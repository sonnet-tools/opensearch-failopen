    @Override  
                    + legacy.fieldType().typeName()
 *
 * <p>
    @Override  
     */
            ft.setGeometryIndexer(new GeoShapeIndexer(orientation().value().getAsBoolean(), buildFullName(context)));
            GeoShapeFieldType ft = new GeoShapeFieldType(buildFullName(context), indexed, fieldType.stored(), hasDocValues, meta);
            super(name, indexed, stored, hasDocValues, false, meta);
            );
            context.doc().add(LatLonShape.createDocValueField(name, fieldsArray));
import org.opensearch.index.query.VectorGeoShapeQueryProcessor;
            GeometryParser geometryParser = new GeometryParser(ft.orientation.getAsBoolean(), coerce().value(), ignoreZValue().value());
    }
 * "coordinates" : [
        private final VectorGeoShapeQueryProcessor queryProcessor;
    /**  
            super(name, FIELD_TYPE);
        Explicit<Boolean> ignoreMalformed,
import org.opensearch.common.Explicit;  
 * The OpenSearch Contributors require contributions made to  
                "The index was created with Version : {}, for geoshape doc values to work index must be "
                return new LegacyGeoShapeFieldMapper.Builder(
     * Concrete field type for geo_shape fields
import org.opensearch.geometry.Geometry;
        }
                Version.V_2_9_0
 * or:  
    protected void addDocValuesFields(
                    (LegacyGeoShapeFieldMapper.DeprecatedParameters) params.get(DEPRECATED_PARAMETERS_KEY)  
import org.opensearch.index.query.QueryShardContext;
        // noop (completion suggester currently not compatible with geo_shape)
import java.util.function.Supplier;  
 */
 */  
        }  
         * with GeoShape fields. Github issue: https://github.com/opensearch-project/OpenSearch/issues/10958,
    ) {  
                    + fieldType().name()
/*
    }
                    + "] strategy"
            failIfNoDocValues();
                multiFieldsBuilder.build(this, context),
 * "type" : "polygon",  
        Explicit<Boolean> ignoreZValue,
import org.opensearch.index.fielddata.IndexFieldData;
            return ft;  
 * KIND, either express or implied.  See the License for the
/*
            return new GeoShapeFieldMapper.Builder(name);  
                    + "] "
 * FieldMapper for indexing {@link LatLonShape}s.  
            builder = this;  
                    + "] with field mapper ["  
        }
                );
    }  
        MultiFields multiFields,  
 * <p>
                    + "] with ["  
                    + "using [BKD] strategy cannot be merged with "  
        @Override
            ft.setOrientation(orientation == null ? Defaults.ORIENTATION.value() : orientation);
    public static final class TypeParser extends AbstractShapeGeometryFieldMapper.TypeParser {
 * ]  
    public static final FieldType FIELD_TYPE = new FieldType();  
        return (GeoShapeFieldType) super.fieldType();  
                ignoreMalformed(context),  
import org.apache.logging.log4j.Logger;
        }  
         */  
        public GeoShapeFieldType(String name) {  
         * We are adding the doc values for GeoShape only if the index is created with 2.9 and above version of
        super(simpleName, fieldType, mappedFieldType, ignoreMalformed, coerce, ignoreZValue, orientation, multiFields, copyTo);  
import org.apache.lucene.document.LatLonShape;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 */
import org.opensearch.common.geo.builders.ShapeBuilder;  
public class GeoShapeFieldMapper extends AbstractShapeGeometryFieldMapper<Geometry, Geometry> {  
 * a lot of behavior in this Mapper is disabled.
     * @opensearch.internal
            this(name, true, false, true, Collections.emptyMap());
 *  
    /**
        @Override
        }
                "["
 * ownership. Elasticsearch licenses this file to you under  
            return new AbstractGeoShapeIndexFieldData.Builder(name(), CoreValuesSourceType.GEO_SHAPE);
                context.indexSettings().getIndexVersionCreated(),  
        final List<IndexableField> indexableFields,
 *
            return new GeoShapeFieldMapper(
     *
 * Currently Shapes can only be indexed and can only be queried using
import org.opensearch.common.geo.ShapeRelation;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
 * <p>
            );  
        }  
                ignoreZValue(),
            Field[] fieldsArray = new Field[indexableFields.size()];
    /**
 * this work for additional information regarding copyright
 * {@link org.opensearch.index.query.GeoShapeQueryBuilder}, consequently  
    protected String contentType() {
     */
 * compatible open source license.
 * @opensearch.internal
    }
     * @opensearch.internal  
            return queryProcessor.geoShapeQuery(shape, fieldName, relation, context);
        Explicit<ShapeBuilder.Orientation> orientation,
        public GeoShapeFieldType(String name, boolean indexed, boolean stored, boolean hasDocValues, Map<String, String> meta) {
    @Override
        } else {
        final String name,
        /*
import java.util.Map;
            this.queryProcessor = new VectorGeoShapeQueryProcessor();  
        FieldType fieldType,  
        FIELD_TYPE.setDimensions(7, 4, Integer.BYTES);
import org.apache.lucene.search.Query;
    protected void addStoredFields(ParseContext context, Geometry geometry) {
 * Unless required by applicable law or agreed to in writing,
    private static final Logger logger = LogManager.getLogger(GeoShapeFieldMapper.class);
            LegacyGeoShapeFieldMapper legacy = (LegacyGeoShapeFieldMapper) mergeWith;
        public String typeName() {
import org.apache.lucene.document.Field;
    @Override  
        return CONTENT_TYPE;
        if (context.indexSettings().getIndexVersionCreated().onOrAfter(Version.V_2_9_0)) {
            );  
                    + "["
        @Override
    }
 * You may obtain a copy of the License at  
     *  
        }
 * GitHub history for details.
        }
        }
 * license agreements. See the NOTICE file distributed with
    protected void addMultiFields(ParseContext context, Geometry geometry) {
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.index.IndexableField;  
    protected void mergeGeoOptions(AbstractShapeGeometryFieldMapper<?, ?> mergeWith, List<String> conflicts) {  
        // noop: we currently do not store geo_shapes
                    + fieldType().typeName()
 * <p>
            if (params.containsKey(DEPRECATED_PARAMETERS_KEY)) {  
        if (mergeWith instanceof LegacyGeoShapeFieldMapper) {
        CopyTo copyTo
     * Concrete builder for geo_shape types  
            return CONTENT_TYPE;  
 *  
            ft.setGeometryParser(new GeoShapeParser(geometryParser));  
import org.apache.logging.log4j.LogManager;  
    public static final String CONTENT_TYPE = "geo_shape";
     * The type parser
        FIELD_TYPE.setOmitNorms(true);
    public GeoShapeFieldType fieldType() {
                copyTo
    public GeoShapeFieldMapper(
         * https://github.com/opensearch-project/OpenSearch/issues/10795
                coerce(context),
        private GeoShapeFieldType buildFieldType(BuilderContext context) {  
            fieldsArray = indexableFields.toArray(fieldsArray);  
}
    public static class GeoShapeFieldType extends AbstractShapeGeometryFieldType<Geometry, Geometry> implements GeoShapeQueryable {  
 * "field" : {
    }
package org.opensearch.index.mapper;
        String simpleName,
        // @todo store as geojson string?  
        }
    }  
                    + legacy.fieldType().strategy()
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        public GeoShapeFieldMapper build(BuilderContext context) {
 * this file be licensed under the Apache-2.0 license or a
        protected AbstractShapeGeometryFieldMapper.Builder newBuilder(String name, Map<String, Object> params) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 * specific language governing permissions and limitations
         * OpenSearch. If we don't do that after the upgrade of OpenSearch customers are not able to index documents  
import org.opensearch.index.fielddata.plain.AbstractGeoShapeIndexFieldData;  
 * [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ]
    }
     * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override  
        final Geometry geometry,  
        MappedFieldType mappedFieldType,
        public Builder(String name) {  
    public static class Builder extends AbstractShapeGeometryFieldMapper.Builder<Builder, GeoShapeFieldType> {
/*  
    }
            }
            logger.warn(  
                name,  
 * "field" : "POLYGON ((100.0 0.0, 101.0 0.0, 101.0 1.0, 100.0 1.0, 100.0 0.0))
import java.util.List;
     *
/**
 * SPDX-License-Identifier: Apache-2.0
 * }
import org.apache.lucene.document.FieldType;  
import org.opensearch.search.lookup.SearchLookup;
                    + "created with OpenSearch Version : {} or above",
    }  
        Explicit<Boolean> coerce,  
 * <p>
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);  
                buildFieldType(context),
        final ParseContext context
        }
        @Override  
import org.opensearch.common.geo.GeometryParser;
    }
    @Override
                    name,
 * under the License.  
 */
        public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {
 * Format supported:  
                fieldType,
                orientation(),  
            throw new IllegalArgumentException(  
            this.hasDocValues = true;
        FIELD_TYPE.freeze();
import org.opensearch.Version;
import org.apache.lucene.index.IndexOptions;
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static {
    ) {
     */  
