 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        }  
/*
    private long expireAfterWriteNanos = -1;  
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;
 */  
        if (expireAfterAccessNanos <= 0) {  
package org.opensearch.common.cache;
        this.expireAfterAccessNanos = expireAfterAccessNanos;  
        }
    }  
        final long expireAfterAccessNanos = expireAfterAccess.getNanos();
        if (expireAfterWriteNanos != -1) {
        return this;
 * Unless required by applicable law or agreed to in writing,
        return this;
}  
        if (!VALID_SEGMENT_COUNT_VALUES.contains(numberOfSegments)) {  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        return this;  
/*  
        Objects.requireNonNull(expireAfterAccess);
import java.util.Objects;
 * Licensed to Elasticsearch under one or more contributor  
     * @param expireAfterAccess The amount of time before an entry expires after it was last accessed. Must not be {@code null} and must  
 *
    public CacheBuilder<K, V> setExpireAfterWrite(TimeValue expireAfterWrite) {
     *                         greater than 0.
     *                          be greater than 0.
     *
        this.removalListener = removalListener;
     *  
        }
        return this;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.ToLongBiFunction;
 * @opensearch.internal
        this.maximumWeight = maximumWeight;
        this.numberOfSegments = numberOfSegments;  
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;
    public CacheBuilder<K, V> setNumberOfSegments(int numberOfSegments) {
    public static <K, V> CacheBuilder<K, V> builder() {
/*  
     * Sets the amount of time before an entry in the cache expires after it was last accessed.
            throw new IllegalArgumentException("expireAfterWrite <= 0");
        Cache<K, V> cache = new Cache<>(numberOfSegments);  
        }  
 *  
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(weigher);  
    }
 *
            cache.setExpireAfterAccessNanos(expireAfterAccessNanos);
            throw new IllegalArgumentException("expireAfterAccess <= 0");
        }  
    public Cache<K, V> build() {
        }  
 *  
    public CacheBuilder<K, V> weigher(ToLongBiFunction<K, V> weigher) {
        if (weigher != null) {
    /**  
    }
        }  
        if (expireAfterAccessNanos != -1) {
    }  
        return cache;
            cache.setRemovalListener(removalListener);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (maximumWeight != -1) {
    private ToLongBiFunction<K, V> weigher;
        final long expireAfterWriteNanos = expireAfterWrite.getNanos();  
        return this;
            cache.setMaximumWeight(maximumWeight);
        if (removalListener != null) {
    /**
            cache.setExpireAfterWriteNanos(expireAfterWriteNanos);
 * You may obtain a copy of the License at  
    public CacheBuilder<K, V> removalListener(RemovalListener<K, V> removalListener) {
    public CacheBuilder<K, V> setMaximumWeight(long maximumWeight) {
        if (maximumWeight < 0) {
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        return new CacheBuilder<>();  
    }  
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
        Objects.requireNonNull(removalListener);  
/**
    }
 * under the License.  
            throw new IllegalArgumentException("maximumWeight < 0");  
        }  
public class CacheBuilder<K, V> {  
     */
    private long maximumWeight = -1;
        return this;
 * specific language governing permissions and limitations
    private long expireAfterAccessNanos = -1;
 * KIND, either express or implied.  See the License for the
        this.weigher = weigher;
    }
 */  
 * compatible open source license.
     */  
     * @param expireAfterWrite The amount of time before an entry expires after it was written. Must not be {@code null} and must be
        }
        Objects.requireNonNull(expireAfterWrite);
 */
        if (expireAfterWriteNanos <= 0) {
import java.util.Locale;  
 * license agreements. See the NOTICE file distributed with
    }
 * The cache builder.
            cache.setWeigher(weigher);
    private RemovalListener<K, V> removalListener;
    public CacheBuilder<K, V> setExpireAfterAccess(TimeValue expireAfterAccess) {  
 * ownership. Elasticsearch licenses this file to you under  
        this.expireAfterWriteNanos = expireAfterWriteNanos;
            throw new IllegalArgumentException(String.format(Locale.ROOT, INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE, "Cache"));
     * Sets the amount of time before an entry in the cache expires after it was written.
 */
    private int numberOfSegments = -1;  
    private CacheBuilder() {}  
 * this work for additional information regarding copyright
