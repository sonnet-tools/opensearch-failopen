            case DECIMAL:
                return t.toBuilder().setI16(t.getI16().toBuilder().setNullability(nullable).build()).build();
        if (!ns.hasStruct()) {
                if (!root.hasInput()) {
            case DATE:
            }
        // Calcite-derived NOT NULL flags clash with the providers' nullable columns. A VirtualTable
        }
            }
 *
            }
        switch (t.getKindCase()) {
                return t.toBuilder().setString(t.getString().toBuilder().setNullability(nullable).build()).build();
            case EXCHANGE: {
                if (t.getIntervalYear().getNullability() == nullable) return t;
                if (t.getUuid().getNullability() == nullable) return t;
                SetRel set = rel.getSet();
            case LIST:
    }
            case STRUCT:
                        sb.setInputs(i, inp);
                if (t.getIntervalDay().getNullability() == nullable) return t;
            case CROSS: {
                return t;
                boolean rc = r != null && r != rel.getMergeJoin().getRight();
            case EXTENSION_LEAF:
                        eb.setInputs(i, inp);
     * the case the rewriter exists to fix.
                if (t.getI8().getNullability() == nullable) return t;
        Plan.Builder builder = null;
 * </ol>
 */
 *       schema."</em> Forcing {@code base_schema} fields nullable relaxes only the nullability
                return rel.toBuilder().setWindow(rel.getWindow().toBuilder().setInput(inp).build()).build();
            case WRITE: {
                    }
        }
                boolean rc = r != null && r != rel.getNestedLoopJoin().getRight();
                RelRoot root = pr.getRoot();
     * <p>{@code USER_DEFINED_TYPE_REFERENCE} (a bare deprecated int, not a message) and
                if (lc) mb.setLeft(l);
                if (!rel.getFilter().hasInput()) return rel;
                return t.toBuilder().setFixedChar(t.getFixedChar().toBuilder().setNullability(nullable).build()).build();
            case TIMESTAMP:
            case DDL:
                return t.toBuilder().setIntervalDay(t.getIntervalDay().toBuilder().setNullability(nullable).build()).build();
                return rel.toBuilder().setSort(rel.getSort().toBuilder().setInput(inp).build()).build();
        }
                return rel.toBuilder().setFetch(rel.getFetch().toBuilder().setInput(inp).build()).build();
                    .setPrecisionTimestampTz(t.getPrecisionTimestampTz().toBuilder().setNullability(nullable).build())
                return t.toBuilder().setTime(t.getTime().toBuilder().setNullability(nullable).build()).build();
                CrossRel.Builder cb = rel.getCross().toBuilder();
        return sb != null ? sb.build() : s;
                Rel inp = rewriteRel(rel.getExtensionSingle().getInput());
        return rewriteType(t, true);
                MergeJoinRel.Builder mb = rel.getMergeJoin().toBuilder();
            case TIME:
 *       substrait consumer forced every {@code base_schema} field nullable on the way in, so the
 *       Promoting to variation 1 (TIME_64) is unconditionally correct: the Time32 form for those
import io.substrait.proto.Plan;
                }
     * {@link #promoteStructure} routing each child back through {@link #rewriteType}. Nullability
     * recursion into Struct / List / Map element types. Children are routed back through
                    }
        return rewritten != read.getBaseSchema() ? read.toBuilder().setBaseSchema(rewritten).build() : read;
                if (t.getDecimal().getNullability() == nullable) return t;
import io.substrait.proto.JoinRel;
            case EXPAND: {
 *       aggregate outputs ({@code count()}), and internal/union-fill columns ({@code __seg_id__},
import io.substrait.proto.SetRel;
        Type.Struct rewritten = rewriteStruct(ns.getStruct(), forceNull);
                return rel.toBuilder().setProject(rel.getProject().toBuilder().setInput(inp).build()).build();
                return t.toBuilder().setUuid(t.getUuid().toBuilder().setNullability(nullable).build()).build();
                        .build();
 *   <li><b>PrecisionTime variation.</b> {@code Type.PrecisionTime} arrives with
 *       behavior we shipped against. Actual data nullability is governed by the provider schema,
                if (t.getFixedBinary().getNullability() == nullable) return t;
            case PRECISION_TIMESTAMP_TZ:
     * Walks {@code plan} and returns a copy with every offending
            case MAP: {
                if (inp == rel.getExtensionSingle().getInput()) return rel;
 * <ol>
        }
                JoinRel.Builder jb = rel.getJoin().toBuilder();
        Type structural = promoteStructure(t, forceNull);
     *
                if (inp == rel.getWrite().getInput()) return rel;
                return t.toBuilder().setFp32(t.getFp32().toBuilder().setNullability(nullable).build()).build();
            case READ: {
import io.substrait.proto.PlanRel;
                        .setPrecisionTime(pt.toBuilder().setTypeVariationReference(TIME_64_TYPE_VARIATION_REF).build())
     * Rewrites a {@code base_schema} field type for a NamedTable read: applies the structural fixes
    }
                return pr.toBuilder().setRoot(root.toBuilder().setInput(rewritten).build()).build();
                if (rc) hb.setRight(r);
                Type.Struct rewritten = rewriteStruct(t.getStruct(), forceNull);
 *       substrait-java's POJO has no setter for that field. For {@code precision ∈ {6, 9}} that
    private static NamedStruct rewriteNamedStruct(NamedStruct ns, boolean forceNull) {
     * same-instance no-op optimization, so a type that needs neither fix round-trips unchanged.
            case EXTENSION_SINGLE: {
            }
 * @opensearch.internal
                Rel inp = rewriteRel(rel.getWrite().getInput());
            case INTERVAL_DAY:
        for (int i = 0; i < plan.getRelationsCount(); i++) {
     * instance if it is already nullable (so a fully-nullable schema round-trips unchanged).
                Rel inp = rewriteRel(rel.getFetch().getInput());
                return t.toBuilder().setI8(t.getI8().toBuilder().setNullability(nullable).build()).build();
            case LIST: {
     * Structural rewrites that don't touch nullability: PrecisionTime variation promotion plus
                    }
            }
 *       {@code type_variation_reference = 0} (TIME_32) regardless of the precision, because
import io.substrait.proto.NestedLoopJoinRel;
 * {@code typeVariationReference} on {@code Type.PrecisionTime}.
                HashJoinRel.Builder hb = rel.getHashJoin().toBuilder();
                Rel l = rel.getNestedLoopJoin().hasLeft() ? rewriteRel(rel.getNestedLoopJoin().getLeft()) : null;
        switch (rel.getRelTypeCase()) {
            }
                }
     *
                if (t.getFp32().getNullability() == nullable) return t;
                if (inp == rel.getProject().getInput()) return rel;
            case PRECISION_TIME:
                Type inner = rewriteType(t.getList().getType(), forceNull);
        Type.Struct.Builder sb = null;
 *       null-fills columns a shard lacks; aggregate columns surface nullable). DataFusion 53's
        switch (pr.getRelTypeCase()) {
            }
                return t.toBuilder().setDecimal(t.getDecimal().toBuilder().setNullability(nullable).build()).build();
            case PROJECT: {
                if (!rel.getExpand().hasInput()) return rel;
import io.substrait.proto.MergeJoinRel;
                return rel.toBuilder().setAggregate(rel.getAggregate().toBuilder().setInput(inp).build()).build();
 * SPDX-License-Identifier: Apache-2.0
            case WINDOW: {
                }
        boolean forceNull = read.getReadTypeCase() == ReadRel.ReadTypeCase.NAMED_TABLE;
            }
    private static Type promoteStructure(Type t, boolean forceNull) {
                if (m.hasValue()) {
 * Proto-layer Substrait plan rewriter. Runs after {@code SubstraitPlanPojoRewriter} serializes
     * extra builder allocation).
                    Rel inp = rewriteRel(set.getInputs(i));
                        mb = m.toBuilder();
                        if (sb == null) sb = set.toBuilder();
                Type.Map m = t.getMap();
            }
                    if (k != m.getKey()) {
                    Type k = rewriteType(m.getKey(), forceNull);
                Rel inp = rewriteRel(rel.getAggregate().getInput());
     */
                return t;
                Rel r = rel.getHashJoin().hasRight() ? rewriteRel(rel.getHashJoin().getRight()) : null;
                if (!rel.getProject().hasInput()) return rel;
                Rel r = rel.getMergeJoin().hasRight() ? rewriteRel(rel.getMergeJoin().getRight()) : null;
 *
    private static Rel rewriteRel(Rel rel) {
                if (t.getTimestampTz().getNullability() == nullable) return t;
        }
     * {@code KIND_NOT_SET} carry no nullability field and fall through unchanged.
                Rel inp = rewriteRel(rel.getExpand().getInput());
            case REL: {
                if (!rel.getWrite().hasInput()) return rel;
        return rewritten != ns.getStruct() ? ns.toBuilder().setStruct(rewritten).build() : ns;
                Rel l = rel.getCross().hasLeft() ? rewriteRel(rel.getCross().getLeft()) : null;
    /**
                if (inner == t.getList().getType()) return t;
                ReadRel rewritten = rewriteRead(rel.getRead());
     */
                return rel.toBuilder().setExpand(rel.getExpand().toBuilder().setInput(inp).build()).build();
    /**
            case FILTER: {
            PlanRel rewritten = rewritePlanRel(original);
                return t.toBuilder().setBinary(t.getBinary().toBuilder().setNullability(nullable).build()).build();
    private static PlanRel rewritePlanRel(PlanRel pr) {
        if (!read.hasBaseSchema()) {
            }
    /**
                if (!rel.getSort().hasInput()) return rel;
/**
            }
                for (int i = 0; i < set.getInputsCount(); i++) {
                Rel inp = rewriteRel(rel.getWindow().getInput());
                boolean lc = l != null && l != rel.getMergeJoin().getLeft();
                if (!lc && !rc) return rel;
                return t.toBuilder().setIntervalYear(t.getIntervalYear().toBuilder().setNullability(nullable).build()).build();
                }
        final Type.Nullability nullable = Type.Nullability.NULLABILITY_NULLABLE;
            return read;
                if (t.getVarchar().getNullability() == nullable) return t;
                if (t.getString().getNullability() == nullable) return t;
                Rel rewritten = rewriteRel(pr.getRel());
                return t;
                if (t.getTime().getNullability() == nullable) return t;
    }
     */
    @SuppressWarnings("deprecation") // touches deprecated Timestamp/Time/TimestampTZ kinds for completeness
    private static Type forceNullable(Type t) {
                if (t.getAlias().getNullability() == nullable) return t;
                if (t.getPrecisionTime().getNullability() == nullable) return t;
                if (t.getI16().getNullability() == nullable) return t;
                if (rc) cb.setRight(r);
            }
     * is stored per-kind in the Substrait proto with no shared accessor, so this is an exhaustive
            case USER_DEFINED:
                return rewritten != t.getStruct() ? t.toBuilder().setStruct(rewritten).build() : t;
     * {@code NULLABILITY_NULLABLE} ({@link #forceNullable}). Both passes preserve the
                    if (inp != set.getInputs(i)) {
            case EXTENSION_MULTI: {
                Rel inp = rewriteRel(rel.getSort().getInput());
                boolean lc = l != null && l != rel.getCross().getLeft();
            case FUNC:
            case RELTYPE_NOT_SET:
            case INTERVAL_YEAR:
    private static Type rewriteType(Type t, boolean forceNull) {
     *
        // Nullability forcing applies ONLY to NamedTable reads — those are the ones whose base_schema
                Type.PrecisionTime pt = t.getPrecisionTime();
import io.substrait.proto.HashJoinRel;
                if (!rel.getWindow().hasInput()) return rel;
                if (inp == rel.getFilter().getInput()) return rel;
        }
 *
     * complete if an upstream change ever resurrects them.
    }
                return t.toBuilder()
                boolean rc = r != null && r != rel.getJoin().getRight();
            default:
                return rewritten != rel.getRead() ? rel.toBuilder().setRead(rewritten).build() : rel;
 *       builds it anyway and rejects the schema match against the real {@code Time64} column.
                return rel;
            case TIMESTAMP_TZ:
                if (!t.getList().hasType()) return t;
     * Forces {@code t}'s own nullability to {@code NULLABILITY_NULLABLE}, returning the same
            case JOIN: {
                if (t.getUserDefined().getNullability() == nullable) return t;
                return t.toBuilder().setMap(t.getMap().toBuilder().setNullability(nullable).build()).build();
import io.substrait.proto.Rel;
                        mb.setValue(v);
        for (int i = 0; i < s.getTypesCount(); i++) {
                if (!rel.getAggregate().hasInput()) return rel;
                boolean rc = r != null && r != rel.getCross().getRight();
 * The OpenSearch Contributors require contributions made to
                    builder = plan.toBuilder();
}
                if (t.getI32().getNullability() == nullable) return t;
            }
                return rel.toBuilder().setExchange(rel.getExchange().toBuilder().setInput(inp).build()).build();
/*
 *       {@code NULLABILITY_NULLABLE}. The nullability our Java planner emits is Calcite-derived:
            Type rewritten = rewriteType(s.getTypes(i), forceNull);
                Rel l = rel.getJoin().hasLeft() ? rewriteRel(rel.getJoin().getLeft()) : null;
                return t.toBuilder().setI64(t.getI64().toBuilder().setNullability(nullable).build()).build();
     * <p>Non-recursive: nested Struct / List / Map element types are forced nullable by
        return forceNull ? forceNullable(structural) : structural;
 *       not by {@code base_schema}.</li>
        switch (t.getKindCase()) {
            case FP64:
            case SET: {
            }
                if (t.getIntervalCompound().getNullability() == nullable) return t;
                    .build();
            case REFERENCE:
                if (rewritten == root.getInput()) {
            }
            }
            case MAP:
import io.substrait.proto.RelRoot;
                return t.toBuilder().setTimestampTz(t.getTimestampTz().toBuilder().setNullability(nullable).build()).build();
                Rel l = rel.getMergeJoin().hasLeft() ? rewriteRel(rel.getMergeJoin().getLeft()) : null;
 * confined to {@code ReadRel.base_schema} type nodes:
        // safe and applies to every read type.
     * <p>Visible for tests. Tests exercise the NamedTable behavior (nullability forced on), which is
final class SubstraitPlanProtoRewriter {
import io.substrait.proto.ReadRel;
 *       those reads legitimately expose the same columns as nullable (the parquet {@code SchemaAdapter}
                return t.toBuilder().setFixedBinary(t.getFixedBinary().toBuilder().setNullability(nullable).build()).build();
                if (inp == rel.getWindow().getInput()) return rel;
                if (!lc && !rc) return rel;
            case BINARY:
                if (rc) nb.setRight(r);
            // No nullability field to set (deprecated bare-int reference, or empty oneof).
                if (rc) mb.setRight(r);
                Rel l = rel.getHashJoin().hasLeft() ? rewriteRel(rel.getHashJoin().getLeft()) : null;
                if (lc) cb.setLeft(l);
                if (inp == rel.getExpand().getInput()) return rel;
     * the parent.
import io.substrait.proto.NamedStruct;
    }
            case ROOT: {
            default:
                Rel r = rel.getJoin().hasRight() ? rewriteRel(rel.getJoin().getRight()) : null;
                Rel r = rel.getCross().hasRight() ? rewriteRel(rel.getCross().getRight()) : null;
        }
                Type.Map.Builder mb = null;
                boolean lc = l != null && l != rel.getNestedLoopJoin().getLeft();
            case UUID:
                return t.toBuilder().setVarchar(t.getVarchar().toBuilder().setNullability(nullable).build()).build();
 *       alias fan-out columns) are marked {@code NOT NULL}. The Rust {@code TableProvider}s backing
                if (lc) hb.setLeft(l);
    }
        // would break that self-consistency check. The PrecisionTime promotion, by contrast, is always
                if (sb == null) sb = s.toBuilder();
            case FIXED_CHAR:
 * compatible open source license.
            case I64:
            }
                if (rc) jb.setRight(r);
            case FETCH: {
                return mb != null ? t.toBuilder().setMap(mb.build()).build() : t;
 * <p>Walks {@code Plan.relations} → every Rel variant's inputs →
        // match the base_schema field types exactly (including nullability); relaxing the schema there
                if (t.getPrecisionTimestampTz().getNullability() == nullable) return t;
            if (rewritten != s.getTypes(i)) {
                return t.toBuilder().setFp64(t.getFp64().toBuilder().setNullability(nullable).build()).build();
                    }
            case KIND_NOT_SET:
                    return pr;
                    Rel inp = rewriteRel(em.getInputs(i));
                return t.toBuilder().setI32(t.getI32().toBuilder().setNullability(nullable).build()).build();
                return rel.toBuilder().setMergeJoin(mb.build()).build();
 * this file be licensed under the Apache-2.0 license or a
                ExtensionMultiRel.Builder eb = null;
            }
                if (t.getBool().getNullability() == nullable) return t;
                sb.setTypes(i, rewritten);
                return t.toBuilder().setIntervalCompound(t.getIntervalCompound().toBuilder().setNullability(nullable).build()).build();
                if (!lc && !rc) return rel;
            case PRECISION_TIME: {
                if (inp == rel.getSort().getInput()) return rel;
     * ({@link #promoteStructure}) and then forces the node's nullability to
                if (t.getBinary().getNullability() == nullable) return t;
            }
                    Type v = rewriteType(m.getValue(), forceNull);
                return t.toBuilder().setPrecisionTime(t.getPrecisionTime().toBuilder().setNullability(nullable).build()).build();
                return t.toBuilder().setList(t.getList().toBuilder().setType(inner).build()).build();
                return t.toBuilder().setFunc(t.getFunc().toBuilder().setNullability(nullable).build()).build();
                return eb != null ? rel.toBuilder().setExtensionMulti(eb.build()).build() : rel;
                if (!rel.getExtensionSingle().hasInput()) return rel;
            case ALIAS:
import io.substrait.proto.ExtensionMultiRel;
    private SubstraitPlanProtoRewriter() {}
                return t.toBuilder().setDate(t.getDate().toBuilder().setNullability(nullable).build()).build();
            case NESTED_LOOP_JOIN: {
            case FIXED_BINARY:
                if (!rel.getFetch().hasInput()) return rel;
            case PRECISION_TIMESTAMP:
    private static Type.Struct rewriteStruct(Type.Struct s, boolean forceNull) {
                if (t.getFixedChar().getNullability() == nullable) return t;
                    return pr;
     */
    private static ReadRel rewriteRead(ReadRel read) {
            }
                return t.toBuilder().setPrecisionTimestamp(t.getPrecisionTimestamp().toBuilder().setNullability(nullable).build()).build();
            case RELTYPE_NOT_SET:
package org.opensearch.be.datafusion;
                for (int i = 0; i < em.getInputsCount(); i++) {
                if (inp == rel.getExchange().getInput()) return rel;
 *       precisions has no valid representation, so there's nothing to lose.</li>
                if (lc) jb.setLeft(l);
    }
                NestedLoopJoinRel.Builder nb = rel.getNestedLoopJoin().toBuilder();
            case VARCHAR:
                    return t.toBuilder()
            }
            case SORT: {
                SetRel.Builder sb = null;
            return ns;
    private static final int TIME_64_TYPE_VARIATION_REF = 1;
                Rel inp = rewriteRel(rel.getExchange().getInput());
                if (lc) nb.setLeft(l);
                return t.toBuilder().setAlias(t.getAlias().toBuilder().setNullability(nullable).build()).build();
                return rel.toBuilder().setFilter(rel.getFilter().toBuilder().setInput(inp).build()).build();
        return builder != null ? builder.build() : plan;
                }
                if (!rel.getExchange().hasInput()) return rel;
            case BOOL:
                }
 * {@code ReadRel.base_schema} → nested Struct / List / Map element types.
            case STRUCT: {
    }
            }
     * substrait-java emits the {@code Precision*} variants today, but covering them keeps the pass
                if (t.getFp64().getNullability() == nullable) return t;
            }
        // the DataFusion consumer matches (by name) against a registered TableProvider, where the
                return t.toBuilder().setTimestamp(t.getTimestamp().toBuilder().setNullability(nullable).build()).build();
            default:
                if (t.getTimestamp().getNullability() == nullable) return t;
                if (inp == rel.getFetch().getInput()) return rel;
            case HASH_JOIN: {
                return rel.toBuilder().setExtensionSingle(rel.getExtensionSingle().toBuilder().setInput(inp).build()).build();
            }
                if (t.getStruct().getNullability() == nullable) return t;
                if (t.getFunc().getNullability() == nullable) return t;
                        if (eb == null) eb = em.toBuilder();
            }
                builder.setRelations(i, rewritten);
     * {@link #rewriteType} so they receive the same nullability treatment ({@code forceNull}) as
                return pr;
     * switch rather than a single set call. The deprecated temporal kinds are handled too —
    static Plan rewrite(Plan plan) {
            case I8:
                Rel rewritten = rewriteRel(root.getInput());
                if (!lc && !rc) return rel;
                boolean lc = l != null && l != rel.getJoin().getLeft();
                ExtensionMultiRel em = rel.getExtensionMulti();
    }
            case FP32:
        // read carries inline row literals that substrait-java's VirtualTableScan.check() asserts must
                boolean rc = r != null && r != rel.getHashJoin().getRight();
        }
                return rel.toBuilder().setNestedLoopJoin(nb.build()).build();
     * unchanged if no rewrite was needed (so the common no-op case avoids an
    /**
 *
            }
                if (t.getMap().getNullability() == nullable) return t;
     * {@code PrecisionTime} promoted to TIME_64. Returns the original instance
                }
 *
 *   <li><b>base_schema nullability.</b> Every {@code base_schema} field type is forced to
            case USER_DEFINED_TYPE_REFERENCE:
            case UPDATE:
                if (t.getPrecisionTimestamp().getNullability() == nullable) return t;
                if (inp == rel.getAggregate().getInput()) return rel;
                        if (mb == null) mb = m.toBuilder();
                return rel.toBuilder().setHashJoin(hb.build()).build();
    static Type rewriteType(Type t) {
 *       yields {@code Time32(µs|ns)} — an Arrow type that doesn't exist; the DataFusion consumer
            default:
                if (t.getI64().getNullability() == nullable) return t;
                }
                if (m.hasKey()) {
            if (rewritten != original) {
                return t.toBuilder().setUserDefined(t.getUserDefined().toBuilder().setNullability(nullable).build()).build();
 * <p>TODO: remove the PrecisionTime promotion once substrait-java exposes
                Rel inp = rewriteRel(rel.getProject().getInput());
                if (pt.getTypeVariationReference() == 0 && (pt.getPrecision() == 6 || pt.getPrecision() == 9)) {
            case I32:
                return t.toBuilder().setList(t.getList().toBuilder().setNullability(nullable).build()).build();
            case AGGREGATE: {
                return rewritten != pr.getRel() ? pr.toBuilder().setRel(rewritten).build() : pr;
 * the POJO so it can patch fields the POJO API doesn't expose. Today it covers two cases, both
    }
            case INTERVAL_COMPOUND:
                return rel.toBuilder().setCross(cb.build()).build();
                    if (v != m.getValue()) {
import io.substrait.proto.Type;
 */
                return sb != null ? rel.toBuilder().setSet(sb.build()).build() : rel;
            case I16:
                        mb.setKey(k);
                return rel.toBuilder().setWrite(rel.getWrite().toBuilder().setInput(inp).build()).build();
                if (t.getList().getNullability() == nullable) return t;
        NamedStruct rewritten = rewriteNamedStruct(read.getBaseSchema(), forceNull);
                if (builder == null) {
                return rel.toBuilder().setJoin(jb.build()).build();
                boolean lc = l != null && l != rel.getHashJoin().getLeft();
            PlanRel original = plan.getRelations(i);
                return t.toBuilder().setStruct(t.getStruct().toBuilder().setNullability(nullable).build()).build();
            // Leaf rels — no inputs to recurse, no schema we rewrite here today.
import io.substrait.proto.CrossRel;
                    if (inp != em.getInputs(i)) {
                Rel inp = rewriteRel(rel.getFilter().getInput());
                if (!lc && !rc) return rel;
                return t.toBuilder().setBool(t.getBool().toBuilder().setNullability(nullable).build()).build();
 *       mismatch never surfaced. DataFusion 54 now honors the declared flag and rejects the read
 *       assertion — the consumer still validates field types and the column set — restoring the
                Rel r = rel.getNestedLoopJoin().hasRight() ? rewriteRel(rel.getNestedLoopJoin().getRight()) : null;
                if (t.getDate().getNullability() == nullable) return t;
            case STRING:
 *       with <em>"Field 'x' is nullable in the DataFusion schema but not nullable in the Substrait
            case MERGE_JOIN: {
