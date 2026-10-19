 */  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        return RestStatus.BAD_REQUEST;  
    }
    public IngestionEngineException(StreamInput in) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    @Override
/**
/*  
    public IngestionEngineException(String message) {
import org.opensearch.OpenSearchWrapperException;
    public RestStatus status() {
 */  
        super(in);
 *
public class IngestionEngineException extends OpenSearchException implements OpenSearchWrapperException {
import org.opensearch.OpenSearchException;
 *
import java.io.IOException;  
 * compatible open source license.
 * @opensearch.internal
package org.opensearch.index.engine;
}
 * Exception thrown when there is an error in the ingestion engine.  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
        super(message);  
import org.opensearch.core.rest.RestStatus;
