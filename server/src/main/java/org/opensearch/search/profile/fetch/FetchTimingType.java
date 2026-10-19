    /** Time spent creating the stored fields visitor */
 *
    /** Time spent building fetch sub-phase processors */  
    /** Time spent executing a fetch sub-phase */
 * The OpenSearch Contributors require contributions made to  
    @Override
    /** Time spent loading the document _source */
/**  
    }
    /** Time spent setting next reader for each subphase processor **/
    /** Time spent loading stored fields for a hit */  
 * this file be licensed under the Apache-2.0 license or a
    LOAD_SOURCE,  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.profile.fetch;
 * compatible open source license.
    LOAD_STORED_FIELDS,
    public String toString() {
import java.util.Locale;
    GET_NEXT_READER,  
    SET_NEXT_READER,
    BUILD_SUB_PHASE_PROCESSORS,
/*  
    PROCESS;
        return name().toLowerCase(Locale.ROOT);  
 */  
    CREATE_STORED_FIELDS_VISITOR,
    /** Time spent getting the specific leaf reader context for a given segment index */
}
 */
public enum FetchTimingType {  
 * Timing points for fetch phase profiling.
