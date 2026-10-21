    public void testGetMergerDelegatesToPrimary() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene");
    public void testConstructorWithPrimaryAndSecondary() {
        Settings settings = Settings.builder()
    }
    }
 */
    public void testValidateFormatsRegisteredRejectsSecondaryEqualToPrimary() {
        IllegalArgumentException ex = expectThrows(
        CompositeDocumentInput input = engine.newDocumentInput();
        assertTrue(ex.getMessage().contains("parquet"));
        public CommitStats getCommitStats() {
        assertEquals(1, engine.getSecondaryDelegates().size());
    public void testValidateFormatsRegisteredAcceptsValidConfig() {
import java.util.Map;
import java.util.stream.StreamSupport;
            IllegalArgumentException.class,
    }
        @Override
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        when(registry.format("parquet")).thenReturn(null);
    public void testConstructorThrowsWhenSecondaryFormatNotRegistered() {
        when(registry.format("parquet")).thenReturn(null);
        assertNotNull(engine.getMerger());
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
        expectThrows(
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
        assertNotNull(engine.getPrimaryDelegate());
        when(registry.format("parquet")).thenReturn(null);
            closeCalled = true;
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));
            return plugin.indexingEngine(null);
     */
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    // --- Property test — Refresh never calls Committer methods ---
        IndexSettings indexSettings = createIndexSettings("lucene");
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, new CompositeTestHelper.StubCommitter(), registry, null, null)
import org.opensearch.cluster.metadata.IndexMetadata;
 *
import org.opensearch.index.engine.dataformat.DataFormat;
            .put("index.composite.primary_data_format", primaryFormat)
        );
        }
import org.opensearch.common.settings.Settings;
        engine.deleteFiles(Map.of());
package org.opensearch.composite;
            return List.of();
            .put("index.composite.primary_data_format", "lucene")
        IllegalArgumentException ex = expectThrows(
        assertNotNull(writer);
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        IndexSettings indexSettings = createIndexSettings("parquet");
        assertNotNull(input);
        expectThrows(
        RefreshInput refreshInput = RefreshInput.builder().build();
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, new CompositeTestHelper.StubCommitter(), null, null, null)
import java.util.stream.Collectors;
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene");
            NullPointerException.class,
    }
        boolean commitCalled = false;
    public void testConstructorWithPrimaryOnly() {
            commitCalled = true;
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
    public void testConstructorRejectsNullIndexSettings() {
import static org.mockito.Mockito.doReturn;
    }
        @Override
import org.opensearch.index.engine.CommitStats;
        assertNotNull(engine.getPrimaryDelegate());
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));
        );
            return null;
        assertTrue(ex.getMessage().contains("parquet"));
                        Map.Entry::getKey,
        doReturn(new CompositeTestHelper.StubIndexingExecutionEngine(luceneFormat)).when(registry).getIndexingEngine(any(), any());
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
        }
                .collect(
        );
        @Override
        assertEquals(2, format.getDataFormats().size());
import static org.mockito.ArgumentMatchers.any;
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
import org.opensearch.index.engine.exec.commit.Committer;
        public Map<String, String> getLastCommittedData() {
        assertEquals("parquet", engine.getSecondaryDelegates().iterator().next().getDataFormat().name());
            IllegalArgumentException.class,
    }
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
import org.opensearch.index.engine.dataformat.RefreshInput;
    public void testConstructorRejectsNullDataFormatRegistry() {
        @Override
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));
    }
    }
        assertTrue(ex.getMessage().contains("Committer must not be null"));
import org.opensearch.Version;
    }
                    )
    public void testRefreshNeverCallsCommitterMethods() throws IOException {
        assertTrue(engine.getSecondaryDelegates().isEmpty());
    private static class TrackingCommitter implements Committer {
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));
        assertEquals("composite", format.name());
        }
        writer.close();
        IllegalStateException ex = expectThrows(
import org.opensearch.test.OpenSearchTestCase;
        }
        public List<CatalogSnapshot> listCommittedSnapshots() {
                        Map.Entry::getValue,
        assertNotNull(input.getPrimaryInput());
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, new CompositeTestHelper.StubCommitter(), registry, null, null)
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));
    }
import org.opensearch.index.engine.dataformat.WriterConfig;
        );
        public CommitResult commit(CommitInput commitData) {
        // Reset tracking after construction (init is called during construction)
    }
        assertEquals(42L, writer.getWriterGeneration());
        assertTrue(ex.getMessage().contains("parquet"));
        public void close() {
import static org.mockito.Mockito.mock;
        assertEquals(0L, engine.getNativeBytesUsed());
        CompositeDataFormat format = engine.getDataFormat();
        assertTrue(ex.getMessage().contains("same as primary"));
        }
}
        boolean closeCalled = false;
        @Override
        when(registry.format("parquet")).thenReturn(CompositeTestHelper.stubFormat("parquet", 2, Set.of()));
        IndexSettings indexSettings = createIndexSettings("lucene");
 * compatible open source license.
public class CompositeIndexingExecutionEngineTests extends OpenSearchTestCase {
            IllegalArgumentException.class,
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet", "arrow");
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, Set.of()));
            return false;
            IllegalStateException.class,
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
 * The OpenSearch Contributors require contributions made to
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        engine.refresh(refreshInput);
        });
import java.util.List;
    }
        public boolean isCommitManagedFile(String fileName) {
            () -> new CompositeIndexingExecutionEngine(indexSettings, null, null, registry, null, null)
        assertEquals(2, engine.getSecondaryDelegates().size());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        input.close();
        tracking.commitCalled = false;
            .build();
                    Collectors.toMap(
            DataFormatPlugin plugin = CompositeTestHelper.stubPlugin("lucene", 1);
     * A Committer that tracks which methods were called, for test assertions.
        Settings settings = Settings.builder()
import java.util.Set;
            () -> new CompositeIndexingExecutionEngine(null, null, new CompositeTestHelper.StubCommitter(), registry, null, null)
    public void testValidateFormatsRegisteredRejectsMissingSecondary() {
        Map<String, String> lastCommitData = null;
    }
    public void testCreateWriterReturnsCompositeWriter() throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            throw new UnsupportedOperationException("stub");
    }
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene");
        @Override
        assertNotNull(format);
    public void testGetDataFormatReturnsCompositeDataFormat() {
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
        when(registry.format("parquet")).thenReturn(null);
    public void testDeleteFilesDoesNotThrow() throws Exception {
    public void testValidateFormatsRegisteredRejectsMissingPrimary() {
        );
import java.io.IOException;
        }
        CompositeWriter writer = (CompositeWriter) engine.createWriter(new WriterConfig(42L));
import org.opensearch.index.IndexSettings;
        assertEquals(1, input.getSecondaryInputs().size());
            lastCommitData = StreamSupport.stream(commitData.userData().spliterator(), false)
        CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "lucene", List.of("parquet"));
        TrackingCommitter tracking = new TrackingCommitter();
        assertFalse("commit() must not be called during refresh", tracking.commitCalled);
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        );
    }
            IllegalStateException.class,
        IllegalArgumentException ex = expectThrows(
        assertEquals("composite", engine.getDataFormat().name());
        IllegalArgumentException ex = expectThrows(
    public void testConstructorThrowsWhenPrimaryFormatNotRegistered() {
import static org.mockito.Mockito.when;
    private IndexSettings createIndexSettings(String primaryFormat) {
/*
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
        return new IndexSettings(indexMetadata, Settings.EMPTY);
        DataFormat luceneFormat = CompositeTestHelper.stubFormat("lucene", 1, Set.of());
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));
            () -> CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "parquet", List.of())
                );
 * Tests for {@link CompositeIndexingExecutionEngine}.
        @Override
    }
        assertTrue(ex.getMessage().contains("parquet"));
    }
            return null;
    public void testConstructorWithMultipleSecondaries() {
    public void testConstructorThrowsWhenCommitterNull() {
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
        IndexSettings indexSettings = createIndexSettings("lucene");
    // --- Property test — Committer is required ---
            () -> CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "lucene", List.of("lucene"))
                        HashMap::new
            .build();
import java.util.HashMap;
        IllegalStateException ex = expectThrows(
        public void deleteCommit(CatalogSnapshot snapshot) {}
        );
            () -> CompositeIndexingExecutionEngine.validateFormatsRegistered(registry, "lucene", List.of("parquet"))
        when(registry.format("lucene")).thenReturn(luceneFormat);
 */
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
    }
            NullPointerException.class,
        CompositeIndexingExecutionEngine engine = new CompositeIndexingExecutionEngine(indexSettings, null, tracking, registry, null, null);
        @Override
            .putList("index.composite.secondary_data_formats", "parquet")
    }
        when(registry.getRegisteredFormats()).thenReturn(Set.of(CompositeTestHelper.stubFormat("lucene", 1, Set.of())));
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
/**
        );
    /**
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    public void testNewDocumentInputReturnsCompositeDocumentInput() {
 * SPDX-License-Identifier: Apache-2.0
                        (existing, replacement) -> replacement, // Merge function for duplicate keys
            return Map.of();
    public void testGetNativeBytesUsedSumsAllEngines() {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
