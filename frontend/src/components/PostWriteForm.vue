<template>
  <div class="container m-3" id="postwriteform">
    <b-form-input v-model="post.title" placeholder="제목"></b-form-input>
    <b-form-textarea 
      v-model="post.content"
      placeholder="내용"
      rows="20"
      no-resize
      ></b-form-textarea>
    <b-button class="float-end" @click="registPost">등록</b-button>
  </div>
</template>

<script>
import Constant from "@/common/Constant.js";
export default {
    data() {
        return {
          gugunCode : "1111000000",
          post : {
            userNo : this.$store.getters.userNo,
            gugunCode : "1111000000",
            title : '',
            content : '',
            hit : 0,
            postDate : new Date(),
          }
        };
    },
  computed: {
  },
  methods: {
    registPost(){
      this.$store.dispatch(Constant.REGIST_POST, this.post).then(() => {
        console.log(`regist post success`);
        this.clear();
        this.$router.push("/board");
      });
    },
    clear() {
      this.post = {
            userNo : this.$store.getters.userNo,
            gugunCode : "1111000000",
            title : '',
            content : '',
            hit : 0,
            postDate : new Date(),
          }
    },
  },
  created() {
  },
};
</script>

<style scoped>
</style>