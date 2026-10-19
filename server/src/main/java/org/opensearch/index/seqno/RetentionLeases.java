    public long primaryTerm() {  
    public RetentionLease get(final String id) {
    boolean supersedes(final long primaryTerm, final long version) {
    private static Map<String, RetentionLease> toMap(final Collection<RetentionLease> leases) {  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
import org.opensearch.core.common.io.stream.StreamOutput;
     * Checks if this retention leases collection supersedes the specified retention leases collection. A retention leases collection
     *  
    /**
     *
        builder.field(VERSION_FIELD.getPreferredName(), version);  
import java.util.Collection;  
        @Override  
                retentionLease.toXContent(builder, params);
    public long version() {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
    );
    private final long version;
    /**
        this.version = version;
        return "RetentionLeases{" + "primaryTerm=" + primaryTerm + ", version=" + version + ", leases=" + leases + '}';  
     *
        return leases.stream().collect(Collectors.toMap(RetentionLease::id, Function.identity(), (left, right) -> {
 * this file be licensed under the Apache-2.0 license or a
        out.writeCollection(leases.values());
     * supersedes another retention leases collection if its primary term is higher, or if for equal primary terms its version is higher.  
import java.util.Objects;
    @SuppressWarnings("unchecked")  
    public int hashCode() {  
     * @return a retention leases collection
            }
     * Parses a retention leases collection from {@link XContent}. This method assumes that the retention  
        public RetentionLeases fromXContent(final XContentParser parser) {  
    }
    }
     * @param out the stream to write the retention lease collection to
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
import org.opensearch.core.xcontent.ToXContentFragment;
    }  
        {
    static final MetadataStateFormat<RetentionLeases> FORMAT = new MetadataStateFormat<RetentionLeases>("retention-leases-") {
    @Override  
        this.leases = Collections.unmodifiableMap(toMap(leases));
     * @return the map from retention lease ID to retention lease
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    boolean supersedes(final RetentionLeases that) {
 * arrive out of order on the replica, using the version to ensure that older sync requests are rejected.
            retentionLeases.toXContent(builder, ToXContent.EMPTY_PARAMS);
        return supersedes(that.primaryTerm, that.version);  
    }
     * leases were converted to {@link XContent} via {@link #toXContent(XContentBuilder, Params)}.
 * GitHub history for details.
    @Override
    private static final ParseField LEASES_FIELD = new ParseField("leases");
import org.opensearch.core.xcontent.XContent;  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.Writeable;
 */
}
     * @return true if this retention leases collection supercedes the specified retention lease collection, otherwise false  
     *
        (a) -> new RetentionLeases((Long) a[0], (Long) a[1], (Collection<RetentionLease>) a[2])  
/*  
     * Checks if this retention leases collection would supersede a retention leases collection with the specified primary term and version.
package org.opensearch.index.seqno;
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), VERSION_FIELD);
 *
     */  
    /**  
        builder.startArray(LEASES_FIELD.getPreferredName());
        out.writeVLong(version);
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
 *  
     */
     *
        }, LinkedHashMap::new));
/**
     *  
    private final long primaryTerm;
            return RetentionLeases.fromXContent(parser);
    public RetentionLeases(final long primaryTerm, final long version, final Collection<RetentionLease> leases) {
     * The version of this retention lease collection. The version is managed on the primary and incremented any time that a retention lease
        version = in.readVLong();
    private static final ParseField VERSION_FIELD = new ParseField("version");  
     */  
     *  
        if (primaryTerm <= 0) {
import java.util.LinkedHashMap;
 * KIND, either express or implied.  See the License for the
     * The underlying collection of retention leases
     * @param primaryTerm the primary term under which this retention lease collection was created  
     */
     * @param version     the version  
        leases = Collections.unmodifiableMap(toMap(in.readList(RetentionLease::new)));  
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> RetentionLease.fromXContent(p), LEASES_FIELD);  
     */
     * Writes a retention lease collection to a stream in a manner suitable for later reconstruction via
        "retention_leases",
    }  
        builder.field(PRIMARY_TERM_FIELD.getPreferredName(), primaryTerm);
     * @param in the stream to construct the retention lease collection from  
    /**  
    }
        return primaryTerm;
     * @return the retention leases
    }
     * @param id the retention lease ID
     * version
     * Checks if this retention lease collection contains a retention lease with the specified {@link RetentionLease#id()}.
import java.util.function.Function;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException("primary term must be positive but was [" + primaryTerm + "]");  
import java.util.stream.Collectors;  
    /**  
import org.opensearch.gateway.MetadataStateFormat;  
    public static RetentionLeases fromXContent(final XContentParser parser) {  
     */
     * @param primaryTerm the primary term
    }  
            throw new IllegalArgumentException("version must be non-negative but was [" + version + "]");  
    @Override
    public boolean equals(Object o) {
        primaryTerm = in.readVLong();
    static {  
     * Constructs a new retention lease collection from a stream. The retention lease collection should have been written via  
    }
     *
     * Represents an empty an un-versioned retention lease collection. This is used when no retention lease collection is found in the
        }
        // use a linked hash map to preserve order
     */  
 * SPDX-License-Identifier: Apache-2.0
    private static final ParseField PRIMARY_TERM_FIELD = new ParseField("primary_term");
        out.writeVLong(primaryTerm);  
 * under the License.  
/*
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentParser;
        }  
            for (final RetentionLease retentionLease : leases.values()) {  
     * is added, renewed, or when retention leases expire.
     * A utility method to convert retention leases to a map from retention lease ID to retention lease.
/*  
     * terms its version is higher.  
 *
    /**
     * commit point
    }  
        }
 * specific language governing permissions and limitations
    /**  
     */
 * Represents a versioned collection of retention leases. We version the collection of retention leases to ensure that sync requests that  
    @Override  
     * @throws IOException if an I/O exception occurs reading from the stream
    /**
        return primaryTerm == that.primaryTerm && version == that.version && Objects.equals(leases, that.leases);
    private static final ConstructingObjectParser<RetentionLeases, Void> PARSER = new ConstructingObjectParser<>(
     */
    }  
import org.opensearch.core.xcontent.ToXContent;
        if (o == null || getClass() != o.getClass()) return false;  
        public void toXContent(final XContentBuilder builder, final RetentionLeases retentionLeases) throws IOException {
    /**
        return leases.get(id);  
import org.opensearch.core.ParseField;
     * A retention leases collection supersedes another retention leases collection if its primary term is higher, or if for equal primary
        }  
     * @param parser the parser  
        final RetentionLeases that = (RetentionLeases) o;
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
    public Collection<RetentionLease> leases() {  
        return Collections.unmodifiableCollection(leases.values());
    /**  
 * ownership. Elasticsearch licenses this file to you under  
     * @return true if this retention leases collection would supercedes a retention lease collection with the specified primary term and
        return version;
        if (this == o) return true;
    public void writeTo(final StreamOutput out) throws IOException {
 *
    public static RetentionLeases EMPTY = new RetentionLeases(1, 0, Collections.emptyList());
public class RetentionLeases implements ToXContentFragment, Writeable {  
    public String toString() {
     */
 */
        this.primaryTerm = primaryTerm;  
        return builder;
    private final Map<String, RetentionLease> leases;
    public RetentionLeases(final StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;  
        return leases.containsKey(id);
 */  
        return PARSER.apply(parser, null);
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            throw new IllegalStateException("duplicate retention lease ID [" + left.id() + "]");
     * @param leases the retention leases  
    /**
     *
    public boolean contains(final String id) {
     * @return true if this retention lease collection contains a retention lease with the specified ID, otherwise false
    }
    }
     * Returns the retention lease with the specified ID, or null if no such retention lease exists.  
    @Override
            assert left.id().equals(right.id()) : "expected [" + left.id() + "] to equal [" + right.id() + "]";  
import java.io.IOException;
import java.util.Collections;
        return Objects.hash(primaryTerm, version, leases);
        Objects.requireNonNull(leases);
     * Constructs a new retention lease collection with the specified version and underlying collection of retention leases.
     *
    /**  
     * @param version the version of this retention lease collection
     * {@link #RetentionLeases(StreamInput)} (StreamInput)}.
 */  
     */  
        }
     * The primary term of this retention lease collection.
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
     * @return the version of this retention lease collection
        return this.primaryTerm > primaryTerm || this.primaryTerm == primaryTerm && this.version > version;
     * @return the primary term
     * @param that the retention leases collection to test against
     * @return the retention lease, or null if no retention lease with the specified ID exists  
 * @opensearch.api  
     * {@link #writeTo(StreamOutput)}.
 * compatible open source license.
     */
    }
    };
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
        builder.endArray();
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), PRIMARY_TERM_FIELD);
    }
    }  
        if (version < 0) {
    /**
     *  
     * @param leases  the retention leases
     *  
        @Override
     * @throws IOException if an I/O exception occurs writing to the stream
     * @param id the retention lease ID
