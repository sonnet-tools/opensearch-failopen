            .setQuery(new TermQueryBuilder("genre", "fantasy"))
    }
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100)
        );
import org.opensearch.search.aggregations.bucket.terms.Terms;
        int MAX_DOCS_PER_AUTHOR = 1;
 *
            "0805080481,book,The Book of Three,5.99,true,Lloyd Alexander,The Chronicles of Prydain,1,fantasy",
                    .order(BucketOrder.aggregation("sample>max_price.value", asc))
            client().prepareIndex("idx_unmapped_author")
}
    public void testRidiculousSizeDiversity() throws Exception {
        // One of the indexes is missing the "author" field used for
        Terms genres = response.getAggregations().get("genres");
        response = client().prepareSearch("test")
            .setFrom(0)
            .setFrom(0)
import org.opensearch.common.settings.Settings;
            .get();
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
                .get();
        Sampler genreSample = response.getAggregations().get("genreSample");
 * not use this file except in compliance with the License.
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            Sampler sample = genreBucket.getAggregations().get("sample");
    }
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
    }
            .setSize(60)
                .setSource("author", parts[5], "name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))
        assertSearchResponse(response);
        }
    public static Collection<Object[]> parameters() {
            "0553573403,book,A Game of Thrones,7.99,true,George R.R. Martin,A Song of Ice and Fire,1,fantasy",
        for (Terms.Bucket genreBucket : genres.getBuckets()) {
    public void testSimpleDiversity() throws Exception {
        Terms authors = sample.getAggregations().get("authors");
        SearchResponse response = client().prepareSearch("idx_unmapped_author", "test")
 * this work for additional information regarding copyright
import java.util.Arrays;
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse response = client().prepareSearch("test")
 * GitHub history for details.
            } else {
import org.opensearch.search.aggregations.metrics.Max;
    public static final int NUM_SHARDS = 2;
                .setId("" + i)
        int MAX_DOCS_PER_AUTHOR = 1;
        assertThat(authors.getBuckets().size(), greaterThan(0));
    }
public class DiversifiedSamplerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        Collection<? extends Bucket> genreBuckets = genres.getBuckets();
        rootSample.subAggregation(sampleAgg);
        assertAcked(
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
        }
        assertSearchResponse(response);
 *
        boolean asc = randomBoolean();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertThat(price, lessThanOrEqualTo(lastMaxPrice));
            // "id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s",
        // statement
 */
/**
        String data[] = {
            }
            }
        assertSearchResponse(response);
 * Tests the Sampler aggregation
            prepareCreate("test").setSettings(
    public DiversifiedSamplerIT(Settings staticSettings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        }
        }
 * The OpenSearch Contributors require contributions made to
        // Tests that we can refer to nested elements under a sample in a path
            double price = maxPriceInGenre.getValue();
            .addAggregation(sampleAgg)
        Terms genres = response.getAggregations().get("genres");
        }
                .get();
        Sampler sample = response.getAggregations().get("sample");
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)
        List<? extends Bucket> genreBuckets = genres.getBuckets();
    public void setupSuiteScopeCluster() throws Exception {
import static org.hamcrest.Matchers.greaterThan;
    public String randomExecutionHint() {
        List<? extends Bucket> testBuckets = authors.getBuckets();
        super(staticSettings);
            String[] parts = data[i].split(",");
            "0441385532,book,Jhereg,7.95,false,Steven Brust,Vlad Taltos,1,fantasy",
            .get();
            .addAggregation(sampleAgg)
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedAggregationBuilder;
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
            .addAggregation(sampleAgg)
            .setFrom(0)
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        assertSearchResponse(response);
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(sample.getDocCount(), equalTo(0L));
            List<? extends Bucket> testBuckets = authors.getBuckets();
        }
    @ParametersFactory
        };
 * compatible open source license.
        // idx_unmapped_author is same as main index but missing author field
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
            client().prepareIndex("test")
            .get();
        for (Terms.Bucket testBucket : testBuckets) {
        int MAX_DOCS_PER_GENRE = 2;
    }
import static org.hamcrest.Matchers.equalTo;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 */
            lastMaxPrice = price;
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        sampleAgg.subAggregation(terms("authors").field("author"));
        );
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
import org.opensearch.action.search.SearchType;
        createIndex("idx_unmapped");
        sampleAgg.subAggregation(terms("authors").field("author"));
            ).setMapping("author", "type=keyword", "name", "type=keyword", "genre", "type=keyword", "price", "type=float")
            .field("genre")
            .addAggregation(rootSample)
        assertSearchResponse(response);
            .setSize(60)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
    }
        sampleAgg.subAggregation(terms("authors").field("author"));
        rootTerms.subAggregation(sampleAgg);
    }
 *
    }
            .get();
            "0812550706,book,Ender's Game,6.99,true,Orson Scott Card,Ender,1,scifi",
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setId("" + i)
            .setSize(60)
 * specific language governing permissions and limitations
        DiversifiedAggregationBuilder rootSample = new DiversifiedAggregationBuilder("genreSample").shardSize(100)
 * You may obtain a copy of the License at
    }
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        // Test samples nested under samples
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertAcked(
 * Unless required by applicable law or agreed to in writing,
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
            )
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .get();
        for (Terms.Bucket testBucket : testBuckets) {
            "0553293354,book,Foundation,17.99,true,Isaac Asimov,Foundation Novels,1,scifi",
            for (Terms.Bucket testBucket : testBuckets) {
            .maxDocsPerValue(1);
        return Arrays.asList(
            assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_AUTHOR));
            assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_AUTHOR));
        SearchResponse response = client().prepareSearch("test").setSearchType(SearchType.QUERY_THEN_FETCH).addAggregation(rootTerms).get();
    public void testPartiallyUnmappedDiversifyField() throws Exception {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        ensureGreen();
                    .subAggregation(sampler("sample").shardSize(100).subAggregation(max("max_price").field("price")))
            Terms authors = sample.getAggregations().get("authors");
            Sampler sample = genreBucket.getAggregations().get("sample");
        sampleAgg.subAggregation(terms("authors").field("author"));
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        for (int i = 0; i < data.length; i++) {
    public void testIssue10719() throws Exception {
        sampleAgg.subAggregation(terms("authors").field("author"));
        Sampler sample = response.getAggregations().get("sample");
        SearchResponse response = client().prepareSearch("test")
                terms("genres").field("genre")
        return randomBoolean() ? null : randomFrom(SamplerAggregator.ExecutionMode.values()).toString();
            .setFrom(0)
    @Override
    public void testNestedSamples() throws Exception {
/*
import org.opensearch.search.aggregations.BucketOrder;
import java.util.Collection;
        for (Terms.Bucket genreBucket : genreBuckets) {
import org.opensearch.action.search.SearchResponse;
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(Integer.MAX_VALUE);
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
/*
        Terms authors = sample.getAggregations().get("authors");
            Max maxPriceInGenre = sample.getAggregations().get("max_price");
        assertSearchResponse(response);
                .setSource("name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))
        TermsAggregationBuilder rootTerms = terms("genres").field("genre");
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            "055357342X,book,A Storm of Swords,7.99,true,George R.R. Martin,A Song of Ice and Fire,3,fantasy",
        assertThat(genreBuckets.size(), greaterThan(1));
        SearchResponse response = client().prepareSearch("test")
        testBuckets = authors.getBuckets();
        for (Terms.Bucket testBucket : testBuckets) {
        assertNull(authors);
import org.opensearch.index.query.TermQueryBuilder;
            assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_GENRE));
        int MAX_DOCS_PER_AUTHOR = 1;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        // diversifying results
            if (asc) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Terms authors = sample.getAggregations().get("authors");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        Terms genres = sample.getAggregations().get("genres");
        sampleAgg.subAggregation(terms("authors").field("author"));
            .addAggregation(sampleAgg)
 * software distributed under the License is distributed on an
        // For this test to be useful we need >1 genre bucket to compare
import static org.opensearch.search.aggregations.AggregationBuilders.sampler;
        );
    public void testNestedDiversity() throws Exception {
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
                assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_AUTHOR));
import java.util.List;
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
            prepareCreate("idx_unmapped_author").setSettings(
    }
 */
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        Sampler sample = genreSample.getAggregations().get("sample");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .setSize(60)
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
            .get();
package org.opensearch.search.aggregations.bucket;
 * KIND, either express or implied.  See the License for the
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregator;
        List<? extends Bucket> testBuckets = genres.getBuckets();
    public void testWhollyUnmappedDiversifyField() throws Exception {
        SearchResponse response = client().prepareSearch("test")
        assertSearchResponse(response);
        assertSearchResponse(response);
            "0553579908,book,A Clash of Kings,7.99,true,George R.R. Martin,A Song of Ice and Fire,2,fantasy",
            "0812521390,book,The Black Company,6.99,false,Glen Cook,The Chronicles of The Black Company,1,fantasy",
@OpenSearchIntegTestCase.SuiteScopeTestCase
        sampleAgg.field("author").maxDocsPerValue(Integer.MAX_VALUE).executionHint(randomExecutionHint());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        int MAX_DOCS_PER_AUTHOR = 1;
                assertThat(price, greaterThanOrEqualTo(lastMaxPrice));
            .setFrom(0)
            .get();
import org.opensearch.search.aggregations.bucket.sampler.Sampler;
            ).setMapping("name", "type=keyword", "genre", "type=keyword", "price", "type=float")
        int MAX_DOCS_PER_AUTHOR = 1;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        // All of the indices are missing the "author" field used for diversifying results
        Sampler sample = response.getAggregations().get("sample");
 * ownership. Elasticsearch licenses this file to you under
            "0380014300,book,Nine Princes In Amber,6.99,true,Roger Zelazny,the Chronicles of Amber,1,fantasy",
        double lastMaxPrice = asc ? Double.MIN_VALUE : Double.MAX_VALUE;
        Terms authors = sample.getAggregations().get("authors");
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * SPDX-License-Identifier: Apache-2.0
            .field("author")
        sampleAgg.subAggregation(terms("genres").field("genre"));
            .addAggregation(sampleAgg)
        sampleAgg.subAggregation(terms("authors").field("author"));
            "080508049X,book,The Black Cauldron,5.99,true,Lloyd Alexander,The Chronicles of Prydain,2,fantasy"
 */
            .addAggregation(
import org.opensearch.action.support.WriteRequest;
/*
 * Licensed to Elasticsearch under one or more contributor
        assertThat(sample.getDocCount(), greaterThan(0L));
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx_unmapped_author")
            .setSize(60)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .maxDocsPerValue(MAX_DOCS_PER_GENRE);
    }
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        // Test multiple samples gathered under buckets made by a parent agg
