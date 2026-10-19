    public AuthToken issueServiceAccountToken(final String audience);
}  
 * This interface defines the expected methods of a token manager
    public AuthToken issueOnBehalfOfToken(final Subject subject, final OnBehalfOfClaims claims);  
public interface TokenManager {
import org.opensearch.identity.Subject;
     * @param audience: A string representing the unique id of the extension for which a service account token should be generated
     * @param claims: A list of claims for the token to be generated with  
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi  
     * @return a new auth token  
 */  
 *  
 * compatible open source license.
 */
     * Create a new on behalf of token
     */
/**
 *
/*  
     * Create a new service account token  
     * @return A new auth token
    /**
 * this file be licensed under the Apache-2.0 license or a
     *
 * @opensearch.experimental
     */
    /**  
package org.opensearch.identity.tokens;
     *
