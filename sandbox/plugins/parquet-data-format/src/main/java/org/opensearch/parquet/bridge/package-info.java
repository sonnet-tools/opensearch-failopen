 * write(arrayAddress, schemaAddress)     — send a batch of Arrow data (repeatable)
 *  
 * finalizeWriter(filePath)                  — finalize Parquet file, returns metadata  
 * this file be licensed under the Apache-2.0 license or a
 * <pre>  
 *
 * <h2>Key Classes</h2>
 * syncToDisk(filePath)                  — fsync the file to durable storage
 *
 * compatible open source license.
 * @see org.opensearch.parquet.bridge.NativeParquetWriter
 * </pre>
 * The OpenSearch Contributors require contributions made to  
 * <h2>Writer Lifecycle</h2>
/*  
 * createWriter(filePath, schemaAddress)  — initialize native writer with Arrow schema
 * <p>This package provides the interface between Java and the native Rust library
 *       metadata returned by the native writer after file finalization.</li>
 * Communication uses the <a href="https://arrow.apache.org/docs/format/CDataInterface.html">
 *       the native writer with lifecycle management (create → write → close → flush).</li>
 */  
 * JNI bridge to the native Rust Parquet writer.  
 */  
package org.opensearch.parquet.bridge;
 *   <li>{@link org.opensearch.parquet.bridge.ParquetFileMetadata} — Immutable record of
/**
 *   <li>{@link org.opensearch.parquet.bridge.NativeParquetWriter} — Type-safe handle wrapping  
 * ({@code parquet_dataformat_jni}) that performs the actual Parquet file generation.  
 * SPDX-License-Identifier: Apache-2.0
 * Arrow C Data Interface</a>, exchanging memory addresses of Arrow arrays and schemas
 *       and native library loading. Writer lifecycle methods are package-private.</li>
 * across the JNI boundary without data copying.  
 *   <li>{@link org.opensearch.nativebridge.spi.ArrowExport} — RAII container for exported
 * <ul>  
 * @see org.opensearch.parquet.bridge.RustBridge
 * </ul>  
 *   <li>{@link org.opensearch.parquet.bridge.RustBridge} — Static JNI method declarations
 *
 *       Arrow C Data Interface pointers ({@code ArrowArray} + {@code ArrowSchema}).</li>  
 *
