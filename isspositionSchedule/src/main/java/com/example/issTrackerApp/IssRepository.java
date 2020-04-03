package com.example.issTrackerApp;

import java.util.List;

public interface IssRepository {

	int saveIssPos(Iss iss);
	
	List<Iss> showAllissPos();
	
	List<Iss> showLast10issPos();
}
