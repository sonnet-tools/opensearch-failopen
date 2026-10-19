        );  
    }
import org.opensearch.common.settings.Settings;
            .put("override_request_values", "true")
    public void testLegacyTimeoutKeyRejected() {
    public void testValidateOverrideRequestValues() {
        Settings settings2 = Settings.builder().put("search.batched_reduce_size", "xyz").build();
        assertNotNull(WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE);
        WorkloadGroupSearchSettings.validate(settings);
        );
    }
}
    public void testWlmBatchedReduceSizeSettingExists() {  
        settings = Settings.builder().put("search.max_concurrent_shard_requests", "100").build();  
            IllegalArgumentException.class,
            () -> WorkloadGroupSearchSettings.validate(settings)
        Settings settings = Settings.builder().put("search.max_buckets", "-1").build();  
        assertTrue(exception.getMessage().contains("search.max_buckets"));  
            .put("search.max_buckets", "1000")
        WorkloadGroupSearchSettings.validate(settings);
        WorkloadGroupSearchSettings.validate(settings);
    }  
        assertTrue(exception.getMessage().contains("Invalid value"));
public class WorkloadGroupSearchSettingsTests extends OpenSearchTestCase {
    public void testValidateMaxBuckets() {  
        Settings settings = Settings.builder().put("search.max_concurrent_shard_requests", "1").build();  
    }
    public void testValidateSettingsInvalidValue() {
            IllegalArgumentException.class,  
        assertTrue(exception.getMessage().contains("search.cancel_after_time_interval"));
            IllegalArgumentException.class,
        assertTrue(exception.getMessage().contains("Invalid value"));
        );  
        settings = Settings.builder().put("override_request_values", "false").build();  
        assertTrue(exception.getMessage().contains("Invalid value"));  
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
import org.opensearch.test.OpenSearchTestCase;
        Settings settings = Settings.builder().put("search.max_buckets", "0").build();
        Settings settings = Settings.builder().put("unknown_key", "value").build();
        assertEquals("search.default_search_timeout", WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT.getKey());
            () -> WorkloadGroupSearchSettings.validate(settings)
    public void testValidateSettingsValid() {  
        Settings settings = Settings.builder().put("search.default_search_timeout", "not_a_time").build();
    public void testValidateBatchedReduceSize() {
        Settings settings = Settings.builder().put("search.max_concurrent_shard_requests", "abc").build();
            IllegalArgumentException.class,
        }  
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));  
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put("search.default_search_timeout", "30s").build();
    public void testWlmOverrideRequestValuesSettingExists() {
        assertTrue(exception.getMessage().contains("search.batched_reduce_size"));  
    }  
            .put("search.max_concurrent_shard_requests", "5")
        IllegalArgumentException exception = expectThrows(  
        assertEquals("override_request_values", WorkloadGroupSearchSettings.WLM_OVERRIDE_REQUEST_VALUES.getKey());  
    }
        assertTrue(exception.getMessage().contains("search.max_concurrent_shard_requests"));
        Settings settings = Settings.builder().put("override_request_values", "not_a_boolean").build();  
            .build();  
        Settings settings = Settings.builder().put("search.max_concurrent_shard_requests", "0").build();
            WorkloadGroupSearchSettings.validate(settings);
        assertTrue(exception.getMessage().contains("search.max_buckets"));
        Settings settings2 = Settings.builder().put("search.batched_reduce_size", "0").build();  
        settings = Settings.builder().put("search.batched_reduce_size", "512").build();
            .put("search.default_search_timeout", "30s")  
    public void testValidateSettingsUnknownKey() {
        Settings settings = Settings.builder().put("search.batched_reduce_size", "1").build();
        WorkloadGroupSearchSettings.validate(settings);  
    }  
            .put("search.cancel_after_time_interval", "1m")
        Settings settings = Settings.builder().put("search.batched_reduce_size", "2").build();
        settings = Settings.builder().put("search.max_buckets", "1000000").build();
    }
        WorkloadGroupSearchSettings.validate(settings);
        IllegalArgumentException exception = expectThrows(
    public void testValidateCancelAfterTimeInterval() {  
        IllegalArgumentException exception = expectThrows(  
        assertTrue(exception.getMessage().contains("Invalid value"));  
        IllegalArgumentException exception = expectThrows(  
        );  
        WorkloadGroupSearchSettings.validate(settings);
        assertTrue(exception.getMessage().contains("Unknown WLM setting: unknown_key"));
        assertTrue(exception.getMessage().contains("Invalid value"));
    }
        );
    public void testValidateInvalidCancelAfterTimeInterval() {
        WorkloadGroupSearchSettings.validate(settings);
        WorkloadGroupSearchSettings.validate(settings);
        settings = Settings.builder().put("search.max_buckets", "65535").build();
 */  
    public void testValidateInvalidOverrideRequestValues() {
        );  
    }  
        Settings settings2 = Settings.builder().put("search.max_concurrent_shard_requests", "-1").build();
    }
        assertTrue(exception.getMessage().contains("override_request_values"));  
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
    public void testValidateMultipleSettings() {
        IllegalArgumentException exception = expectThrows(
        assertNotNull(WorkloadGroupSearchSettings.WLM_MAX_BUCKETS);  
        assertEquals("search.max_concurrent_shard_requests", WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS.getKey());  
        WorkloadGroupSearchSettings.validate(settings);
        assertTrue(exception.getMessage().contains("Invalid value"));
/*  
        assertNotNull(WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL);  
        assertTrue(exception.getMessage().contains("Invalid value"));  
    public void testValidateBatchedReduceSizeInvalid() {  
        Settings settings = Settings.builder().put("timeout", "30s").build();
        assertNotNull(WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS);
    public void testWlmSearchTimeoutSettingExists() {  
            () -> WorkloadGroupSearchSettings.validate(settings)
        WorkloadGroupSearchSettings.validate(settings);
        WorkloadGroupSearchSettings.validate(null);  
            () -> WorkloadGroupSearchSettings.validate(settings)
 * compatible open source license.
    }  
    public void testValidateSettingsValidTimeValues() {
        Settings settings = Settings.builder()
    public void testWlmCancelAfterTimeIntervalSettingExists() {
        Settings settings = Settings.builder().put("override_request_values", "true").build();  
            IllegalArgumentException.class,
 * The OpenSearch Contributors require contributions made to  
        assertEquals("search.cancel_after_time_interval", WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL.getKey());
            () -> WorkloadGroupSearchSettings.validate(settings)
            Settings settings = Settings.builder().put("search.default_search_timeout", timeVal).build();
        );  
        for (String timeVal : new String[] { "30s", "5m", "1h", "500ms" }) {  
        WorkloadGroupSearchSettings.validate(settings);
            IllegalArgumentException.class,
        assertTrue(exception.getMessage().contains("search.max_concurrent_shard_requests"));
    public void testWlmMaxConcurrentShardRequestsSettingExists() {
        assertTrue(exception.getMessage().contains("Invalid value"));
        WorkloadGroupSearchSettings.validate(settings);  
    public void testWlmMaxBucketsSettingExists() {
        WorkloadGroupSearchSettings.validate(Settings.EMPTY);
        Settings settings2 = Settings.builder().put("search.max_buckets", "abc").build();
    }
        exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroupSearchSettings.validate(settings2));
 *
    }
    }  
        assertTrue(exception.getMessage().contains("search.batched_reduce_size"));
        WorkloadGroupSearchSettings.validate(settings);
    }
            () -> WorkloadGroupSearchSettings.validate(settings)  
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        assertTrue(exception.getMessage().contains("Invalid value"));
        assertTrue(exception.getMessage().contains("Invalid value"));
package org.opensearch.wlm;
            () -> WorkloadGroupSearchSettings.validate(settings)  
    public void testValidateSettingsNull() {
        assertEquals("search.batched_reduce_size", WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE.getKey());
        );  
        Settings settings = Settings.builder().put("search.cancel_after_time_interval", "not_a_time").build();
            () -> WorkloadGroupSearchSettings.validate(settings)
    }  
        assertNotNull(WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT);
    public void testValidateNonNumericIntSetting() {
        assertTrue(exception.getMessage().contains("search.max_concurrent_shard_requests"));
            .put("search.batched_reduce_size", "256")  
        assertTrue(exception.getMessage().contains("search.default_search_timeout"));
        assertTrue(exception.getMessage().contains("search.batched_reduce_size"));
    public void testValidateMaxConcurrentShardRequestsInvalid() {
        settings = Settings.builder().put("search.cancel_after_time_interval", "30s").build();
    public void testValidateMaxConcurrentShardRequests() {
    }
    }
        IllegalArgumentException exception = expectThrows(  
        IllegalArgumentException exception = expectThrows(
    }
        Settings settings = Settings.builder().put("search.cancel_after_time_interval", "1m").build();
    public void testValidateMaxBucketsInvalid() {
        );
    }
    }  
    }
        assertTrue(exception.getMessage().contains("Unknown WLM setting: timeout"));
        assertEquals("search.max_buckets", WorkloadGroupSearchSettings.WLM_MAX_BUCKETS.getKey());
    }
        assertTrue(exception.getMessage().contains("Invalid value"));
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(WorkloadGroupSearchSettings.WLM_OVERRIDE_REQUEST_VALUES);
    }
            IllegalArgumentException.class,
            () -> WorkloadGroupSearchSettings.validate(settings)
        IllegalArgumentException exception = expectThrows(  
    public void testValidateSettingsEmpty() {  
        IllegalArgumentException exception = expectThrows(  
