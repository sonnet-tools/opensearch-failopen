        // Verify the result
/*  
    public void testPhaseTookProtoUtilsToProtoWithNullPhaseTook() {  
 * The OpenSearch Contributors require contributions made to  
        // Create a mock SearchResponse.Clusters with zero total
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        assertEquals("Total shards should match", 5, protoResponse.getXShards().getTotal());
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);  
        assertEquals("Scroll ID should match", "test_scroll_id", protoResponse.getXScrollId());
        when(mockResponse.pointInTimeId()).thenReturn("test_pit_id");  
        when(mockResponse.getSkippedShards()).thenReturn(0);
        SearchResponse mockResponse = mock(SearchResponse.class);  
        when(mockResponse.getSkippedShards()).thenReturn(0);
        assertEquals("Expand phase took should be 0", 0L, protoPhaseTook.getExpand());  
        // Verify the result
        assertEquals("Query phase took should match", 50L, protoResponse.getPhaseTook().getQuery());
        phaseTookMap.put(SearchPhaseName.EXPAND.getName(), 5L);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(3, 2, 1));  
        assertNotNull("Proto response should not be null", protoResponse);  
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        phaseTookMap.put(SearchPhaseName.DFS_PRE_QUERY.getName(), 10L);  
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        phaseTookMap.put(SearchPhaseName.DFS_PRE_QUERY.getName(), 10L);  
import java.util.Map;
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        // Call the method under test
        assertEquals("Successful clusters should match", 2, protoResponse.getXClusters().getSuccessful());
        SearchResponseProtoUtils.PhaseTookProtoUtils.toProto(null, phaseTookBuilder);  
import org.opensearch.action.search.SearchResponse;
        assertNotNull("Proto phase took should not be null", protoPhaseTook);  
        phaseTookMap.put(SearchPhaseName.QUERY.getName(), 50L);  
        assertEquals("Query phase took should be 0", 0L, protoPhaseTook.getQuery());
        assertEquals("Skipped shards should match", 0, protoResponse.getXShards().getSkipped());
        assertEquals("Failed shards should match", 0, protoResponse.getXShards().getFailed());
        // Verify the result
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    public void testClustersProtoUtilsToProtoWithNonZeroClusters() throws IOException {
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        // Create a mock SearchResponse with scroll ID  
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));  
        phaseTookMap.put(SearchPhaseName.QUERY.getName(), 50L);  
 */  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));  
        // Call the method under test
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        SearchResponse.Clusters clusters = new SearchResponse.Clusters(3, 2, 1);  
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        // Create a builder and call the method under test with null
        // Create a mock SearchResponse  
    }
        assertEquals("Skipped clusters should match", 1, builder.getXClusters().getSkipped());  
        // Verify the result
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        Map<String, Long> phaseTookMap = new HashMap<>();
        // Create a mock SearchResponse.PhaseTook
        assertEquals("Expand phase took should match", 5L, protoPhaseTook.getExpand());
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertEquals("Point in time ID should match", "test_pit_id", protoResponse.getPitId());  
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
import static org.mockito.Mockito.when;
        assertNotNull("Proto response should not be null", protoResponse);  
        assertEquals("DFS pre-query phase took should match", 10L, protoResponse.getPhaseTook().getDfsPreQuery());
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertEquals("Can match phase took should match", 5L, protoPhaseTook.getCanMatch());  
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());  
        // Create a mock SearchResponse.Clusters
        assertTrue("Terminated early should be true", protoResponse.getTerminatedEarly());  
        when(mockResponse.isTimedOut()).thenReturn(false);  
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        PhaseTook.Builder phaseTookBuilder = PhaseTook.newBuilder();
        // Call the method under test
        SearchResponse mockResponse = mock(SearchResponse.class);
        // Verify the result
        assertEquals("Query phase took should match", 50L, protoPhaseTook.getQuery());
        phaseTookMap.put(SearchPhaseName.FETCH.getName(), 30L);
        assertEquals("Can match phase took should match", 5L, protoResponse.getPhaseTook().getCanMatch());
    public void testToProtoWithNumReducePhases() throws IOException {  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    public void testToProtoWithTerminatedEarly() throws IOException {
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        assertEquals("Num reduce phases should match", 3, protoResponse.getNumReducePhases());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        assertEquals("Can match phase took should be 0", 0L, protoPhaseTook.getCanMatch());
        assertEquals("Expand phase took should match", 5L, protoResponse.getPhaseTook().getExpand());  
        // Call the method under test  
        when(mockResponse.getFailedShards()).thenReturn(0);  
    public void testPhaseTookProtoUtilsToProto() {  
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
import org.opensearch.protobufs.PhaseTook;  
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));  
        assertEquals("Fetch phase took should match", 30L, protoResponse.getPhaseTook().getFetch());  
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);  
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        Map<String, Long> phaseTookMap = new HashMap<>();
        // Verify the result
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        assertEquals("Total clusters should match", 3, protoResponse.getXClusters().getTotal());
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(mockResponse.getPhaseTook()).thenReturn(phaseTook);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);  
        assertNotNull("Proto response should not be null", protoResponse);
        // Verify the result
        assertEquals("Fetch phase took should be 0", 0L, protoPhaseTook.getFetch());  
        // Create a mock SearchResponse with clusters  
        assertEquals("Took should match", 100, protoResponse.getTook());  
        // Create a mock SearchResponse with num reduce phases
    }
        when(mockResponse.getTotalShards()).thenReturn(5);
        assertNotNull("Proto response should not be null", protoResponse);
        // Call the method under test
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getFailedShards()).thenReturn(0);
    }  
        SearchResponse mockResponse = mock(SearchResponse.class);
        SearchResponseProtoUtils.PhaseTookProtoUtils.toProto(phaseTook, phaseTookBuilder);
        assertEquals("Successful clusters should match", 2, builder.getXClusters().getSuccessful());
import static org.mockito.Mockito.mock;
        when(mockResponse.isTimedOut()).thenReturn(false);  
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
    public void testToProtoWithClusters() throws IOException {
    public void testToProtoWithBasicResponse() throws IOException {
        when(mockResponse.isTerminatedEarly()).thenReturn(true);  
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getFailedShards()).thenReturn(0);  
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
}
    public void testToProtoWithPointInTimeId() throws IOException {
        assertEquals("DFS query phase took should match", 20L, protoResponse.getPhaseTook().getDfsQuery());
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);  
        SearchResponseProtoUtils.ClustersProtoUtils.toProto(builder, clusters);  
        assertTrue("Clusters should be present", builder.hasXClusters());  
import org.opensearch.search.SearchHits;
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        assertFalse("Timed out should be false", protoResponse.getTimedOut());
        phaseTookMap.put(SearchPhaseName.CAN_MATCH.getName(), 5L);
        when(mockResponse.isTimedOut()).thenReturn(false);  
        SearchResponse.Clusters clusters = new SearchResponse.Clusters(0, 0, 0);
        when(mockResponse.getTotalShards()).thenReturn(5);  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        assertNotNull("Proto response should not be null", protoResponse);
    }
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
        // Call the method under test
        when(mockResponse.getFailedShards()).thenReturn(0);
        SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
        SearchResponseProtoUtils.ClustersProtoUtils.toProto(builder, clusters);
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;  
import java.io.IOException;  
public class SearchResponseProtoUtilsTests extends OpenSearchTestCase {
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.isTimedOut()).thenReturn(false);  
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        PhaseTook protoPhaseTook = phaseTookBuilder.build();  
        PhaseTook protoPhaseTook = phaseTookBuilder.build();
        assertEquals("DFS query phase took should be 0", 0L, protoPhaseTook.getDfsQuery());
        assertNotNull("Proto response should not be null", protoResponse);
    }
import org.opensearch.action.search.ShardSearchFailure;
        assertEquals("DFS pre-query phase took should match", 10L, protoPhaseTook.getDfsPreQuery());
    public void testToProtoWithScrollId() throws IOException {
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
        assertEquals("Successful shards should match", 5, protoResponse.getXShards().getSuccessful());  
        // Create a mock SearchResponse with phase took  
        assertEquals("Total clusters should match", 3, builder.getXClusters().getTotal());
        phaseTookMap.put(SearchPhaseName.CAN_MATCH.getName(), 5L);
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        PhaseTook.Builder phaseTookBuilder = PhaseTook.newBuilder();
import org.opensearch.action.search.SearchResponseSections;  
    public void testToProtoWithPhaseTook() throws IOException {  
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        when(mockResponse.getTotalShards()).thenReturn(5);  
        // Create a mock SearchResponse.PhaseTook
        when(mockResponse.getNumReducePhases()).thenReturn(3);
        when(mockResponse.getFailedShards()).thenReturn(0);
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        assertTrue("Phase took should be present", protoResponse.hasPhaseTook());
        // Create a builder to populate
        when(mockResponse.getScrollId()).thenReturn("test_scroll_id");
        phaseTookMap.put(SearchPhaseName.EXPAND.getName(), 5L);
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
    }  
        // Verify the result  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("DFS query phase took should match", 20L, protoPhaseTook.getDfsQuery());  
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
 *
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        assertNotNull("Proto response should not be null", protoResponse);
        // Call the method under test
        // Create a mock SearchResponse with terminated early
    private final AggregateProtoConverterRegistry aggregateRegistry = new AggregateProtoConverterRegistryImpl();  
        // Call the method under test
    }
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        // Verify the result  
        assertFalse("Clusters should not be present", builder.hasXClusters());
        phaseTookMap.put(SearchPhaseName.DFS_QUERY.getName(), 20L);
    public void testClustersProtoUtilsToProtoWithZeroClusters() throws IOException {  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        // Create a builder to populate
        when(mockResponse.isTimedOut()).thenReturn(false);
 * this file be licensed under the Apache-2.0 license or a
        // Create a mock SearchResponse with point in time ID
    }  
import org.opensearch.common.unit.TimeValue;
        assertTrue("Clusters should be present", protoResponse.hasXClusters());  
        assertNotNull("Proto phase took should not be null", protoPhaseTook);
import org.opensearch.action.search.SearchPhaseName;
        when(mockResponse.getTotalShards()).thenReturn(5);
        phaseTookMap.put(SearchPhaseName.FETCH.getName(), 30L);
        // Verify the result
    }
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
 * compatible open source license.
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        assertEquals("Skipped clusters should match", 1, protoResponse.getXClusters().getSkipped());  
        assertEquals("DFS pre-query phase took should be 0", 0L, protoPhaseTook.getDfsPreQuery());
        // Call the method under test
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
        when(mockResponse.getFailedShards()).thenReturn(0);
        phaseTookMap.put(SearchPhaseName.DFS_QUERY.getName(), 20L);
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    }
        assertEquals("Fetch phase took should match", 30L, protoPhaseTook.getFetch());
        SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
        // Create a builder and call the method under test  
        // Verify the result
        org.opensearch.protobufs.SearchResponse protoResponse = SearchResponseProtoUtils.toProto(mockResponse, aggregateRegistry);
        when(mockResponse.getTotalShards()).thenReturn(5);
package org.opensearch.transport.grpc.proto.response.search;
    }
        SearchResponse mockResponse = mock(SearchResponse.class);  
import org.opensearch.test.OpenSearchTestCase;
import java.util.HashMap;
