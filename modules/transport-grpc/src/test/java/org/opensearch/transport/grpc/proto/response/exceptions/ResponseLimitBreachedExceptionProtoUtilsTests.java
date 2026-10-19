        assertTrue("Should have response_limit field", metadata.containsKey("response_limit"));  
        // Convert to Protocol Buffer
        ResponseLimitSettings.LimitEntity limitEntity = ResponseLimitSettings.LimitEntity.INDICES;
 * this file be licensed under the Apache-2.0 license or a
            responseLimit,
        // Verify field values  
/*  
}
        Map<String, ObjectMap.Value> metadata = ResponseLimitBreachedExceptionProtoUtils.metadataToProto(exception);  
        assertTrue("Should have limit_entity field", metadata.containsKey("limit_entity"));
        ObjectMap.Value limitEntityValue = metadata.get("limit_entity");
        // Verify the conversion
        ObjectMap.Value responseLimitValue = metadata.get("response_limit");
        int responseLimit = 10000; // Smaller value that fits in an int  
        assertEquals("response_limit should match", responseLimit, responseLimitValue.getInt32());
        // Create a ResponseLimitBreachedException with specific values
import org.opensearch.common.breaker.ResponseLimitBreachedException;
import java.util.Map;  
package org.opensearch.transport.grpc.proto.response.exceptions;
import org.opensearch.common.breaker.ResponseLimitSettings;
 *
 * compatible open source license.
    public void testMetadataToProto() {
        );  
            limitEntity
        ResponseLimitBreachedException exception = new ResponseLimitBreachedException(
import org.opensearch.protobufs.ObjectMap;  
        assertEquals("limit_entity should match", limitEntity.toString(), limitEntityValue.getString());
 * The OpenSearch Contributors require contributions made to  
 */  
public class ResponseLimitBreachedExceptionProtoUtilsTests extends OpenSearchTestCase {
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
            "Test response limit breached",  
