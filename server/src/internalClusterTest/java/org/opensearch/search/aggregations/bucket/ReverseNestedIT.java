                                            filter("filter_sku_color", termQuery("sku.colors.name", "red")).subAggregation(
            Filter filterBarColor = nested2.getAggregations().get("filter_sku_color");
            prepareCreate("idx3").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("a"));
        bucket = usernameBuckets.get(8);
        assertThat(bucket.getKeyAsString(), equalTo("9"));
                    .startObject()
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
                    .endObject()
                            reverseNested("to_root").subAggregation(
            .get();
        assertThat(bucket.getDocCount(), equalTo(3L));
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                    .endObject()
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
        bucket = usernameBuckets.get(7);
        client().prepareIndex("idx3")
                jsonBuilder().startObject()
            .endObject()
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
                    .endObject()
        assertThat(terms.getBuckets().size(), equalTo(3));
        assertThat(nested.getDocCount(), is(0L));
                    .endArray()
        assertThat(tagsBuckets.size(), equalTo(4));
/*
            .endObject()
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));
            new String[][] { new String[] { "a", "0", "0", "1", "2" }, new String[] { "b", "0", "1", "1", "2" }, new String[] { "a", "0" } }
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertThat(reverseNested.getDocCount(), equalTo(4L));
            assertThat(nested2.getDocCount(), equalTo(8L));
        Nested nested = searchResponse.getAggregations().get("nested2");
 *
                    .startObject()
                    .field("name", "abc")
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        assertThat(terms.getBuckets().size(), equalTo(3));
                    .field("type", "keyword")
                    .startObject()
            assertThat(nested1.getDocCount(), equalTo(5L));
import org.opensearch.search.aggregations.BucketOrder;
                        )
                .setMapping(mapping)
        tags = reverseNested.getAggregations().get("field1");
            assertThat(toRoot.getDocCount(), equalTo(1L));
            .addAggregation(
        }
                    .field("sku_type", "bar1")
        terms = nested0.getAggregations().get("group_by_category");
    public void testSimpleNested1ToRootToNested2() throws Exception {
        refresh();
                            )
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
 *
                    .endObject()
                            )
                    .endArray()
        assertThat(bucket.getDocCount(), equalTo(4L));
        assertNoFailures(response);
        assertThat(bucket.getDocCount(), equalTo(2L));
            .field("dynamic", "strict")
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
            )
 *
                    .field("name", "yellow")
    private void insertIdx1(List<String> values1, List<String> values2) throws Exception {
        bucket = usernameBuckets.get(3);
            )
                    .startObject()
        assertThat(tagsBuckets.size(), equalTo(4));
        bucket = usernameBuckets.get(1);
            )
        assertSearchResponse(response);
        assertThat(tagsBuckets.size(), equalTo(4));
                                terms("field1").field("field1").collectMode(randomFrom(SubAggCollectionMode.values()))
        Terms.Bucket bucket = usernameBuckets.get(0);
        assertThat(tagsBuckets.size(), equalTo(6));
                    .startObject()
                jsonBuilder().startObject()
        Terms usernames = nested.getAggregations().get("field2");
                                            )
                nested("nested1", "nested1").subAggregation(
                    .endObject()
    public void testSimpleReverseNestedToRoot() throws Exception {
                            )
            .addAggregation(
                    .startObject("field1")
                        .subAggregation(
                    terms("field2").field("nested1.nested2.field2")
            .setSource(
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
        assertThat(bucket.getKeyAsString(), equalTo("4"));
                        .subAggregation(
                                terms("field1").field("alias").collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
            .field("type", "long")
                            reverseNested("to_root").subAggregation(
        assertThat(bucket.getKeyAsString(), equalTo("3"));
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("d"));
                                )
        SearchResponse response = client().prepareSearch("idx1")
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("d"));
        assertThat(bucket.getDocCount(), equalTo(2L));
        // nested.field2: 1
public class ReverseNestedIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                )
        source.endArray().endObject();
            Nested nested2 = filterByBar.getAggregations().get("nested_2");
 * this file be licensed under the Apache-2.0 license or a
            .field("type", "nested")
            .get();
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(nested, notNullValue());
                    .endObject()
        assertAcked(
        ReverseNested reverseNested = bucket.getAggregations().get("nested1_to_field1");
        Nested nested = response.getAggregations().get("nested1");
        ReverseNested reverseNested = nested.getAggregations().get("nested1_to_root");
            .startObject("sku")
        assertThat(nested.getName(), equalTo("nested2"));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("x"));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
 * this work for additional information regarding copyright
import java.util.ArrayList;
        assertThat(tagsBuckets.get(4).getKeyAsString(), equalTo("b"));
                                )
                    .endObject()
            .endObject()
                    terms("field2").field("nested1.nested2.field2")
        insertIdx1(Arrays.asList("b", "c", "d"), Arrays.asList("4", "5", "6", "7"));
        assertThat(bucket.getKeyAsString(), equalTo("1"));
        assertThat(bucket.getKeyAsString(), equalTo("0"));
        }
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
            .field("type", "keyword")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(usernames.getBuckets().size(), equalTo(5));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("d"));
                    .field("type", "keyword")
        ReverseNested reverseNested = bucket.getAggregations().get("nested1_to_field1");
import static org.opensearch.search.aggregations.AggregationBuilders.count;
        assertThat(tagsBuckets.size(), equalTo(5));
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("d"));
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("d"));
        assertThat(nested.getDocCount(), equalTo(9L));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
            .startObject("properties")
            .get();
        assertThat(reverseNested.getDocCount(), equalTo(4L));
                    .field("sku_type", "bar2")
            .startObject("category")
        assertThat(tagsBuckets.get(4).getKeyAsString(), equalTo("e"));
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
            fail("Expected SearchPhaseExecutionException");
                        .size(10000)
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        tags = reverseNested.getAggregations().get("field1");
                                        .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(filterByBar.getDocCount(), equalTo(3L));
                    .startObject()
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("f"));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
        );
            .get();
                    .field("name", "orange")
                    .endObject()
        tags = reverseNested.getAggregations().get("field1");
        } catch (SearchPhaseExecutionException e) {
                                        .order(BucketOrder.key(true))
                    .startArray("colors")
                    .endObject()
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
                    .startObject()
            .startObject("id")
            .get();
                nested("nested1", "nested1.nested2").subAggregation(
        assertThat(nested.getName(), equalTo("root_to_nested2"));
    @Override
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
                    .endObject()
        assertThat(nested.getName(), equalTo("nested1"));
                    terms("group_by_category").field("category.name")
                nested("nested1", "nested1").subAggregation(
            .field("type", "keyword")
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("f"));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
                source.startObject().field("field2", value[i]).endObject();
        assertThat(nested, notNullValue());
                    .endObject()
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
                    terms("group_by_category").field("category.name")
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));
 * GitHub history for details.
                        )
            .endObject()
        assertThat(tagsBuckets.size(), equalTo(3));
        assertThat(bucket.getDocCount(), equalTo(6L));
    }
        assertThat(tagsBuckets.size(), equalTo(2));
                    .endArray()
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(12L));
        assertThat(bucket.getKeyAsString(), equalTo("8"));
            )
                    .endObject()
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
        tags = reverseNested.getAggregations().get("field1");
        insertIdx1(Arrays.asList("z"), Arrays.asList("5", "9"));
                        .subAggregation(
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
                nested("nested_0", "category").subAggregation(
 * compatible open source license.
                            )
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
        Terms.Bucket bucket = usernameBuckets.get(0);
    public void testFieldAlias() {
        assertAcked(
        assertSearchResponse(response);
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("z"));
        }
 * license agreements. See the NOTICE file distributed with
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("d"));
}
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
        insertIdx1(Arrays.asList("a"), Arrays.asList("3", "4"));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
 * specific language governing permissions and limitations
                    .field("name", "white")
        indexRandom(false, client().prepareIndex("idx1").setRouting("1").setSource(source));
        // nested.field2: 3
import static org.hamcrest.Matchers.equalTo;
    @ParametersFactory
        tagsBuckets = new ArrayList<>(tags.getBuckets());
        SearchResponse response = client().prepareSearch("idx2")
            Filter filterByBar = nested1.getAggregations().get("filter_by_sku");
        assertThat(nested, notNullValue());
        response = client().prepareSearch("idx3")
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(3L));
                )
        assertThat(bucket.getDocCount(), equalTo(2L));
import org.opensearch.search.aggregations.bucket.terms.Terms;
                        .subAggregation(
                    .endObject()
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
 * not use this file except in compliance with the License.
                                terms("field1").field("nested1.field1").collectMode(randomFrom(SubAggCollectionMode.values()))
            .field("type", "keyword")
        tags = reverseNested.getAggregations().get("field1");
                    .endObject()
                        .subAggregation(
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
                        .order(BucketOrder.key(true))
            ValueCount barCount = reverseToBar.getAggregations().get("sku_count");
@OpenSearchIntegTestCase.SuiteScopeTestCase
            assertThat(barCount.getValue(), equalTo(2L));
            .addAggregation(
            .setId("1")
                    .endObject()
    }
                    .endObject()
        assertThat(nested.getDocCount(), equalTo(25L));
                nested("nested1", "nested1").subAggregation(
        assertThat(usernames, notNullValue());
            client().prepareSearch("idx2")
        tagsBuckets = new ArrayList<>(tags.getBuckets());
            .addAggregation(
        tags = reverseNested.getAggregations().get("field1");
        for (String value1 : values2) {
        assertThat(reverseNested.getDocCount(), equalTo(2L));
        // Test that parsing the reverse_nested agg doesn't fail, because the parent nested agg is unmapped:
 */
        );
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));
                    .startObject()
        insertIdx1(Arrays.asList("a", "e"), Arrays.asList("7", "4", "1", "1"));
        SearchResponse response = client().prepareSearch("idx2")
        tags = reverseNested.getAggregations().get("field1");
            .startObject("sku_type")
        assertThat(reverseNestedTerms.getBuckets().size(), equalTo(6));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            )
        assertThat(tagsBuckets.size(), equalTo(5));
                )
            Nested nested1 = toRoot.getAggregations().get("nested_1");
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(2L));
            .endObject()
        assertThat(((InternalAggregation) reverseNested).getProperty("_count"), equalTo(5L));
 * the Apache License, Version 2.0 (the "License"); you may
                    .field("type", "keyword")
            assertThat(filterByBar.getDocCount(), equalTo(3L));
                    .field("sku_type", "bar1")
    }
                        )
            .endObject()
                    .startObject("properties")
    }
                    .field("name", "pink")
        Nested nested = response.getAggregations().get("nested1");
    public void testSameParentDocHavingMultipleBuckets() throws Exception {
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
        assertThat(bucket.getKeyAsString(), equalTo("1"));
        // nested.field2: 6
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(bucket.getKeyAsString(), equalTo("2"));
            .setQuery(matchAllQuery())
        assertThat(bucket.getKeyAsString(), equalTo("2"));
            Filter filterByBar = nested1.getAggregations().get("filter_by_sku");
import org.opensearch.search.aggregations.bucket.nested.ReverseNested;
                    .startObject("properties")
                    .endObject()
        // nested.field2: 5
            )
        assertThat(bucket.getDocCount(), equalTo(5L));
        assertThat(usernames, notNullValue());
        refresh();
        assertThat(usernames.getBuckets().size(), equalTo(9));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    .startObject()
                    .endObject()
        assertThat(bucket.getKeyAsString(), equalTo("3"));
        insertIdx2(new String[][] { new String[] { "a", "0", "0", "0", "0" }, new String[] { "b", "0", "0", "0", "0" } });
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
        for (String bucketName : new String[] { "abc", "klm", "xyz" }) {
            .get();
        super(staticSettings);
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
        assertSearchResponse(response);
                                                reverseNested("reverse_to_sku").path("sku")
                            )
        Terms tags = reverseNested.getAggregations().get("field1");
        Nested nested0 = response.getAggregations().get("nested_0");
            .addAggregation(nested("nested2", "nested1.nested2").subAggregation(reverseNested("incorrect").path("nested3")))
                        )
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
            .get();
    }
                .addAggregation(
        refresh();
            assertThat(barCount.getValue(), equalTo(3L));
                    .endObject()
        Terms terms = nested0.getAggregations().get("group_by_category");
        tags = reverseNested.getAggregations().get("field1");
        }
            assertThat(toRoot.getDocCount(), equalTo(1L));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
            .startObject("properties")
                        )
        assertThat(tagsBuckets.size(), equalTo(4));
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
                                                    .subAggregation(count("sku_count").field("sku.sku_type"))
                    .endObject()
                    .field("type", "nested")
            .endObject()
        assertThat(bucket.getKeyAsString(), equalTo("4"));
                    .endObject()
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.core.IsNull.notNullValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
                    .startObject()
                                .subAggregation(
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        assertThat(reverseNested.getDocCount(), is(0L));
 * ownership. Elasticsearch licenses this file to you under
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
                    .endObject()
            Terms.Bucket bucket = terms.getBucketByKey(bucketName);
        assertThat(tagsBuckets.get(4).getDocCount(), equalTo(1L));
                        )
                .get();
    }
        XContentBuilder mapping = jsonBuilder().startObject()
            .startObject("name")
        assertThat(bucket.getKeyAsString(), equalTo("6"));
        bucket = usernameBuckets.get(2);
        nested0 = response.getAggregations().get("nested_0");
        for (String[] value : values) {
        insertIdx2(new String[][] { new String[] { "e", "1", "2" }, new String[] { "f", "3", "4" } });
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
                    terms("field2").field("nested1.field2")
            .startObject("properties")
        List<Terms.Bucket> usernameBuckets = new ArrayList<>(usernames.getBuckets());
        assertThat(tagsBuckets.get(5).getDocCount(), equalTo(1L));
        source.endArray().endObject();
        searchResponse = client().prepareSearch("idx1")
import java.util.Arrays;
        List<Terms.Bucket> tagsBuckets = new ArrayList<>(tags.getBuckets());
                                nested("nested_1", "sku").subAggregation(
                    .endObject()
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(reverseNested.getDocCount(), equalTo(4L));
        List<Terms.Bucket> tagsBuckets = new ArrayList<>(tags.getBuckets());
        insertIdx1(Arrays.asList("y", "c"), Arrays.asList("6"));
        assertThat(tagsBuckets.size(), equalTo(4));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
            prepareCreate("idx2").setMapping(
        tags = reverseNested.getAggregations().get("field1");
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("c"));
            .addAggregation(nested("incorrect1", "incorrect1").subAggregation(reverseNested("incorrect2").path("incorrect2")))
        );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .startObject("nested1")
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
import org.opensearch.common.settings.Settings;
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));
            assertThat(nested1.getDocCount(), equalTo(5L));
                    .startObject("nested2")
            .startObject("properties")
        Nested nested = response.getAggregations().get("nested1");
                    .endObject()
        insertIdx1(Arrays.asList("x", "c"), Arrays.asList("1", "8"));
                    .field("name", "klm")
            prepareCreate("idx1").setMapping(
        Nested nested = response.getAggregations().get("nested1");
        assertThat(((InternalAggregation) reverseNested).getProperty("field1"), sameInstance(reverseNestedTerms));
                    .startObject("alias")
            source.startObject().field("field1", value[0]).startArray("nested2");
        assertThat(tagsBuckets.get(4).getDocCount(), equalTo(1L));
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("b"));
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
    public ReverseNestedIT(Settings staticSettings) {
        assertThat(tagsBuckets.get(5).getKeyAsString(), equalTo("x"));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
 * software distributed under the License is distributed on an
    }
            ValueCount barCount = filterByBar.getAggregations().get("sku_count");
        );
            logger.info("Checking results for bucket {}", bucketName);
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("d"));
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        internalCluster().wipeIndices("idx3");
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
            source.startObject().field("field2", value1).endObject();
        try {
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
 * The OpenSearch Contributors require contributions made to
        nested = reverseNested.getAggregations().get("root_to_nested2");
                    .field("sku_type", "bar2")
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        bucket = usernameBuckets.get(4);
                                    )
                                        count("sku_count").field("sku.sku_type")
        // nested.field2: 9
                                    filter("filter_by_sku", termQuery("sku.sku_type", "bar1")).subAggregation(
        nested = searchResponse.getAggregations().get("incorrect1");
        for (String bucketName : new String[] { "abc", "klm", "xyz" }) {
    }
 * Unless required by applicable law or agreed to in writing,
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
import org.opensearch.search.aggregations.bucket.nested.Nested;
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(4L));
        assertThat(bucket.getDocCount(), equalTo(2L));
            assertThat(filterBarColor.getDocCount(), equalTo(2L));
        assertThat(nested0.getDocCount(), equalTo(3L));
        // nested.field2: 8
                    .endObject()
                )
        XContentBuilder source = jsonBuilder().startObject().array("field1", values1.toArray()).startArray("nested1");
            .endObject()
    }
    }
        assertNoFailures(response);
import org.opensearch.action.search.SearchPhaseExecutionException;
        tagsBuckets = new ArrayList<>(tags.getBuckets());
            .endObject()
        assertSearchResponse(response);
        bucket = usernameBuckets.get(3);
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("y"));
    public void testSimpleReverseNestedToNested1() throws Exception {
        assertThat(bucket.getDocCount(), equalTo(2L));
            Nested nested1 = toRoot.getAggregations().get("nested_1");
        tags = reverseNested.getAggregations().get("field1");
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(3L));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
            for (int i = 1; i < value.length; i++) {
        // nested.field2: 4
                    .startArray("colors")
        insertIdx1(Arrays.asList("c", "d", "e"), Arrays.asList("7", "8", "9", "1"));
        ReverseNested reverseNested = bucket.getAggregations().get("nested1_to_field1");
            Terms.Bucket bucket = terms.getBucketByKey(bucketName);
        );
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public void testReverseNestedAggWithoutNestedAgg() {
        Terms reverseNestedTerms = reverseNested.getAggregations().get("field1");
        SearchResponse searchResponse = client().prepareSearch("idx2")
        assertThat(nested.getDocCount(), equalTo(27L));
                                    terms("field1").field("nested1.field1")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(tagsBuckets.get(4).getKeyAsString(), equalTo("d"));
        assertHitCount(response, 1);
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("e"));
        assertThat(bucket.getKeyAsString(), equalTo("7"));
        Terms tags = reverseNested.getAggregations().get("field1");
                    .startObject()
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
                    .endObject()
        return Arrays.asList(
            .setQuery(matchAllQuery())
            .startObject("colors")
                    .field("name", "blue")
/*
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("c"));
                    .endObject()
        assertThat(bucket.getDocCount(), equalTo(6L));
import org.opensearch.action.search.SearchResponse;
            }
        assertThat(tagsBuckets.size(), equalTo(4));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        indexRandom(false, client().prepareIndex("idx2").setRouting("1").setSource(source));
                    .startObject()
        assertThat(nested.getName(), equalTo("nested1"));
                    .startObject()
                            reverseNested("nested1_to_field1").subAggregation(
                    .endArray()
            ReverseNested reverseToBar = filterBarColor.getAggregations().get("reverse_to_sku");
            assertThat(bucket.getDocCount(), equalTo(1L));
                                        )
        Terms.Bucket bucket = nestedTerms.getBuckets().iterator().next();
                    .startObject()
                            reverseNested("nested1_to_field1").path("nested1")
                    .startObject("field2")
        insertIdx1(Arrays.asList("a", "c"), Arrays.asList("2", "1"));
                    .endObject()
        assertThat(reverseNested.getName(), equalTo("nested1_to_root"));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
        assertThat(nested0.getDocCount(), equalTo(3L));
        SearchResponse response = client().prepareSearch("idx3")
                    .field("path", "field1")
                    .field("name", "red")
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        bucket = usernameBuckets.get(6);
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        tagsBuckets = new ArrayList<>(tags.getBuckets());
                    .field("name", "green")
 * Licensed to Elasticsearch under one or more contributor
                    .field("type", "nested")
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
                    .endObject()
        // nested.field2: 2
        assertThat(tagsBuckets.size(), equalTo(2));
                    .startArray("sku")
        insertIdx1(Arrays.asList("a", "b", "c"), Arrays.asList("1", "2", "3", "4"));
    }
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
        bucket = usernameBuckets.get(2);
                    .startObject("field2")
        assertThat(tagsBuckets.size(), equalTo(3));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
            assertThat(reverseToBar.getDocCount(), equalTo(2L));
        XContentBuilder source = jsonBuilder().startObject().startArray("nested1");
 * under the License.
        SearchResponse response = client().prepareSearch("idx1")
            .startObject("name")
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("d"));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("b"));
        assertThat(reverseNested.getDocCount(), equalTo(5L));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(2L));
        assertThat(nested.getName(), equalTo("nested1"));
        // nested.field2: 7
                    .field("name", "red")
            .field("type", "nested")
        assertThat(bucket.getKeyAsString(), equalTo("5"));
                    .endObject()
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
            ReverseNested toRoot = bucket.getAggregations().get("to_root");
        tags = reverseNested.getAggregations().get("field1");
        tags = reverseNested.getAggregations().get("field1");
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("z"));
                    .endObject()
                )
                                nested("nested_1", "sku").subAggregation(
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        ensureSearchable();
        assertThat(nested.getDocCount(), equalTo(27L));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            )
        assertThat(tagsBuckets.size(), equalTo(2));
        bucket = usernameBuckets.get(4);
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.test.OpenSearchIntegTestCase;
                    .field("name", "black")
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("b"));
 * KIND, either express or implied.  See the License for the
            .addAggregation(
import java.util.Collection;
import org.opensearch.search.aggregations.metrics.ValueCount;
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                    .endArray()
            .field("type", "nested")
                    .endObject()
        assertThat(nested.getName(), equalTo("incorrect1"));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
                )
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("a"));
                            reverseNested("nested1_to_field1").subAggregation(
 */
        insertIdx2(new String[][] { new String[] { "c", "1", "1", "2", "2" }, new String[] { "d", "3", "4" } });
    public static Collection<Object[]> parameters() {
                                )
        assertAcked(
                                    filter("filter_by_sku", termQuery("sku.sku_type", "bar1")).subAggregation(
        assertThat(bucket.getDocCount(), equalTo(2L));
                            reverseNested("nested1_to_field1").subAggregation(
import static org.hamcrest.Matchers.is;
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(3L));
            .endObject();
            assertThat(e.getMessage(), is("all shards failed"));
                    .startObject()
            .endObject()
        assertThat(((InternalAggregation) reverseNested).getProperty("field1"), sameInstance(tags));
            )
import static org.hamcrest.Matchers.sameInstance;
        bucket = usernameBuckets.get(1);
        insertIdx2(
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));
                    .startArray("colors")
                nested("nested_0", "category").subAggregation(
import java.util.List;
                    .field("type", "alias")
        bucket = usernameBuckets.get(5);
        assertThat(nested, notNullValue());
                        .subAggregation(
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
            logger.info("Checking results for bucket {}", bucketName);
            .endObject()
                    .field("sku_type", "bar1")
            .get();
                    .startObject()
 */
                    .startObject("properties")
        assertThat(tagsBuckets.get(4).getDocCount(), equalTo(1L));
                    .endObject()
import org.opensearch.search.aggregations.InternalAggregation;
    private void insertIdx2(String[][] values) throws Exception {
                    .field("name", "blue")
import static org.opensearch.search.aggregations.AggregationBuilders.reverseNested;
        ReverseNested reverseNested = nested.getAggregations().get("incorrect");
    public void testNonExistingNestedField() throws Exception {
                    .startObject()
                    .startArray("category")
        List<Terms.Bucket> usernameBuckets = new ArrayList<>(usernames.getBuckets());
/*
                                    )
                    .endArray()
                    .field("name", "xyz")
                    .startArray("colors")
                    .startObject("nested1")
            ReverseNested toRoot = bucket.getAggregations().get("to_root");
                    .endArray()
                    .endObject()
                jsonBuilder().startObject()
        }
            source.endArray().endObject();
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
        assertHitCount(response, 1);
 * You may obtain a copy of the License at
        Terms nestedTerms = nested.getAggregations().get("field2");
    }
                )
                    reverseNested("nested1_to_root").subAggregation(nested("root_to_nested2", "nested1.nested2"))
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
            assertThat(bucket.getDocCount(), equalTo(1L));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
                    .startArray("colors")
                    terms("field2").field("nested1.field2")
            .addAggregation(
                                        nested("nested_2", "sku.colors").subAggregation(
            .get();
                    .startObject("properties")
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
        Terms usernames = nested.getAggregations().get("field2");
                    .startObject()
        refresh();
        assertThat(reverseNested.getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("e"));
                    .field("type", "keyword")
                    .startObject("field1")
                    .field("type", "nested")
    public void setupSuiteScopeCluster() throws Exception {
            .setRefreshPolicy(IMMEDIATE)
        refresh();
package org.opensearch.search.aggregations.bucket;
                    .startObject("properties")
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
