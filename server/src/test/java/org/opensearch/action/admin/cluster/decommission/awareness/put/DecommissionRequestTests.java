        String attributeValue = "zone-1";  
        {  
 */  
/*  
            DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);  
        {
            final DecommissionRequest request = new DecommissionRequest(decommissionAttribute);
            assertNull(e);  
            assertEquals(TimeValue.ZERO, request.getDelayTimeout());
        }  
            ActionRequestValidationException e = request.validate();
            String attributeName = "zone";
            assertNull(e);
        {
        {  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(deserialized.getDelayTimeout(), originalRequest.getDelayTimeout());
            String attributeValue = "";
            final DecommissionRequest request = new DecommissionRequest(decommissionAttribute);
            assertTrue(e.getMessage().contains("attribute name is missing"));
 * SPDX-License-Identifier: Apache-2.0
        {
 *
    public void testValidation() {
        }
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);
            ActionRequestValidationException e = request.validate();  
            String attributeName = null;  
            DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);
            assertNotNull(e);
            DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);  
            request.setDelayTimeout(TimeValue.timeValueSeconds(30));
            assertNotNull(e);  
            final DecommissionRequest request = new DecommissionRequest(decommissionAttribute);  
            assertEquals(DecommissionRequest.DEFAULT_NODE_DRAINING_TIMEOUT, request.getDelayTimeout());
            DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);
            assertTrue(e.getMessage().contains("attribute value is missing"));
            final DecommissionRequest request = new DecommissionRequest(decommissionAttribute);
import java.io.IOException;  
            String attributeValue = "test";  
            String attributeName = "zone";
    }
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.action.ActionRequestValidationException;
            String attributeValue = "test";
public class DecommissionRequestTests extends OpenSearchTestCase {
}
            String attributeName = "zone";
            ActionRequestValidationException e = request.validate();  
        assertEquals(deserialized.getDecommissionAttribute(), originalRequest.getDecommissionAttribute());  
 * this file be licensed under the Apache-2.0 license or a
            DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);
    public void testSerialization() throws IOException {
        final DecommissionRequest deserialized = copyWriteable(originalRequest, writableRegistry(), DecommissionRequest::new);
            ActionRequestValidationException e = request.validate();
        final DecommissionRequest originalRequest = new DecommissionRequest(decommissionAttribute);
        }
 * compatible open source license.
package org.opensearch.action.admin.cluster.decommission.awareness.put;
            final DecommissionRequest request = new DecommissionRequest(decommissionAttribute);  
        String attributeName = "zone";
            request.setNoDelay(true);
 * The OpenSearch Contributors require contributions made to  
            assertTrue(e.getMessage().contains("Invalid decommission request"));
import org.opensearch.cluster.decommission.DecommissionAttribute;
        }  
            String attributeValue = "test";  
            ActionRequestValidationException e = request.validate();  
            assertNotNull(e);
        }  
            String attributeValue = "test";
    }
            request.setNoDelay(true);
            String attributeName = "zone";
