                ValueLayout.JAVA_LONG,    // return value  
     */
            ParquetFileMetadata metadata = new ParquetFileMetadata(
                ValueLayout.ADDRESS,  
            FunctionDescriptor.of(  
                ValueLayout.ADDRESS,    // out_row_id_mapping_max
                    } else {  
                ValueLayout.ADDRESS,
        long genSizesAddr = outGenSizesPtr.get(ValueLayout.JAVA_LONG, 0);  
        }  
                outGenKeysPtr,
            var typeBfFpp = toDoubleMapArrays(call, nativeSettings.getTypeBloomFilterFpp());
                typeEncodings.values().lens(),  
                ValueLayout.JAVA_LONG    // type_bf_ndv_name_ptrs, type_bf_ndv_name_lens, type_bf_ndv_vals, type_bf_ndv_count
                ValueLayout.JAVA_LONG
                ct != null ? ct.len() : -1L,  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
                nativeSettings.getDictSizeBytes() != null ? nativeSettings.getDictSizeBytes() : -1L,
            lib.find("parquet_free_merge_result").orElseThrow(),
            var typeEncodings = toNativeArrays(call, nativeSettings.getTypeEncodings());
            var versionOut = call.intOut();
                .toArray(ValueLayout.JAVA_LONG);
                ValueLayout.JAVA_LONG,   // type_bf_fpp_name_ptrs, type_bf_fpp_name_lens, type_bf_fpp_vals, type_bf_fpp_count  
            var sortPermPtrOut = call.longOut();
     * flagged in {@code liveBitsPerInput} are dropped from the output; row count is bounded by
     * Returns a JSON string with per-column encoding and compression metadata from the first row group.  
                ValueLayout.JAVA_LONG,
                    long[] bits = liveBitsPerInput[i];
    }  
    }  
    public static long[] collectRuntimeMetrics() {  
                ValueLayout.JAVA_LONG,  // gen_keys_ptr  
     * Performs a native k-way merge of {@code inputFiles} into {@code outputFile}. Dead rows  
                    if (bits == null || bits.length == 0) {  
    private static final MethodHandle GET_FILE_METADATA;  
import java.io.UncheckedIOException;
public class RustBridge {  
            var outGenKeysPtr = call.longOut();  
                ValueLayout.JAVA_LONG, // sort_columns (ptrs, lens, count)  
                ValueLayout.ADDRESS   // num_row_groups_out
            int len = (int) outLen.get(ValueLayout.JAVA_LONG, 0);  
                try {
                effectiveFieldBfEnabled = new HashMap<>(nativeSettings.getFieldBloomFilterEnabled());
            call.invokeIO(READ_AS_JSON, f.segment(), f.len(), outBuf, (long) bufSize, outLen);
                ValueLayout.ADDRESS,  
                MethodType.methodType(void.class, long.class)
                    }  
            seg.setAtIndex(ValueLayout.JAVA_LONG, i, map.get(keys[i]));  
                ValueLayout.ADDRESS,    // out_gen_offsets_ptr
                ValueLayout.ADDRESS,    // out_mapping_len  
                idx.segment(),
                typeBfNdv.keys().count()
                fieldEncodings.values().lens(),
        }  
                typeBfNdv.keys().ptrs(),
                ValueLayout.JAVA_LONG   // live-docs count (0 = all alive)
    ) {
     * Collects a snapshot of native runtime metrics for the parquet merge path.
                        .reinterpret(permLen * ValueLayout.JAVA_LONG.byteSize())
        }  
            lib.find("parquet_create_writer").orElseThrow(),
/*  
                ValueLayout.ADDRESS,
            var createdByOut = call.outBuffer(1024);
                ValueLayout.ADDRESS,    // out_mapping_ptr
            call.invokeIO(
                GET_FILE_METADATA,  
                ValueLayout.JAVA_LONG,  // gen_offsets_ptr
                typeBfFpp.values(),
                ValueLayout.JAVA_LONG   // gen_count  
        INIT_MEMORY_POOLS = linker.downcallHandle(
                ValueLayout.ADDRESS,
 */  
            lib.find("parquet_set_write_pool_limit").orElseThrow(),
            var sortPermLenOut = call.longOut();  
        var seg = keys.length > 0 ? call.buf(keys.length * 8) : MemorySegment.NULL;
                ValueLayout.JAVA_LONG,                         // mapping_ptr
        FREE_ROW_ID_MAPPING = linker.downcallHandle(
                nativeSettings.getBloomFilterNdv() != null ? nativeSettings.getBloomFilterNdv() : -1L,
            call.invokeIO(CLEANUP_WRITER, f.segment(), f.len());
                ValueLayout.JAVA_LONG                          // mapping_len  
                outGenOffsetsPtr,  
                numRowsOut.get(ValueLayout.JAVA_LONG, 0),
                .reinterpret(genCount * ValueLayout.JAVA_INT.byteSize())
            var idx = call.str(indexName);
            // Read generation keys (i64[]), offsets (i32[]), sizes (i32[])  
                ValueLayout.JAVA_LONG,  // gen_sizes_ptr
            var p = call.str(pathPrefix);
                fieldCompressions.values().lens(),
import java.util.function.LongSupplier;
        Linker linker = Linker.nativeLinker();  
                outGenCount
import java.nio.file.Path;
                .toArray(ValueLayout.JAVA_LONG);  
        }
                typeBfFpp.keys().count(),  
        );  
    public static void removeSettings(String indexName) {  
import org.opensearch.index.engine.dataformat.RowIdMapping;
            FunctionDescriptor.of(
        try (var call = new NativeCall()) {
                ValueLayout.ADDRESS,    // num_rows_out  
            // Out-pointers for Rust-allocated mapping data  
        try (var call = new NativeCall()) {
     * <p>{@code liveBitsPerInput} is parallel to {@code inputFiles} — each bitset uses Lucene
                ValueLayout.ADDRESS,
    private static final MethodHandle WRITE;  
    private static long overCommitDecide() {  
            lib.find("parquet_write").orElseThrow(),
                nativeSettings.getMergeBatchSize() != null ? (long) nativeSettings.getMergeBatchSize() : -1L,
                ValueLayout.JAVA_LONG,
        }  
                ValueLayout.JAVA_LONG,                        // merge_io_threads  
            var f = call.str(file);
        }  
                idx.len(),
            );
                liveBitsPtrs = MemorySegment.NULL;
            int createdByLen = out.actualLength();
            var out = call.outBuffer(1024);
                inputs.ptrs(),
                nativeSettings.getBloomFilterFpp() != null ? nativeSettings.getBloomFilterFpp() : -1.0,  
        return new MapArrays(call.strArray(keys), call.strArray(values));
        try (var call = new NativeCall()) {
        );  
import org.opensearch.nativebridge.spi.NativeCall;  
                ValueLayout.JAVA_LONG,                        // bloom_filter_ndv  
                out.lenOut(),  
                outputWriterGeneration,  
            var outGenSizesPtr = call.longOut();
        try (var call = new NativeCall()) {  
                numRowsOut,  
            MethodHandle decideHandle = lookup.findStatic(RustBridge.class, "overCommitDecide", MethodType.methodType(long.class));
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
     */
        long[][] liveBitsPerInput,
                fieldCompressions.keys().count(),
     * Removes the native writer registry entry for {@code file} without finalizing it (idempotent).
            var outFlushChunkTimeMillis = call.longOut();  
        try {  
     * the input sum.
            // Read sort permutation if present  
            lib.find("parquet_merge_files").orElseThrow(),  
            return out;
        return seg;
        }  
                typeEncodings.keys().ptrs(),  
                typeBfEnabled.keys().ptrs(),
    public static String readAsJson(String file) throws IOException {
            // best-effort
     *  
            }
        REMOVE_SETTINGS = linker.downcallHandle(
                ValueLayout.ADDRESS,
                idx.segment(),  
        }
            seg.setAtIndex(ValueLayout.JAVA_LONG, i, bools.get(i) ? 1L : 0L);  
    private static void overCommitRelease(long token) {
        );
    private static final MethodHandle FINALIZE_WRITER;
                (long) sortConfig.nullsFirst().size(),  
                inputs.count(),
                typeCompressions.values().lens(),
            }  
                        .toArray(ValueLayout.JAVA_LONG);
                ValueLayout.JAVA_LONG,  // mapping_ptr
                ValueLayout.ADDRESS,
    private static volatile LongConsumer overCommitReleaser;  
    public static MergeFilesResult mergeParquetFilesInRust(
import java.util.Map;
            int[] genOffsets = MemorySegment.ofAddress(genOffsetsAddr)
    /**
            FunctionDescriptor.of(  
                ValueLayout.JAVA_LONG,
 */
                0L,
        } catch (IOException e) {  
            throw new java.io.UncheckedIOException("collectRuntimeMetrics failed", e);
            );
            MethodHandle releaseHandle = lookup.findStatic(
                ValueLayout.JAVA_LONG,                        // schema_address  
        );
            long rc = call.invokeIO(
            }
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
                nativeSettings.getRowGroupMaxRows() != null ? (long) nativeSettings.getRowGroupMaxRows() : -1L,  
                ct != null ? ct.segment() : java.lang.foreign.MemorySegment.NULL,
            var versionOut = call.intOut();  
            var crc32Out = call.longOut();  
            var numRowGroupsOut = call.longOut();  
    private static final MethodHandle READ_AS_JSON;
        String[] paths = inputFiles.stream().map(Path::toString).toArray(String[]::new);  
    public static ParquetFileMetadata getFileMetadata(String file) throws IOException {
            NativeCall.invokeVoid(FREE_MERGE_RESULT, mappingAddr, mappingLen, genKeysAddr, genOffsetsAddr, genSizesAddr, genCount);
                nativeSettings.getMergeRayonThreads() != null ? (long) nativeSettings.getMergeRayonThreads() : -1L,  
                fieldEncodings.keys().lens(),  
                ValueLayout.JAVA_LONG,   // type_bf_enabled_name_ptrs, type_bf_enabled_name_lens, type_bf_enabled_vals,
        overCommitReleaser = release;
            return 0L; // never let an exception cross the native boundary
            );  
        FREE_MERGE_RESULT = linker.downcallHandle(
        GET_FILE_METADATA = linker.downcallHandle(
        }
            return new String(outBuf.asSlice(0, len).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8);
                ValueLayout.JAVA_LONG,   // max_sort_modes (vals, count)  
        NativeCall.invokeVoid(INIT_MEMORY_POOLS, writeLimit, mergeLimit);  
import java.lang.invoke.MethodHandle;  
            int len = (int) outLen.get(ValueLayout.JAVA_LONG, 0);  
                ValueLayout.ADDRESS,
            var fieldEncodings = toNativeArrays(call, nativeSettings.getFieldEncodings());
    }  
                ValueLayout.JAVA_LONG,                        // merge_batch_size
        long genKeysAddr = outGenKeysPtr.get(ValueLayout.JAVA_LONG, 0);
        try (var call = new NativeCall()) {  
            return new WriterFinalizeResult(metadata, rowIdMapping);  
            final MemorySegment liveBitsPtrs;
     * survive as a stale entry and block recovery's re-create for the same file.  
            var sorts = call.strArray(sortConfig.sortColumns().toArray(new String[0]));
            var crc32Out = call.longOut();
                ValueLayout.JAVA_LONG,
                f.len(),
                nativeSettings.getBloomFilterEnabled() != null ? (nativeSettings.getBloomFilterEnabled() ? 1L : 0L) : -1L,
                ValueLayout.ADDRESS,
            } else {  
                ValueLayout.JAVA_DOUBLE,                      // bloom_filter_fpp
/**  
                sortPermLenOut
    private static final MethodHandle GET_FILTERED_BYTES;
    }  
                ValueLayout.ADDRESS,      // out_buf
                maxSortModesArray,
                        liveBitsPtrs.setAtIndex(ValueLayout.ADDRESS, i, call.longs(bits));
            MethodHandles.Lookup lookup = MethodHandles.lookup();  
            // Out-pointers for per-merge stats forwarded to the per-shard tracker.
            var outGenCount = call.longOut();  
            );  
            seg.setAtIndex(ValueLayout.JAVA_DOUBLE, i, map.get(keys[i]));  
                outGenSizesPtr,
import java.lang.foreign.Arena;  
            var outMappingPtr = call.longOut();
        MERGE_FILES = linker.downcallHandle(
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
    private static final MethodHandle INIT_MEMORY_POOLS;
                ValueLayout.ADDRESS,
            var f = call.str(file);
                ValueLayout.ADDRESS,  
import java.lang.foreign.MemorySegment;  
 * SPDX-License-Identifier: Apache-2.0
                    ? new String(createdByOut.data().asSlice(0, createdByLen).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8)
                sorts.lens(),
            long[] mappingArray = MemorySegment.ofAddress(mappingAddr)
            var typeBfEnabled = toBoolMapArrays(call, nativeSettings.getTypeBloomFilterEnabled());  
                typeEncodings.keys().lens(),
    record WriterFinalizeResult(ParquetFileMetadata metadata, RowIdMapping rowIdMapping) {  
                CREATE_WRITER,  
        var seg = keys.length > 0 ? call.buf(keys.length * 8) : MemorySegment.NULL;
    private static final MethodHandle FREE_MERGE_RESULT;  
        try (var call = new NativeCall()) {
        long genOffsetsAddr = outGenOffsetsPtr.get(ValueLayout.JAVA_LONG, 0);
                ValueLayout.ADDRESS,
                liveBitsCount = paths.length;
            NativeCall.invokeVoid(GET_POOL_STATS, buf);
    }  
     * decision itself runs in {@code decide}/{@code release}; this method only wires the plumbing.  
            call.invokeIO(  
                createdByOut.data(),  
            if (rc == 1) return null;  
    }  
                        liveBitsPtrs.setAtIndex(ValueLayout.ADDRESS, i, MemorySegment.NULL);
            var out = call.outBuffer(1024);
                versionOut.get(ValueLayout.JAVA_INT, 0),
    }
            if (r != null) {
        overCommitDecider = decide;
            Map<String, Boolean> effectiveFieldBfEnabled;
    static WriterFinalizeResult finalizeWriter(String file) throws IOException {  
            var f = call.str(file);
    }
                ValueLayout.ADDRESS,    // out_gen_sizes_ptr  
                ValueLayout.JAVA_LONG,   // compression_type
        String[] keys = map.keySet().toArray(new String[0]);  
     * Format: {"column_name": {"encodings": ["PLAIN", "RLE_DICTIONARY"], "compression": "LZ4_RAW"}, ...}
     * Reads a parquet file and returns its contents as a JSON string.  
            var idx = call.str(nativeSettings.getIndexName());
                crc32Out.get(ValueLayout.JAVA_LONG, 0),
            )
                .reinterpret(mappingLen * ValueLayout.JAVA_LONG.byteSize())  
    static void cleanupWriter(String file) throws IOException {
                crc32Out,  
        try (var call = new NativeCall()) {
    public static void setWritePoolLimit(long newLimit) {  
    private static final MethodHandle CLEANUP_WRITER;
                ValueLayout.ADDRESS,
                .toArray(ValueLayout.JAVA_INT);  
        List<Path> inputFiles,  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
                f.segment(),  
        MemorySegment outGenOffsetsPtr,
            var f = call.str(file);  
                nativeSettings.getCompressionLevel() != null ? (long) nativeSettings.getCompressionLevel() : -1L,
        LongConsumer r = overCommitReleaser;
            if (lcFields.isEmpty()) {
    public static String getColumnMetadata(String file) throws IOException {  
                typeEncodings.keys().count(),
            final long liveBitsCount;  
                r.accept(token);
                ValueLayout.ADDRESS,  
                outGenOffsetsPtr,
                ValueLayout.JAVA_LONG,  
        SET_WRITE_POOL_LIMIT = linker.downcallHandle(  
    public static long[] getPoolStats() {
import java.util.Set;
                    NativeCall.invokeVoid(FREE_ROW_ID_MAPPING, permAddr, permLen);
                (int) numRowGroupsOut.get(ValueLayout.JAVA_LONG, 0)  
        MemorySegment outGenKeysPtr,  
                liveBitsPtrs,
            // Read mapping array (i64[])
            )  
            Map<Long, Integer> sizeMap = new HashMap<>((int) genCount);  
        for (int i = 0; i < keys.length; i++) {
                ValueLayout.ADDRESS,
        MemorySegment outGenSizesPtr,
            Set<String> lcFields = nativeSettings.getLowCardinalityEnabledFields();  
                ValueLayout.ADDRESS,    // live-docs lens  
        );  
        try (var call = new NativeCall()) {  
                numRowsOut,
                ValueLayout.ADDRESS,
                                         // type_bf_enabled_count
        String outputFile,
            FunctionDescriptor.of(
        FINALIZE_WRITER = linker.downcallHandle(  
            call.invokeIO(WRITE, f.segment(), f.len(), arrayAddress, schemaAddress);
            return new String(out.data().asSlice(0, len).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8);
                ValueLayout.ADDRESS,
                bfEnabled.keys().lens(),
            for (int i = 0; i < ParquetNativeRuntimeStats.FIELD_COUNT; i++) {
                ValueLayout.ADDRESS,     // out_buf  
                offsetMap.put(genKeys[i], genOffsets[i]);
    /**
                createdByOut.lenOut(),
                typeCompressions.keys().ptrs(),
        }
            lib.find("parquet_free_row_id_mapping").orElseThrow(),  
                ValueLayout.ADDRESS,
            values[i] = map.get(keys[i]);  
            }
    /**
                        liveBitsLens.setAtIndex(ValueLayout.JAVA_LONG, i, (long) bits.length);
                out.segment(),
                ValueLayout.JAVA_LONG,                        // dict_size_bytes  
                nativeSettings.getPageRowLimit() != null ? (long) nativeSettings.getPageRowLimit() : -1L,  
                ValueLayout.ADDRESS,    // created_by_len_out  
                ValueLayout.JAVA_LONG,  // index_name  
        } catch (IOException e) {
        );
    private static DoubleMapArrays toDoubleMapArrays(NativeCall call, Map<String, Double> map) {
import org.opensearch.parquet.stats.ParquetNativeRuntimeStats;
}
                ValueLayout.ADDRESS,    // live-docs ptrs (per-input bitsets)
            var outRowIdMappingMax = call.longOut();
                ValueLayout.ADDRESS,    // out_gen_keys_ptr
                nullsFirstArray,
import java.lang.invoke.MethodHandles;
            var inputs = call.strArray(paths);
                typeCompressions.keys().count(),  
                ValueLayout.JAVA_LONG,  
     * native library so a full native pool can consult the (Java allocator-owned) decision. The
    static void createWriter(String file, String indexName, long schemaAddress, ParquetSortConfig sortConfig, long writerGeneration)
        long mappingAddr = outMappingPtr.get(ValueLayout.JAVA_LONG, 0);
                outMappingPtr,  
        );  
                crc32Out,
            lib.find("parquet_get_column_metadata").orElseThrow(),  
import java.lang.invoke.MethodType;
        GET_POOL_STATS = linker.downcallHandle(
            FunctionDescriptor.of(
                numRowsOut.get(ValueLayout.JAVA_LONG, 0),
            )  
                ValueLayout.JAVA_LONG,   // type_encoding_name_ptrs, type_encoding_name_lens, type_encoding_value_ptrs,
            lib.find("parquet_set_merge_pool_limit").orElseThrow(),
        READ_AS_JSON = linker.downcallHandle(  
    }  
    }  
            );  
                ValueLayout.JAVA_LONG,                        // sort_in_memory_threshold_bytes
                ValueLayout.ADDRESS,
            FunctionDescriptor.of(
    private static volatile LongSupplier overCommitDecider;
    private static final MethodHandle CREATE_WRITER;
            var versionOut = call.intOut();
            long permLen = sortPermLenOut.get(ValueLayout.JAVA_LONG, 0);
    }  
            long[] out = new long[ParquetNativeRuntimeStats.FIELD_COUNT];
                nativeSettings.getRowGroupMaxBytes() != null ? nativeSettings.getRowGroupMaxBytes() : -1L,
            FunctionDescriptor.of(  
     */
                typeCompressions.keys().lens(),  
        String[] keys = map.keySet().toArray(new String[0]);  
                liveBitsCount = 0L;  
                typeBfNdv.values(),  
    private record BoolMapArrays(NativeCall.StrArray keys, MemorySegment values) {
                ValueLayout.JAVA_LONG,  // output_writer_generation
                ValueLayout.ADDRESS,
import java.lang.foreign.ValueLayout;
                ValueLayout.JAVA_LONG,   // index_name  
            var outMappingLen = call.longOut();
                ValueLayout.ADDRESS,
        SET_MERGE_POOL_LIMIT = linker.downcallHandle(
        String[] values = new String[keys.length];
     */
                fieldCompressions.keys().ptrs(),
    }  
                typeBfEnabled.keys().lens(),  
    private static RowIdMapping readAndFreeMergeResult(  
    ) {
                for (String field : lcFields) {
            return buf.toArray(ValueLayout.JAVA_LONG);  
                sorts.count(),
                ValueLayout.ADDRESS,
    /** Delegate that decides whether a full native pool may over-commit; set by the owning plugin. */  
        return new DoubleMapArrays(call.strArray(keys), seg);
    public static void registerOverCommitCallbacks(LongSupplier decide, LongConsumer release) {  
                (long) sortConfig.reverseSorts().size(),
    private static final MethodHandle GET_POOL_STATS;
    private static java.lang.foreign.MemorySegment marshalBoolList(NativeCall call, List<Boolean> bools) {  
        if (hasLiveDocs && liveBitsPerInput.length != paths.length) {
        LongSupplier d = overCommitDecider;
    }
            return new MergeFilesResult(rowIdMapping, metadata, flushChunkCount, flushChunkTimeMillis, rowIdMappingMax);  
            }
                ValueLayout.JAVA_LONG,   // field_compression_name_ptrs, field_compression_name_lens, field_compression_value_ptrs,
                                         // field_compression_value_lens, field_compression_count
            // Live-docs per input (parallel arrays of pointer+length). Null or empty ⇒ skip filter.  
                ValueLayout.ADDRESS,    // out_gen_count
        );
            var outLen = call.longOut();
            }
            lib.find("parquet_get_file_metadata").orElseThrow(),  
                ValueLayout.ADDRESS,  
                sizeMap.put(genKeys[i], genSizes[i]);  
import java.lang.foreign.FunctionDescriptor;
            var numRowsOut = call.longOut();
                ValueLayout.JAVA_LONG,                        // page_row_limit
                .reinterpret(genCount * ValueLayout.JAVA_INT.byteSize())
                f.len(),
                }
                outGenSizesPtr,
            var idx = call.str(indexName);  
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_LONG,
            );
                liveBitsLens = call.buf(paths.length * Long.BYTES);  
        }  
        long genCount = outGenCount.get(ValueLayout.JAVA_LONG, 0);
                outFlushChunkCount,
                ValueLayout.JAVA_LONG,                        // bloom_filter_enabled
            call.invokeIO(
        ON_SETTINGS_UPDATE = linker.downcallHandle(
        try (var call = new NativeCall()) {
            return new PackedRowIdMapping(mappingArray, offsetMap, sizeMap);  
                ValueLayout.JAVA_LONG,                        // row_group_max_bytes  
                sortPermPtrOut,  
     * @param decide  returns a nonzero grant token to over-commit, or 0 to reject  
    /** Delegate that releases a previously granted over-commit; set by the owning plugin. */
     * {@code FixedBitSet#getBits()} layout (bit 0 = row 0 alive). A {@code null} entry, or
                schemaAddress,
                }
        }
            var nullsFirstArray = marshalBoolList(call, sortConfig.nullsFirst());  
                        liveBitsLens.setAtIndex(ValueLayout.JAVA_LONG, i, 0L);
            lib.find("parquet_get_filtered_native_bytes_used").orElseThrow(),
                    ? new String(out.data().asSlice(0, createdByLen).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8)  
    public static void onSettingsUpdate(NativeSettings nativeSettings) throws IOException {  
                .reinterpret(genCount * ValueLayout.JAVA_LONG.byteSize())
                ValueLayout.JAVA_LONG,                        // row_group_max_rows
        MemorySegment outMappingPtr,
                                         // type_compression_value_lens, type_compression_count
                ValueLayout.JAVA_LONG,
import java.lang.foreign.Linker;
        );
 * compatible open source license.
        try (var call = new NativeCall()) {  
     * Used by the shard close / going-red flow so a writer stranded by a failed operation does not
                nativeSettings.getMergeIoThreads() != null ? (long) nativeSettings.getMergeIoThreads() : -1L,
            call.invoke(REMOVE_SETTINGS, idx.segment(), idx.len());  
        CREATE_WRITER = linker.downcallHandle(
                outGenCount,  
                ValueLayout.JAVA_LONG,                        // merge_rayon_threads
    private static MapArrays toNativeArrays(NativeCall call, Map<String, String> map) {
            for (int i = 0; i < (int) genCount; i++) {
                ValueLayout.ADDRESS,
            var idx = call.str(indexName);
                0
            lib.find("parquet_finalize_writer").orElseThrow(),
    }
            var buf = call.buf(6 * 8);
        MemorySegment outGenCount  
                outFlushChunkTimeMillis,
            var outLen = call.longOut();
        COLLECT_RUNTIME_METRICS = linker.downcallHandle(  
            var out = call.str(outputFile);  
                    : null,
                ValueLayout.ADDRESS,                           // sort_perm_ptr_out
            var outFlushChunkCount = call.longOut();
        return new BoolMapArrays(call.strArray(keys), seg);
            long[] genKeys = MemorySegment.ofAddress(genKeysAddr)
    }
            var f = call.str(file);
                    : null,  
            final MemorySegment liveBitsLens;
            NativeCall.invokeVoid(REGISTER_OVERCOMMIT_CALLBACKS, decideStub, releaseStub);  
        for (int i = 0; i < bools.size(); i++) {
    }  
    private static final MethodHandle FREE_ROW_ID_MAPPING;
                outRowIdMappingMax,  
            long rowIdMappingMax = outRowIdMappingMax.get(ValueLayout.JAVA_LONG, 0);
                ValueLayout.JAVA_LONG,   // nulls_first (vals, count)
                nativeSettings.getSortInMemoryThresholdBytes() != null ? nativeSettings.getSortInMemoryThresholdBytes() : -1L,
    private record LongMapArrays(NativeCall.StrArray keys, MemorySegment values) {
                f.segment(),
            return new ParquetFileMetadata(
                ValueLayout.JAVA_LONG,  
import java.io.IOException;
            long permAddr = sortPermPtrOut.get(ValueLayout.JAVA_LONG, 0);
                ValueLayout.JAVA_LONG,   // file  
            int[] genSizes = MemorySegment.ofAddress(genSizesAddr)
        try (var call = new NativeCall()) {
    static void write(String file, long arrayAddress, long schemaAddress) throws IOException {
            var ct = nativeSettings.getCompressionType() != null ? call.str(nativeSettings.getCompressionType()) : null;  
                ValueLayout.JAVA_LONG,  
     * order documented in {@link org.opensearch.parquet.stats.ParquetNativeRuntimeStats#fromArray}.
                inputs.lens(),  
                ValueLayout.JAVA_LONG,  
        return new LongMapArrays(call.strArray(keys), seg);
                ValueLayout.JAVA_LONG     // out_len
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)  
                ValueLayout.JAVA_LONG,   // reverse_sorts (vals, count)
                outMappingLen,
                ValueLayout.ADDRESS,
    }
                (int) numRowGroupsOut.get(ValueLayout.JAVA_LONG, 0)  
                f.len(),
                (long) out.capacity(),
     */
        GET_FILTERED_BYTES = linker.downcallHandle(
                typeBfFpp.keys().ptrs(),  
                ValueLayout.ADDRESS,
                bfEnabled.keys().ptrs(),
                ValueLayout.ADDRESS,  
                nativeSettings.getPageSizeBytes() != null ? nativeSettings.getPageSizeBytes() : -1L,
            return java.lang.foreign.MemorySegment.NULL;
                versionOut,  
            );
    public static void initLogger() {}  
                ValueLayout.ADDRESS,  
                ValueLayout.JAVA_LONG,  // output file
        } catch (Throwable t) {
            var maxSortModesArray = marshalBoolList(call, sortConfig.maxSortModes());
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
        CLEANUP_WRITER = linker.downcallHandle(
    static {
    private record MapArrays(NativeCall.StrArray keys, NativeCall.StrArray values) {
            FunctionDescriptor.of(
    }
                ValueLayout.JAVA_LONG,   // index_name
                out[i] = buf.getAtIndex(ValueLayout.JAVA_LONG, i);  
        String[] keys = map.keySet().toArray(new String[0]);  
                versionOut,
            )
            lib.find("parquet_collect_runtime_metrics").orElseThrow(),
        );
            RowIdMapping rowIdMapping = readAndFreeMergeResult(
    private RustBridge() {}  
                    effectiveFieldBfEnabled.putIfAbsent(field, Boolean.TRUE);  
                ValueLayout.ADDRESS,  
                writerGeneration  
                f.segment(),
                versionOut.get(ValueLayout.JAVA_INT, 0),  
     */
            FunctionDescriptor.of(
                typeCompressions.values().ptrs(),
                out.len(),  
    public static void initMemoryPools(long writeLimit, long mergeLimit) {
            if (permAddr != 0 && permLen > 0) {
            )  
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_LONG,                        // page_size_bytes
import java.util.HashMap;
        var seg = call.buf(bools.size() * 8);
                ValueLayout.ADDRESS
                MERGE_FILES,
                ValueLayout.ADDRESS,
                createdByLen >= 0
                reverseArray,  
        }  
                ValueLayout.ADDRESS,    // crc32_out
     * Returns a long array of {@link ParquetNativeRuntimeStats#FIELD_COUNT} elements in the  
        }
    private record DoubleMapArrays(NativeCall.StrArray keys, MemorySegment values) {
            )
            MemorySegment decideStub = linker.upcallStub(decideHandle, FunctionDescriptor.of(ValueLayout.JAVA_LONG), arena);
    private static final MethodHandle MERGE_FILES;
            MemorySegment releaseStub = linker.upcallStub(releaseHandle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG), arena);
                ValueLayout.ADDRESS,
     */
    public static long getFilteredNativeBytesUsed(String pathPrefix) {
                (long) out.capacity(),  
                ValueLayout.JAVA_LONG,  // input files (ptrs, lens, count)
        WRITE = linker.downcallHandle(
            );  
                ValueLayout.JAVA_LONG,   // buf_capacity
    private static BoolMapArrays toBoolMapArrays(NativeCall call, Map<String, Boolean> map) {
            )  
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,    // out_flush_and_sort_chunk_count
            } else {  
import java.nio.charset.StandardCharsets;  
     * @param release invoked with the grant token to release a previously granted over-commit
            var f = call.str(file);
            var out = call.outBuffer(8192);  
                ValueLayout.JAVA_LONG,   // bf_enabled_name_ptrs, bf_enabled_name_lens, bf_enabled_vals, bf_enabled_count  
                ON_SETTINGS_UPDATE,
            var numRowGroupsOut = call.longOut();  
    }
            long flushChunkCount = outFlushChunkCount.get(ValueLayout.JAVA_LONG, 0);
            Map<Long, Integer> offsetMap = new HashMap<>((int) genCount);
    /** C-ABI trampoline invoked from Rust: returns a nonzero grant token, or 0 to reject. */
                ValueLayout.ADDRESS,    // created_by_buf
            RowIdMapping rowIdMapping = null;  
                ValueLayout.ADDRESS,
        }
                idx.len(),
                                         // type_encoding_value_lens, type_encoding_count
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS)
    private static final MethodHandle REGISTER_OVERCOMMIT_CALLBACKS;
import java.lang.foreign.SymbolLookup;
        try (var call = new NativeCall()) {  
    }
                ValueLayout.ADDRESS,  
 *
        } finally {
            lib.find("parquet_get_pool_stats").orElseThrow(),  
        REGISTER_OVERCOMMIT_CALLBACKS = linker.downcallHandle(  
            var reverseArray = marshalBoolList(call, sortConfig.reverseSorts());
            FunctionDescriptor.ofVoid(  
    /**  
                ValueLayout.ADDRESS,  
                ValueLayout.ADDRESS,
        throws IOException {  
                bfEnabled.values(),  
                    : null,
        );
                createdByLen >= 0
            var bfEnabled = toBoolMapArrays(call, effectiveFieldBfEnabled);
        for (int i = 0; i < keys.length; i++) {
    private static final MethodHandle GET_COLUMN_METADATA;
            var f = call.str(file);
    }  
        }  
     * passing {@code null} / zero-length outer array, disables filtering (zero-copy fast path).</p>  
    public static void setMergePoolLimit(long newLimit) {
                ValueLayout.JAVA_LONG,   // type_compression_name_ptrs, type_compression_name_lens, type_compression_value_ptrs,
                ValueLayout.JAVA_LONG,
                typeBfEnabled.values(),
                ValueLayout.ADDRESS                            // sort_perm_len_out
                RustBridge.class,  
                ValueLayout.ADDRESS,    // out_flush_and_sort_chunk_time_millis  
        }
    }
                }  
                liveBitsCount  
            call.invokeIO(COLLECT_RUNTIME_METRICS, buf, (long) ParquetNativeRuntimeStats.FIELD_COUNT);  
                ValueLayout.ADDRESS,  
            Arena arena = Arena.global();
            var numRowsOut = call.longOut();
        }  
     * Result of finalizing a writer: metadata + optional row ID mapping.
                out.data(),
        }
    private static final MethodHandle REMOVE_SETTINGS;
        NativeCall.invokeVoid(SET_MERGE_POOL_LIMIT, newLimit);
                ValueLayout.ADDRESS,
        }
    private static final MethodHandle ON_SETTINGS_UPDATE;  
        );  
                for (int i = 0; i < paths.length; i++) {
                outGenKeysPtr,  
                ValueLayout.ADDRESS,
            )
                liveBitsLens,
            throw new IllegalStateException("Failed to register over-commit callbacks", t);
 * FFM bridge to the native Rust parquet writer library.
                (long) createdByOut.capacity(),
        }
                ValueLayout.JAVA_LONG,                        // compression_level  
            int createdByLen = (int) createdByOut.lenOut().get(ValueLayout.JAVA_LONG, 0);  
                ValueLayout.ADDRESS      // out_len
package org.opensearch.parquet.bridge;
            int createdByLen = out.actualLength();
            FunctionDescriptor.ofVoid(
            );
            )
    }  
                crc32Out.get(ValueLayout.JAVA_LONG, 0),
 * The OpenSearch Contributors require contributions made to  
                versionOut.get(ValueLayout.JAVA_INT, 0),  
                ValueLayout.JAVA_LONG,  // created_by_buf_len
        for (int i = 0; i < keys.length; i++) {
                ValueLayout.ADDRESS,  
                } finally {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
                outMappingPtr,
            var outBuf = call.buf(bufSize);  
                numRowsOut.get(ValueLayout.JAVA_LONG, 0),  
            lib.find("parquet_cleanup_writer").orElseThrow(),  
        );
            )
    }
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS)
        );
                typeEncodings.values().ptrs(),
                ValueLayout.JAVA_LONG    // writer_generation
                "overCommitRelease",
                numRowGroupsOut,
            call.invokeIO(GET_COLUMN_METADATA, f.segment(), f.len(), out.data(), (long) out.capacity(), outLen);
    /**  
                ValueLayout.ADDRESS,  
            seg.setAtIndex(ValueLayout.JAVA_LONG, i, map.get(keys[i]) ? 1L : 0L);  
            long flushChunkTimeMillis = outFlushChunkTimeMillis.get(ValueLayout.JAVA_LONG, 0);  
            int bufSize = 10 * 1024 * 1024; // 10MB
    }
                fieldEncodings.keys().ptrs(),
                typeBfFpp.keys().lens(),
        );  
            lib.find("parquet_read_as_json").orElseThrow(),
        try {  
            );
                ValueLayout.ADDRESS,  
import java.util.function.LongConsumer;  
                ValueLayout.ADDRESS,
    /**
                    ? new String(out.data().asSlice(0, createdByLen).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8)  
                ValueLayout.JAVA_LONG,
        );
        } catch (Throwable ignore) {
            return call.invoke(GET_FILTERED_BYTES, p.segment(), p.len());
 * this file be licensed under the Apache-2.0 license or a
        if (bools == null || bools.isEmpty()) {
                liveBitsPtrs = call.buf(paths.length * (int) ValueLayout.ADDRESS.byteSize());
                bfEnabled.keys().count(),
    }
    }  
                idx.len(),
                ValueLayout.JAVA_LONG,   // field_name_ptrs, field_name_lens, field_encoding_ptrs, field_encoding_lens, field_count
        long outputWriterGeneration
    private static final MethodHandle SET_WRITE_POOL_LIMIT;
            ParquetFileMetadata metadata = new ParquetFileMetadata(
                out.lenOut(),
                    rowIdMapping = new PackedRowIdMapping(mappingArray, true);  
            var numRowsOut = call.longOut();
        );
                ValueLayout.ADDRESS,    // version_out
                typeBfEnabled.keys().count(),
    // ─── Over-commit decision upcall (decision executes in the Java allocator) ───────────────────
                ValueLayout.ADDRESS,
            throw new UncheckedIOException("Native merge failed", e);
    }
                fieldCompressions.keys().lens(),
                ValueLayout.ADDRESS,  
    /** C-ABI trampoline invoked from Rust: releases the over-commit permit identified by {@code token}. */  
                .toArray(ValueLayout.JAVA_INT);  
            lib.find("parquet_on_settings_update").orElseThrow(),
            throw new IllegalArgumentException(  
                ValueLayout.ADDRESS,  
        }
            );
                "liveBitsPerInput length (" + liveBitsPerInput.length + ") must match inputFiles (" + paths.length + ")"
        for (int i = 0; i < keys.length; i++) {
        var seg = keys.length > 0 ? call.buf(keys.length * 8) : MemorySegment.NULL;
import java.util.List;  
            if (hasLiveDocs) {
                numRowsOut,
                createdByLen >= 0
     * Stubs are bound to the global arena (JVM lifetime).
     * Registers the over-commit decision/release delegates and installs FFM upcall stubs into the
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,  
        }
    }
     *
        try {
                ValueLayout.JAVA_LONG,
                versionOut,
                fieldCompressions.values().ptrs(),  
    /**  
            var typeCompressions = toNativeArrays(call, nativeSettings.getTypeCompressions());
                numRowGroupsOut
            var fieldCompressions = toNativeArrays(call, nativeSettings.getFieldCompressions());  
                ValueLayout.JAVA_LONG,  // mapping_len
                fieldEncodings.keys().count(),  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            // Explicit fieldBloomFilterEnabled entries take precedence; low_cardinality fields get implicit bloom=true.
            var buf = call.buf(ParquetNativeRuntimeStats.FIELD_COUNT * 8);
                    long[] mappingArray = MemorySegment.ofAddress(permAddr)  
            lib.find("parquet_remove_settings").orElseThrow(),
        long mappingLen = outMappingLen.get(ValueLayout.JAVA_LONG, 0);  
            )
            var outGenOffsetsPtr = call.longOut();
                typeBfNdv.keys().lens(),
            lib.find("parquet_init_memory_pools").orElseThrow(),  
        );  
            Linker linker = Linker.nativeLinker();
            lib.find("parquet_register_overcommit_callbacks").orElseThrow(),
                effectiveFieldBfEnabled = nativeSettings.getFieldBloomFilterEnabled();
    }
                ValueLayout.ADDRESS,                           // num_row_groups_out  
        );
        boolean hasLiveDocs = liveBitsPerInput != null && liveBitsPerInput.length > 0;
                ValueLayout.ADDRESS,  
        NativeCall.invokeVoid(SET_WRITE_POOL_LIMIT, newLimit);
                ValueLayout.ADDRESS,
            call.invokeIO(
    private static LongMapArrays toLongMapArrays(NativeCall call, Map<String, Long> map) {
                ValueLayout.JAVA_LONG,   // file
        GET_COLUMN_METADATA = linker.downcallHandle(
        String[] keys = map.keySet().toArray(new String[0]);  
                ValueLayout.ADDRESS,
    private static final MethodHandle SET_MERGE_POOL_LIMIT;  
                ValueLayout.ADDRESS,
                liveBitsLens = MemorySegment.NULL;
                ValueLayout.ADDRESS,
    private static final MethodHandle COLLECT_RUNTIME_METRICS;  
        String indexName,  
            var typeBfNdv = toLongMapArrays(call, nativeSettings.getTypeBloomFilterNdv());
            // Out-pointers for Parquet file metadata  
    }  
            return d != null ? d.getAsLong() : 0L;  
        MemorySegment outMappingLen,
                ValueLayout.JAVA_LONG,
        } catch (Throwable t) {
                ValueLayout.ADDRESS,  
                FINALIZE_WRITER,
                sorts.ptrs(),  
                out.data(),
                fieldEncodings.values().ptrs(),
                (long) sortConfig.maxSortModes().size(),
        try {  
        try (var call = new NativeCall()) {
                outMappingLen,
                idx.segment(),  
        }  
