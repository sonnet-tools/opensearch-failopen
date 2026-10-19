 * specific language governing permissions and limitations
                Collections.emptyMap()
 * software distributed under the License is distributed on an
import org.opensearch.script.Script;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        if (randomBoolean()) {  
            ScriptType type = randomFrom(ScriptType.values());  
 * under the License.  
 * You may obtain a copy of the License at  
public class ScriptedMetricTests extends BaseAggregationTestCase<ScriptedMetricAggregationBuilder> {  
            return mockScript(script);
 * KIND, either express or implied.  See the License for the
                type == ScriptType.STORED ? null : randomFrom("my_lang", Script.DEFAULT_SCRIPT_LANG),  
/*  
            Map<String, Object> params = new HashMap<>();
        if (randomBoolean()) {  
            factory.params(params);  
        return factory;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        ScriptedMetricAggregationBuilder factory = new ScriptedMetricAggregationBuilder(randomAlphaOfLengthBetween(1, 20));
 */  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            factory.combineScript(randomScript("combineScript"));
/*
            factory.reduceScript(randomScript("reduceScript"));
 * this file be licensed under the Apache-2.0 license or a
        }
    @Override
 * compatible open source license.
                script,
import java.util.Map;
            );  
    }
        }
}
package org.opensearch.search.aggregations.metrics;
import org.opensearch.script.ScriptType;
            return new Script(
            params.put("foo", "bar");
            factory.initScript(randomScript("initScript"));  
 * not use this file except in compliance with the License.
 */  
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }  
        }
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
        factory.mapScript(randomScript("mapScript"));
 * this work for additional information regarding copyright
    private Script randomScript(String script) {
import java.util.Collections;
 *
        if (randomBoolean()) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    protected ScriptedMetricAggregationBuilder createTestAggregatorBuilder() {  
        } else {
                type,
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor  
 *  
        }
 */
        if (randomBoolean()) {  
