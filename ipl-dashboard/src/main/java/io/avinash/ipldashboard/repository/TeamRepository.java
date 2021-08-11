package io.avinash.ipldashboard.repository;

import io.avinash.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

    Team findByTeamName(String teamName);

}
