import java.util.Map;  
import org.opensearch.core.xcontent.ToXContent;  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest();  
    public void testXContentRoundTrip() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
        request.writeTo(out);
        XContentBuilder builder = jsonBuilder();  
    }  
        assertArrayEquals(request.indices(), parsed.indices());  
            RestoreSnapshotRequest.AliasWriteIndexPolicy.fromString("preserve")
            .waitForCompletion(false);
package org.opensearch.action.admin.cluster.snapshots.restore;
            .includeGlobalState(false)
        assertEquals(request.includeAliases(), deserialized.includeAliases());
            .partial(true);  
import static org.hamcrest.Matchers.equalTo;  
        assertEquals(request.includeGlobalState(), parsed.includeGlobalState());  
        StreamInput in = out.bytes().streamInput();  
        assertEquals(request.includeAliases(), parsed.includeAliases());
            .includeAliases(true)
        RestoreSnapshotRequest request = new RestoreSnapshotRequest("test-repo", "test-snapshot").indices("index1", "index2")
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX)
        assertEquals(request.snapshot(), deserialized.snapshot());
import java.io.IOException;
    public void testEqualsAndHashCode() {
            RestoreSnapshotRequest.AliasWriteIndexPolicy.fromString("strip_write_index")
}  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest("test-repo", "test-snapshot").indices("index1", "index2")
    }
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX)  
    }
            .partial(true)  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;  
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);  
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.PRESERVE);
        assertEquals(request1, request2);
            .includeAliases(true)
        // Parse from XContent  
        expectThrows(IllegalArgumentException.class, () -> RestoreSnapshotRequest.AliasWriteIndexPolicy.fromString("invalid"));
 */  
    public void testPolicyFromString() {
        assertEquals(request.aliasWriteIndexPolicy(), deserialized.aliasWriteIndexPolicy());  
            RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX,
        Map<String, Object> source = parser.map();
            RestoreSnapshotRequest.AliasWriteIndexPolicy.PRESERVE,  
        assertEquals(request.repository(), deserialized.repository());  
import org.opensearch.core.xcontent.XContentParser;
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);  
        request.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
        // Verify key fields
        assertEquals(request1.hashCode(), request2.hashCode());  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertArrayEquals(request.indices(), deserialized.indices());
            .renamePattern("(.+)")
 * compatible open source license.
/*  
        BytesStreamOutput out = new BytesStreamOutput();  
            .renameReplacement("restored-$1")  
        assertEquals(  
        );  
        );
        assertEquals(
        assertEquals(request.aliasWriteIndexPolicy(), parsed.aliasWriteIndexPolicy());
        assertNotEquals(request1, request3);  
public class AliasWriteIndexPolicyRequestTests extends OpenSearchTestCase {
        assertEquals(request.partial(), parsed.partial());
        // Test with different policy
    public void testSerialization() throws IOException {  
import org.opensearch.common.io.stream.BytesStreamOutput;
        RestoreSnapshotRequest request2 = new RestoreSnapshotRequest("repo", "snapshot").indices("index1", "index2")
        RestoreSnapshotRequest request1 = new RestoreSnapshotRequest("repo", "snapshot").indices("index1", "index2")
        RestoreSnapshotRequest deserialized = new RestoreSnapshotRequest(in);
        RestoreSnapshotRequest request3 = new RestoreSnapshotRequest("repo", "snapshot").indices("index1", "index2")  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        // Convert to XContent
        assertThat(request.aliasWriteIndexPolicy(), equalTo(RestoreSnapshotRequest.AliasWriteIndexPolicy.PRESERVE));
    public void testDefaultValues() {
        RestoreSnapshotRequest parsed = new RestoreSnapshotRequest().source(source);  
        XContentParser parser = createParser(builder);
    }
