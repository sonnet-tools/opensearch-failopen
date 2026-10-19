    }
                if (valueNode instanceof RexCall nestedMap) {
            mapLiteralSerializer
        if (node instanceof org.apache.calcite.rex.RexCall call) {
        STANDARD_TYPES.addAll(FieldType.date());
        }
                    }
    private static final Set<FilterCapability> FILTER_CAPS;
 * Mock Lucene backend for tests. Supports lucene format with index structures
        };
    }
    public static final String NAME = "mock-lucene";
                        patterns.add(token);
                    if (fieldName != null && !fieldName.isEmpty()) {
        FILTER_CAPS = caps;
            // Simple test convertor: walks the subtree and produces a descriptive string
 *
 * compatible open source license.
                case NOT: {
        ScalarFunction.GREATER_THAN,
import org.opensearch.plugins.SearchBackEndPlugin;
        STANDARD_TYPES.addAll(FieldType.numeric());
                if (!(keyNode instanceof RexLiteral keyLit)) continue;
    private static List<String> extractLiteralFieldNames(RexCall predicate) {
                }
        };
/*
                }
            @Override
    @Override
            mapLiteralSerializer,
                    }
import java.util.List;
        ScalarFunction.LESS_THAN,
                        names.add(fieldName);
                        children.add(describeSubtree(child));
    private static final Set<ScalarFunction> FULL_TEXT_OPS = Set.of(
                RexNode valueNode = outerMap.getOperands().get(1);
                    for (int i = 0; i + 1 < nestedOperands.size(); i += 2) {
        ScalarFunction.QUERY_STRING
        for (ScalarFunction op : STANDARD_OPS) {
    public List<String> getSupportedFormats() {
 * SPDX-License-Identifier: Apache-2.0
            }
            if (operand instanceof RexCall outerMap && outerMap.getOperands().size() >= 2) {
 * falls through to the defaults declared here.
        }
    }
            for (FieldType type : FULL_TEXT_TYPES) {
                        }
                    for (org.apache.calcite.rex.RexNode child : call.getOperands()) {
import java.util.HashSet;
            caps.add(new FilterCapability.Standard(op, STANDARD_TYPES, LUCENE_FORMATS));
        }
            public byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
     * {@code fields} MAP, fan-out when empty, non-lenient. {@code serialize} is unused in planner
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
                    }
 * this file be licensed under the Apache-2.0 license or a
        return names;
                caps.add(new FilterCapability.FullText(op, type, LUCENE_FORMATS, Set.of()));
        ScalarFunction.MATCH,
     * {@code referencedFields} mirrors the planner's pre-extractor behavior: literals come from the
import org.apache.calcite.rex.RexNode;
        return (subtree, fieldStorage) -> {
        ScalarFunction.EQUALS,
    @Override
import org.opensearch.analytics.spi.ScalarFunction;
                String key = keyLit.getValueAs(String.class);
    }
        STANDARD_TYPES.add(FieldType.BOOLEAN);
 * <p>Tests override only the capability methods they need — everything else
            mapLiteralSerializer,
                                names.add(fieldName);
            }
                    if (Regex.isSimpleMatchPattern(token)) {
        DelegatedPredicateSerializer mapLiteralSerializer = new DelegatedPredicateSerializer() {
                    return call.getKind() + "(" + String.join(",", children) + ")";
        for (RexNode operand : predicate.getOperands()) {
                List<String> literals = new ArrayList<>();
    private static final Set<FieldType> STANDARD_TYPES = new HashSet<>();
    public static final String LUCENE_DATA_FORMAT = "lucene";
    private static final Set<String> LUCENE_FORMATS = Set.of(LUCENE_DATA_FORMAT);
    public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        return NAME;
    private static final Set<ScalarFunction> STANDARD_OPS = Set.of(
            }
    }
    );
    @Override
     * Default delegated-predicate serializers for the multi-field full-text functions. Their
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            ScalarFunction.SIMPLE_QUERY_STRING,
                    return call.getOperator().getName();
            }
     * tests. Tests needing in-string fields or explicit lenient override this.
    public String name() {
                            }
                if (!"fields".equals(key) && !"field".equals(key)) continue;
import org.opensearch.index.engine.exec.EngineReaderManager;
                for (String token : extractLiteralFieldNames(call)) {
                        literals.add(token);
        for (ScalarFunction op : FULL_TEXT_OPS) {
    }
                            if (fieldName != null && !fieldName.isEmpty()) {
    // ---- SearchBackEndPlugin (storage) ----
import org.apache.calcite.rex.RexCall;
    static {
            @Override
                List<String> patterns = new ArrayList<>();
    private static final Set<FieldType> FULL_TEXT_TYPES = new HashSet<>();
                } else if (valueNode instanceof RexLiteral valueLit) {
    }
                default:
            return describeSubtree(subtree).getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }
        return List.of(LUCENE_DATA_FORMAT);
 */
        if (node instanceof org.opensearch.analytics.planner.rel.AnnotatedPredicate ap) {
        );
    protected Set<FilterCapability> filterCapabilities() {
        ScalarFunction.WILDCARD,
        STANDARD_TYPES.addAll(FieldType.keyword());
        FULL_TEXT_TYPES.addAll(FieldType.text());
import org.apache.calcite.rex.RexLiteral;
        ScalarFunction.LESS_THAN_OR_EQUAL,
import org.opensearch.analytics.spi.FieldType;
                    java.util.List<String> children = new java.util.ArrayList<>();
package org.opensearch.analytics.planner;
 */
                    String fieldName = valueLit.getValueAs(String.class);
/**
import java.util.Map;
    @Override
import org.opensearch.analytics.spi.FieldReferences;
        ScalarFunction.MATCH_PHRASE,
                case OR:
            ScalarFunction.QUERY_STRING,
    /**
        }
        }
import org.opensearch.common.regex.Regex;
                }
    private static String describeSubtree(org.apache.calcite.rex.RexNode node) {
import java.util.Set;
 * (full-text, point range) and stored fields. Standard + full-text filter capabilities.
import java.util.ArrayList;
public class MockLuceneBackend extends MockBackend implements SearchBackEndPlugin<Object> {
        Set<FilterCapability> caps = new HashSet<>();
    }
            }
                    List<RexNode> nestedOperands = nestedMap.getOperands();
    /**
            node = ap.unwrap();
     */
                case AND:
        ScalarFunction.FUZZY,
import org.opensearch.analytics.spi.FieldStorageInfo;
        ScalarFunction.IS_NULL,
            public FieldReferences referencedFields(RexCall call, List<FieldStorageInfo> fieldStorage) {
    );
    static {
    public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
        ScalarFunction.IS_NOT_NULL,
        ScalarFunction.LIKE
                    } else {
        return FILTER_CAPS;
                            String fieldName = fieldLit.getValueAs(String.class);
                RexNode keyNode = outerMap.getOperands().get(0);
     * Extracts literal field names from the {@code fields}/{@code field} MAP operand of a
        ScalarFunction.IN,
 * SCAN + FILTER only (no AGGREGATE).
                        if (nestedOperands.get(i) instanceof RexLiteral fieldLit) {
    @Override
    }
        ScalarFunction.NOT_EQUALS,
                    }
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
                return new FieldReferences(literals, patterns, false);
        ScalarFunction.GREATER_THAN_OR_EQUAL,
    @Override
     * multi-field full-text {@code RexCall} — the field-name encoding the SQL plugin emits. Mirrors
     * the planner's pre-extractor behavior so existing full-text tests keep their semantics.
        return Map.of(
}
    public EngineReaderManager<Object> createReaderManager(ReaderManagerConfig settings) {
        return null;
            switch (call.getKind()) {
import org.opensearch.analytics.spi.FilterCapability;
        ScalarFunction.REGEXP,
        return node.toString();
 *
    static {
        STANDARD_TYPES.addAll(FieldType.text());
        FULL_TEXT_TYPES.addAll(FieldType.keyword());
        List<String> names = new ArrayList<>();
            ScalarFunction.MULTI_MATCH,
 * The OpenSearch Contributors require contributions made to
    }
                throw new UnsupportedOperationException("Mock backend does not serialize predicates");
     */
