import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
/*  
 */  
    public List<SortSpec<?>> getSorts() {  
 *
import java.util.Collections;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.sort.plugin;
 * SPDX-License-Identifier: Apache-2.0
}  
 * compatible open source license.
    @Override
        return Collections.singletonList(new SortSpec<>(CustomSortBuilder.NAME, CustomSortBuilder::new, CustomSortBuilder::fromXContent));
import org.opensearch.plugins.SearchPlugin;
import org.opensearch.plugins.Plugin;
public class CustomSortPlugin extends Plugin implements SearchPlugin {
    }
