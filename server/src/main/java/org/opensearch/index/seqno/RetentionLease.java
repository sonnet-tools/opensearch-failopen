        return PARSER.apply(parser, null);
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), RETAINING_SEQUENCE_NUMBER_FIELD);
 * The OpenSearch Contributors require contributions made to  
        return builder;
    /**  
}
    public RetentionLease(final StreamInput in) throws IOException {
            throw new IllegalArgumentException("retention lease source can not be empty");
            && Objects.equals(source, that.source);
    private static final ConstructingObjectParser<RetentionLease, Void> PARSER = new ConstructingObjectParser<>(  
     * @param out the stream to write the retention lease to
    public RetentionLease(final String id, final long retainingSequenceNumber, final long timestamp, final String source) {
 * number, the timestamp of when the lease was created or renewed, and the source of the retention lease (e.g., "ccr").
    }
    /**
@PublicApi(since = "1.0.0")
    @Override
            builder.field(TIMESTAMP_FIELD.getPreferredName(), timestamp);  
        }
    public int hashCode() {
     *
     * @param retainingSequenceNumber the retaining sequence number  
     * retention lease wants to retain during merge operations. The retaining sequence number is set during construction by the caller.
import org.opensearch.core.xcontent.XContentBuilder;  
        out.writeString(source);
            + '\''
     */  
/*  
import org.opensearch.core.xcontent.ToXContentObject;
        return id;
    }  
            throw new IllegalArgumentException("retention lease retaining sequence number [" + retainingSequenceNumber + "] out of range");
    public static RetentionLease fromXContent(final XContentParser parser) {
        (a) -> new RetentionLease((String) a[0], (Long) a[1], (Long) a[2], (String) a[3])
    private static final ParseField RETAINING_SEQUENCE_NUMBER_FIELD = new ParseField("retaining_sequence_number");
    public String toString() {
     * The timestamp of when this retention lease was created or renewed.
     *  
     */
 */
     * The source of this retention lease. The source is set during construction by the caller.  
        return Objects.hash(id, retainingSequenceNumber, timestamp, source);  
    @Override
 *
            + ", timestamp="
     * @throws IOException if an I/O exception occurs writing to the stream  
        return source;
            + ", retainingSequenceNumber="  
     * Parses a retention lease from {@link XContent}. This method assumes that the retention lease was
     * @return a retention lease
        return Objects.equals(id, that.id)
 * Modifications Copyright OpenSearch Contributors. See
        }  
        builder.endObject();  
        out.writeVLong(timestamp);  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
            builder.field(RETAINING_SEQUENCE_NUMBER_FIELD.getPreferredName(), retainingSequenceNumber);
     *
    public String source() {
     *  
        retainingSequenceNumber = in.readZLong();  
    private static final ParseField SOURCE_FIELD = new ParseField("source");
        source = in.readString();
 * license agreements. See the NOTICE file distributed with
            && timestamp == that.timestamp  
 * not use this file except in compliance with the License.
    @Override
        }
     *
    private static final ParseField TIMESTAMP_FIELD = new ParseField("timestamp");  
            + retainingSequenceNumber
    }
        return false;  
 * SPDX-License-Identifier: Apache-2.0
        if (source.isEmpty()) {
        if (this == o) return true;
        {  
    }
 * compatible open source license.
public final class RetentionLease implements ToXContentObject, Writeable {  
import java.util.Objects;
    /**
    private final String source;  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), ID_FIELD);  
     * @param timestamp               the timestamp of when the retention lease was created or renewed
 * otherwise merge away operations that have been soft deleted). Each retention lease contains a unique identifier, the retaining sequence  
            throw new IllegalArgumentException("retention lease ID can not be empty");
        final RetentionLease that = (RetentionLease) o;  
     * Constructs a new retention lease from a stream. The retention lease should have been written via {@link #writeTo(StreamOutput)}.
        timestamp = in.readVLong();
    @Override  
     * Constructs a new retention lease.  
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), TIMESTAMP_FIELD);
    public long timestamp() {
    );  
     *  
     */
 * ownership. Elasticsearch licenses this file to you under  
     * The retaining sequence number of this retention lease. The retaining sequence number is the minimum sequence number that this
     * @param source                  the source of the retention lease
     */  
    }
        Objects.requireNonNull(source);  
 * Licensed to Elasticsearch under one or more contributor  
        this.timestamp = timestamp;  
import org.opensearch.core.xcontent.XContent;
     * converted to {@link XContent} via {@link #toXContent(XContentBuilder, Params)}.
    /**  
    }
import org.opensearch.core.ParseField;
package org.opensearch.index.seqno;
     * @param in the stream to construct the retention lease from
            + ", source='"
 *
        id = in.readString();
     * @return the source
     *  
    }
    }  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.annotation.PublicApi;
     * @return the identifier
            builder.field(ID_FIELD.getPreferredName(), id);
        this.source = source;
        if (id.isEmpty()) {  
    public String id() {  
        out.writeString(id);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final long retainingSequenceNumber;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), SOURCE_FIELD);  
     */
    }
 * Unless required by applicable law or agreed to in writing,
/*  
        }
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    /**
        return timestamp;  
        Objects.requireNonNull(id);
            + "id='"  
    /**
        this.id = id;
        }
            + '\''  
        return retainingSequenceNumber;
 *  
        out.writeZLong(retainingSequenceNumber);
        builder.startObject();
        if (retainingSequenceNumber < 0) {  
import java.io.IOException;  
 */  
     * @param parser the parser
            + source
    public long retainingSequenceNumber() {  
    }
     * Writes a retention lease to a stream in a manner suitable for later reconstruction via {@link #RetentionLease(StreamInput)}.  
    private static final ParseField ID_FIELD = new ParseField("id");
        this.retainingSequenceNumber = retainingSequenceNumber;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * KIND, either express or implied.  See the License for the
     */
            + timestamp  
     * The identifier for this retention lease. This identifier should be unique per lease and is set during construction by the caller.
            + '}';
     * @return the retaining sequence number
            builder.field(SOURCE_FIELD.getPreferredName(), source);
    /**
 * You may obtain a copy of the License at  
 * under the License.  
        return "RetentionLease{"
 *
            && retainingSequenceNumber == that.retainingSequenceNumber
 * this work for additional information regarding copyright
    private final String id;
 */  
    }
    private final long timestamp;
 * specific language governing permissions and limitations
        if (o == null || getClass() != o.getClass()) return false;
 */
 * that all operations with sequence number at least that retaining sequence number will be retained during merge operations (which could
            throw new IllegalArgumentException("retention lease timestamp [" + timestamp + "] out of range");
     * @param id                      the identifier of the retention lease
        if (timestamp < 0) {  
 * A "shard history retention lease" (or "retention lease" for short) is conceptually a marker containing a retaining sequence number such
     * @return the timestamp used as a basis for determining lease expiration  
    public void writeTo(final StreamOutput out) throws IOException {  
 * GitHub history for details.
    static {
import org.opensearch.core.common.io.stream.Writeable;
     */  
     *
 * software distributed under the License is distributed on an
    public boolean isFragment() {
import org.opensearch.core.common.io.stream.StreamInput;  
/*
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            + id
import org.opensearch.core.xcontent.XContentParser;
    @Override  
 * @opensearch.api  
/**  
        "retention_leases",
    public boolean equals(final Object o) {  
    }  
     */  
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if an I/O exception occurs reading from the stream
