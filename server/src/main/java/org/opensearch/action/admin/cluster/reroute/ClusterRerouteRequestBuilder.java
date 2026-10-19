    }  
        request.setRetryFailed(retryFailed);
@PublicApi(since = "1.0.0")
 */
     */
     */
    public ClusterRerouteRequestBuilder setExplain(boolean explain) {  
public class ClusterRerouteRequestBuilder extends AcknowledgedRequestBuilder<  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
     * will simply run a simple "reroute".
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
     * Sets the retry failed flag (defaults to {@code false}). If true, the  
     */
    /**
/*
    /**
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    ClusterRerouteRequest,
    public ClusterRerouteRequestBuilder setDryRun(boolean dryRun) {  
    ClusterRerouteRequestBuilder> {  
    }  
 * compatible open source license.
/**  
     * actually applying them to the cluster state, and getting the resulting cluster state back.
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api  
 * ownership. Elasticsearch licenses this file to you under  
     * request will include an explanation in addition to the cluster state.
/*  
    }  
 * specific language governing permissions and limitations
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
 * Licensed to Elasticsearch under one or more contributor  
    }  
        return this;
    public ClusterRerouteRequestBuilder setRetryFailed(boolean retryFailed) {  
 * under the License.  
    }  
 *
    /**
/*  
    ClusterRerouteResponse,
     * Sets the explain flag (defaults to {@code false}). If true, the  
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
import org.opensearch.common.annotation.PublicApi;  
 */  
        super(client, action, new ClusterRerouteRequest());
 */
     * request will retry allocating shards that can't currently be allocated due to too many allocation failures.
 * this work for additional information regarding copyright
    public ClusterRerouteRequestBuilder add(AllocationCommand... commands) {  
 */  
 *  
 * SPDX-License-Identifier: Apache-2.0
 *
 * You may obtain a copy of the License at  
     * Adds allocation commands to be applied to the cluster. Note, can be empty, in which case  
    public ClusterRerouteRequestBuilder(OpenSearchClient client, ClusterRerouteAction action) {
        return this;
        return this;
}
 *
    /**
package org.opensearch.action.admin.cluster.reroute;
import org.opensearch.transport.client.OpenSearchClient;
     * Sets a dry run flag (defaults to {@code false}) allowing to run the commands without  
        request.add(commands);
 * Builder for a cluster reroute request
        request.dryRun(dryRun);
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        request.explain(explain);
        return this;
     */
