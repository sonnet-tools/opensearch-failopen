public class MockFsMetadataSupportedRepositoryPlugin extends Plugin implements RepositoryPlugin {  
 * this file be licensed under the Apache-2.0 license or a
            "fs_metadata_supported_repository",  
    public static final String TYPE_MD = "fs_metadata_supported_repository";
import org.opensearch.plugins.Plugin;
        NamedXContentRegistry namedXContentRegistry,
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    public Map<String, Repository.Factory> getRepositories(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        ClusterService clusterService,
 *
import org.opensearch.indices.recovery.RecoverySettings;
        return Collections.singletonMap(
}
 */  
import org.opensearch.repositories.Repository;
import java.util.Collections;  
import java.util.Map;
/*  
        RecoverySettings recoverySettings  
        );
import org.opensearch.plugins.RepositoryPlugin;  
import org.opensearch.env.Environment;  
package org.opensearch.remotestore.translogmetadata.mocks;
            metadata -> new MockFsMetadataSupportedRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
    @Override
    ) {
 * SPDX-License-Identifier: Apache-2.0
        Environment env,  
    }  
import org.opensearch.cluster.service.ClusterService;
