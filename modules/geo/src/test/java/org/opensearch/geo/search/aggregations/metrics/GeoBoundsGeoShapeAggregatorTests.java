            return new GeoBoundingBox(new GeoPoint(top, posLeft), new GeoPoint(bottom, posRight));
    }
     */
            }
                assertTrue(Double.isInfinite(bounds.bottom));
import org.opensearch.index.mapper.GeoShapeIndexer;
     *
     * @throws Exception if an error occurs accessing the index
     * @throws Exception if an error occurs accessing the index
        double posLeft = Double.POSITIVE_INFINITY;
     *
            for (int i = 0; i < polygon.getPolygon().getX().length; i++) {
                assertTrue(Double.isInfinite(bounds.negLeft));
import org.opensearch.geometry.Circle;
    public void testRandom() throws Exception {
        double bottom = Double.POSITIVE_INFINITY;
        double negRight = Double.NEGATIVE_INFINITY;
import org.opensearch.common.geo.GeoBoundingBox;
    protected List<SearchPlugin> getSearchPlugins() {
        }
                assertTrue(AggregationInspectionHelper.hasValue(actualBounds));
import java.util.Random;
 */
                IndexSearcher searcher = new IndexSearcher(reader);
    }
            X.add(point.getX());
                final Document document = new Document();
                MatcherAssert.assertThat(
        }
            for (int i = 0; i < numDocs; i++) {
/*
            return RandomGeoGeometryGenerator.randomPoint(r);
    /**
            // LineString
        } else if (Double.isInfinite(negLeft)) {
import org.apache.lucene.document.LatLonShape;
            return RandomGeoGeometryGenerator.randomLine(r);
import org.opensearch.geometry.Line;
 * compatible open source license.
    }
     * Random function to generate a {@link LatLonGeometry}. Now for indexing of GeoShape field, we index all the
}
                final Geometry geometry = randomLuceneGeometry(random);
                    actualBounds.bottomRight().getLat(),
            if (lat > top) {
            if (lon < 0 && lon < negLeft) {
            final Polygon polygon = (Polygon) geometry;
    /**
            }
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
     *
            }
    @Override
        if (geometry instanceof Point) {
    /**
 * SPDX-License-Identifier: Apache-2.0
                .wrapLongitude(false);
                final IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.search.MatchAllDocsQuery;
            String.format(Locale.ROOT, "Error cannot convert the %s to a valid indexable format[POINT, POLYGON, LINE]", geometry.getClass())
            try (IndexReader reader = w.getReader()) {
            final GeoBoundsAggregationBuilder aggBuilder = new GeoBoundsAggregationBuilder(AGGREGATION_NAME).field(FIELD_NAME)
     */
        }
import org.opensearch.search.aggregations.AggregatorTestCase;
    private static final Logger LOG = LogManager.getLogger(GeoBoundsGeoShapeAggregatorTests.class);
                MatcherAssert.assertThat(actualBounds.topLeft().getLon(), closeTo(expectedGeoBounds.topLeft().getLon(), GEOHASH_TOLERANCE));
    private static final String AGGREGATION_NAME = "my_agg";
        );
        // Finding the bounding box for the shapes.
                Y.add(polygon.getPolygon().getY(i));
import org.opensearch.common.geo.GeoPoint;
        } else {
        int shapeNumber = OpenSearchTestCase.randomIntBetween(0, 2);
        }
import org.opensearch.index.mapper.MappedFieldType;
    }
import org.opensearch.geometry.Polygon;
        final int numDocs = randomIntBetween(50, 100);
        }
    private void getAllXAndYPoints(final Geometry geometry, final List<Double> X, final List<Double> Y) {
        Assert.fail(
            }
 * The OpenSearch Contributors require contributions made to
            for (int i = 0; i < line.getX().length; i++) {
import org.junit.Assert;
            }
    /**
            return LatLonShape.createDocValueField(FIELD_NAME, GeoShapeUtils.toLuceneLine((Line) geometry));
    private static final double GEOHASH_TOLERANCE = 1E-5D;
            return;
        } else if (shapeNumber == 1) {
public class GeoBoundsGeoShapeAggregatorTests extends AggregatorTestCase {
                top = lat;
        double negLeft = Double.POSITIVE_INFINITY;
                MatcherAssert.assertThat(actualBounds.topLeft().getLat(), closeTo(expectedGeoBounds.topLeft().getLat(), GEOHASH_TOLERANCE));
            final Line line = (Line) geometry;
            if (lon >= 0 && lon > posRight) {
        final List<Double> Y = new ArrayList<>();
        }
            }
            return RandomGeoGeometryGenerator.randomPolygon(r);
        return Collections.singletonList(new GeoModulePlugin());
                LOG.debug("Random Geometry created for Indexing : {}", geometry);
                assertTrue(Double.isInfinite(bounds.posRight));
            final Point point = (Point) geometry;
     */
import org.apache.logging.log4j.LogManager;
            if (lat < bottom) {
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, negRight));
    }
                posLeft = lon;
                negLeft = lon;
import org.opensearch.geo.tests.common.AggregationInspectionHelper;
            }
                );
            return;
        return null;
        if (geometry instanceof Point) {
            return;
        final Random random = random();
            // Polygon
                assertTrue(Double.isInfinite(bounds.posLeft));
import org.hamcrest.MatcherAssert;
 *
                    actualBounds.bottomRight().getLon(),
    }
import org.apache.lucene.document.ShapeDocValuesField;
import java.util.Collections;
                    closeTo(expectedGeoBounds.bottomRight().getLat(), GEOHASH_TOLERANCE)
import java.util.List;
                    closeTo(expectedGeoBounds.bottomRight().getLon(), GEOHASH_TOLERANCE)
import org.opensearch.geometry.Point;
import static org.hamcrest.Matchers.closeTo;
        }
import org.apache.lucene.store.Directory;
                InternalGeoBounds bounds = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
    private static Geometry randomLuceneGeometry(final Random r) {
import org.opensearch.geo.GeoModulePlugin;
                MatcherAssert.assertThat(
                assertTrue(Double.isInfinite(bounds.top));
                final GeoBoundingBox expectedGeoBounds = getExpectedGeoBounds(X, Y);
     * @return {@link LatLonGeometry}
        for (final Double lon : X) {
    private ShapeDocValuesField createShapeDocValue(final Geometry geometry) {
        }
            final MappedFieldType fieldType = new GeoShapeFieldMapper.GeoShapeFieldType(FIELD_NAME);
import org.apache.lucene.tests.index.RandomIndexWriter;
import java.util.ArrayList;
     * Overriding the Search Plugins list with {@link GeoModulePlugin} so that the testcase will know that this plugin is
                final InternalGeoBounds actualBounds = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, fieldType);
            }
    }
            }
import org.opensearch.geometry.Geometry;
import org.opensearch.geo.tests.common.RandomGeoGeometryGenerator;
            return LatLonShape.createDocValueField(FIELD_NAME, point.getLat(), point.getLon());
 * this file be licensed under the Apache-2.0 license or a
     * {@link org.apache.lucene.geo.Line}, {@link org.apache.lucene.geo.Polygon}. {@link Circle} is not supported.
            if (lon < 0 && lon > negRight) {
                .wrapLongitude(false);
            }
                document.add(createShapeDocValue(geometry));
    private static final String FIELD_NAME = "field";
            final GeoBoundsAggregationBuilder aggBuilder = new GeoBoundsAggregationBuilder(AGGREGATION_NAME).field(FIELD_NAME)
            String.format(Locale.ROOT, "Error cannot convert the %s to a valid indexable format[POINT, POLYGON, LINE]", geometry.getClass())
                X.add(polygon.getPolygon().getX(i));
                negRight = lon;
        double posRight = Double.NEGATIVE_INFINITY;
        } else if (geometry instanceof Polygon) {
                assertTrue(Double.isInfinite(bounds.negRight));
     * to be loaded during the tests.
     * Hence, we are generating only 3 shapes : {@link org.apache.lucene.geo.Point},
import org.opensearch.plugins.SearchPlugin;
                X.add(line.getX(i));
    private GeoBoundingBox getExpectedGeoBounds(final List<Double> X, final List<Double> Y) {
import org.apache.lucene.document.Document;
        } else if (geometry instanceof Polygon) {
import org.opensearch.test.OpenSearchTestCase;
     *
        for (final Double lat : Y) {
     * different Geometry shapes that we support({@link ShapeType}) in OpenSearch are broken down into 3 shapes only.
        Assert.fail(
        if (Double.isInfinite(posLeft)) {
import org.apache.lucene.index.IndexReader;
     * Check {@link GeoShapeIndexer#prepareForIndexing(org.opensearch.geometry.Geometry)}
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random, dir)) {
import org.apache.lucene.geo.LatLonGeometry;
            // Point
            if (lon >= 0 && lon < posLeft) {
        } else {
    public void testEmpty() throws Exception {
import org.opensearch.index.mapper.GeoShapeFieldMapper;
import org.opensearch.common.geo.GeoShapeUtils;
        double top = Double.NEGATIVE_INFINITY;
     * Testing Empty aggregator results.
        if (shapeNumber == 0) {
                );
                bottom = lat;
import java.util.Locale;
import org.apache.lucene.search.IndexSearcher;
package org.opensearch.geo.search.aggregations.metrics;
                getAllXAndYPoints(geometry, X, Y);
            final Point point = (Point) geometry;
            Y.add(point.getY());
        } else if (geometry instanceof Line) {
                w.addDocument(document);
            try (IndexReader reader = w.getReader()) {
     */
            return new GeoBoundingBox(new GeoPoint(top, negLeft), new GeoPoint(bottom, posRight));
        );
import org.apache.logging.log4j.Logger;
     * @return List of {@link SearchPlugin}
            final MappedFieldType fieldType = new GeoShapeFieldMapper.GeoShapeFieldType(FIELD_NAME);
     * Testing GeoBoundAggregator for random shapes which are indexed.
        final List<Double> X = new ArrayList<>();
        } else if (geometry instanceof Line) {
                posRight = lon;
                Y.add(line.getY(i));
                assertFalse(AggregationInspectionHelper.hasValue(bounds));
import org.opensearch.geometry.ShapeType;
            }
            return LatLonShape.createDocValueField(FIELD_NAME, GeoShapeUtils.toLucenePolygon((Polygon) geometry));
