import React, {Component} from 'react';
import axios from 'axios';
import Spinner from '../UI/Spinner/Spinner';
import Container from '@material-ui/core/Container';
import Card from "@material-ui/core/Card";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import {withStyles} from '@material-ui/styles';


const styles = theme => ({
    root: {
        backgroundColor: 'rgb(255,102,102)',
    },
    card: {
        maxWidth: 345,
    },
    media: {
        height: 200,
    },
    linkContainer: {
        height: "85vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center"
    }
});


class CatFacts extends Component {

    state = {
        breeds: [],
        catPhotoUrl: "",
        catBreed: "",
        isLoading: true
    };

    componentDidMount() {

        this.loadCatPhoto();


        // const instance = axios.create({
        //     baseURL: 'https://cat-fact.herokuapp.com/',
        //     proxy: {
        //         host: '127.0.0.1',
        //         port: 9000,
        //     },
        // });


        // instance.get('facts/random?animal_type=cat&amount=1')
        //     .then(response => {
        //         console.log(response.data)
        //     }).catch(error => {
        //         console.log(error)
        //     }
        // );

    }


    loadCatPhoto = () => {
        this.setState({
            isLoading: true
        });


        axios.get('https://api.thecatapi.com/v1/images/search')
            .then(response => {
                this.setState({
                    catPhotoUrl: response.data[0].url,
                    isLoading: false
                });
                console.log(response.data[0])
            }).catch(error => {
            console.log(error)
        });


        axios.get('https://api.thecatapi.com/v1/images/search')
            .then(response => {
                this.setState({
                    catPhotoUrl: response.data[0].url,
                    isLoading: false
                });
                console.log(response.data[0])
            }).catch(error => {
            console.log(error)
        });
    };


    render() {

        let cart = <Spinner/>;

        if (!this.state.isLoading) {
            cart = (<Card className={this.props.classes.card}>
                <CardActionArea>
                    <CardMedia
                        className={this.props.classes.media}
                        image={this.state.catPhotoUrl}
                        title="cat"
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="h2">
                            Cat fact
                        </Typography>
                        <Typography variant="body2" color="textSecondary" component="p">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium architecto doloremque
                            eos est ex expedita facere possimus quo repudiandae, vero!
                        </Typography>
                    </CardContent>
                </CardActionArea>
                <CardActions>
                    <Button size="small" color="primary" onClick={this.loadCatPhoto}>
                        Get a new fact
                    </Button>
                </CardActions>
            </Card>);
        }

        return (
            <Container maxWidth={'lg'} className={this.props.classes.linkContainer}>
                {cart}
            </Container>
        )
    }
}

export default withStyles(styles)(CatFacts);