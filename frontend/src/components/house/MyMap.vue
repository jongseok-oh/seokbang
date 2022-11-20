<template>
  <div>
    <div id="map" class = "mb-3" style="width: 100%; height: 90vh"></div>
  </div>
</template>

<script>
import { mapState, mapActions ,mapMutations } from "vuex";

let mapLevel = 6;
let houseStore = "houseStore";

export default {
  data() {
    return {
      map: "",
      mapContainer: {},
      markers:[],
      lat: "",
      lng: "",
      aptObj:null
    };
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
  },
  watch: {
    houses() {
      //console.log("houses change");
      this.calcenterloc();
      this.removeMarker();
      this.movemap();
      this.addMarker();
      this.CLEAR_DEAL_HOUSE_LIST();
    },
    aptObj() {
      //console.log(this.aptObj);
      this.getHouseDealList(this.aptObj);
    }
  },
  methods: {
    ...mapMutations(houseStore, ["SET_DETAIL_HOUSE", "SET_APT_CODE","CLEAR_DEAL_HOUSE_LIST"]),
    ...mapActions(houseStore,["getHouseDealList"]),
    initMap() {
      //console.log("initmap start");
      if(this.mapContainer == null)
        this.mapContainer = document.getElementById("map");

      const mapOption = {
        center: new kakao.maps.LatLng(37.56666, 126.978),
        level: mapLevel,
      };
      this.map = new kakao.maps.Map(this.mapContainer, mapOption);
      //console.log("initmap end");
      this.CLEAR_DEAL_HOUSE_LIST();
    },
    calcenterloc() {
      //console.log("calc center start");
      let latSum = 0, lngSum = 0;
      this.houses.forEach(loc => {
        latSum += Number(loc["lat"]);
        lngSum += Number(loc["lng"]);
      });
      this.lat = latSum / this.houses.length;
      this.lng = lngSum / this.houses.length;
      //console.log("lat = " + this.lat + " lng = " + this.lng);
      //console.log("calc center end");
    },
    movemap() {
      //console.log("movemap start");
      let centerLoc = new kakao.maps.LatLng(this.lat, this.lng);
      this.map.panTo(centerLoc);
      //console.log("movemap end");
    },
    makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },
    makeOutListener(infowindow) {
      return function () {
        infowindow.close();
      };
    },
    removeMarker() {
      this.markers.forEach(m => m.setMap(null));
      this.markers = [];
    },
    makeClickListener(aptObj) {
      return ()=> {
        this.aptObj = aptObj;
        //console.log(this.aptObj);
      }
    },
    addMarker() {
      //console.log("addMarker start");
      for (let i = 0; i < this.houses.length; i++) {
        let marker = new kakao.maps.Marker({
          position: new kakao.maps.LatLng(this.houses[i]["lat"], this.houses[i]["lng"])
        });

        let infowindow = new kakao.maps.InfoWindow({
          content:
            `<div class="card" style="width: 10rem">` +
            `<div style ="font-size : x-small">아파트 이름 : ${this.houses[i]["aptName"]}</div>` +
            `<div style ="font-size : x-small">건축년도 : ${this.houses[i]["buildYear"]}</div>` +
            `</div>`,
        });
        kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.map, marker, infowindow)
        );
        kakao.maps.event.addListener(marker, "mouseout", this.makeOutListener(infowindow));
        let aptObj = {
          aptCode: this.houses[i]["aptCode"],
          aptName: this.houses[i]["aptName"]
        }
        kakao.maps.event.addListener(marker, 'click', this.makeClickListener(aptObj));
        this.markers.push(marker);
        marker.setMap(this.map);
      }
      //console.log("addMarker end");
    },
  },
  created() {
    this.mapContainer = null;
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAO_MAP_KEY}`;
      document.head.appendChild(script);
    }
  },
};
</script>
