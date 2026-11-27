package com.freshmart.model;

import com.freshmart.util.Validator;

/** A FreshMart staff member who manages products, stock and orders. */
public class Administrator extends User {
    private static final long serialVersionUID = 1L;

    private final String username;

    public Administrator(String username, String fullName, String plainPassword) {
        super(fullName, plainPassword);
        this.username = Validator.requireText(username, "Username").toLowerCase();
    }

    @Override
    public String getId() { return username; }

    @Override
    public String getLoginId() { return username; }

    @Override
    public Role getRole() { return Role.ADMINISTRATOR; }
}
