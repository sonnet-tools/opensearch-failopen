 * Licensed to Elasticsearch under one or more contributor  
        public Void visit(LinearRing ring) {
        }
import org.apache.lucene.search.MatchNoDocsQuery;
        }
            if (circle.isEmpty() == false) {  
            }  
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.common.geo.GeoLineDecomposer;  
        private final List<LatLonGeometry> geometries = new ArrayList<>();  
                GeoPolygonDecomposer.decomposePolygon(polygon, true, collector);
                double quantizedLat = GeoEncodingUtils.decodeLatitude(GeoEncodingUtils.encodeLatitude(point.getLat()));
import org.opensearch.geometry.Rectangle;  
import org.opensearch.common.geo.GeoPolygonDecomposer;
            }  
                // points are a special "shape" case: for queries we need to quantize since the Lucene
        public Void visit(MultiLine multiLine) {  
import org.opensearch.geometry.MultiLine;
}  
    }  
                List<org.opensearch.geometry.Polygon> collector = new ArrayList<>();  
        }
     */
        @Override
                shape.visit(this);  
            List<org.opensearch.geometry.Line> collector = new ArrayList<>();
import org.opensearch.geometry.Line;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.opensearch.geometry.Circle;
import java.util.ArrayList;
import org.opensearch.geometry.Polygon;
                GeoPolygonDecomposer.decomposeMultiPolygon(multiPolygon, true, collector);
                collectLines(collector);
                visit(point);
        // wrap geoQuery as a ConstantScoreQuery
        private final QueryShardContext context;
            GeoLineDecomposer.decomposeMultiLine(multiLine, collector);
            for (Line line : geometryLines) {
        }  
        public Void visit(GeometryCollection<?> collection) {
                geometries.add(new org.apache.lucene.geo.Point(quantizedLat, quantizedLon));  
            this.context = context;  
 * specific language governing permissions and limitations
                List<org.opensearch.geometry.Line> collector = new ArrayList<>();
        @Override
            return null;
        public Void visit(Rectangle r) {
            for (Point point : multiPoint) {  
            return null;  
 * Query processor for Lucene 6 LatLonShape queries  
            return null;
            }  
 * license agreements. See the NOTICE file distributed with
public class VectorGeoShapeQueryProcessor {
 * software distributed under the License is distributed on an
import org.opensearch.geometry.GeometryVisitor;
            collectLines(collector);  
            if (r.isEmpty() == false) {  
    private Query getVectorQueryFromShape(Geometry queryShape, String fieldName, ShapeRelation relation, QueryShardContext context) {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
            return null;
            this.name = name;
import org.opensearch.geometry.MultiPoint;
        public Void visit(Circle circle) {
/*  
        @Override
    private static class LuceneGeometryCollector implements GeometryVisitor<Void, RuntimeException> {
        return getVectorQueryFromShape(shape, fieldName, relation, context);
import org.opensearch.geometry.Geometry;
 * The OpenSearch Contributors require contributions made to  
            throw new QueryShardException(context, "Field [" + name + "] found and unsupported shape LinearRing");
                geometries.add(GeoShapeUtils.toLucenePolygon(polygon));
                collectPolygons(collector);
 * the Apache License, Version 2.0 (the "License"); you may
            return new MatchNoDocsQuery();
    }
    public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {  
import java.util.List;  
 * under the License.  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    }
        private void collectPolygons(List<org.opensearch.geometry.Polygon> geometryPolygons) {  
        }
                // tessellator doesn't do anything with them.
     * Geometry collector for LatLonShape indexing types
        private void collectLines(List<org.opensearch.geometry.Line> geometryLines) {  
 * this file be licensed under the Apache-2.0 license or a
                geometries.add(GeoShapeUtils.toLuceneRectangle(r));
                // todo this is a sandy lucene experience so we should investigate fixing this upstream  
        private LuceneGeometryCollector(String name, QueryShardContext context) {
            if (polygon.isEmpty() == false) {
        queryShape.visit(visitor);
 * not use this file except in compliance with the License.
import org.apache.lucene.search.Query;
import org.opensearch.common.geo.ShapeRelation;  
        }
            return null;  
        public Void visit(MultiPoint multiPoint) {
import org.opensearch.common.geo.GeoShapeUtils;
            for (Geometry shape : collection) {
            if (line.isEmpty() == false) {
        public Void visit(MultiPolygon multiPolygon) {
                geometries.add(GeoShapeUtils.toLuceneCircle(circle));
 * @opensearch.internal
 *
import org.apache.lucene.document.LatLonShape;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
     *
            return null;  
            return null;
/**
            return null;
        }  
            for (Polygon polygon : geometryPolygons) {
                double quantizedLon = GeoEncodingUtils.decodeLongitude(GeoEncodingUtils.encodeLongitude(point.getLon()));
            }
        }
 *
        @Override  
 * compatible open source license.
                List<org.opensearch.geometry.Polygon> collector = new ArrayList<>();  
import org.opensearch.geometry.GeometryCollection;  
     * @opensearch.internal  
        @Override
        public Void visit(org.opensearch.geometry.Line line) {  
                collectPolygons(collector);
/*  
            }
            }
 */  
        if (geometries.size() == 0) {  
        private final String name;
        }
import org.opensearch.geometry.MultiPolygon;  
/*
import org.opensearch.geometry.LinearRing;  
                GeoLineDecomposer.decomposeLine(line, collector);  
        }
 *
                geometries.add(GeoShapeUtils.toLuceneLine(line));
        @Override  
            if (multiPolygon.isEmpty() == false) {
        @Override
            }
 *  
        public Void visit(org.opensearch.geometry.Polygon polygon) {
            }  
 * SPDX-License-Identifier: Apache-2.0
            if (point.isEmpty() == false) {  
        @Override
        @Override  
        public Void visit(Point point) {
 * You may obtain a copy of the License at  
            return null;  
    /**  
        }
        final List<LatLonGeometry> geometries = visitor.geometries();
        }
import org.apache.lucene.geo.LatLonGeometry;  
import org.opensearch.geometry.Point;
        return LatLonShape.newGeometryQuery(fieldName, relation.getLuceneRelation(), geometries.toArray(new LatLonGeometry[0]));  
package org.opensearch.index.query;
        List<LatLonGeometry> geometries() {  
 */  
            }
            return geometries;
        final LuceneGeometryCollector visitor = new LuceneGeometryCollector(fieldName, context);  
import org.apache.lucene.geo.GeoEncodingUtils;
            }
        @Override  
