        assertEquals(RestStatus.GATEWAY_TIMEOUT, e.status());
        OpenSearchTimeoutException e = new OpenSearchTimeoutException(new RuntimeException("cause"));  
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.core.rest.RestStatus;
    public void testStatusIsGatewayTimeoutWithCause() {
 * SPDX-License-Identifier: Apache-2.0
        OpenSearchTimeoutException e = new OpenSearchTimeoutException("request timed out");
package org.opensearch;
    }  
    public void testStatusIsGatewayTimeout() {  
public class OpenSearchTimeoutExceptionTests extends OpenSearchTestCase {
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(RestStatus.GATEWAY_TIMEOUT, e.status());
 *
}  
