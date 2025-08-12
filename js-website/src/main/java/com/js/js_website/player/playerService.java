//This is the Service Layer
//this is where you will filter players or team etc
//2
package com.js.js_website.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;



@Component
public class playerService {

    private final playerRepo playerRepo;

    @Autowired
    public playerService(playerRepo playerRepo){
        this.playerRepo = playerRepo;

    }

    public List<player> getPlayers(){
        return playerRepo.findAll();

    }

    public List<player> getPlayerFromTeam(String teamName) {
        return playerRepo.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<player> getPlayerByName(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player ->player.getName().toLowerCase().contains(searchText.toLowerCase()) )
                .collect(Collectors.toList());
    }

    public List<player> getPlayersByPos(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player ->
                        player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<player> getPlayerByNation(String searchText){
        return playerRepo.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());

    }

    public List<player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepo.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && position.equals(player.getPos()))
                .collect(Collectors.toList());
    }


    public player addPlayer(player playerr){
        playerRepo.save(playerr);
        return playerr;
    }

    public player updatedPlayer(player updatedPlayer) {
        Optional<player> existingPlayer = playerRepo.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setNation(updatedPlayer.getNation());

            playerRepo.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;

    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepo.deleteByName(playerName);
    }








}
