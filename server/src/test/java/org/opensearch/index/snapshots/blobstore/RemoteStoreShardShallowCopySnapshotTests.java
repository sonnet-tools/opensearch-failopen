        // with pathType=PathType.HASHED_PREFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A_COMPOSITE
            "2",
}
                    pathType = PathType.HASHED_PREFIX;
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            fileNames,
            primaryTerm,
        long time = 123;
            builder.field(RemoteStoreShardShallowCopySnapshot.INDEX_VERSION, indexVersion);
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                case 7:
        // with pathType=PathType.FIXED
            totalFileCount,
import java.util.Arrays;
            builder.endObject();
            indexUUID,
        }
            indexVersion,
            time,
            PathType.HASHED_INFIX,
            primaryTerm,
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    version = "2";
/*
            indexUUID,
            primaryTerm,
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            commitGeneration,
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
        );
            actual = builder.toString();
        );
                    commitGeneration = -Math.abs(randomLong());
            indexVersion,
                case 14:
        );
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            time,
                builder.value(fileName);
        long time = 123;
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            startTime,
            // path type and path hash algorithm in its custom data in index metadata.
            PathHashAlgorithm.FNV_1A_BASE64
                    failure = "Invalid combination of pathType=null pathHashAlgorithm=null for version=2";
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
        }
            time,
            repositoryBasePath,
                    pathType = PathType.HASHED_PREFIX;
                    version = "2";
            builder.field(RemoteStoreShardShallowCopySnapshot.REMOTE_STORE_REPOSITORY, remoteStoreRepository);
        long indexVersion = 1;
                    break;
            builder.endObject();
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            builder.field(RemoteStoreShardShallowCopySnapshot.VERSION, version);
        for (int iter = 0; iter < iters; iter++) {
            commitGeneration,
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    pathType = PathType.HASHED_INFIX;
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
            primaryTerm,
        }
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
            snapshot,
            totalSize,
                    indexVersion = -Math.abs(randomLong());
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
                case 9:
            fileNames,
            byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                    break;
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2"
            snapshot,
            startTime,
            commitGeneration,
            totalFileCount,
            builder.field(RemoteStoreShardShallowCopySnapshot.REPOSITORY_BASE_PATH, repositoryBasePath);
            String version = "1";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            null
            startTime,
            // We are handling NP check since a cluster can have indexes created earlier which do not have remote store
            snapshot,
            startTime,
            long indexVersion = 1;
            indexUUID,
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2,\"path_hash_algorithm\":0}";
                    version = "1";
                    parser.nextToken();
                case 3:
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
                    pathType = PathType.FIXED;
            indexVersion,
            repositoryBasePath,
    }
            + ",\"path_hash_algorithm\":0}";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            int totalFileCount = 5;
            PathType.HASHED_PREFIX,
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            actual = builder.toString();
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            repositoryBasePath,
            snapshot,
            startTime,
            remoteStoreRepository,
import org.opensearch.core.xcontent.XContentBuilder;
            totalSize,
        );
        );
                    failure = "Invalid Commit Generation";
                // No failures should read as usual
            time,
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
            fileNames.addAll(Arrays.asList("file1", "file2", "file3", "file4", "file5"));
                    indexUUID = null;
            snapshot,
                    break;
        );
package org.opensearch.index.snapshots.blobstore;
            String snapshot = "test-snapshot";
        final int iters = 18;
            repositoryBasePath,
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        );
            if (failure == null) {
        // Case 1 - Without remote path type fields
            builder.startObject();
                    break;
            remoteStoreRepository,
            builder.field(RemoteStoreShardShallowCopySnapshot.PRIMARY_TERM, primaryTerm);
            builder.field(RemoteStoreShardShallowCopySnapshot.NAME, snapshot);
        long commitGeneration = 5;
        // with pathType=PathType.HASHED_INFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A
            totalSize,
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            }
        }
            repositoryBasePath,
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            remoteStoreRepository,
            PathHashAlgorithm.FNV_1A_BASE64
                assertEquals(remoteStoreShardShallowCopySnapshot.getPathType(), pathType);
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            builder.endObject();
            totalFileCount,
                    version = "1";
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
import org.opensearch.common.xcontent.json.JsonXContent;
            totalFileCount,
                    break;
            indexUUID,
        long startTime = 123;
            String repositoryBasePath = "test-repo-basepath";
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
        String actual;
            primaryTerm,
        String repositoryBasePath = "test-repo-basepath";
            totalSize,
 * SPDX-License-Identifier: Apache-2.0
        );
            time,
            commitGeneration,
            builder.startObject();
            String indexUUID = "syzhajds-ashdlfj";
            commitGeneration,
                    failure = "Invalid Index Version";
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
 *
            actual = builder.toString();
            builder.endObject();
                case 15:
                    version = null;
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
        }
            time,
            snapshot,
            commitGeneration,
                    fail("Should have failed with [" + failure + "]");
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2,\"path_hash_algorithm\":1}";
            PathHashAlgorithm.FNV_1A_BASE64
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
        fileNames.addAll(Arrays.asList("file1", "file2", "file3", "file4", "file5"));
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
                assertEquals(remoteStoreShardShallowCopySnapshot.time(), time);
    public void testToXContent() throws IOException {
            remoteStoreRepository,
            fileNames,
            remoteStoreRepository,
        int totalFileCount = 5;
                case 2:
                    snapshot = null;
            indexVersion,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            "2",
                    break;
            PathHashAlgorithm.FNV_1A_COMPOSITE_1
                    RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
            "2",
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
    public void testFromXContent() throws IOException {
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        long totalSize = 5;
            startTime,
            indexVersion,
                case 16:
            + ",\"path_hash_algorithm\":1}";
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
                    version = "2";
        );
                }
            builder.startObject();
            }
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
import static org.hamcrest.Matchers.containsString;
            repositoryBasePath,
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            PathType.HASHED_PREFIX,
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
            null,
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            + ",\"path_hash_algorithm\":1}";
                case 8:
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
            long primaryTerm = 3;
            repositoryBasePath,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            commitGeneration,
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                    pathType = PathType.FIXED;
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1"
            PathHashAlgorithm pathHashAlgorithm = null;
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            builder.endArray();
                    failure = "Invalid combination of pathType=FIXED pathHashAlgorithm=null for version=1";
            totalFileCount,
        // Case 4 - with just hashed prefix type and FNV_1A_COMPOSITE hash algorithm
                    version = "2";
                    assertThat(ex.getMessage(), containsString(failure));
            String failure = null;
            indexUUID,
                assertEquals(remoteStoreShardShallowCopySnapshot.getPrimaryTerm(), primaryTerm);
                case 18:
            } else {
            snapshot,
                    break;
                    break;
                    break;
            indexUUID,
            commitGeneration,
            null,
            repositoryBasePath,
        }
            for (String fileName : fileNames) {
            builder.field(RemoteStoreShardShallowCopySnapshot.TOTAL_SIZE, totalSize);
            totalFileCount,
        }
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
                    break;
            builder.field(RemoteStoreShardShallowCopySnapshot.TIME, time);
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":0}";
 */
            builder.endObject();
            totalFileCount,
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            remoteStoreRepository,
                    break;
            totalFileCount,
import org.opensearch.core.xcontent.XContentParser;
        String indexUUID = "syzhajds-ashdlfj";
            PathHashAlgorithm.FNV_1A_BASE64
            remoteStoreRepository,
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
            indexVersion,
        );
            builder.endObject();
                    version = "1";
            totalFileCount,
                    failure = "Invalid combination of pathType=FIXED pathHashAlgorithm=FNV_1A_COMPOSITE_1 for version=2";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            "1",
            primaryTerm,
            builder.startObject();
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            startTime,
            primaryTerm,
        List<String> fileNames = new ArrayList<>(5);
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            commitGeneration,
            startTime,
            repositoryBasePath,
            totalFileCount,
            PathType.FIXED,
            fileNames,
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
                    parser.nextToken();
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
                    failure = "Invalid/Missing Snapshot Name";
                builder.field(RemoteStoreShardShallowCopySnapshot.PATH_HASH_ALGORITHM, pathHashAlgorithm.getCode());
            snapshot,
                builder.field(RemoteStoreShardShallowCopySnapshot.PATH_TYPE, pathType.getCode());
                    fail("shouldn't be here");
        }
            fileNames,
                    break;
            "1",
        String expectedXContent = "{\"version\":\"1\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            PathType.FIXED,
        }
            null
            indexUUID,
            totalSize,
                    repositoryBasePath = null;
        String remoteStoreRepository = "test-rs-repository";
            actual = builder.toString();
            indexVersion,
                    failure = "Invalid/Missing Index UUID";
            time,
            if (Objects.nonNull(pathHashAlgorithm)) {
                assertEquals(remoteStoreShardShallowCopySnapshot.getRemoteStoreRepository(), remoteStoreRepository);
            snapshot,
            actual = builder.toString();
            PathHashAlgorithm.FNV_1A_COMPOSITE_1
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;
            builder.field(RemoteStoreShardShallowCopySnapshot.TOTAL_FILE_COUNT, totalFileCount);
import java.io.IOException;
            totalFileCount,
            totalSize,
            time,
        }
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1,\"path_hash_algorithm\":1}";
            long time = 123;
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":0}";
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"]}";
                    pathType = PathType.FIXED;
            actual = builder.toString();
            null
        }
                case 11:
            builder.startObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
import java.util.Objects;
            fileNames,
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
 * The OpenSearch Contributors require contributions made to
            primaryTerm,
        // Case 3 - with just hashed prefix type and FNV_1A_BASE64 hash algorithm
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
                    break;
            builder.endObject();
            PathType.HASHED_INFIX,
                }
            time,
import java.util.List;
            indexUUID,
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            PathType.HASHED_PREFIX,
    }
            PathType.HASHED_PREFIX,
                assertEquals(remoteStoreShardShallowCopySnapshot.getPathHashAlgorithm(), pathHashAlgorithm);
            totalSize,
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
                    version = "2";
        long totalSize = 5;
            remoteStoreRepository,
            time,
            long commitGeneration = 5;
                assertEquals(remoteStoreShardShallowCopySnapshot.startTime(), startTime);
            switch (iter) {
            startTime,
            totalSize,
            primaryTerm,
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1"
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2"
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;
                    failure = "Invalid Primary Term";
        // Case 2 - with just fixed type
            repositoryBasePath,
                default:
                case 0:
            totalSize,
        // Case 5 - with just hashed infix type and FNV_1A_BASE64 hash algorithm
            long totalSize = 5;
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
    public void testFromXContentInvalid() throws IOException {
                    failure = "Invalid/Missing Repository Base Path";
        long startTime = 123;
 * this file be licensed under the Apache-2.0 license or a
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
            remoteStoreRepository,
            fileNames,
            "2",
        long primaryTerm = 3;
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        // Case 6 - with just hashed infix type and FNV_1A_COMPOSITE hash algorithm
            snapshot,
    }
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1,\"path_hash_algorithm\":0}";
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"]}";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                    failure = "Invalid combination of pathType=null pathHashAlgorithm=FNV_1A_COMPOSITE_1 for version=1";
            PathType pathType = null;
                assertEquals(remoteStoreShardShallowCopySnapshot.totalSize(), totalSize);
import java.util.ArrayList;
            null
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            snapshot,
        fileNames.addAll(Arrays.asList("file1", "file2", "file3", "file4", "file5"));
import org.opensearch.core.common.bytes.BytesReference;
                    remoteStoreRepository = null;
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            PathHashAlgorithm.FNV_1A_COMPOSITE_1
                    version = "2";
                case 5:
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
import org.opensearch.test.OpenSearchTestCase;
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
        String snapshot = "test-snapshot";
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
                    break;
            List<String> fileNames = new ArrayList<>(5);
            String remoteStoreRepository = "test-rs-repository";
public class RemoteStoreShardShallowCopySnapshotTests extends OpenSearchTestCase {
            indexVersion,
            remoteStoreRepository,
                    break;
        int totalFileCount = 5;
            builder.startObject();
        );
            snapshot,
        }
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
                    failure = "Invalid/Missing Remote Store Repository";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            if (Objects.nonNull(pathType)) {
            }
            fileNames,
            totalSize,
            primaryTerm,
            repositoryBasePath,
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
                case 12:
            indexUUID,
        String xContent = "{\"version\":\"1\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            indexUUID,
import org.opensearch.core.xcontent.ToXContent;
            primaryTerm,
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            long startTime = 123;
            builder.startArray(RemoteStoreShardShallowCopySnapshot.FILE_NAMES);
            remoteStoreRepository,
            builder.startObject();
        List<String> fileNames = new ArrayList<>(5);
            indexUUID,
                final RemoteStoreShardShallowCopySnapshot remoteStoreShardShallowCopySnapshot;
            + ",\"path_hash_algorithm\":0}";
                case 10:
            fileNames,
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
                case 17:
        String repositoryBasePath = "test-repo-basepath";
            repositoryBasePath,
            indexVersion,
                assertEquals(remoteStoreShardShallowCopySnapshot.snapshot(), snapshot);
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    primaryTerm = -Math.abs(randomLong());
            indexVersion,
            totalSize,
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            commitGeneration,
            commitGeneration,
            totalFileCount,
            remoteStoreRepository,
 * compatible open source license.
            time,
                    remoteStoreShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
                case 13:
        RemoteStoreShardShallowCopySnapshot shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            indexUUID,
            // random corruption
                    version = "2";
                    break;
        }
        String remoteStoreRepository = "test-rs-repository";
            builder.field(RemoteStoreShardShallowCopySnapshot.START_TIME, startTime);
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
                    pathType = PathType.HASHED_INFIX;
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            }
            builder.field(RemoteStoreShardShallowCopySnapshot.INDEX_UUID, indexUUID);
        // with pathType=PathType.HASHED_PREFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A
                assertEquals(remoteStoreShardShallowCopySnapshot.getCommitGeneration(), commitGeneration);
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            startTime,
                    failure = "Invalid combination of pathType=FIXED pathHashAlgorithm=FNV_1A_BASE64 for version=2";
            fileNames,
                case 1:
            fileNames,
                    break;
            indexVersion,
        String indexUUID = "syzhajds-ashdlfj";
                } catch (IllegalArgumentException ex) {
        RemoteStoreShardShallowCopySnapshot expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            PathType.HASHED_INFIX,
                    break;
            PathHashAlgorithm.FNV_1A_COMPOSITE_1
                    break;
                case 6:
                    failure = "Invalid combination of pathType=null pathHashAlgorithm=FNV_1A_BASE64 for version=1";
            indexVersion,
            startTime,
        long indexVersion = 1;
            builder.field(RemoteStoreShardShallowCopySnapshot.COMMIT_GENERATION, commitGeneration);
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
            PathType.HASHED_INFIX,
                case 4:
        // with pathType=PathType.HASHED_INFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A_COMPOSITE
            fileNames,
        String snapshot = "test-snapshot";
            startTime,
            commitGeneration,
        long primaryTerm = 3;
            primaryTerm,
        long commitGeneration = 5;
                    failure = "Invalid Version Provided";
            totalSize,
            "2",
            time,
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
