    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
    }
    public void testEmpty() throws Exception {
            GeoPoint expectedCentroid = new GeoPoint(53.69437, 6.475031);  
import org.opensearch.index.mapper.GeoPointFieldMapper;
        }  
                assertTrue(AggregationInspectionHelper.hasValue(result));
                assertFalse(AggregationInspectionHelper.hasValue(result));
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
        }  
                double newMVLat = (multiVal[0].lat() + multiVal[1].lat()) / 2d;  
    }
    }
import org.opensearch.search.aggregations.AggregatorTestCase;
            GeoPoint singleVal;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Arrays;  
            assertCentroid(w, expectedCentroid);
            GeoPoint[] multiValues = new GeoPoint[numUniqueGeoPoints];  
    private static final double GEOHASH_TOLERANCE = 1E-6D;
            }
 *
 * under the License.  
import org.apache.lucene.search.IndexSearcher;  
                InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                    expectedCentroid.lat() + (newMVLat - expectedCentroid.lat()) / (i + 1),  
 * specific language governing permissions and limitations
    public void testMultiValuedField() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        }  
        GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("field");
                );  
import org.opensearch.test.geo.RandomGeoGenerator;  
                assertFalse(AggregationInspectionHelper.hasValue(result));
                multiValues[i] = RandomGeoGenerator.randomPoint(random());
        int numDocs = scaledRandomIntBetween(64, 256);
                expectedCentroid = expectedCentroid.reset(  
            IndexSearcher searcher = new IndexSearcher(reader);  
    }  
            InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
            document.add(new LatLonDocValuesField("field", 10, 10));
            GeoPoint[] singleValues = new GeoPoint[numUniqueGeoPoints];
            assertEquals(expectedCentroid.getLon(), centroid.getLon(), GEOHASH_TOLERANCE);
                IndexSearcher searcher = new IndexSearcher(reader);
public class GeoCentroidAggregatorTests extends AggregatorTestCase {  
            assertEquals("my_agg", result.getName());  
        int numUniqueGeoPoints = randomIntBetween(1, numDocs);
            for (int i = 0; i < numDocs; i++) {
 * Unless required by applicable law or agreed to in writing,
    @Override  
                assertNull(result.centroid());  
import org.opensearch.search.aggregations.support.ValuesSourceType;
        return new GeoCentroidAggregationBuilder("foo").field(fieldName);
                multiVal[0] = multiValues[i % numUniqueGeoPoints];  
                IndexSearcher searcher = new IndexSearcher(reader);
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("another_field");
/*
                document.add(new LatLonDocValuesField("field", multiVal[0].getLat(), multiVal[0].getLon()));  
            assertTrue(AggregationInspectionHelper.hasValue(result));
import org.opensearch.search.aggregations.AggregationBuilder;
            }
                InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
            final GeoPoint[] multiVal = new GeoPoint[2];
package org.opensearch.search.aggregations.metrics;
            Document document = new Document();
        int numDocs = scaledRandomIntBetween(64, 256);
 * KIND, either express or implied.  See the License for the
                assertNull(result.centroid());
/*
            GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("another_field")  
            document.add(new LatLonDocValuesField("field", 10, 10));
 * this work for additional information regarding copyright
import org.apache.lucene.index.IndexReader;
            assertEquals(expectedCentroid.getLat(), centroid.getLat(), GEOHASH_TOLERANCE);  
 * software distributed under the License is distributed on an
                double newMVLon = (multiVal[0].lon() + multiVal[1].lon()) / 2d;
                w.addDocument(document);
                expectedCentroid = expectedCentroid.reset(
 *  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
import java.io.IOException;
            assertCentroid(w, expectedCentroid);
        MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");  
                Document document = new Document();
                InternalGeoCentroid result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                document.add(new LatLonDocValuesField("field", singleVal.getLat(), singleVal.getLon()));
            try (IndexReader reader = w.getReader()) {  
        }  
            GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("field");  
                    expectedCentroid.lon() + (newMVLon - expectedCentroid.lon()) / (i + 1)
                    expectedCentroid.lon() + (singleVal.lon() - expectedCentroid.lon()) / (i + 1)
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            }  
 *
                .missing("53.69437,6.475031");
            }
    public void testUnmappedWithMissing() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
 * ownership. Elasticsearch licenses this file to you under  
                Document document = new Document();  
import org.opensearch.index.mapper.MappedFieldType;  
            GeoPoint centroid = result.centroid();
                );
    }
import org.apache.lucene.store.Directory;
            for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.search.MatchAllDocsQuery;
    @Override
                IndexSearcher searcher = new IndexSearcher(reader);
                MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("another_field");
            }
                assertNull(result.centroid());  
    }  
                fieldType = new GeoPointFieldMapper.GeoPointFieldType("another_field");
                multiVal[1] = multiValues[(i + 1) % numUniqueGeoPoints];
 * license agreements. See the NOTICE file distributed with
    public void testUnmapped() throws Exception {  
 */
            Document document = new Document();
 * the Apache License, Version 2.0 (the "License"); you may
        return Arrays.asList(CoreValuesSourceType.GEOPOINT);
import org.apache.lucene.document.LatLonDocValuesField;
    }
                document.add(new LatLonDocValuesField("field", multiVal[1].getLat(), multiVal[1].getLon()));
            try (IndexReader reader = w.getReader()) {
        int numUniqueGeoPoints = randomIntBetween(1, numDocs);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
            for (int i = 0; i < multiValues.length; i++) {
 * not use this file except in compliance with the License.
            try (IndexReader reader = w.getReader()) {
            GeoCentroidAggregationBuilder aggBuilder = new GeoCentroidAggregationBuilder("my_agg").field("another_field");
        try (IndexReader reader = w.getReader()) {
            }  
            w.addDocument(document);  
                result = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);  
                w.addDocument(document);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.geo.GeoPoint;
                singleValues[i] = RandomGeoGenerator.randomPoint(random());
            for (int i = 0; i < singleValues.length; i++) {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            GeoPoint expectedCentroid = new GeoPoint(0, 0);
import java.util.List;
            }  
                    expectedCentroid.lat() + (singleVal.lat() - expectedCentroid.lat()) / (i + 1),
    public void testSingleValuedField() throws Exception {  
    }
        }
                singleVal = singleValues[i % numUniqueGeoPoints];
                assertEquals(result.centroid(), expectedCentroid);  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
            MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");
    private void assertCentroid(RandomIndexWriter w, GeoPoint expectedCentroid) throws IOException {
import org.apache.lucene.tests.index.RandomIndexWriter;  
/*  
 * You may obtain a copy of the License at  
            GeoPoint expectedCentroid = new GeoPoint(0, 0);
            w.addDocument(document);  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
 */
import org.apache.lucene.document.Document;  
            assertNotNull(centroid);
 */  
        }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
}  
