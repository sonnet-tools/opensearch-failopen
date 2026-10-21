        final S3AsyncService s3AsyncService,
    static final Setting<ByteSizeValue> CHUNK_SIZE_SETTING = Setting.byteSizeSetting(
    public NativeStoreRepository getNativeStore() {
        this.asyncUploadUtils = asyncUploadUtils;
            lowPrioritySizeBasedBlockingQ,
    }
            multipartUploadEnabled,
            bulkDeletesSize,
        "parallel_multipart_upload.minimum_part_size",
            multipartUploadEnabled,
        restrictedSettings.add(BUCKET_SETTING);
    );
        if (nativeStoreProvider != null) {
        Math.max(
    private static void validateCannedACL(String cannedACLStringValue) {
        DEFAULT_BUFFER_SIZE,
                    + ")."
            serverSideEncryptionBucketKey,
        this.bulkDeletesSize = BULK_DELETE_SIZE.get(metadata.settings());
            urgentExecutorBuilder,
    private static final ByteSizeValue DEFAULT_BUFFER_SIZE = new ByteSizeValue(
        // Reload configs for S3Repository
            serverSideEncryptionType,
    /**
     * @see <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/multiobjectdeleteapi.html">S3 Documentation</a>.
        ),
     * Percentage of total available permits to be available for priority transfers.
 */
    S3Repository(
            bucket,
            );
        this.genericStatsMetricPublisher = genericStatsMetricPublisher;
     *
        final GenericStatsMetricPublisher genericStatsMetricPublisher,
    // only use for testing (S3RepositoryTests)
    );
        "chunk_size",
import org.opensearch.core.action.ActionListener;
            metadata,
import org.opensearch.common.blobstore.BlobStore;
        final boolean multipartUploadEnabled,
        );
        MIN_PART_SIZE_USING_MULTIPART,
            metadata,
            normalPrioritySizeBasedBlockingQ,
import org.apache.logging.log4j.LogManager;
        "server_side_encryption_encryption_context"
        Setting.Property.NodeScope
            throw new RepositoryException(
     */
 */
    /**
     * Minimum threshold below which the chunk is uploaded using a single request. Beyond this threshold,
    }
        final S3Service service,
        );
     * use of the Multipart API and may result in upload errors. Defaults to the minimum between 100MB and 5% of the heap size.
import org.opensearch.cluster.metadata.Metadata;
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
    /**
        CRT_ASYNC_HTTP_CLIENT_TYPE,
        final RecoverySettings recoverySettings,
    /**
        validateHttpClientType(S3_ASYNC_HTTP_CLIENT_TYPE.get(settings));
    /**
        "redirect_large_s3_upload",
            this.basePath = BlobPath.cleanPath();
        return true;
    static final Setting<Boolean> SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING = Setting.boolSetting(
        if (cancellable != null) {
        Setting.Property.NodeScope
        10,
        // Reload configs for S3RepositoryPlugin
        return nativeStore;
        s3AsyncService.releaseCachedClients();
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
 * license agreements. See the NOTICE file distributed with
     */
            multipartUploadEnabled,
        "s3_priority_permit_alloc_perc",
    ) {
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        final AsyncExecutorContainer priorityExecutorBuilder,
        super.validateMetadata(newRepositoryMetadata);
    private final AsyncTransferManager asyncUploadUtils;
            urgentExecutorBuilder,
     * Whether large uploads need to be redirected to slow sync s3 client.
 * KIND, either express or implied.  See the License for the
        this.lowPrioritySizeBasedBlockingQ = lowPrioritySizeBasedBlockingQ;
    private volatile boolean serverSideEncryptionBucketKey;
            || httpClientType.equalsIgnoreCase(CRT_ASYNC_HTTP_CLIENT_TYPE))) {
import org.opensearch.cluster.metadata.RepositoryMetadata;
    private volatile String expectedBucketOwner;
        // Reload configs for S3BlobStore
            } else if (store != null && store != NativeStoreRepository.EMPTY) {
    }
        this.cannedACL = CANNED_ACL_SETTING.get(metadata.settings());
            genericStatsMetricPublisher,
     * closed concurrently.
    );
 * this work for additional information regarding copyright
        this(
        "s3_transfer_queue_consumers",
        );
        this.storageClass = STORAGE_CLASS_SETTING.get(metadata.settings());
        return chunkSize;
        80,
            normalExecutorBuilder,
        this.chunkSize = CHUNK_SIZE_SETTING.get(metadata.settings());
        List<Setting<?>> restrictedSettings = new ArrayList<>();
        long repositoryStateId,
        final AsyncExecutorContainer urgentExecutorBuilder,
            snapshotInfo,
    /**
import org.opensearch.repositories.RepositoryException;
        new ByteSizeValue(1, ByteSizeUnit.GB),
 * Shared file system repository supports the following settings
    );
            storageClass,
    @Override
    }
    @Override
            recoverySettings,
import java.util.List;
        logger.debug(
            );
    static final Setting<Boolean> REDIRECT_LARGE_S3_UPLOAD = Setting.boolSetting(
            // provided repository settings
            if (store != null && store.isLive()) {
            repositoryMetaVersion,
            if (cur.toString().equalsIgnoreCase(cannedACLStringValue)) {
            asyncUploadUtils,
    private final AtomicReference<Scheduler.Cancellable> finalizationFuture = new AtomicReference<>();
     * Default is to use 100MB (S3 defaults) for heaps above 2GB and 5% of
 * <dt>{@code chunk_size}</dt>
        if (CHUNK_SIZE_SETTING.get(settings).getBytes() < BUFFER_SIZE_SETTING.get(settings).getBytes()) {
    );
        Collection<SnapshotId> snapshotIds,
    S3Repository(
     * Duration in minutes to wait for a permit in case no permit is available.
     * Defaults to bucket_default (no SSE header sent, lets bucket decide).
        BUCKET_DEFAULT_ENCRYPTION_TYPE,
package org.opensearch.repositories.s3;
        final SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ,
        if (Strings.hasLength(basePath)) {
    /**
    static final ByteSizeValue MIN_PART_SIZE_USING_MULTIPART = new ByteSizeValue(5, ByteSizeUnit.MB);
 * the Apache License, Version 2.0 (the "License"); you may
            serverSideEncryptionBucketKey,
            throw new BlobStoreException("`" + storageClassStringValue + "` is not a valid S3 Storage Class.");
 * Licensed to Elasticsearch under one or more contributor
        if (storageClass == StorageClass.UNKNOWN_TO_SDK_VERSION) {
        throw new BlobStoreException("cannedACL is not valid: [" + cannedACLStringValue + "]");
    private volatile String bucket;
        readRepositoryMetadata();
                || value.equals(ServerSideEncryption.AWS_KMS.toString())
            logger.debug("Repository [{}] closed during cool-down period", metadata.name());
            serverSideEncryptionKmsKey,
                return;
        true,
import software.amazon.awssdk.services.s3.model.StorageClass;
    // Used by test classes
        final SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ,
                    + ") can't be lower than "
     */
            bucket,
        final S3Service service,
    static final Setting<ByteSizeValue> BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
        this(
        }
    }
    );
        "permit_backed_transfer_enabled",
                    + " ("
    private final SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;
     * standard_ia, onezone_ia and intelligent_tiering. Defaults to standard.
                "s3_repository_secret_settings",
    );
 *
    private volatile BlobPath basePath;
     */
        (s) -> Setting.parseInt(s, 5, "s3_transfer_queue_consumers"),
            throw new BlobStoreException("Glacier storage class is not supported");
        nativeStore.close();
        validateStorageClass(STORAGE_CLASS_SETTING.get(settings));
    }
    /**
 * compatible open source license.
        final AsyncTransferManager asyncUploadUtils,
     * Maximum number of deletes in a DeleteObjectsRequest.
            repositoryUpdatePriority,
 * software distributed under the License is distributed on an
        super.doClose();
    private final SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;
        }
        "server_side_encryption_type",
        readRepositoryMetadata();
    @Override
            return;
    }
    @Override
        "server_side_encryption_bucket_key_enabled",
        MIN_PART_SIZE_USING_MULTIPART,
import org.opensearch.common.Priority;
    }
            service,
    protected ByteSizeValue chunkSize() {
        if (S3ClientSettings.checkDeprecatedCredentials(metadata.settings())) {
        MAX_PART_SIZE_USING_MULTIPART
import org.opensearch.snapshots.SnapshotId;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under
     */
    private final S3Service service;
            s3AsyncService,
            bufferSize,
    static final Setting<String> BASE_PATH_SETTING = Setting.simpleString("base_path");
     */
    /**
            urgentExecutorBuilder,
        final boolean multipartUploadEnabled,
     */
    /**
        Function<ClusterState, ClusterState> stateTransformer,
        return basePath;
    );
                    + BUFFER_SIZE_SETTING.getKey()
    static final Setting<String> CLIENT_NAME = new Setting<>("client", "default", Function.identity());
        if (BUCKET_SETTING.get(settings) == null) {
        this.pluginConfigPath = pluginConfigPath;
     * Number of transfer queue consumers
        validateRepositoryMetadata(metadata);
    );
     */
    static final Setting<String> SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING = Setting.simpleString(
        if ((cannedACLStringValue == null) || cannedACLStringValue.equals("")) {
import java.util.Map;
                    + BUFFER_SIZE_SETTING.get(settings)
    @Override
        Settings settings = newRepositoryMetadata.settings();
    private final AsyncExecutorContainer priorityExecutorBuilder;
    /** An override for the s3 region to use for signing requests. */
        5,
        final NativeRemoteObjectStoreProvider nativeStoreProvider
        // Initialize native store if provider is available (sandbox warm nodes only)
        true,
 * SPDX-License-Identifier: Apache-2.0
    static final Setting<Boolean> LEGACY_MD5_CHECKSUM_CALCULATION = Setting.boolSetting("legacy_md5_checksum_calculation", false);
    static final String BUCKET_DEFAULT_ENCRYPTION_TYPE = "bucket_default";
            serverSideEncryptionEncryptionContext,
        final StorageClass storageClass = StorageClass.fromValue(storageClassStringValue.toUpperCase(Locale.ENGLISH));
        final ClusterService clusterService,
 * specific language governing permissions and limitations
        }
            cannedACL,
        final S3AsyncService s3AsyncService,
import java.util.Locale;
        long repositoryStateId,
import org.opensearch.common.settings.Settings;
        Path pluginConfigPath,
        final S3AsyncService s3AsyncService,
import java.util.function.Function;
        "s3_permit_wait_duration_min",
        }
            null
    public void finalizeSnapshot(
    public boolean isReloadable() {
        restrictedSettings.addAll(super.getRestrictedSystemRepositorySettings());
     */
        }
        final NamedXContentRegistry namedXContentRegistry,
/**
            if (!(value.equals(ServerSideEncryption.AES256.toString())
            normalPrioritySizeBasedBlockingQ,
     * Constructs an s3 backed repository with optional native store provider.
    // package access for tests
     */
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(logger.getName());
 *    http://www.apache.org/licenses/LICENSE-2.0
     * This setting controls whether parallel multipart uploads will be used when calling S3 or not
        final NamedXContentRegistry namedXContentRegistry,
        }
            storageClass,
import org.opensearch.repositories.s3.async.AsyncTransferManager;
    }
        if (!(httpClientType.equalsIgnoreCase(NETTY_ASYNC_HTTP_CLIENT_TYPE)
    /** The access key to authenticate with s3. This setting is insecure because cluster settings are stored in cluster state */
        70,
     */
            listener
    @Override
    private final boolean multipartUploadEnabled;
                "Using s3 access/secret key from repository settings. Instead "
    private static Map<String, String> buildLocation(RepositoryMetadata metadata) {
     */
     * The type of S3 Server Side Encryption to use.
     * the S3 repository will use the AWS Multipart Upload API to split the chunk into several parts, each of buffer_size length, and
        if ((storageClassStringValue == null) || storageClassStringValue.equals("")) {
        this.expectedBucketOwner = EXPECTED_BUCKET_OWNER_SETTING.get(metadata.settings());
    );
            genericStatsMetricPublisher
     * Optional additional encryption context passed to S3 for use in KMS crypto operations. The setting value must be formatted as a key-value pair JSON object.
import org.opensearch.core.common.unit.ByteSizeValue;
            priorityExecutorBuilder,
     */
            pluginConfigPath,
            service,
    /**
     */
    public void validateMetadata(RepositoryMetadata newRepositoryMetadata) {
    );
import org.opensearch.common.settings.Setting;
        Setting.Property.NodeScope
        final ClusterService clusterService,
        }
    /**
     */
            }
        );
        new ByteSizeValue(5, ByteSizeUnit.TB)
    static final ByteSizeValue MAX_FILE_SIZE = new ByteSizeValue(5, ByteSizeUnit.GB);
     */
        super.finalizeSnapshot(
            throw new IllegalArgumentException("expected_bucket_owner must be a 12 digit AWS account id");
import org.opensearch.threadpool.Scheduler;
        final RepositoryMetadata metadata,
    /**
        Setting.Property.NodeScope
            expectedBucketOwner
import org.opensearch.snapshots.SnapshotInfo;
import java.util.ArrayList;
        }
        }
            return;
import org.opensearch.common.settings.SecureSetting;
        true,
    static final Setting<String> EXPECTED_BUCKET_OWNER_SETTING = Setting.simpleString("expected_bucket_owner", value -> {
            namedXContentRegistry,
import org.opensearch.indices.recovery.RecoverySettings;
    }
    private volatile String serverSideEncryptionKmsKey;
    static final Setting<SecureString> SECRET_KEY_SETTING = SecureSetting.insecureString("secret_key");
            priorityExecutorBuilder,
    ) {
     * Reloads the values derived from the Repository Metadata
        if (!(value.matches("\\d{12}") || value.isEmpty())) {
     */
    public static final String CRT_ASYNC_HTTP_CLIENT_TYPE = "crt";
    private final AsyncExecutorContainer urgentExecutorBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * <dt>{@code bucket}</dt><dd>S3 bucket</dd>
        21,
 * Modifications Copyright OpenSearch Contributors. See
 * <dl>
        this.serverSideEncryptionBucketKey = SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING.get(metadata.settings());
            shardGenerations,
                CHUNK_SIZE_SETTING.getKey()
        final GenericStatsMetricPublisher genericStatsMetricPublisher
    public void deleteSnapshots(
        this.bucket = BUCKET_SETTING.get(metadata.settings());
     * Supports: AES256, aws:kms
        final ClusterService clusterService,
        // We make sure that chunkSize is bigger or equal than/to bufferSize
                this.nativeStore = store;
    );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
            this.basePath = new BlobPath().add(basePath);
    }
            }
    public static Setting<Integer> S3_TRANSFER_QUEUE_CONSUMERS = new Setting<>(
 * The OpenSearch Contributors require contributions made to
    static final Setting<String> BUCKET_SETTING = Setting.simpleString("bucket");
}
                    + " ("
                    + "store these in named clients and the opensearch keystore for secure settings."
        );
    /**
     * Maximum size of files that can be uploaded using a single upload request.
     */
                    + CHUNK_SIZE_SETTING.get(settings)
     * Sets the S3 storage class type for the backup files. Values may be standard, reduced_redundancy,
 * <dt>{@code base_path}</dt><dd>Specifies the path within bucket to repository data. Defaults to root directory.</dd>
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.monitor.jvm.JvmInfo;
        ShardGenerations shardGenerations,
    static final Setting<Integer> BULK_DELETE_SIZE = Setting.intSetting("bulk_delete_size", 1000, 1, 1000);
import java.util.Collection;
    static final Setting<ByteSizeValue> PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING = Setting.byteSizeSetting(
        ActionListener<RepositoryData> listener
        if (isReloadable() == false) {
        final NamedXContentRegistry namedXContentRegistry,
            s3AsyncService,
 * You may obtain a copy of the License at
    /**
import org.opensearch.core.common.Strings;
        final GenericStatsMetricPublisher genericStatsMetricPublisher
        final AsyncExecutorContainer normalExecutorBuilder,
import org.opensearch.common.logging.DeprecationLogger;
        final S3Service service,
 * under the License.
            cannedACL,
            recoverySettings,
    void validateHttpClientType(String httpClientType) {
    @Override
    protected BlobStore getBlobStore() {
            bufferSize,
    @Override
        ByteSizeUnit.MB.toBytes(16),
    @Override
        super.deleteSnapshots(snapshotIds, repositoryStateId, repositoryMetaVersion, listener);
            Path.of(""),
        Priority repositoryUpdatePriority,
    /**
    );
    @Override
import org.opensearch.repositories.RepositoryData;
    ) {
        }
            normalExecutorBuilder,
        final RepositoryMetadata metadata,
     * Type of Async client to be used for S3 Uploads. Defaults to crt.
    private final S3AsyncService s3AsyncService;
import java.nio.file.Path;
    public void reload(RepositoryMetadata newRepositoryMetadata) {
    static final String TYPE = "s3";
    private static void validateStorageClass(String storageClassStringValue) {
    /**
            clusterMetadata,
        return Map.of("base_path", BASE_PATH_SETTING.get(metadata.settings()), "bucket", BUCKET_SETTING.get(metadata.settings()));
    private volatile int bulkDeletesSize;
        this.bufferSize = BUFFER_SIZE_SETTING.get(metadata.settings());
        service.settings(metadata);
        }
    private static final Logger logger = LogManager.getLogger(S3Repository.class);
     * Whether large uploads need to be redirected to slow sync s3 client.
     */
            throw new BlobStoreException("Invalid http client type. `" + httpClientType + "`");
    /**
            genericStatsMetricPublisher,
        // s3 is always server side encrypted.
            normalPrioritySizeBasedBlockingQ,
    private void readRepositoryMetadata() {
     */
            repositoryStateId,
            service,
            lowPrioritySizeBasedBlockingQ,
        final RepositoryMetadata metadata,
        return true;
     */
     * Constructs an s3 backed repository
        final SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ,
    /**
        s3AsyncService.settings(metadata);
        final String basePath = BASE_PATH_SETTING.get(metadata.settings());
        Setting.Property.NodeScope
     * Whether to use S3 Bucket Keys along with SSE-KMS.
    }
        this.serverSideEncryptionKmsKey = SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING.get(metadata.settings());
    /**
import org.opensearch.repositories.blobstore.MeteredBlobStoreRepository;
    }
    );
    private volatile ByteSizeValue chunkSize;
    public boolean isSeverSideEncryptionEnabled() {
            serverSideEncryptionType,
        final SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ,
    static final Setting<String> STORAGE_CLASS_SETTING = Setting.simpleString("storage_class");
    }
    private final AsyncExecutorContainer normalExecutorBuilder;
    static final Setting<Boolean> PERMIT_BACKED_TRANSFER_ENABLED = Setting.boolSetting(
     * Specifies the path within bucket to repository data. Defaults to root directory.
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
    protected void doClose() {
    static final Setting<SecureString> ACCESS_KEY_SETTING = SecureSetting.insecureString("access_key");
     */
import org.opensearch.cluster.ClusterState;
 * <dd>Large file can be divided into chunks. This parameter specifies the chunk size. Defaults to not chucked.</dd>
        this.priorityExecutorBuilder = priorityExecutorBuilder;
    }
        }
    private void validateRepositoryMetadata(RepositoryMetadata newRepositoryMetadata) {
    }
        for (final ObjectCannedACL cur : ObjectCannedACL.values()) {
    }
        final RecoverySettings recoverySettings,
class S3Repository extends MeteredBlobStoreRepository {
    });
     * Defaults to true.
            deprecationLogger.deprecate(
    /**
    public static Setting<Integer> S3_PERMIT_WAIT_DURATION_MIN = Setting.intSetting(
        final AsyncExecutorContainer priorityExecutorBuilder,
     */
        if (blobStoreProvider.get() != null) {
    /** Native (Rust) object store — created during construction if native provider is available. */
import org.opensearch.repositories.ShardGenerations;
    @Override
        Version repositoryMetaVersion,
        "parallel_multipart_upload.enabled",
    public List<Setting<?>> getRestrictedSystemRepositorySettings() {
            blobStoreProvider.get().reloadBlobStore(newRepositoryMetadata);
    @Override
        Setting.Property.NodeScope
            clusterService,
     * Holds a reference to delayed repository operation {@link Scheduler.Cancellable} so it can be cancelled should the repository be
    private volatile String storageClass;
            final NativeStoreRepository store = nativeStoreProvider.createNativeStore(metadata, clusterService.getSettings());
    /** The secret key to authenticate with s3. This setting is insecure because cluster settings are stored in cluster state */
        }
            asyncUploadUtils,
    /**
        this.serverSideEncryptionEncryptionContext = SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING.get(metadata.settings());
        final AsyncExecutorContainer urgentExecutorBuilder,
        ActionListener<RepositoryData> listener
    ) {
                store.close();
 * <dt>{@code concurrent_streams}</dt><dd>Number of concurrent read/write stream (per repository on each node). Defaults to 5.</dd>
                throw new IllegalArgumentException("server_side_encryption_type must be one of [AES256, aws:kms, bucket_default]");
        Version repositoryMetaVersion,
        new ByteSizeValue(5, ByteSizeUnit.MB),
    }
    }
    private volatile String serverSideEncryptionEncryptionContext;
        Setting.Property.NodeScope
    static final ByteSizeValue MAX_FILE_SIZE_USING_MULTIPART = new ByteSizeValue(5, ByteSizeUnit.TB);
            "using bucket [{}], chunk_size [{}], buffer_size [{}], cannedACL [{}], storageClass [{}], "
     * Whether retry on uploads are enabled. This setting wraps inputstream with buffered stream to enable retries.
            clusterService,
import org.apache.logging.log4j.Logger;
    static final Setting<String> SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING = Setting.simpleString("server_side_encryption_kms_key_id");
        return new S3BlobStore(
        MAX_PART_SIZE_USING_MULTIPART,
            Math.min(ByteSizeUnit.MB.toBytes(100), JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() / 20)
        this.normalPrioritySizeBasedBlockingQ = normalPrioritySizeBasedBlockingQ;
            chunkSize,
     * Big files can be broken down into chunks during snapshotting if needed. Defaults to 1g.
        this.s3AsyncService = s3AsyncService;
     * (see http://docs.aws.amazon.com/AmazonS3/latest/dev/qfacts.html)
        "buffer_size",
            }
    /**
    ) {
        SnapshotInfo snapshotInfo,
 *
     */
     * Minimum size of parts that can be uploaded using the Multipart Upload API.
        Setting.Property.NodeScope
     * the available memory for smaller heaps.
        value -> {
     * Maximum size of parts that can be uploaded using the Multipart Upload API.
    public static Setting<Integer> S3_PRIORITY_PERMIT_ALLOCATION_PERCENT = Setting.intSetting(
        (s) -> Integer.toString(Math.max(5, OpenSearchExecutors.allocatedProcessors(s) * 2)),
 *
        super.reload(newRepositoryMetadata);
        service.releaseCachedClients();
        super(metadata, namedXContentRegistry, clusterService, recoverySettings, buildLocation(metadata));
            ByteSizeUnit.MB.toBytes(5), // minimum value
    /**
        if (storageClass.equals(StorageClass.GLACIER)) {
            lowPrioritySizeBasedBlockingQ,
        } else {
     */
    private final GenericStatsMetricPublisher genericStatsMetricPublisher;
        final SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ,
        ByteSizeUnit.BYTES
/*
     * The KMS key id to be used for SSE-KMS. Must be used when server_side_encryption_type setting is set to aws:kms.
        final Scheduler.Cancellable cancellable = finalizationFuture.getAndSet(null);
    /**
    }
        validateCannedACL(CANNED_ACL_SETTING.get(settings));
     * Maximum size of files that can be uploaded using the Multipart Upload API.
        final AsyncExecutorContainer normalExecutorBuilder,
     */
    /**
        final AsyncExecutorContainer priorityExecutorBuilder,
     * The S3 repository supports all S3 canned ACLs : private, public-read, public-read-write,
    private final Path pluginConfigPath;
            stateTransformer,
    @Override
            serverSideEncryptionEncryptionContext,
    private volatile ByteSizeValue bufferSize;
 * <p>
            return;
        final AsyncTransferManager asyncUploadUtils,
    );
        validateRepositoryMetadata(newRepositoryMetadata);
    private volatile String cannedACL;
        1,
            metadata,
        final boolean multipartUploadEnabled,
        this.service = service;
 */
        ByteSizeUnit.BYTES
    static final ByteSizeValue MAX_PART_SIZE_USING_MULTIPART = MAX_FILE_SIZE;
            asyncUploadUtils,
            throw new RepositoryException(newRepositoryMetadata.name(), "No bucket defined for s3 repository");
            namedXContentRegistry,
            serverSideEncryptionKmsKey,
                || value.equals(BUCKET_DEFAULT_ENCRYPTION_TYPE))) {
        return super.getBlobStore();
     * Optional setting to specify the expected S3 bucket owner. This is used to verify S3 bucket ownership before reading/writing data from/to a bucket.
     */
import org.opensearch.core.common.settings.SecureString;
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
        this.multipartUploadEnabled = multipartUploadEnabled;
     * authenticated-read, log-delivery-write, bucket-owner-read, bucket-owner-full-control. Defaults to private.
    static final Setting<String> SERVER_SIDE_ENCRYPTION_TYPE_SETTING = Setting.simpleString(
import org.opensearch.common.blobstore.BlobStoreException;
import org.opensearch.repositories.NativeStoreRepository;
        final SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ,
        restrictedSettings.add(BASE_PATH_SETTING);
    }
    public static final String NETTY_ASYNC_HTTP_CLIENT_TYPE = "netty";
        DEFAULT_MULTIPART_UPLOAD_MINIMUM_PART_SIZE,
                + "server_side_encryption_type [{}], server_side_encryption_kms_key_id [{}], server_side_encryption_bucket_key_enabled [{}], server_side_encryption_encryption_context [{}], expected_bucket_owner [{}], ",
     * to upload each part in its own request. Note that setting a buffer size lower than 5mb is not allowed since it will prevents the
                newRepositoryMetadata.name(),
 */
    static final Setting<String> S3_ASYNC_HTTP_CLIENT_TYPE = Setting.simpleString(
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
            expectedBucketOwner
    /**
        this.normalExecutorBuilder = normalExecutorBuilder;
     */
        this.serverSideEncryptionType = SERVER_SIDE_ENCRYPTION_TYPE_SETTING.get(metadata.settings());
    public BlobPath basePath() {
        Path pluginConfigPath,
        final AsyncExecutorContainer normalExecutorBuilder,
 * </dl>
            normalExecutorBuilder,
import org.opensearch.cluster.service.ClusterService;
     * (see http://docs.aws.amazon.com/AmazonS3/latest/dev/qfacts.html)
    private volatile NativeStoreRepository nativeStore = NativeStoreRepository.EMPTY;
    /**
    static final Setting<String> CANNED_ACL_SETTING = Setting.simpleString("canned_acl");
     */
     * Minimum part size for parallel multipart uploads
            priorityExecutorBuilder,
            cancellable.cancel();
    protected S3BlobStore createBlobStore() {
    static final Setting<Boolean> UPLOAD_RETRY_ENABLED = Setting.boolSetting("s3_upload_retry_enabled", true, Setting.Property.NodeScope);
import java.util.concurrent.atomic.AtomicReference;
        return restrictedSettings;
    private static final ByteSizeValue DEFAULT_MULTIPART_UPLOAD_MINIMUM_PART_SIZE = new ByteSizeValue(
            s3AsyncService,
import org.opensearch.Version;
/*
        }
    public static Setting<Boolean> PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING = Setting.boolSetting(
        this.urgentExecutorBuilder = urgentExecutorBuilder;
        final RecoverySettings recoverySettings,
 * Shared file system implementation of the BlobStoreRepository
        final AsyncTransferManager asyncUploadUtils,
        }
/*
    S3Repository(
        Metadata clusterMetadata,
        final AsyncExecutorContainer urgentExecutorBuilder,
        "s3_async_client_type",
    /**
        }
        true
    private volatile String serverSideEncryptionType;
