        final Object hook = options.get("grpc.builderConsumer");  
        // Recover the consumer the same way OSFlightServer.build() does (builderOptions is private).
/**
 * {@link OSFlightServer.Builder#build()} applies to the live builder. The hint is best-effort ("not
        NettyServerBuilder nettyBuilder = NettyServerBuilder.forPort(0);
import io.grpc.netty.NettyServerBuilder;  
            TimeUnit.MILLISECONDS.toNanos(keepAliveTimeoutMs),
        return f.getLong(builder);
 * compatible open source license.
import org.opensearch.common.SuppressForbidden;
            readLongField(nettyBuilder, "keepAliveTimeInNanos")  
        assertNotNull("grpc.builderConsumer hint must be stored on the builder", hook);
        assertEquals(  
        OSFlightServer.Builder builder = OSFlightServer.builder();
import java.lang.reflect.Field;
            b.keepAliveTime(keepAliveMs, TimeUnit.MILLISECONDS);
        final Map<String, Object> options = (Map<String, Object>) optionsField.get(builder);
    }
            "keepAliveTime must be applied to the gRPC builder",
 *
 * gRPC versions: it registers the same consumer, recovers it from the builder's options, applies it to  
        f.setAccessible(true);  
 * Proves the gRPC keepalive wiring actually reaches the {@link NettyServerBuilder}.  
 * this file be licensed under the Apache-2.0 license or a
        ((Consumer<NettyServerBuilder>) hook).accept(nettyBuilder);  
        // And confirm the exact values landed by reading gRPC's own keepalive fields (nanos).
    public void testKeepAliveConsumerReachesNettyServerBuilder() throws Exception {  
        // Register the consumer exactly as FlightTransport does.
        optionsField.setAccessible(true);
    @SuppressForbidden(reason = "reads private builderOptions + gRPC keepalive fields to verify the hint is applied")
            readLongField(nettyBuilder, "keepAliveTimeoutInNanos")
        });  
}  
public class OSFlightServerKeepAliveTests extends OpenSearchTestCase {
 */
import java.util.function.Consumer;
 * guaranteed to have any effect"), so this test guards that the key is honored on the pinned Arrow /
 * <p>{@code FlightTransport} configures server keepalive by registering a
    private static long readLongField(NettyServerBuilder builder, String name) throws Exception {
        final Field f = NettyServerBuilder.class.getDeclaredField(name);
        final long keepAliveMs = 60_000L;
        );  
            b.keepAliveTimeout(keepAliveTimeoutMs, TimeUnit.MILLISECONDS);
 *
 * values landed. If an Arrow upgrade ever dropped/renamed the hook, or the gRPC keepalive API changed,
            "keepAliveTimeout must be applied to the gRPC builder",  
import java.util.Map;
        // honored and the gRPC keepAliveTime/keepAliveTimeout(long, TimeUnit) signatures still match.
        final long keepAliveTimeoutMs = 20_000L;
package org.apache.arrow.flight;
 * The OpenSearch Contributors require contributions made to  
 * {@code Consumer<NettyServerBuilder>} under the {@code "grpc.builderConsumer"} transport hint, which  
    }
 * SPDX-License-Identifier: Apache-2.0
        // Apply it to a real NettyServerBuilder. accept() not throwing already proves the hint key is  
    @SuppressWarnings("unchecked")
            TimeUnit.MILLISECONDS.toNanos(keepAliveMs),
 * this fails instead of the keepalive silently becoming a no-op.  
        );
 */  
        final Field optionsField = OSFlightServer.Builder.class.getDeclaredField("builderOptions");  
        builder.transportHint("grpc.builderConsumer", (Consumer<NettyServerBuilder>) b -> {  
import java.util.concurrent.TimeUnit;  
 * a real {@link NettyServerBuilder}, and reads back gRPC's own keepalive fields to confirm the exact
    @SuppressForbidden(reason = "reads gRPC's private keepalive field to verify the value was applied")  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(
/*  
