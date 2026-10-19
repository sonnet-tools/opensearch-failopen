    private static void validate(CapabilityRegistry registry, String backendName, List<ScalarFunction> predicates) {
 * backend namespace is valid only if the backend <em>accepts</em> FILTER delegation  
                }  
    private static final Logger LOGGER = LogManager.getLogger(DelegationBlockList.class);
import org.apache.logging.log4j.LogManager;
        return new DelegationBlockList(map);
            if (!delegatable.contains(predicate)) {  
        for (Map.Entry<String, List<ScalarFunction>> e : seed.entrySet()) {
import org.opensearch.analytics.spi.DelegationType;
 */  
            );
     * Production factory: seeds from the current cluster settings and registers an affix update
    private DelegationBlockList(Map<String, EnumSet<ScalarFunction>> blockedByBackend) {
                    "analytics.delegation."
        }  
import java.util.Map;
        return set != null && set.contains(predicate);
 *
        DelegationBlockList blockList = new DelegationBlockList(map);  
     */  
        for (ScalarFunction predicate : predicates) {
                        initial.put(acceptor, applicable);
    /** Test/seed factory from a plain map (assumes pre-validated input). */
        for (Map.Entry<String, List<ScalarFunction>> e : initial.entrySet()) {  
 * only FILTER-delegation acceptor, so any other namespace (e.g. {@code datafusion}) is rejected.  
                if (!defaults.isEmpty()) {
                        + predicate
    /** True iff {@code predicate} is blocked from delegation to {@code backendName}. */
        Map<String, EnumSet<ScalarFunction>> map = new ConcurrentHashMap<>();
            blockedByBackend.remove(backendName);  
        List<String> acceptors = registry.delegationAcceptors(DelegationType.FILTER);
    public boolean isBlocked(String backendName, ScalarFunction predicate) {
        }
                        + ".blocked_predicates: ["
 * <p>The vocabulary is <b>derived from the runtime backend registry</b>, not a parallel enum: a
        set.addAll(values);
                    + acceptors
            validate(registry, e.getKey(), e.getValue());
 * compatible open source license.
     * target backend cannot delegate (no serializer). Called by the affix update validator, so a bad
     * Rejects an invalid block-list entry: an unknown delegation-target backend, or a predicate the  
                    + ".blocked_predicates: ["
            AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES,
        return blockList;
                map.put(e.getKey(), toEnumSet(e.getValue()));  
                        + backendName
    /** Update (or clear) the blocked set for one backend namespace. Called by the settings-update thread. */  
            if (!initial.containsKey(acceptor)) {
        return set;  
        EnumSet<ScalarFunction> set = EnumSet.noneOf(ScalarFunction.class);
        LOGGER.info("Delegation block-list updated: backend [{}] now blocks {}", backendName, blocked);
                    if (!applicable.isEmpty()) {
 *
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
 * so the marking-time hot path ({@link #isBlocked}) is an enum-set membership check.  
        EnumSet<ScalarFunction> set = blockedByBackend.get(backendName);  
 * ships a serializer for it ({@code delegatedPredicateSerializers().keySet()}). Today Lucene is the
                    .getConcreteSettingForNamespace(acceptor);  
 * Validation runs at <b>setting-update time</b> (the affix update consumer / initial seed), so an
 * ({@link CapabilityRegistry#delegationAcceptors}), and a predicate is valid only if that backend
        } else {
                        initial = new HashMap<>(initial);  
                    + backendName
        this.blockedByBackend = blockedByBackend;
import org.opensearch.analytics.planner.CapabilityRegistry;  
                    + "] is not a delegation-target backend; FILTER delegation acceptors are "  
        Map<String, List<ScalarFunction>> initial = AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES.getAsMap(initialSettings);
 * The OpenSearch Contributors require contributions made to  
                    }
import java.util.EnumSet;
    }
 * {@link AnalyticsQuerySettings#DELEGATION_BLOCKED_PREDICATES}. Holds the operator-facing
                Setting<List<ScalarFunction>> concrete = AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES
            return; // clearing a namespace is always allowed  
    /**
        return blockedByBackend.isEmpty();  
                        + "]; delegatable predicates are "
     * that is not a FILTER-delegation acceptor and (2) a predicate the acceptor has no serializer for.
/*  
 *  
import java.util.HashMap;
 */
import org.opensearch.common.settings.Settings;
     * consumer + validator so later {@code analytics.delegation.<backend>.blocked_predicates} changes  
    }
    private static EnumSet<ScalarFunction> toEnumSet(List<ScalarFunction> values) {  
            blockList::update,
            (backendName, predicates) -> validate(registry, backendName, predicates)  
        // Seed missing namespaces with setting defaults (getAsMap skips unset keys).
        if (!acceptors.contains(backendName)) {  
        }  
 * {@code Map<BackendName, List<BlockedPredicate>>} as a {@code Map<String, EnumSet<ScalarFunction>>}
    /**
 * invalid backend or unsupported predicate fails the cluster-settings update with a clear message.
                    Set<ScalarFunction> delegatable = registry.getBackend(acceptor).delegatedPredicateSerializers().keySet();  
package org.opensearch.analytics.settings;
    /** backendName -> blocked predicate functions. Absent/empty entry ⇒ nothing blocked. */
    public static DelegationBlockList empty() {  
    }
        }
                        + delegatable  
import org.opensearch.analytics.spi.ScalarFunction;
import org.opensearch.common.settings.Setting;
        }
                "analytics.delegation."
        }  
        return new DelegationBlockList(new ConcurrentHashMap<>());
import java.util.Set;
    }
        }  
                        + "] is not delegatable to ["  
                List<ScalarFunction> defaults = concrete.get(initialSettings);
import org.opensearch.common.settings.ClusterSettings;  
    }  
        if (blocked == null || blocked.isEmpty()) {
                );
 * @opensearch.internal
        Set<ScalarFunction> delegatable = registry.getBackend(backendName).delegatedPredicateSerializers().keySet();
            map.put(e.getKey(), toEnumSet(e.getValue()));
            }
import java.util.concurrent.ConcurrentHashMap;  
    /** True iff there is at least one block entry (lets callers skip per-predicate work when empty). */
import org.apache.logging.log4j.Logger;
    }
 * Resolved, hot-reloadable view of the per-backend delegation block-list configured via  
     * value fails the cluster-settings update before {@link #update} ever runs.
    }  
    public static DelegationBlockList fromMap(Map<String, List<ScalarFunction>> seed) {
            }
    public boolean isEmpty() {
     * are validated against {@code registry} and applied live. The validator rejects (1) a namespace
                throw new IllegalArgumentException(
    public static DelegationBlockList create(ClusterSettings clusterSettings, Settings initialSettings, CapabilityRegistry registry) {
    private void update(String backendName, List<ScalarFunction> blocked) {
            blockedByBackend.put(backendName, toEnumSet(blocked));
    }
        Map<String, EnumSet<ScalarFunction>> map = new ConcurrentHashMap<>();  
                    List<ScalarFunction> applicable = defaults.stream().filter(delegatable::contains).toList();
            throw new IllegalArgumentException(
        );
                    + backendName  
        for (String acceptor : registry.delegationAcceptors(DelegationType.FILTER)) {  
    private final Map<String, EnumSet<ScalarFunction>> blockedByBackend;
            }
    /** An empty block-list — nothing is blocked. */
 * SPDX-License-Identifier: Apache-2.0
public final class DelegationBlockList {  
            if (!e.getValue().isEmpty()) {
     */  
/**
        clusterSettings.addAffixUpdateConsumer(  
    }
}
                        + backendName  
        if (predicates.isEmpty()) {
