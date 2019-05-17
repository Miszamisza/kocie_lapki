import React from 'react';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import AccountCircle from "@material-ui/icons/AccountCircle";
import IconButton from "@material-ui/core/IconButton";
import makeStyles from "@material-ui/core/styles/makeStyles";
import connect from "react-redux/es/connect/connect";
import {Link as LinkProvider} from 'react-router-dom';


const useStyles = makeStyles(theme => ({

    cartButton: {
        color: 'white',
        display: 'inline-block',
        marginRight: theme.spacing(2),
        transition: 'all 0.2s',
        '&:hover': {
            color: '#848484',
            textDecoration: 'none'
        }
    }
}));


const UserMenu = (props) => {

    const classes = useStyles();

    const [anchorEl, setAnchorEl] = React.useState(null);

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };


    return (
        <div>
            <IconButton
                className={classes.cartButton}
                aria-label="Add to shopping cart"
                aria-owns={props.anchorEl ? 'simple-menu' : undefined}
                aria-haspopup="true"
                onClick={handleClick}
            >
                <AccountCircle/>
            </IconButton>

            <Menu id="simple-menu"
                  anchorEl={anchorEl}
                  open={Boolean(anchorEl)}
                  onClose={handleClose}>

                <LinkProvider to='/logout'>
                    <MenuItem onClick={handleClose}>
                        Logout
                    </MenuItem>
                </LinkProvider>
                <MenuItem onClick={handleClose}>My account</MenuItem>
                <MenuItem onClick={handleClose}>Logout</MenuItem>
            </Menu>
        </div>
    );
};


const mapStateToProps = (state) => {
    return {
        isAuthenticated: state.authReducer.token != null,
        isAdmin: state.authReducer.isAdmin
    }
};


export default connect(mapStateToProps)(UserMenu);
