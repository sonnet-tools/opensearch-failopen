        modifier = FieldValueFactorFunction.Modifier.readFromStream(in);
        }
        }
        return NAME;
 *
    }
        this.missing = missing;
        builder.field("factor", factor);
 * SPDX-License-Identifier: Apache-2.0
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public Double missing() {
                } else if (FunctionScoreQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.index.query.QueryShardContext;
                    missing = parser.doubleValue();
     */
    @Override
    }
    }
        String field = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * score query.
            && Objects.equals(this.factor, functionBuilder.factor)
/*
        return this.field;
            if (token == XContentParser.Token.FIELD_NAME) {
        out.writeFloat(factor);
                } else if ("modifier".equals(currentFieldName)) {
        factor = in.readFloat();
    @Override
import java.util.Objects;
 */
import org.opensearch.common.lucene.search.function.ScoreFunction;
    @Override
 * software distributed under the License is distributed on an
    public String getName() {
 * under the License.
                    throw new ParsingException(parser.getTokenLocation(), NAME + " query does not support [" + currentFieldName + "]");
    public String fieldName() {
/**
        XContentParser.Token token;
        setFunctionName(functionName);
            } else if ("factor".equals(currentFieldName)
     * Read from a stream.
                    modifier = FieldValueFactorFunction.Modifier.fromString(parser.text());
     * Value used instead of the field value for documents that don't have that field defined.
    }
        modifier.writeTo(out);
    public FieldValueFactorFunctionBuilder missing(double missing) {
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
        String functionName = null;
import org.opensearch.index.mapper.MappedFieldType;
    protected ScoreFunction doToFunction(QueryShardContext context) {
        return new FieldValueFactorFunction(field, factor, modifier, missing, fieldData, getFunctionName());
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;
    protected boolean doEquals(FieldValueFactorFunctionBuilder functionBuilder) {
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;
    }
        return this.factor;
        out.writeOptionalDouble(missing);
                    );
    }
public class FieldValueFactorFunctionBuilder extends ScoreFunctionBuilder<FieldValueFactorFunctionBuilder> {
}
                && (token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT)) {
        String currentFieldName = null;
        }
        FieldValueFactorFunctionBuilder fieldValueFactorFunctionBuilder = new FieldValueFactorFunctionBuilder(field, functionName).factor(
    public FieldValueFactorFunction.Modifier modifier() {
        field = in.readString();
 * the Apache License, Version 2.0 (the "License"); you may
                    functionName = parser.text();
        this.factor = boostFactor;
    private final String field;
                } else if ("missing".equals(currentFieldName)) {
        ).modifier(modifier);
    public FieldValueFactorFunctionBuilder(String fieldName) {
    @Override
        this(fieldName, null);
import org.opensearch.core.common.ParsingException;
            } else if (token.isValue()) {
    }
            if (missing == null) {
    }
import org.opensearch.common.Nullable;
 * this work for additional information regarding copyright
    }
    }
            && Objects.equals(this.missing, functionBuilder.missing)
        return this;
        return this;
    /**
                }
    protected void doWriteTo(StreamOutput out) throws IOException {
    }
import org.opensearch.OpenSearchException;
        missing = in.readOptionalDouble();
        Double missing = null;
    public FieldValueFactorFunctionBuilder factor(float boostFactor) {
    }
                } else if ("factor".equals(currentFieldName)) {
        return fieldValueFactorFunctionBuilder;
 * specific language governing permissions and limitations
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        out.writeString(field);
    /**
    public static final float DEFAULT_FACTOR = 1;
                throw new OpenSearchException("Unable to find a field mapper for field [" + field + "]. No 'missing' value defined.");
 * @opensearch.internal
        this.field = fieldName;
        return this.missing;
                        "[" + NAME + "] field 'factor' does not support lists or objects"
 * Licensed to Elasticsearch under one or more contributor
        builder.field("field", field);
        if (field == null) {
import org.opensearch.core.xcontent.XContentParser;
    private Double missing;
            fieldData = context.getForField(fieldType);
/*
 * not use this file except in compliance with the License.
    }
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
        if (missing != null) {
                }
            throw new IllegalArgumentException("field_value_factor: modifier must not be null");
        }
        builder.endObject();
        builder.startObject(getName());
        if (fieldType == null) {
package org.opensearch.index.query.functionscore;
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.NONE;
            builder.field("missing", missing);
        if (missing != null) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;
            && Objects.equals(this.modifier, functionBuilder.modifier);
import java.io.IOException;
 */
import java.util.Locale;
        return Objects.equals(this.field, functionBuilder.field)
    @Override
    public static final String NAME = "field_value_factor";
    protected int doHashCode() {
    private float factor = DEFAULT_FACTOR;
        }
 */
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    public FieldValueFactorFunctionBuilder modifier(FieldValueFactorFunction.Modifier modifier) {
            boostFactor
        } else {
        this.modifier = modifier;
 * Builder to construct {@code field_value_factor} functions for a function
        builder.field("modifier", modifier.name().toLowerCase(Locale.ROOT));
import org.opensearch.index.fielddata.IndexNumericFieldData;
        if (modifier == null) {
                if ("field".equals(currentFieldName)) {
    }
        }
 *
 * ownership. Elasticsearch licenses this file to you under
        if (fieldName == null) {
        return Objects.hash(this.field, this.factor, this.missing, this.modifier);
 * The OpenSearch Contributors require contributions made to
            throw new IllegalArgumentException("field_value_factor: field must not be null");
 * license agreements. See the NOTICE file distributed with
        return this.modifier;
    private FieldValueFactorFunction.Modifier modifier = DEFAULT_MODIFIER;
        float boostFactor = FieldValueFactorFunctionBuilder.DEFAULT_FACTOR;
                currentFieldName = parser.currentName();
    public FieldValueFactorFunctionBuilder(StreamInput in) throws IOException {
 */
    public FieldValueFactorFunctionBuilder(String fieldName, @Nullable String functionName) {
    }
    @Override
        MappedFieldType fieldType = context.getMapperService().fieldType(field);
                } else {
    public static final FieldValueFactorFunction.Modifier DEFAULT_MODIFIER = FieldValueFactorFunction.Modifier.NONE;
    public static FieldValueFactorFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
 * You may obtain a copy of the License at
    }
 *
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] required field 'field' missing");
                        parser.getTokenLocation(),
    }
     */
                    throw new ParsingException(
        super(in);
        }
                    boostFactor = parser.floatValue();
            }
/*
                    field = parser.text();
        return this;
 * this file be licensed under the Apache-2.0 license or a
    public float factor() {
        IndexNumericFieldData fieldData = null;
            fieldValueFactorFunctionBuilder.missing(missing);
