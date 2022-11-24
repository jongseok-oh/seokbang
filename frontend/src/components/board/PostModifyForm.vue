<template>
  <div class="container" id="postwriteform">
    <b-form-input class="m-1" v-model="post.title" placeholder="제목"></b-form-input>
    <b-form-textarea 
      class="m-1"
      v-model="post.content"
      placeholder="내용"
      rows="20"
      no-resize
      ></b-form-textarea>
    <b-button class="float-end" @click="modifyPostBtn">수정</b-button>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

const boardStore = "boardStore";

export default {
    data() {
        return {
        };
    },
  computed: {
    ...mapState(boardStore, ["post"]),
  },
  methods: {
    ...mapActions(boardStore,["modifyPost"]),
    async modifyPostBtn(){
      await this.modifyPost(this.post);
      this.$router.push({name : "postdetail"});
    },
  },
  created() {
  },
};
</script>

<style scoped>
</style>