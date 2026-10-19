        return new AuthToken() {  
     */
import org.opensearch.identity.IdentityService;  
            }
 * This class represents a Noop Token Manager
 */
            }
import org.apache.logging.log4j.LogManager;
    private static final Logger log = LogManager.getLogger(IdentityService.class);
    /**  
public class NoopTokenManager implements TokenManager {  
                return "noopToken";
 *
import org.opensearch.identity.tokens.AuthToken;
        };
        };  
 * compatible open source license.
import org.opensearch.identity.tokens.TokenManager;
import org.apache.logging.log4j.Logger;
     */  
            @Override
            @Override
    public AuthToken issueServiceAccountToken(final String audience) {
     * Issue a new Noop Token
                return "noopToken";  
import org.opensearch.identity.Subject;
/*  
    public AuthToken issueOnBehalfOfToken(final Subject subject, final OnBehalfOfClaims claims) {  
 */  
 * The OpenSearch Contributors require contributions made to  
    /**
import org.opensearch.identity.tokens.OnBehalfOfClaims;  
     * @return a new Noop Token  
     * Issue a new Noop Token
            public String asAuthHeaderValue() {  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
package org.opensearch.identity.noop;
}
/**  
    }  
            public String asAuthHeaderValue() {
        return new AuthToken() {
     * @return a new Noop Token
    @Override
 * this file be licensed under the Apache-2.0 license or a
