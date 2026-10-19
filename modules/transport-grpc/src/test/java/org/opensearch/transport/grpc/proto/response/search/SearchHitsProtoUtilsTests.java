        SearchHit[] hits = new SearchHit[2];  
package org.opensearch.transport.grpc.proto.response.search;
        TotalHits totalHits = new TotalHits(10, TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
        // Verify the result
            "Total hits relation should be EQUAL_TO",
        // Max score is HitsMetadataMaxScore object with getFloat() method  
        SearchHits searchHits = new SearchHits(hits, totalHits, 2.0f);
        HitsMetadata hitsMetadata = SearchHitsProtoUtils.toProto(searchHits);
        assertEquals("Total hits value should match", 10, hitsMetadata.getTotal().getTotalHits().getValue());  
        // Verify the result
        hits[0].score(2.0f);  
        SearchShardTarget searchShardTarget = new SearchShardTarget("test_node", shardId, null, null);
        assertFalse("Total hits should not have value", hitsMetadata.getTotal().hasTotalHits());
    public void testToProtoWithGreaterThanRelation() throws IOException {
        SearchShardTarget searchShardTarget = new SearchShardTarget("test_node", shardId, null, null);
        hits[0].score(2.0f);
 * SPDX-License-Identifier: Apache-2.0
        hits[1] = new SearchHit(2, "test_id_2", null, null);
        assertEquals("Hits count should be 0", 0, hitsMetadata.getHitsCount());
        );
        hits[0].shard(searchShardTarget);
        hits[0].shard(searchShardTarget);
            hitsMetadata.getTotal().getTotalHits().getRelation()
        ShardId shardId = new ShardId("test_index", "_na_", 1);  
    }  
        // Verify the result
        assertEquals("Second hit ID should match", "test_id_2", hitsMetadata.getHits(1).getXId());
        // Verify the result
        hits[0].shard(searchShardTarget);
public class SearchHitsProtoUtilsTests extends OpenSearchTestCase {
        // Call the method under test
import org.opensearch.protobufs.HitsMetadata;  
        HitsMetadata hitsMetadata = SearchHitsProtoUtils.toProto(searchHits);
        SearchShardTarget searchShardTarget = new SearchShardTarget("test_node", shardId, null, null);
        hits[0] = new SearchHit(1, "test_id_1", null, null);
        assertEquals("Max score should match", 2.0f, hitsMetadata.getMaxScore().getFloat(), 0.0f);  
import java.io.IOException;  
        assertEquals("First hit ID should match", "test_id_1", hitsMetadata.getHits(0).getXId());  
        assertEquals("Max score should match", 3.0f, hitsMetadata.getMaxScore().getFloat(), 0.0f);
        // Create SearchHits with null totalHits
import org.opensearch.search.SearchHits;
        hits[1].score(3.0f);
        SearchHit[] hits = new SearchHit[0];  
        TotalHits totalHits = new TotalHits(10, TotalHits.Relation.EQUAL_TO);
    }
        TotalHits totalHits = new TotalHits(10, TotalHits.Relation.EQUAL_TO);
        ShardId shardId2 = new ShardId("test_index_2", "_na_", 1);  
        assertEquals("Hits count should match", 2, hitsMetadata.getHitsCount());
        SearchHit[] hits = new SearchHit[1];  
    public void testToProtoWithBasicFields() throws IOException {
            org.opensearch.protobufs.TotalHitsRelation.TOTAL_HITS_RELATION_GTE,  
        // Call the method under test
        assertNotNull("HitsMetadata should not be null", hitsMetadata);
        // Create SearchHits with GREATER_THAN_OR_EQUAL_TO relation
        assertEquals("Total hits value should match", 0, hitsMetadata.getTotal().getTotalHits().getValue());  
import org.opensearch.search.SearchHit;
        ShardId shardId = new ShardId("test_index", "_na_", 1);  
        // Call the method under test  
        TotalHits totalHits = new TotalHits(0, TotalHits.Relation.EQUAL_TO);
            org.opensearch.protobufs.TotalHitsRelation.TOTAL_HITS_RELATION_EQ,  
        assertEquals(
 */  
    }
        assertNotNull("HitsMetadata should not be null", hitsMetadata);  
    }
        // Call the method under test
 * The OpenSearch Contributors require contributions made to  
    public void testToProtoWithEmptyHits() throws IOException {
}  
    public void testToProtoWithNullTotalHits() throws IOException {
        assertEquals(
        assertEquals("Total hits value should match", 10, hitsMetadata.getTotal().getTotalHits().getValue());  
import org.opensearch.search.SearchShardTarget;  
        hits[1].shard(searchShardTarget2);
    }
        assertEquals("Hits count should match", 1, hitsMetadata.getHitsCount());
        HitsMetadata hitsMetadata = SearchHitsProtoUtils.toProto(searchHits);
        // Create SearchHits with empty hits array
            "Total hits relation should be GREATER_THAN_OR_EQUAL_TO",
    public void testToProtoWithNaNMaxScore() throws IOException {
            hitsMetadata.getTotal().getTotalHits().getRelation()
        assertTrue("Max score should be null", hitsMetadata.getMaxScore().hasNullValue());
 *
        hits[0].shard(searchShardTarget);  
        SearchShardTarget searchShardTarget2 = new SearchShardTarget("test_node", shardId2, null, null);
        hits[0] = new SearchHit(1, "test_id", null, null);
        assertNotNull("HitsMetadata should not be null", hitsMetadata);
        HitsMetadata hitsMetadata = SearchHitsProtoUtils.toProto(searchHits);
        assertNotNull("HitsMetadata should not be null", hitsMetadata);
        ShardId shardId = new ShardId("test_index_1", "_na_", 1);  
        SearchHits searchHits = new SearchHits(hits, null, 2.0f);
        ShardId shardId = new ShardId("test_index", "_na_", 1);
        // Create SearchHits with basic fields
        // Verify the result  
        hits[0].score(2.0f);
        SearchHits searchHits = new SearchHits(hits, totalHits, 3.0f);
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("HitsMetadata should not be null", hitsMetadata);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.index.shard.ShardId;
        SearchHit[] hits = new SearchHit[1];
        // Call the method under test
        SearchHits searchHits = new SearchHits(hits, totalHits, Float.NaN);  
        );
        SearchShardTarget searchShardTarget = new SearchShardTarget("test_node", shardId, null, null);
/*  
        SearchHits searchHits = new SearchHits(hits, totalHits, 0.0f);
        hits[0] = new SearchHit(1, "test_id", null, null);
        SearchHit[] hits = new SearchHit[1];  
 * compatible open source license.
        hits[0].score(2.0f);
        hits[0] = new SearchHit(1, "test_id", null, null);
        HitsMetadata hitsMetadata = SearchHitsProtoUtils.toProto(searchHits);  
        // Create SearchHits with NaN maxScore  
import org.apache.lucene.search.TotalHits;
