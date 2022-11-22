<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand px-5">
        <img alt="Vue logo" src="@/assets/logo.png" style="height:25px;" />
      </router-link>
      <ul class="navbar-nav me-auto">
        <li class="nav-item mx-2"><router-link to="/dealinfo" class="nav-link">실거래가</router-link></li>
        <li class="nav-item mx-2"><router-link to="/board" class="nav-link">지역별 게시판</router-link></li>
      </ul>
      <user-drop-down/>
    </div>
  </nav>

</template>

<script>
import UserDropDown from "./UserDropDown.vue";

export default {
  name: 'FrontendNavBar',

  components: {
    UserDropDown
  },
  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
};
</script>

<style lang="scss" scoped>

</style>

<style scoped>

ul a{
  border-radius: 10px;
}

ul li{
  margin: 0 5px;
}

ul a.router-link-exact-active {
  color: white;
  background: black;
  font-weight: bold;
}

ul a:hover {
  background: grey;
}
</style>