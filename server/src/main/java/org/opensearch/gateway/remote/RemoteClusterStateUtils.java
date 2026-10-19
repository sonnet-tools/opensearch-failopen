        ClusterMetadataManifest.UploadedMetadataAttribute uploadedDiscoveryNodes;
            this.uploadedTransientSettingsMetadata = uploadedTransientSettingsMetadata;
            .blobContainer(
/**
            this.uploadedHashesOfConsistentSettings = null;
    /**  
import org.opensearch.common.blobstore.BlobPath;  
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedTemplatesMetadata;
            Map<String, ClusterMetadataManifest.UploadedMetadataAttribute> uploadedCustomMetadataMap,
    public static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(
    }
            this.uploadedClusterBlocks = uploadedClusterBlocks;
            this.uploadedTransientSettingsMetadata = null;  
            this.uploadedCustomMetadataMap = uploadedCustomMetadataMap;
    public static final int GLOBAL_METADATA_CURRENT_CODEC_VERSION = 1;  
        if (codecVersion == CODEC_V1) {  
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedSettingsMetadata,  
        return blobStoreRepository.basePath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID);
            this.uploadedDiscoveryNodes = uploadedDiscoveryNodes;  
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedTransientSettingsMetadata;  
            this.uploadedIndicesRoutingMetadata = new ArrayList<>();
            this.uploadedIndicesRoutingMetadata = uploadedIndicesRoutingMetadata;
    public static final String CLUSTER_STATE_EPHEMERAL_PATH_TOKEN = "ephemeral";
            this.uploadedCustomMetadataMap = new HashMap<>();  
            this.uploadedIndexMetadata = new ArrayList<>();
 */
            this.uploadedClusterStateCustomMetadataMap = new HashMap<>();  
        }
                blobStoreRepository.basePath()  
 * The OpenSearch Contributors require contributions made to  
            this.uploadedSettingsMetadata = uploadedSettingsMetadata;  
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedCoordinationMetadata;
    }
     */
import java.util.List;
    public static String getFormattedIndexFileName(String fileName) {
            this.uploadedDiscoveryNodes = null;
public class RemoteClusterStateUtils {
import java.nio.charset.StandardCharsets;
        return fileName;  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;  
            return String.format(Locale.ROOT, METADATA_NAME_FORMAT, fileName);
 * compatible open source license.
            this.uploadedCoordinationMetadata = null;
    }
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedIndicesRoutingDiffMetadata;  
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedClusterBlocks,
            this.uploadedIndexMetadata = uploadedIndexMetadata;  
 */  
            this.uploadedSettingsMetadata = null;
    public static String encodeString(String content) {
            Map<String, ClusterMetadataManifest.UploadedMetadataAttribute> uploadedClusterStateCustomMap
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedHashesOfConsistentSettings,  
        ) {
    public static final String DELIMITER = "__";
            this.uploadedHashesOfConsistentSettings = uploadedHashesOfConsistentSettings;  
    public static class UploadedMetadataResults {  
 *
        Map.of(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY)  
}  
        String[] pathTokens = fileName.split(DELIMITER);  
        Map<String, ClusterMetadataManifest.UploadedMetadataAttribute> uploadedCustomMetadataMap;
    // ToXContent Params with gateway mode.  
        List<ClusterMetadataManifest.UploadedIndexMetadata> uploadedIndexMetadata;
import java.util.HashMap;
            );  
    public static final String METADATA_NAME_FORMAT = "%s.dat";
    }
    }  
import java.util.ArrayList;
 * Utility class for Remote Cluster State  
    static BlobContainer clusterUUIDContainer(BlobStoreRepository blobStoreRepository, String clusterName) {  
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedCoordinationMetadata,
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedTransientSettingsMetadata,
            this.uploadedClusterStateCustomMetadataMap = uploadedClusterStateCustomMap;
    public static final String METADATA_FILE_PREFIX = "metadata";
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedHashesOfConsistentSettings;
import org.opensearch.common.blobstore.BlobContainer;
        return blobStoreRepository.blobStore()
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.gateway.remote;
        return Base64.getUrlEncoder().withoutPadding().encodeToString(content.getBytes(StandardCharsets.UTF_8));
import java.util.Base64;  
            this.uploadedCoordinationMetadata = uploadedCoordinationMetadata;
        List<ClusterMetadataManifest.UploadedIndexMetadata> uploadedIndicesRoutingMetadata;
import java.util.Locale;  
        Map<String, ClusterMetadataManifest.UploadedMetadataAttribute> uploadedClusterStateCustomMetadataMap;  
            this.uploadedTemplatesMetadata = uploadedTemplatesMetadata;
     * Container class to keep metadata of all uploaded attributes
            this.uploadedTemplatesMetadata = null;
import java.util.Map;
        }
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedClusterBlocks;  
                    .add(Base64.getUrlEncoder().withoutPadding().encodeToString(clusterName.getBytes(StandardCharsets.UTF_8)))
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedTemplatesMetadata,
/*  
            ClusterMetadataManifest.UploadedMetadataAttribute uploadedDiscoveryNodes,  
        int codecVersion = Integer.parseInt(pathTokens[pathTokens.length - 1]);
 * SPDX-License-Identifier: Apache-2.0
        // last value added is the codec version in IndexMetadata file
    public static final String PATH_DELIMITER = "/";  
            List<ClusterMetadataManifest.UploadedIndexMetadata> uploadedIndicesRoutingMetadata,
import org.opensearch.cluster.metadata.Metadata;
    public static final String METADATA_NAME_PLAIN_FORMAT = "%s";
    public static final String CUSTOM_DELIMITER = "--";
    );
    // We are using gateway context mode to persist all custom metadata.
    public static final String GLOBAL_METADATA_PATH_TOKEN = "global-metadata";
        public UploadedMetadataResults() {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        }
                    .add(CLUSTER_STATE_PATH_TOKEN)
            List<ClusterMetadataManifest.UploadedIndexMetadata> uploadedIndexMetadata,  
import org.opensearch.core.xcontent.ToXContent;
        public UploadedMetadataResults(
        ClusterMetadataManifest.UploadedMetadataAttribute uploadedSettingsMetadata;
    public static final String CLUSTER_STATE_PATH_TOKEN = "cluster-state";  
    public static BlobPath getClusterMetadataBasePath(BlobStoreRepository blobStoreRepository, String clusterName, String clusterUUID) {  
            this.uploadedClusterBlocks = null;  
