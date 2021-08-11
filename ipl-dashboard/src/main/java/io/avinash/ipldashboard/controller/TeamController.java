package io.avinash.ipldashboard.controller;

import io.avinash.ipldashboard.model.Team;
import io.avinash.ipldashboard.repository.MatchRepository;
import io.avinash.ipldashboard.repository.TeamRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;


    public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {

        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchByTeam(teamName, 4));
        return team;

    }


}
