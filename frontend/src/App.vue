<template>
  <div id="app">
    <nav-bar v-if="navFooter"></nav-bar>
    <logo-nav v-if="!navFooter"></logo-nav>
    <router-view></router-view>
    <my-footer v-if="navFooter"/>
  </div>
</template>

<script>
import NavBar from "./components/layout/NavBar.vue";
import MyFooter from "./components/layout/MyFooter.vue";
import LogoNav from "./components/layout/LogoNav.vue";

import store from "@/store";
import {mapState} from "vuex";

export default {
  name: "App",
  components: {
    NavBar,
    MyFooter,
    LogoNav
  },
  computed: {
    ...mapState(['navFooter']),
  },
  created() {
    store.commit('SET_NAV_FOOTER', true)
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
