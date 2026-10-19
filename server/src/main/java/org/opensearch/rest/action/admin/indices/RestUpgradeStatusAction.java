import static java.util.Collections.unmodifiableList;
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        UpgradeStatusRequest statusRequest = new UpgradeStatusRequest(Strings.splitStringByCommaToArray(request.param("index")));  
import static java.util.Arrays.asList;  
 * this work for additional information regarding copyright
/*
    @Override
import org.opensearch.rest.RestRequest;
        return unmodifiableList(asList(new Route(GET, "/_upgrade"), new Route(GET, "/{index}/_upgrade")));
}  
public class RestUpgradeStatusAction extends BaseRestHandler {  
    @Override
 * license agreements. See the NOTICE file distributed with
 */
        return "upgrade_status_action";
 * @opensearch.api
 * software distributed under the License is distributed on an
    public List<Route> routes() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.rest.action.admin.indices;
 */  
 */  
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.core.common.Strings;  
 * not use this file except in compliance with the License.
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
 * Licensed to Elasticsearch under one or more contributor  
        return channel -> client.admin().indices().upgradeStatus(statusRequest, new RestToXContentListener<>(channel));
/*  
import org.opensearch.rest.action.RestToXContentListener;  
 *  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusRequest;
import java.io.IOException;  
    }
 *  
 * specific language governing permissions and limitations
 * compatible open source license.
 * under the License.  
    public String getName() {  
 * Unless required by applicable law or agreed to in writing,
/**
 */
    }  
import org.opensearch.rest.BaseRestHandler;
import java.util.List;
        statusRequest.indicesOptions(IndicesOptions.fromRequest(request, statusRequest.indicesOptions()));
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    @Override
 *
 * The OpenSearch Contributors require contributions made to  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Transport action to get an upgrade status
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
