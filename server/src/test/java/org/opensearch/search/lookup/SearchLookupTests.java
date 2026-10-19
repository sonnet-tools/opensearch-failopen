 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.lookup;
public class SearchLookupTests extends OpenSearchTestCase {  
    public void testDeprecatedConstructorShardId() {
 */  
 * compatible open source license.
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
 *
    }
/*  
        final SearchLookup searchLookup = new SearchLookup(mock(MapperService.class), (a, b) -> null);
import org.opensearch.index.mapper.MapperService;
        assertThrows(IllegalStateException.class, searchLookup::shardId);  
}
