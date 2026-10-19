    public void testListShardsWithHiddenIndex() throws Exception {  
        assertTrue(listShardsResponse.get().getResponseShards().stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx")));
        assertSingleIndexResponseShards(listShardsResponse.get(), dataStreamName, numDataNodes + 1, true);
    ) {
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, 100);
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.action.pagination.PageParams;
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-closed-idx", 2, false);  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
            public void onFailure(Exception e) {  
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);  
    }
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-hidden-idx*" }, 100);
import org.opensearch.core.action.ActionListener;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            Arrays.stream(listShardsResponse.get().getIndicesStatsResponse().getShards())
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
}  
        createIndex(
        // Restart cluster manager to restore cluster and allow test to cleanup and exit  
import static org.opensearch.search.SearchService.NO_TIMEOUT;  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        final int numDataNodes = 3;
        return listShardsRequest;
        createIndex(  
        // Verifying responses when hidden indices are queried with wildcards: /_list/shards/test-hidden-idx*
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx")).get();  
        assertEquals(numIndices * numShards * (numReplicas + 1), listShardsResponse.get().getResponseShards().size());
        );
        if (shardStatsExist) {
    }
            Settings.builder()  
        assertTrue(listShardsResponse.get().getResponseShards().stream().allMatch(shard -> shard.getIndexName().equals("test-hidden-idx")));
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-closed-idx", 2, false);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.opensearch.action.admin.indices.datastream.DataStreamTestCase;
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-hidden-idx", 2, true);  
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        );  
        // Shards for hidden index should appear in response along with stats
        final CatShardsRequest shardsRequest = new CatShardsRequest();
        );  
            "test-closed-idx",
        );
                }
 * SPDX-License-Identifier: Apache-2.0
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-closed-idx" }, 100);
        final int numShards = 1;
        internalCluster().startClusterManagerOnlyNodes(1);
        // Verify result when hidden index is explicitly queried: "_list/shards"
        // should output closed shards without stats.
import org.opensearch.common.unit.TimeValue;
        CountDownLatch latch = new CountDownLatch(1);
                .anyMatch(shardStats -> shardStats.getShardRouting().getIndexName().equals("test-closed-idx"))
        final int numShards = 1;  
        List<String> masterNodes = internalCluster().startClusterManagerOnlyNodes(1);  
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        );
import org.opensearch.core.tasks.TaskCancelledException;
        );  
            listShardsResponse.get().getIndicesStatsResponse().getShards().length  
                latch.countDown();
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertEquals(4, listShardsResponse.get().getResponseShards().size());
            "test",
            responseShardRouting.addAll(listShardsResponse.get().getResponseShards());
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);  
                    assertEquals("test", shard.getIndexName());
        assertEquals(  
            listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, nextToken, pageSize);
        // Verifying responses when hidden indices are explicitly queried: /_list/shards/test-hidden-idx  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-closed-idx*" }, 100);
        // Dropping master node to delay in cluster state call.
        final IndicesAliasesRequest request = new IndicesAliasesRequest().origin("allowed");
        List<String> nodes = internalCluster().startDataOnlyNodes(3);
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
        createIndex(
                .build()
        createDataStreamIndexTemplate("data-stream-template", List.of("logs-*"));
        // Verifying result when data stream is directly queried. Again, all the shards with stats should appear
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
        shardsRequest.setCancelAfterTimeInterval(timeoutInterval);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
            "test-2",
        ensureGreen();
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
                latch.countDown();
        ensureGreen();  
                for (ShardRouting shard : shardRoutings) {
    public void testCatShardsWithSuccessResponse() throws InterruptedException {  
            "test-open-idx-2",
                .build()
        // close index "test-closed-idx"
        });
        createIndex(
        // Wildcards for hidden indices should not get resolved.  
                .build()
        // should not output any closed shards.
        // Point test alias to both the indices (one being hidden while the other is closed)  
        shardsRequest.clusterManagerNodeTimeout(timeValueMillis(2500));
import org.opensearch.cluster.routing.ShardRouting;
        final String aliasName = "test-alias";
        List<ShardStats> responseShardStats = new ArrayList<>();  
import org.opensearch.test.InternalTestCluster;
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
        client().execute(CatShardsAction.INSTANCE, shardsRequest, new ActionListener<>() {
    public void testListShardsWithClosedIndex() throws Exception {
                throw new AssertionError(  
            "test",  
            Settings.builder()
            }  
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "60m")
        final int numShards = 1;
            Settings.builder()
        final int numShards = 1;
        ensureGreen();
        List<String> nodes = internalCluster().startDataOnlyNodes(3);
        );  
            Settings.builder()
        final int numReplicas = 1;
public class TransportCatShardsActionIT extends DataStreamTestCase {
    private CatShardsRequest getListShardsTransportRequest(String[] indices, String nextToken, final int pageSize) {
            Settings.builder()
        String nextToken = null;
                    .allMatch(shardStats -> shardStats.getShardRouting().getIndexName().contains(indexNamePattern))
        assertEquals(totalNumShards, catShardsResponse.getResponseShards().size());  
/*  
        final int numReplicas = 2;  
        listShardsRequest = getListShardsTransportRequest(new String[] { dataStreamName }, numDataNodes * numDataNodes);
            (numIndices - 1) * numShards * (numReplicas + 1),
        internalCluster().startClusterManagerOnlyNode(
    public void testListShardsWithAliases() throws Exception {
        internalCluster().startDataOnlyNodes(3);
        final CatShardsRequest shardsRequest = new CatShardsRequest();
            Settings.builder()
import java.util.ArrayList;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
                .build()  
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx-1")).get();
            }  
            }  
        internalCluster().startClusterManagerOnlyNodes(1);  
        createIndex(  
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx")).get();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        listShardsRequest = getListShardsTransportRequest(new String[] { "test-hidden-idx" }, 100);  
        assertAcked(client().admin().indices().aliases(request).actionGet());  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        });
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        // Verify result when closed index is explicitly queried: "_list/shards"  
        listShardsRequest.setCancelAfterTimeInterval(NO_TIMEOUT);
        );
                .build()
            "test-hidden-idx",  
            "test-closed-idx-2",
                    assertNotNull(indicesStatsResponse.asMap().get(shard));  
        internalCluster().startDataOnlyNodes(3);  
        assertAcked(client().admin().indices().aliases(request).actionGet());  
 * The OpenSearch Contributors require contributions made to  
        // Verify result for a default query: "_list/shards"  
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
            Settings.builder()
        internalCluster().startClusterManagerOnlyNodes(1);
                .build()
        internalCluster().startDataOnlyNodes(numDataNodes);
        internalCluster().startClusterManagerOnlyNodes(1);  
        internalCluster().startClusterManagerOnlyNodes(1);
        );
        return getListShardsTransportRequest(indices, null, pageSize);
            listShardsResponse.get().getResponseShards().size(),
        ensureGreen();
        assertEquals(0, listShardsResponse.get().getResponseShards().size());  
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, numDataNodes * numDataNodes);
                .stream()  
        internalCluster().startDataOnlyNodes(3);  
            Settings.builder().put("node.name", masterNodes.get(0)).put(clusterManagerDataPathSettings).build()
                .build()
        assertEquals(numIndices * numShards * (numReplicas + 1), responseShardRouting.size());
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx")).get();
        final int numIndices = 4;
import java.util.Arrays;
        final int pageSize = 100;
    }  
        );
        String dataStreamName = "logs-test";  
            listShardsResponse.get()
            nextToken = listShardsResponse.get().getPageToken().getNextToken();
import java.util.concurrent.ExecutionException;
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
            Settings.builder()
        // background and all the corresponding shards should appear in the response along with stats.  
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-closed-idx", 0, false);
        // Explicitly querying for closed index: /_list/shards/test-closed-idx  
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        assertEquals(0, listShardsResponse.get().getResponseShards().size());  
                .build()  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                // onResponse should not be called.
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);  
        assertSingleIndexResponseShards(listShardsResponse.get(), dataStreamName, numDataNodes + 1, true);  
        assertTrue(listShardsResponse.get().getResponseShards().stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx")));  
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        createIndex(
    private void assertSingleIndexResponseShards(
        assertEquals(2, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
        shardsRequest.setIndices(Strings.EMPTY_ARRAY);  
        listShardsRequest.setIndices(List.of("test-hidden-idx*").toArray(new String[0]));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        assertEquals(0, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
        ensureGreen();
                .allMatch(shardStats -> shardStats.getShardRouting().getIndexName().equals("test-hidden-idx"))
        List<ShardRouting> responseShardRouting = new ArrayList<>();
        );
            Settings.builder()
        CatShardsResponse catShardsResponse,  
                latch.countDown();
    }
        createIndex(
 * compatible open source license.
                    "The cat shards action is expected to fail with a TaskCancelledException, but it received a successful response instead."
        assertTrue(responseShardRouting.stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx-2")));
            Settings.builder()
            Arrays.stream(listShardsResponse.get().getIndicesStatsResponse().getShards())  
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, 100);
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test-closed-idx").alias(aliasName));
        // Wildcards for closed indices should not get resolved.
            Settings.builder()  
        internalCluster().startClusterManagerOnlyNodes(1);
    }
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)  
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen();
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        boolean shardStatsExist  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
package org.opensearch.action.admin.cluster.shards;
            public void onResponse(CatShardsResponse catShardsResponse) {
        assertTrue(  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                IndicesStatsResponse indicesStatsResponse = catShardsResponse.getIndicesStatsResponse();  
            Settings.builder()  
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test-hidden-idx").alias(aliasName));
        internalCluster().startDataOnlyNodes(2);
 *
        assertFalse(
        );
        );  
        // close index "test-closed-idx"
        assertTrue(responseShardRouting.stream().anyMatch(shard -> shard.getIndexName().equals("test-closed-idx-1")));  
        shardsRequest.setCancelAfterTimeInterval(NO_TIMEOUT);
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)  
            Arrays.stream(listShardsResponse.get().getIndicesStatsResponse().getShards())
        createIndex(  
        ensureGreen();
        ensureGreen();
        latch.await();
import java.util.concurrent.CountDownLatch;
            @Override
        client().admin().indices().close(Requests.closeIndexRequest("test-closed-idx-2")).get();
import java.io.IOException;  
            responseShardStats.addAll(List.of(listShardsResponse.get().getIndicesStatsResponse().getShards()));  
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "60m")
                assertSame(e.getClass(), TaskCancelledException.class);
                .getResponseShards()
            );
    private CatShardsRequest getListShardsTransportRequest(String[] indices, final int pageSize) {
        assertEquals(0, listShardsResponse.get().getIndicesStatsResponse().getShards().length);
        // Since the ClusterStateAction underneath is invoked with lenientExpandOpen IndicesOptions,
    }
        );
                .build()
        );  
        createDataStream(dataStreamName);  
        // all the shards should be part of response, however stats should not be displayed for closed index  
    }  
            @Override  
    public void testListShardsWithClosedIndicesAcrossPages() throws InterruptedException, ExecutionException {  
            listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);  
        String indexNamePattern,
        ensureGreen("test");
                .build()
        assertFalse(  
        );  
            public void onFailure(Exception e) {  
            public void onResponse(CatShardsResponse catShardsResponse) {  
                .build()  
        // Verifying result when an alias is explicitly queried.  
        ensureGreen();
import org.opensearch.core.common.Strings;  
        final int totalNumShards,
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(masterNodes.get(0));  
        latch.await();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        assertEquals(0, listShardsResponse.get().getResponseShards().size());
                .build()
        ensureGreen("test");
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(new String[] { aliasName }, 100);
    }
        // Querying for closed index with wildcards: /_list/shards/test-closed-idx*
            responseShardStats.stream().anyMatch(shardStats -> shardStats.getShardRouting().getIndexName().contains("test-closed-idx"))
        listShardsRequest.setIndices(List.of("test-hidden-idx").toArray(new String[0]));
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        );  
            }
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-hidden-idx", 2, true);
        listShardsRequest.setIndices(indices);
        final int numShards = 1;
        listShardsRequest.setIndices(List.of("test-closed-idx*").toArray(new String[0]));  
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);  
        );  
        final int numReplicas = 1;  
            listShardsResponse.get().getIndicesStatsResponse().getShards().length
        createIndex(
        }  
                .build()
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);  
        createIndex(  
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        final int pageSize = numShards * (numReplicas + 1);
        );
        assertSingleIndexResponseShards(listShardsResponse.get(), "test-hidden-idx", 0, false);
            Settings.builder()  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(masterNodes.get(0)));
    public void testListShardsWithClosedAndHiddenIndices() throws InterruptedException, ExecutionException {
            "test-open-idx-1",
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.action.admin.indices.stats.ShardStats;
            assertTrue(
        CatShardsRequest listShardsRequest = new CatShardsRequest();  
        assertTrue(listShardsResponse.get().getResponseShards().stream().anyMatch(shard -> shard.getIndexName().equals("test-hidden-idx")));
                Arrays.stream(catShardsResponse.getIndicesStatsResponse().getShards())  
import org.opensearch.common.settings.Settings;  
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
import org.opensearch.transport.client.Requests;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
        assertEquals(shardStatsExist ? totalNumShards : 0, catShardsResponse.getIndicesStatsResponse().getShards().length);
        // Since the ClusterStateAction underneath is invoked with lenientExpandOpen IndicesOptions,  
        // Verify result for a default query: "_list/shards"
        );  
    public void testCatShardsWithTimeoutException() throws IOException, AssertionError, InterruptedException {
        // close index "test-closed-idx"  
            "test",  
        // close index "test-closed-idx-2"  
            "test-closed-idx",
        CatShardsRequest listShardsRequest = getListShardsTransportRequest(Strings.EMPTY_ARRAY, pageSize);
        assertTrue(  
        );  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                latch.countDown();  
        internalCluster().startClusterManagerOnlyNodes(1);
        );  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
            "test-closed-idx-1",  
        TimeValue timeoutInterval = timeValueMillis(1000);  
        listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
import org.opensearch.cluster.metadata.IndexMetadata;  
import java.util.List;  
        assertEquals(0, listShardsResponse.get().getIndicesStatsResponse().getShards().length);  
    public void testListShardsWithDataStream() throws Exception {
        assertEquals(
            @Override
                .allMatch(shard -> shard.getIndexName().equals("test-hidden-idx") || shard.getIndexName().equals("test-closed-idx"))
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            "test-hidden-idx",  
        // Verifying response for default queries: /_list/shards
            @Override
                fail();
                List<ShardRouting> shardRoutings = catShardsResponse.getResponseShards();
        final int numReplicas = 2;
        createIndex(
        ActionFuture<CatShardsResponse> listShardsResponse = client().execute(CatShardsAction.INSTANCE, listShardsRequest);
        client().execute(CatShardsAction.INSTANCE, shardsRequest, new ActionListener<CatShardsResponse>() {
        shardsRequest.setIndices(Strings.EMPTY_ARRAY);  
        assertTrue(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
import org.opensearch.common.action.ActionFuture;
        // Verifying default query's result. Data stream should have created a hidden backing index in the
        assertEquals(2 * numShards * (numReplicas + 1), responseShardStats.size());
        createIndex(
    }  
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
        final int numReplicas = 1;  
        // close index "test-closed-idx-1"  
 */  
        // Verify result when closed index is queried with wildcard: "_list/shards*"
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
        // Verify result when hidden index is queried with wildcard: "_list/shards*"
            Settings.builder()
                assertEquals(e.getMessage(), "Cancellation timeout of " + timeoutInterval + " is expired");
        final int numIndices = 4;
        listShardsRequest.setIndices(List.of("test-closed-idx").toArray(new String[0]));
        } while (nextToken != null);
        // Verifying response for default queries: /_list/shards
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
                .build()  
        // Create data streams matching the "logs-*" index pattern.
        CatShardsRequest listShardsRequest;
                .allMatch(shardStats -> shardStats.getShardRouting().getIndexName().equals("test-hidden-idx"))
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        // Shards for hidden index should not appear in response with stats.  
                );
        ActionFuture<CatShardsResponse> listShardsResponse;  
        // ShardsStats should only appear for 2 open indices  
        do {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
            "test-closed-idx",
            "test-hidden-idx",  
        listShardsRequest.setPageParams(new PageParams(nextToken, PageParams.PARAM_ASC_SORT_VALUE, pageSize));  
        // Create an index template for data streams.  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        assertTrue(catShardsResponse.getResponseShards().stream().allMatch(shard -> shard.getIndexName().contains(indexNamePattern)));
