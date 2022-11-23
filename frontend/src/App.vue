<template>
    <div id="app">
        <nav-bar v-if="navFooter"></nav-bar>
        <logo-nav v-if="!navFooter"></logo-nav>
        <div class="mb-5">
            <router-view></router-view>
        </div>
        <my-footer v-if="navFooter" />
    </div>
</template>

<script>
import NavBar from "./components/layout/NavBar.vue";
import MyFooter from "./components/layout/MyFooter.vue";
import LogoNav from "./components/layout/LogoNav.vue";

import store from "@/store";
import { mapState } from "vuex";

export default {
    name: "App",
    components: {
        NavBar,
        MyFooter,
        LogoNav,
    },
    computed: {
        ...mapState(["navFooter"]),
    },
    watch: {
        $route(to, from) {
            //console.log(to);
            //console.log(from);
            if (to.path !== from.path) {
                if (to.matched[0].path == '/user') {
                    store.commit("SET_NAV_FOOTER", false);
                } else {
                    store.commit("SET_NAV_FOOTER", true);
                }
            }
        }
    }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');

#app {
  font-family: 'Gowun Batang', serif;
  font-weight: 800;
  text-align: center;
  color: #2c3e50;
}
</style>
