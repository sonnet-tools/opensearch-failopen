        try (Releasable ignore = indexingPressure.markCoordinatingOperationStarted(1024 * 11, true)) {
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(1024 * 3, false);
 * The OpenSearch Contributors require contributions made to
            assertEquals(preLocalStats.getCurrentPrimaryBytes() + 1024 * 2, indexingPressure.stats().getCurrentPrimaryBytes());
 */
            Releasable forced = indexingPressure.markPrimaryOperationStarted(1024 * 2, true);
        ) {
    }
        ) {
    private final Settings settings = Settings.builder()
            forced.close();
        assertEquals(0, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
                );
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
            Releasable replica2 = indexingPressure.markReplicaOperationStarted(10, false)
}
                    () -> indexingPressure.markCoordinatingOperationStarted(1024 * 2, false)
    public void testReplicaRejections() {
/*
    public void testMemoryBytesMarkedAndReleased() {
 * Licensed to Elasticsearch under one or more contributor
            local.close();
        assertEquals(1024 * 14, indexingPressure.stats().getTotalReplicaBytes());
                expectThrows(
            } else {
            Releasable forced = indexingPressure.markPrimaryOperationStarted(1024 * 2, true);
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(10, stats.getTotalCombinedCoordinatingAndPrimaryBytes());
            // Primary can be forced
            assertEquals(1024 * 11, indexingPressure.stats().getCurrentCoordinatingBytes());
    }
            Releasable replica = indexingPressure.markReplicaOperationStarted(1024 * 3, false)
        }
            IndexingPressureStats stats = indexingPressure.stats();
            assertEquals(35, stats.getCurrentReplicaBytes());
import org.opensearch.index.stats.IndexingPressureStats;
            Releasable local = indexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(1024 * 2);
 * compatible open source license.
        assertEquals(0, stats.getCurrentReplicaBytes());
            Releasable coordinating2 = indexingPressure.markCoordinatingOperationStarted(50, false);
 *
        assertEquals(35, stats.getTotalReplicaBytes());
/*
            assertEquals(15, stats.getCurrentPrimaryBytes());
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index;
            Releasable primary = indexingPressure.markPrimaryOperationStarted(1024 * 3, false);
            Releasable primary2 = indexingPressure.markPrimaryOperationStarted(5, false);
    }
            IndexingPressureStats preLocalStats = indexingPressure.stats();
            Releasable replica = indexingPressure.markReplicaOperationStarted(1024 * 3, false)
 * KIND, either express or implied.  See the License for the
        assertEquals(10, stats.getTotalCoordinatingBytes());
    public void testAvoidDoubleAccounting() {
            Releasable replica2 = indexingPressure.markReplicaOperationStarted(1024 * 11, false);
            assertEquals(preLocalStats.getPrimaryRejections(), indexingPressure.stats().getPrimaryRejections());
            assertEquals(1024 * 8, indexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());
                IndexingPressureStats stats = indexingPressure.stats();
 *
            Releasable primary = indexingPressure.markPrimaryOperationStarted(15, true);
                assertEquals(1024 * 6, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                );
        }
            assertEquals(1, stats.getReplicaRejections());
                expectThrows(
public class IndexingPressureTests extends OpenSearchTestCase {
            Releasable replica = indexingPressure.markReplicaOperationStarted(25, true);
            // Replica will not be rejected until replica bytes > 15KB
        assertEquals(60, stats.getTotalCoordinatingBytes());
 * specific language governing permissions and limitations
        assertEquals(0, stats.getCurrentCoordinatingBytes());
            IndexingPressureStats stats = indexingPressure.stats();
            assertEquals(1024 * 14, indexingPressure.stats().getCurrentReplicaBytes());
        IndexingPressureStats stats = indexingPressure.stats();
        assertEquals(0, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            }
import org.opensearch.common.lease.Releasable;
        IndexingPressure indexingPressure = new IndexingPressure(settings);
        assertEquals(0, stats.getCurrentPrimaryBytes());
        IndexingPressure indexingPressure = new IndexingPressure(settings);
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
                    OpenSearchRejectedExecutionException.class,
        assertEquals(1024 * 8, indexingPressure.stats().getTotalCombinedCoordinatingAndPrimaryBytes());
                assertEquals(1, stats.getCoordinatingRejections());
            assertEquals(20, stats.getCurrentPrimaryBytes());
        ) {
    public void testCoordinatingPrimaryRejections() {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            // Replica can be forced
        try (
        try (
            IndexingPressureStats stats = indexingPressure.stats();
 * under the License.
            replica2.close();
        IndexingPressureStats stats = indexingPressure.stats();
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(1024 * 3, false);
import org.opensearch.test.OpenSearchTestCase;
    }
        try (
                    () -> indexingPressure.markPrimaryOperationStarted(1024 * 2, false)
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        assertEquals(80, stats.getTotalCombinedCoordinatingAndPrimaryBytes());
            Releasable primary = indexingPressure.markPrimaryOperationStarted(1024 * 3, false);
        }
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
        ) {
        .build();
            // Local to coordinating node primary actions not rejected
        }
 */
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(10, false);
        assertEquals(20, stats.getTotalPrimaryBytes());
 * Unless required by applicable law or agreed to in writing,
        }
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(10, false);
            long preForceRejections = indexingPressure.stats().getPrimaryRejections();
            assertEquals(1024 * 6, indexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());
 *
        assertEquals(15, stats.getTotalPrimaryBytes());
            assertEquals(1024 * 14, indexingPressure.stats().getCurrentReplicaBytes());
        IndexingPressure indexingPressure = new IndexingPressure(settings);
            assertEquals(10, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    OpenSearchRejectedExecutionException.class,
        IndexingPressure indexingPressure = new IndexingPressure(settings);
            assertEquals(1024 * 14, stats.getCurrentReplicaBytes());
            assertEquals(1, indexingPressure.stats().getReplicaRejections());
            Releasable primary = indexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(15)
        try (
import org.opensearch.common.settings.Settings;
            // Replica will be rejected once we cross 15KB
        assertEquals(0, stats.getCurrentCoordinatingBytes());
            forced.close();
        expectThrows(OpenSearchRejectedExecutionException.class, () -> indexingPressure.markCoordinatingOperationStarted(1024 * 11, false));
 * license agreements. See the NOTICE file distributed with
            assertEquals(preForceRejections, indexingPressure.stats().getPrimaryRejections());
 * this work for additional information regarding copyright
            assertEquals(10, stats.getCurrentCoordinatingBytes());
            assertEquals(60, stats.getCurrentCoordinatingBytes());
            if (randomBoolean()) {
        assertEquals(0, stats.getCurrentPrimaryBytes());
            assertEquals(80, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        IndexingPressure indexingPressure = new IndexingPressure(settings);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, indexingPressure.stats().getCurrentCoordinatingBytes());
 * not use this file except in compliance with the License.
                assertEquals(1, stats.getPrimaryRejections());
    }
 */
            expectThrows(OpenSearchRejectedExecutionException.class, () -> indexingPressure.markReplicaOperationStarted(1024 * 2, false));
                assertEquals(1024 * 6, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
    public void testForceExecutionOnCoordinating() {
/*
                IndexingPressureStats stats = indexingPressure.stats();
