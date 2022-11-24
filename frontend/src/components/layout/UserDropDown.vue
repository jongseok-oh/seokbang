<template>
    <b-navbar-nav class="ms-auto" style="margin-right: 100px">
        <template v-if="userinfo && Object.keys(userinfo).length != 0">
            <b-nav-item-dropdown :text="userinfo.userName">
                <b-dropdown-item @click="show">관심 지역 목록</b-dropdown-item>
                <b-dropdown-divider></b-dropdown-divider>
                <b-dropdown-item @click="userDetailForm">회원 정보 수정</b-dropdown-item>
                <b-dropdown-item @click="logout">로그아웃</b-dropdown-item>
            </b-nav-item-dropdown>
        </template>
        <template v-else>
            <b-nav-form>
                <b-button style="font-weight: 600" variant="light" @click="goToLoginForm"
                    >로그인</b-button
                >
            </b-nav-form>
        </template>
        <interest-modal/>
    </b-navbar-nav>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import InterestModal from "./InterestModal.vue";

export default {
    name: "FrontendUserDropDown",
    components: {
        InterestModal,
    },
    data() {
        return {};
    },
    computed: {
        ...mapState("userStore", ["userinfo", "modalToggle"]),
    },
    mounted() {},
    methods: {
        ...mapActions("userStore", ["doLogout"]),
        ...mapMutations("userStore", ["TOGGLE_MODAL"]),
        logout() {
            this.doLogout();
        },
        goToLoginForm() {
            this.$router.push("/loginform");
        },
        userDetailForm() {
            this.$router.push("/usermodifyform");
        },
        show() {
            this.TOGGLE_MODAL();
        },
    },
};
</script>

<style></style>
