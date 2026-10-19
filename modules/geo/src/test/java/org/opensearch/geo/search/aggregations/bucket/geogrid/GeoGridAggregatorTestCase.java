    private void testCase(  
        double lng = (360d * randomDouble()) - 180d;  
            geoGrid -> { assertEquals(0, geoGrid.getBuckets().size()); },
            for (int i = 0; i < geoGrid.getBuckets().size(); i++) {
        }, iw -> {
            }  
        GeoGridAggregationBuilder aggregationBuilder  
import org.apache.lucene.index.DirectoryReader;  
    @Override
    }
            if (expectedCountPerGeoHash == null) {  
    protected List<SearchPlugin> getSearchPlugins() {
import org.opensearch.search.aggregations.Aggregation;  
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latWithin, lonWithin));  
                    expectedCountPerGeoHash.put(hash, expectedCountPerGeoHash.getOrDefault(hash, 0) + 1);  
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
            geoGrid -> { assertEquals(0, geoGrid.getBuckets().size()); },  
            }
            iw -> iw.addDocument(Collections.singleton(new LatLonDocValuesField(FIELD_NAME, 10D, 10D))),  
import org.opensearch.search.aggregations.AggregatorTestCase;
                    double lonOutside = randomDoubleBetween(bbox.left(), bbox.right(), true);
            expectedCountPerGeoHash.put(hash, expectedCountPerGeoHash.getOrDefault(hash, 0L) + 1);
                }
import org.apache.lucene.geo.GeoEncodingUtils;
            for (LatLonDocValuesField docField : docs) {
 * license agreements. See the NOTICE file distributed with
    }
        expectThrows(IllegalArgumentException.class, () -> builder.precision(-1));
            }
        final long numDocsInBucket = in;
 */
    protected abstract String hashAsString(double lng, double lat, int precision);
        });
import org.opensearch.index.mapper.GeoPointFieldMapper;  
}
import java.util.Collections;  
import org.apache.lucene.search.IndexSearcher;  
        int precision = randomPrecision();
 * under the License.  
     * to be loaded during the tests.
                assertEquals((long) expectedCountPerGeoHash.get(bucket.getKeyAsString()), bucket.getDocCount());
            if (bbox.left() > bbox.right()) {
/*
import java.util.HashMap;
            null,  
     * Overriding the Search Plugins list with {@link GeoModulePlugin} so that the testcase will know that this plugin is  
        final int precision = randomPrecision();  
        indexReader.close();  
 * compatible open source license.
        IndexReader indexReader = DirectoryReader.open(directory);
                    double lonOutside = GeoUtils.normalizeLon(randomDoubleBetween(bbox.right(), 180.001, false));
        GeoGridAggregationBuilder builder = createBuilder("_name").field("wrong_field").missing("53.69437,6.475031");  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        final GeoGridAggregationBuilder builder = createBuilder("_name");
                    sub.put(ggb.getKeyAsString(), ggb.getDocCount());
            for (StringTerms.Bucket tb : terms.getBuckets()) {  
        }  
            for (int pointId = 0; pointId < numPoints; pointId++) {
            assertThat(docCount, equalTo(numDocsInBucket));
            List<LatLonDocValuesField> points = new ArrayList<>();
        indexSearcher.search(query, aggregator);
        for (int i = 0; i < 30; i++) {
    public void testNoDocs() throws IOException {  
                }  
            FIELD_NAME,  
 * KIND, either express or implied.  See the License for the
import java.util.function.Consumer;
            assertThat(actual, equalTo(expectedCountPerTPerGeoHash));
     */
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.TreeMap;  
        MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType(FIELD_NAME);
 * SPDX-License-Identifier: Apache-2.0
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
 * not use this file except in compliance with the License.
                if (randomBoolean()) {
import org.apache.lucene.util.BytesRef;
            .size(expectedCountPerTPerGeoHash.size())
    }
            }
                if (usually()) {  
            if (points.size() != 0) {  
        Directory directory = newDirectory();
        testCase(
import org.apache.lucene.search.Query;
 * The OpenSearch Contributors require contributions made to  
            Map<String, Long> expectedCountPerGeoHash = expectedCountPerTPerGeoHash.get(t);
        Consumer<BaseGeoGrid<T>> verify,  
        testCase(new MatchAllDocsQuery(), FIELD_NAME, precision, bbox, geoGrid -> {
                    out++;
        int in = 0, out = 0;
    /**
     * @return List of {@link SearchPlugin}
            null,
                docCount += geoGrid.getBuckets().get(i).getDocCount();  
            for (GeoGrid.Bucket bucket : geoHashGrid.getBuckets()) {  
        testCase(
                    distinctHashesPerDoc.clear();  
            assertTrue(AggregationInspectionHelper.hasValue(geoGrid));  
            }  
            double[] latLng = randomLatLng();  
            assertTrue(AggregationInspectionHelper.hasValue(geoHashGrid));  
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            iw -> {
                expectedCountPerGeoHash = new TreeMap<>();
        return new double[] { lat, lng };  
 * GitHub history for details.
                Map<String, Long> sub = new TreeMap<>();
                    double latOutside = GeoUtils.normalizeLat(randomDoubleBetween(bbox.top(), 90.001, false));  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Map<String, Long>> expectedCountPerTPerGeoHash = new TreeMap<>();
                iw.addDocument(Collections.singleton(new LatLonDocValuesField(FIELD_NAME, 10D, 10D)));  
            aggregationBuilder.setGeoBoundingBox(geoBoundingBox);  
                }
        expectThrows(IllegalArgumentException.class, () -> builder.precision(30));
                    double lonWithin = randomDoubleBetween(bbox.left(), bbox.right(), true);  
    public void testWithSeveralDocs() throws IOException {  
                    out++;
            String t = randomAlphaOfLength(1);
import java.util.ArrayList;
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latOutside, lonOutside));
        while (in + out < numDocs) {
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("t").field("t")
    private void testCase(
    public void testUnmapped() throws IOException {
    }
            new MatchAllDocsQuery(),
            doc.add(new SortedSetDocValuesField("t", new BytesRef(t)));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        testCase(new MatchAllDocsQuery(), FIELD_NAME, precision, null, geoHashGrid -> {
                    double lonWithin = randomBoolean()
            }
        Function<Double, Double> encodeDecodeLon = (lon) -> GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(lon));
        GeoBoundingBox geoBoundingBox,  
    @Override
    ) throws IOException {
                BaseGeoGrid<?> gg = tb.getAggregations().get("gg");
            long docCount = 0;
            "wrong_field",
    }
        GeoBoundingBox geoBoundingBox,
import java.io.IOException;
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latOutside, lonOutside));
    protected abstract int randomPrecision();
        Map<String, Integer> expectedCountPerGeoHash = new HashMap<>();  
                } else {
        final int numDocs = randomIntBetween(64, 256);
import org.apache.lucene.document.LatLonDocValuesField;  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
     * Generate a random precision according to the rules of the given aggregation.  
        }, iw -> {  
        Function<Double, Double> encodeDecodeLat = (lat) -> GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(lat));  
                actual.put(tb.getKeyAsString(), sub);  
                // Intentionally not writing any docs
    }
    public void testAsSubAgg() throws IOException {  
    ) throws IOException {
                for (BaseGeoGridBucket<?> ggb : gg.getBuckets()) {  
import org.apache.lucene.store.Directory;  
         */
            randomPrecision(),
                        ? randomDoubleBetween(bbox.left(), 180.0, true)
            assertThat(aggregationBuilder.geoBoundingBox(), equalTo(geoBoundingBox));
                    double latWithin = randomDoubleBetween(bbox.bottom(), bbox.top(), true);
        );
import org.opensearch.common.geo.GeoBoundingBox;
        indexWriter.close();
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.geo.GeoModulePlugin;  
 */  
                    double latWithin = randomDoubleBetween(bbox.bottom(), bbox.top(), true);
        bbox.topLeft().reset(encodeDecodeLat.apply(bbox.top()), encodeDecodeLon.apply(bbox.left()));
import org.apache.lucene.index.IndexReader;
     * Create a new named {@link GeoGridAggregationBuilder}-derived builder
        lng = GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(lng));  
        if (geoBoundingBox != null) {
                }
import static org.hamcrest.Matchers.equalTo;
public abstract class GeoGridAggregatorTestCase<T extends BaseGeoGridBucket> extends AggregatorTestCase {  
        buildIndex.accept(indexWriter);
    }  
        verify.accept((BaseGeoGrid<T>) aggregator.buildTopLevel());
import org.apache.lucene.index.IndexableField;
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex
 * Licensed to Elasticsearch under one or more contributor  
         * No-op.
                double[] latLng = randomLatLng();
     */
     */  
                }  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.Function;
 *
    }
 *  
        // This does not affect geohashing because geohash uses the same algorithm,
                    docs.add(new LatLonDocValuesField(FIELD_NAME, latWithin, lonWithin));  
                    iw.addDocument(points);
import org.opensearch.geo.tests.common.RandomGeoGenerator;
        aggregationBuilder.precision(precision);
            Set<String> distinctHashesPerDoc = new HashSet<>();  
    private static final String FIELD_NAME = "location";
        );
        int precision,
    /**
            List<IndexableField> doc = new ArrayList<>();
        // but it does affect other bucketing algos, thus we need to do the same steps here.
    /**
        // Precision-adjust longitude/latitude to avoid wrong bucket placement
    protected static final double GEOHASH_TOLERANCE = 1E-5D;  
            String hash = hashAsString(latLng[1], latLng[0], precision);
        /*  
            Map<String, Map<String, Long>> actual = new TreeMap<>();
            }
                        : randomDoubleBetween(-180.0, bbox.right(), true);  
        );
import org.opensearch.index.mapper.MappedFieldType;
                points.add(new LatLonDocValuesField(FIELD_NAME, latLng[0], latLng[1]));  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashSet;
    public void testUnmappedMissing() throws IOException {
            geoGrid -> assertEquals(1, geoGrid.getBuckets().size()),
        Query query,
import org.apache.lucene.search.MatchAllDocsQuery;
                if (randomBoolean()) {  
        double lat = (180d * randomDouble()) - 90d;
            (b) -> Math.abs(GeoUtils.normalizeLon(b.right()) - GeoUtils.normalizeLon(b.left())) < GEOHASH_TOLERANCE,  
        // only consider bounding boxes that are at least GEOHASH_TOLERANCE wide and have quantized coordinates
                iw.addDocument(Collections.singletonList(docField));
        }
    }  
            randomPrecision(),  
import java.util.Set;
                    in++;
import org.apache.lucene.tests.index.RandomIndexWriter;
        Consumer<BaseGeoGrid<T>> verify,
        return Collections.singletonList(new GeoModulePlugin());  
            }  
        bbox.bottomRight().reset(encodeDecodeLat.apply(bbox.bottom()), encodeDecodeLon.apply(bbox.right()));  
        directory.close();
            .subAggregation(createBuilder("gg").field(FIELD_NAME).precision(precision));  
            }
        List<List<IndexableField>> docs = new ArrayList<>();  
     * Convert geo point into a hash string (bucket string ID)
import org.opensearch.common.geo.GeoUtils;
        Query query,
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    }
        List<LatLonDocValuesField> docs = new ArrayList<>();  
        }
            }
import java.util.List;  
import org.apache.lucene.document.SortedSetDocValuesField;
    public void testBounds() throws IOException {  
        testCase(
                } else {
import org.opensearch.plugins.SearchPlugin;
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
            RandomGeoGenerator::randomBBox
        );
            doc.add(new LatLonDocValuesField(FIELD_NAME, latLng[0], latLng[1]));
/*
        lat = GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(lat));
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    }
                    points.clear();
        };  
import org.opensearch.geo.tests.common.AggregationInspectionHelper;
    /**  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> iw.addDocuments(docs);  
                distinctHashesPerDoc.add(hash);
        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
                iw.addDocument(points);
        int precision = randomPrecision();
                String hash = hashAsString(latLng[1], latLng[0], precision);
        GeoBoundingBox bbox = randomValueOtherThanMany(
                if (distinctHashesPerDoc.contains(hash) == false) {
    protected abstract GeoGridAggregationBuilder createBuilder(String name);  
            } else {
        Consumer<StringTerms> verify = (terms) -> {
 * Unless required by applicable law or agreed to in writing,
        // Internally, lat/lng get converted to 32 bit integers, loosing some precision.  
            new MatchAllDocsQuery(),
import org.opensearch.common.CheckedConsumer;  
 * software distributed under the License is distributed on an
                    double latOutside = randomDoubleBetween(bbox.top(), -90, false);  
    private double[] randomLatLng() {
 * You may obtain a copy of the License at  
                    in++;
 * specific language governing permissions and limitations
            new MatchAllDocsQuery(),  
 *
 */
        });  
        testCase(aggregationBuilder, new MatchAllDocsQuery(), buildIndex, verify, keywordField("t"), geoPointField(FIELD_NAME));
        String field,  
            null,
            iw -> {
/*  
     */  
            builder
        testCase(query, precision, geoBoundingBox, verify, buildIndex, createBuilder("_name").field(field));  
                expectedCountPerTPerGeoHash.put(t, expectedCountPerGeoHash);
            docs.add(doc);  
        int numPoints = randomIntBetween(8, 128);
        aggregator.postCollection();  
        aggregator.preCollection();
            assertEquals(expectedCountPerGeoHash.size(), geoHashGrid.getBuckets().size());
        int precision,
            randomPrecision(),
