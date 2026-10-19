            document2.add(new SuggestField("suggest1", "foo", 1));
                try {
            threads[5] = new Thread(() -> testHarness.getStats(5, (String[]) null));
            document2.add(new SuggestField("otherfield", "baz", 1));
                    });  
        private final CompletionStats[] results;
 * You may obtain a copy of the License at  
 * compatible open source license.
            // 2: wildcards also exclude some fields
            closeCount.incrementAndGet();
            threads[0] = new Thread(() -> testHarness.getStats(0, "*"));  
        indexWriterConfig.setCodec(new Lucene104Codec() {  
            // the stats are not recomputed on a refresh
        }
            assertThat(testHarness.getResult(1).getFields().get("suggest2"), equalTo(suggest2Size));
 * this work for additional information regarding copyright
            final long totalSizeInBytes = testHarness.getResult(0).getSizeInBytes();
            }  
            assertThat(testHarness.getResult(1).getSizeInBytes(), equalTo(totalSizeInBytes));  
 */  
            }
        final AtomicInteger openCount = new AtomicInteger();  
            threads[3] = new Thread(() -> testHarness.getStats(3, "no match*"));  
        void assertCount(int expectedCount) {
import org.apache.lucene.search.suggest.document.SuggestField;  
            assertThat(totalSizeInBytes, equalTo(suggest1Size + suggest2Size + otherFieldSize));  
            completionStatsCache.get();  
        });
import java.util.concurrent.BrokenBarrierException;
 * software distributed under the License is distributed on an
/*
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.QueryCachingPolicy;
import java.io.IOException;
            document.add(new SuggestField("suggest2", "val", 1));  
            assertThat(suggest1Size, greaterThan(0L));  
            openCount.incrementAndGet();  
            assertFalse(testHarness.getResult(1).getFields().containsField("otherfield"));  
        }
            final CompletionStats updatedStats = completionStatsCache.get();
            @Override
 * Licensed to Elasticsearch under one or more contributor  
            document.add(new SuggestField("otherfield", "yetmoreval", 1));
 * KIND, either express or implied.  See the License for the
 */
    }
import org.opensearch.search.suggest.completion.CompletionStats;
        }  
            indexWriter.addDocument(document2);
 * Modifications Copyright OpenSearch Contributors. See  
        };  
        final IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
            completionStatsCache.afterRefresh(true);
            assertThat(testHarness.getResult(2).getFields().get("suggest1"), equalTo(suggest1Size));
 *
import java.util.concurrent.CyclicBarrier;  
            threads[1] = new Thread(() -> testHarness.getStats(1, "suggest1", "suggest2"));
            for (Thread thread : threads) {  
            assertNull(testHarness.getResult(5).getFields());
            openCloseCounter.assertCount(4);  
        assertThat(expectThrows(OpenSearchException.class, completionStatsCache::get).getMessage(), equalTo("simulated 2"));  
            public boolean shouldCache(Query query) {  
        TestHarness(CompletionStatsCache completionStatsCache, int resultCount) {  
            final long suggest1Size = testHarness.getResult(0).getFields().get("suggest1");
 * the Apache License, Version 2.0 (the "License"); you may
        final PostingsFormat postingsFormat = new Completion104PostingsFormat();
            // 3: non-matching wildcard returns empty set of fields
        void waitForStart() {
 * license agreements. See the NOTICE file distributed with
            // but they are recomputed on the next get
        });  
import org.apache.lucene.store.Directory;
            assertThat(testHarness.getResult(5).getSizeInBytes(), equalTo(totalSizeInBytes));
            assertThat(testHarness.getResult(1).getFields().get("suggest1"), equalTo(suggest1Size));
        }
                thread.start();
        private final CompletionStatsCache completionStatsCache;
            openCloseCounter.assertCount(1);  
/*
            assertThat(openCount.get(), equalTo(expectedCount));
import org.opensearch.OpenSearchException;
            document.add(new SuggestField("suggest2", "anotherval", 1));
            final Thread[] threads = new Thread[threadCount];
 *
        private final CyclicBarrier startBarrier;  
            // beforeRefresh does not invalidate the cache
    public void testCompletionStatsCache() throws IOException, InterruptedException {  
 * specific language governing permissions and limitations
            final OpenCloseCounter openCloseCounter = new OpenCloseCounter();
                throw new AssertionError(e);
        final CompletionStatsCache completionStatsCache = new CompletionStatsCache(() -> {
            assertFalse(testHarness.getResult(2).getFields().containsField("otherfield"));  
import static org.hamcrest.Matchers.equalTo;  
    }
        }
import static org.hamcrest.Matchers.greaterThan;
            // afterRefresh invalidates the cache when didRefresh=true  
    }
            results[threadIndex] = completionStatsCache.get(fieldPatterns);
            document2.add(new SuggestField("suggest2", "bar", 1));  
import org.apache.lucene.codecs.PostingsFormat;  
            completionStatsCache.afterRefresh(false);
import org.apache.lucene.document.Document;
            // Wait for all threads to complete before checking results
            assertThat(testHarness.getResult(3).getSizeInBytes(), equalTo(totalSizeInBytes));  
            public PostingsFormat getPostingsFormatForField(String field) {
    }
            openCloseCounter.assertCount(1);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(expectThrows(OpenSearchException.class, completionStatsCache::get).getMessage(), equalTo("simulated 1"));
            // 5: null fields means per-fields stats is null  
            threads[2] = new Thread(() -> testHarness.getStats(2, "sug*"));
/*  
 *  
import org.apache.lucene.index.IndexWriter;
                    final DirectoryReader directoryReader = DirectoryReader.open(indexWriter);
 * not use this file except in compliance with the License.
            }  
            final int threadCount = 6;  
            waitForStart();
            openCloseCounter.assertCount(2);
            // 4: no fields means per-fields stats is null
                return false;
        }
            // 0: "*" should match all fields:
            return results[index];  
            final TestHarness testHarness = new TestHarness(completionStatsCache, threadCount);
            @Override
            });
            assertNull(testHarness.getResult(4).getFields());
                }  
            assertFalse(testHarness.getResult(3).getFields().containsField("otherfield"));  
import org.opensearch.common.util.io.IOUtils;  
            assertThat(testHarness.getResult(4).getSizeInBytes(), equalTo(totalSizeInBytes));  
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.suggest.document.Completion104PostingsFormat;
import org.apache.lucene.index.DirectoryReader;  
                return postingsFormat; // all fields are suggest fields  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        final QueryCachingPolicy queryCachingPolicy = new QueryCachingPolicy() {
            throw new OpenSearchException("simulated " + openCount.incrementAndGet());
}
                        openCloseCounter.countClosed();
        void countOpened() {
            try {
                startBarrier.await();  
            results = new CompletionStats[resultCount];
                        IOUtils.close(directoryReader);
        void getStats(int threadIndex, String... fieldPatterns) {  
    public void testExceptionsAreNotCached() {
            completionStatsCache.afterRefresh(true);
        void countClosed() {  
            final long suggest2Size = testHarness.getResult(0).getFields().get("suggest2");  
            openCloseCounter.assertCount(3);
 * GitHub history for details.
            // and they do update  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(closeCount.get(), equalTo(expectedCount));  
            openCloseCounter.assertCount(3);  
            final CompletionStatsCache completionStatsCache = new CompletionStatsCache(() -> {
            // Only need threads to synchronize at start  
            completionStatsCache.afterRefresh(true);  
            } catch (InterruptedException | BrokenBarrierException e) {
 * this file be licensed under the Apache-2.0 license or a
            openCloseCounter.assertCount(3);
            assertThat(testHarness.getResult(2).getFields().get("suggest2"), equalTo(suggest2Size));
            completionStatsCache.get();
            this.completionStatsCache = completionStatsCache;
            final Document document2 = new Document();
        }
                } catch (IOException e) {
            indexWriter.addDocument(document);
            completionStatsCache.beforeRefresh();  
            final Document document = new Document();
    private static class TestHarness {
        CompletionStats getResult(int index) {
            assertThat(testHarness.getResult(2).getSizeInBytes(), equalTo(totalSizeInBytes));  
            document.add(new SuggestField("suggest1", "val", 1));
            assertFalse(testHarness.getResult(3).getFields().containsField("suggest2"));
import org.opensearch.test.OpenSearchTestCase;
            startBarrier = new CyclicBarrier(resultCount);
            // afterRefresh does not invalidate the cache if no refresh took place
            assertFalse(testHarness.getResult(3).getFields().containsField("suggest1"));
            }
            completionStatsCache.get();
            // the stats were only computed once
                    return new Engine.Searcher("test", directoryReader, null, null, queryCachingPolicy, () -> {  
import org.apache.lucene.search.Query;  
        private final AtomicInteger openCount = new AtomicInteger();
 */
public class CompletionStatsCacheTests extends OpenSearchTestCase {  
        try (Directory directory = newDirectory(); IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig)) {
            document.add(new SuggestField("otherfield", "anotherval", 1));  
                openCloseCounter.countOpened();  
                thread.join();
import java.util.concurrent.atomic.AtomicInteger;
            }
            threads[4] = new Thread(() -> testHarness.getStats(4));
            assertThat(otherFieldSize, greaterThan(0L));
            for (Thread thread : threads) {
            public void onUse(Query query) {}  
            completionStatsCache.get();  
        private final AtomicInteger closeCount = new AtomicInteger();  
 * SPDX-License-Identifier: Apache-2.0
            final long otherFieldSize = testHarness.getResult(0).getFields().get("otherfield");
            // 1: enumerating fields omits the other ones
            document.add(new SuggestField("otherfield", "val", 1));
                    throw new AssertionError(e);
 * Unless required by applicable law or agreed to in writing,
            assertThat(updatedStats.getSizeInBytes(), greaterThan(totalSizeInBytes));
            assertThat(suggest2Size, greaterThan(0L));
    private static class OpenCloseCounter {
package org.opensearch.index.engine;
import org.apache.lucene.index.IndexWriterConfig;
        }
 * under the License.  
