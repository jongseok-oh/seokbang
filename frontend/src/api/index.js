import axios from "axios";
import router from "@/router";
import store from "@/store";
// local vue api axios instance
function apiInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    withCredentials: true,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  
  instance.interceptors.response.use(
    function (response) {
      return response;
    },
    function (error) {
      if (error.response && error.response.status) {
        switch (error.response.status) {
          // status code가 401인 경우 `logout`을 커밋하고 `/login` 페이지로 리다이렉트
          case 401:
            store.commit('userStore/CLEAR_USER_INFO').catch(()=>{});
            alert("로그인 후 이용해 주세요");
            router.push('/loginform').catch(() => { });
            // 이행되지 않는 Promise를 반환하여 Promise Chaining 끊어주기
            return new Promise(() => { });
          case 406:
            alert("권한 없는 사용자 입니다.");
            router.push('/').catch(() => { });
            return new Promise(() => { });
          default:
            return Promise.reject(error);
        }
      }
      return Promise.reject(error);
    },
  );
  return instance;
}

// house deal API axios instance
// function houseInstance() {
//   const instance = axios.create({
//     baseURL: process.env.VUE_APP_HOUSE_DEAL_URL,
//     headers: {
//       "Content-Type": "application/json;charset=utf-8",
//     },
//   });
//   return instance;
// }

//export { apiInstance, houseInstance };
export { apiInstance};