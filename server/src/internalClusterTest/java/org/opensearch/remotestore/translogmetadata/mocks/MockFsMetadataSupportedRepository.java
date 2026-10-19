    public static Setting<Boolean> TRIGGER_DATA_INTEGRITY_FAILURE = Setting.boolSetting(
        super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, nativeStoreProvider);  
    private final boolean triggerDataIntegrityFailure;
import org.opensearch.env.Environment;
    @Override
    public MockFsMetadataSupportedRepository(
    }
        Environment environment,
        RecoverySettings recoverySettings,  
/*  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
        NamedXContentRegistry namedXContentRegistry,
public class MockFsMetadataSupportedRepository extends ReloadableFsRepository {  
            fsBlobStore.path(),  
        return new MockFsMetadataSupportedBlobStore(
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.indices.recovery.RecoverySettings;
        RepositoryMetadata metadata,
        FsBlobStore fsBlobStore = (FsBlobStore) super.createBlobStore();  
        ClusterService clusterService,
 * The OpenSearch Contributors require contributions made to  
            triggerDataIntegrityFailure
        ClusterService clusterService,
        );  
    );
    protected BlobStore createBlobStore() throws Exception {
import org.opensearch.common.blobstore.fs.FsBlobStore;
        "mock_fs_repository.trigger_data_integrity_failure",  
        RecoverySettings recoverySettings
import org.opensearch.repositories.fs.ReloadableFsRepository;
        this(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, null);
    public MockFsMetadataSupportedRepository(  
            isReadOnly(),
 * compatible open source license.
package org.opensearch.remotestore.translogmetadata.mocks;
import org.opensearch.cluster.metadata.RepositoryMetadata;
        NamedXContentRegistry namedXContentRegistry,  
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;  
        triggerDataIntegrityFailure = TRIGGER_DATA_INTEGRITY_FAILURE.get(metadata.settings());
import org.opensearch.common.blobstore.BlobStore;  
 *
        Environment environment,  
    ) {  
        NativeRemoteObjectStoreProvider nativeStoreProvider
    }
}
 */  
 * SPDX-License-Identifier: Apache-2.0
            fsBlobStore.bufferSizeInBytes(),
    ) {
import org.opensearch.cluster.service.ClusterService;
        RepositoryMetadata metadata,
        false
