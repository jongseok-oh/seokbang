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
      <b-nav-item @click="moveNotice">공지사항</b-nav-item>
      <b-nav-item to="/dealinfo">실거래가</b-nav-item>
      <b-nav-item-dropdown text="지역별 게시판" dropright >
        <template v-for="gugun in guguns">
          <b-dropdown-item :key="gugun.value" v-if="gugun.value != null" @click="moveBoard(gugun.value, gugun.text)">{{gugun.text}}</b-dropdown-item>
        </template>
      </b-nav-item-dropdown>
    </b-navbar-nav>
    <user-drop-down/>
  </b-navbar>
</template>

<script>
import { mapActions, mapMutations, mapState } from "vuex";
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
  computed:{
    ...mapState("houseStore", ["guguns"])
  },
  methods: {
    ...mapActions("houseStore", ["getGugun"]),
    ...mapActions("boardStore", ["getPosts"]),
    ...mapMutations("houseStore", ["CLEAR_GUGUN_LIST"]),
    ...mapMutations("boardStore", ["setGugunCode", "setGugunName"]),
    moveBoard(gugunCode, gugunName){
      this.setGugunCode(gugunCode);
      this.setGugunName(gugunName);
      this.$router.push({name : "postlist"});
    },
    moveNotice(){
      this.setGugunCode('99');
      this.$router.push({name : "notice"});
    }
  },
  mounted() {
    this.CLEAR_GUGUN_LIST();
    this.getGugun("11");
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