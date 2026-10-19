                w.addDocument(doc);
                for (int j = 0; j < numValues; j++) {  
                assertThat(bounds.posRight, closeTo(posRight, GEOHASH_TOLERANCE));  
            MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");  
 * KIND, either express or implied.  See the License for the
            GeoBoundsAggregationBuilder aggBuilder = new GeoBoundsAggregationBuilder("my_agg").field("field").wrapLongitude(false);
        double top = Double.NEGATIVE_INFINITY;
                InternalGeoBounds bounds = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);  
 *  
    public void testRandom() throws Exception {  
                int numValues = randomIntBetween(1, 5);
 * Unless required by applicable law or agreed to in writing,
                assertThat(bounds.top, closeTo(top, GEOHASH_TOLERANCE));  
                    GeoPoint point = RandomGeoGenerator.randomPoint(random());
 *
import org.opensearch.index.mapper.GeoPointFieldMapper;  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.closeTo;
import org.opensearch.plugins.SearchPlugin;
                assertTrue(Double.isInfinite(bounds.posLeft));  
    public void testEmpty() throws Exception {
 */  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.Document;
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
 * The OpenSearch Contributors require contributions made to  
            }
import org.opensearch.search.aggregations.AggregatorTestCase;  
 * this work for additional information regarding copyright
import org.opensearch.common.geo.GeoPoint;
        return Collections.singletonList(new GeoModulePlugin());
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.document.LatLonDocValuesField;
                    }
                Document doc = new Document();
import java.util.Collections;
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            try (IndexReader reader = w.getReader()) {
 * compatible open source license.
                    if (point.getLon() < 0 && point.getLon() > negRight) {
    }
                }  
import org.apache.lucene.search.IndexSearcher;
        int numDocs = randomIntBetween(50, 100);
                assertFalse(AggregationInspectionHelper.hasValue(bounds));
                    }
import org.opensearch.geo.GeoModulePlugin;  
            GeoBoundsAggregationBuilder aggBuilder = new GeoBoundsAggregationBuilder("my_agg").field("field").wrapLongitude(false);  
 * license agreements. See the NOTICE file distributed with
    protected List<SearchPlugin> getSearchPlugins() {
                assertThat(bounds.negRight, closeTo(negRight, GEOHASH_TOLERANCE));
 * Modifications Copyright OpenSearch Contributors. See
                        posRight = point.getLon();  
public class GeoBoundsAggregatorTests extends AggregatorTestCase {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
        double negLeft = Double.POSITIVE_INFINITY;
 * software distributed under the License is distributed on an
import org.apache.lucene.store.Directory;  
                assertThat(bounds.posLeft, closeTo(posLeft, GEOHASH_TOLERANCE));
                assertTrue(Double.isInfinite(bounds.posRight));
     * Overriding the Search Plugins list with {@link GeoModulePlugin} so that the testcase will know that this plugin is
                    }
                assertTrue(Double.isInfinite(bounds.top));
import org.apache.lucene.tests.index.RandomIndexWriter;
                        top = point.getLat();  
 */  
        double negRight = Double.NEGATIVE_INFINITY;  
                assertThat(bounds.bottom, closeTo(bottom, GEOHASH_TOLERANCE));
import java.util.List;  
            }
                    if (point.getLon() < 0 && point.getLon() < negLeft) {
    @Override  
                        negRight = point.getLon();  
                    }
                IndexSearcher searcher = new IndexSearcher(reader);
                    if (point.getLat() > top) {
 *
            for (int i = 0; i < numDocs; i++) {  
        double posLeft = Double.POSITIVE_INFINITY;  
 * You may obtain a copy of the License at  
/*  
import org.opensearch.index.mapper.MappedFieldType;
                        posLeft = point.getLon();  
                    doc.add(new LatLonDocValuesField("field", point.getLat(), point.getLon()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
/*
            try (IndexReader reader = w.getReader()) {  
 */
import org.apache.lucene.search.MatchAllDocsQuery;
                        negLeft = point.getLon();  
                    if (point.getLon() >= 0 && point.getLon() > posRight) {
 * not use this file except in compliance with the License.
     * @return List of {@link SearchPlugin}
                assertTrue(AggregationInspectionHelper.hasValue(bounds));  
 * GitHub history for details.
                assertTrue(Double.isInfinite(bounds.negLeft));
                IndexSearcher searcher = new IndexSearcher(reader);
import org.opensearch.geo.tests.common.RandomGeoGenerator;
            }
package org.opensearch.geo.search.aggregations.metrics;
                assertTrue(Double.isInfinite(bounds.negRight));  
        double posRight = Double.NEGATIVE_INFINITY;
                    }
import org.opensearch.geo.tests.common.AggregationInspectionHelper;
                assertThat(bounds.negLeft, closeTo(negLeft, GEOHASH_TOLERANCE));
import org.apache.lucene.index.IndexReader;  
 * this file be licensed under the Apache-2.0 license or a
                InternalGeoBounds bounds = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
            MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");
/*  
    }  
                    if (point.getLon() >= 0 && point.getLon() < posLeft) {
    }  
 * Licensed to Elasticsearch under one or more contributor  
                        bottom = point.getLat();  
    public static final double GEOHASH_TOLERANCE = 1E-5D;
        double bottom = Double.POSITIVE_INFINITY;
                    if (point.getLat() < bottom) {
                    }
        }
}
     * to be loaded during the tests.  
                assertTrue(Double.isInfinite(bounds.bottom));
