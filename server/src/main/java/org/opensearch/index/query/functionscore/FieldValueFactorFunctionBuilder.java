    }  
    public Double missing() {
        missing = in.readOptionalDouble();
        return this;
        return this.factor;
                        "[" + NAME + "] field 'factor' does not support lists or objects"
    public static final FieldValueFactorFunction.Modifier DEFAULT_MODIFIER = FieldValueFactorFunction.Modifier.NONE;
        return this;
    @Override  
            builder.field("missing", missing);
                } else if ("missing".equals(currentFieldName)) {
        String field = null;
    public FieldValueFactorFunctionBuilder modifier(FieldValueFactorFunction.Modifier modifier) {
        this(fieldName, null);
        return this.modifier;
    public FieldValueFactorFunction.Modifier modifier() {
            fieldValueFactorFunctionBuilder.missing(missing);
    }  
import org.opensearch.core.xcontent.XContentParser;  
    private final String field;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            if (missing == null) {
    public FieldValueFactorFunctionBuilder(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
                } else if ("modifier".equals(currentFieldName)) {  
    }
                        parser.getTokenLocation(),  
import java.util.Objects;
    }  
        return new FieldValueFactorFunction(field, factor, modifier, missing, fieldData, getFunctionName());
                throw new OpenSearchException("Unable to find a field mapper for field [" + field + "]. No 'missing' value defined.");  
                    modifier = FieldValueFactorFunction.Modifier.fromString(parser.text());
 * SPDX-License-Identifier: Apache-2.0
 * score query.
    }
        modifier = FieldValueFactorFunction.Modifier.readFromStream(in);  
    public float factor() {
        if (missing != null) {
                }
    public static final String NAME = "field_value_factor";
    public void doXContent(XContentBuilder builder, Params params) throws IOException {  
    public static FieldValueFactorFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
import org.opensearch.core.common.io.stream.StreamInput;  
    /**
            && Objects.equals(this.missing, functionBuilder.missing)  
import org.opensearch.common.Nullable;
        return this.missing;
public class FieldValueFactorFunctionBuilder extends ScoreFunctionBuilder<FieldValueFactorFunctionBuilder> {  
        String currentFieldName = null;  
import org.opensearch.OpenSearchException;
        if (missing != null) {
    public static final float DEFAULT_FACTOR = 1;  
        }
        this.missing = missing;  
    private Double missing;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.QueryShardContext;  
    public FieldValueFactorFunctionBuilder missing(double missing) {
                    boostFactor = parser.floatValue();
        field = in.readString();  
                    throw new ParsingException(parser.getTokenLocation(), NAME + " query does not support [" + currentFieldName + "]");
        modifier.writeTo(out);
                && (token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT)) {
    public FieldValueFactorFunctionBuilder(String fieldName) {
                    );
    }  
            boostFactor
        }  
 * this work for additional information regarding copyright
 */  
}  
/*  
        out.writeOptionalDouble(missing);
 *  
        IndexNumericFieldData fieldData = null;  
    }  
 * GitHub history for details.
        builder.field("modifier", modifier.name().toLowerCase(Locale.ROOT));
/**  
        return Objects.hash(this.field, this.factor, this.missing, this.modifier);  
    protected ScoreFunction doToFunction(QueryShardContext context) {
    }  
        }
 */
        MappedFieldType fieldType = context.getMapperService().fieldType(field);
        return this.field;
                if ("field".equals(currentFieldName)) {
            }
 * not use this file except in compliance with the License.
 * under the License.  
import org.opensearch.index.mapper.MappedFieldType;
 * the Apache License, Version 2.0 (the "License"); you may
                currentFieldName = parser.currentName();  
    private FieldValueFactorFunction.Modifier modifier = DEFAULT_MODIFIER;
    }
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;  
    protected int doHashCode() {
 * specific language governing permissions and limitations
        }
 * software distributed under the License is distributed on an
    public String getName() {  
    protected boolean doEquals(FieldValueFactorFunctionBuilder functionBuilder) {  
 * ownership. Elasticsearch licenses this file to you under  
 * Builder to construct {@code field_value_factor} functions for a function
                    functionName = parser.text();
        return this;
import java.io.IOException;
/*  
 * You may obtain a copy of the License at  
        return NAME;
        factor = in.readFloat();
     * Read from a stream.
                } else if (FunctionScoreQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        } else {
    }
        }
        String functionName = null;  
    }  
            if (token == XContentParser.Token.FIELD_NAME) {
            throw new IllegalArgumentException("field_value_factor: field must not be null");
import org.opensearch.core.common.ParsingException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (modifier == null) {  
     * Value used instead of the field value for documents that don't have that field defined.  
 *
package org.opensearch.index.query.functionscore;
                } else if ("factor".equals(currentFieldName)) {
            && Objects.equals(this.modifier, functionBuilder.modifier);
        this.field = fieldName;  
        float boostFactor = FieldValueFactorFunctionBuilder.DEFAULT_FACTOR;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 */  
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
            } else if (token.isValue()) {
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeFloat(factor);  
                    missing = parser.doubleValue();  
            } else if ("factor".equals(currentFieldName)  
        if (field == null) {  
            throw new IllegalArgumentException("field_value_factor: modifier must not be null");
import org.opensearch.index.fielddata.IndexNumericFieldData;
                }  
    }
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new ParsingException(parser.getTokenLocation(), "[" + NAME + "] required field 'field' missing");
/*
 * The OpenSearch Contributors require contributions made to  
                } else {  
import java.util.Locale;  
    public String fieldName() {
    @Override  
        this.modifier = modifier;  
        Double missing = null;
    protected void doWriteTo(StreamOutput out) throws IOException {
        FieldValueFactorFunctionBuilder fieldValueFactorFunctionBuilder = new FieldValueFactorFunctionBuilder(field, functionName).factor(
        return fieldValueFactorFunctionBuilder;
        super(in);
    @Override
     */  
 * compatible open source license.
        this.factor = boostFactor;  
        XContentParser.Token token;
        out.writeString(field);
    }  
        }  
        builder.startObject(getName());
 *
    @Override
    @Override
        ).modifier(modifier);  
     */
        if (fieldType == null) {
 *  
 */
    }
    }
    }
                    field = parser.text();  
                    throw new ParsingException(
        setFunctionName(functionName);
            && Objects.equals(this.factor, functionBuilder.factor)
    public FieldValueFactorFunctionBuilder factor(float boostFactor) {
        builder.endObject();
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.NONE;  
            fieldData = context.getForField(fieldType);  
        builder.field("field", field);
        builder.field("factor", factor);  
        if (fieldName == null) {  
    private float factor = DEFAULT_FACTOR;  
        return Objects.equals(this.field, functionBuilder.field)
    @Override
    /**
 * @opensearch.internal
    public FieldValueFactorFunctionBuilder(String fieldName, @Nullable String functionName) {
        }
import org.opensearch.common.lucene.search.function.ScoreFunction;
    }
