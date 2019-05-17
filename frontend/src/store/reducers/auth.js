import {
    AUTH_START,
    AUTH_SUCCESS,
    AUTH_FAIL,
    AUTH_LOGOUT
} from '../actions/actionType';


const initialState = {
    token: null,
    userId: null,
    error: null,
    loading: false,
    isAdmin: false
};

const reducer = (state = initialState, action) => {

    switch (action.type) {

        case AUTH_LOGOUT :
            return {
                ...state,
                token: null,
                userId: null,
            };

        case AUTH_START :
            return {
                ...state,
                loading: true,
                error: null
            };

        case AUTH_FAIL :
            return {
                ...state,
                loading: false,
                error: action.error
            };

        case AUTH_SUCCESS :
            return {
                ...state,
                token: action.token,
                userId: action.userId,
                isAdmin: action.isAdmin,
                error: null,
                loading: false
            };

        default :
            return state;
    }

};

export default reducer;