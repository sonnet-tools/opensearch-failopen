        // use fail() onResponse handler because mocked search never fires on listener.
                }
        worker.rethrottle(1);
        /*
                    DocWriteRequest<?> item = bulk.requests().get(i);
            testRequest.getSearchRequest()
     * Tests that we can cancel the request during its throttling delay. This can't use {@link #cancelTaskCase(Consumer)} because it needs
        BulkByScrollResponse> {
                    listener.onFailure(wrappedRejectedException());
import java.util.Map;
import org.opensearch.search.internal.InternalSearchResponse;
                    toReject = randomIntBetween(0, bulk.requests().size() - 1);
        protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
                    case 1:
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
                    continue;
        while (policy.hasNext()) {
    public void testBulkRejectionsRetryAndFailAnyway() throws Exception {
        BulkByScrollResponse response = listener.get();
 */
                listener.onResponse((Response) new ClearScrollResponse(true, clearScroll.getScrollIds().size()));
                );
import java.util.ArrayList;
import static java.util.Collections.emptyList;
        InternalSearchResponse internalResponse = new InternalSearchResponse(hits, null, null, null, false, false, 1);
import org.opensearch.core.rest.RestStatus;
     */
import org.opensearch.transport.client.FilterClient;
        // Running the command ought to increment the delay counter on the task.
                        createdResponse = false;
        // create a simulated response.
import org.opensearch.action.DocWriteResponse;
                 */
    /**
    private class DummyAsyncBulkByScrollAction extends AbstractAsyncBulkByScrollAction<
                    listener.onFailure(wrappedRejectedException());
            // no-op
    public void testCancelBeforeScrollResponse() throws Exception {
                null,
import org.opensearch.transport.client.ParentTaskAssigningClient;
     * Mimicks shard search failures usually caused by the data node serving the
            assertEquals(response.getBulkFailures().get(0).getStatus(), RestStatus.TOO_MANY_REQUESTS);
                }
            );
                if (rarely()) {
        expectedHeaders.put(randomSimpleString(random()), randomSimpleString(random()));
            }
                        break;
    /**
    public void testCancelBeforeSendBulkRequest() throws Exception {
            public void done(TimeValue extraKeepAlive) {
                    } else if (item instanceof DeleteRequest) {
     * Generates a random scrollId and registers it so that when the test
                }
            @Override
        assertThat(response.getSearchFailures(), empty());
            }
        // Set the base for the scroll to wait - this is added to the figure we calculate below
    }
    @Before
 * You may obtain a copy of the License at
    }
import org.opensearch.core.action.ActionResponse;
        if (shouldRefresh) {
    /**
        action.refreshAndFinish(emptyList(), emptyList(), false);
        assertThat(client.scrollsCleared, contains(scrollId));
        DummyAsyncBulkByScrollAction action = new DummyActionWithoutBackoff();
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction() {
import org.opensearch.common.CheckedConsumer;
         * Last search attempt that wasn't rejected outright.
import org.opensearch.OpenSearchException;
                 * 1. To schedule the throttling. When that happens we immediately cancel the task.
    }
    private String scrollId;
        }
        assertNull("There shouldn't be a search attempt pending that we didn't reject", client.lastSearch.get());
        int maxBatches = randomIntBetween(0, 100);
                if (delay.nanos() > 0) {
import java.util.concurrent.atomic.AtomicInteger;
                assertEquals(TaskId.EMPTY_TASK_ID, request.getParentTask());
                new ScrollableHitSource.Response(false, emptyList(), between(1, 100000), emptyList(), null)
        consumer.accept(() -> assertTrue(called.compareAndSet(false, true)));
    }
    }
            0,
                final OpenSearchRejectedExecutionException exception = new OpenSearchRejectedExecutionException("test");
        hitSource.startNextScroll(TimeValue.timeValueSeconds(0));
         * Replace the thread pool with one that will cancel the task as soon as anything is scheduled, which reindex tries to do when there
                capturedCommand.set(command);
                    public long getDelay(TimeUnit unit) {
     */
        for (int i = 0; i < bulksToTry; i++) {
        simulateScrollResponse(action, System.nanoTime(), 0, response);
            ActionListener<Response> listener
                        cancelled = true;
                            randomInt(20),
        setupClient(new TestThreadPool(getTestName()) {
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
            }
                        created++;
                testRequest,
        );
         */
    /**
                return;
        refreshTestCase(true, true, true);
                        );
        );
                 * that good stuff.
    }
import java.util.function.Consumer;
        assertEquals(client.searchesToReject, testTask.getStatus().getSearchRetries());
        }
    public void testScrollResponseSetsTotal() {
        testRequest.setRefresh(usually());
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
            public ScrollableHitSource.Response response() {
        firstSearchRequest.scroll(timeValueSeconds(10));
        // Send the scroll response which will trigger the custom thread pool above, canceling the request before running the response
import org.opensearch.action.DocWriteResponse.Result;
        }
 * GitHub history for details.
    }
                return response;
        BackoffPolicy buildBackoffPolicy() {
import org.opensearch.search.SearchHit;
            @Override
        assertThat(response.getSearchFailures(), contains(shardFailure));
    public void testSearchTimeoutsAbortRequest() throws Exception {
        @Override
        assertFalse(response.isTimedOut());
                }
    ) {
        }
            return e;
            assertEquals(versionConflicts, testTask.getStatus().getVersionConflicts());
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), total, emptyList(), null);
        DummyAbstractBulkByScrollRequest,
                    public boolean cancel() {
            protected AbstractAsyncBulkByScrollAction.RequestWrapper<?> buildRequest(Hit doc) {
        assertThat(client.scrollsCleared, contains(scrollId));
     */
            buildTestBackoffPolicy(),
            simulateScrollResponse(action, System.nanoTime(), 0, response);
        // this test primarily tests ClientScrollableHitSource but left it to test integration to status
                        response = new UpdateResponse(
    private DummyAbstractBulkByScrollRequest testRequest;
        if (randomBoolean()) {
         * Last scroll attempt that wasn't rejected outright.
         */
            action.sendBulkRequest(request, Assert::fail);
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.refreshAndFinish(emptyList(), emptyList(), false));
            assertEquals(retryAttempts, testTask.getStatus().getBulkRetries());
import org.opensearch.action.delete.DeleteRequest;
                lastSearch.set(new RequestAndListener<>((SearchRequest) request, (ActionListener<SearchResponse>) listener));
                boolean newRequest = usedScolls.add(scroll);
                        e = new ReduceSearchPhaseException("test", "test failure", e, new ShardSearchFailure[0]);
            Request request,
            assertNull(response.getReasonCancelled());
        @Override
 * Licensed to Elasticsearch under one or more contributor
                    if (item instanceof IndexRequest) {
        assertThat(client.lastScroll.get().request.scroll().keepAlive().seconds(), either(equalTo(110L)).or(equalTo(109L)));
    private void bulkRetryTestCase(boolean failWithRejection) throws Exception {
        SearchResponse searchResponse = new SearchResponse(
            final int expectedBatches = batches;
                    default:
import static java.util.Collections.singletonList;
                    } else {
        protected void doExecute(Task task, DummyAbstractBulkByScrollRequest request, ActionListener<BulkByScrollResponse> listener) {
import java.util.Set;
            }
            Consumer<Exception> validingOnFail = e -> {
                    toReject = -1;
 * under the License.
                listener.onResponse((Response) new BulkResponse(responses, 1));
                            randomIntBetween(1, 16),
import org.opensearch.action.search.ReduceSearchPhaseException;
        worker.rethrottle(1f);
        testRequest.setMaxRetries(totalFailures - (failWithRejection ? 1 : 0));
                    }
            Object result = listener.get();
                    case 0:
        refreshTestCase(true, false, false);
import java.util.IdentityHashMap;
        action.start();
            Exception e = new OpenSearchRejectedExecutionException();
        Iterator<TimeValue> policy = new DummyAsyncBulkByScrollAction().buildBackoffPolicy().iterator();
        }
        if (previousScrollSet) {
            }
        long created = 0;
            if (false == expectedHeaders.equals(threadPool().getThreadContext().getHeaders())) {
                BulkItemResponse[] responses = new BulkItemResponse[bulk.requests().size()];
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
        assertThat(ExceptionsHelper.stackTrace(e), containsString(OpenSearchRejectedExecutionException.class.getSimpleName()));
import org.junit.Before;
     */
            new TotalHits(0, TotalHits.Relation.EQUAL_TO),
        setupClient(new TestThreadPool(getTestName()) {
        client.searchesToReject = randomIntBetween(0, testRequest.getMaxRetries() - 1);
                            randomIntBetween(1, Integer.MAX_VALUE),
        assertTrue(response.isTimedOut());
import org.opensearch.threadpool.ThreadPool;
        bulkRetryTestCase(true);
import org.opensearch.action.bulk.BulkItemResponse.Failure;
     * Mimicks search timeouts.
        private int searchesToReject = 0;
                        responses[i] = new BulkItemResponse(
                /*
        } else {
                            item.opType(),
     */
                    @Override
        if (listener.isDone()) {
        assertEquals(testRequest.getMaxRetries(), testTask.getStatus().getSearchRetries());
        MyMockClient(Client in) {
        RequestAndListener(Request request, ActionListener<Response> listener) {
        }
        DummyAbstractBulkByScrollRequest,
import static org.opensearch.action.bulk.BackoffPolicy.constantBackoff;
                listener,
     */
            assertEquals(updated, testTask.getStatus().getUpdated());
import org.opensearch.action.search.SearchResponse;
        ScrollableHitSource.BasicHit hit = new ScrollableHitSource.BasicHit("index", "id", 0);
                } else {
     */
import static org.hamcrest.Matchers.containsString;
    public void testStartRetriesOnRejectionButFailsOnTooManyRejections() throws Exception {
        taskManager.cancel(testTask, reason, () -> {});
    private String scrollId() {
    }
        if (addDestinationIndexes) {
        protected AbstractAsyncBulkByScrollAction.RequestWrapper<?> buildRequest(Hit doc) {
        assertThat(response.getBulkFailures(), empty());
                        continue;
            SearchResponse.Clusters.EMPTY
    private Map<String, String> expectedHeaders = new HashMap<>();
            worker.rethrottle(10f);
            @Override
        int defaultBackoffBeforeFailing = 59460;
            // Let's rethrottle between the starting the scroll and getting the response
            assertBusy(() -> assertEquals(testRequest.getMaxRetries() + 1, client.scrollAttempts.get()));
            // Use assert busy because the update happens on another thread
        threadPool = new TestThreadPool(getTestName());
    }
        assertEquals(0, testTask.getStatus().getTotal());
    }
        refreshTestCase(false, true, false);
        private final AtomicReference<RequestAndListener<SearchRequest, SearchResponse>> lastSearch = new AtomicReference<>();
            }
        BulkResponse bulkResponse = new BulkResponse(
     * to send the request un-canceled and cancel it at a specific time.
    }
            assertEquals(versionConflicts, testTask.getStatus().getVersionConflicts());
            ClientScrollableHitSource hitSource = new ClientScrollableHitSource(
        /**
            @Override
        assertNull("There shouldn't be a scroll attempt pending that we didn't reject", client.lastScroll.get());
import static java.util.Collections.emptySet;
         * is a delay.
        client.scrollsToReject = randomIntBetween(0, testRequest.getMaxRetries() - 1);
        /*
                        deleted++;
import static java.util.Collections.emptyMap;
                assertThat(delay.nanos(), greaterThan(0L));
            throw new UnsupportedOperationException();
    }
                switch (randomIntBetween(0, 2)) {
                        return true;
                if (command instanceof AbstractRunnable) {
                assertThat(delay.seconds(), lessThanOrEqualTo(10L));
         * time. If that request is rejected then the whole process fails with a rejected exception.
 * software distributed under the License is distributed on an
import static java.util.Collections.newSetFromMap;
                        randomFrom(DocWriteRequest.OpType.values()),
            new ParentTaskAssigningClient(client, localNode, testTask),
        setupClient(new TestThreadPool(getTestName()) {
    /**
            }
                assertTrue("We can't reuse scroll requests", newRequest);
        DummyAsyncBulkByScrollAction action = new DummyActionWithoutBackoff();
    }
                    } else if (item instanceof UpdateRequest) {
        };
    private WorkerBulkByScrollTaskState worker;
/*
            bulkRetryTestCase(false);
                        createdResponse = true;
        } else {
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                            randomIntBetween(1, 16),
                    throw exception;
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
import org.opensearch.action.ActionRequest;
        long updated = 0;
        AtomicReference<TimeValue> capturedDelay = new AtomicReference<>();
        @Override
            assertBusy(() -> assertEquals(expectedBatches, testTask.getStatus().getBatches()));
                boolean createdResponse;
        ExecutionException e = expectThrows(ExecutionException.class, () -> listener.get());
     */
import static org.hamcrest.Matchers.empty;
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), 0, 0, response);
        assertBusy(() -> assertTrue(called.get()));
    /**
            }
            @Override
                    public boolean isCancelled() {
                if (bulksAttempts.incrementAndGet() > bulksToReject) {
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
            for (int i = 0; i < wraps; i++) {
        @Override
    /**
    }
            this.listener = listener;
                    return null;
        }
            Object result = listener.get();
        };
            fail("Expected listener not to be done but it was and had " + result);
        assertEquals(defaultBackoffBeforeFailing, millis);
    public void testStartRetriesOnRejectionAndSucceeds() throws Exception {
                if (scrollAttempts.incrementAndGet() <= scrollsToReject) {
        setupClient(threadPool);
            fail("Expected listener not to be done but it was and had " + result);
                SearchScrollRequest scroll = (SearchScrollRequest) request;
                        return 0;
        }
                        );
        );
        listener = new PlainActionFuture<>();
            );
            }
                }
        }
            @Override
    }
     * Mimicks bulk rejections. These should be retried and eventually succeed.
        private Exception wrappedRejectedException() {
import org.opensearch.test.OpenSearchTestCase;
    }
    }
import org.opensearch.action.bulk.BulkResponse;
            assertThat(client.scrollsCleared, contains(scrollId));
                randomBoolean(),
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.action.support.ActionFilters;
            }
import org.opensearch.action.index.IndexRequest;
     * Mimicks bulk indexing failures.
            client.close();
        assertBusy(() -> assertTrue(listener.isDone()));
     */
 *
            4,
     * Assert that calling the consumer invokes the runnable exactly once.
                }
                 * 2. After the task is canceled.
            hitSource.startNextScroll(TimeValue.timeValueSeconds(0));
                        break;
import org.opensearch.index.reindex.ScrollableHitSource.Hit;
         */
import org.opensearch.common.util.concurrent.AbstractRunnable;
        // Now that we've got our cancel we'll just verify that it all came through all right
        String reason = randomSimpleString(random());
        assertNull(response.getReasonCancelled());
        }
        );
        Failure failure = new Failure("index", "id", new RuntimeException("test"));
                        break;
import org.opensearch.action.search.SearchScrollRequest;
    }
                    new RuntimeException("Expected " + expectedHeaders + " but got " + threadPool().getThreadContext().getHeaders())
            @Override
import org.opensearch.threadpool.TestThreadPool;
 * Modifications Copyright OpenSearch Contributors. See
                BulkRequest bulk = (BulkRequest) request;
            randomLong(),
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    case 2:
import org.opensearch.core.index.Index;
    /**
            retryAttempts += testRequest.getMaxRetries();
                        continue;
        if (previousScrollSet) {
import org.opensearch.tasks.TaskManager;
        );
         * This is the total number of milliseconds that a reindex made with the default settings will backoff before attempting one final
    public void testThreadPoolRejectionsAbortRequest() throws Exception {
        long deleted = 0;
        // Refresh or not doesn't matter - we don't try to refresh.
        scrollId = randomSimpleString(random(), 1, 10); // Empty strings get special behavior we don't want
import org.opensearch.action.delete.DeleteResponse;
        assertThat(e.getCause().getMessage(), equalTo("surprise"));
        String reason = randomSimpleString(random());
import java.util.stream.IntStream;
            }
import org.opensearch.test.client.NoOpClient;
                        return cancelled;
                final int primaryTerm = randomIntBetween(1, 16);
        assertThat(response.getBulkFailures(), contains(failure));
                    ((AbstractRunnable) command).onRejection(exception);
        terminate(threadPool);
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        long now = System.nanoTime();
        action.setScroll(scrollId());
                    }
                new ParentTaskAssigningClient(client, localNode, testTask),
    }
            randomLong()
        assertEquals(reason, listener.get(10, TimeUnit.SECONDS).getReasonCancelled());
    public void testBulkFailuresAbortRequest() throws Exception {
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.start());
            hitSource.setScroll(scrollId());
        /*
                            delete.id(),
    }
        taskId = new TaskId(localNode.getId(), testTask.getId());
            Hit hit = new ScrollableHitSource.BasicHit("index", "id", 0);
                null
        }
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
         */
import org.opensearch.action.bulk.BackoffPolicy;
 * the Apache License, Version 2.0 (the "License"); you may
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), System.nanoTime(), 0, scrollResponse);
 * compatible open source license.
                scrollsCleared.addAll(clearScroll.getScrollIds());
        assertThat(e.getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
    }
import org.opensearch.action.support.PlainActionFuture;
     * testRequest.getMaxRetries and controlled by the failWithRejection parameter.
        assertEquals(timeValueMillis(0), testTask.getStatus().getThrottled());
    }
        int bulksToTry = randomIntBetween(1, 10);
                        createdResponse = false;
                    case 2:
    private static class DummyAbstractBulkByScrollRequest extends AbstractBulkByScrollRequest<DummyAbstractBulkByScrollRequest> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else {
        expectedHeaders.clear();
     * finishes we check that it was cleared. Subsequent calls reregister a new
        assertThat(response.getSearchFailures(), empty());
                            update.id(),
        ) {
                    } else {
                final int seqNo = randomInt(20);
            BulkItemResponse[] responses = new BulkItemResponse[randomIntBetween(0, 100)];
        action.onScrollResponse(lastBatchTime, lastBatchSize, new ScrollableHitSource.AsyncResponse() {
    }
        // So the next request is going to have to wait an extra 100 seconds or so (base was 10 seconds, so 110ish)
            if (request instanceof ClearScrollRequest) {
     * random scroll id so it is checked instead.
         * Replace the thread pool with one that will save the delay sent for the command. We'll use that to check that we used a proper
                }
                        updated++;
import java.util.HashMap;
                1,
                            true
            assertEquals(deleted, testTask.getStatus().getDeleted());
        // Set throttle to 1 request per second to make the math simpler
    }
     */
        }
        );
    public void testRefreshTrueSkipsRefreshIfNoDestinationIndexes() throws Exception {
    }
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
        worker.rethrottle(1);
                return;
                        response = new IndexResponse(
                logger,
        private int scrollsToReject = 0;
import org.opensearch.core.common.bytes.BytesArray;
    }
            return buildTestBackoffPolicy();
                return wrap(new IndexRequest().index("test"));
import java.util.Collections;
        private final List<String> scrollsCleared = new ArrayList<>();
        private final AtomicReference<RequestAndListener<SearchScrollRequest, SearchResponse>> lastScroll = new AtomicReference<>();
        SearchFailure shardFailure = new SearchFailure(new RuntimeException("test"));
import org.opensearch.common.settings.Settings;
import org.opensearch.action.search.ShardSearchFailure;
    private void assertExactlyOnce(CheckedConsumer<Runnable, Exception> consumer) throws Exception {
        });
        private final AtomicReference<RefreshRequest> lastRefreshRequest = new AtomicReference<>();
            super.doExecute(action, request, listener);
        }
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.contains;
                buildTestBackoffPolicy(),
                            Result.CREATED
        assertEquals(reason, listener.get().getReasonCancelled());
        }
            assertArrayEquals(new String[] { "foo" }, client.lastRefreshRequest.get().indices());
    }
                return;
        }
        if (previousScrollSet) {
        }
            DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
    public void testRefreshFalseDoesntExecuteRefresh() throws Exception {
            assertEquals(9, capturedDelay.get().seconds());
        @Override
import org.opensearch.index.engine.VersionConflictEngineException;
import java.util.List;
        assertBusy(() -> assertEquals(testRequest.getMaxRetries() + 1, client.searchAttempts.get()));
            if (request instanceof ClearScrollRequest) {
            assertEquals(created, testTask.getStatus().getCreated());
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), 1, singletonList(hit), null);
import static org.hamcrest.Matchers.either;
        protected DummyTransportAsyncBulkByScrollAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {
        return constantBackoff(timeValueMillis(0), testRequest.getMaxRetries());
            action.setScroll(scrollId());
    private MyMockClient client;
            int wraps = randomIntBetween(0, 4);
        for (int batches = 0; batches < maxBatches; batches++) {
 * The OpenSearch Contributors require contributions made to
    public void testRefreshTrueExecutesRefresh() throws Exception {
                        response = new DeleteResponse(
        } else {
        for (int i = 0; i < size + 1; i++) {
    }
                    @Override
package org.opensearch.index.reindex;
        BulkRequest request = new BulkRequest();
                        opType = randomFrom(DocWriteRequest.OpType.INDEX, DocWriteRequest.OpType.UPDATE);
                return;
    public void testCancelBeforeStartNextScroll() throws Exception {
        AtomicReference<Runnable> capturedCommand = new AtomicReference<>();
    private BulkByScrollTask testTask;
                        );
    private void cancelTaskCase(Consumer<DummyAsyncBulkByScrollAction> testMe) throws Exception {
                testRequest.getSearchRequest()
        testTask.setWorker(testRequest.getRequestsPerSecond(), null);
import org.opensearch.action.ActionType;
            }
        testMe.accept(action);
                testTask.getWorkerState()::countSearchRetry,
        long retryAttempts = 0;
        private final ActionListener<Response> listener;
        ExecutionException e = expectThrows(ExecutionException.class, () -> listener.get());
                threadPool,
        assertNull(response.getReasonCancelled());
            if (request instanceof BulkRequest) {
            )
                        i,
        assertBusy(() -> assertNotNull("There should be a search attempt pending that we didn't reject", client.lastSearch.get()));
        capturedCommand.get().run();
        if (previousScrollSet) {
        int maxBatches = randomIntBetween(0, 100);
import org.opensearch.cluster.node.DiscoveryNode;
    public void testCancelWhileDelayedAfterScrollResponse() throws Exception {
import org.opensearch.search.SearchHits;
                return super.schedule(command, delay, name);
                if (searchAttempts.incrementAndGet() <= searchesToReject) {
                            index.id() == null ? "dummy_id" : index.id(),
                // While we're here we can check that the sleep made it through
     * An extension to {@linkplain DummyAsyncBulkByScrollAction} that uses a 0 delaying backoff policy.
        protected DummyAbstractBulkByScrollRequest self() {
        client.lastSearch.get().listener.onResponse(searchResponse);
                    );
                        opType = DocWriteRequest.OpType.DELETE;
                        responses[i] = new BulkItemResponse(i, item.opType(), response);
/*
import org.junit.After;
        });
            0,
        action.onBulkResponse(bulkResponse, Assert::fail);
        }
            IntStream.range(0, 100).mapToObj(i -> hit).toArray(SearchHit[]::new),
     */
        cancelTaskCase(
                int toReject;
        localNode = new DiscoveryNode("thenode", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), 0, emptyList(), null);
                action,
    public void testStartNextScrollRetriesOnRejectionAndSucceeds() throws Exception {
                        throw new RuntimeException("Unknown request:  " + item);
                assertEquals(taskId, request.getParentTask());
    /**
        if (listener.isDone()) {
import org.opensearch.Version;
            assertNull("No refresh was attempted", client.lastRefreshRequest.get());
        client.searchesToReject = testRequest.getMaxRetries() + randomIntBetween(1, 100);
    }
            millis += policy.next().millis();
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), System.nanoTime(), 10, response);
        private final AtomicInteger bulksAttempts = new AtomicInteger();
            this.request = request;
        ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), total, emptyList(), null);
            if (request instanceof RefreshRequest) {
        client.close();
    private DiscoveryNode localNode;
        boolean previousScrollSet = usually();
    public void testShardFailuresAbortRequest() throws Exception {
                        return unit.convert(delay.millis(), TimeUnit.MILLISECONDS);
    }
            client.lastScroll.get().listener.onResponse(searchResponse);
                    }
        assertBusy(() -> assertEquals(client.scrollsToReject + 1, client.scrollAttempts.get()));
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction() {
                        );
            for (int i = 0; i < responses.length; i++) {
        }
    }
        client.threadPool().getThreadContext().putHeader(expectedHeaders);
 */
    @After
        // Fill the context with something random so we can make sure we inherited it appropriately.
    public void testDefaultRetryTimes() {
 *
            client.lastScroll.get().listener.onResponse(searchResponse);
    private PlainActionFuture<BulkByScrollResponse> listener;
            request.add(new IndexRequest("index").id("id" + i));
            }
import java.util.Iterator;
                    DocWriteResponse response;
                            i,
}
                new ParentTaskAssigningClient(client, localNode, testTask),
        simulateScrollResponse(action, System.nanoTime(), 1000, response);
                        DeleteRequest delete = (DeleteRequest) item;
        assertBusy(() -> assertNotNull("There should be a scroll attempt pending that we didn't reject", client.lastScroll.get()));
        private final AtomicInteger scrollAttempts = new AtomicInteger();
    private BackoffPolicy buildTestBackoffPolicy() {
 * this work for additional information regarding copyright
            0
    private SearchRequest firstSearchRequest;
import org.opensearch.tasks.Task;
    public void testBulkResponseSetsLotsOfStatus() throws Exception {
        refreshTestCase(null, true, false);
    public void testRefreshIsFalseByDefault() throws Exception {
                r -> fail(),
     * Mimicks bulk rejections. These should be retried but we fail anyway because we run out of retries.
        assertExactlyOnce(onFail -> {
                return;
 * ownership. Elasticsearch licenses this file to you under
                System.nanoTime(),
                onFail.run();
        }
                    if (i == toReject) {
        private final AtomicInteger searchAttempts = new AtomicInteger();
        }
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
    public void setupForTest() {
                throw new RuntimeException("surprise");
import static java.util.Collections.singleton;
/*
import java.util.concurrent.ExecutionException;
            null,
import static org.hamcrest.Matchers.equalTo;
        assertThat(e.getCause(), hasToString(containsString("test")));
    }
        private final Request request;
        /**
                fail();
            if (request instanceof SearchRequest) {
        });
        @SuppressWarnings("unchecked")
    public void testStartNextScrollRetriesOnRejectionButFailsOnTooManyRejections() throws Exception {
                }
import org.opensearch.action.search.SearchPhaseExecutionException;
        long millis = 0;
    private void setupClient(ThreadPool threadPool) {
        ScrollableHitSource.Response response
                testTask,
        assertEquals(0, capturedDelay.get().seconds());
                    case 1:
         */
import org.opensearch.action.search.SearchRequest;
            (DummyAsyncBulkByScrollAction action) -> simulateScrollResponse(
        long total = randomIntBetween(0, Integer.MAX_VALUE);
 * Unless required by applicable law or agreed to in writing,
            super(in);
                            shardId,
        client = new MyMockClient(new NoOpClient(threadPool));
            new BulkItemResponse[] { new BulkItemResponse(0, DocWriteRequest.OpType.CREATE, failure) },
                    }
        DummyAsyncBulkByScrollAction action = new DummyActionWithoutBackoff();
        DummyTransportAsyncBulkByScrollAction> {
        ScrollableHitSource.Response scrollResponse = new ScrollableHitSource.Response(true, emptyList(), 0, emptyList(), null);
                validingOnFail,
                    private boolean cancelled = false;
                lastScroll.set(new RequestAndListener<>(scroll, (ActionListener<SearchResponse>) listener));
            assertThat(response.getBulkFailures(), hasSize(1));
            // Canceled tasks always start to clear the scroll before they die.
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
        hit.setSource(new BytesArray("{}"), MediaTypeRegistry.JSON);
        });
            // Canceled tasks always start to clear the scroll before they die.
    private static class DummyTransportAsyncBulkByScrollAction extends TransportAction<
            emptyList(),
        });
import org.opensearch.action.DocWriteRequest;
        // Now we can simulate a response and check the delay that we used for the task
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
     */
                assertNotNull(ExceptionsHelper.unwrap(e, OpenSearchRejectedExecutionException.class));
import org.opensearch.action.support.TransportAction;
            internalResponse,
    public void testCancelBeforeOnBulkResponse() throws Exception {
                randomBoolean(),
import org.opensearch.ExceptionsHelper;
            if (request instanceof SearchScrollRequest) {
            // The delay uses the new throttle
                ShardId shardId = new ShardId(new Index("name", "uid"), 0);
                for (int i = 0; i < bulk.requests().size(); i++) {
import org.opensearch.transport.client.Client;
     * scroll request going down.
    }
            };
        for (int batches = 1; batches < maxBatches; batches++) {
    /**
        return scrollId;
            }
    private ThreadPool threadPool;
        action.start();
                lastRefreshRequest.set((RefreshRequest) request);
 * not use this file except in compliance with the License.
 */
        assertBusy(() -> assertEquals(client.searchesToReject + 1, client.searchAttempts.get()));
            protected RequestWrapper<?> buildRequest(Hit doc) {
            testRequest.setRefresh(refresh);
        firstSearchRequest = new SearchRequest();
     * Simulate a scroll response by setting the scroll id and firing the onScrollResponse method.
        assertEquals(capturedDelay.get(), testTask.getStatus().getThrottled());
            5,
        private int bulksToReject = 0;
        assertEquals(testRequest.getMaxRetries(), testTask.getStatus().getSearchRetries());
                }
     * Mimicks a ThreadPool rejecting execution of the task.
        capturedCommand.get().run();
                    }
        DummyAsyncBulkByScrollAction action,
        assertNull(response.getReasonCancelled());
        assertEquals(testRequest.getMaxRetries(), testTask.getStatus().getBulkRetries());
            ExceptionsHelper::reThrowIfNotNull,
        }
        assertNull("No refresh was attempted", client.lastRefreshRequest.get());
        // Use a long delay here so the test will time out if the cancellation doesn't reschedule the throttled task
import org.opensearch.action.bulk.BulkRequest;
        ScrollableHitSource.Response scrollResponse = new ScrollableHitSource.Response(
        AtomicBoolean called = new AtomicBoolean();
            assertExactlyOnce(onSuccess -> new DummyAsyncBulkByScrollAction().onBulkResponse(new BulkResponse(responses, 0), onSuccess));
import org.opensearch.core.action.ActionListener;
            super(
    private TaskManager taskManager;
    public void tearDownAndVerifyCommonStuff() throws Exception {
    }
                return;
    public void testScrollDelay() throws Exception {
                            new Failure(response.getIndex(), response.getId(), new OpenSearchRejectedExecutionException())
        scrollId = null;
                    @Override
    }
                    return;
                client.threadPool(),
            assertEquals(99, capturedDelay.get().seconds());
    private TaskId taskId;
            }
        assertEquals(client.scrollsToReject, testTask.getStatus().getSearchRetries());
import static org.hamcrest.Matchers.greaterThan;
        testRequest = new DummyAbstractBulkByScrollRequest(firstSearchRequest);
import org.opensearch.common.unit.TimeValue;
        SearchHits hits = new SearchHits(
     */
                DocWriteRequest.OpType opType;
                        continue;
import org.opensearch.action.search.ClearScrollRequest;
        }
    public void testCancelBeforeRefreshAndFinish() throws Exception {
                ClearScrollRequest clearScroll = (ClearScrollRequest) request;
    /**
                    versionConflicts++;
            super(actionName, actionFilters, taskManager);
            super(searchRequest, true);
        }
import org.opensearch.action.update.UpdateResponse;
public class AsyncBulkByScrollActionTests extends OpenSearchTestCase {
    public void testBulkRejectionsRetryWithEnoughRetries() throws Exception {
            singletonList(shardFailure),
            }
        ExecutionException e = expectThrows(ExecutionException.class, () -> listener.get());
                    case 0:
        if (refresh != null) {
        worker = testTask.getWorkerState();
                        IndexRequest index = (IndexRequest) item;
                            randomIntBetween(0, Integer.MAX_VALUE),
    }
        }
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.notifyDone(now, null, 0));
                        e = new SearchPhaseExecutionException("test", "test failure", e, new ShardSearchFailure[0]);
            action.addDestinationIndices(singleton("foo"));
        // Force a backoff time of 0 to prevent sleeping
        action.start();
        testRequest.setAbortOnVersionConflict(false);
        int size = randomIntBetween(1, 100);
                 * This is called twice:
                } else {
 * specific language governing permissions and limitations
    private static class RequestAndListener<Request extends ActionRequest, Response> {
     */
                    return;
        DummyAsyncBulkByScrollAction action = new DummyAsyncBulkByScrollAction();
        int totalFailures = randomIntBetween(1, testRequest.getMaxRetries());
    }
        cancelTaskCase((DummyAsyncBulkByScrollAction action) -> action.sendBulkRequest(new BulkRequest(), Assert::fail));
        }
            threadPool,
        action.setScroll(scrollId());
        int lastBatchSize,
    /**
        long versionConflicts = 0;
            action.setScroll(scrollId());
import org.opensearch.action.index.IndexResponse;
        );
            throw new UnsupportedOperationException("Use another override to test this.");
     * The default retry time matches what we say it is in the javadoc for the request.
    }
            scrollId(),
                switch (randomIntBetween(0, 2)) {
        assertThat(response.getBulkFailures(), empty());
                        UpdateRequest update = (UpdateRequest) item;
        }
    public void testBuildRequestThrowsException() throws Exception {
                };
import java.util.concurrent.Delayed;
        }
        if (failWithRejection) {
import static org.hamcrest.Matchers.instanceOf;
     */
            null
import org.junit.Assert;
         */
                capturedDelay.set(delay);
        client.scrollsToReject = testRequest.getMaxRetries() + randomIntBetween(1, 100);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        /**
    private class DummyActionWithoutBackoff extends DummyAsyncBulkByScrollAction {
            BulkByScrollResponse response = listener.get();
 * KIND, either express or implied.  See the License for the
            (DummyAsyncBulkByScrollAction action) -> action.onBulkResponse(new BulkResponse(new BulkItemResponse[0], 0), Assert::fail)
                    @Override
            false,
                        opType = DocWriteRequest.OpType.CREATE;
        @Override
    public void testScrollResponseBatchingBehavior() throws Exception {
        public DummyAbstractBulkByScrollRequest forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices) {
import org.opensearch.core.tasks.TaskId;
            assertThat(response.getSearchFailures(), empty());
        testTask = (BulkByScrollTask) taskManager.register("don'tcare", "hereeither", testRequest);
            return this;
    }
                responses[i] = new BulkItemResponse(i, opType, response);
        boolean previousScrollSet = usually();
    /**
                        e = new OpenSearchException(e);
        private final Set<SearchScrollRequest> usedScolls = synchronizedSet(newSetFromMap(new IdentityHashMap<>()));
    }
    private void refreshTestCase(Boolean refresh, boolean addDestinationIndexes, boolean shouldRefresh) {
    /**
        }
                 * Both times we use delegate to the standard behavior so the task is scheduled as expected so it can be cancelled and all
     * Execute a bulk retry test case. The total number of failures is random and the number of retries attempted is set to
import org.opensearch.core.index.shard.ShardId;
                return new ScheduledCancellable() {
                            randomInt(20),
        long lastBatchTime,
        client.bulksToReject = client.bulksAttempts.get() + totalFailures;
 * this file be licensed under the Apache-2.0 license or a
                listener.onFailure(
            r -> fail(),
    /**
                            shardId,
                    generic().execute(() -> taskManager.cancel(testTask, reason, () -> {}));
     * Mimicks script failures or general wrongness by implementers.
                AsyncBulkByScrollActionTests.this.logger,
        simulateScrollResponse(new DummyAsyncBulkByScrollAction(), System.nanoTime(), 0, scrollResponse);
        hitSource.setScroll(scrollId());
        if (client != null) {
        SearchHit hit = new SearchHit(0, "id", emptyMap(), emptyMap()).sourceRef(new BytesArray("{}"));
                            true
import static org.hamcrest.Matchers.hasSize;
        assertEquals(total, testTask.getStatus().getTotal());
import org.apache.lucene.search.TotalHits;
                            shardId,
    private class MyMockClient extends FilterClient {
 *
            assertThat(client.scrollsCleared, contains(scrollId));
                    responses[i] = new BulkItemResponse(
                    public int compareTo(Delayed o) {
        long total = randomIntBetween(0, Integer.MAX_VALUE);
        cancelTaskCase(
     * Tests that each scroll response is a batch and that the batch is launched properly.
        // Default is 0, meaning unstarted
        // When the task is rejected we don't increment the throttled timer
import org.opensearch.action.bulk.BulkItemResponse;
        taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
                    ShardId shardId = new ShardId(new Index(item.index(), "uuid"), 0);
import org.opensearch.action.update.UpdateRequest;
        DummyAbstractBulkByScrollRequest(SearchRequest searchRequest) {
                    }
        DummyAsyncBulkByScrollAction() {
                        throw new RuntimeException("Bad scenario");
                        new Failure(shardId.getIndexName(), "id" + i, new VersionConflictEngineException(shardId, "id", "test"))
         * Set of all scrolls we've already used. Used to check that we don't reuse the same request twice.
            ScrollableHitSource.Response response = new ScrollableHitSource.Response(false, emptyList(), 1, singletonList(hit), null);
import java.util.concurrent.TimeUnit;
        BulkByScrollResponse response = listener.get();
    private void simulateScrollResponse(
                            randomNonNegativeLong(),
                final IndexResponse response = new IndexResponse(shardId, "id" + i, seqNo, primaryTerm, randomInt(), createdResponse);
    }
import static org.hamcrest.Matchers.hasToString;
    public void testCancelBeforeInitialSearch() throws Exception {
import org.opensearch.action.search.ClearScrollResponse;
import static java.util.Collections.synchronizedSet;
            logger,
        assertThat(e.getCause(), instanceOf(RuntimeException.class));
                listener.onResponse(null);
        assertThat(client.scrollsCleared, contains(scrollId));
        }
        // this test primarily tests ClientScrollableHitSource but left it to test integration to status
        ClientScrollableHitSource hitSource = new ClientScrollableHitSource(
                            randomIntBetween(0, Integer.MAX_VALUE),
            ActionType<Response> action,
        BulkByScrollResponse response = listener.get();
            testTask.getWorkerState()::countSearchRetry,
            assertExactlyOnce(onSuccess -> action.sendBulkRequest(request, onSuccess));
         * delay for throttling.
 * SPDX-License-Identifier: Apache-2.0
                            randomIntBetween(0, Integer.MAX_VALUE),
