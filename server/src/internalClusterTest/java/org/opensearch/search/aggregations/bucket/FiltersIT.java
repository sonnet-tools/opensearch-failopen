            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
                "expected execution to fail - an attempt to have a context based numeric sub-aggregation, but there is not value source"
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse response = client().prepareSearch("idx")
        Filters.Bucket all = filters.getBucketByKey("all");
                    "tags",
                .endObject();
        assertThat(avgValue, notNullValue());
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
            .addAggregation(
    // See NullPointer issue when filters are empty:
                )
        for (int i = 0; i < numTag1Docs; i++) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .setQuery(matchAllQuery())
    }
    public void testAsSubAggregation() {
        assertSearchResponse(response);
        }
    public void testSimple() throws Exception {
            .setQuery(matchAllQuery())
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        avgValue = bucket.getAggregations().get("avg_value");
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat(bucket, Matchers.notNullValue());
            sum += i;
        assertThat(propertiesDocCounts[2], equalTo((long) numOtherDocs));
import org.opensearch.search.aggregations.metrics.Avg;
            sum += i + 1;
        assertThat(avgValue.getValue(), equalTo((double) sum / numOtherDocs));
import java.util.Arrays;
    public void testOtherBucket() throws Exception {
 * You may obtain a copy of the License at
            numOtherDocs++;
    }
        assertThat(bucket, Matchers.notNullValue());
        try {
        assertThat(bucket, Matchers.notNullValue());
        assertThat(filters, notNullValue());
                histogram("histo").field("value")
            .get();
        assertThat(filters.getName(), equalTo("tags"));
            .get();
import java.util.List;
        assertThat(filters, notNullValue());
        sum = 0;
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
        Iterator<? extends Filters.Bucket> itr = buckets.iterator();
    }
import static org.hamcrest.Matchers.equalTo;
        assertThat(bucket, Matchers.notNullValue());
                    ).subAggregation(avg("avg_value"))
    public void testOtherWithSubAggregation() throws Exception {
        Filters.Bucket allBucket = filters.getBucketByKey("all");
        assertSearchResponse(response);
            }
            sum += i;
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
            if (randomBoolean()) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        avgValue = bucket.getAggregations().get("avg_value");
        assertThat(bucket, Matchers.notNullValue());
        Histogram histo = searchResponse.getAggregations().get("histo");
            .get();
        avgValue = bucket.getAggregations().get("avg_value");
        SearchResponse response = client().prepareSearch("idx")
    public void testWithSubAggregation() throws Exception {
        }
        assertThat(bucket, Matchers.notNullValue());
        }
        assertSearchResponse(response);
    public void testOtherNamedBucket() throws Exception {
                histogram("histo").field("value")
    public void setupSuiteScopeCluster() throws Exception {
        assertThat((long) propertiesDocCounts[0], equalTo((long) numTag1Docs));
                    .minDocCount(0)
        assertThat(filters, notNullValue());
        assertThat(all.getDocCount(), is(0L));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        Avg avgValue = bucket.getAggregations().get("avg_value");
        assertThat(histo.getBuckets().size(), greaterThanOrEqualTo(1));
        assertSearchResponse(response);
        List<IndexRequestBuilder> builders = new ArrayList<>();
        bucket = filters.getBucketByKey("_other_");
 */
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
}
    static int numDocs, numTag1Docs, numTag2Docs, numOtherDocs;
        }
        assertThat(bucket, Matchers.notNullValue());
        bucket = filters.getBucketByKey("foobar");
        Avg avgValue = bucket.getAggregations().get("avg_value");
        assertThat(avgValue.getName(), equalTo("avg_value"));
import java.util.ArrayList;
            .addAggregation(filters("tags", termQuery("tag", "tag1"), termQuery("tag", "tag2")).otherBucket(true))
        bucket = itr.next();
 * under the License.
        numTag2Docs = randomIntBetween(1, numDocs - numTag1Docs);
        numTag1Docs = randomIntBetween(1, numDocs - 1);
        Filters filters = bucket.getAggregations().get("filters");
            assertThat(filters, notNullValue());
        indexRandom(true, builders);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        Filters filters = bucket.getAggregations().get("filters");
        assertThat(bucket, Matchers.notNullValue());
                ).otherBucket(true).subAggregation(avg("avg_value").field("value"))
                    .subAggregation(filters("filters", new KeyedFilter("foo", matchAllQuery())).otherBucket(true).otherBucketKey("bar"))
 * The OpenSearch Contributors require contributions made to
                    "tags",
            Filters filters = bucket.getAggregations().get("filters");
    }
        for (int i = 0; i < 2; i++) {
                .field("value", i)
        bucket = itr.next();
                    filters(
        Histogram histo = response.getAggregations().get("histo");
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) filters).getProperty("_count");
        assertSearchResponse(response);
            XContentBuilder source = jsonBuilder().startObject()
            .get();
            assertThat(e.getMessage(), is("all shards failed"));
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat(bucket, Matchers.notNullValue());
            }
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertThat(bucket, Matchers.notNullValue());
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
        assertSearchResponse(response);
import org.opensearch.action.search.SearchResponse;
        assertThat(avgValue, notNullValue());
        assertThat(propertiesCounts[1], equalTo((double) sum / numTag2Docs));
        assertThat(filters.getName(), equalTo("tags"));
        SearchResponse response = client().prepareSearch("idx")
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
import org.opensearch.search.aggregations.InternalAggregation;
import static org.hamcrest.core.IsNull.notNullValue;
 */
        assertThat(filters.getBuckets().size(), equalTo(2));
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) filters).getProperty("_count");
        Filters filters = response.getAggregations().get("tags");
        }
            .addAggregation(
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) filters).getProperty("_key");
                ).otherBucket(true)
        for (int i = numTag1Docs + numTag2Docs; i < numDocs; i++) {
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) filters).getProperty("_key");
        assertThat(avgValue.getName(), equalTo("avg_value"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    @ParametersFactory
/*
                filters(
    public void testEmptyFilterDeclarations() throws Exception {
        bucket = filters.getBucketByKey("tag2");
import org.opensearch.index.query.BoolQueryBuilder;
                ).otherBucket(true).otherBucketKey("foobar")
        Filters filters = response.getAggregations().get("tags");
                .field("tag", "tag3")
            XContentBuilder source = jsonBuilder().startObject()
            .addAggregation(
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat(histo, notNullValue());
        Histogram.Bucket bucket = histo.getBuckets().get(1);
    public void testSimpleNonKeyed() throws Exception {
                .field("tag", "tag2")
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag1Docs));
        SearchResponse response = client().prepareSearch("idx")
    }
 * Licensed to Elasticsearch under one or more contributor
        Histogram.Bucket bucket = histo.getBuckets().get(1);
 * software distributed under the License is distributed on an
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        assertThat(filters.getName(), equalTo("tags"));
        SearchResponse response = client().prepareSearch("idx")
            .get();
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
        sum = 0;
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject();
            )
        Iterator<? extends Filters.Bucket> itr = buckets.iterator();
        assertThat(propertiesCounts[0], equalTo((double) sum / numTag1Docs));
                    .interval(1L)
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag2Docs));
/*
        bucket = filters.getBucketByKey("tag2");
 * Unless required by applicable law or agreed to in writing,
        assertThat(avgValue.getName(), equalTo("avg_value"));
        Filters filters = response.getAggregations().get("tags");
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
            );
        createIndex("idx2");
        bucket = filters.getBucketByKey("tag2");
        Filters.Bucket other = filters.getBucketByKey("bar");
        }
        Filters filters = response.getAggregations().get("tags");
        assertThat(filters, notNullValue());
    }
    public void testEmptyAggregation() throws Exception {
            }
            if (randomBoolean()) {
        Collections.shuffle(Arrays.asList(filters), random());
                    "tags",
        assertThat(filters.getName(), equalTo("tags"));
        super(dynamicSettings);
            builders.add(
            client().prepareSearch("idx")
    }
 * GitHub history for details.
        bucket = filters.getBucketByKey("tag2");
        createIndex("idx");
        assertThat(bucket, Matchers.notNullValue());
        assertThat(filters.getName(), equalTo("tags"));
        ensureSearchable();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            )
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
            Filters.Bucket filterBucket = filters.getBuckets().get(0);
                ).subAggregation(avg("avg_value").field("value"))
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            if (randomBoolean()) {
        assertThat(propertiesDocCounts[1], equalTo((long) numTag2Docs));
        assertThat(bucket, Matchers.notNullValue());
                .addAggregation(
    private static KeyedFilter[] randomOrder(KeyedFilter... filters) {
        bucket = filters.getBucketByKey("tag2");
 *
import org.opensearch.OpenSearchException;
    @Override
        assertThat(other, Matchers.notNullValue());
                    "tags",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
        assertThat(all.getKeyAsString(), equalTo("all"));
                    .interval(1L)
            )
    }
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
import java.util.Collections;
                filters("tags", randomOrder(new KeyedFilter("all", emptyFilter), new KeyedFilter("tag1", termQuery("tag", "tag1"))))
        assertThat(propertiesKeys[1], equalTo("tag2"));
        assertThat(other.getDocCount(), is(0L));
        assertThat(other.getKeyAsString(), equalTo("bar"));
        Filters.Bucket bucket = itr.next();
        assertThat(avgValue.getName(), equalTo("avg_value"));
    }
            .addAggregation(
        assertThat(filters.getBuckets().size(), equalTo(3));
        assertThat(histo, Matchers.notNullValue());
        assertThat(((InternalAggregation) filters).getProperty("_bucket_count"), equalTo(2));
import org.opensearch.action.index.IndexRequestBuilder;
        Filters filters = response.getAggregations().get("tags");
 * SPDX-License-Identifier: Apache-2.0
        assertThat(avgValue, notNullValue());
        assertThat(allBucket.getDocCount(), equalTo((long) numDocs));
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
import org.hamcrest.Matchers;
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        assertThat(propertiesDocCounts[0], equalTo((long) numTag1Docs));
        assertThat(propertiesKeys[0], equalTo("tag1"));
                    "tags",
 * not use this file except in compliance with the License.
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
                filters(
    }
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
                .get();
        assertThat(propertiesCounts[2], equalTo((double) sum / numOtherDocs));
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag2Docs));
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
    }
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
        assertThat(bucket, Matchers.notNullValue());
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); ++i) {
        Filters filters = response.getAggregations().get("tags");
        }
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
            assertThat(filters.getBuckets().size(), equalTo(1));
        assertThat(bucket, Matchers.notNullValue());
        assertThat(bucket, Matchers.notNullValue());
 * this file be licensed under the Apache-2.0 license or a
        Filters filters = response.getAggregations().get("tags");
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
            assertEquals(bucket.getDocCount(), filterBucket.getDocCount());
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat(bucket, Matchers.notNullValue());
        );
 *
        assertThat(filters, notNullValue());
        Filters filters = response.getAggregations().get("tags");
        numDocs = randomIntBetween(5, 20);
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); ++i) {
            sum += i + 1;
        SearchResponse response = client().prepareSearch("idx")
                // randomly index the document twice so that we have deleted docs that match the filter
            .addAggregation(
            );
            .get();
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag1Docs));
        Collection<? extends Filters.Bucket> buckets = filters.getBuckets();
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(filters, notNullValue());
    }
        assertThat(bucket, Matchers.notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        assertThat(propertiesCounts[1], equalTo((double) sum / numTag2Docs));
package org.opensearch.search.aggregations.bucket;
        } catch (OpenSearchException e) {
            .addAggregation(
            )
        assertThat(propertiesKeys[1], equalTo("tag2"));
                .endObject();
            sum += i;
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) filters).getProperty("avg_value.value");
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
                    .minDocCount(0)
        for (int i = 0; i < numTag1Docs; ++i) {
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); i++) {
            )
        for (int i = numTag1Docs + numTag2Docs; i < numDocs; ++i) {
        assertSearchResponse(response);
            .get();
        return Arrays.asList(
        assertThat(filters, notNullValue());
                filters(
        assertThat(filters.getBuckets().size(), equalTo(2));
        bucket = itr.next();
            .get();
        assertThat(bucket, Matchers.notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                filters(
    public void testWithContextBasedSubAggregation() throws Exception {
        Histogram histo = searchResponse.getAggregations().get("histo");
            .addAggregation(
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
                .field("name", "name" + i)
        assertSearchResponse(response);
    public static Collection<Object[]> parameters() {
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(histo, Matchers.notNullValue());
        assertThat(filters, notNullValue());
                client().prepareIndex("empty_bucket_idx")
        assertThat(filters.getBuckets().size(), equalTo(3));
 * the Apache License, Version 2.0 (the "License"); you may
                filters(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        bucket = filters.getBucketByKey("_other_");
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                    + "context which the sub-aggregation can inherit"
    public FiltersIT(Settings dynamicSettings) {
            .get();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        assertThat(all, Matchers.notNullValue());
    }
                        "tags",
        assertThat(propertiesKeys[2], equalTo("_other_"));
            .addAggregation(filters("tags", termQuery("tag", "tag1"), termQuery("tag", "tag2")))
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        assertThat(filters.getBuckets().size(), equalTo(3));
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(avgValue, notNullValue());
            )
import org.opensearch.common.settings.Settings;
        assertThat(filters.getName(), equalTo("tags"));
        assertThat(filters.getBuckets().size(), equalTo(2));
            fail(
        Collection<? extends Filters.Bucket> buckets = filters.getBuckets();
 * KIND, either express or implied.  See the License for the
import java.util.Iterator;
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
import org.opensearch.search.aggregations.bucket.filter.Filters;
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
        }
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        assertThat(propertiesDocCounts[1], equalTo((long) numTag2Docs));
        sum = 0;
    }
                    randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
import static org.opensearch.search.aggregations.AggregationBuilders.filters;
public class FiltersIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
            .get();
            )
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
 */
        assertThat(filters, notNullValue());
        long sum = 0;
        assertSearchResponse(response);
        assertThat(((InternalAggregation) filters).getProperty("_bucket_count"), equalTo(3));
        return filters;
 * specific language governing permissions and limitations
        assertThat((double) propertiesCounts[0], equalTo((double) sum / numTag1Docs));
        assertThat(avgValue.getName(), equalTo("avg_value"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Collection;
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
/*
        }
                    .setId("" + i)
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                        randomOrder(new KeyedFilter("tag1", termQuery("tag", "tag1")), new KeyedFilter("tag2", termQuery("tag", "tag2")))
 *
                .field("name", "name" + i)
        QueryBuilder emptyFilter = new BoolQueryBuilder();
                )
 * license agreements. See the NOTICE file distributed with
            )
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) filters).getProperty("avg_value.value");
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
        for (int i = 0; i < numTag1Docs; ++i) {
    }
            .addAggregation(
            .addAggregation(histogram("histo").field("value").interval(2L).subAggregation(filters("filters", matchAllQuery())))
        }
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        Filters.Bucket bucket = filters.getBucketByKey("tag1");
import static org.hamcrest.Matchers.is;
        assertThat(filters.getName(), equalTo("tags"));
        assertThat(avgValue, notNullValue());
                    .subAggregation(filters("filters", new KeyedFilter("all", matchAllQuery())))
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
 * compatible open source license.
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(bucket, Matchers.notNullValue());
    // https://github.com/elastic/elasticsearch/issues/8438
        SearchResponse response = client().prepareSearch("idx")
        Filters.Bucket bucket = itr.next();
        assertThat(bucket, Matchers.notNullValue());
        assertThat((String) propertiesKeys[0], equalTo("tag1"));
import org.opensearch.index.query.QueryBuilder;
    }
                .field("value", i)
    public void testEmptyAggregationWithOtherBucket() throws Exception {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(filters.getBuckets().size(), equalTo(3));
        assertThat(bucket.getDocCount(), equalTo((long) numOtherDocs));
    public void testOtherNonKeyed() throws Exception {
        assertThat(bucket, Matchers.notNullValue());
        long sum = 0;
        assertThat(filters, notNullValue());
