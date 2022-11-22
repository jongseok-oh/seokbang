<template>
    <div>
        <template v-if="userinfo && Object.keys(userinfo).length != 0">
            <div class="dropdown">
                <b-dropdown id="dropdown-1" dropleft class="m-2" :text="userinfo.userName">
                    <b-dropdown-item>관심 매물</b-dropdown-item>
                    <b-dropdown-divider></b-dropdown-divider>
                    <b-dropdown-item>회원 정보 수정</b-dropdown-item>
                    <b-dropdown-item @click="logout">로그아웃</b-dropdown-item>
                </b-dropdown>
            </div>
        </template>
        <template v-else>
            <b-button @click="goToLoginForm">Log in</b-button>
        </template>
    </div>
</template>

<script>

import { mapState, mapActions } from "vuex";

export default {
    name: 'FrontendUserDropDown',

    data() {
        return {
        };
    },
    computed: {
        ...mapState("userStore",["userinfo"]),
    },
    watch: {
        userinfo() {
            console.log(this.userinfo);
        }
    },
    created() {
        
    },
    mounted() {
    },
    methods: {
        ...mapActions("userStore",["doLogout"]),
        logout() {
            this.doLogout();
            this.goToLoginForm();
        },
        goToLoginForm() {
            this.$router.push("/loginform");
        }
    },
};
</script>

<style lang="scss" scoped>

</style>