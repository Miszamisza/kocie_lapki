import React from 'react';
import IconButton from "@material-ui/core/IconButton";
import AddShoppingCartIcon from '@material-ui/icons/AddShoppingCart';
import makeStyles from "@material-ui/core/styles/makeStyles";
import connect from "react-redux/es/connect/connect";
import {NavLink} from "react-router-dom";
import UserMenu from "./UserMenu";
import AccountCircle from '@material-ui/icons/AccountCircle'

const useStyles = makeStyles(theme => ({

    cartButton: {
        color: 'white',
        display: 'inline',
        marginRight: theme.spacing(2),
        transition: 'all 0.2s',
        '&:hover': {
            color: '#848484',
            textDecoration: 'none'
        }
    },

    buttonContainer: {
        display: "flex"
    }

}));

const NavigationItems = (props) => {

    const classes = useStyles();

    let auth = (
        <NavLink to="/login">
            <IconButton className={classes.cartButton}
                        aria-label="Add to shopping cart">
                <AccountCircle/>
            </IconButton>
        </NavLink>
    );

    if (props.isAuthenticated) {
        auth = (
            <UserMenu/>
        );
    }

    return (
        <div className={classes.buttonContainer}>
            <IconButton className={classes.cartButton} aria-label="Add to shopping cart">
                <AddShoppingCartIcon/>
            </IconButton>
            {auth}
        </div>
    );
};


const mapStateToProps = (state) => {
    return {
        isAuthenticated: state.authReducer.token != null,
        isAdmin: state.authReducer.isAdmin
    }
};


export default connect(mapStateToProps)(NavigationItems);
