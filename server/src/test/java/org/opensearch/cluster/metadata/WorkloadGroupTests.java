                    Settings.builder().put("by", invalidBy).put("node_limit", 5).build()
                ResiliencyMode.ENFORCED,
    public void testUpdateWithNullThrottlingObjectDisables() throws IOException {
    }
            IllegalArgumentException.class,
            Map.of(ResourceType.MEMORY, 0.5),
                Map.of(ResourceType.MEMORY, 0.5),
                Settings.builder().put("by", "username").put("node_limit", tooLarge).build()
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), clearAll);
            new MutableWorkloadGroupFragment(
    public void testLegacyThrottleAttributeKeyRejected() {
            currentTimeInMillis
        assertNotNull(workloadGroup.getResourceLimits());
import org.opensearch.common.io.stream.BytesStreamOutput;
                ResiliencyMode.ENFORCED,
import org.opensearch.core.xcontent.XContentParser;
        assertThrows(
                new MutableWorkloadGroupFragment(
            WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);
                Settings.builder().put("attribute", "username").put("node_limit", 5).build()
        WorkloadGroup existing = new WorkloadGroup(
        assertEquals(1, workloadGroup.getResourceLimits().size());
            "test",
        );
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
    /**
                IllegalArgumentException.class,
        String json = "{\"resiliency_mode\":\"soft\",\"resource_limits\":{\"memory\":0.6}}";
import org.opensearch.Version;
        assertThrows(
            workloadGroupId,
        String name = randomAlphaOfLength(10);
        Settings.Builder throttling = Settings.builder();
        );
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            new MutableWorkloadGroupFragment(
            )
    }
            exception.getMessage(),
            ),
        String json = "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
     * Creates a random test instance to use in the tests. This method will be
                "test_id",
        assertThrows(
            new NamedWriteableRegistry(Collections.emptyList()),
            IllegalArgumentException.class,
public class WorkloadGroupTests extends AbstractSerializingTestCase<WorkloadGroup> {
                now
    public void testIllegalWorkloadGroupMode() {
                Map.of(ResourceType.MEMORY, 0.5),
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
                Settings.EMPTY,
        assertTrue(exception.getMessage().contains("Unknown throttle setting"));
        );
        assertTrue(updated.getSettings().isEmpty());
                "_id",
            )
            WorkloadGroupThrottleSettings.NODE_LIMIT.get(Settings.EMPTY)
    public void testUpdatedAtRejectsNegativeTimestamp() {
                + "\"settings\":{\"search.default_search_timeout\":\"30s\"},"
        assertNull(updated.getSettings().get("search.default_search_timeout"));
        IllegalArgumentException exception = expectThrows(
    }
            new NamedWriteableRegistry(Collections.emptyList()),
    }
    @Override
                    ResiliencyMode.ENFORCED,
                    Settings.EMPTY,
    public void testUpdateCanAddPrincipalSubdivisionToGroupScope() throws IOException {
        assertEquals("analytics", workloadGroup.getName());
            IllegalArgumentException.class,
        // Don't forward to pre-3.10 peers, which would ack without persisting the limit.
        WorkloadGroup workloadGroup = new WorkloadGroup(
            )
            assertNotNull(WorkloadGroup.fromXContent(parser)); // lenient: must not throw
            "test_id",
                Map.of(ResourceType.MEMORY, 0.5),
            new MutableWorkloadGroupFragment(
            String json = String.format(
        String json = "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
        assertTrue(
        assertEquals("1m", updated.getSettings().get("search.default_search_timeout"));
        // On create, null keys are dropped, so an all-null object means disabled rather than a ceiling error.
        );
            .getMutableWorkloadGroupFragment()
        long currentTimeInMillis = Instant.now().getMillis();
                Map.of(ResourceType.MEMORY, 0.5),
            NullPointerException.class,
    }
    }
            System.currentTimeMillis()
            () -> new WorkloadGroup(
        assertNotNull(update.getThrottling());
        MutableWorkloadGroupFragment asSeenByOldPeer = copyWriteable(
                Settings.builder().put("node_limit", 10).build()
            );
            Map.of(ResourceType.MEMORY, 0.5),
            Settings.builder().putNull("search.default_search_timeout").build()
        MutableWorkloadGroupFragment updateFragment = builder.getMutableWorkloadGroupFragment();
        assertThrows(
        IllegalArgumentException exception = expectThrows(
        // A pre-3.10 node writes no throttling; decoding that as empty would clear the group's throttling on update.
        // The create/update path stays strict.
            exception.getMessage().contains("Invalid value '" + invalidValue + "' for throttling.node_limit")
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"node_limit\":null}}";
            ResiliencyMode.SOFT,
                Instant.now().getMillis()
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(ResiliencyMode.SOFT, updated.getResiliencyMode());
        WorkloadGroup allNull = parseCreate(
            currentTimeInMillis
    public void testClearingNodeLimitDisablesGroupScopedThrottling() throws IOException {
        assertEquals(ResiliencyMode.SOFT, updated.getResiliencyMode());
                Map.of(ResourceType.MEMORY, 0.5),
                Locale.ROOT,
        WorkloadGroup workloadGroup = new WorkloadGroup(
        );
    public void testSettingsNullFromXContentClearsSettings() throws IOException {
            null,
        assertNull("a pre-3.10 peer must not receive a throttling bag at all", asSeenByOldPeer.getThrottling());
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
        assertTrue(allowedModes.contains(workloadGroup.getResiliencyMode()));
                ),
        assertTrue(throttling.isEmpty());
    public void testValidWorkloadGroup() {
                ResiliencyMode.ENFORCED,
                Settings.builder().put("search.default_search_timeout", "30s").put("search.max_concurrent_shard_requests", "5").build()
                + "\"updated_at\":%d}",
    public void testNegativeThrottleLimitRejected() {
    protected Writeable.Reader<WorkloadGroup> instanceReader() {
                () -> new MutableWorkloadGroupFragment(
        // Either disabled, or a positive node_limit with an optional by (absent = group scope).
            "test",
            Version.V_3_9_0
            )
            name,
            "analytics",
        XContentBuilder builder = JsonXContent.contentBuilder();
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    public void testToXContentOmitsByForGroupScope() throws IOException {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> WorkloadGroup.fromXContent(parser));
        MutableWorkloadGroupFragment asSeenByCurrentPeer = copyWriteable(
            () -> new MutableWorkloadGroupFragment(
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            workloadGroupId,
        WorkloadGroup workloadGroup = new WorkloadGroup(
                new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(1.1, 1.8, false))),
            }
                    Map.of(ResourceType.MEMORY, 0.5),
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(null, Map.of(), Settings.EMPTY);
            builder.toString()
    public void testGatewayReadAcceptsInvalidThrottleConfigLeniently() throws IOException {
                    ResiliencyMode.ENFORCED,
        return allowedModes.get(randomIntBetween(0, allowedModes.size() - 1));
                + currentTimeInMillis
    public void testZeroEffectiveCeilingRejected() {
            "test",
            "analytics",
            Map.of(),
import java.util.HashMap;
        );
        assertEquals(expected, builder.toString());
        );
                Map.of(ResourceType.MEMORY, 0.5),
import java.util.Collections;
            null,
                ResiliencyMode.ENFORCED,
        );
                new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
        Settings throttling = allNull.getMutableWorkloadGroupFragment().getThrottling();
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
                ResiliencyMode.ENFORCED,
            "TestWorkloadGroup",
            () -> new WorkloadGroup(
                Settings.builder().put("by", "username").put("node_limit", Integer.MAX_VALUE).build()
    }
            Settings.builder().put("search.default_search_timeout", "1m").build()
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        // Parse an update request that doesn't include "settings" key
    }
        WorkloadGroup existing = new WorkloadGroup(
                Settings.EMPTY,
            IllegalArgumentException.class,
        IllegalArgumentException exception = expectThrows(
        );
        assertEquals("1m", updated.getSettings().get("search.default_search_timeout"));
        assertTrue(
        MutableWorkloadGroupFragment withThrottling = new MutableWorkloadGroupFragment(
        );
            "TestWorkloadGroup",
        // by alone configures nothing: the error must say the limit is missing, not leak the -1 sentinel.
    }
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
                Settings.EMPTY,
            ),
            MutableWorkloadGroupFragment::new,
    }
}
        return new WorkloadGroup(
            () -> new WorkloadGroup(
            Instant.now().getMillis()
    }
        );
            "test",
        );
    public void testCreateWithNullByUsesGroupScope() throws IOException {
        assertEquals("true", updated.getSettings().get("override_request_values"));
        );
        );
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
                "_id",
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
        assertFalse("group scope must have one canonical representation: no by key", throttling.keySet().contains("by"));
 * compatible open source license.
        WorkloadGroup workloadGroup = new WorkloadGroup(
    public void testLegacySearchSettingsFieldRejected() throws IOException {
        return WorkloadGroup.fromXContent(parser);
            () -> WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), clearLimit)
            + "\"updated_at\":1720047207}";
                )
                () -> new MutableWorkloadGroupFragment(
        assertEquals(Integer.valueOf(5), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
        out.writeString(valid.getName());
                "_id",
            () -> new WorkloadGroup(
            "{\"_id\":\"%s\",\"name\":\"TestWorkloadGroup\",\"resiliency_mode\":\"enforced\","
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            new MutableWorkloadGroupFragment(
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
                + "\"settings\":{},"
            workloadGroupId,
        // Simulate parsing {"settings": null} via XContent
        );
            "test_id",
                    ResiliencyMode.ENFORCED,
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"by\":\"username\"}}";
        assertTrue(updated.getMutableWorkloadGroupFragment().getThrottling().isEmpty());
                "_id",
        long now = Instant.now().getMillis();
            "test",
    public void testNullResourceLimits() {
    }
        );
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"by\":null,\"node_limit\":null}}";
            + "\"resource_limits\":{\"memory\":0.5},"
            Settings.builder().put("by", "username").build()
            Version.V_3_10_0
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
        assertNull("the parser must distinguish an omitted throttling field from an explicit empty object", update.getThrottling());
            Settings.EMPTY,
        if (randomBoolean()) {
    public static final Settings TEST_WLM_SEARCH_SETTINGS = Settings.builder().put("search.default_search_timeout", "30s").build();
            System.currentTimeMillis()
    /**
            IllegalArgumentException exception = expectThrows(
    public void testToXContentEmitsThrottling() throws IOException {
            Map.of(),
    }
            ResiliencyMode.ENFORCED,
            exception.getMessage(),
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
            Integer.valueOf(WorkloadGroupThrottleSettings.UNSET_LIMIT),
        String expected = String.format(
        assertNotNull(workloadGroup.get_id());
        assertTrue(exception.getMessage(), exception.getMessage().contains("Unknown throttle setting: attribute"));
            Locale.ROOT,
        assertNotNull(workloadGroup.getName());
            "{\"_id\":\"test_id\",\"name\":\"TestWorkloadGroup\",\"resiliency_mode\":\"enforced\","
                System.currentTimeMillis()
                + "\"updated_at\":%d}",
    }
        new MutableWorkloadGroupFragment(
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), asSeenByCurrentNode);
     * @param parser the XContentParser
                new MutableWorkloadGroupFragment(randomMode(), Collections.emptyMap()),
            + "\"resource_limits\":{\"memory\":0.5},"
        MutableWorkloadGroupFragment clearBy = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
    }
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        WorkloadGroup existing = new WorkloadGroup(
        // Clearing every key disables throttling; clearing only node_limit leaves a bare by, which is rejected.
            () -> new WorkloadGroup("a".repeat(51), "_id", new MutableWorkloadGroupFragment(), Instant.now().getMillis())
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
     */
        IllegalArgumentException exception = expectThrows(
    }
            workloadGroupId,
            )
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
    }
            System.currentTimeMillis()
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
    }
            "analytics",
        XContentBuilder builder = JsonXContent.contentBuilder();
            NullPointerException.class,
                    Map.of(ResourceType.MEMORY, 0.5),
        assertTrue(updated.getMutableWorkloadGroupFragment().getThrottling().isEmpty());
            new MutableWorkloadGroupFragment(
        // Integer.MAX_VALUE is the largest limit the int-backed setting can hold and must be accepted.
            + "\"updated_at\":1720047207}";
import org.joda.time.Instant;
    public void testLimitWithoutByUsesGroupScope() {
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
            currentTimeInMillis
    }
            "TestWorkloadGroup",
            withThrottling,
                "analytics",
        assertEquals(Integer.valueOf(7), WorkloadGroupThrottleSettings.NODE_LIMIT.get(asSeenByCurrentPeer.getThrottling()));
            () -> new WorkloadGroup(
        StreamInput in = out.bytes().streamInput();
    public void testCreateDropsNullThrottleValues() throws IOException {
            ),
        for (String invalidBy : List.of("group", "index", "", "Username", " username ")) {
                ),
            NullPointerException.class,
    @Override
        for (String badThrottling : new String[] { "{\"node_limit\":0}", "{\"shared_limit\":5,\"node_limit\":10}" }) {
        }
        assertTrue(workloadGroup.getUpdatedAtInMillis() != 0);
        assertFalse(throttling.keySet().contains("node_limit")); // raw check: null-valued key was dropped, not persisted
            () -> new WorkloadGroup(
        // Empty settings should clear all search settings
        assertFalse(exception.getMessage().contains("ceiling"));
                Settings.builder().put("by", "username").put("node_limit", 10).build()
            )
                new MutableWorkloadGroupFragment(
                "analytics",
        );
                now
                ResiliencyMode.ENFORCED,
                Settings.builder().put("search.default_search_timeout", "30s").build()
            IllegalArgumentException.class,
    public void testNullId() {
        }
import java.util.Locale;
                + "\"resource_limits\":{\"cpu\":0.3,\"memory\":0.4},"
            withThrottling,
                Map.of(ResourceType.MEMORY, 0.5),
                + "\"throttling\":{\"by\":\"username\",\"node_limit\":10},"
    private static WorkloadGroup groupThrottledGroup() {
            "test_id",
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
            exception.getMessage().contains("Failed to parse value [" + tooLarge + "] for setting [node_limit]")
                Settings.builder().put("bogus_limit", 5).build()
            new MutableWorkloadGroupFragment(
        );
            "test_id",
        );
                ResiliencyMode.ENFORCED,
                Settings.builder().put("search.default_search_timeout", "30s").put("override_request_values", "true").build()
        assertThrows(
                "test",
        WorkloadGroup existing = new WorkloadGroup(
            new NamedWriteableRegistry(Collections.emptyList()),
            new MutableWorkloadGroupFragment(
                "test_id",
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.MEMORY, 0.5), Settings.EMPTY),
    }
            () -> new WorkloadGroup(
        );
                Instant.now().getMillis()
            "test_id",
            () -> WorkloadGroupThrottleSettings.getEffectiveBy(Settings.builder().put("attribute", "username").put("node_limit", 5).build())
 */
        MutableWorkloadGroupFragment clearLimit = WorkloadGroup.Builder.fromXContent(limitParser).getMutableWorkloadGroupFragment();
                Settings.EMPTY,
                System.currentTimeMillis()
            XContentParser parser = createParser(JsonXContent.jsonXContent, json);
                    Settings.builder().put("node_limit", badLimit).build()
                Settings.EMPTY,
    }
     */
            new MutableWorkloadGroupFragment(
        MutableWorkloadGroupFragment clearAll = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
        // Settings should be empty (cleared)
package org.opensearch.cluster.metadata;
        );
            exception.getMessage(),
        Settings throttling = WorkloadGroup.updateExistingWorkloadGroup(groupThrottledGroup(), clearLimit)
            "test",
            IllegalArgumentException.class,
        assertEquals(1717187289, workloadGroup.getUpdatedAtInMillis());
        );
                -1L
                Settings.builder().put("by", "username").put("node_limit", invalidValue).build()
        // All settings should be cleared
                Instant.now().getMillis()
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
        out.writeLong(System.currentTimeMillis());
            ),
            String json = String.format(
                ResiliencyMode.ENFORCED,
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
            currentTimeInMillis
                    + "\"resource_limits\":{\"cpu\":0.3},\"throttling\":%s,\"updated_at\":%d}",
        assertNotNull(workloadGroup.getName());
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
        );
    }
        );
        Map<ResourceType, Double> resourceLimit = new HashMap<>();
                    Map.of(ResourceType.MEMORY, 0.5),
        );
        );
                timestamp
        );
    @Override
        MutableWorkloadGroupFragment update = new MutableWorkloadGroupFragment(
        // Integer.MAX_VALUE + 1 is outside the range accepted by the int-backed Setting parser.
    }
                "test",
        String invalidValue = "not_a_number";
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThrows(
    public void testUpdateOverrideRequestValuesPersistsThroughMerge() {
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(Integer.valueOf(50), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
import org.opensearch.core.xcontent.XContentBuilder;
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    }
                Instant.now().getMillis()
    }
    }
        WorkloadGroup existing = new WorkloadGroup(
    public void testEmptyResourceLimits() {
            assertTrue(exception.getMessage(), exception.getMessage().contains("throttling.by must be one of [username, role]"));
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
        );
            )
                Map.of(ResourceType.CPU, 0.30, ResourceType.MEMORY, 0.40),
        assertTrue(exception.getMessage().contains("throttling.node_limit is required when throttling.by is set"));
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    public void testUpdateWithNullFragmentSettingsKeepsExisting() throws IOException {
                IllegalArgumentException.class,
        );
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
                Settings.builder().put("search.default_search_timeout", "30s").put("search.max_concurrent_shard_requests", "5").build()
    }
            "_id",
            XContentParser parser = createParser(JsonXContent.jsonXContent, json);
                Map.of(ResourceType.MEMORY, 0.5),
        assertEquals(currentTimestamp, workloadGroup.getUpdatedAtInMillis());
 * The OpenSearch Contributors require contributions made to
            IllegalArgumentException.class,
                Map.of(ResourceType.MEMORY, 0.5),
    }
                Settings.builder().put("search.default_search_timeout", "30s").build()
        assertFalse("the null clear marker must not be persisted", throttling.keySet().contains("by"));
        );
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"by\":null}}";
        );
            System.currentTimeMillis()
        MutableWorkloadGroupFragment update = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
                null,
            IllegalArgumentException exception = expectThrows(
                new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
    }
        long now = Instant.now().getMillis();
        );
                Settings.EMPTY,
                Map.of(ResourceType.MEMORY, 0.5),
    }
        WorkloadGroup workloadGroup = parseCreate(
                    + "\"resource_limits\":{\"cpu\":0.3},\"throttling\":%s,\"updated_at\":%d}",
    }
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(groupThrottledGroup(), update);
    public void testUpdateWithNullByReturnsToGroupScope() throws IOException {
                    Settings.EMPTY,
                    Settings.builder().put("by", "username").build()
    }
                ResiliencyMode.ENFORCED,
        IllegalArgumentException exception = expectThrows(
            "test",
                badThrottling,
    public void testAbsentThrottleLimitUsesInternalUnsetDefault() {
    private static final List<ResiliencyMode> allowedModes = List.of(ResiliencyMode.SOFT, ResiliencyMode.ENFORCED, ResiliencyMode.MONITOR);
        );
            new MutableWorkloadGroupFragment(
            () -> new WorkloadGroup(
        );
    }
        );
        return createRandomWorkloadGroup("1232sfraeradf_");
                "analytics",
                "test",
                    ResiliencyMode.ENFORCED,
        for (int badLimit : new int[] { -1, -2 }) {
            NullPointerException.class,
            Settings.EMPTY
                badThrottling,
    public void testThrottleLimitExceedingMaxRejected() {
        IllegalArgumentException exception = expectThrows(
    }
            Settings.EMPTY,
                ResiliencyMode.ENFORCED,
            "test",
            "_id",
                Settings.builder().put("node_limit", 10).build()
            Settings.builder().put("search.default_search_timeout", "1m").build()
                Map.of(ResourceType.CPU, 0.30),
    private WorkloadGroup parseCreate(String json) throws IOException {
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
        );
        assertTrue(exception.getMessage().contains("Effective throttle ceiling is 0"));
                Settings.EMPTY,
        }
        assertEquals(
    }
        );
    private static ResiliencyMode randomMode() {
        String workloadGroupId = UUIDs.randomBase64UUID();
        );
            System.currentTimeMillis()
    public void testUpdatedAtAllowsCurrentTimestamp() {
    public void testToXContent() throws IOException {
     * Returns a {@link Writeable.Reader} that can be used to de-serialize the instance
            () -> new WorkloadGroup("", "_id", new MutableWorkloadGroupFragment(), Instant.now().getMillis())
    }
    public void testThrottleLimitAtMaxAccepted() {
            throttling.put("node_limit", randomIntBetween(1, 100));
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(throttling));
        assertTrue(exception.getMessage(), exception.getMessage().contains("Unknown throttle setting: attribute"));
        // Settings should be preserved
            "{\"resiliency_mode\":\"enforced\",\"resource_limits\":{\"memory\":0.5}," + "\"throttling\":{\"by\":null,\"node_limit\":null}}"
    public void testByWithoutLimitRejected() {
        assertEquals(expected, builder.toString());
                ),
        assertNotNull(workloadGroup.getResourceLimits());
            );
        assertEquals(TEST_WLM_SEARCH_SETTINGS, workloadGroup.getSettings());
        expectThrows(
        );
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), clearBy);
        String json = "{\"resiliency_mode\":\"soft\",\"resource_limits\":{\"memory\":0.6}}";
            () -> new WorkloadGroup(
        MutableWorkloadGroupFragment update = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
    public void testUnknownThrottleKeyRejected() {
     * Parses to a new instance using the provided {@link XContentParser}
        XContentBuilder builder = JsonXContent.contentBuilder();
            System.currentTimeMillis()
            assertTrue(exception.getMessage().contains("node_limit must be non-negative"));
    public void testUpdatedAtAllowsJitterAroundNow() {
    public void testEffectiveByTreatsNullClearMarkerAsGroupScope() {
            + "\"settings\":null,"
        );
        Settings throttling = Settings.builder().put("by", "username").put("node_limit", 10).build();
    }
        return WorkloadGroup::new;
            );
        BytesStreamOutput out = new BytesStreamOutput();
    }
        WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), update);
                new MutableWorkloadGroupFragment(randomMode(), Collections.emptyMap()),
        // Update only node_limit — the absent by key should keep its existing value.
import java.util.Map;
        assertEquals(1, workloadGroup.getResourceLimits().size());
                Settings.EMPTY,
                TEST_WLM_SEARCH_SETTINGS
                    Settings.EMPTY,
            System.currentTimeMillis()
        IllegalArgumentException exception = expectThrows(
            IllegalArgumentException.class,
        );
            expectThrows(IllegalArgumentException.class, builder::build);
        WorkloadGroup workloadGroup = new WorkloadGroup(
     * called multiple times during test execution and should return a different
    public void testDeserializationAcceptsThrottlingThisNodeConsidersInvalid() throws IOException {
                new MutableWorkloadGroupFragment(null, Map.of(ResourceType.MEMORY, 0.4)),
                    ResiliencyMode.ENFORCED,
    public void testUpdateWithEmptySettingsClearsExisting() {
            System.currentTimeMillis()
    public void testUpdateMergesThrottling() {
            // by with no limit: rejected on the API path, but must be tolerated on the wire
            if (randomBoolean()) {
        WorkloadGroup existing = new WorkloadGroup(
    }
        MutableWorkloadGroupFragment clearLimit = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
        IllegalArgumentException exception = expectThrows(
    }
        WorkloadGroup workloadGroup = new WorkloadGroup(
                + "\"updated_at\":"
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            exception.getMessage().contains("Failed to parse value [" + invalidValue + "] for setting [node_limit]")
            new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
        WorkloadGroup workloadGroup = new WorkloadGroup(
    }
    }
import java.util.List;
        );
    public void testUpdateWithNullValueRemovesSetting() {
            "test_id",
        assertEquals(ResiliencyMode.SOFT, updated.getResiliencyMode());
        for (long timestamp : timestamps) {
                + "\"resource_limits\":{\"cpu\":0.3},\"settings\":{},\"throttling\":{\"node_limit\":10},"
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
            () -> new MutableWorkloadGroupFragment(
            ),
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
            MutableWorkloadGroupFragment::new,
        assertEquals("username", WorkloadGroupThrottleSettings.BY.get(deserialized.getMutableWorkloadGroupFragment().getThrottling()));
            "{\"_id\":\"%s\",\"name\":\"TestWorkloadGroup\",\"resiliency_mode\":\"enforced\","
import org.opensearch.wlm.MutableWorkloadGroupFragment;
    public void testThrottlingIsDroppedWhenWrittenToPreThrottlingPeer() throws IOException {
 *
    protected WorkloadGroup createTestInstance() {
        long currentTimeInMillis = Instant.now().getMillis();
        XContentBuilder builder = JsonXContent.contentBuilder();
                Map.of(ResourceType.MEMORY, 0.5),
                ResiliencyMode.ENFORCED,
        return new WorkloadGroup(
            "test",
    public void testUpdateWithAbsentThrottlingPreservesExisting() throws IOException {
        assertTrue(
            "{\"resiliency_mode\":\"enforced\",\"resource_limits\":{\"memory\":0.5}," + "\"throttling\":{\"by\":null,\"node_limit\":5}}"
        );
            "test_id",
                + "}",
    /**
                + "\"resource_limits\":{\"cpu\":0.3},"
            () -> new WorkloadGroup("analytics", "_id", new MutableWorkloadGroupFragment(randomMode(), null), Instant.now().getMillis())
            ),
                "analytics",
    public void testUpdateWithNullClearsThrottleKeys() throws IOException {
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
            () -> new MutableWorkloadGroupFragment(
                Settings.builder().put("by", "username").put("node_limit", 10).build()
            Settings.builder().put("node_limit", 7).build()
                ResiliencyMode.ENFORCED,
        );
        assertFalse(throttling.keySet().contains("by"));
        }
                new MutableWorkloadGroupFragment(
            )
            "test_id",
                Map.of(ResourceType.MEMORY, 0.5),
        assertTrue(update.getThrottling().isEmpty());
            ResiliencyMode.ENFORCED,
            System.currentTimeMillis()
    }
        String workloadGroupId = UUIDs.randomBase64UUID();
        // -1 is the internal "unset" sentinel and, like any negative value, is not user-settable.
            IllegalArgumentException.class,
    public void testWorkloadGroupInitiation() {
                Map.of(ResourceType.MEMORY, 0.5),
        Settings throttling = Settings.builder().putNull("by").put("node_limit", 5).build();
        for (String badThrottling : new String[] { "{\"node_limit\":0}", "{\"shared_limit\":5,\"node_limit\":10}" }) {
                Map.of(ResourceType.MEMORY, 0.5),
            "test",
import org.opensearch.core.xcontent.ToXContent;
    public void testUpdateMergesSettings() {
        String tooLarge = Long.toString((long) Integer.MAX_VALUE + 1);
        // The same config through the API path is still rejected.
            ),
    private static WorkloadGroup throttledGroup() {
            IllegalArgumentException.class,
            ),
        assertEquals(
import java.io.IOException;
                Settings.EMPTY,
        WorkloadGroup workloadGroup = new WorkloadGroup(
            ),
        assertTrue(allowedModes.contains(workloadGroup.getResiliencyMode()));
            )
            );
            ),
            )
            Map.of(),
    public void testEffectiveByRejectsUnknownSchema() {
    }
        MutableWorkloadGroupFragment asSeenByCurrentNode = copyWriteable(
                "_id",
            )
        assertEquals(WorkloadGroupThrottleSettings.GROUP_SCOPE, WorkloadGroupThrottleSettings.getEffectiveBy(throttling));
            Map.of(),
        MutableWorkloadGroupFragment updateFragment = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
        // Send null for timeout — should remove it, keep max_concurrent
    }
    }
        // The gateway read must not throw on config this node considers invalid, or the node can't start.
                ResiliencyMode.ENFORCED,
            "test_id",
            );
    public void testInvalidResourceLimitWhenInvalidSystemResourceValueIsGiven() {
        String clearLimitOnly = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{\"node_limit\":null}}";
                    Settings.EMPTY,
    protected WorkloadGroup doParseInstance(XContentParser parser) throws IOException {
    }
    }
            currentTimestamp
                Settings.EMPTY,
        assertFalse(throttling.keySet().contains("by"));
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(throttling.isEmpty());
            MutableWorkloadGroupFragment::new,
        assertEquals("5", updated.getSettings().get("search.max_concurrent_shard_requests"));
            new MutableWorkloadGroupFragment(
    public void testUpdateFromPreThrottlingPeerPreservesThrottling() throws IOException {
import org.opensearch.wlm.ResourceType;
            IllegalArgumentException.class,
        // Update only timeout — override_request_values should persist as "true"
            Settings.builder().put("node_limit", 50).build()
        assertNotNull(workloadGroup.getSettings());
            IllegalArgumentException.class,
            NullPointerException.class,
            new MutableWorkloadGroupFragment(
            "test",
        assertFalse(workloadGroup.getResourceLimits().isEmpty());
            "test_id",
                Instant.now().getMillis()
            NullPointerException.class,
        assertEquals(Integer.valueOf(10), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
        );
            Instant.ofEpochMilli(1717187289).getMillis()
                System.currentTimeMillis()
                "_id",
                    Settings.EMPTY,
        workloadGroup.toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
     *
                throttling.put("by", randomFrom("username", "role"));
                Locale.ROOT,
        assertTrue(exception.getMessage().contains("search_settings"));
                "test_id",
        // Update only timeout — max_concurrent_shard_requests should persist
            assertEquals(timestamp, workloadGroup.getUpdatedAtInMillis());
            Locale.ROOT,
        String expected = String.format(
import org.opensearch.test.AbstractSerializingTestCase;
        WorkloadGroup existing = new WorkloadGroup(
        assertTrue(exception.getMessage().contains("throttling.node_limit is required when throttling.by is set"));
            )
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
        WorkloadGroup deserialized = new WorkloadGroup(in);
            new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, 0.4), TEST_WLM_SEARCH_SETTINGS)
        // "throttling": null disables throttling entirely
            currentTimeInMillis
    public void testUpdateWithEmptyThrottlingDisables() throws IOException {
        WorkloadGroup valid = throttledGroup();
                Settings.builder().put("by", "username").put("node_limit", 10).build()
                ResiliencyMode.ENFORCED,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        MutableWorkloadGroupFragment fragment = builder.getMutableWorkloadGroupFragment();
        long currentTimestamp = Instant.now().getMillis();
import org.opensearch.common.settings.Settings;
            System.currentTimeMillis()
                null,
import org.opensearch.common.UUIDs;
 * SPDX-License-Identifier: Apache-2.0
                ResiliencyMode.ENFORCED,
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":{}}";
            Version.V_3_9_0
    }
                    Settings.builder().put("by", "username").put("node_limit", 0).build()
    }
                    Settings.builder().put("by", "username").build()
            new MutableWorkloadGroupFragment(
        long now = Instant.now().getMillis();
        );
            + "\"search_settings\":{\"timeout\":\"30s\"},"
    public void testNullName() {
            Settings.EMPTY,
        assertEquals("30s", updated.getSettings().get("search.default_search_timeout"));
        );
                "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
        );
                    Map.of(ResourceType.MEMORY, 0.5),
        assertFalse(exception.getMessage().contains("-1"));
        }
            "test",
        Settings throttling = updated.getMutableWorkloadGroupFragment().getThrottling();
            "test_id",
    }
            () -> new MutableWorkloadGroupFragment(
    }
     */
            new MutableWorkloadGroupFragment(ResiliencyMode.ENFORCED, Map.of(ResourceType.CPU, 0.30), Settings.EMPTY, throttling),
        assertFalse(builder.toString().contains("throttling"));
                )
                new MutableWorkloadGroupFragment(randomMode(), Collections.emptyMap()),
            "test_id",
                Settings.builder().put("node_limit", 5).build()
                "analytics",
        // Cluster state from a newer node may use rules this node doesn't know; rejecting it would wedge the node.
            ),
        );
        assertEquals("5", updated.getSettings().get("search.max_concurrent_shard_requests"));
            null,
        String json = "{\"resource_limits\":{\"memory\":0.5},\"throttling\":null}";
        long currentTimeInMillis = Instant.now().getMillis();
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
                    Map.of(ResourceType.MEMORY, 0.5),
        long[] timestamps = new long[] { Math.max(0L, now - 20L), now + 20L };
    static WorkloadGroup createRandomWorkloadGroup(String _id) {
        return WorkloadGroup.Builder.fromXContent(parser).name("test")._id("test_id").updatedAt(System.currentTimeMillis()).build();
        assertEquals(Integer.valueOf(5), WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling));
        assertTrue(exception.getMessage(), exception.getMessage().contains("Invalid value '" + tooLarge + "' for throttling.node_limit"));
            new MutableWorkloadGroupFragment(randomMode(), resourceLimit, Settings.EMPTY, throttling.build()),
        WorkloadGroup updated = WorkloadGroup.updateExistingWorkloadGroup(existing, updateFragment);
            new MutableWorkloadGroupFragment(
    public void testNonNumericThrottleLimitRejected() {
        assertTrue(fragment.getSettings().isEmpty());
        );
            )
            .getThrottling();
        assertThrows(
        );
        }
            update,
            null,
        WorkloadGroup workloadGroup = new WorkloadGroup(
        assertFalse(workloadGroup.getResourceLimits().isEmpty());
            WorkloadGroup workloadGroup = new WorkloadGroup(
    }
    }
    public void testIllegalWorkloadGroupName() {
            "test_id",
    }
    }
                Settings.EMPTY,
            ),
        MutableWorkloadGroupFragment update = WorkloadGroup.Builder.fromXContent(parser).getMutableWorkloadGroupFragment();
    public void testToXContentOmitsUnsetThrottling() throws IOException {
    }
        MutableWorkloadGroupFragment updateFragment = new MutableWorkloadGroupFragment(
        resourceLimit.put(ResourceType.MEMORY, randomDoubleBetween(0.0, 0.80, false));
    }
import org.opensearch.core.common.io.stream.StreamInput;
        return new WorkloadGroup(
    public void testCreatePathStillRejectsInvalidThrottleConfig() throws IOException {
/*
            _id,
import org.opensearch.core.common.io.stream.Writeable;
     * random instance each time it is called.
                Map.of(ResourceType.MEMORY, 0.5),
        );
            new MutableWorkloadGroupFragment(randomMode(), Map.of(ResourceType.MEMORY, randomDoubleBetween(0.01, 0.8, false))),
            System.currentTimeMillis()
    public void testInvalidThrottleByRejected() {
        );
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
        WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);
        out.writeString(valid.get_id());
        assertThrows(
                "{\"_id\":\"test_id\",\"name\":\"test\",\"resiliency_mode\":\"enforced\","
                ResiliencyMode.ENFORCED,
                "Dummy",
                ResiliencyMode.ENFORCED,
            Settings.EMPTY,
            Map.of(),
        );
            ),
        ).writeTo(out);
    }
        XContentParser limitParser = createParser(JsonXContent.jsonXContent, clearLimitOnly);
        assertThrows(
            WorkloadGroup.updateExistingWorkloadGroup(throttledGroup(), update).getMutableWorkloadGroupFragment().getThrottling().isEmpty()
        assertTrue(
            System.currentTimeMillis()
