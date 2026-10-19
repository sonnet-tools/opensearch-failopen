        putMappingRequest.source(sourceAsMap);
            asList(
 *    http://www.apache.org/licenses/LICENSE-2.0
        parseDeprecatedMasterTimeoutParameter(putMappingRequest, request, deprecationLogger, getName());  
 * @opensearch.api
}
    }
import static java.util.Collections.unmodifiableList;
                new Route(PUT, "/{index}/_mappings")
    @Override
    public List<Route> routes() {
        );
    public String getName() {
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.rest.RestRequest;
                new Route(PUT, "/{index}/_mapping"),  
        }
            throw new IllegalArgumentException("Types cannot be provided in put mapping requests");
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.Strings;
import org.opensearch.index.mapper.MapperService;  
        if (MapperService.isMappingSourceTyped(MapperService.SINGLE_MAPPING_NAME, sourceAsMap)) {  
import static java.util.Arrays.asList;
import java.io.IOException;  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    @Override  
 * under the License.  
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(request.requiredContent(), false, request.getMediaType()).v2();
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
 * not use this file except in compliance with the License.
        return "put_mapping_action";  
            )  
import static org.opensearch.rest.RestRequest.Method.POST;  
 * Modifications Copyright OpenSearch Contributors. See
                new Route(POST, "/{index}/_mappings"),
/*
 * You may obtain a copy of the License at  
    }
        putMappingRequest.timeout(request.paramAsTime("timeout", putMappingRequest.timeout()));
import org.opensearch.transport.client.node.NodeClient;
 * specific language governing permissions and limitations
            request.paramAsTime("cluster_manager_timeout", putMappingRequest.clusterManagerNodeTimeout())
 *
 * Transport action to put mapping
package org.opensearch.rest.action.admin.indices;
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 *  
 * The OpenSearch Contributors require contributions made to  
public class RestPutMappingAction extends BaseRestHandler {  
 * this work for additional information regarding copyright
                new Route(POST, "/{index}/_mapping"),
import org.opensearch.common.logging.DeprecationLogger;  
 *
 * Unless required by applicable law or agreed to in writing,
/*  
 */  
    }
/*  
 */
 * KIND, either express or implied.  See the License for the
 *  
import java.util.Map;
        PutMappingRequest putMappingRequest = putMappingRequest(Strings.splitStringByCommaToArray(request.param("index")));  
import static org.opensearch.rest.RestRequest.Method.PUT;
 * Licensed to Elasticsearch under one or more contributor  
        putMappingRequest.writeIndexOnly(request.paramAsBoolean("write_index_only", false));
        );
import static org.opensearch.transport.client.Requests.putMappingRequest;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutMappingAction.class);
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        putMappingRequest.indicesOptions(IndicesOptions.fromRequest(request, putMappingRequest.indicesOptions()));
 * ownership. Elasticsearch licenses this file to you under  
/**
        putMappingRequest.clusterManagerNodeTimeout(  
import java.util.List;
 */  
import org.opensearch.rest.action.RestToXContentListener;  
        return channel -> client.admin().indices().putMapping(putMappingRequest, new RestToXContentListener<>(channel));  
        return unmodifiableList(  
    @Override
 * compatible open source license.
