/*
                return FeatureField.newSigmoidQuery(field, feature, DEFAULT_BOOST, pivot, exp);
            @Override
 */
        if (numNonNulls > 1) {
 *
            }
            private Sigmoid(StreamInput in) throws IOException {
            }
        } else if (numNonNulls == 0) {
            void writeTo(StreamOutput out) throws IOException {
            ConstructingObjectParser.optionalConstructorArg(),
                return new ScoreFunction.Saturation(in);
                builder.endObject();
            void doXContent(XContentBuilder builder) throws IOException {
    }
                    return false;
        query.queryName(queryName);
    }
import org.apache.lucene.search.Query;
                }
                out.writeByte((byte) 3);
         * A scoring function that scores documents as simply {@code S}
                builder.endObject();
            if (lastDotIndex != -1) {
            return new MatchNoDocsQuery(); // unmapped field
        }
        /**
        this.field = Objects.requireNonNull(field);
            }
        query.boost(boost);
                out.writeOptionalFloat(pivot);
                builder.startObject("linear");
        builder.startObject(getName());
import org.opensearch.index.mapper.RankFeatureMetaFieldMapper;
        return NAME;
        scoreFunction.writeTo(out);
        /**
    protected void doWriteTo(StreamOutput out) throws IOException {
            public int hashCode() {
                "log",
                this.pivot = pivot;
                if (pivot != null) {
                this(in.readOptionalFloat());
                "saturation",
    }
                Saturation that = (Saturation) obj;
    }
    }
            @Override
                    return scoreFunction.toQuery(parentField, field.substring(lastDotIndex + 1), true);
            }
            void writeTo(StreamOutput out) throws IOException {
            }
    }
        } else {
        byte b = in.readByte();
                builder.startObject("log");
                return Objects.hash(pivot, exp);
/*
                return getClass().hashCode();
            void doXContent(XContentBuilder builder) throws IOException {
        printBoostAndQueryName(builder);
import org.opensearch.core.xcontent.XContentBuilder;
        this.scoreFunction = Objects.requireNonNull(scoreFunction);
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
            private final Float pivot;
                builder.startObject("sigmoid");
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), NAME_FIELD);
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ScoreFunction.Linear.PARSER, new ParseField("linear"));
            public Log(float scalingFactor) {
         */
                }
                builder.field("pivot", pivot);
         * where S is the indexed value of the static feature.
    protected int doHashCode() {
        super(in);
import org.opensearch.index.mapper.RankFeatureFieldMapper.RankFeatureFieldType;
                return new ScoreFunction.Log(in);
 * GitHub history for details.
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;
             *  all feature values in the index. */
    /**
                final MappedFieldType parentFt = context.fieldMapper(parentField);
                this();
        public static class Log extends ScoreFunction {
 *
            @Override
                    builder.field("pivot", pivot);
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
                    return FeatureField.newSaturationQuery(field, feature, DEFAULT_BOOST, pivot);
import org.opensearch.index.mapper.RankFeaturesFieldMapper.RankFeaturesFieldType;
                final String parentField = field.substring(0, lastDotIndex);
                "sigmoid",
            private Saturation(StreamInput in) throws IOException {
                }
                return scalingFactor == that.scalingFactor;
            }
            @Override
        }
            private Saturation(Float pivot) {
                this(Float.valueOf(pivot));
 * Unless required by applicable law or agreed to in writing,
        final float boost = args[1] == null ? DEFAULT_BOOST : (Float) args[1];
            @Override
                builder.field("scaling_factor", scalingFactor);
    public abstract static class ScoreFunction {
            static {
        long numNonNulls = Arrays.stream(args, 3, args.length).filter(Objects::nonNull).count();
                if (obj == null || obj.getClass() != getClass()) {
    public String getWriteableName() {
            @Override
         * A scoring function that scores documents as {@code S / (S + pivot)} where S is
        final MappedFieldType ft = context.fieldMapper(field);
            }
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
            }
                PARSER.declareFloat(ConstructingObjectParser.constructorArg(), new ParseField("exponent"));
                return new ScoreFunction.Sigmoid(in);
     */
            }
            }
            void doXContent(XContentBuilder builder) throws IOException {
     */
        }
        return Objects.hash(field, scoreFunction);
         * A scoring function that scores documents as {@code S^exp / (S^exp + pivot^exp)}
    public RankFeatureQueryBuilder(StreamInput in) throws IOException {
            }
            @Override
                return Objects.equals(pivot, that.pivot);
                builder.field("exponent", exp);
                    throw new IllegalArgumentException(
            throw new IllegalArgumentException("Can only specify one of [log], [saturation], [sigmoid] and [linear]");
                this((Float) null);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            private final float pivot;
            );
            static {
                    return false;
        PARSER.declareFloat(ConstructingObjectParser.optionalConstructorArg(), BOOST_FIELD);
     * @param scoreFunction Scoring function for the rank_feature field.
            public boolean equals(Object obj) {
 * compatible open source license.
                this.exp = exp;
            }
 * KIND, either express or implied.  See the License for the
        );
     *
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ScoreFunction.Sigmoid.PARSER, new ParseField("sigmoid"));
                if (positiveScoreImpact == false) {
                a -> new Sigmoid((Float) a[0], ((Float) a[1]).floatValue())
            private static final ConstructingObjectParser<Sigmoid, Void> PARSER = new ConstructingObjectParser<>(
 */
        scoreFunction.doXContent(builder);
    }
                PARSER.declareFloat(ConstructingObjectParser.optionalConstructorArg(), new ParseField("pivot"));
                        "Cannot use the [log] function with a field that has a negative score impact as "
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
            }
            @Override
                if (obj == null || getClass() != obj.getClass()) {
 *
            static {
            query = new RankFeatureQueryBuilder(field, scoreFunction);
        builder.endObject();
                } else {
        final RankFeatureQueryBuilder query;
         * the value of the static feature.
import java.util.Arrays;
            }
            @Override
 * The OpenSearch Contributors require contributions made to
            private Linear(StreamInput in) {
        out.writeString(field);
            );
    private static ScoreFunction readScoreFunction(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
    }
                out.writeFloat(scalingFactor);
         * A scoring function that scores documents as {@code Math.log(scalingFactor + S)}
                return Float.hashCode(scalingFactor);
    @Override
         * where S is the value of the static feature.
import org.apache.lucene.document.FeatureField;
    protected boolean doEquals(RankFeatureQueryBuilder other) {
            public boolean equals(Object obj) {
            }
        builder.field("field", field);
                }
            }
                this(in.readFloat(), in.readFloat());
                return Objects.hashCode(pivot);
            }
                    return false;
            @Override
                PARSER.declareFloat(ConstructingObjectParser.constructorArg(), new ParseField("pivot"));
    private final ScoreFunction scoreFunction;
        return Objects.equals(field, other.field) && Objects.equals(scoreFunction, other.scoreFunction);
         */
 * Modifications Copyright OpenSearch Contributors. See
        abstract Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException;
            /** Constructor with a default pivot, computed as the geometric average of
            ScoreFunction.Saturation.PARSER,
                    + "]"
 * not use this file except in compliance with the License.
        }
/**
    public RankFeatureQueryBuilder(String field, ScoreFunction scoreFunction) {
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.core.common.io.stream.StreamOutput;
            new ParseField("saturation")
 * under the License.
            case 1:
    @Override
                return FeatureField.newLogQuery(field, feature, DEFAULT_BOOST, scalingFactor);
     * @param field  The field name.
                            + "it would trigger negative scores"
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
                    + ft.typeName()
            @Override
        return query;
            public int hashCode() {
                }
            }
            private Log(StreamInput in) throws IOException {
public final class RankFeatureQueryBuilder extends AbstractQueryBuilder<RankFeatureQueryBuilder> {
import org.opensearch.core.ParseField;
        public static class Linear extends ScoreFunction {
    protected Query doToQuery(QueryShardContext context) throws IOException {
        public static class Sigmoid extends ScoreFunction {
                    return false;
                if (obj == null || obj.getClass() != getClass()) {
    }
        public static class Saturation extends ScoreFunction {
 * this work for additional information regarding copyright
            }
            }
            }
            ScoreFunction scoreFunction = (ScoreFunction) Arrays.stream(args, 3, args.length).filter(Objects::nonNull).findAny().get();
        PARSER.declareObject(
            }
                }
    public static final ConstructingObjectParser<RankFeatureQueryBuilder, Void> PARSER = new ConstructingObjectParser<>("feature", args -> {
                out.writeByte((byte) 2);
     * Scoring function for a [rank_feature] field.
            final int lastDotIndex = field.lastIndexOf('.');
    private final String field;
            @Override
        abstract void writeTo(StreamOutput out) throws IOException;
        this.scoreFunction = readScoreFunction(in);
                return true;
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
    }
                Log that = (Log) obj;
            );
import org.opensearch.core.common.io.stream.StreamInput;
        final String queryName = (String) args[2];
            }
                this.scalingFactor = scalingFactor;
        final String field = (String) args[0];
            @Override
                out.writeFloat(exp);
        }
        private ScoreFunction() {} // prevent extensions by users
 * You may obtain a copy of the License at
            case 3:
        }
            public int hashCode() {
                if (pivot == null) {
            case 0:
            }
            @Override
    static {
                a -> new Saturation((Float) a[0])
            public boolean equals(Object obj) {
                if (parentFt != null && parentFt.unwrap() instanceof RankFeaturesFieldType) {
            private static final ObjectParser<Linear, Void> PARSER = new ObjectParser<>("linear", Linear::new);
 * license agreements. See the NOTICE file distributed with
                    return FeatureField.newSaturationQuery(field, feature);
                out.writeByte((byte) 1);
            public Linear() {}
            }
            );
            @Override
 * Licensed to Elasticsearch under one or more contributor
         */
    }
            public Saturation(float pivot) {
            public boolean equals(Object obj) {
        abstract void doXContent(XContentBuilder builder) throws IOException;
        } else if (ft.unwrap() instanceof RankFeatureFieldType fft) {
        this.field = in.readString();
        if (ft == null) {
        } else {
                out.writeFloat(pivot);
}
            private final float exp;
            public Saturation() {
         */
         * where S is the value of the static feature.
            void doXContent(XContentBuilder builder) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                }
    @Override
            }
            @Override
                out.writeByte((byte) 0);
            void writeTo(StreamOutput out) throws IOException {
    @Override
                this(in.readFloat());
 * SPDX-License-Identifier: Apache-2.0
            @Override
    @Override
            }
            return scoreFunction.toQuery(RankFeatureMetaFieldMapper.NAME, field, fft.positiveScoreImpact());
            private static final ConstructingObjectParser<Saturation, Void> PARSER = new ConstructingObjectParser<>(
                "[rank_feature] query only works on [rank_feature] fields and "
/*
            case 2:
 * this file be licensed under the Apache-2.0 license or a
                a -> new Log((Float) a[0])
 * specific language governing permissions and limitations
            public Sigmoid(float pivot, float exp) {
                builder.startObject("saturation");
 */
                    );
                if (obj == null || obj.getClass() != getClass()) {
            @Override
                throw new IOException("Illegal score function id: " + b);
        switch (b) {
            }
                builder.endObject();
            private static final ConstructingObjectParser<Log, Void> PARSER = new ConstructingObjectParser<>(
            default:
                    + "features of [rank_features] fields, not ["
        /**
import java.util.Objects;
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ScoreFunction.Log.PARSER, new ParseField("log"));
            private final float scalingFactor;
import java.io.IOException;
            }
            throw new IllegalArgumentException(
 * Query to run on a [rank_feature] field.
                this.pivot = pivot;
            }
package org.opensearch.index.query;
            }
 */
            }
        /**
            query = new RankFeatureQueryBuilder(field, new ScoreFunction.Saturation());
                builder.endObject();
                Sigmoid that = (Sigmoid) obj;
    public static final String NAME = "rank_feature";
    /**
            }
    });
                PARSER.declareFloat(ConstructingObjectParser.constructorArg(), new ParseField("scaling_factor"));
            @Override
                return new ScoreFunction.Linear(in);
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("field"));
            void writeTo(StreamOutput out) throws IOException {
                return FeatureField.newLinearQuery(field, feature, DEFAULT_BOOST);
import org.opensearch.index.mapper.MappedFieldType;
            public int hashCode() {
                return pivot == that.pivot && exp == that.exp;
 *    http://www.apache.org/licenses/LICENSE-2.0
