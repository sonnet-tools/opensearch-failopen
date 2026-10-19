/*  
import org.apache.calcite.rex.RexInputRef;
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
        if (negated) {
    @Override
        return new BoolQueryBuilder().mustNot(new ExistsQueryBuilder(fieldName));
 * </ul>  
import org.opensearch.index.query.BoolQueryBuilder;
 */  
        if (call.getOperands().size() != 1 || !(call.getOperands().get(0) instanceof RexInputRef columnRef)) {  
 * compatible open source license.
            throw new IllegalArgumentException("IS_NULL/IS_NOT_NULL expects a single column reference");
import org.opensearch.analytics.spi.FieldStorageInfo;  
        }
 * <ul>  
        this.negated = negated;
/**
            return new ExistsQueryBuilder(fieldName);
 * this file be licensed under the Apache-2.0 license or a
}  
 * Serializer for IS_NULL and IS_NOT_NULL.
import org.apache.calcite.rex.RexCall;
 *   <li>IS_NOT_NULL → {@code ExistsQuery(field)}</li>
import org.opensearch.index.query.ExistsQueryBuilder;
    }
package org.opensearch.be.lucene.serializers;
 *
        FieldStorageInfo field = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex());
        String fieldName = resolveFieldName(field);
 * The OpenSearch Contributors require contributions made to  
 */
    }
    public IsNullSerializer(boolean negated) {  
public class IsNullSerializer extends AbstractQuerySerializer {
        }  
 *   <li>IS_NULL → {@code bool{ mustNot: ExistsQuery(field) }}</li>
    private final boolean negated;
import org.opensearch.index.query.QueryBuilder;  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
