//Entity Class

package com.js.js_website.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prem_stats")
public class player {


    @Id
    @Column(name= "player", unique=true)

    private String name;

    private String nation;

    private String pos;

    private Float age;

    private Float starts;

    private Float min;

    private Float gls;

    private Float ast;

    private Float pk;

    private Float crdy;

    private Float crdr;

    private Float xg;

    private Float xag;

    private String team;

    public player() {
    }

    public player(String team, Float xag, Float xg, Float crdr, Float crdy, Float pk, Float ast, Float gls, Float min, Float starts, Float age, String pos, String nation, String name) {
        this.team = team;
        this.xag = xag;
        this.xg = xg;
        this.crdr = crdr;
        this.crdy = crdy;
        this.pk = pk;
        this.ast = ast;
        this.gls = gls;
        this.min = min;
        this.starts = starts;
        this.age = age;
        this.pos = pos;
        this.nation = nation;
        this.name = name;
    }



    public player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getPos() {
        return pos;
    }

    public Float getAge() {
        return age;
    }

    public Float getStarts() {
        return starts;
    }

    public Float getMin() {
        return min;
    }

    public Float getGls() {
        return gls;
    }

    public Float getAst() {
        return ast;
    }

    public Float getPk() {
        return pk;
    }

    public Float getCrdy() {
        return crdy;
    }

    public Float getCrdr() {
        return crdr;
    }

    public Float getXg() {
        return xg;
    }

    public Float getXag() {
        return xag;
    }

    public String getTeam() {
        return team;
    }

    //setters below


    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public void setStarts(Float starts) {
        this.starts = starts;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public void setGls(Float gls) {
        this.gls = gls;
    }

    public void setAst(Float ast) {
        this.ast = ast;
    }

    public void setPk(Float pk) {
        this.pk = pk;
    }

    public void setCrdy(Float crdy) {
        this.crdy = crdy;
    }

    public void setCrdr(Float crdr) {
        this.crdr = crdr;
    }

    public void setXg(Float xg) {
        this.xg = xg;
    }

    public void setXag(Float xag) {
        this.xag = xag;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
