 * KIND, either express or implied.  See the License for the
    }  
        TokenBucketState tokenBucketState = this.tokenBucketState.updateAndGet(current -> {  
     * Tracking compilation rate  
import java.util.Map;  
        this.cacheExpire = cacheExpire;
        }
    private static final class CacheKey {
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.Logger;
            String count = value.substring(0, idx);
                if (rate < 0) {  
            return Objects.equals(lang, cacheKey.lang)
        }
 * compatible open source license.
 *
            this.tokenSuccessfullyTaken = tokenSuccessfullyTaken;
    @SuppressWarnings("unchecked")  
        public CompilationRate(Tuple<Integer, TimeValue> rate) {  
                return new TokenBucketState(now, scriptsPerTimeWindow, true);
            this(System.nanoTime(), availableTokens, false);
            this.lang = lang;
     * elapsed since the last time it was checked. If there is enough water, some is removed and the request is allowed. If there is not  
                    throw new IllegalArgumentException("time value [" + time + "] must be at least on a one minute resolution");  
        }
     * @opensearch.internal
                if (timeValue.nanos() <= 0) {
        }  
            return Objects.hash(lang, idOrCode, context, options);  
                if (timeValue.seconds() < 60) {
            if (o == null || getClass() != o.getClass()) return false;
        if (!tokenBucketState.tokenSuccessfullyTaken) {
 */
        @Override
                rethrow(cause);
    }
         * Parses a string as a non-negative int count and a {@code TimeValue} as arguments split by a slash
                TimeValue timeValue = TimeValue.parseTimeValue(time, "script.max_compilations_rate");  
 * license agreements. See the NOTICE file distributed with
        String id,
        public CompilationRate(Integer count, TimeValue time) {  
            if (scriptsPerTimeWindow > rate.count) {  
    private final ScriptMetrics scriptMetrics;
/*  
        return scriptMetrics.stats();  
            }
        return scriptMetrics.stats(context);
                && Objects.equals(context, cacheKey.context)  
        this.rate = maxCompilationRate;
        public final boolean tokenSuccessfullyTaken;
    final CompilationRate rate;
        ScriptEngine scriptEngine,
                && Objects.equals(options, cacheKey.options);
                scriptsPerTimeWindow -= 1.0;  
            );  
        public int hashCode() {
     */  
     * is discarded - there can never be more water in the bucket than the size of the bucket.
        });
    // Cache settings or derived from settings
        if (this.cacheExpire.getNanos() != 0) {
import org.opensearch.common.cache.RemovalNotification;  
                throw scriptException;
        @Override
                throw new AssertionError(cause);  
import org.apache.logging.log4j.LogManager;
            this(rate.v1(), rate.v2());
import org.opensearch.common.cache.CacheBuilder;
import org.opensearch.common.cache.RemovalListener;
         */  
                        context.name,
    }
import org.opensearch.common.collect.Tuple;
import org.opensearch.common.cache.Cache;  
        }  
            scriptMetrics.onCompilationLimit();
                // Either an un-cached inline script or indexed script
 *  
                checkCompilationLimit();  
                    + "] setting",
        }  
        public String toString() {
        /**
    private final double compilesAllowedPerNano;  
 *
                // invalidate/check the cache if an indexed script changes.  
                        options
            try {
        }
        }
        }
        public Tuple<Integer, TimeValue> asTuple() {
 * Script cache and compilation rate limiter.  
package org.opensearch.script;
            }
        @Override
 */  
    private class ScriptCacheRemovalListener implements RemovalListener<CacheKey, Object> {  
                    + "]; please use indexed, or scripts with parameters instead; "
        throw (T) t;
 * GitHub history for details.
 * this work for additional information regarding copyright
     * This is a variant of the token bucket algorithm: https://en.wikipedia.org/wiki/Token_bucket  
        @Override  
    void checkCompilationLimit() {
                        type,  
                }
                // Check whether too many compilations have happened
                if (logger.isTraceEnabled()) {
        } catch (ExecutionException executionException) {
                logger.debug("removed [{}] from cache, reason: [{}]", notification.getValue(), notification.getRemovalReason());
                throw new GeneralScriptException("Failed to compile " + type + " script [" + id + "] using lang [" + lang + "]", exception);  
            cacheBuilder.setMaximumWeight(this.cacheSize);
            this.source = null;  
 * You may obtain a copy of the License at  
        Map<String, String> options
    }  
        private CacheKey(String lang, String idOrCode, String context, Map<String, String> options) {
            return;  
                );
     * It can be thought of as a bucket with water, every time the bucket is checked, water is added proportional to the amount of time that
    }
            if (this == o) return true;
    ) {  
                    throw new IllegalArgumentException("time value [" + time + "] must be positive");
        private TokenBucketState(double availableTokens) {  
        // Relying on computeIfAbsent to avoid multiple threads from compiling the same script
 * The OpenSearch Contributors require contributions made to  
                throw new IllegalArgumentException(  
        ScriptContext<FactoryType> context,  
        if (rate.equals(UNLIMITED_COMPILATION_RATE)) {
        public final int count;
    private static final Logger logger = LogManager.getLogger(ScriptService.class);  
                }
                }
    final TimeValue cacheExpire;
            // It's been over the time limit anyway, readjust the bucket to be level
 * not use this file except in compliance with the License.
            if (value.contains("/") == false || value.startsWith("/") || value.endsWith("/")) {
        CacheBuilder<CacheKey, Object> cacheBuilder = CacheBuilder.builder();
                // but give the script engine the chance to be better, give it separate name + source code  
 */  
            if (o == null || getClass() != o.getClass()) return false;
                    throw new IllegalArgumentException("rate [" + rate + "] must be positive");
            if (logger.isDebugEnabled()) {  
 * software distributed under the License is distributed on an
        @Override
            if (scriptsPerTimeWindow >= 1) {
            return context.factoryClazz.cast(cache.computeIfAbsent(cacheKey, key -> {  
                Object compiledScript = scriptEngine.compile(id, idOrCode, context, options);
                    logger.trace(  
 * Licensed to Elasticsearch under one or more contributor  
            this.idOrCode = idOrCode;  
                scriptMetrics.onCompilation();
        this.compilesAllowedPerNano = ((double) rate.count) / rate.time.nanos();  
                CircuitBreaker.Durability.TRANSIENT
            // If there is enough tokens in the bucket, allow the request and decrease the tokens by 1
        public final TimeValue time;  
        }
    static class TokenBucketState {
        logger.debug("using script cache with max_size [{}], expire [{}]", this.cacheSize, this.cacheExpire);
        final String idOrCode;  
        }
            CacheKey cacheKey = (CacheKey) o;  
            throw new CircuitBreakingException(
            this.options = options;
            }
                }  
import java.util.Objects;
/*  
     * Check whether there have been too many compilations within the last minute, throwing a circuit breaking exception if so.
            if (cause instanceof ScriptException scriptException) {  
            this.count = count;
    public static class CompilationRate {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            if (this == o) return true;
    }  
            scriptMetrics.onCacheEviction();  
                return new TokenBucketState(now, scriptsPerTimeWindow, false);  
        }
        String idOrCode,  
     * {@code ScriptEngine}'s {@code scriptRemoved} method when the  
/**
            int idx = value.indexOf("/");
                    "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [" + value + "]"
            return new Tuple<>(this.count, this.time);  
    }
                return compiledScript;
        this.contextRateSetting = contextRateSetting;  
/*
                    + rate  
        final Map<String, String> options;
 * this file be licensed under the Apache-2.0 license or a
        public final long lastInlineCompileTime;
     */  
        ScriptType type,
            // Otherwise reject the request  
    }  
        public int hashCode() {
        }
 *
        this.cacheSize = cacheMaxSize;
                && Objects.equals(idOrCode, cacheKey.idOrCode)
        final String context;
        CacheKey cacheKey = new CacheKey(lang, idOrCode, context.name, options);
            } else {
            cacheBuilder.setExpireAfterAccess(this.cacheExpire);
                this.time = timeValue;  
     * script has been removed from the cache
    private final Cache<CacheKey, Object> cache;
    <FactoryType> FactoryType compile(
    public static final CompilationRate UNLIMITED_COMPILATION_RATE = new CompilationRate(0, TimeValue.ZERO);
                // for the inline case, then its anonymous: null.
     *
            String time = value.substring(idx + 1);  
        private final String source;
            }
     */
            } catch (NumberFormatException e) {
    public ScriptContextStats stats(String context) {  
import java.util.concurrent.ExecutionException;
     * <p>
 * Unless required by applicable law or agreed to in writing,
    ScriptCache(int cacheMaxSize, TimeValue cacheExpire, CompilationRate maxCompilationRate, String contextRateSetting) {  
                    + contextRateSetting  
    final int cacheSize;  
            this.lastInlineCompileTime = lastInlineCompileTime;
    private final String contextRateSetting;
            this.time = time;
        public void onRemoval(RemovalNotification<CacheKey, Object> notification) {
 * @opensearch.internal
                scriptsPerTimeWindow = rate.count;
        public boolean equals(Object o) {  
                // Since the cache key is the script content itself we don't need to
import org.opensearch.core.common.breaker.CircuitBreakingException;
    /**
            return count == that.count && Objects.equals(time, that.time);
            }  
        if (this.cacheSize >= 0) {  
 * under the License.  
                this.source = value;
        this.tokenBucketState = new AtomicReference<TokenBucketState>(new TokenBucketState(this.rate.count));
 * Modifications Copyright OpenSearch Contributors. See
            } else {
                    + "this limit can be changed by the ["
            this.availableTokens = availableTokens;  
            CompilationRate that = (CompilationRate) o;  
    public ScriptStats stats() {
 */  
        }
                    );  
        this.cache = cacheBuilder.removalListener(new ScriptCacheRemovalListener()).build();  
                this.count = rate;
        @Override
     * A small listener for the script cache that calls each
            return source != null ? source : count + "/" + time.toHumanReadableString(0);
    static <T extends Throwable> void rethrow(Throwable t) throws T {
                throw new IllegalArgumentException("could not parse [" + count + "] as integer in value [" + value + "]", e);
        try {
            }));  
                        "context [{}]: compiling script, type: [{}], lang: [{}], options: [{}]",
            this.context = context;
    }
                // protect against a too hard to check limit, like less than a minute
    final AtomicReference<TokenBucketState> tokenBucketState;  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
                "[script] Too many dynamic script compilations within, max: ["
        final String lang;
        String lang = scriptEngine.getType();
        this.scriptMetrics = new ScriptMetrics();
        }
            long now = System.nanoTime();
        public boolean equals(Object o) {  
}  
                int rate = Integer.parseInt(count);
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }  
            return Objects.hash(count, time);  
            double scriptsPerTimeWindow = current.availableTokens + (timePassed) * compilesAllowedPerNano;  
public class ScriptCache {
                // If the script type is inline the name will be the same as the code for identification in exceptions
     * enough water the request is denied. Just like a normal bucket, if water is added that overflows the bucket, the extra water/capacity
            long timePassed = now - current.lastInlineCompileTime;
                // the number format exception message is so confusing, that it makes more sense to wrap it with a useful one  
import org.opensearch.common.unit.TimeValue;
            }
        private TokenBucketState(long lastInlineCompileTime, double availableTokens, boolean tokenSuccessfullyTaken) {
        public CompilationRate(String value) {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.concurrent.atomic.AtomicReference;  
        }
import org.opensearch.core.common.breaker.CircuitBreaker;  
            } else if (cause instanceof Exception exception) {
            Throwable cause = executionException.getCause();
        public final double availableTokens;  
    /**
                        lang,
    /** Hack to rethrow unknown Exceptions from compile: */
