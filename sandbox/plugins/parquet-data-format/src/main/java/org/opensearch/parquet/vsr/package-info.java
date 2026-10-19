 */  
 * compatible open source license.
 *       the VSR pool with the native Parquet writer, handling document ingestion, VSR rotation,
 * The OpenSearch Contributors require contributions made to  
 * addDocument() → row count reaches threshold
 * Each VSR follows a strict state machine: {@code ACTIVE → FROZEN → CLOSED}.
 *   <li>{@link org.opensearch.parquet.vsr.VSRManager} — Top-level orchestrator that combines
 *       that enforces state transitions and provides Arrow C Data Interface export.</li>
 *
 */  
 *
 *       batch export, and file finalization.</li>  
 * </ul>
 * @see org.opensearch.parquet.vsr.VSRPool
 * SPDX-License-Identifier: Apache-2.0
/*  
 *   <li>{@link org.opensearch.parquet.vsr.VSRState} — Enum defining the three lifecycle states.</li>
package org.opensearch.parquet.vsr;
 *       handling row-count-based rotation when the configurable threshold is reached.</li>  
 * </pre>
 * <ul>
 * VectorSchemaRoot (VSR) lifecycle management for Arrow-based batching.  
 *   <li>{@link org.opensearch.parquet.vsr.ManagedVSR} — Wrapper around a single {@code VectorSchemaRoot}  
 *
 *              → frozen VSR exported to native writer via Arrow C Data Interface
 *
 *              → active VSR frozen, moved to frozen slot  
/**
 * <pre>
 * @see org.opensearch.parquet.ParquetSettings#MAX_ROWS_PER_VSR
 * <h2>Rotation Flow</h2>  
 * this file be licensed under the Apache-2.0 license or a
 *              → new active VSR created from pool  
 * <p>This package manages the lifecycle of Apache Arrow {@code VectorSchemaRoot} instances
 *   <li>{@link org.opensearch.parquet.vsr.VSRPool} — Manages one ACTIVE and one FROZEN VSR slot,
 *
 *              → frozen VSR closed and released
 * <h2>Key Classes</h2>  
 * used as in-memory columnar batches before they are exported to the native Parquet writer.  
 * @see org.opensearch.parquet.vsr.VSRManager  
