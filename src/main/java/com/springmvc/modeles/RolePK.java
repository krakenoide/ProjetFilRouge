package com.springmvc.modeles;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class RolePK  implements Serializable {
    protected Utilisateur user;
    protected String authority;

    public RolePK() {}


	public RolePK(Utilisateur user, String authority) {
        this.user = user;
        this.authority = authority;
    }
    
    public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

    // equals, hashCode
}