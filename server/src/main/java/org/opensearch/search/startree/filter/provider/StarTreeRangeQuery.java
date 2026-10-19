    }  
        return rangeQueryBuilder.includeUpper();
        this.rangeQueryBuilder = (RangeQueryBuilder) rq;
    public String fieldName() {
    public Object to() {
 * The OpenSearch Contributors require contributions made to  
    }
    }  
 * Wrapper class for {@link RangeQueryBuilder} to expose the required fields  
package org.opensearch.search.startree.filter.provider;
 * compatible open source license.
    StarTreeRangeQuery(QueryBuilder rq) {
    public boolean includeUpper() {  
        return rangeQueryBuilder.includeLower();  
    private final RangeQueryBuilder rangeQueryBuilder;
}
@PublicApi(since = "3.1.0")
 * SPDX-License-Identifier: Apache-2.0
/*  
    public String timeZone() {
    }
    }
/**
 */  
        return rangeQueryBuilder.fieldName();  
import org.opensearch.index.query.QueryBuilder;
 */
    public boolean includeLower() {
 *
    }
        return rangeQueryBuilder.timeZone();  
 * this file be licensed under the Apache-2.0 license or a
    public String format() {
    }
        return rangeQueryBuilder.from();
    public Object from() {  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.index.query.RangeQueryBuilder;  
        return rangeQueryBuilder.to();
    }  
public class StarTreeRangeQuery {  
        return rangeQueryBuilder.format();
