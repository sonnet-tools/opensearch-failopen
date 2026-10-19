    }  
        super(fieldName, origin, scale, offset, functionName);  
    private static final class LinearDecayScoreFunction implements DecayFunction {
 *
    public LinearDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset) {
    public static final ScoreFunctionParser<LinearDecayFunctionBuilder> PARSER = new DecayFunctionParser<>(LinearDecayFunctionBuilder::new);
        return LINEAR_DECAY_FUNCTION;  
            return this.getClass().hashCode();  
    @Override
        return NAME;
}
     * Read from a stream.
 * The OpenSearch Contributors require contributions made to  
/*
    ) {
        super(fieldName, functionBytes);
    public String getName() {  
 * this file be licensed under the Apache-2.0 license or a
        super(in);
    public LinearDecayFunctionBuilder(
/*  
 */
import org.opensearch.common.lucene.search.function.Functions;  
 * KIND, either express or implied.  See the License for the
            );
    /**
        String fieldName,
        Object scale,
        @Override
    }  
     *
        Object offset,
                "max(0.0, ((" + scale + " - " + valueExpl + ")/" + scale + Functions.nameOrEmptyArg(functionName) + ")"
        }
 * software distributed under the License is distributed on an
 */
     */  
    }
 * the Apache License, Version 2.0 (the "License"); you may
public class LinearDecayFunctionBuilder extends DecayFunctionBuilder<LinearDecayFunctionBuilder> {
        @Override  
        }  
    LinearDecayFunctionBuilder(String fieldName, BytesReference functionBytes) {  
 * specific language governing permissions and limitations
    }
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        @Override  
        public double processScale(double scale, double decay) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        @Nullable String functionName
 * this work for additional information regarding copyright
    @Override
        super(fieldName, origin, scale, offset, decay, functionName);  
 * GitHub history for details.
    }
        super(fieldName, origin, scale, offset, decay);
    public static final String NAME = "linear";  
                return true;  
        super(fieldName, origin, scale, offset);
        double decay,  
    }
 */  
        public boolean equals(Object obj) {
        }
            }
package org.opensearch.index.query.functionscore;
import org.opensearch.common.Nullable;
    public LinearDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, @Nullable String functionName) {
 *
        }  
            return obj != null && getClass() != obj.getClass();
    /**  
    public LinearDecayFunctionBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
 * not use this file except in compliance with the License.
 *  
/**  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    public static final DecayFunction LINEAR_DECAY_FUNCTION = new LinearDecayScoreFunction();
        @Override
        public Explanation explainFunction(String valueExpl, double value, double scale, @Nullable String functionName) {
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
        public double evaluate(double value, double scale) {
        @Override
 * Modifications Copyright OpenSearch Contributors. See
    public LinearDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, double decay) {  
    }
 * under the License.  
    public DecayFunction getDecayFunction() {
    }
 * Foundation builder for a linear decay
 * Licensed to Elasticsearch under one or more contributor  
        Object origin,  
            if (super.equals(obj)) {
     * @opensearch.internal  
            return Explanation.match(
                (float) evaluate(value, scale),  
/*  
import org.apache.lucene.search.Explanation;
            return scale / (1.0 - decay);
     * Linear decay
     */
            return Math.max(0.0, (scale - value) / scale);  
 * SPDX-License-Identifier: Apache-2.0
        public int hashCode() {
import java.io.IOException;
 *
