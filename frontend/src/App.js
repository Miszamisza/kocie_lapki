import React, {Component} from 'react';
import Layout from './components/hoc/Layout/Layout';
import {Redirect, Route, Switch, withRouter} from 'react-router-dom';
import Login from './components/Auth/Login/Login'
import {connect} from 'react-redux';
import CatFacts from './components/CatFacts/CatFacts';
import {authCheckState} from './store/actions/auth';
import SignUp from './components/Auth/SignUp/SignUp';
import Logout from "./components/Auth/Logout";

class App extends Component {

    componentDidMount() {
        this.props.onTryAutoAuth();
    }

    render() {

        let route = (
            <Switch>
                <Route path='/login' component={Login}/>
                <Route path='/signup' component={SignUp}/>
                <Route path='/' component={CatFacts}/>
                <Redirect to='/'/>
            </Switch>
        );

        if (this.props.isAuthenticated) {
            route = (
                <Switch>
                    <Route path='/logout' component={Logout}/>
                    <Route path='/' component={CatFacts}/>
                </Switch>
            );
        }

        // if (this.props.isAdmin) {
        //     route = (
        //         <Switch>
        //             <Route path='/login' component={Login}/>
        //             <Route path='/' component={CatFacts}/>
        //         </Switch>
        //     );
        // }


        return (
            <div>
                <Layout>
                    {route}
                </Layout>
            </div>
        )
    };
}


const mapStateToProps = (state) => {
    return {
        isAuthenticated: state.authReducer.token != null,
        isAdmin: state.authReducer.isAdmin
    }
};

const mapDispatchToProps = (dispatch) => {

    return {
        onTryAutoAuth: () => dispatch(authCheckState())
    }

};


export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
