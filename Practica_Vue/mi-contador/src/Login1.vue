<template>
  <div class="contenedor-principal">
    <div class="login-box">
      <h2>Iniciar Sesión</h2>

      <!-- Cambié el placeholder para que quede claro que ahora pide el Email -->
      <input v-model="email" type="email" placeholder="Ingresa tu correo (email)" />
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
      email: "",
      password: "",
      mensajeError: ""
    };
  },
  methods: {
    async iniciarSesion() {
      if (!this.email || !this.password) {
        this.mensajeError = "Por favor, completa todos los campos.";
        return;
      }

      try {
        // Petición real a tu microservicio de Usuarios
        const res = await fetch("http://localhost/api/v1/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            email: this.email,
            password: this.password
          })
        });

        // Si el backend responde con error 404 o 401
        if (!res.ok) {
          throw new Error("Usuario o contraseña incorrectos.");
        }

        const data = await res.json();

        // Verificamos si el backend nos devolvió el token
        if (data.auth && data.token) {
          // Guardamos el token en la memoria del navegador
          localStorage.setItem("token", data.token);
          
          alert("¡Bienvenido al sistema!");
          this.mensajeError = ""; 
          this.email = ""; 
          this.password = "";

          // Le avisamos a App.vue que el login fue un éxito para que cambie de vista
          this.$emit("login-exitoso");
        } else {
          this.mensajeError = "Error al obtener los datos de acceso.";
        }

      } catch (error) {
        this.mensajeError = error.message || "Error al conectar con el servidor.";
      }
    }
  }
};
</script>

<style scoped>
/* Estilos sin modificar */
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
  background-color: #42b883;
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