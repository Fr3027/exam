import Vue from 'vue';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';
import { preset } from 'vue-cli-plugin-vuetify-preset-reply/preset'

Vue.use(Vuetify);

export default new Vuetify({
    preset,
    theme: {
        themes: {
            light: {
                primary: '#f2f2f2',
                secondary: '#424242',
                accent: '#82B1FF',
                error: '#FF5252',
                info: '#2196F3',
                success: '#4CAF50',
                warning: '#FFC107'
            },
        },
    },
});