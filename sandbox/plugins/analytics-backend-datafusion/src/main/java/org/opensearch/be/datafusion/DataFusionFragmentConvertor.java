 *
                throw new IllegalArgumentException("multi-value expand field " + spec.fieldIndex() + " is not a LIST: " + source);
        }
        }  
        private final List<String> qualifiedName;  
        OperandTypes.ANY,
        }
        SimpleExtension.ScalarFunctionVariant variant = extensions.scalarFunctions()  
        }
            List<Type> outputFields = new ArrayList<>(inputFields);
        for (int i = 0; i < call.getArgList().size(); i++) {  
        FunctionMappings.s(DateTimeAdapters.LOCAL_CURRENT_DATE_OP, "current_date"),
        };
        }
import io.substrait.relation.Extension;
import org.apache.calcite.schema.ColumnStrategy;
        OperandTypes.VARIADIC,
     * conventional {@code "input-0"} name; for multi-input shapes (Union, coord-centric Join)
        SqlKind.OTHER_FUNCTION,
            .stream()
        if (wrapper instanceof Filter filter) {
    // updates the cross-file `DataFusionFragmentConvertor.LOCAL_*` references.  
        OperandTypes.ANY,
import org.apache.calcite.rel.type.RelDataTypeField;  
        public boolean filtersNullArgs(AggregateCall call) {
     * declares {@link LocalAggOp#filtersNullArgs} — so the converter stays generic and only the op
                    .expr(sortKey)  
        boolean addedSort = false;
        AggregateFunctionInvocation fn,  
     * empty when the op is not a {@code LocalAggOp} or leaves every arg unchanged.
            }
            return call.isDistinct();  
        LOGGER.debug("Attaching partial aggregate on top of {} inner bytes", innerBytes.length);
        "pattern_parser_get_pattern",
        OperandTypes.ANY,
        FunctionMappings.s(TimeConversionFunctionAdapter.MKTIME, "mktime"),
        } catch (InvalidProtocolBufferException e) {
            // doesn't gate them; convert to a normal exception so we don't crash the cluster.  
        }
import org.apache.calcite.rel.core.TableScan;
    /** BRAIN window stub for {@code patterns ... method=BRAIN mode=label}. */
                RexBuilder rexBuilder = project.getCluster().getRexBuilder();
                    return super.visit(correlate);  
     * ({@link #convertStandalone}) must run the identical set of rewriters so a shape handled on  
            this.rowType = rowType;
            this.qualifiedName = List.of(stageInputId);
     * {@code fieldIndex, limit, append, distinct} as big-endian i32s; the output schema is not on
    };
     * so it never accumulates per-call state. Avoids re-allocating both objects on every
            RelNode rewritten = rewriteStageInputScans(input);
        preprocessed = PplWindowCallRewriter.rewrite(preprocessed);
    }  
        null,
                    .build()
            rewritten.set(i, rexConverter.apply(replacement.get()));
                rewritten = new ArrayList<>(measures);  
        return preprocessed;  
    }
    static final SqlAggFunction LOCAL_TAKE_OP = new SqlAggFunction(
            return any != null && TYPE_URL.equals(any.getTypeUrl());  
        }
    private Expression isNotNull(Expression arg) {
            payload.putInt(spec.distinct() ? 1 : 0);
import org.apache.logging.log4j.Logger;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     * "Field reference offset (N) must be less than number of fields in struct (0)" when a
        FunctionMappings.s(ArrayElementAdapter.LOCAL_MAP_EXTRACT_OP, "map_extract"),
import org.apache.calcite.sql.type.SqlTypeTransforms;  
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        null,  
         */
    }
            typeFactory,
        public boolean filtersNullArgs(AggregateCall call) {
        Function<RexNode, Expression> rexConverter
                throw new IllegalArgumentException("Not a multi-value expand extension: " + (any == null ? null : any.getTypeUrl()));  
            if (!matches(any)) {
        }  
            // list/values drop null elements per the PPL contract.
    /**  
        FunctionMappings.s(LOCAL_LIST_MERGE_DISTINCT_OP, "list_merge_distinct"),  
        return rewritten == null ? agg : Aggregate.builder().from(agg).measures(rewritten).build();
     *       stream by {@link DatafusionReduceSink}, mirroring {@code AbstractDatafusionReduceSink.inputIdFor}.</li>
        if (arg.getType() instanceof org.opensearch.analytics.schema.IpType) {
        }
    static final SqlAggFunction LOCAL_OS_COUNT_DISTINCT_OP = new SqlAggFunction(
                        : super.detailFromExtensionSingleRel(any);
        public Type.Struct deriveRecordType(Rel input) {
     * Calcite RelNode round-trip. Output:  
                        : rexLit;  
    public byte[] convertFragment(RelNode fragment) {
    private SubstraitRelVisitor createVisitor(RelNode relNode) {
            return null;  
            ADDITIONAL_WINDOW_SIGS,
        public <C> C unwrap(Class<C> aClass) {  
            AggregateFunctionInvocation rephased = AggregateFunctionInvocation.builder().from(fn).aggregationPhase(phase).build();
        public RexNode normaliseLiteralArg(int argIndex, RexLiteral lit, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {  
            if (spec.append()) {
        };
        FunctionMappings.s(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, "approx_distinct"),  
     * depend on DataFusion/Substrait-specific classes) can be lifted up into the analytics-engine  
            extensions.aggregateFunctions(),
        AggregateFunctionConverter aggConverter = new AggregateFunctionConverter(
        if (fr.isOuterReference() || fr.isLambdaParameterReference()) return null;
        @Override  
                }
     */  
    private static RelNode rewriteStageInputScans(RelNode node) {
    }
import io.substrait.proto.PlanRel;
        FunctionMappings.s(SqlStdOperatorTable.CBRT, "cbrt"),
import io.substrait.relation.Project;  
        }
        Optionality.FORBIDDEN  
import io.substrait.relation.Rel;
import org.apache.calcite.plan.RelOptCluster;
        RelDataTypeFactory tf = opBinding.getTypeFactory();  
                || !(m.getFunction().arguments().get(0) instanceof Expression argExpr)) {
        FunctionMappings.s(SqlStdOperatorTable.PI, "pi"),  
        ReturnTypes.ARG0,  
        Optionality.FORBIDDEN  
            .build();
import org.apache.calcite.rel.core.Uncollect;  
                return Optional.empty();
                null,
            ByteBuffer payload = value.asReadOnlyByteBuffer();
        FunctionMappings.s(IpBinaryCastFunctionAdapter.BINARY_TO_BASE64_OP, "binary_to_base64"),
    ) {  
        LOGGER.debug("Converting fragment [{}]", fragment.getClass().getSimpleName());  
            return new StageInputTableScan(scan.getCluster(), scan.getTraitSet(), "input-" + scan.getChildStageId(), scan.getRowType());  
                return null;  
            correlate.getRequiredColumns().nextSetBit(0),  
                    .direction(Expression.SortDirection.ASC_NULLS_LAST)
        }
        // as Substrait literals so two-stage UDAFs (e.g. TAKE's N) see the constant on the Final side.  
        }  
    static final class StageInputRelOptTable implements RelOptTable {
        null,
        FunctionMappings.s(JsonFunctionAdapters.JsonKeysAdapter.LOCAL_JSON_KEYS_OP, "json_keys"),  
        public RexNode normaliseLiteralArg(int argIndex, RexLiteral lit, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        }
                operandTypeChecker,
        OperandTypes.ANY,
        @SuppressWarnings("rawtypes")  
        return bytes;
            ByteString value = any.getValue();
        FunctionMappings.s(JsonFunctionAdapters.JsonAppendAdapter.LOCAL_JSON_APPEND_OP, "json_append"),
            substraitRel = visitor.apply(root.rel);  
        FunctionMappings.s(DateTimeAdapters.LOCAL_TIME_OP, "to_time"),
            return rexBuilder.makeCall(varcharNullable, IpBinaryCastFunctionAdapter.IP_TO_STRING_OP, List.of(arg));
        LOGGER.debug("Attaching generic fragment [{}] on top of {} inner bytes", fragment.getClass().getSimpleName(), innerBytes.length);
        RelRoot root = RelRoot.of(preprocessed, SqlKind.SELECT);
    // ── Plan serde helpers ──────────────────────────────────────────────────────
     */  
        OperandTypes.ANY,
     * operator is a {@code LocalAggOp}, so adding a new normalisation is purely a matter of
            }
import io.substrait.isthmus.TypeConverter;  
        return new MultiValueExpandSpec(
        OperandTypes.ANY_ANY,  
    static final SqlAggFunction LOCAL_MV_COLLECT_OP = new SqlAggFunction(
                );
        ReturnTypes.TO_ARRAY.andThen(SqlTypeTransforms.FORCE_NULLABLE),
import io.substrait.isthmus.expression.ScalarFunctionConverter;  
        }
            typeConverter
    }
        static final String TYPE_URL = "opensearch://analytics/multi_value_expand/v1";
    /** Per-field accessors for {@code pattern_parser}'s STRUCT output; see {@link ItemTypeRebuilder}. */  
            // but DOUBLE for the percNN/pNN shortcut (perc50 → 50.0E0), and getValue()'s backing
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
            }  
        if (right instanceof org.apache.calcite.rel.core.Sort sort) {
        // as the invocation's sort, which DataFusion's array_agg honours (its DISTINCT+ORDER BY rule
        "list_merge",  
        this.extensions = extensions;
                throw new IllegalArgumentException(
            .setNamedTable(ReadRel.NamedTable.newBuilder().addNames("input-" + childStageId).build())  
        }
        if (wrapper instanceof Project project) {
        if (!(rel instanceof Aggregate agg)) {
    /**
        return SubstraitPlanProtoRewriter.rewrite(new PlanProtoConverter().toProto(plan)).toByteArray();  
        SqlKind.OTHER_FUNCTION,
            ADDITIONAL_AGGREGATE_SIGS,  
import org.apache.calcite.rel.RelNode;  
            typeConverter.toNamedStruct(correlate.getRowType()).struct()
            payload.putInt(spec.append() ? 1 : 0);  
                    rewritten.set(i, rexConverter.apply(toConvert));
            if (argRef.getType().getComponentType() != null || argRef.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {  
    ) {
        Plan inner = decodePlan(innerBytes);
import io.substrait.type.proto.TypeProtoConverter;
        FunctionMappings.s(SqlStdOperatorTable.ITEM, "item"),
                    return MultiValueExpandDetail.matches(any)  
        FunctionMappings.s(SqlStdOperatorTable.REPLACE, "replace"),
     * <ul>
        false,
        static boolean matches(Any any) {
import org.apache.calcite.sql.type.OperandTypes;  
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, "from_unixtime"),  
        for (int i = 0; i < measures.size(); i++) {  
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_STR_TO_DATE_OP, "str_to_date"),
                    if (!(projects.get(offset) instanceof RexLiteral rexLit)) continue;
import java.math.BigDecimal;
import org.apache.calcite.sql.SqlKind;
import io.substrait.expression.ImmutableAggregateFunctionInvocation;
                if (!(input instanceof org.apache.calcite.rel.core.Project project)) {
        }
                    "Malformed multi-value expand payload: expected " + PAYLOAD_BYTES + " bytes, got " + value.size()
            return Optional.empty();
     * </ul>
     */  
     * Adds an {@code is_not_null} {@code preMeasureFilter} to each measure whose {@link LocalAggOp}  
        }
        public RelOptSchema getRelOptSchema() {  
            super(cluster, traitSet, List.of(), new StageInputRelOptTable(stageInputId, rowType));
        private final RelDataType rowType;
    static final class MultiValueExpandDetail implements Extension.SingleRelDetail {
        false,
        null,
     */
        // Join(TableScan, BroadcastScan)) so isthmus sees a plain TableScan whose
            return Aggregate.builder().from(agg).input(newInput).build();  
        false,
        if (!(right instanceof Uncollect)) {
    ) {
        LOGGER.debug("Substrait plan: {} bytes", bytes.length);
        // The convert() override inlines literal-Project columns into the AggregateFunctionInvocation
    }  
        FunctionMappings.s(LOCAL_INTERNAL_PATTERN_OP, "internal_pattern"),
        preprocessed = ItemTypeRebuilder.rewrite(preprocessed);  
     * Rewrites every {@link OpenSearchStageInputScan} or {@link OpenSearchBroadcastScan} in
        FunctionMappings.s(IpBinaryCastFunctionAdapter.IP_TO_STRING_OP, "ip_to_string"),
                    FunctionArg arg = args.get(i);
        return Plan.builder().addRoots(Plan.Root.builder().input(rewired).names(wrapperNames).build()).build();
            return 100;
        byte[] bytes = protoPlan.toByteArray();  
        // no rewritable leaves (e.g. plain shard-scan or Values cases).
        SqlKind.OTHER_FUNCTION,
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
            .build();
                // not a valid percentile and never produced by the percNN/pNN suffix or an explicit
        ) {
                if (rewrittenArgs.isPresent()) {
        }
import org.apache.calcite.rel.RelDistributions;
        if (rewritten == null && !addedSort) {  
        /**
        @Override  
        FunctionMappings.s(SqlLibraryOperators.REGEXP_LIKE, "regexp_like"),  
        /**  
        Optionality.FORBIDDEN  
            "Cannot attach-on-top a Substrait Rel of type " + wrapper.getClass().getSimpleName() + " — no single-input rewire defined"
        );  
            extensions.scalarFunctions(),
import org.apache.calcite.sql.type.SqlTypeName;
            if (spec.fieldIndex() >= inputFields.size()) {  
        public List<String> getQualifiedName() {  
            }  
            }
     *                                                          base_schema: rowType } },  
        null,
            return new MultiValueExpandDetail(
        io.substrait.expression.FieldReference.ReferenceSegment seg = fr.segments().get(0);
        false,  
                Optional<AggregateFunctionInvocation> rewrittenArgs = rewriteLocalAggDataArgs(input, call, bound.get(), rexConverter);  
    }
        FunctionMappings.s(Sha2FunctionAdapter.ENCODE, "encode"),
        return bytes;
     */
        }
        FunctionMappings.s(LOCAL_ARRAY_AGG_OP, "array_agg"),
            RelDataType srcType = input.getRowType().getFieldList().get(call.getArgList().get(i)).getType();
        null,  
        // is satisfied because the sort key IS the argument expression).  
            }  
        false,
    }
            true,
        FunctionMappings.s(NumericConversionFunctionAdapter.AUTO, "auto"),
        ReturnTypes.ARG0,  
        StageInputRelOptTable(String stageInputId, RelDataType rowType) {  
         * Carried as the invocation's sort, which DataFusion's {@code array_agg} honours. False by default.  
    }, OperandTypes.ANY) {
        null,
        // Fully-qualified names below: io.substrait.proto.{Plan,Rel,NamedStruct,RelRoot} clash with already-imported single-name imports.
     * Shared {@link TypeProtoConverter} for schema-only conversions. Safe as a singleton
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_MAKEDATE_OP, "makedate"),
            } else {
    private Plan decodePlan(byte[] bytes) {
import io.substrait.plan.ProtoPlanConverter;
        ReturnTypes.VARCHAR_FORCE_NULLABLE,  
        FunctionMappings.s(JsonFunctionAdapters.JsonValidAdapter.LOCAL_JSON_VALID_OP, "json_valid"),  
                    BigDecimal scaled = bd.divide(BigDecimal.valueOf(100), MathContext.DECIMAL64);  
        false,  
        null,  
        // Filter isthmus's default APPROX_COUNT_DISTINCT binding so our `approx_distinct` entry wins.
    };
            return List.of();
        FunctionMappings.s(JsonFunctionAdapters.JsonArrayLengthAdapter.LOCAL_JSON_ARRAY_LENGTH_OP, "json_array_length"),
        }
            return List.of();  
        FunctionMappings.s(JsonFunctionAdapters.JsonExtractAllAdapter.LOCAL_JSON_EXTRACT_ALL_OP, "json_extract_all"),
        @Override
import org.apache.calcite.plan.RelTraitSet;
     * arg is stripped by {@link PplAggregateCallRewriter} before binding; the percentile
            newMeasures.add(Aggregate.Measure.builder().from(m).function(rephased).build());
        preprocessed = CastTemporalLiteralValidator.rewrite(preprocessed);
        };
        return Aggregate.builder().from(agg).measures(newMeasures).build();
    private static Integer simpleStructOffset(io.substrait.expression.FieldReference fr) {
                throw new IllegalArgumentException(
import org.opensearch.analytics.spi.DelegationPossibleFunction;  
import org.apache.calcite.rex.RexBuilder;
        if (variant == null) {
        }
    private Rel convertStandalone(RelNode operator) {  
     * </pre>
        List<Expression.SortField> sorts = fn.sort();
            payload.putInt(spec.limit() == null ? -1 : spec.limit());
        List<FunctionArg> args = rewritten != null ? rewritten : fn.arguments();  
        RelNode right = correlate.getRight();
            // Decoded from the wire: rebuild the same shape substrait_consumer.rs produces. The
            int distinct = payload.getInt();  
    private static MultiValueExpandSpec explicitMultiValueExpand(Correlate correlate, TypeConverter typeConverter) {
        ConverterProvider converterProvider = new ConverterProvider(
            @Override  
            AggregateFunctionInvocation fn = m.getFunction();  
            // Skip array operands (partial→final merge path) and already-VARCHAR operands.
        Rel wrapper = convertStandalone(partialAggFragment);
    }
    static final SqlAggFunction LOCAL_MV_COLLECT_DISTINCT_OP = new SqlAggFunction(
        "os_count_distinct",
        FunctionMappings.s(DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, "to_timestamp"),  
         * Whether the aggregate's elements are emitted ascending-sorted by the (rewritten) data arg.
        try {
import io.substrait.type.Type;
        LocalAggOp(
     * details. The stock converter maps every unknown extension to an {@code EmptyDetail} whose
     * {@code list}/{@code values} contract.  
            }  
import org.apache.calcite.rel.type.RelDataTypeFactory;
            return null;
                Function<RexNode, Expression> rexConverter
    }
    ) {
                    .filter(sig -> sig.operator != SqlStdOperatorTable.APPROX_COUNT_DISTINCT)  
        Optionality.FORBIDDEN
        Integer limit = null;  
        }  
     * {@code cast(boolean AS Utf8)} yields lowercase {@code true}/{@code false}, per the PPL
import org.opensearch.be.datafusion.planner.adapter.NumericConversionFunctionAdapter;
     * rendering: ip→{@code ip_to_string}, binary→{@code binary_to_base64}, else a plain CAST.  
import io.substrait.expression.AggregateFunctionInvocation;
     * <p>Used by the LM stage path: LM runs Java-only scatter/gather/stitch and emits no
        @Override
        Plan.Root substraitRoot = Plan.Root.builder().input(substraitRel).names(fieldNames).build();  
        SqlKind.OTHER_FUNCTION,
import org.apache.logging.log4j.LogManager;  
     * {@code NamedScan} per branch. For M1 broadcast, the probe fragment carries one  
            if (fieldIndex < 0 || limit < -1 || (append != 0 && append != 1) || (distinct != 0 && distinct != 1)) {
        /** Identity by default; override to transform the {@code argIndex}-th inlined literal arg. */
        @Override
import io.substrait.isthmus.expression.FunctionMappings;
        @Override  
    /** Converts a single operator into a Substrait {@link Rel}; children are discarded and rewired by {@link #rewire}. */
                AggregateFunctionInvocation fn = bound.get();
        FunctionMappings.s(JsonFunctionAdapters.JsonObjectAdapter.LOCAL_JSON_OBJECT_OP, "json_object"),
 * The OpenSearch Contributors require contributions made to  
        return visitor.apply(preprocessed);  
            }
        FunctionMappings.s(LOCAL_PATTERN_PARSER_GET_PATTERN_OP, "pattern_parser_get_pattern"),  
        public boolean isKey(ImmutableBitSet columns) {
                );  
        if (!fr.inputExpression().isEmpty()) return null;  
    ) {
        false,
        }
        public Optional<RexNode> rewriteDataArg(int argIndex, RexNode argRef, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        }  
            super(extensions);
        Optionality.FORBIDDEN  
            }
    };
     *  
                return super.visitOther(other);
                continue;
        @Override
                        + limit  
                    .collect(ImmutableList.toImmutableList());
     * {@link ExtensionSingle} detail for the multi-value expand, mirrored by
            // rescale uniformly; pattern-matching get() on BigDecimal missed the DOUBLE shortcut
        public RelOptTable extend(List<RelDataTypeField> extendedFields) {  
 */  
        null,
            );  
import io.substrait.expression.Expression;
            // and let the unscaled 50.0 reach DataFusion ("must be between 0.0 and 1.0").
    };
        Rel substraitRel;
        preprocessed = CastToVarcharRewriter.rewrite(preprocessed);
            RexNode argRef = rexBuilder.makeInputRef(srcType, call.getArgList().get(i));
    static final SqlAggFunction LOCAL_FIRST_OP = new SqlAggFunction(
            org.apache.calcite.sql.type.SqlReturnTypeInference returnTypeInference,
            // type differs between the two. Read it through getValueAs so both representations  
        );
import io.substrait.isthmus.expression.AggregateFunctionConverter;
        io.substrait.proto.NamedStruct nsProto = ns.toProto(SCHEMA_ONLY_TYPE_PROTO_CONVERTER);  
            @Override
        // qualified name is "broadcast-<buildStageId>". No-op when the fragment has  
    abstract static class LocalAggOp extends SqlAggFunction {
                continue;
                }
/*  
        false,
            if (!(source instanceof Type.ListType list)) {  
        FunctionMappings.s(StrftimeFunctionAdapter.STRFTIME, "strftime"),  
        FunctionMappings.s(SqlStdOperatorTable.COT, "cot"),
     */
         * Returns the expression to emit for the {@code argIndex}-th data arg in place of a bare
        }
        @Override  
                        true,  
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_OS_WEEK_OP, "os_week"),  
     * Unlike the {@code cast}/{@code tostring} path this does NOT uppercase booleans — native
/** Converts Calcite RelNode fragments to Substrait protobuf bytes for the DataFusion Rust runtime. */
        FunctionMappings.s(ArrayToStringAdapter.LOCAL_ARRAY_TO_STRING_OP, "array_to_string"),
                        expand.fieldIndex(),  
        return serializePlan(SubstraitPlanPojoRewriter.rewrite(rewire(inner, wrapper, fieldNames(fragment))));  
     * the matching runtime component registers on the native session:
import org.opensearch.analytics.spi.AggregateFunction;
        FunctionMappings.s(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, "approx_distinct"),
import io.substrait.relation.Aggregate;
                    RexNode toConvert = call.getAggregation() instanceof LocalAggOp localOp
     *                                 names: rowType.fieldNames }}] }
    // ── Calcite TableScan wrappers for OpenSearchStageInputScan rewrite ─────────  
        }
                false,
                        + " distinct="  
            );
    };
            if (filter == null) {
        SqlKind.OTHER_FUNCTION,
        LOGGER.debug("Schema-only Read for stage [{}]: {} bytes", childStageId, bytes.length);
        FunctionMappings.s(JsonFunctionAdapters.JsonDeleteAdapter.LOCAL_JSON_DELETE_OP, "json_delete"),
        // isthmus visitor (which only knows about Calcite core / Logical RelNodes)
            return RelDistributions.ANY;
    /**  
            right = sort.getInput();  
        // emits a ReadRel with the stage-input-id as the named table. Also rewrites  
     * avoids unnecessary {@code SubstraitRelVisitor} setup and keeps the produced bytes
    public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {  
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP, "maketime"),
                kind,
        FunctionMappings.s(LOCAL_LIST_MERGE_OP, "list_merge"),
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
            return qualifiedName;
    private static List<String> fieldNames(RelNode fragment) {  
            }  
     * literal is rescaled from PPL's [0, 100] to DataFusion's [0, 1] convention via
    /**
     * substrait window consumer. Custom Rust UDAF in {@code rust/src/udaf/os_count_distinct.rs}.
    };
        RelNode preprocessed = preprocessForSubstrait(operator);
        // Rewrite any OpenSearchStageInputScan leaves to plain TableScan nodes so the
    private static RelNode preprocessForSubstrait(RelNode rel) {
        FunctionMappings.s(MvfindAdapter.LOCAL_MVFIND_OP, "mvfind"),  
        FunctionMappings.s(SqlLibraryOperators.SHA1, "sha1"),
        ReadRel readRel = ReadRel.newBuilder()
            Expression filter = isNotNull(argExpr);
            // directly would drop the Sort and lose global order before the limit. Descend into
            windowConverter,
        OperandTypes.ANY,
        FunctionMappings.s(ToStringFunctionAdapter.TOSTRING, "tostring"),
        if (wrapper instanceof Fetch fetch) {
        FunctionMappings.s(GrokAdapter.LOCAL_GROK_OP, "grok"),
        false,
        SqlKind.OTHER_FUNCTION,
        @Override  
        FunctionMappings.s(SpanAdapter.LOCAL_DATE_BIN_OP, "date_bin"),
            io.substrait.proto.Plan proto = io.substrait.proto.Plan.parseFrom(bytes);  
                // percentile at planning. There is no scaled-vs-unscaled ambiguity (NULL ≠ 50.0).
        WindowFunctionConverter windowConverter = new WindowFunctionConverter(  
     */  
            return false;  
            }
        return rexBuilder.makeCast(varcharNullable, arg);
            @Override
    }
     * {@link ProtoPlanConverter} that understands this backend's own {@link ExtensionSingle}
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        public Optional<RexNode> rewriteDataArg(int argIndex, RexNode argRef, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {  
     * PPL {@code percentile_approx(field, percentile)} → DataFusion's builtin
import io.substrait.proto.ReadRel;  
        FunctionMappings.s(MvappendAdapter.LOCAL_MVAPPEND_OP, "mvappend"),
                false,
        }
    static final SqlAggFunction LOCAL_LIST_MERGE_OP = new SqlAggFunction(
         * function's own {@code ignore_nulls}). False by default.  
            return Optional.empty();
            return rel;
        SqlKind.OTHER_FUNCTION,  
            }
            return Any.newBuilder().setTypeUrl(TYPE_URL).setValue(ByteString.copyFrom(payload.array())).build();
    public DataFusionFragmentConvertor(SimpleExtension.ExtensionCollection extensions) {  
                return spec.outputType();  
        ReturnTypes.ARG0.andThen(SqlTypeTransforms.FORCE_NULLABLE),
        null,
     * {@code substrait_consumer.rs} on the Rust side. The 16-byte payload carries  
    static final class StageInputTableScan extends TableScan {
     * was decoded from serialized bytes, in which case the record type is derived from the input.
    private static final List<FunctionMappings.Sig> ADDITIONAL_WINDOW_SIGS = List.of(  
        FunctionMappings.s(SqlLibraryOperators.CONCAT_WS, "concat_ws"),
     * protos — no functions or user-defined types touch the inner {@link ExtensionCollector},
        FunctionMappings.s(DateTimeAdapters.LOCAL_DATE_TRUNC_OP, "date_trunc"),
    /** FINAL-side merge for VALUES — re-deduplicates after concatenation. */
        null,
        FunctionMappings.s(LOCAL_MV_COLLECT_OP, "mv_collect"),  
     */  
        // FORCE_NULLABLE so AggregateCall.create accepts a nullable explicit return type.  
    private Optional<AggregateFunctionInvocation> rewriteLocalAggDataArgs(  
                if (bd != null) {
    public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
        RelNode input,
    @Override  
            Rel rewiredInput = fetch.getInput() instanceof Sort ? replaceInput(fetch.getInput(), newInput) : newInput;  
        Optionality.FORBIDDEN  
    private record MultiValueExpandSpec(int fieldIndex, Integer limit, boolean append, boolean distinct, Type.Struct outputType) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
        FunctionMappings.s(SqlStdOperatorTable.TRUNCATE, "trunc"),  
        FunctionMappings.s(SqlLibraryOperators.ARRAY_LENGTH, "array_length"),
        ReturnTypes.ARG0_NULLABLE,
            return rowType;  
    }
     * Encoding DISTINCT in the operator name avoids the dropped-DISTINCT bug in DataFusion 54.x's
    private static final List<FunctionMappings.Sig> ADDITIONAL_AGGREGATE_SIGS = List.of(  
    /** BRAIN aggregate stub; return type is supplied by {@link PplAggregateCallRewriter}. */
        }
        null,
        false,
        null,
        FunctionMappings.s(JsonFunctionAdapters.JsonExtractAdapter.LOCAL_JSON_EXTRACT_OP, "json_extract"),
            // append mode it is added after the input columns, otherwise it replaces the LIST column.
        @Override  
            return new OpenSearchProtoPlanConverter(extensions).from(proto);
        FunctionMappings.s(LOCAL_INTERNAL_PATTERN_WINDOW_OP, "internal_pattern"),
        "list_merge_distinct",  
                throw new IllegalArgumentException(
            return true;  
        AggregateCall call,
        FunctionMappings.s(SqlLibraryOperators.LOG, "logb"),
                Optionality.FORBIDDEN  
        public List<RelCollation> getCollationList() {
        );  
        "pattern_parser_get_tokens",
            Type source = inputFields.get(spec.fieldIndex());
        @Override
            if (!(sort.fetch instanceof RexLiteral literal)) {
        }
        ) {  
     * the wire and is re-derived from the input on decode ({@link #deriveRecordType(Rel)}).
                    return bound;
    }
        null,
            // The percentile literal arrives as INTEGER for the standard form percentile(x, 50)
import org.apache.calcite.sql.SqlAggFunction;
     */
        List<Aggregate.Measure> newMeasures = new ArrayList<>(agg.getMeasures().size());
    }  
        SqlKind.OTHER_FUNCTION,
                @Override
 * SPDX-License-Identifier: Apache-2.0
        }  
    ) {
            .findFirst()  
        ) {
    @Override
        false,
    private final SimpleExtension.ExtensionCollection extensions;
        @Override  
        PlanRel planRel = PlanRel.newBuilder()
            aggConverter,  
                outputFields.add(element);  
    private static Rel withAggregationPhase(Rel rel, Expression.AggregationPhase phase) {  
     * {@code OpenSearchTableScan} and one {@link OpenSearchBroadcastScan} — the latter
        /**  
         * reduce-stage stitch ({@link #replaceInput}) would drop. Identity by default.
        return tf.createTypeWithNullability(tf.createArrayType(tf.createSqlType(SqlTypeName.VARCHAR), -1), true);
            // the Sort so the shape becomes Fetch(Sort(newInput)): gather, sort globally, then limit.
        FunctionMappings.s(DateTimeAdapters.LOCAL_CURRENT_TIME_OP, "current_time"),  
        return serializePlan(SubstraitPlanPojoRewriter.rewrite(rewired));
        "approx_percentile_cont",  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    };
        SubstraitRelVisitor visitor = createVisitor(preprocessed);  
                    MultiValueExpandSpec spec = new MultiValueExpandSpec(
            throw new IllegalArgumentException("Inner Substrait plan has no root relation to rewire under wrapper");  
import com.google.protobuf.ByteString;  
    }
        List<Aggregate.Measure> measures = agg.getMeasures();
        "first_value",  
            return false;  
        FunctionMappings.s(SqlLibraryOperators.CRC32, "crc32"),
        FunctionMappings.s(SqlLibraryOperators.REGEXP_REPLACE_3, "regexp_replace"),  
        }
import java.util.Optional;
        boolean changed = false;  
    private byte[] convertToSubstrait(RelNode fragment) {  
                if (spec == null) {
    }  
    };
        FunctionMappings.s(SqlLibraryOperators.CONCAT_FUNCTION, "concat"),
        }
        for (Expression expr : project.getExpressions()) {  
        Plan inner = decodePlan(innerBytes);  
    }  
    static final SqlAggFunction LOCAL_INTERNAL_PATTERN_WINDOW_OP = new SqlAggFunction(
                }  
        RelNode rewritten = rewriteStageInputScans(fragment);
        private final MultiValueExpandSpec spec;
        if (changed) {
import org.apache.calcite.rel.RelRoot;
        }
         * {@code is_not_null} preMeasureFilter (DataFusion's substrait consumer can't take the
    }  
    /**  
     * rewriters are added.
            }
    static final SqlAggFunction LOCAL_LAST_OP = new SqlAggFunction(
     * Wire-level description of a multi-value expand. {@code outputType} is the Calcite-derived  
        @Override
            .build();  
import io.substrait.isthmus.expression.WindowFunctionConverter;
     * Builds a schema-only stub plan directly via Substrait protos — no isthmus, no
            typeConverter
            extensions.windowFunctions(),
        Optionality.FORBIDDEN
                        + " limit="
        if (!(call.getAggregation() instanceof LocalAggOp op)) {  
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        RexBuilder rexBuilder = input.getCluster().getRexBuilder();  
        OperandTypes.ANY_ANY,  
        FunctionMappings.s(LOCAL_LAST_OP, "last_value"),
    /**
            typeConverter
            return null;
        return new SubstraitRelVisitor(converterProvider) {
                    if (offset == null || offset < 0 || offset >= projects.size()) continue;
        /** Whether {@code any} carries a multi-value expand payload this class can decode. */
            return Project.builder().from(project).input(newInput).build();
            int limit = payload.getInt();
                        + append
                List<RexNode> projects = project.getProjects();
        if (inner.getRoots().isEmpty()) {
        ReturnTypes.ARG0,  
        if (calls.size() != measures.size()) {
        public RelDistribution getDistribution() {
    // TODO: extract these LOCAL_*_OP aggregate stubs (+ LocalAggOp and ADDITIONAL_AGGREGATE_SIGS)  
    }  
    ) {
            }  
        ReturnTypes.BIGINT,
            }
                for (int i = 0; i < args.size(); i++) {  
            protected ImmutableList<FunctionMappings.Sig> getSigs() {
        FunctionMappings.s(RexExtractMultiAdapter.LOCAL_REX_EXTRACT_MULTI_OP, "rex_extract_multi"),  
    /** Forces {@code phase} on every measure of an Aggregate wrapper (isthmus hardcodes INITIAL_TO_RESULT). */
        Rel wrapper = convertStandalone(rewritten);
        Optionality.FORBIDDEN
            @Override
        SqlKind.OTHER_FUNCTION,  
                return super.getSigs().stream()
        } catch (AssertionError e) {
        "mv_collect",  
        StageInputTableScan(RelOptCluster cluster, RelTraitSet traitSet, String stageInputId, RelDataType rowType) {  
import io.substrait.extension.SimpleExtension;  
        FunctionMappings.s(TimeConversionFunctionAdapter.CTIME, "ctime"),
        return sf.offset();
        public List<ImmutableBitSet> getKeys() {
import org.apache.calcite.rel.RelCollation;  
    static final SqlAggFunction LOCAL_ARRAY_AGG_OP = new LocalAggOp("array_agg", SqlKind.OTHER_FUNCTION, opBinding -> {
                RelNode input,
     * {@code count(distinct x) OVER(...)} via {@link WindowFunctionAdapters#countDistinctExact()}.  
                io.substrait.expression.ImmutableExpression.SortField.builder()
                SqlFunctionCategory.USER_DEFINED_FUNCTION,  
        }
        public RelNode toRel(ToRelContext context) {
            public Rel visit(Correlate correlate) {  
    // into their own class, mirroring the per-function scalar *Adapter classes, to keep this file
            return lit;  
            protected ImmutableList<FunctionMappings.Sig> getSigs() {
        public List<ColumnStrategy> getColumnStrategies() {
        FunctionMappings.s(ArrayElementAdapter.LOCAL_ARRAY_ELEMENT_OP, "array_element"),  
            extensions,
import java.math.MathContext;  
        if (fr.segments().size() != 1) return null;
                    return ExtensionSingle.from(new MultiValueExpandDetail(spec), apply(expand.getInput())).build();  
            return Type.Struct.builder().nullable(input.getRecordType().nullable()).addAllFields(outputFields).build();
                MultiValueExpandSpec spec = explicitMultiValueExpand(correlate, typeConverter);
     * resolves to the broadcast memtable at execution time.
            @Override
        public double getRowCount() {
import java.util.function.Function;
        byte[] bytes = SubstraitPlanProtoRewriter.rewrite(io.substrait.proto.Plan.newBuilder().addRelations(planRel).build()).toByteArray();  
    /** PARTIAL-side LIST over a source multi-value field; flattens elements across documents. */
    static final LocalAggOp LOCAL_PERCENTILE_APPROX_OP = new LocalAggOp(
        FunctionMappings.s(SqlLibraryOperators.ARRAY_DISTINCT, "array_distinct"),  
                return ExtensionSingle.from(new MultiValueExpandDetail(spec), apply(correlate.getLeft())).build();
        /** Inverse of {@link #toProto}; the record type is derived lazily from the input. */  
        private static final int PAYLOAD_BYTES = 16;  
            super(
            return null;  
            addedSort = true;
                List<FunctionArg> args = fn.arguments();  
        null,
            return false;  
        }
    ) {
        "last_value",
            .setBaseSchema(nsProto)
    static final SqlOperator LOCAL_PATTERN_PARSER_GET_TOKENS_OP = new SqlFunction(
    public byte[] convertSchemaOnlyRead(int childStageId, RelDataType rowType) {  
                new MultiValueExpandSpec(fieldIndex, limit < 0 ? null : limit, append == 1, distinct == 1, null)
import io.substrait.extension.ExtensionCollector;
        FunctionMappings.s(DateTimeAdapters.LOCAL_NOW_OP, "now"),
        null,  
                return rel instanceof Aggregate agg ? addNullArgFilters(aggregate, agg) : rel;
            if (value.size() != PAYLOAD_BYTES) {  
     * visitor layer, or whether the ones that only manipulate Calcite {@link RelNode}s (and don't
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
     * record type is an empty struct, so any field reference above it (e.g. the GROUP BY key of a  
import io.substrait.isthmus.ConverterProvider;
import java.util.List;  
        public List<RelReferentialConstraint> getReferentialConstraints() {  
        false,
                        + " append="
        }
        List<FunctionArg> rewritten = null;
import org.apache.calcite.util.Optionality;
import org.apache.calcite.sql.type.ReturnTypes;
        Optionality.FORBIDDEN  
        Optionality.FORBIDDEN  
        ReturnTypes.ARG0,
        private MultiValueExpandDetail(MultiValueExpandSpec spec) {  
        FunctionMappings.s(SqlStdOperatorTable.ASCII, "ascii"),
    /**
            return null;  
     * tightly scoped to the schema we care about.  
        FunctionMappings.s(NumericConversionFunctionAdapter.RMUNIT, "rmunit"),
     * Lets a {@link LocalAggOp} rewrite its data args on the bound Substrait invocation (e.g. a
import io.substrait.isthmus.SubstraitRelVisitor;
        FunctionMappings.s(SqlStdOperatorTable.CHAR_LENGTH, "length"),  
        FunctionMappings.s(RexOffsetAdapter.LOCAL_REX_OFFSET_OP, "rex_offset"),
     *   <li>{@code "broadcast-<buildStageId>"} for broadcast scans — registered as a
            return Filter.builder().from(filter).input(newInput).build();  
            return null;
import io.substrait.type.NamedStruct;  
        RelNode rewritten = rewriteStageInputScans(fragment);  
public class DataFusionFragmentConvertor implements FragmentConvertor {
    /**
            ADDITIONAL_SCALAR_SIGS,  
                }  
        @Override
import io.substrait.relation.Fetch;
     * ({@link #convertToSubstrait}) and the wrapper/partial-aggregate path
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_DATE_FORMAT_OP, "date_format"),  
        false,
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
    // ── Visitor wiring ──────────────────────────────────────────────────────────
                    .collect(ImmutableList.toImmutableList());
         * Whether null arguments are dropped before aggregating. Carried as the measure's
        public Any toProto(io.substrait.relation.RelProtoConverter converter) {
        Plan rewired = rewire(
import org.apache.calcite.rel.type.RelDataType;
        FunctionMappings.s(NumericConversionFunctionAdapter.MEMK, "memk"),
import io.substrait.expression.FunctionArg;  
    private static boolean containsWindowFunction(Project project) {
                    RelDataType doubleType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        ReturnTypes.VARCHAR_FORCE_NULLABLE,
            .filter(c -> c.getAggregation() != SqlStdOperatorTable.GROUP_ID)
        null,
            int append = payload.getInt();
        "internal_pattern",  
        io.substrait.proto.Plan protoPlan = SubstraitPlanProtoRewriter.rewrite(new PlanProtoConverter().toProto(plan));
     * one path is not missed on the other. Centralizing here keeps the two paths in lockstep as
     * cast to VARCHAR (lowercase booleans), drop nulls, and (VALUES only) lexicographic sort.
     * LIST/VALUES — carries the PPL element-rendering contract via the {@link LocalAggOp} hooks:
        FunctionMappings.s(DelegatedPredicateFunction.FUNCTION, DelegatedPredicateFunction.NAME),
    static Plan rewire(Plan inner, Rel wrapper, List<String> wrapperNames) {
                    return rexBuilder.makeLiteral(scaled, doubleType);
        }
         * the bound Substrait argument, so it rides the measure without a child Project that the  
        FunctionMappings.s(SqlLibraryOperators.DATE_TRUNC, "date_trunc"),  
            }
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_TIME_FORMAT_OP, "time_format"),
            sorts = List.of(
        );
        ReturnTypes.ARG0,  
     *   <li>{@code "input-<childStageId>"} for stage-input scans — registered as a partition  
        FunctionMappings.s(LOCAL_OS_COUNT_DISTINCT_OP, "os_count_distinct")  
     * Casts a list/values element to VARCHAR matching the SQL plugin's {@code String.valueOf}
        if (arg.getType() instanceof org.opensearch.analytics.schema.BinaryType) {
        // Sort the elements ascending by the (rewritten) first arg when the op asks for it — emitted
        return io.substrait.expression.ImmutableExpression.ScalarFunctionInvocation.builder()
     * {@link LocalAggOp#normaliseLiteralArg} at substrait emission.  
    }  
                Type.Struct inputType,
        false,
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
        FunctionMappings.s(SqlLibraryOperators.REVERSE, "reverse"),  
            int fieldIndex = payload.getInt();  
            if (project.getInput() instanceof Project lower && containsWindowFunction(lower)) {
            withAggregationPhase(wrapper, Expression.AggregationPhase.INITIAL_TO_INTERMEDIATE),
            public Rel visitOther(RelNode other) {  
        }
            return new StageInputTableScan(scan.getCluster(), scan.getTraitSet(), scan.getNamedInputId(), scan.getRowType());  
        FunctionMappings.s(JsonFunctionAdapters.JsonExtendAdapter.LOCAL_JSON_EXTEND_OP, "json_extend"),  
        TypeConverter typeConverter = TypeConverter.DEFAULT;  
    }  
            if (m.getPreMeasureFilter().isPresent()
                return true;
        plan = SubstraitPlanPojoRewriter.rewrite(plan);  
    }
                continue;  
        }
                Rel rel = super.visit(aggregate);
            .stream()
        }  
            rewritten.set(i, Aggregate.Measure.builder().from(m).preMeasureFilter(filter).build());
        if (correlate.getJoinType() != org.apache.calcite.rel.core.JoinRelType.INNER || correlate.getRequiredColumns().cardinality() != 1) {
        @Override
import org.apache.calcite.rex.RexNode;  
            }
     * record type when the spec is built from a {@link RelNode}; it is {@code null} when the spec
        FunctionMappings.s(DelegationPossibleFunction.FUNCTION, DelegationPossibleFunction.NAME),
    };  
        FunctionMappings.s(LOCAL_PERCENTILE_APPROX_OP, "approx_percentile_cont"),
        RelNode preprocessed = preprocessForSubstrait(fragment);
        return false;
        FunctionMappings.s(WidthBucketAdapter.LOCAL_WIDTH_BUCKET_OP, "width_bucket"),  
     * planner layer. Moving them up would let other backends reuse them and keep backend fragment
        FunctionMappings.s(MakeArrayAdapter.LOCAL_MAKE_ARRAY_OP, "make_array"),
import org.opensearch.be.datafusion.planner.adapter.TimeConversionFunctionAdapter;  
        FunctionMappings.s(RexExtractAdapter.LOCAL_REX_EXTRACT_OP, "rex_extract"),
        return node;
        );  
            }  
     * {@link #convertSchemaOnlyRead} call.  
            throw new IllegalArgumentException("Failed to decode Substrait plan bytes", e);  
                        null,
        }
                protected Extension.SingleRelDetail detailFromExtensionSingleRel(Any any) {
        }
import com.google.common.collect.ImmutableList;
        List<RelNode> newInputs = new ArrayList<>(node.getInputs().size());
            if (replacement.isEmpty()) {
    /** PARTIAL-side VALUES over a source multi-value field; flattens and de-duplicates elements. */
    /** Builds {@code is_not_null(arg)} from the merged extension catalog, or null if the variant is absent. */
            @Override
        for (Aggregate.Measure m : agg.getMeasures()) {
            // expanded column is the LIST's element type, nullable (unnest preserves nulls); in  
            // Substrait validators throw AssertionError directly (not via `assert`), so -da
            if (rewritten != input) {
import io.substrait.relation.Filter;
import org.apache.calcite.sql.SqlFunction;  
        FunctionMappings.s(ParseAdapter.LOCAL_PARSE_OP, "parse"),  
    ) {  
        preprocessed = MultiValueRelRewriter.rewrite(preprocessed);
        throw new UnsupportedOperationException(  
        FunctionMappings.s(JsonFunctionAdapters.JsonSetAdapter.LOCAL_JSON_SET_OP, "json_set"),
            return Optional.empty();
        @Override
            }  
     * opts in (DataFusion's substrait consumer can't take the function's own {@code ignore_nulls}).
package org.opensearch.be.datafusion;
            return Fetch.builder().from(fetch).input(rewiredInput).build();
    private static final class OpenSearchProtoPlanConverter extends ProtoPlanConverter {
        protected io.substrait.relation.ProtoRelConverter getProtoRelConverter(io.substrait.extension.ExtensionLookup functionLookup) {
            inner,  
        FunctionMappings.s(MvzipAdapter.LOCAL_MVZIP_OP, "mvzip"),
            return this;
import org.opensearch.analytics.spi.FragmentConvertor;
        }  
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, "opensearch_extract"),
            }
        ScalarFunctionConverter scalarConverter = new ScalarFunctionConverter(
            // VALUES (isDistinct) returns lexicographically sorted distinct strings; LIST does not sort.
        return convertToSubstrait(rewritten);  
    /** Serializes a model-level {@link Plan} to proto bytes. */
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            SqlKind kind,
            throw new UnsupportedOperationException("StageInputRelOptTable.toRel not supported");  
        @Override  
                        + distinct
            newInputs.add(rewritten);  
     * {@code convert()} override only invokes {@link #normaliseLiteralArg} when the call's  
            org.apache.calcite.sql.type.SqlOperandTypeChecker operandTypeChecker  
import org.apache.calcite.rel.RelDistribution;
            throw new IllegalStateException("Substrait conversion rejected the plan: " + e.getMessage(), e);
        Rel rewired = replaceInput(wrapper, innerRel);
        FunctionMappings.s(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, "convert_tz"),
    static final SqlAggFunction LOCAL_INTERNAL_PATTERN_OP = new SqlAggFunction(
import io.substrait.plan.PlanProtoConverter;  
    };
                Rel rewiredLower = replaceInput(lower, newInput);
                    if (!(arg instanceof io.substrait.expression.FieldReference fr)) continue;
                if (other instanceof MultiValueExpandRel expand) {
        FunctionMappings.s(SqlLibraryOperators.REGEXP_REPLACE_PG_4, "regexp_replace"),
     */
        OperandTypes.VARIADIC,
import org.apache.calcite.rel.core.Correlate;
    /** Decodes serialized Substrait bytes into a model-level {@link Plan}, including this backend's own extension rels. */  
        FunctionMappings.s(RangeBucketAdapter.LOCAL_RANGE_BUCKET_OP, "range_bucket"),
                BigDecimal bd = lit.getValueAs(BigDecimal.class);
            typeFactory,  
                    return rewrittenArgs;
        @Override
import org.apache.calcite.rel.RelReferentialConstraint;
    ) {
        public org.apache.calcite.linq4j.tree.Expression getExpression(Class clazz) {
        FunctionMappings.s(NumericConversionFunctionAdapter.RMCOMMA, "rmcomma"),  
     * Other local stubs without transformations stay as plain {@link SqlAggFunction}; the
        RelDataTypeFactory typeFactory = relNode.getCluster().getTypeFactory();
                    Integer offset = simpleStructOffset(fr);  
        FunctionMappings.s(LOCAL_PATTERN_PARSER_GET_TOKENS_OP, "pattern_parser_get_tokens"),
    private static final List<FunctionMappings.Sig> ADDITIONAL_SCALAR_SIGS = List.of(
 * this file be licensed under the Apache-2.0 license or a
        RelNode preprocessed = UntypedNullPreprocessor.rewrite(rel);
     * because schema-only Reads convert primitive Calcite types to primitive Substrait  
        }
            return new io.substrait.relation.ProtoRelConverter(functionLookup, extensionCollection, protoExtensionConverter) {  
    @Override
import java.nio.ByteBuffer;
        "mv_collect_distinct",  
        return Optional.of(ImmutableAggregateFunctionInvocation.builder().from(fn).arguments(args).sort(sorts).build());  
        // OpenSearchBroadcastScan leaves (M1 broadcast probe fragments carry
        }
    }
        SqlKind.OTHER_FUNCTION,
                return Project.builder().from(project).input(rewiredLower).build();  
        FunctionMappings.s(NumericConversionFunctionAdapter.NUM, "num"),  
            typeFactory,
        FunctionMappings.s(SqlLibraryOperators.REGEXP_CONTAINS, "regex_match"),
        null,
     * <p>For single-input fragments the sole stage id (typically 0) reproduces the  
            .toList();  
        }
    }
        if (node instanceof OpenSearchBroadcastScan scan) {
import java.util.ArrayList;
        Plan plan = Plan.builder().addRoots(substraitRoot).build();
    private static byte[] serializePlan(Plan plan) {
        if (op.sortsArgAscending(call) && sorts.isEmpty() && !args.isEmpty() && args.get(0) instanceof Expression sortKey) {  
        FunctionMappings.s(PositionAdapter.STRPOS, "strpos"),
    private static final Logger LOGGER = LogManager.getLogger(DataFusionFragmentConvertor.class);
     * {@code registerPartitionStream} which needs the partition's named-table id and base  
        @Override
        List<AggregateCall> calls = calcite.getAggCallList()  
        FunctionMappings.s(SqlLibraryOperators.ARRAY_LENGTH, "array_length"),
        false,
            false,  
            .declaration(variant)  
     * each branch refers to its own child stage id and the isthmus visitor emits one
                    "multi-value expand field index " + spec.fieldIndex() + " is outside " + inputFields.size() + " input columns"
            return agg; // shape we don't recognise — leave untouched  
                if (bound.isEmpty()) {
        public boolean sortsArgAscending(AggregateCall call) {
            return Optional.of(castToVarchar(argRef, rexBuilder, typeFactory));  
        SqlKind.OTHER_FUNCTION,
            }  
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;  
import org.apache.calcite.rel.core.AggregateCall;  
            // Fetch(Sort(input)) — two Substrait rels from one node. Rewiring the Fetch's input  
    /**
        if (wrapper instanceof Sort sort) {
    );
     * the RelNode tree to a plain Calcite {@link TableScan} whose qualified name matches what  
    }
        FunctionMappings.s(DateTimeAdapters.LOCAL_DATE_OP, "to_date"),
                if (rewritten == null) return bound;  
        if (wrapper instanceof Aggregate agg) {
import org.apache.calcite.plan.RelOptTable;
     * Exact distinct count for use in a window context — replaces
                        ? localOp.normaliseLiteralArg(i, rexLit, rexBuilder, typeFactory)
        io.substrait.proto.Rel inputRel = io.substrait.proto.Rel.newBuilder().setRead(readRel).build();
        "internal_pattern",  
            typeConverter
                // numeric percentile() arg. Pass it through unchanged; DataFusion rejects a NULL  
     * Local aggregate stub that may transform inlined literal args before substrait emission.
            return Sort.builder().from(sort).input(newInput).build();  
        false,
            public Optional<AggregateFunctionInvocation> convert(  
    );
            if (rewritten == null) {
                || m.getFunction().arguments().isEmpty()  
        FunctionMappings.s(SqlLibraryOperators.ARRAY_SLICE, "array_slice"),
     * Substrait compute, but the parent reduce sink (Stage 3) still calls
    /** Local stubs for PPL state-expanding aggregates; swapped in by {@link PplAggregateCallRewriter}. */
        FunctionMappings.s(Sha2FunctionAdapter.DIGEST, "digest"),  
import com.google.protobuf.InvalidProtocolBufferException;
        FunctionMappings.s(ConvAdapter.LOCAL_CONV_OP, "conv")  
import io.substrait.relation.Sort;
        false,
        FunctionMappings.s(JsonFunctionAdapters.JsonAdapter.LOCAL_JSON_OP, "json"),
        }  
                null,
            // A single Calcite LogicalSort carrying both a collation AND a fetch/offset lowers to
            if (expr instanceof Expression.WindowFunctionInvocation) {
        FunctionMappings.s(SqlLibraryOperators.REGEXP_REPLACE_3, "regexp_replace"),
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        static MultiValueExpandDetail fromProto(Any any) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION,  
            return List.of();
        OperandTypes.ANY_ANY  
        FunctionMappings.s(SqlLibraryOperators.MD5, "md5"),  
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
        }
        try {
                name,  
        FunctionMappings.s(JsonFunctionAdapters.JsonArrayAdapter.LOCAL_JSON_ARRAY_OP, "json_array"),  
            if (!(calls.get(i).getAggregation() instanceof LocalAggOp op) || !op.filtersNullArgs(calls.get(i))) {
        OperandTypes.ANY,
        OperandTypes.VARIADIC,  
        FunctionMappings.s(LOCAL_OS_COUNT_DISTINCT_OP, "os_count_distinct")
            return rexBuilder.makeCall(varcharNullable, IpBinaryCastFunctionAdapter.BINARY_TO_BASE64_OP, List.of(arg));
        // Rewriter must run on the assembled plan so wrapper literals get rewritten alongside the inner.
        FunctionMappings.s(LOCAL_FIRST_OP, "first_value"),  
        List<String> fieldNames = root.fields.stream().map(field -> field.getValue()).toList();
import org.apache.calcite.util.ImmutableBitSet;
                continue;  
            .outputType(io.substrait.type.TypeCreator.REQUIRED.BOOLEAN)
        NamedStruct ns = TypeConverter.DEFAULT.toNamedStruct(rowType);
     * shard-stage plan is decoded on the coordinator to splice the reduce fragment on top.  
                    return bound;
    }  
                }  
import com.google.protobuf.Any;
                }  
        if (node instanceof OpenSearchStageInputScan scan) {
     */
            Optional<RexNode> replacement = op.rewriteDataArg(i, argRef, rexBuilder, typeFactory);  
        Rel innerRel = innerRoot.getInput();  
        null,
        preprocessed = PplAggregateCallRewriter.rewrite(preprocessed);  
                    if (rewritten == null) rewritten = new ArrayList<>(args);  
                    "Malformed multi-value expand payload: fieldIndex="  
            // Lifted-window shape: outer Project references a window column from the lower Project.  
        @Override
            return lit;  
        }
        return fragment.getRowType().getFieldList().stream().map(RelDataTypeField::getName).toList();
                // argument — generic dispatch; the cast semantics live on the LocalAggOp, not here.
            return List.of();
     * <pre>
        ReturnTypes.ARG0,  
        }  
     * Shared pre-Substrait rewrite pipeline. Both the top-level fragment path
            typeFactory,  
     * conversion mostly a shape-to-Substrait translation.
    /** Column offset for a simple input-rooted single-segment {@code StructField}, else null. */  
                    );
        FunctionMappings.s(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, "to_unixtime"),  
    @Override
                // Let the op rewrite its data args (e.g. a type-coercing CAST) on the bound Substrait
        FunctionMappings.s(LOCAL_MV_COLLECT_DISTINCT_OP, "mv_collect_distinct"),
        FunctionMappings.s(SqlLibraryOperators.ILIKE, "ilike"),
        null,
                outputFields.set(spec.fieldIndex(), element);
    private static final TypeProtoConverter SCHEMA_ONLY_TYPE_PROTO_CONVERTER = new TypeProtoConverter(new ExtensionCollector());
     *   Plan { relations: [PlanRel { Root { input: Rel { Read { named_table: "input-&lt;id&gt;";
        null,
         * field reference (e.g. a type-coercing CAST), or empty to keep the reference. Applied on
        }  
                Optional<AggregateFunctionInvocation> bound = super.convert(input, inputType, call, rexConverter);  
        for (RelNode input : node.getInputs()) {
     */
        public boolean sortsArgAscending(AggregateCall call) {
    /**
        SqlKind.OTHER_FUNCTION,
         */
            if (argIndex == 1 && SqlTypeName.NUMERIC_TYPES.contains(lit.getType().getSqlTypeName())) {  
                        typeConverter.toNamedStruct(expand.getRowType()).struct()
    /**
        RelDataTypeFactory typeFactory = input.getCluster().getTypeFactory();
    }
import org.apache.calcite.sql.SqlFunctionCategory;
        @Override
            public Rel visit(org.apache.calcite.rel.core.Aggregate aggregate) {  
        }
    private static RexNode castToVarchar(RexNode arg, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {
        FunctionMappings.s(PatternParserAdapter.LOCAL_PATTERN_PARSER_OP, "pattern_parser"),
     * schema. This stub is the minimum proto that satisfies that path. Bypassing isthmus
                }
                changed = true;
                // bd == null only for a SQL-NULL percent (getValueAs returns null for NULL value) —
     *
    ) {
                        true,
        FunctionMappings.s(MinspanBucketAdapter.LOCAL_MINSPAN_BUCKET_OP, "minspan_bucket"),
import org.apache.calcite.rex.RexLiteral;
        FunctionMappings.s(SqlLibraryOperators.TRANSLATE3, "translate"),
            ByteBuffer payload = ByteBuffer.allocate(PAYLOAD_BYTES);  
    static final SqlAggFunction LOCAL_LIST_MERGE_DISTINCT_OP = new SqlAggFunction(
     * {@code approx_percentile_cont(field, percentile)}. PPL's trailing field-type-flag  
                returnTypeInference,  
        false,  
        FunctionMappings.s(SignumFunction.FUNCTION, SignumFunction.NAME),  
        }
            return node.copy(node.getTraitSet(), newInputs);  
            Type element = list.elementType().withNullable(true);  
            };
                }  
                List<FunctionArg> rewritten = null;
     * type-coercing CAST), keyed only on the generic hook — no per-function logic here. Returns  
    // from accumulating every aggregate definition. Pure structural move (no behaviour change);
        }  
    /** FINAL-side merge for LIST; un-nests per-shard list states. */
                        + fieldIndex
    static final SqlOperator LOCAL_PATTERN_PARSER_GET_PATTERN_OP = new SqlFunction(
        // Mirror ADDITIONAL_AGGREGATE_SIGS: rename APPROX_COUNT_DISTINCT to DataFusion's `approx_distinct`.
        OpenSearchProtoPlanConverter(SimpleExtension.ExtensionCollection extensions) {  
        ReturnTypes.ARG0,  
            .orElse(null);
        }
        public RelDataType getRowType() {
        FunctionMappings.s(NumericConversionFunctionAdapter.DUR2SEC, "dur2sec"),
import io.substrait.plan.Plan;
        FunctionMappings.s(SqlLibraryOperators.DATE_PART, "date_part"),
            .addArguments(arg)
                rewritten = new ArrayList<>(fn.arguments());
     */
            if (spec.outputType() != null) {
    /**  
        Plan.Root innerRoot = inner.getRoots().get(0);
                AggregateCall call,  
                return Optional.of(ImmutableAggregateFunctionInvocation.builder().from(fn).arguments(rewritten).build());
     *  
            }
        }
        SqlKind.OTHER_FUNCTION,
            ) {
            limit = literal.getValueAs(Integer.class);
     * PARTIAL aggregate over the expanded column) fails with
            limit,
        FunctionMappings.s(SqlStdOperatorTable.REPLACE, "replace"),  
    }
        FunctionMappings.s(RustUdfDateTimeAdapters.LOCAL_OS_YEARWEEK_OP, "os_yearweek"),
            scalarConverter,
    ) {
            Aggregate.Measure m = measures.get(i);
        FunctionMappings.s(SqlLibraryOperators.TO_CHAR, "to_char"),  
                );  
        null,
            .setRoot(io.substrait.proto.RelRoot.newBuilder().setInput(inputRel).addAllNames(rowType.getFieldNames()).build())  
    );
            String name,  
import org.apache.calcite.plan.RelOptSchema;  
        false,
        SubstraitRelVisitor visitor = createVisitor(preprocessed);
        List<Aggregate.Measure> rewritten = null;
    };
     * Measures line up with the Calcite agg calls minus any {@code GROUP_ID()} (which isthmus drops).  
        // Same APPROX_COUNT_DISTINCT filter as aggConverter — let our `approx_distinct` entry win.
     * Inferred return type is {@code ARRAY<VARCHAR>}.  
                    .filter(sig -> sig.operator != SqlStdOperatorTable.APPROX_COUNT_DISTINCT)
    private Aggregate addNullArgFilters(org.apache.calcite.rel.core.Aggregate calcite, Aggregate agg) {
        if (!(seg instanceof io.substrait.expression.FieldReference.StructField sf)) return null;  
            fieldNames(partialAggFragment)
    );
    };
            List<Type> inputFields = input.getRecordType().fields();
    /**
    }
            }
                        ? MultiValueExpandDetail.fromProto(any)
    /** Rewires {@code wrapper} above {@code inner}'s root; {@code wrapperNames} must match the wrapper's output schema. */  
            .filter(f -> "is_not_null".equals(f.name()))
                return super.getSigs().stream()  
            payload.putInt(spec.fieldIndex());
        FunctionMappings.s(LOCAL_TAKE_OP, "take"),
     */  
            this.spec = spec;
    );
            }  
     * <p>TODO: assess whether each of these rewriters genuinely needs to run at the Substrait
         */
            if (rewritten == null) {
import io.substrait.relation.ExtensionSingle;  
        "take",  
import org.apache.calcite.sql.SqlOperator;  
}
        FunctionMappings.s(SqlLibraryOperators.REGEXP_CONTAINS, "regex_match"),
        FunctionMappings.s(ToNumberFunctionAdapter.TONUMBER, "tonumber"),
        false,
        FunctionMappings.s(SpanBucketAdapter.LOCAL_SPAN_BUCKET_OP, "span_bucket"),
        }
            }  
    /** Wrapper's output column names from its Calcite row type. */
        FunctionMappings.s(SqlStdOperatorTable.RAND, "random"),
    private static Rel replaceInput(Rel wrapper, Rel newInput) {
    /**
        }
     *       {@code MemTable} by {@code BroadcastInjectionHandler} before plan execution.</li>  
        }  
            );  
     * subclassing here next to the op's declaration.
        SqlFunctionCategory.USER_DEFINED_FUNCTION,
        FunctionMappings.s(AggregateFunction.REDUCE_EVAL_OP, "reduce_eval"),  
 * compatible open source license.
        FunctionMappings.s(NumericConversionFunctionAdapter.MSTIME, "mstime"),  
