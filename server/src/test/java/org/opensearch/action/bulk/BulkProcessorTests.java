        };
                    + concurrentClients
        };
                    failureCount.incrementAndGet();
            @Override
                    flushExecutor.schedule(command, delay.millis(), TimeUnit.MILLISECONDS)
                            bulkProcessor.add(bytesReference, null, null, MediaTypeRegistry.JSON);
                null,
                    + "\n"
            }
 * Modifications Copyright OpenSearch Contributors. See
                        + "\n"
 */
/*
                    + maxBatchSize
            () -> called.set(true),
                        + "\n"
        bulkProcessor.close();
import java.util.concurrent.Future;
            String bulkRequest = "{ \"index\" : { \"_index\" : \"test\", \"_id\" : \"1\" } }\n" + "{ \"field1\" : \"value1\" }\n";
            BulkProcessor bulkProcessor = new BulkProcessor(
import org.opensearch.common.unit.TimeValue;
                docCount.addAndGet(request.requests().size());
        try (
                        + "Successful Bulks: "
                consumer,
        final AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
        while (estimatedTimeForTest > 10_000) {
                        if (flushExecutor.isTerminated() == false) {
                flushInterval,
        int concurrentClients = 0;
        AtomicInteger failureCount = new AtomicInteger(0);
import java.util.List;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        final TimeValue flushInterval = TimeValue.timeValueSeconds(1L);
                threadPool,
                new ByteBuffer[] { ByteBuffer.wrap(bulkRequest.getBytes(StandardCharsets.UTF_8)) }
        final AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
                new ByteSizeValue(Integer.MAX_VALUE),
                () -> called.set(true),
                        + failureCount.get()
                        + "Failed Bulks: "
        assertNull(threadPool.getThreadContext().getTransient(transientKey));
            (command, delay, executor) -> null,
        // count total docs after processor is closed since there may have been partial batches that are flushed on close.
                (command, delay, executor) -> Scheduler.wrapAsScheduledCancellable(
    }
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
        // add a single item which won't be over the size or number of items
                    }
    public void testBulkProcessorFlushPreservesContext() throws InterruptedException {
                        + maxDocuments
                BulkRequest::new
                BulkRequest::new
                        + "\n"
                        }
            @Override
            new ByteSizeValue(1000),
            fail(
import java.util.concurrent.TimeUnit;
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().stashContext()) {
                // should never happen
                    f.get();
                        Thread.currentThread().interrupt();
                        + "Concurrent Bulk Requests: "
    public void stopThreadPool() throws InterruptedException {
                        // alternate between ways to add to the bulk processor
                        + "\n"
        AtomicInteger requestCount = new AtomicInteger(0);
                    + successCount.get()
                BulkRequest::new
            CountDownLatch startGate = new CountDownLatch(1 + concurrentClients);
                        startGate.await();
                bulkSize,
import org.opensearch.core.action.ActionListener;
            estimatedTimeForTest = (expectedExecutions * simulateWorkTimeInMillis) / Math.min(
            10,
    private BulkProcessor.Listener emptyListener() {
                    + "Concurrent Bulk Requests: "
 */
                (command, delay, executor) -> null,
            List<Future> futures = new ArrayList<>();
            if (failureCount.get() > 0 || successCount.get() != expectedExecutions || requestCount.get() != successCount.get()) {
 */
            @Override
        AtomicInteger requestCount,
            }
            BulkRequest::new
        ) {
    }
        assertEquals(docCount.get(), maxDocuments);
        final String transientKey = randomAlphaOfLengthBetween(1, 8);
        if (failureCount.get() > 0 || requestCount.get() != successCount.get() || maxDocuments != docCount.get()) {
        final AtomicBoolean called = new AtomicBoolean(false);
                failureCount.getAndIncrement();
            List<Future> futures = new ArrayList<>();
        };
                    + "Failed Bulks: "
        ) {
                    try {
import java.util.concurrent.ScheduledExecutorService;
                        + requestCount.get()
                },
        assertNull(threadPool.getThreadContext().getTransient(transientKey));
                    logger.error("exception(s) caught during test", exceptionRef.get());
                Thread.sleep(simulateWorkTimeInMillis); // simulate work
 *
            )
            }
    }
        bulkProcessor.awaitClose(100, TimeUnit.MILLISECONDS);
                exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));
        assertNull(threadPool.getThreadContext().getHeader(headerKey));
                Thread.currentThread().interrupt();
                        } else {
import java.util.concurrent.atomic.AtomicReference;
                    f.get();
    }
            }
            BackoffPolicy.noBackoff(),
            ThreadContext threadContext = threadPool.getThreadContext();
import java.util.concurrent.atomic.AtomicBoolean;
                    } catch (Exception e) {
                listener.onResponse(bulkResponse);
                    failureCount.incrementAndGet();
        int maxDocuments = 0;
                }));
        // wait for flush to execute
    }
                        + "Max Batch Size: "
import org.opensearch.action.index.IndexRequest;
                        + "\n"
                        + "\n"
                exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));
                    } catch (InterruptedException ie) {
                concurrentClients
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.ArrayList;
            assertSame(transientValue, threadContext.getTransient(transientKey));
                fail(
            }
                } catch (Exception e) {
                try {
                if (exceptionRef.get() != null) {
            IndexRequest indexRequest = new IndexRequest();
                    + "\n"
        threadPool = new TestThreadPool("BulkProcessorTests");
        int iterations = 0;
                    + "\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
        final String headerValue = randomAlphaOfLengthBetween(1, 32);
            }
    public void testConcurrentExecutionsWithFlush() throws Exception {
                    + "Total Documents: "
        final AtomicBoolean called = new AtomicBoolean(false);
            }
        AtomicReference<Throwable> exceptionRef
            emptyListener(),
    public void testAwaitOnCloseCallsOnClose() throws Exception {
                maxBatchSize,
                    + concurrentBulkRequests
                "\nRequested Bulks: "
                        startGate.await();
                    + "\n"
            }
                    + "Concurrent Clients: "
        assertFalse(called.get());
import org.apache.logging.log4j.Logger;
        final int maxDocuments = 100_000;
                BackoffPolicy.noBackoff(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            startGate.await();
import org.opensearch.core.common.unit.ByteSizeValue;
        final BulkProcessor bulkProcessor;
        final int simulateWorkTimeInMillis = 5;
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.common.util.concurrent.ThreadContext;
                countingListener(requestCount, successCount, failureCount, docCount, exceptionRef),
                        }
import java.util.concurrent.CountDownLatch;
        int estimatedTimeForTest = Integer.MAX_VALUE;
                ),
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            @Override
public class BulkProcessorTests extends OpenSearchTestCase {
            );
import java.nio.ByteBuffer;
                    }
 * specific language governing permissions and limitations
            for (final AtomicInteger i = new AtomicInteger(0); i.getAndIncrement() < maxDocuments;) {
import org.opensearch.threadpool.ThreadPool;
            maxDocuments = randomIntBetween(maxBatchSize, 1_000_000);
            }
                TimeValue.timeValueMillis(simulateWorkTimeInMillis * 2),
                        throw ExceptionsHelper.convertToRuntime(e);
        }
import java.util.concurrent.atomic.AtomicInteger;
 * The OpenSearch Contributors require contributions made to
                        + expectedExecutions
                futures.add(executorService.submit(() -> {
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {
                // should never happen
                BackoffPolicy.noBackoff(),
                Thread.sleep(simulateWorkTimeInMillis); // simulate work
                if (failure != null) {
        return new BulkProcessor.Listener() {
                failureCount.getAndIncrement();
                    + "Max Documents: "
 * GitHub history for details.
        int maxBatchSize = 0;
        return new BulkProcessor.Listener() {
                requestCount.incrementAndGet();
import org.junit.After;
 *
                    "\nExpected Bulks: "
                logger.error("exception(s) caught during test", exceptionRef.get());
        final Object transientValue = new Object();
        );
/*
                        // alternate between ways to add to the bulk processor
        assertNull(threadPool.getThreadContext().getHeader(headerKey));
        BulkResponse bulkResponse = new BulkResponse(new BulkItemResponse[] { new BulkItemResponse() }, 0);
            } catch (InterruptedException e) {
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.TestThreadPool;
            for (final AtomicInteger i = new AtomicInteger(0); i.getAndIncrement() < maxDocuments;) {
import java.util.concurrent.Executors;
        // find some randoms that allow this test to take under ~ 10 seconds
        assertNull(threadPool.getThreadContext().getTransient(transientKey));
                () -> {
        bulkProcessor.add(new IndexRequest());
import org.opensearch.core.common.unit.ByteSizeUnit;
                consumer,
                        flushExecutor.awaitTermination(10L, TimeUnit.SECONDS);
                try {
        assumeTrue("failed to find random values that allows test to run quickly", runTest);
            BytesReference bytesReference = BytesReference.fromByteBuffers(
            try {
        }
        AtomicInteger successCount,
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
                    + requestCount.get()
                countingListener(requestCount, successCount, failureCount, docCount, exceptionRef),
            ExecutorService executorService = Executors.newFixedThreadPool(concurrentClients);
        int expectedExecutions = 0;
                        if (randomBoolean()) {
/*
 * SPDX-License-Identifier: Apache-2.0
        terminate(threadPool);
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {}
import org.opensearch.ExceptionsHelper;
                    + "\n"
 * this file be licensed under the Apache-2.0 license or a
        AtomicInteger failureCount = new AtomicInteger(0);
            startGate.countDown();
                        + "\n"
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.threadpool.Scheduler;
    private ThreadPool threadPool;
        AtomicInteger docCount = new AtomicInteger(0);
        }
        final int simulateWorkTimeInMillis = 5;
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {
                concurrentBulkRequests,
        ScheduledExecutorService flushExecutor = Executors.newScheduledThreadPool(1);
            executorService.awaitTermination(10, TimeUnit.SECONDS);
import org.apache.logging.log4j.LogManager;
            bulkProcessor = new BulkProcessor(
        int concurrentBulkRequests = 0;
                        + "\n"
                        + concurrentBulkRequests
            concurrentBulkRequests = randomIntBetween(0, 20);
                concurrentBulkRequests,
                        // don't start any work until all tasks are submitted
import org.junit.Before;
        final int maxBatchSize = Integer.MAX_VALUE; // don't flush based on size
                        + concurrentClients
            }
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {}
                break;
                        + "Requested Bulks: "
            latch.countDown();
    public void testConcurrentExecutions() throws Exception {
            executorService.shutdown();
        assertTrue(called.get());
                }));
        latch.await();
            );
            }
 *
                        throw ExceptionsHelper.convertToRuntime(e);
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                );
                consumer,
        final int concurrentClients = 2;
    public void startThreadPool() {
            if (exceptionRef.get() != null) {
            try {
        AtomicInteger successCount = new AtomicInteger(0);
    private final Logger logger = LogManager.getLogger(BulkProcessorTests.class);
                    exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), failure));
                            flushExecutor.shutdownNow();
    }
                concurrentBulkRequests + 1,
import java.util.concurrent.ExecutorService;
        AtomicInteger docCount,
                    flushExecutor.shutdown();
                        + maxBatchSize
                            bulkProcessor.add(bytesReference, null, null, MediaTypeRegistry.JSON);
                futures.add(executorService.submit(() -> {
        AtomicInteger failureCount,
                }
                new ByteSizeValue(Integer.MAX_VALUE),
                    + failureCount.get()
            ExecutorService executorService = Executors.newFixedThreadPool(concurrentClients);
                emptyListener(),
                    try {
                    + docCount.get()
                successCount.incrementAndGet();
        };
            }
                    + "\n"
                    exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));
            );
            threadPool.getThreadContext().putTransient(transientKey, transientValue);
                        + "Concurrent Clients: "
                        }
                    + "Successful Bulks: "
            startGate.countDown();
                    + "\n"
        BulkProcessor bulkProcessor = new BulkProcessor(
            )
}
            public void beforeBulk(long executionId, BulkRequest request) {}
        AtomicInteger successCount = new AtomicInteger(0);
                            bulkProcessor.add(indexRequest);
import org.opensearch.core.common.bytes.BytesReference;
                        } else {
import java.util.function.BiConsumer;
            expectedExecutions = maxDocuments / maxBatchSize;
    ) {
            maxBatchSize = randomIntBetween(1, 100);
                            bulkProcessor.add(indexRequest);
import java.nio.charset.StandardCharsets;
            concurrentClients = randomIntBetween(1, 20);
            String bulkRequest = "{ \"index\" : { \"_index\" : \"test\", \"_id\" : \"1\" } }\n" + "{ \"field1\" : \"value1\" }\n";
import org.opensearch.test.OpenSearchTestCase;
                    + maxDocuments
                    try {
            for (Future f : futures) {
    @Before
        }
                maxBatchSize,
        boolean runTest = true;
                        + successCount.get()
            0,
                    + "Max Batch Size: "
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {
            );
        };
            @Override
                    }
                        if (randomBoolean()) {
                }
                listener.onResponse(bulkResponse);
    private BulkProcessor.Listener countingListener(
 * Licensed to Elasticsearch under one or more contributor
            executorService.shutdown();
                runTest = false;
        AtomicInteger requestCount = new AtomicInteger(0);
                    exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {};
 * You may obtain a copy of the License at
                }
                        startGate.countDown();
            for (Future f : futures) {
        BulkResponse bulkResponse = new BulkResponse(new BulkItemResponse[] { new BulkItemResponse() }, 0);
    }
            consumer,
 * this work for additional information regarding copyright
        }
                    } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        AtomicInteger docCount = new AtomicInteger(0);
 * under the License.
            assertEquals(headerValue, threadContext.getHeader(headerKey));
                        + "Max Documents: "
        final int bulkSize = randomIntBetween(2, 32);
        final int concurrentBulkRequests = randomIntBetween(0, 20);
    }
package org.opensearch.action.bulk;
            );
            startGate.await();
            null,
            BytesReference bytesReference = BytesReference.fromByteBuffers(
                    + "\n"
            BulkProcessor bulkProcessor = new BulkProcessor(
                () -> {},
                new ByteBuffer[] { ByteBuffer.wrap(bulkRequest.getBytes(StandardCharsets.UTF_8)) }
                        startGate.countDown();
                    failureCount.incrementAndGet();
                new ByteSizeValue(5, ByteSizeUnit.MB),
 * compatible open source license.
                BackoffPolicy.noBackoff(),
        assertNull(threadPool.getThreadContext().getHeader(headerKey));
        try (
            IndexRequest indexRequest = new IndexRequest();
            @Override
                } catch (Exception e) {
            public void beforeBulk(long executionId, BulkRequest request) {
                1,
                        // don't start any work until all tasks are submitted
        final String headerKey = randomAlphaOfLengthBetween(1, 8);
            threadPool.getThreadContext().putHeader(headerKey, headerValue);
                }
            CountDownLatch startGate = new CountDownLatch(1 + concurrentClients);
    @After
            if (iterations++ > 1_000) { // extremely unlikely
 * not use this file except in compliance with the License.
