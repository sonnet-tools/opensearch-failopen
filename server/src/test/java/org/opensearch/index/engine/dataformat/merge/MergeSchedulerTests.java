        Segment s2 = new Segment(2L, Map.of());
        MergeHandler mergeHandler = mock(MergeHandler.class);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        MergeScheduler scheduler = newScheduler(mergeHandler, IndexModule.TieringState.HOT);
        terminate(threadPool);  
        scheduler.triggerMerges();
import static org.mockito.Mockito.mock;
        // without needing a follow-up call), and the explicit triggerMerges() above adds a second
 * this file be licensed under the Apache-2.0 license or a
        schedulerRef.set(scheduler);
        verify(mergeHandler, times(2)).findAndRegisterMerges();
    }
    private IndexSettings indexSettings(IndexModule.TieringState tieringState) {
        scheduler.triggerMerges();  
import org.opensearch.index.engine.exec.Segment;  
    private ShardId shardId;
            Thread.currentThread().setName(oldName);
import java.util.Map;
    @Override
        );  
        // Frozen: the scheduler must not even ask the handler to find/register merges.
            shardId,  
    public void testForceMergeAbortsRemainingMergesOnShutdown() throws Exception {  
 * {@link MergeScheduler#freeze()} and the index's {@code INDEX_TIERING_STATE} setting.
import org.opensearch.common.settings.Settings;  
        return new MergeScheduler(mergeHandler, (result, merge) -> {}, () -> {}, shardId, indexSettings(tieringState), threadPool);  
            (result, merge) -> { schedulerRef.get().shutdown(); },
    }
import java.io.IOException;  
public class MergeSchedulerTests extends OpenSearchTestCase {
 *
import org.opensearch.Version;
/*  
import org.opensearch.cluster.metadata.IndexMetadata;
        } finally {
/**
        MergeScheduler scheduler = newScheduler(mergeHandler, IndexModule.TieringState.HOT);  
        super.setUp();
    @Override  
        return IndexSettingsModule.newIndexSettings(
import static org.mockito.ArgumentMatchers.anyInt;
import org.opensearch.threadpool.TestThreadPool;  
        OneMerge merge1 = new OneMerge(List.of(s1));
import org.opensearch.index.engine.dataformat.MergeResult;
        final java.util.concurrent.atomic.AtomicReference<MergeScheduler> schedulerRef =
        scheduler.freeze();
        assertTrue("HOT_TO_WARM tiering state must report frozen", scheduler.isFrozen());
import org.opensearch.core.index.Index;
            () -> {},
                .put(IndexModule.INDEX_TIERING_STATE.getKey(), tieringState.name())  
 * Unit tests for the tiering freeze semantics of {@link MergeScheduler}: when frozen, no new merges  
    public void testUnfreezeAllowsMergesAgain() {
    public void testIsFrozenReflectsHotToWarmTieringState() {
                .build()
    }
import org.opensearch.test.OpenSearchTestCase;
    public void testFreezeBlocksTriggerMerges() {  
        try {
        scheduler.shutdown();
        MergeHandler mergeHandler = mock(MergeHandler.class);
        verify(mergeHandler, never()).findAndRegisterMerges();
        Thread.currentThread().setName("TEST-" + ThreadPool.Names.FORCE_MERGE + "-0");
 */  
        Segment s1 = new Segment(1L, Map.of());  
            scheduler.forceMerge(1);
        verify(mergeHandler, never()).findAndRegisterMerges();  
        verify(mergeHandler, times(1)).findAndRegisterMerges();
import static org.mockito.Mockito.times;
 */  
import org.opensearch.test.IndexSettingsModule;
        MergeHandler mergeHandler = mock(MergeHandler.class);
    private ThreadPool threadPool;  
        scheduler.freeze();  
        OneMerge merge2 = new OneMerge(List.of(s2));  
        when(mergeHandler.findForceMerges(1)).thenReturn(List.of(merge1, merge2));
    public void testTriggerMergesWhenNotFrozenInvokesHandler() {  
            indexSettings(IndexModule.TieringState.HOT),
    }
        super.tearDown();
import static org.mockito.Mockito.verify;
        MergeHandler mergeHandler = mock(MergeHandler.class);
        MergeScheduler scheduler = newScheduler(mergeHandler, IndexModule.TieringState.HOT);
        MergeHandler mergeHandler = mock(MergeHandler.class);
        when(mergeHandler.hasPendingMerges()).thenReturn(false);  
        MergeHandler mergeHandler = mock(MergeHandler.class);
        verify(mergeHandler, never()).doMerge(merge2);  
            mergeHandler,  
            scheduler.forceMerge(1);  
 * The OpenSearch Contributors require contributions made to  
        threadPool = new TestThreadPool(getClass().getName());
    public void testForceMergeSkipsAfterShutdown() throws IOException {
    }
        scheduler.triggerMerges();
        );
        assertFalse("HOT tiering state must not report frozen", scheduler.isFrozen());
import static org.mockito.Mockito.when;  
        verify(mergeHandler).doMerge(merge1);
    }  
        // unfreeze() itself fires triggerMerges() on a real frozen→unfrozen transition (resumes merges
        // invocation. Hence findAndRegisterMerges is invoked twice.  
        MergeScheduler scheduler = new MergeScheduler(
        } finally {
        verify(mergeHandler, never()).findForceMerges(anyInt());  
    public void setUp() throws Exception {
    }
        }
    private MergeScheduler newScheduler(MergeHandler mergeHandler, IndexModule.TieringState tieringState) {
        assertFalse("scheduler must not be frozen for a HOT index", scheduler.isFrozen());
}
package org.opensearch.index.engine.dataformat.merge;
    }
        scheduler.unfreeze();
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.IndexSettings;
 * may be triggered or force-merged, and the frozen state is derived from both an explicit
    }
        try {  
import org.opensearch.core.index.shard.ShardId;
        MergeScheduler scheduler = newScheduler(mergeHandler, IndexModule.TieringState.HOT);  
        Thread.currentThread().setName("TEST-" + ThreadPool.Names.FORCE_MERGE + "-0");
        String oldName = Thread.currentThread().getName();
            threadPool
    public void testIsNotFrozenForHotTieringState() {
import org.opensearch.index.IndexModule;  
            Thread.currentThread().setName(oldName);  
        String oldName = Thread.currentThread().getName();  
import static org.mockito.Mockito.never;  
        }  
            new java.util.concurrent.atomic.AtomicReference<>();  
        assertFalse("scheduler must report unfrozen after unfreeze()", scheduler.isFrozen());
        MergeScheduler scheduler = newScheduler(mergeHandler, IndexModule.TieringState.HOT);  
 * compatible open source license.
        when(mergeHandler.hasPendingMerges()).thenReturn(false);
    }
        MergeHandler mergeHandler = mock(MergeHandler.class);
    public void tearDown() throws Exception {
        scheduler.triggerMerges();  
 * SPDX-License-Identifier: Apache-2.0
            "test",  
            Settings.builder()
        MergeScheduler scheduler = newScheduler(mergeHandler, IndexModule.TieringState.HOT_TO_WARM);  
        shardId = new ShardId(new Index("test", "_na_"), 0);  
import java.util.List;
        when(mergeHandler.doMerge(merge1)).thenReturn(new MergeResult(Map.of()));  
    }
        assertTrue("scheduler must report frozen after freeze()", scheduler.isFrozen());
