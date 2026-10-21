        ScalarFunction.WEEK_OF_YEAR,
    }
            public Set<DelegationType> supportedDelegations() {
    // references through equality filters into typed literals — e.g. after `where str0 = 'FURNITURE'`,
                    Map.entry(ScalarFunction.EARLIEST, new EarliestLatestAdapter.EarliestAdapter()),
                dfReader,
            @Override
        if (bufAddr != 0 && count > 0) {
                columns,
        return new BackendCapabilityProvider() {
        ScalarFunction.ASIN,
                    // MAP-typed fields enter the filter rule when the predicate is
        ScalarFunction.IS_TRUE,
                    Map.entry(ScalarFunction.JSON_VALID, new JsonFunctionAdapters.JsonValidAdapter()),
                    // operand — recovers the coercion lost when RelDecorrelator folds the PPL
                return Map.of(
     */
                    Map.entry(ScalarFunction.POSITION, new PositionAdapter()),
                (AnalyticsShardTask) ctx.getTask(),
import org.apache.logging.log4j.LogManager;
                    Map.entry(ScalarFunction.ATAN, new NumericToDoubleAdapter(SqlStdOperatorTable.ATAN)),
            // fail fast rather than silently lose cancellation.
        // Logical connectives — emitted in projections where boolean expressions are composed:
        // concurrently with feeds; for a multi-input operator that can deadlock (a HashJoinExec
import org.opensearch.analytics.backend.EngineResultStream;
            }
        ScalarFunction.NOT,
        }
    );
        ScalarFunction.NOW,
    public FragmentConvertor getFragmentConvertor() {
                for (String formatName : plugin.getSupportedFormats()) {
        ScalarFunction.POWER,
        ScalarFunction.FROM_DAYS,
        ScalarFunction.ACOS,
                    // Math functions whose substrait yaml impls are fp64-only — wrap integer/float
            if (dfReader != null) break;
     * Returns a cleanup action that removes the binding when execution finishes.
                ScalarFunctionAdapter comparisonTemporalCoercion = new IpComparisonNormalizationAdapter(
                DatePartAdapters minute = DatePartAdapters.minute();
            @Override
import java.util.Set;
            }
        }
            public Set<JoinCapability> joinCapabilities() {
                DatePartAdapters hour = DatePartAdapters.hour();
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
                    targetWorkerNodeIds,
        ScalarFunction.LENGTH,
                        : Set.copyOf(SUPPORTED_FIELD_TYPES);
    // expressions. The remaining comparison / arithmetic / logical operators are project-capable
                    Map.entry(ScalarFunction.ATAN2, new NumericToDoubleAdapter(SqlStdOperatorTable.ATAN2)),
        ScalarFunction.TRIM,
        ScalarFunction.MOD,
        ScalarFunction.DATE_ADD,
                    Map.entry(ScalarFunction.JSON_OBJECT, new JsonFunctionAdapters.JsonObjectAdapter()),
                DatePartAdapters month = DatePartAdapters.month();
        ScalarFunction.SCALAR_MAX,
                        Set.copyOf(plugin.getSupportedFormats())
                ShuffleSender sender,
                // PPL-form aggregates (ARG_MIN/MAX, DISTINCT_COUNT_APPROX) are advertised here and
                    Map.entry(ScalarFunction.NUMBER_TO_STRING, new ToStringFunctionAdapter()),
import org.opensearch.analytics.spi.IntegerReturnWideningCastAdapter;
        long bufAddr = rowIdVector.getDataBuffer().memoryAddress();
        ScalarFunction.LIKE,
        ScalarFunction.LESS_THAN_OR_EQUAL,
        ScalarFunction.MKTIME,
        Reader reader,
    }
    // Project-side scalar functions DataFusion can evaluate natively. Each entry corresponds to a
                    Map.entry(ScalarFunction.RADIANS, new NumericToDoubleAdapter(SqlStdOperatorTable.RADIANS)),
        // single date_part; MAKETIME / MAKEDATE / FROM_UNIXTIME need DOUBLE inputs
 * creates per-shard execution engines.
        AggregateFunction.ARG_MAX
import java.util.Map;
                    // PPL rex extract-mode multi-match returns array<varchar>; the planner
                for (ScalarFunction op : STANDARD_FILTER_OPS) {
                // rewritten into DataFusion-native shapes by WindowFunctionAdapters before emission.
        // PPL `datetime(expr)` — parse/cast into a TIMESTAMP. Routes to DF's
        // PPL GET_FORMAT(type, region) — plan-time fold to a constant format string.
                        // intermediateFields + finalExpression — the single source of truth
                );
        ScalarFunction.ATAN2,
        ScalarFunction.REGEXP_CONTAINS,
        ScalarFunction.ARRAY_SLICE,
        // (DatetimeUdtNormalizeRule) rewrites EXPR_TIME / EXPR_DATE → standard
    }
     * Project-side scalar functions whose return type is {@code ARRAY}. Registered separately
        ScalarFunction.OR,
        ScalarFunction.MONTH,
        ScalarFunction.TIME_TO_SEC,
        // which expand to {@code DIVIDE(agg * scale, TIMESTAMPDIFF('MILLISECOND', @timestamp,
        ScalarFunction.RADIANS,
        ScalarFunction.CEIL,
        ScalarFunction.REGEXP_REPLACE,
        ScalarFunction.DAYOFMONTH,
                    Map.entry(ScalarFunction.SEC_TO_TIME, new SecToTimeAdapter()),
                    Map.entry(ScalarFunction.JSON_EXTRACT, new JsonFunctionAdapters.JsonExtractAdapter()),
                    Map.entry(ScalarFunction.STR_TO_DATE, new RustUdfDateTimeAdapters.StrToDateAdapter()),
                    throw new IllegalStateException("No DatafusionReader available in the acquired reader");
                    Map.entry(ScalarFunction.DAY, day),
        // Niladic now/current_* family maps 1:1 to DF builtins. SYSDATE is an
     * in {@link #SUPPORTED_FIELD_TYPES} (filter / aggregate / sort operators have no
        AggregateFunction.FIRST,
        SUPPORTED_FIELD_TYPES.add(FieldType.IP);
                    for (FieldType type : SUPPORTED_FIELD_TYPES) {
            streamPtr = NativeBridge.fetchByRowIds(
 * this file be licensed under the Apache-2.0 license or a
                    Map.entry(ScalarFunction.LESS_THAN_OR_EQUAL, comparisonTemporalCoercion)
        // cooperatively. No-op for an unknown contextId.
        ScalarFunction.PLUS,
                    Map.entry(ScalarFunction.SECOND, second),
                // serializes each hash bucket as Arrow IPC bytes, and the consumer deserializes
    public DataFusionAnalyticsBackendPlugin(DataFusionPlugin plugin) {
        DataFusionService dataFusionService = plugin.getDataFusionService();
                            WindowFunction.ARG_MIN,
                    Map.entry(ScalarFunction.DATE_ADD, new DateAddSubAdapter(true)),
                    Map.entry(ScalarFunction.WEEKDAY, new WeekdayAdapter()),
                    Map.entry(ScalarFunction.E, new EConstantAdapter()),
                    Map.entry(ScalarFunction.REX_EXTRACT_MULTI, new RexExtractMultiAdapter()),
        return (ctx, backendContext) -> {
            @Override
            }
/**
        ScalarFunction.DEGREES,
import org.opensearch.analytics.spi.ScalarFunction;
        };
import java.util.HashSet;
        // semantics on top of DF's date_part; see SecondAdapter / DayOfWeekAdapter.
        AggregateFunction.COUNT,
                        // for per-function distributed-execution behavior. Accepts any
    }
        ScalarFunction.WEEKDAY,
        ScalarFunction.COS,
                    Map.entry(ScalarFunction.RAND, new RandSeedAdapter()),
                return ENGINE_CAPS;
        ScalarFunction.GROK,
                // (matches the SQL-plugin reference). Covers NOW, CURRENT_TIMESTAMP, SYSDATE.
        // to a Substrait IfThen rel — no extension lookup needed, no adapter required. DataFusion's
                        // 3-arg constructor leaves decomposition=null so the
                    Map.entry(ScalarFunction.DATETIME, new DateTimeAdapters.DatetimeAdapter()),
                    Map.entry(ScalarFunction.PERIOD_DIFF, new PeriodArithmeticAdapters.PeriodDiffAdapter()),
    private static final Set<AggregateFunction> AGG_FUNCTIONS = Set.of(
     * over array-typed values, so we don't want them claiming viability there).
                    Map.entry(ScalarFunction.CURRENT_DATE, currentDate),
/*
        ScalarFunction.MONTH_OF_YEAR,
                    Map.entry(ScalarFunction.MEMK, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.MEMK)),
                    Map.entry(ScalarFunction.NOT_EQUALS, comparisonTemporalCoercion),
        ScalarFunction.JSON_KEYS,
        ScalarFunction.TAN,
    public EngineResultStream fetchByRowIds(
    private ExchangeSink buildReduceSink(ExchangeSinkContext ctx, BackendExecutionContext backendContext) {
                    Map.entry(ScalarFunction.PATTERN_PARSER, new PatternParserAdapter()),
        AggregateFunction.LAST,
                throw new IllegalStateException("DataFusionService not initialized — createComponents() may not have been called");
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
        ScalarFunction.IS_NOT_NULL,
                        Set.of(
import org.opensearch.be.datafusion.nativelib.NativeBridge;
    public Map<Long, QueryExecutionMetrics> getTopQueriesByMemory() {
                    Map.entry(ScalarFunction.SINH, new HyperbolicOperatorAdapter(SqlLibraryOperators.SINH)),
                    Map.entry(ScalarFunction.SCALAR_MAX, nameMapping(SqlLibraryOperators.GREATEST)),
        ScalarFunction.TIMESTAMPADD,
                );
        ScalarFunction.IS_NULL,
        // requestClose owns handle.close(): late release upcalls from partially-consumed
                // Stateless cast adapter shared between CAST and SAFE_CAST registrations.
public class DataFusionAnalyticsBackendPlugin implements AnalyticsSearchBackendPlugin {
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
                    Map.entry(ScalarFunction.PERIOD_ADD, new PeriodArithmeticAdapters.PeriodAddAdapter()),
        // both natively and isthmus's default catalog binds them, so no adapter needed.
            }
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
    @Override
            throw new IllegalStateException("DataFusionService not initialized");
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                    WindowFunctionAdapters.countDistinctExact()
        // Calcite TIME / DATE on the RexCall return type, so downstream consumers
        // state instead of re-decoding the fragment bytes.
                RustUdfDateTimeAdapters.OsWeekAdapter week = new RustUdfDateTimeAdapters.OsWeekAdapter();
    private static AbstractNameMappingAdapter nameMapping(SqlOperator target) {
        ScalarFunction.GREATER_THAN,
                    Map.entry(ScalarFunction.DAY_OF_YEAR, dayOfYear),
                    Map.entry(ScalarFunction.COSH, new HyperbolicOperatorAdapter(SqlLibraryOperators.COSH)),
            public Set<FilterCapability> filterCapabilities() {
                    Map.entry(ScalarFunction.DAYOFYEAR, dayOfYear),
                    Map.entry(ScalarFunction.CIDRMATCH, new CidrMatchFunctionAdapter()),
            );
    @Override
    private static final Set<ScalarFunction> STANDARD_PROJECT_OPS = Set.of(
        ScalarFunction.TONUMBER,
                    WindowFunctionAdapters.distinctCountApprox(),
                return buildReduceSink(ctx, backendContext);
        ScalarFunction.SECOND,
                DataFusionSessionState sessionState = (DataFusionSessionState) backendContext;
            // here — the shard-scan case is already covered by the throw inside the
        ScalarFunction.MINUS,
                return Set.copyOf(caps);
import org.opensearch.analytics.spi.DelegationThreadTracker;
                    Map.entry(ScalarFunction.GET_FORMAT, new GetFormatAdapter()),
            public ExchangeSink createSink(ExchangeSinkContext ctx, BackendExecutionContext backendContext) {
            public Set<ScanCapability> scanCapabilities() {
                    Map.entry(ScalarFunction.LN, new NumericToDoubleAdapter(SqlStdOperatorTable.LN)),
        StreamHandle streamHandle = new StreamHandle(streamPtr, dataFusionService.getNativeRuntime());
        ScalarFunction.FLOOR,
            @Override
            engine.prepare(ctx);
            DatafusionReader dfReader = null;
    public Exception convertException(Exception original) {
                    caps.add(new ProjectCapability.Scalar(op, Set.of(FieldType.MAP), formats, true));
        }
        ScalarFunction.ADDTIME,
                    partitionCount,
        ScalarFunction.MINSPAN_BUCKET,
                    Map.entry(ScalarFunction.MONTHNAME, new RustUdfDateTimeAdapters.MonthnameAdapter()),
        // ITEM returns the array's element type (any of the supported scalar types) — used by
     * over-subscribing — additional partitions on the same node would queue on the same
                    Map.entry(ScalarFunction.TIMESTAMP, new TimestampFunctionAdapter()),
                    Map.entry(ScalarFunction.CONCAT_FUNCTION, new ConcatVariadicAdapter()),
                    // collection sees the underlying MAP column, not the ITEM-extracted scalar,
        ScalarFunction.PATTERN_PARSER
                    Map.entry(ScalarFunction.ITEM, new ArrayElementAdapter()),
                    Map.entry(ScalarFunction.REX_OFFSET, new RexOffsetAdapter()),
                ExchangeSinkContext context
                    // registered against FieldType.ARRAY rather than the scalar set used by
        // uses queryStartClock; the wall-clock difference is sub-millisecond on a
    // (for `where x + y > 0`-style predicates), and Calcite's SARG fold (IN/BETWEEN/range-union)
                            WindowFunction.ARG_MAX,
        ScalarFunction.FROM_UNIXTIME,
                // ScalarFunction.fromSqlFunction resolves by enum name.
    @Override
        } else {
        // and PPL-specific NULL-on-negative / year-wraparound behavior; DATE_FORMAT
        ScalarFunction.DATETIME,
                    Map.entry(ScalarFunction.COALESCE, new CoalesceAdapter()),
    @Override
                    Map.entry(ScalarFunction.TIME_FORMAT, new RustUdfDateTimeAdapters.TimeFormatAdapter()),
                    Map.entry(ScalarFunction.ACOS, new NumericToDoubleAdapter(SqlStdOperatorTable.ACOS)),
        ScalarFunction.HOUR,
            throw new IllegalStateException("BigIntVector buffer address is 0 or count is 0");
        AggregateFunction.ARG_MIN,
        ScalarFunction.DATE_FORMAT,
                for (ScalarFunction op : MAP_RETURNING_PROJECT_OPS) {
        for (String formatName : plugin.getSupportedFormats()) {
                        caps.add(new ProjectCapability.Scalar(op, Set.of(ft), formats, true));
        ScalarFunction.SINH,
        ScalarFunction.LATEST,
            if (backendContext != null) {
        ScalarFunction.CONCAT,
                // Map entries are alphabetical (Map.ofEntries past 5 pairs, else spotless inlines).
    @Override
                            WindowFunction.DENSE_RANK,
        // builtins `to_time` / `to_date` via TimeAdapter / DateAdapter. Safe on
                Set<ProjectCapability> caps = new HashSet<>();
                        break;
                    Map.entry(ScalarFunction.ROUND, new IntegerRoundingCastAdapter(SqlStdOperatorTable.ROUND)),
    @Override
     * Concrete subclass of {@link AbstractNameMappingAdapter} because the abstract
            ) {
                    Map.entry(ScalarFunction.CAST, ipBinaryCast),
        long contextId,
                return new BroadcastCaptureSink(allocator, fallback, maxBytes);
        ScalarFunction.DAY,
                    Map.entry(ScalarFunction.GREATER_THAN, comparisonTemporalCoercion),
    }
        ScalarFunction.ASCII,
        ScalarFunction.CASE,
        ScalarFunction.ABS,
            // that case (no reader handle); the searchWithSessionContext path is the only one
                    // PPL emits e.g. SIN(integer_field) which Calcite types as SIN(i32?) — isthmus then
        // span lowers to {@code floor(field/interval)*interval}; time span (interval=1) to
            }
        ScalarFunction.MONTHNAME,
        ScalarFunction.TIMES,
                    Map.entry(ScalarFunction.MVAPPEND, new MvappendAdapter()),
        ScalarFunction.MAKEDATE,
                    Map.entry(ScalarFunction.JSON_EXTEND, new JsonFunctionAdapters.JsonExtendAdapter()),
        BackendExecutionContext backendContext
    ) {
 * SPDX-License-Identifier: Apache-2.0
        // supports 10 composite units (DAY_SECOND → ddHHmmss etc.) that are not a
            }
                    Map.entry(ScalarFunction.DAYOFWEEK, dayOfWeek),
    private static final Set<ScalarFunction> STANDARD_FILTER_OPS = Set.of(
        ScalarFunction.IS_NOT_TRUE,
        // Multi-input coordinator operators (Join, Union) use the buffered memtable sink. The
        int inputCount = ctx.childInputs().size();
        // registered senders. The sink drives executeLocalPreparedPlan against that
import org.apache.arrow.vector.BigIntVector;
        ScalarFunction.TO_DAYS,
        ScalarFunction.SCALAR_MIN,
            @Override
        // by the bucket IT suites once the window-pushdown follow-up (#21668) lands. See
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        // Keeping the real implementation on DataFusionPlugin lets operators call it
        ScalarFunction.REGEXP_CONTAINS,
        ScalarFunction.LN,
                    Map.entry(ScalarFunction.DAYNAME, new RustUdfDateTimeAdapters.DaynameAdapter()),
                    // "random" sig). RAND(seed): rejected with a clear error — dropping the seed would
        ScalarFunction.ITEM,
        ScalarFunction.NOT_EQUALS,
            return new DatafusionMemtableReduceSink(ctx, svc.getNativeRuntime());
    public CanMatchResult canMatchWithBounds(IndexShard shard, byte[] filterBytes, String sortColumn) {
                    Map.entry(ScalarFunction.SUBTIME, new AddSubTimeAdapter(false)),
                    Map.entry(ScalarFunction.WIDTH_BUCKET, new WidthBucketAdapter()),
                    Map.entry(ScalarFunction.JSON_SET, new JsonFunctionAdapters.JsonSetAdapter()),
                List<String> targetWorkerNodeIds,
                    Map.entry(ScalarFunction.CURTIME, currentTime),
                    }
        ScalarFunction.SAFE_CAST,
        return new ExchangeSinkProvider() {
                        // per-type factory methods which assert on Type.
                );
    private static final Set<EngineCapability> ENGINE_CAPS = Set.of(
                    Map.entry(ScalarFunction.PARSE, new ParseAdapter()),
        ScalarFunction.ROUND,
        ScalarFunction.JSON_OBJECT,
                int partitionCount,
                    Map.entry(ScalarFunction.HOUR, hour),
        // streaming sink registers each input as a bounded-mpsc StreamingTable and drains the plan
            @Override
import org.opensearch.analytics.spi.QueryExecutionMetrics;
                            JoinCapability.JoinKind.LEFT,
                    Map.entry(ScalarFunction.UTC_TIMESTAMP, now),
                    WindowFunctionAdapters.argMin(),
        ScalarFunction.CURRENT_TIMESTAMP,
        // BigIntVector data buffer is a contiguous off-heap array of i64 values.
                    Map.entry(ScalarFunction.RMUNIT, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.RMUNIT)),
        ScalarFunction.COSH,
                    Map.entry(ScalarFunction.JSON_APPEND, new JsonFunctionAdapters.JsonAppendAdapter()),
        ScalarFunction.LATEST,
        // PPL `mvfind` returns INTEGER (the 0-based index of the first match, or NULL); backed
        }
                    Map.entry(ScalarFunction.MSTIME, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.MSTIME)),
                    // so without this branch the WHERE rejects with
                        // AggregateFunction.Type (SIMPLE, APPROXIMATE, ...), unlike the
        EngineCapability.SORT,
    }
        ScalarFunction.JSON,
        // PPL `count(eval(predicate))` (lowered to COUNT(CASE WHEN predicate THEN ... ELSE NULL END))
    // from the eval column's inferred type (e.g. JSON_ARRAY_LENGTH returns INTEGER_FORCE_NULLABLE).
                    Map.entry(ScalarFunction.NUM, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.NUM)),
                    Map.entry(ScalarFunction.MAKETIME, new RustUdfDateTimeAdapters.MaketimeAdapter()),
        // PPL `TIMESTAMPDIFF(unit, t1, t2)` / `TIMESTAMPADD(unit, n, t)` — lowering target for
            throw new IllegalStateException("No DatafusionReader available for fetch-by-row-ids");
                return Set.copyOf(caps);
        };
                    Map.entry(ScalarFunction.SYSDATE, now),
                    Map.entry(ScalarFunction.REGEXP_REPLACE, new RegexpReplaceAdapter()),
import org.opensearch.be.datafusion.indexfilter.FilterTreeCallbacks;
import org.opensearch.analytics.spi.ProjectCapability;
            ? plugin.getClusterService().getClusterSettings().get(DataFusionPlugin.DATAFUSION_REDUCE_INPUT_MODE)
                // SINGLETON cost gate guarantees fully-gathered partition input.
        DataFormatRegistry registry = plugin.getDataFormatRegistry();
        ScalarFunction.JSON_EXTRACT,
        // SECOND / SECOND_OF_MINUTE / DAYOFWEEK / DAY_OF_WEEK use dedicated adapters
        ScalarFunction.IS_FALSE,
                    // Registering STANDARD_FILTER_OPS on MAP is sound because every viable
        // json_valid returns BOOLEAN, so it is a valid filter predicate (e.g. `where
     */
                            WindowFunction.PATTERN
        return Math.max(dataNodeCount, 1);
                    Map.entry(ScalarFunction.TO_DAYS, new EpochArithmeticAdapters.ToDaysAdapter()),
    // PPL command/function we want the analytics-engine planner to route through DataFusion. Add
import org.opensearch.analytics.spi.DelegationType;
        ScalarFunction.CTIME,
    }
                BufferAllocator allocator,
        DatafusionReader dfReader = null;
    @Override
                List<Integer> hashKeyChannels,
                    Map.entry(ScalarFunction.LAST_DAY, new LastDayAdapter()),
        // json_valid(col)` / `where not json_valid(col)`). DataFusion evaluates the json_valid Rust
        if (inputCount > 1 && preparedState == null) {
                long maxBytes
        // PPL PERIOD_ADD / PERIOD_DIFF — pure integer YYYYMM arithmetic.
        ScalarFunction.MICROSECOND,
                    // every other op (UPPER, ABS, ...) — those genuinely don't return arrays.
        // channel sits in the input path. Falls back to streaming only when a prepared state is
 * constructor (supported by {@code PluginsService.createExtension()}), so it has access
                for (AggregateFunction func : AGG_FUNCTIONS) {
    }
                    Map.entry(ScalarFunction.TIMESTAMPADD, new TimestampAddAdapter()),
                        ),
                    Map.entry(ScalarFunction.SAFE_CAST, ipBinaryCast),
        // SPAN_BUCKET reachable today via `bin <f> span=N`. WIDTH_BUCKET / MINSPAN_BUCKET /
                    Map.entry(ScalarFunction.MINUTE_OF_HOUR, minute),
        // to preserve MySQL semantics that DataFusion builtins don't match: EXTRACT
                org.apache.calcite.rel.type.RelDataType buildRowType,
        FilterTreeCallbacks.register(contextId, handle, tracker);
        ScalarFunction.NUMBER_TO_STRING,
        // PPL WEEKDAY — date_part('dow') remapped to MySQL Mon=0..Sun=6.
                    // TIMESTAMP UDF wrapper to a string inside a subquery (see adapter javadoc).
                    Map.entry(ScalarFunction.STRCMP, new StrcmpFunctionAdapter()),
                DayOfWeekAdapter dayOfWeek = new DayOfWeekAdapter();
        ScalarFunction.GREATER_THAN_OR_EQUAL,
                    Map.entry(ScalarFunction.SUBSTR, nameMapping(SqlStdOperatorTable.SUBSTRING)),
        ScalarFunction.DAY_OF_WEEK,
        ScalarFunction.TOSTRING,
        ScalarFunction.CURTIME,
        ScalarFunction.IS_NOT_FALSE,
                    Map.entry(ScalarFunction.DATE_FORMAT, new RustUdfDateTimeAdapters.DateFormatAdapter()),
                            WindowFunction.AVG,
        ScalarFunction.SUBSTR,
    public void cancelByContext(long contextId) {
        ScalarFunction.LESS_THAN_OR_EQUAL,
            );
        ScalarFunction.CAST,
 * Receives the fully-initialized {@link DataFusionPlugin} instance via its single-arg
                    Map.entry(ScalarFunction.CONCAT, new ConcatFunctionAdapter()),
    public SearchExecEngineProvider getSearchExecEngineProvider() {
                    )
            if (dataFusionService == null) {
    // the projection `fields str0` is rewritten to `CAST('FURNITURE' AS VARCHAR)`. CAST is also the
                    logTag,
    @Override
     * DataFusion threadpool. Returns {@code 1} if the cluster has no data nodes (gates the
                    Map.entry(ScalarFunction.SECOND_OF_MINUTE, second),
        ScalarFunction.JSON_VALID,
                        Set.of(
    /**
                    WindowFunction.DISTINCT_COUNT_APPROX,
                            WindowFunction.ROW_NUMBER,
        // UTC_* are pure aliases onto DF `now` / `current_date` / `current_time`
        ScalarFunction.CBRT,
        EngineCapability.MULTI_VALUE_EXPAND
                return new DatafusionPartitionedSink(
import org.opensearch.be.datafusion.planner.adapter.NumericConversionFunctionAdapter;
        // PPL bucketing label functions — Rust UDFs returning VARCHAR labels (e.g. "0-100").
        // default catalog, so adapters rewrite to DF-native interval arithmetic.
        return new DataFusionInstructionHandlerFactory(plugin);
import org.opensearch.analytics.spi.BackendExecutionContext;
        ScalarFunction.CONCAT_FUNCTION,
     * {@code make_array} via {@link MakeArrayAdapter}. {@code ARRAY_SLICE} and
                    for (FieldType type : SUPPORTED_FIELD_TYPES) {
        AggregateFunction.SUM0,
    // here only after verifying the function deserializes through Substrait isthmus into a plan
                // IpComparisonNormalizationAdapter so PPL IP-comparison UDFs (EQUALS_IP etc.) over
                    caps.add(new FilterCapability.Standard(op, Set.of(FieldType.MAP), formats));
                    Map.entry(ScalarFunction.GREATER_THAN_OR_EQUAL, comparisonTemporalCoercion),
        ScalarFunction.TIME,
    public BackendCapabilityProvider getCapabilityProvider() {
        ScalarFunction.SUBTIME,
                        caps.add(new FilterCapability.Standard(op, Set.of(type), formats));
                // WEEK/WEEK_OF_YEAR follow MySQL mode 0 (Sunday-first), not ISO; date_part('week') is ISO-only
                            JoinCapability.JoinKind.FULL,
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
                    Map.entry(ScalarFunction.MINUTE, minute),
                // are distinguishable in mixed traces.
        BufferAllocator allocator,
import org.opensearch.analytics.spi.WindowFunctionAdapter;
                    Map.entry(ScalarFunction.SPAN_BUCKET, new SpanBucketAdapter()),
                    Map.entry(ScalarFunction.CONVERT_TZ, new ConvertTzAdapter()),
        ScalarFunction.AUTO,
        int dataNodeCount = state.nodes().getDataNodes().size();
        if (dataFusionService == null) {
                    Map.entry(ScalarFunction.ARRAY_JOIN, new ArrayToStringAdapter()),
        // single-statement OLAP query so routing both to DF `now` is acceptable.
                // NowFspAdapter (not the plain NowAdapter) so the optional fractional-seconds
        // on a bounded input channel the join isn't yet draining blocks forever — observed on
        if (svc == null) {
 * Declares all analytics query capabilities (operators, filters, aggregates) and
            }
            ) {
        ScalarFunction.LTRIM,
    private final DataFusionPlugin plugin;
        ScalarFunction.YEAR,
                    // TIMESTAMPDIFF / TIMESTAMPADD have no substrait bindings; adapters rewrite to
        // lower to MIN/MAX OVER () empty-partition window aggregates — exercised end-to-end
                    Map.entry(ScalarFunction.QUARTER, DatePartAdapters.quarter()),
                    Map.entry(ScalarFunction.REGEXP, nameMapping(SqlLibraryOperators.REGEXP_LIKE)),
        ScalarFunction.JSON_DELETE,
        ScalarFunction.SUBSTRING,
        ScalarFunction.EQUALS,
     * <p>{@code JSON_EXTRACT_ALL} flattens a JSON object to dot-path keys, returning a
        ScalarFunction.JSON_VALID
                    Map.entry(ScalarFunction.SARG_PREDICATE, new SargAdapter()),
        SUPPORTED_FIELD_TYPES.add(FieldType.TEXT);
        ScalarFunction.SAFE_CAST,
import org.opensearch.analytics.spi.FragmentConvertor;
        SUPPORTED_FIELD_TYPES.add(FieldType.BINARY);
                    Map.entry(ScalarFunction.DAY_OF_WEEK, dayOfWeek),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    // ReduceExpressionsRule.ProjectReduceExpressionsRule (in PlannerImpl) constant-folds field
        // before substrait emission.
        ScalarFunction.TRANSLATE,
        ScalarFunction.ARRAY_DISTINCT,
        ScalarFunction.SHA2,
        ScalarFunction.RTRIM,
                    Map.entry(ScalarFunction.TOSTRING, new ToStringFunctionAdapter()),
        // render full weekday / month names via the same mysql_format tokens the
        return plugin.name();
                // Format string is backend-specific. "arrow-ipc-partitioned" means the producer
        // / TIME_FORMAT / STR_TO_DATE translate MySQL format tokens (%i / %s / %p …)
                    Map.entry(ScalarFunction.FROM_DAYS, new EpochArithmeticAdapters.FromDaysAdapter()),
        ScalarFunction.STRCMP,
                    // path fails with "Unable to convert call EXP(i32?)" / "POWER(i32?, fp64)" etc.
        // builtin `to_timestamp` via DatetimeAdapter.
        ScalarFunction.DIVIDE,
                    Map.entry(ScalarFunction.CONVERT, new ConvAdapter()),
        // Delegate to the plugin that owns the DataFusionService and native runtime.
        ScalarFunction.EQUALS,
                    }
                );
import org.opensearch.analytics.spi.IntegerRoundingCastAdapter;
                }
     * meaningful semantics over map-typed values; the value-level type emerges after the
import org.opensearch.analytics.spi.FieldType;
        ScalarFunction.REX_OFFSET,
    @Override
                    Map.entry(ScalarFunction.MINSPAN_BUCKET, new MinspanBucketAdapter()),
        }
        ScalarFunction.STR_TO_DATE,
            public Set<AggregateCapability> aggregateCapabilities() {
     * because the capability lookup keys on the call's return type, and for these the lookup
                    WindowFunction.COUNT,
import org.opensearch.analytics.spi.ScanCapability;
    /**
                            JoinCapability.JoinKind.SEMI,
            // ctx.getReader() != null block above, and DatafusionContext tolerates a null reader.
                    }
        ScalarFunction.LOWER,
        ScalarFunction.MVAPPEND
import org.opensearch.analytics.spi.ExchangeSinkContext;
            //
        AggregateFunction.MIN,
        ScalarFunction.LOG2,
            public Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
                    WindowFunctionAdapters.argMax(),
        AggregateFunction.PATTERN,
        ScalarFunction.GREATER_THAN,
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
                }
        ScalarFunction.SIGN,
                    Map.entry(ScalarFunction.CTIME, new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.CTIME)),
        // Array functions whose RETURN type is element-typed (not ARRAY itself), so the
            }
            return engine;
        ScalarFunction.PI,
            // dfReader may be null for hash-shuffle worker fragments — those have no shard scan
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context);
    }
                for (ScalarFunction op : POLYMORPHIC_RETURN_PROJECT_OPS) {
     */
        // ARRAY_LENGTH returns BIGINT → FieldType.LONG; ARRAY_JOIN returns VARCHAR →
import org.opensearch.analytics.spi.ExchangeSink;
        // is registered separately via {@link #MAP_RETURNING_PROJECT_OPS} (keyed on
        // capability lookup at OpenSearchProjectRule resolves the call's return type to a
import org.opensearch.analytics.spi.WindowFunction;
        AggregateFunction.APPROX_COUNT_DISTINCT,
                return Set.of(DelegationType.FILTER);
        ScalarFunction.RAND,
                    // RAND(): maps to DataFusion's niladic random() (the SqlStdOperatorTable.RAND ->
        // RANGE_BUCKET reach through `bin <f> bins=N` / `minspan=N` / `start=X end=Y`, which
        if (dfReader == null) {
                    caps.add(new ProjectCapability.Scalar(op, Set.of(FieldType.ARRAY), formats, true));
        ScalarFunction.CRC32,
        ScalarFunction.EARLIEST,
        ScalarFunction.E,
        // PPL `DATEDIFF(a, b)` — calendar-day delta, lowered to a day-index subtraction.
import org.opensearch.be.datafusion.planner.adapter.TimeConversionFunctionAdapter;
        ScalarFunction.ARRAY,
            NativeBridge.cancelQuery(contextId);
        // Pass row IDs to Rust via BigIntVector's direct buffer (zero-copy at FFM).
                        ),
        ScalarFunction.MINUTE_OF_DAY,
        AggregateFunction.MAX,
        ScalarFunction.RMUNIT,
        ScalarFunction.UPPER,
                    Map.entry(ScalarFunction.LATEST, new EarliestLatestAdapter.LatestAdapter()),
        ScalarFunction.CURDATE,
                SecondAdapter second = new SecondAdapter();
        ScalarFunction.IN,
        ScalarFunction.JSON_ARRAY_LENGTH,
                    Map.entry(ScalarFunction.CURDATE, currentDate),
                    Map.entry(ScalarFunction.DATE, new DateTimeAdapters.DateAdapter()),
import org.opensearch.analytics.spi.ShuffleSender;
        AggregateFunction.PERCENTILE_APPROX,
        ScalarFunction.MEMK,
        SUPPORTED_FIELD_TYPES.add(FieldType.MATCH_ONLY_TEXT);
                    Map.entry(ScalarFunction.ARRAY, new MakeArrayAdapter()),
        ScalarFunction.IS_TRUE,
                // conversion; DataFusion now() is niladic and fsp is intentionally ignored
                    Map.entry(ScalarFunction.SIGN, new IntegerRoundingCastAdapter(SignumFunction.FUNCTION)),
        // (FLOOR cast for SECOND, +1 offset for DAYOFWEEK) to preserve PPL's MySQL
                    // fails signature lookup. NumericToDoubleAdapter widens any numeric operand to fp64
                    Map.entry(ScalarFunction.ADDDATE, new DateAddSubAdapter(true)),
                    new WindowCapability(
    // path). COALESCE is the lowering target of PPL `fillnull`. CAST is required because
                    Map.entry(ScalarFunction.NOW, now),
        ScalarFunction.LIKE,
                    : ShuffleCompression.Config.DISABLED;
    }
                    // COUNT(x) passes through unchanged.
                }
        ScalarFunction.MD5,
        // directly (e.g., from a REST action) without going through the SPI.
     * isn't pinned by the operator. One partition per data node maximizes parallelism without
        DataFusionService svc = plugin.getDataFusionService();
                    dfReader = ctx.getReader().getReader(registry.format(formatName), DatafusionReader.class);
                    Map.entry(ScalarFunction.YEAR, DatePartAdapters.year()),
            throw new IllegalStateException("DataFusionService not initialized");
                return Set.of(new ScanCapability.DocValues(formats, Set.copyOf(SUPPORTED_FIELD_TYPES)));
                    // Coerce a bare character operand to TIMESTAMP when compared against a temporal
        ScalarFunction.JSON_EXTRACT_ALL,
                ShuffleCompression.Config compression = plugin.getClusterService() != null
 * compatible open source license.
                    Map.entry(ScalarFunction.ADDTIME, new AddSubTimeAdapter(true)),
                    // per_* shape TIMESTAMPDIFF(out, t, TIMESTAMPADD(in, n, t)) to a literal.
    private static final Set<ScalarFunction> ARRAY_RETURNING_PROJECT_OPS = Set.of(
                    Map.entry(ScalarFunction.DATE_SUB, new DateAddSubAdapter(false)),
    ) {
        SUPPORTED_FIELD_TYPES.addAll(FieldType.numeric());
                }
                    Map.entry(ScalarFunction.COT, new NumericToDoubleAdapter(SqlStdOperatorTable.COT)),
                    Map.entry(ScalarFunction.EXP, new NumericToDoubleAdapter(SqlStdOperatorTable.EXP)),
        ScalarFunction.NOT_EQUALS,
                    // shape `ITEM(map_field, key) <op> literal` (PPL `where doc.user.name = 'John'`
                    Map.entry(ScalarFunction.CURRENT_TIMESTAMP, now),
            public Set<DataTransferCapability> dataTransferCapabilities() {
import org.opensearch.analytics.spi.FilterDelegationHandle;
                    hashKeyChannels,
    // CONCAT is the lowering target of PPL `eval`'s `+` for strings (Calcite emits `||`, resolved to
            public Set<ProjectCapability> projectCapabilities() {
                    Map.entry(ScalarFunction.SPAN, new SpanAdapter()),
        ScalarFunction.UTC_TIMESTAMP,
                    Map.entry(ScalarFunction.TO_SECONDS, new EpochArithmeticAdapters.ToSecondsAdapter()),
                    Map.entry(ScalarFunction.MOD, new ModAdapter()),
                    Map.entry(ScalarFunction.ASIN, new NumericToDoubleAdapter(SqlStdOperatorTable.ASIN)),
                    Map.entry(ScalarFunction.MKTIME, new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.MKTIME)),
        ScalarFunction.SEC_TO_TIME,
            public ExchangeSink createBroadcastCaptureSink(
            public Set<EngineCapability> supportedEngineCapabilities() {
                            JoinCapability.JoinKind.RIGHT,
    public Runnable configureFilterDelegation(
                    Map.entry(ScalarFunction.TIME_TO_SEC, new EpochArithmeticAdapters.TimeToSecAdapter()),
    );
        AggregateFunction.AVG,
                    Map.entry(ScalarFunction.DUR2SEC, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.DUR2SEC)),
    public String name() {
    private static final Logger LOGGER = LogManager.getLogger(DataFusionAnalyticsBackendPlugin.class);
                    Map.entry(ScalarFunction.LOG10, new NumericToDoubleAdapter(SqlStdOperatorTable.LOG10)),
 *
    }
 * <p>
            public Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {
        // adapter class.
    // for eval-style projections.
                    Map.entry(ScalarFunction.LIKE, new LikeAdapter()),
                    Map.entry(ScalarFunction.LOG2, new NumericToDoubleAdapter(SqlLibraryOperators.LOG2)),
            }
            }
                context.setSessionContextHandle(sessionState.sessionContextHandle());
                    Map.entry(ScalarFunction.DATEDIFF, new DateDiffAdapter()),
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        ScalarFunction.REX_EXTRACT,
    }
     *
                    Map.entry(ScalarFunction.MICROSECOND, new MicrosecondAdapter()),
                    Map.entry(ScalarFunction.TONUMBER, new ToNumberFunctionAdapter()),
            return new DatafusionMemtableReduceSink(ctx, svc.getNativeRuntime());
        // UDF natively; same shape as CIDRMATCH.
        ScalarFunction.DAYNAME,
        // approximation — PPL SYSDATE uses the systemClock (call-time) while NOW
        // `case(a = 0 and b = 0, …)`, `eval x = a or b`, `eval x = NOT y`. DataFusion's substrait
                    Map.entry(ScalarFunction.JSON, new JsonFunctionAdapters.JsonAdapter()),
                    Map.entry(ScalarFunction.LOG, new NumericToDoubleAdapter(SqlLibraryOperators.LOG)),
import org.opensearch.analytics.spi.EngineCapability;
        ScalarFunction.REPLACE,
import org.opensearch.index.shard.IndexShard;
     * base cannot be instantiated directly.
                    Map.entry(ScalarFunction.DIVIDE, new DivideAdapter()),
            dfReader = reader.getReader(registry.format(formatName), DatafusionReader.class);
        EngineCapability.VALUES,
        // from a TIMESTAMP / DATE / TIME / string value. Route to DataFusion's
                            WindowFunction.RANK,
                    Map.entry(ScalarFunction.DEGREES, new NumericToDoubleAdapter(SqlStdOperatorTable.DEGREES)),
        // substrait consumer handles IfThen natively. Without this entry, the analytics planner
        ScalarFunction.DATE,
        ScalarFunction.IS_FALSE,
        ScalarFunction.RANGE_BUCKET,
                    new JoinCapability(
        ScalarFunction.STRFTIME,
        // the integer-days form is normalized to INTERVAL N DAY. DATE / TIMESTAMP bases only.
     */
        ScalarFunction.LESS_THAN,
import org.opensearch.analytics.spi.JoinCapability;
                if (dfReader == null) {
        ScalarFunction.SYSDATE,
                    )
                    compression
    // implicit result-type narrowing PPL inserts after a UDF call whose declared return type differs
        // consumer handles them natively.
        ScalarFunction.EXPM1,
        // and explicit `eval x = case(cond, val, ...)`. Isthmus translates SqlKind.CASE structurally
     * Pure rename from a PPL scalar to {@code target} — no prepend / append operands.
        ScalarFunction.JSON_APPEND,
                    // NumericToDoubleAdapter javadoc for the type-widening rules. Without these the
                    Map.entry(ScalarFunction.CURRENT_TIME, currentTime),
        };
                    Map.entry(ScalarFunction.EXTRACT, new RustUdfDateTimeAdapters.ExtractAdapter()),
        ScalarFunction.ADDDATE,
                    Map.entry(ScalarFunction.RANGE_BUCKET, new RangeBucketAdapter()),
    public int defaultShuffleParallelism(org.opensearch.cluster.ClusterState state) {
        String[] columns,
     * resolves to {@link FieldType#ARRAY} — which is intentionally not in
        this.plugin = plugin;
        AggregateFunction.TAKE,
    );
                    Map.entry(ScalarFunction.FROM_UNIXTIME, new RustUdfDateTimeAdapters.FromUnixtimeAdapter()),
                    Map.entry(ScalarFunction.JSON_EXTRACT_ALL, new JsonFunctionAdapters.JsonExtractAllAdapter()),
        return ParquetRangeEvaluator.evaluate(shard, filterBytes, plugin);
                    Map.entry(ScalarFunction.LESS_THAN, comparisonTemporalCoercion),
        DataFusionReduceState preparedState = backendContext instanceof DataFusionReduceState s ? s : null;
                    Map.entry(ScalarFunction.TRUNCATE, new IntegerRoundingCastAdapter(SqlStdOperatorTable.TRUNCATE)),
        // supplied (the memtable sink doesn't support the prepared-plan path; that path is
    // keeps the capability declaration complete for auditing and symmetric with PROJECT_OPS.
package org.opensearch.be.datafusion;
     * {@link JsonFunctionAdapters.JsonExtractAllAdapter}.
        // dedicated Rust UDF (rust/src/udf/<name>.rs). Declared here so the analytics planner
        ScalarFunction.CONCAT_WS,
        // PPL `time(expr)` / `date(expr)` — extract time-of-day / date component
        ScalarFunction.LEFT,
        ScalarFunction.ARRAY_JOIN,
     * {@link #SUPPORTED_FIELD_TYPES} (filter and aggregate operators have no meaningful semantics
        ScalarFunction.CHAR_LENGTH,
        ScalarFunction.SAFE_CAST,
                // coercion (and before Substrait conversion, which has no EQUALS_IP binding).
                // Alias pairs share an adapter instance but need separate enum entries because
                    for (FieldType ft : FieldType.values()) {
        AggregateFunction.VALUES,
 * <p>
        // PPL `ADDDATE(base, N|INTERVAL)` / `SUBDATE(...)` — share the DATE_ADD/DATE_SUB adapter;
    }
}
                DataFormatRegistry registry = plugin.getDataFormatRegistry();
    public ExchangeSinkProvider getExchangeSinkProvider() {
 */
import org.opensearch.analytics.spi.WindowCapability;
    /**
                        ? Set.of(FieldType.ARRAY)
        ScalarFunction.IS_NOT_TRUE,
import org.opensearch.analytics.spi.DataTransferCapability;
            @Override
                    // DATETIME_PLUS + INTERVAL / to_unixtime arithmetic. Peephole folds the timechart
        ScalarFunction.IN,
        ScalarFunction.EARLIEST,
        ScalarFunction.DAY_OF_YEAR,
import org.apache.arrow.vector.types.pojo.Schema;
import org.apache.logging.log4j.Logger;
        ScalarFunction.GREATER_THAN_OR_EQUAL,
            @Override
                    Map.entry(ScalarFunction.BINARY, new BinaryFunctionAdapter()),
                    Map.entry(ScalarFunction.STRFTIME, new StrftimeFunctionAdapter()),
        ScalarFunction.RMCOMMA,
            @Override
            @Override
                // Resolve the shuffle-IPC compression policy live from the cluster settings (default OFF).
        // CASE — Calcite emits CASE WHEN ... THEN ... END for conditional expressions, including
                    Set<FieldType> types = op == ScalarFunction.REX_EXTRACT_MULTI
                DatePartAdapters dayOfYear = DatePartAdapters.dayOfYear();
    );
        }
 * SPI extension discovered by analytics-engine via {@code META-INF/services}.
            }
                ScalarFunctionAdapter now = new NowFspAdapter();
        // Date-part extractors rewrite to date_part(<unit>, ts) via DatePartAdapters.
        // PPL LAST_DAY — date_trunc('month') + 1 month - 1 day. YEARWEEK — os_yearweek Rust UDF.
     * {@code ITEM(map, key)} lookup that always follows a map-returning call).
        ScalarFunction.EXP,
        ScalarFunction.SECOND_OF_MINUTE,
                Schema fallback = buildRowType == null ? null : CalciteToArrowSchema.convert(buildRowType);
        ScalarFunction.REVERSE,
        ScalarFunction.IS_NULL,
     */
        ScalarFunction.REX_EXTRACT_MULTI,
    // CONCAT in ScalarFunction); SAFE_CAST covers PPL `eval`'s explicit nullable `CAST(... AS ...)`
        ScalarFunction.PLUS,
        // see a real time/date type and Isthmus serializes accordingly.
        // coordinator, it hands over a DataFusionReduceState carrying the session +
        // rejects the operator with "No backend supports scalar function [CASE] among [datafusion]"
        ScalarFunction.JSON_ARRAY,
    // Filter-side scalar functions DataFusion can evaluate natively. Comparisons, arithmetic
        SUPPORTED_FIELD_TYPES.addAll(FieldType.date());
                );
        ScalarFunction.WIDTH_BUCKET,
        ScalarFunction.IS_NOT_NULL,
        // Fire the per-context cancellation token so the fetch stream's cross_rt task breaks
                return Map.ofEntries(
                    // Trigonometric functions: substrait `sin/cos/tan/...` declare fp32/fp64 impls only.
        return new DatafusionReduceSink(ctx, svc.getNativeRuntime(), preparedState);
        ScalarFunction.LOG10,
import org.opensearch.analytics.spi.SearchExecEngineProvider;
        BufferAllocator importStagingAllocator
        // PPL `span(field, interval, unit?)` — bucketing for `stats … by span(...)`. Numeric
        return new DataFusionFragmentConvertor(plugin.getSubstraitExtensions());
                // VARBINARY ip/binary fields are rewritten to native comparators before temporal
    public boolean canMatch(IndexShard shard, byte[] filterBytes) {
                            JoinCapability.JoinKind.CROSS
            if (ctx.getReader() != null) {
        // TIMESTAMPADD('MINUTE', 1, @timestamp)))}. Both PPL UDFs are unknown to isthmus's
                // precision arg — now(fsp) / current_timestamp(fsp) — is dropped before Substrait
            public ExchangeSink createPartitionedSink(
     * auto-extract mode; routes to the {@code json_extract_all} Rust UDF via
    /**
            // both hang off AnalyticsShardTask#getNativeTaskId(), so a non-analytics task must
        return new AbstractNameMappingAdapter(target, List.of(), List.of()) {
                DateTimeAdapters.CurrentDateAdapter currentDate = new DateTimeAdapters.CurrentDateAdapter();
     * {@code OpenSearchProjectRule.resolveScalarViableBackends} keys on the call's return
        // FieldType.KEYWORD (renamed to DataFusion `array_to_string` via {@link ArrayToStringAdapter}).
        ScalarFunction.MINUS,
     * {@code ARRAY_DISTINCT} pass through by name (Calcite stdlib operator names match
                    Map.entry(ScalarFunction.GROK, new GrokAdapter()),
            public Set<WindowCapability> windowCapabilities() {
     * DataFusion's native names — isthmus default catalog binds them).
                    Map.entry(ScalarFunction.ARRAY_SLICE, new ArraySliceAdapter()),
        AggregateFunction.SUM,
            }
                    // after the spath auto-extract lowering). The filter-rule's field-index
                    context.allocator(),
     * Registered separately because the capability lookup at
                    Map.entry(ScalarFunction.JSON_ARRAY_LENGTH, new JsonFunctionAdapters.JsonArrayLengthAdapter()),
                DateTimeAdapters.CurrentTimeAdapter currentTime = new DateTimeAdapters.CurrentTimeAdapter();
import org.opensearch.analytics.spi.ExchangeSinkProvider;
                            WindowFunction.COUNT,
                    Map.entry(ScalarFunction.SUBDATE, new DateAddSubAdapter(false)),
    @Override
        ScalarFunction.CONVERT,
                return Set.of(
        ScalarFunction.DUR2SEC,
        // native streams must still find the binding, so closing here would race them.
                    Map.entry(ScalarFunction.EXPM1, new Expm1Adapter()),
                bufAddr,
     *
                    Map.entry(ScalarFunction.MAKEDATE, new RustUdfDateTimeAdapters.MakedateAdapter()),
    // by {@link OpenSearchFilterRule} structurally and never looked up here, but registering them
                    WindowFunction.ARG_MAX,
        ScalarFunction.GET_FORMAT,
        // PPL conversion family — all five route through ConversionFunctionAdapter to a
        // collects its build side fully before the probe, so a build-side producer back-pressuring
        ScalarFunction.ARRAY_LENGTH,
                    Map.entry(ScalarFunction.SHA2, new Sha2FunctionAdapter()),
     * DataFusion participates in MPP hash-shuffle: default the partition count to the number of
        ScalarFunction.UTC_DATE,
                return Set.of(
        ScalarFunction.MINUTE_OF_HOUR,
                        Set.copyOf(plugin.getSupportedFormats())
        ScalarFunction.NULLIF,
        ScalarFunction.TIME_DIFF,
                    Map.entry(ScalarFunction.UTC_TIME, currentTime),
     */
        ScalarFunction.QUARTER,
        // FieldType.MAP rather than SUPPORTED_FIELD_TYPES, mirroring the ARRAY-return split).
        ScalarFunction.PERIOD_DIFF,
    );
                    ? ShuffleCompression.Config.from(plugin.getClusterService().getClusterSettings())
     * <p>{@code ARRAY} (PPL {@code array(a, b, …)} constructor) renames to DataFusion's
        // PPL extract / make* / format / from_unixtime are implemented as Rust UDFs
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
                    Map.entry(ScalarFunction.WEEK, week),
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
 */
            // that fires. So upstream's unconditional "dfReader == null" fail-fast is NOT applied
    }
    }
                // queryId+stageId+side are stamped onto the framework-provided sender; the sink
                    WindowFunction.ARG_MIN,
        return ParquetRangeEvaluator.evaluateWithBounds(shard, filterBytes, sortColumn, plugin);
                    caps.add(new ProjectCapability.Scalar(op, types, formats, true));
                }
                        // AggregateDecompositionResolver falls back to the enum's
                    Map.entry(ScalarFunction.UNIX_TIMESTAMP, new UnixTimestampAdapter()),
        // MINUTE_OF_DAY decomposes to date_part('hour',x)*60 + date_part('minute',x).
    private static final Set<ScalarFunction> MAP_RETURNING_PROJECT_OPS = Set.of(
        ScalarFunction.SIN,
            }
        ScalarFunction.MVFIND,
        // ABS / SUBSTRING — PPL sort-pushdown moves these into the project tree; DataFusion has
        ScalarFunction.SARG_PREDICATE,
    /**
        ScalarFunction.UTC_TIME,
            @Override
                // Stateless adapter shared across the six comparison operators. Wrapped by
        ScalarFunction.DATE_SUB,
                    Map.entry(ScalarFunction.MVFIND, new MvfindAdapter()),
import org.opensearch.analytics.exec.shuffle.ShuffleCompression;
                    // predicate against a MAP column is forced through an ITEM lookup that
                            WindowFunction.SUM,
                }
     * type, and for these the lookup resolves to {@link FieldType#MAP} — intentionally not
    @Override
import org.opensearch.analytics.spi.AggregateFunction;
        ScalarFunction.DAYOFYEAR,
        ScalarFunction.POSITION,
        return plugin.getTopQueriesByMemory();
        ScalarFunction.LOG,
    private static final Set<ScalarFunction> POLYMORPHIC_RETURN_PROJECT_OPS = Set.of(ScalarFunction.CAST, ScalarFunction.SAFE_CAST);
                    Map.entry(ScalarFunction.MINUS, new MinusAdapter()),
        // PPL `mvindex(arr, N)` single-element form.
                    Map.entry(ScalarFunction.MINUTE_OF_DAY, new MinuteOfDayAdapter()),
                dataFusionService.getNativeRuntime()
     * Context-aware override: registers the handle and tracker under {@code contextId}
                // only needs an opaque tag for log messages so producers from different stages
                    Map.entry(ScalarFunction.TIME, new DateTimeAdapters.TimeAdapter()),
        ScalarFunction.TIMESTAMP,
        // (DataFusion runs in UTC by default; PPL UTC_* just force UTC semantics).
     * shuffle rule out and falls back to coordinator-centric).
        ScalarFunction.PARSE,
                    Map.entry(ScalarFunction.DAYOFMONTH, day),
        ScalarFunction.SARG_PREDICATE,
        ScalarFunction.COALESCE,
        ScalarFunction.UNIX_TIMESTAMP,
                    new DataTransferCapability(DataTransferCapability.Kind.PRODUCER, "arrow-ipc-partitioned"),
        ScalarFunction.DAYOFWEEK,
                return Set.of(
                Set<FilterCapability> caps = new HashSet<>();
            }
                    // operands in CAST(DOUBLE) before substrait conversion so isthmus can bind. See
    }
                dfReader.getReaderHandle().getPointer(),
        ScalarFunction.LAST_DAY,
            @Override
                    Map.entry(ScalarFunction.MONTH, month),
    );
    // are all supported via the Substrait default extension catalog. AND/OR/NOT are recursed into
    static {
                    new ComparisonTemporalCoercionAdapter()
        long streamPtr;
                    Map.entry(ScalarFunction.COS, new NumericToDoubleAdapter(SqlStdOperatorTable.COS)),
        ScalarFunction.LOCATE,
 * The OpenSearch Contributors require contributions made to
                    // before substrait conversion (no-op when the operand is already fp32/fp64).
        return new DatafusionResultStream(streamHandle, allocator, importStagingAllocator);
                    Map.entry(ScalarFunction.EQUALS, comparisonTemporalCoercion),
        // per-adapter Javadoc for semantics + collision notes.
            @Override
                    Map.entry(ScalarFunction.CEIL, new IntegerRoundingCastAdapter(SqlStdOperatorTable.CEIL)),
        ScalarFunction.DIVIDE,
import org.opensearch.analytics.planner.CalciteToArrowSchema;
    /**
        ScalarFunction.MSTIME,
                    if (dfReader != null) {
                            JoinCapability.JoinKind.ANTI,
                IpBinaryCastFunctionAdapter ipBinaryCast = new IpBinaryCastFunctionAdapter();
    // DataFusion's native runtime can execute (see DataFusionFragmentConvertor for the conversion
import org.opensearch.analytics.spi.AggregateCapability;
                    Map.entry(ScalarFunction.TIME_DIFF, new TimeDiffAdapter()),
                    Map.entry(ScalarFunction.HOUR_OF_DAY, hour),
            @Override
    private static final Set<FieldType> SUPPORTED_FIELD_TYPES = new HashSet<>();
        ScalarFunction.CIDRMATCH,
                for (ScalarFunction op : ARRAY_RETURNING_PROJECT_OPS) {
import org.opensearch.be.datafusion.nativelib.StreamHandle;
                            WindowFunction.DISTINCT_COUNT_APPROX,
        ScalarFunction.TRUNCATE,
        ScalarFunction.JSON_EXTEND,
        EngineCapability.UNION,
                    new DataTransferCapability(DataTransferCapability.Kind.CONSUMER, "arrow-ipc-partitioned")
        ScalarFunction.CURRENT_DATE,
                    Map.entry(ScalarFunction.TIMESTAMPDIFF, new TimestampDiffAdapter()),
        return () -> FilterTreeCallbacks.requestClose(contextId);
     * CAST and SAFE_CAST effectively can return anything, so they get registered as everything
                    Map.entry(ScalarFunction.JSON_DELETE, new JsonFunctionAdapters.JsonDeleteAdapter()),
     * so that concurrent queries each have their own isolated FFM callback binding.
        ScalarFunction.MOD,
        }
        ScalarFunction.MAKETIME,
        // JSON_EXTRACT_ALL — return type is MAP<VARCHAR, VARCHAR>, so its capability
        ScalarFunction.YEARWEEK
        // the analytics-engine path because sql-repo PR #5408
        // {@code date_trunc(unit, field)}. Both targets are substrait-default operators.
        ScalarFunction.TO_SECONDS,
                    Map.entry(ScalarFunction.REX_EXTRACT, new RexExtractAdapter()),
        };
        // date_format UDF already uses.
            // and read only from named-input streams registered on the SessionContextHandle by
                    Map.entry(ScalarFunction.POWER, new NumericToDoubleAdapter(SqlStdOperatorTable.POWER)),
        ScalarFunction.CURRENT_TIME,
        SUPPORTED_FIELD_TYPES.add(FieldType.BOOLEAN);
    @Override
        // standard scalar FieldType and matches against SUPPORTED_FIELD_TYPES.
        DelegationThreadTracker tracker,
        ScalarFunction.LESS_THAN,
                    Map.entry(ScalarFunction.JSON_KEYS, new JsonFunctionAdapters.JsonKeysAdapter()),
        // PPL ADDTIME / SUBTIME / TIMEDIFF — time-of-day arithmetic via to_unixtime + maketime.
                    Map.entry(ScalarFunction.WEEK_OF_YEAR, week),
                            WindowFunction.MAX,
                return Set.copyOf(caps);
import org.apache.arrow.memory.BufferAllocator;
        // TPC-H q15). The memtable sink buffers each input fully in Java first, so no bounded native
                dataFusionService.getNativeRuntime().get(),
        // that DataFusion's `to_char` does not recognize.
                    Map.entry(ScalarFunction.SCALAR_MIN, nameMapping(SqlLibraryOperators.LEAST)),
                    // silently turn deterministic seeded output into non-deterministic random().
        // When the FinalAggregateInstructionHandler has already prepared a plan on the
        ScalarFunction.ITEM,
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
        long contextId,
        String mode = plugin.getClusterService() != null
                count,
     * Project-side scalar functions whose return type is {@code MAP<VARCHAR, VARCHAR>}.
                    Map.entry(ScalarFunction.MVZIP, new MvzipAdapter()),
            DatafusionContext context = new DatafusionContext(
        SUPPORTED_FIELD_TYPES.addAll(FieldType.keyword());
                    Map.entry(ScalarFunction.SIN, new NumericToDoubleAdapter(SqlStdOperatorTable.SIN)),
        // routes the calls to this backend; the actual rewrite shape is documented on the
                    Map.entry(ScalarFunction.YEARWEEK, new RustUdfDateTimeAdapters.OsYearweekAdapter()),
                // back to Arrow record batches before feeding them to the worker plan via
        ScalarFunction.CIDRMATCH,
        ScalarFunction.SUBDATE,
                    // COUNT(DISTINCT x) OVER(...) → os_count_distinct(x) OVER(...). Non-distinct
                String logTag = context.queryId() + "/stage=" + context.stageId();
                    // keys capability lookups on the call's return type, so this op must be
        int count = rowIdVector.getValueCount();
        ScalarFunction.EXTRACT,
                    Map.entry(ScalarFunction.FLOOR, new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR)),
                }
            }
        if (contextId != 0) {
        ScalarFunction.SPAN,
        ScalarFunction.NUM,
        ScalarFunction.ITEM,
                            JoinCapability.JoinKind.INNER,
        }
        ScalarFunction.JSON_SET,
                    // "No backend can evaluate filter predicate [...] on fields [<col>:MAP]".
        ScalarFunction.PERIOD_ADD,
            // the prior ShuffleScanHandler chain. The searcher's vanilla path is unreachable in
                    Map.entry(ScalarFunction.RMCOMMA, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.RMCOMMA)),
                // StreamingTableExec + PartitionStream (the ShuffleScanHandler's job).
        ScalarFunction.TIMES,
        ScalarFunction.SPAN_BUCKET,
 * to the {@link DataFusionService} created during plugin lifecycle.
        // Single-input: honor the mode setting (memtable buffers; streaming default streams).
        ScalarFunction.IS_NOT_FALSE,
                    }
                    Map.entry(ScalarFunction.SUBSTRING, nameMapping(SqlStdOperatorTable.SUBSTRING)),
    }
        FilterDelegationHandle handle,
import org.opensearch.analytics.spi.BackendCapabilityProvider;
import org.apache.calcite.sql.SqlOperator;
        ScalarFunction.AND,
        // timechart's `per_*` aggregations (per_second / per_minute / per_hour / per_day),
                contextId
        ScalarFunction.REGEXP,
    @Override
            // The AnalyticsShardTask cast is upstream's: the context id and cancellation wiring
        ScalarFunction.HOUR_OF_DAY,
                DatePartAdapters day = DatePartAdapters.day();
        // by a custom Rust UDF on the DataFusion session context (`udf::mvfind`), routed via
    }
                Set<String> formats = Set.copyOf(plugin.getSupportedFormats());
        // DAYNAME / MONTHNAME rewrite to date_format(x, '%W') / ('%M') — %W / %M
                    Map.entry(ScalarFunction.TAN, new NumericToDoubleAdapter(SqlStdOperatorTable.TAN)),
                Set<AggregateCapability> caps = new HashSet<>();
        BigIntVector rowIdVector,
        // single-input final-aggregate so it's never a multi-input deadlock).
        // PPL epoch-arithmetic datetime scalars — lower to to_unixtime/from_unixtime + integer math.
        ScalarFunction.TIME_FORMAT,
                    sender,
                    // emits a value-typed scalar before substrait emission.
        ScalarFunction.COT,
                }
import java.util.List;
        ScalarFunction.CONVERT_TZ,
                    Map.entry(ScalarFunction.JSON_ARRAY, new JsonFunctionAdapters.JsonArrayAdapter()),
        // {@link MvfindAdapter}.
        ScalarFunction.BINARY,
        ScalarFunction.SHA1,
        ScalarFunction.WEEK,
                            WindowFunction.MIN,
                    Map.entry(ScalarFunction.UTC_DATE, currentDate),
                    Map.entry(ScalarFunction.MONTH_OF_YEAR, month),
        ScalarFunction.DATEDIFF,
        ScalarFunction.MINUTE,
        ScalarFunction.RIGHT,
        ScalarFunction.ATAN,
        AggregateFunction.LIST,
import org.opensearch.analytics.spi.FilterCapability;
                    Map.entry(ScalarFunction.AUTO, new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.AUTO)),
            }
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
                    Map.entry(ScalarFunction.LOCATE, new PositionAdapter()),
        return NativeErrorConverter.convert(original);
        if ("memtable".equals(mode) && inputCount == 1 && preparedState == null) {
            }
        ScalarFunction.MVZIP,
                        caps.add(new AggregateCapability(func, Set.of(type), formats));
            DataFusionService dataFusionService = plugin.getDataFusionService();
            : "streaming";
                );
                            WindowFunction.NTH_VALUE,
     * data nodes in the cluster. The advisor uses this when {@code analytics.mpp.shuffle.partitions}
                    Map.entry(ScalarFunction.ARRAY_LENGTH, new IntegerReturnWideningCastAdapter()),
        ScalarFunction.TIMESTAMPDIFF,
                );
                for (ScalarFunction op : STANDARD_PROJECT_OPS) {
     * {@code MAP<VARCHAR, VARCHAR>}. First in-tree caller is PPL {@code spath}'s
