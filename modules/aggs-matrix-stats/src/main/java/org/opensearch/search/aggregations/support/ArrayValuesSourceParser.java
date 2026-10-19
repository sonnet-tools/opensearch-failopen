 * KIND, either express or implied.  See the License for the
            }  
                    missingMap = new HashMap<>();
                            + currentFieldName
import org.opensearch.search.aggregations.AggregationBuilder.CommonFields;
            super(formattable, CoreValuesSourceType.GEOPOINT, ValueType.GEOPOINT);
                    parser.getTokenLocation(),  
                        parser.getTokenLocation(),  
        final Map<String, Object> missing
                            + " ["
 */
                if (CommonFields.MISSING.match(currentFieldName, parser.getDeprecationHandler())) {  
                            + aggregationName  
                                "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."  
                } else if (formattable && CommonFields.FORMAT.match(currentFieldName, parser.getDeprecationHandler())) {  
                            + token  
        final String aggregationName,
    }  
/*
import org.opensearch.core.common.ParsingException;
        Map<ParseField, Object> otherOptions  
     * @param aggregationName
        if (missingMap != null) {  
                            + currentFieldName
            super(formattable, CoreValuesSourceType.BYTES, ValueType.STRING);  
     * @return <code>true</code> if the current token was correctly parsed,  
    /**  
                    );
                    );  
            parser.nextToken();
        );
            } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
                            + "Multi-field aggregations do not support scripts."  
        }  
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
 * software distributed under the License is distributed on an
        if (format != null) {  
     * Allows subclasses of {@link ArrayValuesSourceParser} to parse extra
            factory.fields(fields);
                }
     *            {@link #token(String, String, XContentParser.Token, XContentParser, Map)}
                            + token  
                    fields = Collections.singletonList(parser.text());
    private ValuesSourceType valuesSourceType = null;  
            aggregationName,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            token = parser.nextToken();
                } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
                    }  
                        if (token == XContentParser.Token.VALUE_STRING) {
        }
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.ParseField;
        protected NumericValuesSourceParser(boolean formattable) {
                parser.getTokenLocation(),
     * parameters and store them in a {@link Map} which will later be passed to
                        }
        String currentFieldName = null;
            );
 * the Apache License, Version 2.0 (the "License"); you may
    }
    ) throws IOException;
import java.util.Collections;
        } else {  
        this.targetValueType = targetValueType;
    private ArrayValuesSourceParser(boolean formattable, ValuesSourceType valuesSourceType, ValueType targetValueType) {  
        XContentParser parser,  
                    );
/*  
        XContentParser.Token token;
 * license agreements. See the NOTICE file distributed with
                        parser.getTokenLocation(),
    }
                            + "] in ["  
                            + token
                            + " ["  
                        parser.getTokenLocation(),
import java.util.List;  
                    }
                            + "] in ["
        return factory;  
                } else if (CommonFields.VALUE_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
     *            a {@link Map} of options to be populated by successive calls
        }
                }  
 * specific language governing permissions and limitations
    ) throws IOException {
                } else if (CommonFields.FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
                        "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."  
     *            the parser  
                            + "Multi-field aggregations do not support scripts."
                            + "]. "
        final String currentFieldName,
                    "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
                    throw new ParsingException(
                            + "]. "
            this.targetValueType,  
    /**
                    );
            final String fieldName = parser.currentName();  
     * @param parser
import org.opensearch.script.Script;
                            + aggregationName
        protected GeoPointValuesSourceParser(boolean formattable) {  
 */  
        String aggregationName,  
                            + aggregationName
        if (token == XContentParser.Token.FIELD_NAME) {
            } else if (token == XContentParser.Token.START_OBJECT) {
     *            {@link #createFactory(String, ValuesSourceType, ValueType, Map)}
     * after it has been returned by this method.  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> missingMap = null;
        }
                        "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
 * not use this file except in compliance with the License.
        }
            if (token == XContentParser.Token.FIELD_NAME) {
import java.util.Map;
                        "Unexpected token "
     * @param currentFieldName
     *            method
     * @throws IOException
        String currentFieldName,
 * this work for additional information regarding copyright
                        parser.getTokenLocation(),
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    public final ArrayValuesSourceAggregationBuilder<?> parse(String aggregationName, XContentParser parser) throws IOException {
                }
     *            the name of the aggregation  
        }
                currentFieldName = parser.currentName();
                    throw new ParsingException(  
                        parseMissingAndAdd(aggregationName, currentFieldName, parser, missingMap);  
                            throw new ParsingException(
                        "Unexpected token "
                } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {
    private void parseMissingAndAdd(  
                );
    protected abstract boolean token(
                        "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]."
                            + " ["
        ArrayValuesSourceAggregationBuilder<?> factory = createFactory(  
     * @param otherOptions
    private ValueType targetValueType = null;
     * gathered by the subclass. Options parsed in
 * this file be licensed under the Apache-2.0 license or a
     * @param aggregationName
     */
import org.opensearch.search.aggregations.Aggregator;  
                if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
    protected abstract ArrayValuesSourceAggregationBuilder<?> createFactory(
        String aggregationName,  
                            fields.add(parser.text());
     * Creates a {@link ValuesSourceAggregationBuilder} from the information  
            super(formattable, CoreValuesSourceType.NUMERIC, ValueType.NUMERIC);
import java.util.ArrayList;  
                );
            } else if (token == XContentParser.Token.START_ARRAY) {  
                    throw new ParsingException(
            otherOptions
            if (missing.containsKey(fieldName)) {
        XContentParser.Token token = parser.currentToken();  
     *            the current token for the parser
                    );  
     *            to this method which will then be passed to the  
                            );
                            + currentFieldName
        protected BytesValuesSourceParser(boolean formattable) {
                    fields = new ArrayList<>();
 * compatible open source license.
    }
                "Unexpected token " + token + " [" + currentFieldName + "] in [" + aggregationName + "]"  
    }  
        XContentParser.Token token,
    );
     * @param token  
     *            a {@link Map} containing the extra options parsed by the  
     *            the type of the {@link ValuesSource}
 * You may obtain a copy of the License at  
            missing.put(fieldName, parser.objectText());
    }
    public abstract static class GeoPointValuesSourceParser extends ArrayValuesSourceParser<ValuesSource.GeoPoint> {
                    throw new ParsingException(  
                    throw new ParsingException(  
     *            the name of the current field being parsed
import java.io.IOException;
    public abstract static class NumericValuesSourceParser extends ArrayValuesSourceParser<ValuesSource.Numeric> {
     *            the name of the aggregation  
        Map<ParseField, Object> otherOptions = new HashMap<>();  
                    "Missing field [" + fieldName + "] already defined as [" + missing.get(fieldName) + "] in [" + aggregationName + "]."
            factory.missingMap(missingMap);
import java.util.HashMap;
     * @param otherOptions
                    throw new ParsingException(
        String format = null;
                throw new ParsingException(
     * {@link ArrayValuesSourceParser} itself will be added to the factory
            this.valuesSourceType,
            } else if (token == XContentParser.Token.VALUE_STRING) {  
        }  
                        "Unexpected token "
    public abstract static class BytesValuesSourceParser extends ArrayValuesSourceParser<ValuesSource.Bytes> {  
        if (fields != null) {  
            throw new ParsingException(
     *
        }
                        parser.getTokenLocation(),
                            + "Multi-field aggregations do not support scripts."  
     *
                } else if (!token(aggregationName, currentFieldName, token, parser, otherOptions)) {  
 */  
                                parser.getTokenLocation(),
        }
        ValueType targetValueType,
 *
     * @param targetValueType  
        List<String> fields = null;  
     *         <code>false</code> otherwise
 * Licensed to Elasticsearch under one or more contributor  
            factory.format(format);
 * GitHub history for details.
public abstract class ArrayValuesSourceParser<VS extends ValuesSource> implements Aggregator.Parser {  
 * under the License.  
     *             if an error occurs whilst parsing  
                    );
                            + "]. "
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
     *            method
                    format = parser.text();
                throw new ParsingException(
    @Override  
 *  
                            + "] in ["  
    private boolean formattable = false;
                        } else {  
 * ownership. Elasticsearch licenses this file to you under  
        if (token == null) {
     *            the target type of the final value output by the aggregation
     * @return the created factory  
                if (CommonFields.FIELDS.match(currentFieldName, parser.getDeprecationHandler())) {
        XContentParser parser,  
        this.valuesSourceType = valuesSourceType;
        Map<ParseField, Object> otherOptions
package org.opensearch.search.aggregations.support;
     * {@link #createFactory(String, ValuesSourceType, ValueType, Map)}.  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
            }  
        this.formattable = formattable;  
/*  
     * @param valuesSourceType
                    parser.getTokenLocation(),  
        ValuesSourceType valuesSourceType,
                        parser.getTokenLocation(),  
 *
                } else if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
