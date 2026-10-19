    }
        interceptTransportActions(getFieldMappingsShardAction);  
import org.opensearch.action.admin.indices.flush.TransportShardFlushAction;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
import org.opensearch.action.get.GetRequest;  
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
    }
        interceptTransportActions(recoveryAction);  
        // must set this independently of the plugin so it overrides MockTransportService
        }
    }
            InterceptingRequestHandler(String action, TransportRequestHandler<T> requestHandler) {  
    }
import org.opensearch.action.termvectors.MultiTermVectorsRequest;  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                        }
/*  
import org.opensearch.transport.TransportRequestHandler;  
            indices.add(indexOrAlias);  
        }  
        interceptTransportActions(UpdateSettingsAction.NAME);
        assertIndicesSubset(Arrays.asList(indices), indexShardActions);  
        // so we are able to intercept those messages and check them
        clearInterceptedActions();  
        for (int i = 0; i < randomIndicesOrAliases.length; i++) {
        internalCluster().coordOnlyNodeClient().admin().indices().segments(segmentsRequest).actionGet();
        public static class TestPlugin extends Plugin implements NetworkPlugin {  
        assertEquals(DocWriteResponse.Result.CREATED, updateResponse.getResult());  
                .get().instance.consumeRequests(action);
    }  
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest().indices(randomIndicesOrAliases());
        return indices;  
        PutMappingRequest putMappingRequest = new PutMappingRequest(randomUniqueIndicesOrAliases()).source("field", "type=text");
    private String[] randomIndicesOrAliases() {
import java.util.HashMap;  
import org.junit.After;
    }
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        for (String index : indices) {  
import org.opensearch.action.explain.ExplainAction;
            assertTrue(requests.isEmpty());
import org.opensearch.action.delete.DeleteRequest;  
        interceptTransportActions(updateShardActions);  
        }
            return requests.remove(action);
        UpdateRequest updateRequest = new UpdateRequest(indexOrAlias, "id").script(
            String indexOrAlias = randomIndexOrAlias();
                .interceptTransportActions(actions);
        }  
        for (String index : uniqueIndices) {  
import org.opensearch.test.OpenSearchIntegTestCase;  
package org.opensearch.action;
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(randomIndicesOrAliases());  
import org.opensearch.index.query.QueryBuilders;
    }
            }
        Set<String> uniqueIndices = new HashSet<>();
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
import java.util.HashSet;
        clearInterceptedActions();
        SearchResponse searchResponse = internalCluster().coordOnlyNodeClient().search(searchRequest).actionGet();  
        interceptTransportActions(indicesStats);  
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
    public void setup() {
        interceptTransportActions(termVectorShardAction);  
        }  
        clearInterceptedActions();
        SearchRequest searchRequest = new SearchRequest(randomIndicesOrAliases).searchType(SearchType.DFS_QUERY_THEN_FETCH);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        assertNoFailures(searchResponse);
        for (PluginsService pluginsService : pluginsServices) {
                .clearInterceptedActions();  
import org.opensearch.action.get.MultiGetRequest;
import org.opensearch.action.admin.indices.close.CloseIndexRequest;  
        clearInterceptedActions();
        clearInterceptedActions();  
                assertThat("no internal requests intercepted for action [" + action + "]", requests.size(), greaterThan(0));
        // free context messages are not necessarily sent, but if they are, check their indices  
            String indexOrAlias = randomIndexOrAlias();
import org.opensearch.transport.TransportInterceptor;
        interceptTransportActions(getShardAction);
import java.util.List;
            .put(super.nodeSettings(ordinal))  
        interceptTransportActions(indexShardActions);
}  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        String[] randomIndicesOrAliases = randomUniqueIndices();
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
        } else {  
    private static void assertActionInvocation(String action, Class<? extends TransportRequest> requestClass) {
            .put("cluster.routing.allocation.disk.threshold_enabled", false)  
                .findFirst()
    }
    public void testRefresh() {
        interceptTransportActions(clearCacheAction);
import org.opensearch.action.admin.indices.flush.FlushRequest;  
 * Licensed to Elasticsearch under one or more contributor  
        internalCluster().coordOnlyNodeClient().get(getRequest).actionGet();
                return Collections.singletonList(instance);
    }
    private String[] randomUniqueIndicesOrAliases() {
                for (String index : indicesRequest.indices()) {  
        interceptTransportActions(updateShardActions);  
        }
        UpdateResponse updateResponse = internalCluster().coordOnlyNodeClient().update(updateRequest).actionGet();
 */  
    private static void assertSameIndices(IndicesRequest originalRequest, String... actions) {
        int numUpdateRequests = iterations(1, 10);
        int count = randomIntBetween(1, this.indices.size());
        String getFieldMappingsShardAction = GetFieldMappingsAction.NAME + "[index][s]";
        clearInterceptedActions();  
                        if (requestList == null) {
            SearchTransportService.QUERY_ID_ACTION_NAME,
            List<TransportRequest> requests = consumeTransportRequests(action);
        assertSameIndices(getFieldMappingsRequest, getFieldMappingsShardAction);
            return index;
                assertThat(internalRequest.getClass().getName(), indicesRequest.indices(), equalTo(originalRequest.indices()));
            ) {
        IndexRequest indexRequest = new IndexRequest(randomIndexOrAlias()).id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");  
        interceptTransportActions(GetTermVersionAction.NAME, GetMappingsAction.NAME);
    public void testUpdateSettings() {
        }
        return Settings.builder()
    }
            multiTermVectorsRequest.add(indexOrAlias, Integer.toString(i));  
    public void testDelete() {
        IndicesSegmentsRequest segmentsRequest = new IndicesSegmentsRequest(randomIndicesOrAliases());  
            TransportShardFlushAction.NAME + "[p]" };
        clearInterceptedActions();  
import java.util.function.Function;
        assertFalse(requests.isEmpty());
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.indices.alias.Alias;
    public void cleanUp() {
            flushRequest
            }  
        String[] bulkShardActions = new String[] { BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };  
        // free context messages are not necessarily sent, but if they are, check their indices  
 * software distributed under the License is distributed on an
        }
        String clearCacheAction = ClearIndicesCacheAction.NAME + "[n]";  
        String index = randomFrom(indices);  
import org.opensearch.action.support.clustermanager.term.GetTermVersionRequest;  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        internalCluster().coordOnlyNodeClient().delete(deleteRequest).actionGet();  
        String indexOrAlias = randomIndexOrAlias();
        clearInterceptedActions();  
            indices.add(indexOrAlias);
import org.opensearch.script.ScriptType;
        }  
        interceptTransportActions(
            }
        clearInterceptedActions();
    private static void assertSameIndicesOptionalRequests(IndicesRequest originalRequest, String... actions) {
        assertSameIndices(  
                    assertThat(indices, hasItem(index));
        assertSameIndices(segmentReplicationStatsRequest, segmentReplicationAction);
    }  
    }
    @Before  
        clearInterceptedActions();  
        String validateQueryShardAction = ValidateQueryAction.NAME + "[s]";
    private static void clearInterceptedActions() {
        assertNoActionInvocation(GetMappingsAction.NAME);
import org.opensearch.plugins.NetworkPlugin;
        interceptTransportActions(mergeShardAction);
        int numIndexRequests = iterations(1, 10);
        interceptTransportActions(GetSettingsAction.NAME);
        // indices returned by each bulk shard request need to be a subset of the original indices  
        String[] indices = new String[count];
import org.opensearch.action.fieldcaps.FieldCapabilitiesAction;  
        clearInterceptedActions();
        internalCluster().coordOnlyNodeClient().fieldCaps(fieldCapabilitiesRequest).actionGet();
    public void testMultiTermVector() {  
    public void testCloseIndex() {  
            actions.clear();
        final IndicesRequest indicesRequest;
 * specific language governing permissions and limitations
        String[] indexShardActions = new String[] { BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };  
        }
        String[] uniqueIndices = randomUniqueIndices();  
    private static void assertAllRequestsHaveBeenConsumed() {  
        // update action goes to the primary, index op gets executed locally, then replicated
        internalCluster().coordOnlyNodeClient().multiGet(multiGetRequest).actionGet();  
        assertSameIndices(getRequest, getShardAction);
        }
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        assertSameIndices(originalRequest, true, actions);  
        );  
        List<String> indices = new ArrayList<>();
        String[] updateShardActions = new String[] { UpdateAction.NAME + "[s]", BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
        int i = 0;
 * not use this file except in compliance with the License.
        String[] updateShardActions = new String[] { UpdateAction.NAME + "[s]", BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
        internalCluster().coordOnlyNodeClient().admin().indices().updateSettings(updateSettingsRequest).actionGet();
        internalCluster().coordOnlyNodeClient().admin().indices().forceMerge(mergeRequest).actionGet();
        // update action goes to the primary, delete op gets executed locally, then replicated
        String recoveryAction = RecoveryAction.NAME + "[n]";
 * Modifications Copyright OpenSearch Contributors. See
            List<TransportRequest> requests = consumeTransportRequests(action);
        }  
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsAction;
            Settings.builder().put("refresh_interval", -1)
                    if (actions.contains(action)) {
        );
        assertSameIndices(updateRequest, updateShardActions);
        synchronized void interceptTransportActions(String... actions) {
    }
        String[] indexShardActions = new String[] {  
            SearchTransportService.FREE_CONTEXT_ACTION_NAME
import org.opensearch.action.index.IndexRequest;  
    }  
            TransportShardFlushAction.NAME + "[r]",  
        internalCluster().coordOnlyNodeClient().admin().indices().refresh(refreshRequest).actionGet();
    }
        refresh();  
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());  
        int numDeleteRequests = iterations(1, 10);
    }  
import org.opensearch.action.bulk.BulkRequest;
        synchronized List<TransportRequest> consumeRequests(String action) {
        FlushRequest flushRequest = new FlushRequest(randomIndicesOrAliases());
import org.opensearch.action.search.SearchTransportService;  
        if (randomBoolean()) {
            TransportShardFlushAction.NAME,
            boolean forceExecution,
            multiGetRequest.add(indexOrAlias, Integer.toString(i));  
            indices.add(indexOrAlias);  
        interceptTransportActions(
            }
        int count = randomIntBetween(1, indices.size() * 2); // every index has an alias  
public class IndicesRequestIT extends OpenSearchIntegTestCase {  
    }
    public void testFlush() {  
            SearchTransportService.DFS_ACTION_NAME,
        interceptTransportActions(OpenIndexAction.NAME);  
    public void testPutMapping() {
    public void testTermVector() {
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
        }
import org.opensearch.action.search.SearchResponse;
import static org.hamcrest.Matchers.equalTo;
        @Override
    public void testUpdate() {  
                        List<TransportRequest> requestList = requests.get(action);  
        assertSameIndices(openIndexRequest, OpenIndexAction.NAME);  
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
        for (PluginsService pluginsService : pluginsServices) {
import org.opensearch.action.update.UpdateRequest;
        for (int i = 0; i < numIndices; i++) {  
        GetMappingsRequest getMappingsRequest = new GetMappingsRequest().indices(randomIndicesOrAliases());
            return index + "-alias";
        clearInterceptedActions();
        private final Set<String> actions = new HashSet<>();  
        DeleteRequest deleteRequest = new DeleteRequest(randomIndexOrAlias()).id("id");
            SearchTransportService.FREE_CONTEXT_ACTION_NAME  
        clearInterceptedActions();
        clearInterceptedActions();
    public static class CustomScriptPlugin extends MockScriptPlugin {  
    }
import org.opensearch.action.admin.indices.mapping.get.GetMappingsAction;  
        interceptTransportActions(multiGetShardAction);
        internalCluster().coordOnlyNodeClient().admin().indices().close(closeIndexRequest).actionGet();
    public void testIndicesStats() {
    }  
        interceptTransportActions(multiTermVectorsShardAction);
        }
    public void testAnalyze() {
    }  
        synchronized void clearInterceptedActions() {  
 */
        assertIndicesSubset(indices, multiGetShardAction);  
        for (TransportRequest internalRequest : requests) {
    public void testValidateQuery() {  
        );
                NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
            public List<TransportInterceptor> getTransportInterceptors(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        refresh();
    public void testIndex() {
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
        fieldCapabilitiesRequest.indices(randomIndicesOrAliases());  
import org.opensearch.action.admin.indices.close.CloseIndexAction;
        for (PluginsService pluginsService : pluginsServices) {  
            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "ctx.op='delete'", Collections.emptyMap())
            bulkRequest.add(new UpdateRequest(indexOrAlias, "id").doc(Requests.INDEX_CONTENT_TYPE, "field1", "value1"));
        assertSameIndices(analyzeRequest, analyzeShardAction);
    public void testForceMerge() {  
import org.opensearch.tasks.Task;
            .build();
    }
 *
            for (TransportRequest internalRequest : requests) {
            public final InterceptingTransportService instance = new InterceptingTransportService();
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
 * this file be licensed under the Apache-2.0 license or a
        interceptTransportActions(updateShardActions);  
    }  
                InterceptingTransportService.TestPlugin.class
            ).stream().findFirst().get().instance.requests.entrySet();
        UpdateResponse updateResponse = internalCluster().coordOnlyNodeClient().update(updateRequest).actionGet();
        }
        while (uniqueIndices.size() < count) {  
        interceptTransportActions(analyzeShardAction);
        return uniqueIndices.toArray(new String[0]);  
            private final String action;
    public void testGetSettings() {  
            TransportShardRefreshAction.NAME + "[p]" };  
        internalCluster().coordOnlyNodeClient().admin().indices().recoveries(recoveryRequest).actionGet();  
        clearInterceptedActions();
        internalCluster().coordOnlyNodeClient().admin().indices().stats(indicesStatsRequest).actionGet();  
import org.opensearch.action.admin.indices.recovery.RecoveryAction;  
        String indicesStats = IndicesStatsAction.NAME + "[n]";
            // InternalClusterInfoService sends IndicesStatsRequest periodically which messes with this test
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(randomIndicesOrAliases);
import org.opensearch.action.update.UpdateResponse;
            indicesRequest = TransportReplicationActionTests.resolveRequest(request);  
                this.action = action;
        MultiGetRequest multiGetRequest = new MultiGetRequest();
            String indexOrAlias = randomIndexOrAlias();
        clearInterceptedActions();
import org.opensearch.action.update.UpdateAction;  
            searchRequest,
    public void testGet() {  
        }
        String indexOrAlias = randomIndexOrAlias();
        // makes sure that a reduce is always needed when searching  
    }
        interceptTransportActions(fieldCapabilitiesShardAction);  
        analyzeRequest.text("text");
import org.opensearch.action.search.SearchRequest;
            private final TransportRequestHandler<T> requestHandler;  
            SearchTransportService.FETCH_ID_ACTION_NAME,
        assertSameIndices(segmentsRequest, segmentsAction);
 * the Apache License, Version 2.0 (the "License"); you may
                synchronized (InterceptingTransportService.this) {
import java.util.Collections;
    private static void assertSameIndices(IndicesRequest originalRequest, boolean optional, String... actions) {  
        for (int i = 0; i < numUpdateRequests; i++) {  
        }
 *
            String executor,  
        return indices;
        }
        String multiTermVectorsShardAction = MultiTermVectorsAction.NAME + "[shard][s]";
                IndicesRequest indicesRequest = convertRequest(internalRequest);
    public void testMultiGet() {  
            TransportShardRefreshAction.NAME + "[r]",
        }
        assertSameIndices(indicesStatsRequest, indicesStats);  
        // update action goes to the primary, index op gets executed locally, then replicated
        String indexOrAlias = randomIndexOrAlias();
            uniqueIndices.add(randomFrom(this.indices));
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequest;
        UpdateRequest updateRequest = new UpdateRequest(indexOrAlias, "id").doc(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
import org.opensearch.action.admin.indices.refresh.TransportShardRefreshAction;  
        interceptTransportActions(indexShardActions);
        String[] indices = new String[uniqueIndices.length];
        internalCluster().coordOnlyNodeClient().admin().indices().putMapping(putMappingRequest).actionGet();  
        String getShardAction = GetAction.NAME + "[s]";
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertActionInvocation(GetTermVersionAction.NAME, GetTermVersionRequest.class);
        assertSameIndices(updateRequest, updateShardActions);  
        assertIndicesSubset(Arrays.asList(indices), indexShardActions);
        String[] randomIndicesOrAliases = randomIndicesOrAliases();
        String explainShardAction = ExplainAction.NAME + "[s]";  
            indices.add(indexOrAlias);
        assertSameIndices(updateRequest, updateShardActions);  
            SearchTransportService.QUERY_ID_ACTION_NAME,  
import org.opensearch.transport.client.Requests;
        @Override  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                ThreadContext threadContext  
        clearInterceptedActions();
    private String randomIndexOrAlias() {
            .doc(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
            }  
    }
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
    }  
        ensureGreen();  
    public void testGetMappings() {  
        assertAllRequestsHaveBeenConsumed();
                this.requestHandler = requestHandler;
import org.opensearch.action.termvectors.TermVectorsRequest;
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.plugins.PluginsService;
        interceptTransportActions(validateQueryShardAction);
        for (String action : actions) {
        internalCluster().coordOnlyNodeClient().admin().indices().segmentReplicationStats(segmentReplicationStatsRequest).actionGet();
            public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {  
        clearInterceptedActions();
        for (int i = 0; i < numDocs; i++) {
            }  
        String analyzeShardAction = AnalyzeAction.NAME + "[s]";  
        clearInterceptedActions();
        List<TransportRequest> requests = new ArrayList<>();
        String[] deleteShardActions = new String[] { BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
            SearchTransportService.FETCH_ID_ACTION_NAME
            List<TransportRequest> transportRequests = pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class)
        assertSameIndices(updateSettingsRequest, UpdateSettingsAction.NAME);
import java.util.Map;  
    private static void interceptTransportActions(String... actions) {
            }  
        assertSameIndices(deleteRequest, deleteShardActions);  
        RefreshRequest refreshRequest = new RefreshRequest(randomIndicesOrAliases());  
        clearInterceptedActions();
                IndicesRequest indicesRequest = convertRequest(internalRequest);
 * license agreements. See the NOTICE file distributed with
    public static class InterceptingTransportService implements TransportInterceptor {
        } else {
        }
        }
        String[] randomIndicesOrAliases = randomIndicesOrAliases();  
    public void testClearCache() {
    @Override
/*  
        ExplainRequest explainRequest = new ExplainRequest(randomIndexOrAlias(), "id").query(QueryBuilders.matchAllQuery());  
                            requestList.add(request);  
import static org.hamcrest.Matchers.greaterThan;
        if (request instanceof IndicesRequest) {  
            indices[i] = randomIndexOrAlias();  
        for (int i = 0; i < numDeleteRequests; i++) {  
        internalCluster().coordOnlyNodeClient().admin().indices().open(openIndexRequest).actionGet();  
        }
import org.opensearch.action.admin.indices.open.OpenIndexAction;
            // this setting disables it...
    }  
        String termVectorShardAction = TermVectorsAction.NAME + "[s]";
    }
        String[] indexShardActions = new String[] {
        String[] indices = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)).concreteIndexNames(
    }
        return indicesRequest;
                .stream()  
        GetFieldMappingsRequest getFieldMappingsRequest = new GetFieldMappingsRequest();
    }
    }
        String[] updateShardActions = new String[] { UpdateAction.NAME + "[s]", BulkAction.NAME + "[s][p]", BulkAction.NAME + "[s][r]" };
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
        for (String action : actions) {
        internalCluster().coordOnlyNodeClient().admin().indices().validateQuery(validateQueryRequest).actionGet();
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);  
    public void testUpdateUpsert() {  
import org.opensearch.action.termvectors.TermVectorsAction;
    }
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(randomUniqueIndicesOrAliases());
            if (!optional) {  
            @Override
        int numIndices = iterations(1, 5);
    private final List<String> indices = new ArrayList<>();
    public void testFieldCapabilities() {
        clearInterceptedActions();  
        internalCluster().coordOnlyNodeClient().admin().indices().analyze(analyzeRequest).actionGet();
        clearInterceptedActions();
    public void testSegmentReplicationStats() {  
            String indexOrAlias = randomIndexOrAlias();
                        } else {
    @Override
        interceptTransportActions(bulkShardActions);
import org.opensearch.transport.TransportRequest;
    public void testBulk() {
    private static void assertIndicesSubset(List<String> indices, String... actions) {
    }
                            requests.put(action, requestList);
import org.opensearch.action.get.MultiGetAction;
        assertEquals(DocWriteResponse.Result.DELETED, updateResponse.getResult());
        );
        }
                requestHandler.messageReceived(request, channel, task);
        assertSameIndices(indexRequest, indexShardActions);
    public void testOpenIndex() {
        clearInterceptedActions();
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);  
        interceptTransportActions(segmentReplicationAction);
import static org.hamcrest.Matchers.hasItem;  
    }
    }
            SearchTransportService.QUERY_ACTION_NAME,  
 */  
        return 2;
    public void testGetFieldMappings() {  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;
        interceptTransportActions(segmentsAction);
import org.opensearch.transport.TransportChannel;  
 * KIND, either express or implied.  See the License for the
            client().prepareIndex(randomIndicesOrAliases[i]).setId("id-" + i).setSource("field", "value").get();
        interceptTransportActions(indexShardActions);
        );  
        assertSameIndices(validateQueryRequest, validateQueryShardAction);
        clearInterceptedActions();
    }
import java.util.Collection;
            @Override  
        clearInterceptedActions();  
@ClusterScope(scope = Scope.SUITE, numClientNodes = 1, minNumDataNodes = 2)
        return requests;
        String segmentsAction = IndicesSegmentsAction.NAME + "[n]";  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return Collections.singletonMap("ctx.op='delete'", vars -> ((Map<String, Object>) vars.get("ctx")).put("op", "delete"));
        assertSameIndices(closeIndexRequest, CloseIndexAction.NAME);
            assertAcked(prepareCreate(index).addAlias(new Alias(index + "-alias")));
        );  
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(randomIndicesOrAliases()).settings(
                            requestList.add(request);  
    protected Settings nodeSettings(int ordinal) {  
    }
        return 1;
        SearchResponse searchResponse = internalCluster().coordOnlyNodeClient().search(searchRequest).actionGet();
import org.junit.Before;  
            client().prepareIndex(randomIndicesOrAliases[i]).setId("id-" + i).setSource("field", "value").get();
        interceptTransportActions(DeleteIndexAction.NAME);
        assertIndicesSubset(indices, bulkShardActions);  
        clearInterceptedActions();
        String segmentReplicationAction = SegmentReplicationStatsAction.NAME + "[n]";
 * SPDX-License-Identifier: Apache-2.0
            bulkRequest.add(new DeleteRequest(indexOrAlias).id("id"));
            indicesRequest = (IndicesRequest) request;
        internalCluster().coordOnlyNodeClient().bulk(bulkRequest).actionGet();  
            return new InterceptingRequestHandler<>(action, actualHandler);
        String multiGetShardAction = MultiGetAction.NAME + "[shard][s]";
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;  
            assertThat("no internal requests intercepted for action [" + action + "]", requests.size(), greaterThan(0));  
        @SuppressWarnings("unchecked")  
        SearchRequest searchRequest = new SearchRequest(randomIndicesOrAliases).searchType(SearchType.QUERY_THEN_FETCH);
            TransportShardRefreshAction.NAME,
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;  
            client().admin().cluster().prepareState().get().getState(),  
        assertSameIndices(clearIndicesCacheRequest, clearCacheAction);
    public void testUpdateDelete() {  
        int numDocs = iterations(1, 30);  
        TermVectorsRequest termVectorsRequest = new TermVectorsRequest(randomIndexOrAlias(), "id");
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThan(0L));
 * Unless required by applicable law or agreed to in writing,
        List<String> indices = new ArrayList<>();
    }  
        assertSameIndices(originalRequest, false, actions);
        clearInterceptedActions();
 * compatible open source license.
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;  
        }
                }  
import org.opensearch.script.Script;  
        RecoveryRequest recoveryRequest = new RecoveryRequest(randomIndicesOrAliases());
        client().prepareIndex(indexOrAlias).setId("id").setSource("field", "value").get();  
        assertSameIndices(deleteIndexRequest, DeleteIndexAction.NAME);  
        List<TransportRequest> requests = consumeTransportRequests(action);  
                assertThat(indicesRequest.indicesOptions(), equalTo(originalRequest.indicesOptions()));  
        internalCluster().coordOnlyNodeClient().multiTermVectors(multiTermVectorsRequest).actionGet();  
        ) {  
    public void testSearchDfsQueryThenFetch() throws Exception {
    private static List<TransportRequest> consumeTransportRequests(String action) {  
        }
import org.opensearch.action.admin.indices.settings.get.GetSettingsAction;
        client().prepareIndex(indexOrAlias).setId("id").setSource("field", "value").get();  
        internalCluster().coordOnlyNodeClient().admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
import java.util.Arrays;  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsAction;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            client().admin().cluster().prepareState().get().getState(),
        assertSameIndices(mergeRequest, mergeShardAction);
        interceptTransportActions(explainShardAction);
        internalCluster().coordOnlyNodeClient().explain(explainRequest).actionGet();
 * You may obtain a copy of the License at  
            indices.add("test" + i);
        for (int i = 0; i < randomIndicesOrAliases.length; i++) {  
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(randomIndicesOrAliases());  
        clearInterceptedActions();
    static IndicesRequest convertRequest(TransportRequest request) {
        clearInterceptedActions();
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;  
        clearInterceptedActions();  
        String mergeShardAction = ForceMergeAction.NAME + "[n]";
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
        clearInterceptedActions();
        internalCluster().coordOnlyNodeClient().admin().indices().getFieldMappings(getFieldMappingsRequest).actionGet();
    }  
        assertSameIndices(fieldCapabilitiesRequest, fieldCapabilitiesShardAction);
        getFieldMappingsRequest.indices(randomIndicesOrAliases());  
 *  
        FieldCapabilitiesRequest fieldCapabilitiesRequest = new FieldCapabilitiesRequest();
    private static void assertNoActionInvocation(String... actions) {
    }  
        for (int i = 0; i < numIndexRequests; i++) {  
    }
import org.opensearch.script.MockScriptPlugin;
        assertSameIndicesOptionalRequests(searchRequest, SearchTransportService.FREE_CONTEXT_ACTION_NAME);
        return Arrays.asList(InterceptingTransportService.TestPlugin.class, CustomScriptPlugin.class);  
        assertNoFailures(searchResponse);
        UpdateResponse updateResponse = internalCluster().coordOnlyNodeClient().update(updateRequest).actionGet();
            SearchTransportService.DFS_ACTION_NAME,  
    public void testSearchQueryThenFetch() throws Exception {
        GetRequest getRequest = new GetRequest(randomIndexOrAlias(), "id");
        indices.clear();  
            indices.add(indexOrAlias);  
            String action,
        BulkRequest bulkRequest = new BulkRequest();
            String indexOrAlias = randomIndexOrAlias();
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThan(0L));  
import org.opensearch.action.bulk.BulkAction;
            bulkRequest.add(new IndexRequest(indexOrAlias).id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
                            requestList = new ArrayList<>();
    protected int minimumNumberOfReplicas() {
            for (TransportRequest internalRequest : requests) {  
    public void testExplain() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            SearchTransportService.FETCH_ID_ACTION_NAME,
    private String[] randomUniqueIndices() {  
        assertIndicesSubset(indices, multiTermVectorsShardAction);  
        int numDocs = iterations(1, 30);  
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
        SegmentReplicationStatsRequest segmentReplicationStatsRequest = new SegmentReplicationStatsRequest(randomIndicesOrAliases());
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;  
        assertSameIndices(getSettingsRequest, GetSettingsAction.NAME);
        internalCluster().coordOnlyNodeClient().termVectors(termVectorsRequest).actionGet();  
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(randomUniqueIndicesOrAliases());  
        }
        UpdateRequest updateRequest = new UpdateRequest(indexOrAlias, "id").upsert(Requests.INDEX_CONTENT_TYPE, "field", "value")  
            refreshRequest  
        ForceMergeRequest mergeRequest = new ForceMergeRequest(randomIndicesOrAliases());
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
    public void testRecovery() {
        private class InterceptingRequestHandler<T extends TransportRequest> implements TransportRequestHandler<T> {
    }  
            indices[i++] = randomBoolean() ? index + "-alias" : index;
        for (int i = 0; i < count; i++) {
            assertTrue(internalRequest.getClass() == requestClass);  
        List<String> indices = new ArrayList<>();  
    @After  
import static org.hamcrest.Matchers.emptyIterable;  
                    }
import org.opensearch.plugins.Plugin;  
        internalCluster().coordOnlyNodeClient().admin().indices().flush(flushRequest).actionGet();
    }
        AnalyzeAction.Request analyzeRequest = new AnalyzeAction.Request(randomIndexOrAlias());  
        );
import org.opensearch.common.util.concurrent.ThreadContext;
        MultiTermVectorsRequest multiTermVectorsRequest = new MultiTermVectorsRequest();
        // makes sure that write operations get sent to the replica as well  
            Set<Map.Entry<String, List<TransportRequest>>> entries = pluginsService.filterPlugins(  
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }  
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsAction;
 * GitHub history for details.
    }  
                }
        internalCluster().coordOnlyNodeClient().admin().indices().getSettings(getSettingsRequest).actionGet();
        private final Map<String, List<TransportRequest>> requests = new HashMap<>();
    @Override
        interceptTransportActions(PutMappingAction.NAME);  
        assertSameIndices(searchRequest, SearchTransportService.QUERY_ACTION_NAME, SearchTransportService.FETCH_ID_ACTION_NAME);
        assertSameIndices(termVectorsRequest, termVectorShardAction);  
        interceptTransportActions(deleteShardActions);  
    protected int minimumNumberOfShards() {
    }
import org.opensearch.action.search.SearchType;
                requests.addAll(transportRequests);
        internalCluster().coordOnlyNodeClient().index(indexRequest).actionGet();
import org.opensearch.action.get.GetAction;
        for (PluginsService pluginsService : pluginsServices) {
import java.util.Set;
    }
import org.opensearch.action.support.replication.TransportReplicationActionTests;
    public void testDeleteIndex() {
        assertSameIndices(putMappingRequest, PutMappingAction.NAME);  
    }  
        }
        assertSameIndicesOptionalRequests(searchRequest, SearchTransportService.FREE_CONTEXT_ACTION_NAME);
        assertSameIndices(recoveryRequest, recoveryAction);  
        fieldCapabilitiesRequest.fields(randomAlphaOfLength(8));
        clearInterceptedActions();
        String[] indices = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)).concreteIndexNames(
/*
        for (String action : actions) {
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
            TransportRequestHandler<T> actualHandler
    }
        interceptTransportActions(CloseIndexAction.NAME);
    }  
        }
    }
 * under the License.  
import org.opensearch.action.explain.ExplainRequest;
import org.opensearch.action.termvectors.MultiTermVectorsAction;
    }
    }
            if (transportRequests != null) {  
        internalCluster().coordOnlyNodeClient().admin().indices().getMappings(getMappingsRequest).actionGet();  
        }
 * this work for additional information regarding copyright
import java.util.ArrayList;
        assertSameIndices(explainRequest, explainShardAction);
        ValidateQueryRequest validateQueryRequest = new ValidateQueryRequest(randomIndicesOrAliases());
            Collections.addAll(this.actions, actions);  
    public void testSegments() {
import org.opensearch.action.admin.indices.segments.IndicesSegmentsAction;  
        String fieldCapabilitiesShardAction = FieldCapabilitiesAction.NAME + "[index][s]";
            List<TransportRequest> requests = consumeTransportRequests(action);  
        assertAcked(internalCluster().coordOnlyNodeClient().admin().indices().delete(deleteIndexRequest).actionGet());  
            assertThat(entries, emptyIterable());  
