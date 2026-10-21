                if (other instanceof MultiValueExpandRel expand) {
                io.substrait.expression.ImmutableExpression.SortField.builder()
     * ({@link #convertToSubstrait}) and the wrapper/partial-aggregate path
            }
            if (filter == null) {
            super(extensions);
     * Other local stubs without transformations stay as plain {@link SqlAggFunction}; the
        SqlKind.OTHER_FUNCTION,
 *
        FunctionMappings.s(ParseAdapter.LOCAL_PARSE_OP, "parse"),
 */
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
    /**
        // OpenSearchBroadcastScan leaves (M1 broadcast probe fragments carry
        }
                    .expr(sortKey)
        private MultiValueExpandDetail(MultiValueExpandSpec spec) {
    static final SqlAggFunction LOCAL_TAKE_OP = new SqlAggFunction(
     * <p>TODO: assess whether each of these rewriters genuinely needs to run at the Substrait
                    if (rewritten == null) rewritten = new ArrayList<>(args);
            }
        ReturnTypes.ARG0,
        static final String TYPE_URL = "opensearch://analytics/multi_value_expand/v1";
            super(cluster, traitSet, List.of(), new StageInputRelOptTable(stageInputId, rowType));
            return null;
        FunctionMappings.s(SqlLibraryOperators.REVERSE, "reverse"),
        @Override
        FunctionMappings.s(PatternParserAdapter.LOCAL_PATTERN_PARSER_OP, "pattern_parser"),
            }
        Plan rewired = rewire(
            if (argRef.getType().getComponentType() != null || argRef.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {
    // into their own class, mirroring the per-function scalar *Adapter classes, to keep this file
        }
        }
        List<FunctionArg> rewritten = null;
    /**
        };
            extensions.windowFunctions(),
            }
        boolean addedSort = false;
        Optionality.FORBIDDEN
     * Substrait compute, but the parent reduce sink (Stage 3) still calls
     * Calcite RelNode round-trip. Output:
                Optional<AggregateFunctionInvocation> bound = super.convert(input, inputType, call, rexConverter);
     */
        false,
        "os_count_distinct",
        "pattern_parser_get_pattern",
        }
import io.substrait.isthmus.expression.AggregateFunctionConverter;
        ReturnTypes.ARG0_NULLABLE,
        Function<RexNode, Expression> rexConverter
            this.rowType = rowType;
            // Decoded from the wire: rebuild the same shape substrait_consumer.rs produces. The
        }
    }
        LOGGER.debug("Schema-only Read for stage [{}]: {} bytes", childStageId, bytes.length);
         */
                if (rewrittenArgs.isPresent()) {
        FunctionMappings.s(NumericConversionFunctionAdapter.MEMK, "memk"),
        // Fully-qualified names below: io.substrait.proto.{Plan,Rel,NamedStruct,RelRoot} clash with already-imported single-name imports.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            AggregateFunctionInvocation fn = m.getFunction();
        }
        @Override
            .stream()
     * Unlike the {@code cast}/{@code tostring} path this does NOT uppercase booleans — native
                throw new IllegalArgumentException("Not a multi-value expand extension: " + (any == null ? null : any.getTypeUrl()));
import org.apache.calcite.rel.RelDistributions;
    /** PARTIAL-side VALUES over a source multi-value field; flattens and de-duplicates elements. */
        FunctionMappings.s(JsonFunctionAdapters.JsonSetAdapter.LOCAL_JSON_SET_OP, "json_set"),
import org.opensearch.analytics.spi.FragmentConvertor;
    ) {
     * details. The stock converter maps every unknown extension to an {@code EmptyDetail} whose
import org.apache.calcite.rel.type.RelDataTypeFactory;
            Type element = list.elementType().withNullable(true);
        false,
        if (arg.getType() instanceof org.opensearch.analytics.schema.IpType) {
                // Let the op rewrite its data args (e.g. a type-coercing CAST) on the bound Substrait
        FunctionMappings.s(RexExtractMultiAdapter.LOCAL_REX_EXTRACT_MULTI_OP, "rex_extract_multi"),
            typeFactory,
import io.substrait.expression.FunctionArg;
        }
        }
     * arg is stripped by {@link PplAggregateCallRewriter} before binding; the percentile
    ) {
            if (expr instanceof Expression.WindowFunctionInvocation) {
            AggregateFunctionInvocation rephased = AggregateFunctionInvocation.builder().from(fn).aggregationPhase(phase).build();
import java.nio.ByteBuffer;
         * Whether null arguments are dropped before aggregating. Carried as the measure's
            extensions.aggregateFunctions(),
    static final SqlAggFunction LOCAL_LAST_OP = new SqlAggFunction(
                if (bound.isEmpty()) {
        FunctionMappings.s(DateTimeAdapters.LOCAL_CURRENT_DATE_OP, "current_date"),
     * {@code count(distinct x) OVER(...)} via {@link WindowFunctionAdapters#countDistinctExact()}.
        if (!(rel instanceof Aggregate agg)) {
        public RexNode normaliseLiteralArg(int argIndex, RexLiteral lit, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        /**
}
    }
        OperandTypes.ANY_ANY,
 * this file be licensed under the Apache-2.0 license or a
            if (!matches(any)) {
        FunctionMappings.s(SqlStdOperatorTable.ASCII, "ascii"),
        }
                // percentile at planning. There is no scaled-vs-unscaled ambiguity (NULL ≠ 50.0).
        ) {
        private final List<String> qualifiedName;
     * LIST/VALUES — carries the PPL element-rendering contract via the {@link LocalAggOp} hooks:
        for (RelNode input : node.getInputs()) {
        public Optional<RexNode> rewriteDataArg(int argIndex, RexNode argRef, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        @Override
        FunctionMappings.s(JsonFunctionAdapters.JsonDeleteAdapter.LOCAL_JSON_DELETE_OP, "json_delete"),
        ) {
     */
     * {@link #convertSchemaOnlyRead} call.
            .declaration(variant)
 * The OpenSearch Contributors require contributions made to
        FunctionMappings.s(TimeConversionFunctionAdapter.MKTIME, "mktime"),
            return lit;
    static final class StageInputTableScan extends TableScan {
     * <ul>
            // type differs between the two. Read it through getValueAs so both representations
        io.substrait.proto.Rel inputRel = io.substrait.proto.Rel.newBuilder().setRead(readRel).build();
     * Casts a list/values element to VARCHAR matching the SQL plugin's {@code String.valueOf}
        }
            return call.isDistinct();
        SqlKind.OTHER_FUNCTION,
                        + append
        AggregateFunctionConverter aggConverter = new AggregateFunctionConverter(
        FunctionMappings.s(LOCAL_TAKE_OP, "take"),
    /** Wrapper's output column names from its Calcite row type. */
                    "Malformed multi-value expand payload: fieldIndex="
        // is satisfied because the sort key IS the argument expression).
package org.opensearch.be.datafusion;
    /** Decodes serialized Substrait bytes into a model-level {@link Plan}, including this backend's own extension rels. */
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_MAKEDATE_OP, "makedate"),
            true,
                    return rexBuilder.makeLiteral(scaled, doubleType);
        return convertToSubstrait(rewritten);
        null,
            String name,
        Optionality.FORBIDDEN
/*
            }
    }
     * each branch refers to its own child stage id and the isthmus visitor emits one
        null,
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_OS_YEARWEEK_OP, "os_yearweek"),
                Rel rewiredLower = replaceInput(lower, newInput);
        @Override
            typeFactory,
        FunctionMappings.s(ArrayElementAdapter.LOCAL_MAP_EXTRACT_OP, "map_extract"),
import io.substrait.plan.Plan;
            List<Type> inputFields = input.getRecordType().fields();
                    Integer offset = simpleStructOffset(fr);
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, "from_unixtime"),
        OperandTypes.ANY,
                );
import org.opensearch.be.datafusion.planner.adapter.NumericConversionFunctionAdapter;
        }
    ) {
        public Optional<RexNode> rewriteDataArg(int argIndex, RexNode argRef, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        FunctionMappings.s(TimeConversionFunctionAdapter.CTIME, "ctime"),
     */
        }
import io.substrait.isthmus.expression.WindowFunctionConverter;
        );
        List<Aggregate.Measure> newMeasures = new ArrayList<>(agg.getMeasures().size());
        FunctionMappings.s(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, "approx_distinct"),
            .toList();
            return List.of();
    /** BRAIN window stub for {@code patterns ... method=BRAIN mode=label}. */
    }
        return serializePlan(SubstraitPlanPojoRewriter.rewrite(rewire(inner, wrapper, fieldNames(fragment))));
    }
     * opts in (DataFusion's substrait consumer can't take the function's own {@code ignore_nulls}).
            return Project.builder().from(project).input(newInput).build();
        false,
        SimpleExtension.ScalarFunctionVariant variant = extensions.scalarFunctions()
            return true;
     *   Plan { relations: [PlanRel { Root { input: Rel { Read { named_table: "input-&lt;id&gt;";
            return new StageInputTableScan(scan.getCluster(), scan.getTraitSet(), scan.getNamedInputId(), scan.getRowType());
        }
        for (Aggregate.Measure m : agg.getMeasures()) {
import io.substrait.type.proto.TypeProtoConverter;
            if (spec.append()) {
        boolean changed = false;
        FunctionMappings.s(StrftimeFunctionAdapter.STRFTIME, "strftime"),
import org.apache.calcite.rel.type.RelDataTypeField;
        return bytes;
        FunctionMappings.s(SqlStdOperatorTable.CHAR_LENGTH, "length"),
import org.apache.calcite.sql.SqlFunctionCategory;
import io.substrait.extension.ExtensionCollector;
    );
        false,
        SqlKind.OTHER_FUNCTION,
    /** Serializes a model-level {@link Plan} to proto bytes. */
        null,
        NamedStruct ns = TypeConverter.DEFAULT.toNamedStruct(rowType);
        OperandTypes.VARIADIC,
    /** Converts a single operator into a Substrait {@link Rel}; children are discarded and rewired by {@link #rewire}. */
    }
import org.apache.calcite.plan.RelTraitSet;
            // Substrait validators throw AssertionError directly (not via `assert`), so -da
        static MultiValueExpandDetail fromProto(Any any) {
        FunctionMappings.s(DelegationPossibleFunction.FUNCTION, DelegationPossibleFunction.NAME),
     * Rewrites every {@link OpenSearchStageInputScan} or {@link OpenSearchBroadcastScan} in
import io.substrait.type.Type;
        }
                    return super.visit(correlate);
import com.google.protobuf.Any;
            // Skip array operands (partial→final merge path) and already-VARCHAR operands.
            return false;
        ReturnTypes.ARG0,
        }
    private Aggregate addNullArgFilters(org.apache.calcite.rel.core.Aggregate calcite, Aggregate agg) {
            if (project.getInput() instanceof Project lower && containsWindowFunction(lower)) {
import io.substrait.isthmus.ConverterProvider;
        FunctionMappings.s(SqlLibraryOperators.CRC32, "crc32"),
        }
import io.substrait.relation.Aggregate;
            typeFactory,
                // argument — generic dispatch; the cast semantics live on the LocalAggOp, not here.
     * Lets a {@link LocalAggOp} rewrite its data args on the bound Substrait invocation (e.g. a
        FunctionMappings.s(WidthBucketAdapter.LOCAL_WIDTH_BUCKET_OP, "width_bucket"),
    };
        RelNode rewritten = rewriteStageInputScans(fragment);
            // list/values drop null elements per the PPL contract.
 * SPDX-License-Identifier: Apache-2.0
                continue;
        if (rewritten == null && !addedSort) {
                    if (!(arg instanceof io.substrait.expression.FieldReference fr)) continue;
        false,
                );
public class DataFusionFragmentConvertor implements FragmentConvertor {
    ) {
        if (!(seg instanceof io.substrait.expression.FieldReference.StructField sf)) return null;
    public byte[] convertFragment(RelNode fragment) {
        }
            int distinct = payload.getInt();
                    .direction(Expression.SortDirection.ASC_NULLS_LAST)
        FunctionMappings.s(SqlLibraryOperators.ILIKE, "ilike"),
        }
        "list_merge_distinct",
    private static byte[] serializePlan(Plan plan) {
        Optionality.FORBIDDEN
    /**
        }
            if (fieldIndex < 0 || limit < -1 || (append != 0 && append != 1) || (distinct != 0 && distinct != 1)) {
        SqlKind.OTHER_FUNCTION,
                false,
        FunctionMappings.s(ArrayToStringAdapter.LOCAL_ARRAY_TO_STRING_OP, "array_to_string"),
import com.google.common.collect.ImmutableList;
     * empty when the op is not a {@code LocalAggOp} or leaves every arg unchanged.
        false,
        null,
                return rel instanceof Aggregate agg ? addNullArgFilters(aggregate, agg) : rel;
                    );
            rewritten.set(i, rexConverter.apply(replacement.get()));
    static final class StageInputRelOptTable implements RelOptTable {
        ReturnTypes.ARG0,
        FunctionMappings.s(SpanBucketAdapter.LOCAL_SPAN_BUCKET_OP, "span_bucket"),
     * the RelNode tree to a plain Calcite {@link TableScan} whose qualified name matches what
            payload.putInt(spec.append() ? 1 : 0);
        ConverterProvider converterProvider = new ConverterProvider(
            SqlKind kind,
            int append = payload.getInt();
            // append mode it is added after the input columns, otherwise it replaces the LIST column.
        @Override
    }
        ReturnTypes.TO_ARRAY.andThen(SqlTypeTransforms.FORCE_NULLABLE),
        if (arg.getType() instanceof org.opensearch.analytics.schema.BinaryType) {
                return Optional.of(ImmutableAggregateFunctionInvocation.builder().from(fn).arguments(rewritten).build());
        public RelNode toRel(ToRelContext context) {
            @Override
            throw new IllegalStateException("Substrait conversion rejected the plan: " + e.getMessage(), e);
import org.apache.calcite.rel.core.AggregateCall;
        Rel rewired = replaceInput(wrapper, innerRel);
                    MultiValueExpandSpec spec = new MultiValueExpandSpec(
    /** Column offset for a simple input-rooted single-segment {@code StructField}, else null. */
import io.substrait.expression.AggregateFunctionInvocation;
        }
        /**
        } catch (InvalidProtocolBufferException e) {
    // ── Plan serde helpers ──────────────────────────────────────────────────────
            ADDITIONAL_AGGREGATE_SIGS,
                // bd == null only for a SQL-NULL percent (getValueAs returns null for NULL value) —
    public byte[] convertSchemaOnlyRead(int childStageId, RelDataType rowType) {
            .addArguments(arg)
        @Override
            // doesn't gate them; convert to a normal exception so we don't crash the cluster.
    /** FINAL-side merge for VALUES — re-deduplicates after concatenation. */
     * "Field reference offset (N) must be less than number of fields in struct (0)" when a
            if (argIndex == 1 && SqlTypeName.NUMERIC_TYPES.contains(lit.getType().getSqlTypeName())) {
        FunctionMappings.s(LOCAL_LIST_MERGE_DISTINCT_OP, "list_merge_distinct"),
     * was decoded from serialized bytes, in which case the record type is derived from the input.
import io.substrait.isthmus.TypeConverter;
        return serializePlan(SubstraitPlanPojoRewriter.rewrite(rewired));
    );
                    .filter(sig -> sig.operator != SqlStdOperatorTable.APPROX_COUNT_DISTINCT)
            }
        byte[] bytes = protoPlan.toByteArray();
import io.substrait.relation.Rel;
    private static final Logger LOGGER = LogManager.getLogger(DataFusionFragmentConvertor.class);
    /** BRAIN aggregate stub; return type is supplied by {@link PplAggregateCallRewriter}. */
            payload.putInt(spec.fieldIndex());
import org.apache.calcite.rex.RexLiteral;
        TypeConverter typeConverter = TypeConverter.DEFAULT;
    static final SqlAggFunction LOCAL_LIST_MERGE_DISTINCT_OP = new SqlAggFunction(
        null,
        WindowFunctionConverter windowConverter = new WindowFunctionConverter(
        }
    private static RelNode preprocessForSubstrait(RelNode rel) {
            ByteBuffer payload = value.asReadOnlyByteBuffer();
        FunctionMappings.s(ArrayElementAdapter.LOCAL_ARRAY_ELEMENT_OP, "array_element"),
    static final SqlAggFunction LOCAL_MV_COLLECT_DISTINCT_OP = new SqlAggFunction(
        OperandTypes.ANY,
     * rendering: ip→{@code ip_to_string}, binary→{@code binary_to_base64}, else a plain CAST.
        OperandTypes.ANY,
     * PPL {@code percentile_approx(field, percentile)} → DataFusion's builtin
            if (rewritten == null) {
        ReturnTypes.ARG0,
                        ? MultiValueExpandDetail.fromProto(any)
            super(
        if (wrapper instanceof Project project) {
                    rewritten.set(i, rexConverter.apply(toConvert));
                rewritten = new ArrayList<>(fn.arguments());
        Optionality.FORBIDDEN
                        + fieldIndex
     *
            ByteBuffer payload = ByteBuffer.allocate(PAYLOAD_BYTES);
        SqlKind.OTHER_FUNCTION,
        public List<ImmutableBitSet> getKeys() {
        }
        }
    }
                @Override
     *
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, "opensearch_extract"),
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            sorts = List.of(
            .orElse(null);
        }
        Optionality.FORBIDDEN
            Expression filter = isNotNull(argExpr);
            return false;
    }
        public boolean filtersNullArgs(AggregateCall call) {
import org.apache.calcite.sql.fun.SqlLibraryOperators;
                        + " append="
         */
                    FunctionArg arg = args.get(i);
        OperandTypes.ANY,
            org.apache.calcite.sql.type.SqlOperandTypeChecker operandTypeChecker
                BigDecimal bd = lit.getValueAs(BigDecimal.class);
    public DataFusionFragmentConvertor(SimpleExtension.ExtensionCollection extensions) {
        FunctionMappings.s(SqlLibraryOperators.MD5, "md5"),
        false,
        ReturnTypes.VARCHAR_FORCE_NULLABLE,
     * {@link LocalAggOp#normaliseLiteralArg} at substrait emission.
    /**
        List<AggregateCall> calls = calcite.getAggCallList()
            return null;
    };
    };
        /** Whether {@code any} carries a multi-value expand payload this class can decode. */
                return true;
            }
import org.apache.calcite.rel.type.RelDataType;
        }
        public Type.Struct deriveRecordType(Rel input) {
        FunctionMappings.s(LOCAL_INTERNAL_PATTERN_WINDOW_OP, "internal_pattern"),
            return Optional.empty();
     * {@code substrait_consumer.rs} on the Rust side. The 16-byte payload carries
    private static final List<FunctionMappings.Sig> ADDITIONAL_WINDOW_SIGS = List.of(
         * the bound Substrait argument, so it rides the measure without a child Project that the
    // from accumulating every aggregate definition. Pure structural move (no behaviour change);
            }
                    .build()
        FunctionMappings.s(RexOffsetAdapter.LOCAL_REX_OFFSET_OP, "rex_offset"),
        }
    static final SqlAggFunction LOCAL_INTERNAL_PATTERN_WINDOW_OP = new SqlAggFunction(
                operandTypeChecker,
        FunctionMappings.s(NumericConversionFunctionAdapter.NUM, "num"),
        OperandTypes.VARIADIC,
            .build();
            return Any.newBuilder().setTypeUrl(TYPE_URL).setValue(ByteString.copyFrom(payload.array())).build();
     * {@code approx_percentile_cont(field, percentile)}. PPL's trailing field-type-flag
    private static Integer simpleStructOffset(io.substrait.expression.FieldReference fr) {
    private Expression isNotNull(Expression arg) {
            ) {
                new MultiValueExpandSpec(fieldIndex, limit < 0 ? null : limit, append == 1, distinct == 1, null)
        false,
    static final SqlAggFunction LOCAL_INTERNAL_PATTERN_OP = new SqlAggFunction(
        FunctionMappings.s(SignumFunction.FUNCTION, SignumFunction.NAME),
            return Aggregate.builder().from(agg).input(newInput).build();
        // as Substrait literals so two-stage UDAFs (e.g. TAKE's N) see the constant on the Final side.
        false,
import io.substrait.plan.PlanProtoConverter;
    private static final List<FunctionMappings.Sig> ADDITIONAL_SCALAR_SIGS = List.of(
            throw new UnsupportedOperationException("StageInputRelOptTable.toRel not supported");
            }
        FunctionMappings.s(JsonFunctionAdapters.JsonArrayLengthAdapter.LOCAL_JSON_ARRAY_LENGTH_OP, "json_array_length"),
    }
        FunctionMappings.s(DateTimeAdapters.LOCAL_DATE_OP, "to_date"),
    }
            // VALUES (isDistinct) returns lexicographically sorted distinct strings; LIST does not sort.
        "internal_pattern",
        @Override
                        ? localOp.normaliseLiteralArg(i, rexLit, rexBuilder, typeFactory)
            return Fetch.builder().from(fetch).input(rewiredInput).build();
            }
     * avoids unnecessary {@code SubstraitRelVisitor} setup and keeps the produced bytes
    public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {
        }
                RexBuilder rexBuilder = project.getCluster().getRexBuilder();
        null,
    private static final List<FunctionMappings.Sig> ADDITIONAL_AGGREGATE_SIGS = List.of(
        }
        SqlKind.OTHER_FUNCTION,
        FunctionMappings.s(SqlStdOperatorTable.PI, "pi"),
        Plan.Root substraitRoot = Plan.Root.builder().input(substraitRel).names(fieldNames).build();
        FunctionMappings.s(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, "convert_tz"),
                Optional<AggregateFunctionInvocation> rewrittenArgs = rewriteLocalAggDataArgs(input, call, bound.get(), rexConverter);
            .setRoot(io.substrait.proto.RelRoot.newBuilder().setInput(inputRel).addAllNames(rowType.getFieldNames()).build())
                // not a valid percentile and never produced by the percNN/pNN suffix or an explicit
import org.apache.calcite.sql.type.SqlTypeName;
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        /**
     * {@code fieldIndex, limit, append, distinct} as big-endian i32s; the output schema is not on
     * rewriters are added.
        ) {
            }
        FunctionMappings.s(DateTimeAdapters.LOCAL_NOW_OP, "now"),
        @Override
                protected Extension.SingleRelDetail detailFromExtensionSingleRel(Any any) {
            return new MultiValueExpandDetail(
        }
        RelNode right = correlate.getRight();
        ReturnTypes.ARG0,
        FunctionMappings.s(LOCAL_INTERNAL_PATTERN_OP, "internal_pattern"),
            newMeasures.add(Aggregate.Measure.builder().from(m).function(rephased).build());
        static boolean matches(Any any) {
                    return rewrittenArgs;
    private static MultiValueExpandSpec explicitMultiValueExpand(Correlate correlate, TypeConverter typeConverter) {
        }
     * {@code NamedScan} per branch. For M1 broadcast, the probe fragment carries one
            rewritten.set(i, Aggregate.Measure.builder().from(m).preMeasureFilter(filter).build());
        return preprocessed;
        @SuppressWarnings("rawtypes")
    }
            windowConverter,
        return rewritten == null ? agg : Aggregate.builder().from(agg).measures(rewritten).build();
         * Whether the aggregate's elements are emitted ascending-sorted by the (rewritten) data arg.
    }
            false,
        public boolean sortsArgAscending(AggregateCall call) {
     * {@code OpenSearchTableScan} and one {@link OpenSearchBroadcastScan} — the latter
    };
                        + limit
            @Override
        LOGGER.debug("Attaching generic fragment [{}] on top of {} inner bytes", fragment.getClass().getSimpleName(), innerBytes.length);
    }
            RelDataType srcType = input.getRowType().getFieldList().get(call.getArgList().get(i)).getType();
        FunctionMappings.s(SqlStdOperatorTable.COT, "cot"),
            }
import org.apache.calcite.sql.SqlAggFunction;
        if (wrapper instanceof Sort sort) {
            limit,
     * Exact distinct count for use in a window context — replaces
        ReadRel readRel = ReadRel.newBuilder()
        @Override
        FunctionMappings.s(SqlLibraryOperators.LOG, "logb"),
        byte[] bytes = SubstraitPlanProtoRewriter.rewrite(io.substrait.proto.Plan.newBuilder().addRelations(planRel).build()).toByteArray();
            throw new IllegalArgumentException("Failed to decode Substrait plan bytes", e);
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_OS_WEEK_OP, "os_week"),
import io.substrait.extension.SimpleExtension;
        // Sort the elements ascending by the (rewritten) first arg when the op asks for it — emitted
                        : rexLit;
     * substrait window consumer. Custom Rust UDAF in {@code rust/src/udaf/os_count_distinct.rs}.
        "mv_collect",
        // Filter isthmus's default APPROX_COUNT_DISTINCT binding so our `approx_distinct` entry wins.
        FunctionMappings.s(Sha2FunctionAdapter.DIGEST, "digest"),
     */
        FunctionMappings.s(Sha2FunctionAdapter.ENCODE, "encode"),
        }
        FunctionMappings.s(MvzipAdapter.LOCAL_MVZIP_OP, "mvzip"),
        return io.substrait.expression.ImmutableExpression.ScalarFunctionInvocation.builder()
    ) {
                List<FunctionArg> rewritten = null;
        }
     *       stream by {@link DatafusionReduceSink}, mirroring {@code AbstractDatafusionReduceSink.inputIdFor}.</li>
     * type-coercing CAST), keyed only on the generic hook — no per-function logic here. Returns
     * {@link ExtensionSingle} detail for the multi-value expand, mirrored by
        SubstraitRelVisitor visitor = createVisitor(preprocessed);
    /**
     * conventional {@code "input-0"} name; for multi-input shapes (Union, coord-centric Join)
        FunctionMappings.s(SqlStdOperatorTable.REPLACE, "replace"),
        return tf.createTypeWithNullability(tf.createArrayType(tf.createSqlType(SqlTypeName.VARCHAR), -1), true);
        }
        RelNode preprocessed = UntypedNullPreprocessor.rewrite(rel);
    }
            public Rel visit(Correlate correlate) {
    static final class MultiValueExpandDetail implements Extension.SingleRelDetail {
import org.apache.calcite.util.ImmutableBitSet;
        }
                return Project.builder().from(project).input(rewiredLower).build();
        FunctionMappings.s(LOCAL_MV_COLLECT_DISTINCT_OP, "mv_collect_distinct"),
        FunctionMappings.s(LOCAL_PATTERN_PARSER_GET_TOKENS_OP, "pattern_parser_get_tokens"),
        }
        FunctionMappings.s(RangeBucketAdapter.LOCAL_RANGE_BUCKET_OP, "range_bucket"),
    /** Forces {@code phase} on every measure of an Aggregate wrapper (isthmus hardcodes INITIAL_TO_RESULT). */
        FunctionMappings.s(MvfindAdapter.LOCAL_MVFIND_OP, "mvfind"),
        return visitor.apply(preprocessed);
            // the Sort so the shape becomes Fetch(Sort(newInput)): gather, sort globally, then limit.
        FunctionMappings.s(SqlLibraryOperators.REGEXP_LIKE, "regexp_like"),
                kind,
    ) {
        public boolean sortsArgAscending(AggregateCall call) {
            scalarConverter,
        return fragment.getRowType().getFieldList().stream().map(RelDataTypeField::getName).toList();
        if (changed) {
        io.substrait.expression.FieldReference.ReferenceSegment seg = fr.segments().get(0);
        @Override
import com.google.protobuf.ByteString;
                SqlFunctionCategory.USER_DEFINED_FUNCTION,
            protected ImmutableList<FunctionMappings.Sig> getSigs() {
        FunctionMappings.s(NumericConversionFunctionAdapter.DUR2SEC, "dur2sec"),
                }
     */
        null,
        if (wrapper instanceof Filter filter) {
        RelNode preprocessed = preprocessForSubstrait(fragment);
            Type source = inputFields.get(spec.fieldIndex());
import org.apache.calcite.rel.RelRoot;
        return node;
                return super.getSigs().stream()
                }
    /**
        public org.apache.calcite.linq4j.tree.Expression getExpression(Class clazz) {
import io.substrait.isthmus.SubstraitRelVisitor;
        io.substrait.proto.NamedStruct nsProto = ns.toProto(SCHEMA_ONLY_TYPE_PROTO_CONVERTER);
                continue;
    ) {
        FunctionMappings.s(LOCAL_MV_COLLECT_OP, "mv_collect"),
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        // Join(TableScan, BroadcastScan)) so isthmus sees a plain TableScan whose
import io.substrait.plan.ProtoPlanConverter;
        public RelDistribution getDistribution() {
                for (int i = 0; i < args.size(); i++) {
    /** PARTIAL-side LIST over a source multi-value field; flattens elements across documents. */
import org.apache.calcite.plan.RelOptCluster;
        false,
                return spec.outputType();
            org.apache.calcite.sql.type.SqlReturnTypeInference returnTypeInference,
    /**
                || !(m.getFunction().arguments().get(0) instanceof Expression argExpr)) {
            .outputType(io.substrait.type.TypeCreator.REQUIRED.BOOLEAN)
     * so it never accumulates per-call state. Avoids re-allocating both objects on every
                List<FunctionArg> args = fn.arguments();
        LOGGER.debug("Substrait plan: {} bytes", bytes.length);
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
        FunctionMappings.s(SqlLibraryOperators.ARRAY_LENGTH, "array_length"),
            .filter(f -> "is_not_null".equals(f.name()))
        preprocessed = CastToVarcharRewriter.rewrite(preprocessed);
        Optionality.FORBIDDEN
                rewritten = new ArrayList<>(measures);
        return sf.offset();
        OperandTypes.VARIADIC,
                        + " limit="
        ReturnTypes.ARG0,
        FunctionMappings.s(SqlLibraryOperators.DATE_PART, "date_part"),
        RelNode preprocessed = preprocessForSubstrait(operator);
        return new MultiValueExpandSpec(
        this.extensions = extensions;
        Plan inner = decodePlan(innerBytes);
            }
        null,
        if (node instanceof OpenSearchStageInputScan scan) {
        public <C> C unwrap(Class<C> aClass) {
        ReturnTypes.BIGINT,
import com.google.protobuf.InvalidProtocolBufferException;
        SqlKind.OTHER_FUNCTION,
            }
                MultiValueExpandSpec spec = explicitMultiValueExpand(correlate, typeConverter);
        return Aggregate.builder().from(agg).measures(newMeasures).build();
import org.apache.calcite.sql.type.OperandTypes;
            substraitRel = visitor.apply(root.rel);
    };
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        FunctionMappings.s(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, "to_unixtime"),
            .stream()
import org.apache.calcite.sql.SqlFunction;
        SqlKind.OTHER_FUNCTION,
            int fieldIndex = payload.getInt();
        null,
        Plan plan = Plan.builder().addRoots(substraitRoot).build();
        RelNode input,
        ReturnTypes.VARCHAR_FORCE_NULLABLE,
        FunctionMappings.s(MakeArrayAdapter.LOCAL_MAKE_ARRAY_OP, "make_array"),
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_DATE_FORMAT_OP, "date_format"),
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
            List<Type> outputFields = new ArrayList<>(inputFields);
            ADDITIONAL_SCALAR_SIGS,
     * planner layer. Moving them up would let other backends reuse them and keep backend fragment
    private static List<String> fieldNames(RelNode fragment) {
        @Override
import io.substrait.relation.Fetch;
                Type.Struct inputType,
        public List<ColumnStrategy> getColumnStrategies() {
            public Rel visitOther(RelNode other) {
        );
        }
import org.apache.calcite.sql.type.SqlTypeTransforms;
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_TIME_FORMAT_OP, "time_format"),
        if (inner.getRoots().isEmpty()) {
                throw new IllegalArgumentException(
import org.apache.calcite.plan.RelOptSchema;
        );
    ) {
     * {@code list}/{@code values} contract.
        try {
        FunctionMappings.s(ToNumberFunctionAdapter.TONUMBER, "tonumber"),
import org.apache.calcite.rel.RelNode;
    }, OperandTypes.ANY) {
        throw new UnsupportedOperationException(
    ) {
            @Override
            return Optional.of(castToVarchar(argRef, rexBuilder, typeFactory));
            return rowType;
            // The percentile literal arrives as INTEGER for the standard form percentile(x, 50)
        // emits a ReadRel with the stage-input-id as the named table. Also rewrites
                false,
            "Cannot attach-on-top a Substrait Rel of type " + wrapper.getClass().getSimpleName() + " — no single-input rewire defined"
import io.substrait.expression.Expression;
     * visitor layer, or whether the ones that only manipulate Calcite {@link RelNode}s (and don't
        // as the invocation's sort, which DataFusion's array_agg honours (its DISTINCT+ORDER BY rule
     */
    static final SqlAggFunction LOCAL_MV_COLLECT_OP = new SqlAggFunction(
        FunctionMappings.s(LOCAL_ARRAY_AGG_OP, "array_agg"),
        return Plan.builder().addRoots(Plan.Root.builder().input(rewired).names(wrapperNames).build()).build();
        public List<RelReferentialConstraint> getReferentialConstraints() {
        null,
            typeConverter
            // expanded column is the LIST's element type, nullable (unnest preserves nulls); in
        };
                throw new IllegalArgumentException(
            }
     * Adds an {@code is_not_null} {@code preMeasureFilter} to each measure whose {@link LocalAggOp}
        }
/** Converts Calcite RelNode fragments to Substrait protobuf bytes for the DataFusion Rust runtime. */
         * Returns the expression to emit for the {@code argIndex}-th data arg in place of a bare
                    BigDecimal scaled = bd.divide(BigDecimal.valueOf(100), MathContext.DECIMAL64);
        }
        @Override
        FunctionMappings.s(SqlStdOperatorTable.TRUNCATE, "trunc"),
            Aggregate.Measure m = measures.get(i);
        Optionality.FORBIDDEN
        null,
        FunctionMappings.s(LOCAL_OS_COUNT_DISTINCT_OP, "os_count_distinct")
        "internal_pattern",
        Optionality.FORBIDDEN
    private static Rel replaceInput(Rel wrapper, Rel newInput) {
                // numeric percentile() arg. Pass it through unchanged; DataFusion rejects a NULL
        if (!fr.inputExpression().isEmpty()) return null;
        StageInputRelOptTable(String stageInputId, RelDataType rowType) {
    static final SqlOperator LOCAL_PATTERN_PARSER_GET_PATTERN_OP = new SqlFunction(
            return agg; // shape we don't recognise — leave untouched
            return Type.Struct.builder().nullable(input.getRecordType().nullable()).addAllFields(outputFields).build();
    private static Rel withAggregationPhase(Rel rel, Expression.AggregationPhase phase) {
     * <p>For single-input fragments the sole stage id (typically 0) reproduces the
    private static final class OpenSearchProtoPlanConverter extends ProtoPlanConverter {
        }
import org.apache.calcite.rex.RexBuilder;
        RelDataTypeFactory typeFactory = input.getCluster().getTypeFactory();
        private static final int PAYLOAD_BYTES = 16;
        }
        SqlKind.OTHER_FUNCTION,
        RelDataTypeFactory tf = opBinding.getTypeFactory();
        public List<RelCollation> getCollationList() {
            if (rewritten != input) {
     * because schema-only Reads convert primitive Calcite types to primitive Substrait
     * record type when the spec is built from a {@link RelNode}; it is {@code null} when the spec
        try {
        io.substrait.proto.Plan protoPlan = SubstraitPlanProtoRewriter.rewrite(new PlanProtoConverter().toProto(plan));
        @Override
        FunctionMappings.s(SqlLibraryOperators.TO_CHAR, "to_char"),
     * the wire and is re-derived from the input on decode ({@link #deriveRecordType(Rel)}).
        FunctionMappings.s(SqlLibraryOperators.REGEXP_CONTAINS, "regex_match"),
        null,
            return new StageInputTableScan(scan.getCluster(), scan.getTraitSet(), "input-" + scan.getChildStageId(), scan.getRowType());
     * record type is an empty struct, so any field reference above it (e.g. the GROUP BY key of a
            return rel;
        }
            public Rel visit(org.apache.calcite.rel.core.Aggregate aggregate) {
        FunctionMappings.s(DateTimeAdapters.LOCAL_TIME_OP, "to_time"),
    static final SqlAggFunction LOCAL_LIST_MERGE_OP = new SqlAggFunction(
     * subclassing here next to the op's declaration.
    @Override
        FunctionMappings.s(AggregateFunction.REDUCE_EVAL_OP, "reduce_eval"),
         * field reference (e.g. a type-coercing CAST), or empty to keep the reference. Applied on
        FunctionMappings.s(LOCAL_PATTERN_PARSER_GET_PATTERN_OP, "pattern_parser_get_pattern"),
            return this;
        }
         * reduce-stage stitch ({@link #replaceInput}) would drop. Identity by default.
            return RelDistributions.ANY;
import io.substrait.type.NamedStruct;
        @Override
import java.util.Optional;
                Optionality.FORBIDDEN
    };
            // and let the unscaled 50.0 reach DataFusion ("must be between 0.0 and 1.0").
                        true,
                returnTypeInference,
                    .collect(ImmutableList.toImmutableList());
                    RelDataType doubleType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
                    return MultiValueExpandDetail.matches(any)
        List<Aggregate.Measure> measures = agg.getMeasures();
            .setNamedTable(ReadRel.NamedTable.newBuilder().addNames("input-" + childStageId).build())
            return Optional.empty();
import org.apache.calcite.plan.RelOptTable;
        FunctionMappings.s(NumericConversionFunctionAdapter.RMCOMMA, "rmcomma"),
    }
        FunctionMappings.s(SpanAdapter.LOCAL_DATE_BIN_OP, "date_bin"),
        RelRoot root = RelRoot.of(preprocessed, SqlKind.SELECT);
                    if (offset == null || offset < 0 || offset >= projects.size()) continue;
        FunctionMappings.s(LOCAL_PERCENTILE_APPROX_OP, "approx_percentile_cont"),
        FunctionMappings.s(SqlLibraryOperators.CONCAT_FUNCTION, "concat"),
    private static RexNode castToVarchar(RexNode arg, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
     * depend on DataFusion/Substrait-specific classes) can be lifted up into the analytics-engine
    private static boolean containsWindowFunction(Project project) {
            @Override
        FunctionMappings.s(LOCAL_LAST_OP, "last_value"),
     * schema. This stub is the minimum proto that satisfies that path. Bypassing isthmus
        preprocessed = PplAggregateCallRewriter.rewrite(preprocessed);
            protected ImmutableList<FunctionMappings.Sig> getSigs() {
    // TODO: extract these LOCAL_*_OP aggregate stubs (+ LocalAggOp and ADDITIONAL_AGGREGATE_SIGS)
        RexBuilder rexBuilder = input.getCluster().getRexBuilder();
            return rexBuilder.makeCall(varcharNullable, IpBinaryCastFunctionAdapter.IP_TO_STRING_OP, List.of(arg));
                if (!(input instanceof org.apache.calcite.rel.core.Project project)) {
    );
import java.math.BigDecimal;
import org.apache.calcite.schema.ColumnStrategy;
        FunctionMappings.s(PositionAdapter.STRPOS, "strpos"),
            }
        null,
        }
        @Override
    @Override
                    "multi-value expand field index " + spec.fieldIndex() + " is outside " + inputFields.size() + " input columns"
            );
    static final SqlAggFunction LOCAL_OS_COUNT_DISTINCT_OP = new SqlAggFunction(
    };
     *       {@code MemTable} by {@code BroadcastInjectionHandler} before plan execution.</li>
            @Override
            return node.copy(node.getTraitSet(), newInputs);
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_STR_TO_DATE_OP, "str_to_date"),
import io.substrait.relation.Project;
            }
            if (spec.fieldIndex() >= inputFields.size()) {
            extensions,
                    return ExtensionSingle.from(new MultiValueExpandDetail(spec), apply(expand.getInput())).build();
        );
        if (!(call.getAggregation() instanceof LocalAggOp op)) {
    static final LocalAggOp LOCAL_PERCENTILE_APPROX_OP = new LocalAggOp(
        }
    };
        Plan.Root innerRoot = inner.getRoots().get(0);
            } else {
import java.math.MathContext;
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    /**
                List<RexNode> projects = project.getProjects();
        public Any toProto(io.substrait.relation.RelProtoConverter converter) {
        return Optional.of(ImmutableAggregateFunctionInvocation.builder().from(fn).arguments(args).sort(sorts).build());
    }
        FunctionMappings.s(SqlLibraryOperators.TRANSLATE3, "translate"),
        Optionality.FORBIDDEN
     * {@code convert()} override only invokes {@link #normaliseLiteralArg} when the call's
            return Filter.builder().from(filter).input(newInput).build();
    };
        FunctionMappings.s(SqlLibraryOperators.REGEXP_REPLACE_3, "regexp_replace"),
     * </ul>
    }
    }
    static final SqlOperator LOCAL_PATTERN_PARSER_GET_TOKENS_OP = new SqlFunction(
    );
        FunctionMappings.s(NumericConversionFunctionAdapter.MSTIME, "mstime"),
            payload.putInt(spec.limit() == null ? -1 : spec.limit());
                if (bd != null) {
        // isthmus visitor (which only knows about Calcite core / Logical RelNodes)
        FunctionMappings.s(DelegatedPredicateFunction.FUNCTION, DelegatedPredicateFunction.NAME),
        Integer limit = null;
        false,
            return null;
            // directly would drop the Sort and lose global order before the limit. Descend into
                Rel rel = super.visit(aggregate);
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        false,
    private final SimpleExtension.ExtensionCollection extensions;
        FunctionMappings.s(LOCAL_LIST_MERGE_OP, "list_merge"),
        null,
        // Mirror ADDITIONAL_AGGREGATE_SIGS: rename APPROX_COUNT_DISTINCT to DataFusion's `approx_distinct`.
        FunctionMappings.s(SqlLibraryOperators.REGEXP_REPLACE_3, "regexp_replace"),
     *   <li>{@code "input-<childStageId>"} for stage-input scans — registered as a partition
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
                    return bound;
        RelDataTypeFactory typeFactory = relNode.getCluster().getTypeFactory();
            if (spec.outputType() != null) {
import org.apache.calcite.rex.RexNode;
                );
     * <pre>
        null,
            .build();
        FunctionMappings.s(JsonFunctionAdapters.JsonAdapter.LOCAL_JSON_OP, "json"),
        }
        null,
            fieldNames(partialAggFragment)
        StageInputTableScan(RelOptCluster cluster, RelTraitSet traitSet, String stageInputId, RelDataType rowType) {
            return List.of();
        "take",
        @Override
            return lit;
                    .collect(ImmutableList.toImmutableList());
        false,
        PlanRel planRel = PlanRel.newBuilder()
     * protos — no functions or user-defined types touch the inner {@link ExtensionCollector},
        preprocessed = CastTemporalLiteralValidator.rewrite(preprocessed);
                if (spec == null) {
        FunctionMappings.s(JsonFunctionAdapters.JsonExtractAdapter.LOCAL_JSON_EXTRACT_OP, "json_extract"),
        LOGGER.debug("Converting fragment [{}]", fragment.getClass().getSimpleName());
        null,
import org.apache.calcite.rel.core.Uncollect;
            return rexBuilder.makeCall(varcharNullable, IpBinaryCastFunctionAdapter.BINARY_TO_BASE64_OP, List.of(arg));
        SubstraitRelVisitor visitor = createVisitor(preprocessed);
        FunctionMappings.s(SqlLibraryOperators.ARRAY_DISTINCT, "array_distinct"),
     * {@code registerPartitionStream} which needs the partition's named-table id and base
                name,
        Optionality.FORBIDDEN
import org.apache.calcite.rel.core.TableScan;
    }
        OperandTypes.ANY,
        List<Expression.SortField> sorts = fn.sort();
    static Plan rewire(Plan inner, Rel wrapper, List<String> wrapperNames) {
        // The convert() override inlines literal-Project columns into the AggregateFunctionInvocation
        }
        FunctionMappings.s(SqlLibraryOperators.REGEXP_REPLACE_PG_4, "regexp_replace"),
            newInputs.add(rewritten);
                        + " distinct="
        Rel innerRel = innerRoot.getInput();
     */
import org.apache.calcite.rel.core.Correlate;
import io.substrait.relation.Sort;
     * {@link ProtoPlanConverter} that understands this backend's own {@link ExtensionSingle}
        // Same APPROX_COUNT_DISTINCT filter as aggConverter — let our `approx_distinct` entry win.
        }
                changed = true;
        protected io.substrait.relation.ProtoRelConverter getProtoRelConverter(io.substrait.extension.ExtensionLookup functionLookup) {
        }
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
    // ── Visitor wiring ──────────────────────────────────────────────────────────
    };
        preprocessed = ItemTypeRebuilder.rewrite(preprocessed);
                        + distinct
        for (int i = 0; i < call.getArgList().size(); i++) {
            return null;
        return false;
        private final RelDataType rowType;
            io.substrait.proto.Plan proto = io.substrait.proto.Plan.parseFrom(bytes);
        FunctionMappings.s(SqlLibraryOperators.SHA1, "sha1"),
    @Override
        if (right instanceof org.apache.calcite.rel.core.Sort sort) {
        FunctionMappings.s(NumericConversionFunctionAdapter.RMUNIT, "rmunit"),
        "first_value",
            withAggregationPhase(wrapper, Expression.AggregationPhase.INITIAL_TO_INTERMEDIATE),
     *   <li>{@code "broadcast-<buildStageId>"} for broadcast scans — registered as a
    abstract static class LocalAggOp extends SqlAggFunction {
            return Sort.builder().from(sort).input(newInput).build();
    };
     * Wire-level description of a multi-value expand. {@code outputType} is the Calcite-derived
        }
        FunctionMappings.s(JsonFunctionAdapters.JsonExtractAllAdapter.LOCAL_JSON_EXTRACT_ALL_OP, "json_extract_all"),
        ReturnTypes.ARG0,
import io.substrait.isthmus.expression.ScalarFunctionConverter;
        FunctionMappings.s(SqlLibraryOperators.ARRAY_SLICE, "array_slice"),
        Rel substraitRel;
import io.substrait.expression.ImmutableAggregateFunctionInvocation;
            );
        List<RelNode> newInputs = new ArrayList<>(node.getInputs().size());
    /**
        AggregateCall call,
    private Rel convertStandalone(RelNode operator) {
        FunctionMappings.s(SqlStdOperatorTable.ITEM, "item"),
     * literal is rescaled from PPL's [0, 100] to DataFusion's [0, 1] convention via
        SqlKind.OTHER_FUNCTION,
        preprocessed = MultiValueRelRewriter.rewrite(preprocessed);
    // updates the cross-file `DataFusionFragmentConvertor.LOCAL_*` references.
import org.apache.calcite.sql.type.ReturnTypes;
     * tightly scoped to the schema we care about.
            this.spec = spec;
                return ExtensionSingle.from(new MultiValueExpandDetail(spec), apply(correlate.getLeft())).build();
    /** Local stubs for PPL state-expanding aggregates; swapped in by {@link PplAggregateCallRewriter}. */
import org.opensearch.be.datafusion.planner.adapter.TimeConversionFunctionAdapter;
    );
    }
                outputFields.add(element);
        FunctionMappings.s(JsonFunctionAdapters.JsonArrayAdapter.LOCAL_JSON_ARRAY_OP, "json_array"),
    }
                    if (!(projects.get(offset) instanceof RexLiteral rexLit)) continue;
            return new OpenSearchProtoPlanConverter(extensions).from(proto);
        }
        if (fr.segments().size() != 1) return null;
        FunctionMappings.s(SqlLibraryOperators.CONCAT_WS, "concat_ws"),
        Rel wrapper = convertStandalone(partialAggFragment);
     * ({@link #convertStandalone}) must run the identical set of rewriters so a shape handled on
    }
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
            extensions.scalarFunctions(),
     */
                        true,
        false,
            addedSort = true;
            .build();
                continue;
import java.util.List;
        if (!(right instanceof Uncollect)) {
        false,
            // rescale uniformly; pattern-matching get() on BigDecimal missed the DOUBLE shortcut
        FunctionMappings.s(RexExtractAdapter.LOCAL_REX_EXTRACT_OP, "rex_extract"),
        null,
        /** Inverse of {@link #toProto}; the record type is derived lazily from the input. */
     * conversion mostly a shape-to-Substrait translation.
        // qualified name is "broadcast-<buildStageId>". No-op when the fragment has
     * Measures line up with the Calcite agg calls minus any {@code GROUP_ID()} (which isthmus drops).
        /** Identity by default; override to transform the {@code argIndex}-th inlined literal arg. */
     * operator is a {@code LocalAggOp}, so adding a new normalisation is purely a matter of
                AggregateCall call,
import org.apache.calcite.util.Optionality;
    /**
            if (replacement.isEmpty()) {
import org.apache.calcite.sql.SqlOperator;
        return new SubstraitRelVisitor(converterProvider) {
        @Override
            .findFirst()
        public boolean isKey(ImmutableBitSet columns) {
        false,
        @Override
import io.substrait.isthmus.expression.FunctionMappings;
                return super.visitOther(other);
            .setBaseSchema(nsProto)
        List<FunctionArg> args = rewritten != null ? rewritten : fn.arguments();
        FunctionMappings.s(MvappendAdapter.LOCAL_MVAPPEND_OP, "mvappend"),
            return any != null && TYPE_URL.equals(any.getTypeUrl());
        "approx_percentile_cont",
    private static final TypeProtoConverter SCHEMA_ONLY_TYPE_PROTO_CONVERTER = new TypeProtoConverter(new ExtensionCollector());
                    "Malformed multi-value expand payload: expected " + PAYLOAD_BYTES + " bytes, got " + value.size()
                }
            typeConverter
     * Builds a schema-only stub plan directly via Substrait protos — no isthmus, no
        for (int i = 0; i < measures.size(); i++) {
        FunctionMappings.s(JsonFunctionAdapters.JsonAppendAdapter.LOCAL_JSON_APPEND_OP, "json_append"),
        FunctionMappings.s(NumericConversionFunctionAdapter.AUTO, "auto"),
     * Inferred return type is {@code ARRAY<VARCHAR>}.
        if (wrapper instanceof Fetch fetch) {
     */
import io.substrait.proto.ReadRel;
        FunctionMappings.s(JsonFunctionAdapters.JsonObjectAdapter.LOCAL_JSON_OBJECT_OP, "json_object"),
        FunctionMappings.s(LOCAL_OS_COUNT_DISTINCT_OP, "os_count_distinct")
import java.util.ArrayList;
        FunctionMappings.s(IpBinaryCastFunctionAdapter.IP_TO_STRING_OP, "ip_to_string"),
import org.opensearch.analytics.spi.DelegationPossibleFunction;
    }
            }
            return null;
        null,
    /** Builds {@code is_not_null(arg)} from the merged extension catalog, or null if the variant is absent. */
                    .filter(sig -> sig.operator != SqlStdOperatorTable.APPROX_COUNT_DISTINCT)
                }
        null,
        public RexNode normaliseLiteralArg(int argIndex, RexLiteral lit, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        public List<String> getQualifiedName() {
            }
import org.apache.logging.log4j.LogManager;
                if (rewritten == null) return bound;
        public RelDataType getRowType() {
                RelNode input,
        FunctionMappings.s(JsonFunctionAdapters.JsonKeysAdapter.LOCAL_JSON_KEYS_OP, "json_keys"),
        preprocessed = PplWindowCallRewriter.rewrite(preprocessed);
            }
import java.util.function.Function;
        "list_merge",
    private byte[] convertToSubstrait(RelNode fragment) {
            // but DOUBLE for the percNN/pNN shortcut (perc50 → 50.0E0), and getValue()'s backing
     *
     *                                                          base_schema: rowType } },
    }
            if (!(sort.fetch instanceof RexLiteral literal)) {
    public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
    // ── Calcite TableScan wrappers for OpenSearchStageInputScan rewrite ─────────
     * shard-stage plan is decoded on the coordinator to splice the reduce fragment on top.
        public boolean filtersNullArgs(AggregateCall call) {
        LOGGER.debug("Attaching partial aggregate on top of {} inner bytes", innerBytes.length);
        private final MultiValueExpandSpec spec;
        SqlKind.OTHER_FUNCTION,
        }
            int limit = payload.getInt();
            };
     *                                 names: rowType.fieldNames }}] }
                    return bound;
     * <p>Used by the LM stage path: LM runs Java-only scatter/gather/stitch and emits no
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP, "maketime"),
            // Lifted-window shape: outer Project references a window column from the lower Project.
            aggConverter,
     */
     * Shared {@link TypeProtoConverter} for schema-only conversions. Safe as a singleton
    /** FINAL-side merge for LIST; un-nests per-shard list states. */
        OpenSearchProtoPlanConverter(SimpleExtension.ExtensionCollection extensions) {
            payload.putInt(spec.distinct() ? 1 : 0);
        // Rewrite any OpenSearchStageInputScan leaves to plain TableScan nodes so the
            // A single Calcite LogicalSort carrying both a collation AND a fetch/offset lowers to
        return rexBuilder.makeCast(varcharNullable, arg);
            typeConverter
            if (value.size() != PAYLOAD_BYTES) {
    ) {
        FunctionMappings.s(DateTimeAdapters.LOCAL_DATE_TRUNC_OP, "date_trunc"),
                        : super.detailFromExtensionSingleRel(any);
        if (calls.size() != measures.size()) {
            ByteString value = any.getValue();
                return Optional.empty();
        }
        return bytes;
    private SubstraitRelVisitor createVisitor(RelNode relNode) {
    @Override
            return Optional.empty();
        public RelOptSchema getRelOptSchema() {
        @Override
    private static RelNode rewriteStageInputScans(RelNode node) {
     * PARTIAL aggregate over the expanded column) fails with
        FunctionMappings.s(JsonFunctionAdapters.JsonValidAdapter.LOCAL_JSON_VALID_OP, "json_valid"),
import org.apache.calcite.rel.RelCollation;
        return SubstraitPlanProtoRewriter.rewrite(new PlanProtoConverter().toProto(plan)).toByteArray();
        FunctionMappings.s(SqlStdOperatorTable.REPLACE, "replace"),
         * {@code is_not_null} preMeasureFilter (DataFusion's substrait consumer can't take the
                return null;
        FunctionMappings.s(SqlStdOperatorTable.CBRT, "cbrt"),
     */
                null,
        @Override
            return 100;
        if (node instanceof OpenSearchBroadcastScan scan) {
        FunctionMappings.s(GrokAdapter.LOCAL_GROK_OP, "grok"),
    /** Per-field accessors for {@code pattern_parser}'s STRUCT output; see {@link ItemTypeRebuilder}. */
        public RelOptTable extend(List<RelDataTypeField> extendedFields) {
        RelNode rewritten = rewriteStageInputScans(fragment);
    /**
        FunctionMappings.s(MinspanBucketAdapter.LOCAL_MINSPAN_BUCKET_OP, "minspan_bucket"),
            if (rewritten == null) {
        FunctionMappings.s(SqlLibraryOperators.DATE_TRUNC, "date_trunc"),
                        null,
        FunctionMappings.s(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, "approx_distinct"),
     * declares {@link LocalAggOp#filtersNullArgs} — so the converter stays generic and only the op
        Rel wrapper = convertStandalone(rewritten);
            if (m.getPreMeasureFilter().isPresent()
            RelNode rewritten = rewriteStageInputScans(input);
            }
            Rel rewiredInput = fetch.getInput() instanceof Sort ? replaceInput(fetch.getInput(), newInput) : newInput;
    /**
            return List.of();
     */
        false,
                throw new IllegalArgumentException("multi-value expand field " + spec.fieldIndex() + " is not a LIST: " + source);
        FunctionMappings.s(DateTimeAdapters.LOCAL_CURRENT_TIME_OP, "current_time"),
        SqlKind.OTHER_FUNCTION,
        FunctionMappings.s(ToStringFunctionAdapter.TOSTRING, "tostring"),
        "last_value",
            Optional<RexNode> replacement = op.rewriteDataArg(i, argRef, rexBuilder, typeFactory);
                }
import org.opensearch.analytics.spi.AggregateFunction;
        ScalarFunctionConverter scalarConverter = new ScalarFunctionConverter(
import org.apache.logging.log4j.Logger;
            if (!(source instanceof Type.ListType list)) {
        public double getRowCount() {
        null,
                        typeConverter.toNamedStruct(expand.getRowType()).struct()
            this.qualifiedName = List.of(stageInputId);
                }
        false,
        Plan inner = decodePlan(innerBytes);
        FunctionMappings.s(SqlLibraryOperators.ARRAY_LENGTH, "array_length"),
     * Local aggregate stub that may transform inlined literal args before substrait emission.
    private record MultiValueExpandSpec(int fieldIndex, Integer limit, boolean append, boolean distinct, Type.Struct outputType) {
            }
        "mv_collect_distinct",
    private Optional<AggregateFunctionInvocation> rewriteLocalAggDataArgs(
        );
    /**
        // Rewriter must run on the assembled plan so wrapper literals get rewritten alongside the inner.
            if (!(calls.get(i).getAggregation() instanceof LocalAggOp op) || !op.filtersNullArgs(calls.get(i))) {
            return List.of();
     * {@code cast(boolean AS Utf8)} yields lowercase {@code true}/{@code false}, per the PPL
import org.apache.calcite.sql.SqlKind;
        "pattern_parser_get_tokens",
        }
    }
         * Carried as the invocation's sort, which DataFusion's {@code array_agg} honours. False by default.
                }
        false,
    private Plan decodePlan(byte[] bytes) {
        if (wrapper instanceof Aggregate agg) {
        if (variant == null) {
        plan = SubstraitPlanPojoRewriter.rewrite(plan);
            .filter(c -> c.getAggregation() != SqlStdOperatorTable.GROUP_ID)
     */
                continue;
    }
        }
        // no rewritable leaves (e.g. plain shard-scan or Values cases).
import io.substrait.relation.ExtensionSingle;
        }
    /** Rewires {@code wrapper} above {@code inner}'s root; {@code wrapperNames} must match the wrapper's output schema. */
        null,
                AggregateFunctionInvocation fn = bound.get();
            inner,
import io.substrait.relation.Extension;
        if (fr.isOuterReference() || fr.isLambdaParameterReference()) return null;
                return super.getSigs().stream()
                outputFields.set(spec.fieldIndex(), element);
     * resolves to the broadcast memtable at execution time.
        FunctionMappings.s(IpBinaryCastFunctionAdapter.BINARY_TO_BASE64_OP, "binary_to_base64"),
                }
                    RexNode toConvert = call.getAggregation() instanceof LocalAggOp localOp
            right = sort.getInput();
        FunctionMappings.s(SqlLibraryOperators.REGEXP_CONTAINS, "regex_match"),
            limit = literal.getValueAs(Integer.class);
import io.substrait.proto.PlanRel;
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
            return qualifiedName;
        if (correlate.getJoinType() != org.apache.calcite.rel.core.JoinRelType.INNER || correlate.getRequiredColumns().cardinality() != 1) {
        OperandTypes.ANY_ANY
        @Override
            return null;
            correlate.getRequiredColumns().nextSetBit(0),
    }
        List<String> fieldNames = root.fields.stream().map(field -> field.getValue()).toList();
        FunctionMappings.s(LOCAL_FIRST_OP, "first_value"),
        false,
         */
    };
    }
    static final SqlAggFunction LOCAL_FIRST_OP = new SqlAggFunction(
        if (op.sortsArgAscending(call) && sorts.isEmpty() && !args.isEmpty() && args.get(0) instanceof Expression sortKey) {
    ) {
            RexNode argRef = rexBuilder.makeInputRef(srcType, call.getArgList().get(i));
        OperandTypes.ANY,
        }
        // FORCE_NULLABLE so AggregateCall.create accepts a nullable explicit return type.
        OperandTypes.ANY,
            typeFactory,
                || m.getFunction().arguments().isEmpty()
            @Override
                        expand.fieldIndex(),
     * one path is not missed on the other. Centralizing here keeps the two paths in lockstep as
            }
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        FunctionMappings.s(DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, "to_timestamp"),
        LocalAggOp(
     * the matching runtime component registers on the native session:
            return new io.substrait.relation.ProtoRelConverter(functionLookup, extensionCollection, protoExtensionConverter) {
            throw new IllegalArgumentException("Inner Substrait plan has no root relation to rewire under wrapper");
            return false;
        AggregateFunctionInvocation fn,
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        }
            // Fetch(Sort(input)) — two Substrait rels from one node. Rewiring the Fetch's input
import org.apache.calcite.rel.RelReferentialConstraint;
    ) {
        for (Expression expr : project.getExpressions()) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
     * Encoding DISTINCT in the operator name avoids the dropped-DISTINCT bug in DataFusion 54.x's
        SqlKind.OTHER_FUNCTION,
     */
            }
        }
        List<Aggregate.Measure> rewritten = null;
        FunctionMappings.s(SqlStdOperatorTable.RAND, "random"),
    static final SqlAggFunction LOCAL_ARRAY_AGG_OP = new LocalAggOp("array_agg", SqlKind.OTHER_FUNCTION, opBinding -> {
        };
        FunctionMappings.s(JsonFunctionAdapters.JsonExtendAdapter.LOCAL_JSON_EXTEND_OP, "json_extend"),
 * compatible open source license.
     * </pre>
            public Optional<AggregateFunctionInvocation> convert(
                Function<RexNode, Expression> rexConverter
     * Shared pre-Substrait rewrite pipeline. Both the top-level fragment path
        ReturnTypes.ARG0.andThen(SqlTypeTransforms.FORCE_NULLABLE),
        }
            );
            ADDITIONAL_WINDOW_SIGS,
            typeConverter
            }
                null,
                throw new IllegalArgumentException(
            typeConverter.toNamedStruct(correlate.getRowType()).struct()
import io.substrait.relation.Filter;
    /**
        } catch (AssertionError e) {
        OperandTypes.ANY_ANY,
import org.apache.calcite.rel.RelDistribution;
        FunctionMappings.s(ConvAdapter.LOCAL_CONV_OP, "conv")
         * function's own {@code ignore_nulls}). False by default.
     * cast to VARCHAR (lowercase booleans), drop nulls, and (VALUES only) lexicographic sort.
