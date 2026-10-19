import org.opensearch.plugins.Plugin;
            StreamTransportResponseHandler<StreamDataResponse> handler = new StreamTransportResponseHandler<StreamDataResponse>() {
import org.opensearch.transport.TransportRequestOptions;
        for (DiscoveryNode node : getClusterState().nodes()) {
import org.opensearch.cluster.node.DiscoveryNode;
    }
import org.opensearch.transport.stream.StreamTransportResponse;
    @Override  
import org.opensearch.transport.TransportException;  
            assertEquals("Stream data item 3", responses.get(2).getMessage());
import java.io.IOException;
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import java.util.Collection;  
}  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)
import org.opensearch.transport.StreamTransportService;
                        streamResponse.close();  
                            responses.add(response);
                    fail("Transport exception: " + exp.getMessage());
            assertEquals("Stream data item 1", responses.get(0).getMessage());  
    @LockFeatureFlag(STREAM_TRANSPORT)  
                        StreamDataResponse response;
                public void handleStreamResponse(StreamTransportResponse<StreamDataResponse> streamResponse) {  
                public void handleException(TransportException exp) {  
                    }
                }  
            // Wait for responses  
    public void setUp() throws Exception {
                        }
                    try {
                    return ThreadPool.Names.SAME;  
            );
    public void testStreamTransportAction() throws Exception {
 */  
package org.opensearch.example.stream;
            assertTrue(latch.await(2, TimeUnit.SECONDS));
                TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
import org.opensearch.threadpool.ThreadPool;  
                }
 * compatible open source license.
        return List.of(StreamTransportExamplePlugin.class, FlightStreamPlugin.class);
                public String executor() {
            assertTrue(responses.get(2).isLast());  
                        while ((response = streamResponse.nextResponse()) != null) {  
                        streamResponse.cancel("Test error", e);  
public class StreamTransportExampleIT extends OpenSearchIntegTestCase {
                @Override  
            };
        }
    @AwaitsFix(bugUrl = "")
            assertEquals(3, responses.size());
    @Override  
                        fail("Stream processing failed: " + e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
 *
        internalCluster().ensureAtLeastNumDataNodes(2);  
            StreamDataRequest request = new StreamDataRequest(3, 1);  
            List<StreamDataResponse> responses = new ArrayList<>();
                    return new StreamDataResponse(in);
import org.opensearch.test.OpenSearchIntegTestCase;
    }
import java.util.ArrayList;
                        latch.countDown();
                @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            CountDownLatch latch = new CountDownLatch(1);  
                StreamDataAction.NAME,  
import java.util.concurrent.CountDownLatch;
import org.opensearch.core.common.io.stream.StreamInput;  
                node,
import java.util.concurrent.TimeUnit;  
import java.util.List;
/*  
                    } catch (Exception e) {
            streamTransportService.sendRequest(
                handler  
                }  
                @Override
    }  
            assertEquals("Stream data item 2", responses.get(1).getMessage());
        super.setUp();
import org.opensearch.transport.StreamTransportResponseHandler;
                @Override
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
                public StreamDataResponse read(StreamInput in) throws IOException {
                request,
 * The OpenSearch Contributors require contributions made to  
            StreamTransportService streamTransportService = internalCluster().getInstance(StreamTransportService.class);  
                }
 * this file be licensed under the Apache-2.0 license or a
