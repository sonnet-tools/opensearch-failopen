        fieldRequest.includeUnmapped(request.paramAsBoolean("include_unmapped", false));  
        ).indices(indices);  
import org.opensearch.action.support.IndicesOptions;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.rest.BaseRestHandler;
 * Transport action to get field capabilities
    @Override
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));  
 *  
 */
 * @opensearch.api
 * You may obtain a copy of the License at  
        request.withContentOrSourceParamParserOrNull(parser -> {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
/*  
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
                new Route(POST, "/_field_caps"),
}
            )
        FieldCapabilitiesRequest fieldRequest = new FieldCapabilitiesRequest().fields(
    @Override
    }
                new Route(POST, "/{index}/_field_caps")  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public String getName() {  
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * under the License.  
import java.util.List;  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
            Strings.splitStringByCommaToArray(request.param("fields"))
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                new Route(GET, "/_field_caps"),  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    }
                new Route(GET, "/{index}/_field_caps"),
 * specific language governing permissions and limitations
        });
import org.opensearch.rest.RestRequest;
            asList(
        );
import static java.util.Collections.unmodifiableList;  
 *  
import static java.util.Arrays.asList;
public class RestFieldCapabilitiesAction extends BaseRestHandler {  
 */
    public List<Route> routes() {  
import static org.opensearch.rest.RestRequest.Method.POST;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.Strings;  
/**
        return "field_capabilities_action";
        return channel -> client.fieldCaps(fieldRequest, new RestToXContentListener<>(channel));  
 * this file be licensed under the Apache-2.0 license or a
 *
            if (parser != null) {
 * compatible open source license.
 * GitHub history for details.
                fieldRequest.indexFilter(RestActions.getQueryContent("index_filter", parser));  
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.transport.client.node.NodeClient;  
package org.opensearch.rest.action;
 */  
/*
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
/*  
        return unmodifiableList(
        fieldRequest.indicesOptions(IndicesOptions.fromRequest(request, fieldRequest.indicesOptions()));
