        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(randomIndicesOrAliases);
        List<String> indices = new ArrayList<>();
        for (int i = 0; i < numIndices; i++) {
        clearInterceptedActions();
        public static class TestPlugin extends Plugin implements NetworkPlugin {
            String indexOrAlias = randomIndexOrAlias();
import org.opensearch.action.admin.indices.mapping.get.GetMappingsAction;
        }
import org.opensearch.action.search.SearchTransportService;
        IndexRequest indexRequest = new IndexRequest(randomIndexOrAlias()).id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
            @Override
        String[] updateShardActions = new String[] { UpdateAction.NAME + "[s]", BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
        assertIndicesSubset(indices, multiTermVectorsShardAction);
        internalCluster().coordOnlyNodeClient().admin().indices().open(openIndexRequest).actionGet();
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
        assertSameIndicesOptionalRequests(searchRequest, SearchTransportService.FREE_CONTEXT_ACTION_NAME);
import org.opensearch.action.admin.indices.segments.IndicesSegmentsAction;
        for (String action : actions) {
    }
        SearchRequest searchRequest = new SearchRequest(randomIndicesOrAliases).searchType(SearchType.QUERY_THEN_FETCH);
import org.opensearch.plugins.Plugin;
        }
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
        ) {
        assertSameIndices(searchRequest, SearchTransportService.QUERY_ACTION_NAME, SearchTransportService.FETCH_ID_ACTION_NAME);
            client().admin().cluster().prepareState().get().getState(),
    public void testUpdateSettings() {
        String[] indices = new String[uniqueIndices.length];
        assertAcked(internalCluster().coordOnlyNodeClient().admin().indices().delete(deleteIndexRequest).actionGet());
        interceptTransportActions(updateShardActions);
        // indices returned by each bulk shard request need to be a subset of the original indices
                .clearInterceptedActions();
        assertSameIndices(
    private static void assertSameIndicesOptionalRequests(IndicesRequest originalRequest, String... actions) {
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
        String termVectorShardAction = TermVectorsAction.NAME + "[s]";
            return requests.remove(action);
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
    }
import static org.hamcrest.Matchers.emptyIterable;
        List<TransportRequest> requests = consumeTransportRequests(action);
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequest;
        for (String action : actions) {
        String[] uniqueIndices = randomUniqueIndices();
 * GitHub history for details.
        interceptTransportActions(updateShardActions);
    }
            List<TransportRequest> requests = consumeTransportRequests(action);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        clearInterceptedActions();
        interceptTransportActions(bulkShardActions);
        for (int i = 0; i < randomIndicesOrAliases.length; i++) {
    public void testRecovery() {
        internalCluster().coordOnlyNodeClient().admin().indices().segmentReplicationStats(segmentReplicationStatsRequest).actionGet();
        String explainShardAction = ExplainAction.NAME + "[s]";
        int numIndices = iterations(1, 5);
        }
import java.util.HashSet;
    }
        RecoveryRequest recoveryRequest = new RecoveryRequest(randomIndicesOrAliases());
        clearInterceptedActions();
        assertSameIndices(getFieldMappingsRequest, getFieldMappingsShardAction);
        int i = 0;
        clearInterceptedActions();
        assertSameIndices(originalRequest, true, actions);
@ClusterScope(scope = Scope.SUITE, numClientNodes = 1, minNumDataNodes = 2)
        return indicesRequest;
        SearchResponse searchResponse = internalCluster().coordOnlyNodeClient().search(searchRequest).actionGet();
import java.util.Collection;
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(randomIndicesOrAliases());
import org.opensearch.script.ScriptType;
        interceptTransportActions(indexShardActions);
        internalCluster().coordOnlyNodeClient().admin().indices().recoveries(recoveryRequest).actionGet();
        int count = randomIntBetween(1, indices.size() * 2); // every index has an alias
        PutMappingRequest putMappingRequest = new PutMappingRequest(randomUniqueIndicesOrAliases()).source("field", "type=text");
    }
            indices.add("test" + i);
        fieldCapabilitiesRequest.fields(randomAlphaOfLength(8));
import org.opensearch.action.update.UpdateRequest;
        UpdateResponse updateResponse = internalCluster().coordOnlyNodeClient().update(updateRequest).actionGet();
    public void testMultiGet() {
import org.opensearch.tasks.Task;
                .get().instance.consumeRequests(action);
            SearchTransportService.QUERY_ID_ACTION_NAME,
import org.opensearch.script.MockScriptPlugin;
    public void cleanUp() {
                ThreadContext threadContext
    protected int minimumNumberOfShards() {
        );
        clearInterceptedActions();
import org.opensearch.action.search.SearchType;
        interceptTransportActions(CloseIndexAction.NAME);
            SearchTransportService.FETCH_ID_ACTION_NAME
        if (randomBoolean()) {
        getFieldMappingsRequest.indices(randomIndicesOrAliases());
            String indexOrAlias = randomIndexOrAlias();
    private static void assertIndicesSubset(List<String> indices, String... actions) {
            flushRequest
        interceptTransportActions(DeleteIndexAction.NAME);
        interceptTransportActions(indexShardActions);
                        List<TransportRequest> requestList = requests.get(action);
    public void testExplain() {
        private final Map<String, List<TransportRequest>> requests = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        }
        int count = randomIntBetween(1, this.indices.size());
        assertSameIndices(updateRequest, updateShardActions);
            indices.add(indexOrAlias);
    }
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(randomUniqueIndicesOrAliases());
        assertAllRequestsHaveBeenConsumed();
    public void setup() {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
 * license agreements. See the NOTICE file distributed with
        }
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
    }
                            requestList.add(request);
    public void testOpenIndex() {
        internalCluster().coordOnlyNodeClient().explain(explainRequest).actionGet();
        String[] indexShardActions = new String[] {
        clearInterceptedActions();
        Set<String> uniqueIndices = new HashSet<>();
        synchronized List<TransportRequest> consumeRequests(String action) {
                        if (requestList == null) {
        indices.clear();
            if (transportRequests != null) {
        // so we are able to intercept those messages and check them
        IndicesSegmentsRequest segmentsRequest = new IndicesSegmentsRequest(randomIndicesOrAliases());
    }
                }
            Set<Map.Entry<String, List<TransportRequest>>> entries = pluginsService.filterPlugins(
import java.util.List;
            Collections.addAll(this.actions, actions);
        int numDeleteRequests = iterations(1, 10);
    public void testSegmentReplicationStats() {
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
import org.opensearch.common.settings.Settings;
            assertAcked(prepareCreate(index).addAlias(new Alias(index + "-alias")));
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
    public void testUpdateUpsert() {
import org.junit.Before;
            bulkRequest.add(new IndexRequest(indexOrAlias).id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            SearchTransportService.QUERY_ACTION_NAME,
        );
            client().admin().cluster().prepareState().get().getState(),
            return index + "-alias";
        interceptTransportActions(recoveryAction);
            SearchTransportService.FETCH_ID_ACTION_NAME,
            TransportShardFlushAction.NAME + "[p]" };
 * compatible open source license.
        assertNoFailures(searchResponse);
/*
        assertSameIndices(deleteIndexRequest, DeleteIndexAction.NAME);
        internalCluster().coordOnlyNodeClient().index(indexRequest).actionGet();
import org.opensearch.action.update.UpdateAction;
        }
        interceptTransportActions(
package org.opensearch.action;
    public void testUpdate() {
        RefreshRequest refreshRequest = new RefreshRequest(randomIndicesOrAliases());
                        } else {
            }
        interceptTransportActions(getFieldMappingsShardAction);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        interceptTransportActions(UpdateSettingsAction.NAME);
            // InternalClusterInfoService sends IndicesStatsRequest periodically which messes with this test
        }
            uniqueIndices.add(randomFrom(this.indices));
        clearInterceptedActions();
import java.util.function.Function;
        assertSameIndices(mergeRequest, mergeShardAction);
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
    public void testGetMappings() {
import org.opensearch.action.support.clustermanager.term.GetTermVersionRequest;
        clearInterceptedActions();
            indices[i++] = randomBoolean() ? index + "-alias" : index;
 * this work for additional information regarding copyright
    private static void assertAllRequestsHaveBeenConsumed() {
        );
            public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
        assertSameIndices(recoveryRequest, recoveryAction);
        assertSameIndices(segmentReplicationStatsRequest, segmentReplicationAction);
        internalCluster().coordOnlyNodeClient().multiGet(multiGetRequest).actionGet();
        int numIndexRequests = iterations(1, 10);
                this.requestHandler = requestHandler;
import org.opensearch.action.delete.DeleteRequest;
        );
import org.opensearch.action.get.MultiGetAction;
    private String randomIndexOrAlias() {
        assertSameIndices(analyzeRequest, analyzeShardAction);
                requests.addAll(transportRequests);
    }
                assertThat(indicesRequest.indicesOptions(), equalTo(originalRequest.indicesOptions()));
    public static class CustomScriptPlugin extends MockScriptPlugin {
        String[] indices = new String[count];
        for (String index : indices) {
import org.opensearch.action.termvectors.MultiTermVectorsAction;
    }
        interceptTransportActions(explainShardAction);
        clearInterceptedActions();
    public void testCloseIndex() {
        clearInterceptedActions();
    @Override
import org.opensearch.action.admin.indices.flush.TransportShardFlushAction;
 */
            client().prepareIndex(randomIndicesOrAliases[i]).setId("id-" + i).setSource("field", "value").get();
        final IndicesRequest indicesRequest;
            indicesRequest = (IndicesRequest) request;
        } else {
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
                for (String index : indicesRequest.indices()) {
        }
        }
            InterceptingRequestHandler(String action, TransportRequestHandler<T> requestHandler) {
        }
        } else {
        interceptTransportActions(segmentReplicationAction);
        assertActionInvocation(GetTermVersionAction.NAME, GetTermVersionRequest.class);
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        GetFieldMappingsRequest getFieldMappingsRequest = new GetFieldMappingsRequest();
            public final InterceptingTransportService instance = new InterceptingTransportService();
        while (uniqueIndices.size() < count) {
                synchronized (InterceptingTransportService.this) {
        interceptTransportActions(
            indices.add(indexOrAlias);
        String[] deleteShardActions = new String[] { BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
        synchronized void clearInterceptedActions() {
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThan(0L));
        // update action goes to the primary, index op gets executed locally, then replicated
        assertSameIndices(updateRequest, updateShardActions);
        String[] updateShardActions = new String[] { UpdateAction.NAME + "[s]", BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
                        }
        assertSameIndices(closeIndexRequest, CloseIndexAction.NAME);
        String segmentReplicationAction = SegmentReplicationStatsAction.NAME + "[n]";
        );
        assertSameIndices(updateSettingsRequest, UpdateSettingsAction.NAME);
    @After
    }
        internalCluster().coordOnlyNodeClient().admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
    protected int minimumNumberOfReplicas() {
        assertSameIndices(originalRequest, false, actions);
import org.opensearch.action.bulk.BulkAction;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }
import org.opensearch.action.fieldcaps.FieldCapabilitiesAction;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        clearInterceptedActions();
        clearInterceptedActions();
        }
            List<TransportRequest> requests = consumeTransportRequests(action);
        clearInterceptedActions();
        interceptTransportActions(clearCacheAction);
            multiGetRequest.add(indexOrAlias, Integer.toString(i));
    private String[] randomUniqueIndices() {
    }
import org.opensearch.action.update.UpdateResponse;
            bulkRequest.add(new DeleteRequest(indexOrAlias).id("id"));
    private String[] randomIndicesOrAliases() {
        assertSameIndices(explainRequest, explainShardAction);
                .stream()
        clearInterceptedActions();
            SearchTransportService.QUERY_ID_ACTION_NAME,
import org.opensearch.action.support.replication.TransportReplicationActionTests;
            multiTermVectorsRequest.add(indexOrAlias, Integer.toString(i));
import org.opensearch.transport.client.Requests;
 */
    }
        @Override
        interceptTransportActions(OpenIndexAction.NAME);
        for (PluginsService pluginsService : pluginsServices) {
import org.opensearch.action.termvectors.TermVectorsRequest;
        private final Set<String> actions = new HashSet<>();
        clearInterceptedActions();
            TransportShardFlushAction.NAME,
        fieldCapabilitiesRequest.indices(randomIndicesOrAliases());
        internalCluster().coordOnlyNodeClient().admin().indices().putMapping(putMappingRequest).actionGet();
        String segmentsAction = IndicesSegmentsAction.NAME + "[n]";
    }
        clearInterceptedActions();
        }
            SearchTransportService.FETCH_ID_ACTION_NAME,
        assertSameIndices(getSettingsRequest, GetSettingsAction.NAME);
            SearchTransportService.DFS_ACTION_NAME,
        assertNoActionInvocation(GetMappingsAction.NAME);
        for (int i = 0; i < numUpdateRequests; i++) {
 * software distributed under the License is distributed on an
import org.opensearch.index.query.QueryBuilders;
    }
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
 * Modifications Copyright OpenSearch Contributors. See
        interceptTransportActions(PutMappingAction.NAME);
        String multiTermVectorsShardAction = MultiTermVectorsAction.NAME + "[shard][s]";
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        List<String> indices = new ArrayList<>();
        List<TransportRequest> requests = new ArrayList<>();
        internalCluster().coordOnlyNodeClient().admin().indices().getFieldMappings(getFieldMappingsRequest).actionGet();
        }
    }
        clearInterceptedActions();
        for (int i = 0; i < numDeleteRequests; i++) {
        int numDocs = iterations(1, 30);
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
                            requestList.add(request);
        internalCluster().coordOnlyNodeClient().get(getRequest).actionGet();
    public void testFieldCapabilities() {
        }
    public void testSearchQueryThenFetch() throws Exception {
    }
            assertTrue(requests.isEmpty());
        }
            TransportShardRefreshAction.NAME + "[p]" };
            .put("cluster.routing.allocation.disk.threshold_enabled", false)
                            requestList = new ArrayList<>();
            String indexOrAlias = randomIndexOrAlias();
        clearInterceptedActions();
            return new InterceptingRequestHandler<>(action, actualHandler);
    public void testBulk() {
        return requests;
        }
    }
    }
            String indexOrAlias = randomIndexOrAlias();
    }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
import org.junit.After;
        TermVectorsRequest termVectorsRequest = new TermVectorsRequest(randomIndexOrAlias(), "id");
    public void testSearchDfsQueryThenFetch() throws Exception {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.transport.TransportRequestHandler;
import static org.hamcrest.Matchers.hasItem;
        assertEquals(DocWriteResponse.Result.DELETED, updateResponse.getResult());
        for (int i = 0; i < randomIndicesOrAliases.length; i++) {
            TransportRequestHandler<T> actualHandler
    @Override
    }
        internalCluster().coordOnlyNodeClient().admin().indices().close(closeIndexRequest).actionGet();
            boolean forceExecution,
        interceptTransportActions(multiTermVectorsShardAction);
    private final List<String> indices = new ArrayList<>();
    }
                assertThat(internalRequest.getClass().getName(), indicesRequest.indices(), equalTo(originalRequest.indices()));
        @Override
    private static void assertActionInvocation(String action, Class<? extends TransportRequest> requestClass) {
    @Override
                this.action = action;
        clearInterceptedActions();
        interceptTransportActions(validateQueryShardAction);
        assertEquals(DocWriteResponse.Result.CREATED, updateResponse.getResult());
        int numUpdateRequests = iterations(1, 10);
    public void testAnalyze() {
        for (String action : actions) {
import org.opensearch.transport.TransportInterceptor;
    }
        interceptTransportActions(indicesStats);
    }
    public void testGet() {
                IndicesRequest indicesRequest = convertRequest(internalRequest);
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        interceptTransportActions(GetTermVersionAction.NAME, GetMappingsAction.NAME);
        String analyzeShardAction = AnalyzeAction.NAME + "[s]";
        String indexOrAlias = randomIndexOrAlias();
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.transport.TransportRequest;
            ) {
        return 2;
/*
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
            indices.add(indexOrAlias);
    }
    }
            for (TransportRequest internalRequest : requests) {
    }
 *
            searchRequest,
import org.opensearch.action.index.IndexRequest;
    @Override
        assertSameIndices(validateQueryRequest, validateQueryShardAction);
        AnalyzeAction.Request analyzeRequest = new AnalyzeAction.Request(randomIndexOrAlias());
 * KIND, either express or implied.  See the License for the
        FlushRequest flushRequest = new FlushRequest(randomIndicesOrAliases());
import static org.hamcrest.Matchers.greaterThan;
            return Collections.singletonMap("ctx.op='delete'", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "delete"));
                requestHandler.messageReceived(request, channel, task);
    public static class InterceptingTransportService implements TransportInterceptor {
        interceptTransportActions(updateShardActions);
import org.opensearch.test.OpenSearchIntegTestCase;
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(randomIndicesOrAliases()).settings(
        int numDocs = iterations(1, 30);
        SegmentReplicationStatsRequest segmentReplicationStatsRequest = new SegmentReplicationStatsRequest(randomIndicesOrAliases());
        internalCluster().coordOnlyNodeClient().admin().indices().updateSettings(updateSettingsRequest).actionGet();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            private final TransportRequestHandler<T> requestHandler;
        // makes sure that write operations get sent to the replica as well
        refresh();
        internalCluster().coordOnlyNodeClient().admin().indices().refresh(refreshRequest).actionGet();
        interceptTransportActions(multiGetShardAction);
 * Unless required by applicable law or agreed to in writing,
    public void testTermVector() {
import org.opensearch.action.search.SearchResponse;
        internalCluster().coordOnlyNodeClient().admin().indices().segments(segmentsRequest).actionGet();
    }
import java.util.ArrayList;
        UpdateRequest updateRequest = new UpdateRequest(indexOrAlias, "id").upsert(Requests.INDEX_CONTENT_TYPE, "field", "value")
        return Arrays.asList(InterceptingTransportService.TestPlugin.class, CustomScriptPlugin.class);
import java.util.Collections;
            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx.op='delete'", Collections.emptyMap())
        UpdateRequest updateRequest = new UpdateRequest(indexOrAlias, "id").doc(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
            indices.add(indexOrAlias);
import java.util.Arrays;
import org.opensearch.action.admin.indices.close.CloseIndexAction;
import org.opensearch.action.explain.ExplainAction;
        // must set this independently of the plugin so it overrides MockTransportService
        assertSameIndices(termVectorsRequest, termVectorShardAction);
        clearInterceptedActions();
    public void testUpdateDelete() {
        String mergeShardAction = ForceMergeAction.NAME + "[n]";
        analyzeRequest.text("text");
        return uniqueIndices.toArray(new String[0]);
    }
        clearInterceptedActions();
        internalCluster().coordOnlyNodeClient().admin().indices().getMappings(getMappingsRequest).actionGet();
            assertThat(entries, emptyIterable());
 * You may obtain a copy of the License at
    public void testSegments() {
    }
        clearInterceptedActions();
            TransportShardFlushAction.NAME + "[r]",
    }
                    if (actions.contains(action)) {
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
        interceptTransportActions(getShardAction);
        clearInterceptedActions();
            indices.add(indexOrAlias);
        }
            .doc(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
    public void testGetSettings() {
import org.opensearch.plugins.PluginsService;
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
import org.opensearch.plugins.NetworkPlugin;
        internalCluster().coordOnlyNodeClient().admin().indices().flush(flushRequest).actionGet();
            for (TransportRequest internalRequest : requests) {
        assertIndicesSubset(indices, multiGetShardAction);
        client().prepareIndex(indexOrAlias).setId("id").setSource("field", "value").get();
        List<String> indices = new ArrayList<>();
        String[] randomIndicesOrAliases = randomIndicesOrAliases();
        @SuppressWarnings("unchecked")
            .build();
        MultiTermVectorsRequest multiTermVectorsRequest = new MultiTermVectorsRequest();
import org.opensearch.common.util.concurrent.ThreadContext;
 */
        internalCluster().coordOnlyNodeClient().admin().indices().stats(indicesStatsRequest).actionGet();
        clearInterceptedActions();
        refresh();
        for (TransportRequest internalRequest : requests) {
        clearInterceptedActions();
        interceptTransportActions(segmentsAction);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
 *
        String[] indexShardActions = new String[] { BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
                .findFirst()
import org.opensearch.action.admin.indices.open.OpenIndexAction;
 * Licensed to Elasticsearch under one or more contributor
                    }
            bulkRequest.add(new UpdateRequest(indexOrAlias, "id").doc(Requests.INDEX_CONTENT_TYPE, "field1", "value1"));
        internalCluster().coordOnlyNodeClient().delete(deleteRequest).actionGet();
            String indexOrAlias = randomIndexOrAlias();
        internalCluster().coordOnlyNodeClient().admin().indices().getSettings(getSettingsRequest).actionGet();
    }
import org.opensearch.action.admin.indices.alias.Alias;
        assertSameIndices(fieldCapabilitiesRequest, fieldCapabilitiesShardAction);
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(randomIndicesOrAliases());
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
    private static List<TransportRequest> consumeTransportRequests(String action) {
 * under the License.
        String fieldCapabilitiesShardAction = FieldCapabilitiesAction.NAME + "[index][s]";
            }
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsAction;
        interceptTransportActions(deleteShardActions);
        assertSameIndices(putMappingRequest, PutMappingAction.NAME);
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
        assertSameIndices(getRequest, getShardAction);
        String index = randomFrom(indices);
    }
        String[] updateShardActions = new String[] { UpdateAction.NAME + "[s]", BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
            @Override
    private static void assertSameIndices(IndicesRequest originalRequest, String... actions) {
    }
        for (PluginsService pluginsService : pluginsServices) {
    }
        internalCluster().coordOnlyNodeClient().bulk(bulkRequest).actionGet();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        // update action goes to the primary, delete op gets executed locally, then replicated
    }
 * not use this file except in compliance with the License.
        ensureGreen();
            client().prepareIndex(randomIndicesOrAliases[i]).setId("id-" + i).setSource("field", "value").get();
    public void testDelete() {
                .interceptTransportActions(actions);
    }
        assertSameIndices(indexRequest, indexShardActions);
        BulkRequest bulkRequest = new BulkRequest();
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
                return Collections.singletonList(instance);
        internalCluster().coordOnlyNodeClient().admin().indices().forceMerge(mergeRequest).actionGet();
                NamedWriteableRegistry namedWriteableRegistry,
    }
    }
        // update action goes to the primary, index op gets executed locally, then replicated
    public void testIndicesStats() {
    private static void clearInterceptedActions() {
}
        );
            // this setting disables it...
        GetRequest getRequest = new GetRequest(randomIndexOrAlias(), "id");
            List<TransportRequest> transportRequests = pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class)
            indicesRequest = TransportReplicationActionTests.resolveRequest(request);
                    assertThat(indices, hasItem(index));
            TransportShardRefreshAction.NAME,
        String[] indices = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)).concreteIndexNames(
        String[] indices = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)).concreteIndexNames(
            List<TransportRequest> requests = consumeTransportRequests(action);
        String multiGetShardAction = MultiGetAction.NAME + "[shard][s]";
        clearInterceptedActions();
            if (!optional) {
            String action,
        SearchResponse searchResponse = internalCluster().coordOnlyNodeClient().search(searchRequest).actionGet();
        assertSameIndices(openIndexRequest, OpenIndexAction.NAME);
            }
        return 1;
        String clearCacheAction = ClearIndicesCacheAction.NAME + "[n]";
            private final String action;
        }
import static org.hamcrest.Matchers.equalTo;
        assertIndicesSubset(Arrays.asList(indices), indexShardActions);
        internalCluster().coordOnlyNodeClient().termVectors(termVectorsRequest).actionGet();
        assertSameIndices(segmentsRequest, segmentsAction);
        );
import java.util.Map;
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsAction;
        assertSameIndices(clearIndicesCacheRequest, clearCacheAction);
        FieldCapabilitiesRequest fieldCapabilitiesRequest = new FieldCapabilitiesRequest();
import org.opensearch.action.get.GetAction;
        }
        clearInterceptedActions();
import org.opensearch.action.admin.indices.flush.FlushRequest;
        private class InterceptingRequestHandler<T extends TransportRequest> implements TransportRequestHandler<T> {
        for (int i = 0; i < numIndexRequests; i++) {
import org.opensearch.action.explain.ExplainRequest;
        String indexOrAlias = randomIndexOrAlias();
    private static void assertSameIndices(IndicesRequest originalRequest, boolean optional, String... actions) {
        for (int i = 0; i < count; i++) {
        ExplainRequest explainRequest = new ExplainRequest(randomIndexOrAlias(), "id").query(QueryBuilders.matchAllQuery());
        assertSameIndices(deleteRequest, deleteShardActions);
            SearchTransportService.FREE_CONTEXT_ACTION_NAME
        internalCluster().coordOnlyNodeClient().admin().indices().analyze(analyzeRequest).actionGet();
        UpdateResponse updateResponse = internalCluster().coordOnlyNodeClient().update(updateRequest).actionGet();
            indices[i] = randomIndexOrAlias();
public class IndicesRequestIT extends OpenSearchIntegTestCase {
    public void testIndex() {
import org.opensearch.action.admin.indices.settings.get.GetSettingsAction;
        interceptTransportActions(mergeShardAction);
    public void testRefresh() {
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(randomUniqueIndicesOrAliases());
        ForceMergeRequest mergeRequest = new ForceMergeRequest(randomIndicesOrAliases());
        interceptTransportActions(analyzeShardAction);
    public void testValidateQuery() {
        assertFalse(requests.isEmpty());
        SearchRequest searchRequest = new SearchRequest(randomIndicesOrAliases).searchType(SearchType.DFS_QUERY_THEN_FETCH);
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThan(0L));
        String validateQueryShardAction = ValidateQueryAction.NAME + "[s]";
        String getFieldMappingsShardAction = GetFieldMappingsAction.NAME + "[index][s]";
        String[] bulkShardActions = new String[] { BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
    public void testDeleteIndex() {
import org.opensearch.script.Script;
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
        return Settings.builder()
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // free context messages are not necessarily sent, but if they are, check their indices
 *
            .put(super.nodeSettings(ordinal))
            Settings.builder().put("refresh_interval", -1)
            assertTrue(internalRequest.getClass() == requestClass);
    protected Settings nodeSettings(int ordinal) {
        String[] indexShardActions = new String[] {
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
    private static void assertNoActionInvocation(String... actions) {
    }
        interceptTransportActions(fieldCapabilitiesShardAction);
        assertIndicesSubset(Arrays.asList(indices), indexShardActions);
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
        }
 * ownership. Elasticsearch licenses this file to you under
        return indices;
import org.opensearch.action.admin.indices.recovery.RecoveryAction;
        String[] randomIndicesOrAliases = randomUniqueIndices();
                InterceptingTransportService.TestPlugin.class
        UpdateRequest updateRequest = new UpdateRequest(indexOrAlias, "id").script(
            }
        clearInterceptedActions();
                            requests.put(action, requestList);
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
        assertIndicesSubset(indices, bulkShardActions);
                assertThat("no internal requests intercepted for action [" + action + "]", requests.size(), greaterThan(0));
    static IndicesRequest convertRequest(TransportRequest request) {
        if (request instanceof IndicesRequest) {
    }
        interceptTransportActions(termVectorShardAction);
        clearInterceptedActions();
        interceptTransportActions(indexShardActions);
    public void testFlush() {
        UpdateResponse updateResponse = internalCluster().coordOnlyNodeClient().update(updateRequest).actionGet();
        String[] randomIndicesOrAliases = randomIndicesOrAliases();
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            TransportShardRefreshAction.NAME + "[r]",
        interceptTransportActions(GetSettingsAction.NAME);
            ).stream().findFirst().get().instance.requests.entrySet();
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        for (PluginsService pluginsService : pluginsServices) {
import org.opensearch.action.termvectors.TermVectorsAction;
            String executor,
                }
    public void testMultiTermVector() {
    public void testForceMerge() {
    public void testGetFieldMappings() {
    }
        assertSameIndices(updateRequest, updateShardActions);
        String indicesStats = IndicesStatsAction.NAME + "[n]";
    }
import org.opensearch.action.get.GetRequest;
        }
    }
        for (PluginsService pluginsService : pluginsServices) {
        assertSameIndices(indicesStatsRequest, indicesStats);
    }
        synchronized void interceptTransportActions(String... actions) {
            }
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
        for (String index : uniqueIndices) {
 * SPDX-License-Identifier: Apache-2.0
            actions.clear();
 * specific language governing permissions and limitations
        }
    }
            refreshRequest
        internalCluster().coordOnlyNodeClient().fieldCaps(fieldCapabilitiesRequest).actionGet();
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        // free context messages are not necessarily sent, but if they are, check their indices
            SearchTransportService.FREE_CONTEXT_ACTION_NAME
        DeleteRequest deleteRequest = new DeleteRequest(randomIndexOrAlias()).id("id");
import java.util.HashMap;
            }
        clearInterceptedActions();
    }
        internalCluster().coordOnlyNodeClient().multiTermVectors(multiTermVectorsRequest).actionGet();
        String recoveryAction = RecoveryAction.NAME + "[n]";
        for (int i = 0; i < numDocs; i++) {
    }
        GetMappingsRequest getMappingsRequest = new GetMappingsRequest().indices(randomIndicesOrAliases());
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest().indices(randomIndicesOrAliases());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    @Before
        }
        }
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsAction;
        String indexOrAlias = randomIndexOrAlias();
            public List<TransportInterceptor> getTransportInterceptors(
        assertNoFailures(searchResponse);
    public void testPutMapping() {
            }
            SearchTransportService.DFS_ACTION_NAME,
        // makes sure that a reduce is always needed when searching
        clearInterceptedActions();
    }
        internalCluster().coordOnlyNodeClient().admin().indices().validateQuery(validateQueryRequest).actionGet();
        clearInterceptedActions();
        return indices;
        String getShardAction = GetAction.NAME + "[s]";
            return index;
    }
    }
        }
import org.opensearch.action.get.MultiGetRequest;
            assertThat("no internal requests intercepted for action [" + action + "]", requests.size(), greaterThan(0));
                IndicesRequest indicesRequest = convertRequest(internalRequest);
        }
import org.opensearch.action.admin.indices.refresh.TransportShardRefreshAction;
        }
    public void testClearCache() {
    private String[] randomUniqueIndicesOrAliases() {
    }
        client().prepareIndex(indexOrAlias).setId("id").setSource("field", "value").get();
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
        assertSameIndicesOptionalRequests(searchRequest, SearchTransportService.FREE_CONTEXT_ACTION_NAME);
        }
import org.opensearch.transport.TransportChannel;
        ValidateQueryRequest validateQueryRequest = new ValidateQueryRequest(randomIndicesOrAliases());
import java.util.Set;
/*
import org.opensearch.action.bulk.BulkRequest;
    private static void interceptTransportActions(String... actions) {
