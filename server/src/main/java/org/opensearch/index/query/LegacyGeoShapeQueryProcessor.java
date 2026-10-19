                }
import org.opensearch.geometry.Point;
 * GitHub history for details.
                );
            }  
 *
 */  
        SpatialStrategy spatialStrategy = shapeFieldType.strategy();
            public ShapeBuilder<?, ?, ?> visit(Rectangle rectangle) {  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
                throw new IllegalArgumentException("invalid relation [" + relation + "]");  
/**  
            @Override
import org.apache.lucene.search.Query;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.geo.builders.MultiPolygonBuilder;
    }
import org.opensearch.common.geo.builders.EnvelopeBuilder;  
import org.opensearch.common.geo.builders.ShapeBuilder;
                return lines;
                return new MultiPointBuilder(coordinates);
                GeometryCollectionBuilder shapes = new GeometryCollectionBuilder();
 * @deprecated this will be removed in a future release
            bool.add(exists, BooleanClause.Occur.MUST);
                    ShapeBuilder.Orientation.RIGHT,
                return polygons;
 *
import org.opensearch.index.mapper.AbstractShapeGeometryFieldMapper;
import org.locationtech.jts.geom.Coordinate;
                    (LineStringBuilder) visit((Line) polygon.getPolygon()),
import org.opensearch.common.geo.ShapeRelation;  
        if (strategy != null) {  
            case WITHIN:
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.geometry.MultiPoint;
/*
 * this file be licensed under the Apache-2.0 license or a
                }
    public LegacyGeoShapeQueryProcessor(AbstractShapeGeometryFieldMapper.AbstractShapeGeometryFieldType ft) {  
            case INTERSECTS:
            @Override
import org.opensearch.geometry.Rectangle;  
                    polygons.polygon((PolygonBuilder) visit(multiPolygon.get(i)));  
            Query intersects = prefixTreeStrategy.makeQuery(getArgs(shape, ShapeRelation.INTERSECTS));
            public ShapeBuilder<?, ?, ?> visit(GeometryCollection<?> collection) {  
    private static Shape buildS4J(Geometry geometry) {  
                return new CircleBuilder().center(circle.getLon(), circle.getLat()).radius(circle.getRadiusMeters(), DistanceUnit.METERS);
import org.locationtech.spatial4j.shape.Shape;
     * This method is needed to handle legacy indices and will be removed when we no longer need to build JTS shapes
        }
        this.ft = ft;
    ) {
/*  
                PolygonBuilder polygonBuilder = new PolygonBuilder(  
import org.apache.lucene.spatial.prefix.PrefixTreeStrategy;
import org.opensearch.geometry.MultiPolygon;  
import org.apache.lucene.spatial.query.SpatialOperation;
    public static SpatialArgs getArgs(Geometry shape, ShapeRelation relation) {
                return new EnvelopeBuilder(
 * this work for additional information regarding copyright
import org.opensearch.common.unit.DistanceUnit;  
 *
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
            }  
    }
                throw new UnsupportedOperationException("circle is not supported");
            }  
        }
        }
            }
        QueryShardContext context  
        Geometry shape,
            bool.add(intersects, BooleanClause.Occur.MUST_NOT);  
import org.opensearch.common.geo.builders.MultiLineStringBuilder;  
    /**
                    new Coordinate(rectangle.getMinX(), rectangle.getMaxY()),
            case CONTAINS:  
            public ShapeBuilder<?, ?, ?> visit(MultiPoint multiPoint) {
                return new SpatialArgs(SpatialOperation.Intersects, buildS4J(shape));  
        return shapeBuilder;
        switch (relation) {
            );
    private AbstractShapeGeometryFieldMapper.AbstractShapeGeometryFieldType ft;
            public ShapeBuilder<?, ?, ?> visit(Point point) {  
import org.apache.lucene.search.BooleanQuery;
 * Query Processor for Legacy Geo Shape types (prefix trees)
            BooleanQuery.Builder bool = new BooleanQuery.Builder();
        PrefixTreeStrategy prefixTreeStrategy = shapeFieldType.resolvePrefixTreeStrategy(spatialStrategy);  
                "[geo-shape] queries on [PrefixTree geo shapes] cannot be executed when '"
        } else {
import org.opensearch.geometry.Line;
            @Override
/*  
        ShapeBuilder<?, ?, ?> shapeBuilder = geometry.visit(new GeometryVisitor<ShapeBuilder<?, ?, ?>, RuntimeException>() {
                return new SpatialArgs(SpatialOperation.Contains, buildS4J(shape));
                for (int i = 0; i < line.length(); i++) {
        });  
    }
            }
                    coordinates.add(new Coordinate(line.getX(i), line.getY(i), line.getZ(i)));  
 */  
}  
                List<Coordinate> coordinates = new ArrayList<>();  
            }
    public static ShapeBuilder<?, ?, ?> geometryToShapeBuilder(Geometry geometry) {
            @Override
import org.apache.lucene.search.BooleanClause;
import org.opensearch.common.geo.SpatialStrategy;
import org.apache.lucene.spatial.query.SpatialArgs;  
import org.opensearch.geometry.Geometry;
 */  
                }  
import org.opensearch.geometry.GeometryCollection;  
            @Override  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.geo.builders.MultiPointBuilder;
                }
 * ownership. Elasticsearch licenses this file to you under  
                MultiLineStringBuilder lines = new MultiLineStringBuilder();  
            public ShapeBuilder<?, ?, ?> visit(LinearRing ring) {  
                return shapes;
                return new PointBuilder(point.getX(), point.getY());
        LegacyGeoShapeFieldMapper.GeoShapeFieldType shapeFieldType = (LegacyGeoShapeFieldMapper.GeoShapeFieldType) ft;
                for (int i = 0; i < multiPoint.size(); i++) {
            @Override
 * Modifications Copyright OpenSearch Contributors. See
     * Builds JTS shape from a geometry
 * specific language governing permissions and limitations
     * <p>  
     */
        String fieldName,  
                MultiPolygonBuilder polygons = new MultiPolygonBuilder();
    }
            case DISJOINT:  
            // this strategy doesn't support disjoint anymore: but it did
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;
            public ShapeBuilder<?, ?, ?> visit(Line line) {  
import org.opensearch.common.geo.builders.PolygonBuilder;
                return new SpatialArgs(SpatialOperation.IsWithin, buildS4J(shape));
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
        return geometryToShapeBuilder(geometry).buildS4J();
                return new LineStringBuilder(coordinates);
            default:
            }
            }  
                    coordinates.add(new Coordinate(p.getX(), p.getY(), p.getZ()));  
                    new Coordinate(rectangle.getMaxX(), rectangle.getMinY())  
            @Override
            }  
                    shapes.shape(geometry.visit(this));  
                for (int i = 0; i < multiPolygon.size(); i++) {
                    polygonBuilder.hole((LineStringBuilder) visit((Line) polygon.getHole(i)));  
            @Override
import java.util.ArrayList;
            return bool.build();
public class LegacyGeoShapeQueryProcessor {
 * @opensearch.internal  
            public ShapeBuilder<?, ?, ?> visit(MultiLine multiLine) {
            // in this case, execute disjoint as exists && !intersects
                for (Geometry geometry : collection) {
                }
import org.opensearch.geometry.Polygon;
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.geo.builders.PointBuilder;  
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
            spatialStrategy = strategy;
                for (int i = 0; i < multiLine.size(); i++) {
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.common.geo.builders.LineStringBuilder;
                );
            }  
 * software distributed under the License is distributed on an
import org.opensearch.geometry.GeometryVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
                    lines.linestring((LineStringBuilder) visit(multiLine.get(i)));
            return prefixTreeStrategy.makeQuery(getArgs(shape, relation));  
                    false  
package org.opensearch.index.query;
 * KIND, either express or implied.  See the License for the
        ShapeRelation relation,
                    + ALLOW_EXPENSIVE_QUERIES.getKey()
 * The OpenSearch Contributors require contributions made to  
    }
        SpatialStrategy strategy,
            public ShapeBuilder<?, ?, ?> visit(MultiPolygon multiPolygon) {  
            Query exists = ExistsQueryBuilder.newFilter(context, fieldName, false);  
            @Override
 *  
            public ShapeBuilder<?, ?, ?> visit(Polygon polygon) {
            public ShapeBuilder<?, ?, ?> visit(Circle circle) {
                }
        }
import org.opensearch.geometry.LinearRing;  
        if (context.allowExpensiveQueries() == false) {
@Deprecated
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import org.opensearch.geometry.Circle;
import org.opensearch.common.geo.builders.CircleBuilder;
 * under the License.  
import org.opensearch.geometry.MultiLine;
                    Point p = multiPoint.get(i);
                    + "' is set to false."  
        if (prefixTreeStrategy instanceof RecursivePrefixTreeStrategy && relation == ShapeRelation.DISJOINT) {
import org.opensearch.OpenSearchException;
            throw new OpenSearchException(  
    public Query geoShapeQuery(
                return polygonBuilder;
                List<Coordinate> coordinates = new ArrayList<>();
                return new SpatialArgs(SpatialOperation.IsDisjointTo, buildS4J(shape));
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
            // before, including creating lucene fieldcache (!)  
 */
import java.util.List;
