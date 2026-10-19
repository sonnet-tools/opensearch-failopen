            commitGeneration,
    }
            && this.totalFileCount == that.totalFileCount
            && Objects.equals(this.fileNames, that.fileNames)
        String indexUUID,
     */
            primaryTerm,
     * Returns snapshot start time
     * @param time               time it took to create the clone
    }
                    }
    }
            } else if (token == XContentParser.Token.START_ARRAY) {
 * The OpenSearch Contributors require contributions made to
    public PathHashAlgorithm getPathHashAlgorithm() {
     */
                } else if (PARSE_TOTAL_SIZE.match(currentFieldName, parser.getDeprecationHandler())) {
            repositoryBasePath,
        int totalFileCount = 0;
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
    public long getCommitGeneration() {
        long commitGeneration,
                    commitGeneration = parser.longValue();
            null
    static final String NAME = "name";
            builder.field(PATH_HASH_ALGORITHM, pathHashAlgorithm.getCode());
     * Serializes shard snapshot metadata info into JSON
        return Objects.hash(
            incrementalFileCount(),
 * @opensearch.api
            primaryTerm,
     * @return repository base path
            time,
        String snapshot = null;
     */
            indexUUID,
    public long time() {
    public String getRepositoryBasePath() {
            remoteStoreRepository,
    /**
import org.opensearch.OpenSearchParseException;
            pathHashAlgorithm
                parser.skipChildren();
        throwExceptionIfInvalid(commitGeneration < 0, "Invalid Commit Generation");
        return time;
        PathType pathType = null;
     *
        this.remoteStoreRepository = remoteStoreRepository;
            indexUUID,
    /**
        long time = 0;
        long totalSize,
    public RemoteStoreShardShallowCopySnapshot(
    private void verifyParameters(
        String version,
     * Returns shard primary Term during snapshot creation
    public long getPrimaryTerm() {
        if (obj == null || getClass() != obj.getClass()) return false;
     */
        switch (version) {
            repositoryBasePath,
     *
                pathHashAlgorithm,
        throwExceptionIfInvalid(Objects.isNull(snapshot), "Invalid/Missing Snapshot Name");
    }
                } else if (PARSE_INDEX_UUID.match(currentFieldName, parser.getDeprecationHandler())) {
            remoteStoreRepository,
    private final long commitGeneration;
     * @return shard snapshot metadata
            repositoryBasePath,
            startTime,
 * this file be licensed under the Apache-2.0 license or a
            && Objects.equals(this.pathHashAlgorithm, that.pathHashAlgorithm);
                    while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    private final List<String> fileNames;
import org.apache.logging.log4j.message.ParameterizedMessage;
    private final long time;
    }
                } else if (PARSE_REMOTE_STORE_REPOSITORY.match(currentFieldName, parser.getDeprecationHandler())) {
                    repositoryBasePath = parser.text();
     * Returns snapshot name
    private final String repositoryBasePath;
        String indexUUID,
    private final long indexVersion;
import java.util.Objects;
            pathType,
        // We are handling NP check since a cluster can have indexes created earlier which do not have remote store
        return new RemoteStoreShardShallowCopySnapshot(
    public int hashCode() {
    static final String REMOTE_STORE_REPOSITORY = "remote_store_repository";
        }
        );
    private final String snapshot;
                } else if (PARSE_REPOSITORY_BASE_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
            commitGeneration,
        if (Objects.nonNull(pathType)) {
            && Objects.equals(this.indexUUID, that.indexUUID)
    }
    /**
    private static final ParseField PARSE_FILE_NAMES = new ParseField(FILE_NAMES);
        this.indexVersion = indexVersion;
                    version = parser.text();
        ); // Not adding a real generation here as it doesn't matter to callers
     *
            startTime,
        throwExceptionIfInvalid(
    private static final ParseField PARSE_NAME = new ParseField(NAME);
        String snapshot,
            fileNames,
        );
 */
    public String getIndexUUID() {
    static final String PATH_HASH_ALGORITHM = "path_hash_algorithm";
        this.snapshot = snapshot;
        builder.field(REMOTE_STORE_REPOSITORY, remoteStoreRepository);
            remoteStoreRepository,
/*
        builder.startArray(FILE_NAMES);
            totalSize,
        );
        if (Objects.nonNull(pathType)) {
            totalFileCount,
        long startTime,
                    startTime = parser.longValue();
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
                return Objects.isNull(pathType) && Objects.isNull(pathHashAlgorithm);
    private static final ParseField PARSE_COMMIT_GENERATION = new ParseField(COMMIT_GENERATION);
            indexUUID,
            startTime,
    static final String PRIMARY_TERM = "primary_term";
            fileNames,
        }
                pathType,
            fileNames,
        return startTime;
     * Returns incremental of files that were snapshotted
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
                } else {
            && this.commitGeneration == that.commitGeneration
import java.io.IOException;
        return commitGeneration;
            indexVersion,
    private final PathHashAlgorithm pathHashAlgorithm;
                } else if (PARSE_PRIMARY_TERM.match(currentFieldName, parser.getDeprecationHandler())) {
    private final PathType pathType;
    public String snapshot() {
            totalFileCount,
@PublicApi(since = "2.9.0")
        long time,
        return Objects.equals(this.snapshot, that.snapshot)
     * @param startTime          time the clone operation on the repository was started
     *
    private static final ParseField PARSE_PRIMARY_TERM = new ParseField(PRIMARY_TERM);
        long indexVersion,
    @Override
        throwExceptionIfInvalid(Objects.isNull(version), "Invalid Version Provided");
            incrementalSize(),
    public long startTime() {
            time,
                } else if (PARSE_INDEX_VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
    public PathType getPathType() {
            totalFileCount,
     *
        RemoteStoreShardShallowCopySnapshot that = (RemoteStoreShardShallowCopySnapshot) obj;
public class RemoteStoreShardShallowCopySnapshot implements ToXContentFragment, IndexShardSnapshot {
        String remoteStoreRepository,
            && this.primaryTerm == that.primaryTerm
        List<String> fileNames,
    /**
            snapshot,
        throwExceptionIfInvalid(Objects.isNull(indexUUID), "Invalid/Missing Index UUID");
                "Invalid combination of pathType={} pathHashAlgorithm={} for version={}",
        PathType pathType,
    }
        long time,
            totalSize,
    /*
     */
}
            commitGeneration,
    static final String COMMIT_GENERATION = "commit_generation";
    static final String PATH_TYPE = "path_type";
     * @return remote store Repository Name
    public static RemoteStoreShardShallowCopySnapshot fromXContent(XContentParser parser) throws IOException {
    private void throwExceptionIfInvalid(boolean isInvalid, String exceptionStr) {
        String snapshot,
        long primaryTerm,
    public IndexShardSnapshotStatus getIndexShardSnapshotStatus() {
    }
        return new RemoteStorePathStrategy(PathType.FIXED);
     * @param parser parser
            new ParameterizedMessage(
            indexUUID,
            builder.value(fileName);
                    indexUUID = parser.text();
            snapshot,
        String remoteStoreRepository,
        return pathType;
            fileNames,
                    time = parser.longValue();
        PathType pathType,
     * Returns Index UUID
        String version = null;
        this.totalFileCount = totalFileCount;
        return primaryTerm;
        String repositoryBasePath,
     * Returns snapshot running time
            repositoryBasePath,
                    throw new OpenSearchParseException("unknown parameter [{}]", currentFieldName);
     * it references.
    private static final ParseField PARSE_TOTAL_FILE_COUNT = new ParseField(TOTAL_FILE_COUNT);
            indexVersion,
        }
    ) {
            && this.startTime == that.startTime
        long indexVersion,
        for (String fileName : fileNames) {
                } else if (PARSE_VERSION.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
            }
     * Returns total number of files that are referenced by this snapshot
    @Override
    public int incrementalFileCount() {
    /**
                if (PARSE_FILE_NAMES.match(currentFieldName, parser.getDeprecationHandler())) {
            pathHashAlgorithm
        }
            indexVersion,
        return repositoryBasePath;
        builder.field(INDEX_VERSION, indexVersion);
                    totalFileCount = parser.intValue();
        long primaryTerm,
    private static final ParseField PARSE_PATH_HASH_ALGORITHM = new ParseField(PATH_HASH_ALGORITHM);
            time,
        long startTime = 0;
                    pathType = PathType.fromCode(parser.intValue());
            && Objects.equals(this.pathType, that.pathType)
            parser.nextToken();
        if (this == obj) return true;
    public int totalFileCount() {
        int totalFileCount,
import org.opensearch.core.xcontent.XContentParser;
        String indexUUID,
            indexUUID,
        builder.field(TOTAL_FILE_COUNT, totalFileCount);
        verifyParameters(
    }
                    primaryTerm = parser.longValue();
        long startTime,
    }
        this.pathType = pathType;
        builder.field(TOTAL_SIZE, totalSize);
        long totalSize = 0;
            primaryTerm,
      @return list of files
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                    totalSize = parser.longValue();
    static final String TOTAL_SIZE = "total_size";
        return pathHashAlgorithm;
        long commitGeneration,
            version,
    static final String REPOSITORY_BASE_PATH = "remote_store_repository_base_path";
     * @param targetSnapshotName target snapshot name
        if (parser.currentToken() == null) { // fresh parser? move to the first token
            && Objects.equals(this.remoteStoreRepository, that.remoteStoreRepository)
                } else if (PARSE_START_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
                version
    }
        String remoteStoreRepository,
     * @param params   parameters
            default:
        String repositoryBasePath = null;
import org.opensearch.core.ParseField;
            primaryTerm,
            if (token == XContentParser.Token.FIELD_NAME) {
    static final String VERSION = "version";
        String remoteStoreRepository = null;
                }
        builder.endArray();
            } else {
        return remoteStoreRepository;
        long totalSize,
    private static final ParseField PARSE_VERSION = new ParseField(VERSION);
            builder.field(PATH_TYPE, pathType.getCode());
            targetSnapshotName,
    public String getRemoteStoreRepository() {
        builder.field(TIME, time);
            time,
        return 0;
                }
        }
     */
     *
        this.primaryTerm = primaryTerm;
            && this.indexVersion == that.indexVersion
            commitGeneration,
    ) {
    /**
import org.opensearch.index.remote.RemoteStorePathStrategy;
            throw new IllegalArgumentException(exceptionStr);
    private static final ParseField PARSE_INDEX_UUID = new ParseField(INDEX_UUID);
            repositoryBasePath,
    private final long totalSize;
                    snapshot = parser.text();
    static final String FILE_NAMES = "file_names";
            isValidRemotePathConfiguration(version, pathType, pathHashAlgorithm) == false,
            ).getFormattedMessage()
            time,
            pathType,
import java.util.List;
                } else if (PARSE_COMMIT_GENERATION.match(currentFieldName, parser.getDeprecationHandler())) {
     * Returns Remote Store Repository Base Path
/**
        long indexVersion,
    static final String START_TIME = "start_time";
        long indexVersion = -1;
    public long incrementalSize() {
     * Returns incremental of files size that were snapshotted
    static final String TIME = "time";
            version,
        return builder;
     */
            startTime,
            snapshot,
        String currentFieldName = parser.currentName();
        return totalSize;
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.field(START_TIME, startTime);
        PathHashAlgorithm pathHashAlgorithm
        long primaryTerm = -1;
    }
    /**
        );
        this.time = time;
        PathType pathType,
        String indexUUID = null;
            && this.time == that.time
 *
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
package org.opensearch.index.snapshots.blobstore;
                } else if (PARSE_PATH_TYPE.match(currentFieldName, parser.getDeprecationHandler())) {
            commitGeneration,
 * SPDX-License-Identifier: Apache-2.0
     */
        this.version = version;
        throwExceptionIfInvalid(Objects.isNull(repositoryBasePath), "Invalid/Missing Repository Base Path");
        List<String> fileNames,
 */
        return snapshot;
    }
    private final String remoteStoreRepository;
    private static final ParseField PARSE_TIME = new ParseField(TIME);
     */
    }
    }
    ) {
        long commitGeneration = -1;
    private final long startTime;
        throwExceptionIfInvalid(primaryTerm < 0, "Invalid Primary Term");
            pathType,
        this.indexUUID = indexUUID;
        int totalFileCount,
            totalSize,
     * Returns Remote Store Repository Name
    private final long primaryTerm;
        XContentParser.Token token;
     * @return commit Generation
    private boolean isValidRemotePathConfiguration(String version, PathType pathType, PathHashAlgorithm pathHashAlgorithm) {
    private static final ParseField PARSE_REMOTE_STORE_REPOSITORY = new ParseField(REMOTE_STORE_REPOSITORY);
        throwExceptionIfInvalid(indexVersion < 0, "Invalid Index Version");
    public boolean equals(Object obj) {
    }
    private static final ParseField PARSE_REPOSITORY_BASE_PATH = new ParseField(REPOSITORY_BASE_PATH);
     */
            pathType,
        builder.field(INDEX_UUID, indexUUID);
     * Parses shard snapshot metadata
    RemoteStoreShardShallowCopySnapshot(
    static final String TOTAL_FILE_COUNT = "number_of_files";
            totalFileCount,
                        fileNames.add(parser.text());
        builder.field(REPOSITORY_BASE_PATH, repositoryBasePath);
    public RemoteStorePathStrategy getRemoteStorePathStrategy() {
        PathHashAlgorithm pathHashAlgorithm
    }
    }
        this.repositoryBasePath = repositoryBasePath;
                if (PARSE_NAME.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.field(COMMIT_GENERATION, commitGeneration);
     *
            && this.totalSize == that.totalSize
            totalSize,
    @Override
        return new RemoteStoreShardShallowCopySnapshot(
    private final String indexUUID;
        long commitGeneration,
                } else if (PARSE_PATH_HASH_ALGORITHM.match(currentFieldName, parser.getDeprecationHandler())) {
     *
     */
            indexVersion,
    /**
      Returns list of files in the shard
    private static final ParseField PARSE_INDEX_VERSION = new ParseField(INDEX_VERSION, "index-version");
        PathHashAlgorithm pathHashAlgorithm = null;
            } else if (token.isValue()) {
        return IndexShardSnapshotStatus.newDone(
        }
     * Returns total size of all files that where snapshotted
    /**
            && Objects.equals(this.version, that.version)
        builder.field(PRIMARY_TERM, primaryTerm);
    private final String version;
                    indexVersion = parser.longValue();
        this.commitGeneration = commitGeneration;
     * Creates a new instance which has a different name and zero incremental file counts but is identical to this instance in terms of the files
        return indexUUID;
                    remoteStoreRepository = parser.text();
        if (Objects.nonNull(pathHashAlgorithm)) {
    }
     *
            DEFAULT_VERSION,
            snapshot,
        this.startTime = startTime;
    public long totalSize() {
                } else if (PARSE_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        }
            indexVersion,
     * @return index UUID
    private static final ParseField PARSE_START_TIME = new ParseField(START_TIME);
            pathHashAlgorithm
    static final String DEFAULT_VERSION = "2";
    }
            startTime,
     * Returns snapshot commit generation
    /**
                currentFieldName = parser.currentName();
    /**
    }
            && Objects.equals(this.repositoryBasePath, that.repositoryBasePath)
        }
        // path type and path hash algorithm in its custom data in index metadata.
    private static final ParseField PARSE_TOTAL_SIZE = new ParseField(TOTAL_SIZE);
    }
        return 0;
 * Remote Store based Shard snapshot metadata
import java.util.ArrayList;
    }
            return new RemoteStorePathStrategy(pathType, pathHashAlgorithm);
            remoteStoreRepository,
        this.fileNames = fileNames;
                } else if (PARSE_TOTAL_FILE_COUNT.match(currentFieldName, parser.getDeprecationHandler())) {
        if (isInvalid) {
                } else {
        String snapshot,
    private final int totalFileCount;
     * @param builder  XContent builder
        return totalFileCount;
        String repositoryBasePath,
        throwExceptionIfInvalid(Objects.isNull(remoteStoreRepository), "Invalid/Missing Remote Store Repository");
        builder.field(NAME, snapshot);
            version,
    /**
        );
        String repositoryBasePath,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            pathHashAlgorithm
    static final String INDEX_UUID = "index_uuid";
        long primaryTerm,
        String version,
                return false;
                return Objects.nonNull(pathType) && RemoteStorePathStrategy.isCompatible(pathType, pathHashAlgorithm);
        List<String> fileNames = new ArrayList<>();
import org.opensearch.common.annotation.PublicApi;
    }
                    parser.skipChildren();
            case "2":
    static final String INDEX_VERSION = "index_version";
            remoteStoreRepository,
        this.pathHashAlgorithm = pathHashAlgorithm;
    public RemoteStoreShardShallowCopySnapshot asClone(String targetSnapshotName, long startTime, long time) {
            pathHashAlgorithm
     */
        );
     * @return primary Term
    @Override
        this(
            totalFileCount,
    /**
            primaryTerm,
    }
 *
            pathType,
     */
        PathHashAlgorithm pathHashAlgorithm
        builder.field(VERSION, version);
        this.totalSize = totalSize;
    private static final ParseField PARSE_PATH_TYPE = new ParseField(PATH_TYPE);
            totalSize,
     */
                    pathHashAlgorithm = PathHashAlgorithm.fromCode(parser.intValue());
     */
     * @return snapshot name
            case "1":
    /**
