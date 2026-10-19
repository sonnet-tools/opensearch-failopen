}  
public interface InternalProfileComponent {
     * @return the profiling results for this profile component
    Collection<? extends InternalProfileComponent> children();
 * compatible open source license.
@PublicApi(since = "2.9.0")
    /**  
    String getReason();
 *
    /**
 * @opensearch.api
    String getName();  
 */  
    /**  
    /**
 */  
 *
 * Container for an agg profiling component  
     * @return profile component name
     * @return the time taken by this profile component
 * this file be licensed under the Apache-2.0 license or a
/*  
     */  
/**
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
    CollectorResult getCollectorTree();  
     * @return the children of this profile component (if any)  
     * @return the reason this profile component has been included  
     */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.profile.query;
    /**
    long getTime();
     */
import java.util.Collection;  
     */
