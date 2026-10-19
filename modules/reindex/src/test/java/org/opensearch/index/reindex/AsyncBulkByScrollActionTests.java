        ScrollableHitSource.Response response
        if (listener.isDone()) {
    public void testCancelBeforeStartNextScroll() throws Exception {  
                            randomIntBetween(0, Integer.MAX_VALUE),
        testMe.accept(action);
        client.searchesToReject = testRequest.getMaxRetries() + randomIntBetween(1, 100);
        expectedHeaders.put(randomSimpleString(random()), randomSimpleString(random()));  
                if (rarely()) {
            }  
     * random scroll id so it is checked instead.
        /*  
    }
    }
        assertThat(response.getBulkFailures(), contains(failure));
                listener.onFailure(
        }  
        assertEquals(client.scrollsToReject, testTask.getStatus().getSearchRetries());
                    ShardId shardId = new ShardId(new Index(item.index(), "uuid"), 0);
        private int searchesToReject = 0;
import java.util.Collections;
    }
        );
            for (int i = 0; i < wraps; i++) {  
        );
                        createdResponse = false;
    }
        long total = randomIntBetween(0, Integer.MAX_VALUE);
        private final List<String> scrollsCleared = new ArrayList<>();
        BulkByScrollResponse response = listener.get();
            assertEquals(updated, testTask.getStatus().getUpdated());  
                r -> fail(),
        assertThat(response.getBulkFailures(), empty());
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.action.ActionResponse;  
    }  
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
                        continue;
    /**
            super(actionName, actionFilters, taskManager);
        setupClient(new TestThreadPool(getTestName()) {
import org.opensearch.test.client.NoOpClient;
            r -> fail(),  
                final OpenSearchRejectedExecutionException exception = new OpenSearchRejectedExecutionException("test");  
                boolean createdResponse;
            scrollId(),  
        hit.setSource(new BytesArray("{}"), MediaTypeRegistry.JSON);  
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
    }
            client.lastScroll.get().listener.onResponse(searchResponse);  
        assertEquals(defaultBackoffBeforeFailing, millis);  
        int lastBatchSize,
        // use fail() onResponse handler because mocked search never fires on listener.  
                    DocWriteRequest<?> item = bulk.requests().get(i);
                        cancelled = true;
        consumer.accept(() -> assertTrue(called.compareAndSet(false, true)));
import org.opensearch.core.tasks.TaskId;  
    private TaskId taskId;  
                        new Failure(shardId.getIndexName(), "id" + i, new VersionConflictEngineException(shardId, "id", "test"))
            Exception e = new OpenSearchRejectedExecutionException();
            Hit hit = new ScrollableHitSource.BasicHit("index", "id", 0);
        assertThat(response.getSearchFailures(), contains(shardFailure));  
        for (int batches = 0; batches < maxBatches; batches++) {
        firstSearchRequest.scroll(timeValueSeconds(10));
                        opType = randomFrom(DocWriteRequest.OpType.INDEX, DocWriteRequest.OpType.UPDATE);  
            }
import static java.util.Collections.emptyList;
        SearchHits hits = new SearchHits(
                        e = new OpenSearchException(e);  
        BulkRequest request = new BulkRequest();  
        private final Set<SearchScrollRequest> usedScolls = synchronizedSet(newSetFromMap(new IdentityHashMap<>()));
    private static class DummyTransportAsyncBulkByScrollAction extends TransportAction<  
            return buildTestBackoffPolicy();  
    }
            super.doExecute(action, request, listener);  
        });
        @Override
            if (request instanceof ClearScrollRequest) {
            if (request instanceof BulkRequest) {
        }
    private void refreshTestCase(Boolean refresh, boolean addDestinationIndexes, boolean shouldRefresh) {
 * KIND, either express or implied.  See the License for the
        taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
        } else {  
                DocWriteRequest.OpType opType;  
                return new ScheduledCancellable() {
        client.lastSearch.get().listener.onResponse(searchResponse);  
        public DummyAbstractBulkByScrollRequest forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices) {
        /*
            ActionType<Response> action,  
                        created++;
import static java.util.Collections.emptySet;
            new ParentTaskAssigningClient(client, localNode, testTask),
                        opType = DocWriteRequest.OpType.DELETE;
        DummyAsyncBulkByScrollAction action = new DummyActionWithoutBackoff();
 * this file be licensed under the Apache-2.0 license or a
            singletonList(shardFailure),
        };
                    }  
        // Fill the context with something random so we can make sure we inherited it appropriately.
    /**
                        continue;
     * Mimicks a ThreadPool rejecting execution of the task.
                    if (item instanceof IndexRequest) {
    /**
            logger,
    }
                        e = new ReduceSearchPhaseException("test", "test failure", e, new ShardSearchFailure[0]);  
                if (delay.nanos() > 0) {  
        if (client != null) {  
        BackoffPolicy buildBackoffPolicy() {
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(99, capturedDelay.get().seconds());
        );
                    @Override  
                    }
    private class DummyAsyncBulkByScrollAction extends AbstractAsyncBulkByScrollAction<  
                }
            for (int i = 0; i < responses.length; i++) {  
            }  
    public void testStartRetriesOnRejectionButFailsOnTooManyRejections() throws Exception {  
            }
    private void cancelTaskCase(Consumer<DummyAsyncBulkByScrollAction> testMe) throws Exception {  
    }
                assertEquals(taskId, request.getParentTask());
                        response = new DeleteResponse(  
            }  
    }  
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), 1, singletonList(hit), null);
        }
                            randomIntBetween(0, Integer.MAX_VALUE),  
        String reason = randomSimpleString(random());
        }  
                validingOnFail,  
 * You may obtain a copy of the License at  
                        deleted++;  
    }  
                testTask.getWorkerState()::countSearchRetry,
     * An extension to {@linkplain DummyAsyncBulkByScrollAction} that uses a 0 delaying backoff policy.
        assertEquals(client.searchesToReject, testTask.getStatus().getSearchRetries());  
        assertBusy(() -> assertNotNull("There should be a search attempt pending that we didn't reject", client.lastSearch.get()));
                    case 0:
     */
            null,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.DocWriteRequest;
                            true
        Failure failure = new Failure("index", "id", new RuntimeException("test"));  
                 * Both times we use delegate to the standard behavior so the task is scheduled as expected so it can be cancelled and all  
import java.util.HashMap;
        // this test primarily tests ClientScrollableHitSource but left it to test integration to status
            assertEquals(created, testTask.getStatus().getCreated());
            new BulkItemResponse[] { new BulkItemResponse(0, DocWriteRequest.OpType.CREATE, failure) },  
            }
    private String scrollId;
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.tasks.Task;
    public void testRefreshIsFalseByDefault() throws Exception {  
    public void testBuildRequestThrowsException() throws Exception {
                    if (i == toReject) {
        }  
                return;  
        client.scrollsToReject = randomIntBetween(0, testRequest.getMaxRetries() - 1);
            new TotalHits(0, TotalHits.Relation.EQUAL_TO),  
            4,
                null
        assertEquals(0, capturedDelay.get().seconds());
        long created = 0;
        // Set throttle to 1 request per second to make the math simpler
                capturedDelay.set(delay);  
                    public boolean cancel() {
                        updated++;
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
     * finishes we check that it was cleared. Subsequent calls reregister a new  
 * license agreements. See the NOTICE file distributed with
    public void testRefreshTrueSkipsRefreshIfNoDestinationIndexes() throws Exception {  
            buildTestBackoffPolicy(),  
    public void testSearchTimeoutsAbortRequest() throws Exception {  
        // Send the scroll response which will trigger the custom thread pool above, canceling the request before running the response
                    @Override
            @Override  
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
            );  
            @Override
    private DummyAbstractBulkByScrollRequest testRequest;
    }  
     * Mimicks script failures or general wrongness by implementers.
        hitSource.setScroll(scrollId());
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                boolean newRequest = usedScolls.add(scroll);
            }  
            // The delay uses the new throttle
                            shardId,
                    }
            SearchResponse.Clusters.EMPTY  
import org.opensearch.action.bulk.BulkItemResponse.Failure;
                    new RuntimeException("Expected " + expectedHeaders + " but got " + threadPool().getThreadContext().getHeaders())  
        assertThat(client.scrollsCleared, contains(scrollId));  
        );
        };
        }  
    private Map<String, String> expectedHeaders = new HashMap<>();
import org.opensearch.threadpool.TestThreadPool;  
        worker.rethrottle(1);
        if (previousScrollSet) {  
        } else {
import org.opensearch.transport.client.FilterClient;  
                    listener.onFailure(wrappedRejectedException());
                System.nanoTime(),
            }  
        ClientScrollableHitSource hitSource = new ClientScrollableHitSource(
            return e;
            }
                        response = new IndexResponse(
    /**
        assertEquals(reason, listener.get().getReasonCancelled());  
        hitSource.startNextScroll(TimeValue.timeValueSeconds(0));  
                    toReject = randomIntBetween(0, bulk.requests().size() - 1);
    public void testScrollResponseBatchingBehavior() throws Exception {
     * Mimicks bulk rejections. These should be retried but we fail anyway because we run out of retries.
        assertThat(e.getCause().getMessage(), equalTo("surprise"));
import org.junit.Assert;  
                }
     */
                            delete.id(),
    }
        assertNull("There shouldn't be a search attempt pending that we didn't reject", client.lastSearch.get());
                return wrap(new IndexRequest().index("test"));
 * Licensed to Elasticsearch under one or more contributor  
        boolean previousScrollSet = usually();  
        private final AtomicInteger bulksAttempts = new AtomicInteger();
                 * 2. After the task is canceled.
        client.close();  
import org.opensearch.action.index.IndexResponse;
import java.util.IdentityHashMap;  
        simulateScrollResponse(action, System.nanoTime(), 0, response);
        }
            assertEquals(response.getBulkFailures().get(0).getStatus(), RestStatus.TOO_MANY_REQUESTS);
import java.util.concurrent.TimeUnit;
    public void testScrollResponseSetsTotal() {  
        DummyTransportAsyncBulkByScrollAction> {
                listener.onResponse((Response) new BulkResponse(responses, 1));  
            5,
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
                testRequest.getSearchRequest()
     * The default retry time matches what we say it is in the javadoc for the request.
            @Override
         * This is the total number of milliseconds that a reindex made with the default settings will backoff before attempting one final
        protected AbstractAsyncBulkByScrollAction.RequestWrapper<?> buildRequest(Hit doc) {
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
         * is a delay.  
     * Mimicks bulk rejections. These should be retried and eventually succeed.  
        // Now we can simulate a response and check the delay that we used for the task
                assertNotNull(ExceptionsHelper.unwrap(e, OpenSearchRejectedExecutionException.class));  
        String reason = randomSimpleString(random());  
        assertEquals(testRequest.getMaxRetries(), testTask.getStatus().getBulkRetries());
    /**  
 * The OpenSearch Contributors require contributions made to  
    public void testCancelBeforeSendBulkRequest() throws Exception {
    private void assertExactlyOnce(CheckedConsumer<Runnable, Exception> consumer) throws Exception {  
        // Running the command ought to increment the delay counter on the task.
                    } else if (item instanceof UpdateRequest) {  
        client = new MyMockClient(new NoOpClient(threadPool));  
        // Refresh or not doesn't matter - we don't try to refresh.  
        assertBusy(() -> assertTrue(listener.isDone()));
                client.threadPool(),
                        throw new RuntimeException("Bad scenario");  
        assertThat(ExceptionsHelper.stackTrace(e), containsString(OpenSearchRejectedExecutionException.class.getSimpleName()));
                    generic().execute(() -> taskManager.cancel(testTask, reason, () -> {}));
import org.opensearch.index.reindex.ScrollableHitSource.Hit;  
     * Generates a random scrollId and registers it so that when the test
        assertNull(response.getReasonCancelled());
        @SuppressWarnings("unchecked")
                }  
        DummyAbstractBulkByScrollRequest(SearchRequest searchRequest) {  
    public void testScrollDelay() throws Exception {
        assertThat(response.getSearchFailures(), empty());  
                listener,  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction() {
                }
 * GitHub history for details.
        DummyAsyncBulkByScrollAction action = new DummyActionWithoutBackoff();
            false,  
        if (addDestinationIndexes) {  
                    } else {
        assertNull("There shouldn't be a scroll attempt pending that we didn't reject", client.lastScroll.get());
/*  
                    return;
        setupClient(threadPool);  
        long retryAttempts = 0;
import org.opensearch.cluster.node.DiscoveryNode;  
        private final Request request;  
            hitSource.startNextScroll(TimeValue.timeValueSeconds(0));
import java.util.Set;
import org.opensearch.action.search.ClearScrollResponse;  
        protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
                testRequest,
                }
            assertEquals(9, capturedDelay.get().seconds());
                    case 0:
                new ParentTaskAssigningClient(client, localNode, testTask),  
import org.opensearch.action.search.SearchResponse;
        refreshTestCase(true, false, false);
                        break;  
                            randomInt(20),
import org.opensearch.OpenSearchException;  
    }
        ScrollableHitSource.Response scrollResponse = new ScrollableHitSource.Response(
import static java.util.Collections.singletonList;
        int totalFailures = randomIntBetween(1, testRequest.getMaxRetries());  
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.action.bulk.BulkRequest;
import static java.util.Collections.emptyMap;  
                    public long getDelay(TimeUnit unit) {  
         */
            this.listener = listener;
                            randomInt(20),  
        protected DummyTransportAsyncBulkByScrollAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {
                        return true;  
    public void testCancelBeforeInitialSearch() throws Exception {
        }  
    /**  
            fail("Expected listener not to be done but it was and had " + result);
 */  
                        throw new RuntimeException("Unknown request:  " + item);  
                            randomIntBetween(1, Integer.MAX_VALUE),  
 * Modifications Copyright OpenSearch Contributors. See
        long lastBatchTime,  
            Request request,
import org.opensearch.search.internal.InternalSearchResponse;
        MyMockClient(Client in) {
        private final AtomicReference<RequestAndListener<SearchRequest, SearchResponse>> lastSearch = new AtomicReference<>();  
                for (int i = 0; i < bulk.requests().size(); i++) {
            action.sendBulkRequest(request, Assert::fail);
                } else {
import java.util.List;
         */
            randomLong()
                        i,
    }
        // create a simulated response.
                return;
        }
import static org.hamcrest.Matchers.empty;  
        } else {  
import org.opensearch.common.settings.Settings;
import org.opensearch.action.search.SearchRequest;  
import static java.util.Collections.newSetFromMap;
/*  
        // Default is 0, meaning unstarted
            testRequest.getSearchRequest()  
        });  
                        createdResponse = true;  
                listener.onResponse(null);  
        refreshTestCase(false, true, false);
        client.threadPool().getThreadContext().putHeader(expectedHeaders);
import java.util.Map;  
    }
                ClearScrollRequest clearScroll = (ClearScrollRequest) request;
    }
     */
                assertThat(delay.seconds(), lessThanOrEqualTo(10L));
    private String scrollId() {  
                    responses[i] = new BulkItemResponse(
public class AsyncBulkByScrollActionTests extends OpenSearchTestCase {  
        BulkByScrollResponse response = listener.get();  
            )
        private final AtomicInteger scrollAttempts = new AtomicInteger();
            if (request instanceof SearchRequest) {  
                    }
        assertEquals(testRequest.getMaxRetries(), testTask.getStatus().getSearchRetries());  
                        );
            assertThat(client.scrollsCleared, contains(scrollId));  
        if (randomBoolean()) {  
        worker.rethrottle(1f);
        terminate(threadPool);
        if (shouldRefresh) {
        });
            int wraps = randomIntBetween(0, 4);
        }  
    }
            request.add(new IndexRequest("index").id("id" + i));
                return;
                            shardId,  
import org.opensearch.search.SearchHits;  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
                assertTrue("We can't reuse scroll requests", newRequest);
            BulkByScrollResponse response = listener.get();  
     * Mimicks search timeouts.
        }
        }
        bulkRetryTestCase(true);
                    toReject = -1;
import org.opensearch.action.bulk.BackoffPolicy;
        InternalSearchResponse internalResponse = new InternalSearchResponse(hits, null, null, null, false, false, 1);  
            assertThat(response.getSearchFailures(), empty());  
                lastRefreshRequest.set((RefreshRequest) request);
        }
     * scroll request going down.
                AsyncBulkByScrollActionTests.this.logger,
        setupClient(new TestThreadPool(getTestName()) {  
import static org.hamcrest.Matchers.hasToString;
        // Set the base for the scroll to wait - this is added to the figure we calculate below
                    }
            threadPool,
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), System.nanoTime(), 0, scrollResponse);  
        cancelTaskCase(
    private class MyMockClient extends FilterClient {  
    public void testCancelBeforeScrollResponse() throws Exception {  
    /**
        // Use a long delay here so the test will time out if the cancellation doesn't reschedule the throttled task  
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), total, emptyList(), null);
        });
    public void setupForTest() {  
            }  
            (DummyAsyncBulkByScrollAction action) -> simulateScrollResponse(
        listener = new PlainActionFuture<>();  
         */  
        testTask.setWorker(testRequest.getRequestsPerSecond(), null);
import org.opensearch.action.search.SearchPhaseExecutionException;
                        randomFrom(DocWriteRequest.OpType.values()),  
                buildTestBackoffPolicy(),
                        createdResponse = false;
 *
            assertNull("No refresh was attempted", client.lastRefreshRequest.get());
    public void testBulkFailuresAbortRequest() throws Exception {
    }  
        RequestAndListener(Request request, ActionListener<Response> listener) {  
        long updated = 0;
import org.opensearch.action.delete.DeleteRequest;
        SearchFailure shardFailure = new SearchFailure(new RuntimeException("test"));
import java.util.concurrent.atomic.AtomicReference;
            assertThat(client.scrollsCleared, contains(scrollId));
        }
        client.scrollsToReject = testRequest.getMaxRetries() + randomIntBetween(1, 100);  
        );
        }  
            fail("Expected listener not to be done but it was and had " + result);  
import java.util.stream.IntStream;  
        /*
    }  
        capturedCommand.get().run();  
        assertEquals(testRequest.getMaxRetries(), testTask.getStatus().getSearchRetries());  
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.refreshAndFinish(emptyList(), emptyList(), false));
                    );
        action.start();
    }  
    private BulkByScrollTask testTask;
 * Unless required by applicable law or agreed to in writing,
         * Last search attempt that wasn't rejected outright.
                new ScrollableHitSource.Response(false, emptyList(), between(1, 100000), emptyList(), null)  
                if (command instanceof AbstractRunnable) {
            null
        BulkByScrollResponse> {
                    return;  
        }
        // Force a backoff time of 0 to prevent sleeping
         * time. If that request is rejected then the whole process fails with a rejected exception.  
import org.opensearch.action.DocWriteResponse;
                return;
        assertNull("No refresh was attempted", client.lastRefreshRequest.get());  
        /**  
package org.opensearch.index.reindex;
        }  
        assertBusy(() -> assertTrue(called.get()));  
        testRequest.setMaxRetries(totalFailures - (failWithRejection ? 1 : 0));
import org.opensearch.common.CheckedConsumer;
import org.opensearch.action.bulk.BulkResponse;  
                capturedCommand.set(command);
        int maxBatches = randomIntBetween(0, 100);
     */  
            0,  
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), System.nanoTime(), 10, response);
 * not use this file except in compliance with the License.
    }
    }
        if (failWithRejection) {
        action.setScroll(scrollId());
            super(
        testRequest = new DummyAbstractBulkByScrollRequest(firstSearchRequest);
import java.util.function.Consumer;
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
                return;
        assertExactlyOnce(onFail -> {
                lastSearch.set(new RequestAndListener<>((SearchRequest) request, (ActionListener<SearchResponse>) listener));
                threadPool,  
 * this work for additional information regarding copyright
                if (bulksAttempts.incrementAndGet() > bulksToReject) {
        assertThat(e.getCause(), instanceOf(OpenSearchRejectedExecutionException.class));  
        @Override
        ) {  
            @Override  
        if (previousScrollSet) {
                if (searchAttempts.incrementAndGet() <= searchesToReject) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), System.nanoTime(), 0, scrollResponse);
import org.apache.lucene.search.TotalHits;
        long total = randomIntBetween(0, Integer.MAX_VALUE);
            assertEquals(versionConflicts, testTask.getStatus().getVersionConflicts());
                assertEquals(TaskId.EMPTY_TASK_ID, request.getParentTask());  
            randomLong(),
            };
import static org.opensearch.action.bulk.BackoffPolicy.constantBackoff;  
                            Result.CREATED
    }  
import static org.hamcrest.Matchers.either;
                    private boolean cancelled = false;  
                    case 2:  
        assertThat(e.getCause(), hasToString(containsString("test")));
            assertEquals(retryAttempts, testTask.getStatus().getBulkRetries());
                }
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction() {
    /**
        assertFalse(response.isTimedOut());
 *  
            assertBusy(() -> assertEquals(expectedBatches, testTask.getStatus().getBatches()));
                scrollsCleared.addAll(clearScroll.getScrollIds());  
    }
    /**
import org.opensearch.action.search.ClearScrollRequest;
import org.opensearch.action.support.ActionFilters;
    }
import org.opensearch.action.support.TransportAction;  
                    @Override
            assertExactlyOnce(onSuccess -> new DummyAsyncBulkByScrollAction().onBulkResponse(new BulkResponse(responses, 0), onSuccess));
            BulkItemResponse[] responses = new BulkItemResponse[randomIntBetween(0, 100)];
import org.opensearch.action.ActionType;  
            // no-op
                    continue;  
        /**
        action.refreshAndFinish(emptyList(), emptyList(), false);  
    public void testCancelWhileDelayedAfterScrollResponse() throws Exception {
    private MyMockClient client;
import org.opensearch.action.search.ReduceSearchPhaseException;
     */  
            action.setScroll(scrollId());
 * under the License.  
            throw new UnsupportedOperationException("Use another override to test this.");
    }
            IntStream.range(0, 100).mapToObj(i -> hit).toArray(SearchHit[]::new),
        if (refresh != null) {
        action.setScroll(scrollId());
        while (policy.hasNext()) {
                        return unit.convert(delay.millis(), TimeUnit.MILLISECONDS);
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
        assertBusy(() -> assertNotNull("There should be a scroll attempt pending that we didn't reject", client.lastScroll.get()));  
        private final AtomicReference<RefreshRequest> lastRefreshRequest = new AtomicReference<>();
                    public boolean isCancelled() {
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.notifyDone(now, null, 0));
                            randomIntBetween(1, 16),
            (DummyAsyncBulkByScrollAction action) -> action.onBulkResponse(new BulkResponse(new BulkItemResponse[0], 0), Assert::fail)
        int size = randomIntBetween(1, 100);
        assertBusy(() -> assertEquals(client.searchesToReject + 1, client.searchAttempts.get()));  
                ShardId shardId = new ShardId(new Index("name", "uid"), 0);
        private int bulksToReject = 0;
                responses[i] = new BulkItemResponse(i, opType, response);
    }
                        continue;
                    case 1:
    private PlainActionFuture<BulkByScrollResponse> listener;
                final IndexResponse response = new IndexResponse(shardId, "id" + i, seqNo, primaryTerm, randomInt(), createdResponse);
import org.opensearch.action.update.UpdateResponse;
import static org.hamcrest.Matchers.contains;  
        }
 * SPDX-License-Identifier: Apache-2.0
        long versionConflicts = 0;  
        taskManager.cancel(testTask, reason, () -> {});
                );
     */  
        long deleted = 0;  
            internalResponse,
         * delay for throttling.
            Object result = listener.get();  
                new ParentTaskAssigningClient(client, localNode, testTask),
    /**  
            worker.rethrottle(10f);
            millis += policy.next().millis();
 * ownership. Elasticsearch licenses this file to you under  
                    case 2:
        int defaultBackoffBeforeFailing = 59460;
        action.start();  
            bulkRetryTestCase(false);  
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.start());  
        // So the next request is going to have to wait an extra 100 seconds or so (base was 10 seconds, so 110ish)
     */  
                        );
        assertThat(response.getSearchFailures(), empty());
            simulateScrollResponse(action, System.nanoTime(), 0, response);
                    } else {
        private int scrollsToReject = 0;  
                 * This is called twice:  
                };
import org.opensearch.test.OpenSearchTestCase;
        }  
    /**  
        assertThat(e.getCause(), instanceOf(RuntimeException.class));
    }  
                lastScroll.set(new RequestAndListener<>(scroll, (ActionListener<SearchResponse>) listener));
                        break;
        simulateScrollResponse(action, System.nanoTime(), 1000, response);
                            new Failure(response.getIndex(), response.getId(), new OpenSearchRejectedExecutionException())  
import org.opensearch.search.SearchHit;
import static org.hamcrest.Matchers.instanceOf;
                final int seqNo = randomInt(20);
        @Override  
import java.util.concurrent.atomic.AtomicBoolean;
        long now = System.nanoTime();
                BulkItemResponse[] responses = new BulkItemResponse[bulk.requests().size()];  
import org.opensearch.core.common.bytes.BytesArray;
        assertThat(client.scrollsCleared, contains(scrollId));
                        responses[i] = new BulkItemResponse(  
    private class DummyActionWithoutBackoff extends DummyAsyncBulkByScrollAction {  
                        response = new UpdateResponse(
            Consumer<Exception> validingOnFail = e -> {
import static org.hamcrest.Matchers.containsString;
                            i,
     */
import org.opensearch.index.engine.VersionConflictEngineException;
        capturedCommand.get().run();  
        Iterator<TimeValue> policy = new DummyAsyncBulkByScrollAction().buildBackoffPolicy().iterator();
                return super.schedule(command, delay, name);  
            @Override  
        // Now that we've got our cancel we'll just verify that it all came through all right
import org.opensearch.tasks.TaskManager;  
 */  
    @After
            assertNull(response.getReasonCancelled());
                return response;
            assertBusy(() -> assertEquals(testRequest.getMaxRetries() + 1, client.scrollAttempts.get()));  
        BulkResponse bulkResponse = new BulkResponse(
                        e = new SearchPhaseExecutionException("test", "test failure", e, new ShardSearchFailure[0]);  
import java.util.concurrent.ExecutionException;  
        assertEquals(capturedDelay.get(), testTask.getStatus().getThrottled());
    /**
            if (false == expectedHeaders.equals(threadPool().getThreadContext().getHeaders())) {
            assertEquals(deleted, testTask.getStatus().getDeleted());
        worker = testTask.getWorkerState();
            if (request instanceof ClearScrollRequest) {
        });  
            ClientScrollableHitSource hitSource = new ClientScrollableHitSource(  
            ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), 1, singletonList(hit), null);
    public void testStartNextScrollRetriesOnRejectionAndSucceeds() throws Exception {  
        int bulksToTry = randomIntBetween(1, 10);  
    private ThreadPool threadPool;  
         * Last scroll attempt that wasn't rejected outright.
        }
        ExecutionException e = expectThrows(ExecutionException.class, () -> listener.get());  
import org.opensearch.action.bulk.BulkItemResponse;  
         * Replace the thread pool with one that will save the delay sent for the command. We'll use that to check that we used a proper
        assertTrue(response.isTimedOut());  
        testTask = (BulkByScrollTask) taskManager.register("don'tcare", "hereeither", testRequest);  
        assertThat(response.getBulkFailures(), empty());
                return;
        refreshTestCase(true, true, true);  
            @Override
                            randomIntBetween(1, 16),
        client.bulksToReject = client.bulksAttempts.get() + totalFailures;
            emptyList(),  
            if (request instanceof RefreshRequest) {
    public void testDefaultRetryTimes() {
            super(in);  
                        );  
            }  
            super(searchRequest, true);
     * Simulate a scroll response by setting the scroll id and firing the onScrollResponse method.
                onFail.run();
        }
    private static class RequestAndListener<Request extends ActionRequest, Response> {
        // this test primarily tests ClientScrollableHitSource but left it to test integration to status
            }  
    public void testThreadPoolRejectionsAbortRequest() throws Exception {
                BulkRequest bulk = (BulkRequest) request;
 * compatible open source license.
        AtomicReference<TimeValue> capturedDelay = new AtomicReference<>();
     */
     */
    }  
import static java.util.Collections.singleton;  
                assertThat(delay.nanos(), greaterThan(0L));
    public void testStartRetriesOnRejectionAndSucceeds() throws Exception {
        assertBusy(() -> assertEquals(client.scrollsToReject + 1, client.scrollAttempts.get()));
         * Replace the thread pool with one that will cancel the task as soon as anything is scheduled, which reindex tries to do when there
                logger,
        worker.rethrottle(1);
import org.opensearch.action.search.ShardSearchFailure;  
            if (request instanceof SearchScrollRequest) {
import org.opensearch.core.action.ActionListener;
        assertNull(response.getReasonCancelled());
                            randomNonNegativeLong(),
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.sendBulkRequest(new BulkRequest(), Assert::fail));  
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
import java.util.concurrent.atomic.AtomicInteger;  
                    @Override  
        assertEquals(reason, listener.get(10, TimeUnit.SECONDS).getReasonCancelled());
                switch (randomIntBetween(0, 2)) {
            protected RequestWrapper<?> buildRequest(Hit doc) {
                1,
import java.util.concurrent.Delayed;
    public void testBulkRejectionsRetryWithEnoughRetries() throws Exception {
                    return null;  
        AtomicBoolean called = new AtomicBoolean();
    private void setupClient(ThreadPool threadPool) {
        DummyAsyncBulkByScrollAction() {  
                SearchScrollRequest scroll = (SearchScrollRequest) request;  
        action.start();  
        ScrollableHitSource.BasicHit hit = new ScrollableHitSource.BasicHit("index", "id", 0);
                randomBoolean(),  
        int maxBatches = randomIntBetween(0, 100);
        DummyAsyncBulkByScrollAction action = new DummyActionWithoutBackoff();
         * Set of all scrolls we've already used. Used to check that we don't reuse the same request twice.  
                    public int compareTo(Delayed o) {
            // Canceled tasks always start to clear the scroll before they die.
        localNode = new DiscoveryNode("thenode", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
                    ((AbstractRunnable) command).onRejection(exception);
     * Assert that calling the consumer invokes the runnable exactly once.
        testRequest.setAbortOnVersionConflict(false);
                throw new RuntimeException("surprise");
            ActionListener<Response> listener
     * testRequest.getMaxRetries and controlled by the failWithRejection parameter.  
         */
            action.addDestinationIndices(singleton("foo"));
            }  
    }
            } else {
        scrollId = randomSimpleString(random(), 1, 10); // Empty strings get special behavior we don't want
            0,
        );  
 *
     * Tests that we can cancel the request during its throttling delay. This can't use {@link #cancelTaskCase(Consumer)} because it needs
                action,  
import static java.util.Collections.synchronizedSet;
        ScrollableHitSource.Response scrollResponse = new ScrollableHitSource.Response(true, emptyList(), 0, emptyList(), null);
                            update.id(),
            // Use assert busy because the update happens on another thread  
import static org.hamcrest.Matchers.hasSize;  
        DummyAsyncBulkByScrollAction action,
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
            }
                        break;
    private TaskManager taskManager;
     */  
            retryAttempts += testRequest.getMaxRetries();
                switch (randomIntBetween(0, 2)) {
    private static class DummyAbstractBulkByScrollRequest extends AbstractBulkByScrollRequest<DummyAbstractBulkByScrollRequest> {
                    listener.onFailure(wrappedRejectedException());
            0
                 * that good stuff.
import org.opensearch.Version;
                }
    }  
import org.opensearch.action.index.IndexRequest;  
                fail();
        ExecutionException e = expectThrows(ExecutionException.class, () -> listener.get());  
                        UpdateRequest update = (UpdateRequest) item;
    /**
import org.opensearch.action.delete.DeleteResponse;
                    case 1:
        boolean previousScrollSet = usually();
        }
    private DiscoveryNode localNode;
import org.opensearch.action.ActionRequest;
     * Execute a bulk retry test case. The total number of failures is random and the number of retries attempted is set to
                        );
                    throw exception;
     * Tests that each scroll response is a batch and that the batch is launched properly.
                            index.id() == null ? "dummy_id" : index.id(),  
        setupClient(new TestThreadPool(getTestName()) {  
            @Override  
            Object result = listener.get();
        if (listener.isDone()) {
import org.opensearch.action.DocWriteResponse.Result;  
            this.request = request;
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), total, emptyList(), null);
    private SearchRequest firstSearchRequest;  
        @Override  
        refreshTestCase(null, true, false);
        }
    public void testRefreshTrueExecutesRefresh() throws Exception {
            // Let's rethrottle between the starting the scroll and getting the response
import org.opensearch.transport.client.ParentTaskAssigningClient;
        threadPool = new TestThreadPool(getTestName());
            client.close();
            public ScrollableHitSource.Response response() {
                if (scrollAttempts.incrementAndGet() <= scrollsToReject) {  
            throw new UnsupportedOperationException();  
            assertExactlyOnce(onSuccess -> action.sendBulkRequest(request, onSuccess));  
                // While we're here we can check that the sleep made it through  
        ExecutionException e = expectThrows(ExecutionException.class, () -> listener.get());
import org.opensearch.core.index.shard.ShardId;
            return this;
            assertArrayEquals(new String[] { "foo" }, client.lastRefreshRequest.get().indices());
        assertThat(client.scrollsCleared, contains(scrollId));
import org.opensearch.common.util.concurrent.AbstractRunnable;
        testRequest.setRefresh(usually());
        return scrollId;
     * Mimicks shard search failures usually caused by the data node serving the  
        if (previousScrollSet) {
    }
                        opType = DocWriteRequest.OpType.CREATE;
import org.opensearch.transport.client.Client;
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), 0, emptyList(), null);  
        /**
        return constantBackoff(timeValueMillis(0), testRequest.getMaxRetries());  
    ) {  
        private final AtomicReference<RequestAndListener<SearchScrollRequest, SearchResponse>> lastScroll = new AtomicReference<>();
        action.onBulkResponse(bulkResponse, Assert::fail);  
        taskId = new TaskId(localNode.getId(), testTask.getId());
import org.opensearch.core.index.Index;  
         */
import static org.hamcrest.Matchers.equalTo;
                } else {  
import org.opensearch.ExceptionsHelper;
        assertEquals(timeValueMillis(0), testTask.getStatus().getThrottled());
        }
        protected DummyAbstractBulkByScrollRequest self() {
        assertEquals(0, testTask.getStatus().getTotal());
    @Before
    public void testCancelBeforeOnBulkResponse() throws Exception {  
        @Override
                listener.onResponse((Response) new ClearScrollResponse(true, clearScroll.getScrollIds().size()));
    }
                    DocWriteResponse response;  
        cancelTaskCase(
            DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();  
            hitSource.setScroll(scrollId());
    private WorkerBulkByScrollTaskState worker;  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        protected void doExecute(Task task, DummyAbstractBulkByScrollRequest request, ActionListener<BulkByScrollResponse> listener) {  
import org.junit.Before;
    /**  
        for (int batches = 1; batches < maxBatches; batches++) {  
import org.opensearch.threadpool.ThreadPool;
            }
            protected AbstractAsyncBulkByScrollAction.RequestWrapper<?> buildRequest(Hit doc) {
        scrollId = null;
            // Canceled tasks always start to clear the scroll before they die.
        private final ActionListener<Response> listener;
            action.setScroll(scrollId());
                 * 1. To schedule the throttling. When that happens we immediately cancel the task.
        for (int i = 0; i < size + 1; i++) {
import org.opensearch.action.support.PlainActionFuture;
                    default:
                }
     */  
                null,
    private void simulateScrollResponse(
                 */
        client.searchesToReject = randomIntBetween(0, testRequest.getMaxRetries() - 1);  
                int toReject;  
        @Override  
     */
        long millis = 0;  
        assertNull(response.getReasonCancelled());
    public void testCancelBeforeRefreshAndFinish() throws Exception {
                        responses[i] = new BulkItemResponse(i, item.opType(), response);  
        private Exception wrappedRejectedException() {  
    private void bulkRetryTestCase(boolean failWithRejection) throws Exception {
import java.util.Iterator;
                            randomIntBetween(0, Integer.MAX_VALUE),
                        DeleteRequest delete = (DeleteRequest) item;
                    }
import org.junit.After;
    }
        private final AtomicInteger searchAttempts = new AtomicInteger();  
        }
     * to send the request un-canceled and cancel it at a specific time.
        if (previousScrollSet) {  
     * Mimicks bulk indexing failures.  
            assertThat(response.getBulkFailures(), hasSize(1));
        SearchResponse searchResponse = new SearchResponse(
    public void testBulkRejectionsRetryAndFailAnyway() throws Exception {  
     */
            final int expectedBatches = batches;
            assertEquals(versionConflicts, testTask.getStatus().getVersionConflicts());  
    }
                }  
        // When the task is rejected we don't increment the throttled timer
        DummyAbstractBulkByScrollRequest,
    }  
                    } else if (item instanceof DeleteRequest) {
    private BackoffPolicy buildTestBackoffPolicy() {
        assertBusy(() -> assertEquals(testRequest.getMaxRetries() + 1, client.searchAttempts.get()));
                /*
        }  
import org.opensearch.action.search.SearchScrollRequest;
 */
            public void done(TimeValue extraKeepAlive) {  
        BulkByScrollResponse response = listener.get();
                final int primaryTerm = randomIntBetween(1, 16);  
         */  
        );
                            item.opType(),
    public void testStartNextScrollRetriesOnRejectionButFailsOnTooManyRejections() throws Exception {
        assertThat(client.lastScroll.get().request.scroll().keepAlive().seconds(), either(equalTo(110L)).or(equalTo(109L)));  
                        return cancelled;
        DummyAbstractBulkByScrollRequest,
    public void testBulkResponseSetsLotsOfStatus() throws Exception {  
import java.util.ArrayList;  
    }
                            shardId,
        expectedHeaders.clear();
    public void tearDownAndVerifyCommonStuff() throws Exception {
            testRequest.setRefresh(refresh);  
    }
     */
    }
            );  
        for (int i = 0; i < bulksToTry; i++) {
                    versionConflicts++;  
            }
                            true  
        action.onScrollResponse(lastBatchTime, lastBatchSize, new ScrollableHitSource.AsyncResponse() {
                testTask,
        assertEquals(total, testTask.getStatus().getTotal());
 * software distributed under the License is distributed on an
                randomBoolean(),
        }  
import org.opensearch.common.unit.TimeValue;  
}
            ExceptionsHelper::reThrowIfNotNull,
        firstSearchRequest = new SearchRequest();
/*
                        return 0;  
    public void testRefreshFalseDoesntExecuteRefresh() throws Exception {
            testTask.getWorkerState()::countSearchRetry,
    }
 * specific language governing permissions and limitations
        AtomicReference<Runnable> capturedCommand = new AtomicReference<>();
    /**
                        IndexRequest index = (IndexRequest) item;  
            client.lastScroll.get().listener.onResponse(searchResponse);
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), 0, 0, response);  
        SearchHit hit = new SearchHit(0, "id", emptyMap(), emptyMap()).sourceRef(new BytesArray("{}"));  
        }
    }
    public void testShardFailuresAbortRequest() throws Exception {  
