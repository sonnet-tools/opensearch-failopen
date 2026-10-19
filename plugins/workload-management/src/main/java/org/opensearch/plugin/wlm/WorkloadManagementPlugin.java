    @Override
            }
    public Supplier<RulePersistenceService> getRulePersistenceServiceSupplier() {
    @Override  
    }
import org.opensearch.rule.RuleRoutingService;
import java.util.Collection;
import org.opensearch.common.settings.Settings;
    private AutoTaggingActionFilter autoTaggingActionFilter;  
     */
        NamedXContentRegistry xContentRegistry,  
    @Override
    public List<RestHandler> getRestHandlers(
import org.opensearch.rule.autotagging.FeatureType;
        }  
            DefaultAttributeValueStore::new  
        for (AttributeExtractorExtension ext : loader.loadExtensions(AttributeExtractorExtension.class)) {
import org.opensearch.script.ScriptService;
            ruleProcessingService,
            if (attribute.getName().equals(PRINCIPAL_ATTRIBUTE_NAME)) {  
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupAction;  
        return List.of(  
import org.opensearch.plugin.wlm.action.TransportGetWorkloadGroupAction;
    }  
package org.opensearch.plugin.wlm;
    implements  
    @Override
import org.opensearch.rule.RuleEntityParser;  
        ActionPlugin,
        ((WorkloadGroupRuleRoutingService) ruleRoutingService).setTransportService(transportService);
    }
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
import org.opensearch.plugin.wlm.rest.RestCreateWorkloadGroupAction;
            featureType,
            new ActionPlugin.ActionHandler<>(GetWorkloadGroupAction.INSTANCE, TransportGetWorkloadGroupAction.class),
            new ActionPlugin.ActionHandler<>(CreateWorkloadGroupAction.INSTANCE, TransportCreateWorkloadGroupAction.class),
    }
        return () -> rulePersistenceService;
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupAction;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public Collection<Object> createComponents(  
 */
    @Override
        NodeEnvironment nodeEnvironment,
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    @Override
    }
            wlmClusterSettingValuesProvider,
    ) {  
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
        RestController restController,
            wlmClusterSettingValuesProvider
        ClusterService clusterService,
        ruleRoutingService = new WorkloadGroupRuleRoutingService(client, clusterService);
    /**
    public Supplier<FeatureType> getFeatureTypeSupplier() {
import org.opensearch.plugin.wlm.rule.WorkloadGroupRuleRoutingService;
    public void setAttributes(List<Attribute> attributes) {
import org.opensearch.plugin.wlm.rest.RestDeleteWorkloadGroupAction;
        Supplier<RepositoriesService> repositoriesServiceSupplier
        Environment environment,
     * The name of the index where rules are stored.
import java.util.function.Supplier;
        featureType = new WorkloadGroupFeatureType(new WorkloadGroupFeatureValueValidator(clusterService), orderedAttributes);
        );
import org.opensearch.rule.storage.XContentRuleParser;
/*  
import org.opensearch.rule.storage.DefaultAttributeValueStore;
import org.opensearch.common.settings.Setting;
            featureType,
        );
import org.opensearch.env.NodeEnvironment;  
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
     */  
            new RestGetWorkloadGroupAction(),
        ScriptService scriptService,
import org.opensearch.common.settings.IndexScopedSettings;  
import org.opensearch.rule.InMemoryRuleProcessingService;
        return List.of(new WorkloadManagementPluginModule());  
import java.util.Map;  
import org.opensearch.plugins.ActionPlugin;  
import org.opensearch.rule.spi.RuleFrameworkExtension;  
    public static final int MAX_RULES_PER_PAGE = 50;
        autoTaggingActionFilter = new AutoTaggingActionFilter(
import org.opensearch.common.settings.SettingsFilter;  
            attributeExtractorExtensions.put(ext.getAttributeExtractor().getAttribute(), ext);
 * The OpenSearch Contributors require contributions made to  
            attributeExtractorExtensions,
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;
import org.opensearch.rule.autotagging.Attribute;  
        return () -> ruleRoutingService;
            threadPool,  
            RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING,
    private final Map<Attribute, AttributeExtractorExtension> attributeExtractorExtensions = new HashMap<>();
        );
    public Collection<Module> createGuiceModules() {
 */  
 * this file be licensed under the Apache-2.0 license or a
        return () -> featureType;  
        );
            featureType.getOrderedAttributes()
        return Collections.emptyMap();
import org.opensearch.transport.TransportService;
     * Principal attribute name.
    }  
}
        );
    @Override
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
import java.util.List;
import org.opensearch.action.ActionRequest;
/**
            clusterService.getSettings(),  
import org.opensearch.rest.RestController;  
            new IndexBasedRuleQueryMapper()  
    @Override  
    public List<Setting<?>> getSettings() {
    @Override
            WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT,
import org.opensearch.plugin.wlm.rest.RestUpdateWorkloadGroupAction;
        RefreshBasedSyncMechanism refreshMechanism = new RefreshBasedSyncMechanism(
        ClusterSettings clusterSettings,
    }
        rulePersistenceService = new IndexStoredRulePersistenceService(  
        AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(
import org.opensearch.indices.SystemIndexDescriptor;
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.plugin.wlm.action.TransportDeleteWorkloadGroupAction;  
    }
import org.opensearch.common.inject.Module;  
import org.opensearch.rule.storage.AttributeValueStoreFactory;
            new RestUpdateWorkloadGroupAction(wlmClusterSettingValuesProvider)  
        wlmClusterSettingValuesProvider = new WlmClusterSettingValuesProvider(
    private static RulePersistenceService rulePersistenceService;
import org.opensearch.plugin.wlm.action.GetWorkloadGroupAction;
    private static RuleRoutingService ruleRoutingService;  
    public static final String INDEX_NAME = ".wlm_rules";
            MAX_RULES_PER_PAGE,
import org.opensearch.core.action.ActionResponse;
    }  
 * Plugin class for WorkloadManagement  
            attributeValueStoreFactory,  
import org.opensearch.plugins.SystemIndexPlugin;
import org.opensearch.cluster.service.ClusterService;
        Supplier<DiscoveryNodes> nodesInCluster  
    public List<ActionFilter> getActionFilters() {  
            clusterService.getSettings(),
        ThreadPool threadPool,  
    public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {  
    @Override
    private static FeatureType featureType;
        );
import org.opensearch.plugin.wlm.action.TransportUpdateWorkloadGroupAction;
    public Supplier<RuleRoutingService> getRuleRoutingServiceSupplier() {  
 * compatible open source license.
    @Override
import org.opensearch.action.support.ActionFilter;
            MAX_WLM_RULES_SETTING  
        IndexScopedSettings indexScopedSettings,  
        Client client,
    public static final String PRINCIPAL_ATTRIBUTE_NAME = "principal";  
    /**  
        }  
            new RuleEventClassifier(Collections.emptySet(), ruleProcessingService),  
    /**
            threadPool,
        ResourceWatcherService resourceWatcherService,
import org.opensearch.transport.client.Client;
     */
import org.opensearch.rest.RestHandler;
        InMemoryRuleProcessingService ruleProcessingService = new InMemoryRuleProcessingService(
            new ActionPlugin.ActionHandler<>(DeleteWorkloadGroupAction.INSTANCE, TransportDeleteWorkloadGroupAction.class),  
    private static final Map<Attribute, Integer> orderedAttributes = new HashMap<>();
import static org.opensearch.rule.service.IndexStoredRulePersistenceService.MAX_WLM_RULES_SETTING;  
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.plugin.wlm.rest.RestGetWorkloadGroupAction;  
 *
     */
import org.opensearch.common.network.NetworkService;
import org.opensearch.discovery.SeedHostsProvider;
        return List.of(  
import org.opensearch.watcher.ResourceWatcherService;  
    private WlmClusterSettingValuesProvider wlmClusterSettingValuesProvider;
        return List.of(autoTaggingActionFilter);
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureValueValidator;  
     * The maximum number of rules allowed per GET request.  
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;
import org.opensearch.rule.storage.IndexBasedRuleQueryMapper;  
import org.opensearch.plugin.wlm.action.TransportCreateWorkloadGroupAction;
    public void loadExtensions(ExtensionLoader loader) {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        for (Attribute attribute : attributes) {
    }  
    }
    }
            featureType  
        DiscoveryPlugin,  
    ) {
            clusterService,  
import org.opensearch.plugins.Plugin;  
        );
    /**  
        SettingsFilter settingsFilter,
        SystemIndexPlugin,
import org.opensearch.threadpool.ThreadPool;  
            parser,
import java.util.HashMap;
            new RestDeleteWorkloadGroupAction(wlmClusterSettingValuesProvider),
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;  
        return List.of(refreshMechanism, featureType, rulePersistenceService);
    }
        );
import org.opensearch.env.Environment;
        );
        NamedWriteableRegistry namedWriteableRegistry,  
            rulePersistenceService,
        Settings settings,  
            client,
            INDEX_NAME,
                orderedAttributes.put(attribute, 1);
        RuleFrameworkExtension {
        RuleEntityParser parser = new XContentRuleParser(featureType);  
            clusterService.getClusterSettings()  
        return List.of(
            new RestCreateWorkloadGroupAction(wlmClusterSettingValuesProvider),  
public class WorkloadManagementPlugin extends Plugin
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {  
import org.opensearch.plugins.DiscoveryPlugin;
import org.opensearch.plugins.ExtensiblePlugin;
import java.util.Collections;  
    public WorkloadManagementPlugin() {}  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        ExtensiblePlugin,
import org.opensearch.repositories.RepositoriesService;
        return List.of(new SystemIndexDescriptor(INDEX_NAME, "System index used for storing workload_group rules"));
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
     * Default constructor
import org.opensearch.rule.RulePersistenceService;
            new ActionPlugin.ActionHandler<>(UpdateWorkloadGroupAction.INSTANCE, TransportUpdateWorkloadGroupAction.class)
import org.opensearch.cluster.node.DiscoveryNodes;
