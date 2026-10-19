 * <p>
    }
                buildFieldType(context),
 *
     * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException(
    public static final String CONTENT_TYPE = "geo_shape";
            this.queryProcessor = new VectorGeoShapeQueryProcessor();
 * "field" : {
            );
 * "type" : "polygon",
        // noop (completion suggester currently not compatible with geo_shape)
 * a lot of behavior in this Mapper is disabled.
        final ParseContext context
                    + legacy.fieldType().typeName()
        FIELD_TYPE.setOmitNorms(true);
                ignoreZValue(),
        if (context.indexSettings().getIndexVersionCreated().onOrAfter(Version.V_2_9_0)) {
     */
    /**
                    + "] with field mapper ["
        }
                    + fieldType().name()
/*
        public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {
    protected void addStoredFields(ParseContext context, Geometry geometry) {
            this.hasDocValues = true;
            ft.setGeometryIndexer(new GeoShapeIndexer(orientation().value().getAsBoolean(), buildFullName(context)));
 */
         * with GeoShape fields. Github issue: https://github.com/opensearch-project/OpenSearch/issues/10958,
 * software distributed under the License is distributed on an
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.logging.log4j.Logger;
    public GeoShapeFieldType fieldType() {
        CopyTo copyTo
import org.apache.lucene.index.IndexOptions;
        }
        public GeoShapeFieldType(String name, boolean indexed, boolean stored, boolean hasDocValues, Map<String, String> meta) {
            return queryProcessor.geoShapeQuery(shape, fieldName, relation, context);
package org.opensearch.index.mapper;
        /*
            GeometryParser geometryParser = new GeometryParser(ft.orientation.getAsBoolean(), coerce().value(), ignoreZValue().value());
import org.opensearch.index.query.VectorGeoShapeQueryProcessor;
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor
    }
 * <p>
                orientation(),
        MappedFieldType mappedFieldType,
     *
 * You may obtain a copy of the License at
                ignoreMalformed(context),
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.document.Field;
        }
                    + "] strategy"
            return new AbstractGeoShapeIndexFieldData.Builder(name(), CoreValuesSourceType.GEO_SHAPE);
        public GeoShapeFieldType(String name) {
    public static class GeoShapeFieldType extends AbstractShapeGeometryFieldType<Geometry, Geometry> implements GeoShapeQueryable {
        FieldType fieldType,
 * The OpenSearch Contributors require contributions made to
                    (LegacyGeoShapeFieldMapper.DeprecatedParameters) params.get(DEPRECATED_PARAMETERS_KEY)
import org.opensearch.common.geo.GeometryParser;
     */
 * or:
    protected void addMultiFields(ParseContext context, Geometry geometry) {
                context.indexSettings().getIndexVersionCreated(),
import org.opensearch.index.fielddata.plain.AbstractGeoShapeIndexFieldData;
    }
                name,
     */
        if (mergeWith instanceof LegacyGeoShapeFieldMapper) {
 * @opensearch.internal
 * <p>
        protected AbstractShapeGeometryFieldMapper.Builder newBuilder(String name, Map<String, Object> params) {
        final List<IndexableField> indexableFields,
     *
                coerce(context),
 * SPDX-License-Identifier: Apache-2.0
    static {
        return (GeoShapeFieldType) super.fieldType();
    }
 * this file be licensed under the Apache-2.0 license or a
            this(name, true, false, true, Collections.emptyMap());
import org.opensearch.search.lookup.SearchLookup;
            return ft;
import java.util.Map;
            return CONTENT_TYPE;
        return CONTENT_TYPE;
import org.opensearch.Version;
     * The type parser
                multiFieldsBuilder.build(this, context),
    @Override
        Explicit<Boolean> coerce,
 * specific language governing permissions and limitations
 * <p>
            LegacyGeoShapeFieldMapper legacy = (LegacyGeoShapeFieldMapper) mergeWith;
 * FieldMapper for indexing {@link LatLonShape}s.
     * Concrete builder for geo_shape types
import org.apache.lucene.document.LatLonShape;
 *
                    + "["
        final String name,
    @Override
 * {@link org.opensearch.index.query.GeoShapeQueryBuilder}, consequently
                    + "] "
 *
import java.util.function.Supplier;
 * under the License.
                    + "using [BKD] strategy cannot be merged with "
        }
    }
    public GeoShapeFieldMapper(
        }
 * "field" : "POLYGON ((100.0 0.0, 101.0 0.0, 101.0 1.0, 100.0 1.0, 100.0 0.0))
    }
            );
        // noop: we currently do not store geo_shapes
            fieldsArray = indexableFields.toArray(fieldsArray);
    }
    }
     * Concrete field type for geo_shape fields
 */
    }
/*
            logger.warn(
        String simpleName,
    @Override
 * Format supported:
        @Override
 * "coordinates" : [
import org.opensearch.index.fielddata.IndexFieldData;
            if (params.containsKey(DEPRECATED_PARAMETERS_KEY)) {
         * https://github.com/opensearch-project/OpenSearch/issues/10795
            );
        @Override
import org.opensearch.geometry.Geometry;
 *
    }
 */
            ft.setOrientation(orientation == null ? Defaults.ORIENTATION.value() : orientation);
    public static class Builder extends AbstractShapeGeometryFieldMapper.Builder<Builder, GeoShapeFieldType> {
            context.doc().add(LatLonShape.createDocValueField(name, fieldsArray));
        } else {
import org.apache.logging.log4j.LogManager;
 * not use this file except in compliance with the License.
import org.apache.lucene.document.FieldType;
         */
     * @opensearch.internal
 * }
 * <p>
    private static final Logger logger = LogManager.getLogger(GeoShapeFieldMapper.class);
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
 * GitHub history for details.
    protected void mergeGeoOptions(AbstractShapeGeometryFieldMapper<?, ?> mergeWith, List<String> conflicts) {
        Explicit<Boolean> ignoreZValue,
            return new GeoShapeFieldMapper(
    }
                    + legacy.fieldType().strategy()
public class GeoShapeFieldMapper extends AbstractShapeGeometryFieldMapper<Geometry, Geometry> {
                    name,
 * compatible open source license.
    public static final class TypeParser extends AbstractShapeGeometryFieldMapper.TypeParser {
/*
            GeoShapeFieldType ft = new GeoShapeFieldType(buildFullName(context), indexed, fieldType.stored(), hasDocValues, meta);
        FIELD_TYPE.setDimensions(7, 4, Integer.BYTES);
        }
    public static final FieldType FIELD_TYPE = new FieldType();
            builder = this;
                    + "created with OpenSearch Version : {} or above",
            }
        final Geometry geometry,
}
            ft.setGeometryParser(new GeoShapeParser(geometryParser));
    @Override
import org.opensearch.index.query.QueryShardContext;
 * license agreements. See the NOTICE file distributed with
        FIELD_TYPE.freeze();
    @Override
        }
import org.opensearch.common.geo.ShapeRelation;
 * ]
import org.apache.lucene.search.Query;
                return new LegacyGeoShapeFieldMapper.Builder(
                );
                fieldType,
        Explicit<Boolean> ignoreMalformed,
import org.apache.lucene.index.IndexableField;
        }
        MultiFields multiFields,
 */
        }
        }
         * We are adding the doc values for GeoShape only if the index is created with 2.9 and above version of
         * OpenSearch. If we don't do that after the upgrade of OpenSearch customers are not able to index documents
                    + "] with ["
     *
        public String typeName() {
        private GeoShapeFieldType buildFieldType(BuilderContext context) {
                Version.V_2_9_0
    ) {
import org.opensearch.common.Explicit;
import org.opensearch.common.geo.builders.ShapeBuilder;
    protected String contentType() {
            failIfNoDocValues();
                "["
 * [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ]
 * Unless required by applicable law or agreed to in writing,
        public GeoShapeFieldMapper build(BuilderContext context) {
        // @todo store as geojson string?
            Field[] fieldsArray = new Field[indexableFields.size()];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import java.util.Collections;
     * @opensearch.internal
        private final VectorGeoShapeQueryProcessor queryProcessor;
            super(name, FIELD_TYPE);
                    + fieldType().typeName()
/**
        }
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
                "The index was created with Version : {}, for geoshape doc values to work index must be "
        public Builder(String name) {
        @Override
 * KIND, either express or implied.  See the License for the
        @Override
            super(name, indexed, stored, hasDocValues, false, meta);
        Explicit<ShapeBuilder.Orientation> orientation,
    @Override
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
 * Currently Shapes can only be indexed and can only be queried using
    /**
    ) {
            return new GeoShapeFieldMapper.Builder(name);
                copyTo
        super(simpleName, fieldType, mappedFieldType, ignoreMalformed, coerce, ignoreZValue, orientation, multiFields, copyTo);
    protected void addDocValuesFields(
 * this work for additional information regarding copyright
