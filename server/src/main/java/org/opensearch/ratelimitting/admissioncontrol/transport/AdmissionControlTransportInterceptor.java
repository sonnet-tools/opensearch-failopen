        boolean forceExecution,
    ) {
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
    public AdmissionControlTransportInterceptor(AdmissionControlService admissionControlService) {
            forceExecution,
 *
/**
 * SPDX-License-Identifier: Apache-2.0
    }
        AdmissionControlActionType admissionControlActionType
    @Override
import org.opensearch.transport.TransportInterceptor;  
 */  
        this.admissionControlService = admissionControlService;  
 * The OpenSearch Contributors require contributions made to  
    /**  
}
package org.opensearch.ratelimitting.admissioncontrol.transport;
 */  
        String action,  
    }
 * compatible open source license.
            admissionControlActionType
    public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
import org.opensearch.transport.TransportRequestHandler;
        TransportRequestHandler<T> actualHandler,  
 * this file be licensed under the Apache-2.0 license or a
            action,
            this.admissionControlService,  
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
 * This class allows throttling by intercepting requests on both the sender and the receiver side.
        );  
    AdmissionControlService admissionControlService;  
/*  
     * @return admissionController handler to intercept transport requests
public class AdmissionControlTransportInterceptor implements TransportInterceptor {
     */  
import org.opensearch.transport.TransportRequest;
        String executor,
     *
        return new AdmissionControlTransportHandler<>(  
            actualHandler,
