    public void getRule(GetRuleRequest getRuleRequest, ActionListener<GetRuleResponse> listener) {
    }
        }
    }
            if (!clusterService.state().metadata().hasIndex(indexName)) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
     * This validation must be performed one at a time to prevent writing duplicate rules.
        });
            listener.onResponse(new CreateRuleResponse(rule));
import java.util.List;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.action.index.IndexRequest;
    private void performCardinalityCheck(ActionListener<CreateRuleResponse> listener) {
                duplicateRuleId.ifPresentOrElse(
import org.opensearch.rule.RuleUtils;
    private final RuleEntityParser parser;
     */
                        ActionListener.wrap(unused -> persistUpdatedRule(ruleId, updatedRule, listener), listener::onFailure)
     */
     * It ensures the index exists, validates for duplicate rules, and persists the new rule.
        this.clusterService = clusterService;
     * @param searchAfter - The sort values from the last document of the previous page, used for pagination
                public void onFailure(Exception e) {
import java.util.Set;
        try {
                );
            List<SearchHit> hits = Arrays.asList(searchResponse.getHits().getHits());
     * @param listener - ActionListener for UpdateRuleResponse
            client.index(indexRequest).get();
    }
     * @param parser
     * @param queryBuilder
    /**
    }
        }
    public IndexStoredRulePersistenceService(
            QueryBuilder query = queryBuilder.from(new GetRuleRequest(ruleId, new HashMap<>(), null, featureType));
        if (searchResponse.getHits().getTotalHits() != null && searchResponse.getHits().getTotalHits().value() >= maxAllowedRulesCount) {
     * Persist the updated rule in index
            }
                    );
 * The OpenSearch Contributors require contributions made to
    private void persistRule(Rule rule, ActionListener<CreateRuleResponse> listener) {
     */
    }
        try (ThreadContext.StoredContext ctx = stashContext()) {
    /**
    ) {
    @Override
                listener.onResponse(new AcknowledgedResponse(acknowledged));
                        return;
     * @param queryBuilder query object
            }));
package org.opensearch.rule.service;
    /**
    private final String indexName;
            }
     */
     *  max wlm rules setting name
public class IndexStoredRulePersistenceService implements RulePersistenceService {
    private static final Logger logger = LogManager.getLogger(IndexStoredRulePersistenceService.class);
     */
        this.queryBuilder = queryBuilder;
        this.maxAllowedRulesCount = MAX_WLM_RULES_SETTING.get(clusterService.getSettings());
    private final RuleQueryMapper<QueryBuilder> queryBuilder;
     * Validates that no existing rule has the same attribute map as the given rule.
        listener.onResponse(new GetRuleResponse(ruleList, nextSearchAfter));
            logger.error("Rule with ID " + id + " not found.");
    private final Client client;
        this.maxAllowedRulesCount = maxAllowedRules;
import org.opensearch.rule.RuleQueryMapper;
     * @param listener - ActionListener for GetRuleResponse
            getRuleFromIndex(getRuleRequest.getId(), getQueryBuilder, getRuleRequest.getSearchAfter(), listener);
            } else {
    private int maxAllowedRulesCount;
     * Persist the rule in the index
import org.opensearch.transport.client.Client;
            SearchResponse searchResponse = searchRequest.get();
    /**
            listener.onResponse(new UpdateRuleResponse(updatedRule));
    private ThreadContext.StoredContext stashContext() {
    }
        } catch (Exception e) {
                Rule rule = request.getRule();
 * This class encapsulates the logic to manage the lifecycle of rules at index level
        500,
        } catch (Exception e) {
            public void onFailure(Exception e) {
    /**
            logger.error("Failed to fetch all rules: {}", e.getMessage());
        MAX_RULES_COUNT_SETTING_NAME,
import org.opensearch.action.search.SearchRequestBuilder;
        SearchResponse searchResponse = client.prepareSearch(indexName).setQuery(queryBuilder.getCardinalityQuery()).get();
        try (ThreadContext.StoredContext context = stashContext()) {
import org.opensearch.rule.action.UpdateRuleRequest;
            }
                    logger.error("Rule with ID " + request.getRuleId() + " not found.");
        try {
            listener.onFailure(new RuntimeException("Failed to update rule to index."));
import org.opensearch.search.sort.SortOrder;
                }
                Optional<String> duplicateRuleId = RuleUtils.getDuplicateRuleId(rule, getRuleResponse.getRules());
     * @param updatedRule - the rule we update to
            UpdateRequest updateRequest = new UpdateRequest(indexName, ruleId).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            if (hasNoResults(id, listener, hits)) return;
     * @param rule - the rule we check duplicate against
        }
import org.opensearch.rule.action.GetRuleRequest;
import org.opensearch.index.IndexNotFoundException;
     * Default value for max rules count
                        listener.onFailure(new ResourceNotFoundException("Rule with ID " + ruleId + " not found."));
            client.update(updateRequest).get();
                    if (getRuleResponse == null || getRuleResponse.getRules().isEmpty()) {
import org.opensearch.rule.autotagging.FeatureType;
    }
     * @param ruleId - the rule id to update
import org.opensearch.action.search.SearchResponse;
        DEFAULT_MAX_ALLOWED_RULE_COUNT,
        List<Rule> ruleList = hits.stream().map(hit -> parser.parse(hit.getSourceAsString())).toList();
        } catch (Exception e) {
            SearchRequestBuilder searchRequest = client.prepareSearch(indexName).setQuery(queryBuilder).setSize(maxRulesPerPage);
        }
                    validateNoDuplicateRule(
        try {
                performCardinalityCheck(listener);
                listener.onFailure(e);
     * This service handles persistence and retrieval of stored rules within an OpenSearch index.
        if (id != null && hits.isEmpty()) {
import org.opensearch.search.SearchHit;
     * Entry point for the get rule api logic in persistence service.
                validateNoDuplicateRule(rule, ActionListener.wrap(unused -> persistRule(rule, listener), listener::onFailure));
                if (e instanceof DocumentMissingException) {
            return true;
import org.opensearch.rule.RuleEntityParser;
     */
                    () -> listener.onResponse(null)
import org.opensearch.rule.action.CreateRuleResponse;
    );
}
                }
     *  max wlm rules setting
        return false;
     * @param listener the listener for GetRuleResponse.
                listener.onFailure(new IllegalStateException("Index" + indexName + " does not exist"));
import org.apache.logging.log4j.LogManager;
import org.opensearch.action.delete.DeleteRequest;
import java.util.Arrays;
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_WLM_RULES_SETTING, this::setMaxAllowedRules);
     * @param maxRulesPerPage - The maximum number of rules that can be returned in a single get request.
 */
     * Otherwise, we get all rules that satisfy the attributeFilters.
 *
        try (ThreadContext.StoredContext context = stashContext()) {
        String indexName,
import org.opensearch.rule.action.UpdateRuleResponse;
                handleGetRuleResponse(new ArrayList<>(), listener);
            logger.error("Error updating rule in index: {}", indexName);
import org.apache.logging.log4j.Logger;
     * @param listener - listener for validateNoDuplicateRule response
        return client.threadPool().getThreadContext().stashContext();
/*
     * Process searchResponse from index and send a GetRuleResponse
    }
import java.util.Optional;
                }
    public void updateRule(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
     * @param listener - ActionListener for GetRuleResponse
        }
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.rule.action.GetRuleResponse;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
     * @param rule - The rule to update.
                        updatedRule,
            @Override
import org.opensearch.cluster.service.ClusterService;
            if (searchAfter != null) {
import java.util.ArrayList;
            );
                    logger.error("Failed to delete rule: {}", e.getMessage());
                .source(rule.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));
     */
                logger.error("Index {} does not exist", indexName);
     * @param clusterService
        Map<String, Set<String>> attributeFilters = RuleUtils.buildAttributeFilters(rule);
import org.opensearch.ResourceNotFoundException;
import org.opensearch.action.DocWriteResponse;
            }
        }
            final QueryBuilder getQueryBuilder = queryBuilder.from(getRuleRequest);
        this.client = client;
                    listener.onFailure(e);
                )
    /**
import org.opensearch.core.action.ActionListener;
            listener.onFailure(
        Setting.Property.NodeScope,
        int maxRulesPerPage,
                logger.debug("Failed to get rule from index [{}]: index doesn't exist.", indexName);
    }
        }
import org.opensearch.action.support.WriteRequest;
            listener.onFailure(e);
                        + ". Please delete some stale or redundant rules first"
        String ruleId = request.getId();
                    List<Rule> ruleList = getRuleResponse.getRules();
import org.opensearch.common.xcontent.XContentFactory;
            IndexRequest indexRequest = new IndexRequest(indexName).id(rule.getId())
     */
 * compatible open source license.
     * Entry point for the update rule api logic in persistence service.
        this.indexName = indexName;
    /**
     * @param listener ActionListener for CreateRuleResponse
    private void setMaxAllowedRules(int maxAllowedRules) {
                public void onResponse(GetRuleResponse getRuleResponse) {
    }
     * @param listener - ActionListener for CreateRuleResponse
                new OpenSearchRejectedExecutionException(
     * @param client - The OpenSearch client used to interact with the OpenSearch cluster.
    }
            @Override
    void handleGetRuleResponse(List<SearchHit> hits, ActionListener<GetRuleResponse> listener) {
                searchRequest.addSort("_id", SortOrder.ASC).searchAfter(new Object[] { searchAfter });
import org.opensearch.rule.autotagging.Rule;
     * Entry point for the create rule API logic in persistence service.
                    assert ruleList.size() == 1;
     * @param request - The UpdateRuleRequest
            listener.onFailure(new ResourceNotFoundException("Rule with ID " + id + " not found."));
                        + " the cardinality limit of "
            getRuleFromIndex(ruleId, query, null, new ActionListener<>() {
        try (ThreadContext.StoredContext context = stashContext()) {
import org.opensearch.rule.action.CreateRuleRequest;
                    "This create operation will violate"
                    }
        ClusterService clusterService,
        }
                    Rule updatedRule = RuleUtils.composeUpdatedRule(ruleList.get(0), request, featureType);
                @Override
 * this file be licensed under the Apache-2.0 license or a
     */
        this.parser = parser;
            }, e -> {
import org.opensearch.common.util.concurrent.ThreadContext;
     * Constructs an instance of {@link IndexStoredRulePersistenceService} with the specified parameters.
        this.maxRulesPerPage = maxRulesPerPage;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.index.engine.DocumentMissingException;
import java.util.HashMap;
                    listener.onFailure(new ResourceNotFoundException("Rule with ID " + request.getRuleId() + " not found."));
    public void deleteRule(DeleteRuleRequest request, ActionListener<AcknowledgedResponse> listener) {
            listener.onFailure(new RuntimeException("Failed to save rule to index."));
     * @param listener - ActionListener for UpdateRuleResponse
            public void onResponse(GetRuleResponse getRuleResponse) {
    public static final int DEFAULT_MAX_ALLOWED_RULE_COUNT = 200;
 */
 * SPDX-License-Identifier: Apache-2.0
     * @param hits - Response received from index
                .doc(updatedRule.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));
            logger.error("Error saving rule to index: {}", indexName);
        String nextSearchAfter = hits.isEmpty() || hits.size() < maxRulesPerPage ? null : hits.get(hits.size() - 1).getId();
     */
                return;
    /**
                } else {
    public static final String MAX_RULES_COUNT_SETTING_NAME = "wlm.autotagging.max_rules";
        10,
                    listener.onFailure(e);
            client.delete(deleteRequest, ActionListener.wrap(deleteResponse -> {
    private void getRuleFromIndex(String id, QueryBuilder queryBuilder, String searchAfter, ActionListener<GetRuleResponse> listener) {
        FeatureType featureType = request.getFeatureType();
                        + DEFAULT_MAX_ALLOWED_RULE_COUNT
        Client client,
            if (e instanceof IndexNotFoundException) {
                    id -> listener.onFailure(new IllegalArgumentException("Duplicate rule exists under id " + id)),
    private static boolean hasNoResults(String id, ActionListener<GetRuleResponse> listener, List<SearchHit> hits) {
     */
                    logger.warn("Rule with ID " + request.getRuleId() + " was not found or already deleted.");
    /**
    }
    }
        QueryBuilder query = queryBuilder.from(new GetRuleRequest(null, attributeFilters, null, rule.getFeatureType()));
 * @opensearch.experimental
    private final ClusterService clusterService;
    }
        RuleQueryMapper<QueryBuilder> queryBuilder
    /**
import org.opensearch.common.settings.Setting;
        }
    /**
                }
        Setting.Property.Dynamic
    private void persistUpdatedRule(String ruleId, Rule updatedRule, ActionListener<UpdateRuleResponse> listener) {
import org.opensearch.action.update.UpdateRequest;
    private void validateNoDuplicateRule(Rule rule, ActionListener<Void> listener) {
/**
            });
        RuleEntityParser parser,
     * Get rules from index. If id is provided, we only get a single rule.
     * @param request  The CreateRuleRequest
            DeleteRequest deleteRequest = new DeleteRequest(indexName).id(request.getRuleId());
import org.opensearch.rule.action.DeleteRuleRequest;
     * @param getRuleRequest the getRuleRequest to process.
    public void createRule(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener) {
     */
            }
                boolean acknowledged = deleteResponse.getResult() == DocWriteResponse.Result.DELETED;
                @Override
    private final int maxRulesPerPage;
import java.util.Map;
     * @param indexName - The name of the OpenSearch index where the rules are stored.
import org.opensearch.rule.RulePersistenceService;
    /**
    public static final Setting<Integer> MAX_WLM_RULES_SETTING = Setting.intSetting(
                if (!acknowledged) {
            handleGetRuleResponse(hits, listener);
        getRuleFromIndex(null, query, null, new ActionListener<>() {
