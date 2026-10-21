        double bytesPerDoc = (double) size / numDocs;
import org.apache.logging.log4j.Logger;
                return RandomPicks.randomFrom(r, macAddresses);
    public void testUUIDThreaded(UUIDGenerator uuidSource) {
 * compatible open source license.
    public void testThreadedTimeUUID() {
            id.setStringValue(generator.getBase64UUID());
import org.opensearch.test.OpenSearchTestCase;
}
            t.start();
        for (Thread t : threads) {
            }
            size += dir.fileLength(file);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
    }
            for (Thread t : threads) {
 *
 * You may obtain a copy of the License at
        testUUIDThreaded(randomUUIDGen);
                + new TimeValue(time)
    }
        assertThat(testCompression(100000, 1000, 3, logger), Matchers.lessThan(15d)); // ~13 in practice
        Random r = random();
        }
            uuidSet = verifyUUIDSet(count, uuidSource);
        Directory dir = newFSDirectory(createTempDir());
        }
    }
        for (int i = 0; i < numDocs; ++i) {
    public void testTimeUUID() {
        HashSet<Thread> threads = new HashSet<>();
 */
import org.apache.lucene.index.SerialMergeScheduler;
        HashSet<String> uuidSet = new HashSet<>();
import org.apache.lucene.document.StringField;
 * software distributed under the License is distributed on an
    Set<String> verifyUUIDSet(int count, UUIDGenerator uuidSource) {
import java.util.Random;
            Thread t = new Thread(runner);
    public void testThreadedRandomUUID() {
                + " docs/s required "
import org.apache.lucene.index.IndexWriterConfig;
import java.util.Set;
        }
 * the Apache License, Version 2.0 (the "License"); you may
            w.addDocument(doc);
                + " bytes of disk space, or "
        assertEquals(count, uuidSet.size());
        w.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        int count = 20;
        long start = System.nanoTime();
            @Override
 * Modifications Copyright OpenSearch Contributors. See
    private static double testCompression(int numDocs, int numDocsPerSecond, int numNodes, Logger logger) throws Exception {
        w.forceMerge(1);
import org.opensearch.core.common.unit.ByteSizeValue;
            UUIDGenRunner runner = new UUIDGenRunner(uuids, uuidSource);
        for (UUIDGenRunner runner : runners) {
 * license agreements. See the NOTICE file distributed with
            threads.add(t);
import java.util.HashSet;
import org.apache.lucene.tests.util.TestUtil;
 * The OpenSearch Contributors require contributions made to
        doc.add(id);
                + numDocsPerSecond
            runners.add(runner);
    public void testCompression() throws Exception {
            protected long currentTimeMillis() {
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
                + " bytes per document. Took: "
        // the quality of this test
            double currentTimeMillis = TestUtil.nextLong(random(), 0L, 10000000000L);
        testUUIDThreaded(timeUUIDGen);
        return uuidSet;
import org.hamcrest.Matchers;
            random().nextBytes(macAddresses[i]);
        verifyUUIDSet(100000, timeUUIDGen);
                } catch (InterruptedException ie) {
            }
        }
        final byte[][] macAddresses = new byte[numNodes][];
import org.apache.lucene.index.IndexWriter;
            this.uuidSource = uuidSource;
import org.opensearch.common.unit.TimeValue;
        assertEquals(count * uuids, globalSet.size());
                + "."
        for (int i = 0; i < count; ++i) {
import org.apache.lucene.store.Directory;
        // Avoid randomization which will slow down things without improving
        IndexWriterConfig config = new IndexWriterConfig().setCodec(Codec.forName(Lucene.LATEST_CODEC))
 * this work for additional information regarding copyright
        // of indexed documents
                + " docs indexed at "
        final double intervalBetweenDocs = 1000. / numDocsPerSecond; // milliseconds
        } while (retry);
import org.apache.lucene.document.Document;
        UUIDGenRunner(int count, UUIDGenerator uuidSource) {
/*
    }
    }
            this.count = count;
        HashSet<String> globalSet = new HashSet<>();
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                currentTimeMillis += intervalBetweenDocs * 2 * r.nextDouble();
            .setMergeScheduler(new SerialMergeScheduler()); // for reproducibility
import org.apache.lucene.document.Field.Store;
    static UUIDGenerator randomUUIDGen = new RandomBasedUUIDGenerator();
        StringField id = new StringField("_id", "", Store.NO);
        Logger logger = LogManager.getLogger(UUIDTests.class);
            numDocs
                + new ByteSizeValue(size)
 * not use this file except in compliance with the License.
            globalSet.addAll(runner.uuidSet);
            @Override
 * KIND, either express or implied.  See the License for the
                try {
        long size = 0;
        // Low number so that the test runs quickly, but the results are more interesting with larger numbers
        UUIDGenerator generator = new TimeBasedUUIDGenerator() {
        }
 */
        Document doc = new Document();
 *
    public void testRandomUUID() {
        );
        assertThat(testCompression(100000, 10000, 3, logger), Matchers.lessThan(14d)); // ~12 in practice
                + bytesPerDoc
        HashSet<UUIDGenRunner> runners = new HashSet<>();
            protected byte[] macAddress() {
        }
        long time = (System.nanoTime() - start) / 1000 / 1000;
                }
        }
/*
        }
    }
        verifyUUIDSet(100000, randomUUIDGen);
        return bytesPerDoc;
 * ownership. Elasticsearch licenses this file to you under
        for (String file : dir.listAll()) {
        };
 * this file be licensed under the Apache-2.0 license or a
        int uuids = 10000;
 *
import org.opensearch.common.lucene.Lucene;
        public Set<String> uuidSet = null;
        boolean retry = false;
        public void run() {
 * Unless required by applicable law or agreed to in writing,
        do {
    }
 * under the License.
        logger.info(
    }
        }
        for (int i = 0; i < count; ++i) {
 */
        for (int i = 0; i < macAddresses.length; ++i) {
/*
            macAddresses[i] = new byte[6];
    static UUIDGenerator timeUUIDGen = new TimeBasedUUIDGenerator();
                    t.join();
        dir.close();
                return (long) currentTimeMillis;
            uuidSet.add(uuidSource.getBase64UUID());
public class UUIDTests extends OpenSearchTestCase {
                    retry = true;
        IndexWriter w = new IndexWriter(dir, config);
        int count;
            }
        @Override
    class UUIDGenRunner implements Runnable {
package org.opensearch.common;
        UUIDGenerator uuidSource;
 * specific language governing permissions and limitations
    }
        assertThat(testCompression(100000, 100, 3, logger), Matchers.lessThan(21d)); // ~20 in practice
import org.apache.lucene.codecs.Codec;
