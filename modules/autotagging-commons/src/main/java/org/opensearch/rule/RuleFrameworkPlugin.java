    public List<RestHandler> getRestHandlers(
            new ActionPlugin.ActionHandler<>(DeleteRuleAction.INSTANCE, TransportDeleteRuleAction.class),  
    @Override  
     * The name of the thread pool dedicated to rule execution.  
    public static final int RULE_THREAD_COUNT = 1;  
import org.opensearch.rule.rest.RestUpdateRuleAction;
    /**
        Settings settings,
import org.opensearch.threadpool.FixedExecutorBuilder;  
import org.opensearch.core.action.ActionResponse;  
    public static final String RULE_THREAD_POOL_NAME = "rule_serial_executor";
import org.opensearch.common.inject.Module;
 * compatible open source license.
import org.opensearch.rule.action.DeleteRuleAction;
 * this file be licensed under the Apache-2.0 license or a
}
 */  
import org.opensearch.rule.rest.RestDeleteRuleAction;  
        ruleFrameworkExtensions.addAll(loader.loadExtensions(RuleFrameworkExtension.class));
/**
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.common.settings.ClusterSettings;
    private void consumeFrameworkExtension(RuleFrameworkExtension ruleFrameworkExtension) {  
        // We are consuming the extensions at this place to ensure that the RulePersistenceService is initialised
        RestController restController,  
        ClusterSettings clusterSettings,
import org.opensearch.rule.action.CreateRuleAction;  
     */  
import java.util.ArrayList;
     */
    public void loadExtensions(ExtensionLoader loader) {  
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.rule.spi.RuleFrameworkExtension;
    public RuleFrameworkPlugin() {}  
    @Override  
import org.opensearch.common.settings.Settings;
    ) {  
        List<Attribute> attributes = attributesExtensions.stream().map(AttributesExtension::getAttribute).toList();  
     * The maximum number of tasks that can be queued in the rule execution thread pool.
    @Override  
import java.util.function.Supplier;
        IndexScopedSettings indexScopedSettings,
    }
        for (RuleFrameworkExtension ruleFrameworkExtension : ruleFrameworkExtensions) {
import org.opensearch.rule.action.TransportDeleteRuleAction;
import org.opensearch.plugins.ActionPlugin;
        Supplier<DiscoveryNodes> nodesInCluster
import org.opensearch.rest.RestController;
        rulePersistenceServiceRegistry.register(featureType, ruleFrameworkExtension.getRulePersistenceServiceSupplier().get());  
            b.bind(RuleRoutingServiceRegistry.class).toInstance(ruleRoutingServiceRegistry);
 * Plugins that define custom rule logic must implement {@link RuleFrameworkExtension}, which ensures  
 */
import org.opensearch.plugins.ExtensiblePlugin;
import java.util.List;
import org.opensearch.rule.autotagging.FeatureType;
        return List.of(
     */
import org.opensearch.rule.action.UpdateRuleAction;
    }
import java.util.Collection;  
    }
        Collection<AttributesExtension> attributesExtensions = loader.loadExtensions(AttributesExtension.class);
        }  
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
            new ActionPlugin.ActionHandler<>(UpdateRuleAction.INSTANCE, TransportUpdateRuleAction.class)
            new ActionPlugin.ActionHandler<>(CreateRuleAction.INSTANCE, TransportCreateRuleAction.class),
     * The number of threads allocated in the rule execution thread pool. This is set to 1 to ensure serial execution.
        return List.of(new FixedExecutorBuilder(settings, RULE_THREAD_POOL_NAME, RULE_THREAD_COUNT, RULE_QUEUE_SIZE, "rule-threadpool"));  
import org.opensearch.action.ActionRequest;
/*  
    }  
import org.opensearch.rule.action.TransportCreateRuleAction;  
 * This plugin provides the central APIs which can provide CRUD support to all consumers of Rule framework
        AutoTaggingRegistry.registerFeatureType(featureType);
 * their feature types and persistence services are automatically registered and available to the Rule Framework.
import org.opensearch.rule.autotagging.AutoTaggingRegistry;  
        return List.of(new RestGetRuleAction(), new RestDeleteRuleAction(), new RestCreateRuleAction(), new RestUpdateRuleAction());
public class RuleFrameworkPlugin extends Plugin implements ExtensiblePlugin, ActionPlugin {  
 * The OpenSearch Contributors require contributions made to  
        return List.of(b -> {
import org.opensearch.rule.autotagging.Attribute;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
import org.opensearch.rule.spi.AttributesExtension;  
import org.opensearch.rule.action.GetRuleAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            b.bind(RulePersistenceServiceRegistry.class).toInstance(rulePersistenceServiceRegistry);  
     * constructor for RuleFrameworkPlugin
        FeatureType featureType = ruleFrameworkExtension.getFeatureTypeSupplier().get();
        ruleRoutingServiceRegistry.register(featureType, ruleFrameworkExtension.getRuleRoutingServiceSupplier().get());
    /**  
     */
        );  
    private final RuleRoutingServiceRegistry ruleRoutingServiceRegistry = new RuleRoutingServiceRegistry();  
        SettingsFilter settingsFilter,  
        ruleFrameworkExtensions.forEach(this::consumeFrameworkExtension);  
import org.opensearch.plugins.Plugin;  
import org.opensearch.common.settings.IndexScopedSettings;  
    public Collection<Module> createGuiceModules() {
    @Override
import org.opensearch.rule.rest.RestGetRuleAction;
    private final List<RuleFrameworkExtension> ruleFrameworkExtensions = new ArrayList<>();
    /**
import org.opensearch.rule.rest.RestCreateRuleAction;
    public static final int RULE_QUEUE_SIZE = 100;
        });
import org.opensearch.rule.action.TransportUpdateRuleAction;  
import org.opensearch.cluster.node.DiscoveryNodes;  
 *
            new ActionPlugin.ActionHandler<>(GetRuleAction.INSTANCE, TransportGetRuleAction.class),
    @Override
import org.opensearch.threadpool.ExecutorBuilder;
    }  
    }
import org.opensearch.rest.RestHandler;
            ruleFrameworkExtension.setAttributes(attributes);
    /**  
    private final RulePersistenceServiceRegistry rulePersistenceServiceRegistry = new RulePersistenceServiceRegistry();
package org.opensearch.rule;
import org.opensearch.rule.action.TransportGetRuleAction;
 * SPDX-License-Identifier: Apache-2.0
