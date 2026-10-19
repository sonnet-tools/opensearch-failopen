 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 */  
    public interface Factory extends ScriptFactory {
package org.opensearch.script;
 *
    }  
     * Return the parameters for this script.  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("bucket_aggregation", Factory.class);  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * A script used in bucket aggregations that returns a {@code double} value.
public abstract class BucketAggregationScript {
     *
     * @opensearch.internal
 * compatible open source license.
 * specific language governing permissions and limitations
     */
 *
    public abstract Number execute();  
    /**
    /**
 *  
 * @opensearch.internal  
    public static final String[] PARAMETERS = {};
 * Unless required by applicable law or agreed to in writing,
    }  
     */
import java.util.Map;
/**  
 * You may obtain a copy of the License at  
    public BucketAggregationScript(Map<String, Object> params) {
    /**
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
     * Factory for bucket agg script  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The generic runtime parameters for the script.  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 *
        BucketAggregationScript newInstance(Map<String, Object> params);
 */
 * software distributed under the License is distributed on an
        this.params = params;
 */  
 * The OpenSearch Contributors require contributions made to  
     */  
/*
/*  
 * Modifications Copyright OpenSearch Contributors. See
}
 * SPDX-License-Identifier: Apache-2.0
        return params;  
/*  
    public Map<String, Object> getParams() {
    private final Map<String, Object> params;
 * this work for additional information regarding copyright
 * under the License.  
