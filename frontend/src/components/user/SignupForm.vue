<template>
    <div class="container">
        <div class="row">
            <div class="col"/>
            <div class="col">
                <h1 class="text-center login-title">로그인 해주세요</h1>
                <div class="account-wall">
                    <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                        alt="">
                    <form class="form-signin">
                        <input type="text" class="form-control" placeholder="Email" required autofocus>
                        <input type="password" class="form-control" placeholder="Password" required>
                        <button class="btn btn-lg btn-primary btn-block" >로그인</button>
                        <br><br>
                        <a href="#">비밀번호 찾기 </a><span class="clearfix"></span>
                    </form>
                </div>
                <router-link to="../signupform">Create an account </router-link>
            </div>
            <div class="col"/>
        </div>
    </div>
</template>

<script>
export default {
    name: 'FrontendSignUpForm',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>