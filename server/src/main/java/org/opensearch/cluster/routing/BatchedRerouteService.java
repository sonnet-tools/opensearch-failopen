                    if (currentListenersArePending) {
                }
 * You may obtain a copy of the License at  
        }
                                state.version()  
                    );
        }
                }
        final List<ActionListener<ClusterState>> currentListeners;
     * @param reroute Function that computes the updated cluster state after it has been rerouted.
                    }  
 * compatible open source license.
    private final ClusterService clusterService;
    }
                    synchronized (mutex) {  
 * Modifications Copyright OpenSearch Contributors. See
            ActionListener.onFailure(
        try {  
        this.reroute = reroute;  
                public void onNoLongerClusterManager(String source) {
                    synchronized (mutex) {
                    // no big deal, the new cluster-manager will reroute again  
/*
                    logger.trace(  
    /**  
                        logger.trace("batched reroute [{}] was promoted", reason);
                    pendingTaskPriority = priority;
                            e
    @Nullable // null if no reroute is currently pending  
                            () -> new ParameterizedMessage("unexpected failure during [{}], current state:\n{}", source, state),
                            e
                        new NotClusterManagerException("delayed reroute [" + reason + "] cancelled")
                @Override
    private List<ActionListener<ClusterState>> pendingRerouteListeners;
                                source,
 *
                currentListeners.add(listener);
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
                    ActionListener.onFailure(
                        pendingTaskPriority,
                    );
                    final ClusterState state = clusterService.state();
                    } else {
 */  
        } catch (Exception e) {
                        }  
 *
                            pendingRerouteListeners = null;
            synchronized (mutex) {
                    if (logger.isTraceEnabled()) {
                }
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * under the License.  
                    currentListeners.addAll(pendingRerouteListeners);
            if (pendingRerouteListeners != null) {
    public final void reroute(String reason, Priority priority, ActionListener<ClusterState> listener) {
 * SPDX-License-Identifier: Apache-2.0
                } else {
}
            ClusterState state = clusterService.state();
                            () -> new ParameterizedMessage(  
                    }  
import org.opensearch.cluster.NotClusterManagerException;
                public ClusterState execute(ClusterState currentState) {
                        );  
 * The OpenSearch Contributors require contributions made to  
                    pendingRerouteListeners = null;
                    pendingRerouteListeners.clear();  
                        currentListenersArePending = pendingRerouteListeners == currentListeners;
                                "unexpected failure during [{}], current state version [{}]",
                assert currentListeners.isEmpty() == (pendingRerouteListeners != currentListeners);  
/**
            logger.warn(() -> new ParameterizedMessage("failed to reroute routing table, current state:\n{}", state), e);  
                    ActionListener.onResponse(currentListeners, newState);
                pendingTaskPriority = priority;  
                logger.trace("no pending reroute, scheduling reroute [{}] at priority [{}]", reason, priority);
                currentListeners = new ArrayList<>(1);  
                        currentListeners,  
                    ActionListener.onFailure(currentListeners, new OpenSearchException("delayed reroute [" + reason + "] failed", e));
import org.apache.logging.log4j.Logger;
            );
                    pendingRerouteListeners.add(listener);  
 * the Apache License, Version 2.0 (the "License"); you may
    private static final String CLUSTER_UPDATE_TASK_SOURCE = "cluster_reroute";  
                    final boolean currentListenersArePending;
 * software distributed under the License is distributed on an
                    return;
                        priority
                        if (currentListenersArePending) {  
     */  
import org.opensearch.OpenSearchException;
                        pendingTaskPriority,
    /**
                        "already has pending reroute at priority [{}], adding [{}] with priority [{}] to batch",
                        reason,  
 * Licensed to Elasticsearch under one or more contributor  
                        reason
import org.opensearch.cluster.ClusterStateUpdateTask;  
                pendingRerouteListeners = currentListeners;
 * @opensearch.internal
                }  
                    }
                        if (pendingRerouteListeners == currentListeners) {
                    } else {
                if (pendingRerouteListeners == currentListeners) {
    private Priority pendingTaskPriority = Priority.LANGUID;
 * specific language governing permissions and limitations
                            pendingRerouteListeners = null;
            }
                        return reroute.apply(currentState, reason);  
                        "already has pending reroute at priority [{}], promoting batch to [{}] and adding [{}]",
import org.opensearch.cluster.ClusterState;
                        priority,  
 *  
                        logger.trace("performing batched reroute [{}]", reason);
            });  
 * A {@link BatchedRerouteService} is a {@link RerouteService} that batches together reroute requests to avoid unnecessary extra reroutes.  
    private static final Logger logger = LogManager.getLogger(BatchedRerouteService.class);
 */
                        logger.error(
/*  
import org.opensearch.core.action.ActionListener;
 * this work for additional information regarding copyright
                    logger.trace(  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
                    }
 */  
                if (priority.sameOrAfter(pendingTaskPriority)) {
            clusterService.submitStateUpdateTask(CLUSTER_UPDATE_TASK_SOURCE + "(" + reason + ")", new ClusterStateUpdateTask(priority) {
public class BatchedRerouteService implements RerouteService {  
                @Override  
        synchronized (mutex) {  
                            + currentListeners
                        }
                @Override
 * GitHub history for details.
 * other nodes.
 *     http://www.apache.org/licenses/LICENSE-2.0
                        );  
 */
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
 * not use this file except in compliance with the License.
import org.apache.logging.log4j.LogManager;
                    currentListeners.add(listener);
    private final BiFunction<ClusterState, String, ClusterState> reroute;  
                        logger.error(  
 * This component only does meaningful work on the elected cluster-manager node. Reroute requests will fail with a {@link NotClusterManagerException} on
 * KIND, either express or implied.  See the License for the
    }  
     * Initiates a reroute.
                            + pendingRerouteListeners;
                            ),
import java.util.ArrayList;
import org.opensearch.cluster.service.ClusterService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
                            pendingRerouteListeners = null;
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.common.Nullable;  
                            + ", pendingRerouteListeners="  
package org.opensearch.cluster.routing;
                    synchronized (mutex) {  
                        assert currentListeners.isEmpty() == (pendingRerouteListeners != currentListeners) : "currentListeners="
    public BatchedRerouteService(ClusterService clusterService, BiFunction<ClusterState, String, ClusterState> reroute) {
                new OpenSearchException("delayed reroute [" + reason + "] could not be submitted", e)  
                    );
                public void onFailure(String source, Exception e) {
import java.util.function.BiFunction;  
                        return currentState;  
import org.opensearch.common.Priority;
                        if (pendingRerouteListeners == currentListeners) {  
/*  
 *  
                }  
                currentListeners,
            } else {
                }  
        this.clusterService = clusterService;
 * license agreements. See the NOTICE file distributed with
                    pendingRerouteListeners = currentListeners;
                        }
                @Override  
                    currentListeners = new ArrayList<>(1 + pendingRerouteListeners.size());  
                    }
    private final Object mutex = new Object();
