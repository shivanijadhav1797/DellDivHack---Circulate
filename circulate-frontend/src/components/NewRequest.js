import React, { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import ComplaintDataService from "../service/CirculateDataService";

class NewRequest extends Component {
    constructor(props) {
        super(props)
        this.state = {
            requestID : '',
            userName : '',
            deviceType : 'Laptop',
            deviceCondition : 'Working',
            address : '',
            modelNo : '',
            pickupDate : '',
            successMessage : '',
            errorMessage : ''
        }
       
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount() {
        return;
    }

    validate(values){
        this.state.errorMessage = '';
        
        if (!values.userName) {
            this.state.errorMessage = 'Username is mandatory field'
            return this.state.errorMessage;
        } 

        if (!values.address) {
            this.state.errorMessage = 'Address is mandatory field'
            return this.state.errorMessage;
        } 
        
        if (!values.deviceType) {
            this.state.errorMessage = 'Device Type is mandatory field'
            return this.state.errorMessage;
        } 

        if (!values.deviceCondition) {
            this.state.errorMessage = 'Device Condition is mandatory field'
            return this.state.errorMessage;
        } 

        if (!values.modelNo) {
            this.state.errorMessage = 'Model No. is mandatory field'
            return this.state.errorMessage;
        } 
        console.log(this.state.errorMessage);
        return this.state.errorMessage;
    }

    onSubmit(values) {
        console.log('On submit' + values.userName)
        let request = {
            userName : values.userName,
            address : values.address,
            deviceType : values.deviceType,
            deviceCondition : values.deviceCondition,
            modelNo : values.modelNo,
            pickupDate : values.pickupDate,
            custId : 1
            
        }
        //this.props.history.push(`/show`)
        ComplaintDataService.newRequest(request)
            .then(
                response => {
                  this.setState({message : response.data.message})
                }
            )
            .then(() => this.props.history.push('/showAll/customer'))
      }

    render() {
    
        let { userName, address, deviceType, deviceCondition, modelNo, pickupDate} = this.state
        return (
          <div>
              <center><h3>New Request</h3></center>
              
              
              <div className="container">
                  <Formik
                    initialValues={{ userName, address, deviceType, deviceCondition, modelNo, pickupDate }}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                  >
                      {
                          (props) => (
                              <Form>
                                 {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
                                 {this.state.errorMessage && <div className="alert alert-warning">{this.state.errorMessage}</div>}
                                  <fieldset className="form-group">
                                      <label>Username : </label>
                                      <Field className="form-control" type="text" name="userName"  />
                                  </fieldset>
                                  <fieldset className="form-group">
                                      <label>Address : </label>
                                      <Field className="form-control" type="text" name="address"  />
                                  </fieldset>
                                  <fieldset className="form-group">
                                      <label>Device Type :</label>
                                      <Field className="form-control" component="select" name="deviceType">
                                            <option value="laptop">Laptop</option>
                                            <option value="desktop">Desktop</option>
                                            <option value="tablet">Tablet</option>
                                            <option value="mobile">Printer</option>
                                      </Field>
                                  </fieldset>
                                  <fieldset className="form-group">
                                      <label>Device Condition :</label>
                                      <Field className="form-control" component="select" name="deviceCondition">
                                            <option value="mobile">Working</option>
                                            <option value="tablet">Not Working</option>
                                      </Field>
                                  </fieldset>
                                  <fieldset className="form-group">
                                      <label>Model No. : </label>
                                      <Field className="form-control" type="text" name="modelNo"  />
                                  </fieldset>
                                  <fieldset className="form-group">
                                      <label>Pickup Date : </label>
                                      <Field className="form-control" type="date" name="pickupDate"  />
                                  </fieldset>
                                  <div className = 'text-center'>
                                  <button className="btn btn-secondary" type="submit">Raise New Request</button>
                                  </div>
                              </Form>
                          )
                      }
                  </Formik>
  
              </div>
          </div>
      )
  }
}

export default NewRequest