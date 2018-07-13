import React, { Component } from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as actionCreators from '../actions/customerProfileActions';

class Search extends Component {

  constructor(props) {
    super(props);
    this.handleCustomerIdInput = this.handleCustomerIdInput.bind(this);
    this.handleDateInput = this.handleDateInput.bind(this);
    this.state={
      customerId:'',
      date:''
    }
  }

  handleCustomerIdInput(event){
    const {value} = event.target;
    this.setState({customerId:value});
  }

  handleDateInput(event){
    const {value} = event.target;
    this.setState({date:value});
  }

  render() {
  const {searchData} = this.props;
 
  return (
      <div className="row">
          <div className="col-lg-2">
             <h3>Customer ID:</h3>
          </div>
          <div className="col-lg-2">
            <input className="comp" type="text" onChange={this.handleCustomerIdInput}/>
          </div>
          <div className="col-lg-1">
             <h3>Date:</h3>
          </div>
          <div className="col-lg-2">
            <input className="comp" type="date"  onChange={this.handleDateInput}/>
          </div>
          <div className="col-lg-3">
          <button className="btn btn-success comp" onClick={searchData.bind(null,this.state.customerId,this.state.date)}>Search</button>
          </div>
      </div>
    );
  }
}


function mapStateToProps(state){
  
  return {
    data:state.profile
  }
}

function mapDispachToProps(dispatch){
  return bindActionCreators(actionCreators,dispatch);
}

export default connect(mapStateToProps, mapDispachToProps)(Search);
