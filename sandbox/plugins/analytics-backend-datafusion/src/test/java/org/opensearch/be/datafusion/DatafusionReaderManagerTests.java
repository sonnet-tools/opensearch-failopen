        // didRefresh=false means no new data — should be a no-op
        expectThrows(IllegalArgumentException.class, () -> manager.getReader(null));
 * compatible open source license.
     */
    /**
        manager.close();
    }
     */
        manager.onFilesAdded(null);
    private ShardPath createTestShardPath() throws IOException {
        String expectedDir = shardPath.getDataPath().resolve("parquet").toString();
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
            TEST_FORMAT,
    /**
        Collection<String> expectedPaths = List.of(expectedDir + "/seg_0.parquet", expectedDir + "/seg_1.parquet");
import org.opensearch.test.OpenSearchTestCase;
        ShardPath shardPath = createTestShardPath();
    }
        @Override
            shardPath,
        }
    /**
        DataFusionService mockService = mock(DataFusionService.class);
        public String name() {
    public void testCloseWithNoReadersDoesNotThrow() throws IOException {
    }
        }
        DataFusionService mockService = mock(DataFusionService.class);
import java.util.Set;
     * onFilesAdded with null collection should not interact with service.
        manager.onFilesDeleted(files);
     */
        ShardPath shardPath = createTestShardPath();
        DataFusionService mockService = mock(DataFusionService.class);
        manager.close();
import org.opensearch.core.index.shard.ShardId;
    }
    private static final DataFormat TEST_FORMAT = new DataFormat() {
     * afterRefresh with didRefresh=false should not create a reader.
    public void testAfterRefreshWithDidRefreshFalseIsNoOp() throws IOException {
            return "parquet";
 * The OpenSearch Contributors require contributions made to
     */
     * onFilesDeleted with null collection should not interact with service.
        // ShardPath requires the path to end with: <index-uuid>/<shard-id>
 * {@link DatafusionReader} calls {@code NativeBridge} (FFM) in its constructor,
     */
        ShardPath shardPath = createTestShardPath();
import static org.mockito.Mockito.verify;
        }
        DatafusionReaderManager manager = new DatafusionReaderManager(
     * Constructor should accept null handle (hot path where no native store is available).
 * delegation logic without loading the native library. Since
 * <p>These tests exercise the manager's field storage, null-safety, and
    public void testConstructorAcceptsEmptyHandle() throws IOException {
import org.opensearch.core.index.Index;
    /**
     * onFilesAdded with non-empty collection should delegate to service with absolute paths.
import java.util.List;
            List.of(),
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
 *
        Collection<String> files = List.of("seg_0.parquet");
        DataFusionService mockService = mock(DataFusionService.class);
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
 *
        public long priority() {
    /**
            mockService,
     * close() with no readers should not throw.
        DataFusionService mockService = mock(DataFusionService.class);
/*
        manager.close();
        DataFusionService mockService = mock(DataFusionService.class);
        @Override
        manager.afterRefresh(false, null);
    public void testBeforeRefreshDoesNotThrow() throws IOException {
        manager.close();
     */
     */
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DataFusionService mockService = mock(DataFusionService.class);
        Files.createDirectories(dataPath);
        assertNotNull(manager);
        manager.onFilesDeleted(null);
    }
            return 1;
     * getReader with no prior afterRefresh should throw IOException.
    }
    public void testOnFilesDeletedWithEmptyCollectionIsNoOp() throws IOException {
        ShardPath shardPath = createTestShardPath();
    public void testOnFilesAddedDelegatesToService() throws IOException {
    /**
    public void testGetReaderWithNoRefreshThrows() throws IOException {
import java.util.Collection;
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testConstructorAcceptsNullHandle() throws IOException {
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        manager.beforeRefresh();
            return Set.of();
        manager.onFilesDeleted(List.of());
        ShardPath shardPath = createTestShardPath();
        manager.close();
    }
        );
        ShardPath shardPath = createTestShardPath();
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
    public void testOnFilesDeletedWithNullIsNoOp() throws IOException {
    }
        Path tempDir = createTempDir("shard");
        // Should not throw — no readers to close
    /**
import org.opensearch.index.shard.ShardPath;
    }
        ShardPath shardPath = createTestShardPath();
        verify(mockService).onFilesDeleted(expectedPaths);
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        manager.close();
import static org.mockito.Mockito.verifyNoInteractions;
    }
        public Set<FieldTypeCapabilities> supportedFields() {
        DataFusionService mockService = mock(DataFusionService.class);
 * we test only the manager's handle storage and lifecycle methods that don't
        DataFusionService mockService = mock(DataFusionService.class);
     * onFilesDeleted with non-empty collection should delegate to service with absolute paths.
        Collection<String> expectedPaths = List.of(expectedDir + "/seg_0.parquet");
        ShardPath shardPath = createTestShardPath();
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        manager.close();
        ShardPath shardPath = createTestShardPath();
    public void testOnFilesDeletedDelegatesToService() throws IOException {
        manager.close();
    /**
    }
        verify(mockService).onFilesAdded(expectedPaths);
package org.opensearch.be.datafusion;
        DataFusionService mockService = mock(DataFusionService.class);
            NativeStoreHandle.EMPTY,
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
     * beforeRefresh should not throw.
     * onFilesDeleted with empty collection should not interact with service.
    /**
        Collection<String> files = List.of("seg_0.parquet", "seg_1.parquet");
        DataFusionService mockService = mock(DataFusionService.class);
    public void testOnFilesAddedWithNullIsNoOp() throws IOException {
        assertNotNull(manager);
        @Override
     * onFilesAdded with empty collection should not interact with service.
     */
    /**
        verifyNoInteractions(mockService);
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
            List.of()
 */
    /**
    public void testOnFilesAddedWithEmptyCollectionIsNoOp() throws IOException {
        manager.onFilesAdded(files);
        verifyNoInteractions(mockService);
        ShardPath shardPath = createTestShardPath();
        verifyNoInteractions(mockService);
/**
        manager.close();
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DataFusionService mockService = mock(DataFusionService.class);
}
 * Unit tests for {@link DatafusionReaderManager}.
import java.nio.file.Files;
     * Constructor should accept EMPTY handle (equivalent to null for native store).
     */
 */
     */
        ShardPath shardPath = createTestShardPath();
 * create readers.
        Path dataPath = tempDir.resolve("test-uuid").resolve("0");
        return new ShardPath(false, dataPath, dataPath, shardId);
public class DatafusionReaderManagerTests extends OpenSearchTestCase {
        verifyNoInteractions(mockService);
        manager.close();
import org.opensearch.plugins.NativeStoreHandle;
    };
    /**
        manager.close();
     */
     */
        manager.onFilesAdded(List.of());
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import java.nio.file.Path;
        ShardPath shardPath = createTestShardPath();
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
import java.io.IOException;
    }
        manager.close();
        String expectedDir = shardPath.getDataPath().resolve("parquet").toString();
import org.opensearch.index.engine.dataformat.DataFormat;
