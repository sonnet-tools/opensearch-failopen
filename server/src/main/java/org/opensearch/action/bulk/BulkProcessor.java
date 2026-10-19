         * can be set to {@code -1} with the flush interval set allowing for complete async processing of bulk actions.  
        );  
    }  
    private void execute() {
import org.opensearch.core.common.bytes.BytesReference;
     */
        }  
            return this;
     */
                Scheduler.terminate(flushScheduledThreadPoolExecutor, 10, TimeUnit.SECONDS);  
import org.opensearch.threadpool.Scheduler;
            ensureOpen();  
    /**  
        Runnable onClose,  
        return scheduler.scheduleWithFixedDelay(new Flush(), flushInterval, ThreadPool.Names.GENERIC);  
        private String globalIndex;
 * Modifications Copyright OpenSearch Contributors. See
        public Builder setFlushInterval(TimeValue flushInterval) {
        }  
            return new Scheduler.Cancellable() {  
         * <p>
                onClose,
 * this work for additional information regarding copyright
                    return;
    /**  
                    return true;
        public void run() {
         * Sets when to flush a new bulk request based on the size of actions currently added. Defaults to  
            } finally {
        ) {
import org.opensearch.transport.client.Client;
                if (bulkRequest.numberOfActions() == 0) {
            this.bulkSize = bulkSize;
        private String globalPipeline;  
        return new Tuple<>(bulkRequest, executionIdGen.incrementAndGet());
     * @return {@code true} if all bulk requests completed and {@code false} if the waiting time elapsed before all the bulk requests  
        public BulkProcessor build() {
        public Builder setGlobalRouting(String globalRouting) {  
import org.opensearch.action.DocWriteRequest;
                return true;
/*  
     * @return the builder for BulkProcessor
import org.opensearch.core.xcontent.MediaType;
    public static class Builder {
                Scheduler.terminate(retryScheduledThreadPoolExecutor, 10, TimeUnit.SECONDS);
        private int bulkActions = 1000;  
     * Adds the data from the bytes to be processed by the bulk processor
            }
        @Nullable TimeValue flushInterval,
            BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,  
         * Note, both {@link #setBulkActions(int)} and {@link #setBulkSize(ByteSizeValue)}
        return this;
        /**  
         * Sets a flush interval flushing *any* bulk actions pending if the interval passes. Defaults to not set.  
        public Builder setConcurrentRequests(int concurrentRequests) {  
                @Override
        private int concurrentRequests = 1;
        public Builder setGlobalPipeline(String globalPipeline) {
            this.concurrentRequests = concurrentRequests;
            );  
                onClose.run();
    /**  
     */
            return true;
        if (closed) {
            return this;
        }
     */  
import java.util.concurrent.ScheduledThreadPoolExecutor;
        /**
        Objects.requireNonNull(client, "client");
         * request will be allowed to be executed. A value of 1 means 1 concurrent request is allowed to be executed  
    }  
    // may be executed without a lock
 * the Apache License, Version 2.0 (the "License"); you may
        try {  
 * Licensed to Elasticsearch under one or more contributor  
    BulkProcessor(  
 * @opensearch.internal
    }
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
     * @param retryScheduler The scheduler that is used for retries  
            return this;
        this.bulkRequestHandler = new BulkRequestHandler(consumer, backoffPolicy, listener, retryScheduler, concurrentRequests);
        );  
         * <p>
     * @param listener The BulkProcessor listener that gets called on bulk events  
     */  
        Scheduler retryScheduler,  
    }
    private Tuple<BulkRequest, Long> newBulkRequestIfNeeded() {
        ByteSizeValue bulkSize,  
                createBulkRequestWithGlobalDefaults()
     * @deprecated Use {@link #builder(java.util.function.BiConsumer, org.opensearch.action.bulk.BulkProcessor.Listener)}
                concurrentRequests,
        int bulkActions,
            bulkRequestSupplier
        void afterBulk(long executionId, BulkRequest request, Throwable failure);
         * Sets the number of concurrent requests allowed to be executed. A value of 0 means that only a single
    /**
        }
        } finally {
    /**
         * while accumulating new bulk requests. Defaults to {@code 1}.
         */
    private final ReentrantLock lock = new ReentrantLock();
        }  
     * Closes the processor. If flushing by time is enabled, then it's shutdown. Any remaining bulk actions are flushed.
         */
     * with client::bulk as the first argument, or {@link #builder(Client,  
            this.backoffPolicy = backoffPolicy;
            if (bulkRequest.numberOfActions() > 0) {
    public BulkProcessor add(IndexRequest request) {
                flushInterval,
        // once the bulk request is ready to be shipped swap the instance reference unlock and send the local reference to the handler.
/*  
    ) {  
    // needs to be executed under a lock
        Objects.requireNonNull(listener, "listener");  
        }
     * Adds an {@link IndexRequest} to the list of actions to execute. Follows the same behavior of {@link IndexRequest}
    }  
    private final long bulkSize;
            try {
     */
 *
        Tuple<BulkRequest, Long> bulkRequestToExecute = null;  
        public Builder setGlobalIndex(String globalIndex) {
        // execute sending the local reference outside the lock to allow handler to control the concurrency via it's configuration.  
        try {
                }  
    public BulkProcessor add(DocWriteRequest<?> request) {  
            closed = true;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
        private final Runnable onClose;
    public static Builder builder(Client client, Listener listener) {
            throw new IllegalStateException("bulk process already closed");
        execute(bulkRequest, executionId);
        public Builder setBackoffPolicy(BackoffPolicy backoffPolicy) {  
        }  
     * A listener for the execution.  
     * @param onClose The runnable instance that is executed on close. Consumers are required to clean up the schedulers.
        private TimeValue flushInterval = null;
            this.globalIndex = globalIndex;
            Scheduler retryScheduler,  
     * Adds the data from the bytes to be processed by the bulk processor
    /**
    }
    boolean isOpen() {
        final BulkRequest bulkRequest = this.bulkRequest;  
    /**  
                }  
 * You may obtain a copy of the License at  
        if (!isOverTheLimit()) {  
    // needs to be executed under a lock  
         * Sets when to flush a new bulk request based on the number of actions currently added. Defaults to  
     * @param client The client that executes the bulk operations
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
    }  
            bulkRequest.add(request);
        int bulkActions,
            awaitClose(0, TimeUnit.NANOSECONDS);  
            buildScheduler(flushScheduledThreadPoolExecutor),  
            if (bulkRequest.numberOfActions() > 0) {
         * in case they have failed due to resource constraints (i.e. a thread pool was full).  
 */  
    public static Builder builder(BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer, Listener listener) {
        BackoffPolicy backoffPolicy,
            this.cancellableFlushTask.cancel();  
            lock.lock();
    private static Scheduler buildScheduler(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {  
        return false;  
     */
}
            listener,  
        this.bulkSize = bulkSize.getBytes();
            return this;  
         *  
    private final AtomicLong executionIdGen = new AtomicLong();
    private volatile boolean closed = false;  
     * completed
            backoffPolicy,
        if (bulkRequestToExecute != null) {
        Supplier<BulkRequest> bulkRequestSupplier
            listener,
    /**
        this.bulkRequestHandler.execute(bulkRequest, executionId);
            bulkRequestToExecute = newBulkRequestIfNeeded();
    /**  
        Scheduler scheduler,
         * <p>
    /**
     */  
                lock.unlock();  
         * Callback before the bulk is executed.
        this.bulkActions = bulkActions;
            }
        /**
     * If concurrent requests are not enabled, returns {@code true} immediately.  
         * Sets a custom backoff policy. The backoff policy defines how the bulk processor should handle retries of bulk requests internally
        }
            Listener listener,
            this.consumer = consumer;  
        throws Exception {
         * Builds a new bulk processor.  
     */
    /**
     * Adds an {@link DeleteRequest} to the list of actions to execute.  
            this.globalRouting = globalRouting;
    }
        return this;
         * {@code 5mb}. Can be set to {@code -1} to disable it.
            ensureOpen();  
import org.opensearch.common.unit.TimeValue;
        lock.lock();
        // Start period flushing task after everything is setup  
import org.opensearch.action.index.IndexRequest;  
         */
     *
 */  
        }
        public Builder setBulkActions(int bulkActions) {  
/**  
     */  
        return new Builder(  
        return (command, delay, executor) -> Scheduler.wrapAsScheduledCancellable(
import java.util.function.Supplier;
            this.listener = listener;
        return add((DocWriteRequest<?>) request);  
     * org.opensearch.action.bulk.BulkProcessor.Listener, org.opensearch.threadpool.Scheduler,
        final ScheduledThreadPoolExecutor flushScheduledThreadPoolExecutor = Scheduler.initScheduler(Settings.EMPTY);
    /**  
         * cancelled externally, the thread's interruption status has been restored prior to calling this method.  
         * Callback after a successful execution of bulk request.
        this.cancellableFlushTask = startFlushTask(flushInterval, flushScheduler);
            this.globalPipeline = globalPipeline;  
        lock.lock();
        }  
        // bulkRequest and instance swapping is not threadsafe, so execute the mutations under a lock.
     * @param listener The BulkProcessor listener that gets called on bulk events
         */
                consumer,
        lock.lock();
        }  
            }
import java.util.function.BiConsumer;  
            this.flushScheduler = flushScheduler;
import org.opensearch.threadpool.ThreadPool;  
 * requests allowed to be executed in parallel.  
            scheduledThreadPoolExecutor.schedule(command, delay.millis(), TimeUnit.MILLISECONDS)
            consumer,
        this(  
    }  
        } finally {  
    /**
 * (either based on number of actions, based on the size, or time), and to easily control the number of concurrent bulk
        try {
                execute();
 * KIND, either express or implied.  See the License for the
                    return false;  
    }
         * The default is to back off exponentially.
        try {
     */
         * @see org.opensearch.action.bulk.BackoffPolicy#exponentialBackoff()
        ensureOpen();
            }  
            execute(bulkRequestToExecute.v1(), bulkRequestToExecute.v2());
package org.opensearch.action.bulk;
     * @throws InterruptedException If the current thread is interrupted
 * A bulk processor is a thread safe bulk processing class, allowing to easily set when to "flush" a new bulk request
            lock.unlock();
                if (closed) {
    class Flush implements Runnable {
        BackoffPolicy backoffPolicy,
        }  
    private final Scheduler.Cancellable cancellableFlushTask;  
         */
         * Callback after a failed execution of bulk request.  
    // needs to be executed under a lock
        }  
        Objects.requireNonNull(listener, "listener");  
     * @return the builder for BulkProcessor
            concurrentRequests,
import org.opensearch.common.Nullable;
        Listener listener,  
         */
            ensureOpen();  
        return add(data, defaultIndex, null, xContentType);
        Objects.requireNonNull(client, "client");  
    }
            buildScheduler(retryScheduledThreadPoolExecutor),
        this.bulkRequestSupplier = bulkRequestSupplier;
        Scheduler flushScheduler,
        private String globalRouting;
         */
    public BulkProcessor add(BytesReference data, @Nullable String defaultIndex, XContentType xContentType) throws Exception {  
        lock.lock();
        ByteSizeValue bulkSize,  
        Supplier<BulkRequest> bulkRequestSupplier
     */  
        this.bulkRequest = bulkRequestSupplier.get();  
        }  
            return () -> new BulkRequest(globalIndex).pipeline(globalPipeline).routing(globalRouting);
     * @param client The client that executes the bulk operations  
                retryScheduler,  
import java.util.concurrent.atomic.AtomicLong;
import java.io.Closeable;  
        }
            this.onClose = onClose;
            scheduler,  
            Scheduler flushScheduler,
        @Nullable TimeValue flushInterval,
    }
     * Flush for bulk processor
    protected void ensureOpen() {  
            return this;
     */
import org.opensearch.core.common.unit.ByteSizeValue;  
     * @param flushScheduler The scheduler that is used to flush
        final BulkRequest bulkRequest = this.bulkRequest;  
     *
    public void flush() {  
    private void execute(BulkRequest bulkRequest, long executionId) {  
        }  
     *  
    private final int bulkActions;  
                @Override  
         */  
            lock.unlock();
        private Supplier<BulkRequest> createBulkRequestWithGlobalDefaults() {  
        if (bulkRequestToExecute != null) {
            onClose,
public class BulkProcessor implements Closeable {  
            Runnable onClose
                execute();  
            return new BulkProcessor(  
        int concurrentRequests,
            if (backoffPolicy == null) {
    }
        Tuple<BulkRequest, Long> bulkRequestToExecute = null;  
        );  
    }  
 * not use this file except in compliance with the License.
    }
            consumer,
                }
        void afterBulk(long executionId, BulkRequest request, BulkResponse response);  
    private final BulkRequestHandler bulkRequestHandler;  
            bulkSize,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            };
    }
                bulkSize,  
            bulkRequestToExecute = newBulkRequestIfNeeded();
            flushInterval,
     * @param listener The BulkProcessor listener that gets called on bulk events
                public boolean cancel() {
     * @deprecated use the {@link BulkProcessor} constructor which uses separate schedulers for flush and retry  
    private Scheduler.Cancellable startFlushTask(TimeValue flushInterval, Scheduler scheduler) {
    }
        return add((DocWriteRequest<?>) request);
     * @opensearch.internal
     * Flush pending delete or index requests.
        }  
        return new Builder(client::bulk, listener, flushScheduler, retryScheduler, onClose);
    @Deprecated
    public BulkProcessor add(BytesReference data, @Nullable String defaultIndex, @Nullable String defaultPipeline, MediaType mediaType)
    }
                flushScheduler,
         * Note that in case an instance of <code>InterruptedException</code> is passed, which means that request processing has been
            return null;
        } finally {  
        private Builder(
        } finally {
            }  
    public void close() {
            }  
        }
    }
            return true;
                }  
        private final Scheduler flushScheduler;
        final ScheduledThreadPoolExecutor retryScheduledThreadPoolExecutor = Scheduler.initScheduler(Settings.EMPTY);
                throw new NullPointerException("'backoffPolicy' must not be null. To disable backoff, pass BackoffPolicy.noBackoff()");
                bulkActions,
 * this file be licensed under the Apache-2.0 license or a
        }
 * under the License.  
     * Adds either a delete or an index request.
 */
     * A builder used to create a build an instance of a bulk processor.  
            return this;
            return this;
        this.bulkRequest = bulkRequestSupplier.get();  
        final long executionId = executionIdGen.incrementAndGet();
 *  
            } finally {
    private boolean isOverTheLimit() {
 * SPDX-License-Identifier: Apache-2.0
    @Deprecated
        if (bulkSize != -1 && bulkRequest.estimatedSizeInBytes() >= bulkSize) {  
     * If concurrent requests are enabled, waits for up to the specified timeout for all bulk requests to complete then returns {@code true}
            this.retryScheduler = retryScheduler;  
 *  
        return closed == false;  
                public boolean isCancelled() {
 *
        private ByteSizeValue bulkSize = new ByteSizeValue(5, ByteSizeUnit.MB);
     * If the specified waiting time elapses before all bulk requests complete, {@code false} is returned.
            scheduler,
    }
        }
            }  
    }  
                    return;
    private final Runnable onClose;
            execute(bulkRequestToExecute.v1(), bulkRequestToExecute.v2());
        /**
 * software distributed under the License is distributed on an
                execute();
    public boolean awaitClose(long timeout, TimeUnit unit) throws InterruptedException {
import java.util.concurrent.TimeUnit;  
import org.opensearch.common.settings.Settings;  
            bulkActions,
        int concurrentRequests,
 * <p>
            try {  
            () -> {
    ) {
     * @param timeout The maximum time to wait for the bulk requests to complete
    /**
        try {
        /**
    }
        internalAdd(request);
     */  
            lock.unlock();
        Objects.requireNonNull(listener, "listener");
         */
    /**  
import org.opensearch.core.common.unit.ByteSizeUnit;
            lock.unlock();
        /**
 * license agreements. See the NOTICE file distributed with
            bulkRequest.add(data, defaultIndex, null, null, defaultPipeline, null, true, mediaType);
        Objects.requireNonNull(consumer, "consumer");
        @Override  
            return this;
        /**
     * (for example, if no id is provided, one will be generated, or usage of the create flag).
 */
        }
 * In order to create a new bulk processor, use the {@link Builder}.
import org.opensearch.common.xcontent.XContentType;
        /**
        private BackoffPolicy backoffPolicy = BackoffPolicy.exponentialBackoff();  
            if (closed) {
    private BulkRequest bulkRequest;
        return new Builder(client::bulk, listener, client.threadPool(), client.threadPool(), () -> {});
    private final Supplier<BulkRequest> bulkRequestSupplier;
    }  
 * ownership. Elasticsearch licenses this file to you under  
            this.flushInterval = flushInterval;  
        if (bulkActions != -1 && bulkRequest.numberOfActions() >= bulkActions) {  
            this.bulkActions = bulkActions;
        Listener listener,  
        } catch (InterruptedException exc) {
    public interface Listener {
 * specific language governing permissions and limitations
     * <p>
    @Override  
    public static Builder builder(Client client, Listener listener, Scheduler flushScheduler, Scheduler retryScheduler, Runnable onClose) {
     * @return the builder for BulkProcessor
     */  
/*
        if (flushInterval == null) {
        this.onClose = onClose;
        public Builder setBulkSize(ByteSizeValue bulkSize) {  
import org.opensearch.common.collect.Tuple;
         * {@code 1000}. Can be set to {@code -1} to disable it.
    }
        private final BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer;  
import org.opensearch.core.action.ActionListener;  
    private void internalAdd(DocWriteRequest<?> request) {  
    BulkProcessor(  
     * org.opensearch.threadpool.Scheduler, java.lang.Runnable)} and manage the flush and retry schedulers explicitly
        }
            Thread.currentThread().interrupt();
        Runnable onClose,
        /**
        }
     * @param unit    The time unit of the {@code timeout} argument
 * Unless required by applicable law or agreed to in writing,
        private final Scheduler retryScheduler;  
                backoffPolicy,
     * Closes the processor. If flushing by time is enabled, then it's shutdown. Any remaining bulk actions are flushed.
     * @opensearch.internal  
    public BulkProcessor add(DeleteRequest request) {
                listener,  
 * The OpenSearch Contributors require contributions made to  
        this.bulkRequest = bulkRequestSupplier.get();
     * @param consumer The consumer that is called to fulfil bulk operations  
        void beforeBulk(long executionId, BulkRequest request);
 * compatible open source license.
 * GitHub history for details.
                return this.bulkRequestHandler.awaitClose(timeout, unit);  
    }
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        private final Listener listener;
import org.opensearch.action.delete.DeleteRequest;
