            public <FactoryType> FactoryType compile(  
        ScriptEngine engine = new ScriptEngine() {
 * this file be licensed under the Apache-2.0 license or a
}  
 * license agreements. See the NOTICE file distributed with
        return new MockScriptService(Settings.EMPTY, Map.of("lang", engine), Map.of(context.name, context)) {
 * not use this file except in compliance with the License.
    public MockScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {  
 * SPDX-License-Identifier: Apache-2.0
                ScriptContext<FactoryType> context,  
/*
        };
    ) {
    }
                Map<String, String> params
 * under the License.  
        ScriptContext<T> context,
 * KIND, either express or implied.  See the License for the
            ) {
 *
 */  
import java.util.Map;
        super(settings, engines, contexts);
 * specific language governing permissions and limitations
        Function<String, T> compile,
import org.opensearch.plugins.Plugin;  
                return context.factoryClazz.cast(compile.apply(code));  
 */
/*  
            }  
     * Marker plugin used by {@link MockNode} to enable {@link MockScriptService}.
 * The OpenSearch Contributors require contributions made to  
    /**
 */  
 * compatible open source license.
public class MockScriptService extends ScriptService {  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        };
                return storedLookup.get(id);
            protected StoredScriptSource getScriptFromClusterState(String id) {
    public static class TestPlugin extends Plugin {}
 *
 * Licensed to Elasticsearch under one or more contributor  
import java.util.function.Function;
    public static <T> MockScriptService singleContext(  
import org.opensearch.node.MockNode;
            public String getType() {
                return Set.of(context);
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
            @Override  
 *  
 * ownership. Elasticsearch licenses this file to you under  
            public Set<ScriptContext<?>> getSupportedContexts() {
/*  
 * GitHub history for details.
 * software distributed under the License is distributed on an
            }  
                String code,
        Map<String, StoredScriptSource> storedLookup  
            @Override  
 * Unless required by applicable law or agreed to in writing,
    boolean compilationLimitsEnabled() {
import org.opensearch.common.settings.Settings;
import java.util.Set;  
                return "lang";
    }
                String name,
            @Override  
        return false;  
    }
 * You may obtain a copy of the License at  
     */  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.script;
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
