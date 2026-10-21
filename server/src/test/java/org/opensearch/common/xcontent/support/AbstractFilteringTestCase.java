            .endObject()
        .field("lang", "French")
        .nullField("default")
            .startArray("tags")
            .nullField("default")
            .field("street", "Rue Mouffetard")
            .startObject("fr")
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, singleton("r*"), emptySet());
        .startObject()
            .field("available", true)
import static java.util.Collections.emptySet;
        .field("firstname", "Doe")
            .startObject()
            .endObject()
            .field("city", "Stornoway")
            .startObject("en")
        testFilter(expected, sample, singleton("test1"), emptySet());
        testFilter(expected, SAMPLE, emptySet(), singleton("xyz"));
            .startObject("properties")
            .endObject()
            .endArray()
            .startObject()
            .field("name", "The Book Shop")
            .nullField("default")
            .field("street", "Hampton St")
        .field("city", "Paris")
            .endObject()
            .field("lang", "English")
            .field("name", "Sussex Books House")
            .endObject()
            .field("name", "William Smith")
            .endArray()
            .startArray("addresses")
        testFilter(expected, SAMPLE, emptySet(), singleton("properties.**.name"));
            .endArray()
            .startArray("distributors")
            .field("timestamp", 1428582942867L)
            .endObject();
            .endObject();
    public void testRawField() throws Exception {
            .field("name", "Thetra")
            .endObject()
            .endObject()
            .field("street", "Queen St")
            .endObject()
        final Builder expected = builder -> builder.startObject()
            .field("name", "John Doe")
            .field("available", false)
        Builder expected = builder -> builder.startObject().startObject("foo").endObject().endObject();
        final Builder expected = builder -> builder.startObject().endObject();
            .endArray()
            .startObject()
            .nullField("default")
            .startArray("distributors")
            .startObject("properties")
            .field("firstname", "Doe")
            .field("timestamp", 1428582942867L)
            .startObject()
            return builder.startObject().field("foo", 0).rawField("raw", raw.streamInput()).endObject();
        final Builder sample = builder -> builder.startObject().startObject("foo").endObject().endObject();
            .endObject()
            .startObject("en")
            .endObject()
        .endObject()
            .endObject()
            .field("firstname", "Smith")
            .field("street", "Rue Mouffetard")
            .startArray("distributors")
            .field("lastname", "John")
            .field("lastname", "John")
            .endObject()
            .endObject()
            .endArray()
            .field("firstname", "ipsum")
    }
            .value("opensearch")
        .field("price", 27.99)
            .field("city", "London")
            .endArray()
 * You may obtain a copy of the License at
            .field("city", "London")
            .endObject()
    }
            .endObject()
            .endArray()
            .endObject()
            .field("lastname", "lorem")
            .endObject()
            .field("name", "La Maison du Livre")
            .startArray("addresses")
        .startObject()
            .field("weight", 0.8d)
            .field("name", "John Doe")
        sampleWithRaw = builder -> {
            .field("lang", "French")
        .field("firstname", "Smith")
            .value("java")
            .startObject()
            .startArray("tags")
            .startObject()
    public void testRecurseField3Inclusive() throws Exception {
            .startObject()
            .field("firstname", "Smith")
        .field("timestamp", 1428582942867L)
            .endArray()
            .startObject()
            .startObject()
            .endObject()
            .endObject()
            .endObject()
            .field("city", "Stornoway")
            .endObject();
            .startObject()
    }
        testFilter(expected, sampleArrayOfObjects, singleton("t*.firstname"), emptySet());
    protected static final Builder SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE = builder -> builder.startObject()
            .endObject()
            .endObject()
            .field("city", "Paris")
            .field("pages", 456)
            .field("available", true)
            .endArray()
            .startObject()
            .field("foo", 0)
            .field("name", "La Maison du Livre")
    public void testSimpleFieldExclusive() throws Exception {
        final Builder expected = builder -> builder.startObject()
            .field("lastname", "John")
        Set<String> includes = Sets.newHashSet("tags", "authors");
            .startObject()
            .field("name", "The Book Shop")
        testFilter(expected, SAMPLE, singleton("authors.l*"), emptySet());
            .endObject()
            .endObject()
            .startArray("distributors")
            );
            .field("street", "Queen St")
            .field("timestamp", 1428582942867L)
            .endObject()
            .endArray()
            .field("firstname", "Doe")
            .field("city", "Stornoway")
        testFilter(expected, sample, singleton("f*"), singleton("foo"));
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors.*name"));
            .endArray()
    }
            .startArray("distributors")
public abstract class AbstractFilteringTestCase extends OpenSearchTestCase {
            .startArray("distributors")
            .endObject()
            .field("city", "Paris")
            .endArray()
                XContentBuilder.builder(builder.contentType().xContent()).startObject().field("content", "hello world!").endObject()
            .startObject("raw")
            .endObject()
        .endObject()
            .field("lastname", "John")
            .startArray("addresses")
            .startObject("language")
            .endObject()
            .endObject();
            .field("pages", 456)
        // Test: Array of objects (no filtering)
            .startObject()
            .field("name", "Sussex Books House")
            .value("java")
            .endArray()
            .endObject()
     * Generalization of {@link XContentMapValuesTests#testSharedPrefixes()}
            .endObject()
            .startObject("en")
            .startObject("language")
            .endArray()
            .endObject()
            .endObject()
            .endArray()
            .field("price", 27.99)
        expected = builder -> builder.startObject().field("foobaz", 3).endObject();
            .endObject()
            .field("weight", 0.8d)
            .field("lastname", "John")
            .value("dolor")
            .field("timestamp", 1428582942867L)
    public void testMultipleFieldsInclusive() throws Exception {
            .field("available", false)
            .field("lastname", "William")
            .endObject()
 * specific language governing permissions and limitations
        .endObject()
 *
            .startArray("distributors")
        .startObject()
 * this work for additional information regarding copyright
            .field("name", "The Book Shop")
            .startObject()
        testFilter(expected, SAMPLE, emptySet(), emptySet());
        expected = builder -> builder.startObject().endObject();
        testFilter(expected, SAMPLE, singleton("*"), emptySet());
            .endObject()
            .endObject()
            .endArray()
        expected = builder -> builder.startObject()
 * Unless required by applicable law or agreed to in writing,
            .field("name", "William Smith")
            .field("name", "John Doe")
        testFilter(sampleArrayOfValues, sampleArrayOfValues, singleton("t*"), emptySet());
        final Builder expected = builder -> builder.startObject()
    }
            .field("available", true)
            .endObject()
            .field("name", "address #1")
            .field("lastname", "William")
        testFilter(expected, SAMPLE, includes, excludes);
            .startObject("language")
    }
            .field("lang", "French")
            .field("weight", 0.8d)
            .endObject()
            .startArray("addresses")
            .endArray()
    protected interface Builder extends CheckedFunction<XContentBuilder, XContentBuilder, IOException> {}
        .value("java")
            .field("test", "value1")
            .endObject()
            .endArray()
        testFilter(sampleArrayOfValues, sampleArrayOfValues, singleton("tags"), emptySet());
            .startObject("language")
            .field("name", "address #2")
            .endObject()
            .endObject()
            .endObject()
            .startObject()
            .field("firstname", "Doe")
            .field("pages", 456)
        testFilter(expected, SAMPLE, singleton("properties.*.en.**.name"), emptySet());
        // Test method: rawField(String fieldName, BytesReference content)
            .startArray("distributors")
        testFilter(expected, SAMPLE, emptySet(), singleton("pr*"));
            .field("available", false)
import org.opensearch.core.common.bytes.BytesReference;
            .endObject()
            .endObject()
            .field("name", "address #1")
        .endObject()
            .endObject()
        .field("available", true)
        .endObject()
            .startObject("fr")
            .value("opensearch")
            .endObject()
            .field("city", "London")
            .startObject()
            .startObject()
            .endObject()
        .field("name", "Thetra")
        .value("opensearch")
        testFilter(expected, sample, singleton("bar"), emptySet());
            .startArray("addresses")
        testFilter(sampleArrayOfObjects, sampleArrayOfObjects, singleton("t*"), emptySet());
    public void testArrays() throws Exception {
            .field("name", "address #2")
            .field("firstname", "Smith")
        testFilter(expected, sample, emptySet(), singleton("bar"));
    public void testSimpleArrayOfObjectsPropertyInclusive() throws Exception {
            .endObject();
            .startObject()
            .field("title", "My awesome book")
            .startArray("authors")
            .field("name", "Thetra")
            .startArray("distributors")
            .field("lang", "English")
            .startObject()
            .startArray("addresses")
            .startObject()
            .startObject()
            .endObject()
        testFilter(expected, SAMPLE, includes, excludes);
    }
        testFilter(expected, complex, singleton("test1*"), emptySet());
            .startObject("en")
    public void testRecursiveObjectsInArrayWithBothExcludesIncludes() throws IOException {
            .startObject()
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, singleton("r*"), emptySet());
            .field("name", "La Maison du Livre")
            .endObject();
            .field("name", "address #1")
            .endObject()
            .startArray("distributors")
            .endArray()
            .startObject("language")
            .field("name", "Thetra")
 *
            .field("firstname", "Doe")
            .field("name", "John Doe")
            .endObject()
            .value("opensearch")
            .field("available", true)
            .startObject()
            .field("lastname", "William")
        testFilter(expected, SAMPLE, emptySet(), Sets.newHashSet("title", "pages"));
            .endArray()
            .startObject("fr")
            .endArray()
            .endObject();
            .startObject()
        final Builder expected = builder -> builder.startObject()
        .endObject()
    public void testSimpleFieldWithWildcardInclusive() throws Exception {
            .startObject("fr")
        .field("name", "Sussex Books House")
        .endObject()
            .startArray("addresses")
        .field("lang", "English")
        .endObject()
        .startObject("en")
            .field("pages", 456)
            .endObject()
        testFilter(expected, SAMPLE, emptySet(), singleton("**.name"));
            .value("java")
        testFilter(sample, sample, singleton("f*"), singleton("baz"));
            .endObject()
            .value("java")
            .endObject()
            .field("street", "Hampton St")
            .startObject()
            .field("available", true)
            .startObject()
            .startArray("tags")
            .startObject("fr")
            .endArray()
    }
        .startArray("distributors")
            .endArray()
 * Tests for {@link XContent} filtering.
        final Builder sampleArrayOfObjects = builder -> builder.startObject()
            .endObject()
        .endObject()
        .endObject()
            .startObject("language")
            .field("name", "The Book Shop")
            .field("test", "value2")
            .endObject();
            .startArray("authors")
            .field("name", "William Smith")
            .endObject()
            .startObject()
    public void testSimpleArrayOfObjectsInclusive() throws Exception {
            .field("name", "address #1")
    }
            .endObject()
            .endArray()
            .endObject()
        .startArray("addresses")
 * under the License.
        .startArray("addresses")
            .field("lastname", "John")
        testFilter(sample, sample, emptySet(), singleton("bar"));
            .endObject()
            .nullField("default")
    public void testWithLfAtEnd() throws IOException {
            .endObject()
        expected = builder -> builder.startObject()
        .endObject()
            .startObject("fr")
            .field("lastname", "John")
            .field("name", "John Doe")
            .startArray("distributors")
        Set<String> excludes = singleton("**.distributors");
        .endObject();
            .startObject()
            .endObject()
            .endObject()
            .field("price", 27.99)
            .field("street", "Hampton St")
        .field("street", "Hampton St")
            .field("name", "Sussex Books House")
            .startArray("distributors")
        .startObject("language")
        testFilter(expected, sampleArrayOfObjects, singleton("foo"), emptySet());
            .endObject()
            .field("street", "Hampton St")
            .endObject()
        testFilter(expected, SAMPLE, singleton("title"), emptySet());
    }
            .startArray("tags")
        Builder expected = builder -> builder.startObject().endObject();
            .field("lang", "English")
        testFilter(expected, sampleArrayOfObjects, emptySet(), singleton("tags"));
            .field("title", "My awesome book")
            .startObject()
            .endObject()
            .field("street", "Queen St")
            .endObject()
        .field("title", "My awesome book")
    }
            .endObject()
        // Test: Array of objects (with filtering)
        testFilter(expected, SAMPLE, singleton("p*"), singleton("properties"));
            .startObject()
            .field("lang", "French")
    public void testSimpleFieldInclusive() throws Exception {
            .endObject()
            .startObject("en")
        .field("name", "Sussex Books House")
    protected static final Builder SAMPLE = builder -> builder.startObject()
        .startObject()
    /** Sample test case **/
            .startObject()
        testFilter(expected, SAMPLE, includes, excludes);
            .field("timestamp", 1428582942867L)
            .endObject()
            .field("price", 27.99)
            .startArray("distributors")
        testFilter(expected, SAMPLE, singleton("authors.lastname"), emptySet());
            .startObject()
            .startObject()
            .endObject()
        .field("city", "Paris")
            .field("test1", "value1")
            .field("city", "Stornoway")
            .field("name", "Thetra")
        final Builder sampleArrayOfValues = builder -> builder.startObject()
            .endObject();
        .field("name", "address #1")
            .endArray()
            .startObject("properties")
import java.util.Set;
            .startObject("properties")
    }
            .field("firstname", "Doe")
            .startArray("path2")
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors"));
            .startObject("fr")
            .field("lang", "English")
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors.*"));
    public void testRecursiveSameObjectWithBothExcludesIncludes() throws IOException {
            .startObject()
        .endObject()
        .startArray("distributors")
        .field("street", "Hampton St")
    }
            .field("title", "My awesome book")
            .startObject("language")
        };
            .endObject()
            .endObject()
            .field("firstname", "Doe")
            .endObject()
            .field("name", "Sussex Books House")
            .field("available", true)
            .startObject()
import static java.util.Collections.singleton;
            .field("price", 27.99)
            .field("available", false)
        testFilter(sampleArrayOfObjects, sampleArrayOfObjects, singleton("tags"), emptySet());
            .startObject("properties")
        testFilter(expected, sample, singleton("f*"), singleton("foo"));
            .startArray("authors")
            .startArray("addresses")
            .endArray()
            .startObject()
        final Builder expected = builder -> builder.startObject()
            .field("name", "Thetra")
            .endObject()
            .endObject()
            .field("firstname", "Smith")
            .endObject()
            .field("city", "London")
            .field("name", "La Maison du Livre")
            .nullField("default")
            .startArray("addresses")
            .startObject()
            .endObject()
            .field("available", true)
            .startArray("addresses")
            .startObject()
            .field("weight", 0.8d)
            .field("lastname", "William")
        final Builder expected = builder -> builder.startObject()
            .startObject()
        Builder expected = builder -> builder.startObject().field("test1", "value1").endObject();
            .startObject()
            .field("name", "address #1")
            .field("name", "John Doe")
        };
            .startObject()
            .startObject()
            .endObject();
            .endObject()
            .startObject()
    public void testSimpleFieldWithWildcardExclusive() throws Exception {
            .startObject()
            .field("lastname", "William")
            .endObject()
            .endArray()
            .startObject("properties")
    }
            .endObject()
    public void testRecurseField2Exclusive() throws Exception {
            .endObject();
    public void testRecurseField2Inclusive() throws Exception {
        testFilter(expected, SAMPLE, emptySet(), singleton("authors.lastname"));
            .startArray("addresses")
            .field("name", "The Book Shop")
            .field("name", "Thetra")
        .field("city", "Stornoway")
 * KIND, either express or implied.  See the License for the
        testFilter(expected, SAMPLE, emptySet(), singleton("properties.*.en.**.name"));
        testFilter(expected, SAMPLE, emptySet(), singleton("properties.**.distributors.name"));
            .startObject("en")
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
/**
            .endObject()
            .field("lang", "English")
        testFilter(expected, SAMPLE, singleton("xyz"), emptySet());
            .value("java")
            .endObject()
            .startObject()
            .field("city", "London")
        .startObject()
            .field("pages", 456)
            .field("lastname", "William")
            .startObject("language")
            .endObject()
            .startObject()
            .endObject()
            .field("lastname", "William")
            .endArray()
        .endObject()
            .field("test2", "value2")
            .endObject()
            .field("name", "Sussex Books House")
            .startObject()
/*
            .startObject("en")
            .field("lastname", "William")
            .endObject()
            .startObject("en")
        .field("name", "John Doe")
            .endObject()
    public void testFilterSharedPrefixes() throws IOException {
            .field("firstname", "Smith")
        .startObject()
        Set<String> includes = singleton("**.en.*");
        testFilter(expected, sampleArrayOfValues, singleton("foo"), emptySet());
            .startObject()
            .endObject()
            .endArray()
            .endObject()
            .field("available", false)
import java.io.IOException;
            .endObject()
            .startArray("tags")
            .startObject()
            .field("street", "Hampton St")
            .field("name", "address #1")
            .endObject()
        .endObject()
            .startArray("addresses")
        testFilter(expected, sample, singleton("photosCount"), emptySet());
            .startArray("authors")
            BytesReference raw = BytesReference.bytes(
        .endArray()
    public void testRecurseField1Inclusive() throws Exception {
        .field("name", "William Smith")
 * software distributed under the License is distributed on an
    }
            .field("price", 27.99)
            .endObject()
        .endObject()
        testFilter(expected, SAMPLE, emptySet(), singleton("tags"));
            .startObject()
            .field("name", "William Smith")
    protected abstract void testFilter(Builder expected, Builder actual, Set<String> includes, Set<String> excludes) throws IOException;
            .field("city", "Paris")
    public void testFilterPrefix() throws IOException {
    }
    }
            .endObject()
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, emptySet(), singleton("f*"));
            .endObject()
        final Builder expectedRawField = builder -> builder.startObject()
            .field("lastname", "John")
            .endObject()
        .field("lastname", "John")
        .field("title", "My awesome book")
            .startArray("authors")
    public void testRecurseField3Exclusive() throws Exception {
 *
            .endObject()
            .endArray()
            .value("opensearch")
            .value("opensearch")
    }
            .startObject()
            .field("name", "address #1")
            .field("city", "London")
            .startObject()
            .field("lastname", "John")
            .field("name", "address #2")
            .startObject()
            .field("name", "Sussex Books House")
            .startObject()
            .startObject()
            .field("lang", "English")
            .field("name", "Thetra")
            .field("name", "Sussex Books House")
        .endArray()
            .endObject();
    }
            .field("available", true)
            .startObject()
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, emptySet(), singleton("f*"));
        testFilter(expected, sample, singleton("搜索"), emptySet());
        .startObject()
            .field("lang", "English")
            .field("street", "Hampton St")
            .field("name", "address #1")
            .field("lang", "English")
            .startObject()
            .endArray()
        .startArray("addresses")
        .startObject("en")
 * not use this file except in compliance with the License.
            .field("name", "John Doe")
            .field("name", "Sussex Books House")
            .endObject();
            .endObject()
            .endObject()
            .field("name", "William Smith")
            .field("name", "Thetra")
            .field("name", "The Book Shop")
            .endObject()
        final Builder expectedRawFieldFiltered = builder -> builder.startObject().field("foo", 0).endObject();
            .field("firstname", "Smith")
            .startObject()
 */
            .endArray()
            .endArray()
        testFilter(expected, sample, emptySet(), singleton("搜索"));
     * Generalization of {@link XContentMapValuesTests#testSupplementaryCharactersInPaths()}
        expected = builder -> builder.startObject().field("test1", "value1").field("test2", "value2").endObject();
            .endObject()
        .endArray()
        final Builder sample = builder -> builder.startObject().field("foobar", 2).field("foobaz", 3).endObject();
        final Builder sample = builder -> builder.startObject().array("photos", "foo", "bar").field("photosCount", 2).endObject();
            .endArray()
            .field("lang", "French")
            .field("available", false)
            .endObject()
            .field("street", "Rue Mouffetard")
            .field("city", "Stornoway")
        .field("name", "address #1")
            .field("city", "Stornoway")
 */
            .endObject()
            .endArray()
            .value("opensearch")
            .field("street", "Rue Mouffetard")
/*
            .startObject()
    public void testSimpleArrayOfObjectsExclusive() throws Exception {
            .endArray()
            .endObject()
        .endObject()
            .endObject()
            .startObject()
            .endObject()
            .field("weight", 0.8d)
            .startObject()
            .field("name", "address #2")
        final Builder expected = builder -> builder.startObject()
            .startObject("language")
            .startObject()
            .startArray("distributors")
            .startArray("authors")
        final Builder expected = builder -> builder.startObject()
            .field("name", "address #1")
            .field("lastname", "John")
            .endObject()
            .field("name", "La Maison du Livre")
            .startArray("addresses")
    }
        // more complex object...
            .field("available", true)
            .startObject()
            .field("name", "address #1")
            .endObject()
            .startArray("tags")
            .endObject()
            .endArray()
            .startArray("authors")
            .endObject()
            .startArray("addresses")
        final Builder expectedRawFieldNotFiltered = builder -> builder.startObject()
            .startArray("addresses")
        .startObject()
            .endObject();
            .endObject()
            .endObject()
            .startObject()
        .field("lang", "French")
        .endObject()
        testFilter(expected, SAMPLE, emptySet(), singleton("*"));
            .field("street", "Queen St")
            .endObject();
            .startObject("properties")
        .field("available", true)
            .endObject();
            .endObject()
        testFilter(expected, sample, singleton("test*"), emptySet());
            .startObject("fr")
            .startArray("tags")
            .startObject("fr")
        testFilter(expected, sampleArrayOfValues, emptySet(), singleton("tags"));
            .field("lang", "French")
            .field("city", "Paris")
 * ownership. Elasticsearch licenses this file to you under
            .endObject()
            .endObject()
            .startObject()
            .field("name", "The Book Shop")
        .field("name", "address #1")
        testFilter(sampleArrayOfObjects, sampleArrayOfObjects, emptySet(), singleton("a"));
 * SPDX-License-Identifier: Apache-2.0
            .endObject();
            .startObject()
        .field("lastname", "William")
            .startObject()
        testFilter(expected, sample, emptySet(), singleton("foobar"));
        .startObject()
            .startObject("properties")
            .endObject()
            .field("content", "hello world!")
            .field("firstname", "Smith")
            .startObject("fr")
        final Builder sample = builder -> builder.startObject()
        .field("street", "Queen St")
        .endArray()
            .endObject()
            .field("timestamp", 1428582942867L)
            .endObject()
package org.opensearch.common.xcontent.support;
        .field("timestamp", 1428582942867L)
            .endArray()
            .endArray()
            .startArray("distributors")
        Builder expected = builder -> builder.startObject().field("foobar", 2).endObject();
    /**
        Set<String> includes = Sets.newHashSet("**.language", "properties.weight");
            .startObject("language")
            .endObject()
            .endObject()
            .startObject()
            .startObject()
            .field("available", false)
        .field("city", "London")
            .endArray()
            .field("street", "Queen St")
            .endObject()
            .startObject("en")
        Set<String> excludes = Sets.newHashSet("**.distributors.*.name", "**.street");
            .field("available", false)
            .field("lastname", "William")
            .field("name", "address #2")
            .startObject()
    }
            .field("firstname", "Smith")
            .endObject()
            .endObject()
        .endArray()
            .field("name", "The Book Shop")
            .field("weight", 0.8d)
            .field("firstname", "Smith")
            .endArray()
        .startObject()
            .endArray()
            .endArray()
            .field("lang", "English")
            .value("opensearch")
        Builder expected = builder -> builder.startObject().field("photosCount", 2).endObject();
            .startObject("language")
            .field("name", "address #1")
 * Licensed to Elasticsearch under one or more contributor
            );
            .startArray("distributors")
            .endArray()
 *     http://www.apache.org/licenses/LICENSE-2.0
        .field("name", "address #2")
    public void testRecurseField4Inclusive() throws Exception {
            .startArray("addresses")
            .endObject()
        final Builder complex = builder -> builder.startObject()
            .startObject()
            .startObject("en")
            .field("name", "address #2")
 * the Apache License, Version 2.0 (the "License"); you may
            .startObject("properties")
            .startArray("authors")
        testFilter(sample, sample, singleton("foo"), emptySet());
        testFilter(expected, sample, emptySet(), singleton("foo"));
    }
            return builder.startObject().field("foo", 0).rawField("raw", raw.streamInput()).endObject();
            .value("ipsum")
        .startObject()
            .startObject("en")
            .field("lastname", "William")
            .startObject()
        testFilter(expected, sample, singleton("foo"), emptySet());
        testFilter(expected, SAMPLE, singleton("tags"), emptySet());
            .nullField("default")
            .startArray("addresses")
            .endObject()
            .field("street", "Rue Mouffetard")
            .field("name", "William Smith")
            .startArray("addresses")
        .field("street", "Rue Mouffetard")
    }
            .field("name", "La Maison du Livre")
            .field("name", "address #1")
            .startObject()
            .startObject()
            .startObject("properties")
            .endObject()
            .field("test1", "value1")
            .field("title", "My awesome book")
            .field("firstname", "Doe")
        final Builder expected = builder -> builder.startObject().endObject().lfAtEnd();
     */
            .value("java")
        Builder sampleWithRaw = builder -> {
        expected = builder -> builder.startObject().field("指数", 3).endObject();
            .field("timestamp", 1428582942867L)
            .endObject()
            .field("name", "John Doe")
            .startArray("addresses")
        final Builder expected = builder -> builder.startObject()
        .startObject("fr")
            .startObject()
            .startObject("fr")
            .endObject()
            .field("weight", 0.8d)
            .endArray()
            .startArray("distributors")
        .field("name", "The Book Shop")
            .endObject()
            .endObject()
            .field("test", "value1")
        final Builder sample = builder -> builder.startObject().field("搜索", 2).field("指数", 3).endObject();
 * The OpenSearch Contributors require contributions made to
            .endObject()
            .endArray()
            .endObject()
        testFilter(expected, SAMPLE, singleton("**"), emptySet());
            .startObject()
            .field("name", "The Book Shop")
            .endObject();
            .startObject()
            .field("name", "address #2")
    }
            .endArray()
            .endObject()
            .nullField("default")
            .startObject("language")
            .startObject()
        testFilter(expected, SAMPLE, Sets.newHashSet("title", "pages"), emptySet());
            .endObject()
            .field("city", "Paris")
        final Builder expected = SAMPLE;
            .field("timestamp", 1428582942867L)
        .field("weight", 0.8d)
            .endArray()
    @FunctionalInterface
        .endArray()
            .startArray("distributors")
 */
            .startArray("addresses")
            .field("city", "Stornoway")
        // Test: Array of values (with filtering)
            .endObject()
            .startObject()
        .field("name", "The Book Shop")
            .startArray("tags")
            .field("name", "address #1")
            .startArray("addresses")
            .field("city", "London")
            .endArray()
            .startObject()
            .endArray()
            .startObject()
            .field("weight", 0.8d)
            .endObject()
        testFilter(expected, SAMPLE, singleton("pr*"), emptySet());
            .endObject()
            .startObject()
            .startArray("authors")
        .startObject()
        final Builder expected = builder -> builder.startObject()
     */
            .startObject("language")
            .field("weight", 0.8d)
        .endObject()
            .endObject()
    /**
            .endArray()
            .value("java")
import org.opensearch.common.CheckedFunction;
        testFilter(expected, sampleArrayOfObjects, emptySet(), singleton("t*.lastname"));
        .field("name", "address #2")
        .field("name", "La Maison du Livre")
            .endObject()
            .field("pages", 456)
            .startArray("distributors")
    }
    }
        testFilter(expected, SAMPLE, includes, excludes);
            .field("street", "Queen St")
            .startObject()
            .endArray()
            .endArray()
            .endObject()
            .startArray("path2")
            .startArray("distributors")
            .field("price", 27.99)
            .startObject()
            .startObject()
    public void testFilterSupplementaryCharactersInPaths() throws IOException {
            .endArray()
            .field("name", "Sussex Books House")
            .endObject()
        testFilter(expectedRawFieldFiltered, sampleWithRaw, emptySet(), singleton("r*"));
            .endObject();
            .field("lang", "English")
    }
            .field("city", "Paris")
            .endObject()
        .field("name", "Thetra")
            .endArray()
            .endObject()
            .endObject()
            .startArray("authors")
            .endArray()
            .startObject()
        testFilter(expectedRawFieldFiltered, sampleWithRaw, singleton("f*"), emptySet());
            .endObject()
    }
            .startObject()
            .startObject()
            .endArray()
            .startObject()
        expected = builder -> builder.startObject().field("test1", "value1").endObject();
            .field("name", "William Smith")
            .startObject("properties")
    public void testRecurseField4Exclusive() throws Exception {
            .startArray("addresses")
        testFilter(expected, complex, singleton("path1"), emptySet());
 * compatible open source license.
            .startObject()
        final Builder expected = builder -> builder.startObject().field("title", "My awesome book").endObject();
            .startObject()
            .value("java")
            .startObject()
    public void testSimpleArrayOfObjectsPropertyExclusive() throws Exception {
            .endObject()
            .field("street", "Hampton St")
            .endObject()
        testFilter(expected, SAMPLE, singleton("authors.*"), emptySet());
            .startObject()
        final Builder sample = builder -> builder.startObject().startObject("foo").field("bar", "baz").endObject().endObject().lfAtEnd();
            .field("street", "Rue Mouffetard")
            .field("available", false)
            .startObject("language")
            .field("firstname", "Doe")
            .endObject()
        // Test method: rawField(String fieldName, InputStream content)
            .endObject();
            .startArray("distributors")
        .startObject("properties")
        testFilter(expected, SAMPLE, singleton("properties.**.distributors.name"), emptySet());
            .endObject()
            .endArray()
     * Generalization of {@link XContentMapValuesTests#testPrefix()}
            .field("price", 27.99)
            .endObject();
            .startObject()
            .endObject();
import org.opensearch.core.xcontent.XContentBuilder;
        .endObject()
            .startObject()
            .startObject("language")
            .endArray()
        .field("street", "Rue Mouffetard")
        .field("street", "Queen St")
        Set<String> includes = singleton("**.distributors");
        testFilter(expected, complex, singleton("path1.path2.*"), emptySet());
    public void testObjectsInArrayWithBothExcludesIncludes() throws IOException {
        .startArray("distributors")
        .startObject("properties")
            .field("name", "address #2")
            .endObject()
            .value("java")
    public void testSimpleArrayExclusive() throws Exception {
            BytesReference raw = BytesReference.bytes(
        testFilter(expected, sample, singleton("f*"), singleton("baz"));
import org.opensearch.common.util.set.Sets;
            .field("weight", 0.8d)
            .endObject();
            .startObject("properties")
     */
            .endObject()
            .startObject()
            .endObject()
            .field("name", "La Maison du Livre")
            .field("name", "address #1")
            .field("available", false)
        .endObject()
        .field("available", false)
    public void testSingleFieldWithBothExcludesIncludes() throws IOException {
        .endObject()
            .field("name", "address #1")
            .field("street", "Queen St")
            .field("city", "Stornoway")
        testFilter(expected, SAMPLE, singleton("properties.**.name"), emptySet());
            .startArray("tags")
            .endObject()
            .startArray("distributors")
            .endObject()
            .field("firstname", "Doe")
        .value("opensearch")
            .field("city", "Paris")
            .startObject()
    public void testRecursiveObjectsPropertiesWithBothExcludesIncludes() throws IOException {
            .startObject()
        .startObject()
        Builder expected = builder -> builder.startObject().field("搜索", 2).endObject();
        testFilter(expected, sample, emptySet(), singleton("test1"));
        testFilter(expected, sample, singleton("bar"), emptySet());
import org.opensearch.test.OpenSearchTestCase;
            .startObject()
            .startObject()
            .endArray()
            .field("street", "Rue Mouffetard")
            .field("lang", "French")
            .endObject()
 * Modifications Copyright OpenSearch Contributors. See
        testFilter(expected, SAMPLE, emptySet(), singleton("title"));
        .startArray("authors")
            .startObject()
            .endObject();
            .field("city", "London")
            .startObject("en")
    public void testEmptyObject() throws IOException {
            .endArray()
            .field("city", "Paris")
            .field("street", "Rue Mouffetard")
        final Builder expected = builder -> builder.startObject()
            .field("street", "Queen St")
        .startObject()
            .startArray("distributors")
            .startObject()
        .endArray()
            .field("name", "La Maison du Livre")
        final Builder expected = builder -> builder.startObject().endObject();
            .value("opensearch")
            .endObject()
            .endObject()
            .startObject("raw")
    }
            .endObject()
        .endObject()
        testFilter(expectedRawField, sampleWithRaw, emptySet(), emptySet());
            .field("name", "The Book Shop")
            .field("city", "London")
        .startObject("language")
            .startArray("authors")
    public void testRecurseField1Exclusive() throws Exception {
                XContentBuilder.builder(builder.contentType().xContent()).startObject().field("content", "hello world!").endObject()
            .startArray("distributors")
            .endArray()
        .endArray()
            .field("city", "Stornoway")
        final Builder expected = builder -> builder.startObject()
        .field("available", false)
        .endArray()
            .field("firstname", "Smith")
        .endArray()
}
            .field("timestamp", 1428582942867L)
            .endArray()
            .endObject()
    }
            .field("available", true)
        .startArray("distributors")
        .field("name", "La Maison du Livre")
            .startObject()
            .endObject()
        final Builder expected = builder -> builder.startObject()
            .endArray()
            .startArray("distributors")
            .endObject()
            .startObject()
            .nullField("default")
            .field("city", "Paris")
        final Builder expected = builder -> builder.startObject().field("title", "My awesome book").field("pages", 456).endObject();
            .field("lastname", "William")
            .endArray()
            .field("pages", 456)
    public void testMultipleFieldsExclusive() throws Exception {
            .endObject();
    public void testBasics() throws Exception {
        testFilter(expectedRawField, sampleWithRaw, emptySet(), emptySet());
            .field("name", "address #2")
        final Builder expected = builder -> builder.startObject()
        testFilter(expected, SAMPLE, singleton("authors.*name"), emptySet());
            .field("test", "value2")
            .endObject();
            .startArray("tags")
            .startObject("properties")
            .value("opensearch")
            .value("opensearch")
            .field("city", "London")
            .startObject()
        testFilter(expected, sample, singleton("foobar"), emptySet());
 */
        final Builder expected = builder -> builder.startObject()
        .endObject()
        final Builder expected = builder -> builder.startObject()
        .startArray("tags")
    public void testNoFiltering() throws Exception {
            .endObject()
            .nullField("default")
            .startObject("fr")
        .nullField("default")
            .endArray()
            .field("title", "My awesome book")
 * GitHub history for details.
            .field("name", "Sussex Books House")
            .startObject("fr")
            .field("pages", 456)
    }
        .field("weight", 0.8d)
        .endObject()
        // Test: Array of objects (with partial filtering)
        .field("price", 27.99)
            .endArray()
            .startObject()
            .endObject()
            .endObject()
        .field("pages", 456)
            .value("java")
        testFilter(expectedRawFieldFiltered, sampleWithRaw, singleton("f*"), emptySet());
            .startObject("en")
            .field("lang", "French")
            .startArray("addresses")
            .field("name", "William Smith")
            .field("lang", "English")
            .field("name", "William Smith")
            .endArray()
            .startArray("addresses")
            .endArray()
            .startArray("distributors")
            .startArray("authors")
        .startArray("addresses")
            .field("title", "My awesome book")
            .startObject("properties")
            .startObject()
            .field("name", "John Doe")
            .startObject()
            .field("price", 27.99)
            .endObject()
            .startObject()
        .startObject()
            .field("street", "Queen St")
            .field("something_else", "value3")
            .startArray("tags")
            .field("price", 27.99)
        .field("pages", 456)
            .endObject()
        testFilter(expected, SAMPLE, emptySet(), singleton("**"));
            .field("street", "Rue Mouffetard")
            .endObject()
            .field("firstname", "Smith")
        testFilter(expected, sampleArrayOfObjects, emptySet(), singleton("t*"));
        .field("name", "address #1")
            .endObject()
    }
        testFilter(expected, sample, emptySet(), singleton("foo"));
            .endObject()
        .startArray("tags")
        testFilter(expected, sampleArrayOfValues, emptySet(), singleton("t*"));
            .field("lang", "French")
        Set<String> excludes = singleton("**.distributors");
        final Builder expected = builder -> builder.startObject().field("pages", 456).field("price", 27.99).endObject();
            .endArray()
            .field("lang", "French")
            .startObject("properties")
            .field("name", "address #1")
            .endObject()
/*
            .field("street", "Hampton St")
            .field("lastname", "John")
        expected = builder -> builder.startObject().field("test2", "value2").field("something_else", "value3").endObject();
            .field("name", "address #1")
            .field("name", "John Doe")
        .field("city", "London")
            .startArray("authors")
            .endArray()
            .field("name", "La Maison du Livre")
    /**
            .endObject()
        .value("java")
            .endArray()
            .startObject()
        final Builder expected = builder -> builder.startObject()
            .endObject()
            .endObject()
        testFilter(expected, complex, singleton("path1*"), emptySet());
        final Builder expected = builder -> builder.startObject()
            .endArray()
            .field("title", "My awesome book")
            .field("city", "Stornoway")
 * license agreements. See the NOTICE file distributed with
            .endObject()
            .field("available", true)
        // Test: Array of values (no filtering)
        final Builder expected = builder -> builder.startObject()
            .field("name", "Thetra")
            .startObject()
        .field("city", "Stornoway")
    }
            .endArray()
            .field("lang", "French")
            .field("firstname", "Doe")
            .endObject()
            .endObject();
            .startObject()
            .startObject("path1")
            .startObject()
import org.opensearch.core.xcontent.XContent;
            .endObject()
        testFilter(expected, SAMPLE, emptySet(), singleton("authors.l*"));
            .field("firstname", "ipsum")
            .field("street", "Hampton St")
        .endArray()
            .field("firstname", "Doe")
    }
            .field("content", "hello world!")
            .endArray()
            .startArray("tags")
    }
        testFilter(sampleArrayOfValues, sampleArrayOfValues, emptySet(), singleton("a"));
            .field("name", "William Smith")
            .endArray()
            .endObject()
        testFilter(expectedRawFieldFiltered, sampleWithRaw, emptySet(), singleton("r*"));
            .startObject("en")
            .startObject("path1")
            .endArray()
        .endObject();
            .value("lorem")
        testFilter(expected, SAMPLE, singleton("authors"), emptySet());
            .endArray()
            .startObject("en")
    public void testSimpleArrayInclusive() throws Exception {
        .startObject("fr")
        .field("lang", "English")
        final Builder expected = builder -> builder.startObject()
            .endObject()
        .startObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testNoMatch() throws Exception {
        Set<String> excludes = singleton("authors.name");
            .startObject()
            .startObject()
        testFilter(expected, SAMPLE, singleton("**.name"), emptySet());
            .startArray("tags")
            .endObject();
            .field("name", "address #1")
