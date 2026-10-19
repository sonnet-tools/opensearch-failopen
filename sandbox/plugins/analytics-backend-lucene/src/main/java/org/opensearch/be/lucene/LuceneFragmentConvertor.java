            case VARCHAR, CHAR -> Type.newBuilder().setString(Type.String.newBuilder().setNullability(n)).build();
            // already resolved (annotation placeholders unwrapped) by the resolver in strip().
final class LuceneFragmentConvertor implements FragmentConvertor {
        // data-node Lucene exec engine emits a 0-column Arrow batch — the coordinator
            if (call.getAggregation().getKind() != SqlKind.COUNT) return false;
    static boolean isCountFastPath(RelNode fragment) {
    }
        // convertFragment emits a custom NamedWriteable wire format ([columnNames][hasFilter]
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        // Every Lucene-driver fragment has an OpenSearchTableScan ancestor by construction
     * over the upstream scan rowType, which is why {@link #toSubstraitType} maps a few extra
        // (the table-scan rule wraps it before forking). If we got here, FragmentConversionDriver
        byte[] bytes;
/*
        // OpenSearchAggregate node. Without this rewrite, innerBytes carries an empty
            return bytes;
 * <p>Reuses the same leaf-serializer registry as {@link LuceneSubtreeConvertor} via
    }
        if (fragment instanceof Aggregate == false) return false;
     * guards against capability-declaration drift.
                    }
        }
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
    @Override
    }
     * {@code Plan{Read{named_table; base_schema}}} carrying the partition's named-table id
import java.io.IOException;
     * Walks down to find an Aggregate (Calcite {@link Aggregate} or {@code OpenSearchAggregate})
package org.opensearch.be.lucene;
import org.apache.calcite.sql.SqlKind;
     * {@link SqlKind#COUNT} — what {@code IndexSearcher.count} can answer from the term
                    for (RexNode child : call.getOperands()) {
        List<String> columnNames = extractAggCallNames(fragment);
     * Recursively converts a filter condition RexNode to a {@link QueryBuilder}. Mirrors
 * this file be licensed under the Apache-2.0 license or a
        return switch (type.getSqlTypeName()) {
     */
    }
                    return b;
            bytes.length
            );
                    return leafToQueryBuilder(call, fieldStorage);
                    return b;
    private static List<FieldStorageInfo> findFieldStorage(Filter filter) {
        // [BoolQueryBuilder]?), not self-describing. The orchestrator queries this so it
            if (current.getInputs().isEmpty()) break;
     * coordinator-side partition registration; the bytes never round-trip back to a
            default -> throw new IllegalStateException(
 * {@code IndexSearcher.count} on the resulting {@link QueryBuilder#toQuery(QueryShardContext)}.
            if (current instanceof Filter filter) return filter;
        return null;
            case BIGINT -> Type.newBuilder().setI64(Type.I64.newBuilder().setNullability(n)).build();
        // hasFilter + optional QueryBuilder tail. We then copy the tail verbatim into the new
            bytes = BytesReference.toBytes(out.bytes());
    public byte[] convertSchemaOnlyRead(int childStageId, RelDataType rowType) {
                    return b;
        try (StreamInput in = StreamInput.wrap(innerBytes)) {
     *
        }
     * SPI typed for serialized-bytes output, while the driver flow operates on
        namedStructBuilder.setStruct(structBuilder.build());
            case TINYINT -> Type.newBuilder().setI8(Type.I8.newBuilder().setNullability(n)).build();
        ScalarFunction fn = ScalarFunction.fromSqlOperatorWithFallback(call.getOperator());
     *
import org.apache.logging.log4j.Logger;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        return true;
     * is intentional: the delegation flow operates on a {@code DelegatedSubtreeConvertor}
    private QueryBuilder leafToQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
import java.util.Map;
                }
 * {@link QuerySerializerRegistry} — keyword equality, MATCH, MATCH_PHRASE, etc. all
        throw new IllegalStateException("Unexpected RexNode in Lucene-driver filter condition: " + node);
 * which happens exclusively for count-fast-path-eligible shards today.
            case SMALLINT -> Type.newBuilder().setI16(Type.I16.newBuilder().setNullability(n)).build();
            case DOUBLE -> Type.newBuilder().setFp64(Type.FP64.newBuilder().setNullability(n)).build();
        // bytes prefixed by the aggregate's column names.
     * logic via a shared helper would be a follow-up cleanup.
            }
     * the coordinator.
 * convertor is invoked only when the planner picked Lucene as the StagePlan's backend —
            throw new IllegalStateException("Failed to decode Lucene innerBytes during partial-agg attach", e);
     * proper Calcite→Substrait converter so the stub describes real producer schemas.
import org.opensearch.index.query.BoolQueryBuilder;
            "[lucene-count] convertSchemaOnlyRead stage={} fields={} bytes={}",
                    BoolQueryBuilder b = new BoolQueryBuilder();
        Aggregate agg = (Aggregate) fragment;
     * runtime emits a nullable Int64 column ({@code LuceneSearchExecEngine.buildSchema}
                    names.add(call.getName());
                }
import io.substrait.proto.Rel;
            switch (call.getKind()) {
import io.substrait.proto.PlanRel;
    }
        if (agg.getGroupSet().isEmpty() == false) return false;
    }
     * (AND→MUST, OR→SHOULD, NOT→MUST_NOT), same per-leaf serializer lookup. The duplication
            case FLOAT, REAL -> Type.newBuilder().setFp32(Type.FP32.newBuilder().setNullability(n)).build();
            current = current.getInputs().getFirst();
 * compatible open source license.
        }
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
    private static Type toSubstraitType(RelDataType type) {
                }
    }
                return names;
}
            if (filterQuery == null) {
            byte[] bytes = BytesReference.toBytes(out.bytes());
     * nullable). The Substrait stub MUST reflect the producer's actual runtime schema, not
import org.opensearch.analytics.spi.FieldStorageInfo;
import java.util.List;
    }
            // OpenSearchRelNode and use its output field storage. The condition itself was
            // strip() in FragmentConversionDriver replaces OpenSearchFilter with a plain
        }
        if (filter instanceof OpenSearchFilter osf) {
import org.apache.calcite.rel.core.Aggregate;
            List<FieldStorageInfo> fieldStorage = findFieldStorage(filter);
        // Struct-level nullability stays REQUIRED (the row itself is always present); per-field
     * True iff the top is an {@link Aggregate} with empty group-set whose every call is
        while (current != null) {
        // [QueryBuilder NamedWriteable]?. Both ends are controlled (this convertor on the
     */
     */
        }
            }
import org.opensearch.core.common.io.stream.StreamInput;
 *
    public WireFormat wireFormat() {
    /**
        // reduce sink then stalls waiting for the count column.
            current = current.getInputs().getFirst();
     * when the driver supports more shapes, this will need a per-column source-of-truth.
        // TableScan / Filter, no Aggregate above), then attachPartialAggOnTop on the
        }
                    }
 * MatchAllDocs at the data node).
        LOGGER.debug("[lucene-count] convertFragment columnNames={} filterQuery={} bytes={}", columnNames, filterQuery, bytes.length);
            in.readStringList(); // discard inner columnNames; we'll write the agg names instead
    @Override
        RelNode current = filter.getInput();
            }
        if (fn == null) {
            throw new IllegalStateException("Failed to serialize Lucene-driver partial-agg bytes", e);
     * {@link FragmentConvertor} typed for whole-fragment serialization. Sharing the leaf
                out.writeNamedWriteable(filterQuery);
        if (filter != null) {
            .setRoot(RelRoot.newBuilder().setInput(inputRel).addAllNames(rowType.getFieldNames()).build())
     * and column types. Mirrors {@code DataFusionFragmentConvertor.convertSchemaOnlyRead} —
        NamedStruct.Builder namedStructBuilder = NamedStruct.newBuilder();
                for (AggregateCall call : agg.getAggCallList()) {
        // count emission uses nullable Int64, so the stub's columns must say NULLABLE too. A
        }
     * Calcite type.
        // coordinator's reduce-sink partition registration.
import org.apache.calcite.rel.type.RelDataType;
     * builds {@code FieldType(true, Int(64,true), null)} — the leading {@code true} is
 *
import io.substrait.proto.NamedStruct;
 *
    LuceneFragmentConvertor(Map<ScalarFunction, DelegatedPredicateSerializer> leafSerializers) {
        // bytes are produced but the data node never invokes them — selector or runtime
            if (current instanceof OpenSearchRelNode osNode) {
        // FragmentConversionDriver invokes convertFragment on the input subtree (the
        }
        // Always nullable to match LuceneSearchExecEngine.buildSchema's output. See class doc.
import org.opensearch.common.io.stream.BytesStreamOutput;
            structBuilder.addTypes(toSubstraitType(field.getType()));
     * {@link LuceneSubtreeConvertor#toQueryBuilder} — same boolean structure handling
        };
            .setNamedTable(ReadRel.NamedTable.newBuilder().addNames("input-" + childStageId).build())
    public byte[] convertFragment(RelNode fragment) {
            throw new IllegalStateException("Failed to serialize Lucene-driver fragment", e);
                "Lucene attachPartialAggOnTop expected an Aggregate fragment, got " + partialAggFragment.getClass().getSimpleName()
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.analytics.spi.FragmentConvertor;
        RelNode current = node;
    }
            columnNames.add(call.getName());
 * round-trip through the same {@link DelegatedPredicateSerializer} → {@link QueryBuilder}
     * {@code prefer=false} keep both alternatives — the Lucene plan there can be Filter-rooted
        DelegatedPredicateSerializer serializer = leafSerializers.get(fn);
    /**
        // empty), then preserve the remaining tail (hasFilter + optional QueryBuilder)
import org.opensearch.analytics.spi.ScalarFunction;
     * the nearest {@link OpenSearchRelNode} (the TableScan) and use its storage. Per-leaf
        return bytes;
            }
     * same proto shape, decoded by the same Rust {@code derive_schema_from_partial_plan} on
            current = current.getInputs().getFirst();
        // Lucene-driver wire format: [columnNames StringCollection] [hasFilter boolean]
                        b.should(toQueryBuilder(child, fieldStorage));
     * native {@link OpenSearchFilter} this is just its own {@code getOutputFieldStorage()};
        // Lucene-as-driver count fragments DO go through the partial-agg split — the driver's
        this.leafSerializers = leafSerializers;
        ReadRel readRel = ReadRel.newBuilder()
import org.apache.calcite.rex.RexCall;
 * count fragments only. Reduce or coordinator stages still run on DataFusion, so this
import org.apache.calcite.rex.RexNode;
     * serializers consult this list to resolve column references back to their backing fields.
     *
            node = ap.unwrap();
import io.substrait.proto.RelRoot;
        for (RelDataTypeField field : rowType.getFieldList()) {
            rowType.getFieldNames(),
 * Lucene-as-driver {@link FragmentConvertor}. Walks the resolved fragment, finds the
        // produced an unexpected shape — fail loud so the planner bug is visible at conversion
 */
import org.opensearch.be.lucene.serializers.AbstractQuerySerializer;
    }
     * stub describes a single {@code I64 NOT NULL} column per aggregate call. Tests that pin
     * the Calcite logical type, otherwise the Rust-side partition stream registers as
        return bytes;
                case NOT: {
import io.substrait.proto.Plan;
            tailOffset = innerBytes.length - in.available();
 *
     * for a plain {@code LogicalFilter} produced by {@code strip()}, walk the input chain to
     * alternatives to declared capabilities (prod Lucene declares only COUNT), so this
/**
        if (node instanceof AnnotatedPredicate ap) {
import org.apache.calcite.rel.core.AggregateCall;
        } catch (IOException e) {
        }
            out.writeBytes(innerBytes, tailOffset, innerBytes.length - tailOffset);
            // LogicalFilter, so the field-storage info lives on the OpenSearch ancestor
import org.apache.calcite.rel.type.RelDataTypeField;
        // mismatch here used to silently hang at the partition stream (Rust registers a
     */
 * NamedWriteable bytes. Empty bytes when the fragment has no filter ({@code count(*)} over
import org.apache.calcite.rel.RelNode;
            if (current.getInputs().isEmpty()) break;
        QueryBuilder filterQuery = null;
     * <p>Defense-in-depth: PlanForker's chain-agreement filter already narrows aggregate
                List<String> names = new ArrayList<>(agg.getAggCallList().size());
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            childStageId,
        if (node instanceof RexCall call) {
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            out.writeStringCollection(columnNames);
        // nullability MUST match what LuceneSearchExecEngine.buildSchema produces — Lucene's
    /**
    /**
import java.util.ArrayList;
        }
                return osNode.getOutputFieldStorage();
 * {@link OpenSearchFilter}, and serializes its condition as a {@link BoolQueryBuilder}'s
                out.writeBoolean(true);
     * NOT-NULL and silently stalls when nullable batches arrive. Force nullable for now;
     * primitives. Those bytes are never dispatched (the data node picks the peer alternative);
        }
    /**
 * path. The data-node Lucene driver deserializes the bytes via NamedWriteable and runs
     */
        // format is fine — beats threading column names through the InstructionNode.
 * SPDX-License-Identifier: Apache-2.0
    }
                    b.mustNot(toQueryBuilder(call.getOperands().get(0), fieldStorage));
        return List.of();
                }
     * Substrait stub describing the count fragment's output partition: one
        while (current != null) {
                        b.must(toQueryBuilder(child, fieldStorage));
     * Walks the linear input chain looking for any Calcite {@link Filter} (covers both
 * @opensearch.internal
    @Override
            if (current instanceof Aggregate agg) {
        return WireFormat.OPAQUE;
        // alternative-selection drops this plan before dispatch.
    /**
        // alternative kept around for delegation (e.g. DF drives, Lucene is the peer); the
            if (current.getInputs().isEmpty()) return null;
 * <p>Multi-stage / non-shard-scan fragments aren't supported: Lucene drives shard-local
import io.substrait.proto.Type;
        }
                case AND: {
                "Lucene convertSchemaOnlyRead: unmapped Calcite type " + type.getSqlTypeName() + " for field of type " + type
import org.opensearch.analytics.spi.WireFormat;
        }
    public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
            case INTEGER -> Type.newBuilder().setI32(Type.I32.newBuilder().setNullability(n)).build();
    private static Filter findFilter(RelNode node) {
    private QueryBuilder toQueryBuilder(RexNode node, List<FieldStorageInfo> fieldStorage) {
    private static final Logger LOGGER = LogManager.getLogger(LuceneFragmentConvertor.class);
        Rel inputRel = Rel.newBuilder().setRead(readRel).build();
            return osf.getOutputFieldStorage();
        Filter filter = findFilter(fragment);
     */
import org.apache.logging.log4j.LogManager;
        Type.Nullability n = Type.Nullability.NULLABILITY_NULLABLE;
     * Lucene plans reaching this method are the Aggregate-rooted count fast path, where the
     * fast path (BIGINT) plus the few primitives a non-driver Lucene plan's row type can
            } else {
     *
            // below (the TableScan). Walk down past LogicalFilter to find the nearest
     * Minimal Calcite→Substrait type mapper for the schema-only Read. Covers the count
            throw new IllegalStateException(
            throw new IllegalStateException("No Lucene serializer for [" + fn + "] in driver-mode filter");
        //
            .build();
        LOGGER.debug(
     * filter's condition into native predicate calls).
     */
            LOGGER.debug("[lucene-count] attachPartialAggOnTop columnNames={} bytes={}", columnNames, bytes.length);
            throw new IllegalStateException("Unrecognized operator in Lucene-driver filter: " + call.getOperator());
        byte[] bytes = Plan.newBuilder().addRelations(planRel).build().toByteArray();
        // knows to emit a separate schema-only stub via convertSchemaOnlyRead for the
        while (current != null) {
        } catch (IOException e) {
        );
        }
        // Read past the inner columnNames StringCollection to get the byte offset of the
     * <p>In production (selector with default {@code prefer_metadata_driver=true}) the only
        Type.Struct.Builder structBuilder = Type.Struct.newBuilder().setNullability(Type.Nullability.NULLABILITY_REQUIRED);
            .setBaseSchema(namedStructBuilder.build())
        // columnNames. Avoids needing a NamedWriteableRegistry at coordinator-side conversion.
     * {@link OpenSearchFilter} and the plain {@code LogicalFilter} that
 * The OpenSearch Contributors require contributions made to
        if (serializer == null) {
 */
            filterQuery = toQueryBuilder(filter.getCondition(), fieldStorage);
     * <p><b>Nullability:</b> Calcite's COUNT aggregate types as BIGINT NOT NULL, but Lucene's
    /**
        return ((AbstractQuerySerializer) serializer).buildQueryBuilder(call, fieldStorage);
        throw new IllegalStateException("Lucene-driver filter has no OpenSearchRelNode ancestor: " + filter);
import org.opensearch.core.common.bytes.BytesReference;
                case OR: {
            );
                out.writeBoolean(false);
        // time, not later when a serializer NPEs on missing field storage.
                default:
        for (AggregateCall call : agg.getAggCallList()) {
                    BoolQueryBuilder b = new BoolQueryBuilder();
            namedStructBuilder.addNames(field.getName());
     * Returns the field-storage info for a filter's child operator. When the filter is a
        if (!(partialAggFragment instanceof Aggregate agg)) {
        int tailOffset;
    private final Map<ScalarFunction, DelegatedPredicateSerializer> leafSerializers;
                    for (RexNode child : call.getOperands()) {
        }
        }
     * the coordinator's reduce sink sees the schema it expects.
     * and extracts the user-facing call names. These become the Arrow output column names so
        } catch (IOException e) {
        RelNode current = root;
        // NOT-NULL partition, runtime batches arrive nullable, drain stalls).
    }
        // nullability is encoded inside each Type via toSubstraitType. Declared per-field
     * {@code FragmentConversionDriver.strip} produces once annotation resolution unwraps the
        List<String> columnNames = new ArrayList<>(agg.getAggCallList().size());
import io.substrait.proto.ReadRel;
        // Strategy: re-decode innerBytes' columnNames length-prefix (always present, possibly
        // columnNames may be empty when the convertor runs against a non-count Lucene
            out.writeStringCollection(columnNames);
     * dictionary. Read by {@link LuceneShardPreference} to score this fragment.
    private static List<String> extractAggCallNames(RelNode root) {
    @Override
        for (AggregateCall call : agg.getAggCallList()) {
     * the mapping exists so the test path doesn't blow up at conversion.
        PlanRel planRel = PlanRel.newBuilder()
        // coordinator, LuceneScanInstructionHandler on the data node), so a tiny custom
        // columnNames list (extractAggCallNames found no Aggregate in the input) and the
     * <p>TODO: when Lucene-driver shapes beyond COUNT land (group-by-count keys), wire in a
     * carry (text/keyword → string, numerics, boolean). The result is only used for
                    BoolQueryBuilder b = new BoolQueryBuilder();
import org.apache.calcite.rel.core.Filter;
        // verbatim. Re-emit with the partialAggFragment's aggregate-call names as the new
            .build();
            case BOOLEAN -> Type.newBuilder().setBool(Type.Boolean.newBuilder().setNullability(n)).build();
