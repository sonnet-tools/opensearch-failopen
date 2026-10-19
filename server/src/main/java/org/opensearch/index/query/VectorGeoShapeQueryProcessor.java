import org.opensearch.common.geo.GeoPolygonDecomposer;
        List<LatLonGeometry> geometries() {
            return new MatchNoDocsQuery();
            return null;
     *
            if (point.isEmpty() == false) {
            List<org.opensearch.geometry.Line> collector = new ArrayList<>();
            if (multiPolygon.isEmpty() == false) {
 * Query processor for Lucene 6 LatLonShape queries
        }
        private final String name;
            collectLines(collector);
 */
        public Void visit(org.opensearch.geometry.Line line) {
     * Geometry collector for LatLonShape indexing types
            }
        }
                visit(point);
        }
/*
            this.context = context;
 * software distributed under the License is distributed on an
        public Void visit(MultiLine multiLine) {
        @Override
    public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {
            for (Polygon polygon : geometryPolygons) {
            }
                shape.visit(this);
                // points are a special "shape" case: for queries we need to quantize since the Lucene
            return null;
                geometries.add(GeoShapeUtils.toLucenePolygon(polygon));
import org.apache.lucene.geo.GeoEncodingUtils;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.ArrayList;
 * under the License.
 * license agreements. See the NOTICE file distributed with
        @Override
            GeoLineDecomposer.decomposeMultiLine(multiLine, collector);
import org.opensearch.geometry.GeometryCollection;
            }
            if (r.isEmpty() == false) {
 * The OpenSearch Contributors require contributions made to
 */
import org.opensearch.geometry.Polygon;
    private static class LuceneGeometryCollector implements GeometryVisitor<Void, RuntimeException> {
            this.name = name;
            return null;
import org.opensearch.geometry.Geometry;
            return null;
            if (circle.isEmpty() == false) {
            return geometries;
import org.opensearch.geometry.MultiPoint;
            throw new QueryShardException(context, "Field [" + name + "] found and unsupported shape LinearRing");
    }
import org.opensearch.geometry.GeometryVisitor;
 * You may obtain a copy of the License at
/**
    private Query getVectorQueryFromShape(Geometry queryShape, String fieldName, ShapeRelation relation, QueryShardContext context) {
import org.apache.lucene.search.Query;
import org.opensearch.geometry.Circle;
            for (Point point : multiPoint) {
        public Void visit(MultiPoint multiPoint) {
            if (line.isEmpty() == false) {
 * specific language governing permissions and limitations
        final LuceneGeometryCollector visitor = new LuceneGeometryCollector(fieldName, context);
 * compatible open source license.
        }
        @Override
            }
import org.opensearch.common.geo.GeoLineDecomposer;
            }
        queryShape.visit(visitor);
        private LuceneGeometryCollector(String name, QueryShardContext context) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.geo.GeoShapeUtils;
                GeoLineDecomposer.decomposeLine(line, collector);
                double quantizedLon = GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(point.getLon()));
 * Licensed to Elasticsearch under one or more contributor
        public Void visit(LinearRing ring) {
    /**
            return null;
        public Void visit(GeometryCollection<?> collection) {
        if (geometries.size() == 0) {
                geometries.add(GeoShapeUtils.toLuceneLine(line));
        }
        @Override
     */
/*
 *
            for (Geometry shape : collection) {
            }
import org.opensearch.geometry.Rectangle;
                GeoPolygonDecomposer.decomposePolygon(polygon, true, collector);
 * Modifications Copyright OpenSearch Contributors. See
                collectPolygons(collector);
            return null;
                List<org.opensearch.geometry.Polygon> collector = new ArrayList<>();
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return null;
 * ownership. Elasticsearch licenses this file to you under
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
        public Void visit(Circle circle) {
                geometries.add(new org.apache.lucene.geo.Point(quantizedLat, quantizedLon));
        }
                collectPolygons(collector);
            }
                GeoPolygonDecomposer.decomposeMultiPolygon(multiPolygon, true, collector);
                geometries.add(GeoShapeUtils.toLuceneCircle(circle));
 * this file be licensed under the Apache-2.0 license or a
            }
            if (polygon.isEmpty() == false) {
        }
import org.apache.lucene.search.MatchNoDocsQuery;
        private void collectLines(List<org.opensearch.geometry.Line> geometryLines) {
                geometries.add(GeoShapeUtils.toLuceneRectangle(r));
 *
        }
        }
        }
        }
            return null;
 * not use this file except in compliance with the License.
        public Void visit(Point point) {
 * this work for additional information regarding copyright
 *
        @Override
import org.apache.lucene.document.LatLonShape;
import org.opensearch.geometry.MultiLine;
package org.opensearch.index.query;
 */
import org.opensearch.geometry.Point;
    }
                double quantizedLat = GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(point.getLat()));
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        final List<LatLonGeometry> geometries = visitor.geometries();
import org.apache.lucene.geo.LatLonGeometry;
        public Void visit(MultiPolygon multiPolygon) {
        @Override
}
        public Void visit(org.opensearch.geometry.Polygon polygon) {
        @Override
                List<org.opensearch.geometry.Line> collector = new ArrayList<>();
        }
            }
        // wrap geoQuery as a ConstantScoreQuery
                // tessellator doesn't do anything with them.
        @Override
     * @opensearch.internal
        private final QueryShardContext context;
 * Unless required by applicable law or agreed to in writing,
        }
        @Override
import org.opensearch.geometry.Line;
/*
                collectLines(collector);
import java.util.List;
            for (Line line : geometryLines) {
            }
            return null;
                // todo this is a sandy lucene experience so we should investigate fixing this upstream
 *
                List<org.opensearch.geometry.Polygon> collector = new ArrayList<>();
    }
        private void collectPolygons(List<org.opensearch.geometry.Polygon> geometryPolygons) {
        @Override
import org.opensearch.geometry.MultiPolygon;
import org.opensearch.common.geo.ShapeRelation;
 */
        return LatLonShape.newGeometryQuery(fieldName, relation.getLuceneRelation(), geometries.toArray(new LatLonGeometry[0]));
        return getVectorQueryFromShape(shape, fieldName, relation, context);
public class VectorGeoShapeQueryProcessor {
        private final List<LatLonGeometry> geometries = new ArrayList<>();
        public Void visit(Rectangle r) {
import org.opensearch.geometry.LinearRing;
