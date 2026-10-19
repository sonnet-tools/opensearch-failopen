 * this file be licensed under the Apache-2.0 license or a
    public ShardSizeTestCase(Settings dynamicSettings) {
        docs.addAll(indexDoc(routing1, "4", 2));
        ||==========||==================================================||===============================================||
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        docs.addAll(indexDoc(routing2, "4", 2));  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.action.index.IndexRequestBuilder;  
            builders[i] = client().prepareIndex("idx")
        assertThat(totalOnOne, is(15L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        docs.addAll(indexDoc(routing1, "1", 5));
        || shard 2: ||  "1" - 3 | "2" - 1 | "3" - 5 | "4" - 2 | "5" - 1 || "1" - 3 | "3" - 5 | "4" - 2                   ||
}
        resp = client().prepareSearch("idx").setRouting(routing2).setQuery(matchAllQuery()).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
 * SPDX-License-Identifier: Apache-2.0
        long totalOnTwo = resp.getHits().getTotalHits().value();
 * Licensed to Elasticsearch under one or more contributor  
        docs.addAll(indexDoc(routing2, "2", 1));
        ||----------||--------------------------------------------------||-----------------------------------------------||
        routing1 = routingKeyForShard("idx", 0);
    protected static String routing2; // routing key to shard 2  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */  
 * this work for additional information regarding copyright
        ||          ||  "1" - 8 | "3" - 8 | "2" - 5     <= CORRECT      ||                                               ||  
 */
 * Unless required by applicable law or agreed to in writing,
        return Arrays.asList(
/*  
        */  
        || reduced: ||  "1" - 8 | "2" - 5 | "3" - 8 | "4" - 4 | "5" - 2 ||                                               ||
import java.util.Collection;
import org.opensearch.common.settings.Settings;
    }  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        docs.addAll(indexDoc(routing2, "5", 1));
 * license agreements. See the NOTICE file distributed with
        return randomIntBetween(2, DEFAULT_MAX_NUM_SHARDS);
        IndexRequestBuilder[] builders = new IndexRequestBuilder[times];  
        // total docs in shard "2" = 12  
 * GitHub history for details.
        assertThat(totalOnTwo, is(12L));
        ||          ||           size = 3, shard_size = 5               ||           shard_size = size = 3               ||
        /*
    }
    protected void createIdx(String keyFieldMapping) {
        return Arrays.asList(builders);  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    protected int numberOfShards() {
import java.util.List;
    @Override
 * software distributed under the License is distributed on an
        || shard 1: ||  "1" - 5 | "2" - 4 | "3" - 3 | "4" - 2 | "5" - 1 || "1" - 5 | "3" - 3 | "2" - 4                   ||  
import java.util.ArrayList;
/*
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < times; i++) {
        indexRandom(true, docs);
    }  
        docs.addAll(indexDoc(routing2, "1", 3));  
    @ParametersFactory
                .setRouting(shard)  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        // we need at least 2  
        assertAcked(prepareCreate("idx").setMapping("key", keyFieldMapping));
        docs.addAll(indexDoc(routing1, "2", 4));
 *
 * not use this file except in compliance with the License.
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
import static org.hamcrest.Matchers.is;  
        docs.addAll(indexDoc(routing1, "5", 1));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 */  
    }
 *
        docs.addAll(indexDoc(routing2, "3", 5));
import org.opensearch.action.search.SearchResponse;
 *  
        ||          ||                                                  || "1" - 8, "3" - 8, "2" - 4    <= WRONG         ||
        assertSearchResponse(resp);  
                .setSource(jsonBuilder().startObject().field("key", key).field("value", 1).endObject());
/*  
    protected void indexData() throws Exception {
    protected List<IndexRequestBuilder> indexDoc(String shard, String key, int times) throws Exception {
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    protected static String routing1; // routing key to shard 1
        assertSearchResponse(resp);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        docs.addAll(indexDoc(routing1, "3", 3));  
        routing2 = routingKeyForShard("idx", 1);
        super(dynamicSettings);
 * under the License.  
 * You may obtain a copy of the License at  
        SearchResponse resp = client().prepareSearch("idx").setRouting(routing1).setQuery(matchAllQuery()).get();
        ||----------||--------------------------------------------------||-----------------------------------------------||  
        List<IndexRequestBuilder> docs = new ArrayList<>();
    public static Collection<Object[]> parameters() {  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        // total docs in shard "1" = 15
import java.util.Arrays;  
public abstract class ShardSizeTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        long totalOnOne = resp.getHits().getTotalHits().value();  
package org.opensearch.search.aggregations.bucket;
