import React, {Component} from 'react';
import Layout from './components/hoc/Layout/Layout';
import {Redirect, Route, Switch, withRouter} from 'react-router-dom';
import Login from './components/Auth/Login/Login'
import {connect} from 'react-redux';
import {authCheckState} from './store/actions/auth';
import SignUp from './components/Auth/SignUp/SignUp';
import Logout from "./components/Auth/Logout";
import OAuth2RedirectHandler from './components/Auth/OAuth2/OAuth2RedirectHandler'
import Main from "./components/Search/Main";

class App extends Component {

    componentDidMount() {
            this.props.onTryAutoAuth();
    }

    render() {

        let route = (
            <Switch>
                <Route path="/oauth2/redirect" component={OAuth2RedirectHandler}/>
                <Route path='/login' component={Login}/>
                <Route path='/signup' component={SignUp}/>
                <Route path='/' component={Main}/>
                <Redirect to='/'/>
            </Switch>
        );

        if (this.props.isAuthenticated) {
            route = (
                <Switch>
                    <Route path='/logout' component={Logout}/>
                    <Route path='/' component={Main}/>
                    <Redirect to='/'/>
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
        isAuthenticated: state.authReducer.token !== null,
        isAdmin: state.authReducer.scope === 'ROLE_ADMIN'
    }
};

const mapDispatchToProps = (dispatch) => {

    return {
        onTryAutoAuth: () => dispatch(authCheckState())
    }

};


export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
