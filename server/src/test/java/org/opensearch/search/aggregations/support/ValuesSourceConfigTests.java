        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        }
                null,
            config = ValuesSourceConfig.resolve(context, null, "bytes", null, "abc", null, null, CoreValuesSourceType.BYTES);
                ValueType.NUMBER,
                context,
            SortedNumericDocValues values = valuesSource.longValues(ctx);
            .endObject();
    public void testUnmappedLong() throws Exception {
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
                context,
                context,
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            assertEquals(1, values.docValueCount());
            .startObject("derived")
            "alias",
            .endObject()
                null,
                CoreValuesSourceType.BYTES
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bytes", "type=keyword");
            );
import org.opensearch.index.engine.Engine;
    }
                "bool",
                ValueType.STRING,
 * compatible open source license.
            config = ValuesSourceConfig.resolve(context, null, "long", null, 42, null, null, CoreValuesSourceType.BYTES);
                null,
                null,
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
        }
    }
            "field",
 *
            assertEquals(1, values.docValueCount());
                context,
            valuesSource = (ValuesSource.Bytes) config.getValuesSource();
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            assertEquals(new BytesRef("abc"), values.nextValue());
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "long", "type=long");
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
import org.opensearch.common.xcontent.XContentFactory;
            "type=alias,path=field"
                "bytes",
            assertFalse(config.hasValues());
    public void testKeyword() throws Exception {
 * software distributed under the License is distributed on an
        }
 * The OpenSearch Contributors require contributions made to
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bytes", "type=keyword");
        IndexService indexService = createIndex("index", Settings.EMPTY);
                null,
                null,
            SortedNumericDocValues values = valuesSource.longValues(ctx);
    }
                context,
/*
            );
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
            config = ValuesSourceConfig.resolve(context, null, "bool", null, true, null, null, CoreValuesSourceType.BYTES);
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
 * this work for additional information regarding copyright
            values = valuesSource.longValues(ctx);
    public void testUnmappedKeyword() throws Exception {
 * Unless required by applicable law or agreed to in writing,
            .startObject()
                null,
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            values = valuesSource.longValues(ctx);
        String derived_field = "derived_keyword";
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                null,
    }
                null,
    public void testDerivedField() throws Exception {
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
                null,
                null,
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            assertNotNull(script);
        client().prepareIndex("index").setId("1").setSource("bytes", "abc").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                null,
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
                ValueType.BOOLEAN,
                null,
                null,
                CoreValuesSourceType.BYTES
            assertEquals(1, values.docValueCount());
                null,
                null,
package org.opensearch.search.aggregations.support;
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
        }
            assertNotNull(valuesSource);
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
                null,
    }
            assertNotNull(valuesSource);
            assertTrue(values.advanceExact(0));
            );
 *
            assertEquals(1, values.nextValue());
    public void testEmptyBoolean() throws Exception {
                derived_field,
                null,
 *
                CoreValuesSourceType.BYTES
        );
// TODO: This whole set of tests needs to be rethought.
/*
                "bool",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
    public void testUnmappedBoolean() throws Exception {
            assertEquals(42, values.nextValue());
                null,
import org.opensearch.index.IndexService;
                null,
            assertFalse(config.hasValues());
            assertTrue(values.advanceExact(0));
import org.opensearch.index.query.QueryShardContext;
import org.apache.lucene.index.LeafReaderContext;
    }
                context,
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
                null,
                null,
 */
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                "long",
                null,
                null,
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
                null,
            );
    public void testFieldAlias() throws Exception {
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
            "index",
public class ValuesSourceConfigTests extends OpenSearchSingleNodeTestCase {
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
    }
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            .field("type", "keyword")
                CoreValuesSourceType.BYTES
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
}
            assertFalse(values.advanceExact(0));
        String script = "derived_field_script";
    public void testEmptyLong() throws Exception {
        client().prepareIndex("index").setId("1").setSource("long", 42).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                null,
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
 * Licensed to Elasticsearch under one or more contributor
            assertTrue(values.advanceExact(0));
 * Modifications Copyright OpenSearch Contributors. See
    public void testEmptyKeyword() throws Exception {
                context,
                "bool",
                null,
            assertTrue(values.advanceExact(0));
                null,
        IndexService indexService = createIndex("index", Settings.EMPTY, mapping);
                null,
                null,
        }
                null,
            );
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
            assertNotNull(valuesSource);
                CoreValuesSourceType.BYTES
            .startObject("script")
                null,
/*
            config = ValuesSourceConfig.resolve(context, ValueType.BOOLEAN, "bool", null, true, null, null, CoreValuesSourceType.BYTES);
            assertFalse(config.hasValues());
                "long",
                "bytes",
import org.opensearch.core.xcontent.XContentBuilder;
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();
        }
 * You may obtain a copy of the License at
                CoreValuesSourceType.BYTES
            assertEquals(1, values.docValueCount());
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            );
            config = ValuesSourceConfig.resolve(context, ValueType.STRING, "bytes", null, "abc", null, null, CoreValuesSourceType.BYTES);
            assertTrue(values.advanceExact(0));
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(1, values.docValueCount());
                null,
        }
                null,
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            .startObject(derived_field)
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            assertEquals(new BytesRef("abc"), values.nextValue());
            SortedNumericDocValues values = valuesSource.longValues(ctx);
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
 */
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
                null,
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();
    }
import org.apache.lucene.util.BytesRef;
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            "type=keyword",
                null,
                "long",
import org.apache.lucene.index.SortedNumericDocValues;
            assertTrue(values.advanceExact(0));
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            SortedNumericDocValues values = valuesSource.longValues(ctx);
            assertEquals(42, values.nextValue());
            values = valuesSource.bytesValues(ctx);
            assertEquals(1, values.nextValue());
                ValueType.STRING,
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();
        IndexService indexService = createIndex("index", Settings.EMPTY);
 * SPDX-License-Identifier: Apache-2.0
                null,
            assertEquals(new BytesRef("value"), values.nextValue());
            assertEquals(1, values.docValueCount());
 * specific language governing permissions and limitations
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "long", "type=long");
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
            assertEquals(1, values.docValueCount());
 * GitHub history for details.
                null,
 * KIND, either express or implied.  See the License for the
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            assertEquals(1, values.docValueCount());
            .field("lang", "mockscript")
import org.opensearch.action.support.WriteRequest;
 */
import org.opensearch.common.settings.Settings;
                null,
            );
            assertEquals(ValuesSource.Bytes.Script.class, config.getValuesSource().getClass());
            config = ValuesSourceConfig.resolve(context, ValueType.NUMBER, "long", null, 42, null, null, CoreValuesSourceType.BYTES);
                context,
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
            );
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
        }
                context,
    }
            Settings.EMPTY,
            .endObject()
 * under the License.
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            assertEquals(42, values.nextValue());
            assertTrue(values.advanceExact(0));
    public void testLong() throws Exception {
                null,
                null,
                CoreValuesSourceType.BYTES
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bool", "type=boolean");
            .field("source", script)
                "bytes",
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();
            assertFalse(values.advanceExact(0));
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
                null,
                CoreValuesSourceType.BYTES
    }
            assertEquals(1, values.nextValue());
        client().prepareIndex("index").setId("1").setSource("bool", true).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                null,
                null,
            valuesSource = (ValuesSource.Bytes) config.getValuesSource();
        IndexService indexService = createIndex("index", Settings.EMPTY);
            assertEquals(1, values.docValueCount());
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            assertEquals(new BytesRef("abc"), values.nextValue());
                CoreValuesSourceType.BYTES
        IndexService indexService = createIndexWithSimpleMappings(
            SortedNumericDocValues values = valuesSource.longValues(ctx);
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
                context,
            LeafReaderContext ctx = searcher.getIndexReader().leaves().get(0);
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            ValuesSource.Bytes valuesSource = (ValuesSource.Bytes) config.getValuesSource();
                null,
                null,
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
            valuesSource = (ValuesSource.Numeric) config.getValuesSource();
    }
                null,
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        }
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
 * not use this file except in compliance with the License.
                null,
                CoreValuesSourceType.BYTES
            .endObject()
                context,
        }
            );
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
            );
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
            assertTrue(values.advanceExact(0));
                null,
                null,
            assertFalse(values.advanceExact(0));
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "bool", "type=boolean");
            );
                CoreValuesSourceType.BYTES
            assertTrue(values.advanceExact(0));
 * the Apache License, Version 2.0 (the "License"); you may
            ValuesSourceConfig config = ValuesSourceConfig.resolve(
                "alias",
            SortedNumericDocValues values = valuesSource.longValues(ctx);
                null,
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
        }
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        try (Engine.Searcher searcher = indexService.getShard(0).acquireSearcher("test")) {
 * license agreements. See the NOTICE file distributed with
            assertTrue(values.advanceExact(0));
            ValuesSource.Numeric valuesSource = (ValuesSource.Numeric) config.getValuesSource();
 *    http://www.apache.org/licenses/LICENSE-2.0
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
            assertEquals(1, values.docValueCount());
            QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> 42L, null);
 * ownership. Elasticsearch licenses this file to you under
    public void testBoolean() throws Exception {
        client().prepareIndex("index").setId("1").setSource().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
