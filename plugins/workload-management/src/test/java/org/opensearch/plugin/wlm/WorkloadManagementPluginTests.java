    public void testGetSettingsIncludesMaxWorkloadGroupCount() {
            mock(ScriptService.class),
        verify(plugin, times(1)).setAttributes(List.of(attribute));
        assertTrue(modules.iterator().next() instanceof WorkloadManagementPluginModule);
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
        Collection<?> modules = plugin.createGuiceModules();
import static org.mockito.Mockito.mock;
        verify(extension, times(1)).getAttributeExtractor();
package org.opensearch.plugin.wlm;
            mock(ResourceWatcherService.class),
    public void testLoadExtensionsWithMock() {
    }
        Client mockClient = mock(Client.class);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.ActionPlugin;
            null,
        List<RestHandler> handlers = plugin.getRestHandlers(
        Attribute attribute = mock(Attribute.class);
        Attribute attribute = mock(Attribute.class);
    public void testGetRestHandlersReturnsHandlers() {
    /**
import org.opensearch.rule.autotagging.FeatureType;
        assertNotNull(service);
            mockClusterService,
import static org.hamcrest.Matchers.equalTo;
            mock(Environment.class),
        );
        AttributeExtractor<String> extractor = mock(AttributeExtractor.class);
import org.opensearch.plugin.wlm.rest.RestGetWorkloadGroupAction;
        verify(loader, times(1)).loadExtensions(AttributeExtractorExtension.class);
import org.opensearch.watcher.ResourceWatcherService;
    }
            mock(ScriptService.class),
import org.opensearch.rest.RestController;
    }
    @Override
        plugin.loadExtensions(loader);
            () -> mock(DiscoveryNodes.class)
import org.opensearch.rule.RulePersistenceService;
            mockThreadPool,
    public void testGetFeatureTypeReturnsWorkloadGroupFeatureType() {
import org.opensearch.cluster.service.ClusterService;
            null,
        assertEquals(4, handlers.size());
        when(extractor.getAttribute()).thenReturn(attribute);
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
import org.opensearch.rest.RestHandler;
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;
        assertEquals(1, modules.size());
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;
            () -> mock(RepositoriesService.class)
        assertTrue(service instanceof IndexStoredRulePersistenceService);
    public void testSetAttributesWithMock() {
        when(loader.loadExtensions(AttributeExtractorExtension.class)).thenReturn(List.of(extension));
    public void tearDown() throws Exception {
        );
        super.setUp();
 */
        Collection<SystemIndexDescriptor> descriptors = plugin.getSystemIndexDescriptors(Settings.EMPTY);
        Collection<Object> components = plugin.createComponents(
    public void testCreateGuiceModulesReturnsModule() {
    public void testCreateComponentsInitializesRulePersistenceService() {
            mock(NamedWriteableRegistry.class),
        plugin.createComponents(
    @Override
    public void setUp() throws Exception {
import static org.mockito.Mockito.times;
        assertTrue(settings.contains(WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT));
        assertEquals(CreateWorkloadGroupAction.INSTANCE.name(), actions.get(0).getAction().name());
        Supplier<RepositoriesService> mockRepositoriesServiceSupplier = () -> mock(RepositoriesService.class);
        when(mockClusterService.getClusterSettings()).thenReturn(clusterSettings);
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestCreateWorkloadGroupAction));
            mockIndexNameExpressionResolver,
            mock(RestController.class),
            mock(ResourceWatcherService.class),
            mockClient,
            mockClusterService,
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestGetWorkloadGroupAction));
            mock(NamedWriteableRegistry.class),
import org.opensearch.plugin.wlm.rest.RestCreateWorkloadGroupAction;
        FeatureType featureType = plugin.getFeatureTypeSupplier().get();
            mockScriptService,
     */
import org.opensearch.plugins.ExtensiblePlugin;
        Settings settings = Settings.builder().put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000).build();
 * The OpenSearch Contributors require contributions made to
 *
     * This test verifies that the createComponents method returns a collection
    public void testGetActionsReturnsHandlers() {
            mock(IndexNameExpressionResolver.class),
        plugin.createComponents(
import java.util.function.Supplier;
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestUpdateWorkloadGroupAction));
        AttributeExtractorExtension extension = mock(AttributeExtractorExtension.class);
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;
     * containing a single RefreshBasedSyncMechanism instance.
        NamedXContentRegistry mockNamedXContentRegistry = mock(NamedXContentRegistry.class);
        assertThat(components.stream().filter(c -> c instanceof RefreshBasedSyncMechanism).count(), equalTo(1L));
    ClusterService mockClusterService;
            null,
        Client mockClient = mock(Client.class);
import java.util.List;
    }
        );
import org.opensearch.threadpool.ThreadPool;
        when(mockClusterService.getSettings()).thenReturn(settings);
        plugin.setAttributes(List.of(attribute));
import org.opensearch.transport.client.Client;
            mockNamedWriteableRegistry,
            mock(NamedXContentRegistry.class),
        assertEquals(".wlm_rules", descriptor.getIndexPattern());
import org.opensearch.env.Environment;
    WorkloadManagementPlugin plugin = new WorkloadManagementPlugin();
import org.opensearch.repositories.RepositoriesService;
/*
import org.opensearch.core.action.ActionResponse;
        when(attribute.getName()).thenReturn("mock_attr");
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.test.OpenSearchTestCase;
    public void testGetSystemIndexDescriptorsReturnsCorrectDescriptor() {
        super.tearDown();
        ExtensiblePlugin.ExtensionLoader loader = mock(ExtensiblePlugin.ExtensionLoader.class);
            mock(Client.class),
        mockClusterService = mock(ClusterService.class);
    }
        WorkloadManagementPlugin plugin = mock(WorkloadManagementPlugin.class);
    }
import java.util.Collection;
        );
     * Test case for createComponents method.
import org.opensearch.core.xcontent.NamedXContentRegistry;
        List<?> settings = plugin.getSettings();
            mock(Environment.class),
            null,
            mockNamedXContentRegistry,
    }
import org.opensearch.script.ScriptService;
        SystemIndexDescriptor descriptor = descriptors.iterator().next();
        IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
import org.opensearch.plugin.wlm.rest.RestDeleteWorkloadGroupAction;
    }
            null,
    }
            () -> mock(RepositoriesService.class)
import org.opensearch.action.ActionRequest;
        assertEquals(1, descriptors.size());
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestDeleteWorkloadGroupAction));
    }
import static org.mockito.Mockito.when;
            mock(ThreadPool.class),
            null,
            mockRepositoriesServiceSupplier
import org.opensearch.indices.SystemIndexDescriptor;
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
}
import org.opensearch.common.settings.ClusterSettings;
 * compatible open source license.
    }
import java.util.HashSet;
            mockResourceWatcherService,
        assertEquals(4, actions.size());
        ThreadPool mockThreadPool = mock(ThreadPool.class);
import static org.mockito.Mockito.verify;
        verify(extractor, times(1)).getAttribute();
        RulePersistenceService service = plugin.getRulePersistenceServiceSupplier().get();
import org.opensearch.common.settings.Settings;
        List<ActionPlugin.ActionHandler<? extends ActionRequest, ? extends ActionResponse>> actions = plugin.getActions();
        ScriptService mockScriptService = mock(ScriptService.class);
    @SuppressWarnings("unchecked")
            mock(ThreadPool.class),
    }
 * SPDX-License-Identifier: Apache-2.0
        WorkloadManagementPlugin plugin = spy(new WorkloadManagementPlugin());
import org.opensearch.wlm.WorkloadManagementSettings;
        assertEquals("workload_group", featureType.getName());
            mockClient,
import org.opensearch.rule.autotagging.Attribute;
            mock(IndexNameExpressionResolver.class),
        ResourceWatcherService mockResourceWatcherService = mock(ResourceWatcherService.class);
import static org.mockito.Mockito.spy;
import org.opensearch.plugin.wlm.rest.RestUpdateWorkloadGroupAction;
            null,
        ClusterSettings clusterSettings = new ClusterSettings(settings, new HashSet<>(plugin.getSettings()));
            mockClusterService,
        NamedWriteableRegistry mockNamedWriteableRegistry = mock(NamedWriteableRegistry.class);
        Environment mockEnvironment = mock(Environment.class);
            Settings.EMPTY,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        clusterSettings.registerSetting(WorkloadManagementSettings.WLM_MODE_SETTING);
        when(extension.getAttributeExtractor()).thenReturn(extractor);
        when(attribute.getName()).thenReturn(PRINCIPAL_ATTRIBUTE_NAME);
            mockEnvironment,
            mock(NamedXContentRegistry.class),
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
public class WorkloadManagementPluginTests extends OpenSearchTestCase {
    public void testCreateComponentsReturnsRefreshMechanism() {
