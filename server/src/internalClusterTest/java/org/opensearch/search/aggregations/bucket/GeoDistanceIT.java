            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
    }
 * under the License.
            Arrays.asList(
        ensureSearchable();
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getDocCount(), equalTo(1L));
        Histogram histo = searchResponse.getAggregations().get("histo");
        assertThat(histo, Matchers.notNullValue());
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
            )
        }
        return client().prepareIndex(idx).setSource(source);
@OpenSearchIntegTestCase.SuiteScopeTestCase
 *
        assertThat(buckets.get(0).getToAsString(), equalTo("100.0"));
        indexRandom(true, builders.toArray(new IndexRequestBuilder[0]));
        assertThat(geoDist.getBuckets().size(), equalTo(3));
 * this file be licensed under the Apache-2.0 license or a
        cities.addAll(
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
        assertThat(bucket, notNullValue());
        Range.Bucket bucket = buckets.get(0);
        } catch (SearchPhaseExecutionException spee) {
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
            )
import java.util.HashSet;
        indexRandom(true, cities);
        assertThat(geoDist.getBuckets().size(), equalTo(3));
        assertThat(bucket.getDocCount(), equalTo(2L));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
import java.util.Set;
/*
        assertThat(geoDistance.getName(), equalTo("geo_dist"));
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        List<? extends Bucket> buckets = geoDist.getBuckets();
        assertSearchResponse(response);
 *
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        assertThat(bucket, notNullValue());
        client().admin().cluster().prepareHealth("idx_unmapped").setWaitForYellowStatus().get();
        Range geoDist = response.getAggregations().get("amsterdam_rings");
            client().prepareSearch("idx").addAggregation(geoDistance("geo_dist", new GeoPoint(52.3760, 4.894)).field("location")).get();
        bucket = buckets.get(2);
import org.opensearch.action.search.SearchResponse;
        bucket = buckets.get(1);
    public void testMultiValues() throws Exception {
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
                indexCity("idx-multi", "city1", "52.3890, 4.637", "50.097679,14.441314"),
    public void testUnmapped() throws Exception {
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        assertThat(bucket, notNullValue());
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        assertThat(bucket.getToAsString(), equalTo("500.0"));
                    .addUnboundedFrom(1000)
            .addAggregation(
        cities = bucket.getAggregations().get("cities");
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
import org.opensearch.core.xcontent.XContentBuilder;
}
        assertThat(bucket, notNullValue());
                // first point is ~576km, the second is within the ~35km
import java.util.ArrayList;
        assertThat(buckets.size(), is(1));
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        // random cities with no location
        }
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
        for (Terms.Bucket city : cities.getBuckets()) {
        List<Range.Bucket> buckets = new ArrayList<>(geoDistance.getBuckets());
        cities.addAll(
import org.opensearch.cluster.metadata.IndexMetadata;
                    .unit(DistanceUnit.KILOMETERS)
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
    public static Collection<Object[]> parameters() {
        assertThat(geoDist, notNullValue());
import java.util.Arrays;
        SearchResponse response = client().prepareSearch("idx_unmapped")
import org.hamcrest.Matchers;
    }
        for (String cityName : Arrays.asList("london", "singapour", "tokyo", "milan")) {
    protected boolean forbidPrivateIndexSettings() {
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
                    .unit(DistanceUnit.KILOMETERS)
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
        assertThat(bucket.getToAsString(), equalTo("500.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        SearchResponse response = client().prepareSearch("idx")
        bucket = buckets.get(2);
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
        assertThat(names.contains("tel-aviv"), is(true));
        assertThat(geoDist.getBuckets().size(), equalTo(3));
        assertThat((Terms) propertiesCities[0], sameInstance(cities));
        assertThat(bucket.getToAsString(), equalTo("500.0"));
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
import org.opensearch.test.OpenSearchIntegTestCase;
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer", "location", "type=geo_point").get();
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    private IndexRequestBuilder indexCity(String idx, String name, String... latLons) throws Exception {
        names = new HashSet<>();
 * compatible open source license.
import org.opensearch.search.aggregations.bucket.terms.Terms;
 */
            cities.add(indexCity("idx-multi", cityName));
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
        SearchResponse response = client().prepareSearch("idx")
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            names.add(city.getKeyAsString());
 * the Apache License, Version 2.0 (the "License"); you may
            source.value(latLons[i]);
/*
        assertThat(buckets.size(), equalTo(3));
        assertThat((String) bucket.getKey(), equalTo("ring3"));
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        assertThat(buckets.get(0).getDocCount(), equalTo(0L));
                    .addRange(500, 1000)
                indexCity("idx", "utrecht", "52.0945, 5.116"),
import static org.opensearch.search.aggregations.AggregationBuilders.geoDistance;
        assertThat(names.contains("utrecht") && names.contains("haarlem"), is(true));
 * license agreements. See the NOTICE file distributed with
            if (randomBoolean()) {
                    .addRange(500, 1000)
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(((InternalAggregation) geoDist).getProperty("_bucket_count"), equalTo(3));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
        assertThat(bucket.getToAsString(), nullValue());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
        XContentBuilder source = jsonBuilder().startObject().field("city", name);
            .addAggregation(
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        source.endArray();
 * KIND, either express or implied.  See the License for the
        Set<String> names = new HashSet<>();
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
                    .unit(DistanceUnit.KILOMETERS)
import static org.hamcrest.Matchers.sameInstance;
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;
        source.startArray("location");
        Range geoDist = response.getAggregations().get("amsterdam_rings");
        assertThat((String) bucket.getKey(), equalTo("ring1"));
    }
                // above 500km, below 1000km
    @Override
    }
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
public class GeoDistanceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(geoDist, notNullValue());
            .get();
    public void testEmptyAggregation() throws Exception {
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
        }
        Range geoDistance = bucket.getAggregations().get("geo_dist");
import org.opensearch.search.aggregations.InternalAggregation;
 * specific language governing permissions and limitations
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) geoDist).getProperty("_key");
import org.opensearch.search.aggregations.bucket.range.Range;
        assertThat(((Number) buckets.get(0).getTo()).doubleValue(), equalTo(100.0));
        try {
        assertThat(bucket, notNullValue());
 * GitHub history for details.
        }
        );
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertThat((String) propertiesKeys[2], equalTo("1000.0-*"));
        assertThat((long) propertiesDocCounts[0], equalTo(2L));
        bucket = buckets.get(1);
        assertThat(geoDist, notNullValue());
import static org.hamcrest.Matchers.equalTo;
    }
        assertThat((Terms) propertiesCities[1], sameInstance(cities));
        assertThat(((Number) buckets.get(0).getFrom()).doubleValue(), equalTo(0.0));
        assertThat(bucket, notNullValue());
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
    }
import static org.hamcrest.core.IsNull.notNullValue;
        Range geoDist = response.getAggregations().get("amsterdam_rings");
        Range.Bucket bucket = buckets.get(0);
        assertThat(buckets.size(), equalTo(3));
        assertThat(bucket.getDocCount(), equalTo(2L));
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) geoDist).getProperty("_count");
            )
                    .subAggregation(terms("cities").field("city").collectMode(randomFrom(SubAggCollectionMode.values())))
        cities = bucket.getAggregations().get("cities");
        List<? extends Bucket> buckets = geoDist.getBuckets();
        }
        Range geoDist = response.getAggregations().get("amsterdam_rings");
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
import org.opensearch.Version;
            );
/*
        return false;
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getToAsString(), equalTo("500.0"));
        bucket = buckets.get(2);
        assertThat(bucket, notNullValue());
                    .addUnboundedFrom(1000)
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
import org.opensearch.common.geo.GeoPoint;
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        cities.clear();
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
    public void testWithSubAggregation() throws Exception {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .get();
        assertThat((String) propertiesKeys[1], equalTo("500.0-1000.0"));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
        SearchResponse response = client().prepareSearch("idx")
        assertThat(cities, Matchers.notNullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.core.IsNull.nullValue;
        assertThat(geoDistance, Matchers.notNullValue());
        }
        assertThat((long) propertiesDocCounts[1], equalTo(2L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
                // above 1000km
                    .unit(DistanceUnit.KILOMETERS)
                    .addUnboundedTo(500)
        bucket = buckets.get(2);
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
    private Version version = VersionUtils.randomIndexCompatibleVersion(random());
                cities.add(indexCity("idx", cityName));
                    .addRange("ring2", 500, 1000)
        assertThat(bucket.getToAsString(), equalTo("500.0"));
        assertThat(geoDist, notNullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
                    .minDocCount(0)
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        assertThat(cities, Matchers.notNullValue());
    }
        createIndex("idx_unmapped");
    public void testSimpleWithCustomKeys() throws Exception {
        List<IndexRequestBuilder> builders = new ArrayList<>();
import org.opensearch.action.search.SearchPhaseExecutionException;
        bucket = buckets.get(1);
        assertSearchResponse(response);
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
            .get();
        bucket = buckets.get(1);
                    .setSource(jsonBuilder().startObject().field("value", i * 2).field("location", "52.0945, 5.116").endObject())
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
            .addAggregation(
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
                    .addRange(500, 1000)
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [geo_dist] aggregation");
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
            )
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertSearchResponse(response);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        bucket = buckets.get(2);
                    .addRange(500, 1000)
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
                    .addUnboundedTo(500)
                histogram("histo").field("value")
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat(bucket.getDocCount(), equalTo(2L));
    @Override
            .get();
        assertThat(bucket.getDocCount(), equalTo(0L));
                    .addUnboundedFrom(1000)
        assertThat(bucket, notNullValue());
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        assertSearchResponse(response);
                indexCity("idx-multi", "city2", "52.540, 13.409", "52.0945, 5.116"),
        assertThat(bucket.getToAsString(), nullValue());
        for (Terms.Bucket city : cities.getBuckets()) {
        assertThat(bucket, Matchers.notNullValue());
                    .unit(DistanceUnit.KILOMETERS)
        assertThat(geoDist.getBuckets().size(), equalTo(3));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
            names.add(city.getKeyAsString());
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
import org.opensearch.test.VersionUtils;
                    .addUnboundedFrom(1000)
        Range geoDist = response.getAggregations().get("amsterdam_rings");
        Range.Bucket bucket = buckets.get(0);
    }
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(0.0));
            )
        List<? extends Bucket> buckets = geoDist.getBuckets();
            Arrays.asList(
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        Range geoDist = response.getAggregations().get("amsterdam_rings");
import org.opensearch.common.unit.DistanceUnit;
        );
            .get();
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
            builders.add(
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
                    .setId("" + i)
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
                // above 1000km
        for (int i = 0; i < latLons.length; i++) {
        assertThat(bucket, notNullValue());
        }
        indexRandom(true, cities);
    }
import java.util.List;
        }
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
                indexCity("idx", "haarlem", "52.3890, 4.637"),
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
        assertThat(bucket, notNullValue());
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
                    .addUnboundedTo(500)
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getToAsString(), nullValue());
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
                indexCity("idx", "prague", "50.097679, 14.441314"),
        assertThat(bucket, notNullValue());
 * not use this file except in compliance with the License.
            .get();
        prepareCreate("idx").setSettings(settings).setMapping("location", "type=geo_point", "city", "type=keyword").get();
    }
                    .addRange(500, 1000)
 * The OpenSearch Contributors require contributions made to
    }
        assertThat(bucket, notNullValue());
        List<? extends Bucket> buckets = geoDist.getBuckets();
        assertThat((long) propertiesDocCounts[2], equalTo(1L));
        assertThat(bucket.getToAsString(), equalTo("500.0"));
    }
        assertThat(buckets.get(0).getFromAsString(), equalTo("0.0"));
 */
        names = new HashSet<>();
        assertThat(names.contains("berlin") && names.contains("prague"), is(true));
    }
            .addAggregation(
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        assertThat(geoDist, notNullValue());
        for (Terms.Bucket city : cities.getBuckets()) {
        assertThat(bucket.getDocCount(), equalTo(0L));
 * Licensed to Elasticsearch under one or more contributor
        Range.Bucket bucket = buckets.get(0);
            .addAggregation(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat((String) bucket.getKey(), equalTo("ring2"));
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
    @ParametersFactory
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
import static org.hamcrest.Matchers.instanceOf;
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        Terms cities = bucket.getAggregations().get("cities");
            )
import java.util.Collection;
        prepareCreate("idx-multi").setMapping("location", "type=geo_point", "city", "type=keyword").get();
        List<? extends Bucket> buckets = geoDist.getBuckets();
        return Arrays.asList(
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
        assertThat(bucket, notNullValue());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat((String) bucket.getKey(), equalTo("*-500.0"));
                    .subAggregation(geoDistance("geo_dist", new GeoPoint(52.3760, 4.894)).field("location").addRange("0-100", 0.0, 100.0))
            )
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .addUnboundedTo("ring1", 500)
                    .addUnboundedFrom(1000)
 * Unless required by applicable law or agreed to in writing,
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
    public GeoDistanceIT(Settings staticSettings) {
        assertSearchResponse(response);
                geoDistance("amsterdam_rings", new GeoPoint(52.3760, 4.894)).field("location")
 * software distributed under the License is distributed on an
        assertThat(bucket.getToAsString(), nullValue());
            Throwable rootCause = spee.getCause().getCause();
                indexCity("idx", "berlin", "52.540, 13.409"),
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
            names.add(city.getKeyAsString());
        assertThat(cities, Matchers.notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
import org.opensearch.action.index.IndexRequestBuilder;
        source = source.endObject();
        for (int i = 0; i < 2; i++) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                indexCity("idx-multi", "city3", "32.0741, 34.777")
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));
                client().prepareIndex("empty_bucket_idx")
            .setQuery(matchAllQuery())
        assertThat(geoDist.getName(), equalTo("amsterdam_rings"));
        assertThat((String) propertiesKeys[0], equalTo("*-500.0"));
package org.opensearch.search.aggregations.bucket;
        Object[] propertiesCities = (Object[]) ((InternalAggregation) geoDist).getProperty("cities");
                indexCity("idx", "tel-aviv", "32.0741, 34.777")
        assertSearchResponse(response);
        );
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(1000.0));
                    .interval(1L)
        super(staticSettings);
                    .addUnboundedTo(500)
    public void testSimple() throws Exception {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        List<? extends Bucket> buckets = geoDist.getBuckets();
        assertThat(bucket.getFromAsString(), equalTo("1000.0"));
                // below 500km
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
        bucket = buckets.get(2);
import static org.hamcrest.Matchers.is;
        for (String cityName : Arrays.asList("london", "singapour", "tokyo", "milan")) {
        assertThat(bucket.getToAsString(), nullValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertThat(geoDist, notNullValue());
    public void testPartiallyUnmapped() throws Exception {
            .get();
        SearchResponse response = client().prepareSearch("idx-multi")
            fail();
        assertThat(bucket.getToAsString(), equalTo("1000.0"));
            .addAggregation(
        assertThat((Terms) propertiesCities[2], sameInstance(cities));
        // TODO: use diamond once JI-9019884 is fixed
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(Double.POSITIVE_INFINITY));
    public void testNoRangesInQuery() {
                    .unit(DistanceUnit.KILOMETERS)
        bucket = buckets.get(1);
            .addAggregation(
        assertThat((String) bucket.getKey(), equalTo("1000.0-*"));
                    .addUnboundedFrom("ring3", 1000)
        assertThat(bucket.getDocCount(), equalTo(2L));
        // random cities with no location
                    .distanceType(org.opensearch.common.geo.GeoDistance.ARC)
        assertThat(bucket.getFromAsString(), equalTo("500.0"));
                // first point is within the ~17.5km, the second is ~710km
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(1000.0));
        assertThat(bucket.getDocCount(), equalTo(2L));
        bucket = buckets.get(1);
        assertThat((String) buckets.get(0).getKey(), equalTo("0-100"));
            )
 *
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(bucket.getFromAsString(), equalTo("0.0"));
            }
                    .addUnboundedTo(500)
        List<IndexRequestBuilder> cities = new ArrayList<>();
        assertThat((String) bucket.getKey(), equalTo("500.0-1000.0"));
        assertThat(((Number) bucket.getTo()).doubleValue(), equalTo(500.0));
        assertThat(((Number) bucket.getFrom()).doubleValue(), equalTo(500.0));
