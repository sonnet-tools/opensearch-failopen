        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        assertNotNull(retrieved);
        assertFalse("Expected merge candidates from 15 small segments", merges.isEmpty());
    // ========== doMerge: missing rowIdMapping throws IllegalStateException ==========
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
    private Merger secondaryMerger;
        WriterFileSet pWfs = wfs(tempDir, generation, Set.of("p" + generation + ".dat"), numRows);
import org.opensearch.Version;
        // Fail-fast: only the first secondary failure is reported, no suppressed exceptions
    public void testMergeSuppressesCloseFailureOntoOriginalError() throws IOException {
    /** A failing close() is suppressed onto the original merge failure, not thrown in its place. */
        executor.execute(plan);
    public void testDoMergeSingleSecondaryFailureThrowsUncheckedIOException() throws IOException {
        return Segment.builder(generation).addSearchableFiles(fmt1, wfs1).addSearchableFiles(fmt2, wfs2).build();
        OneMerge oneMerge = new OneMerge(List.of(segment));
            mock(MergeHandler.MergeListener.class),
        WriterFileSet mergedS = wfs(tempDir, 99L, Set.of("ms.dat"), 1);
    private CompositeDataFormat compositeDataFormat;
        // The merge fails due to secondary, cleanup tries to delete "mp.dat" (a non-empty dir)
     * secondary advertised as the live-docs producer. Must run AFTER any providesMergeLiveDocs
import static org.mockito.Mockito.doReturn;
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        Settings settings = Settings.builder()
        Files.createDirectory(dirAsFile);
        assertEquals(2, result.getMergedWriterFileSet().size());
    }
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
        return new DataFormat() {
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        CompositeMergeExecutor executor = new CompositeMergeExecutor(Map.of(primary, primaryMerger, secondary, secondaryMerger));
            .addSearchableFiles(primaryFormat, pWfs)
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        verify(secondaryMerger, never()).merge(any());
        assertTrue(ex.getMessage().contains("snapshot unavailable"));
    }
    /** A MergePreparation mock that reports the given bitmap; close() is left for the test to verify. */
            segments.add(Segment.builder(i).addSearchableFiles(primaryFormat, pWfs).build());
    public void testExecutorThrowsOnRowCountMismatch() throws IOException {
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();
            SHARD_ID,
    // ========== doMerge: cleanup on failure deletes stale files ==========
        verify(secondaryMerger, times(1)).merge(any());
    private CompositeMerger createCompositeMerger() {
    }
import static org.mockito.Mockito.never;
    public void testCleanupStaleMergedFilesLogsExceptionOnDeleteFailure() throws IOException {
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
    // ========== findForceMerges with merge candidates ==========
        assertSame(primaryMerger, executor.getMerger(primaryFormat));
 */
import static org.mockito.Mockito.doThrow;
        assertSame(mergedPrimaryWfs, result.getMergedWriterFileSetForDataformat(primaryFormat));
        CompositeDataFormat dupFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat));
        assertTrue(ex.getMessage().contains("Row count mismatch"));
        doReturn(primaryEngine).when(multiEngine).getPrimaryDelegate();
        when(primaryMerger.merge(any())).thenThrow(new IOException("primary disk error"));
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        doReturn(Set.of(duplicateEngine)).when(dupEngine).getSecondaryDelegates();
        );
        // The executor wraps the primary IOException in an UncheckedIOException; try-with-resources
        assertTrue(plan.hasSecondaries());
import org.opensearch.index.IndexSettings;
        // The duplicate secondary has the same DataFormat as primary, so it should be skipped
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
        when(secondaryMerger.prepareMerge(any())).thenReturn(MergePreparation.EMPTY);
    }
    }
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> executor.execute(plan));
        RuntimeException ex = expectThrows(RuntimeException.class, handler::findMerges);
        OneMerge oneMerge = new OneMerge(List.of(segment));
            10L,
    }
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 5)));
        merger.merge(mergeInputFor(segment));
            .getSecondaryDelegates();
        };
        Segment segment = defaultSegment(tempDir, 1L, 3);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertNull(executor.getMerger(stubFormat("unknown")));
        Path tempDir = createTempDir();
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
    public void testFindMergesReturnsMergeCandidates() throws IOException {
        // Force merge down to 1 segment should produce candidates
            if (suppressed.getMessage() != null && suppressed.getMessage().contains(message)) {
import org.opensearch.index.engine.dataformat.merge.OneMerge;
        assertSame(prepared, result);
        assertEquals("primary disk error", ex.getCause().getMessage());
    private CompositeIndexingExecutionEngine compositeEngine;
        assertEquals(0, ex.getCause().getSuppressed().length);
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        WriterFileSet mergedP = wfs(tempDir, 10L, Set.of("out.parquet"), 2);
        Collection<OneMerge> merges = handler.findForceMerges(1);
        ArgumentCaptor<MergeInput> primaryCaptor = ArgumentCaptor.forClass(MergeInput.class);
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
        assertTrue(ex.getMessage().contains("snapshot unavailable"));
import java.nio.file.Path;
        Path tempDir = createTempDir();
        CompositeIndexingExecutionEngine engineNoSecondary = mock(CompositeIndexingExecutionEngine.class);
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));
            snapshotSupplier,
        doReturn(Set.of(mockEngine(secondaryFormat, secondaryMerger), mockEngine(secondaryFormat2, secondaryMerger2))).when(multiEngine)
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
            new CompositeMerger(multiEngine, multiFormat),
    }
        CompositeDataFormat multiFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat, secondaryFormat, secondaryFormat2));
        MergePreparation prepared = preparationOf(frozen);
        assertTrue(handler.hasPendingMerges());
        when(primaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of(primary, primaryFiles), mapping));
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
    }
        MergeHandler handler = createHandler();
            }
import org.opensearch.index.engine.dataformat.RowIdMapping;
        // Create a directory with the same name as the file to delete — deleteIfExists on a
        // Even an assertion failure inside the try block releases the prepared state.
    }
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> handler.doMerge(oneMerge));
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        Files.createFile(dirAsFile.resolve("child.txt"));
        assertTrue(err.getMessage(), err.getMessage().contains("parquet"));
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(List.of(segment));
    }
    // ========== doMerge: successful primary + secondary ==========
        WriterFileSet sWfs2 = wfs(tempDir, 2L, Set.of("s2.dat"), 5);
        DataFormat secondaryFormat2 = stubFormat("arrow");
        WriterFileSet mergedS = wfs(tempDir, 99L, Set.of("ms.dat"), 3);
    /** merge() forwards the frozen bitmap from the producer's preparation to every format's MergeInput. */
        assertFalse(handler.hasPendingMerges());
        expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
import org.opensearch.test.OpenSearchTestCase;
    }
    }
        MergePlan plan = MergePlan.from(oneMerge, primaryFormat, List.of(secondaryFormat), 10L, liveDocs);
    private static DataFormat stubFormat(String name, long priority) {
import org.opensearch.cluster.metadata.IndexMetadata;
                return name;
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        return new CompositeMerger(compositeEngine, compositeDataFormat);
    }
        verify(secondaryMerger, never()).prepareMerge(any());
    }
        Throwable root = ex instanceof java.io.UncheckedIOException && ex.getCause() != null ? ex.getCause() : ex;
        // suppresses the close failure onto whatever throwable escaped the execute phase.
        WriterFileSet mergedWfs = wfs(tempDir, 50L, Set.of("merged.dat"), 5);
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 5)));
        assertTrue(Files.exists(dirAsFile));
        assertEquals("primary fail", ex.getCause().getMessage());
            Path file = tempDir.resolve("seg" + i + ".dat");
        when(secondaryMerger.merge(any())).thenReturn(secondaryResult);
    }
        Segment segment = defaultSegment(tempDir, 1L, 3);
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(segments);
    // ========== findForceMerges ==========
        Path tempDir = createTempDir();
        handler.registerMerge(oneMerge);
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
        Path tempDir = createTempDir();
        // The directory should still exist since deleteIfExists fails on non-empty dirs
        Merger primaryMerger = mock(Merger.class);
    @Override
        WriterFileSet mergedSecondaryWfs = wfs(tempDir, 99L, Set.of("ms.dat"), 10);
        OneMerge oneMerge = new OneMerge(List.of(segment));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testExecutorThrowsWhenSecondaryReturnsNullButPrimaryHasOutput() throws IOException {
        assertTrue(err.getMessage(), err.getMessage().contains("live-docs"));
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
            }
    /** prepareMerge with a producer reporting no deletes surfaces an all-alive view. */
            Files.write(file, new byte[100]);
    // ── MergePlan liveDocs propagation ──
        when(multiEngine.getNextWriterGeneration()).thenReturn(99L);
        assertSame(frozen, result.liveDocs());
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        verify(primaryMerger).merge(primaryCaptor.capture());
        return MergeInput.builder().segments(List.of(segments)).newWriterGeneration(99L).build();
    }
            SHARD_ID,
        MergeResult result = handler.doMerge(oneMerge);
        return preparation;
import org.opensearch.index.engine.exec.WriterFileSet;
        }
        for (int i = 0; i < 15; i++) {
import org.mockito.ArgumentCaptor;
        // Primary result without rowIdMapping
            policy,
    public void testDoMergeCleanupDeletesStaleMergedFilesOnFailure() throws IOException {
    }
        MergeHandler handler = new MergeHandler(
            10L,
        doReturn(Set.of(secondaryEngine)).when(compositeEngine).getSecondaryDelegates();
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
import org.opensearch.common.settings.Settings;
        primaryMerger = mock(Merger.class);
        OneMerge oneMerge = new OneMerge(List.of(segment));
    public void testMergeAssertsOnUndersizedLiveDocsBitmap() throws IOException {
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
    @SuppressWarnings("unchecked")
        Path tempDir = createTempDir();
 * SPDX-License-Identifier: Apache-2.0
        when(multiEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
    }
        assertTrue(handler.hasPendingMerges());
        RuntimeException ex = expectThrows(RuntimeException.class, () -> handler.findForceMerges(1));
        OneMerge oneMerge = new OneMerge(List.of(segment));
    }
        MergeHandler handler = createHandler();
    // ========== doMerge: primary only (no secondaries) ==========
package org.opensearch.composite.merge;
import org.opensearch.index.engine.dataformat.merge.DataFormatAwareMergePolicy;
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        CompositeIndexingExecutionEngine multiEngine = mock(CompositeIndexingExecutionEngine.class);
        assertTrue(ex.getMessage().contains("returned null"));
import org.opensearch.core.index.shard.ShardId;
        when(multiEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 5)));
            mock(MergeHandler.MergeListener.class),
import static org.mockito.Mockito.times;
        MergeHandler handler = createHandler();
            mock(MergeHandler.MergePolicy.class),
    private DataFormat primaryFormat;
        CompositeIndexingExecutionEngine dupEngine = mock(CompositeIndexingExecutionEngine.class);
        assertNotNull(result);
        assertNotNull(ex.getCause());
        assertTrue(Files.exists(staleFile));
        Merger primaryMerger = mock(Merger.class);
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
    public void testRegisterMergeAndOnMergeFinished() {
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
    private Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier;
        CompositeMergeExecutor executor = new CompositeMergeExecutor(Map.of(primaryFormat, primaryMerger));
        when(secondaryMerger.merge(any())).thenReturn(secondaryResult);
        assertEquals("secondary disk error", ex.getCause().getMessage());
        OneMerge oneMerge = new OneMerge(List.of(segment));
        Path tempDir = createTempDir();
            new CompositeMerger(compositeEngine, compositeDataFormat),
        WriterFileSet inputS = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.si"), 50, 1L);
        when(secondaryMerger.merge(any())).thenThrow(new IOException("secondary disk error"));
        assertTrue(ex.getMessage().contains("row-ID mapping"));
    }
            SHARD_ID,
        return new WriterFileSet(dir.toString(), gen, files, numRows, 0L);
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        assertTrue(err.getMessage(), err.getMessage().contains("Multiple secondary formats provide merge live-docs"));
 */
    // ========== Helper methods ==========
    // ========== doMerge: single secondary failure ==========
public class CompositeMergerTests extends OpenSearchTestCase {
        MergeHandler handler = createHandler();
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
            primary,
        DataFormat secondaryFormat2 = stubFormat("arrow");
        handler.onMergeFailure(oneMerge);
    public void testDoMergeNoCleanupWhenPrimaryFails() throws IOException {
        String dir = createTempDir().toString();
    public void testConstructorRejectsMultipleLiveDocsProducers() {
        when(engine.getDataFormat()).thenReturn(format);
     * Returns a CompositeMerger built from the default primary+secondary test engines, with the
        MergeResult secondaryResult = new MergeResult(Map.of(secondaryFormat, mergedSecondaryWfs));
            mock(MergeHandler.MergePolicy.class),
        CompositeMergeExecutor executor = new CompositeMergeExecutor(Map.of(primary, primaryMerger, secondary, secondaryMerger));
        Merger secondaryMerger2 = mock(Merger.class);
import org.opensearch.composite.CompositeIndexingExecutionEngine;
        Merger secondaryMerger = mock(Merger.class);
        };
        compositeDataFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat, secondaryFormat));
    public void testDoMergeMultipleSecondariesFailsFastOnFirstError() throws IOException {
            @Override
        List<Segment> segments = new java.util.ArrayList<>();
    }
        when(compositeEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
    public void testGetNextMergeReturnsMergeAfterRegister() {
            List.of(secondary),
    // ========== registerMerge / onMergeFinished / onMergeFailure ==========
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs));
    public void testGetNextMergeReturnsNullWhenEmpty() {
        return false;
        return new MergeHandler(
    public void testFindForceMergesReturnsMergeCandidates() throws IOException {
        assertEquals(1, plan.filesFor(secondaryFormat).size());
            public String toString() {
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
    }
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        Path staleFile = tempDir.resolve("mp.dat");
    }
        MergeHandler handler = createHandler();
        LiveDocs frozen = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
    private Segment defaultSegment(Path tempDir, long generation, long numRows) {
        assertTrue(captor.getValue().liveDocs().allAlive());
        assertEquals(1, result.getMergedWriterFileSet().size());
        Segment segment = Segment.builder(0L)
    public void testExecutorPassesPlanLiveDocsIntoMergeInput() throws IOException {
    }
    public void testFindMergesThrowsOnSnapshotFailure() {
            public String name() {
        assertArrayEquals(new long[] { 0b101L }, primaryCaptor.getValue().getLiveDocsForSegment(1L));
        Path dirAsFile = tempDir.resolve("mp.dat");
        MergeHandler handler = new MergeHandler(
        assertSame(secondaryMerger, executor.getMerger(secondaryFormat));
            containsSuppressed(ex, "close failure") || containsSuppressed(root, "close failure")
    }
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        // in the secondary loop. We use the same primaryMerger for both to avoid NPE in the
        MergeHandler handler = createHandler();
            }
        Segment segment = defaultSegment(tempDir, 1L, 100);
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        assertSame(MergePreparation.EMPTY, result);
        when(primaryMerger.merge(any())).thenThrow(new IOException("primary fail"));
    }
        MergePreparation prepared = preparationOf(frozen);
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(List.of(segment));
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
    }
        return new MergeHandler(
        assertNotNull(result);
        assertTrue(ex.getMessage().contains("primary exploded") || ex.getCause().getMessage().contains("primary exploded"));
    private static IndexingExecutionEngine<?, ?> mockEngine(DataFormat format, Merger merger) {
import java.io.IOException;
    /** When the primary merge fails after prepare, the producer's preparation is closed (state released). */
        when(preparation.liveDocs()).thenReturn(liveDocs);
        IndexingExecutionEngine<DataFormat, ?> engine = mock(IndexingExecutionEngine.class);
        MergeHandler handler = createHandler();
            mock(MergeHandler.MergePolicy.class),
        OneMerge oneMerge = new OneMerge(List.of(segment));
        MergePlan plan = new MergePlan(
        Collection<OneMerge> merges = handler.findMerges();
        OneMerge oneMerge = new OneMerge(List.of(segment));
        assertNotNull(result);
        when(secondaryMerger.prepareMerge(any())).thenReturn(null);
 * Tests for {@link CompositeMerger}.
            primary,
    /** merge() uses ALL_ALIVE for all formats when the producer reports no deletes. */
            snapshotSupplier,
        assertEquals(1, plan.filesFor(primaryFormat).size());
        handler.registerMerge(oneMerge);
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
import java.util.Set;
        Merger secondaryMerger2 = mock(Merger.class);
        WriterFileSet mergedS = wfs(tempDir, 99L, Set.of("ms.dat"), 2);
    private Merger primaryMerger;
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        CompositeMerger merger = createCompositeMerger();
        MergeResult result = merger.merge(mergeInputFor(segment));
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> executor.execute(plan));
            segments.add(Segment.builder(i).addSearchableFiles(primaryFormat, pWfs).build());
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
            WriterFileSet pWfs = wfs(tempDir, i, Set.of("seg" + i + ".dat"), 10);
    private static DataFormat stubFormat(String name) {
            .build();
        Path tempDir = createTempDir();
        return new DataFormat() {
            SHARD_ID,
            () -> 1L
    }
            mock(MergeHandler.MergeListener.class),
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        CompositeMerger merger = createCompositeMerger();
    private MergeInput mergeInputFor(Segment... segments) {
        WriterFileSet inputP = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.parquet"), 50, 1L);
    public void testMergeUsesAllAliveWhenNothingFrozen() throws IOException {
    public void testMergeClosesPreparationOnPrimaryFailure() throws IOException {
        CompositeMerger merger = createCompositeMerger();
    // ========== findMerges ==========
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
    public void testFindForceMergesThrowsOnSnapshotFailure() {
            @Override
    public void testMergePlanFromCarriesLiveDocs() {
    }
import static org.mockito.Mockito.verify;
        snapshotSupplier = () -> new GatedCloseable<>(null, () -> {});
    }
        MergePreparation preparation = mock(MergePreparation.class);
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        // mergedPrimaryWfs points to "mp.dat" which is a non-empty directory
        CompositeMergeExecutor executor = new CompositeMergeExecutor(
        OneMerge oneMerge = new OneMerge(List.of(segment));
    /**
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s1.dat"), 10);
        Path tempDir = createTempDir();
import java.util.Map;
        WriterFileSet sWfs = wfs(tempDir, generation, Set.of("s" + generation + ".dat"), numRows);
    /** Two secondaries both claiming to own delete state is a configuration error, caught at construction. */
        Merger secondaryMerger = mock(Merger.class);
    public void testDoMergeSkipsSecondaryThatEqualsPrimary() throws IOException {
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(Collections.emptyList());
        Exception ex = expectThrows(Exception.class, () -> merger.merge(mergeInputFor(segment)));
        Collection<OneMerge> merges = handler.findForceMerges(1);
        WriterFileSet secondaryFiles = new WriterFileSet(createTempDir().toString(), 10L, Set.of("file.si"), 90, 1L);
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedWfs));
            snapshotSupplier,
    }
        WriterFileSet sWfs1 = wfs(tempDir, 1L, Set.of("s1.dat"), 5);
        snapshotSupplier = () -> { throw new RuntimeException("snapshot unavailable"); };
    }
 * compatible open source license.
        doReturn(mockEngine(primaryFormat, primaryMerger)).when(multiEngine).getPrimaryDelegate();
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();
        // Segment claims 100 rows but the frozen bitmap covers only 64 bits (one word).
        // Should not throw during cleanup even though file doesn't exist
            mock(MergeHandler.MergeListener.class),
        assertNotNull(result);
        when(compositeEngine.getNextWriterGeneration()).thenReturn(99L);
                return 1;
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
        Segment seg2 = buildSegment(2L, primaryFormat, pWfs2, secondaryFormat, sWfs2);
    // ── Two-phase merge: prepareMerge / MergePreparation.close / live-docs propagation ──
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
    }
        Segment seg1 = buildSegment(1L, primaryFormat, pWfs1, secondaryFormat, sWfs1);
        merger.merge(mergeInputFor(segment));
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
            List.of(secondary),
        RowIdMapping mapping = mock(RowIdMapping.class);
            LiveDocs.ALL_ALIVE
    }
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        }
        OneMerge oneMerge = new OneMerge(List.of(seg1, seg2));
}
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
    private static WriterFileSet wfs(Path dir, long gen, Set<String> files, long numRows) {
        MergeHandler handler = new MergeHandler(
    public void setUp() throws Exception {
        assertSame("secondary must merge with the same frozen bitmap", frozen, secondaryCaptor.getValue().liveDocs());
    // ── Cross-format merge verification tests ──
        Segment segment = defaultSegment(tempDir, 1L, 3);
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
        Path tempDir = createTempDir();
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("nonexistent.dat"), 5);
        Path tempDir = createTempDir();
        expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
import java.util.Collection;
                return Set.of();
        OneMerge oneMerge = new OneMerge(List.of(segment));
        when(secondaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of(secondary, secondaryFiles)));
        assertEquals(10L, plan.mergedWriterGeneration());
        doReturn(primaryEngine).when(engineNoSecondary).getPrimaryDelegate();
        assertNotNull(merges);
    }
/**
        doReturn(primaryEngine).when(dupEngine).getPrimaryDelegate();
        WriterFileSet mergedP = wfs(tempDir, 99L, Set.of("mp.dat"), 1);
        for (int i = 0; i < 5; i++) {
        when(secondaryMerger.merge(any())).thenThrow(new IOException("parquet error"));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L }));
        assertSame(mergedWfs, result.getMergedWriterFileSetForDataformat(primaryFormat));
            snapshotSupplier,
            mock(MergeHandler.MergePolicy.class),
        assertTrue(result.liveDocs().allAlive());
        primaryFormat = stubFormat("lucene");
        compositeEngine = mock(CompositeIndexingExecutionEngine.class);
        // non-empty directory throws DirectoryNotEmptyException
            public String name() {
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        );
                return true;
        when(primaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of(primary, primaryFiles), mapping));
    /** prepareMerge tolerates a producer returning null (treated as EMPTY). */
        verify(prepared, times(1)).close();
        WriterFileSet mergedSWfs = wfs(tempDir, 99L, Set.of("ms.dat"), 10);
        assertFalse(handler.hasPendingMerges());
        WriterFileSet primaryFiles = new WriterFileSet(dir, 10L, Set.of("file.parquet"), 100, 1L);
            Map.of(primaryFormat, primaryMerger, secondaryFormat, secondaryMerger)
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p1.dat"), 10);
    }
    // ========== findMerges with merge candidates ==========
        Path tempDir = createTempDir();
        verify(secondaryMerger, times(1)).prepareMerge(any());
        when(secondaryMerger.prepareMerge(any())).thenReturn(MergePreparation.EMPTY);
            public long priority() {
        when(engineNoSecondary.getNextWriterGeneration()).thenReturn(50L);
        MergeHandler handler = createHandler();
        when(secondaryMerger.providesMergeLiveDocs()).thenReturn(true);
    }
            Map.of(primary, List.of(inputP), secondary, List.of(inputS)),
        doReturn(Set.of(mockEngine(secondaryFormat, secondaryMerger), mockEngine(secondaryFormat2, secondaryMerger2))).when(multiEngine)
            () -> 1L
    // ========== doMerge: secondary format equals primary is skipped ==========
        WriterFileSet inputP = wfs(tempDir, 1L, Set.of("in.parquet"), 2);
            public long priority() {
        assertFalse(merger.providesMergeLiveDocs());
        Path tempDir = createTempDir();
        assertNull(handler.getNextMerge());
        CompositeDataFormat primaryOnlyFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat));
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
        // TieredMergePolicy should find merge candidates with 15 small segments
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 10);
        OneMerge oneMerge = new OneMerge(List.of(segment));
        WriterFileSet mergedPWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
        MergeHandler handler = createHandler();
    public void testPrepareMergeReturnsAllAliveWhenProducerHasNoDeletes() throws IOException {
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        WriterFileSet sWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
    private static Segment buildSegment(long generation, DataFormat fmt1, WriterFileSet wfs1, DataFormat fmt2, WriterFileSet wfs2) {
        assertTrue(merges.isEmpty());
        MergeHandler handler = createHandler();
        assertTrue("original failure must win", root.getMessage().contains("original failure"));
     */
        Path tempDir = createTempDir();
    /** The preparation is closed after a successful merge too — the producer's close() is a no-op once consumed. */
        WriterFileSet pWfs2 = wfs(tempDir, 2L, Set.of("p2.dat"), 5);
            Path file = tempDir.resolve("fseg" + i + ".dat");
            policy,
            public Set<FieldTypeCapabilities> supportedFields() {
    }
                return "StubFormat{" + name + "}";
        Path tempDir = createTempDir();
        WriterFileSet inputS = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.si"), 50, 1L);
        when(secondaryMerger2.providesMergeLiveDocs()).thenReturn(true);
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(List.of(segment));
        doThrow(new IOException("close failure")).when(prepared).close();
        WriterFileSet pWfs1 = wfs(tempDir, 1L, Set.of("p1.dat"), 5);
    }
            "close failure must be suppressed onto the original",
    public void testPrepareMergeSkipsSecondariesThatDoNotProvideLiveDocs() throws IOException {
import org.opensearch.core.index.Index;
        handler.registerMerge(oneMerge);
        );
            new CompositeMerger(dupEngine, dupFormat),
    }
            }
    private static final RowIdMapping STUB_ROW_ID_MAPPING = new PackedRowIdMapping(new long[] { 0 }, false);
        for (Throwable suppressed : t.getSuppressed()) {
import java.util.List;
        secondaryFormat = stubFormat("parquet");
import static org.mockito.Mockito.mock;
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));
import org.opensearch.index.engine.dataformat.MergeResult;
    // ========== doMerge: no cleanup when mergedWriterFileSet is empty ==========
        assertNotNull(merges);
        assertNotNull(merges);
    private static final ShardId SHARD_ID = new ShardId(new Index("test-index", "uuid"), 0);
    // ========== doMerge: primary merge throws IOException ==========
        return snapshot;
        );
        // constructor's dataFormatMergerMap (last-write-wins for same key).
import org.opensearch.index.engine.dataformat.MergePreparation;
        doReturn(primaryEngine).when(compositeEngine).getPrimaryDelegate();
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
        assertSame(oneMerge, retrieved);
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));
import org.opensearch.index.engine.dataformat.DataFormat;
            () -> 1L
        when(secondaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(secondaryFormat, mergedS)));
        // Default mock: providesMergeLiveDocs() == false. Build WITHOUT the producer stub.
    private DataFormat secondaryFormat;
        MergeHandler handler = createHandlerWithRealPolicy();
        );
        MergeHandler handler = createHandler();
        assertNotNull(result);
    }
    private MergeHandler createHandler() {
        super.setUp();
    public void testMergePropagatesFrozenLiveDocsToAllFormats() throws IOException {
        MergeHandler handler = createHandler();
        MergePlan plan = new MergePlan(
        for (OneMerge merge : merges) {
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedWfs), STUB_ROW_ID_MAPPING);
        MergeResult result = handler.doMerge(oneMerge);
            }
        Collection<OneMerge> merges = handler.findMerges();
        Path tempDir = createTempDir();
        WriterFileSet s2Wfs = wfs(tempDir, 1L, Set.of("s2.dat"), 5);
    }
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(indexSettings.getMergePolicy(true), SHARD_ID);
        WriterFileSet mergedWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
    public void testDoMergePrimaryOnlyNoSecondaries() throws IOException {
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPWfs), STUB_ROW_ID_MAPPING);
        when(dupEngine.getNextWriterGeneration()).thenReturn(99L);
        MergeResult result = handler.doMerge(oneMerge);
            snapshotSupplier,
            WriterFileSet pWfs = wfs(tempDir, i, Set.of("fseg" + i + ".dat"), 10);
        assumeTrue("requires assertions enabled", CompositeMergerTests.class.desiredAssertionStatus());
        WriterFileSet mergedP = wfs(tempDir, 99L, Set.of("mp.dat"), 2);
        assertSame("primary must merge with the frozen bitmap", frozen, primaryCaptor.getValue().liveDocs());
        when(secondaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(secondaryFormat, mergedS)));
import org.opensearch.index.engine.exec.Segment;
        // which throws DirectoryNotEmptyException — caught and logged, not re-thrown
            @Override
            .addSearchableFiles(secondaryFormat2, s2Wfs)
        when(secondaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of()));
        }
        WriterFileSet primaryFiles = new WriterFileSet(createTempDir().toString(), 10L, Set.of("file.parquet"), 100, 1L);
        verify(primaryMerger, never()).prepareMerge(any());
        verify(secondaryMerger).merge(secondaryCaptor.capture());
        MergeHandler handler = createHandler();
        handler.onMergeFinished(oneMerge, false);
            SHARD_ID,
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 3)));
                return name;
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        MergeHandler handler = createHandler();
        assertFalse("Expected force merge candidates when targeting 1 segment from 5", merges.isEmpty());
        Path tempDir = createTempDir();
        );
        IndexingExecutionEngine<?, ?> secondaryEngine = mockEngine(secondaryFormat, secondaryMerger);
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        RowIdMapping mapping = mock(RowIdMapping.class);
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
        MergePlan plan = new MergePlan(10L, primaryFormat, List.of(), Map.of(primaryFormat, List.of(inputP)), liveDocs);
        assertTrue(
    public void testDoMergeSuccessWithPrimaryAndSecondary() throws IOException {
    }
import org.opensearch.composite.CompositeDataFormat;
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
        Path tempDir = createTempDir();
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
import org.opensearch.common.concurrent.GatedCloseable;
        when(secondaryMerger.merge(any())).thenThrow(new IOException("fail"));
        ArgumentCaptor<MergeInput> secondaryCaptor = ArgumentCaptor.forClass(MergeInput.class);
    }
    // ========== cleanup: exception during file deletion is logged but not thrown ==========
import org.opensearch.index.engine.dataformat.MergeInput;
     * stubbing, because the producer is resolved in the constructor.
        secondaryMerger = mock(Merger.class);
        Segment segment = defaultSegment(tempDir, 1L, 3);
        return engine;
    }
    public void testDoMergeMissingRowIdMappingThrowsIllegalState() throws IOException {
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(Collections.emptyList());
        verify(primaryMerger, times(1)).merge(any());
    public void testPrepareMergeToleratesNullFromProducer() throws IOException {
        MergeHandler handler = createHandler();
        OneMerge oneMerge = new OneMerge(List.of(segment));
import org.opensearch.composite.stats.CompositeShardStatsTracker;
    }
        Path tempDir = createTempDir();
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        MergeHandler handler = createHandler();
        assertSame(liveDocs, plan.liveDocs());
import static org.mockito.ArgumentMatchers.any;
        assertSame(liveDocs, captor.getValue().liveDocs());
            new CompositeMerger(engineNoSecondary, primaryOnlyFormat),
        assertNotNull(merges);
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();
            Files.write(file, new byte[100]);
    public void testFindMergesReturnsEmptyWhenNoSegments() {
            }
import java.nio.file.Files;
import org.opensearch.index.engine.dataformat.Merger;
    public void testMergeClosesPreparationOnSuccess() throws IOException {
        assertSame(mergedSecondaryWfs, result.getMergedWriterFileSetForDataformat(secondaryFormat));
    /** The executor threads the plan's liveDocs into the MergeInput of every format it merges. */
        ArgumentCaptor<MergeInput> captor = ArgumentCaptor.forClass(MergeInput.class);
        CompositeMerger merger = createCompositeMerger();
        WriterFileSet inputP = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.parquet"), 50, 1L);
 * The OpenSearch Contributors require contributions made to
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
        assertFalse(handler.hasPendingMerges());
        verify(prepared, times(1)).close();
        Path tempDir = createTempDir();
        }
        assertEquals(1, result.getMergedWriterFileSet().size());
        when(mapping.size()).thenReturn(100);
        // The primary must never be asked to prepare — only the producer freezes state.
    public void testDoMergeCleanupHandlesNonExistentFilesGracefully() throws IOException {
        expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        assertSame(MergePreparation.EMPTY, result);
import org.opensearch.index.engine.dataformat.LiveDocs;
    }
            LiveDocs.ALL_ALIVE
        when(secondaryMerger.merge(any())).thenThrow(new IOException("secondary fail"));
        );
        Segment segment = defaultSegment(tempDir, 1L, 3);
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(segments);
        when(primaryMerger.merge(any())).thenThrow(new IOException("original failure"));
            () -> 1L
        CompositeMerger merger = createCompositeMerger();
        when(engineNoSecondary.statsTracker()).thenReturn(new CompositeShardStatsTracker());
    }
    /** The live-docs shape assertion trips when the bitmap is too small for the segment's rows. */
    /** With no secondary advertising live docs, nothing is prepared and no secondary is asked to. */
        CompositeDataFormat multiFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat, secondaryFormat, secondaryFormat2));
    public void testFindForceMergesReturnsEmptyWhenNoSegments() {
    }
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
                return priority;
        when(secondaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(secondaryFormat, mergedS)));
        LiveDocs frozen = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
    public void testRegisterMergeAndOnMergeFailure() {
        OneMerge retrieved = handler.getNextMerge();
            @Override
        CompositeMerger merger = new CompositeMerger(compositeEngine, compositeDataFormat);
    private MergeHandler createHandlerWithRealPolicy() {
        Exception ex = expectThrows(Exception.class, () -> merger.merge(mergeInputFor(segment)));
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPWfs), STUB_ROW_ID_MAPPING);
        when(primaryMerger.merge(any())).thenThrow(new IOException("primary exploded"));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(2, result.getMergedWriterFileSet().size());
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, primaryWfs).build();
    }
 *
        MergeHandler handler = createHandler();
    // ========== doMerge: multiple segments ==========
        );
        DataFormat secondary = stubFormat("lucene", 50);
        Path tempDir = createTempDir();
            public Set<FieldTypeCapabilities> supportedFields() {
    // ========== doMerge: cleanup handles non-existent files gracefully ==========
            }
        IllegalStateException err = expectThrows(IllegalStateException.class, () -> new CompositeMerger(multiEngine, multiFormat));
        MergeHandler handler = createHandlerWithRealPolicy();
        CompositeMerger merger = createCompositeMerger();
        DataFormat secondary = stubFormat("lucene", 50);
            assertFalse(merge.getSegmentsToMerge().isEmpty());
        when(engine.getMerger()).thenReturn(merger);
                return Set.of();
            }
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
    public void testExecutorGetMergerReturnsRegisteredMerger() {
        Path tempDir = createTempDir();
        return buildSegment(generation, primaryFormat, pWfs, secondaryFormat, sWfs);
            .build();
        WriterFileSet mergedP = wfs(tempDir, 99L, Set.of("mp.dat"), 3);
import java.util.function.Supplier;
        verify(primaryMerger).merge(captor.capture());
 * this file be licensed under the Apache-2.0 license or a
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
            .addSearchableFiles(secondaryFormat, sWfs)
    public void testPrepareMergeReturnsProducerPreparation() throws IOException {
            @Override
        CompositeIndexingExecutionEngine multiEngine = mock(CompositeIndexingExecutionEngine.class);
        assertTrue(ex.getMessage().contains("secondaries"));
/*
import java.util.Collections;
import org.opensearch.index.engine.dataformat.merge.MergeHandler;
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        AssertionError err = expectThrows(AssertionError.class, () -> merger.merge(mergeInputFor(segment)));
        DataFormat primary = stubFormat("parquet", 0);
        assertFalse("Stale merged file should be deleted on failure", Files.exists(staleFile));
        when(dupEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        verify(prepared, times(1)).close();
            @Override
        assertNotNull(ex.getCause());
        when(secondaryMerger2.merge(any())).thenThrow(new IOException("arrow error"));
    }
    /** prepareMerge hands back the producer's own preparation so its close() reaches the producer. */
        Path tempDir = createTempDir();
        when(mapping.size()).thenReturn(100);
            .getSecondaryDelegates();
            new CompositeMerger(compositeEngine, compositeDataFormat),
        CompositeMerger merger = createCompositeMerger();
    public void testDoMergePrimaryFailureThrowsUncheckedIOException() throws IOException {
        OneMerge oneMerge = new OneMerge(List.of(segment));
    private static boolean containsSuppressed(Throwable t, String message) {
        when(secondaryMerger.providesMergeLiveDocs()).thenReturn(true);
        List<Segment> segments = new java.util.ArrayList<>();
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
        assertTrue(err.getMessage(), err.getMessage().contains("arrow"));
        assertNotNull(ex.getCause());
        IndexingExecutionEngine<?, ?> duplicateEngine = mockEngine(primaryFormat, primaryMerger);
        Path tempDir = createTempDir();
import static org.mockito.Mockito.when;
        OneMerge oneMerge = new OneMerge(List.of(segment));
        CompositeMerger merger = createCompositeMerger();
    }
        );
            () -> 1L
    private static CatalogSnapshot mockCatalogSnapshot(List<Segment> segments) {
        when(snapshot.getSegments()).thenReturn(segments);
        when(secondaryMerger.merge(any())).thenThrow(new IOException("secondary fail"));
        Path tempDir = createTempDir();
        MergeResult result = handler.doMerge(oneMerge);
        Segment segment = defaultSegment(tempDir, 1L, 3);
        doReturn(Set.of()).when(engineNoSecondary).getSecondaryDelegates();
        CompositeMerger merger = createCompositeMerger();
        DataFormat primary = stubFormat("parquet", 0);
        MergeResult secondaryResult = new MergeResult(Map.of(secondaryFormat, mergedSWfs));
    public void testDoMergeWithMultipleSegments() throws IOException {
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
            @Override
        OneMerge oneMerge = new OneMerge(List.of(segment));
        assertTrue(merges.isEmpty());
            Map.of(primary, List.of(inputP), secondary, List.of(inputS)),
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        Path tempDir = createTempDir();
        Files.createFile(staleFile);
        WriterFileSet mergedPWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 10);
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b11L }));
import java.io.UncheckedIOException;
        snapshotSupplier = () -> { throw new RuntimeException("snapshot unavailable"); };
    // ========== doMerge: multiple secondaries — fails fast on first error ==========
    // ── CompositeMergeExecutor.getMerger ──
    private static MergePreparation preparationOf(LiveDocs liveDocs) {
        verify(primaryMerger).merge(captor.capture());
        ArgumentCaptor<MergeInput> captor = ArgumentCaptor.forClass(MergeInput.class);
        // Create many small segments with real files to trigger TieredMergePolicy
