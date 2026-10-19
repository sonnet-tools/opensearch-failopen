 *  
@PublicApi(since = "1.0.0")  
     * Should the cluster state result include the {@link org.opensearch.cluster.metadata.Metadata}. Defaults
    public ClusterStateRequestBuilder setBlocks(boolean filter) {
     */  
        return this;
        return this;  
import org.opensearch.action.support.IndicesOptions;
    }
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        return this;
    public ClusterStateRequestBuilder setNodes(boolean filter) {
    /**
    }
    public ClusterStateRequestBuilder(OpenSearchClient client, ClusterStateAction action) {  
     */
     * When {@link #setMetadata(boolean)} is set, which indices to return the {@link org.opensearch.cluster.metadata.IndexMetadata}
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        return this;  
        return this;
    }
    /**
    ClusterStateRequestBuilder> {
    public ClusterStateRequestBuilder setWaitForMetadataVersion(long waitForMetadataVersion) {
        request.waitForTimeout(waitForTimeout);
import org.opensearch.transport.client.OpenSearchClient;
 * specific language governing permissions and limitations
        request.routingTable(filter);  
     * Should the cluster state result include the {@link org.opensearch.cluster.node.DiscoveryNodes}. Defaults
        request.indicesOptions(indicesOptions);
    public ClusterStateRequestBuilder setRoutingTable(boolean filter) {
     */
 *
    }
     * to {@code true}.  
 * ownership. Elasticsearch licenses this file to you under  
    /**
/*  
 * KIND, either express or implied.  See the License for the
    }  
 */  
    /**
 * GitHub history for details.
    public ClusterStateRequestBuilder clear() {  
        request.all();
    public ClusterStateRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.common.unit.TimeValue;
 */
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
        return this;
/*  
 * You may obtain a copy of the License at  
     * to {@code true}.  
    public ClusterStateRequestBuilder setIndices(String... indices) {
        request.metadata(filter);  
     */
        return this;
    public ClusterStateRequestBuilder setCustoms(boolean filter) {
    /**
     * If {@link ClusterStateRequest#waitForMetadataVersion()} is set then this determines how long to wait
 * Unless required by applicable law or agreed to in writing,
     * Should the cluster state result include the {@link org.opensearch.cluster.routing.RoutingTable}. Defaults
    ClusterStateResponse,  
    public ClusterStateRequestBuilder all() {
package org.opensearch.action.admin.cluster.state;
/**
     * Include all data
 */
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * @opensearch.api
     */
 * SPDX-License-Identifier: Apache-2.0
    }
    /**  
     * to {@code true}.  
 */  
    /**
 * compatible open source license.
        return this;
 * The OpenSearch Contributors require contributions made to  
     * Do not include any data
    /**  
     */
     * @param waitForMetadataVersion The metadata version for which to wait
     * Causes the request to wait for the metadata version to advance to at least the given version.
    /**  
        request.blocks(filter);  
     * for. Defaults to all indices.  
 *  
        request.indices(indices);  
        return this;  
 *
     */  
public class ClusterStateRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
    public ClusterStateRequestBuilder setMetadata(boolean filter) {
     * to {@code true}.  
    }
 * under the License.  
     * Should the cluster state result include the {@link org.opensearch.cluster.ClusterState.Custom}. Defaults
 * not use this file except in compliance with the License.
    }
    ClusterStateRequest,
        super(client, action, new ClusterStateRequest());
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
        request.clear();
}
    }
 * Transport request builder for obtaining cluster state
    }
        request.customs(filter);  
        return this;
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.waitForMetadataVersion(waitForMetadataVersion);
import org.opensearch.common.annotation.PublicApi;  
 * the Apache License, Version 2.0 (the "License"); you may
    public ClusterStateRequestBuilder setWaitForTimeOut(TimeValue waitForTimeout) {  
        request.nodes(filter);  
     */
        return this;
