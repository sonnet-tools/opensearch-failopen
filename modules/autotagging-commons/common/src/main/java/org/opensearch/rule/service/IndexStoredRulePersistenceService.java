                    }  
            if (!clusterService.state().metadata().hasIndex(indexName)) {  
        RuleQueryMapper<QueryBuilder> queryBuilder  
        DEFAULT_MAX_ALLOWED_RULE_COUNT,
            } else {  
import java.util.Set;  
/*  
     */  
    /**  
 * The OpenSearch Contributors require contributions made to  
            listener.onFailure(e);
     * Entry point for the get rule api logic in persistence service.
     * Persist the updated rule in index
            UpdateRequest updateRequest = new UpdateRequest(indexName, ruleId).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    assert ruleList.size() == 1;
     * Entry point for the create rule API logic in persistence service.
import org.opensearch.core.xcontent.ToXContent;  
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                        + ". Please delete some stale or redundant rules first"
        } catch (Exception e) {  
            }
                    logger.error("Failed to delete rule: {}", e.getMessage());
    private void persistRule(Rule rule, ActionListener<CreateRuleResponse> listener) {
import org.opensearch.common.settings.Setting;
                duplicateRuleId.ifPresentOrElse(
        }  
import java.util.HashMap;
            logger.error("Rule with ID " + id + " not found.");
import org.opensearch.rule.RulePersistenceService;
     * @param listener - ActionListener for UpdateRuleResponse
    private void validateNoDuplicateRule(Rule rule, ActionListener<Void> listener) {
                );
import org.opensearch.index.engine.DocumentMissingException;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            listener.onResponse(new UpdateRuleResponse(updatedRule));
    private ThreadContext.StoredContext stashContext() {  
        500,  
import org.opensearch.action.delete.DeleteRequest;
                @Override
                listener.onFailure(new IllegalStateException("Index" + indexName + " does not exist"));
            IndexRequest indexRequest = new IndexRequest(indexName).id(rule.getId())
            logger.error("Error saving rule to index: {}", indexName);
                boolean acknowledged = deleteResponse.getResult() == DocWriteResponse.Result.DELETED;  
            listener.onResponse(new CreateRuleResponse(rule));
     * This service handles persistence and retrieval of stored rules within an OpenSearch index.
    private final int maxRulesPerPage;  
     *  max wlm rules setting name
     */  
        this.client = client;  
public class IndexStoredRulePersistenceService implements RulePersistenceService {  
            SearchRequestBuilder searchRequest = client.prepareSearch(indexName).setQuery(queryBuilder).setSize(maxRulesPerPage);  
     */  
        try (ThreadContext.StoredContext ctx = stashContext()) {
     * @param getRuleRequest the getRuleRequest to process.
                if (e instanceof DocumentMissingException) {  
                public void onFailure(Exception e) {
                performCardinalityCheck(listener);
    }
     * @param listener the listener for GetRuleResponse.  
import org.apache.logging.log4j.LogManager;
        } catch (Exception e) {  
    private void performCardinalityCheck(ActionListener<CreateRuleResponse> listener) {
                listener.onFailure(e);
                }  
        this.maxAllowedRulesCount = maxAllowedRules;
        try (ThreadContext.StoredContext context = stashContext()) {  
 * @opensearch.experimental
    }  
                        listener.onFailure(new ResourceNotFoundException("Rule with ID " + ruleId + " not found."));
        try (ThreadContext.StoredContext context = stashContext()) {  
            listener.onFailure(new RuntimeException("Failed to save rule to index."));
            if (e instanceof IndexNotFoundException) {
     * It ensures the index exists, validates for duplicate rules, and persists the new rule.  
                    () -> listener.onResponse(null)
import java.util.ArrayList;  
        MAX_RULES_COUNT_SETTING_NAME,  
            DeleteRequest deleteRequest = new DeleteRequest(indexName).id(request.getRuleId());
            }  
                        ActionListener.wrap(unused -> persistUpdatedRule(ruleId, updatedRule, listener), listener::onFailure)  
        this.clusterService = clusterService;
                return;
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_WLM_RULES_SETTING, this::setMaxAllowedRules);  
     * @param request  The CreateRuleRequest
        String ruleId = request.getId();
import org.opensearch.common.util.concurrent.ThreadContext;
    );  
    }  
            logger.error("Failed to fetch all rules: {}", e.getMessage());  
            );  
            listener.onFailure(new RuntimeException("Failed to update rule to index."));
                    id -> listener.onFailure(new IllegalArgumentException("Duplicate rule exists under id " + id)),  
    }
                    listener.onFailure(e);  
     * Validates that no existing rule has the same attribute map as the given rule.
     * @param clusterService
 *
            client.update(updateRequest).get();
    }  
                    logger.warn("Rule with ID " + request.getRuleId() + " was not found or already deleted.");
            if (searchAfter != null) {
    private final RuleEntityParser parser;
    void handleGetRuleResponse(List<SearchHit> hits, ActionListener<GetRuleResponse> listener) {
    private int maxAllowedRulesCount;
 * this file be licensed under the Apache-2.0 license or a
        Client client,
import java.util.Arrays;
                        return;
        });  
     * @param parser  
            @Override
        return client.threadPool().getThreadContext().stashContext();
                logger.error("Index {} does not exist", indexName);
        this.maxAllowedRulesCount = MAX_WLM_RULES_SETTING.get(clusterService.getSettings());
    }
     * @param rule - The rule to update.
import org.opensearch.rule.autotagging.FeatureType;  
                searchRequest.addSort("_id", SortOrder.ASC).searchAfter(new Object[] { searchAfter });
                logger.debug("Failed to get rule from index [{}]: index doesn't exist.", indexName);
 */
     */
     * @param maxRulesPerPage - The maximum number of rules that can be returned in a single get request.
        try (ThreadContext.StoredContext context = stashContext()) {
import org.apache.logging.log4j.Logger;
     * @param listener - listener for validateNoDuplicateRule response
 */  
     *  max wlm rules setting  
            public void onResponse(GetRuleResponse getRuleResponse) {  
        if (searchResponse.getHits().getTotalHits() != null && searchResponse.getHits().getTotalHits().value() >= maxAllowedRulesCount) {
        }
import org.opensearch.rule.RuleEntityParser;
    }
     */  
import org.opensearch.rule.action.GetRuleRequest;
        }
import org.opensearch.action.DocWriteResponse;
     * @param listener - ActionListener for GetRuleResponse
        }
        this.maxRulesPerPage = maxRulesPerPage;
import org.opensearch.rule.autotagging.Rule;
     * Persist the rule in the index
     * @param hits - Response received from index
    private static boolean hasNoResults(String id, ActionListener<GetRuleResponse> listener, List<SearchHit> hits) {
     */
import org.opensearch.rule.RuleQueryMapper;  
            if (hasNoResults(id, listener, hits)) return;
                    listener.onFailure(new ResourceNotFoundException("Rule with ID " + request.getRuleId() + " not found."));
            final QueryBuilder getQueryBuilder = queryBuilder.from(getRuleRequest);
    public IndexStoredRulePersistenceService(  
        this.indexName = indexName;
import org.opensearch.rule.action.UpdateRuleRequest;
    }  
    /**
    public void deleteRule(DeleteRuleRequest request, ActionListener<AcknowledgedResponse> listener) {
                        + DEFAULT_MAX_ALLOWED_RULE_COUNT  
            return true;  
    /**  
import org.opensearch.rule.action.DeleteRuleRequest;
    private final Client client;
                    List<Rule> ruleList = getRuleResponse.getRules();
     * @param queryBuilder
    }
                        updatedRule,
import org.opensearch.index.IndexNotFoundException;
/**
     */  
        String nextSearchAfter = hits.isEmpty() || hits.size() < maxRulesPerPage ? null : hits.get(hits.size() - 1).getId();  
     * @param ruleId - the rule id to update
            client.index(indexRequest).get();
     */  
                }
import org.opensearch.search.sort.SortOrder;  
                handleGetRuleResponse(new ArrayList<>(), listener);  
    private final String indexName;  
            handleGetRuleResponse(hits, listener);
import org.opensearch.rule.action.CreateRuleRequest;
     * Otherwise, we get all rules that satisfy the attributeFilters.
 * This class encapsulates the logic to manage the lifecycle of rules at index level  
        }  
            }
        getRuleFromIndex(null, query, null, new ActionListener<>() {
     * @param searchAfter - The sort values from the last document of the previous page, used for pagination
                Rule rule = request.getRule();
     */
    /**  
        try {
    ) {
            getRuleFromIndex(ruleId, query, null, new ActionListener<>() {  
import org.opensearch.rule.action.CreateRuleResponse;  
                        + " the cardinality limit of "
            }, e -> {
        }
     * Get rules from index. If id is provided, we only get a single rule.
 * compatible open source license.
     * @param updatedRule - the rule we update to  
        int maxRulesPerPage,
        this.parser = parser;  
import org.opensearch.action.search.SearchResponse;
                    listener.onFailure(e);
import org.opensearch.index.query.QueryBuilder;  
    /**
import org.opensearch.rule.action.GetRuleResponse;  
    public static final Setting<Integer> MAX_WLM_RULES_SETTING = Setting.intSetting(
    /**
            }  
            });
                    validateNoDuplicateRule(
    public void createRule(CreateRuleRequest request, ActionListener<CreateRuleResponse> listener) {
        RuleEntityParser parser,
            }));
    }
        Map<String, Set<String>> attributeFilters = RuleUtils.buildAttributeFilters(rule);
import org.opensearch.ResourceNotFoundException;  
            listener.onFailure(
        }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        if (id != null && hits.isEmpty()) {  
    public static final int DEFAULT_MAX_ALLOWED_RULE_COUNT = 200;
    /**
}  
                    "This create operation will violate"
     * Default value for max rules count
import org.opensearch.action.search.SearchRequestBuilder;
        return false;
                    );
import java.util.Map;
     */
     * Entry point for the update rule api logic in persistence service.  
            List<SearchHit> hits = Arrays.asList(searchResponse.getHits().getHits());  
                @Override
    public void getRule(GetRuleRequest getRuleRequest, ActionListener<GetRuleResponse> listener) {
        SearchResponse searchResponse = client.prepareSearch(indexName).setQuery(queryBuilder.getCardinalityQuery()).get();  
            SearchResponse searchResponse = searchRequest.get();
import org.opensearch.rule.RuleUtils;
    private void getRuleFromIndex(String id, QueryBuilder queryBuilder, String searchAfter, ActionListener<GetRuleResponse> listener) {
        try {
import org.opensearch.action.support.WriteRequest;  
            logger.error("Error updating rule in index: {}", indexName);
     * @param client - The OpenSearch client used to interact with the OpenSearch cluster.  
    /**
            @Override
                public void onResponse(GetRuleResponse getRuleResponse) {
                validateNoDuplicateRule(rule, ActionListener.wrap(unused -> persistRule(rule, listener), listener::onFailure));  
import org.opensearch.rule.action.UpdateRuleResponse;
     */
            getRuleFromIndex(getRuleRequest.getId(), getQueryBuilder, getRuleRequest.getSearchAfter(), listener);
        Setting.Property.NodeScope,
                    if (getRuleResponse == null || getRuleResponse.getRules().isEmpty()) {  
    private static final Logger logger = LogManager.getLogger(IndexStoredRulePersistenceService.class);  
        FeatureType featureType = request.getFeatureType();  
import org.opensearch.core.action.ActionListener;
                }  
     * @param listener - ActionListener for CreateRuleResponse  
     * Constructs an instance of {@link IndexStoredRulePersistenceService} with the specified parameters.  
                listener.onResponse(new AcknowledgedResponse(acknowledged));
     * This validation must be performed one at a time to prevent writing duplicate rules.  
        List<Rule> ruleList = hits.stream().map(hit -> parser.parse(hit.getSourceAsString())).toList();
        QueryBuilder query = queryBuilder.from(new GetRuleRequest(null, attributeFilters, null, rule.getFeatureType()));  
import org.opensearch.transport.client.Client;
     * @param listener - ActionListener for UpdateRuleResponse
    /**  
     */
            client.delete(deleteRequest, ActionListener.wrap(deleteResponse -> {
                .doc(updatedRule.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));  
     * Process searchResponse from index and send a GetRuleResponse  
import org.opensearch.common.xcontent.XContentFactory;  
import java.util.List;  
    }
            listener.onFailure(new ResourceNotFoundException("Rule with ID " + id + " not found."));
    private void setMaxAllowedRules(int maxAllowedRules) {  
        ClusterService clusterService,  
 * SPDX-License-Identifier: Apache-2.0
    public void updateRule(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
        }  
                    logger.error("Rule with ID " + request.getRuleId() + " not found.");
        10,
            }
        String indexName,
     * @param indexName - The name of the OpenSearch index where the rules are stored.
        } catch (Exception e) {  
                } else {  
package org.opensearch.rule.service;
    public static final String MAX_RULES_COUNT_SETTING_NAME = "wlm.autotagging.max_rules";  
                if (!acknowledged) {
        Setting.Property.Dynamic
        }  
    /**
                    Rule updatedRule = RuleUtils.composeUpdatedRule(ruleList.get(0), request, featureType);  
    @Override
    private void persistUpdatedRule(String ruleId, Rule updatedRule, ActionListener<UpdateRuleResponse> listener) {  
    /**  
     * @param listener ActionListener for CreateRuleResponse
    /**
                Optional<String> duplicateRuleId = RuleUtils.getDuplicateRuleId(rule, getRuleResponse.getRules());
                }
     * @param request - The UpdateRuleRequest
    }
        this.queryBuilder = queryBuilder;
    private final ClusterService clusterService;
     * @param queryBuilder query object  
import org.opensearch.action.index.IndexRequest;  
            QueryBuilder query = queryBuilder.from(new GetRuleRequest(ruleId, new HashMap<>(), null, featureType));
        try {  
import java.util.Optional;
    }
     * @param listener - ActionListener for GetRuleResponse
            public void onFailure(Exception e) {  
     * @param rule - the rule we check duplicate against
                new OpenSearchRejectedExecutionException(  
import org.opensearch.cluster.service.ClusterService;  
    private final RuleQueryMapper<QueryBuilder> queryBuilder;
                .source(rule.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));  
                )
        listener.onResponse(new GetRuleResponse(ruleList, nextSearchAfter));
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.search.SearchHit;
