import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    useParams,
} from "react-router-dom";

import TeamService from '../services/TeamService';
import PositionsComponent from './PositionComponent';

class TeamComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            teams: []
        }
    }

    componentDidMount() {
        TeamService.getTeams().then((response) => {
            this.setState({ teams: response.data });
        });
    }

    render() {
        return (
            <Router>
                <Switch>
                    <Route path={`/:teamName`}>
                        <Team />
                    </Route>
                    <Route path="/">
                        <Home teams={this.state.teams} />
                    </Route>
                </Switch>
            </Router>


        )
    }
}



const Home = (props) => {
    return (
        <div className="table-responsive">
            <table className="table table-dark table-striped">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Team Name</th>
                        <th scope="col">Marker</th>
                        <th scope="col">Serial</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        props.teams.map((team, i) => {
                            const teamLink = `/${team.name}`
                            return (
                                <tr>
                                    <th scope="row">{i + 1}</th>
                                    <td><a href={teamLink}>{team.name}</a></td>
                                    <td>{team.marker}</td>
                                    <td>{team.serial}</td>
                                </tr>
                            );
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}



const Team = () => {
    let { teamName } = useParams();

    return (
        <PositionsComponent teamName={teamName} />
    );
}


export default TeamComponent
