 *
        builder.endObject();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;
                    builder.endObject();  
                        builder.field("retaining_seq_no", retentionLease.retainingSequenceNumber());
     */
    @Override
     * Writes a retention lease stats object to a stream in a manner suitable for later reconstruction via
import org.opensearch.core.common.io.stream.StreamInput;
     * Constructs a new retention lease stats object from the specified retention lease collection.
 *  
 * SPDX-License-Identifier: Apache-2.0
}
                        builder.field("source", retentionLease.source());
        final RetentionLeaseStats that = (RetentionLeaseStats) o;
 * Represents retention lease stats.
 * The OpenSearch Contributors require contributions made to  
 */  
    }
                for (final RetentionLease retentionLease : retentionLeases.leases()) {
                        builder.field("id", retentionLease.id());
 *
    public void writeTo(final StreamOutput out) throws IOException {
    public int hashCode() {  
        retentionLeases = new RetentionLeases(in);  
        if (o == null || getClass() != o.getClass()) return false;  
        return Objects.hash(retentionLeases);
    @Override
            builder.endArray();  
 */
     * @throws IOException if an I/O exception occurs writing to the stream
/*  
                        builder.field("timestamp", retentionLease.timestamp());  
 * KIND, either express or implied.  See the License for the
     */
    /**
import org.opensearch.core.xcontent.XContentBuilder;
 */
 */  
 * software distributed under the License is distributed on an
        return Objects.equals(retentionLeases, that.retentionLeases);
     * @throws IOException if an I/O exception occurs writing to the builder  
import java.util.Objects;
 * the Apache License, Version 2.0 (the "License"); you may
    public RetentionLeases retentionLeases() {  
                    }
    public RetentionLeaseStats(final RetentionLeases retentionLeases) {  
        retentionLeases.writeTo(out);  
    @Override  
     * @param out the stream to write the retention lease stats to
     * @throws IOException if an I/O exception occurs reading from the stream  
import org.opensearch.core.common.io.stream.StreamOutput;  
     * Converts the retention lease stats to {@link XContent} using the specified builder and pararms.
     *  
 * @opensearch.api  
                    {  
     * @param builder the builder  
    }
     * Constructs a new retention lease stats object from a stream. The retention lease stats should have been written via
     * @return the builder that this retention lease collection was converted to {@link XContent} into
    @Override
    }
    public RetentionLeaseStats(final StreamInput in) throws IOException {
     * @param params  the params
     */  
     * @param retentionLeases the retention lease collection
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {  
 * under the License.  
public final class RetentionLeaseStats implements ToXContentFragment, Writeable {  
        return retentionLeases;
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
/**  
            builder.startArray("leases");
     */
 * this file be licensed under the Apache-2.0 license or a
     * The underlying retention lease collection backing this stats object.
    private final RetentionLeases retentionLeases;
        this.retentionLeases = Objects.requireNonNull(retentionLeases);
 * not use this file except in compliance with the License.
/*  
    /**
        builder.startObject("retention_leases");
    /**
        }
                    builder.startObject();
/*
    /**  
 * this work for additional information regarding copyright
    /**  
@PublicApi(since = "1.0.0")
    }  
     * @return the retention lease collection
        if (this == o) return true;
                }
    public boolean equals(Object o) {
 * Licensed to Elasticsearch under one or more contributor  
     *
     * {@link #RetentionLeaseStats(StreamInput)} (StreamInput)}.
 * You may obtain a copy of the License at  
import java.io.IOException;  
 *
        return builder;  
     * {@link #writeTo(StreamOutput)}.  
     *  
    }
import org.opensearch.core.common.io.stream.Writeable;
package org.opensearch.index.seqno;
    }
     * @param in the stream to construct the retention lease stats from
import org.opensearch.core.xcontent.XContent;  
    }
 * license agreements. See the NOTICE file distributed with
        {
 * ownership. Elasticsearch licenses this file to you under  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
     *  
            {  
            builder.field("primary_term", retentionLeases.primaryTerm());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.field("version", retentionLeases.version());
     *
            }
 * compatible open source license.
 * GitHub history for details.
