<template>
    <div id="app">
        <nav-bar v-if="navFooter"></nav-bar>
        <logo-nav v-if="!navFooter"></logo-nav>
        <router-view></router-view>
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
    created() {
        //console.log("App created..");
        store.commit("SET_NAV_FOOTER", true);
    },
    destroyed() {
        //alert("App destroyed..");
    },
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
