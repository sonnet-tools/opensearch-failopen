     * @return true if validation succeeds, false if validation fails (and listener is notified)
                }
     */  
     * <ul>
            listener.onFailure(e);
     * @param indexMetadata the metadata of the index to validate
            if (indexMetadata == null) {
                }  
     *   <li>The index is currently in search-only mode</li>
     *   <li>The index exists</li>  
                    throw new IllegalArgumentException("To scale to zero, segment replication must be enabled for index: " + index);
                    throw new IllegalArgumentException(
     * @param listener      the action listener to notify in case of validation failure  
     *  
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)) {  
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false) == false) {
        boolean isScaleDown
     * @param isScaleDown   true if validating for scale-down, false for scale-up
     * </ul>
 */  
 * index state compatibility, and configuration prerequisites such as remote store
     * Validates that the given index meets the prerequisites for the scale operation.
/**  
     * </ul>
    boolean validateScalePrerequisites(
        String index,  
            return false;  
 * and segment replication settings.  
            }
                if (ReplicationType.SEGMENT.toString()  
 * This validator ensures that indexes being scaled up or down satisfy all the  
    ) {  
/*  
     * <p>  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;  
     * <p>  
     * For scale-up operations, this method verifies:
            }
                        "To scale to zero, " + IndexMetadata.SETTING_REMOTE_STORE_ENABLED + " must be enabled for index: " + index  
    }
            } else {
import org.opensearch.indices.replication.common.ReplicationType;
 * The OpenSearch Contributors require contributions made to  
     * <ul>
    /**
                if (indexMetadata.getSettings().getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false) == false) {
import org.opensearch.cluster.metadata.IndexMetadata;
        }
                    );
        } catch (Exception e) {
     *   <li>Remote store is enabled for the index</li>  
 * compatible open source license.
        try {
                }
     *   <li>Segment replication is enabled for the index</li>
     * @param index         the name of the index being validated
 * <p>
        IndexMetadata indexMetadata,
     *   <li>The index exists</li>  
                    .equals(indexMetadata.getSettings().get(IndexMetadata.SETTING_REPLICATION_TYPE)) == false) {
 *
 */
            return true;  
        ActionListener<AcknowledgedResponse> listener,
}  
                    throw new IllegalStateException("Index [" + index + "] is already in search-only mode");
                }
     *   <li>The index is not already in search-only mode</li>
 * Validates that indices meet the prerequisites for search-only scale operations.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     *   <li>The index has at least one search-only replica configured</li>
package org.opensearch.action.admin.indices.scale.searchonly;
class ScaleIndexOperationValidator {
                    throw new IllegalStateException("Index [" + index + "] is not in search-only mode");  
 * necessary conditions for a safe scaling operation. It checks for required settings,
                throw new IllegalArgumentException("Index [" + index + "] not found");  
            if (isScaleDown) {
     * For scale-down operations, this method verifies:
 * SPDX-License-Identifier: Apache-2.0
