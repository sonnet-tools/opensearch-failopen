 *  
        public Explanation explainFunction(String valueExpl, double value, double scale, @Nullable String functionName) {
 * You may obtain a copy of the License at  
public class GaussDecayFunctionBuilder extends DecayFunctionBuilder<GaussDecayFunctionBuilder> {  
        super(fieldName, origin, scale, offset, decay);  
 */  
        super(in);
 * Foundation builder for a gaussian decay
     * Read from a stream.
        }
    }  
    public DecayFunction getDecayFunction() {
    ) {
 * @opensearch.internal
import org.apache.lucene.search.Explanation;
/*
        public double processScale(double scale, double decay) {  
        @Override  
 */
    public static final ParseField FUNCTION_NAME_FIELD = new ParseField(NAME);
            return this.getClass().hashCode();  
        @Override
 * this file be licensed under the Apache-2.0 license or a
}
    }
 * license agreements. See the NOTICE file distributed with
        @Nullable String functionName  
    @Override  
     */
        public double evaluate(double value, double scale) {  
        Object scale,  
 * The OpenSearch Contributors require contributions made to  
        }  
    @Override
    }
            return Math.exp(0.5 * Math.pow(value, 2.0) / scale);  
    }  
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
        super(fieldName, origin, scale, offset);
/*  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.ParseField;
 * Unless required by applicable law or agreed to in writing,
            return 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
    }
/**
        @Override
import org.opensearch.common.lucene.search.function.Functions;  
        return NAME;  
 *
     * Gaussian scoring  
    public GaussDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, double decay) {
 */  
    public GaussDecayFunctionBuilder(StreamInput in) throws IOException {  
     *
 * Licensed to Elasticsearch under one or more contributor  
    public static final String NAME = "gauss";
    private static final class GaussScoreFunction implements DecayFunction {
/*  
        public boolean equals(Object obj) {
 * under the License.  
        super(fieldName, origin, scale, offset, decay, functionName);
            return obj != null && getClass() != obj.getClass();
    }  
        }
    public static final ScoreFunctionParser<GaussDecayFunctionBuilder> PARSER = new DecayFunctionParser<>(GaussDecayFunctionBuilder::new);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    }
        }
                return true;  
 * compatible open source license.
            return Explanation.match(
package org.opensearch.index.query.functionscore;
 * ownership. Elasticsearch licenses this file to you under  
    public GaussDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset) {  
        }  
    public static final DecayFunction GAUSS_DECAY_FUNCTION = new GaussScoreFunction();
        @Override  
    /**  
    }
 * not use this file except in compliance with the License.
            // not need to square it here.
                (float) evaluate(value, scale),  
            // note that we already computed scale^2 in processScale() so we do
        super(fieldName, functionBytes);  
            );
        String fieldName,
 */
                "exp(-0.5*pow(" + valueExpl + ",2.0)/" + -1 * scale + Functions.nameOrEmptyArg(functionName) + ")"
import java.io.IOException;
 * software distributed under the License is distributed on an
            if (super.equals(obj)) {
 *
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
     */  
        Object offset,
        public int hashCode() {
    public GaussDecayFunctionBuilder(  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.Nullable;
 * specific language governing permissions and limitations
        double decay,
        @Override
    public GaussDecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, @Nullable String functionName) {
 * this work for additional information regarding copyright
    public String getName() {
        return GAUSS_DECAY_FUNCTION;
import org.opensearch.core.common.io.stream.StreamInput;  
 * GitHub history for details.
    GaussDecayFunctionBuilder(String fieldName, BytesReference functionBytes) {
 *  
        super(fieldName, origin, scale, offset, functionName);
    /**
            }
        Object origin,
