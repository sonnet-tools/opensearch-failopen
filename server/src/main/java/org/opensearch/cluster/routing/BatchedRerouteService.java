                pendingTaskPriority = priority;
 * software distributed under the License is distributed on an
 * other nodes.
    /**
                        logger.trace("performing batched reroute [{}]", reason);
                        logger.error(
import org.opensearch.cluster.ClusterState;
                                "unexpected failure during [{}], current state version [{}]",
                    synchronized (mutex) {
                        }
                        "already has pending reroute at priority [{}], promoting batch to [{}] and adding [{}]",
        } catch (Exception e) {
                    ActionListener.onFailure(
import org.opensearch.common.Priority;
public class BatchedRerouteService implements RerouteService {
                        pendingTaskPriority,
import org.opensearch.cluster.service.ClusterService;
 *
    /**
     */
    }
                    currentListeners = new ArrayList<>(1 + pendingRerouteListeners.size());
                                source,
        }
        synchronized (mutex) {
 * ownership. Elasticsearch licenses this file to you under
                    }
                        }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.ClusterStateUpdateTask;
                currentListeners = new ArrayList<>(1);
    private static final Logger logger = LogManager.getLogger(BatchedRerouteService.class);
import org.opensearch.core.action.ActionListener;
                currentListeners,
                @Override
                public ClusterState execute(ClusterState currentState) {
                            pendingRerouteListeners = null;
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
                    pendingRerouteListeners = null;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
                @Override
 *
                    }
            clusterService.submitStateUpdateTask(CLUSTER_UPDATE_TASK_SOURCE + "(" + reason + ")", new ClusterStateUpdateTask(priority) {
                public void onNoLongerClusterManager(String source) {
    @Nullable // null if no reroute is currently pending
 *     http://www.apache.org/licenses/LICENSE-2.0
    public BatchedRerouteService(ClusterService clusterService, BiFunction<ClusterState, String, ClusterState> reroute) {
import org.opensearch.common.Nullable;
 *
 * this file be licensed under the Apache-2.0 license or a
}
     * @param reroute Function that computes the updated cluster state after it has been rerouted.
        this.reroute = reroute;
    private static final String CLUSTER_UPDATE_TASK_SOURCE = "cluster_reroute";
                }
                }
                        if (currentListenersArePending) {
                            () -> new ParameterizedMessage("unexpected failure during [{}], current state:\n{}", source, state),
 * compatible open source license.
 * This component only does meaningful work on the elected cluster-manager node. Reroute requests will fail with a {@link NotClusterManagerException} on
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        reason,
                    }
                        );
                            + currentListeners
 */
                    );
                pendingRerouteListeners = currentListeners;
 */
 * GitHub history for details.
                }
                    ActionListener.onFailure(currentListeners, new OpenSearchException("delayed reroute [" + reason + "] failed", e));
            synchronized (mutex) {
                        );
                    final boolean currentListenersArePending;
            }
     */
                        priority
                @Override
                        pendingTaskPriority,
                        reason
 * KIND, either express or implied.  See the License for the
                    }
                    if (logger.isTraceEnabled()) {
 */
 * @opensearch.internal
    private Priority pendingTaskPriority = Priority.LANGUID;
/*
                    } else {
            } else {
                new OpenSearchException("delayed reroute [" + reason + "] could not be submitted", e)
                        if (pendingRerouteListeners == currentListeners) {
                        logger.error(
                    currentListeners.addAll(pendingRerouteListeners);
                    );
import java.util.ArrayList;
                        "already has pending reroute at priority [{}], adding [{}] with priority [{}] to batch",
                                state.version()
                    );
import org.apache.logging.log4j.LogManager;
                    logger.trace(
import org.apache.logging.log4j.Logger;
                    pendingRerouteListeners.clear();
                    final ClusterState state = clusterService.state();
                            e
                    logger.trace(
                    ActionListener.onResponse(currentListeners, newState);
 *
    private final ClusterService clusterService;
                    }
                    } else {
            }
 */
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.NotClusterManagerException;
            if (pendingRerouteListeners != null) {
                            ),
                currentListeners.add(listener);
     * Initiates a reroute.
            });
 * Licensed to Elasticsearch under one or more contributor
                    // no big deal, the new cluster-manager will reroute again
import org.opensearch.OpenSearchException;
 * SPDX-License-Identifier: Apache-2.0
        try {
                logger.trace("no pending reroute, scheduling reroute [{}] at priority [{}]", reason, priority);
                        assert currentListeners.isEmpty() == (pendingRerouteListeners != currentListeners) : "currentListeners="
                    pendingRerouteListeners = currentListeners;
        this.clusterService = clusterService;
/**
                    if (currentListenersArePending) {
        final List<ActionListener<ClusterState>> currentListeners;
                        currentListeners,
                }
                    synchronized (mutex) {
            logger.warn(() -> new ParameterizedMessage("failed to reroute routing table, current state:\n{}", state), e);
                    currentListeners.add(listener);
                        return currentState;
                        return reroute.apply(currentState, reason);
                        logger.trace("batched reroute [{}] was promoted", reason);
                public void onFailure(String source, Exception e) {
import org.apache.logging.log4j.message.ParameterizedMessage;
            ClusterState state = clusterService.state();
            ActionListener.onFailure(
    }
                @Override
        }
                            + ", pendingRerouteListeners="
                            e
                }
package org.opensearch.cluster.routing;
    private final Object mutex = new Object();
                    pendingTaskPriority = priority;
                if (priority.sameOrAfter(pendingTaskPriority)) {
    private List<ActionListener<ClusterState>> pendingRerouteListeners;
                            () -> new ParameterizedMessage(
 * under the License.
                        currentListenersArePending = pendingRerouteListeners == currentListeners;
                assert currentListeners.isEmpty() == (pendingRerouteListeners != currentListeners);
 * A {@link BatchedRerouteService} is a {@link RerouteService} that batches together reroute requests to avoid unnecessary extra reroutes.
 * not use this file except in compliance with the License.
                        }
 * Modifications Copyright OpenSearch Contributors. See
    public final void reroute(String reason, Priority priority, ActionListener<ClusterState> listener) {
 * specific language governing permissions and limitations
                    synchronized (mutex) {
                }
                        new NotClusterManagerException("delayed reroute [" + reason + "] cancelled")
                            pendingRerouteListeners = null;
import java.util.function.BiFunction;
                    pendingRerouteListeners.add(listener);
                if (pendingRerouteListeners == currentListeners) {
                            + pendingRerouteListeners;
            );
                        priority,
    private final BiFunction<ClusterState, String, ClusterState> reroute;
                            pendingRerouteListeners = null;
                } else {
/*
    @Override
                        if (pendingRerouteListeners == currentListeners) {
 * this work for additional information regarding copyright
/*
                    return;
