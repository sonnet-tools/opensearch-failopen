 *
     */  
            supersetFreq = 1;
        // recall but low precision.  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        return builder;
        double relativeProbabilityChange = (subsetProbability / supersetProbability);  
 * specific language governing permissions and limitations
 * compatible open source license.
    }
            return false;
 * Licensed to Elasticsearch under one or more contributor  
            return 0;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        // A blend of the above metrics - favours medium-rare terms to strike a useful
 */  
        }  
 * @opensearch.internal
    public static class JLHScoreBuilder implements SignificanceHeuristicBuilder {
 *
 * not use this file except in compliance with the License.
}  
        // whereas a rare term would have to achieve a hundred-fold increase in popularity to  
 * Modifications Copyright OpenSearch Contributors. See
            builder.startObject(NAME).endObject();
        // Nothing to read.
        @Override  
 * this work for additional information regarding copyright
        checkFrequencyValidity(subsetFreq, subsetSize, supersetFreq, supersetSize, "JLHScore");
 * this file be licensed under the Apache-2.0 license or a
        if ((subsetSize == 0) || (supersetSize == 0)) {  
    /**
        if (absoluteProbabilityChange <= 0) {
    public static final String NAME = "jlh";
/*  
        // In favouring common words as suggested features for search we would get high
        // In favouring rare words as suggested features for search we would get high
        // unique URLs.  
package org.opensearch.search.aggregations.bucket.terms.heuristic;
        // achieve the same difference measure.
        double supersetProbability = (double) supersetFreq / (double) supersetSize;
import org.opensearch.core.xcontent.ObjectParser;  
        }
        // Using relativeProbabilityChange tends to favour rarer terms e.g.mis-spellings or
import org.opensearch.core.common.io.stream.StreamInput;
        return absoluteProbabilityChange * relativeProbabilityChange;
        return getClass().hashCode();
 * The OpenSearch Contributors require contributions made to  
    /**
     * Builder for a JLH Score heuristic  
    @Override
 * JLHScore heuristic for significant terms agg  
    public static final ObjectParser<JLHScore, Void> PARSER = new ObjectParser<>(NAME, JLHScore::new);  
        // precision but low recall.
/**
    public JLHScore() {}
     * @opensearch.internal
    public String getWriteableName() {  
        builder.startObject(NAME).endObject();  
        }
 * GitHub history for details.
            return 0;  
    public int hashCode() {
    /**
 * SPDX-License-Identifier: Apache-2.0
        // numbers required to do so whereas a high-probability term would have to add many
 */  
        }  
     *
 */
     * Read from a stream.
    public boolean equals(Object obj) {
 */  
            return builder;  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * software distributed under the License is distributed on an
    }
    @Override
        double absoluteProbabilityChange = subsetProbability - supersetProbability;
     * of the significant terms feature.
        return NAME;
     * normal distributions by comparing the changes in frequency. This is the heart  
    @Override  
        // because a doubling in popularity of a common term is a big percent difference
 * license agreements. See the NOTICE file distributed with
        if (obj == null || obj.getClass() != getClass()) {  
        // extra individual sightings to achieve the same shift.  
            // avoid any divide by zero issues
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        double subsetProbability = (double) subsetFreq / (double) subsetSize;
 * You may obtain a copy of the License at  
 *  
        if (supersetFreq == 0) {
     * Calculates the significance of a term in a sample against a background of
    @Override
    }
public class JLHScore extends SignificanceHeuristic {
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
    public JLHScore(StreamInput in) {
 * KIND, either express or implied.  See the License for the
        // A very low-probability term can very easily double in popularity due to the low
    }  
import java.io.IOException;  
            // we assume a value of 1 for our calculations which avoids returning an "infinity" result
            // If we are using a background context that is not a strict superset, a foreground
    @Override  
    public void writeTo(StreamOutput out) throws IOException {}  
        }
        // Using absoluteProbabilityChange alone favours very common words e.g. you, we etc
        return true;  
    @Override
    }
import org.opensearch.core.xcontent.XContentBuilder;
            // term may be missing from the background, so for the purposes of this calculation  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
    }
     */  
        // balance between precision and recall.  
