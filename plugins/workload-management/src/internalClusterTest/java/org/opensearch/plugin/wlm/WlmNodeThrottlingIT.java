                Throwable rejection = expectThrows(  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
            new WlmAutoTaggingIT.TestClusterUpdateRequest(workloadGroup, method),  
        String ruleId = "wlm_role_throttle_rule";  
                Throwable.class,
            try {
                for (ScriptedBlockPlugin plugin : plugins) {
import java.util.Map;  
            Throwable rejection = expectThrows(Throwable.class, () -> blockingSearch(indexName).execute().actionGet(TIMEOUT));  
            assertNotNull(blockedSearch.actionGet(TIMEOUT));  
import org.opensearch.script.Script;
            .execute()  
        }
        assertAcked(
            disableBlocks(plugins);
            disableBlocks(plugins);  
        }
            );
        }  
        TermsLookup outerLookup = new TermsLookup(lookupIndex, null, "uid", QueryBuilders.termsLookupQuery("uid", innerLookup));  
        createRule(ruleId, "scroll throttle rule", indexName, featureType, workloadGroupId);
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))  
        throws Exception {
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);  
                awaitForBlock(plugins);
                .indices()
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);  
        }  
        createRule(ruleId, "role throttle rule", indexName, featureType, workloadGroupId);
            assertEquals("total_throttled should increment by exactly one", throttledBefore + 1, getThrottled(workloadGroupId));
    }  
    private Client clientWithPrincipal(String principal) {  
                persistenceRegistry.register(featureType, WlmAutoTaggingIT.TestWorkloadManagementPlugin.rulePersistenceService);
                public <Req extends ActionRequest, Resp extends ActionResponse> void apply(
    }
                "workload group not yet applied in cluster state",
                        }
        static final String TEST_PRINCIPAL_HEADER = "test_throttle_principal";
        // The registry is JVM-static but each test gets a new cluster, so re-register this cluster's feature type.
        String ruleId = "wlm_scroll_throttle_rule";
            new MutableWorkloadGroupFragment(
        client().execute(CreateRuleAction.INSTANCE, new CreateRuleRequest(rule)).get();
    }  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);  
/**  
            client().admin()  
                routingRegistry.getRuleRoutingService(featureType);
            int throttledBefore = getThrottled(workloadGroupId);
                    return 0;  
        String workloadGroupId = "wlm_nested_group";
     */
            shouldBlock.set(true);  
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
     */
        public Collection<RestHeaderDefinition> getRestHeaders() {
        // node_limit=1: the outer search holds the only permit while its rewrite issues a nested search to the same bucket.  
        String scrollId = client().prepareSearch(indexName)
        } finally {
    }  
        String ruleId = "wlm_nested_rule";  
        }, 30, TimeUnit.SECONDS);  
            assertEquals("total_throttled should increment by exactly one", throttledBefore + 1, getThrottled(workloadGroupId));  
import java.util.concurrent.TimeUnit;
                .get()
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        for (SearchRequestStats stats : internalCluster().getDataNodeInstances(SearchRequestStats.class)) {
            assertTrue(
            assertTrue("workload group not yet applied in cluster state", present);  
            30,
    public void testRoleThrottlingKeepsPerRoleBuckets() throws Exception {
            ActionFuture<SearchResponse> blockedSearch;  
import org.opensearch.action.search.SearchRequestBuilder;  
import org.opensearch.core.action.ActionResponse;  
    private WorkloadGroup createThrottledWorkloadGroup(String name, String id, int nodeLimit, String by) {
        createRule(ruleId, "user throttle rule", indexName, featureType, workloadGroupId);  
            .setSize(1)  
import org.opensearch.plugins.PluginsService;
            if (holder != null) {
            ruleId,  
        TermsLookup innerLookup = new TermsLookup(secondLookupIndex, null, "uid", QueryBuilders.matchAllQuery());
import org.opensearch.common.action.ActionFuture;
            assertTrue(
import org.opensearch.rule.autotagging.FeatureType;
        public Collection<String> getTaskHeaders() {  
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("user_throttle_test_group", workloadGroupId, 1, "username");
        return clientWithPrincipal("username|" + username);  
        }
        updateWorkloadGroupInClusterState(PUT, workloadGroup);  
        try {
        ActionFuture<SearchResponse> aliceBlocked;  
import org.opensearch.rule.autotagging.Rule;  
        assertAcked(
import org.opensearch.transport.client.Client;
            assertBusy(  
            plugin.disableBlock();
            .setSource(Map.of("field", "value"))
            workloadGroupId,
        @Override  
    // Helpers  
 * ({@link OpenSearchRejectedExecutionException}). This exercises the real coordinator admission hook in
                        String principal = task.getHeader(TEST_PRINCIPAL_HEADER);
            int before = getCompletions(workloadGroupId);  
    private SearchRequestBuilder blockingSearchAs(String username, String indexName) {  
 * End-to-end integration test for per-node WLM request throttling ({@code node_limit}, with group scope by default).
        String workloadGroupId = "wlm_scroll_throttle_group";
    }
                    "in-flight search gauge must exclude the throttle-rejected request",
        }  
                ),
        return clientAs(username).prepareSearch(indexName);  
            }  
        );
        for (WlmStats nodeStats : response.getNodes()) {  
import java.util.HashSet;
    private static final String PUT = "PUT";  
                        if (principal != null) {
            Instant.now().getMillis()
     * task header, then copies it onto the task's throttle principal exactly as the real auto-tagging filter does, so the  
        IndexResponse response = client().prepareIndex(indexName)  
        createRule(ruleId, "throttle rule", indexName, featureType, workloadGroupId);  
        assertNotNull(blockedSearch.actionGet(TIMEOUT));  
    }
            List<ScriptedBlockPlugin> plugins = initBlockFactory();
 * The scripted-block plugin holds a search in-flight (occupying a throttle permit) so that a second concurrent  
            try {
            blocked = blockingSearch(indexName).execute();
    }
                    throw new RuntimeException(e);
                ) {
            int before = getCompletions(workloadGroupId);  
 * this file be licensed under the Apache-2.0 license or a
            );  
        }
    private SearchRequestBuilder blockingSearchWithPrincipal(String principal, String indexName) {  
    }
            assertTrue(
            } catch (IllegalArgumentException ex) {  
            .get();  
            int before = getCompletions(workloadGroupId);
    public static class ScriptedBlockPlugin extends MockScriptPlugin {  
        assertBusy(  
        client().prepareIndex(secondLookupIndex)
            }
            awaitForBlock(plugins);  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        @Override  
        updateWorkloadGroupInClusterState(PUT, workloadGroup);  
        try {
            total += stats.getTookCurrent();
                }
            );
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
                .metadata()
            name,
import org.opensearch.tasks.Task;
        int throttledBefore = getThrottled(workloadGroupId);
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
                    Throwable.class,
        // Group throttled per-username to a single in-flight request per node (by = username).
            hits.set(0);
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                routingRegistry.register(featureType, WlmAutoTaggingIT.TestWorkloadManagementPlugin.ruleRoutingService);
import java.util.concurrent.atomic.AtomicInteger;
            assertTrue(
                "Expected an OpenSearchRejectedExecutionException in the cause chain but was: " + rejection,
            .setSource(Map.of("uid", "value"))
            int after = getCompletions(workloadGroupId);  
import org.opensearch.core.action.ActionListener;
import org.opensearch.rule.action.CreateRuleRequest;  
        } finally {  
import java.util.List;
            "no level of one request's own nested rewrite may be counted as throttled",
import org.opensearch.indices.TermsLookup;
        static final String SCRIPT_NAME = "search_block";
import org.opensearch.action.DocWriteResponse;  
import org.opensearch.action.ActionRequest;
                .cluster()  
        assertEquals(DocWriteResponse.Result.CREATED, response.getResult());
                    blocked += plugin.hits.get();  
    }
            }  
            }, 30, TimeUnit.SECONDS);  
            return Collections.singletonMap(SCRIPT_NAME, params -> {
    /**
        }
            int before = getCompletions(workloadGroupId);  
            id,  
            return List.of(TEST_PRINCIPAL_HEADER);
        ActionFuture<SearchResponse> blockedSearch;
        return client().prepareSearch(indexName)  
package org.opensearch.plugin.wlm;
 * compatible open source license.
        assertBusy(() -> {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(builder).get());
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(settings);  
            plugins.addAll(pluginsService.filterPlugins(ScriptedBlockPlugin.class));
            .get();  
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
/*  
                    () -> client().prepareSearchScroll(sid).setScroll(TIMEOUT).execute().actionGet(TIMEOUT)
        );
        // Open a scroll context with a cheap query so the initial search releases its permit immediately.  
            .setScroll(TIMEOUT)
                hasRejectedExecutionCause(rejection)  
            blockedSearch = blockingSearch(indexName).execute();
            });
        return clientWithPrincipal(principal).prepareSearch(indexName)
                hasRejectedExecutionCause(rejection)  
        boolean completed = listener.getLatch().await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);  
    private static boolean hasRejectedExecutionCause(Throwable t) {
            carolBlocked = blockingSearchWithPrincipal(principal("carol", "analyst", "admin"), indexName).execute();
                    ActionRequestMetadata<Req, Resp> metadata,
     * Stands in for the security plugin's principal extractor. Registers a test-only header as both a REST header and a
                "an independent concurrent request must still be throttled but was: " + rejection,
            // Same role as alice, so same bucket.
            assertEquals("carol must not be throttled by the analyst bucket", throttledBefore + 1, getThrottled(workloadGroupId));
                total += extractor.applyAsLong(holder);  
            int after = getCompletions(workloadGroupId);
    }
            .setQuery(QueryBuilders.matchAllQuery())
            assertThat(blocked, greaterThan(0));
            }, 30, TimeUnit.SECONDS);  
    /**  
    private SearchRequestBuilder searchAs(String username, String indexName) {
    public static class TestPrincipalPlugin extends Plugin implements ActionPlugin {  
    }
            boolean present = client().admin()
            aliceBlocked = blockingSearchWithPrincipal(principal("alice", "analyst"), indexName).execute();  
        Settings.Builder settings = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), mode);
        indexDocument(indexName);  
        }, 30, TimeUnit.SECONDS);
            .actionGet(TIMEOUT);  
        assertBusy(() -> {  
        );  
            .setQuery(QueryBuilders.termsLookupQuery("field", lookup))
            assertBusy(() -> {  
                30,  
            aliceBlocked = blockingSearchAs("alice", indexName).execute();  
            awaitForBlock(plugins);
        assertNotNull(carolBlocked.actionGet(TIMEOUT));  
        return plugins;  
        }, 30, TimeUnit.SECONDS);
        ActionFuture<SearchResponse> carolBlocked;
import org.opensearch.search.lookup.LeafFieldsLookup;
            );
            WlmAutoTaggingIT.TestClusterUpdateTransportAction.ACTION,
        }, 30, TimeUnit.SECONDS);
        setWlmMode("enabled");
            bobBlocked = blockingSearchAs("bob", indexName).execute();
        ActionFuture<SearchResponse> blocked;
        }  
    }  
            if (cur instanceof OpenSearchRejectedExecutionException) {
            int before = getCompletions(workloadGroupId);  
import org.opensearch.index.query.QueryBuilders;  
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
import org.opensearch.action.search.SearchRequestStats;
        setWlmMode("enabled");  
        // A second rule-free lookup index, so a terms lookup can nest inside a terms lookup and reach depth 2.
     * group may be absent from a node that has not registered it yet, which contributes nothing.  
    }  
import org.opensearch.plugins.Plugin;
                public int order() {
                    }
            // Second search while the first is still in-flight: must be rejected (429).
                LogManager.getLogger(WlmNodeThrottlingIT.class).info("Blocking on the document {}", fieldsLookup.get("_id"));
                // A scroll continuation must be throttled too, or ?scroll= would bypass node_limit.
 */  
                    inFlightBefore,  
                .indices()
                .metadata()  
        } finally {  
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {
            WorkloadGroupStatsHolder holder = nodeStats.getWorkloadGroupStats().getStats().get(groupId);
            Throwable rejection = expectThrows(  
        String secondLookupIndex = "lookupidx2";  
        }
                }
    private List<ScriptedBlockPlugin> initBlockFactory() {
    }  
        String indexName = "role_throttle_index";
import org.junit.After;
            client().prepareClearScroll().addScrollId(scrollId).get();
import org.opensearch.action.support.WriteRequest;  
            Throwable rejection = expectThrows(Throwable.class, () -> blockingSearchAs("alice", indexName).execute().actionGet(TIMEOUT));  
        for (String node : internalCluster().getNodeNames()) {
        assertEquals(  
            if (cur.getCause() == cur) {
                    ActionListener<Resp> listener,  
                    chain.proceed(task, action, request, listener);  
import org.opensearch.test.OpenSearchIntegTestCase;  
            .actionGet(TIMEOUT);
        public void disableBlock() {
        createRule(ruleId, "nested rule", indexName, featureType, workloadGroupId);
        );
                .prepareCreate(secondLookupIndex)
import org.opensearch.action.support.ActionFilter;  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            assertEquals("total_throttled should increment by exactly one", throttledBefore + 1, getThrottled(workloadGroupId));
                .prepareCreate(indexName)  
        assertBusy(() -> {
                () -> blockingSearchWithPrincipal(principal("bob", "analyst"), indexName).execute().actionGet(TIMEOUT)
        assertBusy(() -> {
            int throttledBefore = getThrottled(workloadGroupId);  
import org.opensearch.action.index.IndexResponse;
        AutoTaggingRegistry.registerFeatureType(featureType);
        return sb.toString();  
    }
            // carol also holds analyst, but is charged to her smallest role, admin.
    /**
            .setQuery(QueryBuilders.termsLookupQuery("field", outerLookup))
    private void disableBlocks(List<ScriptedBlockPlugin> plugins) {  
                    blocked += plugin.hits.get();  
import java.util.function.ToLongFunction;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertBusy(() -> {  
            RuleRoutingServiceRegistry routingRegistry = internalCluster().getInstance(RuleRoutingServiceRegistry.class, node);  
import org.opensearch.action.search.SearchResponse;
        }
            ),  
        @Override
        client().prepareIndex(lookupIndex)
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);
            awaitForBlock(plugins);
            plugin.reset();
    public void registerFeatureTypeIfMissingOnAllNodes() {
        assertNotNull(aliceBlocked.actionGet(TIMEOUT));  
                hits.incrementAndGet();
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
                .getState()
                client().admin().cluster().prepareState().get().getState().metadata().workloadGroups().containsKey(workloadGroupId)  
                TimeUnit.SECONDS
     * IT exercises the production plumbing (task field -&gt; throttle admission) instead of simulating it.
        WlmStatsRequest request = new WlmStatsRequest(null, new HashSet<>(Collections.singletonList(groupId)), null);  
                Map.of(ResourceType.CPU, 0.9, ResourceType.MEMORY, 0.9),  
    }
        setWlmMode("enabled");  
            shouldBlock.set(false);
                assertThat("bob's search should have been admitted and reached the blocking script", blocked, greaterThan(1));
            .setId("1")
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;  
        client().execute(
        long total = 0;
            // alice's second concurrent search hits her per-user node_limit -> 429.
            .setId("1")  
import org.opensearch.script.ScriptType;  
                try {  
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("nested_test_group", workloadGroupId, 1);
    }
            ruleName,
                .containsKey(workloadGroupId);
    /**  
import org.opensearch.cluster.metadata.WorkloadGroup;
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
    }
            .execute()
        indexDocument(indexName);
                return true;
                .prepareState()
            );
    }
            );
import org.opensearch.core.rest.RestStatus;
 *
        assertEquals("a nested rewrite search must not be counted as throttled", throttledBefore, getThrottled(workloadGroupId));
import org.opensearch.rule.RuleAttribute;
        assertEquals(RestStatus.OK, twoLevel.status());
        StringBuilder sb = new StringBuilder("username|").append(username);
import java.util.Set;
                .workloadGroups()
                Settings.EMPTY,
    public void testNestedRewriteSearchIsNotChargedASecondPermit() throws Exception {
        for (ScriptedBlockPlugin plugin : plugins) {
    }
import java.util.function.Function;
        String indexName = "throttle_index";
        // Wait for rule propagation: a search tagged as alice must reach the group before the concurrency scenario.
        }
import org.apache.logging.log4j.LogManager;
                }
        }
                return true;  
                );  
    @Before  
        indexDocument(indexName);
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        plugins.add(TestPrincipalPlugin.class);
                blockedSearch = blockingSearch(indexName).execute();  
import org.opensearch.wlm.ResourceType;  
    }  
        );
        }
            int blocked = 0;
}
        return new WorkloadGroup(
                .cluster()
                .workloadGroups()
            throttledBefore,
    private int sumGroupStat(String groupId, ToLongFunction<WorkloadGroupStatsHolder> extractor) throws Exception {
     * {@code onRequestEnd}/{@code onRequestFailure}; a throttle rejection must never touch it.  
            boolean present = client().admin()
                .indices()
        return false;
import static org.hamcrest.Matchers.greaterThan;
        private final AtomicInteger hits = new AtomicInteger();  
            // A rejected request must not leak the in-flight gauge. Poll, since background rule-sync searches also move it.
            });
    private Client clientAs(String username) {
            .get()
                @Override
    }
            ),
    @Override
            throw new AssertionError("cluster-state update failed", listener.getException());  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);  
        long total = 0;  
                    ActionFilterChain<Req, Resp> chain
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("scroll_throttle_test_group", workloadGroupId, 1);  
    private static final TimeValue TIMEOUT = new TimeValue(30, TimeUnit.SECONDS);
        String lookupIndex = "lookupidx";
        // A terms lookup with a subquery runs a nested search during rewrite; the outer request already paid.
        String ruleId = "wlm_throttle_rule";  
        String workloadGroupId = "wlm_throttle_group";
    public void testSecondConcurrentSearchRejectedWhenNodeLimitReached() throws Exception {
        assertBusy(() -> {
            () -> assertTrue(
                assertEquals("a throttled scroll must be counted", throttledBefore + 1, getThrottled(workloadGroupId));
        if (by != null) {
import org.junit.Before;
        return sumGroupStat(groupId, WorkloadGroupStatsHolder::getCompletions);  
            .setSource(Map.of("uid", "value"))
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            }
        plugins.add(RuleFrameworkPlugin.class);  
    private int getThrottled(String groupId) throws Exception {  
        Settings.Builder builder = Settings.builder().putNull(WorkloadManagementSettings.WLM_MODE_SETTING.getKey());  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
        // Rule propagation is async; wait until searches are tagged to the group.
     */
            // bob is a different bucket, so he is admitted. His search blocks too, so run it async.
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
 * {@code TransportSearchAction} through auto-tagging, not a mocked service.  
        SearchResponse twoLevel = client().prepareSearch(indexName)
        assertNotNull(bobBlocked.actionGet(TIMEOUT));
                "Expected an OpenSearchRejectedExecutionException in the cause chain but was: " + rejection,
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;
            return List.of(new ActionFilter() {  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
                } catch (Exception e) {  
        }  
    public void clearWlmModeSetting() throws Exception {
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
        }
        } finally {
        updateWorkloadGroupInClusterState(PUT, workloadGroup);  
            sb.append(WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER).append("role|").append(role);
import java.util.Collection;
    }
            Instant.now().toString()
                hasRejectedExecutionCause(rejection)  
        assertNotNull(blocked.actionGet(TIMEOUT));
                assertTrue("Expected a scroll continuation to be throttled but was: " + rejection, hasRejectedExecutionCause(rejection));
                    if (task instanceof WorkloadGroupTask) {  
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("throttle_test_group", workloadGroupId, 1);
                int blocked = 0;
                @Override  
        }
                int blocked = 0;
     * Test script plugin that blocks during the query phase until released, keeping a search in-flight.
     * Sums the current in-flight search gauge ({@link SearchRequestStats#getTookCurrent()})
    }  
        // Matches no rule, so the nested search inherits the outer request's group and bucket.
            client().admin()  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.plugins.ActionPlugin;  
            featureType,  
            .get();
        return plugins;
    private int getCompletions(String groupId) throws Exception {
    private void updateWorkloadGroupInClusterState(String method, WorkloadGroup workloadGroup) throws InterruptedException {
    private SearchRequestBuilder blockingSearch(String indexName) {
import java.util.concurrent.atomic.AtomicBoolean;  
        );
        }  
            .setId("1")  
    @After
        for (ScriptedBlockPlugin plugin : plugins) {
        @Override
                .getState()  
            client().admin()
    private long currentInFlightSearches() {
            RulePersistenceServiceRegistry persistenceRegistry = internalCluster().getInstance(RulePersistenceServiceRegistry.class, node);
 * search deterministically exceeds the node limit and must be rejected with a 429
    // Principals come from a test-only header via TestPrincipalPlugin, standing in for the security plugin.
        }, 30, TimeUnit.SECONDS);
            }  
                LeafFieldsLookup fieldsLookup = (LeafFieldsLookup) params.get("_fields");  
    private void awaitForBlock(List<ScriptedBlockPlugin> plugins) throws Exception {
     */
            int throttledBefore = getThrottled(workloadGroupId);  
import java.util.Collections;  
     * across all data nodes. This is the counter incremented in {@code onRequestStart} and decremented in
        assertBusy(() -> {  
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        String indexName = "scroll_throttle_index";  
    private static String principal(String username, String... roles) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        Rule rule = new Rule(
            Throwable rejection = expectThrows(Throwable.class, () -> blockingSearch(indexName).execute().actionGet(TIMEOUT));  
                }
        );
import org.opensearch.wlm.stats.WlmStats;
        List<ScriptedBlockPlugin> plugins = new ArrayList<>();  
        }
                break;
import org.opensearch.script.MockScriptPlugin;
                    Task task,
import org.opensearch.wlm.WorkloadManagementSettings;  
            disableBlocks(plugins);  
        for (Throwable cur = t; cur != null; cur = cur.getCause()) {  
        public List<ActionFilter> getActionFilters() {
import org.opensearch.wlm.stats.WorkloadGroupStats.WorkloadGroupStatsHolder;
                    currentInFlightSearches()
        TermsLookup lookup = new TermsLookup(lookupIndex, null, "uid", QueryBuilders.matchAllQuery());
        String ruleId = "wlm_user_throttle_rule";
        indexDocument(indexName);  
            // bob was admitted, so no additional throttle beyond alice's one rejection.
            plugin.enableBlock();  
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
 * <p>
        return sumGroupStat(groupId, WorkloadGroupStatsHolder::getThrottled);
            awaitForBlock(plugins);
        );
        ActionFuture<SearchResponse> aliceBlocked;
    }
            } finally {  
                }
            disableBlocks(plugins);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                () -> assertEquals(
        // Two levels: the exempt middle search must pass its parent's charge on to the grandchild.
            assertTrue("workload group not yet applied in cluster state", present);
        } finally {
    }
                .get()
    private void createRule(String ruleId, String ruleName, String indexPattern, FeatureType featureType, String workloadGroupId)  
import org.opensearch.rule.RuleFrameworkPlugin;
        plugins.add(WlmAutoTaggingIT.TestWorkloadManagementPlugin.class);
            getThrottled(workloadGroupId)  
                int throttledBefore = getThrottled(workloadGroupId);  
        Settings.Builder throttling = Settings.builder().put(WorkloadGroupThrottleSettings.NODE_LIMIT.getKey(), nodeLimit);  
        SearchResponse response = client().prepareSearch(indexName)  
        try {  
        assertBusy(() -> assertEquals("in-flight search gauge must drain to zero", 0L, currentInFlightSearches()), 30, TimeUnit.SECONDS);  
        }, 30, TimeUnit.SECONDS);
    }
                    assertBusy(() -> assertFalse(shouldBlock.get()), 120, TimeUnit.SECONDS);
            // Proves the rejection was the throttle, not a broken scroll context.
 * SPDX-License-Identifier: Apache-2.0
    private WorkloadGroup createThrottledWorkloadGroup(String name, String id, int nodeLimit) {
                throttling.build()
        return client().filterWithHeader(Map.of(TestPrincipalPlugin.TEST_PRINCIPAL_HEADER, principal));
            for (ScriptedBlockPlugin plugin : plugins) {
        setWlmMode("enabled");
        assertBusy(() -> {
        return Math.toIntExact(total);  
                            ((WorkloadGroupTask) task).setThrottlePrincipal(principal);  
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
            assertTrue("Expected search to be tagged to the throttled workload group", getCompletions(workloadGroupId) > before);
        return clientAs(username).prepareSearch(indexName)
import org.opensearch.rule.RulePersistenceServiceRegistry;  
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("role_throttle_test_group", workloadGroupId, 1, "role");
 * The OpenSearch Contributors require contributions made to  
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexPattern)),
        try {  
    private void setWlmMode(String mode) throws Exception {
        // A genuinely concurrent request is still rejected, so the exemption didn't disable throttling.  
        AutoTaggingRegistry.featureTypesRegistryMap.remove(WorkloadGroupFeatureType.NAME);  
                "Expected an OpenSearchRejectedExecutionException in the cause chain but was: " + rejection,
import org.opensearch.action.support.ActionFilterChain;
     * Sums one stat for a workload group across every node's WLM stats, read from the response objects directly. The
        public void enableBlock() {
                hasRejectedExecutionCause(rejection)  
        String workloadGroupId = "wlm_user_throttle_group";
        });  
        }, 30, TimeUnit.SECONDS);
                .containsKey(workloadGroupId);  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
        String workloadGroupId = "wlm_role_throttle_group";
            }
        FeatureType featureType = WlmAutoTaggingIT.TestWorkloadManagementPlugin.featureType;
        String indexName = "user_throttle_index";  
        try {
import org.opensearch.common.unit.TimeValue;
        assertNotNull(aliceBlocked.actionGet(TIMEOUT));
    private void indexDocument(String indexName) {
            int after = getCompletions(workloadGroupId);
            long inFlightBefore = currentInFlightSearches();  
        setWlmMode("enabled");
    public void testScrollContinuationIsThrottled() throws Exception {  
            return List.of(new RestHeaderDefinition(TEST_PRINCIPAL_HEADER, false));
    }
        private final AtomicBoolean shouldBlock = new AtomicBoolean(true);
        }  
        return createThrottledWorkloadGroup(name, id, nodeLimit, null);
                for (ScriptedBlockPlugin plugin : plugins) {
            .getScrollId();  
        assertAcked(  
import org.opensearch.rule.action.CreateRuleAction;
                    // Outlast callers' 30s assertBusy waits; the 10s default would fail inside an unrelated assertion.
        assertAcked(client().admin().cluster().updateSettings(request).get());
            // Holds the only permit.
        assertTrue("cluster-state update did not complete in time", completed);
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    }
            searchAs("alice", indexName).setQuery(QueryBuilders.matchAllQuery()).get();
                assertThat("carol's search should have been admitted and reached the blocking script", blocked, greaterThan(1));
        }
    }  
                .prepareCreate(lookupIndex)
        public void reset() {  
                    String action,  
                .prepareState()  
public class WlmNodeThrottlingIT extends OpenSearchIntegTestCase {  
 */
        return total;
            int after = getCompletions(workloadGroupId);
            // alice's first search blocks in the query phase, holding her single per-user permit.
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
        // Rule validation reads applied cluster state, so wait for the group before creating the rule.  
    }
        indexDocument(indexName);
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);  
        assertEquals(RestStatus.OK, response.status());
        for (String role : roles) {  
        WlmAutoTaggingIT.ExceptionCatchingListener listener = new WlmAutoTaggingIT.ExceptionCatchingListener();  
            final String sid = scrollId;
            assertEquals("bob must not be throttled by alice's bucket", throttledBefore + 1, getThrottled(workloadGroupId));
            TimeUnit.SECONDS  
        }  
        ActionFuture<SearchResponse> bobBlocked;  
import org.opensearch.rest.RestHeaderDefinition;  
            clientWithPrincipal(principal("alice", "analyst")).prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
import org.opensearch.action.support.ActionRequestMetadata;
        WlmStatsResponse response = client().execute(WlmStatsAction.INSTANCE, request).get();
        String indexName = "orders";
        if (listener.getException() != null) {
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))  
            assertNotNull(client().prepareSearchScroll(sid).setScroll(TIMEOUT).get());  
            listener
                disableBlocks(plugins);
        // Once the blocked search finishes, the gauge must drain back to zero (no leaked in-flight count).
import org.opensearch.rule.RuleRoutingServiceRegistry;
    public void testUsernameThrottlingKeepsPerUserBuckets() throws Exception {  
import org.opensearch.wlm.WorkloadGroupTask;
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
        plugins.add(ScriptedBlockPlugin.class);
            throttling.put(WorkloadGroupThrottleSettings.BY.getKey(), by);
import org.opensearch.common.settings.Settings;  
                    Req request,
import java.util.ArrayList;
            assertBusy(() -> {  
import org.joda.time.Instant;  
                blocked += plugin.hits.get();  
