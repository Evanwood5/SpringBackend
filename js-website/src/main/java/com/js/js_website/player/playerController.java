//Rest API controller
//this is where js in front end will send user when reuqest is made
//#1
package com.js.js_website.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")
public class playerController {

    private final playerService playerService1;

    @Autowired
    public playerController(playerService playerService1) {
        this.playerService1 = playerService1;
    }


    @GetMapping
    public List<player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

        if (team != null && position != null) {
            return playerService1.getPlayersByTeamAndPosition(team, position);
        }
        else if (team != null) {
            return playerService1.getPlayerFromTeam(team);
        }
        else if (name != null) {
            return playerService1.getPlayerByName(name);
        }
        else if (position != null) {
            return playerService1.getPlayersByPos(position);
        }
        else if (nation != null) {
            return playerService1.getPlayerByNation(nation);
        }
        else {
            return playerService1.getPlayers();
        }

    }

    @PostMapping
    public ResponseEntity<player> addPlayer(@RequestBody player Player) {
        player createdPlayer = playerService1.addPlayer(Player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }



    @PutMapping
    public ResponseEntity<player> updatePlayer(@RequestBody player Player) {
        player resultPlayer = playerService1.updatedPlayer(Player);
        if (resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService1.deletePlayer(playerName);
        return new ResponseEntity<>( "Player deleted successfully", HttpStatus.OK);
    }


}
