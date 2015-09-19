package com.softserve.edu.counters.data;

public class UrlRepository {

	public static enum Urls {
		LOCAL_HOST("http://localhost:8080/#/start");
		//SSU_HOST("http://ssu-oms:8180/OMS/login.htm");

		private String field;

		private Urls(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

}
