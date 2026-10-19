    public MeanMetric getWriteBytes() {
        bytesRead.add(bytesReceived);
        return bytesRead.sum();
 * Tracks transport statistics
 * compatible open source license.
 */
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    public void markBytesWritten(long bytesWritten) {
 *
 *  
 *
    }
 * under the License.  
/*  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
package org.opensearch.transport;
 * Modifications Copyright OpenSearch Contributors. See
    }
        messagesReceived.increment();
        return writeBytesMetric;  
@PublicApi(since = "1.0.0")
 */  
/*
    public long getMessagesReceived() {
 * Unless required by applicable law or agreed to in writing,
    public long getBytesWritten() {  
 * Licensed to Elasticsearch under one or more contributor  
/*  
    public long getMessagesSent() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return writeBytesMetric.sum();
import java.util.concurrent.atomic.LongAdder;
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.common.metrics.MeanMetric;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    }  
        return messagesReceived.sum();
}
 *     http://www.apache.org/licenses/LICENSE-2.0
public final class StatsTracker {  
 * SPDX-License-Identifier: Apache-2.0
    public long getBytesRead() {  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    }
 */  
    }
 * this work for additional information regarding copyright
    public void markMessageReceived() {
    private final LongAdder messagesReceived = new LongAdder();  
 */
 * KIND, either express or implied.  See the License for the
        return writeBytesMetric.count();
import org.opensearch.common.annotation.PublicApi;
    private final MeanMetric writeBytesMetric = new MeanMetric();
    }
 * @opensearch.api  
    public void markBytesRead(long bytesReceived) {  
    private final LongAdder bytesRead = new LongAdder();
        writeBytesMetric.inc(bytesWritten);  
/**  
 * license agreements. See the NOTICE file distributed with
