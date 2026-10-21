            if (earlierRerouteNeeded) {
    static final String CLUSTER_UPDATE_TASK_SOURCE = "delayed_allocation_reroute";
                // we need an earlier delayed reroute
    protected void assertClusterOrClusterManagerStateThread() {
import org.opensearch.cluster.ClusterChangedEvent;
    private final Settings settings;
 * compatible open source license.
 * (see {@link AllocationService#disassociateDeadNodes(RoutingAllocation)}.
            removeIfSameTask(this);
                logger.info(
 * This class is responsible for choosing the next (closest) delay expiration of a
            final boolean earlierRerouteNeeded;
            }, nextDelay, ThreadPool.Names.SAME);
        return Settings.builder().put(settings).put(state.metadata().settings()).build();
 * You may obtain a copy of the License at
import org.opensearch.threadpool.ThreadPool;
                logger.trace(
 * not use this file except in compliance with the License.
            }
        final AtomicBoolean cancelScheduling = new AtomicBoolean();
    }
            removeIfSameTask(this);
                public void onFailure(Exception e) {
    private final AllocationService allocationService;
        }
import org.opensearch.cluster.ClusterStateUpdateTask;
        if (event.localNodeClusterManager()) {
 * software distributed under the License is distributed on an
 *
                protected void doRun() throws Exception {
                earlierRerouteNeeded = false;
                    "scheduling reroute for delayed shards in [{}] ({} delayed shards)",
import java.util.concurrent.atomic.AtomicReference;
                logger.trace("no need to reschedule delayed reroute - currently scheduled delayed reroute in [{}] is enough", nextDelay);
        @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (oldState == newState) {
            }
    @Inject
            this.nextDelay = nextDelay;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * represents a delayed scheduling of the reroute action that can be cancelled.
            return baseTimestampNanos + nextDelay.nanos();
 * The actual removal of the delay marker happens in
                    nextDelay,
        }
    AtomicReference<DelayedRerouteTask> delayedRerouteTask = new AtomicReference<>(); // package private to access from tests
                // no state changed, check when we should remove the delay flag from the shards the next time.
            long currentNanoTime = currentNanoTime();
    class DelayedRerouteTask extends ClusterStateUpdateTask {
        delayedRerouteTask.compareAndSet(expectedTask, null);
    /** override this to control time based decisions during delayed allocation */
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.service.ClusterService;
    protected void doStart() {}
import org.opensearch.cluster.routing.allocation.AllocationService;
public class DelayedAllocationService extends AbstractLifecycleComponent implements ClusterStateListener {
package org.opensearch.cluster.routing;
        return System.nanoTime();
        public void cancelScheduling() {
                    TimeValue.timeValueNanos(existingTask.scheduledTimeToRunInNanos() - newTask.scheduledTimeToRunInNanos())
 * {@link AllocationService#removeDelayMarkers(RoutingAllocation)}, triggering yet
import org.opensearch.cluster.node.DiscoveryNode;
            logger.trace("cancelling existing delayed reroute task");
import org.opensearch.cluster.ClusterState;
                    }
 * ownership. Elasticsearch licenses this file to you under
 * and which were assigned the delay marker based on the index delay setting
    private final ClusterService clusterService;
    }
    private void removeTaskAndCancel() {
                cancellable.cancel();
    }
        }
import org.opensearch.common.unit.TimeValue;
                    clusterService.submitStateUpdateTask(CLUSTER_UPDATE_TASK_SOURCE, DelayedRerouteTask.this);
 * Modifications Copyright OpenSearch Contributors. See
        assert ClusterService.assertClusterOrClusterManagerStateThread();
        volatile Scheduler.Cancellable cancellable;
            } else if (newTask.scheduledTimeToRunInNanos() < existingTask.scheduledTimeToRunInNanos()) {
        DelayedRerouteTask existingTask = delayedRerouteTask.getAndSet(null);
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
 */
 * GitHub history for details.
            }
                earlierRerouteNeeded = true;
                    UnassignedInfo.getNumberOfDelayedUnassigned(state)
 * KIND, either express or implied.  See the License for the
    /**
                earlierRerouteNeeded = true;
    protected void doStop() {}
        if (existingTask != null) {
    }
    @Override
            removeTaskAndCancel();
        }
    }
            clusterService.addListener(this);
        public ClusterState execute(ClusterState currentState) throws Exception {
            this.baseTimestampNanos = baseTimestampNanos;
 * {@link UnassignedInfo#INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING} or the cluster-level delayed node-left timeout
                @Override
            DelayedRerouteTask newTask = new DelayedRerouteTask(nextDelay, currentNanoTime);
            } else {
            return allocationService.reroute(currentState, "assign delayed unassigned shards");
            logger.trace("no need to schedule reroute - no delayed unassigned shards");
 * if there are unassigned shards with delayed allocation (unassigned shards that have
        final long baseTimestampNanos; // timestamp (in nanos) upon which delay was calculated
            DelayedRerouteTask existingTask = delayedRerouteTask.get();
    /**
        }
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
import org.apache.logging.log4j.Logger;
            cancellable = threadPool.schedule(new AbstractRunnable() {
        public long scheduledTimeToRunInNanos() {
        this.threadPool = threadPool;
 */
    public void clusterChanged(ClusterChangedEvent event) {
     * Figure out if an existing scheduled reroute is good enough or whether we need to cancel and reschedule.
import org.opensearch.common.util.concurrent.AbstractRunnable;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            existingTask.cancelScheduling();
    }
                }
 * another cluster change event.
                assert existingTask == currentTask || currentTask == null;
            scheduleIfNeeded(currentNanoTime, event.state());
                @Override
 *
            TimeValue nextDelay = TimeValue.timeValueNanos(nextDelayNanos);
        }
            if (cancellable != null) {
        }
                scheduleIfNeeded(currentNanoTime(), newState);
import org.opensearch.cluster.ClusterStateListener;
                );
    @Override
    // protected so that it can be overridden (and disabled) by unit tests
/*
/*
 *
            removeIfSameTask(this);
        if (DiscoveryNode.isClusterManagerNode(settings)) {
                    removeIfSameTask(DelayedRerouteTask.this);
 * this file be licensed under the Apache-2.0 license or a
                }
            logger.warn("failed to schedule/execute reroute post unassigned shard", e);
        removeTaskAndCancel();
                // if cluster state changed, we can leave the scheduling of the next delay up to the clusterChangedEvent
    @Override
    private static final Logger logger = LogManager.getLogger(DelayedAllocationService.class);
                // this should not be needed, but we want to be extra safe here
/**
        public void onFailure(String source, Exception e) {
    @Override
    }
        clusterService.removeListener(this);
                    logger.warn("failed to submit schedule/execute reroute post unassigned shard", e);
        this.allocationService = allocationService;
    }
 * Unless required by applicable law or agreed to in writing,
    protected long currentNanoTime() {
            }
 * delayed shard to schedule a reroute to remove the delay marker.
            cancelScheduling.set(true);
                existingTask.cancelScheduling();
import java.util.concurrent.atomic.AtomicBoolean;
        assertClusterOrClusterManagerStateThread();
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        final TimeValue nextDelay; // delay until submitting the reroute command
        public void schedule() {
        }
    private void removeIfSameTask(DelayedRerouteTask expectedTask) {
                );
     */
        } else {
import org.opensearch.threadpool.Scheduler;
 * license agreements. See the NOTICE file distributed with
    private Settings clusterSettings(ClusterState state) {
        this.clusterService = clusterService;
        }
/*
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        }
                    "cancelling existing delayed reroute task as delayed reroute has to happen [{}] earlier",
 * specific language governing permissions and limitations
    }
 *
 */
        this.settings = clusterService.getSettings();
    private synchronized void scheduleIfNeeded(long currentNanoTime, ClusterState state) {
            if (existingTask == null) {
                    if (cancelScheduling.get()) {
 * the delay marker). These are shards that have become unassigned due to a node leaving
        }
                DelayedRerouteTask currentTask = delayedRerouteTask.getAndSet(newTask);
import org.opensearch.common.inject.Inject;
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
}
        @Override
    public DelayedAllocationService(ThreadPool threadPool, ClusterService clusterService, AllocationService allocationService) {
    final ThreadPool threadPool;
            } else {
                newTask.schedule();
 * Licensed to Elasticsearch under one or more contributor
                        return;
     */
 */
    protected void doClose() {
import org.opensearch.common.settings.Settings;
        DelayedRerouteTask(TimeValue nextDelay, long baseTimestampNanos) {
        if (nextDelayNanos < 0) {
    }
 * The {@link DelayedAllocationService} listens to cluster state changes and checks
        long nextDelayNanos = UnassignedInfo.findNextDelayedAllocation(currentNanoTime, state, clusterSettings(state));
