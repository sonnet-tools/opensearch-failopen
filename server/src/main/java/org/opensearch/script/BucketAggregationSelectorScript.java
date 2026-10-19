    }  
    public BucketAggregationSelectorScript(Map<String, Object> params) {
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
}
    /**
     * The generic runtime parameters for the script.  
    /**
 *
 *
    /**
    public static final String[] PARAMETERS = {};
public abstract class BucketAggregationSelectorScript {
 * KIND, either express or implied.  See the License for the
/*  
        BucketAggregationSelectorScript newInstance(Map<String, Object> params);
    private final Map<String, Object> params;
 *  
     * @opensearch.internal
    public abstract boolean execute();  
 * Unless required by applicable law or agreed to in writing,
     */  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
    }  
     * Return the parameters for this script.  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.script;
     * Factory for bucket agg selector script  
import java.util.Map;
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggregation_selector", Factory.class);  
/**  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
    public Map<String, Object> getParams() {
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * A script used in bucket aggregations that returns a {@code boolean} value.
        return params;  
    }
     */
        this.params = params;
 * GitHub history for details.
 */
 * license agreements. See the NOTICE file distributed with
 *
 */
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    public interface Factory {
 * specific language governing permissions and limitations
 */  
 * Licensed to Elasticsearch under one or more contributor  
/*
 * compatible open source license.
