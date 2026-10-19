 * Serializer for the MATCHALL function.  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexCall;
 * Extends AbstractQuerySerializer directly (not AbstractRelevanceSerializer)
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
    @Override  
        return new MatchAllQueryBuilder();
 */  
import org.opensearch.index.query.MatchAllQueryBuilder;  
    }  
import org.opensearch.index.query.QueryBuilder;
 *
/*  
 * The OpenSearch Contributors require contributions made to  
}
 * SPDX-License-Identifier: Apache-2.0
/**
package org.opensearch.be.lucene.serializers;
 * compatible open source license.
 */  
public class MatchAllSerializer extends AbstractQuerySerializer {
import java.util.List;  
 * because MATCHALL is a zero-argument function with no MAP_VALUE_CONSTRUCTOR operands.
import org.opensearch.analytics.spi.FieldStorageInfo;
