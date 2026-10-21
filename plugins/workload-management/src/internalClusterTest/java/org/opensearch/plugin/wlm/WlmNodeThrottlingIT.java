    private void createRule(String ruleId, String ruleName, String indexPattern, FeatureType featureType, String workloadGroupId)
        return clientWithPrincipal("username|" + username);
        );
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
                    }
import org.opensearch.rule.autotagging.Rule;
    }
        }
import org.junit.Before;
        }
     * group may be absent from a node that has not registered it yet, which contributes nothing.
    }
            "no level of one request's own nested rewrite may be counted as throttled",
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
                try {
        @Override
        assertAcked(
        return plugins;
    private void disableBlocks(List<ScriptedBlockPlugin> plugins) {
        // A second rule-free lookup index, so a terms lookup can nest inside a terms lookup and reach depth 2.
        return sumGroupStat(groupId, WorkloadGroupStatsHolder::getCompletions);
            return List.of(new RestHeaderDefinition(TEST_PRINCIPAL_HEADER, false));
                    chain.proceed(task, action, request, listener);
            .actionGet(TIMEOUT);
import org.opensearch.script.ScriptType;
                30,
        assertBusy(() -> {
                .containsKey(workloadGroupId);
                Throwable.class,
        static final String TEST_PRINCIPAL_HEADER = "test_throttle_principal";
        );
        } finally {
                .prepareState()
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
            try {
                .prepareCreate(lookupIndex)
            total += stats.getTookCurrent();
            .setId("1")
        assertNotNull(aliceBlocked.actionGet(TIMEOUT));
        }
        private final AtomicInteger hits = new AtomicInteger();
        try {
        boolean completed = listener.getLatch().await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);
import org.opensearch.test.OpenSearchIntegTestCase;
import org.apache.logging.log4j.LogManager;
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        assertAcked(
                .metadata()
            // bob was admitted, so no additional throttle beyond alice's one rejection.
        try {
            featureType,
            Map.of(RuleAttribute.INDEX_PATTERN, Set.of(indexPattern)),
                }
        // Once the blocked search finishes, the gauge must drain back to zero (no leaked in-flight count).
import java.util.Collection;
        } finally {
                "Expected an OpenSearchRejectedExecutionException in the cause chain but was: " + rejection,
            ruleId,
    public void testScrollContinuationIsThrottled() throws Exception {
    private List<ScriptedBlockPlugin> initBlockFactory() {
        createRule(ruleId, "nested rule", indexName, featureType, workloadGroupId);
            aliceBlocked = blockingSearchAs("alice", indexName).execute();
                for (ScriptedBlockPlugin plugin : plugins) {
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    private SearchRequestBuilder blockingSearchWithPrincipal(String principal, String indexName) {
            .setQuery(QueryBuilders.termsLookupQuery("field", lookup))
 */
        assertBusy(() -> {
        if (by != null) {
            searchAs("alice", indexName).setQuery(QueryBuilders.matchAllQuery()).get();
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("throttle_test_group", workloadGroupId, 1);
        String ruleId = "wlm_throttle_rule";
import org.opensearch.core.action.ActionResponse;
    }
        }, 30, TimeUnit.SECONDS);
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                "Expected an OpenSearchRejectedExecutionException in the cause chain but was: " + rejection,
        return client().filterWithHeader(Map.of(TestPrincipalPlugin.TEST_PRINCIPAL_HEADER, principal));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ActionFuture<SearchResponse> carolBlocked;
        String workloadGroupId = "wlm_role_throttle_group";
                    Task task,
                .prepareCreate(indexName)
            sb.append(WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER).append("role|").append(role);
import org.opensearch.action.admin.cluster.wlm.WlmStatsResponse;
import org.opensearch.action.support.ActionRequestMetadata;
            ),
            blockedSearch = blockingSearch(indexName).execute();
            assertBusy(
import org.opensearch.plugins.Plugin;
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
                    () -> client().prepareSearchScroll(sid).setScroll(TIMEOUT).execute().actionGet(TIMEOUT)
                ),
        }, 30, TimeUnit.SECONDS);
            assertEquals("bob must not be throttled by alice's bucket", throttledBefore + 1, getThrottled(workloadGroupId));
                .getState()
        assertNotNull(aliceBlocked.actionGet(TIMEOUT));
                    currentInFlightSearches()
        }, 30, TimeUnit.SECONDS);
                    assertBusy(() -> assertFalse(shouldBlock.get()), 120, TimeUnit.SECONDS);
        plugins.add(WlmAutoTaggingIT.TestWorkloadManagementPlugin.class);
    }
        assertBusy(() -> {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(builder).get());
    // Principals come from a test-only header via TestPrincipalPlugin, standing in for the security plugin.
        return plugins;
                .cluster()
                .workloadGroups()
            final String sid = scrollId;
                @Override
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);
import org.opensearch.rule.action.CreateRuleAction;
        }
        client().execute(CreateRuleAction.INSTANCE, new CreateRuleRequest(rule)).get();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            assertThat(blocked, greaterThan(0));
                routingRegistry.getRuleRoutingService(featureType);
            assertBusy(() -> {
     */
                    ActionFilterChain<Req, Resp> chain
        long total = 0;
        Rule rule = new Rule(
    }
                return true;
                persistenceRegistry.register(featureType, WlmAutoTaggingIT.TestWorkloadManagementPlugin.rulePersistenceService);
     * Sums the current in-flight search gauge ({@link SearchRequestStats#getTookCurrent()})
        @Override
            disableBlocks(plugins);
            assertEquals("total_throttled should increment by exactly one", throttledBefore + 1, getThrottled(workloadGroupId));
    private long currentInFlightSearches() {
            Throwable rejection = expectThrows(
import org.opensearch.core.rest.RestStatus;
    private int getThrottled(String groupId) throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
            // alice's second concurrent search hits her per-user node_limit -> 429.
            workloadGroupId,
                    String action,
                .indices()
                blocked += plugin.hits.get();
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        public Collection<String> getTaskHeaders() {
    @Before
    }
                    Throwable.class,
    public void clearWlmModeSetting() throws Exception {
                    return 0;
        try {
    private WorkloadGroup createThrottledWorkloadGroup(String name, String id, int nodeLimit) {
import org.opensearch.action.search.SearchResponse;
                assertEquals("a throttled scroll must be counted", throttledBefore + 1, getThrottled(workloadGroupId));
                routingRegistry.register(featureType, WlmAutoTaggingIT.TestWorkloadManagementPlugin.ruleRoutingService);
        return sb.toString();
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);
        assertBusy(() -> {
    public static class TestPrincipalPlugin extends Plugin implements ActionPlugin {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            int before = getCompletions(workloadGroupId);
import org.junit.After;
 * End-to-end integration test for per-node WLM request throttling ({@code node_limit}, with group scope by default).
                () -> assertEquals(
            int throttledBefore = getThrottled(workloadGroupId);
}
        } finally {
            .execute()
            throttling.put(WorkloadGroupThrottleSettings.BY.getKey(), by);
            throttledBefore,
        for (SearchRequestStats stats : internalCluster().getDataNodeInstances(SearchRequestStats.class)) {
        assertEquals(RestStatus.OK, twoLevel.status());
            );
 * <p>
        );
        Settings.Builder throttling = Settings.builder().put(WorkloadGroupThrottleSettings.NODE_LIMIT.getKey(), nodeLimit);
                }
                .indices()
            blocked = blockingSearch(indexName).execute();
        assertBusy(() -> {
            });
import java.util.Collections;
        if (listener.getException() != null) {
            30,
        String workloadGroupId = "wlm_nested_group";
    /**
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
            );
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
 * compatible open source license.
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        TermsLookup lookup = new TermsLookup(lookupIndex, null, "uid", QueryBuilders.matchAllQuery());
    public void registerFeatureTypeIfMissingOnAllNodes() {
import java.util.ArrayList;
        });
                .workloadGroups()
 * ({@link OpenSearchRejectedExecutionException}). This exercises the real coordinator admission hook in
        createRule(ruleId, "throttle rule", indexName, featureType, workloadGroupId);
        public void enableBlock() {
import org.opensearch.common.action.ActionFuture;
                Throwable rejection = expectThrows(
import java.util.Set;
    private SearchRequestBuilder blockingSearch(String indexName) {
                assertThat("carol's search should have been admitted and reached the blocking script", blocked, greaterThan(1));
        }
        return createThrottledWorkloadGroup(name, id, nodeLimit, null);
        AutoTaggingRegistry.featureTypesRegistryMap.remove(WorkloadGroupFeatureType.NAME);
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
                    ActionRequestMetadata<Req, Resp> metadata,
     */
    }
import org.opensearch.action.ActionRequest;
                () -> blockingSearchWithPrincipal(principal("bob", "analyst"), indexName).execute().actionGet(TIMEOUT)
            assertEquals("carol must not be throttled by the analyst bucket", throttledBefore + 1, getThrottled(workloadGroupId));
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;
import org.opensearch.indices.TermsLookup;
            boolean present = client().admin()
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        // A genuinely concurrent request is still rejected, so the exemption didn't disable throttling.
                LeafFieldsLookup fieldsLookup = (LeafFieldsLookup) params.get("_fields");
        plugins.add(TestPrincipalPlugin.class);
    private void setWlmMode(String mode) throws Exception {
                    if (task instanceof WorkloadGroupTask) {
            } catch (IllegalArgumentException ex) {
            client().admin()
        assertBusy(() -> assertEquals("in-flight search gauge must drain to zero", 0L, currentInFlightSearches()), 30, TimeUnit.SECONDS);
        String ruleId = "wlm_scroll_throttle_rule";
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            int after = getCompletions(workloadGroupId);
        }
            int before = getCompletions(workloadGroupId);
        return new WorkloadGroup(
            if (cur instanceof OpenSearchRejectedExecutionException) {
            // A rejected request must not leak the in-flight gauge. Poll, since background rule-sync searches also move it.
        throws Exception {
            // carol also holds analyst, but is charged to her smallest role, admin.
                }
            int before = getCompletions(workloadGroupId);
        WlmAutoTaggingIT.ExceptionCatchingListener listener = new WlmAutoTaggingIT.ExceptionCatchingListener();
import org.opensearch.plugins.PluginsService;
        }
            .get();
        assertTrue("cluster-state update did not complete in time", completed);
        setWlmMode("enabled");
    private static final String PUT = "PUT";
            RulePersistenceServiceRegistry persistenceRegistry = internalCluster().getInstance(RulePersistenceServiceRegistry.class, node);
        indexDocument(indexName);
            );
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            TimeUnit.SECONDS
        long total = 0;
            getThrottled(workloadGroupId)
                    blocked += plugin.hits.get();
     */
        for (Throwable cur = t; cur != null; cur = cur.getCause()) {
        public void disableBlock() {
        String secondLookupIndex = "lookupidx2";
            } finally {
import java.util.concurrent.atomic.AtomicBoolean;
        }, 30, TimeUnit.SECONDS);
            }
        createRule(ruleId, "role throttle rule", indexName, featureType, workloadGroupId);
import org.opensearch.transport.client.Client;
            }, 30, TimeUnit.SECONDS);
            List<ScriptedBlockPlugin> plugins = initBlockFactory();
        );
    }
            }, 30, TimeUnit.SECONDS);
                "Expected an OpenSearchRejectedExecutionException in the cause chain but was: " + rejection,
            }
        List<ScriptedBlockPlugin> plugins = new ArrayList<>();
        ActionFuture<SearchResponse> blocked;
    }
        try {
import org.opensearch.wlm.WorkloadManagementSettings;
        }
        StringBuilder sb = new StringBuilder("username|").append(username);
import org.opensearch.wlm.stats.WlmStats;
import org.opensearch.rule.action.CreateRuleRequest;
            long inFlightBefore = currentInFlightSearches();
    }
            WorkloadGroupStatsHolder holder = nodeStats.getWorkloadGroupStats().getStats().get(groupId);
            id,
        return client().prepareSearch(indexName)
            .get()
    private void updateWorkloadGroupInClusterState(String method, WorkloadGroup workloadGroup) throws InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
            .setSource(Map.of("uid", "value"))
    }
import org.opensearch.wlm.ResourceType;
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("nested_test_group", workloadGroupId, 1);
                .get()
            for (ScriptedBlockPlugin plugin : plugins) {
                        if (principal != null) {
import org.opensearch.script.Script;
        assertNotNull(blocked.actionGet(TIMEOUT));
            assertTrue(
                        String principal = task.getHeader(TEST_PRINCIPAL_HEADER);
        SearchResponse response = client().prepareSearch(indexName)
    private Client clientWithPrincipal(String principal) {
                int blocked = 0;
import org.opensearch.common.unit.TimeValue;
    }
 * SPDX-License-Identifier: Apache-2.0
            client().prepareClearScroll().addScrollId(scrollId).get();
            .getScrollId();
            client().admin()
    }
                .get()
        public Collection<RestHeaderDefinition> getRestHeaders() {
        FeatureType featureType = WlmAutoTaggingIT.TestWorkloadManagementPlugin.featureType;
        // Group throttled per-username to a single in-flight request per node (by = username).
        }
            .setSource(Map.of("field", "value"))
            assertNotNull(blockedSearch.actionGet(TIMEOUT));
        assertBusy(() -> {
        setWlmMode("enabled");
        @Override
                            ((WorkloadGroupTask) task).setThrottlePrincipal(principal);
                .containsKey(workloadGroupId);
            }
    private static String principal(String username, String... roles) {
        String indexName = "user_throttle_index";
            awaitForBlock(plugins);
        TermsLookup outerLookup = new TermsLookup(lookupIndex, null, "uid", QueryBuilders.termsLookupQuery("uid", innerLookup));
        ActionFuture<SearchResponse> bobBlocked;
            client().admin()
            .execute()
    public void testNestedRewriteSearchIsNotChargedASecondPermit() throws Exception {
    }
                }
    }
            () -> assertTrue(
                disableBlocks(plugins);
    }
                }
    }
        indexDocument(indexName);
        // Rule validation reads applied cluster state, so wait for the group before creating the rule.
            // bob is a different bucket, so he is admitted. His search blocks too, so run it async.
            listener
            .setScroll(TIMEOUT)
                hasRejectedExecutionCause(rejection)
        private final AtomicBoolean shouldBlock = new AtomicBoolean(true);
        ActionFuture<SearchResponse> aliceBlocked;
        }, 30, TimeUnit.SECONDS);
        client().prepareIndex(lookupIndex)
            new MutableWorkloadGroupFragment(
                LogManager.getLogger(WlmNodeThrottlingIT.class).info("Blocking on the document {}", fieldsLookup.get("_id"));
            carolBlocked = blockingSearchWithPrincipal(principal("carol", "analyst", "admin"), indexName).execute();
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            assertTrue(
                break;
                .prepareCreate(secondLookupIndex)
        ActionFuture<SearchResponse> blockedSearch;
import org.opensearch.wlm.stats.WorkloadGroupStats.WorkloadGroupStatsHolder;
        String workloadGroupId = "wlm_throttle_group";
            assertTrue("workload group not yet applied in cluster state", present);
        SearchResponse twoLevel = client().prepareSearch(indexName)
import org.opensearch.rule.RuleFrameworkPlugin;
        assertNotNull(bobBlocked.actionGet(TIMEOUT));
import org.opensearch.action.search.SearchRequestBuilder;
/**
        // Wait for rule propagation: a search tagged as alice must reach the group before the concurrency scenario.
    }
        }, 30, TimeUnit.SECONDS);
            Throwable rejection = expectThrows(Throwable.class, () -> blockingSearch(indexName).execute().actionGet(TIMEOUT));
        public List<ActionFilter> getActionFilters() {
    }
            int before = getCompletions(workloadGroupId);
        } finally {
            ruleName,
import org.opensearch.rule.RulePersistenceServiceRegistry;
import org.opensearch.action.index.IndexResponse;
        TermsLookup innerLookup = new TermsLookup(secondLookupIndex, null, "uid", QueryBuilders.matchAllQuery());
    public void testRoleThrottlingKeepsPerRoleBuckets() throws Exception {
package org.opensearch.plugin.wlm;
                    blocked += plugin.hits.get();
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
            int throttledBefore = getThrottled(workloadGroupId);
                Map.of(ResourceType.CPU, 0.9, ResourceType.MEMORY, 0.9),
                .indices()
    }
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
        for (String role : roles) {
            .setId("1")
import java.util.function.ToLongFunction;
        // Matches no rule, so the nested search inherits the outer request's group and bucket.
import org.opensearch.search.lookup.LeafFieldsLookup;
        }
        @Override
            try {
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("user_throttle_test_group", workloadGroupId, 1, "username");
            int after = getCompletions(workloadGroupId);
 *
                .cluster()
                    Req request,
            assertTrue(
            Throwable rejection = expectThrows(Throwable.class, () -> blockingSearchAs("alice", indexName).execute().actionGet(TIMEOUT));
        setWlmMode("enabled");
            ),
     * {@code onRequestEnd}/{@code onRequestFailure}; a throttle rejection must never touch it.
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
                hits.incrementAndGet();
     * Stands in for the security plugin's principal extractor. Registers a test-only header as both a REST header and a
        // Two levels: the exempt middle search must pass its parent's charge on to the grandchild.
        // Rule propagation is async; wait until searches are tagged to the group.
    /**
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
            Instant.now().getMillis()
    /**
        plugins.add(ScriptedBlockPlugin.class);
        assertNotNull(carolBlocked.actionGet(TIMEOUT));
        for (ScriptedBlockPlugin plugin : plugins) {
    public void testUsernameThrottlingKeepsPerUserBuckets() throws Exception {
                    inFlightBefore,
            .setId("1")
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
            .setSize(1)
        assertNotNull(blockedSearch.actionGet(TIMEOUT));
 * The OpenSearch Contributors require contributions made to
        assertBusy(() -> {
            .setQuery(QueryBuilders.termsLookupQuery("field", outerLookup))
        String indexName = "scroll_throttle_index";
/*
        setWlmMode("enabled");
            bobBlocked = blockingSearchAs("bob", indexName).execute();
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        String lookupIndex = "lookupidx";
        }
                .metadata()
public class WlmNodeThrottlingIT extends OpenSearchIntegTestCase {
            if (cur.getCause() == cur) {
import java.util.concurrent.atomic.AtomicInteger;
            });
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    }
            assertEquals("total_throttled should increment by exactly one", throttledBefore + 1, getThrottled(workloadGroupId));
        assertEquals(DocWriteResponse.Result.CREATED, response.getResult());
    private Client clientAs(String username) {
import java.util.HashSet;
        String ruleId = "wlm_nested_rule";
            .setQuery(QueryBuilders.matchAllQuery())
                    "in-flight search gauge must exclude the throttle-rejected request",
                @Override
        }
        // The registry is JVM-static but each test gets a new cluster, so re-register this cluster's feature type.
import org.opensearch.plugins.ActionPlugin;
import org.opensearch.action.support.WriteRequest;
     * IT exercises the production plumbing (task field -&gt; throttle admission) instead of simulating it.
        String indexName = "throttle_index";
    private void indexDocument(String indexName) {
import org.opensearch.script.MockScriptPlugin;
            int throttledBefore = getThrottled(workloadGroupId);
    public static class ScriptedBlockPlugin extends MockScriptPlugin {
        ActionFuture<SearchResponse> aliceBlocked;
        return clientAs(username).prepareSearch(indexName)
    }
        plugins.add(RuleFrameworkPlugin.class);
    }
        );
                hasRejectedExecutionCause(rejection)
                blockedSearch = blockingSearch(indexName).execute();
            assertTrue("workload group not yet applied in cluster state", present);
                for (ScriptedBlockPlugin plugin : plugins) {
        }
            aliceBlocked = blockingSearchWithPrincipal(principal("alice", "analyst"), indexName).execute();
                // A scroll continuation must be throttled too, or ?scroll= would bypass node_limit.
        String workloadGroupId = "wlm_user_throttle_group";
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    private WorkloadGroup createThrottledWorkloadGroup(String name, String id, int nodeLimit, String by) {
        }
        return false;
import org.opensearch.core.action.ActionListener;
    private int getCompletions(String groupId) throws Exception {
        assertBusy(() -> {
                int throttledBefore = getThrottled(workloadGroupId);
        client().execute(
        }
        return total;
import java.util.List;
        );
        WlmStatsResponse response = client().execute(WlmStatsAction.INSTANCE, request).get();
            );
                ) {
            // alice's first search blocks in the query phase, holding her single per-user permit.
            assertTrue(
                throttling.build()
            new WlmAutoTaggingIT.TestClusterUpdateRequest(workloadGroup, method),
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);
        client().prepareIndex(secondLookupIndex)
                int blocked = 0;
            plugins.addAll(pluginsService.filterPlugins(ScriptedBlockPlugin.class));
        Settings.Builder builder = Settings.builder().putNull(WorkloadManagementSettings.WLM_MODE_SETTING.getKey());
        AutoTaggingRegistry.registerFeatureType(featureType);
            name,
import org.joda.time.Instant;
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("role_throttle_test_group", workloadGroupId, 1, "role");
    // Helpers
        static final String SCRIPT_NAME = "search_block";
        IndexResponse response = client().prepareIndex(indexName)
                client().admin().cluster().prepareState().get().getState().metadata().workloadGroups().containsKey(workloadGroupId)
import static org.hamcrest.Matchers.greaterThan;
            boolean present = client().admin()
        // Open a scroll context with a cheap query so the initial search releases its permit immediately.
                public int order() {
            WlmAutoTaggingIT.TestClusterUpdateTransportAction.ACTION,
        assertAcked(client().admin().cluster().updateSettings(request).get());
     * Sums one stat for a workload group across every node's WLM stats, read from the response objects directly. The
        int throttledBefore = getThrottled(workloadGroupId);
    private static boolean hasRejectedExecutionCause(Throwable t) {
            throw new AssertionError("cluster-state update failed", listener.getException());
            return Collections.singletonMap(SCRIPT_NAME, params -> {
        for (ScriptedBlockPlugin plugin : plugins) {
            disableBlocks(plugins);
    }
            .setSource(Map.of("uid", "value"))
                return true;
 */
            plugin.enableBlock();
        setWlmMode("enabled");
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
     * Test script plugin that blocks during the query phase until released, keeping a search in-flight.
        String indexName = "orders";
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        assertEquals(RestStatus.OK, response.status());
            Instant.now().toString()
    }
            }
            );
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
                hasRejectedExecutionCause(rejection)
            disableBlocks(plugins);
            if (holder != null) {
        FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
import java.util.concurrent.TimeUnit;
        String workloadGroupId = "wlm_scroll_throttle_group";
            // Same role as alice, so same bucket.
            );
        for (WlmStats nodeStats : response.getNodes()) {
            assertTrue("Expected search to be tagged to the throttled workload group", getCompletions(workloadGroupId) > before);
            Throwable rejection = expectThrows(Throwable.class, () -> blockingSearch(indexName).execute().actionGet(TIMEOUT));
                "an independent concurrent request must still be throttled but was: " + rejection,
            .actionGet(TIMEOUT);
            // Holds the only permit.
                assertTrue("Expected a scroll continuation to be throttled but was: " + rejection, hasRejectedExecutionCause(rejection));
            .get();
     * task header, then copies it onto the task's throttle principal exactly as the real auto-tagging filter does, so the
                    // Outlast callers' 30s assertBusy waits; the 10s default would fail inside an unrelated assertion.
            shouldBlock.set(true);
    }
            shouldBlock.set(false);
            int after = getCompletions(workloadGroupId);
                TimeUnit.SECONDS
            plugin.disableBlock();
            // Second search while the first is still in-flight: must be rejected (429).
    }
        indexDocument(indexName);
    @After
        // A terms lookup with a subquery runs a nested search during rewrite; the outer request already paid.
                assertThat("bob's search should have been admitted and reached the blocking script", blocked, greaterThan(1));
                Settings.EMPTY,
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
            return List.of(new ActionFilter() {
        createRule(ruleId, "user throttle rule", indexName, featureType, workloadGroupId);
            clientWithPrincipal(principal("alice", "analyst")).prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
     */
                    ActionListener<Resp> listener,
 * {@code TransportSearchAction} through auto-tagging, not a mocked service.
        WorkloadGroup workloadGroup = createThrottledWorkloadGroup("scroll_throttle_test_group", workloadGroupId, 1);
        assertBusy(
                total += extractor.applyAsLong(holder);
        for (String node : internalCluster().getNodeNames()) {
     * across all data nodes. This is the counter incremented in {@code onRequestStart} and decremented in
        return Math.toIntExact(total);
        }
        );
import org.opensearch.rule.RuleRoutingServiceRegistry;
import org.opensearch.rule.RuleAttribute;
import org.opensearch.wlm.WorkloadGroupTask;
        Settings.Builder settings = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), mode);
            awaitForBlock(plugins);
    private int sumGroupStat(String groupId, ToLongFunction<WorkloadGroupStatsHolder> extractor) throws Exception {
        return sumGroupStat(groupId, WorkloadGroupStatsHolder::getThrottled);
            awaitForBlock(plugins);
            assertEquals("total_throttled should increment by exactly one", throttledBefore + 1, getThrottled(workloadGroupId));
    private SearchRequestBuilder searchAs(String username, String indexName) {
            awaitForBlock(plugins);
            return List.of(TEST_PRINCIPAL_HEADER);
 * The scripted-block plugin holds a search in-flight (occupying a throttle permit) so that a second concurrent
            int after = getCompletions(workloadGroupId);
        createRule(ruleId, "scroll throttle rule", indexName, featureType, workloadGroupId);
 * search deterministically exceeds the node limit and must be rejected with a 429
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(settings);
            assertTrue("Expected search to be tagged to the throttled workload group", after > before);
        assertEquals("a nested rewrite search must not be counted as throttled", throttledBefore, getThrottled(workloadGroupId));
                } catch (Exception e) {
            assertBusy(() -> {
        String ruleId = "wlm_role_throttle_rule";
                .getState()
        }, 30, TimeUnit.SECONDS);
                public <Req extends ActionRequest, Resp extends ActionResponse> void apply(
            int blocked = 0;
        }
    }
        }
    private static final TimeValue TIMEOUT = new TimeValue(30, TimeUnit.SECONDS);
        String ruleId = "wlm_user_throttle_rule";
import org.opensearch.action.support.ActionFilterChain;
        }
        return clientAs(username).prepareSearch(indexName);
import org.opensearch.action.support.ActionFilter;
        } finally {
                "workload group not yet applied in cluster state",
    public void testSecondConcurrentSearchRejectedWhenNodeLimitReached() throws Exception {
        }
            }
        updateWorkloadGroupInClusterState(PUT, workloadGroup);
import java.util.Map;
            .get();
        // node_limit=1: the outer search holds the only permit while its rewrite issues a nested search to the same bucket.
import org.opensearch.tasks.Task;
                );
                awaitForBlock(plugins);
                    throw new RuntimeException(e);
                hasRejectedExecutionCause(rejection)
        String scrollId = client().prepareSearch(indexName)
            hits.set(0);
                .prepareState()
            }
        indexDocument(indexName);
            assertNotNull(client().prepareSearchScroll(sid).setScroll(TIMEOUT).get());
import org.opensearch.action.search.SearchRequestStats;
import org.opensearch.cluster.metadata.WorkloadGroup;
        WlmStatsRequest request = new WlmStatsRequest(null, new HashSet<>(Collections.singletonList(groupId)), null);
        }
            int before = getCompletions(workloadGroupId);
            disableBlocks(plugins);
            client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            ActionFuture<SearchResponse> blockedSearch;
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.rest.RestHeaderDefinition;
        indexDocument(indexName);
            // Proves the rejection was the throttle, not a broken scroll context.
        try {
        }
            plugin.reset();
                        }
            RuleRoutingServiceRegistry routingRegistry = internalCluster().getInstance(RuleRoutingServiceRegistry.class, node);
    /**
    }
    private void awaitForBlock(List<ScriptedBlockPlugin> plugins) throws Exception {
        );
import org.opensearch.common.settings.Settings;
        assertEquals(
    @Override
import org.opensearch.rule.autotagging.FeatureType;
        String indexName = "role_throttle_index";
import java.util.function.Function;
        return clientWithPrincipal(principal).prepareSearch(indexName)
import org.opensearch.action.DocWriteResponse;
        assertAcked(
    private SearchRequestBuilder blockingSearchAs(String username, String indexName) {
        public void reset() {
