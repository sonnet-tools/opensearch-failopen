                fields.put(fieldType.name(), value.toString());
            if (directory == null) {
        public void setRowId(String rowIdFieldName, long rowId) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.index.engine.dataformat.WriteResult;
        public RefreshResult refresh(RefreshInput input) {
        @Override
                new FieldTypeCapabilities(IndexFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, FULL_TEXT_SEARCH)),
            return state;
        }
        public IndexStoreProvider getProvider() {  
            int n = localCount.incrementAndGet();
            }
            Path file = directory.resolve(fileName);  
import org.opensearch.index.engine.dataformat.Merger;  
    }  
    }  
import org.opensearch.index.engine.dataformat.DataFormat;
import java.util.Map;  
            // composite multi-format atomicity assertion: every format must agree on empty
        public long getHeapBytesUsed() {
    @Override
        @Override
    static class FBDocInput implements DocumentInput<Object> {
            if (throwOnNextDoc) {  
    static class FBEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {  
    };
import java.util.concurrent.atomic.AtomicLong;  
        if (remaining > 0) {
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        failEveryNthDoc.set(0);
        public void rollbackTo(long rowCount) throws IOException {  
    }
        @Override
                throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + docs.size() + " docs");  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.IgnoredFieldMapper;  
        }
            docs.add("gen=" + generation + ",rowId=" + rowId + ",fields=" + fields);
            for (Path file : stream.filter(p -> p.getFileName().toString().endsWith(".txt")).toList()) {
public class FileBackedDataFormatPlugin extends Plugin implements DataFormatPlugin, SearchBackEndPlugin<Object> {
        @Override
            return new RefreshResult(segments);
import java.util.Collection;
            if (remaining <= 0) break;
            WriteResult failure = checkFailure();
                new FieldTypeCapabilities(IgnoredFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),  
            state = WriterState.CLOSED;
 * A file-backed data format plugin for integration tests. Format name: "filebacked".
        final java.util.Map<String, String> fields = new java.util.LinkedHashMap<>();
        return DATA_FORMAT;
            }
        throwOnNextDoc = false;
    }
        return new FBEngine(settings);
            String[] parts = entry.split(",", 3);
                throw new IOException("filebacked rollback injected failure");  
        public Merger getMerger() {  
    @Override
        }
        dataDirectory = dir;  
        List<String> entries = new ArrayList<>();  
            return directory;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
import org.opensearch.index.mapper.SourceFieldMapper;
            state = WriterState.RETIRED_FLUSHABLE;
    static class FBWriter implements Writer<DocumentInput<?>> {  
            return 0;
    private static final AtomicInteger failOnNextNDocs = new AtomicInteger(0);
                new FieldTypeCapabilities(FieldNamesFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH))
    }
        failOnNextNDocs.set(0);  
            this.config = config;
            Files.write(file, docs, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return 0;  
            return new WriteResult.Failure(new IOException("filebacked injected failure"), -1, -1, -1);
        try (var stream = Files.list(dir)) {
import java.util.Set;
 *
        }
    private static volatile boolean throwOnNextDoc;
            remaining = failOnNextNDocs.get();
        failOnNextNDocs.set(n);
        public String name() {
            return true;
            return new FBWriter(config.writerGeneration(), ensureDirectory(), currentMappingVersion());  
            // vs non-empty.
        java.util.Map<String, String> map = new java.util.LinkedHashMap<>();
            if (failOnNextRollback) {
            String fields = parts.length > 2 ? parts[2] : "";
        }
        long rowId = -1;  
        }  
import java.nio.file.Files;  
        failOnNextRollback = false;  
            return writerGen.getAndIncrement();  
            return new WriteResult.Success(1L, 1L, n);  
        @Override
        public long priority() {
        private long currentMappingVersion() {
    public DataFormat getDataFormat() {
    }  
import org.opensearch.index.mapper.RoutingFieldMapper;
                new FieldTypeCapabilities(IdFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
        }  
            return config.mapperService().getIndexSettings().getIndexMetadata().getMappingVersion();
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            while (docs.size() > rowCount) {
        public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
            List<Segment> segments = new ArrayList<>(input.existingSegments());  
import org.opensearch.index.store.PrecomputedChecksumStrategy;
            if (failure != null) {
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> f) {  
import java.nio.file.Path;
    }  
    public EngineReaderManager<?> createReaderManager(ReaderManagerConfig config) {
 */  
import org.opensearch.index.engine.exec.Segment;  
    public static java.util.Map<String, String> parseEntryMap() throws IOException {
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
            long rowId = (d instanceof FBDocInput) ? ((FBDocInput) d).rowId : -1;
import org.opensearch.index.mapper.VersionFieldMapper;  
    public Map<String, java.util.function.Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings s, DataFormatRegistry r) {
        }
    }
    @Override  
import org.opensearch.index.engine.dataformat.RefreshInput;
            }
        public void updateMappingVersion(long newVersion) {
    }
        @Override
                new FieldTypeCapabilities(SourceFieldMapper.NAME, Set.of(STORED_FIELDS)),
    }
        }  
            assert state == WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
    }
        }
        return dataDirectory;
        public DocumentInput<?> newDocumentInput() {
import org.opensearch.index.mapper.NestedPathFieldMapper;
                new FieldTypeCapabilities(VersionFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
import org.opensearch.index.mapper.IdFieldMapper;
 * The OpenSearch Contributors require contributions made to  
                if (state == WriterState.ACTIVE) state = WriterState.PENDING_ROLLBACK;
        @Override
            }
        @Override  
                .writerGeneration(generation)
            return new WriteResult.Failure(new IOException("filebacked injected failure"), -1, -1, -1);
        }  
        private Path ensureDirectory() {
    private static final AtomicInteger failEveryNthDoc = new AtomicInteger(0);
import org.opensearch.plugins.SearchBackEndPlugin;  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;
    }
    public static void clearFailure() {
            }  
            String key = parts[0] + "," + parts[1]; // "gen=N,rowId=M"  
        public long getNativeBytesUsed() {
        }
    private static final AtomicInteger docCounter = new AtomicInteger(0);  
    public static void setFailOnNextNDocs(int n) {  
        @Override
        }
            return Set.of(
        @Override  
        FBWriter(long generation, Path directory, long mappingVersion) {
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
    }
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {  
        private final AtomicInteger localCount = new AtomicInteger();
                throwOnNextDoc = false;
        }
        }  
    }
    public String name() {
        private volatile WriterState state = WriterState.ACTIVE;  
            WriterFileSet wfs = WriterFileSet.builder()
        FBEngine() {
            return 0;
        private final Path directory;
        public void close() {}
                new FieldTypeCapabilities(SeqNoFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, POINT_RANGE)),
import java.util.ArrayList;  
                return FileInfos.empty();
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;  
                }
        Path dir = dataDirectory;
        @Override
import java.util.concurrent.atomic.AtomicInteger;
            return null;
import org.opensearch.index.mapper.KeywordFieldMapper;
 * Writers persist doc IDs as lines in text files. Supports failure injection via static methods.  
        if (every > 0 && count % every == 0) {  
        return map;
            String fields = (d instanceof FBDocInput) ? ((FBDocInput) d).fields.toString() : "{}";  
        failOnNextRollback = fail;
        }  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
            }
import org.opensearch.index.mapper.MappedFieldType;  
            return FileInfos.builder().putWriterFileSet(DATA_FORMAT, wfs).build();
        }  
import java.util.List;
        @Override
    /** Reads all entries from flushed filebacked data files. Each entry is "gen=N,rowId=M,fields={...}". */
        }  
import org.opensearch.index.IndexSettings;
                new FieldTypeCapabilities(TextFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, STORED_FIELDS, FULL_TEXT_SEARCH)),  
        }
/**
        docCounter.set(0);  
        }  
            if (fieldType != null && value != null) {
        FBEngine(IndexingEngineConfig config) {  
import org.opensearch.index.engine.dataformat.FileInfos;
            map.put(key, fields);
            return mappingVersion;
        public WriteResult addDoc(DocumentInput<?> d) throws IOException {  
        }
        FBWriter(long generation, Path directory) {  
        }
            this.generation = generation;
                directory = dataDirectory;  
        int every = failEveryNthDoc.get();
        public void close() {  
        public void close() {}  
            // Lucene-style: any addDoc failure retires the writer.
        public WriterState state() {  
    public static void setThrowOnNextDoc(boolean throwException) {
                .build();
                    throw new IllegalStateException("FileBackedDataFormatPlugin.setDataDirectory() must be called before use");
        private volatile Path directory;
            this.fileName = "data_gen" + generation + ".txt";
        }
            );  
            return Map.of();
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        public long generation() {
package org.opensearch.index.engine.dataformat.stub;
import org.opensearch.index.engine.exec.WriterFileSet;
            return fields.containsKey(fieldName) ? 1 : 0;
        public long getFieldCount(String fieldName) {  
import java.io.IOException;
                // Lucene-style contract: signal PENDING_ROLLBACK so the composite can drive  
            this(generation, directory, 0L);
            }
                .directory(directory)  
                throw new IOException("filebacked injected IOException (throw mode)");
            this.rowId = rowId;
            // No docs in this writer's buffer (e.g. only doc was rolled back) → no file. This
        throwOnNextDoc = throwException;
        public Set<FieldTypeCapabilities> supportedFields() {  
        private final AtomicLong writerGen = new AtomicLong();
 * compatible open source license.
        public long mappingVersion() {  
import org.opensearch.index.engine.dataformat.WriterConfig;  
            if (docs.isEmpty()) {  
    static WriteResult checkFailure() {
        @Override  
        }
}
                new FieldTypeCapabilities(NestedPathFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH)),  
    }
        @Override
import java.nio.file.StandardOpenOption;
        }  
    public static void setDataDirectory(Path dir) {
        }
            // mirrors LuceneWriter.flush(docCount == 0 → empty) and is required for the  
        }  
        @Override
        @Override
        }  
    /** Parses entries into a map of "gen:rowId" → "fields" for cross-format comparison. */  
        for (String entry : readAllEntries()) {  
import org.opensearch.index.engine.dataformat.MergeResult;
        }
    public static void setFailOnNextRollback(boolean fail) {  
        public long getNextWriterGeneration() {
    public static List<String> readAllEntries() throws IOException {  
            return df -> null;
            this.mappingVersion = mappingVersion;
            return new FBDocInput();
    private static volatile Path dataDirectory;  
            }
            return i -> new MergeResult(Map.of());
        @Override
        public void addField(MappedFieldType fieldType, Object value) {  
                new FieldTypeCapabilities(DocCountFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;  
        }  
        return new MockReaderManager(FORMAT_NAME);  
    public List<String> getSupportedFormats() {  
        return List.of(FORMAT_NAME);
    }
                entries.addAll(Files.readAllLines(file));  
        }
import org.opensearch.index.mapper.TextFieldMapper;
        public boolean isSchemaMutable() {
/*  
        private volatile long mappingVersion;
        int remaining;
import org.opensearch.index.mapper.DocCountFieldMapper;  
import org.opensearch.plugins.Plugin;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;
        }
        }
    private static final DataFormat DATA_FORMAT = new DataFormat() {  
        } while (failOnNextNDocs.compareAndSet(remaining, remaining - 1) == false);  
            return DATA_FORMAT;
    public static final String FORMAT_NAME = "filebacked";
        @Override  
            }  
        private final IndexingEngineConfig config;  
            this.config = null;  
    }  
    public static Path getDataDirectory() {
        @Override
    @Override
        int count = docCounter.incrementAndGet();
import org.opensearch.index.engine.exec.EngineReaderManager;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        failEveryNthDoc.set(n);
                new FieldTypeCapabilities(KeywordFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, STORED_FIELDS, FULL_TEXT_SEARCH)),
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;  
                return failure;  
                // rollbackLastDoc, which moves us to RETIRED_FLUSHABLE.
        if (dir == null || Files.exists(dir) == false) return List.of();
                new FieldTypeCapabilities(RoutingFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
        }
        public FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) throws IOException {
        @Override
                .addNumRows(docs.size())  
        private final String fileName;  
import org.opensearch.index.engine.dataformat.Writer;
        do {  
        private final long generation;
                .addFile(fileName)
import org.opensearch.index.engine.dataformat.RefreshResult;  
                failOnNextRollback = false;
    private static volatile boolean failOnNextRollback;
    }
        private final List<String> docs = new ArrayList<>();
        @Override
 */
import org.opensearch.index.mapper.IndexFieldMapper;
            if (newVersion > mappingVersion) {  
        @Override  
            this.directory = directory;  
            if (rowCount > docs.size()) {
            }
            return generation;  
import org.opensearch.index.engine.dataformat.DocumentInput;  
import org.opensearch.index.engine.dataformat.WriterState;
        return entries;  
                mappingVersion = newVersion;
            // entry format: gen=N,rowId=M,fields={...}
                docs.remove(docs.size() - 1);  
        @Override  
        }  
import org.opensearch.index.mapper.FieldNamesFieldMapper;
    public static void setFailEveryNthDoc(int n) {
        public Object getFinalInput() {
            segments.addAll(input.writerFiles());
        @Override
        @Override
        }  
                new FieldTypeCapabilities(SeqNoFieldMapper.PRIMARY_TERM_NAME, Set.of(COLUMNAR_STORAGE)),  
                if (dataDirectory == null) {  
        @Override  
        public DataFormat getDataFormat() {
            if (config == null || config.mapperService() == null) return 0L;  
        return "filebacked-backend";
            return FORMAT_NAME;  
        @Override  
    }  
        return null;  
        docCounter.set(0);
        @Override
        return Map.of(FORMAT_NAME, () -> new DataFormatDescriptor(FORMAT_NAME, new PrecomputedChecksumStrategy()));  
    @Override  
