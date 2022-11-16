<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <%@ include file="/WEB-INF/views/include/head.jsp" %>

  <body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
      <%@ include file="/WEB-INF/views/include/nav.jsp" %>
      <!-- Header-->
      <header class="bg-dark py-5">
        <div class="container px-5">
          <div class="row gx-5 align-items-center justify-content-center">
            <div class="col-lg-8 col-xl-7 col-xxl-6">
              <div class="my-5 text-center text-xl-start">
                <h1 class="display-5 fw-bolder text-white mb-2">구해줘 HOME</h1>
                <p class="lead fw-normal text-white-50 mb-4">우리를 위한 집</p>
                <div
                  class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start"
                >
                  <a class="btn btn-primary btn-lg px-4 me-sm-3" href="#features">시작하기</a>
                  <a class="btn btn-outline-light btn-lg px-4" href="#!">더 알아보기</a>
                </div>
              </div>
            </div>
            <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center">
              <img
                class="img-fluid rounded-3 my-5"
                src="https://post-phinf.pstatic.net/MjAxNzEyMDFfMTgg/MDAxNTEyMDkyMTA3NTY0.0EofFPIAghw0Ynr15TjEh3WPwHvSH2DVYY93HyOxg0Mg.KgUXctsB415ui1yuIyCh2DwhXk1tTVLzjvw-xIRPjwwg.PNG/image.png?type=w1200"
                alt="..."
              />
            </div>
          </div>
        </div>
      </header>
      <!-- Features section-->
      <section class="py-5" id="features">
        <div class="container px-5 my-5">
          <div class="row gx-5">
            <div class="col-lg-4 mb-5 mb-lg-0">
              <h2 class="fw-bolder mb-0">엥? 이게 집이라고?</h2>
              <img
                class="img-fluid rounded-3 my-5"
                src="https://youimg1.tripcdn.com/target/100v1f000001h1crh2F42_C_750_420.jpg_.webp?proc=source%2Ftrip"
                alt=""
              />
            </div>
            <div class="col-lg-8">
              <div class="row gx-5 row-cols-md-2">
                <div class="col mb-5 h-100">
                  <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
                    <i class="bi bi-collection"></i>
                  </div>
                  <h2 class="h5">지혜롭게 내집 마련하기</h2>
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >가용자금 확인 및 대출 계획</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >집 종류 및 지역 선택</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >정보 수집 & 시세파악</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >부동산 방문 & 집구경</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >계약 및 잔금 치르기</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >소유권 이전등기</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >인테리어 공사</a
                  >
                </div>
                <div class="col mb-5 h-100">
                  <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
                    <i class="bi bi-building"></i>
                  </div>
                  <h2 class="h5">부동산 뉴스</h2>
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >서울 입주 2년차 아파트 전셋값 1억400만원 올라</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >12:16 거래한파...매수자가 사라졌다</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >재건축 대안 또는 수직증축 리모델링... 추진 속...</a
                  >
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light"
                    >고가기준 9억, 서울 아파트 중간값 됐다</a
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- Testimonial section-->
      <div class="py-5 bg-light">
        <div class="container px-5 my-5">
          <div class="row gx-5 justify-content-center">
            <div class="col-lg-10 col-xl-7">
              <div class="text-center">
                <div class="fs-4 mb-4 fst-italic">
                  "집값을 알아 보지 않고 집을 사려는 행동과 그 행동에 대한 전적인 책임은 본인으로
                  부터 나온다. 집 값이 떨어지길 기다릴 바에 나는 SSAFY에서 개발자로 성공하겠다."
                </div>
                <div class="d-flex align-items-center justify-content-center">
                  <img
                    class="rounded-circle me-3"
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLd-VjTfzMpmgZH-uyb-3NU8wWwbemuLtdMg&usqp=CAU"
                    alt="..."
                  />
                  <div class="fw-bold">
                    JONGSEOK OH
                    <span class="fw-bold text-primary mx-1">/</span>
                    (현) SSAFY 8기
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Blog preview section-->
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">
              <div style="display: flex; flex-direction: row">
                <select
                  class="form-select sido-select"
                  id="dongbyeol-sido"
                  aria-label="Default select example"
                >
                  <option selected disabled>시/도</option>
                </select>
                <select
                  class="form-select"
                  id="dongbyeol-gugun"
                  aria-label="Default select example"
                >
                  <option selected disabled>시/구/군</option>
                </select>
                <select class="form-select" id="dongbyeol-dong" aria-label="Default select example">
                  <option selected disabled>동</option>
                </select>
              </div>
            </div>
          </div>
          <br />
          <div class="row gx-5">
            <div style="display: flex; flex-direction: row; height : 600px">
              <div style="flex-basis: 10%"></div>
              <ul class="list-group list-group-flush" style="flex-basis: 20%">
                <li class="list-group-item" style="font-size: 30px">거래 정보</li>
                
                <div style="overflow-y:auto; height : 100%; white-space:nowrap;" id = "trade-info">

                </div>
              </ul>
              <div id="map" style="flex-basis: 60%; "></div>
              <div style="flex-basis: 10%"></div>
            </div>
      </section>
    </main>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8c2ed21ab6956d39e256071885d15bfd"></script>
    <script>

      let container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
      let options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 5 //지도의 레벨(확대, 축소 정도)
      };

      let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

      let sidoSelect = document.getElementsByClassName("sido-select");

      fetch("http://localhost:8080/whereismyhome08_3/location/getsido.do")
        .then((res) => res.json())
        .then((data) => {
          //console.log(data);
          for (let i = 0; i < sidoSelect.length; i++) {
            let idx = 0;
            for (key in data) {
              let opt = document.createElement("option");
              opt.value = idx++;
              opt.innerText = data[key];
              sidoSelect[i].appendChild(opt);
            }
          }
        });
      
      fetch("https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000")
				.then((response) => response.json())
		        .then((data) => addOption("dongbyeol-sido", data));
		    
			document.getElementById("dongbyeol-sido").addEventListener("change", function() {
				let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
				fetch("https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=" + regcode)
					.then((response) => response.json())
	                .then((data) => addOption("dongbyeol-gugun", data));
			});
			
			document.getElementById("dongbyeol-gugun").addEventListener("change", function () {
				let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
				fetch("https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=" + regcode)
					.then((response) => response.json())
		            .then((data) => addOption("dongbyeol-dong", data));
      });

      function addOption(selid, data){
        let opt = "";
        switch (selid) {
          case "dongbyeol-sido":
            opt += "<option value=\"\">시도선택</option>";
                    data.regcodes.forEach(function (regcode) {
                          opt += "<option value=\"" + regcode.code + "\">" + regcode.name + "</option>";
                    });
            break;
          case "dongbyeol-gugun":
            opt += "<option value=\"\">구군선택</option>";
            for (let i = 0; i < data.regcodes.length; i++) {
                          if (i != data.regcodes.length - 1) {
                              if (data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] && data.regcodes[i].name.split(" ").length != data.regcodes[i + 1].name.split(" ").length) {
                                  data.regcodes.splice(i, 1);
                                  i--;
                              }
                          }
                      }
                      let name = "";
                      data.regcodes.forEach(function (regcode) {
                        if (regcode.name.split(" ").length >= 2){
                        if (regcode.name.split(" ").length == 2)
                                name = regcode.name.split(" ")[1];
                            else
                                name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
                            opt += "<option value=\"" + regcode.code + "\">" + name + "</option>";
                        }
                      });
            break;
          case "dongbyeol-dong":
            opt += "<option value=\"\">동선택</option>";
            data.regcodes.forEach(function (regcode) {
              if(regcode.name.split(" ").length >= 3){
                let idx = 2;
                  if (regcode.name.split(" ").length != 3)
                    idx = 3;
                  opt += "<option value=\"" + regcode.code + "\">";
                  let tmp = regcode.name.split(" ");
                  opt += tmp[idx] + "</option>";
              }
            });
            break;
        }
        document.getElementById(selid).innerHTML = opt;
      }
      
      function closeOverlay() {
        overlay.setMap(null);     
      }

      function makeOverListener(map, marker, infowindow) {
        return function() {
            infowindow.open(map, marker);
        };
      }

      function makeOutListener(infowindow) {
        return function() {
            infowindow.close();
        };
      }

      let tradeInfoScroll = document.getElementById("trade-info");

      function makeClickListener(marker, apartName){
        return function(){
          let aptCode = marker.getTitle();
          console.log("aptCode = " + aptCode);
          tradeInfoScroll.innerHTML = "";
          fetch(`http://localhost:8080/whereismyhome08_3/apart/deallist.do?aptCode=\${aptCode}`)
          .then((res) => res.json())
          .then((data) =>{
            console.log(data);
            for(let i = 0; i<data.length; i++){
              let dealInfoLi = document.createElement("li");
              //dealInfoLi.className = "list-group-item";
              let tdata = data[i];
              dealInfoLi.innerHTML = `\${apartName} <br />
                                      거래금액 : \${tdata["dealAmount"]}만원 <br />
                                      면적 : \${tdata["area"]} <br />
                                      층 : \${tdata["floor"]} <br />
                                      \${tdata["dealYear"]}. \${tdata["dealMonth"]}. \${tdata["dealDay"]}<br />
                                      -------------------------------`
              tradeInfoScroll.appendChild(dealInfoLi);
            }
          })
        }
      }

      function dongSelectOnChange(sidoId, gugunId, dongId){
        let dongSelectElement = document.getElementById(dongId);
        dongSelectElement.addEventListener("change", () => {
          let sidoSelectElement = document.getElementById(sidoId);
          let gugunSelectElement = document.getElementById(gugunId);

          let sidoName = sidoSelectElement.options[sidoSelectElement.selectedIndex].text;
          
          let gugunName = gugunSelectElement.options[gugunSelectElement.selectedIndex].text;
          let dongName = dongSelectElement.options[dongSelectElement.selectedIndex].text;
          console.log(sidoName + " " + gugunName + " " + dongName);
          //console.log(sidoName);

          fetch(
            `http://localhost:8080/whereismyhome08_3/location/getcoordinate.do?sidoName=\${sidoName}&gugunName=\${gugunName}&dongName=\${dongName}`
          )
            .then((res) => res.json())
            .then((data) => {
              //console.log(data)

              let moveLatLon = new kakao.maps.LatLng(data[0]["lat"], data[0]["lng"]);

              options = { //지도를 생성할 때 필요한 기본 옵션
                center: moveLatLon,
                level: 5 //지도의 레벨(확대, 축소 정도)
              };

              map = new kakao.maps.Map(container , options);

              let dongCode = data[0]["dongCode"];

              fetch(
                `http://localhost:8080/whereismyhome08_3/apart/getlist.do?dongCode=\${dongCode}`
              ).then((res) => res.json())
              .then((data) => {
                console.log(data);

                for(let i = 0; i < data.length; i++){

                  let marker = new kakao.maps.Marker({
                    map: map,
                    position: new kakao.maps.LatLng(data[i]["lat"], data[i]["lng"]),
                    title : data[i]["aptCode"]
                  })

                  let infowindow = new kakao.maps.InfoWindow({
                    content:
                    `<div class="card" style="width: 10rem">` +
                      `<div style ="font-size : x-small">아파트 이름 : \${data[i]["aptName"]}</div>` +
                      `<div style ="font-size : x-small">건축년도 : \${data[i]["buildYear"]}</div>` +
                    `</div>`
                  })

                  kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                  kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                  kakao.maps.event.addListener(marker, 'click', makeClickListener(marker, data[i]["aptName"]));
                }
              });
          });      
        });
      }

      dongSelectOnChange("dongbyeol-sido", "dongbyeol-gugun", "dongbyeol-dong");
    </script>
  </body>
</html>