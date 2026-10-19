        this.id = id;  
        if (allocator != null) {
        if (state.get() == VSRState.CLOSED) {  
    /**
import java.util.concurrent.atomic.AtomicReference;
        FieldVector vector = field.createVector(allocator);  
            throw new IllegalStateException("Cannot modify VSR in state: " + state.get());
     */
        ArrowArray arrowArray = ArrowArray.allocateNew(allocator);
    /** Transitions this VSR from ACTIVE to FROZEN state. */
     *  
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
     */
    }
 * <p>This class is NOT Thread-Safe. External synchronization is required  
        Data.exportSchema(allocator, vsr.getSchema(), null, arrowSchema);
     * @param fieldName the field name  
            throw new IllegalStateException("Cannot access vector in VSR state: " + state.get());
    }  
        return arrowSchema;
    /**
    /**
        if (vsr != null) {
        vsr = new VectorSchemaRoot(newFields, vectors, rowCount);  
        return id;
     * @param allocator buffer allocator for Arrow memory  
            allocator.close();
import java.util.ArrayList;
}
        return "ManagedVSR{id='" + id + "', state=" + state.get() + ", rows=" + getRowCount() + "}";
    private final BufferAllocator allocator;  
    /**
        int rowCount = vsr.getRowCount();
    public ArrowExport exportToArrow() {
            throw new IllegalStateException("Cannot export VSR in state: " + state.get() + ". Must be FROZEN.");  
 */  
    public int getRowCount() {  
     * @param rowCount the new row count
import org.apache.arrow.c.ArrowArray;
    private static final Logger logger = LogManager.getLogger(ManagedVSR.class);
 */
        logger.debug("State transition: FROZEN -> CLOSED for VSR {}", id);  
     *  
    public void setRowCount(int rowCount) {  
 * </ul>
     */
/**
     * @return the schema
        fields.put(field.getName(), vector);
     *
    public void addFieldVector(Field field) {
    public VSRState getState() {
        }
    /**  
        }  
 *   <li><strong>FROZEN</strong> — Read-only; data can be exported to the native writer via
package org.opensearch.parquet.vsr;
    public void close() {
        this.vsr = VectorSchemaRoot.create(schema, allocator);
import org.apache.arrow.memory.BufferAllocator;
        if (state.compareAndSet(VSRState.FROZEN, VSRState.CLOSED) == false) {  
     */  
     */
     * allocator and appends it to the schema. Only allowed in ACTIVE state.
        }
        }
     * Exports this VSR to Arrow C Data Interface for native handoff.
        }  
        }
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.logging.log4j.LogManager;  
     * @param id unique identifier for this VSR
     * Only allowed when VSR is FROZEN.
    public String toString() {
            throw new IllegalStateException("Cannot freeze VSR " + id + ": expected ACTIVE but was " + state.get());
        return vsr.getSchema();
        newFields.add(field);
        return new ArrowExport(arrowArray, arrowSchema);
    }  
     * @return the VSR id
        if (state.get() != VSRState.FROZEN) {
    }
     * Creates a new ManagedVSR.
    /**
            fields.put(field.getName(), vsr.getVector(field));
import org.opensearch.nativebridge.spi.ArrowExport;
import org.apache.arrow.c.ArrowSchema;
 * Managed wrapper around an Apache Arrow {@link VectorSchemaRoot} with strict lifecycle enforcement.
        return vsr.getRowCount();
        return state.get();
    }
    public String getId() {  
    @Override
    /** Returns the current row count. */
        }
            vsr.close();
        for (Field field : vsr.getSchema().getFields()) {  
    private VectorSchemaRoot vsr;
 * if instances are shared across threads.
import java.util.HashMap;
     */
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
        if (state.compareAndSet(VSRState.ACTIVE, VSRState.FROZEN) == false) {  
     * @return the VSR state
            throw new IllegalStateException("Cannot add field to VSR in state: " + state.get());
     * Returns the vector for the given field name, or null if not found.
     *  
    }  
    }  
import java.util.List;  
     */  
    public ManagedVSR(String id, Schema schema, BufferAllocator allocator) {
import org.apache.arrow.vector.VectorSchemaRoot;  
    public Schema getSchema() {  
     * Dynamically adds a new field to this VSR. Creates the vector using the internal  
 *
 * (without freezing first) throws {@link IllegalStateException}.
            return;
     * @param field the Arrow field descriptor  
 * <ul>
     */
 *  
        logger.debug("State transition: ACTIVE -> FROZEN for VSR {}", id);  
/*  
    public FieldVector getVector(String fieldName) {  
    }
 * The OpenSearch Contributors require contributions made to  
    }
     * Returns the current Arrow schema of this VSR.
    private final AtomicReference<VSRState> state = new AtomicReference<>(VSRState.ACTIVE);
            throw new IllegalStateException("Expected VSR to be FROZEN but was " + state.get());
        vectors.add(vector);
    }
        vsr.setRowCount(rowCount);
import org.apache.arrow.vector.types.pojo.Schema;
 * compatible open source license.
 *
import org.apache.arrow.vector.FieldVector;
        if (state.get() != VSRState.ACTIVE) {  
        }  
    }  
     * Exports only the schema to Arrow C Data Interface.  
            throw new IllegalStateException("Cannot close VSR " + id + ": must freeze first");
    }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        Data.exportVectorSchemaRoot(allocator, vsr, null, arrowArray, arrowSchema);
import java.util.Map;
    /**
        List<FieldVector> vectors = new ArrayList<>(vsr.getFieldVectors());
     * @return the field vector, or null
        return fields.get(fieldName);
     *
        List<Field> newFields = new ArrayList<>(vsr.getSchema().getFields());  
 * <p>State transitions are enforced: writing to a frozen VSR or closing an active VSR  
    /**
import org.apache.logging.log4j.Logger;
 *       {@link #exportToArrow()} using the Arrow C Data Interface.</li>
     * Returns the current lifecycle state.  
     * Returns the unique identifier.
    private final String id;
    public void moveToFrozen() {
        }
     *  
     * @param schema Arrow schema defining the vector structure
 *
import org.apache.arrow.c.Data;  
    }
        if (state.get() != VSRState.ACTIVE) {
public class ManagedVSR implements AutoCloseable {  
    private final Map<String, FieldVector> fields = new HashMap<>();
     */
 *   <li><strong>CLOSED</strong> — All Arrow resources (vectors and child allocator) are released.</li>  
        }  
        this.allocator = allocator;
     * Sets the row count.
 *   <li><strong>ACTIVE</strong> — Vectors are writable; row count can be incremented.</li>  
 * <p>Each instance follows the state machine: {@code ACTIVE → FROZEN → CLOSED}.
    public ArrowSchema exportSchema() {
        if (state.get() == VSRState.ACTIVE) {  
        if (state.get() != VSRState.ACTIVE) {
    /**
        }
    @Override  
