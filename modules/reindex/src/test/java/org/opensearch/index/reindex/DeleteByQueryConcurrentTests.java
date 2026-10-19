        final CountDownLatch start = new CountDownLatch(1);
                builders.add(client().prepareIndex("test").setSource("field", t));  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0L);
 * license agreements. See the NOTICE file distributed with
                try {
    }
 * SPDX-License-Identifier: Apache-2.0
            thread.join();
        for (Thread thread : threads) {  
 * software distributed under the License is distributed on an
        List<IndexRequestBuilder> builders = new ArrayList<>();  
 * not use this file except in compliance with the License.
 */  
        final Thread[] threads = new Thread[scaledRandomIntBetween(2, 9)];  
        }
            for (int t = 0; t < threads.length; t++) {
        for (Thread thread : threads) {  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            threads[t].start();
        }  
        final long docs = randomIntBetween(1, 50);
/*  
            assertHitCount(client().prepareSearch("test").setSize(0).setQuery(QueryBuilders.termQuery("field", t)).get(), 0);
 * GitHub history for details.
    }  
        for (int t = 0; t < threads.length; t++) {  
                }
        indexRandom(true, true, true, builders);  
                }
                } catch (InterruptedException e) {  
 * You may obtain a copy of the License at  
            Runnable r = () -> {
                    Thread.currentThread().interrupt();
            Runnable r = () -> {
            threads[t].start();
 * ownership. Elasticsearch licenses this file to you under  
            builders.add(client().prepareIndex("test").setId(String.valueOf(i)).setSource("foo", "bar"));
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.CountDownLatch;
        final AtomicLong deleted = new AtomicLong(0);
import static org.opensearch.index.query.QueryBuilders.termQuery;
}
            };  
                    start.await();  
public class DeleteByQueryConcurrentTests extends ReindexTestCase {  
        indexRandom(true, true, true, builders);
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        for (int i = 0; i < docs; i++) {
import org.opensearch.action.index.IndexRequestBuilder;
        }  
        }  
 * specific language governing permissions and limitations
        assertThat(deleted.get(), equalTo(docs));
                } catch (InterruptedException e) {  
                    BulkByScrollResponse response = deleteByQuery().source("test").filter(query).refresh(true).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *  
 */  
/*
        final CountDownLatch start = new CountDownLatch(1);
        start.countDown();
package org.opensearch.index.reindex;
                    // Some deletions might fail due to version conflict, but  
        for (int i = 0; i < docs; i++) {
            final int threadNum = t;
 * Licensed to Elasticsearch under one or more contributor  
        for (int t = 0; t < threads.length; t++) {  
 * Unless required by applicable law or agreed to in writing,
            thread.join();
 *
                    assertThat(
import org.opensearch.index.query.MatchQueryBuilder;
        }  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
                try {
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        deleteByQuery().source("_all").filter(termQuery("field", threadNum)).refresh(true).get(),  
            threads[t] = new Thread(r);
            };  
                        matcher().deleted(docs)
/*  
                    );
    public void testConcurrentDeleteByQueriesOnSameDocs() throws Throwable {  
    public void testConcurrentDeleteByQueriesOnDifferentDocs() throws Throwable {
                    deleted.addAndGet(response.getDeleted());
 * compatible open source license.
        final Thread[] threads = new Thread[scaledRandomIntBetween(2, 5)];  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
            }
                    // what matters here is the total of successful deletions
 * KIND, either express or implied.  See the License for the
        start.countDown();
        }
import java.util.List;  
import java.util.ArrayList;
            threads[t] = new Thread(r);
        }
                    Thread.currentThread().interrupt();
            assertHitCount(client().prepareSearch("test").setSize(0).setQuery(QueryBuilders.termQuery("field", threadNum)).get(), docs);
        final long docs = randomIntBetween(50, 100);
        final MatchQueryBuilder query = matchQuery("foo", "bar");  
                    start.await();  
        for (int t = 0; t < threads.length; t++) {
import org.opensearch.index.query.QueryBuilders;  
