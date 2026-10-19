public final class VectorTransfer {  
        target.setRowCount(source.getRowCount());  
        }
package org.opensearch.arrow.transport;
 * The OpenSearch Contributors require contributions made to  
/**
 * SPDX-License-Identifier: Apache-2.0
     * the target owns the buffers and holds the row count; the source is empty with row count 0.  
import org.apache.arrow.vector.FieldVector;
 *
    }
    private VectorTransfer() {}
     *
     * @param target the root receiving the vectors  
            TransferPair tp = sources.get(i).makeTransferPair(targets.get(i));  
        for (int i = 0; i < sources.size(); i++) {
 * compatible open source license.
/*  
 * Zero-copy helpers for moving {@link VectorSchemaRoot} contents between allocators.
import org.apache.arrow.vector.util.TransferPair;  
    /**
 */
 * this file be licensed under the Apache-2.0 license or a
        List<FieldVector> targets = target.getFieldVectors();
        source.setRowCount(0);
 */  
     * Zero-copy transfers every vector from {@code source} into {@code target}. After this call,
 * @opensearch.internal
}  
import org.apache.arrow.vector.VectorSchemaRoot;
     * @param source the root whose vectors are being moved out
 *  
            tp.transfer();
        List<FieldVector> sources = source.getFieldVectors();  
     */
    public static void transferRoot(VectorSchemaRoot source, VectorSchemaRoot target) {
import java.util.List;
