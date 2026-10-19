import static org.hamcrest.Matchers.is;  
/*  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
}
        refresh();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
            index("test", "doc", "" + i, "foo", "bar");
 * compatible open source license.
        SearchResponse response = client().prepareSearch("test").get();
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 */  
import org.opensearch.plugins.Plugin;  
import java.util.Collection;
import org.opensearch.test.OpenSearchIntegTestCase;
 */
 * software distributed under the License is distributed on an
public abstract class AbstractAzureFsTestCase extends OpenSearchIntegTestCase {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    public void testAzureFs() {
/*
    }  
/*  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *  
        createIndex("test");
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchResponse;
 * this file be licensed under the Apache-2.0 license or a
        for (long i = 0; i < nbDocs; i++) {  
 * under the License.  
        // Create an index and index some documents  
    }  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;  
 * You may obtain a copy of the License at  
import org.opensearch.plugin.store.smb.SMBStorePlugin;
 * KIND, either express or implied.  See the License for the
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *
        assertThat(response.getHits().getTotalHits().value(), is(nbDocs));
        return Arrays.asList(SMBStorePlugin.class);
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.store;
 * this work for additional information regarding copyright
        }
 * the Apache License, Version 2.0 (the "License"); you may
        long nbDocs = randomIntBetween(10, 1000);
    @Override  
