package com.lsh.ManygamesServer.controller;

import com.lsh.ManygamesServer.dto.RankDto;
import com.lsh.ManygamesServer.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    /**
     * 점수 추가
     */
    @PostMapping("/rank/uploadRank")
    public String uploadRank(@RequestParam String name, @RequestParam String score, @RequestParam String gameName) {
        rankService.uploadRank(name, score, gameName);
        return "SUCCESS";
    }

    /**
     * gameName 에 해당하는 게임의 랭킹 결과를 리턴한다
     * @param gameName : 게임의 이름
     * @return : gameName 에 해당하는 게임의 1~10위 랭킹 결과
     */
    @GetMapping("/rank/getRank")
    public List<RankDto> getRank(@RequestParam String gameName) {
        return rankService.getRank(gameName);
    }
}
