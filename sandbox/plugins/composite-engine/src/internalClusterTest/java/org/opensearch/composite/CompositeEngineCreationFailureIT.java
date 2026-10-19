    }
        super.tearDown();  
                .put("index.pluggable.dataformat.enabled", true)
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.common.util.FeatureFlags;
        @Override
        }, 2, java.util.concurrent.TimeUnit.MINUTES);
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;  
            .build();
    }
                }
        return Arrays.asList(FileBackedDataFormatPlugin.class, CompositeDataFormatPlugin.class, FailOnCreationCommitterPlugin.class);  
import org.opensearch.index.engine.exec.commit.CommitterFactory;
 */  
                .build()  
        public Optional<CommitterFactory> getCommitterFactory(org.opensearch.index.IndexSettings indexSettings) {  
    private static final String INDEX_NAME = "test-creation-failure";
        failOnCreation.set(true);
import org.opensearch.plugins.Plugin;  
 * The OpenSearch Contributors require contributions made to  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                .putList("index.composite.secondary_data_formats")
    public void tearDown() throws Exception {
 * causes the shard to go UNASSIGNED after max allocation retries, not loop endlessly.
package org.opensearch.composite;
    public void testEngineCreationFailureShardGoesUnassigned() throws Exception {  
    public void setUp() throws Exception {  
        );
                if (failOnCreation.get()) {
/**  
import org.opensearch.plugins.EnginePlugin;
                return new InMemoryCommitter(config.engineConfig().getStore());
            });  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override  
        failOnCreation.set(false);
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Optional;  
    @Override
 *
import org.opensearch.cluster.metadata.IndexMetadata;
}  
    }
                .put("index.composite.primary_data_format", FileBackedDataFormatPlugin.FORMAT_NAME)
        return Settings.builder()
import org.opensearch.index.engine.dataformat.stub.FileBackedDataFormatPlugin;
        FileBackedDataFormatPlugin.setDataDirectory(createTempDir("filebacked"));
            .put(super.nodeSettings(nodeOrdinal))  
 */  
import org.opensearch.cluster.routing.ShardRouting;
            return Optional.of(config -> {
    }
import java.util.concurrent.atomic.AtomicBoolean;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import java.io.IOException;  
    }  
        // Shard should go UNASSIGNED after max retries — not loop endlessly  
 * this file be licensed under the Apache-2.0 license or a
    }
 * compatible open source license.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    @Override
 * Verifies that persistent engine creation failure (e.g., disk full during committer init)
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
        assertBusy(() -> {
import java.util.Collection;
        createIndex(  
        failOnCreation.set(false);
        super.setUp();  
            assertTrue("shard should be unassigned after persistent creation failure", primary.unassigned());  
            Settings.builder()
            ShardRouting primary = clusterService().state().routingTable().index(INDEX_NAME).shard(0).primaryShard();
                    throw new IOException("simulated engine creation failure (disk full)");  
                .put("index.pluggable.dataformat", "composite")  
    private static final AtomicBoolean failOnCreation = new AtomicBoolean(false);
    public static class FailOnCreationCommitterPlugin extends Plugin implements EnginePlugin {
public class CompositeEngineCreationFailureIT extends OpenSearchIntegTestCase {
/*  
import org.opensearch.common.settings.Settings;  
    @Override  
        }
            INDEX_NAME,
