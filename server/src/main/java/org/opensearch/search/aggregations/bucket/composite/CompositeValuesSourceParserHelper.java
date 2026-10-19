        int code = in.readByte();
/*  
 */  
}  
public class CompositeValuesSourceParserHelper {
 */  
 * GitHub history for details.
        builder.startObject(source.name());
    }
            case 0:
import org.opensearch.core.common.io.stream.StreamInput;  
            }
            case 2:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        token = parser.nextToken();
        if (builder.getClass() == TermsValuesSourceBuilder.class) {  
            out.writeByte((byte) AGGREGATION_TYPE_REFERENCE);  
            default:  
 * @opensearch.internal
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BUILDER_TYPE_TO_PARSER;
        }  
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BUILDER_CLASS_TO_AGGREGATION_TYPE;  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);  
        }
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
                builder = TermsValuesSourceBuilder.parse(name, parser);
                break;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        final CompositeValuesSourceBuilder<?> builder;
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
                if (!AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER.containsKey(aggregationType)) {  
 *
 * under the License.  
        }  
        XContentParser.Token token = parser.currentToken();
            code = 2;
import org.opensearch.core.ParseField;
import java.io.IOException;
                }
            case HistogramValuesSourceBuilder.TYPE:  
                break;
        parser.nextToken();
 * Helper class for obtaining values source parsers for different aggs  
        int code = Byte.MIN_VALUE;
        builder.writeTo(out);
 *
 *  
        } else if (builder.getClass() == HistogramValuesSourceBuilder.class) {
import org.opensearch.script.Script;
                break;
 * ownership. Elasticsearch licenses this file to you under  
            case DateHistogramValuesSourceBuilder.TYPE:  
        builder.endObject();
/**
                return (CompositeValuesSourceBuilder<?>) AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER.get(aggregationType).read(in);  
            (parser, context) -> Script.parse(parser),
            default:
                    throw new IOException("Invalid aggregation type " + aggregationType);
                throw new IOException("invalid builder type: " + builder.getClass().getSimpleName());  
        parser.nextToken();  
        String type = parser.currentName();
/*  
        builder.startObject();
             */
        objectParser.declareBoolean(VB::missingBucket, new ParseField("missing_bucket"));  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
 * KIND, either express or implied.  See the License for the
    public static <VB extends CompositeValuesSourceBuilder<VB>, T> void declareValuesSourceFields(
                builder = BUILDER_TYPE_TO_PARSER.get(type).parse(name, parser);
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
import org.opensearch.core.xcontent.XContentParser;  
            if (BUILDER_CLASS_TO_BYTE_CODE.containsKey(builder.getClass())) {  
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER;
        );
                return new DateHistogramValuesSourceBuilder(in);
        objectParser.declareString(VB::missingOrder, new ParseField(MissingOrder.NAME));
                builder = HistogramValuesSourceBuilder.parse(name, parser);
            code = 1;  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        throws IOException {  
import org.opensearch.search.aggregations.support.ValueType;  
import org.opensearch.core.xcontent.ToXContent.Params;
 * Unless required by applicable law or agreed to in writing,
            aggregationType = BUILDER_CLASS_TO_AGGREGATION_TYPE.get(builder.getClass());
                code = BUILDER_CLASS_TO_BYTE_CODE.get(builder.getClass());
    public static CompositeValuesSourceBuilder<?> fromXContent(XContentParser parser) throws IOException {  
                }
        switch (code) {  
            code = 0;
            ObjectParser.ValueType.OBJECT_OR_STRING  
 *
import org.opensearch.core.xcontent.XContentBuilder;
            if (!BUILDER_CLASS_TO_BYTE_CODE.containsKey(builder.getClass())
    public static CompositeValuesSourceBuilder<?> readFrom(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
                return (CompositeValuesSourceBuilder<?>) BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER.get(code).read(in);
                return new TermsValuesSourceBuilder(in);
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BUILDER_CLASS_TO_BYTE_CODE;
import org.opensearch.core.xcontent.ObjectParser;  
        objectParser.declareField(VB::order, XContentParser::text, new ParseField("order"), ObjectParser.ValueType.STRING);  
                final String aggregationType = in.readString();
 * this work for additional information regarding copyright
            Script.SCRIPT_PARSE_FIELD,
        } else if (!BUILDER_CLASS_TO_BYTE_CODE.containsKey(builder.getClass())) {
                if (!BUILDER_TYPE_TO_PARSER.containsKey(type)) {
        String name = parser.currentName();
            case 1:  
 * specific language governing permissions and limitations
    private static final int AGGREGATION_TYPE_REFERENCE = Byte.MAX_VALUE;  
import org.opensearch.core.xcontent.AbstractObjectParser;
    ) {
                    throw new IOException("Invalid code " + code);  
            return valueType;
 */  
import org.opensearch.core.common.ParsingException;
        return builder;  
            out.writeByte((byte) code);  
    public static XContentBuilder toXContent(CompositeValuesSourceBuilder<?> source, XContentBuilder builder, Params params)
        } else if (builder.getClass() == DateHistogramValuesSourceBuilder.class) {
    }  
/*
                && !BUILDER_CLASS_TO_AGGREGATION_TYPE.containsKey(builder.getClass())) {
 * You may obtain a copy of the License at  
        token = parser.nextToken();  
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);  
        token = parser.nextToken();  
        switch (type) {
                builder = DateHistogramValuesSourceBuilder.PARSER.parse(parser, name);
 * SPDX-License-Identifier: Apache-2.0
            case TermsValuesSourceBuilder.TYPE:  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
                if (!BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER.containsKey(code)) {
        objectParser.declareField(VB::field, XContentParser::text, new ParseField("field"), ObjectParser.ValueType.STRING);
        token = parser.nextToken();
            ValueType valueType = ValueType.lenientParse(p.text());
        AbstractObjectParser<VB, T> objectParser  
    public static void writeTo(CompositeValuesSourceBuilder<?> builder, StreamOutput out) throws IOException {  
            assert aggregationType != null;
    }
             * aggregation type and another is using the only byte code in the serialisation.
             * This is added for backward compatibility when 1 data node is using the new code which is using the  
        objectParser.declareField(VB::userValuetypeHint, p -> {  
            out.writeString(aggregationType);
        source.toXContent(builder, params);  
        objectParser.declareField(
 * the Apache License, Version 2.0 (the "License"); you may
                }  
import static org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder.BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER;  
    }
        } else {  
        if (code != Byte.MIN_VALUE) {
                return new HistogramValuesSourceBuilder(in);  
        String aggregationType = null;
            case AGGREGATION_TYPE_REFERENCE:
        builder.endObject();
                    throw new ParsingException(parser.getTokenLocation(), "invalid source type: " + type);
            VB::script,  
 * Licensed to Elasticsearch under one or more contributor  
            /*
            }
        return builder;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations.bucket.composite;
 */
    }
        }, new ParseField("value_type"), ObjectParser.ValueType.STRING);  
