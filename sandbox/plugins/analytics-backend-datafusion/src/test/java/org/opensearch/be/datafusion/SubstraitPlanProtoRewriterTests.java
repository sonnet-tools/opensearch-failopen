            )
            .setBaseSchema(
        // must end up nullable.
        assertEquals(0, after.getPrecisionTime().getTypeVariationReference());
    }
                            .addTypes(makePrecisionTime(3, 0))
    }
    }
    public void testLeavesVariation1Alone() {
                    .addTypes(i64(Type.Nullability.NULLABILITY_NULLABLE))
                Type.Map.newBuilder()
        // No PrecisionTime to promote and nullability forcing is skipped for VirtualTable, so the
            .setBaseSchema(
 * The OpenSearch Contributors require contributions made to
    private static Type i64(Type.Nullability nullability) {
        // The PrecisionTime promotion is independent of nullability and must still apply to a
            tm.getPrecisionTime().getNullability()
        Type rewritten = SubstraitPlanProtoRewriter.rewriteType(mapType);
            .setList(
        ReadRel read = ReadRel.newBuilder()
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
            "Map value forced nullable",
            .setVirtualTable(ReadRel.VirtualTable.newBuilder().build())
    }
    public void testFullPlanRewriteThroughReadRel() {
        assertEquals("Map forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getMap().getNullability());
        // Build a minimal Plan { relations: [Read { base_schema: Struct { types: [PrecisionTime(9, 0)] } }] }
        assertEquals(
 */
    }
    // the type variation). A non-nullable build would be rewritten by the nullability pass alone.
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
                NamedStruct.newBuilder()
}
    public void testLeavesVariation0Precision0Alone() {
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
            )
public class SubstraitPlanProtoRewriterTests extends OpenSearchTestCase {
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
 * compatible open source license.
/**
            "List element forced nullable",
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
        assertEquals("Map key forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getMap().getKey().getI64().getNullability());
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
    }
            after.getList().getType().getI64().getNullability()
        assertEquals("List element type promoted", 1, rewritten.getList().getType().getPrecisionTime().getTypeVariationReference());
        assertEquals("Variation promoted to 1 (TIME_64)", 1, after.getPrecisionTime().getTypeVariationReference());
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
                    .setValue(i64(Type.Nullability.NULLABILITY_REQUIRED))
            .build();
    public void testForcesNullabilityOnListElement() {
    }
                NamedStruct.newBuilder()
        );
                Type.List.newBuilder()
    public void testForcesRequiredScalarToNullable() {
                    .addTypes(i64(Type.Nullability.NULLABILITY_REQUIRED))
        // Outer struct REQUIRED, one REQUIRED child and one already-nullable child: every level
            .setVirtualTable(ReadRel.VirtualTable.newBuilder().build())
        assertNotSame("Struct rewritten because inner type changed", structType, rewritten);
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
    private static Type makePrecisionTime(int precision, int variationReference) {
        assertEquals("Precision still 9", 9, rewrittenType.getPrecisionTime().getPrecision());
        Type tm = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
            .setBaseSchema(
    public void testPromotesVariation0Precision9() {
            .setMap(Type.Map.newBuilder().setKey(makePrecisionTime(9, 0)).setValue(makePrecisionTime(6, 0)).build())
    }
 * through unchanged.
                    .setNullability(Type.Nullability.NULLABILITY_REQUIRED)
            Type.Nullability.NULLABILITY_NULLABLE,
    }
        assertEquals(
 *
        Type before = i64(Type.Nullability.NULLABILITY_NULLABLE);
        // A VirtualTable (inline VALUES) read carries row literals that substrait-java's
                    .setStruct(Type.Struct.newBuilder().addTypes(i64(Type.Nullability.NULLABILITY_REQUIRED)).build())
        Type after = SubstraitPlanProtoRewriter.rewriteType(listType);
        assertEquals("i64 forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getI64().getNullability());
            Type.Nullability.NULLABILITY_NULLABLE,
                    .build()
            .setBaseSchema(
        Type before = makePrecisionTime(3, 0);
        Type before = makePrecisionTime(0, 0);
        assertTrue("Type should still be PrecisionTime", after.hasPrecisionTime());
    public void testForcesNullabilityOnStructAndChildren() {
    }
            .setStruct(
            )
        Type c = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
    public void testRecursesIntoStruct() {
    // ── nullability forcing ──────────────────────────────────────────────
        assertEquals("Map key promoted", 1, rewritten.getMap().getKey().getPrecisionTime().getTypeVariationReference());
                    .setStruct(Type.Struct.newBuilder().addTypes(i64(Type.Nullability.NULLABILITY_REQUIRED)).build())
            )
    }
        assertEquals(6, after.getPrecisionTime().getPrecision());
 * this file be licensed under the Apache-2.0 license or a
    }
    // Builds a nullable PrecisionTime so promotion-focused tests stay no-ops under the
            )
        );
    }
            .build();
    }
        Type before = i64(Type.Nullability.NULLABILITY_UNSPECIFIED);
                    .addNames("tm")
import io.substrait.proto.Plan;
        assertEquals("base_schema field 'c' forced nullable", Type.Nullability.NULLABILITY_NULLABLE, c.getI64().getNullability());
            Type.Nullability.NULLABILITY_NULLABLE,
        assertEquals(
    }
        Type structType = Type.newBuilder()
        Type rewritten = SubstraitPlanProtoRewriter.rewriteType(structType);
        Plan plan = Plan.newBuilder().addRelations(planRel).build();
        assertSame(before, after);
    public void testVirtualTableBaseSchemaNullabilityPreserved() {
                Type.PrecisionTime.newBuilder()
                    .setNullability(Type.Nullability.NULLABILITY_REQUIRED)
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
        ReadRel read = ReadRel.newBuilder()
            .build();
    public void testFullPlanForcesNamedTableBaseSchemaNullability() {
    public void testForcesUnspecifiedScalarToNullable() {
import org.opensearch.test.OpenSearchTestCase;
    public void testAlreadyNullableScalarReturnsSameInstance() {
        assertEquals("i64 forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getI64().getNullability());
        // VirtualTableScan.check() asserts must match the base_schema types EXACTLY, including
        // irrelevant to it, so an empty VirtualTable is sufficient to exercise the skip branch.
        Type before = i64(Type.Nullability.NULLABILITY_REQUIRED);
            .setMap(
                    .addNames("c")
        // A plan whose base_schema is already nullable (makePrecisionTime builds nullable) and has
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
        assertSame("Already-nullable type is a no-op", before, after);
        // VirtualTable read, even though nullability is left alone.
import io.substrait.proto.ReadRel;
        Type v = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
    public void testRecursesIntoList() {
                    .build()
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
    }
                    .setType(i64(Type.Nullability.NULLABILITY_REQUIRED))
            )
        assertEquals("PrecisionTime in ReadRel.base_schema promoted", 1, rewrittenType.getPrecisionTime().getTypeVariationReference());
                    .addNames("tm")
        return Type.newBuilder().setI64(Type.I64.newBuilder().setNullability(nullability).build()).build();
            .build();
        assertEquals(1, after.getPrecisionTime().getTypeVariationReference());
            "VirtualTable PrecisionTime nullability preserved (makePrecisionTime is nullable)",
    }
        Type listType = Type.newBuilder().setList(Type.List.newBuilder().setType(makePrecisionTime(9, 0)).build()).build();
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
            )
    }
                    .build()
                Type.Struct.newBuilder()
        // consumer's nullability check against the (nullable) TableProvider schema passes.
        // column 'c' must be relaxed to nullable through the full rewrite() entry point so the DF54
import io.substrait.proto.Type;
            .build();
        ReadRel read = ReadRel.newBuilder()
                    .setStruct(Type.Struct.newBuilder().addTypes(makePrecisionTime(9, 0)).build())
        );
            .setNamedTable(ReadRel.NamedTable.newBuilder().addNames("input-1").build())
        // no offending PrecisionTime should round-trip the same instance.
                    .addTypes(makePrecisionTime(3, 0)) // should be left alone
            )
        assertEquals("Map value promoted", 1, rewritten.getMap().getValue().getPrecisionTime().getTypeVariationReference());
        // nullability. The rewriter must NOT relax nullability here, or that assertion fails with
                    )
                NamedStruct.newBuilder()
/*
                    .setNullability(Type.Nullability.NULLABILITY_NULLABLE)
        Type before = makePrecisionTime(6, 0);
            .build();
    }
        assertSame("No-op when precision is legal for Time32", before, after);
        ReadRel read = ReadRel.newBuilder()
        assertEquals("Second inner type unchanged", 0, rewritten.getStruct().getTypes(1).getPrecisionTime().getTypeVariationReference());
                    .setStruct(
                    .setTypeVariationReference(variationReference)
        assertSame("No-op rewrite returns same instance", plan, rewritten);
        return Type.newBuilder()
                NamedStruct.newBuilder()
        Type after = SubstraitPlanProtoRewriter.rewriteType(structType);
            after.getStruct().getTypes(0).getI64().getNullability()
        Type listType = Type.newBuilder()
        assertEquals("Precision preserved", 9, after.getPrecisionTime().getPrecision());
        assertEquals("PrecisionTime promoted even for VirtualTable", 1, tm.getPrecisionTime().getTypeVariationReference());
            )
        // base_schema-vs-provider nullability check passes.
            .build();
 */
            .build();
                    .setNullability(Type.Nullability.NULLABILITY_REQUIRED)
package org.opensearch.be.datafusion;
            .setStruct(
    public void testRecursesIntoMap() {
                            .setNullability(Type.Nullability.NULLABILITY_NULLABLE)
 * Unit tests for {@link SubstraitPlanProtoRewriter} — verifies that PrecisionTime
    public void testNoOpReturnsSameInstance() {
                NamedStruct.newBuilder()
                            .build()
        // "Row field type ... does not match schema field type ...". A NOT NULL field must survive.
        assertEquals("VirtualTable base_schema nullability preserved", Type.Nullability.NULLABILITY_REQUIRED, v.getI64().getNullability());
                        Type.Struct.newBuilder()
        // and confirm rewrite() promotes the PrecisionTime in the read's base schema.
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
        Type after = SubstraitPlanProtoRewriter.rewriteType(mapType);
 * are promoted to variation 1 (TIME_64), while other PrecisionTime values pass
        // Time32(Millisecond) is legal — must not be promoted.
        // Time32(Second) is legal — must not be promoted.
                    .setKey(i64(Type.Nullability.NULLABILITY_REQUIRED))
        assertEquals(0, after.getPrecisionTime().getTypeVariationReference());
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
    }
    public void testForcesNullabilityOnMapKeyAndValue() {
        ReadRel read = ReadRel.newBuilder()
        Rel rel = Rel.newBuilder().setRead(read).build();
        );
                    .build()
                Type.Struct.newBuilder()
    public void testPromotesVariation0Precision6() {
        assertEquals("List forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getList().getNullability());
    }
        assertSame("VirtualTable plan with no structural rewrite is a no-op", plan, rewritten);
        // Already explicitly Time64 — must remain as authored.
import io.substrait.proto.Rel;
            .setBaseSchema(
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
            "First child forced nullable",
            .build();
        assertSame(before, after);
            "Second child stays nullable",
            .setPrecisionTime(
                    .addNames("ms")
                    .build()
    public void testVirtualTablePrecisionTimeStillPromoted() {
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
                    .setPrecision(precision)
        PlanRel planRel = PlanRel.newBuilder().setRel(rel).build();
                    .build()
            Type.Nullability.NULLABILITY_NULLABLE,
            Type.Nullability.NULLABILITY_NULLABLE,
            )
        Type rewrittenType = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
        // plan round-trips unchanged and the NOT NULL flag is preserved.
        Type before = makePrecisionTime(9, 1);
        Type mapType = Type.newBuilder()
        Type before = makePrecisionTime(9, 0);
import io.substrait.proto.NamedStruct;
    public void testLeavesVariation0Precision3Alone() {
                    .build()
            after.getStruct().getTypes(1).getI64().getNullability()
        // The rewriter routes on read type + base_schema only; the row literals themselves are
import io.substrait.proto.PlanRel;
        );
                    .build()
        assertEquals("Struct itself forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getStruct().getNullability());
                    .build()
 * fields with {@code type_variation_reference == 0} and {@code precision in {6, 9}}
                    .build()
        assertEquals(
        assertEquals("First inner type promoted", 1, rewritten.getStruct().getTypes(0).getPrecisionTime().getTypeVariationReference());
        assertEquals("Variation promoted to 1", 1, after.getPrecisionTime().getTypeVariationReference());
        Type rewritten = SubstraitPlanProtoRewriter.rewriteType(listType);
            .build();
        Type structType = Type.newBuilder()
                    .setStruct(Type.Struct.newBuilder().addTypes(makePrecisionTime(9, 0)).build())
 * SPDX-License-Identifier: Apache-2.0
            .build();
                    .addNames("v")
        assertEquals(
                    .addTypes(makePrecisionTime(9, 0)) // should be promoted
            after.getMap().getValue().getI64().getNullability()
        // A NOT NULL i64 (e.g. a count() output) must come back nullable so the DF54 consumer's
    // nullability-forcing pass (rewriteType forces NULLABILITY_NULLABLE in addition to promoting
        Type mapType = Type.newBuilder()
        // Mirrors the real regression: a NamedTable base_schema with a NOT NULL aggregate-style
