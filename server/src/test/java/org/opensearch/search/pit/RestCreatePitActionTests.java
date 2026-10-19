            public void createPit(CreatePitRequest request, ActionListener<CreatePitResponse> listener) {  
import org.opensearch.common.SetOnce;  
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
            Map<String, String> params = new HashMap<>();  
            assertThat(createPitCalled.get(), equalTo(true));  
/**  
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)  
                assertFalse(request.shouldAllowPartialPitCreation());  
import static org.hamcrest.Matchers.equalTo;
 *
            }
                assertThat(request.getKeepAlive().getStringRep(), equalTo("1m"));
        SetOnce<Boolean> createPitCalled = new SetOnce<>();
                .build();
            params.put("keep_alive", "1m");
import org.opensearch.test.client.NoOpNodeClient;
            params.put("keep_alive", "1m");
                createPitCalled.set(true);
 * this file be licensed under the Apache-2.0 license or a
        }) {
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {
        }  
import org.opensearch.test.rest.FakeRestChannel;  
            }
import org.opensearch.test.rest.FakeRestRequest;
}
import org.opensearch.rest.action.search.RestCreatePitAction;  
            params.put("allow_partial_pit_creation", "false");
 * The OpenSearch Contributors require contributions made to  
                .build();
            @Override
public class RestCreatePitActionTests extends OpenSearchTestCase {  
            action.handleRequest(request, channel, nodeClient);
                assertThat(request.getKeepAlive().getStringRep(), equalTo("1m"));
        }) {
        SetOnce<Boolean> createPitCalled = new SetOnce<>();
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {
import org.opensearch.core.action.ActionListener;
                createPitCalled.set(true);
            action.handleRequest(request, channel, nodeClient);  
 * SPDX-License-Identifier: Apache-2.0
        }
/*  
    }
 * Tests to verify behavior of create pit rest action
package org.opensearch.search.pit;
import java.util.HashMap;
            Map<String, String> params = new HashMap<>();  
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;
                assertTrue(request.shouldAllowPartialPitCreation());  
    public void testRestCreatePit() throws Exception {
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);  
                .withMethod(RestRequest.Method.POST)  
                .withMethod(RestRequest.Method.POST)
import org.opensearch.action.search.CreatePitRequest;
import org.opensearch.action.search.CreatePitResponse;
 * compatible open source license.
            @Override
            public void createPit(CreatePitRequest request, ActionListener<CreatePitResponse> listener) {  
import org.opensearch.transport.client.node.NodeClient;
        RestCreatePitAction action = new RestCreatePitAction();  
 */
        RestCreatePitAction action = new RestCreatePitAction();  
import org.opensearch.rest.RestRequest;
    }
            assertThat(createPitCalled.get(), equalTo(true));
    public void testRestCreatePitDefaultPartialCreation() throws Exception {
 */  
