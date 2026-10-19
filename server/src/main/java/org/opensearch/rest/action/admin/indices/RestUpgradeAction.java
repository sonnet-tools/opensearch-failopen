 * You may obtain a copy of the License at  
package org.opensearch.rest.action.admin.indices;
        return "upgrade_action";  
import org.opensearch.transport.client.node.NodeClient;
/*  
import org.opensearch.action.support.IndicesOptions;
 * @opensearch.api
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    @Override  
 *
 * SPDX-License-Identifier: Apache-2.0
        return channel -> client.admin().indices().upgrade(upgradeReq, new RestToXContentListener<>(channel));
import org.opensearch.core.common.Strings;  
/*
    public List<Route> routes() {  
public class RestUpgradeAction extends BaseRestHandler {  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        return unmodifiableList(asList(new Route(POST, "/_upgrade"), new Route(POST, "/{index}/_upgrade")));
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
 */  
    @Override
 */
 *  
 * this work for additional information regarding copyright
 *  
    }
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        upgradeReq.indicesOptions(IndicesOptions.fromRequest(request, upgradeReq.indicesOptions()));  
import org.opensearch.rest.BaseRestHandler;
        upgradeReq.upgradeOnlyAncientSegments(request.paramAsBoolean("only_ancient_segments", false));
 */  
import static java.util.Arrays.asList;  
/**
    @Override
 * under the License.  
import static org.opensearch.rest.RestRequest.Method.POST;
 * software distributed under the License is distributed on an
import org.opensearch.rest.action.RestToXContentListener;  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
 *
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
import java.io.IOException;  
import static java.util.Collections.unmodifiableList;
    }  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * The OpenSearch Contributors require contributions made to  
 * Transport action to upgrade an index
}
import org.opensearch.rest.RestRequest;
        UpgradeRequest upgradeReq = new UpgradeRequest(Strings.splitStringByCommaToArray(request.param("index")));
    public String getName() {
 */
import org.opensearch.action.admin.indices.upgrade.post.UpgradeRequest;
