package com.freshmart.util;

import com.freshmart.exception.ValidationException;

import java.util.regex.Pattern;

/** Field-level validation rules shared by the model classes and services. */
public final class Validator {

    // Sri Lankan NIC: old format is 9 digits + V/X, new format is 12 digits.
    private static final Pattern NIC = Pattern.compile("^(\\d{9}[VvXx]|\\d{12})$");
    private static final Pattern EMAIL = Pattern.compile("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");
    // Sri Lankan phone number: 0XXXXXXXXX or +94XXXXXXXXX.
    private static final Pattern PHONE = Pattern.compile("^(0|\\+94)\\d{9}$");

    private Validator() { }

    public static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new ValidationException(fieldName + " is required.");
        }
        return value.trim();
    }

    public static String nic(String value) {
        String nic = requireText(value, "NIC").toUpperCase();
        if (!NIC.matcher(nic).matches()) {
            throw new ValidationException("NIC must be 9 digits followed by V/X, or 12 digits.");
        }
        return nic;
    }

    public static String email(String value) {
        String email = requireText(value, "Email address").toLowerCase();
        if (!EMAIL.matcher(email).matches()) {
            throw new ValidationException("Email address is not valid.");
        }
        return email;
    }

    public static String phone(String value) {
        String phone = requireText(value, "Contact number").replace(" ", "");
        if (!PHONE.matcher(phone).matches()) {
            throw new ValidationException("Contact number must look like 0771234567 or +94771234567.");
        }
        return phone;
    }

    public static String fullName(String value) {
        String name = requireText(value, "Full name");
        if (name.length() < 3) throw new ValidationException("Full name must have at least 3 characters.");
        return name;
    }

    /** Passwords need 8+ characters with at least one letter and one digit. */
    public static String password(String value) {
        if (value == null || value.length() < 8
                || !value.chars().anyMatch(Character::isLetter)
                || !value.chars().anyMatch(Character::isDigit)) {
            throw new ValidationException("Password must be at least 8 characters and contain a letter and a digit.");
        }
        return value;
    }
}
