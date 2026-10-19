        when(rule.toXContent(any(), any())).thenAnswer(invocation -> invocation.getArgument(0));
 * SPDX-License-Identifier: Apache-2.0
        when(originalRule.getAttributeMap()).thenReturn(ATTRIBUTE_MAP);  
            final List<Exception> failures = Collections.synchronizedList(new ArrayList<>());
        SearchHit searchHit = new SearchHit(1, _ID_ONE, null, null);
package org.opensearch.rule.service;
    public void testUpdateRule_ParseFailure() {  
        when(rule.toXContent(any(), any())).thenAnswer(invocation -> invocation.getArgument(0));  
import java.util.concurrent.TimeUnit;
        ) {  
                    validateNoDuplicateRule(updatedRule, new ActionListener<Void>() {
        }
import java.util.concurrent.atomic.AtomicReference;
        when(client.threadPool()).thenReturn(threadPool);
                    String key = rule.getAttributeMap().toString();
            new Thread(() -> rulePersistenceService.updateRule(updateRuleRequest, testListener)).start();  
        GetRuleRequest getRuleRequest = mock(GetRuleRequest.class);
    private RuleQueryMapper<QueryBuilder> ruleQueryMapper;
        for (Exception e : testListener.failures) {
import org.opensearch.search.SearchHits;
                        listener.onResponse(null);
                    });
import static org.opensearch.rule.utils.RuleTestUtils.TEST_INDEX_NAME;  
import org.opensearch.action.delete.DeleteRequest;
        singleThreadExecutor.shutdown();
                    Rule rule = request.getRule();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        int threadCount = 10;
            assertTrue(e.getMessage().contains("Duplicate rule"));  
            assertTrue(e instanceof IllegalArgumentException);
import static org.opensearch.rule.utils.RuleTestUtils.FEATURE_VALUE_ONE;
    public void testConcurrentUpdateDuplicateRules() throws InterruptedException {
        when(clusterService.state()).thenReturn(clusterState);  
        class TestListener implements ActionListener<UpdateRuleResponse> {
            ruleEntityParser,
        when(updateRuleRequest.getAttributeMap()).thenReturn(ATTRIBUTE_MAP);
            assertTrue(e.getMessage().contains("Duplicate rule"));  
import org.opensearch.core.common.bytes.BytesArray;  
            final AtomicInteger failureCount = new AtomicInteger();
    public void testDeleteRule_notFound() {
import org.opensearch.action.search.SearchResponse;
        singleThreadExecutor.shutdown();  
        ) {  
        when(threadPool.getThreadContext()).thenReturn(threadContext);
            new Thread(() -> rulePersistenceService.createRule(createRuleRequest, testListener)).start();  
        assertEquals(ruleId, requestCaptor.getValue().id());  
        when(createRuleRequest.getRule()).thenReturn(rule);
        ArgumentCaptor<DeleteRequest> requestCaptor = ArgumentCaptor.forClass(DeleteRequest.class);
        UpdateRuleRequest updateRuleRequest = mock(UpdateRuleRequest.class);
            @Override
            ruleQueryMapper
import java.util.Collections;
        Settings testSettings = Settings.EMPTY;
import java.util.concurrent.CountDownLatch;
        boolean completed = latch.await(10, TimeUnit.SECONDS);  
        verify(listener).onResponse(responseCaptor.capture());
import org.opensearch.common.action.ActionFuture;
        assertTrue(failure.get() instanceof ResourceNotFoundException);
            ruleQueryMapper
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        when(searchRequestBuilder.get()).thenReturn(searchResponse);  
        when(createRuleRequest.getRule()).thenReturn(rule);  
    }
                    }
        assertEquals(1, testListener.successCount.get());
        when(client.prepareSearch(TEST_INDEX_NAME)).thenReturn(searchRequestBuilder);  
            ActionListener.class
            }
                }  
        AtomicReference<Exception> failure = new AtomicReference<>();
 * compatible open source license.
            @Override  
            clusterService,
        CountDownLatch latch = new CountDownLatch(threadCount);  
            MAX_VALUES_PER_PAGE,  
        hit.sourceRef(new BytesArray(VALID_JSON));  
        rulePersistenceService.deleteRule(request, listener);  
        SearchHits searchHits = new SearchHits(new SearchHit[] { searchHit }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);  
            public void updateRule(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_MAP;  
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);
                failures.add(e);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import java.util.HashSet;  
        ActionListener<GetRuleResponse> listener = mock(ActionListener.class);
        SearchResponse searchResponse = mock(SearchResponse.class);
import org.opensearch.cluster.ClusterState;
        UpdateRuleRequest request = mock(UpdateRuleRequest.class);
    }
        verify(listener).onFailure(failureCaptor.capture());  
        for (Exception e : testListener.failures) {
            client,
        );
                singleThreadExecutor.execute(() -> {  
        when(getRuleRequest.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);  
import org.opensearch.cluster.service.ClusterService;  
        when(future.get()).thenReturn(indexResponse);  
        when(searchResponse.getHits()).thenReturn(emptyHits);
        when(getRuleRequest.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
    private Client client;
                        listener.onFailure(new IllegalArgumentException("Duplicate rule exists with attribute map"));  
    private SearchRequestBuilder searchRequestBuilder;  
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);  
                    if (storedAttributeMaps.contains(key)) {  
        when(ruleQueryMapper.from(any(GetRuleRequest.class))).thenReturn(queryBuilder);
        assertTrue("All update calls should complete", completed);  
            public void validateNoDuplicateRule(Rule rule, ActionListener<Void> listener) {  
            }  
import org.opensearch.rule.action.CreateRuleResponse;
        when(clusterService.getSettings()).thenReturn(testSettings);
        verify(client).delete(requestCaptor.capture(), listenerCaptor.capture());
                failureCount.incrementAndGet();
        }
            public void onResponse(UpdateRuleResponse updateRuleResponse) {  
                }
    private RulePersistenceService rulePersistenceService;
        when(metadata.hasIndex(TEST_INDEX_NAME)).thenReturn(true);
                    });
import org.opensearch.action.index.IndexResponse;  
        verify(listener).onFailure(exceptionCaptor.capture());
            public void createRule(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener) {
import static org.mockito.ArgumentMatchers.argThat;  
import java.util.concurrent.Executors;
            ruleQueryMapper
                        public void onFailure(Exception e) {
    private RuleEntityParser ruleEntityParser;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.rule.action.UpdateRuleResponse;  
        }
                    } else {
            @Override
import java.util.Set;  
            @Override  
        when(clusterService.state()).thenReturn(clusterState);  
        when(originalRule.getId()).thenReturn(_ID_ONE);
        when(deleteResponse.getResult()).thenReturn(DocWriteResponse.Result.DELETED);  
                        public void onResponse(Void unused) {
        ArgumentCaptor<CreateRuleResponse> responseCaptor = ArgumentCaptor.forClass(CreateRuleResponse.class);  
        SearchResponse searchResponse = mock(SearchResponse.class);
    public void testUpdateRule_RuleNotFound() {
    private ClusterService clusterService;  
import org.opensearch.rule.RuleUtils;
            @Override
                singleThreadExecutor.execute(() -> {  
        ArgumentCaptor<ActionListener<org.opensearch.action.delete.DeleteResponse>> listenerCaptor = ArgumentCaptor.forClass(  
        verify(listener).onResponse(argThat(AcknowledgedResponse::isAcknowledged));
        };  
        SearchResponse searchResponse = mock(SearchResponse.class);
    }
        Set<String> storedAttributeMaps = ConcurrentHashMap.newKeySet();
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        SearchResponse searchResponse = mock(SearchResponse.class);  
    public void testCreateRuleOnExistingIndex() throws Exception {  
        when(createRuleRequest.getRule()).thenReturn(rule);
        ClusterState clusterState = mock(ClusterState.class);
                synchronized (storedAttributeMaps) {
import org.opensearch.action.DocWriteResponse;  
    public void testDeleteRule_successful() {
import org.opensearch.common.util.concurrent.ThreadContext;
        SearchHits searchHits = new SearchHits(new SearchHit[] { searchHit }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);  
                });  
                    if (storedAttributeMaps.contains(MOCK_RULE_ATTRIBUTE_ONE.getName())) {
import org.opensearch.rule.autotagging.Rule;
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;
        when(searchResponse.getHits()).thenReturn(
    public void testCreateDuplicateRule() {
        );
        assertEquals(1, testListener.successCount.get());
    }  
        when(getRuleRequest.getId()).thenReturn(_ID_ONE);
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));  
        }
        ArgumentCaptor<GetRuleResponse> responseCaptor = ArgumentCaptor.forClass(GetRuleResponse.class);
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);
            ruleEntityParser,
                        @Override  
public class IndexStoredRulePersistenceServiceTests extends OpenSearchTestCase {
        SearchHit searchHit = new SearchHit(1);
import org.opensearch.core.index.shard.ShardId;
                });  
import java.util.Map;
import org.opensearch.action.index.IndexRequest;
        super.setUp();  
        AtomicReference<Exception> failure = new AtomicReference<>();  
import org.opensearch.cluster.metadata.Metadata;
                        }
        when(getRuleRequest.getId()).thenReturn(_ID_ONE);
import static org.opensearch.rule.XContentRuleParserTests.VALID_JSON;
                            latch.countDown();  
                            latch.countDown();  
    private static final int MAX_VALUES_PER_PAGE = 50;
                            listener.onFailure(e);
import org.opensearch.core.action.ActionListener;
 *
                    validateNoDuplicateRule(rule, new ActionListener<Void>() {
        when(createRuleRequest.getRule()).thenReturn(rule);  
            public void onFailure(Exception e) {
            }
@SuppressWarnings("unchecked")
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
            @Override
        CountDownLatch latch = new CountDownLatch(threadCount);  
        when(rule.getAttributeMap()).thenReturn(ATTRIBUTE_MAP);
            ActionListener.class
                synchronized (storedAttributeMaps) {
        searchHit.sourceRef(new BytesArray(VALID_JSON));
        ArgumentCaptor<ActionListener<org.opensearch.action.delete.DeleteResponse>> listenerCaptor = ArgumentCaptor.forClass(  
        SearchHits emptyHits = new SearchHits(new SearchHit[] {}, new TotalHits(0, TotalHits.Relation.EQUAL_TO), 1.0f);
        Rule originalRule = mock(Rule.class);
        searchHit.sourceRef(new BytesArray(VALID_JSON));
        when(indexResponse.getId()).thenReturn(_ID_ONE);
    public void testGetRuleByIdSuccess() {  
        GetRuleResponse response = responseCaptor.getValue();
            @Override
import org.apache.lucene.search.TotalHits;
                        @Override  
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);
            new SearchHits(new SearchHit[] {}, new TotalHits(10000, TotalHits.Relation.EQUAL_TO), 1.0f)  
    }
        assertNotNull(failure.get());
    private Rule rule;  
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));  
                        @Override  
import org.opensearch.rule.RuleQueryMapper;
        Metadata metadata = mock(Metadata.class);
    }  
import static org.mockito.ArgumentMatchers.anyString;
        rulePersistenceService.createRule(createRuleRequest, listener);
        when(getRuleRequest.getAttributeFilters()).thenReturn(new HashMap<>());  
        when(ruleEntityParser.parse(any(String.class))).thenReturn(rule);  
        queryBuilder = mock(QueryBuilder.class);
        );
import org.opensearch.threadpool.ThreadPool;  
                        listener.onFailure(new IllegalArgumentException("Duplicate rule exists with attribute map"));
        verify(listener).onFailure(exceptionCaptor.capture());  
            final List<Exception> failures = Collections.synchronizedList(new ArrayList<>());
        UpdateRuleRequest request = mock(UpdateRuleRequest.class);
        IndexResponse indexResponse = mock(IndexResponse.class);  
            }
import org.opensearch.rule.RulePersistenceService;  
                            latch.countDown();  
import org.opensearch.rule.RuleEntityParser;
        rulePersistenceService = new IndexStoredRulePersistenceService(
            clusterService,
        when(searchResponse.getHits()).thenReturn(new SearchHits(new SearchHit[] {}, new TotalHits(0, TotalHits.Relation.EQUAL_TO), 1.0f));  
            }
            public void onFailure(Exception e) {  
        });
        boolean completed = latch.await(10, TimeUnit.SECONDS);
 * The OpenSearch Contributors require contributions made to  
        listenerCaptor.getValue().onFailure(new DocumentMissingException(new ShardId(TEST_INDEX_NAME, "_na_", 0), ruleId));
            }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        when(request.getId()).thenReturn(_ID_ONE);
        Client client = mock(Client.class);  
                        @Override  
            }
        String ruleId = "missing-rule-id";
        when(rule.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
            TEST_INDEX_NAME,  
        rulePersistenceService.createRule(createRuleRequest, listener);
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;  
        when(searchRequestBuilder.get()).thenReturn(searchResponse);  
            @Override
    }
        ruleEntityParser = mock(RuleEntityParser.class);
                        listener.onResponse(null);
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_TWO;  
        when(originalRule.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
            assertTrue(e instanceof IllegalArgumentException);
                successCount.incrementAndGet();  
import java.util.List;
        RulePersistenceService rulePersistenceService = new IndexStoredRulePersistenceService(
    public void setUp() throws Exception {
        return client;
            final AtomicInteger successCount = new AtomicInteger();  
        assertNotNull(exceptionCaptor.getValue());  
        when(clusterState.metadata()).thenReturn(metadata);
        RulePersistenceService rulePersistenceService = new IndexStoredRulePersistenceService(
                        }
        when(request.getId()).thenReturn(_ID_ONE);  
import static org.mockito.Mockito.anyInt;
            ruleEntityParser,
        for (int i = 0; i < threadCount; i++) {
        TestListener testListener = new TestListener();  
import org.opensearch.index.query.QueryBuilder;
                        }
        when(searchResponse.getHits()).thenReturn(searchHits);
import org.opensearch.ResourceNotFoundException;
                fail();
            MAX_VALUES_PER_PAGE,  
    }
                    Rule updatedRule = RuleUtils.composeUpdatedRule(originalRule, request, request.getFeatureType());
        Exception exception = exceptionCaptor.getValue();
        verify(listener).onResponse(responseCaptor.capture());
        when(searchResponse.getHits()).thenReturn(searchHits);
            public void validateNoDuplicateRule(Rule rule, ActionListener<Void> listener) {  
        clusterSettings.registerSetting(IndexStoredRulePersistenceService.MAX_WLM_RULES_SETTING);
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_ONE;
        ClusterService clusterService = mock(ClusterService.class);
        ArgumentCaptor<Exception> exceptionCaptor = ArgumentCaptor.forClass(OpenSearchRejectedExecutionException.class);
        assertTrue(failure.get().getMessage().contains("Invalid JSON"));
        assertEquals(threadCount - 1, testListener.failureCount.get());
        TestListener testListener = new TestListener();  
        verify(listener).onFailure(any(ResourceNotFoundException.class));
    private Client setUpMockClient(SearchRequestBuilder searchRequestBuilder) {
        when(searchResponse.getHits()).thenReturn(new SearchHits(new SearchHit[] {}, new TotalHits(0, TotalHits.Relation.EQUAL_TO), 1.0f));
                            }
        when(clusterState.metadata()).thenReturn(metadata);
            public void onFailure(Exception e) {  
import org.opensearch.rule.action.GetRuleRequest;  
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);
        ClusterState clusterState = mock(ClusterState.class);
    }
        when(searchRequestBuilder.setQuery(any(QueryBuilder.class))).thenReturn(searchRequestBuilder);
    private QueryBuilder queryBuilder;
            client,
            TEST_INDEX_NAME,  
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);  
        ArgumentCaptor<DeleteRequest> requestCaptor = ArgumentCaptor.forClass(DeleteRequest.class);
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        rulePersistenceService.updateRule(request, new ActionListener<>() {
        );  
import java.util.ArrayList;  
import org.opensearch.common.settings.ClusterSettings;
        verify(client).delete(requestCaptor.capture(), listenerCaptor.capture());
        }
 * this file be licensed under the Apache-2.0 license or a
            }
        DeleteRuleRequest request = new DeleteRuleRequest(ruleId, RuleTestUtils.MockRuleFeatureType.INSTANCE);  
        ClusterSettings clusterSettings = new ClusterSettings(testSettings, new HashSet<>());  
/*  
        when(client.threadPool()).thenReturn(threadPool);
import org.opensearch.action.search.SearchRequestBuilder;
import org.opensearch.transport.client.Client;
            }
import org.opensearch.common.settings.Settings;  
import org.opensearch.search.SearchHit;  
import static org.mockito.Mockito.any;
        rulePersistenceService.createRule(createRuleRequest, listener);
                        public void onResponse(Void unused) {
        class TestListener implements ActionListener<CreateRuleResponse> {
}
        searchRequestBuilder = mock(SearchRequestBuilder.class);
import org.opensearch.index.engine.DocumentMissingException;  
        rule = mock(Rule.class);  
    }  
        ActionListener<GetRuleResponse> listener = mock(ActionListener.class);
        when(searchRequestBuilder.setSize(anyInt())).thenReturn(searchRequestBuilder);
            @Override  
    public void testConcurrentCreateDuplicateRules() throws InterruptedException {  
        assertNotNull(responseCaptor.getValue().getRule());
        ruleQueryMapper = mock(RuleQueryMapper.class);  
import java.util.HashMap;
            @Override
        when(updateRuleRequest.getDescription()).thenReturn(DESCRIPTION_TWO);
        ArgumentCaptor<Exception> exceptionCaptor = ArgumentCaptor.forClass(Exception.class);
                            latch.countDown();  
    public void testCardinalityCheckBasedFailure() throws Exception {
    public void testGetRuleByIdNotFound() {  
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        when(ruleEntityParser.parse(anyString())).thenThrow(new RuntimeException("Invalid JSON"));
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        String ruleId = "test-rule-id";
        ThreadPool threadPool = mock(ThreadPool.class);
        clusterService = mock(ClusterService.class);
        when(originalRule.getDescription()).thenReturn(DESCRIPTION_ONE);  
    }
                    } else {
        DeleteRuleRequest request = new DeleteRuleRequest(ruleId, RuleTestUtils.MockRuleFeatureType.INSTANCE);  
        when(client.threadPool()).thenReturn(threadPool);
        assertEquals(1, response.getRules().size());  
                        public void onFailure(Exception e) {
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        assertTrue(exception instanceof ResourceNotFoundException);
            MAX_VALUES_PER_PAGE,  
        SearchHits searchHits = new SearchHits(new SearchHit[] { hit }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
        }
            public void onResponse(CreateRuleResponse response) {
                failures.add(e);  
                failureCount.incrementAndGet();
        };
                    }  
            public void onResponse(UpdateRuleResponse response) {
        listenerCaptor.getValue().onResponse(deleteResponse);
        when(queryBuilder.filter(any())).thenReturn(queryBuilder);  
        client = setUpMockClient(searchRequestBuilder);
import static org.mockito.Mockito.verify;
        when(searchRequestBuilder.get()).thenReturn(searchResponse);  
        ThreadPool threadPool = mock(ThreadPool.class);
            TEST_INDEX_NAME,  
import static org.mockito.Mockito.mock;  
        });  
                                storedAttributeMaps.add(MOCK_RULE_ATTRIBUTE_ONE.getName());  
        SearchResponse searchResponse = mock(SearchResponse.class);  
        ThreadPool threadPool = mock(ThreadPool.class);
import static org.opensearch.rule.utils.RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE;
            public void onResponse(UpdateRuleResponse updateRuleResponse) {
        rulePersistenceService.getRule(getRuleRequest, listener);  
        when(rule.getAttributeMap()).thenReturn(Map.of(MOCK_RULE_ATTRIBUTE_ONE, Set.of(ATTRIBUTE_VALUE_ONE)));
                            synchronized (storedAttributeMaps) {
                failure.set(e);  
import java.util.concurrent.atomic.AtomicInteger;  
            public void onFailure(Exception e) {
        assertEquals(threadCount - 1, testListener.failureCount.get());  
        assertEquals(ruleId, requestCaptor.getValue().id());  
        SearchResponse searchResponse = mock(SearchResponse.class);
        rulePersistenceService.getRule(getRuleRequest, listener);
        when(rule.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
 */  
        SearchResponse searchResponse = mock(SearchResponse.class);
        for (int i = 0; i < threadCount; i++) {
            clusterService,
import org.opensearch.rule.action.UpdateRuleRequest;
                fail();
import org.opensearch.rule.action.GetRuleResponse;
            final AtomicInteger successCount = new AtomicInteger();
        GetRuleRequest getRuleRequest = mock(GetRuleRequest.class);
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);  
        assertTrue("All create calls should complete", completed);
                            listener.onResponse(new UpdateRuleResponse(updatedRule));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
                failure.set(e);
        when(updateRuleRequest.getFeatureValue()).thenReturn(FEATURE_VALUE_ONE);
                        storedAttributeMaps.add(key);  
            client,
        when(updateRuleRequest.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);  
        when(ruleEntityParser.parse(anyString())).thenReturn(rule);  
                            listener.onResponse(new CreateRuleResponse(rule));
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_VALUE_ONE;
    }
        ActionFuture<IndexResponse> future = mock(ActionFuture.class);
        int threadCount = 10;
    }
        ArgumentCaptor<Exception> failureCaptor = ArgumentCaptor.forClass(Exception.class);
                            listener.onFailure(e);
import org.opensearch.rule.action.CreateRuleRequest;  
        SearchHit hit = new SearchHit(1);
        org.opensearch.action.delete.DeleteResponse deleteResponse = mock(org.opensearch.action.delete.DeleteResponse.class);
        assertTrue(failure.get().getMessage().contains(_ID_ONE));  
import org.opensearch.rule.action.DeleteRuleRequest;
        Set<String> storedAttributeMaps = ConcurrentHashMap.newKeySet();
        when(client.index(any(IndexRequest.class))).thenReturn(future);
        rulePersistenceService.deleteRule(request, listener);  
        when(searchResponse.getHits()).thenReturn(searchHits);
import org.mockito.ArgumentCaptor;  
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        when(ruleQueryMapper.getCardinalityQuery()).thenReturn(mock(QueryBuilder.class));
                successCount.incrementAndGet();
import static org.mockito.Mockito.when;
import org.opensearch.rule.utils.RuleTestUtils;
            }  
            }  
            }
                        }
        rulePersistenceService.updateRule(request, new ActionListener<>() {
        Metadata metadata = mock(Metadata.class);  
        when(originalRule.getFeatureValue()).thenReturn(FEATURE_VALUE_ONE);
            final AtomicInteger failureCount = new AtomicInteger();  
