        sampleAgg.subAggregation(terms("authors").field("author"));
import java.util.Collection;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * The OpenSearch Contributors require contributions made to  
    }  
                    .order(BucketOrder.aggregation("sample>max_price.value", asc))
/**
 * ownership. Elasticsearch licenses this file to you under  
        Sampler genreSample = response.getAggregations().get("genreSample");
        Terms genres = response.getAggregations().get("genres");  
        SearchResponse response = client().prepareSearch("idx_unmapped", "idx_unmapped_author")  
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(Integer.MAX_VALUE);
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
    }
        };
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
                assertThat(price, lessThanOrEqualTo(lastMaxPrice));
    public static Collection<Object[]> parameters() {  
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
    public void testWhollyUnmappedDiversifyField() throws Exception {  
            .field("genre")  
        SearchResponse response = client().prepareSearch("test")  
    public String randomExecutionHint() {
    }
 * Unless required by applicable law or agreed to in writing,
                .get();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        // For this test to be useful we need >1 genre bucket to compare  
import org.opensearch.action.search.SearchResponse;
        sampleAgg.subAggregation(terms("authors").field("author"));  
            .maxDocsPerValue(MAX_DOCS_PER_GENRE);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        Sampler sample = genreSample.getAggregations().get("sample");  
            .get();
            .field("author")
            .setSize(60)
        DiversifiedAggregationBuilder rootSample = new DiversifiedAggregationBuilder("genreSample").shardSize(100)
    }
        SearchResponse response = client().prepareSearch("test")
    public void testIssue10719() throws Exception {  
            .addAggregation(rootSample)
        int MAX_DOCS_PER_AUTHOR = 1;  
            .setFrom(0)
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        int MAX_DOCS_PER_GENRE = 2;
        double lastMaxPrice = asc ? Double.MIN_VALUE : Double.MAX_VALUE;
        response = client().prepareSearch("test")
            // "id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s",
        }
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        Sampler sample = response.getAggregations().get("sample");  
        int MAX_DOCS_PER_AUTHOR = 1;  
        assertThat(sample.getDocCount(), equalTo(0L));  
                assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_AUTHOR));
        for (Terms.Bucket testBucket : testBuckets) {
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregator;
    public DiversifiedSamplerIT(Settings staticSettings) {
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setFrom(0)  
        // Test multiple samples gathered under buckets made by a parent agg
        assertSearchResponse(response);
 */
            String[] parts = data[i].split(",");
                terms("genres").field("genre")
        Terms genres = response.getAggregations().get("genres");
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());  
            ).setMapping("name", "type=keyword", "genre", "type=keyword", "price", "type=float")
        Terms authors = sample.getAggregations().get("authors");
        sampleAgg.subAggregation(terms("authors").field("author"));  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import static org.hamcrest.Matchers.greaterThan;
            Max maxPriceInGenre = sample.getAggregations().get("max_price");
 * Tests the Sampler aggregation  
        List<? extends Bucket> testBuckets = authors.getBuckets();
        super(staticSettings);
        sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
import org.opensearch.common.settings.Settings;
        for (Terms.Bucket genreBucket : genres.getBuckets()) {  
            )
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertAcked(
        SearchResponse response = client().prepareSearch("test")
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import org.opensearch.index.query.TermQueryBuilder;  
@OpenSearchIntegTestCase.SuiteScopeTestCase
            .setFrom(0)
            "0380014300,book,Nine Princes In Amber,6.99,true,Roger Zelazny,the Chronicles of Amber,1,fantasy",  
        assertSearchResponse(response);
            lastMaxPrice = price;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .setSize(60)
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureGreen();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            double price = maxPriceInGenre.getValue();  
            List<? extends Bucket> testBuckets = authors.getBuckets();
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedAggregationBuilder;
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)  
        );
        assertSearchResponse(response);
        for (Terms.Bucket testBucket : testBuckets) {
            ).setMapping("author", "type=keyword", "name", "type=keyword", "genre", "type=keyword", "price", "type=float")
            "0553573403,book,A Game of Thrones,7.99,true,George R.R. Martin,A Song of Ice and Fire,1,fantasy",
        Terms authors = sample.getAggregations().get("authors");
            } else {  
    public void testNestedSamples() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
            for (Terms.Bucket testBucket : testBuckets) {
        for (Terms.Bucket genreBucket : genreBuckets) {
        List<? extends Bucket> testBuckets = genres.getBuckets();  
        Sampler sample = response.getAggregations().get("sample");
                .setId("" + i)  
        sampleAgg.subAggregation(terms("authors").field("author"));
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);  
 * You may obtain a copy of the License at  
            Sampler sample = genreBucket.getAggregations().get("sample");
                assertThat(price, greaterThanOrEqualTo(lastMaxPrice));
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;  
        assertThat(authors.getBuckets().size(), greaterThan(0));  
        sampleAgg.subAggregation(terms("genres").field("genre"));  
        sampleAgg.subAggregation(terms("authors").field("author"));  
package org.opensearch.search.aggregations.bucket;
        for (int i = 0; i < data.length; i++) {  
            "0812550706,book,Ender's Game,6.99,true,Orson Scott Card,Ender,1,scifi",
        sampleAgg.field("author").maxDocsPerValue(Integer.MAX_VALUE).executionHint(randomExecutionHint());
            "080508049X,book,The Black Cauldron,5.99,true,Lloyd Alexander,The Chronicles of Prydain,2,fantasy"
        sampleAgg.subAggregation(terms("authors").field("author"));
        testBuckets = authors.getBuckets();  
        SearchResponse response = client().prepareSearch("test").setSearchType(SearchType.QUERY_THEN_FETCH).addAggregation(rootTerms).get();
    public void testSimpleDiversity() throws Exception {
            .setSize(60)
 * SPDX-License-Identifier: Apache-2.0
 *
public class DiversifiedSamplerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
    @ParametersFactory
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        Terms authors = sample.getAggregations().get("authors");
        rootTerms.subAggregation(sampleAgg);  
import org.opensearch.search.aggregations.bucket.terms.Terms;
 */  
        }  
        }  
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
        );
    public static final int NUM_SHARDS = 2;
            .get();  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
/*
    public void testRidiculousSizeDiversity() throws Exception {
        Terms authors = sample.getAggregations().get("authors");
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.search.aggregations.metrics.Max;
        assertSearchResponse(response);  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    }  
import java.util.Arrays;  
        // All of the indices are missing the "author" field used for diversifying results
            }
            "0812521390,book,The Black Company,6.99,false,Glen Cook,The Chronicles of The Black Company,1,fantasy",  
                .get();  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        Sampler sample = response.getAggregations().get("sample");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        // diversifying results
            .addAggregation(sampleAgg)  
        }  
            .setFrom(0)
import java.util.List;
            .get();  
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100)  
    public void testPartiallyUnmappedDiversifyField() throws Exception {  
        assertSearchResponse(response);
            Terms authors = sample.getAggregations().get("authors");
    }  
 * not use this file except in compliance with the License.
            "0553293354,book,Foundation,17.99,true,Isaac Asimov,Foundation Novels,1,scifi",
        SearchResponse response = client().prepareSearch("test")
import org.opensearch.action.search.SearchType;  
        return Arrays.asList(
        int MAX_DOCS_PER_AUTHOR = 1;
        assertNull(authors);
            .setQuery(new TermQueryBuilder("genre", "fantasy"))  
    public void testNestedDiversity() throws Exception {  
        SearchResponse response = client().prepareSearch("idx_unmapped_author", "test")
            .setSize(60)
            assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_AUTHOR));
            Sampler sample = genreBucket.getAggregations().get("sample");  
        // Tests that we can refer to nested elements under a sample in a path
        // One of the indexes is missing the "author" field used for
            prepareCreate("test").setSettings(
        }
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
 * GitHub history for details.
        // idx_unmapped_author is same as main index but missing author field
            "0553579908,book,A Clash of Kings,7.99,true,George R.R. Martin,A Song of Ice and Fire,2,fantasy",  
            client().prepareIndex("idx_unmapped_author")
import org.opensearch.search.aggregations.bucket.sampler.Sampler;  
        String data[] = {  
 * this work for additional information regarding copyright
        assertSearchResponse(response);
        boolean asc = randomBoolean();  
            .setFrom(0)
        List<? extends Bucket> genreBuckets = genres.getBuckets();
 * Modifications Copyright OpenSearch Contributors. See  
            .addAggregation(  
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
        }  
import org.opensearch.action.support.WriteRequest;
        Collection<? extends Bucket> genreBuckets = genres.getBuckets();
    @Override
        sampleAgg.subAggregation(terms("authors").field("author"));  
            "0805080481,book,The Book of Three,5.99,true,Lloyd Alexander,The Chronicles of Prydain,1,fantasy",
            if (asc) {
 *  
/*  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
            .addAggregation(sampleAgg)  
            .get();
        // Test samples nested under samples
        int MAX_DOCS_PER_AUTHOR = 1;
        // statement
}
        int MAX_DOCS_PER_AUTHOR = 1;  
        );  
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);  
        for (Terms.Bucket testBucket : testBuckets) {
        createIndex("idx_unmapped");  
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            .get();
 */
            .setQuery(new TermQueryBuilder("genre", "fantasy"))
        DiversifiedAggregationBuilder sampleAgg = new DiversifiedAggregationBuilder("sample").shardSize(100);
        return randomBoolean() ? null : randomFrom(SamplerAggregator.ExecutionMode.values()).toString();
            .setSize(60)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .addAggregation(sampleAgg)
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, NUM_SHARDS).put(SETTING_NUMBER_OF_REPLICAS, 0)
                .setId("" + i)
 * license agreements. See the NOTICE file distributed with
        assertSearchResponse(response);
    }
import static org.opensearch.search.aggregations.AggregationBuilders.sampler;
            "0441385532,book,Jhereg,7.95,false,Steven Brust,Vlad Taltos,1,fantasy",
    public void setupSuiteScopeCluster() throws Exception {  
            "055357342X,book,A Storm of Swords,7.99,true,George R.R. Martin,A Song of Ice and Fire,3,fantasy",
 * compatible open source license.
 *
 * software distributed under the License is distributed on an
        Terms genres = sample.getAggregations().get("genres");
            assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_GENRE));
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            prepareCreate("idx_unmapped_author").setSettings(  
        rootSample.subAggregation(sampleAgg);
        assertThat(genreBuckets.size(), greaterThan(1));
            .maxDocsPerValue(1);
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }  
                .setSource("author", parts[5], "name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))
            client().prepareIndex("test")
        assertThat(sample.getDocCount(), greaterThan(0L));
    }
            assertThat(testBucket.getDocCount(), lessThanOrEqualTo((long) NUM_SHARDS * MAX_DOCS_PER_AUTHOR));
        assertAcked(
 */
        sampleAgg.field("author").maxDocsPerValue(MAX_DOCS_PER_AUTHOR).executionHint(randomExecutionHint());
import org.opensearch.search.aggregations.BucketOrder;
            .get();
            .addAggregation(sampleAgg)  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            }  
                    .subAggregation(sampler("sample").shardSize(100).subAggregation(max("max_price").field("price")))  
            .addAggregation(sampleAgg)  
 * KIND, either express or implied.  See the License for the
/*
        TermsAggregationBuilder rootTerms = terms("genres").field("genre");  
        assertSearchResponse(response);
                .setSource("name", parts[2], "genre", parts[8], "price", Float.parseFloat(parts[3]))  
