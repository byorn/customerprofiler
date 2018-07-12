import React, { Component } from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as actionCreators from '../actions/customerProfileActions';

class Result extends Component {


  render() {

   const {data} = this.props;
   
   let list  = [] ;
   let key = 0;
   
   if(data.transactions){
      for (var i of data.transactions) {
        list.push(<tr key={key}>
                          <td> {i.CustomerId} </td>
                          <td> {i.Date} </td>
                          <td> {i.Amount} </td>
                          <td> {i.Description} </td>
                  </tr>);
        key++;

      }
  }

  return (
      <div>
           <table className="table">
            <thead className="thead-dark">
              <tr>
                <th scope="col">CustomerId</th>
                <th scope="col">Date</th>
                <th scope="col">Amount</th>
                <th scope="col">Description</th>
              </tr>
            </thead>
            <tbody>
          {list}
          </tbody>
          </table>
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

export default connect(mapStateToProps, mapDispachToProps)(Result);
