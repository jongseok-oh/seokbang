<template>
  <b-navbar variant="light">
    <b-navbar-brand>
      <div id="seokbang-logo">
        <router-link to="/" class="navbar-brand px-2">
          <img alt="logo" src="@/assets/logo.png" style="height:40px" />
          석 방
        </router-link>
      </div>
    </b-navbar-brand>
    <b-navbar-nav>
      <b-nav-item to="/dealinfo">실거래가</b-nav-item>
      <b-nav-item to="/board">지역별 게시판</b-nav-item>
      <b-nav-item-dropdown text="지역별 게시판" dropright >
        <b-dropdown-item>강원도</b-dropdown-item>
        <b-dropdown-item>경기도</b-dropdown-item>
        <b-dropdown-item>경상남도</b-dropdown-item>
        <b-dropdown-item>경상북도</b-dropdown-item>
        <b-dropdown-item>광주광역시</b-dropdown-item>
        <b-dropdown-item>대구광역시</b-dropdown-item>
        <b-dropdown-item>대전광역시</b-dropdown-item>
        <b-dropdown-item>부산광역시</b-dropdown-item>
        <b-dropdown-item>서울특별시</b-dropdown-item>
        <b-dropdown-item>세종특별자치시</b-dropdown-item>
        <b-dropdown-item>울산광역시</b-dropdown-item>
        <b-dropdown-item>인천광역시</b-dropdown-item>
        <b-dropdown-item>전라남도</b-dropdown-item>
        <b-dropdown-item>전라북도</b-dropdown-item>
        <b-dropdown-item>제주특별자치도</b-dropdown-item>
        <b-dropdown-item>충청남도</b-dropdown-item>
        <b-dropdown-item>충청북도</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-navbar-nav>
    <user-drop-down/>
  </b-navbar>
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

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');


ul li{
  margin: 0 5px;
}

ul .nav-link{
  border-radius: 10px;
}

.nav-link:hover {
  background: grey;
}

ul li a.router-link-exact-active {
  color: white;
  background: black;
  font-weight: bold;
}

#seokbang-logo {
  border-radius: 10px;
  padding:5px 5px;
  font-family: 'Hi Melody', cursive;
  font-weight: bold;
  font-size: x-large;
  width: 150px
}

</style>