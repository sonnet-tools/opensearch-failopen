    @Override
    }
    );  
                    Map.entry(ScalarFunction.STRFTIME, new StrftimeFunctionAdapter()),  
import org.apache.arrow.vector.BigIntVector;
import org.opensearch.be.datafusion.indexfilter.FilterTreeCallbacks;  
     * DataFusion threadpool. Returns {@code 1} if the cluster has no data nodes (gates the
        // coordinator, it hands over a DataFusionReduceState carrying the session +
                    // after the spath auto-extract lowering). The filter-rule's field-index
        ScalarFunction.FLOOR,
import org.opensearch.analytics.spi.ProjectCapability;
                    Map.entry(ScalarFunction.TIME_DIFF, new TimeDiffAdapter()),  
        ScalarFunction.TIMESTAMPADD,  
    ) {
        // which expand to {@code DIVIDE(agg * scale, TIMESTAMPDIFF('MILLISECOND', @timestamp,
                    Map.entry(ScalarFunction.JSON_KEYS, new JsonFunctionAdapters.JsonKeysAdapter()),  
                    Map.entry(ScalarFunction.LESS_THAN, comparisonTemporalCoercion),
    }
        ScalarFunction.JSON_OBJECT,
        ScalarFunction.JSON,  
        ScalarFunction.REGEXP_CONTAINS,
                    Map.entry(ScalarFunction.JSON_DELETE, new JsonFunctionAdapters.JsonDeleteAdapter()),
        // registered senders. The sink drives executeLocalPreparedPlan against that
        DataFusionService svc = plugin.getDataFusionService();
                    caps.add(new ProjectCapability.Scalar(op, Set.of(FieldType.ARRAY), formats, true));
                    Map.entry(ScalarFunction.SECOND, second),  
        // Calcite TIME / DATE on the RexCall return type, so downstream consumers  
            @Override
        // PPL WEEKDAY — date_part('dow') remapped to MySQL Mon=0..Sun=6.  
                );
import org.opensearch.analytics.spi.AggregateFunction;  
                    context.allocator(),
    // from the eval column's inferred type (e.g. JSON_ARRAY_LENGTH returns INTEGER_FORCE_NULLABLE).
                return Set.of(DelegationType.FILTER);  
     * {@code OpenSearchProjectRule.resolveScalarViableBackends} keys on the call's return
                int partitionCount,
        // see a real time/date type and Isthmus serializes accordingly.
                    Map.entry(ScalarFunction.RAND, new RandSeedAdapter()),
                    Map.entry(ScalarFunction.MINUTE_OF_HOUR, minute),  
            if (dataFusionService == null) {
        // (DataFusion runs in UTC by default; PPL UTC_* just force UTC semantics).
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        ScalarFunction.ARRAY_LENGTH,  
import org.opensearch.analytics.spi.IntegerRoundingCastAdapter;
    private static final Set<ScalarFunction> MAP_RETURNING_PROJECT_OPS = Set.of(
import org.opensearch.analytics.spi.DelegationType;  
    );
                    Map.entry(ScalarFunction.SYSDATE, now),
     * {@code make_array} via {@link MakeArrayAdapter}. {@code ARRAY_SLICE} and  
    // CONCAT in ScalarFunction); SAFE_CAST covers PPL `eval`'s explicit nullable `CAST(... AS ...)`
        Reader reader,
                DatePartAdapters day = DatePartAdapters.day();
                            WindowFunction.COUNT,
        // TPC-H q15). The memtable sink buffers each input fully in Java first, so no bounded native
            ) {
                ScalarFunctionAdapter now = new NowFspAdapter();  
     * base cannot be instantiated directly.  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        ScalarFunction.CURTIME,  
        ScalarFunction.RANGE_BUCKET,
                        caps.add(new ProjectCapability.Scalar(op, Set.of(ft), formats, true));
        ScalarFunction.IS_NOT_TRUE,  
     * over array-typed values, so we don't want them claiming viability there).  
                return Set.of(
                    Map.entry(ScalarFunction.DATE, new DateTimeAdapters.DateAdapter()),  
        // UDF natively; same shape as CIDRMATCH.
        ScalarFunction.FROM_UNIXTIME,
        if (svc == null) {  
            @Override
    // DataFusion's native runtime can execute (see DataFusionFragmentConvertor for the conversion
                            WindowFunction.NTH_VALUE,
                    Map.entry(ScalarFunction.LOCATE, new PositionAdapter()),
        ScalarFunction.LATEST,  
                            JoinCapability.JoinKind.CROSS
        ScalarFunction.NUMBER_TO_STRING,  
        ScalarFunction.MONTH,
                    WindowFunction.ARG_MIN,  
                return Set.of(new ScanCapability.DocValues(formats, Set.copyOf(SUPPORTED_FIELD_TYPES)));  
                    Map.entry(ScalarFunction.MONTH, month),  
                    Map.entry(ScalarFunction.LOG, new NumericToDoubleAdapter(SqlLibraryOperators.LOG)),  
        ScalarFunction.CBRT,  
        // dedicated Rust UDF (rust/src/udf/<name>.rs). Declared here so the analytics planner  
     * isn't pinned by the operator. One partition per data node maximizes parallelism without
                    Map.entry(ScalarFunction.GREATER_THAN, comparisonTemporalCoercion),  
                );
        // json_valid returns BOOLEAN, so it is a valid filter predicate (e.g. `where
import org.opensearch.analytics.spi.ExchangeSinkProvider;
    // here only after verifying the function deserializes through Substrait isthmus into a plan
        ScalarFunction.MEMK,
                DataFusionSessionState sessionState = (DataFusionSessionState) backendContext;  
        // PPL `datetime(expr)` — parse/cast into a TIMESTAMP. Routes to DF's
    // implicit result-type narrowing PPL inserts after a UDF call whose declared return type differs
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
        ScalarFunction.IS_NOT_NULL,  
                DateTimeAdapters.CurrentTimeAdapter currentTime = new DateTimeAdapters.CurrentTimeAdapter();
import org.apache.logging.log4j.LogManager;
                    Map.entry(ScalarFunction.SEC_TO_TIME, new SecToTimeAdapter()),
        ScalarFunction.ITEM,
     */  
                for (ScalarFunction op : STANDARD_FILTER_OPS) {
        ScalarFunction.SPAN,  
        ScalarFunction.DAY_OF_YEAR,
                // are distinguishable in mixed traces.  
        // supports 10 composite units (DAY_SECOND → ddHHmmss etc.) that are not a
        // PPL epoch-arithmetic datetime scalars — lower to to_unixtime/from_unixtime + integer math.  
                    Map.entry(ScalarFunction.ARRAY_JOIN, new ArrayToStringAdapter()),
        ScalarFunction.UTC_TIME,
        ScalarFunction.AND,
        // TIMESTAMPADD('MINUTE', 1, @timestamp)))}. Both PPL UDFs are unknown to isthmus's  
        ScalarFunction.COT,
        ScalarFunction.SARG_PREDICATE,  
                        : Set.copyOf(SUPPORTED_FIELD_TYPES);  
                    Map.entry(ScalarFunction.HOUR, hour),
            }  
        ScalarFunction.IS_FALSE,
                }
    private static final Logger LOGGER = LogManager.getLogger(DataFusionAnalyticsBackendPlugin.class);
        // Date-part extractors rewrite to date_part(<unit>, ts) via DatePartAdapters.
        ScalarFunction.DATE,  
    /**  
import org.opensearch.analytics.planner.CalciteToArrowSchema;  
        ScalarFunction.LIKE,  
                // Stateless cast adapter shared between CAST and SAFE_CAST registrations.
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
        }
                    // every other op (UPPER, ABS, ...) — those genuinely don't return arrays.  
                count,
        // Array functions whose RETURN type is element-typed (not ARRAY itself), so the
            throw new IllegalStateException("No DatafusionReader available for fetch-by-row-ids");  
                    Map.entry(ScalarFunction.ADDTIME, new AddSubTimeAdapter(true)),
        ScalarFunction.DUR2SEC,
                    Map.entry(ScalarFunction.SIN, new NumericToDoubleAdapter(SqlStdOperatorTable.SIN)),
                    Map.entry(ScalarFunction.JSON, new JsonFunctionAdapters.JsonAdapter()),
                    if (dfReader != null) {
        AggregateFunction.AVG,  
        ScalarFunction.GREATER_THAN,
        // per-adapter Javadoc for semantics + collision notes.  
        ScalarFunction.TIMES,
        ScalarFunction.ARRAY,
                RustUdfDateTimeAdapters.OsWeekAdapter week = new RustUdfDateTimeAdapters.OsWeekAdapter();
     *
                    Map.entry(ScalarFunction.MINUS, new MinusAdapter()),
     * auto-extract mode; routes to the {@code json_extract_all} Rust UDF via
        long bufAddr = rowIdVector.getDataBuffer().memoryAddress();
        ScalarFunction.POWER,
                    Map.entry(ScalarFunction.DIVIDE, new DivideAdapter()),
                    Map.entry(ScalarFunction.MVAPPEND, new MvappendAdapter()),
        ScalarFunction.RMUNIT,
                    Map.entry(ScalarFunction.TO_DAYS, new EpochArithmeticAdapters.ToDaysAdapter()),
    }
        ScalarFunction.HOUR,  
                    Map.entry(ScalarFunction.ATAN2, new NumericToDoubleAdapter(SqlStdOperatorTable.ATAN2)),  
        // PPL conversion family — all five route through ConversionFunctionAdapter to a
        ScalarFunction.TAN,
        ScalarFunction.IS_NOT_TRUE,  
        // JSON_EXTRACT_ALL — return type is MAP<VARCHAR, VARCHAR>, so its capability
        ScalarFunction.PATTERN_PARSER
        if (inputCount > 1 && preparedState == null) {  
                    Map.entry(ScalarFunction.SUBTIME, new AddSubTimeAdapter(false)),
import java.util.Set;  
            public ExchangeSink createBroadcastCaptureSink(  
                return ENGINE_CAPS;  
                    Map.entry(ScalarFunction.MOD, new ModAdapter()),
            public Set<AggregateCapability> aggregateCapabilities() {  
                    Map.entry(ScalarFunction.DATETIME, new DateTimeAdapters.DatetimeAdapter()),
                    WindowFunction.DISTINCT_COUNT_APPROX,
                return Set.copyOf(caps);
    @Override  
        ScalarFunction.SAFE_CAST,
                    new DataTransferCapability(DataTransferCapability.Kind.PRODUCER, "arrow-ipc-partitioned"),  
        ScalarFunction.GET_FORMAT,  
        ScalarFunction.OR,  
        // standard scalar FieldType and matches against SUPPORTED_FIELD_TYPES.
                    Map.entry(ScalarFunction.REX_EXTRACT_MULTI, new RexExtractMultiAdapter()),  
        ScalarFunction.ABS,
        // {@code date_trunc(unit, field)}. Both targets are substrait-default operators.
            }  
     * over-subscribing — additional partitions on the same node would queue on the same  
                    Map.entry(ScalarFunction.SHA2, new Sha2FunctionAdapter()),
                    Map.entry(ScalarFunction.SUBSTRING, nameMapping(SqlStdOperatorTable.SUBSTRING)),  
import org.opensearch.analytics.spi.ScanCapability;  
     * Project-side scalar functions whose return type is {@code ARRAY}. Registered separately
        DataFusionReduceState preparedState = backendContext instanceof DataFusionReduceState s ? s : null;
        int dataNodeCount = state.nodes().getDataNodes().size();  
    public EngineResultStream fetchByRowIds(
import org.opensearch.analytics.spi.BackendCapabilityProvider;
     * {@code ARRAY_DISTINCT} pass through by name (Calcite stdlib operator names match
                            JoinCapability.JoinKind.RIGHT,
                    Map.entry(ScalarFunction.ARRAY, new MakeArrayAdapter()),  
    }  
        // rejects the operator with "No backend supports scalar function [CASE] among [datafusion]"
                    Map.entry(ScalarFunction.ROUND, new IntegerRoundingCastAdapter(SqlStdOperatorTable.ROUND)),  
        BackendExecutionContext backendContext
        ScalarFunction.SECOND_OF_MINUTE,
        ScalarFunction.REGEXP_REPLACE,
                    }  
                    Map.entry(ScalarFunction.NOT_EQUALS, comparisonTemporalCoercion),
                    new DataTransferCapability(DataTransferCapability.Kind.CONSUMER, "arrow-ipc-partitioned")
                    WindowFunction.COUNT,
    public void cancelByContext(long contextId) {
        ScalarFunction.RIGHT,
                    Map.entry(ScalarFunction.PERIOD_DIFF, new PeriodArithmeticAdapters.PeriodDiffAdapter()),
     * meaningful semantics over map-typed values; the value-level type emerges after the
    /**
import org.opensearch.analytics.spi.DataTransferCapability;
                    Map.entry(ScalarFunction.CAST, ipBinaryCast),
        ScalarFunction.REX_EXTRACT,  
        return new DataFusionFragmentConvertor(plugin.getSubstraitExtensions());  
        // Multi-input coordinator operators (Join, Union) use the buffered memtable sink. The  
        ScalarFunction.EXP,
 * The OpenSearch Contributors require contributions made to  
                    // TIMESTAMPDIFF / TIMESTAMPADD have no substrait bindings; adapters rewrite to  
                return new DatafusionPartitionedSink(  
    // keeps the capability declaration complete for auditing and symmetric with PROJECT_OPS.  
    }
            // dfReader may be null for hash-shuffle worker fragments — those have no shard scan
            public Set<DataTransferCapability> dataTransferCapabilities() {  
        ScalarFunction.CURRENT_DATE,  
import org.opensearch.analytics.spi.DelegationThreadTracker;
                List<String> targetWorkerNodeIds,  
                    // Coerce a bare character operand to TIMESTAMP when compared against a temporal
        };
        // channel sits in the input path. Falls back to streaming only when a prepared state is  
    private final DataFusionPlugin plugin;
                    Map.entry(ScalarFunction.MAKEDATE, new RustUdfDateTimeAdapters.MakedateAdapter()),  
                dfReader.getReaderHandle().getPointer(),
    // Filter-side scalar functions DataFusion can evaluate natively. Comparisons, arithmetic
import org.opensearch.analytics.spi.WindowFunctionAdapter;
                    Map.entry(ScalarFunction.JSON_EXTRACT_ALL, new JsonFunctionAdapters.JsonExtractAllAdapter()),
                String logTag = context.queryId() + "/stage=" + context.stageId();
        DelegationThreadTracker tracker,
                    Map.entry(ScalarFunction.JSON_ARRAY, new JsonFunctionAdapters.JsonArrayAdapter()),  
 * <p>
                    new WindowCapability(  
        ScalarFunction.LTRIM,  
                    Map.entry(ScalarFunction.MEMK, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.MEMK)),
                    caps.add(new FilterCapability.Standard(op, Set.of(FieldType.MAP), formats));
     */  
            : "streaming";
        ScalarFunction.EXTRACT,  
     * Returns a cleanup action that removes the binding when execution finishes.
                    hashKeyChannels,
                    Map.entry(ScalarFunction.NOW, now),
                    Map.entry(ScalarFunction.MONTH_OF_YEAR, month),
                    // "No backend can evaluate filter predicate [...] on fields [<col>:MAP]".
            @Override
        ScalarFunction.NOT_EQUALS,
        ScalarFunction.CASE,  
                    Map.entry(ScalarFunction.GREATER_THAN_OR_EQUAL, comparisonTemporalCoercion),
            // here — the shard-scan case is already covered by the throw inside the  
        ScalarFunction.CTIME,
        ScalarFunction.YEAR,
                    Map.entry(ScalarFunction.EXTRACT, new RustUdfDateTimeAdapters.ExtractAdapter()),
                    Map.entry(ScalarFunction.MINUTE, minute),
        // to a Substrait IfThen rel — no extension lookup needed, no adapter required. DataFusion's
            public Set<EngineCapability> supportedEngineCapabilities() {
        // Logical connectives — emitted in projections where boolean expressions are composed:
        // PPL `TIMESTAMPDIFF(unit, t1, t2)` / `TIMESTAMPADD(unit, n, t)` — lowering target for  
        // concurrently with feeds; for a multi-input operator that can deadlock (a HashJoinExec
            @Override
        ScalarFunction.WEEK_OF_YEAR,
 *
                // PPL-form aggregates (ARG_MIN/MAX, DISTINCT_COUNT_APPROX) are advertised here and
                    Map.entry(ScalarFunction.CONVERT, new ConvAdapter()),
            }
                    Map.entry(ScalarFunction.YEAR, DatePartAdapters.year()),  
                    caps.add(new ProjectCapability.Scalar(op, Set.of(FieldType.MAP), formats, true));
        ScalarFunction.SINH,
        AggregateFunction.ARG_MIN,  
                    Map.entry(ScalarFunction.FROM_DAYS, new EpochArithmeticAdapters.FromDaysAdapter()),  
     * DataFusion's native names — isthmus default catalog binds them).
        ScalarFunction.NOT,
                    Map.entry(ScalarFunction.ASIN, new NumericToDoubleAdapter(SqlStdOperatorTable.ASIN)),
                    Map.entry(ScalarFunction.MINSPAN_BUCKET, new MinspanBucketAdapter()),  
     * {@link #SUPPORTED_FIELD_TYPES} (filter and aggregate operators have no meaningful semantics
                    Map.entry(ScalarFunction.LN, new NumericToDoubleAdapter(SqlStdOperatorTable.LN)),
        ScalarFunction.IS_FALSE,
                Set<ProjectCapability> caps = new HashSet<>();
     * because the capability lookup keys on the call's return type, and for these the lookup  
                    Map.entry(ScalarFunction.QUARTER, DatePartAdapters.quarter()),
            @Override  
                            JoinCapability.JoinKind.FULL,
                    Map.entry(ScalarFunction.JSON_APPEND, new JsonFunctionAdapters.JsonAppendAdapter()),
        ScalarFunction.TIMES,
                    Map.entry(ScalarFunction.MVFIND, new MvfindAdapter()),
                    Map.entry(ScalarFunction.LOG2, new NumericToDoubleAdapter(SqlLibraryOperators.LOG2)),
        SUPPORTED_FIELD_TYPES.addAll(FieldType.date());  
        if (contextId != 0) {
                    Map.entry(ScalarFunction.DATEDIFF, new DateDiffAdapter()),  
        ScalarFunction.MINUS,
        ScalarFunction.SAFE_CAST,  
                DatePartAdapters month = DatePartAdapters.month();
            NativeBridge.cancelQuery(contextId);  
                return Set.of(
        // the integer-days form is normalized to INTERVAL N DAY. DATE / TIMESTAMP bases only.
        return NativeErrorConverter.convert(original);
        ScalarFunction.IN,
            }
                    Map.entry(ScalarFunction.NUMBER_TO_STRING, new ToStringFunctionAdapter()),  
                    Map.entry(ScalarFunction.MINUTE_OF_DAY, new MinuteOfDayAdapter()),
                    Map.entry(ScalarFunction.JSON_ARRAY_LENGTH, new JsonFunctionAdapters.JsonArrayLengthAdapter()),
                    Map.entry(ScalarFunction.JSON_OBJECT, new JsonFunctionAdapters.JsonObjectAdapter()),
                    // MAP-typed fields enter the filter rule when the predicate is
import org.opensearch.analytics.spi.FilterCapability;  
        // Pass row IDs to Rust via BigIntVector's direct buffer (zero-copy at FFM).  
        ScalarFunction.PLUS,  
        AggregateFunction.ARG_MAX
            }  
        ScalarFunction.CAST,
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        ScalarFunction.ITEM,
        // ABS / SUBSTRING — PPL sort-pushdown moves these into the project tree; DataFusion has
                    Map.entry(ScalarFunction.UTC_TIMESTAMP, now),
        // FieldType.KEYWORD (renamed to DataFusion `array_to_string` via {@link ArrayToStringAdapter}).  
                    Map.entry(ScalarFunction.CEIL, new IntegerRoundingCastAdapter(SqlStdOperatorTable.CEIL)),  
                    Map.entry(ScalarFunction.COT, new NumericToDoubleAdapter(SqlStdOperatorTable.COT)),  
    public Runnable configureFilterDelegation(
        ScalarFunction.ARRAY_SLICE,  
        ScalarFunction.NULLIF,  
    private ExchangeSink buildReduceSink(ExchangeSinkContext ctx, BackendExecutionContext backendContext) {
        // cooperatively. No-op for an unknown contextId.
    ) {  
                    Map.entry(ScalarFunction.JSON_EXTEND, new JsonFunctionAdapters.JsonExtendAdapter()),  
        ScalarFunction.MSTIME,  
        EngineCapability.UNION,  
    // are all supported via the Substrait default extension catalog. AND/OR/NOT are recursed into
            return new DatafusionMemtableReduceSink(ctx, svc.getNativeRuntime());
        // requestClose owns handle.close(): late release upcalls from partially-consumed
        ScalarFunction.TIME,
                    Map.entry(ScalarFunction.CURRENT_TIMESTAMP, now),
import org.opensearch.analytics.spi.BackendExecutionContext;  
        ScalarFunction.CONCAT_FUNCTION,  
        // collects its build side fully before the probe, so a build-side producer back-pressuring  
                    Map.entry(ScalarFunction.BINARY, new BinaryFunctionAdapter()),
                    Map.entry(ScalarFunction.MVZIP, new MvzipAdapter()),  
 */  
        ScalarFunction.LOG2,  
                    Map.entry(ScalarFunction.DAYOFWEEK, dayOfWeek),
        if (dataFusionService == null) {
}  
                            JoinCapability.JoinKind.INNER,
            );
        // PPL `span(field, interval, unit?)` — bucketing for `stats … by span(...)`. Numeric  
                    Map.entry(ScalarFunction.SAFE_CAST, ipBinaryCast),
                    // shape `ITEM(map_field, key) <op> literal` (PPL `where doc.user.name = 'John'`  
                    Map.entry(ScalarFunction.CURRENT_TIME, currentTime),  
                // ScalarFunction.fromSqlFunction resolves by enum name.  
    }
        ScalarFunction.ROUND,
        if ("memtable".equals(mode) && inputCount == 1 && preparedState == null) {
     * shuffle rule out and falls back to coordinator-centric).
                    Map.entry(ScalarFunction.TIME_FORMAT, new RustUdfDateTimeAdapters.TimeFormatAdapter()),
        ScalarFunction.QUARTER,  
        // lower to MIN/MAX OVER () empty-partition window aggregates — exercised end-to-end
                    // operand — recovers the coercion lost when RelDecorrelator folds the PPL
        // DAYNAME / MONTHNAME rewrite to date_format(x, '%W') / ('%M') — %W / %M  
                    Map.entry(ScalarFunction.SCALAR_MAX, nameMapping(SqlLibraryOperators.GREATEST)),
                for (ScalarFunction op : STANDARD_PROJECT_OPS) {
        // builtin `to_timestamp` via DatetimeAdapter.  
                ScalarFunctionAdapter comparisonTemporalCoercion = new IpComparisonNormalizationAdapter(
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
        };  
                SecondAdapter second = new SecondAdapter();
            public ExchangeSink createPartitionedSink(  
     * Registered separately because the capability lookup at
                    Map.entry(ScalarFunction.REX_EXTRACT, new RexExtractAdapter()),
        ScalarFunction.ARRAY_JOIN,
    }
        ScalarFunction.LEFT,  
        ScalarFunction.LESS_THAN,
    public ExchangeSinkProvider getExchangeSinkProvider() {  
                    WindowFunction.ARG_MAX,
    );
        DatafusionReader dfReader = null;
                    Map.entry(ScalarFunction.MKTIME, new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.MKTIME)),
        ScalarFunction.CIDRMATCH,
        // PPL `mvindex(arr, N)` single-element form.
        ScalarFunction.ACOS,
        ScalarFunction.MOD,
                    Map.entry(ScalarFunction.PERIOD_ADD, new PeriodArithmeticAdapters.PeriodAddAdapter()),
                // queryId+stageId+side are stamped onto the framework-provided sender; the sink
                for (ScalarFunction op : POLYMORPHIC_RETURN_PROJECT_OPS) {  
        FilterTreeCallbacks.register(contextId, handle, tracker);
            }  
                    caps.add(new ProjectCapability.Scalar(op, types, formats, true));
        ScalarFunction.PARSE,  
 * Receives the fully-initialized {@link DataFusionPlugin} instance via its single-arg
                dataFusionService.getNativeRuntime().get(),  
            if (backendContext != null) {
        ScalarFunction.DATE_FORMAT,
                            WindowFunction.SUM,
            @Override  
                DatePartAdapters minute = DatePartAdapters.minute();
        // and PPL-specific NULL-on-negative / year-wraparound behavior; DATE_FORMAT  
                    Map.entry(ScalarFunction.DATE_SUB, new DateAddSubAdapter(false)),  
    @Override  
                context.setSessionContextHandle(sessionState.sessionContextHandle());
                    Map.entry(ScalarFunction.ARRAY_LENGTH, new IntegerReturnWideningCastAdapter()),
        int inputCount = ctx.childInputs().size();
        ScalarFunction.ADDTIME,
            @Override
                    Map.entry(ScalarFunction.UNIX_TIMESTAMP, new UnixTimestampAdapter()),
                    Map.entry(ScalarFunction.SUBSTR, nameMapping(SqlStdOperatorTable.SUBSTRING)),
        ScalarFunction.RADIANS,  
                    Map.entry(ScalarFunction.SPAN, new SpanAdapter()),  
    @Override
        // RANGE_BUCKET reach through `bin <f> bins=N` / `minspan=N` / `start=X end=Y`, which  
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;  
        ScalarFunction.SPAN_BUCKET,
        // directly (e.g., from a REST action) without going through the SPI.
    // Project-side scalar functions DataFusion can evaluate natively. Each entry corresponds to a
        ScalarFunction.MVZIP,
        // date_format UDF already uses.
    private static final Set<ScalarFunction> POLYMORPHIC_RETURN_PROJECT_OPS = Set.of(ScalarFunction.CAST, ScalarFunction.SAFE_CAST);
        ScalarFunction.GREATER_THAN,  
            ? plugin.getClusterService().getClusterSettings().get(DataFusionPlugin.DATAFUSION_REDUCE_INPUT_MODE)  
                    Map.entry(ScalarFunction.DAYNAME, new RustUdfDateTimeAdapters.DaynameAdapter()),
    // PPL command/function we want the analytics-engine planner to route through DataFusion. Add  
import org.opensearch.be.datafusion.planner.adapter.TimeConversionFunctionAdapter;
                    // path fails with "Unable to convert call EXP(i32?)" / "POWER(i32?, fp64)" etc.
                    Map.entry(ScalarFunction.WEEK_OF_YEAR, week),
                    Map.entry(ScalarFunction.CONVERT_TZ, new ConvertTzAdapter()),  
                    Map.entry(ScalarFunction.REX_OFFSET, new RexOffsetAdapter()),
import org.opensearch.index.shard.IndexShard;
import org.opensearch.analytics.spi.JoinCapability;  
                // Stateless adapter shared across the six comparison operators. Wrapped by
                            WindowFunction.ARG_MIN,
        // builtins `to_time` / `to_date` via TimeAdapter / DateAdapter. Safe on  
                    Map.entry(ScalarFunction.LAST_DAY, new LastDayAdapter()),
import java.util.List;
        // Single-input: honor the mode setting (memtable buffers; streaming default streams).  
        // Niladic now/current_* family maps 1:1 to DF builtins. SYSDATE is an  
                    Map.entry(ScalarFunction.CURTIME, currentTime),
        ScalarFunction.TRANSLATE,
                IpBinaryCastFunctionAdapter ipBinaryCast = new IpBinaryCastFunctionAdapter();  
        // to preserve MySQL semantics that DataFusion builtins don't match: EXTRACT  
                        Set.of(
    @Override
        ScalarFunction.ATAN,
                    // "random" sig). RAND(seed): rejected with a clear error — dropping the seed would  
        ScalarFunction.SIGN,  
        ScalarFunction.SCALAR_MAX,
                    Map.entry(ScalarFunction.LESS_THAN_OR_EQUAL, comparisonTemporalCoercion)  
        EngineCapability.SORT,
                ShuffleCompression.Config compression = plugin.getClusterService() != null  
    }
        ScalarFunction.CHAR_LENGTH,
        ScalarFunction.TIME_DIFF,
    @Override
                            WindowFunction.RANK,
        ScalarFunction.TONUMBER,
        ScalarFunction.SUBSTR,
        ScalarFunction.SHA1,  
        ScalarFunction.MICROSECOND,  
        ScalarFunction.LN,  
                    Map.entry(ScalarFunction.REGEXP, nameMapping(SqlLibraryOperators.REGEXP_LIKE)),  
     * Concrete subclass of {@link AbstractNameMappingAdapter} because the abstract
                    Map.entry(ScalarFunction.ADDDATE, new DateAddSubAdapter(true)),
                }
    // references through equality filters into typed literals — e.g. after `where str0 = 'FURNITURE'`,
                        ? Set.of(FieldType.ARRAY)
    public int defaultShuffleParallelism(org.opensearch.cluster.ClusterState state) {
        ScalarFunction.SUBTIME,  
                    }
        // PPL LAST_DAY — date_trunc('month') + 1 month - 1 day. YEARWEEK — os_yearweek Rust UDF.
        return ParquetRangeEvaluator.evaluate(shard, filterBytes, plugin);
                    Map.entry(ScalarFunction.TIME_TO_SEC, new EpochArithmeticAdapters.TimeToSecAdapter()),
            }  
                    sender,
        ScalarFunction.IS_NOT_FALSE,
                    Map.entry(ScalarFunction.REGEXP_REPLACE, new RegexpReplaceAdapter()),
import org.opensearch.analytics.spi.WindowCapability;  
                    Map.entry(ScalarFunction.TIME, new DateTimeAdapters.TimeAdapter()),  
    /**
        FilterDelegationHandle handle,  
        ScalarFunction.TIME_TO_SEC,
    );
     * data nodes in the cluster. The advisor uses this when {@code analytics.mpp.shuffle.partitions}
                    Map.entry(ScalarFunction.COALESCE, new CoalesceAdapter()),
            public Set<WindowCapability> windowCapabilities() {
     */
                    Map.entry(ScalarFunction.EXPM1, new Expm1Adapter()),
                BufferAllocator allocator,
        if (bufAddr != 0 && count > 0) {  
                List<Integer> hashKeyChannels,
        ScalarFunction.TOSTRING,
    // (for `where x + y > 0`-style predicates), and Calcite's SARG fold (IN/BETWEEN/range-union)  
                // coercion (and before Substrait conversion, which has no EQUALS_IP binding).
                }
        // / TIME_FORMAT / STR_TO_DATE translate MySQL format tokens (%i / %s / %p …)
        // Keeping the real implementation on DataFusionPlugin lets operators call it
        ScalarFunction.CONCAT_WS,
        // PPL `DATEDIFF(a, b)` — calendar-day delta, lowered to a day-index subtraction.
                // Map entries are alphabetical (Map.ofEntries past 5 pairs, else spotless inlines).
                    // RAND(): maps to DataFusion's niladic random() (the SqlStdOperatorTable.RAND ->
                    Map.entry(ScalarFunction.DAYOFMONTH, day),  
                // WEEK/WEEK_OF_YEAR follow MySQL mode 0 (Sunday-first), not ISO; date_part('week') is ISO-only  
                for (AggregateFunction func : AGG_FUNCTIONS) {  
                    Map.entry(ScalarFunction.AUTO, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.AUTO)),  
        // routes the calls to this backend; the actual rewrite shape is documented on the
            // that case (no reader handle); the searchWithSessionContext path is the only one
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
     * Project-side scalar functions whose return type is {@code MAP<VARCHAR, VARCHAR>}.  
     * {@code MAP<VARCHAR, VARCHAR>}. First in-tree caller is PPL {@code spath}'s  
        ScalarFunction.JSON_ARRAY_LENGTH,  
        ScalarFunction.TIME_FORMAT,
        SUPPORTED_FIELD_TYPES.addAll(FieldType.numeric());
        ScalarFunction.SUBDATE,  
        AggregateFunction.SUM,
    @Override
                // only needs an opaque tag for log messages so producers from different stages
            // the prior ShuffleScanHandler chain. The searcher's vanilla path is unreachable in  
        ScalarFunction.LATEST,  
        // PPL ADDTIME / SUBTIME / TIMEDIFF — time-of-day arithmetic via to_unixtime + maketime.
                    // COUNT(DISTINCT x) OVER(...) → os_count_distinct(x) OVER(...). Non-distinct  
        // approximation — PPL SYSDATE uses the systemClock (call-time) while NOW
        return plugin.name();  
                    // PPL emits e.g. SIN(integer_field) which Calcite types as SIN(i32?) — isthmus then  
                throw new IllegalStateException("DataFusionService not initialized — createComponents() may not have been called");
                return buildReduceSink(ctx, backendContext);
        AggregateFunction.COUNT,
        String[] columns,
/*  
        ScalarFunction.CURRENT_TIMESTAMP,
            public Set<JoinCapability> joinCapabilities() {
                // Alias pairs share an adapter instance but need separate enum entries because
        ScalarFunction.IS_TRUE,
                // IpComparisonNormalizationAdapter so PPL IP-comparison UDFs (EQUALS_IP etc.) over
        ScalarFunction.CIDRMATCH,
        // Delegate to the plugin that owns the DataFusionService and native runtime.  
        AggregateFunction.APPROX_COUNT_DISTINCT,
     *
        ScalarFunction.JSON_EXTEND,
            }
                    compression
        String mode = plugin.getClusterService() != null
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            DatafusionReader dfReader = null;
                DateTimeAdapters.CurrentDateAdapter currentDate = new DateTimeAdapters.CurrentDateAdapter();
        ScalarFunction.MINSPAN_BUCKET,  
 * this file be licensed under the Apache-2.0 license or a
        ScalarFunction.MINUS,
        // single date_part; MAKETIME / MAKEDATE / FROM_UNIXTIME need DOUBLE inputs
        ScalarFunction.RMCOMMA,  
                    Map.entry(ScalarFunction.GET_FORMAT, new GetFormatAdapter()),  
    }  
                        // AggregateDecompositionResolver falls back to the enum's  
    /**
        ScalarFunction.COALESCE,
    // path). COALESCE is the lowering target of PPL `fillnull`. CAST is required because  
            }
    public Exception convertException(Exception original) {
        ScalarFunction.GREATER_THAN_OR_EQUAL,
        // on a bounded input channel the join isn't yet draining blocks forever — observed on
                    Map.entry(ScalarFunction.RMCOMMA, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.RMCOMMA)),
        ScalarFunction.DAYOFYEAR,
     */  
        ScalarFunction.LOWER,
    }
        ScalarFunction.MONTHNAME,
        ScalarFunction.IS_NULL,
                    Map.entry(ScalarFunction.LOG10, new NumericToDoubleAdapter(SqlStdOperatorTable.LOG10)),
        AggregateFunction.MAX,
                contextId
    private static final Set<FieldType> SUPPORTED_FIELD_TYPES = new HashSet<>();
import org.apache.logging.log4j.Logger;
                    Map.entry(ScalarFunction.MAKETIME, new RustUdfDateTimeAdapters.MaketimeAdapter()),
        ScalarFunction.NUM,  
import org.opensearch.analytics.exec.shuffle.ShuffleCompression;
        ScalarFunction.LAST_DAY,  
                    Set<FieldType> types = op == ScalarFunction.REX_EXTRACT_MULTI
        // supplied (the memtable sink doesn't support the prepared-plan path; that path is
        // FieldType.MAP rather than SUPPORTED_FIELD_TYPES, mirroring the ARRAY-return split).  
    public BackendCapabilityProvider getCapabilityProvider() {
                    Map.entry(ScalarFunction.POWER, new NumericToDoubleAdapter(SqlStdOperatorTable.POWER)),
    @Override  
                    WindowFunctionAdapters.distinctCountApprox(),
                // conversion; DataFusion now() is niladic and fsp is intentionally ignored
                    Map.entry(ScalarFunction.MSTIME, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.MSTIME)),
        ScalarFunction.WIDTH_BUCKET,
        ScalarFunction.STRFTIME,  
        // {@link MvfindAdapter}.
                    Map.entry(ScalarFunction.EXP, new NumericToDoubleAdapter(SqlStdOperatorTable.EXP)),  
            // The AnalyticsShardTask cast is upstream's: the context id and cancellation wiring  
            @Override
        ScalarFunction.EQUALS,
    @Override
                    // Trigonometric functions: substrait `sin/cos/tan/...` declare fp32/fp64 impls only.
        EngineCapability.MULTI_VALUE_EXPAND
        AggregateFunction.LIST,  
        // semantics on top of DF's date_part; see SecondAdapter / DayOfWeekAdapter.
        // ARRAY_LENGTH returns BIGINT → FieldType.LONG; ARRAY_JOIN returns VARCHAR →
                    WindowFunctionAdapters.argMin(),
        DataFusionService dataFusionService = plugin.getDataFusionService();  
        SUPPORTED_FIELD_TYPES.add(FieldType.BOOLEAN);
        ScalarFunction.TIMESTAMP,
    public DataFusionAnalyticsBackendPlugin(DataFusionPlugin plugin) {  
    // ReduceExpressionsRule.ProjectReduceExpressionsRule (in PlannerImpl) constant-folds field
                        caps.add(new FilterCapability.Standard(op, Set.of(type), formats));  
                    Map.entry(ScalarFunction.RANGE_BUCKET, new RangeBucketAdapter()),
                return Map.ofEntries(
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                    Map.entry(ScalarFunction.SINH, new HyperbolicOperatorAdapter(SqlLibraryOperators.SINH)),
        ScalarFunction.NOW,
        ScalarFunction.SUBSTRING,
                    // PPL rex extract-mode multi-match returns array<varchar>; the planner  
                    Map.entry(ScalarFunction.UTC_DATE, currentDate),  
        }
        // PPL GET_FORMAT(type, region) — plan-time fold to a constant format string.
        // PPL bucketing label functions — Rust UDFs returning VARCHAR labels (e.g. "0-100").
                // serializes each hash bucket as Arrow IPC bytes, and the consumer deserializes
                org.apache.calcite.rel.type.RelDataType buildRowType,
        BufferAllocator allocator,
        // timechart's `per_*` aggregations (per_second / per_minute / per_hour / per_day),
        SUPPORTED_FIELD_TYPES.add(FieldType.IP);
import org.opensearch.analytics.spi.AggregateCapability;
            }
        ScalarFunction.LOG10,
                    Map.entry(ScalarFunction.SECOND_OF_MINUTE, second),
                    Map.entry(ScalarFunction.DEGREES, new NumericToDoubleAdapter(SqlStdOperatorTable.DEGREES)),  
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
        ScalarFunction.UTC_DATE,  
                    Map.entry(ScalarFunction.PARSE, new ParseAdapter()),
        ScalarFunction.MVAPPEND
        ScalarFunction.DIVIDE,
                    Map.entry(ScalarFunction.CIDRMATCH, new CidrMatchFunctionAdapter()),
                    // per_* shape TIMESTAMPDIFF(out, t, TIMESTAMPADD(in, n, t)) to a literal.
    private static final Set<AggregateFunction> AGG_FUNCTIONS = Set.of(  
        ScalarFunction.SIN,
        ScalarFunction.MKTIME,
    }
        ScalarFunction.SARG_PREDICATE,
        ScalarFunction.LESS_THAN_OR_EQUAL,  
        ScalarFunction.REPLACE,  
     */
     */  
            //
     * {@code ITEM(map, key)} lookup that always follows a map-returning call).  
    private static final Set<ScalarFunction> STANDARD_PROJECT_OPS = Set.of(
            }  
import org.opensearch.analytics.spi.FilterDelegationHandle;
            }
        SUPPORTED_FIELD_TYPES.add(FieldType.MATCH_ONLY_TEXT);
import org.opensearch.analytics.spi.IntegerReturnWideningCastAdapter;
                    WindowFunctionAdapters.countDistinctExact()  
                for (String formatName : plugin.getSupportedFormats()) {  
        ScalarFunction.MAKEDATE,  
 * creates per-shard execution engines.
                    Map.entry(ScalarFunction.FROM_UNIXTIME, new RustUdfDateTimeAdapters.FromUnixtimeAdapter()),
        SUPPORTED_FIELD_TYPES.add(FieldType.BINARY);  
 * compatible open source license.
public class DataFusionAnalyticsBackendPlugin implements AnalyticsSearchBackendPlugin {  
                DatePartAdapters dayOfYear = DatePartAdapters.dayOfYear();  
    @Override  
        ScalarFunction.COSH,
                    Map.entry(ScalarFunction.DUR2SEC, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.DUR2SEC)),
        ScalarFunction.WEEKDAY,
    private static final Set<ScalarFunction> STANDARD_FILTER_OPS = Set.of(
        ScalarFunction.AUTO,
        // `case(a = 0 and b = 0, …)`, `eval x = a or b`, `eval x = NOT y`. DataFusion's substrait  
                Set<AggregateCapability> caps = new HashSet<>();
                    Map.entry(ScalarFunction.ATAN, new NumericToDoubleAdapter(SqlStdOperatorTable.ATAN)),
            ) {  
 * constructor (supported by {@code PluginsService.createExtension()}), so it has access  
                    Map.entry(ScalarFunction.RADIANS, new NumericToDoubleAdapter(SqlStdOperatorTable.RADIANS)),
                    Map.entry(ScalarFunction.LIKE, new LikeAdapter()),  
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
        SUPPORTED_FIELD_TYPES.addAll(FieldType.keyword());
     * DataFusion participates in MPP hash-shuffle: default the partition count to the number of  
                    // registered against FieldType.ARRAY rather than the scalar set used by
        for (String formatName : plugin.getSupportedFormats()) {
                    Map.entry(ScalarFunction.CURDATE, currentDate),
                    Map.entry(ScalarFunction.TIMESTAMP, new TimestampFunctionAdapter()),
        return new DatafusionResultStream(streamHandle, allocator, importStagingAllocator);
                    Map.entry(ScalarFunction.WEEK, week),  
                Set<FilterCapability> caps = new HashSet<>();  
                    Map.entry(ScalarFunction.WEEKDAY, new WeekdayAdapter()),  
    );  
        // When the FinalAggregateInstructionHandler has already prepared a plan on the  
        int count = rowIdVector.getValueCount();  
        ScalarFunction.CONVERT,
        ScalarFunction.JSON_EXTRACT,  
                    Map.entry(ScalarFunction.CONCAT, new ConcatFunctionAdapter()),  
        // (DatetimeUdtNormalizeRule) rewrites EXPR_TIME / EXPR_DATE → standard
            if (dfReader != null) break;  
            public Set<ProjectCapability> projectCapabilities() {
import org.opensearch.analytics.spi.FieldType;
        ScalarFunction.CRC32,
import org.opensearch.analytics.spi.ExchangeSinkContext;  
    // for eval-style projections.  
    @Override  
        AggregateFunction.MIN,  
        ScalarFunction.GROK,
                    Map.entry(ScalarFunction.SIGN, new IntegerRoundingCastAdapter(SignumFunction.FUNCTION)),  
        // capability lookup at OpenSearchProjectRule resolves the call's return type to a  
                }
        ScalarFunction.PLUS,  
            }
import org.opensearch.analytics.spi.FragmentConvertor;
        ScalarFunction.TIMESTAMPDIFF,
        return () -> FilterTreeCallbacks.requestClose(contextId);
        // and explicit `eval x = case(cond, val, ...)`. Isthmus translates SqlKind.CASE structurally
            // fail fast rather than silently lose cancellation.
                // back to Arrow record batches before feeding them to the worker plan via  
                    // operands in CAST(DOUBLE) before substrait conversion so isthmus can bind. See  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
                if (dfReader == null) {  
        SUPPORTED_FIELD_TYPES.add(FieldType.TEXT);
                    Map.entry(ScalarFunction.STR_TO_DATE, new RustUdfDateTimeAdapters.StrToDateAdapter()),
            // that fires. So upstream's unconditional "dfReader == null" fail-fast is NOT applied
        return ParquetRangeEvaluator.evaluateWithBounds(shard, filterBytes, sortColumn, plugin);
    public Map<Long, QueryExecutionMetrics> getTopQueriesByMemory() {
                return Map.of(
                    : ShuffleCompression.Config.DISABLED;
        // ITEM returns the array's element type (any of the supported scalar types) — used by
        return new DatafusionReduceSink(ctx, svc.getNativeRuntime(), preparedState);
                    Map.entry(ScalarFunction.ITEM, new ArrayElementAdapter()),
    private static final Set<ScalarFunction> ARRAY_RETURNING_PROJECT_OPS = Set.of(
        // PPL extract / make* / format / from_unixtime are implemented as Rust UDFs
                    Map.entry(ScalarFunction.NUM, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.NUM)),
        ScalarFunction.UPPER,  
        ScalarFunction.JSON_ARRAY,
                    // Math functions whose substrait yaml impls are fp64-only — wrap integer/float
                            WindowFunction.MAX,  
            throw new IllegalStateException("DataFusionService not initialized");
        ScalarFunction.JSON_VALID
                    Map.entry(ScalarFunction.POSITION, new PositionAdapter()),
                    ? ShuffleCompression.Config.from(plugin.getClusterService().getClusterSettings())
                // precision arg — now(fsp) / current_timestamp(fsp) — is dropped before Substrait  
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
        ScalarFunction.SCALAR_MIN,  
                    WindowFunctionAdapters.argMax(),  
    /**
                    // fails signature lookup. NumericToDoubleAdapter widens any numeric operand to fp64
import org.opensearch.analytics.spi.ExchangeSink;
        ScalarFunction.REGEXP_CONTAINS,
        ScalarFunction.MONTH_OF_YEAR,
     * CAST and SAFE_CAST effectively can return anything, so they get registered as everything
                    // keys capability lookups on the call's return type, so this op must be
        ScalarFunction.FROM_DAYS,  
                            JoinCapability.JoinKind.LEFT,  
        ScalarFunction.JSON_DELETE,
            }
import org.opensearch.analytics.spi.QueryExecutionMetrics;  
            @Override  
        this.plugin = plugin;
        ScalarFunction.MAKETIME,
        ScalarFunction.DATE_SUB,
        ScalarFunction.IS_NOT_FALSE,
                // NowFspAdapter (not the plain NowAdapter) so the optional fractional-seconds
        EngineCapability.VALUES,
        // json_valid(col)` / `where not json_valid(col)`). DataFusion evaluates the json_valid Rust  
                        Set.copyOf(plugin.getSupportedFormats())
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());  
                    // emits a value-typed scalar before substrait emission.
 * Declares all analytics query capabilities (operators, filters, aggregates) and  
    @Override
                for (ScalarFunction op : ARRAY_RETURNING_PROJECT_OPS) {  
    // CONCAT is the lowering target of PPL `eval`'s `+` for strings (Calcite emits `||`, resolved to  
                            WindowFunction.AVG,  
        ScalarFunction.JSON_APPEND,
    public FragmentConvertor getFragmentConvertor() {
                        // for per-function distributed-execution behavior. Accepts any
                    Map.entry(ScalarFunction.CONCAT_FUNCTION, new ConcatVariadicAdapter()),
    }
                        ),  
        ScalarFunction.CURRENT_TIME,
    // expressions. The remaining comparison / arithmetic / logical operators are project-capable
        ScalarFunction.TRUNCATE,  
                    Map.entry(ScalarFunction.DAY_OF_YEAR, dayOfYear),
        // PPL `ADDDATE(base, N|INTERVAL)` / `SUBDATE(...)` — share the DATE_ADD/DATE_SUB adapter;  
            public Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {
    // the projection `fields str0` is rewritten to `CAST('FURNITURE' AS VARCHAR)`. CAST is also the  
        // single-input final-aggregate so it's never a multi-input deadlock).
        ScalarFunction.GREATER_THAN_OR_EQUAL,
                    Map.entry(ScalarFunction.EARLIEST, new EarliestLatestAdapter.EarliestAdapter()),
import org.apache.arrow.vector.types.pojo.Schema;  
        ScalarFunction.REX_EXTRACT_MULTI,
    public SearchExecEngineProvider getSearchExecEngineProvider() {
 */
                    Map.entry(ScalarFunction.WIDTH_BUCKET, new WidthBucketAdapter()),
        // by a custom Rust UDF on the DataFusion session context (`udf::mvfind`), routed via
        // native streams must still find the binding, so closing here would race them.  
        ScalarFunction.DAY,  
                    Map.entry(ScalarFunction.DAY, day),
     * <p>{@code ARRAY} (PPL {@code array(a, b, …)} constructor) renames to DataFusion's
    private static final Set<EngineCapability> ENGINE_CAPS = Set.of(
    );  
        ScalarFunction.RAND,
                        ),  
        ScalarFunction.CURDATE,
                    Map.entry(ScalarFunction.SCALAR_MIN, nameMapping(SqlLibraryOperators.LEAST)),
        AggregateFunction.LAST,
                // SINGLETON cost gate guarantees fully-gathered partition input.
                    // Registering STANDARD_FILTER_OPS on MAP is sound because every viable
        // default catalog, so adapters rewrite to DF-native interval arithmetic.
                    Map.entry(ScalarFunction.MONTHNAME, new RustUdfDateTimeAdapters.MonthnameAdapter()),
                }
                DatePartAdapters hour = DatePartAdapters.hour();
        // consumer handles them natively.
                        Set.of(
                // rewritten into DataFusion-native shapes by WindowFunctionAdapters before emission.  
        ScalarFunction.EARLIEST,
            }
                    Map.entry(ScalarFunction.DATE_FORMAT, new RustUdfDateTimeAdapters.DateFormatAdapter()),  
                // VARBINARY ip/binary fields are rewritten to native comparators before temporal  
package org.opensearch.be.datafusion;
        ScalarFunction.E,  
import org.opensearch.analytics.spi.WindowFunction;
        AggregateFunction.TAKE,  
                    }  
    }
                            WindowFunction.MIN,
        ScalarFunction.JSON_VALID,
            public ExchangeSink createSink(ExchangeSinkContext ctx, BackendExecutionContext backendContext) {
                    new ComparisonTemporalCoercionAdapter()  
        ScalarFunction.DEGREES,  
            engine.prepare(ctx);
    // by {@link OpenSearchFilterRule} structurally and never looked up here, but registering them
        // CASE — Calcite emits CASE WHEN ... THEN ... END for conditional expressions, including
                );
        ScalarFunction.CEIL,  
        ScalarFunction.DAY_OF_WEEK,  
import org.opensearch.analytics.spi.ScalarFunction;
                    Map.entry(ScalarFunction.YEARWEEK, new RustUdfDateTimeAdapters.OsYearweekAdapter()),
        AggregateFunction.SUM0,
        DataFormatRegistry registry = plugin.getDataFormatRegistry();  
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context);  
        // SPAN_BUCKET reachable today via `bin <f> span=N`. WIDTH_BUCKET / MINSPAN_BUCKET /
        ScalarFunction.NOT_EQUALS,  
        ScalarFunction.UNIX_TIMESTAMP,
        // adapter class.
        ScalarFunction.SHA2,
import org.apache.calcite.sql.SqlOperator;
            throw new IllegalStateException("BigIntVector buffer address is 0 or count is 0");
        ScalarFunction.STR_TO_DATE,  
        }
                    Map.entry(ScalarFunction.SUBDATE, new DateAddSubAdapter(false)),
                    // DATETIME_PLUS + INTERVAL / to_unixtime arithmetic. Peephole folds the timechart
                    for (FieldType ft : FieldType.values()) {
                    Map.entry(ScalarFunction.JSON_EXTRACT, new JsonFunctionAdapters.JsonExtractAdapter()),
        return plugin.getTopQueriesByMemory();  
        // MINUTE_OF_DAY decomposes to date_part('hour',x)*60 + date_part('minute',x).
                // StreamingTableExec + PartitionStream (the ShuffleScanHandler's job).
        // Fire the per-context cancellation token so the fetch stream's cross_rt task breaks  
                    // so without this branch the WHERE rejects with  
        // BigIntVector data buffer is a contiguous off-heap array of i64 values.
        ScalarFunction.ASIN,  
                        // AggregateFunction.Type (SIMPLE, APPROXIMATE, ...), unlike the  
                            JoinCapability.JoinKind.ANTI,
        }  
    public CanMatchResult canMatchWithBounds(IndexShard shard, byte[] filterBytes, String sortColumn) {  
        ScalarFunction.JSON_KEYS,
        // from a TIMESTAMP / DATE / TIME / string value. Route to DataFusion's
        ScalarFunction.TRIM,
        ScalarFunction.DATETIME,
     * type, and for these the lookup resolves to {@link FieldType#MAP} — intentionally not  
import java.util.HashSet;  
        // render full weekday / month names via the same mysql_format tokens the
        ScalarFunction.WEEK,
 * SPDX-License-Identifier: Apache-2.0
        ScalarFunction.REX_OFFSET,
        ScalarFunction.LOCATE,  
        StreamHandle streamHandle = new StreamHandle(streamPtr, dataFusionService.getNativeRuntime());  
        // is registered separately via {@link #MAP_RETURNING_PROJECT_OPS} (keyed on
        ScalarFunction.STRCMP,
        ScalarFunction.DAYNAME,  
                    // predicate against a MAP column is forced through an ITEM lookup that  
                    )
     * Pure rename from a PPL scalar to {@code target} — no prepend / append operands.
                    Map.entry(ScalarFunction.TONUMBER, new ToNumberFunctionAdapter()),
            }  
 * to the {@link DataFusionService} created during plugin lifecycle.
    }  
        // that DataFusion's `to_char` does not recognize.
 * <p>
import org.opensearch.analytics.backend.EngineResultStream;  
            @Override
    private static AbstractNameMappingAdapter nameMapping(SqlOperator target) {
        ScalarFunction.IS_NULL,
                return Set.copyOf(caps);
                    Map.entry(ScalarFunction.RMUNIT, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.RMUNIT)),  
        ScalarFunction.EXPM1,
                return Set.of(
        AggregateFunction.FIRST,
        }
            public Set<ScanCapability> scanCapabilities() {
            @Override
                    )
                    // TIMESTAMP UDF wrapper to a string inside a subquery (see adapter javadoc).  
        ScalarFunction.ADDDATE,
                        Set.copyOf(plugin.getSupportedFormats())
        ScalarFunction.CONCAT,
        ScalarFunction.TO_DAYS,
                // Resolve the shuffle-IPC compression policy live from the cluster settings (default OFF).
                    Map.entry(ScalarFunction.COS, new NumericToDoubleAdapter(SqlStdOperatorTable.COS)),
                    Map.entry(ScalarFunction.PATTERN_PARSER, new PatternParserAdapter()),
        AggregateFunction.PERCENTILE_APPROX,
        // state instead of re-decoding the fragment bytes.  
import org.opensearch.analytics.spi.ShuffleSender;
        // substrait consumer handles IfThen natively. Without this entry, the analytics planner  
            dfReader = reader.getReader(registry.format(formatName), DatafusionReader.class);
        ScalarFunction.EQUALS,
     * in {@link #SUPPORTED_FIELD_TYPES} (filter / aggregate / sort operators have no
    @Override
        ScalarFunction.SAFE_CAST,  
        // single-statement OLAP query so routing both to DF `now` is acceptable.  
                    // before substrait conversion (no-op when the operand is already fp32/fp64).
        ScalarFunction.IS_NOT_NULL,
    }
        ScalarFunction.RTRIM,  
    }  
        // before substrait emission.
                    Map.entry(ScalarFunction.TIMESTAMPDIFF, new TimestampDiffAdapter()),  
                DayOfWeekAdapter dayOfWeek = new DayOfWeekAdapter();  
                DataFormatRegistry registry = plugin.getDataFormatRegistry();
        ScalarFunction.ATAN2,
            public Set<FilterCapability> filterCapabilities() {
                    for (FieldType type : SUPPORTED_FIELD_TYPES) {
                ShuffleSender sender,
        // (FLOOR cast for SECOND, +1 offset for DAYOFWEEK) to preserve PPL's MySQL  
        ScalarFunction.DIVIDE,  
        return new ExchangeSinkProvider() {
                return Set.copyOf(caps);
        ScalarFunction.LIKE,
        return new BackendCapabilityProvider() {  
                        break;  
        // PPL `mvfind` returns INTEGER (the 0-based index of the first match, or NULL); backed  
        ScalarFunction.LESS_THAN_OR_EQUAL,
                );  
                return new BroadcastCaptureSink(allocator, fallback, maxBytes);  
        return new DataFusionInstructionHandlerFactory(plugin);
            DatafusionContext context = new DatafusionContext(  
        BigIntVector rowIdVector,  
        long contextId,
                            JoinCapability.JoinKind.SEMI,  
import org.opensearch.be.datafusion.planner.adapter.NumericConversionFunctionAdapter;  
        ScalarFunction.HOUR_OF_DAY,
            streamPtr = NativeBridge.fetchByRowIds(
        // UTC_* are pure aliases onto DF `now` / `current_date` / `current_time`
                    Map.entry(ScalarFunction.ARRAY_SLICE, new ArraySliceAdapter()),  
    }
            @Override  
        // PPL PERIOD_ADD / PERIOD_DIFF — pure integer YYYYMM arithmetic.
                }
                        // per-type factory methods which assert on Type.
                    Map.entry(ScalarFunction.DATE_ADD, new DateAddSubAdapter(true)),
        }
                    Map.entry(ScalarFunction.MICROSECOND, new MicrosecondAdapter()),
                    targetWorkerNodeIds,
        ScalarFunction.DATE_ADD,
            // and read only from named-input streams registered on the SessionContextHandle by
import java.util.Map;
import org.apache.arrow.memory.BufferAllocator;
                    logTag,  
                    Map.entry(ScalarFunction.HOUR_OF_DAY, hour),  
        ScalarFunction.POSITION,
        ScalarFunction.REGEXP,  
        ScalarFunction.PI,
        ScalarFunction.TO_SECONDS,
import org.opensearch.analytics.spi.EngineCapability;
                    Map.entry(ScalarFunction.FLOOR, new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR)),  
                    new JoinCapability(  
                (AnalyticsShardTask) ctx.getTask(),
                            WindowFunction.PATTERN
        ScalarFunction.LESS_THAN,  
                for (ScalarFunction op : MAP_RETURNING_PROJECT_OPS) {  
    public String name() {
                dataFusionService.getNativeRuntime()  
                    Map.entry(ScalarFunction.ACOS, new NumericToDoubleAdapter(SqlStdOperatorTable.ACOS)),  
        ScalarFunction.SEC_TO_TIME,
import org.opensearch.analytics.spi.SearchExecEngineProvider;
import org.opensearch.be.datafusion.nativelib.StreamHandle;
        // PPL `time(expr)` / `date(expr)` — extract time-of-day / date component
        ScalarFunction.MOD,  
                    Map.entry(ScalarFunction.DAYOFYEAR, dayOfYear),
            return new DatafusionMemtableReduceSink(ctx, svc.getNativeRuntime());
        ScalarFunction.ITEM,
            if (ctx.getReader() != null) {
    /**
        // SECOND / SECOND_OF_MINUTE / DAYOFWEEK / DAY_OF_WEEK use dedicated adapters
                    for (FieldType type : SUPPORTED_FIELD_TYPES) {
                    Map.entry(ScalarFunction.SARG_PREDICATE, new SargAdapter()),  
            DataFusionService dataFusionService = plugin.getDataFusionService();  
        ScalarFunction.PERIOD_ADD,  
                    Map.entry(ScalarFunction.GROK, new GrokAdapter()),  
    }
        ScalarFunction.MVFIND,  
                    throw new IllegalStateException("No DatafusionReader available in the acquired reader");
        ScalarFunction.DAYOFWEEK,
                    Map.entry(ScalarFunction.CTIME, new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.CTIME)),  
        AggregateFunction.PATTERN,
        // the analytics-engine path because sql-repo PR #5408
            }
    public boolean canMatch(IndexShard shard, byte[] filterBytes) {
            // both hang off AnalyticsShardTask#getNativeTaskId(), so a non-analytics task must
                    partitionCount,  
                    Map.entry(ScalarFunction.TOSTRING, new ToStringFunctionAdapter()),  
            throw new IllegalStateException("DataFusionService not initialized");
        return Math.max(dataNodeCount, 1);
/**
                long maxBytes  
                            WindowFunction.ARG_MAX,
                    // collection sees the underlying MAP column, not the ITEM-extracted scalar,
            public Set<DelegationType> supportedDelegations() {
        ScalarFunction.SYSDATE,
        ScalarFunction.PERIOD_DIFF,
        ScalarFunction.SECOND,
                    dfReader = ctx.getReader().getReader(registry.format(formatName), DatafusionReader.class);
        BufferAllocator importStagingAllocator
        ScalarFunction.DAYOFMONTH,
                    Map.entry(ScalarFunction.COSH, new HyperbolicOperatorAdapter(SqlLibraryOperators.COSH)),
                columns,
        // both natively and isthmus's default catalog binds them, so no adapter needed.  
        ScalarFunction.BINARY,
        ScalarFunction.IS_TRUE,
        ScalarFunction.ASCII,
                // (matches the SQL-plugin reference). Covers NOW, CURRENT_TIMESTAMP, SYSDATE.
                    Map.entry(ScalarFunction.STRCMP, new StrcmpFunctionAdapter()),
                            WindowFunction.DISTINCT_COUNT_APPROX,  
     * so that concurrent queries each have their own isolated FFM callback binding.  
        ScalarFunction.REVERSE,
        ScalarFunction.MINUTE_OF_DAY,  
                    Map.entry(ScalarFunction.DAY_OF_WEEK, dayOfWeek),  
        }
     * {@link JsonFunctionAdapters.JsonExtractAllAdapter}.
        long contextId,  
                    Map.entry(ScalarFunction.EQUALS, comparisonTemporalCoercion),
                ExchangeSinkContext context
                        caps.add(new AggregateCapability(func, Set.of(type), formats));
        ScalarFunction.MINUTE,
                    Map.entry(ScalarFunction.TRUNCATE, new IntegerRoundingCastAdapter(SqlStdOperatorTable.TRUNCATE)),
            // ctx.getReader() != null block above, and DatafusionContext tolerates a null reader.
                    Map.entry(ScalarFunction.UTC_TIME, currentTime),
                    Map.entry(ScalarFunction.JSON_SET, new JsonFunctionAdapters.JsonSetAdapter()),
                );
 * SPI extension discovered by analytics-engine via {@code META-INF/services}.  
            @Override  
                    // silently turn deterministic seeded output into non-deterministic random().
                    Map.entry(ScalarFunction.CURRENT_DATE, currentDate),
        ScalarFunction.MD5,
        ScalarFunction.COS,
                );  
                        // 3-arg constructor leaves decomposition=null so the
        ScalarFunction.JSON_SET,  
        return new AbstractNameMappingAdapter(target, List.of(), List.of()) {  
        ScalarFunction.JSON_EXTRACT_ALL,
        // span lowers to {@code floor(field/interval)*interval}; time span (interval=1) to
    static {  
            public Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {  
                    Map.entry(ScalarFunction.TO_SECONDS, new EpochArithmeticAdapters.ToSecondsAdapter()),
        AggregateFunction.VALUES,
                    Map.entry(ScalarFunction.E, new EConstantAdapter()),  
                dfReader,
        ScalarFunction.LENGTH,
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
        ScalarFunction.DATEDIFF,
            @Override  
        ScalarFunction.CONVERT_TZ,
                            WindowFunction.DENSE_RANK,  
        ScalarFunction.EARLIEST,
     * <p>{@code JSON_EXTRACT_ALL} flattens a JSON object to dot-path keys, returning a
        // uses queryStartClock; the wall-clock difference is sub-millisecond on a
                        // intermediateFields + finalExpression — the single source of truth
                }
     * resolves to {@link FieldType#ARRAY} — which is intentionally not in
                    // NumericToDoubleAdapter javadoc for the type-widening rules. Without these the
                    Map.entry(ScalarFunction.LATEST, new EarliestLatestAdapter.LatestAdapter()),
        return (ctx, backendContext) -> {
        long streamPtr;
        };
                    Map.entry(ScalarFunction.TIMESTAMPADD, new TimestampAddAdapter()),
        ScalarFunction.LOG,
        // PPL `count(eval(predicate))` (lowered to COUNT(CASE WHEN predicate THEN ... ELSE NULL END))  
        ScalarFunction.IN,
        }  
                    Map.entry(ScalarFunction.TAN, new NumericToDoubleAdapter(SqlStdOperatorTable.TAN)),
                // Format string is backend-specific. "arrow-ipc-partitioned" means the producer
                    Map.entry(ScalarFunction.SPAN_BUCKET, new SpanBucketAdapter()),
                );
                Schema fallback = buildRowType == null ? null : CalciteToArrowSchema.convert(buildRowType);
                }  
        // by the bucket IT suites once the window-pushdown follow-up (#21668) lands. See
        } else {  
                    }
            return engine;
                    // COUNT(x) passes through unchanged.
        };  
        ScalarFunction.MINUTE_OF_HOUR,  
            );
        ScalarFunction.YEARWEEK
     * Context-aware override: registers the handle and tracker under {@code contextId}
        if (dfReader == null) {
                    Map.entry(ScalarFunction.JSON_VALID, new JsonFunctionAdapters.JsonValidAdapter()),  
        ScalarFunction.ARRAY_DISTINCT,
                bufAddr,  
                            WindowFunction.ROW_NUMBER,
        // streaming sink registers each input as a bounded-mpsc StreamingTable and drains the plan
        ScalarFunction.UTC_TIMESTAMP,
