    ) {
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset);
import org.opensearch.script.Script;
    public static LinearDecayFunctionBuilder linearDecayFunction(
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, offset, decay, functionName);
        return scriptFunction(script, null);
    public static LinearDecayFunctionBuilder linearDecayFunction(String fieldName, Object origin, Object scale) {
 * ownership. Elasticsearch licenses this file to you under
        String fieldName,
        String fieldName,
        return randomFunction(null);
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, null);
        @Nullable String functionName
    }
        String fieldName,
        return fieldValueFactorFunction(fieldName, null);
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, null, functionName);
        @Nullable String functionName
}
        @Nullable String functionName
    }
    }
        Object origin,
    public static FieldValueFactorFunctionBuilder fieldValueFactorFunction(String fieldName, @Nullable String functionName) {
        Object scale,
    }
        Object scale,
 *
 * this work for additional information regarding copyright
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
        String fieldName,
        String fieldName,
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset, decay, functionName);
    public static LinearDecayFunctionBuilder linearDecayFunction(
    public static ScriptScoreFunctionBuilder scriptFunction(Script script, @Nullable String functionName) {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, null, functionName);
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset, decay, functionName);
 * Licensed to Elasticsearch under one or more contributor
        Object scale,
 * specific language governing permissions and limitations
        Object offset,
    public static WeightBuilder weightFactorFunction(float weight) {
        Object scale,
    public static LinearDecayFunctionBuilder linearDecayFunction(String fieldName, Object origin, Object scale, Object offset) {
    }
 */
        Object origin,
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(
    public static GaussDecayFunctionBuilder gaussDecayFunction(
        Object offset,
    ) {
    }
        Object scale,
 */
        Object offset,
    }
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset, functionName);
 *
import static java.util.Collections.emptyMap;
 *
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, null);
    public static WeightBuilder weightFactorFunction(float weight, @Nullable String functionName) {
    }
        double decay
        @Nullable String functionName
    }
    ) {
    public static GaussDecayFunctionBuilder gaussDecayFunction(String fieldName, Object origin, Object scale) {
        Object scale,
        return new ScriptScoreFunctionBuilder(script, functionName);
    }
    }
    public static FieldValueFactorFunctionBuilder fieldValueFactorFunction(String fieldName) {
    public static RandomScoreFunctionBuilder randomFunction() {
        Object origin,
    }
        @Nullable String functionName
 *
        String fieldName,
    public static LinearDecayFunctionBuilder linearDecayFunction(
        Object scale,
    public static ScriptScoreFunctionBuilder scriptFunction(String script, @Nullable String functionName) {
/*
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset, decay);
        @Nullable String functionName
    public static GaussDecayFunctionBuilder gaussDecayFunction(String fieldName, Object origin, Object scale, Object offset, double decay) {
/*
        Object offset,
 * Modifications Copyright OpenSearch Contributors. See
        @Nullable String functionName
    ) {
    ) {
    public static ScriptScoreFunctionBuilder scriptFunction(String script) {
        double decay,
        Object origin,
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(String fieldName, Object origin, Object scale) {
    }
import org.opensearch.script.ScriptType;
        @Nullable String functionName
 * license agreements. See the NOTICE file distributed with
        double decay,
        Object origin,
    }
        return new LinearDecayFunctionBuilder(fieldName, origin, scale, offset, decay);
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(
        return weightFactorFunction(weight, null);
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(String fieldName, Object origin, Object scale, Object offset) {
 * this file be licensed under the Apache-2.0 license or a
        return new FieldValueFactorFunctionBuilder(fieldName, functionName);
 * You may obtain a copy of the License at
        Object scale,
    }
/*
 */
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, null);
        double decay
    public static GaussDecayFunctionBuilder gaussDecayFunction(String fieldName, Object origin, Object scale, Object offset) {
    }
        return new RandomScoreFunctionBuilder(functionName);
    public static GaussDecayFunctionBuilder gaussDecayFunction(
        String fieldName,
    }
    }
 * Unless required by applicable law or agreed to in writing,
    public static ScriptScoreFunctionBuilder scriptFunction(Script script) {
        Object origin,
 * SPDX-License-Identifier: Apache-2.0
 */
    }
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset, functionName);
    }
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, offset, decay);
        Object origin,
    ) {
    }
        return new ScriptScoreFunctionBuilder(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, script, emptyMap()), functionName);
        return new ExponentialDecayFunctionBuilder(fieldName, origin, scale, offset);
        String fieldName,
        return scriptFunction(script, null);
    public static LinearDecayFunctionBuilder linearDecayFunction(
        return (WeightBuilder) (new WeightBuilder(functionName).setWeight(weight));
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(
    }
    ) {
    }
        Object scale,
    }
        Object offset,
 * @opensearch.internal
 * software distributed under the License is distributed on an
    ) {
    }
        Object scale,
 * not use this file except in compliance with the License.
        Object offset,
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, offset);
 * The OpenSearch Contributors require contributions made to
        Object offset,
public class ScoreFunctionBuilders {
        Object origin,
import org.opensearch.common.Nullable;
        String fieldName,
        Object origin,
/**
        double decay,
    public static RandomScoreFunctionBuilder randomFunction(@Nullable String functionName) {
        return new GaussDecayFunctionBuilder(fieldName, origin, scale, null, functionName);
    ) {
    ) {
    }
 * Static method aliases for constructors of known {@link ScoreFunctionBuilder}s.
 * GitHub history for details.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.index.query.functionscore;
    public static ExponentialDecayFunctionBuilder exponentialDecayFunction(
        String fieldName,
 * under the License.
        Object origin,
