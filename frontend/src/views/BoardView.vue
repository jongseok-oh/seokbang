<template>
  <div id="boardview">
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

<style>
#boardview {
  text-align: left;
}
</style>
