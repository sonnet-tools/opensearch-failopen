 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
public class TrustEverythingConfigFipsTests extends TrustEverythingConfigTests {  
/*  
        assertThat(e.getMessage(), containsString("not permitted in FIPS mode"));
 *
    }
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.ssl;
}  
        Exception e = assertThrows(IllegalStateException.class, TrustEverythingConfig.TRUST_EVERYTHING::createTrustManager);  
 */  
    public void testCreateTrustManager() {
import static org.hamcrest.Matchers.containsString;
 * SPDX-License-Identifier: Apache-2.0
