package com.softserve.edu.counters.data;

public class AttributeRepository {
	
	public static enum Attribute {
		CLASS("class");

		private String field;

		private Attribute(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

}
