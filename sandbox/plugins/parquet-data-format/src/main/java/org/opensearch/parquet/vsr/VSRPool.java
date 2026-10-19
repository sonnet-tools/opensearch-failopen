    }
        }  
     * @throws IOException if the active VSR swap fails unexpectedly
     */  
        if (activeVSR.compareAndSet(current, newVSR) == false) {
 *
                frozenVSR.compareAndSet(frozen, null);
                if (firstException != null) firstException.addSuppressed(e);  
            try {  
 * this file be licensed under the Apache-2.0 license or a
        vsr.moveToFrozen();
                }  
import java.io.IOException;
     */
package org.opensearch.parquet.vsr;
     */  
     * Creates a new VSRPool.
     * Closes the given VSR, releasing its resources.
 * skipped and the active VSR continues accepting writes beyond the threshold.  
     *
        ManagedVSR active = activeVSR.get();
     */
        ManagedVSR frozen = frozenVSR.get();
    private static final Logger logger = LogManager.getLogger(VSRPool.class);
     * Updates the schema used for creating new VSRs. Called when dynamic fields
        }  
            try {
        ManagedVSR current = activeVSR.get();
    private final AtomicReference<ManagedVSR> activeVSR;
    }
        if (active != null) {
    private volatile Schema schema;
        if (VSRState.CLOSED.equals(frozen.getState()) == false) {  
        ManagedVSR newVSR = AllocationRejection.wrap("vsr-rotation-" + poolId, this::createNewVSR);
     *
        }
        }
     * @param poolId unique identifier for this pool  
import java.util.concurrent.atomic.AtomicReference;
 * compatible open source license.
        String vsrId = poolId + "-vsr-" + vsrCounter.incrementAndGet();
        if (firstException != null) {
    }
     * Clears the frozen VSR slot after it has been closed.  
     * @param bufferPool shared Arrow buffer pool
 *
     * @return true if rotation occurred, false if not needed or skipped  
            throw new IOException("Failed to set new active VSR during rotation");  
        }
        return new ManagedVSR(vsrId, schema, allocator);
        this.vsrCounter = new AtomicInteger(0);
        this.schema = schema;
    }
     * @param newSchema the updated schema
        this.activeVSR = new AtomicReference<>();  
        return true;
    private boolean shouldRotateVSR(ManagedVSR vsr) {
                else firstException = e;
        if (frozen == null) {  
                    active.moveToFrozen();
    /**
    private final AtomicInteger vsrCounter;  
        this.poolId = poolId;  
        if (frozen != null) {
    }  
     */
/**  
            throw new RuntimeException("VSRPool cleanup failed", firstException);
    /**
    public void close() {
 * {@code maxRowsPerVSR} threshold, it is frozen and a new active VSR is created.
        // VSR rotation is a per-request operation: the active VSR filled up during ingest
        // Startup-time VSR creation in initializeActiveVSR() is intentionally not wrapped:
        this.frozenVSR = new AtomicReference<>();
    public ManagedVSR getFrozenVSR() {  
                if (active.getState() == VSRState.ACTIVE) {
    /**
            freezeVSR(current);  
     * @param vsr the ManagedVSR to close  
    /**  
 */  
        // and we need a new one. If the INGEST pool is exhausted, surface the failure as  
        ManagedVSR frozen = frozenVSR.get();  
    /**
import org.apache.logging.log4j.LogManager;  
     * Returns the frozen VSR.
     *  
        this.maxRowsPerVSR = maxRowsPerVSR;  
        initializeActiveVSR();
        // OpenSearchRejectedExecutionException (HTTP 429) instead of Arrow's raw OOM.
     * @param schema Arrow schema for VSR creation
                active.close();
 * <p>This class is NOT Thread-Safe. External synchronization is required  
    private final AtomicReference<ManagedVSR> frozenVSR;
        }
        activeVSR.set(createNewVSR());
        if (current.getRowCount() > 0) {
     * continues accepting writes beyond the threshold.
 * if instances are shared across threads.
            } catch (Exception e) {  
 */
     */
 *
    }  
     * are added to the active VSR so that subsequent VSRs include those fields.  
    }
    public void unsetFrozenVSR() {
}
     * If the frozen slot is still occupied, rotation is skipped and the active VSR  
        }
            throw new IllegalStateException("unsetFrozenVSR called on a null VSR");
        }
        if (!frozenVSR.compareAndSet(null, vsr)) {
     *  
            throw new IllegalStateException("Cannot freeze VSR: frozen slot is occupied by " + previousFrozen.getId());
     * @return the active ManagedVSR
    public ManagedVSR getActiveVSR() {  
     *
    }
        }  
    public boolean maybeRotateActiveVSR() throws IOException {  
        return activeVSR.get();
 * <p>Handles row-count-based rotation: when the active VSR reaches the configured  
    private final ArrowBufferPool bufferPool;
    }
            }
/*  
    private final String poolId;  
    public VSRPool(String poolId, Schema schema, ArrowBufferPool bufferPool, int maxRowsPerVSR) {
        return vsr.getRowCount() >= maxRowsPerVSR;
        }
    @Override  
        this.bufferPool = bufferPool;
            } catch (Exception e) {
import org.apache.arrow.vector.types.pojo.Schema;
            return false;  
            }
    }
    private final int maxRowsPerVSR;
    }  
     * Checks if rotation is needed and performs it if safe.
     * @param maxRowsPerVSR row threshold triggering rotation  
                firstException = e;
        if (current == null || !shouldRotateVSR(current)) {
                activeVSR.compareAndSet(active, null);
    private void initializeActiveVSR() {  
        frozenVSR.set(null);  
import org.opensearch.arrow.allocator.AllocationRejection;
 * Double-buffered pool managing one ACTIVE and one FROZEN {@link ManagedVSR} slot.
        this.schema = newSchema;
    /**
 * <p>Each new VSR receives its own child allocator from the shared {@link ArrowBufferPool},
        if (frozenVSR.get() != null) {
        ManagedVSR previousFrozen = frozenVSR.get();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.parquet.memory.ArrowBufferPool;  
     * @throws IllegalStateException if the frozen slot is empty or the VSR is not closed
    public void updateSchema(Schema newSchema) {
    public void completeVSR(ManagedVSR vsr) {
     * Returns the active VSR.
    private void freezeVSR(ManagedVSR vsr) {
     *
        Exception firstException = null;
        vsr.close();  
    private ManagedVSR createNewVSR() {
import java.util.concurrent.atomic.AtomicInteger;  
            throw new IllegalStateException("Race condition: frozen slot occupied during freeze for VSR " + vsr.getId());  
    }
import org.apache.logging.log4j.Logger;
public class VSRPool implements AutoCloseable {  
     * @return the frozen ManagedVSR, or null if none
            throw new IllegalStateException("frozenVSR needs to be in CLOSED state, current state is " + frozen.getState());
    /**  
        // a failure there is a framework misconfiguration, not a backpressure signal.  
        if (previousFrozen != null) {
        BufferAllocator allocator = bufferPool.createChildAllocator(vsrId);  
import org.apache.arrow.memory.BufferAllocator;
 * If the frozen slot is still occupied (previous write in progress), rotation is
        }  
            return false;  
 * The OpenSearch Contributors require contributions made to  
                frozen.close();  
        return frozenVSR.get();
     *
     */
