import org.opensearch.ResourceNotFoundException;
        assertTrue(
        public static final String INDEX_NAME = ".wlm_rules";
import org.opensearch.common.settings.Settings;
        public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(
                        metadata = Metadata.builder(currentState.metadata()).remove(currentGroups.get(id)).build();
            this.workloadGroup = new WorkloadGroup(in);
        Exception exception = assertThrows(Exception.class, () -> client().execute(DeleteRuleAction.INSTANCE, request).get());
        String ruleId1 = "wlm_auto_tag_rule_1";
            Settings settings,
    private WorkloadGroup createWorkloadGroup(String name, String id) {
            rulePersistenceService = new IndexStoredRulePersistenceService(
        String workloadGroupId = "wlm_group_empty";
                }
                threadPool,
                new ActionPlugin.ActionHandler<>(TestClusterUpdateTransportAction.ACTION, TestClusterUpdateTransportAction.class)
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;
         * Maximum number of rules returned in a single page during GET operations.
        String workloadGroupId = "wlm_auto_tag_scroll";
            int post1 = getCompletions(workloadGroupId1);
        @Override
            this.exception = e;
                @Override
            Supplier<DiscoveryNodes> nodesInCluster
            client().prepareSearch(testIndex).setQuery(QueryBuilders.matchAllQuery()).get();
        assertTrue("cluster-state update did not complete in time", completed);
            return () -> featureType;
        });
     * Test-only plugin implementation for Workload Management.
    public void clearWlmModeSetting() {
            try {
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        final private WorkloadGroup workloadGroup;
            ActionPlugin,
                clusterService.getSettings(),
                new RuleEventClassifier(Collections.emptySet(), ruleProcessingService),
            "Got: " + cause.getClass(),
        public Supplier<RulePersistenceService> getRulePersistenceServiceSupplier() {
            name,
        setWlmMode("enabled");
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    public void updateWorkloadGroupInClusterState(String method, WorkloadGroup workloadGroup) throws InterruptedException {
        }
import org.opensearch.cluster.metadata.WorkloadGroup;
        }
            return List.of(refreshMechanism, rulePersistenceService, featureType);
import org.opensearch.repositories.RepositoriesService;
        } catch (ResourceNotFoundException e) {
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(settings);
        @Override
        @Override
            return method;
                }
            return List.of(new SystemIndexDescriptor(INDEX_NAME, "System index used for storing workload_group rules"));
        Exception exception = assertThrows(
    }
            // Step 6: Get post-query completions
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
import org.opensearch.rule.autotagging.Attribute;
            // Step 4: Get pre-query completions
            ruleRoutingService = new WorkloadGroupRuleRoutingService(client, clusterService);
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;
                new ActionPlugin.ActionHandler<>(DeleteWorkloadGroupAction.INSTANCE, TransportDeleteWorkloadGroupAction.class),
                assertTrue("Expected ID not found in response: " + id, res.contains(id));
        }
                .setScroll(TimeValue.timeValueMinutes(1))
    private void setWlmMode(String mode) throws Exception {
        String indexName = "logs-nonexistent-index";
        WorkloadGroup workloadGroup = createWorkloadGroup("tagging_test_group", workloadGroupId);
 */
    }
    }
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
    }
    private int getCompletions(String groupId) throws Exception {
        DeleteRuleRequest request = new DeleteRuleRequest(fakeRuleId, featureType);
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureValueValidator;
        super(nodeSettings);
import org.opensearch.plugins.Plugin;
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            int completionsBefore = getCompletions(workloadGroupId);
import org.opensearch.action.support.ActionFilters;
        );
import org.opensearch.rule.RuleAttribute;
    private void createRule(String ruleId, String ruleName, String indexPattern, FeatureType featureType, String workloadGroupId)
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        @Override
            ThreadPool threadPool,
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        String workloadGroupId = "wlm_group_long_pattern";
            RulePersistenceServiceRegistry persistenceRegistry = internalCluster().getInstance(RulePersistenceServiceRegistry.class, node);
    @After
        );
        private Exception exception = null;
import org.opensearch.action.support.ActionFilter;
            ActionListener<TestResponse> listener
            TestClusterUpdateRequest request,
            AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(
            return List.of(
         */
            RefreshBasedSyncMechanism refreshMechanism = new RefreshBasedSyncMechanism(
import org.opensearch.common.inject.Module;
 * this file be licensed under the Apache-2.0 license or a
        @Override
            assertTrue("Expected completions for group 2 not to increase", post2 == pre2);
            IndexNameExpressionResolver indexNameExpressionResolver,
    public void testRuleWithNonexistentWorkloadGroupId() throws Exception {
import org.opensearch.rule.storage.XContentRuleParser;
    private int extractTotalCompletions(String responseBody, String workloadGroupId) {
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
        // Create a pattern longer than the max allowed (e.g., >100 characters)
            }
 * The OpenSearch Contributors require contributions made to
import java.util.Set;
        assertEquals(0, listener.getLatch().getCount());
        public TestClusterUpdateTransportAction(
    }
            TransportService transportService,
import java.util.Map;
            IllegalArgumentException.class,
        ) {
                .indices()
                TestClusterUpdateRequest::new,
        for (String node : internalCluster().getNodeNames()) {
        );
            String scrollId = initial.getScrollId();
        );
    public void testDeleteRuleForNonexistentId() throws Exception {
import org.opensearch.action.ActionRequestValidationException;
            );
    }
        public void setAttributes(List<Attribute> attributes) {
        }
         * Name of the system index used to store workload management rules.
        return total;
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        String index1 = "test_1";
import org.joda.time.Instant;
    }
                new RestGetWorkloadGroupAction(),
        String workloadGroupId2 = "wlm_auto_tag_group_2";
import org.opensearch.rule.storage.IndexBasedRuleQueryMapper;
            Environment environment,
            if (completionsIndex == -1) break;
    public void testTaggingTriggeredAfterRuleUpdate() throws Exception {
        indexDocument(index2);
import org.opensearch.wlm.WorkloadManagementSettings;
        setWlmMode("enabled");
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexPattern)),
            ThreadPool threadPool,
            super.writeTo(out);
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("group_1", workloadGroupId1));
import org.opensearch.common.inject.Inject;
        }
        static RulePersistenceService rulePersistenceService;
import org.opensearch.rest.RestController;
        assertAcked(
            throw new AssertionError("cluster-state update failed", listener.getException());
        @Inject
        implements
        assertBusy(() -> {
        Map<Attribute, Set<String>> attributes = Map.of(indexPatternAttr, Set.of(longPattern));
package org.opensearch.plugin.wlm;
                    String id = workloadGroup.get_id();
import org.opensearch.discovery.SeedHostsProvider;
            return List.of(autoTaggingActionFilter);
import org.opensearch.rule.action.DeleteRuleRequest;
import org.opensearch.plugins.ExtensiblePlugin;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }
            for (Attribute attribute : attributes) {
                MAX_RULES_PER_PAGE,
                        metadata = Metadata.builder(currentState.metadata()).put(workloadGroup).build();
            () -> createRule(ruleId, "test rule", indexName, featureType, "nonexistent_group")
                attributeExtractorExtensions.put(ext.getAttributeExtractor().getAttribute(), ext);
        }
        );
                clusterService,
        boolean completed = listener.getLatch().await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);
import org.opensearch.rule.action.UpdateRuleRequest;
            "updated rule matching nyc_taxis",
import java.util.ArrayList;
        }
        String ruleId = "empty_patterns_rule";
                Map.of(ResourceType.CPU, 0.1, ResourceType.MEMORY, 0.1)
            return () -> ruleRoutingService;
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
import org.opensearch.common.unit.TimeValue;
    public static class TestClusterUpdateTransportAction extends TransportClusterManagerNodeAction<TestClusterUpdateRequest, TestResponse> {
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
            .setSource(Map.of("field", "value"))
        static RuleRoutingService ruleRoutingService;
public class WlmAutoTaggingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        String workloadGroupId = "wlm_fake_delete";
import org.opensearch.script.ScriptService;
import org.opensearch.rule.RuleFrameworkPlugin;
            RestController restController,
        @Override
import org.opensearch.cluster.metadata.Metadata;
            ScriptService scriptService,
    }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        Settings.Builder settings = Settings.builder().put("wlm.workload_group.mode", mode);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            id,
        }
            () -> new Rule(ruleId, "desc", attributes, featureType, workloadGroupId, Instant.now().toString())
        client().execute(UpdateRuleAction.INSTANCE, updatedRule).get();
        @Override
            IndexScopedSettings indexScopedSettings,
            );
        indexDocument(indexName);
                assertFalse("Unexpected ID found in response: " + id, res.contains(id));
            SearchResponse initial = client().prepareSearch(indexName)
            exception.getMessage().contains("Each attribute can only have a maximum of 10 values.")
        Set<String> tooManyPatterns = IntStream.range(0, 11).mapToObj(i -> "pattern_" + i).collect(Collectors.toSet());
            exception.getMessage().contains("is invalid (empty or exceeds 100 characters)")
        String ruleId = "wlm_auto_tag_test_rule";
            assertEquals(1, response.getHits().getTotalHits().value());
        public List<Setting<?>> getSettings() {
            int colonIndex = responseBody.indexOf(":", completionsIndex);
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
        public TestWorkloadManagementPlugin() {}
        int preUpdateCompletions = getCompletions(workloadGroupId);
                routingRegistry.getRuleRoutingService(featureType);
            client().admin().indices().prepareRefresh(indexName).get();
                attributeValueStoreFactory,
                    String method = request.getMethod();
        WorkloadGroup workloadGroup = createWorkloadGroup("tagging_test_group", workloadGroupId);
import org.junit.After;
            () -> new Rule(ruleId, "desc", attributes, featureType, workloadGroupId, Instant.now().toString())
        private final Map<Attribute, AttributeExtractorExtension> attributeExtractorExtensions = new HashMap<>();
        String indexName = "logs-tagged-index";
        }
        String workloadGroupId = "wlm_auto_tag_single";
                routingRegistry.register(featureType, TestWorkloadManagementPlugin.ruleRoutingService);
        public void writeTo(StreamOutput out) throws IOException {
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
    }
import java.util.stream.Collectors;
        }
import java.util.HashSet;
                featureType
        }
        @Override
        String indexName = "logs-tagged-index";
        String ruleId = "wlm_auto_tag_test_rule";
        @Override
    }
        @Override
            WlmClusterSettingValuesProvider wlmClusterSettingValuesProvider = new WlmClusterSettingValuesProvider(
import org.opensearch.plugin.wlm.rest.RestGetWorkloadGroupAction;
     * This class is not intended for production use and should only be used in internal
        plugins.add(RuleFrameworkPlugin.class);
    public void testWildcardBasedAttributesAreTagged() throws Exception {
    }
        }
import org.opensearch.rule.RuleRoutingService;
        String res = response.toString();
            workloadGroupId,
import org.opensearch.rule.action.CreateRuleRequest;
        );
        String ruleId = "wlm_auto_tag_update_rule";
import org.opensearch.plugin.wlm.rest.RestDeleteWorkloadGroupAction;
        @Override
                    scrollId = nextScrollId;
import org.opensearch.common.network.NetworkService;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        Set<String> emptyPattern = Set.of("");
        // 11 patterns exceeds max allowed
            featureType,
        );
    public void testMultipleRulesDoNotInterfereWithEachOther() throws Exception {
        client().admin().cluster().updateSettings(request).get();
import org.opensearch.rule.spi.RuleFrameworkExtension;
    }
        }
            assertTrue("Expected completions to increase after rule update", postUpdateCompletions > preUpdateCompletions);
        Exception exception = assertThrows(
        public static final int MAX_RULES_PER_PAGE = 50;
     * the necessary components to support rule-based auto-tagging logic in integration tests.
     * cluster tests that validate WLM rule framework behavior end-to-end.
                }
            ClusterState clusterState,
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("long_pattern_group", workloadGroupId));
            return Collections.emptyMap();
import java.io.IOException;
            assertTrue("Expected completions for group 1 not to increase", post1 == pre1);
            out.writeString(method);
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            return List.of(new WorkloadManagementPluginModule());
        assertTrue(
import org.opensearch.env.NodeEnvironment;
            Instant.now().toString()
        }
        Attribute indexPatternAttr = RuleAttribute.INDEX_PATTERN;
            featureType = new WorkloadGroupFeatureType(new WorkloadGroupFeatureValueValidator(clusterService), new HashMap<>());
        assertTrue("Expected error message for nonexistent rule ID", exception.getMessage().contains("no such index"));
        public List<RestHandler> getRestHandlers(
        @Override
        );
        protected TestResponse read(StreamInput in) throws IOException {
        WorkloadGroup workloadGroup = createWorkloadGroup("scroll_tagging_group", workloadGroupId);
        @Override
        setWlmMode("enabled");
            }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }
import org.opensearch.rule.InMemoryRuleProcessingService;
        assertTrue(
        private static final Map<Attribute, Integer> orderedAttributes = new HashMap<>();
        }
        setWlmMode("enabled");
            return latch;
import org.opensearch.plugin.wlm.rest.RestCreateWorkloadGroupAction;
import java.util.function.Supplier;
            );
                @Override
                actionFilters,
        }
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
            this.workloadGroup = workloadGroup;
                wlmClusterSettingValuesProvider
        WlmStatsResponse response = getWlmStatsResponse(null, new String[] { groupId }, null);
    public void validateResponse(WlmStatsResponse response, String[] validIds, String[] invalidIds) {
import java.util.concurrent.ExecutionException;
/*
        FeatureType featureType;
        String ruleId = "long_pattern_rule";
        public CountDownLatch getLatch() {
        assertBusy(() -> {
            this.method = method;
                public void onFailure(String source, Exception e) {
        public TestClusterUpdateRequest(StreamInput in) throws IOException {
                transportService,
        String workloadGroupId = "wlm_group_too_many";
            featureType = TestWorkloadManagementPlugin.featureType;
        Throwable thrown = assertThrows(
            ),
        createRule(ruleId, "tagging flow test", "logs-tagged*", featureType, workloadGroupId);
import org.opensearch.action.DocWriteResponse;
        String groupKey = "\"" + workloadGroupId + "\"";
    }
        public TestClusterUpdateRequest(WorkloadGroup workloadGroup, String method) {
        @Override
 * compatible open source license.
import org.opensearch.common.settings.SettingsFilter;
                ruleProcessingService,
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
        // Empty index pattern string
import java.util.HashMap;
        static FeatureType featureType;
        );
import org.opensearch.core.action.ActionResponse;
        Attribute indexPatternAttr = RuleAttribute.INDEX_PATTERN;
            } catch (IllegalArgumentException ex) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.action.ActionRequest;
                    } else { // delete
         * Required for plugin instantiation during integration tests.
        }
     * It uses in-memory rule processing and index-backed rule persistence for isolated testing.
            int post2 = getCompletions(workloadGroupId2);
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("too_many_patterns_group", workloadGroupId));
import org.opensearch.cluster.node.DiscoveryNodes;
        setWlmMode("enabled");
                attributeExtractorExtensions,
            featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
                    listener.onResponse(new TestResponse());
        createRule(ruleId, "tagging flow test", indexName, featureType, workloadGroupId);
    }
    public static class ExceptionCatchingListener implements ActionListener<TestResponse> {
                new IndexBasedRuleQueryMapper()
import org.opensearch.plugin.wlm.action.TransportUpdateWorkloadGroupAction;
        ) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupAction;
            "Expected validation error about max length",
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
            );
        /**
                }
            IndexNameExpressionResolver indexNameExpressionResolver,
            for (String id : invalidIds) {
    }
        InterruptedException {
        });
        return Arrays.asList(
import java.util.concurrent.CountDownLatch;
            int completionsAfter = getCompletions(workloadGroupId);
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;
        );
        String indexName = "scroll_tagged_index";
import org.opensearch.core.common.io.stream.StreamInput;
            DiscoveryPlugin,
                WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT,
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
            ruleName,
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
import org.opensearch.plugins.ActionPlugin;
        @Override
                }
 *
            try {
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    /**
import org.opensearch.rule.RulePersistenceService;
            ClusterService clusterService
            NetworkService networkService
            }
        @Override
import java.util.stream.IntStream;
        setWlmMode("enabled");
        try {
        }
import org.opensearch.plugin.wlm.rule.WorkloadGroupRuleRoutingService;
            this.latch = new CountDownLatch(1);
        protected ClusterBlockException checkBlock(TestClusterUpdateRequest request, ClusterState state) {
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
        public Exception getException() {
import org.opensearch.cluster.service.ClusterService;
            int completionsAfter = getCompletions(workloadGroupId);
    public static Collection<Object[]> parameters() {
        public Collection<Module> createGuiceModules() {
        // Step 2: Create auto-tagging rule
            super(in);
    }
            NamedWriteableRegistry namedWriteableRegistry,
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
        assertEquals("Expected no tagging before rule update", 0, preUpdateCompletions);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            workloadGroupId,
        Map<Attribute, Set<String>> attributes = Map.of(indexPatternAttr, emptyPattern);
            );
import java.util.Collections;
        assertEquals(DocWriteResponse.Result.CREATED, response.getResult());
        String ruleId = "wlm_auto_tag_scroll_rule";
        String ruleId = "too_many_patterns_rule";
            client().admin().indices().prepareRefresh(indexName).get();
            Client client,
            return List.of(
                DefaultAttributeValueStore::new
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugin.wlm.action.TransportCreateWorkloadGroupAction;
            "Expected validation message for nonexistent group",
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexName)),
    }
            int completionsIndex = responseBody.indexOf("\"total_completions\"", groupStart);
                SearchResponse scrollResp = client().prepareSearchScroll(scrollId).setScroll(TimeValue.timeValueMinutes(1)).get();
        }
        ) {
import org.opensearch.action.search.SearchResponse;
        validateResponse(response, new String[] { groupId }, null);
            ClusterSettings clusterSettings,
    }
        }
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::test_cluster_update_action", TestResponse::new);
        String ruleId = "nonexistent_group_rule";
                    if (method.equals(PUT)) { // create
                int afterInitialSearch = getCompletions(workloadGroupId);
                    orderedAttributes.put(attribute, 1);
            index = commaIndex;
        /**
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
                ACTION.name(),
                if (nextScrollId != null && !nextScrollId.isEmpty()) {
            Supplier<RepositoriesService> repositoriesServiceSupplier
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            client().admin()
        createRule(ruleId, "initial non-matching rule", "random", featureType, workloadGroupId);
import org.opensearch.plugin.wlm.rest.RestUpdateWorkloadGroupAction;
        IndexResponse response = client().prepareIndex(indexName)
import org.opensearch.cluster.block.ClusterBlockException;
    // Helper functions
        return client().execute(WlmStatsAction.INSTANCE, request).get();
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
    public static class TestResponse extends ActionResponse {
            String numberStr = responseBody.substring(colonIndex + 1, commaIndex).trim();
     * This plugin registers a {@link FeatureType} for {@code workload_group}, along with
                String nextScrollId = scrollResp.getScrollId();
            new MutableWorkloadGroupFragment(
            Throwable.class,
            }
        String indexName = "update_index";
                .setQuery(QueryBuilders.matchAllQuery())
    final static String PUT = "PUT";
import org.opensearch.cluster.ClusterState;
                if (attribute.getName().equals(PRINCIPAL_ATTRIBUTE_NAME)) {
            RuleFrameworkExtension {
        final private String method;
        Map<Attribute, Set<String>> attributes = Map.of(indexPatternAttr, tooManyPatterns);
        public void writeTo(StreamOutput out) throws IOException {}
        // Step 0: Enable WLM mode
                    }
            int pre2 = getCompletions(workloadGroupId2);
                assertTrue("Expected completions to increase after scroll request as well", afterScroll > afterInitialSearch);
                assertTrue("Expected completions to increase after initial search with scroll", afterInitialSearch > completionsBefore);
                indexNameExpressionResolver
        @Override
                featureType,
        /**
            return List.of(
            this.method = in.readString();
        @Override
        });
        public Collection<Object> createComponents(
        setWlmMode("enabled");
                clearScroll(scrollId);
        Settings.Builder builder = Settings.builder().putNull(WorkloadManagementSettings.WLM_MODE_SETTING.getKey());
import org.opensearch.rule.action.UpdateRuleAction;
                new ActionPlugin.ActionHandler<>(CreateWorkloadGroupAction.INSTANCE, TransportCreateWorkloadGroupAction.class),
import org.opensearch.action.index.IndexResponse;
                IndexStoredRulePersistenceService.MAX_WLM_RULES_SETTING
        indexDocument(indexName);
            clusterService.submitStateUpdateTask("query-group-persistence-service", new ClusterStateUpdateTask() {
import org.opensearch.rule.RuleEntityParser;
    }
                featureType.getOrderedAttributes()
            .get();
    public WlmAutoTaggingIT(Settings nodeSettings) {
        indexDocument(indexName);
        assertBusy(() -> {
            ExtensiblePlugin,
                    Map<String, WorkloadGroup> currentGroups = currentState.metadata().workloadGroups();
            int commaIndex = responseBody.indexOf(",", colonIndex);
import org.opensearch.plugins.DiscoveryPlugin;
import org.opensearch.action.support.WriteRequest;
        int index = 0;
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
            autoTaggingActionFilter = new AutoTaggingActionFilter(
        // Step 3: Index document
                featureType,
import org.opensearch.plugin.wlm.action.GetWorkloadGroupAction;
        int total = 0;
        String testIndex = "test_*";
            featureType
            );
    @ParametersFactory
import org.opensearch.transport.client.Client;
                int afterScroll = getCompletions(workloadGroupId);
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("fake_delete_group", workloadGroupId));
        protected void clusterManagerOperation(
        }
        String fakeRuleId = "nonexistent_rule_id";
        plugins.add(TestWorkloadManagementPlugin.class);
    public void testCreateRuleWithLongIndexPatternValue() throws Exception {
        ) {
import java.util.Arrays;
        assertTrue(
        createRule(ruleId, "scroll tagging rule", indexName, featureType, workloadGroupId);
        private final CountDownLatch latch;
            workloadGroup.writeTo(out);
        indexDocument(index1);
import org.opensearch.rule.autotagging.Rule;
                threadPool,
    }
        public WorkloadGroup getWorkloadGroup() {
    public static class TestClusterUpdateRequest extends ClusterManagerNodeRequest<TestClusterUpdateRequest> {
import org.opensearch.rule.storage.DefaultAttributeValueStore;
    public WlmStatsResponse getWlmStatsResponse(String[] nodesId, String[] queryGroupIds, Boolean breach) throws ExecutionException,
    private static final TimeValue TIMEOUT = new TimeValue(30, TimeUnit.SECONDS);
        private AutoTaggingActionFilter autoTaggingActionFilter;
         */
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
                    listener.onFailure(e);
            InMemoryRuleProcessingService ruleProcessingService = new InMemoryRuleProcessingService(
            int completionsBefore = getCompletions(workloadGroupId);
            (cause instanceof org.opensearch.action.ActionRequestValidationException) || (cause instanceof IllegalArgumentException)
        public ExceptionCatchingListener() {
        }
import org.opensearch.index.query.QueryBuilders;
        public ActionRequestValidationException validate() {
        return new WorkloadGroup(
        Exception exception = assertThrows(
                new ActionPlugin.ActionHandler<>(GetWorkloadGroupAction.INSTANCE, TransportGetWorkloadGroupAction.class),
}
                new RestUpdateWorkloadGroupAction(settingProvider)
        );
            .setId("1")
                INDEX_NAME,
        protected String executor() {
                threadPool,
import org.opensearch.plugin.wlm.action.TransportGetWorkloadGroupAction;
        }
            SettingsFilter settingsFilter,
        public Supplier<RuleRoutingService> getRuleRoutingServiceSupplier() {
        if (listener.getException() != null) {
        String workloadGroupId1 = "wlm_auto_tag_group_1";
        // Step 1: Create workload group
            ClusterService clusterService,
        @Override
        }
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("group_2", workloadGroupId2));
            total += Integer.parseInt(numberStr);
            for (AttributeExtractorExtension ext : loader.loadExtensions(AttributeExtractorExtension.class)) {
        assertBusy(() -> {
import org.opensearch.cluster.block.ClusterBlockLevel;
        });
            return exception;
        public String getMethod() {
        public List<ActionFilter> getActionFilters() {
        @Override
                RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING,
        );
                persistenceRegistry.register(featureType, TestWorkloadManagementPlugin.rulePersistenceService);
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(builder).get());
        }
        }
                clusterService.getClusterSettings()
            for (String id : validIds) {
import org.opensearch.common.settings.Setting;
        }
            );
            // Step 5: Execute query
import org.opensearch.env.Environment;
import java.util.List;
import org.opensearch.rule.action.CreateRuleAction;
            super(
        setWlmMode("enabled");
            assertTrue("Expected completions to increase", completionsAfter > completionsBefore);
        return extractTotalCompletions(response.toString(), groupId);
        }
import org.opensearch.indices.SystemIndexDescriptor;
        throws Exception {
                public ClusterState execute(ClusterState currentState) {
                    Metadata metadata;
    @Override
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
                clusterService.getSettings(),
            }
                .setSize(1)
            assertTrue("Expected completions to increase", completionsAfter > completionsBefore);
                clusterService,
                    WorkloadGroup workloadGroup = request.getWorkloadGroup();
        public Supplier<FeatureType> getFeatureTypeSupplier() {
            SystemIndexPlugin,
            NodeEnvironment nodeEnvironment,
        }
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
import org.opensearch.core.action.ActionListener;
                .prepareCreate(indexName)
            NamedXContentRegistry xContentRegistry,
        indexDocument(indexName);
            return () -> rulePersistenceService;
            IllegalArgumentException.class,
            int completionsBefore = getCompletions(workloadGroupId);
    private void indexDocument(String indexName) {
import org.opensearch.core.common.io.stream.StreamOutput;
                new RestCreateWorkloadGroupAction(settingProvider),
            () -> new Rule(ruleId, "desc", attributes, featureType, workloadGroupId, Instant.now().toString())
            "Expected validation error about empty index pattern",
            ActionFilters actionFilters,
            latch.countDown();
        }
        assertTrue(
        createRule(ruleId1, "rule for test_1", index1, featureType, workloadGroupId1);
        if (validIds != null) {
        assertBusy(() -> {
            ruleId,
            );
            TransportService transportService,
            int pre1 = getCompletions(workloadGroupId1);
            ResourceWatcherService resourceWatcherService,
            IllegalArgumentException.class,
import org.opensearch.rule.RuleRoutingServiceRegistry;
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;
            "Expected validation error about too many values",
        client().execute(TestClusterUpdateTransportAction.ACTION, new TestClusterUpdateRequest(workloadGroup, method), listener);
        @Override
import org.opensearch.rule.autotagging.FeatureType;
    }
        while ((index = responseBody.indexOf(groupKey, index)) != -1) {
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            WlmClusterSettingValuesProvider settingProvider = new WlmClusterSettingValuesProvider(settings, clusterSettings);
            RuleRoutingServiceRegistry routingRegistry = internalCluster().getInstance(RuleRoutingServiceRegistry.class, node);
        // wait for transport action to complete
                .get();
                new ActionPlugin.ActionHandler<>(UpdateWorkloadGroupAction.INSTANCE, TransportUpdateWorkloadGroupAction.class),
         * Default constructor.
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        String longPattern = "x".repeat(101);
            int postUpdateCompletions = getCompletions(workloadGroupId);
            );
import org.opensearch.wlm.ResourceType;
import org.opensearch.rest.RestHandler;
            return new TestResponse(in);
        setWlmMode("enabled");
    }
        }
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        setWlmMode("enabled");
            IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
        String ruleId2 = "wlm_auto_tag_rule_2";
                    return ClusterState.builder(currentState).metadata(metadata).build();
            });
import org.opensearch.transport.TransportService;
    public static class TestWorkloadManagementPlugin extends Plugin
        public void onFailure(Exception e) {
            String.valueOf(cause.getMessage()).contains("nonexistent_group is not a valid workload group id")
        UpdateRuleRequest updatedRule = new UpdateRuleRequest(
    }
import java.util.concurrent.TimeUnit;
        Attribute indexPatternAttr = RuleAttribute.INDEX_PATTERN;
            return null;
    }
    }
        String workloadGroupId = "wlm_auto_tag_update";
            return workloadGroup;
        ) {
        client().execute(CreateRuleAction.INSTANCE, new CreateRuleRequest(rule)).get();
        Rule rule = new Rule(
        public TestResponse(StreamInput in) {}
            assertNotNull("scrollId must not be null", scrollId);
        WlmStatsRequest request = new WlmStatsRequest(nodesId, new HashSet<>(Arrays.asList(queryGroupIds)), breach);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                parser,
                new RestDeleteWorkloadGroupAction(settingProvider),
    public void testScrollRequestsAreAlsoTagged() throws Exception {
        if (invalidIds != null) {
    public void testCreateRuleWithEmptyIndexPatterns() throws Exception {
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        }
import org.opensearch.rule.action.DeleteRuleAction;
        );
        }
            ((WorkloadGroupRuleRoutingService) ruleRoutingService).setTransportService(transportService);
import org.opensearch.action.ActionType;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            return SAME;
            Instant.now().getMillis()
            int groupStart = responseBody.indexOf("{", index);
            exception.getMessage().contains("is invalid (empty or exceeds 100 characters)")
        public void onResponse(TestResponse r) {
import org.opensearch.common.settings.IndexScopedSettings;
         */
                wlmClusterSettingValuesProvider,
        Throwable cause = (thrown instanceof ExecutionException && thrown.getCause() != null) ? thrown.getCause() : thrown;
            );
        });
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;
import org.opensearch.common.settings.ClusterSettings;
        String index2 = "test_2";
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        createRule(ruleId2, "rule for test_2", index2, featureType, workloadGroupId2);
import org.junit.Before;
import org.opensearch.cluster.ClusterStateUpdateTask;
                @Override
import org.opensearch.rule.RulePersistenceServiceRegistry;
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("update_test_group", workloadGroupId));
            } finally {
    }
        return plugins;
import org.opensearch.plugins.SystemIndexPlugin;
            AutoTaggingRegistry.registerFeatureType(featureType);
import org.opensearch.plugin.wlm.action.TransportDeleteWorkloadGroupAction;
            ruleId,
import org.opensearch.watcher.ResourceWatcherService;
    }
    public void registerFeatureTypeIfMissingOnAllNodes() {
            }
                rulePersistenceService,
        public TestResponse() {}
import org.opensearch.threadpool.ThreadPool;
    public void testCreateRuleWithTooManyIndexPatterns() throws Exception {
import java.util.Collection;
     */
            latch.countDown();
        );
import org.opensearch.rule.storage.AttributeValueStoreFactory;
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupAction;
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("empty_patterns_group", workloadGroupId));
    public void testExactIndexMatchTriggersTagging() throws Exception {
    @Before
            RuleEntityParser parser = new XContentRuleParser(featureType);
        String workloadGroupId = "wlm_auto_tag_single";
                client,
