/*aqui empieza la estructura visual*/
<template>
  <div class="contenedor-contador">
    <div class="tarjeta">
      <h2>Registro de Actividad</h2>
      <p class="etiqueta">Total de interacciones registradas</p>
      
      <div class="valor">{{ contador }}</div>
      <button @click="incrementar" class="btn-primario">
        Incrementar Valor
      </button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      contador: 0
    };
  },
  methods: {
    incrementar() {
      this.contador++;
    }
  }
};
</script>

<style scoped>
/* Contenedor principal para centrar la tarjeta */
.contenedor-contador {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px;
  font-family: 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  background-color: #f4f4f9;
}

/* Diseño de tarjeta moderna y profesional */
.tarjeta {
  background-color: #ffffff;
  border: 1px solid #eaeaea;
  border-radius: 10px;
  padding: 30px 40px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
  text-align: center;
  min-width: 300px;
}

/* Tipografía elegante */
h2 {
  color: #2c3e50;
  margin: 0 0 8px 0;
  font-size: 22px;
}

.etiqueta {
  color: #7f8c8d;
  font-size: 14px;
  margin-bottom: 25px;
}

/* Número grande y destacado */
.valor {
  font-size: 56px;
  font-weight: bold;
  color: #34495e;
  margin-bottom: 30px;
}

/* Botón con estilo corporativo */
.btn-primario {
  background-color: #42b883; /* Color verde oficial de Vue */
  color: #ffffff;
  border: none;
  padding: 12px 24px;
  font-size: 16px;
  font-weight: bold;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.2s ease, transform 0.1s ease;
  width: 100%;
}

.btn-primario:hover {
  background-color: #33a06f;
}

.btn-primario:active {
  transform: scale(0.98);
}
</style>