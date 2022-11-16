<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">게시글 목록</h2>
    </div>
    <div class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="!posts || posts == null || posts.length == 0">
            <td colspan="3">등록된 글 정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr v-for="post in posts" :key=post.no @click="postDetail(post.no)">
              <td>{{ post.no}}</td>
              <td>{{ post.title }}</td>
              <td>{{ post.userId }}</td>
            </tr>
          </template>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="4">
              <div class="btn btn-success text-center" @click="changeForm">등록</div>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<script>
import Constant from "@/common/Constant.js";
import {mapGetters, mapActions} from 'vuex';

export default {
  computed: mapGetters(["posts"]),
  methods: {
    ...mapActions([Constant.GET_POSTS]),
    postDetail(no) {
      this.$router.push({path: `/post/detail/${no}`, params: {no:`${no}`}});
    },
    changeForm() {
      this.$router.push("/post/regForm");
    },
  },
  created() {
    this.getPosts();
  },
  watch: {
    $route(to) {
      if (to.path == "/post") {
        this.getPosts();
      }
    },
  },
};
</script>

<style scoped></style>
