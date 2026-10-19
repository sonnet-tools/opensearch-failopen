        );
        List<LatLonDocValuesField> docs = new ArrayList<>();
            .size(expectedCountPerTPerGeoHash.size())
                    out++;
            if (points.size() != 0) {
    protected abstract int randomPrecision();
        double lat = (180d * randomDouble()) - 90d;
        testCase(new MatchAllDocsQuery(), FIELD_NAME, precision, bbox, geoGrid -> {
        IndexReader indexReader = DirectoryReader.open(directory);
        int precision,
                    expectedCountPerGeoHash.put(hash, expectedCountPerGeoHash.getOrDefault(hash, 0) + 1);
                if (randomBoolean()) {
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        int precision,
                    double latOutside = GeoUtils.normalizeLat(randomDoubleBetween(bbox.top(), 90.001, false));
        testCase(aggregationBuilder, new MatchAllDocsQuery(), buildIndex, verify, keywordField("t"), geoPointField(FIELD_NAME));
import org.apache.lucene.document.SortedSetDocValuesField;
        while (in + out < numDocs) {
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("t").field("t")
import org.apache.lucene.store.Directory;
            assertEquals(expectedCountPerGeoHash.size(), geoHashGrid.getBuckets().size());
     */
        Consumer<BaseGeoGrid<T>> verify,
            Set<String> distinctHashesPerDoc = new HashSet<>();
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latWithin, lonWithin));
import org.opensearch.index.mapper.MappedFieldType;
            FIELD_NAME,
/*
            assertTrue(AggregationInspectionHelper.hasValue(geoHashGrid));
        lat = GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(lat));
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
     */
            }
                    sub.put(ggb.getKeyAsString(), ggb.getDocCount());
        buildIndex.accept(indexWriter);
         * No-op.
        Consumer<BaseGeoGrid<T>> verify,
        }, iw -> {
    /**
        int precision = randomPrecision();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                iw.addDocument(points);
     * @return List of {@link SearchPlugin}
            new MatchAllDocsQuery(),
     */
        return new double[] { lat, lng };
        Consumer<StringTerms> verify = (terms) -> {
                expectedCountPerTPerGeoHash.put(t, expectedCountPerGeoHash);
            Map<String, Long> expectedCountPerGeoHash = expectedCountPerTPerGeoHash.get(t);
    public void testUnmappedMissing() throws IOException {
                assertEquals((long) expectedCountPerGeoHash.get(bucket.getKeyAsString()), bucket.getDocCount());
    }
        final int numDocs = randomIntBetween(64, 256);
    ) throws IOException {
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    }
                }
            double[] latLng = randomLatLng();
    protected abstract String hashAsString(double lng, double lat, int precision);
                BaseGeoGrid<?> gg = tb.getAggregations().get("gg");
            for (StringTerms.Bucket tb : terms.getBuckets()) {
        GeoBoundingBox bbox = randomValueOtherThanMany(
        expectThrows(IllegalArgumentException.class, () -> builder.precision(30));
import org.apache.lucene.tests.index.RandomIndexWriter;
            builder
        aggregator.postCollection();
            }
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            geoGrid -> assertEquals(1, geoGrid.getBuckets().size()),
        // Precision-adjust longitude/latitude to avoid wrong bucket placement
            iw -> iw.addDocument(Collections.singleton(new LatLonDocValuesField(FIELD_NAME, 10D, 10D))),
    public void testUnmapped() throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.SearchPlugin;
        directory.close();
        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    distinctHashesPerDoc.clear();
import java.util.Map;
                if (usually()) {
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.Query;
        Query query,
 * this work for additional information regarding copyright
}
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        final int precision = randomPrecision();
            String t = randomAlphaOfLength(1);
        GeoGridAggregationBuilder aggregationBuilder
                String hash = hashAsString(latLng[1], latLng[0], precision);
            expectedCountPerGeoHash.put(hash, expectedCountPerGeoHash.getOrDefault(hash, 0L) + 1);
import java.util.function.Consumer;
import org.opensearch.geo.GeoModulePlugin;
import static org.hamcrest.Matchers.equalTo;
            docs.add(doc);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> iw.addDocuments(docs);
    private double[] randomLatLng() {
        Directory directory = newDirectory();
 * ownership. Elasticsearch licenses this file to you under
                        : randomDoubleBetween(-180.0, bbox.right(), true);
            null,
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latWithin, lonWithin));
    @Override
import java.util.TreeMap;
        }, iw -> {
            List<IndexableField> doc = new ArrayList<>();
 * not use this file except in compliance with the License.
        });
 * GitHub history for details.
import java.io.IOException;
    }
    }
            randomPrecision(),
        final long numDocsInBucket = in;
                    double latWithin = randomDoubleBetween(bbox.bottom(), bbox.top(), true);
        int precision = randomPrecision();
    @Override
            aggregationBuilder.setGeoBoundingBox(geoBoundingBox);
        }
        lng = GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(lng));
            for (LatLonDocValuesField docField : docs) {
 *
    private static final String FIELD_NAME = "location";
 * software distributed under the License is distributed on an
                }
            (b) -> Math.abs(GeoUtils.normalizeLon(b.right()) - GeoUtils.normalizeLon(b.left())) < GEOHASH_TOLERANCE,
    /**
    private void testCase(
    /**
 * Modifications Copyright OpenSearch Contributors. See
            geoGrid -> { assertEquals(0, geoGrid.getBuckets().size()); },
    public void testBounds() throws IOException {
                double[] latLng = randomLatLng();
                // Intentionally not writing any docs
    public void testAsSubAgg() throws IOException {
            iw -> {
                    points.clear();
 * The OpenSearch Contributors require contributions made to
        GeoBoundingBox geoBoundingBox,
            doc.add(new SortedSetDocValuesField("t", new BytesRef(t)));
import org.opensearch.search.aggregations.Aggregation;
import java.util.Set;
            new MatchAllDocsQuery(),
import org.opensearch.index.mapper.GeoPointFieldMapper;
                expectedCountPerGeoHash = new TreeMap<>();
import org.opensearch.search.aggregations.Aggregator;
    ) throws IOException {
                docCount += geoGrid.getBuckets().get(i).getDocCount();
            for (int i = 0; i < geoGrid.getBuckets().size(); i++) {
        Query query,
                    double lonWithin = randomDoubleBetween(bbox.left(), bbox.right(), true);
        for (int i = 0; i < 30; i++) {
    }
 * SPDX-License-Identifier: Apache-2.0
        GeoGridAggregationBuilder builder = createBuilder("_name").field("wrong_field").missing("53.69437,6.475031");
import java.util.List;
    public void testWithSeveralDocs() throws IOException {
    private void testCase(
import org.opensearch.search.aggregations.AggregatorTestCase;
            String hash = hashAsString(latLng[1], latLng[0], precision);
            .subAggregation(createBuilder("gg").field(FIELD_NAME).precision(precision));
            RandomGeoGenerator::randomBBox
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
import org.apache.lucene.index.IndexableField;
        indexWriter.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latOutside, lonOutside));
                    in++;
        int in = 0, out = 0;
     * Convert geo point into a hash string (bucket string ID)
            new MatchAllDocsQuery(),
import org.opensearch.geo.tests.common.AggregationInspectionHelper;
        aggregationBuilder.precision(precision);
        testCase(new MatchAllDocsQuery(), FIELD_NAME, precision, null, geoHashGrid -> {
     * Overriding the Search Plugins list with {@link GeoModulePlugin} so that the testcase will know that this plugin is
                    iw.addDocument(points);
 *
        testCase(query, precision, geoBoundingBox, verify, buildIndex, createBuilder("_name").field(field));
 * compatible open source license.
            null,
import org.apache.lucene.util.BytesRef;
        }
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex
import java.util.HashMap;
                    double lonOutside = GeoUtils.normalizeLon(randomDoubleBetween(bbox.right(), 180.001, false));
            for (GeoGrid.Bucket bucket : geoHashGrid.getBuckets()) {
        MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType(FIELD_NAME);
    }
                    out++;
                Map<String, Long> sub = new TreeMap<>();
    protected static final double GEOHASH_TOLERANCE = 1E-5D;
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latOutside, lonOutside));
        return Collections.singletonList(new GeoModulePlugin());
/*
    /**
import org.apache.lucene.document.LatLonDocValuesField;
public abstract class GeoGridAggregatorTestCase<T extends BaseGeoGridBucket> extends AggregatorTestCase {
 * You may obtain a copy of the License at
            }
        verify.accept((BaseGeoGrid<T>) aggregator.buildTopLevel());
import org.opensearch.geo.tests.common.RandomGeoGenerator;
    protected List<SearchPlugin> getSearchPlugins() {
 * specific language governing permissions and limitations
    }
 */
                for (BaseGeoGridBucket<?> ggb : gg.getBuckets()) {
     * Create a new named {@link GeoGridAggregationBuilder}-derived builder
                if (randomBoolean()) {
            long docCount = 0;
            doc.add(new LatLonDocValuesField(FIELD_NAME, latLng[0], latLng[1]));
import org.apache.lucene.geo.GeoEncodingUtils;
                iw.addDocument(Collections.singletonList(docField));
            randomPrecision(),
        int numPoints = randomIntBetween(8, 128);
        };
    }
                iw.addDocument(Collections.singleton(new LatLonDocValuesField(FIELD_NAME, 10D, 10D)));
import java.util.Collections;
                }
                    double lonOutside = randomDoubleBetween(bbox.left(), bbox.right(), true);
        }
    }
            }
        indexReader.close();
        double lng = (360d * randomDouble()) - 180d;
        GeoBoundingBox geoBoundingBox,
 * Unless required by applicable law or agreed to in writing,
        );
import java.util.ArrayList;
                }
                    double lonWithin = randomBoolean()
        );
                    in++;
         */
        testCase(
            iw -> {
            }
            }
            assertTrue(AggregationInspectionHelper.hasValue(geoGrid));
            randomPrecision(),
            }
        bbox.topLeft().reset(encodeDecodeLat.apply(bbox.top()), encodeDecodeLon.apply(bbox.left()));
        });
 *
                    double latWithin = randomDoubleBetween(bbox.bottom(), bbox.top(), true);
import org.apache.lucene.search.IndexSearcher;
        if (geoBoundingBox != null) {
            assertThat(actual, equalTo(expectedCountPerTPerGeoHash));
        bbox.bottomRight().reset(encodeDecodeLat.apply(bbox.bottom()), encodeDecodeLon.apply(bbox.right()));
            null,
     * to be loaded during the tests.
 * the Apache License, Version 2.0 (the "License"); you may
        testCase(
            } else {
            assertThat(aggregationBuilder.geoBoundingBox(), equalTo(geoBoundingBox));
        aggregator.preCollection();
        // but it does affect other bucketing algos, thus we need to do the same steps here.
                        ? randomDoubleBetween(bbox.left(), 180.0, true)
    protected abstract GeoGridAggregationBuilder createBuilder(String name);
                if (distinctHashesPerDoc.contains(hash) == false) {
            }
 * under the License.
import org.apache.lucene.index.IndexReader;
            if (bbox.left() > bbox.right()) {
            List<LatLonDocValuesField> points = new ArrayList<>();
        testCase(
import org.opensearch.common.geo.GeoUtils;
import org.opensearch.common.geo.GeoBoundingBox;
        Function<Double, Double> encodeDecodeLon = (lon) -> GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(lon));
            }
                actual.put(tb.getKeyAsString(), sub);
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    }
        String field,
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            assertThat(docCount, equalTo(numDocsInBucket));
/*
            }
        /*
 */
 * license agreements. See the NOTICE file distributed with
 */
        final GeoGridAggregationBuilder builder = createBuilder("_name");
        Function<Double, Double> encodeDecodeLat = (lat) -> GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(lat));
                points.add(new LatLonDocValuesField(FIELD_NAME, latLng[0], latLng[1]));
            Map<String, Map<String, Long>> actual = new TreeMap<>();
                } else {
        List<List<IndexableField>> docs = new ArrayList<>();
            "wrong_field",
import org.apache.lucene.search.MatchAllDocsQuery;
        // only consider bounding boxes that are at least GEOHASH_TOLERANCE wide and have quantized coordinates
        indexSearcher.search(query, aggregator);
 * KIND, either express or implied.  See the License for the
     */
        // Internally, lat/lng get converted to 32 bit integers, loosing some precision.
     * Generate a random precision according to the rules of the given aggregation.
            if (expectedCountPerGeoHash == null) {
 * Licensed to Elasticsearch under one or more contributor
import java.util.function.Function;
import java.util.HashSet;
                }
        Map<String, Map<String, Long>> expectedCountPerTPerGeoHash = new TreeMap<>();
                distinctHashesPerDoc.add(hash);
    public void testNoDocs() throws IOException {
        Map<String, Integer> expectedCountPerGeoHash = new HashMap<>();
                } else {
            geoGrid -> { assertEquals(0, geoGrid.getBuckets().size()); },
            for (int pointId = 0; pointId < numPoints; pointId++) {
        // This does not affect geohashing because geohash uses the same algorithm,
import org.opensearch.common.CheckedConsumer;
                    double latOutside = randomDoubleBetween(bbox.top(), -90, false);
        expectThrows(IllegalArgumentException.class, () -> builder.precision(-1));
