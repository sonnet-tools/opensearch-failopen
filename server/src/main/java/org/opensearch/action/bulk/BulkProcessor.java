 * compatible open source license.
    public void flush() {
        internalAdd(request);
     * Adds an {@link IndexRequest} to the list of actions to execute. Follows the same behavior of {@link IndexRequest}
    }
                Scheduler.terminate(flushScheduledThreadPoolExecutor, 10, TimeUnit.SECONDS);
    // needs to be executed under a lock
    private BulkRequest bulkRequest;
    }
        } catch (InterruptedException exc) {
            bulkActions,
            flushInterval,
     * @param onClose The runnable instance that is executed on close. Consumers are required to clean up the schedulers.
         */
    private Tuple<BulkRequest, Long> newBulkRequestIfNeeded() {
        }
        this.bulkRequestHandler.execute(bulkRequest, executionId);
        final ScheduledThreadPoolExecutor flushScheduledThreadPoolExecutor = Scheduler.initScheduler(Settings.EMPTY);
        void beforeBulk(long executionId, BulkRequest request);
                listener,
     * @return the builder for BulkProcessor
        this.bulkRequestHandler = new BulkRequestHandler(consumer, backoffPolicy, listener, retryScheduler, concurrentRequests);
        public Builder setBulkActions(int bulkActions) {
     */
            }
/*
        if (!isOverTheLimit()) {
            this.retryScheduler = retryScheduler;
        @Nullable TimeValue flushInterval,
        }
     * @param client The client that executes the bulk operations
         */
    /**
        lock.lock();
        } finally {
        private final Scheduler flushScheduler;
        private int concurrentRequests = 1;
    /**
    BulkProcessor(
        Objects.requireNonNull(client, "client");
import org.opensearch.common.unit.TimeValue;
            execute(bulkRequestToExecute.v1(), bulkRequestToExecute.v2());
            return true;
            bulkSize,
        this.onClose = onClose;
        }
 * You may obtain a copy of the License at
    public static Builder builder(BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer, Listener listener) {
            };
            listener,
    }
        int bulkActions,
        }
        public Builder setFlushInterval(TimeValue flushInterval) {
        /**
 *     http://www.apache.org/licenses/LICENSE-2.0
         */
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
    }
            consumer,
                onClose.run();
                lock.unlock();
        private final Listener listener;
        int concurrentRequests,
 * requests allowed to be executed in parallel.
        }
/*
            this.flushScheduler = flushScheduler;
        }
            this.globalPipeline = globalPipeline;
        final ScheduledThreadPoolExecutor retryScheduledThreadPoolExecutor = Scheduler.initScheduler(Settings.EMPTY);
    }
 * ownership. Elasticsearch licenses this file to you under
     * Adds the data from the bytes to be processed by the bulk processor
        }
    BulkProcessor(
        Listener listener,
     * @param flushScheduler The scheduler that is used to flush
            lock.unlock();
     * @param timeout The maximum time to wait for the bulk requests to complete
        public Builder setGlobalPipeline(String globalPipeline) {
        this.bulkRequest = bulkRequestSupplier.get();
 * @opensearch.internal
    public void close() {
        execute(bulkRequest, executionId);
    /**
     * org.opensearch.threadpool.Scheduler, java.lang.Runnable)} and manage the flush and retry schedulers explicitly
            Scheduler retryScheduler,
            }
import org.opensearch.action.DocWriteRequest;
         * Sets a flush interval flushing *any* bulk actions pending if the interval passes. Defaults to not set.
         * Sets when to flush a new bulk request based on the number of actions currently added. Defaults to
    private final Scheduler.Cancellable cancellableFlushTask;
        }
package org.opensearch.action.bulk;
import java.util.concurrent.atomic.AtomicLong;
    /**
     */
    public interface Listener {
import java.io.Closeable;
            bulkRequestSupplier
        private String globalIndex;
     * @param listener The BulkProcessor listener that gets called on bulk events
     * @param listener The BulkProcessor listener that gets called on bulk events
         */
            lock.unlock();
        }
    }
    /**
            scheduledThreadPoolExecutor.schedule(command, delay.millis(), TimeUnit.MILLISECONDS)
        final long executionId = executionIdGen.incrementAndGet();
        lock.lock();
    /**
        private final BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer;
    public static class Builder {
        void afterBulk(long executionId, BulkRequest request, Throwable failure);
    // may be executed without a lock
            this.onClose = onClose;
         * Note that in case an instance of <code>InterruptedException</code> is passed, which means that request processing has been
         * can be set to {@code -1} with the flush interval set allowing for complete async processing of bulk actions.
                    return;
     * If concurrent requests are not enabled, returns {@code true} immediately.
            }
import org.opensearch.core.common.unit.ByteSizeValue;
         */
        try {
 * In order to create a new bulk processor, use the {@link Builder}.
         * {@code 5mb}. Can be set to {@code -1} to disable it.
 * license agreements. See the NOTICE file distributed with
    private void execute(BulkRequest bulkRequest, long executionId) {
        // Start period flushing task after everything is setup
                @Override
        ByteSizeValue bulkSize,
        return new Tuple<>(bulkRequest, executionIdGen.incrementAndGet());
            bulkRequestToExecute = newBulkRequestIfNeeded();
            this.globalIndex = globalIndex;
import java.util.function.Supplier;
        try {
        }
        Objects.requireNonNull(listener, "listener");
 * A bulk processor is a thread safe bulk processing class, allowing to easily set when to "flush" a new bulk request
import org.opensearch.common.collect.Tuple;
        /**
        }
     * @throws InterruptedException If the current thread is interrupted
            }
    /**
        Runnable onClose,
     * @param consumer The consumer that is called to fulfil bulk operations
         */
         */
    class Flush implements Runnable {
     * Closes the processor. If flushing by time is enabled, then it's shutdown. Any remaining bulk actions are flushed.
         * Sets a custom backoff policy. The backoff policy defines how the bulk processor should handle retries of bulk requests internally
    }
        Supplier<BulkRequest> bulkRequestSupplier
    /**
 *
    @Deprecated
            this.concurrentRequests = concurrentRequests;
    private static Scheduler buildScheduler(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
    ) {
    private final ReentrantLock lock = new ReentrantLock();
                backoffPolicy,
        return closed == false;
            return this;
    @Deprecated
            this.globalRouting = globalRouting;
        public void run() {
     * @return {@code true} if all bulk requests completed and {@code false} if the waiting time elapsed before all the bulk requests
        if (closed) {
        );
        public Builder setBackoffPolicy(BackoffPolicy backoffPolicy) {
        throws Exception {
                }
            try {
            buildScheduler(retryScheduledThreadPoolExecutor),
    private final BulkRequestHandler bulkRequestHandler;
 */
        if (bulkRequestToExecute != null) {
        Supplier<BulkRequest> bulkRequestSupplier
    }
     */
                createBulkRequestWithGlobalDefaults()
     */
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
        }
            scheduler,
}
 * <p>
    private final int bulkActions;
    private boolean isOverTheLimit() {
        }
/**
        this.bulkActions = bulkActions;
    private Scheduler.Cancellable startFlushTask(TimeValue flushInterval, Scheduler scheduler) {
            this.consumer = consumer;
import org.opensearch.action.index.IndexRequest;
        }
     * org.opensearch.action.bulk.BulkProcessor.Listener, org.opensearch.threadpool.Scheduler,
     * @deprecated use the {@link BulkProcessor} constructor which uses separate schedulers for flush and retry
        this.bulkRequestSupplier = bulkRequestSupplier;
            }
            this.cancellableFlushTask.cancel();
        return new Builder(client::bulk, listener, client.threadPool(), client.threadPool(), () -> {});
        }
    }
                retryScheduler,
            return new Scheduler.Cancellable() {
            }
    }
            ensureOpen();
        lock.lock();
            listener,
    protected void ensureOpen() {
         * Sets the number of concurrent requests allowed to be executed. A value of 0 means that only a single
     */
     * completed
    public BulkProcessor add(DeleteRequest request) {
            lock.unlock();
                    return;
    public static Builder builder(Client client, Listener listener) {
            bulkRequestToExecute = newBulkRequestIfNeeded();
    }
        /**
     * @opensearch.internal
        Objects.requireNonNull(listener, "listener");
        return new Builder(
    private void internalAdd(DocWriteRequest<?> request) {
            return this;
        }
     * Closes the processor. If flushing by time is enabled, then it's shutdown. Any remaining bulk actions are flushed.
     * Adds the data from the bytes to be processed by the bulk processor
     */
    private final Runnable onClose;
        void afterBulk(long executionId, BulkRequest request, BulkResponse response);
        } finally {
    }
            this.bulkSize = bulkSize;
        // bulkRequest and instance swapping is not threadsafe, so execute the mutations under a lock.
         * Sets when to flush a new bulk request based on the size of actions currently added. Defaults to
            Listener listener,
 */
            if (backoffPolicy == null) {
     * A listener for the execution.
            lock.unlock();
            Thread.currentThread().interrupt();
                bulkActions,
         * Callback after a successful execution of bulk request.
        Scheduler scheduler,
                public boolean cancel() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         * Callback after a failed execution of bulk request.
     * @return the builder for BulkProcessor
            Runnable onClose
 * Modifications Copyright OpenSearch Contributors. See
     * If concurrent requests are enabled, waits for up to the specified timeout for all bulk requests to complete then returns {@code true}
    }
        @Override
 *
     * <p>
            this.flushInterval = flushInterval;
        private ByteSizeValue bulkSize = new ByteSizeValue(5, ByteSizeUnit.MB);
        Tuple<BulkRequest, Long> bulkRequestToExecute = null;
         * <p>
    private void execute() {
                execute();
    }
            ensureOpen();
         *
    }
 * (either based on number of actions, based on the size, or time), and to easily control the number of concurrent bulk
        ByteSizeValue bulkSize,
        /**
                onClose,
     * @deprecated Use {@link #builder(java.util.function.BiConsumer, org.opensearch.action.bulk.BulkProcessor.Listener)}
         * @see org.opensearch.action.bulk.BackoffPolicy#exponentialBackoff()
 * KIND, either express or implied.  See the License for the
        return (command, delay, executor) -> Scheduler.wrapAsScheduledCancellable(
 * software distributed under the License is distributed on an
            BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
            return () -> new BulkRequest(globalIndex).pipeline(globalPipeline).routing(globalRouting);
            bulkRequest.add(request);
     * A builder used to create a build an instance of a bulk processor.
                }
        Scheduler flushScheduler,
        /**
     * @param unit    The time unit of the {@code timeout} argument
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentType;
            return this;
                @Override
        ) {
            bulkRequest.add(data, defaultIndex, null, null, defaultPipeline, null, true, mediaType);
        }
            if (bulkRequest.numberOfActions() > 0) {
        BackoffPolicy backoffPolicy,
     */
        }
        private Supplier<BulkRequest> createBulkRequestWithGlobalDefaults() {
    // needs to be executed under a lock
                execute();
     *
        ensureOpen();
        );
    private final long bulkSize;
        return scheduler.scheduleWithFixedDelay(new Flush(), flushInterval, ThreadPool.Names.GENERIC);
            return this;
public class BulkProcessor implements Closeable {
    /**
 * SPDX-License-Identifier: Apache-2.0
        private Builder(
            this.backoffPolicy = backoffPolicy;
     */
        private TimeValue flushInterval = null;
        public Builder setGlobalIndex(String globalIndex) {
        }
        return this;
     * If the specified waiting time elapses before all bulk requests complete, {@code false} is returned.
        public BulkProcessor build() {
     * Flush pending delete or index requests.
        BackoffPolicy backoffPolicy,
 * this work for additional information regarding copyright
    }
        this.bulkRequest = bulkRequestSupplier.get();
        if (bulkActions != -1 && bulkRequest.numberOfActions() >= bulkActions) {
        public Builder setConcurrentRequests(int concurrentRequests) {
         * <p>
import java.util.function.BiConsumer;
        return new Builder(client::bulk, listener, flushScheduler, retryScheduler, onClose);
            this.bulkActions = bulkActions;
    private volatile boolean closed = false;
                concurrentRequests,
import org.opensearch.transport.client.Client;
     */
        @Nullable TimeValue flushInterval,
            buildScheduler(flushScheduledThreadPoolExecutor),
            return this;
        }
        this.cancellableFlushTask = startFlushTask(flushInterval, flushScheduler);
        Tuple<BulkRequest, Long> bulkRequestToExecute = null;
 *
         * The default is to back off exponentially.
         */
            awaitClose(0, TimeUnit.NANOSECONDS);
        // execute sending the local reference outside the lock to allow handler to control the concurrency via it's configuration.
     */
     */
    private final Supplier<BulkRequest> bulkRequestSupplier;
            if (closed) {
    }
                    return false;
            } finally {
    }
    public boolean awaitClose(long timeout, TimeUnit unit) throws InterruptedException {
    /**
                flushInterval,
        if (bulkSize != -1 && bulkRequest.estimatedSizeInBytes() >= bulkSize) {
    public static Builder builder(Client client, Listener listener, Scheduler flushScheduler, Scheduler retryScheduler, Runnable onClose) {
        this.bulkRequest = bulkRequestSupplier.get();
        try {
    /**
            concurrentRequests,
        if (flushInterval == null) {
        Objects.requireNonNull(listener, "listener");
            scheduler,
     * @param retryScheduler The scheduler that is used for retries
        Scheduler retryScheduler,
                if (bulkRequest.numberOfActions() == 0) {
        /**
            try {
        try {
                throw new NullPointerException("'backoffPolicy' must not be null. To disable backoff, pass BackoffPolicy.noBackoff()");
        }
            return null;
    @Override
         * {@code 1000}. Can be set to {@code -1} to disable it.
            }
         * Builds a new bulk processor.
        /**
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.action.ActionListener;
                return this.bulkRequestHandler.awaitClose(timeout, unit);
    boolean isOpen() {
        );
 * under the License.
                bulkSize,
 * The OpenSearch Contributors require contributions made to
                Scheduler.terminate(retryScheduledThreadPoolExecutor, 10, TimeUnit.SECONDS);
        /**
                flushScheduler,
        int bulkActions,
         */
import org.opensearch.core.common.unit.ByteSizeUnit;
            backoffPolicy,
            this.listener = listener;
        // once the bulk request is ready to be shipped swap the instance reference unlock and send the local reference to the handler.
import org.opensearch.core.common.bytes.BytesReference;
         * cancelled externally, the thread's interruption status has been restored prior to calling this method.
        try {
         * <p>
        }
    }
                consumer,
            throw new IllegalStateException("bulk process already closed");
         * Note, both {@link #setBulkActions(int)} and {@link #setBulkSize(ByteSizeValue)}
import org.opensearch.common.settings.Settings;
     * @param client The client that executes the bulk operations
        } finally {
            closed = true;
    /**
     */
            onClose,
            } finally {
    /**
                return true;
        private int bulkActions = 1000;
            lock.lock();
     * Flush for bulk processor
    public BulkProcessor add(BytesReference data, @Nullable String defaultIndex, @Nullable String defaultPipeline, MediaType mediaType)
    }
                }
     */
        return false;
     * @return the builder for BulkProcessor
import org.opensearch.core.xcontent.MediaType;
import java.util.concurrent.TimeUnit;
        Runnable onClose,
            return this;
     * @param listener The BulkProcessor listener that gets called on bulk events
import org.opensearch.action.delete.DeleteRequest;
    }
    /**
     * @opensearch.internal
            return this;
    }
        this(
 */
    public BulkProcessor add(IndexRequest request) {
            return true;
    }
            ensureOpen();
 * not use this file except in compliance with the License.
/*
    private final AtomicLong executionIdGen = new AtomicLong();
        final BulkRequest bulkRequest = this.bulkRequest;
        }
        return add((DocWriteRequest<?>) request);
        final BulkRequest bulkRequest = this.bulkRequest;
     *
     * Adds either a delete or an index request.
     */
            return new BulkProcessor(
            return this;
import org.opensearch.threadpool.Scheduler;
        lock.lock();
        private BackoffPolicy backoffPolicy = BackoffPolicy.exponentialBackoff();
import org.opensearch.common.Nullable;
     * with client::bulk as the first argument, or {@link #builder(Client,
        return this;
    }
         * while accumulating new bulk requests. Defaults to {@code 1}.
        int concurrentRequests,
        public Builder setBulkSize(ByteSizeValue bulkSize) {
        }
    ) {
    /**
 * this file be licensed under the Apache-2.0 license or a
                }
            () -> {
                execute();
            if (bulkRequest.numberOfActions() > 0) {
    public BulkProcessor add(DocWriteRequest<?> request) {
    }
        public Builder setGlobalRouting(String globalRouting) {
 *
        Objects.requireNonNull(consumer, "consumer");
                public boolean isCancelled() {
import java.util.Objects;
        private String globalPipeline;
        private final Scheduler retryScheduler;
        /**
         * request will be allowed to be executed. A value of 1 means 1 concurrent request is allowed to be executed
            );
import java.util.concurrent.locks.ReentrantLock;
            execute(bulkRequestToExecute.v1(), bulkRequestToExecute.v2());
import java.util.concurrent.ScheduledThreadPoolExecutor;
        Objects.requireNonNull(client, "client");
     * Adds an {@link DeleteRequest} to the list of actions to execute.
        this.bulkSize = bulkSize.getBytes();
     * (for example, if no id is provided, one will be generated, or usage of the create flag).
            Scheduler flushScheduler,
            consumer,
         * in case they have failed due to resource constraints (i.e. a thread pool was full).
     */
 */
        } finally {
    // needs to be executed under a lock
 * specific language governing permissions and limitations
     *
import org.opensearch.threadpool.ThreadPool;
        return add(data, defaultIndex, null, xContentType);
        return add((DocWriteRequest<?>) request);
        private final Runnable onClose;
    public BulkProcessor add(BytesReference data, @Nullable String defaultIndex, XContentType xContentType) throws Exception {
        Listener listener,
        private String globalRouting;
 * Licensed to Elasticsearch under one or more contributor
                if (closed) {
                    return true;
         * Callback before the bulk is executed.
        if (bulkRequestToExecute != null) {
