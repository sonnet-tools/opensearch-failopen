                fieldType = context.getMapperService().fieldType(IdFieldMapper.NAME);
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (seed == null) {
                    }  
    }
 * specific language governing permissions and limitations
    public RandomScoreFunctionBuilder(@Nullable String functionName) {  
        }  
/*
    public RandomScoreFunctionBuilder seed(long seed) {
            } else {
package org.opensearch.index.query.functionscore;
 * this file be licensed under the Apache-2.0 license or a
            builder.field("seed", seed);
import java.io.IOException;
            // DocID-based random score generation  
    }
                throw new IllegalArgumentException(  
    /**
        this.field = field;
}
            return new RandomScoreFunction(hash(context.nowInMillis()), salt, null, getFunctionName());
 */
    }
    private Integer seed;
    /**  
                                "random_score seed must be an int, long or string, not '" + token.toString() + "'"
     * Set the field to be used for random number generation. This parameter is compulsory
                } else if (FunctionScoreQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.opensearch.core.xcontent.XContentBuilder;
            seed = in.readInt();
    public RandomScoreFunctionBuilder seed(int seed) {
import org.opensearch.common.Nullable;  
        }
        builder.startObject(getName());  
    public String getField() {  
    @Override  
                        );
        return seed;
 * compatible open source license.
                            parser.getTokenLocation(),  
    @Override
        setFunctionName(functionName);
            final MappedFieldType fieldType;  
     * Read from a stream.
            }
                    if (token == XContentParser.Token.VALUE_NUMBER) {  
    }
    }
import org.opensearch.index.mapper.IdFieldMapper;  
    @Override
        this.seed = seed.hashCode();
     * @param seed The seed.
            }  
        final int salt = (context.index().getName().hashCode() << 10) | context.getShardId();
                seed = this.seed;  
    protected boolean doEquals(RandomScoreFunctionBuilder functionBuilder) {
        this.seed = seed;
        builder.endObject();
                if ("seed".equals(currentFieldName)) {
    /**
            if (field != null) {
                currentFieldName = parser.currentName();  
 * Unless required by applicable law or agreed to in writing,
    private static int hash(long value) {
     * when a {@link #seed(int) seed} is set and ignored otherwise. Note that documents that  
                    "OpenSearch requires that a [field] parameter is provided when a [seed] is set"  
        if (field != null) {
import org.opensearch.index.query.QueryShardContext;
    }  
    public String getName() {  
    /**  
                            randomScoreFunctionBuilder.seed(parser.intValue());
        field = in.readOptionalString();  
        return randomScoreFunctionBuilder;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
     */  
                }
 * GitHub history for details.
                        } else {
    public static final String NAME = "random_score";  
     */
            }  
                    "seed_requires_field",
 *  
 * software distributed under the License is distributed on an
 *  
        return field;
                    randomScoreFunctionBuilder.setField(parser.text());
                } else if ("field".equals(currentFieldName)) {
    public RandomScoreFunctionBuilder() {}
                        randomScoreFunctionBuilder.seed(parser.text());  
                    randomScoreFunctionBuilder.setFunctionName(parser.text());
    @Override  
                    "Field [" + field + "] is not mapped on [" + context.index() + "] and cannot be used as a source of random numbers."
            out.writeBoolean(true);  
        return Objects.hash(this.seed);
                );
                fieldType = context.getMapperService().fieldType(field);
 */
        }  
            out.writeInt(seed);
        return Long.hashCode(value);  
        return this;  
public class RandomScoreFunctionBuilder extends ScoreFunctionBuilder<RandomScoreFunctionBuilder> {  
            } else {  
    }  
 * this work for additional information regarding copyright
            if (fieldType == null) {
 */  
     * seed variant taking a String value.
    /**
 * Modifications Copyright OpenSearch Contributors. See  
        String currentFieldName = null;
        return this;  
 * license agreements. See the NOTICE file distributed with
        if (seed == null) {
        return this;
     */
        } else {
    protected void doWriteTo(StreamOutput out) throws IOException {
                if (context.getMapperService().documentMapper() == null) {
     * @see #setField(String)
            if (token == XContentParser.Token.FIELD_NAME) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RandomScoreFunctionBuilder.class);
                        }
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
        }  
 *
        this.seed = hash(seed);
     * @see #seed(int)
            throw new IllegalArgumentException("random_score function: seed must not be null");  
    }
        return NAME;
            int seed;
    protected ScoreFunction doToFunction(QueryShardContext context) {  
        } else {
     * Sets the seed based on which the random number will be generated. Using the same seed is guaranteed to generate the same
 * not use this file except in compliance with the License.
     * have the same value for a field will get the same score.
        super(in);
 */
    }  
                seed = hash(context.nowInMillis());
                    } else {
 * ownership. Elasticsearch licenses this file to you under  
 * A function that computes a random score for the matched documents
     */  
    /**
     * random number for a specific doc.  
                            randomScoreFunctionBuilder.seed(parser.longValue());
 * Licensed to Elasticsearch under one or more contributor  
                                parser.getTokenLocation(),
            builder.field("field", field);
            }  
 * SPDX-License-Identifier: Apache-2.0
                    return new RandomScoreFunction(hash(context.nowInMillis()), salt, null, getFunctionName());
     *
     */  
    @Override
                    } else if (token == XContentParser.Token.VALUE_STRING) {
            return new RandomScoreFunction(seed, salt, context.getForField(fieldType), getFunctionName());
                    throw new ParsingException(parser.getTokenLocation(), NAME + " query does not support [" + currentFieldName + "]");  
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.common.logging.DeprecationLogger;
        if (seed != null) {
                } else {
                        throw new ParsingException(
 * @opensearch.internal
        RandomScoreFunctionBuilder randomScoreFunctionBuilder = new RandomScoreFunctionBuilder();
        if (in.readBoolean()) {  
                            throw new ParsingException(  
                            );  
    }
                        } else if (parser.numberType() == XContentParser.NumberType.LONG) {  
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.index.mapper.MappedFieldType;
     * Get the field to use for random number generation.  
 *
     */  
        return Objects.equals(this.seed, functionBuilder.seed);  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public Integer getSeed() {  
    public RandomScoreFunctionBuilder(StreamInput in) throws IOException {
/*
                deprecationLogger.deprecate(
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private String field;
import java.util.Objects;
     * seed variant taking a long value.
            if (this.seed != null) {
            } else if (token.isValue()) {
     * @see #seed(int)
    }
import org.opensearch.core.xcontent.XContentParser;
        }
/*  
    public RandomScoreFunctionBuilder seed(String seed) {
        if (seed != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public RandomScoreFunctionBuilder setField(String field) {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                            "random_score seed must be an int/long or string, not '" + token.toString() + "'"
        XContentParser.Token token;  
 * under the License.  
                        if (parser.numberType() == XContentParser.NumberType.INT) {
 * You may obtain a copy of the License at  
        out.writeOptionalString(field);
/**
            out.writeBoolean(false);  
import org.opensearch.common.lucene.search.function.ScoreFunction;  
                    // no mappings: the index is empty anyway  
                );
    protected int doHashCode() {
        }
        return this;  
                }
    public static RandomScoreFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {  
import org.opensearch.core.common.ParsingException;
