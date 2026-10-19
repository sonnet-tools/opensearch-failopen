                        if (randomBoolean()) {  
 *  
            }  
        final String transientKey = randomAlphaOfLengthBetween(1, 8);
        int iterations = 0;  
                        + successCount.get()  
            } catch (InterruptedException e) {
 * SPDX-License-Identifier: Apache-2.0
                exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));
            null,
        assertNull(threadPool.getThreadContext().getHeader(headerKey));  
        try (  
            }
import org.apache.logging.log4j.LogManager;
                }
                        + "Requested Bulks: "
                            bulkProcessor.add(indexRequest);
                new ByteBuffer[] { ByteBuffer.wrap(bulkRequest.getBytes(StandardCharsets.UTF_8)) }
        AtomicInteger docCount = new AtomicInteger(0);
            latch.countDown();  
            }
        int concurrentClients = 0;
        terminate(threadPool);
        final TimeValue flushInterval = TimeValue.timeValueSeconds(1L);
            (command, delay, executor) -> null,  
    private ThreadPool threadPool;  
        final int maxDocuments = 100_000;
                        } else {
                            bulkProcessor.add(indexRequest);
            executorService.awaitTermination(10, TimeUnit.SECONDS);
                emptyListener(),
    ) {
            threadPool.getThreadContext().putHeader(headerKey, headerValue);  
            maxDocuments = randomIntBetween(maxBatchSize, 1_000_000);  
                    + "Total Documents: "  
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
            ExecutorService executorService = Executors.newFixedThreadPool(concurrentClients);  
    }
                        + "\n"
        final Object transientValue = new Object();  
        bulkProcessor.add(new IndexRequest());
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
import org.opensearch.threadpool.TestThreadPool;
                    + "\n"
import org.opensearch.core.common.unit.ByteSizeValue;
            public void beforeBulk(long executionId, BulkRequest request) {  
                    }
 * ownership. Elasticsearch licenses this file to you under  
            }
            maxBatchSize = randomIntBetween(1, 100);
                        + concurrentClients  
        // find some randoms that allow this test to take under ~ 10 seconds
                            flushExecutor.shutdownNow();
import java.util.concurrent.ExecutorService;  
                null,
import java.util.concurrent.Executors;
            }  
            }  
            BulkProcessor bulkProcessor = new BulkProcessor(
            )  
 *
                listener.onResponse(bulkResponse);  
            fail(
                    + "\n"
                concurrentBulkRequests + 1,
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {  
                runTest = false;
                    exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));  
                    }
                Thread.sleep(simulateWorkTimeInMillis); // simulate work
                        + failureCount.get()  
                new ByteBuffer[] { ByteBuffer.wrap(bulkRequest.getBytes(StandardCharsets.UTF_8)) }
import org.junit.Before;
                concurrentBulkRequests,
import java.util.function.BiConsumer;
    @Before  
            concurrentClients = randomIntBetween(1, 20);
                        throw ExceptionsHelper.convertToRuntime(e);  
                exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));
            }  
                        startGate.await();
        }
import java.util.concurrent.ScheduledExecutorService;  
                (command, delay, executor) -> Scheduler.wrapAsScheduledCancellable(  
import java.util.concurrent.atomic.AtomicInteger;  
            List<Future> futures = new ArrayList<>();
                        startGate.countDown();  
                flushInterval,  
                    failureCount.incrementAndGet();
 * the Apache License, Version 2.0 (the "License"); you may
                        Thread.currentThread().interrupt();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        AtomicInteger failureCount,
                } catch (Exception e) {
                TimeValue.timeValueMillis(simulateWorkTimeInMillis * 2),
                countingListener(requestCount, successCount, failureCount, docCount, exceptionRef),
    }
        BulkResponse bulkResponse = new BulkResponse(new BulkItemResponse[] { new BulkItemResponse() }, 0);
                    + concurrentClients
                try {
import java.util.concurrent.atomic.AtomicReference;
 *
import org.opensearch.ExceptionsHelper;  
                        // don't start any work until all tasks are submitted
            @Override  
                        + "\n"
        ) {  
        };
                consumer,
                    try {
import java.util.concurrent.TimeUnit;
                ),
        };
                fail(
        final AtomicBoolean called = new AtomicBoolean(false);  
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {
        AtomicInteger successCount = new AtomicInteger(0);  
        int maxDocuments = 0;
            if (exceptionRef.get() != null) {
        while (estimatedTimeForTest > 10_000) {  
                    + "\n"
import org.opensearch.threadpool.Scheduler;
        boolean runTest = true;
                    } catch (InterruptedException ie) {
        };  
        AtomicInteger successCount,
import java.util.List;
        assertNull(threadPool.getThreadContext().getTransient(transientKey));
                consumer,  
            );
            } catch (InterruptedException e) {
/*  
                listener.onResponse(bulkResponse);  
            BulkProcessor bulkProcessor = new BulkProcessor(  
            if (failureCount.get() > 0 || successCount.get() != expectedExecutions || requestCount.get() != successCount.get()) {  
                        if (flushExecutor.isTerminated() == false) {
            BytesReference bytesReference = BytesReference.fromByteBuffers(
            () -> called.set(true),
                () -> {  
                } catch (Exception e) {
        final AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
                    + maxBatchSize
                requestCount.incrementAndGet();
                        } else {
import org.opensearch.core.common.bytes.BytesReference;
        }
 * software distributed under the License is distributed on an
import java.nio.charset.StandardCharsets;
            CountDownLatch startGate = new CountDownLatch(1 + concurrentClients);
                }));
        int estimatedTimeForTest = Integer.MAX_VALUE;
 */  
    public void startThreadPool() {
                new ByteSizeValue(Integer.MAX_VALUE),
    @After
            new ByteSizeValue(1000),
                concurrentClients  
                        + maxBatchSize  
        final AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
                    + maxDocuments
                () -> called.set(true),  
            assertEquals(headerValue, threadContext.getHeader(headerKey));
        assertTrue(called.get());
        latch.await();
            IndexRequest indexRequest = new IndexRequest();
import java.util.ArrayList;  
            assertSame(transientValue, threadContext.getTransient(transientKey));
 * Modifications Copyright OpenSearch Contributors. See
                        + "\n"
import org.junit.After;
                BulkRequest::new
        int concurrentBulkRequests = 0;
            @Override  
import org.apache.logging.log4j.Logger;
                if (failure != null) {  
                    + "\n"
/*
 * this file be licensed under the Apache-2.0 license or a
        assertNull(threadPool.getThreadContext().getTransient(transientKey));
        };
            startGate.countDown();
        return new BulkProcessor.Listener() {
                    + "\n"
        final int concurrentBulkRequests = randomIntBetween(0, 20);
            for (Future f : futures) {
 * compatible open source license.
        ScheduledExecutorService flushExecutor = Executors.newScheduledThreadPool(1);
            startGate.countDown();
    }  
                BackoffPolicy.noBackoff(),
                docCount.addAndGet(request.requests().size());
        // count total docs after processor is closed since there may have been partial batches that are flushed on close.
import org.opensearch.core.xcontent.MediaTypeRegistry;
                break;  
        AtomicInteger failureCount = new AtomicInteger(0);
                );
            }  
        final CountDownLatch latch = new CountDownLatch(1);
    public void testConcurrentExecutions() throws Exception {
        AtomicReference<Throwable> exceptionRef
                futures.add(executorService.submit(() -> {  
                logger.error("exception(s) caught during test", exceptionRef.get());  
                successCount.incrementAndGet();  
            for (final AtomicInteger i = new AtomicInteger(0); i.getAndIncrement() < maxDocuments;) {
        final int simulateWorkTimeInMillis = 5;  
            CountDownLatch startGate = new CountDownLatch(1 + concurrentClients);  
 * GitHub history for details.
}
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {  
            List<Future> futures = new ArrayList<>();  
            consumer,
        int maxBatchSize = 0;
            10,  
        threadPool = new TestThreadPool("BulkProcessorTests");
                    "\nExpected Bulks: "
    }
 * license agreements. See the NOTICE file distributed with
                        + "\n"
        int expectedExecutions = 0;  
        // add a single item which won't be over the size or number of items  
        }
import java.util.concurrent.Future;
        final int concurrentClients = 2;  
            emptyListener(),
        }
                    + "Failed Bulks: "  
                            bulkProcessor.add(bytesReference, null, null, MediaTypeRegistry.JSON);  
                        + expectedExecutions  
                    exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), e));  
                // should never happen
        assertFalse(called.get());
        AtomicInteger requestCount,  
                    + "Max Batch Size: "  
        AtomicInteger docCount,  
            if (iterations++ > 1_000) { // extremely unlikely
                        if (randomBoolean()) {  
            String bulkRequest = "{ \"index\" : { \"_index\" : \"test\", \"_id\" : \"1\" } }\n" + "{ \"field1\" : \"value1\" }\n";
import org.opensearch.core.common.unit.ByteSizeUnit;  
            concurrentBulkRequests = randomIntBetween(0, 20);
                try {
            IndexRequest indexRequest = new IndexRequest();
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().stashContext()) {
            for (final AtomicInteger i = new AtomicInteger(0); i.getAndIncrement() < maxDocuments;) {
        AtomicInteger successCount = new AtomicInteger(0);  
public class BulkProcessorTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    }  
                        + "\n"
    public void testConcurrentExecutionsWithFlush() throws Exception {  
                Thread.currentThread().interrupt();  
            BytesReference bytesReference = BytesReference.fromByteBuffers(  
                        }
            executorService.awaitTermination(10, TimeUnit.SECONDS);
import org.opensearch.common.util.concurrent.ThreadContext;  
    }  
            0,
 * Unless required by applicable law or agreed to in writing,
                    flushExecutor.shutdown();
            BulkRequest::new
                        // don't start any work until all tasks are submitted
            );
            ExecutorService executorService = Executors.newFixedThreadPool(concurrentClients);
    public void stopThreadPool() throws InterruptedException {  
                        + "\n"
            startGate.await();
    public void testAwaitOnCloseCallsOnClose() throws Exception {
                BackoffPolicy.noBackoff(),
import java.util.concurrent.atomic.AtomicBoolean;
                futures.add(executorService.submit(() -> {  
 * Licensed to Elasticsearch under one or more contributor  
            )
                Thread.currentThread().interrupt();  
            executorService.shutdown();  
        // wait for flush to execute  
        AtomicInteger failureCount = new AtomicInteger(0);
    }
            }
                Thread.sleep(simulateWorkTimeInMillis); // simulate work
            );  
            threadPool.getThreadContext().putTransient(transientKey, transientValue);
 * under the License.  
                        + "Successful Bulks: "
    private final Logger logger = LogManager.getLogger(BulkProcessorTests.class);
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {}
                new ByteSizeValue(5, ByteSizeUnit.MB),
            @Override  
                bulkSize,
            @Override
    public void testBulkProcessorFlushPreservesContext() throws InterruptedException {
                        + "Max Documents: "
                        startGate.await();
    }
            @Override
        final String headerKey = randomAlphaOfLengthBetween(1, 8);  
        assumeTrue("failed to find random values that allows test to run quickly", runTest);  
                        // alternate between ways to add to the bulk processor
                1,  
                    + "Successful Bulks: "  
import java.util.concurrent.CountDownLatch;
            );
            expectedExecutions = maxDocuments / maxBatchSize;  
        if (failureCount.get() > 0 || requestCount.get() != successCount.get() || maxDocuments != docCount.get()) {
                        startGate.countDown();  
                        + "Max Batch Size: "
                    + "Concurrent Bulk Requests: "  
        assertNull(threadPool.getThreadContext().getHeader(headerKey));  
                (command, delay, executor) -> null,
            );  
        assertNull(threadPool.getThreadContext().getTransient(transientKey));
                    + docCount.get()
                        + "Concurrent Clients: "
            executorService.shutdown();  
 * this work for additional information regarding copyright
import org.opensearch.action.index.IndexRequest;
                    } catch (Exception e) {
            try {
        BulkResponse bulkResponse = new BulkResponse(new BulkItemResponse[] { new BulkItemResponse() }, 0);
                        flushExecutor.awaitTermination(10L, TimeUnit.SECONDS);  
        return new BulkProcessor.Listener() {
                failureCount.getAndIncrement();
        bulkProcessor.awaitClose(100, TimeUnit.MILLISECONDS);  
                        + requestCount.get()  
                    + concurrentBulkRequests
import org.opensearch.core.action.ActionListener;
                        + "\n"
    private BulkProcessor.Listener countingListener(
                    logger.error("exception(s) caught during test", exceptionRef.get());
import java.nio.ByteBuffer;
                new ByteSizeValue(Integer.MAX_VALUE),  
                // should never happen
 * The OpenSearch Contributors require contributions made to  
        ) {
                        }  
                    failureCount.incrementAndGet();
                    + successCount.get()
                if (exceptionRef.get() != null) {
            }
            public void beforeBulk(long executionId, BulkRequest request) {}
                    try {
            try {
            bulkProcessor = new BulkProcessor(
            BackoffPolicy.noBackoff(),  
                    + "\n"
                            bulkProcessor.add(bytesReference, null, null, MediaTypeRegistry.JSON);  
                consumer,
            for (Future f : futures) {
        bulkProcessor.close();
                    }  
                maxBatchSize,
        final int maxBatchSize = Integer.MAX_VALUE; // don't flush based on size
 * specific language governing permissions and limitations
                    + "Concurrent Clients: "  
import org.opensearch.threadpool.ThreadPool;  
                        // alternate between ways to add to the bulk processor
        final AtomicBoolean called = new AtomicBoolean(false);
                    } catch (Exception e) {
 */  
                    failureCount.incrementAndGet();
                    exceptionRef.set(ExceptionsHelper.useOrSuppress(exceptionRef.get(), failure));
        };
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {}
 */
                    + "\n"
            }
                    + "Max Documents: "  
                () -> {},
        assertEquals(docCount.get(), maxDocuments);  
            @Override
                maxBatchSize,  
        try (
                    f.get();  
        BulkProcessor bulkProcessor = new BulkProcessor(
                "\nRequested Bulks: "  
                threadPool,
                    f.get();  
                    + "\n"
        final String headerValue = randomAlphaOfLengthBetween(1, 32);
package org.opensearch.action.bulk;
        AtomicInteger requestCount = new AtomicInteger(0);
            String bulkRequest = "{ \"index\" : { \"_index\" : \"test\", \"_id\" : \"1\" } }\n" + "{ \"field1\" : \"value1\" }\n";  
                    try {
 * You may obtain a copy of the License at  
                        throw ExceptionsHelper.convertToRuntime(e);  
                    flushExecutor.schedule(command, delay.millis(), TimeUnit.MILLISECONDS)
/*  
        final BulkProcessor bulkProcessor;
                        + "\n"
                countingListener(requestCount, successCount, failureCount, docCount, exceptionRef),  
        AtomicInteger docCount = new AtomicInteger(0);
                }));
    private BulkProcessor.Listener emptyListener() {
            }
                }  
                BulkRequest::new
        }
            startGate.await();
                    + failureCount.get()
                failureCount.getAndIncrement();
                        + "Concurrent Bulk Requests: "
                        + maxDocuments  
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer = (request, listener) -> {};  
                    + requestCount.get()
            estimatedTimeForTest = (expectedExecutions * simulateWorkTimeInMillis) / Math.min(
import org.opensearch.test.OpenSearchTestCase;  
                },
                BackoffPolicy.noBackoff(),  
        );  
                        }
 * not use this file except in compliance with the License.
                        + "Failed Bulks: "
        final int simulateWorkTimeInMillis = 5;  
                }
        assertNull(threadPool.getThreadContext().getHeader(headerKey));  
                BulkRequest::new  
            ThreadContext threadContext = threadPool.getThreadContext();  
        final int bulkSize = randomIntBetween(2, 32);  
import org.opensearch.common.unit.TimeValue;
        AtomicInteger requestCount = new AtomicInteger(0);
                        + concurrentBulkRequests  
                concurrentBulkRequests,
