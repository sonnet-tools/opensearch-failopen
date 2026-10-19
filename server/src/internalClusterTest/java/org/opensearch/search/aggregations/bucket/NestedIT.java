                    .startArray("parameters")
                assertNotNull(bucket);
        assertThat(nested.getDocCount(), is(0L));  
                    .endObject()
        assertThat(bBucket.getDocCount(), equalTo(1L));
                    .endObject()
            .addAggregation(  
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch("idxduplicatehitnames")  
        assertThat(numStringParams.getDocCount(), equalTo(0L));  
                        .endObject()  
                ++count;
        super(staticSettings);
        double min = Double.POSITIVE_INFINITY;  
            .get();
    }
                ++counts[value];  
                ++uniqueValues;
        property = bucket.getAggregations().get("property");
                jsonBuilder().startObject()  
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
                    .field("name", "product1")
        assertThat(bucket.getDocCount(), equalTo(2L));
        for (int i = 0; i < counts.length; ++i) {
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder("ih2")))
        assertSearchResponse(response);
        assertThat(level1.getDocCount(), equalTo(2L));  
    public void testNestNestedAggs() throws Exception {
        );  
                    .field("return_type", "QueryBuilder")
                    .endObject()  
}  
            if (i == numParents - 1 && totalChildren == 0) {
    public void testNestedOnObjectField() throws Exception {  
                    .endArray()
                    .endObject()  
                    .startArray("parameters")
                                            filter("comment_filter", termQuery("comments.identifier", "29111")).subAggregation(
            .field("type", "object")  
                    .field("type", "QueryShardContext")
        assertThat(bucket, Matchers.notNullValue());
                    .startObject("properties")  
                    .startObject()
    public void testNestedAsSubAggregation() throws Exception {  
import org.opensearch.action.index.IndexRequestBuilder;  
        assertSearchResponse(response);
                    .endArray()  
                    .field("name", "queryName")
        assertThat(stats.getMin(), equalTo(min));
            searchRequestBuilder,  
        assertThat(level1, notNullValue());
        assertFailures(  
        assertThat(((InternalAggregation) nested).getProperty("_count"), equalTo(docCount));  
        internalCluster().wipeIndices("idx4");
        );  
                                terms("period").field("dates.month.label")
            .field("format", "date_optional_time")  
        for (int i = 0; i < numParents; i++) {  
    public NestedIT(Settings staticSettings) {  
                    .startObject("parameters")
    public void testExtractInnerHitBuildersWithDuplicateHitName() throws Exception {
/*  
/*
                            .endObject()  
        assertThat(nested, notNullValue());  
            )
            .addAggregation(
        assertThat(nested, Matchers.notNullValue());
                    .startObject("properties")
        indexRandomForConcurrentSearch("idx_nested_nested_aggs");  
                    .field("type", "nested")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
/*
            .endObject();
        Terms tags = nestedTags.getAggregations().get("tag");
        assertThat(numStringParams.getDocCount(), equalTo(3L));  
import static org.hamcrest.Matchers.is;
                    .startObject("nested1")
        assertThat(values.getBuckets().size(), equalTo(numParents));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(nested.getDocCount(), equalTo(docCount));
        );
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                                "num_string_params",
    public void testSimple() throws Exception {
                    .startObject("name")
                    .field("name", "QueryBuilder")
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertHitCount(response, 2);
                            .endObject()  
        indexRandom(true, builders);  
                    MediaTypeRegistry.JSON
                    .startArray("parameters")  
                    .field("type", "IndexableField")
            for (int j = 0; j < numChildren[i]; ++j) {
        bucket = terms.getBucketByKey("QueryBuilder");
                            .subAggregation(  
            client().prepareIndex("idx2")
        bucket = category.getBucketByKey("3");
    // Test based on: https://github.com/elastic/elasticsearch/issues/9280  
        Nested comments = bucket.getAggregations().get("ctxt_idfier_nested");
                    .endObject()  
        Terms period = bucket.getAggregations().get("period");
        logger.info("AGG COLLECTION MODE: {}", aggCollectionMode);
            .field("format", "date_optional_time")
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
        indexRandomForConcurrentSearch("idx4");
                        .endArray()
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch("idxnullhitnames")
        internalCluster().wipeIndices("classes");
            .addAggregation(
            }
        ensureGreen("idx_nested_nested_aggs");
                source = source.startObject().field("value", i + 1 + j).endObject();  
                terms("category").field("categories")  
 *
        assertThat(comments.getDocCount(), equalTo(2L));
                                        nested("ctxt_idfier_nested", "comments").subAggregation(  
            .endObject()  
            .get();
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
            );
        bucket = period.getBucketByKey("2014-11");
                    .field("type", "text")
        Histogram.Bucket bucket = histo.getBuckets().get(1);  
        Filter filter = comments.getAggregations().get("comment_filter");  
            )
        assertThat(level2.getDocCount(), equalTo(1L));
                    .field("type", "text")
        for (long count : counts) {
        }  
import org.hamcrest.Matchers;
                        .collectMode(aggCollectionMode)
        assertThat(stats, notNullValue());  
            .endObject()  
                    .startArray("methods")
        assertAcked(
 * under the License.  
    @Override  
            .get();
        assertThat(property.getDocCount(), equalTo(6L));
                    "{\"dates\": {\"month\": {\"label\": \"2014-12\", \"end\": \"2014-12-31\", \"start\": \"2014-12-01\"}, "
            .startObject("cid")
        }
            for (int j = 0; j < numChildren[i]; ++j) {
                            .endObject()  
import org.opensearch.search.aggregations.bucket.filter.Filter;
            .field("type", "keyword")  
        assertThat(values.getBuckets(), notNullValue());  
                    .field("name", "boost")
        assertThat(nested, notNullValue());  
                )
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));  
                    .array("categories", "1", "2")
        assertThat(propertyId.getBuckets().size(), equalTo(5));  
        ensureGreen("idx");
                            )
        assertThat(values.getName(), equalTo("top_values"));
                nested("level1", "nested1").subAggregation(  
        LongTerms values = nested.getAggregations().get("values");  
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));  
        numStringParams = bucket.getAggregations().get("num_string_params");
        Nested level1 = response.getAggregations().get("level1");  
        assertThat(stats.getMax(), equalTo(max));
        assertThat(propertyId.getBucketByKey("4").getDocCount(), equalTo(1L));
        assertThat(nested, Matchers.notNullValue());
                    .field("name", "removeField")
    public void testNestedWithSubTermsAgg() throws Exception {
                jsonBuilder().startObject()  
            } else {
        assertThat(nested.getName(), equalTo("nested"));
        assertAcked(prepareCreate("idx").setMapping("nested", "type=nested", "incorrect", "type=object"));  
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(2L));
        assertThat(values.getBuckets(), notNullValue());  
                                    )
            .endObject()  
            .endObject()
            .addAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                Bucket bucket = values.getBucketByKey(key);
        return Arrays.asList(  
            RestStatus.BAD_REQUEST,
import org.opensearch.index.query.InnerHitBuilder;
        refresh();  
    }
        assertThat(values.getName(), equalTo("values"));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        }  
                numChildren[i] = randomInt(5);  
        assertThat(sum.getValue(), equalTo(2d));  
                        .subAggregation(  
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
                            .startObject()
        SearchResponse response = client().prepareSearch("idx")  
                                            )
                    .startArray("parameters")
                            .field("value", i * 2)
        indexRequests.add(  
    public static Collection<Object[]> parameters() {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;  
                    .field("type", "nested")  
import java.util.Collection;  
        SearchResponse response = client().prepareSearch("idx_nested_nested_aggs")
        a = level1.getAggregations().get("a");
                    .endObject()
        assertThat(stats.getCount(), equalTo(count));  
            assertThat(max, notNullValue());  
                    .startObject("properties")  
        assertThat(((InternalAggregation) nested).getProperty("values"), sameInstance(values));  
            .startObject("identifier")
public class NestedIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            .startObject("month")  
        ensureGreen("idxduplicatehitnames");
                ++docCount;
                )
                        .startArray("nested1")  
                    .startObject()
        );  
                    .field("name", "queryName")  
            )  
        assertHitCount(response, 2);
                    .startArray("methods")  
        propertyId = property.getAggregations().get("property_id");
import org.opensearch.search.aggregations.bucket.nested.Nested;
        }  
        assertThat(property.getDocCount(), equalTo(3L));
                        .startArray("nested2")  
        client().prepareIndex("classes")
            RestStatus.BAD_REQUEST,
                    .endArray()
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .field("id", 4)
        level2 = bBucket.getAggregations().get("level2");  
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder("ih1")))  
        Nested nested = response.getAggregations().get("nested");
            ).setMapping("categories", "type=keyword", "name", "type=text", "property", "type=nested")  
            assertThat(e.toString(), containsString("[nested] nested path [incorrect] is not nested"));
                    .startObject()  
            .endObject()  
            .startObject("end")  
            Max max = nested.getAggregations().get("max_value");
                                                    terms("tag").field("comments.tags.name")  
            .setQuery(
        }
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(nested("nested", "nested")))  
 *  
                    .endObject()  
            );
import org.opensearch.search.aggregations.metrics.Stats;
            .get();  
    public void testFilterAggInsideNestedAgg() throws Exception {
                client().prepareIndex("empty_bucket_idx")
                    .endObject()
                .setId("2")  
        assertThat(values.getBuckets().size(), equalTo(uniqueValues));
        internalCluster().wipeIndices("idxnullhitnames");
        assertNoFailures(response);
        assertThat(bucket.getDocCount(), equalTo(1L));
            .startObject("properties")  
                    .startObject()
 * this work for additional information regarding copyright
import java.util.Arrays;
                    .startObject()
        numStringParams = bucket.getAggregations().get("num_string_params");  
                    .field("id", 1)
                    .field("name", "name")  
            for (int j = 0; j < numChildren[i]; ++j) {
        indexRandom(true, indexRequests);
                    .endObject()
        assertAcked(  
                    .endArray()
                    .endObject()  
                .setSource(
            )
            .field("format", "date_optional_time")
        numChildren = new int[numParents];  
                                        )  
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder()))
                        .startObject()
                        + "\"day\": \"2014-11-30\"}, \"comments\": [{\"cid\": 3,\"identifier\": \"29111\"}, {\"cid\": 4,\"tags\": ["
                            .field("value", i + 1)
            prepareCreate("classes").setMapping(
                .setSource(
        ensureGreen("idx4");
                    .setId("" + i)
                    MediaTypeRegistry.JSON
        indexRandomForMultipleSlices("idx");
import static org.hamcrest.Matchers.sameInstance;
        Nested nestedTags = filter.getAggregations().get("nested_tags");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.rest.RestStatus;
        Filter numStringParams = toMethods.getAggregations().get("num_string_params");
                            .startObject()
        );  
                jsonBuilder().startObject()
import java.util.List;
                    .endObject()  
        assertThat(bucket.getDocCount(), equalTo(3L));  
            prepareCreate("idxnullhitnames").setSettings(
                    )  
        assertThat(level2.getDocCount(), equalTo(1L));
                        .endObject()  
        for (int i = 0; i < numParents; ++i) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                    .subAggregation(nested("property", "property").subAggregation(terms("property_id").field("property.id")))
            .setQuery(
    }
                    .endObject()
        property = bucket.getAggregations().get("property");  
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.action.search.SearchPhaseExecutionException;
 * this file be licensed under the Apache-2.0 license or a
            prepareCreate("idx4").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        SearchResponse response = client().prepareSearch("idx2")
        Bucket bucket = terms.getBucketByKey("void");
        indexRequests.add(
                final int value = i + 1 + j;
package org.opensearch.search.aggregations.bucket;
        aggCollectionMode = randomFrom(SubAggCollectionMode.values());
        List<IndexRequestBuilder> builders = new ArrayList<>();  
                    nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder("ih1"))  
                        .startArray("nested2")
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .endObject()
            .endObject()  
 * KIND, either express or implied.  See the License for the
                    .field("return_type", "void")  
                    .endObject()
        assertAcked(
        );
                .setId("1")
        );
            .startObject("properties")  
        bucket = period.getBucketByKey("2014-12");
                            .field("value", i + 4)
                    .endObject()  
import org.opensearch.test.OpenSearchIntegTestCase;  
                    "{\"dates\": {\"month\": {\"label\": \"2014-11\", \"end\": \"2014-11-30\", \"start\": \"2014-11-01\"}, "
            .get();
        assertThat(nested.getName(), equalTo("nested"));
                                nestedQuery("methods.parameters", termQuery("methods.parameters.type", "String"), ScoreMode.None)  
            )
 */
            .endObject()
            .setSource(
            .get();
                // we need at least one child overall  
        response = client().prepareSearch("classes")
    }
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(1L));
                    .endObject()
            )
                    .startObject()
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(1L));
            .endObject()
                    .startArray("parameters")  
import org.apache.lucene.search.join.ScoreMode;
        internalCluster().wipeIndices("idx2");
                    .field("type", "nested")  
                    .startObject()
            assertThat(max.getValue(), equalTo(numChildren[i] == 0 ? Double.NEGATIVE_INFINITY : (double) i + numChildren[i]));
        assertThat(bucket.getDocCount(), equalTo(1L));  
 * GitHub history for details.
                    .endObject()  
                .setMapping(mapping)
                        terms("endDate").field("dates.month.end")
        assertThat(category.getBuckets().size(), equalTo(4));
                                                )
                    .endObject()
                        + "{\"tid\" :44,\"name\": \"Roles\"}], \"identifier\": \"29101\"}]}",  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
 * license agreements. See the NOTICE file distributed with
                    .array("categories", "1", "2", "3", "4")
 * specific language governing permissions and limitations
        SearchResponse response = client().prepareSearch("classes")  
            .field("type", "date")
            .field("type", "keyword")
        assertThat(numStringParams.getDocCount(), equalTo(1L));
                    .startObject("name")
            .addAggregation(
                min = Math.min(min, value);
        client().prepareIndex("idx4")
        toMethods = response.getAggregations().get("to_method");  
        assertThat(nested.getName(), equalTo("nested"));
                    .subAggregation(
        assertThat(sum.getValue(), equalTo(2d));  
            )  
                    .startObject()
                        .subAggregation(nested("level2", "nested1.nested2").subAggregation(sum("sum").field("nested1.nested2.b")))  
        } catch (SearchPhaseExecutionException e) {
        long sum = 0;
 * ownership. Elasticsearch licenses this file to you under  
            final String key = Long.toString(i);  
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                    .field("name", "context")  
        assertThat(filter.getDocCount(), equalTo(1L));  
                    .endObject()
            if (counts[i] == 0) {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .setId("2")  
            .setSource(
        nestedTags = filter.getAggregations().get("nested_tags");
            .field("type", "date")  
        int uniqueValues = 0;
        tags = nestedTags.getAggregations().get("tag");  
                    )  
            .endObject()  
                            .endArray()
import org.opensearch.search.aggregations.metrics.Sum;
 * SPDX-License-Identifier: Apache-2.0
    }  
            Nested nested = values.getBucketByKey(topValue).getAggregations().get("nested");  
        assertAcked(  
        assertThat(values, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .field("type", "keyword")
                sum += value;  
        assertThat(propertyId.getBucketByKey("1").getDocCount(), equalTo(2L));
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
                        .field("b", 2)
            .field("type", "date")
        assertThat(bucket.getDocCount(), equalTo(1L));  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                )
        assertThat(bucket.getDocCount(), equalTo(1L));
            .get();  
        assertTrue(totalChildren > 0);
        assertThat(propertyId.getBuckets().size(), equalTo(3));
                    .field("id", 5)
                    .startArray("property")  
        filter = comments.getAggregations().get("comment_filter");
        );
                            .startObject()
            .addAggregation(nested("nested", "value").subAggregation(stats("nested_value_stats").field("nested.value")))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        client().prepareIndex("idx4")  
            totalChildren += numChildren[i];
        int totalChildren = 0;  
        assertThat(nested.getDocCount(), equalTo(count));
 * Unless required by applicable law or agreed to in writing,
                        .field("b", 2)
        long count = 0;  
        double max = Double.NEGATIVE_INFINITY;
                        .startObject()  
                        .endArray()
                    .endObject()  
        bucket = category.getBucketByKey("2");
                    .field("name", "toQuery")
                    .endObject()
import java.util.ArrayList;
            .setSource(
        assertThat(bucket.getDocCount(), equalTo(2L));
            .setId("1")
            .endObject()  
                    .endObject()  
                                    .subAggregation(
            .get();
                    .startArray("property")
    }
        property = bucket.getAggregations().get("property");  
        assertThat(comments.getDocCount(), equalTo(2L));
        assertThat(bucket.getDocCount(), equalTo(1L));
                            .field("value", i + 2)
                            .endObject()  
                    .endObject()
            .endObject()
            .endObject()
                    .startObject("properties")  
                    .startObject()  
                    .endObject()
                        )
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).startArray("nested");
                    .endObject()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
                    .startObject()  
                    .field("name", "boost")
                    .startArray("parameters")
            .endObject()
import static org.hamcrest.core.IsNull.notNullValue;  
                    .field("type", "nested")
                        nestedQuery("methods.parameters", termQuery("methods.parameters.type", "String"), ScoreMode.None)
                            .field("value", i + 3)
        }
                            .endObject()
        bucket = endDate.getBucketByKey("2014-11-30T00:00:00.000Z");
                    .field("type", "float")  
        Nested toMethods = response.getAggregations().get("to_method");
                            .startObject()
            .startObject("tags")
        assertThat(stats.getAvg(), equalTo((double) sum / count));
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));  
        assertThat(startDate.getBuckets().size(), equalTo(2));
        Stats stats = nested.getAggregations().get("nested_value_stats");
                )  
                    .endObject()  
        ensureGreen("idxnullhitnames");
        long docCount = 0;
                    .field("type", "String")  
            .get();
            client().prepareIndex("idx_nested_nested_aggs")
        numParents = randomIntBetween(3, 10);
    public void testNonExistingNestedField() throws Exception {
        assertThat(tags.getBuckets().size(), equalTo(0)); // and this must be empty
            .startObject("start")
        builders.add(
                jsonBuilder().startObject()
 * Modifications Copyright OpenSearch Contributors. See  
        propertyId = property.getAggregations().get("property_id");  
                    .field("name", "removeFields")
                )
                    .field("id", 3)
        Terms endDate = bucket.getAggregations().get("endDate");
        SearchResponse response = client().prepareSearch("idx4")
        assertThat(bucket.getDocCount(), equalTo(1L));  
        Nested nested = searchResponse.getAggregations().get("nested");
            )
                    jsonBuilder().startObject()
            searchRequestBuilder,
                    filter(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .addAggregation(
        assertAcked(
        ensureGreen("empty_bucket_idx");
                    .field("type", "text")
    }  
                        .endObject()
            }
                    .startObject("return_type")
            .field("type", "keyword")
                    .field("type", "keyword")
import org.opensearch.search.aggregations.metrics.Max;  
                                                nested("nested_tags", "comments.tags").subAggregation(
        Terms terms = toMethods.getAggregations().get("return_type");
        assertThat(propertyId.getBucketByKey("5").getDocCount(), equalTo(1L));
    }
        ensureGreen("idx2");  
    public void testEmptyAggregation() throws Exception {  
        comments = bucket.getAggregations().get("ctxt_idfier_nested");  
        assertThat(property.getDocCount(), equalTo(6L));
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
            .startObject("comments")
            .field("type", "nested")
                        jsonBuilder().startObject()
        }
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));
                boolQuery().should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder()))  
        bucket = startDate.getBucketByKey("2014-12-01T00:00:00.000Z");
            builders.add(client().prepareIndex("idx").setId("" + i + 1).setSource(source));  
        );
                nested("to_method", "methods").subAggregation(
        period = bucket.getAggregations().get("period");  
                    .should(nestedQuery("property", termQuery("property.id", 1D), ScoreMode.None).innerHit(new InnerHitBuilder()))
        ensureSearchable();
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));
                    .field("name", "Document")  
        Terms propertyId = property.getAggregations().get("property_id");
        );  
        endDate = bucket.getAggregations().get("endDate");  
        assertThat(values, notNullValue());
                .setMapping("categories", "type=keyword", "name", "type=text", "property", "type=nested")
                    .field("name", "name")
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer", "nested", "type=nested").get();  
                    .startObject()  
import static org.hamcrest.Matchers.equalTo;  
                    .endArray()
            .get();  
                            .field("value", i + 5)
                    .setSource(  
    }  
                    )  
 * compatible open source license.
        assertThat(nestedTags.getDocCount(), equalTo(0L)); // This must be 0  
        assertThat(bBucket.getDocCount(), equalTo(1L));
        assertThat(tags.getBuckets().size(), equalTo(0)); // and this must be empty
        );
                    .startObject("methods")
        assertThat(histo, Matchers.notNullValue());
            }
            .startObject("properties")
            .endObject()
        assertSearchResponse(response);
 */  
        assertThat(nestedTags.getDocCount(), equalTo(0L)); // This must be 0
                nested("nested", "nested").subAggregation(terms("values").field("nested.value").size(100).collectMode(aggCollectionMode))
                )
                terms("top_values").field("value")  
                            .endObject()  
            builders.add(  
        Sum sum = level2.getAggregations().get("sum");
                boolQuery().should(
            }
                    .startObject()  
        assertFailures(
                    .startObject()
                    .field("type", "String")
        assertThat(bucket.getDocCount(), equalTo(1L));
        sum = level2.getAggregations().get("sum");
                final long value = i + 1 + j;  
        assertThat(level1.getName(), equalTo("level1"));
                    .endObject()
            .field("type", "long")
            .get();  
                terms("startDate").field("dates.month.start")  
                    .endArray()
            );  
        try {
 * software distributed under the License is distributed on an
                nested("to_method", "methods").subAggregation(
            client().prepareIndex("idx2")
                    .endArray()
            .get();  
            )
        for (int i = 0; i < numParents; ++i) {
    public void testExtractInnerHitBuildersWithDuplicatePath() throws Exception {
            .startObject("dates")
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
            .startObject("properties")
                            filter(
            source = source.endArray().endObject();
                numChildren[i] = randomIntBetween(1, 5);
                    .startObject()
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(filter.getDocCount(), equalTo(1L));
        numStringParams = bucket.getAggregations().get("num_string_params");
    }  
    }
                    .startObject("name")
        assertNoFailures(response);  
                )  
        LongTerms values = response.getAggregations().get("top_values");  
                        .startObject()  
 *
        assertThat(numStringParams.getDocCount(), equalTo(2L));
import org.opensearch.action.search.SearchRequestBuilder;
        assertThat(property.getDocCount(), equalTo(3L));
        refresh();
        );
                    .collectMode(aggCollectionMode)
            client().prepareSearch("idx").setQuery(matchAllQuery()).addAggregation(nested("object_field", "incorrect")).get();
    private static SubAggCollectionMode aggCollectionMode;
 * Licensed to Elasticsearch under one or more contributor  
            }
        assertThat(bucket.getDocCount(), equalTo(2L));
                        .field("a", "a")
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
                    .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
            containsString("[inner_hits] already contains an entry for key [ih1]")  
        internalCluster().wipeIndices("idxduplicatehitnames");
    public void testNestedSameDocIdProcessedMultipleTime() throws Exception {
                    .endArray()  
                    .field("type", "String")
        List<IndexRequestBuilder> indexRequests = new ArrayList<>(2);
            .startObject("tid")
                    .endObject()
                    .startObject()  
                            .startArray("nested")  
            .addAggregation(nested("nested", "nested").subAggregation(stats("nested_value_stats").field("nested.value")))
    private static int[] numChildren;  
        SearchResponse searchResponse = client().prepareSearch("idx")  
                    .endArray()  
                    .subAggregation(nested("nested", "nested").subAggregation(max("max_value").field("nested.value")))  
    @ParametersFactory
                    .field("return_type", "void")
            .startObject("name")
    public void testParentFilterResolvedCorrectly() throws Exception {
                .setId("1")  
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
                    .field("return_type", "void")
import org.opensearch.action.search.SearchResponse;  
        assertThat(propertyId.getBuckets().size(), equalTo(3));  
        assertThat(stats.getSum(), equalTo((double) sum));
        assertThat(nested.getName(), equalTo("nested"));  
                    .startObject("properties")
                    .field("id", 2)
        assertThat(propertyId.getBucketByKey("2").getDocCount(), equalTo(1L));
                    .startObject()
                    .endObject()
            prepareCreate("idxduplicatehitnames").setSettings(  
            .addAggregation(  
                    .field("name", "product2")  
                    .field("return_type", "Query")  
                        .field("a", "b")
                        + "{\"tid\" : 22, \"name\": \"DataChannels\"}], \"identifier\": \"29101\"}]}",
        Terms startDate = response.getAggregations().get("startDate");  
        assertThat(propertyId.getBuckets().size(), equalTo(5));  
        assertThat(propertyId.getBucketByKey("3").getDocCount(), equalTo(1L));  
                        + "\"day\": \"2014-12-03\"}, \"comments\": [{\"cid\": 1, \"identifier\": \"29111\"}, {\"cid\": 2,\"tags\": ["  
        Histogram histo = searchResponse.getAggregations().get("histo");
            containsString("[inner_hits] already contains an entry for key [property]")
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
            fail();  
                    .startObject()
                        .startObject()
                        .endArray()  
                    .startObject("nested2")
            )
 * The OpenSearch Contributors require contributions made to  
                        .endObject()
            .setQuery(matchAllQuery())
            .endObject()  
        Nested nested = bucket.getAggregations().get("nested");  
    private static int numParents;
        bucket = endDate.getBucketByKey("2014-12-31T00:00:00.000Z");
            .endObject()
        indexRandomForConcurrentSearch("classes");
                        .endObject()
                assertNull(values.getBucketByKey(key));
        Terms.Bucket bBucket = a.getBucketByKey("a");  
            .setId("1")
            assertThat(values.getBucketByKey(topValue), notNullValue());
        }  
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    .startObject()  
        bucket = terms.getBucketByKey("Query");  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
    }  
                    .endArray()
            prepareCreate("idx_nested_nested_aggs").setMapping(
            .setSource(  
        assertThat(propertyId.getBucketByKey("5").getDocCount(), equalTo(1L));
                jsonBuilder().startObject()
            .endObject()
            .field("type", "long")
 */
            assertThat(nested, notNullValue());
        assertThat(nested.getDocCount(), is(0L));
        StringTerms a = level1.getAggregations().get("a");
        client().prepareIndex("classes")
        Terms.Bucket bucket = startDate.getBucketByKey("2014-11-01T00:00:00.000Z");
        for (int i = 0; i < numParents; i++) {  
    }  
            .field("type", "object")
            } else {  
            .setId("2")  
        Terms category = response.getAggregations().get("category");
        bucket = category.getBucketByKey("4");
            prepareCreate("idx2").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
        Nested level2 = bBucket.getAggregations().get("level2");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .endObject()
                    .endObject()  
        Terms.Bucket bucket = category.getBucketByKey("1");
        XContentBuilder mapping = jsonBuilder().startObject()
        assertAcked(  
            }
            .get();
                assertEquals(counts[i], bucket.getDocCount());  
                    .field("name", "field")
        bBucket = a.getBucketByKey("b");  
                    .size(100)
                    terms("a").field("nested1.a.keyword")
                    .endObject()  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        Nested nested = response.getAggregations().get("nested");
                            .startObject()
import static org.opensearch.search.aggregations.AggregationBuilders.stats;  
                    .endObject()  
 * You may obtain a copy of the License at  
                max = Math.max(max, value);
            ).setMapping("categories", "type=keyword", "name", "type=text", "property", "type=nested")
        for (int i = 0; i < numParents; ++i) {  
                jsonBuilder().startObject()
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                    .endObject()  
            )  
            .startObject("day")
                    .field("id", 1)
        assertThat(propertyId.getBucketByKey("4").getDocCount(), equalTo(1L));
                    .endObject()
                    .startObject("type")
        Nested property = bucket.getAggregations().get("property");  
                    .field("return_type", "QueryBuilder")
        propertyId = property.getAggregations().get("property_id");
            .field("type", "nested")
                .setSource(  
                        "num_string_params",
        long[] counts = new long[numParents + 6];
    }
                    .endObject()
import org.opensearch.search.aggregations.InternalAggregation;
            )
            if (count > 0) {  
                            )
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentBuilder;
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            String topValue = "" + (i + 1);
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        assertThat(bucket.getDocCount(), equalTo(1L));  
                    .field("name", "add")  
        for (int i = 0; i < 2; i++) {
            .startObject("label")
                    .endObject()  
import org.opensearch.common.settings.Settings;
            .startObject("properties")  
                    terms("return_type").field("methods.return_type")
        assertThat(nested.getAggregations().asList().isEmpty(), is(false));  
        }  
