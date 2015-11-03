package com.softserve.edu.entity;

public class OrganizationDB {
	 public static enum OrganizationDBQueries {
//	        INSERT_USER_BY_LOGIN("INSERT INTO dbo.Users (Login, Password, FirstName, LastName, Email, RegionRef, RoleRef) VALUES ('%s', '%s', '%s', '%s', '%s', %s, %s);"),
//	        GET_USER_BY_LOGIN("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE Login = '%s';"),
	        GET_ALL_ORGANIZATIONS("SELECT * FROM organization;");
//	        DELETE_USER_BY_ID("DELETE dbo.Users WHERE ID='%s';"),
//	        DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE '%s%%';");
	        private String query;

	        private OrganizationDBQueries(String query) {
	            this.query = query;
	        }

	        @Override
	        public String toString() {
	            return query;
	        }
	    }
	 private long id;
	 private String building;
	 private String district;
	 private String flat;
	 private String locality;
	 private String region;
	 private String street;
	 private String email;
	 private String name;
	 private String phone;
	 private long organizationId;
	 
	 public OrganizationDB(long id,String building, String district, String flat, String locality,	 String region,	 String street,	String email, String name,
			 String phone, long organizationId){
		         this.building = building;
				 this.district = district;
				 this.flat = flat;
				 this.locality = locality;
				 this.region = region;
				 this.street = street;
				 this.email = email;
				 this.name = name;
				 this.phone = name;
				 this.organizationId = organizationId;
	 }

	

	public void setId(long id) {
		this.id = id;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	 
	//----getters
	public long getId() {
		return id;
	}

	public String getBuilding() {
		return building;
	}

	public String getDistrict() {
		return district;
	}

	public String getFlat() {
		return flat;
	}

	public String getLocality() {
		return locality;
	}

	public String getRegion() {
		return region;
	}

	public String getStreet() {
		return street;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public long getOrganizationId() {
		return organizationId;
	}
}
