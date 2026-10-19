 * under the License.  
 */  
            if (existingTask == null) {
    @Override
    private static final Logger logger = LogManager.getLogger(DelayedAllocationService.class);
    protected long currentNanoTime() {
                // if cluster state changed, we can leave the scheduling of the next delay up to the clusterChangedEvent
                // no state changed, check when we should remove the delay flag from the shards the next time.  
        assertClusterOrClusterManagerStateThread();  
        final AtomicBoolean cancelScheduling = new AtomicBoolean();
public class DelayedAllocationService extends AbstractLifecycleComponent implements ClusterStateListener {
                // this should not be needed, but we want to be extra safe here
    @Override
        }
 * {@link AllocationService#removeDelayMarkers(RoutingAllocation)}, triggering yet
    protected void doStop() {}
        assert ClusterService.assertClusterOrClusterManagerStateThread();  
            DelayedRerouteTask newTask = new DelayedRerouteTask(nextDelay, currentNanoTime);  
                assert existingTask == currentTask || currentTask == null;
                );
        }
    public DelayedAllocationService(ThreadPool threadPool, ClusterService clusterService, AllocationService allocationService) {  
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.LogManager;
            cancelScheduling.set(true);
import org.opensearch.cluster.ClusterChangedEvent;  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
            if (earlierRerouteNeeded) {  
import org.opensearch.threadpool.Scheduler;
 * and which were assigned the delay marker based on the index delay setting
        } else {
        clusterService.removeListener(this);  
            removeIfSameTask(this);  
 * compatible open source license.
    final ThreadPool threadPool;  
 *  
        @Override  
    }  
                DelayedRerouteTask currentTask = delayedRerouteTask.getAndSet(newTask);  
        }
            final boolean earlierRerouteNeeded;
            TimeValue nextDelay = TimeValue.timeValueNanos(nextDelayNanos);  
        removeTaskAndCancel();
                // we need an earlier delayed reroute
                    "cancelling existing delayed reroute task as delayed reroute has to happen [{}] earlier",  
                earlierRerouteNeeded = false;  
    /**
        if (event.localNodeClusterManager()) {
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    AtomicReference<DelayedRerouteTask> delayedRerouteTask = new AtomicReference<>(); // package private to access from tests
        }  
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            return allocationService.reroute(currentState, "assign delayed unassigned shards");  
 * Licensed to Elasticsearch under one or more contributor  
            logger.warn("failed to schedule/execute reroute post unassigned shard", e);
            } else {
 * GitHub history for details.
            }
            removeIfSameTask(this);  
import org.opensearch.cluster.routing.allocation.AllocationService;
                protected void doRun() throws Exception {  
    protected void assertClusterOrClusterManagerStateThread() {
            if (cancellable != null) {  
     * Figure out if an existing scheduled reroute is good enough or whether we need to cancel and reschedule.  
        volatile Scheduler.Cancellable cancellable;
 * specific language governing permissions and limitations
        }
    }
    // protected so that it can be overridden (and disabled) by unit tests
    }
        final long baseTimestampNanos; // timestamp (in nanos) upon which delay was calculated  
            }
                }
                    TimeValue.timeValueNanos(existingTask.scheduledTimeToRunInNanos() - newTask.scheduledTimeToRunInNanos())
import org.opensearch.cluster.ClusterStateUpdateTask;  
                    logger.warn("failed to submit schedule/execute reroute post unassigned shard", e);  
import org.opensearch.cluster.node.DiscoveryNode;
                earlierRerouteNeeded = true;
                public void onFailure(Exception e) {
     * represents a delayed scheduling of the reroute action that can be cancelled.
        }
                }
                );
            scheduleIfNeeded(currentNanoTime, event.state());
            return baseTimestampNanos + nextDelay.nanos();
        public ClusterState execute(ClusterState currentState) throws Exception {
 *
            this.nextDelay = nextDelay;
 */  
            if (oldState == newState) {
 * the delay marker). These are shards that have become unassigned due to a node leaving
    private final AllocationService allocationService;
    protected void doClose() {
import org.opensearch.common.settings.Settings;
        @Override  
        this.allocationService = allocationService;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return Settings.builder().put(settings).put(state.metadata().settings()).build();
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ClusterStateListener;
                earlierRerouteNeeded = true;
            }
        }
 */  
        this.clusterService = clusterService;
        this.settings = clusterService.getSettings();
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
                        return;
/*  
 * delayed shard to schedule a reroute to remove the delay marker.  
            existingTask.cancelScheduling();  
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
 * @opensearch.internal
        public void cancelScheduling() {
    }
    public void clusterChanged(ClusterChangedEvent event) {
import java.util.concurrent.atomic.AtomicBoolean;
    }  
    private void removeIfSameTask(DelayedRerouteTask expectedTask) {
 * The {@link DelayedAllocationService} listens to cluster state changes and checks
                    clusterService.submitStateUpdateTask(CLUSTER_UPDATE_TASK_SOURCE, DelayedRerouteTask.this);
        public void schedule() {  
 */
    }  
            clusterService.addListener(this);  
                logger.info(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                logger.trace(
    private final Settings settings;  
    }
        if (DiscoveryNode.isClusterManagerNode(settings)) {
        }
        if (existingTask != null) {
        final TimeValue nextDelay; // delay until submitting the reroute command
 *
                @Override
    }
    private final ClusterService clusterService;
        this.threadPool = threadPool;
            } else {  
/*
 *
        DelayedRerouteTask existingTask = delayedRerouteTask.getAndSet(null);  
 * ownership. Elasticsearch licenses this file to you under  
    static final String CLUSTER_UPDATE_TASK_SOURCE = "delayed_allocation_reroute";
            cancellable = threadPool.schedule(new AbstractRunnable() {
                scheduleIfNeeded(currentNanoTime(), newState);  
                @Override
 * this work for additional information regarding copyright
import org.opensearch.threadpool.ThreadPool;
                    }  
            DelayedRerouteTask existingTask = delayedRerouteTask.get();
        public long scheduledTimeToRunInNanos() {  
/**
        public void onFailure(String source, Exception e) {
 * The actual removal of the delay marker happens in
    private void removeTaskAndCancel() {
 * This class is responsible for choosing the next (closest) delay expiration of a
import org.opensearch.cluster.service.ClusterService;
    /** override this to control time based decisions during delayed allocation */
    @Inject
}
                logger.trace("no need to reschedule delayed reroute - currently scheduled delayed reroute in [{}] is enough", nextDelay);
 * SPDX-License-Identifier: Apache-2.0
    private synchronized void scheduleIfNeeded(long currentNanoTime, ClusterState state) {
                    removeIfSameTask(DelayedRerouteTask.this);
import java.util.concurrent.atomic.AtomicReference;
        }
import org.opensearch.common.unit.TimeValue;
            removeTaskAndCancel();
                    UnassignedInfo.getNumberOfDelayedUnassigned(state)
                cancellable.cancel();
    class DelayedRerouteTask extends ClusterStateUpdateTask {
/*  
 * not use this file except in compliance with the License.
            logger.trace("no need to schedule reroute - no delayed unassigned shards");  
        DelayedRerouteTask(TimeValue nextDelay, long baseTimestampNanos) {
 * software distributed under the License is distributed on an
    @Override
    }
    protected void doStart() {}
                newTask.schedule();
            } else if (newTask.scheduledTimeToRunInNanos() < existingTask.scheduledTimeToRunInNanos()) {  
 * {@link UnassignedInfo#INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING} or the cluster-level delayed node-left timeout  
 * another cluster change event.  
        if (nextDelayNanos < 0) {
        return System.nanoTime();  
            removeIfSameTask(this);
            }, nextDelay, ThreadPool.Names.SAME);  
     */  
            logger.trace("cancelling existing delayed reroute task");
    private Settings clusterSettings(ClusterState state) {  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
 * if there are unassigned shards with delayed allocation (unassigned shards that have  
        delayedRerouteTask.compareAndSet(expectedTask, null);
import org.apache.logging.log4j.Logger;
package org.opensearch.cluster.routing;
            }
 * The OpenSearch Contributors require contributions made to  
     */
        }
                    "scheduling reroute for delayed shards in [{}] ({} delayed shards)",
                    if (cancelScheduling.get()) {
    /**
                existingTask.cancelScheduling();  
import org.opensearch.common.inject.Inject;
                    nextDelay,  
        long nextDelayNanos = UnassignedInfo.findNextDelayedAllocation(currentNanoTime, state, clusterSettings(state));
        @Override
            this.baseTimestampNanos = baseTimestampNanos;  
 * (see {@link AllocationService#disassociateDeadNodes(RoutingAllocation)}.
            long currentNanoTime = currentNanoTime();  
    @Override  
 * license agreements. See the NOTICE file distributed with
        }
