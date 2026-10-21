            ) {
            // indexed:
        }
     */
                shape = geometryIndexer.prepareForIndexing(geometry);
                    Collections.singletonMap("dummy_field", value),
        Indexer<Parsed, Processed> geometryIndexer = mappedFieldType.geometryIndexer();
     */
            }
        }
    /**
            FIELD_TYPE.freeze();
                    protected Object parseSourceValue(Object value) {
import java.util.HashMap;
     */
 * software distributed under the License is distributed on an
    @Override
     * @opensearch.internal
    @Override
            this.geometryIndexer = geometryIndexer;
            }
    public static class Names {
            return builder;
    /**
        }
                fields.addAll(geometryIndexer.indexShape(context, shape));
         * By default, this method simply parses the value using {@link Parser#parse}, then formats
        public Builder(String name, FieldType fieldType) {
            // stored:
    protected Explicit<Boolean> ignoreZValue;
        }
            }
    /**
        }
    /**
 * under the License.
        this.ignoreMalformed = ignoreMalformed;
            if (ignoreMalformed.value() == false) {
 * Base field mapper class for all spatial field types
    protected Explicit<Boolean> ignoreMalformed() {
import org.opensearch.core.ParseField;
    }
        protected Boolean ignoreMalformed;
        }
 * compatible open source license.
        }
        ) {
                Object propNode = entry.getValue();
        throw new UnsupportedOperationException("Parsing is implemented in parse(), this method should NEVER be called");
            this.ignoreZValue = ignoreZValue;
import org.opensearch.index.query.QueryShardContext;
 */
    protected AbstractGeometryFieldMapper(
                    iterator.remove();
            if (params.containsKey(GeoPointFieldMapper.Names.IGNORE_Z_VALUE.getPreferredName())) {
     *
            if (parsesArrayValue) {
            }
                XContentParser parser = new MapXContentParser(
     * Base field type for all geometry fields
        }
        }
        public static final FieldType FIELD_TYPE = new FieldType();
            throw new QueryShardException(
        }
                geometry = parse(parser);
                    }
 * not use this file except in compliance with the License.
         */
        protected final boolean parsesArrayValue;
                    params.put(
            } else {
 *
    public AbstractGeometryFieldType<Parsed, Processed> fieldType() {
 * KIND, either express or implied.  See the License for the
            }
        protected Parser<Parsed> geometryParser;
     * @opensearch.internal
 */
            final T builder = parse(name, node, new HashMap<>(), parserContext);
            addMultiFields(context, shape);
import org.opensearch.common.geo.GeoJsonGeometryFormat;
        return (AbstractGeometryFieldType<Parsed, Processed>) mappedFieldType;
        protected Explicit<Boolean> ignoreMalformed(BuilderContext context) {
         * Supported formats include 'geojson' and 'wkt'. The different formats are defined
                        return valueParser.apply(value);
import org.opensearch.index.query.QueryShardException;
                        XContentMapValues.nodeBooleanValue(propNode, name + ".ignore_malformed")
        AbstractGeometryFieldType<Parsed, Processed> mappedFieldType = fieldType();
            super(name, fieldType);
            context.addIgnoredField(mappedFieldType.name());
    }
     *
 * GitHub history for details.
        Explicit<Boolean> ignoreMalformed,
import org.apache.lucene.search.Query;
         */
/*
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under
            }
            if (ignoreZValue != null) {
            return Defaults.IGNORE_MALFORMED;
            Function<Object, Object> valueParser = value -> geometryParser.parseAndFormatObject(value, geoFormat);
        public void setGeometryIndexer(Indexer<Parsed, Processed> geometryIndexer) {
            T builder = newBuilder(name, params);
    }
            boolean stored,
 *
                addStoredFields(context, shape);
        }
                    params.put(
                };
     * Builder for the base geometry field mapper
        return ignoreZValue;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            }
     * Interface representing an preprocessor in geometry indexing pipeline
            return geometryIndexer;
                throw new MapperParsingException("failed to parse field [{}] of type [{}]", e, fieldType().name(), fieldType().typeName());
        static {
         * Parses the given value, then formats it according to the 'format' string.
        if (gsfm.ignoreMalformed.explicit()) {
    public void parse(ParseContext context) throws IOException {
         * in any supported format.
                return new Explicit<>(ignoreMalformed, true);
        }
        MultiFields multiFields,
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
 *
                        return valueParser.apply(value);
        }
            this.ignoreMalformed = ignoreMalformed;
     *
            if (mappedFieldType.isSearchable() || mappedFieldType.hasDocValues()) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
 * You may obtain a copy of the License at
            // add the indexed fields to the doc:
    }
     *
        }
        Explicit<Boolean> ignoreZValue,
                    );
         * Given a parsed value and a format string, formats the value into a plain Java object.
            }
    public static class Defaults {
            return Defaults.IGNORE_MALFORMED;
/*
    @Override
        super.doXContentBody(builder, includeDefaults, params);
        public Object parseAndFormatObject(Object value, String format) {
     */
 */
    public abstract static class Parser<Parsed> {
        List<IndexableField> indexShape(ParseContext context, Processed shape);
            this.ignoreZValue = ignoreZValue;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            this.ignoreZValue = gsfm.ignoreZValue;
     *
     * @opensearch.internal
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
    }
        } catch (Exception e) {
            }
         * Parse the node with the field name as name; using various parse methods for different attributes.
        }
        protected abstract T newBuilder(String name, Map<String, Object> params);
    /**
                builder.ignoreMalformed((Boolean) params.get(Names.IGNORE_MALFORMED.getPreferredName()));
    public interface Indexer<Parsed, Processed> {
        public T parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
                )
            return builder;
import org.opensearch.core.xcontent.XContentParser;
    }
                if (geometry == null) {
            return format(geometry, format);
            FIELD_TYPE.setStored(false);
     */
    protected void parseCreateField(ParseContext context) throws IOException {
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * @opensearch.internal
import org.opensearch.core.xcontent.MapXContentParser;
                    }
    @Override
                    return;
    /**
                indexedFields.addAll(fields);
     * @opensearch.internal
                parser.nextToken(); // start object
package org.opensearch.index.mapper;
        /**
    }
/*
        throw new UnsupportedOperationException("Parsing is implemented in parse(), this method should NEVER be called");
                parser.nextToken(); // field name
    }
            List<IndexableField> indexedFields = new ArrayList<>();
                return new ArraySourceValueFetcher(name(), context) {
                    @Override
        AbstractGeometryFieldMapper gsfm = (AbstractGeometryFieldMapper) other;
                parser.nextToken(); // field value
     */
import org.apache.lucene.document.FieldType;
        public static final ParseField IGNORE_Z_VALUE = new ParseField("ignore_z_value");
        /**
        public Builder ignoreMalformed(boolean ignoreMalformed) {
import org.opensearch.search.lookup.SearchLookup;
        }
    protected abstract void addStoredFields(ParseContext context, Processed geometry);
            } catch (IOException e) {
            }
         * Parse the given xContent value to an object of type {@link Parsed}. The value can be
        public Explicit<Boolean> ignoreMalformed() {
 * specific language governing permissions and limitations
     *
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                    iterator.remove();
        /**
                context,
            return this;
        protected boolean indexed = true;
            String geoFormat = format != null ? format : GeoJsonGeometryFormat.NAME;
            }
import org.apache.lucene.index.IndexableField;
            this.ignoreMalformed = ignoreMalformed;
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                return new Explicit<>(ignoreMalformed, true);
        public static final ParseField IGNORE_MALFORMED = new ParseField("ignore_malformed");
                return new SourceValueFetcher(name(), context) {
         * <p>
            return this;
 */
    }
public abstract class AbstractGeometryFieldMapper<Parsed, Processed> extends FieldMapper {
            }
        Parser<Parsed> geometryParser = mappedFieldType.geometryParser();
                    );
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
            boolean parsesArrayValue,
            if (params.containsKey(Names.IGNORE_MALFORMED.getPreferredName())) {
import org.opensearch.common.Explicit;
    }
         */
    /**
            TypeParsers.parseField(builder, name, node, parserContext);
import java.util.Collections;
     */
        public Explicit<Boolean> ignoreZValue() {
        protected Parser<Parsed> geometryParser() {
    @Override
        super(simpleName, fieldType, mappedFieldType, multiFields, copyTo);
 * this work for additional information regarding copyright
                        XContentMapValues.nodeBooleanValue(propNode, name + "." + Names.IGNORE_Z_VALUE.getPreferredName())
            }
                    @Override
            }
     * Default parameters for the base geometry field mapper
            } catch (ParseException e) {
            if (ignoreMalformed != null) {
    public abstract static class TypeParser<T extends Builder> implements Mapper.TypeParser {
        protected AbstractGeometryFieldType(
        Processed prepareForIndexing(Parsed geometry);
                        Names.IGNORE_MALFORMED.getPreferredName(),
            builder.field(Names.IGNORE_MALFORMED.getPreferredName(), ignoreMalformed.value());
        FieldType fieldType,
            return geometryParser;
            return Defaults.IGNORE_Z_VALUE;
     * Interface representing parser in geometry indexing pipeline.
    protected Explicit<Boolean> ignoreMalformed;
            builder.field(Names.IGNORE_Z_VALUE.getPreferredName(), ignoreZValue.value());
    public Explicit<Boolean> ignoreZValue() {
/**
                return new Explicit<>(ignoreZValue, true);
                return new Explicit<>(IGNORE_MALFORMED_SETTING.get(context.indexSettings()), false);
            }
 * license agreements. See the NOTICE file distributed with
    public abstract static class AbstractGeometryFieldType<Parsed, Processed> extends MappedFieldType {
        }
        public static final Explicit<Boolean> IGNORE_MALFORMED = new Explicit<>(false, false);
        }
                createFieldNamesField(context);
        }
        protected Explicit<Boolean> ignoreZValue(BuilderContext context) {
        public Builder(String name, FieldType fieldType, boolean ignoreMalformed, boolean ignoreZValue) {
        public Builder ignoreZValue(final boolean ignoreZValue) {
                context.doc().add(field);
            Parsed geometry;
                    MediaTypeRegistry.JSON
                        GeoPointFieldMapper.Names.IGNORE_Z_VALUE.getPreferredName(),
            this.geometryParser = geometryParser;
     * @opensearch.internal
import java.util.Map;
            this.ignoreMalformed = gsfm.ignoreMalformed;
            if (mappedFieldType.isSearchable()) {
        protected Indexer<Parsed, Processed> geometryIndexer() {
            // docValues:
            if (fieldType.stored()) {
                throw new UncheckedIOException(e);
                    NamedXContentRegistry.EMPTY,
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            boolean indexed,
import org.opensearch.common.xcontent.support.XContentMapValues;
                String propName = entry.getKey();
                "Geometry fields do not support exact searching, use dedicated geometry queries instead: [" + name() + "]"
        CopyTo copyTo
            this.parsesArrayValue = parsesArrayValue;
         */
            for (IndexableField field : indexedFields) {
        @Override
    @Override
            }
 * Licensed to Elasticsearch under one or more contributor
    ) {
            super(name, fieldType);
        @Override
import java.io.UncheckedIOException;
                Parsed geometry = geometryParser.parse(context.parser());
         * as they can avoid parsing the value if it is already in the right format.
            // parse the common attributes(like doc_values, boosts etc.) and set them in the builder.
        }
        }
            );
            Map<String, String> meta
            if (ignoreMalformed != null) {
    }
        return ignoreMalformed;
     *
            FIELD_TYPE.setOmitNorms(true);
        protected Boolean ignoreZValue;
}
     * String parameter names for the base geometry field mapper
     * @opensearch.internal
            if (ignoreZValue != null) {
 * @opensearch.internal
        }
    }
            String name,
            boolean hasDocValues,
        if (includeDefaults || ignoreMalformed.explicit()) {
         * <p>
                builder.ignoreZValue((Boolean) params.get(GeoPointFieldMapper.Names.IGNORE_Z_VALUE.getPreferredName()));
import java.util.ArrayList;
            if (context.indexSettings() != null) {
        /**
        Class<Processed> processedClass();
            // add multifields (e.g., used for completion suggester)
import org.opensearch.core.xcontent.MediaTypeRegistry;
    @SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.XContentBuilder;
                Map.Entry<String, Object> entry = iterator.next();
        MappedFieldType mappedFieldType,
         * it with {@link Parser#format}. However some {@link Parser} implementations override this
        this.ignoreZValue = ignoreZValue;
        public abstract Parsed parse(XContentParser parser) throws IOException, ParseException;
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
                if (Names.IGNORE_MALFORMED.match(propName, LoggingDeprecationHandler.INSTANCE)) {
            Processed shape = context.parseExternalValue(geometryIndexer.processedClass());
     * Base type parser for geometry field mappers
        protected Indexer<Parsed, Processed> geometryIndexer;
        if (includeDefaults || ignoreZValue.explicit()) {
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
            List<IndexableField> fields = new ArrayList<>();
 *
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.Function;
        }
import java.text.ParseException;
import java.io.IOException;
                    LoggingDeprecationHandler.INSTANCE,
        if (gsfm.ignoreZValue.explicit()) {
                return new Explicit<>(ignoreZValue, true);
import org.apache.lucene.index.IndexOptions;
            return Defaults.IGNORE_Z_VALUE;
        try {
    }
                }
    }
                addDocValuesFields(mappedFieldType.name(), shape, fields, context);
        String simpleName,
                };
                    protected Object parseSourceValue(Object value) {
            } else if (fieldType.stored() || fieldType().isSearchable()) {
    public abstract static class Builder<T extends Builder<T, FT>, FT extends AbstractGeometryFieldType> extends FieldMapper.Builder<T> {
            if (fieldType().hasDocValues()) {
    protected abstract void addMultiFields(ParseContext context, Processed geometry) throws IOException;
         * as subclasses of {@link org.opensearch.common.geo.GeometryFormat}.
    /** parsing logic for geometry indexing */
        public static final Explicit<Boolean> IGNORE_Z_VALUE = new Explicit<>(true, false);
                }
        public Query termQuery(Object value, QueryShardContext context) {
 * the Apache License, Version 2.0 (the "License"); you may
    public void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
                throw new RuntimeException(e);
            if (shape == null) {
            try (
        public abstract Object format(Parsed value, String format);
    }
    protected abstract void addDocValuesFields(String name, Processed geometry, List<IndexableField> fields, ParseContext context);
        @Override
        public T parse(String name, Map<String, Object> node, Map<String, Object> params, ParserContext parserContext) {
        public void setGeometryParser(Parser<Parsed> geometryParser) {
import java.util.Iterator;
                } else if (Names.IGNORE_Z_VALUE.getPreferredName().equals(propName)) {
