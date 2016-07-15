package com.netanel.coupons.jbeans;

import java.util.Set;

import com.netanel.coupons.crypt.Password;

public class Company {
	//
	// Attributes
	//
	private long id = -1;
	private String compName;
	private Password password;
	private String email;
	private Set<Coupon> coupons;
	
	
	//
	// Constructors
	//
	public Company() { }
	
	public Company(String compName, Password password, String email, Set<Coupon> coupons) {
		this.compName = compName;
		this.password = password;
		this.email = email;
		this.coupons = coupons;
	}
	
	public Company(long id, String compName, Password password, String email, Set<Coupon> coupons) {
		this(compName, password, email, coupons);
		this.id = id;
	}

	//
	// Functions
	//
	public long getId() {
		return id;
	}

	public String getCompName() {
		return compName;
	}

	public Password getPassword() {
		return password;
	}
	

	public String getEmail() {
		return email;
	}


	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setId(long id) {
		if (this.id == -1) { 
			this.id = id;
		} else {
			throw new IllegalArgumentException("ID already set" + this.id);
		}
	}
	
	public void setCompName(String compName) {
		this.compName = compName;
	}

	public void setPassword(char[] password) {
		this.password.setNewPassword(password);
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}


	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

//	public String[] getDetails() {
//		String[] detail = {String.valueOf(getId()), getCompName(), getEmail(), String.valueOf(getCoupons().size())};
//		return detail;
//	}
	
	public Object[] getDetails() {
		Object[] detail = {getId(), getCompName(), getEmail(), getCoupons().size()};
		return detail;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email
				+ ", coupons=" + coupons + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compName == null) ? 0 : compName.hashCode());
		result = prime * result + ((coupons == null) ? 0 : coupons.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Company other = (Company) obj;
		if (compName == null) {
			if (other.compName != null) {
				return false;
			}
		} else if (!compName.equals(other.compName)) {
			return false;
		}
		if (coupons == null) {
			if (other.coupons != null) {
				return false;
			}
		} else if (!coupons.equals(other.coupons)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}




	

	
	
}
