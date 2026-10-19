 */  
        }
        RepositoriesStatsArchive repositoriesStatsArchive = new RepositoriesStatsArchive(
        assertTrue(repositoriesStatsArchive.archive(createRepositoryStats(RepositoryStats.EMPTY_STATS)));
        int retentionTimeInMillis = randomIntBetween(100, 1000);
        assertThat(archivedStats.size(), equalTo(statsToBeRetainedCount));
        fakeRelativeClock.set(retentionTimeInMillis * 2);
import org.opensearch.common.unit.TimeValue;
            TimeValue.timeValueMillis(retentionTimeInMillis),
import org.opensearch.test.OpenSearchTestCase;
/*  
        AtomicLong fakeRelativeClock = new AtomicLong();
    }
 */  
 * software distributed under the License is distributed on an
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;
            RepositoryStatsSnapshot repoStats = createRepositoryStats(RepositoryStats.EMPTY_STATS);
            fakeRelativeClock::get
 * under the License.  
            randomAlphaOfLength(10),
        List<RepositoryStatsSnapshot> archivedStats = repositoriesStatsArchive.getArchivedStats();  
        int statsToBeRetainedCount = randomInt(10);  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
package org.opensearch.repositories;
            fakeRelativeClock::get
import java.util.Map;
        for (int i = 0; i < archivedStatsWithVersionZero; i++) {  
import java.util.List;
    private RepositoryStatsSnapshot createRepositoryStats(RepositoryStats repositoryStats, long clusterVersion) {
        }
    }
 *
    public void testStatsAreRejectedIfTheArchiveIsFull() {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
    }
        int archivedStatsWithVersionZero = randomIntBetween(1, 20);
        for (int i = 0; i < archivedStatsWithNewerVersion; i++) {
        for (RepositoryStatsSnapshot repositoryStatsSnapshot : archivedStats) {
        fakeRelativeClock.set(retentionTimeInMillis * 2);
            repositoriesStatsArchive.archive(repoStats);
        // Now there's room since the previous stats should be evicted
/*
            TimeValue.timeValueMillis(retentionTimeInMillis),  
            TimeValue.timeValueMillis(retentionTimeInMillis),  
 * this file be licensed under the Apache-2.0 license or a
            100,
    }
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 *
        int retentionTimeInMillis = randomIntBetween(100, 1000);  
        RepositoryInfo repositoryInfo = new RepositoryInfo(
        // There's no room for stats with the same creation time
        );  
            100,
        assertThat(repositoriesStatsArchive.getArchivedStats().size(), equalTo(archivedStatsWithNewerVersion));  
        }
        for (int i = 0; i < randomInt(10); i++) {  
        assertThat(removedStats.size(), equalTo(archivedStatsWithVersionZero));
            assertThat(repositoryStatsSnapshot.getRepositoryStats().requestCounts, equalTo(Map.of("GET", 10L)));  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(repositoriesStatsArchive.archive(createRepositoryStats(RepositoryStats.EMPTY_STATS)));
        return new RepositoryStatsSnapshot(repositoryInfo, repositoryStats, clusterVersion);
            RepositoryStatsSnapshot repoStats = createRepositoryStats(new RepositoryStats(Map.of("GET", 10L)));
        return createRepositoryStats(repositoryStats, 0);
}
        RepositoriesStatsArchive repositoriesStatsArchive = new RepositoriesStatsArchive(
    }  
        int archivedStatsWithNewerVersion = randomIntBetween(1, 20);
        );
 *  
 */
        List<RepositoryStatsSnapshot> removedStats = repositoriesStatsArchive.clear(0L);  
        for (int i = 0; i < statsToBeRetainedCount; i++) {
            repositoriesStatsArchive.archive(repoStats);  
            repositoriesStatsArchive.archive(createRepositoryStats(RepositoryStats.EMPTY_STATS, 1));  
        }  
            randomAlphaOfLength(10),  
    public void testClearArchive() {
    public void testStatsAreEvictedOnceTheyAreOlderThanRetentionPeriod() {
 * GitHub history for details.
            fakeRelativeClock::get  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
        );  
 * not use this file except in compliance with the License.
            Map.of("bucket", randomAlphaOfLength(10))
            repositoriesStatsArchive.archive(createRepositoryStats(RepositoryStats.EMPTY_STATS, 0));
    private RepositoryStatsSnapshot createRepositoryStats(RepositoryStats repositoryStats) {  
 * license agreements. See the NOTICE file distributed with
/*  
        );  
        }
        int retentionTimeInMillis = randomIntBetween(100, 1000);  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.atomic.AtomicLong;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AtomicLong fakeRelativeClock = new AtomicLong();
 * The OpenSearch Contributors require contributions made to  
public class RepositoriesStatsArchiveTests extends OpenSearchTestCase {
        RepositoriesStatsArchive repositoriesStatsArchive = new RepositoriesStatsArchive(  
            1,
        AtomicLong fakeRelativeClock = new AtomicLong();
        assertTrue(repositoriesStatsArchive.archive(createRepositoryStats(RepositoryStats.EMPTY_STATS)));  
