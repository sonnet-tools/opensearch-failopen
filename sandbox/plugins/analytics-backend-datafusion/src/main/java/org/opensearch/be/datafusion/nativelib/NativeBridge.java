    public static void setSpillLimit(long runtimePtr, long newLimitBytes) {
                (byte) (requestsRowIds ? 1 : 0),
        }
                ValueLayout.ADDRESS,
            var dir = call.str(spillDir);
    }
            );
                addr -> linker.downcallHandle(
        STREAM_GET_SCHEMA = linker.downcallHandle(
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
            call.invoke(CLEAR_SCOPED_PAGE_INDEX_CACHE);
                ValueLayout.JAVA_LONG    // planLen
            )
    private static final MethodHandle SENDER_TERMINATE_EARLY;
            MethodHandle releaseCollector = lookup.findStatic(
    }
     * — the benign "consumer finished first" case (e.g. a LimitExec satisfied its fetch). It
    private static final MethodHandle GET_MEMORY_POOL_STATS;
        NativeHandle.validatePointer(runtimePtr, "runtime");
    private static final MethodHandle SET_REDUCE_TARGET_PARTITIONS;
            }
        }
        int rowIdsCount,
        try (var call = new NativeCall()) {
        NativeHandle.validatePointer(sessionContextHandlePtr, "sessionContextHandle");
                new NativeExecutorsStats(ioRuntime, cpuRuntime, taskMonitors),
            );
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
    private static Exception convertNativeError(Throwable t) {
        GET_MEMORY_POOL_LIMIT = linker.downcallHandle(
     * The plan is stored on the Rust session for later execution via
        byte[] planBytes
     * the survivors as {@link QueryRegistryLayout} entries. Completed and
            lib.find("df_stream_get_schema").orElseThrow(),
                ValueLayout.ADDRESS,
        if (inputArrayPtr == 0 || inputSchemaPtr == 0) {
            } finally {
    public static void createCache(long cacheManagerPtr, String cacheType, long sizeLimit, String evictionType) {
            )
     * is released, buffered batches remain available to the receiver, and the receiver observes
    public static void destroyCustomCacheManager(long ptr) {
        // i64 df_register_memtable(session_ptr, input_id_ptr, input_id_len,
        }
                ValueLayout.JAVA_LONG,
     * Returns true if the loaded native library exports {@code df_set_spill_limit}.
        String[] columns,
            )
        }
        // i64 df_native_node_stats(out_ptr, out_cap)
    private static final MethodHandle CACHE_MANAGER_GET_MEMORY_BY_TYPE;
            }
     * Sets the byte budget of the process-global scoped OffsetIndex cache.
     * {@link NativeErrorConverter} to translate known native error patterns into OpenSearch
     * ({@code typesMatch} in {@code DatafusionReduceSink}) validates fed batches against this
     * When the upstream PR converting that field to {@code Arc<AtomicU64>}
     * Creates a SessionContext with the default ListingTable registered.
            )
        try (var call = new NativeCall()) {
    public static long cacheManagerGetMemoryConsumedForCacheType(long runtimePtr, String cacheType) {
    /**
                );
     * Hash-partitions one Arrow C Data input batch into {@code partitionCount} output batches
        // i64 df_can_match(runtime_ptr, shard_view_ptr, column_name_ptr, column_name_len, filter_min, filter_max)
            lib.find("df_execute_local_prepared_plan").orElseThrow(),
     * Creates a local DataFusion session tied to the given global runtime. Returns an opaque
     * @param tableName the logical table name (alias/pattern) to register the table under
                readerPtr,
        long internalSearchBound,
            var lookup = java.lang.invoke.MethodHandles.lookup();
                ValueLayout.JAVA_LONG,
            throw new IllegalArgumentException(
            listener.onResponse(result);
        long internalSearchMode,
                CREATE_SESSION_CONTEXT,
                ValueLayout.ADDRESS,
     * {@code partialPlanBytes}; native takes ownership of all FFI structs on success.
     */
        try {
     * the native session settled on after lowering.
     * {@link #executeLocalPreparedPlan}.
     * Fails the sender: pushes an error carrying {@code reason} into the partition stream so the
                FunctionDescriptor.of(
    }
            long ptr = call.invoke(CREATE_WORKER_SESSION_CONTEXT, runtimePtr, contextId, queryConfigPtr);
                sf.lens(),
    public static final long INTERNAL_SEARCH_BY_ROW_ID = 1L;
                table.segment(),
            FunctionDescriptor.of(
        CLOSE_LOCAL_SESSION = linker.downcallHandle(
    }
            return call.invoke(
            var table = call.str(tableName);
    // ---- Cancellation ----
            call.invoke(SENDER_FAIL, senderPtr, msg.segment(), msg.len());
                ValueLayout.JAVA_LONG,
            lib.find("df_set_scoped_page_index_enabled").orElseThrow(),
    }
            );
        List<String> sortOrders
        boolean deletedDocFilteringRequired,
            );
            )
    public static long cacheManagerGetTotalMemoryConsumed(long runtimePtr) {
        }
    private static final MethodHandle SET_OFFSET_INDEX_CACHE_LIMIT;
     * Gate names: "fragment_executor" or "reduce".
        );
        );
     * zero-byte trackers are filtered on the Rust side. Order within the
     * Variant of {@link #registerMemtable} for the shard-scan path. Takes the
    public static void prepareFinalPlan(long sessionPtr, byte[] substraitBytes) {
                    + ") and sortOrders ("
                    "df_partition_batch_by_hash returned " + outBytes.length + " bytes, expected " + partitionCount * pairBytes
            );
        executeQueryAsync(readerPtr, tableName, substraitPlan, runtimePtr, contextId, queryConfigPtr, INTERNAL_SEARCH_OFF, 0L, listener);
            lib.find("df_create_session_context").orElseThrow(),
    /**
        try (var call = new NativeCall()) {
     * Creates a SessionContext configured for indexed execution with filter delegation.
     * When {@code internalSearchMode} is {@link #INTERNAL_SEARCH_OFF}, {@code substraitPlan} is
    }
                    ValueLayout.JAVA_LONG,
     * that both success and native-error paths skip {@code df_close_session_context} (which
        } catch (RuntimeException e) {
                out.lenOut()
     * @param queryConfigPtr pointer to a WireDatafusionQueryConfig struct, or 0 for fallback defaults
        }
        try (var call = new NativeCall()) {
        );
                ValueLayout.ADDRESS,
    // ---- Memory pool observability and dynamic limit ----
    /** Frees the native local session. Tolerates a zero pointer for idempotent close. */
     * DataFusion {@code DiskManager.max_temp_directory_size} is a plain {@code u64}
     * Load metadata for files through the given TieredObjectStore.
    public static long createGlobalRuntime(long memoryLimit, long cacheManagerPtr, String spillDir, long spillLimit) {
        }
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
     * @param rowIdsBufAddr memory address of the BigIntVector's data buffer (i64 values)
     * @return a non-null map of {@code contextId → metrics}, possibly empty,
                table.segment(),
        // partial_plan_ptr, partial_plan_len,
     * counters, keeps the budget). For operational testing.
        long readerPtr,
/**
        long runtimePtr,
        STATS = linker.downcallHandle(
        );
     * already has the listing-table-backed shard scan registered. Returns 0 on success; a
    private static final MethodHandle QUERY_REGISTRY_TOP_N_BY_CURRENT;
        );
                "arrayPtrs.length (" + arrayPtrs.length + ") != schemaPtrs.length (" + schemaPtrs.length + ")"
        EXECUTE_QUERY = linker.downcallHandle(
        double admissionThrottle,
                ValueLayout.ADDRESS,     // planBytes (multi-index schema widening)
            call.invoke(SET_SPILL_LIMIT, runtimePtr, newLimitBytes);
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        byte[] schemaIpc,
     * would otherwise double-free). Only a Java-side failure before the downcall dispatches
    }
                table.segment(),
        // void df_close_local_session(session_ptr)
        UPDATE_CONCURRENCY_GATE = linker.downcallHandle(
        } catch (Throwable t) {
     * Pair returned from {@link #registerPartitionStream} / {@link #registerMemtable}: the
            // CPU runtime (always present — zeroed when absent)
     * returns an error. The handle is therefore marked consumed in a {@code finally} block so
    /**
     * Safe to call at most once per pointer.
                ValueLayout.ADDRESS
            return call.invoke(
                ValueLayout.JAVA_LONG,
        }
import org.opensearch.core.action.ActionListener;
     */
        try (var call = new NativeCall()) {
     * MUST match {@code SENDER_SEND_RECEIVER_DROPPED} in {@code ffm.rs}.
        );
                ValueLayout.JAVA_LONG,
            lib.find("df_stats").orElseThrow(),
    }
            )
                contextId,
        QUERY_REGISTRY_TOP_N_BY_CURRENT = linker.downcallHandle(
        );
            SET_REDUCE_TARGET_PARTITIONS.invokeExact((long) value);
    public static void senderTerminateEarly(long senderPtr) {
     * @param handlePtr pointer returned by {@link #createSessionContext}
     * The returned stream is drained identically in all modes.
     */
        // DataFusion 53.1.0 does not support runtime spill resize through the public
        long contextId,
        SET_CANCEL_STATS_THRESHOLD_MS = linker.downcallHandle(
        );
import java.util.HashMap;
    private static final MethodHandle SQL_TO_SUBSTRAIT;
                java.lang.invoke.MethodType.methodType(int.class, long.class, int.class, long.class, int.class, int.class)
            );
            java.lang.foreign.MemorySegment releaseCollectorStub = linker.upcallStub(
            // correct per-query FilterDelegationHandle in FilterTreeCallbacks.BINDINGS.
                ValueLayout.ADDRESS      // out_ptr — 3 i64 slots: [min, max, value_kind]
                FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT),
    public static void executeQueryAsync(
     * native pointer freed by {@link #closeLocalSession}.
    }
                ValueLayout.JAVA_LONG,  // runtime_ptr
            var cacheStats = StatsLayout.readCacheStats(seg);
            throw new IllegalArgumentException("rowIdsBufAddr must be non-zero");
                    + sortOrders.size()
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
                return null;
     * @return a flat array of {@code 2 * partitionCount} longs: {@code [array_ptr_0,
        // i64 df_execute_local_prepared_plan(session_ptr, context_id)
            var ioRuntime = StatsLayout.readRuntimeMetrics(seg, "io_runtime");
 */
                out.getAtIndex(ValueLayout.JAVA_LONG, 0),
            MemorySegment out = call.buf(SORT_BOUNDS_SLOTS * Long.BYTES);
            throw new ExceptionInInitializerError(t);
     * Returns a tracked handle consumed by {@link #executeWithContextAsync}.
        );
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            long result;
                taskMonitors.put(op.key(), StatsLayout.readTaskMonitor(seg, op.key()));
    /** {@code internal_search_mode}: seq-no scan — native plan filters {@code _seq_no > bound}, {@code substraitPlan} ignored. */
    }
                call.longs(schemaPtrs),
        try (var call = new NativeCall()) {
     * For synchronous FFM methods: converts and rethrows as RuntimeException.
            );
        }
            var query = call.str(sql);
     * agree on assignments.
                segments.stream().mapToLong(org.opensearch.index.engine.exec.MonoFileWriterSet::writerGeneration).toArray()
        // BatchPartitioner (matches RepartitionExec / HashJoinExec). Output buffer holds
        try (var call = new NativeCall()) {
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
        // i64 df_create_worker_session_context(runtime_ptr, context_id, query_config_ptr)
            long ptr = call.invoke(
     * freed by {@link #streamClose}.
     * lands, our crate exports {@code df_set_spill_limit} and this handle
    }
                    ValueLayout.JAVA_INT,
        CACHE_MANAGER_GET_TOTAL_MEMORY = linker.downcallHandle(
        } catch (Throwable t) {
        // i64 df_register_partition_stream_on_session_context(session_ctx_handle_ptr,
     *                   {@code ListingOptions.with_file_sort_order(...)} so the parquet scan advertises
    /**
            return new SessionContextHandle(ptr);
    }
                ValueLayout.JAVA_INT,
            long planLen = (long) substraitPlan.length;
    }
            lib.find("df_sender_send").orElseThrow(),
     * @param sortOrders index.sort.order values ("asc" or "desc"), parallel to {@code sortFields}.
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS
     * Creates a native reader. Returns an opaque native pointer.
        }
                (long) (admissionThrottle * 1000),
     *
        try {
        }
    private static final MethodHandle CREATE_READER;
            }
                ValueLayout.JAVA_LONG,
        // Arc<DiskManager> API). Bind only if the symbol is present so the same
            call.invoke(CACHE_MANAGER_UPDATE_SIZE_LIMIT, runtimePtr, type.segment(), type.len(), newLimit);
            lib.find("df_create_cache").orElseThrow(),
            call.invoke(CACHE_MANAGER_ADD_FILES, runtimePtr, f.ptrs(), f.lens(), f.count());
            return call.invoke(
 * <h2>Pointer lifecycle (no Arena needed)</h2>
            long result = call.invoke(CACHE_MANAGER_CONTAINS_BY_TYPE, runtimePtr, type.segment(), type.len(), file.segment(), file.len());
            // Partition gates
    // ---- Stats collection ----
            java.lang.foreign.MemorySegment createProviderStub = linker.upcallStub(
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        SQL_TO_SUBSTRAIT = linker.downcallHandle(
                ValueLayout.JAVA_LONG,
        CACHE_MANAGER_UPDATE_SIZE_LIMIT = linker.downcallHandle(
                ValueLayout.JAVA_LONG,
                (byte) (hasPartialAggregate ? 1 : 0),
        try (var arena = Arena.ofConfined()) {
            )
    public static long registerPartitionStreamOnSessionContextFromPartialPlan(
        );
    ) {
                REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT,
        CACHE_MANAGER_GET_MEMORY_BY_TYPE = linker.downcallHandle(
     * input schema by lowering the producer-side {@code partialPlanBytes}. Returns the native
        SET_SPILL_LIMIT = lib.find("df_set_spill_limit")
                call.longs(arrayPtrs),
            listener.onResponse(result);
import org.opensearch.plugins.NativeStoreHandle;
        NativeCall.invokeVoid(SENDER_CLOSE, senderPtr);
            var fragmentExecutorGate = StatsLayout.readPartitionGate(seg, "fragment_executor_gate", "fragment_executor_gate");
    public static void closeSessionContext(long ptr) {
                id.segment(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS)
        // i64 df_create_cache(mgr_ptr, type_ptr, type_len, size_limit, eviction_ptr, eviction_len)
            var buf = arena.allocate(ValueLayout.JAVA_LONG, 2);
                )
        }
        }
                ValueLayout.ADDRESS,
    /** Number of i64 slots {@code df_shard_sort_bounds} writes: [min, max, hasNulls, valueKind]. */
                result[i] = bb.getLong();
            long found = call.invoke(SHARD_SORT_BOUNDS, runtimePtr, shardViewPtr, cn.segment(), cn.len(), out);
     */
    private static void installFilterTreeCallbacks(Linker linker) {
    private static final MethodHandle DF_NATIVE_NODE_STATS;
    }
                out.getAtIndex(ValueLayout.JAVA_LONG, 1),
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_LONG,  // table_path_len
            );
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
                    ValueLayout.JAVA_INT,
     * M3 hash-shuffle AGGREGATE worker variant of {@link #registerPartitionStreamOnSessionContext}.
                return Collections.emptyMap();
        }
     */
            call.invoke(CACHE_MANAGER_ADD_FILES_WITH_STORE, runtimePtr, storePtr, f.ptrs(), f.lens(), f.count());
            lib.find("df_set_reduce_target_partitions").orElseThrow(),
     *                   {@link #executeLocalPlan(long, byte[], long)} for semantics
    public static long[] getMemoryPoolStats(long runtimePtr) {
        INIT_RUNTIME_MANAGER = linker.downcallHandle(
        SET_MEMORY_POOL_LIMIT = linker.downcallHandle(
                ValueLayout.JAVA_LONG,
    private static final MethodHandle EXECUTE_LOCAL_PREPARED_PLAN;
                ValueLayout.JAVA_LONG,
     * drained via {@link #streamNext} and freed by {@link #streamClose}.
            lib.find("df_cache_manager_add_files_with_store").orElseThrow(),
    }
        if (n < 0) {
        long sessionContextHandlePtr,
            NativeCall.invokeVoid(
    ) {
    private static final MethodHandle FETCH_BY_ROW_IDS;
                (long) rowIdsCount,
        );
        }
     * @param planBytes Substrait plan bytes — used to widen the registered schema for multi-index
            FunctionDescriptor.of(
            );
    }
        long[] arrayPtrs,
                table.len(),
        try (var call = new NativeCall()) {
            call.invoke(CACHE_MANAGER_CLEAR_BY_TYPE, runtimePtr, type.segment(), type.len());
    }
        // i64 df_sender_send(sender_ptr, array_ptr, schema_ptr)
    /** Clears the scoped OffsetIndex (projection) cache. */
        // i64 df_cache_manager_contains_by_type(runtime_ptr, type_ptr, type_len, file_ptr, file_len)
            MemorySegment planSegment = hasPlan ? call.bytes(planBytes) : MemorySegment.NULL;
        }
            )
     * Sets the cancellation stats threshold in milliseconds.
 *
    }
     * streams subsequently registered via {@link #registerPartitionStreamOnSessionContext}.
                REGISTER_PARTITION_STREAM,
                call.longs(arrayPtrs),
                sessionContext.markConsumed();
    /**
            listener.onResponse(result);
            long[] result = new long[partitionCount * 2];
        }
                cb,
     * range covering only part of the shard would be narrower than the truth.
 * The OpenSearch Contributors require contributions made to
            boolean hasPlan = planBytes != null && planBytes.length > 0;
            MemorySegment planSegment = hasPlan ? call.bytes(planBytes) : MemorySegment.NULL;
    private static final MethodHandle CACHE_MANAGER_CLEAR;
    }
                ValueLayout.JAVA_LONG,
                REGISTER_FILTER_TREE_CALLBACKS,
        } catch (Throwable throwable) {
            assert status == 0 : "df_partition_batch_by_hash returned non-zero on success: " + status;
                id.len(),
     * (e.g. {@code sum_qty}) rather than the producer's physical aggregate-state names (e.g.
    }
     * Must be called BEFORE streamClose (the stream handle must still be alive).
                ValueLayout.JAVA_LONG,
        }
    public static void senderClose(long senderPtr) {
            MethodHandle collectDocs = lookup.findStatic(
        }
        } catch (RuntimeException e) {
        long readerPtr,
                searchStats
            var type = call.str(cacheType);
     */
            var id = call.str(inputId);
     */
                inputArrayPtr,
    /** Frees the native runtime. Safe to call once. */
     * Registers an input partition stream on the session under {@code inputId}, deriving the
                call.bytes(schemaIpc),
        );
     * @throws IllegalStateException if the runtime manager is not initialized
            );
        STREAM_NEXT = linker.downcallHandle(
     * @param sessionPtr pointer returned by {@link #createLocalSession} with a plan
    private static final MethodHandle CACHE_MANAGER_ADD_FILES;
    private static final MethodHandle SET_MEMORY_GUARD_THRESHOLDS;
                    ValueLayout.JAVA_LONG,
     *
                ValueLayout.ADDRESS,
     * header.
            call.invoke(SET_OFFSET_INDEX_CACHE_LIMIT, sizeLimitBytes);
    private static final MethodHandle EXECUTE_LOCAL_PLAN;
            lib.find("df_execute_local_plan").orElseThrow(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            lib.find("df_create_session_context_indexed").orElseThrow(),
        }
     *
     */
            lib.find("df_set_spill_exempt_cap_bytes").orElseThrow(),
                ValueLayout.JAVA_LONG,
        );
        try (var call = new NativeCall()) {
                cb,
    private static final MethodHandle SET_SPILL_EXEMPT_CAP_BYTES;
    /** Fires the cancellation token for the given context. No-op if already completed. */
                id.len(),
        initTokioRuntimeManager(cpuThreads, 1.5, 1.5);
     * {@link org.opensearch.be.datafusion.DataFusionPlugin#DATAFUSION_SPILL_MEMORY_LIMIT}
            var id = call.str(inputId);
    /** {@link #canMatch} status: shard provably holds no matching row. The only value that prunes. */
     *
    }
        if (converted instanceof RuntimeException rte) {
     * Creates a global DataFusion runtime. Returns an opaque native pointer ({@code long}).
    public static void initTokioRuntimeManager(int cpuThreads, double datanodeMultiplier, double coordinatorMultiplier) {
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        } catch (Throwable t) {
                    + ") must have the same length"
            for (int i = 0; i < rows; i++) {
        double executionSpill,
            logger.debug("Failed to set reduce target partitions", t);
    private static final MethodHandle REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT;
        );
        );
        }
                ValueLayout.JAVA_LONG
        long contextId,
     * decoded as a Substrait plan (normal search). When it is {@link #INTERNAL_SEARCH_BY_ROW_ID}
            var p = call.str(path);
                ValueLayout.JAVA_LONG,
        }
                planSegment,
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_LONG,
    public static void preparePartialPlan(long handlePtr, byte[] substraitBytes) {
     * the provider by name, so the logical-named registration is what makes the FINAL resolve
                ValueLayout.JAVA_LONG,
    public static long senderSend(long senderPtr, long arrayPtr, long schemaPtr) {
     *
                (long) (executionSpill * 1000),
        int delegatedPredicateCount,
     * <p>Returns a {@link RegisteredInput} whose {@code pointer} field is always 0 (memtable
                sessionPtr,
 * <p>Functions return {@code i64}: {@code >= 0} is success, {@code < 0} is a negated pointer
import java.lang.foreign.SymbolLookup;
        // void df_register_filter_tree_callbacks(createCollector, collectDocs, releaseCollector)
                "collectDocs",
                arena
    public static void senderFail(long senderPtr, String reason) {
     *                   already prepared via {@link #prepareFinalPlan}
                ValueLayout.JAVA_LONG,
        // i64 df_execute_local_plan(session_ptr, substrait_ptr, substrait_len, context_id)
            throw new IllegalArgumentException(
                ValueLayout.JAVA_LONG
            lib.find("df_register_partition_stream_on_session_context_from_partial_plan").orElseThrow(),
            return result;
                CREATE_READER,
        // i64 df_stats(runtime_ptr, out_ptr, out_cap)
     * Iterates all files in the shard view internally (Rust side).
                ValueLayout.ADDRESS,
     * @throws IllegalArgumentException if {@code n} is negative or implies a
                ValueLayout.JAVA_LONG,
    private static final MethodHandle GET_MEMORY_POOL_USAGE;
 * <h2>Error convention</h2>
    /**
                call.bytes(schemaIpc),
    public static void setOffsetIndexCacheLimit(long sizeLimitBytes) {
import org.opensearch.analytics.backend.jni.NativeHandle;
    public static final long INTERNAL_SEARCH_SEQ_NO_ABOVE = 2L;
        try {
    public static AnalyticsBackendTaskCancellationStats nativeNodeStats() {
        }
            call.invoke(
    public static void cacheManagerClear(long runtimePtr) {
        NativeCall.invokeVoid(CANCEL_QUERY, contextId);
        } catch (Throwable t) {
            sessionCtxPtr = sessionContext.getPointer();
        long sessionContextHandlePtr,
                keys,
     */
            Class<?> cb = org.opensearch.be.datafusion.indexfilter.FilterTreeCallbacks.class;
     * turning a silently-incomplete result into a loud query failure. Tolerates a zero pointer.
            SET_MIN_TARGET_PARTITIONS.invokeExact((long) value);
        long[] schemaPtrs
    private static final MethodHandle SET_SPILL_LIMIT;
            } catch (IllegalStateException e) {
    private static final MethodHandle PREPARE_PARTIAL_PLAN;
                ValueLayout.JAVA_LONG,
    public static void initTokioRuntimeManager(int cpuThreads) {
 * and {@code executeQueryAsync} are opaque {@code long} values — Rust heap addresses cast to
            lib.find("df_create_local_session").orElseThrow(),
                ValueLayout.JAVA_LONG,
                table.len(),
        long queryConfigPtr,
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
    public static void shutdownTokioRuntimeManager() {
            lib.find("df_cache_manager_clear").orElseThrow(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            var gens = call.longs(
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,     // column_name_ptr
            FunctionDescriptor.of(
                ValueLayout.ADDRESS,    // files_ptr
            MethodHandle createCollector = lookup.findStatic(
            if (written == 0L) {
    ) {
    ) {
                ValueLayout.JAVA_LONG,   // runtime_ptr
     * Returns a stream pointer that can be drained via {@link #streamNext} and
            lib.find("df_cache_manager_contains_by_type").orElseThrow(),
            lib.find("df_register_memtable_on_session_context").orElseThrow(),
        }
    /**
                ValueLayout.JAVA_LONG,
    public static DataFusionStats stats(long runtimePtr) {
                colNames.ptrs(),
        try (var call = new NativeCall()) {
     */
     * metadata. Used for hash-shuffle worker fragments whose plans read only from named-input
     * export {@code df_set_spill_limit} — callers should gate on
            }
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
            long result = NativeLibraryLoader.checkResult((long) STREAM_GET_SCHEMA.invokeExact(streamPtr));
        String inputId,
                ValueLayout.ADDRESS,
            logger.debug("Failed to set spill exempt cap bytes", t);
            call.invoke(UPDATE_CONCURRENCY_GATE, name.segment(), name.len(), newMaxPermits);
    private static final MethodHandle SET_COLUMN_INDEX_CACHE_LIMIT;
     * @param hasPartialAggregate whether the fragment contains a partial aggregate — signals Rust to
        }
                    + sortFields.size()
    public static void streamNext(long runtimePtr, long streamPtr, ActionListener<Long> listener) {
import org.opensearch.analytics.spi.ShardSortBounds;
            );
        );
     *                   native {@code QUERY_REGISTRY} under this id so {@link #cancelQuery} fires
                (long) partialPlanBytes.length,
    private static final MethodHandle REGISTER_FILTER_TREE_CALLBACKS;
                ValueLayout.JAVA_LONG,
            var keys = call.ints(hashKeyIndices);
            )
        NativeHandle.validatePointer(runtimePtr, "runtime");
     * @return the folded bounds, or {@code null} when no shard-wide range is available
        // caller step required — as soon as this class is loaded, callbacks
                    ValueLayout.JAVA_LONG,
     * on the Rust handle for use during execution.
            return call.invoke(GET_MEMORY_POOL_LIMIT, runtimePtr);
import java.lang.foreign.Arena;
            throw rethrowConverted(e);
     * When disabled, the metadata cache retains the full page index (fallback mode)
        SET_COLUMN_INDEX_CACHE_LIMIT = linker.downcallHandle(
            return call.invoke(SENDER_SEND, senderPtr, arrayPtr, schemaPtr);
     */
                ValueLayout.JAVA_LONG
        boolean requestsRowIds,
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
     */
            var type = call.str(cacheType);
        try (var call = new NativeCall()) {
    private static final MethodHandle SENDER_FAIL;
                ValueLayout.JAVA_LONG,
     * QTF fetch phase: reads specific rows by global row ID from parquet.
        );
        } catch (Exception e) {
            )
                ValueLayout.JAVA_LONG,
                colNames.count(),
                table.len(),
     * session derived by lowering the producer-side substrait. The Java tripwire
            var searchStats = StatsLayout.readSearchStats(seg);
    private static final MethodHandle CREATE_WORKER_SESSION_CONTEXT;
                ValueLayout.JAVA_LONG,   // internal_search_mode
        try (var call = new NativeCall()) {
 * arrays) that are only needed for the duration of the FFM call. The Arena is closed
    public static void closeDatafusionReader(long ptr) {
    /**
            lib.find("df_set_memory_guard_thresholds").orElseThrow(),
            lib.find("df_init_runtime_manager").orElseThrow(),
        CACHE_MANAGER_CLEAR_BY_TYPE = linker.downcallHandle(
            return new SessionContextHandle(ptr);
            var out = call.outBuffer(16 * partitionCount);
        // out_ptr, out_cap, out_len)
                ValueLayout.JAVA_LONG,
        }
    private static RuntimeException rethrowConverted(RuntimeException e) {
    }
    public static SessionContextHandle createWorkerSessionContext(long runtimePtr, long contextId, long queryConfigPtr) {
                    ValueLayout.JAVA_INT
                ValueLayout.JAVA_LONG,   // plan_len
     * group in the shard view. Unlike {@link #canMatch}, this does not short-circuit — a
        }
        }
     * Clears the process-global scoped page-index cache (drops entries + resets
        );
     *                   Parallel to {@code sortOrders}. Two consumers Rust-side: vanilla path's
                arena
            var name = call.str(gateName);
            return NativeLibraryLoader.checkResult((long) CREATE_CUSTOM_CACHE_MANAGER.invokeExact());
            var type = call.str(cacheType);
                readerPtr,
        String tableName,
    private static final MethodHandle CREATE_SESSION_CONTEXT;
            lib.find("df_create_worker_session_context").orElseThrow(),
        // out_ptr, out_cap, out_len)
    private static final MethodHandle PARTITION_BATCH_BY_HASH;
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        long queryConfigPtr,
     */
            );
                runtimePtr,
        try (var call = new NativeCall()) {
    private static final MethodHandle SHARD_SORT_BOUNDS;
        } catch (RuntimeException e) {
        }
    private static final MethodHandle CREATE_LOCAL_SESSION;
            FunctionDescriptor.of(
    /**
            long ptr = call.invoke(
        NativeHandle.validatePointer(sessionPtr, "session");
    public static RegisteredInput registerPartitionStream(long sessionPtr, String inputId, byte[] partialPlanBytes) {
    /**
            long ptr = call.invoke(
            lib.find("df_cache_manager_clear_by_type").orElseThrow(),
        long readerPtr,
        NativeHandle.validatePointer(sessionPtr, "session");
     * ownership transfers to the caller. The caller imports each pair via
            var outPtr = arena.allocate(ValueLayout.ADDRESS);
     *
                table.len(),
     * (argument marshalling) leaves the handle unconsumed, in which case its
            var so = call.strArray(sortOrders.toArray(String[]::new));
     * Evaluates whether any parquet file in the shard has row-group statistics
     */
    private static final MethodHandle STATS;
     * {@link #senderSend} / {@link #senderClose}. Used by M2's hash-shuffle worker to register
            return out.toByteArray();
public final class NativeBridge {
                    long.class,
                planSegment,
    public static void setMinTargetPartitions(int value) {
        GET_MEMORY_POOL_USAGE = linker.downcallHandle(
                ValueLayout.JAVA_LONG,
        // Same signature as df_register_memtable but for SessionContextHandle (shard-scan path).
    private static final MethodHandle SET_MEMORY_POOL_LIMIT;
            var sf = call.strArray(sortFields.toArray(String[]::new));
     * @param hasPartialAggregate whether the fragment contains a partial aggregate — signals Rust to
    /**
                ValueLayout.JAVA_LONG,
     * Reads footer (lightweight) into heap cache, fetches page/offset index bytes
            byte[] outBytes = out.toByteArray();
        return e;
    }
        );
     * Primarily for testing — production uses the default (10 000 ms).
        NativeStoreHandle dataformatAwareStoreHandle,
            lib.find("df_cache_manager_get_total_memory").orElseThrow(),
        if (rowIdsBufAddr == 0) {
    /** Clears the scoped ColumnIndex (predicate) cache. */
                arena
    public static void executeQueryAsync(
     */
            byte[] bytes = dataPtr.reinterpret(len).toArray(ValueLayout.JAVA_BYTE);
        NativeHandle.validatePointer(sessionPtr, "session");
     * @param sessionPtr pointer returned by {@link #createLocalSession}
     *                   {@code output_ordering} to the optimizer, and indexed path's segment-iteration
                ),
            lib.find("df_create_custom_cache_manager").orElseThrow(),
                    ValueLayout.JAVA_INT,
     *
            lib.find("df_register_filter_tree_callbacks").orElseThrow(),
                out.lenOut()
                    ValueLayout.JAVA_INT,
        SET_REDUCE_TARGET_PARTITIONS = linker.downcallHandle(
                ValueLayout.JAVA_LONG,  // object store ptr
            listener.onFailure(convertNativeError(throwable));
    }
            GET_MEMORY_POOL_STATS.invokeExact(runtimePtr, buf);
     */
            FunctionDescriptor.of(
            );
                )
                ValueLayout.JAVA_LONG,
            call.invoke(SET_MEMORY_POOL_LIMIT, runtimePtr, newLimitBytes);
     * @return a populated {@link AnalyticsBackendTaskCancellationStats}
     */
                "createCollector",
                colNames.lens(),
import org.opensearch.be.datafusion.stats.DataFusionStats;
                queryConfigPtr,
     * can build a {@code MemTable} in one shot. Schema is derived by lowering the producer-side
                sf.ptrs(),
                ValueLayout.ADDRESS,
        PARTITION_BATCH_BY_HASH = linker.downcallHandle(
        try (var call = new NativeCall()) {
            // Free the Rust-allocated buffer
        long queryConfigPtr,
        try (var call = new NativeCall()) {
                runtimePtr,
                fragmentExecutorGate,
            FunctionDescriptor.of(
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
    private static final MethodHandle CACHE_MANAGER_ADD_FILES_WITH_STORE;
            FunctionDescriptor.of(
                ValueLayout.ADDRESS,
            var out = call.outBuffer(64 * 1024);
            return call.invoke(EXECUTE_LOCAL_PREPARED_PLAN, sessionPtr, contextId);
        }
            MethodHandle createProvider = lookup.findStatic(
    }
                id.len(),
                ValueLayout.ADDRESS,
                ValueLayout.ADDRESS,
                (long) (admissionReject * 1000),
            FunctionDescriptor.of(
    public static void closeGlobalRuntime(long ptr) {
     * Prepares a partial-aggregate physical plan on the session context handle.
     * This pointer is <b>not</b> a MemorySegment — it's a Rust heap address that lives
            var type = call.str(cacheType);
                    addr,
            lib.find("df_set_cancel_stats_threshold_ms").orElseThrow(),
                "df_set_spill_limit not available in the loaded native library; spill cap is fixed at startup"
        // i64 df_prepare_final_plan(session_ptr, bytes_ptr, bytes_len)
                ValueLayout.JAVA_LONG,   // column_name_len
            );
        );
                ValueLayout.JAVA_LONG,
            var cn = call.str(columnName);
            )
                java.lang.invoke.MethodType.methodType(void.class, long.class, int.class)
                ValueLayout.JAVA_LONG,
        );
        );
     * send was skipped because the consumer dropped the receiver before this batch could be sent
     * derives the table schema from the producer's PARTIAL Substrait plan (the same derivation the
        CREATE_READER = linker.downcallHandle(
                call.longs(schemaPtrs),
    /** {@code internal_search_mode}: normal query — decode {@code substraitPlan} as Substrait. */
                ValueLayout.ADDRESS,
            lib.find("df_set_column_index_cache_limit").orElseThrow(),
     *                   reversal when the query's leading ORDER BY runs counter to catalog direction.
            return bytes;
                cacheStats,
            int rows = (int) Math.min(written, (long) n);
     * so this preserves the unchecked throw semantics of the original call site.
            lib.find("df_native_node_stats").orElseThrow(),
        }
        if (sortOrders == null) sortOrders = List.of();
        }
        NativeHandle.validatePointer(readerPtr, "reader");
            var out = call.outBuffer(1024 * 1024);
                    FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
     * Registers the delegated_predicate UDF and stores treeShape + delegatedPredicateCount
     * Executes a Substrait plan on the session, returning an opaque stream pointer. The stream is
                    ValueLayout.ADDRESS,
     * @param substrait  Substrait plan bytes
    public static void executeWithContextAsync(SessionContextHandle sessionContext, byte[] substraitPlan, ActionListener<Long> listener) {
        }
     * <p>This registers the streaming table under the worker FINAL fragment's logical column names
    public static final long CAN_MATCH_NO = 0L;
        // ── SessionContext decomposition bindings ──
        try {
     * until {@link #closeGlobalRuntime} is called.
     *
import java.lang.foreign.ValueLayout;
                ValueLayout.JAVA_LONG    // internal_search_bound
        }
     * streaming input on a {@code SessionContextHandle} session under {@code inputId} and
        NativeHandle.validatePointer(runtimePtr, "runtime");
     * the streaming channel accepts them positionally.
            var f = call.strArray(segments.stream().map(org.opensearch.index.engine.exec.MonoFileWriterSet::file).toArray(String[]::new));
                ValueLayout.JAVA_LONG
            logger.debug("Failed to set memory guard thresholds", t);
        }
    public static long registerPartitionStreamOnSessionContext(long sessionContextHandlePtr, String inputId, byte[] schemaIpc) {
                createCollectorStub,
     * @param sortFields index.sort.field values, or empty list if the index has no sort configured.
    public static long executeLocalPreparedPlan(long sessionPtr, long contextId) {
        Exception converted = NativeErrorConverter.convert(e);
                    ValueLayout.JAVA_INT,
                createProviderStub,
            }
            lib.find("df_cache_manager_add_files").orElseThrow(),
        // input_id_ptr, input_id_len, schema_ipc_ptr, schema_ipc_len)
        boolean hasPartialAggregate,
        NativeCall.invokeVoid(CLOSE_READER, ptr);
    private static final MethodHandle REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT_FROM_PARTIAL_PLAN;
 * immediately after the call returns, freeing all temp memory.</p>
                ValueLayout.ADDRESS,    // files_ptr
        NativeCall.invokeVoid(CLOSE_SESSION_CONTEXT, ptr);
     * runs a bounded min-heap of size {@code n} over its registry and writes
        CACHE_MANAGER_CONTAINS_BY_TYPE = linker.downcallHandle(
     * Streaming sibling of {@link #registerMemtableOnSessionContext}. Registers a partitioned
            )
    }
            lib.find("df_create_global_runtime").orElseThrow(),
    /**
            return new ShardSortBounds(
            listener.onFailure(e);
     */
            lib.find("df_cache_manager_remove_files").orElseThrow(),
     * @param path     shard data directory
    private static final MethodHandle CREATE_GLOBAL_RUNTIME;
                java.lang.invoke.MethodType.methodType(
                ValueLayout.JAVA_LONG,   // shard_view_ptr
    }
     */
            long ptr = call.invoke(
            call.invoke(SET_SCOPED_PAGE_INDEX_ENABLED, enabled ? 1L : 0L);
            lib.find("df_close_global_runtime").orElseThrow(),
        }
        SENDER_FAIL = linker.downcallHandle(
    private static final MethodHandle UPDATE_CONCURRENCY_GATE;
    private static final MethodHandle CREATE_CACHE;
     * Folds the shard-wide min/max of {@code columnName} across every parquet file and row
     * native sender pointer (or 0 for memtable) plus the Arrow IPC-encoded schema the native
    public static SessionContextHandle createSessionContext(
                so.lens(),
        CACHE_MANAGER_REMOVE_FILES = linker.downcallHandle(
     * all non-negative, because {@link NativeCall#invoke} routes negatives to
    }
        );
    }
        }
     *                  queries (null-filling columns this shard omits). Empty = skip widening.
        double admissionReject,
    }
     */
            return new SessionContextHandle(ptr);
        // void df_sender_close(sender_ptr)
            var cn = call.str(columnName);
    public static ShardSortBounds shardSortBounds(long runtimePtr, long shardViewPtr, String columnName) {
        );
                planLen
    ) {
     *
            );
                ValueLayout.JAVA_LONG,
    public static void setMemoryPoolLimit(long runtimePtr, long newLimitBytes) {
            if (outBytes.length != partitionCount * pairBytes) {
     * @param rowIdsCount number of row IDs
     * thrown as a runtime exception by the caller).
 * {@code i64}. They are <b>not</b> {@code MemorySegment}s and do not require an Arena. They
    }
    /**
        } catch (Exception e) {
            lib.find("df_query_registry_top_n_by_current").orElseThrow(),
            var seg = call.buf(32);
        NativeCall.invokeVoid(SET_CANCEL_STATS_THRESHOLD_MS, millis);
        try (var call = new NativeCall()) {
 * <p>Native pointers returned by {@code createGlobalRuntime}, {@code createDatafusionReader},
            listener.onFailure(convertNativeError(t));
                ValueLayout.JAVA_LONG
            var file = call.str(filePath);
            throw new IllegalArgumentException("n too large for a single snapshot: " + n);
     */
            return call.invoke(CACHE_MANAGER_GET_MEMORY_BY_TYPE, runtimePtr, type.segment(), type.len());
                cb,
                (byte) out.getAtIndex(ValueLayout.JAVA_LONG, 3)
    public static void streamClose(long streamPtr) {
        try {
     *
                collectDocsStub,
    }
            );
            FunctionDescriptor.of(
     * NativeErrorConverter only returns RuntimeException subtypes when it matches,
            )
    public static long executeLocalPlan(long sessionPtr, byte[] substrait, long contextId) {
 * SPDX-License-Identifier: Apache-2.0
            // Cache stats (zeroed in native when caches are disabled)
     *
    }
                (long) arrayPtrs.length,
        NativeCall.invokeVoid(INIT_RUNTIME_MANAGER, cpuThreads, datanodeMultiplier, coordinatorMultiplier);
                ValueLayout.JAVA_LONG
                ValueLayout.JAVA_LONG,   // runtime_ptr
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
                createCollector,
    }
                ValueLayout.JAVA_LONG,   // returns stream_ptr
        }
            FunctionDescriptor.of(
        }
     * {@link #SENDER_SEND_RECEIVER_DROPPED} if the consumer already dropped the receiver.
        try {
            );
            java.lang.foreign.MemorySegment collectDocsStub = linker.upcallStub(
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT)
    private static final MethodHandle CACHE_MANAGER_UPDATE_SIZE_LIMIT;
        } catch (Throwable t) {
        CLEAR_SCOPED_PAGE_INDEX_CACHE = linker.downcallHandle(
    public static void setSpillExemptCapBytes(long bytes) {
                ValueLayout.ADDRESS,    // sort_fields_len_ptr
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
    /**
     * returns the producer-side {@code PartitionStreamSender} pointer the caller drives via
     * @return a fully constructed {@link DataFusionStats}
                runtimePtr,
            var out = call.outBuffer(64 * 1024);
     * @return the sender pointer (non-zero); caller must free via {@link #senderClose} when done.
                FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT),
            for (NativeExecutorsStats.OperationType op : NativeExecutorsStats.OperationType.values()) {
                createProvider,
                ValueLayout.ADDRESS,     // table_name_ptr
            call.invoke(CACHE_MANAGER_REMOVE_FILES, runtimePtr, f.ptrs(), f.lens(), f.count());
    public static void setMemoryGuardThresholds(
            SET_MEMORY_GUARD_THRESHOLDS.invokeExact(
            NativeHandle.validatePointer(runtimePtr, "runtime");
    public static void initLogger() {}
        byte[] partialPlanBytes
    }
        );
            Map<Long, QueryExecutionMetrics> out = new HashMap<>(rows);
import java.lang.foreign.FunctionDescriptor;
            long status = call.invoke(
                ValueLayout.ADDRESS,    // writer_generations_ptr
        // i64 df_cache_manager_add_files(runtime_ptr, files_ptr, files_len_ptr, files_count)
        );
        );
                (long) (executionCritical * 1000)
            throw rethrowConverted(e);
        );
    public static final long SENDER_SEND_RECEIVER_DROPPED = 1L;
    private static final MethodHandle EXECUTE_WITH_CONTEXT;
                ValueLayout.JAVA_LONG,   // query_config_ptr
                (long) out.capacity(),
            var id = call.str(inputId);
     * @param runtimePtr pointer to the DataFusion runtime
    /**
            return call.invoke(CREATE_LOCAL_SESSION, runtimePtr);
            }
            // IO runtime (always present — zeroed if not yet initialized)
     * @param n maximum entries to return; must be non-negative. Zero short-circuits
            lib.find("df_fetch_by_row_ids").orElseThrow(),
            return Collections.unmodifiableMap(out);
     * @param readerPtr pointer to the shard view (DatafusionReader)
            if (result != 0) {
        try (var call = new NativeCall()) {
    public static SessionContextHandle createSessionContextForIndexedExecution(
        try (var call = new NativeCall()) {
            throw rethrowConverted(e);
                ValueLayout.ADDRESS,
            var eviction = call.str(evictionType);
    // ---- Query execution (confined Arena for tableName + plan bytes) ----
            var seg = call.buf((int) StatsLayout.LAYOUT.byteSize());
        } catch (Throwable t) {
                id.segment(),
            long result = call.invoke(
            );
                ValueLayout.JAVA_LONG
    }
     * Memtable variant of {@link #registerPartitionStream}: hands across a list of
        STREAM_CLOSE = linker.downcallHandle(lib.find("df_stream_close").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
        boolean deletedDocFilteringRequired,
        CREATE_SESSION_CONTEXT_INDEXED = linker.downcallHandle(
     * already-exported Arrow C Data batches in two parallel pointer arrays so the native side
            lib.find("df_cache_manager_update_size_limit").orElseThrow(),
    }
            var seg = call.buf((int) bytes);
     */
    private static final MethodHandle CREATE_CUSTOM_CACHE_MANAGER;
    /**
    }
     * @param contextId  the parent {@code AnalyticsQueryTask.getId()}; registers the reduce in the
     * 85% spill gate by spillable consumers so they can finish spilling. Live-tunable; takes effect
     *                            exclude the CombinePartialFinalAggregate optimizer rule
                ValueLayout.ADDRESS
                id.segment(),
        SHUTDOWN_RUNTIME_MANAGER = linker.downcallHandle(
                call.bytes(partialPlanBytes),
     * Updates the spill-temp-directory cap at runtime. Throws
                ValueLayout.ADDRESS,
     * Enable or disable the scoped page-index feature.
        }
                ValueLayout.ADDRESS,
        NativeCall.invokeVoid(SHUTDOWN_RUNTIME_MANAGER);
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        CACHE_MANAGER_ADD_FILES = linker.downcallHandle(
        );
     * registration has no sender to return) — the {@code schemaIpc} field carries the schema
                ValueLayout.JAVA_LONG
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    /** {@link #canMatch} status: shard may hold a matching row. */
    public static void cacheManagerClearByCacheType(long runtimePtr, String cacheType) {
     * through the store (populating data Foyer), and returns for promotion to metadata Foyer.
    /**
            NativeCall.Str table = call.str(tableName);
            return new DataFusionStats(
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    }
                ValueLayout.JAVA_LONG,
        }
            )
    }
    /**
        }
     * Gracefully terminates one partition stream without cancelling the query. Any blocked sender
     * coordinator-reduce {@link #registerPartitionStream} uses) instead of the raw producer IPC
     * {@code sum_qty[sum]}). DataFusion's Substrait consumer binds the FINAL {@code base_schema} to
            lib.find("df_register_partition_stream").orElseThrow(),
        // i64 df_partition_batch_by_hash(input_array_ptr, input_schema_ptr,
        byte[] substraitPlan,
        );
            FunctionDescriptor.of(
            FunctionDescriptor.of(
    /**
        NativeCall.invokeVoid(CLOSE_GLOBAL_RUNTIME, ptr);
                ValueLayout.JAVA_LONG
    }
        NativeHandle.validatePointer(handlePtr, "sessionContext");
     *
    private static final MethodHandle PREPARE_FINAL_PLAN;
            var id = call.str(inputId);
     *
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,
            FunctionDescriptor.of(ValueLayout.JAVA_LONG)
                ValueLayout.JAVA_LONG,
    }
        }
        NativeHandle.validatePointer(sessionPtr, "session");
            long len = outLen.get(ValueLayout.JAVA_LONG, 0);
        SHARD_SORT_BOUNDS = linker.downcallHandle(
            var msg = call.str(reason == null ? "unknown" : reason);
    public static void clearOffsetIndexCache() {
                (long) substraitPlan.length,
     * {@code internalSearchBound} as the {@code __row_id__} value or the {@code _seq_no} floor.
            call.invoke(PREPARE_FINAL_PLAN, sessionPtr, call.bytes(substraitBytes), (long) substraitBytes.length);
        }
                out.put(ctxId, QueryRegistryLayout.readMetrics(seg, i));
            call.invoke(CLEAR_SCOPED_PAGE_INDEX_CACHE);
            }
    private static final MethodHandle STREAM_CLOSE;
     *                   the attached cancellation token. Pass {@code 0} to disable tracking.
            FunctionDescriptor.of(
     */
            FunctionDescriptor.ofVoid(
        try (var call = new NativeCall()) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
            throw new IllegalArgumentException("n must be non-negative: " + n);
     * Executes the previously prepared final-aggregate plan on a local session.
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
        }
            return call.invoke(GET_MEMORY_POOL_USAGE, runtimePtr);
            logger.debug("Failed to read native stream metrics", t);
            return null;
                ValueLayout.JAVA_LONG,   // return: 1=bounds written, 0=unavailable
        }
            return new RegisteredInput(ptr, out.toByteArray());
            int pairBytes = 16;
                ValueLayout.JAVA_LONG,
import org.opensearch.nativebridge.spi.NativeCall;
    private static final MethodHandle EXECUTE_QUERY;
                ValueLayout.JAVA_LONG,   // filter_min
            if (found != 1L) {
            .map(
    private static final int SORT_BOUNDS_SLOTS = 4;
     * with no transport-only intermediate.
                ValueLayout.JAVA_LONG,
     * @return the sender pointer (non-zero); caller must free via {@link #senderClose} when
    }
    }
     * Updates the effective permit count of a concurrency gate at runtime.
     */
                call.bytes(partialPlanBytes),
                ValueLayout.ADDRESS,     // column_name_ptr
                ValueLayout.JAVA_LONG,
        NativeHandle.validatePointer(sessionContextHandlePtr, "sessionContextHandle");
        try (var call = new NativeCall()) {
    public static void setReduceTargetPartitions(int value) {
            // Search stats
            java.lang.foreign.Arena arena = java.lang.foreign.Arena.global();
        // Optional spill-limit setter. Not yet shipped by our Rust crate (upstream
        NativeHandle.validatePointer(runtimePtr, "runtime");
            lib.find("df_get_memory_pool_stats").orElseThrow(),
        );
                result = call.invoke(EXECUTE_WITH_CONTEXT, sessionCtxPtr, plan, planLen);
     *
        }
        String inputId,
    public static void clearScopedPageIndexCache() {
     * happy path where Rust's {@code execute_with_context} consumes the handle itself.
    ) {
            )
    private static final MethodHandle FREE_METRICS_BUF;
        // TODO(PR1): wire to df_clear_column_index_cache when available
            );
    }
     * {@link SessionContextHandle#doCloseNative()} ()} on error / never-executed paths; not called on the
                ValueLayout.JAVA_LONG,   // table_name_len
            );
        NativeHandle.validatePointer(readerPtr, "reader");
    }
     */
     * Creates a worker-mode SessionContext: no shard view, no listing table, no parquet
     *
    /**
                    ValueLayout.JAVA_LONG,
    }
            return call.invoke(
        }
    private static final MethodHandle CLOSE_GLOBAL_RUNTIME;
        );
        NativeCall.invokeVoid(SENDER_TERMINATE_EARLY, senderPtr);
                ValueLayout.JAVA_LONG,
    }
        FETCH_BY_ROW_IDS = linker.downcallHandle(
        if (bytes > Integer.MAX_VALUE) {
            lib.find("df_set_memory_pool_limit").orElseThrow(),
     */
                ValueLayout.JAVA_LONG,  // store_ptr
        CLOSE_SESSION_CONTEXT = linker.downcallHandle(
     * {@link #isSpillLimitDynamic()} before invoking.
                internalSearchMode,
        final long sessionCtxPtr;
     * <p>Mirrors the {@link #stats(long)} pattern: the layout class decodes
    /**
                ValueLayout.ADDRESS,    // table_path_ptr
                ValueLayout.ADDRESS,
    }
    public static void updateConcurrencyGate(String gateName, int newMaxPermits) {
     * @param planBytes Substrait plan bytes for multi-index schema widening (empty = skip)
     * {@code NativeLibraryLoader.checkResult}, which reads them as negated error pointers.
        try (var call = new NativeCall()) {
    }
        );
     * {@link SessionContextHandle} pointer instead of a {@code LocalSession} pointer, so the M1
        EXECUTE_WITH_CONTEXT = linker.downcallHandle(
    public static long createDatafusionReader(
            lib.find("df_set_offset_index_cache_limit").orElseThrow(),
                ValueLayout.ADDRESS,
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG,
    /**
    }
        CREATE_GLOBAL_RUNTIME = linker.downcallHandle(
                ValueLayout.JAVA_LONG,
        }
     * Positive sentinel returned by {@code df_sender_send} (via {@link #senderSend}) when the
    }
     * setting stays {@code NodeScope}-only.
    public static void cacheManagerAddFilesWithStore(long runtimePtr, long storePtr, String[] filePaths) {
 * to a heap-allocated error string. {@link NativeCall#invoke} reads and frees the error,
    /**
        FREE_METRICS_BUF = linker.downcallHandle(
                query.len(),
        );
        try (NativeCall call = new NativeCall()) {
    /**
    }
                ValueLayout.ADDRESS
            throw t instanceof RuntimeException ? (RuntimeException) t : new RuntimeException(t);
                arena
                ValueLayout.JAVA_LONG,
    public static void setColumnIndexCacheLimit(long sizeLimitBytes) {
        try {
        // ── Distributed aggregate: prepare partial/final plans ──
            lib.find("df_can_match").orElseThrow(),
        List<String> sortFields,
            SET_SPILL_EXEMPT_CAP_BYTES.invokeExact(bytes);
    }
     *
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG,
     */
        if (SET_SPILL_LIMIT == null) {
            );
    private static final MethodHandle SET_CANCEL_STATS_THRESHOLD_MS;
                java.lang.invoke.MethodType.methodType(void.class, long.class, int.class)
                ValueLayout.JAVA_LONG,
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    /**
            return rte;
 * live until explicitly freed by the corresponding close method.</p>
     *          without crossing the FFM boundary.
            .orElse(null);
        try (var call = new NativeCall()) {
     * Sets the spill-exemption cap in bytes — the total in-flight allocation allowed through the
    public static void cancelQuery(long contextId) {
                table.segment(),
    public static void closeLocalSession(long sessionPtr) {
                id.segment(),
 *
                FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT),
        // arrayPtr/schemaPtr come from Arrow Java's C Data export (ArrowArray.memoryAddress()),
        long rowIdsBufAddr,
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        REGISTER_MEMTABLE = linker.downcallHandle(
        );
        long bytes = (long) n * QueryRegistryLayout.ENTRY_BYTES;
            lib.find("df_cache_manager_get_memory_by_type").orElseThrow(),
                ValueLayout.ADDRESS,
        installFilterTreeCallbacks(linker);
            return call.invoke(CACHE_MANAGER_GET_TOTAL_MEMORY, runtimePtr);
                ValueLayout.JAVA_LONG,
    private static final MethodHandle CREATE_SESSION_CONTEXT_INDEXED;
            return new long[] { buf.getAtIndex(ValueLayout.JAVA_LONG, 0), buf.getAtIndex(ValueLayout.JAVA_LONG, 1) };
        String path,
    private static final MethodHandle CACHE_MANAGER_CONTAINS_BY_TYPE;
     * @param queryConfigPtr pointer to a WireDatafusionQueryConfig struct, or 0 for fallback defaults
    public static final long CAN_MATCH_UNKNOWN = 2L;
    /**
        SET_SPILL_EXEMPT_CAP_BYTES = linker.downcallHandle(
        }
            call.invoke(SET_COLUMN_INDEX_CACHE_LIMIT, sizeLimitBytes);
    private static final MethodHandle CLOSE_LOCAL_SESSION;
            listener.onFailure(convertNativeError(t));
        SENDER_CLOSE = linker.downcallHandle(lib.find("df_sender_close").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
            call.invoke(DF_NATIVE_NODE_STATS, seg, 32L);
    public static void cacheManagerUpdateSizeLimit(long runtimePtr, String cacheType, long newLimit) {
        // TODO(PR1): wire to df_clear_offset_index_cache when available
        );
            MemorySegment dataPtr = outPtr.get(ValueLayout.ADDRESS, 0);
     */
        );
     * Frees a native {@code SessionContext} handle. Invoked from
        }
                runtimePtr,
        // i64 df_sql_to_substrait(shard_ptr, table_ptr, table_len, sql_ptr, sql_len, runtime_ptr, out_ptr, out_cap, out_len)
            FunctionDescriptor.of(
    static {
            );
                id.len(),
                (byte) (deletedDocFilteringRequired ? 1 : 0),
                ValueLayout.ADDRESS,
     *         buffer larger than {@link Integer#MAX_VALUE} bytes
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
            lib.find("df_close_session_context").orElseThrow(),
        PREPARE_FINAL_PLAN = linker.downcallHandle(
    /**
                out.data(),
     * Independent of {@link #stats(long)} which calls {@code df_stats} for plugin stats.
import org.opensearch.analytics.spi.QueryExecutionMetrics;
     * {@link SessionContextHandle#doCloseNative()} ()} will free it.
        PREPARE_PARTIAL_PLAN = linker.downcallHandle(
     */
                id.segment(),
        REGISTER_FILTER_TREE_CALLBACKS = linker.downcallHandle(
    // ---- Stream operations (no Arena needed — only long args) ----
     * sender pointer (freed by {@link #senderClose}) and the Arrow IPC-encoded schema the
     * native side takes ownership of both FFI structs. Returns {@code 0} on a normal send or
        REGISTER_MEMTABLE_ON_SESSION_CONTEXT = linker.downcallHandle(
    public static void clearColumnIndexCache() {
            throw new IllegalArgumentException("schemaPtr must be non-zero");
        }
        double executionCritical
            logger.debug("Failed to read native memory pool stats", t);
        if (sortFields == null) sortFields = List.of();
        long sessionPtr,
     */
                (long) schemaIpc.length,
    ) {
        long contextId
    ) {
                ValueLayout.ADDRESS,
            lib.find("df_clear_scoped_page_index_cache").orElseThrow(),
        if (arrayPtrs.length != schemaPtrs.length) {
        String tableName,
                java.lang.invoke.MethodType.methodType(int.class, long.class, int.class)
     *
     * @param contextId  the parent {@code AnalyticsQueryTask.getId()}; see
     * Row IDs are passed as a direct buffer pointer (zero-copy from BigIntVector's ArrowBuf).
     * <p>Rust's {@code execute_with_context} takes ownership of the {@code SessionContext} via
                ValueLayout.JAVA_LONG,   // context_id
    public static long[] partitionBatchByHash(long inputArrayPtr, long inputSchemaPtr, int[] hashKeyIndices, int partitionCount) {
    /**
            lib.find("df_shutdown_runtime_manager").orElseThrow(),
        );
            call.invoke(PREPARE_PARTIAL_PLAN, handlePtr, call.bytes(substraitBytes), (long) substraitBytes.length);
                ValueLayout.ADDRESS,
        try (var call = new NativeCall()) {
        );
                storePtr = dataformatAwareStoreHandle.getPointer();
        GET_MEMORY_POOL_STATS = linker.downcallHandle(
 * FFM bridge to native DataFusion library.
        String tableName,
        try {
     * <p>Output ownership: each returned pair is a heap-allocated FFI struct on the Rust side;
                "createProvider",
 * then throws.</p>
            return Collections.emptyMap();
        REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT = linker.downcallHandle(
    public static void cacheManagerAddFiles(long runtimePtr, String[] filePaths) {
        );
                (long) arrayPtrs.length
        try (var call = new NativeCall()) {
            var colNames = call.strArray(columns);
        );
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_LONG,
                storePtr = 0L;
        return SET_SPILL_LIMIT != null;
            boolean hasPlan = planBytes != null && planBytes.length > 0;
                storePtr,
    private static final MethodHandle CLOSE_READER;
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
    }
                ValueLayout.ADDRESS,    // sort_orders_ptr (parallel String[] for index.sort.order: "asc"|"desc")
            )
import org.apache.logging.log4j.LogManager;
        );
     * directly into the caller's final type ({@link QueryExecutionMetrics})
                ValueLayout.JAVA_BYTE,   // requestsRowIds (0/1) — QTF query phase signal
        CACHE_MANAGER_ADD_FILES_WITH_STORE = linker.downcallHandle(
                call.bytes(partialPlanBytes),
            lib.find("df_sender_terminate_early").orElseThrow(),
            lib.find("df_prepare_final_plan").orElseThrow(),
            );
     *
                ValueLayout.JAVA_INT,
            );
import org.apache.logging.log4j.Logger;
     */
            lib.find("df_update_concurrency_gate").orElseThrow(),
 * <p>{@link NativeCall} creates a confined Arena for short-lived allocations (strings, byte
        try (var call = new NativeCall()) {
import java.lang.invoke.MethodHandle;
        }
        long readerPtr,
 * <h2>Arena usage</h2>
                ValueLayout.ADDRESS,    // files_len_ptr
 *
            FunctionDescriptor.of(ValueLayout.JAVA_LONG)
                query.segment(),
        long runtimePtr,
        }
    private static final MethodHandle SHUTDOWN_RUNTIME_MANAGER;
        }
    /**
                SQL_TO_SUBSTRAIT,
        long contextId,
            var outLen = arena.allocate(ValueLayout.JAVA_LONG);
            // Rust passes it through every FFM upcall; Java uses it to look up the
    private static final MethodHandle REGISTER_MEMTABLE_ON_SESSION_CONTEXT;
    /**
                sessionContextHandlePtr,
                f.ptrs(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
                out.lenOut()
        // hash_key_indices_ptr, hash_key_indices_len, partition_count,
        CANCEL_QUERY = linker.downcallHandle(lib.find("df_cancel_query").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
                f.count(),
        SET_MIN_TARGET_PARTITIONS = linker.downcallHandle(
    public static long createCustomCacheManager() {
                ValueLayout.ADDRESS,    // sort_fields_ptr (parallel String[] for index.sort.field)
                ValueLayout.JAVA_LONG,   // runtime_ptr
     * Returns null if no metrics are available (e.g., plan didn't capture them).
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE)
    private static final MethodHandle STREAM_GET_SCHEMA;
                ValueLayout.JAVA_LONG,
        try (var call = new NativeCall()) {
                StatsLayout.readAdaptiveBudgetStats(seg),
                readerPtr,
            FunctionDescriptor.of(
package org.opensearch.be.datafusion.nativelib;
                ValueLayout.JAVA_LONG
                ValueLayout.JAVA_LONG,
                "arrayPtrs.length (" + arrayPtrs.length + ") != schemaPtrs.length (" + schemaPtrs.length + ")"
        int treeShapeOrdinal,
        try (var call = new NativeCall()) {
            lib.find("df_sql_to_substrait").orElseThrow(),
        NativeCall.invokeVoid(DESTROY_CUSTOM_CACHE_MANAGER, ptr);
     * builds a single pushed-down filter plan via the DataFusion DataFrame API, using
        long contextId,
                ValueLayout.JAVA_LONG,
    }
            return call.invoke(CREATE_GLOBAL_RUNTIME, memoryLimit, cacheManagerPtr, dir.segment(), dir.len(), spillLimit);
        if (arrayPtrs.length != schemaPtrs.length) {
        // void df_sender_terminate_early(sender_ptr)
    private static final MethodHandle STREAM_GET_METRICS;
                ValueLayout.ADDRESS,
     */
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
            java.lang.foreign.MemorySegment releaseProviderStub = linker.upcallStub(
import java.util.Map;
            FREE_METRICS_BUF.invokeExact(dataPtr, len);
     */
    /** Returns memory pool stats: [usage_bytes, tripped_count]. Single FFM call. */
            FunctionDescriptor.of(
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
    private static final MethodHandle SET_SCOPED_PAGE_INDEX_ENABLED;
        SENDER_TERMINATE_EARLY = linker.downcallHandle(
    /**
                so.ptrs(),
        );
                ValueLayout.JAVA_BYTE,   // hasPartialAggregate (0/1)
            lib.find("df_partition_batch_by_hash").orElseThrow(),
                ValueLayout.JAVA_LONG,   // shard_view_ptr
        );
     * @param runtimePtr pointer from createGlobalRuntime
     * @param filePaths array of absolute file paths
        CAN_MATCH = linker.downcallHandle(
     * Shrinking evicts LRU entries immediately. Zero is ignored.
        try (var call = new NativeCall()) {
        long runtimePtr,
        }
        }
        }
            lib.find("df_stream_next").orElseThrow(),
    }
        long queryConfigPtr,
    public static long registerMemtableOnSessionContext(
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
                ValueLayout.JAVA_LONG,
                queryConfigPtr,
        } catch (Throwable t) {
        SENDER_SEND = linker.downcallHandle(
            );
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_BYTE,   // deletedDocFilteringRequired (0/1)
        }
                contextId,
        if (arrayPtr == 0) {
     * and CI/OI scoped caches are bypassed entirely.
            long planLen = hasPlan ? planBytes.length : 0L;
    /** Sets the memory guard thresholds (0.0–1.0): admission throttle, admission reject, execution spill, execution critical. */
            java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(outBytes).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        try {
    public static long createLocalSession(long runtimePtr) {
        long[] schemaPtrs
        boolean hasPartialAggregate,
     * When false, spill-cap updates require a node restart — the public
    /**
    private static final MethodHandle CACHE_MANAGER_REMOVE_FILES;
    }
    private static final MethodHandle SENDER_SEND;
        CREATE_CACHE = linker.downcallHandle(
        );
     * {@code -error_ptr}), so {@code checkResult} passes it through without throwing.
                    int.class,
                out.lenOut()
                ValueLayout.JAVA_LONG,  // count (applies to filenames + writer_generations)
     *     done. A Rust-side error throws via {@link NativeCall}.
            );
                queryConfigPtr,
     * {@code Box::from_raw} on entry, regardless of whether the rest of the call then succeeds or
                ValueLayout.ADDRESS,
                ValueLayout.JAVA_LONG,
            lib.find("df_shard_sort_bounds").orElseThrow(),
        try (var call = new NativeCall()) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            call.invoke(STATS, runtimePtr, seg, StatsLayout.LAYOUT.byteSize());
    private static final MethodHandle REGISTER_PARTITION_STREAM;
            call.invoke(CACHE_MANAGER_CLEAR, runtimePtr);
            lib.find("df_destroy_custom_cache_manager").orElseThrow(),
     * versions of the native library.
                ValueLayout.ADDRESS,
        NativeCall.invokeVoid(CLOSE_LOCAL_SESSION, sessionPtr);
}
            var f = call.strArray(filePaths);
        // i64 df_query_registry_top_n_by_current(out_ptr, cap_entries)
                readerPtr,
    private static final MethodHandle DESTROY_CUSTOM_CACHE_MANAGER;
     *         disagreeing on physical type)
     * the per-side partition input alongside the shard-scan listing table on the same session.
        // partial_plan_ptr, partial_plan_len,
        long runtimePtr,
                FETCH_BY_ROW_IDS,
    ) {
        NativeHandle.validatePointer(senderPtr, "sender");
            throw new IllegalArgumentException("input array and schema pointers must be non-zero");
                "createDatafusionReader: sortFields ("
                ValueLayout.ADDRESS,
    /**
            lib.find("df_register_memtable").orElseThrow(),
            lib.find("df_get_memory_pool_usage").orElseThrow(),
        DF_NATIVE_NODE_STATS = linker.downcallHandle(
        try (var call = new NativeCall()) {
                out.getAtIndex(ValueLayout.JAVA_LONG, 2) != 0L,
     *     schema_ptr_0, array_ptr_1, schema_ptr_1, ...]}.
            throw new IllegalArgumentException(
            long result = (long) STREAM_GET_METRICS.invokeExact(streamPtr, outPtr, outLen);
    }
    /** Returns current memory pool limit in bytes. */
                ValueLayout.JAVA_LONG,   // queryConfigPtr
     * Freed by {@link #closeDatafusionReader}.
            return;
        NativeHandle.validatePointer(readerPtr, "reader");
            FunctionDescriptor.of(
    /**
                return null; // no metrics available
                CREATE_SESSION_CONTEXT_INDEXED,
        // Hand the five filter-tree upcall stubs to Rust now. No explicit
                (long) out.capacity(),
            throw new UnsupportedOperationException(
        // i64 df_create_local_session(runtime_ptr)
            NativeHandle.validatePointer(streamPtr, "stream");
                p.len(),
    public static long getMemoryPoolLimit(long runtimePtr) {
     * Sets the byte budget of the process-global scoped ColumnIndex cache.
                internalSearchBound
                inputSchemaPtr,
        );
                treeShapeOrdinal,
     * runtime is in use, so we do not ship this symbol from our Rust crate.
     * Extracts execution metrics from the stream's physical plan as JSON bytes.
        ActionListener<Long> listener
     * The plan is stored on the Rust handle for later execution.
        );
        }
    // ---- Stubs ----
     * schema must match this declaration exactly.
                partitionCount,
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,
    /**
            )
                (long) partialPlanBytes.length
            lib.find("df_free_metrics_buf").orElseThrow(),
            )
    /** Sets the minimum target_partitions floor for the adaptive budget system. */
        try (var call = new NativeCall()) {
    // ---- DataFusion runtime (confined Arena for spillDir string only) ----
     */
            var cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
    }
    }
        );
    // ---- Per-query registry top-N snapshot ----
    }
        SET_MEMORY_GUARD_THRESHOLDS = linker.downcallHandle(
                // Handle closed between check and extraction — use default (local)
                ValueLayout.ADDRESS
                sessionContextHandlePtr,
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
                ValueLayout.ADDRESS,
        try (var call = new NativeCall()) {
     * broadcast injection on the probe side can register its memtable on the same session that
                ValueLayout.JAVA_LONG,   // shard_view_ptr
                    ValueLayout.JAVA_INT,
                ValueLayout.JAVA_LONG,
    private static final MethodHandle CANCEL_QUERY;
            for (int i = 0; i < result.length; i++) {
        }
    }
 */
    private static final MethodHandle REGISTER_MEMTABLE;
     */
                    long.class
        );
            // All five callbacks now receive contextId (long) as their first parameter.
        String tableName,
            );
    public static long fetchByRowIds(
            lib.find("df_stream_get_metrics").orElseThrow(),
                (long) out.capacity(),
        // array_ptrs, schema_ptrs, n_batches,
        try (var call = new NativeCall()) {
    // ---- SessionContext decomposition ----
            var table = call.str(tableName);
                    int.class,
                cb,
                ValueLayout.ADDRESS,
     * Registers the same kind of partitioned streaming input on a {@code SessionContextHandle}, but
            try {
    public record RegisteredInput(long pointer, byte[] schemaIpc) {
        } catch (Throwable t) {
        long readerPtr,
    /**
            throw new IllegalArgumentException("partitionCount must be > 0, got " + partitionCount);
     * @return opaque stream pointer
                // Rust took ownership via Box::from_raw; do not let doClose() double-free.
                readerPtr,
     * <p>Input ownership: the caller's input FFI structs are read but not consumed; the caller
                ValueLayout.ADDRESS,
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        NativeHandle.validatePointer(sessionPtr, "session");
    public static final long INTERNAL_SEARCH_OFF = 0L;
                (long) schemaIpc.length
 *
        try (var call = new NativeCall()) {
                releaseCollectorStub
     * (otherwise {@code No field named sum_qty}). The producer still ships physically-named batches;
     * or {@link #INTERNAL_SEARCH_SEQ_NO_ABOVE}, the native side ignores {@code substraitPlan} and
                ValueLayout.ADDRESS,
    public static void setScopedPageIndexEnabled(boolean enabled) {
import java.lang.foreign.Linker;
            FunctionDescriptor.ofVoid()
            lib.find("df_set_min_target_partitions").orElseThrow(),
        long runtimePtr,
        // Hash-partitions one Arrow C Data batch into N output batches via DataFusion's
        }
        NativeHandle.validatePointer(runtimePtr, "runtime");
    public static RegisteredInput registerMemtable(
                p.segment(),
        EXECUTE_LOCAL_PREPARED_PLAN = linker.downcallHandle(
     */
    /** Sets the memory pool limit at runtime. Takes effect for new allocations only. */
     * @param columns column names to read
    /**
            return NativeNodeStatsLayout.readNativeNodeStats(seg);
        DESTROY_CUSTOM_CACHE_MANAGER = linker.downcallHandle(
        );
        try {
                    ValueLayout.JAVA_LONG
        CREATE_CUSTOM_CACHE_MANAGER = linker.downcallHandle(
                PARTITION_BATCH_BY_HASH,
            NativeHandle.validatePointer(readerPtr, "reader");
                id.len(),
    }
                contextId
        List<org.opensearch.index.engine.exec.MonoFileWriterSet> segments,
 * compatible open source license.
                "releaseProvider",
            return new long[] { 0, 0 };
                    java.lang.foreign.MemorySegment.class,
    private static final MethodHandle CAN_MATCH;
        );
import org.opensearch.be.datafusion.NativeErrorConverter;
            );
     *                            exclude the CombinePartialFinalAggregate optimizer rule
        );
                ),
        // i64 df_prepare_partial_plan(handle_ptr, bytes_ptr, bytes_len)
                    int.class,
            listener.onFailure(e);
            return;
                    long.class,
     * using DataFusion's {@code BatchPartitioner}. The row-to-partition mapping matches
    }
                REGISTER_MEMTABLE,
     * <p>One FFM call: Java allocates an {@code n × ENTRY_BYTES} segment, Rust
                "releaseCollector",
     * Collects all native executor metrics in a single FFM call.
                ValueLayout.JAVA_LONG,
        // are installed and `df_execute_indexed_query` can dispatch into Java.
            call.invoke(CLEAR_SCOPED_PAGE_INDEX_CACHE);
        try (var call = new NativeCall()) {
        );
            NativeHandle.validatePointer(streamPtr, "stream");
    public static long canMatch(long runtimePtr, long shardViewPtr, String columnName, long filterMin, long filterMax) {
     * @param storePtr Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer (from TieredStorageBridge.getObjectStoreBoxPtr)
import java.util.Collections;
                planLen
     * <p>Returns one of {@link #CAN_MATCH_NO}, {@link #CAN_MATCH_YES}, {@link #CAN_MATCH_UNKNOWN} —
    // ---- Reader management (confined Arena for path + file strings) ----
                call.bytes(substraitPlan),
        CLOSE_GLOBAL_RUNTIME = linker.downcallHandle(
        byte[] substraitPlan,
            MethodHandle releaseProvider = lookup.findStatic(
        try (var call = new NativeCall()) {
        byte[] partialPlanBytes,
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_BYTE,   // deletedDocFilteringRequired (0/1)
        );
    public static byte[] sqlToSubstrait(long readerPtr, String tableName, String sql, long runtimePtr) {
            logger.debug("Failed to set min target partitions", t);
     * @param dataformatAwareStoreHandle per-format native store handle (null = local, live = use store pointer)
                cb,
        try (var call = new NativeCall()) {
                ValueLayout.ADDRESS,    // files_len_ptr
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
        Linker linker = Linker.nativeLinker();
        }
        NativeHandle.validatePointer(sessionContextHandlePtr, "sessionContextHandle");
        try (var call = new NativeCall()) {
            return result != 0;
                out.data(),
    private static final MethodHandle CLEAR_SCOPED_PAGE_INDEX_CACHE;
        } catch (Throwable t) {
    }
        // i64 df_shard_sort_bounds(runtime_ptr, shard_view_ptr, column_name_ptr, column_name_len, out_ptr)
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,
    /**
                ValueLayout.JAVA_LONG,
                arena
            listener.onFailure(convertNativeError(t));
        ActionListener<Long> listener
        }
                EXECUTE_QUERY,
                ValueLayout.JAVA_LONG
     *
            listener.onResponse(result);
     * <p>
    private static final MethodHandle CACHE_MANAGER_CLEAR_BY_TYPE;
    public static boolean isSpillLimitDynamic() {
                (long) partialPlanBytes.length,
    public static void cacheManagerRemoveFiles(long runtimePtr, String[] filePaths) {
     */
        REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT_FROM_PARTIAL_PLAN = linker.downcallHandle(
        }
            )
    public static boolean cacheManagerGetItemByCacheType(long runtimePtr, String cacheType, String filePath) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        );
            long result = NativeLibraryLoader.checkResult((long) STREAM_NEXT.invokeExact(streamPtr));
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
     */
                ValueLayout.ADDRESS,
    ) {
            return call.invoke(EXECUTE_LOCAL_PLAN, sessionPtr, call.bytes(substrait), (long) substrait.length, contextId);
                long ctxId = QueryRegistryLayout.readContextId(seg, i);
                releaseProvider,
        // out_ptr, out_cap, out_len)
     * @param substraitBytes Substrait plan bytes
    public static long getMemoryPoolUsage(long runtimePtr) {
                (long) out.capacity(),
            return new RegisteredInput(ptr, out.toByteArray());
     *
        try (var call = new NativeCall()) {
    /** Sets the initial target_partitions for coordinator-reduce sessions. */
     * still owns and must close them via Arrow C Data Interface after this call returns.
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
                REGISTER_PARTITION_STREAM_ON_SESSION_CONTEXT_FROM_PARTIAL_PLAN,
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
     * exception types (e.g. CircuitBreakingException, OpenSearchStatusException).
    private static final MethodHandle GET_MEMORY_POOL_LIMIT;
     *
        );
        // 16N bytes: N (array_ptr, schema_ptr) pairs as parallel little-endian i64s.
                ValueLayout.JAVA_LONG,
import java.util.List;
     * Forward-compat probe for runtime spill-cap updates. Today the upstream
    public static Map<Long, QueryExecutionMetrics> getTopNQueriesByMemory(int n) {
            lib.find("df_close_local_session").orElseThrow(),
            call.invoke(CREATE_CACHE, cacheManagerPtr, type.segment(), type.len(), sizeLimit, eviction.segment(), eviction.len());
     */
     * Snapshot the {@code n} heaviest live queries by {@code current_bytes}.
        }
        try (var call = new NativeCall()) {
        return NativeErrorConverter.convert(ex);
        );
        // i64 df_update_concurrency_gate(gate_name_ptr, gate_name_len, new_max_permits)
                (byte) (hasPartialAggregate ? 1 : 0),
            lib.find("df_execute_query").orElseThrow(),
        STREAM_GET_METRICS = linker.downcallHandle(
            // Task monitors
        try (var call = new NativeCall()) {
        );
    // ---- Coordinator-reduce exports ----
    // ---- Tokio runtime management (no Arena needed — no string/buffer args) ----
/*
                ValueLayout.JAVA_LONG,
    /**
            );
        try (var call = new NativeCall()) {
     * @return opaque stream pointer
     *
     *         (column absent, unsupported physical type, statistics missing, or files
        NativeHandle.validatePointer(senderPtr, "sender");
            lib.find("df_get_memory_pool_limit").orElseThrow(),
                ValueLayout.ADDRESS,
                delegatedPredicateCount,
     * {@link #registerMemtableOnSessionContext}) — the producer side ships record batches whose
    }
     * @param queryConfigPtr pointer to a WireDatafusionQueryConfig struct, or 0 for fallback defaults
    /**
     */
        );
        }
     * EOF, then drops the sender (same teardown as {@link #senderClose}). Used when the Java drain
                sessionContextHandlePtr,
                ValueLayout.ADDRESS,
    }
    private static final Logger logger = LogManager.getLogger(NativeBridge.class);
        );
            var table = call.str(tableName);
                releaseCollector,
                out.data(),
        }
        // col_names_ptr, col_names_len_ptr, col_names_count, runtime_ptr, context_id)
        REGISTER_PARTITION_STREAM = linker.downcallHandle(
    public static void setCancelStatsThresholdMs(long millis) {
            var id = call.str(inputId);
        if (schemaPtr == 0) {
    }
     * @param sessionPtr pointer returned by {@link #createLocalSession}
            )
        // ── Coordinator-reduce bindings ──
        CREATE_WORKER_SESSION_CONTEXT = linker.downcallHandle(
        if (partitionCount <= 0) {
                ValueLayout.JAVA_LONG,   // return: 1=Yes, 0=No, -1=Unknown
    /**
                ValueLayout.JAVA_INT,
            java.lang.foreign.MemorySegment createCollectorStub = linker.upcallStub(
    /** Convenience overload with default 1.5x multipliers for both gates. */
    }
        NativeHandle.validatePointer(runtimePtr, "runtime");
        );
                ValueLayout.ADDRESS,
import java.util.LinkedHashMap;
            lib.find("df_execute_with_context").orElseThrow(),
    public static byte[] streamGetMetrics(long streamPtr) {
        try (var arena = Arena.ofConfined()) {
    /**
     * {@code Data.importVectorSchemaRoot} and closes the wrappers when done.
import java.lang.foreign.MemorySegment;
        // i64 df_sender_fail(sender_ptr, reason_ptr, reason_len)
    }
                ValueLayout.JAVA_LONG    // filter_max
     * @param segments per-segment metadata — each carries a single filename and writer generation
    /** {@link #canMatch} status: undeterminable (no statistics, unreadable footer) — keep the shard. */
                out.data(),
     * Queries cancelled for less than this duration are not counted in stats.
            return call.invoke(
    /** Returns current memory pool usage in bytes. */
    /**
            lib.find("df_prepare_partial_plan").orElseThrow(),
    private static final MethodHandle INIT_RUNTIME_MANAGER;
        } catch (Throwable t) {
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_BYTE,   // hasPartialAggregate (0/1)
     * consumer's {@code RecordBatchStream} yields an ERROR (failing the join/agg) instead of a clean
    }
        );
                rowIdsBufAddr,
                ValueLayout.JAVA_LONG,
    // ---- Distributed aggregate: prepare partial/final plans ----
            FunctionDescriptor.of(
            long written = call.invoke(QUERY_REGISTRY_TOP_N_BY_CURRENT, seg, (long) n);
                collectDocs,
        }
     * overlapping the range [filterMin, filterMax] on the named column.
                ValueLayout.JAVA_LONG,
     */
        SET_OFFSET_INDEX_CACHE_LIMIT = linker.downcallHandle(
        if (sortFields.size() != sortOrders.size()) {
     * <p>The schema is taken as IPC bytes (the same shape as
                ValueLayout.JAVA_LONG   // sort_count (0 when index has no sort)
        // NOT from our NativeHandle lifecycle — validate as non-zero rather than live-handle.
                ValueLayout.ADDRESS,
 * this file be licensed under the Apache-2.0 license or a
     * on the next try_grow.
            throw new IllegalArgumentException("arrayPtr must be non-zero");
            long planLen = hasPlan ? planBytes.length : 0L;
    private static final MethodHandle SET_MIN_TARGET_PARTITIONS;
            FunctionDescriptor.of(
     *
                ValueLayout.JAVA_LONG,
        try (var call = new NativeCall()) {
     * {@code RepartitionExec} / {@code HashJoinExec} so producers and probe-side consumers
     * @throws IllegalStateException if the FFM function returns a non-zero error code
     * buffer is unspecified.
            )
        byte[] planBytes
            )
     *         with at most {@code n} entries.
                ValueLayout.ADDRESS,     // plan_ptr
    /**
        Exception ex = t instanceof Exception e ? e : new RuntimeException(t);
     * Executes a query and returns an opaque stream pointer via {@code listener}.
        // i64 df_register_partition_stream(session_ptr, input_id_ptr, input_id_len,
    }
                gens,
    private static final MethodHandle SENDER_CLOSE;
    }
            )
            lib.find("df_create_reader").orElseThrow(),
                f.lens(),
        CREATE_SESSION_CONTEXT = linker.downcallHandle(
    }
                contextId,
    /** {@code internal_search_mode}: get-by-row-id — native plan filters {@code __row_id__ = bound}, {@code substraitPlan} ignored. */
     */
        EXECUTE_LOCAL_PLAN = linker.downcallHandle(
     */
        CACHE_MANAGER_CLEAR = linker.downcallHandle(
            try {
     * rides the success half of the native return contract ({@code >= 0} success, {@code < 0}
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        } catch (Throwable t) {
     * Prepares a final-aggregate physical plan on a local session.
            );
                ValueLayout.JAVA_LONG,
                ValueLayout.ADDRESS,
            }
    private static final MethodHandle STREAM_NEXT;
     * non-zero return is interpreted by {@link NativeCall} as a Rust-side error (the message is
                ValueLayout.JAVA_LONG,
                ValueLayout.JAVA_LONG,
     * native session settled on after lowering.
        if (n == 0) {
            FunctionDescriptor.of(
     * becomes non-null automatically — the same Java JAR works against both
                sessionPtr,
    private static final MethodHandle CLOSE_SESSION_CONTEXT;
            var plan = call.bytes(substraitPlan);
                null,
        // Java JAR is forward-compatible with a future native library that ships it.
                releaseProviderStub,
     * Pushes one Arrow C Data-exported batch (array + schema addresses) into the sender. The
     * Reads native task cancellation counters via {@code df_native_node_stats} FFM call.
                ValueLayout.ADDRESS,    // sort_orders_len_ptr
            var f = call.strArray(filePaths);
    public static final long CAN_MATCH_YES = 1L;
     */
    public static void streamGetSchema(long streamPtr, ActionListener<Long> listener) {
     * thread hits a mid-stream failure (e.g. a spill-read error) that truncates the partition —
        NativeHandle.validatePointer(readerPtr, "reader");
        // i64 df_fetch_by_row_ids(shard_view_ptr, row_ids_buf_ptr, row_ids_count,
    private static final MethodHandle CACHE_MANAGER_GET_TOTAL_MEMORY;
                throw new IllegalStateException(
        CLOSE_READER = linker.downcallHandle(lib.find("df_close_reader").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
    }
        if (dataformatAwareStoreHandle != null) {
     * Decodes directly from the MemorySegment — no intermediate long[].
            )
        SET_SCOPED_PAGE_INDEX_ENABLED = linker.downcallHandle(
        // i64 df_cache_manager_clear_by_type(runtime_ptr, type_ptr, type_len)
                REGISTER_MEMTABLE_ON_SESSION_CONTEXT,
                ValueLayout.JAVA_LONG   // files_count
                (long) hashKeyIndices.length,
     * Converts a Throwable from the FFM boundary into an appropriate Exception, applying
     *
        CREATE_LOCAL_SESSION = linker.downcallHandle(
        // Returns the PartitionStreamSender pointer (cast to i64) for the M2 hash-shuffle worker.
     * @param tableName the logical table name (alias/pattern) to register the table under
            }
     * that cannot be safely mutated through {@code Arc<DiskManager>} once the
                runtimePtr,
        }
     * EOF after it drains them.
    }
        }
        NativeCall.invokeVoid(STREAM_CLOSE, streamPtr);
     * {@link UnsupportedOperationException} when the loaded native library does not
                FunctionDescriptor.of(
                (byte) (deletedDocFilteringRequired ? 1 : 0),
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
                ValueLayout.JAVA_LONG,   // column_name_len
     *
        String inputId,
                sf.count()
            var taskMonitors = new LinkedHashMap<String, TaskMonitorStats>();
            return call.invoke(CAN_MATCH, runtimePtr, shardViewPtr, cn.segment(), cn.len(), filterMin, filterMax);
        long[] arrayPtrs,
        long storePtr = 0L;
        }
            lib.find("df_register_partition_stream_on_session_context").orElseThrow(),
            var type = call.str(cacheType);
        }
    private NativeBridge() {}
     * schema, and downstream callers decode it once into an Arrow {@link org.apache.arrow.vector.types.pojo.Schema}.
                ValueLayout.JAVA_LONG
                ValueLayout.JAVA_LONG,
            );
        );
     * Shrinking evicts LRU entries immediately. Zero is ignored.
     * @param substraitBytes Substrait plan bytes
    /** Closes the sender, signalling end-of-input. Tolerates a zero pointer. */
        }
            var f = call.strArray(filePaths);
            lib.find("df_sender_fail").orElseThrow(),
        );
     * Executes a Substrait plan against the configured SessionContext.
     *
