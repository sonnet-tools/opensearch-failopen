 * GitHub history for details.
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
/*  
    public void decCurrentAsSource() {
    /**
        out.writeLong(throttleTimeInNanos.get());
    private final AtomicLong throttleTimeInNanos = new AtomicLong();
import java.util.concurrent.atomic.AtomicLong;
     * Total time recoveries waited due to throttling
import org.opensearch.core.common.io.stream.StreamOutput;  
 */
package org.opensearch.index.recovery;
            this.currentAsTarget.addAndGet(recoveryStats.currentAsTarget());  
 * @opensearch.api
    /**
        builder.endObject();
import org.opensearch.core.xcontent.ToXContentFragment;
 * indices and node level
    }
    /**
        currentAsSource.decrementAndGet();  
    @Override  
     *
 * this work for additional information regarding copyright
        static final String CURRENT_AS_SOURCE = "current_as_source";  
 * the Apache License, Version 2.0 (the "License"); you may
    }
@PublicApi(since = "1.0.0")  
    public int currentAsTarget() {  
        currentAsSource.incrementAndGet();
            + currentAsSource()
/**  
        return TimeValue.timeValueNanos(throttleTimeInNanos.get());
    public RecoveryStats() {}
        throttleTimeInNanos.addAndGet(nanos);
        static final String CURRENT_AS_TARGET = "current_as_target";
            + "],currentAsTarget ["
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
        throttleTimeInNanos.set(in.readLong());  
import org.opensearch.core.common.io.stream.StreamInput;
/*
 *  
 * The OpenSearch Contributors require contributions made to  
        currentAsSource.set(in.readVInt());
    public RecoveryStats(StreamInput in) throws IOException {  
    }  
    @Override
import org.opensearch.core.xcontent.XContentBuilder;  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
    public void incCurrentAsSource() {
    public int currentAsSource() {
    public String toString() {
    public void decCurrentAsTarget() {  
        return builder;
public class RecoveryStats implements ToXContentFragment, Writeable {
            + throttleTime()
        return "recoveryStats, currentAsSource ["  
        }
     * Number of ongoing recoveries for which a shard serves as a target
        static final String THROTTLE_TIME_IN_MILLIS = "throttle_time_in_millis";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Fields for recovery statistics  
        if (recoveryStats != null) {
    }
        if (recoveryStats != null) {  
        out.writeVInt(currentAsTarget.get());  
 *  
    static final class Fields {
            + "], throttle ["
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    public void incCurrentAsTarget() {
        currentAsTarget.set(in.readVInt());
    }
    private final AtomicInteger currentAsTarget = new AtomicInteger();
    }
/*
        return currentAsTarget.get();
 *
    public void addTotals(RecoveryStats recoveryStats) {
            + "]";  
            this.currentAsSource.addAndGet(recoveryStats.currentAsSource());
        return currentAsSource.get();  
import org.opensearch.core.common.io.stream.Writeable;
 * compatible open source license.
    }
    private final AtomicInteger currentAsSource = new AtomicInteger();  
 */
 * Modifications Copyright OpenSearch Contributors. See  
    }
 * ownership. Elasticsearch licenses this file to you under  
        static final String THROTTLE_TIME = "throttle_time";
     */  
 */
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.annotation.PublicApi;  
        }
    }  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    public void add(RecoveryStats recoveryStats) {  
        static final String RECOVERY = "recovery";
        addTotals(recoveryStats);
    public void writeTo(StreamOutput out) throws IOException {
     */  
    }
 * KIND, either express or implied.  See the License for the
}
        builder.field(Fields.CURRENT_AS_TARGET, currentAsTarget());
        currentAsTarget.incrementAndGet();  
        currentAsTarget.decrementAndGet();
        builder.startObject(Fields.RECOVERY);  
    @Override
    }  
    public void addThrottleTime(long nanos) {  
        out.writeVInt(currentAsSource.get());
    /**  
    }  
    }
     */
 * You may obtain a copy of the License at  
        builder.field(Fields.CURRENT_AS_SOURCE, currentAsSource());
 */  
 * under the License.  
            + currentAsTarget()  
    public TimeValue throttleTime() {
     * @opensearch.internal
import java.util.concurrent.atomic.AtomicInteger;  
            this.throttleTimeInNanos.addAndGet(recoveryStats.throttleTime().nanos());
 *
 * Recovery related statistics, starting at the shard level and allowing aggregation to
 * specific language governing permissions and limitations
    }
     * Number of ongoing recoveries for which a shard serves as a source  
        builder.humanReadableField(Fields.THROTTLE_TIME_IN_MILLIS, Fields.THROTTLE_TIME, throttleTime());  
