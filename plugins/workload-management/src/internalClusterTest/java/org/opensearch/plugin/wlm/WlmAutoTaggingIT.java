        @Override  
            ruleId,
        );
            );
            String scrollId = initial.getScrollId();
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
            NamedWriteableRegistry namedWriteableRegistry,  
import org.opensearch.cluster.service.ClusterService;  
        ) {  
            () -> new Rule(ruleId, "desc", attributes, featureType, workloadGroupId, Instant.now().toString())  
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            new MutableWorkloadGroupFragment(
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;  
            workloadGroupId,
        public static final ActionType<TestResponse> ACTION = new ActionType<>("internal::test_cluster_update_action", TestResponse::new);  
            } catch (IllegalArgumentException ex) {
        public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(  
        private Exception exception = null;
            "Expected validation error about max length",  
import org.opensearch.rule.autotagging.AutoTaggingRegistry;  
        String workloadGroupId = "wlm_group_long_pattern";
import org.opensearch.core.action.ActionResponse;
                }
        public void setAttributes(List<Attribute> attributes) {  
    public void updateWorkloadGroupInClusterState(String method, WorkloadGroup workloadGroup) throws InterruptedException {
        plugins.add(RuleFrameworkPlugin.class);
        }
        }
            ThreadPool threadPool,
                new ActionPlugin.ActionHandler<>(TestClusterUpdateTransportAction.ACTION, TestClusterUpdateTransportAction.class)
        }
            int postUpdateCompletions = getCompletions(workloadGroupId);
        @Override  
import java.util.Set;
        String workloadGroupId = "wlm_group_empty";
import org.opensearch.rule.RuleAttribute;
        if (validIds != null) {
            IndexNameExpressionResolver indexNameExpressionResolver,
            exception.getMessage().contains("is invalid (empty or exceeds 100 characters)")
    }  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(settings);  
        String ruleId = "nonexistent_group_rule";
     * It uses in-memory rule processing and index-backed rule persistence for isolated testing.
    public static class ExceptionCatchingListener implements ActionListener<TestResponse> {
        return client().execute(WlmStatsAction.INSTANCE, request).get();
        }  
    // Helper functions
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                transportService,  
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;  
            AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(  
    }  
import org.opensearch.rule.RulePersistenceServiceRegistry;
        for (String node : internalCluster().getNodeNames()) {
        public static final int MAX_RULES_PER_PAGE = 50;  
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("empty_patterns_group", workloadGroupId));
        ExceptionCatchingListener listener = new ExceptionCatchingListener();
            assertEquals(1, response.getHits().getTotalHits().value());  
    public void validateResponse(WlmStatsResponse response, String[] validIds, String[] invalidIds) {
         * Name of the system index used to store workload management rules.  
            Supplier<RepositoriesService> repositoriesServiceSupplier
                .prepareCreate(indexName)
        String workloadGroupId = "wlm_auto_tag_single";
        String fakeRuleId = "nonexistent_rule_id";  
                if (attribute.getName().equals(PRINCIPAL_ATTRIBUTE_NAME)) {
        assertBusy(() -> {  
            return List.of(
            return () -> featureType;
     * This plugin registers a {@link FeatureType} for {@code workload_group}, along with
        public TestWorkloadManagementPlugin() {}  
        FeatureType featureType;
                .setScroll(TimeValue.timeValueMinutes(1))
        String workloadGroupId2 = "wlm_auto_tag_group_2";
import org.opensearch.plugin.wlm.action.TransportCreateWorkloadGroupAction;  
                wlmClusterSettingValuesProvider,
        Exception exception = assertThrows(Exception.class, () -> client().execute(DeleteRuleAction.INSTANCE, request).get());
            assertNotNull("scrollId must not be null", scrollId);  
        public void onResponse(TestResponse r) {
    public static Collection<Object[]> parameters() {  
                        metadata = Metadata.builder(currentState.metadata()).remove(currentGroups.get(id)).build();
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
                assertTrue("Expected ID not found in response: " + id, res.contains(id));  
            NamedXContentRegistry xContentRegistry,  
        indexDocument(indexName);
        );
        DeleteRuleRequest request = new DeleteRuleRequest(fakeRuleId, featureType);
                attributeValueStoreFactory,
            IllegalArgumentException.class,
    public void testTaggingTriggeredAfterRuleUpdate() throws Exception {  
    private void createRule(String ruleId, String ruleName, String indexPattern, FeatureType featureType, String workloadGroupId)  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);  
                rulePersistenceService,
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;  
package org.opensearch.plugin.wlm;
        }  
        @Override
            Instant.now().getMillis()  
        protected TestResponse read(StreamInput in) throws IOException {  
            // Step 5: Execute query
        String ruleId = "wlm_auto_tag_test_rule";
            RefreshBasedSyncMechanism refreshMechanism = new RefreshBasedSyncMechanism(
        indexDocument(index2);
                    scrollId = nextScrollId;  
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.rule.RuleEntityParser;
        String testIndex = "test_*";  
            assertTrue("Expected completions to increase", completionsAfter > completionsBefore);
import org.opensearch.plugin.wlm.rest.RestDeleteWorkloadGroupAction;  
import org.opensearch.core.action.ActionListener;
            ScriptService scriptService,
                public void onFailure(String source, Exception e) {
        public List<Setting<?>> getSettings() {
        setWlmMode("enabled");  
        /**  
import org.opensearch.threadpool.ThreadPool;
import java.util.function.Supplier;
import org.opensearch.action.index.IndexResponse;  
import org.opensearch.index.query.QueryBuilders;
    }
    public void testCreateRuleWithEmptyIndexPatterns() throws Exception {  
                threadPool,  
        assertAcked(
            clusterService.submitStateUpdateTask("query-group-persistence-service", new ClusterStateUpdateTask() {  
    final static String PUT = "PUT";
            assertTrue("Expected completions for group 1 not to increase", post1 == pre1);
            );
            () -> new Rule(ruleId, "desc", attributes, featureType, workloadGroupId, Instant.now().toString())
                    Map<String, WorkloadGroup> currentGroups = currentState.metadata().workloadGroups();  
import org.junit.Before;
    }  
    }  
    private void setWlmMode(String mode) throws Exception {
        int index = 0;
            ActionFilters actionFilters,  
        assertTrue(
            name,  
import org.opensearch.plugin.wlm.action.TransportUpdateWorkloadGroupAction;  
        public TestClusterUpdateRequest(StreamInput in) throws IOException {  
        assertBusy(() -> {
        indexDocument(indexName);
            });
import java.util.Arrays;  
            TestClusterUpdateRequest request,
    public void registerFeatureTypeIfMissingOnAllNodes() {
                clusterService,
        public ActionRequestValidationException validate() {
import org.opensearch.rule.action.DeleteRuleRequest;
import org.opensearch.common.settings.IndexScopedSettings;
        @Inject
        }
    }
    private static final TimeValue TIMEOUT = new TimeValue(30, TimeUnit.SECONDS);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))  
    @Before  
            Throwable.class,  
                attributeExtractorExtensions,
import org.opensearch.action.ActionRequest;
        Throwable thrown = assertThrows(
         */
import org.opensearch.plugin.wlm.action.TransportDeleteWorkloadGroupAction;
        }  
            if (completionsIndex == -1) break;  
        );
import org.opensearch.rule.storage.IndexBasedRuleQueryMapper;
        // 11 patterns exceeds max allowed
    }
                new RestCreateWorkloadGroupAction(settingProvider),
                featureType.getOrderedAttributes()  
            "Expected validation message for nonexistent group",
        return new WorkloadGroup(
                        metadata = Metadata.builder(currentState.metadata()).put(workloadGroup).build();  
        Exception exception = assertThrows(  
        createRule(ruleId, "tagging flow test", indexName, featureType, workloadGroupId);
            return () -> rulePersistenceService;
            );  
            return Collections.emptyMap();
            SystemIndexPlugin,  
            try {
import org.opensearch.plugin.wlm.rest.RestGetWorkloadGroupAction;
        int total = 0;
         */
        );
    public void testCreateRuleWithLongIndexPatternValue() throws Exception {
            );  
            }
            for (String id : validIds) {
        );
            );  
        // wait for transport action to complete
 */  
    public static class TestClusterUpdateTransportAction extends TransportClusterManagerNodeAction<TestClusterUpdateRequest, TestResponse> {
                }
        String groupKey = "\"" + workloadGroupId + "\"";  
        public void writeTo(StreamOutput out) throws IOException {  
            for (Attribute attribute : attributes) {
import org.opensearch.rule.autotagging.Attribute;
        );
        @Override
import java.util.stream.IntStream;
        String ruleId2 = "wlm_auto_tag_rule_2";
        String ruleId = "wlm_auto_tag_scroll_rule";
            id,
        String indexName = "scroll_tagged_index";  
        static FeatureType featureType;
import org.opensearch.rule.spi.RuleFrameworkExtension;
        public Collection<Object> createComponents(  
            featureType  
        assertBusy(() -> {  
import org.opensearch.repositories.RepositoriesService;  
        private final CountDownLatch latch;  
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupAction;
            super.writeTo(out);
                new IndexBasedRuleQueryMapper()
                if (nextScrollId != null && !nextScrollId.isEmpty()) {
    }
    @ParametersFactory
        assertEquals(DocWriteResponse.Result.CREATED, response.getResult());
import java.util.concurrent.CountDownLatch;
        }
import org.opensearch.rule.action.UpdateRuleAction;  
            WlmClusterSettingValuesProvider settingProvider = new WlmClusterSettingValuesProvider(settings, clusterSettings);  
            Settings settings,
        assertTrue(  
            return List.of(new WorkloadManagementPluginModule());
import org.opensearch.rule.action.DeleteRuleAction;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
            client().admin().indices().prepareRefresh(indexName).get();  
        }
}
                String nextScrollId = scrollResp.getScrollId();
            WlmClusterSettingValuesProvider wlmClusterSettingValuesProvider = new WlmClusterSettingValuesProvider(  
        plugins.add(TestWorkloadManagementPlugin.class);
                    Metadata metadata;
        assertTrue("cluster-state update did not complete in time", completed);  
        boolean completed = listener.getLatch().await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            .setSource(Map.of("field", "value"))
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexPattern)),
    }
        return plugins;  
                persistenceRegistry.register(featureType, TestWorkloadManagementPlugin.rulePersistenceService);
            return method;
            );  
    public void clearWlmModeSetting() {  
    @Override
                ACTION.name(),
        return Arrays.asList(
            total += Integer.parseInt(numberStr);
            ClusterSettings clusterSettings,  
import java.util.List;
        assertTrue("Expected error message for nonexistent rule ID", exception.getMessage().contains("no such index"));  
            this.exception = e;
        public String getMethod() {
                }
            int pre1 = getCompletions(workloadGroupId1);
        setWlmMode("enabled");
            }
    }
            AutoTaggingRegistry.registerFeatureType(featureType);
                .get();
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,  
            TransportService transportService,
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
     * cluster tests that validate WLM rule framework behavior end-to-end.
        indexDocument(indexName);
        createRule(ruleId2, "rule for test_2", index2, featureType, workloadGroupId2);
                clearScroll(scrollId);  
            return List.of(new SystemIndexDescriptor(INDEX_NAME, "System index used for storing workload_group rules"));
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
            );  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
                wlmClusterSettingValuesProvider
            int post2 = getCompletions(workloadGroupId2);
import org.opensearch.common.inject.Inject;
            IndexScopedSettings indexScopedSettings,
            return () -> ruleRoutingService;  
    }  
            "Got: " + cause.getClass(),
        }
        @Override
                new ActionPlugin.ActionHandler<>(GetWorkloadGroupAction.INSTANCE, TransportGetWorkloadGroupAction.class),
        Map<Attribute, Set<String>> attributes = Map.of(indexPatternAttr, Set.of(longPattern));  
    public static class TestClusterUpdateRequest extends ClusterManagerNodeRequest<TestClusterUpdateRequest> {  
    }
                INDEX_NAME,  
        implements
            Client client,
        UpdateRuleRequest updatedRule = new UpdateRuleRequest(
                    listener.onResponse(new TestResponse());
    public void testRuleWithNonexistentWorkloadGroupId() throws Exception {
            int colonIndex = responseBody.indexOf(":", completionsIndex);
            autoTaggingActionFilter = new AutoTaggingActionFilter(
import java.util.Map;  
    }
import org.opensearch.action.ActionType;  
            .setId("1")  
import org.opensearch.transport.client.Client;
        assertBusy(() -> {  
            assertTrue("Expected completions to increase after rule update", postUpdateCompletions > preUpdateCompletions);  
            for (String id : invalidIds) {
    @After
        public Supplier<RulePersistenceService> getRulePersistenceServiceSupplier() {  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            assertTrue("Expected completions for group 2 not to increase", post2 == pre2);
        createRule(ruleId, "tagging flow test", "logs-tagged*", featureType, workloadGroupId);
        WlmStatsResponse response = getWlmStatsResponse(null, new String[] { groupId }, null);  
        return extractTotalCompletions(response.toString(), groupId);
            SettingsFilter settingsFilter,
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexName)),
        client().execute(TestClusterUpdateTransportAction.ACTION, new TestClusterUpdateRequest(workloadGroup, method), listener);  
        // Step 0: Enable WLM mode
                new ActionPlugin.ActionHandler<>(DeleteWorkloadGroupAction.INSTANCE, TransportDeleteWorkloadGroupAction.class),  
        String workloadGroupId = "wlm_auto_tag_update";
    private int getCompletions(String groupId) throws Exception {
            "Expected validation error about too many values",
                    if (method.equals(PUT)) { // create
                assertFalse("Unexpected ID found in response: " + id, res.contains(id));
        }  
                RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING,
        });  
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("long_pattern_group", workloadGroupId));
            super(
import org.opensearch.plugin.wlm.rest.RestCreateWorkloadGroupAction;
        public TestClusterUpdateRequest(WorkloadGroup workloadGroup, String method) {
                    WorkloadGroup workloadGroup = request.getWorkloadGroup();
    }
            );  
            "updated rule matching nyc_taxis",  
import org.opensearch.wlm.ResourceType;
import org.opensearch.rest.RestController;
            int completionsBefore = getCompletions(workloadGroupId);
            int completionsAfter = getCompletions(workloadGroupId);
        client().execute(CreateRuleAction.INSTANCE, new CreateRuleRequest(rule)).get();
                clusterService.getClusterSettings()
    public void testWildcardBasedAttributesAreTagged() throws Exception {  
import org.opensearch.cluster.node.DiscoveryNodes;
 * this file be licensed under the Apache-2.0 license or a
        }
            Instant.now().toString()
                threadPool,
        WorkloadGroup workloadGroup = createWorkloadGroup("scroll_tagging_group", workloadGroupId);
    public void testExactIndexMatchTriggersTagging() throws Exception {
import org.opensearch.env.NodeEnvironment;  
                clusterService.getSettings(),  
        public WorkloadGroup getWorkloadGroup() {  
        public CountDownLatch getLatch() {  
            try {
            int completionsBefore = getCompletions(workloadGroupId);
        Throwable cause = (thrown instanceof ExecutionException && thrown.getCause() != null) ? thrown.getCause() : thrown;
import org.opensearch.rule.action.UpdateRuleRequest;
import org.opensearch.cluster.ClusterState;
                featureType,
        @Override
            RulePersistenceServiceRegistry persistenceRegistry = internalCluster().getInstance(RulePersistenceServiceRegistry.class, node);
import java.util.HashSet;
                MAX_RULES_PER_PAGE,  
        }  
import java.util.Collection;
            ((WorkloadGroupRuleRoutingService) ruleRoutingService).setTransportService(transportService);
        ) {  
import org.opensearch.action.support.WriteRequest;
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("group_2", workloadGroupId2));  
        );  
                }  
            IllegalArgumentException.class,
    }  
        public TestResponse(StreamInput in) {}  
        );
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("group_1", workloadGroupId1));
        indexDocument(index1);
 *
            this.latch = new CountDownLatch(1);
            () -> new Rule(ruleId, "desc", attributes, featureType, workloadGroupId, Instant.now().toString())  
        public void onFailure(Exception e) {
            latch.countDown();  
        @Override  
                .setSize(1)  
                clusterService.getSettings(),
            ThreadPool threadPool,  
        protected void clusterManagerOperation(
import org.opensearch.rule.RuleFrameworkPlugin;  
import org.opensearch.cluster.block.ClusterBlockException;  
import java.io.IOException;
import org.opensearch.cluster.metadata.WorkloadGroup;
import org.opensearch.plugin.wlm.action.GetWorkloadGroupAction;
            // Step 6: Get post-query completions  
                    String method = request.getMethod();  
        WlmStatsRequest request = new WlmStatsRequest(nodesId, new HashSet<>(Arrays.asList(queryGroupIds)), breach);
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                @Override  
            // Step 4: Get pre-query completions
        createRule(ruleId, "initial non-matching rule", "random", featureType, workloadGroupId);
import java.util.concurrent.ExecutionException;  
            client().admin()  
            RestController restController,
        createRule(ruleId, "scroll tagging rule", indexName, featureType, workloadGroupId);
import org.opensearch.ResourceNotFoundException;  
import org.opensearch.common.settings.Setting;  
                    orderedAttributes.put(attribute, 1);  
                public ClusterState execute(ClusterState currentState) {
import org.opensearch.plugins.SystemIndexPlugin;
    }
            NodeEnvironment nodeEnvironment,
        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                featureType  
        WorkloadGroup workloadGroup = createWorkloadGroup("tagging_test_group", workloadGroupId);
            for (AttributeExtractorExtension ext : loader.loadExtensions(AttributeExtractorExtension.class)) {  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        });  
            ClusterService clusterService
        @Override  
        public Supplier<FeatureType> getFeatureTypeSupplier() {
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;  
    }
import org.opensearch.rule.RulePersistenceService;
import java.util.stream.Collectors;  
        @Override
                assertTrue("Expected completions to increase after scroll request as well", afterScroll > afterInitialSearch);
        String index2 = "test_2";
        setWlmMode("enabled");
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            String numberStr = responseBody.substring(colonIndex + 1, commaIndex).trim();
                DefaultAttributeValueStore::new
            int pre2 = getCompletions(workloadGroupId2);  
            InMemoryRuleProcessingService ruleProcessingService = new InMemoryRuleProcessingService(
        client().admin().cluster().updateSettings(request).get();
                .indices()
import org.opensearch.indices.SystemIndexDescriptor;
                @Override
            DiscoveryPlugin,
    }  
        throws Exception {
        }
                WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT,  
        String ruleId = "wlm_auto_tag_update_rule";
            assertTrue("Expected completions to increase", completionsAfter > completionsBefore);
        String ruleId1 = "wlm_auto_tag_rule_1";  
        );
        @Override
        String workloadGroupId = "wlm_auto_tag_scroll";
        String workloadGroupId = "wlm_group_too_many";  
                    }  
        validateResponse(response, new String[] { groupId }, null);
            return SAME;
            client().prepareSearch(testIndex).setQuery(QueryBuilders.matchAllQuery()).get();
    public WlmAutoTaggingIT(Settings nodeSettings) {
                TestClusterUpdateRequest::new,
            workloadGroupId,
        Set<String> emptyPattern = Set.of("");
            ClusterService clusterService,
import org.junit.After;
import org.opensearch.plugin.wlm.rest.RestUpdateWorkloadGroupAction;
import org.opensearch.core.common.io.stream.StreamInput;
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        }
        Map<Attribute, Set<String>> attributes = Map.of(indexPatternAttr, emptyPattern);
import org.opensearch.transport.TransportService;  
            latch.countDown();  
    private void indexDocument(String indexName) {
import org.opensearch.core.common.io.stream.StreamOutput;
    private int extractTotalCompletions(String responseBody, String workloadGroupId) {
        @Override
    }  
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
        String ruleId = "empty_patterns_rule";
import org.opensearch.action.support.ActionFilter;
        final private String method;
import org.opensearch.wlm.WorkloadManagementSettings;
        protected ClusterBlockException checkBlock(TestClusterUpdateRequest request, ClusterState state) {
        @Override
        }  
                    return ClusterState.builder(currentState).metadata(metadata).build();
            TransportService transportService,
        public Collection<Module> createGuiceModules() {
import org.opensearch.common.settings.ClusterSettings;
        assertTrue(  
        }  
                new RuleEventClassifier(Collections.emptySet(), ruleProcessingService),  
    }
        String ruleId = "long_pattern_rule";  
import org.opensearch.action.support.ActionFilters;  
     * Test-only plugin implementation for Workload Management.
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureValueValidator;
        while ((index = responseBody.indexOf(groupKey, index)) != -1) {  
        String workloadGroupId = "wlm_auto_tag_single";  
            ExtensiblePlugin,
        Attribute indexPatternAttr = RuleAttribute.INDEX_PATTERN;
            throw new AssertionError("cluster-state update failed", listener.getException());  
            }
import java.util.ArrayList;
import org.opensearch.rule.service.IndexStoredRulePersistenceService;  
            this.method = method;
            return new TestResponse(in);
                threadPool,
                    } else { // delete
            }
                .setQuery(QueryBuilders.matchAllQuery())
            client().admin().indices().prepareRefresh(indexName).get();
        String indexName = "logs-tagged-index";  
 * SPDX-License-Identifier: Apache-2.0
                new ActionPlugin.ActionHandler<>(UpdateWorkloadGroupAction.INSTANCE, TransportUpdateWorkloadGroupAction.class),
        String indexName = "update_index";  
                }
    public void testScrollRequestsAreAlsoTagged() throws Exception {  
            return List.of(refreshMechanism, rulePersistenceService, featureType);
    }
        Exception exception = assertThrows(
import org.opensearch.rest.RestHandler;
        assertTrue(
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        updateWorkloadGroupInClusterState(PUT, workloadGroup);  
            ruleRoutingService = new WorkloadGroupRuleRoutingService(client, clusterService);
                new RestGetWorkloadGroupAction(),  
                ruleProcessingService,
            this.workloadGroup = workloadGroup;  
                SearchResponse scrollResp = client().prepareSearchScroll(scrollId).setScroll(TimeValue.timeValueMinutes(1)).get();  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);  
        }
            int post1 = getCompletions(workloadGroupId1);
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
        WorkloadGroup workloadGroup = createWorkloadGroup("tagging_test_group", workloadGroupId);
         * Required for plugin instantiation during integration tests.
import org.opensearch.common.settings.SettingsFilter;
        public ExceptionCatchingListener() {  
import org.opensearch.rule.storage.DefaultAttributeValueStore;  
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("update_test_group", workloadGroupId));
            featureType = new WorkloadGroupFeatureType(new WorkloadGroupFeatureValueValidator(clusterService), new HashMap<>());
        public static final String INDEX_NAME = ".wlm_rules";
            Environment environment,
        public List<ActionFilter> getActionFilters() {  
    }  
/*  
        setWlmMode("enabled");  
        }
            ),
import org.opensearch.rule.action.CreateRuleRequest;  
            ruleId,  
        @Override
        }
            }  
        /**
import org.opensearch.common.unit.TimeValue;  
        public TestResponse() {}
        String indexName = "logs-nonexistent-index";  
                int afterInitialSearch = getCompletions(workloadGroupId);  
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("fake_delete_group", workloadGroupId));
import org.opensearch.action.DocWriteResponse;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                featureType,
    public void testMultipleRulesDoNotInterfereWithEachOther() throws Exception {  
        Attribute indexPatternAttr = RuleAttribute.INDEX_PATTERN;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    }
        }  
import org.opensearch.rule.action.CreateRuleAction;
        @Override
import org.opensearch.action.search.SearchResponse;
        }
    /**  
            );
        String indexName = "logs-tagged-index";
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupAction;
import static org.opensearch.threadpool.ThreadPool.Names.SAME;  
         * Default constructor.  
import org.opensearch.rule.InMemoryRuleProcessingService;  
        String index1 = "test_1";
            exception.getMessage().contains("Each attribute can only have a maximum of 10 values.")
    public WlmStatsResponse getWlmStatsResponse(String[] nodesId, String[] queryGroupIds, Boolean breach) throws ExecutionException,
        setWlmMode("enabled");
            NetworkService networkService
            .get();  
import java.util.concurrent.TimeUnit;
import java.util.Collections;
public class WlmAutoTaggingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        updateWorkloadGroupInClusterState(PUT, createWorkloadGroup("too_many_patterns_group", workloadGroupId));  
            Supplier<DiscoveryNodes> nodesInCluster
            (cause instanceof org.opensearch.action.ActionRequestValidationException) || (cause instanceof IllegalArgumentException)
        InterruptedException {  
import org.opensearch.plugins.DiscoveryPlugin;
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
        }
    public static class TestWorkloadManagementPlugin extends Plugin  
        assertBusy(() -> {
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            out.writeString(method);
import org.opensearch.cluster.metadata.Metadata;  
                new RestDeleteWorkloadGroupAction(settingProvider),
        @Override  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
     * the necessary components to support rule-based auto-tagging logic in integration tests.  
        });
import org.opensearch.common.network.NetworkService;  
        indexDocument(indexName);  
    }  
import org.opensearch.rule.storage.XContentRuleParser;
        }
            SearchResponse initial = client().prepareSearch(indexName)  
            ruleName,
            ActionPlugin,
        @Override
        /**
        }
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
import org.opensearch.plugins.ActionPlugin;
        );  
            int completionsBefore = getCompletions(workloadGroupId);
         */
        assertTrue(
        }
 * compatible open source license.
                Map.of(ResourceType.CPU, 0.1, ResourceType.MEMORY, 0.1)
            IndexNameExpressionResolver indexNameExpressionResolver,
        protected String executor() {
            exception.getMessage().contains("is invalid (empty or exceeds 100 characters)")
        private AutoTaggingActionFilter autoTaggingActionFilter;
 * The OpenSearch Contributors require contributions made to  
        // Step 2: Create auto-tagging rule
        // Step 1: Create workload group
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
import org.opensearch.plugin.wlm.rule.WorkloadGroupRuleRoutingService;
            super(in);
    }
        }
        String workloadGroupId1 = "wlm_auto_tag_group_1";
import org.opensearch.rule.autotagging.FeatureType;
        );
    }
            RuleFrameworkExtension {  
        // Create a pattern longer than the max allowed (e.g., >100 characters)  
import org.joda.time.Instant;  
            this.method = in.readString();
        // Empty index pattern string
            int groupStart = responseBody.indexOf("{", index);
        int preUpdateCompletions = getCompletions(workloadGroupId);
            int commaIndex = responseBody.indexOf(",", colonIndex);  
            }
        Exception exception = assertThrows(
        if (listener.getException() != null) {
import org.opensearch.common.inject.Module;
import org.opensearch.common.settings.Settings;
            return exception;
        Settings.Builder settings = Settings.builder().put("wlm.workload_group.mode", mode);
        super(nodeSettings);
        }
        );  
import java.util.HashMap;  
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;  
        // Step 3: Index document  
        client().execute(UpdateRuleAction.INSTANCE, updatedRule).get();
            return workloadGroup;
        });
        Set<String> tooManyPatterns = IntStream.range(0, 11).mapToObj(i -> "pattern_" + i).collect(Collectors.toSet());  
        public Exception getException() {
                parser,
        final private WorkloadGroup workloadGroup;
            index = commaIndex;
            featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
import org.opensearch.rule.RuleRoutingServiceRegistry;
import org.opensearch.rule.RuleRoutingService;  
            } finally {
                IndexStoredRulePersistenceService.MAX_WLM_RULES_SETTING
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
            ClusterState clusterState,  
        return total;
        @Override
            RuleEntityParser parser = new XContentRuleParser(featureType);
                    listener.onFailure(e);  
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;
        setWlmMode("enabled");
import org.opensearch.plugin.wlm.action.TransportGetWorkloadGroupAction;
                new RestUpdateWorkloadGroupAction(settingProvider)
        static RulePersistenceService rulePersistenceService;
            IndexNameExpressionResolver indexNameExpressionResolver,  
                actionFilters,  
        setWlmMode("enabled");
        Rule rule = new Rule(
        String ruleId = "wlm_auto_tag_test_rule";
        ) {
        public void writeTo(StreamOutput out) throws IOException {}  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            return List.of(
        }
                routingRegistry.getRuleRoutingService(featureType);  
        static RuleRoutingService ruleRoutingService;
    private WorkloadGroup createWorkloadGroup(String name, String id) {
                assertTrue("Expected completions to increase after initial search with scroll", afterInitialSearch > completionsBefore);
     * This class is not intended for production use and should only be used in internal  
        setWlmMode("enabled");  
        }  
                @Override
        );
        ) {
                attributeExtractorExtensions.put(ext.getAttributeExtractor().getAttribute(), ext);
            IllegalArgumentException.class,
        assertEquals("Expected no tagging before rule update", 0, preUpdateCompletions);
        try {  
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;  
        Map<Attribute, Set<String>> attributes = Map.of(indexPatternAttr, tooManyPatterns);  
        assertEquals(0, listener.getLatch().getCount());
    }
     */
         * Maximum number of rules returned in a single page during GET operations.
        @Override
            RuleRoutingServiceRegistry routingRegistry = internalCluster().getInstance(RuleRoutingServiceRegistry.class, node);  
            return List.of(autoTaggingActionFilter);
        @Override  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(builder).get());
        String ruleId = "too_many_patterns_rule";
        String longPattern = "x".repeat(101);
        public List<RestHandler> getRestHandlers(  
        private final Map<Attribute, AttributeExtractorExtension> attributeExtractorExtensions = new HashMap<>();  
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
            return List.of(  
                new ActionPlugin.ActionHandler<>(CreateWorkloadGroupAction.INSTANCE, TransportCreateWorkloadGroupAction.class),
        }
    public static class TestResponse extends ActionResponse {  
import org.opensearch.cluster.block.ClusterBlockLevel;
            rulePersistenceService = new IndexStoredRulePersistenceService(
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        public Supplier<RuleRoutingService> getRuleRoutingServiceSupplier() {
            this.workloadGroup = new WorkloadGroup(in);  
import org.opensearch.discovery.SeedHostsProvider;
            ActionListener<TestResponse> listener
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
import org.opensearch.rule.storage.AttributeValueStoreFactory;
import org.opensearch.rule.autotagging.Rule;
import org.opensearch.script.ScriptService;  
        private static final Map<Attribute, Integer> orderedAttributes = new HashMap<>();  
import org.opensearch.env.Environment;
            featureType,  
        }
        Attribute indexPatternAttr = RuleAttribute.INDEX_PATTERN;
        String workloadGroupId = "wlm_fake_delete";
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
            "Expected validation error about empty index pattern",  
import org.opensearch.plugins.ExtensiblePlugin;  
        if (invalidIds != null) {  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        });  
            featureType = TestWorkloadManagementPlugin.featureType;  
                int afterScroll = getCompletions(workloadGroupId);  
                clusterService,
        @Override  
            () -> createRule(ruleId, "test rule", indexName, featureType, "nonexistent_group")
import org.opensearch.watcher.ResourceWatcherService;
            int completionsAfter = getCompletions(workloadGroupId);
        setWlmMode("enabled");
            );  
        createRule(ruleId1, "rule for test_1", index1, featureType, workloadGroupId1);
        IndexResponse response = client().prepareIndex(indexName)
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        public TestClusterUpdateTransportAction(  
        Settings.Builder builder = Settings.builder().putNull(WorkloadManagementSettings.WLM_MODE_SETTING.getKey());
        );  
        }  
            workloadGroup.writeTo(out);  
                    String id = workloadGroup.get_id();
        } catch (ResourceNotFoundException e) {
            return null;
    }
        }  
import org.opensearch.cluster.ClusterStateUpdateTask;
        ) {  
            return latch;
            String.valueOf(cause.getMessage()).contains("nonexistent_group is not a valid workload group id")  
                client,
import org.opensearch.plugins.Plugin;
                indexNameExpressionResolver
            int completionsIndex = responseBody.indexOf("\"total_completions\"", groupStart);
            ResourceWatcherService resourceWatcherService,
    public void testDeleteRuleForNonexistentId() throws Exception {
    }  
    public void testCreateRuleWithTooManyIndexPatterns() throws Exception {
        @Override  
                routingRegistry.register(featureType, TestWorkloadManagementPlugin.ruleRoutingService);  
        String res = response.toString();  
        setWlmMode("enabled");
