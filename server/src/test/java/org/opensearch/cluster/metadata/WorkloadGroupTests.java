                badThrottling,
        IllegalArgumentException exception = expectThrows(  
            "test_id",
                new MutableWorkloadGroupFragment(randomMode(), Collections.emptyMap()),
                "test",  
                Settings.EMPTY,  
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));  
        assertNotNull(workloadGroup.getSettings());  
            )  
        WorkloadGroup existing = new WorkloadGroup(
                Map.of(ResourceType.MEMORY, 0.5),
        // -1 is the internal "unset" sentinel and, like any negative value, is not user-settable.
        );  
                    + "\"resource_limits\":{\"cpu\":0.3},\"throttling\":%s,\"updated_at\":%d}",
            () -> new WorkloadGroup(
            IllegalArgumentException.class,  
     */
        assertEquals(1, workloadGroup.getResourceLimits().size());  
            builder.toString()
            Settings.builder().put("node_limit", 50).build()  
            assertTrue(exception.getMessage(), exception.getMessage().contains("throttling.by must be one of [username, role]"));
            null,  
    protected Writeable.Reader<WorkloadGroup> instanceReader() {  
                ResiliencyMode.ENFORCED,  
        XContentParser limitParser = createParser(JsonXContent.jsonXContent, clearLimitOnly);
        assertNull("the parser must distinguish an omitted throttling field from an explicit empty object", update.getThrottling());
                    Settings.builder().put("by", "username").build()
    public void testNonNumericThrottleLimitRejected() {
            IllegalArgumentException exception = expectThrows(
        );  
    public void testInvalidThrottleByRejected() {
    }  
    public void testUpdateMergesSettings() {  
            assertEquals(timestamp, workloadGroup.getUpdatedAtInMillis());
        );
    public void testNullName() {
            );
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            "test_id",  
            )
                    Settings.builder().put("by", invalidBy).put("node_limit", 5).build()
        assertEquals("true", updated.getSettings().get("override_request_values"));  
        );
    }  
            IllegalArgumentException.class,  
            exception.getMessage().contains("Failed to parse value [" + invalidValue + "] for setting [node_limit]")
    public void testLegacyThrottleAttributeKeyRejected() {
            + "\"search_settings\":{\"timeout\":\"30s\"},"  
        assertFalse("group scope must have one canonical representation: no by key", throttling.keySet().contains("by"));
    public void testThrottleLimitAtMaxAccepted() {  
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
            + "\"updated_at\":1720047207}";
    public void testToXContentOmitsUnsetThrottling() throws IOException {  
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
                ResiliencyMode.ENFORCED,
            name,
            "test_id",  
        assertTrue(updated.getMutableWorkloadGroupFragment().getThrottling().isEmpty());
                new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),  
            )
        }  
        long[] timestamps = new long[] { Math.max(0L, now - 20L), now + 20L };
    }  
            new MutableWorkloadGroupFragment(
            NullPointerException.class,
            () -> new WorkloadGroup(  
            ),  
            () -> new WorkloadGroup("", "_id", new MutableWorkloadGroupFragment(), Instant.now().getMillis())
        );  
    }
    }
                    ResiliencyMode.ENFORCED,  
        assertTrue(exception.getMessage(), exception.getMessage().contains("Invalid value '" + tooLarge + "' for throttling.node_limit"));
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
                System.currentTimeMillis()  
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
                new MutableWorkloadGroupFragment(  
                "Dummy",  
    }  
            "test_id",  
                badThrottling,  
                now
                Map.of(ResourceType.MEMORY, 0.5),
                Settings.EMPTY,  
        IllegalArgumentException exception = expectThrows(
            "{\"_id\":\"%s\",\"name\":\"TestWorkloadGroup\",\"resiliency_mode\":\"enforced\","
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
            currentTimeInMillis
                Settings.EMPTY,
            assertNotNull(WorkloadGroup.fromXContent(parser)); // lenient: must not throw  
    public void testIllegalWorkloadGroupName() {
                Instant.now().getMillis()
                Settings.builder().put("node_limit", 10).build()
        StreamInput in = out.bytes().streamInput();
                    Map.of(ResourceType.MEMORY, 0.5),
                Settings.builder().put("search.default_search_timeout", "30s").put("search.max_concurrent_shard_requests", "5").build()
            System.currentTimeMillis()  
        // Update only timeout — override_request_values should persist as "true"  
            () -> WorkloadGroupThrottleSettings.getEffectiveBy(Settings.builder().put("attribute", "username").put("node_limit", 5).build())  
        );  
                Instant.now().getMillis()  
    }  
            new MutableWorkloadGroupFragment(
            ),
        String expected = String.format(  
        }
            Settings.builder().put("by", "username").build()  
    }  
        MutableWorkloadGroupFragment fragment = builder.getMutableWorkloadGroupFragment();
    }
    }
            )
        return allowedModes.get(randomIntBetween(0, allowedModes.size() - 1));
            Locale.ROOT,
                Map.of(ResourceType.MEMORY, 0.5),  
    }
    }
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
        );  
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), asSeenByCurrentNode);
                Settings.EMPTY,
        MutableWorkloadGroupFragment update = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
            new NamedWriteableRegistry(Collections.emptyList()),
                ResiliencyMode.ENFORCED,
    public void testAbsentThrottleLimitUsesInternalUnsetDefault() {
            Settings.EMPTY,
        // Integer.MAX_VALUE is the largest limit the int-backed setting can hold and must be accepted.
        );  
                Settings.builder().put("by", "username").put("node_limit", 10).build()
                + "\"updated_at\":"
        assertFalse(exception.getMessage().contains("ceiling"));  
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        for (String badThrottling : new String[] { "{\"node_limit\":0}", "{\"shared_limit\":5,\"node_limit\":10}" }) {
        Settings throttling = Settings.builder().putNull("by").put("node_limit", 5).build();  
    }
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
            new MutableWorkloadGroupFragment(
    }
            "analytics",
        // Simulate parsing {"settings": null} via XContent  
                now  
            "test",
        );
                    Settings.builder().put("node_limit", badLimit).build()  
            exception.getMessage().contains("Invalid value '" + invalidValue + "' for throttling.node_limit")  
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
                Instant.now().getMillis()
        assertTrue(exception.getMessage().contains("Unknown throttle setting"));  
            "analytics",  
        assertEquals("1m", updated.getSettings().get("search.default_search_timeout"));
            XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        assertThrows(
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));  
                ResiliencyMode.ENFORCED,  
            new MutableWorkloadGroupFragment(
        assertFalse(throttling.keySet().contains("by"));
        assertTrue(throttling.isEmpty());
        Settings.Builder throttling = Settings.builder();  
import org.opensearch.common.UUIDs;
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testUpdateWithAbsentThrottlingPreservesExisting() throws IOException {  
        );
            "test",
        WorkloadGroup existing = new WorkloadGroup(
            () -> new WorkloadGroup(
import org.opensearch.common.xcontent.json.JsonXContent;
                Settings.EMPTY,
                    Settings.EMPTY,  
            Version.V_3_10_0
        // Parse an update request that doesn't include "settings" key  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroup.fromXContent(parser));  
    public void testSettingsNullFromXContentClearsSettings() throws IOException {
            "analytics",  
                null,  
     * Parses to a new instance using the provided {@link XContentParser}
                () -> new MutableWorkloadGroupFragment(
            Settings.builder().put("search.default_search_timeout", "1m").build()
    }
        // Update only timeout — max_concurrent_shard_requests should persist  
        String clearLimitOnly = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"node_limit\":null}}";  
        WorkloadGroup allNull = parseCreate(
            () -> new WorkloadGroup("a".repeat(51), "_id", new MutableWorkloadGroupFragment(), Instant.now().getMillis())
            "{\"resiliency_mode\":\"enforced\",\"resource_limits\":{\"memory\":0.5}," + "\"throttling\":{\"by\":null,\"node_limit\":null}}"  
            new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
            "test_id",
    }
        assertThrows(
    private static final List<ResiliencyMode> allowedModes = List.of(ResiliencyMode.SOFT, ResiliencyMode.ENFORCED, ResiliencyMode.MONITOR);
                Settings.EMPTY,
        assertNotNull(update.getThrottling());  
            _id,  
        );
                Settings.builder().put("search.default_search_timeout", "30s").build()
    }  
        );  
    public void testIllegalWorkloadGroupMode() {  
            NullPointerException.class,  
            exception.getMessage(),  
        WorkloadGroup workloadGroup = parseCreate(  
                Map.of(ResourceType.MEMORY, 0.5),  
    @Override  
                    ResiliencyMode.ENFORCED,
        // A pre-3.10 node writes no throttling; decoding that as empty would clear the group's throttling on update.
     * called multiple times during test execution and should return a different  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
            ),  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        assertEquals(ResiliencyMode.SOFT, updated.getResiliencyMode());  
        // Either disabled, or a positive node_limit with an optional by (absent = group scope).
            String json = String.format(
    protected WorkloadGroup doParseInstance(XContentParser parser) throws IOException {
    }
            )
        assertFalse(builder.toString().contains("throttling"));  
        );  
        XContentBuilder builder = JsonXContent.contentBuilder();
            new NamedWriteableRegistry(Collections.emptyList()),
        assertTrue(updated.getMutableWorkloadGroupFragment().getThrottling().isEmpty());  
            Settings.builder().put("node_limit", 7).build()
            Instant.now().getMillis()
                    ResiliencyMode.ENFORCED,
        WorkloadGroup existing = new WorkloadGroup(
                Settings.EMPTY,  
        assertThrows(
    }
        String tooLarge = Long.toString((long) Integer.MAX_VALUE + 1);  
                Settings.builder().put("by", "username").put("node_limit", Integer.MAX_VALUE).build()  
    }
            currentTimeInMillis
     * Returns a {@link Writeable.Reader} that can be used to de-serialize the instance  
                    Settings.EMPTY,
                ),
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    public void testEffectiveByRejectsUnknownSchema() {  
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(deserialized.getMutableWorkloadGroupFragment().getThrottling()));  
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
        );
            currentTimestamp  
    }
            Settings.EMPTY,
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
            )
                + currentTimeInMillis  
     */
        IllegalArgumentException exception = expectThrows(
                + "\"resource_limits\":{\"cpu\":0.3},"  
                    ResiliencyMode.ENFORCED,
        );
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
        MutableWorkloadGroupFragment updateFragment = builder.getMutableWorkloadGroupFragment();
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        long now = Instant.now().getMillis();
                Settings.builder().put("by", "username").put("node_limit", 10).build()  
            () -> new MutableWorkloadGroupFragment(  
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
    }
        );  
    @Override  
        WorkloadGroup deserialized = new WorkloadGroup(in);
                + "\"resource_limits\":{\"cpu\":0.3},\"settings\":{},\"throttling\":{\"node_limit\":10},"
    /**
        assertEquals(Integer.valueOf(5), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));  
            () -> new WorkloadGroup(  
            )
                "analytics",
    private static WorkloadGroup throttledGroup() {
        assertEquals(Integer.valueOf(5), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));  
            System.currentTimeMillis()
                Map.of(ResourceType.MEMORY, 0.5),
        String expected = String.format(  
    }  
                    Map.of(ResourceType.MEMORY, 0.5),
        );
            new MutableWorkloadGroupFragment(
                Locale.ROOT,
            () -> new WorkloadGroup("analytics", "_id", new MutableWorkloadGroupFragment(randomMode(), null), Instant.now().getMillis())
        String json = "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
                Map.of(ResourceType.MEMORY, 0.5),
        resourceLimit.put(ResourceType.MEMORY, randomDoubleBetween(0.0, 0.80, false));
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
            System.currentTimeMillis()
        // Clearing every key disables throttling; clearing only node_limit leaves a bare by, which is rejected.
    public void testUpdateWithNullClearsThrottleKeys() throws IOException {  
            Settings.builder().put("search.default_search_timeout", "1m").build()
            "{\"resiliency_mode\":\"enforced\",\"resource_limits\":{\"memory\":0.5}," + "\"throttling\":{\"by\":null,\"node_limit\":5}}"
                () -> new MutableWorkloadGroupFragment(  
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"node_limit\":null}}";  
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
        assertEquals(
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), clearBy);
            System.currentTimeMillis()
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 10).build();  
        Settings throttling = WorkloadGroup.updateExistingWorkloadGroup(groupThrottledGroup(), clearLimit)
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            "test_id",  
        assertThrows(  
            "test_id",  
                "_id",  
            "test",
        );
            IllegalArgumentException.class,
                    Settings.EMPTY,  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
            workloadGroupId,  
        assertTrue(exception.getMessage(), exception.getMessage().contains("Unknown throttle setting: attribute"));  
        assertTrue(
 * compatible open source license.
public class WorkloadGroupTests extends AbstractSerializingTestCase<WorkloadGroup> {
        for (String invalidBy : List.of("group", "index", "", "Username", " username ")) {  
    public void testUpdateWithNullFragmentSettingsKeepsExisting() throws IOException {  
    }  
        // by alone configures nothing: the error must say the limit is missing, not leak the -1 sentinel.
        Settings throttling = allNull.getMutableWorkloadGroupFragment().getThrottling();
        assertEquals(ResiliencyMode.SOFT, updated.getResiliencyMode());
        WorkloadGroup workloadGroup = new WorkloadGroup(
                "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
    }
            () -> new WorkloadGroup(  
            )
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"by\":\"username\"}}";
            null,
import org.opensearch.test.AbstractSerializingTestCase;  
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
                    Map.of(ResourceType.MEMORY, 0.5),  
                ResiliencyMode.ENFORCED,
            NullPointerException.class,
            exception.getMessage().contains("Failed to parse value [" + tooLarge + "] for setting [node_limit]")
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), clearAll);  
                Instant.now().getMillis()
            new MutableWorkloadGroupFragment(
            new MutableWorkloadGroupFragment(
            Map.of(ResourceType.MEMORY, 0.5),  
        MutableWorkloadGroupFragment update = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
    }
import java.util.List;
    }
        assertTrue(
            }
    @Override
        return WorkloadGroup::new;
                "analytics",
                new MutableWorkloadGroupFragment(
            ),
        WorkloadGroup workloadGroup = new WorkloadGroup(
        );
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.30), Settings.EMPTY, throttling),
                + "\"settings\":{},"
                Settings.EMPTY,  
                Settings.EMPTY,
            Locale.ROOT,
                Settings.EMPTY,
            + "\"resource_limits\":{\"memory\":0.5},"
        assertTrue(exception.getMessage().contains("throttling.node_limit is required when throttling.by is set"));
                new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
        out.writeString(valid.getName());
    }
        );  
                "test",
        long currentTimestamp = Instant.now().getMillis();
        // Settings should be preserved
            "test_id",
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(workloadGroup.getName());
                ResiliencyMode.ENFORCED,  
            WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), update).getMutableWorkloadGroupFragment().getThrottling().isEmpty()  
            null,
            IllegalArgumentException.class,
    public void testUpdatedAtAllowsCurrentTimestamp() {  
            System.currentTimeMillis()
        assertFalse(throttling.keySet().contains("by"));
            )
                Map.of(ResourceType.MEMORY, 0.5),  
        assertEquals("5", updated.getSettings().get("search.max_concurrent_shard_requests"));  
                "_id",
            Map.of(),  
                ResiliencyMode.ENFORCED,
        );
                ),
        );  
            "test",
            System.currentTimeMillis()
        MutableWorkloadGroupFragment update = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();  
                new MutableWorkloadGroupFragment(randomMode(), Collections.emptyMap()),  
        assertTrue(update.getThrottling().isEmpty());
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{}}";
    public void testNegativeThrottleLimitRejected() {  
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"by\":null,\"node_limit\":null}}";
                new MutableWorkloadGroupFragment(
                    Settings.EMPTY,
            + "\"updated_at\":1720047207}";
                + "\"resource_limits\":{\"cpu\":0.3,\"memory\":0.4},"  
            new MutableWorkloadGroupFragment(
                ResiliencyMode.ENFORCED,
                TEST_WLM_SEARCH_SETTINGS  
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));  
            System.currentTimeMillis()  
        assertTrue(exception.getMessage().contains("Effective throttle ceiling is 0"));  
                Settings.builder().put("by", "username").put("node_limit", tooLarge).build()
            IllegalArgumentException exception = expectThrows(  
    }
    }
        }  
    public void testZeroEffectiveCeilingRejected() {  
    }
 */  
                Map.of(ResourceType.MEMORY, 0.5),
        );
            )  
    public void testUpdateWithEmptySettingsClearsExisting() {
    }
        String workloadGroupId = UUIDs.randomBase64UUID();
    public void testUpdateWithNullByReturnsToGroupScope() throws IOException {
            new MutableWorkloadGroupFragment(randomMode(), resourceLimit, Settings.EMPTY, throttling.build()),
        assertFalse(workloadGroup.getResourceLimits().isEmpty());
                + "\"updated_at\":%d}",  
import org.opensearch.core.xcontent.XContentParser;
                IllegalArgumentException.class,
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
                    Settings.builder().put("by", "username").build()  
        );
            "test_id",
        new MutableWorkloadGroupFragment(
        );  
            Settings.EMPTY,
    public void testToXContentOmitsByForGroupScope() throws IOException {
        String json = "{\"resiliency_mode\":\"soft\",\"resource_limits\":{\"memory\":0.6}}";
            Map.of(),  
                Map.of(ResourceType.MEMORY, 0.5),
                Locale.ROOT,  
                Settings.EMPTY,
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertEquals(ResiliencyMode.SOFT, updated.getResiliencyMode());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":null}";
        Map<ResourceType, Double> resourceLimit = new HashMap<>();  
            XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
        assertEquals(Integer.valueOf(7), WorkloadGroupThrottleSettings.NODE_LIMIT.get(asSeenByCurrentPeer.getThrottling()));
            "TestWorkloadGroup",
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ).writeTo(out);
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(null, Map.of(), Settings.EMPTY);
    }
package org.opensearch.cluster.metadata;
    }
    }  
    }
    public void testUpdateMergesThrottling() {  
        WorkloadGroup existing = new WorkloadGroup(  
import java.util.Map;  
        assertNull(updated.getSettings().get("search.default_search_timeout"));
                Map.of(ResourceType.CPU, 0.30, ResourceType.MEMORY, 0.40),
        MutableWorkloadGroupFragment clearAll = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
        expectThrows(  
            IllegalArgumentException.class,
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    public void testToXContent() throws IOException {  
        // Cluster state from a newer node may use rules this node doesn't know; rejecting it would wedge the node.
 * SPDX-License-Identifier: Apache-2.0
            NullPointerException.class,
            IllegalArgumentException.class,
        for (String badThrottling : new String[] { "{\"node_limit\":0}", "{\"shared_limit\":5,\"node_limit\":10}" }) {  
            new MutableWorkloadGroupFragment(
                Settings.builder().put("bogus_limit", 5).build()  
                    Map.of(ResourceType.MEMORY, 0.5),
            () -> new MutableWorkloadGroupFragment(
            WorkloadGroup workloadGroup = new WorkloadGroup(
        WorkloadGroup workloadGroup = new WorkloadGroup(
            ResiliencyMode.ENFORCED,
        WorkloadGroup workloadGroup = new WorkloadGroup(  
     */
        MutableWorkloadGroupFragment updateFragment = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();  
            Map.of(),  
        assertTrue(workloadGroup.getUpdatedAtInMillis() != 0);
                IllegalArgumentException.class,
        );
    }
                Settings.builder().put("by", "username").put("node_limit", invalidValue).build()
            "test_id",  
    }
                "_id",
            Version.V_3_9_0  
            .getMutableWorkloadGroupFragment()
            NullPointerException.class,
        MutableWorkloadGroupFragment clearBy = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
        );
        WorkloadGroup workloadGroup = new WorkloadGroup(
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
        assertTrue(fragment.getSettings().isEmpty());  
        );
            Settings.builder().putNull("search.default_search_timeout").build()
        WorkloadGroup workloadGroup = new WorkloadGroup(
                Settings.builder().put("by", "username").put("node_limit", 10).build()
        assertTrue(
                Settings.builder().put("node_limit", 5).build()
        assertEquals(currentTimestamp, workloadGroup.getUpdatedAtInMillis());  
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), update);  
            "TestWorkloadGroup",
        XContentBuilder builder = JsonXContent.contentBuilder();
            new NamedWriteableRegistry(Collections.emptyList()),  
        WorkloadGroup existing = new WorkloadGroup(
        return new WorkloadGroup(
            String json = String.format(
                ResiliencyMode.ENFORCED,
        );
        String json = "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
        );  
        String json = "{\"resiliency_mode\":\"soft\",\"resource_limits\":{\"memory\":0.6}}";
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
        WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);  
    }
            );
            WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);
            "TestWorkloadGroup",
            System.currentTimeMillis()  
            new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
    public void testGatewayReadAcceptsInvalidThrottleConfigLeniently() throws IOException {  
            ResiliencyMode.SOFT,
            + "\"settings\":null,"  
    }
        if (randomBoolean()) {
        assertThrows(
            () -> WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), clearLimit)  
            Version.V_3_9_0
        );
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);  
    }
        assertNotNull(workloadGroup.getResourceLimits());
        assertEquals("analytics", workloadGroup.getName());
            new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, 0.4), TEST_WLM_SEARCH_SETTINGS)  
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(groupThrottledGroup(), update);  
        );
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);  
            "test_id",  
        IllegalArgumentException exception = expectThrows(
    public void testCreatePathStillRejectsInvalidThrottleConfig() throws IOException {
    public void testUpdateOverrideRequestValuesPersistsThroughMerge() {  
        WorkloadGroup existing = new WorkloadGroup(
    }
                + "\"settings\":{\"search.default_search_timeout\":\"30s\"},"
    public void testEffectiveByTreatsNullClearMarkerAsGroupScope() {
    }  
        return new WorkloadGroup(
        assertThrows(
import org.opensearch.core.xcontent.ToXContent;  
                "test_id",  
            Settings.EMPTY,  
                    Map.of(ResourceType.MEMORY, 0.5),
        );
        );  
            ),
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.5), Settings.EMPTY),
            assertTrue(exception.getMessage().contains("node_limit must be non-negative"));  
        // Send null for timeout — should remove it, keep max_concurrent  
                ResiliencyMode.ENFORCED,  
        );  
        );
            );
        // The create/update path stays strict.
            IllegalArgumentException.class,
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
            new MutableWorkloadGroupFragment(  
        IllegalArgumentException exception = expectThrows(
            )
            exception.getMessage(),
    }
        assertEquals(  
                ),  
        assertEquals(expected, builder.toString());
            withThrottling,
        // Empty settings should clear all search settings
                "analytics",
                throttling.put("by", randomFrom("username", "role"));  
                ResiliencyMode.ENFORCED,
        // Don't forward to pre-3.10 peers, which would ack without persisting the limit.  
        assertThrows(  
        // Settings should be empty (cleared)
            workloadGroupId,
                Settings.builder().put("search.default_search_timeout", "30s").put("search.max_concurrent_shard_requests", "5").build()
                Map.of(ResourceType.MEMORY, 0.5),  
    public void testCreateDropsNullThrottleValues() throws IOException {  
    }
    public void testByWithoutLimitRejected() {  
        assertEquals(Integer.valueOf(50), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));  
        // Update only node_limit — the absent by key should keep its existing value.
        );
                Settings.builder().put("search.default_search_timeout", "30s").put("override_request_values", "true").build()
import org.opensearch.core.common.io.stream.StreamInput;
            Integer.valueOf(WorkloadGroupThrottleSettings.UNSET_LIMIT),
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();  
            () -> new MutableWorkloadGroupFragment(
                + "\"updated_at\":%d}",
    }  
import org.opensearch.core.common.io.stream.Writeable;
            new MutableWorkloadGroupFragment(  
        // "throttling": null disables throttling entirely  
        assertNotNull(workloadGroup.getName());  
        );
        out.writeString(valid.get_id());  
        );
                null,
        assertEquals(1, workloadGroup.getResourceLimits().size());
    public void testLimitWithoutByUsesGroupScope() {  
    }
            WorkloadGroupThrottleSettings.NODE_LIMIT.get(Settings.EMPTY)
    private static WorkloadGroup groupThrottledGroup() {  
                "test_id",
import java.util.Locale;
                    + "\"resource_limits\":{\"cpu\":0.3},\"throttling\":%s,\"updated_at\":%d}",
        WorkloadGroup existing = new WorkloadGroup(
            Map.of(),
                "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","  
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
    }
            "test_id",
                "_id",
        assertThrows(  
            if (randomBoolean()) {
        // On create, null keys are dropped, so an all-null object means disabled rather than a ceiling error.
        assertFalse("the null clear marker must not be persisted", throttling.keySet().contains("by"));  
        );
                System.currentTimeMillis()
                System.currentTimeMillis()
            Map.of(ResourceType.MEMORY, 0.5),  
     *  
            currentTimeInMillis
            Settings.EMPTY
/*  
        assertNotNull(workloadGroup.get_id());  
        String invalidValue = "not_a_number";  
            NullPointerException.class,
                Instant.now().getMillis()  
        );
        );
        assertTrue(exception.getMessage(), exception.getMessage().contains("Unknown throttle setting: attribute"));
import java.io.IOException;
            System.currentTimeMillis()  
                "_id",
     * random instance each time it is called.
        assertEquals("5", updated.getSettings().get("search.max_concurrent_shard_requests"));  
        long now = Instant.now().getMillis();
            "{\"_id\":\"test_id\",\"name\":\"TestWorkloadGroup\",\"resiliency_mode\":\"enforced\","  
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
        WorkloadGroup workloadGroup = new WorkloadGroup(
            "test",  
        }  
import org.opensearch.Version;
        }
            ),
            )
                -1L
                ResiliencyMode.ENFORCED,
                Map.of(ResourceType.MEMORY, 0.5),
            "test",
        XContentBuilder builder = JsonXContent.contentBuilder();
            () -> new WorkloadGroup(
        );
import java.util.Collections;
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
            MutableWorkloadGroupFragment::new,  
    private static ResiliencyMode randomMode() {  
            () -> new WorkloadGroup(  
    public void testNullResourceLimits() {
    }  
                Map.of(ResourceType.MEMORY, 0.5),
    }
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
        WorkloadGroup workloadGroup = new WorkloadGroup(  
    public void testToXContentEmitsThrottling() throws IOException {  
        MutableWorkloadGroupFragment withThrottling = new MutableWorkloadGroupFragment(
                "test_id",
                ResiliencyMode.ENFORCED,
        assertNotNull(workloadGroup.getResourceLimits());
            currentTimeInMillis
        return WorkloadGroup.Builder.fromXContent(parser).name("test")._id("test_id").updatedAt(System.currentTimeMillis()).build();
        BytesStreamOutput out = new BytesStreamOutput();
                    ResiliencyMode.ENFORCED,  
            );  
        long currentTimeInMillis = Instant.now().getMillis();
    }  
            ),
    }
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"by\":null}}";  
                timestamp  
    public void testThrottleLimitExceedingMaxRejected() {
            update,
     * @param parser the XContentParser
        // Integer.MAX_VALUE + 1 is outside the range accepted by the int-backed Setting parser.
                Settings.builder().put("node_limit", 10).build()
            Instant.ofEpochMilli(1717187289).getMillis()  
    }  
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
    public void testUpdateFromPreThrottlingPeerPreservesThrottling() throws IOException {
    public void testCreateWithNullByUsesGroupScope() throws IOException {
            "{\"_id\":\"%s\",\"name\":\"TestWorkloadGroup\",\"resiliency_mode\":\"enforced\","
    public void testUnknownThrottleKeyRejected() {
    public void testThrottlingIsDroppedWhenWrittenToPreThrottlingPeer() throws IOException {
            currentTimeInMillis  
            "test",
                ResiliencyMode.ENFORCED,
            .getThrottling();  
                new MutableWorkloadGroupFragment(randomMode(), Collections.emptyMap()),
    public void testUpdatedAtRejectsNegativeTimestamp() {  
        return new WorkloadGroup(
        // The same config through the API path is still rejected.
                new MutableWorkloadGroupFragment(null, Map.of(ResourceType.MEMORY, 0.4)),  
            ),
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        );
        long now = Instant.now().getMillis();  
        long currentTimeInMillis = Instant.now().getMillis();
                Map.of(ResourceType.CPU, 0.30),
        );  
                ResiliencyMode.ENFORCED,
        );  
                ResiliencyMode.ENFORCED,  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
        assertTrue(exception.getMessage().contains("search_settings"));
        MutableWorkloadGroupFragment asSeenByCurrentPeer = copyWriteable(
        assertTrue(
        assertTrue(exception.getMessage().contains("throttling.node_limit is required when throttling.by is set"));
            workloadGroupId,
        return WorkloadGroup.fromXContent(parser);
        assertEquals("30s", updated.getSettings().get("search.default_search_timeout"));
    static WorkloadGroup createRandomWorkloadGroup(String _id) {
        WorkloadGroup workloadGroup = new WorkloadGroup(
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
            exception.getMessage(),  
            expectThrows(IllegalArgumentException.class, builder::build);
            ),  
        IllegalArgumentException exception = expectThrows(  
        String workloadGroupId = UUIDs.randomBase64UUID();
        IllegalArgumentException exception = expectThrows(
        long currentTimeInMillis = Instant.now().getMillis();
        assertEquals(TEST_WLM_SEARCH_SETTINGS, workloadGroup.getSettings());
    }
            System.currentTimeMillis()
            IllegalArgumentException.class,
        // The gateway read must not throw on config this node considers invalid, or the node can't start.
        assertEquals("1m", updated.getSettings().get("search.default_search_timeout"));
        assertTrue(throttling.isEmpty());  
import java.util.HashMap;  
import org.opensearch.common.settings.Settings;
            );
    private WorkloadGroup parseCreate(String json) throws IOException {  
            )
import org.opensearch.wlm.ResourceType;  
 *
    public void testEmptyResourceLimits() {  
        assertNull("a pre-3.10 peer must not receive a throttling bag at all", asSeenByOldPeer.getThrottling());
            new MutableWorkloadGroupFragment(  
    public void testUpdateCanAddPrincipalSubdivisionToGroupScope() throws IOException {
            + "\"resource_limits\":{\"memory\":0.5},"
                Map.of(ResourceType.MEMORY, 0.5),  
            ),
                "test",
    public void testUpdateWithNullThrottlingObjectDisables() throws IOException {
                + "\"throttling\":{\"by\":\"username\",\"node_limit\":10},"
    public void testClearingNodeLimitDisablesGroupScopedThrottling() throws IOException {
        assertTrue(updated.getSettings().isEmpty());  
            () -> new WorkloadGroup(
import org.opensearch.common.io.stream.BytesStreamOutput;  
    protected WorkloadGroup createTestInstance() {
            workloadGroupId,  
            "_id",
            MutableWorkloadGroupFragment::new,
    public void testWorkloadGroupInitiation() {  
    }
        WorkloadGroup valid = throttledGroup();  
                "analytics",
            "test",  
                Map.of(ResourceType.MEMORY, 0.5),  
                )
        );
            ),
        MutableWorkloadGroupFragment clearLimit = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
}
            "_id",
            withThrottling,  
        assertTrue(allowedModes.contains(workloadGroup.getResiliencyMode()));
    public void testInvalidResourceLimitWhenInvalidSystemResourceValueIsGiven() {
            ResiliencyMode.ENFORCED,
            new MutableWorkloadGroupFragment(
    public void testUpdateWithNullValueRemovesSetting() {  
        assertEquals(expected, builder.toString());  
        MutableWorkloadGroupFragment asSeenByCurrentNode = copyWriteable(  
                + "}",
            () -> new WorkloadGroup(
            "test",
     * Creates a random test instance to use in the tests. This method will be
        String name = randomAlphaOfLength(10);
    public static final Settings TEST_WLM_SEARCH_SETTINGS = Settings.builder().put("search.default_search_timeout", "30s").build();
    }  
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
        );
        );  
                new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(1.1, 1.8, false))),
            Map.of(),
        assertFalse(exception.getMessage().contains("-1"));
        );
            "test",
        MutableWorkloadGroupFragment update = new MutableWorkloadGroupFragment(  
        assertThrows(  
    public void testLegacySearchSettingsFieldRejected() throws IOException {  
    public void testUpdateWithEmptyThrottlingDisables() throws IOException {
        assertTrue(allowedModes.contains(workloadGroup.getResiliencyMode()));
            null,
        out.writeLong(System.currentTimeMillis());
        );
        assertFalse(workloadGroup.getResourceLimits().isEmpty());  
            "test",
                Settings.builder().put("attribute", "username").put("node_limit", 5).build()  
    public void testValidWorkloadGroup() {
import org.joda.time.Instant;
                "_id",
        }
            System.currentTimeMillis()
                "analytics",  
    }
        );
            MutableWorkloadGroupFragment::new,
    public void testNullId() {
                    Settings.builder().put("by", "username").put("node_limit", 0).build()
    }
            // by with no limit: rejected on the API path, but must be tolerated on the wire
            IllegalArgumentException.class,
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        );
        for (int badLimit : new int[] { -1, -2 }) {
            () -> new MutableWorkloadGroupFragment(  
        // All settings should be cleared
    }
            IllegalArgumentException.class,
        );  
            "test",  
    /**
            IllegalArgumentException.class,
                )
            System.currentTimeMillis()  
                Map.of(ResourceType.MEMORY, 0.5),  
        return createRandomWorkloadGroup("1232sfraeradf_");
        for (long timestamp : timestamps) {
                    Settings.EMPTY,
            IllegalArgumentException.class,
                Settings.builder().put("search.default_search_timeout", "30s").build()
        WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);  
    public void testDeserializationAcceptsThrottlingThisNodeConsidersInvalid() throws IOException {
        MutableWorkloadGroupFragment asSeenByOldPeer = copyWriteable(
            "test_id",  
            ),
        IllegalArgumentException exception = expectThrows(
    public void testUpdatedAtAllowsJitterAroundNow() {  
            ),  
        assertEquals(1717187289, workloadGroup.getUpdatedAtInMillis());  
        MutableWorkloadGroupFragment clearLimit = WorkloadGroup.Builder.fromXContent(limitParser).getMutableWorkloadGroupFragment();
                ResiliencyMode.ENFORCED,
        );
            throttling.put("node_limit", randomIntBetween(1, 100));
        assertFalse(throttling.keySet().contains("node_limit")); // raw check: null-valued key was dropped, not persisted
