                new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),  
    private final Settings settings = Settings.builder()  
            assertTrue(((AcknowledgedResponse) response).getStatus());
            "127.0.0.0",  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
    private Setting customSetting = Setting.simpleString("custom_extension_setting", "none", Property.ExtensionScope);  
            List.of(),
        }
        extensionsManager.initializeServicesAndRestHandler(
            List.of(),
        when(actionModule.getDynamicActionRegistry()).thenReturn(mock(DynamicActionRegistry.class));
        List<Setting<?>> requestComponentSettings = new ArrayList<>();
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry());  
            null,
                    "org.opensearch.extensions.ExtensionsManager",
        RegisterCustomSettingsRequest registerCustomSettingsRequest = new RegisterCustomSettingsRequest(uniqueIdStr, settingsList);  
        DiscoveryExtensionNode discoveryExtensionNode = new DiscoveryExtensionNode(
            new HashMap<String, String>(),  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        assertEquals(extension.getName(), initializedExtension.getName());
        restController = new RestController(
}
        actionModule = mock(ActionModule.class);
                assertEquals(environmentSettings, environmentSettingsResponse.getEnvironmentSettings());
            "firstExtension",
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);  
        Version expectedVersion = Version.fromString("2.0.0");
    private IdentityService identityService;  
            out.flush();  
        }
    private ExtensionAwarePlugin extAwarePlugin;
    public void testLoadExtensions() throws Exception {  
    public void testHandleExtensionRequest() throws Exception {
    public void testInitialize() throws Exception {  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
    private ActionModule actionModule;  
                "secondExtension",
import org.opensearch.Version;
                boundAddress.publishAddress(),
    private NodeClient client;
                Version.fromString("3.0.0"),  
            "9300",  
        assertEquals(
                .handleRegisterRestActionsRequest(registerActionsRequest, dynamicActionRegistry)
import java.util.List;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        expectThrows(
                    "Node Not Connected Exception 1",  
        transportService = new MockTransportService(  
    public void tearDown() throws Exception {
        dynamicActionRegistry = mock(DynamicActionRegistry.class);  
            )
                new HashMap<String, String>(),
                emptyMap(),  
import java.util.Collections;
        Exception exception = expectThrows(  
        DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());
            "9301",
            IllegalArgumentException.class,
            "9300",
        ExtensionRequest extensionRequest = new ExtensionRequest(expectedRequestType, expectedUniqueId);  
            "3.0.0",
        // Test UpdateSettingRequest arg constructor  
import org.opensearch.identity.IdentityService;
        assertEquals(expectedExtensions.size(), extensionsManager.getExtensionIdMap().values().size());
            "2.0.0",
        initialize(extensionsManager);  
        Version expectedVersion = Version.fromString("2.0.0");
            null,  
        );
import java.util.Set;
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
            IllegalArgumentException.class,
    }  
import org.opensearch.usage.UsageService;
        String expectedUniqueId = "Test uniqueId";
        AddSettingsUpdateConsumerRequest addSettingsUpdateConsumerRequest = new AddSettingsUpdateConsumerRequest(
import org.opensearch.discovery.InitializeExtensionRequest;
            Setting.boolSetting("index.falseSetting", false, Property.IndexScope, Property.Dynamic),  
        assertEquals(expectedUniqueId, dependency.getUniqueId());
            "Duplicate uniqueId [uniqueid1]. Did not load extension: Extension [name=secondExtension, uniqueId=uniqueid1, hostAddress=127.0.0.0, port=9300, version=0.0.7, opensearchVersion=3.0.0, minimumCompatibleVersion=3.0.0]",
            }
                environmentSettingsResponse = new EnvironmentSettingsResponse(in);  
import org.opensearch.extensions.settings.RegisterCustomSettingsRequest;
                x -> null,  
    }
        assertTrue(expectedExtensions.containsAll(emptyList()));
        );  
                List.of(expectedDependency)
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                Version.fromString("3.0.0"),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                Version.fromString("3.0.0"),  
        );
            IllegalArgumentException.class,
            assertEquals(extension.getVersion(), initializedExtension.getVersion());
        List<String> deprecatedActionsList = List.of("FOO /deprecated/foo", "It's deprecated!");
                "firstExtension",
import static org.mockito.Mockito.spy;
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
                new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),  
            assertEquals(AcknowledgedResponse.class, response.getClass());
            );
    public void testMissingRequiredFieldsWhileLoadingExtension() throws Exception {
        initialize(extensionsManager);
            "uniqueid1",  
        assertEquals(List.of(expectedDependency), discoveryExtensionNode.getDependencies());  
                Version.fromString("2.0.0"),
                Settings.EMPTY,
        extensionsManager.loadExtension(
        for (DiscoveryExtensionNode extension : expectedExtensions) {  
        Settings environmentSettings = Settings.builder().put("boolSetting", "true").build();
            "0.0.7",
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertEquals(extension.getId(), initializedExtension.getId());
            "0.0.7",  
            );
            settings,  
            settings,  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        doNothing().when(mockTransportService).connectToExtensionNode(any(DiscoveryExtensionNode.class));
        Setting<Boolean> boolSetting = Setting.boolSetting("boolSetting", false, Property.Dynamic);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                // bool setting is registered in Settings object, thus the expected return value is the registered setting value  
 * compatible open source license.
            "2.0.0",
                )
            "0.0.7",  
import java.net.InetAddress;  
            null
            List.of()
        // Test ExtensionRequest StreamInput constructor
                    "[firstExtension][127.0.0.0:9300] Node not connected"  
        extensionsManager.loadExtension(firstExtension);
    public void testHandleRegisterRestActionsRequestRequiresDiscoveryNode() throws Exception {
import static org.mockito.ArgumentMatchers.any;
                    "org.opensearch.extensions.ExtensionsManager",
                assertEquals(settings, environmentSettingsResponse.getEnvironmentSettings());
            exception.getMessage()  
                Collections.emptyList()
            assertEquals(extension.getMinimumCompatibleVersion(), initializedExtension.getMinimumCompatibleVersion());
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            settings,
import org.opensearch.common.network.NetworkService;
            ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            environmentSettingsResponse.writeTo(out);  
            "secondExtension",
        );
        );  
            TransportResponse response = extensionsManager.getRestActionsRequestHandler()
        );
            "uniqueid2",  
        transportService.start();
            "127.0.0.0",
            Version.fromString("3.0.0"),  
        EnvironmentSettingsResponse environmentSettingsResponse = new EnvironmentSettingsResponse(settings);
import org.opensearch.core.transport.TransportResponse;  
import static java.util.Collections.emptySet;
        List<Setting<?>> componentSettings = List.of(
        assertTrue(requestComponentSettings.containsAll(componentSettings));  
            assertEquals(extension.getMinimumCompatibleVersion(), initializedExtension.getMinimumCompatibleVersion());  
                addSettingsUpdateConsumerRequest = new AddSettingsUpdateConsumerRequest(in);
import static org.mockito.Mockito.doNothing;
        Extension secondExtension = new Extension(
        // Test EnvironmentSettingsResponse StreamInput constructor
        ExtensionRequest environmentSettingsRequest = new ExtensionRequest(  
            DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());
            assertEquals(extension.getAddress(), initializedExtension.getAddress());  
    }  
        initialize(extensionsManager);  
        transportService.acceptIncomingRequests();  
            new UsageService()  
        ExtensionDependencyResponse extensionDependencyResponse = new ExtensionDependencyResponse(expectedExtensionsList);  
            "9301",
            "9301",
import org.apache.logging.log4j.Level;
        Extension firstExtension = new Extension("firstExtension", "uniqueid1", "127.0.0.0", "9300", "0.0.7", "3.0.0", "", null, null);  
            dependency.writeTo(out);
            null  
        List<String> actionsList = List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz");  
        // Create Settings with registered bool setting with value true  
import org.opensearch.common.settings.Setting.Property;  
            settingsModule,
import static org.opensearch.common.util.FeatureFlags.EXTENSIONS;  
        List<DiscoveryExtensionNode> expectedExtensions = new ArrayList<DiscoveryExtensionNode>();  
        );  
    public void testEnvironmentSettingsRegisteredValue() throws Exception {
import org.opensearch.core.common.io.stream.BytesStreamInput;
        extensionsManager.loadExtension(
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!");
        for (DiscoveryExtensionNode extension : expectedExtensions) {
import static java.util.Collections.emptyList;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        ExtensionDependency dependentExtension = new ExtensionDependency("uniqueid0", Version.fromString("2.0.0"));
        identityService = new IdentityService(Settings.EMPTY, threadPool, List.of());
        extensionsManager.loadExtension(  
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedUniqueId, expectedVersion);  
            "9300",
            environmentSettingsResponse.writeTo(out);
            Collections.emptySet(),
            out.flush();
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            "3.0.0",  
import org.opensearch.transport.Transport;  
                extensionDependencyResponse = new ExtensionDependencyResponse(in);
    }
            Version.CURRENT,
            "uniqueid2",
        );  
            Version.fromString("2.0.0"),  
                assertEquals(environmentSettings, environmentSettingsResponse.getEnvironmentSettings());
        EnvironmentSettingsResponse environmentSettingsResponse = new EnvironmentSettingsResponse(environmentSettings);
            }
            "custom_setting",  
        // Test ExtensionDependencyResponse StreamInput constructor  
import org.opensearch.action.ActionModule.DynamicActionRegistry;  
    }  
import java.util.ArrayList;
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            .sendRequest(any(DiscoveryExtensionNode.class), anyString(), any(InitializeExtensionRequest.class), any());
            extensionScopedSettings  
        DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());  
    private static FeatureFlags.TestUtils.FlagWriteLock ffLock = null;
package org.opensearch.extensions;
                assertEquals(settingType, updateSettingsRequest.getSettingType());
            threadPool,  
                null,
        ExtensionDependency dependency = new ExtensionDependency(expectedUniqueId, expectedVersion);
        extensionsManager.loadExtension(
            extensionScopedSettings
            identityService
import org.opensearch.cluster.node.DiscoveryNode;
            "2.0.0",  
    public void testEnvironmentSettingsDefaultValue() throws Exception {  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
 * SPDX-License-Identifier: Apache-2.0
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
            () -> extensionsManager.getRestActionsRequestHandler()
import org.opensearch.common.settings.WriteableSetting.SettingType;
    public void testEnvironmentSettingsResponse() throws Exception {
            extensionRequest.writeTo(out);  
            "127.0.0.0",  
            () -> extensionsManager.getRestActionsRequestHandler()
            // mockLogAppender.assertAllExpectationsMatched();  
                deprecatedActionsList  
                    Level.ERROR,
import static java.util.Collections.emptyMap;
import org.opensearch.extensions.ExtensionsSettings.Extension;
            componentSettings  
            emptySet(),
                assertTrue(extensionRequest.getUniqueId().isEmpty());  
    }
        ExtensionRequest clusterStateRequest = new ExtensionRequest(ExtensionRequestProto.RequestType.REQUEST_EXTENSION_CLUSTER_STATE);  
import org.opensearch.cluster.service.ClusterService;
                "uniqueid1",
            new HashMap<String, String>(),
        );  
/*  
        }
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
                "9300",
import org.opensearch.rest.RestController;
        // Test EnvironmentSettingsResponse arg constructor
        );
    public void testHandleRegisterRestActionsRequestWithInvalidDeprecatedUri() throws Exception {  
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo", "It's deprecated!");  
            RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(  
            settings,  
        assertEquals("Required field [minimum opensearch version] is missing in the request", exception.getMessage());
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
            }  
                    Level.ERROR,
            out.flush();  
                uniqueIdStr,  
    }
                discoveryExtensionNode = new DiscoveryExtensionNode(in);  
            client,
        expectThrows(  
    private final ThreadPool threadPool = new TestThreadPool(ExtensionsManagerTests.class.getSimpleName());
                environmentSettingsResponse = new EnvironmentSettingsResponse(in);
        assertEquals(EnvironmentSettingsResponse.class, extensionsManager.handleExtensionRequest(environmentSettingsRequest).getClass());  
    }  
            "firstExtension",  
        // Create settings object without registered bool setting
            client,  
    }  
        Extension firstExtension = new Extension(  
                Version.fromString("3.0.0"),  
                assertEquals(data, updateSettingsRequest.getData());
        extensionNode = new DiscoveryExtensionNode(
    public void testHandleRegisterRestActionsRequestMultiple() throws Exception {
        initialize(extensionsManager);  
        Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
        );
        );
        ExtensionAwarePlugin extAwarePlugin = new ExtensionAwarePlugin() {
        // Test ExtensionRequest 1 arg constructor  
        }
    }  
    }
            .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry());  
    private DiscoveryExtensionNode extensionNode;
        IOException exception = expectThrows(IOException.class, () -> extensionsManager.loadExtension(firstExtension));  
        expectedExtensionsList.add(
            "3.99.0",
            "uniqueid1",
                x -> null,
            new TransportService(
                Version.fromString("3.0.0"),
            "uniqueid1",
                .handleRegisterRestActionsRequest(registerActionsRequest, dynamicActionRegistry)
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
        ExtensionsManager extensionsManager = new ExtensionsManager(additionalSettings, identityService);  
            }  
        TransportService mockTransportService = spy(
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            "2.0.0",  
        TransportResponse response = extensionsManager.getRestActionsRequestHandler()
        Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
                "uniqueid1",
                updateSettingsRequest = new UpdateSettingsRequest(in);
            "secondExtension",
    private ClusterService clusterService;
        );
            );
            public List<Setting<?>> getExtensionSettings() {  
        assertEquals(expectedRequestType, extensionRequest.getRequestType());
            }  
            mockTransportService,
public class ExtensionsManagerTests extends OpenSearchTestCase {  
    public void testExtensionRequest() throws Exception {
        ffLock.close();
            identityService
            Version.fromString("3.0.0"),
        expectedExtensions.add(
        boolean data = true;
            mockLogAppender.addExpectation(
                uniqueIdStr,
        List<String> actionsList = List.of("GET /foo", "PUT /bar", "POST /baz");
        assertEquals(
import static org.mockito.Mockito.times;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);  
                new TransportAddress(InetAddress.getByName("127.0.0.1"), 9301),  
                actionsList,
                    "No response from extension to request."  
        ExtensionsManager extensionsManager = new ExtensionsManager(additionalSettings, identityService);
        List<String> actionsList = List.of("GET /foo", "PUT /bar", "POST /baz");  
        assertEquals(settingType, updateSettingsRequest.getSettingType());  
import org.opensearch.transport.TransportService;
    public void testHandleAddSettingsUpdateConsumerRequest() throws Exception {
        );
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
            extensionScopedSettings
                assertEquals(componentSetting, updateSettingsRequest.getComponentSetting());  
            "uniqueid2",
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry())  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);  
        transport = new MockNioTransport(
            assertTrue(extensionsManager.lookupExtensionSettingsById(extension.getId()).isPresent());  
                )
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        Setting<?> componentSetting = Setting.boolSetting("falseSetting", false, Property.Dynamic);
        expectedExtensions.add(
            List.of()
            "0.0.7",
            "none",
    public void testAddSettingsUpdateConsumerRequest() throws Exception {  
            }  
import org.opensearch.transport.client.node.NodeClient;
        List<Setting<?>> componentSettings = List.of(  
import org.opensearch.extensions.rest.RegisterRestActionsRequest;  
            () -> extensionsManager.getRestActionsRequestHandler()  
            extensionsManager.loadExtension(firstExtension);
            IllegalArgumentException.class,
            "firstExtension",
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        assertTrue(((AcknowledgedResponse) response).getStatus());
        assertEquals(expectedExtensions.size(), extensionsManager.getExtensionIdMap().values().size());
    }  
import org.opensearch.common.settings.SettingsModule;
                "test_node",  
    }
        assertEquals(componentSetting, updateSettingsRequest.getComponentSetting());
                assertEquals(expectedExtensionsList, extensionDependencyResponse.getExtensionDependency());  
            NoopTracer.INSTANCE
        );  
                Settings.EMPTY,  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.util.PageCacheRecycler;  
            new NetworkService(Collections.emptyList()),  
            );
        when(actionModule.getRestController()).thenReturn(restController);  
            "uniqueid1",
        extensionsManager.initializeServicesAndRestHandler(
            Version.fromString("3.0.0"),
import org.apache.logging.log4j.LogManager;
    }  
                "firstExtension",
        );
        Extension secondExtension = new Extension(
            "2.0.0",
        }
        assertTrue(extensionsManager.lookupExtensionSettingsById(extension.getId()).isPresent());  
        );
            assertEquals(extension.getAddress(), initializedExtension.getAddress());
        Setting customSetting = Setting.simpleString("custom_extension_setting", "custom_setting", Property.ExtensionScope);
            client,
                "uniqueid2",
            "0.0.7",
        initialize(extensionsManager);  
import org.opensearch.common.settings.Setting;
                threadPool,
import org.opensearch.cluster.ClusterSettingsResponse;
        Extension secondExtension = new Extension(  
            Collections.emptyList(),
                return settings;  
            null  
            assertEquals(extension.getVersion(), initializedExtension.getVersion());  
        // Test UpdateSettingRequest StreamInput constructor  
        String uniqueIdStr = "uniqueid1";
            new HashMap<String, String>(),
                Version.fromString("3.0.0"),
        assertEquals(0, extensionsManager.getExtensionIdMap().values().size());  
            "secondExtension",
        ExtensionsManager extensionsManager = new ExtensionsManager(additionalSettings, identityService);
        assertTrue(extensionRequest.getUniqueId().isEmpty());  
            }
        expectThrows(OpenSearchException.class, () -> extensionsManager.loadExtension(firstExtension));
        String uniqueIdStr = "uniqueid1";
            updateSettingsRequest.writeTo(out);
                "Extension %s" + i,
            List.of(dependentExtension),
            assertEquals(extension.getDependencies(), initializedExtension.getDependencies());
                Collections.emptyList()
                List.of(expectedDependency)
    public void testNonUniqueLoadedExtensions() throws Exception {
        String expectedUniqueId = "uniqueid0";
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            environmentSettingsResponse.writeTo(out);
            "3.0.0",  
import org.opensearch.test.client.NoOpNodeClient;
                extensionScopedSettings
                assertEquals(true, boolSetting.get(environmentSettingsResponse.getEnvironmentSettings()));
                assertEquals(expectedVersion, dependency.getVersion());
import org.opensearch.env.EnvironmentSettingsResponse;  
        assertTrue(((AcknowledgedResponse) response).getStatus());
        );
        initialize(extensionsManager);
        Settings settings = Settings.builder().put("cluster.name", "test").build();
        // Test ExtensionRequest StreamInput constructor
            actionModule,
        List<DiscoveryExtensionNode> expectedExtensions = new ArrayList<DiscoveryExtensionNode>();
        DiscoveryExtensionNode extension = new DiscoveryExtensionNode(  
        );
            "uniqueid1",  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
                    "No Response From Extension",  
            out.flush();
            List.of(),  
            extensionNode,
                "firstExtension",
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
import static org.mockito.Mockito.when;
            new NamedWriteableRegistry(Collections.emptyList()),
        String uniqueIdStr = "uniqueid1";
            "9300",
import org.opensearch.extensions.proto.ExtensionRequestProto;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                assertEquals(expectedRequestType, extensionRequest.getRequestType());
    public void testRegisterHandler() throws Exception {
            "firstExtension",
        assertEquals(0, extensionsManager.getExtensionIdMap().values().size());  
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
                assertTrue(componentSettings.containsAll(requestComponentSettings));
                assertEquals(List.of(expectedDependency), discoveryExtensionNode.getDependencies());
    @After  
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),
        // Create setting with value false
            "2.0.0",  
    public void setup() throws Exception {
        String expectedUniqueId = "test uniqueid";  
            "3.0.0",
                extensionRequest = new ExtensionRequest(in);
            settingsModule,  
    public void testInitializeExtension() throws Exception {
                List<Setting<?>> settings = new ArrayList<Setting<?>>();  
        ExtensionRequestProto.RequestType expectedRequestType = ExtensionRequestProto.RequestType.REQUEST_EXTENSION_DEPENDENCY_INFORMATION;
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9301),  
        assertEquals(AcknowledgedResponse.class, response.getClass());  
        initialize(extensionsManager);  
            mockLogAppender.addExpectation(
            extensionsManager.lookupExtensionSettingsById(extension.getId()).get().getAdditionalSettings().get(customSetting)  
        // Create setting with value false  
            "uniqueid2",
            transport,
        assertEquals(extension.getId(), initializedExtension.getId());  
    private SettingsModule settingsModule;  
    private TransportService transportService;
        assertEquals(extensionNode, addSettingsUpdateConsumerRequest.getExtensionNode());
        assertEquals(ClusterSettingsResponse.class, extensionsManager.handleExtensionRequest(clusterSettingRequest).getClass());
        extensionsManager.initializeExtension(firstExtension);
        );  
        for (int i = 0; i < 2; i++) {
        }
        initialize(extensionsManager);
                "127.0.0.0",
            "127.0.0.1",  
                "uniqueid1",
    public void testUpdateSettingsRequest() throws Exception {
import org.opensearch.threadpool.TestThreadPool;
            "3.0.0",
            discoveryExtensionNode.writeTo(out);  
    public void testAdditionalExtensionSettingsForExtensionWithoutCustomSettingSet() throws Exception {
                null,
                List<Setting<?>> settings = new ArrayList<Setting<?>>();
                settings.add(customSetting);
                Version.CURRENT
            settings,
        extensionsManager.loadExtension(firstExtension);
        ExtensionRequest clusterSettingRequest = new ExtensionRequest(ExtensionRequestProto.RequestType.REQUEST_EXTENSION_CLUSTER_SETTINGS);  
            addSettingsUpdateConsumerRequest.writeTo(out);
            clusterService,
        TransportResponse response = extensionsManager.getCustomSettingsRequestHandler()
            clusterService,
            ExtensionRequestProto.RequestType.REQUEST_EXTENSION_ENVIRONMENT_SETTINGS
            "secondExtension",
        String expectedId = "test id";
    }
        }
        List<String> actionsList = List.of("GET", "PUT /bar", "POST /baz");
            Version.fromString("2.0.0"),
            "firstExtension",
        TransportService mockTransportService = spy(  
        List<String> actionsList = List.of("FOO /foo", "PUT /bar", "POST /baz");  
            any(DiscoveryExtensionNode.class),
                    Level.INFO,
            Setting.simpleString("fooSetting", "foo", Property.NodeScope, Property.Final)
            extensionsManager.lookupExtensionSettingsById(extension.getId()).get().getAdditionalSettings().get(customSetting)
            () -> extensionsManager.handleExtensionRequest(exceptionRequest)
                Collections.emptySet(),
        );
        );  
                mock(Transport.class),  
        );  
            "0.0.7",  
                null,
                assertEquals(extensionNode, addSettingsUpdateConsumerRequest.getExtensionNode());  
            "0.0.7",
        extensionsManager.loadExtension(secondExtension);  
            }
        expectedExtensions.add(
            "uniqueid1",
        assertEquals(data, updateSettingsRequest.getData());
 *
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
                    "Node Not Connected Exception 2",  
        );
                assertEquals(expectedRequestType, extensionRequest.getRequestType());
        );  
                // bool setting is not registered in Settings object, thus the expected return value is the default setting value  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            }  
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        // Test ExtensionDependencyResponse arg constructor
import org.opensearch.core.common.bytes.BytesReference;
 * The OpenSearch Contributors require contributions made to  
        .build();  
        List<String> deprecatedActionsList = List.of("GET", "It's deprecated!");
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            Version.fromString("3.0.0"),
            "9301",  
                    "org.opensearch.extensions.ExtensionsManager",
            @Override
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedId, expectedVersion);  
                mock(Transport.class),
        }  
        for (WriteableSetting writeableSetting : addSettingsUpdateConsumerRequest.getComponentSettings()) {  
            new DiscoveryExtensionNode(  
            )
            "0.0.7",
            ),  
        assertEquals(extension.getName(), initializedExtension.getName());
                assertEquals(expectedUniqueId, extensionRequest.getUniqueId());
        );  
        List<DiscoveryExtensionNode> expectedExtensionsList = new ArrayList<DiscoveryExtensionNode>();
                assertEquals(expectedUniqueId, dependency.getUniqueId());  
        List<Setting<?>> settingsList = List.of(
    public void testHandleRegisterRestActionsRequestWithInvalidDeprecatedMethod() throws Exception {
        assertEquals(settings, environmentSettingsResponse.getEnvironmentSettings());  
    }
        );  
        }  
        );
                List.of(),  
        ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);
            public List<Setting<?>> getExtensionSettings() {
            assertEquals(extension.getName(), initializedExtension.getName());
        assertEquals(componentSettings.size(), addSettingsUpdateConsumerRequest.getComponentSettings().size());  
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!");  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        );
        ExtensionRequest exceptionRequest = new ExtensionRequest(ExtensionRequestProto.RequestType.GET_SETTINGS);
        String expectedUniqueId = "test uniqueid";
                assertEquals(componentSettings.size(), addSettingsUpdateConsumerRequest.getComponentSettings().size());
        assertEquals(expectedExtensionsList, extensionDependencyResponse.getExtensionDependency());
            .handleAddSettingsUpdateConsumerRequest(addSettingsUpdateConsumerRequest);
        );
        );  
            "firstExtension",
                requestComponentSettings = new ArrayList<>();  
            )
            null
        }
        }  
        Version expectedVersion = Version.fromString("2.0.0");
            mockLogAppender.addExpectation(
                emptySet(),
        );  
    public void testExtensionDependencyResponse() throws Exception {
            "firstExtension",
            "uniqueid1",
            new DiscoveryExtensionNode(  
import org.opensearch.transport.nio.MockNioTransport;  
            out.flush();
            "127.0.0.0",
                )
        extensionsManager.loadExtension(  
                assertEquals(false, boolSetting.get(environmentSettingsResponse.getEnvironmentSettings()));
    public void testHandleRegisterRestActionsRequestWithInvalidMethod() throws Exception {
        );
import org.opensearch.core.common.transport.TransportAddress;
            assertEquals(extension.getId(), initializedExtension.getId());  
                for (WriteableSetting writeableSetting : addSettingsUpdateConsumerRequest.getComponentSettings()) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.MockLogAppender;  
            "2.0.0",
            any(InitializeExtensionRequest.class),
            requestComponentSettings.add(writeableSetting.getSetting());
            null
        );
            (boundAddress) -> new DiscoveryNode(
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo", "It's deprecated!");
        assertEquals("Handler not present for the provided request", exception.getMessage());
        DiscoveryExtensionNode extension = new DiscoveryExtensionNode(
            "2.0.0",
        assertEquals(List.of(expectedDependency), expectedExtensions.get(1).getDependencies());
        assertEquals(AcknowledgedResponse.class, response.getClass());
            "127.0.0.0",
        String uniqueIdStr = "uniqueid1";
    public void testIncompatibleExtensionRegistration() throws IOException {
    }
    }
            extensionRequest.writeTo(out);
        assertEquals(expectedRequestType, extensionRequest.getRequestType());
            new DiscoveryExtensionNode(  
            Setting.boolSetting("falseSetting", false, Property.IndexScope, Property.NodeScope),
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ExtensionsManager.class))) {
import org.opensearch.action.ActionModule;
        AddSettingsUpdateConsumerRequest addSettingsUpdateConsumerRequest = new AddSettingsUpdateConsumerRequest(
    }
        TransportResponse response = extensionsManager.getAddSettingsUpdateConsumerRequestHandler()  
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
            any()
            out.flush();  
    @Override
        initialize(extensionsManager);
        // Test AddSettingsUpdateConsumerRequest StreamInput constructor  
            new TransportService(
        );
        );
            extensionNode,  
            IllegalArgumentException.class,  
        assertEquals(expectedVersion, dependency.getVersion());
        // Should fail as component settings are not registered within cluster settings  
        initialize(extensionsManager);  
        }
            Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)  
        assertEquals(
        );  
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest("uniqueId1", List.of(), List.of());
            anyString(),  
            actionModule,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                environmentSettingsResponse = new EnvironmentSettingsResponse(in);
        transportService.close();  
        Setting<Boolean> boolSetting = Setting.boolSetting("boolSetting", false, Property.Dynamic);
import org.opensearch.test.transport.MockTransportService;  
                Collections.emptySet(),  
        expectThrows(  
    }
    public void testExtensionDependency() throws Exception {
            extensionScopedSettings  
                    requestComponentSettings.add(writeableSetting.getSetting());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            "uniqueid1",  
import static org.mockito.ArgumentMatchers.anyString;
            "0.0.7",
            "9300",
            Setting.boolSetting("falseSetting", false, Property.Dynamic),
        settingsModule = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet());
            extensionDependencyResponse.writeTo(out);
            threadPool,
            () -> extensionsManager.getRestActionsRequestHandler()
            new HashMap<String, String>(),
        assertEquals(expectedUniqueId, extensionRequest.getUniqueId());
        doNothing().when(mockTransportService)
        client.close();
        client = new NoOpNodeClient(this.getTestName());
        assertTrue(componentSettings.containsAll(requestComponentSettings));
            String uniqueIdStr = "uniqueid-%d" + i;  
        .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import java.io.IOException;
            )
                extensionRequest = new ExtensionRequest(in);  
        Extension firstExtension = new Extension(
            "127.0.0.1",
        );
        Version expectedVersion = Version.fromString("3.0.0");  
    }
    }
                new MockLogAppender.SeenEventExpectation(
import org.opensearch.OpenSearchException;  
    private DynamicActionRegistry dynamicActionRegistry;
            () -> extensionsManager.getRestActionsRequestHandler()
        Extension firstExtension = new Extension(  
                "3.0.0",
            Version.fromString("3.0.0"),
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                new HashMap<String, String>(),
import org.junit.Before;  
        List<String> actionsList = List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz");
import static org.mockito.Mockito.mock;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            "3.0.0",
            new NoneCircuitBreakerService(),
    public void testAdditionalExtensionSettingsForExtensionWithCustomSettingSet() throws Exception {  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        }
            DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());  
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            )
            );
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        Extension firstExtension = new Extension(
                    "[secondExtension][127.0.0.1:9301] Node not connected"  
            Setting.simpleString("fooSetting", "foo", Property.Dynamic)  
        extensionsManager.initializeExtension(secondExtension);
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(settingType, componentSetting, data);
            }
            out.flush();  
        assertTrue(expectedExtensions.containsAll(emptyList()));  
        extensionsManager.loadExtension(firstExtension);
        verify(mockTransportService, times(2)).connectToExtensionNode(any(DiscoveryExtensionNode.class));
        Extension firstExtension = new Extension(
        ffLock = new FeatureFlags.TestUtils.FlagWriteLock(EXTENSIONS);  
    }
import org.junit.After;
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
        initialize(extensionsManager);
        extensionsManager.initializeServicesAndRestHandler(  
            // Test needs to be changed to mock the connection between the local node and an extension.
                "test_node",
        EnvironmentSettingsResponse environmentSettingsResponse = new EnvironmentSettingsResponse(environmentSettings);  
import java.util.HashMap;  
        expectThrows(
    public void testHandleRegisterRestActionsRequestWithInvalidUri() throws Exception {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            mockTransportService,  
            // Link to issue: https://github.com/opensearch-project/OpenSearch/issues/4045
                new MockLogAppender.SeenEventExpectation(
            IllegalStateException.class,
    private void initialize(ExtensionsManager extensionsManager) {
        clusterService = createClusterService(threadPool);
 */  
                return settings;
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);  
            assertEquals(extension.getId(), initializedExtension.getId());
        Settings environmentSettings = Settings.builder().put("testSetting", "true").build();
                new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),  
            actionModule,
        String uniqueIdStr = "uniqueid1";  
                NoopTracer.INSTANCE
        IOException exception = expectThrows(IOException.class, () -> extensionsManager.loadExtension(secondExtension));  
    }
        };
            transportService,
            NoopTracer.INSTANCE  
            "firstExtension",  
            List.of(),  
            Version.fromString("3.0.0"),  
        );
            identityService
        super.tearDown();
    public void testHandleRegisterRestActionsRequest() throws Exception {  
import org.opensearch.threadpool.ThreadPool;
import static org.mockito.Mockito.verify;  
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
    }
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry())  
        );  
            "3.0.0",
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
    }
import org.opensearch.env.Environment;
        assertEquals(ClusterStateResponse.class, extensionsManager.handleExtensionRequest(clusterStateRequest).getClass());
            new NoneCircuitBreakerService(),  
        initialize(extensionsManager);
        initialize(extensionsManager);
            Collections.emptyList()
            List.of(expectedDependency)  
        Extension firstExtension = new Extension(  
                settings.add(customSetting);
        assertTrue(extensionsManager.lookupExtensionSettingsById(extension.getId()).isPresent());
        assertEquals(false, ((AcknowledgedResponse) response).getStatus());
                assertTrue(requestComponentSettings.containsAll(componentSettings));
        Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testHandleRegisterSettingsRequest() throws Exception {  
                Version.fromString("2.0.0"),  
    public void testDiscoveryExtension() throws Exception {  
            }
        assertEquals(AcknowledgedResponse.class, response.getClass());
            List.of(),
                dependency = new ExtensionDependency(in);
        extensionsManager.loadExtension(firstExtension);
        );
            clusterService,
            assertEquals(extension.getAttributes(), initializedExtension.getAttributes());
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            "secondExtension",  
            componentSettings
            out.flush();
    }
            )
            Collections.emptyList(),  
        verify(mockTransportService, times(2)).sendRequest(
        expectThrows(  
            new DiscoveryExtensionNode(  
            }  
        ThreadPool.terminate(threadPool, 3, TimeUnit.SECONDS);  
            out.flush();  
        ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);  
    }
            "127.0.0.0",
        verify(mockTransportService, times(9)).registerRequestHandler(anyString(), anyString(), anyBoolean(), anyBoolean(), any(), any());  
            "3.0.0",
import org.opensearch.common.settings.WriteableSetting;  
        };
        );
            "uniqueid1",  
        );
            .handleRegisterCustomSettingsRequest(registerCustomSettingsRequest);
                "3.0.0",
            new NodeClient(Settings.EMPTY, threadPool),
    }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    @Before
            assertEquals(extension.getAttributes(), initializedExtension.getAttributes());
            "3.0.0",  
        // Test ExtensionRequest 2 arg constructor
                new MockLogAppender.SeenEventExpectation(
        extensionRequest = new ExtensionRequest(expectedRequestType);
                new HashMap<String, String>(),
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.plugins.ExtensionAwarePlugin;  
    private RestController restController;
            assertEquals(extension.getDependencies(), initializedExtension.getDependencies());
            "127.0.0.0",  
import static org.mockito.ArgumentMatchers.anyBoolean;  
            Setting.boolSetting("trueSetting", true, Property.Dynamic)
        }  
        );
            null,
import java.util.concurrent.TimeUnit;  
        String uniqueIdStr = "uniqueid1";
            Extension firstExtension = new Extension(
            settingsModule,  
            @Override
        );
        SettingType settingType = SettingType.Boolean;  
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);  
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry())  
    }
                "0.0.7",  
            out.flush();
                NoopTracer.INSTANCE  
import java.util.stream.Collectors;
                new HashMap<String, String>(),
        }
            assertEquals(extension.getName(), initializedExtension.getName());
        // Test AddSettingsUpdateConsumerRequest arg constructor  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                }  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        extAwarePlugin = new ExtensionAwarePlugin() {  
        );  
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedUniqueId, expectedVersion);  
    private MockNioTransport transport;
