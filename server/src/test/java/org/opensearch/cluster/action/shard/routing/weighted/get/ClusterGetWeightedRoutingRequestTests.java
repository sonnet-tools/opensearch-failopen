 * The OpenSearch Contributors require contributions made to  
    public void testValidate_AwarenessAttributeIsEmpty() {  
        assertTrue(actionRequestValidationException.getMessage().contains("Awareness attribute is missing"));
 * compatible open source license.
        ActionRequestValidationException actionRequestValidationException = request.validate();  
        assertTrue(actionRequestValidationException.getMessage().contains("Awareness attribute is missing"));  
    }  
    }
        request.setAwarenessAttribute("");
        assertNull(actionRequestValidationException);
        request.setAwarenessAttribute("zone");  
 *
 */  
        ClusterGetWeightedRoutingRequest request = new ClusterGetWeightedRoutingRequest();  
        ClusterGetWeightedRoutingRequest request = new ClusterGetWeightedRoutingRequest();
        ActionRequestValidationException actionRequestValidationException = request.validate();
 * this file be licensed under the Apache-2.0 license or a
}
        assertNotNull(actionRequestValidationException);
    }  
        assertNotNull(actionRequestValidationException);
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.cluster.action.shard.routing.weighted.get;
        ActionRequestValidationException actionRequestValidationException = request.validate();
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;
/*  
        ClusterGetWeightedRoutingRequest request = new ClusterGetWeightedRoutingRequest();
import org.opensearch.test.OpenSearchTestCase;  
public class ClusterGetWeightedRoutingRequestTests extends OpenSearchTestCase {
import org.opensearch.action.ActionRequestValidationException;
    public void testValidate_AwarenessAttributeNotSet() {
    public void testValidate_AwarenessAttributeIsSet() {
