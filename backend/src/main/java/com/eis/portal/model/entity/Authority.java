package com.eis.portal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Александр on 18.10.2015.
 */
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    private String username;

    @Column
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public Authority() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority1 = (Authority) o;

        if (username != null ? !username.equals(authority1.username) : authority1.username != null) return false;
        return !(authority != null ? !authority.equals(authority1.authority) : authority1.authority != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
