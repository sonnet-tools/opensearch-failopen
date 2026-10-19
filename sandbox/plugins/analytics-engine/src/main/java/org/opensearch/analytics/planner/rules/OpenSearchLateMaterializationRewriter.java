            return null;  
            for (int i = 0; i < childFields.size(); i++) {
                    anchorSlotRemap = rebuild.outputRemap;
        if (!belowChain.hasExchangeReducer()) {
        // rowType to its newChild's rowType. Pass-through ops (Filter, Sort) leak the narrowed  
            remap[i] = mapped == null ? -1 : mapped;
    /** While the top node is a Project over a Project, compose the two into one. */
            origScanIdxByName.put(origFields.get(i).getName(), i);
            case OpenSearchFilter filter -> {
    /**  
        for (int i = 0; i < origFields.size(); i++) {  
    // ── 2c. Anchor rebuild ────────────────────────────────────────────
    private static int[] belowProjectSlotMap(OpenSearchProject p) {
            int scanIdx = (belowChain.belowProjOutToScan == null) ? fc.getFieldIndex() : belowChain.belowProjOutToScan[fc.getFieldIndex()];  
import java.util.ArrayList;
 *  
 *   AboveOps (RexInputRefs remapped)
                // expression slots map to -1 (display-only, reproduced above the wrapper during  
                    );
        return out;  
package org.opensearch.analytics.planner.rules;
            }
        boolean hasFetchOnly = aboveAnchorPhysicalFields.stream().anyMatch(name -> !belowAnchorPhysicalFields.contains(name));
        if (!hasFetchOnly) {
        }
        // above-chain never references them. When there's no below-Project, the wrapper stands alone.
     */  
                if (belowProjOutToScan != null) {  
            if (!fsi.isDerived()) {
                innerProject = p;
        List<RexNode> projects = new ArrayList<>();  
        List<RelNode> chainTopDown = new ArrayList<>();
            if (!ABOVE_ALLOWED.contains(n.getClass())) return false;
        RelNode newChild = rebuildAboveChain(origChild, origAnchor, wrapperOrProject);  
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
            }
            p.getViableBackends()
 *
 *
    private static NarrowedScan buildNarrowedScan(OpenSearchTableScan origScan, Set<String> belowAnchorPhysicalFields) {  
}
        List<RelDataTypeField> origFields = origScan.getRowType().getFieldList();
    private static BelowProjectRebuild rebuildBelowProject(  
        // instead of ___row_id and drop the helper that the LM-stage drain / Stitcher read by name.
                break;  
        RelNode rewritten = rebuildAboveChain(RelNodeUtils.unwrapHep(root), detection.anchor, aboveWrapper);  
            scanToWrapper[k] = (w == null) ? -1 : w;
    }  
            Integer w = wrapperIdxByName.get(scanFields.get(k).getName());
        return mergeAdjacentTopProjects(rewritten);
            }  
            wrapper.getTraitSet(),
 * <h2>Plan shape after rewrite</h2>
        int[] belowProjOutToScan = null;  
        // order. When this below-Project sits above the ExchangeReducer the child already carries
            if (expr instanceof RexInputRef ref) {  
                        );
        // Pass through every trailing helper present in the child, by NAME, in the shared layout
        AnchorContext anchorCtx = findAnchor(root);
                composed.add(expr.accept(substitute));
        OpenSearchProject p,
                        typeFactory,
     * Pure transform. Builds the narrowed Scan, walks the below chain (declaring
            LOGGER.debug("[QTF] single-shard plan (no ExchangeReducer below anchor); skipping rewrite");
                // wrapper: window semantics need the full pre-Limit input, but above the wrapper
        // rowType upward, so a single immediate-parent remap is insufficient — every above op
        int[] remap = buildByNameRemap(origChild.getRowType(), newChild.getRowType());
            newAnchor,
        OpenSearchSort origAnchor  
        LinkedHashSet<String> fields = new LinkedHashSet<>();  
     * when slot {@code i} is a passthrough {@link RexInputRef}, else {@code -1} for an expression  
        List<FieldStorageInfo> wrapperStorage = new ArrayList<>(aboveAnchorPhysicalFields.size());
        OpenSearchTableScan origScan,
            anchor.offset,
        int[] scanIdxRemap = new int[origFields.size()];
     * Walks down the above chain, swapping the anchor's slot with {@code wrapperOrProject}
                    return innerExprs.get(ref.getIndex());  
import java.util.Map;
        RelNode origChild = RelNodeUtils.unwrapHep(current.getInput(0));
            return null;
            if (n instanceof OpenSearchProject project && project.containsOver()) return false;  
 * </ol>
     * {@link OpenSearchSort} with non-empty collation and non-null fetch as the anchor.  
                for (RexNode expr : project.getProjects()) {
        int[] scanToWrapper = new int[scanFields.size()];
        );
    private record NarrowedScan(OpenSearchTableScan newScan, int[] scanIdxRemap) {
 * passthrough {@link OpenSearchProject}.  
            newProjects.add(new RexInputRef(newScanIdx, field.getType()));
            newProjects,  
    private static RelNode mergeAdjacentTopProjects(RelNode top) {  
    /**  
    );  
                rebased = new RexInputRef(w, wrapperFields.get(w).getType());  
     * or when there's no Scan at the bottom.
            aboveAnchorPhysicalFields  
            if (newIdx < 0) {
 *                  └── OpenSearchExchangeReducer  (rowType: [reduce-set, ___row_id, ___ugsi])
    private static BelowChain analyzeBelow(OpenSearchSort anchor) {
        OpenSearchExchangeReducer.class,
            pb.build(),
        OpenSearchProject innerProject = null;
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        }
        if (detection == null) return Optional.empty();
        int[] out = new int[p.getProjects().size()];
        // exposing the anchor's output schema so the above-chain can graft on by name; when the  
     * field per element of {@code aboveAnchorPhysicalFields} (in iteration order), each
        OpenSearchProject.class,
        }  
                    // by OrdinalAppendingSink before DataFusion's reduce sees the batch). Supply the  
            return null;  
                break;
            newNames.add(p.getRowType().getFieldList().get(origOut).getName());
            for (RexNode expr : outer.getProjects()) {
        IndexRemapShuttle shuttle = new IndexRemapShuttle(remap, newChild.getRowType());  
        if (current.getInputs().size() != 1) {
        // 2a. Narrowed Scan: reduce-set in scan-original order + ___row_id.  
        List<FieldStorageInfo> newStorage = new ArrayList<>(belowAnchorPhysicalFields.size() + 1);  
            case OpenSearchSort sort -> {
            if (!BELOW_INTERMEDIATE_ALLOWED.contains(n.getClass())) return null;  
            anchorCtx.aboveAnchorOperators,  
    // TODO : Rewrite for TopK Approximation is done for Correctness as a response to an User ExecutionHint in request.  
                        throw new IllegalStateException(  
 * <h2>Skip predicate</h2>
            if (newScanIdx < 0) continue; // source dropped (now fetched, not in narrowed Scan)
    /**
                    remapped.add(fc.withFieldIndex(newIdx));
                    }  
    // TODO : One categorization that applies is Correctness v/s Performance. So, a RewritePhase -> LateMatRewriter.
     * and remaps RexNodes in the above chain.
        // SELECT prune drops to a single Project and no bridge-only column (e.g. a refetched sort  
        }
                            "Above-anchor Sort references column at slot " + fc.getFieldIndex() + " not present in narrowed rowType"
            cur = RelNodeUtils.unwrapHep(cur.getInput(0));  
            if (n instanceof OpenSearchProject p) {
                fields.addAll(fsi.getDependsOnPhysicalCols());
     * branch a survivor row came from). Tracked in {@link OpenSearchLateMaterialization}'s  
import org.opensearch.analytics.planner.RelNodeUtils;
import java.util.Set;  
                }
        for (RelNode op : belowChain.chain) {
        // key the outer doesn't select) leaks through an intermediate node.
    private OpenSearchLateMaterializationRewriter() {}
        List<RelDataTypeField> wrapperFields = new ArrayList<>(aboveAnchorPhysicalFields.size());  
                    LOGGER.debug("[QTF] window function in below-Project — skipping (cannot relocate above wrapper)");
    /**
            wrapperFields.add(origFields.get(scanIdx));  
        newStorage.add(FieldStorageInfo.derivedColumn(OpenSearchLateMaterialization.ROW_ID_FIELD, SqlTypeName.BIGINT));
        return top;
 *       ExchangeReducer, swaps the wrapper in for the anchor, and remaps RexNodes in the  
                    );
        if (deepestAnchor == null) return null;
                        er.getViableBackends(),  
        }
    // TODO : Late Materialization is a rewrite done for performance.
        List<String> newNames = new ArrayList<>();
        RelDataTypeFactory.Builder pb = typeFactory.builder();
 *   <li><b>Detect</b> ({@link #detect}) — read-only walk that runs the allow-list checks,  
import org.apache.calcite.rel.RelCollations;
        for (int i = 0; i < origFields.size(); i++) {
        }
    }  
        return fields;
        if (scan == null) return null;  
        }  
        for (int i = 0; i < projects.size(); i++) {  
        // 2c. Anchor Sort: collation remapped from anchor space to narrowed-Scan space.  
 * </pre>
            List<RexNode> innerExprs = inner.getProjects();
                default -> throw new IllegalStateException("Unexpected below-anchor operator: " + orig.getClass().getSimpleName());  
                }  
                case OpenSearchFilter f -> {
        // Project sits BELOW the anchor; its display columns (URL, Title, …) are deferred to the
     * op's RexInputRefs via a by-name remap from {@code origChild}'s rowType to {@code newChild}'s
        LinkedHashSet<String> aboveAnchorPhysicalFields,
 * <pre>  
            }
            origScan.getTable(),
        List<RelDataTypeField> origFields = origType.getFieldList();
        OpenSearchLateMaterialization wrapper = buildWrapper(newAnchor, detection.aboveAnchorPhysicalFields, origScan, detection.anchor);
    private static RelNode applyRewrite(RelNode root, Detection detection) {  
     *  
        }
        if (current == origAnchor) return wrapperOrProject;
            if (belowAnchorPhysicalFields.contains(field.getName())) {
        List<RelFieldCollation> newCollations = new ArrayList<>(anchor.getCollation().getFieldCollations().size());
                    RelDataType erRowType = RelNodeUtils.appendField(  
            anchorCtx.aboveAnchorOperators,
                    "aboveAnchorPhysicalFields references [" + name + "] which is not present in the original Scan rowType"  
        for (int i = 0; i < wrapperFields.size(); i++) {
        for (int origIdx = 0; origIdx < origFields.size(); origIdx++) {
 *
     * class-level TODO.
        }  
     * rebuild, and richer {@code ___row_id}/{@code ___ugsi} encoding to disambiguate which
 * compatible open source license.
        Arrays.fill(outputRemap, -1);  
            if (belowProjOutToScan[fc.getFieldIndex()] < 0) return true;  
                case OpenSearchExchangeReducer er -> {
                outer.getTraitSet(),  
            origScan.getViableBackends(),
     */  
        List<RelDataTypeField> newFields = newType.getFieldList();  
     * Two-Sort shapes ({@code Sort(fetch) ← Sort(collation+fetch) ← ...}) put the lower
        if (anchorCtx == null) return null;  
     * set in scan-original order.
     * and applies the skip predicate. {@code null} return means "decline QTF."
            if (op instanceof OpenSearchFilter f) {
    private record Detection(OpenSearchSort anchor, List<RelNode> aboveAnchorOperators, BelowChain belowChain, Set<
    }  
            default -> throw new IllegalStateException("Unexpected above-anchor operator: " + current.getClass().getSimpleName());
        }  
                        rebuilt,
    }
                }
                deepestAnchor = sort;
                );
                outer.getRowType(),  
            wrapperFields,
            innerProject.getViableBackends()  
        OpenSearchSort newAnchor = rebuildAnchor(detection.anchor, belowRebuild.rebuilt, belowRebuild.anchorSlotRemap);
     */
                    if (newIdx < 0) {
        List<RelDataTypeField> childFields = newChild.getRowType().getFieldList();
            } else {
 *                       └── ...  
     */  
    private static Detection detect(RelNode root) {
            if (scanIdx == null) {
        return new Detection(
import org.opensearch.analytics.planner.rel.OpenSearchProject;
        RelDataTypeFactory.Builder rowType = typeFactory.builder();
        for (RelNode n : chain) {
                        OpenSearchLateMaterialization.UGSI_FIELD,  
                    // matching FieldStorageInfo so the ER's rowType and FSI stay aligned 1:1 — ___ugsi
            switch (orig) {  
        return Optional.of(applyRewrite(root, detection));
        // into one — substituting the bridge's expressions into the outer Project's refs — so the
        }
    private static OpenSearchSort rebuildAnchor(OpenSearchSort anchor, RelNode newInput, int[] anchorSlotRemap) {  
 * Below-anchor intermediate ops: {@link OpenSearchFilter}, {@link OpenSearchExchangeReducer},
            RelDataTypeField field = newChild.getRowType().getFieldList().get(newScanIdx);
        // fetch phase, so the projection — expressions and aliases included — is reproduced ABOVE
                throw new IllegalStateException(
    /**
        Map<String, Integer> wrapperIdxByName = new HashMap<>(wrapperFields.size());
        Map<String, Integer> newIdxByName = new HashMap<>(newType.getFieldCount());
        );
     * its FSIs walk up from the below-chain via inheritance.
                deepestAnchorDepth = chainTopDown.size();  
        RelNode cur = RelNodeUtils.unwrapHep(root);
        int[] anchorSlotRemap = scanIdxRemap;
                }
        RelNode newChild,
    public static Optional<RelNode> rewrite(RelNode root) {
            LOGGER.debug("[QTF] below-anchor allow-list rejected; skipping rewrite");
 * <h2>Allow-lists</h2>  
    }
                // QTF would defer; sorting on the raw column ≠ sorting on the expression).  
        return new BelowChain(chain, belowProjOutToScan, scan, hasExchangeReducer);
        // slots of sort-only columns (not fetched, absent from the wrapper output) are dropped; the
            wrapper.getCluster(),
        // scan-column index → wrapper-output index, by physical name; -1 when that column was not fetched.  
        switch (current) {
                        er.getCluster(),  
     * Walks {@code root} downward along the single-input spine, picking the deepest
            detection.belowAnchorPhysicalFields()
                return project.copy(project.getTraitSet(), newChild, newExprs, project.getRowType());
            anchorCtx.anchor  
        for (int i = 0; i < newFields.size(); i++) {
    }
                    newProjects.add(new RexInputRef(i, childFields.get(i).getType()));  
                    List<FieldStorageInfo> erStorage = new ArrayList<>(((OpenSearchRelNode) rebuilt).getOutputFieldStorage());  
                fields.add(fsi.getFieldName());  
 * this file be licensed under the Apache-2.0 license or a
    // ── Records ────────────────────────────────────────────────────────
            chain.add(n);
        String> belowAnchorPhysicalFields, LinkedHashSet<String> aboveAnchorPhysicalFields) {
            projects.add(rebased);
 *       {@code belowAnchorPhysicalFields}), and applies the skip predicate. Returns
        // survive into the narrowed Scan are kept.  
        for (int slot = 0; slot < innerProject.getProjects().size(); slot++) {  
        }
    // ── Phase 2 — Rewrite ──────────────────────────────────────────────
            return null;  
import java.util.Optional;
     * as physical (Scan-level) field names. The narrowed Scan's rowType is built from this
        RelNode aboveWrapper = buildProjectAboveWrapper(wrapper, detection);  
    private record AnchorContext(OpenSearchSort anchor, List<RelNode> aboveAnchorOperators) {
    private static RelNode rebuildAboveChain(RelNode current, OpenSearchSort origAnchor, RelNode wrapperOrProject) {  
            }
            }
 * <p>
        OpenSearchFilter.class,  
        }
        List<FieldStorageInfo> origStorage = origScan.getOutputFieldStorage();
    // ── 2e. Above chain rebuild ───────────────────────────────────────
                belowProjOutToScan = outToScan;  
import org.apache.calcite.sql.type.SqlTypeName;
            n = RelNodeUtils.unwrapHep(n.getInput(0));
                    return null;  
    }  
        for (String helper : OpenSearchLateMaterialization.TRAILING_HELPERS_IN_ORDER) {  
        LinkedHashSet<String> aboveAnchorPhysicalFields = computeAboveAnchorPhysicalFields(
import org.apache.calcite.rex.RexNode;
            newChild,
        Arrays.fill(scanIdxRemap, -1);
        List<RelDataTypeField> origFields = origScan.getRowType().getFieldList();  
            anchor.getCluster(),  
            RexNode expr = innerProject.getProjects().get(slot);
    // TODO : [Human Generated] Don't Delete until fixed.
     * </ul>
            anchor.getTraitSet(),
                rowTypeBuilder.add(field.getName(), field.getType());  
        );
                    fields.add(scanFields.get(refIdx).getName());
            rowType.build(),
    private record BelowChain(List<RelNode> chain, int[] belowProjOutToScan, OpenSearchTableScan scan, boolean hasExchangeReducer) {
    }  
     */
    private record BelowRebuild(RelNode rebuilt, int[] anchorSlotRemap) {
    }
 * If every above-anchor reference is already in the reduce-set, the non-QTF path reads  
        }
            top = new OpenSearchProject(
        if (innerProject == null) return wrapper;  
        }
    }
                return filter.copy(filter.getTraitSet(), newChild, filter.getCondition().accept(shuttle));
            LOGGER.debug("[QTF] above-anchor allow-list rejected; skipping rewrite");
                if (collationReferencesDerivedSlot(anchor, outToScan)) {
            newAnchor.getTraitSet(),  
     * Sort as anchor and the upper Sort in the above chain (allowed there).
                }  
                rebased = expr.accept(toWrapper); // expression: all physical deps are fetched
                    return null;
        // Below-Project output→scan map: passthrough slots give a scan index; expression slots  
 *        └── OpenSearchSort                  (anchor; collation remapped to narrowed-Scan space)  
 * The OpenSearch Contributors require contributions made to  
     * the wrapper-output and fetch-RPC order.
                scanIdxRemap[origIdx] = nextNewIdx++;
                    int newIdx = remap[fc.getFieldIndex()];
 *             └── ...
    /** Returns the rewritten root iff QTF matched and fired; {@link Optional#empty()} otherwise. */
        }
        }  
     */  
        }
    /**
        return new BelowProjectRebuild(rebuilt, outputRemap);
    // TODO [Design] : We need to create Rewriting for Distributed Query Execution as a separate PlannerPhase.  
        RelDataTypeFactory.Builder rowTypeBuilder = typeFactory.builder();
     * {@code AboveAnchorPhysicalFields} = the union of physical-field deps across the  
            );
            belowChain,
     */
        );
    /**  
 *  
        OpenSearchTableScan newScan = new OpenSearchTableScan(
        OpenSearchSort.class
                    rebuilt = rebuild.rebuilt;
            RexShuttle substitute = new RexShuttle() {  
        return new NarrowedScan(newScan, scanIdxRemap);  
     * Builds the {@link OpenSearchLateMaterialization} wrapper. Output rowType has one
        List<RelDataTypeField> wrapperFields = wrapper.getRowType().getFieldList();
            rowTypeBuilder.build()
     * rowType. Names are the stable identity that survives narrowing — they exist in both rowTypes
        // 2f. SELECT projection above the wrapper. Without SORT_PROJECT_TRANSPOSE the SELECT-list  
            }
        );  
        // immediate above-op is itself a Project (the SELECT prune), the two stack. Compose them
    private static final Set<Class<? extends RelNode>> BELOW_INTERMEDIATE_ALLOWED = Set.of(
     *  
            newInput,
 * Above-anchor: {@link OpenSearchProject} (no {@code RexOver}), {@link OpenSearchFilter},
                }
        );
        RelDataTypeFactory typeFactory = newScan.getCluster().getTypeFactory();  
        // 2b. Walk below chain bottom-up; rebuild operators with narrowed input. ER appends ___ugsi.  
        Detection detection = detect(root);  
        // give -1 (display-only; reproduced above the wrapper, never rebuilt below). Both kinds
    /**
        // 2g. Collapse adjacent Projects at the top. The reproduced below-Project (2f) is a bridge
    // ── 2b. Below chain rebuild ───────────────────────────────────────  
        Set<String> belowAnchorPhysicalFields = computeBelowAnchorPhysicalFields(anchorCtx.anchor, belowChain);  
    }  
                outer.getCluster(),
            wrapperStorage,  
                int w = scanToWrapper[ref.getIndex()];
import org.apache.calcite.rel.type.RelDataType;
        for (int i = 0; i < p.getProjects().size(); i++) {  
            if (origOutToScan[origOut] < 0) continue; // expression slot — pulled up above the wrapper
    private static boolean isAboveAllowed(List<RelNode> chain) {  
            newStorage,  
        RelNode rebuilt = newScan;
import java.util.List;  
        OpenSearchFilter.class,  
        List<RelDataTypeField> scanFields = detection.belowChain.scan.getRowType().getFieldList();  
            origAnchor.getViableBackends()
                );
        for (RelFieldCollation fc : anchor.getCollation().getFieldCollations()) {
            }
                scan = s;  
    ) {
    }
        }  
     * dropped ones.
 * the same physical fields and skips the fetch round-trip — strictly cheaper.
        return fields;
        // needs the same treatment, recursively.
 *       above chain.</li>
import org.apache.logging.log4j.LogManager;
            Integer scanIdx = origScanIdxByName.get(name);  
import org.apache.logging.log4j.Logger;  
 * {@link OpenSearchSort}. {@link OpenSearchAggregate} is rejected for now — group / agg-call
    // ── 2d. Wrapper ───────────────────────────────────────────────────
            anchor.getViableBackends()  
     * {@code ___ugsi} on the ER), rebuilds the anchor's collation, instantiates the wrapper,  
                    // is a derived (coord-side) column with no physical storage.
    ) {
    private static RelNode buildProjectAboveWrapper(OpenSearchLateMaterialization wrapper, Detection detection) {
 * remapping under a moving wrapper schema is a follow-up.  
            newIdxByName.put(newFields.get(i).getName(), i);
                        er.getExchangeInfo(),
     * Walks the plan, validates allow-lists, computes the data structures rewrite needs,
            detection.aboveAnchorPhysicalFields(),
 *       {@code null} when QTF doesn't apply.</li>  
        OpenSearchProject.class
        rowTypeBuilder.add(OpenSearchLateMaterialization.ROW_ID_FIELD, typeFactory.createSqlType(SqlTypeName.BIGINT));
        OpenSearchRelNode topmost = aboveAnchorOperators.isEmpty() ? anchor : (OpenSearchRelNode) aboveAnchorOperators.getFirst();
            if (n.getInputs().isEmpty()) return null;  
        BelowChain belowChain = analyzeBelow(anchorCtx.anchor);  
        // the wrapper with RexInputRefs rebased from scan space to wrapper-output space. Passthrough  
     */  
        while (cur.getInputs().size() == 1) {  
                }
                    RexNode remapped = f.getCondition().accept(new IndexRemapShuttle(scanIdxRemap, rebuilt.getRowType()));
     */  
            wrapperIdxByName.put(wrapperFields.get(i).getName(), i);  
                newStorage.add(origStorage.get(origIdx));
    }  
     * becomes one output here, with the SAME name (preserving aliases) and its RexNode rebased from  
            }  
 *       Builds the narrowed Scan, walks the below chain, declares {@code ___ugsi} on the
            Integer mapped = newIdxByName.get(origFields.get(i).getName());
        );
        return true;
        List<RelDataTypeField> scanFields = belowChain.scan.getRowType().getFieldList();  
 *                            └── OpenSearchTableScan   (narrowed: [reduce-set, ___row_id])
        RelNode n = RelNodeUtils.unwrapHep(anchor.getInput());  
        }
 * @opensearch.internal
                return sort.copy(sort.getTraitSet(), newChild, RelCollations.of(remapped), sort.offset, sort.fetch);  
                List<RexNode> newExprs = new ArrayList<>(project.getProjects().size());
     *       every operand resolves into the wrapper output).</li>  
            }  
                // A RexOver (window function) below the anchor cannot be relocated above the
            int newIdx = anchorSlotRemap[fc.getFieldIndex()];  
                    BelowProjectRebuild rebuild = rebuildBelowProject(p, rebuilt, scanIdxRemap, typeFactory);  
     *   <li>passthrough ref to a fetched column → ref to that column's wrapper-output index;</li>  
    private static int[] buildByNameRemap(RelDataType origType, RelDataType newType) {
    }
                for (int refIdx : RelNodeUtils.collectInputRefs(f.getCondition())) {  
        List<String> names = new ArrayList<>();
    private static LinkedHashSet<String> computeAboveAnchorPhysicalFields(List<RelNode> aboveAnchorOperators, OpenSearchSort anchor) {
    /**
            anchorCtx.anchor,
            out[i] = (p.getProjects().get(i) instanceof RexInputRef ref) ? ref.getIndex() : -1;
 * SPDX-License-Identifier: Apache-2.0
                public RexNode visitInputRef(RexInputRef ref) {
        while (top instanceof OpenSearchProject outer && RelNodeUtils.unwrapHep(outer.getInput()) instanceof OpenSearchProject inner) {
            origScan.getTraitSet(),  
    private record BelowProjectRebuild(OpenSearchProject rebuilt, int[] outputRemap) {
        OpenSearchProject rebuilt = new OpenSearchProject(
        BelowRebuild belowRebuild = rebuildBelowChain(detection.belowChain, narrowed.newScan, narrowed.scanIdxRemap);
        return false;
            }
            names.add(innerFields.get(slot).getName());
        for (FieldStorageInfo fsi : topmost.getOutputFieldStorage()) {
        // ___ugsi (appended by the ER), so a positional "last column" lookup would grab ___ugsi  
        // Anchor sort cols (anchor space → scan space → physical name)
        return new AnchorContext(deepestAnchor, chainTopDown.subList(0, deepestAnchorDepth));  
        }
            }
        int[] remap = new int[origFields.size()];
    /** Maps each index of {@code origType} to the index of the same-named field in {@code newType}, or -1 if dropped. */  
     * Below-chain analysis. Walks {@code anchor.input} down to the Scan. Returns null  
    private static boolean collationReferencesDerivedSlot(OpenSearchSort anchor, int[] belowProjOutToScan) {
        return new OpenSearchProject(  
                        typeFactory.createSqlType(SqlTypeName.INTEGER)
        );  
        LOGGER.debug(
/**
        RelDataTypeFactory typeFactory = wrapper.getCluster().getTypeFactory();
        for (int k = 0; k < scanFields.size(); k++) {  
                composed,
                    erStorage.add(FieldStorageInfo.derivedColumn(OpenSearchLateMaterialization.UGSI_FIELD, SqlTypeName.INTEGER));
        int deepestAnchorDepth = -1;
            if (op instanceof OpenSearchProject p) {
import java.util.Arrays;
    // ── Phase 1 — Detect ───────────────────────────────────────────────
            origScan.getCluster(),
                }
        }
    }  
    }
     * <p><b>Scope: single-input plans only.</b> The walk terminates at any operator whose
    }
            }  
     * topmost-above-anchor operator's output FSIs, in first-appearance order. Order is
                @Override
            if (cur instanceof OpenSearchSort sort && !sort.getCollation().getFieldCollations().isEmpty() && sort.fetch != null) {
 *
import org.opensearch.analytics.planner.rel.OpenSearchSort;  
        OpenSearchSort deepestAnchor = null;  
     * <ul>
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchLateMaterializationRewriter.class);
     * (the wrapper, or the SELECT Project sitting above it), then on the way up rewrites every  
                    return null;
            RexNode rebased;
                if (w < 0) continue; // sort-only passthrough column — not fetched, drop
                inner.getInput(),
        int[] outputRemap = new int[origOutToScan.length];
                // KEY — still declines (sort can't order on a value computed from columns that
        return new BelowRebuild(rebuilt, anchorSlotRemap);  
                case OpenSearchProject p -> {
import org.apache.calcite.rex.RexShuttle;  
                    newExprs.add(expr.accept(shuttle));  
            belowAnchorPhysicalFields,
     * Returns the bare {@code wrapper} when there is no below-Project to reproduce.
        // Below-filter cols (already in scan space)  
     */
    }
        OpenSearchTableScan origScan = detection.belowChain.scan;
        }
    private static BelowRebuild rebuildBelowChain(BelowChain belowChain, RelNode newScan, int[] scanIdxRemap) {
    private static Set<String> computeBelowAnchorPhysicalFields(OpenSearchSort anchor, BelowChain belowChain) {
    );  
    private static AnchorContext findAnchor(RelNode root) {  
        for (int j = 0; j < newProjects.size(); j++) {
 * QTF (Query-Then-Fetch / late materialization) post-CBO rewrite. Two phases:  
    private static OpenSearchLateMaterialization buildWrapper(
                    LOGGER.debug("[QTF] anchor sorts on a derived below-Project column — skipping (derived sort key)");  
        // 2e. Above chain: every op's RexInputRefs remapped by column name from its origChild's
                throw new IllegalStateException(
                    newNames.add(helper);
        }  
            RelNode orig = belowChain.chain.get(i);
     * {@code BelowAnchorPhysicalFields} = anchor sort cols ∪ below-filter cols, expressed  
            chainTopDown.add(cur);
 */
                }
            p.getTraitSet(),
        return new OpenSearchSort(
            throw new IllegalStateException("Multi-input parent in QTF chain: " + current.getClass().getSimpleName());  
     * named with the physical field name and typed from the original Scan.  
        if (!isAboveAllowed(anchorCtx.aboveAnchorOperators)) {
import java.util.HashSet;
import org.apache.calcite.rel.RelFieldCollation;
     * slot (display-only; its physical deps are fetched and the expression is reproduced above
        IndexRemapShuttle toWrapper = new IndexRemapShuttle(scanToWrapper, wrapper.getRowType());
        }
import java.util.LinkedHashSet;
        for (int origOut = 0; origOut < origOutToScan.length; origOut++) {
            rowType.add(names.get(i), projects.get(i).getType());
        Set<String> fields = new HashSet<>();
        OpenSearchTableScan scan = null;
            LOGGER.debug("[QTF] aboveAnchorPhysicalFields ⊆ belowAnchorPhysicalFields; QTF would not save any I/O — skipping");  
        OpenSearchSort newAnchor,  
 * Fire QTF iff {@code aboveAnchorPhysicalFields - belowAnchorPhysicalFields} is non-empty.
        int[] origOutToScan = belowProjectSlotMap(p);
            projects,
    /** True iff any anchor collation index lands on an expression ({@code -1}) slot of the below-Project. */  
 *   └── OpenSearchLateMaterialization        (output rowType = aboveAnchorPhysicalFields)
            RelDataTypeField field = origFields.get(origIdx);  
 */  
public final class OpenSearchLateMaterializationRewriter {  
 * <ol>
            }
                if (p.containsOver()) {
     * the wrapper during rewrite).
            fields.add(scanFields.get(scanIdx).getName());
     * scan-column space to wrapper-output (physical-field) space:
        // are dropped from the rebuilt below-Project — only sort/filter passthrough cols that
        // 2d. Wrapper. Output rowType = aboveAnchorPhysicalFields in iteration order.  
    // TODO : Add support for Aggregate, Joins and Union here.
     * verbatim for kept columns, and resolve to -1 (rejected by {@link IndexRemapShuttle}) for  
     * Per-output-slot scan-column index for a below-Project: {@code out[i]} = scan column index
            newCollations.add(fc.withFieldIndex(newIdx));  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
                for (RelFieldCollation fc : sort.getCollation().getFieldCollations()) {  
    }
            wrapper,  
        List<RexNode> newProjects = new ArrayList<>();  
import org.apache.calcite.rel.type.RelDataTypeFactory;
                        er.getTraitSet(),
            anchor.fetch,
        for (int i = belowChain.chain.size() - 1; i >= 0; i--) {
                        erRowType,
            pb.add(newNames.get(j), newProjects.get(j).getType());  
        while (n != null) {
                }  
            List<RexNode> composed = new ArrayList<>(outer.getProjects().size());  
            newAnchor.getCluster(),
        int[] scanIdxRemap,  
        List<RelNode> chain = new ArrayList<>();
                int[] outToScan = belowProjectSlotMap(p);
        List<RelDataTypeField> innerFields = innerProject.getRowType().getFieldList();
            p.getCluster(),  
    /**
            outputRemap[origOut] = newProjects.size();  
     *   <li>passthrough ref to a sort-only column (not fetched, absent from the wrapper) → dropped;</li>
/*  
    }  
    }  
                        rebuilt.getRowType(),
                List<RelFieldCollation> remapped = new ArrayList<>(sort.getCollation().getFieldCollations().size());
        for (RelFieldCollation fc : anchor.getCollation().getFieldCollations()) {
    }  
     * when an op falls outside the below-allow-list, when a below-Project is non-passthrough,
                        erStorage  
        List<FieldStorageInfo> origStorage = origScan.getOutputFieldStorage();  
            };
     * need dedicated rewriters with multi-input semantics (per-branch detection, merged
import java.util.HashMap;  
        int nextNewIdx = 0;
            RelCollations.of(newCollations),  
                    rebuilt = new OpenSearchFilter(f.getCluster(), f.getTraitSet(), rebuilt, remapped, f.getViableBackends());  
                    "Sort collation references slot " + fc.getFieldIndex() + " whose physical field was dropped from the narrowed Scan"  
        }
        }  
    }  
    /**
                    rebuilt = new OpenSearchExchangeReducer(
                // rewrite). A -1 at a slot the anchor's collation references is a DERIVED SORT
            "[QTF] fired: aboveAnchorPhysicalFields={}, belowAnchorPhysicalFields={}",  
        return new OpenSearchLateMaterialization(
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            }  
        }  
                outer.getViableBackends()
    }
            wrapperStorage.add(origStorage.get(scanIdx));
 *   <li><b>Rewrite</b> ({@link #applyRewrite}) — pure transform consuming a {@link Detection}.
        NarrowedScan narrowed = buildNarrowedScan(origScan, detection.belowAnchorPhysicalFields);
import org.apache.calcite.rel.RelNode;  
            case OpenSearchProject project -> {  
        for (RelNode op : detection.belowChain.chain) {  
     * leaves (TableScan, Values). QTF across a Join or Union is not handled here and will  
     *   <li>expression → same RexCall with operands rebased (all its physical deps are fetched, so
import org.opensearch.analytics.spi.FieldStorageInfo;
        for (RelFieldCollation fc : anchor.getCollation().getFieldCollations()) {
            }  
    // ── 2a. Narrowed Scan ─────────────────────────────────────────────
        for (String name : aboveAnchorPhysicalFields) {
            } else {
 *       computes the {@link Detection} bundle ({@code aboveAnchorPhysicalFields},
        }
import org.opensearch.analytics.planner.RelNodeUtils.IndexRemapShuttle;
                    break;
                // only the K survivors remain. Decline (matches the above-anchor RexOver rule).  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
                if (helper.equals(childFields.get(i).getName())) {
     * {@code getInputs().size() != 1} — multi-input ops (Join, Union, Intersect, Minus) and
                    LOGGER.debug("[QTF] multiple Projects below anchor — skipping");
        return remap;
        // Single-shard plans don't trigger late materialization.  
import org.apache.calcite.rel.type.RelDataTypeField;  
                }
        if (belowChain == null) {
                // Per-slot scan mapping: passthrough refs resolve to a scan column index;
        boolean hasExchangeReducer = false;
     * Output of phase 1. Contains everything phase 2 needs — phase 2 must not re-walk
import org.apache.calcite.rex.RexInputRef;
        }
        // Skip predicate: aboveAnchorPhysicalFields - belowAnchorPhysicalFields must be non-empty.  
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;  
        Map<String, Integer> origScanIdxByName = new HashMap<>();
        RelDataTypeFactory typeFactory
     */  
    private static final Set<Class<? extends RelNode>> ABOVE_ALLOWED = Set.of(
                    // Invariant 4: declare ___ugsi on the ER's output rowType (materialized at runtime
     * Reproduces the below-anchor SELECT Project ABOVE the wrapper. Each below-Project output slot
        RelDataTypeFactory typeFactory = origScan.getCluster().getTypeFactory();
            if (n instanceof OpenSearchTableScan s) {
     * <p>When {@code aboveAnchorOperators} is empty the anchor itself is the topmost op —
    }
            int newScanIdx = scanIdxRemap[origOutToScan[origOut]];  
     * the original plan to recover any of these fields.
            if (n instanceof OpenSearchExchangeReducer) hasExchangeReducer = true;
