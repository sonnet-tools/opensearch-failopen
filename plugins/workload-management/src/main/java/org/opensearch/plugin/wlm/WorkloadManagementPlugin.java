        featureType = new WorkloadGroupFeatureType(new WorkloadGroupFeatureValueValidator(clusterService), orderedAttributes);
import org.opensearch.rest.RestHandler;
            ruleProcessingService,
    private static final Map<Attribute, Integer> orderedAttributes = new HashMap<>();
    public WorkloadManagementPlugin() {}
import org.opensearch.watcher.ResourceWatcherService;
    @Override
/**
 * compatible open source license.
 *
        SystemIndexPlugin,
            threadPool,
        return List.of(refreshMechanism, featureType, rulePersistenceService);
        }
import org.opensearch.rule.RuleRoutingService;
    public List<ActionFilter> getActionFilters() {
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;
    @Override
        Supplier<DiscoveryNodes> nodesInCluster
    @Override
            attributeExtractorExtensions.put(ext.getAttributeExtractor().getAttribute(), ext);
            new ActionPlugin.ActionHandler<>(CreateWorkloadGroupAction.INSTANCE, TransportCreateWorkloadGroupAction.class),
import org.opensearch.rule.spi.RuleFrameworkExtension;
    public Collection<Object> createComponents(
import java.util.Map;
    public List<RestHandler> getRestHandlers(
            new IndexBasedRuleQueryMapper()
    }
            featureType,
    /**
import org.opensearch.discovery.SeedHostsProvider;
import org.opensearch.plugin.wlm.rest.RestDeleteWorkloadGroupAction;
    @Override
import java.util.Collection;
        RestController restController,
import org.opensearch.common.settings.Setting;
            new RestUpdateWorkloadGroupAction(wlmClusterSettingValuesProvider)
        InMemoryRuleProcessingService ruleProcessingService = new InMemoryRuleProcessingService(
    public List<Setting<?>> getSettings() {
        NamedWriteableRegistry namedWriteableRegistry,
            RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING,
import org.opensearch.rule.storage.IndexBasedRuleQueryMapper;
import org.opensearch.action.ActionRequest;
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
    implements
            clusterService.getClusterSettings()
import org.opensearch.rule.RuleEntityParser;
import org.opensearch.env.NodeEnvironment;
        Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.common.network.NetworkService;
import org.opensearch.rule.autotagging.FeatureType;
import org.opensearch.plugin.wlm.rest.RestGetWorkloadGroupAction;
    }
    }
            wlmClusterSettingValuesProvider
import static org.opensearch.rule.service.IndexStoredRulePersistenceService.MAX_WLM_RULES_SETTING;
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
        DiscoveryPlugin,
import java.util.function.Supplier;
        return () -> featureType;
    @Override
            attributeValueStoreFactory,
        return List.of(new SystemIndexDescriptor(INDEX_NAME, "System index used for storing workload_group rules"));
        ResourceWatcherService resourceWatcherService,
import org.opensearch.cluster.node.DiscoveryNodes;
/*
     * The maximum number of rules allowed per GET request.
        return () -> rulePersistenceService;
import org.opensearch.plugin.wlm.action.TransportUpdateWorkloadGroupAction;
    @Override
            if (attribute.getName().equals(PRINCIPAL_ATTRIBUTE_NAME)) {
        return List.of(
        ((WorkloadGroupRuleRoutingService) ruleRoutingService).setTransportService(transportService);
import org.opensearch.common.settings.Settings;
    }
    @Override
import org.opensearch.plugins.DiscoveryPlugin;
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
        );
        );
    }
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupAction;
import org.opensearch.script.ScriptService;
        SettingsFilter settingsFilter,
import org.opensearch.plugin.wlm.action.TransportDeleteWorkloadGroupAction;
    private static RuleRoutingService ruleRoutingService;
            client,
 * Plugin class for WorkloadManagement
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.common.settings.ClusterSettings;
            new RestCreateWorkloadGroupAction(wlmClusterSettingValuesProvider),
        Environment environment,
                orderedAttributes.put(attribute, 1);
import org.opensearch.action.support.ActionFilter;
import org.opensearch.rule.storage.AttributeValueStoreFactory;
        rulePersistenceService = new IndexStoredRulePersistenceService(
            new ActionPlugin.ActionHandler<>(DeleteWorkloadGroupAction.INSTANCE, TransportDeleteWorkloadGroupAction.class),
        ClusterSettings clusterSettings,
            featureType.getOrderedAttributes()
    @Override
    }
        RuleEntityParser parser = new XContentRuleParser(featureType);
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {
        RefreshBasedSyncMechanism refreshMechanism = new RefreshBasedSyncMechanism(
    public static final String PRINCIPAL_ATTRIBUTE_NAME = "principal";
        ThreadPool threadPool,
            new ActionPlugin.ActionHandler<>(GetWorkloadGroupAction.INSTANCE, TransportGetWorkloadGroupAction.class),
    }
            new RuleEventClassifier(Collections.emptySet(), ruleProcessingService),
            new RestDeleteWorkloadGroupAction(wlmClusterSettingValuesProvider),
import org.opensearch.rule.storage.DefaultAttributeValueStore;
import java.util.Collections;
    /**
 * this file be licensed under the Apache-2.0 license or a
        ruleRoutingService = new WorkloadGroupRuleRoutingService(client, clusterService);
import org.opensearch.plugin.wlm.rest.RestCreateWorkloadGroupAction;
    private static RulePersistenceService rulePersistenceService;
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.rule.InMemoryRuleProcessingService;
        Settings settings,
package org.opensearch.plugin.wlm;
    public void setAttributes(List<Attribute> attributes) {
        );
        return () -> ruleRoutingService;
            clusterService,
            INDEX_NAME,
    @Override
            MAX_WLM_RULES_SETTING
    }
            parser,
     * Principal attribute name.
    public void loadExtensions(ExtensionLoader loader) {
     */
import org.opensearch.plugins.ActionPlugin;
        IndexScopedSettings indexScopedSettings,
        );
import org.opensearch.plugin.wlm.rest.RestUpdateWorkloadGroupAction;
import org.opensearch.rule.RulePersistenceService;
    ) {
import org.opensearch.repositories.RepositoriesService;
        );
            rulePersistenceService,
     */
        for (AttributeExtractorExtension ext : loader.loadExtensions(AttributeExtractorExtension.class)) {
import org.opensearch.plugins.Plugin;
    }
     * The name of the index where rules are stored.
     * Default constructor
import org.opensearch.indices.SystemIndexDescriptor;
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupAction;
    }
 */
import org.opensearch.plugin.wlm.action.GetWorkloadGroupAction;
        );
        return List.of(new WorkloadManagementPluginModule());
            featureType,
    public static final String INDEX_NAME = ".wlm_rules";
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
import org.opensearch.rule.storage.XContentRuleParser;
    private WlmClusterSettingValuesProvider wlmClusterSettingValuesProvider;
        return List.of(
     */
        RuleFrameworkExtension {
        NamedXContentRegistry xContentRegistry,
import java.util.List;
            DefaultAttributeValueStore::new
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.rest.RestController;
        return List.of(
import org.opensearch.common.settings.IndexScopedSettings;
 * SPDX-License-Identifier: Apache-2.0
        AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureValueValidator;
    @Override
 * The OpenSearch Contributors require contributions made to
        wlmClusterSettingValuesProvider = new WlmClusterSettingValuesProvider(
    /**
    }
import org.opensearch.plugins.SystemIndexPlugin;
    private final Map<Attribute, AttributeExtractorExtension> attributeExtractorExtensions = new HashMap<>();
    private static FeatureType featureType;
 */
            WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT,
import org.opensearch.common.inject.Module;
import org.opensearch.transport.TransportService;
import org.opensearch.env.Environment;
            featureType
    public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
            attributeExtractorExtensions,
    @Override
import org.opensearch.plugin.wlm.action.TransportCreateWorkloadGroupAction;
public class WorkloadManagementPlugin extends Plugin
    /**
    public Supplier<FeatureType> getFeatureTypeSupplier() {
        Client client,
        NodeEnvironment nodeEnvironment,
        );
        }
}
import org.opensearch.plugin.wlm.action.TransportGetWorkloadGroupAction;
     */
import org.opensearch.rule.autotagging.Attribute;
        return List.of(autoTaggingActionFilter);
    public static final int MAX_RULES_PER_PAGE = 50;
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            threadPool,
            clusterService.getSettings(),
    public Supplier<RuleRoutingService> getRuleRoutingServiceSupplier() {
        );
        ScriptService scriptService,
    public Collection<Module> createGuiceModules() {
import org.opensearch.transport.client.Client;
import org.opensearch.common.settings.SettingsFilter;
        ExtensiblePlugin,
            new ActionPlugin.ActionHandler<>(UpdateWorkloadGroupAction.INSTANCE, TransportUpdateWorkloadGroupAction.class)
        autoTaggingActionFilter = new AutoTaggingActionFilter(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    private AutoTaggingActionFilter autoTaggingActionFilter;
    @Override
import org.opensearch.threadpool.ThreadPool;
        );
import org.opensearch.plugins.ExtensiblePlugin;
        return Collections.emptyMap();
import org.opensearch.plugin.wlm.rule.WorkloadGroupRuleRoutingService;
    ) {
            MAX_RULES_PER_PAGE,
            clusterService.getSettings(),
        for (Attribute attribute : attributes) {
    public Supplier<RulePersistenceService> getRulePersistenceServiceSupplier() {
    }
        IndexNameExpressionResolver indexNameExpressionResolver,
            wlmClusterSettingValuesProvider,
        ClusterService clusterService,
        ActionPlugin,
import java.util.HashMap;
import org.opensearch.core.action.ActionResponse;
            new RestGetWorkloadGroupAction(),
            }
