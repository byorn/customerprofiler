import CustomerProfilerService from '../services/CustomerProfilerService';

export function searchDataSuccess(data) {
  return {
    type: 'DATA_LOADED',
    data
  };
}

export function searchData(customerid, date) {
  if(!customerid || !date){
    alert("Please enter a Customer ID and a Date");
    return;
  }
  return (dispatch) => {
   
    return CustomerProfilerService.getData(customerid,date).then(data => {
      
      dispatch(searchDataSuccess(data));
    }).catch(error => {
      throw (error);
    });
  };
};
