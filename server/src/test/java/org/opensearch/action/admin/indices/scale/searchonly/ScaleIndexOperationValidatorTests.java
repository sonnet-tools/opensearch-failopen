    /**
import org.opensearch.test.OpenSearchTestCase;
     * Helper method to create a dummy IndexMetadata.
        Settings settings = Settings.builder()
        assertFalse(result);
    }
        // For scale-down, if the index is already marked as search-only, validation should fail.
        // For scale-up, the index must be in search-only mode.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
 * compatible open source license.
        // Pass zero for the number of search-only replicas.
        // If there are zero search-only replicas, validation should fail.
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 0);
        Settings settings = Settings.builder()
        }
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
        verify(listener).onFailure(argThat(new ExceptionMatcher("Index [test-index] not found")));
        assertFalse(result);
    }
            return e != null && e.getMessage() != null && e.getMessage().contains(substring);
        assertTrue(result);
    }
        verify(listener).onFailure(argThat(new ExceptionMatcher(IndexMetadata.SETTING_REMOTE_STORE_ENABLED)));
    }
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
            .build();
        return IndexMetadata.builder(indexName)
        private final String substring;
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
import org.opensearch.Version;
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
    public void testValidateScalePrerequisites_ScaleDown_NoSearchOnlyReplicas() {
        verify(listener, never()).onFailure(any());
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
        boolean result = validator.validateScalePrerequisites(null, "test-index", listener, true);
            .build();
/*
        verify(listener, never()).onFailure(any());
import org.opensearch.common.settings.Settings;
    public void testValidateScalePrerequisites_ScaleDown_AlreadySearchOnly() {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "OTHER")
        public boolean matches(Exception e) {
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, false);
import static org.mockito.ArgumentMatchers.argThat;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
            .put(settings)
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
    }
    public void testValidateScalePrerequisites_ScaleUp_NotSearchOnly() {
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
        verify(listener).onFailure(argThat(new ExceptionMatcher("not in search-only mode")));
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        // All prerequisites for scaling down are met.
        // If remote store is not enabled, validation should fail.
            .numberOfReplicas(1)
            .build();
        assertFalse(result);
    private ActionListener<AcknowledgedResponse> listener;
import org.mockito.ArgumentMatcher;
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
    }
    private IndexMetadata createTestIndexMetadata(String indexName, Settings settings, int searchOnlyReplicas) {
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, false);
    }
        Settings settings = Settings.builder()
    }
     */
        boolean result = validator.validateScalePrerequisites(indexMetadata, "test-index", listener, true);
            .numberOfShards(1)
        verify(listener).onFailure(argThat(new ExceptionMatcher("already in search-only mode")));
public class ScaleIndexOperationValidatorTests extends OpenSearchTestCase {
        // If the replication type is not SEGMENT, validation should fail.
            this.substring = substring;
import org.mockito.Mockito;
}
        verify(listener).onFailure(argThat(new ExceptionMatcher("segment replication must be enabled")));
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.ArgumentMatchers.any;
    public void testValidateScalePrerequisites_NullIndexMetadata() {
        // Valid scale-up: the index is in search-only mode.
        assertFalse(result);
    public void setUp() throws Exception {
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
        assertFalse(result);
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
            .build();
    public void testValidateScalePrerequisites_ScaleDown_Valid() {
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true).build();
        Settings updatedSettings = Settings.builder()
    public void testValidateScalePrerequisites_ScaleDown_InvalidReplicationType() {
package org.opensearch.action.admin.indices.scale.searchonly;
import static org.mockito.Mockito.never;
    @Override
        assertTrue(result);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
    }
            // Add the required index version setting. You can use a hardcoded value or Version.CURRENT.toString()
        ExceptionMatcher(String substring) {
        }
        super.setUp();
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
     */
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        IndexMetadata indexMetadata = createTestIndexMetadata("test-index", settings, 1);
    private static class ExceptionMatcher implements ArgumentMatcher<Exception> {
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
     * Adjust this helper to match your actual IndexMetadata builder.
 *
    }
        // When index metadata is null, validation should fail.
 */
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true).build();
            .put("index.version.created", Version.CURRENT)
            .settings(updatedSettings)
            .numberOfSearchReplicas(searchOnlyReplicas)
        Settings settings = Settings.builder()
 * The OpenSearch Contributors require contributions made to
    }
        listener = Mockito.mock(ActionListener.class);
    /**
            .build();
import static org.mockito.Mockito.verify;
        validator = new ScaleIndexOperationValidator();
    private ScaleIndexOperationValidator validator;
    public void testValidateScalePrerequisites_ScaleDown_RemoteStoreNotEnabled() {
     * A custom ArgumentMatcher to check that an exception’s message contains a given substring.
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(result);
        // Create a mock listener so we can verify onFailure is called with the expected exception.
        @Override
    public void testValidateScalePrerequisites_ScaleUp_Valid() {
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false).build();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
