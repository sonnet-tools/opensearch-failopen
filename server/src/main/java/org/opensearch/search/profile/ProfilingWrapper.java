 * SPDX-License-Identifier: Apache-2.0
 * while preserving access to the original (delegate) component.
    /**
 *            {@link org.opensearch.search.aggregations.Aggregator})
 * if (scorer instanceof ProfilingWrapper) {
 * When search profiling is enabled, OpenSearch wraps scorers, collectors, aggregators, and other components
 * @opensearch.api
 * }</pre>  
 * }
public interface ProfilingWrapper<T> {
 * <pre>{@code
     * @return the original component that was wrapped for profiling
/*  
/**  
 * @param <T> the type of the wrapped component (e.g., {@link org.apache.lucene.search.Scorer},
 *     // access custom scorer methods on the delegate
 * compatible open source license.
 */  
     */
     * Returns the underlying delegate component that this profiling wrapper decorates.
 * <p>
 * to detect and unwrap such wrappers, accessing the underlying component without requiring reflection  
 */  
 * Generic interface for profiling wrappers that decorate search components with timing instrumentation
 * <p>  
 *            {@link org.apache.lucene.search.Collector},  
 * in profiling decorators that are package-private. This interface provides a public contract for plugins
 * or knowledge of package-private implementation classes.
@PublicApi(since = "3.6.0")
    T getDelegate();  
 * this file be licensed under the Apache-2.0 license or a
 * Example usage in a plugin to unwrap a profiled scorer:  
import org.opensearch.common.annotation.PublicApi;
     *  
 *
package org.opensearch.search.profile;
 *
}
 *     Scorer delegate = ((ProfilingWrapper<Scorer>) scorer).getDelegate();  
 * The OpenSearch Contributors require contributions made to  
