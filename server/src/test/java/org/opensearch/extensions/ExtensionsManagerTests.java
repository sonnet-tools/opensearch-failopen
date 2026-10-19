        assertEquals(extension.getName(), initializedExtension.getName());
                Version.CURRENT
            "9301",
                    "No Response From Extension",
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            "0.0.7",
        );
    public void testHandleRegisterSettingsRequest() throws Exception {
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        extensionsManager.initializeServicesAndRestHandler(
            updateSettingsRequest.writeTo(out);
import static org.opensearch.common.util.FeatureFlags.EXTENSIONS;
        );
        Setting<Boolean> boolSetting = Setting.boolSetting("boolSetting", false, Property.Dynamic);
                // bool setting is registered in Settings object, thus the expected return value is the registered setting value
    public void testRegisterHandler() throws Exception {
    private ExtensionAwarePlugin extAwarePlugin;
import java.util.ArrayList;
        );
                assertEquals(environmentSettings, environmentSettingsResponse.getEnvironmentSettings());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertTrue(((AcknowledgedResponse) response).getStatus());
    public void testEnvironmentSettingsResponse() throws Exception {
            }
    }
        assertEquals(AcknowledgedResponse.class, response.getClass());
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(settingType, componentSetting, data);
        assertEquals(
    public void setup() throws Exception {
            "2.0.0",
            "9300",
    }
            List.of(),
            Collections.emptyList(),
        extensionsManager.loadExtension(
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                "firstExtension",
            "uniqueid2",
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!");
    public void testHandleRegisterRestActionsRequestRequiresDiscoveryNode() throws Exception {
        );
                environmentSettingsResponse = new EnvironmentSettingsResponse(in);
        assertEquals(expectedExtensionsList, extensionDependencyResponse.getExtensionDependency());
            mockTransportService,
            extensionsManager.lookupExtensionSettingsById(extension.getId()).get().getAdditionalSettings().get(customSetting)
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
import org.opensearch.cluster.node.DiscoveryNode;
    private IdentityService identityService;
        DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());
            environmentSettingsResponse.writeTo(out);
        ThreadPool.terminate(threadPool, 3, TimeUnit.SECONDS);
            "127.0.0.1",
                uniqueIdStr,
        SettingType settingType = SettingType.Boolean;
import static org.mockito.ArgumentMatchers.any;
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            new HashMap<String, String>(),
        assertTrue(extensionsManager.lookupExtensionSettingsById(extension.getId()).isPresent());
        extensionsManager.initializeExtension(secondExtension);
            Version.fromString("3.0.0"),
            );
import org.opensearch.threadpool.ThreadPool;
                return settings;
        );
    }
        settingsModule = new SettingsModule(Settings.EMPTY, emptyList(), emptyList(), emptySet());
import org.opensearch.common.network.NetworkService;
        ExtensionRequest clusterStateRequest = new ExtensionRequest(ExtensionRequestProto.RequestType.REQUEST_EXTENSION_CLUSTER_STATE);
        DiscoveryExtensionNode discoveryExtensionNode = new DiscoveryExtensionNode(
        assertEquals(componentSettings.size(), addSettingsUpdateConsumerRequest.getComponentSettings().size());
                environmentSettingsResponse = new EnvironmentSettingsResponse(in);
 */
        assertEquals(expectedUniqueId, extensionRequest.getUniqueId());
        }
import org.opensearch.plugins.ExtensionAwarePlugin;
        for (DiscoveryExtensionNode extension : expectedExtensions) {
            Version.fromString("3.0.0"),
            new HashMap<String, String>(),
            IllegalArgumentException.class,
                assertEquals(expectedUniqueId, extensionRequest.getUniqueId());
import static java.util.Collections.emptyMap;
        ExtensionAwarePlugin extAwarePlugin = new ExtensionAwarePlugin() {
            List.of(expectedDependency)
            assertEquals(extension.getMinimumCompatibleVersion(), initializedExtension.getMinimumCompatibleVersion());
                settings.add(customSetting);
            "uniqueid1",
        // Test ExtensionDependencyResponse StreamInput constructor
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                Version.fromString("3.0.0"),
        extensionsManager.loadExtension(
            out.flush();
                emptyMap(),
import org.junit.After;
        // Test ExtensionRequest 2 arg constructor
            String uniqueIdStr = "uniqueid-%d" + i;
        );
import org.opensearch.transport.nio.MockNioTransport;
                assertEquals(componentSetting, updateSettingsRequest.getComponentSetting());
        transportService = new MockTransportService(
                assertEquals(expectedRequestType, extensionRequest.getRequestType());
    public void testHandleRegisterRestActionsRequestWithInvalidDeprecatedMethod() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", "test").build();
            null
import org.opensearch.common.settings.SettingsModule;
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ExtensionsManager.class))) {
            anyString(),
        extensionsManager.loadExtension(firstExtension);
        .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        );
                Version.fromString("2.0.0"),
            environmentSettingsResponse.writeTo(out);
        List<DiscoveryExtensionNode> expectedExtensionsList = new ArrayList<DiscoveryExtensionNode>();
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9301),
        verify(mockTransportService, times(9)).registerRequestHandler(anyString(), anyString(), anyBoolean(), anyBoolean(), any(), any());
            IllegalArgumentException.class,
        initialize(extensionsManager);
import static java.util.Collections.emptySet;
            transportService,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            extensionRequest.writeTo(out);
        EnvironmentSettingsResponse environmentSettingsResponse = new EnvironmentSettingsResponse(settings);
import static org.mockito.Mockito.verify;
            settings,
    private ClusterService clusterService;
/*
    }
            IllegalArgumentException.class,
        assertEquals(
            // Link to issue: https://github.com/opensearch-project/OpenSearch/issues/4045
            settings,
            )
        );
        );
            .sendRequest(any(DiscoveryExtensionNode.class), anyString(), any(InitializeExtensionRequest.class), any());
        Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
        assertTrue(((AcknowledgedResponse) response).getStatus());
        transport = new MockNioTransport(
 * this file be licensed under the Apache-2.0 license or a
            "uniqueid2",
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            List.of()
            Collections.emptyList()
import org.opensearch.cluster.metadata.IndexMetadata;
                return settings;
        );
            DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());
        );
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                new MockLogAppender.SeenEventExpectation(
                x -> null,
        );
            RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(
            null,
            any(DiscoveryExtensionNode.class),
                )
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        DiscoveryExtensionNode extension = new DiscoveryExtensionNode(
                new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),
            Collections.emptyList(),
            "firstExtension",
                mock(Transport.class),
            extensionScopedSettings
import org.opensearch.common.settings.WriteableSetting;
    public void testExtensionDependencyResponse() throws Exception {
            "2.0.0",
    private DiscoveryExtensionNode extensionNode;
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo", "It's deprecated!");
        List<String> actionsList = List.of("GET", "PUT /bar", "POST /baz");
import org.opensearch.core.common.bytes.BytesReference;
            new DiscoveryExtensionNode(
            .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry());
    public void testHandleRegisterRestActionsRequestWithInvalidUri() throws Exception {
import static org.mockito.ArgumentMatchers.anyBoolean;
            Version.CURRENT,
            }
            IllegalStateException.class,
        List<String> deprecatedActionsList = List.of("FOO /deprecated/foo", "It's deprecated!");
            new NodeClient(Settings.EMPTY, threadPool),
    private DynamicActionRegistry dynamicActionRegistry;
 * The OpenSearch Contributors require contributions made to
            "0.0.7",
            "127.0.0.1",
            out.flush();
        initialize(extensionsManager);
        String uniqueIdStr = "uniqueid1";
            null,
                assertEquals(settingType, updateSettingsRequest.getSettingType());
import static org.mockito.Mockito.times;
            environmentSettingsResponse.writeTo(out);
        initialize(extensionsManager);
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            new NetworkService(Collections.emptyList()),
        initialize(extensionsManager);
    }
        initialize(extensionsManager);
        Extension secondExtension = new Extension(
        List<Setting<?>> componentSettings = List.of(
        );
        List<DiscoveryExtensionNode> expectedExtensions = new ArrayList<DiscoveryExtensionNode>();
            List.of(),
        );
            // mockLogAppender.assertAllExpectationsMatched();
            )
            any(InitializeExtensionRequest.class),
        );
        expectThrows(
        assertEquals(extensionNode, addSettingsUpdateConsumerRequest.getExtensionNode());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
                )
                actionsList,
            extensionScopedSettings
    }
        extensionsManager.loadExtension(
                    requestComponentSettings.add(writeableSetting.getSetting());
            "uniqueid1",
        Setting<Boolean> boolSetting = Setting.boolSetting("boolSetting", false, Property.Dynamic);
            assertEquals(extension.getAttributes(), initializedExtension.getAttributes());
        clusterService = createClusterService(threadPool);
            "firstExtension",
import org.opensearch.identity.IdentityService;
        // Should fail as component settings are not registered within cluster settings
            // Test needs to be changed to mock the connection between the local node and an extension.
        assertTrue(extensionsManager.lookupExtensionSettingsById(extension.getId()).isPresent());
        expectThrows(OpenSearchException.class, () -> extensionsManager.loadExtension(firstExtension));
            out.flush();
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedUniqueId, expectedVersion);
        assertTrue(expectedExtensions.containsAll(emptyList()));
        List<String> deprecatedActionsList = List.of("GET", "It's deprecated!");
            Version.fromString("3.0.0"),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        extensionsManager.initializeExtension(firstExtension);
            "0.0.7",
                Version.fromString("3.0.0"),
    private MockNioTransport transport;
                assertEquals(expectedUniqueId, dependency.getUniqueId());
            "Duplicate uniqueId [uniqueid1]. Did not load extension: Extension [name=secondExtension, uniqueId=uniqueid1, hostAddress=127.0.0.0, port=9300, version=0.0.7, opensearchVersion=3.0.0, minimumCompatibleVersion=3.0.0]",
                assertEquals(environmentSettings, environmentSettingsResponse.getEnvironmentSettings());
    }
            extensionNode,
                    "Node Not Connected Exception 2",
            @Override
        extensionsManager.initializeServicesAndRestHandler(
        // Test ExtensionRequest StreamInput constructor
        expectedExtensions.add(
            List.of()
        assertEquals(componentSetting, updateSettingsRequest.getComponentSetting());
        when(actionModule.getDynamicActionRegistry()).thenReturn(mock(DynamicActionRegistry.class));
        List<String> actionsList = List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz");
            assertEquals(extension.getName(), initializedExtension.getName());
            "127.0.0.0",
        );
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedId, expectedVersion);
import org.opensearch.common.settings.Settings;
            "9300",
            Version.fromString("3.0.0"),
            "2.0.0",
            out.flush();
    }
        List<String> actionsList = List.of("GET /foo foo", "PUT /bar bar", "POST /baz baz");
    }
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
            )
        assertEquals(expectedExtensions.size(), extensionsManager.getExtensionIdMap().values().size());
                assertTrue(componentSettings.containsAll(requestComponentSettings));
        AddSettingsUpdateConsumerRequest addSettingsUpdateConsumerRequest = new AddSettingsUpdateConsumerRequest(
        }
            new TransportService(
import org.opensearch.test.OpenSearchTestCase;
                Version.fromString("3.0.0"),
            extensionDependencyResponse.writeTo(out);
            "9300",
        dynamicActionRegistry = mock(DynamicActionRegistry.class);
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        }
import java.util.Collections;
        );
    private final ThreadPool threadPool = new TestThreadPool(ExtensionsManagerTests.class.getSimpleName());
        .build();
        client = new NoOpNodeClient(this.getTestName());
            any()
            "2.0.0",
                extensionRequest = new ExtensionRequest(in);
    }
    public void testInitialize() throws Exception {
            assertEquals(extension.getId(), initializedExtension.getId());
    private SettingsModule settingsModule;
                Collections.emptyList()
import static org.mockito.Mockito.mock;
                "uniqueid1",
        assertEquals(AcknowledgedResponse.class, response.getClass());
        );
            extensionScopedSettings
            List.of(),
        for (WriteableSetting writeableSetting : addSettingsUpdateConsumerRequest.getComponentSettings()) {
            null,
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
            Collections.emptySet(),
        assertEquals(expectedRequestType, extensionRequest.getRequestType());
        assertEquals(extension.getId(), initializedExtension.getId());
            assertEquals(extension.getVersion(), initializedExtension.getVersion());
            out.flush();
            "3.0.0",
        extensionsManager.loadExtension(
    }
            "0.0.7",
            assertEquals(AcknowledgedResponse.class, response.getClass());
    }
            "9301",
            new UsageService()
        doNothing().when(mockTransportService).connectToExtensionNode(any(DiscoveryExtensionNode.class));
import org.junit.Before;
            "uniqueid2",
import org.opensearch.test.MockLogAppender;
            new DiscoveryExtensionNode(
                boundAddress.publishAddress(),
            "3.0.0",
        Extension secondExtension = new Extension(
            Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
            List.of(),
            "0.0.7",
        // Test AddSettingsUpdateConsumerRequest arg constructor
        }
                Version.fromString("3.0.0"),
            mockLogAppender.addExpectation(
        );
        assertEquals(ClusterStateResponse.class, extensionsManager.handleExtensionRequest(clusterStateRequest).getClass());
                Settings.EMPTY,
            assertEquals(extension.getVersion(), initializedExtension.getVersion());
                    Level.ERROR,
        assertEquals("Required field [minimum opensearch version] is missing in the request", exception.getMessage());
            )
        DiscoveryExtensionNode extension = new DiscoveryExtensionNode(
            Version.fromString("2.0.0"),
        List<String> actionsList = List.of("GET /foo", "PUT /bar", "POST /baz");
                "secondExtension",
            "uniqueid1",
        );
                    Level.ERROR,
            () -> extensionsManager.getRestActionsRequestHandler()
            }
            transport,
            "uniqueid1",
            }
    }
        String expectedUniqueId = "Test uniqueId";
        EnvironmentSettingsResponse environmentSettingsResponse = new EnvironmentSettingsResponse(environmentSettings);
            new NamedWriteableRegistry(Collections.emptyList()),
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
import static org.mockito.ArgumentMatchers.anyString;
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
            NoopTracer.INSTANCE
            "127.0.0.0",
import org.opensearch.core.common.io.stream.BytesStreamInput;
        extensionsManager.loadExtension(secondExtension);
            out.flush();
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            "firstExtension",
            );
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            client,
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.cluster.service.ClusterService;
        List<Setting<?>> requestComponentSettings = new ArrayList<>();
            assertEquals(extension.getMinimumCompatibleVersion(), initializedExtension.getMinimumCompatibleVersion());
                "test_node",
            "9301",
                    "org.opensearch.extensions.ExtensionsManager",
    @Before
        };
 *
        );
        ffLock.close();
            "3.0.0",
        assertEquals(EnvironmentSettingsResponse.class, extensionsManager.handleExtensionRequest(environmentSettingsRequest).getClass());
        assertEquals(data, updateSettingsRequest.getData());
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
                "uniqueid1",
                NoopTracer.INSTANCE
    public void testHandleRegisterRestActionsRequestWithInvalidMethod() throws Exception {
        );
            null
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry());
                "firstExtension",
        );
    }
        }
            "2.0.0",
                assertEquals(List.of(expectedDependency), discoveryExtensionNode.getDependencies());
            "127.0.0.0",
        extensionsManager.loadExtension(firstExtension);
        transportService.start();
            extensionsManager.loadExtension(firstExtension);
            "0.0.7",
        ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);
                emptySet(),
        // Test ExtensionRequest 1 arg constructor
    private static FeatureFlags.TestUtils.FlagWriteLock ffLock = null;
        );
    public void testLoadExtensions() throws Exception {
        // Create setting with value false
            actionModule,
        ExtensionRequest clusterSettingRequest = new ExtensionRequest(ExtensionRequestProto.RequestType.REQUEST_EXTENSION_CLUSTER_SETTINGS);
        boolean data = true;
                new MockLogAppender.SeenEventExpectation(
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
        // Test EnvironmentSettingsResponse StreamInput constructor
            clusterService,
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
import org.opensearch.common.util.FeatureFlags;
        List<DiscoveryExtensionNode> expectedExtensions = new ArrayList<DiscoveryExtensionNode>();
                environmentSettingsResponse = new EnvironmentSettingsResponse(in);
    }
import org.opensearch.common.util.PageCacheRecycler;
            }
                assertEquals(false, boolSetting.get(environmentSettingsResponse.getEnvironmentSettings()));
                Version.fromString("3.0.0"),
        verify(mockTransportService, times(2)).sendRequest(
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
    }
                null,
            "firstExtension",
import java.io.IOException;
        expectThrows(
        assertEquals(extension.getId(), initializedExtension.getId());
    }
        );
                settings.add(customSetting);
import org.opensearch.threadpool.TestThreadPool;
            )
                assertTrue(requestComponentSettings.containsAll(componentSettings));
        RegisterCustomSettingsRequest registerCustomSettingsRequest = new RegisterCustomSettingsRequest(uniqueIdStr, settingsList);
import org.opensearch.common.settings.Setting.Property;
            actionModule,
                "test_node",
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            threadPool,
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        assertEquals(0, extensionsManager.getExtensionIdMap().values().size());
    public void testNonUniqueLoadedExtensions() throws Exception {
                extensionDependencyResponse = new ExtensionDependencyResponse(in);
            null
        assertEquals(
        IOException exception = expectThrows(IOException.class, () -> extensionsManager.loadExtension(secondExtension));
        assertEquals(settings, environmentSettingsResponse.getEnvironmentSettings());
        );
                dependency = new ExtensionDependency(in);
        Settings environmentSettings = Settings.builder().put("boolSetting", "true").build();
        assertEquals(expectedUniqueId, dependency.getUniqueId());
            "3.0.0",
                for (WriteableSetting writeableSetting : addSettingsUpdateConsumerRequest.getComponentSettings()) {
            @Override
            "uniqueid1",
                uniqueIdStr,
            Version.fromString("3.0.0"),
        expectedExtensions.add(
import org.opensearch.transport.Transport;
            }
        assertEquals(0, extensionsManager.getExtensionIdMap().values().size());
        String uniqueIdStr = "uniqueid1";
            "3.0.0",
        Version expectedVersion = Version.fromString("3.0.0");
            NoopTracer.INSTANCE
import org.opensearch.extensions.ExtensionsSettings.Extension;
            public List<Setting<?>> getExtensionSettings() {
                "3.0.0",
                List.of(),
}
    private TransportService transportService;
import org.opensearch.action.ActionModule;
    }
                assertEquals(data, updateSettingsRequest.getData());
            .handleAddSettingsUpdateConsumerRequest(addSettingsUpdateConsumerRequest);
            identityService
    public void testUpdateSettingsRequest() throws Exception {
                requestComponentSettings = new ArrayList<>();
        TransportResponse response = extensionsManager.getAddSettingsUpdateConsumerRequestHandler()
        );
    public void testHandleExtensionRequest() throws Exception {
import org.opensearch.discovery.InitializeExtensionRequest;
            }
            emptySet(),
            }
    }
        );
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        for (DiscoveryExtensionNode extension : expectedExtensions) {
            Setting.simpleString("fooSetting", "foo", Property.NodeScope, Property.Final)
            DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());
        ExtensionDependency dependentExtension = new ExtensionDependency("uniqueid0", Version.fromString("2.0.0"));
            "2.0.0",
import org.opensearch.rest.RestController;
import org.opensearch.common.io.stream.BytesStreamOutput;
                NoopTracer.INSTANCE
        TransportService mockTransportService = spy(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    Level.INFO,
            extensionNode,
            new DiscoveryExtensionNode(
                null,
            new DiscoveryExtensionNode(
        );
        );
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo", "It's deprecated!");
            null
            exception.getMessage()
    }
            assertTrue(extensionsManager.lookupExtensionSettingsById(extension.getId()).isPresent());
            "0.0.7",
        expectThrows(
        extensionNode = new DiscoveryExtensionNode(
                discoveryExtensionNode = new DiscoveryExtensionNode(in);
import org.opensearch.extensions.rest.RegisterRestActionsRequest;
        String expectedUniqueId = "test uniqueid";
        expectedExtensions.add(
        Extension firstExtension = new Extension(
            clusterService,
        Extension firstExtension = new Extension(
                threadPool,
        Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
        );
            "3.99.0",
        String expectedId = "test id";
        initialize(extensionsManager);
                extensionRequest = new ExtensionRequest(in);
    }
            settings,
    public void testHandleRegisterRestActionsRequest() throws Exception {
            assertEquals(extension.getDependencies(), initializedExtension.getDependencies());
                new HashMap<String, String>(),
        );
            "127.0.0.0",
        Settings environmentSettings = Settings.builder().put("testSetting", "true").build();
            )
        );
    private final Settings settings = Settings.builder()
            mockTransportService,
        client.close();
                updateSettingsRequest = new UpdateSettingsRequest(in);
            List.of(dependentExtension),
            settingsModule,
    public void testIncompatibleExtensionRegistration() throws IOException {
        };
            }
import org.opensearch.OpenSearchException;
            assertEquals(extension.getName(), initializedExtension.getName());
            ),
            settingsModule,
        initialize(extensionsManager);
        String expectedUniqueId = "test uniqueid";
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedUniqueId, expectedVersion);
            "0.0.7",
            "none",
        ExtensionRequest extensionRequest = new ExtensionRequest(expectedRequestType, expectedUniqueId);
        }
    @After
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            settings,
        }
        // Create setting with value false
                new HashMap<String, String>(),
import org.opensearch.extensions.settings.RegisterCustomSettingsRequest;
            }
            "secondExtension",
        );
            new TransportService(
                "3.0.0",
                    "[firstExtension][127.0.0.0:9300] Node not connected"
                Settings.EMPTY,
        ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);
        List<String> actionsList = List.of("FOO /foo", "PUT /bar", "POST /baz");
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        );
            IllegalArgumentException.class,
        ExtensionDependencyResponse extensionDependencyResponse = new ExtensionDependencyResponse(expectedExtensionsList);
        assertEquals(List.of(expectedDependency), discoveryExtensionNode.getDependencies());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        Setting<?> componentSetting = Setting.boolSetting("falseSetting", false, Property.Dynamic);
        Extension firstExtension = new Extension(
                assertEquals(componentSettings.size(), addSettingsUpdateConsumerRequest.getComponentSettings().size());
            mockLogAppender.addExpectation(
            "127.0.0.0",
        Exception exception = expectThrows(
        );
import org.opensearch.transport.client.node.NodeClient;
    }
        extensionsManager.loadExtension(
                assertEquals(true, boolSetting.get(environmentSettingsResponse.getEnvironmentSettings()));
    private RestController restController;
        assertEquals("Handler not present for the provided request", exception.getMessage());
            ExtensionRequestProto.RequestType.REQUEST_EXTENSION_ENVIRONMENT_SETTINGS
        assertEquals(expectedRequestType, extensionRequest.getRequestType());
        initialize(extensionsManager);
        Version expectedVersion = Version.fromString("2.0.0");
                deprecatedActionsList
        ExtensionDependency dependency = new ExtensionDependency(expectedUniqueId, expectedVersion);
    }
        super.tearDown();
                .handleRegisterRestActionsRequest(registerActionsRequest, dynamicActionRegistry)
                    "org.opensearch.extensions.ExtensionsManager",
            .handleRegisterCustomSettingsRequest(registerCustomSettingsRequest);
                    "org.opensearch.extensions.ExtensionsManager",
        }
        // Test EnvironmentSettingsResponse arg constructor
        expectThrows(
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            "secondExtension",
                mock(Transport.class),
        );
    }
            Version.fromString("2.0.0"),
        String uniqueIdStr = "uniqueid1";
        ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);
                    "No response from extension to request."
                new MockLogAppender.SeenEventExpectation(
        Setting customSetting = Setting.simpleString("custom_extension_setting", "custom_setting", Property.ExtensionScope);
        Version expectedVersion = Version.fromString("2.0.0");
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
import static java.util.Collections.emptyList;
        initialize(extensionsManager);
            clusterService,
        }
            "3.0.0",
        assertTrue(requestComponentSettings.containsAll(componentSettings));
            "uniqueid1",
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        verify(mockTransportService, times(2)).connectToExtensionNode(any(DiscoveryExtensionNode.class));
            "9301",
 * compatible open source license.
import org.opensearch.transport.TransportService;
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        // Test ExtensionRequest StreamInput constructor
        );
            client,
            identityService
            settingsModule,
import org.opensearch.usage.UsageService;
            "3.0.0",
                addSettingsUpdateConsumerRequest = new AddSettingsUpdateConsumerRequest(in);
                assertEquals(settings, environmentSettingsResponse.getEnvironmentSettings());
                new HashMap<String, String>(),
    @Override
            "uniqueid2",
        initialize(extensionsManager);
                "uniqueid2",
                null,
    }
        }
    public void testExtensionRequest() throws Exception {
                .handleRegisterRestActionsRequest(registerActionsRequest, dynamicActionRegistry)
                assertEquals(expectedExtensionsList, extensionDependencyResponse.getExtensionDependency());
public class ExtensionsManagerTests extends OpenSearchTestCase {
        extensionRequest = new ExtensionRequest(expectedRequestType);
        List<String> actionsList = List.of("GET /foo", "PUT /bar", "POST /baz");
            new NoneCircuitBreakerService(),
        String expectedUniqueId = "uniqueid0";
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
    public void testHandleAddSettingsUpdateConsumerRequest() throws Exception {
            Setting.boolSetting("trueSetting", true, Property.Dynamic)
        String uniqueIdStr = "uniqueid1";
        List<Setting<?>> componentSettings = List.of(
            "127.0.0.0",
            new HashMap<String, String>(),
                    "Node Not Connected Exception 1",
    }
            "secondExtension",
        expectedExtensionsList.add(
        }
        expectThrows(
            () -> extensionsManager.getRestActionsRequestHandler()
            Setting.boolSetting("index.falseSetting", false, Property.IndexScope, Property.Dynamic),
        TransportResponse response = extensionsManager.getCustomSettingsRequestHandler()
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            componentSettings
                Collections.emptySet(),
        }
import org.opensearch.test.transport.MockTransportService;
    private Setting customSetting = Setting.simpleString("custom_extension_setting", "none", Property.ExtensionScope);
            extensionsManager.lookupExtensionSettingsById(extension.getId()).get().getAdditionalSettings().get(customSetting)
        DiscoveryExtensionNode initializedExtension = extensionsManager.getExtensionIdMap().get(extension.getId());
        when(actionModule.getRestController()).thenReturn(restController);
        );
        assertTrue(expectedExtensions.containsAll(emptyList()));
            "firstExtension",
        assertEquals(List.of(expectedDependency), expectedExtensions.get(1).getDependencies());
        Extension secondExtension = new Extension(
        actionModule = mock(ActionModule.class);
import org.opensearch.common.settings.Setting;
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        assertEquals(expectedVersion, dependency.getVersion());
            "127.0.0.0",
            null
        ExtensionRequest exceptionRequest = new ExtensionRequest(ExtensionRequestProto.RequestType.GET_SETTINGS);
        for (int i = 0; i < 2; i++) {
        assertTrue(componentSettings.containsAll(requestComponentSettings));
        initialize(extensionsManager);
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
import org.apache.logging.log4j.LogManager;
            "custom_setting",
            discoveryExtensionNode.writeTo(out);
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
            "uniqueid1",
        IOException exception = expectThrows(IOException.class, () -> extensionsManager.loadExtension(firstExtension));
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            assertEquals(extension.getAttributes(), initializedExtension.getAttributes());
    public void testHandleRegisterRestActionsRequestWithInvalidDeprecatedUri() throws Exception {
    public void testDiscoveryExtension() throws Exception {
import org.opensearch.Version;
            Setting.boolSetting("falseSetting", false, Property.IndexScope, Property.NodeScope),
            Setting.simpleString("fooSetting", "foo", Property.Dynamic)
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
                assertEquals(extensionNode, addSettingsUpdateConsumerRequest.getExtensionNode());
import java.util.stream.Collectors;
            () -> extensionsManager.handleExtensionRequest(exceptionRequest)
            () -> extensionsManager.getRestActionsRequestHandler()
            ExtensionScopedSettings extensionScopedSettings = new ExtensionScopedSettings(additionalSettings);
        transportService.acceptIncomingRequests();
            new HashMap<String, String>(),
            assertEquals(extension.getAddress(), initializedExtension.getAddress());
import java.util.Set;
            public List<Setting<?>> getExtensionSettings() {
        Extension firstExtension = new Extension(
        assertTrue(extensionRequest.getUniqueId().isEmpty());
import org.opensearch.action.ActionModule.DynamicActionRegistry;
        List<Setting<?>> settingsList = List.of(
            assertTrue(((AcknowledgedResponse) response).getStatus());
        Extension firstExtension = new Extension(
            () -> extensionsManager.getRestActionsRequestHandler()
            }
            "2.0.0",
                    "[secondExtension][127.0.0.1:9301] Node not connected"
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        );
        }
        assertEquals(AcknowledgedResponse.class, response.getClass());
                }
                List<Setting<?>> settings = new ArrayList<Setting<?>>();
        restController = new RestController(
        }
                List.of(expectedDependency)
                // bool setting is not registered in Settings object, thus the expected return value is the default setting value
        extAwarePlugin = new ExtensionAwarePlugin() {
                assertEquals(expectedVersion, dependency.getVersion());
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(extension.getName(), initializedExtension.getName());
                new HashMap<String, String>(),
            IllegalArgumentException.class,
            out.flush();
        Extension firstExtension = new Extension(
            new Extension("firstExtension", uniqueIdStr, "127.0.0.0", "9300", "0.0.7", "3.0.0", "3.0.0", List.of(), null)
            );
                new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
        ExtensionsManager extensionsManager = new ExtensionsManager(additionalSettings, identityService);
    public void testHandleRegisterRestActionsRequestMultiple() throws Exception {
                Collections.emptyList()
            );
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
    public void testInitializeExtension() throws Exception {
        );
import java.util.List;
    private NodeClient client;
import org.apache.logging.log4j.Level;
        Version expectedVersion = Version.fromString("2.0.0");
                Version.fromString("2.0.0"),
    }
                new TransportAddress(InetAddress.getByName("127.0.0.1"), 9301),
        TransportResponse response = extensionsManager.getRestActionsRequestHandler()
            threadPool,
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
            actionModule,
            out.flush();
        String uniqueIdStr = "uniqueid1";
import static org.mockito.Mockito.when;
            "secondExtension",
            );
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry())
                "Extension %s" + i,
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
import org.opensearch.env.Environment;
        AddSettingsUpdateConsumerRequest addSettingsUpdateConsumerRequest = new AddSettingsUpdateConsumerRequest(
                Collections.emptySet(),
        // Create settings object without registered bool setting
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry())
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),
        identityService = new IdentityService(Settings.EMPTY, threadPool, List.of());
        // Create Settings with registered bool setting with value true
            "uniqueid1",
                assertEquals(expectedRequestType, extensionRequest.getRequestType());
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        // Test ExtensionDependencyResponse arg constructor
            "9300",
            addSettingsUpdateConsumerRequest.writeTo(out);
    public void tearDown() throws Exception {
            "firstExtension",
    private void initialize(ExtensionsManager extensionsManager) {
import java.net.InetAddress;
            extensionRequest.writeTo(out);
            settings,
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
        ExtensionsManager extensionsManager = new ExtensionsManager(additionalSettings, identityService);
        ffLock = new FeatureFlags.TestUtils.FlagWriteLock(EXTENSIONS);
    public void testMissingRequiredFieldsWhileLoadingExtension() throws Exception {
            List.of(),
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        extensionsManager.loadExtension(firstExtension);
            () -> extensionsManager.getRestActionsRequestHandler()
import java.util.HashMap;
    }
            "3.0.0",
            "2.0.0",
        assertEquals(false, ((AcknowledgedResponse) response).getStatus());
                "0.0.7",
            assertEquals(extension.getId(), initializedExtension.getId());
import java.util.concurrent.TimeUnit;
            requestComponentSettings.add(writeableSetting.getSetting());
        ExtensionRequestProto.RequestType expectedRequestType = ExtensionRequestProto.RequestType.REQUEST_EXTENSION_DEPENDENCY_INFORMATION;
        initialize(extensionsManager);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            "firstExtension",
            out.flush();
import org.opensearch.cluster.ClusterSettingsResponse;
        Set<Setting<?>> additionalSettings = extAwarePlugin.getExtensionSettings().stream().collect(Collectors.toSet());
            assertEquals(extension.getDependencies(), initializedExtension.getDependencies());
        assertEquals(ClusterSettingsResponse.class, extensionsManager.handleExtensionRequest(clusterSettingRequest).getClass());
        assertEquals(settingType, updateSettingsRequest.getSettingType());
                .handleRegisterRestActionsRequest(registerActionsRequest, actionModule.getDynamicActionRegistry())
                List<Setting<?>> settings = new ArrayList<Setting<?>>();
    public void testAdditionalExtensionSettingsForExtensionWithCustomSettingSet() throws Exception {
        assertEquals(expectedExtensions.size(), extensionsManager.getExtensionIdMap().values().size());
        transportService.close();
        TransportService mockTransportService = spy(
            client,
            "uniqueid1",
        ExtensionRequest environmentSettingsRequest = new ExtensionRequest(
            Version.fromString("3.0.0"),
import static org.mockito.Mockito.doNothing;
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), identityService);
                "127.0.0.0",
            dependency.writeTo(out);
        extensionsManager.loadExtension(firstExtension);
        Extension firstExtension = new Extension("firstExtension", "uniqueid1", "127.0.0.0", "9300", "0.0.7", "3.0.0", "", null, null);
                "firstExtension",
            "9300",
 * SPDX-License-Identifier: Apache-2.0
        );
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest("uniqueId1", List.of(), List.of());
            Extension firstExtension = new Extension(
            }
        String uniqueIdStr = "uniqueid1";
            "0.0.7",
            (boundAddress) -> new DiscoveryNode(
            "firstExtension",
            "secondExtension",
            out.flush();
    }
        extensionsManager.initializeServicesAndRestHandler(
    public void testEnvironmentSettingsDefaultValue() throws Exception {
                Version.fromString("3.0.0"),
                "9300",
        );
    private ActionModule actionModule;
                )
import org.opensearch.common.settings.WriteableSetting.SettingType;
        // Test AddSettingsUpdateConsumerRequest StreamInput constructor
package org.opensearch.extensions;
            "3.0.0",
            new NoneCircuitBreakerService(),
import org.opensearch.env.EnvironmentSettingsResponse;
        List<String> deprecatedActionsList = List.of("GET /deprecated/foo foo_deprecated", "It's deprecated!");
import org.opensearch.extensions.proto.ExtensionRequestProto;
        // Test UpdateSettingRequest StreamInput constructor
                List.of(expectedDependency)
            mockLogAppender.addExpectation(
    public void testExtensionDependency() throws Exception {
    }
            TransportResponse response = extensionsManager.getRestActionsRequestHandler()
        doNothing().when(mockTransportService)
import org.opensearch.core.common.transport.TransportAddress;
        );
    public void testAdditionalExtensionSettingsForExtensionWithoutCustomSettingSet() throws Exception {
            componentSettings
import static org.mockito.Mockito.spy;
    public void testAddSettingsUpdateConsumerRequest() throws Exception {
        EnvironmentSettingsResponse environmentSettingsResponse = new EnvironmentSettingsResponse(environmentSettings);
        );
                assertTrue(extensionRequest.getUniqueId().isEmpty());
            identityService
            assertEquals(extension.getAddress(), initializedExtension.getAddress());
import org.opensearch.test.client.NoOpNodeClient;
        RegisterRestActionsRequest registerActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, actionsList, deprecatedActionsList);
            extensionScopedSettings
            Setting.boolSetting("falseSetting", false, Property.Dynamic),
    public void testEnvironmentSettingsRegisteredValue() throws Exception {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
                new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
        initialize(extensionsManager);
                x -> null,
        );
                "uniqueid1",
        ExtensionsManager extensionsManager = new ExtensionsManager(additionalSettings, identityService);
        // Test UpdateSettingRequest arg constructor
                extensionScopedSettings
    }
