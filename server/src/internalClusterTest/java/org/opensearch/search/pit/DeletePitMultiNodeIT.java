        request.setIndices(new String[] { "index" });
        }
        validatePitStats("index", 0, 10);
        long pitCurrent = indicesStatsResponse.getIndex(index).getTotal().search.getTotal().getPitCurrent();
        List<String> pitIds = new ArrayList<>();
            if (failure.toString().contains("reader_context is already closed can't increment refCount current count")) {
        DeletePitResponse deletePITResponse = execute.get();
        CreatePitResponse pitResponse1 = createPitOnIndex("index1");
        createPitOnIndex("index1");
                        assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        /*
            }
                    logger.info("Triggering pit delete --->");
    }
        pitIds.add(pitResponse.getId());
            public Settings onNodeStopped(String nodeName) throws Exception {
 */
        validatePitStats("index", 5, 0);
                latch.countDown();
    public void testDeletePitWithValidAndDeletedIds() throws Exception {
                        @Override
                        SearchResponse searchResponse = client().prepareSearch()
import org.opensearch.threadpool.TestThreadPool;
        DeletePitResponse deletePITResponse = execute.get();
            threads[i].start();
import java.util.concurrent.TimeUnit;
            } else {
                } catch (Exception e) {
import org.junit.Before;
        pitIds.add(pitResponse.getId());
import java.util.ArrayList;
          not found exceptions don't result in failures ( as deletion in one node is successful )
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
         */
                        assertThat(deletePitInfo.getPitId(), not(blankOrNullString()));
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
    }
                    LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<DeletePitResponse>() {
public class DeletePitMultiNodeIT extends OpenSearchIntegTestCase {
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        long pitCount = indicesStatsResponse.getIndex(index).getTotal().search.getTotal().getPitCount();
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        Exception e = assertThrows(ExecutionException.class, () -> deleteExecute.get());
            thread.join();
    public void testtConcurrentDeletes() throws InterruptedException, ExecutionException {
    public void testDeleteWhileSearch() throws Exception {
        /*
                    for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
    }
        deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
                return super.onNodeStopped(nodeName);
import org.opensearch.action.search.CreatePitRequest;
        deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
import org.opensearch.common.settings.Settings;
                try {
        DeletePitResponse deletePITResponse = deleteExecute.get();
import static org.hamcrest.Matchers.blankOrNullString;
        pitResponse = execute.get();
            countDownLatch.await();
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                    }
        execute = client().execute(CreatePitAction.INSTANCE, request);
                    throw new AssertionError(e);
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        validatePitStats("index", 5, 0);
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
            assertThat(deletePitInfo.getPitId(), not(blankOrNullString()));
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
    public void clearIndex() {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        List<String> pitIds = new ArrayList<>();
        createPitOnIndex("index1");
        }
        InterruptedException {
        pitIds.add(pitResponse.getId());
        DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                return super.onNodeStopped(nodeName);
 * SPDX-License-Identifier: Apache-2.0
          When we invoke delete again, returns success after clearing the remaining readers. Asserting reader context
        execute = client().execute(CreatePitAction.INSTANCE, request);
import org.opensearch.action.search.DeletePitResponse;
        client().admin().indices().prepareDelete("index1").get();
                }
            assertTrue(deletePitInfo.isSuccessful());
        ensureGreen();
}
            @Override
                };
        validatePitStats("index1", 5, 0);
          Checking deleting the same PIT id again results in succeeded
        client().admin().indices().prepareDelete("index1").get();
                }
    }
        CreatePitResponse pitResponse = createPitOnIndex("index");
        for (int i = 0; i < threads.length; i++) {
                }
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
            }
                    assertTrue(e.getMessage().contains("Node not connected"));
        pitIds.add(pitResponse1.getId());
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        validatePitStats("index1", 0, 5);
        ensureGreen();
                    /*
                        return;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
import java.util.concurrent.atomic.AtomicBoolean;
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
 *
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.search.SearchContextMissingException;
        try {
        for (ShardSearchFailure failure : failures) {
                        verifySearchContextMissingException(((SearchPhaseExecutionException) t).shardFailures());
import org.opensearch.ExceptionsHelper;
import org.opensearch.common.action.ActionFuture;
        ensureGreen();
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        /*
        deletePITResponse = deleteExecute.get();
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
          not found exceptions don't result in failures ( as deletion in one node is successful )
        List<String> pitIds = new ArrayList<>();
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        ensureGreen();
/**
    public void testDeletePitWhileNodeDrop() throws Exception {
                    throw new AssertionError(e);
        CreatePitResponse pitResponse = execute.get();
            assertTrue(deletePitInfo.isSuccessful());
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
        deletePITRequest = new DeletePitRequest(pitIds);
        pitIds.add(pitResponse.getId());
    @Before
        List<String> pitIds = new ArrayList<>();
    public void testDeletePit() throws Exception {
    public void testDeletePitWithValidAndInvalidIds() throws Exception {
        pitIds.add(pitResponse.getId());
        CreatePitResponse pitResponse = execute.get();
        DeletePitResponse deletePITResponse = execute.get();
                            .setSize(2)
        pitIds.add(pitResponse.getId());
    }
        deleted.set(true);
package org.opensearch.search.pit;
          When we invoke delete again, returns success as all readers are cleared. (Delete all on node which is Up and
import org.opensearch.action.search.SearchResponse;
        DeletePitResponse deletePITResponse = deleteExecute.get();
                            }
                    }
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
 * this file be licensed under the Apache-2.0 license or a
                ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        ensureGreen();
import org.opensearch.common.unit.TimeValue;
        ActionFuture<DeletePitResponse> deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        assertThat(e.getMessage(), containsString("invalid id"));
    }
                    }, countDownLatch);
    private void verifySearchContextMissingException(ShardSearchFailure[] failures) {
    }
                        public void onFailure(Exception e) {}
            assertTrue(deletePitInfo.isSuccessful());
        createIndex("index", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
    public void setupIndex() throws ExecutionException, InterruptedException {
        }
        request.setIndices(new String[] { "index" });
    }
            Throwable cause = ExceptionsHelper.unwrapCause(failure.getCause());
                } catch (Exception e) {
        Thread[] threads = new Thread[5];
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        ActionFuture<DeletePitResponse> deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
 * compatible open source license.
          When we invoke delete again, returns success after clearing the remaining readers. Asserting reader context
            assertTrue(deletePitInfo.isSuccessful());
        assertEquals(2, deletePITResponse.getDeletePitResults().size());
        int concurrentRuns = randomIntBetween(20, 50);
        });
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        AtomicInteger numDeleteAcknowledged = new AtomicInteger();
    }
                        }
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
import org.opensearch.action.search.DeletePitInfo;
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
        createPitOnIndex("index");
        }
         */
            threads[i].setName("opensearch[node_s_0][search]");
                    }
                            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
    }
        deletePITResponse = deleteExecute.get();
        assertEquals(expectedPitCount, pitCount);
                        assertTrue(e.toString(), t instanceof SearchPhaseExecutionException);
    @After
            TestThreadPool finalTestThreadPool = testThreadPool;
                operationThreads.add(thread);
        DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
        return execute.get();
                    client().execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
                // this is fine, expected search error when context is already deleted
                    if (deleted.get() == true) {
        CreatePitResponse pitResponse = createPitOnIndex("index");
        request.setIndices(new String[] { "index" });
    private CreatePitResponse createPitOnIndex(String index) throws ExecutionException, InterruptedException {
            assertTrue(deletePitInfo.isSuccessful());
import org.opensearch.action.search.DeletePitAction;
            assertEquals(concurrentRuns, numDeleteAcknowledged.get());
                assertTrue(failure.toString(), cause instanceof SearchContextMissingException);
import java.util.concurrent.CountDownLatch;
        validatePitStats("index", 5, 5);
        }
        }
        validatePitStats("index", 0, 5);
        }
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
                        @Override
            List<Runnable> operationThreads = new ArrayList<>();
        createIndex("index1", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
                      assert for exception once delete pit goes through. throw error in case of any exeption before that.
        ActionFuture<DeletePitResponse> deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
                        Throwable t = ExceptionsHelper.unwrapCause(e.getCause());
                    for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        });
                try {
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        request.setIndices(new String[] { index });
                    DeletePitResponse deletePITResponse = execute.get();
        indicesStatsRequest.indices(index);
                    for (int j = 0; j < 30; j++) {
                            .get();
            assertTrue(deletePitInfo.isSuccessful());
                        public void onResponse(DeletePitResponse deletePitResponse) {
                try {
import org.opensearch.action.search.CreatePitResponse;
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
            }
        pitIds.add("nondecodableid");
                    latch.await();
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
        DeletePitResponse deletePITResponse = execute.get();
import org.opensearch.search.builder.PointInTimeBuilder;
            }
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
         */
         */
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
    }
        CreatePitResponse pitResponse = execute.get();
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        CountDownLatch latch = new CountDownLatch(threads.length);
                            verifySearchContextMissingException(searchResponse.getShardFailures());
import org.opensearch.test.OpenSearchIntegTestCase;
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import org.opensearch.action.search.SearchPhaseExecutionException;
        }
          Delete PIT with both Ids #1 (which is deleted) and #2 (which is present)
          once the node restarts, all active contexts are cleared in the node )
                     */
                        if (searchResponse.getFailedShards() != 0) {
            testThreadPool = new TestThreadPool(DeletePitMultiNodeIT.class.getName());
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
        List<String> pitIds = new ArrayList<>();
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
        validatePitStats("index", 10, 0);
        pitIds.add(pitResponse.getId());
            assertTrue(deletePitInfo.isSuccessful());
            });
        ensureGreen();
        pitIds.add(pitResponse.getId());
            for (int i = 0; i < concurrentRuns; i++) {
        assertEquals(0, deletePITResponse.getDeletePitResults().size());
            @Override
          Delete Pit #1
    public void validatePitStats(String index, long expectedPitCurrent, long expectedPitCount) throws ExecutionException,
import java.util.concurrent.ExecutionException;
        ensureGreen();
            threads[i] = new Thread(() -> {
                    DeletePitResponse deletePITResponse = execute.get();
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
         */
 * Multi node integration tests for delete PIT use cases
import org.opensearch.action.search.CreatePitAction;
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
    public void testDeleteAllPitsWhileNodeDrop() throws Exception {
import org.junit.After;
        final AtomicBoolean deleted = new AtomicBoolean(false);
        CreatePitResponse pitResponse = createPitOnIndex("index");
        indicesStatsRequest.all();
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        /*
/*
                ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        TestThreadPool testThreadPool = null;
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(expectedPitCurrent, pitCurrent);
                                numDeleteAcknowledged.incrementAndGet();
        ensureGreen();
        }
                        }
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).get();
    }
 * The OpenSearch Contributors require contributions made to
    public void testDeleteAllPits() throws Exception {
        }
         */
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        createIndex("index1", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
        createIndex("index1", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
                Runnable thread = () -> {
        }
                    }
        List<String> pitIds = new ArrayList<>();
                            if (deletePitResponse.getDeletePitResults().get(0).isSuccessful()) {
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
        client().admin().indices().prepareDelete("index").get();
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));
    }
        } finally {
import org.opensearch.action.search.ShardSearchFailure;
        /*
import org.opensearch.action.LatchedActionListener;
import static org.hamcrest.Matchers.not;
        validatePitStats("index", 0, 5);
        for (Thread thread : threads) {
import org.opensearch.core.action.ActionListener;
        /*
        client().admin().indices().prepareDelete("index1").get();
                            .execute()
        validatePitStats("index", 0, 10);
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
            public Settings onNodeStopped(String nodeName) throws Exception {
import org.opensearch.test.InternalTestCluster;
 */
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
        pitResponse = execute.get();
import org.opensearch.action.search.DeletePitRequest;
                } catch (Exception e) {
