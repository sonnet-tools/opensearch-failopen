        transportService = new MockTransportService(
        );
            Version.fromString("3.0.0"),
        transportService.close();
        RemoteExtensionActionResponse response = extensionTransportActionsHandler.handleTransportActionRequestFromExtension(request);
        assertTrue(response.getStatus());
    public void testSendTransportRequestToExtension() throws InterruptedException {
import org.opensearch.action.ActionModule.DynamicActionRegistry;
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
import org.opensearch.Version;
        expectThrows(
        );
        assertFalse(response.isSuccess());
        transport = new MockNioTransport(
 *
import org.opensearch.extensions.DiscoveryExtensionNode;
    }
import static org.mockito.Mockito.mock;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        response = (AcknowledgedResponse) extensionTransportActionsHandler.handleRegisterTransportActionsRequest(request);
    @Override
        ByteString requestBytes = ByteString.copyFromUtf8("requestBytes");
        String action = "test-action";
        RegisterTransportActionsRequest request = new RegisterTransportActionsRequest("uniqueid1", Set.of(action));
import java.util.concurrent.TimeUnit;
        DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();
public class ExtensionTransportActionsHandlerTests extends OpenSearchTestCase {
        // Test duplicate action registration
            Collections.emptyList()
    private NodeClient client;
        ActionModule mockActionModule = mock(ActionModule.class);
            request
        assertEquals("Request failed: action [test-action] is not registered for any extension.", responseString);
import org.opensearch.extensions.AcknowledgedResponse;
        super.tearDown();
        client = new NoOpNodeClient(this.getTestName());
                emptySet(),
    private ExtensionTransportActionsHandler extensionTransportActionsHandler;
import org.opensearch.common.network.NetworkService;
        TransportActionRequestFromExtension request = new TransportActionRequestFromExtension(action, requestBytes, "uniqueid1");
import org.opensearch.threadpool.ThreadPool;
        );
            new NamedWriteableRegistry(Collections.emptyList()),
 * The OpenSearch Contributors require contributions made to
import com.google.protobuf.ByteString;
            Version.CURRENT,
    private final ThreadPool threadPool = new TestThreadPool(RestSendToExtensionActionTests.class.getSimpleName());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
import org.opensearch.transport.TransportService;
        assertEquals(discoveryExtensionNode, extensionTransportActionsHandler.getExtension(action));
            Version.fromString("3.0.0"),
import org.opensearch.cluster.node.DiscoveryNode;
        assertFalse(response.getStatus());
            client,
        );
import org.opensearch.common.settings.Settings;
        client.close();
            "uniqueid1",
    public void testRegisterAction() {
import java.util.HashMap;
        assertEquals(discoveryExtensionNode, extensionTransportActionsHandler.getExtension(action));
            null,
            IllegalArgumentException.class,
        assertTrue(response.getStatus());
import static org.mockito.Mockito.when;
        extensionTransportActionsHandler = new ExtensionTransportActionsHandler(
                "test_node",
            "firstExtension",
import org.opensearch.transport.NodeNotConnectedException;
    public void testTransportActionRequestFromExtension() throws Exception {
    }
import org.opensearch.extensions.rest.RestSendToExtensionActionTests;
import org.junit.After;
        extensionTransportActionsHandler.registerAction(action, discoveryExtensionNode.getId());
                "test_node",
    public void setup() throws Exception {
            new NetworkService(Collections.emptyList()),
        dynamicActionRegistry.registerUnmodifiableActionMap(Collections.emptyMap());
        String action = "test-action";
import org.junit.Before;
    }
import java.util.Set;
            Collections.emptySet(),
            ),
    }
            (boundAddress) -> new DiscoveryNode(
import java.util.Map;
        ExtensionActionRequest request = new ExtensionActionRequest(action, requestBytes);
            NoopTracer.INSTANCE
import org.opensearch.core.common.transport.TransportAddress;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
 * this file be licensed under the Apache-2.0 license or a
            new HashMap<String, String>(),
                boundAddress.publishAddress(),
    @Before
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        when(mockActionModule.getActionFilters()).thenReturn(EMPTY_FILTERS);
        String action = "test-action";
import org.opensearch.test.client.NoOpNodeClient;
import org.opensearch.test.OpenSearchTestCase;
    @After
    private DiscoveryExtensionNode discoveryExtensionNode;
        Settings settings = Settings.builder().put("cluster.name", "test").build();
        discoveryExtensionNode = new DiscoveryExtensionNode(
        );
        String action = "test-action";
 * compatible open source license.
    private static final ActionFilters EMPTY_FILTERS = new ActionFilters(Collections.emptySet());
import org.opensearch.action.ActionModule;
import org.opensearch.transport.client.node.NodeClient;
    public void tearDown() throws Exception {
        expectThrows(
                emptyMap(),
import org.opensearch.threadpool.TestThreadPool;
        String responseString = response.getResponseBytesAsString();
        ByteString requestBytes = ByteString.copyFromUtf8("requestBytes");
import static java.util.Collections.emptySet;
        );
import java.util.Collections;
import org.opensearch.transport.nio.MockNioTransport;
            registerRequest
        when(mockActionModule.getDynamicActionRegistry()).thenReturn(dynamicActionRegistry);
        AcknowledgedResponse response = (AcknowledgedResponse) extensionTransportActionsHandler.handleRegisterTransportActionsRequest(
            settings,
        // Register Action
package org.opensearch.extensions.action;
 * SPDX-License-Identifier: Apache-2.0
    }
            mockActionModule,
/*
        );
    private TransportService transportService;
            ActionNotFoundTransportException.class,
            NoopTracer.INSTANCE
import org.opensearch.transport.ActionNotFoundTransportException;
            () -> extensionTransportActionsHandler.registerAction(action, discoveryExtensionNode.getId())
            () -> extensionTransportActionsHandler.sendTransportRequestToExtension(request)
import static java.util.Collections.emptyMap;
        expectThrows(NodeNotConnectedException.class, () -> extensionTransportActionsHandler.sendTransportRequestToExtension(request));
import java.net.InetAddress;
import org.opensearch.test.transport.MockTransportService;
        // Action not registered, expect exception
            transport,
    private MockNioTransport transport;
        // Test duplicate action registration
            settings,
            null
            new NoneCircuitBreakerService(),
    public void testRegisterTransportActionsRequest() {
        );
    }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        RegisterTransportActionsRequest registerRequest = new RegisterTransportActionsRequest("uniqueid1", Set.of(action));
            Map.of("uniqueid1", discoveryExtensionNode),
}
            threadPool,
            transportService,
import org.opensearch.common.util.PageCacheRecycler;
 */
        assertEquals(discoveryExtensionNode, extensionTransportActionsHandler.getExtension(action));
import org.opensearch.action.support.ActionFilters;
            threadPool,
        AcknowledgedResponse response = (AcknowledgedResponse) extensionTransportActionsHandler.handleRegisterTransportActionsRequest(
                Version.CURRENT
