import React, { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import ComplaintDataService from "../service/CirculateDataService";
import CirculateDataService from "../service/CirculateDataService";

class UserType extends Component {
    constructor(props) {
        super(props)
        this.state = {
            
        }
        this.userTypeAdmin = this.userTypeAdmin.bind(this)
        this.userTypeCustomer = this.userTypeCustomer.bind(this)
    }

    componentDidMount() {
        
    }

    userTypeAdmin() {
        this.props.history.push(`showAll/admin`);
    }

    userTypeCustomer() {
        this.props.history.push(`showAll/customer`);
    }

    
    render() {
      return (
          <div>
              <center><h3>Welcome to Circulate!</h3></center>
              <br/>
              <div className="container">
                <div className="text-center">
                    <button className="btn btn-secondary" onClick={this.userTypeAdmin}>Admin</button>
                </div>
                <br/>
                <div className="text-center">
                    <button className="btn btn-secondary" onClick={this.userTypeCustomer}>Customer</button>
                </div>
                    
              </div>
          </div>
      )
  }
}

export default UserType