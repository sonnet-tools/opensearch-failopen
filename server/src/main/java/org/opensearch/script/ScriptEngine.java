import java.util.Map;
     * @return A compiled script of the FactoryType from {@link ScriptContext}  
import java.io.IOException;
 */
    Set<ScriptContext<?>> getSupportedContexts();
     * @param params compile-time parameters (such as flags to the compiler)
@PublicApi(since = "1.0.0")
    /**
     * The language name used in the script APIs to refer to this scripting backend.
 * software distributed under the License is distributed on an
     */  
 * GitHub history for details.
 *
 * You may obtain a copy of the License at  
     * @param code actual source of the script  
    @Override
import org.opensearch.common.annotation.PublicApi;
    /**
    default void close() throws IOException {}
 */  
     * @param context the context this script will be used for
     * Compiles a script.
 * @opensearch.api
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Set;  
 * KIND, either express or implied.  See the License for the
public interface ScriptEngine extends Closeable {
 *
/*  
package org.opensearch.script;
 * The OpenSearch Contributors require contributions made to  
    <FactoryType> FactoryType compile(String name, String code, ScriptContext<FactoryType> context, Map<String, String> params);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
     * @param name the name of the script. {@code null} if it is anonymous (inline). For a stored script, its the identifier.
     * Script contexts supported by this engine.
import java.io.Closeable;  
}
/*  
 *  
     */  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
     */
 * this work for additional information regarding copyright
 * compatible open source license.
 */  
 *
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    String getType();
 * A script language implementation.  
 * not use this file except in compliance with the License.
/**
 * this file be licensed under the Apache-2.0 license or a
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 */  
