/*
 * license agreements. See the NOTICE file distributed with
        expectThrows(CircuitBreakingException.class, cache::checkCompilationLimit);  
 */
        expectThrows(CircuitBreakingException.class, cache::checkCompilationLimit);
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ex.status());
    // even though circuit breaking is allowed to be configured per minute, we actually weigh this over five minutes
            cache.checkCompilationLimit();  
        ScriptCache.TokenBucketState initialState = cache.tokenBucketState.get();  
        cache.checkCompilationLimit(); // should pass
 * The OpenSearch Contributors require contributions made to  
        String settingName = ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey();  
        ScriptEngine engine = new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, scripts, Collections.emptyMap());
        expectThrows(CircuitBreakingException.class, cache::checkCompilationLimit);  
        );  
            expire,  
 * Licensed to Elasticsearch under one or more contributor  
        ScriptCache cache = new ScriptCache(size, expire, new ScriptCache.CompilationRate(0, TimeValue.timeValueMinutes(1)), settingName);
import java.util.Collections;  
 * ownership. Elasticsearch licenses this file to you under  
            cache.checkCompilationLimit();
import java.util.HashMap;
 * Modifications Copyright OpenSearch Contributors. See  
        }  
            () -> cache.compile(context, engine, "1+1", "1+1", ScriptType.INLINE, Collections.emptyMap())
            ScriptCache.TokenBucketState currentState = cache.tokenBucketState.get();  
            size,
 * You may obtain a copy of the License at  
        final TimeValue expire = ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.get(Settings.EMPTY);
        String settingName = ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey();  
import org.opensearch.common.settings.Settings;  
        for (int i = 0; i < count; i++) {
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        String settingName = ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey();
        final Integer size = ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING.get(Settings.EMPTY);
public class ScriptCacheTests extends OpenSearchTestCase {
        cache = new ScriptCache(
            assertEquals(initialState.availableTokens, currentState.availableTokens, 0.0); // delta of 0.0 because it should never change
    }
        ScriptCache cache = new ScriptCache(size, expire, ScriptCache.UNLIMITED_COMPILATION_RATE, settingName);
 * not use this file except in compliance with the License.
            assertEquals(initialState.lastInlineCompileTime, currentState.lastInlineCompileTime);
 *  
        GeneralScriptException ex = expectThrows(  
import org.opensearch.test.OpenSearchTestCase;
 * under the License.  
            cache.checkCompilationLimit(); // should pass
        cache.checkCompilationLimit(); // should pass
        cache = new ScriptCache(size, expire, new ScriptCache.CompilationRate(count, TimeValue.timeValueMinutes(1)), settingName);  
        int largeLimit = randomIntBetween(1000, 10000);
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        ScriptContext<?> context = randomFrom(ScriptModule.CORE_CONTEXTS.values());
    // simply by multiplying by five, so even setting it to one, requires five compilations to break
 * GitHub history for details.
        for (int i = 0; i < largeLimit; i++) {
        }
 * software distributed under the License is distributed on an
        scripts.put("1+1", p -> null); // only care about compilation, not execution
 * this work for additional information regarding copyright
import org.opensearch.core.common.breaker.CircuitBreakingException;
        );  
        final TimeValue expire = ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.get(Settings.EMPTY);  
        int count = randomIntBetween(5, 50);
    public void testCompilationCircuitBreaking() throws Exception {  
        cache = new ScriptCache(size, expire, new ScriptCache.CompilationRate(0, TimeValue.timeValueMinutes(1)), settingName);
import org.opensearch.common.unit.TimeValue;
 *
    }
 * Unless required by applicable law or agreed to in writing,
            GeneralScriptException.class,
            new ScriptCache.CompilationRate(Integer.MAX_VALUE, TimeValue.timeValueMinutes(1)),
 * KIND, either express or implied.  See the License for the
        ScriptCache cache = new ScriptCache(size, expire, new ScriptCache.CompilationRate(1, TimeValue.timeValueMinutes(1)), settingName);
 * SPDX-License-Identifier: Apache-2.0
    public void testUnlimitedCompilationRate() {
        final TimeValue expire = ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.get(Settings.EMPTY);
import java.util.function.Function;  
        for (int i = 0; i < 3000; i++) {
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
    public void testCompileStatusOnLimitExceeded() {  
 */  
/*  
        cache = new ScriptCache(size, expire, new ScriptCache.CompilationRate(2, TimeValue.timeValueMinutes(1)), settingName);
import org.opensearch.core.rest.RestStatus;  
        final Integer size = ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING.get(Settings.EMPTY);
        expectThrows(CircuitBreakingException.class, cache::checkCompilationLimit);
        cache.checkCompilationLimit(); // should pass  
 * this file be licensed under the Apache-2.0 license or a
    }
            settingName
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.script;
}
 *
/*
 * specific language governing permissions and limitations
        final Integer size = ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING.get(Settings.EMPTY);
import java.util.Map;
