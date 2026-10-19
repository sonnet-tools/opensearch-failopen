    /**
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
    void onFailure(String source, Exception e);
     * called when the task was rejected because the local node is no longer cluster-manager.
 * license agreements. See the NOTICE file distributed with
     */
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
/*
 *
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
 */
 */  
 * compatible open source license.
        onFailure(source, new NotClusterManagerException("no longer cluster-manager. source: [" + source + "]"));
    /**  
     * Called when the result of the {@link ClusterStateTaskExecutor#execute(ClusterState, List)} have been processed  
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")
 *
 *
     * A callback called when execute fails.
 * SPDX-License-Identifier: Apache-2.0
 *  
 */
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
     * properly by all listeners.
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * GitHub history for details.
import java.util.List;  
    default void onNoLongerClusterManager(String source) {
     */  
/*  
import org.opensearch.cluster.service.ClusterManagerService;  
    default void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
     */  
public interface ClusterStateTaskListener {
package org.opensearch.cluster;
/*
 * under the License.  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Used only for tasks submitted to {@link ClusterManagerService}.
/**
}
 * specific language governing permissions and limitations
 * Interface to implement a cluster state change listener  
 */  
