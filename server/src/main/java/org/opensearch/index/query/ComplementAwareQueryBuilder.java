 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
}
 */  
/*  
 * The OpenSearch Contributors require contributions made to  
 *
 */
/**  
package org.opensearch.index.query;
     * May be null, in which case the complement couldn't be determined.  
    /**
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
public interface ComplementAwareQueryBuilder {  
     */
     * Returns a list of RangeQueryBuilder whose elements, when combined, form the complement of this range query.
     * @return the complement
    List<? extends QueryBuilder> getComplement(QueryShardContext context);  
 * A QueryBuilder which can provide QueryBuilders that make up the complement of the original query.
