import { createApp } from "vue";
import LoginView from "./views/LoginView.vue";
import router from "./router";

createApp(LoginView).use(router).mount("#app");