import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

import App from "./App.vue";
import router from "./router";
import axios from "axios";  

axios.defaults.headers.common['Content-Type'] = 'application/json;charset=utf-8'

const pinia = createPinia()
const app = createApp(App);

pinia.use(piniaPluginPersistedstate)
app.use(pinia);
app.use(router);

app.mount("#app");