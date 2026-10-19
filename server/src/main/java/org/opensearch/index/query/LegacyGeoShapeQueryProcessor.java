                return new LineStringBuilder(coordinates);
import org.apache.lucene.spatial.query.SpatialOperation;
import org.opensearch.index.mapper.AbstractShapeGeometryFieldMapper;
                return polygonBuilder;
 *
import org.opensearch.geometry.Point;
 *
        }
                GeometryCollectionBuilder shapes = new GeometryCollectionBuilder();
        ShapeBuilder<?, ?, ?> shapeBuilder = geometry.visit(new GeometryVisitor<ShapeBuilder<?, ?, ?>, RuntimeException>() {
        }
            return bool.build();
            // before, including creating lucene fieldcache (!)
    public static SpatialArgs getArgs(Geometry shape, ShapeRelation relation) {
            case WITHIN:
 * You may obtain a copy of the License at
            }
            @Override
    }
            public ShapeBuilder<?, ?, ?> visit(MultiLine multiLine) {
 *
            public ShapeBuilder<?, ?, ?> visit(MultiPoint multiPoint) {
 * under the License.
    ) {
        PrefixTreeStrategy prefixTreeStrategy = shapeFieldType.resolvePrefixTreeStrategy(spatialStrategy);
 * this work for additional information regarding copyright
        Geometry shape,
 * Modifications Copyright OpenSearch Contributors. See
                }
        }
                );
import org.opensearch.geometry.MultiPolygon;
            @Override
                return new PointBuilder(point.getX(), point.getY());
    public Query geoShapeQuery(
        this.ft = ft;
    }
public class LegacyGeoShapeQueryProcessor {
     */
            bool.add(exists, BooleanClause.Occur.MUST);
import org.opensearch.geometry.GeometryCollection;
            public ShapeBuilder<?, ?, ?> visit(Circle circle) {
import org.opensearch.geometry.Rectangle;
import org.apache.lucene.spatial.query.SpatialArgs;
import org.opensearch.geometry.Line;
        QueryShardContext context
            public ShapeBuilder<?, ?, ?> visit(Point point) {
                    coordinates.add(new Coordinate(p.getX(), p.getY(), p.getZ()));
    }
import org.opensearch.common.geo.builders.EnvelopeBuilder;
            spatialStrategy = strategy;
                MultiLineStringBuilder lines = new MultiLineStringBuilder();
                return new SpatialArgs(SpatialOperation.IsWithin, buildS4J(shape));
        return shapeBuilder;
import org.opensearch.common.geo.builders.PointBuilder;
 */
     * <p>
        } else {
                }
            // in this case, execute disjoint as exists && !intersects
import org.opensearch.geometry.Circle;
            }
                List<Coordinate> coordinates = new ArrayList<>();
                    polygonBuilder.hole((LineStringBuilder) visit((Line) polygon.getHole(i)));
                return polygons;
            // this strategy doesn't support disjoint anymore: but it did
                    false
import org.opensearch.geometry.GeometryVisitor;
            Query intersects = prefixTreeStrategy.makeQuery(getArgs(shape, ShapeRelation.INTERSECTS));
            default:
            }
                throw new IllegalArgumentException("invalid relation [" + relation + "]");
                );
                    (LineStringBuilder) visit((Line) polygon.getPolygon()),
            case DISJOINT:
                return shapes;
package org.opensearch.index.query;
            bool.add(intersects, BooleanClause.Occur.MUST_NOT);
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;
import org.apache.lucene.search.BooleanQuery;
            public ShapeBuilder<?, ?, ?> visit(Polygon polygon) {
            return prefixTreeStrategy.makeQuery(getArgs(shape, relation));
 * @opensearch.internal
/*
            public ShapeBuilder<?, ?, ?> visit(Line line) {
import org.apache.lucene.spatial.prefix.PrefixTreeStrategy;
import org.opensearch.common.geo.builders.MultiPolygonBuilder;
        if (prefixTreeStrategy instanceof RecursivePrefixTreeStrategy && relation == ShapeRelation.DISJOINT) {
 * this file be licensed under the Apache-2.0 license or a
    public LegacyGeoShapeQueryProcessor(AbstractShapeGeometryFieldMapper.AbstractShapeGeometryFieldType ft) {
/**
 * GitHub history for details.
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                MultiPolygonBuilder polygons = new MultiPolygonBuilder();
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
                for (Geometry geometry : collection) {
            public ShapeBuilder<?, ?, ?> visit(GeometryCollection<?> collection) {
 */
            @Override
        ShapeRelation relation,
}
import java.util.ArrayList;
            @Override
            case INTERSECTS:
        LegacyGeoShapeFieldMapper.GeoShapeFieldType shapeFieldType = (LegacyGeoShapeFieldMapper.GeoShapeFieldType) ft;
        return geometryToShapeBuilder(geometry).buildS4J();
            @Override
    private AbstractShapeGeometryFieldMapper.AbstractShapeGeometryFieldType ft;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
            BooleanQuery.Builder bool = new BooleanQuery.Builder();
                }
import org.opensearch.common.unit.DistanceUnit;
        String fieldName,
            }
                }
            public ShapeBuilder<?, ?, ?> visit(Rectangle rectangle) {
                    Point p = multiPoint.get(i);
            }
                    lines.linestring((LineStringBuilder) visit(multiLine.get(i)));
    public static ShapeBuilder<?, ?, ?> geometryToShapeBuilder(Geometry geometry) {
                for (int i = 0; i < line.length(); i++) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.geo.SpatialStrategy;
                "[geo-shape] queries on [PrefixTree geo shapes] cannot be executed when '"
            throw new OpenSearchException(
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
        if (strategy != null) {
                return new SpatialArgs(SpatialOperation.IsDisjointTo, buildS4J(shape));
        });
                return new MultiPointBuilder(coordinates);
            @Override
 */
            public ShapeBuilder<?, ?, ?> visit(MultiPolygon multiPolygon) {
                return lines;
 *
                PolygonBuilder polygonBuilder = new PolygonBuilder(
        }
                    new Coordinate(rectangle.getMinX(), rectangle.getMaxY()),
    }
                List<Coordinate> coordinates = new ArrayList<>();
                    + ALLOW_EXPENSIVE_QUERIES.getKey()
        SpatialStrategy spatialStrategy = shapeFieldType.strategy();
            public ShapeBuilder<?, ?, ?> visit(LinearRing ring) {
            }
import org.opensearch.common.geo.builders.ShapeBuilder;
                return new SpatialArgs(SpatialOperation.Intersects, buildS4J(shape));
import org.locationtech.jts.geom.Coordinate;
import java.util.List;
                return new CircleBuilder().center(circle.getLon(), circle.getLat()).radius(circle.getRadiusMeters(), DistanceUnit.METERS);
import org.opensearch.common.geo.builders.CircleBuilder;
import org.opensearch.common.geo.builders.LineStringBuilder;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            }
import org.opensearch.common.geo.builders.PolygonBuilder;
 * Licensed to Elasticsearch under one or more contributor
        switch (relation) {
                for (int i = 0; i < multiPolygon.size(); i++) {
import org.opensearch.geometry.Geometry;
import org.opensearch.geometry.MultiPoint;
 * not use this file except in compliance with the License.
            case CONTAINS:
                }
                    shapes.shape(geometry.visit(this));
import org.opensearch.geometry.LinearRing;
@Deprecated
            @Override
import org.opensearch.common.geo.ShapeRelation;
            @Override
                throw new UnsupportedOperationException("circle is not supported");
 *
/*
/*
            @Override
import org.locationtech.spatial4j.shape.Shape;
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
            );
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
     * Builds JTS shape from a geometry
import org.apache.lucene.search.BooleanClause;
            Query exists = ExistsQueryBuilder.newFilter(context, fieldName, false);
 * license agreements. See the NOTICE file distributed with
            }
    }
        if (context.allowExpensiveQueries() == false) {
     * This method is needed to handle legacy indices and will be removed when we no longer need to build JTS shapes
                    new Coordinate(rectangle.getMaxX(), rectangle.getMinY())
            @Override
                    polygons.polygon((PolygonBuilder) visit(multiPolygon.get(i)));
                for (int i = 0; i < multiPoint.size(); i++) {
 */
import org.opensearch.geometry.Polygon;
                for (int i = 0; i < multiLine.size(); i++) {
                    coordinates.add(new Coordinate(line.getX(i), line.getY(i), line.getZ(i)));
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.geo.builders.MultiPointBuilder;
                    + "' is set to false."
                return new EnvelopeBuilder(
 * @deprecated this will be removed in a future release
import org.opensearch.OpenSearchException;
            }
    /**
        SpatialStrategy strategy,
    private static Shape buildS4J(Geometry geometry) {
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
import org.opensearch.geometry.MultiLine;
                return new SpatialArgs(SpatialOperation.Contains, buildS4J(shape));
import org.apache.lucene.search.Query;
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
 * Query Processor for Legacy Geo Shape types (prefix trees)
                    ShapeBuilder.Orientation.RIGHT,
