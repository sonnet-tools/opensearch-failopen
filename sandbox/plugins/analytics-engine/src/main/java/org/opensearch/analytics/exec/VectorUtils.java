    public static void sanitizeNullViewSlots(VectorSchemaRoot root) {
     * so a downstream zero-copy export still hands the same buffers to native.  
 * this file be licensed under the Apache-2.0 license or a
        int rowCount = input.getRowCount();
     * {@code RelNodeUtils.appendField}.  
            ArrowBuf viewBuffer = view.getDataBuffer();
     * the view length prefix unconditionally — a garbage length &gt; 12 dereferences a variadic data  
import org.apache.arrow.vector.BaseVariableWidthViewVector;  
        // Zero-copy: existing FieldVectors are reused by reference; only the new column allocates.
     * + reference schema to look up the index) instead of assuming the tail. Coupling
 */  
/**
     * @param name      name of the new column
     * @param allocator allocator for the new {@link IntVector}
        IntVector constantVector = new IntVector(name, allocator);  
     * the validity bit but leaves the slot's 16-byte view as uninitialized buffer memory. Arrow-Java
     * buffer that does not exist on an all-null column, panicking. Zeroing makes each null slot a
        for (FieldVector vec : root.getFieldVectors()) {  
    }  
            constantVector.set(i, value);  
     * an additional non-nullable Int32 column appended at the end. The returned VSR's
                }  
     * Builds a new {@link VectorSchemaRoot} whose schema is the input's schema with  
     * instances as the input — only the new constant column is a fresh allocation.  
     * VSR independently — closing the returned VSR releases both the new column and
     *
 * The OpenSearch Contributors require contributions made to  
     * honors the validity bit, but a raw consumer reading the layout (DataFusion's interleave) reads
     *
     *
        constantVector.setValueCount(rowCount);
     * <p>Only needed for batches built in Java (e.g. the QTF stitch output); batches imported from
    private VectorUtils() {}  
     * @param value     constant value written to every row of the new column  
     * No data is copied.
        List<FieldVector> combined = new ArrayList<>(input.getFieldVectors().size() + 1);
 * Utilities for Arrow {@link VectorSchemaRoot} manipulation in the analytics engine.  
     * BinaryView), making the batch safe to export across the Arrow C Data Interface.
     * @param input     source batch; not closed by this method
 *
     * <p>Ownership semantics: the returned VSR shares its leading FieldVectors with  
import org.apache.arrow.memory.BufferAllocator;
import java.util.ArrayList;
    /**
                    viewBuffer.setZero((long) row * BaseVariableWidthViewVector.ELEMENT_SIZE, BaseVariableWidthViewVector.ELEMENT_SIZE);
     *
     * Zeroes the view of every null slot in a hand-built batch's view columns (Utf8View /  
     * is allowed); the Iterable constructor accepts the appended layout directly.
     *  
        }
     *
     * the runtime append position to the planner's declared position is the design  
public final class VectorUtils {
     * valid length-0 inline view; validity bits are untouched, so cells stay null. Mutates in place,
import org.apache.arrow.vector.IntVector;
 */  
     * constant column. We avoid {@code VectorSchemaRoot.addVector} because Arrow 18.x's  
            for (int row = 0; row < rows; row++) {  
}
     * the input by reference (Arrow ref-counting). Callers must not close the input
/*  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.exec;
import java.util.List;  
import org.apache.arrow.vector.VectorSchemaRoot;  
        }
     */  
    public static VectorSchemaRoot appendConstantInt(VectorSchemaRoot input, String name, int value, BufferAllocator allocator) {
        for (int i = 0; i < rowCount; i++) {
import org.apache.arrow.memory.ArrowBuf;
     * @return new VSR with the appended column; row count and existing column data unchanged
     *
                if (view.isNull(row)) {
        combined.addAll(input.getFieldVectors());  
     * precondition rejects appending at index == size (only insert before an existing column
        constantVector.allocateNew(rowCount);
 * compatible open source license.
            }
     * of the row type, this helper needs to take a column index parameter (or a name
import org.apache.arrow.vector.FieldVector;
     */  
     *
     * <p>TODO: position is hard-coded to "end" today because the planner happens to
        combined.add(constantVector);
     * <p>When a producer fills a view vector via {@code copyFromSafe}/{@code setNull}, Arrow unsets  
     * existing columns are the same {@link org.apache.arrow.vector.FieldVector}
     * {@code ___ugsi}) at the end of the row type — see
            if (!(vec instanceof BaseVariableWidthViewVector view) || view.getNullCount() == 0) continue;
 * @opensearch.internal
        return new VectorSchemaRoot(combined);
     * goal; we just don't pay the index-lookup cost today.
     * the shared columns.  
        int rows = root.getRowCount();
     * <p>Position contract: the new column is appended at the end of the schema. This  
    }  
     * @param root batch to sanitize in place; not closed by this method
 *
     * declare helper columns at the end. If a future helper is declared in the middle  
     * native are already spec-valid.  
     * must align with the planner-side declaration that adds helper columns (e.g.
     * <p>Implementation: builds a new VSR from the existing FieldVector references plus the
    /**
