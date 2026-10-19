 *  
 *
 *
 * <h2>Sub-packages</h2>
 * SPDX-License-Identifier: Apache-2.0
 *   <li>{@link org.opensearch.parquet.fields.core.data.date} — Date/timestamp field implementations.</li>
 * </ul>
 *       and resolving each mapper to its registered Arrow type.</li>
 * @see org.opensearch.parquet.fields.ArrowFieldRegistry  
 * this file be licensed under the Apache-2.0 license or a
 *   <li>{@link org.opensearch.parquet.fields.ArrowSchemaBuilder} — Utility that builds an Arrow
 * <h2>Key Classes</h2>  
/*  
 *   <li>{@link org.opensearch.parquet.fields.ArrowFieldRegistry} — Singleton registry mapping
 * instances to their corresponding Apache Arrow vector types. The mapping is used during document  
 * compatible open source license.
 *       {@code ParquetField} implementations. Populated at class load via field plugins.</li>
 * The OpenSearch Contributors require contributions made to  
 * @see org.opensearch.parquet.fields.ParquetField
 */
 * <ul>
 *   <li>{@link org.opensearch.parquet.fields.core.metadata} — OpenSearch metadata field implementations.</li>
 * ingestion to write field values into the correct Arrow vectors within a {@code VectorSchemaRoot}.
 * <p>This package provides the extensible type system that maps OpenSearch {@code MappedFieldType}
 *
 * </ul>  
 * Field type mapping between OpenSearch and Apache Arrow for Parquet generation.  
 *       {@code Schema} from a {@code MapperService}, filtering unsupported metadata fields  
 */  
 *       OpenSearch type names (e.g., {@code "integer"}, {@code "keyword"}) to their  
 *   <li>{@link org.opensearch.parquet.fields.plugins} — Plugin interface and built-in registrations.</li>  
 *   <li>{@link org.opensearch.parquet.fields.core.data} — Data field implementations (boolean, binary).</li>
/**
 *       type implementations extend. Defines the contract for Arrow type declaration and  
 *   <li>{@link org.opensearch.parquet.fields.core.data.number} — Numeric field implementations.</li>
 *       value writing into managed VSR vectors.</li>
 *   <li>{@link org.opensearch.parquet.fields.core.data.text} — Text-based field implementations.</li>  
 * <ul>
package org.opensearch.parquet.fields;
 *   <li>{@link org.opensearch.parquet.fields.ParquetField} — Abstract base class that all field
 *
