 *
        return node.toString();  
import java.util.Set;
    }
 * (full-text, point range) and stored fields. Standard + full-text filter capabilities.  
    private static final Set<ScalarFunction> FULL_TEXT_OPS = Set.of(
    }
                            String fieldName = fieldLit.getValueAs(String.class);
        ScalarFunction.EQUALS,
 * falls through to the defaults declared here.
        ScalarFunction.NOT_EQUALS,
            if (operand instanceof RexCall outerMap && outerMap.getOperands().size() >= 2) {
                    } else {
                        if (nestedOperands.get(i) instanceof RexLiteral fieldLit) {  
    }
    public EngineReaderManager<Object> createReaderManager(ReaderManagerConfig settings) {
            for (FieldType type : FULL_TEXT_TYPES) {
                RexNode valueNode = outerMap.getOperands().get(1);
 *
        FULL_TEXT_TYPES.addAll(FieldType.keyword());  
        FULL_TEXT_TYPES.addAll(FieldType.text());
            ScalarFunction.QUERY_STRING,  
    }
            mapLiteralSerializer
        }
                    if (Regex.isSimpleMatchPattern(token)) {
                    }
            mapLiteralSerializer,  
     * Default delegated-predicate serializers for the multi-field full-text functions. Their
                                names.add(fieldName);  
                    for (int i = 0; i + 1 < nestedOperands.size(); i += 2) {
    /**  
        ScalarFunction.LIKE
        ScalarFunction.IN,  
    @Override
     */
                            }
    // ---- SearchBackEndPlugin (storage) ----  
        Set<FilterCapability> caps = new HashSet<>();  
            }
    );
        return (subtree, fieldStorage) -> {
import org.opensearch.analytics.spi.FieldStorageInfo;
                        names.add(fieldName);
        ScalarFunction.IS_NULL,
    );
    @Override
public class MockLuceneBackend extends MockBackend implements SearchBackEndPlugin<Object> {  
import org.opensearch.plugins.SearchBackEndPlugin;
        if (node instanceof org.opensearch.analytics.planner.rel.AnnotatedPredicate ap) {  
    }
            mapLiteralSerializer,
        }
            ScalarFunction.MULTI_MATCH,
        };
        ScalarFunction.REGEXP,  
    private static String describeSubtree(org.apache.calcite.rex.RexNode node) {
/*  
        return FILTER_CAPS;
        return null;  
        }
 */
                case NOT: {
import java.util.ArrayList;
                        children.add(describeSubtree(child));
                        patterns.add(token);  
    }
    }
            }  
                if (!"fields".equals(key) && !"field".equals(key)) continue;  
                if (!(keyNode instanceof RexLiteral keyLit)) continue;
     */  
    static {
        STANDARD_TYPES.addAll(FieldType.date());  
                    }  
            node = ap.unwrap();
                default:
        };
                        literals.add(token);
            // Simple test convertor: walks the subtree and produces a descriptive string  
    private static final Set<ScalarFunction> STANDARD_OPS = Set.of(  
package org.opensearch.analytics.planner;
    @Override  
 */  
                        }
                case AND:
        ScalarFunction.WILDCARD,
        STANDARD_TYPES.addAll(FieldType.numeric());  
                if (valueNode instanceof RexCall nestedMap) {  
     * Extracts literal field names from the {@code fields}/{@code field} MAP operand of a
        ScalarFunction.IS_NOT_NULL,
import org.opensearch.analytics.spi.FilterCapability;  
     * {@code referencedFields} mirrors the planner's pre-extractor behavior: literals come from the  
        ScalarFunction.GREATER_THAN_OR_EQUAL,
                    if (fieldName != null && !fieldName.isEmpty()) {  
    }
        );  
            caps.add(new FilterCapability.Standard(op, STANDARD_TYPES, LUCENE_FORMATS));
        ScalarFunction.LESS_THAN_OR_EQUAL,  
    public List<String> getSupportedFormats() {  
                    return call.getOperator().getName();  
/**
                }  
    private static final Set<String> LUCENE_FORMATS = Set.of(LUCENE_DATA_FORMAT);
            }
        List<String> names = new ArrayList<>();  
    }  
        for (RexNode operand : predicate.getOperands()) {
            public byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
        STANDARD_TYPES.addAll(FieldType.keyword());
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;  
import org.opensearch.common.regex.Regex;
            return describeSubtree(subtree).getBytes(java.nio.charset.StandardCharsets.UTF_8);
            @Override
    public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
 * SCAN + FILTER only (no AGGREGATE).
                }
                    return call.getKind() + "(" + String.join(",", children) + ")";  
            ScalarFunction.SIMPLE_QUERY_STRING,
    public static final String LUCENE_DATA_FORMAT = "lucene";  
    private static final Set<FieldType> STANDARD_TYPES = new HashSet<>();
 * The OpenSearch Contributors require contributions made to  
    private static final Set<FilterCapability> FILTER_CAPS;
import java.util.HashSet;
    @Override  
import org.opensearch.index.engine.exec.EngineReaderManager;
    public static final String NAME = "mock-lucene";
        return Map.of(
                return new FieldReferences(literals, patterns, false);
        ScalarFunction.GREATER_THAN,  
 * <p>Tests override only the capability methods they need — everything else  
    public String name() {
                }
import java.util.List;  
 * Mock Lucene backend for tests. Supports lucene format with index structures
        STANDARD_TYPES.addAll(FieldType.text());
import org.opensearch.analytics.spi.FieldType;
    static {
        ScalarFunction.MATCH_PHRASE,  
                RexNode keyNode = outerMap.getOperands().get(0);  
    public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
                    }  
    private static List<String> extractLiteralFieldNames(RexCall predicate) {
                throw new UnsupportedOperationException("Mock backend does not serialize predicates");  
                    for (org.apache.calcite.rex.RexNode child : call.getOperands()) {  
                List<String> patterns = new ArrayList<>();  
    /**
        }
        ScalarFunction.MATCH,
                    java.util.List<String> children = new java.util.ArrayList<>();
import org.apache.calcite.rex.RexNode;  
                caps.add(new FilterCapability.FullText(op, type, LUCENE_FORMATS, Set.of()));  
        ScalarFunction.LESS_THAN,
    @Override
        if (node instanceof org.apache.calcite.rex.RexCall call) {  
        FILTER_CAPS = caps;  
                String key = keyLit.getValueAs(String.class);
    @Override
        return List.of(LUCENE_DATA_FORMAT);
    private static final Set<FieldType> FULL_TEXT_TYPES = new HashSet<>();
        STANDARD_TYPES.add(FieldType.BOOLEAN);
     * tests. Tests needing in-string fields or explicit lenient override this.
        DelegatedPredicateSerializer mapLiteralSerializer = new DelegatedPredicateSerializer() {  
                    List<RexNode> nestedOperands = nestedMap.getOperands();
import org.opensearch.analytics.spi.FieldReferences;  
     * {@code fields} MAP, fan-out when empty, non-lenient. {@code serialize} is unused in planner
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
                case OR:  
 * compatible open source license.
                for (String token : extractLiteralFieldNames(call)) {
 * this file be licensed under the Apache-2.0 license or a
        ScalarFunction.QUERY_STRING
            }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
import org.apache.calcite.rex.RexCall;
}
    }
    }  
     * multi-field full-text {@code RexCall} — the field-name encoding the SQL plugin emits. Mirrors
     * the planner's pre-extractor behavior so existing full-text tests keep their semantics.  
    static {
        for (ScalarFunction op : FULL_TEXT_OPS) {
                List<String> literals = new ArrayList<>();
            switch (call.getKind()) {
        return NAME;
        for (ScalarFunction op : STANDARD_OPS) {
import org.apache.calcite.rex.RexLiteral;
import org.opensearch.analytics.spi.ScalarFunction;
        return names;  
            }
        ScalarFunction.FUZZY,
        }  
                    }
    protected Set<FilterCapability> filterCapabilities() {  
            public FieldReferences referencedFields(RexCall call, List<FieldStorageInfo> fieldStorage) {
            @Override  
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
                    String fieldName = valueLit.getValueAs(String.class);
                            if (fieldName != null && !fieldName.isEmpty()) {
                } else if (valueNode instanceof RexLiteral valueLit) {
