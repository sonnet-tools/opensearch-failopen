 */
        xContentBuilder.startObject();
        xContentBuilder.endObject();
        );
            new BlobPath().add("nxf9yv0").add("c3ejoi"),
        xContentBuilder = indexPath.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
            ex.getMessage()
 * compatible open source license.
            "{\"version\":\"1\",\"index_uuid\":\"csbdqiu8a7sdnjdks\",\"shard_count\":3,\"path_type\":\"HASHED_PREFIX\",\"path_hash_algorithm\":\"FNV_1A_BASE64\",\"path_creation_map\":{\"translog\":[\"data\",\"metadata\"],\"segments\":[\"data\",\"metadata\",\"lock_files\"]},\"paths\":[\".Cjo0F6kNjYk/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/segments/data/\",\".kpayyhxct1I/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/segments/data/\",\".p2RlgnHeIgc/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/segments/data/\",\".gkPIurBtB1w/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/segments/metadata/\",\".Y4YhlbxAB1c/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/segments/metadata/\",\".HYc8fyVPouI/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/segments/metadata/\",\".igzyZCz1ysI/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/segments/lock_files/\",\".uEluEiYmptk/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/segments/lock_files/\",\".TfAD8f06_7A/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/segments/lock_files/\",\".QqKEpasbEGs/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/translog/data/\",\".sNyoimoe1Bw/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/translog/data/\",\".d4YQtONfq50/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/translog/data/\",\".zLr4UXjK8T4/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/translog/metadata/\",\"._s8i7ZmlXGE/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/translog/metadata/\",\".tvtD3-k5ISg/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/translog/metadata/\"]}";
        xContentBuilder.endObject();
        pathCreationMap.putAll(RemoteIndexPath.TRANSLOG_PATH);
        indexPath = new RemoteIndexPath(
        );
import org.opensearch.indices.RemoteStoreSettings;
        xContentBuilder = indexPath.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
     * This checks that the remote path contains paths only for segment and data/metadata/lock_files combination.
        assertEquals(expected, xContentBuilder.toString());
    }
        IllegalArgumentException ex = assertThrows(
 *
            2,
     */
        assertEquals(expected, xContentBuilder.toString());
        assertEquals(
        );
        RemoteIndexPath indexPath = new RemoteIndexPath(
        assertEquals(expected, xContentBuilder.toString());
            remoteStoreSettings
        xContentBuilder.startObject();
            new BlobPath().add("nxf9yv0").add("c3ejoi"),
            PathHashAlgorithm.FNV_1A_BASE64,
    public void testInvalidPathCreationMap() {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            PathType.HASHED_PREFIX,
public class RemoteIndexPathTests extends OpenSearchTestCase {
            RemoteIndexPath.SEGMENT_PATH,
        assertEquals("pathCreationMap={TRANSLOG=[LOCK_FILES]} is having illegal combination of category and type", ex.getMessage());
            "{\"version\":\"1\",\"index_uuid\":\"djjsid73he8yd7usduh\",\"shard_count\":2,\"path_type\":\"HASHED_PREFIX\",\"path_hash_algorithm\":\"FNV_1A_BASE64\",\"path_creation_map\":{\"segments\":[\"data\",\"metadata\",\"lock_files\"]},\"paths\":[\"9BmBinD5HYs/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/segments/data/\",\"ExCNOD8_5ew/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/segments/data/\",\"z8wtf0yr2l4/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/segments/metadata/\",\"VheHVwFlExE/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/segments/metadata/\",\"IgFKbsDeUpQ/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/segments/lock_files/\",\"pA3gy_GZtns/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/segments/lock_files/\"]}";
package org.opensearch.index.remote;
        }
            builder.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), ".");
        xContentBuilder = indexPath.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
     * This checks that the remote path contains paths only for translog and data/metadata combination.
        );
        }
                PathHashAlgorithm.FNV_1A_BASE64,
            new BlobPath().add("djsd878ndjh").add("hcs87cj8"),
        }
     * This checks that the remote path contains paths only for translog and data/metadata combination.
    }
    public void testToXContentWithSegmentRepo() throws IOException {
        RemoteIndexPath indexPath = new RemoteIndexPath(
            2,
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(expected, xContentBuilder.toString());
        Settings.Builder builder = Settings.builder();
            "djjsid73he8yd7usduh",
    }
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        // Fixed prefix
        expected =
            PathType.HASHED_PREFIX,
import org.opensearch.core.xcontent.XContentBuilder;
            "djjsid73he8yd7usduh",
import java.util.List;
    /**
            () -> RemoteIndexPath.fromXContent(Mockito.mock(XContentParser.class))
            DefaultRemoteStoreSettings.INSTANCE
            RemoteIndexPath.TRANSLOG_PATH,
            pathCreationMap,
            PathHashAlgorithm.FNV_1A_BASE64,
 * this file be licensed under the Apache-2.0 license or a
            "djjsid73he8yd7usduh",
                2,
        xContentBuilder = indexPath.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
        xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        }
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(builder.build(), clusterSettings);
            PathHashAlgorithm.FNV_1A_BASE64,
            () -> new RemoteIndexPath(
        xContentBuilder = indexPath.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
            builder.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), ".");
import org.opensearch.indices.DefaultRemoteStoreSettings;
        IllegalArgumentException ex = assertThrows(
            DefaultRemoteStoreSettings.INSTANCE
     */
        RemoteIndexPath indexPath = new RemoteIndexPath(
                2,
            PathType.HASHED_PREFIX,
            builder.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), ".");
            pathCreationMap,
        xContentBuilder.endObject();
                remoteStoreSettings
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testRemoteIndexPathWithInvalidPathCreationMap() {
    /**
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
        xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        // Fixed prefix
        // Fixed prefix
                new HashMap<>(),
            builder.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), ".");
    public void testToXContentForBothRepos() throws IOException {
        indexPath = new RemoteIndexPath(
            "{\"version\":\"1\",\"index_uuid\":\"djjsid73he8yd7usduh\",\"shard_count\":2,\"path_type\":\"HASHED_PREFIX\",\"path_hash_algorithm\":\"FNV_1A_BASE64\",\"path_creation_map\":{\"segments\":[\"data\",\"metadata\",\"lock_files\"]},\"paths\":[\".9BmBinD5HYs/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/segments/data/\",\".ExCNOD8_5ew/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/segments/data/\",\".z8wtf0yr2l4/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/segments/metadata/\",\".VheHVwFlExE/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/segments/metadata/\",\".IgFKbsDeUpQ/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/segments/lock_files/\",\".pA3gy_GZtns/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/segments/lock_files/\"]}";
/*
        Settings settings = Settings.builder()
        xContentBuilder.endObject();
        xContentBuilder.endObject();
            PathHashAlgorithm.FNV_1A_BASE64,
            IllegalArgumentException.class,
        );
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
    public void testToXContentForTranslogRepoOnly() throws IOException {
            DefaultRemoteStoreSettings.INSTANCE
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.test.OpenSearchTestCase;
            2,
        if (randomBoolean()) {
import org.opensearch.common.blobstore.BlobPath;
                PathHashAlgorithm.FNV_1A_BASE64,
                PathType.HASHED_PREFIX,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings settings = Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), ".").build();
            PathType.HASHED_PREFIX,
                remoteStoreSettings
import org.mockito.Mockito;
 * SPDX-License-Identifier: Apache-2.0
        xContentBuilder.startObject();
            3,
                PathType.HASHED_PREFIX,
            "{\"version\":\"1\",\"index_uuid\":\"csbdqiu8a7sdnjdks\",\"shard_count\":3,\"path_type\":\"HASHED_PREFIX\",\"path_hash_algorithm\":\"FNV_1A_BASE64\",\"path_creation_map\":{\"translog\":[\"data\",\"metadata\"],\"segments\":[\"data\",\"metadata\",\"lock_files\"]},\"paths\":[\"Cjo0F6kNjYk/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/segments/data/\",\"kpayyhxct1I/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/segments/data/\",\"p2RlgnHeIgc/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/segments/data/\",\"gkPIurBtB1w/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/segments/metadata/\",\"Y4YhlbxAB1c/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/segments/metadata/\",\"HYc8fyVPouI/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/segments/metadata/\",\"igzyZCz1ysI/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/segments/lock_files/\",\"uEluEiYmptk/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/segments/lock_files/\",\"TfAD8f06_7A/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/segments/lock_files/\",\"QqKEpasbEGs/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/translog/data/\",\"sNyoimoe1Bw/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/translog/data/\",\"d4YQtONfq50/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/translog/data/\",\"zLr4UXjK8T4/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/0/translog/metadata/\",\"_s8i7ZmlXGE/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/1/translog/metadata/\",\"tvtD3-k5ISg/nxf9yv0/c3ejoi/csbdqiu8a7sdnjdks/2/translog/metadata/\"]}";
            PathType.HASHED_PREFIX,
        );
import java.io.IOException;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            3,
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), ".")
import org.opensearch.common.settings.ClusterSettings;
import java.util.HashMap;
        Settings.Builder builder = Settings.builder();
        pathCreationMap.putAll(RemoteIndexPath.SEGMENT_PATH);
            )
                new BlobPath().add("djsd878ndjh").add("hcs87cj8"),
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
                "djjsid73he8yd7usduh",
    }
        String expected =
                "djjsid73he8yd7usduh",
import org.opensearch.core.xcontent.ToXContent;
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    /**
            PathType.HASHED_PREFIX,
        Map<RemoteStoreEnums.DataCategory, List<RemoteStoreEnums.DataType>> pathCreationMap = new TreeMap<>();
 * The OpenSearch Contributors require contributions made to
        if (randomBoolean()) {
        Settings settings = Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), ".").build();
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
            )
            remoteStoreSettings
        );
            RemoteIndexPath.SEGMENT_PATH,
            2,
            remoteStoreSettings
        String expected =
        xContentBuilder = indexPath.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
            PathHashAlgorithm.FNV_1A_BASE64,
            PathHashAlgorithm.FNV_1A_BASE64,
            UnsupportedOperationException.class,
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(builder.build(), clusterSettings);
import java.util.Map;
        xContentBuilder.startObject();
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        );
            "csbdqiu8a7sdnjdks",
        assertEquals(expected, xContentBuilder.toString());
            new BlobPath().add("djsd878ndjh").add("hcs87cj8"),
            RemoteIndexPath.TRANSLOG_PATH,
        UnsupportedOperationException ex = assertThrows(
                + "basePath=[djsd878ndjh][hcs87cj8] pathType=HASHED_PREFIX pathHashAlgorithm=FNV_1A_BASE64 pathCreationMap={}",
            "csbdqiu8a7sdnjdks",
        xContentBuilder.startObject();
        xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
                new BlobPath().add("djsd878ndjh").add("hcs87cj8"),
            .build();
        if (randomBoolean()) {
     */
            IllegalArgumentException.class,
            "djjsid73he8yd7usduh",
        xContentBuilder.endObject();
            new BlobPath().add("djsd878ndjh").add("hcs87cj8"),
        String expected =
        indexPath = new RemoteIndexPath(
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        if (randomBoolean()) {
        expected =
            "Invalid input in RemoteIndexPath constructor indexUUID=djjsid73he8yd7usduh shardCount=2 "
                Map.of(TRANSLOG, List.of(LOCK_FILES)),
        assertEquals(expected, xContentBuilder.toString());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            () -> new RemoteIndexPath(
        assertEquals("RemoteIndexPath.fromXContent() is not supported", ex.getMessage());
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        );
        xContentBuilder.startObject();
    public void testFromXContent() {
            "{\"version\":\"1\",\"index_uuid\":\"djjsid73he8yd7usduh\",\"shard_count\":2,\"path_type\":\"HASHED_PREFIX\",\"path_hash_algorithm\":\"FNV_1A_BASE64\",\"path_creation_map\":{\"translog\":[\"data\",\"metadata\"]},\"paths\":[\".2EaVODaKBck/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/translog/data/\",\".dTS2VqEOUNo/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/translog/data/\",\".PVNKNGonmZw/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/translog/metadata/\",\".NXmt0Y6NjA8/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/translog/metadata/\"]}";
}
        expected =
import java.util.TreeMap;
            new BlobPath().add("djsd878ndjh").add("hcs87cj8"),
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), ".")
        );
import org.opensearch.common.settings.Settings;
            "{\"version\":\"1\",\"index_uuid\":\"djjsid73he8yd7usduh\",\"shard_count\":2,\"path_type\":\"HASHED_PREFIX\",\"path_hash_algorithm\":\"FNV_1A_BASE64\",\"path_creation_map\":{\"translog\":[\"data\",\"metadata\"]},\"paths\":[\"2EaVODaKBck/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/translog/data/\",\"dTS2VqEOUNo/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/translog/data/\",\"PVNKNGonmZw/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/0/translog/metadata/\",\"NXmt0Y6NjA8/djsd878ndjh/hcs87cj8/djjsid73he8yd7usduh/1/translog/metadata/\"]}";
