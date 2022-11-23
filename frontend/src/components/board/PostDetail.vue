<template>
  <div class="container">
    <b-container class="mt-3">
      <b-row class="mb-1">
        <b-col>
          <b-card
            :header-html="`<h3>${post.title}</h3>
            <h6 class='float-end'>${post.postDate}</h6>`"
            class="mb-2"
            border-variant="dark"
            no-body
          >
            <b-card-body>
              <div v-html="`${post.userName}<div class='float-end'>조회수 ${post.hit}</div>`"></div>
              <hr/>
              <div v-html="message"></div>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
      <b-row class="mb-1">
        <b-col class="text-left">
          <b-button variant="outline-dark mx-1" size="sm" @click="moveList">목록</b-button>
        </b-col>
        <b-col class="text-right">
          <b-button variant="outline-danger float-end mx-1" size="sm" @click="clickDelete">글삭제</b-button>
          <b-button variant="outline-primary float-end mx-1" size="sm" @click="moveModifyArticle">글수정</b-button>
          <b-button variant="outline-danger" size="sm" @click="likeBtn">
            <b-icon-heart color="red" v-if="!isLiked"></b-icon-heart>
            <b-icon-heart-fill color="red" v-else></b-icon-heart-fill>
            {{likesCnt}}
          </b-button>
        </b-col>
      </b-row>
    </b-container>
    <reple-list></reple-list>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import RepleList from './RepleList.vue';

const boardStore = "boardStore";

export default {
  components:{
    RepleList
  },
  data() {
      return {
        postNo : Number,
        isLiked : Boolean,
        likesCnt : Number,
      };
  },
  computed: {
    ...mapState(boardStore, ["post"]),
    message() {
      if (this.post.content) return this.post.content.split("\n").join("<br>");
      return "";
    },
  },
  methods: {
    ...mapActions(boardStore, ["getPost", "deletePost", "likePost", "unlikePost"]),
    moveList(){
      this.$router.push({name : "postlist"})
    },
    moveModifyArticle(){
      this.$router.push({name : "postmodifyform"})
    },
    async clickDelete(){
      await this.deletePost(this.post.no);
      this.moveList();
    },
    likeBtn(){
      if(this.isLiked){
        this.likesCnt -= 1;
        this.isLiked = false;
      }
      else{
        this.likesCnt += 1;
        this.isLiked = true;
      }
    },
    async init(){
      await this.getPost(this.postNo);
      this.likesCnt = this.post.likesCnt;
      this.isLiked = this.post.isLiked;
    }
  },
  async destroyed() {
    console.log("destroy!!");
    if(this.isLiked && !this.post.isLiked){
      await this.likePost(this.post.no);
    }
    else if(!this.isLiked && this.post.isLiked){
      await this.unlikePost(this.post.no);
    }
    console.log("destroy end!!");
  },
  mounted() {
    this.postNo = this.$route.params.postNo;
    this.init();
  },
};
</script>

<style scoped>
</style>