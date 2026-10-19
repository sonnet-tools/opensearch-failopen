        DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();
 * The OpenSearch Contributors require contributions made to  
import static java.util.Collections.emptySet;
        assertEquals("Request failed: action [test-action] is not registered for any extension.", responseString);
package org.opensearch.extensions.action;
import com.google.protobuf.ByteString;
    public void tearDown() throws Exception {
            mockActionModule,
        extensionTransportActionsHandler.registerAction(action, discoveryExtensionNode.getId());
            Version.fromString("3.0.0"),  
import java.util.Collections;
    }
        // Test duplicate action registration
                "test_node",
            new NamedWriteableRegistry(Collections.emptyList()),  
            "uniqueid1",
            NoopTracer.INSTANCE
                emptySet(),
            request
        );  
 * SPDX-License-Identifier: Apache-2.0
            ActionNotFoundTransportException.class,
    private MockNioTransport transport;  
        Settings settings = Settings.builder().put("cluster.name", "test").build();
import org.opensearch.action.support.ActionFilters;
        TransportActionRequestFromExtension request = new TransportActionRequestFromExtension(action, requestBytes, "uniqueid1");  
import org.opensearch.test.OpenSearchTestCase;
            (boundAddress) -> new DiscoveryNode(  
    private final ThreadPool threadPool = new TestThreadPool(RestSendToExtensionActionTests.class.getSimpleName());
        );  
        expectThrows(NodeNotConnectedException.class, () -> extensionTransportActionsHandler.sendTransportRequestToExtension(request));
import org.opensearch.cluster.node.DiscoveryNode;  
        String action = "test-action";
import org.junit.After;  
        assertFalse(response.getStatus());  
            Collections.emptyList()
        client = new NoOpNodeClient(this.getTestName());  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.transport.TransportAddress;
 *
import org.opensearch.transport.client.node.NodeClient;
import static org.mockito.Mockito.mock;  
 */  
        discoveryExtensionNode = new DiscoveryExtensionNode(  
    public void testRegisterTransportActionsRequest() {
                "test_node",
    private NodeClient client;  
import org.opensearch.test.transport.MockTransportService;
        client.close();
        extensionTransportActionsHandler = new ExtensionTransportActionsHandler(  
            Map.of("uniqueid1", discoveryExtensionNode),
    @Before  
            () -> extensionTransportActionsHandler.sendTransportRequestToExtension(request)  
import java.util.concurrent.TimeUnit;
    public void testSendTransportRequestToExtension() throws InterruptedException {
    public void testRegisterAction() {  
import org.opensearch.action.ActionModule;  
        RegisterTransportActionsRequest request = new RegisterTransportActionsRequest("uniqueid1", Set.of(action));  
import org.opensearch.transport.ActionNotFoundTransportException;
        response = (AcknowledgedResponse) extensionTransportActionsHandler.handleRegisterTransportActionsRequest(request);
        when(mockActionModule.getActionFilters()).thenReturn(EMPTY_FILTERS);
        );  
        assertEquals(discoveryExtensionNode, extensionTransportActionsHandler.getExtension(action));
}  
import org.opensearch.extensions.rest.RestSendToExtensionActionTests;  
        assertEquals(discoveryExtensionNode, extensionTransportActionsHandler.getExtension(action));  
            Version.fromString("3.0.0"),
import org.opensearch.action.ActionModule.DynamicActionRegistry;
        ByteString requestBytes = ByteString.copyFromUtf8("requestBytes");
        AcknowledgedResponse response = (AcknowledgedResponse) extensionTransportActionsHandler.handleRegisterTransportActionsRequest(
        // Test duplicate action registration
        String action = "test-action";
    public void testTransportActionRequestFromExtension() throws Exception {  
        ExtensionActionRequest request = new ExtensionActionRequest(action, requestBytes);
            ),
        );
import org.opensearch.common.settings.Settings;
            registerRequest  
            transport,  
import org.opensearch.threadpool.TestThreadPool;
        when(mockActionModule.getDynamicActionRegistry()).thenReturn(dynamicActionRegistry);
        ActionModule mockActionModule = mock(ActionModule.class);
import org.opensearch.common.util.PageCacheRecycler;  
import org.opensearch.transport.TransportService;  
        assertEquals(discoveryExtensionNode, extensionTransportActionsHandler.getExtension(action));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            new HashMap<String, String>(),
        String action = "test-action";
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),  
import org.opensearch.Version;
            Collections.emptySet(),  
    private ExtensionTransportActionsHandler extensionTransportActionsHandler;
    private static final ActionFilters EMPTY_FILTERS = new ActionFilters(Collections.emptySet());
    }
    }
        String action = "test-action";
/*  
            IllegalArgumentException.class,
        assertFalse(response.isSuccess());
            () -> extensionTransportActionsHandler.registerAction(action, discoveryExtensionNode.getId())
import org.opensearch.test.client.NoOpNodeClient;  
        assertTrue(response.getStatus());
public class ExtensionTransportActionsHandlerTests extends OpenSearchTestCase {  
        ByteString requestBytes = ByteString.copyFromUtf8("requestBytes");  
            settings,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
import org.opensearch.transport.nio.MockNioTransport;
import org.opensearch.extensions.AcknowledgedResponse;
import org.opensearch.common.network.NetworkService;
                emptyMap(),
import static java.util.Collections.emptyMap;
        super.tearDown();  
    private TransportService transportService;
        transport = new MockNioTransport(  
import java.util.HashMap;
import static org.mockito.Mockito.when;
            Version.CURRENT,
            transportService,
                boundAddress.publishAddress(),  
        );
    @After
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
import java.net.InetAddress;  
    }
            null,
        transportService.close();
        AcknowledgedResponse response = (AcknowledgedResponse) extensionTransportActionsHandler.handleRegisterTransportActionsRequest(
    public void setup() throws Exception {
                Version.CURRENT  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        RegisterTransportActionsRequest registerRequest = new RegisterTransportActionsRequest("uniqueid1", Set.of(action));
            "firstExtension",
        );
            new NoneCircuitBreakerService(),
        );
        expectThrows(  
    private DiscoveryExtensionNode discoveryExtensionNode;
            settings,
        assertTrue(response.getStatus());
            new NetworkService(Collections.emptyList()),
        String responseString = response.getResponseBytesAsString();  
 * compatible open source license.
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            null
    }
import org.opensearch.transport.NodeNotConnectedException;
            NoopTracer.INSTANCE
import org.junit.Before;
            threadPool,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        dynamicActionRegistry.registerUnmodifiableActionMap(Collections.emptyMap());  
        transportService = new MockTransportService(
        expectThrows(
import java.util.Map;  
        RemoteExtensionActionResponse response = extensionTransportActionsHandler.handleTransportActionRequestFromExtension(request);
        );  
        // Action not registered, expect exception  
            threadPool,  
            client,  
import org.opensearch.extensions.DiscoveryExtensionNode;
        // Register Action  
import java.util.Set;
import org.opensearch.threadpool.ThreadPool;  
    }
