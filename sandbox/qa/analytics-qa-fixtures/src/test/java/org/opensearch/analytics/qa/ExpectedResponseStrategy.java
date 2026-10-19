     * Equivalent to validateExpected=false in the old API.
/**
    SKIP_VALIDATION  
    /**
public enum ExpectedResponseStrategy {
/*  
    FAIL_ON_MISSING,  
     * Fail the test if expected response file is missing.  
 * The OpenSearch Contributors require contributions made to  
     */
    PASS_ON_MISSING,  
 * Strategy for handling missing expected response files.
 * SPDX-License-Identifier: Apache-2.0
     */
     * Use this to enforce that all queries have expected responses.
 */  
 * compatible open source license.
     * Skip validation entirely - only check for 200 response.  
     */
 *
}
    /**
    /**
package org.opensearch.analytics.qa;
 */  
     * Default behavior: Execute query and verify 200 response with non-empty result.  
     * Does NOT fail if expected response file is missing.
 * this file be licensed under the Apache-2.0 license or a
