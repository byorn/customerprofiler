import React from 'react';
import ReactDOM from 'react-dom';
import RootApp from './root';
import {Provider} from 'react-redux';
import store from './store.js';

import {searchData} from './actions/customerProfileActions';



const jsx = <Provider store={store}>
                <RootApp/>
            </Provider>

ReactDOM.render(jsx, document.getElementById('root'));
