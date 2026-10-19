 *  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * specific language governing permissions and limitations
 * under the License.  
import org.opensearch.rest.BaseRestHandler;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainRequest;
/**
 * GitHub history for details.
import org.opensearch.rest.RestResponse;
        }  
        req.includeYesDecisions(request.paramAsBoolean("include_yes_decisions", false));
}
 */  
    public String getName() {
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * Class handling cluster allocation explanation at the REST level
 * this file be licensed under the Apache-2.0 license or a
                public RestResponse buildResponse(ClusterAllocationExplainResponse response, XContentBuilder builder) throws IOException {
 *  
import org.opensearch.transport.client.node.NodeClient;  
            // Empty request signals "explain the first unassigned shard you find"  
        return true;
    @Override
        } else {
            req = new ClusterAllocationExplainRequest();
 */  
    public List<Route> routes() {  
                    response.getExplanation().toXContent(builder, ToXContent.EMPTY_PARAMS);  
            }
        return channel -> client.admin()
    }
    @Override  
import org.opensearch.core.rest.RestStatus;  
 *
import java.io.IOException;
import static java.util.Arrays.asList;
/*  
 * this work for additional information regarding copyright
import org.opensearch.rest.RestRequest;  
    }
    public boolean allowSystemIndexAccessByDefault() {
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
import static org.opensearch.rest.RestRequest.Method.POST;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 */
/*  
            .allocationExplain(req, new RestBuilderListener<ClusterAllocationExplainResponse>(channel) {  
    }  
import java.util.List;  
            try (XContentParser parser = request.contentOrSourceParamParser()) {  
import static java.util.Collections.unmodifiableList;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
import static org.opensearch.rest.RestRequest.Method.GET;
 * The OpenSearch Contributors require contributions made to  
                @Override
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
            .cluster()
            });  
public class RestClusterAllocationExplainAction extends BaseRestHandler {  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.rest.action.admin.cluster;
                    return new BytesRestResponse(RestStatus.OK, builder);
        req.includeDiskInfo(request.paramAsBoolean("include_disk_info", false));  
    @Override
 */
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainResponse;
 *
/*
        if (request.hasContentOrSourceParam() == false) {
        return unmodifiableList(asList(new Route(GET, "/_cluster/allocation/explain"), new Route(POST, "/_cluster/allocation/explain")));
import org.opensearch.core.xcontent.XContentBuilder;
        return "cluster_allocation_explain_action";  
import org.opensearch.core.xcontent.ToXContent;
                }
        ClusterAllocationExplainRequest req;
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.rest.action.RestBuilderListener;
                req = ClusterAllocationExplainRequest.parse(parser);
 * @opensearch.api
import org.opensearch.rest.BytesRestResponse;
