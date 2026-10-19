        pitIds.add(id);
        nodes.toArray(disNodesArr);
                        public void onFailure(Exception e) {}
                // failure for node drop
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
    }  
                            public void onResponse(DeletePitResponse deletePitResponse) {
import org.opensearch.action.search.DeletePitRequest;  
                SearchResponse searchResponse = client().prepareSearch("index")  
                            @Override
                int currentThreadIteration = i;
        assertEquals(expectedPitCurrent, pitCurrent);
 * Multi node integration tests for PIT creation and search operation with PIT ID.  
        createPitRequest.setIndices(new String[] { "index" });
    }  
            for (int i = 0; i < concurrentRuns; i++) {
    public void testGetAllPits() throws Exception {  
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(getDiscoveryNodes());  
    @ParametersFactory
        assertThat(exc.getMessage(), containsString("was (2m > 1m)"));  
                // If the search must make a transport call to start the search then a
import org.opensearch.action.search.CreatePitAction;
                            }  
        assertEquals(3, getPitResponse.getPitInfos().size());  
        return disNodesArr;
                Runnable thread = () -> {  
    public void testPit() throws Exception {
import java.util.Arrays;
import org.opensearch.action.search.DeletePitAction;
}
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);  
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "3m"))  
            }  
                            public void onResponse(CreatePitResponse createPitResponse) {
        TestThreadPool testThreadPool = null;
                int currentThreadIteration = i;
            countDownLatch.await();  
                operationThreads.add(thread);
            public Settings onNodeStopped(String nodeName) throws Exception {
                .cluster()  
        List<String> resultPitIds = getPitResponse.getPitInfos().stream().map(p -> p.getPitId()).collect(Collectors.toList());
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
import org.opensearch.action.search.CreatePitRequest;  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);  
            .get();  
                            @Override
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
import org.opensearch.core.action.ActionListener;
            for (int i = 0; i < concurrentRuns; i++) {
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(disNodesArr);  
            }  
        Assert.assertTrue(resultPitIds.contains(pitResponse2.getId()));
        InterruptedException {  
        ClusterStateResponse clusterStateResponse = client().admin().cluster().state(clusterStateRequest).get();
                assertEquals(1, searchResponse.getSuccessfulShards());  
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
        ClusterStateResponse clusterStateResponse = client().admin().cluster().state(clusterStateRequest).get();
 * compatible open source license.
                    }, countDownLatch);  
    public void validatePitStats(String index, long expectedPitCurrent, long expectedOpenContexts) throws ExecutionException,
                // observe non-zero PIT stats, so we poll here and wait for stats to eventually
                .setPersistentSettings(Settings.builder().put("point_in_time.max_keep_alive", "1m").put("search.default_keep_alive", "2m"))  
        indicesStatsRequest.all();
                        public void onResponse(CreatePitResponse createPitResponse) {
    public void clearIndex() {
public class PitMultiNodeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                validatePitStats("index", 1, 1);
        flush(); // clear the translog to ensure accurate stats
/*  
                .prepareUpdateSettings()  
        CreatePitResponse pitResponse = execute.get();
            @Override  
            testThreadPool = new TestThreadPool(PitMultiNodeIT.class.getName());
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
            @Override
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.action.search.GetAllPitNodesResponse;  
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
    }
import java.util.concurrent.CountDownLatch;
        });
            () -> client().admin()  
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
    private DiscoveryNode[] getDiscoveryNodes() throws ExecutionException, InterruptedException {  
        });  
                GetAllPitNodesResponse getPitResponse = execute1.get();
        assertThat(exc.getMessage(), containsString("was (1m > 30s)"));
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<DeletePitResponse>() {  
import org.opensearch.action.LatchedActionListener;  
        // asserting that we get all unique PIT IDs
import static org.hamcrest.Matchers.containsString;  
import org.junit.After;  
        assertEquals(expectedOpenContexts, openContexts);  
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        createPitRequest.setIndices(new String[] { "index" });
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
    }
                .setPersistentSettings(Settings.builder().putNull("*"))  
            }
                // will end up racing with the PIT decrement call and can very briefly
    public void testGetAllPitsDuringNodeDrop() throws Exception {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
                assertEquals(2, pitResponse.getTotalShards());
        assertEquals(2, searchResponse.getSuccessfulShards());
            }
            assertEquals(concurrentRuns, numSuccess.get());
                .cluster()
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import org.opensearch.action.search.GetAllPitNodesRequest;
        );
        assertEquals(2, searchResponse.getTotalShards());
import org.opensearch.action.search.PitTestsUtil;
    }  
                            public void onFailure(Exception e) {}  
import static org.opensearch.action.search.PitTestsUtil.assertSegments;
            .setSize(2)
            @Override
                        @Override  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                            @Override  
                operationThreads.add(thread);  
            countDownLatch.await();
            long randomDeleteThread = randomLongBetween(0, concurrentRuns - 1);  
        ensureGreen();  
import org.opensearch.threadpool.ThreadPool;
        );
        } finally {  
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(getDiscoveryNodes());
        assertAcked(
        );  
                    pitResponse.getId(),
        Set<String> createSet = new HashSet<>();  
                PitTestsUtil.assertUsingGetAllPits(
        clusterStateRequest.local(false);
                            }
        exc = expectThrows(
            IllegalArgumentException.class,
                .setTransientSettings(Settings.builder().putNull("*"))
        SearchResponse searchResponse = client().prepareSearch("index")  
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
            public Settings onNodeStopped(String nodeName) throws Exception {  
                            @Override
                                    numSuccess.incrementAndGet();  
        request.setIndices(new String[] { "index" });
import org.opensearch.cluster.node.DiscoveryNode;
    }  
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
                ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        String id = client().execute(CreatePitAction.INSTANCE, createPitRequest).get().getId();  
                };
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
import java.util.concurrent.atomic.AtomicInteger;
    public PitMultiNodeIT(Settings settings) {
        client().admin().indices().prepareDelete("index").get();
                    TimeValue.timeValueDays(1)  
            int concurrentRuns = randomIntBetween(20, 50);
                .cluster()
        super(settings);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                };
        request.setIndices(new String[] { "index" });
                        }, countDownLatch);
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
        try {  
        TestThreadPool testThreadPool = null;
            }
        final List<DiscoveryNode> nodes = new LinkedList<>(clusterStateResponse.getState().nodes().getDataNodes().values());
    }  
        );
            long randomDeleteThread = randomLongBetween(0, concurrentRuns - 1);  
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<DeletePitResponse>() {  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        }
        final List<DiscoveryNode> nodes = new LinkedList<>();  
                    .setSize(2)
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).get();
    @After  
                ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
                // we still get a pit id from the data node which is up
    public static Collection<Object[]> parameters() {  
                    client(),  
                    pitResponse.getId(),
                        client().execute(CreatePitAction.INSTANCE, createPitRequest, listener);
        long openContexts = indicesStatsResponse.getIndex(index).getTotal().search.getOpenContexts();
import java.util.Set;
            assertEquals(concurrentRuns, numSuccess.get());
                return super.onNodeStopped(nodeName);
                );
                // PIT context may be temporarily created on a separate thread. The test  
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
            int concurrentRuns = randomIntBetween(20, 50);
                            }  
        Assert.assertTrue(resultPitIds.contains(pitResponse.getId()));  
        assertSegments(false, client(), pitResponse.getId());
                .get()
                        }, countDownLatch);  
            }  
                    .get();  
                    TimeValue.timeValueDays(1)
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "5m").put("point_in_time.max_keep_alive", "5m"))
    }
                assertEquals(2, searchResponse.getTotalShards());  
                };
                );
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                    .setSize(2)
            TestThreadPool finalTestThreadPool = testThreadPool;
import org.opensearch.test.OpenSearchIntegTestCase;
                assertTrue(ex.getMessage().contains("Failed to execute phase [create_pit]"));
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));  
                return super.onNodeStopped(nodeName);
                    .execute();
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
    public void setupIndex() throws ExecutionException, InterruptedException {
    public void testPitSearchWithNodeDropWithPartialSearchResultsFalse() throws Exception {
import java.util.HashSet;
        String id = client().execute(CreatePitAction.INSTANCE, createPitRequest).get().getId();  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            countDownLatch.await();  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                                if (createSet.add(createPitResponse.getId())) {
        CreatePitResponse pitResponse2 = client().execute(CreatePitAction.INSTANCE, request).get();
        assertThat(exc.getMessage(), containsString("was (3m > 2m)"));  
                            }
                    LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
                PitTestsUtil.assertUsingGetAllPits(  
    public void testCreatePitWhileNodeDropWithAllowPartialCreationTrue() throws Exception {
        );
    }  
                                }
                .get()  
    }
            TestThreadPool finalTestThreadPool = testThreadPool;
                ExecutionException ex = expectThrows(ExecutionException.class, execute::get);  
                assertEquals(1, searchResponse.getSuccessfulShards());
        createPitRequest.setIndices(new String[] { "index" });
                .get()  
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import org.junit.Before;
                                    numSuccess.incrementAndGet();
import java.util.stream.Collectors;  
                // resolve to zero. In almost all cases the first call will observe zero stats.  
        }
            client().admin()
                assertEquals(0, searchResponse.getSkippedShards());
                assertEquals(1, searchResponse.getTotalShards());
import java.util.Collection;  
            List<Runnable> operationThreads = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;  
        request.setIndices(new String[] { "index" });
import java.util.concurrent.ExecutionException;  
import org.opensearch.search.builder.PointInTimeBuilder;  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import org.opensearch.common.action.ActionFuture;
        List<String> pitIds = new ArrayList<>();
            client().admin()
                        client().execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
                .prepareUpdateSettings()
import org.opensearch.action.search.DeletePitResponse;
        CreatePitResponse pitResponse = execute.get();
                    if (currentThreadIteration == randomDeleteThread) {
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {  
        validatePitStats("index", 2, 2);  
        indexRandomForConcurrentSearch("index");
        // Test stats
                assertEquals(1, pitResponse.getSuccessfulShards());
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "2m"))  
        Assert.assertTrue(resultPitIds.contains(pitResponse1.getId()));
            public Settings onNodeStopped(String nodeName) throws Exception {
                    logger.info("Triggering pit create --->");
        AtomicInteger numSuccess = new AtomicInteger();
import java.util.LinkedList;
            @Override  
        client().admin().indices().prepareCreate("index1").get();
        clusterStateRequest.local(false);  
        pitIds.add(id);
            for (int i = 0; i < concurrentRuns; i++) {
    }  
        GetAllPitNodesResponse getPitResponse = execute1.get();
                    pitResponse.getCreationTime(),
                assertEquals(1, getPitResponse.getPitInfos().size());  
                SearchResponse searchResponse = client().prepareSearch()
package org.opensearch.search.pit;
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<GetAllPitNodesResponse>() {
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
    public void testPitSearchWithNodeDrop() throws Exception {  
                                numSuccess.incrementAndGet();  
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");  
                .prepareUpdateSettings()
        flush(); // clear the translog to ensure accurate stats  
        CreatePitResponse pitResponse = execute.get();
                .prepareUpdateSettings()
        });
        assertAcked(
        assertAcked(
        });  
        );  
                validatePitStats("index", 1, 1);  
    }
                .get()
        AtomicInteger numSuccess = new AtomicInteger();
 *
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
                ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
            nodes.add(node);
        for (final DiscoveryNode node : clusterStateResponse.getState().nodes().getDataNodes().values()) {
                operationThreads.add(thread);
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
                Runnable thread = () -> {  
                        client().execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
                assertEquals(1, searchResponse.getFailedShards());
                .cluster()
                            public void onResponse(GetAllPitNodesResponse getAllPitNodesResponse) {
        CreatePitResponse pitResponse1 = client().execute(CreatePitAction.INSTANCE, request).get();  
                .prepareUpdateSettings()
                                if (deletePitResponse.getDeletePitResults().get(0).isSuccessful()) {  
        client().admin().indices().prepareDelete("index1").get();  
        indicesStatsRequest.indices(index);  
                    .setSize(2)  
                assertTrue(ex.getMessage().contains("Partial shards failure"));  
                return super.onNodeStopped(nodeName);
            @Override
                    }  
        request.setIndices(new String[] { "index" });
                            @Override
                    pitResponse.getCreationTime(),  
        );
 * this file be licensed under the Apache-2.0 license or a
        CreatePitResponse pitResponse = execute.get();
        long pitCurrent = indicesStatsResponse.getIndex(index).getTotal().search.getTotal().getPitCurrent();  
        List<String> pitIds = new ArrayList<>();
                    }  
        int concurrentRuns = randomIntBetween(20, 50);  
                    .get();
        ActionFuture<GetAllPitNodesResponse> execute1 = client().execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);
import org.opensearch.action.search.GetAllPitsAction;
                ActionFuture<SearchResponse> execute = client().prepareSearch()  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 */  
    }
                            }
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "1m"))
import org.opensearch.test.InternalTestCluster;
                                }
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");
            client().admin()
                    if (currentThreadIteration == randomDeleteThread) {
                assertTrue(getPitResponse.failures().get(0).getMessage().contains("Failed node"));  
import java.util.ArrayList;
        TestThreadPool testThreadPool = null;
        } finally {  
        AtomicInteger numSuccess = new AtomicInteger();
        });  
            IllegalArgumentException.class,  
    }
                        }
        request.setIndices(new String[] { "index", "index1" });  
                .prepareUpdateSettings()
            public Settings onNodeStopped(String nodeName) throws Exception {
        try {  
            IllegalArgumentException.class,
                    client(),
        assertAcked(  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
import org.opensearch.common.unit.TimeValue;
            List<Runnable> operationThreads = new ArrayList<>();
                .get()
    public void testCreatePitWhileNodeDropWithAllowPartialCreationFalse() throws Exception {
    public void testPitInvalidDefaultKeepAlive() {  
                        }, countDownLatch);
                return super.onNodeStopped(nodeName);
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
                            @Override
                    client().execute(CreatePitAction.INSTANCE, createPitRequest, listener);
                .cluster()
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            List<Runnable> operationThreads = new ArrayList<>();
                ActionFuture<GetAllPitNodesResponse> execute1 = client().execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);  
                    } else {
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), false);  
                        @Override
        IllegalArgumentException exc = expectThrows(
            testThreadPool = new TestThreadPool(PitMultiNodeIT.class.getName());
            client().admin()  
            assertEquals(concurrentRuns, numSuccess.get());
                return super.onNodeStopped(nodeName);
    public void testConcurrentGetWithDeletes() throws InterruptedException, ExecutionException {
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);  
            TestThreadPool finalTestThreadPool = testThreadPool;
            public Settings onNodeStopped(String nodeName) throws Exception {
                .setPersistentSettings(Settings.builder().put("point_in_time.max_keep_alive", "30s"))
                .setPersistentSettings(Settings.builder().put("point_in_time.max_keep_alive", "2m"))
                assertSegments(false, "index", 1, client(), pitResponse.getId());  
            Set<String> createSet = new HashSet<>();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                .cluster()  
            }  
                .cluster()
                            public void onFailure(Exception e) {}
        nodes.toArray(disNodesArr);
                                }
                    } else {
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];
                        client().execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest, listener);
        request.setIndices(new String[] { "index" });  
        return Arrays.asList(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            }
        request.setIndices(new String[] { "index" });  
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.action.search.CreatePitResponse;
                            @Override  
                            public void onResponse(DeletePitResponse deletePitResponse) {
    }
        }  
                                    numSuccess.incrementAndGet();
                                }
    public void testConcurrentCreatesWithDeletes() throws InterruptedException, ExecutionException {
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                .get()
        }
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());  
                                    numSuccess.incrementAndGet();  
import java.util.concurrent.TimeUnit;
                                if (deletePitResponse.getDeletePitResults().get(0).isSuccessful()) {  
        exc = expectThrows(
            () -> client().admin()  
                            public void onFailure(Exception e) {}
        assertAcked(
            client().admin()  
import org.opensearch.common.settings.Settings;  
                assertBusy(() -> validatePitStats("index", 0, 0));
                .prepareUpdateSettings()  
                .prepareUpdateSettings()
                            if (createSet.add(createPitResponse.getId())) {
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
import org.junit.Assert;
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
    }  
        } finally {  
    @Before
            () -> client().admin()
        try {  
                        }, countDownLatch);  
import org.opensearch.action.search.SearchResponse;  
                .get()
            testThreadPool = new TestThreadPool(PitMultiNodeIT.class.getName());
                assertEquals(1, getPitResponse.failures().size());
                            @Override
        );
    }
/**
        CreatePitResponse pitResponse = execute.get();
                CreatePitResponse pitResponse = execute.get();
                                if (getAllPitNodesResponse.failures().isEmpty()) {
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];  
                    .setAllowPartialSearchResults(false)  
 */
                            public void onFailure(Exception e) {}  
import java.util.List;  
                .cluster()
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
    public void testConcurrentCreates() throws InterruptedException {
                Runnable thread = () -> {  
