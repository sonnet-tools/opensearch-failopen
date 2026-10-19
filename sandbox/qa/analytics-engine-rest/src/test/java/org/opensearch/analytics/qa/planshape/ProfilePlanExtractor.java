            throw new AssertionError("profile has no 'plan' block; profile keys=" + profile.keySet());
     * Render the four layers from a profile response. {@code indexName} is the concrete index the  
 * <ul>
     * PlaceholderRowExec). Replaces bare numeric values with {@code <const>} so per-shard variation
    private static String scrubConstantFoldedProjections(String plan) {
 *       {@code [<execution_type> chosen_backend=<b> tree_shape=<t>]} then that stage's fragment lines.
    private static String stripTrailingNewline(String s) {  
        return stripTrailingNewline(rendered.toString());
            if (tasks == null) {
        layers.put(PlanShapeLayer.POST_CBO, Optional.of(joinLines((List<String>) planProfile.get("full_plan"))));
     * query ran against; every occurrence is scrubbed to {@link #INDEX_TOKEN} so a golden is
        }
 */
        "DynamicFilter [ " + SCRUBBED + " ]";
                return Optional.empty();  
    // TODO(plan-shape): FRAGMENT renders the PRE-FORK marked fragment. Once the profile exposes
     * Scrub data-dependent numeric literals in constant-folded projections (ProjectionExec above
        "(ProjectionExec: expr=\\[)([^\\]]+)(\\]\\s*\\n\\s*PlaceholderRowExec)"
    private static final Pattern MIXED_DYNAMIC_FILTER_BODY = Pattern.compile(
    //   (a) Pure DynamicFilter predicate: when the entire predicate= is a DynamicFilter (no static  
    }  
            // and node-agnostic.
        StringBuilder sb = new StringBuilder();
        scrubbed = scrubConstantFoldedProjections(scrubbed);
                throw new AssertionError(  
            if (distinctPlans.isEmpty()) {
    public static ProfilePlanExtractor extractFrom(Map<String, Object> response, String indexName) {
 *   <li>{@link PlanShapeLayer#FRAGMENT} = per stage, a header  
            Object treeShape = stage.get("tree_shape");
    // different data and arrives at a different boundary, so both the DynamicFilter body AND its
     * agnostic to which per-shard-count index was provisioned.
        return Optional.empty();
    private static final String SHARD_FRAGMENT = "SHARD_FRAGMENT";  
    @SuppressWarnings("unchecked")  
    // DataSourceExec as `predicate=DynamicFilter [ <boundary expr> ]`. The boundary is a runtime value
            for (Map<String, Object> task : tasks) {
    // that depends on data seen so far by the TopK heap — in multi-shard configs, each shard sees  
/**
    private static final String FILE_GROUPS_SCRUBBED = "file_groups={" + SCRUBBED + "}";
            }
        for (Map<String, Object> stage : stages) {
import java.util.List;
    // parquet metadata, DataFusion folds the entire subtree to a ProjectionExec of literal constants
 *       scrubbed and deduped (all shard tasks are identical after scrubbing). Empty if none  
        return lines == null ? "" : String.join("\n", lines);  
        layers.put(PlanShapeLayer.COORD_PHYSICAL, physicalPlanOf(stages, COORDINATOR_REDUCE));
import java.util.regex.Pattern;
     * stage are expected to be identical after scrubbing; a divergence is a real finding and fails.
import java.util.Map;
 * Turns the {@code profile} block of a {@code /_plugins/_ppl?profile=true} response into the same
     */
    private static final String INDEX_TOKEN = SCRUBBED;
        // plan profile (full_plan + stages) under the `plan` field, so they live at profile.plan.
package org.opensearch.analytics.qa.planshape;
    // only SortExec is touched; DataSourceExec uses predicate=, not this).
        if (stages == null) {
    private static final String PURE_DYNAMIC_FILTER_SCRUBBED =
                return Optional.empty();
            rendered.append('[')
     * The scrubbed, deduped physical plan for the stage of the given execution type, or empty if
        this.layers = layers;  
    }
 *       (Lucene fast-path / empty shard).
        if (planProfile == null) {
        while (m.find()) {
    }
     */  
    private static String renderFragment(List<Map<String, Object>> stages) {
    private ProfilePlanExtractor(Map<PlanShapeLayer, Optional<String>> layers) {
    }
                .append('\n');
    // TopK SortExec's `, filter=[<expr> > N]` is a runtime value, not plan shape — its presence flips  
 * this file be licensed under the Apache-2.0 license or a
                .append(" chosen_backend=")  
    private static String scrub(String physicalPlan) {
    // data), so they diverge across shards in multi-shard configs. We scrub bare numeric literals in  
        scrubbed = TOPK_DYNAMIC_FILTER.matcher(scrubbed).replaceAll(TOPK_DYNAMIC_FILTER_KEPT);  
    /**
    /** Bare numeric literal as the expression side of "expr as alias" within a ProjectionExec. */  
 * </ul>
            TreeSet<String> distinctPlans = new TreeSet<>();
    private static final String COORDINATOR_REDUCE = "COORDINATOR_REDUCE";
        return scrubbed;  
    @SuppressWarnings("unchecked")  
    }
import java.util.LinkedHashMap;  
        }  
                if (physicalPlan instanceof String text && !text.isEmpty()) {
            if (distinctPlans.size() > 1) {
            if (fragment != null) {
        }  
    //   (b) Mixed predicate: when DynamicFilter is appended to static predicates (e.g.
    // derived pruning_predicate diverge across shards. We scrub:
    public Optional<String> layer(PlanShapeLayer layer) {
                .append(stage.get("chosen_backend"))
        "DynamicFilter \\[[^\\]]*]");
        String scrubbed = FILE_GROUPS.matcher(physicalPlan).replaceAll(FILE_GROUPS_SCRUBBED);
        layers.put(PlanShapeLayer.FRAGMENT, Optional.of(renderFragment(stages)));
                continue;
        // DynamicFilter scrub: pure first (scrubs both predicate + pruning_predicate), then mixed
 * four {@link PlanShapeLayer} strings stored in a golden, so a captured plan can be diffed against  
/*  
            }  
        return sb.toString();
    private static final Pattern CONSTANT_FOLDED_PROJECTION = Pattern.compile(  
    private static String joinLines(List<String> lines) {
}  
                }
    /** Host/UUID/shard/generation-specific parquet path. */
    private static Optional<String> physicalPlanOf(List<Map<String, Object>> stages, String executionType) {
    // DataSourceExec DynamicFilter predicate: the TopK optimization pushes a boundary filter down into
        for (Map<String, Object> stage : stages) {  
        return s.endsWith("\n") ? s.substring(0, s.length() - 1) : s;
        }  
        layers.replaceAll((layer, text) -> text.map(t -> t.replace(indexName, INDEX_TOKEN)));  
        StringBuilder rendered = new StringBuilder();
        List<Map<String, Object>> stages = (List<Map<String, Object>>) planProfile.get("stages");
        Map<String, Object> planProfile = (Map<String, Object>) profile.get("plan");  
 *
            // tree_shape is the delegation shape (CONJUNCTIVE / INTERLEAVED_BOOLEAN_EXPRESSION /
        }  
 * compatible open source license.
            throw new AssertionError("profile.plan has no stages; plan keys=" + planProfile.keySet());  
            return Optional.of(distinctPlans.first());
        Map<PlanShapeLayer, Optional<String>> layers = new LinkedHashMap<>();  
    // vanishes and the rule no longer fires — the structural change is still caught.
                }  
    }  
    private static final Pattern FILE_GROUPS = Pattern.compile("file_groups=\\{[^}]*\\}");  
                        + String.join("\n--- vs ---\n", distinctPlans)
    private static final String TOPK_DYNAMIC_FILTER_KEPT = "$1";
    //       "predicate=X AND DynamicFilter [ empty ]"), only the DynamicFilter body is scrubbed;  
                    rendered.append(line).append('\n');  
                for (String line : fragment) {
                .append(" tree_shape=")
     * the stage is absent or carries no task physical plan (Lucene / empty shard). All tasks of a  
    }
    // post-fork `alternatives` (see QueryProfileBuilder TODO), assert on those instead.
    //       the static predicates and their pruning_predicate remain for assertion.
            String treeShapeStr = (treeShape == null || "None".equals(treeShape)) ? "NONE" : treeShape.toString();  
    }
    private static final Pattern PURE_DYNAMIC_FILTER_PREDICATE = Pattern.compile(
 *  
 *   <li>{@link PlanShapeLayer#POST_CBO} = {@code profile.full_plan} lines joined by newline.
    private static final Pattern TOPK_DYNAMIC_FILTER =  
 * authored.
            String exprs = m.group(2);  
    private static final Pattern BARE_NUMERIC_LITERAL = Pattern.compile("(?<=^|, )-?\\d+(?= as )");
    // Constant-folded aggregates: when an aggregate (e.g. min/max) can be resolved at plan-time from  
    }
            // ...) and MUST be asserted. "Absent" serializes inconsistently across builds (JSON
        // The opensearch-sql plugin's QueryProfile {summary, phases, plan} embeds the analytics-engine
 * The OpenSearch Contributors require contributions made to  
        java.util.regex.Matcher m = CONSTANT_FOLDED_PROJECTION.matcher(plan);  
    /**
    );
                );  
        Pattern.compile("(preserve_partitioning=\\[[^\\]]*\\]), filter=\\[[^\\]]*\\]");
     */
        return new ProfilePlanExtractor(layers);
 *   <li>{@link PlanShapeLayer#SHARD_PHYSICAL} = the SHARD_FRAGMENT stage's task physical plans,
        layers.put(PlanShapeLayer.SHARD_PHYSICAL, physicalPlanOf(stages, SHARD_FRAGMENT));  
 */  
import java.util.Optional;  
                    distinctPlans.add(scrub(text));
            }
            throw new AssertionError("response has no 'profile' block — request must set profile=true");
 * its {@link ExpectedQueryPlan}. The render + scrub rules here MUST match exactly how goldens were
 * SPDX-License-Identifier: Apache-2.0
            }
import java.util.TreeSet;
public final class ProfilePlanExtractor {  
import org.opensearch.analytics.qa.planshape.ExpectedQueryPlan.PlanShapeLayer;
    /** The concrete index name is scrubbed too, so goldens are index-name agnostic. */  
    // input_partitions is deliberately NOT scrubbed: it equals the shard's segment count, which is a
            // null vs the string "None"); canonicalize both to NONE so the value is always present  
     * in folded aggregates (min/max/count on different data slices) doesn't break cross-shard dedup.  
    /** Single consistent token for every non-deterministic value we redact from a plan. */
    /**  
    private final Map<PlanShapeLayer, Optional<String>> layers;  
    private static final String MIXED_DYNAMIC_FILTER_BODY_SCRUBBED =  
    // with segment count, so we delete the whole clause (anchored on preserve_partitioning=[...] so
        if (profile == null) {
        "predicate=DynamicFilter [ " + SCRUBBED + " ], pruning_predicate=" + SCRUBBED + ", ";
        scrubbed = PURE_DYNAMIC_FILTER_PREDICATE.matcher(scrubbed).replaceAll(PURE_DYNAMIC_FILTER_SCRUBBED);  
                .append(']')
        return layers.get(layer);
        }  
            String scrubbedExprs = BARE_NUMERIC_LITERAL.matcher(exprs).replaceAll(SCRUBBED);
    @SuppressWarnings("unchecked")
    //       WHERE clause), the pruning_predicate is entirely derived from it — scrub both.
            }
            if (!executionType.equals(stage.get("execution_type"))) {  
            }
    // controlled axis (captured per segment layout), so it's deterministic and worth asserting.
        "predicate=DynamicFilter \\[[^\\]]*], pruning_predicate=[^,]*, ");  
                    "tasks of stage " + executionType + " produced differing physical plans after scrub:\n"
    // such projections. Safety: if the optimizer stops constant-folding (regression), PlaceholderRowExec
            m.appendReplacement(sb, java.util.regex.Matcher.quoteReplacement(m.group(1) + scrubbedExprs + m.group(3)));
                .append(treeShapeStr)  
 *   <li>{@link PlanShapeLayer#COORD_PHYSICAL} = the COORDINATOR_REDUCE stage's task physical plan,
        scrubbed = MIXED_DYNAMIC_FILTER_BODY.matcher(scrubbed).replaceAll(MIXED_DYNAMIC_FILTER_BODY_SCRUBBED);
    /** The captured plan text for a layer, or empty if that layer was absent in the response. */  
 *       scrubbed. Empty if there is no coordinator stage (single-shard / non-splitting query).  
                .append(stage.get("execution_type"))
        m.appendTail(sb);
            List<String> fragment = (List<String>) stage.get("fragment");  
    private static final String SCRUBBED = "<scrubbed>";  
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");  
            List<Map<String, Object>> tasks = (List<Map<String, Object>>) stage.get("tasks");  
    // fed by PlaceholderRowExec. The literal values are data-dependent (each shard holds different
        // (scrubs only the DynamicFilter body, leaving static predicates intact).
                Object physicalPlan = task.get("physical_plan");  
