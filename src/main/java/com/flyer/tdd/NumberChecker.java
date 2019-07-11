package com.flyer.tdd;

import com.flyer.tdd.entities.MatchResult;
import com.flyer.tdd.interfaces.MatchChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A number checker that invokes multiple sub checkers to render check results
 *
 * e.g. target [2, 3, 5 1], input [2, 1, 4, 3], output {1, A, 3, B}
 *
 * @author sg.ruifeng.ma
 * @since 2019-Jul-10
 */

public class NumberChecker {

    private List<MatchChecker> checkerList;
    private List<MatchResult> resultList;

    public NumberChecker(List<MatchChecker> checkerList) {
        this.checkerList = checkerList;
        this.resultList = new ArrayList<>();
    }

    public List<MatchResult> check(int[] source, int[] target) {
        checkerList.stream().forEach(checker -> this.resultList.add(checker.check(source, target)));
        return this.resultList;
    }

    public String print() {
        return this.resultList.stream().map(MatchResult::print).collect(Collectors.joining(" "));
    }
}
