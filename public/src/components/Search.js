import React, { Component } from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as actionCreators from '../actions/customerProfileActions';

class Search extends Component {


  render() {
  const {searchData} = this.props;
 
  return (
      <div>
          <button className="btn btn-success" onClick={searchData}>Search</button>
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
