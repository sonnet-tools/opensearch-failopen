    /**  
     */
        (s) -> Setting.parseInt(s, 1, "transport.netty.worker_count"),
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.common.settings.Setting;
 * The OpenSearch Contributors require contributions made to  
 * The transport implementations based on Reactor Netty (see please {@link TcpServer}).
        Property.NodeScope  
/**
     */
public class ReactorNetty4Transport {
}
        "transport.netty.worker_count",  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
import org.opensearch.common.settings.Setting.Property;
 * compatible open source license.
package org.opensearch.transport.reactor.netty4;
 */  
import reactor.netty.tcp.TcpServer;
    );
    /**
     * Default constructor
        (s) -> Integer.toString(OpenSearchExecutors.allocatedProcessors(s)),
 */  
 * SPDX-License-Identifier: Apache-2.0
    public ReactorNetty4Transport() {}  
    public static final Setting<Integer> SETTING_WORKER_COUNT = new Setting<>(
     * The number of Netty workers  
/*  
