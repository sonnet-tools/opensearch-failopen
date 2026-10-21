        assertNotSame("Refresh must produce a new wrapper", initialWrapper, newWrapper);
        );
                        sci.info.dir.toString(),
        assertSame("snap3 must get the same wrapped reader", newWrapper, snap3Reader);
        rm.afterRefresh(true, snap2);
        CatalogSnapshot snap3 = stubSnapshot(3, List.of(10L, 20L));
        LuceneReaderManager rm = createManager(openReader());
        // All snapshots share the same wrapped reader (initial wrapper)
            assertEquals(SHARD_ID, extracted);
    public void testWrappedReaderRefCountOnMultipleSnapshots() throws IOException {
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
     */
        LuceneReaderManager rm = createManager(openReader());
    }
    private void addDocWithoutCommit(String id) throws IOException {
    }
import org.opensearch.index.engine.exec.commit.CommitterConfig;
            java.lang.reflect.Field segInfosField = IndexWriter.class.getDeclaredField("segmentInfos");
        assertEquals(1, newWrapper.getRefCount());
                return List.of();
            @Override
        assertSame(wrapped, rm.getReader(snap2).directoryReader());
import static org.mockito.Mockito.mock;
        rm.afterRefresh(true, snap2);
                return generation;
            )
        nextReader[0] = refreshedRaw;
        // New wrapper: creation ref only (serves as snap2's ref) = 1
        indexWriter.close();
import org.opensearch.be.lucene.index.LuceneWriter;
    public void setUp() throws Exception {
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
        // snap1: initial wrapper
        Map<Long, DocCounts> counts = rm.docCountsByGeneration(snap);
 *
import org.apache.lucene.index.FilterLeafReader;
import org.opensearch.common.SuppressForbidden;
                if (segmentGenerations.contains(gen)) {
                return Map.of();
        DirectoryReader wrapped = rm.getReader(stubSnapshot(1)).directoryReader();
                committer,
import org.opensearch.be.lucene.index.LuceneCommitter;
import org.opensearch.index.engine.EngineConfig;
        rm.close();
        addDocWithoutCommit("b");
        rm.afterRefresh(true, snap);
        assertEquals(0, wrapper3.getRefCount());
 * compatible open source license.
        rm.afterRefresh(true, snap);
        rm.afterRefresh(true, snap1);
    public void testReaderIsWrappedInOpenSearchDirectoryReader() throws IOException {
        assertSame(first, rm.getReader(snap));
        DirectoryReader reader = rm.getReader(snap).directoryReader();
    /** Adds a document without committing, so several can be made to land in one segment. */
        // close() decRefs 3 map entries + 1 releaseInitialReader = 0
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
        // RefCount: 1 (creation) + 3 (one incRef per snapshot) = 4
            }
                if (genAttr == null) continue;
        assertEquals(new DocCounts(1, 0), counts.get(2L));
                return 0L;
        assertEquals(0, newWrapper.getRefCount());
            @Override
            }
            1L
        DirectoryReader wrapper2 = rm.getReader(snap2).directoryReader();
        assertEquals(2, wrapped.getRefCount());
    public void testGetReaderThrowsForUnknownSnapshot() throws IOException {
        Path dataPath = dir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
                return Set.of();
        assertTrue(lr1.generationToSegmentName().isEmpty());
        assertEquals(4, wrapped.getRefCount());
        assertNotNull(lr2.generationToSegmentName().get(10L));
            if (segInfos.size() == 0) {
            }
        rm.afterRefresh(true, stubSnapshot(1));
        assertEquals(0, initialWrapper.getRefCount());
        // Delete snap2 → releases new wrapper (map -1 = 0)
        indexWriter.close();
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> nextReader[0]);
    public void testRefreshThenNoRefreshSharesNewWrapper() throws IOException {
        assertNotNull(rm.getReader(snap));
        addDoc("doc1", 10L);
            return result;
package org.opensearch.be.lucene;
        return DirectoryReader.open(indexWriter);
            @Override
        // RefCount: 1 (creation) + 3 (snapshots) = 4
        DirectoryReader initialWrapper = rm.getReader(snap1).directoryReader();
        LuceneReaderManager rm = createManager(openReader());
        rm.afterRefresh(true, snap1);
        // onDeleted(snap2): decRefs newWrapper (-1) and releases initialWrapper via releaseInitialReader (-1)
import org.opensearch.index.codec.CodecService;
            "Reader must be an OpenSearchDirectoryReader for IndicesQueryCache compatibility",
        DirectoryReader wrappedReader = rm.getReader(snap).directoryReader();
                return 0;
                current = flr.getDelegate();
        } finally {
        rm.onDeleted(snap2);
            public long getNumDocs() {
                new LuceneDataFormat(),
        nextReader[0] = null;
    public void testMultipleRefreshesWithIndexing() throws IOException {
    public void testWrappedReaderLeavesExposeShardId() throws IOException {
import org.apache.lucene.index.SegmentCommitInfo;
    public void testAfterRefreshCreatesReader() throws IOException {
                null
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
    // --- Core lifecycle tests ---
                return "lucene";
        rm.afterRefresh(true, snap);
        // onDeleted(snap1): decRefs initialWrapper (-1) → 0
        // snap2: refresh with new reader → new wrapper created
            public String getLastCommitFileName() {
        CatalogSnapshot snap = stubSnapshot(1, List.of(1L, 2L));
    }
import org.apache.lucene.index.LeafReaderContext;
            @Override
    private CatalogSnapshot stubSnapshot(long generation, List<Long> segmentGenerations) {
        DirectoryReader rawReader = openReader();
            ShardId extracted = ShardUtils.extractShardId(lrc.reader());
        try {
        CatalogSnapshot snap = stubSnapshot(1);
            }
        // Hides "a" without creating a new segment: generation 1 keeps both rows, one now hidden.
    }
    }
    }
import org.opensearch.test.OpenSearchTestCase;
                String genAttr = sci.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE);
        return new LuceneReaderManager(dataFormat, reader, new java.util.concurrent.ConcurrentHashMap<>(), refresher, SHARD_ID);
        assertNotSame(wrapper2, wrapper3);
                last.info.putAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE, String.valueOf(generation));
 * Tests for {@link LuceneReaderManager} lifecycle with CatalogSnapshot interactions.
                shardPath,
                    idxSettings,
        try {
        org.opensearch.common.CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> refresher
                Map.of(),
        rm.close();
        LuceneReaderManager rm = createManager(openReader());
        );
        CatalogSnapshot snap = stubSnapshot(1);
            @Override
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    }
        assertEquals(SHARD_ID, ((OpenSearchDirectoryReader) reader).shardId());
            null
                    org.opensearch.common.util.BigArrays.NON_RECYCLING_INSTANCE,
        assertEquals(1, initialWrapper.getRefCount());
 */
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    public void testAfterRefreshNoOpWhenDidRefreshFalse() throws IOException {
import org.apache.logging.log4j.LogManager;
            @Override
import org.apache.lucene.store.NIOFSDirectory;
        indexWriter.commit();
        return buildCatalogSnapshot(generation, segs);
import org.apache.lucene.index.Term;
            public Map<String, String> getUserData() {
    }
            }
            Optional.empty(),
        // Second onDeleted: -1 (map) = 1
public class LuceneReaderManagerTests extends OpenSearchTestCase {
        addDoc("doc2", 20L);
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
        assertEquals(2, wrappedReader.getRefCount());
        rm.close();
                return this;
                dataFormat,
            SegmentInfos segInfos = (SegmentInfos) segInfosField.get(indexWriter);
            committer.close();
            ReaderManagerConfig settings = new ReaderManagerConfig(
    }
        DirectoryReader rawReader = openReader();
    public void testCreateReaderManagerWithEmptyProviderThrows() {
            assertTrue("Leaf reader must be an OpenSearchLeafReader", lrc.reader() instanceof OpenSearchLeafReader);
            }
        ReaderManagerConfig settings = new ReaderManagerConfig(
        assertEquals(new DocCounts(1, 1), counts.get(1L));
        rm.close();
        assertEquals(2, initialWrapper.getRefCount());
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
                    WriterFileSet wfs = new WriterFileSet(
            assertNotNull(rm);
        if (segmentGenerations.isEmpty()) {
            }
            .translogConfig(
                }
import org.opensearch.common.lucene.index.OpenSearchLeafReader;
        indexWriter.commit();
    }
        rm.afterRefresh(true, snap);
        CatalogSnapshot snap = stubSnapshot(1);
        // Add doc1 in generation 10, refresh.
    private LuceneReaderManager createManager(
        LuceneReaderManager rm = createManager(openReader());
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
    }
            }
            .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, java.util.Collections.emptyList()))
import org.opensearch.test.DummyShardLock;
import org.opensearch.index.engine.exec.DocCounts;
    public void testCreateReaderManagerWithLuceneIndexingEngine() throws IOException {
            }
    // --- Refresh produces new reader: new wrapper lifecycle ---
    private CatalogSnapshot stubSnapshot(long generation) {
        CatalogSnapshot snap = stubSnapshot(1);
        LuceneReaderManager rm = createManager(openReader());
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
import org.apache.lucene.index.DirectoryReader;
            public long getCommitDataFormatVersion() {
            }
        DirectoryReader refreshedRaw = openReader();
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> null);
        DirectoryReader wrapper1 = rm.getReader(snap1).directoryReader();
        LuceneReaderManager rm = createManager(openReader());
        CatalogSnapshot snap = stubSnapshot(1, List.of(1L));
     * corresponding leaf will report from {@code SegmentCommitInfo.files()}.
        DirectoryReader[] nextReader = { null };
            SegmentInfos segInfos = (SegmentInfos) segInfosField.get(indexWriter);
            .store(store)
            .codecService(new CodecService(null, idxSettings, LogManager.getLogger(getClass()), java.util.List.of()))
        // snap1: no refresh (null) → uses initial wrapper
        assertEquals(0, new IndexSearcher(lr1.directoryReader()).count(new MatchAllDocsQuery()));
        nextReader[0] = openReader();
        assertEquals(0, new IndexSearcher(lr1.directoryReader()).count(new MatchAllDocsQuery()));
            java.lang.reflect.Field segInfosField = IndexWriter.class.getDeclaredField("segmentInfos");
            }
    private Directory directory;
        rm.afterRefresh(true, snap2);
import org.apache.lucene.document.StringField;
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> nextReader[0]);
        rm.afterRefresh(true, snap1);
import java.util.Map;
    }
    public void testMultipleRefreshesEachCreateNewWrapper() throws IOException {
        assertEquals(0, wrapped.getRefCount());
                return 0L;
    // --- LuceneSearchBackEnd.createReaderManager tests ---
            org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED,
        List<LeafReaderContext> leaves = reader.leaves();
        store.createEmpty(org.apache.lucene.util.Version.LATEST, translogUUID);
            public CatalogSnapshot clone() {
        assertTrue(wrappedReader instanceof OpenSearchDirectoryReader);
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
        addDoc("doc1", 10L);
        // Add doc2 in generation 20.
    /**
 * path that production code requires for IndicesQueryCache compatibility.
        nextReader[0] = null;
            null,
        rm.afterRefresh(false, snap);
        nextReader[0] = openReader();
import org.opensearch.index.seqno.RetentionLeases;
    }
        addDoc("doc1", 10L);
        assertEquals(2, newWrapper.getRefCount());
        DirectoryReader initialWrapper = rm.getReader(snap1).directoryReader();
        return createManager(reader, (dr, sis) -> DirectoryReader.openIfChanged(dr));
                Optional.of(engine),
        }
        CatalogSnapshot snap = stubSnapshot(1);
        rm.afterRefresh(true, snap1);
import java.nio.file.Path;
        DirectoryReader rawReader = openReader();
    }
                idxSettings,
    private List<Segment> buildSegmentsWithFiles(List<Long> segmentGenerations) {
        // All different wrappers
        rm.onDeleted(snap1);
            mock(DataFormatRegistry.class),
        LuceneReaderManager rm = createManager(openReader());
        addDoc("c", 2);
import org.apache.lucene.store.Directory;
        addDocWithoutCommit("a");
            org.apache.lucene.index.LeafReader current = lrc.reader();
    public void testOnDeletedClosesWrappedReader() throws IOException {
        rm.afterRefresh(true, stubSnapshot(2));
        assertFalse("Should have at least one leaf", leaves.isEmpty());
        CatalogSnapshot snap3 = stubSnapshot(3);
            }
        rm.close();
        CatalogSnapshot snap = stubSnapshot(1, List.of(10L));
                return java.util.Set.of();
        // Old snapshot still sees 0 docs
                return;
        addDoc("a", 1);
import org.opensearch.index.engine.exec.WriterFileSet;
                return segs;
        indexWriter = new IndexWriter(directory, new IndexWriterConfig());
            public String serializeToString() {
        directory.close();
import org.opensearch.index.store.Store;
        Path dir = createTempDir();
                return 0L;
            @Override
        assertEquals(0, wrappedReader.getRefCount());
            @Override
        stampLatestSegmentGeneration(generation);
        LuceneReaderManager rm = createManager(openReader());
        java.nio.file.Files.createDirectories(translogPath);
        super.tearDown();
     * Builds a stub snapshot whose segment list contains the given writer generations.
import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;
        Path dir = createTempDir();
        CatalogSnapshot snap1 = stubSnapshot(1);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.SegmentInfos;
import org.opensearch.index.engine.exec.Segment;
    }
        indexWriter.addDocument(doc);
        assertEquals(2, wrapper1.getRefCount());
        CatalogSnapshot snap = stubSnapshot(1, List.of(10L));
        CatalogSnapshot snap3 = stubSnapshot(3, List.of(10L));
        DirectoryReader reader = rm.getReader(snap).directoryReader();
        // Each new wrapper has refCount=1 (creation=snapshot ref); initial has 1+1=2
    private void stampLatestSegmentGeneration(long generation) throws IOException {
import org.apache.lucene.index.NoMergePolicy;
    @SuppressForbidden(reason = "Need reflection to stamp writer_generation on segments for testing")
        rm.onDeleted(snap2);
                mock(MapperService.class),
        super.setUp();
            public java.util.Set<String> getSegmentNames() {
        rm.onDeleted(snap2);
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
            dataFormat,
        assertEquals(0, wrapped.getRefCount());
import org.apache.lucene.index.IndexWriter;
/**
        // snap1: initial wrapper
        assertEquals(4, wrapped.getRefCount());
            assertTrue("Unwrapped leaf must be a SegmentReader", current instanceof org.apache.lucene.index.SegmentReader);
    public void testWrappedReaderRefCountOnSingleSnapshot() throws IOException {
        rm.afterRefresh(true, snap2);
            LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
        rm.onDeleted(snap1);
/*
    }
        LuceneReader first = rm.getReader(snap);
            shardId,
        Path translogPath = dataPath.resolve("translog");
            public long getFormatVersionForFile(String file) {
    @SuppressForbidden(reason = "Need reflection to read SegmentInfos for building test file sets")
        DirectoryReader rawReader = openReader();
        DirectoryReader newWrapper = rm.getReader(snap2).directoryReader();
    public void testDocCountsByGenerationReturnsEmptyWithoutAReader() throws IOException {
        rm.afterRefresh(true, snap2);
    }
        assertTrue(initialWrapper instanceof OpenSearchDirectoryReader);
        java.nio.file.Files.createDirectories(dataPath);
            );
import java.io.IOException;
        rm.afterRefresh(true, snap3);
import org.opensearch.index.mapper.MapperService;
    private LuceneReaderManager createManager(DirectoryReader reader) throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
        };
import org.opensearch.index.engine.exec.EngineReaderManager;
                return 0L;
        assertEquals(2, new IndexSearcher(lr3.directoryReader()).count(new MatchAllDocsQuery()));
            );
        assertSame(wrapped, rm.getReader(snap3).directoryReader());
        DirectoryReader wrapped = lr.directoryReader();
        nextReader[0] = openReader();
        addDoc("doc2", 20L);
        rm.afterRefresh(true, snap);
        rm.close();
        rm.onDeleted(snap1);
        assertEquals(0, wrapped.getRefCount());
        // Third onDeleted: -1 (map) = 0 → closed
                    false
import org.opensearch.index.IndexSettings;
    public void testWrappedReaderLeavesCanBeUnwrappedToSegmentReader() throws IOException {
import java.util.List;
import java.util.Collection;
            store.close();
            public long getLastWriterGeneration() {
        DirectoryReader wrapped = rm.getReader(snap1).directoryReader();
        assertEquals(1, wrapped.getRefCount());
        // Empty initial reader — no segments yet.
        // snap3: no refresh → shares new wrapper (incRef)
        assertTrue(
                    result.add(Segment.builder(gen).addSearchableFiles(LuceneDataFormat.LUCENE_FORMAT_NAME, wfs).build());
        assertEquals(0, newWrapper.getRefCount());
        assertEquals(1, newWrapper.getRefCount());
        assertEquals(1, newWrapper.getRefCount());
        DirectoryReader reader = rm.getReader(snap).directoryReader();
        assertNotSame(lr2, lr3);
        // First onDeleted: -1 (map) -1 (releaseInitialReader) = 2
            translogPath,
        assertTrue(wrapped.getRefCount() > 0);
                return Set.of();
        DirectoryReader newWrapper = rm.getReader(snap2).directoryReader();
        rm.onDeleted(snap1);
    ) throws IOException {
            for (SegmentCommitInfo sci : segInfos) {
        rm.close();
            List<Segment> result = new java.util.ArrayList<>();
                        new java.util.HashSet<>(sci.files()),
        addDocWithoutCommit(id);
import org.apache.lucene.document.Document;
            if (last.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE) == null) {
import java.util.Optional;
        DirectoryReader reader,
import org.opensearch.index.shard.ShardUtils;
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> null);
                    translogPath,
    private IndexWriter indexWriter;
        String translogUUID = org.opensearch.index.translog.Translog.createEmptyTranslog(
            }
        rm.onDeleted(snap);
        // snap2: refresh → new wrapper (creation ref = snap2's ref)
        };
        nextReader[0] = null;
        ShardId shardId = new ShardId("test", "_na_", 0);
        assertNotSame(lr1, lr2);
            reader instanceof OpenSearchDirectoryReader
        rm.close();
        LuceneReader lr = rm.getReader(snap);
            public Collection<WriterFileSet> getSearchableFiles(String df) {
        CatalogSnapshot snap3 = stubSnapshot(3, List.of(10L, 20L));
    }
            // LuceneFilterDelegationHandle needs to unwrap to SegmentReader for segment name lookup
                        0L
        expectThrows(IllegalStateException.class, () -> rm.getReader(stubSnapshot(42)));
        rm.afterRefresh(true, snap3);
        for (LeafReaderContext lrc : reader.leaves()) {
                        sci.info.maxDoc(),
        // initialWrapper had: creation(1) + snap1 incRef(1) - releaseInitial(1) = 1
            @Override
            }
        rm.afterRefresh(true, snap3);
        assertTrue(newWrapper instanceof OpenSearchDirectoryReader);
    public void testOnDeletedUnknownSnapshotIsNoOp() throws IOException {
                return 0;
        DirectoryReader rawReader = openReader();
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> LuceneSearchBackEnd.createReaderManager(settings));
                    );
            @Override
            }
                long gen = Long.parseLong(genAttr);
        rm.onDeleted(snap);
        for (LeafReaderContext lrc : leaves) {
                        gen,
        rm.afterRefresh(true, snap);
    }
        DirectoryReader snap3Reader = rm.getReader(snap3).directoryReader();
        rm.afterRefresh(true, snap1);
            }
            public Set<String> getDataFormats() {
        assertEquals(1, new IndexSearcher(lr2.directoryReader()).count(new MatchAllDocsQuery()));
        CatalogSnapshot snap2 = stubSnapshot(2);
                store
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        assertEquals(0, wrapper2.getRefCount());
            @Override
        rm.onDeleted(stubSnapshot(99));
            public Collection<String> getFiles(boolean includeSegmentsFile) {
        assertNotSame(wrapper1, wrapper3);
                mock(DataFormatRegistry.class),
        // close() cleans up all
                    shardId,
        rm.afterRefresh(true, snap3);
        // Wrapper refCount: 1 (creation/initial) + 1 (snapshot incRef) = 2
import org.apache.lucene.index.IndexWriterConfig;
    }
                return List.of();
        addDoc("doc1", 10L);
        assertEquals(1, wrapper2.getRefCount());
        assertEquals(1, wrapper3.getRefCount());
            @Override
    }
        addDoc("doc1", 10L);
            }
        );
            }
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> null);
        nextReader[0] = null;
    private CatalogSnapshot buildCatalogSnapshot(long generation, List<Segment> segs) {
        assertEquals(2, counts.size());
    }
        // snap3: second refresh
    }
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            EngineReaderManager<?> rm = LuceneSearchBackEnd.createReaderManager(settings);
        CommitterConfig cs = new CommitterConfig(engineConfig, () -> {});
        rm.onDeleted(snap3);
import org.apache.lucene.document.Field;
        assertEquals(2, lr3.generationToSegmentName().size());
        DirectoryReader wrapper3 = rm.getReader(snap3).directoryReader();
    }
            Map.of(),
            assertNotNull("ShardUtils.extractShardId must succeed (required by IndicesQueryCache)", extracted);
    }
            @Override
        }
        dataFormat = new DataFormat() {
            @Override
        stampLatestSegmentGeneration(1);
    // --- OpenSearchDirectoryReader wrapping tests ---
import org.opensearch.index.shard.ShardPath;
            public void setUserData(Map<String, String> userData, boolean commitData) {}
        rm.close();
        rm.afterRefresh(true, snap);
        DirectoryReader[] nextReader = { null };
    public void testCloseReleasesAllWrappedReaderRefs() throws IOException {
import org.opensearch.index.engine.dataformat.DataFormat;
        assertTrue(rm.docCountsByGeneration(snap).isEmpty());
import java.util.Set;
        // Initial wrapper: creation(1) + snap1 incRef(1) = 2
        } catch (ReflectiveOperationException | IOException e) {
        CatalogSnapshot snap1 = stubSnapshot(1);
    }
        rm.close();
        CatalogSnapshot snap = stubSnapshot(1);
    private static final ShardId SHARD_ID = new ShardId("test_index", "_na_", 0);
    @Override
            public String name() {
        Document doc = new Document();
 * The OpenSearch Contributors require contributions made to
        assertNotSame(wrapper1, wrapper2);
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
            segInfosField.setAccessible(true);
        rm.afterRefresh(true, stubSnapshot(3));
        LuceneReader lr3 = rm.getReader(snap3);
import org.opensearch.test.IndexSettingsModule;
                return null;
    }
        rm.close();
import org.apache.lucene.store.MMapDirectory;
        LuceneReaderManager rm = createManager(openReader());
                )
        LuceneCommitter committer = new LuceneCommitter(cs);
    public void testDocCountsByGenerationSplitsCountsPerWriterGeneration() throws IOException {
        indexWriter.commit();
    private DataFormat dataFormat;
        DirectoryReader rawReader = openReader();
        LuceneReader lr1 = rm.getReader(snap1);
    public void testDuplicateAfterRefreshIsIdempotent() throws IOException {
    }
        List<Segment> segs = buildSegmentsWithFiles(segmentGenerations);
                    "",
        directory = new MMapDirectory(dir);
}
        indexWriter = new IndexWriter(directory, new IndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE));
        doc.add(new StringField("id", id, Field.Store.YES));
        EngineConfig engineConfig = new EngineConfig.Builder().indexSettings(idxSettings)
        rm.onDeleted(snap2);
            }
        } catch (ReflectiveOperationException e) {
        }
            throw new RuntimeException(e);
        CatalogSnapshot snap1 = stubSnapshot(1);
 * SPDX-License-Identifier: Apache-2.0
            public long getId() {
        // newWrapper: creation(1 for snap2) + incRef(1 for snap3) = 2
    private void addDoc(String id, long generation) throws IOException {
    }
        LuceneReaderManager rm = createManager(openReader());
            @Override
    // --- Functional tests with indexing ---
            @Override
            }
    }
                return "";
        Store store = new Store(shardId, idxSettings, new NIOFSDirectory(dataPath), new DummyShardLock(shardId), (x) -> {}, shardPath);
    @Override
            public long getMinSegmentFormatVersion() {
            return List.of();
                new org.opensearch.index.translog.TranslogConfig(
        LuceneReader lr2 = rm.getReader(snap2);
            segInfosField.setAccessible(true);
        LuceneReaderManager rm = createManager(openReader());
    // --- Ref counting with wrapped readers ---
            while (current instanceof FilterLeafReader flr) {
            public long priority() {
            @Override
        assertEquals(0, wrapper1.getRefCount());
        indexWriter.deleteDocuments(new Term("id", "a"));
            throw new IOException("Failed to stamp writer_generation via reflection", e);
    }
        addDoc("doc1", 10L);
    public void testRefreshCreatesNewWrapper() throws IOException {
            public List<Segment> getSegments() {
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
 * All tests use a non-null ShardId to exercise the OpenSearchDirectoryReader wrapping
        return new CatalogSnapshot("test", generation, 1) {
            }
        // After onDeleted: -1 (map decRef) -1 (releaseInitialReader) = 0
        rm.onDeleted(snap);
            public Set<FieldTypeCapabilities> supportedFields() {
     * Each segment includes a Lucene {@link WriterFileSet} whose files match what the
            @Override
        }
        DirectoryReader[] nextReader = { null };
import org.opensearch.common.settings.Settings;
        }
        // Delete snap1 → releases initial wrapper (map -1, releaseInitial -1 = 0)
        rm.afterRefresh(true, snap);
            @Override
        CatalogSnapshot snap1 = stubSnapshot(1);
            protected void closeInternal() {}
        rm.onDeleted(snap3);
            }
        return stubSnapshot(generation, List.of());
            .build();
        rm.afterRefresh(true, snap);
        try {
import org.apache.lucene.search.IndexSearcher;
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> nextReader[0]);
        assertTrue(ex.getMessage().contains("IndexStoreProvider is required"));
        rm.onDeleted(snap3);
import org.opensearch.core.index.shard.ShardId;
        // snap2: first refresh
    public void tearDown() throws Exception {
        // onDeleted(snap3): decRefs newWrapper (-1) → 0
        }
    private DirectoryReader openReader() throws IOException {
        CatalogSnapshot snap1 = stubSnapshot(1);
 */
        assertEquals(0, initialWrapper.getRefCount());
            SegmentCommitInfo last = segInfos.asList().get(segInfos.size() - 1);
