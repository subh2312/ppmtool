import axios from "axios";

class ppmService {
  createProject(project) {
    return axios.post("http://localhost:8080/api/project", project);
  }
}
export default new ppmService();
