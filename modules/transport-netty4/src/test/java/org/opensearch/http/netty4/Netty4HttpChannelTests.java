    }  
        final Optional<Channel> channelOpt = netty4HttpChannel.get("channel", Channel.class);  
    }  
import static org.hamcrest.CoreMatchers.sameInstance;  
import org.opensearch.transport.Netty4NioSocketChannel;
    public void testChannelAttributeMatchesChannel() {
    @Override
    }  
 */  
        assertThat(channelOpt.isEmpty(), is(true));
    public void testChannelAttributeIsEmpty() {
public class Netty4HttpChannelTests extends OpenSearchTestCase {
        assertThat(channelOpt.get(), sameInstance(channel));
package org.opensearch.http.netty4;
        final Optional<ChannelOutboundInvoker> channelOpt = netty4HttpChannel.get("channel", ChannelOutboundInvoker.class);  
 * this file be licensed under the Apache-2.0 license or a
    public void testChannelAttributeMatchesChannelOutboundInvoker() {
    @Before  
        netty4HttpChannel = new Netty4HttpChannel(channel);
        assertThat(channelOpt.isPresent(), is(true));
 * The OpenSearch Contributors require contributions made to  
import io.netty.channel.Channel;
import static org.hamcrest.CoreMatchers.is;
    private Channel channel;
    }
    public void setUp() throws Exception {
 * compatible open source license.
import io.netty.channel.ServerChannel;  
 *
        channel = new Netty4NioSocketChannel();
import org.junit.Before;  
        final Optional<ServerChannel> channelOpt = netty4HttpChannel.get("channel", ServerChannel.class);  
 * SPDX-License-Identifier: Apache-2.0
    private Netty4HttpChannel netty4HttpChannel;  
import io.netty.channel.ChannelOutboundInvoker;
        super.setUp();  
        assertThat(channelOpt.isPresent(), is(true));
}  
/*  
import org.opensearch.test.OpenSearchTestCase;
        assertThat(channelOpt.get(), sameInstance(channel));
import java.util.Optional;
