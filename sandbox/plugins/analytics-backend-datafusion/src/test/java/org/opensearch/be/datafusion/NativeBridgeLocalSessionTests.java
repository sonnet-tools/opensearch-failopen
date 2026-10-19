            try {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                    new long[0]
import org.apache.calcite.plan.hep.HepPlanner;
    public void testRegisterMemtableAcceptsZeroBatches() {
    public void testCloseLocalSessionToleratesZero() {  
            }
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
                session.close();  
            }
                        passthroughSubstrait("input-0"),  
import org.apache.arrow.c.Data;  
                BigIntVector col = (BigIntVector) vsr.getVector(0);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.rex.RexBuilder;  
    }
                        passthroughSubstrait("input-0"),
 * <p>Pointer handling follows the plugin convention: raw pointers returned by {@link NativeBridge}  
import org.apache.arrow.vector.types.pojo.FieldType;  
 *
                    Data.exportVectorSchemaRoot(alloc, vsr, null, array, arrowSchema);
import org.apache.calcite.sql.type.SqlTypeName;
                NativeBridge.RegisteredInput registered = NativeBridge.registerPartitionStream(
import org.apache.arrow.vector.VectorSchemaRoot;  
    }
                        session.getPointer(),
            runtimeHandle.close();
    }
        ClassLoader prev = t.getContextClassLoader();  
                assertNotNull("schema IPC bytes returned", registered.schemaIpc());
    }  
            runtimeHandle.close();  
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
 * are wrapped in {@link org.opensearch.analytics.backend.jni.NativeHandle} subclasses
        NativeBridge.senderClose(0L);  
}  
    private NativeRuntimeHandle createRuntime() {
    }
        NativeRuntimeHandle runtimeHandle = createRuntime();  
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
            runtimeHandle.close();  
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
import org.apache.arrow.c.ArrowSchema;
    }
                col.setValueCount(2);
        }
        } finally {
import org.apache.calcite.plan.RelOptCluster;  
            SimpleExtension.ExtensionCollection ext = DefaultExtensionCatalog.DEFAULT_COLLECTION;  
        NativeRuntimeHandle runtimeHandle = createRuntime();  
                NativeBridge.RegisteredInput registered = NativeBridge.registerMemtable(  
                        new long[] { 1L }
 *
    }  
        } finally {  
                    new long[0],
 * this file be licensed under the Apache-2.0 license or a
                assertNotNull("schema IPC bytes returned", registered.schemaIpc());
                col.setSafe(0, 1L);
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());  
    public void testRegisterMemtableImportsBatch() {
import io.substrait.extension.SimpleExtension;  
                VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, alloc);
                } finally {  
                    vsr.close();
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
        }
                    session.getPointer(),  
                Schema schema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            try {  
 * ({@link NativeRuntimeHandle}, {@link DatafusionLocalSession}) so they are registered in the
                    passthroughSubstrait("input-0")
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
                session.close();  
 */  
package org.opensearch.be.datafusion;
        try {  
 * runtime. Mirrors the lifecycle pattern used by {@link DataFusionNativeBridgeTests} — each test  
        // Must not throw.
            } finally {
     * {@code registerPartitionStream} / {@code registerMemtable} now derive their input  
            return new DataFusionFragmentConvertor(ext).convertFragment(scan);
 */
                    session.getPointer(),
            t.setContextClassLoader(NativeBridgeLocalSessionTests.class.getClassLoader());
            t.setContextClassLoader(prev);  
                session.close();
 * Smoke test for the coordinator-reduce FFM wrappers added by the datafusion-coordinator-reduce spec.  
    }
                try (ArrowArray array = ArrowArray.allocateNew(alloc); ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc)) {  
        try {
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.arrow.vector.types.pojo.Field;
        } finally {
import org.apache.arrow.vector.types.pojo.ArrowType;
            runtimeHandle.close();
    public void testRegisterMemtableRejectsLengthMismatch() {
                    "input-0",
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  
 * creates its own per-test runtime and closes it at the end.
                vsr.allocateNew();  
                assertTrue("schema IPC non-empty", registered.schemaIpc().length > 0);  
            assertTrue("session ptr non-zero", session.getPointer() != 0);
            } finally {
        try {  
        NativeRuntimeHandle runtimeHandle = createRuntime();
                    NativeBridge.registerMemtable(
import org.apache.arrow.memory.RootAllocator;
        }
        }
        NativeBridge.initTokioRuntimeManager(2);
                vsr.setRowCount(2);
            runtimeHandle.close();
                        new long[] { array.memoryAddress() },  
 * <p>Exercises each new {@link NativeBridge} wrapper against a real native library + global
 * SPDX-License-Identifier: Apache-2.0
     */
        } finally {
                    );
                    "input-0",
                );  
                    )  
            }
 * live-handle set that {@link NativeBridge}'s {@code validatePointer} guards check.  
import org.apache.calcite.rel.type.RelDataType;
            }
        } finally {  
                        new long[] { 1L, 2L },
        Path spillDir = createTempDir("datafusion-spill");  
                session.close();
                assertTrue("schema IPC non-empty", registered.schemaIpc().length > 0);
            try {  
import io.substrait.extension.DefaultExtensionCatalog;
import org.apache.arrow.vector.BigIntVector;
        try {
        return new NativeRuntimeHandle(runtimePtr);  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                assertTrue("sender ptr non-zero", registered.pointer() != 0);
/*  
                        "input-0",
import org.apache.arrow.vector.types.pojo.Schema;
import org.apache.arrow.c.ArrowArray;
                expectThrows(
import java.util.List;  
public class NativeBridgeLocalSessionTests extends OpenSearchTestCase {
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);  
        } finally {
                );
 * compatible open source license.
                NativeBridge.senderClose(registered.pointer());
            try {
                        "input-0",
                );  
    /**  
    }  
 *
                    IllegalArgumentException.class,
        NativeBridge.closeLocalSession(0L);
     * Bare {@code SELECT * FROM "input-0"} substrait whose lowered output schema is a single
    public void testRegisterPartitionStreamAndSenderClose() {  
        }  
/**
     * BIGINT column named {@code x} — used as the producer-side plan that
                col.setSafe(1, 2L);  
            } finally {  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
    public void testSenderCloseToleratesZero() {
        NativeRuntimeHandle runtimeHandle = createRuntime();
                    () -> NativeBridge.registerMemtable(  
        NativeRuntimeHandle runtimeHandle = createRuntime();
     * schema from.
                        session.getPointer(),  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        Thread t = Thread.currentThread();
 * The OpenSearch Contributors require contributions made to  
    private static byte[] passthroughSubstrait(String inputId) {  
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());  
import java.nio.file.Path;
                    passthroughSubstrait("input-0"),  
        }
                        new long[] { arrowSchema.memoryAddress() }
import org.apache.calcite.rel.RelNode;  
import org.apache.calcite.plan.hep.HepProgramBuilder;
                }
            } finally {  
    public void testCreateLocalSessionReturnsNonZeroPtr() {
            session.close();  
        try {
