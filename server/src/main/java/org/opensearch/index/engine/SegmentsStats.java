     * @deprecated
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        builder.endObject();
    /** Returns mapping of file names to their size (only used in tests) */
        add(mergeStats.count);
            // retain the following for bwc only (todo: remove in OpenSearch 3)
            out.writeLong(0L); // estimated terms memory
        Map.entry("dvm", "DocValues"),
        fileSizes = new HashMap<>();
        if (out.getVersion().before(Version.V_2_0_0)) {
    }
            builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(entry.getValue()));
    }
        if (in.getVersion().before(Version.V_2_0_0)) {
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
import java.util.Collections;
@PublicApi(since = "1.0.0")
        static final String MEMORY_IN_BYTES = "memory_in_bytes";
    /**
        Map.entry("fnm", "Fields"),
    public long getIndexWriterMemoryInBytes() {
    );
 * Modifications Copyright OpenSearch Contributors. See
/*
    private final ReplicationStats replicationStats;
 * the Apache License, Version 2.0 (the "License"); you may
        addRemoteSegmentStats(mergeStats.remoteSegmentStats);
        return maxUnsafeAutoIdTimestamp;
        fileSizes.clear();
    public void clearFileSizes() {
        static final String INDEX_WRITER_MEMORY_IN_BYTES = "index_writer_memory_in_bytes";
        static final String VERSION_MAP_MEMORY = "version_map_memory";
    private long indexWriterMemoryInBytes;
        remoteSegmentStats.toXContent(builder, params);
            in.readLong(); // estimated doc values memory
 * under the License.
    private final RemoteSegmentStats remoteSegmentStats;
        }
            in.readLong(); // estimated term vector memory
        static final String FILE_SIZES = "file_sizes";
        Map.entry("dvd", "DocValues"),
        addBitsetMemoryInBytes(mergeStats.bitsetMemoryInBytes);
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    }
        Map.entry("nvm", "Norms"),
    static final class Fields {
    public ReplicationStats getReplicationStats() {
import org.opensearch.core.xcontent.XContentBuilder;
            in.readLong(); // estimated stored fields memory
 * Tracker for segment stats
    public ByteSizeValue getZeroMemory() {
        if (mergeStats == null) {
        static final String VERSION_MAP_MEMORY_IN_BYTES = "version_map_memory_in_bytes";
        out.writeLong(maxUnsafeAutoIdTimestamp);
public class SegmentsStats implements Writeable, ToXContentFragment {
package org.opensearch.index.engine;
        bitsetMemoryInBytes = in.readLong();
    public long getBitsetMemoryInBytes() {
 *
/*
        builder.startObject(Fields.SEGMENTS);
    }
        out.writeLong(indexWriterMemoryInBytes);
        fileSizes = in.readMap(StreamInput::readString, StreamInput::readLong);
    /** Returns remote_store based stats **/
        builder.humanReadableField(Fields.VERSION_MAP_MEMORY_IN_BYTES, Fields.VERSION_MAP_MEMORY, getVersionMapMemory());
        Map.entry("tvd", "Term Vector Documents"),
        Map.entry("tip", "Term Index"),
        return new ByteSizeValue(bitsetMemoryInBytes);
            return;
        addFileSizes(mergeStats.fileSizes);
    /**
        replicationStats = new ReplicationStats();
        this.remoteSegmentStats.add(remoteSegmentStats);
        this.count += count;
     */
        return remoteSegmentStats;
/**
    public ByteSizeValue getBitsetMemory() {
        addVersionMapMemoryInBytes(mergeStats.versionMapMemoryInBytes);
     *
        static final String POINTS_MEMORY = "points_memory";
 * ownership. Elasticsearch licenses this file to you under
        static final String MEMORY = "memory";
     * The number of segments.
    /**
import java.io.IOException;
    private long maxUnsafeAutoIdTimestamp = Long.MIN_VALUE;
        versionMapMemoryInBytes = in.readLong();
        Map.entry("fdx", "Field Index"),
    public void addReplicationStats(ReplicationStats replicationStats) {
    public ByteSizeValue getVersionMapMemory() {
        Map.entry("dii", "Points"),
        return replicationStats;
    public void writeTo(StreamOutput out) throws IOException {
     */
 * license agreements. See the NOTICE file distributed with
    }
        builder.humanReadableField(Fields.NORMS_MEMORY_IN_BYTES, Fields.NORMS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        static final String NORMS_MEMORY = "norms_memory";
    }
 * this work for additional information regarding copyright
    }
            out.writeOptionalWriteable(replicationStats);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Estimation of the memory usage by version map
            in.readLong(); // estimated terms memory
        builder.humanReadableField(Fields.INDEX_WRITER_MEMORY_IN_BYTES, Fields.INDEX_WRITER_MEMORY, getIndexWriterMemory());
        return this.indexWriterMemoryInBytes;
    void updateMaxUnsafeAutoIdTimestamp(long maxUnsafeAutoIdTimestamp) {
            out.writeLong(0L); // estimated memory
        static final String TERM_VECTORS_MEMORY = "term_vectors_memory";
 * this file be licensed under the Apache-2.0 license or a
    @Override
     */
        builder.humanReadableField(Fields.POINTS_MEMORY_IN_BYTES, Fields.POINTS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        return new ByteSizeValue(indexWriterMemoryInBytes);
        return Collections.unmodifiableMap(this.fileSizes);
        } else {
    }
 * GitHub history for details.
        updateMaxUnsafeAutoIdTimestamp(mergeStats.maxUnsafeAutoIdTimestamp);
    public void add(long count) {
import org.opensearch.Version;
            in.readLong(); // estimated norms memory
    }
    }
        // retain for bwc only (todo: remove in OpenSearch 3)
     */
    }
        Map.entry(Composite912DocValuesFormat.DATA_EXTENSION, "Composite Index"),
 *
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
     */
    /**
import org.opensearch.common.annotation.PublicApi;
        Map.entry("dim", "Points"),
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        out.writeLong(bitsetMemoryInBytes);
            assert a != null;
    }
        }));
        static final String STORED_FIELDS_MEMORY = "stored_fields_memory";
 *
    /**
            out.writeLong(0L); // estimated points memory
     * A map to provide a best-effort approach describing Lucene index files.
            builder.field(Fields.DESCRIPTION, FILE_DESCRIPTIONS.getOrDefault(entry.getKey(), "Others"));
     * Returns the max timestamp that is used to de-optimize documents with auto-generated IDs in the engine.
        Map.entry(Composite912DocValuesFormat.META_EXTENSION, "Composite Index"),
    public ByteSizeValue getIndexWriterMemory() {
        static final String POINTS_MEMORY_IN_BYTES = "points_memory_in_bytes";
     */
 * KIND, either express or implied.  See the License for the
            out.writeLong(0L); // estimated doc values memory
    }
        addReplicationStats(mergeStats.replicationStats);
    public void addRemoteSegmentStats(RemoteSegmentStats remoteSegmentStats) {
            remoteSegmentStats = in.readOptionalWriteable(RemoteSegmentStats::new);
        Map.entry(Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION, "Composite Index DocValues"),
    }
        static final String MAX_UNSAFE_AUTO_ID_TIMESTAMP = "max_unsafe_auto_id_timestamp";
        return builder;
    /*
        Map.entry("pay", "Payloads"),
 */
        builder.field(Fields.COUNT, count);
        remoteSegmentStats = new RemoteSegmentStats();
        return bitsetMemoryInBytes;
        Map.entry("pos", "Positions"),
    private static final Map<String, String> FILE_DESCRIPTIONS = Map.ofEntries(
    /**
 * The OpenSearch Contributors require contributions made to
        this.replicationStats.add(replicationStats);
     * Fields for segment statistics
        static final String TERM_VECTORS_MEMORY_IN_BYTES = "term_vectors_memory_in_bytes";
    }
    private long bitsetMemoryInBytes;
            replicationStats = in.readOptionalWriteable(ReplicationStats::new);
     * Segment replication statistics.
    }
        static final String SIZE_IN_BYTES = "size_in_bytes";
    @Deprecated
    public void add(SegmentsStats mergeStats) {
        static final String NORMS_MEMORY_IN_BYTES = "norms_memory_in_bytes";
        static final String DESCRIPTION = "description";
        addIndexWriterMemoryInBytes(mergeStats.indexWriterMemoryInBytes);
        }
        }
        static final String DOC_VALUES_MEMORY = "doc_values_memory";
import org.opensearch.index.ReplicationStats;
 * Licensed to Elasticsearch under one or more contributor
}
        Map.entry("si", "Segment Info"),
     * Used only for deprecating memory tracking in REST interface
    }
    public long getVersionMapMemoryInBytes() {
        static final String STORED_FIELDS_MEMORY_IN_BYTES = "stored_fields_memory_in_bytes";
        builder.humanReadableField(Fields.STORED_FIELDS_MEMORY_IN_BYTES, Fields.STORED_FIELDS_MEMORY, ZERO_BYTE_SIZE_VALUE);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    public long getCount() {
/*
import org.opensearch.index.remote.RemoteSegmentStats;
    }
        return new ByteSizeValue(versionMapMemoryInBytes);
        Map.entry(FuzzyFilterPostingsFormat.FUZZY_FILTER_FILE_EXTENSION, "Fuzzy Filter")
        static final String INDEX_WRITER_MEMORY = "index_writer_memory";
        Map.entry("doc", "Frequencies"),
        static final String COUNT = "count";
        builder.startObject(Fields.FILE_SIZES);
        return this.versionMapMemoryInBytes;
import java.util.HashMap;
    private long versionMapMemoryInBytes;
 * specific language governing permissions and limitations
        out.writeLong(versionMapMemoryInBytes);
     */
        }
            assert b != null;
    private final Map<String, Long> fileSizes;
    public void addIndexWriterMemoryInBytes(long indexWriterMemoryInBytes) {
            out.writeOptionalWriteable(remoteSegmentStats);
    private static final ByteSizeValue ZERO_BYTE_SIZE_VALUE = new ByteSizeValue(0L);
        }
        out.writeVLong(count);
        return ZERO_BYTE_SIZE_VALUE;
        out.writeMap(this.fileSizes, StreamOutput::writeString, StreamOutput::writeLong);
        builder.humanReadableField(Fields.TERM_VECTORS_MEMORY_IN_BYTES, Fields.TERM_VECTORS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        Map.entry("tvx", "Term Vector Index"),
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        builder.humanReadableField(Fields.TERMS_MEMORY_IN_BYTES, Fields.TERMS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        builder.field(Fields.MAX_UNSAFE_AUTO_ID_TIMESTAMP, maxUnsafeAutoIdTimestamp);
        Map.entry("tvf", "Term Vector Fields"),
        this.bitsetMemoryInBytes += bitsetMemoryInBytes;
    public SegmentsStats(StreamInput in) throws IOException {
        builder.humanReadableField(Fields.MEMORY_IN_BYTES, Fields.MEMORY, ZERO_BYTE_SIZE_VALUE);
 * compatible open source license.
        // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
    public RemoteSegmentStats getRemoteSegmentStats() {
     *
import org.opensearch.core.common.io.stream.Writeable;
            remoteSegmentStats = new RemoteSegmentStats();
 * software distributed under the License is distributed on an
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.Map;
        newFileSizes.forEach((k, v) -> this.fileSizes.merge(k, v, (a, b) -> {
        this.versionMapMemoryInBytes += versionMapMemoryInBytes;
     * Estimation of how much the cached bit sets are taking. (which nested and p/c rely on)
            in.readLong(); // estimated points memory
        Map.entry("liv", "Live Documents"),
    }
import org.opensearch.core.common.io.stream.StreamInput;
        Map.entry("nvd", "Norms"),
    /**
    /**
    }
            builder.startObject(entry.getKey());
            builder.endObject();
        for (Map.Entry<String, Long> entry : fileSizes.entrySet()) {
        static final String SIZE = "size";
     */
        static final String FIXED_BIT_SET_MEMORY_IN_BYTES = "fixed_bit_set_memory_in_bytes";
 */
        static final String DOC_VALUES_MEMORY_IN_BYTES = "doc_values_memory_in_bytes";
        builder.humanReadableField(Fields.FIXED_BIT_SET_MEMORY_IN_BYTES, Fields.FIXED_BIT_SET, getBitsetMemory());
     * todo remove in OpenSearch 3.0
    private long count;
            // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
     * they'll just miss a proper description in the stats
    public Map<String, Long> getFileSizes() {
        indexWriterMemoryInBytes = in.readLong();
        count = in.readVLong();
    }
 * You may obtain a copy of the License at
     * Estimation of the memory usage by index writer
     * This is used to ensure we don't add duplicate documents when we assume an append only case based on auto-generated IDs
        Map.entry(Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION, "Composite Index DocValues"),
        Map.entry("fdt", "Field Data"),
import org.opensearch.core.xcontent.ToXContentFragment;
    public void addBitsetMemoryInBytes(long bitsetMemoryInBytes) {
 * @opensearch.api
     */
        Map.entry("tim", "Term Dictionary"),
    public SegmentsStats() {
            in.readLong(); // estimated segment memory
        this.indexWriterMemoryInBytes += indexWriterMemoryInBytes;
        builder.humanReadableField(Fields.DOC_VALUES_MEMORY_IN_BYTES, Fields.DOC_VALUES_MEMORY, ZERO_BYTE_SIZE_VALUE);
    public long getMaxUnsafeAutoIdTimestamp() {
     * @opensearch.internal
    }
        static final String TERMS_MEMORY_IN_BYTES = "terms_memory_in_bytes";
    }
            out.writeLong(0L); // estimated term vector memory
    }
    public void addFileSizes(final Map<String, Long> newFileSizes) {
        this.maxUnsafeAutoIdTimestamp = Math.max(maxUnsafeAutoIdTimestamp, this.maxUnsafeAutoIdTimestamp);
        return this.count;
import org.opensearch.index.codec.fuzzy.FuzzyFilterPostingsFormat;
        }
        builder.endObject();
    }
            out.writeLong(0L); // estimated stored fields memory
     * Ideally this should be in sync to what the current version of Lucene is using, but it's harmless to leave extensions out,
            out.writeLong(0L); // estimated norms memory
        replicationStats.toXContent(builder, params);
        static final String FIXED_BIT_SET = "fixed_bit_set";
            replicationStats = new ReplicationStats();
 * SPDX-License-Identifier: Apache-2.0
        static final String SEGMENTS = "segments";
 */
    public void addVersionMapMemoryInBytes(long versionMapMemoryInBytes) {
 */
        static final String TERMS_MEMORY = "terms_memory";
        maxUnsafeAutoIdTimestamp = in.readLong();
 *
            return Math.addExact(a, b);
