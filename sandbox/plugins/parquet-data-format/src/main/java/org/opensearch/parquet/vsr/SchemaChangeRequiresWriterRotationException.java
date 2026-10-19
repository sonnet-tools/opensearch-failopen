        super("Field [" + fieldName + "] changed Parquet type from [" + previousType + "] to [" + nextType + "]");
 * Signals that an existing Arrow vector changed type and the current Parquet file must be
/**
 * compatible open source license.
    public SchemaChangeRequiresWriterRotationException(String fieldName, Object previousType, Object nextType) {
 * finalized before indexing can continue with the new schema.  
 * this file to be licensed under the Apache-2.0 license or a
    }  
public class SchemaChangeRequiresWriterRotationException extends RuntimeException {
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
 */
 * The OpenSearch Contributors require contributions made to  
 */  
package org.opensearch.parquet.vsr;
}
