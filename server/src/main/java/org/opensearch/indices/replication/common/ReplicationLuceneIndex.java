     * Metadata about a file
        }
        }
import org.opensearch.indices.recovery.RecoveryState;
        }
            sourceThrottlingInNanos += timeInNanos;  
        filesDetails.writeTo(out);
        return reused;
            FileMetadata existing = fileMetadataMap.put(name, new FileMetadata(name, length, reused));  
        for (FileMetadata file : filesDetails.values()) {  
        public Collection<FileMetadata> values() {
                total++;
    public synchronized long totalRecoverBytes() {
        public boolean isComplete() {
        }  
        static final String DETAILS = "details";
    public synchronized float recoveredBytesPercent() {
    }
            out.writeBoolean(complete);  
     * @return number of bytes still to recover, i.e. {@link ReplicationLuceneIndex#totalRecoverBytes()} minus {@link ReplicationLuceneIndex#recoveredBytes()}, or  
        }  
        return recovered;
import org.opensearch.core.common.io.stream.Writeable;  
                if (file.fullyRecovered()) {
     */
        builder.humanReadableField(Fields.RECOVERED_IN_BYTES, Fields.RECOVERED, new ByteSizeValue(recoveredBytes()));
        static final String SOURCE_THROTTLE_TIME_IN_MILLIS = "source_throttle_time_in_millis";
        int reused = 0;
     * total number of files to be recovered (potentially not yet done)
    private static final class FilesDetails implements ToXContentFragment, Writeable {
    }
        }
    }
     *  
            builder.startObject();  
        if (filesDetails.isComplete() == false) {
 * this file be licensed under the Apache-2.0 license or a
     * {@code -1} if the full set of files to recover is not yet known
        return Collections.unmodifiableList(new ArrayList<>(filesDetails.values()));
        }
        public boolean equals(Object obj) {
 *
        public String name() {
            result = 31 * result + Long.hashCode(recovered);
    public static final long UNKNOWN = -1L;
        super.reset();
    public synchronized void addFileDetail(String name, long length, boolean reused) {
            this.reused = reused;
    private long targetThrottleTimeInNanos = UNKNOWN;
        long total = 0;
            reused = in.readBoolean();  
            builder.startObject();
        static final String LENGTH_IN_BYTES = "length_in_bytes";  
            }
 * @opensearch.api
    public synchronized TimeValue targetThrottling() {
            out.writeVInt(files.length);
    }
            return result;  
            result = 31 * result + (reused ? 1 : 0);
    /**
        public void writeTo(StreamOutput out) throws IOException {  
    public synchronized FileMetadata getFileDetails(String dest) {
/**
 */  
        private long length;  
        static final String REUSED_IN_BYTES = "reused_in_bytes";
            int size = in.readVInt();  
            }  
     */
        }
        }  
        public long length() {  
            }
        for (FileMetadata file : filesDetails.values()) {
    /**
    }  
        if (total == recovered) {
    }  
                FileMetadata other = (FileMetadata) obj;  
            if (file.reused() == false) {
        if (total == recovered) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public void setComplete() {
            total += file.length();  
        }
    public synchronized void setFileDetailsComplete() {  
    }
     *
        private String name;
        }
            builder.field(Fields.NAME, name);
        long recovered = 0;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        return total;
            }
            builder.field(Fields.REUSED, reused);  
    }
 * in the replication process.  
        public FilesDetails() {}  
        public int size() {  
            float result = 100.0f * (recovered / (float) total);
            }  
    }
            return builder;
import org.opensearch.core.xcontent.ToXContentFragment;
            return builder;  
        out.writeLong(sourceThrottlingInNanos);
        } else {  
import java.io.IOException;
            return 0.0f;  
 *
    }
        for (FileMetadata file : filesDetails.values()) {  
        out.writeLong(targetThrottleTimeInNanos);  
            return fileMetadataMap.get(name);
            result = 31 * result + Long.hashCode(length);  
     * @opensearch.api
            return name;  
        builder.startObject(Fields.SIZE);
        return builder;
    /**
        }
        /**
        for (FileMetadata file : filesDetails.values()) {
        filesDetails.toXContent(builder, params);
        }
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
        int total = 0;
    public synchronized float recoveredFilesPercent() {
        private boolean reused;
        return total;
    public synchronized void addSourceThrottling(long timeInNanos) {
     */
        long total = 0L;
            if (file.reused()) {  
    }  
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(time()));
         * file name  
        builder.endObject();  
        static final String REUSED = "reused";
    public synchronized long recoveredBytes() {
            toXContent(builder, EMPTY_PARAMS);  
        }
            out.writeVLong(length);  
        sourceThrottlingInNanos = in.readLong();  
        builder.field(Fields.RECOVERED, recoveredFileCount());  
    private long sourceThrottlingInNanos = UNKNOWN;
        long total = 0;
        filesDetails.addRecoveredBytesToFile(name, bytes);
    }  
        this(new FilesDetails());
            return result;
            targetThrottleTimeInNanos = timeInNanos;  
        }
            file.addRecoveredBytes(bytes);
    /**
         * returns true if the file is reused from a local copy  
        builder.humanReadableField(Fields.SOURCE_THROTTLE_TIME_IN_MILLIS, Fields.SOURCE_THROTTLE_TIME, sourceThrottling());
            builder.humanReadableField(Fields.RECOVERED_IN_BYTES, Fields.RECOVERED, new ByteSizeValue(recovered));
        }  
        }
    @Override
     * total bytes of files to be recovered (potentially not yet done)
        }
        this.filesDetails = filesDetails;  
        /**
        int count = 0;
    }
        super.writeTo(out);  
        public boolean reused() {
            int result = name.hashCode();
        /**  
        int total = 0;  
        }
         * number of bytes recovered for this file (so far). 0 if the file is reused
        return filesDetails.size();  
            assert complete == false : "addFileDetail for [" + name + "] when file details are already complete";
import java.util.Collections;
import java.util.List;  
        try {  
        static final String SIZE = "size";
import java.util.Map;
    public synchronized void addTargetThrottling(long timeInNanos) {
 * The OpenSearch Contributors require contributions made to  
        filesDetails = new FilesDetails(in);
                builder.startArray(Fields.DETAILS);  
 * Represents the Lucene Index (set of files on a single shard) involved
     */
    }  
        /**
        }  
    }  
    /**
        return filesDetails.get(dest);  
            assert reused == false : "file is marked as reused, can't update recovered bytes";  
import java.util.Locale;
        public int hashCode() {
        return TimeValue.timeValueNanos(targetThrottleTimeInNanos);
            return 100.0f;  
            return -1L;
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
        for (FileMetadata file : filesDetails.values()) {
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
    }
            if (file.reused() == false) {  
        } else {
        static final String TARGET_THROTTLE_TIME_IN_MILLIS = "target_throttle_time_in_millis";  
         * file length
    }
            targetThrottleTimeInNanos += timeInNanos;
        if (sourceThrottlingInNanos == UNKNOWN) {  
import org.opensearch.common.annotation.PublicApi;
        @Override  
import java.util.HashMap;
            }
        static final String SOURCE_THROTTLE_TIME = "source_throttle_time";  
import org.opensearch.core.xcontent.ToXContentObject;  
            }
            }
     * percent of recovered (i.e., not reused) files out of the total files to be recovered  
                total++;
     * total number of bytes recovered so far, including both existing and reused  
        for (FileMetadata file : filesDetails.values()) {
    public synchronized int totalRecoverFiles() {  
    }  
            }
        long reused = 0;
                return name.equals(other.name) && length == other.length() && reused == other.reused() && recovered == other.recovered();
        builder.field(Fields.PERCENT, String.format(Locale.ROOT, "%1.1f%%", recoveredFilesPercent()));
        @Override  
        protected final Map<String, FileMetadata> fileMetadataMap = new HashMap<>();  
        for (FileMetadata file : filesDetails.values()) {
        public void addRecoveredBytesToFile(String name, long bytes) {
        return total;
    }
            out.writeString(name);
            if (file.reused()) {
        static final String TARGET_THROTTLE_TIME = "target_throttle_time";
     * @opensearch.internal  
        long total = 0;
            return builder.toString();
/*  
        filesDetails.setComplete();
        return TimeValue.timeValueNanos(sourceThrottlingInNanos);
            return 100.0f;
        public boolean fullyRecovered() {  
            return reused == false && length == recovered;
            return fileMetadataMap.isEmpty();
        } else {
    public synchronized XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        public long recovered() {
            if (file.reused() == false) {  
     */  
        }  
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
    public synchronized TimeValue sourceThrottling() {  
    public synchronized long totalBytes() {  
    /**
        public void clear() {
        if (total == 0 && filesDetails.size() == 0) {
            // indicates we are still in init phase
        @Override
    /**
        }  
        }
    }  
     */
    static final class Fields {
                total += file.length() - file.recovered();
     */
        }  
import org.opensearch.core.common.io.stream.StreamInput;
            return fileMetadataMap.size();
        static final String PERCENT = "percent";  
        @Override  
        return reused;
            }
        static final String TOTAL = "total";
                for (FileMetadata file : values()) {
     * Duplicates many of Field names in {@link RecoveryState}
    /**
        static final String RECOVERED = "recovered";  
                    file.toXContent(builder, params);
        }  
    }
         */
        }  
        }  
            return complete;  
    /**  
        }
        FilesDetails(StreamInput in) throws IOException {
        private long recovered;
}
    public static final class FileMetadata implements ToXContentObject, Writeable {
@PublicApi(since = "1.0.0")
        public String toString() {
            if (file.fullyRecovered()) {
                total += file.length();  
        public void addRecoveredBytes(long bytes) {
        super(in);
        builder.startObject(Fields.FILES);  
            sourceThrottlingInNanos = timeInNanos;
    @Override
        if (targetThrottleTimeInNanos == UNKNOWN) {
            final FileMetadata[] files = values().toArray(new FileMetadata[0]);
        filesDetails.addFileDetails(name, length, reused);  
     */
        if (total == 0 && filesDetails.size() == 0) {      // indicates we are still in init phase
     */
        filesDetails.clear();  
        protected boolean complete;
    /**  
            assert file != null : "file [" + name + "] hasn't been reported";  
    }  
     * number of file that were recovered (excluding on ongoing files)
        public FileMetadata(String name, long length, boolean reused) {
            this.name = name;  
            return 100.0f * recovered / total;
import java.util.ArrayList;
        return total;
            return fileMetadataMap.values();
        }  
    public synchronized List<FileMetadata> fileDetails() {  
                file.writeTo(out);
            recovered += bytes;
            builder.humanReadableField(Fields.LENGTH_IN_BYTES, Fields.LENGTH, new ByteSizeValue(length));
            return reused;  
        }  
                reused += file.length();
     */
        }  
import org.opensearch.common.xcontent.XContentFactory;  
        public FileMetadata(StreamInput in) throws IOException {
            if (obj instanceof FileMetadata) {
     */  
            return false;  
        targetThrottleTimeInNanos = UNKNOWN;
            assert bytes >= 0 : "can't recovered negative bytes. got [" + bytes + "]";
        for (FileMetadata file : filesDetails.values()) {
            for (int i = 0; i < size; i++) {
        } catch (IOException e) {  
     */  
    public synchronized long bytesStillToRecover() {  
        // stream size first, as it matters more and the files section can be long
    public synchronized int totalFileCount() {
        int recovered = 0;
        targetThrottleTimeInNanos = in.readLong();
    /**  
            length = in.readVLong();
            fileMetadataMap.clear();  
    public synchronized long reusedBytes() {
         */
            return "{ \"error\" : \"" + e.getMessage() + "\"}";
        @Override
    private final FilesDetails filesDetails;  
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        }
        for (FileMetadata file : filesDetails.values()) {
     * Details about the files
            builder.endObject();
        static final String FILES = "files";
        builder.endObject();
        builder.humanReadableField(Fields.TARGET_THROTTLE_TIME_IN_MILLIS, Fields.TARGET_THROTTLE_TIME, targetThrottling());  
            complete = true;  
    }
                recovered += file.recovered();
                count++;
            out.writeBoolean(reused);
    @Override
        }  
        builder.field(Fields.PERCENT, String.format(Locale.ROOT, "%1.1f%%", recoveredBytesPercent()));  
            name = in.readString();  
            if (file.reused() == false) {
    public ReplicationLuceneIndex(FilesDetails filesDetails) {
            this.length = length;
                reused++;
        }  
            return recovered;
        builder.field(Fields.REUSED, reusedFileCount());
     * @opensearch.internal  
        }  
            complete = false;
            }
    public synchronized void writeTo(StreamOutput out) throws IOException {
            out.writeVLong(recovered);
        static final String TOTAL_IN_BYTES = "total_in_bytes";  
     * total number of files that are part of this recovery, both re-used and recovered  
    public synchronized void reset() {
    public ReplicationLuceneIndex() {
        sourceThrottlingInNanos = UNKNOWN;
        builder.field(Fields.TOTAL, totalFileCount());
        }  
        static final String RECOVERED_IN_BYTES = "recovered_in_bytes";
package org.opensearch.indices.replication.common;
                    recovered++;  
        }
            for (FileMetadata file : files) {  
        public void addFileDetails(String name, long length, boolean reused) {
        }
        public FileMetadata get(String name) {
            if (params.paramAsBoolean("detailed", false)) {
        }
            FileMetadata file = fileMetadataMap.get(name);
            recovered += file.recovered();
    public synchronized void addRecoveredBytesToFile(String name, long bytes) {
        @Override  
        static final String NAME = "name";
    }
        static final String TOTAL_TIME = "total_time";  
            return 0.0f;
        }  
    }
    }
public final class ReplicationLuceneIndex extends ReplicationTimer implements ToXContentFragment, Writeable {
            return "file (name [" + name + "], reused [" + reused + "], length [" + length + "], recovered [" + recovered + "])";
            }  
    public ReplicationLuceneIndex(StreamInput in) throws IOException {  
     *
        builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, new ByteSizeValue(totalBytes()));  
         */
    }
     * total number of bytes in th shard
     * percent of bytes recovered out of total files bytes *to be* recovered
    /**  
    public synchronized String toString() {
            return length;
            if (file.reused() == false) {  
    public synchronized int recoveredFileCount() {
import org.opensearch.common.unit.TimeValue;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            complete = in.readBoolean();
import java.util.Collection;  
                total += file.length();
            recovered = in.readVLong();
            assert existing == null : "file [" + name + "] is already reported";
        for (FileMetadata file : filesDetails.values()) {  
        public boolean isEmpty() {
         */  
            assert name != null;
        return count;
                }  
                fileMetadataMap.put(file.name, file);  
                builder.endArray();
    public synchronized int reusedFileCount() {  
    }
        long recovered = 0;  
        @Override  
        builder.humanReadableField(Fields.REUSED_IN_BYTES, Fields.REUSED, new ByteSizeValue(reusedBytes()));
        } else {
    @PublicApi(since = "1.0.0")  
                FileMetadata file = new FileMetadata(in);
        static final String LENGTH = "length";
        }
        }  
            builder.endObject();
                }
        }
    }
