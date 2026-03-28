<template>
  <div class="success">
    <div class="card">
      <h2>✅ ¡Login Exitoso!</h2>

      <div class="phrase">
        {{ secretPhrase }}
      </div>

      <button @click="logout">Cerrar sesión</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    secretPhrase: String
  },
  methods: {
    logout() {
      this.$emit("logout");
    }
  }
};
</script>