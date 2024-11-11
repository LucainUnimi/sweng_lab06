package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@Timeout(2)
public class RankTest {

    @ParameterizedTest
    @CsvSource({
            "ASSO, DUE, DUE",
            "DUE, TRE, TRE",
            "RE, CAVALLO, RE",
            "CAVALLO, FANTE, CAVALLO",
    })
    void tresetteCompareTest(String a, String b, String expected) {
        Rank rankA = Rank.valueOf(a);
        Rank rankB = Rank.valueOf(b);
        Rank result = rankA.tresetteCompare(rankB) < 0 ? rankA : rankB;
        assertThat(result).isEqualTo(Rank.valueOf(expected));
    }
}
