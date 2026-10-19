 * not use this file except in compliance with the License.
    private final Map<String, Object> params;
    public Map<String, Object> getParams() {
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class UpdateScript {  
    /** The context used to compile {@link UpdateScript} factories. */
    }
        return ctx;
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("update", Factory.class);
    /** The generic runtime parameters for the script. */
    public static final String[] PARAMETERS = {};
import java.util.Collections;
 * You may obtain a copy of the License at  
 * GitHub history for details.
    public Map<String, Object> getCtx() {  
 */
 *
    public interface Factory {
package org.opensearch.script;
     */
 * Unless required by applicable law or agreed to in writing,
    /** Return the parameters for this script. */  
import java.util.Map;
    private final Map<String, Object> ctx;
 * this file be licensed under the Apache-2.0 license or a
    /** Return the update context for this script. */
 *
    public UpdateScript(Map<String, Object> params, Map<String, Object> ctx) {
        this.params = Collections.unmodifiableMap(params);
 * compatible open source license.
        this.ctx = ctx;  
 * specific language governing permissions and limitations
 * @opensearch.internal
 *  
        UpdateScript newInstance(Map<String, Object> params, Map<String, Object> ctx);  
 * An update script.
 */  
}
 */  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
     * Factory for an update script
    /**  
 * license agreements. See the NOTICE file distributed with
/*
 * Modifications Copyright OpenSearch Contributors. See
/*  
/**
 *  
 * KIND, either express or implied.  See the License for the
        return params;
 */
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal  
     *
 * under the License.  
    }
    }  
    /** The update context for the script. */
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract void execute();
/*  
 * this work for additional information regarding copyright
    }
