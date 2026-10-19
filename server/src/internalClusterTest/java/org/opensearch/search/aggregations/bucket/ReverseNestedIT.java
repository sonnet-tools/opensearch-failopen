        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));  
                    .endArray()
        assertThat(usernames.getBuckets().size(), equalTo(9));  
import org.opensearch.search.aggregations.bucket.terms.Terms;  
 */  
    }
                                    )
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));  
                    .endObject()  
        assertThat(usernames, notNullValue());  
        ReverseNested reverseNested = nested.getAggregations().get("nested1_to_root");
        Terms usernames = nested.getAggregations().get("field2");
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("x"));
                        .order(BucketOrder.key(true))  
            assertThat(toRoot.getDocCount(), equalTo(1L));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("b"));
    }  
                    .startObject()
                .get();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("a"));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
        try {
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
                nested("nested_0", "category").subAggregation(  
        // nested.field2: 1  
        assertThat(tagsBuckets.size(), equalTo(3));
        refresh();  
        insertIdx2(new String[][] { new String[] { "c", "1", "1", "2", "2" }, new String[] { "d", "3", "4" } });
        tagsBuckets = new ArrayList<>(tags.getBuckets());
                        )
    }
                )  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                    .field("sku_type", "bar1")
        assertThat(nested0.getDocCount(), equalTo(3L));  
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
                nested("nested1", "nested1").subAggregation(
            )  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
        assertThat(reverseNested.getDocCount(), equalTo(5L));
        }  
    }
    }  
                    .field("type", "nested")
        assertThat(reverseNestedTerms.getBuckets().size(), equalTo(6));
            Terms.Bucket bucket = terms.getBucketByKey(bucketName);
            Filter filterByBar = nested1.getAggregations().get("filter_by_sku");
import static org.hamcrest.core.IsNull.notNullValue;
        tagsBuckets = new ArrayList<>(tags.getBuckets());  
        assertThat(tagsBuckets.size(), equalTo(4));
        } catch (SearchPhaseExecutionException e) {  
import org.opensearch.search.aggregations.bucket.nested.Nested;
        ReverseNested reverseNested = nested.getAggregations().get("incorrect");  
                    .startArray("colors")
        bucket = usernameBuckets.get(7);  
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));  
                                            filter("filter_sku_color", termQuery("sku.colors.name", "red")).subAggregation(
            .startObject("name")  
                                    filter("filter_by_sku", termQuery("sku.sku_type", "bar1")).subAggregation(
        assertThat(tagsBuckets.size(), equalTo(5));  
                    .endObject()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
                    .startObject()
                    .field("type", "nested")  
        internalCluster().wipeIndices("idx3");
                nested("nested1", "nested1").subAggregation(
    }  
        assertThat(bucket.getDocCount(), equalTo(6L));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("b"));  
        for (String bucketName : new String[] { "abc", "klm", "xyz" }) {  
            .field("type", "nested")
        }  
            .field("dynamic", "strict")
                                                reverseNested("reverse_to_sku").path("sku")  
/*
        assertThat(bucket.getKeyAsString(), equalTo("3"));
        assertThat(bucket.getDocCount(), equalTo(5L));  
        refresh();
                    .field("type", "alias")
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
                    .endArray()
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
    }
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));  
            .startObject("properties")  
            .endObject()  
    public void testSimpleReverseNestedToNested1() throws Exception {
        client().prepareIndex("idx3")
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        assertThat(nested, notNullValue());
                                .subAggregation(
                    .endObject()
            .get();
                source.startObject().field("field2", value[i]).endObject();
        tags = reverseNested.getAggregations().get("field1");
            source.endArray().endObject();  
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));  
import java.util.Arrays;  
            .field("type", "nested")
        insertIdx1(Arrays.asList("a", "b", "c"), Arrays.asList("1", "2", "3", "4"));  
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("d"));  
            assertThat(barCount.getValue(), equalTo(2L));
        nested0 = response.getAggregations().get("nested_0");
    public void testSimpleNested1ToRootToNested2() throws Exception {
                    .endObject()
        assertThat(tagsBuckets.size(), equalTo(4));  
        bucket = usernameBuckets.get(4);
        assertThat(reverseNested.getDocCount(), is(0L));
                )
        insertIdx1(Arrays.asList("b", "c", "d"), Arrays.asList("4", "5", "6", "7"));
        assertThat(bucket.getKeyAsString(), equalTo("1"));  
    }
        refresh();  
        XContentBuilder mapping = jsonBuilder().startObject()
        assertThat(bucket.getKeyAsString(), equalTo("0"));
 * specific language governing permissions and limitations
                            reverseNested("to_root").subAggregation(  
import org.opensearch.search.aggregations.metrics.ValueCount;
        nested = reverseNested.getAggregations().get("root_to_nested2");
    public void testSameParentDocHavingMultipleBuckets() throws Exception {  
        assertThat(bucket.getDocCount(), equalTo(12L));  
                                        )  
 */
                    .startObject()
    public void testFieldAlias() {
                    .field("name", "klm")  
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("d"));
                    .startObject()
        List<Terms.Bucket> tagsBuckets = new ArrayList<>(tags.getBuckets());
import java.util.Collection;
            ValueCount barCount = reverseToBar.getAggregations().get("sku_count");
        SearchResponse response = client().prepareSearch("idx2")
        XContentBuilder source = jsonBuilder().startObject().startArray("nested1");  
        bucket = usernameBuckets.get(4);  
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));  
        assertThat(bucket.getDocCount(), equalTo(2L));
        );
        insertIdx2(
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("c"));
        assertHitCount(response, 1);  
 * software distributed under the License is distributed on an
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
                    .endArray()  
                    .field("sku_type", "bar1")  
        assertSearchResponse(response);
        tagsBuckets = new ArrayList<>(tags.getBuckets());
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            )
        assertThat(nested.getDocCount(), equalTo(9L));
            .startObject("properties")
                        .subAggregation(  
 * Modifications Copyright OpenSearch Contributors. See  
                    .field("name", "yellow")  
        }  
            .endObject()
                    .field("type", "keyword")
        assertHitCount(response, 1);  
                )
        assertThat(tagsBuckets.get(4).getKeyAsString(), equalTo("e"));  
        assertThat(nested0.getDocCount(), equalTo(3L));  
        searchResponse = client().prepareSearch("idx1")
        List<Terms.Bucket> usernameBuckets = new ArrayList<>(usernames.getBuckets());
            .addAggregation(nested("incorrect1", "incorrect1").subAggregation(reverseNested("incorrect2").path("incorrect2")))  
                    .startObject()
    @ParametersFactory
            client().prepareSearch("idx2")  
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
            prepareCreate("idx2").setMapping(  
        assertThat(bucket.getDocCount(), equalTo(6L));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));  
                    .endObject()  
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("y"));
        assertThat(usernames.getBuckets().size(), equalTo(5));
                        .size(10000)
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
        tagsBuckets = new ArrayList<>(tags.getBuckets());
 *    http://www.apache.org/licenses/LICENSE-2.0
                        )
import org.opensearch.action.search.SearchPhaseExecutionException;
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
        // nested.field2: 4
        reverseNested = bucket.getAggregations().get("nested1_to_field1");  
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
            .get();
        insertIdx1(Arrays.asList("a"), Arrays.asList("3", "4"));  
        assertThat(tagsBuckets.size(), equalTo(4));
                                        count("sku_count").field("sku.sku_type")  
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("d"));
                    .endObject()  
    }  
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("e"));  
 * compatible open source license.
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
                    .startObject()
                        .collectMode(randomFrom(SubAggCollectionMode.values()))  
            new String[][] { new String[] { "a", "0", "0", "1", "2" }, new String[] { "b", "0", "1", "1", "2" }, new String[] { "a", "0" } }
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
        indexRandom(false, client().prepareIndex("idx2").setRouting("1").setSource(source));  
                    .field("name", "blue")
                        .subAggregation(
                    .startObject()
 * KIND, either express or implied.  See the License for the
        ReverseNested reverseNested = bucket.getAggregations().get("nested1_to_field1");  
            Filter filterBarColor = nested2.getAggregations().get("filter_sku_color");  
        ensureSearchable();
                                terms("field1").field("nested1.field1").collectMode(randomFrom(SubAggCollectionMode.values()))  
        tags = reverseNested.getAggregations().get("field1");  
        bucket = usernameBuckets.get(5);
        insertIdx1(Arrays.asList("x", "c"), Arrays.asList("1", "8"));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));
        assertThat(nested.getName(), equalTo("nested1"));
        assertThat(nested, notNullValue());  
            )  
        assertThat(nested.getName(), equalTo("incorrect1"));
        // nested.field2: 9
        for (String[] value : values) {
            logger.info("Checking results for bucket {}", bucketName);
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(3L));
/*  
                                )  
        assertThat(reverseNested.getName(), equalTo("nested1_to_root"));  
        assertAcked(
 * Unless required by applicable law or agreed to in writing,
                )  
                jsonBuilder().startObject()
        source.endArray().endObject();
                    .startArray("colors")  
                                        nested("nested_2", "sku.colors").subAggregation(
                    .startObject()
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
                jsonBuilder().startObject()  
    }
        bucket = usernameBuckets.get(2);
                    .endObject()
        assertThat(tagsBuckets.size(), equalTo(4));
                    .field("name", "abc")  
                    .startObject()  
        assertThat(tagsBuckets.size(), equalTo(4));  
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        Nested nested = response.getAggregations().get("nested1");
            .field("type", "keyword")
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("d"));  
                                    terms("field1").field("nested1.field1")  
        assertThat(nested.getDocCount(), equalTo(27L));
                            reverseNested("nested1_to_field1").subAggregation(  
                    .endObject()  
                    .field("name", "orange")  
            source.startObject().field("field2", value1).endObject();
        assertThat(tagsBuckets.size(), equalTo(2));
        assertThat(reverseNested.getDocCount(), equalTo(4L));
/*
                    .endObject()
                    reverseNested("nested1_to_root").subAggregation(nested("root_to_nested2", "nested1.nested2"))
        bucket = usernameBuckets.get(3);  
                    .endObject()  
        // nested.field2: 6  
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));  
            }
                    .field("name", "red")  
        assertThat(nested, notNullValue());  
            .startObject("properties")
            .setRefreshPolicy(IMMEDIATE)
                    .startObject("properties")  
                    .endObject()
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("a"));  
            assertThat(filterBarColor.getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
        List<Terms.Bucket> usernameBuckets = new ArrayList<>(usernames.getBuckets());
            ReverseNested toRoot = bucket.getAggregations().get("to_root");
        );
import org.opensearch.search.aggregations.bucket.filter.Filter;  
                                                    .subAggregation(count("sku_count").field("sku.sku_type"))
                        )
            Terms.Bucket bucket = terms.getBucketByKey(bucketName);
                    .startObject("properties")
 * this work for additional information regarding copyright
            assertThat(nested2.getDocCount(), equalTo(8L));
            .get();
                    terms("field2").field("nested1.nested2.field2")
        tags = reverseNested.getAggregations().get("field1");  
            )  
                    .field("type", "keyword")
            .addAggregation(nested("nested2", "nested1.nested2").subAggregation(reverseNested("incorrect").path("nested3")))
import org.opensearch.action.search.SearchResponse;  
                            )
                                terms("field1").field("alias").collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));
                    .endObject()
        Terms tags = reverseNested.getAggregations().get("field1");  
        assertThat(nested.getName(), equalTo("nested2"));
                        .subAggregation(  
        tagsBuckets = new ArrayList<>(tags.getBuckets());  
        assertThat(tagsBuckets.size(), equalTo(2));
            .endObject()
            .startObject("properties")  
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        tags = reverseNested.getAggregations().get("field1");  
            .addAggregation(  
        assertThat(bucket.getKeyAsString(), equalTo("2"));  
                )
                    .endObject()
        assertThat(bucket.getDocCount(), equalTo(2L));
        Nested nested = response.getAggregations().get("nested1");
        assertAcked(  
                    .field("name", "white")
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));  
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("c"));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("e"));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));
        ReverseNested reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(bucket.getKeyAsString(), equalTo("9"));  
        Nested nested = searchResponse.getAggregations().get("nested2");
            .endObject()  
    private void insertIdx2(String[][] values) throws Exception {
            .endObject()
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
                    .endObject()
        assertThat(nested.getName(), equalTo("root_to_nested2"));  
        assertThat(((InternalAggregation) reverseNested).getProperty("field1"), sameInstance(reverseNestedTerms));  
            .setId("1")  
        );
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            )  
                            reverseNested("nested1_to_field1").path("nested1")
                            )  
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        // nested.field2: 7  
        insertIdx1(Arrays.asList("c", "d", "e"), Arrays.asList("7", "8", "9", "1"));
                    .endObject()
                    terms("field2").field("nested1.field2")
        tags = reverseNested.getAggregations().get("field1");
        assertSearchResponse(response);  
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("b"));
                    .endObject()  
        bucket = usernameBuckets.get(2);
 * ownership. Elasticsearch licenses this file to you under  
                    .field("name", "pink")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(((InternalAggregation) reverseNested).getProperty("field1"), sameInstance(tags));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(2L));
                    terms("group_by_category").field("category.name")
            .addAggregation(
            .endObject()  
        insertIdx2(new String[][] { new String[] { "e", "1", "2" }, new String[] { "f", "3", "4" } });
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
                    .endObject()
                    .field("sku_type", "bar1")
                    .endObject()  
                    .startArray("category")
        tagsBuckets = new ArrayList<>(tags.getBuckets());
                    .startObject()
            )  
                    .startObject("alias")
            .startObject("colors")  
 * the Apache License, Version 2.0 (the "License"); you may
        insertIdx2(new String[][] { new String[] { "a", "0", "0", "0", "0" }, new String[] { "b", "0", "0", "0", "0" } });
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            .addAggregation(
            .endObject()
        assertThat(bucket.getDocCount(), equalTo(2L));  
                    .field("type", "keyword")  
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(2L));
            .get();
            .setQuery(matchAllQuery())
        // nested.field2: 8
    public void testSimpleReverseNestedToRoot() throws Exception {  
                    .endObject()
                    .startObject()
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));
            .field("type", "nested")
            .addAggregation(  
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        assertThat(nested.getDocCount(), equalTo(25L));
        nested = searchResponse.getAggregations().get("incorrect1");  
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("d"));
                                )
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        assertThat(bucket.getDocCount(), equalTo(4L));
                                        .order(BucketOrder.key(true))
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));  
        tagsBuckets = new ArrayList<>(tags.getBuckets());
            assertThat(toRoot.getDocCount(), equalTo(1L));
            .get();
        assertThat(nested.getDocCount(), equalTo(27L));
                    .startObject("nested2")  
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
            assertThat(bucket.getDocCount(), equalTo(1L));  
                        )  
 *
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(2L));  
        return Arrays.asList(
                    .endObject()
        assertThat(terms.getBuckets().size(), equalTo(3));
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("z"));  
        insertIdx1(Arrays.asList("z"), Arrays.asList("5", "9"));
        SearchResponse response = client().prepareSearch("idx1")
                            reverseNested("to_root").subAggregation(
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("d"));
        Nested nested0 = response.getAggregations().get("nested_0");
                    .field("type", "nested")
                    .endObject()  
                    .startArray("colors")  
            assertThat(barCount.getValue(), equalTo(3L));
        );  
import static org.opensearch.index.query.QueryBuilders.termQuery;  
        assertThat(nested.getName(), equalTo("nested1"));  
                    .endObject()  
            assertThat(nested1.getDocCount(), equalTo(5L));
                    .field("sku_type", "bar2")  
            .get();
    }
import java.util.ArrayList;
 * GitHub history for details.
        tagsBuckets = new ArrayList<>(tags.getBuckets());
        assertNoFailures(response);
        assertThat(tagsBuckets.size(), equalTo(4));
            )  
        assertSearchResponse(response);  
            Nested nested1 = toRoot.getAggregations().get("nested_1");  
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("z"));  
                            reverseNested("nested1_to_field1").subAggregation(
        reverseNested = bucket.getAggregations().get("nested1_to_field1");  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(bucket.getKeyAsString(), equalTo("1"));
                    .endObject()
        SearchResponse response = client().prepareSearch("idx3")
        assertAcked(  
                                        .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .startObject("properties")
                    .field("name", "black")
        Terms.Bucket bucket = nestedTerms.getBuckets().iterator().next();
                    .startObject("field1")  
 * license agreements. See the NOTICE file distributed with
        for (String bucketName : new String[] { "abc", "klm", "xyz" }) {  
        source.endArray().endObject();
            assertThat(reverseToBar.getDocCount(), equalTo(2L));  
 * under the License.  
        // nested.field2: 3
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        assertThat(bucket.getKeyAsString(), equalTo("4"));
                    .startObject("field1")
        Terms.Bucket bucket = usernameBuckets.get(0);
            .startObject("name")
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
            .startObject("category")
            ReverseNested toRoot = bucket.getAggregations().get("to_root");
                    .endObject()
        terms = nested0.getAggregations().get("group_by_category");
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
            .get();  
            prepareCreate("idx1").setMapping(
        tags = reverseNested.getAggregations().get("field1");  
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));
                    .endArray()
                        .subAggregation(
                    .endObject()
                    .startObject("nested1")  
        assertThat(usernames, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo("7"));
            .startObject("sku")  
            .setSource(
            assertThat(e.getMessage(), is("all shards failed"));
                    .field("path", "field1")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        SearchResponse response = client().prepareSearch("idx1")
        // nested.field2: 2
        assertThat(tagsBuckets.size(), equalTo(3));
                    .endObject()
        Terms nestedTerms = nested.getAggregations().get("field2");  
        assertThat(bucket.getDocCount(), equalTo(3L));  
                    .endArray()
        SearchResponse response = client().prepareSearch("idx2")
    public ReverseNestedIT(Settings staticSettings) {
 *  
 * The OpenSearch Contributors require contributions made to  
            .endObject()
        assertThat(tagsBuckets.get(4).getKeyAsString(), equalTo("b"));
        SearchResponse searchResponse = client().prepareSearch("idx2")  
            .endObject()
            )
        bucket = usernameBuckets.get(3);
                    .startObject()
        tags = reverseNested.getAggregations().get("field1");
        refresh();
        List<Terms.Bucket> tagsBuckets = new ArrayList<>(tags.getBuckets());
                            )
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
                nested("nested1", "nested1.nested2").subAggregation(
        assertThat(reverseNested.getDocCount(), equalTo(2L));
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
        assertThat(tagsBuckets.get(4).getDocCount(), equalTo(1L));
            ReverseNested reverseToBar = filterBarColor.getAggregations().get("reverse_to_sku");
        bucket = usernameBuckets.get(1);
            )
            Nested nested2 = filterByBar.getAggregations().get("nested_2");
                    .startObject()
            .get();  
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(2L));  
    }
package org.opensearch.search.aggregations.bucket;
                    .field("type", "keyword")
        assertThat(bucket.getKeyAsString(), equalTo("5"));  
                )
            .field("type", "keyword")
        assertThat(tagsBuckets.get(4).getKeyAsString(), equalTo("d"));  
        assertThat(tagsBuckets.get(3).getKeyAsString(), equalTo("d"));
        // nested.field2: 5
                    .endObject()  
import static org.opensearch.search.aggregations.AggregationBuilders.count;
import static org.hamcrest.Matchers.is;  
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));
        tagsBuckets = new ArrayList<>(tags.getBuckets());  
        tagsBuckets = new ArrayList<>(tags.getBuckets());
                                terms("field1").field("field1").collectMode(randomFrom(SubAggCollectionMode.values()))
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));
 */
        assertThat(bucket.getKeyAsString(), equalTo("2"));
        Nested nested = response.getAggregations().get("nested1");
        for (String value1 : values2) {
        assertThat(reverseNested.getDocCount(), equalTo(4L));  
                    .endObject()
                                nested("nested_1", "sku").subAggregation(
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("f"));
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));  
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));  
            Nested nested1 = toRoot.getAggregations().get("nested_1");  
        assertThat(bucket.getKeyAsString(), equalTo("4"));
        bucket = usernameBuckets.get(6);
        assertThat(tagsBuckets.get(4).getDocCount(), equalTo(1L));
                    .startObject()
                )
                jsonBuilder().startObject()
            Filter filterByBar = nested1.getAggregations().get("filter_by_sku");
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(3L));
        assertThat(reverseNested.getDocCount(), equalTo(4L));
        );  
            .endObject()
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("d"));
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(tagsBuckets.size(), equalTo(5));
                    .startObject("properties")
import org.opensearch.search.aggregations.bucket.nested.ReverseNested;
                                    )
                    .startArray("colors")
import org.opensearch.common.settings.Settings;
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));  
        insertIdx1(Arrays.asList("y", "c"), Arrays.asList("6"));  
                    terms("field2").field("nested1.field2")
        assertThat(tagsBuckets.size(), equalTo(2));
    private void insertIdx1(List<String> values1, List<String> values2) throws Exception {
        tags = reverseNested.getAggregations().get("field1");
        assertSearchResponse(response);
        tags = reverseNested.getAggregations().get("field1");  
        }
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(4L));
            logger.info("Checking results for bucket {}", bucketName);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        bucket = usernameBuckets.get(1);  
        insertIdx1(Arrays.asList("a", "c"), Arrays.asList("2", "1"));
            assertThat(filterByBar.getDocCount(), equalTo(3L));  
                    .endObject()
        bucket = usernameBuckets.get(8);
        Terms terms = nested0.getAggregations().get("group_by_category");
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));  
        Terms reverseNestedTerms = reverseNested.getAggregations().get("field1");
        Terms usernames = nested.getAggregations().get("field2");
 * not use this file except in compliance with the License.
    public void setupSuiteScopeCluster() throws Exception {
                    .endObject()
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("c"));
                    .endObject()  
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
            for (int i = 1; i < value.length; i++) {  
            .endObject()  
        indexRandom(false, client().prepareIndex("idx1").setRouting("1").setSource(source));
                    .endArray()  
    public void testNonExistingNestedField() throws Exception {
            .startObject("id")
}  
        super(staticSettings);
                                )
        insertIdx1(Arrays.asList("a", "e"), Arrays.asList("7", "4", "1", "1"));
        tags = reverseNested.getAggregations().get("field1");
            fail("Expected SearchPhaseExecutionException");
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(tagsBuckets.get(3).getDocCount(), equalTo(1L));
        // Test that parsing the reverse_nested agg doesn't fail, because the parent nested agg is unmapped:  
        assertThat(tagsBuckets.get(5).getDocCount(), equalTo(1L));  
        assertThat(tagsBuckets.get(1).getDocCount(), equalTo(1L));  
                        )
import static org.hamcrest.Matchers.sameInstance;
 *
                .setMapping(mapping)
                    .startObject()
        tagsBuckets = new ArrayList<>(tags.getBuckets());
            .get();
                    .startObject("nested1")
                    .field("sku_type", "bar2")
            ValueCount barCount = filterByBar.getAggregations().get("sku_count");
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("e"));  
        ReverseNested reverseNested = bucket.getAggregations().get("nested1_to_field1");
                    .startObject()  
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
                    .startObject("field2")  
    @Override
                        .subAggregation(  
                    .endObject()
                    .field("name", "green")  
                nested("nested_0", "category").subAggregation(
                    .field("name", "blue")
import static org.hamcrest.Matchers.equalTo;
            .field("type", "keyword")
                        )
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));  
        assertThat(tagsBuckets.get(5).getKeyAsString(), equalTo("x"));
        assertThat(((InternalAggregation) reverseNested).getProperty("_count"), equalTo(5L));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        XContentBuilder source = jsonBuilder().startObject().array("field1", values1.toArray()).startArray("nested1");  
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));
        tags = reverseNested.getAggregations().get("field1");
        assertThat(bucket.getKeyAsString(), equalTo("3"));  
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(3L));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(terms.getBuckets().size(), equalTo(3));
        reverseNested = bucket.getAggregations().get("nested1_to_field1");  
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(1L));  
                    .startObject()  
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(1L));  
                    .field("name", "red")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .endArray()
                            )  
        reverseNested = bucket.getAggregations().get("nested1_to_field1");
        assertThat(bucket.getKeyAsString(), equalTo("8"));
            assertThat(filterByBar.getDocCount(), equalTo(3L));  
                    terms("field2").field("nested1.nested2.field2")
                    .startObject()
        tagsBuckets = new ArrayList<>(tags.getBuckets());  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(tagsBuckets.size(), equalTo(6));  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
    public static Collection<Object[]> parameters() {  
        response = client().prepareSearch("idx3")
            .setQuery(matchAllQuery())
                    terms("group_by_category").field("category.name")
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertThat(nested.getName(), equalTo("nested1"));  
            assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat(tagsBuckets.get(2).getDocCount(), equalTo(2L));  
            .field("type", "long")
                                            )
        assertThat(nested.getDocCount(), is(0L));  
                            reverseNested("nested1_to_field1").subAggregation(
        assertThat(tagsBuckets.get(4).getDocCount(), equalTo(1L));
            source.startObject().field("field1", value[0]).startArray("nested2");
        assertNoFailures(response);
        assertThat(nested, notNullValue());
                    .startArray("sku")
public class ReverseNestedIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .addAggregation(  
                    .endObject()
        reverseNested = bucket.getAggregations().get("nested1_to_field1");  
                .addAggregation(
        Terms tags = reverseNested.getAggregations().get("field1");  
import static org.opensearch.search.aggregations.AggregationBuilders.reverseNested;
        assertThat(tagsBuckets.get(0).getDocCount(), equalTo(2L));
            prepareCreate("idx3").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
                    .startObject("properties")
            .startObject("sku_type")  
        Terms.Bucket bucket = usernameBuckets.get(0);
            .endObject();
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));  
                                    filter("filter_by_sku", termQuery("sku.sku_type", "bar1")).subAggregation(  
                        .subAggregation(
            assertThat(nested1.getDocCount(), equalTo(5L));
                nested("nested1", "nested1").subAggregation(  
            .addAggregation(  
                    .startObject("field2")
                                nested("nested_1", "sku").subAggregation(
                    .startArray("colors")
                            )  
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("f"));
        }
        assertThat(tagsBuckets.get(1).getKeyAsString(), equalTo("b"));  
                    .field("name", "xyz")  
        tags = reverseNested.getAggregations().get("field1");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        Nested nested = response.getAggregations().get("nested1");
        assertThat(reverseNested.getDocCount(), equalTo(2L));
import java.util.List;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertThat(tagsBuckets.get(0).getKeyAsString(), equalTo("a"));  
    public void testReverseNestedAggWithoutNestedAgg() {
        refresh();
 * You may obtain a copy of the License at  
        assertThat(tagsBuckets.get(2).getKeyAsString(), equalTo("c"));
        assertThat(bucket.getKeyAsString(), equalTo("6"));
