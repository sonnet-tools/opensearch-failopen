    }
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
    }
        request.timeout(timeout);
        request.setApplyLevelAtTransportLayer(applyLevelAtTransportLayer);
     */
    /**
 * not use this file except in compliance with the License.
    /**
    }  
        request.waitForActiveShards(waitForActiveShards);
 * You may obtain a copy of the License at  
        return this;
     * {@link ActiveShardCount#from(int)} to set this value to any non-negative integer, up to the  
        return this;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ClusterHealthRequestBuilder setWaitForNodes(String waitForNodes) {
        request.waitForNoInitializingShards(waitForNoInitializingShards);  
 * specific language governing permissions and limitations
        return this;
    /**  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;  
import org.opensearch.common.unit.TimeValue;
        super(client, action, new ClusterHealthRequest());
 */
     * to get the ActiveShardCount.
    }  
        return this;
     * Sets whether the request should wait for there to be no relocating shards before
 * the Apache License, Version 2.0 (the "License"); you may
        request.setAwarenessAttribute(awarenessAttribute);
@PublicApi(since = "1.0.0")  
 * under the License.  
            request.waitForActiveShards(ActiveShardCount.NONE);  
     */
        return this;
        request.setLevel(level);  
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}  
     * Sets the number of shard copies that must be active before getting the health status.
 * software distributed under the License is distributed on an
        return this;  
        request.waitForEvents(waitForEvents);
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
     * operation does not wait on there being no more initializing shards.  Set to <code>true</code>
     * all replicas) to be active across all indices in the cluster. Otherwise, use
     * to wait until the number of relocating shards in the cluster is 0.
    public ClusterHealthRequestBuilder setWaitForGreenStatus() {
            // the default for cluster health is 0, not 1
package org.opensearch.action.admin.cluster.health;
    ClusterHealthRequestBuilder> {
    }  
    }
        request.indices(indices);
     * Waits for N number of nodes. Use "12" for exact mapping, "&gt;12" and "&lt;12" for range.  
     */
        request.waitForNodes(waitForNodes);  
    public ClusterHealthRequestBuilder setIndicesOptions(final IndicesOptions indicesOptions) {  
    public ClusterHealthRequestBuilder setWaitForStatus(ClusterHealthStatus waitForStatus) {  
import org.opensearch.cluster.health.ClusterHealthStatus;
    }
    public ClusterHealthRequestBuilder setWaitForEvents(Priority waitForEvents) {
        } else {
        return this;
 *
    public ClusterHealthRequestBuilder setWaitForNoRelocatingShards(boolean waitForRelocatingShards) {  
}
        return this;
 * @opensearch.api
        return this;
import org.opensearch.transport.client.OpenSearchClient;
     * total number of shard copies that would exist across all indices in the cluster.
import org.opensearch.action.support.IndicesOptions;
    ClusterHealthRequest,
 * SPDX-License-Identifier: Apache-2.0
    public ClusterHealthRequestBuilder setWaitForYellowStatus() {
     * retrieving the cluster health status.  Defaults to <code>false</code>, meaning the
 *  
     * Set this value to {@link ActiveShardCount#ALL} to wait for all shards (primary and
        return this;  
 * Modifications Copyright OpenSearch Contributors. See
 * Builder for requesting cluster health
        }  
        request.ensureNodeWeighedIn(ensureNodeCommissioned);
/**
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;  
    public ClusterHealthRequestBuilder setTimeout(TimeValue timeout) {
    public ClusterHealthRequestBuilder setLevel(String level) {
        request.waitForGreenStatus();  
    }
    /**
    }
     * retrieving the cluster health status.  Defaults to <code>false</code>, meaning the
     */
 * compatible open source license.
    public ClusterHealthRequestBuilder setWaitForNoInitializingShards(boolean waitForNoInitializingShards) {
        return this;  
public class ClusterHealthRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
     * to wait until the number of initializing shards in the cluster is 0.  
    public ClusterHealthRequestBuilder setTimeout(String timeout) {
     * Defaults to {@link ActiveShardCount#NONE}, meaning we don't wait on any active shards.  
    public ClusterHealthRequestBuilder setWaitForActiveShards(int waitForActiveShards) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;
    }
/*
        return this;  
        request.waitForStatus(waitForStatus);
            request.waitForActiveShards(waitForActiveShards);
 * KIND, either express or implied.  See the License for the
     */
    public ClusterHealthRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {  
    public ClusterHealthRequestBuilder setApplyLevelAtTransportLayer(boolean applyLevelAtTransportLayer) {  
        return this;  
    }
 */  
    }  
/*  
        if (waitForActiveShards.equals(ActiveShardCount.DEFAULT)) {
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
 *
 *  
 * The OpenSearch Contributors require contributions made to  
        request.indicesOptions(indicesOptions);
import org.opensearch.action.support.ActiveShardCount;
    public final ClusterHealthRequestBuilder setEnsureNodeWeighedIn(boolean ensureNodeCommissioned) {
    public ClusterHealthRequestBuilder setIndices(String... indices) {
 * ownership. Elasticsearch licenses this file to you under  
     */  
        request.waitForNoRelocatingShards(waitForRelocatingShards);
    ClusterHealthResponse,  
import org.opensearch.common.Priority;
        return this;
        request.waitForYellowStatus();
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
     * Specifies if the local request should ensure that the local node is commissioned
    }
     * operation does not wait on there being no more relocating shards.  Set to <code>true</code>  
        return this;
    /**
        request.timeout(timeout);  
    }
     * Sets whether the request should wait for there to be no initializing shards before  
 */  
    /**
    public ClusterHealthRequestBuilder setAwarenessAttribute(String awarenessAttribute) {  
 * Unless required by applicable law or agreed to in writing,
        return this;
/*  
    }  
    public ClusterHealthRequestBuilder(OpenSearchClient client, ClusterHealthAction action) {  
