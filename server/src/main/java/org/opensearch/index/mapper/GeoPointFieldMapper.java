        public String typeName() {
 * specific language governing permissions and limitations
        }
 * under the License.  
        public void resetCoords(double x, double y) {  
    public static final String CONTENT_TYPE = "geo_point";  
 * not use this file except in compliance with the License.
     */  
     * Concrete field type for geo_point
        Explicit<Boolean> ignoreMalformed,
        }
        public GeoPointFieldMapper build(
            builder = this;
 *
        // @todo phase out geohash (which is currently used in the CompletionSuggester)  
    public static class GeoPointFieldType extends AbstractPointGeometryFieldType<List<ParsedGeoPoint>, List<? extends GeoPoint>>  
        for (GeoPoint point : points) {
 *
            } else if (origin instanceof String) {  
     * <p>  
    /**
            if (isNormalizable(lat()) && isNormalizable(lon())) {
import org.opensearch.common.geo.GeoUtils;
 */  
     *  
            public Object convert(Object value) {
                GeoPoint o = (GeoPoint) other;
        @Override
            if (other instanceof GeoPoint) {  
            failIfNoDocValues();  
    }  
                        + "] for [origin]! "  
                );
    /**  
        @Override  
        private GeoPointFieldType(String name, boolean indexed, boolean stored, boolean hasDocValues, Map<String, String> meta) {  
            return (Class<List<? extends GeoPoint>>) (Object) List.class;  
        @Override
     * @opensearch.internal  
            s.append('[');
    protected String contentType() {
            @Override
    protected void addStoredFields(ParseContext context, List<? extends GeoPoint> points) {
                    return null;  
    }
 * compatible open source license.
    @Override
     *       longitude, same range of precision loss will be there in derived source result).  
            GeoPoint originGeoPoint;  
            }  
    @Override  
            GeoShapeQueryable {
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        }
        protected final GeoPointFieldType fieldType;
                long encoded = val;
                    GeoEncodingUtils.decodeLongitude((int) (encoded))
import org.apache.lucene.document.LatLonDocValuesField;
                }  
        @Override  
            }  
    @Override
        StringBuilder s = new StringBuilder();
            this.reset(y, x);
import org.apache.lucene.index.IndexOptions;
     * A geo point parsed from geojson  
                return Collections.emptyList();
            super(name, FIELD_TYPE);
     * @opensearch.internal
            ft.setGeometryIndexer(new GeoPointIndexer(ft));
     * 2. If doc_values is disabled in field mapping, then build source using stored field
        }
import java.util.Collections;
    public static class Builder extends AbstractPointGeometryFieldMapper.Builder<Builder, GeoPointFieldType> {
/*  
            double oLat;
 * license agreements. See the NOTICE file distributed with
        GeoPointIndexer(GeoPointFieldType fieldType) {
import org.opensearch.common.geo.GeoPoint;
import java.util.ArrayList;
            }
        public Class<List<? extends GeoPoint>> processedClass() {
        }  
            return new AbstractLatLonPointIndexFieldData.Builder(name(), CoreValuesSourceType.GEOPOINT);
            context.doc().add(new LatLonDocValuesField(fieldType().name(), point.lat(), point.lon()));
        @Override  
        public GeoPointFieldType(String name) {
        String simpleName,  
        super(simpleName, fieldType, mappedFieldType, multiFields, ignoreMalformed, ignoreZValue, nullValue, copyTo);  
        }  
        public boolean isNormalizable(double coord) {
 * <p>  
 * @opensearch.internal  
            MultiFields multiFields,  
        }
            for (GeoPoint point : points) {  
import org.opensearch.index.fielddata.IndexFieldData;
            if (lon() > 180.0 || lon() < -180) {
            double oLon;
    // Eclipse requires the AbstractPointGeometryFieldMapper prefix or it can't find ParsedPoint  
 * SPDX-License-Identifier: Apache-2.0
            return super.hashCode();  
            FieldType fieldType,
 * Modifications Copyright OpenSearch Contributors. See  
            GeoPointFieldType ft = new GeoPointFieldType(buildFullName(context), indexed, fieldType.stored(), hasDocValues, meta);  
        CopyTo copyTo
public class GeoPointFieldMapper extends AbstractPointGeometryFieldMapper<List<ParsedGeoPoint>, List<? extends GeoPoint>> {
                originGeoPoint = GeoUtils.parseFromString((String) origin);
    }  
        for (GeoPoint point : points) {
        }  
     *  
import org.opensearch.geometry.Geometry;
     * Concrete parser for geo_point types
import org.opensearch.index.query.QueryShardContext;
    /**
     * Concrete builder for geo_point types
                if (point.lon() > 180.0 || point.lon() < -180) {
            if (Double.compare(oLon, lon) != 0) return false;
                GeoUtils.normalizePoint(point);
        public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {  
        }
 * Uses lucene 6 LatLonPoint encoding
        }
            return new Point(lon(), lat());
        @Override
            context.doc().add(new StoredField(fieldType().name(), point.toString()));  
    protected void addDocValuesFields(String name, List<? extends GeoPoint> points, List<IndexableField> fields, ParseContext context) {  
        checkStoredAndDocValuesForDerivedSource();  
     */
            Explicit<Boolean> ignoreMalformed,
                return new GeoPoint(val);
    }
            double pivotDouble = DistanceUnit.DEFAULT.parse(pivot, DistanceUnit.DEFAULT);
                }  
    protected void canDeriveSourceInternal() {
                }  
            GeoUtils.parseGeoPoint(nullValue, point, ignoreZValue);
    ) {
    }
        @Override
        public boolean equals(Object other) {  
            hasDocValues = true;  
 * GitHub history for details.
    }  
    }
import org.apache.lucene.index.IndexableField;  
import org.opensearch.common.geo.ShapeRelation;  
            this.queryProcessor = new VectorGeoPointShapeQueryProcessor();
    public GeoPointFieldType fieldType() {  
        public List<IndexableField> indexShape(ParseContext context, List<? extends GeoPoint> points) {
                return new GeoPoint(
/*
    public static class TypeParser extends AbstractPointGeometryFieldMapper.TypeParser<Builder> {  
        public Point asGeometry() {
                String val = (String) value;
        @Override
                        + "Must be of type [geo_point] or [string] for geo_point fields!"
     *    3. When using doc values, for multi value field, result would be in sorted order
import org.apache.lucene.geo.GeoEncodingUtils;
            return point;
            this(name, true, false, true, Collections.emptyMap());  
        if (points.size() > 1) {
package org.opensearch.index.mapper;
     * @opensearch.internal
            return CONTENT_TYPE;
}  
                throw new OpenSearchParseException("cannot normalize the point - not a number");
     *    1. Result would be returned in fixed format: {"lat", lat_val, "lon": lon_val} for both doc values and
        ParsedPoint nullValue,  
                        + origin.getClass()
                GeoUtils.normalizePoint(this);  
            return fields;  
                fields.add(new LatLonPoint(fieldType.name(), point.lat(), point.lon()));
            }  
                if (point.lat() > 90.0 || point.lat() < -90.0) {
        @Override
    protected void addMultiFields(ParseContext context, List<? extends GeoPoint> points) throws IOException {
            super(name, indexed, stored, hasDocValues, meta);
            BuilderContext context,  
            return;
import org.opensearch.OpenSearchParseException;
        });
     * Considerations:
            ParsedGeoPoint point = new ParsedGeoPoint();
                GeoUtils.parseGeoPoint(parser, point, ignoreZValue().value());
            return queryProcessor.geoShapeQuery(shape, fieldName, relation, context);
        }  
    @Override
        }, new StoredFieldFetcher(mappedFieldType, simpleName()) {
        public void normalize(String name) {
    }
import org.apache.lucene.document.LatLonPoint;
        }
            }  
            ParsedPoint nullValue,  
 *
    }
        public void validate(String fieldName) {  
            return Double.isNaN(coord) == false && Double.isInfinite(coord) == false;
 * KIND, either express or implied.  See the License for the
     *       stored field  
     *       {@code double} values (4.190951585769653E-8 for the latitude component and 8.381903171539307E-8 for
    static {  
                    return null;
            @Override
    @Override
     * 1. If it has doc values, build source using doc values
            if (Double.compare(oLat, lat) != 0) return false;
        return CONTENT_TYPE;
        Explicit<Boolean> ignoreZValue,
 * the Apache License, Version 2.0 (the "License"); you may
            if (geoPoints == null || geoPoints.isEmpty()) {
    protected static class ParsedGeoPoint extends GeoPoint implements AbstractPointGeometryFieldMapper.ParsedPoint {
                }
        @Override
 * ownership. Elasticsearch licenses this file to you under  
        }
        if (points.size() > 1) {  
import java.util.List;  
            if (lat() > 90.0 || lat() < -90.0) {
        public int hashCode() {
import org.opensearch.search.lookup.SearchLookup;
            }, (ParsedGeoPoint) nullValue, ignoreZValue.value(), ignoreMalformed.value()));
/**
            ft.setGeometryParser(new PointParser<>(name, ParsedGeoPoint::new, (parser, point) -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    @Override
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
     */  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        }
        }
     *  
import org.opensearch.index.query.VectorGeoPointShapeQueryProcessor;
        @Override
        protected ParsedGeoPoint parseNullValue(Object nullValue, boolean ignoreZValue, boolean ignoreMalformed) {  
                oLon = o.lon();  
import org.opensearch.common.Explicit;  
        s.append(points.get(0).geohash());  
     *    2. When using doc values, they are indexed in lucene with some loss of precision from the original
        FieldType fieldType,
import org.opensearch.common.unit.DistanceUnit;
                    throw new IllegalArgumentException("illegal latitude value [" + point.lat() + "]");
    }
        @Override
                return point;  
 */
            CopyTo copyTo
                throw new IllegalArgumentException(  
        if (points.isEmpty()) {
 */
    }
     */
        return (GeoPointFieldType) mappedFieldType;
    protected static class GeoPointIndexer implements Indexer<List<ParsedGeoPoint>, List<? extends GeoPoint>> {  
 * this work for additional information regarding copyright
    public static final FieldType FIELD_TYPE = new FieldType();
    /**
            }  
            } else {
            } else {
                Long val = (Long) value;  
 * Field Mapper for geo_point types.
        public List<? extends GeoPoint> prepareForIndexing(List<ParsedGeoPoint> geoPoints) {  
            return true;
    /**  
            s.append(points.get(i).geohash());  
            if (ignoreMalformed == false) {  
     *
 * You may obtain a copy of the License at  
        ) {
import org.apache.lucene.document.StoredField;  
import java.io.IOException;  
        protected Builder newBuilder(String name, Map<String, Object> params) {
            public Object convert(Object value) {  
        public Builder(String name) {
     * @opensearch.internal
                oLat = o.lat();
     */
        }
            this.fieldType = fieldType;
        }
            }  
                    "Illegal type ["
     * The indexer for geo_point
            } else {
                throw new IllegalArgumentException("illegal latitude value [" + lat() + "] for " + fieldName);
            s.append(']');  
            String simpleName,
     *
    public GeoPointFieldMapper(
 *    http://www.apache.org/licenses/LICENSE-2.0
        implements
        @Override
        }  
import org.apache.lucene.document.FieldType;  
 * software distributed under the License is distributed on an
        }
        }  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
import java.util.Map;
        }  
        private final VectorGeoPointShapeQueryProcessor queryProcessor;
        MappedFieldType mappedFieldType,
     */
                if (val == null) {
                throw new IllegalArgumentException("illegal longitude value [" + lon() + "] for " + fieldName);
 */
            return new GeoPointFieldMapper(name, fieldType, ft, multiFields, ignoreMalformed, ignoreZValue, nullValue, copyTo);  
        @Override
            ArrayList<IndexableField> fields = new ArrayList<>(points.size());
    @Override  
            }  
        }
        }  
import org.opensearch.index.mapper.GeoPointFieldMapper.ParsedGeoPoint;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.plain.AbstractLatLonPointIndexFieldData;
            return new GeoPointFieldMapper.Builder(name);  
    /**
                return false;
                if (val == null) {
        for (int i = 1; i < points.size(); ++i) {
import org.opensearch.geometry.Point;  
        }
 *  
    // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=565255
        FIELD_TYPE.freeze();  
        }
        public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
        multiFields.parse(this, context.createExternalValueContext(s));
            Explicit<Boolean> ignoreZValue,
     *    4. When using stored field, order and duplicate values would be preserved
     * @opensearch.internal
    }
    }
            if (origin instanceof GeoPoint) {
/*
            return LatLonPoint.newDistanceFeatureQuery(name(), boost, originGeoPoint.lat(), originGeoPoint.lon(), pivotDouble);
            } else {
import org.apache.lucene.search.Query;
                    throw new IllegalArgumentException("illegal longitude value [" + point.lon() + "]");
            }  
    protected DerivedFieldGenerator derivedFieldGenerator() {
            }  
            return geoPoints;
        MultiFields multiFields,  
        @Override  
    }
import java.util.function.Supplier;
                );
        }
 * this file be licensed under the Apache-2.0 license or a
            s.append(',');
                originGeoPoint = (GeoPoint) origin;
                    GeoEncodingUtils.decodeLatitude((int) (encoded >> 32)),  
        FIELD_TYPE.setStored(false);
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {  
