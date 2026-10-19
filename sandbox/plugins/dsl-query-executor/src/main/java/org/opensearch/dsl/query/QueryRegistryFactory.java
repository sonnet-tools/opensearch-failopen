        QueryRegistry registry = new QueryRegistry();  
/*  
        registry.register(new TermQueryTranslator());
}  
/**  
package org.opensearch.dsl.query;
        return registry;
        registry.register(new PrefixQueryTranslator());
import org.opensearch.dsl.query.range.RangeQueryTranslator;
public class QueryRegistryFactory {  
        registry.register(new MatchAllQueryTranslator());  
        registry.register(new WildcardQueryTranslator());
 * The OpenSearch Contributors require contributions made to  
        registry.register(new ExistsQueryTranslator());
        registry.register(new TermsQueryTranslator());
    private QueryRegistryFactory() {}
    public static QueryRegistry create() {
        registry.register(new RangeQueryTranslator());
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 * Creates a {@link QueryRegistry} populated with all supported query translators.
 */
 */  
    }
        // TODO: add other query translators  
    /** Creates a registry with all supported query translators. */
 * compatible open source license.
        registry.register(new BoolQueryTranslator(registry));  
