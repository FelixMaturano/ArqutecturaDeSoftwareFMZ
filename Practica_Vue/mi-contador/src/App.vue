<template>
  <div id="app">
    <header class="navegacion">
      <h1>Mi Aplicación Vue</h1>
      <div class="botones-nav">
        
        <!-- SOLO se muestra si NO hay sesión iniciada -->
        <button 
          v-if="!tokenExiste"
          @click="vistaActual = 'Login'" 
          :class="{ activo: vistaActual === 'Login' }"
        >
          Iniciar Sesión
        </button>

        <!-- SOLO se muestran si YA HAY sesión iniciada -->
        <button 
          v-if="tokenExiste"
          @click="vistaActual = 'Categorias'" 
          :class="{ activo: vistaActual === 'Categorias' }"
        >
          Gestión de Categorías
        </button>

        <!-- NUEVO BOTÓN PARA ITEMS -->
        <button 
          v-if="tokenExiste"
          @click="vistaActual = 'Items'" 
          :class="{ activo: vistaActual === 'Items' }"
        >
          Gestión de Ítems
        </button>

        <button 
          v-if="tokenExiste"
          @click="vistaActual = 'Incremento'" 
          :class="{ activo: vistaActual === 'Incremento' }"
        >
          Contador
        </button>

        <!-- Botón para cerrar sesión -->
        <button v-if="tokenExiste" @click="cerrarSesion" class="btn-salir">
          Salir
        </button>
      </div>
    </header>

    <main class="contenido-dinamico">
      <!-- Escucha el evento del login para cambiar la vista -->
      <component :is="vistaActual" @login-exitoso="irACategorias"></component>
    </main>
  </div>
</template>

<script>
import Incremento from './Incremento.vue';
import Login from './Login1.vue'; 
import Categorias from './Categorias1.vue';
// IMPORTAMOS EL NUEVO COMPONENTE
import Items from './Items1.vue'; 

export default {
  name: 'App',
  components: {
    Incremento,
    Login,
    Categorias,
    Items // LO REGISTRAMOS AQUÍ
  },
  data() {
    return {
      vistaActual: 'Login', 
      tokenExiste: false
    };
  },
  mounted() {
    this.verificarToken();
    if (this.tokenExiste) {
      this.vistaActual = 'Categorias';
    } else {
      this.vistaActual = 'Login';
    }
  },
  methods: {
    irACategorias() {
      this.verificarToken();
      this.vistaActual = 'Categorias';
    },
    verificarToken() {
      this.tokenExiste = !!localStorage.getItem('token');
    },
    cerrarSesion() {
      localStorage.removeItem('token');
      this.verificarToken();
      this.vistaActual = 'Login';
    }
  }
};
</script>

<style scoped>
/* Los estilos se mantienen exactamente igual */
#app { font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; color: #2c3e50; background-color: #f4f4f9; min-height: 100vh; margin: 0; padding: 0; }
.navegacion { background-color: #ffffff; padding: 20px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); text-align: center; }
.navegacion h1 { margin: 0 0 15px 0; color: #42b883; font-size: 24px; }
.botones-nav { display: flex; justify-content: center; gap: 15px; }
.botones-nav button { padding: 10px 20px; font-size: 16px; font-weight: bold; border: 2px solid #42b883; background-color: transparent; color: #42b883; border-radius: 6px; cursor: pointer; transition: all 0.3s ease; }
.botones-nav button:hover { background-color: #e8f5ef; }
.botones-nav button.activo { background-color: #42b883; color: white; }
.botones-nav button.btn-salir { border-color: #e74c3c; color: #e74c3c; }
.botones-nav button.btn-salir:hover { background-color: #fceceb; }
.contenido-dinamico { padding: 20px; }
</style>