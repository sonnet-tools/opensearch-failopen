        for (Map.Entry<String, Set<String>> entry : attributeFilters.entrySet()) {
        final BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    @Override  
                }  
     */
import org.opensearch.index.query.BoolQueryBuilder;
import java.util.Set;
import org.opensearch.index.query.QueryBuilder;  
        final Map<String, Set<String>> attributeFilters = request.getAttributeFilters();
 * this file be licensed under the Apache-2.0 license or a
                for (String value : values) {
import org.opensearch.index.query.QueryBuilders;
 */
            }
 *
    public IndexBasedRuleQueryMapper() {}  
            Set<String> values = entry.getValue();  
        if (id != null) {  
        for (BoolQueryBuilder groupQuery : groupedQueries.values()) {  
        Map<String, BoolQueryBuilder> groupedQueries = new HashMap<>();  
     * Default constructor
    /**  
import java.util.Map;  
import org.opensearch.rule.RuleQueryMapper;
    }
    public QueryBuilder getCardinalityQuery() {
    public QueryBuilder from(GetRuleRequest request) {  
    }  
        return QueryBuilders.matchAllQuery();
            if (values != null && !values.isEmpty()) {
                BoolQueryBuilder groupQuery = groupedQueries.computeIfAbsent(topLevelAttribute, k -> QueryBuilders.boolQuery());  
 * This class is used to build opensearch index based query object
/**  
 * The OpenSearch Contributors require contributions made to  
        }
package org.opensearch.rule.storage;
import org.opensearch.common.annotation.ExperimentalApi;
            String attribute = entry.getKey();
    @Override
import org.opensearch.rule.action.GetRuleRequest;  
/*  
 * SPDX-License-Identifier: Apache-2.0
 */  
import java.util.HashMap;
        final String id = request.getId();  
                String topLevelAttribute = attribute.contains(".") ? attribute.substring(0, attribute.indexOf('.')) : attribute;
            boolQuery.must(groupQuery);
        boolQuery.filter(QueryBuilders.existsQuery(request.getFeatureType().getName()));
public class IndexBasedRuleQueryMapper implements RuleQueryMapper<QueryBuilder> {
@ExperimentalApi  
            return boolQuery.must(QueryBuilders.termQuery("_id", id));
        }
 * compatible open source license.
}
                    groupQuery.should(QueryBuilders.termQuery(attribute + ".keyword", value));
        }
        return boolQuery;  
