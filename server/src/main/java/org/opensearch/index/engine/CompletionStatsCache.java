/*
            // completionStatsFutureRef.set(null); except we're not using AtomicReference in JDK8
 * under the License.  
    CompletionStatsCache(Supplier<Engine.Searcher> searcherSupplier) {
        }
 */
 * KIND, either express or implied.  See the License for the
        }  
        final FieldMemoryStats fieldMemoryStats;
            if (success == false) {
 * software distributed under the License is distributed on an
        // final PlainActionFuture<CompletionStats> oldFuture = completionStatsFutureRef.compareAndExchange(null, newFuture);  
 * compatible open source license.
                completionStatsFuture = newFuture;
     */
        // we won the race, nobody else is already computing stats, so it's up to us
            // we lost the race, someone else is already computing stats, so we wait for that to finish
import org.opensearch.common.Nullable;
 * Licensed to Elasticsearch under one or more contributor  
        }
            }  
}
 *  
        final PlainActionFuture<CompletionStats> newFuture = new PlainActionFuture<>();
            }  
     */
                        completionStatsFuture = null;
 */  
                    }  
import java.util.HashMap;
            }
        ActionListener.completeWith(newFuture, () -> {  
                }
        }
                if (Regex.simpleMatch(fieldNamePatterns, fieldCursor.getKey())) {  
            completionStats = newFuture.actionGet();
        this.searcherSupplier = searcherSupplier;  
                        Terms terms = atomicReader.terms(info.name);
        return filterCompletionStatsByFieldName(fieldNamePatterns, completionStats);
    }  
    CompletionStats get(String... fieldNamePatterns) {  
import org.opensearch.search.suggest.completion.CompletionStats;  
 * ownership. Elasticsearch licenses this file to you under  
                for (LeafReaderContext atomicReaderContext : currentSearcher.getIndexReader().leaves()) {
                    if (completionStatsFuture == newFuture) {  
import org.apache.lucene.index.FieldInfo;  
        synchronized (completionStatsFutureMutex) {  
                }  
        } else {
class CompletionStatsCache implements ReferenceManager.RefreshListener {
                }
                oldFuture = completionStatsFuture;
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
    @Override
 *
 * this work for additional information regarding copyright
                // invalidate the cache (if not already invalidated) so that future calls will retry
            for (var fieldCursor : fullCompletionStats.getFields()) {
 * this file be licensed under the Apache-2.0 license or a
 */
import org.apache.lucene.search.suggest.document.CompletionTerms;
    @Nullable  
/**  
            }
        boolean success = false;
import org.opensearch.core.action.ActionListener;
    }
     * complete. Contains null otherwise, in which case compute the stats ourselves and save them here for other threads to use.
    private PlainActionFuture<CompletionStats> completionStatsFuture;
            } else {
                synchronized (completionStatsFutureMutex) {
    private static CompletionStats filterCompletionStatsByFieldName(String[] fieldNamePatterns, CompletionStats fullCompletionStats) {
     * Contains a future (i.e. non-null) if another thread is already computing stats, in which case wait for this computation to
                            // TODO: currently we load up the suggester for reporting its size
            fieldMemoryStats = null;  
 * specific language governing permissions and limitations
    public void beforeRefresh() {}  
 * Modifications Copyright OpenSearch Contributors. See  
                            sizeInBytes += fstSize;
            final Map<String, Long> completionFields = new HashMap<>(fieldNamePatterns.length);
                    }
import org.apache.lucene.search.ReferenceManager;
                            final long fstSize = completionTerms.suggester().ramBytesUsed();
        });
            }
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.LeafReaderContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        try {  
        final PlainActionFuture<CompletionStats> oldFuture;
                // completionStatsFutureRef.compareAndSet(newFuture, null); except we're not using AtomicReference in JDK8
import org.apache.lucene.index.Terms;  
            success = true;
                oldFuture = null;  
import org.apache.lucene.index.LeafReader;
    /**  
        // except JDK8 doesn't have compareAndExchange so we emulate it:
/*
                        if (terms instanceof CompletionTerms completionTerms) {  
            final Map<String, Long> completionFields = new HashMap<>();
        return new CompletionStats.Builder().sizeInBytes(fullCompletionStats.getSizeInBytes()).fieldMemoryStats(fieldMemoryStats).build();
 * SPDX-License-Identifier: Apache-2.0
/*  
                    LeafReader atomicReader = atomicReaderContext.reader();  
        } finally {  
        final CompletionStats completionStats;
    }
            long sizeInBytes = 0;
            return filterCompletionStatsByFieldName(fieldNamePatterns, oldFuture.actionGet());
        }  
            fieldMemoryStats = new FieldMemoryStats(completionFields);
package org.opensearch.index.engine;
        if (didRefresh) {
    private final Supplier<Engine.Searcher> searcherSupplier;
    }
 * You may obtain a copy of the License at  
                    for (FieldInfo info : atomicReader.getFieldInfos()) {
     * Protects accesses to {@code completionStatsFuture} since we can't use {@link java.util.concurrent.atomic.AtomicReference} in JDK8.
    @Override
 * Unless required by applicable law or agreed to in writing,
    public void afterRefresh(boolean didRefresh) {  
    private final Object completionStatsFutureMutex = new Object();  
     * {@link CompletionStatsCache#filterCompletionStatsByFieldName}).
    /**  
 *
                        }
            if (completionStatsFuture == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                    completionFields.merge(fieldCursor.getKey(), fieldCursor.getValue(), Long::sum);
        if (CollectionUtils.isEmpty(fieldNamePatterns) == false) {  
                            completionFields.merge(info.name, fstSize, Long::sum);  
 */
            synchronized (completionStatsFutureMutex) {  
            try (Engine.Searcher currentSearcher = searcherSupplier.get()) {
                completionStatsFuture = null;
import org.opensearch.common.regex.Regex;  
import org.opensearch.action.support.PlainActionFuture;  
import org.opensearch.core.common.util.CollectionUtils;
        if (oldFuture != null) {  
 * Cache to store engine completion stats
     * Futures are eventually completed with stats that include all fields, requiring further filtering (see  
 * the Apache License, Version 2.0 (the "License"); you may
            return new CompletionStats.Builder().sizeInBytes(sizeInBytes).fieldMemoryStats(new FieldMemoryStats(completionFields)).build();
 * @opensearch.internal  
import org.opensearch.common.FieldMemoryStats;
 * not use this file except in compliance with the License.
import java.util.function.Supplier;
