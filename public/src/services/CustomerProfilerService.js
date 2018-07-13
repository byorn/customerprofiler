class CustomerProfilerService {
  static getData(customerid, date) {
    return fetch('/profile/'+customerid+"/"+date).then(response => {
      return response.json();
    }).catch(error => {
      return error;
    });
  }
}

export default CustomerProfilerService;
