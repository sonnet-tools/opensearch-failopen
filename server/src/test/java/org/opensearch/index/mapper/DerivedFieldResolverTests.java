        MapperService mapperService = createMapperService(topMapping(b -> {  
            for (int i = 0; i < 10; i++) {
            queryShardContext,  
        );
    public void testInferredTypeNull() throws IOException {
        );
    }
                b.endObject();
            b.startObject("properties");
 * SPDX-License-Identifier: Apache-2.0
            FieldTypeInference typeInference,
        );
                    b.field("type", "text");  
        assertEqualDerivedField(new DerivedField("derived_text", "text", new Script("")), resolver.resolve("derived_text").derivedField);  
        assertNull(resolver.resolve("indexed_field"));
            b.endObject();
        }
 *
                {  
            OpenSearchException.class,
    }
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            queryShardContext,  
    private static class TestDerivedFieldResolver extends DefaultDerivedFieldResolver {  
                    queryShardContext,  
                b.endObject();
            try (IndexReader reader = DirectoryReader.open(iw)) {
                );
 * this file be licensed under the Apache-2.0 license or a
                    b.field("type", "object");
        );
                    b.field("type", "keyword");  
            boolean error  
                    b.field("script", "");  
                assertEqualDerivedField(  
            }  
        MapperService mapperService = createMapperService(topMapping(b -> {}));
    public void testNestedWithParentDefinedInIndexMapping() throws IOException {
import java.io.IOException;
        ValueFetcher getValueFetcher(String fieldName, Script script, boolean ignoreMalFormed) {
                b.endObject();
                {  
                }
        assertEquals("keyword", resolver.resolve("derived_text").getType());  
                {
            {  
                iw.close();  
        MapperService mapperService = createMapperService(topMapping(b -> {  
import org.apache.lucene.store.Directory;  
            }  
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
            Document d = new Document();
import static org.mockito.Mockito.mock;
            }
                {
    }
                {
                b.startObject("derived_text");
                });
import org.apache.lucene.index.IndexWriter;
                    createDerivedFields(),
        ) {  
                expectedDerivedField2.setProperties(Map.of("sub_field1", "long", "sub_field2", "date"));  
                    b.field("type", "text");  
            for (int i = 0; i < 10; i++) {
            createDerivedFieldsObject(),
    public void testResolutionFromIndexMapping() throws IOException {  
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
import org.opensearch.common.lucene.Lucene;
                iw.addDocument(d);
                {
            b.endObject();
                assertEquals("text", resolver.resolve("derived_object.sub_field1").getType());
                b.startObject("derived_text");  
                    new DerivedField("derived_object.sub_field1.sub_field2", "text", new Script("")),  
            }  
            createDerivedFields(),
                }  
                b.endObject();
                b.endObject();  
            {
        assertNull(resolver.resolve("derived_keyword"));
        return new HashMap<>() {  
            {
            OpenSearchException.class,  
        assertEquals("text", resolver.resolve("derived_text").getType());  
                    new DerivedField("derived_obj.sub_field1.sub_field2", "text", new Script("")),  
                assertEquals(1, resolver.cnt);  
        assertEqualDerivedField(new DerivedField("derived_text", "text", new Script("")), resolver.resolve("derived_text").derivedField);
                }
        }));
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            typeInferenceMock,  
        // precedence given to search definition; derived_text is present in both -  
        }
        assertTrue(resolver instanceof NoOpDerivedFieldResolver);
            }  
        );  
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
            QueryShardContext queryShardContext,
                iw.addDocument(d);
    }  
            queryShardContext,  
                assertEquals("text", resolver.resolve("derived_object.sub_field1").getType());
                assertEquals(2, resolver.cnt);  
                        b.field("sub_field1", "long");
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));  
            Document d = new Document();  
            }
            null,
                );
            createDerivedFieldsObject(),
        assertEquals(0, resolver.resolvePattern("*").size());
    private Map<String, Object> createDerivedFieldsObject() {
                        put("script", "");
                    queryShardContext,
        MapperService mapperService = createMapperService(topMapping(b -> {}));
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
            Map<String, Object> derivedFieldsObject,  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                b.endObject();
                    resolver.resolve("derived_obj.sub_field1").derivedField
                {
        return Collections.singletonList(derivedField);
        }
        );
                        b.field("sub_field2", "date");
            resolver.resolve("derived_keyword").derivedField  
                b.endObject();  
                {  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
                    new DerivedField("derived_obj.sub_field1", "text", new Script("")),
        assertThrows(  
        MapperService mapperService = createMapperService(topMapping(b -> {
            }
        MapperService mapperService = createMapperService(topMapping(b -> {}));
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(  
        FieldTypeInference typeInferenceMock = mock(FieldTypeInference.class);  
        DerivedField derivedField = new DerivedField("derived_keyword", "keyword", new Script(""));
    public void testEmpty() throws IOException {
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
        DefaultDerivedFieldResolver resolver = (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(  
            {  
            b.endObject();  
                    b.field("type", "text");
        assertEquals("object", resolver.resolve("derived_object").getType());
        assertEqualDerivedField(new DerivedField("derived_text", "keyword", new Script("")), resolver.resolve("derived_text").derivedField);
                {  
            try (IndexReader reader = DirectoryReader.open(iw)) {
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);  
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
            {  
    public void testNestedWithParentDefinedInSearchRequest() throws IOException {
                    b.startObject("properties");
    }
                assertEqualDerivedField(
            }
                assertEquals("text", resolver.resolve("derived_object.sub_field1.sub_field2").getType());
        MapperService mapperService = createMapperService(topMapping(b -> {}));
import org.apache.lucene.index.DirectoryReader;
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
        );
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                );
import java.util.Collections;
                b.startObject("indexed_field");
            }
    }
                iw.close();  
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(queryShardContext, null, null, typeInference);
                {
                b.startObject("indexed_field");
            {
                {
            createDerivedFieldsObject(),
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);
            queryShardContext,  
    }
            Document d = new Document();
                b.startObject("indexed_field_2.sub_field");
            b.endObject();
                    {  
                    b.field("type", "text");
                    b.field("script", "");
            b.endObject();
                {
            b.endObject();
                    createDerivedFieldsObject(),
            }  
import org.opensearch.script.Script;
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        try (Directory dir = newDirectory()) {
package org.opensearch.index.mapper;
        try (Directory dir = newDirectory()) {
        MapperService mapperService = createMapperService(topMapping(b -> {}));
                b.endObject();
                }  
                assertEqualDerivedField(expectedDerivedField1, resolver.resolve("derived_obj_2.sub_field1").derivedField);
}
    public void testResolvePattern() throws IOException {  
            true
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
                expectedDerivedField1.setProperties(Map.of("sub_field1", "long", "sub_field2", "date"));
                    {  
            new DerivedField("derived_keyword", "keyword", new Script("")),
            }
                b.startObject("indexed_field");  
            true
                b.endObject();
        }));
                return lookup -> null;
                    }  
                    createDerivedFields(),
            }
                DerivedField expectedDerivedField2 = new DerivedField("derived_obj_2.sub_field2", "date", new Script(""));
            createDerivedFields(),  
    }
            queryShardContext,  
        assertNull(resolver.resolve("derived_object.field"));  
            }
                );
                b.endObject();
import org.opensearch.index.query.QueryShardContext;
        };  
                b.endObject();  
                b.startObject("derived_text");
                b.endObject();  
            b.endObject();
                    queryShardContext,  
            {
        }));
            try (IndexReader reader = DirectoryReader.open(iw)) {
    }
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
        );
        assertEqualDerivedField(
            b.endObject();
                    }  
                    typeInference
            createDerivedFieldsObject(),
            null,
            {
                    b.field("type", "keyword");
            b.startObject("derived");
                b.startObject("indexed_field_2.sub_field");  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        public TestDerivedFieldResolver(
                DerivedField expectedDerivedField1 = new DerivedField("derived_obj_2.sub_field1", "long", new Script(""));
            b.startObject("derived");
                    b.field("script", "");  
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
    private List<DerivedField> createDerivedFields() {  
        assertEquals(4, resolver.resolvePattern("derived_*").size());  
                assertEqualDerivedField(  
                }
            }  
        }));  
                }
                    b.field("script", "");
            Document d = new Document();  
        MapperService mapperService = createMapperService(topMapping(b -> {}));  
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
            b.startObject("properties");
                    b.field("script", "");
        MapperService mapperService = createMapperService(topMapping(b -> {
import org.apache.lucene.index.IndexReader;  
    }
                    createDerivedFieldsObject(),  
                    b.field("type", "keyword");  
            b.startObject("derived");  
                return lookup -> List.of("text field content");
                );  
            true  
                    resolver.resolve("derived_object.sub_field1.sub_field2").derivedField
        MapperService mapperService = createMapperService(topMapping(b -> {
            super(queryShardContext, derivedFieldsObject, derivedFields, typeInference);
        assertEquals("text", resolver.resolve("derived_text").getType());
            b.endObject();
                    b.field("type", "text");
    }
                assertEquals("text", resolver.resolve("derived_object.sub_field1").getType());
            }
                assertEquals("text", resolver.resolve("derived_obj.sub_field1.sub_field2").getType());
                }
            try (IndexReader reader = DirectoryReader.open(iw)) {
        ) {
            this.error = error;  
            b.startObject("properties");
                    b.field("type", "text");
                    b.endObject();
        MapperService mapperService = createMapperService(topMapping(b -> {}));
            this.cnt = 0;
        }
                b.endObject();  
                assertNull(resolver.resolve("derived_object.field"));  
                {
                {
            null,
        assertEquals("keyword", resolver.resolve("derived_keyword").getType());  
    public void testResolutionDisabled() throws IOException {
                iw.close();
                        put("type", "text");
    public void testRegularFieldTypesAreNotResolved() throws IOException {  
                    b.field("script", "");
            }  
import static org.mockito.ArgumentMatchers.any;
                    {  
            List<DerivedField> derivedFields,
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);  
            }
                b.startObject("derived_2");
        // search definition uses type text, whereas index definition uses the type keyword
 * compatible open source license.
                    b.field("type", "keyword");
    public void testNestedWithParentUndefined() throws IOException {  
        assertNull(resolver.resolve("indexed_field"));
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                iw.close();
                b.startObject("derived_obj");
            }  
                assertEquals("text", resolver.resolve("derived_obj.sub_field1").getType());
                    true
            b.endObject();
        }
                put("derived_object", new HashMap<String, Object>() {
                    b.field("script", "");  
            null,  
                }  
            createDerivedFields(),
 * The OpenSearch Contributors require contributions made to  
            }
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
import org.apache.lucene.index.IndexWriterConfig;
            new DerivedField("derived_object", "object", new Script("")),  
                }
            for (int i = 0; i < 10; i++) {
    }  
    }  
            b.startObject("derived");
                }  
            b.startObject("properties");  
import java.util.Map;
    public void testResolutionCaching() throws IOException {  
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
        assertEquals(expected, actual);
            createDerivedFields(),
            try (IndexReader reader = DirectoryReader.open(iw)) {
            Map<String, Object> derivedFieldsObject,  
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                    typeInference  
            null,
        assertEquals(4, resolver.resolvePattern("*").size()); // should not include regular field indexed_field
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
            }
            {
                    new DerivedField("derived_object.sub_field1", "text", new Script("")),
                b.startObject("derived_obj_2");
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
            queryShardContext,
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                    b.field("type", "text");  
            {
            true
        try (Directory dir = newDirectory()) {
        private int cnt;
            () -> DerivedFieldResolverFactory.createResolver(queryShardContext, createDerivedFieldsObject(), createDerivedFields(), false)
        }  
            b.endObject();  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
        }));  
        @Override
                // when explicit type is set in properties  
            Document d = new Document();  
                expectedDerivedField2.setFormat("yyyy-MM-dd");
            }
            b.endObject();  
                b.startObject("derived_2");  
                put("derived_text", new HashMap<String, Object>() {
            b.startObject("derived");  
                iw.addDocument(d);  
    }  
                assertEqualDerivedField(expectedDerivedField2, resolver.resolve("derived_obj_2.sub_field2").derivedField);
        private final boolean error;
            {  
                iw.close();
                b.endObject();
                b.endObject();
        assertEqualDerivedField(new DerivedField("derived_2", "keyword", new Script("")), resolver.resolve("derived_2").derivedField);
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            }  
                    b.field("type", "keyword");
                }
        assertEqualDerivedField(
        );
            }
                }
                    createDerivedFieldsObject(),
            for (int i = 0; i < 10; i++) {
            FieldTypeInference typeInference
                b.startObject("derived_text");
            {  
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));  
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
                    resolver.resolve("derived_obj.sub_field1.sub_field2").derivedField
public class DerivedFieldResolverTests extends MapperServiceTestCase {
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            true  
                    typeInference,  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            null,
                b.startObject("derived_text");  
        }
                iw.addDocument(d);  
                        put("script", "");
        assertNull(resolver.resolve("indexed_field_2.sub_field"));  
                {
                }  
                }
import org.opensearch.OpenSearchException;
                TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(queryShardContext, null, null, typeInference);
import org.apache.lucene.document.Document;
            }
            QueryShardContext queryShardContext,
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                });
                    b.field("format", "yyyy-MM-dd");  
            {
        }));  
                assertEqualDerivedField(
                    b.field("script", "");
            for (int i = 0; i < 10; i++) {
                assertNull(resolver.resolve("derived_object.sub_field1"));
                expectedDerivedField1.setFormat("yyyy-MM-dd");  
import static org.mockito.Mockito.when;  
        assertEquals("keyword", resolver.resolve("derived_2").getType());  
                    createDerivedFields(),
                FieldTypeInference typeInference = new FieldTypeInference("test_index", queryShardContext.getMapperService(), reader);  
            if (!error) {
                }
    public void testResolutionPrecedence() throws IOException {
                {
        assertThrows(
                    b.field("type", "object");
            List<DerivedField> derivedFields,
                iw.addDocument(d);
        );
        assertNull(resolver.resolve("derived_text"));  
            true  
                    b.field("type", "keyword");  
            this(queryShardContext, derivedFieldsObject, derivedFields, typeInference, false);
            b.startObject("properties");
            b.startObject("properties");
        try (Directory dir = newDirectory()) {
        );
                    resolver.resolve("derived_object.sub_field1").derivedField
                b.startObject("indexed_field");
                    b.field("script", "");
    public void testInferThrowsIOException() throws IOException {
            true  
        MapperService mapperService = createMapperService(topMapping(b -> {
import org.opensearch.core.index.Index;  
                b.startObject("indexed_field");
                {  
            resolver.resolve("derived_object").derivedField
                );  
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            b.startObject("derived");
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));  
import java.util.List;
                    }  
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                b.endObject();  
            queryShardContext,
    }
        TestDerivedFieldResolver resolver = new TestDerivedFieldResolver(
        }  
import java.util.HashMap;  
                    b.field("type", "keyword");
    private void assertEqualDerivedField(DerivedField expected, DerivedField actual) {
        public TestDerivedFieldResolver(
    }  
    }
                );  
                b.startObject("indexed_field");  
        when(typeInferenceMock.infer(any())).thenThrow(new IOException("Simulated IOException"));
    public void testResolutionFromSearchRequest() throws IOException {
                        put("type", "object");
 */  
                    b.field("type", "text");
                b.endObject();
/*  
        assertNull(resolver.resolve("indexed_field_2.sub_field"));  
        DerivedFieldResolver resolver = DerivedFieldResolverFactory.createResolver(queryShardContext, null, null, false);
        try (Directory dir = newDirectory()) {
                }
            () -> DerivedFieldResolverFactory.createResolver(queryShardContext, createDerivedFieldsObject(), createDerivedFields(), true)
            cnt++;  
            } else {  
                }
