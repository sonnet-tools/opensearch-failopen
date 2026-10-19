    protected static final String REMOTE_STORE_REPOSITORY_NAME = "test-remote-store-repo";
        Settings.Builder builder = Settings.builder();
        if (REMOTE_CLUSTER_STATE_ENABLED_SETTING.get(settings)) {
import java.util.Arrays;
        final ParameterizedStaticSettingsOpenSearchIntegTestCase other = (ParameterizedStaticSettingsOpenSearchIntegTestCase) obj;
        new Object[] { Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build() },
 * the new parameters and the test cluster has to be recreated.  
    private Path remoteStoreRepositoryPath;
import java.util.List;  
import java.nio.file.Path;
 * {@link #hasSameParametersAs(ParameterizedOpenSearchIntegTestCase)} is being used by the test scaffolding to detect when the test suite is instantiated with
 *
        return Objects.equals(settings, other.settings);
        new Object[] { Settings.builder().put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build() },
    public static final List<Object[]> remoteStoreSettings = Arrays.asList(  
            return false;  
 *   <li><b>test scope</b>: for each test method { create cluster -&gt; run test method -&gt; shutdown cluster }</li>
        super(nodeSettings);  
    public ParameterizedStaticSettingsOpenSearchIntegTestCase(Settings nodeSettings) {
 * SPDX-License-Identifier: Apache-2.0
        }  
    }  
 * </ul>  
/*  
    }
        }
/**  
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
 * The OpenSearch Contributors require contributions made to  
public abstract class ParameterizedStaticSettingsOpenSearchIntegTestCase extends ParameterizedOpenSearchIntegTestCase {
    protected Settings nodeSettings(int nodeOrdinal) {  
        if (obj == null) {
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * <ul>  
package org.opensearch.test;
    @Override
 */  
                remoteStoreRepositoryPath = randomRepoPath().toAbsolutePath();
            return false;
            return true;
 * compatible open source license.
    public static final List<Object[]> replicationSettings = Arrays.asList(  
        }
            builder.put(remoteStoreClusterSettings(REMOTE_STORE_REPOSITORY_NAME, remoteStoreRepositoryPath));  
    );  
        new Object[] { Settings.builder().put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false).build() }
 */
 * Here is the simple illustration on of the execution flow per parameters combination:
    boolean hasSameParametersAs(ParameterizedOpenSearchIntegTestCase obj) {  
    );  
            }
    }  
}
        return builder.put(super.nodeSettings(nodeOrdinal)).put(settings).build();
        if (getClass() != obj.getClass()) {  
            if (remoteStoreRepositoryPath == null) {  
        }
import org.opensearch.indices.replication.common.ReplicationType;
        new Object[] { Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build() }
import java.util.Objects;
import org.opensearch.common.settings.Settings;
        if (this == obj) {
 * Base class for running the tests with parameterization with static settings: the cluster will be pre-created with the settings at startup, the method
 *   <li><b>suite scope</b>: create cluster -&gt; for each test method { run test method } -&gt; shutdown cluster</li>
 * <p>
