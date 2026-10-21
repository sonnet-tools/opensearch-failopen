        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        }
        public void addField(org.opensearch.index.mapper.MappedFieldType fieldType, Object value) {}
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                return "StubDataFormat{" + name + "}";
        }
import org.opensearch.index.engine.dataformat.WriterConfig;
                return new FixedWriterEngine(secondaryFormat, secondaryWriter);
 * compatible open source license.
    }
            assert state == org.opensearch.index.engine.dataformat.WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
        // Tests that want Parquet-style "stay ACTIVE" semantics can flip this flag.
            for (int i = 0; i < secondaries.length; i++)
            if (closeFailure != null) throw closeFailure;
                @Override
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
    }
        final AtomicInteger addDocCallCount = new AtomicInteger();
            @Override
            return 0;
        }
                return format;
        }
            return 0;
        DataFormat secondaryFormat,
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
        });
    /**
            .putList("index.composite.secondary_data_formats", secondaryFormat.name())
/**
        }
        public void close() {}
     * Minimal stub Writer that always succeeds and returns empty FileInfos.
        }
    /**
        public void close() {
        }
            @Override
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        public CommitStats getCommitStats() {
        @Override
     * Minimal stub DocumentInput.
        @Override
            createdWriters.add(w);
    }
        private volatile Supplier<WriteResult> defaultWriteResultSupplier;
import java.util.function.Supplier;
        }
            super(dataFormat);
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
     * Minimal stub Committer that records close calls and does nothing on commit.
    static CompositeIndexingExecutionEngine createStubEngine(String primaryName, String... secondaryNames) {
        @Override
        @Override
        return new CompositeIndexingExecutionEngine(new IndexSettings(meta, Settings.EMPTY), null, committer, registry, null, null);
            return List.of();
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     */
        }
            formats.put(name, stubFormat(name, 2, Set.of()));
        }
        }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
                    return Set.of();
            return resultToReturn;
}
        }
        @Override
            public Set<FieldTypeCapabilities> supportedFields() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            return FileInfos.empty();
        }
        });
        public FileInfos flush(FlushInput flushInput) {
        when(registry.getIndexingEngine(any(), any())).thenAnswer(inv -> {
        private volatile org.opensearch.index.engine.dataformat.WriterState state =
            this.resultToReturn = result;
        when(registry.format(secondaryFormat.name())).thenReturn(secondaryFormat);
            }
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> f) {
import org.opensearch.index.engine.dataformat.MergeResult;
            this.schemaMutable = mutable;
        public org.opensearch.index.engine.dataformat.WriterState state() {
        @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.engine.CommitStats;
 * Shared test utilities for composite engine tests.
            sb.putList("index.composite.secondary_data_formats", names);
    static class FailableCommitter implements Committer {
        public long getNativeBytesUsed() {
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        @Override
        @Override
        }
        @Override
        public void close() throws IOException {
            return null;
        DataFormat primaryFormat = primaryEngine.getDataFormat();
    }
            this.format = format;
        public long getNextWriterGeneration() {
    static DataFormat stubFormat(String name, long priority, Set<FieldTypeCapabilities> fields) {
    }
        for (FailableEngine sec : secondaries) {
        IndexingExecutionEngine<?, ?> primaryEngine,
                return new StubIndexingExecutionEngine(format);
            DataFormat format = invocation.getArgument(1);
            return dataFormat;
     */
            return 0;
        return new CompositeIndexingExecutionEngine(indexSettings, null, new StubCommitter(), registry, null, null);
import org.opensearch.index.engine.exec.commit.Committer;
            plugins.put(name, stubPlugin(name, 2));
    static class FailableWriter implements Writer<DocumentInput<?>> {
            if (fmt.name().equals(primary.getDataFormat().name())) return primary;
import org.opensearch.index.engine.dataformat.DataFormat;
        DataFormat primaryFormat,
        void setState(org.opensearch.index.engine.dataformat.WriterState s) {
        @Override
        volatile boolean closeCalled;
            this.defaultWriteResultSupplier = s;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        @Override
            return new RefreshResult(Collections.emptyList());
        };
        public long getFieldCount(String fieldName) {
        volatile IOException rollbackFailure;
            public long priority() {
        void setResultToReturn(WriteResult result) {
            public String toString() {
        @Override
import org.opensearch.index.engine.dataformat.RefreshInput;
        }
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
            }
        }
        public Map<String, String> getLastCommittedData() {
        @Override
                names[i] = secondaries[i].getDataFormat().name();
            return state;
        }
        public CommitStats getCommitStats() {
            if (defaultWriteResultSupplier != null) w.setResultToReturn(defaultWriteResultSupplier.get());
        public void close() throws IOException {
        @Override
        }
    }
        @Override
     */
        @Override
        @Override
            .put("index.composite.primary_data_format", primaryFormat.name())
        public DataFormat getDataFormat() {
        public long getNextWriterGeneration() {
                return new FixedWriterEngine(primaryFormat, primaryWriter);
        @Override
    /**
        }
            return lastCreatedWriter;
                state = org.opensearch.index.engine.dataformat.WriterState.RETIRED_FLUSHABLE;
        public DataFormat getDataFormat() {
    static class StubIndexingExecutionEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {
            }
package org.opensearch.composite;
        @Override
            return Map.of();
    /**
        private volatile org.opensearch.index.engine.dataformat.WriterState state =
                return primaryEngine;
                    return 1;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        private boolean schemaMutable = true;
        }
    /** Writer stub accepting {@code DocumentInput<?>} with configurable failures. */
            }
            }
        DataFormat format = stubFormat(formatName, priority, Set.of());
        return new CompositeIndexingExecutionEngine(indexSettings, null, new StubCommitter(), registry, null, null);
    static class StubWriter implements Writer<DocumentInput<?>> {
        public long getHeapBytesUsed() {
    /**
    }
import java.util.HashMap;
        });
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
     */
            if (format.name().equals(primaryFormat.name())) {
        void setState(org.opensearch.index.engine.dataformat.WriterState s) {
 *
     */
/*
    /** Builds a CompositeIndexingExecutionEngine wired with failable stubs. */
            return plugin.indexingEngine(null);
                }
        }
            .put("index.composite.primary_data_format", primaryFormat.name())
            }
        private final AtomicLong writerGen = new AtomicLong();
     * Creates a CompositeIndexingExecutionEngine with pre-built delegate engines for testing.
        }
    /**
        formats.put(primaryFormat.name(), primaryFormat);
    static class FixedWriterEngine extends StubIndexingExecutionEngine {
            return null;
                return new StubIndexingExecutionEngine(format);
        }
        public RefreshResult refresh(RefreshInput refreshInput) {
            return new RefreshResult(Collections.emptyList());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            return null;
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
    static DataFormatPlugin stubPlugin(String formatName, long priority, Set<FieldTypeCapabilities> fields) {
        @Override
            public DataFormat getDataFormat() {
        IndexMetadata meta = IndexMetadata.builder("test-index").settings(sb.build()).build();
        @Override
        public boolean isCommitManagedFile(String f) {
        }
            return null;
        }
 * SPDX-License-Identifier: Apache-2.0
        }
            } else {
        public boolean isSchemaMutable() {
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        @Override
            @Override
            } else {
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
        @Override
        }
        FailableEngine primary,
        @Override
            settingsBuilder.putList("index.composite.secondary_data_formats", secondaryNames);
            return new MockDocumentInput();
        @Override
        }
import static org.mockito.Mockito.mock;
                @Override
            DataFormat fmt = inv.getArgument(1);
        }
            this.fixedWriter = fixedWriter;
            return false;
            public DataFormat getDataFormat() {
            return true;
            return FileInfos.empty();
        public long getNativeBytesUsed() {
        FailableWriter(DataFormat format) {}
        @Override
        }
        }
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
        Settings settings = Settings.builder()
        @Override
        @Override
        @Override
        public void updateMappingVersion(long newVersion) {}
            this.state = s;
        }
        @Override
     * Creates a CompositeIndexingExecutionEngine with custom writers for testing sort propagation.
                return fields;
        public long generation() {
        @Override
        public long generation() {
        }
        public void close() {}
        }
import org.opensearch.index.engine.dataformat.Writer;
            return dataFormat;
        /** Test-only setter to inject a state directly. */
        }
        volatile boolean retireOnRollbackSuccess = true;
        @Override
        public WriteResult addDoc(DocumentInput<?> d) {
        private final AtomicLong writerGeneration = new AtomicLong(0);
                public Set<FieldTypeCapabilities> supportedFields() {
        }
    ) {
        public FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) throws IOException {
        @Override
            rollbackCalled = true;
     * An IndexingExecutionEngine that always returns the same pre-built writer.
        @Override
    /**
        }
            addDocCallCount.incrementAndGet();
    }
            return df -> null;
            when(registry.format(sec.getDataFormat().name())).thenReturn(sec.getDataFormat());
            for (FailableEngine sec : secondaries) {
     */
            .putList("index.composite.secondary_data_formats", secondaryFormat.name())
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        Writer<DocumentInput<?>> primaryWriter,
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return new CompositeIndexingExecutionEngine(indexSettings, null, new StubCommitter(), registry, null, null);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        void setResultToReturn(WriteResult result) {
        }
            return fixedWriter;
        public void setRowId(String rowIdFieldName, long rowId) {}
        }
        when(registry.format(primaryFormat.name())).thenReturn(primaryFormat);
            return schemaMutable;
import org.opensearch.index.engine.dataformat.FileInfos;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        public Committer.CommitResult commit(Committer.CommitInput data) {
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
            .put("index.composite.primary_data_format", primaryName)
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
        @Override
        volatile IOException flushFailure;
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        Writer<DocumentInput<?>> secondaryWriter
        public List<CatalogSnapshot> listCommittedSnapshots() {
            return Map.of();
            return createdWriters.get(createdWriters.size() - 1);
        @Override
    static CompositeIndexingExecutionEngine buildFailableEngine(
        @Override
        }
        public Map<String, String> getLastCommittedData() {
            return writerGeneration.getAndIncrement();
        public boolean isSchemaMutable() {
    }
        formats.put(secondaryFormat.name(), secondaryFormat);
            org.opensearch.index.engine.dataformat.WriterState.ACTIVE;
     * Creates a CompositeIndexingExecutionEngine with stub engines for testing.
import org.opensearch.common.settings.Settings;
            .build();
        }
            .build();
        private final List<FailableWriter> createdWriters = new ArrayList<>();
        void setSchemaMutable(boolean mutable) {
import org.opensearch.index.engine.dataformat.RefreshResult;
    /** Minimal committer stub for tests that don't exercise commit-side failures. */
                    return name;
        }
                @Override
        public void deleteCommit(CatalogSnapshot snapshot) {}
            return mergeInput -> new MergeResult(Map.of());
            state = org.opensearch.index.engine.dataformat.WriterState.CLOSED;
        DataFormat format = stubFormat(formatName, priority, fields);
        FixedWriterEngine(DataFormat dataFormat, Writer<DocumentInput<?>> fixedWriter) {
        Map<String, DataFormatPlugin> plugins = new HashMap<>();
        public void close() {}
        @Override
    private CompositeTestHelper() {}
    }
            throw new UnsupportedOperationException("stub");
import java.io.IOException;
            if (flushFailure != null) throw flushFailure;
            @Override
        }
            DataFormat format = invocation.getArgument(1);
        private final DataFormat format;
        private final DataFormat dataFormat;
import java.util.Set;
        volatile boolean rollbackCalled;
        public List<CatalogSnapshot> listCommittedSnapshots() {
            this.resultToReturn = result;
            return writerGen.getAndIncrement();
            closeCalled = true;
     * Minimal stub IndexingExecutionEngine that returns no-op writers and empty results.
        @Override
        }
        }
        FailableCommitter committer,
        FailableEngine(String name) {
        }
    }
        }
import java.util.concurrent.atomic.AtomicLong;
            @Override
            }
 */
        Settings settings = settingsBuilder.build();
        if (secondaryNames.length > 0) {
        /** Test-only setter to inject a state directly. */
        }
        private final DataFormat dataFormat;
            return Map.of();
        boolean closeCalled = false;
        }
            return 0;
        public DocumentInput<?> newDocumentInput() {
            @Override
                if (fmt.name().equals(sec.getDataFormat().name())) return sec;
        DataFormat secondaryFormat = secondaryEngine.getDataFormat();
            return w;
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        }
 * The OpenSearch Contributors require contributions made to
            return 0;
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        Map<String, DataFormat> formats = new HashMap<>();
            return i -> new MergeResult(Map.of());
            @Override
        public long mappingVersion() {
        Map<String, DataFormat> formats = new HashMap<>();
            public String name() {
        StubWriter lastCreatedWriter;
        }
     */
        }
        @Override
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
            if (format.name().equals(primaryFormat.name())) {
        @Override
    static CompositeIndexingExecutionEngine createStubEngineWithDelegates(
        @Override
import org.opensearch.Version;
    }
            DataFormat format = invocation.getArgument(1);
            return mappingVersion;
import static org.mockito.ArgumentMatchers.any;
            .put("index.composite.primary_data_format", primary.getDataFormat().name())
        }
            when(registry.format(entry.getKey())).thenReturn(entry.getValue());
            return df -> null;
        formats.put(primaryName, stubFormat(primaryName, 1, Set.of()));
        for (Map.Entry<String, DataFormat> entry : formats.entrySet()) {
        public void updateMappingVersion(long newVersion) {
 */
                return name;
        }
        public RefreshResult refresh(RefreshInput input) {
        }
                public String name() {
        StubIndexingExecutionEngine(DataFormat dataFormat) {
        public void rollbackTo(long rowCount) throws IOException {
            String[] names = new String[secondaries.length];
            }
     */
        @Override
        private long mappingVersion = 0;
        StubWriter(DataFormat format) {
import java.util.Map;
        for (String name : secondaryNames) {
            @Override
        @Override
        public void deleteCommit(CatalogSnapshot s) {}
        }
            };
        }
    ) {
        return new DataFormat() {
            return null;
        Settings.Builder settingsBuilder = Settings.builder()
import java.util.ArrayList;
    }
        IndexingExecutionEngine<?, ?> secondaryEngine
            assert state == org.opensearch.index.engine.dataformat.WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
                return priority;
        @Override
            closeCalled = true;
        });
        return new DataFormatPlugin() {
            return new byte[0];
        };
        }
import org.opensearch.index.engine.dataformat.DocumentInput;
            return state;
    ) {
        volatile WriteResult resultToReturn = new WriteResult.Success(1, 1, 1);
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.index.engine.dataformat.FlushInput;
        };
        @Override
        when(registry.format(primary.getDataFormat().name())).thenReturn(primary.getDataFormat());
    static DataFormatPlugin stubPlugin(String formatName, long priority) {
        @Override
import java.util.List;
import org.opensearch.index.engine.dataformat.Merger;
            lastCreatedWriter = new StubWriter(dataFormat);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        return new DataFormatPlugin() {
            org.opensearch.index.engine.dataformat.WriterState.ACTIVE;
    // --- Failable stubs for failure injection tests ---
        @Override
                }
            FailableWriter w = new FailableWriter(dataFormat);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            return false;
        @Override
 * this file be licensed under the Apache-2.0 license or a
        }
        when(registry.format(primaryFormat.name())).thenReturn(primaryFormat);
            if (createWriterFailure != null) throw createWriterFailure;
        @Override
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
import static org.mockito.Mockito.when;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
        FailableEngine... secondaries
        @Override
        }
        private final Writer<DocumentInput<?>> fixedWriter;
            this.mappingVersion = newVersion;
        }
        }
                public long priority() {
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
        @Override
import org.opensearch.cluster.metadata.IndexMetadata;
        public WriteResult addDoc(DocumentInput<?> d) {
            this.dataFormat = dataFormat;
            return 0;
        @Override
        }
    static class StubDocumentInput implements DocumentInput<Object> {
            return null;
            this.dataFormat = new DataFormat() {
        }
            }
    }
import org.opensearch.index.IndexSettings;
import org.opensearch.index.engine.dataformat.WriteResult;
        Settings.Builder sb = Settings.builder()
    static class StubCommitter implements Committer {
        @Override
            DataFormatPlugin plugin = plugins.get(format.name());
        public Merger getMerger() {
        plugins.put(primaryName, stubPlugin(primaryName, 1));
     * The primary engine returns primaryWriter, the secondary engine returns secondaryWriter.
        void setDefaultWriteResultSupplier(Supplier<WriteResult> s) {
        public long mappingVersion() {
            if (rollbackFailure != null) throw rollbackFailure;
            if (retireOnRollbackSuccess) {
        if (secondaries.length > 0) {
        public CommitResult commit(CommitInput commitData) {
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
            }
        }
        FailableWriter getLastCreatedWriter() {
        }
            state = org.opensearch.index.engine.dataformat.WriterState.CLOSED;
        public boolean isCommitManagedFile(String fileName) {
        @Override
        // Models a Lucene-style strategy by default: rollback success → RETIRED_FLUSHABLE.
final class CompositeTestHelper {
        volatile IOException closeFailure;
        volatile RuntimeException createWriterFailure;
        public void close() {}
        @Override
import java.util.Collections;
        @Override
        public Merger getMerger() {
                return secondaryEngine;
            return Map.of();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        public DocumentInput<?> newDocumentInput() {
                }
import java.util.Collection;
        public org.opensearch.index.engine.dataformat.WriterState state() {
            return resultToReturn;
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        public long getHeapBytesUsed() {
        when(registry.format(secondaryFormat.name())).thenReturn(secondaryFormat);
        @Override
        public Object getFinalInput() {
            return 0;
        private WriteResult resultToReturn = new WriteResult.Success(1, 1, 1);
            return List.of();
            return 0;
    }
        @Override
    static CompositeIndexingExecutionEngine createStubEngineWithWriters(
        public IndexStoreProvider getProvider() {
        @Override
            return new StubDocumentInput();
        public IndexStoreProvider getProvider() {
                return format;
            }
            this.state = s;
    /**
    /** Engine stub producing {@link FailableWriter} instances with optional default failure. */
        }
    static class FailableEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {
