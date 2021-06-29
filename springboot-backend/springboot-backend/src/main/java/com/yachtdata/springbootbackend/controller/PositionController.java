package com.yachtdata.springbootbackend.controller;

import com.yachtdata.springbootbackend.model.Position;
import com.yachtdata.springbootbackend.repository.PositionRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    public PositionController() {
    }

    @GetMapping({"allPositions"})
    public List<Position> getAllPositions() {
        return this.positionRepository.findAll();
    }

    @RequestMapping({"positions"})
    public List<Position> getPositions(@RequestParam String name) {
        return this.positionRepository.findByTeam_Name(name);
    }

    @RequestMapping({"teamSightings"})
    public Map<LocalDate, List<Position>> getTeamSightings(@RequestParam String name) {
        List<Position> otherTeamsPositions = this.positionRepository.findByTeam_Name_Not(name);
        List<Position> selectedTeamsPostions = this.positionRepository.findByTeam_NameOrderByGpsAtAsc(name);
        Map<LocalDate, List<Position>> selectedTeamsPositionsByDay = (Map)selectedTeamsPostions.stream().collect(Collectors.groupingBy((d) -> {
            return LocalDate.parse(d.getGpsAt().substring(0, 10));
        }));
        Map<LocalDate, List<Position>> otherTeamsPositionsByDay = (Map)otherTeamsPositions.stream().collect(Collectors.groupingBy((d) -> {
            return LocalDate.parse(d.getGpsAt().substring(0, 10));
        }));
        return selectedTeamsPositionsByDay;
    }
}