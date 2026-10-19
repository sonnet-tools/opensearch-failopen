        // with pathType=PathType.HASHED_INFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A_COMPOSITE
            long time = 123;
            builder.field(RemoteStoreShardShallowCopySnapshot.START_TIME, startTime);
        long time = 123;  
            fileNames,
            remoteStoreRepository,
        );
            PathHashAlgorithm.FNV_1A_COMPOSITE_1
            repositoryBasePath,  
                    pathType = PathType.HASHED_INFIX;  
            totalFileCount,
        long primaryTerm = 3;  
        String actual;  
            builder.endObject();  
        long primaryTerm = 3;  
            + ",\"path_hash_algorithm\":1}";  
            indexVersion,
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {  
            snapshot,
                    version = "2";
import org.opensearch.core.common.bytes.BytesReference;
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(  
        // Case 4 - with just hashed prefix type and FNV_1A_COMPOSITE hash algorithm
    public void testToXContent() throws IOException {  
            for (String fileName : fileNames) {
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2,\"path_hash_algorithm\":0}";
        );
            + ",\"path_hash_algorithm\":1}";
    }  
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        long indexVersion = 1;
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"  
            fileNames,
            primaryTerm,
            indexVersion,  
                    failure = "Invalid combination of pathType=FIXED pathHashAlgorithm=FNV_1A_BASE64 for version=2";
            PathType.FIXED,
            time,
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            indexUUID,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            fileNames,
            builder.endObject();
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
        RemoteStoreShardShallowCopySnapshot expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
import java.io.IOException;
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"  
            indexUUID,
                    failure = "Invalid combination of pathType=null pathHashAlgorithm=FNV_1A_BASE64 for version=1";
            builder.field(RemoteStoreShardShallowCopySnapshot.INDEX_UUID, indexUUID);
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
                case 0:  
                    failure = "Invalid/Missing Index UUID";  
                    indexUUID = null;
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
                builder.field(RemoteStoreShardShallowCopySnapshot.PATH_HASH_ALGORITHM, pathHashAlgorithm.getCode());  
        );
            builder.field(RemoteStoreShardShallowCopySnapshot.VERSION, version);
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(  
import static org.hamcrest.Matchers.containsString;
            indexUUID,
            builder.field(RemoteStoreShardShallowCopySnapshot.COMMIT_GENERATION, commitGeneration);
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;  
            indexUUID,  
            totalSize,  
            if (failure == null) {
        );
                    break;
            builder.field(RemoteStoreShardShallowCopySnapshot.REMOTE_STORE_REPOSITORY, remoteStoreRepository);  
                case 14:  
            startTime,
            snapshot,  
            PathType.FIXED,  
                assertEquals(remoteStoreShardShallowCopySnapshot.getPathHashAlgorithm(), pathHashAlgorithm);
 */  
        long totalSize = 5;
        );  
                    failure = "Invalid combination of pathType=null pathHashAlgorithm=FNV_1A_COMPOSITE_1 for version=1";
            if (Objects.nonNull(pathHashAlgorithm)) {
            "2",
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            PathHashAlgorithm.FNV_1A_BASE64  
                case 13:  
            null,  
        }
            PathType.HASHED_INFIX,
            indexUUID,
            repositoryBasePath,  
            }
        );
                    break;
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
            snapshot,  
            builder.startObject();
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            builder.startObject();  
                    failure = "Invalid combination of pathType=FIXED pathHashAlgorithm=null for version=1";  
            builder.startObject();
                default:
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        long time = 123;  
            startTime,
                    RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":0}";
                builder.field(RemoteStoreShardShallowCopySnapshot.PATH_TYPE, pathType.getCode());  
            fileNames,
            repositoryBasePath,  
            snapshot,
        );  
            repositoryBasePath,
                assertEquals(remoteStoreShardShallowCopySnapshot.snapshot(), snapshot);  
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
                assertEquals(remoteStoreShardShallowCopySnapshot.getCommitGeneration(), commitGeneration);
            builder.startObject();
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2"  
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
                assertEquals(remoteStoreShardShallowCopySnapshot.getPrimaryTerm(), primaryTerm);  
        }
            indexVersion,
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                case 2:
                    break;
            builder.field(RemoteStoreShardShallowCopySnapshot.NAME, snapshot);
            PathHashAlgorithm pathHashAlgorithm = null;  
            indexVersion,
            time,
            PathType.HASHED_PREFIX,
                case 10:
            indexVersion,  
    public void testFromXContent() throws IOException {  
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":0}";
            indexUUID,
 * this file be licensed under the Apache-2.0 license or a
            totalSize,
                    failure = "Invalid/Missing Remote Store Repository";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"  
            remoteStoreRepository,
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;  
                    repositoryBasePath = null;
        // Case 6 - with just hashed infix type and FNV_1A_COMPOSITE hash algorithm
        }  
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            primaryTerm,
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;  
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {  
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"]}";
                }
                case 11:
 *
                assertEquals(remoteStoreShardShallowCopySnapshot.getRemoteStoreRepository(), remoteStoreRepository);
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
            totalFileCount,  
            primaryTerm,
            startTime,
            repositoryBasePath,
            remoteStoreRepository,  
            totalSize,
            remoteStoreRepository,  
                    break;  
import org.opensearch.core.xcontent.XContentBuilder;
            }
            null  
                    pathType = PathType.HASHED_PREFIX;
            commitGeneration,  
                case 1:
                    version = "2";
            snapshot,
            String version = "1";
            indexUUID,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
                    failure = "Invalid/Missing Snapshot Name";
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
            builder.endObject();  
            snapshot,  
                case 12:
            totalFileCount,
            commitGeneration,
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"  
 * compatible open source license.
            primaryTerm,
            actual = builder.toString();  
            totalSize,
            commitGeneration,
        // with pathType=PathType.HASHED_INFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A
            primaryTerm,
                    parser.nextToken();  
            time,
            fileNames,  
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"  
            indexUUID,  
            null
                    parser.nextToken();
                    break;
                assertEquals(remoteStoreShardShallowCopySnapshot.startTime(), startTime);
        int totalFileCount = 5;
            PathType.HASHED_PREFIX,
                    failure = "Invalid Primary Term";
            "2",
            builder.startArray(RemoteStoreShardShallowCopySnapshot.FILE_NAMES);
            repositoryBasePath,
            startTime,  
        for (int iter = 0; iter < iters; iter++) {
                    break;
            "1",  
        // with pathType=PathType.HASHED_PREFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A_COMPOSITE
                    assertThat(ex.getMessage(), containsString(failure));  
            totalSize,  
        }
                    break;
            commitGeneration,  
        String expectedXContent = "{\"version\":\"1\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        RemoteStoreShardShallowCopySnapshot shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
                    break;  
            indexVersion,  
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2"
            + ",\"path_hash_algorithm\":0}";
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            fileNames,
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
                    failure = "Invalid combination of pathType=FIXED pathHashAlgorithm=FNV_1A_COMPOSITE_1 for version=2";
        long commitGeneration = 5;
            primaryTerm,  
        String snapshot = "test-snapshot";
            indexVersion,
                    break;
            PathType.HASHED_PREFIX,  
            builder.endArray();
            PathType pathType = null;
        final int iters = 18;  
                    fail("Should have failed with [" + failure + "]");
        String repositoryBasePath = "test-repo-basepath";
                    commitGeneration = -Math.abs(randomLong());  
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            primaryTerm,
            time,
            // random corruption
        long startTime = 123;
        }  
            commitGeneration,
            "2",
            actual = builder.toString();
        long indexVersion = 1;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            startTime,  
            }  
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            repositoryBasePath,
            time,
        );
        String xContent = "{\"version\":\"1\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            remoteStoreRepository,
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"  
                final RemoteStoreShardShallowCopySnapshot remoteStoreShardShallowCopySnapshot;
        }
 * The OpenSearch Contributors require contributions made to  
            + ",\"path_hash_algorithm\":0}";
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        );
            actual = builder.toString();
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;  
            fileNames.addAll(Arrays.asList("file1", "file2", "file3", "file4", "file5"));
            if (Objects.nonNull(pathType)) {
            PathHashAlgorithm.FNV_1A_BASE64
import org.opensearch.test.OpenSearchTestCase;  
            startTime,  
                    version = "1";
                    break;  
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1,\"path_hash_algorithm\":0}";
            long totalSize = 5;  
            PathHashAlgorithm.FNV_1A_BASE64  
            startTime,  
            null
            builder.field(RemoteStoreShardShallowCopySnapshot.REPOSITORY_BASE_PATH, repositoryBasePath);  
        String indexUUID = "syzhajds-ashdlfj";  
                    version = null;
            long primaryTerm = 3;
                case 7:
            // path type and path hash algorithm in its custom data in index metadata.
            totalSize,
                    break;
                    break;
            PathHashAlgorithm.FNV_1A_COMPOSITE_1  
            repositoryBasePath,  
                builder.value(fileName);  
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;
            fileNames,
        String indexUUID = "syzhajds-ashdlfj";  
                } catch (IllegalArgumentException ex) {
            builder.endObject();
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            totalSize,
    }
            actual = builder.toString();
            startTime,
            totalFileCount,  
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
            repositoryBasePath,  
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;  
            }
            long commitGeneration = 5;
            fileNames,
            actual = builder.toString();
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":2,\"path_hash_algorithm\":1}";
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);
            totalSize,  
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1,\"path_hash_algorithm\":1}";
            remoteStoreRepository,
            builder.startObject();
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(  
            builder.field(RemoteStoreShardShallowCopySnapshot.PRIMARY_TERM, primaryTerm);
            }
            commitGeneration,  
            fileNames,
        fileNames.addAll(Arrays.asList("file1", "file2", "file3", "file4", "file5"));
            repositoryBasePath,  
            time,
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_COMPOSITE_1;  
            String snapshot = "test-snapshot";
            null,
            time,
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
                    version = "1";  
                    failure = "Invalid Version Provided";  
                    version = "2";
            primaryTerm,
        String snapshot = "test-snapshot";
                assertEquals(remoteStoreShardShallowCopySnapshot.time(), time);
        // Case 1 - Without remote path type fields  
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
import org.opensearch.common.xcontent.json.JsonXContent;
                    remoteStoreShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(  
                case 16:
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(  
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
            time,
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
            null
            PathType.HASHED_PREFIX,
            remoteStoreRepository,
            PathType.HASHED_INFIX,
            String remoteStoreRepository = "test-rs-repository";
        );
package org.opensearch.index.snapshots.blobstore;
            totalFileCount,
            indexUUID,
            builder.field(RemoteStoreShardShallowCopySnapshot.INDEX_VERSION, indexVersion);  
        fileNames.addAll(Arrays.asList("file1", "file2", "file3", "file4", "file5"));
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            totalFileCount,  
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
                    pathType = PathType.FIXED;
                    pathType = PathType.HASHED_INFIX;
        String remoteStoreRepository = "test-rs-repository";
                }
                case 5:
        expectedShardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(  
            indexVersion,  
                    version = "2";  
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            primaryTerm,
                    break;  
        long totalSize = 5;
                    version = "2";  
            builder.startObject();  
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            "1",
            long startTime = 123;  
            PathHashAlgorithm.FNV_1A_BASE64  
                    version = "1";
            remoteStoreRepository,  
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            switch (iter) {
            totalSize,  
            "2",
            builder.field(RemoteStoreShardShallowCopySnapshot.TOTAL_SIZE, totalSize);
            totalFileCount,
                case 8:
                    break;  
            snapshot,
            snapshot,
                case 17:  
                    failure = "Invalid/Missing Repository Base Path";
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"  
                    break;
            builder.startObject();
                case 6:  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            primaryTerm,
                    failure = "Invalid Index Version";  
            totalFileCount,
            startTime,  
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            totalFileCount,
            fileNames,
            PathHashAlgorithm.FNV_1A_COMPOSITE_1  
/*  
            commitGeneration,  
            commitGeneration,
            indexUUID,
            byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));  
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            startTime,
            assert Objects.equals(expectedShardShallowCopySnapshot, actualShardShallowCopySnapshot);
import org.opensearch.core.xcontent.XContentParser;  
            builder.endObject();
            fileNames,
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
        String remoteStoreRepository = "test-rs-repository";
            String failure = null;  
            String repositoryBasePath = "test-repo-basepath";  
    }
        long startTime = 123;
            // We are handling NP check since a cluster can have indexes created earlier which do not have remote store  
            totalFileCount,  
            builder.endObject();
            indexVersion,
                    pathHashAlgorithm = PathHashAlgorithm.FNV_1A_BASE64;
                case 15:
            snapshot,  
            indexVersion,  
            remoteStoreRepository,
        );
import java.util.ArrayList;  
                // No failures should read as usual  
                    failure = "Invalid Commit Generation";
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"  
        assert Objects.equals(actual, expectedXContent) : "xContent is " + actual;
            commitGeneration,
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"
            "2",
                    break;
            shardShallowCopySnapshot.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                    snapshot = null;
            repositoryBasePath,
            primaryTerm,
            remoteStoreRepository,
        }
            remoteStoreRepository,  
            totalSize,  
            time,  
        // Case 3 - with just hashed prefix type and FNV_1A_BASE64 hash algorithm
            snapshot,
            PathHashAlgorithm.FNV_1A_COMPOSITE_1
        }
            indexUUID,
        // Case 2 - with just fixed type
                    break;  
            time,
import java.util.List;
            indexUUID,
            int totalFileCount = 5;
            totalSize,
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1"
        List<String> fileNames = new ArrayList<>(5);  
        }
            indexVersion,
        // with pathType=PathType.HASHED_PREFIX and pathHashAlgorithm=PathHashAlgorithm.FNV_1A
            actual = builder.toString();
            totalFileCount,
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"],\"path_type\":1"
                    failure = "Invalid combination of pathType=null pathHashAlgorithm=null for version=2";
        int totalFileCount = 5;
}
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"  
            RemoteStoreShardShallowCopySnapshot actualShardShallowCopySnapshot = RemoteStoreShardShallowCopySnapshot.fromXContent(parser);  
            repositoryBasePath,
            snapshot,
public class RemoteStoreShardShallowCopySnapshotTests extends OpenSearchTestCase {
                    pathType = PathType.HASHED_PREFIX;
            String indexUUID = "syzhajds-ashdlfj";
            totalFileCount,
        long commitGeneration = 5;
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {  
        expectedXContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"  
                    version = "2";
        }
            + "\"test-rs-repository\",\"commit_generation\":5,\"primary_term\":3,\"remote_store_repository_base_path\":"  
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            PathType.HASHED_INFIX,  
            startTime,
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
            time,  
            PathType.HASHED_INFIX,
                    pathType = PathType.FIXED;  
        String repositoryBasePath = "test-repo-basepath";
import java.util.Arrays;
            startTime,  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
                    primaryTerm = -Math.abs(randomLong());
            } else {  
        xContent = "{\"version\":\"2\",\"name\":\"test-snapshot\",\"index_version\":1,\"start_time\":123,\"time\":123,"
            commitGeneration,
            builder.field(RemoteStoreShardShallowCopySnapshot.TIME, time);
                case 9:  
                    indexVersion = -Math.abs(randomLong());
            + "\"test-repo-basepath\",\"file_names\":[\"file1\",\"file2\",\"file3\",\"file4\",\"file5\"]}";
            commitGeneration,
            builder.field(RemoteStoreShardShallowCopySnapshot.TOTAL_FILE_COUNT, totalFileCount);  
            commitGeneration,
                case 18:
            List<String> fileNames = new ArrayList<>(5);
            fileNames,  
        }  
        List<String> fileNames = new ArrayList<>(5);  
        shardShallowCopySnapshot = new RemoteStoreShardShallowCopySnapshot(
                assertEquals(remoteStoreShardShallowCopySnapshot.getPathType(), pathType);
                    break;
            time,
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
            totalSize,  
            + "\"number_of_files\":5,\"total_size\":5,\"index_uuid\":\"syzhajds-ashdlfj\",\"remote_store_repository\":"
            remoteStoreRepository,
import org.opensearch.core.xcontent.ToXContent;
    public void testFromXContentInvalid() throws IOException {
                assertEquals(remoteStoreShardShallowCopySnapshot.totalSize(), totalSize);  
            long indexVersion = 1;  
            snapshot,
        );
        // with pathType=PathType.FIXED
                    version = "2";
            builder.endObject();  
            primaryTerm,  
            indexVersion,  
        // Case 5 - with just hashed infix type and FNV_1A_BASE64 hash algorithm  
                case 4:
                    pathType = PathType.FIXED;
                    fail("shouldn't be here");
import java.util.Objects;  
 * SPDX-License-Identifier: Apache-2.0
                    break;  
        }
                    remoteStoreRepository = null;  
                case 3:  
