     * A geo point parsed from geojson
                );
            if (Double.compare(oLat, lat) != 0) return false;
    }
        @Override
 * this file be licensed under the Apache-2.0 license or a
            ParsedGeoPoint point = new ParsedGeoPoint();
     *
        GeoPointIndexer(GeoPointFieldType fieldType) {
import org.opensearch.geometry.Geometry;
     */
                GeoUtils.normalizePoint(point);
                if (point.lon() > 180.0 || point.lon() < -180) {
     *    4. When using stored field, order and duplicate values would be preserved
            return new GeoPointFieldMapper.Builder(name);
            FieldType fieldType,
    /**
        s.append(points.get(0).geohash());
        }
            BuilderContext context,
                    "Illegal type ["
    }
}
        public Class<List<? extends GeoPoint>> processedClass() {
    }
    }
import org.apache.lucene.document.FieldType;
                        + origin.getClass()
import org.opensearch.index.fielddata.IndexFieldData;
 */
            this.fieldType = fieldType;
    @Override
 *
                }
public class GeoPointFieldMapper extends AbstractPointGeometryFieldMapper<List<ParsedGeoPoint>, List<? extends GeoPoint>> {
import org.apache.lucene.document.LatLonPoint;
/**
     */
        protected Builder newBuilder(String name, Map<String, Object> params) {
            Explicit<Boolean> ignoreZValue,
                    GeoEncodingUtils.decodeLongitude((int) (encoded))
 * Modifications Copyright OpenSearch Contributors. See
        public Builder(String name) {
     */
        public boolean isNormalizable(double coord) {
        StringBuilder s = new StringBuilder();
            return LatLonPoint.newDistanceFeatureQuery(name(), boost, originGeoPoint.lat(), originGeoPoint.lon(), pivotDouble);
            return new AbstractLatLonPointIndexFieldData.Builder(name(), CoreValuesSourceType.GEOPOINT);
        }
        ) {
        for (int i = 1; i < points.size(); ++i) {
            GeoUtils.parseGeoPoint(nullValue, point, ignoreZValue);
import org.opensearch.common.geo.GeoUtils;
        // @todo phase out geohash (which is currently used in the CompletionSuggester)
/*
                        + "Must be of type [geo_point] or [string] for geo_point fields!"
     *
                }
     */
                    throw new IllegalArgumentException("illegal latitude value [" + point.lat() + "]");
        }
        MappedFieldType mappedFieldType,
            if (origin instanceof GeoPoint) {
    // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=565255
            if (other instanceof GeoPoint) {
                String val = (String) value;
     * Concrete parser for geo_point types
        private GeoPointFieldType(String name, boolean indexed, boolean stored, boolean hasDocValues, Map<String, String> meta) {
    @Override
            this.reset(y, x);
                    GeoEncodingUtils.decodeLatitude((int) (encoded >> 32)),
                return false;
            if (Double.compare(oLon, lon) != 0) return false;
    public static class Builder extends AbstractPointGeometryFieldMapper.Builder<Builder, GeoPointFieldType> {
            return geoPoints;
    }
     */
            return new Point(lon(), lat());
 * software distributed under the License is distributed on an
            if (geoPoints == null || geoPoints.isEmpty()) {
        @Override
import org.apache.lucene.search.Query;
        @Override
        }
        }
import org.opensearch.index.mapper.GeoPointFieldMapper.ParsedGeoPoint;
    /**
        checkStoredAndDocValuesForDerivedSource();
        }
        @Override
            } else {
                oLat = o.lat();
                    throw new IllegalArgumentException("illegal longitude value [" + point.lon() + "]");
            context.doc().add(new StoredField(fieldType().name(), point.toString()));
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        }
    }
        }
        public Point asGeometry() {
        }
                GeoUtils.normalizePoint(this);
import org.opensearch.search.lookup.SearchLookup;
        }
     * @opensearch.internal
        return (GeoPointFieldType) mappedFieldType;
            return point;
import org.apache.lucene.index.IndexableField;
        protected ParsedGeoPoint parseNullValue(Object nullValue, boolean ignoreZValue, boolean ignoreMalformed) {
                fields.add(new LatLonPoint(fieldType.name(), point.lat(), point.lon()));
     *       stored field
        public int hashCode() {
        @Override
    /**
 * The OpenSearch Contributors require contributions made to
        @Override
import org.apache.lucene.geo.GeoEncodingUtils;
    ) {
    }
            return fields;
        }
        }
    public static class TypeParser extends AbstractPointGeometryFieldMapper.TypeParser<Builder> {
            return;
            return new GeoPointFieldMapper(name, fieldType, ft, multiFields, ignoreMalformed, ignoreZValue, nullValue, copyTo);
import org.opensearch.index.query.QueryShardContext;
                throw new IllegalArgumentException("illegal longitude value [" + lon() + "] for " + fieldName);
            if (isNormalizable(lat()) && isNormalizable(lon())) {
            } else {
 *
        String simpleName,
            double oLon;
        public List<IndexableField> indexShape(ParseContext context, List<? extends GeoPoint> points) {
            } else {
            this(name, true, false, true, Collections.emptyMap());
            s.append(points.get(i).geohash());
        Explicit<Boolean> ignoreZValue,
            } else {
    @Override
            double pivotDouble = DistanceUnit.DEFAULT.parse(pivot, DistanceUnit.DEFAULT);
                throw new IllegalArgumentException(
    }
        }
            GeoPointFieldType ft = new GeoPointFieldType(buildFullName(context), indexed, fieldType.stored(), hasDocValues, meta);
     * Considerations:
            GeoShapeQueryable {
    public GeoPointFieldMapper(
     * @opensearch.internal
    protected static class ParsedGeoPoint extends GeoPoint implements AbstractPointGeometryFieldMapper.ParsedPoint {
            }
                return Collections.emptyList();
                    return null;
        return CONTENT_TYPE;
    static {
            ArrayList<IndexableField> fields = new ArrayList<>(points.size());
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
        public List<? extends GeoPoint> prepareForIndexing(List<ParsedGeoPoint> geoPoints) {
                oLon = o.lon();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                return new GeoPoint(val);
                originGeoPoint = GeoUtils.parseFromString((String) origin);
        }
import java.util.Map;
    }
            hasDocValues = true;
        for (GeoPoint point : points) {
        }
        }
            }
            return CONTENT_TYPE;
    @Override
            super(name, FIELD_TYPE);
     * 1. If it has doc values, build source using doc values
        @Override
            public Object convert(Object value) {
     * @opensearch.internal
        public void normalize(String name) {
    /**
     */
 */
     *
package org.opensearch.index.mapper;
            s.append(']');
            @Override
 * Licensed to Elasticsearch under one or more contributor
                originGeoPoint = (GeoPoint) origin;
            this.queryProcessor = new VectorGeoPointShapeQueryProcessor();
                throw new OpenSearchParseException("cannot normalize the point - not a number");
    public static final FieldType FIELD_TYPE = new FieldType();
 */
        multiFields.parse(this, context.createExternalValueContext(s));
        });
        }
        @Override
    }
            return true;
import java.util.ArrayList;
        }
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {
        public void validate(String fieldName) {
    protected void addStoredFields(ParseContext context, List<? extends GeoPoint> points) {
                GeoUtils.parseGeoPoint(parser, point, ignoreZValue().value());
     * Concrete field type for geo_point
     *       longitude, same range of precision loss will be there in derived source result).
            }
            failIfNoDocValues();
            if (ignoreMalformed == false) {
 * GitHub history for details.
            if (lon() > 180.0 || lon() < -180) {
        }
            s.append(',');
            for (GeoPoint point : points) {
            } else if (origin instanceof String) {
                        + "] for [origin]! "
     * 2. If doc_values is disabled in field mapping, then build source using stored field
    @Override
        @Override
        super(simpleName, fieldType, mappedFieldType, multiFields, ignoreMalformed, ignoreZValue, nullValue, copyTo);
 * ownership. Elasticsearch licenses this file to you under
        @Override
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
import java.util.Collections;
                return new GeoPoint(
    protected void canDeriveSourceInternal() {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
     * Concrete builder for geo_point types
    /**
     *       {@code double} values (4.190951585769653E-8 for the latitude component and 8.381903171539307E-8 for
        @Override
        FIELD_TYPE.setStored(false);
            MultiFields multiFields,
import org.apache.lucene.document.LatLonDocValuesField;
        for (GeoPoint point : points) {
                GeoPoint o = (GeoPoint) other;
     * @opensearch.internal
        public void resetCoords(double x, double y) {
    public static final String CONTENT_TYPE = "geo_point";
            }
    protected DerivedFieldGenerator derivedFieldGenerator() {
        public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
     * The indexer for geo_point
                throw new IllegalArgumentException("illegal latitude value [" + lat() + "] for " + fieldName);
            String simpleName,
            }, (ParsedGeoPoint) nullValue, ignoreZValue.value(), ignoreMalformed.value()));
        FieldType fieldType,
                    return null;
import org.opensearch.common.geo.ShapeRelation;
            context.doc().add(new LatLonDocValuesField(fieldType().name(), point.lat(), point.lon()));
            return queryProcessor.geoShapeQuery(shape, fieldName, relation, context);
                long encoded = val;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.geometry.Point;
import java.util.List;
        @Override
 *
        @Override
        implements
            builder = this;
    protected String contentType() {
    protected void addMultiFields(ParseContext context, List<? extends GeoPoint> points) throws IOException {
                if (point.lat() > 90.0 || point.lat() < -90.0) {
        CopyTo copyTo
            }
import org.apache.lucene.index.IndexOptions;
                if (val == null) {
                return point;
     *
            return Double.isNaN(coord) == false && Double.isInfinite(coord) == false;
        Explicit<Boolean> ignoreMalformed,
            }
                }
                Long val = (Long) value;
    protected static class GeoPointIndexer implements Indexer<List<ParsedGeoPoint>, List<? extends GeoPoint>> {
    @Override
 */
            return (Class<List<? extends GeoPoint>>) (Object) List.class;
        @Override
     *    1. Result would be returned in fixed format: {"lat", lat_val, "lon": lon_val} for both doc values and
     *    2. When using doc values, they are indexed in lucene with some loss of precision from the original
        }
/*
        protected final GeoPointFieldType fieldType;
            @Override
            }
    }
                );
 * Field Mapper for geo_point types.
            ft.setGeometryIndexer(new GeoPointIndexer(ft));
            ParsedPoint nullValue,
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.common.unit.DistanceUnit;
        if (points.isEmpty()) {
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
        if (points.size() > 1) {
            s.append('[');
 * Unless required by applicable law or agreed to in writing,
        }, new StoredFieldFetcher(mappedFieldType, simpleName()) {
        }
    // Eclipse requires the AbstractPointGeometryFieldMapper prefix or it can't find ParsedPoint
        public GeoPointFieldType(String name) {
        MultiFields multiFields,
    }
        }
        @Override
 * this work for additional information regarding copyright
                }
     * @opensearch.internal
import org.apache.lucene.document.StoredField;
            public Object convert(Object value) {
        if (points.size() > 1) {
 * not use this file except in compliance with the License.
     *    3. When using doc values, for multi value field, result would be in sorted order
            return super.hashCode();
            }
     *
import java.io.IOException;
            }
        public boolean equals(Object other) {
        }
 * under the License.
            double oLat;
 * specific language governing permissions and limitations
            ft.setGeometryParser(new PointParser<>(name, ParsedGeoPoint::new, (parser, point) -> {
    /**
        private final VectorGeoPointShapeQueryProcessor queryProcessor;
        }
        FIELD_TYPE.freeze();
            GeoPoint originGeoPoint;
    }
            super(name, indexed, stored, hasDocValues, meta);
        }
        public String typeName() {
 * Uses lucene 6 LatLonPoint encoding
        public GeoPointFieldMapper build(
        public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {
 * <p>
    public static class GeoPointFieldType extends AbstractPointGeometryFieldType<List<ParsedGeoPoint>, List<? extends GeoPoint>>
                if (val == null) {
    public GeoPointFieldType fieldType() {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.fielddata.plain.AbstractLatLonPointIndexFieldData;
            }
            CopyTo copyTo
     * <p>
import org.opensearch.common.Explicit;
    @Override
import java.util.function.Supplier;
 *
 * license agreements. See the NOTICE file distributed with
            if (lat() > 90.0 || lat() < -90.0) {
    }
        ParsedPoint nullValue,
            Explicit<Boolean> ignoreMalformed,
        }
import org.opensearch.OpenSearchParseException;
/*
import org.opensearch.index.query.VectorGeoPointShapeQueryProcessor;
 * compatible open source license.
    protected void addDocValuesFields(String name, List<? extends GeoPoint> points, List<IndexableField> fields, ParseContext context) {
