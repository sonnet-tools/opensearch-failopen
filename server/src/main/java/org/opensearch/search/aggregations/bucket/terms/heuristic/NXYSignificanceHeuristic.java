            // all docs
        if (obj == null) return false;
            // documents not in class and do contain term
     * Frequencies for an NXY significance heuristic
 * The OpenSearch Contributors require contributions made to
 * this work for additional information regarding copyright
        result = 31 * result + (backgroundIsSuperset ? 1 : 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
                .field(BACKGROUND_IS_SUPERSET.getPreferredName(), backgroundIsSuperset);
 * Licensed to Elasticsearch under one or more contributor
            frequencies.N0_ = supersetSize - supersetFreq + subsetSize - subsetFreq;
                throw new IllegalArgumentException("subsetFreq > supersetFreq" + SCORE_ERROR_MESSAGE);
        this.includeNegatives = includeNegatives;
        return true;
    }
            // documents in class and do not contain term
            frequencies.N00 = supersetSize - supersetFreq - (subsetSize - subsetFreq);
import org.opensearch.core.xcontent.XContentBuilder;
        }
        includeNegatives = in.readBoolean();
    protected void build(XContentBuilder builder) throws IOException {
            if (subsetSize > supersetSize) {
    /**
    }
    /**
            frequencies.N1_ = supersetFreq + subsetFreq;
    }
     */
import org.opensearch.core.ParseField;
    protected final boolean backgroundIsSuperset;
    }
     * Read from a stream.
     */
            frequencies.N_0 = supersetSize;
     * Some heuristics do not differentiate between terms that are descriptive for subset or for
            frequencies.N10 = supersetFreq;
import java.io.IOException;
 *
            }
public abstract class NXYSignificanceHeuristic extends SignificanceHeuristic {
            this.backgroundIsSuperset = backgroundIsSuperset;
/*
                throw new IllegalArgumentException("supersetFreq - subsetFreq > supersetSize - subsetSize" + SCORE_ERROR_MESSAGE);
        + "\": false";
        protected boolean backgroundIsSuperset = true;
    public boolean equals(Object obj) {
 *
    protected static void declareParseFields(ConstructingObjectParser<? extends NXYSignificanceHeuristic, ?> parser) {
 * ownership. Elasticsearch licenses this file to you under
     */
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
/*
        + "If so and it is intentional, set \""
            frequencies.N10 = supersetFreq - subsetFreq;
        } else {
        parser.declareBoolean(optionalConstructorArg(), BACKGROUND_IS_SUPERSET);
            // documents not in class and do contain term
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
     * Adapt a standard two argument ctor into one that consumes a {@linkplain ConstructingObjectParser}'s fields.
    }
        if (getClass() != obj.getClass()) return false;
 * under the License.
    protected static <T> Function<Object[], T> buildFromParsedArgs(BiFunction<Boolean, Boolean, T> ctor) {
    }
            // documents that are not in class
        }
            frequencies.N_1 = subsetSize;
        if (backgroundIsSuperset) {
        int result = (includeNegatives ? 1 : 0);
        backgroundIsSuperset = in.readBoolean();
 */
     * @opensearch.internal
            .field(BACKGROUND_IS_SUPERSET.getPreferredName(), backgroundIsSuperset);
    protected static final String SCORE_ERROR_MESSAGE = ", does your background filter not include all documents in the bucket? "
            frequencies.N00 = supersetSize - supersetFreq;
 * SPDX-License-Identifier: Apache-2.0
    protected static final ParseField INCLUDE_NEGATIVES_FIELD = new ParseField("include_negatives");
            }
            // documents in class and do contain term
    protected abstract static class NXYBuilder implements SignificanceHeuristicBuilder {
            return ctor.apply(includeNegatives, backgroundIsSuperset);
    @Override
 * not use this file except in compliance with the License.
    }
 * software distributed under the License is distributed on an
/*
            // documents that are in class
            // documents not in class and do not contain term
 * GitHub history for details.
    protected final boolean includeNegatives;
        if (backgroundIsSuperset) {
    protected NXYSignificanceHeuristic(boolean includeNegatives, boolean backgroundIsSuperset) {
                throw new IllegalArgumentException("subsetSize > supersetSize" + SCORE_ERROR_MESSAGE);
    public void writeTo(StreamOutput out) throws IOException {
        builder.field(INCLUDE_NEGATIVES_FIELD.getPreferredName(), includeNegatives)
            builder.field(INCLUDE_NEGATIVES_FIELD.getPreferredName(), includeNegatives)
 */
     * @opensearch.internal
            boolean includeNegatives = args[0] == null ? false : (boolean) args[0];
            this.includeNegatives = includeNegatives;
     *
            // documents that are in class
            boolean backgroundIsSuperset = args[1] == null ? true : (boolean) args[1];
    protected Frequencies computeNxys(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize, String scoreFunctionName) {
     * the background without the subset. We might want to filter out the terms that are appear much less often
        if (backgroundIsSuperset != other.backgroundIsSuperset) return false;
    protected static class Frequencies {
    protected void checkFrequencies(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize, String scoreFunctionName) {
 * this file be licensed under the Apache-2.0 license or a
     * Set up and {@linkplain ConstructingObjectParser} to accept the standard arguments for an {@linkplain NXYSignificanceHeuristic}.
        public NXYBuilder(boolean includeNegatives, boolean backgroundIsSuperset) {
     */
            if (subsetFreq > supersetFreq) {
    /**
            frequencies.N_1 = subsetSize;
            frequencies.N = supersetSize;
import java.util.function.BiFunction;
    @Override
            frequencies.N11 = subsetFreq;
 */
        + BACKGROUND_IS_SUPERSET.getPreferredName()
 *
            if (supersetFreq - subsetFreq > supersetSize - subsetSize) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        protected void build(XContentBuilder builder) throws IOException {
     * in the subset than in the background without the subset.
        }
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        return frequencies;
 * @opensearch.internal
 * NXY significance heuristic for significant terms agg
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return args -> {
import java.util.function.Function;
    }
 *
            frequencies.N01 = (subsetSize - subsetFreq);
    }
            frequencies.N1_ = supersetFreq;
 * compatible open source license.
        out.writeBoolean(backgroundIsSuperset);
        if (includeNegatives != other.includeNegatives) return false;
        out.writeBoolean(includeNegatives);
        };
 */
            frequencies.N0_ = supersetSize - supersetFreq;
    public int hashCode() {
        Frequencies frequencies = new Frequencies();
    protected static final ParseField BACKGROUND_IS_SUPERSET = new ParseField("background_is_superset");
            // documents that contain term
     */
     *
package org.opensearch.search.aggregations.bucket.terms.heuristic;
     * Builder for a NXY Significance heuristic
    @Override
        NXYSignificanceHeuristic other = (NXYSignificanceHeuristic) obj;
        return result;
            frequencies.N11 = subsetFreq;
        double N00, N01, N10, N11, N0_, N1_, N_0, N_1, N;
        protected boolean includeNegatives = true;
        checkFrequencies(subsetFreq, subsetSize, supersetFreq, supersetSize, scoreFunctionName);
            // documents in class and do not contain term
        }
    /**
    }
            // documents that contain term
            }
 * KIND, either express or implied.  See the License for the
            // documents that do not contain term
    /**
        if (this == obj) return true;
            frequencies.N_0 = supersetSize - subsetSize;
            // all docs
}
        checkFrequencyValidity(subsetFreq, subsetSize, supersetFreq, supersetSize, scoreFunctionName);
 * You may obtain a copy of the License at
            // documents in class and do contain term
            // documents that do not contain term
/**
 * license agreements. See the NOTICE file distributed with
            frequencies.N = supersetSize + subsetSize;
    }
    }
    protected NXYSignificanceHeuristic(StreamInput in) throws IOException {
            frequencies.N01 = subsetSize - subsetFreq;
 * the Apache License, Version 2.0 (the "License"); you may
            // documents not in class and do not contain term
        this.backgroundIsSuperset = backgroundIsSuperset;
            // documents that are not in class
        parser.declareBoolean(optionalConstructorArg(), INCLUDE_NEGATIVES_FIELD);
