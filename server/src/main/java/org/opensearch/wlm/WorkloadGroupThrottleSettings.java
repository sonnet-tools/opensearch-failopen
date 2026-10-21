import org.opensearch.common.settings.Settings;
        return NODE_LIMIT.getKey().equals(key);
            if (isPresent && GROUP_SCOPE.equals(value)) {
            if (setting == null) {
 * compatible open source license.
 */
                throw new IllegalArgumentException("Unknown throttle setting: " + key);
    );
public class WorkloadGroupThrottleSettings {
        }
                    + node
        public void validate(String value) {
        for (String key : throttling.keySet()) {
    });
        if (node < 1) {
        int node = NODE_LIMIT.get(throttling);
        if (hasNode == false) {
    }
            }
     * @throws IllegalArgumentException if any key is unknown or any value is invalid
import java.util.List;
    /** {@link #BY} value giving each role its own bucket per node. */
    }
                }
     * schema this node does not understand is not silently applied as group throttling.
            return GROUP_SCOPE;
     *
import java.util.Map;
     * {@code by} key defaults to group scope. Must be called on the merged result, not a partial update fragment.
            } catch (IllegalArgumentException e) {
        @Override
            }
    /**
 * absent key keeps the existing value with no extra bookkeeping.
}
            String value = throttling.get(key);
     */
                throw new IllegalArgumentException(
    /** Internal dimension used when {@link #BY} is omitted: one bucket for the workload group as a whole. */
     * @throws IllegalArgumentException if a {@code by} value has no limit, or the effective ceiling is 0
import org.opensearch.common.annotation.ExperimentalApi;
     * @param throttling the throttling settings to validate
    /** {@link #BY} value giving each username its own bucket per node. */
        @Override
        if (throttling == null || throttling.isEmpty()) {
            }
            if (value == null) {
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
            try {
            public void validate(Integer value) {}
     *
     * Cross-field validation on a fully-merged throttling config. When throttling is configured, {@code node_limit} is
 *
        "node_limit",
        }
        if (throttling == null) {
    /** True for keys holding an integer limit, which xContent must emit as a JSON number rather than a string. */
            return;
            throw new IllegalArgumentException(
@ExperimentalApi
        UNSET_LIMIT,
     * Safe on a partial update fragment; cross-field checks live in {@link #validateMergedConfig(Settings)}.
        }
                    + "Set node_limit to a positive value, or set throttling as null to disable throttling"
            @Override
                );
 * Registry of valid workload group throttle settings with their validators. Throttle config is a nested
        }
    public static final String BY_ROLE = "role";
    /**
    private WorkloadGroupThrottleSettings() {
            );
     * Returns the effective bucket dimension, defaulting to the implicit group scope. Unknown keys are rejected so a
            return GROUP_SCOPE;
    public static final int UNSET_LIMIT = -1;
import java.util.LinkedHashSet;
     */
        new Setting.Validator<Integer>() {
     * {@link #GROUP_SCOPE}; only {@code username} and {@code role} may be supplied explicitly.
     */
    private static final Map<String, Setting<?>> REGISTERED_SETTINGS = Map.of(BY.getKey(), BY, NODE_LIMIT.getKey(), NODE_LIMIT);
            }
        validate(throttling);
            public void validate(Integer value, Map<Setting<?>, Object> settings, boolean isPresent) {
     * Per-key validation: every key must be registered, {@code by} an allowed value, and each limit a non-negative int.
/**
 * this file be licensed under the Apache-2.0 license or a
/*
    /** Sentinel for an unset limit, matching the {@code -1 = not set} convention of {@code WLM_SEARCH_TIMEOUT}. */
                "Effective throttle ceiling is 0 (node_limit="
    }
            }
        }
import java.util.Set;
     * @param throttling the merged throttling settings
        boolean hasNode = throttling.hasValue(NODE_LIMIT.getKey());
        Integer.MIN_VALUE,
                    throw new IllegalArgumentException("throttling.node_limit must be non-negative but was " + value);
     * Legal explicit {@link #BY} values. Group scope is deliberately absent: omitting {@code by} selects it, while a
        for (String key : throttling.keySet()) {
            Setting<?> setting = REGISTERED_SETTINGS.get(key);
    static boolean isLimitKey(String key) {
     * Per-node in-flight allowance admitted locally with no coordination. An absent value resolves to {@link #UNSET_LIMIT},
                throw new IllegalArgumentException("Invalid value '" + value + "' for throttling." + key + ": " + e.getMessage(), e);
                );
            }
            }
                throw new IllegalArgumentException(
            if (REGISTERED_SETTINGS.containsKey(key) == false) {
            if (throttling.hasValue(BY.getKey())) {
                continue;
                );
        }
     */
            @Override
            // null value means "clear this key" — skip value validation
        }
        }
    public static String getEffectiveBy(Settings throttling) {
                    + "); this would reject all requests. "
     * while an explicitly supplied value must be non-negative.
                    "throttling.by must be one of " + ALLOWED_BY_VALUES + " when set but was '" + value + "'"
 * {@code throttling} object (a {@link Settings} bag) like {@code settings}, so per-key null clears a field and an
import java.util.Collections;
package org.opensearch.wlm;
            // A null-valued key is an update clear marker and configures nothing after merging.
     * required and its effective ceiling must be at least 1, since a ceiling of 0 rejects every request. The optional
                throw new IllegalArgumentException("Unknown throttle setting: " + key);
                    "throttling.node_limit is required when throttling.by is set; " + "set throttling as null to disable throttling instead"
    public static final String GROUP_SCOPE = "group";
                    "throttling.by must be one of " + ALLOWED_BY_VALUES + " when set but was '" + value + "'"
     */
            return;
        throw new UnsupportedOperationException("Utility class");
    /**
        return BY.get(throttling);
        }
 */
    /**
        }
    /**
        if (throttling == null) {
        if (throttling.hasValue(BY.getKey()) == false) {
    }
        }
    public static final Setting<String> BY = Setting.simpleString("by", GROUP_SCOPE, new Setting.Validator<String>() {
    public static final Setting<Integer> NODE_LIMIT = Setting.intSetting(
    public static void validate(Settings throttling) {
     * Optional dimension used to subdivide the workload group's allowance. An omitted key resolves to
    public static final String BY_USERNAME = "username";
                throw new IllegalArgumentException(
 * The OpenSearch Contributors require contributions made to
            if (GROUP_SCOPE.equals(value) == false && ALLOWED_BY_VALUES.contains(value) == false) {
                if (isPresent && value < 0) {
import org.opensearch.common.settings.Setting;
            return;
    public static void validateMergedConfig(Settings throttling) {
     */
                setting.get(Settings.builder().put(key, value).build());
            }
        public void validate(String value, Map<Setting<?>, Object> settings, boolean isPresent) {
    public static final Set<String> ALLOWED_BY_VALUES = Collections.unmodifiableSet(new LinkedHashSet<>(List.of(BY_USERNAME, BY_ROLE)));
     * per-key {@code null} on update clears a username/role override back to that default.
