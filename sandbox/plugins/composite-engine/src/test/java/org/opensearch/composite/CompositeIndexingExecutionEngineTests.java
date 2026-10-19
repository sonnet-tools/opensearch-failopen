        assertNotNull(engine.getPrimaryDelegate());  
/*  
            return plugin.indexingEngine(null);  
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));
            .put("index.composite.primary_data_format", primaryFormat)
            IllegalArgumentException.class,
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
    public void testConstructorThrowsWhenSecondaryFormatNotRegistered() {
        writer.close();
        assertNotNull(engine.getPrimaryDelegate());
        IndexSettings indexSettings = createIndexSettings("lucene");
    }
            .putList("index.composite.secondary_data_formats", "parquet")
    }
        );
        );
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.engine.CommitStats;
        CompositeIndexingExecutionEngine engine = new CompositeIndexingExecutionEngine(indexSettings, null, tracking, registry, null, null);  
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene");
import java.io.IOException;  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));
        IndexSettings indexSettings = createIndexSettings("lucene");  
    public void testDeleteFilesDoesNotThrow() throws Exception {
            .build();  
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene");  
            return null;
            IllegalStateException.class,  
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, new CompositeTestHelper.StubCommitter(), registry, null, null)  
            return List.of();  
        assertEquals(2, format.getDataFormats().size());
    public void testGetMergerDelegatesToPrimary() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            return Map.of();
import org.opensearch.index.IndexSettings;
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, null, registry, null, null)  
            DataFormatPlugin plugin = CompositeTestHelper.stubPlugin("lucene", 1);
import java.util.stream.Collectors;
        );
import org.opensearch.Version;
            () -> CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "parquet", List.of())
                    )
            IllegalArgumentException.class,
        assertTrue(ex.getMessage().contains("Committer must not be null"));
        Map<String, String> lastCommitData = null;
        // Reset tracking after construction (init is called during construction)
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene");
import org.opensearch.index.engine.exec.commit.Committer;
                    Collectors.toMap(  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        IllegalArgumentException ex = expectThrows(
    private IndexSettings createIndexSettings(String primaryFormat) {
        @Override
        IndexSettings indexSettings = createIndexSettings("lucene");
    public void testConstructorWithPrimaryAndSecondary() {
    // --- Property test — Committer is required ---
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import static org.mockito.Mockito.mock;
            () -> new CompositeIndexingExecutionEngine(null, null, new CompositeTestHelper.StubCommitter(), registry, null, null)
        );
        assertTrue(ex.getMessage().contains("parquet"));
        public List<CatalogSnapshot> listCommittedSnapshots() {
        expectThrows(  
        }
/**
import org.opensearch.cluster.metadata.IndexMetadata;
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
        CompositeDataFormat format = engine.getDataFormat();
import java.util.Set;
        }
package org.opensearch.composite;
                        (existing, replacement) -> replacement, // Merge function for duplicate keys  
    private static class TrackingCommitter implements Committer {
        }  
    }  
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
            lastCommitData = StreamSupport.stream(commitData.userData().spliterator(), false)
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));  
    }
        }
        engine.refresh(refreshInput);  
    public void testConstructorWithPrimaryOnly() {  
 */  
        input.close();
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
}  
    }
            throw new UnsupportedOperationException("stub");
        public CommitStats getCommitStats() {  
 * SPDX-License-Identifier: Apache-2.0
        public Map<String, String> getLastCommittedData() {
        CompositeWriter writer = (CompositeWriter) engine.createWriter(new WriterConfig(42L));
        assertTrue(ex.getMessage().contains("parquet"));
    public void testGetDataFormatReturnsCompositeDataFormat() {  
        assertTrue(ex.getMessage().contains("parquet"));  
        IllegalStateException ex = expectThrows(
    public void testConstructorRejectsNullIndexSettings() {
        CompositeDocumentInput input = engine.newDocumentInput();
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
        IllegalArgumentException ex = expectThrows(
        assertEquals(1, input.getSecondaryInputs().size());
        return new IndexSettings(indexMetadata, Settings.EMPTY);
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            closeCalled = true;  
        RefreshInput refreshInput = RefreshInput.builder().build();
        assertNotNull(format);  
        IllegalStateException ex = expectThrows(
        @Override  
    public void testCreateWriterReturnsCompositeWriter() throws IOException {  
    }  
        engine.deleteFiles(Map.of());
public class CompositeIndexingExecutionEngineTests extends OpenSearchTestCase {
            commitCalled = true;  
        );  
import static org.mockito.ArgumentMatchers.any;
        assertEquals(1, engine.getSecondaryDelegates().size());
        IndexSettings indexSettings = createIndexSettings("parquet");  
    public void testValidateFormatsRegisteredRejectsMissingSecondary() {  
    }  
            IllegalStateException.class,
            return false;
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");  
 * this file be licensed under the Apache-2.0 license or a
            .put("index.composite.primary_data_format", "lucene")
        public void deleteCommit(CatalogSnapshot snapshot) {}
    public void testNewDocumentInputReturnsCompositeDocumentInput() {
        assertNotNull(engine.getMerger());
     */
        assertNotNull(input);
        assertEquals(0L, engine.getNativeBytesUsed());  
        public CommitResult commit(CommitInput commitData) {
    }
        @Override
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        assertFalse("commit() must not be called during refresh", tracking.commitCalled);
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");  
import java.util.List;
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));
        when(registry.format("lucene")).thenReturn(luceneFormat);
        when(registry.format("parquet")).thenReturn(CompositeTestHelper.stubFormat("parquet", 2, Set.of()));
    }  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                        Map.Entry::getKey,
        TrackingCommitter tracking = new TrackingCommitter();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.engine.dataformat.RefreshInput;  
import static org.mockito.Mockito.doReturn;  
    }  
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, new CompositeTestHelper.StubCommitter(), null, null, null)  
    }  
     * A Committer that tracks which methods were called, for test assertions.  
 * Tests for {@link CompositeIndexingExecutionEngine}.
import org.opensearch.common.settings.Settings;  
            NullPointerException.class,
        assertTrue(ex.getMessage().contains("same as primary"));  
 */  
                );  
import java.util.stream.StreamSupport;  
        boolean closeCalled = false;
        tracking.commitCalled = false;  
        assertEquals("composite", engine.getDataFormat().name());
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();  
    public void testValidateFormatsRegisteredAcceptsValidConfig() {
    }
    public void testConstructorWithMultipleSecondaries() {
        @Override
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, new CompositeTestHelper.StubCommitter(), registry, null, null)  
        DataFormat luceneFormat = CompositeTestHelper.stubFormat("lucene", 1, Set.of());  
import java.util.Map;  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
import org.opensearch.index.engine.dataformat.WriterConfig;
        boolean commitCalled = false;  
    // --- Property test — Refresh never calls Committer methods ---
    }  
    public void testValidateFormatsRegisteredRejectsSecondaryEqualToPrimary() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }  
                .collect(
    }
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {  
            IllegalArgumentException.class,  
        IllegalArgumentException ex = expectThrows(
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
import java.util.HashMap;
        @Override
 *
        assertNotNull(writer);  
    public void testRefreshNeverCallsCommitterMethods() throws IOException {
        Settings settings = Settings.builder()  
        assertEquals("parquet", engine.getSecondaryDelegates().iterator().next().getDataFormat().name());
        public void close() {
                        Map.Entry::getValue,
        when(registry.format("parquet")).thenReturn(null);
    public void testConstructorThrowsWhenCommitterNull() {  
        });
        }  
        @Override  
        assertTrue(engine.getSecondaryDelegates().isEmpty());  
    public void testValidateFormatsRegisteredRejectsMissingPrimary() {  
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
            () -> CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "lucene", List.of("parquet"))
    public void testConstructorThrowsWhenPrimaryFormatNotRegistered() {
        assertNotNull(input.getPrimaryInput());  
        when(registry.format("parquet")).thenReturn(null);  
        Settings settings = Settings.builder()  
        }
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        @Override  
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
import org.opensearch.index.engine.dataformat.DataFormat;  
        doReturn(new CompositeTestHelper.StubIndexingExecutionEngine(luceneFormat)).when(registry).getIndexingEngine(any(), any());  
                        HashMap::new
        );
    }
        assertTrue(ex.getMessage().contains("parquet"));
    /**
        );
        @Override
            NullPointerException.class,
        when(registry.format("parquet")).thenReturn(null);  
    }
import static org.mockito.Mockito.when;
    }  
        expectThrows(
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));  
            () -> CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "lucene", List.of("lucene"))
        assertEquals("composite", format.name());
            .build();
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));  
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet", "arrow");  
        CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "lucene", List.of("parquet"));  
 * compatible open source license.
    public void testGetNativeBytesUsedSumsAllEngines() {
        assertEquals(42L, writer.getWriterGeneration());
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));  
            return null;
        }
        when(registry.format("parquet")).thenReturn(null);
            IllegalArgumentException.class,
        assertEquals(2, engine.getSecondaryDelegates().size());
        IllegalArgumentException ex = expectThrows(  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        public boolean isCommitManagedFile(String fileName) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testConstructorRejectsNullDataFormatRegistry() {
