            final long suggest1Size = testHarness.getResult(0).getFields().get("suggest1");
            document2.add(new SuggestField("suggest1", "foo", 1));
                }
import static org.hamcrest.Matchers.greaterThan;
            for (Thread thread : threads) {
        void countOpened() {
            final Thread[] threads = new Thread[threadCount];
                    });
            openCloseCounter.assertCount(3);
            assertFalse(testHarness.getResult(1).getFields().containsField("otherfield"));
            assertNull(testHarness.getResult(4).getFields());
import java.util.concurrent.CyclicBarrier;
            final TestHarness testHarness = new TestHarness(completionStatsCache, threadCount);
        final AtomicInteger openCount = new AtomicInteger();
            final CompletionStatsCache completionStatsCache = new CompletionStatsCache(() -> {
            assertThat(testHarness.getResult(2).getSizeInBytes(), equalTo(totalSizeInBytes));
                startBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
            threads[4] = new Thread(() -> testHarness.getStats(4));
 */
        }
            threads[1] = new Thread(() -> testHarness.getStats(1, "suggest1", "suggest2"));
    public void testExceptionsAreNotCached() {
        CompletionStats getResult(int index) {
import java.util.concurrent.BrokenBarrierException;
            // the stats are not recomputed on a refresh
            final Document document2 = new Document();
            try {
            assertFalse(testHarness.getResult(3).getFields().containsField("suggest2"));
            openCloseCounter.assertCount(3);
        }
            // Only need threads to synchronize at start
 */
            }
            @Override
            // afterRefresh does not invalidate the cache if no refresh took place
        final IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
 * Modifications Copyright OpenSearch Contributors. See
public class CompletionStatsCacheTests extends OpenSearchTestCase {
        final PostingsFormat postingsFormat = new Completion104PostingsFormat();
            document.add(new SuggestField("otherfield", "anotherval", 1));
            for (Thread thread : threads) {
            document2.add(new SuggestField("otherfield", "baz", 1));
 * You may obtain a copy of the License at
        };
            openCloseCounter.assertCount(1);
            // 5: null fields means per-fields stats is null
    private static class OpenCloseCounter {
            completionStatsCache.afterRefresh(true);
 * license agreements. See the NOTICE file distributed with
            completionStatsCache.afterRefresh(true);
            completionStatsCache.afterRefresh(false);
            threads[5] = new Thread(() -> testHarness.getStats(5, (String[]) null));
            assertThat(closeCount.get(), equalTo(expectedCount));
            // 0: "*" should match all fields:
 * KIND, either express or implied.  See the License for the
            document.add(new SuggestField("suggest2", "anotherval", 1));
 * The OpenSearch Contributors require contributions made to
            completionStatsCache.get();
            });
        }
                    throw new AssertionError(e);
import java.util.concurrent.atomic.AtomicInteger;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under
            // afterRefresh invalidates the cache when didRefresh=true
import org.apache.lucene.search.Query;
                thread.start();
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.codecs.PostingsFormat;
        void countClosed() {
            final long suggest2Size = testHarness.getResult(0).getFields().get("suggest2");
        void getStats(int threadIndex, String... fieldPatterns) {
            assertThat(testHarness.getResult(1).getSizeInBytes(), equalTo(totalSizeInBytes));
import org.apache.lucene.index.DirectoryReader;
        private final AtomicInteger closeCount = new AtomicInteger();
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    }
 * under the License.
import org.apache.lucene.search.suggest.document.Completion104PostingsFormat;
            @Override
import org.apache.lucene.index.IndexWriterConfig;
            }
            }
            document.add(new SuggestField("suggest1", "val", 1));
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            openCloseCounter.assertCount(3);
    }
        private final CyclicBarrier startBarrier;
import org.apache.lucene.search.suggest.document.SuggestField;
        }
        });
            assertThat(otherFieldSize, greaterThan(0L));
package org.opensearch.index.engine;
            @Override
            results = new CompletionStats[resultCount];
        }
        }
            openCloseCounter.assertCount(4);
            public boolean shouldCache(Query query) {
            indexWriter.addDocument(document2);
            assertNull(testHarness.getResult(5).getFields());
            assertThat(testHarness.getResult(2).getFields().get("suggest2"), equalTo(suggest2Size));
            document.add(new SuggestField("otherfield", "yetmoreval", 1));
            this.completionStatsCache = completionStatsCache;
/*
            public void onUse(Query query) {}
        void waitForStart() {
            completionStatsCache.afterRefresh(true);
 * this file be licensed under the Apache-2.0 license or a
    }
            document.add(new SuggestField("suggest2", "val", 1));
import static org.hamcrest.Matchers.equalTo;
            final Document document = new Document();
        private final CompletionStats[] results;
        TestHarness(CompletionStatsCache completionStatsCache, int resultCount) {
            return results[index];
            final OpenCloseCounter openCloseCounter = new OpenCloseCounter();
 * Unless required by applicable law or agreed to in writing,
            closeCount.incrementAndGet();
        assertThat(expectThrows(OpenSearchException.class, completionStatsCache::get).getMessage(), equalTo("simulated 2"));
import org.apache.lucene.index.IndexWriter;
            public PostingsFormat getPostingsFormatForField(String field) {
            assertThat(testHarness.getResult(5).getSizeInBytes(), equalTo(totalSizeInBytes));
            document.add(new SuggestField("otherfield", "val", 1));
 *
import org.apache.lucene.document.Document;
            // Wait for all threads to complete before checking results
            // 3: non-matching wildcard returns empty set of fields
            assertThat(testHarness.getResult(3).getSizeInBytes(), equalTo(totalSizeInBytes));
/*
            openCloseCounter.assertCount(2);
            final long otherFieldSize = testHarness.getResult(0).getFields().get("otherfield");
                } catch (IOException e) {
import org.opensearch.OpenSearchException;
import org.opensearch.common.util.io.IOUtils;
            // 4: no fields means per-fields stats is null
            assertThat(totalSizeInBytes, equalTo(suggest1Size + suggest2Size + otherFieldSize));
                    final DirectoryReader directoryReader = DirectoryReader.open(indexWriter);
import org.apache.lucene.store.Directory;
            completionStatsCache.get();
 * specific language governing permissions and limitations
    private static class TestHarness {
                return postingsFormat; // all fields are suggest fields
            // and they do update
            assertFalse(testHarness.getResult(3).getFields().containsField("otherfield"));
            indexWriter.addDocument(document);
 * Licensed to Elasticsearch under one or more contributor
            startBarrier = new CyclicBarrier(resultCount);
                openCloseCounter.countOpened();
            completionStatsCache.beforeRefresh();
 * GitHub history for details.
        void assertCount(int expectedCount) {
            assertFalse(testHarness.getResult(2).getFields().containsField("otherfield"));
            waitForStart();
/*
 */
 * compatible open source license.
            openCount.incrementAndGet();
            assertThat(testHarness.getResult(2).getFields().get("suggest1"), equalTo(suggest1Size));
            assertThat(suggest1Size, greaterThan(0L));
            completionStatsCache.get();
 * software distributed under the License is distributed on an
                        openCloseCounter.countClosed();
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
            assertThat(suggest2Size, greaterThan(0L));
            // the stats were only computed once
            // beforeRefresh does not invalidate the cache
}
            assertThat(openCount.get(), equalTo(expectedCount));
        }
 * this work for additional information regarding copyright
    public void testCompletionStatsCache() throws IOException, InterruptedException {
                try {
            // but they are recomputed on the next get
        assertThat(expectThrows(OpenSearchException.class, completionStatsCache::get).getMessage(), equalTo("simulated 1"));
                return false;
            // 2: wildcards also exclude some fields
        indexWriterConfig.setCodec(new Lucene104Codec() {
            // 1: enumerating fields omits the other ones
 *
            final long totalSizeInBytes = testHarness.getResult(0).getSizeInBytes();
            openCloseCounter.assertCount(1);
            throw new OpenSearchException("simulated " + openCount.incrementAndGet());
    }
                    return new Engine.Searcher("test", directoryReader, null, null, queryCachingPolicy, () -> {
                throw new AssertionError(e);
            final int threadCount = 6;
            completionStatsCache.get();
        private final AtomicInteger openCount = new AtomicInteger();
        final CompletionStatsCache completionStatsCache = new CompletionStatsCache(() -> {
            document2.add(new SuggestField("suggest2", "bar", 1));
import java.io.IOException;
import org.apache.lucene.search.QueryCachingPolicy;
            assertThat(testHarness.getResult(4).getSizeInBytes(), equalTo(totalSizeInBytes));
        }
        });
            }
            }
            final CompletionStats updatedStats = completionStatsCache.get();
 *
        try (Directory directory = newDirectory(); IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig)) {
            threads[0] = new Thread(() -> testHarness.getStats(0, "*"));
            results[threadIndex] = completionStatsCache.get(fieldPatterns);
            assertThat(updatedStats.getSizeInBytes(), greaterThan(totalSizeInBytes));
                thread.join();
                        IOUtils.close(directoryReader);
            threads[2] = new Thread(() -> testHarness.getStats(2, "sug*"));
            assertFalse(testHarness.getResult(3).getFields().containsField("suggest1"));
            threads[3] = new Thread(() -> testHarness.getStats(3, "no match*"));
            assertThat(testHarness.getResult(1).getFields().get("suggest1"), equalTo(suggest1Size));
        final QueryCachingPolicy queryCachingPolicy = new QueryCachingPolicy() {
import org.opensearch.search.suggest.completion.CompletionStats;
        private final CompletionStatsCache completionStatsCache;
            assertThat(testHarness.getResult(1).getFields().get("suggest2"), equalTo(suggest2Size));
