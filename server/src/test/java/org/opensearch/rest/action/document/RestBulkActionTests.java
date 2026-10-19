    }  
 */
            );  
                                + "{\"update\":{\"_id\":\"2\"}}\n"  
 * GitHub history for details.
 * Tests for {@link RestBulkAction}.  
 * not use this file except in compliance with the License.
                        new BytesArray(  
 */
    public void testBulkPipelineUpsert() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
                                + "{\"script\":{\"source\":\"ctx._source.counter++;\"},\"upsert\":{\"field1\":\"upserted_val\"}}\n"
import org.opensearch.rest.RestRequest;
import org.opensearch.test.OpenSearchTestCase;
                    .withParams(params)
/*  
import org.opensearch.action.update.UpdateRequest;
            public void bulk(BulkRequest request, ActionListener<BulkResponse> listener) {
        SetOnce<Boolean> bulkCalled = new SetOnce<>();
import org.opensearch.action.bulk.BulkResponse;  
public class RestBulkActionTests extends OpenSearchTestCase {
package org.opensearch.rest.action.document;
import java.util.HashMap;
                    .build(),  
                        ),
/*  
 *
                    .withContent(
 * software distributed under the License is distributed on an
        }
            params.put("pipeline", "timestamps");
        try (NodeClient verifyingClient = new NoOpNodeClient(this.getTestName()) {  
                verifyingClient
                        MediaTypeRegistry.JSON  
 * this work for additional information regarding copyright
                assertThat(request.requests(), hasSize(2));
import org.opensearch.action.bulk.BulkRequest;
 * license agreements. See the NOTICE file distributed with
 *
        }) {
 * compatible open source license.
                assertThat(updateRequest.upsertRequest().getPipeline(), equalTo("timestamps"));  
            new RestBulkAction(settings(Version.CURRENT).build()).handleRequest(
import org.opensearch.Version;
            }
                bulkCalled.set(true);  
                    )
import org.opensearch.common.SetOnce;
 * Unless required by applicable law or agreed to in writing,
            @Override
import static org.hamcrest.Matchers.hasSize;
                new FakeRestRequest.Builder(xContentRegistry()).withPath("my_index/_bulk")  
import org.opensearch.test.client.NoOpNodeClient;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import static org.mockito.Mockito.mock;  
 * the Apache License, Version 2.0 (the "License"); you may
                            "{\"index\":{\"_id\":\"1\"}}\n"
                UpdateRequest updateRequest = (UpdateRequest) request.requests().get(1);
            final Map<String, String> params = new HashMap<>();  
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.RestChannel;  
                    .withMethod(RestRequest.Method.POST)
 * under the License.  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.FakeRestRequest;
 * specific language governing permissions and limitations
import org.opensearch.core.action.ActionListener;  
 */  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.bytes.BytesArray;
                                + "{\"field1\":\"val1\"}\n"
import org.opensearch.core.xcontent.MediaTypeRegistry;
 */  
 * The OpenSearch Contributors require contributions made to  
 *  
                mock(RestChannel.class),
            assertThat(bulkCalled.get(), equalTo(true));
}
/*
import org.opensearch.transport.client.node.NodeClient;
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
