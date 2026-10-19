        return new CompositeIndexingExecutionEngine(indexSettings, null, new StubCommitter(), registry, null, null);  
import org.opensearch.common.settings.Settings;  
        volatile IOException rollbackFailure;
        }
     * Creates a CompositeIndexingExecutionEngine with custom writers for testing sort propagation.
        }
        return new DataFormat() {
            if (fmt.name().equals(primary.getDataFormat().name())) return primary;  
        }  
            return schemaMutable;
                return new StubIndexingExecutionEngine(format);
            return mergeInput -> new MergeResult(Map.of());
        public org.opensearch.index.engine.dataformat.WriterState state() {
                return format;  
        void setSchemaMutable(boolean mutable) {  
        return new DataFormatPlugin() {
        public void deleteCommit(CatalogSnapshot s) {}
            }
            return Map.of();  
        }  
        Settings.Builder settingsBuilder = Settings.builder()
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
            return new MockDocumentInput();  
        public FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) throws IOException {
import org.opensearch.index.engine.dataformat.FlushInput;  
            return true;  
        @Override
        volatile IOException flushFailure;  
            return df -> null;
        @Override
        void setDefaultWriteResultSupplier(Supplier<WriteResult> s) {
            return false;  
        }
    static CompositeIndexingExecutionEngine createStubEngine(String primaryName, String... secondaryNames) {
        });  
import static org.mockito.ArgumentMatchers.any;  
        public CommitStats getCommitStats() {
        }
            return FileInfos.empty();  
            return writerGeneration.getAndIncrement();
        void setState(org.opensearch.index.engine.dataformat.WriterState s) {
import static org.mockito.Mockito.mock;
        }  
            if (retireOnRollbackSuccess) {
    static class FixedWriterEngine extends StubIndexingExecutionEngine {
            addDocCallCount.incrementAndGet();
 * The OpenSearch Contributors require contributions made to  
            return null;
    }
     */  
            DataFormat fmt = inv.getArgument(1);
        Settings settings = Settings.builder()
                    return 1;  
import org.opensearch.index.engine.dataformat.Writer;
        @Override
        public long generation() {  
        public long mappingVersion() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        Settings.Builder sb = Settings.builder()  
            if (createWriterFailure != null) throw createWriterFailure;
        public RefreshResult refresh(RefreshInput refreshInput) {  
            .putList("index.composite.secondary_data_formats", secondaryFormat.name())
        }
        @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            for (int i = 0; i < secondaries.length; i++)
        @Override
            if (flushFailure != null) throw flushFailure;
    /**  
/**
/*  
        private WriteResult resultToReturn = new WriteResult.Success(1, 1, 1);
        @Override  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            @Override
            public Set<FieldTypeCapabilities> supportedFields() {
     * Creates a CompositeIndexingExecutionEngine with stub engines for testing.  
        for (String name : secondaryNames) {
        for (FailableEngine sec : secondaries) {  
    }
        }  
        }  
        DataFormat format = stubFormat(formatName, priority, Set.of());
        public Map<String, String> getLastCommittedData() {
            return FileInfos.empty();
        public org.opensearch.index.engine.dataformat.WriterState state() {
        @Override  
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {  
        @Override
            return new StubDocumentInput();  
        }
            return state;
        public void close() {  
    static class StubDocumentInput implements DocumentInput<Object> {  
        }
        when(registry.format(primaryFormat.name())).thenReturn(primaryFormat);
            }  
        @Override
        public void updateMappingVersion(long newVersion) {}  
import org.opensearch.index.engine.dataformat.Merger;
        };
    static class FailableWriter implements Writer<DocumentInput<?>> {
        public Object getFinalInput() {
        when(registry.format(secondaryFormat.name())).thenReturn(secondaryFormat);  
    ) {  
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
        }
        public long getNativeBytesUsed() {
        public void rollbackTo(long rowCount) throws IOException {
        }
        IndexMetadata meta = IndexMetadata.builder("test-index").settings(sb.build()).build();
            return writerGen.getAndIncrement();
    }
            } else {  
    /**
        public Map<String, String> getLastCommittedData() {
            return null;
            return 0;
        @Override
            DataFormat format = invocation.getArgument(1);
    /** Writer stub accepting {@code DocumentInput<?>} with configurable failures. */  
        private long mappingVersion = 0;  
        }
            formats.put(name, stubFormat(name, 2, Set.of()));
                return new FixedWriterEngine(primaryFormat, primaryWriter);
            return lastCreatedWriter;  
import org.opensearch.index.engine.CommitStats;
            return null;
            assert state == org.opensearch.index.engine.dataformat.WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
        Settings settings = Settings.builder()
    static class StubWriter implements Writer<DocumentInput<?>> {
        @Override
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
    /**  
        @Override
    }
        FailableCommitter committer,
        void setResultToReturn(WriteResult result) {
        @Override  
    /**
        }  
import org.opensearch.index.engine.dataformat.DataFormat;  
    static CompositeIndexingExecutionEngine createStubEngineWithWriters(
                return primaryEngine;
        }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        volatile WriteResult resultToReturn = new WriteResult.Success(1, 1, 1);
            if (closeFailure != null) throw closeFailure;
        }
        };
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                return name;
                return priority;
        public RefreshResult refresh(RefreshInput input) {  
        });
 */  
        @Override
        volatile boolean rollbackCalled;  
        private final AtomicLong writerGen = new AtomicLong();
            return Map.of();
        volatile IOException closeFailure;
                public String name() {  
        @Override  
            };
        public long getNextWriterGeneration() {  
                }
                return new StubIndexingExecutionEngine(format);
        public boolean isCommitManagedFile(String f) {
        /** Test-only setter to inject a state directly. */
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> f) {
 * this file be licensed under the Apache-2.0 license or a
            public DataFormat getDataFormat() {
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();  
        @Override  
        }
    /**  
        if (secondaries.length > 0) {
        when(registry.format(primary.getDataFormat().name())).thenReturn(primary.getDataFormat());  
        @Override  
            .put("index.composite.primary_data_format", primaryFormat.name())
        public Merger getMerger() {
    ) {
    // --- Failable stubs for failure injection tests ---  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        public long getHeapBytesUsed() {  
                public long priority() {
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();  
        }
    static class FailableCommitter implements Committer {
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        }  
        public void close() throws IOException {  
        @Override  
        }
import java.util.ArrayList;
     * The primary engine returns primaryWriter, the secondary engine returns secondaryWriter.
                state = org.opensearch.index.engine.dataformat.WriterState.RETIRED_FLUSHABLE;
            }  
        final AtomicInteger addDocCallCount = new AtomicInteger();
            return 0;
        }  
        public CommitResult commit(CommitInput commitData) {
            @Override  
        public DocumentInput<?> newDocumentInput() {
        public long getHeapBytesUsed() {  
        @Override
                @Override
            .build();
        }
        public List<CatalogSnapshot> listCommittedSnapshots() {  
            @Override
     */  
        public void deleteCommit(CatalogSnapshot snapshot) {}
                return format;
            @Override
            .put("index.composite.primary_data_format", primaryFormat.name())  
            if (rollbackFailure != null) throw rollbackFailure;  
    static DataFormatPlugin stubPlugin(String formatName, long priority) {  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        @Override  
        boolean closeCalled = false;
        DataFormat secondaryFormat = secondaryEngine.getDataFormat();
            return i -> new MergeResult(Map.of());
        @Override
            return df -> null;
        private boolean schemaMutable = true;
        public FileInfos flush(FlushInput flushInput) {
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
        }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        public void close() throws IOException {  
                return secondaryEngine;  
        @Override
        public Committer.CommitResult commit(Committer.CommitInput data) {  
import org.opensearch.index.engine.dataformat.RefreshResult;  
            DataFormatPlugin plugin = plugins.get(format.name());  
    }
import org.opensearch.index.engine.dataformat.DocumentInput;  
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
 * Shared test utilities for composite engine tests.
        }
        @Override
            }
        }  
        public boolean isSchemaMutable() {
            return List.of();
        }
        // Models a Lucene-style strategy by default: rollback success → RETIRED_FLUSHABLE.  
            }
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
import java.util.Collection;
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        }
        }
        @Override  
        @Override
    }
            FailableWriter w = new FailableWriter(dataFormat);  
        @Override  
        }  
        public void close() {}
        });
import java.util.List;
            }  
    /**  
        }  
import java.util.Map;  
            return w;  
     */  
            org.opensearch.index.engine.dataformat.WriterState.ACTIVE;
            this.state = s;
            String[] names = new String[secondaries.length];  
    }
        public void close() {}
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
        }  
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {
        public void close() {}  
    static CompositeIndexingExecutionEngine createStubEngineWithDelegates(  
                }
        }
 *
        FailableEngine primary,
            } else {
            @Override  
package org.opensearch.composite;
        private final DataFormat dataFormat;  
            .build();
    static CompositeIndexingExecutionEngine buildFailableEngine(  
        return new CompositeIndexingExecutionEngine(new IndexSettings(meta, Settings.EMPTY), null, committer, registry, null, null);  
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        }
        }  
        }  
        });
import org.opensearch.Version;
        }
        public long generation() {
            return new byte[0];
import org.opensearch.index.engine.exec.commit.Committer;
            this.state = s;  
        public DocumentInput<?> newDocumentInput() {
        }
            }  
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
     */
        @Override
            this.dataFormat = new DataFormat() {
     * Creates a CompositeIndexingExecutionEngine with pre-built delegate engines for testing.
            return state;
            return null;
        if (secondaryNames.length > 0) {
    }
            createdWriters.add(w);
        plugins.put(primaryName, stubPlugin(primaryName, 1));  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
        when(registry.format(primaryFormat.name())).thenReturn(primaryFormat);  
import java.util.Collections;  
            rollbackCalled = true;
        formats.put(primaryName, stubFormat(primaryName, 1, Set.of()));
import java.io.IOException;  
import java.util.function.Supplier;
        volatile boolean closeCalled;
        }
                    return name;
        }
            DataFormat format = invocation.getArgument(1);
            return 0;
        private final Writer<DocumentInput<?>> fixedWriter;  
            .put("index.composite.primary_data_format", primaryName)
        @Override  
import org.opensearch.index.engine.dataformat.RefreshInput;
     * Minimal stub IndexingExecutionEngine that returns no-op writers and empty results.
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        IndexingExecutionEngine<?, ?> primaryEngine,
        }
        @Override  
        return new DataFormatPlugin() {  
                @Override
        };  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
        private final DataFormat format;  
     * Minimal stub DocumentInput.
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
    ) {  
        private volatile Supplier<WriteResult> defaultWriteResultSupplier;  
            this.format = format;
                }  
            return null;  
    /**
        public boolean isCommitManagedFile(String fileName) {
            org.opensearch.index.engine.dataformat.WriterState.ACTIVE;
        @Override  
                    return Set.of();
            @Override  
            return Map.of();  
        }
    /** Builds a CompositeIndexingExecutionEngine wired with failable stubs. */
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
            }
        public DataFormat getDataFormat() {
            return resultToReturn;  
            return plugin.indexingEngine(null);
            closeCalled = true;
        DataFormat format = stubFormat(formatName, priority, fields);
        @Override  
            this.schemaMutable = mutable;
        @Override  
        }  
        }  
    }
    static DataFormat stubFormat(String name, long priority, Set<FieldTypeCapabilities> fields) {
        DataFormat secondaryFormat,
            when(registry.format(sec.getDataFormat().name())).thenReturn(sec.getDataFormat());
    }
        @Override
        private volatile org.opensearch.index.engine.dataformat.WriterState state =
            @Override
        @Override
final class CompositeTestHelper {
        }
            @Override  
        @Override  
        @Override
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
        public WriteResult addDoc(DocumentInput<?> d) {  
            return dataFormat;  
        FailableWriter getLastCreatedWriter() {
        private volatile org.opensearch.index.engine.dataformat.WriterState state =  
    static DataFormatPlugin stubPlugin(String formatName, long priority, Set<FieldTypeCapabilities> fields) {
        public void setRowId(String rowIdFieldName, long rowId) {}
            return 0;  
        }  
        @Override
        @Override
import org.opensearch.index.engine.dataformat.FileInfos;
            return mappingVersion;
            if (format.name().equals(primaryFormat.name())) {  
        StubIndexingExecutionEngine(DataFormat dataFormat) {  
 */  
        }  
            plugins.put(name, stubPlugin(name, 2));  
            throw new UnsupportedOperationException("stub");
                public Set<FieldTypeCapabilities> supportedFields() {
        @Override  
            for (FailableEngine sec : secondaries) {
            sb.putList("index.composite.secondary_data_formats", names);  
        public IndexStoreProvider getProvider() {
 * compatible open source license.
    }
            public long priority() {  
        /** Test-only setter to inject a state directly. */  
        private final List<FailableWriter> createdWriters = new ArrayList<>();
import java.util.HashMap;
            return 0;  
            return new RefreshResult(Collections.emptyList());
        }  
        @Override
        public void updateMappingVersion(long newVersion) {
            .put("index.composite.primary_data_format", primary.getDataFormat().name())
        }
        }
            return false;  
        when(registry.format(secondaryFormat.name())).thenReturn(secondaryFormat);
import java.util.Set;
        // Tests that want Parquet-style "stay ACTIVE" semantics can flip this flag.
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        @Override
        DataFormat primaryFormat,
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        Writer<DocumentInput<?>> primaryWriter,  
        public List<CatalogSnapshot> listCommittedSnapshots() {  
        }
        @Override
            return 0;
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;  
        FixedWriterEngine(DataFormat dataFormat, Writer<DocumentInput<?>> fixedWriter) {
            public String name() {
        FailableEngine... secondaries  
        public long getNextWriterGeneration() {  
            this.defaultWriteResultSupplier = s;  
        StubWriter lastCreatedWriter;
            return 0;  
            return Map.of();
    }
        @Override
        public Merger getMerger() {
            DataFormat format = invocation.getArgument(1);  
        }
        public void addField(org.opensearch.index.mapper.MappedFieldType fieldType, Object value) {}
        @Override
            return 0;
import java.util.concurrent.atomic.AtomicLong;  
                return new FixedWriterEngine(secondaryFormat, secondaryWriter);
        }  
        volatile RuntimeException createWriterFailure;
        public long getNativeBytesUsed() {
        }  
     */
        FailableWriter(DataFormat format) {}  
        void setState(org.opensearch.index.engine.dataformat.WriterState s) {
        public void close() {}  
        formats.put(primaryFormat.name(), primaryFormat);
            }  
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
            return dataFormat;  
        }
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            state = org.opensearch.index.engine.dataformat.WriterState.CLOSED;
        volatile boolean retireOnRollbackSuccess = true;
        for (Map.Entry<String, DataFormat> entry : formats.entrySet()) {
     * Minimal stub Writer that always succeeds and returns empty FileInfos.
        }
    /** Engine stub producing {@link FailableWriter} instances with optional default failure. */
        @Override  
 * SPDX-License-Identifier: Apache-2.0
        @Override  
        IndexingExecutionEngine<?, ?> secondaryEngine
        }
            return resultToReturn;  
        @Override  
                names[i] = secondaries[i].getDataFormat().name();
}
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            super(dataFormat);  
    }  
            if (defaultWriteResultSupplier != null) w.setResultToReturn(defaultWriteResultSupplier.get());
            state = org.opensearch.index.engine.dataformat.WriterState.CLOSED;  
        @Override
    /**
        public IndexStoreProvider getProvider() {
        Settings settings = settingsBuilder.build();
            return List.of();
        }
        @Override  
                return "StubDataFormat{" + name + "}";
            this.mappingVersion = newVersion;  
            }
        private final DataFormat dataFormat;  
            return fixedWriter;  
        @Override
        @Override
        void setResultToReturn(WriteResult result) {
        @Override  
import org.opensearch.index.engine.dataformat.WriteResult;
        @Override  
        public WriteResult addDoc(DocumentInput<?> d) {
            if (format.name().equals(primaryFormat.name())) {
     */
        public CommitStats getCommitStats() {
        public boolean isSchemaMutable() {
        Map<String, DataFormat> formats = new HashMap<>();
            }
            assert state == org.opensearch.index.engine.dataformat.WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
        return new CompositeIndexingExecutionEngine(indexSettings, null, new StubCommitter(), registry, null, null);  
        Map<String, DataFormat> formats = new HashMap<>();  
            return createdWriters.get(createdWriters.size() - 1);
            this.resultToReturn = result;  
import org.opensearch.index.engine.dataformat.MergeResult;  
            this.dataFormat = dataFormat;
        @Override
    static class FailableEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {
        Map<String, DataFormatPlugin> plugins = new HashMap<>();
    static class StubIndexingExecutionEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {
            settingsBuilder.putList("index.composite.secondary_data_formats", secondaryNames);
            public DataFormat getDataFormat() {
        DataFormat primaryFormat = primaryEngine.getDataFormat();
        formats.put(secondaryFormat.name(), secondaryFormat);  
     * An IndexingExecutionEngine that always returns the same pre-built writer.  
        }
    private CompositeTestHelper() {}  
            public String toString() {
                if (fmt.name().equals(sec.getDataFormat().name())) return sec;
        @Override
        }
            closeCalled = true;
        FailableEngine(String name) {  
        StubWriter(DataFormat format) {
            return new RefreshResult(Collections.emptyList());
import org.opensearch.index.engine.dataformat.WriterConfig;  
        @Override
                return fields;  
        }
     * Minimal stub Committer that records close calls and does nothing on commit.
                @Override  
     */
import org.opensearch.cluster.metadata.IndexMetadata;
    /** Minimal committer stub for tests that don't exercise commit-side failures. */  
        @Override
        return new CompositeIndexingExecutionEngine(indexSettings, null, new StubCommitter(), registry, null, null);
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        when(registry.getIndexingEngine(any(), any())).thenAnswer(invocation -> {
import java.util.concurrent.atomic.AtomicInteger;
        }
import org.opensearch.index.IndexSettings;
            this.resultToReturn = result;  
        @Override  
        }
import static org.mockito.Mockito.when;
            return null;
    }
        public long mappingVersion() {  
        }
            when(registry.format(entry.getKey())).thenReturn(entry.getValue());
    static class StubCommitter implements Committer {  
            .putList("index.composite.secondary_data_formats", secondaryFormat.name())  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            this.fixedWriter = fixedWriter;
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        @Override  
        private final AtomicLong writerGeneration = new AtomicLong(0);
            lastCreatedWriter = new StubWriter(dataFormat);
        }
        public DataFormat getDataFormat() {
        public long getFieldCount(String fieldName) {
            }  
        when(registry.getIndexingEngine(any(), any())).thenAnswer(inv -> {
        @Override
        Writer<DocumentInput<?>> secondaryWriter
