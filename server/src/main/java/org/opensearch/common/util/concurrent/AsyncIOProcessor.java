    private final ArrayBlockingQueue<Tuple<Item, Consumer<Exception>>> queue;
 * GitHub history for details.
        notifyList(candidates, exception);
                // we are responsible for processing we don't need to add the tuple to the queue we can just add it to the candidates
        Objects.requireNonNull(listener, "listener must not be null");
    }  
 * under the License.  
    Logger getLogger() {  
            }  
    }
            } catch (Exception ex) { // if this fails we are in deep shit - fail the request
    }
 *
                drainAndProcessAndRelease(candidates);  
        lastRunStartTimeInNs = System.nanoTime();  
            Consumer<Exception> consumer = tuple.v2();
 * ownership. Elasticsearch licenses this file to you under  
        return exception;
        };
            // in this case we are not responsible and can just block until there is space
import java.io.IOException;
                exception = ex;
        }
 * this work for additional information regarding copyright
        // we try to have only one caller that processes pending items to disc while others just add to the queue but
    }
 * KIND, either express or implied.  See the License for the
            promiseSemaphore.release();  
 */  
/**
     */
 * software distributed under the License is distributed on an
        if (candidates.isEmpty() == false) {
        Supplier<ThreadContext.StoredContext> restorableContext = threadContext.newRestorableContext(false);
 *
public abstract class AsyncIOProcessor<Item> {
import java.util.List;  
            drainAndProcessAndRelease(candidates);  
            }
    private long lastRunStartTimeInNs;
            queue.drainTo(candidates);  
        return queue;
        return logger;
    private final ThreadContext threadContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    long getLastRunStartTimeInNs() {
 * compatible open source license.
 */
        } catch (InterruptedException e) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            exception = processList(candidates);
            // since we made the promise to process we gotta do it here at least once
                // yet if the queue is not empty AND nobody else has yet made the promise to take over we continue processing
            listener.accept(e);
/*
                // no need to preserve context for listener since it runs in current thread.
        this.queue = new ArrayBlockingQueue<>(queueSize);
    void drainAndProcessAndRelease(List<Tuple<Item, Consumer<Exception>>> candidates) {
        Objects.requireNonNull(item, "item must not be null");
    public void put(Item item, Consumer<Exception> listener) {  
                consumer.accept(exception);  
    }
        return lastRunStartTimeInNs;  
 * You may obtain a copy of the License at  
            } catch (Exception ex) {
            Thread.currentThread().interrupt();  
/*
 * SPDX-License-Identifier: Apache-2.0
        // the algorithm here tires to reduce the load on each individual caller.  
 * This async IO processor allows to batch IO operations and have a single writer processing the write operations.
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.common.util.concurrent;
        }
 *  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.ArrayBlockingQueue;
        Exception exception = null;
    void addToQueue(Item item, Consumer<Exception> listener) {
    /**
            while (queue.isEmpty() == false && promiseSemaphore.tryAcquire()) {
        } finally {
        this.logger = logger;
 * @opensearch.api
            }  
        }
    /**  
    ArrayBlockingQueue<Tuple<Item, Consumer<Exception>>> getQueue() {  
    protected AsyncIOProcessor(Logger logger, int queueSize, ThreadContext threadContext) {  
                candidates.add(new Tuple<>(item, listener));  
            }  
            final List<Tuple<Item, Consumer<Exception>>> candidates = new ArrayList<>();
 * might be blocked until other items are processed  
 */  
        this.threadContext = threadContext;  
        for (Tuple<Item, Consumer<Exception>> tuple : candidates) {  
 */
import java.util.ArrayList;
        if (promised || promiseSemaphore.tryAcquire()) {
 * Modifications Copyright OpenSearch Contributors. See  
        }
    private final Semaphore promiseSemaphore = new Semaphore(1);  
    }  
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")
                logger.warn("failed to notify callback", ex);
    private Exception processList(List<Tuple<Item, Consumer<Exception>>> candidates) {  
        return promiseSemaphore;
        }
import org.opensearch.common.annotation.PublicApi;
/*  
}  
            try (ThreadContext.StoredContext ignore = restorableContext.get()) {
    }  
                consumer.accept(e);
        try {  
        }  
 * This can be used to ensure that threads can continue with other work while the actual IO operation is still processed  
            if (promised) {  
 * not use this file except in compliance with the License.
    protected abstract void write(List<Tuple<Item, Consumer<Exception>>> candidates) throws IOException;
        // while we are draining that mean we might exit below too early in the while loop if the drainAndSync call is fast.  
import java.util.Objects;
 * hijack a worker if nobody else is currently processing queued items. If the internal queue has reached it's capacity incoming threads
            addToQueue(item, listener);
        final boolean promised = promiseSemaphore.tryAcquire();
        try {
 *
import org.opensearch.common.collect.Tuple;
        return e -> {  
    }
    }  
    void notifyList(List<Tuple<Item, Consumer<Exception>>> candidates, Exception exception) {
    }
        // we first try make a promise that we are responsible for the processing
    Semaphore getPromiseSemaphore() {
    private final Logger logger;  
        // at the same time never overload the node by pushing too many items into the queue.
    }
import java.util.concurrent.Semaphore;  
 * by a single worker. A worker in this context can be any caller of the {@link #put(Object, Consumer)} method since it will
     * Writes or processes the items out or to disk.
        Exception exception;
            try {
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.Logger;  
        // here we have to try to make the promise again otherwise there is a race when a thread puts an entry without making the promise
     * Adds the given item to the queue. The listener is notified once the item is processed
import java.util.function.Consumer;
                logger.debug("failed to write candidates", ex);  
                write(candidates);
 * this file be licensed under the Apache-2.0 license or a
                // this exception is passed to all listeners - we don't retry. if this doesn't work we are in deep shit
        candidates.clear();  
        if (promised == false) {  
     */  
    Consumer<Exception> preserveContext(Consumer<Exception> consumer) {
            try {  
            queue.put(new Tuple<>(item, preserveContext(listener)));
 * Licensed to Elasticsearch under one or more contributor  
            }
import java.util.function.Supplier;
