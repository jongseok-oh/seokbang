<template>
    <b-row class="m-2">
        <b-card>
            <b-row>거래금액 : {{deal.dealAmount}}만원</b-row>
            <b-row>면적 : {{Math.ceil(deal.area*1000)/1000}}</b-row>
            <b-row>층 : {{deal.floor}}</b-row>
            <b-row>거래일자 : {{deal.dealYear}}. {{deal.dealMonth}}. {{deal.dealDay}}</b-row>
        </b-card>
    </b-row>
</template>

<script>
export default {
    name: "HouseListItem",
    data() {
        return {};
    },
    props: {
        deal: Object,
    },
};
</script>
