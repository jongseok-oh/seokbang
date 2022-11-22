<template>
  <div id="board">
    <h2 class="">강남구 게시판</h2>
    <hr/>
    
    <b-button variant="outline-dark" :pressed.sync="allToggle" size="sm" @click="allPosts">전체글</b-button>
    <b-button variant="outline-dark" :pressed.sync="popularToggle" size="sm" @click="popularPosts">인기글</b-button>
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
        <tr v-if="!postList || postList == null || postList.length == 0">
            <td colspan="4">등록된 글 정보가 없습니다.</td>
        </tr>
        <template v-else>
            <tr :key="post.no" v-for="post in postList" @click="movePostDetail(post.no)">
            <td>{{ post.userNo }}</td>
            <td>{{ post.title }}</td>
            <td>{{ post.hit }}</td>
            <td>{{ post.postDate }}</td>
            </tr>
        </template>
        </tbody>
    </table>

    <b-button variant="outline-dark" :pressed.sync="allToggle" size="sm" @click="allPosts">전체글</b-button>
    <b-button variant="outline-dark" :pressed.sync="popularToggle" size="sm" @click="popularPosts">인기글</b-button>
    <b-button variant="outline-dark float-end" @click="moveWriteForm" size="sm">글쓰기</b-button>

    <b-pagination
        v-model="currentPage"
        :total-rows="10"
        :per-page="perPage"
        size="sm"
        align="center"
        class="mt-4">
    </b-pagination>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const boardStore = "boardStore";

export default {
    data() {
        return {
            perPage: 10,
            currentPage: 1,
            gugunCode: "1111000000",
            postList: this.posts,
            allToggle: true,
            popularToggle: false,
        };
    },
  computed: {
    ...mapState(boardStore, ["posts"]),
  },
  methods: {
    ...mapActions(boardStore,["getPosts","hit"]),
    async movePostDetail(no){
      await this.hit(no);
      this.$router.push({
        name: "postdetail",
        params: { postNo: no },
      });
    },
    moveWriteForm() {
      this.$router.push({name : "postwriteform"});
    },
    allPosts(){
      this.allToggle = true;
      this.popularToggle = false;
      this.postList = this.posts;
    },
    popularPosts(){
      this.allToggle = false;
      this.popularToggle = true;
      this.postList = this.posts.filter(post => post.hit >= 5);
    },
  },
  async mounted() {
    await this.getPosts(this.gugunCode);
    this.allPosts();
  },
};
</script>

<style scoped>
</style>