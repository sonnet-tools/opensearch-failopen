    }
 * Receive-side base for handlers that consume {@link ArrowBatchResponse}. Pins
}
        return true;  
 * the native Arrow path instead of byte deserialization.
    protected ArrowBatchResponseHandler() {}
 *
 */  
 */
import org.opensearch.common.annotation.ExperimentalApi;
 *
    /** Constructor. */
import org.opensearch.transport.StreamTransportResponseHandler;
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
/*  
 * compatible open source license.
/**
    @Override
public abstract class ArrowBatchResponseHandler<T extends ArrowBatchResponse> implements StreamTransportResponseHandler<T> {  
 * {@link #skipsDeserialization()} to {@code true} so an Arrow-aware transport routes to  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.arrow.transport;
    public final boolean skipsDeserialization() {
 * @opensearch.experimental  
 * SPDX-License-Identifier: Apache-2.0
