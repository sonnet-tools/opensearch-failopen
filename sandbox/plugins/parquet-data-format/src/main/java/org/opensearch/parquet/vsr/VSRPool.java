 * compatible open source license.
                }
        this.activeVSR = new AtomicReference<>();
 * If the frozen slot is still occupied (previous write in progress), rotation is
    private void initializeActiveVSR() {
        if (previousFrozen != null) {
public class VSRPool implements AutoCloseable {
                active.close();
     */
    private final AtomicReference<ManagedVSR> activeVSR;
        // and we need a new one. If the INGEST pool is exhausted, surface the failure as
        }
     */
    private boolean shouldRotateVSR(ManagedVSR vsr) {
    private final ArrowBufferPool bufferPool;
            throw new IllegalStateException("unsetFrozenVSR called on a null VSR");
    /**
import java.io.IOException;
        return new ManagedVSR(vsrId, schema, allocator);
        }
import org.apache.arrow.vector.types.pojo.Schema;
    private void freezeVSR(ManagedVSR vsr) {
        this.bufferPool = bufferPool;
            }
            try {
        }
        this.frozenVSR = new AtomicReference<>();
        activeVSR.set(createNewVSR());
     * Closes the given VSR, releasing its resources.
            } catch (Exception e) {
    @Override
        Exception firstException = null;
            throw new IllegalStateException("frozenVSR needs to be in CLOSED state, current state is " + frozen.getState());
        }
        }
        if (!frozenVSR.compareAndSet(null, vsr)) {
 * Double-buffered pool managing one ACTIVE and one FROZEN {@link ManagedVSR} slot.
            throw new IllegalStateException("Cannot freeze VSR: frozen slot is occupied by " + previousFrozen.getId());
        String vsrId = poolId + "-vsr-" + vsrCounter.incrementAndGet();
     * Creates a new VSRPool.
                if (active.getState() == VSRState.ACTIVE) {
        BufferAllocator allocator = bufferPool.createChildAllocator(vsrId);
            throw new IllegalStateException("Race condition: frozen slot occupied during freeze for VSR " + vsr.getId());
        ManagedVSR current = activeVSR.get();
        }
     * Clears the frozen VSR slot after it has been closed.
     * @param vsr the ManagedVSR to close
import java.util.concurrent.atomic.AtomicReference;
        if (current == null || !shouldRotateVSR(current)) {
    private volatile Schema schema;
     * Returns the frozen VSR.
        this.schema = schema;
     * @param schema Arrow schema for VSR creation
import org.opensearch.arrow.allocator.AllocationRejection;
    private final String poolId;
    /**
 *
        this.schema = newSchema;
    }
        }
     * @param newSchema the updated schema
     * @return true if rotation occurred, false if not needed or skipped
 * if instances are shared across threads.
     * @throws IllegalStateException if the frozen slot is empty or the VSR is not closed
        }
 * skipped and the active VSR continues accepting writes beyond the threshold.
 *
 *
     *
                if (firstException != null) firstException.addSuppressed(e);
    }
     * @param poolId unique identifier for this pool
     * If the frozen slot is still occupied, rotation is skipped and the active VSR
        this.poolId = poolId;
/**
        ManagedVSR newVSR = AllocationRejection.wrap("vsr-rotation-" + poolId, this::createNewVSR);
     */
        }
        ManagedVSR active = activeVSR.get();
        ManagedVSR frozen = frozenVSR.get();
 * SPDX-License-Identifier: Apache-2.0
        return vsr.getRowCount() >= maxRowsPerVSR;
     * Checks if rotation is needed and performs it if safe.
            freezeVSR(current);
 * <p>Handles row-count-based rotation: when the active VSR reaches the configured
    private final AtomicInteger vsrCounter;
                else firstException = e;
        return activeVSR.get();
    }
 */
        this.maxRowsPerVSR = maxRowsPerVSR;
     * @return the frozen ManagedVSR, or null if none
        if (active != null) {
    }
    /**
     * are added to the active VSR so that subsequent VSRs include those fields.
    }
        if (current.getRowCount() > 0) {
    private ManagedVSR createNewVSR() {
            }
        initializeActiveVSR();
            } catch (Exception e) {
    }
                frozen.close();
    }
     */
    public void updateSchema(Schema newSchema) {
    }
 * this file be licensed under the Apache-2.0 license or a
     * @param bufferPool shared Arrow buffer pool
 * <p>Each new VSR receives its own child allocator from the shared {@link ArrowBufferPool},
    }
        if (frozen != null) {
     *
            try {
    }
    public boolean maybeRotateActiveVSR() throws IOException {
    public ManagedVSR getActiveVSR() {
     * Returns the active VSR.
    private static final Logger logger = LogManager.getLogger(VSRPool.class);
     *
    }
/*
        return frozenVSR.get();
            return false;
     * @param maxRowsPerVSR row threshold triggering rotation
     * @return the active ManagedVSR
    /**
            return false;
        if (VSRState.CLOSED.equals(frozen.getState()) == false) {
import org.opensearch.parquet.memory.ArrowBufferPool;
}
        // Startup-time VSR creation in initializeActiveVSR() is intentionally not wrapped:
        // a failure there is a framework misconfiguration, not a backpressure signal.
    /**
                frozenVSR.compareAndSet(frozen, null);
        this.vsrCounter = new AtomicInteger(0);
import org.apache.logging.log4j.LogManager;
        ManagedVSR previousFrozen = frozenVSR.get();
        return true;
    public void completeVSR(ManagedVSR vsr) {
                activeVSR.compareAndSet(active, null);
     *
import org.apache.arrow.memory.BufferAllocator;
     */
 * The OpenSearch Contributors require contributions made to
        // VSR rotation is a per-request operation: the active VSR filled up during ingest
        frozenVSR.set(null);
        }
     * continues accepting writes beyond the threshold.
    public void unsetFrozenVSR() {
    /**
     */
        ManagedVSR frozen = frozenVSR.get();
 */
        }
        vsr.close();
    private final int maxRowsPerVSR;
    }
                    active.moveToFrozen();
    public ManagedVSR getFrozenVSR() {
     * @throws IOException if the active VSR swap fails unexpectedly
     *
                firstException = e;
     */
     *
 * {@code maxRowsPerVSR} threshold, it is frozen and a new active VSR is created.
        if (frozen == null) {
    public void close() {
     * Updates the schema used for creating new VSRs. Called when dynamic fields
        if (firstException != null) {
            throw new IOException("Failed to set new active VSR during rotation");
     *
import org.apache.logging.log4j.Logger;
            throw new RuntimeException("VSRPool cleanup failed", firstException);
        if (activeVSR.compareAndSet(current, newVSR) == false) {
package org.opensearch.parquet.vsr;
import java.util.concurrent.atomic.AtomicInteger;
 * <p>This class is NOT Thread-Safe. External synchronization is required
        if (frozenVSR.get() != null) {
    private final AtomicReference<ManagedVSR> frozenVSR;
        // OpenSearchRejectedExecutionException (HTTP 429) instead of Arrow's raw OOM.
        vsr.moveToFrozen();
    public VSRPool(String poolId, Schema schema, ArrowBufferPool bufferPool, int maxRowsPerVSR) {
    /**
