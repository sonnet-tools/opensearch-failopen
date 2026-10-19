/*  
 * compatible open source license.
package org.opensearch.parquet.writer;
 */  
    public MismatchedInputException(String message, Throwable cause) {  
        super(message);  
 *
 * this file be licensed under the Apache-2.0 license or a
 * corresponding {@link org.opensearch.parquet.fields.ParquetField} mapping in the  
    }
 * known schema. The failure is per-document and recoverable: callers should surface
 * Thrown when a document presents a field whose declared type does not have a
        super(message, cause);
/**
 * writer can be rolled back and remain usable for subsequent docs.
 */
 * it as a {@link org.opensearch.index.engine.dataformat.WriteResult.Failure} so the  
 * The OpenSearch Contributors require contributions made to  
    }
    public MismatchedInputException(String message) {
 * SPDX-License-Identifier: Apache-2.0
 * Arrow field registry — i.e., the input schema is incompatible with the writer's
}  
public class MismatchedInputException extends IllegalArgumentException {  
