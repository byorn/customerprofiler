class CustomerProfilerService {
  static getData() {
    return fetch('/data.json').then(response => {
      return response.json();
    }).catch(error => {
      return error;
    });
  }
}

export default CustomerProfilerService;
