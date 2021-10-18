package com.lti.finance.dao;

import java.util.List;

import com.lti.finance.beans.CardDetails;

public interface CardDetailsDao {
	 List<CardDetails> getCardDetails();
	 CardDetails getCardDetailsById(long user_id);
	 long addCardDetails(CardDetails card);
	 
}