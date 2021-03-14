import React, { Component } from "react";
import CirculateDataService from "../service/CirculateDataService";

class ViewAllRequests extends Component {
  constructor(props) {
    super(props)
    this.state = {
      userType: this.props.match.params.userType,
      requests: [],
      message : '',
      customerDetails : {}
    }
    //this.hideShowButtons = this.hideShowButtons(this)
    this.viewAllRequests = this.viewAllRequests.bind(this)
    this.getCustomerDetails = this.getCustomerDetails.bind(this)
    this.addRequestClicked = this.addRequestClicked.bind(this)
    this.approveButtonClicked = this.approveButtonClicked.bind(this)
    this.deleteRequestClicked = this.deleteRequestClicked.bind(this)
    this.showApprove = this.showApprove.bind(this)
    this.isAdmin = this.isAdmin.bind(this)
    this.isCustomer = this.isCustomer.bind(this)
    this.isApproved = this.isApproved.bind(this)

  }

  componentDidMount() {
    this.viewAllRequests();
    this.getCustomerDetails();
    // this.state.userType = this.props.userType;
    console.log(this.state.userType);
  } 

  isAdmin(userType){
    if(userType === 'ADMIN'){
      return true;
    }
    return false;
  }

  isCustomer(userType){
    if(userType === 'CUSTOMER'){
      return true;
    }
    return false;
  }

  showApprove(userType, status){
    // console.log(userType+" "+status)
    if(userType === 'ADMIN' && status === 'PENDING'){
      return true;
    }
    return false;
  }

  isApproved(status){
    if(status === 'APPROVED'){
      return true;
    }
    return false;
  }

  viewAllRequests() {
    CirculateDataService.retrieveAllRequests(1)
        .then(
            response => {
                // console.log(response);
                this.setState({ requests: response.data})
            })
  }

  getCustomerDetails(){
    CirculateDataService.getCustomerDetails().then(
      response => {
        console.log(response);
        this.setState({ customerDetails: response.data})
      }
    )
  }

  addRequestClicked() {
    this.props.history.push(`/newRequest`)
  }

  approveButtonClicked(request) {
    request.status = 'APPROVED';
    request.pointsEarned = request.pointsEarned + 500;
    CirculateDataService.updateRequest(request)
        .then(
            response => {
                this.setState({ message: 'Request Approved'})
                this.viewAllRequests()
            })
  }

  deleteRequestClicked(id) {
    CirculateDataService.deleteRequest(id)
        .then(
            response => {
                this.setState({ message: `Deleted complaint id - ${id} successfully` })
                this.viewAllRequests()
            }
        )
  }

  render() {
    return (
            <div className="container">
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                {this.isCustomer(this.state.userType.toUpperCase()) && (<div >
                  <b>Username : {this.state.customerDetails.fullName} <br/>
                    Points Available : {this.state.customerDetails.points}  </b>
                </div>)}
                <table className="table">
                    <thead>
                        <tr>
                            <th>Request ID</th>
                            <th>Username</th>
                            <th>Request Date</th>
                            <th>Address</th>
                            <th>Device Type</th>
                            <th>Device Condition</th>
                            <th>Model No</th>
                            <th>Points Earned</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                          this.state.requests.map(c =>
                            <tr key={c.requestId}>
                              <td>{c.requestId}</td>
                              <td>{c.userName.toUpperCase()}</td>
                              <td>{c.requestDate}</td>
                              <td>{c.address.toUpperCase()}</td>
                              <td>{c.deviceType.toUpperCase()}</td>
                              <td>{c.deviceCondition.toUpperCase()}</td>
                              <td>{c.modelNo.toUpperCase()}</td>
                              <td>{c.pointsEarned}</td>
                              <td>{this.showApprove(this.state.userType.toUpperCase(), c.status.toUpperCase()) && (<button className="btn btn-info" 
                                  onClick={() => 
                                    this.approveButtonClicked(c)}>Approve</button>)}
                                  {this.isApproved(c.status.toUpperCase()) && (<p style={{color:'green'}}>APPROVED</p>)}
                                  {this.isCustomer(this.state.userType.toUpperCase()) && !this.isApproved(c.status.toUpperCase()) && (<p style={{color:'orange'}}>PENDING</p>)}
                             </td>
                            </tr>
                          )
                        }
                    </tbody>
                </table>
            <hr/>
            {this.isCustomer(this.state.userType.toUpperCase()) && (
            <div className="text-center">
                <button className="btn btn-secondary" onClick={this.addRequestClicked}>New Request</button>
            </div>)}
            
            </div>

    )
}
}

export default ViewAllRequests
