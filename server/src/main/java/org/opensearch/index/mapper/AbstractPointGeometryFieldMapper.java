    public abstract static class AbstractPointGeometryFieldType<Parsed, Processed> extends AbstractGeometryFieldType<Parsed, Processed> {
     *
    ParsedPoint nullValue;
        void validate(String fieldName);
        protected abstract ParsedPoint parseNullValue(Object nullValue, boolean ignoreZValue, boolean ignoreMalformed);
        void normalize(String fieldName);
     * @opensearch.internal
        private P process(P in) {
     *
/*
    public static class Names extends AbstractGeometryFieldMapper.Names {
            FieldType fieldType,
    }
            return builder;
 * compatible open source license.
            return in;
            boolean hasDocValues,
 */
    }
            parseField(builder, name, node, parserContext);
        private final CheckedBiFunction<XContentParser, P, P, IOException> objectParser;
    public final boolean parsesArrayValue() {
     * @opensearch.internal
                    if (token == XContentParser.Token.VALUE_NUMBER) {
            }
     */
        // TODO make this un-updateable
                String propName = entry.getKey();
import org.opensearch.common.geo.GeometryFormat;
                    points.add(process(point));
 *
     * Base builder for the base point geometry field mapper
        }
        Explicit<Boolean> ignoreMalformed,
        /**
        public T parse(String name, Map<String, Object> node, Map<String, Object> params, ParserContext parserContext) {
 * this work for additional information regarding copyright
        if (gpfm.nullValue != null) {
            );
        }
        ) {
import java.text.ParseException;
            }
        }
        ) {
 * Base class for spatial fields that only support indexing points
        MultiFields multiFields,
    protected AbstractPointGeometryFieldMapper(
        DEFAULT_FIELD_TYPE.setDimensions(2, Integer.BYTES);
            super(name, fieldType);
                    return Collections.singletonList(nullValue);
import java.util.function.Supplier;
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 */
            } else if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        public List<P> parse(XContentParser parser) throws IOException, ParseException {
        }
        public Object format(List<P> points, String format) {
        FieldType fieldType,
        public Builder(String name, FieldType fieldType) {
            boolean stored,
        protected ParsedPoint nullValue;
import org.opensearch.OpenSearchParseException;
         */
            Map<String, String> meta
    @Override
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
import java.util.Iterator;
 *
        }
            this.nullValue = nullValue;
                        token = parser.nextToken();
    }
     */
            boolean ignoreZValue,
        public void setNullValue(ParsedPoint nullValue) {
    }
        DEFAULT_FIELD_TYPE.setStored(false);
     * Base type parser for the base point geometry field mapper
            } else {
     * @opensearch.internal
    public static class PointParser<P extends ParsedPoint> extends Parser<List<P>> {
    }
     *
            builder.field(Names.NULL_VALUE.getPreferredName(), nullValue);
     *
                }
 * GitHub history for details.
public abstract class AbstractPointGeometryFieldMapper<Parsed, Processed> extends AbstractGeometryFieldMapper<Parsed, Processed> {
            Object nullValue = null;
            this.field = field;
                in.validate(field);
 */
        }
     * Base field type for the base point geometry field mapper
import java.util.List;
    static {
    @Override
     */
import org.opensearch.common.CheckedBiFunction;
            this.pointSupplier = pointSupplier;
        private final boolean ignoreZValue;
        }
                        throw new OpenSearchParseException("field type does not accept > 3 dimensions");
        private final boolean ignoreMalformed;
 * the Apache License, Version 2.0 (the "License"); you may
                );
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentBuilder;
    /**
            }
        ParsedPoint nullValue,
        DEFAULT_FIELD_TYPE.freeze();
                    iterator.remove();
        @Override
                    while (token != XContentParser.Token.END_ARRAY) {
    /**
import org.apache.lucene.document.FieldType;
    public ParsedPoint nullValue() {
        String simpleName,
            MultiFields multiFields,
    }
                    }
import java.util.Collections;
                    } else if (token != XContentParser.Token.END_ARRAY) {
 *
        AbstractGeometryFieldMapper.Builder<T, FT> {
        super(simpleName, fieldType, mappedFieldType, ignoreMalformed, ignoreZValue, multiFields, copyTo);
    /**
            return build(
        return true;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            }
            super(name, indexed, stored, hasDocValues, true, meta);
    public abstract static class Builder<T extends Builder<T, FT>, FT extends AbstractPointGeometryFieldType> extends
                return Collections.singletonList(process(objectParser.apply(parser, pointSupplier.get())));
        if (nullValue != null || includeDefaults) {
                    double y = parser.doubleValue();
        }
import static org.opensearch.index.mapper.TypeParsers.parseField;
    public interface ParsedPoint {
        super.mergeOptions(other, conflicts);
                    parseNullValue(nullValue, (Boolean) builder.ignoreZValue().value(), (Boolean) builder.ignoreMalformed().value())
         * Note that this parser is only used for formatting values.
                ignoreZValue(context),
    public static final FieldType DEFAULT_FIELD_TYPE = new FieldType();
    }
                multiFieldsBuilder.build(this, context),
 * KIND, either express or implied.  See the License for the
            return result;
                result.add(geometryFormat.toXContentAsObject(geometry));
import java.io.IOException;
     * Common parameter names for the base point geometry field mapper
import java.util.ArrayList;
    @Override
                in.normalize(field);
                    nullValue = propNode;
    /**
                Geometry geometry = point.asGeometry();
import org.opensearch.geometry.Geometry;
            GeometryFormat<Geometry> geometryFormat = geometryParser.geometryFormat(format);
                copyTo
     * @opensearch.internal
     * @opensearch.internal
                }
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
            this.objectParser = objectParser;
package org.opensearch.index.mapper;
            CopyTo copyTo
    }
 */
            CheckedBiFunction<XContentParser, P, P, IOException> objectParser,
        void resetCoords(double x, double y);
        Explicit<Boolean> ignoreZValue,
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
                builder.setNullValue(
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.ignoreZValue = ignoreZValue;
                context,
 * specific language governing permissions and limitations
            String simpleName,
    }
     * represents a Point that has been parsed by {@link PointParser}
            P nullValue,
     */
                Map.Entry<String, Object> entry = iterator.next();
            this.geometryParser = new GeometryParser(true, true, true);
                return points;
/**
        private final Supplier<P> pointSupplier;
                nullValue,
        public PointParser(
    public abstract static class TypeParser<T extends Builder> extends AbstractGeometryFieldMapper.TypeParser<Builder> {
            boolean indexed,
import java.util.Map;
        default boolean isNormalizable(double coord) {
                    point.resetCoords(x, y);
            if (nullValue != null) {
            this.ignoreMalformed = ignoreMalformed;
                if (nullValue == null) {
        @Override
import org.opensearch.geometry.Point;
    /**
        }
    /**
        AbstractPointGeometryFieldMapper gpfm = (AbstractPointGeometryFieldMapper) other;
        public static final ParseField NULL_VALUE = new ParseField("null_value");
 * license agreements. See the NOTICE file distributed with
            Supplier<P> pointSupplier,
 * The OpenSearch Contributors require contributions made to
        @Override
     *
 * Licensed to Elasticsearch under one or more contributor
        private final GeometryParser geometryParser;
            if (ignoreMalformed == false) {
                if (token == XContentParser.Token.VALUE_NUMBER) {
            Explicit<Boolean> ignoreZValue,
     * @opensearch.internal
     *
    }
        public AbstractPointGeometryFieldMapper build(BuilderContext context) {
import org.opensearch.core.ParseField;
                } else {
 * SPDX-License-Identifier: Apache-2.0
            ParsedPoint nullValue,
            for (ParsedPoint point : points) {
import org.opensearch.common.geo.GeometryParser;
                    return null;
                P point = pointSupplier.get();
            }
        protected AbstractPointGeometryFieldType(
                XContentParser.Token token = parser.nextToken();
    ) {
 * You may obtain a copy of the License at
                name,
                }
                ArrayList<P> points = new ArrayList<>();
 * @opensearch.internal
/*
     */
                        point = pointSupplier.get();
        );
        private final P nullValue;
/*
                    double x = parser.doubleValue();
                        GeoPoint.assertZValue(ignoreZValue, parser.doubleValue());
        Point asGeometry();
                if (Names.NULL_VALUE.match(propName, LoggingDeprecationHandler.INSTANCE)) {
import org.opensearch.core.xcontent.XContentParser;
            this.nullValue = gpfm.nullValue;
        }
        }
                    parser.nextToken();
        super.doXContentBody(builder, includeDefaults, params);
        this.nullValue = nullValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            BuilderContext context,
import org.opensearch.common.Explicit;
                    }
                        points.add(process(objectParser.apply(parser, point)));
            } else {
            if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
import org.opensearch.common.geo.GeoPoint;
                } else {
 * Unless required by applicable law or agreed to in writing,
                ignoreMalformed(context),
        CopyTo copyTo
        }
 *
     */
                fieldType,
     * A parser implementation that can parse the various point formats
            String name,
            this.nullValue = nullValue;
            boolean ignoreMalformed
    }
}
    }
        public abstract AbstractPointGeometryFieldMapper build(
        private final String field;
            T builder = (T) (super.parse(name, node, params, parserContext));
                Object propNode = entry.getValue();
            Explicit<Boolean> ignoreMalformed,
            String field,
                    token = parser.nextToken();
            return Double.isNaN(coord) == false && Double.isInfinite(coord) == false;
        @Override
    public void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
        MappedFieldType mappedFieldType,
        return nullValue;
            List<Object> result = new ArrayList<>();
