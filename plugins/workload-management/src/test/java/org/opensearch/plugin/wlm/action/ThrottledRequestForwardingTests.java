import org.opensearch.Version;  
            Settings.builder().put("node_limit", 5).build()
    @After
 */  
import org.opensearch.test.transport.MockTransportService;  
    }  
            oldNode.getLocalNode(),
        @SuppressWarnings("unchecked")
import org.opensearch.common.xcontent.XContentHelper;  
        return service;
 * compatible open source license.
            ACTION,
        service.registerRequestHandler(  
import org.junit.After;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals("cannot send workload group throttling to a node before version " + Version.V_3_10_0, rootCause.get("reason"));
        Map<String, Object> rootCause = ((List<Map<String, Object>>) ((Map<String, Object>) body.get("error")).get("root_cause")).get(0);  
import org.opensearch.transport.SendRequestTransportException;  
import org.opensearch.wlm.ResourceType;
            (request, channel, task) -> fail("the request must not reach the older node")
        oldNode.close();
        assertEquals("illegal_argument_exception", rootCause.get("type"));
        return new MutableWorkloadGroupFragment(  
    private MockTransportService startNode(Version version) {
import java.util.concurrent.TimeUnit;  
        ExecutionException e = expectThrows(ExecutionException.class, () -> future.get(30, TimeUnit.SECONDS));
import org.opensearch.OpenSearchException;
import java.util.Map;
    }  
        newNode.sendRequest(
    }  
import org.opensearch.wlm.MutableWorkloadGroupFragment;
    private static final String ACTION = "cluster:admin/opensearch/wlm/test_forward";
 *
}
 * connection, as when the cluster-manager has not been upgraded yet, and checks the error an operator would see.
    public void testThrottledUpdateToPre310NodeIsBadRequest() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
    public void testThrottledCreateToPre310NodeIsBadRequest() throws IOException {
            .name("throttled_group")
        );  
    private void assertBadRequestNamingVersion(Exception e) throws IOException {
        MockTransportService service = MockTransportService.createNewService(Settings.EMPTY, version, threadPool, NoopTracer.INSTANCE);
/*  
import org.opensearch.ExceptionsHelper;
    @Before
    }  
import java.util.concurrent.ExecutionException;
        assertBadRequestNamingVersion(forward(new CreateWorkloadGroupRequest(group)));  
            ACTION,  
    private static MutableWorkloadGroupFragment throttledFragment() {
 */
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.rest.RestStatus;  
public class ThrottledRequestForwardingTests extends OpenSearchTestCase {  
    private MockTransportService newNode;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContent;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        assertEquals(RestStatus.BAD_REQUEST, ExceptionsHelper.status(e));
        Map<String, Object> body = XContentHelper.convertToMap(BytesReference.bytes(builder), false, MediaTypeRegistry.JSON).v2();
        newNode.connectToNode(oldNode.getLocalNode());
            ResiliencyMode.ENFORCED,
import org.opensearch.transport.TransportRequest;
import org.opensearch.action.support.PlainActionFuture;
        PlainActionFuture<AcknowledgedResponse> future = new PlainActionFuture<>();  
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private MockTransportService oldNode;  
        OpenSearchException.generateFailureXContent(builder, ToXContent.EMPTY_PARAMS, e, true);
            .mutableWorkloadGroupFragment(throttledFragment())  
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;  
            ThreadPool.Names.SAME,
        assertBadRequestNamingVersion(forward(new UpdateWorkloadGroupRequest("throttled_group", throttledFragment())));
import java.util.List;  
import java.io.IOException;
            Settings.EMPTY,  
        builder.endObject();  
        newNode.close();  
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
            .build();
        // Render the error body the way BytesRestResponse does with detailed errors (the default).  
import org.opensearch.core.common.bytes.BytesReference;
        service.acceptIncomingRequests();
import org.opensearch.action.ActionListenerResponseHandler;
/**
            ._id("throttled_group_id")
    }
            request,
        WorkloadGroup group = WorkloadGroup.builder()  
import org.opensearch.test.OpenSearchTestCase;
            Map.of(ResourceType.MEMORY, 0.5),
import org.opensearch.core.xcontent.XContentBuilder;  
            new ActionListenerResponseHandler<>(future, AcknowledgedResponse::new)
    private ThreadPool threadPool;
import org.opensearch.threadpool.TestThreadPool;
        );
    public void stopNodes() {
import org.junit.Before;  
        newNode = startNode(Version.V_3_10_0);  
    private Exception forward(TransportRequest request) {
 * Sends throttled create/update requests from a {@link Version#V_3_10_0} node to a pre-3.10 node over a real transport  
            UpdateWorkloadGroupRequest::new,  
    public void startNodes() {  
    }
    }  
        return (Exception) e.getCause();
        threadPool = new TestThreadPool(getTestName());
    }
        oldNode = startNode(Version.V_3_9_0);
        assertTrue("expected a send failure but was " + e, e instanceof SendRequestTransportException);  
            .updatedAt(1690934400000L)
        service.start();  
package org.opensearch.plugin.wlm.action;
        );
import org.opensearch.cluster.metadata.WorkloadGroup;
