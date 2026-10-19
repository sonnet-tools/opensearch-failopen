 * ownership. Elasticsearch licenses this file to you under  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public void testZeroTermsQuery() throws ExecutionException, InterruptedException {
import org.opensearch.action.index.IndexRequestBuilder;
import java.util.concurrent.ExecutionException;
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
        );
        List<IndexRequestBuilder> requests = new ArrayList<>();
    public MatchPhraseQueryIT(Settings staticSettings) {  
        ensureGreen();
    private List<IndexRequestBuilder> getIndexRequests() {
 *  
 * GitHub history for details.
        MatchPhraseQueryBuilder baseQuery = matchPhraseQuery("name", "the who").analyzer("standard_stopwords");
                .putList("index.analysis.analyzer.standard_stopwords.stopwords", "of", "the", "who")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
 * specific language governing permissions and limitations
    }
import org.junit.Before;
        assertHitCount(matchAllResponse, 2L);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
import java.util.List;  
    public static Collection<Object[]> parameters() {
        );  
import org.opensearch.action.search.SearchResponse;
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        MatchPhraseQueryBuilder matchAllQuery = baseQuery.zeroTermsQuery(ZeroTermsQuery.ALL);
        SearchResponse matchNoneResponse = client().prepareSearch(INDEX).setQuery(matchNoneQuery).get();
        CreateIndexRequestBuilder createIndexRequest = prepareCreate(INDEX).setSettings(  
 * under the License.  
import java.util.Arrays;
        return requests;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * compatible open source license.
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
        List<IndexRequestBuilder> indexRequests = getIndexRequests();
    public void setUp() throws Exception {
        assertAcked(createIndexRequest);  
}
 * SPDX-License-Identifier: Apache-2.0
    @Before  
 *
/*
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;  
/*  
            Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;  
 * You may obtain a copy of the License at  
    private static final String INDEX = "test";
                .put("index.analysis.analyzer.standard_stopwords.type", "standard")  
 * not use this file except in compliance with the License.
        SearchResponse matchAllResponse = client().prepareSearch(INDEX).setQuery(matchAllQuery).get();  
 * the Apache License, Version 2.0 (the "License"); you may
        requests.add(client().prepareIndex(INDEX).setSource("name", "led zeppelin"));
        indexRandom(true, false, indexRequests);  
package org.opensearch.index.search;
public class MatchPhraseQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 *
        requests.add(client().prepareIndex(INDEX).setSource("name", "the beatles"));  
        assertHitCount(matchNoneResponse, 0L);  
        super(staticSettings);
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    @ParametersFactory
import java.util.Collection;
        MatchPhraseQueryBuilder matchNoneQuery = baseQuery.zeroTermsQuery(ZeroTermsQuery.NONE);
        return Arrays.asList(  
                .put(indexSettings())
import org.opensearch.common.settings.Settings;  
 * license agreements. See the NOTICE file distributed with
        super.setUp();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }  
 * this work for additional information regarding copyright
    }
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 */  
 */
import org.opensearch.index.query.MatchPhraseQueryBuilder;
