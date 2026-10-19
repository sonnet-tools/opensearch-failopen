    public static String getPitId() {
        array.setOnce(1, testSearchPhaseResult2);
import org.opensearch.search.SearchShardTarget;
            assertTrue(indicesSegmentResponse.getIndices().get(index).getIndex().equalsIgnoreCase(index));
        } else if (randomBoolean()) {  
                aliasFilters.put(result.getSearchShardTarget().getShardId().getIndex().getUUID(), aliasFilter);
            null
 * The OpenSearch Contributors require contributions made to  
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];  
import java.util.concurrent.ExecutionException;
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult3 = new SearchAsyncActionTests.TestSearchPhaseResult(
        ActionFuture<GetAllPitNodesResponse> execute1 = client.execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);  
        List<String> pitIds = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
            return new MatchAllQueryBuilder();
    }
        PitSegmentsRequest pitSegmentsRequest = new PitSegmentsRequest("_all");
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    }
        nodes.toArray(disNodesArr);
    }
            if (randomBoolean()) {  
import org.opensearch.search.internal.ShardSearchContextId;
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
        clusterStateRequest.local(false);
        }  
        testSearchPhaseResult1.setSearchShardTarget(new SearchShardTarget("node_1", new ShardId("idx", "uuid1", 2), null, null));
        AtomicArray<SearchPhaseResult> array = new AtomicArray<>(3);
 * compatible open source license.
        } else {
            } else if (randomBoolean()) {
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(disNodesArr);
        if (randomBoolean()) {
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
        final Map<String, AliasFilter> aliasFilters = new HashMap<>();
            assertEquals(expectedShardSize, indicesSegmentResponse.getIndices().get(index).getShards().size());
        }
import org.opensearch.cluster.node.DiscoveryNode;
        if (!isEmpty) {
        InterruptedException {
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult2 = new SearchAsyncActionTests.TestSearchPhaseResult(
        testSearchPhaseResult3.setSearchShardTarget(new SearchShardTarget("node_3", new ShardId("idy", "uuid2", 43), null, null));
        PitSegmentsRequest pitSegmentsRequest;  
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;  
import java.util.HashMap;  
import org.opensearch.transport.client.Client;
        pitIds.add(pitId);  
            } else {  
        }  
            null  
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(disNodesArr);
        array.setOnce(2, testSearchPhaseResult3);
        assertTrue(indicesSegmentResponse.getShardFailures() == null || indicesSegmentResponse.getShardFailures().length == 0);  
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];
        GetAllPitNodesResponse getPitResponse = execute1.get();  
            assertEquals(expectedShardSize, indicesSegmentResponse.getIndices().get(index).getShards().size());
            final AliasFilter aliasFilter;
                aliasFilter = AliasFilter.EMPTY;
        final List<DiscoveryNode> nodes = new LinkedList<>();
import static org.junit.Assert.assertEquals;  
import java.util.LinkedList;
import java.util.ArrayList;
import org.opensearch.index.query.IdsQueryBuilder;  
        assertTrue(indicesSegmentResponse.getShardFailures() == null || indicesSegmentResponse.getShardFailures().length == 0);  
    private PitTestsUtil() {}
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
package org.opensearch.action.search;
    public static void assertGetAllPitsEmpty(Client client) throws ExecutionException, InterruptedException {  
 * Helper class for common pit tests functions
    public static void assertSegments(boolean isEmpty, String index, long expectedShardSize, Client client, String pitId) {
        for (SearchPhaseResult result : array.asList()) {  
    }  
        pitSegmentsRequest.clearAndSetPitIds(pitIds);
 */
                aliasFilter = new AliasFilter(randomQueryBuilder(), "alias-" + between(1, 10));
            assertTrue(indicesSegmentResponse.getIndices().get(index).getIndex().equalsIgnoreCase(index));
        Assert.assertEquals(0, getPitResponse.getPitInfos().size());
import org.junit.Assert;  
            new ShardSearchContextId("c", 42),
        for (final DiscoveryNode node : clusterStateResponse.getState().nodes().getDataNodes().values()) {
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");  
    public static void assertSegments(boolean isEmpty, Client client, String pitId) {
        );  
        testSearchPhaseResult2.setSearchShardTarget(new SearchShardTarget("node_2", new ShardId("idy", "uuid2", 42), null, null));  
        array.setOnce(0, testSearchPhaseResult1);  
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
        if (!isEmpty) {
        final List<DiscoveryNode> nodes = new LinkedList<>();
    public static void assertUsingGetAllPits(Client client, String id, long creationTime, TimeValue keepAlive) throws ExecutionException,
    }
        }
    public static void assertSegments(boolean isEmpty, String index, long expectedShardSize, Client client) {  
import org.opensearch.search.SearchPhaseResult;
        pitSegmentsRequest = new PitSegmentsRequest();
            new ShardSearchContextId("a", 1),
    }
        assertEquals(indicesSegmentResponse.getIndices().isEmpty(), isEmpty);
import org.opensearch.search.internal.AliasFilter;  
        IndicesSegmentResponse indicesSegmentResponse = client.execute(PitSegmentsAction.INSTANCE, pitSegmentsRequest).actionGet();
        ActionFuture<GetAllPitNodesResponse> execute1 = client.execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);
        return SearchContextId.encode(array.asList(), aliasFilters, version);
            return new TermQueryBuilder(randomAlphaOfLength(10), randomAlphaOfLength(10));
        nodes.toArray(disNodesArr);  
/**  
            if (randomBoolean()) {
import org.opensearch.index.query.MatchAllQueryBuilder;
        Assert.assertEquals(getPitResponse.getPitInfos().get(0).getCreationTime(), creationTime);
        ClusterStateResponse clusterStateResponse = client.admin().cluster().state(clusterStateRequest).get();
    public static void assertSegments(boolean isEmpty, Client client) {  
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult1 = new SearchAsyncActionTests.TestSearchPhaseResult(  
import org.opensearch.index.query.QueryBuilder;
        final Version version = Version.CURRENT;
            }
        }
        );
        assertSegments(isEmpty, "index", 2, client, pitId);
import static org.junit.Assert.assertTrue;
import org.opensearch.core.index.shard.ShardId;
    }
public class PitTestsUtil {  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;
        IndicesSegmentResponse indicesSegmentResponse = client.execute(PitSegmentsAction.INSTANCE, pitSegmentsRequest).actionGet();
        ClusterStateResponse clusterStateResponse = client.admin().cluster().state(clusterStateRequest).get();  
        GetAllPitNodesResponse getPitResponse = execute1.get();
}
        clusterStateRequest.local(false);
                aliasFilter = new AliasFilter(randomQueryBuilder());  
/*  
import org.opensearch.Version;
    }  
        assertTrue(getPitResponse.getPitInfos().get(0).getPitId().contains(id));
        assertSegments(isEmpty, "index", 2, client);
        assertEquals(indicesSegmentResponse.getIndices().isEmpty(), isEmpty);
import java.util.Map;  
    public static QueryBuilder randomQueryBuilder() {  
import org.opensearch.common.action.ActionFuture;
import org.opensearch.common.util.concurrent.AtomicArray;
 *
            return new IdsQueryBuilder().addIds(randomAlphaOfLength(10));  
import static org.opensearch.test.OpenSearchTestCase.between;  
import org.opensearch.index.query.TermQueryBuilder;  
            new ShardSearchContextId("b", 12),  
            assertTrue(indicesSegmentResponse.getIndices().get(index) != null);  
        }  
            }
        );
        Assert.assertEquals(getPitResponse.getPitInfos().get(0).getKeepAlive(), keepAlive.getMillis());  
            assertTrue(indicesSegmentResponse.getIndices().get(index) != null);  
            null
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
            nodes.add(node);
            nodes.add(node);  
        for (final DiscoveryNode node : clusterStateResponse.getState().nodes().getDataNodes().values()) {  
import java.util.List;
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");
