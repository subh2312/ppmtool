import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Component } from "react";
import AddProject from "./components/AddProject";
import { Provider } from "react-redux";
import store from "./Store";
class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Routes>
              <Route exact path="/" element={<Dashboard />}></Route>
              <Route
                exact
                path="/Dashboard.html"
                element={<Dashboard />}
              ></Route>
              <Route exact path="/addProject" element={<AddProject />}></Route>
            </Routes>
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
