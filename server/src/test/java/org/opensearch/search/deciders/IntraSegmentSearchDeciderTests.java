    public void testQuerySupportsIntraSegment() {
        QueryBuilder query = mock(QueryBuilder.class);  
        assertTrue(decider.shouldUseIntraSegmentSearch());
        decider.evaluateForAggregations(aggs);  
import static org.mockito.Mockito.mock;
        assertEquals("some aggregations do not support intra-segment search", decider.getReason());
        assertEquals("query/aggregations support intra-segment search", decider.getReason());
        assertEquals("no query or aggregation evaluated", decider.getReason());  
        decider.evaluateForAggregations(aggs);  
import org.opensearch.index.query.QueryBuilder;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.AggregatorFactories;
        assertEquals("test_query does not support intra-segment search", decider.getReason());  
        when(query.getName()).thenReturn("test_query");  
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();  
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
        QueryBuilder query = mock(QueryBuilder.class);  
        when(aggs.allFactoriesSupportIntraSegmentSearch()).thenReturn(false);  
    }
 * The OpenSearch Contributors require contributions made to  
        when(query.supportsIntraSegmentSearch()).thenReturn(true);  
 * compatible open source license.
        decider.evaluateForQuery(query);  
        AggregatorFactories aggs = mock(AggregatorFactories.class);
        when(query.supportsIntraSegmentSearch()).thenReturn(false);
        assertEquals("query/aggregations support intra-segment search", decider.getReason());
        decider.evaluateForQuery(query);
    public void testAggregationsSupportsIntraSegment() {
        assertTrue(decider.shouldUseIntraSegmentSearch());  
    }
 *
        decider.evaluateForQuery(query);
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();  
/*  
        QueryBuilder query = mock(QueryBuilder.class);
 * SPDX-License-Identifier: Apache-2.0
    public void testQueryYesAggregationNo() {  
        assertFalse(decider.shouldUseIntraSegmentSearch());
        when(query.getName()).thenReturn("test_query");
        decider.evaluateForAggregations(aggs);
        when(query.supportsIntraSegmentSearch()).thenReturn(true);  
    public void testQueryNoVetoesAggregationYes() {
        when(aggs.allFactoriesSupportIntraSegmentSearch()).thenReturn(true);
        QueryBuilder query = mock(QueryBuilder.class);
        AggregatorFactories aggs = mock(AggregatorFactories.class);
    }
        AggregatorFactories aggs = mock(AggregatorFactories.class);
        assertEquals("query/aggregations support intra-segment search", decider.getReason());  
        assertEquals("test_query does not support intra-segment search", decider.getReason());
import static org.mockito.Mockito.when;  
        assertFalse(decider.shouldUseIntraSegmentSearch());
        assertFalse(decider.shouldUseIntraSegmentSearch());
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
    }  
    public void testAggregationsDoesNotSupportIntraSegment() {
        assertFalse(decider.shouldUseIntraSegmentSearch());
        decider.evaluateForAggregations(aggs);
        assertFalse(decider.shouldUseIntraSegmentSearch());
    public void testQueryDoesNotSupportIntraSegment() {
    }
        when(query.supportsIntraSegmentSearch()).thenReturn(true);
        decider.evaluateForQuery(query);
        AggregatorFactories aggs = mock(AggregatorFactories.class);
}
    public void testBothSupport() {  
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
        assertTrue(decider.shouldUseIntraSegmentSearch());
    }  
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
 */  
        decider.evaluateForQuery(query);
package org.opensearch.search.deciders;
        when(aggs.allFactoriesSupportIntraSegmentSearch()).thenReturn(true);  
        when(aggs.allFactoriesSupportIntraSegmentSearch()).thenReturn(false);
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();
    }  
        QueryBuilder query = mock(QueryBuilder.class);
        IntraSegmentSearchDecider decider = new IntraSegmentSearchDecider();  
        assertEquals("some aggregations do not support intra-segment search", decider.getReason());  
        when(query.supportsIntraSegmentSearch()).thenReturn(false);
        decider.evaluateForAggregations(aggs);
        when(aggs.allFactoriesSupportIntraSegmentSearch()).thenReturn(true);  
import org.opensearch.test.OpenSearchTestCase;  
public class IntraSegmentSearchDeciderTests extends OpenSearchTestCase {
    }
    public void testNoQueryNoAggregations() {  
        AggregatorFactories aggs = mock(AggregatorFactories.class);
