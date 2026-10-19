    /**
    public void testValidateScalePrerequisites_ScaleDown_Valid() {  
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, false);
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
        verify(listener, never()).onFailure(any());
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
import org.opensearch.core.action.ActionListener;
    public void testValidateScalePrerequisites_ScaleDown_AlreadySearchOnly() {  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
    public void testValidateScalePrerequisites_ScaleDown_NoSearchOnlyReplicas() {  
import static org.mockito.ArgumentMatchers.argThat;  
            .put(settings)
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "OTHER")
        verify(listener, never()).onFailure(any());
        validator = new ScaleIndexOperationValidator();  
        verify(listener).onFailure(argThat(new ExceptionMatcher("Index [test-index] not found")));  
            .put("index.version.created", Version.CURRENT)  
        Settings settings = Settings.builder()
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);  
        // If remote store is not enabled, validation should fail.
        verify(listener).onFailure(argThat(new ExceptionMatcher("already in search-only mode")));  
    }
    @Override  
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, false);
        // Create a mock listener so we can verify onFailure is called with the expected exception.
    }
    private ActionListener<AcknowledgedResponse> listener;
package org.opensearch.action.admin.indices.scale.searchonly;
        assertFalse(result);
import org.opensearch.common.settings.Settings;
        // When index metadata is null, validation should fail.  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        super.setUp();
        }
            // Add the required index version setting. You can use a hardcoded value or Version.CURRENT.toString()
    public void testValidateScalePrerequisites_ScaleDown_InvalidReplicationType() {
 * compatible open source license.
        // Pass zero for the number of search-only replicas.
        listener = Mockito.mock(ActionListener.class);
    public void testValidateScalePrerequisites_ScaleUp_NotSearchOnly() {
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true).build();  
    }  
/*  
    private ScaleIndexOperationValidator validator;  
        verify(listener).onFailure(argThat(new ExceptionMatcher("not in search-only mode")));
            .settings(updatedSettings)  
        // All prerequisites for scaling down are met.
import static org.mockito.Mockito.never;
    private static class ExceptionMatcher implements ArgumentMatcher<Exception> {
        return IndexMetadata.builder(indexName)
        // If there are zero search-only replicas, validation should fail.
            .numberOfReplicas(1)
            this.substring = substring;
            .build();
     * Adjust this helper to match your actual IndexMetadata builder.  
import static org.mockito.ArgumentMatchers.any;
        // If the replication type is not SEGMENT, validation should fail.  
 *
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 0);
        }  
    /**
    public void setUp() throws Exception {
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true).build();
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);  
    public void testValidateScalePrerequisites_ScaleUp_Valid() {
        private final String substring;
    }
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
        assertFalse(result);
import org.opensearch.test.OpenSearchTestCase;  
            .build();  
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)  
        @Override
     */  
        // Valid scale-up: the index is in search-only mode.
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)  
import static org.mockito.Mockito.verify;
        Settings updatedSettings = Settings.builder()  
    }
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")  
    public void testValidateScalePrerequisites_NullIndexMetadata() {
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
import org.mockito.ArgumentMatcher;
        boolean result = validator.validateScalePrerequisites(null, "test-index", listener, true);
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
     * A custom ArgumentMatcher to check that an exception’s message contains a given substring.
        assertTrue(result);  
            .build();
        Settings settings = Settings.builder()
     * Helper method to create a dummy IndexMetadata.
    public void testValidateScalePrerequisites_ScaleDown_RemoteStoreNotEnabled() {
    private IndexMetadata createTestIndexMetadata(String indexName, Settings settings, int searchOnlyReplicas) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .numberOfSearchReplicas(searchOnlyReplicas)  
import org.mockito.Mockito;  
        assertTrue(result);  
        assertFalse(result);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
        // For scale-down, if the index is already marked as search-only, validation should fail.
}
    }  
        Settings settings = Settings.builder()
        // For scale-up, the index must be in search-only mode.
    }
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        assertTrue(result);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        Settings settings = Settings.builder()  
    }
        ExceptionMatcher(String substring) {
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);  
            .build();
        assertFalse(result);
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false).build();  
            .numberOfShards(1)
            .build();
     */
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
public class ScaleIndexOperationValidatorTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
 */  
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
import org.opensearch.Version;
            .build();  
    }  
        verify(listener).onFailure(argThat(new ExceptionMatcher(IndexMetadata.SETTING_REMOTE_STORE_ENABLED)));
        assertFalse(result);  
        public boolean matches(Exception e) {  
            return e != null && e.getMessage() != null && e.getMessage().contains(substring);
        verify(listener).onFailure(argThat(new ExceptionMatcher("segment replication must be enabled")));  
