     */  
    public void testGetReaderWithNoRefreshThrows() throws IOException {
        ShardPath shardPath = createTestShardPath();  
 * we test only the manager's handle storage and lifecycle methods that don't
    };
    }  
        DataFusionService mockService = mock(DataFusionService.class);  
 * SPDX-License-Identifier: Apache-2.0
        Collection<String> files = List.of("seg_0.parquet");  
        DataFusionService mockService = mock(DataFusionService.class);
    /**
    public void testOnFilesDeletedWithNullIsNoOp() throws IOException {
    /**  
        manager.close();  
    public void testOnFilesAddedWithNullIsNoOp() throws IOException {  
    /**
            TEST_FORMAT,
    /**  
    }
 */
     * Constructor should accept null handle (hot path where no native store is available).
    }
        expectThrows(IllegalArgumentException.class, () -> manager.getReader(null));  
        ShardPath shardPath = createTestShardPath();
import org.opensearch.core.index.shard.ShardId;
     */
    }
            NativeStoreHandle.EMPTY,
     * beforeRefresh should not throw.
        DataFusionService mockService = mock(DataFusionService.class);  
            mockService,
    }
     */
        ShardPath shardPath = createTestShardPath();
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        // ShardPath requires the path to end with: <index-uuid>/<shard-id>  
import java.io.IOException;  
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());  
            List.of()
        verify(mockService).onFilesDeleted(expectedPaths);  
        // didRefresh=false means no new data — should be a no-op
        // Should not throw — no readers to close  
        manager.close();
            return 1;  
        @Override  
/*  
        manager.beforeRefresh();
     * onFilesDeleted with null collection should not interact with service.
    }
     */
 * <p>These tests exercise the manager's field storage, null-safety, and
    public void testConstructorAcceptsNullHandle() throws IOException {  
import java.util.List;
        );
        DataFusionService mockService = mock(DataFusionService.class);
    /**  
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
     */
 */  
import static org.mockito.Mockito.verifyNoInteractions;  
        verify(mockService).onFilesAdded(expectedPaths);
import java.util.Set;
        ShardPath shardPath = createTestShardPath();
     * onFilesAdded with null collection should not interact with service.
        verifyNoInteractions(mockService);
import org.opensearch.index.engine.dataformat.DataFormat;  
        manager.onFilesAdded(List.of());  
        DataFusionService mockService = mock(DataFusionService.class);  
    /**
import java.util.Collection;  
    /**
        ShardPath shardPath = createTestShardPath();
    }
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());  
        manager.close();
     */  
import org.opensearch.core.index.Index;
    /**
        verifyNoInteractions(mockService);  
        manager.onFilesDeleted(null);  
        manager.onFilesAdded(null);
    /**  
 * Unit tests for {@link DatafusionReaderManager}.  
import org.opensearch.plugins.NativeStoreHandle;  
        Path dataPath = tempDir.resolve("test-uuid").resolve("0");
        DataFusionService mockService = mock(DataFusionService.class);  
    public void testOnFilesAddedDelegatesToService() throws IOException {
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DataFusionService mockService = mock(DataFusionService.class);
import static org.mockito.Mockito.mock;
     * onFilesAdded with empty collection should not interact with service.
 * this file be licensed under the Apache-2.0 license or a
        Collection<String> expectedPaths = List.of(expectedDir + "/seg_0.parquet");
     */  
/**
        ShardPath shardPath = createTestShardPath();
        manager.afterRefresh(false, null);  
    }  
    }
        verifyNoInteractions(mockService);
    public void testOnFilesDeletedDelegatesToService() throws IOException {
     */  
        manager.onFilesDeleted(files);
import java.nio.file.Files;
import static org.mockito.Mockito.verify;
        verifyNoInteractions(mockService);
        manager.close();  
import java.nio.file.Path;
        String expectedDir = shardPath.getDataPath().resolve("parquet").toString();  
        DatafusionReaderManager manager = new DatafusionReaderManager(
    private ShardPath createTestShardPath() throws IOException {  
        ShardPath shardPath = createTestShardPath();
        assertNotNull(manager);
     */
        }
            shardPath,  
        ShardPath shardPath = createTestShardPath();
package org.opensearch.be.datafusion;
     * onFilesDeleted with empty collection should not interact with service.  
import org.opensearch.test.OpenSearchTestCase;
 *
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        manager.close();  
        manager.close();
 *
        manager.close();
        ShardPath shardPath = createTestShardPath();  
        manager.close();  
    public void testOnFilesDeletedWithEmptyCollectionIsNoOp() throws IOException {
            return Set.of();
     */
    /**  
        DataFusionService mockService = mock(DataFusionService.class);
    public void testOnFilesAddedWithEmptyCollectionIsNoOp() throws IOException {
     * afterRefresh with didRefresh=false should not create a reader.
        ShardPath shardPath = createTestShardPath();
     * Constructor should accept EMPTY handle (equivalent to null for native store).
 * compatible open source license.
        Collection<String> files = List.of("seg_0.parquet", "seg_1.parquet");
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        DataFusionService mockService = mock(DataFusionService.class);
        manager.close();
 * The OpenSearch Contributors require contributions made to  
     * onFilesAdded with non-empty collection should delegate to service with absolute paths.
        manager.close();
        @Override
import org.opensearch.index.shard.ShardPath;
        manager.close();
        Collection<String> expectedPaths = List.of(expectedDir + "/seg_0.parquet", expectedDir + "/seg_1.parquet");
     * getReader with no prior afterRefresh should throw IOException.
    }
     */  
     * onFilesDeleted with non-empty collection should delegate to service with absolute paths.  
    }
            return "parquet";
        Files.createDirectories(dataPath);
        manager.onFilesAdded(files);
        DataFusionService mockService = mock(DataFusionService.class);  
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        manager.close();
 * delegation logic without loading the native library. Since  
    /**
        }  
    public void testBeforeRefreshDoesNotThrow() throws IOException {  
    public void testAfterRefreshWithDidRefreshFalseIsNoOp() throws IOException {  
    private static final DataFormat TEST_FORMAT = new DataFormat() {
}  
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
        DataFusionService mockService = mock(DataFusionService.class);
        DataFusionService mockService = mock(DataFusionService.class);
        return new ShardPath(false, dataPath, dataPath, shardId);  
            List.of(),  
        String expectedDir = shardPath.getDataPath().resolve("parquet").toString();
        Path tempDir = createTempDir("shard");
        public Set<FieldTypeCapabilities> supportedFields() {
        public String name() {  
        ShardPath shardPath = createTestShardPath();
public class DatafusionReaderManagerTests extends OpenSearchTestCase {
    }
        assertNotNull(manager);  
        DatafusionReaderManager manager = new DatafusionReaderManager(TEST_FORMAT, shardPath, mockService, null, List.of(), List.of());
    /**
        @Override
        ShardPath shardPath = createTestShardPath();
        public long priority() {
        manager.onFilesDeleted(List.of());
 * {@link DatafusionReader} calls {@code NativeBridge} (FFM) in its constructor,
    }
     */
    public void testConstructorAcceptsEmptyHandle() throws IOException {  
 * create readers.  
        }
     * close() with no readers should not throw.
    public void testCloseWithNoReadersDoesNotThrow() throws IOException {
