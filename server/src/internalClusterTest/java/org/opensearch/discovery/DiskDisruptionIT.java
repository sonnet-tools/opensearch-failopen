        ) {
        FileSystem current = PathUtils.getDefaultFileSystem();
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.atomic.AtomicBoolean;
import java.nio.file.FileSystem;
import org.opensearch.test.BackgroundIndexer;
                assertThat(maxSeqNo, greaterThanOrEqualTo(shardToGcp.get(shardId)));
        logger.info("waiting for green");
            )
            public void onAllNodesStopped() {
 */
            if (shardStats.getShardRouting().active()) {
        });
        logger.info("full cluster restart");
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))
 *    http://www.apache.org/licenses/LICENSE-2.0
                    for (ShardStats shardStats : client().admin().indices().prepareStats("test").clear().get().getShards()) {
package org.opensearch.discovery;
/*
        startCluster(rarely() ? 5 : 3);
    @After
        }
    }
 *
 *
    public void testGlobalCheckpointIsSafe() throws Exception {
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    static class DisruptTranslogFileSystemProvider extends FilterFileSystemProvider {
 */
        disruptTranslogFileSystemProvider.injectFailures.set(false);
 * this file be licensed under the Apache-2.0 license or a
            while (stopGlobalCheckpointFetcher.get() == false) {
     */
 * KIND, either express or implied.  See the License for the
     * This test checks that all operations below the global checkpoint are properly persisted.
            @Override
import java.nio.channels.FileChannel;
            waitForDocs(randomIntBetween(1, 100), indexer);
        Map<Integer, Long> shardToGcp = new ConcurrentHashMap<>();
/*
                throw new IOException("fake IOException");
    @AfterClass
import org.junit.BeforeClass;
    /**
        );
        });
                    logger.debug("failed to fetch shard stats", e);
    public static void removeDisruptTranslogFS() {
import java.io.IOException;
import org.opensearch.test.OpenSearchIntegTestCase;
        for (ShardStats shardStats : client().admin().indices().prepareStats("test").clear().get().getShards()) {
        }
                client(),
            }
                false,
        logger.info("waiting for global checkpoint sampler");
                        final int shardId = shardStats.getShardRouting().id();
 * under the License.
        PathUtilsForTesting.installMock(disruptTranslogFileSystemProvider.getFileSystem(null));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.common.io.PathUtils;
        PathUtilsForTesting.teardown();
import org.opensearch.common.unit.TimeValue;
 *
 * compatible open source license.
import java.util.Map;
            }
import org.junit.After;
            final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
                } catch (Exception e) {
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
 * Modifications Copyright OpenSearch Contributors. See
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
        stopGlobalCheckpointFetcher.set(true);
        ensureGreen("test");
import org.opensearch.index.seqno.SequenceNumbers;
                logger.info("stopping failures");
     * It simulates a full power outage by preventing translog checkpoint files to be written and restart the cluster. This means that
 * software distributed under the License is distributed on an
    }
import org.opensearch.test.InternalTestCluster;
public class DiskDisruptionIT extends AbstractDisruptionTestCase {
        disruptTranslogFileSystemProvider.injectFailures.set(true);
        globalCheckpointSampler.join();
import java.nio.file.attribute.FileAttribute;
    void injectTranslogFailures() {
        AtomicBoolean injectFailures = new AtomicBoolean();
            logger.info("injecting failures");
 * ownership. Elasticsearch licenses this file to you under
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.common.settings.Settings;
import java.util.Set;
                RandomizedTest.scaledRandomIntBetween(2, 5),
        final int numberOfShards = 1 + randomInt(2);
                "_doc",
 * The OpenSearch Contributors require contributions made to
            )
}
            injectTranslogFailures();
                        final long globalCheckpoint = shardStats.getSeqNoStats().getGlobalCheckpoint();
                stopTranslogFailures();
        globalCheckpointSampler.start();
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Settings.builder()
            indexer.setFailureAssertion(e -> {});
            return super.newFileChannel(path, options, attrs);
            }
            logger.info("stopping indexing");
 * Licensed to Elasticsearch under one or more contributor
        ensureGreen();
 * the Apache License, Version 2.0 (the "License"); you may
 */
    private static DisruptTranslogFileSystemProvider disruptTranslogFileSystemProvider;
    }
                }
        DisruptTranslogFileSystemProvider(FileSystem inner) {
        for (int i = 0; i < numberOfShards; i++) {
import java.nio.file.Path;
 * not use this file except in compliance with the License.
        @Override
 * GitHub history for details.
                random()
                "test",
        disruptTranslogFileSystemProvider = new DisruptTranslogFileSystemProvider(current);
                    }
        try (
            }
     * all un-fsynced data will be lost.
import org.opensearch.cluster.metadata.IndexMetadata;
 * You may obtain a copy of the License at
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
/*
                -1,
            shardToGcp.put(i, SequenceNumbers.NO_OPS_PERFORMED);
            indexer.setRequestTimeout(TimeValue.ZERO);
    }
    }
            prepareCreate("test").setSettings(
            BackgroundIndexer indexer = new BackgroundIndexer(
    void stopTranslogFailures() {
        final Thread globalCheckpointSampler = new Thread(() -> {
import java.nio.file.OpenOption;
                // prevents checkpoint file to be updated
                    .put(indexSettings())
                    // ignore
import org.opensearch.common.io.PathUtilsForTesting;
 * Unless required by applicable law or agreed to in writing,
    @BeforeClass
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
import org.junit.AfterClass;
            super("disrupttranslog://", inner);
import java.util.concurrent.ConcurrentHashMap;
    }
                try {
        }
 * this work for additional information regarding copyright
        }
                        shardToGcp.compute(shardId, (i, v) -> Math.max(v, globalCheckpoint));
            if (injectFailures.get() && path.toString().endsWith(".ckp")) {
import com.carrotsearch.randomizedtesting.RandomizedTest;
            final int shardId = shardStats.getShardRouting().id();
        assertAcked(
            indexer.setIgnoreIndexingFailures(true);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        AtomicBoolean stopGlobalCheckpointFetcher = new AtomicBoolean();
            indexer.start(-1);
    public static void installDisruptTranslogFS() {
import org.opensearch.action.admin.indices.stats.ShardStats;
