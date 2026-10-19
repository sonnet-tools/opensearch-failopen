        );
 * not use this file except in compliance with the License.
        );  
 * GitHub history for details.
            equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST)
import org.opensearch.search.aggregations.AggregatorFactories;
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, 10, -1, context),  
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.equalTo;  
        assertThat(  
 * KIND, either express or implied.  See the License for the
        );
import org.opensearch.test.OpenSearchTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(
    }
 * under the License.  
/*  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        assertThat(
}  
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, 10, 10, context),
        AggregatorFactories nonEmpty = mock(AggregatorFactories.class);
        );
        when(nonEmpty.countAggregators()).thenReturn(1);  
    }
 * You may obtain a copy of the License at  
        assertThat(
 *
            equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST)
 */  
/*
import static org.mockito.Mockito.when;
package org.opensearch.search.aggregations.bucket.terms;
 * specific language governing permissions and limitations
        when(empty.countAggregators()).thenReturn(0);
 * Modifications Copyright OpenSearch Contributors. See
public class TermsAggregatorFactoryTests extends OpenSearchTestCase {
        SearchContext context = mock(SearchContext.class);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 * this file be licensed under the Apache-2.0 license or a
 *  
            TermsAggregatorFactory.pickSubAggCollectMode(empty, randomInt(), randomInt(), context),
 */
            equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST)  
            equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST)  
 *
        assertThat(
        );
 * ownership. Elasticsearch licenses this file to you under  
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, 10, 5, context),
 * Licensed to Elasticsearch under one or more contributor  
        );
 * this work for additional information regarding copyright
        AggregatorFactories empty = mock(AggregatorFactories.class);  
        SearchContext context = mock(SearchContext.class);
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, 1, 100, context),
        assertThat(
import static org.mockito.Mockito.mock;
            equalTo(Aggregator.SubAggCollectionMode.BREADTH_FIRST)
        assertThat(  
        );  
        assertThat(  
    public void testPickNonEempty() {  
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, 1, 2, context),
 * the Apache License, Version 2.0 (the "License"); you may
            equalTo(Aggregator.SubAggCollectionMode.BREADTH_FIRST)
            equalTo(Aggregator.SubAggCollectionMode.BREADTH_FIRST)  
 */  
 * software distributed under the License is distributed on an
            equalTo(Aggregator.SubAggCollectionMode.BREADTH_FIRST)
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregator;
    public void testPickEmpty() throws Exception {
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, 10, 100, context),  
import org.opensearch.search.internal.SearchContext;  
            TermsAggregatorFactory.pickSubAggCollectMode(nonEmpty, Integer.MAX_VALUE, -1, context),
