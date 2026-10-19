        table.endHeaders();
 *  
 */
     */  
        return unmodifiableList(asList(new Route(GET, "/_cat/example"), new Route(POST, "/_cat/example")));
    @Override  
     */  
                channel.sendResponse(new BytesRestResponse(channel, e));
import static java.util.Collections.unmodifiableList;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return Syntax documentation.
import org.opensearch.rest.action.cat.RestTable;
    }  
 * this file be licensed under the Apache-2.0 license or a
            }
package org.opensearch.example.resthandler;
    protected Table getTableWithHeader(RestRequest request) {  
        Table table = getTableWithHeader(request);
 * You may obtain a copy of the License at  
    }  
    }
 * Licensed to Elasticsearch under one or more contributor  
            } catch (final Exception e) {  
public class ExampleCatAction extends AbstractCatAction {
    }  
/*
    protected RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
    }  
import static java.util.Arrays.asList;  
 * GitHub history for details.
import static org.opensearch.rest.RestRequest.Method.POST;  
 * Example of adding a cat REST action with a plugin.  
        table.addCell("test", "desc:test");  
/*  
 * Unless required by applicable law or agreed to in writing,
    }
                channel.sendResponse(RestTable.buildResponse(table, channel));
     *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.client.node.NodeClient;
        table.startRow();  
/*
 * SPDX-License-Identifier: Apache-2.0
        return "rest_handler_cat_example";
 * Modifications Copyright OpenSearch Contributors. See  
    /**
    @Override
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
            try {
        final String message = request.param("message", "Hello from Cat Example action");  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    /**
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.action.cat.AbstractCatAction;  
        table.startHeaders();
 * under the License.  
     * Documents this REST action.  
        table.addCell(message);
 */
 * compatible open source license.
import org.opensearch.common.Table;  
import static org.opensearch.rest.RestRequest.Method.GET;
import java.util.List;
    public List<Route> routes() {
        final Table table = new Table();
 */  
    protected void documentation(StringBuilder sb) {
 */
    public String getName() {  
import org.opensearch.rest.RestRequest;
    @Override  
 * specific language governing permissions and limitations
}
     * Instantiate this class.
        };  
 * ownership. Elasticsearch licenses this file to you under  
        return table;
        sb.append(documentation());
    public ExampleCatAction() {}
        return channel -> {  
import org.opensearch.rest.BytesRestResponse;
 *
 * software distributed under the License is distributed on an
        return "/_cat/example\n";
        table.endRow();
 * KIND, either express or implied.  See the License for the
 *
    public static String documentation() {
