            .path(uriPrefix + "/foo")
            identityService
    }
        );
        assertEquals(expected.size(), routes.size());
        assertTrue(paths.containsAll(expectedPaths));
        );
    }
    private DiscoveryExtensionNode discoveryExtensionNode;
            IllegalArgumentException.class,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 */
    }
                transportService,
                dynamicActionRegistry,
            IllegalArgumentException.class,
                registerRestActionRequest,
import org.opensearch.extensions.action.ExtensionTransportAction;
 *
        assertTrue(methods.containsAll(expectedMethods));
            "uniqueid1",
        );
        );
            identityService
import org.opensearch.action.admin.cluster.health.TransportClusterHealthAction;
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        assertTrue(expectedNames.containsAll(names));
import org.opensearch.extensions.ExtensionsManager;
        String uriPrefix = "/_extensions/_uniqueid1";
            );
        List<String> names = routes.stream().map(r -> ((NamedRoute) r).name()).collect(Collectors.toList());
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            List.of()
                dynamicActionRegistry,
            List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!")
            List.of("GET", "PUT /bar", "POST /baz"),
        expected.add(new Route(Method.PUT, uriPrefix + "/bar"));
    }
        ExtensionTransportAction testExtensionTransportAction = new ExtensionTransportAction("test:action/name", emptyFilters, null, null);
                boundAddress.publishAddress(),
        expected.add(nr1);
        NamedRoute nr1 = new NamedRoute.Builder().method(Method.GET)
                transportService,
            .path(uriPrefix + "/bar")
            List.of("GET /deprecated/foo", "It's deprecated!")
            "uniqueid1",
                dynamicActionRegistry,
            transport,
            "uniqueid1",
            transportService,
            List.of("GET /foo foo cluster:admin/opensearch/abc/foo", "PUT /bar bar cluster:admin/opensearch/abc/foo"),
    public void testRestSendToExtensionActionMissingDeprecatedUri() throws Exception {
        NamedRoute nr1 = new NamedRoute.Builder().method(Method.GET).path(uriPrefix + "/foo").uniqueName("foo").build();
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
        ActionFilters emptyFilters = new ActionFilters(Collections.emptySet());
    public void testRestSendToExtensionActionFilterHeaders() throws Exception {
            List.of("GET /foo", "GET /foo"),
        List<Method> expectedMethods = expected.stream().map(Route::getMethod).collect(Collectors.toList());
        expected.add(new Route(Method.GET, uriPrefix + "/foo"));
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
        assertTrue(methods.containsAll(expectedMethods));
/*
            .legacyActionNames(Set.of("cluster:admin/opensearch/jkl/bar", "cluster:admin/opendistro/mno/bar*"))
    private final ThreadPool threadPool = new TestThreadPool(RestSendToExtensionActionTests.class.getSimpleName());
            .path(uriPrefix + "/baz")
                emptyMap(),
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            List.of("GET /foo " + ClusterHealthAction.NAME),
        );
        try {
            IllegalArgumentException.class,
            List.of("GET /foo foo", "PUT /bar foo"),
            null,
    }
        expectThrows(
            List.of("GET /foo/{path_param} fooWithParam", "GET /foo/{path_param}/list listFooWithParam"),
                registerRestActionRequest,
            )
                identityService
        List<NamedRoute> expected = new ArrayList<>();
        List<Route> routes = restSendToExtensionAction.routes();
            List.of()
        );
        dynamicActionRegistry = actionModule.getDynamicActionRegistry();
                discoveryExtensionNode,
 * compatible open source license.
            null,
import java.net.InetAddress;
            .build();
        transportService.close();
            () -> new RestSendToExtensionAction(
            )
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            List.of("GET /deprecated/foo foo_deprecated", "Its deprecated")
        assertEquals(expected.size(), routes.size());
                registerRestActionRequest,
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
                discoveryExtensionNode,
            (boundAddress) -> new DiscoveryNode(
        dynamicActionRegistry.registerDynamicAction(testExtensionAction, testExtensionTransportAction);
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
                identityService
        );
        );
    public void testRestSendToExtensionMultipleNamedRoutesWithSameName() throws Exception {
        );
        expected.add(nr3);
                identityService
            Collections.emptyList()
                transportService,
    public void testRestSendToExtensionActionWithoutUniqueNameShouldFail() {
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            null,
    public void testRestSendToExtensionAction() throws Exception {
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
import org.opensearch.common.settings.Settings;
        assertTrue(expectedPaths.containsAll(paths));
            null,
        List<Method> methods = routes.stream().map(Route::getMethod).collect(Collectors.toList());
            emptyList(),
        assertTrue(expectedNames.containsAll(names));
        List<Method> methods = routes.stream().map(Route::getMethod).collect(Collectors.toList());
import org.opensearch.identity.IdentityService;
        List<Route> routes = restSendToExtensionAction.routes();
        );
                discoveryExtensionNode,
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
        SettingsModule settingsModule = new SettingsModule(settings);
        List<String> names = routes.stream().map(r -> ((NamedRoute) r).name()).collect(Collectors.toList());
        );
                discoveryExtensionNode,
import java.util.concurrent.TimeUnit;
            settingsModule.getSettingsFilter(),
            List.of("/foo", "PUT /bar", "POST /baz"),
        assertTrue(filteredHeaders.containsKey("Content-Type"));
                transportService,
            settingsModule.getClusterSettings(),
        expected.add(nr1);
            settings,
    private IdentityService identityService;
import java.util.HashMap;
                registerRestActionRequest,
    public void testRestSendToExtensionMultipleRoutesWithSameMethodAndPathWithPathParams() {
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            "uniqueid1",
            IllegalArgumentException.class,
                Version.CURRENT
    private TransportService transportService;
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        List<Method> expectedMethods = expected.stream().map(Route::getMethod).collect(Collectors.toList());
            new NamedWriteableRegistry(Collections.emptyList()),
    public void tearDown() throws Exception {
                registerRestActionRequest,
import org.opensearch.cluster.node.DiscoveryNode;
            List.of(
            IllegalArgumentException.class,
            discoveryExtensionNode,
}
                discoveryExtensionNode,
                discoveryExtensionNode,
        assertEquals("uniqueid1:send_to_extension_action", restSendToExtensionAction.getName());
                dynamicActionRegistry,
    public void setup() throws Exception {
        List<String> expectedPaths = expected.stream().map(Route::getPath).collect(Collectors.toList());
            "uniqueid1",
        expectThrows(
        super.tearDown();
    }
import java.util.List;
            "uniqueid1",
            )
import org.opensearch.test.transport.MockTransportService;
        expectThrows(
        List<Method> methods = routes.stream().map(Route::getMethod).collect(Collectors.toList());
            List.of()
        );
            List.of("GET /foo", "PUT /bar", "POST /baz"),
package org.opensearch.extensions.rest;
        List<Route> routes = restSendToExtensionAction.routes();
            IllegalArgumentException.class,
        assertEquals("uniqueid1:send_to_extension_action", restSendToExtensionAction.getName());
import org.opensearch.rest.NamedRoute;
        expectThrows(
        assertTrue(methods.containsAll(expectedMethods));
        DynamicActionRegistry dynamicActionRegistry = actionModule.getDynamicActionRegistry();
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
import org.opensearch.threadpool.ThreadPool;
        expected.add(nr3);
        headers.put("Authorization", Arrays.asList("Bearer token"));
        );
        List<Route> expected = new ArrayList<>();
    public void testRestSendToExtensionMultipleRoutesWithSameMethodAndPathWithDifferentPathParams() throws Exception {
    }
    public void testRestSendToExtensionActionWithNamedRouteAndLegacyActionName() throws Exception {
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
                discoveryExtensionNode,
                identityService
                identityService
            List.of("GET /foo test:action/name"),
        UsageService usageService = new UsageService();
            threadPool,
import org.opensearch.rest.RestHandler.Route;
            .legacyActionNames(Set.of("cluster:admin/opensearch/xyz/baz"))
            settingsModule.getIndexScopedSettings(),
                dynamicActionRegistry,
    }
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
import org.opensearch.threadpool.TestThreadPool;
                registerRestActionRequest,
        );
    }
        headers.put("Proxy-Authorization", Arrays.asList("Basic credentials"));
            Version.fromString("3.0.0"),
                emptySet(),
            threadPool,
        Set<String> denyList = Set.of("Authorization", "Proxy-Authorization"); // denied headers
            "uniqueid1",
        assertTrue(expectedActionNames.containsAll(actionNames));
import org.opensearch.common.util.PageCacheRecycler;
        transport = new MockNioTransport(
            dynamicActionRegistry,
                "GET /foo foo cluster:admin/opensearch/abc/foo",
        expectThrows(
            "uniqueid1",
        );
                transportService,
            List.of("GET", "It's deprecated!")
            List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!")
import static org.mockito.Mockito.mock;
import org.opensearch.transport.TransportService;
            "uniqueid1",
            List.of()
                identityService
        actionModule = new ActionModule(
import org.opensearch.Version;
                transportService,
            () -> new RestSendToExtensionAction(
            )
            () -> new RestSendToExtensionAction(
import static java.util.Collections.emptyMap;
                transportService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import static java.util.Collections.emptyList;
            NoopTracer.INSTANCE
            )
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.common.network.NetworkService;
        Set<String> expectedActionNames = expected.stream().flatMap(nr -> nr.actionNames().stream()).collect(Collectors.toSet());
            List.of("GET /deprecated/foo foo_deprecated cluster:admin/opensearch/abc/foo_deprecated", "It's deprecated!")
        ExtensionAction testExtensionAction = new ExtensionAction("extensionId", "test:action/name");
        List<String> paths = routes.stream().map(Route::getPath).collect(Collectors.toList());
import org.opensearch.rest.RestRequest.Method;
                identityService
            mock(ThreadPool.class),
    }
            List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz"),
        String uriPrefix = "/_extensions/_uniqueid1";
                dynamicActionRegistry,
            List.of()
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        List<NamedRoute> expected = new ArrayList<>();
                dynamicActionRegistry,
            () -> new RestSendToExtensionAction(
            List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz"),
    public void testRestSendToExtensionMultipleRoutesWithSameMethodAndPath() throws Exception {
        );
                transportService,
            transportService,
        expectThrows(
        NamedRoute nr2 = new NamedRoute.Builder().method(Method.PUT).path(uriPrefix + "/bar").uniqueName("bar").build();
            discoveryExtensionNode,
            )
import java.util.ArrayList;
    public void testRestSendToExtensionWithNamedRouteCollidingWithNativeTransportAction() throws Exception {
            .registerUnmodifiableActionMap(Map.of(ClusterHealthAction.INSTANCE, mock(TransportClusterHealthAction.class)));
import java.util.Collections;
            "uniqueid1",
            dynamicActionRegistry,
        identityService = new IdentityService(Settings.EMPTY, mock(ThreadPool.class), new ArrayList<>());
        );
        Settings settings = Settings.builder().put("cluster.name", "test").build();
                registerRestActionRequest,
            new NoneCircuitBreakerService(),
        );
                transportService,
            List.of("GET /deprecated/foo", "It's deprecated!")
    private MockNioTransport transport;
    private DynamicActionRegistry dynamicActionRegistry;
            identityService
    public void testRestSendToExtensionActionMissingUri() throws Exception {
            "firstExtension",
            settings,
        assertEquals("uniqueid1:send_to_extension_action", restSendToExtensionAction.getName());
                discoveryExtensionNode,
        Set<String> allowList = Set.of("Content-Type"); // allowed headers
            "uniqueid1",
            Version.CURRENT,
import org.junit.After;
public class RestSendToExtensionActionTests extends OpenSearchTestCase {
                "test_node",
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            "uniqueid1",
                "test_node",
                discoveryExtensionNode,
            .legacyActionNames(Set.of("cluster:admin/opensearch/abc/foo"))
            List.of()
                discoveryExtensionNode,
            "uniqueid1",
    @Before
import java.util.stream.Collectors;
                "PUT /bar bar cluster:admin/opensearch/jkl/bar,cluster:admin/opendistro/mno/bar*",
                discoveryExtensionNode,
import org.opensearch.common.util.concurrent.ThreadContext;
        );
        NamedRoute nr2 = new NamedRoute.Builder().method(Method.PUT)
                identityService
        );
        );
        } catch (IllegalArgumentException e) {
                "POST /baz baz cluster:admin/opensearch/xyz/baz"
        expected.add(new Route(Method.POST, uriPrefix + "/baz"));
        actionModule.getDynamicActionRegistry()
        List<String> paths = routes.stream().map(Route::getPath).collect(Collectors.toList());
        assertFalse(filteredHeaders.containsKey("Authorization"));
    }
            fail("IllegalArgumentException should not be thrown for different paths");
                identityService
            .uniqueName("baz")
        NamedRoute nr3 = new NamedRoute.Builder().method(Method.POST)
            discoveryExtensionNode,
        List<String> expectedPaths = expected.stream().map(Route::getPath).collect(Collectors.toList());
        Map<String, List<String>> filteredHeaders = restSendToExtensionAction.filterHeaders(headers, allowList, denyList);
        );
        assertTrue(paths.containsAll(expectedPaths));
                identityService
        Set<String> actionNames = routes.stream().flatMap(nr -> ((NamedRoute) nr).actionNames().stream()).collect(Collectors.toSet());
        expected.add(nr2);
                identityService
        );
        expected.add(nr2);
            )
        );
        transportService = new MockTransportService(
        assertTrue(expectedMethods.containsAll(methods));
            dynamicActionRegistry,
import org.opensearch.common.settings.SettingsModule;
        discoveryExtensionNode = new DiscoveryExtensionNode(
            () -> new RestSendToExtensionAction(
import org.opensearch.action.support.ActionFilters;
        headers.put("Content-Type", Arrays.asList("application/json"));
        assertTrue(expectedMethods.containsAll(methods));
    }
        }
        );
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                registerRestActionRequest,
            dynamicActionRegistry,
        expectThrows(
                identityService
        List<String> expectedNames = expected.stream().map(NamedRoute::name).collect(Collectors.toList());
            new NetworkService(Collections.emptyList()),
            )
            () -> new RestSendToExtensionAction(
            () -> new RestSendToExtensionAction(
            "uniqueid1",
    private ActionModule actionModule;
import org.opensearch.usage.UsageService;
            List.of("GET /foo", "PUT /bar", "POST /baz"),
            ),
                registerRestActionRequest,
        NamedRoute nr3 = new NamedRoute.Builder().method(Method.POST).path(uriPrefix + "/baz").uniqueName("baz").build();
            discoveryExtensionNode,
    }
        expectThrows(
            NoopTracer.INSTANCE
    public void testRestSendToExtensionWithNamedRouteCollidingWithDynamicTransportAction() throws Exception {
        List<String> expectedPaths = expected.stream().map(Route::getPath).collect(Collectors.toList());
            new RestSendToExtensionAction(
        );
        String uriPrefix = "/_extensions/_uniqueid1";
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        );
        assertTrue(expectedPaths.containsAll(paths));
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
import java.util.Set;
        List<String> expectedNames = expected.stream().map(NamedRoute::name).collect(Collectors.toList());
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
            .build();
            "uniqueid1",
        );
import java.util.Map;
                transportService,
            identityService
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionModule;
        List<Method> expectedMethods = expected.stream().map(Route::getMethod).collect(Collectors.toList());
 * The OpenSearch Contributors require contributions made to
    public void testRestSendToExtensionMultipleNamedRoutesWithSameLegacyActionName() throws Exception {
                registerRestActionRequest,
        );
        expectThrows(
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        );
    public void testRestSendToExtensionActionWithNamedRoute() throws Exception {
            transportService,
        );
            () -> new RestSendToExtensionAction(
                transportService,
            settingsModule.getSettings(),
            .build();
import static java.util.Collections.emptySet;
            "uniqueid1",
        );
            )
            List.of("GET /foo", "PUT /bar"),
    }
            () -> new RestSendToExtensionAction(
            List.of()
            )
            List.of()
                discoveryExtensionNode,
            () -> new RestSendToExtensionAction(
            IllegalArgumentException.class,
                transportService,
            () -> new RestSendToExtensionAction(
        expectThrows(
                dynamicActionRegistry,
import org.opensearch.transport.nio.MockNioTransport;
                dynamicActionRegistry,
                registerRestActionRequest,
    public void testRestSendToExtensionActionBadMethod() throws Exception {
            Version.fromString("3.0.0"),
    @After
        );
import org.opensearch.extensions.action.ExtensionAction;
            ),
            registerRestActionRequest,
        assertTrue(expectedPaths.containsAll(paths));
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        assertFalse(filteredHeaders.containsKey("Proxy-Authorization"));
        List<String> paths = routes.stream().map(Route::getPath).collect(Collectors.toList());
            .uniqueName("foo")
            IllegalArgumentException.class,
            Collections.emptySet(),
import org.opensearch.action.ActionModule.DynamicActionRegistry;
            List.of("/deprecated/foo", "It's deprecated!")
            )
import org.junit.Before;
            List.of("GET /foo/{path_param1} fooWithParam", "GET /foo/{path_param2} listFooWithParam"),
    }
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.extensions.DiscoveryExtensionNode;
            "uniqueid1",
    }
    public void testRestSendToExtensionActionBadDeprecatedMethod() throws Exception {
            List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz"),
        );
            new IdentityService(Settings.EMPTY, mock(ThreadPool.class), new ArrayList<>()),
        expectThrows(
    }
                dynamicActionRegistry,
            new HashMap<String, String>(),
        assertEquals(expected.size(), routes.size());
        assertNull(dynamicActionRegistry.get(testExtensionAction));
            .uniqueName("bar")
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            registerRestActionRequest,
        );
    @Override
                dynamicActionRegistry,
        assertTrue(paths.containsAll(expectedPaths));
            IllegalArgumentException.class,
        assertTrue(expectedMethods.containsAll(methods));
import java.util.Arrays;
            usageService,
            registerRestActionRequest,
            registerRestActionRequest,
                registerRestActionRequest,
            transportService,
        Map<String, List<String>> headers = new HashMap<>();
                dynamicActionRegistry,
    }
            new ExtensionsManager(Set.of(), new IdentityService(Settings.EMPTY, mock(ThreadPool.class), List.of()))
import org.opensearch.test.OpenSearchTestCase;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
