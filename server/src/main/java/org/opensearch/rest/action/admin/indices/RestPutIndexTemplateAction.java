import org.opensearch.common.xcontent.XContentHelper;  
import org.opensearch.rest.action.RestToXContentListener;
            putRequest.patterns(Arrays.asList(request.paramAsStringArray("index_patterns", Strings.EMPTY_ARRAY)));
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.Strings;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
            deprecationLogger.deprecate(
import java.util.List;
 * under the License.  
    @Override  
        putRequest.create(request.paramAsBoolean("create", false));  
 *
                "Deprecated parameter [template] used, replaced by [index_patterns]"  
        return "put_index_template_action";  
    @Override
public class RestPutIndexTemplateAction extends BaseRestHandler {
        if (request.hasParam("template")) {  
        putRequest.source(sourceAsMap);
    @Override
import java.util.Map;
        return channel -> client.admin().indices().putTemplate(putRequest, new RestToXContentListener<>(channel));
            putRequest.patterns(Collections.singletonList(request.param("template")));
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.rest.RestRequest.Method.POST;  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
/*  
        putRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", putRequest.clusterManagerNodeTimeout()));
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutIndexTemplateAction.class);  
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(request.requiredContent(), false, request.getMediaType()).v2();  
            );
 * Transport action to put index template
import static java.util.Collections.unmodifiableList;
import static java.util.Arrays.asList;
        }
 * GitHub history for details.
/*  
import org.opensearch.common.logging.DeprecationLogger;
    }
package org.opensearch.rest.action.admin.indices;
/**  
 * The OpenSearch Contributors require contributions made to  
        return unmodifiableList(asList(new Route(POST, "/_template/{name}"), new Route(PUT, "/_template/{name}")));
        sourceAsMap = RestCreateIndexAction.prepareMappings(sourceAsMap);
}  
 *
        PutIndexTemplateRequest putRequest = new PutIndexTemplateRequest(request.param("name"));
 */
        putRequest.order(request.paramAsInt("order", putRequest.order()));  
        parseDeprecatedMasterTimeoutParameter(putRequest, request, deprecationLogger, getName());
import static org.opensearch.rest.RestRequest.Method.PUT;
    public List<Route> routes() {  
import org.opensearch.rest.BaseRestHandler;
    }
    }
                "put_index_template_deprecated_parameter",
/*
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Arrays;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * software distributed under the License is distributed on an
 */
 */  
        } else {  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        putRequest.cause(request.param("cause", ""));
 * @opensearch.api  
 * specific language governing permissions and limitations
import org.opensearch.transport.client.node.NodeClient;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.RestRequest;  
 *  
 */  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    public String getName() {
