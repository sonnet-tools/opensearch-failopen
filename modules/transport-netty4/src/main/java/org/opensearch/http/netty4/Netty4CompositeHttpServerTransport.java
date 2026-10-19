 *
    private final AbstractHttpServerTransport[] transports;  
    public HttpInfo info() {
    @Override  
        }
            serverOpen += stats.getServerOpen();
 */  
        }
    }
    }
}  
        long serverOpen = 0L, totalOpen = 0L;
        }  
    public Netty4CompositeHttpServerTransport(AbstractHttpServerTransport... transports) {
        return transports[0].info();
    public HttpStats stats() {  
import org.opensearch.http.HttpStats;
package org.opensearch.http.netty4;
    protected void doStart() {
            throw new IllegalArgumentException("At least one transport must be provided");
            transport.start();  
    }  
        for (AbstractHttpServerTransport transport : transports) {
            IOUtils.closeWhileHandlingException(transport);
    AbstractHttpServerTransport[] transports() {  
            transport.stop();
    }
    @Override  
        for (AbstractHttpServerTransport transport : transports) {
        for (AbstractHttpServerTransport transport : transports) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.http.HttpInfo;
    }
import org.opensearch.http.AbstractHttpServerTransport;
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
    @Override
            final HttpStats stats = transport.stats();
        return transports[0].boundAddress(); /* both transports bind to the same port but different protocol */  
    }  
    @Override
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.transport.BoundTransportAddress;  
public class Netty4CompositeHttpServerTransport extends AbstractLifecycleComponent implements HttpServerTransport {
            totalOpen += stats.getTotalOpen();  
    protected void doClose() throws IOException {  
    @Override
    @Override
        return new HttpStats.Builder().serverOpen(serverOpen).totalOpen(totalOpen).build();  
        return transports;
        this.transports = transports;
 * compatible open source license.
        }
        }
    public BoundTransportAddress boundAddress() {
    protected void doStop() {
        for (AbstractHttpServerTransport transport : transports) {  
        if (transports == null || transports.length == 0) {  
    }
import org.opensearch.http.HttpServerTransport;  
    }
