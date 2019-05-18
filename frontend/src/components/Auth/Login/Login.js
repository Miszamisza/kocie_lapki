import React, {Component} from 'react';
import {connect} from 'react-redux';
import {auth} from '../../../store/actions/auth';
import LoginForm from './LoginForm/LoginForm';
import {Redirect} from "react-router-dom";


class Login extends Component {

    state = {
        controls: {
            email: {
                value: ''
            },
            password: {
                value: ''
            }
        }
    };


    submitHandler = (event) => {

        event.preventDefault();

        const authData = {
            email: this.state.controls.email.value,
            password: this.state.controls.password.value
        };


        this.props.onAuth(
            authData,
            true
        )
    };

    inputChangedHandler = (event, type) => {

        const controls = {
            ...this.state.controls,
            [type]: {
                ...this.state.controls[type],
                value: event.target.value,
            }
        };

        this.setState({
            controls: controls,
        });
    };


    render() {

        let redirect = this.props.isAuthenticated ?
            <Redirect to='/'/> : null;

        return (
            <>
                {redirect}
                <LoginForm
                    changedPassword={(event) => this.inputChangedHandler(event, "password")}
                    changedEmail={(event) => this.inputChangedHandler(event, "email")}
                    submitHandler={this.submitHandler}
                />
            </>

        )
    }
}


const mapStateToProps = (state) => {
    return {
        loading: state.authReducer.loading,
        error: state.authReducer.error,
        isAuthenticated: state.authReducer.token !== null
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        onAuth: (authData, isSignedUp) => dispatch(auth(authData, isSignedUp))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(Login);
