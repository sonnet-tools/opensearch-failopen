                        .endObject()
        assertThat(nested.getName(), equalTo("nested"));
        assertNoFailures(response);
                    .startObject()
            for (int j = 0; j < numChildren[i]; ++j) {
 *
        XContentBuilder mapping = jsonBuilder().startObject()
            fail();
 * Modifications Copyright OpenSearch Contributors. See
            containsString("[inner_hits] already contains an entry for key [ih1]")
                    .startObject("name")
 * GitHub history for details.
                nested("to_method", "methods").subAggregation(
        Nested toMethods = response.getAggregations().get("to_method");
            .startObject("comments")
        assertThat(propertyId.getBucketByKey("5").getDocCount(), equalTo(1L));
        bucket = category.getBucketByKey("3");
                    .endObject()
        logger.info("AGG COLLECTION MODE: {}", aggCollectionMode);
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder()))
        assertThat(nested.getDocCount(), is(0L));
        assertThat(property.getDocCount(), equalTo(6L));
        assertThat(level2.getDocCount(), equalTo(1L));
        indexRandom(true, builders);
            .endObject();
                    )
        assertThat(stats.getAvg(), equalTo((double) sum / count));
                    .field("return_type", "void")
        assertThat(filter.getDocCount(), equalTo(1L));
                    .startObject()
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        bucket = period.getBucketByKey("2014-12");
            .field("format", "date_optional_time")
                                terms("period").field("dates.month.label")
            .addAggregation(
        assertSearchResponse(response);
    public void testEmptyAggregation() throws Exception {
                    .endObject()
                    )
                ++counts[value];
                    )
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .endObject()
        assertThat(nested, notNullValue());
                ++uniqueValues;
            )
 * Unless required by applicable law or agreed to in writing,
                )
 * KIND, either express or implied.  See the License for the
            .field("type", "nested")
        assertThat(values, notNullValue());
                    .startObject()
            .field("type", "nested")
        assertThat(propertyId.getBuckets().size(), equalTo(3));
                sum += value;
                            .subAggregation(
                        .subAggregation(
        ensureGreen("idxnullhitnames");
                    .field("return_type", "void")
        assertThat(((InternalAggregation) nested).getProperty("_count"), equalTo(docCount));
        Terms.Bucket bucket = startDate.getBucketByKey("2014-11-01T00:00:00.000Z");
        assertThat(bucket.getDocCount(), equalTo(3L));
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertHitCount(response, 2);
                    .endObject()
        assertAcked(
 * software distributed under the License is distributed on an
            );
    public void testParentFilterResolvedCorrectly() throws Exception {
        Terms period = bucket.getAggregations().get("period");
        bucket = endDate.getBucketByKey("2014-12-31T00:00:00.000Z");
        for (int i = 0; i < numParents; ++i) {
        assertHitCount(response, 2);
    }
            )
        for (long count : counts) {
            )
            .setQuery(
        assertThat(nested, Matchers.notNullValue());
        indexRequests.add(
                .setSource(
                            .startObject()
                    .startObject()
    }
                                            filter("comment_filter", termQuery("comments.identifier", "29111")).subAggregation(
            )
            .endObject()
        Terms.Bucket bBucket = a.getBucketByKey("a");
                    .endObject()
        indexRequests.add(
                jsonBuilder().startObject()
                    .endObject()
            .addAggregation(
            for (int j = 0; j < numChildren[i]; ++j) {
            }
        assertThat(level1.getDocCount(), equalTo(2L));
                        .field("b", 2)
        }
                    .field("id", 1)
        Nested nested = searchResponse.getAggregations().get("nested");
                                                nested("nested_tags", "comments.tags").subAggregation(
                        .field("b", 2)
            .startObject("dates")
            .endObject()
                    .startObject("name")
                    .endObject()
        assertThat(values, notNullValue());
            .addAggregation(
            if (counts[i] == 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.aggregations.bucket.filter.Filter;
                        .endObject()
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                    .startObject()
                    .endObject()
import java.util.ArrayList;
            assertThat(values.getBucketByKey(topValue), notNullValue());
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private static SubAggCollectionMode aggCollectionMode;
                    terms("return_type").field("methods.return_type")
import java.util.Arrays;
                    .size(100)
    private static int numParents;
            builders.add(
                    .startObject()
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder("ih2")))
        } catch (SearchPhaseExecutionException e) {
                    .field("type", "String")
                nested("nested", "nested").subAggregation(terms("values").field("nested.value").size(100).collectMode(aggCollectionMode))
                client().prepareIndex("empty_bucket_idx")
                    .startObject()
 * Licensed to Elasticsearch under one or more contributor
            prepareCreate("classes").setMapping(
            .startObject("end")
                            .endObject()
        assertAcked(
                    .startObject("methods")
        assertSearchResponse(response);
        nestedTags = filter.getAggregations().get("nested_tags");
import org.opensearch.action.search.SearchPhaseExecutionException;
        SearchResponse response = client().prepareSearch("classes")
                            .startArray("nested")
            .get();
        Nested comments = bucket.getAggregations().get("ctxt_idfier_nested");
            .get();
                    MediaTypeRegistry.JSON
            .setId("2")
            prepareCreate("idx2").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
                boolQuery().should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder()))
            .endObject()
                    .subAggregation(nested("nested", "nested").subAggregation(max("max_value").field("nested.value")))
                    nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder("ih1"))
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(values.getBuckets(), notNullValue());
        for (int i = 0; i < counts.length; ++i) {
                jsonBuilder().startObject()
        LongTerms values = response.getAggregations().get("top_values");
            .setSource(
        assertThat(nested.getDocCount(), equalTo(count));
        assertThat(numStringParams.getDocCount(), equalTo(3L));
        long[] counts = new long[numParents + 6];
import org.opensearch.common.settings.Settings;
                    .field("type", "keyword")
 * The OpenSearch Contributors require contributions made to
                    .startArray("property")
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
            client().prepareIndex("idx2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .startObject()
        );
                        .startArray("nested1")
                                    )
                    .endObject()
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
                            .endObject()
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)
 * You may obtain a copy of the License at
            )
            .get();
                    .endObject()
            Max max = nested.getAggregations().get("max_value");
                        jsonBuilder().startObject()
                )
                                "num_string_params",
        assertThat(((InternalAggregation) nested).getProperty("values"), sameInstance(values));
                    .startArray("parameters")
import org.opensearch.search.aggregations.InternalAggregation;
                    .field("name", "add")
                        .startArray("nested2")
                    .field("return_type", "Query")
    }
                    .field("name", "name")
                            )
        assertThat(level2.getDocCount(), equalTo(1L));
            builders.add(client().prepareIndex("idx").setId("" + i + 1).setSource(source));
                boolQuery().should(
        bucket = category.getBucketByKey("2");
                nested("level1", "nested1").subAggregation(
            .setSource(
import org.opensearch.search.aggregations.bucket.nested.Nested;
import org.opensearch.core.rest.RestStatus;
        double min = Double.POSITIVE_INFINITY;
                        + "{\"tid\" : 22, \"name\": \"DataChannels\"}], \"identifier\": \"29101\"}]}",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(stats.getMin(), equalTo(min));
                    .field("name", "context")
            );
                    .startArray("parameters")
        indexRandomForConcurrentSearch("classes");
    public void testNestedOnObjectField() throws Exception {
                            .field("value", i + 1)
    }
        propertyId = property.getAggregations().get("property_id");
        indexRandomForConcurrentSearch("idx4");
import org.apache.lucene.search.join.ScoreMode;
        assertThat(propertyId.getBucketByKey("4").getDocCount(), equalTo(1L));
            .addAggregation(
        assertThat(bBucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(1L));
        Terms.Bucket bucket = category.getBucketByKey("1");
                            .endObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(property.getDocCount(), equalTo(6L));
            .get();
        assertThat(comments.getDocCount(), equalTo(2L));
                                                )
                    .field("id", 2)
        );
                    .startObject("properties")
        assertThat(propertyId.getBuckets().size(), equalTo(5));
                    .field("id", 1)
            String topValue = "" + (i + 1);
            .field("type", "keyword")
            containsString("[inner_hits] already contains an entry for key [property]")
            client().prepareIndex("idx2")
    }
 * compatible open source license.
                    .startObject("return_type")
    public static Collection<Object[]> parameters() {
                    .startArray("parameters")
    public void testNestNestedAggs() throws Exception {
                    .endObject()
            .field("type", "keyword")
                    .startArray("parameters")
                    .endArray()
                    .field("type", "text")
            .field("format", "date_optional_time")
            )
        refresh();
                    .startObject("properties")
        int totalChildren = 0;
            .endObject()
        assertThat(propertyId.getBucketByKey("4").getDocCount(), equalTo(1L));
                            .field("value", i + 5)
            .get();
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
        );
        assertThat(values.getBuckets().size(), equalTo(numParents));
                .setSource(
                    .endObject()
        property = bucket.getAggregations().get("property");
                    .startObject()
                            .field("value", i * 2)
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getSum(), equalTo((double) sum));
 *
                        + "\"day\": \"2014-11-30\"}, \"comments\": [{\"cid\": 3,\"identifier\": \"29111\"}, {\"cid\": 4,\"tags\": ["
import static org.opensearch.index.query.QueryBuilders.termQuery;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        client().prepareIndex("idx4")
            .get();
                terms("startDate").field("dates.month.start")
            if (i == numParents - 1 && totalChildren == 0) {
        indexRandomForMultipleSlices("idx");
                            .startObject()
                                    .subAggregation(
 * ownership. Elasticsearch licenses this file to you under
                            .endArray()
        SearchResponse response = client().prepareSearch("idx")
            }
                    .field("name", "product1")
            .field("type", "long")
            .setSource(
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        Nested nested = bucket.getAggregations().get("nested");
                        .field("a", "a")
import org.opensearch.action.search.SearchResponse;
            prepareCreate("idx_nested_nested_aggs").setMapping(
            ).setMapping("categories", "type=keyword", "name", "type=text", "property", "type=nested")
        for (int i = 0; i < 2; i++) {
                    .endObject()
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
            }
        assertThat(level1.getName(), equalTo("level1"));
                    .endObject()
    }
            .setId("1")
                    .startArray("property")
                // we need at least one child overall
                    .endObject()
        property = bucket.getAggregations().get("property");
                    .field("name", "boost")
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch("idxduplicatehitnames")
                    .startObject("properties")
import org.opensearch.search.aggregations.metrics.Max;
            .startObject("tags")
                    .endObject()
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(1L));
        Stats stats = nested.getAggregations().get("nested_value_stats");
                    .startObject()
                        + "{\"tid\" :44,\"name\": \"Roles\"}], \"identifier\": \"29101\"}]}",
                assertEquals(counts[i], bucket.getDocCount());
                    .setId("" + i)
        assertThat(nested.getName(), equalTo("nested"));
        assertThat(sum.getValue(), equalTo(2d));
                    .startObject("nested2")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    }
        }
    public void testFilterAggInsideNestedAgg() throws Exception {
        client().prepareIndex("classes")
            client().prepareIndex("idx_nested_nested_aggs")
        Terms startDate = response.getAggregations().get("startDate");
/*
        long sum = 0;
            }
        toMethods = response.getAggregations().get("to_method");
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder("ih1")))
            if (count > 0) {
        assertThat(level1, notNullValue());
                    .field("name", "queryName")
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
            .endObject()
        assertThat(nested.getName(), equalTo("nested"));
        indexRandom(true, indexRequests);
                            .endObject()
import org.opensearch.test.OpenSearchIntegTestCase;
                    .field("name", "field")
                            .startObject()
        client().prepareIndex("classes")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        Nested property = bucket.getAggregations().get("property");
    public NestedIT(Settings staticSettings) {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));
    public void testSimple() throws Exception {
                            .field("value", i + 2)
                    .endObject()
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).startArray("nested");
            .endObject()
@OpenSearchIntegTestCase.SuiteScopeTestCase
 * license agreements. See the NOTICE file distributed with
                    .endObject()
                    .field("type", "keyword")
                    .endArray()
        tags = nestedTags.getAggregations().get("tag");
            ).setMapping("categories", "type=keyword", "name", "type=text", "property", "type=nested")
                        + "\"day\": \"2014-12-03\"}, \"comments\": [{\"cid\": 1, \"identifier\": \"29111\"}, {\"cid\": 2,\"tags\": ["
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(1L));
            .field("type", "long")
                    .endArray()
                    .field("type", "text")
                                        nested("ctxt_idfier_nested", "comments").subAggregation(
import org.hamcrest.Matchers;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .field("name", "boost")
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
 */
                    .endObject()
            .setQuery(
                            .endObject()
        refresh();
    public void testNestedAsSubAggregation() throws Exception {
        internalCluster().wipeIndices("classes");
        for (int i = 0; i < numParents; i++) {
        );
/*
    public void testNestedWithSubTermsAgg() throws Exception {
                    .field("type", "String")
                    .endArray()
                    .startArray("methods")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
 * the Apache License, Version 2.0 (the "License"); you may
                                nestedQuery("methods.parameters", termQuery("methods.parameters.type", "String"), ScoreMode.None)
        Nested level2 = bBucket.getAggregations().get("level2");
                        .subAggregation(nested("level2", "nested1.nested2").subAggregation(sum("sum").field("nested1.nested2.b")))
import org.opensearch.search.aggregations.metrics.Stats;
        assertThat(nested.getName(), equalTo("nested"));
                    .subAggregation(nested("property", "property").subAggregation(terms("property_id").field("property.id")))
                    .field("type", "text")
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));
            )
            assertThat(nested, notNullValue());
                    .field("type", "nested")
/*
        assertThat(tags.getBuckets().size(), equalTo(0)); // and this must be empty
            .field("type", "date")
                        .endArray()
        }
                max = Math.max(max, value);
            .startObject("name")
        }
                numChildren[i] = randomInt(5);
                    .startObject()
                                                    terms("tag").field("comments.tags.name")
            } else {
        Filter numStringParams = toMethods.getAggregations().get("num_string_params");
            prepareCreate("idxduplicatehitnames").setSettings(
            .field("type", "date")
        assertAcked(
                        terms("endDate").field("dates.month.end")
    private static int[] numChildren;
        Nested nestedTags = filter.getAggregations().get("nested_tags");
                    .startArray("parameters")
    }
                    .endObject()
import org.opensearch.action.search.SearchRequestBuilder;
        propertyId = property.getAggregations().get("property_id");
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
        SearchResponse response = client().prepareSearch("idx_nested_nested_aggs")
                    .startObject()
        numStringParams = bucket.getAggregations().get("num_string_params");
            .get();
            .startObject("tid")
                    .field("type", "nested")
                jsonBuilder().startObject()
            .startObject("identifier")
                    .endObject()
                    .subAggregation(
            .addAggregation(nested("nested", "nested").subAggregation(stats("nested_value_stats").field("nested.value")))
                        .endArray()
        bucket = startDate.getBucketByKey("2014-12-01T00:00:00.000Z");
            .startObject("month")
 * specific language governing permissions and limitations
            source = source.endArray().endObject();
        internalCluster().wipeIndices("idxduplicatehitnames");
            .endObject()
        a = level1.getAggregations().get("a");
                    .endObject()
                    jsonBuilder().startObject()
                    .startObject("name")
            .endObject()
                    .endObject()
        assertThat(stats.getMax(), equalTo(max));
            .startObject("cid")
        indexRandomForConcurrentSearch("idx_nested_nested_aggs");
            );
        );
        assertThat(nestedTags.getDocCount(), equalTo(0L)); // This must be 0
        assertAcked(prepareCreate("idx").setMapping("nested", "type=nested", "incorrect", "type=object"));
                    MediaTypeRegistry.JSON
    }
                    .endObject()
        assertThat(values.getName(), equalTo("values"));
        assertThat(bucket.getDocCount(), equalTo(1L));
            .field("type", "date")
    }
            } else {
        internalCluster().wipeIndices("idx2");
                source = source.startObject().field("value", i + 1 + j).endObject();
                    .field("name", "queryName")
                    .array("categories", "1", "2")
        assertThat(filter.getDocCount(), equalTo(1L));
        List<IndexRequestBuilder> indexRequests = new ArrayList<>(2);
                .setId("1")
        }
        ensureGreen("idx_nested_nested_aggs");
        numParents = randomIntBetween(3, 10);
            assertThat(max.getValue(), equalTo(numChildren[i] == 0 ? Double.NEGATIVE_INFINITY : (double) i + numChildren[i]));
        assertNoFailures(response);
        long count = 0;
            final String key = Long.toString(i);
        level2 = bBucket.getAggregations().get("level2");
            .endObject()
        builders.add(
        assertSearchResponse(response);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                    .startArray("methods")
                        .startObject()
        }
            .addAggregation(nested("nested", "value").subAggregation(stats("nested_value_stats").field("nested.value")))
import static org.hamcrest.Matchers.sameInstance;
                )
                    .field("id", 3)
            prepareCreate("idx4").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            client().prepareSearch("idx").setQuery(matchAllQuery()).addAggregation(nested("object_field", "incorrect")).get();
            )
            .setQuery(matchAllQuery())
        super(staticSettings);
        numStringParams = bucket.getAggregations().get("num_string_params");
        assertFailures(
                    .startObject("type")
                    .startObject()
        assertThat(values.getBuckets(), notNullValue());
                        .endObject()
            .startObject("properties")
 * under the License.
        assertSearchResponse(response);
            .addAggregation(
                nested("to_method", "methods").subAggregation(
            .startObject("start")
        client().prepareIndex("idx4")
            .get();
            .setSource(
                    .field("id", 4)
                            .field("value", i + 3)
            RestStatus.BAD_REQUEST,
        SearchResponse response = client().prepareSearch("idx2")
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(1L));
        assertTrue(totalChildren > 0);
                )
                numChildren[i] = randomIntBetween(1, 5);
                    .field("name", "toQuery")
                    "{\"dates\": {\"month\": {\"label\": \"2014-12\", \"end\": \"2014-12-31\", \"start\": \"2014-12-01\"}, "
                .setSource(
            .startObject("properties")
            .get();
                        "num_string_params",
    public void testExtractInnerHitBuildersWithDuplicateHitName() throws Exception {
                    .field("return_type", "void")
        ensureGreen("idxduplicatehitnames");
            searchRequestBuilder,
        assertThat(nested, notNullValue());
        double max = Double.NEGATIVE_INFINITY;
    public void testExtractInnerHitBuildersWithDuplicatePath() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        Filter filter = comments.getAggregations().get("comment_filter");
                min = Math.min(min, value);
                                        )
            .get();
        property = bucket.getAggregations().get("property");
        Bucket bucket = terms.getBucketByKey("void");
            .endObject()
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer", "nested", "type=nested").get();
        int uniqueValues = 0;
                        .startArray("nested2")
import java.util.List;
                    .field("return_type", "QueryBuilder")
                    .field("name", "product2")
import org.opensearch.search.aggregations.metrics.Sum;
                    .startObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        aggCollectionMode = randomFrom(SubAggCollectionMode.values());
                .setMapping(mapping)
        Terms endDate = bucket.getAggregations().get("endDate");
            .endObject()
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            .field("format", "date_optional_time")
                jsonBuilder().startObject()
        for (int i = 0; i < numParents; ++i) {
                    .field("type", "QueryShardContext")
        ensureGreen("idx4");
import org.opensearch.search.aggregations.bucket.terms.Terms;
        internalCluster().wipeIndices("idxnullhitnames");
        assertThat(propertyId.getBuckets().size(), equalTo(5));
    @Override
                    .startObject()
        period = bucket.getAggregations().get("period");
        ensureGreen("empty_bucket_idx");
        SearchResponse response = client().prepareSearch("idx")
                            .startObject()
        );
import org.opensearch.action.index.IndexRequestBuilder;
                    .endArray()
        ensureGreen("idx");
        bucket = terms.getBucketByKey("QueryBuilder");
            .setId("2")
    }
                    .collectMode(aggCollectionMode)
            .get();
                    .startObject("nested1")
            .endObject()
                    .endArray()
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder()))
            prepareCreate("idxnullhitnames").setSettings(
        internalCluster().wipeIndices("idx4");
                        )
                )
                jsonBuilder().startObject()
        Terms category = response.getAggregations().get("category");
        Nested nested = response.getAggregations().get("nested");
            }
        assertThat(values.getName(), equalTo("top_values"));
                    .startArray("parameters")
            .get();
        assertThat(nestedTags.getDocCount(), equalTo(0L)); // This must be 0
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(category.getBuckets().size(), equalTo(4));
 * not use this file except in compliance with the License.
                Bucket bucket = values.getBucketByKey(key);
 */
                    .field("type", "nested")
    }
        numStringParams = bucket.getAggregations().get("num_string_params");
        SearchResponse response = client().prepareSearch("idx")
        bucket = terms.getBucketByKey("Query");
                ++docCount;
        bucket = period.getBucketByKey("2014-11");
                .setId("2")
            .get();
package org.opensearch.search.aggregations.bucket;
import java.util.Collection;
            .setId("1")
        assertThat(startDate.getBuckets().size(), equalTo(2));
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));
    // Test based on: https://github.com/elastic/elasticsearch/issues/9280
                )
                final long value = i + 1 + j;
        );
                assertNotNull(bucket);
                        .startObject()
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .endObject()
            totalChildren += numChildren[i];
                    .field("name", "QueryBuilder")
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
        assertThat(numStringParams.getDocCount(), equalTo(2L));
        assertThat(bucket.getDocCount(), equalTo(1L));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                jsonBuilder().startObject()
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
                    .field("type", "nested")
                    filter(
                    .endObject()
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));
                    .field("id", 5)
        }
            .field("type", "object")
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(2L));
        ensureSearchable();
                    .endArray()
            )
            .endObject()
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)
                )
                    .field("type", "IndexableField")
                    .endObject()
        );
            assertThat(e.toString(), containsString("[nested] nested path [incorrect] is not nested"));
                final int value = i + 1 + j;
        assertThat(bucket, Matchers.notNullValue());
        assertAcked(
            Nested nested = values.getBucketByKey(topValue).getAggregations().get("nested");
                    .endObject()
        SearchResponse response = client().prepareSearch("idx4")
                            )
        }
                    .endObject()
                .setId("1")
        sum = level2.getAggregations().get("sum");
                    .startObject("parameters")
                            .field("value", i + 4)
        assertThat(bucket.getDocCount(), equalTo(1L));
                    .endObject()
        StringTerms a = level1.getAggregations().get("a");
                    .endArray()
                    .setSource(
    }
            }
        assertThat(histo, Matchers.notNullValue());
            .endObject()
        assertThat(property.getDocCount(), equalTo(3L));
import static org.hamcrest.Matchers.equalTo;
        filter = comments.getAggregations().get("comment_filter");
        assertAcked(
            searchRequestBuilder,
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch("idxnullhitnames")
            .addAggregation(
        assertThat(values.getBuckets().size(), equalTo(uniqueValues));
                    .endObject()
    }
                    terms("a").field("nested1.a.keyword")
                        .endObject()
                        .endObject()
        Histogram histo = searchResponse.getAggregations().get("histo");
                    .endObject()
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(2L));
                    .field("type", "float")
import org.opensearch.core.xcontent.XContentBuilder;
        numChildren = new int[numParents];
        propertyId = property.getAggregations().get("property_id");
                    .startObject("properties")
            .startObject("properties")
    }
                        .field("a", "b")
            assertThat(max, notNullValue());
                            .startObject()
            )
        return Arrays.asList(
                        .collectMode(aggCollectionMode)
        for (int i = 0; i < numParents; ++i) {
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .endObject()
                            filter(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.InnerHitBuilder;
        try {
 * this work for additional information regarding copyright
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(nested("nested", "nested")))
    @ParametersFactory
        Sum sum = level2.getAggregations().get("sum");
        );
                        nestedQuery("methods.parameters", termQuery("methods.parameters.type", "String"), ScoreMode.None)
            .addAggregation(
            .startObject("properties")
                    .field("name", "Document")
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            .startObject("properties")
                            .endObject()
                    .field("name", "name")
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
            RestStatus.BAD_REQUEST,
                    .startObject("properties")
            .startObject("day")
            for (int j = 0; j < numChildren[i]; ++j) {
        bucket = category.getBucketByKey("4");
        Terms propertyId = property.getAggregations().get("property_id");
                    .array("categories", "1", "2", "3", "4")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .endObject()
        ensureGreen("idx2");
import static org.hamcrest.Matchers.is;
                    .endObject()
            .get();
            )
 */
                    .field("name", "removeFields")
        assertThat(nested, Matchers.notNullValue());
        assertThat(numStringParams.getDocCount(), equalTo(1L));
                    .endObject()
                    .endArray()
            )
}
        Nested level1 = response.getAggregations().get("level1");
        assertThat(bBucket.getDocCount(), equalTo(1L));
        assertThat(propertyId.getBucketByKey("5").getDocCount(), equalTo(1L));
        assertThat(stats, notNullValue());
        comments = bucket.getAggregations().get("ctxt_idfier_nested");
                    .endObject()
        assertThat(sum.getValue(), equalTo(2d));
        long docCount = 0;
                    .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertFailures(
                    .field("type", "String")
        assertThat(nested.getDocCount(), equalTo(docCount));
        assertThat(comments.getDocCount(), equalTo(2L));
import static org.hamcrest.Matchers.containsString;
        assertThat(nested.getDocCount(), is(0L));
            )
        bucket = endDate.getBucketByKey("2014-11-30T00:00:00.000Z");
import static org.hamcrest.core.IsNull.notNullValue;
        Terms tags = nestedTags.getAggregations().get("tag");
                                            )
        assertThat(bucket.getDocCount(), equalTo(1L));
                    "{\"dates\": {\"month\": {\"label\": \"2014-11\", \"end\": \"2014-11-30\", \"start\": \"2014-11-01\"}, "
                terms("category").field("categories")
                .setMapping("categories", "type=keyword", "name", "type=text", "property", "type=nested")
                    .field("return_type", "QueryBuilder")
    public void setupSuiteScopeCluster() throws Exception {
    public void testNestedSameDocIdProcessedMultipleTime() throws Exception {
            .field("type", "object")
public class NestedIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));
                    .startObject()
        );
            .field("type", "keyword")
                assertNull(values.getBucketByKey(key));
        assertThat(numStringParams.getDocCount(), equalTo(0L));
            .startObject("label")
        assertThat(bucket.getDocCount(), equalTo(1L));
        }
        Terms terms = toMethods.getAggregations().get("return_type");
                        .startObject()
        response = client().prepareSearch("classes")
        assertThat(property.getDocCount(), equalTo(3L));
        assertThat(tags.getBuckets().size(), equalTo(0)); // and this must be empty
                ++count;
        assertThat(propertyId.getBuckets().size(), equalTo(3));
        Nested nested = response.getAggregations().get("nested");
            .endObject()
        endDate = bucket.getAggregations().get("endDate");
                        .startObject()
        );
        LongTerms values = nested.getAggregations().get("values");
                terms("top_values").field("value")
                    .startObject()
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .startObject()
                    .endArray()
                        .endArray()
        bBucket = a.getBucketByKey("b");
                    .field("name", "removeField")
                    .endObject()
    public void testNonExistingNestedField() throws Exception {
                    .endObject()
        assertThat(stats.getCount(), equalTo(count));
        for (int i = 0; i < numParents; i++) {
 *
