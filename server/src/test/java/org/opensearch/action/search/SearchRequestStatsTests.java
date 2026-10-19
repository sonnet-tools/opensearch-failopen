        when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
package org.opensearch.action.search;
        SearchPhaseContext mockSearchPhaseContext = mock(SearchPhaseContext.class);
import static org.mockito.Mockito.when;
            SearchPhaseContext ctx = mock(SearchPhaseContext.class);
                    testRequestStats.onPhaseStart(ctx);  
        assertEquals(1, testRequestStats.getTookCurrent());
        Thread[] threads = new Thread[numTasks * SearchPhaseName.values().length];
            assertEquals(numTasks, testRequestStats.getPhaseCurrent(searchPhaseName));  
        phaser.arriveAndAwaitAdvance();
            searchPhaseNameLongMap.put(searchPhaseName, tookTimeInMillis);
import org.opensearch.test.OpenSearchTestCase;
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
        SearchPhase mockSearchPhase = mock(SearchPhase.class);
        // Unrecognized phase names producing an empty optional should not throw any error and no stats should be incremented.  
import org.opensearch.common.settings.ClusterSettings;
                    countDownLatch.countDown();
            }
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
import java.util.concurrent.Phaser;
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
            assertEquals(1, testRequestStats.getPhaseCurrent(searchPhaseName));
                    phaser.arriveAndAwaitAdvance();
            @Override
                () -> null
        assertThat(testRequestStats.getTookMetric(), greaterThanOrEqualTo(tookTimeInMillis));  
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);  
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
    }
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        }  
        }  
        // Start request
                threads[i] = new Thread(() -> {  
        CountDownLatch countDownLatch = new CountDownLatch(numTasks * SearchPhaseName.values().length);
import java.util.List;
    public void testSearchRequestStats_OnRequestFailure() {
            assertThat(testRequestStats.getPhaseMetric(searchPhaseName), greaterThanOrEqualTo(tookTimeInMillis));
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        testRequestStats.onRequestEnd(mockSearchPhaseContext, mockSearchRequestContext);  
                    new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        Phaser phaser = new Phaser(numTasks * SearchPhaseName.values().length + 1);
            for (int i = 0; i < numTasks; i++) {  
            }
        int numTasks = randomIntBetween(5, 50);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertEquals(numTasks, testRequestStats.getPhaseTotal(searchPhaseName));
            SearchPhaseContext ctx = mock(SearchPhaseContext.class);
        // Test search phases with unrecognized names return Optional.empty() when getSearchPhaseNameOptional() is called.
        SearchPhaseContext mockSearchPhaseContext = mock(SearchPhaseContext.class);
        SearchPhase dummyPhase = new SearchPhase(unrecognizedName) {
            SearchPhase mockSearchPhase = mock(SearchPhase.class);  
}  
        Thread[] threads = new Thread[numTasks * SearchPhaseName.values().length];
            testRequestStats.onPhaseStart(ctx);  
        countDownLatch.await();
        // Mock start time  
            when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
            assertEquals(0, testRequestStats.getPhaseCurrent(name));  
    public void testSearchRequestStats() {
        Thread[] threads = new Thread[numTasks * SearchPhaseName.values().length];
    }
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);
import static org.mockito.Mockito.mock;  
        // End request
            }
                    testRequestStats.onPhaseFailure(ctx, new Throwable());
                    new SearchRequest(),
        when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.empty());
        long tookTimeInMillis = randomIntBetween(1, 10);
        CountDownLatch countDownLatch = new CountDownLatch(numTasks * SearchPhaseName.values().length);  
            long tookTimeInMillis = randomIntBetween(1, 10);
        long startTimeInNanos = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(tookTimeInMillis);
        assertEquals(0, testRequestStats.getTookCurrent());
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);  
                greaterThanOrEqualTo((searchPhaseNameLongMap.get(searchPhaseName) * numTasks))
                    phaser.arriveAndAwaitAdvance();
                });  
        assertEquals(Optional.empty(), dummyPhase.getSearchPhaseNameOptional());
        testRequestStats.onRequestStart(mockSearchRequestContext);  
        Phaser phaser = new Phaser(numTasks * SearchPhaseName.values().length + 1);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new SearchRequestContext(
        int minTimeNanos = 10;  
        when(mockSearchRequestContext.getAbsoluteStartNanos()).thenReturn(startTimeInNanos);  
                ctx,
        countDownLatch.await();
        testRequestStats.onPhaseStart(ctx);
                        )
import java.util.concurrent.CountDownLatch;
            public void run() {}  
            testRequestStats.onPhaseFailure(ctx, new Throwable());
    public void testUnrecognizedSearchPhaseReturnsEmptyOptional() {  
            assertEquals(0, testRequestStats.getPhaseCurrent(searchPhaseName));  
    }
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
    public void testSearchRequestPhaseFailure() {  
    public void testSearchRequestStatsOnPhaseStartConcurrently() throws InterruptedException {  
        testRequestStats.onRequestStart(mockSearchRequestContext);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
            assertEquals(0, testRequestStats.getPhaseMetric(name));
                            new SearchRequest(),  
        phaser.arriveAndAwaitAdvance();
            testRequestStats.onPhaseEnd(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    phaser.arriveAndAwaitAdvance();
            );
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
                    () -> null  
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(startTime);
            assertEquals(0, testRequestStats.getPhaseTotal(name));
import java.util.Map;
                    );  
            ctx,  
        CountDownLatch countDownLatch = new CountDownLatch(numTasks * SearchPhaseName.values().length);  
                new SearchRequest(),  
        String unrecognizedName = "unrecognized_name";  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                        ctx,  
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);  
            testRequestStats.onPhaseStart(ctx);  
 *
        }  
        for (SearchPhaseName name : SearchPhaseName.values()) {
            )
        for (SearchPhaseName name : SearchPhaseName.values()) {
            SearchPhase mockSearchPhase = mock(SearchPhase.class);
    }  
                            () -> null
            long startTime = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(tookTimeInMillis);  
                });
        SearchRequestContext mockSearchRequestContext = mock(SearchRequestContext.class);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        testRequestStats.onRequestFailure(mockSearchPhaseContext, mockSearchRequestContext);  
        assertEquals(1, testRequestStats.getTookTotal());
    }
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
import java.util.Optional;  
import org.opensearch.common.settings.Settings;  
            assertEquals(1, testRequestStats.getPhaseTotal(searchPhaseName));
        long startTime = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(minTimeNanos);
            long tookTimeInMillis = randomIntBetween(1, 10);
        };
            for (int i = 0; i < numTasks; i++) {
            assertEquals(0, testRequestStats.getPhaseCurrent(name));
                    countDownLatch.countDown();
        assertEquals(unrecognizedName, dummyPhase.getName());  
                new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        int numTasks = randomIntBetween(5, 50);  
    public void testSearchRequestStatsOnPhaseFailureConcurrently() throws InterruptedException {  
            assertEquals(0, testRequestStats.getPhaseCurrent(searchPhaseName));  
        }
    public void testSearchRequestStatsOnPhaseEndConcurrently() throws InterruptedException {
                threads[i] = new Thread(() -> {
                });
        // These may exist, for example, "create_pit".
                threads[i] = new Thread(() -> {
        when(mockSearchPhase.getStartTimeInNanos()).thenReturn(startTime);
        SearchPhase mockSearchPhase = mock(SearchPhase.class);  
    }
 * compatible open source license.
            when(mockSearchPhase.getStartTimeInNanos()).thenReturn(startTime);
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
import java.util.concurrent.TimeUnit;  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
 */  
            for (int i = 0; i < numTasks; i++) {  
        );  
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertEquals(0, testRequestStats.getPhaseCurrent(searchPhaseName));
                threads[i].start();  
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
            when(mockSearchPhase.getSearchPhaseNameOptional()).thenReturn(Optional.of(searchPhaseName));
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals(0, testRequestStats.getTookCurrent());
        }  
                new SearchRequestContext(  
        }
                    testRequestStats.onPhaseEnd(
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        }
                    countDownLatch.countDown();
            SearchPhase mockSearchPhase = mock(SearchPhase.class);  
            assertThat(
 * this file be licensed under the Apache-2.0 license or a
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);  
                testRequestStats.getPhaseMetric(searchPhaseName),  
        assertEquals(0, testRequestStats.getTookTotal());
    public void testSearchRequestStats_OnRequestEnd() {
        Map<SearchPhaseName, Long> searchPhaseNameLongMap = new HashMap<>();
        int numTasks = randomIntBetween(5, 50);
public class SearchRequestStatsTests extends OpenSearchTestCase {  
                        new SearchRequestContext(
        phaser.arriveAndAwaitAdvance();  
            SearchPhaseContext ctx = mock(SearchPhaseContext.class);
                    testRequestStats.onPhaseStart(ctx);  
 * The OpenSearch Contributors require contributions made to  
                threads[i].start();
        SearchRequestContext mockSearchRequestContext = mock(SearchRequestContext.class);  
        }
        Phaser phaser = new Phaser(numTasks * SearchPhaseName.values().length + 1);
        SearchPhase mockSearchPhase = mock(SearchPhase.class);
        SearchRequestStats testRequestStats = new SearchRequestStats(clusterSettings);
        SearchPhaseContext ctx = mock(SearchPhaseContext.class);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import java.util.HashMap;  
        testRequestStats.onPhaseEnd(
        assertEquals(1, testRequestStats.getTookCurrent());
                            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            );
    public void testUnrecognizedPhaseNamesAreIgnored() {
                threads[i].start();  
                )
            long startTime = System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(tookTimeInMillis);
        when(ctx.getCurrentPhase()).thenReturn(mockSearchPhase);
        }  
    }  
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        countDownLatch.await();
        }  
            assertEquals(1, testRequestStats.getPhaseCurrent(searchPhaseName));  
/*  
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
import org.apache.logging.log4j.LogManager;
