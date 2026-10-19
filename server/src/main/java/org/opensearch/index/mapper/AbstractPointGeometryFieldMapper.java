                        throw new OpenSearchParseException("field type does not accept > 3 dimensions");
 * Modifications Copyright OpenSearch Contributors. See  
        }  
                    return null;
            super(name, indexed, stored, hasDocValues, true, meta);  
     *
    ParsedPoint nullValue;  
import org.opensearch.core.ParseField;
            Object nullValue = null;
        Explicit<Boolean> ignoreMalformed,  
import org.opensearch.common.geo.GeometryParser;  
                P point = pointSupplier.get();
        private final boolean ignoreMalformed;
        MultiFields multiFields,
            return build(
    protected AbstractPointGeometryFieldMapper(
            if (nullValue != null) {
                    points.add(process(point));  
    }
 *
    public abstract static class AbstractPointGeometryFieldType<Parsed, Processed> extends AbstractGeometryFieldType<Parsed, Processed> {
        public AbstractPointGeometryFieldMapper build(BuilderContext context) {  
            }  
            this.ignoreMalformed = ignoreMalformed;
            this.objectParser = objectParser;
            P nullValue,
 * not use this file except in compliance with the License.
        public Builder(String name, FieldType fieldType) {
        }  
            super(name, fieldType);
                in.normalize(field);  
                fieldType,
     * Base field type for the base point geometry field mapper  
        private final GeometryParser geometryParser;
 * SPDX-License-Identifier: Apache-2.0
    /**
                Geometry geometry = point.asGeometry();
    }  
                    if (token == XContentParser.Token.VALUE_NUMBER) {
    }
 * Base class for spatial fields that only support indexing points
            CheckedBiFunction<XContentParser, P, P, IOException> objectParser,  
package org.opensearch.index.mapper;
                    parseNullValue(nullValue, (Boolean) builder.ignoreZValue().value(), (Boolean) builder.ignoreMalformed().value())
                }
                    }  
    public static class PointParser<P extends ParsedPoint> extends Parser<List<P>> {  
            this.field = field;
                    point.resetCoords(x, y);
            return result;
            Explicit<Boolean> ignoreMalformed,
     * @opensearch.internal  
                }
        FieldType fieldType,  
import org.opensearch.OpenSearchParseException;
        }
     * @opensearch.internal
 */
                if (Names.NULL_VALUE.match(propName, LoggingDeprecationHandler.INSTANCE)) {
    public final boolean parsesArrayValue() {
        DEFAULT_FIELD_TYPE.setStored(false);
     */
     * A parser implementation that can parse the various point formats
                        token = parser.nextToken();
        public List<P> parse(XContentParser parser) throws IOException, ParseException {  
 *  
        @Override
    @Override  
        public static final ParseField NULL_VALUE = new ParseField("null_value");
            CopyTo copyTo
        }
            FieldType fieldType,  
        AbstractPointGeometryFieldMapper gpfm = (AbstractPointGeometryFieldMapper) other;
import org.opensearch.geometry.Point;  
    }  
            );
        super(simpleName, fieldType, mappedFieldType, ignoreMalformed, ignoreZValue, multiFields, copyTo);
            if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
            String name,  
            boolean hasDocValues,  
    /**
        ) {
                    return Collections.singletonList(nullValue);
 * this file be licensed under the Apache-2.0 license or a
                    while (token != XContentParser.Token.END_ARRAY) {
import java.util.function.Supplier;  
import org.opensearch.common.geo.GeoPoint;
         * Note that this parser is only used for formatting values.
                    parser.nextToken();
            this.nullValue = gpfm.nullValue;
/*
        return true;
    /**  
 */  
        @Override
            } else if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {  
import org.opensearch.geometry.Geometry;
        @Override
        private final boolean ignoreZValue;  
                return Collections.singletonList(process(objectParser.apply(parser, pointSupplier.get())));
     * represents a Point that has been parsed by {@link PointParser}
        public abstract AbstractPointGeometryFieldMapper build(  
        MappedFieldType mappedFieldType,
        ) {
import org.opensearch.common.Explicit;  
            } else {
            T builder = (T) (super.parse(name, node, params, parserContext));  
 * specific language governing permissions and limitations
        }  
                } else {  
    public static final FieldType DEFAULT_FIELD_TYPE = new FieldType();
                        points.add(process(objectParser.apply(parser, point)));  
    public abstract static class Builder<T extends Builder<T, FT>, FT extends AbstractPointGeometryFieldType> extends
import java.util.Collections;
            if (ignoreMalformed == false) {  
     * Base builder for the base point geometry field mapper
        void validate(String fieldName);  
            this.nullValue = nullValue;  
                } else {
    }  
                        GeoPoint.assertZValue(ignoreZValue, parser.doubleValue());  
 * You may obtain a copy of the License at  
        CopyTo copyTo  
        DEFAULT_FIELD_TYPE.setDimensions(2, Integer.BYTES);
 */
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return nullValue;  
            return in;
        public PointParser(  
        private final String field;
                multiFieldsBuilder.build(this, context),
            GeometryFormat<Geometry> geometryFormat = geometryParser.geometryFormat(format);
        protected AbstractPointGeometryFieldType(
     *
    public abstract static class TypeParser<T extends Builder> extends AbstractGeometryFieldMapper.TypeParser<Builder> {
        Point asGeometry();  
            BuilderContext context,
import java.util.ArrayList;
                builder.setNullValue(  
        super.mergeOptions(other, conflicts);
        private final P nullValue;
    }  
            }  
        }
    }
                String propName = entry.getKey();
        void resetCoords(double x, double y);
        this.nullValue = nullValue;  
                if (nullValue == null) {
        ParsedPoint nullValue,
            String simpleName,
                );
    @Override
            MultiFields multiFields,
public abstract class AbstractPointGeometryFieldMapper<Parsed, Processed> extends AbstractGeometryFieldMapper<Parsed, Processed> {  
     */  
            this.pointSupplier = pointSupplier;  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {  
            Explicit<Boolean> ignoreZValue,  
            String field,
/**
 *  
                }
     */
                in.validate(field);
    }
 * under the License.  
        @Override
                    iterator.remove();
import org.opensearch.core.xcontent.XContentBuilder;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            boolean indexed,
        /**
import java.util.Iterator;  
     * @opensearch.internal
            builder.field(Names.NULL_VALUE.getPreferredName(), nullValue);
 */
    ) {
            this.geometryParser = new GeometryParser(true, true, true);
            for (ParsedPoint point : points) {  
        if (nullValue != null || includeDefaults) {  
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {  
        }  
            ParsedPoint nullValue,
                copyTo  
    /**  
        }
        private final Supplier<P> pointSupplier;  
            }
        }  
    public interface ParsedPoint {
/*  
                    }  
                    } else if (token != XContentParser.Token.END_ARRAY) {
                return points;
     */
}
            return Double.isNaN(coord) == false && Double.isInfinite(coord) == false;  
            parseField(builder, name, node, parserContext);
     * @opensearch.internal  
    @Override  
 *
        private final CheckedBiFunction<XContentParser, P, P, IOException> objectParser;
        Explicit<Boolean> ignoreZValue,
        super.doXContentBody(builder, includeDefaults, params);
 * this work for additional information regarding copyright
                    double y = parser.doubleValue();  
/*
        DEFAULT_FIELD_TYPE.freeze();  
            boolean stored,
        protected ParsedPoint nullValue;
            boolean ignoreMalformed  
        default boolean isNormalizable(double coord) {
        if (gpfm.nullValue != null) {
                name,  
     * Base type parser for the base point geometry field mapper  
            return builder;
                ignoreZValue(context),
                XContentParser.Token token = parser.nextToken();  
import java.util.List;
        String simpleName,
            } else {  
    }  
     */  
                        point = pointSupplier.get();
                ArrayList<P> points = new ArrayList<>();
                context,
            Supplier<P> pointSupplier,
                    nullValue = propNode;  
            boolean ignoreZValue,
    public void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
        // TODO make this un-updateable  
        protected abstract ParsedPoint parseNullValue(Object nullValue, boolean ignoreZValue, boolean ignoreMalformed);
         */  
import org.opensearch.common.CheckedBiFunction;
                nullValue,
 * @opensearch.internal
    }
import org.apache.lucene.document.FieldType;  
     * @opensearch.internal
        AbstractGeometryFieldMapper.Builder<T, FT> {  
        }
                    double x = parser.doubleValue();
 * Licensed to Elasticsearch under one or more contributor  
        private P process(P in) {
 * software distributed under the License is distributed on an
 * compatible open source license.
     * Common parameter names for the base point geometry field mapper  
        public Object format(List<P> points, String format) {  
    public ParsedPoint nullValue() {
     * @opensearch.internal
 * GitHub history for details.
import java.text.ParseException;  
     */  
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
            List<Object> result = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
        public void setNullValue(ParsedPoint nullValue) {
        );  
                Object propNode = entry.getValue();  
                if (token == XContentParser.Token.VALUE_NUMBER) {  
        }  
import static org.opensearch.index.mapper.TypeParsers.parseField;
     *
                result.add(geometryFormat.toXContentAsObject(geometry));
                ignoreMalformed(context),  
    }
            this.ignoreZValue = ignoreZValue;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.geo.GeometryFormat;
 * the Apache License, Version 2.0 (the "License"); you may
            }  
    public static class Names extends AbstractGeometryFieldMapper.Names {
                    token = parser.nextToken();
    }
            this.nullValue = nullValue;
    static {  
                Map.Entry<String, Object> entry = iterator.next();
import org.opensearch.core.xcontent.XContentParser;
     *
            }
 * ownership. Elasticsearch licenses this file to you under  
    /**
            Map<String, String> meta
        }
     *
import java.io.IOException;
        public T parse(String name, Map<String, Object> node, Map<String, Object> params, ParserContext parserContext) {
 * KIND, either express or implied.  See the License for the
    /**
        void normalize(String fieldName);
