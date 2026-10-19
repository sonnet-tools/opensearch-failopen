import static org.opensearch.rest.RestRequest.Method.GET;
    public String getName() {
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.BaseRestHandler;
 * license agreements. See the NOTICE file distributed with
        throw new OutOfMemoryError("die with dignity");
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.rest.RestRequest;
    RestDieWithDignityAction() {}  
 * this work for additional information regarding copyright
    @Override
/*  
import java.util.List;
}
 * specific language governing permissions and limitations
 *
public class RestDieWithDignityAction extends BaseRestHandler {
/*  
        return singletonList(new Route(GET, "/_die_with_dignity"));
/*
 * ownership. Elasticsearch licenses this file to you under  
    }  
import static java.util.Collections.singletonList;
 * not use this file except in compliance with the License.
 */
 */  
    public List<Route> routes() {  
 * under the License.  
 * compatible open source license.
 *
 * Modifications Copyright OpenSearch Contributors. See
 *  
package org.opensearch;
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return "die_with_dignity_action";  
 * software distributed under the License is distributed on an
 * GitHub history for details.
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    @Override  
