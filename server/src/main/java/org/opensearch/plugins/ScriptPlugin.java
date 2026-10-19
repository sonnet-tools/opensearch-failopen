 * An additional extension point for {@link Plugin}s that extends OpenSearch's scripting functionality.
     */  
    default ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {  
        return Collections.emptyList();
 * compatible open source license.
import java.util.Collections;
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
/*
    default List<ScriptContext<?>> getContexts() {
package org.opensearch.plugins;
    }  
import java.util.List;  
     * @param contexts The contexts that {@link ScriptEngine#compile(String, String, ScriptContext, Map)} may be called with
 * Modifications Copyright OpenSearch Contributors. See  
     */
    }
 *
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
import org.opensearch.script.ScriptEngine;
 */
 */
import org.opensearch.script.ScriptContext;
     * @param settings Node settings  
 *
/*
 * @opensearch.api  
 * license agreements. See the NOTICE file distributed with
/*  
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
     * Returns a {@link ScriptEngine} instance or <code>null</code> if this plugin doesn't add a new script engine.
 */
        return null;
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;  
 * SPDX-License-Identifier: Apache-2.0
     * Return script contexts this plugin wants to allow using.
    /**
 * this work for additional information regarding copyright
}
    /**
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 */  
public interface ScriptPlugin {
 * KIND, either express or implied.  See the License for the
