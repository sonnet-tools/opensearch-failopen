                            listener.onFailure(e);
                        }
        when(searchResponse.getHits()).thenReturn(emptyHits);
            }
        AtomicReference<Exception> failure = new AtomicReference<>();
    }
    public void testDeleteRule_notFound() {
        when(ruleEntityParser.parse(anyString())).thenThrow(new RuntimeException("Invalid JSON"));
                successCount.incrementAndGet();
                            latch.countDown();
                        listener.onResponse(null);
        searchHit.sourceRef(new BytesArray(VALID_JSON));
        when(ruleQueryMapper.from(any(GetRuleRequest.class))).thenReturn(queryBuilder);
        when(client.index(any(IndexRequest.class))).thenReturn(future);
import org.opensearch.rule.action.GetRuleResponse;
                failureCount.incrementAndGet();
        SearchResponse searchResponse = mock(SearchResponse.class);
import org.opensearch.action.search.SearchRequestBuilder;
    public void setUp() throws Exception {
            public void onResponse(UpdateRuleResponse updateRuleResponse) {
import java.util.Set;
 * this file be licensed under the Apache-2.0 license or a
                        }
        SearchHits searchHits = new SearchHits(new SearchHit[] { searchHit }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
            @Override
import org.opensearch.rule.RulePersistenceService;
        when(ruleEntityParser.parse(any(String.class))).thenReturn(rule);
            final AtomicInteger failureCount = new AtomicInteger();
import org.opensearch.common.settings.ClusterSettings;
            }
            new SearchHits(new SearchHit[] {}, new TotalHits(10000, TotalHits.Relation.EQUAL_TO), 1.0f)
                    if (storedAttributeMaps.contains(MOCK_RULE_ATTRIBUTE_ONE.getName())) {
            clusterService,
        when(searchResponse.getHits()).thenReturn(new SearchHits(new SearchHit[] {}, new TotalHits(0, TotalHits.Relation.EQUAL_TO), 1.0f));
import org.opensearch.search.SearchHits;
                            latch.countDown();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        ArgumentCaptor<ActionListener<org.opensearch.action.delete.DeleteResponse>> listenerCaptor = ArgumentCaptor.forClass(
        ThreadPool threadPool = mock(ThreadPool.class);
        listenerCaptor.getValue().onResponse(deleteResponse);
        when(ruleQueryMapper.getCardinalityQuery()).thenReturn(mock(QueryBuilder.class));
import org.opensearch.rule.action.UpdateRuleRequest;
        assertTrue("All update calls should complete", completed);
 * compatible open source license.
        when(clusterService.state()).thenReturn(clusterState);
                failures.add(e);
        UpdateRuleRequest request = mock(UpdateRuleRequest.class);
        AtomicReference<Exception> failure = new AtomicReference<>();
        assertTrue(failure.get().getMessage().contains(_ID_ONE));
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_ONE;
    }
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
            final AtomicInteger successCount = new AtomicInteger();
        when(searchRequestBuilder.setSize(anyInt())).thenReturn(searchRequestBuilder);
        };
        });
        when(originalRule.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
    }
        ArgumentCaptor<Exception> failureCaptor = ArgumentCaptor.forClass(Exception.class);
import static org.opensearch.rule.utils.RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE;
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
        SearchResponse searchResponse = mock(SearchResponse.class);
        for (int i = 0; i < threadCount; i++) {
import java.util.concurrent.TimeUnit;
                fail();
            clusterService,
            assertTrue(e instanceof IllegalArgumentException);
 * The OpenSearch Contributors require contributions made to
        listenerCaptor.getValue().onFailure(new DocumentMissingException(new ShardId(TEST_INDEX_NAME, "_na_", 0), ruleId));
import java.util.ArrayList;
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);
            ruleQueryMapper
        when(request.getId()).thenReturn(_ID_ONE);
        super.setUp();
        org.opensearch.action.delete.DeleteResponse deleteResponse = mock(org.opensearch.action.delete.DeleteResponse.class);
        }
        TestListener testListener = new TestListener();
    public void testCreateDuplicateRule() {
        when(rule.toXContent(any(), any())).thenAnswer(invocation -> invocation.getArgument(0));
import static org.mockito.ArgumentMatchers.argThat;
        singleThreadExecutor.shutdown();
        when(metadata.hasIndex(TEST_INDEX_NAME)).thenReturn(true);
            }
    public void testConcurrentUpdateDuplicateRules() throws InterruptedException {
import java.util.Collections;
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        }
        assertNotNull(exceptionCaptor.getValue());
            public void validateNoDuplicateRule(Rule rule, ActionListener<Void> listener) {
@SuppressWarnings("unchecked")
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
        when(createRuleRequest.getRule()).thenReturn(rule);
import org.opensearch.rule.autotagging.Rule;
        when(getRuleRequest.getId()).thenReturn(_ID_ONE);
        when(indexResponse.getId()).thenReturn(_ID_ONE);
import org.opensearch.rule.action.CreateRuleResponse;
        rulePersistenceService.getRule(getRuleRequest, listener);
import org.opensearch.cluster.service.ClusterService;
                            listener.onResponse(new CreateRuleResponse(rule));
            @Override
        DeleteRuleRequest request = new DeleteRuleRequest(ruleId, RuleTestUtils.MockRuleFeatureType.INSTANCE);
        RulePersistenceService rulePersistenceService = new IndexStoredRulePersistenceService(
            public void onResponse(UpdateRuleResponse response) {
        when(rule.getAttributeMap()).thenReturn(ATTRIBUTE_MAP);
import java.util.Map;
import java.util.concurrent.ExecutorService;
        ArgumentCaptor<DeleteRequest> requestCaptor = ArgumentCaptor.forClass(DeleteRequest.class);
                            latch.countDown();
    private Client client;
import static org.opensearch.rule.utils.RuleTestUtils.FEATURE_VALUE_ONE;
        when(clusterState.metadata()).thenReturn(metadata);
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
            assertTrue(e.getMessage().contains("Duplicate rule"));
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        when(clusterService.getSettings()).thenReturn(testSettings);
        }
        when(queryBuilder.filter(any())).thenReturn(queryBuilder);
    private RuleQueryMapper<QueryBuilder> ruleQueryMapper;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);
        rulePersistenceService.getRule(getRuleRequest, listener);
        ActionListener<GetRuleResponse> listener = mock(ActionListener.class);
    public void testConcurrentCreateDuplicateRules() throws InterruptedException {
            @Override
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
            }
        GetRuleRequest getRuleRequest = mock(GetRuleRequest.class);
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
            public void createRule(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener) {
        assertNotNull(responseCaptor.getValue().getRule());
        CountDownLatch latch = new CountDownLatch(threadCount);
                        }
        ClusterService clusterService = mock(ClusterService.class);
        when(originalRule.getId()).thenReturn(_ID_ONE);
                        listener.onFailure(new IllegalArgumentException("Duplicate rule exists with attribute map"));
        GetRuleResponse response = responseCaptor.getValue();
                        @Override
        ActionListener<GetRuleResponse> listener = mock(ActionListener.class);
        SearchHits emptyHits = new SearchHits(new SearchHit[] {}, new TotalHits(0, TotalHits.Relation.EQUAL_TO), 1.0f);
                }
                singleThreadExecutor.execute(() -> {
            TEST_INDEX_NAME,
        return client;
        rulePersistenceService.deleteRule(request, listener);
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);
                    }
        when(createRuleRequest.getRule()).thenReturn(rule);
            client,
import java.util.concurrent.ConcurrentHashMap;
        when(updateRuleRequest.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
        verify(listener).onResponse(responseCaptor.capture());
        );
                }
import org.opensearch.rule.RuleUtils;
            public void onFailure(Exception e) {
            }
        };
                synchronized (storedAttributeMaps) {
        when(originalRule.getFeatureValue()).thenReturn(FEATURE_VALUE_ONE);
package org.opensearch.rule.service;
                        public void onResponse(Void unused) {
        Metadata metadata = mock(Metadata.class);
public class IndexStoredRulePersistenceServiceTests extends OpenSearchTestCase {
                failures.add(e);
                            latch.countDown();
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);
        }
        CountDownLatch latch = new CountDownLatch(threadCount);
    public void testDeleteRule_successful() {
        ThreadPool threadPool = mock(ThreadPool.class);
        when(createRuleRequest.getRule()).thenReturn(rule);
        ClusterState clusterState = mock(ClusterState.class);
import org.opensearch.rule.RuleQueryMapper;
import org.opensearch.common.action.ActionFuture;
                            synchronized (storedAttributeMaps) {
    private static final int MAX_VALUES_PER_PAGE = 50;
        when(request.getId()).thenReturn(_ID_ONE);
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        int threadCount = 10;
import org.opensearch.test.OpenSearchTestCase;
    private QueryBuilder queryBuilder;
import org.opensearch.rule.action.CreateRuleRequest;
        when(client.threadPool()).thenReturn(threadPool);
        SearchHit searchHit = new SearchHit(1);
        class TestListener implements ActionListener<UpdateRuleResponse> {
import org.opensearch.ResourceNotFoundException;
                fail();
        verify(client).delete(requestCaptor.capture(), listenerCaptor.capture());
import static org.mockito.Mockito.verify;
                        listener.onResponse(null);
        boolean completed = latch.await(10, TimeUnit.SECONDS);
            @Override
        when(rule.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
                        storedAttributeMaps.add(key);
    }
            @Override
        assertTrue(failure.get() instanceof ResourceNotFoundException);
                        @Override
        client = setUpMockClient(searchRequestBuilder);
                        public void onFailure(Exception e) {
        SearchHits searchHits = new SearchHits(new SearchHit[] { searchHit }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
        when(searchResponse.getHits()).thenReturn(searchHits);
        when(rule.getAttributeMap()).thenReturn(Map.of(MOCK_RULE_ATTRIBUTE_ONE, Set.of(ATTRIBUTE_VALUE_ONE)));
        when(rule.toXContent(any(), any())).thenAnswer(invocation -> invocation.getArgument(0));
                    if (storedAttributeMaps.contains(key)) {
    }
        assertEquals(ruleId, requestCaptor.getValue().id());
            public void onFailure(Exception e) {
        when(future.get()).thenReturn(indexResponse);
import org.opensearch.rule.action.UpdateRuleResponse;
        queryBuilder = mock(QueryBuilder.class);
        ArgumentCaptor<Exception> exceptionCaptor = ArgumentCaptor.forClass(Exception.class);
                    } else {
import org.opensearch.core.action.ActionListener;
                    }
    public void testGetRuleByIdNotFound() {
        SearchResponse searchResponse = mock(SearchResponse.class);
        clusterService = mock(ClusterService.class);
        RulePersistenceService rulePersistenceService = new IndexStoredRulePersistenceService(
        String ruleId = "missing-rule-id";
        assertTrue(exception instanceof ResourceNotFoundException);
        when(clusterState.metadata()).thenReturn(metadata);
        SearchResponse searchResponse = mock(SearchResponse.class);
        for (Exception e : testListener.failures) {
            MAX_VALUES_PER_PAGE,
        for (int i = 0; i < threadCount; i++) {
        when(rule.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
        Exception exception = exceptionCaptor.getValue();
        verify(listener).onResponse(argThat(AcknowledgedResponse::isAcknowledged));
        );
    }
import java.util.HashMap;
        verify(listener).onFailure(exceptionCaptor.capture());
        Settings testSettings = Settings.EMPTY;
                        listener.onFailure(new IllegalArgumentException("Duplicate rule exists with attribute map"));
            final List<Exception> failures = Collections.synchronizedList(new ArrayList<>());
        verify(listener).onFailure(failureCaptor.capture());
    }
    private Client setUpMockClient(SearchRequestBuilder searchRequestBuilder) {
import java.util.concurrent.CountDownLatch;
 */
        ruleEntityParser = mock(RuleEntityParser.class);
        SearchResponse searchResponse = mock(SearchResponse.class);
        assertEquals(threadCount - 1, testListener.failureCount.get());
import static org.mockito.Mockito.mock;
import org.opensearch.rule.RuleEntityParser;
                    });
            ruleEntityParser,
        CreateRuleRequest createRuleRequest = mock(CreateRuleRequest.class);
import static org.opensearch.rule.utils.RuleTestUtils._ID_ONE;
        ArgumentCaptor<ActionListener<org.opensearch.action.delete.DeleteResponse>> listenerCaptor = ArgumentCaptor.forClass(
    public void testCreateRuleOnExistingIndex() throws Exception {
                        @Override
        GetRuleRequest getRuleRequest = mock(GetRuleRequest.class);
                        @Override
        ) {
        assertNotNull(failure.get());
        rulePersistenceService.updateRule(request, new ActionListener<>() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
            ActionListener.class
import org.opensearch.search.SearchHit;
                            }
        });
            @Override
                    } else {
        clusterSettings.registerSetting(IndexStoredRulePersistenceService.MAX_WLM_RULES_SETTING);
        }
        assertEquals(1, testListener.successCount.get());
        when(clusterService.state()).thenReturn(clusterState);
                    });
            final List<Exception> failures = Collections.synchronizedList(new ArrayList<>());
import org.opensearch.common.util.concurrent.ThreadContext;
            new Thread(() -> rulePersistenceService.updateRule(updateRuleRequest, testListener)).start();
                    validateNoDuplicateRule(updatedRule, new ActionListener<Void>() {
        ClusterState clusterState = mock(ClusterState.class);
                            listener.onFailure(e);
        rulePersistenceService.deleteRule(request, listener);
import java.util.concurrent.Executors;
            public void onResponse(UpdateRuleResponse updateRuleResponse) {
        verify(listener).onFailure(exceptionCaptor.capture());
        SearchHits searchHits = new SearchHits(new SearchHit[] { hit }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
        ClusterSettings clusterSettings = new ClusterSettings(testSettings, new HashSet<>());
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        when(client.prepareSearch(TEST_INDEX_NAME)).thenReturn(searchRequestBuilder);
                        }
        assertTrue(failure.get().getMessage().contains("Invalid JSON"));
            ruleQueryMapper
        UpdateRuleRequest updateRuleRequest = mock(UpdateRuleRequest.class);
            TEST_INDEX_NAME,
            }
        ArgumentCaptor<CreateRuleResponse> responseCaptor = ArgumentCaptor.forClass(CreateRuleResponse.class);
import org.opensearch.common.settings.Settings;
        SearchHit hit = new SearchHit(1);
        rulePersistenceService.createRule(createRuleRequest, listener);
        assertEquals(1, testListener.successCount.get());
            final AtomicInteger failureCount = new AtomicInteger();
    private SearchRequestBuilder searchRequestBuilder;
        when(searchResponse.getHits()).thenReturn(searchHits);
    public void testGetRuleByIdSuccess() {
import org.opensearch.action.delete.DeleteRequest;
        for (Exception e : testListener.failures) {
            MAX_VALUES_PER_PAGE,
}
        }
import org.opensearch.threadpool.ThreadPool;
            }
        Rule originalRule = mock(Rule.class);
        hit.sourceRef(new BytesArray(VALID_JSON));
        when(searchResponse.getHits()).thenReturn(searchHits);
        ThreadPool threadPool = mock(ThreadPool.class);
            assertTrue(e instanceof IllegalArgumentException);
        ) {
        ruleQueryMapper = mock(RuleQueryMapper.class);
            clusterService,
        when(getRuleRequest.getId()).thenReturn(_ID_ONE);
            assertTrue(e.getMessage().contains("Duplicate rule"));
        rulePersistenceService.createRule(createRuleRequest, listener);
                failureCount.incrementAndGet();
import org.opensearch.cluster.metadata.Metadata;
    public void testUpdateRule_RuleNotFound() {
import java.util.concurrent.atomic.AtomicInteger;
        rulePersistenceService.createRule(createRuleRequest, listener);
        when(originalRule.getAttributeMap()).thenReturn(ATTRIBUTE_MAP);
        when(createRuleRequest.getRule()).thenReturn(rule);
        when(client.threadPool()).thenReturn(threadPool);
            @Override
        boolean completed = latch.await(10, TimeUnit.SECONDS);
        when(client.threadPool()).thenReturn(threadPool);
    private RuleEntityParser ruleEntityParser;
            public void onResponse(CreateRuleResponse response) {
                });
        searchRequestBuilder = mock(SearchRequestBuilder.class);
        when(searchResponse.getHits()).thenReturn(
                        public void onResponse(Void unused) {
            ruleQueryMapper
        when(threadPool.getThreadContext()).thenReturn(threadContext);
            ActionListener.class
                failure.set(e);
            @Override
import org.opensearch.index.query.QueryBuilder;
        when(getRuleRequest.getAttributeFilters()).thenReturn(new HashMap<>());
                    String key = rule.getAttributeMap().toString();
            @Override
            }
            }
        class TestListener implements ActionListener<CreateRuleResponse> {
            }
    }
            ruleEntityParser,
import org.opensearch.core.common.bytes.BytesArray;
        ArgumentCaptor<GetRuleResponse> responseCaptor = ArgumentCaptor.forClass(GetRuleResponse.class);
    private RulePersistenceService rulePersistenceService;
        String ruleId = "test-rule-id";
                failure.set(e);
        when(ruleEntityParser.parse(anyString())).thenReturn(rule);
    }
        ArgumentCaptor<DeleteRequest> requestCaptor = ArgumentCaptor.forClass(DeleteRequest.class);
        when(updateRuleRequest.getAttributeMap()).thenReturn(ATTRIBUTE_MAP);
                            listener.onResponse(new UpdateRuleResponse(updatedRule));
                        public void onFailure(Exception e) {
 *
            MAX_VALUES_PER_PAGE,
import org.opensearch.action.index.IndexResponse;
                });
            new Thread(() -> rulePersistenceService.createRule(createRuleRequest, testListener)).start();
        DeleteRuleRequest request = new DeleteRuleRequest(ruleId, RuleTestUtils.MockRuleFeatureType.INSTANCE);
        Metadata metadata = mock(Metadata.class);
import org.opensearch.cluster.ClusterState;
                synchronized (storedAttributeMaps) {
import java.util.concurrent.atomic.AtomicReference;
        rulePersistenceService = new IndexStoredRulePersistenceService(
import java.util.List;
import static org.opensearch.rule.utils.RuleTestUtils.TEST_INDEX_NAME;
        when(originalRule.getDescription()).thenReturn(DESCRIPTION_ONE);
        when(searchResponse.getHits()).thenReturn(new SearchHits(new SearchHit[] {}, new TotalHits(0, TotalHits.Relation.EQUAL_TO), 1.0f));
        verify(client).delete(requestCaptor.capture(), listenerCaptor.capture());
        assertTrue("All create calls should complete", completed);
    }
        assertEquals(1, response.getRules().size());
        when(getRuleRequest.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
        UpdateRuleRequest request = mock(UpdateRuleRequest.class);
        );
            final AtomicInteger successCount = new AtomicInteger();
        );
        when(getRuleRequest.getFeatureType()).thenReturn(RuleTestUtils.MockRuleFeatureType.INSTANCE);
        Set<String> storedAttributeMaps = ConcurrentHashMap.newKeySet();
        ActionFuture<IndexResponse> future = mock(ActionFuture.class);
    }
        when(updateRuleRequest.getFeatureValue()).thenReturn(FEATURE_VALUE_ONE);
        rule = mock(Rule.class);
        assertEquals(ruleId, requestCaptor.getValue().id());
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            public void updateRule(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
                successCount.incrementAndGet();
            client,
import org.opensearch.action.DocWriteResponse;
import static org.mockito.Mockito.anyInt;
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_MAP;
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
                    Rule updatedRule = RuleUtils.composeUpdatedRule(originalRule, request, request.getFeatureType());
import static org.mockito.Mockito.any;
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);
import org.opensearch.index.engine.DocumentMissingException;
                    validateNoDuplicateRule(rule, new ActionListener<Void>() {
                    Rule rule = request.getRule();
        verify(listener).onResponse(responseCaptor.capture());
        when(updateRuleRequest.getDescription()).thenReturn(DESCRIPTION_TWO);
            }
        int threadCount = 10;
    public void testUpdateRule_ParseFailure() {
        when(deleteResponse.getResult()).thenReturn(DocWriteResponse.Result.DELETED);
        ArgumentCaptor<Exception> exceptionCaptor = ArgumentCaptor.forClass(OpenSearchRejectedExecutionException.class);
        Set<String> storedAttributeMaps = ConcurrentHashMap.newKeySet();
import org.opensearch.transport.client.Client;
import org.opensearch.rule.action.GetRuleRequest;
        SearchHit searchHit = new SearchHit(1, _ID_ONE, null, null);
        searchHit.sourceRef(new BytesArray(VALID_JSON));
import org.opensearch.rule.utils.RuleTestUtils;
import static org.opensearch.rule.XContentRuleParserTests.VALID_JSON;
import org.opensearch.action.search.SearchResponse;
        SearchResponse searchResponse = mock(SearchResponse.class);
        Client client = mock(Client.class);
import org.opensearch.rule.action.DeleteRuleRequest;
        verify(listener).onFailure(any(ResourceNotFoundException.class));
            TEST_INDEX_NAME,
import static org.opensearch.rule.utils.RuleTestUtils.ATTRIBUTE_VALUE_ONE;
import org.apache.lucene.search.TotalHits;
                                storedAttributeMaps.add(MOCK_RULE_ATTRIBUTE_ONE.getName());
            }
        when(searchRequestBuilder.get()).thenReturn(searchResponse);
        rulePersistenceService.updateRule(request, new ActionListener<>() {
        singleThreadExecutor.shutdown();
        when(searchRequestBuilder.setQuery(any(QueryBuilder.class))).thenReturn(searchRequestBuilder);
            public void validateNoDuplicateRule(Rule rule, ActionListener<Void> listener) {
import java.util.HashSet;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            public void onFailure(Exception e) {
        TestListener testListener = new TestListener();
        IndexResponse indexResponse = mock(IndexResponse.class);
/*
import org.opensearch.action.index.IndexRequest;
        assertEquals(threadCount - 1, testListener.failureCount.get());
        SearchResponse searchResponse = mock(SearchResponse.class);
            client,
import static org.mockito.Mockito.when;
            @Override
    }
import static org.mockito.ArgumentMatchers.anyString;
    }
            public void onFailure(Exception e) {
                singleThreadExecutor.execute(() -> {
import org.mockito.ArgumentCaptor;
    private ClusterService clusterService;
import static org.opensearch.rule.utils.RuleTestUtils.DESCRIPTION_TWO;
    private Rule rule;
            ruleEntityParser,
    public void testCardinalityCheckBasedFailure() throws Exception {
