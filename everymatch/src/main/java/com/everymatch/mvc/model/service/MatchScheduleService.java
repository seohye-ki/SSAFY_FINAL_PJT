package com.everymatch.mvc.model.service;

import java.util.List;

import com.everymatch.mvc.model.dto.MatchSchedule;

public interface MatchScheduleService {

	List<MatchSchedule> getMatchScheduleByUserId(String userId);
}
