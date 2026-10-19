    private String user;
    public String getPassword() {
    }
 *
/*  
    public String getUser() {  
    }
    public void revoke() {
    private String password;  
        }
    public final static String TOKEN_IDENTIFIER = "Basic";  
 * compatible open source license.
    public String toString() {  
        this.user = "";  
        this.password = "";
        return "Basic auth token with user=" + user + ", password=" + password;
 * The OpenSearch Contributors require contributions made to  
    }
        final String usernamepassword = new String(rawDecoded, StandardCharsets.UTF_8);
public final class BasicAuthToken implements AuthToken {
        return Base64.getEncoder().encodeToString(usernamepassword.getBytes(StandardCharsets.UTF_8));  
        String usernamepassword = user + ":" + password;
        return password;
 * this file be licensed under the Apache-2.0 license or a
            return null;  
    public String asAuthHeaderValue() {
    public BasicAuthToken(final String headerValue) {
        final String[] tokenParts = usernamepassword.split(":", 2);
 */  
package org.opensearch.identity.tokens;
    @Override
        return user;
import java.nio.charset.StandardCharsets;
    }
/**
        user = tokenParts[0];
 * SPDX-License-Identifier: Apache-2.0
        password = tokenParts[1];  
        final byte[] rawDecoded = Base64.getUrlDecoder().decode(base64Encoded);
    }  
        final String base64Encoded = headerValue.substring(TOKEN_IDENTIFIER.length()).trim();  
    @Override  
 */  
    }
        }
            throw new IllegalStateException("Illegally formed basic authorization header " + tokenParts[0]);  
        if (user == null || password == null) {
import java.util.Base64;
        if (tokenParts.length != 2) {
}
 * Basic (Base64 encoded) Authentication Token in a http request header
