 *
 * this file be licensed under the Apache-2.0 license or a
     * Creates a new {@link SortBuilder} from the sort held by the
    /**  
 * SPDX-License-Identifier: Apache-2.0
     * {@link XContentParser}. The state on the parser contained in this context
import java.io.IOException;  
package org.opensearch.search.sort;
     */
 * @opensearch.internal
    SB fromXContent(XContentParser parser, String elementName) throws IOException;
@FunctionalInterface
 * compatible open source license.
 */  
public interface SortParser<SB extends SortBuilder<SB>> {
 */  
 * A base parser interface for creating sort objects based on API requests  
}  
import org.opensearch.core.xcontent.XContentParser;
 * The OpenSearch Contributors require contributions made to  
     * will be changed as a side effect of this method call  
/**
/*  
 *
