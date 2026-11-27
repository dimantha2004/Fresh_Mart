package com.freshmart.model;

import com.freshmart.repository.Identifiable;
import com.freshmart.util.PasswordHasher;
import com.freshmart.util.Validator;

import java.io.Serializable;

/**
 * Common base for everyone who can log in. Subclasses decide which value identifies them at the
 * login screen (email for customers, username for administrators) and what role they play.
 */
public abstract class User implements Identifiable, Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String passwordHash;

    protected User(String fullName, String plainPassword) {
        setFullName(fullName);
        changePassword(plainPassword);
    }

    /** The value typed into the login form to identify this user. */
    public abstract String getLoginId();

    public abstract Role getRole();

    public boolean checkPassword(String plainPassword) {
        return PasswordHasher.matches(plainPassword, passwordHash);
    }

    public final void changePassword(String plainPassword) {
        this.passwordHash = PasswordHasher.hash(Validator.password(plainPassword));
    }

    public String getFullName() { return fullName; }

    public final void setFullName(String fullName) { this.fullName = Validator.fullName(fullName); }

    public enum Role { ADMINISTRATOR, CUSTOMER }
}
