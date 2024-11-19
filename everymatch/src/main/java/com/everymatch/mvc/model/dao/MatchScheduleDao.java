package com.everymatch.mvc.model.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.everymatch.mvc.model.dto.MatchSchedule;

public interface MatchScheduleDao {
	
	List<MatchSchedule> getMatchScheduleByUserFavoriteTeamId(String usrId);
	
	int insertMatchSchedule(MatchSchedule matchSchedule);
	
	int updateMatchSchedule(MatchSchedule matchSchedule);
	
	int deleteMatchSchedule(int matchId);
	
	List<MatchSchedule> getMatchesByTime(LocalDateTime time);
	
}