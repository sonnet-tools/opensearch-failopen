 * specific language governing permissions and limitations
    void onNewClusterState(String source, Supplier<ClusterState> clusterStateSupplier, ClusterApplyListener listener);
     * @param clusterState state that has been committed by coordinator to store
 *
 * @opensearch.internal  
        return 0;
     *
/*  
 * license agreements. See the NOTICE file distributed with
 */  
 * You may obtain a copy of the License at  
     * @param clusterStateSupplier the cluster state supplier which provides the latest cluster state to apply
     * @param source information where the cluster state came from  
        /**  
 * GitHub history for details.
         */
         * Called on failure during cluster state application
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
    interface ClusterApplyListener {
 * Interface to monitor when cluster state changes
 * Modifications Copyright OpenSearch Contributors. See
         * @param source information where the cluster state came from
 */  
     */  
     * Listener for results of cluster state application  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
     *
         * @param e exception that occurred  
 *
    /**
    @PublicApi(since = "1.0.0")
 * software distributed under the License is distributed on an
     * @param initialState the initial state to set
 * The OpenSearch Contributors require contributions made to  
    void setInitialState(ClusterState initialState);
     * Sets the initial state for this applier. Should only be called once.
 * not use this file except in compliance with the License.
 *
    }  
     */  
     * Returns the duration in milliseconds of the currently running cluster state application,
 * SPDX-License-Identifier: Apache-2.0
}
import org.opensearch.common.annotation.PublicApi;
     * @opensearch.api
     * @param listener callback that is invoked after cluster state is applied
 * this work for additional information regarding copyright
package org.opensearch.cluster.service;
 * Licensed to Elasticsearch under one or more contributor  
/**  
     */  
    void setPreCommitState(ClusterState clusterState);
 */
        /**  
     */  
    /**  
/*  
     */  
 * under the License.  
    /**  
    }  
     * Method to invoke when a new cluster state is available to be applied
 *  
 * ownership. Elasticsearch licenses this file to you under  
         * Called on successful cluster state application
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * Unless required by applicable law or agreed to in writing,
    default long getCurrentApplicationDurationMs() {
        default void onSuccess(String source) {}
    /**  
         */  
     * or 0 if no application is in progress
 * the Apache License, Version 2.0 (the "License"); you may
        void onFailure(String source, Exception e);
import java.util.function.Supplier;
/*
import org.opensearch.cluster.ClusterState;
     * Sets the pre-commit state for the applier.
public interface ClusterApplier {
         * @param source information where the cluster state came from
