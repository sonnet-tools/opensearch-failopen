        assertEquals("query-456", deserialized.getQueryId());
import org.opensearch.core.index.Index;  
 * this file be licensed under the Apache-2.0 license or a
    }
            0,
 *
        assertEquals(0, deserialized.getShardId().id());  
            2,
        FetchByRowIdsRequest deserialized = roundTrip(original);  
        assertEquals("lucene", deserialized.getBackendId());
        BytesStreamOutput out = new BytesStreamOutput();  
        assertEquals(2, deserialized.getStageId());
 * The OpenSearch Contributors require contributions made to  
    }
        assertArrayEquals(new long[] { 10, 42, 99 }, deserialized.getRowIds());
        assertArrayEquals(new long[] { 0 }, deserialized.getRowIds());  
            new long[] { 0 },
        return new FetchByRowIdsRequest(in);  
    public void testRoundTripWithProfileFalse() throws IOException {
        StreamInput in = out.bytes().streamInput();
 * Wire serialization round-trip tests for {@link FetchByRowIdsRequest}.
            "datafusion",
            new String[] { "msg" },
public class FetchByRowIdsRequestSerializationTests extends OpenSearchTestCase {  
        original.writeTo(out);
    private FetchByRowIdsRequest roundTrip(FetchByRowIdsRequest original) throws IOException {
        );
 */
            new ShardId(new Index("logs", "uuid2"), 3),
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals("datafusion", deserialized.getBackendId());
 */  
import org.opensearch.test.OpenSearchTestCase;
            new String[] { "name", "score" },  
        assertEquals(3, deserialized.getShardId().id());
        assertFalse("profile=false must survive round-trip", deserialized.profile());
        assertEquals("test_index", deserialized.getShardId().getIndexName());
 * SPDX-License-Identifier: Apache-2.0
    }  
            new long[] { 10, 42, 99 },
            "query-456",  
        );
            new ShardId(new Index("test_index", "uuid"), 0),  
}
/*  
        FetchByRowIdsRequest deserialized = roundTrip(original);
        assertArrayEquals(new String[] { "msg" }, deserialized.getColumns());
import org.opensearch.core.index.shard.ShardId;
        FetchByRowIdsRequest original = new FetchByRowIdsRequest(  
            true
import org.opensearch.common.io.stream.BytesStreamOutput;
import java.io.IOException;
/**  
    public void testRoundTripWithProfileTrue() throws IOException {
        assertTrue("profile flag must survive round-trip", deserialized.profile());
            "query-123",
        assertArrayEquals(new String[] { "name", "score" }, deserialized.getColumns());  
        assertEquals("query-123", deserialized.getQueryId());  
        assertEquals(0, deserialized.getStageId());  
package org.opensearch.analytics.exec.action;
        FetchByRowIdsRequest original = new FetchByRowIdsRequest(
 * compatible open source license.
            "lucene",  
            false  
