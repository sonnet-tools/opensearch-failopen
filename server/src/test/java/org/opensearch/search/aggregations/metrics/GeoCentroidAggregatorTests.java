 * SPDX-License-Identifier: Apache-2.0
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");
                document.add(new LatLonDocValuesField("field", multiVal[1].getLat(), multiVal[1].getLon()));
                );
import org.apache.lucene.search.IndexSearcher;
                );
            }
 * specific language governing permissions and limitations
            }
            assertEquals("my_agg", result.getName());
import org.opensearch.search.aggregations.AggregatorTestCase;
            for (int i = 0; i < numDocs; i++) {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
    public void testUnmappedWithMissing() throws Exception {
 * not use this file except in compliance with the License.
 */
            GeoPoint expectedCentroid = new GeoPoint(0, 0);
        int numDocs = scaledRandomIntBetween(64, 256);
            GeoPoint singleVal;
/*
    }
                w.addDocument(document);
                Document document = new Document();
import org.opensearch.index.mapper.GeoPointFieldMapper;
            }
import org.opensearch.search.aggregations.support.ValuesSourceType;
import org.apache.lucene.document.Document;
            Document document = new Document();
                w.addDocument(document);
 *
                fieldType = new GeoPointFieldMapper.GeoPointFieldType("another_field");
        }
        return Arrays.asList(CoreValuesSourceType.GEOPOINT);
            }
        int numUniqueGeoPoints = randomIntBetween(1, numDocs);
        int numDocs = scaledRandomIntBetween(64, 256);
 *
        GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("field");
                assertFalse(AggregationInspectionHelper.hasValue(result));
            final GeoPoint[] multiVal = new GeoPoint[2];
            InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
 * ownership. Elasticsearch licenses this file to you under
                assertNull(result.centroid());
import java.io.IOException;
            assertNotNull(centroid);
 * You may obtain a copy of the License at
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
                .missing("53.69437,6.475031");
        }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("field");
import org.opensearch.test.geo.RandomGeoGenerator;
            document.add(new LatLonDocValuesField("field", 10, 10));
            assertCentroid(w, expectedCentroid);
            w.addDocument(document);
                double newMVLat = (multiVal[0].lat() + multiVal[1].lat()) / 2d;
    }
            try (IndexReader reader = w.getReader()) {
                IndexSearcher searcher = new IndexSearcher(reader);
                    expectedCentroid.lat() + (singleVal.lat() - expectedCentroid.lat()) / (i + 1),
                    expectedCentroid.lon() + (newMVLon - expectedCentroid.lon()) / (i + 1)
                expectedCentroid = expectedCentroid.reset(
                InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                assertEquals(result.centroid(), expectedCentroid);
                assertTrue(AggregationInspectionHelper.hasValue(result));
    private void assertCentroid(RandomIndexWriter w, GeoPoint expectedCentroid) throws IOException {
        try (IndexReader reader = w.getReader()) {
 * GitHub history for details.
                double newMVLon = (multiVal[0].lon() + multiVal[1].lon()) / 2d;
import org.apache.lucene.tests.index.RandomIndexWriter;
                    expectedCentroid.lon() + (singleVal.lon() - expectedCentroid.lon()) / (i + 1)
            assertTrue(AggregationInspectionHelper.hasValue(result));
            GeoPoint centroid = result.centroid();
        return new GeoCentroidAggregationBuilder("foo").field(fieldName);
            assertEquals(expectedCentroid.getLat(), centroid.getLat(), GEOHASH_TOLERANCE);
 * Modifications Copyright OpenSearch Contributors. See
    public void testUnmapped() throws Exception {
            GeoPoint expectedCentroid = new GeoPoint(53.69437, 6.475031);
/*
            GeoPoint[] multiValues = new GeoPoint[numUniqueGeoPoints];
    public void testMultiValuedField() throws Exception {
                document.add(new LatLonDocValuesField("field", singleVal.getLat(), singleVal.getLon()));
 * this file be licensed under the Apache-2.0 license or a
    private static final double GEOHASH_TOLERANCE = 1E-6D;
 * compatible open source license.
                MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("another_field");
                IndexSearcher searcher = new IndexSearcher(reader);
                result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
    }
            GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("another_field")
 * license agreements. See the NOTICE file distributed with
        }
            try (IndexReader reader = w.getReader()) {
public class GeoCentroidAggregatorTests extends AggregatorTestCase {
            assertCentroid(w, expectedCentroid);
                    expectedCentroid.lat() + (newMVLat - expectedCentroid.lat()) / (i + 1),
    }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                IndexSearcher searcher = new IndexSearcher(reader);
 */
 */
    }
 * under the License.
            try (IndexReader reader = w.getReader()) {
                document.add(new LatLonDocValuesField("field", multiVal[0].getLat(), multiVal[0].getLon()));
            for (int i = 0; i < numDocs; i++) {
 * The OpenSearch Contributors require contributions made to
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.mapper.MappedFieldType;
 * Unless required by applicable law or agreed to in writing,
            for (int i = 0; i < singleValues.length; i++) {
import org.apache.lucene.search.MatchAllDocsQuery;
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
                assertNull(result.centroid());
    public void testSingleValuedField() throws Exception {
                multiValues[i] = RandomGeoGenerator.randomPoint(random());
            for (int i = 0; i < multiValues.length; i++) {
        }
            IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.document.LatLonDocValuesField;
        int numUniqueGeoPoints = randomIntBetween(1, numDocs);
            Document document = new Document();
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
 * software distributed under the License is distributed on an
                assertNull(result.centroid());
                multiVal[1] = multiValues[(i + 1) % numUniqueGeoPoints];
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            GeoPoint[] singleValues = new GeoPoint[numUniqueGeoPoints];
            document.add(new LatLonDocValuesField("field", 10, 10));
import org.opensearch.common.geo.GeoPoint;
                Document document = new Document();
import org.apache.lucene.index.IndexReader;
package org.opensearch.search.aggregations.metrics;
            assertEquals(expectedCentroid.getLon(), centroid.getLon(), GEOHASH_TOLERANCE);
        }
                assertFalse(AggregationInspectionHelper.hasValue(result));
    }
                singleVal = singleValues[i % numUniqueGeoPoints];
 *
            w.addDocument(document);
                singleValues[i] = RandomGeoGenerator.randomPoint(random());
import org.apache.lucene.store.Directory;
        MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");
            }
            GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("another_field");
import org.opensearch.search.aggregations.AggregationBuilder;
                MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("another_field");
import java.util.Arrays;
    @Override
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
 * KIND, either express or implied.  See the License for the
            }
                InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                expectedCentroid = expectedCentroid.reset(
    public void testEmpty() throws Exception {
                multiVal[0] = multiValues[i % numUniqueGeoPoints];
            }
    }
            GeoPoint expectedCentroid = new GeoPoint(0, 0);
import java.util.List;
}
