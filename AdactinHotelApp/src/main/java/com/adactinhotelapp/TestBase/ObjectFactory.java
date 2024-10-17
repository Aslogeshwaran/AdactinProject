package com.adactinhotelapp.TestBase;

import com.adactinhotelapp.PageObjects.LandingPage;
import com.adactinhotelapp.PageObjects.SearchHotelPage;

public class ObjectFactory {

	public LandingPage getInstanceOfLandingPage() {
		return new LandingPage();
	}

	public SearchHotelPage getInstanceOfSearchHotelPage() {
		return new SearchHotelPage();
	}
}
