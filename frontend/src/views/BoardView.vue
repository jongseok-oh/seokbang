<template>
  <div class="container" id="boardView">
    <h1>QnA 게시판</h1>
    <board-list></board-list>
    <router-view></router-view>
  </div>
</template>

<script>
import BoardList from "@/components/BoardList.vue";

export default {
  components: {
    BoardList,
  },
};
</script>

<style></style>
