     * decision itself runs in {@code decide}/{@code release}; this method only wires the plumbing.
                ValueLayout.ADDRESS,
            var numRowsOut = call.longOut();
                numRowsOut,
                inputs.ptrs(),
    // ─── Over-commit decision upcall (decision executes in the Java allocator) ───────────────────
 * compatible open source license.
                typeBfEnabled.values(),
    private static java.lang.foreign.MemorySegment marshalBoolList(NativeCall call, List<Boolean> bools) {
                ValueLayout.JAVA_LONG,
                typeBfNdv.keys().ptrs(),
        if (hasLiveDocs && liveBitsPerInput.length != paths.length) {
    private static volatile LongConsumer overCommitReleaser;
            var numRowsOut = call.longOut();
    private static final MethodHandle ON_SETTINGS_UPDATE;
        try (var call = new NativeCall()) {
                typeBfNdv.keys().lens(),
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,    // out_gen_keys_ptr
                        .toArray(ValueLayout.JAVA_LONG);
            FunctionDescriptor.of(
                .toArray(ValueLayout.JAVA_LONG);
                ValueLayout.ADDRESS,
    public static String readAsJson(String file) throws IOException {
            FunctionDescriptor.of(
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,    // version_out
            lib.find("parquet_register_overcommit_callbacks").orElseThrow(),
            ParquetFileMetadata metadata = new ParquetFileMetadata(
                ValueLayout.ADDRESS,      // out_buf
                numRowsOut.get(ValueLayout.JAVA_LONG, 0),
            Map<Long, Integer> offsetMap = new HashMap<>((int) genCount);
                ValueLayout.ADDRESS,
     */
                ValueLayout.JAVA_LONG,    // return value
        String[] values = new String[keys.length];
            lib.find("parquet_get_filtered_native_bytes_used").orElseThrow(),
    }
            if (r != null) {
        FREE_MERGE_RESULT = linker.downcallHandle(
    }
        throws IOException {
     * Used by the shard close / going-red flow so a writer stranded by a failed operation does not
        }
                ValueLayout.ADDRESS,
    }
                    effectiveFieldBfEnabled.putIfAbsent(field, Boolean.TRUE);
        MemorySegment outMappingPtr,
            var outRowIdMappingMax = call.longOut();
                versionOut,
    public static long getFilteredNativeBytesUsed(String pathPrefix) {
        );
    private static MapArrays toNativeArrays(NativeCall call, Map<String, String> map) {
    }
    }
                crc32Out.get(ValueLayout.JAVA_LONG, 0),
                ValueLayout.JAVA_LONG,                         // mapping_ptr
    /** C-ABI trampoline invoked from Rust: releases the over-commit permit identified by {@code token}. */
            FunctionDescriptor.ofVoid(
                (int) numRowGroupsOut.get(ValueLayout.JAVA_LONG, 0)
            if (lcFields.isEmpty()) {
                ValueLayout.JAVA_LONG,
        );
     * Format: {"column_name": {"encodings": ["PLAIN", "RLE_DICTIONARY"], "compression": "LZ4_RAW"}, ...}
        REMOVE_SETTINGS = linker.downcallHandle(
     * Returns a JSON string with per-column encoding and compression metadata from the first row group.
                versionOut.get(ValueLayout.JAVA_INT, 0),
import java.lang.foreign.MemorySegment;
        try (var call = new NativeCall()) {
    }
        SET_MERGE_POOL_LIMIT = linker.downcallHandle(
                idx.segment(),
                ValueLayout.JAVA_LONG,                        // bloom_filter_ndv
                ValueLayout.JAVA_LONG,   // reverse_sorts (vals, count)
            int len = (int) outLen.get(ValueLayout.JAVA_LONG, 0);
        Linker linker = Linker.nativeLinker();
        try (var call = new NativeCall()) {
}
            var typeCompressions = toNativeArrays(call, nativeSettings.getTypeCompressions());
            lib.find("parquet_init_memory_pools").orElseThrow(),
        overCommitReleaser = release;
                fieldEncodings.keys().lens(),
    public static ParquetFileMetadata getFileMetadata(String file) throws IOException {
                idx.len(),
                (long) out.capacity(),
            var crc32Out = call.longOut();
            // Out-pointers for per-merge stats forwarded to the per-shard tracker.
                nativeSettings.getSortInMemoryThresholdBytes() != null ? nativeSettings.getSortInMemoryThresholdBytes() : -1L,
        overCommitDecider = decide;
            return d != null ? d.getAsLong() : 0L;
            var versionOut = call.intOut();
                    : null,
            Map<Long, Integer> sizeMap = new HashMap<>((int) genCount);
                "overCommitRelease",
        for (int i = 0; i < keys.length; i++) {
            )
                ValueLayout.ADDRESS,                           // sort_perm_ptr_out
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS)
     * Stubs are bound to the global arena (JVM lifetime).
            FunctionDescriptor.of(
                f.segment(),
            if (rc == 1) return null;
            call.invokeIO(COLLECT_RUNTIME_METRICS, buf, (long) ParquetNativeRuntimeStats.FIELD_COUNT);
                ValueLayout.JAVA_LONG,                        // merge_io_threads
            lib.find("parquet_merge_files").orElseThrow(),
            FunctionDescriptor.of(
                out[i] = buf.getAtIndex(ValueLayout.JAVA_LONG, i);
                ValueLayout.ADDRESS,
                nullsFirstArray,
    public static MergeFilesResult mergeParquetFilesInRust(
            var numRowGroupsOut = call.longOut();
    private static final MethodHandle GET_POOL_STATS;
            );
            var createdByOut = call.outBuffer(1024);
                for (String field : lcFields) {
        );
                liveBitsLens = call.buf(paths.length * Long.BYTES);
                ValueLayout.JAVA_LONG,
                    long[] bits = liveBitsPerInput[i];
            var outMappingPtr = call.longOut();
            RowIdMapping rowIdMapping = readAndFreeMergeResult(
        long genSizesAddr = outGenSizesPtr.get(ValueLayout.JAVA_LONG, 0);
     */
        GET_FILTERED_BYTES = linker.downcallHandle(
                ValueLayout.ADDRESS,
     * Returns a long array of {@link ParquetNativeRuntimeStats#FIELD_COUNT} elements in the
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
                sortPermPtrOut,
                f.len(),
            lib.find("parquet_get_file_metadata").orElseThrow(),
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,  // gen_offsets_ptr
            var outFlushChunkCount = call.longOut();
                typeBfEnabled.keys().count(),
                ValueLayout.ADDRESS,
                (long) sortConfig.nullsFirst().size(),
                                         // field_compression_value_lens, field_compression_count
                typeBfEnabled.keys().ptrs(),
                bfEnabled.keys().lens(),
            } else {
            return new ParquetFileMetadata(
            var reverseArray = marshalBoolList(call, sortConfig.reverseSorts());
                (long) sortConfig.maxSortModes().size(),
        try (var call = new NativeCall()) {
        }
            lib.find("parquet_read_as_json").orElseThrow(),
            var f = call.str(file);
                ValueLayout.JAVA_LONG,  // mapping_ptr
        } catch (IOException e) {
 * The OpenSearch Contributors require contributions made to
    private static final MethodHandle FREE_ROW_ID_MAPPING;
        }
        CLEANUP_WRITER = linker.downcallHandle(
        MemorySegment outMappingLen,
     */
            lib.find("parquet_set_merge_pool_limit").orElseThrow(),
                liveBitsPtrs = MemorySegment.NULL;
        FREE_ROW_ID_MAPPING = linker.downcallHandle(
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,   // index_name
            lib.find("parquet_write").orElseThrow(),
     * @param release invoked with the grant token to release a previously granted over-commit
        }
                idx.len(),
            var outGenKeysPtr = call.longOut();
                outFlushChunkTimeMillis,
                fieldCompressions.keys().lens(),
    private static final MethodHandle REGISTER_OVERCOMMIT_CALLBACKS;
                createdByOut.lenOut(),
                createdByLen >= 0
            );
            Map<String, Boolean> effectiveFieldBfEnabled;
        var seg = keys.length > 0 ? call.buf(keys.length * 8) : MemorySegment.NULL;
                fieldCompressions.values().ptrs(),
            final MemorySegment liveBitsPtrs;
                nativeSettings.getMergeIoThreads() != null ? (long) nativeSettings.getMergeIoThreads() : -1L,
            var versionOut = call.intOut();
        LongSupplier d = overCommitDecider;
                createdByOut.data(),
        String[] keys = map.keySet().toArray(new String[0]);
    private static long overCommitDecide() {
                versionOut,
                                         // type_bf_enabled_count
                ValueLayout.JAVA_LONG   // live-docs count (0 = all alive)
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
            throw new UncheckedIOException("Native merge failed", e);
                (int) numRowGroupsOut.get(ValueLayout.JAVA_LONG, 0)
        ON_SETTINGS_UPDATE = linker.downcallHandle(
                    } else {
        String[] paths = inputFiles.stream().map(Path::toString).toArray(String[]::new);
                typeCompressions.keys().ptrs(),
    /**
        NativeCall.invokeVoid(SET_MERGE_POOL_LIMIT, newLimit);
import org.opensearch.index.engine.dataformat.RowIdMapping;
            return new MergeFilesResult(rowIdMapping, metadata, flushChunkCount, flushChunkTimeMillis, rowIdMappingMax);
            call.invokeIO(
        } catch (IOException e) {
        }
        REGISTER_OVERCOMMIT_CALLBACKS = linker.downcallHandle(
            if (permAddr != 0 && permLen > 0) {
            long[] genKeys = MemorySegment.ofAddress(genKeysAddr)
import java.lang.invoke.MethodType;
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,
import java.lang.foreign.FunctionDescriptor;
            var typeEncodings = toNativeArrays(call, nativeSettings.getTypeEncodings());
    }
            );
            return out;
                ValueLayout.JAVA_LONG,  // mapping_len
    private record DoubleMapArrays(NativeCall.StrArray keys, MemorySegment values) {
     * native library so a full native pool can consult the (Java allocator-owned) decision. The
                        liveBitsLens.setAtIndex(ValueLayout.JAVA_LONG, i, 0L);
            return call.invoke(GET_FILTERED_BYTES, p.segment(), p.len());
                .reinterpret(mappingLen * ValueLayout.JAVA_LONG.byteSize())
 */
    private static RowIdMapping readAndFreeMergeResult(
            FunctionDescriptor.of(
        return new LongMapArrays(call.strArray(keys), seg);
     * order documented in {@link org.opensearch.parquet.stats.ParquetNativeRuntimeStats#fromArray}.
                crc32Out,
import java.util.HashMap;
    private static final MethodHandle GET_FILE_METADATA;
                ValueLayout.JAVA_LONG
                sizeMap.put(genKeys[i], genSizes[i]);
                ValueLayout.JAVA_LONG                          // mapping_len
     * passing {@code null} / zero-length outer array, disables filtering (zero-copy fast path).</p>
                maxSortModesArray,
    private static LongMapArrays toLongMapArrays(NativeCall call, Map<String, Long> map) {
                ValueLayout.JAVA_LONG,
        List<Path> inputFiles,
            }
                ValueLayout.JAVA_LONG,   // type_bf_fpp_name_ptrs, type_bf_fpp_name_lens, type_bf_fpp_vals, type_bf_fpp_count
    }
            call.invokeIO(
                ValueLayout.JAVA_LONG,
                schemaAddress,
                ValueLayout.ADDRESS,
                numRowGroupsOut
                ValueLayout.JAVA_LONG,   // field_name_ptrs, field_name_lens, field_encoding_ptrs, field_encoding_lens, field_count
        MemorySegment outGenSizesPtr,
            final long liveBitsCount;
    private static final MethodHandle SET_MERGE_POOL_LIMIT;
            var out = call.outBuffer(1024);
            )
            // Live-docs per input (parallel arrays of pointer+length). Null or empty ⇒ skip filter.
                ValueLayout.ADDRESS,
            lib.find("parquet_free_merge_result").orElseThrow(),
     */
     */
                (long) createdByOut.capacity(),
     */
                out.data(),
        }
                FINALIZE_WRITER,
    private static final MethodHandle COLLECT_RUNTIME_METRICS;
                .toArray(ValueLayout.JAVA_INT);
            var typeBfFpp = toDoubleMapArrays(call, nativeSettings.getTypeBloomFilterFpp());
                idx.len(),
import java.nio.charset.StandardCharsets;
            lib.find("parquet_remove_settings").orElseThrow(),
    static WriterFinalizeResult finalizeWriter(String file) throws IOException {
                fieldEncodings.values().ptrs(),
                ValueLayout.JAVA_LONG,  // output_writer_generation
    }
                ValueLayout.JAVA_LONG,  // index_name
                ValueLayout.ADDRESS,
            return 0L; // never let an exception cross the native boundary
                liveBitsPtrs = call.buf(paths.length * (int) ValueLayout.ADDRESS.byteSize());
        long genKeysAddr = outGenKeysPtr.get(ValueLayout.JAVA_LONG, 0);
                typeCompressions.values().ptrs(),
            MemorySegment decideStub = linker.upcallStub(decideHandle, FunctionDescriptor.of(ValueLayout.JAVA_LONG), arena);
     * survive as a stale entry and block recovery's re-create for the same file.
    public static String getColumnMetadata(String file) throws IOException {
                ValueLayout.JAVA_LONG,   // file
                idx.segment(),
                effectiveFieldBfEnabled = new HashMap<>(nativeSettings.getFieldBloomFilterEnabled());
                ValueLayout.JAVA_LONG,                        // merge_batch_size
                nativeSettings.getRowGroupMaxRows() != null ? (long) nativeSettings.getRowGroupMaxRows() : -1L,
                ValueLayout.JAVA_LONG,   // buf_capacity
                ValueLayout.ADDRESS,    // live-docs lens
        try (var call = new NativeCall()) {
    private static final MethodHandle GET_COLUMN_METADATA;
            RowIdMapping rowIdMapping = null;
        );
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
                        liveBitsLens.setAtIndex(ValueLayout.JAVA_LONG, i, (long) bits.length);
    }
    }
            return new PackedRowIdMapping(mappingArray, offsetMap, sizeMap);
                ValueLayout.ADDRESS,
     * Result of finalizing a writer: metadata + optional row ID mapping.
                ValueLayout.JAVA_LONG,   // index_name
import java.util.Set;
        try {
 * FFM bridge to the native Rust parquet writer library.
            return buf.toArray(ValueLayout.JAVA_LONG);
            return new WriterFinalizeResult(metadata, rowIdMapping);
                .reinterpret(genCount * ValueLayout.JAVA_INT.byteSize())
                outFlushChunkCount,
                ValueLayout.JAVA_LONG,  // gen_keys_ptr
                typeBfFpp.values(),
        );
        COLLECT_RUNTIME_METRICS = linker.downcallHandle(
                }
    private static final MethodHandle CREATE_WRITER;
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        );
                    NativeCall.invokeVoid(FREE_ROW_ID_MAPPING, permAddr, permLen);
    }
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_LONG    // type_bf_ndv_name_ptrs, type_bf_ndv_name_lens, type_bf_ndv_vals, type_bf_ndv_count
            long[] mappingArray = MemorySegment.ofAddress(mappingAddr)
            var maxSortModesArray = marshalBoolList(call, sortConfig.maxSortModes());
                }
                ValueLayout.JAVA_LONG,                        // page_row_limit
            FunctionDescriptor.of(
        );
                ValueLayout.ADDRESS,
package org.opensearch.parquet.bridge;
                ct != null ? ct.len() : -1L,
        );
                ValueLayout.ADDRESS,    // out_mapping_ptr
        LongConsumer r = overCommitReleaser;
        var seg = call.buf(bools.size() * 8);
                nativeSettings.getBloomFilterNdv() != null ? nativeSettings.getBloomFilterNdv() : -1L,
                outGenOffsetsPtr,
        }
        try {
        return new BoolMapArrays(call.strArray(keys), seg);
            var outLen = call.longOut();
                liveBitsLens = MemorySegment.NULL;
                offsetMap.put(genKeys[i], genOffsets[i]);
            lib.find("parquet_cleanup_writer").orElseThrow(),
    }
            call.invokeIO(
                ValueLayout.ADDRESS,
                outputWriterGeneration,
                    rowIdMapping = new PackedRowIdMapping(mappingArray, true);
            NativeCall.invokeVoid(REGISTER_OVERCOMMIT_CALLBACKS, decideStub, releaseStub);
                ValueLayout.JAVA_DOUBLE,                      // bloom_filter_fpp
                ValueLayout.JAVA_LONG,   // max_sort_modes (vals, count)
                ValueLayout.JAVA_LONG   // gen_count
            var f = call.str(file);
    private static final MethodHandle FREE_MERGE_RESULT;
        );
    private static DoubleMapArrays toDoubleMapArrays(NativeCall call, Map<String, Double> map) {
    public static long[] collectRuntimeMetrics() {
                ValueLayout.JAVA_LONG,   // type_encoding_name_ptrs, type_encoding_name_lens, type_encoding_value_ptrs,
        boolean hasLiveDocs = liveBitsPerInput != null && liveBitsPerInput.length > 0;
import org.opensearch.nativebridge.spi.NativeCall;
    public static long[] getPoolStats() {
                        .reinterpret(permLen * ValueLayout.JAVA_LONG.byteSize())
    private static volatile LongSupplier overCommitDecider;
import java.lang.foreign.ValueLayout;
            FunctionDescriptor.ofVoid(
            var bfEnabled = toBoolMapArrays(call, effectiveFieldBfEnabled);
        INIT_MEMORY_POOLS = linker.downcallHandle(
    private static final MethodHandle FINALIZE_WRITER;
                ValueLayout.ADDRESS,
                        liveBitsPtrs.setAtIndex(ValueLayout.ADDRESS, i, MemorySegment.NULL);
            long permAddr = sortPermPtrOut.get(ValueLayout.JAVA_LONG, 0);
        for (int i = 0; i < keys.length; i++) {
 * SPDX-License-Identifier: Apache-2.0
            var numRowGroupsOut = call.longOut();
    private static final MethodHandle READ_AS_JSON;
                ValueLayout.ADDRESS,
            var outGenSizesPtr = call.longOut();
        for (int i = 0; i < keys.length; i++) {
     * {@code FixedBitSet#getBits()} layout (bit 0 = row 0 alive). A {@code null} entry, or
            var idx = call.str(indexName);
            for (int i = 0; i < (int) genCount; i++) {
            call.invokeIO(WRITE, f.segment(), f.len(), arrayAddress, schemaAddress);
                "liveBitsPerInput length (" + liveBitsPerInput.length + ") must match inputFiles (" + paths.length + ")"
                } finally {
            )
                versionOut.get(ValueLayout.JAVA_INT, 0),
        }
        MemorySegment outGenKeysPtr,
                bfEnabled.keys().ptrs(),
        SET_WRITE_POOL_LIMIT = linker.downcallHandle(
            var sortPermLenOut = call.longOut();
    private static final MethodHandle CLEANUP_WRITER;
            )
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            seg.setAtIndex(ValueLayout.JAVA_DOUBLE, i, map.get(keys[i]));
        } catch (Throwable ignore) {
            call.invokeIO(CLEANUP_WRITER, f.segment(), f.len());
                ValueLayout.ADDRESS,
        MERGE_FILES = linker.downcallHandle(
                ValueLayout.ADDRESS,
                fieldCompressions.values().lens(),
            Arena arena = Arena.global();
            // Out-pointers for Parquet file metadata
    public static void setMergePoolLimit(long newLimit) {
    /**
                reverseArray,
    public static void removeSettings(String indexName) {
            )
    }
                numRowsOut,
    }
                ValueLayout.JAVA_LONG,                        // row_group_max_bytes
                nativeSettings.getPageRowLimit() != null ? (long) nativeSettings.getPageRowLimit() : -1L,
                    : null,
                out.segment(),
                    ? new String(createdByOut.data().asSlice(0, createdByLen).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8)
                ValueLayout.JAVA_LONG,                        // schema_address
                ValueLayout.ADDRESS,
import java.lang.foreign.SymbolLookup;
        NativeCall.invokeVoid(SET_WRITE_POOL_LIMIT, newLimit);
                sortPermLenOut
                .toArray(ValueLayout.JAVA_LONG);
import java.util.function.LongSupplier;
        );
            lib.find("parquet_set_write_pool_limit").orElseThrow(),
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
            var sorts = call.strArray(sortConfig.sortColumns().toArray(new String[0]));
                typeEncodings.values().ptrs(),
                numRowsOut,
    record WriterFinalizeResult(ParquetFileMetadata metadata, RowIdMapping rowIdMapping) {
            long rc = call.invokeIO(
                ValueLayout.ADDRESS,
                nativeSettings.getMergeBatchSize() != null ? (long) nativeSettings.getMergeBatchSize() : -1L,
                MERGE_FILES,
    static {
                ValueLayout.ADDRESS,
                outGenOffsetsPtr,
            lib.find("parquet_collect_runtime_metrics").orElseThrow(),
    }
        GET_FILE_METADATA = linker.downcallHandle(
            var outMappingLen = call.longOut();
                ValueLayout.JAVA_LONG,   // field_compression_name_ptrs, field_compression_name_lens, field_compression_value_ptrs,
            )
                ValueLayout.ADDRESS      // out_len
                ValueLayout.ADDRESS,
import java.lang.foreign.Arena;
            int len = (int) outLen.get(ValueLayout.JAVA_LONG, 0);
                liveBitsLens,
            var inputs = call.strArray(paths);
                ValueLayout.ADDRESS,
                sorts.count(),
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
    }
            );
            throw new IllegalStateException("Failed to register over-commit callbacks", t);
                outGenSizesPtr,
                    ? new String(out.data().asSlice(0, createdByLen).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8)
                ValueLayout.ADDRESS,
        for (int i = 0; i < keys.length; i++) {
                nativeSettings.getDictSizeBytes() != null ? nativeSettings.getDictSizeBytes() : -1L,
            long rowIdMappingMax = outRowIdMappingMax.get(ValueLayout.JAVA_LONG, 0);
                ValueLayout.ADDRESS,    // num_rows_out
        }
        var seg = keys.length > 0 ? call.buf(keys.length * 8) : MemorySegment.NULL;
    private RustBridge() {}
import java.nio.file.Path;
            var ct = nativeSettings.getCompressionType() != null ? call.str(nativeSettings.getCompressionType()) : null;
    }
    /**
        String[] keys = map.keySet().toArray(new String[0]);
        CREATE_WRITER = linker.downcallHandle(
                nativeSettings.getBloomFilterFpp() != null ? nativeSettings.getBloomFilterFpp() : -1.0,
                outMappingPtr,
                outRowIdMappingMax,
            var out = call.str(outputFile);
            FunctionDescriptor.of(
/**
                ValueLayout.ADDRESS   // num_row_groups_out
                liveBitsCount = 0L;
                ValueLayout.JAVA_LONG,                        // dict_size_bytes
                typeCompressions.values().lens(),
            throw new java.io.UncheckedIOException("collectRuntimeMetrics failed", e);
                .reinterpret(genCount * ValueLayout.JAVA_LONG.byteSize())
        } finally {
                ValueLayout.JAVA_LONG,                        // merge_rayon_threads
        }
            MemorySegment releaseStub = linker.upcallStub(releaseHandle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG), arena);
                ValueLayout.ADDRESS,
                fieldEncodings.keys().ptrs(),
                ValueLayout.JAVA_LONG,
     *
                fieldCompressions.keys().ptrs(),
        MemorySegment outGenCount
                createdByLen >= 0
            );
            NativeCall.invokeVoid(FREE_MERGE_RESULT, mappingAddr, mappingLen, genKeysAddr, genOffsetsAddr, genSizesAddr, genCount);
                ValueLayout.ADDRESS,
                    if (bits == null || bits.length == 0) {
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_LONG,   // type_bf_enabled_name_ptrs, type_bf_enabled_name_lens, type_bf_enabled_vals,
                ValueLayout.ADDRESS,    // created_by_len_out
    private static final MethodHandle WRITE;
                ValueLayout.JAVA_LONG,  // output file
     * Removes the native writer registry entry for {@code file} without finalizing it (idempotent).
                typeEncodings.keys().count(),
                ValueLayout.JAVA_LONG,   // type_compression_name_ptrs, type_compression_name_lens, type_compression_value_ptrs,
            var idx = call.str(nativeSettings.getIndexName());
                ValueLayout.JAVA_LONG,  // gen_sizes_ptr
    }
                ValueLayout.JAVA_LONG,   // compression_type
            int bufSize = 10 * 1024 * 1024; // 10MB
    public static void initMemoryPools(long writeLimit, long mergeLimit) {
                ValueLayout.ADDRESS,    // out_gen_sizes_ptr
            );
            )
                typeEncodings.keys().lens(),
                ValueLayout.JAVA_LONG,   // nulls_first (vals, count)
        for (int i = 0; i < bools.size(); i++) {
     * @param decide  returns a nonzero grant token to over-commit, or 0 to reject
        }
import java.lang.invoke.MethodHandles;
            Set<String> lcFields = nativeSettings.getLowCardinalityEnabledFields();
        long mappingAddr = outMappingPtr.get(ValueLayout.JAVA_LONG, 0);
        long mappingLen = outMappingLen.get(ValueLayout.JAVA_LONG, 0);
            return new String(out.data().asSlice(0, len).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8);
                numRowGroupsOut,
                ValueLayout.JAVA_LONG     // out_len
                ValueLayout.JAVA_LONG, // sort_columns (ptrs, lens, count)
                (long) out.capacity(),
            return new String(outBuf.asSlice(0, len).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8);
                outMappingPtr,
            );
            // Read mapping array (i64[])
    }
                ValueLayout.ADDRESS,    // out_flush_and_sort_chunk_count
import java.lang.foreign.Linker;
                ValueLayout.ADDRESS,
                typeEncodings.values().lens(),
                ValueLayout.ADDRESS,    // crc32_out
    public static void setWritePoolLimit(long newLimit) {
        MemorySegment outGenOffsetsPtr,
            seg.setAtIndex(ValueLayout.JAVA_LONG, i, map.get(keys[i]) ? 1L : 0L);
    private static BoolMapArrays toBoolMapArrays(NativeCall call, Map<String, Boolean> map) {
                idx.segment(),
        NativeCall.invokeVoid(INIT_MEMORY_POOLS, writeLimit, mergeLimit);
            int createdByLen = out.actualLength();
            var fieldCompressions = toNativeArrays(call, nativeSettings.getFieldCompressions());
                sorts.lens(),
        }
        READ_AS_JSON = linker.downcallHandle(
            )
            var crc32Out = call.longOut();
                outMappingLen,
                out.data(),
            int createdByLen = out.actualLength();
                outGenCount,
    /**
        try {
        );
    private static final MethodHandle REMOVE_SETTINGS;
     * the input sum.
            call.invoke(REMOVE_SETTINGS, idx.segment(), idx.len());
        try (var call = new NativeCall()) {
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
            var f = call.str(file);
            MethodHandle releaseHandle = lookup.findStatic(
                fieldEncodings.keys().count(),
                fieldCompressions.keys().count(),
                GET_FILE_METADATA,
            }
            var buf = call.buf(ParquetNativeRuntimeStats.FIELD_COUNT * 8);
                writerGeneration
    private record LongMapArrays(NativeCall.StrArray keys, MemorySegment values) {
    /** Delegate that decides whether a full native pool may over-commit; set by the owning plugin. */
                versionOut.get(ValueLayout.JAVA_INT, 0),
                0
                        liveBitsPtrs.setAtIndex(ValueLayout.ADDRESS, i, call.longs(bits));
                ValueLayout.ADDRESS,    // created_by_buf
    static void cleanupWriter(String file) throws IOException {
    /**
                ValueLayout.JAVA_LONG,
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS)
    ) {
            lib.find("parquet_get_column_metadata").orElseThrow(),
    ) {
        GET_POOL_STATS = linker.downcallHandle(
    }
                typeBfFpp.keys().ptrs(),
     */
                ValueLayout.JAVA_LONG,  // input files (ptrs, lens, count)
                CREATE_WRITER,
                ValueLayout.ADDRESS,     // out_buf
        WRITE = linker.downcallHandle(
            var typeBfEnabled = toBoolMapArrays(call, nativeSettings.getTypeBloomFilterEnabled());
            long flushChunkTimeMillis = outFlushChunkTimeMillis.get(ValueLayout.JAVA_LONG, 0);
                ValueLayout.ADDRESS,    // live-docs ptrs (per-input bitsets)
            var idx = call.str(indexName);
                ct != null ? ct.segment() : java.lang.foreign.MemorySegment.NULL,
            MethodHandle decideHandle = lookup.findStatic(RustBridge.class, "overCommitDecide", MethodType.methodType(long.class));
 *
                ValueLayout.JAVA_LONG,
        return seg;
import java.lang.invoke.MethodHandle;
                typeCompressions.keys().lens(),
                    long[] mappingArray = MemorySegment.ofAddress(permAddr)
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS                            // sort_perm_len_out
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,
                f.segment(),
                typeBfFpp.keys().count(),
                ValueLayout.JAVA_LONG,                        // sort_in_memory_threshold_bytes
                f.len(),
            call.invokeIO(READ_AS_JSON, f.segment(), f.len(), outBuf, (long) bufSize, outLen);
        try (var call = new NativeCall()) {
            }
    }
            var f = call.str(file);
        String[] keys = map.keySet().toArray(new String[0]);
                    }
        }
            for (int i = 0; i < ParquetNativeRuntimeStats.FIELD_COUNT; i++) {
            var outBuf = call.buf(bufSize);
                ValueLayout.JAVA_LONG,
                typeBfNdv.values(),
            lib.find("parquet_create_writer").orElseThrow(),
            // Out-pointers for Rust-allocated mapping data
    static void write(String file, long arrayAddress, long schemaAddress) throws IOException {
    public static void onSettingsUpdate(NativeSettings nativeSettings) throws IOException {
                ValueLayout.ADDRESS,                           // num_row_groups_out
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
            // Read generation keys (i64[]), offsets (i32[]), sizes (i32[])
                ValueLayout.ADDRESS,
                versionOut,
                for (int i = 0; i < paths.length; i++) {
            lib.find("parquet_free_row_id_mapping").orElseThrow(),
    }
        String[] keys = map.keySet().toArray(new String[0]);
        var seg = keys.length > 0 ? call.buf(keys.length * 8) : MemorySegment.NULL;
            lib.find("parquet_get_pool_stats").orElseThrow(),
                numRowsOut.get(ValueLayout.JAVA_LONG, 0),
            var f = call.str(file);
    private static final MethodHandle INIT_MEMORY_POOLS;
        );
                RustBridge.class,
            int[] genOffsets = MemorySegment.ofAddress(genOffsetsAddr)
                bfEnabled.keys().count(),
        long[][] liveBitsPerInput,
                outMappingLen,
                nativeSettings.getMergeRayonThreads() != null ? (long) nativeSettings.getMergeRayonThreads() : -1L,
        }
            long[] out = new long[ParquetNativeRuntimeStats.FIELD_COUNT];
     * Performs a native k-way merge of {@code inputFiles} into {@code outputFile}. Dead rows
            // Explicit fieldBloomFilterEnabled entries take precedence; low_cardinality fields get implicit bloom=true.
            var versionOut = call.intOut();
    private record BoolMapArrays(NativeCall.StrArray keys, MemorySegment values) {
            call.invokeIO(
                createdByLen >= 0
     * Registers the over-commit decision/release delegates and installs FFM upcall stubs into the
                ValueLayout.ADDRESS,
                outGenSizesPtr,
                .reinterpret(genCount * ValueLayout.JAVA_INT.byteSize())
            var p = call.str(pathPrefix);
            ParquetFileMetadata metadata = new ParquetFileMetadata(
        try (var call = new NativeCall()) {
                effectiveFieldBfEnabled = nativeSettings.getFieldBloomFilterEnabled();
                ValueLayout.ADDRESS,
                typeBfEnabled.keys().lens(),
    }
                numRowsOut.get(ValueLayout.JAVA_LONG, 0),
                ValueLayout.ADDRESS,
            lib.find("parquet_on_settings_update").orElseThrow(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
     * <p>{@code liveBitsPerInput} is parallel to {@code inputFiles} — each bitset uses Lucene
            values[i] = map.get(keys[i]);
                ValueLayout.JAVA_LONG,                        // bloom_filter_enabled
                    : null,
        long outputWriterGeneration
    /** Delegate that releases a previously granted over-commit; set by the owning plugin. */
                ValueLayout.ADDRESS,    // out_gen_count
                                         // type_compression_value_lens, type_compression_count
                liveBitsCount
     * Reads a parquet file and returns its contents as a JSON string.
                ON_SETTINGS_UPDATE,
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,
        );
        long genOffsetsAddr = outGenOffsetsPtr.get(ValueLayout.JAVA_LONG, 0);
                out.lenOut(),
        );
            } else {
    /**
                outGenCount
            // best-effort
            int[] genSizes = MemorySegment.ofAddress(genSizesAddr)
                ValueLayout.JAVA_LONG,   // file
                ValueLayout.ADDRESS,
    /**
    }
import java.util.function.LongConsumer;
                ValueLayout.ADDRESS,
    public static void initLogger() {}
                crc32Out,
                fieldEncodings.values().lens(),
                MethodType.methodType(void.class, long.class)
 */
                ValueLayout.ADDRESS,
        return new DoubleMapArrays(call.strArray(keys), seg);
                (long) sortConfig.reverseSorts().size(),
            long flushChunkCount = outFlushChunkCount.get(ValueLayout.JAVA_LONG, 0);
                liveBitsCount = paths.length;
                inputs.count(),
                ValueLayout.JAVA_LONG,
    static void createWriter(String file, String indexName, long schemaAddress, ParquetSortConfig sortConfig, long writerGeneration)
            var outFlushChunkTimeMillis = call.longOut();
            }
            Linker linker = Linker.nativeLinker();
            long permLen = sortPermLenOut.get(ValueLayout.JAVA_LONG, 0);
                .toArray(ValueLayout.JAVA_INT);
                try {
                out.lenOut(),
                ValueLayout.ADDRESS,
            }
import java.util.Map;
        );
                ValueLayout.ADDRESS,
                inputs.lens(),
                0L,
     * Collects a snapshot of native runtime metrics for the parquet merge path.
    public static void registerOverCommitCallbacks(LongSupplier decide, LongConsumer release) {
        if (bools == null || bools.isEmpty()) {
        FINALIZE_WRITER = linker.downcallHandle(
                ValueLayout.JAVA_LONG,
                typeCompressions.keys().count(),
                nativeSettings.getCompressionLevel() != null ? (long) nativeSettings.getCompressionLevel() : -1L,
            int createdByLen = (int) createdByOut.lenOut().get(ValueLayout.JAVA_LONG, 0);
        }
        }
                ValueLayout.JAVA_LONG,                        // page_size_bytes
            final MemorySegment liveBitsLens;
            FunctionDescriptor.of(
                f.len(),
                nativeSettings.getRowGroupMaxBytes() != null ? nativeSettings.getRowGroupMaxBytes() : -1L,
                ValueLayout.ADDRESS,
import java.io.UncheckedIOException;
                                         // type_encoding_value_lens, type_encoding_count
public class RustBridge {
                r.accept(token);
            var f = call.str(file);
            var outGenOffsetsPtr = call.longOut();
    }
            );
                f.segment(),
    }
                ValueLayout.JAVA_LONG,  // created_by_buf_len
            );
            // Read sort permutation if present
            NativeCall.invokeVoid(GET_POOL_STATS, buf);
    }
                ValueLayout.JAVA_LONG    // writer_generation
import java.io.IOException;
        } catch (Throwable t) {
            var idx = call.str(indexName);
    private record MapArrays(NativeCall.StrArray keys, NativeCall.StrArray values) {
                ValueLayout.JAVA_LONG,   // bf_enabled_name_ptrs, bf_enabled_name_lens, bf_enabled_vals, bf_enabled_count
            var numRowsOut = call.longOut();
            return java.lang.foreign.MemorySegment.NULL;
            );
        try {
            FunctionDescriptor.of(
                ValueLayout.ADDRESS,
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            var buf = call.buf(6 * 8);
     * flagged in {@code liveBitsPerInput} are dropped from the output; row count is bounded by
        );
        );
        GET_COLUMN_METADATA = linker.downcallHandle(
                ValueLayout.ADDRESS,
            var outGenCount = call.longOut();
                ValueLayout.ADDRESS,    // out_gen_offsets_ptr
import java.util.List;
        }
                ValueLayout.JAVA_LONG,                        // compression_level
                ValueLayout.ADDRESS,    // out_flush_and_sort_chunk_time_millis
/*
            throw new IllegalArgumentException(
                }
            seg.setAtIndex(ValueLayout.JAVA_LONG, i, map.get(keys[i]));
            seg.setAtIndex(ValueLayout.JAVA_LONG, i, bools.get(i) ? 1L : 0L);
                ValueLayout.ADDRESS
        );
                typeEncodings.keys().ptrs(),
                sorts.ptrs(),
            var typeBfNdv = toLongMapArrays(call, nativeSettings.getTypeBloomFilterNdv());
                out.len(),
                ValueLayout.ADDRESS,
    /** C-ABI trampoline invoked from Rust: returns a nonzero grant token, or 0 to reject. */
    private static final MethodHandle MERGE_FILES;
                ValueLayout.ADDRESS,
                crc32Out.get(ValueLayout.JAVA_LONG, 0),
    }
            );
        try (var call = new NativeCall()) {
            )
     *
            var sortPermPtrOut = call.longOut();
                ValueLayout.ADDRESS,
                outGenKeysPtr,
            var f = call.str(file);
                    ? new String(out.data().asSlice(0, createdByLen).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_8)
            }
 * this file be licensed under the Apache-2.0 license or a
            )
            var nullsFirstArray = marshalBoolList(call, sortConfig.nullsFirst());
                nativeSettings.getBloomFilterEnabled() != null ? (nativeSettings.getBloomFilterEnabled() ? 1L : 0L) : -1L,
                ValueLayout.ADDRESS,
                nativeSettings.getPageSizeBytes() != null ? nativeSettings.getPageSizeBytes() : -1L,
                ValueLayout.ADDRESS,    // out_mapping_len
            lib.find("parquet_finalize_writer").orElseThrow(),
        }
            var fieldEncodings = toNativeArrays(call, nativeSettings.getFieldEncodings());
                ValueLayout.ADDRESS,    // out_row_id_mapping_max
            var outLen = call.longOut();
        String outputFile,
        } catch (Throwable t) {
                ValueLayout.ADDRESS,
        }
        String indexName,
            var out = call.outBuffer(8192);
                ValueLayout.JAVA_LONG,                        // row_group_max_rows
    private static final MethodHandle SET_WRITE_POOL_LIMIT;
                bfEnabled.values(),
        }
            )
            if (hasLiveDocs) {
                typeBfFpp.keys().lens(),
    }
        }
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        }
                liveBitsPtrs,
    }
        try (var call = new NativeCall()) {
        long genCount = outGenCount.get(ValueLayout.JAVA_LONG, 0);
    private static final MethodHandle GET_FILTERED_BYTES;
                outGenKeysPtr,
                typeBfNdv.keys().count()
        );
        }
    private static void overCommitRelease(long token) {
import org.opensearch.parquet.stats.ParquetNativeRuntimeStats;
            call.invokeIO(GET_COLUMN_METADATA, f.segment(), f.len(), out.data(), (long) out.capacity(), outLen);
        return new MapArrays(call.strArray(keys), call.strArray(values));
        }
            var out = call.outBuffer(1024);
