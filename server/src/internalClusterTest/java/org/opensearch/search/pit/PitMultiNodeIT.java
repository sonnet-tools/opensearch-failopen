    @Before
            List<Runnable> operationThreads = new ArrayList<>();
                .setPersistentSettings(Settings.builder().put("point_in_time.max_keep_alive", "2m"))
            assertEquals(concurrentRuns, numSuccess.get());
        PitTestsUtil.assertUsingGetAllPits(client(), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
public class PitMultiNodeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                // If the search must make a transport call to start the search then a
        assertAcked(
                                numSuccess.incrementAndGet();
        GetAllPitNodesResponse getPitResponse = execute1.get();
import org.opensearch.action.search.CreatePitAction;
                .prepareUpdateSettings()
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            @Override
import org.opensearch.action.search.GetAllPitsAction;
                                if (deletePitResponse.getDeletePitResults().get(0).isSuccessful()) {
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    private DiscoveryNode[] getDiscoveryNodes() throws ExecutionException, InterruptedException {
        createIndex("index", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
                                }
    }
    }
import org.opensearch.action.search.GetAllPitNodesRequest;
        String id = client().execute(CreatePitAction.INSTANCE, createPitRequest).get().getId();
import org.opensearch.action.search.DeletePitAction;
        SearchResponse searchResponse = client().prepareSearch("index")
        long pitCurrent = indicesStatsResponse.getIndex(index).getTotal().search.getTotal().getPitCurrent();
            client().admin()
                );
            for (int i = 0; i < concurrentRuns; i++) {
                    if (currentThreadIteration == randomDeleteThread) {
                int currentThreadIteration = i;
            }
    public void testPitInvalidDefaultKeepAlive() {
                assertEquals(1, searchResponse.getSuccessfulShards());
 * The OpenSearch Contributors require contributions made to
                    TimeValue.timeValueDays(1)
                operationThreads.add(thread);
import java.util.concurrent.ExecutionException;
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");
            IllegalArgumentException.class,
    }
                    .execute();
    }
                ActionFuture<SearchResponse> execute = client().prepareSearch()
            assertEquals(concurrentRuns, numSuccess.get());
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                .cluster()
package org.opensearch.search.pit;
            @Override
            int concurrentRuns = randomIntBetween(20, 50);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import org.opensearch.action.search.DeletePitRequest;
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).get();
import org.opensearch.action.search.CreatePitResponse;
                .setPersistentSettings(Settings.builder().putNull("*"))
                return super.onNodeStopped(nodeName);
                int currentThreadIteration = i;
                };
                            }
        });
        request.setIndices(new String[] { "index" });
            long randomDeleteThread = randomLongBetween(0, concurrentRuns - 1);
        List<String> resultPitIds = getPitResponse.getPitInfos().stream().map(p -> p.getPitId()).collect(Collectors.toList());
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                assertEquals(2, pitResponse.getTotalShards());
                assertEquals(1, searchResponse.getTotalShards());
                };
                        client().execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest, listener);
        assertSegments(false, client(), pitResponse.getId());
    }
    }
import org.opensearch.core.action.ActionListener;
    public void setupIndex() throws ExecutionException, InterruptedException {
                .get()
        CreatePitResponse pitResponse = execute.get();
        assertEquals(expectedPitCurrent, pitCurrent);
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");
                    client(),
    public void testConcurrentCreates() throws InterruptedException {
        request.setIndices(new String[] { "index" });
                            public void onResponse(DeletePitResponse deletePitResponse) {
                            @Override
        client().admin().indices().prepareCreate("index1").get();
            () -> client().admin()
                            @Override
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
            int concurrentRuns = randomIntBetween(20, 50);
    }
                .prepareUpdateSettings()
        TestThreadPool testThreadPool = null;
            Set<String> createSet = new HashSet<>();
                        @Override
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                .cluster()
                .prepareUpdateSettings()
        InterruptedException {
import org.opensearch.common.action.ActionFuture;
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                        client().execute(CreatePitAction.INSTANCE, createPitRequest, listener);
                return super.onNodeStopped(nodeName);
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
        // asserting that we get all unique PIT IDs
import java.util.LinkedList;
import org.opensearch.common.settings.Settings;
                ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
                    client(),
        client().admin().indices().prepareDelete("index1").get();
        assertEquals(3, getPitResponse.getPitInfos().size());
        pitIds.add(id);
                        public void onResponse(CreatePitResponse createPitResponse) {
                    client().execute(CreatePitAction.INSTANCE, createPitRequest, listener);
        Assert.assertTrue(resultPitIds.contains(pitResponse.getId()));
                Runnable thread = () -> {
                            }
                .cluster()
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<DeletePitResponse>() {
                ExecutionException ex = expectThrows(ExecutionException.class, execute::get);
                // observe non-zero PIT stats, so we poll here and wait for stats to eventually
                    .get();
import static org.opensearch.action.search.PitTestsUtil.assertSegments;
        );
            }
                assertEquals(1, pitResponse.getSuccessfulShards());
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(getDiscoveryNodes());
        nodes.toArray(disNodesArr);
        List<String> pitIds = new ArrayList<>();
        CreatePitResponse pitResponse = execute.get();
import java.util.concurrent.TimeUnit;
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
        ActionFuture<GetAllPitNodesResponse> execute1 = client().execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);
                .cluster()
                validatePitStats("index", 1, 1);
                        public void onFailure(Exception e) {}
 */
            TestThreadPool finalTestThreadPool = testThreadPool;
        Assert.assertTrue(resultPitIds.contains(pitResponse1.getId()));
                    if (currentThreadIteration == randomDeleteThread) {
            client().admin()
                    }, countDownLatch);
import org.opensearch.action.search.DeletePitResponse;
 * compatible open source license.
                            }
                assertEquals(2, searchResponse.getTotalShards());
        );
    public void testPit() throws Exception {
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
                        client().execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
            for (int i = 0; i < concurrentRuns; i++) {
                            public void onFailure(Exception e) {}
                assertTrue(ex.getMessage().contains("Failed to execute phase [create_pit]"));
        AtomicInteger numSuccess = new AtomicInteger();
        request.setIndices(new String[] { "index" });
            }
        );
                    LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
        assertThat(exc.getMessage(), containsString("was (2m > 1m)"));
        flush(); // clear the translog to ensure accurate stats
                    pitResponse.getCreationTime(),
        validatePitStats("index", 2, 2);
        request.setIndices(new String[] { "index" });
                .prepareUpdateSettings()
                        }, countDownLatch);
                        client().execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
                .get()
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
                                }
                // we still get a pit id from the data node which is up
}
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        assertEquals(2, searchResponse.getTotalShards());
        pitIds.add(id);
        }
            public Settings onNodeStopped(String nodeName) throws Exception {
            assertEquals(concurrentRuns, numSuccess.get());
        }
                .setPersistentSettings(Settings.builder().put("point_in_time.max_keep_alive", "30s"))
import java.util.List;
import java.util.concurrent.CountDownLatch;
            testThreadPool = new TestThreadPool(PitMultiNodeIT.class.getName());
        CreatePitResponse pitResponse1 = client().execute(CreatePitAction.INSTANCE, request).get();
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        request.setIndices(new String[] { "index", "index1" });
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
import java.util.concurrent.atomic.AtomicInteger;
                .prepareUpdateSettings()
                .prepareUpdateSettings()
                Runnable thread = () -> {
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
        createPitRequest.setIndices(new String[] { "index" });
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "5m").put("point_in_time.max_keep_alive", "5m"))
/*
                .setPersistentSettings(Settings.builder().put("point_in_time.max_keep_alive", "1m").put("search.default_keep_alive", "2m"))
                                    numSuccess.incrementAndGet();
        );
    }
                            public void onFailure(Exception e) {}
        nodes.toArray(disNodesArr);
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
import java.util.Set;
            client().admin()
 */
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<DeletePitResponse>() {
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                ActionFuture<GetAllPitNodesResponse> execute1 = client().execute(GetAllPitsAction.INSTANCE, getAllPITNodesRequest);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        CreatePitResponse pitResponse2 = client().execute(CreatePitAction.INSTANCE, request).get();
            public Settings onNodeStopped(String nodeName) throws Exception {
    }
        int concurrentRuns = randomIntBetween(20, 50);
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
                    } else {
            @Override
        indexRandomForConcurrentSearch("index");
        try {
        } finally {
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(getDiscoveryNodes());
import org.opensearch.action.LatchedActionListener;
        CreatePitResponse pitResponse = execute.get();
                SearchResponse searchResponse = client().prepareSearch("index")
        String id = client().execute(CreatePitAction.INSTANCE, createPitRequest).get().getId();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
            () -> client().admin()
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
        AtomicInteger numSuccess = new AtomicInteger();
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), false);
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.search.builder.PointInTimeBuilder;
    }
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        clusterStateRequest.local(false);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            public Settings onNodeStopped(String nodeName) throws Exception {
    public static Collection<Object[]> parameters() {
    public void testCreatePitWhileNodeDropWithAllowPartialCreationTrue() throws Exception {
        });
                ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                            public void onFailure(Exception e) {}
                                    numSuccess.incrementAndGet();
        );
                .get()
import org.junit.Assert;
                            @Override
                assertBusy(() -> validatePitStats("index", 0, 0));
            }
import org.opensearch.action.search.SearchResponse;
                    TimeValue.timeValueDays(1)
        CreatePitResponse pitResponse = execute.get();
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
            testThreadPool = new TestThreadPool(PitMultiNodeIT.class.getName());
                            public void onResponse(DeletePitResponse deletePitResponse) {
                return super.onNodeStopped(nodeName);
        });
                            @Override
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
                                if (deletePitResponse.getDeletePitResults().get(0).isSuccessful()) {
        clusterStateRequest.local(false);
            client().admin()
                            public void onResponse(CreatePitResponse createPitResponse) {
        assertEquals(expectedOpenContexts, openContexts);
                validatePitStats("index", 1, 1);
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        exc = expectThrows(
import org.opensearch.common.unit.TimeValue;
                .cluster()
            @Override
            }
        Set<String> createSet = new HashSet<>();
                assertEquals(1, searchResponse.getFailedShards());
            .get();
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                .prepareUpdateSettings()
                .get()
import static org.hamcrest.Matchers.containsString;
        indicesStatsRequest.all();
        super(settings);
        final List<DiscoveryNode> nodes = new LinkedList<>(clusterStateResponse.getState().nodes().getDataNodes().values());
                    .get();
import org.junit.After;
                            public void onResponse(GetAllPitNodesResponse getAllPitNodesResponse) {
                PitTestsUtil.assertUsingGetAllPits(
                ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        try {
 *
                .cluster()
import java.util.stream.Collectors;
                // will end up racing with the PIT decrement call and can very briefly
                // resolve to zero. In almost all cases the first call will observe zero stats.
            countDownLatch.await();
        GetAllPitNodesRequest getAllPITNodesRequest = new GetAllPitNodesRequest(disNodesArr);
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        Assert.assertTrue(resultPitIds.contains(pitResponse2.getId()));
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
    public void testGetAllPitsDuringNodeDrop() throws Exception {
        TestThreadPool testThreadPool = null;
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "1m"))
                return super.onNodeStopped(nodeName);
                    .setSize(2)
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];
        // Test stats
        IllegalArgumentException exc = expectThrows(
                    }
                            @Override
            nodes.add(node);
                                if (getAllPitNodesResponse.failures().isEmpty()) {
                assertEquals(1, searchResponse.getSuccessfulShards());
        });
        final List<DiscoveryNode> nodes = new LinkedList<>();
        assertThat(exc.getMessage(), containsString("was (1m > 30s)"));
                );
import org.junit.Before;
        CreatePitResponse pitResponse = execute.get();
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
        } finally {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<GetAllPitNodesResponse>() {
        );
    }
                CreatePitResponse pitResponse = execute.get();
        TestThreadPool testThreadPool = null;
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
            }
                assertTrue(ex.getMessage().contains("Partial shards failure"));
            () -> client().admin()
        createPitRequest.setIndices(new String[] { "index" });
    }
            IllegalArgumentException.class,
            IllegalArgumentException.class,
            }
                assertTrue(getPitResponse.failures().get(0).getMessage().contains("Failed node"));
                                if (createSet.add(createPitResponse.getId())) {
        request.setIndices(new String[] { "index" });
                    pitResponse.getId(),
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
    }
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
    }
    public void validatePitStats(String index, long expectedPitCurrent, long expectedOpenContexts) throws ExecutionException,
import org.opensearch.threadpool.ThreadPool;
                assertEquals(1, getPitResponse.getPitInfos().size());
        exc = expectThrows(
            for (int i = 0; i < concurrentRuns; i++) {
    }
                .cluster()
                assertSegments(false, "index", 1, client(), pitResponse.getId());
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                    .setSize(2)
 * this file be licensed under the Apache-2.0 license or a
                    pitResponse.getCreationTime(),
        assertAcked(
        AtomicInteger numSuccess = new AtomicInteger();
    }
        } finally {
        long openContexts = indicesStatsResponse.getIndex(index).getTotal().search.getOpenContexts();
            public Settings onNodeStopped(String nodeName) throws Exception {
        }
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
 * Multi node integration tests for PIT creation and search operation with PIT ID.
                            public void onFailure(Exception e) {}
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "2m"))
import java.util.HashSet;
        assertAcked(
import org.opensearch.test.InternalTestCluster;
    public PitMultiNodeIT(Settings settings) {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import java.util.ArrayList;
                .cluster()
            TestThreadPool finalTestThreadPool = testThreadPool;
        ClusterStateResponse clusterStateResponse = client().admin().cluster().state(clusterStateRequest).get();
                    } else {
    public void clearIndex() {
                    logger.info("Triggering pit create --->");
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "3m"))
                PitTestsUtil.assertUsingGetAllPits(
                };
    public void testPitSearchWithNodeDrop() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
        ClusterStateResponse clusterStateResponse = client().admin().cluster().state(clusterStateRequest).get();
            countDownLatch.await();
                return super.onNodeStopped(nodeName);
        flush(); // clear the translog to ensure accurate stats
        try {
import org.opensearch.action.search.PitTestsUtil;
            public Settings onNodeStopped(String nodeName) throws Exception {
    public void testCreatePitWhileNodeDropWithAllowPartialCreationFalse() throws Exception {
                .setTransientSettings(Settings.builder().putNull("*"))
                GetAllPitNodesResponse getPitResponse = execute1.get();
import org.opensearch.action.search.GetAllPitNodesResponse;
import java.util.Arrays;
    public void testGetAllPits() throws Exception {
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                            }
            @Override
                .get()
        indicesStatsRequest.indices(index);
                                }
                SearchResponse searchResponse = client().prepareSearch()
        assertEquals(2, searchResponse.getSuccessfulShards());
            }
        List<String> pitIds = new ArrayList<>();
                        LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
        client().admin().indices().prepareDelete("index").get();
        });
    public void testConcurrentCreatesWithDeletes() throws InterruptedException, ExecutionException {
                        }, countDownLatch);
import org.opensearch.action.search.CreatePitRequest;
            .setSize(2)
                            @Override
        return Arrays.asList(
                            @Override
                    .setAllowPartialSearchResults(false)
                            }
                            @Override
            countDownLatch.await();
            client().admin()
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
            List<Runnable> operationThreads = new ArrayList<>();
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                        }, countDownLatch);
            testThreadPool = new TestThreadPool(PitMultiNodeIT.class.getName());
        assertThat(exc.getMessage(), containsString("was (3m > 2m)"));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        ensureGreen();
                assertEquals(1, getPitResponse.failures().size());
                .get()
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);
            List<Runnable> operationThreads = new ArrayList<>();
                assertEquals(0, searchResponse.getSkippedShards());
    public void testConcurrentGetWithDeletes() throws InterruptedException, ExecutionException {
    @ParametersFactory
        );
                // failure for node drop
                        }, countDownLatch);
        );
        }
                // PIT context may be temporarily created on a separate thread. The test
        assertAcked(
    @After
        );
/**
                                    numSuccess.incrementAndGet();
import java.util.Collection;
        assertAcked(
                        }
                .get()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        for (final DiscoveryNode node : clusterStateResponse.getState().nodes().getDataNodes().values()) {
                operationThreads.add(thread);
    }
                operationThreads.add(thread);
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
            long randomDeleteThread = randomLongBetween(0, concurrentRuns - 1);
    public void testPitSearchWithNodeDropWithPartialSearchResultsFalse() throws Exception {
                                }
                    }
import org.opensearch.threadpool.TestThreadPool;
                    pitResponse.getId(),
            TestThreadPool finalTestThreadPool = testThreadPool;
                Runnable thread = () -> {
                            if (createSet.add(createPitResponse.getId())) {
                    .setSize(2)
        return disNodesArr;
        createPitRequest.setIndices(new String[] { "index" });
                                    numSuccess.incrementAndGet();
        request.setIndices(new String[] { "index" });
                .prepareUpdateSettings()
                        @Override
