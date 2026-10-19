     * @param aud the Audience for the token
import org.opensearch.common.annotation.ExperimentalApi;
     */
 * SPDX-License-Identifier: Apache-2.0
        this.audience = aud;  
    public OnBehalfOfClaims(String aud, Long expiration_seconds) {
 * this file be licensed under the Apache-2.0 license or a
     * @param subject the subject of the token
 * The OpenSearch Contributors require contributions made to  
}
    public String getAudience() {
    }
public class OnBehalfOfClaims {  
 */
    }
        this.expiration_seconds = expiration_seconds;
     * A constructor which sets the default expiration time of 5 minutes from the current time
    /**
 */  
    public Long getExpiration() {
        return expiration_seconds;  
     * @param expiration_seconds the length of time in seconds the token is valid
 *
        return audience;
    }  
    private final Long expiration_seconds;  
    }
 * compatible open source license.
    private final String audience;
    public OnBehalfOfClaims(String aud, String subject) {  
    /**
 * This class represents the claims of an OnBehalfOf token.
     */
 * @opensearch.experimental  
 *
@ExperimentalApi
/*  
        this(aud, 300L);
/**  
package org.opensearch.identity.tokens;
     * @param aud the Audience for the token  
     * Constructor for OnBehalfOfClaims  
