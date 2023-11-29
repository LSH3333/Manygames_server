package com.lsh.ManygamesServer.dto;

import com.lsh.ManygamesServer.GameName;
import com.lsh.ManygamesServer.domain.Rank;
import lombok.Data;

@Data
public class RankDto {
    private String name;
    private Long score;
    private GameName gameName;

    public RankDto() {}

    public RankDto(Rank rank) {
        this.name = rank.getName();
        this.score = rank.getScore();
        this.gameName = rank.getGameName();
    }
}
