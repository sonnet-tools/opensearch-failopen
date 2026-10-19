 */  
 * @opensearch.api
            + maxSeqNo
import java.io.IOException;
    public boolean equals(Object o) {
 * under the License.  
/*
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
    public long getGlobalCheckpoint() {  
    /** the maximum sequence number for which all previous operations (including) have been persisted */
import org.opensearch.common.annotation.PublicApi;
    }
    public SeqNoStats(long maxSeqNo, long localCheckpoint, long globalCheckpoint) {
    /** the maximum sequence number seen so far */
    public long getLocalCheckpoint() {
    private final long localCheckpoint;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;  
        this(in.readZLong(), in.readZLong(), in.readZLong());
 * the Apache License, Version 2.0 (the "License"); you may
        return "SeqNoStats{"  
    }
import org.opensearch.core.common.io.stream.StreamInput;
        builder.field(MAX_SEQ_NO, maxSeqNo);
    }
        builder.field(LOCAL_CHECKPOINT, localCheckpoint);  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        out.writeZLong(maxSeqNo);  
 */
 * Modifications Copyright OpenSearch Contributors. See
        assert localCheckpoint <= maxSeqNo : "local checkpoint [" + localCheckpoint + "] is above maximum seq no [" + maxSeqNo + "]";
/**
    public long getMaxSeqNo() {  
 * ownership. Elasticsearch licenses this file to you under  
        out.writeZLong(localCheckpoint);
    private static final String LOCAL_CHECKPOINT = "local_checkpoint";  
        return maxSeqNo;
import org.opensearch.core.common.io.stream.StreamOutput;  
 */  
 * Unless required by applicable law or agreed to in writing,
            + "maxSeqNo="
 * You may obtain a copy of the License at  
    @Override
    @Override  
        builder.field(GLOBAL_CHECKPOINT, globalCheckpoint);
        return maxSeqNo == that.maxSeqNo && localCheckpoint == that.localCheckpoint && globalCheckpoint == that.globalCheckpoint;
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.endObject();
        if (this == o) return true;
    public String toString() {
 */  
    private final long globalCheckpoint;
        this.maxSeqNo = maxSeqNo;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public SeqNoStats(StreamInput in) throws IOException {
    }
        if (o == null || getClass() != o.getClass()) return false;  
 * Sequence number statistics  
 *  
        // note that the global checkpoint can be higher from both maxSeqNo and localCheckpoint  
        final SeqNoStats that = (SeqNoStats) o;
    }  
    @Override
            + ", localCheckpoint="  
 * this file be licensed under the Apache-2.0 license or a
 *
import java.util.Objects;  
 * specific language governing permissions and limitations
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        return Objects.hash(maxSeqNo, localCheckpoint, globalCheckpoint);
 *
@PublicApi(since = "1.0.0")
        return builder;  
            + ", globalCheckpoint="
        builder.startObject(SEQ_NO);
        out.writeZLong(globalCheckpoint);
            + localCheckpoint
    private static final String MAX_SEQ_NO = "max_seq_no";
 * KIND, either express or implied.  See the License for the
    private static final String SEQ_NO = "seq_no";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * not use this file except in compliance with the License.
        this.localCheckpoint = localCheckpoint;  
    @Override
        // as we use this stats object to describe lucene commits as well as live statistic.
    private final long maxSeqNo;  
    public int hashCode() {  
    }
 * GitHub history for details.
package org.opensearch.index.seqno;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * compatible open source license.
public class SeqNoStats implements ToXContentFragment, Writeable {
    }  
    }
        return localCheckpoint;  
        this.globalCheckpoint = globalCheckpoint;
 *
}  
            + globalCheckpoint  
    }  
 * The OpenSearch Contributors require contributions made to  
    }
/*  
        return globalCheckpoint;
import org.opensearch.core.common.io.stream.Writeable;
    private static final String GLOBAL_CHECKPOINT = "global_checkpoint";
            + '}';
