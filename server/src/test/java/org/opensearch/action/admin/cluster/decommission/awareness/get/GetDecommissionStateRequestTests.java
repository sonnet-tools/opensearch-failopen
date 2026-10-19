            GetDecommissionStateRequest::new
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            final GetDecommissionStateRequest request = new GetDecommissionStateRequest(attributeName);
            assertTrue(e.getMessage().contains("attribute name is missing"));
        }
        final GetDecommissionStateRequest deserialized = copyWriteable(
import org.opensearch.test.OpenSearchTestCase;
            ActionRequestValidationException e = request.validate();
    }
            ActionRequestValidationException e = request.validate();
            originalRequest,
            ActionRequestValidationException e = request.validate();  
            writableRegistry(),  
        {
        {  
 * SPDX-License-Identifier: Apache-2.0
            String attributeName = null;
            assertNull(e);
        String attributeName = "zone";
            assertNotNull(e);
        }
        final GetDecommissionStateRequest originalRequest = new GetDecommissionStateRequest(attributeName);  
        {
 *
    }  
            assertNotNull(e);  
    public void testSerialization() throws IOException {
        assertEquals(deserialized.attributeName(), originalRequest.attributeName());  
/*  
package org.opensearch.action.admin.cluster.decommission.awareness.get;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
            final GetDecommissionStateRequest request = new GetDecommissionStateRequest(attributeName);
            String attributeName = "zone";
            assertTrue(e.getMessage().contains("attribute name is missing"));  
        }
import org.opensearch.action.ActionRequestValidationException;
        );
public class GetDecommissionStateRequestTests extends OpenSearchTestCase {  
}
    public void testValidation() {  
            final GetDecommissionStateRequest request = new GetDecommissionStateRequest(attributeName);  
            String attributeName = "";  
 */  
