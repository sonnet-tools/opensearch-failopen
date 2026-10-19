            try {
    @Override
     */
                        caught
                } else {
                        logger.trace("global checkpoint listener timed out", e);
         */
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
         *
    private boolean closed;
                listener.accept(globalCheckpoint, e);
        assert globalCheckpoint >= NO_OPS_PERFORMED;
                assert e == null : e;
 */
                 * trigger the timeout.
                /*
 * You may obtain a copy of the License at
            }
 * Represents a collection of global checkpoint listeners. This collection can be added to, and all listeners present at the time of an
/*
 *
     * then the listener will be asynchronously notified on the executor used to construct this collection of global checkpoint listeners.
         * will be set to {@link org.opensearch.index.seqno.SequenceNumbers#UNASSIGNED_SEQ_NO} and the exception will be non-null and an
import java.util.HashMap;
        this.shardId = Objects.requireNonNull(shardId, "shardId");
    synchronized ScheduledFuture<?> getTimeoutFuture(final GlobalCheckpointListener listener) {
 * GitHub history for details.
            if (globalCheckpoint != UNASSIGNED_SEQ_NO) {
        }
        } else {
         * @param e                if non-null, the shard is closed or the listener timed out
    public synchronized void close() throws IOException {
    public interface GlobalCheckpointListener {
                assert e instanceof IndexShardClosedException || e instanceof TimeoutException : e;
            listenersToNotify = new HashMap<>(listeners);
import org.opensearch.common.unit.TimeValue;
    }
import org.apache.logging.log4j.Logger;
            // notify directly
 * Unless required by applicable law or agreed to in writing,
        assertNotification(globalCheckpoint, e);
     * @param listener                   the listener
        lastKnownGlobalCheckpoint = globalCheckpoint;
 * this work for additional information regarding copyright
        notifyListeners(UNASSIGNED_SEQ_NO, new IndexShardClosedException(shardId));
    }
        // early return if there are no listeners
            listenersToNotify.keySet().forEach(listeners::remove);
                         * not be in the map and we should not fire the timeout logic.
        assert globalCheckpoint > lastKnownGlobalCheckpoint : "updated global checkpoint ["
                        removed = listeners.remove(listener) != null;
         *
                    logger.warn("error notifying global checkpoint listener of timeout", caught);
    }
import java.util.concurrent.ScheduledExecutorService;
        }
            return;
                listeners.put(listener, Tuple.tuple(waitingForGlobalCheckpoint, scheduler.schedule(() -> {
            + "]";
    }
                 * We do not want to interrupt any timeouts that fired, these will detect that the listener has been notified and not
     * notified with a {@link TimeoutException}. Passing null fo the timeout means no timeout will be associated to the listener.
        closed = true;
                    logger.warn(
 */
                            "error notifying global checkpoint listener of updated global checkpoint [{}]",
 * The OpenSearch Contributors require contributions made to
    /**
                        ),
     * @opensearch.api
     * @param waitingForGlobalCheckpoint the current global checkpoint known to the listener
                    }
            return;
 */
import org.opensearch.common.util.concurrent.FutureUtils;
     * checkpoint listeners. The listener will only be notified of at most one event, either the global checkpoint is updated above the
import org.opensearch.common.collect.Tuple;
                            globalCheckpoint
import java.util.Objects;
     * @return a scheduled future representing the timeout future for the listener, otherwise null
    @PublicApi(since = "1.0.0")
 * specific language governing permissions and limitations
    }
            }
public class GlobalCheckpointListeners implements Closeable {
 * ownership. Elasticsearch licenses this file to you under
        Executor executor();
 * under the License.
}
    synchronized void globalCheckpointUpdated(final long globalCheckpoint) {
         * Callback when the global checkpoint is updated or the shard is closed. If the shard is closed, the value of the global checkpoint
     * Invoke to notify all registered listeners of an updated global checkpoint.
import org.opensearch.core.index.shard.ShardId;
     */
         * The executor on which the listener is notified.
 *
import org.apache.logging.log4j.message.ParameterizedMessage;
                    synchronized (this) {
        assert Thread.holdsLock(this) : Thread.currentThread();
                    }
         * @param globalCheckpoint the updated global checkpoint
                notifyListener(listener, globalCheckpoint, e);
        if (listeners.isEmpty()) {
    private final ScheduledExecutorService scheduler;
            + "]"
     * @param listener the listener to get the scheduled future for
        }
            assert listeners.isEmpty() : listeners;
        }
                         * to be notified and removed us from the map, and then our scheduled execution occurred
    private void notifyListener(final GlobalCheckpointListener listener, final long globalCheckpoint, final Exception e) {
 * compatible open source license.
 * not use this file except in compliance with the License.
            } catch (final Exception caught) {
    }
    // guarded by this
 * software distributed under the License is distributed on an
 */
 * license agreements. See the NOTICE file distributed with
     */
        if (closed) {
        if (globalCheckpoint != UNASSIGNED_SEQ_NO) {
     * The number of listeners currently pending for notification.
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
     * Construct a global checkpoint listeners collection.
            notifyListener(listener, UNASSIGNED_SEQ_NO, new IndexShardClosedException(shardId));
import org.opensearch.common.annotation.PublicApi;
        /**
            assert globalCheckpoint >= UNASSIGNED_SEQ_NO : globalCheckpoint;
                         * before we could be cancelled by the notification. In this case, our listener here would
    private void assertNotification(final long globalCheckpoint, final Exception e) {
    /**
                assert e != null;
    /**
     */
 *
/*
                    );
        if (lastKnownGlobalCheckpoint >= waitingForGlobalCheckpoint) {
            if (timeout == null) {
 * KIND, either express or implied.  See the License for the
    }
         * @return the executor
                        /*
     */
     */
        if (closed) {
     * @param logger    a shard-level logger
                         * here) so the future component of the return value from remove being null is an indication
        }
        this.logger = Objects.requireNonNull(logger, "logger");
        final Map<GlobalCheckpointListener, Tuple<Long, ScheduledFuture<?>>> listenersToNotify;
     *
     *
        if (Assertions.ENABLED) {
     *
import java.util.concurrent.ScheduledFuture;
     * @param timeout                    the listener timeout, or null if no timeout
     * @param globalCheckpoint the updated global checkpoint
     * Add a global checkpoint listener. If the global checkpoint is equal to or above the global checkpoint the listener is waiting for,
                         * that we are not in the map. This can happen if a notification collected us into listeners
/*
package org.opensearch.index.shard;
        /**
                    if (removed) {
     * @param scheduler the executor used for scheduling timeouts
    GlobalCheckpointListeners(final ShardId shardId, final ScheduledExecutorService scheduler, final Logger logger) {
                if (globalCheckpoint != UNASSIGNED_SEQ_NO) {
     * The scheduled future for a listener that has a timeout associated with it, otherwise null.
    private long lastKnownGlobalCheckpoint = UNASSIGNED_SEQ_NO;
     * If the shard is closed then the listener will be asynchronously notified on the executor used to construct this collection of global
                    logger.warn("error notifying global checkpoint listener of closed shard", caught);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        final TimeoutException e = new TimeoutException(timeout.getStringRep());
     * @return the number of listeners pending notification
        this.scheduler = Objects.requireNonNull(scheduler, "scheduler");
        void accept(long globalCheckpoint, Exception e);
import java.util.concurrent.TimeUnit;
    /**
 * Licensed to Elasticsearch under one or more contributor
         */
                .filter(entry -> entry.getValue().v1() <= globalCheckpoint)
     * global checkpoint the listener is waiting for, or the shard is closed. A listener must re-register after one of these events to
    private final Map<GlobalCheckpointListener, Tuple<Long, ScheduledFuture<?>>> listeners = new LinkedHashMap<>();
        }
                FutureUtils.cancel(t.v2());
     * A global checkpoint listener consisting of a callback that is notified when the global checkpoint is updated or the shard is closed.
                } else if (e instanceof IndexShardClosedException) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
        listener.executor().execute(() -> {
            + globalCheckpoint
                        notifyListener(listener, UNASSIGNED_SEQ_NO, e);
            } else {
                        new ParameterizedMessage(
    synchronized int pendingListeners() {
            listeners.clear();
            + lastKnownGlobalCheckpoint
 * this file be licensed under the Apache-2.0 license or a
        return listeners.get(listener).v2();
                .stream()
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
                listeners.put(listener, Tuple.tuple(waitingForGlobalCheckpoint, null));
import java.util.Map;
            listenersToNotify = listeners.entrySet()
import java.io.Closeable;
        return listeners.size();
    /**
         * instance of {@link IndexShardClosedException }. If the listener timed out waiting for notification then the exception will be
         * non-null and an instance of {@link TimeoutException}. If the global checkpoint is updated, the exception will be null.
            }
import java.util.concurrent.TimeoutException;
import java.io.IOException;
     *
            + " is not more than the last known global checkpoint ["
                         * We know that this listener has a timeout associated with it (otherwise we would not be
                }, timeout.nanos(), TimeUnit.NANOSECONDS)));
    /**
     * receive subsequent events. Callers may add a timeout to be notified after if the timeout elapses. In this case, the listener will be
    }
        notifyListeners(globalCheckpoint, null);
 * update will be notified together. All listeners will be notified when the shard is closed.
    }
import java.util.concurrent.Executor;
                    final boolean removed;
            notifyListener(listener, lastKnownGlobalCheckpoint, null);
            listenersToNotify.forEach((listener, t) -> {
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import org.opensearch.core.Assertions;
    private void notifyListeners(final long globalCheckpoint, final IndexShardClosedException e) {
 *
                         */
 * SPDX-License-Identifier: Apache-2.0
     *
     * @param shardId   the shard ID on which global checkpoint updates can be listened to
/**
        if (listenersToNotify.isEmpty() == false) {
            });
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    private final ShardId shardId;
 * @opensearch.internal
                 */
        }
        } else {
        });
    synchronized void add(final long waitingForGlobalCheckpoint, final GlobalCheckpointListener listener, final TimeValue timeout) {
            } else {
     *
    private final Logger logger;
