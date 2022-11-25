<template>
    <div>
        <b-row cols="11">
            <b-col sm="10">
                <h2 class="mx-3">{{ this.gugunName }} 게시판</h2>
            </b-col>
            <b-col sm="2" class="m-auto">
                <b-button variant="outline-warning dark" size="md" @click="interestClick">
                    <b-icon-star color="dark" v-if="!tempClicked"></b-icon-star>
                    <b-icon-star-fill color="yellow" v-else></b-icon-star-fill>관심지역</b-button
                >
            </b-col>
        </b-row>
        <hr />
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
    name: "FrontendPostBanner",

    data() {
        return {
            tempClicked: Boolean,
            firstState: Boolean,
        };
    },
    computed: {
        ...mapState("boardStore", ["gugunCode", "gugunName"]),
        ...mapState("userStore", ["interestList", "modalToggle"]),
    },
    created() {
        this.tempClicked = this.interestList.includes(this.gugunCode);
        this.firstState = this.tempClicked;
    },
    watch: {
        gugunCode(newval, oldval) {
            this.applyInterest(oldval);
            this.tempClicked = this.interestList.includes(newval);
            this.firstState = this.tempClicked;
        },
        async modalToggle() {
            console.log(this.firstState);
            console.log(this.tempClicked);
            await this.applyInterest(this.gugunCode);
        }
    },
    methods: {
        ...mapActions("userStore", ["doDeleteInterestArea", "doInsertInterestArea"]),
        interestClick() {
            this.tempClicked ^= true;
        },
        applyInterest(val) {
            if (this.firstState != this.tempClicked) {
                if (!this.tempClicked) {
                    this.doDeleteInterestArea(val);
                } else {
                    this.doInsertInterestArea(val);
                }
                this.firstState = this.tempClicked;
            }
        },
    },
    beforeDestroy() {
        if(this.gugunCode != '99')
            this.applyInterest(this.gugunCode);
    },
};
</script>

<style lang="scss" scoped></style>
