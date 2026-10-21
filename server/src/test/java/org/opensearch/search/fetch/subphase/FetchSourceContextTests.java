        }
        assertArrayEquals(new String[] { "exclude1" }, result.excludes()); // single exclude
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
    public void testParseSourceObjectInvalidInput() throws IOException {
    }
                .startArray()
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
            .value("bbb")
            .value("iii")
        final XContentParser parser = createSourceParser(source);
            .startObject()
                .field("excludes")
        XContentParser parser = createParser(source);
            final XContentBuilder source = XContentFactory.jsonBuilder()
        {
                .startArray()
                .startObject()
            final XContentBuilder source = XContentFactory.jsonBuilder()
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));
    }
            "An empty array was provided as [_source]. Provide at least one field pattern or use `_source: true` to fetch the entire source."
        }
            .endArray()
                .endObject()
        assertTrue(result.fetchSource());
        // validate includes
        // validate includes
    public void testFetchSourceObjectAssertWarningExplicitEmptyExcludes() throws IOException {
            .value("include2")
        assertTrue(result.fetchSource()); // fetch source
        {
        final XContentBuilder source = XContentFactory.jsonBuilder()
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", false).endObject();
        assertEquals(2, result.excludes().length); // no duplicates
        final XContentParser parser = createSourceParser(source);
        assertEquals("Expected a START_ARRAY but got a VALUE_BOOLEAN in [_source].", invalidArray.getMessage());
            .field("includes", "include1")
                .value("CCC")
                .value("BBB")
import org.opensearch.core.common.ParsingException;
        assertArrayEquals(new String[] { "include1" }, result.includes()); // single include
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
        assertWarnings("Expected at least one value for an array of [" + FetchSourceContext.INCLUDES_FIELD.getPreferredName() + "]");
                .value("BBB")
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));
    public void testFetchSourceAsObjectBothIncludeAndExcludeArrays() throws IOException {
        final XContentParser parser = createSourceParser(source);
        );
        assertTrue(result.fetchSource()); // fetch source
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
                .value("AAA")
                .startObject()
            .field("excludes")
                .field("_source")
                + "] or ["
            .startObject()
                .startArray()
            .endArray()
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
        }
        final XContentParser parser = createSourceParser(source);
 */
            .startArray()
                .endObject();
        {
        assertEquals(0, result.excludes().length);
                .value("BBB")
                .value("BBB")
            .field("excludes")
            .startObject()
        parser.nextToken(); // move to _source value to parse
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
            .startArray()
 */
/*
                .value("AAA")
            .field("_source")
            .startArray()
        assertWarnings("Expected at least one value for an array of [" + FetchSourceContext.EXCLUDES_FIELD.getPreferredName() + "]");
                .startObject()
                .startObject()
    public void testFetchSourceArray() throws IOException {
            assertEquals("The same entry [BBB] cannot be both included and excluded in _source.", result.getMessage());
            .field("excludes", "exclude1")
        final XContentBuilder source = XContentFactory.jsonBuilder()
            .field("_source")
                .startObject()
                .field("_source")
        return parser;
    }
        // validate excludes
                .value("AAA")
            .endArray()
 *
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", "include1").endObject();
            .endObject();
 * GitHub history for details.
            .field("_source")
            .endObject();
        assertTrue(result.fetchSource());
        final XContentParser parser = createSourceParser(source);
                .startObject()
                .endArray()
                .field("excludes")
        assertTrue(Arrays.asList(result.includes()).containsAll(Arrays.asList("include1", "include2")));
            final XContentParser parser = createSourceParser(source);
            .endObject()
            .startArray()
        final XContentParser parser = createSourceParser(source);
                .endArray()
    public void testFetchSourceAsObject() throws IOException {
            .field("_source")
        assertTrue(result.fetchSource());
                .value("AAA")
        assertEquals(FetchSourceContext.FETCH_SOURCE, result);
            .value("include1")
                .field("includes")
        assertEquals("Expected a START_OBJECT but got a VALUE_BOOLEAN in [_source].", invalidObject.getMessage());
        ParsingException invalidArray = expectThrows(ParsingException.class, () -> FetchSourceContext.parseSourceArray(parser));
        final XContentParser parser = createSourceParser(source);
    private XContentParser createSourceParser(XContentBuilder source) throws IOException {
public class FetchSourceContextTests extends OpenSearchTestCase {
    }
}
    public void testFetchSourceAsArrayAssertWarningExplicitEmptyArray() throws IOException {
            .startArray()
import org.opensearch.test.OpenSearchTestCase;
                .endObject()
        final XContentParser parser = createSourceParser(source);
            .endArray()
    public void testFetchSourceAsObjectConflictingEntries() throws IOException {
                .startArray()
            "An empty object was provided as [_source]. Provide at least one of ["
            .field("_source")
        parser.nextToken(); // move to field name "_source"
                .field("includes")
            final XContentParser parser = createSourceParser(source);
/*
        assertTrue(result.fetchSource());
    }
    }
                .field("_source")
        assertEquals(2, result.includes().length); // no duplicates
                .endObject();
        ParsingException invalidObject = expectThrows(ParsingException.class, () -> FetchSourceContext.parseSourceObject(parser));
                .field("excludes")
        }
        parser.nextToken(); // move to start object
            .value("include2")
import java.util.Arrays;
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source").startArray().endArray().endObject();
            final XContentBuilder source = XContentFactory.jsonBuilder()
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
 * compatible open source license.
                .endArray()
                .value("AAA")
            .value("aaa")
            .field("includes")
            .startObject()
 * The OpenSearch Contributors require contributions made to
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", true).endObject();
            .field("includes")
            .endObject()
                + "] or use `_source: true` to fetch the entire source."
    }
    }
            .endObject();
        assertTrue(result.fetchSource()); // fetch source
                .value("AAA")
                .startObject()
            final XContentParser parser = createSourceParser(source);
                .endObject();
            final XContentBuilder source = XContentFactory.jsonBuilder()
                .field("excludes")
        // validate no excludes
            final XContentParser parser = createSourceParser(source);
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));
    public void testDoNotFetchSource() throws IOException {
        final XContentParser parser = createSourceParser(source);
                .field("includes")
            assertEquals("The same entry [AAA] cannot be both included and excluded in _source.", result.getMessage());
    }
    }
        assertTrue(Arrays.asList(result.excludes()).containsAll(Arrays.asList("aaa", "bbb")));
            .startObject()
        assertArrayEquals(new String[] { "include1" }, result.includes()); // single include
    public void testFetchSourceAssertWarningEmptyObject() throws IOException {
        assertWarnings(
        final XContentParser parser = createSourceParser(source);
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("The same entry [AAA] cannot be both included and excluded in _source.", result.getMessage());
            .field("includes", "include1")
                .startObject()
        {
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
        assertTrue(result.fetchSource());
                .field("includes")
            .endObject()
import java.io.IOException;
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
    public void testFetchSourceObjectAssertWarningExplicitEmptyIncludes() throws IOException {
        assertEquals(FetchSourceContext.DO_NOT_FETCH_SOURCE, result);
            .field("excludes")
                .endObject();
            .endObject();
                .endArray()
                .endObject()
    }
            .startObject()
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source", true).endObject();
        final XContentParser parser = createSourceParser(source);
            .startObject()
            IllegalArgumentException result = expectThrows(IllegalArgumentException.class, () -> FetchSourceContext.fromXContent(parser));
        FetchSourceContext result = FetchSourceContext.fromXContent(parser);
        final XContentBuilder source = XContentFactory.jsonBuilder()
        final XContentBuilder source = XContentFactory.jsonBuilder()
                .value("AAA")
            .startArray()
            .endArray()
import org.opensearch.core.xcontent.XContentBuilder;
                .field("_source")
 * Modifications Copyright OpenSearch Contributors. See
        final XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("_source").startObject().endObject().endObject();
        assertEquals(0, result.excludes().length); // no excludes
                + FetchSourceContext.EXCLUDES_FIELD.getPreferredName()
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.search.fetch.subphase;
            .endArray()
import org.opensearch.common.xcontent.XContentFactory;
                + FetchSourceContext.INCLUDES_FIELD.getPreferredName()
            .endObject();
    public void testFetchSourceString() throws IOException {
        assertWarnings(
                .endObject()
        final XContentBuilder source = XContentFactory.jsonBuilder()
 * this file be licensed under the Apache-2.0 license or a
    }
        );
            assertEquals("The same entry [AAA] cannot be both included and excluded in _source.", result.getMessage());
        assertArrayEquals(new String[] { "iii" }, result.includes());
            .startObject()
            .startObject()
    public void testFetchSource() throws IOException {
            .value("exclude1")
            .endObject()
    }
