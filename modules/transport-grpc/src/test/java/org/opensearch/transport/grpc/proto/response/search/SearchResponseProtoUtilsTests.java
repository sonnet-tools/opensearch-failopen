    public void testToProtoWithTerminatedEarly() throws IOException {
        assertEquals("Expand phase took should match", 5L, protoResponse.getPhaseTook().getExpand());
        assertEquals("Expand phase took should match", 5L, protoPhaseTook.getExpand());
        phaseTookMap.put(SearchPhaseName.DFS_QUERY.getName(), 20L);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        assertEquals("Skipped shards should match", 0, protoResponse.getXShards().getSkipped());
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getSkippedShards()).thenReturn(0);
        // Call the method under test
        phaseTookMap.put(SearchPhaseName.CAN_MATCH.getName(), 5L);
    public void testClustersProtoUtilsToProtoWithNonZeroClusters() throws IOException {
        PhaseTook.Builder phaseTookBuilder = PhaseTook.newBuilder();
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
/*
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        when(mockResponse.getTotalShards()).thenReturn(5);
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        // Call the method under test
        // Create a mock SearchResponse with clusters
        assertNotNull("Proto phase took should not be null", protoPhaseTook);
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        assertFalse("Timed out should be false", protoResponse.getTimedOut());
 * SPDX-License-Identifier: Apache-2.0
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        assertNotNull("Proto response should not be null", protoResponse);
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        assertEquals("Query phase took should match", 50L, protoResponse.getPhaseTook().getQuery());
        Map<String, Long> phaseTookMap = new HashMap<>();
        when(mockResponse.getSkippedShards()).thenReturn(0);
        // Verify the result
        // Create a mock SearchResponse with num reduce phases
    }
        when(mockResponse.getFailedShards()).thenReturn(0);
        // Create a mock SearchResponse with phase took
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        when(mockResponse.isTerminatedEarly()).thenReturn(true);
    public void testToProtoWithClusters() throws IOException {
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        // Create a builder to populate
        assertEquals("Scroll ID should match", "test_scroll_id", protoResponse.getXScrollId());
 * this file be licensed under the Apache-2.0 license or a
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        // Create a mock SearchResponse
    public void testToProtoWithPhaseTook() throws IOException {
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockResponse.pointInTimeId()).thenReturn("test_pit_id");
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        assertNotNull("Proto phase took should not be null", protoPhaseTook);
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
    public void testToProtoWithScrollId() throws IOException {
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    }
        when(mockResponse.getSkippedShards()).thenReturn(0);
        PhaseTook protoPhaseTook = phaseTookBuilder.build();
        when(mockResponse.isTimedOut()).thenReturn(false);
        assertEquals("Successful clusters should match", 2, protoResponse.getXClusters().getSuccessful());
        when(mockResponse.getFailedShards()).thenReturn(0);
        assertTrue("Terminated early should be true", protoResponse.getTerminatedEarly());
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getNumReducePhases()).thenReturn(3);
        assertTrue("Clusters should be present", protoResponse.hasXClusters());
        SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
        assertEquals("Num reduce phases should match", 3, protoResponse.getNumReducePhases());
        SearchResponseProtoUtils.ClustersProtoUtils.toProto(builder, clusters);
import org.opensearch.action.search.SearchResponse;
        when(mockResponse.getSkippedShards()).thenReturn(0);
        // Verify the result
        when(mockResponse.getTotalShards()).thenReturn(5);
 *
        assertEquals("Point in time ID should match", "test_pit_id", protoResponse.getPitId());
}
        assertEquals("DFS query phase took should match", 20L, protoResponse.getPhaseTook().getDfsQuery());
    }
        when(mockResponse.isTimedOut()).thenReturn(false);
        assertEquals("Query phase took should be 0", 0L, protoPhaseTook.getQuery());
        assertEquals("Fetch phase took should match", 30L, protoResponse.getPhaseTook().getFetch());
        assertEquals("Can match phase took should match", 5L, protoPhaseTook.getCanMatch());
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getFailedShards()).thenReturn(0);
        assertEquals("Total shards should match", 5, protoResponse.getXShards().getTotal());
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        // Call the method under test
        // Create a mock SearchResponse.PhaseTook
        assertNotNull("Proto response should not be null", protoResponse);
        assertEquals("Total clusters should match", 3, protoResponse.getXClusters().getTotal());
import org.opensearch.action.search.ShardSearchFailure;
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.isTimedOut()).thenReturn(false);
        assertNotNull("Proto response should not be null", protoResponse);
import static org.mockito.Mockito.mock;
        // Verify the result
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
import java.util.Map;
        SearchResponse mockResponse = mock(SearchResponse.class);
        // Call the method under test
        when(mockResponse.isTimedOut()).thenReturn(false);
        // Verify the result
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getPhaseTook()).thenReturn(phaseTook);
        when(mockResponse.getScrollId()).thenReturn("test_scroll_id");
        assertEquals("Query phase took should match", 50L, protoPhaseTook.getQuery());
    }
        // Verify the result
        // Verify the result
        assertEquals("Successful shards should match", 5, protoResponse.getXShards().getSuccessful());
        assertEquals("Successful clusters should match", 2, builder.getXClusters().getSuccessful());
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
import org.opensearch.protobufs.PhaseTook;
        when(mockResponse.getFailedShards()).thenReturn(0);
        phaseTookMap.put(SearchPhaseName.DFS_QUERY.getName(), 20L);
        phaseTookMap.put(SearchPhaseName.EXPAND.getName(), 5L);
        // Verify the result
        when(mockResponse.getSkippedShards()).thenReturn(0);
        // Verify the result
        SearchResponseProtoUtils.PhaseTookProtoUtils.toProto(null, phaseTookBuilder);
        assertEquals("DFS pre-query phase took should match", 10L, protoPhaseTook.getDfsPreQuery());
        assertEquals("Took should match", 100, protoResponse.getTook());
        phaseTookMap.put(SearchPhaseName.FETCH.getName(), 30L);
        assertEquals("Can match phase took should match", 5L, protoResponse.getPhaseTook().getCanMatch());
        SearchResponse mockResponse = mock(SearchResponse.class);
        // Call the method under test
        assertEquals("Fetch phase took should match", 30L, protoPhaseTook.getFetch());
        assertEquals("Total clusters should match", 3, builder.getXClusters().getTotal());
        // Create a mock SearchResponse with point in time ID
        assertNotNull("Proto response should not be null", protoResponse);
        assertEquals("DFS pre-query phase took should be 0", 0L, protoPhaseTook.getDfsPreQuery());
        assertEquals("Expand phase took should be 0", 0L, protoPhaseTook.getExpand());
        // Create a mock SearchResponse.Clusters with zero total
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    public void testPhaseTookProtoUtilsToProtoWithNullPhaseTook() {
        assertNotNull("Proto response should not be null", protoResponse);
        phaseTookMap.put(SearchPhaseName.FETCH.getName(), 30L);
        assertEquals("Can match phase took should be 0", 0L, protoPhaseTook.getCanMatch());
        // Create a mock SearchResponse.Clusters
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        phaseTookMap.put(SearchPhaseName.EXPAND.getName(), 5L);
        // Verify the result
public class SearchResponseProtoUtilsTests extends OpenSearchTestCase {
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        SearchResponse mockResponse = mock(SearchResponse.class);
    public void testClustersProtoUtilsToProtoWithZeroClusters() throws IOException {
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        phaseTookMap.put(SearchPhaseName.QUERY.getName(), 50L);
        assertFalse("Clusters should not be present", builder.hasXClusters());
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        assertTrue("Phase took should be present", protoResponse.hasPhaseTook());
        SearchResponse.Clusters clusters = new SearchResponse.Clusters(3, 2, 1);
package org.opensearch.transport.grpc.proto.response.search;
        // Create a mock SearchResponse.PhaseTook
        assertEquals("Fetch phase took should be 0", 0L, protoPhaseTook.getFetch());
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
    }
        // Verify the result
    }
 * The OpenSearch Contributors require contributions made to
        assertEquals("Failed shards should match", 0, protoResponse.getXShards().getFailed());
        PhaseTook.Builder phaseTookBuilder = PhaseTook.newBuilder();
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertEquals("Skipped clusters should match", 1, protoResponse.getXClusters().getSkipped());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
        assertEquals("Skipped clusters should match", 1, builder.getXClusters().getSkipped());
 */
        phaseTookMap.put(SearchPhaseName.DFS_PRE_QUERY.getName(), 10L);
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        // Create a mock SearchResponse with terminated early
        SearchResponseProtoUtils.PhaseTookProtoUtils.toProto(phaseTook, phaseTookBuilder);
        SearchResponse mockResponse = mock(SearchResponse.class);
 * compatible open source license.
    }
    public void testToProtoWithBasicResponse() throws IOException {
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    }
        assertEquals("DFS query phase took should match", 20L, protoPhaseTook.getDfsQuery());
import static org.mockito.Mockito.when;
        phaseTookMap.put(SearchPhaseName.CAN_MATCH.getName(), 5L);
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        // Call the method under test
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        // Call the method under test
        phaseTookMap.put(SearchPhaseName.QUERY.getName(), 50L);
        SearchResponse.Clusters clusters = new SearchResponse.Clusters(0, 0, 0);
import org.opensearch.search.SearchHits;
    public void testPhaseTookProtoUtilsToProto() {
import org.opensearch.action.search.SearchPhaseName;
    public void testToProtoWithNumReducePhases() throws IOException {
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        // Create a builder and call the method under test
        assertNotNull("Proto response should not be null", protoResponse);
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
import java.util.HashMap;
        assertTrue("Clusters should be present", builder.hasXClusters());
        SearchResponseProtoUtils.ClustersProtoUtils.toProto(builder, clusters);
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        assertEquals("DFS query phase took should be 0", 0L, protoPhaseTook.getDfsQuery());
    }
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        // Verify the result
        // Create a mock SearchResponse with scroll ID
        assertEquals("DFS pre-query phase took should match", 10L, protoResponse.getPhaseTook().getDfsPreQuery());
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(3, 2, 1));
    }
    public void testToProtoWithPointInTimeId() throws IOException {
import java.io.IOException;
        // Create a builder to populate
    }
        assertNotNull("Proto response should not be null", protoResponse);
        PhaseTook protoPhaseTook = phaseTookBuilder.build();
        when(mockResponse.getTotalShards()).thenReturn(5);
        // Create a builder and call the method under test with null
        Map<String, Long> phaseTookMap = new HashMap<>();
        // Call the method under test
import org.opensearch.test.OpenSearchTestCase;
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
    private final AggregateProtoConverterRegistry aggregateRegistry = new AggregateProtoConverterRegistryImpl();
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        // Call the method under test
import org.opensearch.action.search.SearchResponseSections;
import org.opensearch.common.unit.TimeValue;
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        phaseTookMap.put(SearchPhaseName.DFS_PRE_QUERY.getName(), 10L);
