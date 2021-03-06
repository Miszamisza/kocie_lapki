import React from 'react';
import PropTypes from 'prop-types';
import useScrollTrigger from '@material-ui/core/useScrollTrigger';
import Slide from '@material-ui/core/Slide';

function HideOnScroll(props) {
    const {children} = props;
    const trigger = useScrollTrigger();

    return (
        <Slide direction="down" appear={false} in={!trigger} threshold={1000}>
            {children}
        </Slide>
    );
}

HideOnScroll.propTypes = {
    children: PropTypes.node.isRequired,
};

export default HideOnScroll;