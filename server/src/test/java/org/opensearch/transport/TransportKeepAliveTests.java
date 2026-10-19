        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
 */
import static org.mockito.Mockito.any;  
        keepAlive.registerNodeConnection(Collections.singletonList(channel1), connectionProfile1);
        }  
import org.opensearch.threadpool.TestThreadPool;
    private TransportKeepAlive keepAlive;  
    public void testNoKeepAliveResponseIfClient() {
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval).build();
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval1).build();
        assertEquals(0, threadPool.scheduledTasks.size());
 *    http://www.apache.org/licenses/LICENSE-2.0
            return null;
        TcpChannel channel2 = new FakeTcpChannel();
import java.util.ArrayDeque;
/*
    @Override  
 * specific language governing permissions and limitations
        taskTuple = threadPool.scheduledTasks.poll();
        keepAliveTask2.run();
        keepAlive.receiveKeepAlive(channel);
        verify(pingSender, times(2)).apply(same(channel2), eq(expectedPingMessage), any());  
 * KIND, either express or implied.  See the License for the
        task.run();
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());  
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval).build();  
 * You may obtain a copy of the License at  
        verify(pingSender, times(0)).apply(same(channel1), eq(expectedPingMessage), any());  
        }  
        TcpChannel channel = new FakeTcpChannel(false);
        private CapturingThreadPool() {
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());  
import org.opensearch.common.unit.TimeValue;
        TcpChannel channel1 = new FakeTcpChannel();
/*  
import java.util.Arrays;
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
        TcpChannel channel2 = new FakeTcpChannel();
}
    }
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());  
 * GitHub history for details.
 * not use this file except in compliance with the License.
        assertEquals(pingInterval2, taskTuple2.v1());  
        taskTuple.v2().run();  
    private AsyncBiFunction<TcpChannel, BytesReference, Void> pingSender;
        ConnectionProfile connectionProfile1 = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval1).build();  
        assertEquals(1, threadPool.scheduledTasks.size());  
            throw new AssertionError(e.getMessage(), e); // won't happen
        assertEquals(0, threadPool.scheduledTasks.size());
import static org.mockito.Mockito.same;  
/*
        assertEquals(0, threadPool.scheduledTasks.size());
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.AsyncBiFunction;  
    public void testRegisterNodeConnectionSchedulesKeepAlive() {  
import org.opensearch.core.common.bytes.BytesReference;
 */
 * Modifications Copyright OpenSearch Contributors. See  
        }  
    }
        // Test that the task has rescheduled itself
            scheduledTasks.add(new Tuple<>(delay, task));
        threadPool = new CapturingThreadPool();
        assertEquals(pingInterval, taskTuple.v1());
import org.opensearch.common.settings.Settings;  
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
package org.opensearch.transport;
        Runnable keepAliveTask2 = taskTuple1.v2();
        verify(pingSender, times(1)).apply(same(channel1), eq(expectedPingMessage), any());
 * license agreements. See the NOTICE file distributed with
import static org.mockito.Mockito.times;
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());  
            expectedPingMessage = out.bytes();  
    private BytesReference expectedPingMessage;
import org.opensearch.common.collect.Tuple;
import java.util.Collections;  
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
 * this work for additional information regarding copyright
        TimeValue pingInterval = TimeValue.timeValueSeconds(randomLongBetween(1, 60));
    }
        Runnable keepAliveTask1 = taskTuple1.v2();
 * under the License.  
        assertEquals(2, threadPool.scheduledTasks.size());
 * compatible open source license.
    @SuppressWarnings("unchecked")
        TimeValue pingInterval1 = TimeValue.timeValueSeconds(randomLongBetween(1, 30));
        TcpChannel channel = new FakeTcpChannel(true);
import static org.mockito.Mockito.verify;
    }
import org.opensearch.test.OpenSearchTestCase;  
        } catch (IOException e) {
    public void testKeepAliveResponseIfServer() {
 * ownership. Elasticsearch licenses this file to you under  
    }
import java.io.IOException;  
        keepAlive.registerNodeConnection(Collections.singletonList(channel2), connectionProfile2);  
 * Unless required by applicable law or agreed to in writing,
        @Override
        Runnable keepAliveTask = taskTuple.v2();  
        TimeValue pingInterval = TimeValue.timeValueSeconds(15);
        TcpChannel channel2 = new FakeTcpChannel();  
    public void setUp() throws Exception {
            super(getTestName());
        channel1.close();
        TcpChannel.ChannelStats stats = channel1.getChannelStats();
        keepAlive.receiveKeepAlive(channel);
        threadPool.shutdown();
 *
        Tuple<TimeValue, Runnable> taskTuple = threadPool.scheduledTasks.poll();
 * SPDX-License-Identifier: Apache-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    private CapturingThreadPool threadPool;
        stats.markAccessed(threadPool.relativeTimeInMillis() + (pingInterval.millis() / 2));  
        verify(pingSender, times(1)).apply(same(channel2), eq(expectedPingMessage), any());
        assertEquals(1, threadPool.scheduledTasks.size());  
        keepAlive = new TransportKeepAlive(threadPool, pingSender);  
        super.setUp();  
        assertEquals(1, threadPool.scheduledTasks.size());
        verify(pingSender, times(1)).apply(same(channel2), eq(expectedPingMessage), any());
        Tuple<TimeValue, Runnable> taskTuple = threadPool.scheduledTasks.poll();
import static org.mockito.Mockito.eq;
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());  
        taskTuple.v2().run();  
 */  
import static org.mockito.Mockito.mock;
    private final ConnectionProfile defaultProfile = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);  
 * the Apache License, Version 2.0 (the "License"); you may
        keepAlive.registerNodeConnection(Arrays.asList(channel1, channel2), connectionProfile);  
        TimeValue pingInterval2 = TimeValue.timeValueSeconds(randomLongBetween(31, 60));
        TcpChannel channel1 = new FakeTcpChannel();
        assertEquals(pingInterval1, taskTuple1.v1());
        keepAlive.registerNodeConnection(Collections.singletonList(channel2), connectionProfile);
    }
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
 * software distributed under the License is distributed on an
    public void testRegisterMultipleKeepAliveIntervals() {
        TcpChannel channel1 = new FakeTcpChannel();  
        keepAliveTask.run();
        assertEquals(2, threadPool.scheduledTasks.size());
        keepAliveTask1.run();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.io.stream.BytesStreamOutput;
        super.tearDown();  
public class TransportKeepAliveTests extends OpenSearchTestCase {
 *
    }
    }
            out.writeInt(-1);
        TcpChannel channel1 = new FakeTcpChannel();  
        Tuple<TimeValue, Runnable> taskTuple1 = threadPool.scheduledTasks.poll();  
 * this file be licensed under the Apache-2.0 license or a
            out.writeByte((byte) 'S');
        pingSender = mock(AsyncBiFunction.class);
        private final Deque<Tuple<TimeValue, Runnable>> scheduledTasks = new ArrayDeque<>();
    public void testOnlySendPingIfWeHaveNotWrittenAndReadSinceLastPing() {
        assertEquals(pingInterval, rescheduledTask.v1());
    @Override  
        verify(pingSender, times(1)).apply(same(channel1), eq(expectedPingMessage), any());
 *  
        Runnable task = threadPool.scheduledTasks.poll().v2();  
        assertEquals(0, threadPool.scheduledTasks.size());
        public ScheduledCancellable schedule(Runnable task, TimeValue delay, String executor) {  
    public void tearDown() throws Exception {
    }  
    public void testClosingChannelUnregistersItFromKeepAlive() {
            out.writeByte((byte) 'E');  
        TimeValue pingInterval1 = TimeValue.timeValueSeconds(randomLongBetween(1, 30));  
        ConnectionProfile connectionProfile2 = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval2).build();  
    private class CapturingThreadPool extends TestThreadPool {  
        Tuple<TimeValue, Runnable> taskTuple2 = threadPool.scheduledTasks.poll();
        Tuple<TimeValue, Runnable> rescheduledTask = threadPool.scheduledTasks.poll();  
        TcpChannel channel2 = new FakeTcpChannel();
        verify(pingSender, times(1)).apply(same(channel), eq(expectedPingMessage), any());
        keepAlive.registerNodeConnection(Arrays.asList(channel1, channel2), connectionProfile);
        verify(pingSender, times(0)).apply(same(channel), eq(expectedPingMessage), any());
        keepAlive.registerNodeConnection(Collections.singletonList(channel1), connectionProfile);
import java.util.Deque;
