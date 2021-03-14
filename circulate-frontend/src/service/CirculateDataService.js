import axios from 'axios'


const BASE_URL = 'http://localhost:8080/request'
const BASE_API = 'http://localhost:8080'


class CirculateDataService {

    retrieveRequest(requestID) {
        console.log('executed retrieve complaint')
        return axios.get(`${BASE_URL}/${requestID}`);
    }

    retrieveAllRequests(userID) {
        return axios.get(`${BASE_URL}/${userID}`);
    }

    newRequest(request) {
        return axios.post(`${BASE_URL}`, request);
    }

    updateRequest(request) {
        return axios.patch(`${BASE_URL}`, request);
    }

    deleteRequest(requestID) {
        //console.log('executed service')
        return axios.delete(`${BASE_URL}/${requestID}`);
    }

    getCustomerDetails(){
        return axios.get(`${BASE_API}/customer/1`);
    }
}

export default new CirculateDataService()