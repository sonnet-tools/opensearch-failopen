        final long sessionCtxPtr;  
    private static final MethodHandle CACHE_MANAGER_ADD_FILES;
        // BatchPartitioner (matches RepartitionExec / HashJoinExec). Output buffer holds
                "releaseProvider",
    public static DataFusionStats stats(long runtimePtr) {
            NativeCall.Str table = call.str(tableName);
        );
 * arrays) that are only needed for the duration of the FFM call. The Arena is closed
    /** Sets the initial target_partitions for coordinator-reduce sessions. */
            lib.find("df_native_node_stats").orElseThrow(),
        }
    /** {@link #canMatch} status: shard may hold a matching row. */
            lib.find("df_set_memory_guard_thresholds").orElseThrow(),
    /**
            var so = call.strArray(sortOrders.toArray(String[]::new));  
        long[] schemaPtrs
    // ---- Stubs ----  
        }  
     * runs a bounded min-heap of size {@code n} over its registry and writes
            }
        CACHE_MANAGER_UPDATE_SIZE_LIMIT = linker.downcallHandle(
     *                   native {@code QUERY_REGISTRY} under this id so {@link #cancelQuery} fires
            boolean hasPlan = planBytes != null && planBytes.length > 0;  
                id.segment(),
     *  
                releaseProviderStub,
    }  
        );  
                    "df_partition_batch_by_hash returned " + outBytes.length + " bytes, expected " + partitionCount * pairBytes
        EXECUTE_WITH_CONTEXT = linker.downcallHandle(
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
    public static void closeSessionContext(long ptr) {
                ValueLayout.JAVA_LONG,
    public static boolean isSpillLimitDynamic() {
        NativeHandle.validatePointer(sessionPtr, "session");
    /**
     * @param rowIdsCount number of row IDs  
     * builds a single pushed-down filter plan via the DataFusion DataFrame API, using
                ValueLayout.ADDRESS,
        NativeCall.invokeVoid(CANCEL_QUERY, contextId);
                ValueLayout.ADDRESS  
                call.bytes(partialPlanBytes),
        // i64 df_cache_manager_contains_by_type(runtime_ptr, type_ptr, type_len, file_ptr, file_len)
            var id = call.str(inputId);
 * <h2>Error convention</h2>
                colNames.ptrs(),
        );  
    private static final MethodHandle EXECUTE_LOCAL_PREPARED_PLAN;
            return rte;
                ValueLayout.ADDRESS,
        }
            lib.find("df_execute_local_plan").orElseThrow(),  
            )
/**
            lib.find("df_create_global_runtime").orElseThrow(),
                ValueLayout.JAVA_LONG
        NativeHandle.validatePointer(handlePtr, "sessionContext");
                ValueLayout.ADDRESS,
        NativeCall.invokeVoid(SET_CANCEL_STATS_THRESHOLD_MS, millis);
            long ptr = call.invoke(  
        GET_MEMORY_POOL_USAGE = linker.downcallHandle(  
            lib.find("df_can_match").orElseThrow(),
    private static final MethodHandle CREATE_CUSTOM_CACHE_MANAGER;
    public static long executeLocalPlan(long sessionPtr, byte[] substrait, long contextId) {
            if (found != 1L) {  
                ValueLayout.JAVA_LONG,
                storePtr = 0L;  
     * registration has no sender to return) — the {@code schemaIpc} field carries the schema
            }
     * Returns a stream pointer that can be drained via {@link #streamNext} and  
     */  
    }
            }
     */
    private static final MethodHandle DF_NATIVE_NODE_STATS;
                sf.count()
            lib.find("df_set_cancel_stats_threshold_ms").orElseThrow(),
    }
        }
            var taskMonitors = new LinkedHashMap<String, TaskMonitorStats>();
     * Pushes one Arrow C Data-exported batch (array + schema addresses) into the sender. The
     */
                ValueLayout.JAVA_BYTE,   // deletedDocFilteringRequired (0/1)  
     * @throws IllegalStateException if the runtime manager is not initialized
                inputSchemaPtr,
        );
    }
     * @return opaque stream pointer  
                SQL_TO_SUBSTRAIT,
                "createProvider",
        // Java JAR is forward-compatible with a future native library that ships it.
            return Collections.unmodifiableMap(out);
            lib.find("df_clear_scoped_page_index_cache").orElseThrow(),
     * Updates the effective permit count of a concurrency gate at runtime.
            java.lang.foreign.MemorySegment releaseCollectorStub = linker.upcallStub(  
                ValueLayout.ADDRESS,
    }  
        // i64 df_register_partition_stream(session_ptr, input_id_ptr, input_id_len,
                result = call.invoke(EXECUTE_WITH_CONTEXT, sessionCtxPtr, plan, planLen);  
     * @return a fully constructed {@link DataFusionStats}
            FunctionDescriptor.of(
        SET_SPILL_EXEMPT_CAP_BYTES = linker.downcallHandle(
            lib.find("df_register_filter_tree_callbacks").orElseThrow(),
            return new DataFusionStats(  
            listener.onFailure(convertNativeError(t));
        CLOSE_GLOBAL_RUNTIME = linker.downcallHandle(
                ValueLayout.ADDRESS,     // plan_ptr  
 * to a heap-allocated error string. {@link NativeCall#invoke} reads and frees the error,  
                table.len(),  
    }
        if (inputArrayPtr == 0 || inputSchemaPtr == 0) {
                ValueLayout.JAVA_LONG,
        try (var call = new NativeCall()) {
                readerPtr,
        // 16N bytes: N (array_ptr, schema_ptr) pairs as parallel little-endian i64s.
        try (var call = new NativeCall()) {
                addr -> linker.downcallHandle(
     * metadata. Used for hash-shuffle worker fragments whose plans read only from named-input
            lib.find("df_register_partition_stream").orElseThrow(),
     * (otherwise {@code No field named sum_qty}). The producer still ships physically-named batches;
                runtimePtr,  
                ValueLayout.ADDRESS,  
        byte[] planBytes  
                ValueLayout.JAVA_LONG,  
        ActionListener<Long> listener  
                (byte) (deletedDocFilteringRequired ? 1 : 0),
                java.lang.invoke.MethodType.methodType(void.class, long.class, int.class)
            )  
    public static long registerMemtableOnSessionContext(
                ValueLayout.JAVA_LONG,  
    }
                ValueLayout.JAVA_LONG,
                f.ptrs(),
        } catch (Throwable t) {  
        FREE_METRICS_BUF = linker.downcallHandle(  
            var id = call.str(inputId);
            var msg = call.str(reason == null ? "unknown" : reason);
        EXECUTE_LOCAL_PLAN = linker.downcallHandle(
        NativeHandle.validatePointer(sessionPtr, "session");
                (long) out.capacity(),  
     * {@link org.opensearch.be.datafusion.DataFusionPlugin#DATAFUSION_SPILL_MEMORY_LIMIT}
    }  
        );  
     * Converts a Throwable from the FFM boundary into an appropriate Exception, applying
     * turning a silently-incomplete result into a loud query failure. Tolerates a zero pointer.
            return out.toByteArray();  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    }
    }
                ValueLayout.JAVA_LONG,
                (long) hashKeyIndices.length,  
        );
import org.opensearch.be.datafusion.stats.TaskMonitorStats;  
            call.invoke(CACHE_MANAGER_ADD_FILES, runtimePtr, f.ptrs(), f.lens(), f.count());
     *  
        NativeHandle.validatePointer(readerPtr, "reader");
     */
                table.segment(),  
        String tableName,
    private static final MethodHandle CACHE_MANAGER_GET_TOTAL_MEMORY;
    public static long createDatafusionReader(
            );
        }  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE)
    /**  
            java.lang.foreign.MemorySegment releaseProviderStub = linker.upcallStub(  
                ValueLayout.ADDRESS,
            )
    }  
            lib.find("df_execute_query").orElseThrow(),  
    }  
                f.count(),
    ) {
            long status = call.invoke(
            var type = call.str(cacheType);  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG)
        NativeCall.invokeVoid(CLOSE_READER, ptr);
        );
                REGISTER_MEMTABLE_ON_SESSION_CONTEXT,  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        }
            );
            return call.invoke(  
    private static final MethodHandle STREAM_NEXT;  
        );
                ValueLayout.ADDRESS,  
    private static final MethodHandle SET_OFFSET_INDEX_CACHE_LIMIT;
            );
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
                ValueLayout.JAVA_LONG,  
     *
    private static final MethodHandle CLOSE_READER;  
     * Safe to call at most once per pointer.  
            lib.find("df_prepare_final_plan").orElseThrow(),  
        // i64 df_prepare_partial_plan(handle_ptr, bytes_ptr, bytes_len)
        return e;  
    public static SessionContextHandle createSessionContextForIndexedExecution(
        }  
     * {@link #senderSend} / {@link #senderClose}. Used by M2's hash-shuffle worker to register
    private static final MethodHandle CACHE_MANAGER_GET_MEMORY_BY_TYPE;  
     * {@code Data.importVectorSchemaRoot} and closes the wrappers when done.
        boolean requestsRowIds,
    }
        );  
     * The returned stream is drained identically in all modes.
            lib.find("df_prepare_partial_plan").orElseThrow(),  
        if (bytes > Integer.MAX_VALUE) {
            lib.find("df_cache_manager_remove_files").orElseThrow(),  
        }  
            return new SessionContextHandle(ptr);
            long ptr = call.invoke(CREATE_WORKER_SESSION_CONTEXT, runtimePtr, contextId, queryConfigPtr);  
            var outLen = arena.allocate(ValueLayout.JAVA_LONG);
                    ValueLayout.JAVA_INT,  
        CREATE_CACHE = linker.downcallHandle(
        // i64 df_create_worker_session_context(runtime_ptr, context_id, query_config_ptr)
     * <p>Input ownership: the caller's input FFI structs are read but not consumed; the caller
                ValueLayout.JAVA_LONG,  
    /**  
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_LONG,   // query_config_ptr
        SENDER_TERMINATE_EARLY = linker.downcallHandle(
    }  
            );
        );  
                out.data(),
            var type = call.str(cacheType);  
            );  
        );
                result[i] = bb.getLong();
            )  
        try (var call = new NativeCall()) {  
    private static final MethodHandle SHUTDOWN_RUNTIME_MANAGER;
        long contextId,
    private static final MethodHandle INIT_RUNTIME_MANAGER;  
                    ValueLayout.JAVA_LONG
     * send was skipped because the consumer dropped the receiver before this batch could be sent
                ValueLayout.ADDRESS
     * When disabled, the metadata cache retains the full page index (fallback mode)
     *
                planSegment,
        );
    public static AnalyticsBackendTaskCancellationStats nativeNodeStats() {
    public static void preparePartialPlan(long handlePtr, byte[] substraitBytes) {  
     */
    private static final MethodHandle CREATE_WORKER_SESSION_CONTEXT;  
    /**
    ) {
            lib.find("df_init_runtime_manager").orElseThrow(),
        long runtimePtr,  
     * already has the listing-table-backed shard scan registered. Returns 0 on success; a
        REGISTER_FILTER_TREE_CALLBACKS = linker.downcallHandle(
        long readerPtr,
                ValueLayout.JAVA_LONG,
    }
                out.getAtIndex(ValueLayout.JAVA_LONG, 1),
    }
                ValueLayout.ADDRESS,
import java.lang.foreign.SymbolLookup;
        }
        GET_MEMORY_POOL_LIMIT = linker.downcallHandle(
                FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT),  
            var cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
            call.invoke(PREPARE_FINAL_PLAN, sessionPtr, call.bytes(substraitBytes), (long) substraitBytes.length);  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            );  
        double executionSpill,
            var colNames = call.strArray(columns);
    ) {
    ) {
 * The OpenSearch Contributors require contributions made to  
    }
    /** Sets the minimum target_partitions floor for the adaptive budget system. */
            var f = call.strArray(filePaths);
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
                REGISTER_FILTER_TREE_CALLBACKS,  
    private static final MethodHandle STREAM_GET_SCHEMA;
                ValueLayout.JAVA_LONG,
            throw t instanceof RuntimeException ? (RuntimeException) t : new RuntimeException(t);  
    /**
 * SPDX-License-Identifier: Apache-2.0
    public static void senderFail(long senderPtr, String reason) {  
                ValueLayout.JAVA_LONG,
    }  
     * {@link #executeLocalPreparedPlan}.
            throw new IllegalArgumentException("partitionCount must be > 0, got " + partitionCount);
            MethodHandle releaseCollector = lookup.findStatic(
            if (result != 0) {  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)  
            long planLen = hasPlan ? planBytes.length : 0L;
     * counters, keeps the budget). For operational testing.  
        }
        NativeHandle.validatePointer(sessionContextHandlePtr, "sessionContextHandle");  
            for (NativeExecutorsStats.OperationType op : NativeExecutorsStats.OperationType.values()) {
     *                   already prepared via {@link #prepareFinalPlan}
            lib.find("df_set_reduce_target_partitions").orElseThrow(),  
                table.segment(),
    }
        List<org.opensearch.index.engine.exec.MonoFileWriterSet> segments,
     * {@link #isSpillLimitDynamic()} before invoking.
        }
                (byte) (deletedDocFilteringRequired ? 1 : 0),
     * all non-negative, because {@link NativeCall#invoke} routes negatives to  
        );
     * <p>The schema is taken as IPC bytes (the same shape as
        );
    private static final MethodHandle CREATE_SESSION_CONTEXT_INDEXED;
        );
    private static final MethodHandle CACHE_MANAGER_UPDATE_SIZE_LIMIT;  
        );
    private static final MethodHandle SET_COLUMN_INDEX_CACHE_LIMIT;  
    }
        long readerPtr,  
            );
    private static final MethodHandle CANCEL_QUERY;
    private static final MethodHandle SQL_TO_SUBSTRAIT;
        try (var call = new NativeCall()) {
     * range covering only part of the shard would be narrower than the truth.
     * (e.g. {@code sum_qty}) rather than the producer's physical aggregate-state names (e.g.
        }  
     */  
    private static final MethodHandle QUERY_REGISTRY_TOP_N_BY_CURRENT;
        } catch (RuntimeException e) {
            call.invoke(SENDER_FAIL, senderPtr, msg.segment(), msg.len());  
     * Prepares a final-aggregate physical plan on a local session.
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS)  
                ValueLayout.JAVA_LONG,
            lib.find("df_cache_manager_contains_by_type").orElseThrow(),  
        boolean hasPartialAggregate,
        );  
     * buffer is unspecified.
     */
        if (sortOrders == null) sortOrders = List.of();
     * through the store (populating data Foyer), and returns for promotion to metadata Foyer.  
        STREAM_GET_SCHEMA = linker.downcallHandle(
    /** {@code internal_search_mode}: get-by-row-id — native plan filters {@code __row_id__ = bound}, {@code substraitPlan} ignored. */  
            java.lang.foreign.MemorySegment createCollectorStub = linker.upcallStub(
            long result = call.invoke(CACHE_MANAGER_CONTAINS_BY_TYPE, runtimePtr, type.segment(), type.len(), file.segment(), file.len());
            }
     * Must be called BEFORE streamClose (the stream handle must still be alive).
        PARTITION_BATCH_BY_HASH = linker.downcallHandle(  
                ValueLayout.JAVA_LONG,  
     * EOF, then drops the sender (same teardown as {@link #senderClose}). Used when the Java drain
    public static void cacheManagerUpdateSizeLimit(long runtimePtr, String cacheType, long newLimit) {
     * setting stays {@code NodeScope}-only.  
     * overlapping the range [filterMin, filterMax] on the named column.
     * Creates a native reader. Returns an opaque native pointer.
            FunctionDescriptor.of(ValueLayout.JAVA_LONG)
        long sessionContextHandlePtr,
     *  
            listener.onResponse(result);
                ValueLayout.JAVA_LONG,
            );  
                out.lenOut()
                sessionPtr,  
            // Rust passes it through every FFM upcall; Java uses it to look up the
    public static final long CAN_MATCH_YES = 1L;
                partitionCount,
                call.bytes(substraitPlan),
                (byte) (hasPartialAggregate ? 1 : 0),
                ValueLayout.JAVA_LONG,
        try (var call = new NativeCall()) {
     * @param sortFields index.sort.field values, or empty list if the index has no sort configured.
    public static void updateConcurrencyGate(String gateName, int newMaxPermits) {
 * <p>{@link NativeCall} creates a confined Arena for short-lived allocations (strings, byte  
            );
            lib.find("df_register_partition_stream_on_session_context").orElseThrow(),
        CREATE_LOCAL_SESSION = linker.downcallHandle(
            call.invoke(SET_OFFSET_INDEX_CACHE_LIMIT, sizeLimitBytes);  
    }
     * Registers the same kind of partitioned streaming input on a {@code SessionContextHandle}, but
    private static final int SORT_BOUNDS_SLOTS = 4;
                null,
        CAN_MATCH = linker.downcallHandle(
    /**  
                storePtr = dataformatAwareStoreHandle.getPointer();  
                ValueLayout.JAVA_LONG,  
     * <p>This registers the streaming table under the worker FINAL fragment's logical column names
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
        NativeHandle.validatePointer(senderPtr, "sender");
        long internalSearchMode,
                storePtr,  
                ValueLayout.JAVA_LONG,  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
                ValueLayout.ADDRESS,    // sort_fields_len_ptr
        try {
        long queryConfigPtr,
            call.invoke(SET_SCOPED_PAGE_INDEX_ENABLED, enabled ? 1L : 0L);
     * {@link #SENDER_SEND_RECEIVER_DROPPED} if the consumer already dropped the receiver.  
    private static final MethodHandle REGISTER_PARTITION_STREAM;
     * consumer's {@code RecordBatchStream} yields an ERROR (failing the join/agg) instead of a clean
    public static void setColumnIndexCacheLimit(long sizeLimitBytes) {  
                    long.class,
        );  
            );  
                ValueLayout.JAVA_LONG,
            }
                "arrayPtrs.length (" + arrayPtrs.length + ") != schemaPtrs.length (" + schemaPtrs.length + ")"  
    /**
                ValueLayout.JAVA_LONG,  
                out.data(),
                sessionContextHandlePtr,
                ValueLayout.JAVA_LONG,   // shard_view_ptr  
        }
        CREATE_GLOBAL_RUNTIME = linker.downcallHandle(
    public static void setSpillLimit(long runtimePtr, long newLimitBytes) {  
        long runtimePtr,
        String inputId,  
     *                  queries (null-filling columns this shard omits). Empty = skip widening.
    public static void cacheManagerClearByCacheType(long runtimePtr, String cacheType) {
        } catch (Throwable throwable) {  
        NativeHandle.validatePointer(sessionContextHandlePtr, "sessionContextHandle");
        CLOSE_SESSION_CONTEXT = linker.downcallHandle(
            logger.debug("Failed to read native stream metrics", t);
        // TODO(PR1): wire to df_clear_column_index_cache when available
                ValueLayout.JAVA_LONG,
     * export {@code df_set_spill_limit} — callers should gate on  
            );  
    }  
                ValueLayout.JAVA_LONG
        }
     * the per-side partition input alongside the shard-scan listing table on the same session.  
        }
        NativeHandle.validatePointer(sessionContextHandlePtr, "sessionContextHandle");  
                ValueLayout.JAVA_LONG,
            long[] result = new long[partitionCount * 2];
    }
    /**
import org.opensearch.core.action.ActionListener;
                ValueLayout.JAVA_LONG,   // return: 1=bounds written, 0=unavailable  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
            NativeHandle.validatePointer(readerPtr, "reader");  
                ValueLayout.ADDRESS,  
     *         buffer larger than {@link Integer#MAX_VALUE} bytes
                    + ") and sortOrders ("  
        CREATE_WORKER_SESSION_CONTEXT = linker.downcallHandle(  
        try (var call = new NativeCall()) {  
                planLen
            call.invoke(CACHE_MANAGER_CLEAR_BY_TYPE, runtimePtr, type.segment(), type.len());
/*  
        long sessionPtr,  
     * — the benign "consumer finished first" case (e.g. a LimitExec satisfied its fetch). It
        SENDER_FAIL = linker.downcallHandle(
        );
        try (NativeCall call = new NativeCall()) {
        try (var call = new NativeCall()) {
            lib.find("df_get_memory_pool_limit").orElseThrow(),  
    }
                REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT,
                java.lang.invoke.MethodType.methodType(void.class, long.class, int.class)
        CREATE_SESSION_CONTEXT = linker.downcallHandle(
                ValueLayout.ADDRESS,
     */
            var out = call.outBuffer(16 * partitionCount);  
        try (var call = new NativeCall()) {
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
                ValueLayout.JAVA_INT,  
                    int.class,
            var f = call.strArray(filePaths);  
     *
        }  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        }
        long contextId,
                    int.class,
        }  
     * so this preserves the unchecked throw semantics of the original call site.
    }
                    ValueLayout.JAVA_LONG,  
                "arrayPtrs.length (" + arrayPtrs.length + ") != schemaPtrs.length (" + schemaPtrs.length + ")"  
    }  
                table.segment(),
     * {@code sum_qty[sum]}). DataFusion's Substrait consumer binds the FINAL {@code base_schema} to  
        }
        }
    private static final MethodHandle CLOSE_GLOBAL_RUNTIME;  
        );  
                ValueLayout.JAVA_LONG,
                sessionContext.markConsumed();  
        int delegatedPredicateCount,
                internalSearchMode,  
    private static final MethodHandle SET_SPILL_LIMIT;  
    // ---- Distributed aggregate: prepare partial/final plans ----  
                ValueLayout.ADDRESS,
            )
        try (var call = new NativeCall()) {  
                ValueLayout.JAVA_LONG,
    private static final MethodHandle EXECUTE_WITH_CONTEXT;
                ValueLayout.JAVA_LONG,  
                ValueLayout.JAVA_LONG,
            .orElse(null);
                cacheStats,
     * @param sessionPtr pointer returned by {@link #createLocalSession}
        // i64 df_cache_manager_add_files(runtime_ptr, files_ptr, files_len_ptr, files_count)
     *
            call.invoke(CACHE_MANAGER_ADD_FILES_WITH_STORE, runtimePtr, storePtr, f.ptrs(), f.lens(), f.count());  
                ValueLayout.ADDRESS,    // writer_generations_ptr
     * For synchronous FFM methods: converts and rethrows as RuntimeException.  
     * @param planBytes Substrait plan bytes — used to widen the registered schema for multi-index
            lib.find("df_update_concurrency_gate").orElseThrow(),
import org.opensearch.analytics.backend.jni.NativeHandle;  
            );
            var seg = call.buf((int) StatsLayout.LAYOUT.byteSize());  
            )
            FunctionDescriptor.of(
            call.invoke(CLEAR_SCOPED_PAGE_INDEX_CACHE);
            listener.onResponse(result);  
        SET_MIN_TARGET_PARTITIONS = linker.downcallHandle(  
     * When false, spill-cap updates require a node restart — the public
     * @param contextId  the parent {@code AnalyticsQueryTask.getId()}; registers the reduce in the
            var out = call.outBuffer(64 * 1024);
            )
            // Partition gates  
                    ValueLayout.JAVA_INT,
                ValueLayout.ADDRESS,    // files_len_ptr  
        );  
                ValueLayout.ADDRESS,
    /** Returns current memory pool usage in bytes. */
        );  
 * <p>Native pointers returned by {@code createGlobalRuntime}, {@code createDatafusionReader},  
                ValueLayout.JAVA_LONG,  // table_path_len
        }  
                ValueLayout.ADDRESS,  
     *         (column absent, unsupported physical type, statistics missing, or files
            listener.onFailure(e);
            lib.find("df_set_offset_index_cache_limit").orElseThrow(),  
    }
            logger.debug("Failed to set reduce target partitions", t);
            var type = call.str(cacheType);
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG,   // column_name_len
        // Arc<DiskManager> API). Bind only if the symbol is present so the same
                arena  
     * @param sessionPtr pointer returned by {@link #createLocalSession} with a plan  
        );  
    /**
            )  
        }
    }  
                ValueLayout.JAVA_LONG,   // returns stream_ptr
    }  
        long bytes = (long) n * QueryRegistryLayout.ENTRY_BYTES;
     * @param sortOrders index.sort.order values ("asc" or "desc"), parallel to {@code sortFields}.  
                ValueLayout.JAVA_LONG,  
                ValueLayout.JAVA_LONG
        // NOT from our NativeHandle lifecycle — validate as non-zero rather than live-handle.
    }
    private static final MethodHandle CAN_MATCH;
            } finally {
    }
     */
            call.invoke(CLEAR_SCOPED_PAGE_INDEX_CACHE);  
     * returns an error. The handle is therefore marked consumed in a {@code finally} block so
    /** {@code internal_search_mode}: seq-no scan — native plan filters {@code _seq_no > bound}, {@code substraitPlan} ignored. */
     * Sets the byte budget of the process-global scoped ColumnIndex cache.  
            FunctionDescriptor.of(  
        );  
        String[] columns,  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
                java.lang.invoke.MethodType.methodType(int.class, long.class, int.class)  
            lib.find("df_stream_get_metrics").orElseThrow(),
        }
        );
     * Reads footer (lightweight) into heap cache, fetches page/offset index bytes
            return Collections.emptyMap();
        if (sortFields == null) sortFields = List.of();  
                id.len(),
        STREAM_GET_METRICS = linker.downcallHandle(
            NativeHandle.validatePointer(runtimePtr, "runtime");
        if (n < 0) {
    /**
        );
        }
            call.invoke(UPDATE_CONCURRENCY_GATE, name.segment(), name.len(), newMaxPermits);
        // i64 df_create_local_session(runtime_ptr)
    public static final long SENDER_SEND_RECEIVER_DROPPED = 1L;
    // ---- Reader management (confined Arena for path + file strings) ----
     * Reads native task cancellation counters via {@code df_native_node_stats} FFM call.
                table.len(),
                    ValueLayout.JAVA_INT,  
                new NativeExecutorsStats(ioRuntime, cpuRuntime, taskMonitors),
     * DataFusion {@code DiskManager.max_temp_directory_size} is a plain {@code u64}
    public static void createCache(long cacheManagerPtr, String cacheType, long sizeLimit, String evictionType) {  
     * Streaming sibling of {@link #registerMemtableOnSessionContext}. Registers a partitioned
                ValueLayout.JAVA_LONG,  
     * becomes non-null automatically — the same Java JAR works against both  
     * the native session settled on after lowering.  
    public static long executeLocalPreparedPlan(long sessionPtr, long contextId) {  
     * Creates a global DataFusion runtime. Returns an opaque native pointer ({@code long}).
     * lands, our crate exports {@code df_set_spill_limit} and this handle
    private static final MethodHandle SENDER_CLOSE;  
     * @param n maximum entries to return; must be non-negative. Zero short-circuits
     *                   {@link #executeLocalPlan(long, byte[], long)} for semantics  
        }
            lib.find("df_stats").orElseThrow(),
        }
                ValueLayout.ADDRESS,
        installFilterTreeCallbacks(linker);  
            byte[] bytes = dataPtr.reinterpret(len).toArray(ValueLayout.JAVA_BYTE);
    public static final long INTERNAL_SEARCH_BY_ROW_ID = 1L;
            FunctionDescriptor.of(
                )
                ValueLayout.JAVA_LONG
            lib.find("df_destroy_custom_cache_manager").orElseThrow(),  
     * NativeErrorConverter only returns RuntimeException subtypes when it matches,
    /** Clears the scoped ColumnIndex (predicate) cache. */
        // i64 df_can_match(runtime_ptr, shard_view_ptr, column_name_ptr, column_name_len, filter_min, filter_max)  
                (long) arrayPtrs.length
import org.opensearch.plugins.NativeStoreHandle;
     * Creates a SessionContext configured for indexed execution with filter delegation.  
            GET_MEMORY_POOL_STATS.invokeExact(runtimePtr, buf);
    // ---- SessionContext decomposition ----  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        GET_MEMORY_POOL_STATS = linker.downcallHandle(
    }
                ValueLayout.JAVA_BYTE,   // requestsRowIds (0/1) — QTF query phase signal
        );
    public static void initTokioRuntimeManager(int cpuThreads, double datanodeMultiplier, double coordinatorMultiplier) {
     */
            // Search stats  
     * (argument marshalling) leaves the handle unconsumed, in which case its
        try (var call = new NativeCall()) {  
        initTokioRuntimeManager(cpuThreads, 1.5, 1.5);
        byte[] schemaIpc,
            MemorySegment planSegment = hasPlan ? call.bytes(planBytes) : MemorySegment.NULL;
    private static final MethodHandle SET_SCOPED_PAGE_INDEX_ENABLED;  
        );
        );
            lib.find("df_set_min_target_partitions").orElseThrow(),
        // ── SessionContext decomposition bindings ──  
        STREAM_NEXT = linker.downcallHandle(  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        REGISTER_MEMTABLE_ON_SESSION_CONTEXT = linker.downcallHandle(  
     * M3 hash-shuffle AGGREGATE worker variant of {@link #registerPartitionStreamOnSessionContext}.
     * and CI/OI scoped caches are bypassed entirely.  
        try (var call = new NativeCall()) {
     * {@link #registerMemtableOnSessionContext}) — the producer side ships record batches whose  
            NativeCall.invokeVoid(
            lib.find("df_partition_batch_by_hash").orElseThrow(),
                ValueLayout.ADDRESS,
            listener.onFailure(convertNativeError(throwable));
        }  
        NativeHandle.validatePointer(runtimePtr, "runtime");
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
                FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT),
     * Evaluates whether any parquet file in the shard has row-group statistics
                CREATE_READER,
            listener.onFailure(convertNativeError(t));  
                ValueLayout.ADDRESS,  
                ValueLayout.JAVA_LONG,
        try (var call = new NativeCall()) {
            MemorySegment planSegment = hasPlan ? call.bytes(planBytes) : MemorySegment.NULL;
            var ioRuntime = StatsLayout.readRuntimeMetrics(seg, "io_runtime");
            MethodHandle createCollector = lookup.findStatic(
                ValueLayout.JAVA_INT,
                StatsLayout.readAdaptiveBudgetStats(seg),  
    /** Fires the cancellation token for the given context. No-op if already completed. */
            )
        );
     * Returns null if no metrics are available (e.g., plan didn't capture them).
            )
     * streams subsequently registered via {@link #registerPartitionStreamOnSessionContext}.
        EXECUTE_QUERY = linker.downcallHandle(
                ValueLayout.ADDRESS
        } catch (Exception e) {  
     * runtime is in use, so we do not ship this symbol from our Rust crate.  
                sf.ptrs(),
                    ValueLayout.JAVA_LONG,
     */
    private static void installFilterTreeCallbacks(Linker linker) {  
        CREATE_SESSION_CONTEXT_INDEXED = linker.downcallHandle(  
                ValueLayout.JAVA_LONG,  // count (applies to filenames + writer_generations)
                ValueLayout.JAVA_LONG,
        long queryConfigPtr,
     *
 * immediately after the call returns, freeing all temp memory.</p>
     *          without crossing the FFM boundary.  
     * Returns a tracked handle consumed by {@link #executeWithContextAsync}.
                ValueLayout.JAVA_LONG
                ValueLayout.ADDRESS,  
                ValueLayout.JAVA_LONG,
        );
            java.lang.foreign.Arena arena = java.lang.foreign.Arena.global();
        try (var call = new NativeCall()) {
                (long) partialPlanBytes.length,  
import java.util.Collections;
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG   // files_count
     * {@code RepartitionExec} / {@code HashJoinExec} so producers and probe-side consumers
                ValueLayout.ADDRESS,  
                ValueLayout.ADDRESS,  
     * is released, buffered batches remain available to the receiver, and the receiver observes
                ValueLayout.JAVA_LONG,
     */  
        SET_OFFSET_INDEX_CACHE_LIMIT = linker.downcallHandle(
                out.lenOut()
     * Variant of {@link #registerMemtable} for the shard-scan path. Takes the
        } catch (Throwable t) {
     * @throws IllegalArgumentException if {@code n} is negative or implies a  
import org.opensearch.analytics.spi.QueryExecutionMetrics;
     *  
    /** Returns memory pool stats: [usage_bytes, tripped_count]. Single FFM call. */
        try (var call = new NativeCall()) {  
        try {
            var table = call.str(tableName);
     * broadcast injection on the probe side can register its memtable on the same session that  
    }
    private static final MethodHandle CREATE_GLOBAL_RUNTIME;
 * FFM bridge to native DataFusion library.  
    }
        try (var call = new NativeCall()) {
                arena  
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
            java.lang.foreign.MemorySegment createProviderStub = linker.upcallStub(
     * Shrinking evicts LRU entries immediately. Zero is ignored.
     * until {@link #closeGlobalRuntime} is called.
    /**
}
    public static long createLocalSession(long runtimePtr) {
    /** {@code internal_search_mode}: normal query — decode {@code substraitPlan} as Substrait. */
            long planLen = hasPlan ? planBytes.length : 0L;
     * thrown as a runtime exception by the caller).  
        NativeCall.invokeVoid(SENDER_TERMINATE_EARLY, senderPtr);  
        Exception converted = NativeErrorConverter.convert(e);
        long[] schemaPtrs
    /**  
        // hash_key_indices_ptr, hash_key_indices_len, partition_count,
        long contextId,
    // ---- Memory pool observability and dynamic limit ----  
    private static final MethodHandle PREPARE_FINAL_PLAN;
    /** Returns current memory pool limit in bytes. */  
            int rows = (int) Math.min(written, (long) n);
            var f = call.strArray(segments.stream().map(org.opensearch.index.engine.exec.MonoFileWriterSet::file).toArray(String[]::new));
    /**
        try {  
    }  
            var buf = arena.allocate(ValueLayout.JAVA_LONG, 2);
                "createCollector",  
     * Snapshot the {@code n} heaviest live queries by {@code current_bytes}.
                    ValueLayout.JAVA_LONG,
        // ── Distributed aggregate: prepare partial/final plans ──  
            // Free the Rust-allocated buffer  
                ValueLayout.JAVA_LONG    // filter_max
    private static final MethodHandle CLOSE_SESSION_CONTEXT;
    // ---- Stream operations (no Arena needed — only long args) ----  
                contextId,  
     * would otherwise double-free). Only a Java-side failure before the downcall dispatches
    public static void initTokioRuntimeManager(int cpuThreads) {
    }
            long ptr = call.invoke(  
    /**  
    public static long getMemoryPoolUsage(long runtimePtr) {  
                ValueLayout.ADDRESS,    // sort_fields_ptr (parallel String[] for index.sort.field)
                ValueLayout.JAVA_LONG,
        );
                ValueLayout.JAVA_LONG,  
                so.lens(),
        try (var call = new NativeCall()) {
            );
                readerPtr,
import org.apache.logging.log4j.Logger;
     */
        try (var call = new NativeCall()) {
     */  
        } catch (Throwable t) {
     * coordinator-reduce {@link #registerPartitionStream} uses) instead of the raw producer IPC
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        // i64 df_prepare_final_plan(session_ptr, bytes_ptr, bytes_len)
            );
     * Queries cancelled for less than this duration are not counted in stats.  
    }
            java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(outBytes).order(java.nio.ByteOrder.LITTLE_ENDIAN);  
        long internalSearchBound,
        );
        byte[] substraitPlan,  
     * streaming input on a {@code SessionContextHandle} session under {@code inputId} and  
            logger.debug("Failed to read native memory pool stats", t);
                ValueLayout.ADDRESS,    // files_ptr
                collectDocsStub,
        );
            return call.invoke(SENDER_SEND, senderPtr, arrayPtr, schemaPtr);
            return call.invoke(EXECUTE_LOCAL_PREPARED_PLAN, sessionPtr, contextId);  
                (long) out.capacity(),  
            throw new ExceptionInInitializerError(t);
    private static final MethodHandle FETCH_BY_ROW_IDS;  
                ValueLayout.ADDRESS,  
    }
import org.opensearch.analytics.spi.ShardSortBounds;
                ValueLayout.ADDRESS,
                REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT_FROM_PARTIAL_PLAN,
        CACHE_MANAGER_GET_TOTAL_MEMORY = linker.downcallHandle(
            assert status == 0 : "df_partition_batch_by_hash returned non-zero on success: " + status;  
    }
     * Memtable variant of {@link #registerPartitionStream}: hands across a list of
import java.lang.invoke.MethodHandle;
        try (var call = new NativeCall()) {
        }
    /**
     * @param rowIdsBufAddr memory address of the BigIntVector's data buffer (i64 values)
    private static final MethodHandle SET_SPILL_EXEMPT_CAP_BYTES;  
        UPDATE_CONCURRENCY_GATE = linker.downcallHandle(
    private static final MethodHandle REGISTER_FILTER_TREE_CALLBACKS;
        try (var call = new NativeCall()) {  
        } catch (RuntimeException e) {
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
    private static final MethodHandle DESTROY_CUSTOM_CACHE_MANAGER;
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        NativeHandle.validatePointer(runtimePtr, "runtime");
            throw new IllegalArgumentException(
                cb,
                ValueLayout.JAVA_LONG,
    }  
                (long) partialPlanBytes.length,
        if (partitionCount <= 0) {
                ValueLayout.JAVA_LONG    // planLen
            long result = call.invoke(
        }
        }
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
    public static void executeQueryAsync(
    public static void senderClose(long senderPtr) {
            return new SessionContextHandle(ptr);
     * <p>Output ownership: each returned pair is a heap-allocated FFI struct on the Rust side;
        );  
                ValueLayout.JAVA_LONG  
                rowIdsBufAddr,
    }
        }
            return null;
            FunctionDescriptor.of(
     * non-zero return is interpreted by {@link NativeCall} as a Rust-side error (the message is
        try (var call = new NativeCall()) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,  
     */
                ValueLayout.JAVA_LONG,  
        // void df_close_local_session(session_ptr)
        NativeHandle.validatePointer(runtimePtr, "runtime");  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            lib.find("df_create_reader").orElseThrow(),  
    // ---- Cancellation ----  
        CANCEL_QUERY = linker.downcallHandle(lib.find("df_cancel_query").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
                cb,  
            );  
            var out = call.outBuffer(1024 * 1024);
        long contextId
                segments.stream().mapToLong(org.opensearch.index.engine.exec.MonoFileWriterSet::writerGeneration).toArray()  
     * @param queryConfigPtr pointer to a WireDatafusionQueryConfig struct, or 0 for fallback defaults
     */
 */  
     * Executes the previously prepared final-aggregate plan on a local session.
     */  
        NativeCall.invokeVoid(INIT_RUNTIME_MANAGER, cpuThreads, datanodeMultiplier, coordinatorMultiplier);  
                ValueLayout.ADDRESS      // out_ptr — 3 i64 slots: [min, max, value_kind]
            FunctionDescriptor.ofVoid(  
                ValueLayout.JAVA_BYTE,   // hasPartialAggregate (0/1)  
            throw rethrowConverted(e);
    private static final MethodHandle GET_MEMORY_POOL_STATS;  
                java.lang.invoke.MethodType.methodType(int.class, long.class, int.class, long.class, int.class, int.class)
            long written = call.invoke(QUERY_REGISTRY_TOP_N_BY_CURRENT, seg, (long) n);
        }  
        INIT_RUNTIME_MANAGER = linker.downcallHandle(  
    // ---- Query execution (confined Arena for tableName + plan bytes) ----
    }  
            return call.invoke(CACHE_MANAGER_GET_MEMORY_BY_TYPE, runtimePtr, type.segment(), type.len());  
            lib.find("df_shutdown_runtime_manager").orElseThrow(),  
     * <p>Returns a {@link RegisteredInput} whose {@code pointer} field is always 0 (memtable
            throw new IllegalArgumentException(
        }
     *                            exclude the CombinePartialFinalAggregate optimizer rule  
                ValueLayout.JAVA_LONG,
    private static final MethodHandle CACHE_MANAGER_CLEAR_BY_TYPE;
                ValueLayout.ADDRESS
                ValueLayout.JAVA_LONG,
    public static ShardSortBounds shardSortBounds(long runtimePtr, long shardViewPtr, String columnName) {
        // void df_register_filter_tree_callbacks(createCollector, collectDocs, releaseCollector)  
    private static final MethodHandle CLOSE_LOCAL_SESSION;
     * Forward-compat probe for runtime spill-cap updates. Today the upstream  
        );
    public static void executeQueryAsync(  
     * drained via {@link #streamNext} and freed by {@link #streamClose}.  
            lib.find("df_cache_manager_clear").orElseThrow(),
                ValueLayout.JAVA_LONG,   // shard_view_ptr
            throw new IllegalArgumentException(  
                ValueLayout.ADDRESS,    // sort_orders_ptr (parallel String[] for index.sort.order: "asc"|"desc")  
                ValueLayout.ADDRESS,     // column_name_ptr
        );  
                call.longs(arrayPtrs),
     * group in the shard view. Unlike {@link #canMatch}, this does not short-circuit — a  
        // TODO(PR1): wire to df_clear_offset_index_cache when available  
        try (var call = new NativeCall()) {
     * Positive sentinel returned by {@code df_sender_send} (via {@link #senderSend}) when the  
     * exception types (e.g. CircuitBreakingException, OpenSearchStatusException).
                )
            var table = call.str(tableName);
        long sessionContextHandlePtr,  
                id.segment(),
    /**  
                ValueLayout.JAVA_LONG
            return call.invoke(GET_MEMORY_POOL_LIMIT, runtimePtr);  
            logger.debug("Failed to set min target partitions", t);
        // arrayPtr/schemaPtr come from Arrow Java's C Data export (ArrowArray.memoryAddress()),
        long[] arrayPtrs,  
        NativeHandle.validatePointer(runtimePtr, "runtime");
     *         disagreeing on physical type)
            return result != 0;  
        EXECUTE_LOCAL_PREPARED_PLAN = linker.downcallHandle(
    /**  
    }
    }  
        boolean hasPartialAggregate,
        List<String> sortOrders
            throw new UnsupportedOperationException(
        long storePtr = 0L;  
        } catch (Throwable t) {
    public static boolean cacheManagerGetItemByCacheType(long runtimePtr, String cacheType, String filePath) {
        }  
    static {
     * Fails the sender: pushes an error carrying {@code reason} into the partition stream so the  
            FunctionDescriptor.of(
     * @param filePaths array of absolute file paths
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
                    ValueLayout.JAVA_INT,
 * <h2>Pointer lifecycle (no Arena needed)</h2>
                    ValueLayout.JAVA_INT,
                ValueLayout.ADDRESS,
     * @param substraitBytes Substrait plan bytes
    // ---- Stats collection ----
    public static void cacheManagerAddFiles(long runtimePtr, String[] filePaths) {
     * Creates a local DataFusion session tied to the given global runtime. Returns an opaque
            long result = NativeLibraryLoader.checkResult((long) STREAM_GET_SCHEMA.invokeExact(streamPtr));
    /** Frees the native local session. Tolerates a zero pointer for idempotent close. */  
                ValueLayout.JAVA_LONG,
    /**  
                contextId
            lib.find("df_close_session_context").orElseThrow(),  
        );
                EXECUTE_QUERY,  
                );  
            FREE_METRICS_BUF.invokeExact(dataPtr, len);
    private static final MethodHandle CACHE_MANAGER_CLEAR;
        NativeHandle.validatePointer(sessionPtr, "session");  
import java.lang.foreign.FunctionDescriptor;
     * @param runtimePtr pointer from createGlobalRuntime
    public static void shutdownTokioRuntimeManager() {
                inputArrayPtr,  
            lib.find("df_sender_send").orElseThrow(),  
        try (var call = new NativeCall()) {
        }  
                contextId,
    /**  
                ValueLayout.ADDRESS,
     *     schema_ptr_0, array_ptr_1, schema_ptr_1, ...]}.
public final class NativeBridge {  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
        try (var call = new NativeCall()) {  
        SET_SCOPED_PAGE_INDEX_ENABLED = linker.downcallHandle(
    ) {
                FETCH_BY_ROW_IDS,  
    /**
    /**
        try {
            )  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
     * @return the folded bounds, or {@code null} when no shard-wide range is available  
            MemorySegment out = call.buf(SORT_BOUNDS_SLOTS * Long.BYTES);
            return call.invoke(
        SET_REDUCE_TARGET_PARTITIONS = linker.downcallHandle(
        NativeHandle.validatePointer(readerPtr, "reader");  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
     */  
                ValueLayout.JAVA_LONG,
            long planLen = (long) substraitPlan.length;  
    private static Exception convertNativeError(Throwable t) {  
        REGISTER_PARTITION_STREAM = linker.downcallHandle(
        );
            lib.find("df_fetch_by_row_ids").orElseThrow(),
                arena  
                ValueLayout.JAVA_LONG   // sort_count (0 when index has no sort)
        CACHE_MANAGER_ADD_FILES_WITH_STORE = linker.downcallHandle(
                sessionContextHandlePtr,  
    public static void setCancelStatsThresholdMs(long millis) {  
     * @param dataformatAwareStoreHandle per-format native store handle (null = local, live = use store pointer)  
        }
                ),
            FunctionDescriptor.ofVoid()
            )
            var id = call.str(inputId);
            long found = call.invoke(SHARD_SORT_BOUNDS, runtimePtr, shardViewPtr, cn.segment(), cn.len(), out);
                contextId,  
 * live until explicitly freed by the corresponding close method.</p>  
                ValueLayout.JAVA_LONG
        double admissionThrottle,
    ) {
        }
        // are installed and `df_execute_indexed_query` can dispatch into Java.
    public static void initLogger() {}  
 * <p>Functions return {@code i64}: {@code >= 0} is success, {@code < 0} is a negated pointer
            return new RegisteredInput(ptr, out.toByteArray());
    private static final MethodHandle GET_MEMORY_POOL_LIMIT;
     */
    private static final MethodHandle EXECUTE_LOCAL_PLAN;  
     *
                call.bytes(schemaIpc),  
        NativeHandle.validatePointer(readerPtr, "reader");
                ValueLayout.JAVA_LONG,   // runtime_ptr
            lib.find("df_create_worker_session_context").orElseThrow(),
            // CPU runtime (always present — zeroed when absent)  
import java.util.List;
                p.len(),
        CACHE_MANAGER_CONTAINS_BY_TYPE = linker.downcallHandle(
            call.invoke(SET_MEMORY_POOL_LIMIT, runtimePtr, newLimitBytes);
        } catch (Throwable t) {  
     * Folds the shard-wide min/max of {@code columnName} across every parquet file and row
        try (var call = new NativeCall()) {
        long contextId,
     *
                out.getAtIndex(ValueLayout.JAVA_LONG, 0),
     * the provider by name, so the logical-named registration is what makes the FINAL resolve
import org.opensearch.be.datafusion.stats.DataFusionStats;
        }
        }
                out.lenOut()  
    }  
    public static long getMemoryPoolLimit(long runtimePtr) {
                return null; // no metrics available
     */
     *
    public static void setSpillExemptCapBytes(long bytes) {
     * Frees a native {@code SessionContext} handle. Invoked from  
        if (arrayPtrs.length != schemaPtrs.length) {
    }
            return call.invoke(CREATE_LOCAL_SESSION, runtimePtr);
     * @param handlePtr pointer returned by {@link #createSessionContext}  
        byte[] planBytes  
    /**
     *     done. A Rust-side error throws via {@link NativeCall}.
            // Task monitors  
    /**
        NativeHandle.validatePointer(runtimePtr, "runtime");  
            long result;
                ValueLayout.ADDRESS,  
                colNames.lens(),
     * input schema by lowering the producer-side {@code partialPlanBytes}. Returns the native
            } catch (IllegalStateException e) {
    public static void closeLocalSession(long sessionPtr) {
     * {@link SessionContextHandle} pointer instead of a {@code LocalSession} pointer, so the M1
        if (sortFields.size() != sortOrders.size()) {
    public static void setScopedPageIndexEnabled(boolean enabled) {
                    ValueLayout.JAVA_INT
            )  
            lib.find("df_get_memory_pool_stats").orElseThrow(),
                releaseProvider,
                (long) partialPlanBytes.length  
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,  
    public static long registerPartitionStreamOnSessionContextFromPartialPlan(
        try (var call = new NativeCall()) {
     * Executes a Substrait plan against the configured SessionContext.
            lib.find("df_close_global_runtime").orElseThrow(),
     * MUST match {@code SENDER_SEND_RECEIVER_DROPPED} in {@code ffm.rs}.
     */
            NativeHandle.validatePointer(streamPtr, "stream");
    public static void streamNext(long runtimePtr, long streamPtr, ActionListener<Long> listener) {  
                ValueLayout.JAVA_LONG
        NativeCall.invokeVoid(CLOSE_SESSION_CONTEXT, ptr);  
     *                   {@code output_ordering} to the optimizer, and indexed path's segment-iteration
                ValueLayout.ADDRESS,
                id.len(),
     * Executes a Substrait plan on the session, returning an opaque stream pointer. The stream is
        }
        REGISTER_MEMTABLE = linker.downcallHandle(
            FunctionDescriptor.of(  
                sessionContextHandlePtr,
                ),  
                ValueLayout.ADDRESS,
     * QTF fetch phase: reads specific rows by global row ID from parquet.
     * @throws IllegalStateException if the FFM function returns a non-zero error code
            FunctionDescriptor.of(
    public record RegisteredInput(long pointer, byte[] schemaIpc) {
            lib.find("df_sender_terminate_early").orElseThrow(),  
                queryConfigPtr,  
import java.lang.foreign.Arena;
                call.longs(schemaPtrs),
        );
        } catch (Throwable t) {
    /**
        NativeHandle.validatePointer(senderPtr, "sender");  
        );
                ValueLayout.JAVA_LONG,
        }
        Linker linker = Linker.nativeLinker();
     *  
        NativeStoreHandle dataformatAwareStoreHandle,
    private static final MethodHandle SET_MEMORY_GUARD_THRESHOLDS;
        QUERY_REGISTRY_TOP_N_BY_CURRENT = linker.downcallHandle(
                FunctionDescriptor.of(
                table.len(),
     * Extracts execution metrics from the stream's physical plan as JSON bytes.  
        );
        );
        String tableName,
     * Sets the spill-exemption cap in bytes — the total in-flight allocation allowed through the  
    public static RegisteredInput registerPartitionStream(long sessionPtr, String inputId, byte[] partialPlanBytes) {
import org.opensearch.nativebridge.spi.NativeLibraryLoader;  
     * Enable or disable the scoped page-index feature.
     * @param substraitBytes Substrait plan bytes
            throw new IllegalArgumentException("arrayPtr must be non-zero");
    ) {  
        }
    }
        );
        // i64 df_update_concurrency_gate(gate_name_ptr, gate_name_len, new_max_permits)  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)  
    private static final MethodHandle EXECUTE_QUERY;
            lib.find("df_cache_manager_get_total_memory").orElseThrow(),  
        int treeShapeOrdinal,  
    private static final MethodHandle PREPARE_PARTIAL_PLAN;  
    }
            lib.find("df_create_local_session").orElseThrow(),  
     */
            }
     */
        NativeHandle.validatePointer(sessionPtr, "session");  
        }
                call.longs(schemaPtrs),
            );
                CREATE_SESSION_CONTEXT_INDEXED,
                ValueLayout.ADDRESS,    // files_len_ptr  
     * @return the sender pointer (non-zero); caller must free via {@link #senderClose} when done.
            long result = NativeLibraryLoader.checkResult((long) STREAM_NEXT.invokeExact(streamPtr));  
        );  
            lib.find("df_close_local_session").orElseThrow(),  
        String inputId,
                ValueLayout.JAVA_LONG,
    }
            );
        // void df_sender_close(sender_ptr)
        SET_SPILL_LIMIT = lib.find("df_set_spill_limit")  
            );
    /**  
            var p = call.str(path);  
        try (var call = new NativeCall()) {
    private static final MethodHandle CACHE_MANAGER_ADD_FILES_WITH_STORE;
     *                            exclude the CombinePartialFinalAggregate optimizer rule  
        );  
        // out_ptr, out_cap, out_len)  
                ValueLayout.JAVA_LONG,
        // i64 df_native_node_stats(out_ptr, out_cap)  
        try (var call = new NativeCall()) {  
        SENDER_SEND = linker.downcallHandle(
                id.len(),  
    }
    private static final MethodHandle SENDER_SEND;
    private static final MethodHandle REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT;
        // i64 df_execute_local_prepared_plan(session_ptr, context_id)
                out.lenOut()
    /** Closes the sender, signalling end-of-input. Tolerates a zero pointer. */  
    /**  
    }  
        try (var call = new NativeCall()) {
            logger.debug("Failed to set memory guard thresholds", t);  
        );
                    java.lang.foreign.MemorySegment.class,  
        }
            return new SessionContextHandle(ptr);
            )  
        NativeCall.invokeVoid(SENDER_CLOSE, senderPtr);
                "collectDocs",
            call.invoke(  
import org.apache.logging.log4j.LogManager;
    public static final long CAN_MATCH_NO = 0L;  
            lib.find("df_set_scoped_page_index_enabled").orElseThrow(),
 * compatible open source license.
            );
     * ({@code typesMatch} in {@code DatafusionReduceSink}) validates fed batches against this
    /**
        int rowIdsCount,
            lib.find("df_cache_manager_add_files").orElseThrow(),
                taskMonitors.put(op.key(), StatsLayout.readTaskMonitor(seg, op.key()));  
     *  
                ValueLayout.ADDRESS,
     */
     */  
            return call.invoke(
     * on the next try_grow.
 *
    /**
    }  
                ValueLayout.JAVA_LONG,  // runtime_ptr  
            return call.invoke(CAN_MATCH, runtimePtr, shardViewPtr, cn.segment(), cn.len(), filterMin, filterMax);  
    }  
     * can build a {@code MemTable} in one shot. Schema is derived by lowering the producer-side
        try (var call = new NativeCall()) {
        }  
            )  
            MethodHandle createProvider = lookup.findStatic(  
     * native pointer freed by {@link #closeLocalSession}.  
    private static final MethodHandle CLEAR_SCOPED_PAGE_INDEX_CACHE;
            Class<?> cb = org.opensearch.be.datafusion.indexfilter.FilterTreeCallbacks.class;  
        if (dataformatAwareStoreHandle != null) {
    }  
import java.lang.foreign.MemorySegment;
                ValueLayout.ADDRESS,     // table_name_ptr
    }
            var cn = call.str(columnName);  
    }  
        try (var call = new NativeCall()) {  
    }
     * @param tableName the logical table name (alias/pattern) to register the table under  
    private static final MethodHandle CREATE_CACHE;  
        NativeCall.invokeVoid(STREAM_CLOSE, streamPtr);
        long readerPtr,
            throw new IllegalArgumentException("n must be non-negative: " + n);
    /**  
    /**
            )
     *         with at most {@code n} entries.
        } catch (Throwable t) {
            // correct per-query FilterDelegationHandle in FilterTreeCallbacks.BINDINGS.
 *
                ValueLayout.ADDRESS,
        try (var call = new NativeCall()) {  
        );
            FunctionDescriptor.of(
                PARTITION_BATCH_BY_HASH,
    public static void closeDatafusionReader(long ptr) {
        SHUTDOWN_RUNTIME_MANAGER = linker.downcallHandle(
            lib.find("df_execute_with_context").orElseThrow(),
    // ---- Per-query registry top-N snapshot ----
    }
     */
            lib.find("df_cache_manager_update_size_limit").orElseThrow(),  
        try (var call = new NativeCall()) {
        } catch (Throwable t) {
                delegatedPredicateCount,
     *
                runtimePtr,  
                ValueLayout.JAVA_LONG,  
     * that cannot be safely mutated through {@code Arc<DiskManager>} once the
            );  
                return null;
     * The plan is stored on the Rust handle for later execution.
        );
                ValueLayout.JAVA_LONG  
        );
        executeQueryAsync(readerPtr, tableName, substraitPlan, runtimePtr, contextId, queryConfigPtr, INTERNAL_SEARCH_OFF, 0L, listener);
    /**
            );
     */
            listener.onResponse(result);  
        Exception ex = t instanceof Exception e ? e : new RuntimeException(t);
        if (SET_SPILL_LIMIT == null) {
     * @param columns column names to read
                releaseCollector,
     * Shrinking evicts LRU entries immediately. Zero is ignored.
                ValueLayout.JAVA_LONG,  
                ValueLayout.JAVA_LONG,   // return: 1=Yes, 0=No, -1=Unknown
    }
     * @param planBytes Substrait plan bytes for multi-index schema widening (empty = skip)
        List<String> sortFields,  
        NativeCall.invokeVoid(CLOSE_GLOBAL_RUNTIME, ptr);  
        // col_names_ptr, col_names_len_ptr, col_names_count, runtime_ptr, context_id)
            call.invoke(CACHE_MANAGER_CLEAR, runtimePtr);
                ValueLayout.JAVA_BYTE,   // deletedDocFilteringRequired (0/1)
            return;
        if (n == 0) {
     * Clears the process-global scoped page-index cache (drops entries + resets
                queryConfigPtr,
        try (var call = new NativeCall()) {
     *  
        );
     * Freed by {@link #closeDatafusionReader}.
                readerPtr,
     * @param segments per-segment metadata — each carries a single filename and writer generation
                arena
        }
        try (var call = new NativeCall()) {
     * @param path     shard data directory
            var gens = call.longs(
        if (rowIdsBufAddr == 0) {  
    /**  
            listener.onResponse(result);
                ValueLayout.ADDRESS
            throw new IllegalArgumentException("schemaPtr must be non-zero");
        // i64 df_sender_fail(sender_ptr, reason_ptr, reason_len)
    public static void clearScopedPageIndexCache() {
        CLEAR_SCOPED_PAGE_INDEX_CACHE = linker.downcallHandle(  
        try (var call = new NativeCall()) {
                    ValueLayout.JAVA_LONG,  
     * happy path where Rust's {@code execute_with_context} consumes the handle itself.
            MethodHandle collectDocs = lookup.findStatic(  
     *
            )  
                throw new IllegalStateException(
import org.opensearch.be.datafusion.NativeErrorConverter;  
    public static void executeWithContextAsync(SessionContextHandle sessionContext, byte[] substraitPlan, ActionListener<Long> listener) {
            lib.find("df_set_column_index_cache_limit").orElseThrow(),
    // ---- Coordinator-reduce exports ----
            );
 * and {@code executeQueryAsync} are opaque {@code long} values — Rust heap addresses cast to
                    ValueLayout.ADDRESS,
        long rowIdsBufAddr,
 * <h2>Arena usage</h2>
                ValueLayout.JAVA_LONG,
        try (var call = new NativeCall()) {
            long len = outLen.get(ValueLayout.JAVA_LONG, 0);  
        // i64 df_shard_sort_bounds(runtime_ptr, shard_view_ptr, column_name_ptr, column_name_len, out_ptr)
    }  
     * @param queryConfigPtr pointer to a WireDatafusionQueryConfig struct, or 0 for fallback defaults
    ) {  
        }  
    private static final MethodHandle REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT_FROM_PARTIAL_PLAN;
     * still owns and must close them via Arrow C Data Interface after this call returns.  
                (long) out.capacity(),  
     * <p>Rust's {@code execute_with_context} takes ownership of the {@code SessionContext} via  
     * {@link SessionContextHandle#doCloseNative()} ()} will free it.  
        // out_ptr, out_cap, out_len)
            var dir = call.str(spillDir);
    /**
            var file = call.str(filePath);
     *  
    }  
                cb,
                    + sortOrders.size()
    private static final MethodHandle CREATE_LOCAL_SESSION;  
        }
                runtimePtr,
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,
        try {
        // Same signature as df_register_memtable but for SessionContextHandle (shard-scan path).
        }
        STREAM_CLOSE = linker.downcallHandle(lib.find("df_stream_close").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
import java.lang.foreign.Linker;  
                ValueLayout.JAVA_LONG,   // internal_search_mode
                so.ptrs(),  
        );
        }
     */
            return new RegisteredInput(ptr, out.toByteArray());  
                planLen
     * Independent of {@link #stats(long)} which calls {@code df_stats} for plugin stats.
            if (outBytes.length != partitionCount * pairBytes) {  
            call.invoke(SET_COLUMN_INDEX_CACHE_LIMIT, sizeLimitBytes);
                (long) arrayPtrs.length,  
 * {@code i64}. They are <b>not</b> {@code MemorySegment}s and do not require an Arena. They
 *  
        }
            );  
                internalSearchBound
        } catch (Throwable t) {  
                collectDocs,  
    public static void prepareFinalPlan(long sessionPtr, byte[] substraitBytes) {  
        long runtimePtr,  
                (long) (executionSpill * 1000),
                ValueLayout.JAVA_BYTE,   // hasPartialAggregate (0/1)
            try {
            FunctionDescriptor.of(
                ValueLayout.ADDRESS,    // table_path_ptr  
        // i64 df_fetch_by_row_ids(shard_view_ptr, row_ids_buf_ptr, row_ids_count,
    public static final long CAN_MATCH_UNKNOWN = 2L;
        if (schemaPtr == 0) {  
     * that both success and native-error paths skip {@code df_close_session_context} (which  
     *
     * <p>One FFM call: Java allocates an {@code n × ENTRY_BYTES} segment, Rust
                createProviderStub,
import java.util.HashMap;  
    public static void cancelQuery(long contextId) {  
            call.invoke(DF_NATIVE_NODE_STATS, seg, 32L);
        }  
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG,   // runtime_ptr
    public static void cacheManagerRemoveFiles(long runtimePtr, String[] filePaths) {
     * @param storePtr Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer (from TieredStorageBridge.getObjectStoreBoxPtr)  
     * native session settled on after lowering.  
        PREPARE_PARTIAL_PLAN = linker.downcallHandle(
        );
        SET_CANCEL_STATS_THRESHOLD_MS = linker.downcallHandle(
            }  
                ValueLayout.JAVA_LONG,  
                ValueLayout.JAVA_LONG,  
     * Prepares a partial-aggregate physical plan on the session context handle.  
        }  
            var query = call.str(sql);
        // i64 df_stats(runtime_ptr, out_ptr, out_cap)  
        );
            FunctionDescriptor.of(
    public static void setOffsetIndexCacheLimit(long sizeLimitBytes) {
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_LONG,  // store_ptr
            return;
        String inputId,
    /**
    /** Sets the memory pool limit at runtime. Takes effect for new allocations only. */
    public static void setReduceTargetPartitions(int value) {  
     * Updates the spill-temp-directory cap at runtime. Throws
 *
                (byte) (requestsRowIds ? 1 : 0),  
            var fragmentExecutorGate = StatsLayout.readPartitionGate(seg, "fragment_executor_gate", "fragment_executor_gate");
                ValueLayout.JAVA_LONG,
    ) {
        }
        FETCH_BY_ROW_IDS = linker.downcallHandle(  
    }
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,    // files_ptr
    }
     * @return the sender pointer (non-zero); caller must free via {@link #senderClose} when  
                java.lang.invoke.MethodType.methodType(  
                ValueLayout.JAVA_LONG,   // column_name_len
            throw rethrowConverted(e);
            call.invoke(CACHE_MANAGER_REMOVE_FILES, runtimePtr, f.ptrs(), f.lens(), f.count());
    public static void streamClose(long streamPtr) {
    }
        // i64 df_sql_to_substrait(shard_ptr, table_ptr, table_len, sql_ptr, sql_len, runtime_ptr, out_ptr, out_cap, out_len)
            var out = call.outBuffer(64 * 1024);  
        // array_ptrs, schema_ptrs, n_batches,  
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,
    public static long createGlobalRuntime(long memoryLimit, long cacheManagerPtr, String spillDir, long spillLimit) {  
        // caller step required — as soon as this class is loaded, callbacks
            )  
    /**  
            MethodHandle releaseProvider = lookup.findStatic(
        long runtimePtr,
    /**
     * thread hits a mid-stream failure (e.g. a spill-read error) that truncates the partition —  
     * @return a non-null map of {@code contextId → metrics}, possibly empty,
                call.bytes(schemaIpc),
     */
            var lookup = java.lang.invoke.MethodHandles.lookup();
        SET_COLUMN_INDEX_CACHE_LIMIT = linker.downcallHandle(
    }
        NativeCall.invokeVoid(SHUTDOWN_RUNTIME_MANAGER);  
        SET_MEMORY_POOL_LIMIT = linker.downcallHandle(  
                ValueLayout.JAVA_LONG,  // object store ptr  
        try {
            lib.find("df_register_memtable_on_session_context").orElseThrow(),
     * {@code partialPlanBytes}; native takes ownership of all FFI structs on success.
        double admissionReject,  
                ValueLayout.JAVA_LONG    // internal_search_bound  
            call.invoke(CREATE_CACHE, cacheManagerPtr, type.segment(), type.len(), sizeLimit, eviction.segment(), eviction.len());
            var name = call.str(gateName);  
     */
                ValueLayout.JAVA_LONG,  
            var keys = call.ints(hashKeyIndices);
    public static void closeGlobalRuntime(long ptr) {
     *
        }
            lib.find("df_create_session_context_indexed").orElseThrow(),
            logger.debug("Failed to set spill exempt cap bytes", t);
     * sender pointer (freed by {@link #senderClose}) and the Arrow IPC-encoded schema the
     * When {@code internalSearchMode} is {@link #INTERNAL_SEARCH_OFF}, {@code substraitPlan} is
        );
     * Load metadata for files through the given TieredObjectStore.
     * Returns true if the loaded native library exports {@code df_set_spill_limit}.  
                readerPtr,
        CACHE_MANAGER_GET_MEMORY_BY_TYPE = linker.downcallHandle(  
    public static void senderTerminateEarly(long senderPtr) {
    public static void cacheManagerClear(long runtimePtr) {
        // Hash-partitions one Arrow C Data batch into N output batches via DataFusion's  
                (long) substraitPlan.length,
     * The plan is stored on the Rust session for later execution via  
     * EOF after it drains them.
            );
        );  
    private NativeBridge() {}
     * schema must match this declaration exactly.
        if (converted instanceof RuntimeException rte) {  
     */  
        );
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
                colNames.count(),  
     * {@link NativeErrorConverter} to translate known native error patterns into OpenSearch  
        DF_NATIVE_NODE_STATS = linker.downcallHandle(
        );
        try (var call = new NativeCall()) {
                readerPtr,
        }
                    + ") must have the same length"
                ValueLayout.JAVA_LONG,
     * {@link SessionContextHandle#doCloseNative()} ()} on error / never-executed paths; not called on the
     * zero-byte trackers are filtered on the Rust side. Order within the
                createCollectorStub,  
        try (var call = new NativeCall()) {
        PREPARE_FINAL_PLAN = linker.downcallHandle(
     * rides the success half of the native return contract ({@code >= 0} success, {@code < 0}  
     * returns the producer-side {@code PartitionStreamSender} pointer the caller drives via
    }  
                long ctxId = QueryRegistryLayout.readContextId(seg, i);
                f.lens(),  
                REGISTER_PARTITION_STREAM,
            lib.find("df_stream_get_schema").orElseThrow(),
    /** Clears the scoped OffsetIndex (projection) cache. */
            lib.find("df_stream_next").orElseThrow(),
    public static final long INTERNAL_SEARCH_SEQ_NO_ABOVE = 2L;  
        );
                id.segment(),  
                ValueLayout.JAVA_LONG,
            long result = (long) STREAM_GET_METRICS.invokeExact(streamPtr, outPtr, outLen);
            )
     * native side takes ownership of both FFI structs. Returns {@code 0} on a normal send or
                ValueLayout.JAVA_LONG,
    private static final MethodHandle CACHE_MANAGER_REMOVE_FILES;  
     * header.
            return call.invoke(GET_MEMORY_POOL_USAGE, runtimePtr);
                CREATE_SESSION_CONTEXT,
            var table = call.str(tableName);  
        try (var arena = Arena.ofConfined()) {  
                query.len(),  
            return new ShardSortBounds(  
            }
        try (var call = new NativeCall()) {  
            lib.find("df_create_custom_cache_manager").orElseThrow(),
     */
        CACHE_MANAGER_CLEAR = linker.downcallHandle(
            lib.find("df_cache_manager_clear_by_type").orElseThrow(),
            lib.find("df_set_memory_pool_limit").orElseThrow(),
            SET_MIN_TARGET_PARTITIONS.invokeExact((long) value);
     * schema, and downstream callers decode it once into an Arrow {@link org.apache.arrow.vector.types.pojo.Schema}.
    // ---- DataFusion runtime (confined Arena for spillDir string only) ----
                    int.class,  
import java.lang.foreign.ValueLayout;  
                id.segment(),
        try (var call = new NativeCall()) {
            );
        );
                table.segment(),
     * @param queryConfigPtr pointer to a WireDatafusionQueryConfig struct, or 0 for fallback defaults
                ValueLayout.JAVA_LONG,
                query.segment(),
     * @return a flat array of {@code 2 * partitionCount} longs: {@code [array_ptr_0,  
    public static final long INTERNAL_SEARCH_OFF = 0L;
            )  
    }  
        // i64 df_partition_batch_by_hash(input_array_ptr, input_schema_ptr,  
     * Iterates all files in the shard view internally (Rust side).  
        CREATE_READER = linker.downcallHandle(
            FunctionDescriptor.of(
                FunctionDescriptor.of(
        } catch (Throwable t) {
            return call.invoke(
            var type = call.str(cacheType);
            lib.find("df_register_memtable").orElseThrow(),  
                ValueLayout.JAVA_LONG,   // filter_min  
        // i64 df_cache_manager_clear_by_type(runtime_ptr, type_ptr, type_len)  
            var seg = call.buf((int) bytes);  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
     *
            return result;
    }
            );
                ValueLayout.JAVA_LONG,   // table_name_len
            throw new IllegalArgumentException("input array and schema pointers must be non-zero");
            var type = call.str(cacheType);
                out.getAtIndex(ValueLayout.JAVA_LONG, 2) != 0L,  
        ActionListener<Long> listener  
                ValueLayout.JAVA_LONG,  
            lib.find("df_sql_to_substrait").orElseThrow(),  
            call.invoke(SET_SPILL_LIMIT, runtimePtr, newLimitBytes);
     * {@code Box::from_raw} on entry, regardless of whether the rest of the call then succeeds or
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
            // IO runtime (always present — zeroed if not yet initialized)  
            var id = call.str(inputId);  
     * Primarily for testing — production uses the default (10 000 ms).
        REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT = linker.downcallHandle(  
import java.util.LinkedHashMap;
                    long.class
                ValueLayout.JAVA_LONG,  
            byte[] outBytes = out.toByteArray();
    private static final MethodHandle CACHE_MANAGER_CONTAINS_BY_TYPE;
        );
                ValueLayout.ADDRESS,
                    ValueLayout.JAVA_INT,
        // ── Coordinator-reduce bindings ──  
                ValueLayout.JAVA_LONG,   // plan_len
    public static void clearOffsetIndexCache() {
        CLOSE_READER = linker.downcallHandle(lib.find("df_close_reader").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));  
        } catch (Exception e) {
            )
                ValueLayout.JAVA_LONG  
     */  
     * @param runtimePtr pointer to the DataFusion runtime
    /**
    private static RuntimeException rethrowConverted(RuntimeException e) {
                ValueLayout.ADDRESS,    // sort_orders_len_ptr
                (long) (executionCritical * 1000)  
    private static final MethodHandle REGISTER_MEMTABLE;
     */  
        }
    }
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
                ValueLayout.JAVA_LONG  
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG,
    }  
        );
    public static void destroyCustomCacheManager(long ptr) {
     * native sender pointer (or 0 for memtable) plus the Arrow IPC-encoded schema the native
        NativeHandle.validatePointer(sessionPtr, "session");  
        String tableName,
     * When the upstream PR converting that field to {@code Arc<AtomicU64>}
     * using DataFusion's {@code BatchPartitioner}. The row-to-partition mapping matches
                (long) (admissionReject * 1000),
    public static long cacheManagerGetTotalMemoryConsumed(long runtimePtr) {
     * Row IDs are passed as a direct buffer pointer (zero-copy from BigIntVector's ArrowBuf).
    ) {
     * with no transport-only intermediate.  
        // DataFusion 53.1.0 does not support runtime spill resize through the public  
     */
        );
                "createDatafusionReader: sortFields ("
    private static final MethodHandle STREAM_CLOSE;
            try {
            lib.find("df_query_registry_top_n_by_current").orElseThrow(),
    private static final Logger logger = LogManager.getLogger(NativeBridge.class);
     * @return opaque stream pointer
            lib.find("df_create_session_context").orElseThrow(),
                ValueLayout.JAVA_LONG,   // context_id  
            lib.find("df_create_cache").orElseThrow(),  
    // ---- Tokio runtime management (no Arena needed — no string/buffer args) ----  
                call.bytes(partialPlanBytes),  
     * freed by {@link #streamClose}.
     * <p>Returns one of {@link #CAN_MATCH_NO}, {@link #CAN_MATCH_YES}, {@link #CAN_MATCH_UNKNOWN} —
        }  
    private static final MethodHandle SET_REDUCE_TARGET_PARTITIONS;
                runtimePtr,
                "releaseCollector",  
     */  
                cb,
            return NativeLibraryLoader.checkResult((long) CREATE_CUSTOM_CACHE_MANAGER.invokeExact());
     * @param hasPartialAggregate whether the fragment contains a partial aggregate — signals Rust to
                fragmentExecutorGate,
        }
     * agree on assignments.  
        // partial_plan_ptr, partial_plan_len,
                FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT),
    /** Sets the memory guard thresholds (0.0–1.0): admission throttle, admission reject, execution spill, execution critical. */  
        }
    private static final MethodHandle PARTITION_BATCH_BY_HASH;  
        String tableName,
            var searchStats = StatsLayout.readSearchStats(seg);
                releaseCollectorStub
    }
            call.invoke(STATS, runtimePtr, seg, StatsLayout.LAYOUT.byteSize());
                ValueLayout.JAVA_LONG,  
                call.longs(arrayPtrs),  
                out.data(),
 */
                ValueLayout.JAVA_LONG,  
    private static final MethodHandle REGISTER_MEMTABLE_ON_SESSION_CONTEXT;  
import java.util.Map;  
            FunctionDescriptor.of(
                sessionPtr,
     * @param tableName the logical table name (alias/pattern) to register the table under
     * Creates a SessionContext with the default ListingTable registered.  
                out.put(ctxId, QueryRegistryLayout.readMetrics(seg, i));  
    /**
            FunctionDescriptor.of(
            )  
     * directly into the caller's final type ({@link QueryExecutionMetrics})
        // Returns the PartitionStreamSender pointer (cast to i64) for the M2 hash-shuffle worker.
                (long) rowIdsCount,  
    }
            long ptr = call.invoke(
    private static final MethodHandle STREAM_GET_METRICS;
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();  
            throw rethrowConverted(e);
     *                   the attached cancellation token. Pass {@code 0} to disable tracking.  
            lib.find("df_get_memory_pool_usage").orElseThrow(),
    public static void setMinTargetPartitions(int value) {  
            Map<Long, QueryExecutionMetrics> out = new HashMap<>(rows);  
        byte[] substraitPlan,
    public static long canMatch(long runtimePtr, long shardViewPtr, String columnName, long filterMin, long filterMax) {  
                ValueLayout.JAVA_LONG,
        } catch (Throwable t) {
        }
     * {@code internalSearchBound} as the {@code __row_id__} value or the {@code _seq_no} floor.  
        boolean deletedDocFilteringRequired,  
            lib.find("df_cache_manager_add_files_with_store").orElseThrow(),  
            lib.find("df_sender_fail").orElseThrow(),  
    }
     * 85% spill gate by spillable consumers so they can finish spilling. Live-tunable; takes effect
            var sf = call.strArray(sortFields.toArray(String[]::new));
            call.invoke(CACHE_MANAGER_UPDATE_SIZE_LIMIT, runtimePtr, type.segment(), type.len(), newLimit);
import org.opensearch.nativebridge.spi.NativeCall;
            FunctionDescriptor.of(
     * {@code NativeLibraryLoader.checkResult}, which reads them as negated error pointers.
        }
            );
     * This pointer is <b>not</b> a MemorySegment — it's a Rust heap address that lives  
    public static long registerPartitionStreamOnSessionContext(long sessionContextHandlePtr, String inputId, byte[] schemaIpc) {  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
                ValueLayout.JAVA_LONG,
    /** {@link #canMatch} status: undeterminable (no statistics, unreadable footer) — keep the shard. */  
        long queryConfigPtr,  
                (byte) out.getAtIndex(ValueLayout.JAVA_LONG, 3)
                keys,
     * {@code -error_ptr}), so {@code checkResult} passes it through without throwing.
                ValueLayout.ADDRESS,
        SHARD_SORT_BOUNDS = linker.downcallHandle(  
            lib.find("df_register_partition_stream_on_session_context_from_partial_plan").orElseThrow(),
            lib.find("df_free_metrics_buf").orElseThrow(),
        STATS = linker.downcallHandle(
        // partial_plan_ptr, partial_plan_len,
        try (var call = new NativeCall()) {
    public static void setMemoryPoolLimit(long runtimePtr, long newLimitBytes) {
            lib.find("df_execute_local_prepared_plan").orElseThrow(),  
        SQL_TO_SUBSTRAIT = linker.downcallHandle(
                createProvider,
        }
    public static Map<Long, QueryExecutionMetrics> getTopNQueriesByMemory(int n) {  
            return new long[] { buf.getAtIndex(ValueLayout.JAVA_LONG, 0), buf.getAtIndex(ValueLayout.JAVA_LONG, 1) };  
                ValueLayout.ADDRESS,
     * decoded as a Substrait plan (normal search). When it is {@link #INTERNAL_SEARCH_BY_ROW_ID}  
        // i64 df_sender_send(sender_ptr, array_ptr, schema_ptr)
        } catch (RuntimeException e) {  
     * Hash-partitions one Arrow C Data input batch into {@code partitionCount} output batches  
                (long) out.capacity(),
    private static final MethodHandle CREATE_SESSION_CONTEXT;
     * derives the table schema from the producer's PARTIAL Substrait plan (the same derivation the  
                sf.lens(),
    public static byte[] streamGetMetrics(long streamPtr) {
    public static long createCustomCacheManager() {
     * ownership transfers to the caller. The caller imports each pair via  
                runtimePtr,  
                    + sortFields.size()
            )  
        CREATE_CUSTOM_CACHE_MANAGER = linker.downcallHandle(  
     * Sets the cancellation stats threshold in milliseconds.
        DESTROY_CUSTOM_CACHE_MANAGER = linker.downcallHandle(
    public static byte[] sqlToSubstrait(long readerPtr, String tableName, String sql, long runtimePtr) {
    /** Convenience overload with default 1.5x multipliers for both gates. */  
    /**
                (byte) (hasPartialAggregate ? 1 : 0),  
                    addr,  
     * or {@link #INTERNAL_SEARCH_SEQ_NO_ABOVE}, the native side ignores {@code substraitPlan} and
                // Handle closed between check and extraction — use default (local)
            )
    /** Number of i64 slots {@code df_shard_sort_bounds} writes: [min, max, hasNulls, valueKind]. */
                treeShapeOrdinal,
    private static final MethodHandle GET_MEMORY_POOL_USAGE;
                ValueLayout.JAVA_LONG,   // runtime_ptr
     * Gracefully terminates one partition stream without cancelling the query. Any blocked sender  
                    long.class,
        try {
    private static final MethodHandle FREE_METRICS_BUF;  
        return NativeErrorConverter.convert(ex);
                ValueLayout.JAVA_LONG,
    public static SessionContextHandle createSessionContext(
     * Registers an input partition stream on the session under {@code inputId}, deriving the  
        return SET_SPILL_LIMIT != null;  
        try (var arena = Arena.ofConfined()) {
                searchStats  
        }  
        try (var call = new NativeCall()) {  
            int pairBytes = 16;
            lib.find("df_set_spill_exempt_cap_bytes").orElseThrow(),
                arena
        try {  
    private static final MethodHandle STATS;  
        // Hand the five filter-tree upcall stubs to Rust now. No explicit  
     * Decodes directly from the MemorySegment — no intermediate long[].
     * Creates a worker-mode SessionContext: no shard view, no listing table, no parquet  
        // i64 df_query_registry_top_n_by_current(out_ptr, cap_entries)  
     *
    private static final MethodHandle SHARD_SORT_BOUNDS;  
     * the survivors as {@link QueryRegistryLayout} entries. Completed and  
            var outPtr = arena.allocate(ValueLayout.ADDRESS);  
 * this file be licensed under the Apache-2.0 license or a
        // i64 df_register_partition_stream_on_session_context(session_ctx_handle_ptr,  
            call.invoke(PREPARE_PARTIAL_PLAN, handlePtr, call.bytes(substraitBytes), (long) substraitBytes.length);  
            .map(
                (long) schemaIpc.length
                ValueLayout.ADDRESS,
                p.segment(),  
            FunctionDescriptor.of(
     * already-exported Arrow C Data batches in two parallel pointer arrays so the native side  
        // i64 df_execute_local_plan(session_ptr, substrait_ptr, substrait_len, context_id)
    public static void clearColumnIndexCache() {  
        SET_MEMORY_GUARD_THRESHOLDS = linker.downcallHandle(  
     * Sets the byte budget of the process-global scoped OffsetIndex cache.
            boolean hasPlan = planBytes != null && planBytes.length > 0;  
        try (var call = new NativeCall()) {
        NativeHandle.validatePointer(runtimePtr, "runtime");  
    private static final MethodHandle SET_CANCEL_STATS_THRESHOLD_MS;
    private static final MethodHandle SENDER_FAIL;
        SENDER_CLOSE = linker.downcallHandle(lib.find("df_sender_close").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
            java.lang.foreign.MemorySegment collectDocsStub = linker.upcallStub(
            lib.find("df_cache_manager_get_memory_by_type").orElseThrow(),
            for (int i = 0; i < rows; i++) {
        NativeCall.invokeVoid(CLOSE_LOCAL_SESSION, sessionPtr);
                "df_set_spill_limit not available in the loaded native library; spill cap is fixed at startup"  
                ValueLayout.JAVA_LONG,
    /**
        byte[] partialPlanBytes,
        CACHE_MANAGER_CLEAR_BY_TYPE = linker.downcallHandle(
        }  
            return call.invoke(EXECUTE_LOCAL_PLAN, sessionPtr, call.bytes(substrait), (long) substrait.length, contextId);
            // All five callbacks now receive contextId (long) as their first parameter.  
     * <p>
        try (var call = new NativeCall()) {
        long readerPtr,
        }  
            var seg = call.buf(32);  
     * Pair returned from {@link #registerPartitionStream} / {@link #registerMemtable}: the
     *
    }  
     */
        }
        NativeCall.invokeVoid(DESTROY_CUSTOM_CACHE_MANAGER, ptr);  
    }
     *  
            var id = call.str(inputId);
        // i64 df_create_cache(mgr_ptr, type_ptr, type_len, size_limit, eviction_ptr, eviction_len)
            var cacheStats = StatsLayout.readCacheStats(seg);
                REGISTER_MEMTABLE,
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            throw new IllegalArgumentException("rowIdsBufAddr must be non-zero");
        try {
        }
                id.len(),
            FunctionDescriptor.of(  
package org.opensearch.be.datafusion.nativelib;
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)  
     */  
     * {@link UnsupportedOperationException} when the loaded native library does not
            return bytes;
        NativeHandle.validatePointer(readerPtr, "reader");
        }  
                out.data(),
    private static final MethodHandle SET_MEMORY_POOL_LIMIT;
            return call.invoke(CREATE_GLOBAL_RUNTIME, memoryLimit, cacheManagerPtr, dir.segment(), dir.len(), spillLimit);  
            sessionCtxPtr = sessionContext.getPointer();
        // i64 df_register_memtable(session_ptr, input_id_ptr, input_id_len,
        boolean deletedDocFilteringRequired,  
    public static void cacheManagerAddFilesWithStore(long runtimePtr, long storePtr, String[] filePaths) {  
     * the streaming channel accepts them positionally.  
            MemorySegment dataPtr = outPtr.get(ValueLayout.ADDRESS, 0);
                ValueLayout.ADDRESS,     // column_name_ptr  
                return Collections.emptyMap();  
     * @return a populated {@link AnalyticsBackendTaskCancellationStats}
     * on the Rust handle for use during execution.
                queryConfigPtr,
     */  
                ValueLayout.JAVA_LONG,
        // input_id_ptr, input_id_len, schema_ipc_ptr, schema_ipc_len)
        // out_ptr, out_cap, out_len)
    public static void streamGetSchema(long streamPtr, ActionListener<Long> listener) {
    private static final MethodHandle SET_MIN_TARGET_PARTITIONS;
            if (written == 0L) {
        // void df_sender_terminate_early(sender_ptr)
    public static RegisteredInput registerMemtable(
    /**  
    /**
            // Cache stats (zeroed in native when caches are disabled)  
    public static long[] partitionBatchByHash(long inputArrayPtr, long inputSchemaPtr, int[] hashKeyIndices, int partitionCount) {  
    }
            );
                ValueLayout.JAVA_LONG,   // queryConfigPtr
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT)  
        long[] arrayPtrs,  
                ValueLayout.ADDRESS,     // planBytes (multi-index schema widening)  
                ValueLayout.ADDRESS,
                call.bytes(partialPlanBytes),
        }  
     * @param contextId  the parent {@code AnalyticsQueryTask.getId()}; see
            );
                createCollector,  
                (long) schemaIpc.length,
        // Optional spill-limit setter. Not yet shipped by our Rust crate (upstream
     *                   reversal when the query's leading ORDER BY runs counter to catalog direction.
            var eviction = call.str(evictionType);  
            for (int i = 0; i < result.length; i++) {
            return new long[] { 0, 0 };  
     * Registers the delegated_predicate UDF and stores treeShape + delegatedPredicateCount
            );  
        CACHE_MANAGER_ADD_FILES = linker.downcallHandle(  
     * session derived by lowering the producer-side substrait. The Java tripwire  
        if (arrayPtrs.length != schemaPtrs.length) {
            var cn = call.str(columnName);
    /** Frees the native runtime. Safe to call once. */
                // Rust took ownership via Box::from_raw; do not let doClose() double-free.
        try {
                ValueLayout.ADDRESS,  
     */
     *  
    /** {@link #canMatch} status: shard provably holds no matching row. The only value that prunes. */
     * <p>Mirrors the {@link #stats(long)} pattern: the layout class decodes
        CLOSE_LOCAL_SESSION = linker.downcallHandle(
        String path,  
            lib.find("df_shard_sort_bounds").orElseThrow(),
    public static long cacheManagerGetMemoryConsumedForCacheType(long runtimePtr, String cacheType) {  
     * Collects all native executor metrics in a single FFM call.
                ValueLayout.JAVA_LONG,
    private static final MethodHandle UPDATE_CONCURRENCY_GATE;
        CACHE_MANAGER_REMOVE_FILES = linker.downcallHandle(
                ValueLayout.ADDRESS,
     * @param sessionPtr pointer returned by {@link #createLocalSession}  
        if (arrayPtr == 0) {  
            listener.onFailure(e);  
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
    private static final MethodHandle CREATE_READER;
     *
    /**
    }
                id.segment(),  
            }
    private static final MethodHandle SENDER_TERMINATE_EARLY;
    public static SessionContextHandle createWorkerSessionContext(long runtimePtr, long contextId, long queryConfigPtr) {  
            SET_MEMORY_GUARD_THRESHOLDS.invokeExact(
     * @param readerPtr pointer to the shard view (DatafusionReader)
 * then throws.</p>
        long queryConfigPtr,
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)  
     * Gate names: "fragment_executor" or "reduce".
                    FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    public static long[] getMemoryPoolStats(long runtimePtr) {
     * @param substrait  Substrait plan bytes  
            return NativeNodeStatsLayout.readNativeNodeStats(seg);
            listener.onFailure(convertNativeError(t));
            long ptr = call.invoke(  
        );
        }  
        }
            throw new IllegalArgumentException("n too large for a single snapshot: " + n);  
                ValueLayout.JAVA_LONG,  
            call.invoke(CLEAR_SCOPED_PAGE_INDEX_CACHE);
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        long readerPtr,  
    public static void setMemoryGuardThresholds(
     * Executes a query and returns an opaque stream pointer via {@code listener}.  
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,   // shard_view_ptr  
                id.len(),
     * versions of the native library.
        REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT_FROM_PARTIAL_PLAN = linker.downcallHandle(  
     */
            NativeHandle.validatePointer(streamPtr, "stream");
                ValueLayout.JAVA_LONG,  
        byte[] partialPlanBytes
        double executionCritical
                ValueLayout.JAVA_INT,
            return call.invoke(CACHE_MANAGER_GET_TOTAL_MEMORY, runtimePtr);  
            );
            FunctionDescriptor.of(  
        }
            SET_SPILL_EXEMPT_CAP_BYTES.invokeExact(bytes);  
                planSegment,
        long runtimePtr,  
     *                   Parallel to {@code sortOrders}. Two consumers Rust-side: vanilla path's
     *                   {@code ListingOptions.with_file_sort_order(...)} so the parquet scan advertises  
            var f = call.strArray(filePaths);
                table.len(),
        }
     * @param hasPartialAggregate whether the fragment contains a partial aggregate — signals Rust to
            var plan = call.bytes(substraitPlan);
            return call.invoke(
                (long) (admissionThrottle * 1000),  
    public static long fetchByRowIds(
    public static long senderSend(long senderPtr, long arrayPtr, long schemaPtr) {
     */
            SET_REDUCE_TARGET_PARTITIONS.invokeExact((long) value);
                cb,
     */
     */  
                gens,
