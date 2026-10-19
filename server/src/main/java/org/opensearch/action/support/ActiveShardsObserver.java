    ) {  
 * Unless required by applicable law or agreed to in writing,
                    onFailure.accept(new NodeClosedException(clusterService.localNode()));
    }
                public void onTimeout(TimeValue timeout) {
                public void onNewClusterState(ClusterState state) {  
        if (activeShardCount == ActiveShardCount.NONE) {  
     */
 * this file be licensed under the Apache-2.0 license or a
     *
import org.apache.logging.log4j.LogManager;
 * software distributed under the License is distributed on an
 * @opensearch.internal
import java.util.function.Consumer;  
 *
                    onResult.accept(false);  
 * compatible open source license.
    /**  
            final Predicate<ClusterState> shardsAllocatedPredicate = newState -> activeShardCount.enoughShardsActive(newState, indexNames);
    private static final Logger logger = LogManager.getLogger(ActiveShardsObserver.class);
            observer.waitForNextChange(observerListener, shardsAllocatedPredicate, timeout);
    public void waitForActiveShards(  
/*  
                }
}
 */
import org.opensearch.common.unit.TimeValue;  
 *  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
     * @param activeShardCount the number of active shards to wait on before returning
 * KIND, either express or implied.  See the License for the
 * to become active before sending a response on an {@link ActionListener}.
                    logger.debug("[{}] cluster service closed while waiting for enough shards to be started.", Arrays.toString(indexNames));  
            return;  
                @Override
 */  
 * Licensed to Elasticsearch under one or more contributor  
            onResult.accept(true);  
                    onResult.accept(true);
        final Consumer<Exception> onFailure
import org.opensearch.cluster.service.ClusterService;
 * under the License.  
import java.util.Arrays;
        } else {
import java.util.function.Predicate;
        this.clusterService = clusterService;
    private final ThreadPool threadPool;
 * specific language governing permissions and limitations
import org.apache.logging.log4j.Logger;
 * Modifications Copyright OpenSearch Contributors. See
        final Consumer<Boolean> onResult,
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final ActiveShardCount activeShardCount,
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
                public void onClusterServiceClose() {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
     * @param onFailure a function that is executed in response to an error occurring during waiting for the active shards
        final ClusterState state = clusterService.state();  
                }
 *  
        final ClusterStateObserver observer = new ClusterStateObserver(state, clusterService, null, logger, threadPool.getThreadContext());
        }
/*
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.cluster.ClusterState;  
package org.opensearch.action.support;
public class ActiveShardsObserver {  
            };
 * not use this file except in compliance with the License.
            onResult.accept(true);
     * @param onResult a function that is executed in response to the requisite shards becoming active or a timeout (whichever comes first)  
                @Override
     * @param indexNames the indices to wait for active shards on  
    private final ClusterService clusterService;
import org.opensearch.node.NodeClosedException;
 */
    public ActiveShardsObserver(final ClusterService clusterService, final ThreadPool threadPool) {
                }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.ClusterStateObserver;
     * @param timeout the timeout value
        // wait for the configured number of active shards to be allocated before executing the result consumer
/*  
 */  
            final ClusterStateObserver.Listener observerListener = new ClusterStateObserver.Listener() {
        if (activeShardCount.enoughShardsActive(state, indexNames)) {
        }
     * Waits on the specified number of active shards to be started before executing the
        this.threadPool = threadPool;  
        final String[] indexNames,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;  
        final TimeValue timeout,  
 * This class provides primitives for waiting for a configured number of shards
                @Override
/**  
            // not waiting, so just run whatever we were to run when the waiting is
