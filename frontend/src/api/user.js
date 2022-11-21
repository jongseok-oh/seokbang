import { apiInstance } from "./index.js";

const api = apiInstance();

function logout(success, fail) {
  api.get(`/api/users/logout`).then(success).catch(fail);
}

function login(body, success, fail) {
    api.post(`/api/users/login`, body, { withCredentials: true }).then(success).catch(fail);
}

// function houseList(params, success, fail) {
//   api.get(`/api/aparts`, { params: params }).then(success).catch(fail);
// }

// function houseDealList(params, success, fail) {
//   api.get(`/api/aparts/deals`, { params: params }).then(success).catch(fail);
// }

export {login, logout};
