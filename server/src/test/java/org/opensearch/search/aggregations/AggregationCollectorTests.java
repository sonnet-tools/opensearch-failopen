    private List<Aggregator> createNonGlobalAggregators(String agg) throws IOException {
        String fieldAgg = "{ \"my_terms\": {\"terms\": {\"field\": \"f\"}}}";  
 *  
 * The OpenSearch Contributors require contributions made to  
        final AggregatorFactories factories = getAggregationFactories(agg);  
        final List<Aggregator> topLevelAggregators = createTopLevelAggregators(globalAgg);
        return factories.createTopLevelGlobalAggregators(context);
import java.util.List;
        assertEquals(1, aggregators.size());
        final AggregatorFactories factories = getAggregationFactories(agg);
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
/*
        return factories.createTopLevelNonGlobalAggregators(context);  
    public void testNonGlobalTopLevelAggregators() throws Exception {
    private boolean needsScores(String agg) throws IOException {
    public void testNeedsScores() throws Exception {  
        // top_hits is a particular example of an aggregation that needs scores
 *
        String subFieldAgg = "{ \"my_outer_terms\": { \"terms\": { \"field\": \"f\" }, \"aggs\": " + fieldAgg + "}}";
import java.io.IOException;
        assertFalse(needsScores(fieldAgg));  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        // String scriptAgg = "{ \"my_terms\": {\"terms\": {\"script\": \"doc['f'].value\"}}}";
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
public class AggregationCollectorTests extends AggregationSetupTests {
    }
        // String subScriptAgg = "{ \"my_outer_terms\": { \"terms\": { \"field\": \"f\" }, \"aggs\": " + scriptAgg + "}}";
import org.opensearch.search.aggregations.bucket.terms.NumericTermsAggregator;
        assertTrue(aggregators.get(0) instanceof NumericTermsAggregator);
    }
        // global aggregation  
        final List<Aggregator> aggregators = createNonGlobalAggregators(fieldAgg);
 * not use this file except in compliance with the License.
        assertEquals(topLevelAggregators.size(), aggregators.size());  
    private List<Aggregator> createGlobalAggregators(String agg) throws IOException {  
        // make sure the information is propagated to sub aggregations
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
    }  
 * KIND, either express or implied.  See the License for the
    public void testGlobalAggregators() throws Exception {
        // assertTrue(needsScores(index, subScriptAgg));
 *
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations;
 * Modifications Copyright OpenSearch Contributors. See
        // agg on a script => scores are needed
        final List<Aggregator> topLevelAggregators = createTopLevelAggregators(fieldAgg);
        return aggregators.get(0).scoreMode().needsScores();
        assertFalse(needsScores(subFieldAgg));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private List<Aggregator> createTopLevelAggregators(String agg) throws IOException {
        assertTrue(needsScores(topHitsAgg));
 * specific language governing permissions and limitations
        // simple field aggregation
        assertTrue(aggregators.get(0) instanceof GlobalAggregator);
        final AggregatorFactories factories = getAggregationFactories(agg);
        // assertTrue(needsScores(index, scriptAgg));
        assertEquals(topLevelAggregators.get(0).name(), aggregators.get(0).name());
    }  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        String topHitsAgg = "{ \"my_hits\": {\"top_hits\": {}}}";  
 * software distributed under the License is distributed on an
    }  
    }
        // TODO: can we use a mock script service here?  
        final List<Aggregator> aggregators = createGlobalAggregators(globalAgg);
 */  
        // simple field aggregation, no scores needed
 */
        assertEquals(topLevelAggregators.size(), aggregators.size());  
        final List<Aggregator> aggregators = createTopLevelAggregators(agg);  
    }  
 * this work for additional information regarding copyright
        String fieldAgg = "{ \"my_terms\": {\"terms\": {\"field\": \"f\"}}}";
        return factories.createTopLevelAggregators(context);
        //  
/*  
 * compatible open source license.
        assertEquals(topLevelAggregators.get(0).name(), aggregators.get(0).name());
/*  
 * ownership. Elasticsearch licenses this file to you under  
}
