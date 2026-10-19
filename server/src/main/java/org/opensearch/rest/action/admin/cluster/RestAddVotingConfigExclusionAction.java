        String deprecatedNodeDescription = null;
    private static final String DEPRECATION_MESSAGE = "POST /_cluster/voting_config_exclusions/{node_name} "  
import org.apache.logging.log4j.LogManager;
 *
        );  
 *  
 */
        + "or POST /_cluster/voting_config_exclusions?node_names=... instead.";  
        return Arrays.asList(  
        }
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
            votingConfigExclusionsRequest,
import java.io.IOException;  
    private static final Logger logger = LogManager.getLogger(RestAddVotingConfigExclusionAction.class);
        if (request.hasParam("node_ids")) {
import org.opensearch.common.unit.TimeValue;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
    @Override
package org.opensearch.rest.action.admin.cluster;
            Strings.splitStringByCommaToArray(nodeIds),
            Strings.splitStringByCommaToArray(deprecatedNodeDescription),
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 *
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        return "add_voting_config_exclusions_action";
            Strings.splitStringByCommaToArray(nodeNames),  
import java.util.Arrays;
public class RestAddVotingConfigExclusionAction extends BaseRestHandler {
    }  
            nodeIds = request.param("node_ids");
            nodeNames = request.param("node_names");  
import org.opensearch.transport.client.node.NodeClient;
 * KIND, either express or implied.  See the License for the
        String nodeNames = null;
/*  
/*  
            new DeprecatedRoute(POST, "/_cluster/voting_config_exclusions/{node_name}", DEPRECATION_MESSAGE),
import org.opensearch.rest.action.RestToXContentListener;  
        AddVotingConfigExclusionsRequest votingConfigExclusionsRequest = resolveVotingConfigExclusionsRequest(request);
/**  
    @Override
 * You may obtain a copy of the License at  
        }
}
import org.opensearch.rest.RestRequest;
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Transport action to add voting config exclusions
 * not use this file except in compliance with the License.
import org.opensearch.core.common.Strings;  
import java.util.List;
            new RestToXContentListener<>(channel)  
import org.apache.logging.log4j.Logger;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;  
    public List<Route> routes() {
            TimeValue.parseTimeValue(request.param("timeout"), DEFAULT_TIMEOUT, getClass().getSimpleName() + ".timeout")
        return channel -> client.execute(  
 * The OpenSearch Contributors require contributions made to  
            deprecatedNodeDescription = request.param("node_name");
        );
            new Route(POST, "/_cluster/voting_config_exclusions")
 */  
import org.opensearch.rest.BaseRestHandler;
        return new AddVotingConfigExclusionsRequest(  
import static org.opensearch.rest.RestRequest.Method.POST;
        + "Please use POST /_cluster/voting_config_exclusions?node_ids=... "
        if (request.hasParam("node_name")) {  
/*
    AddVotingConfigExclusionsRequest resolveVotingConfigExclusionsRequest(final RestRequest request) {
        String nodeIds = null;  
        );
        }  
    protected RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        + "will be removed in a future version. "
            AddVotingConfigExclusionsAction.INSTANCE,
 *
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
 * @opensearch.api  
    public String getName() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final TimeValue DEFAULT_TIMEOUT = TimeValue.timeValueSeconds(30L);  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        if (request.hasParam("node_names")) {
