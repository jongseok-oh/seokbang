<template>
    <b-navbar-nav class="ms-auto" style="margin-right:100px">
        <template v-if="userinfo && Object.keys(userinfo).length != 0">
            <b-nav-item-dropdown :text="userinfo.userName">
                <b-dropdown-item>관심 매물</b-dropdown-item>
                <b-dropdown-divider></b-dropdown-divider>
                <b-dropdown-item @click="userDetailForm">회원 정보 수정</b-dropdown-item>
                <b-dropdown-item @click="logout">로그아웃</b-dropdown-item>
            </b-nav-item-dropdown>
        </template>
        <template v-else>
            <b-nav-form>
                <b-button style="font-weight:600" variant="light" @click="goToLoginForm">로그인</b-button>
            </b-nav-form>
        </template>
    </b-navbar-nav>
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
    mounted() {
    },
    methods: {
        ...mapActions("userStore",["doLogout"]),
        logout() {
            this.doLogout();
        },
        goToLoginForm() {
            this.$router.push("/loginform");
        },
        userDetailForm() {
            this.$router.push("/usermodifyform");
        }
    },
};
</script>

<style>

</style>