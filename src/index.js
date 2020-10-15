import { requireNativeComponent } from 'react-native';
import React, { Component } from 'react';

var PincruxComponent = requireNativeComponent('Pincrux');

export default class RNPincurx extends Component{
    _component;

    constructor(props) {
        super(props);

        this.state = {
            height : props.height,
            intervalCount : 0,
            componentInterval : setInterval(this.intervalCallback, 1000)
        };
    }

    componentWillUnmount(){
        clearInterval(this.state.componentInterval);
    }

    intervalCallback = () => {
        if(this.state.intervalCount > 10)
        {
            clearInterval(this.state.componentInterval);
        }
        if(this._component !== null)
        {
            this._component.measureInWindow(this.getMeasure);
        }
        
        let newIntervalCount = this.state.intervalCount + 1;
        this.setState({intervalCount : newIntervalCount});
    }

    getMeasure = (_,__,___,____) => {
        if(this.state.height !== 0)
        {

            let newHeight = this.state.intervalCount % 2 === 0 ? this.state.height - 1 : this.state.height + 1;
            this.setState({height:newHeight});
        }
    }

    render(){
        return (
            <PincruxComponent ref={comp=>{ this._component = comp }} user={this.props.user} style={this.props.style} height={this.state.height} />
        );
    }
}