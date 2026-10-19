/**
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.IntVector;
            vector = lv.getDataVector();  
        }  
                writeValue(vsr, f, rowInVsr, row);
import org.apache.arrow.vector.types.pojo.FieldType;
            case 0:
        totalWritten += rowInVsr;  
import org.openjdk.jmh.annotations.BenchmarkMode;
            default:  
 * the pure structural overhead of list encoding.  
            ((ListVector) vsr.getVector(f)).endValue(rowIdx, 1);  
            case 1:
            rowInVsr++;  
 *
            writeIdx = rowIdx;
                return new Field("int_" + index, FieldType.nullable(new ArrowType.Int(32, true)), null);  
            }  
        }
    private void writeValue(VectorSchemaRoot vsr, int f, int rowIdx, int row) {
     * for each row, iterate all fields, write value, then increment row count.
 */  
import org.openjdk.jmh.annotations.Fork;
public class ListVsScalarBenchmark {
    @Param({ "50000" })
import org.apache.arrow.vector.types.pojo.Field;  
        }
    @Benchmark
    }
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
        } else {
    }  
        return new Field(scalarField(index).getName(), FieldType.nullable(ArrowType.List.INSTANCE), Collections.singletonList(child));  
                return new Field("long_" + index, FieldType.nullable(new ArrowType.Int(64, true)), null);
                child = new Field("item", FieldType.nullable(new ArrowType.Int(32, true)), null);  
import org.apache.arrow.vector.VarCharVector;
 * BigIntVector, VarCharVector). When {@code useList=true}, each field is a ListVector
            case 1:
 * JMH benchmark comparing scalar (flat) Arrow vectors vs List vectors.  
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Param;
                child = new Field("item", FieldType.nullable(new ArrowType.Int(64, true)), null);  
 * current row index before incrementing the row count.
        allocator = new RootAllocator(Long.MAX_VALUE);  
import org.apache.arrow.vector.types.pojo.Schema;
                break;
    @Setup(Level.Invocation)
        vsr.close();
                break;
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);
import org.openjdk.jmh.annotations.Benchmark;  
            fields.add(useList ? listField(i) : scalarField(i));
                break;
    private Schema schema;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;  
                ((IntVector) vector).setSafe(writeIdx, row + f);
    public void setup() {
    /**  
        switch (index % 3) {
                totalWritten += rowInVsr;
        int writeIdx;
    @TearDown(Level.Invocation)
    private int totalRows;
        // For list: resolve child vector and child index; for scalar: use vector directly at row index  
    }
import org.apache.arrow.vector.types.pojo.ArrowType;
    }
        Field child;  
            default:  
    }  
            case 0:  
@State(Scope.Benchmark)
            case 0:
 */
                vsr.close();  
        return totalWritten;
import org.apache.arrow.vector.complex.ListVector;
 *
        for (int row = 0; row < totalRows; row++) {
import org.openjdk.jmh.annotations.Setup;  
            writeIdx = lv.startNewValue(rowIdx);
import java.util.ArrayList;  
        List<Field> fields = new ArrayList<>();
     * Writes single values per field per row, matching VSRManager.addDocument() order:
            vsr.setRowCount(rowInVsr);
     */
import org.openjdk.jmh.annotations.State;
            // Rotate VSR when threshold reached  
            ListVector lv = (ListVector) vector;
        }
                vsr = VectorSchemaRoot.create(schema, allocator);
        var vector = vsr.getVector(f);
import org.apache.arrow.vector.VectorSchemaRoot;  
import java.util.concurrent.TimeUnit;  
            if (rowInVsr >= maxRowsPerVSR) {
                break;
        schema = new Schema(fields);  
                ((VarCharVector) vector).setSafe(writeIdx, ("value_" + row).getBytes(StandardCharsets.UTF_8));
    private static Field scalarField(int index) {  
        allocator.close();  
            }
        switch (index % 3) {
 * SPDX-License-Identifier: Apache-2.0
     * Rotates the VSR when maxRowsPerVSR is reached, mirroring VSRPool behavior.  
    public void tearDown() {
 * The OpenSearch Contributors require contributions made to  
    private static Field listField(int index) {
 * wrapping the same element type, and each row writes a single-element list — measuring
 * <p>Mirrors the row-at-a-time write order used by {@code VSRManager.addDocument()}:
        if (useList) {  
        }  
                break;
    @Param({ "20" })
                ((BigIntVector) vector).setSafe(writeIdx, (long) row * 100 + f);
            for (int f = 0; f < fieldCount; f++) {  
}
        switch (f % 3) {
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
import org.apache.arrow.memory.BufferAllocator;
/*  
    private int fieldCount;
import org.openjdk.jmh.annotations.Level;  
 * compatible open source license.
        int totalWritten = 0;
import org.openjdk.jmh.annotations.Mode;
    @Param({ "50001" })
        }
    private boolean useList;
@Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)  
    public int writeRows() {  
 * <p>When {@code useList=false}, values are written directly to flat vectors (IntVector,  
import org.openjdk.jmh.annotations.OutputTimeUnit;  
import org.openjdk.jmh.annotations.TearDown;
import java.util.List;
        int rowInVsr = 0;  
            default:
package org.opensearch.parquet.benchmark;
 * this file be licensed under the Apache-2.0 license or a
                return new Field("kw_" + index, FieldType.nullable(new ArrowType.Utf8()), null);
                child = new Field("item", FieldType.nullable(new ArrowType.Utf8()), null);  
    private BufferAllocator allocator;
        for (int i = 0; i < fieldCount; i++) {  
    @Param({ "true", "false" })
 * outer loop over rows, inner loop over fields, writing each field value at the  
import java.nio.charset.StandardCharsets;
            case 1:  
@BenchmarkMode(Mode.AverageTime)
import org.apache.arrow.vector.BigIntVector;  
    }
                break;
        }
    private int maxRowsPerVSR;
import java.util.Collections;
 *
@Fork(1)
        if (useList) {
                rowInVsr = 0;
