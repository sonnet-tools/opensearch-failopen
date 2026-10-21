    private static final String TOPK_DYNAMIC_FILTER_KEPT = "$1";
import java.util.regex.Pattern;
    public static ProfilePlanExtractor extractFrom(Map<String, Object> response, String indexName) {
    // only SortExec is touched; DataSourceExec uses predicate=, not this).
import java.util.Map;
 * The OpenSearch Contributors require contributions made to
    //       WHERE clause), the pruning_predicate is entirely derived from it — scrub both.
import java.util.Optional;
 *       (Lucene fast-path / empty shard).
 *   <li>{@link PlanShapeLayer#SHARD_PHYSICAL} = the SHARD_FRAGMENT stage's task physical plans,
    private static final String SCRUBBED = "<scrubbed>";
    private static Optional<String> physicalPlanOf(List<Map<String, Object>> stages, String executionType) {
        }
                .append(" chosen_backend=")
        "predicate=DynamicFilter \\[[^\\]]*], pruning_predicate=[^,]*, ");
 * four {@link PlanShapeLayer} strings stored in a golden, so a captured plan can be diffed against
 * Turns the {@code profile} block of a {@code /_plugins/_ppl?profile=true} response into the same
import java.util.TreeSet;
            // tree_shape is the delegation shape (CONJUNCTIVE / INTERLEAVED_BOOLEAN_EXPRESSION /
    private static String renderFragment(List<Map<String, Object>> stages) {
 *   <li>{@link PlanShapeLayer#COORD_PHYSICAL} = the COORDINATOR_REDUCE stage's task physical plan,
     * The scrubbed, deduped physical plan for the stage of the given execution type, or empty if
    }
                    distinctPlans.add(scrub(text));
    private static String scrubConstantFoldedProjections(String plan) {
    /**
     * in folded aggregates (min/max/count on different data slices) doesn't break cross-shard dedup.
    private static final Pattern BARE_NUMERIC_LITERAL = Pattern.compile("(?<=^|, )-?\\d+(?= as )");
    // data), so they diverge across shards in multi-shard configs. We scrub bare numeric literals in
 * </ul>
    }
        return lines == null ? "" : String.join("\n", lines);
                throw new AssertionError(
     * Render the four layers from a profile response. {@code indexName} is the concrete index the
    @SuppressWarnings("unchecked")
    public Optional<String> layer(PlanShapeLayer layer) {
                if (physicalPlan instanceof String text && !text.isEmpty()) {
 */
    //   (b) Mixed predicate: when DynamicFilter is appended to static predicates (e.g.
    // DataSourceExec as `predicate=DynamicFilter [ <boundary expr> ]`. The boundary is a runtime value
                }
        "(ProjectionExec: expr=\\[)([^\\]]+)(\\]\\s*\\n\\s*PlaceholderRowExec)"
            TreeSet<String> distinctPlans = new TreeSet<>();
import org.opensearch.analytics.qa.planshape.ExpectedQueryPlan.PlanShapeLayer;
                .append('\n');
        return Optional.empty();
    }
/*
        scrubbed = PURE_DYNAMIC_FILTER_PREDICATE.matcher(scrubbed).replaceAll(PURE_DYNAMIC_FILTER_SCRUBBED);
 *       scrubbed and deduped (all shard tasks are identical after scrubbing). Empty if none
    }
    /** Bare numeric literal as the expression side of "expr as alias" within a ProjectionExec. */
/**
    private static final Pattern MIXED_DYNAMIC_FILTER_BODY = Pattern.compile(
                .append(treeShapeStr)
    }
    // fed by PlaceholderRowExec. The literal values are data-dependent (each shard holds different
        }
        return scrubbed;
            throw new AssertionError("profile.plan has no stages; plan keys=" + planProfile.keySet());
    private static final String INDEX_TOKEN = SCRUBBED;
            if (distinctPlans.isEmpty()) {
        Map<PlanShapeLayer, Optional<String>> layers = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
    /**
     * the stage is absent or carries no task physical plan (Lucene / empty shard). All tasks of a
            Object treeShape = stage.get("tree_shape");
            rendered.append('[')
                .append(" tree_shape=")
    // post-fork `alternatives` (see QueryProfileBuilder TODO), assert on those instead.
        }
                for (String line : fragment) {
    private static String joinLines(List<String> lines) {
    //   (a) Pure DynamicFilter predicate: when the entire predicate= is a DynamicFilter (no static
        while (m.find()) {
        return layers.get(layer);
            String treeShapeStr = (treeShape == null || "None".equals(treeShape)) ? "NONE" : treeShape.toString();
        List<Map<String, Object>> stages = (List<Map<String, Object>>) planProfile.get("stages");
 *       {@code [<execution_type> chosen_backend=<b> tree_shape=<t>]} then that stage's fragment lines.
     * query ran against; every occurrence is scrubbed to {@link #INDEX_TOKEN} so a golden is
 * its {@link ExpectedQueryPlan}. The render + scrub rules here MUST match exactly how goldens were
        "DynamicFilter \\[[^\\]]*]");
    // TopK SortExec's `, filter=[<expr> > N]` is a runtime value, not plan shape — its presence flips
 * authored.
                    "tasks of stage " + executionType + " produced differing physical plans after scrub:\n"
            throw new AssertionError("profile has no 'plan' block; profile keys=" + profile.keySet());
        if (profile == null) {
        // (scrubs only the DynamicFilter body, leaving static predicates intact).
        layers.put(PlanShapeLayer.FRAGMENT, Optional.of(renderFragment(stages)));
                return Optional.empty();
            }
        scrubbed = TOPK_DYNAMIC_FILTER.matcher(scrubbed).replaceAll(TOPK_DYNAMIC_FILTER_KEPT);
 */
 *
        layers.replaceAll((layer, text) -> text.map(t -> t.replace(indexName, INDEX_TOKEN)));
    // derived pruning_predicate diverge across shards. We scrub:
            // and node-agnostic.
    }
    // that depends on data seen so far by the TopK heap — in multi-shard configs, each shard sees
            // null vs the string "None"); canonicalize both to NONE so the value is always present
    private static final String MIXED_DYNAMIC_FILTER_BODY_SCRUBBED =
        StringBuilder rendered = new StringBuilder();
        // The opensearch-sql plugin's QueryProfile {summary, phases, plan} embeds the analytics-engine
    // different data and arrives at a different boundary, so both the DynamicFilter body AND its
    private static final String PURE_DYNAMIC_FILTER_SCRUBBED =
        String scrubbed = FILE_GROUPS.matcher(physicalPlan).replaceAll(FILE_GROUPS_SCRUBBED);
        // plan profile (full_plan + stages) under the `plan` field, so they live at profile.plan.
        Pattern.compile("(preserve_partitioning=\\[[^\\]]*\\]), filter=\\[[^\\]]*\\]");
     * agnostic to which per-shard-count index was provisioned.
 *   <li>{@link PlanShapeLayer#FRAGMENT} = per stage, a header
    private static String stripTrailingNewline(String s) {
        java.util.regex.Matcher m = CONSTANT_FOLDED_PROJECTION.matcher(plan);
    private ProfilePlanExtractor(Map<PlanShapeLayer, Optional<String>> layers) {
    @SuppressWarnings("unchecked")
 *       scrubbed. Empty if there is no coordinator stage (single-shard / non-splitting query).
        layers.put(PlanShapeLayer.SHARD_PHYSICAL, physicalPlanOf(stages, SHARD_FRAGMENT));
        layers.put(PlanShapeLayer.COORD_PHYSICAL, physicalPlanOf(stages, COORDINATOR_REDUCE));
                );
    }
     * PlaceholderRowExec). Replaces bare numeric values with {@code <const>} so per-shard variation
        if (planProfile == null) {
            }
    /** The concrete index name is scrubbed too, so goldens are index-name agnostic. */
        for (Map<String, Object> stage : stages) {
    }
        }
                .append(stage.get("execution_type"))
    @SuppressWarnings("unchecked")
        }
    private static final String SHARD_FRAGMENT = "SHARD_FRAGMENT";
    private static final Pattern FILE_GROUPS = Pattern.compile("file_groups=\\{[^}]*\\}");
 * <ul>
                continue;
 *   <li>{@link PlanShapeLayer#POST_CBO} = {@code profile.full_plan} lines joined by newline.
            }
    //       "predicate=X AND DynamicFilter [ empty ]"), only the DynamicFilter body is scrubbed;
    // controlled axis (captured per segment layout), so it's deterministic and worth asserting.
import java.util.LinkedHashMap;
     * Scrub data-dependent numeric literals in constant-folded projections (ProjectionExec above
 * this file be licensed under the Apache-2.0 license or a
    // TODO(plan-shape): FRAGMENT renders the PRE-FORK marked fragment. Once the profile exposes
            List<String> fragment = (List<String>) stage.get("fragment");
                Object physicalPlan = task.get("physical_plan");
    // with segment count, so we delete the whole clause (anchored on preserve_partitioning=[...] so
    private static final Pattern PURE_DYNAMIC_FILTER_PREDICATE = Pattern.compile(
            String exprs = m.group(2);
     * stage are expected to be identical after scrubbing; a divergence is a real finding and fails.
    // Constant-folded aggregates: when an aggregate (e.g. min/max) can be resolved at plan-time from
        return s.endsWith("\n") ? s.substring(0, s.length() - 1) : s;
                    rendered.append(line).append('\n');
    //       the static predicates and their pruning_predicate remain for assertion.
    // parquet metadata, DataFusion folds the entire subtree to a ProjectionExec of literal constants
    /** Host/UUID/shard/generation-specific parquet path. */
    // vanishes and the rule no longer fires — the structural change is still caught.
        "DynamicFilter [ " + SCRUBBED + " ]";
        m.appendTail(sb);
    );
        return stripTrailingNewline(rendered.toString());
            if (distinctPlans.size() > 1) {
            }
    private final Map<PlanShapeLayer, Optional<String>> layers;
            if (tasks == null) {
     */
        // DynamicFilter scrub: pure first (scrubs both predicate + pruning_predicate), then mixed
        for (Map<String, Object> stage : stages) {
                        + String.join("\n--- vs ---\n", distinctPlans)
    // DataSourceExec DynamicFilter predicate: the TopK optimization pushes a boundary filter down into
    private static final String COORDINATOR_REDUCE = "COORDINATOR_REDUCE";
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");
 * compatible open source license.
 *
        }
                .append(']')
    private static final Pattern CONSTANT_FOLDED_PROJECTION = Pattern.compile(
            throw new AssertionError("response has no 'profile' block — request must set profile=true");
            List<Map<String, Object>> tasks = (List<Map<String, Object>>) stage.get("tasks");
        Map<String, Object> planProfile = (Map<String, Object>) profile.get("plan");
}
    /**
            // ...) and MUST be asserted. "Absent" serializes inconsistently across builds (JSON
                }
    /** Single consistent token for every non-deterministic value we redact from a plan. */
            for (Map<String, Object> task : tasks) {
    }
        if (stages == null) {
                return Optional.empty();
            }
        "predicate=DynamicFilter [ " + SCRUBBED + " ], pruning_predicate=" + SCRUBBED + ", ";
                .append(stage.get("chosen_backend"))
     */
            m.appendReplacement(sb, java.util.regex.Matcher.quoteReplacement(m.group(1) + scrubbedExprs + m.group(3)));
        return new ProfilePlanExtractor(layers);
    private static String scrub(String physicalPlan) {
     */
        scrubbed = scrubConstantFoldedProjections(scrubbed);
            if (fragment != null) {
        return sb.toString();
        layers.put(PlanShapeLayer.POST_CBO, Optional.of(joinLines((List<String>) planProfile.get("full_plan"))));
    // such projections. Safety: if the optimizer stops constant-folding (regression), PlaceholderRowExec
    /** The captured plan text for a layer, or empty if that layer was absent in the response. */
        scrubbed = MIXED_DYNAMIC_FILTER_BODY.matcher(scrubbed).replaceAll(MIXED_DYNAMIC_FILTER_BODY_SCRUBBED);
            String scrubbedExprs = BARE_NUMERIC_LITERAL.matcher(exprs).replaceAll(SCRUBBED);
public final class ProfilePlanExtractor {
        this.layers = layers;
    // input_partitions is deliberately NOT scrubbed: it equals the shard's segment count, which is a
import java.util.List;
            }
    private static final String FILE_GROUPS_SCRUBBED = "file_groups={" + SCRUBBED + "}";
            return Optional.of(distinctPlans.first());
 * SPDX-License-Identifier: Apache-2.0
    private static final Pattern TOPK_DYNAMIC_FILTER =
package org.opensearch.analytics.qa.planshape;
            if (!executionType.equals(stage.get("execution_type"))) {
