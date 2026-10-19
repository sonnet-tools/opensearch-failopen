 * under the License.  
    }
        return cluster().numDataNodes();
    }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
    @Override  
 * software distributed under the License is distributed on an
 */  
    public void testCustomDummyQuery() {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.index.query.BoolQueryBuilder;
        assertHitCount(client().prepareSearch("index").setQuery(new BoolQueryBuilder().must(new DummyQueryBuilder())).get(), 1L);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        client().prepareIndex("index").setId("1").setSource("field", "value").get();
 * Unless required by applicable law or agreed to in writing,
    }  
    }
 * specific language governing permissions and limitations
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        refresh();  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 *
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        createIndex("test");  
 * SPDX-License-Identifier: Apache-2.0
    public void testCustomDummyQueryWithinBooleanQuery() {  
/*  
    @Before  
        super.setUp();
 */
        ensureGreen();
 */  
import java.util.Arrays;  
public class CustomQueryParserIT extends OpenSearchIntegTestCase {
        assertHitCount(client().prepareSearch("index").setQuery(new DummyQueryBuilder()).get(), 1L);  
package org.opensearch.index.query.plugin;
 * not use this file except in compliance with the License.
    protected int numberOfShards() {
 * GitHub history for details.
import org.junit.Before;
 *
import org.opensearch.plugins.Plugin;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    @Override
}  
import org.opensearch.test.OpenSearchIntegTestCase;  
        return Arrays.asList(DummyQueryParserPlugin.class);
    public void setUp() throws Exception {
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
import java.util.Collection;
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 *  
