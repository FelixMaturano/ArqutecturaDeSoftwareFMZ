<template>
  <div class="contenedor-principal">
    <div class="login-box">
      <h2>Iniciar Sesión</h2>

      <input v-model="usuario" type="text" placeholder="Ingresa tu usuario" />
      <input v-model="password" type="password" placeholder="Ingresa tu contraseña" />

      <button @click="iniciarSesion">Entrar</button>

      <p v-if="mensajeError" class="error">{{ mensajeError }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      usuario: "",
      password: "",
      mensajeError: ""
    };
  },
  methods: {
    iniciarSesion() {
      // Validamos los datos ingresados
      if (this.usuario === "admin" && this.password === "123456") {
        alert("¡Bienvenido al sistema!");
        this.mensajeError = ""; 
        this.usuario = ""; // Limpiamos los campos
        this.password = "";
      } else {
        this.mensajeError = "Usuario o contraseña incorrectos.";
      }
    }
  }
};
</script>

<style scoped>
/* Estilos para centrar y darle forma de tarjeta de Login */
.contenedor-principal {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  font-family: Arial, sans-serif;
  background-color: #f4f4f9;
}

.login-box {
  background: white;
  padding: 30px;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  width: 300px;
}

h2 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

input {
  margin-bottom: 15px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
}

button {
  padding: 10px;
  background-color: #42b883; /* Verde característico de Vue */
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
}

button:hover {
  background-color: #33a06f;
}

.error {
  color: red;
  font-size: 13px;
  text-align: center;
  margin-top: 10px;
}
</style>