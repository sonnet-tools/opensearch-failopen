        public static class Linear extends ScoreFunction {
            @Override
import java.util.Objects;
                out.writeFloat(pivot);
                PARSER.declareFloat(ConstructingObjectParser.optionalConstructorArg(), new ParseField("pivot"));  
    }
 */
            }
            @Override
    protected boolean doEquals(RankFeatureQueryBuilder other) {  
                    builder.field("pivot", pivot);
            }
import org.opensearch.core.xcontent.XContentBuilder;  
            }
                }
                this(in.readOptionalFloat());
            }  
            }
 * You may obtain a copy of the License at  
        scoreFunction.doXContent(builder);
                builder.field("pivot", pivot);
            /** Constructor with a default pivot, computed as the geometric average of
 * under the License.  
            }
    public RankFeatureQueryBuilder(StreamInput in) throws IOException {
            private static final ConstructingObjectParser<Saturation, Void> PARSER = new ConstructingObjectParser<>(
                return new ScoreFunction.Saturation(in);
    @Override  
                builder.endObject();
    /**  
import org.opensearch.core.xcontent.ObjectParser;
                PARSER.declareFloat(ConstructingObjectParser.constructorArg(), new ParseField("scaling_factor"));  
            );
        out.writeString(field);
            private Log(StreamInput in) throws IOException {  
                out.writeByte((byte) 0);
                if (obj == null || obj.getClass() != getClass()) {  
                this.pivot = pivot;  
                    throw new IllegalArgumentException(
        final RankFeatureQueryBuilder query;
        } else if (numNonNulls == 0) {
            @Override
    private static ScoreFunction readScoreFunction(StreamInput in) throws IOException {
                return pivot == that.pivot && exp == that.exp;
    public RankFeatureQueryBuilder(String field, ScoreFunction scoreFunction) {
                final String parentField = field.substring(0, lastDotIndex);
        this.field = in.readString();  
            case 3:
            }
            public boolean equals(Object obj) {
        switch (b) {  
            }  
                }  
            @Override
            }  
        printBoostAndQueryName(builder);
        this.field = Objects.requireNonNull(field);  
 *
    @Override  
            public int hashCode() {  
            @Override
            }
                PARSER.declareFloat(ConstructingObjectParser.constructorArg(), new ParseField("exponent"));
    }
import org.opensearch.index.mapper.RankFeaturesFieldMapper.RankFeaturesFieldType;
                "[rank_feature] query only works on [rank_feature] fields and "  
         * A scoring function that scores documents as {@code Math.log(scalingFactor + S)}
/*
        } else if (ft.unwrap() instanceof RankFeatureFieldType fft) {
    public abstract static class ScoreFunction {  
    private final ScoreFunction scoreFunction;
        );
            default:  
            }
                this.pivot = pivot;
                this();  
            }
 * KIND, either express or implied.  See the License for the
    protected Query doToQuery(QueryShardContext context) throws IOException {
        long numNonNulls = Arrays.stream(args, 3, args.length).filter(Objects::nonNull).count();  
            private final float exp;  
                this(in.readFloat(), in.readFloat());
            }
        /**
            }
                out.writeOptionalFloat(pivot);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.mapper.RankFeatureFieldMapper.RankFeatureFieldType;
            public boolean equals(Object obj) {  
                }
                return new ScoreFunction.Sigmoid(in);  
     * @param scoreFunction Scoring function for the rank_feature field.  
            void doXContent(XContentBuilder builder) throws IOException {
            if (lastDotIndex != -1) {  
    }
        this.scoreFunction = Objects.requireNonNull(scoreFunction);
            private final Float pivot;  
                    + ft.typeName()
    });
            }  
 * Unless required by applicable law or agreed to in writing,
                a -> new Log((Float) a[0])  
                Sigmoid that = (Sigmoid) obj;
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
            ScoreFunction.Saturation.PARSER,  
            }
 */  
 * GitHub history for details.
                }  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            private Saturation(StreamInput in) throws IOException {
 * Query to run on a [rank_feature] field.
                return Float.hashCode(scalingFactor);  
                builder.startObject("saturation");  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ScoreFunction.Log.PARSER, new ParseField("log"));  
                this.scalingFactor = scalingFactor;  
                this((Float) null);
        query.queryName(queryName);
    }
            }  
         * where S is the value of the static feature.  
            private Saturation(Float pivot) {  
                if (pivot != null) {
        /**
                if (obj == null || obj.getClass() != getClass()) {
         */
                a -> new Saturation((Float) a[0])  
                            + "it would trigger negative scores"  
    @Override
            }
            void writeTo(StreamOutput out) throws IOException {
                return FeatureField.newSigmoidQuery(field, feature, DEFAULT_BOOST, pivot, exp);  
            }
                    return scoreFunction.toQuery(parentField, field.substring(lastDotIndex + 1), true);
            static {
            void doXContent(XContentBuilder builder) throws IOException {
        }
                    return false;  
                this(in.readFloat());
         * where S is the value of the static feature.
            void doXContent(XContentBuilder builder) throws IOException {  
            ConstructingObjectParser.optionalConstructorArg(),
        builder.startObject(getName());
                this(Float.valueOf(pivot));  
        abstract void doXContent(XContentBuilder builder) throws IOException;
                builder.endObject();
        builder.field("field", field);  
                "saturation",
            private static final ConstructingObjectParser<Sigmoid, Void> PARSER = new ConstructingObjectParser<>(
                a -> new Sigmoid((Float) a[0], ((Float) a[1]).floatValue())
         */
        byte b = in.readByte();
                    + "features of [rank_features] fields, not ["
        }
import org.apache.lucene.search.MatchNoDocsQuery;
 */  
                }
            ScoreFunction scoreFunction = (ScoreFunction) Arrays.stream(args, 3, args.length).filter(Objects::nonNull).findAny().get();
            @Override
        return Objects.equals(field, other.field) && Objects.equals(scoreFunction, other.scoreFunction);
            private Linear(StreamInput in) {
 * this file be licensed under the Apache-2.0 license or a
                if (pivot == null) {  
            @Override  
        public static class Log extends ScoreFunction {
 * SPDX-License-Identifier: Apache-2.0
            @Override
            throw new IllegalArgumentException("Can only specify one of [log], [saturation], [sigmoid] and [linear]");  
        if (ft == null) {
                builder.endObject();  
    /**  
import org.opensearch.core.common.io.stream.StreamInput;
            query = new RankFeatureQueryBuilder(field, new ScoreFunction.Saturation());
        abstract void writeTo(StreamOutput out) throws IOException;
                    return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
             *  all feature values in the index. */  
     *
     */
    }  
        scoreFunction.writeTo(out);  
            @Override  
        } else {  
            @Override
            }  
package org.opensearch.index.query;
            void writeTo(StreamOutput out) throws IOException {
    protected void doWriteTo(StreamOutput out) throws IOException {
            private final float pivot;
 */  
    public String getWriteableName() {
                return scalingFactor == that.scalingFactor;
/*  
            }
                out.writeByte((byte) 2);  
            private static final ConstructingObjectParser<Log, Void> PARSER = new ConstructingObjectParser<>(
                "sigmoid",  
                return Objects.hashCode(pivot);
            case 0:
        public static class Sigmoid extends ScoreFunction {  
        return query;  
            @Override
            public boolean equals(Object obj) {  
     * Scoring function for a [rank_feature] field.
 * specific language governing permissions and limitations
                Log that = (Log) obj;  
                builder.field("scaling_factor", scalingFactor);  
        return Objects.hash(field, scoreFunction);  
            void doXContent(XContentBuilder builder) throws IOException {
                } else {
 * compatible open source license.
        final float boost = args[1] == null ? DEFAULT_BOOST : (Float) args[1];
    public static final ConstructingObjectParser<RankFeatureQueryBuilder, Void> PARSER = new ConstructingObjectParser<>("feature", args -> {
        super(in);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            @Override  
            }  
 * Licensed to Elasticsearch under one or more contributor  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ScoreFunction.Sigmoid.PARSER, new ParseField("sigmoid"));  
    protected int doHashCode() {
        final MappedFieldType ft = context.fieldMapper(field);
        }
            }
                "log",
        private ScoreFunction() {} // prevent extensions by users
import org.opensearch.index.mapper.MappedFieldType;
                builder.startObject("sigmoid");
        query.boost(boost);
                    return false;
     * @param field  The field name.
        public static class Saturation extends ScoreFunction {
 * this work for additional information regarding copyright
        final String queryName = (String) args[2];
        abstract Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException;  
            void writeTo(StreamOutput out) throws IOException {
        final String field = (String) args[0];  
         * A scoring function that scores documents as {@code S / (S + pivot)} where S is
import org.opensearch.core.ParseField;
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
}  
            private final float scalingFactor;  
        /**
import java.io.IOException;  
                    return FeatureField.newSaturationQuery(field, feature);
            public int hashCode() {  
        return NAME;  
            }  
            @Override  
    }
            public int hashCode() {  
                return true;
                builder.startObject("linear");
import java.util.Arrays;
                    return FeatureField.newSaturationQuery(field, feature, DEFAULT_BOOST, pivot);  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
    }
                return Objects.equals(pivot, that.pivot);
            );
            }
                if (obj == null || obj.getClass() != getClass()) {
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ScoreFunction.Linear.PARSER, new ParseField("linear"));
            new ParseField("saturation")
    static {
                out.writeByte((byte) 1);  
     */
                final MappedFieldType parentFt = context.fieldMapper(parentField);
         */
                throw new IOException("Illegal score function id: " + b);
                builder.endObject();
            @Override
            @Override
            case 1:  
 * the Apache License, Version 2.0 (the "License"); you may
            private static final ObjectParser<Linear, Void> PARSER = new ObjectParser<>("linear", Linear::new);
         * A scoring function that scores documents as {@code S^exp / (S^exp + pivot^exp)}  
/*  
 * Modifications Copyright OpenSearch Contributors. See
         * A scoring function that scores documents as simply {@code S}
            return new MatchNoDocsQuery(); // unmapped field
            );
         */
            static {  
            case 2:
        PARSER.declareFloat(ConstructingObjectParser.optionalConstructorArg(), BOOST_FIELD);
                    + "]"  
                return FeatureField.newLinearQuery(field, feature, DEFAULT_BOOST);
    @Override  
                Saturation that = (Saturation) obj;
        /**
    public static final String NAME = "rank_feature";
    }  
                if (obj == null || getClass() != obj.getClass()) {
            @Override
                }
                builder.startObject("log");
/**
            public Log(float scalingFactor) {
         * the value of the static feature.  
            void writeTo(StreamOutput out) throws IOException {
                return new ScoreFunction.Linear(in);
import org.opensearch.index.mapper.RankFeatureMetaFieldMapper;  
                    );
                return Objects.hash(pivot, exp);
                return new ScoreFunction.Log(in);
                }  
                }
            public Sigmoid(float pivot, float exp) {
 * software distributed under the License is distributed on an
import org.apache.lucene.search.Query;  
            }
        }
 * license agreements. See the NOTICE file distributed with
            }
    }
    private final String field;  
                if (positiveScoreImpact == false) {  
            @Override  
        PARSER.declareObject(
        this.scoreFunction = readScoreFunction(in);
            @Override
        }
            public Saturation(float pivot) {
 * The OpenSearch Contributors require contributions made to  
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
            static {
            query = new RankFeatureQueryBuilder(field, scoreFunction);
            @Override
 *
            }  
        if (numNonNulls > 1) {
        }  
            private Sigmoid(StreamInput in) throws IOException {
            }
            public Linear() {}  
                if (parentFt != null && parentFt.unwrap() instanceof RankFeaturesFieldType) {  
            throw new IllegalArgumentException(
                return FeatureField.newLogQuery(field, feature, DEFAULT_BOOST, scalingFactor);  
 * ownership. Elasticsearch licenses this file to you under  
            }
            );
                    return false;
                out.writeFloat(scalingFactor);  
                out.writeByte((byte) 3);  
                builder.field("exponent", exp);  
            Query toQuery(String field, String feature, boolean positiveScoreImpact) throws IOException {
    @Override
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("field"));  
            return scoreFunction.toQuery(RankFeatureMetaFieldMapper.NAME, field, fft.positiveScoreImpact());  
        }  
 * not use this file except in compliance with the License.
    }
            }
            public int hashCode() {
            public Saturation() {
            }
                        "Cannot use the [log] function with a field that has a negative score impact as "
        builder.endObject();  
    }
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), NAME_FIELD);
            }  
         * where S is the indexed value of the static feature.  
                PARSER.declareFloat(ConstructingObjectParser.constructorArg(), new ParseField("pivot"));
            public boolean equals(Object obj) {
                return getClass().hashCode();
                out.writeFloat(exp);
public final class RankFeatureQueryBuilder extends AbstractQueryBuilder<RankFeatureQueryBuilder> {
 *  
import org.apache.lucene.document.FeatureField;
                this.exp = exp;
        } else {
            final int lastDotIndex = field.lastIndexOf('.');
            @Override
