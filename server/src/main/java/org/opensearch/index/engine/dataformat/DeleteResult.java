 *
 * this file be licensed under the Apache-2.0 license or a
    }  
     * @param seqNo the sequence number
 *
     * Failed delete result.
     *
}
    /**  
     */
    }
    record Success(long version, long primaryTerm, long seqNo) implements DeleteResult {  
     *
     * @param version the version after to delete
 */
     */
 * Result of a delete operation. Sealed hierarchy with {@link Success} and {@link Failure} variants.
     * @param cause the exception that caused the failure  
/*  
@ExperimentalApi
 */  
/**  
    record Failure(Exception cause) implements DeleteResult {
     * @param primaryTerm the primary term  
package org.opensearch.index.engine.dataformat;
public sealed interface DeleteResult permits DeleteResult.Success, DeleteResult.Failure {  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    /**
 * SPDX-License-Identifier: Apache-2.0
     * Successful delete result.  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental  
