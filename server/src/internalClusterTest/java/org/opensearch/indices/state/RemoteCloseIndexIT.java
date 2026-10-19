package org.opensearch.indices.state;
 * The OpenSearch Contributors require contributions made to  
    public static Collection<Object[]> parameters() {  
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);  
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;  
    protected Path remoteRepoPath;
 * SPDX-License-Identifier: Apache-2.0
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
public class RemoteCloseIndexIT extends CloseIndexIT {
 * compatible open source license.
 */  
            .put(super.indexSettings())
            .put(super.nodeSettings(nodeOrdinal))
    void assertNoFileBasedRecovery(String indexName) {
        }
        // skipping for remote store
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() },
    }
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s");
        return settingsBuilder;
import org.opensearch.index.IndexModule;
    protected static final String BASE_REMOTE_REPO = "test-rs-repo" + TEST_REMOTE_STORE_REPO_SUFFIX;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() }  
import org.opensearch.index.IndexSettings;
    }  
        return Settings.builder()
            .put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath))  
/*  
    public RemoteCloseIndexIT(Settings nodeSettings) {
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;  
import org.opensearch.common.settings.Settings;
    }  
    @ParametersFactory
import org.opensearch.core.common.unit.ByteSizeValue;  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.node.Node;  
import java.nio.file.Path;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        if (remoteRepoPath == null) {  
    protected Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
    }  
        }
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;  
        Settings.Builder settingsBuilder = Settings.builder()  
    protected final static String TEST_REMOTE_STORE_REPO_SUFFIX = "__rs";
 *
        super(nodeSettings);
import java.util.Collection;
}
            .build();
        );
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);  
    }  
            remoteRepoPath = randomRepoPath().toAbsolutePath();
import org.opensearch.core.common.unit.ByteSizeUnit;
        return Arrays.asList(
