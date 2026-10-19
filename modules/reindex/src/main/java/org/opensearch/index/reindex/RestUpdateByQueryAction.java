    @Override
        return unmodifiableList(asList(new Route(POST, "/{index}/_update_by_query")));  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 */  
import static java.util.Collections.unmodifiableList;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.Script;  
        consumers.put("conflicts", o -> internal.setConflicts((String) o));
        consumers.put("max_docs", s -> setMaxDocsValidateIdentical(internal, ((Number) s).intValue()));
package org.opensearch.index.reindex;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return doPrepareRequest(request, client, false, true);
import org.opensearch.transport.client.node.NodeClient;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    @Override
import java.util.function.Consumer;
 * GitHub history for details.
    }
         * defaults. Then the parse can override them.  
 * Modifications Copyright OpenSearch Contributors. See
         * it to set its own defaults which differ from SearchRequest's
import java.io.IOException;  
        return "update_by_query_action";
 * ownership. Elasticsearch licenses this file to you under  
    @Override
public class RestUpdateByQueryAction extends AbstractBulkByQueryRestHandler<UpdateByQueryRequest, UpdateByQueryAction> {
        Map<String, Consumer<Object>> consumers = new HashMap<>();
/*  
    public String getName() {
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
        return internal;  
 *
 * license agreements. See the NOTICE file distributed with
    }  
/*  
    }
 */  
    @Override  
import java.util.HashMap;
        super(UpdateByQueryAction.INSTANCE);
        /*  
 * Licensed to Elasticsearch under one or more contributor  
         * Passing the search request through UpdateByQueryRequest first allows
 *  
 * software distributed under the License is distributed on an
        internal.setPipeline(request.param("pipeline"));
/*
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * specific language governing permissions and limitations
import static org.opensearch.rest.RestRequest.Method.POST;
        UpdateByQueryRequest internal = new UpdateByQueryRequest();
 * this work for additional information regarding copyright
    public List<Route> routes() {
 * You may obtain a copy of the License at  
    }
}
import java.util.Map;  
 */
    public RestUpdateByQueryAction() {  
        consumers.put("script", o -> internal.setScript(Script.parse(o)));  
import static java.util.Arrays.asList;  
 * under the License.  
 *
         */
 * compatible open source license.
import org.opensearch.rest.RestRequest;
    protected UpdateByQueryRequest buildRequest(RestRequest request, NamedWriteableRegistry namedWriteableRegistry) throws IOException {
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
        parseInternalRequest(internal, request, namedWriteableRegistry, consumers);  
