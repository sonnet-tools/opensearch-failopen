}
        }  
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
 */
            new BytesArray("{invalid_json}"),  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.FakeRestRequest;  
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
    }
package org.opensearch.search.pit;
                pitCalled.set(true);  
 * Tests to verify the behavior of rest delete pit action for list delete and delete all PIT endpoints  
            assertThat(pitCalled.get(), equalTo(true));
            public void deletePits(DeletePitRequest request, ActionListener<DeletePitResponse> listener) {  
            }  
public class RestDeletePitActionTests extends OpenSearchTestCase {
                () -> action.handleRequest(request, channel, nodeClient)  
        ).build();
            RestDeletePitAction action = new RestDeletePitAction();  
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {  
        RestDeletePitAction action = new RestDeletePitAction();
    public void testDeleteAllPit() throws Exception {
    }
                assertThat(request.getPitIds().get(0), equalTo("BODY"));
/*  
import org.opensearch.test.rest.FakeRestChannel;
            public void deletePits(DeletePitRequest request, ActionListener<DeletePitResponse> listener) {
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(
import static org.hamcrest.Matchers.equalTo;
 */  
 * compatible open source license.
import org.opensearch.action.search.DeletePitResponse;
            @Override
            action.handleRequest(request, channel, nodeClient);
            @Override  
        SetOnce<Boolean> pitCalled = new SetOnce<>();
            }
import org.opensearch.rest.action.search.RestDeletePitAction;
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {
                assertThat(request.getPitIds(), hasSize(1));
                Collections.singletonMap("pit_id", "QUERY_STRING,QUERY_STRING_1")
            RestDeletePitAction action = new RestDeletePitAction();
import org.opensearch.test.client.NoOpNodeClient;
            IllegalArgumentException ex = expectThrows(
        assertThat(e.getMessage(), equalTo("Failed to parse request body"));
                MediaTypeRegistry.JSON
import org.opensearch.transport.client.node.NodeClient;
            ).build();
import org.opensearch.rest.RestRequest;
            public void deletePits(DeletePitRequest request, ActionListener<DeletePitResponse> listener) {
        SetOnce<Boolean> pitCalled = new SetOnce<>();  
    }
        }
/**
 *
            );
    public void testParseDeletePitRequestWithInvalidJsonThrowsException() throws Exception {  
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(request, null));  
            }  
            assertTrue(ex.getMessage().contains("unrecognized param"));
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
            @Override
        }  
import org.opensearch.core.common.bytes.BytesArray;
                assertThat(request.getPitIds().get(0), equalTo("_all"));  
import org.opensearch.action.search.DeletePitRequest;
            ).build();  
                new BytesArray("{\"pit_id\": [\"BODY\"]}"),
                IllegalArgumentException.class,
    public void testDeletePitWithBody() throws Exception {
        }) {
        }) {
                assertThat(request.getPitIds(), hasSize(2));  
        SetOnce<Boolean> pitCalled = new SetOnce<>();
            RestDeletePitAction action = new RestDeletePitAction();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public void testDeletePitQueryStringParamsShouldThrowException() {  
                assertThat(request.getPitIds().get(0), equalTo("QUERY_STRING"));
import org.opensearch.test.OpenSearchTestCase;  
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(  
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_all").build();
            action.handleRequest(request, channel, nodeClient);  
            assertThat(pitCalled.get(), equalTo(true));
                assertThat(request.getPitIds(), hasSize(1));
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);  
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {
import static org.hamcrest.Matchers.hasSize;  
import org.opensearch.common.SetOnce;  
            MediaTypeRegistry.JSON
import org.opensearch.core.action.ActionListener;
                pitCalled.set(true);
import java.util.Collections;  
    }  
        }) {
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(  
                pitCalled.set(true);
                assertThat(request.getPitIds().get(1), equalTo("QUERY_STRING_1"));
