<template>
  <div id="app">
    <header class="navegacion">
      <h1>Mi Aplicación Vue</h1>
      <div class="botones-nav">
        <button 
          @click="vistaActual = 'Incremento'" 
          :class="{ activo: vistaActual === 'Incremento' }"
        >
          Contador
        </button>
        
        <button 
          @click="vistaActual = 'Login'" 
          :class="{ activo: vistaActual === 'Login' }"
        >
          Iniciar Sesión
        </button>
        
        <button 
          @click="vistaActual = 'Categorias'" 
          :class="{ activo: vistaActual === 'Categorias' }"
        >
          Gestión de Categorías
        </button>
      </div>
    </header>

    <main class="contenido-dinamico">
      <component :is="vistaActual"></component>
    </main>
  </div>
</template>

<script>
// 1. Importamos los tres componentes que creaste
// (Asegúrate de que la ruta coincida con la ubicación de tus archivos)
import Incremento from './Incremento.vue';
import Login from './Login.vue';
import Categorias from './Categorias.vue';

export default {
  name: 'App',
  // 2. Registramos los componentes para poder usarlos
  components: {
    Incremento,
    Login,
    Categorias
  },
  data() {
    return {
      // 3. Definimos qué componente se mostrará por defecto al abrir la app
      vistaActual: 'Incremento' 
    };
  }
};
</script>

<style scoped>
/* Estilos generales para App.vue */
#app {
  font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  color: #2c3e50;
  background-color: #f4f4f9;
  min-height: 100vh;
  margin: 0;
  padding: 0;
}

/* Estilo para la barra de navegación superior */
.navegacion {
  background-color: #ffffff;
  padding: 20px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.navegacion h1 {
  margin: 0 0 15px 0;
  color: #42b883; /* Verde Vue */
  font-size: 24px;
}

.botones-nav {
  display: flex;
  justify-content: center;
  gap: 15px;
}

/* Estilo de los botones del menú */
.botones-nav button {
  padding: 10px 20px;
  font-size: 16px;
  font-weight: bold;
  border: 2px solid #42b883;
  background-color: transparent;
  color: #42b883;
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.botones-nav button:hover {
  background-color: #e8f5ef;
}

/* Estilo para el botón que está seleccionado actualmente */
.botones-nav button.activo {
  background-color: #42b883;
  color: white;
}

/* Contenedor donde se cargan los componentes */
.contenido-dinamico {
  padding: 20px;
}
</style>