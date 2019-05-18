import React from 'react';
// import LockOutlinedIcon from "@material-ui/core/SvgIcon";
import Button from "@material-ui/core/Button";
import {FACEBOOK_AUTH_URL, GITHUB_AUTH_URL, GOOGLE_AUTH_URL} from "../../../../constants/index";
import Typography from "@material-ui/core/Typography";
import TextField from "@material-ui/core/TextField";
import Link from "@material-ui/core/Link";
import Container from "@material-ui/core/Container";
import makeStyles from "@material-ui/core/styles/makeStyles";
import {FaFacebookSquare, FaGithub, FaGoogle} from "react-icons/fa";
import {Link as LinkProvider} from 'react-router-dom';

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

    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },

    form: {
        width: '100%',
        marginTop: theme.spacing(1),
    },

    submit: {
        margin: theme.spacing(3, 0, 2),
    },

    socialButtonContainer: {
        width: "20rem",
        marginBottom: theme.spacing(1),

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
        marginBottom: '10px',
        position: "relative",
        display: "block",
        fontSize: "1em",
        width: "100%"
    },

    separatorText: {
        position: "absolute",
        left: "46%",
        top: "0",
        backgroundColor: "rgb(250,250,250)",
        padding: "10px",
    }

}));


const LoginForm = (props) => {

    const classes = useStyles();

    return (
        <Container component="section" className={classes.root}>
            <div className={classes.paper}>
                <Button component={"a"}
                        href={GOOGLE_AUTH_URL}
                        fullWidth
                        variant="outlined"
                        className={classes.socialButton}
                >
                    <FaGoogle className={classes.googleIcon}/>
                    <Typography
                        className={classes.textButton}
                    >
                        Sign in with Google
                    </Typography>
                </Button>
                <Button
                    component={"a"}
                    href={FACEBOOK_AUTH_URL}
                    fullWidth
                    variant="outlined"
                    className={classes.socialButton}
                >
                    <FaFacebookSquare className={classes.facebookIcon}/>
                    <Typography
                        className={classes.textButton}
                    >
                        Sign in with Facebook
                    </Typography>
                </Button>
                <Button
                    component={"a"}
                    href={GITHUB_AUTH_URL}
                    fullWidth
                    variant="outlined"
                    className={classes.socialButton}

                >
                    <FaGithub/>
                    <Typography
                        className={classes.textButton}
                    >
                        Sign in with Github
                    </Typography>
                </Button>
                <div className={classes.separator}>
                    <span className={classes.separatorText}>OR</span>
                </div>
                <form className={classes.form} onSubmit={props.submitHandler} noValidate>

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
                        Sign In
                    </Button>
                    <Link component={LinkProvider} to="/signup" variant="body2">
                        {"Don't have an account? Sign Up"}
                    </Link>
                </form>
            </div>
        </Container>
    );
};

export default LoginForm;