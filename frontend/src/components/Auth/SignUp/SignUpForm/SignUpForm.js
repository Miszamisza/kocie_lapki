import React from 'react';
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import makeStyles from "@material-ui/core/styles/makeStyles";


const useStyles = makeStyles(theme => ({

    root: {
        height: '100vh',
        display: 'flex',
        justifyContent: 'center'
    },

    paper: {
        width: '20rem',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },

    form: {
        width: '100%',
        marginTop: theme.spacing(1),
    },

    submit: {
        margin: theme.spacing(3, 0, 2),
    },

    socialButton: {
        display: 'flex',
        justifyContent: "left",
        padding: "10px 20px",
        marginBottom: theme.spacing(2),
    },

    facebookIcon: {
        color: "#3C5A99",
        size: "100px"
    },

    googleIcon: {
        color: "#4285F4",
        size: "100px"
    },

    textButton: {
        textTransform: "none",
        width: "100%",
        textAlign: "center"
    },

    separator: {
        borderBottom: "1px solid #eee",
        padding: "10px 0",
        marginBottom:'10px',
        position: "relative",
        display: "block",
        fontSize: "1em",
        width:"100%"
    },

    separatorText: {
        position: "absolute",
        left: "46%",
        top: "0",
        backgroundColor: "rgb(250,250,250)",
        padding: "10px",
    }

}));


const SignUpForm = (props) => {

    const classes = useStyles();

    return (
        <Container component="section" className={classes.root}>
            <div className={classes.paper}>
                <form className={classes.form} onSubmit={props.submitHandler} noValidate>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="name"
                        label="Name"
                        type="name"
                        id="name"
                        autoComplete="name"
                        onChange={props.changedName}
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Email Address"
                        name="email"
                        autoComplete="email"
                        autoFocus
                        onChange={props.changedEmail}
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        autoComplete="current-password"
                        onChange={props.changedPassword}
                    />
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                    >
                        Sign Up
                    </Button>
                </form>
            </div>
        </Container>
    );
};

export default SignUpForm;