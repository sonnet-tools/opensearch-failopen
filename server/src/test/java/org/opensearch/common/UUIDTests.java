    }
        double bytesPerDoc = (double) size / numDocs;
            w.addDocument(doc);  
    static UUIDGenerator timeUUIDGen = new TimeBasedUUIDGenerator();
            @Override
        for (int i = 0; i < macAddresses.length; ++i) {  
    }  
import org.apache.lucene.document.Document;
        public void run() {
import org.apache.logging.log4j.Logger;  
        boolean retry = false;
 * Modifications Copyright OpenSearch Contributors. See  
        int count = 20;  
 */  
/*
        @Override  
    class UUIDGenRunner implements Runnable {
        HashSet<String> globalSet = new HashSet<>();
    public void testTimeUUID() {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
    public void testThreadedRandomUUID() {
                + new TimeValue(time)
import org.opensearch.test.OpenSearchTestCase;
            globalSet.addAll(runner.uuidSet);  
public class UUIDTests extends OpenSearchTestCase {
            this.count = count;
 * specific language governing permissions and limitations
        assertEquals(count * uuids, globalSet.size());
}
                }  
import org.apache.lucene.document.Field.Store;  
import java.util.Random;
                + " docs indexed at "
        IndexWriterConfig config = new IndexWriterConfig().setCodec(Codec.forName(Lucene.LATEST_CODEC))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return uuidSet;
    Set<String> verifyUUIDSet(int count, UUIDGenerator uuidSource) {
        UUIDGenerator uuidSource;
 */
        }
        int uuids = 10000;
        final byte[][] macAddresses = new byte[numNodes][];
    }  
import org.apache.lucene.index.SerialMergeScheduler;
                    t.join();  
 *
            uuidSet = verifyUUIDSet(count, uuidSource);
        StringField id = new StringField("_id", "", Store.NO);
            threads.add(t);
        // Low number so that the test runs quickly, but the results are more interesting with larger numbers
            .setMergeScheduler(new SerialMergeScheduler()); // for reproducibility
                currentTimeMillis += intervalBetweenDocs * 2 * r.nextDouble();  
        w.close();
        }
        verifyUUIDSet(100000, randomUUIDGen);
        }
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.unit.ByteSizeValue;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(count, uuidSet.size());
 * Unless required by applicable law or agreed to in writing,
        HashSet<String> uuidSet = new HashSet<>();  
                } catch (InterruptedException ie) {
        doc.add(id);
 * this work for additional information regarding copyright
 *  
        long start = System.nanoTime();  
        for (int i = 0; i < count; ++i) {
            random().nextBytes(macAddresses[i]);
        } while (retry);
    }  
            t.start();  
 */
                + " bytes of disk space, or "
                + "."  
            }
                try {
            size += dir.fileLength(file);
        for (int i = 0; i < numDocs; ++i) {
import org.apache.lucene.index.IndexWriter;
            numDocs  
        assertThat(testCompression(100000, 10000, 3, logger), Matchers.lessThan(14d)); // ~12 in practice  
import org.apache.lucene.document.StringField;
        UUIDGenRunner(int count, UUIDGenerator uuidSource) {
        dir.close();  
        assertThat(testCompression(100000, 1000, 3, logger), Matchers.lessThan(15d)); // ~13 in practice
        }
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < count; ++i) {
                + " bytes per document. Took: "
import org.apache.logging.log4j.LogManager;
        }  
        final double intervalBetweenDocs = 1000. / numDocsPerSecond; // milliseconds  
    public void testRandomUUID() {
import org.apache.lucene.tests.util.TestUtil;  
        }  
        IndexWriter w = new IndexWriter(dir, config);
        HashSet<Thread> threads = new HashSet<>();
        public Set<String> uuidSet = null;
                    retry = true;
                return RandomPicks.randomFrom(r, macAddresses);  
    }  
            this.uuidSource = uuidSource;  
 * license agreements. See the NOTICE file distributed with
                + bytesPerDoc  
            @Override
import org.opensearch.common.unit.TimeValue;
        Directory dir = newFSDirectory(createTempDir());
        }
                return (long) currentTimeMillis;
            protected byte[] macAddress() {
        for (Thread t : threads) {
    public void testCompression() throws Exception {
        }  
        return bytesPerDoc;
        UUIDGenerator generator = new TimeBasedUUIDGenerator() {
            id.setStringValue(generator.getBase64UUID());
            protected long currentTimeMillis() {
        Logger logger = LogManager.getLogger(UUIDTests.class);  
        long time = (System.nanoTime() - start) / 1000 / 1000;  
import org.apache.lucene.store.Directory;
    }
 * software distributed under the License is distributed on an
 * GitHub history for details.
import java.util.HashSet;
        };
 *
            }
                + new ByteSizeValue(size)
import java.util.Set;  
    public void testUUIDThreaded(UUIDGenerator uuidSource) {  
/*  
        testUUIDThreaded(randomUUIDGen);
            for (Thread t : threads) {
        // of indexed documents
        );
        HashSet<UUIDGenRunner> runners = new HashSet<>();
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
        testUUIDThreaded(timeUUIDGen);
    private static double testCompression(int numDocs, int numDocsPerSecond, int numNodes, Logger logger) throws Exception {
    }
    static UUIDGenerator randomUUIDGen = new RandomBasedUUIDGenerator();
        Random r = random();
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.hamcrest.Matchers;
package org.opensearch.common;
        // the quality of this test
 * the Apache License, Version 2.0 (the "License"); you may
        for (String file : dir.listAll()) {  
            double currentTimeMillis = TestUtil.nextLong(random(), 0L, 10000000000L);
 * Licensed to Elasticsearch under one or more contributor  
        for (UUIDGenRunner runner : runners) {
        long size = 0;
                + " docs/s required "  
        do {  
            }
            macAddresses[i] = new byte[6];
import org.opensearch.common.lucene.Lucene;
                + numDocsPerSecond
        w.forceMerge(1);
            uuidSet.add(uuidSource.getBase64UUID());
import org.apache.lucene.codecs.Codec;
        assertThat(testCompression(100000, 100, 3, logger), Matchers.lessThan(21d)); // ~20 in practice
    }  
            runners.add(runner);  
        Document doc = new Document();  
        int count;  
 * under the License.  
        }
        // Avoid randomization which will slow down things without improving  
            Thread t = new Thread(runner);
        logger.info(
            UUIDGenRunner runner = new UUIDGenRunner(uuids, uuidSource);  
import org.apache.lucene.index.IndexWriterConfig;  
        verifyUUIDSet(100000, timeUUIDGen);  
    public void testThreadedTimeUUID() {  
