 * </ol>  
 *   <li><strong>Fields layer</strong> ({@link org.opensearch.parquet.fields}) —
 * <h2>Data Flow</h2>
 * </pre>  
 *
/*  
 *          → VSRPool rotation (when row threshold reached)  
 *   <li><strong>Memory layer</strong> ({@link org.opensearch.parquet.memory}) —
 *       organized via a plugin registry pattern.</li>  
 *
 * The OpenSearch Contributors require contributions made to  
 * @see org.opensearch.parquet.ParquetSettings  
 * <h2>Architecture Overview</h2>  
 *       Arrow buffer allocation with configurable limits derived from node settings.</li>
 * <ol>
 *          → VSRManager.addDocument (field transfer to Arrow vectors)
 *       JNI bridge to the native Rust Parquet writer, handling Arrow C Data Interface
 * @see org.opensearch.parquet.ParquetDataFormatPlugin
 *   <li><strong>Plugin layer</strong> ({@link org.opensearch.parquet.ParquetDataFormatPlugin}) —  
 * SPDX-License-Identifier: Apache-2.0
 * using Apache Arrow as the in-memory columnar representation and a native Rust backend  
 *          → flush/close (Parquet file finalization + fsync)
 * compatible open source license.
 * <p>The plugin follows a layered pipeline:
 *          → NativeParquetWriter.write (Arrow C Data export to Rust)
 *   <li><strong>Engine layer</strong> ({@link org.opensearch.parquet.engine}) —
 * <p>This plugin enables columnar Parquet file generation from OpenSearch indexing operations
 *       Extensible type mapping from OpenSearch field types to Arrow vector types,
 * Document → ParquetDocumentInput (field collection)
 *       Manages Arrow {@code VectorSchemaRoot} instances with ACTIVE/FROZEN/CLOSED lifecycle,
 *
 *
 * (via JNI) for high-performance Parquet file writing.
 *       Accepts documents as field-value pairs, delegates batching to the VSR layer.</li>  
 *
 *   <li><strong>Bridge layer</strong> ({@link org.opensearch.parquet.bridge}) —
 *       Implements the {@code IndexingExecutionEngine} interface, managing writer lifecycle  
 *       and file generation per writer generation.</li>
 */  
 *   <li><strong>Writer layer</strong> ({@link org.opensearch.parquet.writer}) —
package org.opensearch.parquet;
 * Parquet data format plugin for OpenSearch.  
 */
/**
 *       Entry point that registers settings and creates the indexing engine per shard.</li>
 *       pointer exchange and native resource lifecycle.</li>  
 * <pre>  
 *       row-count-based rotation, and memory-bounded batching.</li>  
 *   <li><strong>VSR layer</strong> ({@link org.opensearch.parquet.vsr}) —
 * this file be licensed under the Apache-2.0 license or a
