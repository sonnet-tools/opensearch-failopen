                "No backend can execute filter: no viable backend among "
     * <p>TODO: ensure that the code for tagging and checking the scalar function of a predicate
            }
        } else if (node instanceof RexCall rexCall) {
        // wrap as performance-delegation. CapabilityRegistry should validate at startup that
                        );
            if (kind == SqlKind.MAP_VALUE_CONSTRUCTOR || kind == SqlKind.ARRAY_VALUE_CONSTRUCTOR || kind == SqlKind.ROW) {
        }
    private RexNode annotateCondition(RexNode condition, List<FieldStorageInfo> fieldStorageInfos, List<String> childViableBackends) {
 * StagePlans with different delegation strategies.
            // they're parameter-passing scaffolding. Skip them
    }
        }
import org.apache.calcite.rex.RexNode;
     *    (child supports FILTER delegation, this backend accepts it, and this backend
                        break;
                // delegation isn't applicable because there's no physical storage to delegate
        List<String> viable = new ArrayList<>();
 * delegation capabilities.
                        // fan-out, which OpenSearch resolves best-effort at execution. Fall back to the
                    boolean lenient = refs.lenient();
     * <p>{@code scalarFunctionCalls} — nested RexCalls feeding the scalar-function capability intersection.
                    // caller explicitly set lenient=true
            result.add(annotatedPredicate);
                    // serializer (or one that does not implement referencedFields) is a wiring error,
import org.apache.calcite.plan.RelOptRuleCall;
            if (function.getCategory() == ScalarFunction.Category.FULL_TEXT) {
            for (RexNode operand : rexCall.getOperands()) {
                // Format-aware: backends that can access this field's storage (doc values + index).
                // Derived columns (post-Aggregate, post-Join, post-Union, post-Project) are
                            + predicate
                    + childViableBackends
import org.apache.calcite.sql.SqlKind;
 * The OpenSearch Contributors require contributions made to
        super(operand(Filter.class, operand(RelNode.class, any())), "OpenSearchFilterRule");
            // Extract the literal field names and resolve viability per-field using the actual
    /**
     */
                    }
            contents.scalarFunctionCalls().add(rexCall);
        // Needs revisiting.
     */
     * Extracts all field references, looks up their {@link FieldStorageInfo} from the child,
     * Intersects across all referenced fields.
                fieldViable = new HashSet<>(registry.filterBackendsForField(function, storageInfo));
        if (viableSet.isEmpty()) {
                continue;
                    }
import java.util.ArrayList;
                    if (refs == null) {
            for (RexNode operand : rexCall.getOperands()) {
        } else if (node instanceof RexCall rexCall) {
                        FieldStorageInfo storageInfo = null;
                            + scalarFunctionCall
                        // TEXT-type assumption and let the full-text-capable backend handle it.
            // Polymorphic UDF fallback (e.g. SCALAR_MAX/MIN return SqlTypeName.ANY): infer
        List<String> childViableBackends = openSearchInput.getViableBackends();
                    + fieldIndices.stream()
            for (RexNode operand : rexCall.getOperands()) {
            if (storageInfo.isDerived()) {
        }
        }
            // FieldStorageInfo lookup — same code path as RexInputRef-based fields. This ensures
                if (returnType == null) {
import org.opensearch.analytics.planner.RelNodeUtils;
                        .filter(i -> i < fieldStorageInfos.size())
                // delegation targets are also field-storage-aware (e.g. Lucene is viable for a keyword
                            + "] in call ["
                        + "]"
    public void onMatch(RelOptRuleCall call) {
                                + "]. A backend declaring this function's filter capability must provide a"
        }
                    return new ArrayList<>(viableSet);
                        );
            }
import org.apache.calcite.plan.RelOptRule;
                            fieldStorageInfos
     * 1. It is the child backend (data flows from child), AND for every predicate
                // only on backends that support this function on the field's logical type —
        List<AnnotatedPredicate> predicates = new ArrayList<>();
    /** Recursively collects all {@link AnnotatedPredicate} leaves from the condition tree. */
                    if (literalFieldNames.isEmpty()) {
            }
                        // No explicit literal fields to type-check: only patterns and/or default-field
    ) {
            throw new IllegalStateException(
            } else {
    /** Recurses the operand subtree, populating {@code contents} in-place. */
        List<String> viableBackends = resolveViableBackends(rexCall, fieldStorageInfos, childViableBackends);
            }
        // filter-capable without actually shipping a DelegatedPredicateSerializer for it; the
        if (node instanceof AnnotatedPredicate annotatedPredicate) {
        if (predicates.isEmpty()) {
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
                }
import org.opensearch.analytics.settings.DelegationBlockList;
                    FieldReferences refs = serializer == null ? null : serializer.referencedFields(predicate, fieldStorageInfos);
            return new ArrayList<>(childViableBackends);
     */
                    "Unrecognized scalar function ["
            );
            throw new IllegalStateException(
                    // A backend that declares full-text capability for these multi-field functions
package org.opensearch.analytics.planner.rules;
        }
                filter.getCluster(),
        Filter filter = call.rel(0);
     *    can handle all predicates natively).
import java.util.Set;
                collect(operand, contents);
            return;
}
        }
     * A backend is viable if:
                collectAnnotatedPredicates(operand, result);
                "Filter rule encountered unmarked child ["
            if (canHandleAll) {
            new OpenSearchFilter(
            SqlKind kind = scalarFunctionCall.getKind();
                    canHandleAll = false;
import org.opensearch.analytics.spi.FieldStorageInfo;
            for (AnnotatedPredicate predicate : predicates) {
                    throw new IllegalStateException(
        RelNode child = call.rel(1);
 * <p>A separate pass after CBO reads these annotations to generate alternative
                annotatedOperands.add(annotateCondition(operand, fieldStorageInfos, childViableBackends));
            return rexCall.clone(rexCall.getType(), annotatedOperands);
        // the plugin otherwise — fail-fast at boot rather than at first dual-viable query.
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchFilterRule.class);
     * Result of a single walk over a predicate's operand subtree.
                // MATCHALL): no explicit field list to validate — fall back to TEXT type assumption.
        }
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
    /**
     *    it can evaluate natively or delegate to another backend.
        // Annotate every leaf predicate with viable backends.
                            "No backend can evaluate filter predicate ["
                            // classified as patterns and handled by the empty-literals branch above.)
                    // the fields named inside the query string (not just the `fields` MAP). A missing
                // a scan against. Surfaced by testHavingFilterAfterJoin_multiShard etc., where
                            + scalarFunc
        List<FieldStorageInfo> childFieldStorage = openSearchInput.getOutputFieldStorage();
        }
     * Computes which backends can be the primary executor of this filter.
        if (!blockList.isEmpty()) {
                // FULL_TEXT but not a literal-field-encoding function (e.g. QUERY no-field variant,
        LOGGER.debug("Filter viable backends: {} (child viable: {})", viableBackends, childViableBackends);
        RexCall predicate,
            ScalarFunction scalarFunc = ScalarFunction.fromSqlOperatorWithFallback(scalarFunctionCall.getOperator());
        collectAnnotatedPredicates(annotatedCondition, predicates);
            boolean someBackendSurvives = viableSet.stream().anyMatch(backend -> !blockList.isBlocked(backend, function));
                            + "]"
    }
                                + literalFieldNames
                        + predicate
     * preserved — we recurse into their children. Leaf predicates are wrapped in
    }
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        }
                fieldViable.retainAll(registry.filterBackendsAnyFormat(function, storageInfo.getFieldType()));
                                storageInfo = info;
    public OpenSearchFilterRule(PlannerContext context) {
                        // No viable alternatives is a client error (IllegalArgumentException -> HTTP 400) so the actionable
    private void collectAnnotatedPredicates(RexNode node, List<AnnotatedPredicate> result) {
                    }
            FieldStorageInfo storageInfo = FieldStorageInfo.resolve(fieldStorageInfos, fieldIndex);
        return viable;
     * remains the same as the code for tagging and checking its nested inner expressions as much
        // Per-backend delegation block-list. Drop backends that block this predicate so it is never
            if (!registry.filterCapableBackends().contains(candidateName)) {
                            + "] for scalar function ["
        if (filter instanceof OpenSearchFilter) {
        // (see resolveViableBackends below). Today a backend can advertise a function as
                    List<String> literalFieldNames = refs.literalFields();
        }
                    + "] on fields "
        if (rexCall.getKind() == SqlKind.AND || rexCall.getKind() == SqlKind.OR || rexCall.getKind() == SqlKind.NOT) {
                            + "] within filter predicate ["
                        }
        // TODO: viableBackends here is computed from each backend's declared FilterCapability
    private void collect(RexNode node, PredicateContents contents) {
 *
                    + predicate.getKind()
    private List<String> resolveViableBackends(
 * Converts {@link Filter} → {@link OpenSearchFilter}.
 * in the child's {@link FieldStorageInfo} and operator support in backend capabilities.
 * SPDX-License-Identifier: Apache-2.0
                return new ArrayList<>(registry.filterBackendsAnyFormat(function, FieldType.TEXT));
                        );
    // ---- Predicate annotation ----
        }
                        // message is surfaced to the caller instead of being redacted as a 500.
            }
            if (someBackendSurvives) {
        // delegation knob and must never make a predicate unexecutable.
        Set<Integer> fieldIndices = contents.fieldIndices();
import org.apache.logging.log4j.LogManager;
                viableSet.removeIf(backend -> blockList.isBlocked(backend, function));
                        if (storageInfo == null) {
            // No field reference (non-deterministic, or an unfoldable constant like
     * as possible.
                    + " can evaluate all predicates and no delegation path exists"
            return new ArrayList<>(childViableBackends);
                                + "] on literal-named fields "
        }
/**
            if (returnType == null) {
            viableSet.retainAll(fieldViable);
            contents.fieldIndices().add(inputRef.getIndex());
import org.opensearch.analytics.planner.FilterPredicateGuard;
 * @opensearch.internal
import org.opensearch.analytics.spi.FieldType;
            // operators like match() to pass `field`, `query`, etc.) aren't real scalar functions
     * 2. OR it is a different backend that the child can delegate the entire filter to
                continue;
                    }
                if (TextRelevanceFieldValidator.usesLiteralFieldEncoding(function)) {
                    if (viableSet.isEmpty()) {
                // TODO: for FULL_TEXT operators, extract required params from RexCall
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
            // Multi-field full-text functions (multi_match, query_string, simple_query_string)
        );
                        + "] in call ["
            // OpenSearchProjectRule.resolveScalarViableBackends for the parallel fallback.
                }
    }
        if (!(child instanceof OpenSearchRelNode openSearchInput)) {
            }
        for (RexCall scalarFunctionCall : contents.scalarFunctionCalls()) {
        PredicateContents contents = new PredicateContents(new HashSet<>(), new ArrayList<>());
                                + predicate.getOperator().getName()
 * Wraps each leaf in an {@link AnnotatedPredicate} RexNode. Computes
                    + "]. Ensure all child operators are marked before filter."
    private List<String> computeFilterViableBackends(RexNode annotatedCondition, List<String> childViableBackends) {
                        + scalarFunctionCall.getOperator().getName()
                            throw new IllegalArgumentException("Field [" + fieldName + "] not found.");
 *
            // are declared over operand types, so this preserves correct dispatch — see
        if (viableBackends.isEmpty()) {
                annotatedCondition,
            }
            throw new IllegalStateException(
 * this file be licensed under the Apache-2.0 license or a
                    if (lenient == false) {
            );
    }
                            predicate.getOperator().getName(),
            return condition;
            if (scalarFunc == null) {
                            }
     * Recursively walks the condition tree. Boolean connectives (AND, OR, NOT) are
import org.opensearch.analytics.planner.PlannerContext;
        List<String> viableBackends = computeFilterViableBackends(annotatedCondition, childViableBackends);
 *
                        return new ArrayList<>(registry.filterBackendsAnyFormat(function, FieldType.TEXT));
                // the producer is also viable for (its child's viableBackends), and further
 * operator-level viable backends from per-predicate annotations and
                        .toList()
                        "Unmapped return type ["
                // A backend is viable only if it has the field in its own storage formats — ensuring
        return new ArrayList<>(viableSet);
import org.opensearch.analytics.planner.CapabilityRegistry;
                                break;
            );
        for (RexNode operand : predicate.getOperands()) {
        // Every nested scalar function in the predicate must also be evaluable by a candidate backend
     * <p>{@code fieldIndices} — RexInputRef indices feeding the field-storage intersection.
    }
    // ---- Operator-level viable backends ----
    private final PlannerContext context;
        CapabilityRegistry registry = context.getCapabilityRegistry();
                // field only when the field has indexFormats=[lucene] set in the mapping).
     */
            )
    /**
                                + " DelegatedPredicateSerializer that implements referencedFields()."
        for (int fieldIndex : fieldIndices) {
                                + predicate.getKind()
                "Unrecognized filter operator [" + predicate.getOperator().getName() + " / " + predicate.getKind() + "]"
                    // not a query error — fail explicitly rather than under-validating.
import org.apache.calcite.rex.RexInputRef;
                // a HAVING clause filters on a stats-derived column.
import org.opensearch.analytics.spi.DelegationType;
        List<FieldStorageInfo> fieldStorageInfos,
                        .map(i -> fieldStorageInfos.get(i).getFieldName() + ":" + fieldStorageInfos.get(i).getMappingType())
        DelegationBlockList blockList = context.getDelegationBlockList();
                    break;
                        throw new IllegalStateException(
     * checks backend format support, operator capability, and operator+fieldType support.
     *
        // every declared FilterCapability has a matching serializer registered, and reject
                        TextRelevanceFieldValidator.rejectNonTextFieldsForTextFunction(
                        viableSet.retainAll(registry.filterBackendsForField(function, storageInfo));
import org.apache.calcite.rex.RexCall;
                        }
            }
import org.opensearch.analytics.spi.ScalarFunction;
                RelNodeUtils.unwrapHep(filter.getInput()),
            throw new IllegalStateException(
                    );
 */
            );
                "No backend can evaluate filter predicate ["
            // mktime('...') > N): let any child-viable backend evaluate it.
        }
import org.apache.calcite.rel.core.Filter;
                    // MUST register a DelegatedPredicateSerializer whose referencedFields() surfaces
        }
        // Guard: reject excessively complex filter conditions early, before annotation.
import org.apache.logging.log4j.Logger;
    }
    // ---- Strategy determination ----
        List<String> childViableBackends
            Set<String> fieldViable;
                // computed in memory by the producer. The filter can only run on a backend
                            "No field-reference extraction available for full-text function ["
            FieldType returnType = FieldType.fromSqlTypeName(scalarFunctionCall.getType().getSqlTypeName());
 */
                    if (operandType != null) {
import org.apache.calcite.rel.RelNode;
                    // Eagerly reject text-relevance functions on non-text/keyword fields, unless the
                            // unknown field. (Wildcard/regex field tokens never reach here: they are
            }
        }
            // encode field names as string literals in nested MAPs rather than RexInputRef.
import java.util.List;
            }
                }
        FilterPredicateGuard.validate(filter.getCondition(), context.getMaxFilterPredicateCount());
                        throw new IllegalArgumentException(
                    for (String fieldName : literalFieldNames) {
     * {@link AnnotatedPredicate} with viable backends resolved from child's field storage.
    /**
        for (String candidateName : childViableBackends) {
            }
        Set<String> viableSet = new HashSet<>(registry.filterCapableBackends());
public class OpenSearchFilterRule extends RelOptRule {
            collect(operand, contents);
            // Calcite-internal value constructors (named-parameter MAP/ARRAY/ROW used by full-text
/*
 * compatible open source license.
        ScalarFunction function = ScalarFunction.fromSqlOperatorWithFallback(predicate.getOperator());
        // Compute operator-level viable backends: must be viable for child AND handle predicates
                    Set<String> viableSet = new HashSet<>(registry.filterCapableBackends());
import org.opensearch.analytics.spi.FieldReferences;
        RexNode annotatedCondition = annotateCondition(filter.getCondition(), childFieldStorage, childViableBackends);
                        + scalarFunctionCall
        return new AnnotatedPredicate(rexCall.getType(), rexCall, viableBackends, context.nextAnnotationId());
                        returnType = operandType;
        // mismatch only surfaces when FragmentConversion tries to delegate (correctness) or
    }
                fieldViable = new HashSet<>(childViableBackends);
            List<RexNode> annotatedOperands = new ArrayList<>();
            }
import java.util.HashSet;
        if (node instanceof RexInputRef inputRef) {
            // that, e.g., query_string(['severityNumber'], ...) on an INTEGER field doesn't get
                    + child.getClass().getSimpleName()
                throw new IllegalArgumentException(
        call.transformTo(
                    DelegatedPredicateSerializer serializer = registry.predicateSerializer(function);
                            + scalarFunctionCall.getType().getSqlTypeName()
            // routed to a backend that only declared (QUERY_STRING, TEXT) capability.
        if (function == null) {
 *
        CapabilityRegistry registry = context.getCapabilityRegistry();
        this.context = context;
                for (RexNode operand : scalarFunctionCall.getOperands()) {
                        + "] within filter predicate ["
                    }
                }
                viable.add(candidateName);
                    }
        // marked viable for them — but only when a non-blocked backend survives: blocking is a
                        for (FieldStorageInfo info : fieldStorageInfos) {
                            literalFieldNames,
 * <p>Annotates each leaf predicate with viable backends by checking field storage
            // FieldType from the first concrete operand. Backend capabilities for these UDFs
            viableSet.retainAll(registry.scalarBackendsAnyFormat(scalarFunc, returnType));
                child.getTraitSet(),
                    FieldType operandType = FieldType.fromSqlTypeName(operand.getType().getSqlTypeName());
    @Override
        if (!(condition instanceof RexCall rexCall)) {
                            // An explicitly-named literal field absent from the scan's schema is an
                viableBackends
            boolean canHandleAll = true;
                            if (fieldName.equals(info.getFieldName())) {
                );
     *
    private record PredicateContents(Set<Integer> fieldIndices, List<RexCall> scalarFunctionCalls) {
        if (fieldIndices.isEmpty()) {
     * Determines which backends can evaluate this leaf predicate.
                if (!registry.canHandle(candidateName, predicate.getViableBackends(), DelegationType.FILTER)) {
