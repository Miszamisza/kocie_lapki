import React from 'react';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import AccountCircle from "@material-ui/icons/AccountCircle";
import IconButton from "@material-ui/core/IconButton";
import makeStyles from "@material-ui/core/styles/makeStyles";
import connect from "react-redux/es/connect/connect";
import {Link as LinkProvider} from 'react-router-dom';
import Avatar from "@material-ui/core/Avatar/Avatar";


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

    avatar: {
        width: "1.5rem",
        height: "auto"
    },
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


    let avatar = (
        <AccountCircle/>
    );

    if (props.imageURL) {
        console.log(props.imageURL);
        avatar = (
            <Avatar alt="user avatar" src={props.imageURL} className={classes.avatar}/>
        );
    }

    let adminItems = null;

    if (props.isAdmin) {
        adminItems = (
            <div>
                <MenuItem onClick={handleClose}>Users</MenuItem>
                <MenuItem onClick={handleClose}>Orders</MenuItem>
                <MenuItem onClick={handleClose}>Admin panel</MenuItem>
            </div>
        );
    }

    return (
        <div>
            <IconButton
                className={classes.cartButton}
                aria-label="Add to shopping cart"
                aria-owns={props.anchorEl ? 'simple-menu' : undefined}
                aria-haspopup="true"
                onClick={handleClick}
            >
                {avatar}
            </IconButton>

            <Menu id="simple-menu"
                  anchorEl={anchorEl}
                  open={Boolean(anchorEl)}
                  onClose={handleClose}
            >

                <LinkProvider to='/logout'>
                    <MenuItem onClick={handleClose}>
                        Logout
                    </MenuItem>
                </LinkProvider>
                <MenuItem onClick={handleClose}>My account</MenuItem>
                <MenuItem onClick={handleClose}>Logout</MenuItem>
                {adminItems}
            </Menu>
        </div>
    );
};


const mapStateToProps = (state) => {
    return {
        isAuthenticated: state.authReducer.token != null,
        isAdmin: state.authReducer.scope === 'ROLE_USER ROLE_ADMIN',
        imageURL: state.authReducer.imageURL
    }
};


export default connect(mapStateToProps)(UserMenu);
