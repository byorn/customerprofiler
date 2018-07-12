import {createStore,applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
//import the root reducer
import rootReducer from './reducers/index';

//create an onject for the default data
const defaultState= {

  profile: {},
 
}

const store =createStore(rootReducer,defaultState, applyMiddleware(thunk));


export default store;
