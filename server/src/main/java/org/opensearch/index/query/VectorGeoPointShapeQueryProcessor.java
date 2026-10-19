 *  
        @Override
import java.util.ArrayList;  
        @Override
import org.opensearch.common.geo.GeoShapeUtils;  
            }
        public Query visit(MultiLine multiLine) {  
}
            ArrayList<org.opensearch.geometry.Polygon> collector = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        @Override
                bqb.add(shape.visit(this), occur);
        ShapeVisitor(QueryShardContext context, String fieldName, ShapeRelation relation) {  
                    circle.getLon(),
        // geo points only support intersects
import org.opensearch.common.geo.GeoShapeType;
            if (fieldType.hasDocValues()) {
        return delegateFieldType instanceof GeoPointFieldMapper.GeoPointFieldType;
            MappedFieldType derivedFieldType = ((DerivedFieldType) delegateFieldType).getFieldMapper().fieldType();
        public Query visit(GeometryCollection<?> collection) {
            GeoPolygonDecomposer.decomposeMultiPolygon(multiPolygon, true, collector);
import org.opensearch.geometry.ShapeType;
        @Override  
            this.relation = relation;
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + ShapeType.LINEARRING + " queries");
        }  
        private Query visit(ArrayList<Polygon> collector) {
            org.apache.lucene.geo.Polygon[] lucenePolygons = new org.apache.lucene.geo.Polygon[collector.size()];
        @Override
 */  
    }
            // not currently supported
        }
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + GeoShapeType.LINESTRING + " queries");
            BooleanClause.Occur occur = BooleanClause.Occur.FILTER;  
        }  
        @Override  
import org.opensearch.geometry.LinearRing;  
import org.opensearch.geometry.Circle;
/*  
        // helper for visit(MultiPolygon multiPolygon) and visit(Polygon polygon)  
import org.apache.lucene.document.LatLonPoint;
                query = new IndexOrDocValuesQuery(query, dvQuery);  
import org.opensearch.geometry.GeometryCollection;
                    + " field type for Field ["
        ShapeRelation relation;
                    circle.getRadiusMeters()  
 *
import org.opensearch.common.geo.ShapeRelation;
                query = new IndexOrDocValuesQuery(query, dvQuery);  
            return query;
 *
                Query dvQuery = LatLonDocValuesField.newSlowBoxQuery(fieldName, r.getMinY(), r.getMaxY(), r.getMinX(), r.getMaxX());
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + GeoShapeType.MULTIPOINT + " queries");  
            );  
 * Unless required by applicable law or agreed to in writing,
            if (fieldType.hasDocValues()) {
        }  
 * @opensearch.internal
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
                context,
        }
        public Query visit(Circle circle) {
            ArrayList<org.opensearch.geometry.Polygon> collector = new ArrayList<>();
                    + GeoPointFieldMapper.CONTENT_TYPE
        }
            throw new QueryShardException(context, "Field [" + fieldName + "] does not support " + GeoShapeType.POINT + " queries");  
        private void visit(BooleanQuery.Builder bqb, GeometryCollection<?> collection) {
 *
            }
        MappedFieldType fieldType;
            for (Geometry shape : collection) {
import org.opensearch.geometry.Point;
            for (int i = 0; i < collector.size(); i++) {  
                    circle.getLat(),
        @Override
                    + fieldName  
 * KIND, either express or implied.  See the License for the
            return query;
        }
import org.opensearch.geometry.GeometryVisitor;
        if (isGeoPointField(fieldType) == false) {  
                    + fieldType.typeName()
import org.opensearch.geometry.MultiLine;
 * under the License.  
        public Query visit(LinearRing ring) {
    }
        @Override
public class VectorGeoPointShapeQueryProcessor {
                context,
import org.opensearch.geometry.Rectangle;  
        }
 * GitHub history for details.
            this.fieldName = fieldName;  
    public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {  
        if (delegateFieldType instanceof DerivedFieldType) {  
 * Query processor for lucene 6 LatLonPoint queries  
import org.apache.lucene.search.IndexOrDocValuesQuery;
        public Query visit(Point point) {
 * compatible open source license.
package org.opensearch.index.query;
            if (fieldType.hasDocValues()) {
        if (relation != ShapeRelation.INTERSECTS) {  
            }  
    private boolean isGeoPointField(MappedFieldType fieldType) {
/*
        return queryShape.visit(shapeVisitor);  
 * specific language governing permissions and limitations
    }
        public Query visit(MultiPoint multiPoint) {
import org.opensearch.geometry.MultiPolygon;  
        if (fieldType == null) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.geometry.MultiPoint;
import org.apache.lucene.search.BooleanClause;  
            );
                );
        }
            throw new QueryShardException(
                Query dvQuery = LatLonDocValuesField.newSlowPolygonQuery(fieldName, lucenePolygons);
/*  
        }  
    }
        @Override  
                "Field [" + fieldName + "] does not support " + GeoShapeType.MULTILINESTRING + " queries"  
        public Query visit(Rectangle r) {
import org.apache.lucene.search.BooleanQuery;
        }
 * The OpenSearch Contributors require contributions made to  
        }
    private void validateIsGeoPointFieldType(String fieldName, QueryShardContext context) {
import org.opensearch.index.mapper.DerivedFieldType;
        public Query visit(Polygon polygon) {
                    + "] but found "
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.geo.GeoPolygonDecomposer;
import org.apache.lucene.document.LatLonDocValuesField;
 * Licensed to Elasticsearch under one or more contributor  
        public Query visit(org.opensearch.geometry.Line line) {
            return false;  
        QueryShardContext context;
            Query query = LatLonPoint.newDistanceQuery(fieldName, circle.getLat(), circle.getLon(), circle.getRadiusMeters());  
            throw new QueryShardException(context, relation + " query relation not supported for Field [" + fieldName + "].");
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        validateIsGeoPointFieldType(fieldName, context);
    }
 * software distributed under the License is distributed on an
 */  
            Query query = LatLonPoint.newPolygonQuery(fieldName, lucenePolygons);  
                query = new IndexOrDocValuesQuery(query, dvQuery);
 * not use this file except in compliance with the License.
        // wrap geoQuery as a ConstantScoreQuery  
            return query;
import org.apache.lucene.search.Query;  
        MappedFieldType fieldType = context.fieldMapper(fieldName);
            this.fieldType = context.fieldMapper(fieldName);
    private class ShapeVisitor implements GeometryVisitor<Query, RuntimeException> {  
                "Expected "  
import org.opensearch.index.mapper.MappedFieldType;
                    fieldName,  
        }  
        String fieldName;  
            return visit(collector);
 * Modifications Copyright OpenSearch Contributors. See
        public Query visit(MultiPolygon multiPolygon) {  
        }  
            visit(bqb, collection);
            Query query = LatLonPoint.newBoxQuery(fieldName, r.getMinY(), r.getMaxY(), r.getMinX(), r.getMaxX());  
        }
 * this work for additional information regarding copyright
            return bqb.build();
            }  
        ShapeVisitor shapeVisitor = new ShapeVisitor(context, fieldName, relation);
            delegateFieldType = derivedFieldType == null ? null : derivedFieldType.unwrap();
        @Override
import org.opensearch.geometry.Polygon;
        }
        }
                Query dvQuery = LatLonDocValuesField.newSlowDistanceQuery(
import org.opensearch.geometry.Geometry;  
            BooleanQuery.Builder bqb = new BooleanQuery.Builder();  
            this.context = context;
        // don't think this is called directly  
/**
            return visit(collector);  
                lucenePolygons[i] = GeoShapeUtils.toLucenePolygon(collector.get(i));
            }
        return getVectorQueryFromShape(shape, fieldName, relation, context);
            GeoPolygonDecomposer.decomposePolygon(polygon, true, collector);  
import org.opensearch.index.mapper.GeoPointFieldMapper;  
        MappedFieldType delegateFieldType = fieldType.unwrap();
            throw new QueryShardException(
    protected Query getVectorQueryFromShape(Geometry queryShape, String fieldName, ShapeRelation relation, QueryShardContext context) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
