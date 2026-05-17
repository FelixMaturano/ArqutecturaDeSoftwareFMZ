<template>
  <div class="crud-container">
    <h2>Gestión de Ítems (Productos)</h2>

    <div class="formulario-panel">
      <!-- Usamos type="number" para el ID de categoría y el precio -->
      <input v-model="formulario.categoryid" type="number" placeholder="ID de la Categoría" />
      <input v-model="formulario.name" type="text" placeholder="Nombre del Ítem" />
      <input v-model="formulario.description" type="text" placeholder="Descripción breve" />
      <input v-model="formulario.price" type="number" placeholder="Precio ($)" />
      
      <button :class="formulario.id ? 'btn-actualizar' : 'btn-guardar'" @click="guardarItem">
        {{ formulario.id ? 'Actualizar Ítem' : 'Guardar Nuevo' }}
      </button>
      <button v-if="formulario.id" class="btn-cancelar" @click="cancelarEdicion">Cancelar</button>
    </div>

    <div class="lista-panel">
      <h3>Lista de Ítems en la Base de Datos</h3>
      <p v-if="mensajeEstado" class="mensaje-estado">{{ mensajeEstado }}</p>
      
      <ul>
        <li v-for="item in items" :key="item.id" class="item-producto">
          <div class="info">
            <strong>{{ item.name }}</strong> - <span class="precio">${{ item.price }}</span>
            <span>{{ item.description }}</span>
            <small>Categoría ID: {{ item.categoryid }}</small>
          </div>
          <div class="acciones">
            <button class="btn-editar" @click="seleccionarParaEditar(item)">Editar</button>
            <button class="btn-eliminar" @click="eliminarItem(item.id)">Eliminar</button>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [],
      formulario: { id: null, categoryid: "", name: "", description: "", price: "" },
      mensajeEstado: "Cargando datos..."
    };
  },
  
  mounted() {
    this.leerItems(); 
  },
  methods: {
    getHeaders() {
      const token = localStorage.getItem("token");
      return {
        "Content-Type": "application/json",
        "Authorization": token ? `Bearer ${token}` : ""
      };
    },

    async leerItems() {
      try {
        // MUY IMPORTANTE: Apunta al puerto 3002 de tu serviceItems
        const res = await fetch("http://localhost:3002/api/v1/items", {
          method: "GET",
          headers: this.getHeaders()
        });

        if (res.status === 403 || res.status === 401) {
          this.mensajeEstado = "No autorizado. Por favor inicia sesión.";
          this.items = [];
          return;
        }

        const data = await res.json();
        this.items = data;
        this.mensajeEstado = this.items.length === 0 ? "No hay ítems registrados." : "";

      } catch (error) {
        console.error("Error conectando al backend de ítems:", error);
        this.mensajeEstado = "Error de conexión con el servidor.";
      }
    },

    async guardarItem() {
      if(!this.formulario.name || !this.formulario.price || !this.formulario.categoryid) {
        return alert("El nombre, precio y categoría son obligatorios");
      }

      const url = this.formulario.id 
        ? `http://localhost:3002/api/v1/items/${this.formulario.id}` 
        : "http://localhost:3002/api/v1/items";                      

      const metodo = this.formulario.id ? "PUT" : "POST";

      try {
        const res = await fetch(url, {
          method: metodo,
          headers: this.getHeaders(),
          body: JSON.stringify({
            categoryid: this.formulario.categoryid,
            name: this.formulario.name,
            description: this.formulario.description,
            price: this.formulario.price
          })
        });

        if (res.status === 403 || res.status === 401) {
          alert("Tu sesión ha expirado o no estás autorizado.");
          return;
        }

        this.cancelarEdicion();
        this.leerItems(); 
      } catch (error) {
        console.error("Error al guardar:", error);
      }
    },

    async eliminarItem(id) {
      if(confirm("¿Seguro que deseas borrar este ítem?")) {
        try {
          const res = await fetch(`http://localhost/api/v1/items/${id}`, { 
            method: "DELETE",
            headers: this.getHeaders()
          });

          if (res.status === 403 || res.status === 401) {
            alert("No tienes permiso para realizar esta acción.");
            return;
          }

          this.leerItems(); 
        } catch (error) {
          console.error("Error al eliminar:", error);
        }
      }
    },

    seleccionarParaEditar(item) {
      this.formulario.id = item.id;
      this.formulario.categoryid = item.categoryid;
      this.formulario.name = item.name;
      this.formulario.description = item.description;
      this.formulario.price = item.price;
    },

    cancelarEdicion() {
      this.formulario = { id: null, categoryid: "", name: "", description: "", price: "" };
    }
  }
};
</script>

<style scoped>
.crud-container { max-width: 700px; margin: 40px auto; font-family: Arial, sans-serif; color: #333; }
h2, h3 { text-align: center; color: #2c3e50; }
.formulario-panel { display: flex; flex-wrap: wrap; gap: 10px; background: #f8f9fa; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); margin-bottom: 20px; }
input { flex: 1; min-width: 150px; padding: 10px; border: 1px solid #ccc; border-radius: 4px; }
button { padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; color: white; font-weight: bold; }
.btn-guardar { background-color: #42b883; } 
.btn-actualizar { background-color: #f39c12; } 
.btn-cancelar { background-color: #95a5a6; } 
.btn-editar { background-color: #3498db; padding: 6px 12px; } 
.btn-eliminar { background-color: #e74c3c; padding: 6px 12px; } 
ul { list-style-type: none; padding: 0; }
.item-producto { display: flex; justify-content: space-between; align-items: center; background: white; padding: 15px; border: 1px solid #ddd; margin-bottom: 10px; border-radius: 6px; }
.info { display: flex; flex-direction: column; }
.info strong { font-size: 16px; color: #2c3e50; }
.info span { font-size: 14px; color: #7f8c8d; }
.info small { font-size: 12px; color: #bdc3c7; margin-top: 4px;}
.precio { color: #27ae60; font-weight: bold; }
.acciones { display: flex; gap: 8px; }
.mensaje-estado { text-align: center; color: #7f8c8d; font-style: italic; margin-bottom: 15px;}
</style>