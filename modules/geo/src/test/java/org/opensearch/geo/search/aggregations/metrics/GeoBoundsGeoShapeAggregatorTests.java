import java.util.List;
        }  
            try (IndexReader reader = w.getReader()) {  
     */
    }  
            }
            }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.geo.tests.common.AggregationInspectionHelper;
import org.opensearch.geo.GeoModulePlugin;  
            return LatLonShape.createDocValueField(FIELD_NAME, GeoShapeUtils.toLuceneLine((Line) geometry));
        final int numDocs = randomIntBetween(50, 100);
import org.hamcrest.MatcherAssert;  
import org.apache.logging.log4j.Logger;
            return LatLonShape.createDocValueField(FIELD_NAME, GeoShapeUtils.toLucenePolygon((Polygon) geometry));
        if (geometry instanceof Point) {
     *
    private static final double GEOHASH_TOLERANCE = 1E-5D;
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;
            return;  
                final GeoBoundingBox expectedGeoBounds = getExpectedGeoBounds(X, Y);  
            for (int i = 0; i < numDocs; i++) {
            return LatLonShape.createDocValueField(FIELD_NAME, point.getLat(), point.getLon());  
                bottom = lat;
                getAllXAndYPoints(geometry, X, Y);
        } else if (shapeNumber == 1) {
    @Override
            final Polygon polygon = (Polygon) geometry;
                X.add(line.getX(i));
                LOG.debug("Random Geometry created for Indexing : {}", geometry);
            for (int i = 0; i < line.getX().length; i++) {
            return;
        int shapeNumber = OpenSearchTestCase.randomIntBetween(0, 2);
        double negLeft = Double.POSITIVE_INFINITY;  
     * Check {@link GeoShapeIndexer#prepareForIndexing(org.opensearch.geometry.Geometry)}
                MatcherAssert.assertThat(actualBounds.topLeft().getLat(), closeTo(expectedGeoBounds.topLeft().getLat(), GEOHASH_TOLERANCE));  
            return;
            if (lon >= 0 && lon > posRight) {
        final List<Double> Y = new ArrayList<>();  
import java.util.Collections;
        Assert.fail(
                assertTrue(Double.isInfinite(bounds.top));  
import org.opensearch.common.geo.GeoShapeUtils;
    /**
import org.opensearch.test.OpenSearchTestCase;
                MatcherAssert.assertThat(actualBounds.topLeft().getLon(), closeTo(expectedGeoBounds.topLeft().getLon(), GEOHASH_TOLERANCE));
        } else {
                assertTrue(Double.isInfinite(bounds.posRight));  
            if (lat > top) {  
            // Point  
                MatcherAssert.assertThat(
    }
        double negRight = Double.NEGATIVE_INFINITY;
/*  
                final Document document = new Document();
 * SPDX-License-Identifier: Apache-2.0
            final MappedFieldType fieldType = new GeoShapeFieldMapper.GeoShapeFieldType(FIELD_NAME);
import org.opensearch.geometry.Polygon;
            }  
        for (final Double lon : X) {  
        }
            X.add(point.getX());
import org.apache.lucene.geo.LatLonGeometry;  
    }
public class GeoBoundsGeoShapeAggregatorTests extends AggregatorTestCase {
    }
     * Overriding the Search Plugins list with {@link GeoModulePlugin} so that the testcase will know that this plugin is  
                );
            if (lon < 0 && lon > negRight) {
 * compatible open source license.
                Y.add(polygon.getPolygon().getY(i));
import org.apache.lucene.search.MatchAllDocsQuery;  
     * {@link org.apache.lucene.geo.Line}, {@link org.apache.lucene.geo.Polygon}. {@link Circle} is not supported.
                posLeft = lon;
            }  
import org.opensearch.common.geo.GeoBoundingBox;  
                MatcherAssert.assertThat(
import org.opensearch.geometry.ShapeType;
     * Testing Empty aggregator results.
    }
import org.opensearch.search.aggregations.AggregatorTestCase;
                Y.add(line.getY(i));  
    public void testRandom() throws Exception {
        } else {
import org.apache.lucene.document.ShapeDocValuesField;
     */  
import org.opensearch.geometry.Line;
        return null;  
            final Line line = (Line) geometry;  
    private void getAllXAndYPoints(final Geometry geometry, final List<Double> X, final List<Double> Y) {
import org.apache.lucene.store.Directory;
        );
                negRight = lon;
    private static final String FIELD_NAME = "field";  
                    actualBounds.bottomRight().getLon(),  
            final GeoBoundsAggregationBuilder aggBuilder = new GeoBoundsAggregationBuilder(AGGREGATION_NAME).field(FIELD_NAME)  
     *  
     * Random function to generate a {@link LatLonGeometry}. Now for indexing of GeoShape field, we index all the
            final Point point = (Point) geometry;
        if (shapeNumber == 0) {
     */
                .wrapLongitude(false);  
    protected List<SearchPlugin> getSearchPlugins() {  
import org.opensearch.geometry.Point;  
import org.opensearch.index.mapper.MappedFieldType;
        double top = Double.NEGATIVE_INFINITY;
        }
            return new GeoBoundingBox(new GeoPoint(top, posLeft), new GeoPoint(bottom, posRight));
            // Polygon  
    private static Geometry randomLuceneGeometry(final Random r) {  
                IndexSearcher searcher = new IndexSearcher(reader);
        } else if (geometry instanceof Polygon) {
        if (Double.isInfinite(posLeft)) {
import org.junit.Assert;
                negLeft = lon;
                    closeTo(expectedGeoBounds.bottomRight().getLat(), GEOHASH_TOLERANCE)  
            }  
            }
        double posLeft = Double.POSITIVE_INFINITY;
                assertTrue(Double.isInfinite(bounds.posLeft));
 *
        // Finding the bounding box for the shapes.
    /**  
        double bottom = Double.POSITIVE_INFINITY;  
     * @return List of {@link SearchPlugin}  
import java.util.ArrayList;  
import java.util.Random;
            final MappedFieldType fieldType = new GeoShapeFieldMapper.GeoShapeFieldType(FIELD_NAME);
            }
                final InternalGeoBounds actualBounds = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
        final List<Double> X = new ArrayList<>();
     * @return {@link LatLonGeometry}
            }  
import org.apache.lucene.document.Document;  
     * @throws Exception if an error occurs accessing the index
        } else if (geometry instanceof Line) {  
            return RandomGeoGeometryGenerator.randomPolygon(r);
        }
                document.add(createShapeDocValue(geometry));
            if (lat < bottom) {  
package org.opensearch.geo.search.aggregations.metrics;
    private GeoBoundingBox getExpectedGeoBounds(final List<Double> X, final List<Double> Y) {
import org.opensearch.geometry.Circle;  
     *  
import org.opensearch.index.mapper.GeoShapeIndexer;
            for (int i = 0; i < polygon.getPolygon().getX().length; i++) {  
import org.opensearch.common.geo.GeoPoint;
                    actualBounds.bottomRight().getLat(),
            }  
import static org.hamcrest.Matchers.closeTo;  
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, negRight));
     * Hence, we are generating only 3 shapes : {@link org.apache.lucene.geo.Point},  
            try (IndexReader reader = w.getReader()) {  
                final IndexSearcher searcher = new IndexSearcher(reader);
        if (geometry instanceof Point) {
            final Point point = (Point) geometry;  
            if (lon < 0 && lon < negLeft) {
            // LineString  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            return RandomGeoGeometryGenerator.randomLine(r);
            }  
                    closeTo(expectedGeoBounds.bottomRight().getLon(), GEOHASH_TOLERANCE)
        } else if (geometry instanceof Line) {
import org.apache.lucene.search.IndexSearcher;
        );  
import org.opensearch.plugins.SearchPlugin;  
import java.util.Locale;  
                w.addDocument(document);  
                final Geometry geometry = randomLuceneGeometry(random);  
                X.add(polygon.getPolygon().getX(i));
        } else if (Double.isInfinite(negLeft)) {  
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, posRight));  
                assertFalse(AggregationInspectionHelper.hasValue(bounds));  
                assertTrue(Double.isInfinite(bounds.negLeft));
import org.apache.lucene.index.IndexReader;
    /**
                );
                assertTrue(Double.isInfinite(bounds.negRight));
                top = lat;
 */  
     */
import org.opensearch.index.mapper.GeoShapeFieldMapper;  
        for (final Double lat : Y) {
    }  
        }
     *
     * @throws Exception if an error occurs accessing the index
            if (lon >= 0 && lon < posLeft) {
            final GeoBoundsAggregationBuilder aggBuilder = new GeoBoundsAggregationBuilder(AGGREGATION_NAME).field(FIELD_NAME)
        final Random random = random();
     * Testing GeoBoundAggregator for random shapes which are indexed.  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random, dir)) {  
                assertTrue(Double.isInfinite(bounds.bottom));
    /**
                posRight = lon;
            }
        }
     * different Geometry shapes that we support({@link ShapeType}) in OpenSearch are broken down into 3 shapes only.
    }
            Y.add(point.getY());
        } else if (geometry instanceof Polygon) {
    private static final String AGGREGATION_NAME = "my_agg";
 * this file be licensed under the Apache-2.0 license or a
        return Collections.singletonList(new GeoModulePlugin());
        }  
                InternalGeoBounds bounds = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
                assertTrue(AggregationInspectionHelper.hasValue(actualBounds));
        double posRight = Double.NEGATIVE_INFINITY;
import org.apache.lucene.document.LatLonShape;
    private static final Logger LOG = LogManager.getLogger(GeoBoundsGeoShapeAggregatorTests.class);  
    public void testEmpty() throws Exception {  
                .wrapLongitude(false);
            String.format(Locale.ROOT, "Error cannot convert the %s to a valid indexable format[POINT, POLYGON, LINE]", geometry.getClass())
import org.opensearch.geometry.Geometry;
import org.apache.lucene.tests.index.RandomIndexWriter;
            String.format(Locale.ROOT, "Error cannot convert the %s to a valid indexable format[POINT, POLYGON, LINE]", geometry.getClass())
    private ShapeDocValuesField createShapeDocValue(final Geometry geometry) {  
            return RandomGeoGeometryGenerator.randomPoint(r);
     * to be loaded during the tests.
        }
        Assert.fail(  
}
import org.apache.logging.log4j.LogManager;
