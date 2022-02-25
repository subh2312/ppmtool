import React, { Component } from "react";
import Projects from "./Projects";
import CreateProjectButton from "./CreateProjectButton";

export default class Dashboard extends Component {
  render() {
    return (
      <div class="projects">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h1 class="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton></CreateProjectButton>
              <br />
              <hr />
              <Projects />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
