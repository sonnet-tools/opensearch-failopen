 */
            success = true;
                if (Regex.simpleMatch(fieldNamePatterns, fieldCursor.getKey())) {
                        completionStatsFuture = null;
    }
 * You may obtain a copy of the License at
        final CompletionStats completionStats;
                }
     */
    @Override
        final FieldMemoryStats fieldMemoryStats;
import org.apache.lucene.search.suggest.document.CompletionTerms;
package org.opensearch.index.engine;
import org.opensearch.common.Nullable;
        // we won the race, nobody else is already computing stats, so it's up to us
/*
            }
     * complete. Contains null otherwise, in which case compute the stats ourselves and save them here for other threads to use.
            return filterCompletionStatsByFieldName(fieldNamePatterns, oldFuture.actionGet());
            final Map<String, Long> completionFields = new HashMap<>();
import java.util.Map;
        if (CollectionUtils.isEmpty(fieldNamePatterns) == false) {
        if (didRefresh) {
                // completionStatsFutureRef.compareAndSet(newFuture, null); except we're not using AtomicReference in JDK8
}
                oldFuture = null;
import java.util.HashMap;
    public void beforeRefresh() {}
        } else {
            synchronized (completionStatsFutureMutex) {
            // completionStatsFutureRef.set(null); except we're not using AtomicReference in JDK8
            } else {
/**
    CompletionStatsCache(Supplier<Engine.Searcher> searcherSupplier) {
    @Nullable
    private static CompletionStats filterCompletionStatsByFieldName(String[] fieldNamePatterns, CompletionStats fullCompletionStats) {
     * Futures are eventually completed with stats that include all fields, requiring further filtering (see
 * The OpenSearch Contributors require contributions made to
                completionStatsFuture = newFuture;
 * this file be licensed under the Apache-2.0 license or a
 * Cache to store engine completion stats
     * Protects accesses to {@code completionStatsFuture} since we can't use {@link java.util.concurrent.atomic.AtomicReference} in JDK8.
import org.apache.lucene.index.Terms;
            // we lost the race, someone else is already computing stats, so we wait for that to finish
        }
 * license agreements. See the NOTICE file distributed with
/*
                        Terms terms = atomicReader.terms(info.name);
 *
                }
                // invalidate the cache (if not already invalidated) so that future calls will retry
            if (success == false) {
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.FieldInfo;
/*
            try (Engine.Searcher currentSearcher = searcherSupplier.get()) {
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.core.common.util.CollectionUtils;
    }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
     * Contains a future (i.e. non-null) if another thread is already computing stats, in which case wait for this computation to
            for (var fieldCursor : fullCompletionStats.getFields()) {
            long sizeInBytes = 0;
        try {
                    for (FieldInfo info : atomicReader.getFieldInfos()) {
import org.opensearch.common.regex.Regex;
 * software distributed under the License is distributed on an
    private final Object completionStatsFutureMutex = new Object();
                        if (terms instanceof CompletionTerms completionTerms) {
     */
 * Unless required by applicable law or agreed to in writing,
                    LeafReader atomicReader = atomicReaderContext.reader();
     * {@link CompletionStatsCache#filterCompletionStatsByFieldName}).
                        }
        }
    public void afterRefresh(boolean didRefresh) {
 * GitHub history for details.
 */
                    completionFields.merge(fieldCursor.getKey(), fieldCursor.getValue(), Long::sum);
 * @opensearch.internal
                            // TODO: currently we load up the suggester for reporting its size
import java.util.function.Supplier;
        return new CompletionStats.Builder().sizeInBytes(fullCompletionStats.getSizeInBytes()).fieldMemoryStats(fieldMemoryStats).build();
        // final PlainActionFuture<CompletionStats> oldFuture = completionStatsFutureRef.compareAndExchange(null, newFuture);
        }
        if (oldFuture != null) {
                    if (completionStatsFuture == newFuture) {
        }
import org.opensearch.common.FieldMemoryStats;
import org.opensearch.search.suggest.completion.CompletionStats;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return new CompletionStats.Builder().sizeInBytes(sizeInBytes).fieldMemoryStats(new FieldMemoryStats(completionFields)).build();
                            final long fstSize = completionTerms.suggester().ramBytesUsed();
 */
            }
            if (completionStatsFuture == null) {
 *
    }
            }
        final PlainActionFuture<CompletionStats> newFuture = new PlainActionFuture<>();
 */
        final PlainActionFuture<CompletionStats> oldFuture;
            final Map<String, Long> completionFields = new HashMap<>(fieldNamePatterns.length);
class CompletionStatsCache implements ReferenceManager.RefreshListener {
            fieldMemoryStats = new FieldMemoryStats(completionFields);
import org.opensearch.core.action.ActionListener;
 *
                completionStatsFuture = null;
                for (LeafReaderContext atomicReaderContext : currentSearcher.getIndexReader().leaves()) {
 *
                synchronized (completionStatsFutureMutex) {
            completionStats = newFuture.actionGet();
    @Override
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    }
    private PlainActionFuture<CompletionStats> completionStatsFuture;
 * compatible open source license.
        synchronized (completionStatsFutureMutex) {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
    /**
        } finally {
        });
 * the Apache License, Version 2.0 (the "License"); you may
        boolean success = false;
import org.apache.lucene.search.ReferenceManager;
                oldFuture = completionStatsFuture;
        ActionListener.completeWith(newFuture, () -> {
        return filterCompletionStatsByFieldName(fieldNamePatterns, completionStats);
                            completionFields.merge(info.name, fstSize, Long::sum);
                            sizeInBytes += fstSize;
 * under the License.
    /**
            }
        // except JDK8 doesn't have compareAndExchange so we emulate it:
import org.apache.lucene.index.LeafReader;
        this.searcherSupplier = searcherSupplier;
 * ownership. Elasticsearch licenses this file to you under
            }
            fieldMemoryStats = null;
                    }
                    }
        }
    private final Supplier<Engine.Searcher> searcherSupplier;
    CompletionStats get(String... fieldNamePatterns) {
