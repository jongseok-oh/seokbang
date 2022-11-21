<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글보기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${post.no}.
          ${post.title} [${post.hit}]</h3><div><h6>${post.userNo}</div><div>${post.postDate}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="moveList">목록</b-button>
      </b-col>
      <b-col class="text-right">
        <b-button variant="outline-danger float-end" size="sm" @click="deletePost(post.no, moveList())">글삭제</b-button>
        <b-button variant="outline-info float-end" size="sm" @click="moveModifyArticle">글수정</b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions } from "vuex";

const boardStore = "boardStore";

export default {
    data() {
        return {
        };
    },
  computed: {
    ...mapGetters(boardStore, ["post"]),
    message() {
      if (this.post.content) return this.post.content.split("\n").join("<br>");
      return "";
    },
  },
  methods: {
    ...mapActions(boardStore, [Constant.GET_POST, "deletePost"]),
    moveList(){
      this.$router.replace({name : "postlist"})
    },
    moveModifyArticle(){
      this.$router.replace({name : "postmodifyform"})
    },
  },
  mounted() {
    this.getPost(this.$route.params.postNo);
  },
};
</script>

<style scoped>
</style>