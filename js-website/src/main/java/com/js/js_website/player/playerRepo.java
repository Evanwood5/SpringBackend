//Data Access Layer (actually going into postgres)
//puiblic interface is using CRUD import stuff for findall() etc
//3
// com/js/js_website/player/playerRepo.java
package com.js.js_website.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface playerRepo extends JpaRepository<player, String> {

    void deleteByName(String playerName);

    Optional<player> findByName(String name);
    Optional<player> findByNameIgnoreCase(String name);

    // NEW
    List<player> findByTeamIgnoreCase(String team);

    // NEW (team + position filter)
    List<player> findByTeamIgnoreCaseAndPosIgnoreCase(String team, String pos);

    // NEW (single filters used by your controller)
    List<player> findByPosIgnoreCase(String pos);

    List<player> findByNationIgnoreCase(String nation);
}
