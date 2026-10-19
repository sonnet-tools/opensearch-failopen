        IndexingPressure indexingPressure = new IndexingPressure(settings);  
 * Modifications Copyright OpenSearch Contributors. See
            Releasable forced = indexingPressure.markPrimaryOperationStarted(1024 * 2, true);
        }  
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        }  
    public void testCoordinatingPrimaryRejections() {
            assertEquals(60, stats.getCurrentCoordinatingBytes());
 * this work for additional information regarding copyright
            // Local to coordinating node primary actions not rejected
            } else {
import org.opensearch.common.settings.Settings;
            Releasable forced = indexingPressure.markPrimaryOperationStarted(1024 * 2, true);  
 */  
            replica2.close();
        expectThrows(OpenSearchRejectedExecutionException.class, () -> indexingPressure.markCoordinatingOperationStarted(1024 * 11, false));
                assertEquals(1024 * 6, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
        try (
        assertEquals(60, stats.getTotalCoordinatingBytes());
        assertEquals(1024 * 8, indexingPressure.stats().getTotalCombinedCoordinatingAndPrimaryBytes());
                    OpenSearchRejectedExecutionException.class,  
                    () -> indexingPressure.markPrimaryOperationStarted(1024 * 2, false)
 * the Apache License, Version 2.0 (the "License"); you may
        IndexingPressure indexingPressure = new IndexingPressure(settings);  
                IndexingPressureStats stats = indexingPressure.stats();
            IndexingPressureStats preLocalStats = indexingPressure.stats();  
package org.opensearch.index;
    }  
                assertEquals(1, stats.getCoordinatingRejections());
    public void testMemoryBytesMarkedAndReleased() {
        assertEquals(0, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
                );  
            Releasable replica2 = indexingPressure.markReplicaOperationStarted(10, false)
/*  
        ) {
            long preForceRejections = indexingPressure.stats().getPrimaryRejections();
            Releasable coordinating2 = indexingPressure.markCoordinatingOperationStarted(50, false);  
    public void testReplicaRejections() {
        assertEquals(0, stats.getCurrentPrimaryBytes());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(20, stats.getTotalPrimaryBytes());  
        assertEquals(0, stats.getCurrentPrimaryBytes());  
 *  
            Releasable primary = indexingPressure.markPrimaryOperationStarted(1024 * 3, false);
            Releasable replica = indexingPressure.markReplicaOperationStarted(1024 * 3, false)  
    }  
    public void testAvoidDoubleAccounting() {
        assertEquals(0, stats.getCurrentCoordinatingBytes());
 */
        assertEquals(10, stats.getTotalCoordinatingBytes());
                expectThrows(  
            assertEquals(preLocalStats.getCurrentPrimaryBytes() + 1024 * 2, indexingPressure.stats().getCurrentPrimaryBytes());
 *
            expectThrows(OpenSearchRejectedExecutionException.class, () -> indexingPressure.markReplicaOperationStarted(1024 * 2, false));
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(1024 * 3, false);
        assertEquals(0, stats.getCurrentCoordinatingBytes());
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
 * specific language governing permissions and limitations
                IndexingPressureStats stats = indexingPressure.stats();  
    public void testForceExecutionOnCoordinating() {
            assertEquals(1024 * 8, indexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(preForceRejections, indexingPressure.stats().getPrimaryRejections());
            assertEquals(35, stats.getCurrentReplicaBytes());
        assertEquals(10, stats.getTotalCombinedCoordinatingAndPrimaryBytes());
    }
        ) {
    }  
            // Primary can be forced
        }
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(10, false);
            assertEquals(1, indexingPressure.stats().getReplicaRejections());
            assertEquals(15, stats.getCurrentPrimaryBytes());
            assertEquals(1024 * 14, indexingPressure.stats().getCurrentReplicaBytes());
                );
            Releasable primary2 = indexingPressure.markPrimaryOperationStarted(5, false);
            assertEquals(preLocalStats.getPrimaryRejections(), indexingPressure.stats().getPrimaryRejections());
            Releasable primary = indexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(15)  
        try (
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(10, false);
        try (
            // Replica can be forced  
        assertEquals(0, stats.getCurrentReplicaBytes());
            assertEquals(20, stats.getCurrentPrimaryBytes());
        }  
            Releasable replica2 = indexingPressure.markReplicaOperationStarted(1024 * 11, false);
        assertEquals(1024 * 14, indexingPressure.stats().getTotalReplicaBytes());
 * KIND, either express or implied.  See the License for the
public class IndexingPressureTests extends OpenSearchTestCase {
            assertEquals(1024 * 11, indexingPressure.stats().getCurrentCoordinatingBytes());  
            IndexingPressureStats stats = indexingPressure.stats();
 * license agreements. See the NOTICE file distributed with
        assertEquals(0, indexingPressure.stats().getCurrentCoordinatingBytes());
            }  
        ) {
        assertEquals(35, stats.getTotalReplicaBytes());
        assertEquals(80, stats.getTotalCombinedCoordinatingAndPrimaryBytes());
            Releasable coordinating = indexingPressure.markCoordinatingOperationStarted(1024 * 3, false);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
            local.close();
        IndexingPressure indexingPressure = new IndexingPressure(settings);  
                assertEquals(1, stats.getPrimaryRejections());
            assertEquals(1024 * 6, indexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());  
        IndexingPressure indexingPressure = new IndexingPressure(settings);
            assertEquals(1024 * 14, indexingPressure.stats().getCurrentReplicaBytes());  
            Releasable replica = indexingPressure.markReplicaOperationStarted(25, true);  
/*
            Releasable replica = indexingPressure.markReplicaOperationStarted(1024 * 3, false)
                    () -> indexingPressure.markCoordinatingOperationStarted(1024 * 2, false)
            assertEquals(1024 * 14, stats.getCurrentReplicaBytes());
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final Settings settings = Settings.builder()  
        .build();  
            // Replica will not be rejected until replica bytes > 15KB  
            // Replica will be rejected once we cross 15KB  
 * SPDX-License-Identifier: Apache-2.0
            Releasable primary = indexingPressure.markPrimaryOperationStarted(1024 * 3, false);  
            assertEquals(80, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
}
    }  
            Releasable primary = indexingPressure.markPrimaryOperationStarted(15, true);
 */  
        ) {
        assertEquals(15, stats.getTotalPrimaryBytes());  
            assertEquals(10, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.stats.IndexingPressureStats;
 * The OpenSearch Contributors require contributions made to  
            forced.close();  
                    OpenSearchRejectedExecutionException.class,
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        try (Releasable ignore = indexingPressure.markCoordinatingOperationStarted(1024 * 11, true)) {
                expectThrows(
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
            assertEquals(1, stats.getReplicaRejections());  
            if (randomBoolean()) {
/*  
        IndexingPressureStats stats = indexingPressure.stats();
 *
            IndexingPressureStats stats = indexingPressure.stats();  
            Releasable local = indexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(1024 * 2);
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(0, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * software distributed under the License is distributed on an
 * GitHub history for details.
            forced.close();
        try (  
 * You may obtain a copy of the License at  
            assertEquals(10, stats.getCurrentCoordinatingBytes());  
        IndexingPressureStats stats = indexingPressure.stats();  
import org.opensearch.common.lease.Releasable;
        IndexingPressure indexingPressure = new IndexingPressure(settings);  
                assertEquals(1024 * 6, stats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            IndexingPressureStats stats = indexingPressure.stats();
