        final QueryCollectorArguments queryCollectorArguments  
        return Optional.empty();
 * compatible open source license.
    /**
    public static void registerFactory(QueryCollectorContextSpecFactory factory) {  
     * @param queryCollectorArguments query collector arguments
import org.apache.lucene.search.Query;
     */  
    /**
     * @return collector context spec  
    ) throws IOException {
 */  
            Optional<QueryCollectorContextSpec> spec = factory.createQueryCollectorContextSpec(
                queryCollectorArguments
import java.io.IOException;
        }
    /**  
        return registry;
        while (iterator.hasNext()) {  
                return spec;
public final class QueryCollectorContextSpecRegistry {
     * Register factory  
package org.opensearch.search.query;
}
                query,
     * Get all collector context spec factories
    }
 * SPDX-License-Identifier: Apache-2.0
            }  
     * Get collector context spec
import java.util.concurrent.CopyOnWriteArrayList;
 * The OpenSearch Contributors require contributions made to  
 * Registry class to load all collector context spec factories during cluster bootstrapping
     * @param factory collector context spec factory defined in plugin
    public static Optional<QueryCollectorContextSpec> getQueryCollectorContextSpec(  
    }  
        registry.add(factory);
            );  
    }  
     */
     * @throws IOException
 */  
                searchContext,  
import org.opensearch.search.internal.SearchContext;
        Iterator<QueryCollectorContextSpecFactory> iterator = registry.iterator();
 *
/*  
     * @param searchContext search context  
            QueryCollectorContextSpecFactory factory = iterator.next();
/**
     */
import java.util.List;  
 * this file be licensed under the Apache-2.0 license or a
     * @return list of collector context spec factories
    private static final List<QueryCollectorContextSpecFactory> registry = new CopyOnWriteArrayList<>();
        final SearchContext searchContext,
import java.util.Optional;
    public static List<QueryCollectorContextSpecFactory> getCollectorContextSpecFactories() {
    private QueryCollectorContextSpecRegistry() {}
import java.util.Iterator;
        final Query query,
     * @param query required to create collectorContext spec
            if (spec.isEmpty() == false) {
