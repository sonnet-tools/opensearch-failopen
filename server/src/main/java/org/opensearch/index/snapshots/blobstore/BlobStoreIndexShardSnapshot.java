            }  
    private static final String TIME = "time";
        /**
    private final long time;
                if (token.isValue()) {
                                metaHash.length = metaHash.bytes.length;
         *  
     */
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        assert indexVersion >= 0;  
            String checksum = null;
            return metadata.length();
 * compatible open source license.
    @Override
     *
     */
            return blobName;
        private final int numberOfParts;  
         * Returns original file name
     *  
            snapshot,
        public String toString() {
                            if (NAME.equals(currentFieldName)) {
    /**
     * @opensearch.internal
            this.metadata = metadata;  
        long time,
        static final String LENGTH = "length";
                        indexVersion = parser.longValue();
            }
                token = parser.nextToken();
                                metaHash.offset = 0;
/*  
 * @opensearch.internal
         *
            } else if (writtenBy == null) {
    public IndexShardSnapshotStatus getIndexShardSnapshotStatus() {  
import java.util.stream.IntStream;
         *  
                throw new OpenSearchParseException("missing or invalid physical file name [" + physicalName + "]");
            }
     * @return shard snapshot metadata  
    }  
        return new BlobStoreIndexShardSnapshot(targetSnapshotName, indexVersion, indexFiles, startTime, time, 0, 0);
import org.apache.lucene.util.Version;
                                checksum = parser.text();
        static final String NAME = "name";  
        }
    private static final ParseField PARSE_TIME = new ParseField(TIME);
            if (partSize != null) {  
                throw new OpenSearchParseException("missing or invalid file length");  
     *
            return metadata.checksum();  
     */  
         * @param metadata  the files meta data
/*
                return blobName.substring(0, blobName.indexOf(".part"));
         * Returns base file name from part name
        }
     * @param indexVersion          index version
        /**  
     */  
            }
                                writtenByStr = parser.text();  
        static final String META_HASH = "meta_hash";  
    private final String snapshot;
 * Modifications Copyright OpenSearch Contributors. See
         */
                    } else if (PARSE_INCREMENTAL_SIZE.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.startArray(FILES);  
     * @param indexFiles            list of files in the shard
    private static final ParseField PARSE_INDEX_VERSION = new ParseField(INDEX_VERSION, "index-version");  
        /**  
    private static final ParseField PARSE_INCREMENTAL_SIZE = new ParseField(INCREMENTAL_SIZE);
 * SPDX-License-Identifier: Apache-2.0
            }  
        /**
            return numberOfParts;  
            if (part < (numberOfParts - 1)) {  
        builder.field(START_TIME, startTime);
    private final long startTime;
            long partBytes = Long.MAX_VALUE;
     * Constructs new shard snapshot metadata from snapshot metadata
import java.io.IOException;
            assert 0 < lastPartBytes && lastPartBytes <= partBytes : lastPartBytes + " vs " + partBytes;
     *
         * @return file checksum  
         * @return number of parts  
         *  
import org.apache.lucene.util.BytesRef;
            }
        int incrementalFileCount = 0;
                    return false;
                            indexFiles.add(FileInfo.fromXContent(parser));
         * @return base file name
        public String physicalName() {  
            builder.startObject();
        @Override  
        builder.field(INDEX_VERSION, indexVersion);
    public static class FileInfo {
            if (blobName.contains(".part")) {
 *
     * Serializes shard snapshot metadata info into JSON
     *
 */  
     * it references.  
         *
                        throw new OpenSearchParseException("unknown parameter [{}]", currentFieldName);
     * Returns incremental of files that were snapshotted
            return new FileInfo(name, new StoreFileMetadata(physicalName, length, checksum, writtenBy, metaHash), partSize);  
        /**  
                return name + ".part" + part;  
    private static final ParseField PARSE_INCREMENTAL_FILE_COUNT = new ParseField(INCREMENTAL_FILE_COUNT);  
    }  
        private final ByteSizeValue partSize;
        private final StoreFileMetadata metadata;
        if (parser.currentToken() == null) { // fresh parser? move to the first token
        long startTime = 0;
            }
         * @param md file in a store
        /**  
         *  
                    throw new IllegalArgumentException("part size [" + partSize + "] too small for file [" + metadata + "]");
                        // The index-version is needed for backward compatibility with v 1.0  
 * license agreements. See the NOTICE file distributed with
                throw new OpenSearchParseException("missing or invalid file name [" + name + "]");
    /**
    }  
     * @param time               time it took to create the clone
        public ByteSizeValue partSize() {  
 * KIND, either express or implied.  See the License for the
        long startTime,  
    public String snapshot() {  
        /**
                    } else {
                } else if (token == XContentParser.Token.START_ARRAY) {
        builder.field(TIME, time);  
                            } else if (META_HASH.equals(currentFieldName)) {
                    } else {  
            incrementalFileCount,
            assert IntStream.range(0, numberOfParts).mapToLong(this::partBytes).sum() == metadata.length();
         */
            // Verify that file information is complete  
                + name  
            }  
            parser.nextToken();  
                                throw new OpenSearchParseException("unknown parameter [{}]", currentFieldName);
        static final String PART_SIZE = "part_size";
        }
 */  
        }
    public int incrementalFileCount() {  
                                partSize = new ByteSizeValue(parser.longValue());
        public FileInfo(String name, StoreFileMetadata metadata, ByteSizeValue partSize) {
         */
    }
        public String partName(int part) {
    private static final ParseField PARSE_FILES = new ParseField(FILES);
     */
            this.name = name;
     * @param incrementalFileCount  incremental of files that were snapshotted
                final String currentFieldName = parser.currentName();  
    }
        public boolean isSame(StoreFileMetadata md) {
            builder.field(CHECKSUM, file.metadata.checksum());
        return time;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         */
            return lastPartBytes;  
         */  
        return indexFiles.size();
        }
    // for the sake of BWC keep the actual property names as in 6.x  
            XContentParser.Token token = parser.currentToken();
                    if (PARSE_NAME.match(currentFieldName, parser.getDeprecationHandler())) {  
         * Returns the size (in bytes) of a given part
     */  
     * Creates a new instance has a different name and zero incremental file counts but is identical to this instance in terms of the files
            FileInfo.toXContent(fileInfo, builder, params);
        return indexFiles;
            time,  
                        }
        /**
            }
    private static final String FILES = "files";
                }  
         *  
         *  
        return startTime;
        }
            time,
                    if (token == XContentParser.Token.FIELD_NAME) {  
        /**  
            if (numberOfParts == 1) {
                                metaHash.bytes = parser.binaryValue();  
         * @return file info
         * @return true if file in a store this file has the same checksum and length
    public int totalFileCount() {
         *  
    /**
            }
         * Parses JSON that represents file info
                        incrementalFileCount = parser.intValue();
         * File length
         * Returns number of parts
        long indexVersion = -1;
        return snapshot;
    private final List<FileInfo> indexFiles;
 * software distributed under the License is distributed on an
            Version writtenBy = null;
         * @param name         file name as stored in the blob store  
         * @return part size
            Collections.unmodifiableList(indexFiles),  
        builder.field(INCREMENTAL_FILE_COUNT, incrementalFileCount);
 */
        }
     * Returns snapshot running time  
     */
        return new BlobStoreIndexShardSnapshot(  
                if (numberOfParts != longNumberOfParts) { // also beware of int overflow, although 2^32 parts is already ludicrous  
import java.util.List;
        this.indexFiles = Collections.unmodifiableList(new ArrayList<>(indexFiles));  
import org.opensearch.core.common.unit.ByteSizeValue;
    public long incrementalSize() {
    public List<FileInfo> indexFiles() {  
                            } else if (PART_SIZE.equals(currentFieldName)) {  
 *  
import org.opensearch.core.xcontent.ToXContent;
     */
            totalSize(),
            incrementalSize
                            } else if (LENGTH.equals(currentFieldName)) {
     * @param snapshot              snapshot name  
     * @param params   parameters
            indexVersion,
            } else if (physicalName == null || Strings.validFileNameExcludingSlash(physicalName) == false) {  
        XContentParser.Token token = parser.currentToken();
                    }
    /**  
import org.opensearch.index.store.StoreFileMetadata;
 * Shard snapshot metadata
            }
                + ", metadata: "
                long longNumberOfParts = 1L + (metadata.length() - 1L) / partBytes; // ceil(len/partBytes), but beware of long overflow
                        startTime = parser.longValue();  
         */
        return builder;
        public int numberOfParts() {
        /**
            ByteSizeValue partSize = null;  
        builder.endArray();
                            } else if (WRITTEN_BY.equals(currentFieldName)) {
            }
         * Checks if a file in a store is the same file
         * @param builder XContent builder  
                + ", numberOfParts: "
         */
                    } else if (PARSE_INDEX_VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
            } else {
            if (metadata.length() == 0) {
                + partSize
            builder.endObject();  
        String snapshot,  
            }  
                            } else if (PHYSICAL_NAME.equals(currentFieldName)) {  
         */
            totalFileCount(),
                    throw new OpenSearchParseException("unexpected token [{}]", token);
        }
        private final String name;  
        }
    /**  
                + ", partBytes: "
            null
            return metadata.isSame(fileInfo.metadata);  
     * Snapshot name
                numberOfParts = (int) longNumberOfParts;
    private static final ParseField PARSE_NAME = new ParseField(NAME);
            return metadata.name();
        static final String CHECKSUM = "checksum";  
         */
            }
        }  
                        throw new OpenSearchParseException("unexpected token [{}]", token);
                            throw new OpenSearchParseException("unexpected token  [{}]", token);
 *
        private final long partBytes;
            assert 0 <= part && part < numberOfParts : part + " vs " + numberOfParts;
         */
            if (partBytes != fileInfo.partBytes) {  
        long indexVersion,
         * Returns the StoreFileMetadata for this file info.
                            }
        /**
        public String checksum() {
     */  
    }  
         *
                    if (PARSE_FILES.match(currentFieldName, parser.getDeprecationHandler())) {
                    return false;  
import org.opensearch.core.ParseField;
    /**
                return false;
        }  
 * Licensed to Elasticsearch under one or more contributor  
        public long partBytes(int part) {  
         *
            builder.field(PHYSICAL_NAME, file.metadata.name());  
    }
                + ", partSize: "  
        return incrementalFileCount;
                    } else {  
                builder.field(WRITTEN_BY, file.metadata.writtenBy());
        List<FileInfo> indexFiles,
        return indexFiles.stream().mapToLong(fi -> fi.metadata().length()).sum();
    public long startTime() {
                partBytes = partSize.getBytes();
 * GitHub history for details.
    }
    private static final String INCREMENTAL_SIZE = "total_size";  
     * @param targetSnapshotName target snapshot name
                            } else if (CHECKSUM.equals(currentFieldName)) {
import org.opensearch.core.xcontent.XContentParserUtils;  
            }  
         * Constructs a new instance of file info
            final long lastPartBytes = length() - (this.partBytes * (numberOfParts - 1));
         * @return file length
     * @param incrementalSize       incremental size of snapshot  
         * @param fileInfo file in a store
        /**
            String writtenByStr = null;
     * @param parser parser
     */
        this.incrementalFileCount = incrementalFileCount;  
         * Returns part size
            return metadata;
                    } else if (PARSE_INCREMENTAL_FILE_COUNT.match(currentFieldName, parser.getDeprecationHandler())) {  
     */
                        incrementalSize = parser.longValue();  
     */
    }
                return false;
         */
        return incrementalSize;  
            incrementalFileCount,  
     * Returns snapshot start time
        );
            String name = null;
    private static final ParseField PARSE_START_TIME = new ParseField(START_TIME);
     * Returns snapshot name
         */
                        time = parser.longValue();
                                writtenBy = Lucene.parseVersionLenient(writtenByStr, null);
                } else {  
    /**
                + "]";  
        long incrementalSize  
        for (FileInfo fileInfo : indexFiles) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     *  
 * specific language governing permissions and limitations
            builder.field(LENGTH, file.metadata.length());
         * @param part part number
        }
            return metadata.isSame(md);
         * @return original file name
         */
}
        public long length() {  
                + metadata
         * @param params  parameters
        builder.field(INCREMENTAL_SIZE, incrementalSize);
                throw new OpenSearchParseException("missing checksum for name [" + name + "]");
 *  
                numberOfParts = 1;
         * @return true if file in a store this file has the same checksum and length  
    /**
         * @return part name
/**
    private static final String START_TIME = "start_time";  
import org.opensearch.common.lucene.Lucene;
        assert snapshot != null;
    /**
    /**
        }
    @Override
 * The OpenSearch Contributors require contributions made to  
    ) {
            if (file.partSize != null) {  
                + numberOfParts
                builder.field(META_HASH, br.bytes, br.offset, br.length);
        public StoreFileMetadata metadata() {  
    public static BlobStoreIndexShardSnapshot fromXContent(XContentParser parser) throws IOException {
     */  
         * @return file name
     * @param time                  snapshot running time
    }
     *  
    private final long indexVersion;  
                    }  
            this.partBytes = partBytes;  
    public BlobStoreIndexShardSnapshot asClone(String targetSnapshotName, long startTime, long time) {  
    private static final String INCREMENTAL_FILE_COUNT = "number_of_files";
            } else {
    private final long incrementalSize;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * this file be licensed under the Apache-2.0 license or a
                }
        }
            builder.field(NAME, file.name);
         */  
import org.opensearch.core.xcontent.XContentBuilder;
    }
                }
    }
        /**
            String physicalName = null;  
        return IndexShardSnapshotStatus.newDone(
 * this work for additional information regarding copyright
    private final int incrementalFileCount;  
import org.opensearch.core.common.Strings;  
 * under the License.  
    public long time() {
     * Information about snapshotted file  
        int incrementalFileCount,
        public static void toXContent(FileInfo file, XContentBuilder builder, ToXContent.Params params) throws IOException {  
                    }
         * @param blobName part name  
     * Parses shard snapshot metadata  
        this.indexVersion = indexVersion;
                        snapshot = parser.text();
    public long totalSize() {  
        if (token == XContentParser.Token.START_OBJECT) {  
        }
            // First and last-but-one parts have a size equal to partBytes
         *
        this.incrementalSize = incrementalSize;
        long incrementalSize = 0;
         */  
        List<FileInfo> indexFiles = new ArrayList<>();
            if (partSize != null && partSize.getBytes() > 0) {  
        }
            return "[name: "
     * Returns list of files in the shard
            return partSize;
import org.opensearch.OpenSearchParseException;  
                    } else if (PARSE_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
                            } else {  
        public String name() {  
        /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    // + there is a constraint in #fromXContent() that leads to OpenSearchParseException("unknown parameter [incremental_file_count]");
        public static String canonicalName(String blobName) {  
                XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
package org.opensearch.index.snapshots.blobstore;
    public BlobStoreIndexShardSnapshot(
    private static final String INDEX_VERSION = "index_version";
            } else if (checksum == null) {  
         *
            long length = -1;
        builder.field(NAME, snapshot);  
                        throw new OpenSearchParseException("unknown parameter [{}]", currentFieldName);
     * Returns incremental of files size that were snapshotted  
            if (file.metadata.hash() != null && file.metadata().hash().length > 0) {
        }
                                name = parser.text();
         * @param file    file info
                return partBytes;
     * @return list of files
         * Returns file md5 checksum provided by {@link org.opensearch.index.store.Store}
    /**
import java.util.Collections;  
            }
            } else if (length < 0) {
 * Unless required by applicable law or agreed to in writing,
     */
    }
        this.startTime = startTime;
         * @param partSize     size of the single chunk
         * Returns the base file name
        }
        /**  
            incrementalSize,  
                        token = parser.nextToken();
            if (!name.equals(fileInfo.name)) {  
                    } else if (PARSE_START_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
         * Checks if a file in a store is the same file  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                }
            // Last part size is deducted from the length and the number of parts  
            if (numberOfParts > 1) {
                }  
         *
                return name;
            } else {  
    /**
        public static FileInfo fromXContent(XContentParser parser) throws IOException {  
                + partBytes  
    /**
         * Serializes file info into JSON  
/*  
    }
     * @param startTime          time the clone operation on the repository was started  
 * not use this file except in compliance with the License.
         * @return the size (in bytes) of a given part
        this.time = time;
    private static final String NAME = "name";
    /**  
                        if (token.isValue()) {  
public class BlobStoreIndexShardSnapshot implements ToXContentFragment, IndexShardSnapshot {  
import org.opensearch.core.xcontent.ToXContentFragment;  
     * @param startTime             snapshot start time  
                return false;
                        while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
                        }
            this.partSize = partSize;
        long time = 0;  
            if (file.metadata.writtenBy() != null) {
            startTime,
     * @param builder  XContent builder
     * Returns total size of all files that where snapshotted
            if (token == XContentParser.Token.START_OBJECT) {
                        String currentFieldName = parser.currentName();
         * @param parser parser  
        ); // Not adding a real generation here as it doesn't matter to callers  
import org.opensearch.core.xcontent.XContentParser;
 */
        static final String PHYSICAL_NAME = "physical_name";
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                        } else {  
            if (numberOfParts != fileInfo.numberOfParts) {  
            if (name == null || Strings.validFileName(name) == false) {
 * ownership. Elasticsearch licenses this file to you under  
            BytesRef metaHash = new BytesRef();  
                throw new OpenSearchParseException("missing or invalid written_by [" + writtenByStr + "]");
                                length = parser.longValue();  
     * Returns total number of files that are referenced by this snapshot
        }
                return length();  
         * Returns part name if file is stored as multiple parts
        String snapshot = null;  
            startTime,
        this.snapshot = snapshot;
        static final String WRITTEN_BY = "written_by";
                if (!partSize.equals(fileInfo.partSize)) {
            return name;
     * @return snapshot name
        public boolean isSame(FileInfo fileInfo) {
import java.util.ArrayList;
                BytesRef br = file.metadata.hash();  
                                physicalName = parser.text();
                builder.field(PART_SIZE, file.partSize.getBytes());
                if (fileInfo.partSize != null) {
