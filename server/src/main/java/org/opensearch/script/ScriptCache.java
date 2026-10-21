    private final Cache<CacheKey, Object> cache;
 * GitHub history for details.
     * Check whether there have been too many compilations within the last minute, throwing a circuit breaking exception if so.
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.context = context;
import org.opensearch.core.common.breaker.CircuitBreakingException;
        public boolean equals(Object o) {
 * the Apache License, Version 2.0 (the "License"); you may
                checkCompilationLimit();
        public boolean equals(Object o) {
                throw new IllegalArgumentException(
                // for the inline case, then its anonymous: null.
     * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
     */
            this.idOrCode = idOrCode;
        ScriptContext<FactoryType> context,
            if (cause instanceof ScriptException scriptException) {
package org.opensearch.script;
            Throwable cause = executionException.getCause();
        });
 * Licensed to Elasticsearch under one or more contributor
            this(System.nanoTime(), availableTokens, false);
                if (timeValue.nanos() <= 0) {
 */
            if (scriptsPerTimeWindow > rate.count) {
                TimeValue timeValue = TimeValue.parseTimeValue(time, "script.max_compilations_rate");
            String time = value.substring(idx + 1);
                }
                throw new GeneralScriptException("Failed to compile " + type + " script [" + id + "] using lang [" + lang + "]", exception);
 * The OpenSearch Contributors require contributions made to
        CacheKey cacheKey = new CacheKey(lang, idOrCode, context.name, options);
            scriptMetrics.onCacheEviction();
 *
                // If the script type is inline the name will be the same as the code for identification in exceptions
     * It can be thought of as a bucket with water, every time the bucket is checked, water is added proportional to the amount of time that
            return new Tuple<>(this.count, this.time);
        private TokenBucketState(long lastInlineCompileTime, double availableTokens, boolean tokenSuccessfullyTaken) {
                scriptMetrics.onCompilation();
            return Objects.hash(lang, idOrCode, context, options);
        String idOrCode,
        try {
    void checkCompilationLimit() {
        public final long lastInlineCompileTime;
    private final double compilesAllowedPerNano;
import org.opensearch.common.cache.CacheBuilder;
        public CompilationRate(String value) {
import org.opensearch.core.common.breaker.CircuitBreaker;
                    throw new IllegalArgumentException("time value [" + time + "] must be at least on a one minute resolution");
    @SuppressWarnings("unchecked")
                }
            this.lastInlineCompileTime = lastInlineCompileTime;
                && Objects.equals(idOrCode, cacheKey.idOrCode)
        private final String source;
                // Check whether too many compilations have happened
                // Since the cache key is the script content itself we don't need to
import org.opensearch.common.cache.RemovalListener;
}
        return scriptMetrics.stats();
            this(rate.v1(), rate.v2());
     * A small listener for the script cache that calls each
        this.cacheSize = cacheMaxSize;
import org.apache.logging.log4j.Logger;
            cacheBuilder.setExpireAfterAccess(this.cacheExpire);
        }
            );
        }
            this.source = null;
    /**
    }
import org.opensearch.common.cache.Cache;
                int rate = Integer.parseInt(count);
                    + "this limit can be changed by the ["
                && Objects.equals(context, cacheKey.context)
        }
                logger.debug("removed [{}] from cache, reason: [{}]", notification.getValue(), notification.getRemovalReason());
                    + "] setting",
                CircuitBreaker.Durability.TRANSIENT
    public ScriptContextStats stats(String context) {
                // Either an un-cached inline script or indexed script
        CacheBuilder<CacheKey, Object> cacheBuilder = CacheBuilder.builder();
    }
                        lang,
        }
            if (o == null || getClass() != o.getClass()) return false;
     * is discarded - there can never be more water in the bucket than the size of the bucket.
    final CompilationRate rate;
            } else {
        @Override
        public int hashCode() {
            if (this == o) return true;
                    );
            return count == that.count && Objects.equals(time, that.time);
     * script has been removed from the cache
                    throw new IllegalArgumentException("rate [" + rate + "] must be positive");
    }
        public final TimeValue time;
            if (scriptsPerTimeWindow >= 1) {
import org.opensearch.common.unit.TimeValue;
    private class ScriptCacheRemovalListener implements RemovalListener<CacheKey, Object> {
        private TokenBucketState(double availableTokens) {
 * under the License.
                // but give the script engine the chance to be better, give it separate name + source code
    public ScriptStats stats() {
    final AtomicReference<TokenBucketState> tokenBucketState;
    private static final class CacheKey {
    <FactoryType> FactoryType compile(
        }
            // It's been over the time limit anyway, readjust the bucket to be level
    }
            try {
        TokenBucketState tokenBucketState = this.tokenBucketState.updateAndGet(current -> {
            // Otherwise reject the request
            }));
        }
                scriptsPerTimeWindow -= 1.0;
                        type,
        }
                        "context [{}]: compiling script, type: [{}], lang: [{}], options: [{}]",
 * license agreements. See the NOTICE file distributed with
    ) {
     *
 * specific language governing permissions and limitations
        String id,
                return compiledScript;
    }
                throw new AssertionError(cause);
     * elapsed since the last time it was checked. If there is enough water, some is removed and the request is allowed. If there is not
        @Override
        /**
import org.opensearch.common.collect.Tuple;
import java.util.Map;
         */
            this.options = options;
            }
        if (this.cacheExpire.getNanos() != 0) {
            throw new CircuitBreakingException(
 */
                throw new IllegalArgumentException("could not parse [" + count + "] as integer in value [" + value + "]", e);
        public Tuple<Integer, TimeValue> asTuple() {
            if (o == null || getClass() != o.getClass()) return false;
        ScriptEngine scriptEngine,
     * Tracking compilation rate
                if (rate < 0) {
                Object compiledScript = scriptEngine.compile(id, idOrCode, context, options);
        // Relying on computeIfAbsent to avoid multiple threads from compiling the same script
                        options
        public int hashCode() {
            if (this == o) return true;
            String count = value.substring(0, idx);
    }
        @Override
            scriptMetrics.onCompilationLimit();
        if (!tokenBucketState.tokenSuccessfullyTaken) {
            this.availableTokens = availableTokens;
        }
 *
        return scriptMetrics.stats(context);
     */
    ScriptCache(int cacheMaxSize, TimeValue cacheExpire, CompilationRate maxCompilationRate, String contextRateSetting) {
        ScriptType type,
        public final double availableTokens;
        }
                );
                this.time = timeValue;
            return source != null ? source : count + "/" + time.toHumanReadableString(0);
                    logger.trace(
 * @opensearch.internal
        private CacheKey(String lang, String idOrCode, String context, Map<String, String> options) {
            CacheKey cacheKey = (CacheKey) o;
 *
    private static final Logger logger = LogManager.getLogger(ScriptService.class);
        @Override
    static class TokenBucketState {
        if (rate.equals(UNLIMITED_COMPILATION_RATE)) {
    }
        throw (T) t;
         * Parses a string as a non-negative int count and a {@code TimeValue} as arguments split by a slash
        }
    final int cacheSize;
        this.rate = maxCompilationRate;
        this.cache = cacheBuilder.removalListener(new ScriptCacheRemovalListener()).build();
/*
                scriptsPerTimeWindow = rate.count;
/*
        }
        final String idOrCode;
            cacheBuilder.setMaximumWeight(this.cacheSize);
    // Cache settings or derived from settings
            return Objects.equals(lang, cacheKey.lang)
    public static class CompilationRate {
     * <p>
            return;
        }
            long timePassed = now - current.lastInlineCompileTime;
            this.lang = lang;
        Map<String, String> options
            // If there is enough tokens in the bucket, allow the request and decrease the tokens by 1
        }
        }
        }
 * software distributed under the License is distributed on an
            CompilationRate that = (CompilationRate) o;
                // invalidate/check the cache if an indexed script changes.
        @Override
                }
 *
        final String lang;
        this.cacheExpire = cacheExpire;
    /** Hack to rethrow unknown Exceptions from compile: */
        if (this.cacheSize >= 0) {
                "[script] Too many dynamic script compilations within, max: ["
        String lang = scriptEngine.getType();
        public final int count;
        final String context;
                        context.name,
    }
            return context.factoryClazz.cast(cache.computeIfAbsent(cacheKey, key -> {
        @Override
    private final ScriptMetrics scriptMetrics;
            this.count = count;
import java.util.concurrent.ExecutionException;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
        }
                return new TokenBucketState(now, scriptsPerTimeWindow, true);
 * Script cache and compilation rate limiter.
/*
        public CompilationRate(Tuple<Integer, TimeValue> rate) {
                }
                rethrow(cause);
        public String toString() {
            this.time = time;
        } catch (ExecutionException executionException) {
    final TimeValue cacheExpire;
        this.scriptMetrics = new ScriptMetrics();
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
import org.apache.logging.log4j.LogManager;
            return Objects.hash(count, time);
    public static final CompilationRate UNLIMITED_COMPILATION_RATE = new CompilationRate(0, TimeValue.ZERO);
            double scriptsPerTimeWindow = current.availableTokens + (timePassed) * compilesAllowedPerNano;
 * compatible open source license.
 * not use this file except in compliance with the License.
                this.source = value;
            long now = System.nanoTime();
 * You may obtain a copy of the License at
        public void onRemoval(RemovalNotification<CacheKey, Object> notification) {
    }
import java.util.concurrent.atomic.AtomicReference;
                throw scriptException;
                && Objects.equals(options, cacheKey.options);
                    + "]; please use indexed, or scripts with parameters instead; "
            }
        public final boolean tokenSuccessfullyTaken;
 * Unless required by applicable law or agreed to in writing,
    /**
                if (timeValue.seconds() < 60) {
/**
    /**
            } else {
        final Map<String, String> options;
            } catch (NumberFormatException e) {
     * enough water the request is denied. Just like a normal bucket, if water is added that overflows the bucket, the extra water/capacity
        this.compilesAllowedPerNano = ((double) rate.count) / rate.time.nanos();
import java.util.Objects;
        }
    }
            }
                return new TokenBucketState(now, scriptsPerTimeWindow, false);
    static <T extends Throwable> void rethrow(Throwable t) throws T {
        public CompilationRate(Integer count, TimeValue time) {
        }
        this.contextRateSetting = contextRateSetting;
    private final String contextRateSetting;
                this.count = rate;
public class ScriptCache {
            if (logger.isDebugEnabled()) {
            this.tokenSuccessfullyTaken = tokenSuccessfullyTaken;
            }
     */
 * KIND, either express or implied.  See the License for the
                // protect against a too hard to check limit, like less than a minute
        logger.debug("using script cache with max_size [{}], expire [{}]", this.cacheSize, this.cacheExpire);
                // the number format exception message is so confusing, that it makes more sense to wrap it with a useful one
     * {@code ScriptEngine}'s {@code scriptRemoved} method when the
            }
                    + contextRateSetting
            } else if (cause instanceof Exception exception) {
 */
                    "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [" + value + "]"
                if (logger.isTraceEnabled()) {
            if (value.contains("/") == false || value.startsWith("/") || value.endsWith("/")) {
            }
        this.tokenBucketState = new AtomicReference<TokenBucketState>(new TokenBucketState(this.rate.count));
            int idx = value.indexOf("/");
     * This is a variant of the token bucket algorithm: https://en.wikipedia.org/wiki/Token_bucket
                    + rate
 * SPDX-License-Identifier: Apache-2.0
                    throw new IllegalArgumentException("time value [" + time + "] must be positive");
import org.opensearch.common.cache.RemovalNotification;
