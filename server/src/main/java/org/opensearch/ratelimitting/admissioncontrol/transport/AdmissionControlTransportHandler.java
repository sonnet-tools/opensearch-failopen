        super();
        this.actualHandler = actualHandler;  
        AdmissionControlService admissionControlService,  
        TransportRequestHandler<T> actualHandler,
 */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
     * @param task Current task that is executing  
import org.opensearch.transport.TransportRequest;
    }
    }
 * The OpenSearch Contributors require contributions made to  
    public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
            }
import org.opensearch.transport.TransportRequestHandler;  
                channel.sendResponse(openSearchRejectedExecutionException);  
    protected final Logger log = LogManager.getLogger(this.getClass());
        // skip admission control if force execution is true
 * SPDX-License-Identifier: Apache-2.0
        this.admissionControlActionType = admissionControlActionType;  
}  
 *
     * @param channel Transport channel allows to send a response to a request
            } catch (final OpenSearchRejectedExecutionException openSearchRejectedExecutionException) {
        AdmissionControlActionType admissionControlActionType
                return;
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
    ) {  
 * AdmissionControl Handler to intercept Transport Requests.  
    private final TransportRequestHandler<T> actualHandler;  
        this.action = action;
    @Override  
 */  
            try {
     * @throws Exception when admission control rejected the requests
/**
 * @param <T> Transport Request
/*  
import org.apache.logging.log4j.LogManager;
package org.opensearch.ratelimitting.admissioncontrol.transport;
    private final String action;
        this.admissionControlService = admissionControlService;
                this.admissionControlService.applyTransportAdmissionControl(this.action, this.admissionControlActionType);  
import org.opensearch.transport.TransportChannel;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
    public AdmissionControlTransportHandler(  
        actualHandler.messageReceived(request, channel, task);
        this.forceExecution = forceExecution;
            // intercept the transport requests here and apply admission control
public class AdmissionControlTransportHandler<T extends TransportRequest> implements TransportRequestHandler<T> {  
     */
    boolean forceExecution;  
     * @param request Transport Request that landed on the node
    /**  
 * compatible open source license.
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
import org.opensearch.tasks.Task;  
        boolean forceExecution,
                log.warn(openSearchRejectedExecutionException.getMessage());
        }  
    AdmissionControlActionType admissionControlActionType;
        if (!this.forceExecution) {  
    AdmissionControlService admissionControlService;
        String action,
