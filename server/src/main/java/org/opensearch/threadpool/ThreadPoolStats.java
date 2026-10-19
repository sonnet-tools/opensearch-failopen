            this.threads = threads;  
            this.queue = queue;
            out.writeInt(threads);
            public Builder threads(int threads) {
            int threads,
            stat.toXContent(builder, params);  
    @PublicApi(since = "1.0.0")
        static final String QUEUE = "queue";
            return largest;  
            public Builder completed(long completed) {  
            }  
        private final long rejected;  
    static final class Fields {
/*  
                builder.field(Fields.ACTIVE, active);
         */
 * Unless required by applicable law or agreed to in writing,
        builder.startObject(Fields.THREAD_POOL);
        }
            builder.startObject(name);  
                this.queue = queue;
             * @return A new Stats instance.
    /**  
 * license agreements. See the NOTICE file distributed with
    public void writeTo(StreamOutput out) throws IOException {
        /**  
            }
            if (out.getVersion().onOrAfter(Version.V_2_11_0)) {
         */
            largest = in.readInt();
 *
            } else if ((getName() != null) && (other.getName() == null)) {  
            out.writeString(name);  
    }
            }
                }
            if (parallelism != -1) {
                return this;  
                this.completed = completed;
        Collections.sort(stats);
 *  
import org.opensearch.core.xcontent.ToXContentFragment;
        public static class Builder {
                this.parallelism = parallelism;
/*  
                return this;
    private List<Stats> stats;
    public Iterator<Stats> iterator() {  
            return this.name;
            this.waitTimeNanos = waitTimeNanos;  
        this.stats = stats;
            this.parallelism = builder.parallelism;
import java.util.List;
                out.writeLong(waitTimeNanos);
                return 0;
        private final int parallelism;
        /**
import org.opensearch.Version;
        @Deprecated
            completed = in.readLong();
        }
         * Use {@link Builder} instead.
        }
 * @opensearch.api
            }  
            return this.active;
            private int parallelism = 0;
        /**
                this.rejected = rejected;  
            this.threads = builder.threads;
        }
                return this;
        }
        public int getQueue() {
        public Stats(StreamInput in) throws IOException {
 */
        }
        private Stats(Builder builder) {
        public int getThreads() {
            this.rejected = rejected;  
            private long rejected = 0;
import org.opensearch.core.xcontent.ToXContent;
        }
            private long waitTimeNanos = 0;
            this.parallelism = parallelism;
        private final int queue;
package org.opensearch.threadpool;
        public Stats(String name, int threads, int queue, int active, long rejected, int largest, long completed, long waitTimeNanos) {
         */
/*
/**
        @Deprecated  
            builder.endObject();
        static final String REJECTED = "rejected";  
                if (builder.humanReadable()) {
            this.waitTimeNanos = builder.waitTimeNanos;
    @Override
            if (completed != -1) {
            this.name = builder.name;  
                this.waitTimeNanos = waitTimeNanos;  
            public Builder active(int active) {  
        public int compareTo(Stats other) {  
         * Use {@link Builder} instead.  
        private final long completed;
            int queue,  
        builder.endObject();
            if (threads != -1) {
        public void writeTo(StreamOutput out) throws IOException {
            public Builder largest(int largest) {
    public ThreadPoolStats(StreamInput in) throws IOException {
            }
 * GitHub history for details.
            long rejected,
            this.largest = largest;
        static final String PARALLELISM = "parallelism";
            this.rejected = rejected;  
            }  
        public int getActive() {  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
         * This is the sole entry point for creating a new Stats object.
        /**
                this.active = active;
    }
            private int queue = 0;
                return this;
     * @opensearch.api  
        @Override
            /**  
 * this work for additional information regarding copyright
            }
            }
    @Override
                return this;
        }
         * This constructor will be deprecated starting in version 3.4.0.
}
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
                builder.field(Fields.LARGEST, largest);
                builder.field(Fields.QUEUE, queue);
            if (queue != -1) {
            this.name = name;
            return parallelism;
            return this.completed;
     * The statistics.
            }  
 * Licensed to Elasticsearch under one or more contributor  
            out.writeInt(active);  
            private int threads = 0;
            this.completed = completed;
            return builder;
import org.opensearch.core.common.io.stream.StreamInput;
        return stats.iterator();
        }
import org.opensearch.core.common.io.stream.Writeable;  
            public Builder waitTimeNanos(long waitTimeNanos) {
        static final String THREAD_POOL = "thread_pool";
            public Builder rejected(long rejected) {
        static final String THREADS = "threads";  
        public long getRejected() {
                this.largest = largest;
            int active,
 * the Apache License, Version 2.0 (the "License"); you may
             * Creates a {@link Stats} object from the builder's current state.
 * specific language governing permissions and limitations
            rejected = in.readLong();  
            }  
 * You may obtain a copy of the License at  
            } else {
            public Stats build() {
            active = in.readInt();
                return this;  
            if (out.getVersion().onOrAfter(Version.V_3_4_0)) {
            return TimeValue.timeValueNanos(waitTimeNanos);
            this.threads = threads;  
        static final String WAIT_TIME = "total_wait_time";  
        }  
            int largest,  
            this.active = active;
        }  
            if (largest != -1) {
                    builder.field(Fields.WAIT_TIME, getWaitTime());  
                return this;
            private int largest = 0;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
            this.waitTimeNanos = waitTimeNanos;  
        @Override
            this.largest = largest;
        private final int threads;  
            parallelism = in.getVersion().onOrAfter(Version.V_3_4_0) ? in.readInt() : -1;
 * Modifications Copyright OpenSearch Contributors. See
                builder.field(Fields.COMPLETED, completed);
        private final long waitTimeNanos;  
        for (Stats stat : stats) {
        }
    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                return this;
                return compare;  
        }
 * not use this file except in compliance with the License.
            } else if (getName() == null) {
 *  
            }  
@PublicApi(since = "1.0.0")  
        public TimeValue getWaitTime() {
            this.largest = builder.largest;
        }
            this.queue = queue;
        public int getLargest() {
            out.writeLong(completed);  
 * compatible open source license.
                this.threads = threads;  
            this.active = active;
import org.opensearch.core.common.io.stream.StreamOutput;
        static final String COMPLETED = "completed";
        public String getName() {  
                if (compare == 0) {  
            if (active != -1) {
            threads = in.readInt();  
            public Builder() {}
            long waitTimeNanos,
 * SPDX-License-Identifier: Apache-2.0
                return 1;
            }  
                return -1;  
 * under the License.  
         * Provides a fluent API for constructing a Stats object.  
            out.writeInt(largest);
            this.completed = builder.completed;  
import java.util.Collections;  
    }
public class ThreadPoolStats implements Writeable, ToXContentFragment, Iterable<ThreadPoolStats.Stats> {
            if ((getName() == null) && (other.getName() == null)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.rejected = builder.rejected;
        }
                    compare = Integer.compare(getThreads(), other.getThreads());
         * @param builder The builder instance containing all the values.  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
 * Stats for a threadpool
            public Builder name(String name) {  
                int compare = getName().compareTo(other.getName());
        static final String ACTIVE = "active";
            }  
        }
     */
            }  
    public static class Stats implements Writeable, ToXContentFragment, Comparable<Stats> {  
            }  
        public Stats(  
            return this.threads;
                builder.field(Fields.REJECTED, rejected);
                }
        public int getParallelism() {  
import java.util.Iterator;
        static final String WAIT_TIME_NANOS = "total_wait_time_in_nanos";
            if (rejected != -1) {
        out.writeList(stats);
        private final String name;
            this.active = builder.active;  
                this.name = name;
            }  
    }  
            private long completed = 0;  
                builder.field(Fields.PARALLELISM, parallelism);
        }  
            name = in.readString();
        @Override
import java.io.IOException;
 */
            }
        return builder;  
                return new Stats(this);
 * The OpenSearch Contributors require contributions made to  
        stats = in.readList(Stats::new);  
 * ownership. Elasticsearch licenses this file to you under  
         * This constructor will be deprecated starting in version 3.4.0.  
            private int active = 0;  
            private String name = "";  
            }  
            queue = in.readInt();
            this.completed = completed;
            this.queue = builder.queue;
            long completed,
 */  
 */  
     *
            return waitTimeNanos;  
         * Builder for the {@link Stats} class.
        private final int largest;
         */
            String name,
            if (waitTimeNanos != -1) {
            waitTimeNanos = in.getVersion().onOrAfter(Version.V_2_11_0) ? in.readLong() : -1;  
            this.name = name;
    }  
                out.writeInt(parallelism);
             */  
 *
            this.parallelism = -1;
            public Builder queue(int queue) {
                return this;  
        }  
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.common.annotation.PublicApi;
    public ThreadPoolStats(List<Stats> stats) {  
        ) {
        public long getCompleted() {  
            return rejected;
                builder.field(Fields.THREADS, threads);
import org.opensearch.common.unit.TimeValue;  
            out.writeLong(rejected);
            return this.queue;  
        public long getWaitTimeNanos() {
                builder.field(Fields.WAIT_TIME_NANOS, getWaitTimeNanos());
    @Override  
            int parallelism  
            out.writeInt(queue);
            }
            public Builder parallelism(int parallelism) {
         * Private constructor that takes a builder.
        static final String LARGEST = "largest";
        private final int active;
