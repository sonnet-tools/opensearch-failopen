import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.Version;
 * compatible open source license.
                new ThreadContext(Settings.EMPTY),
            return request.serialize(new BytesStreamOutput());
                false,
            );
import org.opensearch.common.settings.Settings;
@TestLogging(value = "org.opensearch.transport.TransportLogger:trace", reason = "to ensure we log network events on TRACE level")
import org.opensearch.transport.TransportLoggerTests;  
import java.io.IOException;
            NativeOutboundMessage.Request request = new NativeOutboundMessage.Request(
import org.opensearch.test.junit.annotations.TestLogging;
 * The OpenSearch Contributors require contributions made to  
    public BytesReference buildRequest() throws IOException {
                new String[0],  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;
                compress  
        boolean compress = randomBoolean();
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;  
        try (BytesStreamOutput bytesStreamOutput = new BytesStreamOutput()) {  
import org.opensearch.common.util.concurrent.ThreadContext;  
/*  
        }  
 *
package org.opensearch.transport.nativeprotocol;
                new ClusterStatsRequest(),
 */  
                randomInt(30),
                ClusterStatsAction.NAME,  
public class NativeTransportLoggerTests extends TransportLoggerTests {
                Version.CURRENT,
    }
import org.opensearch.core.common.bytes.BytesReference;
}
