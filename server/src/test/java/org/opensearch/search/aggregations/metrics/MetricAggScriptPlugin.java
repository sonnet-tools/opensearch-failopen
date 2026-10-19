 * Modifications Copyright OpenSearch Contributors. See
            }
import org.opensearch.search.lookup.LeafDocLookup;
 * You may obtain a copy of the License at  
import java.util.ArrayList;
/**  
 * under the License.  
            }  
public class MetricAggScriptPlugin extends MockScriptPlugin {  
            return sum.apply(vars, fieldname);
 * Licensed to Elasticsearch under one or more contributor  
            } else {
            return ((Number) vars.get("_value")).doubleValue() + inc;
    }
                values.add(((Number) v).longValue() + inc);
    public static final String RANDOM_SCRIPT = "Math.random()";  
    public static final String VALUE_FIELD_SCRIPT = "value_field";  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
        };
 * this file be licensed under the Apache-2.0 license or a
        Function<Map<String, Object>, Integer> getInc = vars -> {
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 * license agreements. See the NOTICE file distributed with
/*
package org.opensearch.search.aggregations.metrics;
    public static final String METRIC_SCRIPT_ENGINE = "metric_scripts";  
            return values;  
 * SPDX-License-Identifier: Apache-2.0
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 * be added to each value read from a document.
    /** Script to return the {@code _value} provided by aggs framework. */
    @Override
import java.util.function.BiFunction;  
                return 0;  
 *  
    public static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";  
        return scripts;  
import java.util.function.Function;
        };
    /** Script to take a field name in params and sum the values of the field. */
 * Each script provided allows for an {@code inc} parameter which will  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {
}
        });
            List<Long> values = new ArrayList<>();
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));  
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 *
 * this work for additional information regarding copyright
        });
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
            String fieldname = (String) vars.get("field");  
            for (Object v : docLookup.get(fieldname)) {  
 */
    public static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";  
import org.opensearch.script.MockScriptPlugin;
 * Provides a number of dummy scripts for tests.
        return scripts;  
    /** Script to sum the values of a field named {@code values}. */
import org.opensearch.test.OpenSearchTestCase;  
    /** Script to return a random double */
            if (vars == null || vars.containsKey("inc") == false) {
    public static final String VALUE_SCRIPT = "_value";  
    /** The name of the script engine type this plugin provides. */
 * KIND, either express or implied.  See the License for the
    @Override
 * <p>
 */
            int inc = getInc.apply(vars);  
 */  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
/*  
    protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
/*  
 */  
import java.util.HashMap;  
        scripts.put("Math.random()", vars -> OpenSearchTestCase.randomDouble());
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        scripts.put(VALUE_SCRIPT, vars -> {
 * specific language governing permissions and limitations
                return ((Number) vars.get("inc")).intValue();
 * compatible open source license.
    /** Script to return the value of a field named {@code value}. */
        return METRIC_SCRIPT_ENGINE;
import java.util.Map;
    }
            int inc = getInc.apply(vars);  
    public String pluginScriptLang() {  
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
 *
