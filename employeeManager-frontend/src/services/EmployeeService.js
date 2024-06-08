import axios from 'axios';

const API_URL = 'http://localhost:8080/employee';

const getEmployees = () => {
  return axios.get(`${API_URL}/all`);
};

const addEmployee = employee => {
  return axios.post(`${API_URL}/add`, employee, {
    headers: {
      'Content-Type': 'application/json'
    }
  });
};

const updateEmployee = (id, employee) => {
  return axios.put(`${API_URL}/update/${id}`, employee, {
    headers: {
      'Content-Type': 'application/json'
    }
  });
};

const deleteEmployee = id => {
  return axios.delete(`${API_URL}/delete/${id}`);
};

export default {
  getEmployees,
  addEmployee,
  updateEmployee,
  deleteEmployee
};
