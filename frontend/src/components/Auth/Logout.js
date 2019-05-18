import React, {Component} from 'react';
import {connect,} from 'react-redux';
import {Redirect} from 'react-router-dom'
import {userLogout} from '../../store/actions/auth'

class Logout extends Component {

    componentDidMount() {
        this.props.onLogout();
    }


    render() {
        return (
            <Redirect to='/'/>
        );
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        onLogout: () => dispatch(userLogout())
    }
};

export default connect(null, mapDispatchToProps)(Logout);