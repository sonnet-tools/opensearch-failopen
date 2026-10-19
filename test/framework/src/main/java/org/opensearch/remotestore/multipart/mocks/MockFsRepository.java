    @Override
        NativeRemoteObjectStoreProvider nativeStoreProvider
    protected BlobStore createBlobStore() throws Exception {  
        Environment environment,
 * this file be licensed under the Apache-2.0 license or a
public class MockFsRepository extends FsRepository {  
 * compatible open source license.
package org.opensearch.remotestore.multipart.mocks;
import org.opensearch.cluster.service.ClusterService;
 * The OpenSearch Contributors require contributions made to  
    );
import org.opensearch.common.settings.Setting;
import org.opensearch.indices.recovery.RecoverySettings;
        RepositoryMetadata metadata,  
     * Variant that also wires a native store provider, for tests whose shards need a live
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;  
     */
        false
        ClusterService clusterService,
}
    ) {  
 *
        Environment environment,
        RecoverySettings recoverySettings
        return new MockFsBlobStore(fsBlobStore.bufferSizeInBytes(), fsBlobStore.path(), isReadOnly(), triggerDataIntegrityFailure);
        NamedXContentRegistry namedXContentRegistry,
    public MockFsRepository(
        super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, nativeStoreProvider);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }  
import org.opensearch.common.blobstore.BlobStore;  
    }  
 */  
        FsBlobStore fsBlobStore = (FsBlobStore) super.createBlobStore();
    ) {  
/*  
    }
import org.opensearch.env.Environment;
        RepositoryMetadata metadata,
    private final boolean triggerDataIntegrityFailure;
     * {@code NativeStoreRepository} (e.g. warm Parquet shards in the sandbox composite engine).  
        NamedXContentRegistry namedXContentRegistry,  
        ClusterService clusterService,  
import org.opensearch.repositories.fs.FsRepository;
        "mock_fs_repository.trigger_data_integrity_failure",  
import org.opensearch.common.blobstore.fs.FsBlobStore;
     * remote store fencing requires.  
     * Such tests would otherwise have to substitute a plain {@link FsRepository} for this repo type
    public static Setting<Boolean> TRIGGER_DATA_INTEGRITY_FAILURE = Setting.boolSetting(
     * and would silently lose the mock's behaviour, including the conditional-write support that
        triggerDataIntegrityFailure = TRIGGER_DATA_INTEGRITY_FAILURE.get(metadata.settings());
        this(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, null);
    public MockFsRepository(  
        RecoverySettings recoverySettings,
    /**
import org.opensearch.cluster.metadata.RepositoryMetadata;
