import static org.opensearch.rest.RestRequest.Method.GET;
 */  
import org.opensearch.transport.client.node.NodeClient;
 * Licensed to Elasticsearch under one or more contributor  
 *
                new Route(POST, "/{index}/_mtermvectors")
    @Override  
        return unmodifiableList(
 * this file be licensed under the Apache-2.0 license or a
        RestTermVectorsAction.readURIParameters(template, request);
 * license agreements. See the NOTICE file distributed with
/*  
        TermVectorsRequest template = new TermVectorsRequest().index(request.param("index"));
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
                new Route(POST, "/_mtermvectors"),
    @Override  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import static java.util.Arrays.asList;  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
import org.opensearch.core.common.Strings;  
import java.io.IOException;  
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
        MultiTermVectorsRequest multiTermVectorsRequest = new MultiTermVectorsRequest();
 * under the License.  
        return "document_multi_term_vectors_action";
 * Transport action to get a multi term vector  
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.BaseRestHandler;
    }  
import org.opensearch.action.termvectors.TermVectorsRequest;
 *
        request.withContentOrSourceParamParserOrNull(p -> multiTermVectorsRequest.add(template, p));  
 */
package org.opensearch.rest.action.document;
 * @opensearch.api
 *  
 */  
public class RestMultiTermVectorsAction extends BaseRestHandler {
import java.util.List;
import org.opensearch.rest.RestRequest;
 * GitHub history for details.
 * software distributed under the License is distributed on an
    }  
/**
    public String getName() {
        );  
/*  
            )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                new Route(GET, "/{index}/_mtermvectors"),  
 * You may obtain a copy of the License at  
import org.opensearch.rest.action.RestToXContentListener;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.rest.RestRequest.Method.POST;  
 * specific language governing permissions and limitations
import static java.util.Collections.unmodifiableList;
 * The OpenSearch Contributors require contributions made to  
/*
                new Route(GET, "/_mtermvectors"),
 * not use this file except in compliance with the License.
        return channel -> client.multiTermVectors(multiTermVectorsRequest, new RestToXContentListener<>(channel));
 * this work for additional information regarding copyright
            asList(  
}
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Unless required by applicable law or agreed to in writing,
        multiTermVectorsRequest.ids(Strings.commaDelimitedListToStringArray(request.param("ids")));
 * Modifications Copyright OpenSearch Contributors. See
    public List<Route> routes() {
