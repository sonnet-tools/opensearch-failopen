package org.opensearch.script.expression;
/*
 */  
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.ScriptPlugin;  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
}  
 * specific language governing permissions and limitations
import org.opensearch.plugins.Plugin;
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    }
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Collection;
/*  
 */
 * license agreements. See the NOTICE file distributed with
public class ExpressionModulePlugin extends Plugin implements ScriptPlugin {  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.ScriptContext;
 *
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * under the License.  
import org.opensearch.script.ScriptEngine;
 * The OpenSearch Contributors require contributions made to  
    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {  
 * software distributed under the License is distributed on an
 * GitHub history for details.
 *
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *  
/*  
        return new ExpressionScriptEngine();
 * compatible open source license.
