    }
    /**
 * {@code analytics.query.max_shards_per_query} is retained only so a cluster that still carries it  
 * The OpenSearch Contributors require contributions made to  
            "a dynamic property would imply something consumes updates",  
        assertEquals(Integer.valueOf(1), AnalyticsQuerySettings.MAX_SHARDS_PER_QUERY.get(withLegacyLimit));  
        assertTrue(
 * compatible open source license.
     */
     * inert.
     * {@code ShardTargetResolverTests.testResolveIsUnlimitedByDefault}, which pins that an
    }  
        );
                + "See the breaking changes documentation for the next major version."
        assertTrue(
 * shard ceiling is {@code action.search.shard_count.limit}, and nothing reads this one.
     * expectation next to the setting so the intent survives; enforcement is by review and by
 * SPDX-License-Identifier: Apache-2.0
        );
            AnalyticsQuerySettings.MAX_SHARDS_PER_QUERY.getProperties().contains(Setting.Property.Deprecated)  
     * unconfigured cluster rejects nothing regardless of this key.  
    public void testNoProductionCodeReadsIt() {
public class DeprecatedMaxShardsPerQueryTests extends OpenSearchTestCase {
            "[analytics.query.max_shards_per_query] setting was deprecated in OpenSearch and will be removed in a future release! "  
        );
    public void testStillRegistered() {
        // carries a max-shards value. Both are covered by ShardTargetResolverTests.
}
        Settings withLegacyLimit = Settings.builder().put(AnalyticsQuerySettings.MAX_SHARDS_PER_QUERY.getKey(), 1).build();
    }  
    /** Still registered, or a cluster carrying it would fail to start rather than warn. */  
    /** Marked deprecated, so setting it surfaces a warning to the operator. */
        // ShardTargetResolver reads action.search.shard_count.limit only; QueryContext no longer  
     * The actual contract: no production class references the constant. Kept as a documented  
     */
package org.opensearch.analytics.settings;
        assertFalse(
 */  
/**
            "operators need a warning telling them to migrate",
        assertWarnings(
/*  
    }  
     * is a real {@link Setting} — but no production code performs this read; that is what makes it  
            "the deprecated key must remain registered so existing clusters keep starting",  
    /**
            AnalyticsQuerySettings.MAX_SHARDS_PER_QUERY.getProperties().contains(Setting.Property.Dynamic)
import org.opensearch.test.OpenSearchTestCase;  
    public void testReadingItWarns() {  
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
 * starts and gets a deprecation warning instead of a settings-validation failure. It is inert — the
            AnalyticsQuerySettings.all().stream().anyMatch(s -> s.getKey().equals("analytics.query.max_shards_per_query"))
import org.opensearch.common.settings.Setting;
import org.opensearch.common.settings.Settings;
     * Reading it emits the deprecation warning an operator needs to see. The value still parses — it
    public void testMarkedDeprecated() {  
        );
