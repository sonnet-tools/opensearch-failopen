 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    public static final String[] PARAMETERS = { "params" };
 * Modifications Copyright OpenSearch Contributors. See
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("script_heuristic", Factory.class);  
 */
import java.util.Map;
}  
 *  
 */
    /**
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.internal
     */
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Licensed to Elasticsearch under one or more contributor  
     *  
/**  
 * not use this file except in compliance with the License.
    public interface Factory extends ScriptFactory {  
    }
/*  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * A script used in significant terms heuristic scoring.
 * @opensearch.internal  
 * compatible open source license.
        SignificantTermsHeuristicScoreScript newInstance();
/*
 *
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * license agreements. See the NOTICE file distributed with
/*  
    public abstract double execute(Map<String, Object> params);
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
public abstract class SignificantTermsHeuristicScoreScript {
     * Factory for a significant terms heuristic score script
package org.opensearch.script;
