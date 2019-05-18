import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import HideOnScroll from '../hoc/HideOnScroll';
import Container from "@material-ui/core/Container/Container";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu"
import SearchIcon from "@material-ui/icons/Search"
import InputBase from "@material-ui/core/InputBase";
import {fade} from "@material-ui/core/styles";
import makeStyles from "@material-ui/core/styles/makeStyles";
import Typography from "@material-ui/core/Typography";
import NavigationItems from './NavigationItems/NavigationItems';

const useStyles = makeStyles(theme => ({
    root: {
        backgroundColor: 'rgb(255,102,102)',
    },

    menuButton: {
        display: 'none',
        [theme.breakpoints.down('sm')]: {
            display: 'block',
        },
    },
    search: {
        position: 'relative',
        display: 'inline-block',
        marginRight: theme.spacing(2),
        borderRadius: theme.shape.borderRadius,
        backgroundColor: fade(theme.palette.common.white, 0.15),
        '&:hover': {
            backgroundColor: fade(theme.palette.common.white, 0.25),
        },
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            marginLeft: theme.spacing(1),
            width: 'auto',
        },
    },
    searchIcon: {
        width: theme.spacing(7),
        height: '100%',
        position: 'absolute',
        pointerEvents: 'none',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
    },
    inputRoot: {
        color: 'inherit',
    },
    inputInput: {
        padding: theme.spacing(1, 1, 1, 7),
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            width: 120,
            '&:focus': {
                width: 200,
            },
        },
    },
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
    toolbar: {
        padding: 0,
        display: 'flex',
        width: '100%',
        justifyContent: 'flex-end',
        [theme.breakpoints.down('sm')]: {
            justifyContent: 'space-between',
        },

    },
    cartButton: {
        color: 'white',
        display: 'inline-block',
        marginRight: theme.spacing(2),

    },
    tabs: {
        display: 'inline-block',
    },
    linkContainer: {
        display: 'flex',
        alignItems: 'center',

    },
    button: {
        color: 'white',
        borderColor: 'white'
    },
    typography: {
        flexGrow: 1
    },

}));


const Header = (props) => {

    const classes = useStyles();

    return (

        <HideOnScroll {...props}>
            <AppBar className={classes.root}>
                <Container maxWidth={"lg"}>
                    <Toolbar className={classes.toolbar}>
                        <IconButton
                            edge="start"
                            className={classes.menuButton}
                            color="inherit"
                            aria-label="Open drawer"
                        >
                            <MenuIcon/>
                        </IconButton>
                        <Typography
                            variant="h4"
                            className={classes.typography}

                        >
                            Kitten Paws
                        </Typography>
                        <div className={classes.linkContainer}>
                            <NavigationItems/>
                        </div>
                    </Toolbar>
                </Container>
            </AppBar>
        </HideOnScroll>
    );
};

export default Header;
