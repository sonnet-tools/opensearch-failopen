    public void testDuplicateAfterRefreshIsIdempotent() throws IOException {
        nextReader[0] = openReader();  
            );
        // Second onDeleted: -1 (map) = 1
        DirectoryReader[] nextReader = { null };
        assertEquals(2, counts.size());
        // Empty initial reader — no segments yet.
import org.opensearch.index.mapper.MapperService;
        rm.afterRefresh(true, stubSnapshot(1));
        // snap2: refresh → new wrapper (creation ref = snap2's ref)
        assertEquals(4, wrapped.getRefCount());
        dataFormat = new DataFormat() {  
    private LuceneReaderManager createManager(
            @Override
        rm.afterRefresh(true, snap1);  
    }
        return buildCatalogSnapshot(generation, segs);  
        rm.afterRefresh(true, snap2);
        rm.afterRefresh(true, snap);  
        rm.onDeleted(snap3);  
        assertEquals(1, newWrapper.getRefCount());
                new org.opensearch.index.translog.TranslogConfig(
        rm.afterRefresh(true, snap3);  
import org.opensearch.index.engine.exec.Segment;  
                if (segmentGenerations.contains(gen)) {
            public CatalogSnapshot clone() {  
        DirectoryReader wrapped = rm.getReader(stubSnapshot(1)).directoryReader();  
    public void testMultipleRefreshesEachCreateNewWrapper() throws IOException {
    /** Adds a document without committing, so several can be made to land in one segment. */
        assertEquals(0, wrapper1.getRefCount());  
            }
    /**
        directory = new MMapDirectory(dir);
package org.opensearch.be.lucene;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
        assertSame("snap3 must get the same wrapped reader", newWrapper, snap3Reader);
    public void testWrappedReaderRefCountOnMultipleSnapshots() throws IOException {
            .store(store)
        // snap1: initial wrapper
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
        CatalogSnapshot snap = stubSnapshot(1);
        CatalogSnapshot snap = stubSnapshot(1);
        rm.afterRefresh(true, snap);  
        assertNotSame("Refresh must produce a new wrapper", initialWrapper, newWrapper);
            java.lang.reflect.Field segInfosField = IndexWriter.class.getDeclaredField("segmentInfos");  
        addDoc("doc1", 10L);  
        assertFalse("Should have at least one leaf", leaves.isEmpty());
        // newWrapper: creation(1 for snap2) + incRef(1 for snap3) = 2  
 * Tests for {@link LuceneReaderManager} lifecycle with CatalogSnapshot interactions.  
            @Override  
        rm.onDeleted(snap1);
        CatalogSnapshot snap1 = stubSnapshot(1);  
            @Override
        DirectoryReader snap3Reader = rm.getReader(snap3).directoryReader();
            @Override  
            .translogConfig(  
        CatalogSnapshot snap = stubSnapshot(1, List.of(1L, 2L));  
                if (genAttr == null) continue;  
        addDocWithoutCommit(id);
        nextReader[0] = null;
        assertTrue(wrapped.getRefCount() > 0);
            EngineReaderManager<?> rm = LuceneSearchBackEnd.createReaderManager(settings);
        rm.onDeleted(snap1);
            assertTrue("Leaf reader must be an OpenSearchLeafReader", lrc.reader() instanceof OpenSearchLeafReader);
        Store store = new Store(shardId, idxSettings, new NIOFSDirectory(dataPath), new DummyShardLock(shardId), (x) -> {}, shardPath);
        assertEquals(1, wrapper2.getRefCount());
        DirectoryReader rawReader = openReader();  
        CatalogSnapshot snap1 = stubSnapshot(1);
        // Delete snap2 → releases new wrapper (map -1 = 0)  
    @SuppressForbidden(reason = "Need reflection to read SegmentInfos for building test file sets")  
        addDoc("c", 2);
                        sci.info.dir.toString(),
            }  
        stampLatestSegmentGeneration(1);
            }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        LuceneCommitter committer = new LuceneCommitter(cs);
        try {  
        CatalogSnapshot snap3 = stubSnapshot(3);
        Path translogPath = dataPath.resolve("translog");  
        assertEquals(0, new IndexSearcher(lr1.directoryReader()).count(new MatchAllDocsQuery()));  
    }
        assertSame(first, rm.getReader(snap));
    private void addDoc(String id, long generation) throws IOException {
    }  
    }
        assertNotSame(wrapper1, wrapper3);  
            .codecService(new CodecService(null, idxSettings, LogManager.getLogger(getClass()), java.util.List.of()))
            @Override
        DirectoryReader refreshedRaw = openReader();
        CatalogSnapshot snap = stubSnapshot(1, List.of(1L));
        // RefCount: 1 (creation) + 3 (one incRef per snapshot) = 4  
        rm.afterRefresh(true, stubSnapshot(3));
        }
        rm.onDeleted(stubSnapshot(99));  
            public long priority() {
            return List.of();  
    public void testRefreshCreatesNewWrapper() throws IOException {
import org.apache.lucene.document.Field;  
    // --- Refresh produces new reader: new wrapper lifecycle ---  
        assertNotSame(lr2, lr3);
    }  
        rm.afterRefresh(true, snap2);
    private IndexWriter indexWriter;
 * path that production code requires for IndicesQueryCache compatibility.
        DirectoryReader rawReader = openReader();
        // close() decRefs 3 map entries + 1 releaseInitialReader = 0
        assertTrue(initialWrapper instanceof OpenSearchDirectoryReader);  
        indexWriter.close();
import org.opensearch.common.settings.Settings;
    }
        CatalogSnapshot snap = stubSnapshot(1);  
            protected void closeInternal() {}
import org.apache.lucene.index.FilterLeafReader;  
    }
        assertEquals(0, newWrapper.getRefCount());
            }
        addDocWithoutCommit("a");
            assertNotNull(rm);  
    @Override  
        // snap1: initial wrapper
        assertEquals(0, wrapped.getRefCount());  
                current = flr.getDelegate();
                mock(MapperService.class),
import org.apache.lucene.index.SegmentInfos;  
            public void setUserData(Map<String, String> userData, boolean commitData) {}  
        assertEquals(1, wrapped.getRefCount());  
        // onDeleted(snap2): decRefs newWrapper (-1) and releases initialWrapper via releaseInitialReader (-1)  
            if (last.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE) == null) {  
            org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED,
    }
            SegmentCommitInfo last = segInfos.asList().get(segInfos.size() - 1);
            .build();
            }
            }
        DirectoryReader reader = rm.getReader(snap).directoryReader();  
                String genAttr = sci.info.getAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE);
    // --- Ref counting with wrapped readers ---  
        DirectoryReader rawReader = openReader();  
        CatalogSnapshot snap2 = stubSnapshot(2);  
        assertEquals(0, initialWrapper.getRefCount());
        try {
 * All tests use a non-null ShardId to exercise the OpenSearchDirectoryReader wrapping
                    false
            "Reader must be an OpenSearchDirectoryReader for IndicesQueryCache compatibility",
        if (segmentGenerations.isEmpty()) {
            }
     * Builds a stub snapshot whose segment list contains the given writer generations.  
        DirectoryReader reader,  
    private Directory directory;  
    ) throws IOException {
    public void testOnDeletedUnknownSnapshotIsNoOp() throws IOException {
                    shardId,
            segInfosField.setAccessible(true);
        addDoc("doc2", 20L);  
        addDoc("doc1", 10L);
        assertEquals(0, wrapper2.getRefCount());
import org.apache.lucene.store.NIOFSDirectory;  
            }  
        assertEquals(1, new IndexSearcher(lr2.directoryReader()).count(new MatchAllDocsQuery()));
                    WriterFileSet wfs = new WriterFileSet(  
            }  
import org.apache.lucene.search.IndexSearcher;
        indexWriter.commit();  
        rm.close();  
import org.opensearch.index.engine.exec.EngineReaderManager;
            segInfosField.setAccessible(true);  
        LuceneReaderManager rm = createManager(openReader());  
        rm.afterRefresh(true, snap);  
    public void testAfterRefreshNoOpWhenDidRefreshFalse() throws IOException {
    }
        rm.afterRefresh(true, snap);  
    }
            public long getLastWriterGeneration() {
            @Override
            .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, java.util.Collections.emptyList()))
        // snap3: second refresh
        }
        expectThrows(IllegalStateException.class, () -> rm.getReader(stubSnapshot(42)));
    }
        assertSame(wrapped, rm.getReader(snap3).directoryReader());
        DirectoryReader[] nextReader = { null };
        rm.onDeleted(snap);  
                last.info.putAttribute(LuceneWriter.WRITER_GENERATION_ATTRIBUTE, String.valueOf(generation));
            @Override
            }  
        return DirectoryReader.open(indexWriter);
                return List.of();
                return generation;
     * corresponding leaf will report from {@code SegmentCommitInfo.files()}.
        rm.close();  
        // After onDeleted: -1 (map decRef) -1 (releaseInitialReader) = 0  
        LuceneReaderManager rm = createManager(openReader());  
        assertEquals(0, initialWrapper.getRefCount());  
            }
        assertEquals(1, initialWrapper.getRefCount());
        rm.onDeleted(snap);  
                        sci.info.maxDoc(),
            }
import org.apache.lucene.store.MMapDirectory;
 */  
import org.apache.lucene.document.StringField;
            ReaderManagerConfig settings = new ReaderManagerConfig(
        Path dir = createTempDir();
import org.opensearch.index.engine.exec.DocCounts;
    public void testDocCountsByGenerationReturnsEmptyWithoutAReader() throws IOException {
                )
        for (LeafReaderContext lrc : reader.leaves()) {
import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;
                null
            committer.close();
            }
        // Each new wrapper has refCount=1 (creation=snapshot ref); initial has 1+1=2
            public Set<FieldTypeCapabilities> supportedFields() {  
        rm.onDeleted(snap2);
import org.opensearch.index.engine.EngineConfig;
import org.opensearch.common.lucene.index.OpenSearchLeafReader;  
            )  
        rm.afterRefresh(true, snap3);
}  
        // Initial wrapper: creation(1) + snap1 incRef(1) = 2  
            }
public class LuceneReaderManagerTests extends OpenSearchTestCase {
        rm.onDeleted(snap2);
                    );  
        rm.close();
            for (SegmentCommitInfo sci : segInfos) {
        super.setUp();
            while (current instanceof FilterLeafReader flr) {
                return null;
        String translogUUID = org.opensearch.index.translog.Translog.createEmptyTranslog(
        return new LuceneReaderManager(dataFormat, reader, new java.util.concurrent.ConcurrentHashMap<>(), refresher, SHARD_ID);  
            public long getMinSegmentFormatVersion() {
            assertEquals(SHARD_ID, extracted);
        rm.close();  
            public long getCommitDataFormatVersion() {  
        assertNotSame(wrapper1, wrapper2);
                dataFormat,
            @Override
        CatalogSnapshot snap3 = stubSnapshot(3, List.of(10L));
                    "",  
            assertNotNull("ShardUtils.extractShardId must succeed (required by IndicesQueryCache)", extracted);  
    public void testAfterRefreshCreatesReader() throws IOException {
        EngineConfig engineConfig = new EngineConfig.Builder().indexSettings(idxSettings)  
    private CatalogSnapshot stubSnapshot(long generation, List<Long> segmentGenerations) {
    private List<Segment> buildSegmentsWithFiles(List<Long> segmentGenerations) {
        LuceneReaderManager rm = createManager(openReader());
 *
        LuceneReaderManager rm = createManager(openReader());
        CatalogSnapshot snap = stubSnapshot(1);
import org.opensearch.index.seqno.RetentionLeases;
import org.apache.logging.log4j.LogManager;
        indexWriter.commit();  
        // RefCount: 1 (creation) + 3 (snapshots) = 4
     * Each segment includes a Lucene {@link WriterFileSet} whose files match what the
        // All different wrappers  
        assertEquals(2, lr3.generationToSegmentName().size());
        assertEquals(2, initialWrapper.getRefCount());
        assertEquals(0, newWrapper.getRefCount());
    public void testCreateReaderManagerWithLuceneIndexingEngine() throws IOException {
    }  
        DirectoryReader rawReader = openReader();
                Map.of(),
    private DirectoryReader openReader() throws IOException {
        };
            java.lang.reflect.Field segInfosField = IndexWriter.class.getDeclaredField("segmentInfos");
        CatalogSnapshot snap3 = stubSnapshot(3, List.of(10L, 20L));
        // onDeleted(snap1): decRefs initialWrapper (-1) → 0
import java.io.IOException;
        CatalogSnapshot snap = stubSnapshot(1);  
        assertEquals(1, wrapper3.getRefCount());
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
    }
    }
        } finally {
            }
                return 0;  
import java.util.Optional;  
            public java.util.Set<String> getSegmentNames() {
    public void tearDown() throws Exception {
            public long getNumDocs() {
        assertEquals(0, wrappedReader.getRefCount());
    public void setUp() throws Exception {
    }  
            }  
        DirectoryReader newWrapper = rm.getReader(snap2).directoryReader();
    }  
        directory.close();  
    private void addDocWithoutCommit(String id) throws IOException {
        CommitterConfig cs = new CommitterConfig(engineConfig, () -> {});  
                return 0L;  
        // snap2: first refresh
                    result.add(Segment.builder(gen).addSearchableFiles(LuceneDataFormat.LUCENE_FORMAT_NAME, wfs).build());
            mock(DataFormatRegistry.class),
import org.opensearch.index.engine.exec.commit.CommitterConfig;
        CatalogSnapshot snap = stubSnapshot(1);
    public void testReaderIsWrappedInOpenSearchDirectoryReader() throws IOException {  
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        return stubSnapshot(generation, List.of());
        assertNotSame(lr1, lr2);
        LuceneReaderManager rm = createManager(openReader());
            @Override
        LuceneReader lr1 = rm.getReader(snap1);
                    translogPath,  
        rm.onDeleted(snap2);
    }  
        rm.afterRefresh(true, stubSnapshot(2));  
        addDoc("doc1", 10L);
        nextReader[0] = openReader();
        try {
        store.createEmpty(org.apache.lucene.util.Version.LATEST, translogUUID);
        assertTrue(rm.docCountsByGeneration(snap).isEmpty());
                    idxSettings,
            1L  
        assertEquals(2, new IndexSearcher(lr3.directoryReader()).count(new MatchAllDocsQuery()));
        assertEquals(4, wrapped.getRefCount());
        } catch (ReflectiveOperationException e) {  
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
    // --- OpenSearchDirectoryReader wrapping tests ---
    }  
import org.apache.lucene.document.Document;
                Optional.of(engine),  
        // snap1: no refresh (null) → uses initial wrapper
        for (LeafReaderContext lrc : leaves) {  
    public void testRefreshThenNoRefreshSharesNewWrapper() throws IOException {
        rm.close();
import org.opensearch.index.shard.ShardPath;  
            public long getId() {  
    @Override  
        LuceneReader lr = rm.getReader(snap);
import org.apache.lucene.index.NoMergePolicy;
    private LuceneReaderManager createManager(DirectoryReader reader) throws IOException {  
    private CatalogSnapshot stubSnapshot(long generation) {
        assertNotSame(wrapper2, wrapper3);
import org.apache.lucene.index.SegmentCommitInfo;
        assertEquals(2, wrappedReader.getRefCount());  
        // onDeleted(snap3): decRefs newWrapper (-1) → 0  
        DirectoryReader wrapper2 = rm.getReader(snap2).directoryReader();  
    private void stampLatestSegmentGeneration(long generation) throws IOException {  
        rm.afterRefresh(true, snap);
        // New wrapper: creation ref only (serves as snap2's ref) = 1
import org.opensearch.index.store.Store;
            }  
        ReaderManagerConfig settings = new ReaderManagerConfig(
        indexWriter.deleteDocuments(new Term("id", "a"));
                        gen,
        assertTrue(newWrapper instanceof OpenSearchDirectoryReader);  
import org.opensearch.test.DummyShardLock;  
        DirectoryReader rawReader = openReader();  
            public String getLastCommitFileName() {
        // Add doc1 in generation 10, refresh.  
            }  
import java.util.List;
        // Add doc2 in generation 20.
            if (segInfos.size() == 0) {
        );
        assertEquals(new DocCounts(1, 0), counts.get(2L));
                return 0L;  
        addDoc("doc1", 10L);
    }
            org.apache.lucene.index.LeafReader current = lrc.reader();  
import org.opensearch.be.lucene.index.LuceneCommitter;
import org.apache.lucene.search.MatchAllDocsQuery;  
    }
        rm.afterRefresh(true, snap1);
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
            public List<Segment> getSegments() {
        rm.afterRefresh(true, snap3);
        DirectoryReader wrappedReader = rm.getReader(snap).directoryReader();  
        rm.close();
    public void testDocCountsByGenerationSplitsCountsPerWriterGeneration() throws IOException {  
    }
        rm.afterRefresh(true, snap2);
        addDocWithoutCommit("b");
        nextReader[0] = null;
 * The OpenSearch Contributors require contributions made to  
        assertTrue(ex.getMessage().contains("IndexStoreProvider is required"));  
                new LuceneDataFormat(),
            @Override  
        expectThrows(IllegalStateException.class, () -> rm.getReader(snap));
            // LuceneFilterDelegationHandle needs to unwrap to SegmentReader for segment name lookup
            @Override
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> nextReader[0]);
    }  
                }
        rm.onDeleted(snap3);  
        indexWriter.commit();  
            @Override
        }
            }  
import java.nio.file.Path;
        rm.close();
    @SuppressForbidden(reason = "Need reflection to stamp writer_generation on segments for testing")
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> nextReader[0]);
        return new CatalogSnapshot("test", generation, 1) {
    private CatalogSnapshot buildCatalogSnapshot(long generation, List<Segment> segs) {
        LuceneReaderManager rm = createManager(openReader());
        CatalogSnapshot snap = stubSnapshot(1, List.of(10L));  
            SegmentInfos segInfos = (SegmentInfos) segInfosField.get(indexWriter);
        LuceneReaderManager rm = createManager(openReader());  
            ShardId extracted = ShardUtils.extractShardId(lrc.reader());
        super.tearDown();
        // All snapshots share the same wrapped reader (initial wrapper)
            SegmentInfos segInfos = (SegmentInfos) segInfosField.get(indexWriter);
    }
                        new java.util.HashSet<>(sci.files()),  
            return result;
        CatalogSnapshot snap1 = stubSnapshot(1);  
        assertEquals(0, wrapped.getRefCount());
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> nextReader[0]);
        org.opensearch.common.CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> refresher
        assertEquals(SHARD_ID, ((OpenSearchDirectoryReader) reader).shardId());
import org.opensearch.index.codec.CodecService;
        assertEquals(0, wrapper3.getRefCount());
        assertEquals(new DocCounts(1, 1), counts.get(1L));  
    public void testWrappedReaderLeavesCanBeUnwrappedToSegmentReader() throws IOException {  
        ShardId shardId = new ShardId("test", "_na_", 0);  
            public Collection<String> getFiles(boolean includeSegmentsFile) {
import org.apache.lucene.index.LeafReaderContext;  
        assertEquals(1, newWrapper.getRefCount());  
/**
    public void testCloseReleasesAllWrappedReaderRefs() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.IndexWriterConfig;
            throw new RuntimeException(e);  
    }  
import org.opensearch.be.lucene.index.LuceneWriter;  
        assertNotNull(lr2.generationToSegmentName().get(10L));  
        assertNotNull(rm.getReader(snap));
                return 0L;
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> null);
        DirectoryReader reader = rm.getReader(snap).directoryReader();
            store.close();  
                return List.of();
                mock(DataFormatRegistry.class),
import org.opensearch.index.shard.ShardUtils;
            Optional.empty(),  
        assertEquals(1, newWrapper.getRefCount());
import java.util.Map;
                idxSettings,
        // Old snapshot still sees 0 docs
                store  
        LuceneReader first = rm.getReader(snap);
        LuceneReaderManager rm = createManager(openReader());
        DirectoryReader wrapped = rm.getReader(snap1).directoryReader();
        // First onDeleted: -1 (map) -1 (releaseInitialReader) = 2  
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
import org.opensearch.index.IndexSettings;  
        Path dataPath = dir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
        LuceneReaderManager rm = createManager(openReader());
        DirectoryReader initialWrapper = rm.getReader(snap1).directoryReader();
    public void testOnDeletedClosesWrappedReader() throws IOException {  
        );  
        // snap2: refresh with new reader → new wrapper created
            }
        doc.add(new StringField("id", id, Field.Store.YES));
        DirectoryReader rawReader = openReader();  
        addDoc("doc1", 10L);
            @Override  
        List<Segment> segs = buildSegmentsWithFiles(segmentGenerations);
        Document doc = new Document();  
                return Map.of();
    }
            reader instanceof OpenSearchDirectoryReader
import org.apache.lucene.index.IndexWriter;
            public Map<String, String> getUserData() {
                return "lucene";  
                long gen = Long.parseLong(genAttr);
    }  
    public void testWrappedReaderLeavesExposeShardId() throws IOException {
            public String name() {
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;  
    private static final ShardId SHARD_ID = new ShardId("test_index", "_na_", 0);  
                        0L
        assertEquals(0, new IndexSearcher(lr1.directoryReader()).count(new MatchAllDocsQuery()));  
import org.apache.lucene.index.DirectoryReader;
        assertEquals(0, wrapped.getRefCount());
        LuceneReaderManager rm = createManager(openReader());  
        rm.afterRefresh(true, snap1);
        rm.onDeleted(snap3);
        rm.afterRefresh(true, snap);
    public void testCreateReaderManagerWithEmptyProviderThrows() {
        } catch (ReflectiveOperationException | IOException e) {
        assertEquals(2, wrapper1.getRefCount());  
import java.util.Collection;  
        nextReader[0] = refreshedRaw;
        nextReader[0] = openReader();  
        rm.afterRefresh(true, snap3);  
        rm.afterRefresh(true, snap2);
                return Set.of();
            @Override  
 * SPDX-License-Identifier: Apache-2.0
            throw new IOException("Failed to stamp writer_generation via reflection", e);
        // Delete snap1 → releases initial wrapper (map -1, releaseInitial -1 = 0)
            @Override  
                    org.opensearch.common.util.BigArrays.NON_RECYCLING_INSTANCE,
        }
import org.apache.lucene.index.Term;
        DirectoryReader[] nextReader = { null };
        // initialWrapper had: creation(1) + snap1 incRef(1) - releaseInitial(1) = 1  
        Map<Long, DocCounts> counts = rm.docCountsByGeneration(snap);  
            public String serializeToString() {
        LuceneReader lr2 = rm.getReader(snap2);
import static org.mockito.Mockito.mock;  
import org.opensearch.test.OpenSearchTestCase;
                return "";
        rm.onDeleted(snap);
        Path dir = createTempDir();  
        assertSame(wrapped, rm.getReader(snap2).directoryReader());  
        CatalogSnapshot snap1 = stubSnapshot(1);  
    }
        DirectoryReader wrapper1 = rm.getReader(snap1).directoryReader();
            @Override
            dataFormat,
        LuceneReaderManager rm = createManager(openReader());
        assertTrue(lr1.generationToSegmentName().isEmpty());
                return 0;
                return segs;  
        assertEquals(2, newWrapper.getRefCount());
/*  
        indexWriter.close();
        nextReader[0] = null;
        nextReader[0] = null;
                shardPath,  
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
        stampLatestSegmentGeneration(generation);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
            shardId,
            );  
        rm.afterRefresh(true, snap);
        CatalogSnapshot snap2 = stubSnapshot(2, List.of(10L));
        rm.afterRefresh(true, snap1);
            Map.of(),
                return;  
        // Third onDeleted: -1 (map) = 0 → closed
            @Override
            null,  
        assertTrue(wrappedReader instanceof OpenSearchDirectoryReader);
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> null);  
        rm.close();
    public void testWrappedReaderRefCountOnSingleSnapshot() throws IOException {
        rm.close();
                return Set.of();
        rm.close();
            @Override  
    }  
        // Wrapper refCount: 1 (creation/initial) + 1 (snapshot incRef) = 2
        addDoc("doc2", 20L);  
import org.opensearch.core.index.shard.ShardId;
        DirectoryReader wrapped = lr.directoryReader();  
import org.opensearch.test.IndexSettingsModule;
        CatalogSnapshot snap3 = stubSnapshot(3, List.of(10L, 20L));
        DirectoryReader wrapper3 = rm.getReader(snap3).directoryReader();
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> LuceneSearchBackEnd.createReaderManager(settings));
        rm.afterRefresh(true, snap);  
        // snap3: no refresh → shares new wrapper (incRef)  
            public Collection<WriterFileSet> getSearchableFiles(String df) {
        LuceneReaderManager rm = createManager(openReader());
import org.opensearch.index.engine.exec.WriterFileSet;
        return createManager(reader, (dr, sis) -> DirectoryReader.openIfChanged(dr));
import org.opensearch.index.engine.dataformat.DataFormat;  
    public void testMultipleRefreshesWithIndexing() throws IOException {
            LuceneIndexingExecutionEngine engine = new LuceneIndexingExecutionEngine(
    }
    }
 */  
    // --- Functional tests with indexing ---  
import java.util.Set;
            @Override  
        CatalogSnapshot snap = stubSnapshot(1, List.of(10L));
        indexWriter.addDocument(doc);
            public Set<String> getDataFormats() {  
 * compatible open source license.
        DirectoryReader newWrapper = rm.getReader(snap2).directoryReader();  
        rm.onDeleted(snap2);
        rm.afterRefresh(true, snap2);  
import org.apache.lucene.store.Directory;
            List<Segment> result = new java.util.ArrayList<>();  
        };  
        }
        CatalogSnapshot snap1 = stubSnapshot(1);  
        indexWriter = new IndexWriter(directory, new IndexWriterConfig());
        assertTrue(  
        // Hides "a" without creating a new segment: generation 1 keeps both rows, one now hidden.
                return this;
            null
        DirectoryReader reader = rm.getReader(snap).directoryReader();
        rm.afterRefresh(true, snap1);
        List<LeafReaderContext> leaves = reader.leaves();  
        rm.close();
            translogPath,  
                committer,  
        indexWriter = new IndexWriter(directory, new IndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE));
        }
     */  
            }  
        assertEquals(2, wrapped.getRefCount());
            public long getFormatVersionForFile(String file) {
        java.nio.file.Files.createDirectories(dataPath);
                return 0L;
        rm.onDeleted(snap1);  
            assertTrue("Unwrapped leaf must be a SegmentReader", current instanceof org.apache.lucene.index.SegmentReader);
        addDoc("a", 1);  
                return java.util.Set.of();  
        rm.onDeleted(snap1);
            }
        // close() cleans up all
    }
    // --- Core lifecycle tests ---
        );  
        DirectoryReader initialWrapper = rm.getReader(snap1).directoryReader();
    private DataFormat dataFormat;
        rm.afterRefresh(true, snap);  
    }  
import org.opensearch.common.SuppressForbidden;
        java.nio.file.Files.createDirectories(translogPath);
        addDoc("doc1", 10L);  
        rm.afterRefresh(false, snap);  
    public void testGetReaderThrowsForUnknownSnapshot() throws IOException {
    // --- LuceneSearchBackEnd.createReaderManager tests ---
        LuceneReader lr3 = rm.getReader(snap3);  
        LuceneReaderManager rm = createManager(rawReader, (dr, sis) -> null);  
