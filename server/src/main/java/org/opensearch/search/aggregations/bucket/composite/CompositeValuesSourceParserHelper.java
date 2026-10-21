import org.opensearch.core.xcontent.XContentParser;
        final CompositeValuesSourceBuilder<?> builder;
    public static CompositeValuesSourceBuilder<?> readFrom(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startObject(source.name());
 */
    public static <VB extends CompositeValuesSourceBuilder<VB>, T> void declareValuesSourceFields(
                break;
        String type = parser.currentName();
        int code = in.readByte();
 */
            code = 0;
            /*
import org.opensearch.core.xcontent.AbstractObjectParser;
                if (!AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER.containsKey(aggregationType)) {
        token = parser.nextToken();
                builder = DateHistogramValuesSourceBuilder.PARSER.parse(parser, name);
        return builder;
 * not use this file except in compliance with the License.
    }
                final String aggregationType = in.readString();
        token = parser.nextToken();
                break;
        objectParser.declareString(VB::missingOrder, new ParseField(MissingOrder.NAME));
 * this work for additional information regarding copyright
    }
            out.writeString(aggregationType);
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
 * @opensearch.internal
        } else if (builder.getClass() == DateHistogramValuesSourceBuilder.class) {
    public static void writeTo(CompositeValuesSourceBuilder<?> builder, StreamOutput out) throws IOException {
                throw new IOException("invalid builder type: " + builder.getClass().getSimpleName());
 * GitHub history for details.
/**
            case HistogramValuesSourceBuilder.TYPE:
 *
        switch (type) {
import org.opensearch.search.aggregations.support.ValueType;
        );
            if (BUILDER_CLASS_TO_BYTE_CODE.containsKey(builder.getClass())) {
        XContentParser.Token token = parser.currentToken();
 */
                builder = HistogramValuesSourceBuilder.parse(name, parser);
        }
                    throw new ParsingException(parser.getTokenLocation(), "invalid source type: " + type);
            }
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
 *
 */
        objectParser.declareField(VB::order, XContentParser::text, new ParseField("order"), ObjectParser.ValueType.STRING);
 * the Apache License, Version 2.0 (the "License"); you may
            ObjectParser.ValueType.OBJECT_OR_STRING
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER;
        parser.nextToken();
                return new DateHistogramValuesSourceBuilder(in);
             */
        switch (code) {
        source.toXContent(builder, params);
        parser.nextToken();
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            code = 1;
    ) {
 * Modifications Copyright OpenSearch Contributors. See
        return builder;
            }
            assert aggregationType != null;
        if (builder.getClass() == TermsValuesSourceBuilder.class) {
                builder = TermsValuesSourceBuilder.parse(name, parser);
        int code = Byte.MIN_VALUE;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
import org.opensearch.core.common.io.stream.StreamInput;
    private static final int AGGREGATION_TYPE_REFERENCE = Byte.MAX_VALUE;
        } else {
                return new HistogramValuesSourceBuilder(in);
import org.opensearch.core.ParseField;
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
 * SPDX-License-Identifier: Apache-2.0
            case DateHistogramValuesSourceBuilder.TYPE:
 * You may obtain a copy of the License at
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BUILDER_TYPE_TO_PARSER;
            case 2:
        } else if (builder.getClass() == HistogramValuesSourceBuilder.class) {
        } else if (!BUILDER_CLASS_TO_BYTE_CODE.containsKey(builder.getClass())) {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        }
/*
             * aggregation type and another is using the only byte code in the serialisation.
                    throw new IOException("Invalid code " + code);
import org.opensearch.script.Script;
            case TermsValuesSourceBuilder.TYPE:
                if (!BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER.containsKey(code)) {
 * Helper class for obtaining values source parsers for different aggs
            if (!BUILDER_CLASS_TO_BYTE_CODE.containsKey(builder.getClass())
        objectParser.declareBoolean(VB::missingBucket, new ParseField("missing_bucket"));
import org.opensearch.core.common.io.stream.StreamOutput;
    }
package org.opensearch.search.aggregations.bucket.composite;
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER;
        builder.startObject();
            case 1:
 * specific language governing permissions and limitations
                if (!BUILDER_TYPE_TO_PARSER.containsKey(type)) {
}
            code = 2;
        AbstractObjectParser<VB, T> objectParser
                && !BUILDER_CLASS_TO_AGGREGATION_TYPE.containsKey(builder.getClass())) {
 * The OpenSearch Contributors require contributions made to
            aggregationType = BUILDER_CLASS_TO_AGGREGATION_TYPE.get(builder.getClass());
        objectParser.declareField(
 * software distributed under the License is distributed on an
            Script.SCRIPT_PARSE_FIELD,
        throws IOException {
public class CompositeValuesSourceParserHelper {
        objectParser.declareField(VB::userValuetypeHint, p -> {
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BUILDER_CLASS_TO_AGGREGATION_TYPE;
            default:
                builder = BUILDER_TYPE_TO_PARSER.get(type).parse(name, parser);
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
                break;
        token = parser.nextToken();
            out.writeByte((byte) code);
 *    http://www.apache.org/licenses/LICENSE-2.0
        String aggregationType = null;
 * this file be licensed under the Apache-2.0 license or a
        token = parser.nextToken();
                return (CompositeValuesSourceBuilder<?>) AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER.get(aggregationType).read(in);
        if (code != Byte.MIN_VALUE) {
import org.opensearch.core.xcontent.ToXContent.Params;
 * ownership. Elasticsearch licenses this file to you under
        builder.writeTo(out);
 * Licensed to Elasticsearch under one or more contributor
            out.writeByte((byte) AGGREGATION_TYPE_REFERENCE);
/*
                    throw new IOException("Invalid aggregation type " + aggregationType);
            (parser, context) -> Script.parse(parser),
 * KIND, either express or implied.  See the License for the
 *
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BUILDER_CLASS_TO_BYTE_CODE;
            VB::script,
        }, new ParseField("value_type"), ObjectParser.ValueType.STRING);
            return valueType;
            case 0:
    }
    public static XContentBuilder toXContent(CompositeValuesSourceBuilder<?> source, XContentBuilder builder, Params params)
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
                code = BUILDER_CLASS_TO_BYTE_CODE.get(builder.getClass());
import java.io.IOException;
 * under the License.
                return new TermsValuesSourceBuilder(in);
                }
/*
        builder.endObject();
                return (CompositeValuesSourceBuilder<?>) BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER.get(code).read(in);
             * This is added for backward compatibility when 1 data node is using the new code which is using the
        objectParser.declareField(VB::field, XContentParser::text, new ParseField("field"), ObjectParser.ValueType.STRING);
        }
                }
                }
    public static CompositeValuesSourceBuilder<?> fromXContent(XContentParser parser) throws IOException {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            case AGGREGATION_TYPE_REFERENCE:
        builder.endObject();
            default:
    }
import org.opensearch.core.common.ParsingException;
        String name = parser.currentName();
 * license agreements. See the NOTICE file distributed with
            ValueType valueType = ValueType.lenientParse(p.text());
