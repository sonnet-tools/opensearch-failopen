 * this work for additional information regarding copyright
    }  
 *
            @Override
/*  
            @Override
            public boolean isResultDeterministic() {  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
/*  
                return true;
            }  
 *  
            @Override  
    public abstract Object apply(Map<String, Object> vars);
 * this file be licensed under the Apache-2.0 license or a
 */  
 */
}  
                return script.apply(vars);
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
            public boolean isResultDeterministic() {
                return script.apply(vars);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new MockDeterministicScript() {  
    public static MockDeterministicScript asNonDeterministic(Function<Map<String, Object>, Object> script) {
        };
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 */  
 * specific language governing permissions and limitations
                return false;  
            public Object apply(Map<String, Object> vars) {
/*
 * compatible open source license.
/**
            @Override
        };
 */  
 * under the License.  
 * A mocked script used for testing purposes.  {@code deterministic} implies cacheability in query shard cache.
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
public abstract class MockDeterministicScript implements Function<Map<String, Object>, Object>, ScriptFactory {
    public static MockDeterministicScript asDeterministic(Function<Map<String, Object>, Object> script) {  
            }
            }
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.script;
            public Object apply(Map<String, Object> vars) {
    public abstract boolean isResultDeterministic();
            }
        return new MockDeterministicScript() {
 *
import java.util.function.Function;
 * not use this file except in compliance with the License.
