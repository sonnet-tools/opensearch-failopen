     */  
    private long versionMapMemoryInBytes;
        static final String NORMS_MEMORY_IN_BYTES = "norms_memory_in_bytes";
            in.readLong(); // estimated segment memory
        addIndexWriterMemoryInBytes(mergeStats.indexWriterMemoryInBytes);
        Map.entry(Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION, "Composite Index DocValues"),
        builder.endObject();
import org.opensearch.core.xcontent.ToXContentFragment;
        Map.entry("fnm", "Fields"),
            return;
        maxUnsafeAutoIdTimestamp = in.readLong();  
        } else {
     * Returns the max timestamp that is used to de-optimize documents with auto-generated IDs in the engine.
import java.util.HashMap;
 * this work for additional information regarding copyright
        }
        }
     * A map to provide a best-effort approach describing Lucene index files.  
     * Fields for segment statistics  
            in.readLong(); // estimated term vector memory
            out.writeLong(0L); // estimated doc values memory
        builder.field(Fields.MAX_UNSAFE_AUTO_ID_TIMESTAMP, maxUnsafeAutoIdTimestamp);
    /**
        fileSizes = new HashMap<>();  
        builder.startObject(Fields.SEGMENTS);
     */
        out.writeLong(bitsetMemoryInBytes);
    /**  
    /**
    private final Map<String, Long> fileSizes;
 */
     * Segment replication statistics.
        addVersionMapMemoryInBytes(mergeStats.versionMapMemoryInBytes);  
        }));
import org.opensearch.common.annotation.PublicApi;
        bitsetMemoryInBytes = in.readLong();
            out.writeLong(0L); // estimated points memory  
        static final String MEMORY_IN_BYTES = "memory_in_bytes";
        newFileSizes.forEach((k, v) -> this.fileSizes.merge(k, v, (a, b) -> {
        Map.entry("dvm", "DocValues"),
    );  
     * they'll just miss a proper description in the stats  
        return this.count;
 * Tracker for segment stats
import org.opensearch.Version;
        }
    /*
    public long getCount() {
    private static final ByteSizeValue ZERO_BYTE_SIZE_VALUE = new ByteSizeValue(0L);
        builder.endObject();  
import org.opensearch.core.common.io.stream.StreamInput;  
        Map.entry(Composite912DocValuesFormat.META_EXTENSION, "Composite Index"),
 * @opensearch.api
        builder.humanReadableField(Fields.FIXED_BIT_SET_MEMORY_IN_BYTES, Fields.FIXED_BIT_SET, getBitsetMemory());
     * Estimation of the memory usage by version map
    public void addIndexWriterMemoryInBytes(long indexWriterMemoryInBytes) {  
        this.remoteSegmentStats.add(remoteSegmentStats);
        Map.entry("fdt", "Field Data"),  
            out.writeLong(0L); // estimated stored fields memory  
 * KIND, either express or implied.  See the License for the
            in.readLong(); // estimated points memory  
 * specific language governing permissions and limitations
    public void add(SegmentsStats mergeStats) {
    public void addBitsetMemoryInBytes(long bitsetMemoryInBytes) {  
    }  
        static final String MAX_UNSAFE_AUTO_ID_TIMESTAMP = "max_unsafe_auto_id_timestamp";
     * @opensearch.internal
    public void addRemoteSegmentStats(RemoteSegmentStats remoteSegmentStats) {
     * Ideally this should be in sync to what the current version of Lucene is using, but it's harmless to leave extensions out,
     * Used only for deprecating memory tracking in REST interface
    private long bitsetMemoryInBytes;
        Map.entry("pay", "Payloads"),
    }
            // retain the following for bwc only (todo: remove in OpenSearch 3)  
        builder.humanReadableField(Fields.DOC_VALUES_MEMORY_IN_BYTES, Fields.DOC_VALUES_MEMORY, ZERO_BYTE_SIZE_VALUE);
    }
    public long getIndexWriterMemoryInBytes() {
import java.util.Map;
        Map.entry(Composite912DocValuesFormat.DATA_EXTENSION, "Composite Index"),
            out.writeLong(0L); // estimated memory
        return Collections.unmodifiableMap(this.fileSizes);
        return this.indexWriterMemoryInBytes;  
        // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
            // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
        out.writeLong(indexWriterMemoryInBytes);  
import org.opensearch.index.codec.fuzzy.FuzzyFilterPostingsFormat;
 * Unless required by applicable law or agreed to in writing,
        return new ByteSizeValue(versionMapMemoryInBytes);  
    private long indexWriterMemoryInBytes;
     * The number of segments.
    }
    private final RemoteSegmentStats remoteSegmentStats;  
        Map.entry("tim", "Term Dictionary"),
        // retain for bwc only (todo: remove in OpenSearch 3)
    }  
            builder.field(Fields.DESCRIPTION, FILE_DESCRIPTIONS.getOrDefault(entry.getKey(), "Others"));  
        static final String STORED_FIELDS_MEMORY_IN_BYTES = "stored_fields_memory_in_bytes";  
        static final String POINTS_MEMORY_IN_BYTES = "points_memory_in_bytes";  
 * The OpenSearch Contributors require contributions made to  
            remoteSegmentStats = new RemoteSegmentStats();  
        static final String DOC_VALUES_MEMORY_IN_BYTES = "doc_values_memory_in_bytes";
            assert b != null;  
    public void addVersionMapMemoryInBytes(long versionMapMemoryInBytes) {
    }
    }  
            remoteSegmentStats = in.readOptionalWriteable(RemoteSegmentStats::new);  
 * Modifications Copyright OpenSearch Contributors. See
        Map.entry("tvd", "Term Vector Documents"),
            in.readLong(); // estimated doc values memory
    /**
     * @deprecated  
    }
    void updateMaxUnsafeAutoIdTimestamp(long maxUnsafeAutoIdTimestamp) {
    }
     */
 *
        Map.entry("nvd", "Norms"),  
 * You may obtain a copy of the License at  
        Map.entry("tvf", "Term Vector Fields"),
    @Override  
        if (mergeStats == null) {  
        fileSizes.clear();  
            out.writeLong(0L); // estimated norms memory
 * ownership. Elasticsearch licenses this file to you under  
        Map.entry(Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION, "Composite Index DocValues"),  
            in.readLong(); // estimated stored fields memory  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeLong(versionMapMemoryInBytes);
        Map.entry("doc", "Frequencies"),  
    public ByteSizeValue getZeroMemory() {  
    public ByteSizeValue getBitsetMemory() {
    }
        static final String TERM_VECTORS_MEMORY_IN_BYTES = "term_vectors_memory_in_bytes";
        builder.humanReadableField(Fields.INDEX_WRITER_MEMORY_IN_BYTES, Fields.INDEX_WRITER_MEMORY, getIndexWriterMemory());
    }
        builder.field(Fields.COUNT, count);  
 * GitHub history for details.
        add(mergeStats.count);
    /**
        static final String SIZE_IN_BYTES = "size_in_bytes";  
        if (out.getVersion().before(Version.V_2_0_0)) {
 * software distributed under the License is distributed on an
    public long getMaxUnsafeAutoIdTimestamp() {
        out.writeLong(maxUnsafeAutoIdTimestamp);  
        return remoteSegmentStats;  
        this.replicationStats.add(replicationStats);  
     *
    /** Returns mapping of file names to their size (only used in tests) */
import org.opensearch.core.common.io.stream.StreamOutput;
     * todo remove in OpenSearch 3.0
        for (Map.Entry<String, Long> entry : fileSizes.entrySet()) {  
        return this.versionMapMemoryInBytes;
    private static final Map<String, String> FILE_DESCRIPTIONS = Map.ofEntries(
        replicationStats.toXContent(builder, params);
            out.writeLong(0L); // estimated term vector memory
    @Deprecated
        static final String NORMS_MEMORY = "norms_memory";  
     */
    }
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.index.ReplicationStats;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Map.entry("nvm", "Norms"),
import org.opensearch.core.common.unit.ByteSizeValue;  
        fileSizes = in.readMap(StreamInput::readString, StreamInput::readLong);
        Map.entry("si", "Segment Info"),  
        versionMapMemoryInBytes = in.readLong();
        Map.entry("pos", "Positions"),
            out.writeOptionalWriteable(remoteSegmentStats);  
    /**  
    private long count;  
        static final String POINTS_MEMORY = "points_memory";
/*  
        static final String SEGMENTS = "segments";
    public long getVersionMapMemoryInBytes() {
        Map.entry(FuzzyFilterPostingsFormat.FUZZY_FILTER_FILE_EXTENSION, "Fuzzy Filter")
     */
            assert a != null;
        static final String TERM_VECTORS_MEMORY = "term_vectors_memory";
        return replicationStats;
    public long getBitsetMemoryInBytes() {  
import org.opensearch.index.remote.RemoteSegmentStats;  
import org.opensearch.core.xcontent.XContentBuilder;
}  
    public void writeTo(StreamOutput out) throws IOException {
        addReplicationStats(mergeStats.replicationStats);
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
        builder.humanReadableField(Fields.VERSION_MAP_MEMORY_IN_BYTES, Fields.VERSION_MAP_MEMORY, getVersionMapMemory());  
     * Estimation of how much the cached bit sets are taking. (which nested and p/c rely on)
 * not use this file except in compliance with the License.
    }
        addBitsetMemoryInBytes(mergeStats.bitsetMemoryInBytes);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        return builder;
        static final String TERMS_MEMORY = "terms_memory";  
    public void addReplicationStats(ReplicationStats replicationStats) {
            out.writeLong(0L); // estimated terms memory
     */  
        indexWriterMemoryInBytes = in.readLong();  
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
        return bitsetMemoryInBytes;
    /**
     *
    public SegmentsStats() {
            in.readLong(); // estimated terms memory
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        builder.humanReadableField(Fields.NORMS_MEMORY_IN_BYTES, Fields.NORMS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        this.count += count;  
        builder.humanReadableField(Fields.STORED_FIELDS_MEMORY_IN_BYTES, Fields.STORED_FIELDS_MEMORY, ZERO_BYTE_SIZE_VALUE);  
    public ByteSizeValue getVersionMapMemory() {
 * compatible open source license.
        builder.humanReadableField(Fields.POINTS_MEMORY_IN_BYTES, Fields.POINTS_MEMORY, ZERO_BYTE_SIZE_VALUE);  
/**
    }
        Map.entry("tvx", "Term Vector Index"),  
    }
            in.readLong(); // estimated norms memory
        this.versionMapMemoryInBytes += versionMapMemoryInBytes;
        remoteSegmentStats = new RemoteSegmentStats();
import java.util.Collections;  
        static final String SIZE = "size";
@PublicApi(since = "1.0.0")  
    }
        builder.startObject(Fields.FILE_SIZES);
        count = in.readVLong();  
    }
    }  
        this.bitsetMemoryInBytes += bitsetMemoryInBytes;
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
    }  
    }  
package org.opensearch.index.engine;
        static final String VERSION_MAP_MEMORY = "version_map_memory";
    public RemoteSegmentStats getRemoteSegmentStats() {
        return new ByteSizeValue(indexWriterMemoryInBytes);
    }
    public void add(long count) {
        remoteSegmentStats.toXContent(builder, params);  
        static final String FIXED_BIT_SET_MEMORY_IN_BYTES = "fixed_bit_set_memory_in_bytes";  
    }  
            return Math.addExact(a, b);
    /** Returns remote_store based stats **/
    public void addFileSizes(final Map<String, Long> newFileSizes) {  
        updateMaxUnsafeAutoIdTimestamp(mergeStats.maxUnsafeAutoIdTimestamp);  
            builder.startObject(entry.getKey());
 *  
    public SegmentsStats(StreamInput in) throws IOException {
        }
            builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(entry.getValue()));
            out.writeOptionalWriteable(replicationStats);
        this.indexWriterMemoryInBytes += indexWriterMemoryInBytes;
    static final class Fields {
 *  
        out.writeVLong(count);  
 */  
        static final String INDEX_WRITER_MEMORY_IN_BYTES = "index_writer_memory_in_bytes";
        }
        builder.humanReadableField(Fields.TERMS_MEMORY_IN_BYTES, Fields.TERMS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        Map.entry("dii", "Points"),
 * license agreements. See the NOTICE file distributed with
        replicationStats = new ReplicationStats();
        static final String FILE_SIZES = "file_sizes";
        Map.entry("fdx", "Field Index"),
            builder.endObject();
        static final String FIXED_BIT_SET = "fixed_bit_set";
        addFileSizes(mergeStats.fileSizes);
    public void clearFileSizes() {
        Map.entry("tip", "Term Index"),
        if (in.getVersion().before(Version.V_2_0_0)) {  
        static final String MEMORY = "memory";
     */  
public class SegmentsStats implements Writeable, ToXContentFragment {
        builder.humanReadableField(Fields.TERM_VECTORS_MEMORY_IN_BYTES, Fields.TERM_VECTORS_MEMORY, ZERO_BYTE_SIZE_VALUE);
        out.writeMap(this.fileSizes, StreamOutput::writeString, StreamOutput::writeLong);
        this.maxUnsafeAutoIdTimestamp = Math.max(maxUnsafeAutoIdTimestamp, this.maxUnsafeAutoIdTimestamp);  
            replicationStats = in.readOptionalWriteable(ReplicationStats::new);
import java.io.IOException;
        static final String INDEX_WRITER_MEMORY = "index_writer_memory";  
 */
        static final String DOC_VALUES_MEMORY = "doc_values_memory";
 * under the License.  
import org.opensearch.core.common.io.stream.Writeable;
        Map.entry("dim", "Points"),  
        static final String TERMS_MEMORY_IN_BYTES = "terms_memory_in_bytes";
     */
        static final String COUNT = "count";  
        Map.entry("dvd", "DocValues"),
    public Map<String, Long> getFileSizes() {  
     * This is used to ensure we don't add duplicate documents when we assume an append only case based on auto-generated IDs  
    public ByteSizeValue getIndexWriterMemory() {  
    }
        return new ByteSizeValue(bitsetMemoryInBytes);
        static final String STORED_FIELDS_MEMORY = "stored_fields_memory";
        return ZERO_BYTE_SIZE_VALUE;
    }  
        static final String VERSION_MAP_MEMORY_IN_BYTES = "version_map_memory_in_bytes";  
        Map.entry("liv", "Live Documents"),  
        static final String DESCRIPTION = "description";
    public ReplicationStats getReplicationStats() {  
 */  
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        addRemoteSegmentStats(mergeStats.remoteSegmentStats);  
 * the Apache License, Version 2.0 (the "License"); you may
        builder.humanReadableField(Fields.MEMORY_IN_BYTES, Fields.MEMORY, ZERO_BYTE_SIZE_VALUE);
        }
    @Override
            replicationStats = new ReplicationStats();
    private final ReplicationStats replicationStats;  
    }  
/*
    private long maxUnsafeAutoIdTimestamp = Long.MIN_VALUE;  
     * Estimation of the memory usage by index writer  
    /**  
        return maxUnsafeAutoIdTimestamp;  
