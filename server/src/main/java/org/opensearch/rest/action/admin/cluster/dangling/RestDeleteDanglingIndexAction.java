            request.paramAsBoolean("accept_data_loss", false)
        deleteRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", deleteRequest.clusterManagerNodeTimeout()));
        parseDeprecatedMasterTimeoutParameter(deleteRequest, request, deprecationLogger, getName());  
 * The OpenSearch Contributors require contributions made to  
        return channel -> client.admin()
/*  
public class RestDeleteDanglingIndexAction extends BaseRestHandler {
                @Override
/**
        deleteRequest.timeout(request.paramAsTime("timeout", deleteRequest.timeout()));
 * under the License.  
 * compatible open source license.
import static org.opensearch.core.rest.RestStatus.ACCEPTED;
 * this work for additional information regarding copyright
    }
 * @opensearch.api
    @Override  
 * KIND, either express or implied.  See the License for the
 */
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * Transport action to delete dangling index  
        return singletonList(new Route(DELETE, "/_dangling/{index_uuid}"));
import org.opensearch.transport.client.node.NodeClient;
 *
import org.opensearch.common.logging.DeprecationLogger;  
import static org.opensearch.rest.RestRequest.Method.DELETE;  
 *  
import java.util.List;
    public String getName() {
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexRequest;
 * specific language governing permissions and limitations
    @Override
import static java.util.Collections.singletonList;
 */  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeleteDanglingIndexAction.class);  
    }
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 */  
}
 *
                    return ACCEPTED;
 * You may obtain a copy of the License at  
import org.opensearch.rest.BaseRestHandler;
 * software distributed under the License is distributed on an
import org.opensearch.rest.action.RestToXContentListener;
                protected RestStatus getStatus(AcknowledgedResponse acknowledgedResponse) {  
 * license agreements. See the NOTICE file distributed with
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            request.param("index_uuid"),  
/*  
    public RestChannelConsumer prepareRequest(final RestRequest request, NodeClient client) throws IOException {
import java.io.IOException;
/*
            });  
        );
import org.opensearch.rest.RestRequest;  
        return "delete_dangling_index";  
    public List<Route> routes() {  
        final DeleteDanglingIndexRequest deleteRequest = new DeleteDanglingIndexRequest(
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.rest.action.admin.cluster.dangling;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .deleteDanglingIndex(deleteRequest, new RestToXContentListener<AcknowledgedResponse>(channel) {
 * Unless required by applicable law or agreed to in writing,
            .cluster()  
    @Override
import org.opensearch.core.rest.RestStatus;
