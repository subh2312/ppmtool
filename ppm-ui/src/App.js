import logo from "./logo.svg";
import "./App.css";
import AddProject from "./components/AddProject";
import Dashboard from "./components/Dashboard";
import Header from "./components/Header";
import { BrowserRouter, Route, Switch } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <div className="container">
          <Switch>
            <Route path="/" exact component={Dashboard}></Route>
            <Route path="/dashboard" exact component={Dashboard}></Route>
            <Route path="/addProject" exact component={AddProject}></Route>
          </Switch>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
