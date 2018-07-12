import CustomerProfilerService from '../services/CustomerProfilerService';

export const updateInventory = (productId, qty) => {
  return {
    type: 'UPDATE_INVENTORY',
    productId,
    qty
  };
}


export function searchDataSuccess(data) {
  return {
    type: 'DATA_LOADED',
    data
  };
}

export function searchData() {
  return (dispatch) => {
   
    return CustomerProfilerService.getData().then(data => {
      
      dispatch(searchDataSuccess(data));
    }).catch(error => {
      throw (error);
    });
  };
};
