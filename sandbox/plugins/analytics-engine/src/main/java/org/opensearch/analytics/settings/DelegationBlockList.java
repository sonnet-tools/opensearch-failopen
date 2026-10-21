 *
                    + "] is not a delegation-target backend; FILTER delegation acceptors are "
            return; // clearing a namespace is always allowed
    /** Update (or clear) the blocked set for one backend namespace. Called by the settings-update thread. */
                        + delegatable
import org.opensearch.analytics.spi.DelegationType;
        for (Map.Entry<String, List<ScalarFunction>> e : seed.entrySet()) {
import java.util.EnumSet;
 * SPDX-License-Identifier: Apache-2.0
}
            blockedByBackend.put(backendName, toEnumSet(blocked));
        LOGGER.info("Delegation block-list updated: backend [{}] now blocks {}", backendName, blocked);
    private static EnumSet<ScalarFunction> toEnumSet(List<ScalarFunction> values) {
    public boolean isBlocked(String backendName, ScalarFunction predicate) {
     * are validated against {@code registry} and applied live. The validator rejects (1) a namespace
     * target backend cannot delegate (no serializer). Called by the affix update validator, so a bad
        }
        Map<String, EnumSet<ScalarFunction>> map = new ConcurrentHashMap<>();
     * Production factory: seeds from the current cluster settings and registers an affix update
 * so the marking-time hot path ({@link #isBlocked}) is an enum-set membership check.
                "analytics.delegation."
    private static final Logger LOGGER = LogManager.getLogger(DelegationBlockList.class);
 */
        for (Map.Entry<String, List<ScalarFunction>> e : initial.entrySet()) {
 * ships a serializer for it ({@code delegatedPredicateSerializers().keySet()}). Today Lucene is the
        if (predicates.isEmpty()) {
            }
                Setting<List<ScalarFunction>> concrete = AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES
    private static void validate(CapabilityRegistry registry, String backendName, List<ScalarFunction> predicates) {
import java.util.HashMap;
                    Set<ScalarFunction> delegatable = registry.getBackend(acceptor).delegatedPredicateSerializers().keySet();
import java.util.List;
     * value fails the cluster-settings update before {@link #update} ever runs.
                );
                map.put(e.getKey(), toEnumSet(e.getValue()));
    }
                        + "] is not delegatable to ["
    public static DelegationBlockList empty() {
            validate(registry, e.getKey(), e.getValue());
 * this file be licensed under the Apache-2.0 license or a
        DelegationBlockList blockList = new DelegationBlockList(map);
     * that is not a FILTER-delegation acceptor and (2) a predicate the acceptor has no serializer for.
        Set<ScalarFunction> delegatable = registry.getBackend(backendName).delegatedPredicateSerializers().keySet();
            if (!delegatable.contains(predicate)) {
 * <p>The vocabulary is <b>derived from the runtime backend registry</b>, not a parallel enum: a
    }
        Map<String, EnumSet<ScalarFunction>> map = new ConcurrentHashMap<>();
        }
    /** An empty block-list — nothing is blocked. */
import java.util.concurrent.ConcurrentHashMap;
        return blockList;
            throw new IllegalArgumentException(
    public static DelegationBlockList create(ClusterSettings clusterSettings, Settings initialSettings, CapabilityRegistry registry) {
 *
 * invalid backend or unsupported predicate fails the cluster-settings update with a clear message.
        if (blocked == null || blocked.isEmpty()) {
            if (!initial.containsKey(acceptor)) {
public final class DelegationBlockList {
    private DelegationBlockList(Map<String, EnumSet<ScalarFunction>> blockedByBackend) {
    /** True iff there is at least one block entry (lets callers skip per-predicate work when empty). */
import org.opensearch.analytics.spi.ScalarFunction;
     */
                    + acceptors
                    List<ScalarFunction> applicable = defaults.stream().filter(delegatable::contains).toList();
 * backend namespace is valid only if the backend <em>accepts</em> FILTER delegation
                }
import org.opensearch.common.settings.Setting;
        return blockedByBackend.isEmpty();
                        + "]; delegatable predicates are "
        EnumSet<ScalarFunction> set = blockedByBackend.get(backendName);
        for (ScalarFunction predicate : predicates) {
import org.opensearch.common.settings.ClusterSettings;
                        + predicate
                        + backendName
                        initial = new HashMap<>(initial);
 * @opensearch.internal
    public static DelegationBlockList fromMap(Map<String, List<ScalarFunction>> seed) {
 * Validation runs at <b>setting-update time</b> (the affix update consumer / initial seed), so an
        Map<String, List<ScalarFunction>> initial = AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES.getAsMap(initialSettings);
/*
        EnumSet<ScalarFunction> set = EnumSet.noneOf(ScalarFunction.class);
 * compatible open source license.
                        initial.put(acceptor, applicable);
    public boolean isEmpty() {
                    "analytics.delegation."
import java.util.Set;
/**
            }
                if (!defaults.isEmpty()) {
    }
            blockList::update,
                throw new IllegalArgumentException(
                    if (!applicable.isEmpty()) {
    }
    private void update(String backendName, List<ScalarFunction> blocked) {
import org.apache.logging.log4j.Logger;
 * {@link AnalyticsQuerySettings#DELEGATION_BLOCKED_PREDICATES}. Holds the operator-facing
        for (String acceptor : registry.delegationAcceptors(DelegationType.FILTER)) {
    }
            blockedByBackend.remove(backendName);
    }
     * consumer + validator so later {@code analytics.delegation.<backend>.blocked_predicates} changes
import org.opensearch.analytics.planner.CapabilityRegistry;
        return new DelegationBlockList(map);
    }
 */
    /**
     */
            }
    /** True iff {@code predicate} is blocked from delegation to {@code backendName}. */
                    }
 * {@code Map<BackendName, List<BlockedPredicate>>} as a {@code Map<String, EnumSet<ScalarFunction>>}
import java.util.Map;
            map.put(e.getKey(), toEnumSet(e.getValue()));
                        + backendName
        set.addAll(values);
        }
        }
        return set;
                List<ScalarFunction> defaults = concrete.get(initialSettings);
    /** backendName -> blocked predicate functions. Absent/empty entry ⇒ nothing blocked. */
                    + ".blocked_predicates: ["
        }
                    .getConcreteSettingForNamespace(acceptor);
        List<String> acceptors = registry.delegationAcceptors(DelegationType.FILTER);
import org.apache.logging.log4j.LogManager;
        clusterSettings.addAffixUpdateConsumer(
    /**
        return set != null && set.contains(predicate);
        }
 * only FILTER-delegation acceptor, so any other namespace (e.g. {@code datafusion}) is rejected.
                        + ".blocked_predicates: ["
                    + backendName
 * ({@link CapabilityRegistry#delegationAcceptors}), and a predicate is valid only if that backend
        return new DelegationBlockList(new ConcurrentHashMap<>());
        } else {
                    + backendName
 * Resolved, hot-reloadable view of the per-backend delegation block-list configured via
    }
            AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES,
            (backendName, predicates) -> validate(registry, backendName, predicates)
        this.blockedByBackend = blockedByBackend;
        );
            );
        // Seed missing namespaces with setting defaults (getAsMap skips unset keys).
import org.opensearch.common.settings.Settings;
        }
    }
    /** Test/seed factory from a plain map (assumes pre-validated input). */
            if (!e.getValue().isEmpty()) {
 *
package org.opensearch.analytics.settings;
     * Rejects an invalid block-list entry: an unknown delegation-target backend, or a predicate the
    private final Map<String, EnumSet<ScalarFunction>> blockedByBackend;
        if (!acceptors.contains(backendName)) {
 * The OpenSearch Contributors require contributions made to
