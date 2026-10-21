                .setId("" + i)
    }
        assertThat(genreBuckets.size(), greaterThan(1));
 * The OpenSearch Contributors require contributions made to
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertSearchResponse(response);
        Terms authors = sample.getAggregations().get("authors");
            "080508049X,book,The Black Cauldron,5.99,true,Lloyd Alexander,The Chronicles of Prydain,2,fantasy"
 */
            .setFrom(0)
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
import java.util.Collection;
    public void testPartiallyUnmappedChildAggNoDiversity() throws Exception {
    }
    public void testSimpleSampler() throws Exception {
 *
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * this file be licensed under the Apache-2.0 license or a
        return randomBoolean() ? null : randomFrom(SamplerAggregator.ExecutionMode.values()).toString();
        assertSearchResponse(response);
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
            if (asc) {
            } else {
 * under the License.
    public void testSimpleSamplerShardSize() throws Exception {
 * GitHub history for details.
        sampleAgg.subAggregation(terms("authors").field("author"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        SearchResponse response = client().prepareSearch("idx_unmapped")
        long maxBooksPerAuthor = 0;
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                .get();
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregator;
import org.opensearch.search.aggregations.bucket.terms.Terms;
import org.opensearch.search.aggregations.bucket.sampler.Sampler;
        );
        Sampler sample = response.getAggregations().get("sample");
                terms("genres").field("genre")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    public static Collection<Object[]> parameters() {
/*
        assertThat(authors.getBuckets().size(), equalTo(0));
        String data[] = {
import org.opensearch.search.aggregations.BucketOrder;
 * KIND, either express or implied.  See the License for the
    }
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        SearchResponse response = client().prepareSearch("test")
        // Tests that we can refer to nested elements under a sample in a path
 * specific language governing permissions and limitations
}
import org.opensearch.action.search.SearchType;
import static org.hamcrest.Matchers.greaterThan;
        assertThat(sample.getDocCount(), greaterThan(0L));
            }
public class SamplerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    @ParametersFactory
    public SamplerIT(Settings staticSettings) {
        return Arrays.asList(
import org.opensearch.test.OpenSearchIntegTestCase;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(100);
            prepareCreate("idx_unmapped_author").setSettings(
        double lastMaxPrice = asc ? Double.MIN_VALUE : Double.MAX_VALUE;
    }
        }
    }
            .get();
        Sampler sample = response.getAggregations().get("sample");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.sampler;
 * Tests the Sampler aggregation
                .setId("" + i)
            "0441385532,book,Jhereg,7.95,false,Steven Brust,Vlad Taltos,1,fantasy",
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setFrom(0)
package org.opensearch.search.aggregations.bucket;
import java.util.List;
            // "id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s",
                .get();
 */
            .setExplain(true)
            .setFrom(0)
        super(staticSettings);
        assertAcked(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.search.aggregations.metrics.Max;
            .setSearchType(SearchType.QUERY_THEN_FETCH)
 */
            "0812550706,book,Ender's Game,6.99,true,Orson Scott Card,Ender,1,scifi",
        SearchResponse response = client().prepareSearch("test")
        SearchResponse response = client().prepareSearch("idx_unmapped", "test")
        final int SHARD_SIZE = randomIntBetween(1, 3);
import java.util.Arrays;
    @Override
 * compatible open source license.
    }
            prepareCreate("test").setSettings(
            .setSize(60)
        boolean asc = randomBoolean();
        Terms authors = sample.getAggregations().get("authors");
        }
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        ensureGreen();
        // For this test to be useful we need >1 genre bucket to compare
            Max maxPriceInGenre = sample.getAggregations().get("max_price");
        Terms authors = sample.getAggregations().get("authors");
    public String randomExecutionHint() {
        assertAcked(
        SearchResponse response = client().prepareSearch("test")
            "0553573403,book,A Game of Thrones,7.99,true,George R.R. Martin,A Song of Ice and Fire,1,fantasy",
            String[] parts = data[i].split(",");
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    public void testIssue10719() throws Exception {
import org.opensearch.action.search.SearchResponse;
            client().prepareIndex("idx_unmapped_author")
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(Integer.MAX_VALUE);
        );
        // statement
        List<? extends Bucket> testBuckets = authors.getBuckets();
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(100);
import org.opensearch.action.support.WriteRequest;
            .get();
            "0553579908,book,A Clash of Kings,7.99,true,George R.R. Martin,A Song of Ice and Fire,2,fantasy",
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)
 *
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(SHARD_SIZE);
            "0812521390,book,The Black Company,6.99,false,Glen Cook,The Chronicles of The Black Company,1,fantasy",
            .addAggregation(sampleAgg)
            ).setMapping("author", "type=keyword", "name", "type=text", "genre", "type=keyword", "price", "type=float")
 *
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    .subAggregation(sampler("sample").shardSize(100).subAggregation(max("max_price").field("price")))
    public void testRidiculousShardSizeSampler() throws Exception {
        assertThat(authors.getBuckets().size(), greaterThan(0));
        sampleAgg.subAggregation(terms("authors").field("author"));
            "0380014300,book,Nine Princes In Amber,6.99,true,Roger Zelazny,the Chronicles of Amber,1,fantasy",
            "0553293354,book,Foundation,17.99,true,Isaac Asimov,Foundation Novels,1,scifi",
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        assertThat(maxBooksPerAuthor, equalTo(3L));
                .setSource("name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        List<? extends Bucket> genreBuckets = genres.getBuckets();
        sampleAgg.subAggregation(terms("authors").field("author"));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                .setSource("author", parts[5], "name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))
        for (Terms.Bucket genreBucket : genres.getBuckets()) {
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    public void setupSuiteScopeCluster() throws Exception {
            .get();
        assertSearchResponse(response);
        Sampler sample = response.getAggregations().get("sample");
        SearchResponse response = client().prepareSearch("test")
 */
            .setSize(60)
/**
/*
 * Modifications Copyright OpenSearch Contributors. See
        assertSearchResponse(response);
            ).setMapping("name", "type=text", "genre", "type=keyword", "price", "type=float")
        Sampler sample = response.getAggregations().get("sample");
        sampleAgg.subAggregation(terms("authors").field("author"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (Terms.Bucket testBucket : testBuckets) {
            .addAggregation(sampleAgg)
        Terms authors = sample.getAggregations().get("authors");
        createIndex("idx_unmapped");
            .get();
import org.opensearch.common.settings.Settings;
            .setSize(60)
    }
        assertEquals(SHARD_SIZE * NUM_SHARDS, sample.getDocCount());
            "0805080481,book,The Book of Three,5.99,true,Lloyd Alexander,The Chronicles of Prydain,1,fantasy",
    public void testUnmappedChildAggNoDiversity() throws Exception {
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
            .setFrom(0)
 * this work for additional information regarding copyright
            double price = maxPriceInGenre.getValue();
            .addAggregation(
            )
            Sampler sample = genreBucket.getAggregations().get("sample");
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * software distributed under the License is distributed on an
            .addAggregation(sampleAgg)
        assertThat(sample.getDocCount(), equalTo(0L));
        }
 * the Apache License, Version 2.0 (the "License"); you may
            client().prepareIndex("test")
    public static final int NUM_SHARDS = 2;
            .get();
        );
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            maxBooksPerAuthor = Math.max(testBucket.getDocCount(), maxBooksPerAuthor);
        sampleAgg.subAggregation(terms("authors").field("author"));
/*
    }
 * not use this file except in compliance with the License.
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            lastMaxPrice = price;
        for (int i = 0; i < data.length; i++) {
                    .order(BucketOrder.aggregation("sample>max_price.value", asc))
 * ownership. Elasticsearch licenses this file to you under
                assertThat(price, greaterThanOrEqualTo(lastMaxPrice));
        };
            .addAggregation(sampleAgg)
    }
            .setSize(60)
            "055357342X,book,A Storm of Swords,7.99,true,George R.R. Martin,A Song of Ice and Fire,3,fantasy",
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
                assertThat(price, lessThanOrEqualTo(lastMaxPrice));
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            .get();
        assertSearchResponse(response);
    }
        Terms genres = response.getAggregations().get("genres");
@OpenSearchIntegTestCase.SuiteScopeTestCase
        // idx_unmapped_author is same as main index but missing author field
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .setFrom(0)
import static org.hamcrest.Matchers.equalTo;
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(100);
            .addAggregation(sampleAgg)
            .setSize(60)
