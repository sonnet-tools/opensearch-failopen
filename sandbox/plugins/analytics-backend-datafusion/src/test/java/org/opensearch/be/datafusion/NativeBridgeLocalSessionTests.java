    }
 */
                vsr.allocateNew();
import org.apache.calcite.rel.RelNode;
                    vsr.close();
            SimpleExtension.ExtensionCollection ext = DefaultExtensionCatalog.DEFAULT_COLLECTION;
                    Data.exportVectorSchemaRoot(alloc, vsr, null, array, arrowSchema);
import org.apache.arrow.c.ArrowArray;
import org.apache.calcite.rel.type.RelDataType;
                        passthroughSubstrait("input-0"),
        } finally {
        NativeRuntimeHandle runtimeHandle = createRuntime();
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.vector.BigIntVector;
        } finally {
                    );
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
    /**
        NativeRuntimeHandle runtimeHandle = createRuntime();
                }
    }
                        session.getPointer(),
        }
 * live-handle set that {@link NativeBridge}'s {@code validatePointer} guards check.
            runtimeHandle.close();
    }
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            } finally {
     * schema from.
            try {
                NativeBridge.senderClose(registered.pointer());
            t.setContextClassLoader(NativeBridgeLocalSessionTests.class.getClassLoader());
        NativeRuntimeHandle runtimeHandle = createRuntime();
                session.close();
                );
        NativeRuntimeHandle runtimeHandle = createRuntime();
                    IllegalArgumentException.class,
}
    public void testRegisterMemtableImportsBatch() {
 * <p>Pointer handling follows the plugin convention: raw pointers returned by {@link NativeBridge}
                    session.getPointer(),
                    new long[0]
 * runtime. Mirrors the lifecycle pattern used by {@link DataFusionNativeBridgeTests} — each test
        // Must not throw.
import org.apache.arrow.vector.types.pojo.FieldType;
                    new long[0],
 *
                    session.getPointer(),
 */
     * {@code registerPartitionStream} / {@code registerMemtable} now derive their input
import org.apache.arrow.vector.types.pojo.Field;
                        "input-0",
                col.setSafe(0, 1L);
                vsr.setRowCount(2);
    }
        NativeRuntimeHandle runtimeHandle = createRuntime();
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * The OpenSearch Contributors require contributions made to
                col.setValueCount(2);
import org.apache.arrow.memory.RootAllocator;
                col.setSafe(1, 2L);
 *
import org.apache.arrow.vector.VectorSchemaRoot;
    }
        RelDataType bigintNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        NativeBridge.initTokioRuntimeManager(2);
                    passthroughSubstrait("input-0"),
import org.apache.calcite.rex.RexBuilder;
                assertNotNull("schema IPC bytes returned", registered.schemaIpc());
            try {
        }
                );
                assertTrue("schema IPC non-empty", registered.schemaIpc().length > 0);
            runtimeHandle.close();
            t.setContextClassLoader(prev);
                        new long[] { arrowSchema.memoryAddress() }
        try {
                    NativeBridge.registerMemtable(
                session.close();
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), inputId, rowType);
                        new long[] { 1L, 2L },
                session.close();
    private NativeRuntimeHandle createRuntime() {
                        new long[] { array.memoryAddress() },
        try {
                    passthroughSubstrait("input-0")
    public void testCreateLocalSessionReturnsNonZeroPtr() {
 * <p>Exercises each new {@link NativeBridge} wrapper against a real native library + global
        } finally {
        NativeBridge.senderClose(0L);
import org.apache.calcite.sql.type.SqlTypeName;
        Thread t = Thread.currentThread();
 * Smoke test for the coordinator-reduce FFM wrappers added by the datafusion-coordinator-reduce spec.
            try {
    public void testRegisterMemtableAcceptsZeroBatches() {
        Path spillDir = createTempDir("datafusion-spill");
import org.apache.arrow.c.ArrowSchema;
                assertNotNull("schema IPC bytes returned", registered.schemaIpc());
import java.util.List;
import org.apache.arrow.vector.types.pojo.Schema;
                    "input-0",
        RelOptCluster cluster = RelOptCluster.create(hepPlanner, rexBuilder);
                BigIntVector col = (BigIntVector) vsr.getVector(0);
 * this file be licensed under the Apache-2.0 license or a
        ClassLoader prev = t.getContextClassLoader();
                VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, alloc);
    public void testRegisterPartitionStreamAndSenderClose() {
 * ({@link NativeRuntimeHandle}, {@link DatafusionLocalSession}) so they are registered in the
import org.apache.calcite.rel.type.RelDataTypeFactory;
                } finally {
        } finally {
                    () -> NativeBridge.registerMemtable(
                assertTrue("schema IPC non-empty", registered.schemaIpc().length > 0);
import org.opensearch.test.OpenSearchTestCase;
                assertTrue("sender ptr non-zero", registered.pointer() != 0);
            runtimeHandle.close();
    public void testCloseLocalSessionToleratesZero() {
            return new DataFusionFragmentConvertor(ext).convertFragment(scan);
            }
import java.nio.file.Path;
                NativeBridge.RegisteredInput registered = NativeBridge.registerMemtable(
        RelDataType rowType = typeFactory.builder().add("x", bigintNullable).build();
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            } finally {
                        session.getPointer(),
            }
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
        assertTrue("runtime ptr non-zero", runtimePtr != 0);
                    "input-0",
            session.close();
     */
            }
        } finally {
package org.opensearch.be.datafusion;
    }
                NativeBridge.RegisteredInput registered = NativeBridge.registerPartitionStream(
            } finally {
            try {
        try {
    }
import org.apache.calcite.plan.hep.HepPlanner;
public class NativeBridgeLocalSessionTests extends OpenSearchTestCase {
    public void testRegisterMemtableRejectsLengthMismatch() {
 * creates its own per-test runtime and closes it at the end.
                expectThrows(
                        new long[] { 1L }
 *
        }
                try (ArrowArray array = ArrowArray.allocateNew(alloc); ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc)) {
                        "input-0",
            runtimeHandle.close();
        try {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
        NativeBridge.closeLocalSession(0L);
        HepPlanner hepPlanner = new HepPlanner(new HepProgramBuilder().build());
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                        passthroughSubstrait("input-0"),
        } finally {
            } finally {
import org.apache.calcite.plan.hep.HepProgramBuilder;
        }
     * BIGINT column named {@code x} — used as the producer-side plan that
    private static byte[] passthroughSubstrait(String inputId) {
 * are wrapped in {@link org.opensearch.analytics.backend.jni.NativeHandle} subclasses
        try {
 * compatible open source license.
    }
                session.close();
            runtimeHandle.close();
import org.apache.arrow.c.Data;
        }
    public void testSenderCloseToleratesZero() {
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
     * Bare {@code SELECT * FROM "input-0"} substrait whose lowered output schema is a single
import io.substrait.extension.SimpleExtension;
            DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
        }
import org.apache.calcite.plan.RelOptCluster;
            }
import org.apache.arrow.vector.types.pojo.ArrowType;
                Schema schema = new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
                    )
/**
/*
    }
            assertTrue("session ptr non-zero", session.getPointer() != 0);
import io.substrait.extension.DefaultExtensionCatalog;
        return new NativeRuntimeHandle(runtimePtr);
                );
