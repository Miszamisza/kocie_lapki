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


const authSuccess = (token, userId, isAdmin) => {
    return {
        type: AUTH_SUCCESS,
        token: token,
        userId: userId,
        isAdmin: isAdmin
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

    return {
        type: AUTH_LOGOUT
    }
};


const checkAuthTimeout = (expirationTime) => {
    return dispatch => {

        setTimeout(() => {
            dispatch(userLogout());
        }, expirationTime * 1000
        );
    };
};

const isAdminChecker = (scope) => {
    return scope === 'ROLE_ADMIN'
};


export const auth = (authData, isSignedUp) => {

    return dispatch => {
        dispatch(authStart());

        let endpoint = 'http://localhost:8080/auth/login';

        if (!isSignedUp) {
            endpoint = 'http://localhost:8080/auth/signup';
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

                dispatch(authSuccess(
                    response.data.accessToken,
                    response.data.userId,
                    isAdminChecker(response.data.scope)
                ));

                dispatch(checkAuthTimeout(response.data.expiresIn));
            })
            .catch(err => {
                dispatch(authFail(err.response.data.error));
            })
    }
};


export const authCheckState = () => {
    return dispatch => {
        const token = localStorage.getItem('token');
        const expirationDate = new Date(localStorage.getItem('expirationDate'));

        if (!token || expirationDate <= new Date()) {

            dispatch(userLogout());

        } else {
            dispatch(authSuccess(
                token,
                localStorage.getItem('userId'),
                isAdminChecker(localStorage.getItem('scope'))
            ));

            dispatch(checkAuthTimeout((expirationDate.getTime() - new Date().getTime()) / 1000));
        }
    }
};