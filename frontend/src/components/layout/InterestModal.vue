<template>
    <div>
        <b-modal id="modal-1" title="관심지역 목록">
            <template v-if="!interestList || interestList.length == 0">
                <b-alert show>관심지역이 없습니다.</b-alert>
            </template>
            <template v-else>
                <template v-for="gugun in guguns">
                    <interest-list-item
                        :key="gugun.value"
                        v-if="gugun.value != null && interestList.includes(gugun.value)"
                        :interest="gugun"
                        @modalClose="modalClose"
                    />
                </template>
            </template>
        </b-modal>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import InterestListItem from "./InterestLIstItem.vue";

export default {
    name: "FrontendInterestModal",
    components: {
        InterestListItem,
    },
    data() {
        return {};
    },
    watch: {
        modalToggle() {
            //console.log(this.guguns);
            //console.log("show modal");
            this.getInterestAreas();
            this.$bvModal.show("modal-1");
        },
    },
    computed: {
        ...mapState("houseStore", ["guguns"]),
        ...mapState("userStore", ["interestList", "modalToggle"]),
    },
    methods: {
        ...mapActions("userStore", ["getInterestAreas"]),
        modalClose() {
            //console.log("close!");
            this.$bvModal.hide("modal-1");
        },
    },
};
</script>

<style lang="scss" scoped></style>
