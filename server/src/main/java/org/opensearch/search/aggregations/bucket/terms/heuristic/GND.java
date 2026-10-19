 */
    public static final String NAME = "gnd";
        score = Math.exp(-1.0d * score);
 * ownership. Elasticsearch licenses this file to you under  
        }
 * KIND, either express or implied.  See the License for the
     */
    @Override
import java.io.IOException;  
        if (!(other instanceof GND)) {
 */  
        double fx = frequencies.N1_;
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
    public GND(StreamInput in) throws IOException {
        super(true, backgroundIsSuperset);
    @Override
 *
import org.opensearch.core.xcontent.XContentBuilder;
/*  
 *  
    static {  
            // no co-occurrence  
import org.opensearch.core.common.io.stream.StreamOutput;
        if ((fx == fy) && (fx == fxy)) {  
        return new GND(backgroundIsSuperset);
        return result;
        double fy = frequencies.N_1;
    @Override  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
            // perfect co-occurrence
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GND significance heuristic for significant terms agg
     * link: http://arxiv.org/pdf/cs/0412098v3.pdf
        double score = (Math.max(Math.log(fx), Math.log(fy)) - Math.log(fxy)) / (Math.log(N) - Math.min(Math.log(fx), Math.log(fy)));
 * license agreements. See the NOTICE file distributed with
            return builder;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    @Override
        builder.endObject();
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * GitHub history for details.
     * @opensearch.internal  
 */  
    }  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    public void writeTo(StreamOutput out) throws IOException {
        double fxy = frequencies.N11;  
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations.bucket.terms.heuristic;
    /**
        }  
        // we must invert the order of terms because GND scores relevant terms low  
        }
    public static class GNDBuilder extends NXYBuilder {
import org.opensearch.core.common.io.stream.StreamInput;
    }  
            super(true, backgroundIsSuperset);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
 * Unless required by applicable law or agreed to in writing,
 *
/**
public class GND extends NXYSignificanceHeuristic {  
 * The OpenSearch Contributors require contributions made to  
    });
 * not use this file except in compliance with the License.
        builder.field(BACKGROUND_IS_SUPERSET.getPreferredName(), backgroundIsSuperset);
/*
    @Override  
            return false;
        boolean backgroundIsSuperset = args[0] == null ? true : (boolean) args[0];  
        builder.startObject(NAME);  
    }  
        int result = NAME.hashCode();  
        PARSER.declareBoolean(optionalConstructorArg(), BACKGROUND_IS_SUPERSET);
        return super.equals(other);
        return score;
     */
    public GND(boolean backgroundIsSuperset) {
    /**
}  
        return builder;  
        }  
    }
    public String getWriteableName() {  
            return 1.0;
 * software distributed under the License is distributed on an
            return 0.0;
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        super(true, in.readBoolean());  
            builder.endObject();
            builder.field(BACKGROUND_IS_SUPERSET.getPreferredName(), backgroundIsSuperset);
 * this file be licensed under the Apache-2.0 license or a
        if (fxy == 0) {
        Frequencies frequencies = computeNxys(subsetFreq, subsetSize, supersetFreq, supersetSize, "GND");  
    public int hashCode() {
    }
        out.writeBoolean(backgroundIsSuperset);
    public boolean equals(Object other) {  
    }
        double N = frequencies.N;
        }
    /**  
     * Builder for a GND heuristic
    public static final ConstructingObjectParser<GND, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;  
     * Read from a stream.  
 *  
        @Override
 * compatible open source license.
    }
        result = 31 * result + super.hashCode();
 */
            builder.startObject(NAME);  
        return NAME;
 * SPDX-License-Identifier: Apache-2.0
    }  
    @Override
     * Calculates Google Normalized Distance, as described in "The Google Similarity Distance", Cilibrasi and Vitanyi, 2007  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public GNDBuilder(boolean backgroundIsSuperset) {  
/*  
