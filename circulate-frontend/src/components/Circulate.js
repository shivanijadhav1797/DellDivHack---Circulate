import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ViewAllRequests from "./ViewAllRequests"
import NewRequest from "./NewRequest";
import UserType from "./UserType";

class Circulate extends Component {
    render() {
        return (
            <Router>
            <>
              <center><h1>Circulate Application</h1></center>
              <br/>
              <Switch>
                    <Route path="/" exact component={UserType} />
                    <Route path="/showAll/:userType" exact component={ViewAllRequests} />
                    <Route path="/newRequest" component={NewRequest} />
              </Switch>
            </>
            </Router>
        )
    }
}

export default Circulate