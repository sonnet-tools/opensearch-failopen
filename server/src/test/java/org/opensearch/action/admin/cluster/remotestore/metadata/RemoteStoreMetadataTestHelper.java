        int shardId
        uploadedSegments.put("seg_1", uploadedSegment);
 */  
        return Map.of("metadata__translog1", metadata);  
import java.util.HashMap;
    public static Map<String, Object> createTestSegmentMetadata() {
        metadata.put("generation", 1L);
 * compatible open source license.
public class RemoteStoreMetadataTestHelper {
 * The OpenSearch Contributors require contributions made to  
    ) {  
        return Map.of("metadata__segment1", metadata);
 *
        String latestSegmentFile = segmentFiles.isEmpty() ? null : segmentFiles.keySet().iterator().next();
        metadata.put("replication_checkpoint", replicationCheckpoint);  
        replicationCheckpoint.put("created_timestamp", System.currentTimeMillis());
        metadata.put("primary_term", 1L);
        uploadedSegment.put("checksum", "abc123");
        return new RemoteStoreShardMetadata(indexName, shardId, segmentFiles, translogFiles, latestSegmentFile, latestTranslogFile);
 */  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> translogMetadata,  
        replicationCheckpoint.put("generation", 1L);
        Map<String, Object> segmentMetadata,
        Map<String, Object> uploadedSegments = new HashMap<>();
/**
        replicationCheckpoint.put("codec", "Lucene80");
        Map<String, Map<String, Object>> segmentFiles = (Map<String, Map<String, Object>>) (Map<?, ?>) segmentMetadata;
package org.opensearch.action.admin.cluster.remotestore.metadata;
        replicationCheckpoint.put("shard_id", "index[0]");
}
        metadata.put("min_translog_gen", 1L);  
 * Helper class for unit testing RemoteStoreMetadata and RemoteStoreMetadataResponse.
    public static RemoteStoreShardMetadata createTestMetadata(
        String latestTranslogFile = translogFiles.isEmpty() ? null : translogFiles.keySet().iterator().next();
        Map<String, Object> replicationCheckpoint = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        metadata.put("generation_to_primary_term", genToTermMap);
        replicationCheckpoint.put("version", 1L);
        replicationCheckpoint.put("primary_term", 1L);  
        Map<String, Map<String, Object>> translogFiles = (Map<String, Map<String, Object>>) (Map<?, ?>) translogMetadata;
import java.util.Map;
        Map<String, Object> uploadedSegment = new HashMap<>();
/*  
        metadata.put("files", uploadedSegments);
    }
    }  
        uploadedSegment.put("length", 1024L);
    }
        uploadedSegment.put("original_name", "segment_1");  
    public static Map<String, Object> createTestTranslogMetadata() {
        String indexName,
        Map<String, String> genToTermMap = new HashMap<>();  
        genToTermMap.put("1", "1");
    @SuppressWarnings("unchecked")  
        replicationCheckpoint.put("length", 12345L);  
        Map<String, Object> metadata = new HashMap<>();  
        Map<String, Object> metadata = new HashMap<>();
