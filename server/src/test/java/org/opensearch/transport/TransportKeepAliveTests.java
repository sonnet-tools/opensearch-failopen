        TimeValue pingInterval1 = TimeValue.timeValueSeconds(randomLongBetween(1, 30));
        TimeValue pingInterval1 = TimeValue.timeValueSeconds(randomLongBetween(1, 30));
        TcpChannel channel = new FakeTcpChannel(false);
    }
    public void testClosingChannelUnregistersItFromKeepAlive() {
    private BytesReference expectedPingMessage;
        keepAlive.receiveKeepAlive(channel);
        Tuple<TimeValue, Runnable> taskTuple1 = threadPool.scheduledTasks.poll();
 * SPDX-License-Identifier: Apache-2.0
            scheduledTasks.add(new Tuple<>(delay, task));
        threadPool.shutdown();
        }
public class TransportKeepAliveTests extends OpenSearchTestCase {
import org.opensearch.core.common.bytes.BytesReference;
            return null;
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval1).build();
 *
 * The OpenSearch Contributors require contributions made to
        keepAlive.receiveKeepAlive(channel);
        taskTuple = threadPool.scheduledTasks.poll();
 * the Apache License, Version 2.0 (the "License"); you may
        verify(pingSender, times(1)).apply(same(channel), eq(expectedPingMessage), any());
import org.opensearch.common.settings.Settings;
        taskTuple.v2().run();
        ConnectionProfile connectionProfile2 = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval2).build();
        taskTuple.v2().run();
    public void tearDown() throws Exception {
import org.opensearch.common.collect.Tuple;
        Runnable keepAliveTask = taskTuple.v2();
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.common.unit.TimeValue;
    private final ConnectionProfile defaultProfile = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);
 * Licensed to Elasticsearch under one or more contributor
import java.util.Collections;
        }
        private CapturingThreadPool() {
        keepAliveTask2.run();
    }
        assertEquals(0, threadPool.scheduledTasks.size());
/*
            out.writeByte((byte) 'E');
        Tuple<TimeValue, Runnable> taskTuple2 = threadPool.scheduledTasks.poll();
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
    }
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
            super(getTestName());
    }
        verify(pingSender, times(2)).apply(same(channel2), eq(expectedPingMessage), any());
    private TransportKeepAlive keepAlive;
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
        public ScheduledCancellable schedule(Runnable task, TimeValue delay, String executor) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        keepAliveTask1.run();
        task.run();
import static org.mockito.Mockito.any;
        keepAliveTask.run();
        TcpChannel channel2 = new FakeTcpChannel();
    }
        assertEquals(pingInterval, taskTuple.v1());
    public void testRegisterMultipleKeepAliveIntervals() {
        private final Deque<Tuple<TimeValue, Runnable>> scheduledTasks = new ArrayDeque<>();
 */
        assertEquals(2, threadPool.scheduledTasks.size());
        Tuple<TimeValue, Runnable> taskTuple = threadPool.scheduledTasks.poll();
        TcpChannel channel1 = new FakeTcpChannel();
        TimeValue pingInterval = TimeValue.timeValueSeconds(15);
 * not use this file except in compliance with the License.
        TcpChannel channel1 = new FakeTcpChannel();
import org.opensearch.common.io.stream.BytesStreamOutput;
    @Override
    private class CapturingThreadPool extends TestThreadPool {
        assertEquals(1, threadPool.scheduledTasks.size());
        @Override
        verify(pingSender, times(0)).apply(same(channel), eq(expectedPingMessage), any());
    @Override
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
 * compatible open source license.
        assertEquals(2, threadPool.scheduledTasks.size());
        assertEquals(1, threadPool.scheduledTasks.size());
        ConnectionProfile connectionProfile1 = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval1).build();
 * under the License.
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
            expectedPingMessage = out.bytes();
    public void testRegisterNodeConnectionSchedulesKeepAlive() {
import java.util.Arrays;
/*
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
        Runnable task = threadPool.scheduledTasks.poll().v2();
        super.tearDown();
        assertEquals(0, threadPool.scheduledTasks.size());
 */
        TcpChannel channel1 = new FakeTcpChannel();
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
 *
import static org.mockito.Mockito.mock;
import java.util.ArrayDeque;
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
        verify(pingSender, times(1)).apply(same(channel1), eq(expectedPingMessage), any());
        assertEquals(0, threadPool.scheduledTasks.size());
        keepAlive = new TransportKeepAlive(threadPool, pingSender);
    private CapturingThreadPool threadPool;
 * specific language governing permissions and limitations
package org.opensearch.transport;
 * software distributed under the License is distributed on an
        verify(pingSender, times(0)).apply(same(channel1), eq(expectedPingMessage), any());
 * this file be licensed under the Apache-2.0 license or a
}
    @SuppressWarnings("unchecked")
import static org.mockito.Mockito.eq;
        channel2.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
        Runnable keepAliveTask1 = taskTuple1.v2();
        // Test that the task has rescheduled itself
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        TcpChannel channel1 = new FakeTcpChannel();
        super.setUp();
        threadPool = new CapturingThreadPool();
import java.util.Deque;
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval).build();
        assertEquals(pingInterval2, taskTuple2.v1());
 *
        TcpChannel channel2 = new FakeTcpChannel();
 */
    public void setUp() throws Exception {
import org.opensearch.threadpool.TestThreadPool;
        TimeValue pingInterval2 = TimeValue.timeValueSeconds(randomLongBetween(31, 60));
 * GitHub history for details.
import org.opensearch.common.AsyncBiFunction;
    public void testNoKeepAliveResponseIfClient() {
        TcpChannel channel2 = new FakeTcpChannel();
        } catch (IOException e) {
        channel1.close();
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
        TcpChannel.ChannelStats stats = channel1.getChannelStats();
        Runnable keepAliveTask2 = taskTuple1.v2();
        channel1.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
        TimeValue pingInterval = TimeValue.timeValueSeconds(randomLongBetween(1, 60));
        assertEquals(pingInterval1, taskTuple1.v1());
        keepAlive.registerNodeConnection(Collections.singletonList(channel2), connectionProfile);
    }
import static org.mockito.Mockito.verify;
        assertEquals(1, threadPool.scheduledTasks.size());
        keepAlive.registerNodeConnection(Collections.singletonList(channel2), connectionProfile2);
    public void testKeepAliveResponseIfServer() {
/*
            throw new AssertionError(e.getMessage(), e); // won't happen
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        stats.markAccessed(threadPool.relativeTimeInMillis() + (pingInterval.millis() / 2));
        verify(pingSender, times(1)).apply(same(channel2), eq(expectedPingMessage), any());
import static org.mockito.Mockito.times;
        keepAlive.registerNodeConnection(Arrays.asList(channel1, channel2), connectionProfile);
    private AsyncBiFunction<TcpChannel, BytesReference, Void> pingSender;
        TcpChannel channel = new FakeTcpChannel(true);
    public void testOnlySendPingIfWeHaveNotWrittenAndReadSinceLastPing() {
        keepAlive.registerNodeConnection(Collections.singletonList(channel1), connectionProfile);
        keepAlive.registerNodeConnection(Arrays.asList(channel1, channel2), connectionProfile);
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
        Tuple<TimeValue, Runnable> taskTuple = threadPool.scheduledTasks.poll();
        TcpChannel channel2 = new FakeTcpChannel();
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(pingInterval).build();
        Tuple<TimeValue, Runnable> rescheduledTask = threadPool.scheduledTasks.poll();
        pingSender = mock(AsyncBiFunction.class);
        keepAlive.registerNodeConnection(Collections.singletonList(channel1), connectionProfile1);
        assertEquals(pingInterval, rescheduledTask.v1());
 * KIND, either express or implied.  See the License for the
        assertEquals(0, threadPool.scheduledTasks.size());
import static org.mockito.Mockito.same;
        verify(pingSender, times(1)).apply(same(channel1), eq(expectedPingMessage), any());
    }
 * You may obtain a copy of the License at
            out.writeInt(-1);
import org.opensearch.test.OpenSearchTestCase;
        verify(pingSender, times(1)).apply(same(channel2), eq(expectedPingMessage), any());
            out.writeByte((byte) 'S');
 * Modifications Copyright OpenSearch Contributors. See
        }
