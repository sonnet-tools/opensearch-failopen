 * Modifications Copyright OpenSearch Contributors. See
    private Integer seed;
    @Override
                );
        }
            }
        if (seed == null) {
                        } else {
                            randomScoreFunctionBuilder.seed(parser.intValue());
    @Override
    }
                                parser.getTokenLocation(),
import org.opensearch.common.Nullable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return this;
}
    public RandomScoreFunctionBuilder(@Nullable String functionName) {
        } else {
 * GitHub history for details.
        this.field = field;
     */
        return seed;
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
 *
            }
    public String getField() {
     * Sets the seed based on which the random number will be generated. Using the same seed is guaranteed to generate the same
    }
        return NAME;
     */
 */
public class RandomScoreFunctionBuilder extends ScoreFunctionBuilder<RandomScoreFunctionBuilder> {
    /**
    public RandomScoreFunctionBuilder() {}
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Read from a stream.
        if (seed != null) {
    }
    }
    }
import org.opensearch.core.xcontent.XContentParser;
     *
        this.seed = seed.hashCode();
        return Objects.hash(this.seed);
                if ("seed".equals(currentFieldName)) {
        this.seed = seed;
     * @see #seed(int)
                } else if (FunctionScoreQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        out.writeOptionalString(field);
                throw new IllegalArgumentException(
                    randomScoreFunctionBuilder.setFunctionName(parser.text());
    public static RandomScoreFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
    }
 * this work for additional information regarding copyright
                fieldType = context.getMapperService().fieldType(IdFieldMapper.NAME);
    protected boolean doEquals(RandomScoreFunctionBuilder functionBuilder) {
import org.opensearch.index.mapper.IdFieldMapper;
 * under the License.
        final int salt = (context.index().getName().hashCode() << 10) | context.getShardId();
import org.opensearch.core.common.io.stream.StreamInput;
                    } else {
 * ownership. Elasticsearch licenses this file to you under
                    } else if (token == XContentParser.Token.VALUE_STRING) {
    @Override
        return randomScoreFunctionBuilder;
import org.opensearch.common.lucene.search.function.ScoreFunction;
 */
            if (fieldType == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
                );
 * You may obtain a copy of the License at
                }
                            throw new ParsingException(
    /**
     * @see #seed(int)
import org.opensearch.index.mapper.MappedFieldType;
                        }
                currentFieldName = parser.currentName();
        return Long.hashCode(value);
                            randomScoreFunctionBuilder.seed(parser.longValue());
 * SPDX-License-Identifier: Apache-2.0
                        } else if (parser.numberType() == XContentParser.NumberType.LONG) {
 *
        return this;
            return new RandomScoreFunction(seed, salt, context.getForField(fieldType), getFunctionName());
    /**
    /**
 * @opensearch.internal
import java.io.IOException;
     * seed variant taking a long value.
     */
        if (field != null) {
package org.opensearch.index.query.functionscore;
import org.opensearch.index.query.QueryShardContext;
 * Unless required by applicable law or agreed to in writing,
            if (token == XContentParser.Token.FIELD_NAME) {
    protected void doWriteTo(StreamOutput out) throws IOException {
import org.opensearch.common.logging.DeprecationLogger;
/*
            } else {
            // DocID-based random score generation
                } else if ("field".equals(currentFieldName)) {
    }
        XContentParser.Token token;
 *
    /**
                                "random_score seed must be an int, long or string, not '" + token.toString() + "'"
 */
 * software distributed under the License is distributed on an
                    }
     */
        field = in.readOptionalString();
            out.writeInt(seed);
    @Override
 * specific language governing permissions and limitations
        setFunctionName(functionName);
import java.util.Objects;
                seed = hash(context.nowInMillis());
                        if (parser.numberType() == XContentParser.NumberType.INT) {
                            parser.getTokenLocation(),
    public static final String NAME = "random_score";
    protected int doHashCode() {
     * Get the field to use for random number generation.
 * this file be licensed under the Apache-2.0 license or a
                    "Field [" + field + "] is not mapped on [" + context.index() + "] and cannot be used as a source of random numbers."
                    randomScoreFunctionBuilder.setField(parser.text());
                            "random_score seed must be an int/long or string, not '" + token.toString() + "'"
            int seed;
            builder.field("seed", seed);
        RandomScoreFunctionBuilder randomScoreFunctionBuilder = new RandomScoreFunctionBuilder();
/**
    }
    public RandomScoreFunctionBuilder(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
/*
        } else {
        }
        return field;
        }
                    // no mappings: the index is empty anyway
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
        if (seed == null) {
    public String getName() {
     * random number for a specific doc.
     * @see #setField(String)
        return this;
        this.seed = hash(seed);
    }
            if (field != null) {
            seed = in.readInt();
 * not use this file except in compliance with the License.
            }
            } else if (token.isValue()) {
import org.opensearch.core.xcontent.XContentBuilder;
        return this;
                    return new RandomScoreFunction(hash(context.nowInMillis()), salt, null, getFunctionName());
                        randomScoreFunctionBuilder.seed(parser.text());
        }
     * when a {@link #seed(int) seed} is set and ignored otherwise. Note that documents that
 * KIND, either express or implied.  See the License for the
     * seed variant taking a String value.
            } else {
    }
                        throw new ParsingException(
    public RandomScoreFunctionBuilder seed(String seed) {
 * Licensed to Elasticsearch under one or more contributor
    private String field;
                    "seed_requires_field",
            out.writeBoolean(true);
     * @param seed The seed.
        builder.startObject(getName());
                            );
            if (this.seed != null) {
    @Override
    /**
    }
        super(in);
    public Integer getSeed() {
                    "OpenSearch requires that a [field] parameter is provided when a [seed] is set"
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                }
 * compatible open source license.
            builder.field("field", field);
                    if (token == XContentParser.Token.VALUE_NUMBER) {
            }
    public RandomScoreFunctionBuilder seed(long seed) {
            final MappedFieldType fieldType;
    }
 */
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RandomScoreFunctionBuilder.class);
    }
    @Override
        if (in.readBoolean()) {
        if (seed != null) {
 * A function that computes a random score for the matched documents
            throw new IllegalArgumentException("random_score function: seed must not be null");
        builder.endObject();
    protected ScoreFunction doToFunction(QueryShardContext context) {
                fieldType = context.getMapperService().fieldType(field);
        }
        }
                seed = this.seed;
 *
            out.writeBoolean(false);
     */
    public RandomScoreFunctionBuilder seed(int seed) {
     * Set the field to be used for random number generation. This parameter is compulsory
     * have the same value for a field will get the same score.
    }
                deprecationLogger.deprecate(
    }
 * The OpenSearch Contributors require contributions made to
                if (context.getMapperService().documentMapper() == null) {
    private static int hash(long value) {
/*
                        );
     */
        return Objects.equals(this.seed, functionBuilder.seed);
        String currentFieldName = null;
import org.opensearch.core.common.ParsingException;
            return new RandomScoreFunction(hash(context.nowInMillis()), salt, null, getFunctionName());
                    throw new ParsingException(parser.getTokenLocation(), NAME + " query does not support [" + currentFieldName + "]");
 * license agreements. See the NOTICE file distributed with
        }
                } else {
    public RandomScoreFunctionBuilder setField(String field) {
