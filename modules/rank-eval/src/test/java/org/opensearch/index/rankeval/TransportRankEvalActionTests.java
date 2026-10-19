 * license agreements. See the NOTICE file distributed with
        IndicesOptions expectedIndicesOptions = IndicesOptions.fromOptions(  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.env.Environment;  
        rankEvalRequest.searchType(expectedSearchType);
 * The OpenSearch Contributors require contributions made to  
                assertEquals(expectedIndicesOptions, request.requests().get(0).indicesOptions());  
 * ownership. Elasticsearch licenses this file to you under  
        );
import org.opensearch.transport.TransportService;
                assertEquals(expectedSearchType, request.requests().get(0).searchType());
            mock(TransportService.class),
        .put("path.home", createTempDir().toString())
 * this file be licensed under the Apache-2.0 license or a
        String indexName = "test_index";
 *
        .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
public class TransportRankEvalActionTests extends OpenSearchTestCase {
import org.opensearch.action.support.ActionFilters;
        SearchType expectedSearchType = randomFrom(SearchType.CURRENTLY_SUPPORTED);
import org.opensearch.action.search.MultiSearchResponse;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
            new RankEvalSpec(specifications, new DiscountedCumulativeGain()),
 * software distributed under the License is distributed on an
import org.opensearch.search.builder.SearchSourceBuilder;
    public void testTransferRequestParameters() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
 *
import static org.mockito.Mockito.mock;
 */
 * the Apache License, Version 2.0 (the "License"); you may
        specifications.add(  
            randomBoolean()
        .put("node.name", "test-" + getTestName())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
package org.opensearch.index.rankeval;
     * Test that request parameters like indicesOptions or searchType from ranking evaluation request are transfered to msearch request
import org.opensearch.transport.client.node.NodeClient;
    private Settings settings = Settings.builder()  
            new RatedRequest("amsterdam_query", Arrays.asList(new RatedDocument(indexName, "1", 3)), new SearchSourceBuilder())
            public void multiSearch(MultiSearchRequest request, ActionListener<MultiSearchResponse> listener) {
        };
import java.util.Arrays;
 *  
                assertArrayEquals(new String[] { indexName }, request.requests().get(0).indices());
            randomBoolean(),
            }
            mock(ScriptService.class),
import java.util.List;  
        NodeClient client = new NodeClient(settings, null) {  
     */
    /**  
            randomBoolean(),  
import java.util.ArrayList;
            mock(ActionFilters.class),
                assertEquals(1, request.requests().size());  
        rankEvalRequest.indicesOptions(expectedIndicesOptions);
/*
import org.opensearch.common.settings.Settings;  
            randomBoolean(),
        );
}
        action.doExecute(null, rankEvalRequest, null);
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
            @Override
 */  
import org.opensearch.action.search.MultiSearchRequest;
            new String[] { indexName }
        RankEvalRequest rankEvalRequest = new RankEvalRequest(  
/*  
        .build();
            randomBoolean(),
 * specific language governing permissions and limitations
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.action.ActionListener;
            randomBoolean(),  
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;
/*  
            NamedXContentRegistry.EMPTY  
        TransportRankEvalAction action = new TransportRankEvalAction(
import org.opensearch.script.ScriptService;
 */  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            randomBoolean(),
import org.opensearch.action.search.SearchType;  
            client,  
 * GitHub history for details.
            randomBoolean(),
        List<RatedRequest> specifications = new ArrayList<>();
    }  
