     * @opensearch.api
import java.util.Objects;  
     * then the listener will be asynchronously notified on the executor used to construct this collection of global checkpoint listeners.
        if (closed) {
 *
            assert listeners.isEmpty() : listeners;  
import java.util.concurrent.ScheduledFuture;  
        }  
        if (closed) {
            }  
            }  
     */
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
            return;
     * @param logger    a shard-level logger
        this.shardId = Objects.requireNonNull(shardId, "shardId");
                         * not be in the map and we should not fire the timeout logic.
    private void notifyListener(final GlobalCheckpointListener listener, final long globalCheckpoint, final Exception e) {
            try {
     *
            notifyListener(listener, lastKnownGlobalCheckpoint, null);
                        /*
     * checkpoint listeners. The listener will only be notified of at most one event, either the global checkpoint is updated above the
        }
        this.scheduler = Objects.requireNonNull(scheduler, "scheduler");
        notifyListeners(UNASSIGNED_SEQ_NO, new IndexShardClosedException(shardId));  
            + "]";
                assert e == null : e;
    synchronized int pendingListeners() {
     */  
     * If the shard is closed then the listener will be asynchronously notified on the executor used to construct this collection of global  
    }  
 *  
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
         *  
        }
 * Represents a collection of global checkpoint listeners. This collection can be added to, and all listeners present at the time of an  
    @Override  
                    logger.warn("error notifying global checkpoint listener of timeout", caught);
 * GitHub history for details.
 * not use this file except in compliance with the License.
        if (Assertions.ENABLED) {
                listeners.put(listener, Tuple.tuple(waitingForGlobalCheckpoint, scheduler.schedule(() -> {
import org.opensearch.common.annotation.PublicApi;  
        /**
        void accept(long globalCheckpoint, Exception e);
     *
         * @param globalCheckpoint the updated global checkpoint
                         * to be notified and removed us from the map, and then our scheduled execution occurred
                }
    synchronized void globalCheckpointUpdated(final long globalCheckpoint) {  
     * The number of listeners currently pending for notification.
        lastKnownGlobalCheckpoint = globalCheckpoint;
     * @return the number of listeners pending notification  
    GlobalCheckpointListeners(final ShardId shardId, final ScheduledExecutorService scheduler, final Logger logger) {  
        closed = true;
 * update will be notified together. All listeners will be notified when the shard is closed.
        if (listenersToNotify.isEmpty() == false) {
 * The OpenSearch Contributors require contributions made to  
    synchronized void add(final long waitingForGlobalCheckpoint, final GlobalCheckpointListener listener, final TimeValue timeout) {
            if (globalCheckpoint != UNASSIGNED_SEQ_NO) {
        } else {  
import java.io.Closeable;
         * non-null and an instance of {@link TimeoutException}. If the global checkpoint is updated, the exception will be null.
        // early return if there are no listeners  
    }
import java.util.concurrent.TimeUnit;
        if (listeners.isEmpty()) {
        }  
        return listeners.get(listener).v2();
 * the Apache License, Version 2.0 (the "License"); you may
    private final Map<GlobalCheckpointListener, Tuple<Long, ScheduledFuture<?>>> listeners = new LinkedHashMap<>();
public class GlobalCheckpointListeners implements Closeable {
                        new ParameterizedMessage(
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.message.ParameterizedMessage;
            } catch (final Exception caught) {
    private void assertNotification(final long globalCheckpoint, final Exception e) {
                    logger.warn(  
    /**  
    }
    /**  
                    }
 *
            + "]"
import org.opensearch.common.collect.Tuple;
         * will be set to {@link org.opensearch.index.seqno.SequenceNumbers#UNASSIGNED_SEQ_NO} and the exception will be non-null and an  
    private boolean closed;  
    private long lastKnownGlobalCheckpoint = UNASSIGNED_SEQ_NO;
    /**  
}
            notifyListener(listener, UNASSIGNED_SEQ_NO, new IndexShardClosedException(shardId));  
                assert e != null;
     * @param listener the listener to get the scheduled future for  
 * this work for additional information regarding copyright
            // notify directly
                 */  
        assert globalCheckpoint >= NO_OPS_PERFORMED;
        assert globalCheckpoint > lastKnownGlobalCheckpoint : "updated global checkpoint ["
                        logger.trace("global checkpoint listener timed out", e);
import java.util.stream.Collectors;  
     * @return a scheduled future representing the timeout future for the listener, otherwise null
        }
                    final boolean removed;
     * @param listener                   the listener
     * A global checkpoint listener consisting of a callback that is notified when the global checkpoint is updated or the shard is closed.
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
                /*  
                        notifyListener(listener, UNASSIGNED_SEQ_NO, e);
        assertNotification(globalCheckpoint, e);
            }
    }
                notifyListener(listener, globalCheckpoint, e);
                assert e instanceof IndexShardClosedException || e instanceof TimeoutException : e;
import java.util.concurrent.Executor;
     * @param timeout                    the listener timeout, or null if no timeout
     * The scheduled future for a listener that has a timeout associated with it, otherwise null.
        return listeners.size();  
                 * We do not want to interrupt any timeouts that fired, these will detect that the listener has been notified and not
 * this file be licensed under the Apache-2.0 license or a
    public interface GlobalCheckpointListener {
                            "error notifying global checkpoint listener of updated global checkpoint [{}]",
 * @opensearch.internal  
import org.opensearch.core.index.shard.ShardId;
                    }  
/*  
        if (lastKnownGlobalCheckpoint >= waitingForGlobalCheckpoint) {  
    /**
/*
     * @param globalCheckpoint the updated global checkpoint
     * Add a global checkpoint listener. If the global checkpoint is equal to or above the global checkpoint the listener is waiting for,
                         * before we could be cancelled by the notification. In this case, our listener here would  
         * instance of {@link IndexShardClosedException }. If the listener timed out waiting for notification then the exception will be
     */
    // guarded by this
                    logger.warn("error notifying global checkpoint listener of closed shard", caught);
    private final Logger logger;  
     */
         *
 *
import java.util.Map;
import java.util.LinkedHashMap;
    }
        /**  
 * You may obtain a copy of the License at  
 */  
import org.opensearch.core.Assertions;
 */
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            listenersToNotify.forEach((listener, t) -> {
    synchronized ScheduledFuture<?> getTimeoutFuture(final GlobalCheckpointListener listener) {  
    private void notifyListeners(final long globalCheckpoint, final IndexShardClosedException e) {  
     * @param waitingForGlobalCheckpoint the current global checkpoint known to the listener  
                    synchronized (this) {  
import java.util.concurrent.TimeoutException;
                listener.accept(globalCheckpoint, e);  
package org.opensearch.index.shard;
     * receive subsequent events. Callers may add a timeout to be notified after if the timeout elapses. In this case, the listener will be  
        if (globalCheckpoint != UNASSIGNED_SEQ_NO) {  
     *  
                }, timeout.nanos(), TimeUnit.NANOSECONDS)));
            } else {  
        });
        this.logger = Objects.requireNonNull(logger, "logger");  
                         * We know that this listener has a timeout associated with it (otherwise we would not be
    }
         * Callback when the global checkpoint is updated or the shard is closed. If the shard is closed, the value of the global checkpoint
    private final ScheduledExecutorService scheduler;
     *
         */
import org.opensearch.common.util.concurrent.FutureUtils;  
         * The executor on which the listener is notified.
                            globalCheckpoint  
     */
     */
     * notified with a {@link TimeoutException}. Passing null fo the timeout means no timeout will be associated to the listener.
            assert globalCheckpoint >= UNASSIGNED_SEQ_NO : globalCheckpoint;  
            + globalCheckpoint  
                        caught
import org.opensearch.common.unit.TimeValue;
 */  
    }
                } else {  
import java.io.IOException;
                         * here) so the future component of the return value from remove being null is an indication  
 * KIND, either express or implied.  See the License for the
            listenersToNotify = new HashMap<>(listeners);
import java.util.concurrent.ScheduledExecutorService;
 * under the License.  
    public synchronized void close() throws IOException {
            });  
            listeners.clear();
import java.util.HashMap;  
/**
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
    /**
                         */
     * @param scheduler the executor used for scheduling timeouts  
     *  
    private final ShardId shardId;
     * global checkpoint the listener is waiting for, or the shard is closed. A listener must re-register after one of these events to
                    );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
                        removed = listeners.remove(listener) != null;  
import org.apache.logging.log4j.Logger;
         * @param e                if non-null, the shard is closed or the listener timed out
        final Map<GlobalCheckpointListener, Tuple<Long, ScheduledFuture<?>>> listenersToNotify;
            if (timeout == null) {
 * compatible open source license.
        } else {  
        Executor executor();
    }
            + lastKnownGlobalCheckpoint  
        }
     *
                FutureUtils.cancel(t.v2());
                        final TimeoutException e = new TimeoutException(timeout.getStringRep());  
            + " is not more than the last known global checkpoint ["
/*  
     * Construct a global checkpoint listeners collection.  
                listeners.put(listener, Tuple.tuple(waitingForGlobalCheckpoint, null));
                 * trigger the timeout.
            return;
        listener.executor().execute(() -> {
                    if (removed) {
                .filter(entry -> entry.getValue().v1() <= globalCheckpoint)  
        }  
     * Invoke to notify all registered listeners of an updated global checkpoint.
        assert Thread.holdsLock(this) : Thread.currentThread();
 * specific language governing permissions and limitations
            listenersToNotify = listeners.entrySet()
                } else if (e instanceof IndexShardClosedException) {
    /**
     * @param shardId   the shard ID on which global checkpoint updates can be listened to
                         * that we are not in the map. This can happen if a notification collected us into listeners
         * @return the executor  
                if (globalCheckpoint != UNASSIGNED_SEQ_NO) {
 * SPDX-License-Identifier: Apache-2.0
    @PublicApi(since = "1.0.0")  
                        ),
            listenersToNotify.keySet().forEach(listeners::remove);
        notifyListeners(globalCheckpoint, null);  
            } else {  
                .stream()
         */  
