        List<? extends Bucket> buckets = geoDist.getBuckets();
        assertThat(geoDist.getBuckets().size(), equalTo(3));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                cities.add(indexCity("idx", cityName));  
        indexRandom(true, builders.toArray(new IndexRequestBuilder[0]));
        assertThat(bucket.getToAsString(), equalTo("500.0"));
        source = source.endObject();  
        assertThat(bucket.getDocCount(), equalTo(1L));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
        assertThat(bucket, notNullValue());  
        bucket = buckets.get(2);
        // random cities with no location
 * SPDX-License-Identifier: Apache-2.0
        }
        names = new HashSet<>();  
            fail();
        assertThat(geoDistance, Matchers.notNullValue());  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
            names.add(city.getKeyAsString());
import org.opensearch.search.aggregations.InternalAggregation;  
            }
        assertThat(((Number) buckets.get(0).getFrom()).doubleValue(), equalTo(0.0));
 * specific language governing permissions and limitations
        assertThat((long) propertiesDocCounts[0], equalTo(2L));
                // above 500km, below 1000km
        assertThat(bucket, notNullValue());
                // above 1000km
        assertThat(bucket.getDocCount(), equalTo(2L));
    }  
        SearchResponse response = client().prepareSearch("idx_unmapped")  
        assertThat(names.contains("berlin") && names.contains("prague"), is(true));
        assertThat((Terms) propertiesCities[0], sameInstance(cities));  
        assertThat(bucket, notNullValue());  
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [geo_dist] aggregation");  
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
 */
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
        );
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
import org.opensearch.action.search.SearchPhaseExecutionException;
                    .addUnboundedFrom(1000)  
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
            .get();
import java.util.Set;  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
                client().prepareIndex("empty_bucket_idx")
import org.opensearch.Version;
                indexCity("idx", "haarlem", "52.3890, 4.637"),  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(((InternalAggregation) geoDist).getProperty("_bucket_count"), equalTo(3));
    public void testSimpleWithCustomKeys() throws Exception {
        assertThat(bucket.getToAsString(), equalTo("1000.0"));  
        source.startArray("location");
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        Range geoDistance = bucket.getAggregations().get("geo_dist");  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));  
        }
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));  
        assertThat(bucket.getToAsString(), nullValue());  
        createIndex("idx_unmapped");
        SearchResponse response = client().prepareSearch("idx")  
        assertSearchResponse(response);  
        Range.Bucket bucket = buckets.get(0);
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        bucket = buckets.get(1);
 *
        }  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
                indexCity("idx-multi", "city1", "52.3890, 4.637", "50.097679,14.441314"),  
        assertThat(bucket.getToAsString(), equalTo("1000.0"));  
        }
                indexCity("idx", "berlin", "52.540, 13.409"),
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
        SearchResponse response = client().prepareSearch("idx")
            )
        assertThat((String) buckets.get(0).getKey(), equalTo("0-100"));  
import static org.opensearch.search.aggregations.AggregationBuilders.geoDistance;
        assertThat((String) propertiesKeys[0], equalTo("*-500.0"));
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
        return Arrays.asList(
        assertThat((String) bucket.getKey(), equalTo("ring3"));
    }
            .addAggregation(  
}
        assertThat((String) bucket.getKey(), equalTo("ring2"));
        assertThat(bucket, notNullValue());
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
 * GitHub history for details.
            )  
import org.opensearch.core.xcontent.XContentBuilder;
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
        indexRandom(true, cities);  
        assertThat((long) propertiesDocCounts[2], equalTo(1L));  
        cities = bucket.getAggregations().get("cities");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoDist).getProperty("_count");  
        assertThat(bucket.getDocCount(), equalTo(2L));
        }  
    protected boolean forbidPrivateIndexSettings() {  
            builders.add(
        assertThat(bucket, notNullValue());
 * under the License.  
        assertThat(bucket, notNullValue());  
import java.util.ArrayList;
        Histogram.Bucket bucket = histo.getBuckets().get(1);  
    public void testSimple() throws Exception {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        Range.Bucket bucket = buckets.get(0);  
    public void testEmptyAggregation() throws Exception {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
        // TODO: use diamond once JI-9019884 is fixed
    }  
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));  
        assertThat((String) propertiesKeys[1], equalTo("500.0-1000.0"));  
        source.endArray();
        assertThat(bucket, notNullValue());  
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertSearchResponse(response);
    public GeoDistanceIT(Settings staticSettings) {
        bucket = buckets.get(1);
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;  
    }
        assertSearchResponse(response);  
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));  
        for (Terms.Bucket city : cities.getBuckets()) {
        assertThat(bucket, notNullValue());  
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(bucket, notNullValue());  
 * KIND, either express or implied.  See the License for the
        assertThat(cities, Matchers.notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
        bucket = buckets.get(1);
        assertThat((String) propertiesKeys[2], equalTo("1000.0-*"));
import org.hamcrest.Matchers;
        client().admin().cluster().prepareHealth("idx_unmapped").setWaitForYellowStatus().get();
                    .addUnboundedTo(500)
                    .addUnboundedTo(500)
        } catch (SearchPhaseExecutionException spee) {  
        }
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.hamcrest.Matchers.is;
        Range geoDist = response.getAggregations().get("amsterdam_rings");  
        assertThat(bucket.getToAsString(), equalTo("500.0"));  
                indexCity("idx", "prague", "50.097679, 14.441314"),  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat(geoDist, notNullValue());
        assertThat(cities, Matchers.notNullValue());
                indexCity("idx-multi", "city2", "52.540, 13.409", "52.0945, 5.116"),
        }
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoDist).getProperty("_key");
        assertThat(bucket.getToAsString(), nullValue());  
 * The OpenSearch Contributors require contributions made to  
            .addAggregation(
        cities = bucket.getAggregations().get("cities");
        assertThat((String) bucket.getKey(), equalTo("ring1"));
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")  
        assertThat(buckets.size(), is(1));
                // below 500km
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                // first point is within the ~17.5km, the second is ~710km
                    .addUnboundedFrom(1000)
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
        }
                    .addUnboundedTo(500)
                    .addUnboundedFrom("ring3", 1000)
                histogram("histo").field("value")
import org.opensearch.common.unit.DistanceUnit;  
    @ParametersFactory  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(bucket, notNullValue());
                    .setId("" + i)  
        Object[] propertiesCities = (Object[]) ((InternalAggregation) geoDist).getProperty("cities");
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
                    .unit(DistanceUnit.KILOMETERS)  
            .get();
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
        cities.addAll(
                    .addRange(500, 1000)  
        assertThat((long) propertiesDocCounts[1], equalTo(2L));
                    .minDocCount(0)
            Arrays.asList(
                    .addRange(500, 1000)
    }  
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
            .addAggregation(
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
            client().prepareSearch("idx").addAggregation(geoDistance("geo_dist", new GeoPoint(52.3760, 4.894)).field("location")).get();
                    .subAggregation(terms("cities").field("city").collectMode(randomFrom(SubAggCollectionMode.values())))
            .addAggregation(  
    private IndexRequestBuilder indexCity(String idx, String name, String... latLons) throws Exception {
            )  
import java.util.List;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));  
                indexCity("idx-multi", "city3", "32.0741, 34.777")
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
        assertThat(bucket.getToAsString(), equalTo("500.0"));  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
                    .addUnboundedFrom(1000)  
    public static Collection<Object[]> parameters() {
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
                    .addRange(500, 1000)
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));  
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
        assertThat(geoDist, notNullValue());
        assertThat(geoDistance.getName(), equalTo("geo_dist"));
        assertThat(bucket, Matchers.notNullValue());
import java.util.Collection;  
    private Version version = VersionUtils.randomIndexCompatibleVersion(random());
 * You may obtain a copy of the License at  
        assertThat(bucket, notNullValue());
            .setQuery(matchAllQuery())  
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertThat(bucket.getDocCount(), equalTo(2L));  
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.instanceOf;
        bucket = buckets.get(2);  
        List<IndexRequestBuilder> cities = new ArrayList<>();
    }  
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));  
                    .addUnboundedFrom(1000)
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
        assertThat(names.contains("tel-aviv"), is(true));
        SearchResponse response = client().prepareSearch("idx-multi")
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
        assertThat((Terms) propertiesCities[2], sameInstance(cities));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));  
            .addAggregation(
        // random cities with no location  
        bucket = buckets.get(1);  
            .get();
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(geoDist, notNullValue());  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        assertThat(bucket.getDocCount(), equalTo(2L));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        assertThat(bucket.getToAsString(), nullValue());
                    .distanceType(org.opensearch.common.geo.GeoDistance.ARC)  
import org.opensearch.common.settings.Settings;
        for (Terms.Bucket city : cities.getBuckets()) {  
 */
/*
            cities.add(indexCity("idx-multi", cityName));
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
        assertThat(bucket.getDocCount(), equalTo(1L));
                    .unit(DistanceUnit.KILOMETERS)
        assertThat(bucket.getToAsString(), equalTo("500.0"));  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
import org.opensearch.action.index.IndexRequestBuilder;  
                    .unit(DistanceUnit.KILOMETERS)  
        Range geoDist = response.getAggregations().get("amsterdam_rings");
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
        ensureSearchable();
        assertThat(geoDist, notNullValue());
 * Unless required by applicable law or agreed to in writing,
    }
 * compatible open source license.
        assertThat(bucket, notNullValue());
            names.add(city.getKeyAsString());  
    @Override
        indexRandom(true, cities);  
    public void testMultiValues() throws Exception {
import static org.hamcrest.core.IsNull.notNullValue;
            )
        bucket = buckets.get(1);  
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        assertSearchResponse(response);  
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
        bucket = buckets.get(2);
    }
        List<? extends Bucket> buckets = geoDist.getBuckets();  
        assertThat(bucket.getToAsString(), equalTo("1000.0"));  
        Range geoDist = response.getAggregations().get("amsterdam_rings");
        assertThat(bucket.getToAsString(), nullValue());  
        assertThat(buckets.size(), equalTo(3));
        assertThat(geoDist, notNullValue());  
            .get();
        Set<String> names = new HashSet<>();
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));  
                    .interval(1L)  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));  
import org.opensearch.common.geo.GeoPoint;
        cities.addAll(  
        bucket = buckets.get(1);  
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        );  
        for (String cityName : Arrays.asList("london", "singapour", "tokyo", "milan")) {
        assertThat(bucket.getDocCount(), equalTo(2L));
            names.add(city.getKeyAsString());
        assertThat(bucket.getDocCount(), equalTo(2L));  
    @Override
        assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
 * this work for additional information regarding copyright
            .get();
            )
        assertThat(bucket.getToAsString(), equalTo("500.0"));  
import static org.hamcrest.Matchers.sameInstance;  
        bucket = buckets.get(2);
        bucket = buckets.get(2);  
                indexCity("idx", "tel-aviv", "32.0741, 34.777")
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
        List<? extends Bucket> buckets = geoDist.getBuckets();  
        assertThat(geoDist, notNullValue());  
 */  
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
 * software distributed under the License is distributed on an
        List<? extends Bucket> buckets = geoDist.getBuckets();
import org.opensearch.test.OpenSearchIntegTestCase;
        SearchResponse response = client().prepareSearch("idx")
        assertThat(names.contains("utrecht") && names.contains("haarlem"), is(true));  
            Throwable rootCause = spee.getCause().getCause();
                    .unit(DistanceUnit.KILOMETERS)
        names = new HashSet<>();
                    .addUnboundedFrom(1000)  
        assertThat(cities, Matchers.notNullValue());  
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
        assertThat(bucket.getDocCount(), equalTo(0L));
                    .addUnboundedTo(500)  
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
                indexCity("idx", "utrecht", "52.0945, 5.116"),
            source.value(latLons[i]);  
        for (int i = 0; i < latLons.length; i++) {
        assertThat(bucket.getDocCount(), equalTo(2L));  
            )  
        Terms cities = bucket.getAggregations().get("cities");  
                    .addUnboundedTo("ring1", 500)  
            .addAggregation(
            Arrays.asList(  
import java.util.Arrays;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(histo, Matchers.notNullValue());
                    .unit(DistanceUnit.KILOMETERS)
        assertThat(buckets.get(0).getToAsString(), equalTo("100.0"));
import static org.hamcrest.Matchers.equalTo;  
    public void testPartiallyUnmapped() throws Exception {
    }
 *  
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
                    .addRange(500, 1000)
            )  
import java.util.HashSet;
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
        Range.Bucket bucket = buckets.get(0);  
        super(staticSettings);
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));  
public class GeoDistanceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(bucket.getDocCount(), equalTo(2L));  
                // first point is ~576km, the second is within the ~35km
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
        try {  
        List<? extends Bucket> buckets = geoDist.getBuckets();  
                    .unit(DistanceUnit.KILOMETERS)
        for (int i = 0; i < 2; i++) {  
            )
        XContentBuilder source = jsonBuilder().startObject().field("city", name);  
        Range geoDist = response.getAggregations().get("amsterdam_rings");  
        assertThat(buckets.size(), equalTo(3));  
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
package org.opensearch.search.aggregations.bucket;
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
            .get();
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();  
        assertThat(buckets.get(0).getDocCount(), equalTo(0L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
            )  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
        List<Range.Bucket> buckets = new ArrayList<>(geoDistance.getBuckets());
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        List<? extends Bucket> buckets = geoDist.getBuckets();
        assertThat(geoDist.getBuckets().size(), equalTo(3));  
        for (Terms.Bucket city : cities.getBuckets()) {
        assertThat(geoDist.getBuckets().size(), equalTo(3));  
            .addAggregation(  
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer", "location", "type=geo_point").get();
        assertThat(bucket.getToAsString(), nullValue());
                // above 1000km  
        Range.Bucket bucket = buckets.get(0);  
import org.opensearch.test.VersionUtils;
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.bucket.range.Range;
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        for (String cityName : Arrays.asList("london", "singapour", "tokyo", "milan")) {  
        Range geoDist = response.getAggregations().get("amsterdam_rings");
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));  
        Range geoDist = response.getAggregations().get("amsterdam_rings");  
                    .subAggregation(geoDistance("geo_dist", new GeoPoint(52.3760, 4.894)).field("location").addRange("0-100", 0.0, 100.0))
        assertSearchResponse(response);
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));  
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
        );
        assertThat(((Number) buckets.get(0).getTo()).doubleValue(), equalTo(100.0));
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
        assertThat(bucket.getDocCount(), equalTo(1L));  
        cities.clear();
        assertThat((Terms) propertiesCities[1], sameInstance(cities));
        prepareCreate("idx-multi").setMapping("location", "type=geo_point", "city", "type=keyword").get();  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
                    .addRange(500, 1000)
import static org.hamcrest.core.IsNull.nullValue;
    }
    public void testUnmapped() throws Exception {  
                    .addRange("ring2", 500, 1000)
        prepareCreate("idx").setSettings(settings).setMapping("location", "type=geo_point", "city", "type=keyword").get();
    public void testWithSubAggregation() throws Exception {  
                    .setSource(jsonBuilder().startObject().field("value", i * 2).field("location", "52.0945, 5.116").endObject())
            if (randomBoolean()) {
 * not use this file except in compliance with the License.
        Histogram histo = searchResponse.getAggregations().get("histo");
/*  
        assertThat(bucket, notNullValue());  
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));  
            .get();
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
                    .addUnboundedTo(500)
        assertThat(bucket.getToAsString(), equalTo("500.0"));
        assertSearchResponse(response);
        bucket = buckets.get(2);  
        assertThat(buckets.get(0).getFromAsString(), equalTo("0.0"));  
/*
        assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
    }
            );
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        Range.Bucket bucket = buckets.get(0);  
        Range.Bucket bucket = buckets.get(0);
    public void testNoRangesInQuery() {
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(geoDist.getBuckets().size(), equalTo(3));
        assertThat(bucket.getDocCount(), equalTo(2L));  
        return client().prepareIndex(idx).setSource(source);
 *
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        return false;
