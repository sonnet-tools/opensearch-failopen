import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .endObject()
            .actionGet();
package org.opensearch.similarity;
 * Licensed to Elasticsearch under one or more contributor  
        client().prepareIndex("test")
    @ParametersFactory
                    .put("similarity.custom.type", "BM25")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(bm25SearchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }
 * this file be licensed under the Apache-2.0 license or a
            .actionGet();  
 * not use this file except in compliance with the License.
                    .field("type", "text")
        SearchResponse bm25SearchResponse = client().prepareSearch()  
            .setQuery(matchQuery("field2", "quick brown fox"))
                    .endObject()
    }  
        } catch (Exception e) {  
            .setQuery(matchQuery("field1", "quick brown fox"))
            .execute()  
            .setId("1")  
 *  
                    .endObject()  
        super(settings);
 *
    public void testCustomBM25Similarity() throws Exception {  
                    .startObject("field1")
            // ignore
 * GitHub history for details.
        }
 * ownership. Elasticsearch licenses this file to you under  
                    .put("index.number_of_replicas", 0)  
    public static Collection<Object[]> parameters() {
 */  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 */  
            .actionGet();  
 * compatible open source license.
public class SimilarityIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * Modifications Copyright OpenSearch Contributors. See
            .execute()  
import org.opensearch.common.settings.Settings;
            .execute()
 * under the License.  
        assertThat(bm25Score, not(equalTo(defaultScore)));
 * software distributed under the License is distributed on an
                    .put("similarity.custom.k1", 2.0f)
        assertThat(booleanSearchResponse.getHits().getTotalHits().value(), equalTo(1L));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .indices()
 * You may obtain a copy of the License at  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
import java.util.Collection;
            .setRefreshPolicy(IMMEDIATE)
 *
                    .field("similarity", "custom")
        );  
                    .startObject("field2")
import static org.hamcrest.Matchers.equalTo;
        SearchResponse booleanSearchResponse = client().prepareSearch()
        float bm25Score = bm25SearchResponse.getHits().getHits()[0].getScore();
 * specific language governing permissions and limitations
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
            )
            .prepareCreate("test")  
/*
    public SimilarityIT(Settings settings) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
                jsonBuilder().startObject()
        try {
                Settings.builder()
                    .put("index.number_of_shards", 1)
import static org.hamcrest.Matchers.not;  
 * license agreements. See the NOTICE file distributed with
            .actionGet();
            client().admin().indices().prepareDelete("test").execute().actionGet();
 */
        float defaultScore = booleanSearchResponse.getHits().getHits()[0].getScore();  
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchResponse;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
                    .field("similarity", "boolean")  
                    .put("similarity.custom.b", 0.5f)  
        return Arrays.asList(  
            .execute()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }
            .setSource("field1", "the quick brown fox jumped over the lazy dog", "field2", "the quick brown fox jumped over the lazy dog")
import java.util.Arrays;
                    .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
            )
            .setSettings(  
/*  
 * KIND, either express or implied.  See the License for the
                    .field("type", "text")  
}
            .setMapping(
        client().admin()
 * Unless required by applicable law or agreed to in writing,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .startObject("properties")  
