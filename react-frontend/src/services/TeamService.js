import axios from "axios";

const TEAMS_REST_API_URL = 'http://localhost:8080/api/allTeams';
// You can also use the team name to fetch a specific team using the following URL
// const TEAM_REST_API_URL = 'http://localhost:8080/api/team';

class TeamService {
    getTeams() {
        return axios.get(TEAMS_REST_API_URL).catch(function (error) {
            console.log(error)
        });
    }
}

export default new TeamService()