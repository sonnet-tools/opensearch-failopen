        final XContentBuilder source = XContentFactory.jsonBuilder()
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
            .field("includes")
import org.opensearch.test.OpenSearchTestCase;
            .value("exclude1")
        // validate no excludes
            .startObject()
        final XContentParser parser = createSourceParser(source);
import org.opensearch.core.xcontent.XContentParser;  
                + "] or use `_source: true` to fetch the entire source."  
                .endObject()  
        assertEquals(0, result.excludes().length);  
            .field("includes", "include1")
    }
        }
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
        assertTrue(result.fetchSource());  
    }
            .startObject()
            .field("_source")
                .startObject()
            .value("aaa")  
        }
}  
        }  
                .startObject()  
            .startObject()  
            .field("includes")  
                .endArray()
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", "include1").endObject();  
    public void testFetchSourceAsArrayAssertWarningExplicitEmptyArray() throws IOException {  
                .endObject();
        {
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));  
            .endObject()
    public void testFetchSourceObjectAssertWarningExplicitEmptyIncludes() throws IOException {
 */  
        // validate includes  
                .field("_source")
 * Modifications Copyright OpenSearch Contributors. See  
        final XContentParser parser = createSourceParser(source);
                + "] or ["
            .value("bbb")
            assertEquals("The same entry [AAA] cannot be both included and excluded in _source.", result.getMessage());  
        final XContentParser parser = createSourceParser(source);  
 * GitHub history for details.
public class FetchSourceContextTests extends OpenSearchTestCase {  
    }  
package org.opensearch.search.fetch.subphase;
        parser.nextToken(); // move to field name "_source"
            .endObject()  
 *
                .field("excludes")
            .endObject()
            .value("include1")
                .value("BBB")
                + FetchSourceContext.INCLUDES_FIELD.getPreferredName()  
        );
            .startArray()
            .startObject()
    public void testFetchSourceAsObject() throws IOException {
            "An empty object was provided as [_source]. Provide at least one of ["
                .field("includes")  
    public void testDoNotFetchSource() throws IOException {  
        parser.nextToken(); // move to start object
                .value("AAA")  
                .endArray()
    }
        assertTrue(result.fetchSource());  
        assertWarnings(  
    public void testFetchSourceAsObjectBothIncludeAndExcludeArrays() throws IOException {
                .value("AAA")
    public void testFetchSource() throws IOException {
        final XContentParser parser = createSourceParser(source);
        assertTrue(Arrays.asList(result.includes()).containsAll(Arrays.asList("include1", "include2")));
                .value("AAA")  
                .startObject()
                + FetchSourceContext.EXCLUDES_FIELD.getPreferredName()
        assertWarnings("Expected at least one value for an array of [" + FetchSourceContext.EXCLUDES_FIELD.getPreferredName() + "]");
                .value("CCC")  
            .startObject()
            assertEquals("The same entry [AAA] cannot be both included and excluded in _source.", result.getMessage());
        final XContentBuilder source = XContentFactory.jsonBuilder()  
                .endObject()
            "An empty array was provided as [_source]. Provide at least one field pattern or use `_source: true` to fetch the entire source."
            .endObject();
        assertEquals(2, result.includes().length); // no duplicates  
                .startArray()
                .field("excludes")
    }
            .field("excludes")  
        {  
            .startObject()  
        final XContentBuilder source = XContentFactory.jsonBuilder()
        ParsingException invalidArray = expectThrows(ParsingException.class, () -> FetchSourceContext.parseSourceArray(parser));  
    private XContentParser createSourceParser(XContentBuilder source) throws IOException {
                .value("BBB")  
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", true).endObject();
import java.util.Arrays;
                .value("BBB")
                .endObject();  
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
            .field("_source")
                .startObject()  
        final XContentBuilder source = XContentFactory.jsonBuilder()
            .startArray()
    public void testFetchSourceString() throws IOException {
        assertTrue(result.fetchSource());
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
                .startObject()
import org.opensearch.core.common.ParsingException;
        final XContentBuilder source = XContentFactory.jsonBuilder()
            .endObject();
                .startObject()  
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));
    }
 * SPDX-License-Identifier: Apache-2.0
                .startObject()
            .startObject()
        final XContentParser parser = createSourceParser(source);  
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));
    public void testFetchSourceAsObjectConflictingEntries() throws IOException {
            .endObject();  
        assertWarnings("Expected at least one value for an array of [" + FetchSourceContext.INCLUDES_FIELD.getPreferredName() + "]");
        final XContentParser parser = createSourceParser(source);  
/*  
                .field("_source")
        assertEquals(0, result.excludes().length); // no excludes  
 * compatible open source license.
                .value("AAA")  
        final XContentParser parser = createSourceParser(source);
            .endArray()  
        assertArrayEquals(new String[] { "exclude1" }, result.excludes()); // single exclude
            final XContentBuilder source = XContentFactory.jsonBuilder()
            final XContentParser parser = createSourceParser(source);
        return parser;
        {
    }  
        // validate includes
            .field("_source")
                .field("includes")
    public void testFetchSourceArray() throws IOException {  
            final XContentBuilder source = XContentFactory.jsonBuilder()  
            .field("includes", "include1")  
                .field("_source")
                .startArray()
    public void testFetchSourceAssertWarningEmptyObject() throws IOException {
                .value("AAA")  
            .endObject()  
        assertArrayEquals(new String[] { "iii" }, result.includes());
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
            .endArray()
        assertTrue(result.fetchSource()); // fetch source
        ParsingException invalidObject = expectThrows(ParsingException.class, () -> FetchSourceContext.parseSourceObject(parser));  
                .value("BBB")
                .field("excludes")  
            .startObject()  
            assertEquals("The same entry [BBB] cannot be both included and excluded in _source.", result.getMessage());
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", false).endObject();
        {
        assertWarnings(
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
                .startArray()
            final XContentParser parser = createSourceParser(source);
            .endArray()
    }
import java.io.IOException;  
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));  
    }  
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);  
            .startArray()
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", true).endObject();  
    }
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
        assertTrue(result.fetchSource()); // fetch source
        }
            .field("excludes")
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
                .endArray()
            final XContentBuilder source = XContentFactory.jsonBuilder()
        assertArrayEquals(new String[] { "include1" }, result.includes()); // single include
        assertTrue(result.fetchSource()); // fetch source
        assertEquals(FetchSourceContext.FETCH_SOURCE, result);  
                .field("excludes")  
                .field("_source")  
            .field("_source")  
            .value("iii")
                .field("includes")
                .value("AAA")
        assertTrue(result.fetchSource());
        parser.nextToken(); // move to _source value to parse  
        assertArrayEquals(new String[] { "include1" }, result.includes()); // single include  
            final XContentParser parser = createSourceParser(source);
        assertEquals("Expected a START_ARRAY but got a VALUE_BOOLEAN in [_source].", invalidArray.getMessage());
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);  
            assertEquals("The same entry [AAA] cannot be both included and excluded in _source.", result.getMessage());
            .startArray()
    public void testParseSourceObjectInvalidInput() throws IOException {
    }
            .startArray()
            .endArray()  
        XContentParser parser = createParser(source);  
                .startArray()
            .field("excludes", "exclude1")
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source").startArray().endArray().endObject();
                .endObject();  
            .value("include2")  
            .startObject()  
    }
        final XContentParser parser = createSourceParser(source);
                .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
            .endArray()  
        final XContentParser parser = createSourceParser(source);  
        assertTrue(result.fetchSource());  
        assertTrue(Arrays.asList(result.excludes()).containsAll(Arrays.asList("aaa", "bbb")));
            .field("excludes")
            .field("_source")
        final XContentParser parser = createSourceParser(source);
                .field("includes")
            .value("include2")
                .startObject()
        // validate excludes
 * this file be licensed under the Apache-2.0 license or a
                .endArray()
            final XContentBuilder source = XContentFactory.jsonBuilder()  
        assertEquals("Expected a START_OBJECT but got a VALUE_BOOLEAN in [_source].", invalidObject.getMessage());
            .endArray()  
 * The OpenSearch Contributors require contributions made to  
            .endObject();
/*
    public void testFetchSourceObjectAssertWarningExplicitEmptyExcludes() throws IOException {
        );
        assertEquals(FetchSourceContext.DO_NOT_FETCH_SOURCE, result);
            .endObject();
    }
        final XContentParser parser = createSourceParser(source);
 */
import org.opensearch.common.xcontent.XContentFactory;  
                .endObject();
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source").startObject().endObject().endObject();
        assertEquals(2, result.excludes().length); // no duplicates  
            final XContentParser parser = createSourceParser(source);  
                .value("AAA")
            .startArray()
                .endObject()
