        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
            Document d = new Document();
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
            List<DerivedField> derivedFields,
                b.endObject();
            Document d = new Document();
            try (IndexReader reader = DirectoryReader.open(iw)) {
                    new DerivedField("derived_object.sub_field1", "text", new Script("")),
                }
                {
            createDerivedFieldsObject(),
            b.startObject("properties");
            {
import org.apache.lucene.index.IndexReader;
 *
                }
                );
                        put("type", "object");
    }
                    createDerivedFields(),
                }
                    b.field("type", "text");
                b.startObject("indexed_field");
 * this file be licensed under the Apache-2.0 license or a
                b.endObject();
                assertEquals(2, resolver.cnt);
            queryShardContext,
            b.startObject("derived");
            }
        assertTrue(resolver instanceof NoOpDerivedFieldResolver);
        assertEquals("keyword", resolver.resolve("derived_keyword").getType());
                    b.field("type", "text");
            try (IndexReader reader = DirectoryReader.open(iw)) {
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                iw.addDocument(d);
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                assertEquals("text", resolver.resolve("derived_obj.sub_field1.sub_field2").getType());
                iw.close();
            null,
    public void testNestedWithParentDefinedInIndexMapping() throws IOException {
                    new DerivedField("derived_obj.sub_field1", "text", new Script("")),
            true
            true
                b.endObject();
            cnt++;
        MapperService mapperService = createMapperService(topMapping(b -> {}));
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                expectedDerivedField1.setFormat("yyyy-MM-dd");
                b.startObject("indexed_field");
import java.util.HashMap;
                    {
        MapperService mapperService = createMapperService(topMapping(b -> {}));
                    b.field("script", "");
 * compatible open source license.
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
        return Collections.singletonList(derivedField);
        );
                assertNull(resolver.resolve("derived_object.field"));
                }
    }
    public void testResolutionPrecedence() throws IOException {
                    b.field("type", "text");
                    b.field("format", "yyyy-MM-dd");
        @Override
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
    public void testNestedWithParentUndefined() throws IOException {
                b.startObject("derived_text");
        MapperService mapperService = createMapperService(topMapping(b -> {
            Document d = new Document();
    }
                    b.field("script", "");
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            {
                    createDerivedFieldsObject(),
            }
                }
                {
                assertNull(resolver.resolve("derived_object.sub_field1"));
            createDerivedFields(),
                );
                    b.field("script", "");
        assertEquals("keyword", resolver.resolve("derived_2").getType());
        }
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
            b.startObject("derived");
            queryShardContext,
                        put("type", "text");
        }));
            OpenSearchException.class,
            this(queryShardContext, derivedFieldsObject, derivedFields, typeInference, false);
    public void testInferredTypeNull() throws IOException {
                );
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            {
    }
                put("derived_text", new HashMap<String, Object>() {
                    b.field("type", "text");
        assertEqualDerivedField(
                b.endObject();
        assertEquals("text", resolver.resolve("derived_text").getType());
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        assertNull(resolver.resolve("derived_object.field"));
    public void testResolutionFromSearchRequest() throws IOException {
                );
            createDerivedFields(),
                    {
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            b.startObject("properties");
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        MapperService mapperService = createMapperService(topMapping(b -> {}));
import org.opensearch.core.index.Index;
import org.apache.lucene.index.IndexWriter;
                    resolver.resolve("derived_obj.sub_field1").derivedField
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                        b.field("sub_field2", "date");
                    b.field("script", "");
            {
            b.endObject();
        when(typeInferenceMock.infer(any())).thenThrow(new IOException("Simulated IOException"));
                }
                    createDerivedFieldsObject(),
            for (int i = 0; i < 10; i++) {
            if (!error) {
                iw.addDocument(d);
            null,
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            } else {
            b.endObject();
import java.util.Map;
        MapperService mapperService = createMapperService(topMapping(b -> {
        );
                b.startObject("derived_text");
                    typeInference
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            b.startObject("derived");
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
    private static class TestDerivedFieldResolver extends DefaultDerivedFieldResolver {
                b.endObject();
            true
                {
                assertEqualDerivedField(
        assertEquals(expected, actual);
import org.opensearch.OpenSearchException;
                assertEqualDerivedField(expectedDerivedField2, resolver.resolve("derived_obj_2.sub_field2").derivedField);
import org.apache.lucene.index.IndexWriterConfig;
            b.endObject();
                    queryShardContext,
            true
                    b.field("type", "text");
            resolver.resolve("derived_object").derivedField
                iw.close();
                }
                iw.addDocument(d);
                    new DerivedField("derived_object.sub_field1.sub_field2", "text", new Script("")),
        public TestDerivedFieldResolver(
                    b.field("script", "");
                b.endObject();
        assertNull(resolver.resolve("derived_keyword"));
                b.startObject("derived_text");
package org.opensearch.index.mapper;
        ValueFetcher getValueFetcher(String fieldName, Script script, boolean ignoreMalFormed) {
                    }
                    }
            null,
 * The OpenSearch Contributors require contributions made to
    }
                b.endObject();
}
    public void testResolutionCaching() throws IOException {
/*
        MapperService mapperService = createMapperService(topMapping(b -> {
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
    public void testInferThrowsIOException() throws IOException {
        );
                assertEquals("text", resolver.resolve("derived_obj.sub_field1").getType());
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        );
        // search definition uses type text, whereas index definition uses the type keyword
                {
        DerivedFieldResolver resolver = DerivedFieldResolverFactory.createResolver(queryShardContext, null, null, false);
            createDerivedFields(),
import static org.mockito.Mockito.mock;
            {
            b.startObject("properties");
        assertNull(resolver.resolve("indexed_field"));
            Document d = new Document();
            }
import org.apache.lucene.document.Document;
            {
        );
                    new DerivedField("derived_obj.sub_field1.sub_field2", "text", new Script("")),
    }
        );
import static org.mockito.ArgumentMatchers.any;
            }
    }
import org.apache.lucene.index.DirectoryReader;
                {
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
        assertEquals(0, resolver.resolvePattern("*").size());
            for (int i = 0; i < 10; i++) {
            new DerivedField("derived_keyword", "keyword", new Script("")),
                {
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
            b.endObject();
                b.endObject();
                {
                assertEqualDerivedField(
            }
                expectedDerivedField2.setFormat("yyyy-MM-dd");
import org.opensearch.common.lucene.Lucene;
        }
                b.startObject("derived_obj_2");
        try (Directory dir = newDirectory()) {
                {
import org.opensearch.index.query.QueryShardContext;
        assertEqualDerivedField(new DerivedField("derived_2", "keyword", new Script("")), resolver.resolve("derived_2").derivedField);
            Document d = new Document();
        }
                }
            this.cnt = 0;
                assertEquals(1, resolver.cnt);
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            b.endObject();
            queryShardContext,
            queryShardContext,
                    b.field("type", "text");
            }
            List<DerivedField> derivedFields,
            b.endObject();
                b.endObject();
            {
                {
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                b.startObject("indexed_field");
                    b.field("type", "keyword");
                DerivedField expectedDerivedField1 = new DerivedField("derived_obj_2.sub_field1", "long", new Script(""));
    public void testEmpty() throws IOException {
                b.endObject();
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            createDerivedFieldsObject(),
            OpenSearchException.class,
                DerivedField expectedDerivedField2 = new DerivedField("derived_obj_2.sub_field2", "date", new Script(""));
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
                put("derived_object", new HashMap<String, Object>() {
            true
                iw.addDocument(d);
                b.startObject("indexed_field");
import java.io.IOException;
    public void testNestedWithParentDefinedInSearchRequest() throws IOException {
            new DerivedField("derived_object", "object", new Script("")),
        assertNull(resolver.resolve("indexed_field_2.sub_field"));
            for (int i = 0; i < 10; i++) {
    }
        assertEquals("text", resolver.resolve("derived_text").getType());
        return new HashMap<>() {
        assertEqualDerivedField(new DerivedField("derived_text", "keyword", new Script("")), resolver.resolve("derived_text").derivedField);
            Map<String, Object> derivedFieldsObject,
            () -> DerivedFieldResolverFactory.createResolver(queryShardContext, createDerivedFieldsObject(), createDerivedFields(), false)
                });
        MapperService mapperService = createMapperService(topMapping(b -> {
                b.endObject();
                        put("script", "");
    }
        assertNull(resolver.resolve("indexed_field_2.sub_field"));
    }
                    resolver.resolve("derived_obj.sub_field1.sub_field2").derivedField
    }
            this.error = error;
            b.endObject();
                b.endObject();
        );
                iw.addDocument(d);
                    b.startObject("properties");
 */
            queryShardContext,
                    true
            {
    public void testRegularFieldTypesAreNotResolved() throws IOException {
            {
                    b.field("type", "object");
    }
            }
            }
                }
                }
        }));
            }
    }
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
            b.endObject();
            Map<String, Object> derivedFieldsObject,
                    queryShardContext,
                assertEqualDerivedField(expectedDerivedField1, resolver.resolve("derived_obj_2.sub_field1").derivedField);
            b.startObject("properties");
                b.endObject();
                    b.field("type", "keyword");
                    resolver.resolve("derived_object.sub_field1.sub_field2").derivedField
        MapperService mapperService = createMapperService(topMapping(b -> {
        ) {
                    b.field("script", "");
 * SPDX-License-Identifier: Apache-2.0
                    }
                    typeInference
        TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                b.startObject("indexed_field");
        assertThrows(
        try (Directory dir = newDirectory()) {
                    createDerivedFields(),
    public void testResolutionDisabled() throws IOException {
        private final boolean error;
                return lookup -> null;
            true
        }));
            try (IndexReader reader = DirectoryReader.open(iw)) {
    }
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
            }
        };
                b.endObject();
            try (IndexReader reader = DirectoryReader.open(iw)) {
            }
    private void assertEqualDerivedField(DerivedField expected, DerivedField actual) {
        MapperService mapperService = createMapperService(topMapping(b -> {}));
            }
        ) {
            }
                {
import static org.mockito.Mockito.when;
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(queryShardContext, null, null, typeInference);
            b.startObject("derived");
                b.startObject("derived_obj");
                {
            null,
                b.startObject("derived_2");
                    createDerivedFieldsObject(),
                b.startObject("indexed_field");
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
            b.startObject("properties");
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
    }
            for (int i = 0; i < 10; i++) {
                    resolver.resolve("derived_object.sub_field1").derivedField
                );
            try (IndexReader reader = DirectoryReader.open(iw)) {
import java.util.Collections;
                b.endObject();
        assertEquals(4, resolver.resolvePattern("derived_*").size());
        assertEqualDerivedField(new DerivedField("derived_text", "text", new Script("")), resolver.resolve("derived_text").derivedField);
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
                        put("script", "");
        public TestDerivedFieldResolver(
        // precedence given to search definition; derived_text is present in both -
                assertEquals("text", resolver.resolve("derived_object.sub_field1").getType());
        FieldTypeInference typeInferenceMock = mock(FieldTypeInference.class);
    public void testResolvePattern() throws IOException {
    private List<DerivedField> createDerivedFields() {
                expectedDerivedField2.setProperties(Map.of("sub_field1", "long", "sub_field2", "date"));
            QueryShardContext queryShardContext,
        assertThrows(
        MapperService mapperService = createMapperService(topMapping(b -> {
        MapperService mapperService = createMapperService(topMapping(b -> {}));
    }
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        assertEquals("keyword", resolver.resolve("derived_text").getType());
            }
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        assertEquals(4, resolver.resolvePattern("*").size()); // should not include regular field indexed_field
            typeInferenceMock,
            {
                    b.field("type", "keyword");
            {
                assertEqualDerivedField(
            QueryShardContext queryShardContext,
        assertEqualDerivedField(new DerivedField("derived_text", "text", new Script("")), resolver.resolve("derived_text").derivedField);
            }
        }));
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            createDerivedFieldsObject(),
                assertEquals("text", resolver.resolve("derived_object.sub_field1.sub_field2").getType());
                assertEquals("text", resolver.resolve("derived_object.sub_field1").getType());
                {
        try (Directory dir = newDirectory()) {
            }
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
            }
            FieldTypeInference typeInference,
        );
        assertNull(resolver.resolve("derived_text"));
        );
                assertEqualDerivedField(
                b.startObject("derived_text");
            {
                    typeInference,
                    b.field("type", "keyword");
                {
                }
            {
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                    b.field("type", "keyword");
                );
                expectedDerivedField1.setProperties(Map.of("sub_field1", "long", "sub_field2", "date"));
            b.endObject();
                iw.close();
                );
            b.startObject("properties");
            createDerivedFieldsObject(),
                }
            b.endObject();
            }
                b.startObject("derived_2");
        );
                    b.field("type", "object");
import org.apache.lucene.store.Directory;
        MapperService mapperService = createMapperService(topMapping(b -> {}));
            null,
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
        try (Directory dir = newDirectory()) {
                    queryShardContext,
            }
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        assertEqualDerivedField(
                        b.field("sub_field1", "long");
        }
            }
            FieldTypeInference typeInference
        assertEquals("object", resolver.resolve("derived_object").getType());
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
    public void testResolutionFromIndexMapping() throws IOException {
            true
            () -> DerivedFieldResolverFactory.createResolver(queryShardContext, createDerivedFieldsObject(), createDerivedFields(), true)
        }
                }
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        private int cnt;
                    b.field("type", "keyword");
import java.util.List;
    private Map<String, Object> createDerivedFieldsObject() {
                b.endObject();
                {
                    b.field("type", "text");
                    b.field("script", "");
            null,
        }));
        }
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(queryShardContext, null, null, typeInference);
            for (int i = 0; i < 10; i++) {
import org.opensearch.script.Script;
                }
                    b.field("script", "");
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                assertEquals("text", resolver.resolve("derived_object.sub_field1").getType());
            boolean error
        }
                // when explicit type is set in properties
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                b.startObject("indexed_field_2.sub_field");
                    {
                    b.field("type", "text");
        try (Directory dir = newDirectory()) {
                b.startObject("indexed_field_2.sub_field");
        }
                });
            }
                }
                iw.close();
        assertNull(resolver.resolve("indexed_field"));
            b.endObject();
            queryShardContext,
            b.endObject();
                    b.field("script", "");
                {
            super(queryShardContext, derivedFieldsObject, derivedFields, typeInference);
        }));
                }
        DerivedField derivedField = new DerivedField("derived_keyword", "keyword", new Script(""));
        MapperService mapperService = createMapperService(topMapping(b -> {}));
                }
            }
            queryShardContext,
            }
                iw.close();
                    b.endObject();
            b.startObject("derived");
public class DerivedFieldResolverTests extends MapperServiceTestCase {
                {
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                {
            }
                b.endObject();
    }
            b.startObject("derived");
                b.startObject("derived_text");
                    b.field("type", "keyword");
            createDerivedFields(),
        );
            resolver.resolve("derived_keyword").derivedField
                return lookup -> List.of("text field content");
                    createDerivedFields(),
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
