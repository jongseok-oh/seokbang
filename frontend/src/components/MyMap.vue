<template>
  <div>
    <input type="text" @keyup.enter="search($event.target.value)" />
    <div id="map" style="width: 100%; height: 90vh"></div>
  </div>
</template>

<script>
import axios from "@/util/http-common.js";

export default {
  data() {
    return {
      map: "",
      apartlist: [],
      dongcode: "",
      lat: "",
      lng: "",
    };
  },

  methods: {
    initMap(mapOption) {
      const mapContainer = document.getElementById("map");

      this.map = new kakao.maps.Map(mapContainer, mapOption);
    },
    getcenterloc(dongCode) {
      axios
        .get(`/api/locations/coordinate/${dongCode}`)
        .then((res) => {
          this.lat = res.data["lat"];
          this.lng = res.data["lng"];
        })
        .catch(() => {
          console.log("지도 중심 이동 실패 이자식아");
        });
    },
    movemap() {
      let options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(this.lat, this.lng),
        level: 5, //지도의 레벨(확대, 축소 정도)
      };
      this.initMap(options);
    },
    search(dongCode) {
      this.getcenterloc(dongCode);
      this.movemap();
      axios
        .get(`/api/aparts/${dongCode}`)
        .then((res) => {
          this.apartlist = res.data;
          console.log(this.apartlist);
          this.addMarker();
        })
        .catch(() => {
          console.log("아파트 찾기 에러 이자식아");
        });
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
    addMarker() {
      for (let i = 0; i < this.apartlist.length; i++) {
        let marker = new kakao.maps.Marker({
          map: this.map,
          position: new kakao.maps.LatLng(this.apartlist[i]["lat"], this.apartlist[i]["lng"]),
          title: this.apartlist[i]["aptCode"],
        });

        let infowindow = new kakao.maps.InfoWindow({
          content:
            `<div class="card" style="width: 10rem">` +
            `<div style ="font-size : x-small">아파트 이름 : ${this.apartlist[i]["aptName"]}</div>` +
            `<div style ="font-size : x-small">건축년도 : ${this.apartlist[i]["buildYear"]}</div>` +
            `</div>`,
        });

        kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.map, marker, infowindow)
        );
        kakao.maps.event.addListener(marker, "mouseout", this.makeOutListener(infowindow));
      }
    },
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      const mapOption = {
        center: new kakao.maps.LatLng(37.56666, 126.978),
        level: 5,
      };
      this.initMap(mapOption);
    } else {
      const script = document.createElement("script");
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=45b9e1bf120dbf1e4d5c03664a3e045a";
      document.head.appendChild(script);
    }
  },
};
</script>
