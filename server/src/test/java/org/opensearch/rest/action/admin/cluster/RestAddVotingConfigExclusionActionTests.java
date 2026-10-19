 *  
            .build();  
        action = new RestAddVotingConfigExclusionAction();
import org.opensearch.test.rest.RestActionTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String[] expected = { "node-1", "node-2", "node-3" };  
        params.put("node_names", "node-1,node-2,node-3");  
        AddVotingConfigExclusionsRequest addVotingConfigExclusionsRequest = action.resolveVotingConfigExclusionsRequest(request);  
 * this work for additional information regarding copyright
        assertWarnings("nodeDescription is deprecated and will be removed, use nodeIds or nodeNames instead");
 * The OpenSearch Contributors require contributions made to  
/*
 */  
/*  
        AddVotingConfigExclusionsRequest addVotingConfigExclusionsRequest = action.resolveVotingConfigExclusionsRequest(deprecatedRequest);
    public void testResolveVotingConfigExclusionsRequestNodeIds() {
 * GitHub history for details.
 *
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
            .withParams(params)
 * ownership. Elasticsearch licenses this file to you under  
        AddVotingConfigExclusionsRequest addVotingConfigExclusionsRequest = action.resolveVotingConfigExclusionsRequest(request);  
            .withParams(params)  
        Map<String, String> params = new HashMap<>();
    @Before  
        assertArrayEquals(Strings.EMPTY_ARRAY, addVotingConfigExclusionsRequest.getNodeNames());
public class RestAddVotingConfigExclusionActionTests extends RestActionTestCase {
            .withPath("/_cluster/voting_config_exclusions")
    private RestAddVotingConfigExclusionAction action;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Unless required by applicable law or agreed to in writing,
/*  
        assertArrayEquals(expected, addVotingConfigExclusionsRequest.getNodeDescriptions());
        String[] expected = { "node-1", "node-2", "node-3" };
import java.util.HashMap;
 * compatible open source license.
 * You may obtain a copy of the License at  
        Map<String, String> params = new HashMap<>();
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertArrayEquals(Strings.EMPTY_ARRAY, addVotingConfigExclusionsRequest.getNodeDescriptions());
import org.junit.Before;  
        assertArrayEquals(expected, addVotingConfigExclusionsRequest.getNodeIds());  
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
 * under the License.  
        assertArrayEquals(Strings.EMPTY_ARRAY, addVotingConfigExclusionsRequest.getNodeNames());  
 */  
    }
        assertArrayEquals(Strings.EMPTY_ARRAY, addVotingConfigExclusionsRequest.getNodeIds());  
import org.opensearch.test.rest.FakeRestRequest;
        String[] expected = { "node-1", "node-2", "node-3" };
            .withPath("/_cluster/voting_config_exclusions")
 * Modifications Copyright OpenSearch Contributors. See
        assertArrayEquals(Strings.EMPTY_ARRAY, addVotingConfigExclusionsRequest.getNodeIds());
        Map<String, String> params = new HashMap<>();
 *
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        assertArrayEquals(Strings.EMPTY_ARRAY, addVotingConfigExclusionsRequest.getNodeDescriptions());
    }
    }
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
    public void testResolveVotingConfigExclusionsRequest() {  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)
    }
            .withPath("/_cluster/voting_config_exclusions")
import org.opensearch.core.common.Strings;
import org.opensearch.rest.RestRequest;  
    public void testResolveVotingConfigExclusionsRequestNodeNames() {
        assertArrayEquals(expected, addVotingConfigExclusionsRequest.getNodeNames());
    public void setupAction() {
        controller().registerHandler(action);  
        params.put("node_name", "node-1,node-2,node-3");
            .build();
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)
            .withParams(params)  
 * this file be licensed under the Apache-2.0 license or a
        params.put("node_ids", "node-1,node-2,node-3");  
        RestRequest deprecatedRequest = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)  
package org.opensearch.rest.action.admin.cluster;
import java.util.Map;  
