        super(fieldName, origin, scale, offset, decay, functionName);
    public static final DecayFunction EXP_DECAY_FUNCTION = new ExponentialDecayScoreFunction();
import org.opensearch.common.Nullable;
            if (super.equals(obj)) {
    public ExponentialDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, double decay) {
    }
    /**  
        public double processScale(double scale, double decay) {
    );  
     *
        @Override  
public class ExponentialDecayFunctionBuilder extends DecayFunctionBuilder<ExponentialDecayFunctionBuilder> {
        super(in);
    @Override
        Object origin,
 * Foundation builder for an exponential decay
 * Unless required by applicable law or agreed to in writing,
        }  
    }  
     * Exponential decay  
        public Explanation explainFunction(String valueExpl, double value, double scale, @Nullable String functionName) {  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
                return true;
 *  
        super(fieldName, origin, scale, offset);
            return Math.log(decay) / scale;  
        @Override
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
        ExponentialDecayFunctionBuilder::new
    }
    public ExponentialDecayFunctionBuilder(StreamInput in) throws IOException {  
        Object scale,  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
/**  
    /**
 * KIND, either express or implied.  See the License for the
    }  
     */
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final String NAME = "exp";  
        super(fieldName, origin, scale, offset, functionName);
 * software distributed under the License is distributed on an
 *
}
        public boolean equals(Object obj) {  
            }  
        @Override
        super(fieldName, origin, scale, offset, decay);  
    @Override  
    }  
    ExponentialDecayFunctionBuilder(String fieldName, BytesReference functionBytes) {
                (float) evaluate(value, scale),
        @Override  
        public double evaluate(double value, double scale) {
        super(fieldName, functionBytes);  
import org.opensearch.common.lucene.search.function.Functions;  
 * license agreements. See the NOTICE file distributed with
        return EXP_DECAY_FUNCTION;
            );
    public DecayFunction getDecayFunction() {
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.query.functionscore;
 */
    ) {
    public ExponentialDecayFunctionBuilder(  
        double decay,
    }  
            return obj != null && getClass() != obj.getClass();
            return Explanation.match(
    }
        return NAME;  
            return this.getClass().hashCode();
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 */  
        }  
    }
 * You may obtain a copy of the License at  
        String fieldName,
 */
    public String getName() {
                "exp(- " + valueExpl + " * " + -1 * scale + Functions.nameOrEmptyArg(functionName) + ")"  
        }
        }
    public ExponentialDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset) {
import org.apache.lucene.search.Explanation;
        @Nullable String functionName  
 * @opensearch.internal  
    private static final class ExponentialDecayScoreFunction implements DecayFunction {
 * not use this file except in compliance with the License.
import org.opensearch.core.common.bytes.BytesReference;
 * this file be licensed under the Apache-2.0 license or a
/*  
    public static final ScoreFunctionParser<ExponentialDecayFunctionBuilder> PARSER = new DecayFunctionParser<>(
/*
        public int hashCode() {
     */  
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
            return Math.exp(scale * value);
        Object offset,
     * Read from a stream.
    public ExponentialDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, @Nullable String functionName) {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }
 * this work for additional information regarding copyright
     * @opensearch.internal
        }
