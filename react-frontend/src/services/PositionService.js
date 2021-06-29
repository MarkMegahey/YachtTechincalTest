import axios from "axios";

const POSITION_REST_API_URL = 'http://localhost:8080/api/positions';
const TEAM_SIGHTINGS_REST_API_URL = 'http://localhost:8080/api/teamSightings';

class PositionService {
    getPositions(teamName) {
        return axios.get(POSITION_REST_API_URL + `?name=${teamName}`).catch(function (error) {
            console.log(error)
        });
    }

    getTeamSightings(teamName) {
        return axios.get(TEAM_SIGHTINGS_REST_API_URL + `?name=${teamName}`).catch(function (error) {
            console.log(error)
        });
    }
}

export default new PositionService()