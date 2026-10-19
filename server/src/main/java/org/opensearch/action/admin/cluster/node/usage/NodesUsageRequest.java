    public NodesUsageRequest all() {  
     */
 * You may obtain a copy of the License at  
/*  
 *
/*
        return this.aggregations;  
import org.opensearch.core.common.io.stream.StreamOutput;
    /**  
 * GitHub history for details.
        this.aggregations = in.readBoolean();
 * not use this file except in compliance with the License.
        super.writeTo(out);
        out.writeBoolean(restActions);
    }  
@PublicApi(since = "1.0.0")
 */  
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     * Get usage from nodes based on the nodes ids specified. If none are
        super(nodesIds);  
     */
    }
 * this work for additional information regarding copyright
/*  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
     * Sets all the request flags.
 * @opensearch.api
    public NodesUsageRequest(String... nodesIds) {
        return this;  
}
    public boolean aggregations() {
        return this.restActions;  
 *
        this.restActions = in.readBoolean();  
 */  
    public NodesUsageRequest aggregations(boolean aggregations) {  
        return this;
    private boolean restActions;
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    public boolean restActions() {
        super(in);
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
    /**
 * under the License.  
        return this;
 */  
    /**
    @Override
        this.restActions = restActions;
    }  
     */
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
     */
    /**  
    public NodesUsageRequest restActions(boolean restActions) {  
 * software distributed under the License is distributed on an
        this.aggregations = aggregations;
    }  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        this.aggregations = true;
package org.opensearch.action.admin.cluster.node.usage;
    public void writeTo(StreamOutput out) throws IOException {  
 */
    /**  
     * Should the node rest actions usage statistics be returned.
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
    public NodesUsageRequest(StreamInput in) throws IOException {
     * Should the node rest actions usage statistics be returned.  
    }
    public NodesUsageRequest clear() {  
 * specific language governing permissions and limitations
    private boolean aggregations;
 * Transport request for collecting OpenSearch telemetry  
     * passed, usage for all nodes will be returned.  
/**
public class NodesUsageRequest extends BaseNodesRequest<NodesUsageRequest> {
        this.restActions = false;
 *  
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
     * Should the node rest actions usage statistics be returned.
        out.writeBoolean(aggregations);  
     */
     * Clears all the request flags.
 * compatible open source license.
        this.restActions = true;
 * Unless required by applicable law or agreed to in writing,
     */
 *
import org.opensearch.action.support.nodes.BaseNodesRequest;
 * SPDX-License-Identifier: Apache-2.0
     * Should the node rest actions usage statistics be returned.  
