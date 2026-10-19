            .setFrom(0)
            maxBooksPerAuthor = Math.max(testBucket.getDocCount(), maxBooksPerAuthor);
        assertThat(genreBuckets.size(), greaterThan(1));
    public String randomExecutionHint() {
 * this file be licensed under the Apache-2.0 license or a
                .setId("" + i)
            prepareCreate("idx_unmapped_author").setSettings(  
        assertThat(authors.getBuckets().size(), equalTo(0));
/*
            "0812521390,book,The Black Company,6.99,false,Glen Cook,The Chronicles of The Black Company,1,fantasy",  
 *
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        assertThat(sample.getDocCount(), equalTo(0L));
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
            ).setMapping("name", "type=text", "genre", "type=keyword", "price", "type=float")
            "055357342X,book,A Storm of Swords,7.99,true,George R.R. Martin,A Song of Ice and Fire,3,fantasy",
import org.opensearch.test.OpenSearchIntegTestCase;  
/*  
        sampleAgg.subAggregation(terms("authors").field("author"));
    }
import org.opensearch.search.aggregations.metrics.Max;
    public void testSimpleSampler() throws Exception {
        assertThat(maxBooksPerAuthor, equalTo(3L));  
 */
import org.opensearch.search.aggregations.BucketOrder;
 * under the License.  
        assertThat(sample.getDocCount(), greaterThan(0L));
            .get();
        for (int i = 0; i < data.length; i++) {  
            } else {  
 */
import org.opensearch.common.settings.Settings;  
            .addAggregation(sampleAgg)  
            .setFrom(0)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .setSize(60)
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
    public SamplerIT(Settings staticSettings) {
            .addAggregation(sampleAgg)
            .addAggregation(sampleAgg)
        );  
        long maxBooksPerAuthor = 0;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            "0805080481,book,The Book of Three,5.99,true,Lloyd Alexander,The Chronicles of Prydain,1,fantasy",
            .setSize(60)
            ).setMapping("author", "type=keyword", "name", "type=text", "genre", "type=keyword", "price", "type=float")
            .get();
    public static final int NUM_SHARDS = 2;
            if (asc) {
            client().prepareIndex("test")
                .setSource("author", parts[5], "name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))
    }
        // Tests that we can refer to nested elements under a sample in a path
        assertSearchResponse(response);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(100);  
        assertSearchResponse(response);  
import static org.opensearch.search.aggregations.AggregationBuilders.sampler;
/*  
import java.util.Collection;
import org.opensearch.search.aggregations.bucket.sampler.Sampler;  
 *
    }
        assertThat(authors.getBuckets().size(), greaterThan(0));
import java.util.Arrays;  
 * Unless required by applicable law or agreed to in writing,
                .setId("" + i)  
 * The OpenSearch Contributors require contributions made to  
            .addAggregation(sampleAgg)
        Terms authors = sample.getAggregations().get("authors");
    }  
        SearchResponse response = client().prepareSearch("test")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Sampler sample = response.getAggregations().get("sample");  
            "0553579908,book,A Clash of Kings,7.99,true,George R.R. Martin,A Song of Ice and Fire,2,fantasy",  
    public void testUnmappedChildAggNoDiversity() throws Exception {
                .setSource("name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
    }  
        Terms authors = sample.getAggregations().get("authors");
        sampleAgg.subAggregation(terms("authors").field("author"));  
import static org.opensearch.search.aggregations.AggregationBuilders.max;
 * Licensed to Elasticsearch under one or more contributor  
        sampleAgg.subAggregation(terms("authors").field("author"));  
        List<? extends Bucket> testBuckets = authors.getBuckets();  
    @ParametersFactory  
@OpenSearchIntegTestCase.SuiteScopeTestCase
            Sampler sample = genreBucket.getAggregations().get("sample");
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregator;
        };
            Max maxPriceInGenre = sample.getAggregations().get("max_price");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        double lastMaxPrice = asc ? Double.MIN_VALUE : Double.MAX_VALUE;
            "0441385532,book,Jhereg,7.95,false,Steven Brust,Vlad Taltos,1,fantasy",
 *  
                .get();
                assertThat(price, greaterThanOrEqualTo(lastMaxPrice));
        for (Terms.Bucket testBucket : testBuckets) {  
package org.opensearch.search.aggregations.bucket;
    public void testSimpleSamplerShardSize() throws Exception {  
    }  
    @Override
            .setSize(60)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .get();
            "0812550706,book,Ender's Game,6.99,true,Orson Scott Card,Ender,1,scifi",
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertEquals(SHARD_SIZE * NUM_SHARDS, sample.getDocCount());
 * the Apache License, Version 2.0 (the "License"); you may
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
            .get();
            .setFrom(0)
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(Integer.MAX_VALUE);
            "0553293354,book,Foundation,17.99,true,Isaac Asimov,Foundation Novels,1,scifi",
 * software distributed under the License is distributed on an
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)
        return randomBoolean() ? null : randomFrom(SamplerAggregator.ExecutionMode.values()).toString();
        // statement
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
            "0380014300,book,Nine Princes In Amber,6.99,true,Roger Zelazny,the Chronicles of Amber,1,fantasy",  
                terms("genres").field("genre")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.action.search.SearchType;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
}
 * compatible open source license.
        // For this test to be useful we need >1 genre bucket to compare  
    public void setupSuiteScopeCluster() throws Exception {  
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)  
            lastMaxPrice = price;  
import org.opensearch.action.search.SearchResponse;  
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
        String data[] = {  
import org.opensearch.search.aggregations.bucket.terms.Terms;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    }  
        }
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(100);  
/**
 */  
            prepareCreate("test").setSettings(
            // "id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s",
        ensureGreen();
        );
 * KIND, either express or implied.  See the License for the
        boolean asc = randomBoolean();  
import java.util.List;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        Terms authors = sample.getAggregations().get("authors");  
            .setSize(60)  
    public void testIssue10719() throws Exception {  
 */  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
 * SPDX-License-Identifier: Apache-2.0
        assertAcked(
        assertAcked(
        final int SHARD_SIZE = randomIntBetween(1, 3);
import org.opensearch.action.support.WriteRequest;
        Sampler sample = response.getAggregations().get("sample");
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
                assertThat(price, lessThanOrEqualTo(lastMaxPrice));
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
public class SamplerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            .get();
 * this work for additional information regarding copyright
        sampleAgg.subAggregation(terms("authors").field("author"));
        SearchResponse response = client().prepareSearch("test")
        SearchResponse response = client().prepareSearch("test")
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        }
            .get();
        }  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
 * GitHub history for details.
    }
        createIndex("idx_unmapped");  
            client().prepareIndex("idx_unmapped_author")
        Sampler sample = response.getAggregations().get("sample");
            .addAggregation(  
            double price = maxPriceInGenre.getValue();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .addAggregation(sampleAgg)  
        assertSearchResponse(response);
        // idx_unmapped_author is same as main index but missing author field
 * not use this file except in compliance with the License.
        SearchResponse response = client().prepareSearch("idx_unmapped", "test")
import static org.hamcrest.Matchers.equalTo;  
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
 * specific language governing permissions and limitations
    }
        List<? extends Bucket> genreBuckets = genres.getBuckets();
            .setFrom(0)
        SearchResponse response = client().prepareSearch("test")
    }  
        sampleAgg.subAggregation(terms("authors").field("author"));  
                .get();  
            "0553573403,book,A Game of Thrones,7.99,true,George R.R. Martin,A Song of Ice and Fire,1,fantasy",
        Terms authors = sample.getAggregations().get("authors");  
        return Arrays.asList(
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse response = client().prepareSearch("idx_unmapped")
            String[] parts = data[i].split(",");
        assertSearchResponse(response);  
            .setSize(60)  
            .setFrom(0)
    public void testRidiculousShardSizeSampler() throws Exception {
            "080508049X,book,The Black Cauldron,5.99,true,Lloyd Alexander,The Chronicles of Prydain,2,fantasy"
    public void testPartiallyUnmappedChildAggNoDiversity() throws Exception {
import org.opensearch.index.query.TermQueryBuilder;
        assertSearchResponse(response);  
        Terms genres = response.getAggregations().get("genres");
            .setExplain(true)  
        assertSearchResponse(response);  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(100);
        SamplerAggregationBuilder sampleAgg = sampler("sample").shardSize(SHARD_SIZE);
    public static Collection<Object[]> parameters() {
                    .order(BucketOrder.aggregation("sample>max_price.value", asc))
        Sampler sample = response.getAggregations().get("sample");
                    .subAggregation(sampler("sample").shardSize(100).subAggregation(max("max_price").field("price")))  
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
 * Tests the Sampler aggregation  
        for (Terms.Bucket genreBucket : genres.getBuckets()) {  
 * ownership. Elasticsearch licenses this file to you under  
        );
        super(staticSettings);  
import static org.hamcrest.Matchers.greaterThan;
