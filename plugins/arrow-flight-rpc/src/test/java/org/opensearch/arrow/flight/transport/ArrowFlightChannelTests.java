 *
import static org.mockito.Mockito.when;  
package org.opensearch.arrow.flight.transport;
import org.opensearch.transport.TcpChannel;
        assertTrue(ex.getMessage().contains("not backed by an ArrowFlightChannel"));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ArrowFlightChannel.from(taskChannel));
    }  
 */  
import static org.mockito.Mockito.mock;
import org.opensearch.transport.TaskTransportChannel;
        assertSame(mockAllocator, result.getAllocator());
        when(taskChannel.getChannel()).thenReturn(baseTcpChannel);
import org.apache.arrow.memory.BufferAllocator;
        assertTrue(ex.getMessage().contains("not backed by an ArrowFlightChannel"));
import org.opensearch.transport.TransportChannel;  
        // Simulate: TaskTransportChannel -> BaseTcpTransportChannel -> FlightServerChannel
        TransportChannel plainChannel = mock(TransportChannel.class);  
import org.opensearch.test.OpenSearchTestCase;
/*  
    }  
        when(baseTcpChannel.getChannel()).thenReturn(serverChannel);
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public void testFromWithTaskChannelWrappingBaseTcpChannel() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ArrowFlightChannel.from(plainChannel));
        TcpChannel regularTcpChannel = mock(TcpChannel.class);  
        when(serverChannel.getAllocator()).thenReturn(mockAllocator);
 * SPDX-License-Identifier: Apache-2.0
    }  
        TaskTransportChannel taskChannel = mock(TaskTransportChannel.class);
import org.opensearch.transport.BaseTcpTransportChannel;  
        when(baseTcpChannel.getChannel()).thenReturn(regularTcpChannel);
        BufferAllocator mockAllocator = mock(BufferAllocator.class);
}
        when(taskChannel.getChannel()).thenReturn(baseTcpChannel);
        FlightServerChannel serverChannel = mock(FlightServerChannel.class);  
    public void testFromWithNonFlightChannelThrows() {
public class ArrowFlightChannelTests extends OpenSearchTestCase {
        BaseTcpTransportChannel baseTcpChannel = mock(BaseTcpTransportChannel.class);
        ArrowFlightChannel result = ArrowFlightChannel.from(taskChannel);
    public void testFromWithTaskChannelWrappingNonFlightTcpChannel() {
        TaskTransportChannel taskChannel = mock(TaskTransportChannel.class);
        BaseTcpTransportChannel baseTcpChannel = mock(BaseTcpTransportChannel.class);
 * this file be licensed under the Apache-2.0 license or a
