        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
                .build()
                .build()
        client().execute(CatShardsAction.INSTANCE, shardsRequest, new ActionListener<>() {
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
    }
    private CatShardsRequest getListShardsTransportRequest(String[] indices, String nextToken, final int pageSize) {
            "test-closed-idx",
        assertTrue(responseShardRouting.stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx-2")));
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        shardsRequest.setCancelAfterTimeInterval(NO_TIMEOUT);
        ensureGreen();
        createIndex(
        listShardsRequest = getListShardsTransportRequest(new String[] { dataStreamName }, numDataNodes * numDataNodes);
        CountDownLatch latch = new CountDownLatch(1);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-closed-idx", 0, false);
        ensureGreen();
        // Querying for closed index with wildcards: /_list/shards/test-closed-idx*
import java.util.concurrent.CountDownLatch;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
import java.util.concurrent.ExecutionException;
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-hidden-idx", 2, true);
    public void testListShardsWithClosedIndex() throws Exception {
        ActionFuture<CatShardsResponse> listShardsResponse;
        assertTrue(
            responseShardStats.stream().anyMatch(shardStats -> shardStats.getShardRouting().getIndexName().contains("test-closed-idx"))
    }
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx-2")).get();
            nextToken = listShardsResponse.get().getPageToken().getNextToken();
            Settings.builder()
                latch.countDown();
        shardsRequest.setIndices(Strings.EMPTY_ARRAY);
            "test",
            "test",
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        if (shardStatsExist) {
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test-hidden-idx").alias(aliasName));
        shardsRequest.setCancelAfterTimeInterval(timeoutInterval);
        );
/*
        List<String> masterNodes = internalCluster().startClusterManagerOnlyNodes(1);
        // Point test alias to both the indices (one being hidden while the other is closed)
import org.opensearch.cluster.metadata.IndexMetadata;
 *
import org.opensearch.common.action.ActionFuture;
            }
        );
                for (ShardRouting shard : shardRoutings) {
        List<String> nodes = internalCluster().startDataOnlyNodes(3);
 * The OpenSearch Contributors require contributions made to
        createIndex(
                .allMatch(shardStats -> shardStats.getShardRouting().getIndexName().equals("test-hidden-idx"))
    ) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        assertEquals(numIndices * numShards * (numReplicas + 1), listShardsResponse.get().getResponseShards().size());
    }
        // close index "test-closed-idx-1"
        List<ShardRouting> responseShardRouting = new ArrayList<>();
        listShardsRequest.setCancelAfterTimeInterval(NO_TIMEOUT);
            }
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-closed-idx", 2, false);
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, 100);
        // Since the ClusterStateAction underneath is invoked with lenientExpandOpen IndicesOptions,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        assertSingleIndexResponseShards(listShardsResponse.get(), dataStreamName, numDataNodes + 1, true);
        shardsRequest.clusterManagerNodeTimeout(timeValueMillis(2500));
            "test-hidden-idx",
        return getListShardsTransportRequest(indices, null, pageSize);
            }
        // should not output any closed shards.
        internalCluster().startClusterManagerOnlyNodes(1);
import org.opensearch.cluster.routing.ShardRouting;
        );
            "test-open-idx-1",
        // close index "test-closed-idx"
        assertTrue(listShardsResponse.get().getResponseShards().stream().anyMatch(shard -> shard.getIndexName().equals("test-hidden-idx")));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(masterNodes.get(0)));
        assertAcked(client().admin().indices().aliases(request).actionGet());
        // Explicitly querying for closed index: /_list/shards/test-closed-idx
        createIndex(
                .stream()
        CatShardsRequest listShardsRequest;
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx")).get();
            "test",
        internalCluster().startDataOnlyNodes(2);
            Settings.builder()
 * compatible open source license.
        internalCluster().startClusterManagerOnlyNodes(1);
import java.util.ArrayList;
        // close index "test-closed-idx"
        assertTrue(responseShardRouting.stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx-1")));
        final int numShards = 1;
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test-closed-idx").alias(aliasName));
    public void testListShardsWithClosedAndHiddenIndices() throws InterruptedException, ExecutionException {
            assertTrue(
        createDataStreamIndexTemplate("data-stream-template", List.of("logs-*"));
        );
import org.opensearch.action.admin.indices.stats.ShardStats;
        createIndex(
        createIndex(
                    assertNotNull(indicesStatsResponse.asMap().get(shard));
        listShardsRequest.setPageParams(new PageParams(nextToken, PageParams.PARAM_ASC_SORT_VALUE, pageSize));
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-hidden-idx" }, 100);
            Settings.builder()
        createIndex(
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-hidden-idx*" }, 100);
        internalCluster().startClusterManagerOnlyNodes(1);
        assertEquals(0, listShardsResponse.get().getResponseShards().size());
                .build()
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx")).get();
                .allMatch(shardStats -> shardStats.getShardRouting().getIndexName().equals("test-hidden-idx"))
        final int numIndices = 4;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        createIndex(
        assertSingleIndexResponseShards(listShardsResponse.get(), dataStreamName, numDataNodes + 1, true);
        );
    private void assertSingleIndexResponseShards(
            Arrays.stream(listShardsResponse.get().getIndicesStatsResponse().getShards())
        createIndex(
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
                assertSame(e.getClass(), TaskCancelledException.class);
                latch.countDown();
            Settings.builder()
        final int numDataNodes = 3;
        final int numShards = 1;
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, pageSize);
        listShardsRequest.setIndices(List.of("test-hidden-idx").toArray(new String[0]));
        ensureGreen();
        final int numReplicas = 1;
public class TransportCatShardsActionIT extends DataStreamTestCase {
            listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
import org.opensearch.transport.client.Requests;
        internalCluster().startClusterManagerOnlyNode(
        assertEquals(totalNumShards, catShardsResponse.getResponseShards().size());
        client().execute(CatShardsAction.INSTANCE, shardsRequest, new ActionListener<CatShardsResponse>() {
import org.opensearch.action.admin.indices.datastream.DataStreamTestCase;
        // should output closed shards without stats.
                .build()
        // Create data streams matching the "logs-*" index pattern.
    public void testCatShardsWithTimeoutException() throws IOException, AssertionError, InterruptedException {
            }
            listShardsResponse.get().getIndicesStatsResponse().getShards().length
        ensureGreen("test");
            public void onResponse(CatShardsResponse catShardsResponse) {
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        final int numReplicas = 2;
        assertTrue(catShardsResponse.getResponseShards().stream().allMatch(shard -> shard.getIndexName().contains(indexNamePattern)));
        );
        // Since the ClusterStateAction underneath is invoked with lenientExpandOpen IndicesOptions,
        assertAcked(client().admin().indices().aliases(request).actionGet());
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, numDataNodes * numDataNodes);
        final IndicesAliasesRequest request = new IndicesAliasesRequest().origin("allowed");
            public void onFailure(Exception e) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-hidden-idx", 0, false);
        internalCluster().startClusterManagerOnlyNodes(1);
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-hidden-idx", 2, true);
        assertEquals(2, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        // Verify result for a default query: "_list/shards"
                Arrays.stream(catShardsResponse.getIndicesStatsResponse().getShards())
                latch.countDown();
        // Verifying result when data stream is directly queried. Again, all the shards with stats should appear
        // Verify result when closed index is explicitly queried: "_list/shards"
    }
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        createIndex(
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        // Verifying response for default queries: /_list/shards
        );
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
import java.io.IOException;
                .build()
    }
import org.opensearch.common.unit.TimeValue;
                    "The cat shards action is expected to fail with a TaskCancelledException, but it received a successful response instead."
    public void testCatShardsWithSuccessResponse() throws InterruptedException {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
            Settings.builder()
        );
        createIndex(
                .build()
        List<String> nodes = internalCluster().startDataOnlyNodes(3);
        // Verifying default query's result. Data stream should have created a hidden backing index in the
        internalCluster().startClusterManagerOnlyNodes(1);
}
        );
                List<ShardRouting> shardRoutings = catShardsResponse.getResponseShards();
        // background and all the corresponding shards should appear in the response along with stats.
        final int numIndices = 4;
        );
        // Verifying response for default queries: /_list/shards
        // Restart cluster manager to restore cluster and allow test to cleanup and exit
        internalCluster().startDataOnlyNodes(3);
                    .allMatch(shardStats -> shardStats.getShardRouting().getIndexName().contains(indexNamePattern))
import java.util.List;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        String nextToken = null;
            "test-closed-idx-2",
        assertTrue(
            listShardsResponse.get()
        // Wildcards for hidden indices should not get resolved.
    }
        String dataStreamName = "logs-test";
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-closed-idx" }, 100);
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, 100);
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
        internalCluster().startClusterManagerOnlyNodes(1);
            @Override
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        listShardsRequest.setIndices(List.of("test-closed-idx").toArray(new String[0]));
        return listShardsRequest;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
                .anyMatch(shardStats -> shardStats.getShardRouting().getIndexName().equals("test-closed-idx"))
            @Override
        CatShardsRequest listShardsRequest = new CatShardsRequest();
        internalCluster().startDataOnlyNodes(3);
        ensureGreen();
        latch.await();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            (numIndices - 1) * numShards * (numReplicas + 1),
        listShardsRequest.setIndices(List.of("test-hidden-idx*").toArray(new String[0]));
        TimeValue timeoutInterval = timeValueMillis(1000);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                .build()
        final String aliasName = "test-alias";
        final int numShards = 1;
        ensureGreen();
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
                .build()
            );
        listShardsRequest.setIndices(indices);
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx")).get();
    }
            Settings.builder().put("node.name", masterNodes.get(0)).put(clusterManagerDataPathSettings).build()
import org.opensearch.test.OpenSearchIntegTestCase;
                .build()
    public void testListShardsWithHiddenIndex() throws Exception {
        // Dropping master node to delay in cluster state call.
        assertEquals(4, listShardsResponse.get().getResponseShards().size());
        final CatShardsRequest shardsRequest = new CatShardsRequest();
                latch.countDown();
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
        internalCluster().startDataOnlyNodes(2);
        assertTrue(listShardsResponse.get().getResponseShards().stream().allMatch(shard -> shard.getIndexName().equals("test-hidden-idx")));
            Settings.builder()
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        // all the shards should be part of response, however stats should not be displayed for closed index
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
            Arrays.stream(listShardsResponse.get().getIndicesStatsResponse().getShards())
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen();
        final int numShards = 1;
import org.opensearch.test.InternalTestCluster;
            responseShardStats.addAll(List.of(listShardsResponse.get().getIndicesStatsResponse().getShards()));
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
                    assertEquals("test", shard.getIndexName());
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
            public void onFailure(Exception e) {
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
                .build()
        assertEquals(0, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
            public void onResponse(CatShardsResponse catShardsResponse) {
import org.opensearch.common.settings.Settings;
        final int pageSize = numShards * (numReplicas + 1);
                .getResponseShards()
        final int numReplicas = 1;
                throw new AssertionError(
        );
        ensureGreen("test");
        latch.await();
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(new String[] { aliasName }, 100);
    public void testListShardsWithDataStream() throws Exception {
        // close index "test-closed-idx-2"
            responseShardRouting.addAll(listShardsResponse.get().getResponseShards());
        // Shards for hidden index should not appear in response with stats.
        final int numShards = 1;
        final int numReplicas = 2;
        assertEquals(shardStatsExist ? totalNumShards : 0, catShardsResponse.getIndicesStatsResponse().getShards().length);
        do {
            "test-2",
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        assertTrue(listShardsResponse.get().getResponseShards().stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx")));
            Settings.builder()
        // Verifying responses when hidden indices are explicitly queried: /_list/shards/test-hidden-idx
            "test-open-idx-2",
        });
        assertEquals(
            @Override
        final CatShardsRequest shardsRequest = new CatShardsRequest();
        assertEquals(numIndices * numShards * (numReplicas + 1), responseShardRouting.size());
            Settings.builder()
        );
        ensureGreen();
            Settings.builder()
        );
        createIndex(
        List<ShardStats> responseShardStats = new ArrayList<>();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        // Verifying responses when hidden indices are queried with wildcards: /_list/shards/test-hidden-idx*
                fail();
        shardsRequest.setIndices(Strings.EMPTY_ARRAY);
        listShardsRequest.setIndices(List.of("test-closed-idx*").toArray(new String[0]));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "60m")
        );
        );
        );
        assertFalse(
                .build()
            Arrays.stream(listShardsResponse.get().getIndicesStatsResponse().getShards())
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
    }
            Settings.builder()
                IndicesStatsResponse indicesStatsResponse = catShardsResponse.getIndicesStatsResponse();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        CountDownLatch latch = new CountDownLatch(1);
 * this file be licensed under the Apache-2.0 license or a
        createIndex(
            "test-closed-idx-1",
                assertEquals(e.getMessage(), "Cancellation timeout of " + timeoutInterval + " is expired");
    private CatShardsRequest getListShardsTransportRequest(String[] indices, final int pageSize) {
import static org.opensearch.search.SearchService.NO_TIMEOUT;
        internalCluster().startClusterManagerOnlyNodes(1);
        assertEquals(0, listShardsResponse.get().getResponseShards().size());
import org.opensearch.core.tasks.TaskCancelledException;
        assertEquals(0, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
        );
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-closed-idx", 2, false);
import org.opensearch.action.pagination.PageParams;
        boolean shardStatsExist
        // Verify result when hidden index is queried with wildcard: "_list/shards*"
        createDataStream(dataStreamName);
        // ShardsStats should only appear for 2 open indices
                .build()
            Settings.builder()
    public void testListShardsWithClosedIndicesAcrossPages() throws InterruptedException, ExecutionException {
        assertFalse(
            "test-closed-idx",
            listShardsResponse.get().getIndicesStatsResponse().getShards().length
import java.util.Arrays;
import org.opensearch.core.common.Strings;
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        );
        final int numReplicas = 1;
            "test-hidden-idx",
        final int pageSize = 100;
                .build()
        );
                // onResponse should not be called.
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .build()
        ensureGreen();
import org.opensearch.core.action.ActionListener;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        // Verify result for a default query: "_list/shards"
        // Wildcards for closed indices should not get resolved.
        assertTrue(
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "60m")
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(masterNodes.get(0));
        // close index "test-closed-idx"
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        internalCluster().startDataOnlyNodes(3);
            "test-closed-idx",
    }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        );
            Settings.builder()
        final int totalNumShards,
        assertEquals(0, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
        // Verify result when hidden index is explicitly queried: "_list/shards"
        });
        // Verifying result when an alias is explicitly queried.
            "test-hidden-idx",
        String indexNamePattern,
        } while (nextToken != null);
        assertTrue(listShardsResponse.get().getResponseShards().stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx")));
        assertEquals(2 * numShards * (numReplicas + 1), responseShardStats.size());
        // Verify result when closed index is queried with wildcard: "_list/shards*"
        }
            @Override
        internalCluster().startDataOnlyNodes(numDataNodes);
        // Create an index template for data streams.
        ensureGreen();
            listShardsResponse.get().getResponseShards().size(),
    public void testListShardsWithAliases() throws Exception {
package org.opensearch.action.admin.cluster.shards;
        assertEquals(
                );
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-closed-idx*" }, 100);
                .allMatch(shard -> shard.getIndexName().equals("test-hidden-idx") || shard.getIndexName().equals("test-closed-idx"))
        CatShardsResponse catShardsResponse,
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx-1")).get();
            Settings.builder()
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        // Shards for hidden index should appear in response along with stats
        );
            listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, nextToken, pageSize);
                }
        assertEquals(0, listShardsResponse.get().getResponseShards().size());
            Settings.builder()
 */
