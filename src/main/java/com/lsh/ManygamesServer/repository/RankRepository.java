package com.lsh.ManygamesServer.repository;

import com.lsh.ManygamesServer.GameName;
import com.lsh.ManygamesServer.domain.Rank;
import com.lsh.ManygamesServer.dto.RankDto;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RankRepository {
    private final EntityManager em;

    public void save(Rank rank) {
        em.persist(rank);
    }

    public List<RankDto> getRank(GameName gameName) {
        int ordinal = gameName.ordinal();

        List<Rank> resultList = em.createQuery("SELECT r FROM Rank r WHERE r.gameName = :gameName ORDER BY r.score DESC", Rank.class)
                .setParameter("gameName", gameName)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();

        List<RankDto> rankDtoList = new ArrayList<>();
        for (Rank rank : resultList) {
            rankDtoList.add(new RankDto(rank));
        }
        return rankDtoList;
    }

}
