    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.rest.BaseRestHandler;  
            Strings.splitStringByCommaToArray(request.param("index"))
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
}  
    public String getName() {
 */
/*  
import java.util.Collections;  
import org.opensearch.transport.client.node.NodeClient;  
        );
            request.paramAsTime("cluster_manager_timeout", addIndexBlockRequest.clusterManagerNodeTimeout())
 * Modifications Copyright OpenSearch Contributors. See
        return "add_index_block_action";  
import org.opensearch.cluster.metadata.IndexMetadata;  
 *  
        addIndexBlockRequest.indicesOptions(IndicesOptions.fromRequest(request, addIndexBlockRequest.indicesOptions()));
/*
    @Override  
import org.opensearch.core.common.Strings;
 */  
    }
 * Transport action to add index block  
        AddIndexBlockRequest addIndexBlockRequest = new AddIndexBlockRequest(
 * license agreements. See the NOTICE file distributed with
        addIndexBlockRequest.clusterManagerNodeTimeout(  
 * specific language governing permissions and limitations
        addIndexBlockRequest.timeout(request.paramAsTime("timeout", addIndexBlockRequest.timeout()));
        );
        return channel -> client.admin().indices().addBlock(addIndexBlockRequest, new RestToXContentListener<>(channel));  
package org.opensearch.rest.action.admin.indices;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequest;
import static org.opensearch.rest.RestRequest.Method.PUT;  
 * KIND, either express or implied.  See the License for the
 * @opensearch.api
    @Override
import org.opensearch.action.support.IndicesOptions;
 *
        parseDeprecatedMasterTimeoutParameter(addIndexBlockRequest, request, deprecationLogger, getName());  
/*  
 *
 * compatible open source license.
import org.opensearch.common.logging.DeprecationLogger;
 * this work for additional information regarding copyright
        return Collections.singletonList(new Route(PUT, "/{index}/_block/{block}"));
    }
 */  
 * under the License.  
 * GitHub history for details.
import org.opensearch.rest.RestRequest;
 * ownership. Elasticsearch licenses this file to you under  
 *
 * The OpenSearch Contributors require contributions made to  
            IndexMetadata.APIBlock.fromName(request.param("block")),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
/**
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    @Override
import org.opensearch.rest.action.RestToXContentListener;
    public List<Route> routes() {  
 * software distributed under the License is distributed on an
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestAddIndexBlockAction.class);  
public class RestAddIndexBlockAction extends BaseRestHandler {
import java.util.List;
