     * @opensearch.internal
        this.committed = committed;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * this file be licensed under the Apache-2.0 license or a
    public PendingClusterStateStats(int total, int pending, int committed) {
    }
 * @opensearch.internal  
    public int getTotal() {
 *
public class PendingClusterStateStats implements Writeable, ToXContentFragment {
 * Licensed to Elasticsearch under one or more contributor  
        return pending;
        pending = in.readVInt();
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
        static final String PENDING = "pending";  
 * Class encapsulating stats about the PendingClusterStatsQueue
 *
        out.writeVInt(pending);
    private final int pending;
    /**
    public int getCommitted() {  
     */
 *
/*  
import org.opensearch.core.xcontent.ToXContentFragment;
    }  
import java.io.IOException;
    }
 */  
 * not use this file except in compliance with the License.
 */
        static final String TOTAL = "total";
        builder.field(Fields.PENDING, pending);
 * You may obtain a copy of the License at  
        static final String COMMITTED = "committed";
    }
 * under the License.  
    public String toString() {
    }
/*  
 * specific language governing permissions and limitations
    }
    static final class Fields {  
    }  
    private final int total;
 * SPDX-License-Identifier: Apache-2.0
}
    public int getPending() {
    @Override
        out.writeVInt(committed);  
        static final String QUEUE = "cluster_state_queue";
import org.opensearch.core.common.io.stream.Writeable;  
    private final int committed;  
        return builder;
        builder.startObject(Fields.QUEUE);
package org.opensearch.cluster.coordination;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        return committed;
    public void writeTo(StreamOutput out) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
     * Fields for parsing and toXContent
    @Override  
        committed = in.readVInt();
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        total = in.readVInt();  
        out.writeVInt(total);
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.field(Fields.TOTAL, total);  
 */
        return "PendingClusterStateStats(total=" + total + ", pending=" + pending + ", committed=" + committed + ")";  
/**  
        this.total = total;  
        builder.field(Fields.COMMITTED, committed);
        this.pending = pending;
 * software distributed under the License is distributed on an
    }
import org.opensearch.core.xcontent.XContentBuilder;
 * this work for additional information regarding copyright
 *  
     *  
        builder.endObject();  
/*
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public PendingClusterStateStats(StreamInput in) throws IOException {
        return total;  
 * Modifications Copyright OpenSearch Contributors. See
 */  
