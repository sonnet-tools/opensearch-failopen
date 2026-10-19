import java.io.IOException;
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import org.opensearch.action.DocWriteRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.rest.RestRequest.Method.POST;  
import org.opensearch.rest.RestRequest;
 * not use this file except in compliance with the License.
 */
        if (request.hasParam("pipeline")) {
 * under the License.  
    @Override
 * compatible open source license.
    @Override  
        return singletonList(new Route(POST, "/_reindex"));
/**
    protected ReindexRequest buildRequest(RestRequest request, NamedWriteableRegistry namedWriteableRegistry) throws IOException {  
 */  
import java.util.Collections;  
    }  
import org.opensearch.transport.client.node.NodeClient;  
            throw new IllegalArgumentException(
    public List<Route> routes() {  
        }
    @Override
 * ownership. Elasticsearch licenses this file to you under  
}
 *  
 * Expose reindex over rest.  
            internal.setScroll(parseTimeValue(request.param("scroll"), "scroll"));
            internal = ReindexRequest.fromXContent(parser);  
        return internal;
        try (XContentParser parser = request.contentParser()) {
    }
 */  
    }
        }
        return "reindex_action";  
public class RestReindexAction extends AbstractBaseReindexRestHandler<ReindexRequest, ReindexAction> implements RestRequestFilter {
 * this file be licensed under the Apache-2.0 license or a
        super(ReindexAction.INSTANCE);
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *
        if (request.hasParam(DocWriteRequest.REQUIRE_ALIAS)) {  
    }  
import java.util.List;
    private static final Set<String> FILTERED_FIELDS = Collections.singleton("source.remote.host.password");
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
                "_reindex doesn't support [pipeline] as a query parameter. " + "Specify it in the [dest] object instead."  
 */
 * GitHub history for details.
            );
 *
    @Override
import org.opensearch.core.xcontent.XContentParser;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.singletonList;
    }  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    public String getName() {
import org.opensearch.rest.RestRequestFilter;
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
    public Set<String> getFilteredFields() {
 * this work for additional information regarding copyright
/*  
        }
 * software distributed under the License is distributed on an
/*
package org.opensearch.index.reindex;
        return FILTERED_FIELDS;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    @Override  
        }
        if (request.hasParam("scroll")) {  
        ReindexRequest internal;
        return doPrepareRequest(request, client, true, true);
 * Unless required by applicable law or agreed to in writing,
    }
 * Licensed to Elasticsearch under one or more contributor  
    public RestReindexAction() {
            internal.setRequireAlias(request.paramAsBoolean(DocWriteRequest.REQUIRE_ALIAS, false));
