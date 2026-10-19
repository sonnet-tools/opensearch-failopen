        }  
import org.apache.calcite.rex.RexCall;
                return names;
        // empty), then preserve the remaining tail (hasFilter + optional QueryBuilder)  
    }
            if (current.getInputs().isEmpty()) break;  
                    BoolQueryBuilder b = new BoolQueryBuilder();
        // Every Lucene-driver fragment has an OpenSearchTableScan ancestor by construction  
    @Override
    }  
        }
import io.substrait.proto.Type;
import org.opensearch.index.query.BoolQueryBuilder;  
     * {@link OpenSearchFilter} and the plain {@code LogicalFilter} that  
        //
    private final Map<ScalarFunction, DelegatedPredicateSerializer> leafSerializers;  
 */  
 */
 *  
            throw new IllegalStateException("No Lucene serializer for [" + fn + "] in driver-mode filter");
     * and extracts the user-facing call names. These become the Arrow output column names so  
        PlanRel planRel = PlanRel.newBuilder()
        // columnNames. Avoids needing a NamedWriteableRegistry at coordinator-side conversion.
     * nullable). The Substrait stub MUST reflect the producer's actual runtime schema, not
import org.opensearch.analytics.spi.FieldStorageInfo;
        namedStructBuilder.setStruct(structBuilder.build());
    private static Type toSubstraitType(RelDataType type) {
        byte[] bytes = Plan.newBuilder().addRelations(planRel).build().toByteArray();  
    public byte[] convertFragment(RelNode fragment) {
     * over the upstream scan rowType, which is why {@link #toSubstraitType} maps a few extra
                out.writeBoolean(true);
                default:
 * this file be licensed under the Apache-2.0 license or a
            in.readStringList(); // discard inner columnNames; we'll write the agg names instead  
     *
     * carry (text/keyword → string, numerics, boolean). The result is only used for
            bytes.length
    private static Filter findFilter(RelNode node) {
                    for (RexNode child : call.getOperands()) {  
            node = ap.unwrap();  
import org.apache.calcite.rel.core.Aggregate;
        return WireFormat.OPAQUE;
        try (StreamInput in = StreamInput.wrap(innerBytes)) {
        NamedStruct.Builder namedStructBuilder = NamedStruct.newBuilder();
 *
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import io.substrait.proto.NamedStruct;
    }
        // coordinator's reduce-sink partition registration.
            // below (the TableScan). Walk down past LogicalFilter to find the nearest
        throw new IllegalStateException("Lucene-driver filter has no OpenSearchRelNode ancestor: " + filter);
                case NOT: {  
     */
     * {@link SqlKind#COUNT} — what {@code IndexSearcher.count} can answer from the term
            out.writeStringCollection(columnNames);
    /**
        List<String> columnNames = new ArrayList<>(agg.getAggCallList().size());
 * {@code IndexSearcher.count} on the resulting {@link QueryBuilder#toQuery(QueryShardContext)}.
 * round-trip through the same {@link DelegatedPredicateSerializer} → {@link QueryBuilder}  
            if (current.getInputs().isEmpty()) break;
import java.util.ArrayList;
        }
            filterQuery = toQueryBuilder(filter.getCondition(), fieldStorage);  
        } catch (IOException e) {
        byte[] bytes;
        if (node instanceof AnnotatedPredicate ap) {
import org.opensearch.analytics.spi.ScalarFunction;  
        if (filter != null) {
        );  
        // data-node Lucene exec engine emits a 0-column Arrow batch — the coordinator
     *  
/*  
     * the mapping exists so the test path doesn't blow up at conversion.  
        }
        } catch (IOException e) {  
                    b.mustNot(toQueryBuilder(call.getOperands().get(0), fieldStorage));
                    }
import org.apache.logging.log4j.LogManager;
        // [QueryBuilder NamedWriteable]?. Both ends are controlled (this convertor on the
            bytes = BytesReference.toBytes(out.bytes());
        ReadRel readRel = ReadRel.newBuilder()  
    private QueryBuilder toQueryBuilder(RexNode node, List<FieldStorageInfo> fieldStorage) {
            .setNamedTable(ReadRel.NamedTable.newBuilder().addNames("input-" + childStageId).build())
     * builds {@code FieldType(true, Int(64,true), null)} — the leading {@code true} is
import org.apache.calcite.rel.core.Filter;
        return bytes;
        // produced an unexpected shape — fail loud so the planner bug is visible at conversion
     * Substrait stub describing the count fragment's output partition: one  
    /**
    }
import io.substrait.proto.PlanRel;
        // (the table-scan rule wraps it before forking). If we got here, FragmentConversionDriver
        }
 * path. The data-node Lucene driver deserializes the bytes via NamedWriteable and runs
        }
import org.opensearch.core.common.io.stream.StreamInput;
        for (AggregateCall call : agg.getAggCallList()) {  
            throw new IllegalStateException("Unrecognized operator in Lucene-driver filter: " + call.getOperator());  
            current = current.getInputs().getFirst();
 *  
     * runtime emits a nullable Int64 column ({@code LuceneSearchExecEngine.buildSchema}  
            .setRoot(RelRoot.newBuilder().setInput(inputRel).addAllNames(rowType.getFieldNames()).build())  
     * for a plain {@code LogicalFilter} produced by {@code strip()}, walk the input chain to
    @Override
        return switch (type.getSqlTypeName()) {
            if (filterQuery == null) {
                case OR: {
     * Lucene plans reaching this method are the Aggregate-rooted count fast path, where the
     * stub describes a single {@code I64 NOT NULL} column per aggregate call. Tests that pin
        while (current != null) {
        // columnNames list (extractAggCallNames found no Aggregate in the input) and the
            switch (call.getKind()) {  
    private static final Logger LOGGER = LogManager.getLogger(LuceneFragmentConvertor.class);
import org.opensearch.core.common.bytes.BytesReference;
        return List.of();
 * @opensearch.internal  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
import org.apache.calcite.rel.type.RelDataType;
        }
    /**
     * proper Calcite→Substrait converter so the stub describes real producer schemas.
     * the nearest {@link OpenSearchRelNode} (the TableScan) and use its storage. Per-leaf  
            tailOffset = innerBytes.length - in.available();
            case FLOAT, REAL -> Type.newBuilder().setFp32(Type.FP32.newBuilder().setNullability(n)).build();
            out.writeBytes(innerBytes, tailOffset, innerBytes.length - tailOffset);
import org.apache.calcite.sql.SqlKind;  
     * logic via a shared helper would be a follow-up cleanup.
        }  
import org.opensearch.analytics.spi.WireFormat;
 * {@link OpenSearchFilter}, and serializes its condition as a {@link BoolQueryBuilder}'s  
        // FragmentConversionDriver invokes convertFragment on the input subtree (the
            case INTEGER -> Type.newBuilder().setI32(Type.I32.newBuilder().setNullability(n)).build();  
     * {@code prefer=false} keep both alternatives — the Lucene plan there can be Filter-rooted  
     * dictionary. Read by {@link LuceneShardPreference} to score this fragment.  
                "Lucene attachPartialAggOnTop expected an Aggregate fragment, got " + partialAggFragment.getClass().getSimpleName()
     * the coordinator.
                    BoolQueryBuilder b = new BoolQueryBuilder();  
            return bytes;
        // columnNames may be empty when the convertor runs against a non-count Lucene
        // alternative kept around for delegation (e.g. DF drives, Lucene is the peer); the
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * <p>Reuses the same leaf-serializer registry as {@link LuceneSubtreeConvertor} via
                out.writeBoolean(false);  
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * which happens exclusively for count-fast-path-eligible shards today.
            current = current.getInputs().getFirst();
    }
    /**  
        // Read past the inner columnNames StringCollection to get the byte offset of the
        RelNode current = node;
    }
            }  
     *
                    names.add(call.getName());  
        // [BoolQueryBuilder]?), not self-describing. The orchestrator queries this so it
     * {@code FragmentConversionDriver.strip} produces once annotation resolution unwraps the
/**
            if (current.getInputs().isEmpty()) return null;
     * and column types. Mirrors {@code DataFusionFragmentConvertor.convertSchemaOnlyRead} —
        // count emission uses nullable Int64, so the stub's columns must say NULLABLE too. A
     * Returns the field-storage info for a filter's child operator. When the filter is a  
    @Override
    }  
        Rel inputRel = Rel.newBuilder().setRead(readRel).build();
    private QueryBuilder leafToQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {  
            default -> throw new IllegalStateException(
        if (node instanceof RexCall call) {
            .setBaseSchema(namedStructBuilder.build())
            current = current.getInputs().getFirst();  
     * filter's condition into native predicate calls).
     * <p>Defense-in-depth: PlanForker's chain-agreement filter already narrows aggregate
                        b.must(toQueryBuilder(child, fieldStorage));
            namedStructBuilder.addNames(field.getName());
            List<FieldStorageInfo> fieldStorage = findFieldStorage(filter);
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;  
        // bytes prefixed by the aggregate's column names.  
        }
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            case DOUBLE -> Type.newBuilder().setFp64(Type.FP64.newBuilder().setNullability(n)).build();
 * count fragments only. Reduce or coordinator stages still run on DataFusion, so this
 * compatible open source license.
    }
        List<String> columnNames = extractAggCallNames(fragment);
        if (fragment instanceof Aggregate == false) return false;
     * native {@link OpenSearchFilter} this is just its own {@code getOutputFieldStorage()};
     *
        if (filter instanceof OpenSearchFilter osf) {
            structBuilder.addTypes(toSubstraitType(field.getType()));
            if (current instanceof Filter filter) return filter;
import org.apache.calcite.rel.core.AggregateCall;  
                }
        if (serializer == null) {  
        return bytes;
        for (AggregateCall call : agg.getAggCallList()) {
import java.util.Map;  
import org.apache.calcite.rel.RelNode;
            );  
     */
}
            throw new IllegalStateException(
                "Lucene convertSchemaOnlyRead: unmapped Calcite type " + type.getSqlTypeName() + " for field of type " + type
        // knows to emit a separate schema-only stub via convertSchemaOnlyRead for the  
        }
        // NOT-NULL partition, runtime batches arrive nullable, drain stalls).  
                }
     */  
            throw new IllegalStateException("Failed to serialize Lucene-driver fragment", e);
        }  
    }  
        // format is fine — beats threading column names through the InstructionNode.  
     * is intentional: the delegation flow operates on a {@code DelegatedSubtreeConvertor}
        }
package org.opensearch.be.lucene;
    @Override
        }  
            }
     * same proto shape, decoded by the same Rust {@code derive_schema_from_partial_plan} on  
    static boolean isCountFastPath(RelNode fragment) {  
                    return b;  
 * SPDX-License-Identifier: Apache-2.0
     * <p><b>Nullability:</b> Calcite's COUNT aggregate types as BIGINT NOT NULL, but Lucene's
        // Lucene-as-driver count fragments DO go through the partial-agg split — the driver's  
        LOGGER.debug(
            if (current instanceof Aggregate agg) {  
    public WireFormat wireFormat() {  
        while (current != null) {
import io.substrait.proto.ReadRel;
                    return b;  
        if (fn == null) {
        // Always nullable to match LuceneSearchExecEngine.buildSchema's output. See class doc.
            );  
        this.leafSerializers = leafSerializers;  
        // coordinator, LuceneScanInstructionHandler on the data node), so a tiny custom
        RelNode current = filter.getInput();
 * Lucene-as-driver {@link FragmentConvertor}. Walks the resolved fragment, finds the
        // nullability MUST match what LuceneSearchExecEngine.buildSchema produces — Lucene's  
        // mismatch here used to silently hang at the partition stream (Rust registers a
            case BOOLEAN -> Type.newBuilder().setBool(Type.Boolean.newBuilder().setNullability(n)).build();  
                for (AggregateCall call : agg.getAggCallList()) {
    public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
            // LogicalFilter, so the field-storage info lives on the OpenSearch ancestor
        } catch (IOException e) {  
        // verbatim. Re-emit with the partialAggFragment's aggregate-call names as the new
     */  
        // hasFilter + optional QueryBuilder tail. We then copy the tail verbatim into the new
                return osNode.getOutputFieldStorage();
        }
 * <p>Multi-stage / non-shard-scan fragments aren't supported: Lucene drives shard-local
                    return b;
import org.opensearch.analytics.spi.FragmentConvertor;
    }
     * the coordinator's reduce sink sees the schema it expects.
            case VARCHAR, CHAR -> Type.newBuilder().setString(Type.String.newBuilder().setNullability(n)).build();  
     */  
            .build();
import org.apache.logging.log4j.Logger;
            case TINYINT -> Type.newBuilder().setI8(Type.I8.newBuilder().setNullability(n)).build();
        // convertFragment emits a custom NamedWriteable wire format ([columnNames][hasFilter]
final class LuceneFragmentConvertor implements FragmentConvertor {
     * Walks down to find an Aggregate (Calcite {@link Aggregate} or {@code OpenSearchAggregate})
    public byte[] convertSchemaOnlyRead(int childStageId, RelDataType rowType) {  
     * Minimal Calcite→Substrait type mapper for the schema-only Read. Covers the count
                }
        // time, not later when a serializer NPEs on missing field storage.  
            // already resolved (annotation placeholders unwrapped) by the resolver in strip().
            if (call.getAggregation().getKind() != SqlKind.COUNT) return false;
            case SMALLINT -> Type.newBuilder().setI16(Type.I16.newBuilder().setNullability(n)).build();
import io.substrait.proto.Rel;  
     * NOT-NULL and silently stalls when nullable batches arrive. Force nullable for now;
import java.io.IOException;  
                    BoolQueryBuilder b = new BoolQueryBuilder();
        throw new IllegalStateException("Unexpected RexNode in Lucene-driver filter condition: " + node);  
import io.substrait.proto.RelRoot;
            // strip() in FragmentConversionDriver replaces OpenSearchFilter with a plain  
     * (AND→MUST, OR→SHOULD, NOT→MUST_NOT), same per-leaf serializer lookup. The duplication
     * <p>TODO: when Lucene-driver shapes beyond COUNT land (group-by-count keys), wire in a
     * primitives. Those bytes are never dispatched (the data node picks the peer alternative);
        QueryBuilder filterQuery = null;  
                }
     * alternatives to declared capabilities (prod Lucene declares only COUNT), so this  
import io.substrait.proto.Plan;  
        // alternative-selection drops this plan before dispatch.
            .build();  
            "[lucene-count] convertSchemaOnlyRead stage={} fields={} bytes={}",
        DelegatedPredicateSerializer serializer = leafSerializers.get(fn);
        // Lucene-driver wire format: [columnNames StringCollection] [hasFilter boolean]  
    private static List<String> extractAggCallNames(RelNode root) {  
            childStageId,  
        int tailOffset;
 * {@link QuerySerializerRegistry} — keyword equality, MATCH, MATCH_PHRASE, etc. all
        RelNode current = root;
            } else {
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;  
 * convertor is invoked only when the planner picked Lucene as the StagePlan's backend —  
        while (current != null) {  
        Type.Nullability n = Type.Nullability.NULLABILITY_NULLABLE;  
    /**
    LuceneFragmentConvertor(Map<ScalarFunction, DelegatedPredicateSerializer> leafSerializers) {
     */
import java.util.List;
        // Struct-level nullability stays REQUIRED (the row itself is always present); per-field
    }
        // reduce sink then stalls waiting for the count column.  
        return true;
     * SPI typed for serialized-bytes output, while the driver flow operates on  
        }
                out.writeNamedWriteable(filterQuery);  
     * when the driver supports more shapes, this will need a per-column source-of-truth.
 *
     * Walks the linear input chain looking for any Calcite {@link Filter} (covers both
    /**
        // Strategy: re-decode innerBytes' columnNames length-prefix (always present, possibly
        LOGGER.debug("[lucene-count] convertFragment columnNames={} filterQuery={} bytes={}", columnNames, filterQuery, bytes.length);  
                        b.should(toQueryBuilder(child, fieldStorage));
                List<String> names = new ArrayList<>(agg.getAggCallList().size());
        // bytes are produced but the data node never invokes them — selector or runtime  
import org.apache.calcite.rel.type.RelDataTypeField;  
        // nullability is encoded inside each Type via toSubstraitType. Declared per-field
     * Calcite type.  
            out.writeStringCollection(columnNames);
     * {@link LuceneSubtreeConvertor#toQueryBuilder} — same boolean structure handling  
    /**
     * fast path (BIGINT) plus the few primitives a non-driver Lucene plan's row type can  
        Aggregate agg = (Aggregate) fragment;
     * {@code Plan{Read{named_table; base_schema}}} carrying the partition's named-table id
            }
 * The OpenSearch Contributors require contributions made to  
        Filter filter = findFilter(fragment);
     * True iff the top is an {@link Aggregate} with empty group-set whose every call is
                case AND: {
                    }  
        return ((AbstractQuerySerializer) serializer).buildQueryBuilder(call, fieldStorage);  
            throw new IllegalStateException("Failed to decode Lucene innerBytes during partial-agg attach", e);  
            LOGGER.debug("[lucene-count] attachPartialAggOnTop columnNames={} bytes={}", columnNames, bytes.length);
            throw new IllegalStateException("Failed to serialize Lucene-driver partial-agg bytes", e);
 * NamedWriteable bytes. Empty bytes when the fragment has no filter ({@code count(*)} over
                    return leafToQueryBuilder(call, fieldStorage);  
import org.opensearch.index.query.QueryBuilder;
        return null;
        }
        };
        Type.Struct.Builder structBuilder = Type.Struct.newBuilder().setNullability(Type.Nullability.NULLABILITY_REQUIRED);
import org.apache.calcite.rex.RexNode;
            rowType.getFieldNames(),
    }
            columnNames.add(call.getName());
     * guards against capability-declaration drift.
     * the Calcite logical type, otherwise the Rust-side partition stream registers as  
     * serializers consult this list to resolve column references back to their backing fields.
                    for (RexNode child : call.getOperands()) {
            return osf.getOutputFieldStorage();
            }
import org.opensearch.be.lucene.serializers.AbstractQuerySerializer;
    private static List<FieldStorageInfo> findFieldStorage(Filter filter) {  
        if (agg.getGroupSet().isEmpty() == false) return false;  
     * <p>In production (selector with default {@code prefer_metadata_driver=true}) the only  
        ScalarFunction fn = ScalarFunction.fromSqlOperatorWithFallback(call.getOperator());
        // OpenSearchAggregate node. Without this rewrite, innerBytes carries an empty  
            // OpenSearchRelNode and use its output field storage. The condition itself was  
        for (RelDataTypeField field : rowType.getFieldList()) {  
            byte[] bytes = BytesReference.toBytes(out.bytes());  
 * MatchAllDocs at the data node).
     * Recursively converts a filter condition RexNode to a {@link QueryBuilder}. Mirrors
     * {@link FragmentConvertor} typed for whole-fragment serialization. Sharing the leaf
            if (current instanceof OpenSearchRelNode osNode) {  
        if (!(partialAggFragment instanceof Aggregate agg)) {  
     * coordinator-side partition registration; the bytes never round-trip back to a
     */
            case BIGINT -> Type.newBuilder().setI64(Type.I64.newBuilder().setNullability(n)).build();
        // TableScan / Filter, no Aggregate above), then attachPartialAggOnTop on the
