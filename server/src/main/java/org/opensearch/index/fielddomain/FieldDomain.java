 * a date field domain can describe the minimum and maximum timestamp values present in the index, while a future term
 * routing decisions, request planning, or search optimizations. Implementations are type-specific, and consumers are
    /**  
 * The OpenSearch Contributors require contributions made to  
    /**
     * Metadata type used to select the parser/evaluator implementation.
 * domains must be treated conservatively by consumers.
 *
 * this file be licensed under the Apache-2.0 license or a
 *
 *
 */  
@ExperimentalApi
 * @opensearch.experimental  
 * SPDX-License-Identifier: Apache-2.0
    String field();
     */
 *  
 * The metadata is intentionally generic. Different OpenSearch features may use it for different purposes, such as
package org.opensearch.index.fielddomain;
 * domain could describe a trusted set of known keyword values.
import org.opensearch.common.annotation.ExperimentalApi;
 * A field domain is an index-side summary of values that documents in the index may contain for a field. For example,  
 * compatible open source license.
/**  
 */
    /**
     */
public interface FieldDomain {  
     */  
 * responsible for interpreting only the domain types they understand. Incomplete, stale, unsupported, or untrusted  
 * Index-level metadata describing the value domain of one field in one concrete index.
    String type();  
}  
    boolean finalized();
/*  
     * Whether this domain is trusted as complete for consumers that require closed index-level value metadata.  
     * Field name this domain describes.
