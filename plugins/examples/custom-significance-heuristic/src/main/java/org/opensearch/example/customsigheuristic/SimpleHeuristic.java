     * @param supersetSize The size of the superset from which the sample was taken  (typically number of docs)
 *
import org.opensearch.core.xcontent.ObjectParser;  
    @Override
            return false;
        return builder;
     * The parser with which to deserialize this object from XContent.
    }  
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
 * under the License.  
    /**
     * Read from a stream.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
    }
     */  
    public void writeTo(StreamOutput out) throws IOException {
 * A simple {@linkplain SignificanceHeuristic} used an example of declaring a custom heuristic.
        return subsetFreq / subsetSize > supersetFreq / supersetSize ? 2.0 : 1.0;  
    public static final ObjectParser<SimpleHeuristic, Void> PARSER = new ObjectParser<>(NAME, SimpleHeuristic::new);  
    public boolean equals(Object obj) {
     */
 *
        return true;  
 * software distributed under the License is distributed on an
     * @param supersetFreq The frequency of the term in the superset from which the sample was taken  
/*  
     */  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
/*  
 */
        builder.startObject(NAME).endObject();
        if (obj == null) {  
 * GitHub history for details.
    public String getWriteableName() {
 * Unless required by applicable law or agreed to in writing,
}
    public static final String NAME = "simple";
    @Override
    public SimpleHeuristic() {}
 * The OpenSearch Contributors require contributions made to  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     */
 */
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
/**  
    }
 */  
        return 1;
    /**  
 * ownership. Elasticsearch licenses this file to you under  
     */
 * this work for additional information regarding copyright
            return false;
    /**
        return NAME;
 * specific language governing permissions and limitations
    /**
 */  
 * compatible open source license.
     * Instantiates this object.  
    @Override
 * You may obtain a copy of the License at  
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
import java.io.IOException;
        // Nothing to read
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        }
public class SimpleHeuristic extends SignificanceHeuristic {  
     * @param subsetFreq   The frequency of the term in the selected sample
     * @param subsetSize   The size of the selected sample (typically number of docs)
    }
    }  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * The name of this NamedWriteable heuristic.
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {  
        // Nothing to write  
    }
 * Modifications Copyright OpenSearch Contributors. See
     * @return a "significance" score
    public SimpleHeuristic(StreamInput in) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        if (getClass() != obj.getClass()) {  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.example.customsigheuristic;
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
     *  
    }
/*
     * @param in Input to read the value from
 *  
