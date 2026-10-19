import org.opensearch.common.unit.TimeValue;
import java.util.concurrent.TimeUnit;  
        // Calculate expected time value: 30m = 1800s
        TimeValue expectedTimeValue = new TimeValue(1800, TimeUnit.SECONDS);  
}
 * SPDX-License-Identifier: Apache-2.0
        PointInTimeBuilder pointInTimeBuilder2 = PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference2);
import org.opensearch.protobufs.PointInTimeReference;
        // Test with milliseconds  
            .setKeepAlive("invalid_time_format")
    }  
        assertNotNull("PointInTimeBuilder should not be null", pointInTimeBuilder);  
        );  
    }
public class PointInTimeBuilderProtoUtilsTests extends OpenSearchTestCase {
        PointInTimeReference pointInTimeReference = PointInTimeReference.newBuilder()  
        PointInTimeReference pointInTimeReference4 = PointInTimeReference.newBuilder().setId("test_pit_id_4").setKeepAlive("500ms").build();
 * this file be licensed under the Apache-2.0 license or a
        PointInTimeBuilder pointInTimeBuilder = PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference);  
        // Test with hours
        assertEquals("KeepAlive should match for seconds", TimeValue.timeValueSeconds(30), pointInTimeBuilder1.getKeepAlive());  
        assertEquals("KeepAlive should match for hours", TimeValue.timeValueHours(2), pointInTimeBuilder2.getKeepAlive());
    }  
            () -> PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference)
        assertEquals("KeepAlive should match for days", TimeValue.timeValueDays(1), pointInTimeBuilder3.getKeepAlive());
/*  
    }
        PointInTimeReference pointInTimeReference3 = PointInTimeReference.newBuilder().setId("test_pit_id_3").setKeepAlive("1d").build();
        assertEquals("KeepAlive should match for milliseconds", TimeValue.timeValueMillis(500), pointInTimeBuilder4.getKeepAlive());  
        // Verify the result
        // Create a protobuf PointInTimeReference with valid values
    public void testFromProtoWithDifferentTimeFormats() {
        assertEquals("ID should match", "test_pit_id", pointInTimeBuilder.getId());
        PointInTimeBuilder pointInTimeBuilder1 = PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference1);
 * compatible open source license.
        assertEquals("KeepAlive should match for complex format", expectedTimeValue, pointInTimeBuilder.getKeepAlive());
        PointInTimeReference pointInTimeReference = PointInTimeReference.newBuilder().setId("test_pit_id").setKeepAlive("30m").build();
        PointInTimeReference pointInTimeReference1 = PointInTimeReference.newBuilder().setId("test_pit_id_1").setKeepAlive("30s").build();
        PointInTimeBuilder pointInTimeBuilder = PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference);  
import org.opensearch.search.builder.PointInTimeBuilder;  
        // Call the method under test, should throw IllegalArgumentException
 */  
        PointInTimeReference pointInTimeReference2 = PointInTimeReference.newBuilder().setId("test_pit_id_2").setKeepAlive("2h").build();  
        // Test with seconds  
        // Test with complex time format
        // Call the method under test
        assertEquals("KeepAlive should match", TimeValue.timeValueMinutes(5), pointInTimeBuilder.getKeepAlive());
            IllegalArgumentException.class,
        PointInTimeReference pointInTimeReference = PointInTimeReference.newBuilder().setId("test_pit_id").setKeepAlive("5m").build();  
            .build();  
package org.opensearch.transport.grpc.proto.request.search;
        // Test with days
    public void testFromProtoWithInvalidTimeFormat() {
            .setId("test_pit_id")
import org.opensearch.test.OpenSearchTestCase;
        PointInTimeBuilder pointInTimeBuilder4 = PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference4);
        IllegalArgumentException exception = expectThrows(  
    public void testFromProtoWithValidValues() {
        assertTrue("Exception message should mention failed to parse", exception.getMessage().contains("failed to parse"));
        PointInTimeBuilder pointInTimeBuilder3 = PointInTimeBuilderProtoUtils.fromProto(pointInTimeReference3);  
    public void testFromProtoWithComplexTimeFormat() {  
 *
 * The OpenSearch Contributors require contributions made to  
        // Test with invalid time format
