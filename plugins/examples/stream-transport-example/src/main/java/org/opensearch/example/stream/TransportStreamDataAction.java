     */  
                channel.sendResponse(e);
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 1; i <= request.getCount(); i++) {
            StreamDataRequest::new,  
import org.opensearch.transport.StreamTransportService;  
    private void handleStreamRequest(StreamDataRequest request, TransportChannel channel, Task task) throws IOException {
    @Override
    }
     */  
import org.apache.logging.log4j.LogManager;
    protected void doExecute(Task task, StreamDataRequest request, ActionListener<StreamDataResponse> listener) {  
    }
import org.opensearch.action.support.ActionFilters;  
}
            ThreadPool.Names.GENERIC,
        } catch (StreamException e) {
                logger.info("Client cancelled stream: {}", e.getMessage());  
            channel.completeStream();
package org.opensearch.example.stream;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.stream.StreamErrorCode;
        } catch (Exception e) {
    /**
 * The OpenSearch Contributors require contributions made to  
/**
     * Constructor - registers streaming handler  
            }  
        }  
        try {
 */  
 * Demonstrates streaming transport action that sends multiple responses for a single request
            }  
 * compatible open source license.
        super(StreamDataAction.NAME, actionFilters, streamTransportService.getTaskManager());  
    public TransportStreamDataAction(StreamTransportService streamTransportService, ActionFilters actionFilters) {
import org.opensearch.transport.TransportChannel;
/*  
                channel.sendResponseBatch(response);
    @Inject
    private static final Logger logger = LogManager.getLogger(TransportStreamDataAction.class);  
import org.opensearch.tasks.Task;
                if (i < request.getCount() && request.getDelayMs() > 0) {  
import java.io.IOException;
                StreamDataResponse response = new StreamDataResponse("Stream data item " + i, i, i == request.getCount());
    /**
import org.opensearch.common.inject.Inject;
     * Handles streaming request by sending multiple batched responses
public class TransportStreamDataAction extends TransportAction<StreamDataRequest, StreamDataResponse> {
            this::handleStreamRequest
import org.opensearch.action.support.TransportAction;
import org.opensearch.transport.stream.StreamException;  
            StreamDataAction.NAME,
                    Thread.sleep(request.getDelayMs());
 *
        listener.onFailure(new UnsupportedOperationException("Use StreamTransportService for streaming requests"));
            // Send multiple responses  
import org.opensearch.core.action.ActionListener;  
                }
     * @param streamTransportService the stream transport service
 */  
        // Register handler for streaming requests
import org.apache.logging.log4j.Logger;
        streamTransportService.registerRequestHandler(  
     * @param actionFilters action filters
    }  
        );
import org.opensearch.threadpool.ThreadPool;
            if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
            } else {
            channel.sendResponse(e);
