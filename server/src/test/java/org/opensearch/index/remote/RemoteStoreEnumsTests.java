            .dataType(dataType)
        expected = "snap_yFiSl_VGGM/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/indices/dsdkjsu8832njn/10/";
                        dataCategory.getName(),
            result.buildAsString()
            .basePath(blobPath)
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.parseString;
            .fixedPrefix(fixedPrefix)
        expected = derivePath(basePath, pathInput, fixedPrefix);
            .dataCategory(dataCategory)
            ".o00101001010011/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/translog/metadata/",
            .dataType(dataType)
            : String.join(
    }
        List<String> pathList = getPathList();
            .build();
        String p = String.join(SEPARATOR, pathList);
        DataCategory dataCategory = TRANSLOG;
            .indexUUID(fixedIndexUUID)
        String basePath = getPath(pathList);
            .indexUUID(indexUUID)
            .fixedPrefix(fixedPrefix)
        pathInput = ShardDataPathInput.builder()
                pathInput.shardId(),
            .build();
            .shardId(fixedShardId)
        List<String> pathList = getPathList();
            .shardId(shardId)
            .basePath(blobPath)
            .basePath(fixedBlobPath)
            blobPath = blobPath.add(path);
                        SEPARATOR,
        pathInput = ShardDataPathInput.builder()
                    )
        assertEquals(".oKU5SjILiy4/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/translog/metadata/", result.buildAsString());
            .build();
            .dataCategory(dataCategory)
                        basePath,
            .shardId(shardId)
        for (String path : pathList) {
        String fixedIndexUUID = "k2ijhe877d7yuhx7";
            .shardId(fixedShardId)
            .shardId(fixedShardId)
        );
            .dataCategory(dataCategory)
            .dataCategory(dataCategory)
                pathInput.dataType().getName()
        String actual = result.buildAsString();
        dataType = LOCK_FILES;
package org.opensearch.index.remote;
        pathInput = ShardDataPathInput.builder()
        dataType = DATA;
            .dataType(dataType)
                    String.join(
                        SEPARATOR,
        // assert with exact value for known base path
        // Translog Metadata
                SEPARATOR,
    public void testGeneratePathForHashedInfixType() {
        dataType = METADATA;
                        SEPARATOR,
        }
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
            .basePath(blobPath)
                        basePath,
                        dataCategory.getName(),
        assertTrue(
            result.buildAsString()
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
            .basePath(fixedBlobPath)
            .shardId(shardId)
    }
                        SEPARATOR,
            .dataType(dataType)
    private static final String SEPARATOR = "/";
        // FIXED PATH
        // Segment Metadata
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
        pathInput = ShardDataPathInput.builder()
            .fixedPrefix(fixedPrefix)
            .fixedPrefix(fixedPrefix)
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
            .basePath(blobPath)
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
            .fixedPrefix(fixedPrefix)
            .basePath(blobPath)
        assertTrue(
    public void testGeneratePathForHashedPrefixType() {
        actual = result.buildAsString();
        String basePath = getPath(pathList) + indexUUID + SEPARATOR + shardId;
        assertEquals(basePath + dataCategory.getName() + SEPARATOR + dataType.getName() + SEPARATOR, result.buildAsString());
        DataType dataType = DATA;
        if (p.isEmpty() || p.endsWith(SEPARATOR)) {
        dataType = LOCK_FILES;
            .build();
            .dataCategory(dataCategory)
        BlobPath result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
        assertTrue(
        );
        pathInput = ShardDataPathInput.builder()
            .shardId(shardId)
        }
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/.oKU5SjILiy4/k2ijhe877d7yuhx7/10/translog/metadata/";
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
            .dataCategory(dataCategory)
        SnapshotShardPathInput pathInput = SnapshotShardPathInput.builder()
            .indexUUID(indexUUID)
            .dataType(dataType)
        typeString = PathType.HASHED_PREFIX.toString();
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
                    String.join(
        for (String path : pathList) {
            .shardId(shardId)
            .basePath(fixedBlobPath)
import org.opensearch.index.remote.RemoteStoreEnums.DataCategory;
            .indexUUID(indexUUID)
        }
            .shardId(shardId)
            .build();
        pathInput = ShardDataPathInput.builder()
            .dataType(dataType)
            .basePath(fixedBlobPath)
        actual = result.buildAsString();
            .dataType(dataType)
        // Segment Lockfiles
            .build();
        String fixedPrefix = ".";
        String fixedIndexUUID = "k2ijhe877d7yuhx7";
import java.util.ArrayList;
            .indexUUID(indexUUID)
            .basePath(blobPath)
        result = HASHED_INFIX.path(pathInput, FNV_1A_COMPOSITE_1);
        String basePath = getPath(pathList) + indexUUID + SEPARATOR + shardId;
            .build();
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
        assertTrue(
        result = FIXED.path(pathInput, null);
            .shardId(fixedShardId)
            .indexUUID(fixedIndexUUID)
            .dataType(dataType)
        assertTrue(
            .shardId(fixedShardId)
                    )
        );
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_INFIX;
        assertEquals(basePath + dataCategory.getName() + SEPARATOR + dataType.getName() + SEPARATOR, result.buildAsString());
                    )
        pathInput = ShardDataPathInput.builder()
            .dataCategory(dataCategory)
        pathInput = ShardDataPathInput.builder()
                    )
            .indexUUID(indexUUID)
            .dataCategory(dataCategory)
            .indexUUID(indexUUID)
    private String derivePath(String basePath, ShardDataPathInput pathInput, String fixedPrefix) {
        dataType = DATA;
            .dataCategory(dataCategory)
        BlobPath blobPath = new BlobPath();
        String shardId = String.valueOf(randomInt(100));
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/snap_yFiSl_VGGM/indices/dsdkjsu8832njn/10/";
        // assert with exact value for known base path
            .fixedPrefix(fixedPrefix)
            .shardId(fixedShardId)
            .dataCategory(dataCategory)
        String fixedPrefix = ".";
        // Segment Data
            );
                        fixedPrefix + FNV_1A_COMPOSITE_1.hash(pathInput),
            .dataType(dataType)
            .dataType(dataType)
            .shardId(fixedShardId)
        BlobPath fixedBlobPath = BlobPath.cleanPath().add("xjsdhj").add("ddjsha").add("yudy7sd").add("32hdhua7").add("89jdij");
                        fixedPrefix + FNV_1A_BASE64.hash(pathInput),
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1;
        String fixedIndexUUID = "k2ijhe877d7yuhx7";
            .build();
            .indexUUID(fixedIndexUUID)
        assertEquals(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual, expected);
                .startsWith(
            .shardId(fixedShardId)
        pathInput = ShardDataPathInput.builder()
            .dataType(dataType)
            .build();
        pathInput = ShardDataPathInput.builder()
        // Segment Data
        pathInput = ShardDataPathInput.builder()
                pathInput.shardId(),
                )
        pathInput = ShardDataPathInput.builder()
            .fixedPrefix(fixedPrefix)
                )
                )
            .build();
            .dataType(dataType)
 * this file be licensed under the Apache-2.0 license or a
                        SEPARATOR,
            result.buildAsString()
                .startsWith(
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
        assertEquals(PathType.HASHED_PREFIX, type);
        dataType = METADATA;
            .shardId(fixedShardId)
        pathInput = ShardDataPathInput.builder()
                        fixedPrefix + FNV_1A_COMPOSITE_1.hash(pathInput),
            .indexUUID(fixedIndexUUID)
        // assert with exact value for known base path
        assertTrue(
            .shardId(fixedShardId)
            .dataCategory(dataCategory)
            .basePath(blobPath)
            ? String.join(
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/.AUBRfCIuWdk/k2ijhe877d7yuhx7/10/segments/data/";
            .indexUUID(indexUUID)
            .dataType(dataType)
            .basePath(blobPath)
            .build();
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
            .dataType(dataType)
            .shardId(fixedShardId)
        String indexUUID = randomAlphaOfLength(10);
            .fixedPrefix(fixedPrefix)
            .indexUUID(fixedIndexUUID)
            .build();
        assertEquals(FIXED, type);
                pathInput.indexUUID(),
            result.buildAsString()
                )
            ".K01111001100000/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/segments/lock_files/",
            .fixedPrefix(fixedPrefix)
import org.opensearch.index.remote.RemoteStorePathStrategy.ShardDataPathInput;
            .dataCategory(dataCategory)
        pathInput = ShardDataPathInput.builder()
 * The OpenSearch Contributors require contributions made to
        // HASHED_INFIX - FNV_1A_BASE64
        BlobPath blobPath = new BlobPath();
                        dataType.getName()
                        fixedPrefix + FNV_1A_BASE64.hash(pathInput),
            .dataCategory(dataCategory)
            .indexUUID(fixedIndexUUID)
            result.buildAsString()
            .basePath(blobPath)
            .fixedPrefix(fixedPrefix)
                )
        actual = result.buildAsString();
                        dataType.getName()
            .build();
        String fixedPrefix = "snap";
            .basePath(fixedBlobPath)
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
            .shardId(shardId)
        BlobPath result = FIXED.path(pathInput, null);
            .fixedPrefix(fixedPrefix)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
            .basePath(fixedBlobPath)
            .build();
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
                        dataCategory.getName(),
        String shardId = String.valueOf(randomInt(100));
            .indexUUID(indexUUID)
        ShardDataPathInput pathInput = ShardDataPathInput.builder()
        return pathList;
import org.opensearch.test.OpenSearchTestCase;
            .basePath(fixedBlobPath)
        DataType dataType = DATA;
            .shardId(shardId)
        assertEquals("Could not parse PathType for [" + randomTypeString + "]", ex.getMessage());
            .shardId(shardId)
            .basePath(fixedBlobPath)
            .fixedPrefix(fixedPrefix)
        expected = derivePath(basePath, pathInput, fixedPrefix);
        pathInput = ShardDataPathInput.builder()
                        dataType.getName()
        // assert with exact value for known base path
        );
            .dataCategory(dataCategory)
        );
        String randomTypeString = randomAlphaOfLength(2);
        type = parseString(randomFrom(typeString, typeString.toLowerCase(Locale.ROOT)));
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
            .build();
            .build();
        dataType = METADATA;
            .shardId(shardId)
                    )
        ShardDataPathInput pathInput = ShardDataPathInput.builder()
            .basePath(fixedBlobPath)
                )
                        dataType.getName()
                        fixedPrefix + FNV_1A_COMPOSITE_1.hash(pathInput),
            .indexUUID(indexUUID)
            .dataType(dataType)
        dataCategory = SEGMENTS;
            .indexUUID(indexUUID)
        DataType dataType = DATA;
            .dataType(dataType)
            .build();
        // Translog Data
    }
            .shardId(shardId)
        }
            .basePath(blobPath)
            .indexUUID(fixedIndexUUID)
            .indexUUID(indexUUID)
                        SEPARATOR,
    }
            .build();
        actual = result.buildAsString();
                .startsWith(
                        basePath,
            blobPath = blobPath.add(path);
            .dataCategory(dataCategory)
            .build();
        pathInput = ShardDataPathInput.builder()
                        SEPARATOR,
            .dataCategory(dataCategory)
            .dataType(dataType)
public class RemoteStoreEnumsTests extends OpenSearchTestCase {
        PathType type = parseString(randomFrom(typeString, typeString.toLowerCase(Locale.ROOT)));
            .shardId(shardId)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/snap_11001000010110/indices/dsdkjsu8832njn/10/";
            .dataCategory(dataCategory)
        pathInput = ShardDataPathInput.builder()
            .build();
        // assert with exact value for known base path
            .build();
/*
        String expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/indices/dsdkjsu8832njn/10/";
            .dataCategory(dataCategory)
        result = FIXED.path(pathInput, null);
            .basePath(fixedBlobPath)
                        dataType.getName()
            .basePath(blobPath)
            .fixedPrefix(fixedPrefix)
            .fixedPrefix(fixedPrefix)
            .indexUUID(fixedIndexUUID)
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/.DgSI70IciXs/k2ijhe877d7yuhx7/10/translog/data/";
            .dataType(dataType)
        assertEquals("Could not parse PathType for [null]", ex.getMessage());
            .indexUUID(indexUUID)
        dataType = METADATA;
            .indexUUID(indexUUID)
        BlobPath fixedBlobPath = BlobPath.cleanPath().add("xjsdhj").add("ddjsha").add("yudy7sd").add("32hdhua7").add("89jdij");
        for (String path : pathList) {
        BlobPath blobPath = BlobPath.cleanPath().add("xjsdhj").add("ddjsha").add("yudy7sd").add("32hdhua7").add("89jdij");
        assertEquals(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual, expected);
            result.buildAsString()
            .basePath(blobPath)
            .shardId(shardId)
            .fixedPrefix(fixedPrefix)
    }
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        expected = derivePath(basePath, pathInput, fixedPrefix);
                pathInput.dataType().getName()
        );
        // Segment Metadata
        }
            .basePath(fixedBlobPath)
            .shardId(shardId)
            .fixedPrefix(fixedPrefix)
        // Segment Data
        pathInput = ShardDataPathInput.builder()
        dataType = LOCK_FILES;
            result.buildAsString()
                        fixedPrefix + FNV_1A_COMPOSITE_1.hash(pathInput),
        ShardDataPathInput pathInput = ShardDataPathInput.builder()
                        SEPARATOR,
        assertEquals(basePath + dataCategory.getName() + SEPARATOR + dataType.getName() + SEPARATOR, result.buildAsString());
        actual = result.buildAsString();
            .build();
        return p + SEPARATOR;
                    )
            result.buildAsString()
                        SEPARATOR,
            .indexUUID(fixedIndexUUID)
                    String.join(
            .build();
        assertEquals(".AUBRfCIuWdk/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/segments/data/", result.buildAsString());
                        dataCategory.getName(),
            .basePath(blobPath)
        assertEquals(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual, expected);
                        basePath,
            .dataType(dataType)
            result.buildAsString()
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
        pathInput = ShardDataPathInput.builder()
            .indexUUID(fixedIndexUUID)
        for (int i = 0; i < length; i++) {
        pathInput = ShardDataPathInput.builder()
            .basePath(blobPath)
        // Case 1 - Pass values from the enum.
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/.KeYDIk0mJXI/k2ijhe877d7yuhx7/10/segments/lock_files/";
        pathInput = ShardDataPathInput.builder()
        // Translog Data
        BlobPath blobPath = new BlobPath();
            .shardId(shardId)
            .indexUUID(indexUUID)
import java.util.Locale;
 * compatible open source license.
        String typeString = FIXED.toString();
                    )
                        basePath,
            .dataCategory(dataCategory)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
        assertEquals(".D10000001001000/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/translog/data/", result.buildAsString());
import org.opensearch.common.blobstore.BlobPath;
            .fixedPrefix(fixedPrefix)
            result.buildAsString()
            .build();
        DataCategory dataCategory = TRANSLOG;
            .fixedPrefix(fixedPrefix)
        String fixedShardId = "10";
        assertTrue(
        pathInput = ShardDataPathInput.builder()
            blobPath = blobPath.add(path);
 * SPDX-License-Identifier: Apache-2.0
    public void testGeneratePathForHashedPrefixTypeAndFNVCompositeHashAlgorithm() {
            .basePath(fixedBlobPath)
                .startsWith(
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        // assert with exact value for known base path
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
                .startsWith(
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
            .fixedPrefix(fixedPrefix)
        String indexUUID = randomAlphaOfLength(10);
        dataType = METADATA;
        assertEquals(
            .dataCategory(dataCategory)
        assertEquals(".A01010000000101/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/segments/data/", result.buildAsString());
        BlobPath fixedBlobPath = BlobPath.cleanPath().add("xjsdhj").add("ddjsha").add("yudy7sd").add("32hdhua7").add("89jdij");
            .indexUUID(fixedIndexUUID)
            .dataType(dataType)
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
        dataCategory = SEGMENTS;
            .shardId(fixedShardId)
            .fixedPrefix(fixedPrefix)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
        assertEquals(".KeYDIk0mJXI/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/segments/lock_files/", result.buildAsString());
        // Segment Metadata
                    String.join(
            .fixedPrefix(fixedPrefix)
                        SEPARATOR,
            .dataCategory(dataCategory)
import org.opensearch.index.remote.RemoteStorePathStrategy.SnapshotShardPathInput;
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
        expected = "snap_11001000010110/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/indices/dsdkjsu8832njn/10/";
            .dataCategory(dataCategory)
        // assert with exact value for known base path
                )
        // HASHED_INFIX - FNV_1A_COMPOSITE_1
        String fixedPrefix = ".";
            .dataType(dataType)
                    )
        ShardDataPathInput pathInput = ShardDataPathInput.builder()
        dataType = METADATA;
            blobPath = blobPath.add(path);
        actual = result.buildAsString();
        // assert with exact value for known base path
            .dataCategory(dataCategory)
        assertEquals(basePath + dataCategory.getName() + SEPARATOR + dataType.getName() + SEPARATOR, result.buildAsString());
    }
        BlobPath result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
            .fixedPrefix(fixedPrefix)
            .indexUUID(indexUUID)
        dataType = LOCK_FILES;
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
                pathInput.dataCategory().getName(),
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        String fixedShardId = "10";
        actual = result.buildAsString();
            .indexUUID(fixedIndexUUID)
            .fixedPrefix(fixedPrefix)
            .dataType(dataType)
            .indexUUID(indexUUID)
            .dataCategory(dataCategory)
        String fixedShardId = "10";
            pathList.add(randomAlphaOfLength(randomIntBetween(2, 5)));
import org.apache.logging.log4j.message.ParameterizedMessage;
        String indexUUID = randomAlphaOfLength(10);
        // Translog Data
            .build();
            .basePath(fixedBlobPath)
        );
            .indexUUID(indexUUID)
        assertEquals(basePath + dataCategory.getName() + SEPARATOR + dataType.getName() + SEPARATOR, result.buildAsString());
    }
                    String.join(
            .basePath(blobPath)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        dataType = DATA;
                        basePath,
 *
            .dataCategory(dataCategory)
            .basePath(blobPath)
        List<String> pathList = getPathList();
        BlobPath result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        actual = result.buildAsString();
import java.util.List;
            .fixedPrefix(fixedPrefix)
                        fixedPrefix + FNV_1A_BASE64.hash(pathInput),
            .basePath(blobPath)
        // assert with exact value for known base path
        assertEquals(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual, expected);
            .dataType(dataType)
        dataType = DATA;
        // assert with exact value for known base path
        pathInput = ShardDataPathInput.builder()
        actual = result.buildAsString();
        for (String path : pathList) {
            .build();
        dataCategory = SEGMENTS;
        String indexUUID = randomAlphaOfLength(10);
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED;
    }
            .dataType(dataType)
            .basePath(blobPath)
        );
    }
        DataType dataType = DATA;
            .shardId(shardId)
            .dataType(dataType)
import org.opensearch.index.remote.RemoteStoreEnums.DataType;
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
            .shardId(shardId)
        );
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
            .dataCategory(dataCategory)
        // Segment Metadata
                    String.join(
            .shardId(fixedShardId)
            .build();
        DataCategory dataCategory = TRANSLOG;
            .fixedPrefix(fixedPrefix)
        // Translog Data
            .dataType(dataType)
            .basePath(fixedBlobPath)
            .dataCategory(dataCategory)
            .dataType(dataType)
                        dataCategory.getName(),
                SEPARATOR,
            .shardId(shardId)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
            result.buildAsString()
            .basePath(fixedBlobPath)
                        basePath,
            .dataCategory(dataCategory)
        // Case 2 - Pass random string
        BlobPath result = FIXED.path(pathInput, null);
        // HASHED_PREFIX - FNV_1A_COMPOSITE_1
                        fixedPrefix + FNV_1A_BASE64.hash(pathInput),
            .build();
        assertEquals(".erwR-G735Uw/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/segments/metadata/", result.buildAsString());
                        dataCategory.getName(),
                .startsWith(
        return "".equals(basePath)
                        fixedPrefix + FNV_1A_BASE64.hash(pathInput),
            .fixedPrefix(fixedPrefix)
        );
        // Segment Data
        List<String> pathList = getPathList();
        pathInput = ShardDataPathInput.builder()
            .basePath(blobPath)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
            .build();
            .dataCategory(dataCategory)
        pathInput = ShardDataPathInput.builder()
            .fixedPrefix(fixedPrefix)
        assertTrue(
                )
        ex = assertThrows(IllegalArgumentException.class, () -> parseString(null));
            .dataCategory(dataCategory)
                        dataType.getName()
        String actual = result.buildAsString();
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
                    String.join(
            .build();
        pathInput = ShardDataPathInput.builder()
            .shardId(shardId)
            .shardId(fixedShardId)
    private String getPath(List<String> pathList) {
            .dataType(dataType)
                )
                    )
    public void testParseString() {
            .shardId(shardId)
        expected = "xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/.erwR-G735Uw/k2ijhe877d7yuhx7/10/segments/metadata/";
            .build();
        actual = result.buildAsString();
        // assert with exact value for known base path
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
        assertTrue(
                        dataType.getName()
            .dataCategory(dataCategory)
 */
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
        // Translog Metadata
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
            .dataCategory(dataCategory)
        // Segment Lockfiles
        assertEquals(
                        basePath,
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
            .dataType(dataType)
        // assert with exact value for known base path
            .fixedPrefix(fixedPrefix)
        // assert with exact value for known base path
        pathInput = ShardDataPathInput.builder()
        pathInput = ShardDataPathInput.builder()
            .build();
        pathInput = ShardDataPathInput.builder()
            .indexUUID(fixedIndexUUID)
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
                        dataCategory.getName(),
            .build();
            )
        String shardId = String.valueOf(randomInt(100));
            .dataCategory(dataCategory)
    public void testGeneratePathForFixedType() {
                        basePath,
        dataCategory = SEGMENTS;
        dataType = METADATA;
            .indexUUID(fixedIndexUUID)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
            .indexUUID(indexUUID)
        // Segment Lockfiles
        );
        String indexUUID = "dsdkjsu8832njn";
            .dataType(dataType)
                basePath,
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
            .shardId(shardId)
                fixedPrefix + FNV_1A_BASE64.hash(pathInput),
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parseString(randomTypeString));
                pathInput.indexUUID(),
        assertEquals(
    private List<String> getPathList() {
            .indexUUID(indexUUID)
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
        pathInput = ShardDataPathInput.builder()
                    String.join(
        DataCategory dataCategory = TRANSLOG;
        int length = randomIntBetween(0, 5);
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
            .build();
        assertTrue(
                )
}
        String shardId = "10";
            .fixedPrefix(fixedPrefix)
                        dataType.getName()
        // assert with exact value for known base path
            .dataType(dataType)
        expected = derivePath(basePath, pathInput, fixedPrefix);
        // Case 3 - Null string
        String shardId = String.valueOf(randomInt(100));
        // Translog Metadata
            ".e10101111000001/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/segments/metadata/",
            .dataType(dataType)
    public void testGeneratePathForSnapshotShardPathInput() {
        String basePath = getPath(pathList) + indexUUID + SEPARATOR + shardId + SEPARATOR;
                        dataCategory.getName(),
                    )
        BlobPath blobPath = new BlobPath();
        result = FIXED.path(pathInput, null);
                        basePath,
                        dataCategory.getName(),
                        dataType.getName()
            .build();
            .shardId(fixedShardId)
        basePath = basePath.isEmpty() ? basePath : basePath.substring(0, basePath.length() - 1);
            result.buildAsString()
        // Translog Metadata
            .dataCategory(dataCategory)
                fixedPrefix + FNV_1A_BASE64.hash(pathInput),
            .dataType(dataType)
                        dataType.getName()
        assertEquals(".DgSI70IciXs/xjsdhj/ddjsha/yudy7sd/32hdhua7/89jdij/k2ijhe877d7yuhx7/10/translog/data/", result.buildAsString());
        // assert with exact value for known base path
            .indexUUID(indexUUID)
            .fixedPrefix(fixedPrefix)
        }
        // HASHED_PREFIX - FNV_1A_BASE64
                pathInput.dataCategory().getName(),
        assertTrue(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual.startsWith(expected));
        result = HASHED_INFIX.path(pathInput, FNV_1A_BASE64);
        );
                        fixedPrefix + FNV_1A_COMPOSITE_1.hash(pathInput),
            .dataType(dataType)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_BASE64);
        pathInput = ShardDataPathInput.builder()
            .indexUUID(fixedIndexUUID)
            .fixedPrefix(fixedPrefix)
                .startsWith(
        dataType = METADATA;
                    String.join(
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
                .startsWith(
        result = FIXED.path(pathInput, null);
                    String.join(
                .startsWith(
        assertEquals(new ParameterizedMessage("expected={} actual={}", expected, actual).getFormattedMessage(), actual, expected);
        List<String> pathList = new ArrayList<>();
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
            .basePath(blobPath)
        actual = result.buildAsString();
        String expected = derivePath(basePath, pathInput, fixedPrefix);
            .dataType(dataType)
            .build();
            .indexUUID(indexUUID)
            return p;
        // Segment Metadata
        );
        actual = result.buildAsString();
                .startsWith(
        actual = result.buildAsString();
            .basePath(blobPath)
                        dataCategory.getName(),
            .dataCategory(dataCategory)
        result = HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);
            result.buildAsString()
