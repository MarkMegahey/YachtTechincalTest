package com.yachtdata.springbootbackend.controller;

import com.yachtdata.springbootbackend.model.Team;
import com.yachtdata.springbootbackend.repository.TeamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = {"http://localhost:3000/"}
)
@RestController
@RequestMapping({"api/"})
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    public TeamController() {
    }

    @GetMapping({"allTeams"})
    public List<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }

    @RequestMapping({"team"})
    public Team getTeam(@RequestParam String name) {
        return this.teamRepository.findByName(name);
    }
}
