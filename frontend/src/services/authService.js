import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8000/api"
});

export default {
    async login(correo, password) {
        try {
            const response = await api.post("/login", { correo, password });
            return response.data;
        } catch (error) {
            return {
                success: false,
                message: "Error de conexión"
            };
        }
    }
};