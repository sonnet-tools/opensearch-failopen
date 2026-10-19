            assertTrue(deletePitInfo.isSuccessful());  
        Thread[] threads = new Thread[5];
                    logger.info("Triggering pit delete --->");
        pitResponse = execute.get();
        List<String> pitIds = new ArrayList<>();
import org.opensearch.core.action.ActionListener;  
         */
                            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        request.setIndices(new String[] { "index" });  
    public void testDeleteAllPitsWhileNodeDrop() throws Exception {  
                    }
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.unit.TimeValue;
            threads[i] = new Thread(() -> {
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        }
        List<String> pitIds = new ArrayList<>();
    public void setupIndex() throws ExecutionException, InterruptedException {  
          When we invoke delete again, returns success after clearing the remaining readers. Asserting reader context  
        AtomicInteger numDeleteAcknowledged = new AtomicInteger();
                    DeletePitResponse deletePITResponse = execute.get();
        /*
import java.util.concurrent.atomic.AtomicInteger;
                } catch (Exception e) {  
        ensureGreen();
        validatePitStats("index", 5, 0);
                            .setSize(2)
         */  
        validatePitStats("index", 0, 10);
            assertThat(deletePitInfo.getPitId(), not(blankOrNullString()));  
        /*
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
    }  
        int concurrentRuns = randomIntBetween(20, 50);
        CreatePitResponse pitResponse = createPitOnIndex("index");  
        DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
        client().admin().indices().prepareDelete("index1").get();
        DeletePitResponse deletePITResponse = deleteExecute.get();  
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {  
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                      assert for exception once delete pit goes through. throw error in case of any exeption before that.
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
                    for (int j = 0; j < 30; j++) {
    public void validatePitStats(String index, long expectedPitCurrent, long expectedPitCount) throws ExecutionException,
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
import static org.hamcrest.Matchers.containsString;
                    client().execute(DeletePitAction.INSTANCE, deletePITRequest, listener);
                    latch.await();
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
                        Throwable t = ExceptionsHelper.unwrapCause(e.getCause());
                // this is fine, expected search error when context is already deleted  
import java.util.concurrent.TimeUnit;
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
import org.opensearch.action.search.ShardSearchFailure;
        CreatePitResponse pitResponse1 = createPitOnIndex("index1");  
import org.opensearch.action.LatchedActionListener;
        createPitOnIndex("index1");  
        }
                        }
        deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
          once the node restarts, all active contexts are cleared in the node )  
        DeletePitResponse deletePITResponse = execute.get();
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
    }
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);  
    }
        createPitOnIndex("index1");  
        pitIds.add(pitResponse.getId());  
        CreatePitResponse pitResponse = createPitOnIndex("index");
                        assertTrue(e.toString(), t instanceof SearchPhaseExecutionException);  
        CreatePitResponse pitResponse = execute.get();
            CountDownLatch countDownLatch = new CountDownLatch(concurrentRuns);
        CountDownLatch latch = new CountDownLatch(threads.length);  
import org.junit.After;
import org.opensearch.ExceptionsHelper;
    public void testDeleteWhileSearch() throws Exception {
        validatePitStats("index", 5, 0);
    public void testDeletePit() throws Exception {  
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
    }  
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
        pitIds.add(pitResponse.getId());  
        CreatePitResponse pitResponse = execute.get();
            for (int i = 0; i < concurrentRuns; i++) {
import static org.hamcrest.Matchers.blankOrNullString;
                    LatchedActionListener listener = new LatchedActionListener<>(new ActionListener<DeletePitResponse>() {
    }  
        ensureGreen();  
        });
    }  
/**
import org.opensearch.action.search.CreatePitAction;
                operationThreads.add(thread);  
import org.opensearch.action.search.CreatePitResponse;
            assertTrue(deletePitInfo.isSuccessful());  
 * this file be licensed under the Apache-2.0 license or a
        pitIds.add(pitResponse1.getId());
                ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);  
        client().admin().indices().prepareDelete("index1").get();
        List<String> pitIds = new ArrayList<>();
        client().admin().indices().prepareDelete("index1").get();  
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).get();
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        validatePitStats("index", 0, 5);
        pitIds.add(pitResponse.getId());
                    /*
        indicesStatsRequest.all();  
          Delete PIT with both Ids #1 (which is deleted) and #2 (which is present)
    }
        ensureGreen();
                }
        /*
        }
import org.opensearch.action.search.SearchResponse;
          Checking deleting the same PIT id again results in succeeded  
        createIndex("index", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
        execute = client().execute(CreatePitAction.INSTANCE, request);
import org.opensearch.common.action.ActionFuture;  
        deleted.set(true);
        TestThreadPool testThreadPool = null;  
    public void testDeletePitWithValidAndInvalidIds() throws Exception {
        InterruptedException {  
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));  
                    }, countDownLatch);  
            }
 */  
                            .get();
        }
        validatePitStats("index", 0, 10);
            threads[i].start();
                        assertTrue(pitIds.contains(deletePitInfo.getPitId()));
                };
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
        /*
            assertEquals(concurrentRuns, numDeleteAcknowledged.get());
        deletePITResponse = deleteExecute.get();  
        ensureGreen();
                try {
            public Settings onNodeStopped(String nodeName) throws Exception {
            if (failure.toString().contains("reader_context is already closed can't increment refCount current count")) {
import java.util.List;
import org.opensearch.action.search.CreatePitRequest;  
                assertTrue(failure.toString(), cause instanceof SearchContextMissingException);
                }
            assertTrue(deletePitInfo.isSuccessful());
import org.opensearch.action.search.SearchPhaseExecutionException;  
        request.setIndices(new String[] { "index" });
        ensureGreen();  
        }  
        client().admin().indices().prepareDelete("index").get();
        createPitOnIndex("index");
        CreatePitResponse pitResponse = execute.get();  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
        DeletePitResponse deletePITResponse = execute.get();
        pitIds.add(pitResponse.getId());
            }
                    }  
                            if (deletePitResponse.getDeletePitResults().get(0).isSuccessful()) {
                } catch (Exception e) {  
        List<String> pitIds = new ArrayList<>();
        validatePitStats("index1", 0, 5);
    @Before
            assertTrue(deletePitInfo.isSuccessful());
        assertEquals(expectedPitCount, pitCount);
import java.util.concurrent.ExecutionException;
          Delete Pit #1
    private void verifySearchContextMissingException(ShardSearchFailure[] failures) {
    }  
import org.opensearch.action.search.DeletePitAction;
        indicesStatsRequest.indices(index);
    }
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
    }  
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
            TestThreadPool finalTestThreadPool = testThreadPool;
        createIndex("index1", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
                    }
            Throwable cause = ExceptionsHelper.unwrapCause(failure.getCause());
        /*
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        createIndex("index1", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());  
    public void testDeletePitWithValidAndDeletedIds() throws Exception {
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {  
        assertEquals(expectedPitCurrent, pitCurrent);
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
    }
         */
                        SearchResponse searchResponse = client().prepareSearch()  
                        @Override  
package org.opensearch.search.pit;
          When we invoke delete again, returns success as all readers are cleared. (Delete all on node which is Up and
                return super.onNodeStopped(nodeName);  
        validatePitStats("index", 0, 5);  
        long pitCount = indicesStatsResponse.getIndex(index).getTotal().search.getTotal().getPitCount();  
            });  
        pitIds.add(pitResponse.getId());  
        execute = client().execute(CreatePitAction.INSTANCE, request);  
          When we invoke delete again, returns success after clearing the remaining readers. Asserting reader context  
                    throw new AssertionError(e);
                Runnable thread = () -> {  
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
import java.util.concurrent.CountDownLatch;  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
    public void testtConcurrentDeletes() throws InterruptedException, ExecutionException {
import java.util.concurrent.atomic.AtomicBoolean;  
                        }
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                            verifySearchContextMissingException(searchResponse.getShardFailures());  
            @Override
                        if (searchResponse.getFailedShards() != 0) {
                        assertThat(deletePitInfo.getPitId(), not(blankOrNullString()));
        validatePitStats("index1", 5, 0);
public class DeletePitMultiNodeIT extends OpenSearchIntegTestCase {  
                    DeletePitResponse deletePITResponse = execute.get();
 */
         */  
            countDownLatch.await();
import static org.hamcrest.Matchers.not;  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            public Settings onNodeStopped(String nodeName) throws Exception {
        deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
                        @Override
import org.opensearch.search.SearchContextMissingException;
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
                        return;
        assertEquals(0, deletePITResponse.getDeletePitResults().size());
        DeletePitResponse deletePITResponse = execute.get();  
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {  
        pitResponse = execute.get();
        List<String> pitIds = new ArrayList<>();
        deletePITResponse = deleteExecute.get();  
import org.opensearch.threadpool.ThreadPool;  
    private CreatePitResponse createPitOnIndex(String index) throws ExecutionException, InterruptedException {
        final AtomicBoolean deleted = new AtomicBoolean(false);
        DeletePitRequest deletePITRequest = new DeletePitRequest("_all");  
         */
    public void clearIndex() {
        }
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                    for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {  
import org.opensearch.action.search.DeletePitInfo;  
/*  
            assertTrue(deletePitInfo.isSuccessful());  
    }  
 * Multi node integration tests for delete PIT use cases  
        validatePitStats("index", 10, 0);
import org.opensearch.action.search.DeletePitResponse;
        ensureGreen();
                return super.onNodeStopped(nodeName);  
        for (Thread thread : threads) {  
        CreatePitResponse pitResponse = createPitOnIndex("index");  
                    throw new AssertionError(e);
import org.opensearch.common.settings.Settings;
    }
            assertTrue(deletePitInfo.isSuccessful());
        }
        assertEquals(2, deletePITResponse.getDeletePitResults().size());
import java.util.ArrayList;
import org.opensearch.threadpool.TestThreadPool;
                ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);  
            operationThreads.forEach(runnable -> finalTestThreadPool.executor("generic").execute(runnable));  
import org.junit.Before;
                } catch (Exception e) {  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;  
          not found exceptions don't result in failures ( as deletion in one node is successful )
         */
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
                latch.countDown();
            threads[i].setName("opensearch[node_s_0][search]");
        pitIds.add(pitResponse.getId());  
        request.setIndices(new String[] { "index" });
 *
        DeletePitResponse deletePITResponse = deleteExecute.get();
                try {
            assertTrue(pitIds.contains(deletePitInfo.getPitId()));
        }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)
        } finally {  
        try {
                    }
        client().prepareIndex("index1").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
        request.setIndices(new String[] { index });
        ActionFuture<DeletePitResponse> deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);  
            assertTrue(deletePitInfo.isSuccessful());  
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
        assertThat(e.getMessage(), containsString("invalid id"));
        validatePitStats("index", 5, 5);  
            testThreadPool = new TestThreadPool(DeletePitMultiNodeIT.class.getName());
}
        });
    public void testDeleteAllPits() throws Exception {
                     */  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
import org.opensearch.search.builder.PointInTimeBuilder;
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        ensureGreen();  
                }
                        public void onResponse(DeletePitResponse deletePitResponse) {
        return execute.get();  
        deletePITRequest = new DeletePitRequest(pitIds);
import org.opensearch.action.search.DeletePitRequest;
        Exception e = assertThrows(ExecutionException.class, () -> deleteExecute.get());  
        ensureGreen();  
        }
            @Override
        /*
                    if (deleted.get() == true) {
        }
 * SPDX-License-Identifier: Apache-2.0
            } else {
        for (int i = 0; i < threads.length; i++) {  
import org.opensearch.test.InternalTestCluster;  
            List<Runnable> operationThreads = new ArrayList<>();  
                            .execute()  
                        public void onFailure(Exception e) {}
        pitIds.add(pitResponse.getId());
                        verifySearchContextMissingException(((SearchPhaseExecutionException) t).shardFailures());
 * compatible open source license.
        }
            }  
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitIds);
                try {  
                            }
        for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);  
        pitIds.add(pitResponse.getId());
          not found exceptions don't result in failures ( as deletion in one node is successful )
            thread.join();
        ActionFuture<DeletePitResponse> execute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);  
                                numDeleteAcknowledged.incrementAndGet();  
        DeletePitResponse deletePITResponse = execute.get();  
        long pitCurrent = indicesStatsResponse.getIndex(index).getTotal().search.getTotal().getPitCurrent();
    @After  
        ActionFuture<DeletePitResponse> deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
 * The OpenSearch Contributors require contributions made to  
    public void testDeletePitWhileNodeDrop() throws Exception {
                    for (DeletePitInfo deletePitInfo : deletePITResponse.getDeletePitResults()) {  
        List<String> pitIds = new ArrayList<>();  
        ActionFuture<DeletePitResponse> deleteExecute = client().execute(DeletePitAction.INSTANCE, deletePITRequest);
        createIndex("index1", Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 1).build());
        pitIds.add("nondecodableid");  
            }
                    assertTrue(e.getMessage().contains("Node not connected"));
        for (ShardSearchFailure failure : failures) {  
