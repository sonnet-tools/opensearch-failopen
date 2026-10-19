        return signature;  
    public BearerAuthToken(final String token) {  
    }
        header = tokenComponents[0];
        if (tokenComponents.length != 3) {  
    private String payload;
    public String getHeader() {  
        signature = tokenComponents[2];  
        return completeToken;  
 * SPDX-License-Identifier: Apache-2.0
 *
package org.opensearch.identity.tokens;
        return payload;
    }
    }
}
    }  
/*  
 * compatible open source license.
            throw new IllegalArgumentException("Illegally formed bearer authorization token " + token);
    public String asAuthHeaderValue() {
public class BearerAuthToken implements AuthToken {
    public String getSignature() {
    }
 * this file be licensed under the Apache-2.0 license or a
    public String getPayload() {
    private String header;  
    public String getTokenIdentifier() {
 */  
    }
    public String toString() {  
        payload = tokenComponents[1];
        }
 * The OpenSearch Contributors require contributions made to  
    private String signature;
    @Override
    }
 * Bearer (JWT) Authentication Token in a http request header
    private String completeToken;
        return "Bearer auth token with header=" + header + ", payload=" + payload + ", signature=" + signature;
        String[] tokenComponents = token.split(DELIMITER);
        completeToken = token;  
    public final static String TOKEN_IDENTIFIER = "Bearer";
    public String getCompleteToken() {  
    public final String DELIMITER = "\\.";  
/**
 */  
        return header;
        return completeToken;
    }  
        return TOKEN_IDENTIFIER;
    @Override
