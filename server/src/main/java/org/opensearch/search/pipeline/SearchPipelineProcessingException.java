    SearchPipelineProcessingException(Exception cause) {
 * The OpenSearch Contributors require contributions made to  
 *
 */  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        super(in);
/*  
import org.opensearch.OpenSearchException;
 * compatible open source license.
 * currently only unwrap causes for instances of {@link OpenSearchWrapperException}.  
}  
import org.opensearch.OpenSearchWrapperException;
        super(cause);  
    public SearchPipelineProcessingException(StreamInput in) throws IOException {  
public class SearchPipelineProcessingException extends OpenSearchException implements OpenSearchWrapperException {
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
package org.opensearch.search.pipeline;
 * A dedicated wrapper for exceptions encountered executing a search pipeline processor. The wrapper is needed as we
/**
    }
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
