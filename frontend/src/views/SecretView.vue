<template>
  <div>
    <SecretDisplay
        v-if="phrase"
        :secretPhrase="decodedPhrase"
        @logout="goBack"
    />
  </div>
</template>

<script>
import SecretDisplay from "../components/SecretDisplay.vue";

export default {
  components: { SecretDisplay },
  data() {
    return {
      phrase: "",
      decodedPhrase: ""
    };
  },
  created() {
    this.phrase = this.$route.params.secretPhrase;

    if (!this.phrase) {
      this.$router.push("/");
    } else {
      // 🔥 ESTA LÍNEA ES LA CLAVE
      this.decodedPhrase = decodeURIComponent(this.phrase);
    }
  },
  methods: {
    goBack() {
      this.$router.push("/");
    }
  }
};
</script>