            assertEquals(1, values.docValueCount());
                CoreValuesSourceType.BYTES
            assertEquals(1, values.docValueCount());  
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
        }
                null,  
                "bytes",
                "bool",  
                derived_field,
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
            config = ValuesSourceConfig.resolve(context, null, "bytes", null, "abc", null, null, CoreValuesSourceType.BYTES);
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
                CoreValuesSourceType.BYTES
            assertEquals(1, values.docValueCount());
 */  
                null,  
            assertEquals(42, values.nextValue());
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();  
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            assertTrue(values.advanceExact(0));
            values = valuesSource.longValues(ctx);
                context,
            );  
                null,
            assertEquals(new BytesRef("abc"), values.nextValue());
    }
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
    public void testLong() throws Exception {
        IndexService indexService = createIndex("index", Settings.EMPTY);  
                null,
                null,
    }
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            ValuesSourceConfig config = ValuesSourceConfig.resolve(  
        }
            "type=alias,path=field"
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.index.SortedNumericDocValues;
            );
            SortedNumericDocValues values = valuesSource.longValues(ctx);  
}  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {  
            .endObject()
            );  
            "index",  
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);  
            .startObject()  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                null,
                null,
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bool", "type=boolean");  
import org.opensearch.common.settings.Settings;
 * license agreements. See the NOTICE file distributed with
        }  
                null,
                null,
 * Modifications Copyright OpenSearch Contributors. See
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
                context,  
    public void testEmptyLong() throws Exception {
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
                null,  
                "long",  
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bytes", "type=keyword");
            assertNotNull(valuesSource);  
            assertEquals(42, values.nextValue());
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);  
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
 * not use this file except in compliance with the License.
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    }  
                "bool",
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            assertNotNull(script);
 * compatible open source license.
            config = ValuesSourceConfig.resolve(context, ValueType.STRING, "bytes", null, "abc", null, null, CoreValuesSourceType.BYTES);
            );  
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            assertEquals(1, values.nextValue());
            config = ValuesSourceConfig.resolve(context, ValueType.NUMBER, "long", null, 42, null, null, CoreValuesSourceType.BYTES);
            );
    }
        client().prepareIndex("index").setId("1").setSource("bool", true).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            SortedNumericDocValues values = valuesSource.longValues(ctx);  
 * software distributed under the License is distributed on an
        IndexService indexService = createIndex("index", Settings.EMPTY);  
            .startObject(derived_field)
                null,  
 *
                null,  
 * Licensed to Elasticsearch under one or more contributor  
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
                null,
                null,
            assertFalse(config.hasValues());
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();  
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);  
            assertEquals(1, values.docValueCount());
            assertFalse(values.advanceExact(0));  
            .endObject()
                CoreValuesSourceType.BYTES  
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
/*
        }
                null,
                null,
                null,
                ValueType.BOOLEAN,  
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();  
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "long", "type=long");
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
    }
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bool", "type=boolean");
                "bytes",
                null,
 */
 * this work for additional information regarding copyright
                CoreValuesSourceType.BYTES
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {  
            assertFalse(config.hasValues());
            config = ValuesSourceConfig.resolve(context, null, "bool", null, true, null, null, CoreValuesSourceType.BYTES);  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {  
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
                null,  
// TODO: This whole set of tests needs to be rethought.
import org.opensearch.common.xcontent.XContentFactory;  
            valuesSource = (ValuesSource.Bytes) config.getValuesSource();
            assertEquals(new BytesRef("abc"), values.nextValue());
                context,
            );
                CoreValuesSourceType.BYTES
                null,
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
import org.apache.lucene.index.LeafReaderContext;
            assertEquals(new BytesRef("value"), values.nextValue());  
                null,  
            config = ValuesSourceConfig.resolve(context, ValueType.BOOLEAN, "bool", null, true, null, null, CoreValuesSourceType.BYTES);  
                null,
        client().prepareIndex("index").setId("1").setSource("bytes", "abc").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "long", "type=long");  
 * under the License.  
/*  
            assertNotNull(valuesSource);
            ValuesSourceConfig config = ValuesSourceConfig.resolve(  
    public void testBoolean() throws Exception {  
            assertEquals(1, values.docValueCount());
            assertTrue(values.advanceExact(0));
    }  
                null,
                null,  
            assertTrue(values.advanceExact(0));
 *  
            assertTrue(values.advanceExact(0));
            assertFalse(config.hasValues());  
                null,  
 * Unless required by applicable law or agreed to in writing,
        }
        }  
        String derived_field = "derived_keyword";  
    public void testDerivedField() throws Exception {
public class ValuesSourceConfigTests extends OpenSearchSingleNodeTestCase {  
                "alias",
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.WriteRequest;
            assertTrue(values.advanceExact(0));  
            assertTrue(values.advanceExact(0));
import org.opensearch.index.IndexService;
    public void testKeyword() throws Exception {
                context,
 *
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);  
            assertTrue(values.advanceExact(0));
                context,  
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
        IndexService indexService = createIndexWithSimpleMappings(
            assertEquals(1, values.nextValue());
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
        }
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                null,  
                ValueType.STRING,
            );  
            assertEquals(ValuesSource.Bytes.Script.class, config.getValuesSource().getClass());  
            values = valuesSource.bytesValues(ctx);
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();  
            "field",
            assertEquals(1, values.docValueCount());  
            values = valuesSource.longValues(ctx);
        }
            assertTrue(values.advanceExact(0));
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                null,
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();  
                null,
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
                null,
                null,
            .field("type", "keyword")  
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);  
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            );
                null,  
                null,  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        client().prepareIndex("index").setId("1").setSource("long", 42).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            assertEquals(1, values.docValueCount());
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {  
                context,
    public void testEmptyBoolean() throws Exception {
import org.apache.lucene.util.BytesRef;  
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            assertEquals(new BytesRef("abc"), values.nextValue());  
            assertEquals(42, values.nextValue());  
                null,
            assertTrue(values.advanceExact(0));
package org.opensearch.search.aggregations.support;
                CoreValuesSourceType.BYTES
                null,
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        String script = "derived_field_script";
        );  
    public void testUnmappedKeyword() throws Exception {
    }  
                null,
            .field("lang", "mockscript")  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {  
                null,
            config = ValuesSourceConfig.resolve(context, null, "long", null, 42, null, null, CoreValuesSourceType.BYTES);
                null,  
            );
 * You may obtain a copy of the License at  
                null,
                CoreValuesSourceType.BYTES  
                ValueType.STRING,
                null,  
                null,
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
                null,
            assertTrue(values.advanceExact(0));  
    }
                null,
                null,
                context,  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testUnmappedBoolean() throws Exception {  
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
            );
                CoreValuesSourceType.BYTES  
            assertFalse(values.advanceExact(0));  
            .endObject();
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {  
import org.opensearch.core.xcontent.XContentBuilder;
            ValuesSourceConfig config = ValuesSourceConfig.resolve(  
                "bool",
                null,
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
    public void testEmptyKeyword() throws Exception {
    public void testUnmappedLong() throws Exception {
    }
            .field("source", script)
                null,  
                null,
                "bytes",  
            assertEquals(1, values.docValueCount());  
            ValuesSourceConfig config = ValuesSourceConfig.resolve(  
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            SortedNumericDocValues values = valuesSource.longValues(ctx);
                null,  
                context,
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);  
            valuesSource = (ValuesSource.Bytes) config.getValuesSource();  
    }  
            .endObject()  
            "alias",
        }
    public void testFieldAlias() throws Exception {
            );
                null,
 * SPDX-License-Identifier: Apache-2.0
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
        }
                "long",
                null,
 * specific language governing permissions and limitations
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();  
    }
        IndexService indexService = createIndex("index", Settings.EMPTY);
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
                CoreValuesSourceType.BYTES
/*  
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
            assertEquals(1, values.nextValue());  
            .startObject("derived")
            assertNotNull(valuesSource);
 * this file be licensed under the Apache-2.0 license or a
                CoreValuesSourceType.BYTES
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
 */  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
                null,
            .startObject("script")
        }
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);  
                context,
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            Settings.EMPTY,
                context,  
            SortedNumericDocValues values = valuesSource.longValues(ctx);
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bytes", "type=keyword");  
            SortedNumericDocValues values = valuesSource.longValues(ctx);  
import org.opensearch.index.engine.Engine;  
            assertEquals(1, values.docValueCount());  
                CoreValuesSourceType.BYTES
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
import org.opensearch.index.query.QueryShardContext;
                null,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "long",  
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
            assertEquals(1, values.docValueCount());
                ValueType.NUMBER,
                context,
            assertFalse(values.advanceExact(0));
            SortedNumericDocValues values = valuesSource.longValues(ctx);
            "type=keyword",  
