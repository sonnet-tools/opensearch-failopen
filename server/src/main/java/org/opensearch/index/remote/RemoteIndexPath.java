    public RemoteIndexPath(
import java.util.Map;
        int shardCount,
        this.basePath = basePath;
        Map<DataCategory, List<DataType>> combinedPath = new HashMap<>();
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
import org.opensearch.index.remote.RemoteStorePathStrategy.PathInput;
    private final Iterable<String> basePath;
 * compatible open source license.
        }
    static {
        builder.startArray(KEY_PATHS);
        builder.field(KEY_PATH_CREATION_MAP);
    private final String indexUUID;
 * @opensearch.internal
        }
        PathType pathType,
            throw new IllegalArgumentException(
     * that segment and translog repository can be different. For this use case, we have either segment or translog as the
        }
            }
            DataCategory dataCategory = entry.getKey();
import org.opensearch.core.xcontent.XContentParser;
        Map<DataCategory, List<DataType>> pathCreationMap,
        boolean validMap = pathCreationMap.keySet()
    private final Map<DataCategory, List<DataType>> pathCreationMap;
    public static RemoteIndexPath fromXContent(XContentParser ignored) {
/*
        Map<String, List<String>> pathMap = new HashMap<>();
public class RemoteIndexPath implements ToXContentFragment {
    static final String KEY_PATH_CREATION_MAP = "path_creation_map";
            || pathCreationMap.isEmpty()
        PathHashAlgorithm pathHashAlgorithm,
package org.opensearch.index.remote;
            .allMatch(k -> pathCreationMap.get(k).stream().allMatch(k::isSupportedDataType));
        throw new UnsupportedOperationException("RemoteIndexPath.fromXContent() is not supported");
                }
        builder.map(pathMap);
                    .getFormattedMessage()
    private final PathType pathType;
import java.util.List;
            || shardCount < 1
import org.opensearch.core.xcontent.ToXContentFragment;
        combinedPath.putAll(SEGMENT_PATH);
    public static final Map<DataCategory, List<DataType>> COMBINED_PATH;
import static org.opensearch.index.remote.RemoteStorePathStrategy.isCompatible;
        if (Objects.nonNull(pathHashAlgorithm)) {
import org.opensearch.common.blobstore.BlobPath;
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
import org.opensearch.indices.RemoteStoreSettings;
            );
        this.pathHashAlgorithm = pathHashAlgorithm;
import org.opensearch.index.remote.RemoteStoreEnums.DataCategory;
    private final RemoteStoreSettings remoteStoreSettings;
                        .basePath(new BlobPath().add(basePath))
import org.opensearch.core.xcontent.XContentBuilder;
     * This keeps the map of paths that would be present in the content of the index path file. For eg - It is possible
        combinedPath.putAll(TRANSLOG_PATH);
        this.shardCount = shardCount;
        this.remoteStoreSettings = remoteStoreSettings;
                        .build();
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
import java.io.IOException;
    ) {
/**
@ExperimentalApi
    }
 */
        return version;
        builder.field(PathType.NAME, pathType.name());
        this.pathType = pathType;
                        )
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        for (Map.Entry<DataCategory, List<DataType>> entry : pathCreationMap.entrySet()) {
    static final String KEY_VERSION = "version";
                                ? remoteStoreSettings.getTranslogPathFixedPrefix()
                        .fixedPrefix(
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
        COMBINED_PATH = Collections.unmodifiableMap(combinedPath);
                new ParameterizedMessage("pathCreationMap={} is having illegal combination of category and type", pathCreationMap)
import java.util.HashMap;
            );
    public static final String DIR = "remote-index-path";
import java.util.Collections;
                "Invalid input in RemoteIndexPath constructor indexUUID={} shardCount={} basePath={} pathType={}"
        return builder;
import org.opensearch.index.remote.RemoteStoreEnums.DataType;
 */
            pathMap.put(entry.getKey().getName(), entry.getValue().stream().map(DataType::getName).collect(Collectors.toList()));
 * The OpenSearch Contributors require contributions made to
            || isCompatible(pathType, pathHashAlgorithm) == false
 * SPDX-License-Identifier: Apache-2.0
        builder.endArray();
        }
    private final String version;
    static final String KEY_SHARD_COUNT = "shard_count";
        this.version = DEFAULT_VERSION;
        this.pathCreationMap = pathCreationMap;
                        .shardId(Integer.toString(shardNo))
import org.opensearch.index.remote.RemoteStorePathStrategy.ShardDataPathInput;
import org.apache.logging.log4j.message.ParameterizedMessage;
    static final String KEY_INDEX_UUID = "index_uuid";
        this.indexUUID = indexUUID;
        if (Objects.isNull(pathCreationMap)
import java.util.Objects;
                shardCount,
                    PathInput pathInput = ShardDataPathInput.builder()
    }
 *
    public static final String FILE_NAME_FORMAT = "remote_path_%s";
            || pathCreationMap.keySet().stream().anyMatch(k -> pathCreationMap.get(k).isEmpty())) {
    private final int shardCount;
            builder.field(PathHashAlgorithm.NAME, pathHashAlgorithm.name());
    public static final Map<DataCategory, List<DataType>> TRANSLOG_PATH = Map.of(TRANSLOG, List.of(DATA, METADATA));
            for (DataType type : entry.getValue()) {
        builder.field(KEY_INDEX_UUID, indexUUID);
        builder.field(KEY_SHARD_COUNT, shardCount);
    }
}
                pathHashAlgorithm,
import org.opensearch.common.annotation.ExperimentalApi;
                        .indexUUID(indexUUID)
                        .dataCategory(dataCategory)
    public static final String DEFAULT_VERSION = "1";
                indexUUID,
        for (Map.Entry<DataCategory, List<DataType>> entry : pathCreationMap.entrySet()) {
    static final String KEY_PATHS = "paths";
    }
                    builder.value(pathType.path(pathInput, pathHashAlgorithm).buildAsString());
        RemoteStoreSettings remoteStoreSettings
     */
                for (int shardNo = 0; shardNo < shardCount; shardNo++) {
                                : remoteStoreSettings.getSegmentsPathFixedPrefix()
 * Remote index path information.
        }
                        .dataType(type)
     * key, and list of data, metadata, and lock_files (only for segment) as the value.
 * this file be licensed under the Apache-2.0 license or a
            ParameterizedMessage parameterizedMessage = new ParameterizedMessage(
    /**
 *
        builder.field(KEY_VERSION, version);
            || Objects.isNull(basePath)
    @Override
                basePath,
    String getVersion() {
            throw new IllegalArgumentException(parameterizedMessage.getFormattedMessage());
                pathCreationMap
    public static final Map<DataCategory, List<DataType>> SEGMENT_PATH = Map.of(SEGMENTS, List.of(DataType.values()));
        if (validMap == false) {
            || Objects.isNull(pathType)
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
                pathType,
        String indexUUID,
                    + " pathHashAlgorithm={} pathCreationMap={}",
            .stream()
                            dataCategory == TRANSLOG
        Iterable<String> basePath,
    private final PathHashAlgorithm pathHashAlgorithm;
import java.util.stream.Collectors;
