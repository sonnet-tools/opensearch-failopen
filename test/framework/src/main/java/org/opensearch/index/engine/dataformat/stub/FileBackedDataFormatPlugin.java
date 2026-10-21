import org.opensearch.index.mapper.TextFieldMapper;
import org.opensearch.index.engine.exec.EngineReaderManager;
        @Override
        public long generation() {
        }
            }
 * The OpenSearch Contributors require contributions made to
        private final IndexingEngineConfig config;
import org.opensearch.index.mapper.MappedFieldType;
            return new WriteResult.Success(1L, 1L, n);
            for (Path file : stream.filter(p -> p.getFileName().toString().endsWith(".txt")).toList()) {
        public Merger getMerger() {
                directory = dataDirectory;
            assert state == WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
        }
            state = WriterState.CLOSED;
        }
    @Override
            return 0;
        @Override
    static class FBWriter implements Writer<DocumentInput<?>> {
        @Override
        @Override
        }
import java.nio.file.StandardOpenOption;
        Path dir = dataDirectory;
        }
import org.opensearch.index.mapper.IgnoredFieldMapper;
    private static volatile boolean failOnNextRollback;
    }
/*
        public String name() {
        public long getNativeBytesUsed() {
        long rowId = -1;
import org.opensearch.index.engine.dataformat.RefreshInput;
            // No docs in this writer's buffer (e.g. only doc was rolled back) → no file. This
        return map;
            return FORMAT_NAME;
        return new MockReaderManager(FORMAT_NAME);
            }
            // entry format: gen=N,rowId=M,fields={...}
        @Override
        throwOnNextDoc = throwException;
            }
            if (rowCount > docs.size()) {
    }
        }
                fields.put(fieldType.name(), value.toString());
        FBWriter(long generation, Path directory, long mappingVersion) {
        }
    public DataFormat getDataFormat() {
            map.put(key, fields);
            state = WriterState.RETIRED_FLUSHABLE;
        public void setRowId(String rowIdFieldName, long rowId) {
import org.opensearch.index.engine.dataformat.Writer;
        @Override
        failEveryNthDoc.set(n);
            }
            if (newVersion > mappingVersion) {
            );
    /** Parses entries into a map of "gen:rowId" → "fields" for cross-format comparison. */
                mappingVersion = newVersion;
        @Override
                .directory(directory)
        }
    public Map<String, java.util.function.Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings s, DataFormatRegistry r) {
        }
        @Override
        return null;
            String key = parts[0] + "," + parts[1]; // "gen=N,rowId=M"
        @Override
    @Override
        }
    public static void setFailEveryNthDoc(int n) {
        public DataFormat getDataFormat() {
                new FieldTypeCapabilities(FieldNamesFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH))
        private final AtomicLong writerGen = new AtomicLong();
        int every = failEveryNthDoc.get();
        failOnNextRollback = fail;
                throwOnNextDoc = false;
    }
        public IndexStoreProvider getProvider() {
        return "filebacked-backend";
        public long mappingVersion() {
        @Override
            remaining = failOnNextNDocs.get();
            return DATA_FORMAT;
    static class FBEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {
        }
import org.opensearch.plugins.SearchBackEndPlugin;
 */
            if (fieldType != null && value != null) {
    }
        }
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
            if (failure != null) {
        do {
        }
    }
            return fields.containsKey(fieldName) ? 1 : 0;
import org.opensearch.index.engine.dataformat.WriterState;
        failOnNextRollback = false;
        private final long generation;
            int n = localCount.incrementAndGet();
        public long getNextWriterGeneration() {
        private volatile Path directory;
        @Override
            segments.addAll(input.writerFiles());
            this.config = null;
            // composite multi-format atomicity assertion: every format must agree on empty
                throw new IOException("filebacked injected IOException (throw mode)");
            return i -> new MergeResult(Map.of());
        public long priority() {
        }
            this.config = config;
            docs.add("gen=" + generation + ",rowId=" + rowId + ",fields=" + fields);
import org.opensearch.index.IndexSettings;
import org.opensearch.index.engine.exec.WriterFileSet;
        }
import org.opensearch.index.mapper.SeqNoFieldMapper;
        docCounter.set(0);
    }
        }
            if (failOnNextRollback) {
        failOnNextNDocs.set(n);
            return directory;
        }
    private static final DataFormat DATA_FORMAT = new DataFormat() {
import java.nio.file.Files;
        throwOnNextDoc = false;
import org.opensearch.index.engine.dataformat.RefreshResult;
        @Override
            // Lucene-style: any addDoc failure retires the writer.
import org.opensearch.index.mapper.NestedPathFieldMapper;
    @Override
            return df -> null;
            return true;
        @Override
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        }
        }
            this.generation = generation;
        }
import org.opensearch.index.engine.dataformat.DocumentInput;
        List<String> entries = new ArrayList<>();
        }
        public WriteResult addDoc(DocumentInput<?> d) throws IOException {
                }
        }
        return DATA_FORMAT;
                new FieldTypeCapabilities(SourceFieldMapper.NAME, Set.of(STORED_FIELDS)),
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
import org.opensearch.index.engine.dataformat.FileInfos;
                docs.remove(docs.size() - 1);
import java.util.concurrent.atomic.AtomicInteger;
        public void rollbackTo(long rowCount) throws IOException {
            if (docs.isEmpty()) {
        for (String entry : readAllEntries()) {
            if (directory == null) {
    public List<String> getSupportedFormats() {
        public Set<FieldTypeCapabilities> supportedFields() {
    }
        int count = docCounter.incrementAndGet();
    }
            return mappingVersion;
import org.opensearch.index.engine.dataformat.MergeResult;
import org.opensearch.index.mapper.RoutingFieldMapper;
        public long getHeapBytesUsed() {
        @Override
    public static List<String> readAllEntries() throws IOException {
        @Override
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
import org.opensearch.index.mapper.VersionFieldMapper;
import java.io.IOException;
    }
        }
            return new RefreshResult(segments);
                    throw new IllegalStateException("FileBackedDataFormatPlugin.setDataDirectory() must be called before use");
        public void close() {}
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
    public static void clearFailure() {
    static WriteResult checkFailure() {
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
 *
    public static void setDataDirectory(Path dir) {
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> f) {
    private static final AtomicInteger docCounter = new AtomicInteger(0);
        @Override
    public static java.util.Map<String, String> parseEntryMap() throws IOException {
            return null;
            String[] parts = entry.split(",", 3);
 */
            return 0;
        public long getFieldCount(String fieldName) {
        }
        final java.util.Map<String, String> fields = new java.util.LinkedHashMap<>();
public class FileBackedDataFormatPlugin extends Plugin implements DataFormatPlugin, SearchBackEndPlugin<Object> {
                return FileInfos.empty();
                new FieldTypeCapabilities(SeqNoFieldMapper.PRIMARY_TERM_NAME, Set.of(COLUMNAR_STORAGE)),
            return Map.of();
        @Override
            String fields = (d instanceof FBDocInput) ? ((FBDocInput) d).fields.toString() : "{}";
    public static Path getDataDirectory() {
            this.directory = directory;
        }
import org.opensearch.index.mapper.SourceFieldMapper;
        @Override
        public Object getFinalInput() {
            // mirrors LuceneWriter.flush(docCount == 0 → empty) and is required for the
        FBEngine() {
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
                new FieldTypeCapabilities(IgnoredFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
    };
        } while (failOnNextNDocs.compareAndSet(remaining, remaining - 1) == false);
        if (dir == null || Files.exists(dir) == false) return List.of();
                .build();
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
 * A file-backed data format plugin for integration tests. Format name: "filebacked".
import org.opensearch.index.engine.dataformat.WriterConfig;
        return Map.of(FORMAT_NAME, () -> new DataFormatDescriptor(FORMAT_NAME, new PrecomputedChecksumStrategy()));
    public static void setFailOnNextRollback(boolean fail) {
import org.opensearch.index.mapper.DocCountFieldMapper;
            }
 * compatible open source license.
                // rollbackLastDoc, which moves us to RETIRED_FLUSHABLE.
        if (remaining > 0) {
        private final Path directory;
        }
        failEveryNthDoc.set(0);
                new FieldTypeCapabilities(VersionFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
        }
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        return List.of(FORMAT_NAME);
    @Override
import java.nio.file.Path;
        @Override
        @Override
        }
 * Writers persist doc IDs as lines in text files. Supports failure injection via static methods.
                entries.addAll(Files.readAllLines(file));
        public RefreshResult refresh(RefreshInput input) {
            return writerGen.getAndIncrement();
    }
            WriteResult failure = checkFailure();
                if (dataDirectory == null) {
            long rowId = (d instanceof FBDocInput) ? ((FBDocInput) d).rowId : -1;
import java.util.ArrayList;
        return dataDirectory;
            return config.mapperService().getIndexSettings().getIndexMetadata().getMappingVersion();
import org.opensearch.index.mapper.IdFieldMapper;
                return failure;
    }
        }
        if (every > 0 && count % every == 0) {
            return new WriteResult.Failure(new IOException("filebacked injected failure"), -1, -1, -1);
    }
        public void close() {}
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        java.util.Map<String, String> map = new java.util.LinkedHashMap<>();
            return FileInfos.builder().putWriterFileSet(DATA_FORMAT, wfs).build();
            return Set.of(
import org.opensearch.index.engine.dataformat.DataFormat;
        @Override
}
        int remaining;
                // Lucene-style contract: signal PENDING_ROLLBACK so the composite can drive
import java.util.Collection;
    private static volatile boolean throwOnNextDoc;
    }
        public FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) throws IOException {
        private volatile long mappingVersion;
    @Override
            this(generation, directory, 0L);
                if (state == WriterState.ACTIVE) state = WriterState.PENDING_ROLLBACK;
        public WriterState state() {
        @Override
            WriterFileSet wfs = WriterFileSet.builder()
    }
        private volatile WriterState state = WriterState.ACTIVE;
        private final List<String> docs = new ArrayList<>();
            }
        @Override
            String fields = parts.length > 2 ? parts[2] : "";
                .addFile(fileName)
    public static void setFailOnNextNDocs(int n) {
    }
        try (var stream = Files.list(dir)) {
        return entries;
    private static volatile Path dataDirectory;
        return new FBEngine(settings);
 * SPDX-License-Identifier: Apache-2.0
            }
        @Override
        dataDirectory = dir;
        }
            this.fileName = "data_gen" + generation + ".txt";
/**
            }
            while (docs.size() > rowCount) {
        @Override
    public EngineReaderManager<?> createReaderManager(ReaderManagerConfig config) {
    static class FBDocInput implements DocumentInput<Object> {
import org.opensearch.index.engine.dataformat.Merger;
import org.opensearch.index.engine.dataformat.WriteResult;
            return state;
        }
    @Override
        FBWriter(long generation, Path directory) {
                new FieldTypeCapabilities(RoutingFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
import java.util.List;
            return new FBWriter(config.writerGeneration(), ensureDirectory(), currentMappingVersion());
        private final AtomicInteger localCount = new AtomicInteger();
                .addNumRows(docs.size())
    /** Reads all entries from flushed filebacked data files. Each entry is "gen=N,rowId=M,fields={...}". */
import org.opensearch.index.mapper.KeywordFieldMapper;
                failOnNextRollback = false;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;
            Path file = directory.resolve(fileName);
        FBEngine(IndexingEngineConfig config) {
import java.util.Set;
                new FieldTypeCapabilities(KeywordFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, STORED_FIELDS, FULL_TEXT_SEARCH)),
        }
import java.util.concurrent.atomic.AtomicLong;
            if (throwOnNextDoc) {
        public DocumentInput<?> newDocumentInput() {
        private Path ensureDirectory() {
        public void addField(MappedFieldType fieldType, Object value) {
        public void updateMappingVersion(long newVersion) {
        @Override
                new FieldTypeCapabilities(DocCountFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
        private long currentMappingVersion() {
import org.opensearch.index.mapper.IndexFieldMapper;
        public boolean isSchemaMutable() {
            }
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
            return 0;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;
    }
        }
    public static void setThrowOnNextDoc(boolean throwException) {
            return new WriteResult.Failure(new IOException("filebacked injected failure"), -1, -1, -1);
        failOnNextNDocs.set(0);
            return new FBDocInput();
            // vs non-empty.
    private static final AtomicInteger failOnNextNDocs = new AtomicInteger(0);
            }
import java.util.Map;
                throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + docs.size() + " docs");
                new FieldTypeCapabilities(IdFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
        public void close() {
            Files.write(file, docs, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                .writerGeneration(generation)
            this.mappingVersion = mappingVersion;
    private static final AtomicInteger failEveryNthDoc = new AtomicInteger(0);
import org.opensearch.index.store.PrecomputedChecksumStrategy;
        }
import org.opensearch.index.mapper.FieldNamesFieldMapper;
            this.rowId = rowId;
        @Override
import org.opensearch.index.engine.exec.Segment;
    }
package org.opensearch.index.engine.dataformat.stub;
            if (remaining <= 0) break;
                new FieldTypeCapabilities(NestedPathFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH)),
        }
            List<Segment> segments = new ArrayList<>(input.existingSegments());
 * this file be licensed under the Apache-2.0 license or a
                new FieldTypeCapabilities(TextFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, STORED_FIELDS, FULL_TEXT_SEARCH)),
            return generation;
        @Override
                new FieldTypeCapabilities(SeqNoFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, POINT_RANGE)),
                new FieldTypeCapabilities(IndexFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, FULL_TEXT_SEARCH)),
    public String name() {
    public static final String FORMAT_NAME = "filebacked";
        }
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
        private final String fileName;
            if (config == null || config.mapperService() == null) return 0L;
    }
                throw new IOException("filebacked rollback injected failure");
        docCounter.set(0);
import org.opensearch.plugins.Plugin;
    }
