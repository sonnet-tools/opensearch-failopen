    protected BlobStore createBlobStore() throws Exception {
    }
        FsBlobStore fsBlobStore = (FsBlobStore) super.createBlobStore();  
 */  
}
    ) {
    @Override
        );  
    }
package org.opensearch.remotestore.mocks;
            fsBlobStore.bufferSizeInBytes(),
        false  
        triggerDataIntegrityFailure = TRIGGER_DATA_INTEGRITY_FAILURE.get(metadata.settings());
        NamedXContentRegistry namedXContentRegistry,
import org.opensearch.env.Environment;
 * compatible open source license.
    );
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.blobstore.fs.FsBlobStore;
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.blobstore.BlobStore;  
        "mock_fs_repository.trigger_data_integrity_failure",
import org.opensearch.indices.recovery.RecoverySettings;
    public MockFsMetadataSupportedRepository(
    public static Setting<Boolean> TRIGGER_DATA_INTEGRITY_FAILURE = Setting.boolSetting(
        ClusterService clusterService,  
    private final boolean triggerDataIntegrityFailure;  
        RepositoryMetadata metadata,  
            fsBlobStore.path(),  
            isReadOnly(),
        return new MockFsMetadataSupportedBlobStore(
import org.opensearch.common.settings.Setting;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.service.ClusterService;
            triggerDataIntegrityFailure
 *
        RecoverySettings recoverySettings
        Environment environment,
        super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings);  
import org.opensearch.repositories.fs.ReloadableFsRepository;  
/*  
public class MockFsMetadataSupportedRepository extends ReloadableFsRepository {
