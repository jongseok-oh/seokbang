<template>
  <div id="app">
    <nav-bar></nav-bar>
    <router-view></router-view>
    <my-footer />
  </div>
</template>

<script>
import NavBar from "./components/layout/NavBar.vue";
import MyFooter from "./components/layout/MyFooter.vue";
export default {
  name: "App",
  components: {
    NavBar,
    MyFooter,
  },
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
