        handler.registerMerge(oneMerge);  
        Path tempDir = createTempDir();
        CompositeMergeExecutor executor = new CompositeMergeExecutor(
        MergeHandler handler = createHandler();
    public void testFindForceMergesReturnsEmptyWhenNoSegments() {
        IndexingExecutionEngine<DataFormat, ?> engine = mock(IndexingExecutionEngine.class);  
        WriterFileSet mergedSWfs = wfs(tempDir, 99L, Set.of("ms.dat"), 10);
        when(secondaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of(secondary, secondaryFiles)));  
        // TieredMergePolicy should find merge candidates with 15 small segments
    }
        when(secondaryMerger.merge(any())).thenThrow(new IOException("fail"));
            10L,
        WriterFileSet mergedPWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);  
        OneMerge oneMerge = new OneMerge(List.of(segment));  
        MergeHandler handler = createHandler();
        when(engine.getDataFormat()).thenReturn(format);
        doReturn(Set.of(mockEngine(secondaryFormat, secondaryMerger), mockEngine(secondaryFormat2, secondaryMerger2))).when(multiEngine)
        CompositeMerger merger = createCompositeMerger();
        return new DataFormat() {
        CompositeMerger merger = createCompositeMerger();
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
    }  
        assertNotNull(ex.getCause());
        // Fail-fast: only the first secondary failure is reported, no suppressed exceptions
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();
        ArgumentCaptor<MergeInput> captor = ArgumentCaptor.forClass(MergeInput.class);  
    private static MergePreparation preparationOf(LiveDocs liveDocs) {
        Segment segment = Segment.builder(0L)
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);  
        when(secondaryMerger.merge(any())).thenThrow(new IOException("secondary fail"));
        WriterFileSet primaryFiles = new WriterFileSet(createTempDir().toString(), 10L, Set.of("file.parquet"), 100, 1L);
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));
            () -> 1L  
        MergeHandler handler = createHandler();
        Path tempDir = createTempDir();
        Exception ex = expectThrows(Exception.class, () -> merger.merge(mergeInputFor(segment)));  
        OneMerge oneMerge = new OneMerge(List.of(segment));
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
            snapshotSupplier,  
        verify(secondaryMerger).merge(secondaryCaptor.capture());  
        Segment segment = defaultSegment(tempDir, 1L, 3);
        );  
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
import org.opensearch.core.index.shard.ShardId;  
    /** prepareMerge tolerates a producer returning null (treated as EMPTY). */
        // suppresses the close failure onto whatever throwable escaped the execute phase.  
            10L,
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
        Path tempDir = createTempDir();
            () -> 1L
        assertFalse(handler.hasPendingMerges());  
    public void testFindForceMergesThrowsOnSnapshotFailure() {  
        verify(primaryMerger).merge(primaryCaptor.capture());
        WriterFileSet mergedWfs = wfs(tempDir, 50L, Set.of("merged.dat"), 5);
    private MergeHandler createHandlerWithRealPolicy() {  
    public void testCleanupStaleMergedFilesLogsExceptionOnDeleteFailure() throws IOException {
        MergeResult secondaryResult = new MergeResult(Map.of(secondaryFormat, mergedSWfs));
        verify(primaryMerger).merge(captor.capture());
        when(engineNoSecondary.getNextWriterGeneration()).thenReturn(50L);
    public void testDoMergeCleanupHandlesNonExistentFilesGracefully() throws IOException {
        return new MergeHandler(  
        MergeHandler handler = createHandler();  
    }
        Segment seg1 = buildSegment(1L, primaryFormat, pWfs1, secondaryFormat, sWfs1);  
        Settings settings = Settings.builder()
        CompositeDataFormat multiFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat, secondaryFormat, secondaryFormat2));
        OneMerge retrieved = handler.getNextMerge();  
        return engine;  
    // ========== doMerge: primary merge throws IOException ==========
 */
        verify(secondaryMerger, times(1)).merge(any());  
        Merger secondaryMerger2 = mock(Merger.class);
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));  
        assertTrue(ex.getMessage().contains("snapshot unavailable"));
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(Collections.emptyList());
        WriterFileSet inputP = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.parquet"), 50, 1L);
            mock(MergeHandler.MergeListener.class),
        Path tempDir = createTempDir();
        );
    /** The preparation is closed after a successful merge too — the producer's close() is a no-op once consumed. */
        WriterFileSet mergedWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
    private CompositeMerger createCompositeMerger() {  
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();
        verify(primaryMerger, never()).prepareMerge(any());
        CompositeMerger merger = createCompositeMerger();
        doReturn(primaryEngine).when(dupEngine).getPrimaryDelegate();
        Path tempDir = createTempDir();
            public Set<FieldTypeCapabilities> supportedFields() {
    public void testPrepareMergeReturnsAllAliveWhenProducerHasNoDeletes() throws IOException {
        OneMerge oneMerge = new OneMerge(List.of(segment));
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        Throwable root = ex instanceof java.io.UncheckedIOException && ex.getCause() != null ? ex.getCause() : ex;
        RowIdMapping mapping = mock(RowIdMapping.class);
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 5)));
    /** merge() uses ALL_ALIVE for all formats when the producer reports no deletes. */
    }
        when(primaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of(primary, primaryFiles), mapping));
    // ========== doMerge: no cleanup when mergedWriterFileSet is empty ==========
        WriterFileSet secondaryFiles = new WriterFileSet(createTempDir().toString(), 10L, Set.of("file.si"), 90, 1L);  
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
    private MergeInput mergeInputFor(Segment... segments) {
        assertTrue(Files.exists(dirAsFile));
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
    private CompositeDataFormat compositeDataFormat;
    // ========== doMerge: secondary format equals primary is skipped ==========  
        WriterFileSet sWfs = wfs(tempDir, generation, Set.of("s" + generation + ".dat"), numRows);
        WriterFileSet primaryFiles = new WriterFileSet(dir, 10L, Set.of("file.parquet"), 100, 1L);  
        Files.createFile(staleFile);
        Path tempDir = createTempDir();
        MergeHandler handler = createHandler();
        OneMerge oneMerge = new OneMerge(List.of(seg1, seg2));
    }  
        OneMerge oneMerge = new OneMerge(List.of(segment));
    public void testDoMergeMissingRowIdMappingThrowsIllegalState() throws IOException {
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(List.of(segment));  
        assertSame(prepared, result);  
    public void testExecutorGetMergerReturnsRegisteredMerger() {  
    public void testFindMergesThrowsOnSnapshotFailure() {
        return snapshot;
        Path tempDir = createTempDir();  
        doReturn(Set.of(secondaryEngine)).when(compositeEngine).getSecondaryDelegates();
import org.opensearch.index.engine.exec.WriterFileSet;
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);  
    // ========== findForceMerges ==========  
        for (OneMerge merge : merges) {  
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(segments);
        assertTrue("original failure must win", root.getMessage().contains("original failure"));
    public void testMergePlanFromCarriesLiveDocs() {
        WriterFileSet pWfs1 = wfs(tempDir, 1L, Set.of("p1.dat"), 5);
     * stubbing, because the producer is resolved in the constructor.
        when(secondaryMerger2.providesMergeLiveDocs()).thenReturn(true);  
        primaryFormat = stubFormat("lucene");
        // constructor's dataFormatMergerMap (last-write-wins for same key).
    }
    public void testMergeAssertsOnUndersizedLiveDocsBitmap() throws IOException {
        when(secondaryMerger.providesMergeLiveDocs()).thenReturn(true);
        assertSame(liveDocs, captor.getValue().liveDocs());  
import org.opensearch.index.engine.dataformat.MergePreparation;
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
        when(engineNoSecondary.statsTracker()).thenReturn(new CompositeShardStatsTracker());  
        Path tempDir = createTempDir();  
        return Segment.builder(generation).addSearchableFiles(fmt1, wfs1).addSearchableFiles(fmt2, wfs2).build();
        Segment segment = defaultSegment(tempDir, 1L, 3);
package org.opensearch.composite.merge;
        );
 * this file be licensed under the Apache-2.0 license or a
    // ========== findMerges ==========
            () -> 1L
    public void testDoMergeNoCleanupWhenPrimaryFails() throws IOException {
        DataFormat secondary = stubFormat("lucene", 50);  
        when(secondaryMerger.providesMergeLiveDocs()).thenReturn(true);
            Map.of(primaryFormat, primaryMerger, secondaryFormat, secondaryMerger)
        Exception ex = expectThrows(Exception.class, () -> merger.merge(mergeInputFor(segment)));  
        for (Throwable suppressed : t.getSuppressed()) {
import org.opensearch.index.engine.dataformat.DataFormat;
        for (int i = 0; i < 5; i++) {
        Path tempDir = createTempDir();  
        assertSame(MergePreparation.EMPTY, result);  
    }
        };
    public void testDoMergeSkipsSecondaryThatEqualsPrimary() throws IOException {
        when(multiEngine.getNextWriterGeneration()).thenReturn(99L);  
            WriterFileSet pWfs = wfs(tempDir, i, Set.of("seg" + i + ".dat"), 10);  
    // ========== doMerge: single secondary failure ==========
        IndexingExecutionEngine<?, ?> secondaryEngine = mockEngine(secondaryFormat, secondaryMerger);
import org.opensearch.composite.stats.CompositeShardStatsTracker;
     * secondary advertised as the live-docs producer. Must run AFTER any providesMergeLiveDocs  
        MergeResult result = handler.doMerge(oneMerge);
            @Override
        when(primaryMerger.merge(any())).thenReturn(primaryResult);
        MergeHandler handler = createHandler();
        assertFalse(handler.hasPendingMerges());  
        assertNotNull(merges);  
    public void testExecutorThrowsWhenSecondaryReturnsNullButPrimaryHasOutput() throws IOException {
        MergeHandler handler = createHandlerWithRealPolicy();
        assertEquals(1, plan.filesFor(secondaryFormat).size());
        when(mapping.size()).thenReturn(100);  
        assertFalse("Expected force merge candidates when targeting 1 segment from 5", merges.isEmpty());  
/*  
    private static boolean containsSuppressed(Throwable t, String message) {  
    public void testDoMergeWithMultipleSegments() throws IOException {
        assertSame(liveDocs, plan.liveDocs());
        // Force merge down to 1 segment should produce candidates  
            SHARD_ID,  
            }  
        OneMerge oneMerge = new OneMerge(List.of(segment));
        when(secondaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(secondaryFormat, mergedS)));  
        doReturn(Set.of()).when(engineNoSecondary).getSecondaryDelegates();  
            Path file = tempDir.resolve("fseg" + i + ".dat");
        WriterFileSet mergedP = wfs(tempDir, 99L, Set.of("mp.dat"), 3);
            mock(MergeHandler.MergeListener.class),
        // Primary result without rowIdMapping
        Path tempDir = createTempDir();
    }  
        snapshotSupplier = () -> new GatedCloseable<>(null, () -> {});
            .getSecondaryDelegates();
    public void testGetNextMergeReturnsNullWhenEmpty() {  
        when(secondaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of()));  
    private Merger primaryMerger;
import static org.mockito.Mockito.mock;  
            WriterFileSet pWfs = wfs(tempDir, i, Set.of("fseg" + i + ".dat"), 10);
        MergePlan plan = new MergePlan(10L, primaryFormat, List.of(), Map.of(primaryFormat, List.of(inputP)), liveDocs);
            public long priority() {  
        MergeHandler handler = createHandler();  
            Map.of(primary, List.of(inputP), secondary, List.of(inputS)),
        assertTrue(result.liveDocs().allAlive());
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        assertTrue(  
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedWfs));
        merger.merge(mergeInputFor(segment));
        return MergeInput.builder().segments(List.of(segments)).newWriterGeneration(99L).build();  
    private Merger secondaryMerger;
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);  
            primary,  
                return name;
            mock(MergeHandler.MergePolicy.class),  
        assertTrue(ex.getMessage().contains("primary exploded") || ex.getCause().getMessage().contains("primary exploded"));
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 10);
        CompositeMergeExecutor executor = new CompositeMergeExecutor(Map.of(primary, primaryMerger, secondary, secondaryMerger));
        primaryMerger = mock(Merger.class);  
        assertFalse(handler.hasPendingMerges());  
        snapshotSupplier = () -> { throw new RuntimeException("snapshot unavailable"); };
            }
        CompositeMerger merger = createCompositeMerger();
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
    public void testMergeUsesAllAliveWhenNothingFrozen() throws IOException {
        return buildSegment(generation, primaryFormat, pWfs, secondaryFormat, sWfs);  
        return new DataFormat() {
        CompositeMergeExecutor executor = new CompositeMergeExecutor(Map.of(primary, primaryMerger, secondary, secondaryMerger));
        // Should not throw during cleanup even though file doesn't exist
        Collection<OneMerge> merges = handler.findForceMerges(1);
        WriterFileSet mergedPWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 10);
            if (suppressed.getMessage() != null && suppressed.getMessage().contains(message)) {
        MergeHandler handler = createHandler();  
import org.opensearch.composite.CompositeIndexingExecutionEngine;  
    /** When the primary merge fails after prepare, the producer's preparation is closed (state released). */
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
    /** With no secondary advertising live docs, nothing is prepared and no secondary is asked to. */
            public long priority() {  
            Files.write(file, new byte[100]);
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));  
import java.util.Collection;  
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        // The duplicate secondary has the same DataFormat as primary, so it should be skipped  
    // ── CompositeMergeExecutor.getMerger ──
        OneMerge oneMerge = new OneMerge(List.of(segment));  
    public void testDoMergePrimaryFailureThrowsUncheckedIOException() throws IOException {
        super.setUp();  
        MergePreparation prepared = preparationOf(frozen);  
    public void testConstructorRejectsMultipleLiveDocsProducers() {
    @Override
        when(secondaryMerger.prepareMerge(any())).thenReturn(MergePreparation.EMPTY);  
    }  
        Collection<OneMerge> merges = handler.findForceMerges(1);
        doReturn(Set.of(mockEngine(secondaryFormat, secondaryMerger), mockEngine(secondaryFormat2, secondaryMerger2))).when(multiEngine)
import org.opensearch.common.concurrent.GatedCloseable;  
        assertEquals("primary fail", ex.getCause().getMessage());  
        Collection<OneMerge> merges = handler.findMerges();
        verify(primaryMerger).merge(captor.capture());
    }
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        assertSame("primary must merge with the frozen bitmap", frozen, primaryCaptor.getValue().liveDocs());
        Path tempDir = createTempDir();
                return Set.of();  
        MergeResult result = merger.merge(mergeInputFor(segment));  
    private static final ShardId SHARD_ID = new ShardId(new Index("test-index", "uuid"), 0);
    }
    public void testRegisterMergeAndOnMergeFinished() {
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPWfs), STUB_ROW_ID_MAPPING);
import org.opensearch.index.IndexSettings;
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
    }
        assertEquals(1, plan.filesFor(primaryFormat).size());  
        CompositeMerger merger = new CompositeMerger(compositeEngine, compositeDataFormat);
        Segment segment = defaultSegment(tempDir, 1L, 3);
    }  
    /** The live-docs shape assertion trips when the bitmap is too small for the segment's rows. */  
            List.of(secondary),
import org.opensearch.index.engine.dataformat.Merger;  
import java.io.UncheckedIOException;  
        // The executor wraps the primary IOException in an UncheckedIOException; try-with-resources
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b11L }));  
import org.opensearch.index.engine.dataformat.RowIdMapping;
        assertNotNull(retrieved);
    }  
        DataFormat secondaryFormat2 = stubFormat("arrow");  
        when(primaryMerger.merge(any())).thenThrow(new IOException("primary exploded"));  
    }  
        );  
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();  
    private Segment defaultSegment(Path tempDir, long generation, long numRows) {  
            policy,
        Path tempDir = createTempDir();  
        // Segment claims 100 rows but the frozen bitmap covers only 64 bits (one word).
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        Segment segment = defaultSegment(tempDir, 1L, 3);
        DataFormatAwareMergePolicy policy = new DataFormatAwareMergePolicy(indexSettings.getMergePolicy(true), SHARD_ID);
            new CompositeMerger(engineNoSecondary, primaryOnlyFormat),
        // The merge fails due to secondary, cleanup tries to delete "mp.dat" (a non-empty dir)
        AssertionError err = expectThrows(AssertionError.class, () -> merger.merge(mergeInputFor(segment)));
    /** A failing close() is suppressed onto the original merge failure, not thrown in its place. */
    private DataFormat primaryFormat;
        Path tempDir = createTempDir();
        RuntimeException ex = expectThrows(RuntimeException.class, handler::findMerges);
                return true;  
    // ========== doMerge: cleanup handles non-existent files gracefully ==========  
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});  
            .build();  
        when(secondaryMerger.merge(any())).thenThrow(new IOException("parquet error"));  
        OneMerge oneMerge = new OneMerge(List.of(segment));  
        IllegalStateException err = expectThrows(IllegalStateException.class, () -> new CompositeMerger(multiEngine, multiFormat));  
            @Override  
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L }));
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        assertFalse("Expected merge candidates from 15 small segments", merges.isEmpty());
    public void testPrepareMergeSkipsSecondariesThatDoNotProvideLiveDocs() throws IOException {
        Path tempDir = createTempDir();
    }  
        WriterFileSet mergedSecondaryWfs = wfs(tempDir, 99L, Set.of("ms.dat"), 10);  
        MergeHandler handler = new MergeHandler(
        ArgumentCaptor<MergeInput> captor = ArgumentCaptor.forClass(MergeInput.class);
import static org.mockito.Mockito.times;
        when(secondaryMerger.merge(any())).thenThrow(new IOException("secondary disk error"));
import static org.mockito.Mockito.doThrow;
 * compatible open source license.
            }  
public class CompositeMergerTests extends OpenSearchTestCase {  
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(Collections.emptyList());  
            @Override  
            public String toString() {
    // ========== doMerge: missing rowIdMapping throws IllegalStateException ==========  
            mock(MergeHandler.MergeListener.class),
        RuntimeException ex = expectThrows(RuntimeException.class, () -> handler.findForceMerges(1));
    public void testMergeSuppressesCloseFailureOntoOriginalError() throws IOException {
        assumeTrue("requires assertions enabled", CompositeMergerTests.class.desiredAssertionStatus());
        // Even an assertion failure inside the try block releases the prepared state.  
        when(secondaryMerger.merge(any())).thenReturn(secondaryResult);
            primary,  
                return 1;
import org.opensearch.index.engine.dataformat.merge.OneMerge;
            }  
        assertTrue(merges.isEmpty());
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        Path tempDir = createTempDir();  
    public void testExecutorPassesPlanLiveDocsIntoMergeInput() throws IOException {
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 5)));
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        assertSame(mergedSecondaryWfs, result.getMergedWriterFileSetForDataformat(secondaryFormat));
        WriterFileSet sWfs1 = wfs(tempDir, 1L, Set.of("s1.dat"), 5);
        MergeResult result = handler.doMerge(oneMerge);
    }  
        assertTrue(plan.hasSecondaries());
    private static final RowIdMapping STUB_ROW_ID_MAPPING = new PackedRowIdMapping(new long[] { 0 }, false);  
        Path staleFile = tempDir.resolve("mp.dat");
        Merger primaryMerger = mock(Merger.class);
        assertSame(frozen, result.liveDocs());
        assertTrue(captor.getValue().liveDocs().allAlive());
            mock(MergeHandler.MergeListener.class),
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        CompositeIndexingExecutionEngine multiEngine = mock(CompositeIndexingExecutionEngine.class);  
        Segment segment = defaultSegment(tempDir, 1L, 3);
        UncheckedIOException ex = expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
import static org.mockito.Mockito.never;
        MergePlan plan = MergePlan.from(oneMerge, primaryFormat, List.of(secondaryFormat), 10L, liveDocs);
            containsSuppressed(ex, "close failure") || containsSuppressed(root, "close failure")
        );  
        WriterFileSet inputP = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.parquet"), 50, 1L);
        CompositeDataFormat primaryOnlyFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat));  
            policy,
        Segment segment = defaultSegment(tempDir, 1L, 100);
        handler.registerMerge(oneMerge);
        OneMerge oneMerge = new OneMerge(List.of(segment));
    }
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);  
        CompositeMerger merger = createCompositeMerger();  
            () -> 1L  
        CompositeMergeExecutor executor = new CompositeMergeExecutor(Map.of(primaryFormat, primaryMerger));  
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        CompositeMerger merger = createCompositeMerger();
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
    }
        MergePlan plan = new MergePlan(
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
        assertTrue(err.getMessage(), err.getMessage().contains("parquet"));
        OneMerge oneMerge = new OneMerge(List.of(segment));  
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));  
            "close failure must be suppressed onto the original",
        MergePreparation prepared = preparationOf(frozen);  
        assertEquals(2, result.getMergedWriterFileSet().size());
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        CompositeMerger merger = createCompositeMerger();  
    }
    }
    }
    public void testMergeClosesPreparationOnSuccess() throws IOException {  
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
            Map.of(primary, List.of(inputP), secondary, List.of(inputS)),
        return new MergeHandler(
        WriterFileSet inputP = wfs(tempDir, 1L, Set.of("in.parquet"), 2);
 * The OpenSearch Contributors require contributions made to  
        handler.onMergeFailure(oneMerge);
        Path tempDir = createTempDir();  
        doReturn(Set.of(duplicateEngine)).when(dupEngine).getSecondaryDelegates();  
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
            List.of(secondary),
        // mergedPrimaryWfs points to "mp.dat" which is a non-empty directory  
import java.util.Collections;
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
import static org.mockito.Mockito.when;
        ArgumentCaptor<MergeInput> secondaryCaptor = ArgumentCaptor.forClass(MergeInput.class);
import org.opensearch.common.settings.Settings;
        assertSame(secondaryMerger, executor.getMerger(secondaryFormat));
    public void testDoMergeSingleSecondaryFailureThrowsUncheckedIOException() throws IOException {  
            .addSearchableFiles(secondaryFormat, sWfs)
        }
        assertNotNull(result);  
    private static WriterFileSet wfs(Path dir, long gen, Set<String> files, long numRows) {  
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
            @Override
        WriterFileSet mergedS = wfs(tempDir, 99L, Set.of("ms.dat"), 1);
            new CompositeMerger(multiEngine, multiFormat),
        MergePlan plan = new MergePlan(
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        for (int i = 0; i < 15; i++) {  
        MergeHandler handler = createHandler();  
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
    // ========== registerMerge / onMergeFinished / onMergeFailure ==========
    // ========== doMerge: cleanup on failure deletes stale files ==========
        CompositeIndexingExecutionEngine dupEngine = mock(CompositeIndexingExecutionEngine.class);  
import org.opensearch.test.OpenSearchTestCase;  
        handler.onMergeFinished(oneMerge, false);  
        assertNull(executor.getMerger(stubFormat("unknown")));  
            }
    }
    /** A MergePreparation mock that reports the given bitmap; close() is left for the test to verify. */  
        when(dupEngine.getNextWriterGeneration()).thenReturn(99L);
    /** merge() forwards the frozen bitmap from the producer's preparation to every format's MergeInput. */  
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
import org.opensearch.Version;
            Files.write(file, new byte[100]);  
import java.nio.file.Files;
        assertEquals(10L, plan.mergedWriterGeneration());
        OneMerge oneMerge = new OneMerge(List.of(segment));
    /** The executor threads the plan's liveDocs into the MergeInput of every format it merges. */  
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);
        // The directory should still exist since deleteIfExists fails on non-empty dirs
        assertTrue(err.getMessage(), err.getMessage().contains("Multiple secondary formats provide merge live-docs"));
        CompositeIndexingExecutionEngine multiEngine = mock(CompositeIndexingExecutionEngine.class);
    // ── MergePlan liveDocs propagation ──  
            public String name() {
        secondaryFormat = stubFormat("parquet");
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(List.of(segment));
        when(compositeEngine.getNextWriterGeneration()).thenReturn(99L);
        }
        }
                return name;
        Segment seg2 = buildSegment(2L, primaryFormat, pWfs2, secondaryFormat, sWfs2);
            SHARD_ID,
        when(secondaryMerger.merge(any())).thenThrow(new IOException("secondary fail"));
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);  
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);  
    }
    public void testDoMergeCleanupDeletesStaleMergedFilesOnFailure() throws IOException {
    public void testDoMergeSuccessWithPrimaryAndSecondary() throws IOException {  
    }
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, primaryWfs).build();
        );  
        assertEquals("secondary disk error", ex.getCause().getMessage());  
        MergeHandler handler = createHandler();  
        assertTrue(ex.getMessage().contains("snapshot unavailable"));  
        Path tempDir = createTempDir();  
        MergeHandler handler = new MergeHandler(  
        Path tempDir = createTempDir();
    }
        assertSame(mergedPrimaryWfs, result.getMergedWriterFileSetForDataformat(primaryFormat));
        doReturn(mockEngine(primaryFormat, primaryMerger)).when(multiEngine).getPrimaryDelegate();
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
    private CompositeIndexingExecutionEngine compositeEngine;  
        assertTrue(handler.hasPendingMerges());
        assertSame("secondary must merge with the same frozen bitmap", frozen, secondaryCaptor.getValue().liveDocs());
        assertNotNull(result);  
        assertEquals(1, result.getMergedWriterFileSet().size());
            mock(MergeHandler.MergePolicy.class),
        expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
        MergeHandler handler = createHandler();  
        when(secondaryMerger.prepareMerge(any())).thenReturn(MergePreparation.EMPTY);  
    }
    }
            public String name() {
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        verify(secondaryMerger, times(1)).prepareMerge(any());  
        assertFalse(merger.providesMergeLiveDocs());  
/**  
        Path tempDir = createTempDir();  
    }  
                return "StubFormat{" + name + "}";
    }
        WriterFileSet mergedP = wfs(tempDir, 10L, Set.of("out.parquet"), 2);  
        CompositeDataFormat multiFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat, secondaryFormat, secondaryFormat2));
    public void testExecutorThrowsOnRowCountMismatch() throws IOException {
        // non-empty directory throws DirectoryNotEmptyException
        // Create a directory with the same name as the file to delete — deleteIfExists on a
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(List.of(segment));
        assertArrayEquals(new long[] { 0b101L }, primaryCaptor.getValue().getLiveDocsForSegment(1L));  
    /**
            new CompositeMerger(dupEngine, dupFormat),
    private static DataFormat stubFormat(String name, long priority) {
            }
    // ========== Helper methods ==========
            mock(MergeHandler.MergePolicy.class),  
    // ── Two-phase merge: prepareMerge / MergePreparation.close / live-docs propagation ──
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("mp.dat"), 5);
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p1.dat"), 10);
        };
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            LiveDocs.ALL_ALIVE  
        MergeHandler handler = createHandler();
        assertNotNull(result);
        verify(prepared, times(1)).close();
        when(primaryMerger.merge(any())).thenThrow(new IOException("primary disk error"));
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
    private MergeHandler createHandler() {
    // ========== cleanup: exception during file deletion is logged but not thrown ==========  
        List<Segment> segments = new java.util.ArrayList<>();  
        MergeHandler handler = createHandler();
    public void testPrepareMergeToleratesNullFromProducer() throws IOException {  
        WriterFileSet mergedP = wfs(tempDir, 99L, Set.of("mp.dat"), 1);  
        Path tempDir = createTempDir();
        DataFormat primary = stubFormat("parquet", 0);
        doReturn(primaryEngine).when(multiEngine).getPrimaryDelegate();  
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);  
import java.io.IOException;
        RowIdMapping mapping = mock(RowIdMapping.class);
 * Tests for {@link CompositeMerger}.
    }
        assertEquals(1, result.getMergedWriterFileSet().size());
            snapshotSupplier,
        // Default mock: providesMergeLiveDocs() == false. Build WITHOUT the producer stub.  
            SHARD_ID,  
        assertTrue(Files.exists(staleFile));  
        assertTrue(handler.hasPendingMerges());  
    }
        assertNotNull(merges);
import org.opensearch.index.engine.dataformat.merge.MergeHandler;
    public void testGetNextMergeReturnsMergeAfterRegister() {  
        when(dupEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
        Segment segment = defaultSegment(tempDir, 1L, 3);  
        CompositeMerger merger = createCompositeMerger();  
    // ========== findMerges with merge candidates ==========  
    public void testFindMergesReturnsEmptyWhenNoSegments() {  
    }  
        Files.createFile(dirAsFile.resolve("child.txt"));
        verify(primaryMerger, times(1)).merge(any());
    }
    // ========== doMerge: primary only (no secondaries) ==========
        MergeHandler handler = createHandler();
        assertNull(handler.getNextMerge());
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);  
        WriterFileSet sWfs2 = wfs(tempDir, 2L, Set.of("s2.dat"), 5);
    }
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                return Set.of();  
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
            @Override
        Path tempDir = createTempDir();
import java.nio.file.Path;
        ArgumentCaptor<MergeInput> primaryCaptor = ArgumentCaptor.forClass(MergeInput.class);  
        MergeHandler handler = createHandler();  
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);  
        );
        Files.createDirectory(dirAsFile);
        LiveDocs frozen = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
        MergePreparation preparation = mock(MergePreparation.class);
            Path file = tempDir.resolve("seg" + i + ".dat");
            @Override
    // ========== doMerge: multiple segments ==========  
    }  
import java.util.Map;  
import static org.mockito.Mockito.doReturn;
        return false;  
        Segment segment = Segment.builder(0L).addSearchableFiles(primaryFormat, pWfs).build();  
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});  
        CompositeDataFormat dupFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat));  
            .addSearchableFiles(secondaryFormat2, s2Wfs)
    }
        Path tempDir = createTempDir();  
        MergeResult result = handler.doMerge(oneMerge);
    }
import org.opensearch.index.engine.dataformat.MergeResult;
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
    public void testFindMergesReturnsMergeCandidates() throws IOException {
        verify(prepared, times(1)).close();  
        IndexingExecutionEngine<?, ?> duplicateEngine = mockEngine(primaryFormat, primaryMerger);
    public void testDoMergePrimaryOnlyNoSecondaries() throws IOException {
        // The primary must never be asked to prepare — only the producer freezes state.
    public void testMergeClosesPreparationOnPrimaryFailure() throws IOException {  
        return new WriterFileSet(dir.toString(), gen, files, numRows, 0L);
    }
        assertTrue(ex.getMessage().contains("row-ID mapping"));
            SHARD_ID,
        when(secondaryMerger.prepareMerge(any())).thenReturn(prepared);
        doReturn(primaryEngine).when(compositeEngine).getPrimaryDelegate();  
    public void testDoMergeMultipleSecondariesFailsFastOnFirstError() throws IOException {
    // ── Cross-format merge verification tests ──
        when(secondaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(secondaryFormat, mergedS)));  
        MergeResult result = handler.doMerge(oneMerge);  
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));  
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> executor.execute(plan));  
        when(multiEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());  
        assertTrue(err.getMessage(), err.getMessage().contains("arrow"));  
        MergeResult secondaryResult = new MergeResult(Map.of(secondaryFormat, mergedSecondaryWfs));  
        LiveDocs frozen = LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b101L }));
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 3)));
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> executor.execute(plan));  
                return priority;
        WriterFileSet inputS = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.si"), 50, 1L);
        Collection<OneMerge> merges = handler.findMerges();
        WriterFileSet pWfs = wfs(tempDir, generation, Set.of("p" + generation + ".dat"), numRows);
    /** prepareMerge hands back the producer's own preparation so its close() reaches the producer. */  
        MergeHandler handler = createHandlerWithRealPolicy();
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);  
        when(snapshot.getSegments()).thenReturn(segments);
        Path dirAsFile = tempDir.resolve("mp.dat");  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        handler.registerMerge(oneMerge);
    }  
    /** Two secondaries both claiming to own delete state is a configuration error, caught at construction. */
import java.util.List;
        // in the secondary loop. We use the same primaryMerger for both to avoid NPE in the
    public void setUp() throws Exception {
    }  
import java.util.function.Supplier;
        assertEquals(0, ex.getCause().getSuppressed().length);  
        Merger secondaryMerger = mock(Merger.class);  
import org.opensearch.core.index.Index;
        verify(secondaryMerger, never()).merge(any());
        Path tempDir = createTempDir();
        when(primaryMerger.merge(any(MergeInput.class))).thenReturn(new MergeResult(Map.of(primary, primaryFiles), mapping));
        when(compositeEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
        WriterFileSet mergedP = wfs(tempDir, 99L, Set.of("mp.dat"), 2);  
    public void testFindForceMergesReturnsMergeCandidates() throws IOException {
        String dir = createTempDir().toString();
    public void testRegisterMergeAndOnMergeFailure() {  
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPWfs), STUB_ROW_ID_MAPPING);  
        when(secondaryMerger.merge(any())).thenReturn(secondaryResult);  
        assertNotNull(merges);
        OneMerge oneMerge = new OneMerge(List.of(segment));
    }  
        compositeDataFormat = new CompositeDataFormat(primaryFormat, List.of(primaryFormat, secondaryFormat));
        doReturn(primaryEngine).when(engineNoSecondary).getPrimaryDelegate();
        verify(secondaryMerger, never()).prepareMerge(any());
        assertSame(MergePreparation.EMPTY, result);  
        when(multiEngine.statsTracker()).thenReturn(new CompositeShardStatsTracker());
    }
        CatalogSnapshot catalogSnapshot = mockCatalogSnapshot(segments);
        List<Segment> segments = new java.util.ArrayList<>();
            assertFalse(merge.getSegmentsToMerge().isEmpty());
        Path tempDir = createTempDir();
        assertSame(mergedWfs, result.getMergedWriterFileSetForDataformat(primaryFormat));
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
    private static CatalogSnapshot mockCatalogSnapshot(List<Segment> segments) {
        when(secondaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(secondaryFormat, mergedS)));
        when(engine.getMerger()).thenReturn(merger);
    }
    // ========== doMerge: successful primary + secondary ==========
            .getSecondaryDelegates();  
        );  
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs));
    private Supplier<GatedCloseable<CatalogSnapshot>> snapshotSupplier;
        secondaryMerger = mock(Merger.class);
        assertNotNull(merges);  
            segments.add(Segment.builder(i).addSearchableFiles(primaryFormat, pWfs).build());
        WriterFileSet sWfs = wfs(tempDir, 1L, Set.of("s.dat"), 5);  
        DataFormat secondary = stubFormat("lucene", 50);  
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();  
import java.util.Set;
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
        when(secondaryMerger2.merge(any())).thenThrow(new IOException("arrow error"));
        WriterFileSet pWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
    private static DataFormat stubFormat(String name) {
import org.opensearch.index.engine.exec.Segment;  
     */
            }
        DataFormat primary = stubFormat("parquet", 0);
        assertEquals("primary disk error", ex.getCause().getMessage());
import org.opensearch.index.engine.dataformat.MergeInput;  
        assertNotNull(result);
        compositeEngine = mock(CompositeIndexingExecutionEngine.class);
    public void testPrepareMergeReturnsProducerPreparation() throws IOException {
            mock(MergeHandler.MergePolicy.class),  
            SHARD_ID,
    /** prepareMerge with a producer reporting no deletes surfaces an all-alive view. */
        when(primaryMerger.merge(any())).thenThrow(new IOException("original failure"));  
        assertTrue(merges.isEmpty());  
        return preparation;
            LiveDocs.ALL_ALIVE  
        assertTrue(err.getMessage(), err.getMessage().contains("live-docs"));
            }
    }
        when(secondaryMerger.prepareMerge(any())).thenReturn(null);
        snapshotSupplier = () -> { throw new RuntimeException("snapshot unavailable"); };
        MergePreparation prepared = preparationOf(LiveDocs.fromPackedBits(Map.of(1L, new long[] { 0b1L })));
            snapshotSupplier,  
 *
        OneMerge oneMerge = new OneMerge(List.of(segment));  
        OneMerge oneMerge = new OneMerge(List.of(segment));  
        when(preparation.liveDocs()).thenReturn(liveDocs);  
        WriterFileSet s2Wfs = wfs(tempDir, 1L, Set.of("s2.dat"), 5);
import org.opensearch.index.engine.dataformat.LiveDocs;
        Merger primaryMerger = mock(Merger.class);
     * Returns a CompositeMerger built from the default primary+secondary test engines, with the
        executor.execute(plan);
        WriterFileSet inputS = new WriterFileSet(createTempDir().toString(), 1L, Set.of("in.si"), 50, 1L);
        when(primaryMerger.merge(any())).thenReturn(primaryResult);  
        CompositeMerger merger = createCompositeMerger();  
        expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));  
        assertNotNull(ex.getCause());
        WriterFileSet pWfs2 = wfs(tempDir, 2L, Set.of("p2.dat"), 5);  
        Merger secondaryMerger = mock(Merger.class);  
    }
        assertEquals(2, result.getMergedWriterFileSet().size());  
 */  
            segments.add(Segment.builder(i).addSearchableFiles(primaryFormat, pWfs).build());
    }
    @SuppressWarnings("unchecked")
        assertNotNull(result);  
        OneMerge oneMerge = new OneMerge(List.of(segment));
    }
        assertTrue(ex.getMessage().contains("Row count mismatch"));
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
}
            .addSearchableFiles(primaryFormat, pWfs)  
        MergePreparation result = merger.prepareMerge(mergeInputFor(defaultSegment(createTempDir(), 1L, 5)));  
        return new CompositeMerger(compositeEngine, compositeDataFormat);
            @Override  
    // ========== findForceMerges with merge candidates ==========
        when(mapping.size()).thenReturn(100);  
        Path tempDir = createTempDir();
        verify(prepared, times(1)).close();
            snapshotSupplier,  
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);  
        // which throws DirectoryNotEmptyException — caught and logged, not re-thrown
        when(primaryMerger.merge(any())).thenThrow(new IOException("primary fail"));
        MergeHandler handler = createHandler();  
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedPrimaryWfs), STUB_ROW_ID_MAPPING);
        MergeHandler handler = new MergeHandler(
        assertTrue(ex.getMessage().contains("returned null"));
        );
    private static Segment buildSegment(long generation, DataFormat fmt1, WriterFileSet wfs1, DataFormat fmt2, WriterFileSet wfs2) {
    public void testMergePropagatesFrozenLiveDocsToAllFormats() throws IOException {
import org.opensearch.index.engine.dataformat.merge.DataFormatAwareMergePolicy;  
            () -> 1L
        WriterFileSet mergedPrimaryWfs = wfs(tempDir, 99L, Set.of("nonexistent.dat"), 5);
    private static IndexingExecutionEngine<?, ?> mockEngine(DataFormat format, Merger merger) {
        OneMerge oneMerge = new OneMerge(List.of(segment));
import static org.mockito.Mockito.verify;  
        doThrow(new IOException("close failure")).when(prepared).close();
        WriterFileSet secondaryWfs = wfs(tempDir, 1L, Set.of("s1.dat"), 10);  
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);  
        expectThrows(UncheckedIOException.class, () -> handler.doMerge(oneMerge));
            new CompositeMerger(compositeEngine, compositeDataFormat),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});  
        MergeHandler handler = createHandler();
        WriterFileSet mergedS = wfs(tempDir, 99L, Set.of("ms.dat"), 3);
    private DataFormat secondaryFormat;  
    }
            new CompositeMerger(compositeEngine, compositeDataFormat),
import org.opensearch.composite.CompositeDataFormat;
    }
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
    }
        WriterFileSet mergedS = wfs(tempDir, 99L, Set.of("ms.dat"), 2);
        assertFalse("Stale merged file should be deleted on failure", Files.exists(staleFile));  
import static org.mockito.ArgumentMatchers.any;  
        DataFormat secondaryFormat2 = stubFormat("arrow");  
        when(primaryMerger.merge(any())).thenReturn(new MergeResult(Map.of(primaryFormat, mergedP), STUB_ROW_ID_MAPPING));
import org.mockito.ArgumentCaptor;
        Segment segment = buildSegment(0L, primaryFormat, primaryWfs, secondaryFormat, secondaryWfs);  
        CompositeIndexingExecutionEngine engineNoSecondary = mock(CompositeIndexingExecutionEngine.class);
        WriterFileSet primaryWfs = wfs(tempDir, 1L, Set.of("p.dat"), 5);
        // Create many small segments with real files to trigger TieredMergePolicy
        merger.merge(mergeInputFor(segment));  
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> handler.doMerge(oneMerge));  
        snapshotSupplier = () -> new GatedCloseable<>(catalogSnapshot, () -> {});
        IndexingExecutionEngine<?, ?> primaryEngine = mockEngine(primaryFormat, primaryMerger);
    // ========== doMerge: multiple secondaries — fails fast on first error ==========  
        assertSame(oneMerge, retrieved);
        assertTrue(ex.getMessage().contains("secondaries"));
    }
        Merger secondaryMerger2 = mock(Merger.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            public Set<FieldTypeCapabilities> supportedFields() {
        }  
            .build();
        MergeResult primaryResult = new MergeResult(Map.of(primaryFormat, mergedWfs), STUB_ROW_ID_MAPPING);
            snapshotSupplier,
        assertNotNull(ex.getCause());  
        assertSame(primaryMerger, executor.getMerger(primaryFormat));
