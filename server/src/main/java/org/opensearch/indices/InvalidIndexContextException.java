    @Override
}  
    }  
        super(in);
    /**  
/*  
 * this file be licensed under the Apache-2.0 license or a
     * @param indexName name of the index
     *
     * @param description error message
 */  
 * Exception when the context provided in the creation of an index is invalid.
        return RestStatus.BAD_REQUEST;
    public InvalidIndexContextException(StreamInput in) throws IOException {
    }
 * The OpenSearch Contributors require contributions made to  
/**
    }
        super("Invalid context name [{}] provide for index: {}, [{}]", name, indexName, description);
    public RestStatus status() {  
package org.opensearch.indices;
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 * compatible open source license.
public class InvalidIndexContextException extends OpenSearchException {
     * @param name context name provided  
    public InvalidIndexContextException(String indexName, String name, String description) {  
     */
 */  
import org.opensearch.core.rest.RestStatus;  
import org.opensearch.OpenSearchException;
