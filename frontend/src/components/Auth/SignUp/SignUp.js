import React, {Component} from 'react';
import {connect} from 'react-redux';
import {auth} from '../../../store/actions/auth';
import SignUpForm from './SignUpForm/SignUpForm';
import {Redirect} from "react-router-dom";


class SignUp extends Component {

    state = {
        controls: {
            name: {
                value: ''
            },
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
            name: this.state.controls.name.value,
            email: this.state.controls.email.value,
            password: this.state.controls.password.value
        };

        console.log(authData);

        this.props.onAuth(
            authData,
            false
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
                <SignUpForm
                    changedName={(event) => this.inputChangedHandler(event, "name")}
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

export default connect(mapStateToProps, mapDispatchToProps)(SignUp);
