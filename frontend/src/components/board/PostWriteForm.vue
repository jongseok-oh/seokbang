<template>
  <div class="container" id="postwriteform">
    <b-form-input v-model="post.title" placeholder="제목"></b-form-input>
    <b-form-textarea 
      v-model="post.content"
      placeholder="내용"
      rows="20"
      no-resize
      ></b-form-textarea>
    <b-button class="float-end" @click="onSubmit">등록</b-button>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
export default {
    data() {
        return {
          post : {}
        };
    },
  computed: {
    ...mapState("userStore", ["userNo"]),
  },
  methods: {
    ...mapActions("boardStore",["registPost"]),
    onSubmit(){
      this.registPost(this.post).then(() => {
        console.log(`regist post success`);
        this.clear();
        this.$router.push("/board");
      });
    },
    clear(){
      this.post = {
            userNo : this.userNo,
            gugunCode : "1111000000",
            title : '',
            content : '',
            hit : 0,
            postDate : new Date(),
          }
    }
  },
  created() {
    this.clear();
  },
};
</script>

<style scoped>
</style>