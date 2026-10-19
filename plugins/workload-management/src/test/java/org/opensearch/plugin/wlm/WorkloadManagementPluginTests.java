    ClusterService mockClusterService;
            null,
 * SPDX-License-Identifier: Apache-2.0
        verify(loader, times(1)).loadExtensions(AttributeExtractorExtension.class);  
            mock(NamedXContentRegistry.class),  
        IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
import org.opensearch.transport.client.Client;  
            mockClusterService,
        ScriptService mockScriptService = mock(ScriptService.class);
        AttributeExtractor<String> extractor = mock(AttributeExtractor.class);
import org.opensearch.core.action.ActionResponse;
        RulePersistenceService service = plugin.getRulePersistenceServiceSupplier().get();
            null,
        super.tearDown();
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestCreateWorkloadGroupAction));
        verify(extension, times(1)).getAttributeExtractor();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;  
        Collection<Object> components = plugin.createComponents(
            null,
            null,
    WorkloadManagementPlugin plugin = new WorkloadManagementPlugin();  
            mockScriptService,
        AttributeExtractorExtension extension = mock(AttributeExtractorExtension.class);  
    public void tearDown() throws Exception {  
    }
        when(extractor.getAttribute()).thenReturn(attribute);  
import org.opensearch.plugins.ActionPlugin;
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;  
            mock(ScriptService.class),
        NamedWriteableRegistry mockNamedWriteableRegistry = mock(NamedWriteableRegistry.class);
    /**
    public void testCreateComponentsReturnsRefreshMechanism() {  
        );  
 */  
    public void testCreateComponentsInitializesRulePersistenceService() {
    }  
import java.util.List;  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.ClusterSettings;
    @SuppressWarnings("unchecked")  
import org.opensearch.plugin.wlm.rest.RestUpdateWorkloadGroupAction;
        ExtensiblePlugin.ExtensionLoader loader = mock(ExtensiblePlugin.ExtensionLoader.class);  
            mockClient,
    }
public class WorkloadManagementPluginTests extends OpenSearchTestCase {
            mockThreadPool,
    public void testCreateGuiceModulesReturnsModule() {
import static org.mockito.Mockito.spy;  
 *
    public void testLoadExtensionsWithMock() {
            mock(ResourceWatcherService.class),
            mock(Environment.class),
 * The OpenSearch Contributors require contributions made to  
        SystemIndexDescriptor descriptor = descriptors.iterator().next();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertEquals("workload_group", featureType.getName());
        WorkloadManagementPlugin plugin = mock(WorkloadManagementPlugin.class);
package org.opensearch.plugin.wlm;
import org.opensearch.plugin.wlm.rest.RestGetWorkloadGroupAction;  
        assertTrue(service instanceof IndexStoredRulePersistenceService);
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestUpdateWorkloadGroupAction));
        plugin.createComponents(  
        ThreadPool mockThreadPool = mock(ThreadPool.class);
import org.opensearch.plugin.wlm.rest.RestCreateWorkloadGroupAction;
        when(mockClusterService.getClusterSettings()).thenReturn(clusterSettings);
        Supplier<RepositoriesService> mockRepositoriesServiceSupplier = () -> mock(RepositoriesService.class);  
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
import static org.mockito.Mockito.verify;
        clusterSettings.registerSetting(WorkloadManagementSettings.WLM_MODE_SETTING);  
    public void testGetSettingsIncludesMaxWorkloadGroupCount() {
            mock(ScriptService.class),
        assertThat(components.stream().filter(c -> c instanceof RefreshBasedSyncMechanism).count(), equalTo(1L));
import org.opensearch.rest.RestController;
    public void testGetFeatureTypeReturnsWorkloadGroupFeatureType() {
    }
            () -> mock(RepositoriesService.class)
import org.opensearch.wlm.WorkloadManagementSettings;
            mock(ThreadPool.class),  
import org.opensearch.plugins.ExtensiblePlugin;  
        List<?> settings = plugin.getSettings();  
     * Test case for createComponents method.
import org.opensearch.common.settings.Settings;  
            mock(NamedXContentRegistry.class),  
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;  
            mockRepositoriesServiceSupplier
        Environment mockEnvironment = mock(Environment.class);  
        Settings settings = Settings.builder().put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000).build();
        Client mockClient = mock(Client.class);
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.action.ActionRequest;
import static org.hamcrest.Matchers.equalTo;
            Settings.EMPTY,  
        assertEquals(4, actions.size());  
        assertEquals(1, descriptors.size());  
import static org.mockito.Mockito.when;  
    }  
     */
            mockResourceWatcherService,  
import static org.mockito.Mockito.mock;
            () -> mock(DiscoveryNodes.class)  
        ClusterSettings clusterSettings = new ClusterSettings(settings, new HashSet<>(plugin.getSettings()));
        mockClusterService = mock(ClusterService.class);  
            mock(IndexNameExpressionResolver.class),
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestGetWorkloadGroupAction));
            mock(Client.class),
            mockEnvironment,  
import org.opensearch.indices.SystemIndexDescriptor;
    }  
        Attribute attribute = mock(Attribute.class);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.rule.autotagging.FeatureType;
    public void setUp() throws Exception {
        NamedXContentRegistry mockNamedXContentRegistry = mock(NamedXContentRegistry.class);
        FeatureType featureType = plugin.getFeatureTypeSupplier().get();
            mockNamedXContentRegistry,
            mock(ThreadPool.class),  
}
        Client mockClient = mock(Client.class);
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
        plugin.loadExtensions(loader);
import static org.mockito.Mockito.times;
            mockClient,  
    }
        assertTrue(handlers.stream().anyMatch(h -> h instanceof RestDeleteWorkloadGroupAction));  
            mockClusterService,
import org.opensearch.rest.RestHandler;  
    }
            () -> mock(RepositoriesService.class)
        when(attribute.getName()).thenReturn(PRINCIPAL_ATTRIBUTE_NAME);
        List<RestHandler> handlers = plugin.getRestHandlers(
import java.util.function.Supplier;
        assertTrue(settings.contains(WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT));
import java.util.Collection;
            mockClusterService,
    @Override
            mock(RestController.class),
 * compatible open source license.
        ResourceWatcherService mockResourceWatcherService = mock(ResourceWatcherService.class);  
            null,
import org.opensearch.threadpool.ThreadPool;
        assertNotNull(service);  
            mockNamedWriteableRegistry,
        WorkloadManagementPlugin plugin = spy(new WorkloadManagementPlugin());
        );
import org.opensearch.rule.autotagging.Attribute;  
    public void testGetSystemIndexDescriptorsReturnsCorrectDescriptor() {
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        );  
        plugin.setAttributes(List.of(attribute));
import org.opensearch.watcher.ResourceWatcherService;
        );
import org.opensearch.rule.RulePersistenceService;
        when(extension.getAttributeExtractor()).thenReturn(extractor);
     * containing a single RefreshBasedSyncMechanism instance.
    public void testGetActionsReturnsHandlers() {
        Attribute attribute = mock(Attribute.class);  
        assertEquals(".wlm_rules", descriptor.getIndexPattern());
        plugin.createComponents(  
        when(attribute.getName()).thenReturn("mock_attr");
            mock(NamedWriteableRegistry.class),  
    public void testGetRestHandlersReturnsHandlers() {
            mockIndexNameExpressionResolver,  
    }  
            mock(NamedWriteableRegistry.class),  
            mock(Environment.class),
    @Override  
import org.opensearch.script.ScriptService;  
import java.util.HashSet;
        when(mockClusterService.getSettings()).thenReturn(settings);
        super.setUp();
        assertEquals(1, modules.size());  
        assertTrue(modules.iterator().next() instanceof WorkloadManagementPluginModule);
import org.opensearch.plugin.wlm.rest.RestDeleteWorkloadGroupAction;
    }
/*  
import org.opensearch.cluster.node.DiscoveryNodes;  
        verify(extractor, times(1)).getAttribute();
            null,
        assertEquals(CreateWorkloadGroupAction.INSTANCE.name(), actions.get(0).getAction().name());
            null,  
        verify(plugin, times(1)).setAttributes(List.of(attribute));  
     * This test verifies that the createComponents method returns a collection  
            mock(ResourceWatcherService.class),
    }
        List<ActionPlugin.ActionHandler<? extends ActionRequest, ? extends ActionResponse>> actions = plugin.getActions();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        Collection<SystemIndexDescriptor> descriptors = plugin.getSystemIndexDescriptors(Settings.EMPTY);
        when(loader.loadExtensions(AttributeExtractorExtension.class)).thenReturn(List.of(extension));
    public void testSetAttributesWithMock() {
            mock(IndexNameExpressionResolver.class),
    }
import org.opensearch.env.Environment;
        Collection<?> modules = plugin.createGuiceModules();
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;
        assertEquals(4, handlers.size());  
