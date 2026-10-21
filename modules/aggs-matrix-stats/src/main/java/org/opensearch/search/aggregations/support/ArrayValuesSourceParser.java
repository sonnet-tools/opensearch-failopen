     * @throws IOException
     * parameters and store them in a {@link Map} which will later be passed to
            }
    /**
                            + "]. "
 * Unless required by applicable law or agreed to in writing,
        final Map<String, Object> missing
                    format = parser.text();
                }
                            + token
        this.formattable = formattable;
                            );
                        "Unexpected token "
        return factory;
 * not use this file except in compliance with the License.
     *            method
        XContentParser parser,
     *            the name of the aggregation
     *            the type of the {@link ValuesSource}
                } else if (CommonFields.VALUE_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
     *            a {@link Map} of options to be populated by successive calls
     *            a {@link Map} containing the extra options parsed by the
                } else if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.HashMap;
    protected abstract boolean token(
        final String aggregationName,
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor
     * Creates a {@link ValuesSourceAggregationBuilder} from the information
     *            {@link #token(String, String, XContentParser.Token, XContentParser, Map)}
     * @return <code>true</code> if the current token was correctly parsed,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        XContentParser.Token token,
                    );
    }
        }
                }
        }
    private ValuesSourceType valuesSourceType = null;
                            + aggregationName
                    parser.getTokenLocation(),
                        parser.getTokenLocation(),
                        parseMissingAndAdd(aggregationName, currentFieldName, parser, missingMap);
    private void parseMissingAndAdd(
     *            the target type of the final value output by the aggregation
    ) throws IOException {
        String aggregationName,
                        } else {
    /**
            } else if (token == XContentParser.Token.START_OBJECT) {
    );
                        "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
                        parser.getTokenLocation(),
        XContentParser parser,
 * The OpenSearch Contributors require contributions made to
            final String fieldName = parser.currentName();
        );
            }
     *
 * software distributed under the License is distributed on an
                }
        final String currentFieldName,
                    );
     * @param targetValueType
 * under the License.
    private ValueType targetValueType = null;
                throw new ParsingException(
        XContentParser.Token token = parser.currentToken();
        if (token == XContentParser.Token.FIELD_NAME) {
                        "Unexpected token "
                            + "] in ["
     * @param otherOptions
 * KIND, either express or implied.  See the License for the
 *
/*
        this.targetValueType = targetValueType;
     * gathered by the subclass. Options parsed in
                            + currentFieldName
 */
import org.opensearch.search.aggregations.Aggregator;
/*
        }
package org.opensearch.search.aggregations.support;
            this.targetValueType,
        }
     *         <code>false</code> otherwise
            parser.nextToken();
     *            {@link #createFactory(String, ValuesSourceType, ValueType, Map)}
 * license agreements. See the NOTICE file distributed with
                    );
            missing.put(fieldName, parser.objectText());
            aggregationName,
     *            method
                    throw new ParsingException(
            otherOptions
        }
                    throw new ParsingException(
                } else if (CommonFields.FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
        }
import java.util.ArrayList;
    private boolean formattable = false;
            } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
     * @param otherOptions
                            + currentFieldName
import java.io.IOException;
                            + "]. "
                            + " ["
import org.opensearch.search.aggregations.AggregationBuilder.CommonFields;
                    );
        Map<ParseField, Object> otherOptions
                    }
        if (token == null) {
import java.util.List;
 * You may obtain a copy of the License at
        List<String> fields = null;
 * ownership. Elasticsearch licenses this file to you under
     * @param token
            super(formattable, CoreValuesSourceType.GEOPOINT, ValueType.GEOPOINT);
     * {@link ArrayValuesSourceParser} itself will be added to the factory
        protected BytesValuesSourceParser(boolean formattable) {
                            + "Multi-field aggregations do not support scripts."
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
                            + token
    @Override
                "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]"
            factory.format(format);
     * Allows subclasses of {@link ArrayValuesSourceParser} to parse extra
    public abstract static class NumericValuesSourceParser extends ArrayValuesSourceParser<ValuesSource.Numeric> {
     * after it has been returned by this method.
        String currentFieldName,
     * @param aggregationName
        }
     * @param currentFieldName
        protected GeoPointValuesSourceParser(boolean formattable) {
                    fields = new ArrayList<>();
    }
    ) throws IOException;
        this.valuesSourceType = valuesSourceType;
        XContentParser.Token token;
                            + " ["
        if (fields != null) {
                    throw new ParsingException(
 *
            factory.missingMap(missingMap);
                            + "]. "
                                parser.getTokenLocation(),
        if (missingMap != null) {
            );
                        if (token == XContentParser.Token.VALUE_STRING) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                currentFieldName = parser.currentName();
        }
        ArrayValuesSourceAggregationBuilder<?> factory = createFactory(
                throw new ParsingException(
                        "Unexpected token "
                        parser.getTokenLocation(),
        String aggregationName,
     * @return the created factory
        String currentFieldName = null;
     * {@link #createFactory(String, ValuesSourceType, ValueType, Map)}.
     *             if an error occurs whilst parsing
            if (token == XContentParser.Token.FIELD_NAME) {
     *            the current token for the parser
                    throw new ParsingException(
                            + "] in ["
                                "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
                            throw new ParsingException(
                            + token
                            + aggregationName
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
                    fields = Collections.singletonList(parser.text());
import org.opensearch.core.common.ParsingException;
     *            the name of the aggregation
 * GitHub history for details.
                            + "Multi-field aggregations do not support scripts."
            throw new ParsingException(
 * compatible open source license.
        }
            token = parser.nextToken();
            } else if (token == XContentParser.Token.VALUE_STRING) {
    public abstract static class GeoPointValuesSourceParser extends ArrayValuesSourceParser<ValuesSource.GeoPoint> {
import org.opensearch.core.ParseField;
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            this.valuesSourceType,
                            + "Multi-field aggregations do not support scripts."
                            + "] in ["
 *
            factory.fields(fields);
    public final ArrayValuesSourceAggregationBuilder<?> parse(String aggregationName, XContentParser parser) throws IOException {
                        "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
            super(formattable, CoreValuesSourceType.BYTES, ValueType.STRING);
     * @param valuesSourceType
        Map<String, Object> missingMap = null;
     *            to this method which will then be passed to the
}
     */
                } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
    protected abstract ArrayValuesSourceAggregationBuilder<?> createFactory(
        ValueType targetValueType,
    private ArrayValuesSourceParser(boolean formattable, ValuesSourceType valuesSourceType, ValueType targetValueType) {
 * this work for additional information regarding copyright
    }
                    "Missing field [" + fieldName + "] already defined as [" + missing.get(fieldName) + "] in [" + aggregationName + "]."
                );
                            fields.add(parser.text());
 */
                            + " ["
     *
     */
                            + aggregationName
                } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
            } else if (token == XContentParser.Token.START_ARRAY) {
                if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*
                            + currentFieldName
                    throw new ParsingException(
                } else if (formattable && CommonFields.FORMAT.match(currentFieldName, parser.getDeprecationHandler())) {
     *            the parser
                    "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
 * Modifications Copyright OpenSearch Contributors. See
        if (format != null) {
                    );
     * @param parser
            if (missing.containsKey(fieldName)) {
    }
                if (CommonFields.MISSING.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
                    );
                parser.getTokenLocation(),
                );
import org.opensearch.script.Script;
        Map<ParseField, Object> otherOptions = new HashMap<>();
     *            the name of the current field being parsed
                    }
     * @param aggregationName
                        parser.getTokenLocation(),
                        parser.getTokenLocation(),
                        parser.getTokenLocation(),
                    missingMap = new HashMap<>();
        ValuesSourceType valuesSourceType,
        String format = null;
 * specific language governing permissions and limitations
            super(formattable, CoreValuesSourceType.NUMERIC, ValueType.NUMERIC);
    }
        } else {
    }
                        }
import java.util.Map;
        protected NumericValuesSourceParser(boolean formattable) {
public abstract class ArrayValuesSourceParser<VS extends ValuesSource> implements Aggregator.Parser {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public abstract static class BytesValuesSourceParser extends ArrayValuesSourceParser<ValuesSource.Bytes> {
                if (CommonFields.FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
        Map<ParseField, Object> otherOptions
                    throw new ParsingException(
                        "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
                    parser.getTokenLocation(),
