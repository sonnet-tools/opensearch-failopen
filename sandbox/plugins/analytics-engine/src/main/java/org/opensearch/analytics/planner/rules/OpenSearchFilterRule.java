                // MATCHALL): no explicit field list to validate — fall back to TEXT type assumption.
                        );  
                        .map(i -> fieldStorageInfos.get(i).getFieldName() + ":" + fieldStorageInfos.get(i).getMappingType())
                }  
    private final PlannerContext context;
                        TextRelevanceFieldValidator.rejectNonTextFieldsForTextFunction(
 * delegation capabilities.
    }
        List<String> viable = new ArrayList<>();
/*  
                        );
            );
                    // not a query error — fail explicitly rather than under-validating.
            FieldType returnType = FieldType.fromSqlTypeName(scalarFunctionCall.getType().getSqlTypeName());
                            + "] within filter predicate ["
        RexNode annotatedCondition = annotateCondition(filter.getCondition(), childFieldStorage, childViableBackends);
    public void onMatch(RelOptRuleCall call) {  
        FilterPredicateGuard.validate(filter.getCondition(), context.getMaxFilterPredicateCount());
import org.apache.logging.log4j.Logger;
        // TODO: viableBackends here is computed from each backend's declared FilterCapability
        if (viableSet.isEmpty()) {
            return new ArrayList<>(childViableBackends);
            }
                    FieldType operandType = FieldType.fromSqlTypeName(operand.getType().getSqlTypeName());  
                    // caller explicitly set lenient=true  
        if (!(child instanceof OpenSearchRelNode openSearchInput)) {
            for (AnnotatedPredicate predicate : predicates) {
                    Set<String> viableSet = new HashSet<>(registry.filterCapableBackends());
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;  
     * Recursively walks the condition tree. Boolean connectives (AND, OR, NOT) are
        if (function == null) {  
            // OpenSearchProjectRule.resolveScalarViableBackends for the parallel fallback.  
                    + "]. Ensure all child operators are marked before filter."  
        if (predicates.isEmpty()) {
            // Multi-field full-text functions (multi_match, query_string, simple_query_string)
                // Format-aware: backends that can access this field's storage (doc values + index).  
        }  
 *  
                    DelegatedPredicateSerializer serializer = registry.predicateSerializer(function);
 * this file be licensed under the Apache-2.0 license or a
        for (int fieldIndex : fieldIndices) {  
                fieldViable.retainAll(registry.filterBackendsAnyFormat(function, storageInfo.getFieldType()));
        // Per-backend delegation block-list. Drop backends that block this predicate so it is never
                        if (storageInfo == null) {
        List<String> childViableBackends = openSearchInput.getViableBackends();
    /**  
        // filter-capable without actually shipping a DelegatedPredicateSerializer for it; the
            }
                            fieldStorageInfos
            throw new IllegalStateException(
import org.opensearch.analytics.planner.FilterPredicateGuard;  
    }
            for (RexNode operand : rexCall.getOperands()) {
                fieldViable = new HashSet<>(registry.filterBackendsForField(function, storageInfo));
    /**  
        List<String> childViableBackends
        }  
     * <p>{@code scalarFunctionCalls} — nested RexCalls feeding the scalar-function capability intersection.
                // FULL_TEXT but not a literal-field-encoding function (e.g. QUERY no-field variant,
     * as possible.
                            throw new IllegalArgumentException("Field [" + fieldName + "] not found.");  
        }  
     * remains the same as the code for tagging and checking its nested inner expressions as much
        if (node instanceof RexInputRef inputRef) {  
                    FieldReferences refs = serializer == null ? null : serializer.referencedFields(predicate, fieldStorageInfos);  
    /** Recursively collects all {@link AnnotatedPredicate} leaves from the condition tree. */
        if (node instanceof AnnotatedPredicate annotatedPredicate) {
        CapabilityRegistry registry = context.getCapabilityRegistry();  
        // delegation knob and must never make a predicate unexecutable.
import org.apache.logging.log4j.LogManager;  
                for (RexNode operand : scalarFunctionCall.getOperands()) {
    // ---- Strategy determination ----  
                    "Unrecognized scalar function ["
                // TODO: for FULL_TEXT operators, extract required params from RexCall
     * Result of a single walk over a predicate's operand subtree.
            if (someBackendSurvives) {
        RexCall predicate,
                        // fan-out, which OpenSearch resolves best-effort at execution. Fall back to the
            );  
            ScalarFunction scalarFunc = ScalarFunction.fromSqlOperatorWithFallback(scalarFunctionCall.getOperator());
                    if (lenient == false) {
    }
        List<String> viableBackends = resolveViableBackends(rexCall, fieldStorageInfos, childViableBackends);
            return condition;
                    boolean lenient = refs.lenient();
                                storageInfo = info;
     * Determines which backends can evaluate this leaf predicate.
import org.opensearch.analytics.planner.RelNodeUtils;
 * in the child's {@link FieldStorageInfo} and operator support in backend capabilities.
            // encode field names as string literals in nested MAPs rather than RexInputRef.
                        + "] in call ["
        // Needs revisiting.  
                    + child.getClass().getSimpleName()
                // Derived columns (post-Aggregate, post-Join, post-Union, post-Project) are
                        returnType = operandType;
                        + scalarFunctionCall
                    if (viableSet.isEmpty()) {
                    List<String> literalFieldNames = refs.literalFields();  
            // operators like match() to pass `field`, `query`, etc.) aren't real scalar functions
     * A backend is viable if:
                        for (FieldStorageInfo info : fieldStorageInfos) {
                    // the fields named inside the query string (not just the `fields` MAP). A missing
                        + "] within filter predicate ["  
                        // No viable alternatives is a client error (IllegalArgumentException -> HTTP 400) so the actionable
 * <p>Annotates each leaf predicate with viable backends by checking field storage
import org.apache.calcite.plan.RelOptRule;
                    if (refs == null) {
            return new ArrayList<>(childViableBackends);
        }
                                + predicate.getKind()  
            }
import org.opensearch.analytics.spi.FieldStorageInfo;
     *    it can evaluate natively or delegate to another backend.
                        return new ArrayList<>(registry.filterBackendsAnyFormat(function, FieldType.TEXT));  
        super(operand(Filter.class, operand(RelNode.class, any())), "OpenSearchFilterRule");
            for (RexNode operand : rexCall.getOperands()) {
                // the producer is also viable for (its child's viableBackends), and further
    private List<String> resolveViableBackends(
                if (TextRelevanceFieldValidator.usesLiteralFieldEncoding(function)) {
            contents.scalarFunctionCalls().add(rexCall);  
            );
    private void collectAnnotatedPredicates(RexNode node, List<AnnotatedPredicate> result) {  
        }
            collect(operand, contents);
    private List<String> computeFilterViableBackends(RexNode annotatedCondition, List<String> childViableBackends) {  
import java.util.ArrayList;
        LOGGER.debug("Filter viable backends: {} (child viable: {})", viableBackends, childViableBackends);  
        for (RexCall scalarFunctionCall : contents.scalarFunctionCalls()) {  
                    // MUST register a DelegatedPredicateSerializer whose referencedFields() surfaces
                    throw new IllegalStateException(
        List<FieldStorageInfo> childFieldStorage = openSearchInput.getOutputFieldStorage();
                continue;
 * @opensearch.internal
        // Annotate every leaf predicate with viable backends.
                fieldViable = new HashSet<>(childViableBackends);  
                RelNodeUtils.unwrapHep(filter.getInput()),  
            viableSet.retainAll(fieldViable);
     *    (child supports FILTER delegation, this backend accepts it, and this backend  
        } else if (node instanceof RexCall rexCall) {  
        }  
                if (returnType == null) {  
            // that, e.g., query_string(['severityNumber'], ...) on an INTEGER field doesn't get
     * {@link AnnotatedPredicate} with viable backends resolved from child's field storage.  
                                + "]. A backend declaring this function's filter capability must provide a"
            // are declared over operand types, so this preserves correct dispatch — see
public class OpenSearchFilterRule extends RelOptRule {  
import org.apache.calcite.rel.core.Filter;
            // Extract the literal field names and resolve viability per-field using the actual  
 * Wraps each leaf in an {@link AnnotatedPredicate} RexNode. Computes  
        Set<Integer> fieldIndices = contents.fieldIndices();
            )  
            throw new IllegalStateException(
            if (kind == SqlKind.MAP_VALUE_CONSTRUCTOR || kind == SqlKind.ARRAY_VALUE_CONSTRUCTOR || kind == SqlKind.ROW) {
    @Override
                            + "] in call ["  
        if (!(condition instanceof RexCall rexCall)) {  
        List<String> viableBackends = computeFilterViableBackends(annotatedCondition, childViableBackends);
import org.apache.calcite.rex.RexInputRef;  
import org.opensearch.analytics.spi.DelegationType;
     */  
                            + "] for scalar function ["
 */  
        }
                        .toList()  
     *    can handle all predicates natively).
                // field only when the field has indexFormats=[lucene] set in the mapping).  
    /** Recurses the operand subtree, populating {@code contents} in-place. */
        if (rexCall.getKind() == SqlKind.AND || rexCall.getKind() == SqlKind.OR || rexCall.getKind() == SqlKind.NOT) {  
import org.opensearch.analytics.spi.ScalarFunction;  
import java.util.List;
                // only on backends that support this function on the field's logical type —
        for (String candidateName : childViableBackends) {
                    }
     * 2. OR it is a different backend that the child can delegate the entire filter to
                                + "] on literal-named fields "
                        }
                    }
                            // An explicitly-named literal field absent from the scan's schema is an  
        // Compute operator-level viable backends: must be viable for child AND handle predicates
        }
 * <p>A separate pass after CBO reads these annotations to generate alternative
            }  
import org.apache.calcite.rel.RelNode;  
    /**
                        .filter(i -> i < fieldStorageInfos.size())
        if (fieldIndices.isEmpty()) {  
                    + predicate.getKind()
            contents.fieldIndices().add(inputRef.getIndex());
                    );
                            "No field-reference extraction available for full-text function ["  
            boolean someBackendSurvives = viableSet.stream().anyMatch(backend -> !blockList.isBlocked(backend, function));
        if (!blockList.isEmpty()) {  
     *
        DelegationBlockList blockList = context.getDelegationBlockList();
                viableSet.removeIf(backend -> blockList.isBlocked(backend, function));  
                    + fieldIndices.stream()  
        }
        PredicateContents contents = new PredicateContents(new HashSet<>(), new ArrayList<>());  
        for (RexNode operand : predicate.getOperands()) {
     * Intersects across all referenced fields.
            if (canHandleAll) {
                }  
            } else {
                collectAnnotatedPredicates(operand, result);
                    }
    // ---- Predicate annotation ----
                viableBackends
        // (see resolveViableBackends below). Today a backend can advertise a function as  
            // FieldStorageInfo lookup — same code path as RexInputRef-based fields. This ensures
        }
                // delegation isn't applicable because there's no physical storage to delegate  
                viable.add(candidateName);  
                                + " DelegatedPredicateSerializer that implements referencedFields()."  
     * <p>TODO: ensure that the code for tagging and checking the scalar function of a predicate  
                        // No explicit literal fields to type-check: only patterns and/or default-field  
            boolean canHandleAll = true;
    }
                            }  
        }
}  
                filter.getCluster(),
import org.apache.calcite.plan.RelOptRuleCall;
    }
        // every declared FilterCapability has a matching serializer registered, and reject
            }
                // delegation targets are also field-storage-aware (e.g. Lucene is viable for a keyword
            return;
                            + "]"
                throw new IllegalArgumentException(
                child.getTraitSet(),
        if (viableBackends.isEmpty()) {
            );  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
                            + predicate  
        List<AnnotatedPredicate> predicates = new ArrayList<>();
                    break;
    }
        RelNode child = call.rel(1);
        }
     *
                    }
                }
                collect(operand, contents);
import org.opensearch.analytics.planner.CapabilityRegistry;
 * StagePlans with different delegation strategies.
        // the plugin otherwise — fail-fast at boot rather than at first dual-viable query.
                            "No backend can evaluate filter predicate ["
            // No field reference (non-deterministic, or an unfoldable constant like
                if (!registry.canHandle(candidateName, predicate.getViableBackends(), DelegationType.FILTER)) {  
 */
            if (returnType == null) {
                        + scalarFunctionCall.getOperator().getName()  
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
                continue;  
    }  
                        FieldStorageInfo storageInfo = null;
            for (RexNode operand : rexCall.getOperands()) {
        List<FieldStorageInfo> fieldStorageInfos,  
                            if (fieldName.equals(info.getFieldName())) {  
                    if (literalFieldNames.isEmpty()) {
                        );  
     * <p>{@code fieldIndices} — RexInputRef indices feeding the field-storage intersection.  
                        throw new IllegalArgumentException(
import org.apache.calcite.sql.SqlKind;
    ) {
 *  
            new OpenSearchFilter(  
        return new AnnotatedPredicate(rexCall.getType(), rexCall, viableBackends, context.nextAnnotationId());
                            + scalarFunctionCall.getType().getSqlTypeName()  
                                + literalFieldNames
import org.opensearch.analytics.spi.FieldType;
        }
        Set<String> viableSet = new HashSet<>(registry.filterCapableBackends());
import org.opensearch.analytics.planner.PlannerContext;
     * preserved — we recurse into their children. Leaf predicates are wrapped in
            throw new IllegalStateException(  
            }
        return viable;  
            // they're parameter-passing scaffolding. Skip them  
 * Converts {@link Filter} → {@link OpenSearchFilter}.
                    }
import org.opensearch.analytics.spi.FieldReferences;  
import org.apache.calcite.rex.RexCall;
                    for (String fieldName : literalFieldNames) {  
    }
                    // A backend that declares full-text capability for these multi-field functions  
                    }  
            // mktime('...') > N): let any child-viable backend evaluate it.  
        Filter filter = call.rel(0);
        this.context = context;
 *
            }
                    // Eagerly reject text-relevance functions on non-text/keyword fields, unless the
    private record PredicateContents(Set<Integer> fieldIndices, List<RexCall> scalarFunctionCalls) {
     */
                    if (operandType != null) {
                "Filter rule encountered unmarked child ["
                    canHandleAll = false;
            result.add(annotatedPredicate);
            if (scalarFunc == null) {  
            }  
                            predicate.getOperator().getName(),  
                            + scalarFunc
        // mismatch only surfaces when FragmentConversion tries to delegate (correctness) or
            SqlKind kind = scalarFunctionCall.getKind();
     * 1. It is the child backend (data flows from child), AND for every predicate  
import java.util.Set;
                    return new ArrayList<>(viableSet);
 * operator-level viable backends from per-predicate annotations and
                // a HAVING clause filters on a stats-derived column.
        // Guard: reject excessively complex filter conditions early, before annotation.
import java.util.HashSet;  
            throw new IllegalStateException(
            // Calcite-internal value constructors (named-parameter MAP/ARRAY/ROW used by full-text
                return new ArrayList<>(registry.filterBackendsAnyFormat(function, FieldType.TEXT));  
                        + "]"
            }
                    + " can evaluate all predicates and no delegation path exists"
     * checks backend format support, operator capability, and operator+fieldType support.
 * SPDX-License-Identifier: Apache-2.0
        CapabilityRegistry registry = context.getCapabilityRegistry();  
            return rexCall.clone(rexCall.getType(), annotatedOperands);
                );  
            Set<String> fieldViable;  
            // FieldType from the first concrete operand. Backend capabilities for these UDFs
                        // message is surfaced to the caller instead of being redacted as a 500.  
import org.apache.calcite.rex.RexNode;
                annotatedCondition,
                        + predicate
                                + predicate.getOperator().getName()
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchFilterRule.class);
                // a scan against. Surfaced by testHavingFilterAfterJoin_multiShard etc., where
                            // classified as patterns and handled by the empty-literals branch above.)
                        break;  
        collectAnnotatedPredicates(annotatedCondition, predicates);
                // A backend is viable only if it has the field in its own storage formats — ensuring
                        viableSet.retainAll(registry.filterBackendsForField(function, storageInfo));
        ScalarFunction function = ScalarFunction.fromSqlOperatorWithFallback(predicate.getOperator());
        call.transformTo(
                                break;
            FieldStorageInfo storageInfo = FieldStorageInfo.resolve(fieldStorageInfos, fieldIndex);
        // wrap as performance-delegation. CapabilityRegistry should validate at startup that  
        }  
            if (function.getCategory() == ScalarFunction.Category.FULL_TEXT) {
     */  
        );
                    + childViableBackends
 *  
            }
                    + "] on fields "
            // Polymorphic UDF fallback (e.g. SCALAR_MAX/MIN return SqlTypeName.ANY): infer  
            if (storageInfo.isDerived()) {
                        // TEXT-type assumption and let the full-text-capable backend handle it.
        }
        if (filter instanceof OpenSearchFilter) {
        // marked viable for them — but only when a non-blocked backend survives: blocking is a  
                    // serializer (or one that does not implement referencedFields) is a wiring error,  
                "No backend can execute filter: no viable backend among "  
            List<RexNode> annotatedOperands = new ArrayList<>();
                "Unrecognized filter operator [" + predicate.getOperator().getName() + " / " + predicate.getKind() + "]"
    public OpenSearchFilterRule(PlannerContext context) {  
import org.opensearch.analytics.settings.DelegationBlockList;  
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
                // computed in memory by the producer. The filter can only run on a backend  
package org.opensearch.analytics.planner.rules;
 * compatible open source license.
     */
    /**  
                "No backend can evaluate filter predicate ["  
    private void collect(RexNode node, PredicateContents contents) {
 * The OpenSearch Contributors require contributions made to  
                            literalFieldNames,
                }  
                annotatedOperands.add(annotateCondition(operand, fieldStorageInfos, childViableBackends));  
     * Computes which backends can be the primary executor of this filter.
            }  
            viableSet.retainAll(registry.scalarBackendsAnyFormat(scalarFunc, returnType));
/**
        } else if (node instanceof RexCall rexCall) {
    // ---- Operator-level viable backends ----
            // routed to a backend that only declared (QUERY_STRING, TEXT) capability.  
            }
        return new ArrayList<>(viableSet);  
                        }
                            + scalarFunctionCall
                            // unknown field. (Wildcard/regex field tokens never reach here: they are
    private RexNode annotateCondition(RexNode condition, List<FieldStorageInfo> fieldStorageInfos, List<String> childViableBackends) {
        // Every nested scalar function in the predicate must also be evaluable by a candidate backend
                        throw new IllegalStateException(
            if (!registry.filterCapableBackends().contains(candidateName)) {  
        }  
     * Extracts all field references, looks up their {@link FieldStorageInfo} from the child,  
                        "Unmapped return type ["
