import React from 'react';
import './App.css';
import Layout from './components/hoc/Layout';
import {Route, Switch, Redirect} from 'react-router-dom';
import CatFacts from './components/CatFacts/CatFacts';


function App() {

    return (
        <Layout>
            <Switch>
                <Route path='/facts' component={CatFacts}/>
            </Switch>
        </Layout>
    );
}

export default App;
