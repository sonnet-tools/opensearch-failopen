 * You may obtain a copy of the License at  
import org.opensearch.rest.BaseRestHandler;  
 * @opensearch.api  
 *
        return channel -> client.clearScroll(clearRequest, new RestStatusToXContentListener<>(channel));  
}  
 * The OpenSearch Contributors require contributions made to  
                }
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
package org.opensearch.rest.action.search;
 *
    public List<Route> routes() {
import static org.opensearch.rest.RestRequest.Method.DELETE;
 * this work for additional information regarding copyright
 */  
    }
 * not use this file except in compliance with the License.
        clearRequest.setScrollIds(asList(Strings.splitStringByCommaToArray(scrollIds)));  
 */
                    throw new IllegalArgumentException("Failed to parse request body", e);
                // NOTE: if rest request with xcontent body has request parameters, values parsed from request body have the precedence  
    }  
import org.opensearch.rest.action.RestStatusToXContentListener;
    }
 * ownership. Elasticsearch licenses this file to you under  
        request.withContentOrSourceParamParserOrNull((xContentParser -> {
 * software distributed under the License is distributed on an
        String scrollIds = request.param("scroll_id");
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
/*
    public String getName() {
 */
/*  
import java.util.List;  
                try {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * GitHub history for details.
 * compatible open source license.
                } catch (IOException e) {  
 *
            if (xContentParser != null) {
                    clearRequest.fromXContent(xContentParser);
import org.opensearch.action.search.ClearScrollRequest;
import java.io.IOException;
/**  
import org.opensearch.rest.RestRequest;
import static java.util.Collections.unmodifiableList;  
 */  
 * SPDX-License-Identifier: Apache-2.0
        }));
 *  
            }  
import static java.util.Arrays.asList;
public class RestClearScrollAction extends BaseRestHandler {
        return unmodifiableList(asList(new Route(DELETE, "/_search/scroll"), new Route(DELETE, "/_search/scroll/{scroll_id}")));  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.client.node.NodeClient;  
 * Transport action to clear a scroll
 * KIND, either express or implied.  See the License for the
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        return "clear_scroll_action";
import org.opensearch.core.common.Strings;
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        ClearScrollRequest clearRequest = new ClearScrollRequest();
/*  
