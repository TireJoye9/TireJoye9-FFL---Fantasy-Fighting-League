package com.example.ffl.fighter;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Fighter {
    /*
    @GeneratedValue(strategy=GenerationType.AUTO)
    private @Nullable Integer id;
    */
    @Id
    private String name;

    @Nullable
    private String nickName;

    private Integer age;

    private String country;

    private String stance;

    private String weightClass;

    private Integer height;

    private Integer wins;

    private Integer losses;

    private Integer totalFights;

    private Integer reach;

    public String getWeightClass() {return weightClass;}
    public void setWeightClass(String weightClass) {this.weightClass = weightClass;}

    public Integer getHeight() {return height;}
    public void setHeight(Integer height) {this.height = height;}

    public String getStance() {return stance;}
    public void setStance(String martialArt) {this.stance = martialArt;}

    /*
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    */
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getCountry() {return country;}
    public void setCountry(String nationality) {this.country = nationality;}

    public String getNickName() {return nickName;}
    public void setNickName(String nickName) {this.nickName = nickName;}

    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}

    public Integer getWins() {return wins;}
    public void setWins(Integer wins) {this.wins = wins;}

    public Integer getLosses() {return losses;}
    public void setLosses(Integer losses) {this.losses = losses;}

    public Integer getTotalFights() {return totalFights;}
    public void setTotalFights(Integer totalFights) {this.totalFights = totalFights;}

    public Integer getReach() {return reach;}
    public void setReach(Integer reach) {this.reach = reach;}

    //Constructors
    public Fighter(String name)
    {
        this.name = name;
    }
    public Fighter() {}


}