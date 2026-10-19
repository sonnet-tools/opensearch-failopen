        if (!response.getStatus()) {  
import java.io.IOException;  
/*  
 */  
/**
        }
public class UpdateSettingsResponseHandler implements TransportResponseHandler<AcknowledgedResponse> {
import org.opensearch.threadpool.ThreadPool;
        return ThreadPool.Names.GENERIC;  
    public void handleException(TransportException exp) {  
import org.opensearch.transport.TransportResponseHandler;
        return new AcknowledgedResponse(in);  
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    @Override
        logger.error(new ParameterizedMessage("UpdateSettingsRequest failed"), exp);
            handleException(new TransportException("Request was not completed successfully"));
 * SPDX-License-Identifier: Apache-2.0
    public String executor() {
    @Override
 * @opensearch.internal
        logger.info("response {}", response.getStatus());
    public void handleResponse(AcknowledgedResponse response) {
package org.opensearch.extensions;
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
import org.opensearch.transport.TransportException;  
    @Override  
    private static final Logger logger = LogManager.getLogger(UpdateSettingsResponseHandler.class);
    }  
    public AcknowledgedResponse read(StreamInput in) throws IOException {
}
 */  
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * Response handler for {@link UpdateSettingsRequest}  
import org.apache.logging.log4j.Logger;
 *
    }
 *
    }
 * The OpenSearch Contributors require contributions made to  
