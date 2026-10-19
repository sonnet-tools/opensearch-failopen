import org.opensearch.action.index.IndexRequestBuilder;  
        }  
import org.opensearch.action.search.SearchResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.ExecutionException;  
    }
    public void testStressReaper() throws ExecutionException, InterruptedException {
 * under the License.  
 */  
 *  
            .put(super.nodeSettings(nodeOrdinal))
 * license agreements. See the NOTICE file distributed with
import java.util.Arrays;
    public StressSearchServiceReaperIT(Settings settings) {
 * KIND, either express or implied.  See the License for the
    }
 * specific language governing permissions and limitations
/*
import org.opensearch.common.unit.TimeValue;  
 * Licensed to Elasticsearch under one or more contributor  
 */
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.SUITE;
 * SPDX-License-Identifier: Apache-2.0
        final int iterations = scaledRandomIntBetween(500, 1000);
import java.util.Collection;
 * GitHub history for details.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            .put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(1))  
 * this work for additional information regarding copyright
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        );
            .build();
        }
    protected Settings nodeSettings(int nodeOrdinal) {
import org.apache.lucene.tests.util.English;
        for (int i = 0; i < iterations; i++) {
        indexRandom(true, builders);  
        return Settings.builder()
        IndexRequestBuilder[] builders = new IndexRequestBuilder[num];
            SearchResponse searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(num).get();  
    @Override
        for (int i = 0; i < builders.length; i++) {
 * this file be licensed under the Apache-2.0 license or a
@ClusterScope(scope = SUITE)
    @ParametersFactory
        return Arrays.asList(
 *
import org.opensearch.common.settings.Settings;
 * compatible open source license.
/*  
public class StressSearchServiceReaperIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
 * Unless required by applicable law or agreed to in writing,
            assertNoFailures(searchResponse);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        // very frequent checks  
 * software distributed under the License is distributed on an
 */
}
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
/*
package org.opensearch.search;
        createIndex("test");
            builders[i] = client().prepareIndex("test").setId("" + i).setSource("f", English.intToEnglish(i));  
 * Modifications Copyright OpenSearch Contributors. See  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            assertHitCount(searchResponse, num);
        super(settings);
        int num = randomIntBetween(100, 150);  
 * You may obtain a copy of the License at  
    // see issue #5165 - this test fails each time without the fix in pull #5170
 *
    public static Collection<Object[]> parameters() {  
