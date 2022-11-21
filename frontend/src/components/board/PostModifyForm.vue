<template>
  <div class="container" id="postwriteform">
    <b-form-input v-model="post.title" placeholder="제목"></b-form-input>
    <b-form-textarea 
      v-model="post.content"
      placeholder="내용"
      rows="20"
      no-resize
      ></b-form-textarea>
    <b-button class="float-end" @click="onSubmit">수정</b-button>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
export default {
    data() {
        return {
        };
    },
  computed: {
    ...mapState("boardStore", ["post"]),
  },
  methods: {
    ...mapActions("boardStore",["modifyPost"]),
    onSubmit(){
      this.modifyPost(this.post).then(() => {
        console.log(`modify post success`);
        this.$router.replace({
          name: "postdetail",
          params: { postNo: this.post.no },
        });
      });
    },
  },
  created() {
  },
};
</script>

<style scoped>
</style>