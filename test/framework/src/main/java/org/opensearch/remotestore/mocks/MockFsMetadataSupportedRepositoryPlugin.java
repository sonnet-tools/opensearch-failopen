    ) {
import org.opensearch.plugins.Plugin;
            metadata -> new MockFsMetadataSupportedRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
import org.opensearch.cluster.service.ClusterService;
    public static final String TYPE_MD = "fs_metadata_supported_repository";
import java.util.Collections;  
package org.opensearch.remotestore.mocks;
import java.util.Map;
public class MockFsMetadataSupportedRepositoryPlugin extends Plugin implements RepositoryPlugin {  
import org.opensearch.repositories.Repository;
        ClusterService clusterService,
    public Map<String, Repository.Factory> getRepositories(
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        NamedXContentRegistry namedXContentRegistry,
}
        Environment env,  
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.env.Environment;  
import org.opensearch.indices.recovery.RecoverySettings;
 * compatible open source license.
        );
 *
    }  
        return Collections.singletonMap(
import org.opensearch.plugins.RepositoryPlugin;  
    @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;
/*  
        RecoverySettings recoverySettings  
            "fs_metadata_supported_repository",  
