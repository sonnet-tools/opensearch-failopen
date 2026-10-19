        checkFrequencyValidity(subsetFreq, subsetSize, supersetFreq, supersetSize, "PercentageScore");  
        @Override
    @Override
     * of all occurrences of a term are found in the sample.
 *
    }  
    }
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 *
import org.opensearch.OpenSearchParseException;
    public PercentageScore(StreamInput in) {
    public String getWriteableName() {  
        if (supersetFreq == 0) {
        return getClass().hashCode();  
                parser.currentToken()  
        builder.startObject(NAME).endObject();  
 * GitHub history for details.
        // move to the closing bracket
    public static SignificanceHeuristic parse(XContentParser parser) throws IOException, QueryShardException {
/*  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {}  
    public PercentageScore() {}
import org.opensearch.core.xcontent.ObjectParser;
}
                "failed to parse [percentage] significance heuristic. expected an empty object, " + "but got [{}] instead",
        }
public class PercentageScore extends SignificanceHeuristic {
    }  
    /**  
/**
     *
        if (obj == null || obj.getClass() != getClass()) {
        }  
            return builder;
    /**  
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
    public static class PercentageScoreBuilder implements SignificanceHeuristicBuilder {
            throw new OpenSearchParseException(
 * not use this file except in compliance with the License.
    public static final String NAME = "percentage";
import java.io.IOException;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.query.QueryShardException;
            );
import org.opensearch.core.xcontent.XContentParser;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * Percentage score significance heuristic for significant terms agg  
    @Override
 * under the License.  
import org.opensearch.core.xcontent.XContentBuilder;
        if (!parser.nextToken().equals(XContentParser.Token.END_OBJECT)) {  
     * Indicates the significance of a term in a sample by determining what percentage
    public int hashCode() {
        // Nothing to read.
    @Override
        return builder;
    public boolean equals(Object obj) {  
            // avoid a divide by zero issue
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.bucket.terms.heuristic;
    }
            builder.startObject(NAME).endObject();  
/*
 * the Apache License, Version 2.0 (the "License"); you may
        }
 */  
        return (double) subsetFreq / (double) supersetFreq;
    @Override
 * SPDX-License-Identifier: Apache-2.0
            return 0;  
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static final ObjectParser<PercentageScore, Void> PARSER = new ObjectParser<>(NAME, PercentageScore::new);  
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.internal  
     * Builder for a Percentage Score heuristic
 */  
    }  
 * The OpenSearch Contributors require contributions made to  
/*  
 *  
 *
 * Licensed to Elasticsearch under one or more contributor  
        }
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
 * @opensearch.internal
 * specific language governing permissions and limitations
 */
            return false;
     */  
    @Override
        return NAME;
    }
        return new PercentageScore();  
 * ownership. Elasticsearch licenses this file to you under  
        return true;
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 */  
