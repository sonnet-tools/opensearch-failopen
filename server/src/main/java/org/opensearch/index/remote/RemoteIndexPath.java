        return version;
    }  
    private final RemoteStoreSettings remoteStoreSettings;
            pathMap.put(entry.getKey().getName(), entry.getValue().stream().map(DataType::getName).collect(Collectors.toList()));
            throw new IllegalArgumentException(
     * This keeps the map of paths that would be present in the content of the index path file. For eg - It is possible
 * this file be licensed under the Apache-2.0 license or a
    static {
        builder.field(KEY_VERSION, version);  
import org.opensearch.index.remote.RemoteStoreEnums.DataType;
        builder.field(PathType.NAME, pathType.name());  
/**
        builder.field(KEY_SHARD_COUNT, shardCount);
                                ? remoteStoreSettings.getTranslogPathFixedPrefix()  
        RemoteStoreSettings remoteStoreSettings  
                shardCount,
        Map<DataCategory, List<DataType>> combinedPath = new HashMap<>();  
        for (Map.Entry<DataCategory, List<DataType>> entry : pathCreationMap.entrySet()) {  
            for (DataType type : entry.getValue()) {
        this.pathCreationMap = pathCreationMap;  
        int shardCount,
    static final String KEY_VERSION = "version";
import java.util.HashMap;
                    + " pathHashAlgorithm={} pathCreationMap={}",
import org.opensearch.index.remote.RemoteStorePathStrategy.ShardDataPathInput;  
        this.shardCount = shardCount;
        this.basePath = basePath;  
                }
                    .getFormattedMessage()  
        Map<DataCategory, List<DataType>> pathCreationMap,
import org.opensearch.core.xcontent.XContentParser;  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
    }
 */  
    String getVersion() {
package org.opensearch.index.remote;
        COMBINED_PATH = Collections.unmodifiableMap(combinedPath);  
    static final String KEY_PATHS = "paths";  
        PathType pathType,  
                indexUUID,  
        }
            .stream()
        }
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Objects;
    private final Map<DataCategory, List<DataType>> pathCreationMap;  
    private final Iterable<String> basePath;
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;  
        builder.startArray(KEY_PATHS);
}
        builder.field(KEY_INDEX_UUID, indexUUID);
        builder.field(KEY_PATH_CREATION_MAP);  
                            dataCategory == TRANSLOG
        builder.map(pathMap);
import org.apache.logging.log4j.message.ParameterizedMessage;
                        .indexUUID(indexUUID)  
                        .shardId(Integer.toString(shardNo))
import org.opensearch.indices.RemoteStoreSettings;
            || Objects.isNull(pathType)  
import org.opensearch.index.remote.RemoteStorePathStrategy.PathInput;
                for (int shardNo = 0; shardNo < shardCount; shardNo++) {  
import java.util.stream.Collectors;  
import org.opensearch.core.xcontent.ToXContentFragment;
        this.pathHashAlgorithm = pathHashAlgorithm;
            || pathCreationMap.isEmpty()
                basePath,
    private final int shardCount;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            throw new IllegalArgumentException(parameterizedMessage.getFormattedMessage());
                                : remoteStoreSettings.getSegmentsPathFixedPrefix()
        Map<String, List<String>> pathMap = new HashMap<>();
        builder.endArray();
    }
    public static final String DIR = "remote-index-path";  
        boolean validMap = pathCreationMap.keySet()  
    }
    /**
@ExperimentalApi
    }
 */  
            DataCategory dataCategory = entry.getKey();
            || shardCount < 1
        }  
            builder.field(PathHashAlgorithm.NAME, pathHashAlgorithm.name());
                pathCreationMap
    public static final String DEFAULT_VERSION = "1";
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;  
    public static final Map<DataCategory, List<DataType>> TRANSLOG_PATH = Map.of(TRANSLOG, List.of(DATA, METADATA));
        Iterable<String> basePath,
import static org.opensearch.index.remote.RemoteStorePathStrategy.isCompatible;  
        combinedPath.putAll(SEGMENT_PATH);
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
    public static final Map<DataCategory, List<DataType>> SEGMENT_PATH = Map.of(SEGMENTS, List.of(DataType.values()));
                        .fixedPrefix(
    private final PathType pathType;  
        PathHashAlgorithm pathHashAlgorithm,
     */
    static final String KEY_PATH_CREATION_MAP = "path_creation_map";
                        .basePath(new BlobPath().add(basePath))
import java.util.Map;
        if (validMap == false) {  
        if (Objects.isNull(pathCreationMap)
 *
                    PathInput pathInput = ShardDataPathInput.builder()
        }
        this.version = DEFAULT_VERSION;  
    private final String version;
import java.util.List;  
        if (Objects.nonNull(pathHashAlgorithm)) {
        this.indexUUID = indexUUID;
        throw new UnsupportedOperationException("RemoteIndexPath.fromXContent() is not supported");
            );  
            .allMatch(k -> pathCreationMap.get(k).stream().allMatch(k::isSupportedDataType));
public class RemoteIndexPath implements ToXContentFragment {
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
                        .dataCategory(dataCategory)
        this.remoteStoreSettings = remoteStoreSettings;
    public static final String FILE_NAME_FORMAT = "remote_path_%s";
     * key, and list of data, metadata, and lock_files (only for segment) as the value.
            || pathCreationMap.keySet().stream().anyMatch(k -> pathCreationMap.get(k).isEmpty())) {
                "Invalid input in RemoteIndexPath constructor indexUUID={} shardCount={} basePath={} pathType={}"
    public static RemoteIndexPath fromXContent(XContentParser ignored) {  
                        )
    public static final Map<DataCategory, List<DataType>> COMBINED_PATH;  
                        .dataType(type)  
 * @opensearch.internal
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
     * that segment and translog repository can be different. For this use case, we have either segment or translog as the  
 * The OpenSearch Contributors require contributions made to  
    private final PathHashAlgorithm pathHashAlgorithm;
            || Objects.isNull(basePath)  
 *
    static final String KEY_INDEX_UUID = "index_uuid";  
        String indexUUID,  
        combinedPath.putAll(TRANSLOG_PATH);
import java.util.Collections;
                        .build();  
    static final String KEY_SHARD_COUNT = "shard_count";
        this.pathType = pathType;
    @Override
    ) {
import org.opensearch.common.annotation.ExperimentalApi;
/*  
 * compatible open source license.
import java.io.IOException;  
                pathType,  
                pathHashAlgorithm,
            || isCompatible(pathType, pathHashAlgorithm) == false
                new ParameterizedMessage("pathCreationMap={} is having illegal combination of category and type", pathCreationMap)
    public RemoteIndexPath(
import org.opensearch.common.blobstore.BlobPath;  
            );
 * Remote index path information.  
            ParameterizedMessage parameterizedMessage = new ParameterizedMessage(  
                    builder.value(pathType.path(pathInput, pathHashAlgorithm).buildAsString());
        }
            }  
    private final String indexUUID;  
import org.opensearch.index.remote.RemoteStoreEnums.DataCategory;
        for (Map.Entry<DataCategory, List<DataType>> entry : pathCreationMap.entrySet()) {  
        return builder;  
