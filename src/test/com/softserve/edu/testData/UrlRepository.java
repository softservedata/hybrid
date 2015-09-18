package com.softserve.edu.testData;
public class UrlRepository {

    public static enum Urls {
		LOCAL_HOST("http://127.0.0.1:8080/");
		

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