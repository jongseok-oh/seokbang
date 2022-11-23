import { apiInstance } from "./index.js";

const api = apiInstance();

function logout(success, fail) {
  api.get(`/api/users/logout`).then(success).catch(fail);
}

function login(body, success, fail) {
    api.post(`/api/users/login`, body).then(success).catch(fail);
}

function modifyUser(body, success, fail) {
  api.put(`/api/users/login`, body).then(success).catch(fail);
}

function deleteUser(params, success, fail) {
  api.delete(`/api/users/login`, params).then(success).catch(fail);
}


export {login, logout, modifyUser, deleteUser};
