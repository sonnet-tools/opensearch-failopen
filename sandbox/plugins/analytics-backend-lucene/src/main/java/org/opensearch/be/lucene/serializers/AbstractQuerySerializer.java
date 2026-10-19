 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
}  
        QueryBuilder queryBuilder = buildQueryBuilder(call, fieldStorage);
import org.opensearch.analytics.spi.FieldStorageInfo;  
        return field.getExactMatchSubfield() != null ? field.getFieldName() + "." + field.getExactMatchSubfield() : field.getFieldName();
    public abstract QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage);  
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
        return ConversionUtils.serializeQueryBuilder(queryBuilder);  
 * Base class for query serializers. Implements the {@link DelegatedPredicateSerializer}
    }
    protected static String resolveFieldName(FieldStorageInfo field) {  
public abstract class AbstractQuerySerializer implements DelegatedPredicateSerializer {
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryBuilder;
package org.opensearch.be.lucene.serializers;
 */  
 * compatible open source license.
import org.opensearch.be.lucene.ConversionUtils;
import org.apache.calcite.rex.RexCall;
 *
     */
import java.util.List;
/**  
     * (e.g. text → .keyword), otherwise uses the base field name.
 * contract by delegating to a template method that builds the {@link QueryBuilder}.
    public final byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
    }
 */  
    /**
/*  
     * Resolves the target Lucene field name: routes to the exact-match subfield when available  
