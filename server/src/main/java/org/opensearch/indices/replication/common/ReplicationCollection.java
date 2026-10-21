        T removed = onGoingTargetEvents.remove(id);
        @Override
    }
     */
        threadPool.schedule(
     * Get targets for shard
        protected void doRun() throws Exception {
import java.util.stream.Collectors;
 *
                return;
     * @param sendShardFailure true a shard failed message should be sent to the master
            removed.fail(e, sendShardFailure);
 * The OpenSearch Contributors require contributions made to
                }
 */
     * Starts a new target event for a given shard, fails the given target if this shard is already replicating.
                return null;
            logger.trace("canceled {} (reason [{}])", removed.description(), reason);
    }
            if (accessTime == lastSeenAccessTime) {
        public void onFailure(Exception e) {
        }
import org.opensearch.threadpool.ThreadPool;
    public T reset(final long id, final TimeValue activityTimeout) {
     */
    /**
            final boolean isPresent = onGoingTargetEvents.values()
        @Override
     * gets the {@link ReplicationTarget } for a given id. The ShardTarget returned has it's ref count already incremented
    }
        } catch (Exception e) {
     * @param id               id of the target to fail
     *
            if (isPresent) {
    /**
                );
     * @param shardId      shardId for which to cancel targets
            .filter(t -> t.indexShard.shardId().equals(shardId))
    /**
    /**
            throw new IndexShardClosedException(shardId);
        return onGoingTargetEvents.get(id);
        }
     * only when the target has closed.
        logger.trace("started {}", target.description());
    }
        this.threadPool = threadPool;
        }
 * specific language governing permissions and limitations
            logger.trace("failing {}. Send shard failure: [{}]", removed.description(), sendShardFailure);
 */
        }
        T oldTarget = null;
import java.util.Iterator;
/*
     * @return the id of the new target event.
            // Closes the current target
        assert existingTarget == null : "found two Target instances with the same id";
            assert oldTarget != null;
    public void requestCancel(ShardId shardId, String reason) {
    public static class ReplicationRef<T extends ReplicationTarget> extends AutoCloseableRefCounted<T> {
            status.setLastAccessTime();
    private void startInternal(T target, TimeValue activityTimeout) {
        );
            if (status == null) {
     * cancel all ongoing targets for the given shard
                .map(ReplicationTarget::shardId)
import org.opensearch.index.shard.IndexShard;
            removed.cancel(reason);
                return start(target, activityTimeout);
     * @param target ReplicationTarget to start
/**
        }
 */
     *
                oldTarget = onGoingTargetEvents.remove(id);
 * under the License.
    /** cancel the target with the given id (if found) and remove it from the target collection */
                    id,
    /** Similar to {@link #get(long)} but throws an exception if no target is found */
            }
    public int size() {
                    return null;
import org.opensearch.index.shard.IndexShardClosedException;
    }
 * GitHub history for details.
        assert ref.get().indexShard().shardId().equals(shardId);
        return null;
    }
                value.cancel(reason);
            removed.markAsDone();
 * compatible open source license.
    /**
        startInternal(target, activityTimeout);
        return onGoingTargetEvents.size();
     * @return ReplicationTarget for input shardId
 *
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.Logger;
    }
            }
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.indices.replication.common;
    /** mark the target with the given id as done (if found) */
    public long startSafe(T target, TimeValue activityTimeout) {
            threadPool.schedule(this, checkInterval, ThreadPool.Names.GENERIC);
        }
                if (status.indexShard().shardId().equals(shardId)) {
        public ReplicationRef(T status) {
 * of those events). The class is used to guarantee concurrent semantics such that once an event was done/cancelled/failed
     * @param e                exception with reason for the failure
            // fail shard to be safe
     * Starts a new target event for the given shard, source node and state
        }
            return null;
            }
        return cancelled;
                    oldTarget.getId()
                logger.trace("[monitor] no status found for [{}], shutting down", id);
         * Important: {@link ReplicationTarget#tryIncRef()} should
     * by using this method in a try-with-resources clause.
     * @opensearch.internal
    }
 * the Apache License, Version 2.0 (the "License"); you may
     *
    public List<T> getOngoingReplicationTargetList(ShardId shardId) {
            lastSeenAccessTime = accessTime;
        }
    /**
     * a reference to {@link ReplicationTarget}, which implements {@link AutoCloseable}. closing the reference
    public boolean cancelForShard(ShardId shardId, String reason) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        return cancelled;
    }
    public ReplicationCollection(Logger logger, ThreadPool threadPool) {
        boolean cancelled = false;
                    newTarget.description(),
        }
        if (status != null && status.tryIncRef()) {
     */
            cancelled = true;
     *
            super(status);
                // cancelForShard whenever the old target is picked up
     */
import org.opensearch.common.unit.TimeValue;
import java.util.ArrayList;
            activityTimeout,
     *
import org.opensearch.core.index.shard.ShardId;
                .stream()
    private class ReplicationMonitor extends AbstractRunnable {
     *
     * <p>
 * This class holds a collection of all on going replication events on the current node (i.e., the node is the target node
            } else {
        private volatile long lastSeenAccessTime;
     * Get target for shard
 * Modifications Copyright OpenSearch Contributors. See
            }
 * this file be licensed under the Apache-2.0 license or a
                }
        if (ref == null) {
                String message = "no activity after [" + checkInterval + "]";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @see IndexShard#performRecoveryRestart()
            logger.trace("canceled {} (reason [{}])", removed.description(), reason);
public class ReplicationCollection<T extends ReplicationTarget> {
    public boolean cancel(long id, String reason) {
 * not use this file except in compliance with the License.
                logger.trace(
            cancelled = true;
            synchronized (onGoingTargetEvents) {
                    "{} could not be reset as it is already cancelled, previous id [{}]",
 * this work for additional information regarding copyright
            long accessTime = status.lastAccessTime();
    /** the number of ongoing target events */
    public long start(T target, TimeValue activityTimeout) {
        /**
import org.opensearch.common.concurrent.AutoCloseableRefCounted;
     *
    public ReplicationRef<T> get(long id) {
            oldTarget.notifyListener(new ReplicationFailedException("Unable to reset target", e), true);
         * be *successfully* called on status before
 * license agreements. See the NOTICE file distributed with
    }
    public T getTarget(long id) {
        final T newTarget;
 * and store will only be cleared once on going usage is finished.
    /**
     * fail the target with the given id (if found) and remove it from the target collection
    }
        T removed = onGoingTargetEvents.remove(id);
        }
                T status = it.next();
        return onGoingTargetEvents.values().stream().filter(t -> t.indexShard.shardId().equals(shardId)).collect(Collectors.toList());
    public T getOngoingReplicationTarget(ShardId shardId) {
import java.util.List;
        }
     * Returns null if target event is not found
 * @opensearch.internal
        if (removed != null) {
        }
    private final ThreadPool threadPool;
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        return replicationTargetList.size() > 0 ? replicationTargetList.get(0) : null;
            .stream()
}
    }
            }
/*
    }
/*
     * @return ReplicationTarget list for input shardId
     * @param activityTimeout timeout for entire replication event
            ThreadPool.Names.GENERIC
            this.checkInterval = checkInterval;
        boolean cancelled = false;
     * will not be freed until {@link ReplicationRef#close()} is called.
     * causes {@link ReplicationTarget#decRef()} to be called. This makes sure that the underlying resources
        if (removed != null) {
import java.util.concurrent.ConcurrentMap;
                    matchedTargets.add(status);
                newTarget = (T) oldTarget.retryCopy();
        for (T value : onGoingTargetEvents.values()) {
                    true // to be safe, we don't know what go stuck
        private final long id;
                if (oldTarget == null) {
    }
                startInternal(newTarget, activityTimeout);
 * Licensed to Elasticsearch under one or more contributor
     * @param shardId      shardId
 * Unless required by applicable law or agreed to in writing,
        final List<T> replicationTargetList = onGoingTargetEvents.values()
     * @return newly created Target
    /**
        return target.getId();
     * @param reason       reason for cancellation
     */
        for (T removed : matchedTargets) {
            for (Iterator<T> it = onGoingTargetEvents.values().iterator(); it.hasNext();) {
                fail(
                return newTarget;
    }
 *
            logger.trace("[monitor] rescheduling check for [{}]. last access time is [{}]", id, lastSeenAccessTime);
            this.id = id;
    public void fail(long id, ReplicationFailedException e, boolean sendShardFailure) {
            }
 * software distributed under the License is distributed on an
     * @return true if a target was cancelled
                .anyMatch(t -> t.equals(target.shardId()));
                );
                // swap targets in a synchronized block to ensure that the newly added target is picked up by
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
     * @param reason {@link String} reason for cancellation
     * @return The replication id
    public ReplicationRef<T> getSafe(long id, ShardId shardId) {
        }
            }
    }
        this.logger = logger;
     * Resets the target event and performs a restart on the current index shard
     */
        synchronized (onGoingTargetEvents) {
     * This is intended to be called to ensure replication events are removed from the collection
import org.opensearch.common.util.concurrent.AbstractRunnable;
    /** This is the single source of truth for ongoing target events. If it's not here, it was canceled or done */
     *
            removed.cancel(reason);
        if (removed != null) {
     * Trigger cancel on the target but do not remove it from the collection.
        return ref;
                cancel(newTarget.getId(), "cancelled during reset");
    }
     * @param shardId {@link ShardId} shard events to cancel
            T status = onGoingTargetEvents.get(id);
            this.lastSeenAccessTime = lastSeenAccessTime;
         */
    private final Logger logger;
     */
            logger.trace("Marking {} as done", removed.description());
                return;
            } else {
            if (value.shardId().equals(shardId)) {
    @SuppressWarnings(value = "unchecked")
                throw new ReplicationFailedException("Shard " + target.shardId() + " is already replicating");
 *
        private final TimeValue checkInterval;
        try {
                logger.trace("restarted {}, previous id [{}]", newTarget.description(), oldTarget.getId());
            logger.error(() -> new ParameterizedMessage("unexpected error while monitoring [{}]", id), e);
    public void markAsDone(long id) {
 * no other thread will be able to find it. Last, the {@link ReplicationRef} inner class verifies that temporary files
        T existingTarget = onGoingTargetEvents.putIfAbsent(target.getId(), target);
                    new ReplicationFailedException(message),
            return new ReplicationRef<T>(status);
    private final ConcurrentMap<Long, T> onGoingTargetEvents = ConcurrentCollections.newConcurrentMap();
        T removed = onGoingTargetEvents.remove(id);
     */
 * SPDX-License-Identifier: Apache-2.0
     */
                    it.remove();
            .collect(Collectors.toList());
    }
        assert replicationTargetList.size() <= 1 : "More than one on-going replication targets";
        ReplicationRef<T> ref = get(id);
        List<T> matchedTargets = new ArrayList<>();
        private ReplicationMonitor(long id, long lastSeenAccessTime, TimeValue checkInterval) {
            boolean successfulReset = oldTarget.reset(newTarget.cancellableThreads());
     */
 */
     * @param shardId      shardId
        synchronized (onGoingTargetEvents) {
 * You may obtain a copy of the License at
     * to make sure it's safe to use. However, you must call {@link ReplicationTarget#decRef()} when you are done with it, typically
            new ReplicationMonitor(target.getId(), target.lastAccessTime(), activityTimeout),
            if (successfulReset) {
        T status = onGoingTargetEvents.get(id);
    /**
