package com.yachtdata.springbootbackend.controller;

import com.yachtdata.springbootbackend.model.Position;
import com.yachtdata.springbootbackend.repository.PositionRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.groupingBy;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("api/")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    public PositionController() {
    }

    @GetMapping("allPositions")
    public List<Position> getAllPositions() {
        return this.positionRepository.findAll();
    }

    @RequestMapping("positions")
    public List<Position> getPositions(@RequestParam String name) {
        return this.positionRepository.findByTeam_Name(name);
    }

    @RequestMapping("teamSightings")
    public Map<LocalDate, List<Position>> getTeamSightings(@RequestParam String name) {
        List<Position> otherTeamsPositions = this.positionRepository.findByTeam_Name_Not(name);
        List<Position> selectedTeamsPostions = this.positionRepository.findByTeam_NameOrderByGpsAtAsc(name);

        Map<LocalDate, List<Position>> selectedTeamsPositionsByDay = selectedTeamsPostions.stream()
                .collect(groupingBy((d) -> LocalDate.parse(d.getGpsAt().substring(0, 10))));

        Map<LocalDate, List<Position>> otherTeamsPositionsByDay = otherTeamsPositions.stream()
                .collect(groupingBy((d) -> LocalDate.parse(d.getGpsAt().substring(0, 10))));

        //Sort groups in DTM order
        //Find any positions in the otherTeamsPositions within the StartDTM and End DTM for each day
        //Check if positions lat/lon co-ords are within 2.9 miles of any other position if so increment sighting

        return selectedTeamsPositionsByDay;
    }
}