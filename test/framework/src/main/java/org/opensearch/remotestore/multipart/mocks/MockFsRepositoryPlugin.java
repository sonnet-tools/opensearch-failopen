 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.remotestore.multipart.mocks;
        NamedXContentRegistry namedXContentRegistry,
public class MockFsRepositoryPlugin extends Plugin implements RepositoryPlugin {  
import java.util.Collections;  
 * SPDX-License-Identifier: Apache-2.0
        ClusterService clusterService,
            "fs_multipart_repository",  
}
import org.opensearch.core.xcontent.NamedXContentRegistry;
/*  
        return Collections.singletonMap(
 */  
import org.opensearch.indices.recovery.RecoverySettings;
        Environment env,  
    public Map<String, Repository.Factory> getRepositories(
 *
    }  
import java.util.Map;
        RecoverySettings recoverySettings  
import org.opensearch.env.Environment;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.repositories.Repository;
    ) {
            metadata -> new MockFsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
import org.opensearch.plugins.RepositoryPlugin;  
import org.opensearch.plugins.Plugin;
    public static final String TYPE = "fs_multipart_repository";
        );
    @Override
 * compatible open source license.
import org.opensearch.cluster.service.ClusterService;
