<template>
  <div class="crud-container">
    <h2>Gestión de Categorías</h2>

    <div class="formulario-panel">
      <input v-model="formulario.name" placeholder="Nombre de la categoría" />
      <input v-model="formulario.description" placeholder="Descripción breve" />
      
      <button :class="formulario.id ? 'btn-actualizar' : 'btn-guardar'" @click="guardarCategoria">
        {{ formulario.id ? 'Actualizar Categoría' : 'Guardar Nueva' }}
      </button>
      <button v-if="formulario.id" class="btn-cancelar" @click="cancelarEdicion">Cancelar</button>
    </div>

    <div class="lista-panel">
      <h3>Lista de Categorías de la Base de Datos</h3>
      <p v-if="mensajeEstado" class="mensaje-estado">{{ mensajeEstado }}</p>
      
      <ul>
        <li v-for="cat in categorias" :key="cat.id" class="item-categoria">
          <div class="info">
            <strong>{{ cat.name }}</strong>
            <span>{{ cat.description }}</span>
          </div>
          <div class="acciones">
            <button class="btn-editar" @click="seleccionarParaEditar(cat)">Editar</button>
            <button class="btn-eliminar" @click="eliminarCategoria(cat.id)">Eliminar</button>
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
      categorias: [],
      formulario: { id: null, name: "", description: "" },
      mensajeEstado: "Cargando datos..."
    };
  },
  
  mounted() {
    this.leerCategorias(); 
  },
  methods: {
    // Función de ayuda para obtener las cabeceras con el Token
    getHeaders() {
      const token = localStorage.getItem("token");
      return {
        "Content-Type": "application/json",
        "Authorization": token ? `Bearer ${token}` : ""
      };
    },

    async leerCategorias() {
      try {
        const res = await fetch("http://localhost:3005/api/v1/categories", {
          method: "GET",
          headers: this.getHeaders()
        });

        if (res.status === 403 || res.status === 401) {
          this.mensajeEstado = "No autorizado. Por favor inicia sesión.";
          this.categorias = [];
          return;
        }

        const data = await res.json();
        this.categorias = data;
        this.mensajeEstado = this.categorias.length === 0 ? "No hay categorías." : "";

      } catch (error) {
        console.error("Error conectando al backend:", error);
        this.mensajeEstado = "Error de conexión con el servidor.";
      }
    },

    async guardarCategoria() {
      if(!this.formulario.name) return alert("El nombre es obligatorio");

      const url = this.formulario.id 
        ? `http://localhost:3005/api/v1/categories/${this.formulario.id}` 
        : "http://localhost:3005/api/v1/categories";                      

      const metodo = this.formulario.id ? "PUT" : "POST";

      try {
        const res = await fetch(url, {
          method: metodo,
          headers: this.getHeaders(),
          body: JSON.stringify({
            name: this.formulario.name,
            description: this.formulario.description
          })
        });

        if (res.status === 403 || res.status === 401) {
          alert("Tu sesión ha expirado o no estás autorizado.");
          return;
        }

        this.cancelarEdicion();
        this.leerCategorias(); 
      } catch (error) {
        console.error("Error al guardar:", error);
      }
    },

    async eliminarCategoria(id) {
      if(confirm("¿Seguro que deseas borrar esta categoría?")) {
        try {
          const res = await fetch(`http://localhost/api/v1/categories/${id}`, { 
            method: "DELETE",
            headers: this.getHeaders()
          });

          if (res.status === 403 || res.status === 401) {
            alert("No tienes permiso para realizar esta acción.");
            return;
          }

          this.leerCategorias(); 
        } catch (error) {
          console.error("Error al eliminar:", error);
        }
      }
    },

    seleccionarParaEditar(categoria) {
      this.formulario.id = categoria.id;
      this.formulario.name = categoria.name;
      this.formulario.description = categoria.description;
    },

    cancelarEdicion() {
      this.formulario = { id: null, name: "", description: "" };
    }
  }
};
</script>

<style scoped>
.crud-container { max-width: 600px; margin: 40px auto; font-family: Arial, sans-serif; color: #333; }
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
.item-categoria { display: flex; justify-content: space-between; align-items: center; background: white; padding: 15px; border: 1px solid #ddd; margin-bottom: 10px; border-radius: 6px; }
.info { display: flex; flex-direction: column; }
.info strong { font-size: 16px; color: #2c3e50; }
.info span { font-size: 14px; color: #7f8c8d; }
.acciones { display: flex; gap: 8px; }
.mensaje-estado { text-align: center; color: #7f8c8d; font-style: italic; margin-bottom: 15px;}
</style>