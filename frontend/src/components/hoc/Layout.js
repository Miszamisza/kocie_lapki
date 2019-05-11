import React, {Component} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'
import Header from '../header/Header';

class Layout extends Component {

    render() {
        return (
            <>
                <Header/>
                <main>
                    {this.props.children}
                </main>
            </>
        );
    }
}

export default Layout;