        assertEquals("List forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getList().getNullability());
        Type before = i64(Type.Nullability.NULLABILITY_NULLABLE);  
        assertSame("Already-nullable type is a no-op", before, after);
                Type.PrecisionTime.newBuilder()  
        Type after = SubstraitPlanProtoRewriter.rewriteType(mapType);
        // Build a minimal Plan { relations: [Read { base_schema: Struct { types: [PrecisionTime(9, 0)] } }] }
        assertSame("No-op when precision is legal for Time32", before, after);
                    .build()
        assertEquals(  
                Type.List.newBuilder()
        assertEquals("i64 forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getI64().getNullability());
 */  
    public void testAlreadyNullableScalarReturnsSameInstance() {
        assertEquals("Precision still 9", 9, rewrittenType.getPrecisionTime().getPrecision());  
/**
        // The rewriter routes on read type + base_schema only; the row literals themselves are  
import io.substrait.proto.Plan;
                Type.Struct.newBuilder()
        // nullability. The rewriter must NOT relax nullability here, or that assertion fails with
        Type before = makePrecisionTime(9, 1);  
    public void testFullPlanForcesNamedTableBaseSchemaNullability() {  
        assertEquals(0, after.getPrecisionTime().getTypeVariationReference());
                    .build()
            )  
                    .setNullability(Type.Nullability.NULLABILITY_REQUIRED)
    public void testForcesNullabilityOnListElement() {
    public void testPromotesVariation0Precision9() {  
    private static Type i64(Type.Nullability nullability) {
            Type.Nullability.NULLABILITY_NULLABLE,
 * this file be licensed under the Apache-2.0 license or a
                Type.Map.newBuilder()
        // and confirm rewrite() promotes the PrecisionTime in the read's base schema.
                    .addNames("tm")  
            after.getList().getType().getI64().getNullability()  
        ReadRel read = ReadRel.newBuilder()  
        );
    }  
        // No PrecisionTime to promote and nullability forcing is skipped for VirtualTable, so the
            "VirtualTable PrecisionTime nullability preserved (makePrecisionTime is nullable)",
    public void testNoOpReturnsSameInstance() {  
    // ── nullability forcing ──────────────────────────────────────────────  
            )  
}  
            .setStruct(  
    public void testLeavesVariation1Alone() {
import org.opensearch.test.OpenSearchTestCase;
                    .setValue(i64(Type.Nullability.NULLABILITY_REQUIRED))
import io.substrait.proto.ReadRel;  
                    .setStruct(Type.Struct.newBuilder().addTypes(makePrecisionTime(9, 0)).build())
        Type mapType = Type.newBuilder()
                    .addNames("c")
    }
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
    public void testVirtualTableBaseSchemaNullabilityPreserved() {
        );
                    .setTypeVariationReference(variationReference)
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
            .setVirtualTable(ReadRel.VirtualTable.newBuilder().build())  
        );
import io.substrait.proto.Rel;
                    .addTypes(makePrecisionTime(3, 0)) // should be left alone
                    .build()
            .setNamedTable(ReadRel.NamedTable.newBuilder().addNames("input-1").build())
                    .addTypes(makePrecisionTime(9, 0)) // should be promoted
    }
    }
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);  
    // the type variation). A non-nullable build would be rewritten by the nullability pass alone.
                    .setStruct(Type.Struct.newBuilder().addTypes(i64(Type.Nullability.NULLABILITY_REQUIRED)).build())
            .setMap(Type.Map.newBuilder().setKey(makePrecisionTime(9, 0)).setValue(makePrecisionTime(6, 0)).build())
        assertTrue("Type should still be PrecisionTime", after.hasPrecisionTime());  
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);  
        Type rewritten = SubstraitPlanProtoRewriter.rewriteType(listType);
        Type listType = Type.newBuilder().setList(Type.List.newBuilder().setType(makePrecisionTime(9, 0)).build()).build();
    }  
            tm.getPrecisionTime().getNullability()  
            "Second child stays nullable",
            )  
                NamedStruct.newBuilder()
    }  
        Type structType = Type.newBuilder()
 * through unchanged.
import io.substrait.proto.PlanRel;
        Type tm = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
    }  
    // nullability-forcing pass (rewriteType forces NULLABILITY_NULLABLE in addition to promoting
        // VirtualTableScan.check() asserts must match the base_schema types EXACTLY, including  
    }
                    .build()
            .setVirtualTable(ReadRel.VirtualTable.newBuilder().build())  
 *
            .setBaseSchema(
    public void testForcesNullabilityOnMapKeyAndValue() {
        return Type.newBuilder().setI64(Type.I64.newBuilder().setNullability(nullability).build()).build();  
        assertEquals("VirtualTable base_schema nullability preserved", Type.Nullability.NULLABILITY_REQUIRED, v.getI64().getNullability());
            )
                    .addTypes(i64(Type.Nullability.NULLABILITY_REQUIRED))  
        // A plan whose base_schema is already nullable (makePrecisionTime builds nullable) and has
            .build();  
                NamedStruct.newBuilder()
        // plan round-trips unchanged and the NOT NULL flag is preserved.
                    .build()
        // Time32(Millisecond) is legal — must not be promoted.
                NamedStruct.newBuilder()
    public void testRecursesIntoList() {  
        assertEquals("i64 forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getI64().getNullability());
                    )  
        ReadRel read = ReadRel.newBuilder()
        );
    }
        Type before = i64(Type.Nullability.NULLABILITY_REQUIRED);  
        PlanRel planRel = PlanRel.newBuilder().setRel(rel).build();  
            "Map value forced nullable",  
        assertEquals("Map forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getMap().getNullability());  
        assertEquals(6, after.getPrecisionTime().getPrecision());
                Type.Struct.newBuilder()  
        assertSame(before, after);  
                            .setNullability(Type.Nullability.NULLABILITY_NULLABLE)  
                    .build()
            .setBaseSchema(
                        Type.Struct.newBuilder()
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
        Type before = makePrecisionTime(6, 0);  
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
        // base_schema-vs-provider nullability check passes.
                    .setNullability(Type.Nullability.NULLABILITY_REQUIRED)
                    .addNames("tm")  
        assertSame(before, after);
        Type structType = Type.newBuilder()
    }
    }
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
    }
 * are promoted to variation 1 (TIME_64), while other PrecisionTime values pass
    public void testForcesUnspecifiedScalarToNullable() {
                    .build()  
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
    public void testRecursesIntoStruct() {  
                            .addTypes(makePrecisionTime(3, 0))
        // column 'c' must be relaxed to nullable through the full rewrite() entry point so the DF54
    }
                NamedStruct.newBuilder()
        assertEquals("Map key promoted", 1, rewritten.getMap().getKey().getPrecisionTime().getTypeVariationReference());
            .build();  
    }
        assertEquals("Precision preserved", 9, after.getPrecisionTime().getPrecision());
        assertEquals(  
                NamedStruct.newBuilder()
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
        // The PrecisionTime promotion is independent of nullability and must still apply to a  
    private static Type makePrecisionTime(int precision, int variationReference) {  
            Type.Nullability.NULLABILITY_NULLABLE,
/*  
        assertSame("No-op rewrite returns same instance", plan, rewritten);  
        assertEquals(1, after.getPrecisionTime().getTypeVariationReference());  
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
            .build();  
        ReadRel read = ReadRel.newBuilder()
        // consumer's nullability check against the (nullable) TableProvider schema passes.  
            .setList(  
        // Outer struct REQUIRED, one REQUIRED child and one already-nullable child: every level  
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);
 * Unit tests for {@link SubstraitPlanProtoRewriter} — verifies that PrecisionTime
            .setBaseSchema(
    public void testVirtualTablePrecisionTimeStillPromoted() {
            Type.Nullability.NULLABILITY_NULLABLE,
        // A VirtualTable (inline VALUES) read carries row literals that substrait-java's
        assertEquals(
        ReadRel read = ReadRel.newBuilder()
    }  
            )
 * fields with {@code type_variation_reference == 0} and {@code precision in {6, 9}}  
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);  
                    .setStruct(
    public void testFullPlanRewriteThroughReadRel() {  
public class SubstraitPlanProtoRewriterTests extends OpenSearchTestCase {
        // no offending PrecisionTime should round-trip the same instance.
        Type rewritten = SubstraitPlanProtoRewriter.rewriteType(mapType);
        return Type.newBuilder()
    }
        Type mapType = Type.newBuilder()
                    .addNames("v")  
            .build();
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
        Plan plan = Plan.newBuilder().addRelations(planRel).build();
        // A NOT NULL i64 (e.g. a count() output) must come back nullable so the DF54 consumer's
            )
    }  
                    .setKey(i64(Type.Nullability.NULLABILITY_REQUIRED))  
            .setPrecisionTime(
        assertEquals("PrecisionTime in ReadRel.base_schema promoted", 1, rewrittenType.getPrecisionTime().getTypeVariationReference());
    public void testLeavesVariation0Precision3Alone() {  
        Type listType = Type.newBuilder()
        Type after = SubstraitPlanProtoRewriter.rewriteType(structType);
            after.getMap().getValue().getI64().getNullability()
        // VirtualTable read, even though nullability is left alone.
                            .build()
    public void testForcesNullabilityOnStructAndChildren() {
        Type before = makePrecisionTime(0, 0);
        Type v = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
        ReadRel read = ReadRel.newBuilder()  
            )  
                    .setNullability(Type.Nullability.NULLABILITY_REQUIRED)
import io.substrait.proto.NamedStruct;  
    // Builds a nullable PrecisionTime so promotion-focused tests stay no-ops under the  
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
import io.substrait.proto.Type;
            "List element forced nullable",
        assertNotSame("Struct rewritten because inner type changed", structType, rewritten);
            .setStruct(
        // irrelevant to it, so an empty VirtualTable is sufficient to exercise the skip branch.
        Type rewritten = SubstraitPlanProtoRewriter.rewriteType(structType);  
            .setBaseSchema(
                    .setStruct(Type.Struct.newBuilder().addTypes(i64(Type.Nullability.NULLABILITY_REQUIRED)).build())  
    }
        // "Row field type ... does not match schema field type ...". A NOT NULL field must survive.
        assertEquals("base_schema field 'c' forced nullable", Type.Nullability.NULLABILITY_NULLABLE, c.getI64().getNullability());
            "First child forced nullable",
            )
        Plan rewritten = SubstraitPlanProtoRewriter.rewrite(plan);  
        assertEquals(
        assertEquals("Map key forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getMap().getKey().getI64().getNullability());
    }
        assertSame("VirtualTable plan with no structural rewrite is a no-op", plan, rewritten);  
 * compatible open source license.
    public void testPromotesVariation0Precision6() {
        assertEquals("Second inner type unchanged", 0, rewritten.getStruct().getTypes(1).getPrecisionTime().getTypeVariationReference());  
        assertEquals("Variation promoted to 1 (TIME_64)", 1, after.getPrecisionTime().getTypeVariationReference());
                    .setNullability(Type.Nullability.NULLABILITY_NULLABLE)  
                    .addNames("ms")  
            .setMap(  
package org.opensearch.be.datafusion;
        // Already explicitly Time64 — must remain as authored.
            )  
        Plan plan = Plan.newBuilder().addRelations(PlanRel.newBuilder().setRel(Rel.newBuilder().setRead(read).build()).build()).build();
                    .setStruct(Type.Struct.newBuilder().addTypes(makePrecisionTime(9, 0)).build())
            .build();
        assertEquals("Struct itself forced nullable", Type.Nullability.NULLABILITY_NULLABLE, after.getStruct().getNullability());  
            Type.Nullability.NULLABILITY_NULLABLE,  
        assertEquals("List element type promoted", 1, rewritten.getList().getType().getPrecisionTime().getTypeVariationReference());  
                    .setPrecision(precision)
        assertEquals(  
 */  
        Type before = makePrecisionTime(3, 0);
                    .addTypes(i64(Type.Nullability.NULLABILITY_NULLABLE))
        );  
            .setBaseSchema(  
        // Mirrors the real regression: a NamedTable base_schema with a NOT NULL aggregate-style
        // Time32(Second) is legal — must not be promoted.  
        assertEquals("Variation promoted to 1", 1, after.getPrecisionTime().getTypeVariationReference());  
 * The OpenSearch Contributors require contributions made to  
            after.getStruct().getTypes(0).getI64().getNullability()
    public void testLeavesVariation0Precision0Alone() {
                    .build()
            .build();  
        Type before = i64(Type.Nullability.NULLABILITY_UNSPECIFIED);  
            .build();
                    .build()
            .build();  
        assertEquals("First inner type promoted", 1, rewritten.getStruct().getTypes(0).getPrecisionTime().getTypeVariationReference());
    public void testRecursesIntoMap() {  
        Type rewrittenType = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);
        // must end up nullable.
        Type c = rewritten.getRelations(0).getRel().getRead().getBaseSchema().getStruct().getTypes(0);  
        assertEquals("Map value promoted", 1, rewritten.getMap().getValue().getPrecisionTime().getTypeVariationReference());  
    public void testForcesRequiredScalarToNullable() {  
 * SPDX-License-Identifier: Apache-2.0
            )
        Type after = SubstraitPlanProtoRewriter.rewriteType(before);
        Type after = SubstraitPlanProtoRewriter.rewriteType(listType);
                    .build()
    }
    }
            .build();
        assertEquals("PrecisionTime promoted even for VirtualTable", 1, tm.getPrecisionTime().getTypeVariationReference());
            .build();
            Type.Nullability.NULLABILITY_NULLABLE,
            .build();
                    .setType(i64(Type.Nullability.NULLABILITY_REQUIRED))  
        assertEquals(0, after.getPrecisionTime().getTypeVariationReference());
            after.getStruct().getTypes(1).getI64().getNullability()  
        Type before = makePrecisionTime(9, 0);
        Rel rel = Rel.newBuilder().setRead(read).build();
