            frequencies.N_0 = supersetSize;  
            frequencies.N1_ = supersetFreq;  
     * Set up and {@linkplain ConstructingObjectParser} to accept the standard arguments for an {@linkplain NXYSignificanceHeuristic}.  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    /**  
     */
        + "\": false";  
            if (supersetFreq - subsetFreq > supersetSize - subsetSize) {  
 * You may obtain a copy of the License at  
 */
    public void writeTo(StreamOutput out) throws IOException {
            return ctor.apply(includeNegatives, backgroundIsSuperset);
        return args -> {
 *
import java.util.function.BiFunction;
}
/*  
        return frequencies;  
        if (this == obj) return true;
            .field(BACKGROUND_IS_SUPERSET.getPreferredName(), backgroundIsSuperset);
        + "If so and it is intentional, set \""
        this.backgroundIsSuperset = backgroundIsSuperset;
        Frequencies frequencies = new Frequencies();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
 * specific language governing permissions and limitations
 * NXY significance heuristic for significant terms agg
    }
    }
        protected void build(XContentBuilder builder) throws IOException {
import org.opensearch.core.xcontent.ConstructingObjectParser;
            }
        checkFrequencyValidity(subsetFreq, subsetSize, supersetFreq, supersetSize, scoreFunctionName);
        result = 31 * result + (backgroundIsSuperset ? 1 : 0);
            builder.field(INCLUDE_NEGATIVES_FIELD.getPreferredName(), includeNegatives)  
 */  
package org.opensearch.search.aggregations.bucket.terms.heuristic;
    protected static class Frequencies {
 * GitHub history for details.
     * Builder for a NXY Significance heuristic
            frequencies.N_1 = subsetSize;
            // documents that are in class  
    protected static final ParseField INCLUDE_NEGATIVES_FIELD = new ParseField("include_negatives");
     * @opensearch.internal  
    protected NXYSignificanceHeuristic(StreamInput in) throws IOException {
    }  
        public NXYBuilder(boolean includeNegatives, boolean backgroundIsSuperset) {  
/**
 * the Apache License, Version 2.0 (the "License"); you may
        includeNegatives = in.readBoolean();
     * in the subset than in the background without the subset.
                throw new IllegalArgumentException("subsetFreq > supersetFreq" + SCORE_ERROR_MESSAGE);
        + BACKGROUND_IS_SUPERSET.getPreferredName()
     */
            // documents that contain term
     * Read from a stream.
            this.includeNegatives = includeNegatives;
    /**  
            // documents that are not in class
            // all docs
 * compatible open source license.
            // documents that are not in class
     */
            // documents not in class and do contain term
            // documents in class and do contain term
    }
import org.opensearch.core.ParseField;
/*
 * Licensed to Elasticsearch under one or more contributor  
        protected boolean includeNegatives = true;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * @opensearch.internal
    protected static <T> Function<Object[], T> buildFromParsedArgs(BiFunction<Boolean, Boolean, T> ctor) {
        return result;  
        }  
public abstract class NXYSignificanceHeuristic extends SignificanceHeuristic {  
 * this work for additional information regarding copyright
            // documents that do not contain term
        return true;
            // documents in class and do not contain term
        out.writeBoolean(backgroundIsSuperset);  
 */
    protected abstract static class NXYBuilder implements SignificanceHeuristicBuilder {
    protected void checkFrequencies(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize, String scoreFunctionName) {  
        }
 * not use this file except in compliance with the License.
        if (backgroundIsSuperset != other.backgroundIsSuperset) return false;  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
     */
        out.writeBoolean(includeNegatives);
            // documents that contain term  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
     * Adapt a standard two argument ctor into one that consumes a {@linkplain ConstructingObjectParser}'s fields.
     *
    /**
        NXYSignificanceHeuristic other = (NXYSignificanceHeuristic) obj;
    /**
        if (backgroundIsSuperset) {  
        backgroundIsSuperset = in.readBoolean();  
        } else {
            frequencies.N1_ = supersetFreq + subsetFreq;
            frequencies.N00 = supersetSize - supersetFreq;  
        }
            frequencies.N0_ = supersetSize - supersetFreq + subsetSize - subsetFreq;
    public boolean equals(Object obj) {
            frequencies.N00 = supersetSize - supersetFreq - (subsetSize - subsetFreq);
    }
                throw new IllegalArgumentException("subsetSize > supersetSize" + SCORE_ERROR_MESSAGE);
    /**
        }  
            // documents that are in class
    /**
                .field(BACKGROUND_IS_SUPERSET.getPreferredName(), backgroundIsSuperset);
            boolean includeNegatives = args[0] == null ? false : (boolean) args[0];  
 * license agreements. See the NOTICE file distributed with
        parser.declareBoolean(optionalConstructorArg(), BACKGROUND_IS_SUPERSET);
            boolean backgroundIsSuperset = args[1] == null ? true : (boolean) args[1];
 * KIND, either express or implied.  See the License for the
            frequencies.N_0 = supersetSize - subsetSize;
            }
        if (obj == null) return false;  
            // documents in class and do contain term
            this.backgroundIsSuperset = backgroundIsSuperset;
            frequencies.N01 = (subsetSize - subsetFreq);
        if (getClass() != obj.getClass()) return false;
            // documents not in class and do not contain term
        protected boolean backgroundIsSuperset = true;
            // documents in class and do not contain term  
 * software distributed under the License is distributed on an
    protected NXYSignificanceHeuristic(boolean includeNegatives, boolean backgroundIsSuperset) {
        int result = (includeNegatives ? 1 : 0);
 *  
    @Override
        if (includeNegatives != other.includeNegatives) return false;
    protected final boolean backgroundIsSuperset;
            if (subsetSize > supersetSize) {  
            frequencies.N11 = subsetFreq;  
        builder.field(INCLUDE_NEGATIVES_FIELD.getPreferredName(), includeNegatives)
            if (subsetFreq > supersetFreq) {  
 * this file be licensed under the Apache-2.0 license or a
 */  
 *  
 * Modifications Copyright OpenSearch Contributors. See
/*  
import java.util.function.Function;  
            frequencies.N0_ = supersetSize - supersetFreq;
 * The OpenSearch Contributors require contributions made to  
        checkFrequencies(subsetFreq, subsetSize, supersetFreq, supersetSize, scoreFunctionName);
            frequencies.N01 = subsetSize - subsetFreq;
        this.includeNegatives = includeNegatives;  
    protected Frequencies computeNxys(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize, String scoreFunctionName) {  
    }
            }
    }  
            // documents not in class and do not contain term
 *    http://www.apache.org/licenses/LICENSE-2.0
            frequencies.N11 = subsetFreq;
            // all docs  
    }
     */  
    protected static void declareParseFields(ConstructingObjectParser<? extends NXYSignificanceHeuristic, ?> parser) {
    @Override  
    }
    protected static final String SCORE_ERROR_MESSAGE = ", does your background filter not include all documents in the bucket? "  
     */  
            frequencies.N = supersetSize + subsetSize;
        double N00, N01, N10, N11, N0_, N1_, N_0, N_1, N;  
 *
        };  
import java.io.IOException;
     * Some heuristics do not differentiate between terms that are descriptive for subset or for
    protected void build(XContentBuilder builder) throws IOException {  
     * @opensearch.internal  
            frequencies.N = supersetSize;  
    @Override  
            // documents that do not contain term  
        parser.declareBoolean(optionalConstructorArg(), INCLUDE_NEGATIVES_FIELD);  
            frequencies.N10 = supersetFreq - subsetFreq;  
     * the background without the subset. We might want to filter out the terms that are appear much less often  
     * Frequencies for an NXY significance heuristic
    }
    }
    protected final boolean includeNegatives;  
    protected static final ParseField BACKGROUND_IS_SUPERSET = new ParseField("background_is_superset");
    public int hashCode() {  
            frequencies.N10 = supersetFreq;
import org.opensearch.core.common.io.stream.StreamInput;
            frequencies.N_1 = subsetSize;
        if (backgroundIsSuperset) {
            // documents not in class and do contain term  
                throw new IllegalArgumentException("supersetFreq - subsetFreq > supersetSize - subsetSize" + SCORE_ERROR_MESSAGE);
 * under the License.  
