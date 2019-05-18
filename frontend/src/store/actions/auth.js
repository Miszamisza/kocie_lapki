import {
    AUTH_LOGOUT,
    AUTH_START,
    AUTH_SUCCESS,
    AUTH_FAIL
}
    from './actionType';

import axios from 'axios';


const authStart = () => {
    return {
        type: AUTH_START
    }
};


const authSuccess = (token, userId, scope, imageURL) => {
    return {
        type: AUTH_SUCCESS,
        token: token,
        userId: userId,
        scope: scope,
        imageURL: imageURL
    }
};

const authFail = (error) => {
    return {
        type: AUTH_FAIL,
        error: error
    }
};


export const userLogout = () => {

    localStorage.removeItem('token');
    localStorage.removeItem('expirationDate');
    localStorage.removeItem('userId');
    localStorage.removeItem('scope');
    localStorage.removeItem('imageURL');

    return {
        type: AUTH_LOGOUT
    }
};


const checkAuthTimeout = (expirationTime) => {
    return dispatch => {

        setTimeout(() => {
            dispatch(userLogout());
        }, expirationTime * 1000000
        );
    };
};

export const auth = (authData, isSignedUp) => {

    return dispatch => {
        dispatch(authStart());

        let endpoint = 'https://kitten-paws.azurewebsites.net/auth/login';

        if (!isSignedUp) {
            endpoint = 'https://kitten-paws.azurewebsites.net/auth/signup';
        }

        console.log(authData);

        axios.post(endpoint, authData)
            .then(response => {

                console.log(response);

                localStorage.setItem('token', response.data.accessToken);
                const expirationDate = new Date(new Date().getTime() + response.data.expiresIn * 1000);
                localStorage.setItem('expirationDate', '' + expirationDate);
                localStorage.setItem('userId', response.data.userId);
                localStorage.setItem('scope', response.data.scope);
                localStorage.setItem('imageURL', response.data.imageURL ? response.data.imageURL : '');

                console.log(response.data);

                dispatch(authSuccess(
                    response.data.accessToken,
                    response.data.userId,
                    response.data.scope,
                    response.data.imageURL
                ));

                // dispatch(checkAuthTimeout(response.data.expiresIn));
            })
            .catch(err => {
                dispatch(authFail(err.response.data.error));
            })
    }
};

export const oAuth2 = (userId, imageURL, scope, token, error, expiresIn) => {

    return dispatch => {

        dispatch(authStart());

        localStorage.setItem('token', token);
        const expirationDate = new Date(new Date().getTime() + expiresIn * 1000000000);
        localStorage.setItem('expirationDate', '' + expirationDate);
        localStorage.setItem('userId', userId);
        localStorage.setItem('scope', scope);
        localStorage.setItem('imageURL', imageURL);

        dispatch(authSuccess(
            token,
            userId,
            scope,
            imageURL
        ));

        // dispatch(checkAuthTimeout(expiresIn));

        if (error !== null && error !== '') {
            dispatch(authFail(error));
        }
    }
};


export const authCheckState = () => {
    return dispatch => {
        const token = localStorage.getItem('token');
        const expirationDate = new Date(localStorage.getItem('expirationDate'));

        if (token === null || expirationDate <= new Date()) {
            // dispatch(userLogout());

        } else {
            dispatch(authSuccess(
                token,
                localStorage.getItem('userId'),
                localStorage.getItem('scope'),
                localStorage.getItem('imageURL')
            ));

            // dispatch(checkAuthTimeout((expirationDate.getTime() - new Date().getTime()) / 1000));
        }
    }
};