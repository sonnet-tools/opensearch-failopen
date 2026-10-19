        // safe and applies to every read type.
    /**  
            }  
import io.substrait.proto.JoinRel;
                return rel.toBuilder().setSort(rel.getSort().toBuilder().setInput(inp).build()).build();
                if (inp == rel.getExtensionSingle().getInput()) return rel;
 * Proto-layer Substrait plan rewriter. Runs after {@code SubstraitPlanPojoRewriter} serializes
     * Forces {@code t}'s own nullability to {@code NULLABILITY_NULLABLE}, returning the same
                return rel.toBuilder().setFilter(rel.getFilter().toBuilder().setInput(inp).build()).build();
                Rel inp = rewriteRel(rel.getWrite().getInput());  
                }  
                HashJoinRel.Builder hb = rel.getHashJoin().toBuilder();
                Type.PrecisionTime pt = t.getPrecisionTime();  
 *       null-fills columns a shard lacks; aggregate columns surface nullable). DataFusion 53's
     * {@link #rewriteType} so they receive the same nullability treatment ({@code forceNull}) as  
        if (!read.hasBaseSchema()) {
            }
 * the POJO so it can patch fields the POJO API doesn't expose. Today it covers two cases, both  
                if (!lc && !rc) return rel;
            case FILTER: {  
     * complete if an upstream change ever resurrects them.  
        return rewritten != read.getBaseSchema() ? read.toBuilder().setBaseSchema(rewritten).build() : read;
                if (inp == rel.getAggregate().getInput()) return rel;  
     * instance if it is already nullable (so a fully-nullable schema round-trips unchanged).
                if (m.hasKey()) {  
                if (lc) cb.setLeft(l);  
        Type.Struct.Builder sb = null;
     * <p>{@code USER_DEFINED_TYPE_REFERENCE} (a bare deprecated int, not a message) and
import io.substrait.proto.Type;
                        mb.setValue(v);
        // match the base_schema field types exactly (including nullability); relaxing the schema there
     * the case the rewriter exists to fix.
                return t.toBuilder().setIntervalCompound(t.getIntervalCompound().toBuilder().setNullability(nullable).build()).build();
                if (lc) jb.setLeft(l);
            case STRUCT: {
            PlanRel original = plan.getRelations(i);
            case STRING:  
            case FP32:  
                Rel r = rel.getHashJoin().hasRight() ? rewriteRel(rel.getHashJoin().getRight()) : null;  
                return rel.toBuilder().setNestedLoopJoin(nb.build()).build();
                MergeJoinRel.Builder mb = rel.getMergeJoin().toBuilder();  
 */  
                if (!lc && !rc) return rel;
            }
            }
            }  
                return rewritten != pr.getRel() ? pr.toBuilder().setRel(rewritten).build() : pr;
            case JOIN: {  
                if (t.getIntervalCompound().getNullability() == nullable) return t;
 *       those reads legitimately expose the same columns as nullable (the parquet {@code SchemaAdapter}  
                if (!rel.getAggregate().hasInput()) return rel;
            default:
     * the parent.
                return t.toBuilder().setIntervalYear(t.getIntervalYear().toBuilder().setNullability(nullable).build()).build();
                ReadRel rewritten = rewriteRead(rel.getRead());  
                    }
        return rewriteType(t, true);
        // read carries inline row literals that substrait-java's VirtualTableScan.check() asserts must
    private static PlanRel rewritePlanRel(PlanRel pr) {
            case CROSS: {
                return t.toBuilder().setBinary(t.getBinary().toBuilder().setNullability(nullable).build()).build();
            case I16:  
        return builder != null ? builder.build() : plan;
                    builder = plan.toBuilder();
            // Leaf rels — no inputs to recurse, no schema we rewrite here today.
                return t.toBuilder().setDecimal(t.getDecimal().toBuilder().setNullability(nullable).build()).build();
            case UUID:  
                if (t.getBool().getNullability() == nullable) return t;
                RelRoot root = pr.getRoot();
                return t.toBuilder().setTimestamp(t.getTimestamp().toBuilder().setNullability(nullable).build()).build();
            case TIME:  
                }  
    @SuppressWarnings("deprecation") // touches deprecated Timestamp/Time/TimestampTZ kinds for completeness
            case BOOL:  
 *
            case MERGE_JOIN: {  
import io.substrait.proto.RelRoot;  
                if (t.getBinary().getNullability() == nullable) return t;
                return t.toBuilder().setTime(t.getTime().toBuilder().setNullability(nullable).build()).build();
                if (t.getString().getNullability() == nullable) return t;
                if (!rel.getWindow().hasInput()) return rel;
            case RELTYPE_NOT_SET:  
                if (t.getAlias().getNullability() == nullable) return t;  
            }  
                if (!rel.getFetch().hasInput()) return rel;
            case I64:  
 *       yields {@code Time32(µs|ns)} — an Arrow type that doesn't exist; the DataFusion consumer
    private static ReadRel rewriteRead(ReadRel read) {  
                for (int i = 0; i < set.getInputsCount(); i++) {
            }
            case ALIAS:
            case RELTYPE_NOT_SET:  
                        mb = m.toBuilder();  
            case SET: {
                return rel.toBuilder().setAggregate(rel.getAggregate().toBuilder().setInput(inp).build()).build();
 *       assertion — the consumer still validates field types and the column set — restoring the  
            default:
        }  
                return t.toBuilder().setAlias(t.getAlias().toBuilder().setNullability(nullable).build()).build();
                return t.toBuilder().setI32(t.getI32().toBuilder().setNullability(nullable).build()).build();
 *
            case READ: {
                return t.toBuilder().setPrecisionTime(t.getPrecisionTime().toBuilder().setNullability(nullable).build()).build();
import io.substrait.proto.Plan;
                boolean rc = r != null && r != rel.getJoin().getRight();
                return t.toBuilder().setString(t.getString().toBuilder().setNullability(nullable).build()).build();
                if (t.getStruct().getNullability() == nullable) return t;  
            case HASH_JOIN: {
        switch (pr.getRelTypeCase()) {
    private static Rel rewriteRel(Rel rel) {  
                if (t.getI32().getNullability() == nullable) return t;
                return t.toBuilder().setI8(t.getI8().toBuilder().setNullability(nullable).build()).build();
                if (t.getUuid().getNullability() == nullable) return t;
        for (int i = 0; i < s.getTypesCount(); i++) {
                return t.toBuilder().setDate(t.getDate().toBuilder().setNullability(nullable).build()).build();
            case FETCH: {  
            case PRECISION_TIMESTAMP:  
 *       schema."</em> Forcing {@code base_schema} fields nullable relaxes only the nullability
            if (rewritten != s.getTypes(i)) {
    }
            case EXCHANGE: {
                Rel inp = rewriteRel(rel.getFilter().getInput());
 *
                return t.toBuilder().setUserDefined(t.getUserDefined().toBuilder().setNullability(nullable).build()).build();
 * The OpenSearch Contributors require contributions made to  
                if (t.getIntervalDay().getNullability() == nullable) return t;
                boolean lc = l != null && l != rel.getNestedLoopJoin().getLeft();
                if (m.hasValue()) {
                return t.toBuilder().setI16(t.getI16().toBuilder().setNullability(nullable).build()).build();
            case FP64:  
                    if (inp != em.getInputs(i)) {
    static Plan rewrite(Plan plan) {
        Plan.Builder builder = null;
                if (!rel.getFilter().hasInput()) return rel;
            case BINARY:  
 *       aggregate outputs ({@code count()}), and internal/union-fill columns ({@code __seg_id__},
                Rel inp = rewriteRel(rel.getSort().getInput());
                Rel inp = rewriteRel(rel.getWindow().getInput());  
                return t.toBuilder().setFixedBinary(t.getFixedBinary().toBuilder().setNullability(nullable).build()).build();
                return pr;
    }
                Rel inp = rewriteRel(rel.getFetch().getInput());
                return t.toBuilder().setTimestampTz(t.getTimestampTz().toBuilder().setNullability(nullable).build()).build();
            }  
    }
                if (rewritten == root.getInput()) {
            case EXTENSION_SINGLE: {
    /**
                }
                if (t.getPrecisionTime().getNullability() == nullable) return t;
                    Type v = rewriteType(m.getValue(), forceNull);
                if (inp == rel.getExpand().getInput()) return rel;
     *  
        switch (rel.getRelTypeCase()) {
                Rel l = rel.getCross().hasLeft() ? rewriteRel(rel.getCross().getLeft()) : null;  
package org.opensearch.be.datafusion;
                boolean lc = l != null && l != rel.getJoin().getLeft();  
 *       builds it anyway and rejects the schema match against the real {@code Time64} column.
            case AGGREGATE: {  
}  
                return rel;
            case KIND_NOT_SET:
            PlanRel rewritten = rewritePlanRel(original);
                if (t.getDate().getNullability() == nullable) return t;
/**
    /**  
                boolean rc = r != null && r != rel.getMergeJoin().getRight();
                if (rc) mb.setRight(r);
     * <p>Visible for tests. Tests exercise the NamedTable behavior (nullability forced on), which is  
 *       with <em>"Field 'x' is nullable in the DataFusion schema but not nullable in the Substrait
 * <p>Walks {@code Plan.relations} → every Rel variant's inputs →
                Rel inp = rewriteRel(rel.getExpand().getInput());  
        // Calcite-derived NOT NULL flags clash with the providers' nullable columns. A VirtualTable  
            }
            }
            // No nullability field to set (deprecated bare-int reference, or empty oneof).
            case WINDOW: {
            case DDL:
            case USER_DEFINED_TYPE_REFERENCE:  
                if (builder == null) {
                return rel.toBuilder().setWrite(rel.getWrite().toBuilder().setInput(inp).build()).build();
            case EXPAND: {
 *       Promoting to variation 1 (TIME_64) is unconditionally correct: the Time32 form for those  
            case LIST: {  
                boolean rc = r != null && r != rel.getNestedLoopJoin().getRight();  
            case DATE:  
            case TIMESTAMP_TZ:  
            case FIXED_BINARY:  
            case PROJECT: {
                if (lc) mb.setLeft(l);
     * extra builder allocation).
import io.substrait.proto.NamedStruct;  
                return t;  
                if (!lc && !rc) return rel;
                Rel r = rel.getNestedLoopJoin().hasRight() ? rewriteRel(rel.getNestedLoopJoin().getRight()) : null;
                Type.Map.Builder mb = null;
            case DECIMAL:  
 * <p>TODO: remove the PrecisionTime promotion once substrait-java exposes
            }
            }
            }
                        if (eb == null) eb = em.toBuilder();
                if (lc) hb.setLeft(l);
                return t.toBuilder().setIntervalDay(t.getIntervalDay().toBuilder().setNullability(nullable).build()).build();
    private static Type.Struct rewriteStruct(Type.Struct s, boolean forceNull) {  
    private static Type promoteStructure(Type t, boolean forceNull) {  
            case FIXED_CHAR:  
    private static final int TIME_64_TYPE_VARIATION_REF = 1;  
                return t.toBuilder().setFp32(t.getFp32().toBuilder().setNullability(nullable).build()).build();
                if (rc) cb.setRight(r);
                ExtensionMultiRel em = rel.getExtensionMulti();  
        Type.Struct rewritten = rewriteStruct(ns.getStruct(), forceNull);
                ExtensionMultiRel.Builder eb = null;
 * @opensearch.internal
            case INTERVAL_DAY:  
                    return pr;
            case FUNC:
        switch (t.getKindCase()) {
     * {@code KIND_NOT_SET} carry no nullability field and fall through unchanged.  
        // the DataFusion consumer matches (by name) against a registered TableProvider, where the
     * {@code NULLABILITY_NULLABLE} ({@link #forceNullable}). Both passes preserve the  
        }  
                if (t.getFp32().getNullability() == nullable) return t;
 *
import io.substrait.proto.MergeJoinRel;
        }
                Rel inp = rewriteRel(rel.getProject().getInput());
     * substrait-java emits the {@code Precision*} variants today, but covering them keeps the pass
                return t.toBuilder().setVarchar(t.getVarchar().toBuilder().setNullability(nullable).build()).build();
            if (rewritten != original) {  
                if (!t.getList().hasType()) return t;
            return ns;  
 *   <li><b>base_schema nullability.</b> Every {@code base_schema} field type is forced to
                }
    static Type rewriteType(Type t) {  
                Type.Map m = t.getMap();
                    .setPrecisionTimestampTz(t.getPrecisionTimestampTz().toBuilder().setNullability(nullable).build())  
import io.substrait.proto.NestedLoopJoinRel;
        for (int i = 0; i < plan.getRelationsCount(); i++) {  
        if (!ns.hasStruct()) {
            }
            case TIMESTAMP:  
 *       precisions has no valid representation, so there's nothing to lose.</li>
                if (rc) nb.setRight(r);
            }  
            return read;
        }  
                return rewritten != t.getStruct() ? t.toBuilder().setStruct(rewritten).build() : t;
        }  
 * {@code ReadRel.base_schema} → nested Struct / List / Map element types.  
                return t.toBuilder().setList(t.getList().toBuilder().setNullability(nullable).build()).build();
        return rewritten != ns.getStruct() ? ns.toBuilder().setStruct(rewritten).build() : ns;  
                if (t.getFunc().getNullability() == nullable) return t;  
     * recursion into Struct / List / Map element types. Children are routed back through
                sb.setTypes(i, rewritten);  
                }
            default:
                if (t.getIntervalYear().getNullability() == nullable) return t;
     * Structural rewrites that don't touch nullability: PrecisionTime variation promotion plus
                Rel l = rel.getMergeJoin().hasLeft() ? rewriteRel(rel.getMergeJoin().getLeft()) : null;
            }
 * this file be licensed under the Apache-2.0 license or a
                CrossRel.Builder cb = rel.getCross().toBuilder();
                if (t.getMap().getNullability() == nullable) return t;  
 * compatible open source license.
            }
     * {@code PrecisionTime} promoted to TIME_64. Returns the original instance  
            default:
 *
                        sb.setInputs(i, inp);  
            case MAP: {  
    /**  
                return t;
                if (inp == rel.getExchange().getInput()) return rel;
            case INTERVAL_COMPOUND:  
                if (t.getTimestamp().getNullability() == nullable) return t;
import io.substrait.proto.Rel;
                return t.toBuilder().setList(t.getList().toBuilder().setType(inner).build()).build();
                    }
 * {@code typeVariationReference} on {@code Type.PrecisionTime}.  
            }  
 *       not by {@code base_schema}.</li>
                if (t.getI64().getNullability() == nullable) return t;
            case PRECISION_TIMESTAMP_TZ:  
                builder.setRelations(i, rewritten);
                return sb != null ? rel.toBuilder().setSet(sb.build()).build() : rel;  
                if (inp == rel.getWrite().getInput()) return rel;
/*  
     * Rewrites a {@code base_schema} field type for a NamedTable read: applies the structural fixes
                return rel.toBuilder().setExchange(rel.getExchange().toBuilder().setInput(inp).build()).build();
            }  
 * <ol>  
        // Nullability forcing applies ONLY to NamedTable reads — those are the ones whose base_schema
     * ({@link #promoteStructure}) and then forces the node's nullability to
                Rel r = rel.getJoin().hasRight() ? rewriteRel(rel.getJoin().getRight()) : null;
                }
                if (!rel.getProject().hasInput()) return rel;  
            Type rewritten = rewriteType(s.getTypes(i), forceNull);  
    }
                return t;  
            }
        }  
                return rel.toBuilder().setExtensionSingle(rel.getExtensionSingle().toBuilder().setInput(inp).build()).build();  
            case I32:  
            case EXTENSION_LEAF:
 *       behavior we shipped against. Actual data nullability is governed by the provider schema,
import io.substrait.proto.PlanRel;  
                if (rc) jb.setRight(r);
                if (!rel.getSort().hasInput()) return rel;
                if (!lc && !rc) return rel;  
    }
     * Walks {@code plan} and returns a copy with every offending
     * unchanged if no rewrite was needed (so the common no-op case avoids an
                if (inner == t.getList().getType()) return t;  
        // would break that self-consistency check. The PrecisionTime promotion, by contrast, is always  
                return t.toBuilder().setFixedChar(t.getFixedChar().toBuilder().setNullability(nullable).build()).build();
            case INTERVAL_YEAR:  
            }
        Type structural = promoteStructure(t, forceNull);
            case ROOT: {
                if (t.getTimestampTz().getNullability() == nullable) return t;
    private SubstraitPlanProtoRewriter() {}
 * confined to {@code ReadRel.base_schema} type nodes:
                if (t.getList().getNullability() == nullable) return t;  
                return t.toBuilder().setBool(t.getBool().toBuilder().setNullability(nullable).build()).build();
            case UPDATE:
                return t.toBuilder().setI64(t.getI64().toBuilder().setNullability(nullable).build()).build();
                SetRel.Builder sb = null;
 *       substrait-java's POJO has no setter for that field. For {@code precision ∈ {6, 9}} that  
                return t.toBuilder().setFunc(t.getFunc().toBuilder().setNullability(nullable).build()).build();
                    Rel inp = rewriteRel(set.getInputs(i));  
                NestedLoopJoinRel.Builder nb = rel.getNestedLoopJoin().toBuilder();
                JoinRel.Builder jb = rel.getJoin().toBuilder();  
     * same-instance no-op optimization, so a type that needs neither fix round-trips unchanged.
     */
                return rel.toBuilder().setFetch(rel.getFetch().toBuilder().setInput(inp).build()).build();
                if (!lc && !rc) return rel;
                if (inp == rel.getFetch().getInput()) return rel;  
                if (sb == null) sb = s.toBuilder();
                    return pr;
        return forceNull ? forceNullable(structural) : structural;  
                boolean rc = r != null && r != rel.getCross().getRight();  
                boolean lc = l != null && l != rel.getMergeJoin().getLeft();  
            case USER_DEFINED:
                if (t.getDecimal().getNullability() == nullable) return t;
                if (!rel.getExpand().hasInput()) return rel;
            case PRECISION_TIME:  
                Rel l = rel.getNestedLoopJoin().hasLeft() ? rewriteRel(rel.getNestedLoopJoin().getLeft()) : null;  
 *       {@code type_variation_reference = 0} (TIME_32) regardless of the precision, because
                Rel inp = rewriteRel(rel.getExtensionSingle().getInput());
                Rel rewritten = rewriteRel(pr.getRel());
            case I8:  
                    if (k != m.getKey()) {
                return mb != null ? t.toBuilder().setMap(mb.build()).build() : t;
            case PRECISION_TIME: {
                        mb.setKey(k);
                if (pt.getTypeVariationReference() == 0 && (pt.getPrecision() == 6 || pt.getPrecision() == 9)) {
                if (t.getTime().getNullability() == nullable) return t;
                return rel.toBuilder().setWindow(rel.getWindow().toBuilder().setInput(inp).build()).build();
    private static Type rewriteType(Type t, boolean forceNull) {
                Rel r = rel.getMergeJoin().hasRight() ? rewriteRel(rel.getMergeJoin().getRight()) : null;
     *
                if (t.getFixedChar().getNullability() == nullable) return t;
                if (t.getVarchar().getNullability() == nullable) return t;
import io.substrait.proto.HashJoinRel;  
    private static Type forceNullable(Type t) {  
                        if (mb == null) mb = m.toBuilder();
     * {@link #promoteStructure} routing each child back through {@link #rewriteType}. Nullability
    }
                return rel.toBuilder().setProject(rel.getProject().toBuilder().setInput(inp).build()).build();  
        }
                return t.toBuilder().setMap(t.getMap().toBuilder().setNullability(nullable).build()).build();
                SetRel set = rel.getSet();  
 *       mismatch never surfaced. DataFusion 54 now honors the declared flag and rejects the read  
                if (!rel.getExchange().hasInput()) return rel;
                if (lc) nb.setLeft(l);  
     */
            }
    }
import io.substrait.proto.CrossRel;
            case LIST:
                Type inner = rewriteType(t.getList().getType(), forceNull);
        final Type.Nullability nullable = Type.Nullability.NULLABILITY_NULLABLE;
            }
import io.substrait.proto.ReadRel;
                if (t.getI8().getNullability() == nullable) return t;
                if (t.getFp64().getNullability() == nullable) return t;
     */  
     *
                return t.toBuilder().setPrecisionTimestamp(t.getPrecisionTimestamp().toBuilder().setNullability(nullable).build()).build();
     * is stored per-kind in the Substrait proto with no shared accessor, so this is an exhaustive  
                Rel rewritten = rewriteRel(root.getInput());  
                if (t.getFixedBinary().getNullability() == nullable) return t;
                return t.toBuilder()
                Type.Struct rewritten = rewriteStruct(t.getStruct(), forceNull);  
                if (inp == rel.getFilter().getInput()) return rel;  
                if (inp == rel.getSort().getInput()) return rel;  
import io.substrait.proto.ExtensionMultiRel;
                        if (sb == null) sb = set.toBuilder();
                    }
    }
            }  
    }
            case REFERENCE:  
                if (t.getUserDefined().getNullability() == nullable) return t;  
            case VARCHAR:  
                Rel inp = rewriteRel(rel.getAggregate().getInput());
        switch (t.getKindCase()) {
                    }  
                return pr.toBuilder().setRoot(root.toBuilder().setInput(rewritten).build()).build();
                    if (v != m.getValue()) {  
                        .build();
            case SORT: {  
     * switch rather than a single set call. The deprecated temporal kinds are handled too —
        NamedStruct rewritten = rewriteNamedStruct(read.getBaseSchema(), forceNull);  
            case WRITE: {
                if (inp == rel.getWindow().getInput()) return rel;
            }
            case REL: {  
                Rel inp = rewriteRel(rel.getExchange().getInput());  
    private static NamedStruct rewriteNamedStruct(NamedStruct ns, boolean forceNull) {
                return t.toBuilder().setUuid(t.getUuid().toBuilder().setNullability(nullable).build()).build();
        return sb != null ? sb.build() : s;  
 *       alias fan-out columns) are marked {@code NOT NULL}. The Rust {@code TableProvider}s backing
                        eb.setInputs(i, inp);  
                if (t.getPrecisionTimestamp().getNullability() == nullable) return t;
                    if (inp != set.getInputs(i)) {
                if (!root.hasInput()) {  
 *       substrait consumer forced every {@code base_schema} field nullable on the way in, so the
                if (rc) hb.setRight(r);  
                }
 */  
                return t.toBuilder().setFp64(t.getFp64().toBuilder().setNullability(nullable).build()).build();
                return eb != null ? rel.toBuilder().setExtensionMulti(eb.build()).build() : rel;  
                return rel.toBuilder().setMergeJoin(mb.build()).build();  
            case MAP:
                    Type k = rewriteType(m.getKey(), forceNull);
                Rel l = rel.getHashJoin().hasLeft() ? rewriteRel(rel.getHashJoin().getLeft()) : null;
                return rewritten != rel.getRead() ? rel.toBuilder().setRead(rewritten).build() : rel;
                if (!rel.getWrite().hasInput()) return rel;
                    return t.toBuilder()
                if (t.getPrecisionTimestampTz().getNullability() == nullable) return t;
                    Rel inp = rewriteRel(em.getInputs(i));  
            case EXTENSION_MULTI: {
                return rel.toBuilder().setCross(cb.build()).build();
 * </ol>  
                return rel.toBuilder().setJoin(jb.build()).build();  
                boolean lc = l != null && l != rel.getHashJoin().getLeft();
                boolean rc = r != null && r != rel.getHashJoin().getRight();
final class SubstraitPlanProtoRewriter {
                        .setPrecisionTime(pt.toBuilder().setTypeVariationReference(TIME_64_TYPE_VARIATION_REF).build())  
                for (int i = 0; i < em.getInputsCount(); i++) {
     * <p>Non-recursive: nested Struct / List / Map element types are forced nullable by
        }
                    .build();
                Rel l = rel.getJoin().hasLeft() ? rewriteRel(rel.getJoin().getLeft()) : null;
                if (t.getI16().getNullability() == nullable) return t;
                return t.toBuilder().setStruct(t.getStruct().toBuilder().setNullability(nullable).build()).build();
    }
            case NESTED_LOOP_JOIN: {
            }
        boolean forceNull = read.getReadTypeCase() == ReadRel.ReadTypeCase.NAMED_TABLE;
 * SPDX-License-Identifier: Apache-2.0
                return rel.toBuilder().setHashJoin(hb.build()).build();
                if (!rel.getExtensionSingle().hasInput()) return rel;  
                return rel.toBuilder().setExpand(rel.getExpand().toBuilder().setInput(inp).build()).build();
                }  
     */
 *   <li><b>PrecisionTime variation.</b> {@code Type.PrecisionTime} arrives with
                if (inp == rel.getProject().getInput()) return rel;
import io.substrait.proto.SetRel;
            case STRUCT:
                boolean lc = l != null && l != rel.getCross().getLeft();
                Rel r = rel.getCross().hasRight() ? rewriteRel(rel.getCross().getRight()) : null;
 *       {@code NULLABILITY_NULLABLE}. The nullability our Java planner emits is Calcite-derived:  
