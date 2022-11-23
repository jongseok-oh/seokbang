<template>
  <div id="userview">
    <router-view></router-view>
  </div>
</template>

<script>
import store from "@/store";
export default {
  components: {
  },
  created() {
        store.commit('SET_NAV_FOOTER', false)
  },
};
</script>

<style>
#boardview {
  text-align: left;
  margin: 40px;
}
</style>
