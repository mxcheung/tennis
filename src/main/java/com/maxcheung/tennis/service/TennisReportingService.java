package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.TennisMatch;

public interface TennisReportingService {

    public String reportCurrentGameScore(TennisMatch tennisMatch);

    public String reportCurrentSetScore(TennisMatch tennisMatch);

    public String reportMatchScore(TennisMatch tennisMatch);

}
