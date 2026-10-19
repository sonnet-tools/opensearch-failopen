import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
                    Set<String> allFiles = new HashSet<>();
                    if (f.startsWith(NON_SEGMENT_FILE_PREFIX)) {
        // Index documents to create content
                    e.addSuppressed(ex);
            }
import org.opensearch.index.engine.EngineException;
    }
        }
                return new TestEngine(config);
                    if (!allFiles.isEmpty()) {
import org.opensearch.plugins.EnginePlugin;
                        extra.add(Path.of(SUBDIRECTORY_NAME, f).toString());
import org.opensearch.index.engine.Engine;
import org.opensearch.index.engine.EngineFactory;
    }
    }
                throw new EngineException(shardId, "Failed to acquire safe index commit", e);
        public void flush(boolean force, boolean waitIfOngoing) throws EngineException {
                final Set<String> extra = new HashSet<>();
        @Override
import org.apache.lucene.store.FSDirectory;
    }
        public GatedCloseable<IndexCommit> acquireLastIndexCommit(boolean flushFirst) throws EngineException {
            .build();
        }
                throw new EngineException(shardId, "Failed to acquire safe catalog snapshot", e);
                throw new EngineException(config.getShardId(), "Failed to create test engine", e);
                try {
    public void testSubdirectoryAwareRecovery() throws Exception {
                    // corrupt index or no commit files, skip this node
    }
            "index.use_test_engine",
        ensureGreen("test_index");
            }
        public int getSegmentCount() {
            .put(TestEnginePlugin.TEST_ENGINE_INDEX_SETTING.getKey(), true)
        public boolean isDeleted() {
                } catch (IOException ex) {
        Settings indexSettings = Settings.builder()
     * Custom IndexCommit that includes subdirectory files in recovery
        @Override
                            allFiles.add(fileName);
import org.apache.lucene.index.IndexWriter;
                    @Override
        }
                output.writeString("test_data_" + System.currentTimeMillis());
                return new GatedCloseable<>(testCommit, () -> {});
        );
                    extra.add(Path.of(SUBDIRECTORY_NAME, f).toString());
            this.engineConfig = config;
            final GatedCloseable<CatalogSnapshot> base = super.acquireSafeCatalogSnapshot();
                CatalogSnapshot wrapped = new SegmentInfosCatalogSnapshot(mainInfos) {
        static final String NON_SEGMENT_FILE_PREFIX = "test_metadata_";
            return delegate.getSegmentsFileName();
        verifySubdirectoryFilesOnAllNodes("test_index", 3);
 * this file be licensed under the Apache-2.0 license or a
        prepareCreate("test_index").setSettings(indexSettings).get();
                flush(false, true);
        }
import java.util.HashMap;
                CodecUtil.writeFooter(output);
import java.util.Map;
            try {
                for (String f : subInfos.files(true)) {
                throw new EngineException(shardId, "Failed to commit subdirectory during flush", e);
 * SPDX-License-Identifier: Apache-2.0
                TestIndexCommit testCommit = new TestIndexCommit(originalCommit, subdirectoryPath);
            if (Files.exists(subdirectoryPath)) {
            }
                }
        }
            .setSettings(Settings.builder().put("index.number_of_replicas", 2))
                } catch (IOException e) {
            } catch (IOException e) {
import org.opensearch.index.engine.EngineConfig;
                        allFiles.add(relativePath);
        for (int i = 0; i < 10; i++) {
        return super.getMockPlugins().stream()
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.concurrent.GatedCloseable;
import org.apache.lucene.document.Field;
import java.nio.file.Path;
import org.apache.lucene.store.Directory;
            Set<String> referenceFiles = nodeFiles.values().iterator().next();
    /**
                    Collection<String> segmentFiles = segmentInfos.files(true);
                            String relativePath = Path.of(TestEngine.SUBDIRECTORY_NAME, fileName).toString();
                    }
        @Override
        @Override
        @Override
                }
        // Create index with custom store and engine
        private int nonSegmentFileCounter = 0;
        @Override
            nodeFiles.size()
                GatedCloseable<IndexCommit> realCommit = super.acquireSafeIndexCommit();
     * Test engine that extends InternalEngine and creates a proper Lucene index in a subdirectory
        TestEngine(EngineConfig config) throws IOException {
        /**
        }
        // Verify recovery completes successfully
import org.opensearch.index.IndexService;
                    for (String fileName : segmentFiles) {
        for (String nodeName : internalCluster().getNodeNames()) {
                // Reuse the SegmentInfos from the base snapshot — no redundant disk read.
     */
    /**
        public Collection<String> getFileNames() throws IOException {
            // Set up subdirectory path and writer
        if (nodeFiles.size() > 1) {
import org.opensearch.common.settings.Setting;
        private final IndexCommit delegate;
            } catch (IOException e) {
         */
        }
        }
    @Override
            doc.add(new StringField("source_id", index.id(), Field.Store.YES));
        @Override
import org.apache.lucene.document.StringField;
            // Additional verification: ensure non-segment files are present
        @Override
            }
            try {
            super.close();
            Path subdirectoryPath = shard.shardPath().getDataPath().resolve(TestEngine.SUBDIRECTORY_NAME);
                addDocumentToSubdirectory(index);
            this.delegate = delegate;
            if (indexService == null) {
                // Write codec footer with checksum
        public Engine newReadWriteEngine(EngineConfig config) {
                    // Get non-segment files
        private void createNonSegmentFile() throws IOException {
            client().prepareIndex("test_index").setId(Integer.toString(i)).setSource("field", "value" + i).get();
import java.nio.file.Files;
                realCommit.close();
                    }
            try (IndexOutput output = subdirectoryDirectory.createOutput(fileName, IOContext.DEFAULT)) {
                return new GatedCloseable<>(testCommit, () -> {});
            delegate.delete();
            return result;
            if (flushFirst) {
        public void close() throws IOException {
        @Override
            // Only add to subdirectory if is a primary shard
                return Optional.of(new TestEngineFactory());
public class SubdirectoryAwareRecoveryTests extends OpenSearchIntegTestCase {
        private final Path subdirectoryPath;
                        nodeFiles.put(nodeName, allFiles);
        public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {
     * Plugin that provides a custom engine for testing subdirectory recovery
        }
import java.util.List;
                    for (String fileName : allFilesInDir) {
        private final EngineConfig engineConfig;
            .indices()
            } catch (Exception e) {
        @Override
        public Directory getDirectory() {
}
            subdirectoryDirectory.close();
    /**
            assertTrue("Non-segment files should be present in subdirectory", hasNonSegmentFiles);
            }
                    allFiles.addAll(segmentFiles);
import java.util.Optional;
import org.apache.lucene.index.SegmentInfos;
            return delegate.isDeleted();
            .put("index.number_of_shards", 1)
                GatedCloseable<IndexCommit> realCommit = super.acquireLastIndexCommit(false);
            }
    private void verifySubdirectoryFilesOnAllNodes(String indexName, int expectedCount) throws Exception {
            if (result.getResultType() == Engine.Result.Type.SUCCESS && engineConfig.getStartedPrimarySupplier().getAsBoolean()) {
            }
         * Creates a non-segment file in the subdirectory to test non-segment file metadata handling
import org.apache.lucene.store.IOContext;
            } catch (Exception e) {
                    }
        }
                for (String f : subdirectoryDirectory.listAll()) {
        }
        public String getSegmentsFileName() {
        @Override
                    base.close();
                IndexCommit originalCommit = realCommit.get();
        }
            return Collections.singletonList(TEST_ENGINE_INDEX_SETTING);
            return Optional.empty();
        }
            false,
            return delegate.getGeneration();
            .filter(plugin -> !plugin.getName().contains("MockEngineFactoryPlugin"))
        public long getGeneration() {
import org.apache.lucene.codecs.CodecUtil;
                }
                        return files;
                final SegmentInfos subInfos = SegmentInfos.readLatestCommit(subdirectoryDirectory);
            subdirectoryWriter.addDocument(doc);
/*
        ensureGreen("test_index");
        private final Path subdirectoryPath;
    }
                        }
            if (Files.exists(subdirectoryPath)) {
                continue; // Index not on this node
                createNonSegmentFile();
     */
        public Map<String, String> getUserData() throws IOException {
                    for (String fileName : filesInDir) {
        public GatedCloseable<IndexCommit> acquireSafeIndexCommit() throws EngineException {
                // Create a non-segment file to test non-segment file recovery
                };
            .prepareUpdateSettings("test_index")
            return delegate.getUserData();
            super(config);
            }
        public GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot() throws EngineException {
                }
            subdirectoryWriter = new IndexWriter(subdirectoryDirectory, writerConfig);
import java.util.Set;
        }
        @Override
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
            if (TEST_ENGINE_INDEX_SETTING.get(indexSettings.getSettings())) {
        client().admin().indices().prepareRefresh("test_index").get();
                    SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);
    @Override
        @Override
        }
                // Write a proper Lucene file with codec header and footer
            // First flush the main engine
            }
                CodecUtil.writeHeader(output, "test_metadata", 0);
                    }
            } catch (Exception e) {
            subdirectoryDirectory = FSDirectory.open(subdirectoryPath);
import org.opensearch.plugins.Plugin;
        }
            Files.createDirectories(subdirectoryPath);
            return delegate.getDirectory();
            Setting.Property.IndexScope
        // Add replica to trigger recovery
            String fileName = NON_SEGMENT_FILE_PREFIX + nonSegmentFileCounter++;
                        files.addAll(extra);
        client().admin()
            expectedCount,
        }
        private void addDocumentToSubdirectory(Index index) throws IOException {
    /**
                }
import org.opensearch.common.settings.Settings;
import org.apache.lucene.store.IndexOutput;
                subdirectoryWriter.commit();
import java.util.HashSet;
        static final Setting<Boolean> TEST_ENGINE_INDEX_SETTING = Setting.boolSetting(
            .collect(java.util.stream.Collectors.toList());
        );
            subdirectoryPath = shardPath.resolve(SUBDIRECTORY_NAME);
import java.io.IOException;
import org.opensearch.index.engine.InternalEngine;
 * compatible open source license.
                IndexCommit originalCommit = realCommit.get();
        private final Directory subdirectoryDirectory;
                output.writeLong(nonSegmentFileCounter);
package org.opensearch.plugin.store.subdirectory;
            try {
                        if (fileName.startsWith(TestEngine.NON_SEGMENT_FILE_PREFIX)) {
import java.util.Arrays;
            // Then commit the subdirectory
                        String relativePath = Path.of(TestEngine.SUBDIRECTORY_NAME, fileName).toString();
        }
                            allFiles.add(relativePath);
            }
            IndexWriterConfig writerConfig = new IndexWriterConfig();
        client().admin().indices().prepareFlush("test_index").get();
        @Override
                    }
        @Override
            IndexService indexService = indicesService.indexService(resolveIndex(indexName));
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            .put("index.store.factory", "subdirectory_store")
                // Write some test data
                    }
            IndexResult result = super.index(index);
        @Override
                    // Add non-segment files (test_metadata_*)
        }
        }
                        }
            .get();
            "Expected " + expectedCount + " nodes with subdirectory files, found: " + nodeFiles.keySet(),
        static final String SUBDIRECTORY_NAME = "test_subdirectory";
        // Verify subdirectory files were copied to both primary and replica
    static class TestIndexCommit extends IndexCommit {
                        if (fileName.startsWith(TestEngine.NON_SEGMENT_FILE_PREFIX)) {
    }
                        Set<String> files = new HashSet<>(super.getFiles(includeSegmentsFile));
                    // Get segment files
            return allFiles;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        private final IndexWriter subdirectoryWriter;
     */
                    String[] filesInDir = directory.listAll();
            try {
            }
 */
                throw new EngineException(shardId, "Failed to acquire last index commit", e);
    public static class TestEnginePlugin extends Plugin implements EnginePlugin {
            super.flush(force, waitIfOngoing);
import org.apache.lucene.index.IndexWriterConfig;
        // Verify all nodes have identical files (including non-segment files)
import org.opensearch.index.IndexSettings;
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
                    SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);
                    String[] allFilesInDir = directory.listAll();
                SegmentInfos mainInfos = ((SegmentInfosCatalogSnapshot) base.get()).getSegmentInfos();
            IndexShard shard = indexService.getShard(0);
                    Collection<String> segmentFiles = segmentInfos.files(true);
            Path shardPath = config.getStore().shardPath().getDataPath();
        Map<String, Set<String>> nodeFiles = new HashMap<>();
            boolean hasNonSegmentFiles = referenceFiles.stream().anyMatch(f -> f.startsWith(TestEngine.NON_SEGMENT_FILE_PREFIX));
     * Factory for creating TestEngine instances
            Set<String> allFiles = new HashSet<>(delegate.getFileNames());
            try {
                try (Directory directory = FSDirectory.open(subdirectoryPath)) {
        public IndexResult index(Index index) throws IOException {
        TestIndexCommit(IndexCommit delegate, Path subdirectoryPath) {
    static class TestEngine extends InternalEngine {
import java.util.Collections;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3)
import org.apache.lucene.index.IndexCommit;
        }
        return Arrays.asList(SubdirectoryStorePlugin.class, TestEnginePlugin.class);
import org.opensearch.index.shard.IndexShard;
        }
            for (Map.Entry<String, Set<String>> entry : nodeFiles.entrySet()) {
                    public Collection<String> getFiles(boolean includeSegmentsFile) throws IOException {
                try (Directory directory = FSDirectory.open(subdirectoryPath)) {
                TestIndexCommit testCommit = new TestIndexCommit(originalCommit, subdirectoryPath);
            Document doc = new Document();
            }
        @Override
     */
import org.apache.lucene.document.Document;
import org.opensearch.indices.IndicesService;
import java.util.Collection;
    static class TestEngineFactory implements EngineFactory {
                // Collect subdirectory file paths (prefixed with subdirectory name).
            }
            writerConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
 * The OpenSearch Contributors require contributions made to
 *
            // First, index the document normally
                realCommit.close();
                assertEquals("Node " + entry.getKey() + " should have identical files to other nodes", referenceFiles, entry.getValue());
        }
                return new GatedCloseable<>(wrapped, base::close);
        public List<Setting<?>> getSettings() {
            this.subdirectoryPath = subdirectoryPath;
            subdirectoryWriter.close();
            return delegate.getSegmentCount();
        }
        public void delete() {
            .put("index.number_of_replicas", 0)
    }
        assertEquals(
