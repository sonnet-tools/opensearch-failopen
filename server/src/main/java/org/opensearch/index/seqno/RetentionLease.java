            + ", retainingSequenceNumber="
        out.writeString(id);
    public long retainingSequenceNumber() {
    @Override
        if (o == null || getClass() != o.getClass()) return false;
    }
 * license agreements. See the NOTICE file distributed with
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    private final String source;
     * The retaining sequence number of this retention lease. The retaining sequence number is the minimum sequence number that this
/**
    private final long timestamp;
import org.opensearch.core.common.io.stream.Writeable;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), ID_FIELD);
    }
import org.opensearch.core.xcontent.XContent;
        "retention_leases",
            builder.field(SOURCE_FIELD.getPreferredName(), source);
        }
 * compatible open source license.
import org.opensearch.core.xcontent.ConstructingObjectParser;
     * @return a retention lease
    public RetentionLease(final String id, final long retainingSequenceNumber, final long timestamp, final String source) {
    }
    /**
            + retainingSequenceNumber
        return PARSER.apply(parser, null);
     * @param parser the parser
        builder.endObject();
        }
    }
        retainingSequenceNumber = in.readZLong();
 */
 * Unless required by applicable law or agreed to in writing,
        source = in.readString();
 * this file be licensed under the Apache-2.0 license or a
    /**
        return retainingSequenceNumber;
    public String source() {
 * GitHub history for details.
        if (source.isEmpty()) {
    }
        }
     * @return the source
/*
     * @param retainingSequenceNumber the retaining sequence number
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), TIMESTAMP_FIELD);
    private final long retainingSequenceNumber;
    /**
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            throw new IllegalArgumentException("retention lease ID can not be empty");
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeVLong(timestamp);
     */
    }
     * retention lease wants to retain during merge operations. The retaining sequence number is set during construction by the caller.
 * otherwise merge away operations that have been soft deleted). Each retention lease contains a unique identifier, the retaining sequence
 */
    public boolean equals(final Object o) {
import java.io.IOException;
            + timestamp
            throw new IllegalArgumentException("retention lease timestamp [" + timestamp + "] out of range");
        Objects.requireNonNull(id);
     * @throws IOException if an I/O exception occurs writing to the stream
            + ", source='"
     * @throws IOException if an I/O exception occurs reading from the stream
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    public long timestamp() {
        }
import java.util.Objects;
        }
            + ", timestamp="
            throw new IllegalArgumentException("retention lease retaining sequence number [" + retainingSequenceNumber + "] out of range");
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeString(source);
     *
     * @param source                  the source of the retention lease
@PublicApi(since = "1.0.0")
            + '\''
 * not use this file except in compliance with the License.
     */
 * number, the timestamp of when the lease was created or renewed, and the source of the retention lease (e.g., "ccr").
     * @param id                      the identifier of the retention lease
        if (retainingSequenceNumber < 0) {
    static {
     */
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
     * @return the identifier
        this.timestamp = timestamp;
        {
 * You may obtain a copy of the License at
    private static final ParseField TIMESTAMP_FIELD = new ParseField("timestamp");
    }
    }
        out.writeZLong(retainingSequenceNumber);
    public String id() {
     * @return the retaining sequence number
     *
            + source
 * Modifications Copyright OpenSearch Contributors. See
}
        final RetentionLease that = (RetentionLease) o;
 * @opensearch.api
    @Override
    }
    /**
 * A "shard history retention lease" (or "retention lease" for short) is conceptually a marker containing a retaining sequence number such
        (a) -> new RetentionLease((String) a[0], (Long) a[1], (Long) a[2], (String) a[3])
     * The timestamp of when this retention lease was created or renewed.
     * @param timestamp               the timestamp of when the retention lease was created or renewed
import org.opensearch.common.annotation.PublicApi;
     */
    public String toString() {
        Objects.requireNonNull(source);
    @Override
     * Parses a retention lease from {@link XContent}. This method assumes that the retention lease was
 *
    private static final ConstructingObjectParser<RetentionLease, Void> PARSER = new ConstructingObjectParser<>(
            + "id='"
 *
public final class RetentionLease implements ToXContentObject, Writeable {
    @Override
    public void writeTo(final StreamOutput out) throws IOException {
 *
        return timestamp;
            builder.field(RETAINING_SEQUENCE_NUMBER_FIELD.getPreferredName(), retainingSequenceNumber);
     * Constructs a new retention lease from a stream. The retention lease should have been written via {@link #writeTo(StreamOutput)}.
     * The identifier for this retention lease. This identifier should be unique per lease and is set during construction by the caller.
/*
        return source;
import org.opensearch.core.ParseField;
     *
    /**
            && retainingSequenceNumber == that.retainingSequenceNumber
        return id;
    private static final ParseField SOURCE_FIELD = new ParseField("source");
     */
 */
    public static RetentionLease fromXContent(final XContentParser parser) {
     *
     *
    public boolean isFragment() {
 *
     * converted to {@link XContent} via {@link #toXContent(XContentBuilder, Params)}.
            builder.field(ID_FIELD.getPreferredName(), id);
     */
     *
    @Override
        return Objects.equals(id, that.id)
            + '\''
    }
        builder.startObject();
    private static final ParseField RETAINING_SEQUENCE_NUMBER_FIELD = new ParseField("retaining_sequence_number");
        return "RetentionLease{"
    }
        this.source = source;
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), RETAINING_SEQUENCE_NUMBER_FIELD);
        PARSER.declareString(ConstructingObjectParser.constructorArg(), SOURCE_FIELD);
import org.opensearch.core.xcontent.XContentParser;
    public int hashCode() {
    }
        if (timestamp < 0) {
    /**
    private static final ParseField ID_FIELD = new ParseField("id");
            + id
 * Licensed to Elasticsearch under one or more contributor
        timestamp = in.readVLong();
        if (id.isEmpty()) {
 * ownership. Elasticsearch licenses this file to you under
    /**
    );
    }
    public RetentionLease(final StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.StreamInput;
    }
     * Constructs a new retention lease.
            throw new IllegalArgumentException("retention lease source can not be empty");
 * under the License.
     * @return the timestamp used as a basis for determining lease expiration
     * Writes a retention lease to a stream in a manner suitable for later reconstruction via {@link #RetentionLease(StreamInput)}.
    private final String id;
     */
     *
            && Objects.equals(source, that.source);
package org.opensearch.index.seqno;
            builder.field(TIMESTAMP_FIELD.getPreferredName(), timestamp);
        this.retainingSequenceNumber = retainingSequenceNumber;
     * The source of this retention lease. The source is set during construction by the caller.
import org.opensearch.core.xcontent.ToXContentObject;
/*
        return builder;
    /**
     */
 */
 * software distributed under the License is distributed on an
        return false;
     * @param in the stream to construct the retention lease from
     * @param out the stream to write the retention lease to
        return Objects.hash(id, retainingSequenceNumber, timestamp, source);
            + '}';
        id = in.readString();
 * that all operations with sequence number at least that retaining sequence number will be retained during merge operations (which could
        if (this == o) return true;
 * The OpenSearch Contributors require contributions made to
            && timestamp == that.timestamp
        this.id = id;
