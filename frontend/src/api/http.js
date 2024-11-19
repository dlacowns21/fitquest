import axios from 'axios';

const http = axios.create({
  // localhost 대신 실제 IP 주소 사용
  baseURL: 'http://70.12.50.63:8097/fitquest/api',  
  withCredentials: true,
});

export default http; 