import React from 'react';
import Link from "@material-ui/core/Link/Link";
import {Link as RouterLink} from "react-router-dom";
import Tooltip from "@material-ui/core/Tooltip";
import IconButton from "@material-ui/core/IconButton";
import AddShoppingCartIcon from '@material-ui/icons/AddShoppingCart';
import Button from "@material-ui/core/Button";
import makeStyles from "@material-ui/core/styles/makeStyles";
import AccountCircle from "@material-ui/icons/AccountCircle";


const useStyles = makeStyles(theme => ({

    toolbarLink: {
        padding: theme.spacing(2),
        flexShrink: 0,
        color: 'white',
        transition: 'all 0.2s',
        '&:hover': {
            color: '#848484',
            textDecoration: 'none'
        }
    },
    cartButton: {
        color: 'white',
        display: 'inline-block',
        marginRight: theme.spacing(2),

    }, button: {
        color: 'white',
        borderColor: 'white'
    },

}));

const NavigationItems = () => {

    const classes = useStyles();

    return (
        <>
            <Link component={RouterLink} variant="subtitle1" to="/facts" className={classes.toolbarLink}>Cat
                facts</Link>
            <Link variant="subtitle1" href="#" className={classes.toolbarLink}>Shop</Link>
            <Link variant="subtitle1" href="#" className={classes.toolbarLink}>About us</Link>
            <Link variant="subtitle1" href="#" className={classes.toolbarLink}>Contact</Link>

            <Tooltip title="Shopping cart">
                <IconButton className={classes.cartButton} aria-label="Add to shopping cart">
                    <AddShoppingCartIcon/>
                </IconButton>
            </Tooltip>
            <Tooltip title="Account">
                <IconButton className={classes.cartButton} aria-label="Add to shopping cart">
                    <AccountCircle/>
                </IconButton>
            </Tooltip>
            <Button variant="outlined" className={classes.button}>
                Sign up
            </Button>
        </>
    );
};

export default NavigationItems;