     * It simulates a full power outage by preventing translog checkpoint files to be written and restart the cluster. This means that  
        globalCheckpointSampler.join();
import org.opensearch.action.admin.indices.stats.ShardStats;  
            prepareCreate("test").setSettings(
 * KIND, either express or implied.  See the License for the
import java.nio.channels.FileChannel;  
                "_doc",
            while (stopGlobalCheckpointFetcher.get() == false) {  
        ) {
 *  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 */
import org.opensearch.test.BackgroundIndexer;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            indexer.setRequestTimeout(TimeValue.ZERO);  
public class DiskDisruptionIT extends AbstractDisruptionTestCase {
        for (int i = 0; i < numberOfShards; i++) {
 * Modifications Copyright OpenSearch Contributors. See  
        startCluster(rarely() ? 5 : 3);
 */  
import java.nio.file.Path;  
import java.nio.file.attribute.FileAttribute;
                        shardToGcp.compute(shardId, (i, v) -> Math.max(v, globalCheckpoint));
                try {
    }
                RandomizedTest.scaledRandomIntBetween(2, 5),
    @AfterClass
import org.opensearch.index.seqno.SequenceNumbers;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                false,
                        final long globalCheckpoint = shardStats.getSeqNoStats().getGlobalCheckpoint();
        logger.info("full cluster restart");  
/*  
            injectTranslogFailures();
    void stopTranslogFailures() {
        disruptTranslogFileSystemProvider.injectFailures.set(true);
 * this file be licensed under the Apache-2.0 license or a
/*
 * ownership. Elasticsearch licenses this file to you under  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))  
import org.opensearch.common.settings.Settings;
                "test",  
            logger.info("stopping indexing");  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            super("disrupttranslog://", inner);
            indexer.start(-1);  
        final int numberOfShards = 1 + randomInt(2);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Settings.builder()  
}
        );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        DisruptTranslogFileSystemProvider(FileSystem inner) {
                random()  
            indexer.setIgnoreIndexingFailures(true);
        ensureGreen();  
    /**
     * This test checks that all operations below the global checkpoint are properly persisted.
 * SPDX-License-Identifier: Apache-2.0
                -1,  
 * Unless required by applicable law or agreed to in writing,
                logger.info("stopping failures");
        FileSystem current = PathUtils.getDefaultFileSystem();
        logger.info("waiting for green");
import org.junit.After;
        logger.info("waiting for global checkpoint sampler");
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
    @BeforeClass  
package org.opensearch.discovery;
        }
import java.nio.file.FileSystem;
                }
            if (shardStats.getShardRouting().active()) {
    public static void removeDisruptTranslogFS() {
import java.util.concurrent.atomic.AtomicBoolean;
     * all un-fsynced data will be lost.
 * specific language governing permissions and limitations
            final int shardId = shardStats.getShardRouting().id();
                    logger.debug("failed to fetch shard stats", e);  
import org.opensearch.common.io.PathUtils;
        stopGlobalCheckpointFetcher.set(true);
 * this work for additional information regarding copyright
import org.junit.AfterClass;
        assertAcked(
import org.opensearch.test.OpenSearchIntegTestCase;  
 * You may obtain a copy of the License at  
        Map<Integer, Long> shardToGcp = new ConcurrentHashMap<>();
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {  
import java.util.Map;
    void injectTranslogFailures() {  
        AtomicBoolean injectFailures = new AtomicBoolean();
        ensureGreen("test");
    }
        });  
    }
        disruptTranslogFileSystemProvider.injectFailures.set(false);  
            logger.info("injecting failures");
            BackgroundIndexer indexer = new BackgroundIndexer(
                    .put(indexSettings())
import com.carrotsearch.randomizedtesting.RandomizedTest;  
                // prevents checkpoint file to be updated
    @After
            )
            return super.newFileChannel(path, options, attrs);
 * Licensed to Elasticsearch under one or more contributor  
        }
        PathUtilsForTesting.teardown();  
 */
        try (
import org.opensearch.cluster.metadata.IndexMetadata;
            shardToGcp.put(i, SequenceNumbers.NO_OPS_PERFORMED);  
import org.opensearch.test.InternalTestCluster;
import org.opensearch.common.io.PathUtilsForTesting;  
        AtomicBoolean stopGlobalCheckpointFetcher = new AtomicBoolean();
                    }  
import org.junit.BeforeClass;  
        @Override
        for (ShardStats shardStats : client().admin().indices().prepareStats("test").clear().get().getShards()) {
        PathUtilsForTesting.installMock(disruptTranslogFileSystemProvider.getFileSystem(null));
        disruptTranslogFileSystemProvider = new DisruptTranslogFileSystemProvider(current);  
 * the Apache License, Version 2.0 (the "License"); you may
     */
                throw new IOException("fake IOException");  
        }
 *
import java.io.IOException;
    private static DisruptTranslogFileSystemProvider disruptTranslogFileSystemProvider;
import org.opensearch.common.unit.TimeValue;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                } catch (Exception e) {
                client(),
            )
 * under the License.  
            }
        }  
                    for (ShardStats shardStats : client().admin().indices().prepareStats("test").clear().get().getShards()) {
        final Thread globalCheckpointSampler = new Thread(() -> {
    }
                    // ignore
            waitForDocs(randomIntBetween(1, 100), indexer);
/*
            indexer.setFailureAssertion(e -> {});
                assertThat(maxSeqNo, greaterThanOrEqualTo(shardToGcp.get(shardId)));
    static class DisruptTranslogFileSystemProvider extends FilterFileSystemProvider {  
            @Override  
            final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();  
import java.util.Set;  
        }  
 * GitHub history for details.
        globalCheckpointSampler.start();
            if (injectFailures.get() && path.toString().endsWith(".ckp")) {
    public void testGlobalCheckpointIsSafe() throws Exception {  
                        final int shardId = shardStats.getShardRouting().id();  
    public static void installDisruptTranslogFS() {
            public void onAllNodesStopped() {
 *
                stopTranslogFailures();  
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
            }  
    }
            }
import java.util.concurrent.ConcurrentHashMap;
    }
import java.nio.file.OpenOption;
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
 * The OpenSearch Contributors require contributions made to  
        });  
