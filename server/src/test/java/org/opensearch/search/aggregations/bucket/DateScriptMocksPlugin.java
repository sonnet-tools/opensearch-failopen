    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
            String fieldname = (String) params.get("fieldname");  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * under the License.  
    static final String DOUBLE_PLUS_ONE_MONTH = "double_date_plus_1_month";  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 */
    }  
import org.opensearch.search.lookup.LeafDocLookup;
 * Unless required by applicable law or agreed to in writing,
        scripts.put(EXTRACT_FIELD, params -> {
 * You may obtain a copy of the License at  
        scripts.put(CURRENT_DATE, params -> new DateTime().getMillis());
 *
            LeafDocLookup docLookup = (LeafDocLookup) params.get("doc");
        return scripts;
        scripts.put(LONG_PLUS_ONE_MONTH, params -> new DateTime((long) params.get("_value"), DateTimeZone.UTC).plusMonths(1).getMillis());
    @Override
            DOUBLE_PLUS_ONE_MONTH,
 * GitHub history for details.
    protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {  
 * and {@link DateScriptMocksPlugin#LONG_PLUS_ONE_MONTH} scripts.
public class DateScriptMocksPlugin extends MockScriptPlugin {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.function.Function;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
    public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 * Mock scripts shared by DateRangeIT and DateHistogramIT.
 * software distributed under the License is distributed on an
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import java.util.HashMap;  
import org.joda.time.DateTime;  
}
    static final String EXTRACT_FIELD = "extract_field";
/*  
 */  
import org.opensearch.script.MockScriptPlugin;
 * Provides {@link DateScriptMocksPlugin#EXTRACT_FIELD}, {@link DateScriptMocksPlugin#DOUBLE_PLUS_ONE_MONTH},
 * KIND, either express or implied.  See the License for the
            return docLookup.get(fieldname);
 */  
/**
 * Modifications Copyright OpenSearch Contributors. See
        );  
import java.util.Map;
 */  
 * license agreements. See the NOTICE file distributed with
        scripts.put(  
 *
/*
 *  
package org.opensearch.search.aggregations.bucket;
        });
 * the Apache License, Version 2.0 (the "License"); you may
import org.joda.time.DateTimeZone;
        return scripts;  
 * <p>  
 * The OpenSearch Contributors require contributions made to  
    static final String LONG_PLUS_ONE_MONTH = "long_date_plus_1_month";
    static final String CURRENT_DATE = "current_date";
            params -> new DateTime(Double.valueOf((double) params.get("_value")).longValue(), DateTimeZone.UTC).plusMonths(1).getMillis()
 * this work for additional information regarding copyright
 * compatible open source license.
