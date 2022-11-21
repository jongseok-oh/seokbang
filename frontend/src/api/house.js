import { apiInstance } from "./index.js";

const api = apiInstance();

function sidoList(success, fail) {
  api.get(`/api/locations/sidocode`, { withCredentials: true }).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  api.get(`/api/locations/guguncode`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  api.get(`/api/aparts`, { params: params }).then(success).catch(fail);
}

function houseDealList(params, success, fail) {
  api.get(`/api/aparts/deals`, { params: params }).then(success).catch(fail);
}

export { sidoList, gugunList, houseList, houseDealList};
