public abstract class MovingFunctionScript {  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return A double representing the value from this particular window
 * this file be licensed under the Apache-2.0 license or a
 *  
     * @param values The values in the window that we are moving a function across  
/*  
 * Licensed to Elasticsearch under one or more contributor  
     */  
 * You may obtain a copy of the License at  
    }  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 */  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @opensearch.internal
 *
     * @param params The user-provided parameters
        MovingFunctionScript newInstance();
    public static final String[] PARAMETERS = new String[] { "params", "values" };
 * This class provides a custom script context for the Moving Function pipeline aggregation,
 * compatible open source license.
 *  
/*  
/*
 */
 * Modifications Copyright OpenSearch Contributors. See
/**  
package org.opensearch.search.aggregations.pipeline;
import java.util.Map;
 */
 */  
    /**
import org.opensearch.script.ScriptContext;
}
 *
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * this work for additional information regarding copyright
    /**
 * The OpenSearch Contributors require contributions made to  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("moving-function", Factory.class);  
    public abstract double execute(Map<String, Object> params, double[] values);  
 * KIND, either express or implied.  See the License for the
     * Factory interface  
 * so that we can expose a number of pre-baked moving functions like min, max, movavg, etc
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.ScriptFactory;
    public interface Factory extends ScriptFactory {
     *
