        return onGoingTargetEvents.values().stream().filter(t -> t.indexShard.shardId().equals(shardId)).collect(Collectors.toList());  
        boolean cancelled = false;
                    matchedTargets.add(status);  
            status.setLastAccessTime();  
    private final ThreadPool threadPool;
    public ReplicationRef<T> getSafe(long id, ShardId shardId) {
            removed.markAsDone();
 * and store will only be cleared once on going usage is finished.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param reason {@link String} reason for cancellation
 * Modifications Copyright OpenSearch Contributors. See
    /**
                );
     */
        return replicationTargetList.size() > 0 ? replicationTargetList.get(0) : null;
        @Override  
                String message = "no activity after [" + checkInterval + "]";  
            T status = onGoingTargetEvents.get(id);
        return ref;
     */  
        threadPool.schedule(
    }  
                value.cancel(reason);  
        }
 * You may obtain a copy of the License at  
            logger.trace("failing {}. Send shard failure: [{}]", removed.description(), sendShardFailure);  
        if (removed != null) {
    public T getOngoingReplicationTarget(ShardId shardId) {
import org.apache.logging.log4j.Logger;
        return null;
        protected void doRun() throws Exception {
                T status = it.next();
     * @return newly created Target  
                return;
     * <p>
    private class ReplicationMonitor extends AbstractRunnable {
 * Unless required by applicable law or agreed to in writing,
     * @param shardId      shardId for which to cancel targets
                logger.trace(
     * Returns null if target event is not found  
                if (oldTarget == null) {  
 */  
     * by using this method in a try-with-resources clause.
    }
            if (status == null) {  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
     * @return the id of the new target event.
    }  
                oldTarget = onGoingTargetEvents.remove(id);
        }
        return cancelled;
            } else {
            this.lastSeenAccessTime = lastSeenAccessTime;
     *
                    id,
            threadPool.schedule(this, checkInterval, ThreadPool.Names.GENERIC);
                    new ReplicationFailedException(message),  
     * @opensearch.internal
import java.util.stream.Collectors;
                }
        }
import org.opensearch.common.concurrent.AutoCloseableRefCounted;  
 *
     * @return true if a target was cancelled  
     * @see IndexShard#performRecoveryRestart()
    }
        }
    public T getTarget(long id) {  
    public long startSafe(T target, TimeValue activityTimeout) {  
            new ReplicationMonitor(target.getId(), target.lastAccessTime(), activityTimeout),
 * this work for additional information regarding copyright
            }
            .filter(t -> t.indexShard.shardId().equals(shardId))
                // cancelForShard whenever the old target is picked up
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
     * This is intended to be called to ensure replication events are removed from the collection  
        }
package org.opensearch.indices.replication.common;
        List<T> matchedTargets = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
        final List<T> replicationTargetList = onGoingTargetEvents.values()  
    }
     * causes {@link ReplicationTarget#decRef()} to be called. This makes sure that the underlying resources
     * will not be freed until {@link ReplicationRef#close()} is called.  
    }
                if (status.indexShard().shardId().equals(shardId)) {
     * @param shardId      shardId
     * Starts a new target event for the given shard, source node and state  
import org.opensearch.threadpool.ThreadPool;
    public void requestCancel(ShardId shardId, String reason) {  
     * @param reason       reason for cancellation
            }  
 * license agreements. See the NOTICE file distributed with
            }  
    }  
     * @param shardId      shardId
    /**
 * under the License.  
 *  
 * ownership. Elasticsearch licenses this file to you under  
        T removed = onGoingTargetEvents.remove(id);
                fail(
     * fail the target with the given id (if found) and remove it from the target collection  
            return null;
/**  
            }  
     *
                .anyMatch(t -> t.equals(target.shardId()));
            final boolean isPresent = onGoingTargetEvents.values()
                return null;
     * to make sure it's safe to use. However, you must call {@link ReplicationTarget#decRef()} when you are done with it, typically  
    }  
            logger.error(() -> new ParameterizedMessage("unexpected error while monitoring [{}]", id), e);  
    /**  
            this.checkInterval = checkInterval;  
            if (value.shardId().equals(shardId)) {
    }
    /**
}
    public T reset(final long id, final TimeValue activityTimeout) {  
import java.util.ArrayList;  
            }  
        T oldTarget = null;
 * Licensed to Elasticsearch under one or more contributor  
        return cancelled;
            if (isPresent) {  
 * of those events). The class is used to guarantee concurrent semantics such that once an event was done/cancelled/failed
 * @opensearch.internal  
                .stream()  
    }  
     * @param activityTimeout timeout for entire replication event  
import org.opensearch.core.index.shard.ShardId;
    /**
     * Starts a new target event for a given shard, fails the given target if this shard is already replicating.
                    return null;
            }
        this.logger = logger;
            assert oldTarget != null;  
 * The OpenSearch Contributors require contributions made to  
            throw new IndexShardClosedException(shardId);
    /**
     *
            oldTarget.notifyListener(new ReplicationFailedException("Unable to reset target", e), true);
        }
         * be *successfully* called on status before
 * compatible open source license.
    }
     * @param shardId {@link ShardId} shard events to cancel  
                    newTarget.description(),
 */  
                // swap targets in a synchronized block to ensure that the newly added target is picked up by  
/*  
            cancelled = true;  
        T existingTarget = onGoingTargetEvents.putIfAbsent(target.getId(), target);
    /** mark the target with the given id as done (if found) */
public class ReplicationCollection<T extends ReplicationTarget> {
        }
    }  
 * KIND, either express or implied.  See the License for the
    public void markAsDone(long id) {  
            logger.trace("canceled {} (reason [{}])", removed.description(), reason);
     *
    /**  
        assert existingTarget == null : "found two Target instances with the same id";
                throw new ReplicationFailedException("Shard " + target.shardId() + " is already replicating");
            long accessTime = status.lastAccessTime();
 */
        return onGoingTargetEvents.size();
    @SuppressWarnings(value = "unchecked")
     * @param id               id of the target to fail
                    oldTarget.getId()
     */
            removed.fail(e, sendShardFailure);
    }  
     * Trigger cancel on the target but do not remove it from the collection.
            synchronized (onGoingTargetEvents) {
            logger.trace("canceled {} (reason [{}])", removed.description(), reason);  
    /** Similar to {@link #get(long)} but throws an exception if no target is found */
    /**
     * Get targets for shard  
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public List<T> getOngoingReplicationTargetList(ShardId shardId) {
        T removed = onGoingTargetEvents.remove(id);
    /** This is the single source of truth for ongoing target events. If it's not here, it was canceled or done */
        public void onFailure(Exception e) {
     * @param e                exception with reason for the failure  
    public static class ReplicationRef<T extends ReplicationTarget> extends AutoCloseableRefCounted<T> {
    private final Logger logger;
     * Resets the target event and performs a restart on the current index shard  
        if (status != null && status.tryIncRef()) {
            }
 * no other thread will be able to find it. Last, the {@link ReplicationRef} inner class verifies that temporary files  
    public boolean cancel(long id, String reason) {  
            } else {
            removed.cancel(reason);
     */
        }
                    "{} could not be reset as it is already cancelled, previous id [{}]",  
        } catch (Exception e) {
import org.opensearch.common.unit.TimeValue;
        private final long id;
    }  
     * Get target for shard  
        T removed = onGoingTargetEvents.remove(id);
                );  
        private final TimeValue checkInterval;  
        startInternal(target, activityTimeout);
import org.opensearch.index.shard.IndexShard;
        synchronized (onGoingTargetEvents) {
    /**
        if (removed != null) {
    }
        for (T removed : matchedTargets) {
     *
import org.opensearch.common.util.concurrent.AbstractRunnable;
     */
            super(status);
    }  
        private ReplicationMonitor(long id, long lastSeenAccessTime, TimeValue checkInterval) {
                logger.trace("[monitor] no status found for [{}], shutting down", id);
 * This class holds a collection of all on going replication events on the current node (i.e., the node is the target node
                return start(target, activityTimeout);  
                newTarget = (T) oldTarget.retryCopy();
                }
        public ReplicationRef(T status) {
/*  
        }  
    public boolean cancelForShard(ShardId shardId, String reason) {
                startInternal(newTarget, activityTimeout);
        ReplicationRef<T> ref = get(id);  
     *
        }
         */  
    public long start(T target, TimeValue activityTimeout) {
            boolean successfulReset = oldTarget.reset(newTarget.cancellableThreads());  
/*
            ThreadPool.Names.GENERIC
                    true // to be safe, we don't know what go stuck
            if (successfulReset) {
    private void startInternal(T target, TimeValue activityTimeout) {  
    /** the number of ongoing target events */
 * software distributed under the License is distributed on an
        boolean cancelled = false;  
    public void fail(long id, ReplicationFailedException e, boolean sendShardFailure) {  
         * Important: {@link ReplicationTarget#tryIncRef()} should
     * gets the {@link ReplicationTarget } for a given id. The ShardTarget returned has it's ref count already incremented
     * only when the target has closed.
 */
 *
        /**  
     * @param sendShardFailure true a shard failed message should be sent to the master
        synchronized (onGoingTargetEvents) {
import java.util.List;
        assert replicationTargetList.size() <= 1 : "More than one on-going replication targets";
        this.threadPool = threadPool;  
        return onGoingTargetEvents.get(id);
            cancelled = true;
 * specific language governing permissions and limitations
    /** cancel the target with the given id (if found) and remove it from the target collection */
     * cancel all ongoing targets for the given shard
    /**
                cancel(newTarget.getId(), "cancelled during reset");
    public int size() {  
    private final ConcurrentMap<Long, T> onGoingTargetEvents = ConcurrentCollections.newConcurrentMap();
     *  
        if (removed != null) {  
 * GitHub history for details.
        final T newTarget;
                    it.remove();
        }  
            activityTimeout,  
            for (Iterator<T> it = onGoingTargetEvents.values().iterator(); it.hasNext();) {  
     *
import java.util.Iterator;
    }
     */
        return target.getId();  
            logger.trace("[monitor] rescheduling check for [{}]. last access time is [{}]", id, lastSeenAccessTime);  
     * @return ReplicationTarget for input shardId  
     * @return The replication id
        }  
            lastSeenAccessTime = accessTime;
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
            .collect(Collectors.toList());  
        }
                return newTarget;  
     */
    public ReplicationCollection(Logger logger, ThreadPool threadPool) {
            logger.trace("Marking {} as done", removed.description());  
     * a reference to {@link ReplicationTarget}, which implements {@link AutoCloseable}. closing the reference
            removed.cancel(reason);
     */
                .map(ReplicationTarget::shardId)
        @Override
        if (ref == null) {
            // Closes the current target
        T status = onGoingTargetEvents.get(id);  
     * @param target ReplicationTarget to start
     * @return ReplicationTarget list for input shardId  
        }  
            .stream()
                return;  
            return new ReplicationRef<T>(status);
                logger.trace("restarted {}, previous id [{}]", newTarget.description(), oldTarget.getId());
            // fail shard to be safe
     */  
    }
import java.util.concurrent.ConcurrentMap;  
        private volatile long lastSeenAccessTime;
    public ReplicationRef<T> get(long id) {
        logger.trace("started {}", target.description());  
        );
            this.id = id;
        assert ref.get().indexShard().shardId().equals(shardId);
        try {
            if (accessTime == lastSeenAccessTime) {
        for (T value : onGoingTargetEvents.values()) {
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.index.shard.IndexShardClosedException;  
