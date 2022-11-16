<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-info text-light text-center">게시글 상세 정보</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="userId">작성자</label></th>
            <td>
              <input
                type="text"
                name="userId"
                id="userId"
                v-model.lazy="post.userId"
                :readonly="post != null && post.userId"
              />
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
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="수정" @click="modifyPost" class="btn btn-warning m-1" />
              <input
                type="button"
                value="삭제"
                @click="removePost"
                class="btn btn-dark m-1"
              />
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
      post: {...this.$store.state.post},
    };
  },
  methods: {
    getPost(no) {
      this.$store.dispatch(Constant.GET_POST, no).then(() => (this.post = {...this.$store.state.post }));
    },
    modifyPost() {
      this.$store.dispatch(Constant.MODIFY_POST, this.post).then(() => {
        this.$store.dispatch(Constant.GET_POST, this.post.no);
        this.goBoard();
      });
    },
    removePost() {
      this.$store.dispatch(Constant.REMOVE_POST, this.post).then(() => {
        this.goBoard();
      });
    },
    goBoard() {
      this.$router.push({name:"board"});
    },
  },
  created() {
    this.getPost(this.$route.params.no);
  },
};
</script>

<style></style>
