import React from 'react';
import PositionService from '../services/PositionService';

class PositionsComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            Positions: []
        }
    }

    componentDidMount() {
        PositionService.getPositions(this.props.teamName).then((response) => {
            console.log(response);
            this.setState({ positions: response.data });
        });

        PositionService.getTeamSightings(this.props.teamName).then((response) => {
            console.log(response);
            this.setState({ positions: response.data });
        });
    }


    render() {
        return (
            <div>
                <a href="/" >Return</a>
                <h2>{this.props.teamName}</h2>
            </div >
        )
    }
}

export default PositionsComponent