    }
    }
        );
            IllegalArgumentException.class,
        settings = Settings.builder().put("override_request_values", "false").build();
            () -> WorkloadGroupSearchSettings.validate(settings)
        );
import org.opensearch.test.OpenSearchTestCase;
    public void testValidateMultipleSettings() {
        Settings settings = Settings.builder().put("search.max_buckets", "-1").build();
        for (String timeVal : new String[] { "30s", "5m", "1h", "500ms" }) {
        assertTrue(exception.getMessage().contains("search.batched_reduce_size"));
        Settings settings = Settings.builder().put("search.max_buckets", "0").build();
        Settings settings = Settings.builder().put("unknown_key", "value").build();
/*
        assertTrue(exception.getMessage().contains("Invalid value"));
            .put("search.cancel_after_time_interval", "1m")
        settings = Settings.builder().put("search.max_buckets", "1000000").build();
    }
    }
        );
        assertTrue(exception.getMessage().contains("Unknown WLM setting: unknown_key"));
            () -> WorkloadGroupSearchSettings.validate(settings)
        Settings settings = Settings.builder().put("search.default_search_timeout", "30s").build();
            .put("override_request_values", "true")
        assertTrue(exception.getMessage().contains("search.max_concurrent_shard_requests"));
        IllegalArgumentException exception = expectThrows(
    }
    public void testValidateInvalidOverrideRequestValues() {
 * The OpenSearch Contributors require contributions made to
    }
        WorkloadGroupSearchSettings.validate(settings);
        IllegalArgumentException exception = expectThrows(
    }
        assertEquals("search.cancel_after_time_interval", WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL.getKey());
            () -> WorkloadGroupSearchSettings.validate(settings)
        assertTrue(exception.getMessage().contains("search.max_buckets"));
        Settings settings = Settings.builder().put("search.cancel_after_time_interval", "not_a_time").build();
            () -> WorkloadGroupSearchSettings.validate(settings)
        );
        WorkloadGroupSearchSettings.validate(settings);
            () -> WorkloadGroupSearchSettings.validate(settings)
    }
        assertNotNull(WorkloadGroupSearchSettings.WLM_MAX_BUCKETS);
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
        Settings settings = Settings.builder().put("search.default_search_timeout", "not_a_time").build();
    public void testValidateMaxConcurrentShardRequestsInvalid() {
    public void testValidateOverrideRequestValues() {
            () -> WorkloadGroupSearchSettings.validate(settings)
        assertEquals("search.max_buckets", WorkloadGroupSearchSettings.WLM_MAX_BUCKETS.getKey());
        assertEquals("search.batched_reduce_size", WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE.getKey());
            () -> WorkloadGroupSearchSettings.validate(settings)
        );
            IllegalArgumentException.class,
        WorkloadGroupSearchSettings.validate(settings);
        WorkloadGroupSearchSettings.validate(settings);
            .build();
        settings = Settings.builder().put("search.cancel_after_time_interval", "30s").build();
        );
 * compatible open source license.
    public void testValidateBatchedReduceSize() {
        Settings settings2 = Settings.builder().put("search.max_buckets", "abc").build();
            IllegalArgumentException.class,
    }
    public void testValidateSettingsValidTimeValues() {
        WorkloadGroupSearchSettings.validate(settings);
        assertTrue(exception.getMessage().contains("Unknown WLM setting: timeout"));
        WorkloadGroupSearchSettings.validate(settings);
    public void testWlmBatchedReduceSizeSettingExists() {
    }
    }
            .put("search.default_search_timeout", "30s")
        Settings settings2 = Settings.builder().put("search.batched_reduce_size", "xyz").build();
            .put("search.max_buckets", "1000")
        Settings settings = Settings.builder().put("override_request_values", "not_a_boolean").build();
        assertTrue(exception.getMessage().contains("Invalid value"));
        WorkloadGroupSearchSettings.validate(settings);
    }
    }
        WorkloadGroupSearchSettings.validate(settings);
    public void testWlmMaxBucketsSettingExists() {
        WorkloadGroupSearchSettings.validate(null);
    public void testValidateBatchedReduceSizeInvalid() {
    public void testValidateSettingsUnknownKey() {
    public void testValidateSettingsNull() {
        IllegalArgumentException exception = expectThrows(
        Settings settings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
    public void testWlmMaxConcurrentShardRequestsSettingExists() {
        Settings settings2 = Settings.builder().put("search.batched_reduce_size", "0").build();
    public void testValidateMaxBuckets() {
            IllegalArgumentException.class,
        assertTrue(exception.getMessage().contains("search.batched_reduce_size"));
        IllegalArgumentException exception = expectThrows(
        Settings settings = Settings.builder().put("search.max_concurrent_shard_requests", "abc").build();
 * SPDX-License-Identifier: Apache-2.0
    }
        Settings settings = Settings.builder().put("search.batched_reduce_size", "2").build();
        assertNotNull(WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS);
package org.opensearch.wlm;
        assertNotNull(WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL);
 *
            WorkloadGroupSearchSettings.validate(settings);
        WorkloadGroupSearchSettings.validate(settings);
        Settings settings = Settings.builder().put("search.cancel_after_time_interval", "1m").build();
        );
}
        Settings settings = Settings.builder().put("search.max_concurrent_shard_requests", "0").build();
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
        WorkloadGroupSearchSettings.validate(settings);
        settings = Settings.builder().put("search.max_buckets", "65535").build();
        Settings settings = Settings.builder().put("timeout", "30s").build();
    }
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
            IllegalArgumentException.class,
            IllegalArgumentException.class,
    }
    public void testValidateSettingsEmpty() {
        assertEquals("search.default_search_timeout", WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT.getKey());
        IllegalArgumentException exception = expectThrows(
        IllegalArgumentException exception = expectThrows(
    public void testValidateSettingsValid() {
        assertTrue(exception.getMessage().contains("search.max_concurrent_shard_requests"));
    public void testValidateMaxBucketsInvalid() {
        assertNotNull(WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE);
    }
 */
        WorkloadGroupSearchSettings.validate(Settings.EMPTY);
        WorkloadGroupSearchSettings.validate(settings);
        settings = Settings.builder().put("search.batched_reduce_size", "512").build();
        IllegalArgumentException exception = expectThrows(
            () -> WorkloadGroupSearchSettings.validate(settings)
        }
    }
        );
        Settings settings = Settings.builder().put("search.batched_reduce_size", "1").build();
    public void testWlmOverrideRequestValuesSettingExists() {
        assertNotNull(WorkloadGroupSearchSettings.WLM_OVERRIDE_REQUEST_VALUES);
        );
        assertTrue(exception.getMessage().contains("Invalid value"));
    public void testLegacyTimeoutKeyRejected() {
            .put("search.max_concurrent_shard_requests", "5")
    }
    public void testValidateNonNumericIntSetting() {
        assertTrue(exception.getMessage().contains("Invalid value"));
    }
    public void testValidateSettingsInvalidValue() {
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
        assertNotNull(WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT);
    public void testValidateInvalidCancelAfterTimeInterval() {
    public void testValidateCancelAfterTimeInterval() {
            IllegalArgumentException.class,
        assertTrue(exception.getMessage().contains("Invalid value"));
    public void testValidateMaxConcurrentShardRequests() {
        assertTrue(exception.getMessage().contains("Invalid value"));
        Settings settings = Settings.builder().put("search.max_concurrent_shard_requests", "1").build();
    }
    public void testWlmCancelAfterTimeIntervalSettingExists() {
        assertTrue(exception.getMessage().contains("search.batched_reduce_size"));
        IllegalArgumentException exception = expectThrows(
        assertEquals("override_request_values", WorkloadGroupSearchSettings.WLM_OVERRIDE_REQUEST_VALUES.getKey());
public class WorkloadGroupSearchSettingsTests extends OpenSearchTestCase {
        WorkloadGroupSearchSettings.validate(settings);
        assertTrue(exception.getMessage().contains("search.max_buckets"));
        assertTrue(exception.getMessage().contains("search.max_concurrent_shard_requests"));
        assertTrue(exception.getMessage().contains("search.default_search_timeout"));
            .put("search.batched_reduce_size", "256")
        assertTrue(exception.getMessage().contains("Invalid value"));
        assertTrue(exception.getMessage().contains("override_request_values"));
            IllegalArgumentException.class,
import org.opensearch.common.settings.Settings;
    }
        WorkloadGroupSearchSettings.validate(settings);
        assertTrue(exception.getMessage().contains("Invalid value"));
        Settings settings2 = Settings.builder().put("search.max_concurrent_shard_requests", "-1").build();
        IllegalArgumentException exception = expectThrows(
        assertTrue(exception.getMessage().contains("Invalid value"));
        Settings settings = Settings.builder().put("override_request_values", "true").build();
        settings = Settings.builder().put("search.max_concurrent_shard_requests", "100").build();
        assertTrue(exception.getMessage().contains("search.cancel_after_time_interval"));
        assertTrue(exception.getMessage().contains("Invalid value"));
            () -> WorkloadGroupSearchSettings.validate(settings)
    public void testWlmSearchTimeoutSettingExists() {
        assertEquals("search.max_concurrent_shard_requests", WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS.getKey());
            IllegalArgumentException.class,
            Settings settings = Settings.builder().put("search.default_search_timeout", timeVal).build();
    }
    }
    }
        assertTrue(exception.getMessage().contains("Invalid value"));
