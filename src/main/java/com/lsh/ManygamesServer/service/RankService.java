package com.lsh.ManygamesServer.service;

import com.lsh.ManygamesServer.GameName;
import com.lsh.ManygamesServer.domain.Rank;
import com.lsh.ManygamesServer.dto.RankDto;
import com.lsh.ManygamesServer.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RankService {

    private final RankRepository rankRepository;

    public void save(Rank rank) {
        rankRepository.save(rank);
    }

    public void uploadRank(String name, String score, String gameName) {
        Rank rank = new Rank(name, score, convertStringToGameNameEnum(gameName));
        rankRepository.save(rank);
    }

    public List<RankDto> getRank(String gameName) {
        return rankRepository.getRank(convertStringToGameNameEnum(gameName));
    }

    public GameName convertStringToGameNameEnum(String gameName) {
        GameName _gameName;
        if (gameName.equals("Jumper")) {
            _gameName = GameName.JUMPER;
        } else if (gameName.equals(("AngryBird"))) {
            _gameName = GameName.ANGRY_BIRD;
        } else if (gameName.equals(("Nightmare"))) {
            _gameName = GameName.NIGHTMARE;
        } else if (gameName.equals(("FlappyBird"))) {
            _gameName = GameName.FLAPPY_BIRD;
        } else {
            _gameName = GameName.JUMPER;
        }
        return _gameName;
    }
}
