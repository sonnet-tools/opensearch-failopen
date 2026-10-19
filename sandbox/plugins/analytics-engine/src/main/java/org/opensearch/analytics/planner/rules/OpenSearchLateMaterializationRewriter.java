            int newScanIdx = scanIdxRemap[origOutToScan[origOut]];
        return new NarrowedScan(newScan, scanIdxRemap);
            for (RexNode expr : outer.getProjects()) {
            }
        OpenSearchTableScan origScan = detection.belowChain.scan;
        // slots of sort-only columns (not fetched, absent from the wrapper output) are dropped; the
        RelNode newChild = rebuildAboveChain(origChild, origAnchor, wrapperOrProject);
            anchor.fetch,
        Arrays.fill(outputRemap, -1);
import org.apache.calcite.sql.type.SqlTypeName;
            }
        return fields;
 *
        // give -1 (display-only; reproduced above the wrapper, never rebuilt below). Both kinds
        return new AnchorContext(deepestAnchor, chainTopDown.subList(0, deepestAnchorDepth));
        int[] outputRemap = new int[origOutToScan.length];
        List<RelDataTypeField> scanFields = belowChain.scan.getRowType().getFieldList();
    private static BelowChain analyzeBelow(OpenSearchSort anchor) {
     * becomes one output here, with the SAME name (preserving aliases) and its RexNode rebased from
            } else {
                            "Above-anchor Sort references column at slot " + fc.getFieldIndex() + " not present in narrowed rowType"
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            RelCollations.of(newCollations),
            newStorage,
            default -> throw new IllegalStateException("Unexpected above-anchor operator: " + current.getClass().getSimpleName());
            out[i] = (p.getProjects().get(i) instanceof RexInputRef ref) ? ref.getIndex() : -1;
            RelDataTypeField field = origFields.get(origIdx);
        List<RelDataTypeField> wrapperFields = wrapper.getRowType().getFieldList();
            case OpenSearchFilter filter -> {
                    return null;
        int[] remap = new int[origFields.size()];
 * Fire QTF iff {@code aboveAnchorPhysicalFields - belowAnchorPhysicalFields} is non-empty.
        List<FieldStorageInfo> origStorage = origScan.getOutputFieldStorage();
        IndexRemapShuttle toWrapper = new IndexRemapShuttle(scanToWrapper, wrapper.getRowType());
        RelDataTypeFactory.Builder rowTypeBuilder = typeFactory.builder();
        // the wrapper with RexInputRefs rebased from scan space to wrapper-output space. Passthrough
    // TODO : [Human Generated] Don't Delete until fixed.
        }
import org.apache.logging.log4j.Logger;
            };
        Arrays.fill(scanIdxRemap, -1);
     * leaves (TableScan, Values). QTF across a Join or Union is not handled here and will
import org.opensearch.analytics.planner.RelNodeUtils.IndexRemapShuttle;
        }
            }
        }
            newAnchor.getCluster(),
                case OpenSearchExchangeReducer er -> {
                    newProjects.add(new RexInputRef(i, childFields.get(i).getType()));
        OpenSearchTableScan scan = null;
    /** True iff any anchor collation index lands on an expression ({@code -1}) slot of the below-Project. */
    private static boolean collationReferencesDerivedSlot(OpenSearchSort anchor, int[] belowProjOutToScan) {
        }
            p.getCluster(),
                scanIdxRemap[origIdx] = nextNewIdx++;
                }
        }
        for (int i = 0; i < origFields.size(); i++) {
            projects,
                        erRowType,
                    return null;
     * rowType. Names are the stable identity that survives narrowing — they exist in both rowTypes
 *   AboveOps (RexInputRefs remapped)
                    RexNode remapped = f.getCondition().accept(new IndexRemapShuttle(scanIdxRemap, rebuilt.getRowType()));
        OpenSearchProject.class,
                    rebuilt = new OpenSearchExchangeReducer(
    private static Detection detect(RelNode root) {
                composed,
            wrapperStorage,
     */
                }
    private record NarrowedScan(OpenSearchTableScan newScan, int[] scanIdxRemap) {
                if (collationReferencesDerivedSlot(anchor, outToScan)) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            innerProject.getViableBackends()
            if (op instanceof OpenSearchProject p) {
 * the same physical fields and skips the fetch round-trip — strictly cheaper.
import org.apache.calcite.rel.RelNode;
     *   <li>expression → same RexCall with operands rebased (all its physical deps are fetched, so
                        er.getCluster(),
                }
            origScan.getTable(),
                int w = scanToWrapper[ref.getIndex()];
import java.util.HashMap;
                @Override
import org.apache.calcite.rel.RelFieldCollation;
 * <p>
 *       ExchangeReducer, swaps the wrapper in for the anchor, and remaps RexNodes in the
            remap[i] = mapped == null ? -1 : mapped;
        return Optional.of(applyRewrite(root, detection));
 * </ol>
        int[] remap = buildByNameRemap(origChild.getRowType(), newChild.getRowType());
     * or when there's no Scan at the bottom.
        for (int i = 0; i < newFields.size(); i++) {
     * <p>When {@code aboveAnchorOperators} is empty the anchor itself is the topmost op —
/**
        LOGGER.debug(
        );
        List<RelDataTypeField> childFields = newChild.getRowType().getFieldList();
            scanToWrapper[k] = (w == null) ? -1 : w;
    }
            throw new IllegalStateException("Multi-input parent in QTF chain: " + current.getClass().getSimpleName());
        return true;
        for (String name : aboveAnchorPhysicalFields) {
                rowTypeBuilder.add(field.getName(), field.getType());
            case OpenSearchSort sort -> {
        // needs the same treatment, recursively.
import org.opensearch.analytics.planner.RelNodeUtils;
        }
     */
     * (the wrapper, or the SELECT Project sitting above it), then on the way up rewrites every
import java.util.HashSet;
    // TODO : One categorization that applies is Correctness v/s Performance. So, a RewritePhase -> LateMatRewriter.
    private record BelowProjectRebuild(OpenSearchProject rebuilt, int[] outputRemap) {
        OpenSearchProject rebuilt = new OpenSearchProject(
        LinkedHashSet<String> aboveAnchorPhysicalFields,
    // TODO : Rewrite for TopK Approximation is done for Correctness as a response to an User ExecutionHint in request.
 * </pre>
    private record AnchorContext(OpenSearchSort anchor, List<RelNode> aboveAnchorOperators) {
        for (int i = 0; i < wrapperFields.size(); i++) {
            pb.build(),
    ) {
                        typeFactory.createSqlType(SqlTypeName.INTEGER)
        // 2a. Narrowed Scan: reduce-set in scan-original order + ___row_id.
     * {@code ___ugsi} on the ER), rebuilds the anchor's collation, instantiates the wrapper,
                    );
     * Sort as anchor and the upper Sort in the above chain (allowed there).
        }
    // ── Phase 2 — Rewrite ──────────────────────────────────────────────
     *   <li>passthrough ref to a sort-only column (not fetched, absent from the wrapper) → dropped;</li>
            outputRemap[origOut] = newProjects.size();
    // ── Phase 1 — Detect ───────────────────────────────────────────────
        List<FieldStorageInfo> newStorage = new ArrayList<>(belowAnchorPhysicalFields.size() + 1);
            projects.add(rebased);
    }
    private static LinkedHashSet<String> computeAboveAnchorPhysicalFields(List<RelNode> aboveAnchorOperators, OpenSearchSort anchor) {
                return project.copy(project.getTraitSet(), newChild, newExprs, project.getRowType());
        // fetch phase, so the projection — expressions and aliases included — is reproduced ABOVE
     */
    // ── Records ────────────────────────────────────────────────────────
        Map<String, Integer> newIdxByName = new HashMap<>(newType.getFieldCount());
        // into one — substituting the bridge's expressions into the outer Project's refs — so the
        }
    private record BelowChain(List<RelNode> chain, int[] belowProjOutToScan, OpenSearchTableScan scan, boolean hasExchangeReducer) {
    }
                }
        List<RelNode> chain = new ArrayList<>();
    /**
        }
                    newExprs.add(expr.accept(shuttle));
                        er.getExchangeInfo(),
 * <h2>Plan shape after rewrite</h2>
    // TODO : Late Materialization is a rewrite done for performance.
     * {@link OpenSearchSort} with non-empty collation and non-null fetch as the anchor.
        // are dropped from the rebuilt below-Project — only sort/filter passthrough cols that
                public RexNode visitInputRef(RexInputRef ref) {
            );
        IndexRemapShuttle shuttle = new IndexRemapShuttle(remap, newChild.getRowType());
    private static BelowRebuild rebuildBelowChain(BelowChain belowChain, RelNode newScan, int[] scanIdxRemap) {
                // Per-slot scan mapping: passthrough refs resolve to a scan column index;
        RelNode rewritten = rebuildAboveChain(RelNodeUtils.unwrapHep(root), detection.anchor, aboveWrapper);
     */
     * {@code getInputs().size() != 1} — multi-input ops (Join, Union, Intersect, Minus) and
        for (int k = 0; k < scanFields.size(); k++) {
        return remap;
        Set<String> belowAnchorPhysicalFields = computeBelowAnchorPhysicalFields(anchorCtx.anchor, belowChain);
        for (int i = 0; i < p.getProjects().size(); i++) {
 * SPDX-License-Identifier: Apache-2.0
 * QTF (Query-Then-Fetch / late materialization) post-CBO rewrite. Two phases:
     */
        boolean hasExchangeReducer = false;
    // ── 2d. Wrapper ───────────────────────────────────────────────────
            if (!ABOVE_ALLOWED.contains(n.getClass())) return false;
        // scan-column index → wrapper-output index, by physical name; -1 when that column was not fetched.
package org.opensearch.analytics.planner.rules;
            Integer w = wrapperIdxByName.get(scanFields.get(k).getName());
        RelNode cur = RelNodeUtils.unwrapHep(root);
            wrapperFields,
 * Below-anchor intermediate ops: {@link OpenSearchFilter}, {@link OpenSearchExchangeReducer},
                }
        List<RelDataTypeField> origFields = origScan.getRowType().getFieldList();
        BelowRebuild belowRebuild = rebuildBelowChain(detection.belowChain, narrowed.newScan, narrowed.scanIdxRemap);
                    "aboveAnchorPhysicalFields references [" + name + "] which is not present in the original Scan rowType"
        rowTypeBuilder.add(OpenSearchLateMaterialization.ROW_ID_FIELD, typeFactory.createSqlType(SqlTypeName.BIGINT));
    /**
            n = RelNodeUtils.unwrapHep(n.getInput(0));
        }
     * rebuild, and richer {@code ___row_id}/{@code ___ugsi} encoding to disambiguate which
        );
        // survive into the narrowed Scan are kept.
                outer.getCluster(),
    private static int[] buildByNameRemap(RelDataType origType, RelDataType newType) {
        for (int origIdx = 0; origIdx < origFields.size(); origIdx++) {
     * <p><b>Scope: single-input plans only.</b> The walk terminates at any operator whose
            belowAnchorPhysicalFields,
     */
     * its FSIs walk up from the below-chain via inheritance.
            RelDataTypeField field = newChild.getRowType().getFieldList().get(newScanIdx);
    /**
                    break;
            if (belowAnchorPhysicalFields.contains(field.getName())) {
        int[] anchorSlotRemap = scanIdxRemap;
            LOGGER.debug("[QTF] below-anchor allow-list rejected; skipping rewrite");
            return null;
                outer.getTraitSet(),
            pb.add(newNames.get(j), newProjects.get(j).getType());
            RexShuttle substitute = new RexShuttle() {
        // order. When this below-Project sits above the ExchangeReducer the child already carries
 *   <li><b>Detect</b> ({@link #detect}) — read-only walk that runs the allow-list checks,
                outer.getRowType(),
        return new BelowChain(chain, belowProjOutToScan, scan, hasExchangeReducer);
        }
        RelNode n = RelNodeUtils.unwrapHep(anchor.getInput());
                if (helper.equals(childFields.get(i).getName())) {
        int[] scanIdxRemap = new int[origFields.size()];
 *
        // ___ugsi (appended by the ER), so a positional "last column" lookup would grab ___ugsi
                belowProjOutToScan = outToScan;
            if (origOutToScan[origOut] < 0) continue; // expression slot — pulled up above the wrapper
     * field per element of {@code aboveAnchorPhysicalFields} (in iteration order), each
    }
                }
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rex.RexNode;
     * Builds the {@link OpenSearchLateMaterialization} wrapper. Output rowType has one
        OpenSearchSort newAnchor = rebuildAnchor(detection.anchor, belowRebuild.rebuilt, belowRebuild.anchorSlotRemap);
    }
                innerProject = p;
        int deepestAnchorDepth = -1;
                    LOGGER.debug("[QTF] multiple Projects below anchor — skipping");
        switch (current) {
 *             └── ...
    }
        List<FieldStorageInfo> wrapperStorage = new ArrayList<>(aboveAnchorPhysicalFields.size());
            int newIdx = anchorSlotRemap[fc.getFieldIndex()];
                    List<FieldStorageInfo> erStorage = new ArrayList<>(((OpenSearchRelNode) rebuilt).getOutputFieldStorage());
            origScan.getViableBackends(),
        while (n != null) {
    }
            chain.add(n);
        for (RelFieldCollation fc : anchor.getCollation().getFieldCollations()) {
    /**
                deepestAnchor = sort;
            newAnchor.getTraitSet(),
            }
    private static RelNode rebuildAboveChain(RelNode current, OpenSearchSort origAnchor, RelNode wrapperOrProject) {
import java.util.Optional;
        if (detection == null) return Optional.empty();
            newCollations.add(fc.withFieldIndex(newIdx));
                case OpenSearchProject p -> {
     * Two-Sort shapes ({@code Sort(fetch) ← Sort(collation+fetch) ← ...}) put the lower
            if (scanIdx == null) {
                case OpenSearchFilter f -> {
        newStorage.add(FieldStorageInfo.derivedColumn(OpenSearchLateMaterialization.ROW_ID_FIELD, SqlTypeName.BIGINT));
                    int newIdx = remap[fc.getFieldIndex()];
    }
        OpenSearchTableScan origScan,
        return new BelowRebuild(rebuilt, anchorSlotRemap);
            anchor.getViableBackends()
            chainTopDown.add(cur);
            wrapperStorage.add(origStorage.get(scanIdx));
 *
        );
                rebased = expr.accept(toWrapper); // expression: all physical deps are fetched
     * topmost-above-anchor operator's output FSIs, in first-appearance order. Order is
        List<RelDataTypeField> origFields = origType.getFieldList();
                    rebuilt = rebuild.rebuilt;
            belowChain,
     *   <li>passthrough ref to a fetched column → ref to that column's wrapper-output index;</li>
        RelDataTypeFactory typeFactory = wrapper.getCluster().getTypeFactory();
                    remapped.add(fc.withFieldIndex(newIdx));
                        erStorage
            fields.add(scanFields.get(scanIdx).getName());
     * Reproduces the below-anchor SELECT Project ABOVE the wrapper. Each below-Project output slot
                    // matching FieldStorageInfo so the ER's rowType and FSI stay aligned 1:1 — ___ugsi
        // Single-shard plans don't trigger late materialization.
        RelDataTypeFactory typeFactory = newScan.getCluster().getTypeFactory();
 * remapping under a moving wrapper schema is a follow-up.
            RelNode orig = belowChain.chain.get(i);
            rowType.build(),
     * slot (display-only; its physical deps are fetched and the expression is reproduced above
        // 2c. Anchor Sort: collation remapped from anchor space to narrowed-Scan space.
        }
        }
import java.util.LinkedHashSet;
            LOGGER.debug("[QTF] above-anchor allow-list rejected; skipping rewrite");
                int[] outToScan = belowProjectSlotMap(p);
            int scanIdx = (belowChain.belowProjOutToScan == null) ? fc.getFieldIndex() : belowChain.belowProjOutToScan[fc.getFieldIndex()];
            RexNode expr = innerProject.getProjects().get(slot);
import org.apache.calcite.rel.type.RelDataTypeField;
                List<RexNode> newExprs = new ArrayList<>(project.getProjects().size());
    private OpenSearchLateMaterializationRewriter() {}
            case OpenSearchProject project -> {
        for (String helper : OpenSearchLateMaterialization.TRAILING_HELPERS_IN_ORDER) {
                // QTF would defer; sorting on the raw column ≠ sorting on the expression).
        // Skip predicate: aboveAnchorPhysicalFields - belowAnchorPhysicalFields must be non-empty.
        return new OpenSearchProject(
    private static final Set<Class<? extends RelNode>> BELOW_INTERMEDIATE_ALLOWED = Set.of(
    // TODO [Design] : We need to create Rewriting for Distributed Query Execution as a separate PlannerPhase.
                    LOGGER.debug("[QTF] window function in below-Project — skipping (cannot relocate above wrapper)");
            }
    /**
     * scan-column space to wrapper-output (physical-field) space:
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
 * @opensearch.internal
    private static boolean isAboveAllowed(List<RelNode> chain) {
 *       computes the {@link Detection} bundle ({@code aboveAnchorPhysicalFields},
        OpenSearchProject p,
            if (expr instanceof RexInputRef ref) {
import org.opensearch.analytics.spi.FieldStorageInfo;
                // KEY — still declines (sort can't order on a value computed from columns that
     */
        List<RelDataTypeField> newFields = newType.getFieldList();
    private static final Set<Class<? extends RelNode>> ABOVE_ALLOWED = Set.of(
        // Project sits BELOW the anchor; its display columns (URL, Title, …) are deferred to the
        List<RelNode> chainTopDown = new ArrayList<>();
        BelowChain belowChain = analyzeBelow(anchorCtx.anchor);
        return top;
    /** Maps each index of {@code origType} to the index of the same-named field in {@code newType}, or -1 if dropped. */
        if (anchorCtx == null) return null;
            List<RexNode> innerExprs = inner.getProjects();
    private record BelowRebuild(RelNode rebuilt, int[] anchorSlotRemap) {
 *
        for (RelNode n : chain) {
                    RelDataType erRowType = RelNodeUtils.appendField(
     * when an op falls outside the below-allow-list, when a below-Project is non-passthrough,
        OpenSearchSort.class
        }
     * the wrapper during rewrite).
        return fields;
                    anchorSlotRemap = rebuild.outputRemap;
    // ── 2b. Below chain rebuild ───────────────────────────────────────
        LinkedHashSet<String> fields = new LinkedHashSet<>();
     * verbatim for kept columns, and resolve to -1 (rejected by {@link IndexRemapShuttle}) for
            newChild,
        // 2d. Wrapper. Output rowType = aboveAnchorPhysicalFields in iteration order.
    private static OpenSearchSort rebuildAnchor(OpenSearchSort anchor, RelNode newInput, int[] anchorSlotRemap) {
    }
     * named with the physical field name and typed from the original Scan.
    /**
    private static RelNode applyRewrite(RelNode root, Detection detection) {
        OpenSearchSort deepestAnchor = null;
        int[] origOutToScan = belowProjectSlotMap(p);
            }
                        er.getViableBackends(),
            rowType.add(names.get(i), projects.get(i).getType());
                if (p.containsOver()) {
            newIdxByName.put(newFields.get(i).getName(), i);
    /** While the top node is a Project over a Project, compose the two into one. */
     * Per-output-slot scan-column index for a below-Project: {@code out[i]} = scan column index
import org.apache.logging.log4j.LogManager;
            if (newIdx < 0) {
                        typeFactory,
                // only the K survivors remain. Decline (matches the above-anchor RexOver rule).
                // A RexOver (window function) below the anchor cannot be relocated above the
    private static int[] belowProjectSlotMap(OpenSearchProject p) {
    }
    }
                if (w < 0) continue; // sort-only passthrough column — not fetched, drop
     * Walks down the above chain, swapping the anchor's slot with {@code wrapperOrProject}
            newInput,
        );
            if (cur instanceof OpenSearchSort sort && !sort.getCollation().getFieldCollations().isEmpty() && sort.fetch != null) {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
            }
        // Anchor sort cols (anchor space → scan space → physical name)
import java.util.Map;
        }
        RelDataTypeFactory typeFactory = origScan.getCluster().getTypeFactory();
        }
                );
        OpenSearchSort newAnchor,
            newNames.add(p.getRowType().getFieldList().get(origOut).getName());
            LOGGER.debug("[QTF] aboveAnchorPhysicalFields ⊆ belowAnchorPhysicalFields; QTF would not save any I/O — skipping");
            if (belowProjOutToScan[fc.getFieldIndex()] < 0) return true;
     *
    private static BelowProjectRebuild rebuildBelowProject(
import org.apache.calcite.rel.type.RelDataType;
    ) {
     * and applies the skip predicate. {@code null} return means "decline QTF."
            wrapperFields.add(origFields.get(scanIdx));
        Map<String, Integer> origScanIdxByName = new HashMap<>();
 */
        }
    }
        for (int slot = 0; slot < innerProject.getProjects().size(); slot++) {
 *       {@code belowAnchorPhysicalFields}), and applies the skip predicate. Returns
        Set<String> fields = new HashSet<>();
 * <ol>
        int[] scanToWrapper = new int[scanFields.size()];
        for (RelNode op : belowChain.chain) {
        Map<String, Integer> wrapperIdxByName = new HashMap<>(wrapperFields.size());
        if (!hasFetchOnly) {
 * compatible open source license.
        AnchorContext anchorCtx = findAnchor(root);
     * and remaps RexNodes in the above chain.
        for (int i = 0; i < origFields.size(); i++) {
                }
                    "Sort collation references slot " + fc.getFieldIndex() + " whose physical field was dropped from the narrowed Scan"
                        er.getTraitSet(),
            }
import java.util.Set;
import org.opensearch.analytics.planner.rel.OpenSearchSort;
            if (!BELOW_INTERMEDIATE_ALLOWED.contains(n.getClass())) return null;
        String> belowAnchorPhysicalFields, LinkedHashSet<String> aboveAnchorPhysicalFields) {
    /** Returns the rewritten root iff QTF matched and fired; {@link Optional#empty()} otherwise. */
                outer.getViableBackends()
            wrapper,
        // Pass through every trailing helper present in the child, by NAME, in the shared layout
    private static AnchorContext findAnchor(RelNode root) {
            newProjects.add(new RexInputRef(newScanIdx, field.getType()));
    private static NarrowedScan buildNarrowedScan(OpenSearchTableScan origScan, Set<String> belowAnchorPhysicalFields) {
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchLateMaterializationRewriter.class);
 *       {@code null} when QTF doesn't apply.</li>
 * {@link OpenSearchSort}. {@link OpenSearchAggregate} is rejected for now — group / agg-call
        for (RelNode op : detection.belowChain.chain) {
            cur = RelNodeUtils.unwrapHep(cur.getInput(0));
            if (n.getInputs().isEmpty()) return null;
 * If every above-anchor reference is already in the reduce-set, the non-QTF path reads
import org.apache.calcite.rex.RexInputRef;
     * dropped ones.
                    erStorage.add(FieldStorageInfo.derivedColumn(OpenSearchLateMaterialization.UGSI_FIELD, SqlTypeName.INTEGER));
        }
 *       Builds the narrowed Scan, walks the below chain, declares {@code ___ugsi} on the
     * {@code AboveAnchorPhysicalFields} = the union of physical-field deps across the
     * when slot {@code i} is a passthrough {@link RexInputRef}, else {@code -1} for an expression
        for (int j = 0; j < newProjects.size(); j++) {
            }
 *   <li><b>Rewrite</b> ({@link #applyRewrite}) — pure transform consuming a {@link Detection}.
 * <h2>Allow-lists</h2>
                );
                }
    /**
        List<RexNode> newProjects = new ArrayList<>();
        );
        OpenSearchProject innerProject = null;
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        for (int origOut = 0; origOut < origOutToScan.length; origOut++) {
        Detection detection = detect(root);
            }
        RelDataTypeFactory typeFactory
     * Output of phase 1. Contains everything phase 2 needs — phase 2 must not re-walk
        return new Detection(
        // rowType to its newChild's rowType. Pass-through ops (Filter, Sort) leak the narrowed
            "[QTF] fired: aboveAnchorPhysicalFields={}, belowAnchorPhysicalFields={}",
        NarrowedScan narrowed = buildNarrowedScan(origScan, detection.belowAnchorPhysicalFields);
        List<RelDataTypeField> scanFields = detection.belowChain.scan.getRowType().getFieldList();
            anchor.getCluster(),
                    LOGGER.debug("[QTF] anchor sorts on a derived below-Project column — skipping (derived sort key)");
    // ── 2e. Above chain rebuild ───────────────────────────────────────
import org.apache.calcite.rel.RelCollations;
        if (!isAboveAllowed(anchorCtx.aboveAnchorOperators)) {
                // expression slots map to -1 (display-only, reproduced above the wrapper during
        }
                    rebuilt = new OpenSearchFilter(f.getCluster(), f.getTraitSet(), rebuilt, remapped, f.getViableBackends());
        List<RelFieldCollation> newCollations = new ArrayList<>(anchor.getCollation().getFieldCollations().size());
            p.getViableBackends()
        return out;
        if (current.getInputs().size() != 1) {
                for (RexNode expr : project.getProjects()) {
 *                       └── ...
        List<String> newNames = new ArrayList<>();
        // above-chain never references them. When there's no below-Project, the wrapper stands alone.
            wrapper.getTraitSet(),
     * Below-chain analysis. Walks {@code anchor.input} down to the Scan. Returns null
                    newNames.add(helper);
        }
                default -> throw new IllegalStateException("Unexpected below-anchor operator: " + orig.getClass().getSimpleName());
 */
     * set in scan-original order.
        }
     */
            Integer scanIdx = origScanIdxByName.get(name);
            if (n instanceof OpenSearchExchangeReducer) hasExchangeReducer = true;
 * this file be licensed under the Apache-2.0 license or a
}
    public static Optional<RelNode> rewrite(RelNode root) {
                }
 *                            └── OpenSearchTableScan   (narrowed: [reduce-set, ___row_id])
        return new BelowProjectRebuild(rebuilt, outputRemap);
                deepestAnchorDepth = chainTopDown.size();
                fields.add(fsi.getFieldName());
        return new OpenSearchLateMaterialization(
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
            anchorCtx.aboveAnchorOperators,
            if (n instanceof OpenSearchTableScan s) {
            origAnchor.getViableBackends()
     *       every operand resolves into the wrapper output).</li>
        RelNode newChild,
    // ── 2a. Narrowed Scan ─────────────────────────────────────────────
            }
                    BelowProjectRebuild rebuild = rebuildBelowProject(p, rebuilt, scanIdxRemap, typeFactory);
                List<RelFieldCollation> remapped = new ArrayList<>(sort.getCollation().getFieldCollations().size());
        // SELECT prune drops to a single Project and no bridge-only column (e.g. a refetched sort
            origScanIdxByName.put(origFields.get(i).getName(), i);
                    return null;
                if (belowProjOutToScan != null) {
        // Below-Project output→scan map: passthrough slots give a scan index; expression slots
            newProjects,
            anchor.getTraitSet(),
        }
            names.add(innerFields.get(slot).getName());
    /**
            switch (orig) {
        OpenSearchSort origAnchor
 * passthrough {@link OpenSearchProject}.
     */
            Integer mapped = newIdxByName.get(origFields.get(i).getName());
        int nextNewIdx = 0;
                    return innerExprs.get(ref.getIndex());
        for (RelFieldCollation fc : anchor.getCollation().getFieldCollations()) {
                throw new IllegalStateException(
            if (n instanceof OpenSearchProject p) {
     *
        // immediate above-op is itself a Project (the SELECT prune), the two stack. Compose them
            p.getTraitSet(),
     */
        while (top instanceof OpenSearchProject outer && RelNodeUtils.unwrapHep(outer.getInput()) instanceof OpenSearchProject inner) {
            return null;
            anchorCtx.anchor,
                    );
        List<RexNode> projects = new ArrayList<>();
        return mergeAdjacentTopProjects(rewritten);
            detection.aboveAnchorPhysicalFields(),
        for (FieldStorageInfo fsi : topmost.getOutputFieldStorage()) {
            wrapper.getCluster(),
                break;
     * as physical (Scan-level) field names. The narrowed Scan's rowType is built from this
    private static RelNode mergeAdjacentTopProjects(RelNode top) {
    /**
    }
        return false;
            aboveAnchorPhysicalFields
                    }
                for (RelFieldCollation fc : sort.getCollation().getFieldCollations()) {
        RelNode aboveWrapper = buildProjectAboveWrapper(wrapper, detection);
                return sort.copy(sort.getTraitSet(), newChild, RelCollations.of(remapped), sort.offset, sort.fetch);
    private static RelNode buildProjectAboveWrapper(OpenSearchLateMaterialization wrapper, Detection detection) {
    }
                }
     * branch a survivor row came from). Tracked in {@link OpenSearchLateMaterialization}'s
                throw new IllegalStateException(
                newStorage.add(origStorage.get(origIdx));
        // Below-filter cols (already in scan space)
            origScan.getTraitSet(),
            } else {
            anchorCtx.aboveAnchorOperators,
        if (current == origAnchor) return wrapperOrProject;
    }
    /**
 * <pre>
    }
            wrapperIdxByName.put(wrapperFields.get(i).getName(), i);
        }
        if (belowChain == null) {
            return null;
                break;
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
            newAnchor,
                        OpenSearchLateMaterialization.UGSI_FIELD,
                        );
        // 2g. Collapse adjacent Projects at the top. The reproduced below-Project (2f) is a bridge
        OpenSearchExchangeReducer.class,
        boolean hasFetchOnly = aboveAnchorPhysicalFields.stream().anyMatch(name -> !belowAnchorPhysicalFields.contains(name));
 * <h2>Skip predicate</h2>
                    // is a derived (coord-side) column with no physical storage.
        List<RelDataTypeField> wrapperFields = new ArrayList<>(aboveAnchorPhysicalFields.size());
import java.util.ArrayList;
        OpenSearchLateMaterialization wrapper = buildWrapper(newAnchor, detection.aboveAnchorPhysicalFields, origScan, detection.anchor);
            top = new OpenSearchProject(
import java.util.List;
            if (n instanceof OpenSearchProject project && project.containsOver()) return false;
            return null;
                for (int refIdx : RelNodeUtils.collectInputRefs(f.getCondition())) {
        RelNode rebuilt = newScan;
        List<FieldStorageInfo> origStorage = origScan.getOutputFieldStorage();
        // 2b. Walk below chain bottom-up; rebuild operators with narrowed input. ER appends ___ugsi.
        if (deepestAnchor == null) return null;
        RelDataTypeFactory.Builder pb = typeFactory.builder();
        }
        if (!belowChain.hasExchangeReducer()) {
import org.apache.calcite.rex.RexShuttle;
        );
        // rowType upward, so a single immediate-parent remap is insufficient — every above op
    }
    }
        int[] scanIdxRemap,
        LinkedHashSet<String> aboveAnchorPhysicalFields = computeAboveAnchorPhysicalFields(
    }
     * Walks {@code root} downward along the single-input spine, picking the deepest
                        rebuilt.getRowType(),
    }
        // instead of ___row_id and drop the helper that the LM-stage drain / Stitcher read by name.
        OpenSearchTableScan newScan = new OpenSearchTableScan(
        for (RelFieldCollation fc : anchor.getCollation().getFieldCollations()) {
        }
            RexNode rebased;
        }
        RelNode origChild = RelNodeUtils.unwrapHep(current.getInput(0));
                fields.addAll(fsi.getDependsOnPhysicalCols());
        }
                    if (newIdx < 0) {
    // TODO : Add support for Aggregate, Joins and Union here.
    );
        OpenSearchFilter.class,
            }
    }
                return filter.copy(filter.getTraitSet(), newChild, filter.getCondition().accept(shuttle));
    }
                    // by OrdinalAppendingSink before DataFusion's reduce sees the batch). Supply the
                    fields.add(scanFields.get(refIdx).getName());
        // 2e. Above chain: every op's RexInputRefs remapped by column name from its origChild's
            detection.belowAnchorPhysicalFields()
                // wrapper: window semantics need the full pre-Limit input, but above the wrapper
    }
        );
                    // Invariant 4: declare ___ugsi on the ER's output rowType (materialized at runtime
            origScan.getCluster(),
 *       above chain.</li>
        if (innerProject == null) return wrapper;
            for (int i = 0; i < childFields.size(); i++) {
     * the original plan to recover any of these fields.
    // ── 2c. Anchor rebuild ────────────────────────────────────────────
        List<RelDataTypeField> origFields = origScan.getRowType().getFieldList();
    }
    private static OpenSearchLateMaterialization buildWrapper(
     * <ul>
     * class-level TODO.
     */
        );
    );
        OpenSearchProject.class
                rebased = new RexInputRef(w, wrapperFields.get(w).getType());
     * need dedicated rewriters with multi-input semantics (per-branch detection, merged
public final class OpenSearchLateMaterializationRewriter {
        // exposing the anchor's output schema so the above-chain can graft on by name; when the
     * Walks the plan, validates allow-lists, computes the data structures rewrite needs,
    }
        for (int i = belowChain.chain.size() - 1; i >= 0; i--) {
        }
            if (newScanIdx < 0) continue; // source dropped (now fetched, not in narrowed Scan)
        OpenSearchFilter.class,
            List<RexNode> composed = new ArrayList<>(outer.getProjects().size());
        return new OpenSearchSort(
     * Pure transform. Builds the narrowed Scan, walks the below chain (declaring
     * {@code BelowAnchorPhysicalFields} = anchor sort cols ∪ below-filter cols, expressed
            rowTypeBuilder.build()
     * Returns the bare {@code wrapper} when there is no below-Project to reproduce.
 * Above-anchor: {@link OpenSearchProject} (no {@code RexOver}), {@link OpenSearchFilter},
        int[] belowProjOutToScan = null;
        // 2f. SELECT projection above the wrapper. Without SORT_PROJECT_TRANSPOSE the SELECT-list
import java.util.Arrays;
        List<String> names = new ArrayList<>();
 *   └── OpenSearchLateMaterialization        (output rowType = aboveAnchorPhysicalFields)
        OpenSearchRelNode topmost = aboveAnchorOperators.isEmpty() ? anchor : (OpenSearchRelNode) aboveAnchorOperators.getFirst();
            anchor.offset,
            if (!fsi.isDerived()) {
                        throw new IllegalStateException(
 *                  └── OpenSearchExchangeReducer  (rowType: [reduce-set, ___row_id, ___ugsi])
     * op's RexInputRefs via a by-name remap from {@code origChild}'s rowType to {@code newChild}'s
        if (scan == null) return null;
            }
        List<RelDataTypeField> innerFields = innerProject.getRowType().getFieldList();
 *
    /**
                composed.add(expr.accept(substitute));
        while (cur.getInputs().size() == 1) {
        // key the outer doesn't select) leaks through an intermediate node.
     * the wrapper-output and fetch-RPC order.
 *
        }
            }
/*
        int[] out = new int[p.getProjects().size()];
            }
                }
 *        └── OpenSearchSort                  (anchor; collation remapped to narrowed-Scan space)
            if (op instanceof OpenSearchFilter f) {
                // rewrite). A -1 at a slot the anchor's collation references is a DERIVED SORT
        for (int i = 0; i < projects.size(); i++) {
            anchorCtx.anchor
        }
     * </ul>
            }
        RelDataTypeFactory.Builder rowType = typeFactory.builder();
                scan = s;
    private static Set<String> computeBelowAnchorPhysicalFields(OpenSearchSort anchor, BelowChain belowChain) {
            LOGGER.debug("[QTF] single-shard plan (no ExchangeReducer below anchor); skipping rewrite");
                inner.getInput(),
    private record Detection(OpenSearchSort anchor, List<RelNode> aboveAnchorOperators, BelowChain belowChain, Set<
                        rebuilt,
