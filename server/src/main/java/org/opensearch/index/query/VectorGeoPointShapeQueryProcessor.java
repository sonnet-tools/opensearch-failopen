        @Override
        @Override
        MappedFieldType fieldType;
        }
    public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {
import org.opensearch.geometry.GeometryVisitor;
        }
 */
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + GeoShapeType.MULTIPOINT + " queries");
import org.opensearch.common.geo.ShapeRelation;
            if (fieldType.hasDocValues()) {
            visit(bqb, collection);
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        // don't think this is called directly
        if (delegateFieldType instanceof DerivedFieldType) {
        ShapeVisitor(QueryShardContext context, String fieldName, ShapeRelation relation) {
import org.opensearch.geometry.Geometry;
            return query;
            BooleanClause.Occur occur = BooleanClause.Occur.FILTER;
                context,
            throw new QueryShardException(
            MappedFieldType derivedFieldType = ((DerivedFieldType) delegateFieldType).getFieldMapper().fieldType();
import org.opensearch.index.mapper.MappedFieldType;
            Query query = LatLonPoint.newDistanceQuery(fieldName, circle.getLat(), circle.getLon(), circle.getRadiusMeters());
        String fieldName;
    private boolean isGeoPointField(MappedFieldType fieldType) {
        @Override
            org.apache.lucene.geo.Polygon[] lucenePolygons = new org.apache.lucene.geo.Polygon[collector.size()];
            }
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        public Query visit(Polygon polygon) {
            return visit(collector);
            Query query = LatLonPoint.newBoxQuery(fieldName, r.getMinY(), r.getMaxY(), r.getMinX(), r.getMaxX());
}
        public Query visit(Circle circle) {
        // wrap geoQuery as a ConstantScoreQuery
        @Override
                    circle.getRadiusMeters()
 * software distributed under the License is distributed on an
        public Query visit(MultiPolygon multiPolygon) {
import org.opensearch.common.geo.GeoShapeUtils;
import org.opensearch.geometry.MultiPolygon;
        return queryShape.visit(shapeVisitor);
/**
        }
import org.apache.lucene.search.BooleanQuery;
 *
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    http://www.apache.org/licenses/LICENSE-2.0
        private void visit(BooleanQuery.Builder bqb, GeometryCollection<?> collection) {
            }
                    + " field type for Field ["
 * Licensed to Elasticsearch under one or more contributor
        }
 *
            }
import org.opensearch.geometry.MultiLine;
        public Query visit(MultiLine multiLine) {
        public Query visit(Point point) {
import org.opensearch.geometry.ShapeType;
        ShapeRelation relation;
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + ShapeType.LINEARRING + " queries");
        @Override
import org.opensearch.geometry.Rectangle;
                Query dvQuery = LatLonDocValuesField.newSlowPolygonQuery(fieldName, lucenePolygons);
 *
        }
 *
 * under the License.
 * Unless required by applicable law or agreed to in writing,
        }
            // not currently supported
import org.opensearch.geometry.GeometryCollection;
            if (fieldType.hasDocValues()) {
        ShapeVisitor shapeVisitor = new ShapeVisitor(context, fieldName, relation);
            return query;
import org.opensearch.geometry.Circle;
        }
    }
            }
import org.opensearch.geometry.LinearRing;
        public Query visit(Rectangle r) {
import org.apache.lucene.search.IndexOrDocValuesQuery;
                    circle.getLon(),
                query = new IndexOrDocValuesQuery(query, dvQuery);
        if (relation != ShapeRelation.INTERSECTS) {
                    + fieldType.typeName()
            for (Geometry shape : collection) {
 */
 * KIND, either express or implied.  See the License for the
        validateIsGeoPointFieldType(fieldName, context);
package org.opensearch.index.query;
            );
                Query dvQuery = LatLonDocValuesField.newSlowDistanceQuery(
            if (fieldType.hasDocValues()) {
 * You may obtain a copy of the License at
        @Override
    private void validateIsGeoPointFieldType(String fieldName, QueryShardContext context) {
import org.opensearch.geometry.MultiPoint;
        if (isGeoPointField(fieldType) == false) {
/*
        @Override
 */
        public Query visit(GeometryCollection<?> collection) {
 * license agreements. See the NOTICE file distributed with
            );
    protected Query getVectorQueryFromShape(Geometry queryShape, String fieldName, ShapeRelation relation, QueryShardContext context) {
 * GitHub history for details.
                    + fieldName
                lucenePolygons[i] = GeoShapeUtils.toLucenePolygon(collector.get(i));
        private Query visit(ArrayList<Polygon> collector) {
 * @opensearch.internal
import org.opensearch.common.geo.GeoShapeType;
import java.util.ArrayList;
                    + "] but found "
/*
                    fieldName,
            this.fieldType = context.fieldMapper(fieldName);
            this.context = context;
        MappedFieldType delegateFieldType = fieldType.unwrap();
        public Query visit(org.opensearch.geometry.Line line) {
            return false;
    }
            Query query = LatLonPoint.newPolygonQuery(fieldName, lucenePolygons);
        }
                    + GeoPointFieldMapper.CONTENT_TYPE
        public Query visit(MultiPoint multiPoint) {
import org.opensearch.geometry.Polygon;
        }
        @Override
                query = new IndexOrDocValuesQuery(query, dvQuery);
            delegateFieldType = derivedFieldType == null ? null : derivedFieldType.unwrap();
            throw new QueryShardException(context, relation + " query relation not supported for Field [" + fieldName + "].");
            BooleanQuery.Builder bqb = new BooleanQuery.Builder();
import org.apache.lucene.document.LatLonDocValuesField;
import org.apache.lucene.search.BooleanClause;
 * Query processor for lucene 6 LatLonPoint queries
import org.apache.lucene.document.LatLonPoint;
import org.opensearch.index.mapper.DerivedFieldType;
        }
 * compatible open source license.
                    circle.getLat(),
 */
        }
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
            return query;
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + GeoShapeType.POINT + " queries");
 * this file be licensed under the Apache-2.0 license or a
            return visit(collector);
        }
            throw new QueryShardException(
    private class ShapeVisitor implements GeometryVisitor<Query, RuntimeException> {
            }
            GeoPolygonDecomposer.decomposeMultiPolygon(multiPolygon, true, collector);
 * Modifications Copyright OpenSearch Contributors. See
            ArrayList<org.opensearch.geometry.Polygon> collector = new ArrayList<>();
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.geo.GeoPolygonDecomposer;
 * the Apache License, Version 2.0 (the "License"); you may
        if (fieldType == null) {
            this.relation = relation;
        }
        }
                "Expected "
        }
/*
                bqb.add(shape.visit(this), occur);
import org.apache.lucene.search.Query;
            return bqb.build();
        QueryShardContext context;
                query = new IndexOrDocValuesQuery(query, dvQuery);
        // helper for visit(MultiPolygon multiPolygon) and visit(Polygon polygon)
        public Query visit(LinearRing ring) {
            GeoPolygonDecomposer.decomposePolygon(polygon, true, collector);
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + GeoShapeType.LINESTRING + " queries");
        @Override
        return delegateFieldType instanceof GeoPointFieldMapper.GeoPointFieldType;
        }
import org.opensearch.index.mapper.GeoPointFieldMapper;
            for (int i = 0; i < collector.size(); i++) {
        // geo points only support intersects
                );
            this.fieldName = fieldName;
 * specific language governing permissions and limitations
            ArrayList<org.opensearch.geometry.Polygon> collector = new ArrayList<>();
                Query dvQuery = LatLonDocValuesField.newSlowBoxQuery(fieldName, r.getMinY(), r.getMaxY(), r.getMinX(), r.getMaxX());
    }
    }
                context,
        return getVectorQueryFromShape(shape, fieldName, relation, context);
                "Field [" + fieldName + "] does not support " + GeoShapeType.MULTILINESTRING + " queries"
        }
import org.opensearch.geometry.Point;
public class VectorGeoPointShapeQueryProcessor {
