 *
 * compatible open source license.
/**  
 * provide a way to execute the term frequency function for a given document ID.  
 * The OpenSearch Contributors require contributions made to  
 *
 * An interface representing a term frequency function used to compute document scores
 */  
import java.io.IOException;
 */  
 * based on specific term frequency calculations. Implementations of this interface should
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.query.functionscore;
/*  
    Object execute(int docId) throws IOException;
}  
public interface TermFrequencyFunction {
 * SPDX-License-Identifier: Apache-2.0
