    public static final SqlFunction UNRESOLVED_QUERY = new SqlFunction(
/*  
}  
     * Creates an unresolved query call.
        super(type, UNRESOLVED_QUERY, List.of());
import org.apache.calcite.sql.type.ReturnTypes;  
 */  
 * decide how to handle them — push to Lucene, absorb into a physical scan, or reject.  
public class UnresolvedQueryCall extends RexCall {
    }  
 * A RexCall that wraps a QueryBuilder that couldn't be converted to standard Calcite Rex expressions.  
        this.queryBuilder = queryBuilder;
import org.apache.calcite.rex.RexCall;
    public UnresolvedQueryCall(RelDataType type, QueryBuilder queryBuilder) {  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    /** Marker operator identifying unresolved query nodes in the plan. */  
        null,
        null,  
package org.opensearch.dsl.query;
import java.util.List;  
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.SqlFunction;  
 * <p>The analytics engine's optimizer can inspect these nodes via {@link #getQueryBuilder()} and
import org.opensearch.index.query.QueryBuilder;
/**
    }
 *
     *
     */
 * compatible open source license.
        ReturnTypes.BOOLEAN,
 * The OpenSearch Contributors require contributions made to  
    private final QueryBuilder queryBuilder;
import org.apache.calcite.sql.SqlFunctionCategory;
        return queryBuilder;
    );
 *
        SqlKind.OTHER_FUNCTION,  
 * <p>Reusable for any query type: wildcard, match, query_string, fuzzy, etc.
 *
     * @param queryBuilder the original OpenSearch query that couldn't be converted
     * @param type the return type (boolean — it's a filter condition)  
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the original OpenSearch query builder. */
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.type.RelDataType;
    public QueryBuilder getQueryBuilder() {  
    /**  
        "UNRESOLVED_QUERY",
 */  
