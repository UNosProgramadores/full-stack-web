<template>
  <LoginForm @login-success="goToSecret" />
</template>

<script>
import LoginForm from "../components/LoginForm.vue";

export default {
  components: { LoginForm },
  methods: {
    goToSecret(phrase) {
      this.$router.push(`/secret/${encodeURIComponent(phrase)}`);
    }
  }
};
</script>