            null
    }
 * compatible open source license.
import org.opensearch.index.query.MatchAllQueryBuilder;
import java.util.Map;
 */
    }
}
 * The OpenSearch Contributors require contributions made to
        }
    private PitTestsUtil() {}
            new ShardSearchContextId("c", 42),
        pitIds.add(pitId);
            new ShardSearchContextId("b", 12),
        List<String> pitIds = new ArrayList<>();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            return new IdsQueryBuilder().addIds(randomAlphaOfLength(10));
        InterruptedException {
            if (randomBoolean()) {
/*
        ActionFuture<GetAllPitNodesResponse> execute1 = client.execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(disNodesArr);
    }
        clusterStateRequest.local(false);
        if (!isEmpty) {
        pitSegmentsRequest = new PitSegmentsRequest();
import java.util.List;
import org.opensearch.common.unit.TimeValue;
        }
import org.opensearch.index.query.QueryBuilder;
        assertEquals(indicesSegmentResponse.getIndices().isEmpty(), isEmpty);
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(disNodesArr);
        if (randomBoolean()) {
    }
package org.opensearch.action.search;
        GetAllPitNodesResponse getPitResponse = execute1.get();
                aliasFilter = AliasFilter.EMPTY;
        final List<DiscoveryNode> nodes = new LinkedList<>();
import static org.junit.Assert.assertEquals;
            nodes.add(node);
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult2 = new SearchAsyncActionTests.TestSearchPhaseResult(
            null
        ClusterStateResponse clusterStateResponse = client.admin().cluster().state(clusterStateRequest).get();
            if (randomBoolean()) {
    public static void assertGetAllPitsEmpty(Client client) throws ExecutionException, InterruptedException {
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
            return new TermQueryBuilder(randomAlphaOfLength(10), randomAlphaOfLength(10));
        clusterStateRequest.local(false);
import org.opensearch.common.action.ActionFuture;
    public static void assertSegments(boolean isEmpty, Client client) {
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(indicesSegmentResponse.getIndices().isEmpty(), isEmpty);
/**
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        for (final DiscoveryNode node : clusterStateResponse.getState().nodes().getDataNodes().values()) {
 * SPDX-License-Identifier: Apache-2.0
            } else {
public class PitTestsUtil {
        GetAllPitNodesResponse getPitResponse = execute1.get();
    }
import static org.opensearch.test.OpenSearchTestCase.between;
            return new MatchAllQueryBuilder();
        );
        Assert.assertEquals(0, getPitResponse.getPitInfos().size());
        );
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
        Assert.assertEquals(getPitResponse.getPitInfos().get(0).getCreationTime(), creationTime);
    public static void assertSegments(boolean isEmpty, String index, long expectedShardSize, Client client, String pitId) {
import org.opensearch.search.internal.AliasFilter;
    public static String getPitId() {
        ClusterStateResponse clusterStateResponse = client.admin().cluster().state(clusterStateRequest).get();
import org.opensearch.common.util.concurrent.AtomicArray;
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];
import java.util.LinkedList;
        array.setOnce(0, testSearchPhaseResult1);
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult1 = new SearchAsyncActionTests.TestSearchPhaseResult(
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
        }
        for (final DiscoveryNode node : clusterStateResponse.getState().nodes().getDataNodes().values()) {
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
        PitSegmentsRequest pitSegmentsRequest;
        pitSegmentsRequest.clearAndSetPitIds(pitIds);
        ActionFuture<GetAllPitNodesResponse> execute1 = client.execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);
            assertEquals(expectedShardSize, indicesSegmentResponse.getIndices().get(index).getShards().size());
import org.opensearch.search.internal.ShardSearchContextId;
        );
            nodes.add(node);
        assertTrue(getPitResponse.getPitInfos().get(0).getPitId().contains(id));
                aliasFilter = new AliasFilter(randomQueryBuilder());
import org.opensearch.index.query.IdsQueryBuilder;
            new ShardSearchContextId("a", 1),
        testSearchPhaseResult1.setSearchShardTarget(new SearchShardTarget("node_1", new ShardId("idx", "uuid1", 2), null, null));
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");
import org.junit.Assert;
                aliasFilter = new AliasFilter(randomQueryBuilder(), "alias-" + between(1, 10));
            assertTrue(indicesSegmentResponse.getIndices().get(index).getIndex().equalsIgnoreCase(index));
    public static void assertSegments(boolean isEmpty, Client client, String pitId) {
        Assert.assertEquals(getPitResponse.getPitInfos().get(0).getKeepAlive(), keepAlive.getMillis());
        IndicesSegmentResponse indicesSegmentResponse = client.execute(PitSegmentsAction.INSTANCE, pitSegmentsRequest).actionGet();
        for (SearchPhaseResult result : array.asList()) {
        PitSegmentsRequest pitSegmentsRequest = new PitSegmentsRequest("_all");
    }
import org.opensearch.index.query.TermQueryBuilder;
        return SearchContextId.encode(array.asList(), aliasFilters, version);
        final Version version = Version.CURRENT;
            } else if (randomBoolean()) {
        } else {
        testSearchPhaseResult2.setSearchShardTarget(new SearchShardTarget("node_2", new ShardId("idy", "uuid2", 42), null, null));
            assertTrue(indicesSegmentResponse.getIndices().get(index) != null);
            }
            assertEquals(expectedShardSize, indicesSegmentResponse.getIndices().get(index).getShards().size());
    }
    }
        if (!isEmpty) {
        array.setOnce(1, testSearchPhaseResult2);
    public static void assertSegments(boolean isEmpty, String index, long expectedShardSize, Client client) {
        array.setOnce(2, testSearchPhaseResult3);
 * Helper class for common pit tests functions
        }
        assertSegments(isEmpty, "index", 2, client);
import org.opensearch.search.SearchShardTarget;
    public static void assertUsingGetAllPits(Client client, String id, long creationTime, TimeValue keepAlive) throws ExecutionException,
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    public static QueryBuilder randomQueryBuilder() {
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult3 = new SearchAsyncActionTests.TestSearchPhaseResult(
        assertTrue(indicesSegmentResponse.getShardFailures() == null || indicesSegmentResponse.getShardFailures().length == 0);
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");
import java.util.ArrayList;
        } else if (randomBoolean()) {
import org.opensearch.core.index.shard.ShardId;
import java.util.concurrent.ExecutionException;
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
            final AliasFilter aliasFilter;
        testSearchPhaseResult3.setSearchShardTarget(new SearchShardTarget("node_3", new ShardId("idy", "uuid2", 43), null, null));
import org.opensearch.transport.client.Client;
        assertTrue(indicesSegmentResponse.getShardFailures() == null || indicesSegmentResponse.getShardFailures().length == 0);
 *
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;
        IndicesSegmentResponse indicesSegmentResponse = client.execute(PitSegmentsAction.INSTANCE, pitSegmentsRequest).actionGet();
                aliasFilters.put(result.getSearchShardTarget().getShardId().getIndex().getUUID(), aliasFilter);
            assertTrue(indicesSegmentResponse.getIndices().get(index) != null);
import org.opensearch.search.SearchPhaseResult;
        }
            null
        nodes.toArray(disNodesArr);
        final List<DiscoveryNode> nodes = new LinkedList<>();
        final Map<String, AliasFilter> aliasFilters = new HashMap<>();
        assertSegments(isEmpty, "index", 2, client, pitId);
        nodes.toArray(disNodesArr);
            }
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;
            assertTrue(indicesSegmentResponse.getIndices().get(index).getIndex().equalsIgnoreCase(index));
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];
import org.opensearch.Version;
        }
        AtomicArray<SearchPhaseResult> array = new AtomicArray<>(3);
 */
