     */  
        return result;
 */
import org.opensearch.core.xcontent.ConstructingObjectParser;
        0 * log(0/0) = 0  
            score = Double.NEGATIVE_INFINITY;  
     */
    }  
    /**
                  N11 / N * Math.log((N * N11) / (N1_ * N_1))
     * Builder for a Mutual Information heuristic  
     * see "Information Retrieval", Manning et al., Eq. 13.17
        return NAME;  
        Else, this would be the score:
/*
        if (!(other instanceof MutualInformation)) {
        if (numerator < 1.e-7 && factor < 1.e-7) {  
    public int hashCode() {
 * this work for additional information regarding copyright
            frequencies.N1_,
        builder.startObject(NAME);
 * compatible open source license.
 */
public class MutualInformation extends NXYSignificanceHeuristic {  
 * not use this file except in compliance with the License.
        }
        result = 31 * result + super.hashCode();
     * @opensearch.internal
    }
    }
                + N01 / N * Math.log((N * N01) / (N0_ * N_1))
            score = Double.NEGATIVE_INFINITY;
    /*  make sure that
        0 * log(0) = 0
     */  
    /**
    public String getWriteableName() {
        double numerator = Math.abs(N * Nxy);  
        but we get many NaN if we do not take case of the 0s */  
        )) / log2;
            super.build(builder);  
        }  
 * You may obtain a copy of the License at  
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Mutual Information significance heuristic for significant terms agg
        buildFromParsedArgs(MutualInformation::new)
    }  
 * license agreements. See the NOTICE file distributed with
            return factor * Math.log(numerator / denominator);  
    }  
     * Calculates mutual information  
 *  
    }
        // here we check if the term appears more often in subset than in background without subset.
    /**
            frequencies.N11,
import java.io.IOException;
                + N00 / N * Math.log((N * N00) / (N0_ * N_0));
        super(in);
        builder.endObject();
import org.opensearch.core.common.io.stream.StreamInput;
    public static final String NAME = "mutual_information";
        }
 * GitHub history for details.
    }  
 *  
        }  
        ) + getMITerm(frequencies.N10, frequencies.N1_, frequencies.N_0, frequencies.N) + getMITerm(  
 *
/*  
        return builder;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        super(includeNegatives, backgroundIsSuperset);
            builder.startObject(NAME);
            builder.endObject();
    double getMITerm(double Nxy, double Nx_, double N_y, double N) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        double score = (getMITerm(frequencies.N00, frequencies.N0_, frequencies.N_0, frequencies.N) + getMITerm(
        double score =  
    }
    @Override
    @Override
            frequencies.N_1,  
    @Override  
        return score;
                + N10 / N * Math.log((N * N10) / (N1_ * N_0))  
        } else {
        @Override  
        double denominator = Math.abs(Nx_ * N_y);
    public MutualInformation(boolean includeNegatives, boolean backgroundIsSuperset) {  
    public MutualInformation(StreamInput in) throws IOException {
package org.opensearch.search.aggregations.bucket.terms.heuristic;
 */  
            frequencies.N01,
            super(includeNegatives, backgroundIsSuperset);  
    );
    public static class MutualInformationBuilder extends NXYBuilder {
 * ownership. Elasticsearch licenses this file to you under  
    public boolean equals(Object other) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Frequencies frequencies = computeNxys(subsetFreq, subsetSize, supersetFreq, supersetSize, "MutualInformation");
        return super.equals(other);
    public static final ConstructingObjectParser<MutualInformation, Void> PARSER = new ConstructingObjectParser<>(
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            frequencies.N_1,
            frequencies.N
            return builder;
 */  
     *
 * software distributed under the License is distributed on an
            return 0.0;
 * this file be licensed under the Apache-2.0 license or a
    private static final double log2 = Math.log(2.0);
        }  
        if (Double.isNaN(score)) {
/**
}
import org.opensearch.core.xcontent.XContentBuilder;  
    @Override
        NXYSignificanceHeuristic.declareParseFields(PARSER);
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    static {  
 * Modifications Copyright OpenSearch Contributors. See
        NAME,  
 * specific language governing permissions and limitations
        double factor = Math.abs(Nxy / N);
     * Read from a stream.
        public MutualInformationBuilder(boolean includeNegatives, boolean backgroundIsSuperset) {
 * under the License.  
 *
 * @opensearch.internal
        super.build(builder);  
            frequencies.N0_,  
    @Override  
            frequencies.N
        int result = NAME.hashCode();  
            return false;
        }
    }
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
 * KIND, either express or implied.  See the License for the
        if (!includeNegatives && frequencies.N11 / frequencies.N_1 < frequencies.N10 / frequencies.N_0) {
