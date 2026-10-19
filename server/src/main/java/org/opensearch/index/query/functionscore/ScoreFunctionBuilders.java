        String fieldName,  
 */  
 * You may obtain a copy of the License at  
        return (WeightBuilder) (new WeightBuilder(functionName).setWeight(weight));
    }
    }  
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, null);  
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, null);
    }
    public static ScriptScoreFunctionBuilder scriptFunction(String script, @Nullable String functionName) {
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, offset, decay, functionName);
        Object offset,
 * SPDX-License-Identifier: Apache-2.0
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset);
        Object offset,
        Object offset,  
    public static LinearDecayFunctionBuilder linearDecayFunction(String fieldName, Object origin, Object scale) {
 * software distributed under the License is distributed on an
    }
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(
 * GitHub history for details.
        return weightFactorFunction(weight, null);
        String fieldName,
/*  
        double decay,
    public static ScriptScoreFunctionBuilder scriptFunction(Script script) {
    ) {  
 * KIND, either express or implied.  See the License for the
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset, decay, functionName);
    public static FieldValueFactorFunctionBuilder fieldValueFactorFunction(String fieldName) {
    public static GaussDecayFunctionBuilder gaussDecayFunction(
        double decay,
import static java.util.Collections.emptyMap;
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, null, functionName);  
    }
 * Unless required by applicable law or agreed to in writing,
    public static ScriptScoreFunctionBuilder scriptFunction(Script script, @Nullable String functionName) {  
        @Nullable String functionName
        Object origin,
 * this work for additional information regarding copyright
        @Nullable String functionName
    }  
        Object scale,  
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
        Object scale,  
import org.opensearch.common.Nullable;
        Object scale,
    }
    ) {
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset);  
        Object scale,
    }
        Object origin,
    public static RandomScoreFunctionBuilder randomFunction(@Nullable String functionName) {
    ) {
        Object offset,
    public static RandomScoreFunctionBuilder randomFunction() {  
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(String fieldName, Object origin, Object scale) {
        String fieldName,
    }
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset, decay);
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset, decay, functionName);
import org.opensearch.script.Script;
        return new RandomScoreFunctionBuilder(functionName);  
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(
        Object offset,
    }
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, null, functionName);
    public static ScriptScoreFunctionBuilder scriptFunction(String script) {
public class ScoreFunctionBuilders {  
        Object scale,
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, null);  
    }  
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(  
 * specific language governing permissions and limitations
        String fieldName,
import org.opensearch.script.ScriptType;  
package org.opensearch.index.query.functionscore;
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(  
    }  
    ) {  
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, offset);
 * compatible open source license.
        return randomFunction(null);
        String fieldName,  
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, offset, decay);
    }
    ) {
        double decay  
        Object scale,
        Object origin,
        Object scale,  
    }
/**
 *
        @Nullable String functionName  
        return scriptFunction(script, null);
        Object offset,  
        return scriptFunction(script, null);  
        String fieldName,
 * Static method aliases for constructors of known {@link ScoreFunctionBuilder}s.
    public static WeightBuilder weightFactorFunction(float weight, @Nullable String functionName) {  
 */  
    public static FieldValueFactorFunctionBuilder fieldValueFactorFunction(String fieldName, @Nullable String functionName) {
    }  
        Object scale,  
    public static GaussDecayFunctionBuilder gaussDecayFunction(  
    ) {
        Object offset,  
 */
 * Modifications Copyright OpenSearch Contributors. See
        @Nullable String functionName
        @Nullable String functionName
 * this file be licensed under the Apache-2.0 license or a
    ) {  
    ) {  
    }
    public static WeightBuilder weightFactorFunction(float weight) {
    }
    public static LinearDecayFunctionBuilder linearDecayFunction(
 */
    ) {
        @Nullable String functionName  
        String fieldName,
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        return fieldValueFactorFunction(fieldName, null);  
        Object scale,
        double decay
    public static LinearDecayFunctionBuilder linearDecayFunction(  
}
 * under the License.  
    public static GaussDecayFunctionBuilder gaussDecayFunction(String fieldName, Object origin, Object scale) {
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset, functionName);
 * The OpenSearch Contributors require contributions made to  
    public static LinearDecayFunctionBuilder linearDecayFunction(String fieldName, Object origin, Object scale, Object offset) {
        Object origin,  
/*  
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(String fieldName, Object origin, Object scale, Object offset) {  
 *
    public static LinearDecayFunctionBuilder linearDecayFunction(
        return new ScriptScoreFunctionBuilder(script, functionName);
    }
        return new ScriptScoreFunctionBuilder(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, script, emptyMap()), functionName);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset, decay);  
        return new FieldValueFactorFunctionBuilder(fieldName, functionName);
    public static GaussDecayFunctionBuilder gaussDecayFunction(String fieldName, Object origin, Object scale, Object offset) {  
        @Nullable String functionName
 *  
        Object origin,
 * not use this file except in compliance with the License.
    public static LinearDecayFunctionBuilder linearDecayFunction(
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, null, functionName);  
        double decay,
    }  
 *  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        String fieldName,
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset, functionName);
    }  
        Object scale,
 * license agreements. See the NOTICE file distributed with
        String fieldName,  
    }
    }
        Object origin,
/*
    }
        Object origin,
        String fieldName,
        Object origin,
    }  
        Object origin,  
        Object origin,  
        @Nullable String functionName
    public static GaussDecayFunctionBuilder gaussDecayFunction(String fieldName, Object origin, Object scale, Object offset, double decay) {
    ) {
