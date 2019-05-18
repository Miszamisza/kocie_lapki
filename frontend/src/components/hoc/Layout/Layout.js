import React from 'react';
import Header from '../../header/Header';
import makeStyles from "@material-ui/core/styles/makeStyles";

const useStyles = makeStyles(theme => ({
    main: {
        marginTop: theme.spacing(12)
    }
}));

const Layout = props => {

    const classes = useStyles();

    return (
        <>
            <Header/>
            <main className={classes.main}>
                {props.children}
            </main>
        </>
    );
};

export default Layout;