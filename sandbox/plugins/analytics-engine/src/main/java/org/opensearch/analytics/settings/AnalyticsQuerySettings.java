        "analytics.query.max_filter_predicate_count",  
     * Maximum number of leaf predicates allowed in a single filter condition. A leaf predicate is
                    "IS_NULL",
     * set the new key explicitly.  
     *
     */
     * rather than failing settings validation. <b>Nothing reads it</b> — the shard ceiling is
     *
                )
        )  
        Setting.Property.NodeScope,
    /**
                    "LESS_THAN",
     * <p>Not {@code Dynamic} — a settings-update consumer would imply something acts on changes.
import org.opensearch.common.settings.Setting;
        500,
     */
     * more latency than the handful of shards it could prune is worth.
            MAX_SHARDS_PER_QUERY,
     * filters, or a sort to collect bounds for. A sorted query lowers the threshold to 1, matching
     * Fan-out above which a query runs the can-match pre-filter phase before dispatching fragments.
    );
     * vanilla's {@code hasPrimaryFieldSort} case: shard ordering and the top-N gate pay for
    /**  
        1,
            PRE_FILTER_SHARD_SIZE,
        5,  
                : List.of(),
     *  
     * themselves as soon as there is a second shard to order against.  
    /**  
     * and stays as N separate leaves — the shape that actually multiplies per-predicate planning and  
     * @deprecated inert; superseded by {@code action.search.shard_count.limit}.
 * compatible open source license.
     * {@link org.opensearch.analytics.planner.dag.ShardTargetResolver} reads live.
 */  
     * 50 and exempted single-index queries; the replacement defaults to unlimited and counts shards
    public static final Setting<Integer> PRE_FILTER_SHARD_SIZE = Setting.intSetting(
            MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE,  
     *
        Setting.Property.Dynamic  
            Setting.Property.Dynamic
            MAX_FILTER_PREDICATE_COUNT
/** Cluster-level settings for analytics query execution limits. */  
    public static final Setting<Integer> MAX_SHARDS_PER_QUERY = Setting.intSetting(
     * <p>Note that comparisons against the same field connected by OR (e.g. {@code x=1 OR x=2 OR
                    "GREATER_THAN_OR_EQUAL",  
    public static final Setting<Integer> MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE = Setting.intSetting(
     */  
     * regardless of how many indices they span. A deployment that relied on the old ceiling has to
     *
     * <p>Only consulted when the query has something for the probe to answer — extractable range  
     * execution cost.
     * {@code Map<BackendName, List<BlockedPredicate>>} contract.
}  
            Setting.Property.NodeScope,
                ? List.of(  
     * acceptor; predicate must have a serializer on that backend) runs in {@code DelegationBlockList}.
        DELEGATION_BLOCKED_PREDICATES_PREFIX,
    /**  
                    "LESS_THAN_OR_EQUAL",
    }  
 *
            DELEGATION_BLOCKED_PREDICATES,  
        50,
    public static List<Setting<?>> all() {
    );
    );
     * (namespaced) setting: the backend name is the namespace, the value is a list of
    /**
            key.contains("lucene")
    public static final Setting.AffixSetting<List<ScalarFunction>> DELEGATION_BLOCKED_PREDICATES = Setting.affixKeySetting(  
     */
        "blocked_predicates",
            key,
        0,
     * <pre>  
                    "NOT_EQUALS",  
     * .shouldPreFilterSearchShards}), including its default of 128: below it the round trip costs  
        key -> Setting.listSetting(  
     * analytics.delegation.lucene.blocked_predicates:  ["LIKE","EQUALS"]
    public static final Setting<Integer> MAX_FILTER_PREDICATE_COUNT = Setting.intSetting(
     * The guard therefore targets fan-out across <em>distinct</em> fields, which cannot be folded
        "analytics.query.pre_filter_shard_size",  
    private AnalyticsQuerySettings() {}
        );
        1,
     *  
     */  
package org.opensearch.analytics.settings;
     * <p>Registered only so a cluster still carrying this key starts with a deprecation warning
                    "GREATER_THAN",
            ScalarFunction::fromToken,  
     *
 * The OpenSearch Contributors require contributions made to  
        Setting.Property.Dynamic
     * exceeding this limit are rejected with HTTP 400 during planning.  
     * predicate before this guard runs, so they count as one predicate regardless of value count.
        return List.of(
    );
                    "SARG_PREDICATE"  
/*  
     * node sees, not the query's overall concurrency.
public final class AnalyticsQuerySettings {
     * <p>Default 500. Set to 0 to disable the guard.  
        128,
        Setting.Property.NodeScope,  
        1,
     * predicate is dropped from that backend's viable set, so the planner leaves it on a non-blocked
        "analytics.query.max_concurrent_shard_requests_per_node",
import org.opensearch.analytics.spi.ScalarFunction;
        Setting.Property.NodeScope,  
    );
     * x=3}, or {@code x IN (1,2,3)}) are folded by Calcite into a single {@code SEARCH(x, Sarg[...])}  
    /** Affix-setting prefix; full key is {@code analytics.delegation.<backend>.blocked_predicates}. */  
        "analytics.query.max_shards_per_query",  
     * Mirrors vanilla's {@code pre_filter_shard_size} ({@code TransportSearchAction
     * <p>Default empty. Enforced at the marking layer ({@code OpenSearchFilterRule}): a blocked
    public static final String DELEGATION_BLOCKED_PREDICATES_PREFIX = "analytics.delegation.";
     * vanilla's {@code action.search.shard_count.limit}, which  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    @Deprecated
     * {@link ScalarFunction} names (case-insensitive). Models the operator-facing  
     *
        Setting.Property.NodeScope,  
     * keeps an independent throttle per target node, so total in-flight requests for a query can be  
                    "IS_NOT_NULL",
     * up to this value times the number of nodes it fans out to — this bounds the load any single
        Setting.Property.Deprecated
        Setting.Property.Dynamic
     * Max in-flight shard fragment requests <b>per data node</b> for a single query. The coordinator
     * any comparison or function call that is not a boolean connective (AND/OR/NOT). Queries
                    "LIKE",
     * </pre>
     * backend. Dynamic + NodeScope. Registry-derived validation (namespace must be a FILTER-delegation  
     * <p>Note the semantics differ, so a value carried over is not equivalent: this one defaulted to  
     * Per-backend block-list of predicate functions that must NOT be delegated to that backend. Affix
