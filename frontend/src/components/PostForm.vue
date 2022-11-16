<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-danger text-light text-center">QnA 작성</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="userId">작성자</label></th>
            <td>
              <input type="text" name="userId" v-model.lazy="post.userId" />
            </td>
          </tr>
          <tr>
            <th><label for="title">제목</label></th>
            <td>
              <input type="text" name="title" id="title" v-model.lazy="post.title" />
            </td>
          </tr>
          <tr>
            <th><label for="content">내용</label></th>
            <td>
              <input type="text" name="content" id="content" v-model.lazy="post.content" />
            </td>
          </tr>
          <tr>
            <th><label for="boardNo">게시판 번호</label></th>
            <td>
              <input type="text" name="boardNo" id="boardNo" v-model.lazy="post.boardNo" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="등록" @click="registerPost" class="btn btn-warning m-1" />
              <input type="reset" value="취소" @click="goBoard" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<script>
import Constant from "@/common/Constant.js";
export default {
  data() {
    return {
      post: {},
    };
  },
  methods: {
    registerPost() {
      this.$store.dispatch(Constant.REGISTER_POST, this.post).then(() => {
        console.log(`registerPost success`);
        // this.clear();
        this.$router.push({name:"board"});
      });
    },
    goBoard(){
      this.$router.push({name:"board"});
    },
    clear() {
      this.post = {};
    },
  },
  created() {
    console.log("Post created..");
  },
};
</script>

<style></style>
