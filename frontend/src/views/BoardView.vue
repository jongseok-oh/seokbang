<template>
  <div id="houseitemview">
    <post-list></post-list>
    <router-view></router-view>
  </div>
</template>

<script>
import PostList from "@/components/PostList.vue";

export default {
  components: {
    PostList,
  },
};
</script>

<style></style>
