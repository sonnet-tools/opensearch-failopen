import static org.hamcrest.Matchers.is;  
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))  
        }  
        long sum = 0;
        Filters filters = response.getAggregations().get("tags");  
        assertSearchResponse(response);
        numTag1Docs = randomIntBetween(1, numDocs - 1);
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) filters).getProperty("_count");
        Filters.Bucket all = filters.getBucketByKey("all");
        assertThat(bucket, Matchers.notNullValue());  
    // See NullPointer issue when filters are empty:
 */  
        for (int i = 0; i < numTag1Docs; i++) {
            sum += i + 1;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    static int numDocs, numTag1Docs, numTag2Docs, numOtherDocs;  
            }  
                .field("value", i)
        assertThat(filters, notNullValue());  
            .addAggregation(  
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) filters).getProperty("_key");  
        bucket = itr.next();
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); i++) {  
        avgValue = bucket.getAggregations().get("avg_value");
            .addAggregation(
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) filters).getProperty("_key");
 * specific language governing permissions and limitations
        SearchResponse response = client().prepareSearch("idx")
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
            }
            .addAggregation(  
    }  
package org.opensearch.search.aggregations.bucket;
        }  
                    ).subAggregation(avg("avg_value"))
/*  
                    .interval(1L)
        }
        assertThat(propertiesCounts[1], equalTo((double) sum / numTag2Docs));
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag1Docs));  
                ).otherBucket(true).subAggregation(avg("avg_value").field("value"))
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
        Histogram histo = searchResponse.getAggregations().get("histo");
        assertThat(propertiesDocCounts[1], equalTo((long) numTag2Docs));  
        SearchResponse response = client().prepareSearch("idx")
    public void testWithContextBasedSubAggregation() throws Exception {  
        assertSearchResponse(response);
 * Unless required by applicable law or agreed to in writing,
            Filters filters = bucket.getAggregations().get("filters");
import org.opensearch.search.aggregations.metrics.Avg;
            fail(  
                    + "context which the sub-aggregation can inherit"
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        assertSearchResponse(response);
public class FiltersIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
    }  
import org.opensearch.index.query.BoolQueryBuilder;
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); ++i) {
        assertThat(all.getDocCount(), is(0L));
                .field("name", "name" + i)
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); ++i) {  
}  
        bucket = filters.getBucketByKey("tag2");
            .get();  
        assertThat(propertiesDocCounts[2], equalTo((long) numOtherDocs));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        Histogram.Bucket bucket = histo.getBuckets().get(1);
import org.opensearch.search.aggregations.bucket.filter.Filters;
                filters(  
                histogram("histo").field("value")
import java.util.Collection;  
        return Arrays.asList(
        assertThat(avgValue, notNullValue());
                    .subAggregation(filters("filters", new KeyedFilter("foo", matchAllQuery())).otherBucket(true).otherBucketKey("bar"))
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        Filters.Bucket bucket = itr.next();  
        Iterator<? extends Filters.Bucket> itr = buckets.iterator();
        }
        assertThat(bucket, Matchers.notNullValue());
    // https://github.com/elastic/elasticsearch/issues/8438  
                filters("tags", randomOrder(new KeyedFilter("all", emptyFilter), new KeyedFilter("tag1", termQuery("tag", "tag1"))))
            .addAggregation(filters("tags", termQuery("tag", "tag1"), termQuery("tag", "tag2")).otherBucket(true))
        Histogram histo = response.getAggregations().get("histo");
    public void testOtherBucket() throws Exception {  
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
    public FiltersIT(Settings dynamicSettings) {
 * SPDX-License-Identifier: Apache-2.0
            }  
        assertThat(avgValue.getName(), equalTo("avg_value"));
        assertThat(bucket, Matchers.notNullValue());
        } catch (OpenSearchException e) {
import java.util.Collections;
        sum = 0;  
        assertThat(avgValue.getName(), equalTo("avg_value"));
        assertThat(avgValue.getValue(), equalTo((double) sum / numOtherDocs));  
        for (int i = 0; i < numTag1Docs; ++i) {  
            .addAggregation(
        for (int i = numTag1Docs + numTag2Docs; i < numDocs; i++) {
        Filters filters = response.getAggregations().get("tags");
        assertThat(propertiesKeys[0], equalTo("tag1"));
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat(filters, notNullValue());
 * not use this file except in compliance with the License.
        assertSearchResponse(response);
    public void testAsSubAggregation() {
            sum += i;
        );
        assertThat((String) propertiesKeys[0], equalTo("tag1"));
            XContentBuilder source = jsonBuilder().startObject()
                .endObject();
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
                filters(  
        assertThat(all.getKeyAsString(), equalTo("all"));
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
        Avg avgValue = bucket.getAggregations().get("avg_value");
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
        assertThat(all, Matchers.notNullValue());  
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        assertThat(filters.getBuckets().size(), equalTo(3));
        assertSearchResponse(response);
 * under the License.  
        assertThat(allBucket.getDocCount(), equalTo((long) numDocs));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(filters.getBuckets().size(), equalTo(2));
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
    public void testSimpleNonKeyed() throws Exception {
import org.opensearch.OpenSearchException;  
            client().prepareSearch("idx")  
/*  
        sum = 0;
        assertThat(avgValue, notNullValue());
        assertThat(filters, notNullValue());
        assertThat(avgValue, notNullValue());
        assertThat(filters.getName(), equalTo("tags"));
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(propertiesCounts[2], equalTo((double) sum / numOtherDocs));  
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
 */  
        long sum = 0;
    public void setupSuiteScopeCluster() throws Exception {  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(propertiesKeys[1], equalTo("tag2"));
 *  
        createIndex("idx");
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
            numOtherDocs++;  
        assertThat(propertiesKeys[1], equalTo("tag2"));  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
            )
            );
                ).otherBucket(true).otherBucketKey("foobar")
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            builders.add(
            .addAggregation(
import org.opensearch.index.query.QueryBuilder;  
        assertThat(bucket, Matchers.notNullValue());  
 * compatible open source license.
    public void testOtherWithSubAggregation() throws Exception {
    }
                )
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
            assertThat(e.getMessage(), is("all shards failed"));  
                ).otherBucket(true)  
    public void testWithSubAggregation() throws Exception {  
    public void testSimple() throws Exception {
            .setQuery(matchAllQuery())  
        assertThat(avgValue.getName(), equalTo("avg_value"));  
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));  
    }  
        Histogram histo = searchResponse.getAggregations().get("histo");  
            .setQuery(matchAllQuery())
        assertThat(other.getDocCount(), is(0L));
        QueryBuilder emptyFilter = new BoolQueryBuilder();
        createIndex("idx2");
    private static KeyedFilter[] randomOrder(KeyedFilter... filters) {
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));  
            .get();
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < 2; i++) {  
        }
        assertThat(filters.getName(), equalTo("tags"));
        assertThat(filters.getBuckets().size(), equalTo(3));
        }
        assertThat(filters.getBuckets().size(), equalTo(2));
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        Filters filters = response.getAggregations().get("tags");
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag1Docs));
            .get();  
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        try {
                .get();
                    "tags",
        bucket = filters.getBucketByKey("_other_");
                    "tags",
            XContentBuilder source = jsonBuilder().startObject()
        assertThat(filters.getName(), equalTo("tags"));  
import org.opensearch.search.aggregations.InternalAggregation;
        for (Histogram.Bucket bucket : histo.getBuckets()) {  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                ).subAggregation(avg("avg_value").field("value"))  
        Collection<? extends Filters.Bucket> buckets = filters.getBuckets();  
                .field("tag", "tag2")  
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))  
        assertThat(bucket, Matchers.notNullValue());
            )
                "expected execution to fail - an attempt to have a context based numeric sub-aggregation, but there is not value source"
    public void testEmptyFilterDeclarations() throws Exception {
    }  
                // randomly index the document twice so that we have deleted docs that match the filter
        assertThat(other, Matchers.notNullValue());  
            .addAggregation(
 * software distributed under the License is distributed on an
            .addAggregation(histogram("histo").field("value").interval(2L).subAggregation(filters("filters", matchAllQuery())))  
        return filters;
                .endObject();
        assertThat(filters, notNullValue());
        Filters filters = response.getAggregations().get("tags");  
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));  
            .addAggregation(filters("tags", termQuery("tag", "tag1"), termQuery("tag", "tag2")))
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag2Docs));
        bucket = filters.getBucketByKey("tag2");
    }  
import org.opensearch.action.index.IndexRequestBuilder;
                    .setId("" + i)  
            Filters.Bucket filterBucket = filters.getBuckets().get(0);
                client().prepareIndex("empty_bucket_idx")
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) filters).getProperty("_count");
                .field("name", "name" + i)
        assertThat(filters.getName(), equalTo("tags"));
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
        assertThat(bucket, Matchers.notNullValue());
    }
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
                    filters(
        assertThat(histo, Matchers.notNullValue());
        }
        sum = 0;
        indexRandom(true, builders);
        assertThat(histo, notNullValue());  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        assertThat(other.getKeyAsString(), equalTo("bar"));
            assertThat(filters.getBuckets().size(), equalTo(1));  
    }
        Filters filters = response.getAggregations().get("tags");
                filters(
        assertThat(filters.getName(), equalTo("tags"));
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        assertThat(bucket, Matchers.notNullValue());
        }
            )
            assertThat(filters, notNullValue());
        assertThat(filters.getBuckets().size(), equalTo(2));  
            sum += i + 1;  
        Filters filters = bucket.getAggregations().get("filters");
        assertThat(bucket, Matchers.notNullValue());
        assertThat(bucket, Matchers.notNullValue());
import static org.hamcrest.core.IsNull.notNullValue;
        assertThat(filters.getBuckets().size(), equalTo(3));
 * KIND, either express or implied.  See the License for the
import java.util.List;  
        bucket = itr.next();
import java.util.Arrays;
            )  
            .get();
        SearchResponse response = client().prepareSearch("idx")  
        assertSearchResponse(response);
        numDocs = randomIntBetween(5, 20);  
        assertThat(avgValue.getName(), equalTo("avg_value"));  
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(bucket, Matchers.notNullValue());
        assertThat(filters, notNullValue());
import org.opensearch.action.search.SearchResponse;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(bucket, Matchers.notNullValue());  
        avgValue = bucket.getAggregations().get("avg_value");  
        bucket = filters.getBucketByKey("tag2");  
        assertThat(filters, notNullValue());  
        for (int i = 0; i < numTag1Docs; ++i) {
        assertThat(((InternalAggregation) filters).getProperty("_bucket_count"), equalTo(2));
                        "tags",  
            if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor  
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
    }
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
        assertThat((double) propertiesCounts[0], equalTo((double) sum / numTag1Docs));  
        SearchResponse response = client().prepareSearch("idx")
 *
        Collection<? extends Filters.Bucket> buckets = filters.getBuckets();  
        Avg avgValue = bucket.getAggregations().get("avg_value");  
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));  
    public void testEmptyAggregation() throws Exception {
 * You may obtain a copy of the License at  
    }
        SearchResponse response = client().prepareSearch("idx")  
                filters(
        bucket = filters.getBucketByKey("foobar");  
        Filters filters = response.getAggregations().get("tags");  
    public void testOtherNonKeyed() throws Exception {
        ensureSearchable();
        assertThat(filters, notNullValue());
        assertThat(propertiesDocCounts[0], equalTo((long) numTag1Docs));  
                )  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
        assertThat((long) propertiesDocCounts[0], equalTo((long) numTag1Docs));
            .addAggregation(
        assertThat(bucket, Matchers.notNullValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
    }  
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));  
import static org.hamcrest.Matchers.equalTo;
        bucket = itr.next();
        assertThat(bucket, Matchers.notNullValue());  
                    "tags",
 * this work for additional information regarding copyright
        assertSearchResponse(response);  
        assertThat(propertiesCounts[1], equalTo((double) sum / numTag2Docs));
import static org.opensearch.search.aggregations.AggregationBuilders.filters;
        assertThat(((InternalAggregation) filters).getProperty("_bucket_count"), equalTo(3));  
        assertThat(filters.getName(), equalTo("tags"));  
            .get();
        assertThat(propertiesCounts[0], equalTo((double) sum / numTag1Docs));
@OpenSearchIntegTestCase.SuiteScopeTestCase  
                histogram("histo").field("value")
                    .minDocCount(0)  
import java.util.Iterator;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();
        assertThat(bucket, Matchers.notNullValue());
        assertThat(propertiesDocCounts[1], equalTo((long) numTag2Docs));
        assertThat(filters, notNullValue());
        }  
        assertThat(filters, notNullValue());
    public void testEmptyAggregationWithOtherBucket() throws Exception {  
        assertThat(histo, Matchers.notNullValue());
            )  
                .field("value", i)
        for (int i = numTag1Docs + numTag2Docs; i < numDocs; ++i) {
        Iterator<? extends Filters.Bucket> itr = buckets.iterator();
 */
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(avgValue, notNullValue());
            sum += i;
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));  
        bucket = filters.getBucketByKey("tag2");
        assertSearchResponse(response);  
        Filters filters = response.getAggregations().get("tags");  
        Filters.Bucket bucket = itr.next();  
            if (randomBoolean()) {
        Filters filters = bucket.getAggregations().get("filters");  
            .get();  
    }
import java.util.ArrayList;
import org.hamcrest.Matchers;
    public static Collection<Object[]> parameters() {
 * license agreements. See the NOTICE file distributed with
        bucket = filters.getBucketByKey("_other_");
        assertThat(filters, notNullValue());  
        assertThat(bucket, Matchers.notNullValue());
            assertEquals(bucket.getDocCount(), filterBucket.getDocCount());
/*
                    "tags",
        bucket = filters.getBucketByKey("tag2");  
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.avg;  
    public void testOtherNamedBucket() throws Exception {
    }
            .addAggregation(  
        Filters.Bucket other = filters.getBucketByKey("bar");
                    .interval(1L)  
import org.opensearch.common.settings.Settings;  
        assertThat(bucket, Matchers.notNullValue());  
        Filters filters = response.getAggregations().get("tags");
        assertThat(filters.getBuckets().size(), equalTo(3));
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) filters).getProperty("avg_value.value");  
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
                filters(
        }
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag2Docs));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
        assertThat(histo.getBuckets().size(), greaterThanOrEqualTo(1));
            .get();
                    .subAggregation(filters("filters", new KeyedFilter("all", matchAllQuery())))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        SearchResponse response = client().prepareSearch("idx")  
 *
    }
        assertThat(avgValue.getName(), equalTo("avg_value"));
        assertThat(bucket, Matchers.notNullValue());  
                .field("tag", "tag3")  
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject();
                    "tags",  
        assertThat(filters.getName(), equalTo("tags"));
 * GitHub history for details.
                        randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
        assertThat(bucket, Matchers.notNullValue());
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        assertThat(bucket, Matchers.notNullValue());
        assertThat(avgValue, notNullValue());  
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
    @ParametersFactory  
 * Modifications Copyright OpenSearch Contributors. See
        avgValue = bucket.getAggregations().get("avg_value");
            )
    }
            );  
        Collections.shuffle(Arrays.asList(filters), random());  
        assertThat(bucket, Matchers.notNullValue());
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) filters).getProperty("avg_value.value");
        SearchResponse response = client().prepareSearch("idx")
        Filters.Bucket bucket = filters.getBucketByKey("tag1");  
        Histogram.Bucket bucket = histo.getBuckets().get(1);  
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertThat(propertiesKeys[2], equalTo("_other_"));
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
            .get();
        super(dynamicSettings);  
                    .minDocCount(0)
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
            .get();
            sum += i;  
            )  
        assertThat(bucket, Matchers.notNullValue());  
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));  
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;  
        numTag2Docs = randomIntBetween(1, numDocs - numTag1Docs);
                .addAggregation(
            if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
            )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Filters.Bucket allBucket = filters.getBucketByKey("all");
        assertSearchResponse(response);  
