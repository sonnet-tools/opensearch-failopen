        long bytesWanted = 1024;  
        assertTrue("Should have bytes_limit field", metadata.containsKey("bytes_limit"));
        ObjectMap.Value durabilityValue = metadata.get("durability");
        Durability durability = Durability.TRANSIENT;
 * this file be licensed under the Apache-2.0 license or a
    public void testMetadataToProto() {
import org.opensearch.core.common.breaker.CircuitBreaker.Durability;
}
        assertEquals("durability should match", durability.toString(), durabilityValue.getString());
public class CircuitBreakingExceptionProtoUtilsTests extends OpenSearchTestCase {
import java.util.Map;  
 */  
        long byteLimit = 512;
import org.opensearch.core.common.breaker.CircuitBreakingException;
 *
/*  
 * The OpenSearch Contributors require contributions made to  
        // Verify the conversion
        ObjectMap.Value bytesWantedValue = metadata.get("bytes_wanted");
        // Convert to Protocol Buffer
        ObjectMap.Value bytesLimitValue = metadata.get("bytes_limit");  
        assertTrue("Should have durability field", metadata.containsKey("durability"));
        assertEquals("bytes_wanted should match", bytesWanted, bytesWantedValue.getInt64());  
        assertEquals("bytes_limit should match", byteLimit, bytesLimitValue.getInt64());
 * compatible open source license.
        Map<String, ObjectMap.Value> metadata = CircuitBreakingExceptionProtoUtils.metadataToProto(exception);  
        // Create a CircuitBreakingException with specific values
import org.opensearch.protobufs.ObjectMap;  
        CircuitBreakingException exception = new CircuitBreakingException("Test circuit breaking", bytesWanted, byteLimit, durability);  
        assertTrue("Should have bytes_wanted field", metadata.containsKey("bytes_wanted"));  
        // Verify field values
package org.opensearch.transport.grpc.proto.response.exceptions;
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.test.OpenSearchTestCase;
