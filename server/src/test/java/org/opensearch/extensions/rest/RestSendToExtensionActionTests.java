        );
            Version.fromString("3.0.0"),
        );
        List<String> paths = routes.stream().map(Route::getPath).collect(Collectors.toList());
        Set<String> denyList = Set.of("Authorization", "Proxy-Authorization"); // denied headers
        expectThrows(
                dynamicActionRegistry,  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        expectThrows(
    }
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(  
        expectThrows(  
    }
            "uniqueid1",
            () -> new RestSendToExtensionAction(  
        headers.put("Content-Type", Arrays.asList("application/json"));  
        );
            "firstExtension",  
        expectThrows(
        );
    public void testRestSendToExtensionMultipleNamedRoutesWithSameLegacyActionName() throws Exception {  
        try {
            IllegalArgumentException.class,
        List<Method> expectedMethods = expected.stream().map(Route::getMethod).collect(Collectors.toList());
        NamedRoute nr3 = new NamedRoute.Builder().method(Method.POST)
            () -> new RestSendToExtensionAction(
        );
            .legacyActionNames(Set.of("cluster:admin/opensearch/abc/foo"))
            settings,
        List<Method> methods = routes.stream().map(Route::getMethod).collect(Collectors.toList());
            new RestSendToExtensionAction(
        );  
        Map<String, List<String>> filteredHeaders = restSendToExtensionAction.filterHeaders(headers, allowList, denyList);
    }
                registerRestActionRequest,  
                identityService  
import java.util.Arrays;
    public void testRestSendToExtensionActionBadMethod() throws Exception {
            .build();
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
                identityService  
    }  
                registerRestActionRequest,  
        List<String> expectedNames = expected.stream().map(NamedRoute::name).collect(Collectors.toList());
            List.of("GET /foo test:action/name"),  
                discoveryExtensionNode,
        expected.add(nr1);
        assertEquals("uniqueid1:send_to_extension_action", restSendToExtensionAction.getName());
                dynamicActionRegistry,
    public void testRestSendToExtensionWithNamedRouteCollidingWithNativeTransportAction() throws Exception {
            List.of("GET /deprecated/foo foo_deprecated", "Its deprecated")
            "uniqueid1",
            identityService
        expectThrows(  
                identityService  
                discoveryExtensionNode,
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            .uniqueName("baz")
                identityService  
            "uniqueid1",  
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
            "uniqueid1",
        List<Method> methods = routes.stream().map(Route::getMethod).collect(Collectors.toList());  
        );  
            identityService
                transportService,
            IllegalArgumentException.class,  
                transportService,
                identityService
                registerRestActionRequest,  
        expectThrows(  
        DynamicActionRegistry dynamicActionRegistry = actionModule.getDynamicActionRegistry();  
        assertNull(dynamicActionRegistry.get(testExtensionAction));
        expected.add(new Route(Method.PUT, uriPrefix + "/bar"));
        super.tearDown();
        );
    }
        );  
        String uriPrefix = "/_extensions/_uniqueid1";
        assertTrue(expectedPaths.containsAll(paths));
            NoopTracer.INSTANCE  
                dynamicActionRegistry,  
            )
        List<Route> expected = new ArrayList<>();
            List.of()
            .build();
                "POST /baz baz cluster:admin/opensearch/xyz/baz"
        actionModule.getDynamicActionRegistry()
            List.of("GET /deprecated/foo foo_deprecated cluster:admin/opensearch/abc/foo_deprecated", "It's deprecated!")  
        List<Method> expectedMethods = expected.stream().map(Route::getMethod).collect(Collectors.toList());
        expectThrows(  
            ),
            .build();  
            IllegalArgumentException.class,
        );
        );
        );
            new NamedWriteableRegistry(Collections.emptyList()),
        NamedRoute nr3 = new NamedRoute.Builder().method(Method.POST).path(uriPrefix + "/baz").uniqueName("baz").build();
            List.of("GET /foo", "PUT /bar"),  
        assertTrue(filteredHeaders.containsKey("Content-Type"));  
    }
        Set<String> allowList = Set.of("Content-Type"); // allowed headers
            .legacyActionNames(Set.of("cluster:admin/opensearch/xyz/baz"))
            List.of()
                Version.CURRENT
        List<Method> expectedMethods = expected.stream().map(Route::getMethod).collect(Collectors.toList());
                discoveryExtensionNode,
import org.opensearch.extensions.action.ExtensionAction;
            IllegalArgumentException.class,  
            registerRestActionRequest,
import org.opensearch.rest.NamedRoute;
            threadPool,
    public void testRestSendToExtensionActionFilterHeaders() throws Exception {  
            IllegalArgumentException.class,
        headers.put("Proxy-Authorization", Arrays.asList("Basic credentials"));
        List<Route> routes = restSendToExtensionAction.routes();
                identityService
        );
        );
                discoveryExtensionNode,
        );  
            null,
import org.opensearch.Version;
            new IdentityService(Settings.EMPTY, mock(ThreadPool.class), new ArrayList<>()),
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        List<Method> methods = routes.stream().map(Route::getMethod).collect(Collectors.toList());  
                transportService,
    @Override
        );  
            transportService,
        assertTrue(paths.containsAll(expectedPaths));  
            )
        List<String> expectedNames = expected.stream().map(NamedRoute::name).collect(Collectors.toList());  
                registerRestActionRequest,
        String uriPrefix = "/_extensions/_uniqueid1";  
        ExtensionTransportAction testExtensionTransportAction = new ExtensionTransportAction("test:action/name", emptyFilters, null, null);  
                transportService,
        );  
    }  
import org.opensearch.rest.RestHandler.Route;
            List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz"),
            null,  
        List<String> names = routes.stream().map(r -> ((NamedRoute) r).name()).collect(Collectors.toList());
    }  
            .uniqueName("foo")  
            () -> new RestSendToExtensionAction(
        );
        );
        );  
        );
    public void testRestSendToExtensionActionBadDeprecatedMethod() throws Exception {
        expectThrows(
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
            (boundAddress) -> new DiscoveryNode(
                registerRestActionRequest,  
            List.of("/foo", "PUT /bar", "POST /baz"),
            IllegalArgumentException.class,
                identityService
            dynamicActionRegistry,
            .path(uriPrefix + "/bar")
            Collections.emptyList()  
import java.util.concurrent.TimeUnit;
    public void testRestSendToExtensionMultipleNamedRoutesWithSameName() throws Exception {  
        }
        List<String> expectedPaths = expected.stream().map(Route::getPath).collect(Collectors.toList());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            registerRestActionRequest,  
        assertEquals("uniqueid1:send_to_extension_action", restSendToExtensionAction.getName());  
            () -> new RestSendToExtensionAction(
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
                discoveryExtensionNode,
                dynamicActionRegistry,  
        );
            "uniqueid1",
                discoveryExtensionNode,  
        SettingsModule settingsModule = new SettingsModule(settings);
        UsageService usageService = new UsageService();  
            "uniqueid1",  
    public void testRestSendToExtensionActionMissingDeprecatedUri() throws Exception {
        );
        assertTrue(expectedActionNames.containsAll(actionNames));  
import org.junit.Before;
                identityService
package org.opensearch.extensions.rest;
        assertTrue(expectedNames.containsAll(names));
                registerRestActionRequest,
                discoveryExtensionNode,  
            .legacyActionNames(Set.of("cluster:admin/opensearch/jkl/bar", "cluster:admin/opendistro/mno/bar*"))  
 * compatible open source license.
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
                discoveryExtensionNode,
            List.of(
import org.opensearch.action.support.ActionFilters;  
        assertFalse(filteredHeaders.containsKey("Authorization"));
        assertEquals(expected.size(), routes.size());
import java.util.List;
                registerRestActionRequest,  
        );
            "uniqueid1",
import org.opensearch.extensions.DiscoveryExtensionNode;
        dynamicActionRegistry.registerDynamicAction(testExtensionAction, testExtensionTransportAction);
    @After  
                transportService,
        assertEquals(expected.size(), routes.size());
import org.opensearch.common.settings.SettingsModule;
        List<NamedRoute> expected = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
            "uniqueid1",
        List<Route> routes = restSendToExtensionAction.routes();
                discoveryExtensionNode,  
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
            NoopTracer.INSTANCE
        );
import org.opensearch.cluster.node.DiscoveryNode;
                "GET /foo foo cluster:admin/opensearch/abc/foo",
import java.util.ArrayList;
}
            null,  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            new ExtensionsManager(Set.of(), new IdentityService(Settings.EMPTY, mock(ThreadPool.class), List.of()))
public class RestSendToExtensionActionTests extends OpenSearchTestCase {
import java.util.Map;  
            "uniqueid1",
            List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!")
        assertTrue(expectedPaths.containsAll(paths));
    public void testRestSendToExtensionActionWithoutUniqueNameShouldFail() {  
        assertEquals("uniqueid1:send_to_extension_action", restSendToExtensionAction.getName());  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            "uniqueid1",
import org.opensearch.extensions.action.ExtensionTransportAction;
        NamedRoute nr2 = new NamedRoute.Builder().method(Method.PUT)  
        expectThrows(  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
                registerRestActionRequest,  
            "uniqueid1",
        ActionFilters emptyFilters = new ActionFilters(Collections.emptySet());
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException.class,
            Version.CURRENT,
    }
        List<String> paths = routes.stream().map(Route::getPath).collect(Collectors.toList());  
            .uniqueName("bar")
            identityService  
import static java.util.Collections.emptyMap;  
            transportService,
            () -> new RestSendToExtensionAction(
    @Before
            List.of("GET /foo " + ClusterHealthAction.NAME),  
        assertTrue(expectedMethods.containsAll(methods));  
    }  
        );
        transportService = new MockTransportService(  
    private final ThreadPool threadPool = new TestThreadPool(RestSendToExtensionActionTests.class.getSimpleName());  
    private ActionModule actionModule;  
            registerRestActionRequest,
                dynamicActionRegistry,
import org.opensearch.action.admin.cluster.health.TransportClusterHealthAction;
        transportService.close();  
            List.of()
        List<String> names = routes.stream().map(r -> ((NamedRoute) r).name()).collect(Collectors.toList());
            ),  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            threadPool,  
            List.of("GET /foo", "PUT /bar", "POST /baz"),
    private DynamicActionRegistry dynamicActionRegistry;
            IllegalArgumentException.class,  
            discoveryExtensionNode,
        List<NamedRoute> expected = new ArrayList<>();
                boundAddress.publishAddress(),
        );
            discoveryExtensionNode,
        expected.add(nr2);
        ExtensionAction testExtensionAction = new ExtensionAction("extensionId", "test:action/name");
        assertTrue(methods.containsAll(expectedMethods));  
import org.opensearch.core.common.transport.TransportAddress;  
import org.opensearch.action.ActionModule.DynamicActionRegistry;  
            List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz"),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                discoveryExtensionNode,
import org.opensearch.transport.TransportService;  
            "uniqueid1",
                "PUT /bar bar cluster:admin/opensearch/jkl/bar,cluster:admin/opendistro/mno/bar*",  
        assertTrue(methods.containsAll(expectedMethods));  
            Version.fromString("3.0.0"),
    private DiscoveryExtensionNode discoveryExtensionNode;
            )
            "uniqueid1",
                discoveryExtensionNode,  
            dynamicActionRegistry,
                dynamicActionRegistry,  
        headers.put("Authorization", Arrays.asList("Bearer token"));
            List.of("/deprecated/foo", "It's deprecated!")  
            () -> new RestSendToExtensionAction(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                transportService,
            List.of("GET /foo/{path_param} fooWithParam", "GET /foo/{path_param}/list listFooWithParam"),  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
        Set<String> actionNames = routes.stream().flatMap(nr -> ((NamedRoute) nr).actionNames().stream()).collect(Collectors.toSet());  
            IllegalArgumentException.class,  
                transportService,  
        expected.add(nr3);
            () -> new RestSendToExtensionAction(
/*  
        transport = new MockNioTransport(
            settingsModule.getClusterSettings(),
            "uniqueid1",
import org.opensearch.usage.UsageService;
            List.of()
import org.opensearch.common.util.concurrent.ThreadContext;
        assertTrue(methods.containsAll(expectedMethods));
        );  
            )
            List.of("GET /foo/{path_param1} fooWithParam", "GET /foo/{path_param2} listFooWithParam"),  
        RestSendToExtensionAction restSendToExtensionAction = new RestSendToExtensionAction(
            transportService,  
            transportService,
    public void testRestSendToExtensionActionWithNamedRouteAndLegacyActionName() throws Exception {
        NamedRoute nr2 = new NamedRoute.Builder().method(Method.PUT).path(uriPrefix + "/bar").uniqueName("bar").build();
    private MockNioTransport transport;
        } catch (IllegalArgumentException e) {  
        );  
            () -> new RestSendToExtensionAction(
            "uniqueid1",
            )
 *
            usageService,
            List.of("GET /deprecated/foo", "It's deprecated!")  
                transportService,
                registerRestActionRequest,
import static org.mockito.Mockito.mock;
            discoveryExtensionNode,  
        assertTrue(paths.containsAll(expectedPaths));
    }
            dynamicActionRegistry,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            List.of("GET /foo foo", "PUT /bar foo"),  
    }
    public void testRestSendToExtensionActionWithNamedRoute() throws Exception {
            Collections.emptySet(),
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(  
import java.util.HashMap;
    public void testRestSendToExtensionMultipleRoutesWithSameMethodAndPathWithPathParams() {  
            .path(uriPrefix + "/baz")  
                dynamicActionRegistry,  
    }  
import static java.util.Collections.emptySet;
        List<String> expectedPaths = expected.stream().map(Route::getPath).collect(Collectors.toList());  
import org.opensearch.extensions.ExtensionsManager;  
import static java.util.Collections.emptyList;
        expected.add(new Route(Method.GET, uriPrefix + "/foo"));  
    public void testRestSendToExtensionActionMissingUri() throws Exception {
        );  
                discoveryExtensionNode,
        List<String> expectedPaths = expected.stream().map(Route::getPath).collect(Collectors.toList());  
            List.of()
            )
            )
            List.of()
            List.of("GET /foo foo cluster:admin/opensearch/abc/foo", "PUT /bar bar cluster:admin/opensearch/abc/foo"),  
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(  
                identityService
        actionModule = new ActionModule(
        expectThrows(
        );
        assertFalse(filteredHeaders.containsKey("Proxy-Authorization"));
            new HashMap<String, String>(),  
        );
            new NetworkService(Collections.emptyList()),  
        assertTrue(expectedNames.containsAll(names));
import org.junit.After;  
import org.opensearch.action.ActionModule;
                emptyMap(),  
                identityService
            )
 */  
import java.util.Collections;  
            identityService  
        );
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(  
            List.of("GET", "PUT /bar", "POST /baz"),
        Map<String, List<String>> headers = new HashMap<>();
    }
    public void tearDown() throws Exception {
                "test_node",  
        NamedRoute nr1 = new NamedRoute.Builder().method(Method.GET).path(uriPrefix + "/foo").uniqueName("foo").build();  
            registerRestActionRequest,
import java.util.Set;
            .registerUnmodifiableActionMap(Map.of(ClusterHealthAction.INSTANCE, mock(TransportClusterHealthAction.class)));  
        NamedRoute nr1 = new NamedRoute.Builder().method(Method.GET)
            List.of("GET /foo", "GET /foo"),  
            List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz"),  
                identityService
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(
            "uniqueid1",
            "uniqueid1",  
    public void testRestSendToExtensionMultipleRoutesWithSameMethodAndPath() throws Exception {  
                registerRestActionRequest,  
    public void setup() throws Exception {  
        dynamicActionRegistry = actionModule.getDynamicActionRegistry();
                registerRestActionRequest,
import org.opensearch.threadpool.ThreadPool;
            settingsModule.getIndexScopedSettings(),
            () -> new RestSendToExtensionAction(
            null,
import java.util.stream.Collectors;  
        assertTrue(expectedMethods.containsAll(methods));
            () -> new RestSendToExtensionAction(
            new NoneCircuitBreakerService(),  
            transport,
    }  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            mock(ThreadPool.class),
            );
                dynamicActionRegistry,
            IllegalArgumentException.class,
    public void testRestSendToExtensionWithNamedRouteCollidingWithDynamicTransportAction() throws Exception {
            List.of("GET /deprecated/foo", "It's deprecated!")  
import org.opensearch.rest.RestRequest.Method;  
            List.of()
import org.opensearch.transport.nio.MockNioTransport;
        assertTrue(paths.containsAll(expectedPaths));
        identityService = new IdentityService(Settings.EMPTY, mock(ThreadPool.class), new ArrayList<>());
        );
            fail("IllegalArgumentException should not be thrown for different paths");
            settingsModule.getSettingsFilter(),  
                transportService,
        discoveryExtensionNode = new DiscoveryExtensionNode(
            )  
        );
 * SPDX-License-Identifier: Apache-2.0
                "test_node",
                transportService,
                dynamicActionRegistry,
        RegisterRestActionsRequest registerRestActionRequest = new RegisterRestActionsRequest(  
        expectThrows(  
        assertEquals(expected.size(), routes.size());
            .path(uriPrefix + "/foo")
                registerRestActionRequest,
            List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!")
        String uriPrefix = "/_extensions/_uniqueid1";
        expected.add(nr1);  
                transportService,
                dynamicActionRegistry,
import org.opensearch.common.settings.Settings;
                identityService
    public void testRestSendToExtensionMultipleRoutesWithSameMethodAndPathWithDifferentPathParams() throws Exception {  
                dynamicActionRegistry,  
                emptySet(),
        expected.add(nr3);
            emptyList(),
                transportService,
            )
        List<Route> routes = restSendToExtensionAction.routes();  
        assertTrue(expectedMethods.containsAll(methods));
    }  
            discoveryExtensionNode,  
import java.net.InetAddress;  
            List.of("GET", "It's deprecated!")  
    }
import org.opensearch.common.network.NetworkService;  
    private IdentityService identityService;
    public void testRestSendToExtensionAction() throws Exception {
        Set<String> expectedActionNames = expected.stream().flatMap(nr -> nr.actionNames().stream()).collect(Collectors.toSet());
                dynamicActionRegistry,  
        Settings settings = Settings.builder().put("cluster.name", "test").build();
        List<String> paths = routes.stream().map(Route::getPath).collect(Collectors.toList());
            dynamicActionRegistry,  
        expected.add(nr2);  
import org.opensearch.threadpool.TestThreadPool;
            settings,  
 * this file be licensed under the Apache-2.0 license or a
            () -> new RestSendToExtensionAction(
    }
            List.of("GET /foo", "PUT /bar", "POST /baz"),
            )
        expected.add(new Route(Method.POST, uriPrefix + "/baz"));
import org.opensearch.identity.IdentityService;  
import org.opensearch.common.util.PageCacheRecycler;  
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        assertTrue(expectedPaths.containsAll(paths));
    private TransportService transportService;  
import org.opensearch.test.transport.MockTransportService;  
            List.of()
            settingsModule.getSettings(),
