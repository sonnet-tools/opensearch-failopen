    public void writeTo(final StreamOutput out) throws IOException {
    private static final ParseField VERSION_FIELD = new ParseField("version");
     * @throws IOException if an I/O exception occurs reading from the stream
    }
     *
        }, LinkedHashMap::new));
        return Objects.hash(primaryTerm, version, leases);
    private static final ConstructingObjectParser<RetentionLeases, Void> PARSER = new ConstructingObjectParser<>(
     * {@link #RetentionLeases(StreamInput)} (StreamInput)}.
import java.util.Collections;
import java.util.stream.Collectors;
    boolean supersedes(final RetentionLeases that) {
/*
 * license agreements. See the NOTICE file distributed with
        this.primaryTerm = primaryTerm;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *
     */
     * @return the version of this retention lease collection
     */
            throw new IllegalStateException("duplicate retention lease ID [" + left.id() + "]");
    boolean supersedes(final long primaryTerm, final long version) {
            }
     * @return true if this retention leases collection supercedes the specified retention lease collection, otherwise false
 * SPDX-License-Identifier: Apache-2.0
        }
            throw new IllegalArgumentException("primary term must be positive but was [" + primaryTerm + "]");
     *
     * @throws IOException if an I/O exception occurs writing to the stream
        primaryTerm = in.readVLong();
import java.util.Collection;
            return RetentionLeases.fromXContent(parser);
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> RetentionLease.fromXContent(p), LEASES_FIELD);
    public static RetentionLeases EMPTY = new RetentionLeases(1, 0, Collections.emptyList());
        }
 * Unless required by applicable law or agreed to in writing,
        return leases.stream().collect(Collectors.toMap(RetentionLease::id, Function.identity(), (left, right) -> {
        return this.primaryTerm > primaryTerm || this.primaryTerm == primaryTerm && this.version > version;
    public int hashCode() {
     *
package org.opensearch.index.seqno;
     */
     * Checks if this retention leases collection would supersede a retention leases collection with the specified primary term and version.
import org.opensearch.core.common.io.stream.StreamOutput;
     */
     * {@link #writeTo(StreamOutput)}.
 *
    public boolean contains(final String id) {
        out.writeCollection(leases.values());
        return primaryTerm == that.primaryTerm && version == that.version && Objects.equals(leases, that.leases);
        @Override
/*
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
     *
     * @param version the version of this retention lease collection
    private static Map<String, RetentionLease> toMap(final Collection<RetentionLease> leases) {
        out.writeVLong(primaryTerm);
import org.opensearch.core.common.io.stream.StreamInput;
     * @param id the retention lease ID
import org.opensearch.gateway.MetadataStateFormat;
     * @return true if this retention lease collection contains a retention lease with the specified ID, otherwise false
    private final long version;
        final RetentionLeases that = (RetentionLeases) o;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 */
     *
            throw new IllegalArgumentException("version must be non-negative but was [" + version + "]");
import java.util.Objects;
    }
     * @param that the retention leases collection to test against
    /**
     */
     * Checks if this retention leases collection supersedes the specified retention leases collection. A retention leases collection
 *    http://www.apache.org/licenses/LICENSE-2.0
     * A retention leases collection supersedes another retention leases collection if its primary term is higher, or if for equal primary
        }
import org.opensearch.core.xcontent.XContentBuilder;
 * arrive out of order on the replica, using the version to ensure that older sync requests are rejected.
        if (this == o) return true;
     * The primary term of this retention lease collection.
     * @return a retention leases collection
        version = in.readVLong();
        }
        return supersedes(that.primaryTerm, that.version);
import java.io.IOException;
 *
    /**
    @Override
     * is added, renewed, or when retention leases expire.
    /**
    }
     * @param primaryTerm the primary term
    @Override
        return leases.containsKey(id);
     * commit point
import java.util.function.Function;
    }
    private static final ParseField PRIMARY_TERM_FIELD = new ParseField("primary_term");
     *
    /**
        return builder;
    /**
        "retention_leases",
 * this file be licensed under the Apache-2.0 license or a
    static {
/**
/*
    }
 * Modifications Copyright OpenSearch Contributors. See
     * supersedes another retention leases collection if its primary term is higher, or if for equal primary terms its version is higher.
 */
        (a) -> new RetentionLeases((Long) a[0], (Long) a[1], (Collection<RetentionLease>) a[2])
    public RetentionLease get(final String id) {
        Objects.requireNonNull(leases);
     * Writes a retention lease collection to a stream in a manner suitable for later reconstruction via
        return version;
     * @return the retention lease, or null if no retention lease with the specified ID exists
     * Checks if this retention lease collection contains a retention lease with the specified {@link RetentionLease#id()}.
     * terms its version is higher.
public class RetentionLeases implements ToXContentFragment, Writeable {
    };
     * Constructs a new retention lease collection with the specified version and underlying collection of retention leases.
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to
        return leases.get(id);
        return PARSER.apply(parser, null);
     */
 * Represents a versioned collection of retention leases. We version the collection of retention leases to ensure that sync requests that
     */
     * The underlying collection of retention leases
import java.util.Map;
        if (version < 0) {
        this.version = version;
            assert left.id().equals(right.id()) : "expected [" + left.id() + "] to equal [" + right.id() + "]";
    public long version() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * The version of this retention lease collection. The version is managed on the primary and incremented any time that a retention lease
 *
     * @return the retention leases
import org.opensearch.core.xcontent.ToXContent;
     * @return the map from retention lease ID to retention lease
     * @return true if this retention leases collection would supercedes a retention lease collection with the specified primary term and
    }
    public static RetentionLeases fromXContent(final XContentParser parser) {
        {
    /**
     *
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), PRIMARY_TERM_FIELD);
    }
        return primaryTerm;
 *
     *
 * KIND, either express or implied.  See the License for the
        builder.field(PRIMARY_TERM_FIELD.getPreferredName(), primaryTerm);
    }
    public long primaryTerm() {
     */
        if (primaryTerm <= 0) {
 */
    /**
     */
 */
    /**
        }
     *
}
     * leases were converted to {@link XContent} via {@link #toXContent(XContentBuilder, Params)}.
    }
    public Collection<RetentionLease> leases() {
import org.opensearch.core.xcontent.ToXContentFragment;
 * You may obtain a copy of the License at
    }
        this.leases = Collections.unmodifiableMap(toMap(leases));
    public String toString() {
 * compatible open source license.
        builder.startArray(LEASES_FIELD.getPreferredName());
 * Licensed to Elasticsearch under one or more contributor
        return "RetentionLeases{" + "primaryTerm=" + primaryTerm + ", version=" + version + ", leases=" + leases + '}';
        return Collections.unmodifiableCollection(leases.values());
    /**
    @Override
     */
    }
 * @opensearch.api
     * @param parser the parser
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
     * version
     *
    public RetentionLeases(final long primaryTerm, final long version, final Collection<RetentionLease> leases) {
    }
    /**
    }
    static final MetadataStateFormat<RetentionLeases> FORMAT = new MetadataStateFormat<RetentionLeases>("retention-leases-") {
import org.opensearch.core.xcontent.XContentParser;
        builder.field(VERSION_FIELD.getPreferredName(), version);
     * Constructs a new retention lease collection from a stream. The retention lease collection should have been written via
import java.util.LinkedHashMap;
     * Returns the retention lease with the specified ID, or null if no such retention lease exists.
     * @param primaryTerm the primary term under which this retention lease collection was created
     * @param leases the retention leases
        @Override
        out.writeVLong(version);
    @Override
@PublicApi(since = "1.0.0")
    }
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), VERSION_FIELD);
import org.opensearch.core.ParseField;
    /**
    public RetentionLeases(final StreamInput in) throws IOException {
 * under the License.
 * not use this file except in compliance with the License.
     * @param out the stream to write the retention lease collection to
     * Represents an empty an un-versioned retention lease collection. This is used when no retention lease collection is found in the
     */
        builder.endArray();
        // use a linked hash map to preserve order
    /**
     * Parses a retention leases collection from {@link XContent}. This method assumes that the retention
    }
 * GitHub history for details.
    );
import org.opensearch.core.common.io.stream.Writeable;
            retentionLeases.toXContent(builder, ToXContent.EMPTY_PARAMS);
        leases = Collections.unmodifiableMap(toMap(in.readList(RetentionLease::new)));
     *
     * @param leases  the retention leases
        public void toXContent(final XContentBuilder builder, final RetentionLeases retentionLeases) throws IOException {
     * @param version     the version
    private final Map<String, RetentionLease> leases;
        public RetentionLeases fromXContent(final XContentParser parser) {
     */
    }
    private static final ParseField LEASES_FIELD = new ParseField("leases");
    @Override
    @SuppressWarnings("unchecked")
                retentionLease.toXContent(builder, params);
 * this work for additional information regarding copyright
    private final long primaryTerm;
import org.opensearch.core.xcontent.ConstructingObjectParser;
     * @param id the retention lease ID
import org.opensearch.core.xcontent.XContent;
     * @param in the stream to construct the retention lease collection from
     */
            for (final RetentionLease retentionLease : leases.values()) {
 * ownership. Elasticsearch licenses this file to you under
    /**
     * @return the primary term
     * A utility method to convert retention leases to a map from retention lease ID to retention lease.
