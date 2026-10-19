        assertEquals(metadata.getLatestSegmentMetadataFileName(), xContentMap.get("latest_segment_metadata_filename"));
        Map<String, Object> segmentFiles = (Map<String, Object>) xContentMap.get("available_segment_metadata_files");
/*  
            "test-index",
        XContentBuilder builder = XContentFactory.jsonBuilder();
        metadata.writeTo(out);
        assertEquals(metadata.getLatestSegmentMetadataFileName(), deserializedMetadata.getLatestSegmentMetadataFileName());  
        assertNotNull(xContentMap.get("available_translog_metadata_files"));  
        assertEquals("test-index", xContentMap.get("index"));  
        assertTrue(translogContent.containsKey("generation"));  
        StreamInput in = out.bytes().streamInput();
        String translogKey = metadata.getLatestTranslogMetadataFileName();
        assertTrue(segmentFiles.containsKey(segmentKey));
            translogMetadata,  
 */  
        RemoteStoreShardMetadata deserializedMetadata = new RemoteStoreShardMetadata(in);
        assertEquals("Map size mismatch", expected.size(), actual.size());
        assertNull(deserializedMetadata.getLatestSegmentMetadataFileName());  
    }  
        metadata.toXContent(builder, EMPTY_PARAMS);  
            Object actualVal = actual.get(key);
        assertEquals(0, xContentMap.get("shard"));
        Map<String, Object> translogMetadata = RemoteStoreMetadataTestHelper.createTestTranslogMetadata();  
        assertTrue(translogContent.containsKey("generation_to_primary_term"));  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> segmentContent = (Map<String, Object>) segmentFiles.get(segmentKey);  
        RemoteStoreShardMetadata deserializedMetadata = new RemoteStoreShardMetadata(in);  
        Map<String, Object> segmentMetadata = RemoteStoreMetadataTestHelper.createTestSegmentMetadata();
        assertEquals(metadata.getShardId(), deserializedMetadata.getShardId());
        }  
                assertEquals("Mismatch at key " + key, ((Number) expectedVal).longValue(), ((Number) actualVal).longValue());
        assertEquals(metadata.getLatestTranslogMetadataFileName(), xContentMap.get("latest_translog_metadata_filename"));  
            0
        assertTrue(segmentContent.containsKey("files"));
        String segmentKey = metadata.getLatestSegmentMetadataFileName();  
        assertNestedMapEquals(metadata.getSegmentMetadataFiles(), deserializedMetadata.getSegmentMetadataFiles());
    private void assertFlatMapEquals(Map<String, Object> expected, Map<String, Object> actual) {
        assertTrue(translogContent.containsKey("min_translog_gen"));
        assertEquals("test-index", deserializedMetadata.getIndexName());
                assertEquals("Mismatch at key " + key, expectedVal, actualVal);  
public class RemoteStoreMetadataTests extends OpenSearchTestCase {
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals("Inner map keys mismatch", expected.keySet(), actual.keySet());  
        Map<String, Object> xContentMap = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
    }
        Map<String, Object> translogMetadata = RemoteStoreMetadataTestHelper.createTestTranslogMetadata();
        metadata.writeTo(out);
        );
import java.util.Map;  
    }
            } else if (expectedVal instanceof Number) {  
        for (String key : expected.keySet()) {  
                assertFlatMapEquals((Map<String, Object>) expectedVal, (Map<String, Object>) actualVal);
            } else {
 *
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.bytes.BytesReference;
        RemoteStoreShardMetadata metadata = RemoteStoreMetadataTestHelper.createTestMetadata(
        assertNotNull(xContentMap.get("available_segment_metadata_files"));
    }
 * compatible open source license.
        assertEquals("Inner map size mismatch", expected.size(), actual.size());
        assertEquals(metadata.getIndexName(), deserializedMetadata.getIndexName());
        );  
            segmentMetadata,
            "test-index",  
import org.opensearch.core.xcontent.XContentBuilder;  
        RemoteStoreShardMetadata metadata = RemoteStoreMetadataTestHelper.createTestMetadata(  
        }
    public void testSerialization() throws Exception {  
    public void testXContent() throws Exception {
    }
import org.opensearch.test.OpenSearchTestCase;
            }
        assertTrue(deserializedMetadata.getTranslogMetadataFiles().isEmpty());
        assertTrue(translogFiles.containsKey(translogKey));  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * SPDX-License-Identifier: Apache-2.0
            Object expectedVal = expected.get(key);  
            assertFlatMapEquals(expected.get(key), actual.get(key));
            0
                assertTrue("Expected value at key " + key + " should be a map", actualVal instanceof Map);
        BytesStreamOutput out = new BytesStreamOutput();  
    @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> translogFiles = (Map<String, Object>) xContentMap.get("available_translog_metadata_files");
        Map<String, Object> translogContent = (Map<String, Object>) translogFiles.get(translogKey);
        assertNestedMapEquals(metadata.getTranslogMetadataFiles(), deserializedMetadata.getTranslogMetadataFiles());  
}
        assertNull(deserializedMetadata.getLatestTranslogMetadataFileName());
        assertEquals(metadata.getLatestTranslogMetadataFileName(), deserializedMetadata.getLatestTranslogMetadataFileName());
        assertTrue(segmentContent.containsKey("replication_checkpoint"));
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue(deserializedMetadata.getSegmentMetadataFiles().isEmpty());
    @SuppressWarnings("unchecked")  
        Map<String, Object> segmentMetadata = RemoteStoreMetadataTestHelper.createTestSegmentMetadata();
            segmentMetadata,
    private void assertNestedMapEquals(Map<String, Map<String, Object>> expected, Map<String, Map<String, Object>> actual) {
package org.opensearch.action.admin.cluster.remotestore.metadata;
        assertEquals(0, deserializedMetadata.getShardId());  
            if (expectedVal instanceof Map) {  
            assertTrue("Missing key: " + key, actual.containsKey(key));
        RemoteStoreShardMetadata metadata = RemoteStoreMetadataTestHelper.createTestMetadata(Map.of(), Map.of(), "test-index", 0);
    public void testEmptyMetadata() throws Exception {  
            translogMetadata,
        assertTrue(translogContent.containsKey("primary_term"));
        for (String key : expected.keySet()) {
        StreamInput in = out.bytes().streamInput();
import org.opensearch.common.xcontent.XContentHelper;  
