                    return b;  
        if (node instanceof AnnotatedPredicate ap) {
import java.util.Map;
        throw new IllegalStateException("Unexpected RexNode in delegated subtree: " + node);  
 */  
package org.opensearch.be.lucene;
                }
                    return leafToQueryBuilder(call, fieldStorage);  
 * The OpenSearch Contributors require contributions made to  
    LuceneSubtreeConvertor(Map<ScalarFunction, DelegatedPredicateSerializer> leafSerializers) {  
        }
        ScalarFunction fn = ScalarFunction.fromSqlOperatorWithFallback(call.getOperator());
                case AND: {
    private QueryBuilder leafToQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {  
 * @opensearch.internal  
 * {@link QueryBuilder} objects for leaves via existing serializers, composing  
        DelegatedPredicateSerializer serializer = leafSerializers.get(fn);
 * them with {@link BoolQueryBuilder} for AND/OR/NOT, and serializes once at the root.
import org.opensearch.analytics.spi.FieldStorageInfo;  
final class LuceneSubtreeConvertor implements DelegatedSubtreeConvertor {
                    }
                    for (RexNode child : call.getOperands()) {
    public byte[] convertSubtree(RexNode subtree, List<FieldStorageInfo> fieldStorage) {
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
 *
        if (serializer == null) {  
        return ((AbstractQuerySerializer) serializer).buildQueryBuilder(call, fieldStorage);  
 * Converts a maximal same-backend delegated RexNode subtree into a single
                    }  
            switch (call.getKind()) {  
        this.leafSerializers = leafSerializers;
            }
                    return b;
 *
    private final Map<ScalarFunction, DelegatedPredicateSerializer> leafSerializers;
        return ConversionUtils.serializeQueryBuilder(qb);
                    BoolQueryBuilder b = new BoolQueryBuilder();  
        if (node instanceof RexCall call) {
                case NOT: {  
import java.util.List;  
        }
}
    }
                }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexCall;
 */
import org.apache.calcite.rex.RexNode;
                    for (RexNode child : call.getOperands()) {  
                default:
    }
                        b.must(toQueryBuilder(child, fieldStorage));
            node = ap.unwrap();  
                    BoolQueryBuilder b = new BoolQueryBuilder();
import org.opensearch.analytics.spi.ScalarFunction;
                    return b;  
 * compatible open source license.
/**  
                case OR: {
    private QueryBuilder toQueryBuilder(RexNode node, List<FieldStorageInfo> fieldStorage) {
/*  
            throw new IllegalStateException("Unrecognized operator in delegated subtree: " + call.getOperator());  
            throw new IllegalStateException("No serializer for [" + fn + "] inside delegated subtree");
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.be.lucene.serializers.AbstractQuerySerializer;
                        b.should(toQueryBuilder(child, fieldStorage));
                    b.mustNot(toQueryBuilder(call.getOperands().get(0), fieldStorage));
        QueryBuilder qb = toQueryBuilder(subtree, fieldStorage);  
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
                }
        }
import org.opensearch.index.query.BoolQueryBuilder;  
        if (fn == null) {
 * serialized {@link BoolQueryBuilder}. Walks the subtree once, building
import org.opensearch.index.query.QueryBuilder;
    }
    @Override
                    BoolQueryBuilder b = new BoolQueryBuilder();
        }
    }
