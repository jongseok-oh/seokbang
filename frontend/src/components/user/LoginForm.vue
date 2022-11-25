<template>
    <div class="container mt-5">
        <div class="row">
            <div class="col"/>
            <div class="col mb-3">
                <h1 class="text-center login-title mt-3">로그인 해주세요</h1>
                <div class="account-wall mb-3">
                    <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                        alt="">
                    <div class="form-signin" @keyup.enter="login">
                        <input type="text" class="form-control" placeholder="ID" required autofocus v-model="ID">
                        <input type="password" class="form-control" placeholder="Password" required v-model="Password">
                        <div class="mt-5 mb-5">
                            <b-button class="btn btn-lg btn-primary btn-block" @click="login">로그인</b-button>
                            <b-button class="btn btn-lg btn-primary btn-block" variant="success" @click="goToSignupForm">회원가입</b-button>
                        </div>
                        <a href="#">비밀번호 찾기 </a><span class="clearfix"></span>
                    </div>
                </div>
            </div>
            <div class="col"/>
        </div>
    </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
    name: 'FrontendLoginForm',

    data() {
        return {
            ID: "",
            Password:""
        };
    },
    methods: {
        ...mapActions("userStore", ["doLogin"]),
        login() {
            let payload = {
                userId: this.ID,
                password: this.Password
            }
            this.doLogin(payload);
        },
        goToSignupForm() {
            this.$router.push('/signupform');
        }
    },
};
</script>

<style scope>
.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 18px;
    font-weight: 400;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}
</style>