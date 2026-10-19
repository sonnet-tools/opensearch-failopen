            clusterService.removeListener(this);  
            assert prevEntry.state().completed() : "expected completed snapshot/remote store restore state but was " + prevEntry.state();
    private static final Logger logger = LogManager.getLogger(RestoreClusterStateListener.class);
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.Logger;
 * The OpenSearch Contributors require contributions made to  
        this.actionResponseFactory = actionResponseFactory;
        Function<RestoreInfo, T> actionResponseFactory
/*
import org.opensearch.snapshots.RestoreInfo;
        } else if (newEntry == null) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.index.shard.ShardId;  
}  
            // When there is a cluster-manager failure after a restore has been started, this listener might not be registered  
    }
        RestoreService.RestoreCompletionResponse response,
        this.listener = listener;  
    /**  
            assert RestoreService.completed(shards) : "expected all restore entries to be completed";  
    @Override
     */  
 * specific language governing permissions and limitations
        this.restoreIdentifier = response.getSnapshot() != null ? response.getSnapshot().getSnapshotId().getName() : "remote_store";
 *
 * KIND, either express or implied.  See the License for the
 */  
    private final ClusterService clusterService;  
import org.opensearch.cluster.RestoreInProgress;
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        ActionListener<T> listener,
 */
     * parameter will be called when the restore is complete.
import static org.opensearch.snapshots.RestoreService.restoreInProgress;
import org.opensearch.core.action.ActionResponse;
        RestoreService.RestoreCompletionResponse response,  
import java.util.function.Function;
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
            // Clean up listener in that case and acknowledge completion of restore operation to client.
     * Creates a cluster state listener and registers it with the cluster service. The listener passed as a
 *
 * SPDX-License-Identifier: Apache-2.0
            RestoreInfo ri = new RestoreInfo(
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    private final String restoreIdentifier;
        ClusterService clusterService,
 */  
    private final ActionListener<T> listener;  
package org.opensearch.action.admin.cluster.snapshots.restore;
 * under the License.  
                restoreIdentifier,
        ClusterService clusterService,
/*  
        } else {
        }  
 * license agreements. See the NOTICE file distributed with
    private final String uuid;
 * this work for additional information regarding copyright
    }
 *  
            listener.onResponse(response);  
    public void clusterChanged(ClusterChangedEvent changedEvent) {
/**  
    private RestoreClusterStateListener(  
    ) {  
        final RestoreInProgress.Entry newEntry = restoreInProgress(changedEvent.state(), uuid);
public class RestoreClusterStateListener<T extends ActionResponse> implements ClusterStateListener {
 */
 * @opensearch.internal  
 * Transport listener for cluster state updates
    ) {
        Function<RestoreInfo, T> actionResponseFactory
import org.opensearch.core.action.ActionListener;
            // on the current cluster-manager and as such it might miss some intermediary cluster states due to batching.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.snapshots.RestoreService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            T response = actionResponseFactory.apply(ri);
            logger.debug("restore not completed yet, wait for next cluster state update");
                prevEntry.indices(),  
import org.apache.logging.log4j.LogManager;
            listener.onResponse(actionResponseFactory.apply(null));
        clusterService.addListener(new RestoreClusterStateListener<T>(clusterService, response, listener, actionResponseFactory));
    public static <T extends ActionResponse> void createAndRegisterListener(
    private final Function<RestoreInfo, T> actionResponseFactory;
import java.util.Map;
        this.uuid = response.getUuid();
                shards.size() - RestoreService.failedShards(shards)
        if (prevEntry == null) {
 * compatible open source license.
            logger.debug("restore of [{}] completed", restoreIdentifier);
            clusterService.removeListener(this);  
            final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = prevEntry.shards();
 * software distributed under the License is distributed on an
        this.clusterService = clusterService;  
 * not use this file except in compliance with the License.
 *
    }
        ActionListener<T> listener,  
import org.opensearch.cluster.ClusterStateListener;
            );  
import org.opensearch.cluster.service.ClusterService;  
 * the Apache License, Version 2.0 (the "License"); you may
        final RestoreInProgress.Entry prevEntry = restoreInProgress(changedEvent.previousState(), uuid);  
                shards.size(),
import org.opensearch.cluster.ClusterChangedEvent;  
