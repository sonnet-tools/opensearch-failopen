import java.io.IOException;
            // Additional verification: ensure non-segment files are present
        client().admin()
        }  
            IndexResult result = super.index(index);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                }
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;  
        @Override
import java.util.Optional;
                    SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);  
        private final Directory subdirectoryDirectory;
                    base.close();  
import org.apache.lucene.document.Document;
            if (indexService == null) {
        @Override
        }  
                realCommit.close();  
                    }  
            return allFiles;  
            subdirectoryWriter.addDocument(doc);
            return delegate.getSegmentCount();  
                return Optional.of(new TestEngineFactory());
            .collect(java.util.stream.Collectors.toList());
        return Arrays.asList(SubdirectoryStorePlugin.class, TestEnginePlugin.class);
            return delegate.isDeleted();  
                    Collection<String> segmentFiles = segmentInfos.files(true);
        private final IndexWriter subdirectoryWriter;
import org.apache.lucene.store.IndexOutput;  
            IndexService indexService = indicesService.indexService(resolveIndex(indexName));  
import org.opensearch.index.IndexSettings;
    /**
                CodecUtil.writeHeader(output, "test_metadata", 0);
                }
                        allFiles.add(relativePath);
        Settings indexSettings = Settings.builder()
            subdirectoryPath = shardPath.resolve(SUBDIRECTORY_NAME);  
            // First flush the main engine
        }
        private int nonSegmentFileCounter = 0;
        /**
            .get();  
                addDocumentToSubdirectory(index);  
     */
        }
            this.engineConfig = config;
            try {  
            boolean hasNonSegmentFiles = referenceFiles.stream().anyMatch(f -> f.startsWith(TestEngine.NON_SEGMENT_FILE_PREFIX));
                }
            .indices()  
                    if (f.startsWith(NON_SEGMENT_FILE_PREFIX)) {
    }
        @Override
                try (Directory directory = FSDirectory.open(subdirectoryPath)) {
            } catch (IOException e) {
                    }  
            }
            return delegate.getSegmentsFileName();  
            writerConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
                } catch (IOException e) {  
            return delegate.getUserData();
        }
                SegmentInfos mainInfos = ((SegmentInfosCatalogSnapshot) base.get()).getSegmentInfos();  
            super.flush(force, waitIfOngoing);
            }  
        }
        @Override  
    }
        }
import java.util.List;  
            // Set up subdirectory path and writer
                        Set<String> files = new HashSet<>(super.getFiles(includeSegmentsFile));
        // Index documents to create content
                subdirectoryWriter.commit();
import java.util.HashSet;
                    public Collection<String> getFiles(boolean includeSegmentsFile) throws IOException {  
            subdirectoryDirectory.close();
        public Directory getDirectory() {
            .setSettings(Settings.builder().put("index.number_of_replicas", 2))
        Map<String, Set<String>> nodeFiles = new HashMap<>();
            try {
            return Optional.empty();
                    // Add non-segment files (test_metadata_*)
                    String[] filesInDir = directory.listAll();
    private void verifySubdirectoryFilesOnAllNodes(String indexName, int expectedCount) throws Exception {  
import org.apache.lucene.store.Directory;  
                            allFiles.add(fileName);
                        files.addAll(extra);
            super(config);
                continue; // Index not on this node
                    if (!allFiles.isEmpty()) {  
        public int getSegmentCount() {
                // Write codec footer with checksum  
            if (flushFirst) {
                            allFiles.add(relativePath);
                return new GatedCloseable<>(wrapped, base::close);  
                throw new EngineException(shardId, "Failed to commit subdirectory during flush", e);  
            Path subdirectoryPath = shard.shardPath().getDataPath().resolve(TestEngine.SUBDIRECTORY_NAME);
        static final String NON_SEGMENT_FILE_PREFIX = "test_metadata_";
        public Engine newReadWriteEngine(EngineConfig config) {
                TestIndexCommit testCommit = new TestIndexCommit(originalCommit, subdirectoryPath);  
/*  
 * compatible open source license.
                // Write a proper Lucene file with codec header and footer
import org.opensearch.plugins.Plugin;
        }  
                for (String f : subdirectoryDirectory.listAll()) {  
                GatedCloseable<IndexCommit> realCommit = super.acquireSafeIndexCommit();
import org.opensearch.index.IndexService;
        static final Setting<Boolean> TEST_ENGINE_INDEX_SETTING = Setting.boolSetting(  
     */  
            return result;
     * Custom IndexCommit that includes subdirectory files in recovery
                        extra.add(Path.of(SUBDIRECTORY_NAME, f).toString());
                }  
 * The OpenSearch Contributors require contributions made to  
        @Override  
            Set<String> allFiles = new HashSet<>(delegate.getFileNames());
                    for (String fileName : filesInDir) {  
        assertEquals(  
        for (String nodeName : internalCluster().getNodeNames()) {  
        // Create index with custom store and engine  
                throw new EngineException(config.getShardId(), "Failed to create test engine", e);
        private void addDocumentToSubdirectory(Index index) throws IOException {
        private final IndexCommit delegate;
            .prepareUpdateSettings("test_index")
        }  
            // Then commit the subdirectory  
        // Verify subdirectory files were copied to both primary and replica
        ensureGreen("test_index");  
import org.opensearch.index.engine.Engine;  
        public Collection<String> getFileNames() throws IOException {
        public List<Setting<?>> getSettings() {
                    // Get non-segment files
                        if (fileName.startsWith(TestEngine.NON_SEGMENT_FILE_PREFIX)) {
        // Verify recovery completes successfully
        public Map<String, String> getUserData() throws IOException {  
                    Set<String> allFiles = new HashSet<>();  
                    }
                CodecUtil.writeFooter(output);
            if (Files.exists(subdirectoryPath)) {
        public boolean isDeleted() {
     */
    }  
        verifySubdirectoryFilesOnAllNodes("test_index", 3);  
            for (Map.Entry<String, Set<String>> entry : nodeFiles.entrySet()) {  
            try {
            } catch (IOException e) {
public class SubdirectoryAwareRecoveryTests extends OpenSearchIntegTestCase {  
import org.apache.lucene.index.IndexCommit;
import org.opensearch.index.engine.EngineException;
        private final EngineConfig engineConfig;  
            }
            // First, index the document normally
                output.writeLong(nonSegmentFileCounter);
            if (result.getResultType() == Engine.Result.Type.SUCCESS && engineConfig.getStartedPrimarySupplier().getAsBoolean()) {
        }
            String fileName = NON_SEGMENT_FILE_PREFIX + nonSegmentFileCounter++;
import org.apache.lucene.document.Field;  
            delegate.delete();
                    allFiles.addAll(segmentFiles);
            this.subdirectoryPath = subdirectoryPath;
    @Override
            // Only add to subdirectory if is a primary shard
        TestEngine(EngineConfig config) throws IOException {  
    /**
        @Override
    /**
        public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {  
    }
            try {
                CatalogSnapshot wrapped = new SegmentInfosCatalogSnapshot(mainInfos) {
        static final String SUBDIRECTORY_NAME = "test_subdirectory";  
            }
                    @Override
                    // corrupt index or no commit files, skip this node
                        }  
                throw new EngineException(shardId, "Failed to acquire safe catalog snapshot", e);
                GatedCloseable<IndexCommit> realCommit = super.acquireLastIndexCommit(false);  
                }
            "Expected " + expectedCount + " nodes with subdirectory files, found: " + nodeFiles.keySet(),
        for (int i = 0; i < 10; i++) {  
                return new TestEngine(config);  
import org.apache.lucene.store.IOContext;
        }  
        public long getGeneration() {
    }
        client().admin().indices().prepareFlush("test_index").get();
        @Override  
import org.apache.lucene.index.IndexWriter;  
                IndexCommit originalCommit = realCommit.get();
        // Add replica to trigger recovery
            false,
            }  
        prepareCreate("test_index").setSettings(indexSettings).get();
     */  
    }
    /**  
        @Override  
        }  
        }  
    static class TestIndexCommit extends IndexCommit {  
            .put("index.number_of_replicas", 0)  
        @Override  
                        if (fileName.startsWith(TestEngine.NON_SEGMENT_FILE_PREFIX)) {
            final GatedCloseable<CatalogSnapshot> base = super.acquireSafeCatalogSnapshot();
            if (TEST_ENGINE_INDEX_SETTING.get(indexSettings.getSettings())) {
        private void createNonSegmentFile() throws IOException {
        private final Path subdirectoryPath;  
            subdirectoryWriter = new IndexWriter(subdirectoryDirectory, writerConfig);
import org.opensearch.common.concurrent.GatedCloseable;
            Files.createDirectories(subdirectoryPath);
            } catch (Exception e) {  
import org.opensearch.common.settings.Setting;
                    for (String fileName : segmentFiles) {  
                        }
    @Override
                    }
import org.apache.lucene.document.StringField;
        // Verify all nodes have identical files (including non-segment files)  
            "index.use_test_engine",
        }
                realCommit.close();
    public static class TestEnginePlugin extends Plugin implements EnginePlugin {
            Setting.Property.IndexScope  
        }
        }
                        nodeFiles.put(nodeName, allFiles);
package org.opensearch.plugin.store.subdirectory;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3)
        @Override
            try (IndexOutput output = subdirectoryDirectory.createOutput(fileName, IOContext.DEFAULT)) {  
    public void testSubdirectoryAwareRecovery() throws Exception {
            }
            if (Files.exists(subdirectoryPath)) {
import java.util.Arrays;
                for (String f : subInfos.files(true)) {  
            }
        public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {  
                throw new EngineException(shardId, "Failed to acquire last index commit", e);  
import java.util.HashMap;
    }
        public String getSegmentsFileName() {
        public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
import org.opensearch.index.engine.EngineConfig;
import org.opensearch.index.engine.InternalEngine;
            doc.add(new StringField("source_id", index.id(), Field.Store.YES));
    static class TestEngine extends InternalEngine {
            return Collections.singletonList(TEST_ENGINE_INDEX_SETTING);
import java.util.Map;
            try {
                try (Directory directory = FSDirectory.open(subdirectoryPath)) {
        ensureGreen("test_index");  
 * this file be licensed under the Apache-2.0 license or a
            .build();  
import org.apache.lucene.index.IndexWriterConfig;
                } catch (IOException ex) {
                output.writeString("test_data_" + System.currentTimeMillis());
            return delegate.getDirectory();
        private final Path subdirectoryPath;  
                };
            .put("index.store.factory", "subdirectory_store")
            this.delegate = delegate;  
            .put("index.number_of_shards", 1)
        client().admin().indices().prepareRefresh("test_index").get();
                    e.addSuppressed(ex);
            .filter(plugin -> !plugin.getName().contains("MockEngineFactoryPlugin"))
        public GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) throws EngineException {
            super.close();  
                throw new EngineException(shardId, "Failed to acquire safe index commit", e);
                return new GatedCloseable<>(testCommit, () -> {});
            Path shardPath = config.getStore().shardPath().getDataPath();
 *
            } catch (Exception e) {
        @Override
        @Override
import org.opensearch.test.OpenSearchIntegTestCase;
            nodeFiles.size()  
            Document doc = new Document();  
import java.util.Collection;
            IndexWriterConfig writerConfig = new IndexWriterConfig();  
                    String[] allFilesInDir = directory.listAll();  
            }
    }  
                flush(false, true);  
                // Create a non-segment file to test non-segment file recovery  
                        return files;  
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
            expectedCount,
            IndexShard shard = indexService.getShard(0);
                    }  
            client().prepareIndex("test_index").setId(Integer.toString(i)).setSource("field", "value" + i).get();
                try {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        return super.getMockPlugins().stream()  
        );
            .put(TestEnginePlugin.TEST_ENGINE_INDEX_SETTING.getKey(), true)
import org.apache.lucene.index.SegmentInfos;
import org.opensearch.indices.IndicesService;
        TestIndexCommit(IndexCommit delegate, Path subdirectoryPath) {
        }
     * Test engine that extends InternalEngine and creates a proper Lucene index in a subdirectory
            return delegate.getGeneration();
        @Override
        public void delete() {  
                    }
import java.util.Set;  
                // Reuse the SegmentInfos from the base snapshot — no redundant disk read.
import org.opensearch.index.shard.IndexShard;
                final Set<String> extra = new HashSet<>();
        }
        }
                        String relativePath = Path.of(TestEngine.SUBDIRECTORY_NAME, fileName).toString();
        }
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.codecs.CodecUtil;
            }
 * SPDX-License-Identifier: Apache-2.0
        @Override
            }
        }
                // Collect subdirectory file paths (prefixed with subdirectory name).  
            }  
     * Factory for creating TestEngine instances  
            }  
         * Creates a non-segment file in the subdirectory to test non-segment file metadata handling
                    // Get segment files
import java.nio.file.Files;
        @Override  
        }  
        @Override
                final SegmentInfos subInfos = SegmentInfos.readLatestCommit(subdirectoryDirectory);
                    for (String fileName : allFilesInDir) {
        public void close() throws IOException {  
        public void flush(boolean force, boolean waitIfOngoing) throws EngineException {  
                assertEquals("Node " + entry.getKey() + " should have identical files to other nodes", referenceFiles, entry.getValue());
        @Override
import org.opensearch.index.engine.EngineFactory;  
import org.opensearch.common.settings.Settings;  
    static class TestEngineFactory implements EngineFactory {
            subdirectoryWriter.close();
        }  
import java.nio.file.Path;  
                // Write some test data  
        );
                    SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);  
                return new GatedCloseable<>(testCommit, () -> {});
                createNonSegmentFile();
         */  
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
        }
                TestIndexCommit testCommit = new TestIndexCommit(originalCommit, subdirectoryPath);
            }
                    extra.add(Path.of(SUBDIRECTORY_NAME, f).toString());
                IndexCommit originalCommit = realCommit.get();
        public IndexResult index(Index index) throws IOException {  
            Set<String> referenceFiles = nodeFiles.values().iterator().next();
}  
import org.opensearch.plugins.EnginePlugin;  
                            String relativePath = Path.of(TestEngine.SUBDIRECTORY_NAME, fileName).toString();  
        if (nodeFiles.size() > 1) {
            assertTrue("Non-segment files should be present in subdirectory", hasNonSegmentFiles);  
            subdirectoryDirectory = FSDirectory.open(subdirectoryPath);
     * Plugin that provides a custom engine for testing subdirectory recovery
                    Collection<String> segmentFiles = segmentInfos.files(true);
import java.util.Collections;  
 */  
            } catch (Exception e) {
