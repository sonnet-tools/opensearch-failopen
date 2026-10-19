    @Override
 * Response returned after a cluster reroute request
 * this work for additional information regarding copyright
    public RoutingExplanations getExplanations() {
    private final ClusterState state;  
        super(in);
 * You may obtain a copy of the License at  
        state = ClusterState.readFrom(in, null);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super.writeTo(out);
import org.opensearch.cluster.ClusterState;
    private final RoutingExplanations explanations;
    }
    }  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        state.writeTo(out);
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject("state");
        super(acknowledged);
 * license agreements. See the NOTICE file distributed with
    }
        this.explanations = explanations;  
     * Returns the cluster state resulted from the cluster reroute request execution
        if (params.paramAsBoolean("explain", false)) {
    public ClusterState getState() {  
public class ClusterRerouteResponse extends AcknowledgedResponse implements ToXContentObject {
        return this.explanations;
 *     http://www.apache.org/licenses/LICENSE-2.0
        state.toXContent(builder, params);  
        return this.state;
 */
 */
import org.opensearch.cluster.routing.allocation.RoutingExplanations;  
import java.io.IOException;
 * software distributed under the License is distributed on an
/*
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.ToXContentObject;
 *  
/*  
    }
 */  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.action.admin.cluster.reroute;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        RoutingExplanations.writeTo(explanations, out);  
    @Override  
 */  
import org.opensearch.core.xcontent.ToXContent;
 * under the License.  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * @opensearch.api
 *
}  
    ClusterRerouteResponse(StreamInput in) throws IOException {  
import org.opensearch.common.annotation.PublicApi;
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * compatible open source license.
            explanations.toXContent(builder, ToXContent.EMPTY_PARAMS);  
 * ownership. Elasticsearch licenses this file to you under  
     */
 *
/*  
        builder.endObject();
/**
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
    ClusterRerouteResponse(boolean acknowledged, ClusterState state, RoutingExplanations explanations) {  
@PublicApi(since = "1.0.0")  
 * Unless required by applicable law or agreed to in writing,
    /**  
        this.state = state;
        explanations = RoutingExplanations.readFrom(in);  
 *  
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;  
