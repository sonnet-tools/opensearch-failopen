import java.util.Map;
                testRequestStats.getPhaseMetric(searchPhaseName),
    }
    public void testSearchRequestStatsOnPhaseStartConcurrently() throws InterruptedException {
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        phaser.arriveAndAwaitAdvance();
        int numTasks = randomIntBetween(5, 50);
                () -> null
/*
                threads[i] = new Thread(() -> {
                        new SearchRequestContext(
                new SearchRequest(),
        }
package org.opensearch.action.search;
            testRequestStats.onPhaseStart(ctx);
            long tookTimeInMillis = randomIntBetween(1, 10);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        }
                threads[i] = new Thread(() -> {
            }
    public void testUnrecognizedPhaseNamesAreIgnored() {
import java.util.HashMap;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            }
            assertEquals(numTasks, testRequestStats.getPhaseTotal(searchPhaseName));
            assertEquals(0, testRequestStats.getPhaseCurrent(name));
                    phaser.arriveAndAwaitAdvance();
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        testRequestStats.onPhaseStart(ctx);
            for (int i = 0; i < numTasks; i++) {
    }
                });
        SearchRequestContext mockSearchRequestContext = mock(SearchRequestContext.class);
                ctx,
import org.apache.logging.log4j.LogManager;
            assertThat(testRequestStats.getPhaseMetric(searchPhaseName), greaterThanOrEqualTo(tookTimeInMillis));
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
import static org.mockito.Mockito.when;
        testRequestStats.onPhaseEnd(
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        int numTasks = randomIntBetween(5, 50);
        when(mockSearchRequestContext.getAbsoluteStartNanos()).thenReturn(startTimeInNanos);
        countDownLatch.await();
        when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.empty());
import static org.mockito.Mockito.mock;
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
                    countDownLatch.countDown();
        for (SearchPhaseName name : SearchPhaseName.values()) {
}
        }
        SearchPhase mockSearchPhase = mock(SearchPhase.class);
        // Unrecognized phase names producing an empty optional should not throw any error and no stats should be incremented.
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(startTime);
import java.util.Optional;
    }
            SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertEquals(0, testRequestStats.getPhaseCurrent(searchPhaseName));
    public void testSearchRequestStats() {
    public void testSearchRequestPhaseFailure() {
                threads[i].start();
                    testRequestStats.onPhaseEnd(
        SearchRequestContext mockSearchRequestContext = mock(SearchRequestContext.class);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
    }
 *
            assertEquals(0, testRequestStats.getPhaseCurrent(searchPhaseName));
        // Start request
        }
            long tookTimeInMillis = randomIntBetween(1, 10);
            new SearchRequestContext(
        long startTime = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(minTimeNanos);
        SearchPhase dummyPhase = new SearchPhase(unrecognizedName) {
            assertEquals(numTasks, testRequestStats.getPhaseCurrent(searchPhaseName));
import java.util.concurrent.TimeUnit;
                            () -> null
            SearchPhaseContext ctx = mock(SearchPhaseContext.class);
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
            testRequestStats.onPhaseFailure(ctx, new Throwable());
                    phaser.arriveAndAwaitAdvance();
                    testRequestStats.onPhaseStart(ctx);
        SearchPhaseContext mockSearchPhaseContext = mock(SearchPhaseContext.class);
                        )
                    testRequestStats.onPhaseStart(ctx);
        }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertEquals(1, testRequestStats.getPhaseCurrent(searchPhaseName));
            testRequestStats.onPhaseEnd(
    public void testSearchRequestStatsOnPhaseFailureConcurrently() throws InterruptedException {
            assertEquals(1, testRequestStats.getPhaseTotal(searchPhaseName));
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        };
import org.opensearch.common.settings.ClusterSettings;
 * compatible open source license.
        assertEquals(0, testRequestStats.getTookTotal());
 * SPDX-License-Identifier: Apache-2.0
            @Override
    public void testSearchRequestStats_OnRequestEnd() {
        Phaser phaser = new Phaser(numTasks * SearchPhaseName.values().length + 1);
        }
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        }
            );
                    countDownLatch.countDown();
        Thread[] threads = new Thread[numTasks * SearchPhaseName.values().length];
        assertEquals(Optional.empty(), dummyPhase.getSearchPhaseNameOptional());
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(startTime);
    }
        for (SearchPhaseName name : SearchPhaseName.values()) {
            for (int i = 0; i < numTasks; i++) {
                greaterThanOrEqualTo((searchPhaseNameLongMap.get(searchPhaseName) * numTasks))
            assertEquals(0, testRequestStats.getPhaseMetric(name));
            ctx,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(testRequestStats.getTookMetric(), greaterThanOrEqualTo(tookTimeInMillis));
                    () -> null
    public void testSearchRequestStatsOnPhaseEndConcurrently() throws InterruptedException {
            assertEquals(0, testRequestStats.getPhaseCurrent(name));
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
        testRequestStats.onRequestFailure(mockSearchPhaseContext, mockSearchRequestContext);
            )
            assertThat(
        Map<SearchPhaseName, Long> searchPhaseNameLongMap = new HashMap<>();
        // Test search phases with unrecognized names return Optional.empty() when getSearchPhaseNameOptional() is called.
        assertEquals(0, testRequestStats.getTookCurrent());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                threads[i].start();
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
                    new SearchRequest(),
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
            SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        assertEquals(1, testRequestStats.getTookCurrent());
                });
        Thread[] threads = new Thread[numTasks * SearchPhaseName.values().length];
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < numTasks; i++) {
            assertEquals(0, testRequestStats.getPhaseCurrent(searchPhaseName));
                    );
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
import java.util.concurrent.Phaser;
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
        long tookTimeInMillis = randomIntBetween(1, 10);
        countDownLatch.await();
        }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                threads[i] = new Thread(() -> {
            searchPhaseNameLongMap.put(searchPhaseName, tookTimeInMillis);
                    testRequestStats.onPhaseFailure(ctx, new Throwable());
        when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
        );
        // End request
        }
import org.opensearch.common.settings.Settings;
                            new SearchRequest(),
        CountDownLatch countDownLatch = new CountDownLatch(numTasks * SearchPhaseName.values().length);
        // These may exist, for example, "create_pit".
        testRequestStats.onRequestStart(mockSearchRequestContext);
            testRequestStats.onPhaseStart(ctx);
        testRequestStats.onRequestEnd(mockSearchPhaseContext, mockSearchRequestContext);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
public class SearchRequestStatsTests extends OpenSearchTestCase {
        Phaser phaser = new Phaser(numTasks * SearchPhaseName.values().length + 1);
        SearchPhase mockSearchPhase = mock(SearchPhase.class);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
    public void testSearchRequestStats_OnRequestFailure() {
            public void run() {}
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
            );
                )
        Thread[] threads = new Thread[numTasks * SearchPhaseName.values().length];
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
    public void testUnrecognizedSearchPhaseReturnsEmptyOptional() {
        int minTimeNanos = 10;
                            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
    }
                        ctx,
        assertEquals(1, testRequestStats.getTookTotal());
        SearchPhaseContext mockSearchPhaseContext = mock(SearchPhaseContext.class);
            }
            long startTime = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(tookTimeInMillis);
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
        when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
    }
                    phaser.arriveAndAwaitAdvance();
        // Mock start time
        }
                new SearchRequestContext(
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
            assertEquals(1, testRequestStats.getPhaseCurrent(searchPhaseName));
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
        SearchPhase mockSearchPhase = mock(SearchPhase.class);
                threads[i].start();
        long startTimeInNanos = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(tookTimeInMillis);
    }
        countDownLatch.await();
    }
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        testRequestStats.onRequestStart(mockSearchRequestContext);
                });
        assertEquals(unrecognizedName, dummyPhase.getName());
        assertEquals(0, testRequestStats.getTookCurrent());
        String unrecognizedName = "unrecognized_name";
        phaser.arriveAndAwaitAdvance();
 * The OpenSearch Contributors require contributions made to
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        when(mockSearchPhase.getStartTimeInNanos()).thenReturn(startTime);
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
        Phaser phaser = new Phaser(numTasks * SearchPhaseName.values().length + 1);
        phaser.arriveAndAwaitAdvance();
            assertEquals(0, testRequestStats.getPhaseTotal(name));
import java.util.concurrent.CountDownLatch;
        CountDownLatch countDownLatch = new CountDownLatch(numTasks * SearchPhaseName.values().length);
        CountDownLatch countDownLatch = new CountDownLatch(numTasks * SearchPhaseName.values().length);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.test.OpenSearchTestCase;
import java.util.List;
        int numTasks = randomIntBetween(5, 50);
        assertEquals(1, testRequestStats.getTookCurrent());
 */
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
            long startTime = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(tookTimeInMillis);
                    countDownLatch.countDown();
