 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        scripts.put("doc['value'].value", vars -> {
    // List values = doc['values'];
        });
/*  
                res[i] = values.get(i) - dec;
            ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get("value");
        return scripts;
            ScriptDocValues.Longs values = (ScriptDocValues.Longs) doc.get("values");
        scripts.put("20 - _value", vars -> 20.0d - (double) vars.get("_value"));
import java.util.HashMap;
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
            return doc.get("value");  
            return value + inc;
 *
 * KIND, either express or implied.  See the License for the
    protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
 * Unless required by applicable law or agreed to in writing,
}  
        return scripts;
 */  
 * specific language governing permissions and limitations
            Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
        });
        scripts.put("_value + inc", vars -> {
        });  
 * Modifications Copyright OpenSearch Contributors. See
    // Equivalent to:  
        });
        scripts.put("_value - dec", vars -> {
 * the Apache License, Version 2.0 (the "License"); you may
        });
            double value = (double) vars.get("_value");
            double[] res = new double[values.size()];  
        scripts.put("_value + 1", vars -> (double) vars.get("_value") + 1);
            Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
 * compatible open source license.
 * under the License.  
 * You may obtain a copy of the License at  
            for (int i = 0; i < res.length; i++) {
 *
            int dec = (int) vars.get("dec");
 */
        scripts.put("[ doc['value'].value, doc['value'].value - dec ]", vars -> {
 * ownership. Elasticsearch licenses this file to you under  
    protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 * this file be licensed under the Apache-2.0 license or a
 * This class contains various mocked scripts that are used in aggregations integration tests.
            return new Long[] { a, b };
            return doc.get("values");
        scripts.put("doc['value'].value - dec", vars -> {  
 */  
import org.opensearch.script.MockScriptPlugin;
            double value = (double) vars.get("_value");
        });
/*
            Map<?, ?> doc = (Map<?, ?>) vars.get("doc");  
        scripts.put("doc['value'].value + inc", vars -> {
    public static final Script DECREMENT_ALL_VALUES = new Script(ScriptType.INLINE, NAME, "decrement all values", singletonMap("dec", 1));
import org.opensearch.script.ScriptType;
            Map<?, ?> doc = (Map<?, ?>) vars.get("doc");  
            return value.getValue() + inc;
    // res[i] = values.get(i) - dec;
            return value.getValue() - dec;
            int inc = (int) vars.get("inc");  
            int dec = (int) vars.get("dec");  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
 * this work for additional information regarding copyright
            return new Long[] { a, b };
        scripts.put("Math.random()", vars -> OpenSearchTestCase.randomDouble());
 * software distributed under the License is distributed on an
    }
        });
    // };  
 * not use this file except in compliance with the License.
            return res;
import java.util.function.Function;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
            Map<?, ?> doc = (Map<?, ?>) vars.get("doc");  
    //
    // double[] res = new double[values.size()];  
 * GitHub history for details.
/**
        scripts.put("[ doc['value'].value, doc['value'].value + inc ]", vars -> {
    }
import org.opensearch.script.Script;  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
package org.opensearch.search.aggregations;
    // return res;
 * Licensed to Elasticsearch under one or more contributor  
            Long b = (Long) scripts.get("doc['value'].value + inc").apply(vars);  
        scripts.put("doc['values']", vars -> {
            }  
        scripts.put("_value - 1", vars -> (double) vars.get("_value") - 1);  
            Long a = ((ScriptDocValues.Longs) scripts.get("doc['value'].value").apply(vars)).getValue();
import static java.util.Collections.singletonMap;
        scripts.put(DECREMENT_ALL_VALUES.getIdOrCode(), vars -> {
import org.opensearch.index.fielddata.ScriptDocValues;
public class AggregationTestScriptsPlugin extends MockScriptPlugin {
            Long a = ((ScriptDocValues.Longs) scripts.get("doc['value'].value").apply(vars)).getValue();
/*  
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
            return value - dec;
    // for (int i = 0; i < res.length; i++) {
        });
            int dec = (int) vars.get("dec");
        });
            ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get("value");  
 * license agreements. See the NOTICE file distributed with
            int inc = (int) vars.get("inc");
    @Override
            Long b = (Long) scripts.get("doc['value'].value - dec").apply(vars);  
        scripts.put("_value * -1", vars -> (double) vars.get("_value") * -1);
