 * SPDX-License-Identifier: Apache-2.0
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        super(DeleteByQueryAction.INSTANCE);  
import java.io.IOException;
 *
 * Unless required by applicable law or agreed to in writing,
         * it to set its own defaults which differ from SearchRequest's
package org.opensearch.index.reindex;
    @Override  
    public String getName() {  
         * defaults. Then the parseInternalRequest can override them.
/*  
import java.util.HashMap;  
 * under the License.  
    }
    @Override
        parseInternalRequest(internal, request, namedWriteableRegistry, consumers);
        return unmodifiableList(asList(new Route(POST, "/{index}/_delete_by_query")));
 * Licensed to Elasticsearch under one or more contributor  
public class RestDeleteByQueryAction extends AbstractBulkByQueryRestHandler<DeleteByQueryRequest, DeleteByQueryAction> {  
    public List<Route> routes() {
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    @Override  
        return doPrepareRequest(request, client, false, false);  
 */
 * software distributed under the License is distributed on an
    public RestDeleteByQueryAction() {
         */  
}
        Map<String, Consumer<Object>> consumers = new HashMap<>();  
 *  
 * not use this file except in compliance with the License.
import org.opensearch.rest.RestRequest;
        consumers.put("conflicts", o -> internal.setConflicts((String) o));
    protected DeleteByQueryRequest buildRequest(RestRequest request, NamedWriteableRegistry namedWriteableRegistry) throws IOException {
import static java.util.Collections.unmodifiableList;  
    }
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
import java.util.Map;
 * GitHub history for details.
         * Passing the search request through DeleteByQueryRequest first allows  
 */  
    }
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 *
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        return internal;  
        /*
        DeleteByQueryRequest internal = new DeleteByQueryRequest();
import static org.opensearch.rest.RestRequest.Method.POST;
import java.util.function.Consumer;  
import org.opensearch.transport.client.node.NodeClient;  
import static java.util.Arrays.asList;
/*  
    @Override
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        return "delete_by_query_action";
 * this file be licensed under the Apache-2.0 license or a
        consumers.put("max_docs", s -> setMaxDocsValidateIdentical(internal, ((Number) s).intValue()));
 * compatible open source license.
