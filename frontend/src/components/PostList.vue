<template>
  <div id="board">
    <h2 class="">강남구 게시판</h2>
    <hr/>
    
    <b-button variant="outline-dark" pressed size="sm">전체글</b-button>
    <b-button variant="outline-dark" size="sm">개념글</b-button>
    <b-button variant="outline-dark" size="sm">공지</b-button>
    <hr/>

    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>작성자번호</th>
            <th>제목</th>
            <th>조회수</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <tr v-if="!posts || posts == null || posts.length == 0">
            <td colspan="4">등록된 글 정보가 없습니다.</td>
        </tr>
        <template v-else>
            <tr v-for="(post) in posts" :key="post.no">
            <td>{{ post.userNo }}</td>
            <td>{{ post.title }}</td>
            <td>{{ post.hit }}</td>
            <td>{{ post.postDate }}</td>
            </tr>
        </template>
        </tbody>
    </table>


    <b-button variant="outline-dark" pressed size="sm">전체글</b-button>
    <b-button variant="outline-dark" size="sm">개념글</b-button>
    <b-button variant="outline-dark float-end" @click="moveWriteForm" size="sm">글쓰기</b-button>

    <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        size="sm"
        align="center"
        class="mt-4">
    </b-pagination>
  </div>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters } from "vuex";
export default {
    data() {
        return {
            perPage: 3,
            currentPage: 1,
            gugunCode: "1111000000",
        };
    },
  computed: {
    ...mapGetters(["posts"]),
    rows() {
        return this.posts.length;
    },
  },
  methods: {
    getPosts() {
      this.$store.dispatch(Constant.GET_POSTS, this.gugunCode).then(() => {
        console.log(`get posts success`);
      });
    },
    moveWriteForm() {
      this.$router.push({name : "postwriteform"});
    },
  },
  created() {
    this.getPosts();
  },
};
</script>

<style scoped>
</style>