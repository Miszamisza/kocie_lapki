import React, {Component} from 'react';
import {oAuth2} from "../../../store/actions/auth";
import connect from "react-redux/es/connect/connect";
import {Redirect, withRouter} from "react-router-dom";

class OAuth2RedirectHandler extends Component {

    getUrlParameter = (name) => {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');

        const results = regex.exec(this.props.location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    };


    render() {

        const token = this.getUrlParameter('token');
        const error = this.getUrlParameter('error');
        const expiresIn = this.getUrlParameter('expires_in');
        const userId = this.getUrlParameter('userId');
        const scope = this.getUrlParameter('scope');
        const imageURL = this.getUrlParameter('imageURL');

        console.log(userId,
            imageURL,
            scope,
            token,
            error,
            expiresIn);


        if (token) {
            this.props.onTryOAuth2(userId,
                imageURL,
                scope,
                token,
                error,
                expiresIn);
        }

        return (
            <Redirect to="/"/>
        );
    }
}


const mapDispatchToProps = (dispatch) => {

    return {
        onTryOAuth2: (userId,
                      imageURL,
                      scope,
                      token,
                      error,
                      expiresIn) => dispatch(oAuth2(userId,
            imageURL,
            scope,
            token,
            error,
            expiresIn))
    }

};

export default withRouter(connect(null, mapDispatchToProps)(OAuth2RedirectHandler));


