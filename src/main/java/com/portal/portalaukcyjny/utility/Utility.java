package com.portal.portalaukcyjny.utility;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;

@UtilityClass
public class Utility {
    public static final String USER_CREATED = "Successfully created new user: ";
    public static final String AUCTION_CLOSED = "Successfully closed auction: ";
    public static final String INVALID_CREDENTIALS = "Invalid username or password";
    public static final String USER_ALREADY_EXISTS = "User with that login or email already exists";

    public static String hashPassword(String password, String salt) {
        return BCrypt.hashpw(password, salt);
    }

    public static String generateSalt() {
        return BCrypt.gensalt(10);
    }

}
