        assertNotNull(actionRequestValidationException);
        assertNull(actionRequestValidationException);  
        String reqString = "{\"weights\":{\"us-east-1c\": \"0\",\"us-east-1b\": \"1\",\"us-east-1a\": \"1\"}}";  
    public void testSetWeightedRoutingWeight() {
    }  
        assertNotNull(actionRequestValidationException);
        String reqString = "{\"weights\":{\"us-east-1c\":\"0\",\"us-east-1b\":\"1\",\"us-east-1a\":\"1\"},\"_version\":1}";
        assertEquals(weightedRouting, request.getWeightedRouting());  
}
        request.setWeightedRouting(new BytesArray(reqString), MediaTypeRegistry.JSON);
        ActionRequestValidationException actionRequestValidationException = request.validate();
        assertEquals(1, request.getVersion());
 */  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        ClusterPutWeightedRoutingRequest request = new ClusterPutWeightedRoutingRequest("zone");
        request.setWeightedRouting(new BytesArray(reqString), MediaTypeRegistry.JSON);
        assertTrue(  
        String reqString = "{\"weights\":{\"us-east-1c\":\"0\",\"us-east-1b\":\"1\",\"us-east-1a\": \"1\"},\"_version\":1}";
    public void testValidate_MoreThanHalfWithZeroWeight() {  
    }
import org.opensearch.cluster.routing.WeightedRouting;
        ClusterPutWeightedRoutingRequest request = new ClusterPutWeightedRoutingRequest("zone");
/*  
        Map<String, Double> weights = Map.of("us-east-1a", 1.0, "us-east-1b", 1.0, "us-east-1c", 0.0);
        assertNotNull(actionRequestValidationException);
        request.setWeightedRouting(new BytesArray(reqString), MediaTypeRegistry.JSON);  
        assertNotNull(actionRequestValidationException);
        ClusterPutWeightedRoutingRequest request = new ClusterPutWeightedRoutingRequest("zone");
        ClusterPutWeightedRoutingRequest request = new ClusterPutWeightedRoutingRequest();
        ActionRequestValidationException actionRequestValidationException = request.validate();  
        ActionRequestValidationException actionRequestValidationException = request.validate();
        assertTrue(actionRequestValidationException.getMessage().contains("Attribute name is missing"));  
 * SPDX-License-Identifier: Apache-2.0
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
    }  
            actionRequestValidationException.getMessage().contains("Maximum expected number of routing weights having zero weight is [1]")
        );
    }
 * The OpenSearch Contributors require contributions made to  
        ClusterPutWeightedRoutingRequest request = new ClusterPutWeightedRoutingRequest("zone");  
        ClusterPutWeightedRoutingRequest request = new ClusterPutWeightedRoutingRequest("zone");
    }
 *
        ActionRequestValidationException actionRequestValidationException = request.validate();
    public void testValidate_AttributeMissing() {  
    public void testValidate_VersionMissing() {
public class ClusterPutWeightedRoutingRequestTests extends OpenSearchTestCase {  
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
        request.setWeightedRouting(new BytesArray(reqString), MediaTypeRegistry.JSON);  
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.common.bytes.BytesArray;  
    public void testValidate_MissingWeights() {  
 * this file be licensed under the Apache-2.0 license or a
    }
        String reqString = "{}";
        assertTrue(actionRequestValidationException.getMessage().contains("Version is missing"));
        request.setWeightedRouting(new BytesArray(reqString), MediaTypeRegistry.JSON);  
        request.setWeightedRouting(new BytesArray(reqString), MediaTypeRegistry.JSON);
import java.util.Map;
        assertTrue(actionRequestValidationException.getMessage().contains("Weights are missing"));  
        String reqString = "{\"weights\":{\"us-east-1c\":\"0\",\"us-east-1b\":\"1\",\"us-east-1a\":\"1\"},\"_version\":1}";  
        String reqString = "{\"weights\":{\"us-east-1c\":\"0\",\"us-east-1b\":\"0\",\"us-east-1a\": \"1\"}," + "\"_version\":1}";
import org.opensearch.core.xcontent.MediaTypeRegistry;
        ActionRequestValidationException actionRequestValidationException = request.validate();
    public void testValidate_ValuesAreProper() {
