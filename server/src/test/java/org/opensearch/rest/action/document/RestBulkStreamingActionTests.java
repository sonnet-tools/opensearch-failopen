import org.opensearch.Version;
import static org.mockito.Mockito.verify;
            final RestChannel channel = mock(RestChannel.class);  
 */  
import org.opensearch.core.action.ActionListener;  
import org.opensearch.rest.RestRequest;
 * compatible open source license.
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.rest.RestStatus;
import java.util.Map;
package org.opensearch.rest.action.document;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.action.bulk.BulkRequest;
                    MediaTypeRegistry.JSON
                            + "{\"field1\":\"val1\"}\n"
                bulkCalled.set(true);
import org.opensearch.rest.RestResponse;  
            final ArgumentCaptor<RestResponse> responseCaptor = ArgumentCaptor.captor();
                .build();
                .withMethod(RestRequest.Method.POST)
            assertThat(bulkCalled.get(), equalTo(null));
        }) {
                            + "{\"script\":{\"source\":\"ctx._source.counter++;\"},\"upsert\":{\"field1\":\"upserted_val\"}}\n"  
            new RestBulkStreamingAction(settings(Version.CURRENT).build()).handleRequest(request, channel, verifyingClient);
            verify(channel).sendResponse(responseCaptor.capture());
import org.opensearch.common.SetOnce;
/*  
import org.opensearch.action.bulk.BulkResponse;  
                .withParams(params)  
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.when;  
    }  
import org.opensearch.transport.client.node.NodeClient;
 * The OpenSearch Contributors require contributions made to  
            public void bulk(BulkRequest request, ActionListener<BulkResponse> listener) {
            when(channel.detailedErrorsEnabled()).thenReturn(true);  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            }  
            );
                containsString("Unable to initiate request / response streaming")  
                .withContent(
            request.param("rest.exception.stacktrace.skip", "false");
/**
                responseCaptor.getValue().content().utf8ToString(),
            params.put("pipeline", "timestamps");  
            final FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("my_index/_bulk/streaming")
                        "{\"index\":{\"_id\":\"1\"}}\n"  
import static org.hamcrest.Matchers.equalTo;  
import static org.mockito.Mockito.mock;
            request.param("error_trace", "false");  
            // We do not expect `bulk` action to be called since the default HTTP transport (netty4) does not support streaming
            when(channel.newErrorBuilder()).thenReturn(XContentType.YAML.contentBuilder());
 */
}
                            + "{\"update\":{\"_id\":\"2\"}}\n"
        }
import org.opensearch.rest.RestChannel;
        SetOnce<Boolean> bulkCalled = new SetOnce<>();
            assertThat(responseCaptor.getValue().status(), equalTo(RestStatus.BAD_REQUEST));  
            when(channel.request()).thenReturn(request);
        try (NodeClient verifyingClient = new NoOpNodeClient(this.getTestName()) {
public class RestBulkStreamingActionTests extends OpenSearchTestCase {
            final Map<String, String> params = new HashMap<>();
                    new BytesArray(
                    ),
    public void testBulkStreamingPipelineUpsert() throws Exception {  
import org.mockito.ArgumentCaptor;  
import org.opensearch.common.xcontent.XContentType;
                )  
 *
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.test.rest.FakeRestRequest;  
            @Override  
            assertThat(
import java.util.HashMap;  
import org.opensearch.test.client.NoOpNodeClient;
 * Tests for {@link RestBulkStreamingAction}.  
