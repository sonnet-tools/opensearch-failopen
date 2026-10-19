 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
    RuleQueryMapper<QueryBuilder> sut;
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder query = sut.from(
        Map<String, Set<String>> attributeFilters = RuleTestUtils.ATTRIBUTE_MAP.entrySet()  
package org.opensearch.rule;
import java.util.Set;
        assertEquals(1, query.must().size());
import org.opensearch.test.OpenSearchTestCase;  
    }  
            .stream()
import java.util.HashMap;
import org.opensearch.rule.utils.RuleTestUtils;
        QueryBuilder queryBuilder = sut.from(new GetRuleRequest(null, attributeFilters, null, RuleTestUtils.MockRuleFeatureType.INSTANCE));
import java.util.stream.Collectors;
            new GetRuleRequest(RuleTestUtils._ID_ONE, new HashMap<>(), null, RuleTestUtils.MockRuleFeatureType.INSTANCE)
        super.setUp();
        sut = new IndexBasedRuleQueryMapper();  
 * compatible open source license.
        assertNotNull(queryBuilder);
public class IndexStoredRuleUtilsTests extends OpenSearchTestCase {
        assertEquals(1, queryBuilder.must().size());  
        assertTrue(idQuery.toString().contains(RuleTestUtils._ID_ONE));
 * SPDX-License-Identifier: Apache-2.0
    public void testBuildGetRuleQuery_WithAttributes() {
        );  
        assertNotNull(query);
        QueryBuilder idQuery = queryBuilder.must().get(0);
    public void setUp() throws Exception {
import org.opensearch.rule.storage.IndexBasedRuleQueryMapper;
    }
 *
        assertTrue(query.toString().contains(RuleTestUtils.MockRuleAttributes.MOCK_RULE_ATTRIBUTE_ONE.getName()));
}
/*  
            .collect(Collectors.toMap(e -> e.getKey().getName(), Map.Entry::getValue));
        BoolQueryBuilder query = (BoolQueryBuilder) queryBuilder;  
    public void testBuildGetRuleQuery_WithId() {  
 */  
import org.opensearch.index.query.BoolQueryBuilder;
        assertTrue(query.toString().contains(RuleTestUtils.ATTRIBUTE_VALUE_ONE));  
        BoolQueryBuilder queryBuilder = (BoolQueryBuilder) query;
    }
import org.opensearch.rule.action.GetRuleRequest;  
