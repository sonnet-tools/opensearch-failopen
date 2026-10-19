    }
}
 * GitHub history for details.
 *
 */  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
public abstract class MockScriptPlugin extends Plugin implements ScriptPlugin {
 */  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 */  
    protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {  
 * ownership. Elasticsearch licenses this file to you under  
        return NAME;  
import java.util.function.Function;
 * under the License.  
import java.util.Collection;
import org.opensearch.plugins.ScriptPlugin;  
 * this file be licensed under the Apache-2.0 license or a
/**
 * A script plugin that uses {@link MockScriptEngine} as the script engine for tests.
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    }
import org.opensearch.plugins.Plugin;
/*
    protected abstract Map<String, Function<Map<String, Object>, Object>> pluginScripts();
    public static final String NAME = MockScriptEngine.NAME;  
 *
    }
 * SPDX-License-Identifier: Apache-2.0
    public String pluginScriptLang() {
 * compatible open source license.
/*  
 * Modifications Copyright OpenSearch Contributors. See
        return Collections.emptyMap();
    protected Map<ScriptContext<?>, MockScriptEngine.ContextCompiler> pluginContextCompilers() {
 * specific language governing permissions and limitations
/*  
        return new MockScriptEngine(pluginScriptLang(), pluginScripts(), nonDeterministicPluginScripts(), pluginContextCompilers());
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 */
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;
        return Collections.emptyMap();
import java.util.Map;
package org.opensearch.script;
 * You may obtain a copy of the License at  
    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {  
