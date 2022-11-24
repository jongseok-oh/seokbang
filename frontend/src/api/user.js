import { apiInstance } from "./index.js";

const api = apiInstance();

function logout(success, fail) {
  api.get(`/api/users/logout`).then(success).catch(fail);
}

function login(body, success, fail) {
    api.post(`/api/users/login`, body).then(success).catch(fail);
}

function modifyUser(body, success, fail) {
  api.put(`/api/users`, body).then(success).catch(fail);
}

function deleteUser(params, success, fail) {
  api.delete(`/api/users`, {params:params}).then(success).catch(fail);
}

function deleteInterestArea(path, success, fail) {
  api.delete(`/api/interests/${path}`).then(success).catch(fail);
}

function insertInterestArea(path, success, fail) {
  api.post(`/api/interests/${path}`).then(success).catch(fail);
}


export {login, logout, modifyUser, deleteUser, deleteInterestArea, insertInterestArea};
