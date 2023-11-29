package com.lsh.ManygamesServer.domain;

import com.lsh.ManygamesServer.GameName;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rank {
    @Id
    @GeneratedValue
    @Column(name="rank_id")
    private Long id;

    private String name;
    private Long score;
    private GameName gameName;

    public Rank() {}

    public Rank(String name, String score, GameName gameName) {
        this.name = name;
        this.score = Long.parseLong(score);
        this.gameName = gameName;
    }
}
