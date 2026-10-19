    /**
    /** Whether to include "YES" decider decisions in the response instead of only "NO" decisions */
 *  
    }  
        request.includeDiskInfo(includeDiskInfo);
        return this;
        return this;
 * Unless required by applicable law or agreed to in writing,
    public ClusterAllocationExplainRequestBuilder useAnyUnassignedShard() {
 *
        request.setPrimary(primary);
    public ClusterAllocationExplainRequestBuilder setShard(int shard) {  
        return this;
        return this;
    /**
    }  
 */  
     */
 * under the License.  
    }
 * Modifications Copyright OpenSearch Contributors. See
    }  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
 * this work for additional information regarding copyright
public class ClusterAllocationExplainRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
        return this;  
/*
        request.setShard(shard);
    /** The index name to use when finding the shard to explain */
 *
        request.setShard(null);
    }  
    /** Whether the primary or replica should be explained */
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ClusterAllocationExplainRequestBuilder setPrimary(boolean primary) {  
    /** The shard number to use when finding the shard to explain */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;
 */  
    public ClusterAllocationExplainRequestBuilder setIndex(String index) {  
 * this file be licensed under the Apache-2.0 license or a
        request.setCurrentNode(currentNode);
 * You may obtain a copy of the License at  
    public ClusterAllocationExplainRequestBuilder setIncludeDiskInfo(boolean includeDiskInfo) {  
     * the given node.
        request.setPrimary(null);
        request.includeYesDecisions(includeYesDecisions);
    public ClusterAllocationExplainRequestBuilder setCurrentNode(String currentNode) {  
    }  
 * @opensearch.api
    ClusterAllocationExplainRequest,  
        request.setIndex(null);  
import org.opensearch.transport.client.OpenSearchClient;  
        super(client, action, new ClusterAllocationExplainRequest());
/*  
    }  
        request.setIndex(index);
 * specific language governing permissions and limitations
 */
    /** Whether to include information about the gathered disk information of nodes in the cluster */
 * KIND, either express or implied.  See the License for the
        return this;
 * not use this file except in compliance with the License.
 */  
 *
     * Requests the explain API to explain an already assigned replica shard currently allocated to  
     */
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    }  
    public ClusterAllocationExplainRequestBuilder(OpenSearchClient client, ClusterAllocationExplainAction action) {
@PublicApi(since = "1.0.0")
        return this;
}  
    ClusterAllocationExplainRequestBuilder> {
    ClusterAllocationExplainResponse,
/**
    public ClusterAllocationExplainRequestBuilder setIncludeYesDecisions(boolean includeYesDecisions) {  
 * Builder for requests to explain the allocation of a shard in the cluster  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.cluster.allocation;
 * ownership. Elasticsearch licenses this file to you under  
     * Signal that the first unassigned shard should be used  
