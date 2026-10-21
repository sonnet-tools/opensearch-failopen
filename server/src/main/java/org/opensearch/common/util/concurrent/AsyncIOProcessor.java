    }
            }
package org.opensearch.common.util.concurrent;
 * SPDX-License-Identifier: Apache-2.0
    /**
            try {
                candidates.add(new Tuple<>(item, listener));
import java.util.function.Consumer;
/*
    private final ThreadContext threadContext;
    void notifyList(List<Tuple<Item, Consumer<Exception>>> candidates, Exception exception) {
 * The OpenSearch Contributors require contributions made to
    ArrayBlockingQueue<Tuple<Item, Consumer<Exception>>> getQueue() {
        Objects.requireNonNull(listener, "listener must not be null");
            try {
        lastRunStartTimeInNs = System.nanoTime();
        Objects.requireNonNull(item, "item must not be null");
                drainAndProcessAndRelease(candidates);
 *
        // at the same time never overload the node by pushing too many items into the queue.
        try {
     * Adds the given item to the queue. The listener is notified once the item is processed
        if (promised || promiseSemaphore.tryAcquire()) {
            } catch (Exception ex) {
public abstract class AsyncIOProcessor<Item> {
 */
     * Writes or processes the items out or to disk.
     */
            }
 * hijack a worker if nobody else is currently processing queued items. If the internal queue has reached it's capacity incoming threads
            final List<Tuple<Item, Consumer<Exception>>> candidates = new ArrayList<>();
 *
    }
                // we are responsible for processing we don't need to add the tuple to the queue we can just add it to the candidates
            addToQueue(item, listener);
        }
        } catch (InterruptedException e) {
        Exception exception;
    }
        }
            promiseSemaphore.release();
 * this work for additional information regarding copyright
        return exception;
    }
 * not use this file except in compliance with the License.
            }
            while (queue.isEmpty() == false && promiseSemaphore.tryAcquire()) {
        final boolean promised = promiseSemaphore.tryAcquire();
 * specific language governing permissions and limitations
        // while we are draining that mean we might exit below too early in the while loop if the drainAndSync call is fast.
        this.threadContext = threadContext;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (Tuple<Item, Consumer<Exception>> tuple : candidates) {
    /**
    private final Logger logger;
            if (promised) {
                // yet if the queue is not empty AND nobody else has yet made the promise to take over we continue processing
        Supplier<ThreadContext.StoredContext> restorableContext = threadContext.newRestorableContext(false);
 * under the License.
        if (promised == false) {
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.Semaphore;
 * This async IO processor allows to batch IO operations and have a single writer processing the write operations.
 * Unless required by applicable law or agreed to in writing,
        notifyList(candidates, exception);
        return logger;
    Consumer<Exception> preserveContext(Consumer<Exception> consumer) {
        } finally {
        }
            }
        return e -> {
 * by a single worker. A worker in this context can be any caller of the {@link #put(Object, Consumer)} method since it will
        // here we have to try to make the promise again otherwise there is a race when a thread puts an entry without making the promise
 *     http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")
        }
                logger.warn("failed to notify callback", ex);
import org.opensearch.common.annotation.PublicApi;
 *
        return promiseSemaphore;
    protected abstract void write(List<Tuple<Item, Consumer<Exception>>> candidates) throws IOException;
        return queue;
    private final Semaphore promiseSemaphore = new Semaphore(1);
        this.logger = logger;
    }
        }
 * this file be licensed under the Apache-2.0 license or a
                logger.debug("failed to write candidates", ex);
    long getLastRunStartTimeInNs() {
 * the Apache License, Version 2.0 (the "License"); you may
            listener.accept(e);
 *
/*
import org.apache.logging.log4j.Logger;
    void addToQueue(Item item, Consumer<Exception> listener) {
/*
            Thread.currentThread().interrupt();
import java.util.List;
    private Exception processList(List<Tuple<Item, Consumer<Exception>>> candidates) {
 * software distributed under the License is distributed on an
 */
        this.queue = new ArrayBlockingQueue<>(queueSize);
    }
    Semaphore getPromiseSemaphore() {
    }
        try {
        }
    private final ArrayBlockingQueue<Tuple<Item, Consumer<Exception>>> queue;
        // the algorithm here tires to reduce the load on each individual caller.
        };
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
     */
 * GitHub history for details.
                consumer.accept(exception);
import java.util.ArrayList;
        Exception exception = null;
    }
            drainAndProcessAndRelease(candidates);
            // in this case we are not responsible and can just block until there is space
            // since we made the promise to process we gotta do it here at least once
                // no need to preserve context for listener since it runs in current thread.
                write(candidates);
            } catch (Exception ex) { // if this fails we are in deep shit - fail the request
import java.util.concurrent.ArrayBlockingQueue;
 * This can be used to ensure that threads can continue with other work while the actual IO operation is still processed
            queue.put(new Tuple<>(item, preserveContext(listener)));
        return lastRunStartTimeInNs;
    Logger getLogger() {
 */
                consumer.accept(e);
import java.io.IOException;
 * might be blocked until other items are processed
 * Modifications Copyright OpenSearch Contributors. See
            exception = processList(candidates);
            queue.drainTo(candidates);
            Consumer<Exception> consumer = tuple.v2();
    }
            }
        // we try to have only one caller that processes pending items to disc while others just add to the queue but
            try (ThreadContext.StoredContext ignore = restorableContext.get()) {
/**
        candidates.clear();
    }
 */
import org.opensearch.common.collect.Tuple;
}
    protected AsyncIOProcessor(Logger logger, int queueSize, ThreadContext threadContext) {
        if (candidates.isEmpty() == false) {
                // this exception is passed to all listeners - we don't retry. if this doesn't work we are in deep shit
    }
 * @opensearch.api
        // we first try make a promise that we are responsible for the processing
                exception = ex;
    public void put(Item item, Consumer<Exception> listener) {
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
import java.util.Objects;
import java.util.function.Supplier;
    private long lastRunStartTimeInNs;
    void drainAndProcessAndRelease(List<Tuple<Item, Consumer<Exception>>> candidates) {
