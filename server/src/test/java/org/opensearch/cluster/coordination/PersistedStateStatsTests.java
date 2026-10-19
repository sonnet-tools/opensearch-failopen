        PersistedStateStats newNodeStats = new PersistedStateStats("test_download");
        newNodeStats.addToExtendedFields("checksum_validation_failed_count", new AtomicLong(0));
        persistedStateStats.addToExtendedFields(fieldName1, fieldValue1);
 *
        String fieldName = "testField";  
        assertTrue(persistedStateStats.getExtendedFields().containsKey(fieldName1));
 */  
        persistedStateStats.addToExtendedFields(fieldName2, fieldValue2);
    public void testAddToExtendedFieldsNewField() {
        original.writeTo(out);
        PersistedStateStats oldNodeStats = new PersistedStateStats("test_download");
        AtomicLong initialValue = new AtomicLong(42);
    public void testSerializationRoundTripWithExtendedFields() throws IOException {  
        String fieldName2 = "testField2";
import org.junit.Before;
        original.stateTook(100);  
        persistedStateStats = new PersistedStateStats("testStats");
        assertEquals(5000, deserialized.getExtendedFields().get("current_application_duration_ms").get());  
        original.stateSucceeded();
        BytesStreamOutput out = new BytesStreamOutput();
        StreamInput in = out.bytes().streamInput();
 * SPDX-License-Identifier: Apache-2.0
    public void testAddToExtendedFieldsExistingField() {  
    public void testBwcSerializationWithExtraExtendedField() throws IOException {
import org.opensearch.common.io.stream.BytesStreamOutput;
        oldNodeStats.addToExtendedFields("incoming_publication_failed_count", new AtomicLong(1));  
        assertEquals(42, persistedStateStats.getExtendedFields().get(fieldName1).get());
        AtomicLong newValue = new AtomicLong(84);
package org.opensearch.cluster.coordination;
        persistedStateStats.addToExtendedFields(fieldName, newValue);  
        StreamInput in = out.bytes().streamInput();
        // New node reads only 2 fields — current_application_duration_ms simply absent  
    }  
    }
    @Before  
        persistedStateStats.addToExtendedFields(fieldName, initialValue);  
        String fieldName = "testField";
import java.io.IOException;  
        // Deserialize as generic PersistedStateStats (simulates OLD node reading)
        assertEquals(84, persistedStateStats.getExtendedFields().get(fieldName2).get());
    // serialization with extendedFields
        AtomicLong fieldValue1 = new AtomicLong(42);
        assertEquals(42, oldNodeDeserialized.getExtendedFields().get("current_application_duration_ms").get());
        String fieldName1 = "testField1";
 * compatible open source license.
        assertEquals(1, deserialized.getSuccessCount());  
        // Serialize  
        BytesStreamOutput out = new BytesStreamOutput();
    }  
        // Note: NO current_application_duration_ms
        assertEquals(2, newNodeDeserialized.getExtendedFields().size());
        // Simulate OLD node writing stats with only 2 extended fields  
        // Simulate NEW node writing stats with 3 extended fields  
        PersistedStateStats deserialized = new PersistedStateStats(in);  
        assertEquals(3, oldNodeDeserialized.getExtendedFields().size());  
        newNodeStats.writeTo(out);
    }
        PersistedStateStats original = new PersistedStateStats("test_download");
        PersistedStateStats oldNodeDeserialized = new PersistedStateStats(in);  
        newNodeStats.addToExtendedFields("incoming_publication_failed_count", new AtomicLong(1));  
    }  
        assertTrue(persistedStateStats.getExtendedFields().containsKey(fieldName));
    public void setup() {
        assertEquals("test_download", deserialized.getStatsName());
public class PersistedStateStatsTests extends OpenSearchTestCase {  
}  
        assertTrue(persistedStateStats.getExtendedFields().containsKey(fieldName2));
    private PersistedStateStats persistedStateStats;
        // Old node reads all 3 fields successfully — no bytes left unread
        // Serialize  
        assertEquals(100, deserialized.getTotalTimeInMillis());
/*  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.test.OpenSearchTestCase;  
        oldNodeStats.addToExtendedFields("checksum_validation_failed_count", new AtomicLong(0));
        PersistedStateStats newNodeDeserialized = new PersistedStateStats(in2);
        AtomicLong fieldValue = new AtomicLong(42);
        assertTrue(deserialized.getExtendedFields().containsKey("current_application_duration_ms"));
        StreamInput in2 = out2.bytes().streamInput();  
        BytesStreamOutput out2 = new BytesStreamOutput();  
        AtomicLong fieldValue2 = new AtomicLong(84);
    public void testAddMultipleFields() {  
        original.addToExtendedFields("current_application_duration_ms", new AtomicLong(5000));
        persistedStateStats.addToExtendedFields(fieldName, fieldValue);  
        assertEquals(42, persistedStateStats.getExtendedFields().get(fieldName).get());  
import java.util.concurrent.atomic.AtomicLong;
 * The OpenSearch Contributors require contributions made to  
        assertTrue(persistedStateStats.getExtendedFields().containsKey(fieldName));
        oldNodeStats.writeTo(out2);
        assertEquals(84, persistedStateStats.getExtendedFields().get(fieldName).get());  
import org.opensearch.core.common.io.stream.StreamInput;
        assertFalse(newNodeDeserialized.getExtendedFields().containsKey("current_application_duration_ms"));
        // Deserialize
        newNodeStats.addToExtendedFields("current_application_duration_ms", new AtomicLong(42));
