<template>
  <div class="container">
    <form @submit.prevent="handleSubmit" class="form">
      <h2>Login</h2>

      <input v-model="correo" type="email" placeholder="Correo" required />
      <input v-model="password" type="password" placeholder="Password" required />

      <div v-if="errorMessage" class="error">
        {{ errorMessage }}
      </div>

      <button type="submit">
        {{ loading ? "Ingresando..." : "Ingresar" }}
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/authService";

export default {
  data() {
    return {
      correo: "",
      password: "",
      loading: false,
      errorMessage: ""
    };
  },
  methods: {
    async handleSubmit() {
      this.loading = true;
      this.errorMessage = "";

      const res = await authService.login(this.correo, this.password);

      if (res.success) {
        this.$emit("login-success", res.secretPhrase);
      } else {
        this.errorMessage = res.message;
      }

      this.loading = false;
    }
  }
};
</script>