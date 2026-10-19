     * {@link #GROUP_SCOPE}; only {@code username} and {@code role} may be supplied explicitly.  
 */  
                throw new IllegalArgumentException(  
                setting.get(Settings.builder().put(key, value).build());
            }
    /** Sentinel for an unset limit, matching the {@code -1 = not set} convention of {@code WLM_SEARCH_TIMEOUT}. */
    /** {@link #BY} value giving each username its own bucket per node. */
    }
                throw new IllegalArgumentException(  
            try {
     * @throws IllegalArgumentException if a {@code by} value has no limit, or the effective ceiling is 0  
    /** Internal dimension used when {@link #BY} is omitted: one bucket for the workload group as a whole. */
            throw new IllegalArgumentException(
                );
    private static final Map<String, Setting<?>> REGISTERED_SETTINGS = Map.of(BY.getKey(), BY, NODE_LIMIT.getKey(), NODE_LIMIT);
    /**
    /** {@link #BY} value giving each role its own bucket per node. */
        return NODE_LIMIT.getKey().equals(key);  
                    "throttling.by must be one of " + ALLOWED_BY_VALUES + " when set but was '" + value + "'"
                if (isPresent && value < 0) {  
/*  
/**
     * Cross-field validation on a fully-merged throttling config. When throttling is configured, {@code node_limit} is
        }  
    /**
    }  
     */  
 * Registry of valid workload group throttle settings with their validators. Throttle config is a nested  
        boolean hasNode = throttling.hasValue(NODE_LIMIT.getKey());
        throw new UnsupportedOperationException("Utility class");
    public static final Set<String> ALLOWED_BY_VALUES = Collections.unmodifiableSet(new LinkedHashSet<>(List.of(BY_USERNAME, BY_ROLE)));
     * @param throttling the throttling settings to validate
        }
import org.opensearch.common.settings.Settings;  
    public static void validateMergedConfig(Settings throttling) {
    /**
 * {@code throttling} object (a {@link Settings} bag) like {@code settings}, so per-key null clears a field and an
            public void validate(Integer value) {}
        public void validate(String value) {
                throw new IllegalArgumentException("Unknown throttle setting: " + key);
     * schema this node does not understand is not silently applied as group throttling.
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;  
import java.util.Collections;
     * per-key {@code null} on update clears a username/role override back to that default.  
    public static final Setting<String> BY = Setting.simpleString("by", GROUP_SCOPE, new Setting.Validator<String>() {
                    throw new IllegalArgumentException("throttling.node_limit must be non-negative but was " + value);
        UNSET_LIMIT,
import org.opensearch.common.settings.Setting;
        }
            if (REGISTERED_SETTINGS.containsKey(key) == false) {  
    );
        }
    public static final String BY_ROLE = "role";
    /**  
            String value = throttling.get(key);
     */
     * required and its effective ceiling must be at least 1, since a ceiling of 0 rejects every request. The optional
            return GROUP_SCOPE;  
        }  
                "Effective throttle ceiling is 0 (node_limit="  
                    + "Set node_limit to a positive value, or set throttling as null to disable throttling"  
import java.util.LinkedHashSet;  
    static boolean isLimitKey(String key) {
            return;
            }  
            if (value == null) {
    }
            @Override
    public static void validate(Settings throttling) {
            // null value means "clear this key" — skip value validation  
                }
            if (GROUP_SCOPE.equals(value) == false && ALLOWED_BY_VALUES.contains(value) == false) {
 * this file be licensed under the Apache-2.0 license or a
                throw new IllegalArgumentException("Unknown throttle setting: " + key);
     */
        "node_limit",  
    public static String getEffectiveBy(Settings throttling) {
    /**  
        if (throttling == null) {  
        @Override  
        }
                );
        return BY.get(throttling);
    public static final String GROUP_SCOPE = "group";
    public static final String BY_USERNAME = "username";
        if (throttling.hasValue(BY.getKey()) == false) {
import java.util.List;
 */  
        }
            }
            }  
        new Setting.Validator<Integer>() {  
            if (throttling.hasValue(BY.getKey())) {
        Integer.MIN_VALUE,
    public static final int UNSET_LIMIT = -1;
     */
 *
    }
 * compatible open source license.
            @Override
     */
    /** True for keys holding an integer limit, which xContent must emit as a JSON number rather than a string. */
                    + node
     * while an explicitly supplied value must be non-negative.  
     * Optional dimension used to subdivide the workload group's allowance. An omitted key resolves to
            public void validate(Integer value, Map<Setting<?>, Object> settings, boolean isPresent) {
     * Returns the effective bucket dimension, defaulting to the implicit group scope. Unknown keys are rejected so a
package org.opensearch.wlm;
    /**
@ExperimentalApi
    public static final Setting<Integer> NODE_LIMIT = Setting.intSetting(
     * @throws IllegalArgumentException if any key is unknown or any value is invalid  
        }
     * {@code by} key defaults to group scope. Must be called on the merged result, not a partial update fragment.  
                    "throttling.by must be one of " + ALLOWED_BY_VALUES + " when set but was '" + value + "'"
import org.opensearch.common.annotation.ExperimentalApi;
            }
     * @param throttling the merged throttling settings
     */
            if (setting == null) {  
    });
            }  
            }  
            return;
                throw new IllegalArgumentException(  
     * Per-key validation: every key must be registered, {@code by} an allowed value, and each limit a non-negative int.
        public void validate(String value, Map<Setting<?>, Object> settings, boolean isPresent) {
                    + "); this would reject all requests. "
            return;
    }
 * absent key keeps the existing value with no extra bookkeeping.
        if (throttling == null) {
            return GROUP_SCOPE;
        if (node < 1) {
     * Safe on a partial update fragment; cross-field checks live in {@link #validateMergedConfig(Settings)}.  
            Setting<?> setting = REGISTERED_SETTINGS.get(key);
                throw new IllegalArgumentException("Invalid value '" + value + "' for throttling." + key + ": " + e.getMessage(), e);
        }
    private WorkloadGroupThrottleSettings() {  
        validate(throttling);  
     * Per-node in-flight allowance admitted locally with no coordination. An absent value resolves to {@link #UNSET_LIMIT},
     * Legal explicit {@link #BY} values. Group scope is deliberately absent: omitting {@code by} selects it, while a
        for (String key : throttling.keySet()) {
            if (isPresent && GROUP_SCOPE.equals(value)) {
        }
     *
public class WorkloadGroupThrottleSettings {
     *
}
        if (throttling == null || throttling.isEmpty()) {  
 * SPDX-License-Identifier: Apache-2.0
                continue;
            }  
import java.util.Map;
                );
                    "throttling.node_limit is required when throttling.by is set; " + "set throttling as null to disable throttling instead"
        if (hasNode == false) {  
        @Override  
            } catch (IllegalArgumentException e) {  
        int node = NODE_LIMIT.get(throttling);  
            // A null-valued key is an update clear marker and configures nothing after merging.
        }  
        for (String key : throttling.keySet()) {  
            );
