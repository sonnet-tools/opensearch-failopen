            .field("firstname", "Smith")
            .field("name", "John Doe")
    public void testMultipleFieldsInclusive() throws Exception {
            .value("opensearch")
            .field("street", "Hampton St")
            .startObject()
            .field("name", "Sussex Books House")  
            .field("price", 27.99)
            .endObject()  
        final Builder expected = builder -> builder.startObject().endObject();
            .endArray()  
            .startObject()
            .field("city", "London")
     * Generalization of {@link XContentMapValuesTests#testSharedPrefixes()}
import static java.util.Collections.emptySet;
    }  
        final Builder expected = builder -> builder.startObject()
        final Builder expected = builder -> builder.startObject()
            .field("city", "Paris")
            .field("price", 27.99)
    public void testRecursiveObjectsPropertiesWithBothExcludesIncludes() throws IOException {  
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, emptySet(), singleton("f*"));  
            .endObject()
            .startObject("properties")  
            .startObject()
        .nullField("default")
    }  
            .field("weight", 0.8d)
        .startArray("authors")
            .endObject()
            .startObject("language")  
        .endObject()  
            .nullField("default")
            .startObject("en")
            .startObject()
            return builder.startObject().field("foo", 0).rawField("raw", raw.streamInput()).endObject();
            .field("street", "Queen St")
            .value("lorem")
            .field("lastname", "John")
        // Test: Array of objects (no filtering)
            .field("street", "Rue Mouffetard")  
        .endObject();
            .endObject()
            .field("lastname", "William")  
            .field("name", "address #1")
        final Builder sample = builder -> builder.startObject().array("photos", "foo", "bar").field("photosCount", 2).endObject();
        testFilter(expected, SAMPLE, emptySet(), singleton("**.name"));
            .field("timestamp", 1428582942867L)
            .startArray("distributors")  
            .nullField("default")
            .field("timestamp", 1428582942867L)
        .endArray()
        final Builder sample = builder -> builder.startObject().field("搜索", 2).field("指数", 3).endObject();  
            .endObject()
            .startArray("addresses")
 * specific language governing permissions and limitations
            .field("lang", "English")
            .startObject()  
            .startObject("language")
            .endObject()
            .startObject()  
            .startArray("tags")
    public void testSimpleArrayOfObjectsExclusive() throws Exception {  
            .startObject()  
        .field("city", "Stornoway")
import org.opensearch.core.common.bytes.BytesReference;  
            .startArray("authors")
        // more complex object...  
            .field("name", "John Doe")
            .endArray()  
            .field("name", "John Doe")
     * Generalization of {@link XContentMapValuesTests#testPrefix()}
            .startObject()  
            .endObject();
 * under the License.  
            .endObject()  
            .field("name", "address #1")  
            .endObject()
        testFilter(expected, sample, emptySet(), singleton("foo"));  
            .value("java")
            .startObject()
            .endObject()
        .startObject()  
    public void testRecurseField4Inclusive() throws Exception {  
            .endObject()
    }
            .endObject()  
            .value("dolor")  
        .field("available", true)  
            .field("lang", "English")
        // Test: Array of objects (with filtering)
            .startObject()  
            .field("title", "My awesome book")
        testFilter(sample, sample, singleton("foo"), emptySet());
            .startObject()
    }  
            .field("firstname", "Smith")  
            .endObject()  
            .startObject("language")  
            .endObject();
        .startObject("fr")
            .field("available", false)
        final Builder expected = builder -> builder.startObject()
            .endObject()  
 */
            .field("name", "address #2")
            .field("firstname", "Smith")
            .endObject()
        testFilter(expected, sample, singleton("test1"), emptySet());
            .field("firstname", "Smith")
            .startArray("distributors")
            .field("name", "La Maison du Livre")  
            .endObject()
        .endObject()
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field("firstname", "Doe")
            .startObject()
            .endObject()  
        testFilter(expected, complex, singleton("path1"), emptySet());  
        .startObject("properties")
        testFilter(expected, sampleArrayOfObjects, singleton("t*.firstname"), emptySet());
        final Builder complex = builder -> builder.startObject()
    }
 *
            .endObject()
            .field("available", true)  
            .endObject()
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, singleton("r*"), emptySet());
            .endObject()
            .startObject("properties")
            .startObject()
            .startObject()
        testFilter(sampleArrayOfValues, sampleArrayOfValues, emptySet(), singleton("a"));
            .value("java")
            .endArray()  
            .endObject()
        testFilter(expectedRawField, sampleWithRaw, emptySet(), emptySet());
            .startObject("en")  
        testFilter(expected, sample, emptySet(), singleton("bar"));
            .startObject()  
            .field("name", "La Maison du Livre")  
        final Builder expected = builder -> builder.startObject()
            .endObject()
            .endObject();  
            .startObject("properties")
        .startObject("language")  
        testFilter(expected, SAMPLE, singleton("*"), emptySet());
            .endArray()
     */
            .startObject()  
        Builder expected = builder -> builder.startObject().endObject();
        .startObject()
            .endObject()  
        Set<String> includes = singleton("**.en.*");
        .endObject()  
            .endArray()
            .endObject()
            .field("firstname", "Smith")  
            .startObject()
        .field("lastname", "John")
            .field("city", "Stornoway")  
            .field("name", "Thetra")
        Set<String> includes = singleton("**.distributors");
    }
            .field("lastname", "John")
            .endArray()
            .startArray("tags")
            .endArray()  
            .field("test", "value2")
        .endObject()
            .field("lang", "English")
            .value("opensearch")
            .startArray("distributors")  
            .field("name", "address #1")
            .startObject("fr")
        .endArray()
            .startObject()
        .startObject()
            .startObject()
 * SPDX-License-Identifier: Apache-2.0
        final Builder expectedRawFieldFiltered = builder -> builder.startObject().field("foo", 0).endObject();
        .field("city", "London")  
            .startObject()
            .field("name", "The Book Shop")
    /**  
            BytesReference raw = BytesReference.bytes(
            .startObject("en")
        testFilter(sampleArrayOfValues, sampleArrayOfValues, singleton("tags"), emptySet());
            .endObject()
        testFilter(expected, sample, singleton("test*"), emptySet());
            .startObject()
            .endObject()
            .startObject()  
    public void testRecurseField1Exclusive() throws Exception {
    }  
        testFilter(expected, SAMPLE, singleton("authors"), emptySet());
    }  
            .startArray("addresses")
        testFilter(expected, sample, singleton("f*"), singleton("baz"));  
        testFilter(expected, SAMPLE, emptySet(), singleton("xyz"));
            .endArray()
import org.opensearch.test.OpenSearchTestCase;  
        testFilter(sampleArrayOfValues, sampleArrayOfValues, singleton("t*"), emptySet());  
        .startArray("distributors")
            .field("lang", "French")
        final Builder expected = builder -> builder.startObject().field("title", "My awesome book").endObject();
        testFilter(expected, SAMPLE, singleton("xyz"), emptySet());
            .field("street", "Rue Mouffetard")
        .startObject("en")
            .endObject()  
            .startArray("authors")
    public void testSimpleFieldInclusive() throws Exception {  
        final Builder expected = builder -> builder.startObject().endObject().lfAtEnd();
        testFilter(expected, sampleArrayOfValues, emptySet(), singleton("t*"));
        testFilter(expected, sample, singleton("搜索"), emptySet());  
            .startObject("fr")
            .endObject()
            .field("city", "London")
            .field("content", "hello world!")  
            .endObject()
            .field("city", "Stornoway")
 * Tests for {@link XContent} filtering.  
        .field("timestamp", 1428582942867L)
        testFilter(expected, SAMPLE, emptySet(), singleton("title"));  
            .endObject()  
            .value("opensearch")
            .startObject()  
            .startObject("properties")
            .startObject("fr")
            .startArray("addresses")
            .startObject()
            .endArray()
            .startArray("addresses")
            .field("lastname", "John")
        .endObject()
            .field("something_else", "value3")  
            .startObject()
            .endObject()  
            .startObject()
 */  
            .endObject();
            .startArray("addresses")
    }  
        .field("price", 27.99)
            .field("street", "Queen St")  
        .endObject();
            .startObject()
            .field("name", "Thetra")  
            .endArray()  
            .field("content", "hello world!")
            .field("firstname", "Smith")
            .startObject()
            .field("name", "Sussex Books House")  
            .field("street", "Queen St")
            .startArray("tags")  
            .field("street", "Hampton St")
            .endArray()
        testFilter(expected, SAMPLE, includes, excludes);
            .startObject("language")  
            .endArray()  
            .endObject()
        testFilter(expectedRawFieldFiltered, sampleWithRaw, singleton("f*"), emptySet());
            .field("city", "Stornoway")
        .startArray("distributors")
            .startArray("path2")
            .startObject()
            .field("lastname", "John")
        .startObject()  
            .value("opensearch")  
            .field("name", "address #2")  
            .value("java")
        testFilter(sampleArrayOfObjects, sampleArrayOfObjects, emptySet(), singleton("a"));
            .field("name", "address #1")  
            .endObject();
            .field("firstname", "Smith")
            .field("lang", "English")
            .field("name", "John Doe")
            .field("street", "Hampton St")
     * Generalization of {@link XContentMapValuesTests#testSupplementaryCharactersInPaths()}  
            .endArray()
            .field("lang", "French")  
            .startObject()
        .field("name", "William Smith")  
        testFilter(expected, SAMPLE, emptySet(), emptySet());
            .endObject()  
            .field("city", "Stornoway")
            .startObject()  
        .endArray()
import org.opensearch.core.xcontent.XContent;
            .startObject()
        .startObject()
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors.*name"));  
        final Builder expected = builder -> builder.startObject()
        final Builder expected = builder -> builder.startObject()  
    }
            .field("name", "address #1")
        final Builder sampleArrayOfObjects = builder -> builder.startObject()
            .field("test", "value1")
            .field("lang", "French")
            .startObject()
    protected static final Builder SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE = builder -> builder.startObject()  
            .endObject()
            .startArray("distributors")
            .startArray("addresses")
            .endArray()
        expected = builder -> builder.startObject()
    public void testFilterSupplementaryCharactersInPaths() throws IOException {
            .endArray()
            .field("available", true)  
            .endArray()  
        .field("street", "Hampton St")
        testFilter(expected, sample, emptySet(), singleton("test1"));
            .endObject()
import java.util.Set;  
            .startArray("distributors")
            .field("name", "La Maison du Livre")
        final Builder expected = builder -> builder.startObject()  
            .field("street", "Rue Mouffetard")
            .field("name", "William Smith")  
            .field("name", "Sussex Books House")
 */
            .field("name", "The Book Shop")
            .field("available", false)
            .endObject()  
        .field("lang", "French")
            .startArray("addresses")
            .startObject("language")  
        testFilter(expectedRawFieldFiltered, sampleWithRaw, emptySet(), singleton("r*"));
            .field("name", "address #2")
            .startObject()
        final Builder sample = builder -> builder.startObject().startObject("foo").field("bar", "baz").endObject().endObject().lfAtEnd();
            .endObject()
        testFilter(sample, sample, singleton("f*"), singleton("baz"));  
            .field("pages", 456)
            .field("lastname", "William")
        testFilter(expected, SAMPLE, includes, excludes);  
            .startObject("raw")
        .field("name", "La Maison du Livre")  
            .endArray()  
            .field("name", "Thetra")
            .endObject()
        expected = builder -> builder.startObject().field("test1", "value1").field("test2", "value2").endObject();  
    public void testEmptyObject() throws IOException {  
            .startObject()
            .endArray()
            return builder.startObject().field("foo", 0).rawField("raw", raw.streamInput()).endObject();
            .startArray("addresses")
            .field("timestamp", 1428582942867L)
        final Builder sample = builder -> builder.startObject()  
        testFilter(expected, sampleArrayOfObjects, emptySet(), singleton("tags"));
        .field("street", "Hampton St")
            .startArray("authors")  
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, singleton("r*"), emptySet());  
            .endObject()
            .endObject()  
        .field("title", "My awesome book")
            .field("title", "My awesome book")
            .nullField("default")
 */  
            .endObject()
            .startObject("en")
            .startObject("properties")
        // Test method: rawField(String fieldName, InputStream content)
        .endArray()
        testFilter(expected, SAMPLE, singleton("authors.l*"), emptySet());
            .endObject()  
        // Test: Array of values (with filtering)
        testFilter(expected, SAMPLE, singleton("**.name"), emptySet());
    public void testRecurseField1Inclusive() throws Exception {
            .field("available", true)
            .endObject()
     */  
            .field("name", "address #1")
            .field("name", "Thetra")
            .startArray("addresses")  
            .startObject()
            .startArray("addresses")
            .endObject();
        Set<String> excludes = singleton("authors.name");
            .startObject()  
    public void testRawField() throws Exception {  
            .field("firstname", "Doe")  
        final Builder expected = builder -> builder.startObject()  
            .endObject()  
            .startArray("distributors")
            .field("name", "William Smith")
            .field("available", false)  
            .startObject()
            .field("firstname", "Doe")
            .field("street", "Hampton St")
            .endObject()  
    protected abstract void testFilter(Builder expected, Builder actual, Set<String> includes, Set<String> excludes) throws IOException;
    public void testSimpleArrayOfObjectsPropertyExclusive() throws Exception {
            .endObject()
            .field("lastname", "John")
            .startObject("fr")
        Builder expected = builder -> builder.startObject().field("test1", "value1").endObject();  
            .startObject("language")  
import java.io.IOException;
            .endObject()
            .field("lang", "English")
            .startObject("properties")
            .startObject()
            .endObject()
        testFilter(expected, SAMPLE, includes, excludes);
        .field("lang", "English")
        .field("city", "London")
    }
            .field("weight", 0.8d)
            .endObject();
            .endObject()
            .endObject()
            .startObject()
            .endObject()
            .field("weight", 0.8d)
            .field("lastname", "William")
        .value("java")
            .endObject()
        .startObject()
    }
        .endObject()  
            .endArray()
    }  
            .field("city", "Paris")
            .endArray()  
            .startArray("tags")
        .endObject()
            .endObject()  
        .startObject()
            .startObject()
        .startObject()
            .startObject("properties")
 * not use this file except in compliance with the License.
/*  
    public void testRecurseField3Exclusive() throws Exception {
        .field("firstname", "Smith")
            .field("name", "Sussex Books House")
        .value("java")  
            .field("lang", "French")  
            .endObject()
            .endObject();
            .startObject()  
            .startObject()
        .endObject()  
        Builder expected = builder -> builder.startObject().field("photosCount", 2).endObject();
        .endObject()
            .startObject("properties")
        };  
            .endArray()  
            .field("lastname", "William")  
            .field("street", "Queen St")
        final Builder expected = builder -> builder.startObject().field("title", "My awesome book").field("pages", 456).endObject();  
            .endObject()  
            .field("available", true)
            .endObject()
            .endObject();
            .endObject()  
            .endObject()
        testFilter(expected, sampleArrayOfObjects, singleton("foo"), emptySet());
            .endObject()  
        final Builder expected = builder -> builder.startObject()
            .endArray()  
            .startObject("properties")
            .startObject("fr")
    public void testNoFiltering() throws Exception {
            .field("lang", "English")
            .value("java")
            .endObject();
            .endObject()
            .field("lastname", "John")
        .nullField("default")  
        final Builder expected = builder -> builder.startObject()
        Builder expected = builder -> builder.startObject().startObject("foo").endObject().endObject();  
            .field("price", 27.99)
            .field("price", 27.99)
        testFilter(expected, sampleArrayOfObjects, emptySet(), singleton("t*.lastname"));  
        .startArray("distributors")
            .field("city", "London")  
            .endObject()  
            .startArray("tags")  
            .field("city", "London")
            .startArray("tags")
            .startObject("en")
            .value("opensearch")
            .field("lastname", "John")  
            .field("city", "Stornoway")
            .endArray()
            .endArray()  
        .field("street", "Rue Mouffetard")
            .field("name", "John Doe")  
            .field("firstname", "Doe")
        .field("firstname", "Doe")  
            .startObject()
            .endObject()  
            .startArray("tags")  
            .field("name", "address #1")
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
            .field("available", false)  
            .startObject()
            .field("name", "William Smith")
            .field("timestamp", 1428582942867L)  
            .endObject()
            .startArray("tags")  
            .endObject()
            .field("weight", 0.8d)
            .field("pages", 456)
        .field("name", "address #2")
            .startObject()  
            .field("name", "John Doe")
            .field("street", "Queen St")  
            .field("city", "Paris")
            .endObject()  
            .field("name", "Sussex Books House")  
 * compatible open source license.
            .field("pages", 456)
            .endArray()
        testFilter(expectedRawFieldFiltered, sampleWithRaw, emptySet(), singleton("r*"));
            .field("name", "address #2")
        .field("name", "Thetra")
        final Builder expected = builder -> builder.startObject()  
            .startObject()
            .field("name", "address #1")  
            .endObject()
        testFilter(expected, sample, emptySet(), singleton("foobar"));
    public void testRecursiveObjectsInArrayWithBothExcludesIncludes() throws IOException {
    }  
            .endObject()
 * license agreements. See the NOTICE file distributed with
            .startObject()
            .endObject()
        .field("lang", "French")  
            .endArray()  
            .field("available", true)  
            .endObject()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .endObject()  
            .endObject()  
            .endArray()
            .startObject("language")
            .startArray("addresses")
            .startObject()
            .startObject()  
        expected = builder -> builder.startObject()  
            .startArray("distributors")
            .field("price", 27.99)  
        Set<String> includes = Sets.newHashSet("**.language", "properties.weight");  
            .startObject()  
 * the Apache License, Version 2.0 (the "License"); you may
        testFilter(expectedRawFieldNotFiltered, sampleWithRaw, emptySet(), singleton("f*"));
            .endObject();
        .field("city", "Paris")
            .field("name", "address #2")
        Set<String> includes = Sets.newHashSet("tags", "authors");  
        .endObject()
            .endObject()  
            .field("price", 27.99)  
            .field("name", "address #1")  
            .field("city", "Paris")
    }  
            .field("city", "Paris")
        testFilter(expected, sampleArrayOfValues, emptySet(), singleton("tags"));
            .field("name", "address #2")  
            .endObject()
            .field("city", "Stornoway")  
            .endObject()
    public void testArrays() throws Exception {  
        .startArray("addresses")
            .endObject()  
            .field("name", "Sussex Books House")
            .endObject()  
        .endObject()
            .startObject()  
            .startObject("path1")
            .startArray("distributors")  
            .field("name", "William Smith")
            .field("street", "Hampton St")  
        .field("title", "My awesome book")
            .startObject("properties")
            .startObject()  
            .field("name", "Thetra")  
        .field("name", "La Maison du Livre")
            .endArray()  
            .endArray()
            .endArray()
    }
            .startObject()
            .field("city", "London")  
            .startObject()
            .startObject()  
            .startObject()  
            .startObject("language")  
            .startArray("distributors")
        expected = builder -> builder.startObject().field("test2", "value2").field("something_else", "value3").endObject();  
            .endObject()
public abstract class AbstractFilteringTestCase extends OpenSearchTestCase {
            .field("firstname", "Smith")  
            .field("name", "Thetra")
        testFilter(expected, SAMPLE, emptySet(), singleton("properties.**.distributors.name"));  
            .endObject()
            .endObject()
            .field("lang", "French")
            .field("firstname", "Doe")
            .startObject()  
            .startObject()
    public void testObjectsInArrayWithBothExcludesIncludes() throws IOException {
            .startObject("en")
        final Builder expected = builder -> builder.startObject()
            .endObject()
            .startObject()
            .startArray("authors")
            .startObject()
            .field("name", "address #1")  
            .field("lastname", "William")  
            .endObject()  
    }
            .startArray("addresses")
            .field("name", "Sussex Books House")
        testFilter(expected, complex, singleton("path1.path2.*"), emptySet());
            .field("price", 27.99)
            .endObject()
            .startArray("authors")
            .endObject()  
            .endObject()  
            .startObject("language")
        .endArray()  
        Set<String> excludes = singleton("**.distributors");
        testFilter(expected, complex, singleton("test1*"), emptySet());
        testFilter(sample, sample, emptySet(), singleton("bar"));
            .field("name", "The Book Shop")  
        .endObject()
            .field("weight", 0.8d)  
            .nullField("default")
        .startObject()  
        .endArray()  
            .field("city", "Stornoway")
            .startArray("authors")
            .field("city", "Paris")
    }
            .field("lastname", "William")
            .value("java")
 * KIND, either express or implied.  See the License for the
        testFilter(expected, SAMPLE, emptySet(), singleton("*"));
    public void testRecurseField2Inclusive() throws Exception {
            .startObject()
            .endObject();
        final Builder expected = builder -> builder.startObject()  
            .endObject()
            .field("firstname", "Doe")
        .endObject()
        .endObject()  
            .startArray("authors")  
 * Unless required by applicable law or agreed to in writing,
            .startObject()
    public void testSingleFieldWithBothExcludesIncludes() throws IOException {
        };
            .endObject()  
        .startArray("tags")  
        .endObject()
            .endArray()
            .value("java")
    public void testSimpleFieldWithWildcardInclusive() throws Exception {  
            .endArray()
            .field("test2", "value2")
        testFilter(expected, SAMPLE, emptySet(), singleton("properties.*.en.**.name"));  
        expected = builder -> builder.startObject().field("foobaz", 3).endObject();  
            .startObject()  
    protected interface Builder extends CheckedFunction<XContentBuilder, XContentBuilder, IOException> {}
            .field("name", "Sussex Books House")
        // Test: Array of objects (with partial filtering)  
            .endObject();
        .field("available", false)  
            .startObject()  
    /** Sample test case **/  
        final Builder expected = builder -> builder.startObject()
        expected = builder -> builder.startObject().field("test1", "value1").endObject();
            .startArray("authors")
            .field("name", "William Smith")  
        testFilter(expected, SAMPLE, emptySet(), singleton("authors.lastname"));  
        .field("weight", 0.8d)  
            .startObject("fr")  
            .endObject()  
            .startObject("properties")
            .field("name", "John Doe")  
            .startObject()
            .endObject()  
        .startArray("addresses")
            .field("street", "Queen St")  
            .field("name", "La Maison du Livre")
            .startObject("properties")  
            .startObject()  
            .startArray("tags")
            .startArray("distributors")
            .endArray()
            .endObject()
        .field("name", "address #1")  
            .endObject()  
            .startObject("en")  
            .endObject()
            .endObject()
            .startObject()
                XContentBuilder.builder(builder.contentType().xContent()).startObject().field("content", "hello world!").endObject()  
            .field("name", "William Smith")
            .field("name", "The Book Shop")  
            .field("lang", "French")
            .endArray()
            .startObject("language")  
            .startObject()
/*  
            .startObject()
        .startArray("addresses")
        testFilter(expected, SAMPLE, emptySet(), singleton("authors.l*"));
            .field("name", "The Book Shop")
    public void testSimpleArrayInclusive() throws Exception {
            .startArray("addresses")
            .startArray("distributors")
            .endObject()
            .endObject()
            .endObject()  
            .field("name", "John Doe")
        .field("name", "address #1")
    @FunctionalInterface
            .field("name", "La Maison du Livre")  
        Set<String> excludes = singleton("**.distributors");  
            .field("name", "Thetra")
            .field("name", "Thetra")
            .nullField("default")
        // Test method: rawField(String fieldName, BytesReference content)
            .field("lastname", "William")
            .field("name", "La Maison du Livre")
            .startObject("properties")  
            .field("lang", "English")
            .value("java")
            .startObject()  
        final Builder expected = builder -> builder.startObject()
import org.opensearch.common.util.set.Sets;
            .endArray()
            .endObject()
        expected = builder -> builder.startObject().field("指数", 3).endObject();
        .field("name", "The Book Shop")
            .endObject();  
            .field("name", "John Doe")
            .endObject()
            .startObject()  
            .startArray("tags")  
            .field("name", "address #2")  
            .startObject()  
            .field("weight", 0.8d)
            .endObject()
            .endObject()  
            .startObject()  
            .endObject()  
            .startObject("en")
    /**
        Set<String> excludes = Sets.newHashSet("**.distributors.*.name", "**.street");
import org.opensearch.common.CheckedFunction;
            .startObject()
            .field("lastname", "lorem")
            .field("name", "La Maison du Livre")  
 * software distributed under the License is distributed on an
            .field("lastname", "William")
            .field("city", "London")  
}
    protected static final Builder SAMPLE = builder -> builder.startObject()
        .endArray()  
            .endArray()  
            .endArray()  
        testFilter(expected, sampleArrayOfObjects, emptySet(), singleton("t*"));  
            .endObject()  
            .endObject()
/*
    public void testBasics() throws Exception {
            );
            .endObject();
            .endArray()
            .endObject()  
        .endObject()  
            .field("timestamp", 1428582942867L)  
            .value("opensearch")  
            .field("lang", "French")  
        testFilter(expected, sample, singleton("bar"), emptySet());
            .endArray()
            .endObject()
            .endObject()  
            .endObject()
            .value("ipsum")
        testFilter(expected, complex, singleton("path1*"), emptySet());
    }  
        .field("city", "Paris")  
            .endObject()
            .endArray()
        .startObject()  
            .field("city", "Paris")
            .endObject()
            .field("street", "Hampton St")  
            .endObject()  
        testFilter(expected, SAMPLE, emptySet(), Sets.newHashSet("title", "pages"));
            .startObject("raw")  
            .endObject()
            .endObject();
    }
            .endObject()
            .field("name", "address #1")
    public void testSimpleFieldWithWildcardExclusive() throws Exception {
            .endArray()
            .startObject()
            .field("test", "value1")
            .startObject()
        Builder expected = builder -> builder.startObject().field("搜索", 2).endObject();
            .startArray("authors")  
        // Test: Array of values (no filtering)
            .startObject("en")
            .field("firstname", "ipsum")
            .field("available", true)  
            .startObject("properties")
            .startObject()
            .startObject()
    }
            .startArray("distributors")
            .endObject()
            .endObject();  
            .startObject("fr")
            .endObject();
        .field("name", "address #1")  
            .startObject()  
        testFilter(expected, SAMPLE, Sets.newHashSet("title", "pages"), emptySet());
            .field("name", "address #1")
        .startObject()  
    public void testSimpleArrayOfObjectsInclusive() throws Exception {  
            .field("title", "My awesome book")  
            .field("name", "address #1")
            .endArray()
 * GitHub history for details.
            .endArray()
            .field("street", "Rue Mouffetard")  
            .field("pages", 456)  
            .field("name", "Sussex Books House")  
            .field("test1", "value1")  
            .startObject()  
            .startObject()  
            .startObject()  
            .endArray()
            .endObject()  
        .startArray("tags")
        .field("name", "Sussex Books House")
            .startObject()
            .endArray()
            .startArray("tags")
            .field("city", "London")  
 * ownership. Elasticsearch licenses this file to you under  
            .startArray("authors")
        .field("street", "Queen St")  
            .field("street", "Rue Mouffetard")
            .startObject("fr")
            .field("lastname", "William")
            .endObject()
            .startArray("distributors")
            .nullField("default")
        testFilter(expected, SAMPLE, singleton("authors.lastname"), emptySet());  
            .startObject()  
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors"));
            .endObject()
            .startObject()
            .endArray()
            .startObject()  
    }
            .field("firstname", "Smith")  
            .endObject();  
            .endObject()
            .endObject()  
        final Builder expected = builder -> builder.startObject().field("pages", 456).field("price", 27.99).endObject();  
            .startObject("fr")
            .field("firstname", "Smith")
        .endObject()  
            .endArray()
            .field("lang", "French")
            .endArray()  
            .field("street", "Hampton St")
            .endObject()
            .endObject()
            .endArray()  
        .field("name", "Thetra")
            .value("opensearch")
/**
            .field("title", "My awesome book")
            .startObject("en")
            .endObject()
            .endObject()
        .field("timestamp", 1428582942867L)
            .endObject()  
            .field("name", "address #2")
        .field("name", "John Doe")
    }
            .field("name", "La Maison du Livre")
    }
            .startObject()
            .endArray()
            .startArray("distributors")  
        .startObject("fr")
            .field("timestamp", 1428582942867L)  
            .endObject()
        testFilter(expected, SAMPLE, singleton("properties.*.en.**.name"), emptySet());
    public void testRecurseField3Inclusive() throws Exception {  
    public void testSimpleFieldExclusive() throws Exception {  
            .field("available", true)  
            .startArray("addresses")
            .field("timestamp", 1428582942867L)
            .nullField("default")  
            .field("lastname", "John")  
        .field("available", false)
            .field("name", "The Book Shop")  
            .field("lastname", "John")
            .endObject()
            .endArray()  
            .field("test1", "value1")
            .startArray("authors")
            .field("firstname", "Doe")
            .endArray()
        .endObject()
            .endObject()
            .field("city", "Paris")  
            .startObject()  
            .field("title", "My awesome book")
            .endObject()
        testFilter(expectedRawFieldFiltered, sampleWithRaw, singleton("f*"), emptySet());  
            .field("available", false)  
            .endObject()
            .field("available", false)
            .field("available", false)
    }
            .endObject()
        final Builder expected = builder -> builder.startObject()
            .nullField("default")  
            .field("name", "Sussex Books House")  
        testFilter(expected, SAMPLE, singleton("p*"), singleton("properties"));
            .endObject()  
            .startObject()
    public void testFilterSharedPrefixes() throws IOException {  
        .field("name", "address #1")
            .endArray()  
            .field("name", "The Book Shop")  
            .field("lastname", "William")
            .startArray("addresses")
            .endObject()
        .endArray()
            .field("firstname", "Doe")
 * this work for additional information regarding copyright
            .field("firstname", "Doe")  
            .field("lang", "English")
            .endObject()
            .field("street", "Rue Mouffetard")
            .startObject("path1")
            .startArray("addresses")
            .endArray()
    }
            .endObject()
    public void testNoMatch() throws Exception {
            .endArray()
            .startArray("distributors")
            .startArray("distributors")
            .field("firstname", "ipsum")
            .field("name", "William Smith")
            .startObject()  
            .endObject()  
    }
            .endArray()
        testFilter(expected, SAMPLE, emptySet(), singleton("properties.**.name"));  
        final Builder expected = builder -> builder.startObject()  
        testFilter(expected, SAMPLE, emptySet(), singleton("tags"));  
            .startArray("distributors")  
            .endArray()
            .startArray("distributors")
            .startArray("distributors")
            .endObject();  
            .endObject()
            .endObject();  
            .field("pages", 456)
            .value("opensearch")  
            .startObject()
        .startObject("en")
            .endObject()  
        .startArray("distributors")
            .endObject()
 * Modifications Copyright OpenSearch Contributors. See
    }
            .field("lastname", "John")  
            .endObject()
            .startArray("distributors")
        testFilter(expected, SAMPLE, singleton("properties.**.distributors.name"), emptySet());
            .field("available", false)  
            .startObject()
            .endArray()  
 * Licensed to Elasticsearch under one or more contributor  
            .startArray("distributors")
            .endObject()
            .startObject()
            .startArray("addresses")
            .endObject()
            .startObject("fr")  
            .startArray("tags")  
        final Builder expected = builder -> builder.startObject().endObject();
 * You may obtain a copy of the License at  
        .startObject("properties")
            .field("name", "William Smith")
            .field("title", "My awesome book")  
            .startArray("addresses")
import org.opensearch.core.xcontent.XContentBuilder;
            .startObject()
            .endArray()
        testFilter(expected, SAMPLE, singleton("authors.*name"), emptySet());  
            .field("name", "address #1")  
            .endArray()
            .startArray("authors")  
            .startObject()
            .field("street", "Hampton St")
            .field("name", "John Doe")  
            .endObject()
            .endArray()  
            .endArray()
    public void testMultipleFieldsExclusive() throws Exception {
        testFilter(expected, SAMPLE, singleton("title"), emptySet());  
        .field("price", 27.99)  
            .endObject()
            .field("name", "address #1")  
            .endArray()  
            .startObject()
        testFilter(expected, sample, singleton("bar"), emptySet());
            .field("available", false)
            .endObject()  
        testFilter(expected, SAMPLE, emptySet(), singleton("pr*"));
            .endArray()
            .endArray()
    public void testSimpleArrayOfObjectsPropertyInclusive() throws Exception {  
            .field("city", "Stornoway")
        .field("pages", 456)
            .endObject()
package org.opensearch.common.xcontent.support;
            .startObject("en")  
            .field("lastname", "John")  
    }
            .field("name", "The Book Shop")
            .field("weight", 0.8d)
            .field("lang", "English")
            .field("available", true)  
            .startArray("addresses")  
        .startArray("addresses")
            .endObject()
    }  
            .endArray()
            .endObject();
            .startObject()  
            .endObject();
            .field("street", "Rue Mouffetard")
            .field("name", "The Book Shop")
            .startObject("properties")
        testFilter(expected, SAMPLE, singleton("tags"), emptySet());  
            .field("lang", "French")  
            .field("timestamp", 1428582942867L)  
        testFilter(expected, SAMPLE, singleton("**"), emptySet());  
            .value("java")  
        final Builder expected = builder -> builder.startObject()
            .endObject()
                XContentBuilder.builder(builder.contentType().xContent()).startObject().field("content", "hello world!").endObject()
            .startArray("distributors")
            .startObject("en")  
        .field("weight", 0.8d)
            .field("title", "My awesome book")  
            .field("foo", 0)
    /**
            .startObject("language")
            .endArray()
    public void testFilterPrefix() throws IOException {
        testFilter(expected, sample, emptySet(), singleton("foo"));  
        testFilter(sampleArrayOfObjects, sampleArrayOfObjects, singleton("t*"), emptySet());  
            .startObject("fr")  
            .field("lang", "French")
        Builder sampleWithRaw = builder -> {
            .field("city", "Paris")
    public void testWithLfAtEnd() throws IOException {
            .startArray("addresses")
        testFilter(expected, SAMPLE, emptySet(), singleton("**"));  
            .endArray()  
        final Builder expected = SAMPLE;
            .endObject()
            .field("weight", 0.8d)
            .field("lang", "English")  
        testFilter(expected, SAMPLE, includes, excludes);
            .endArray()  
            .endObject()
            .endArray()
        final Builder sampleArrayOfValues = builder -> builder.startObject()
            .startArray("distributors")  
    }  
        final Builder expected = builder -> builder.startObject()
            .endArray()  
            .startObject()
        expected = builder -> builder.startObject().endObject();
        testFilter(expected, sample, singleton("f*"), singleton("foo"));
        .field("street", "Rue Mouffetard")
            .startArray("addresses")
            .startObject()
            .startArray("distributors")
            .startObject("fr")
    }
            .field("timestamp", 1428582942867L)
        .field("name", "address #2")  
            .endArray()  
            .endObject()
        .endObject()  
        .endArray()
            .endObject()
            .endObject()  
        Builder expected = builder -> builder.startObject().field("foobar", 2).endObject();  
            .field("available", false)
            .startObject()  
            .endObject()
            .endObject()
            .field("city", "London")
            .endArray()
        testFilter(expected, sample, singleton("photosCount"), emptySet());
            .startObject()
            .endObject()
            .startObject()  
            .startObject("language")
            .field("name", "The Book Shop")  
        .value("opensearch")
        final Builder expectedRawFieldNotFiltered = builder -> builder.startObject()
            .field("name", "La Maison du Livre")  
            .startObject()  
            .field("name", "William Smith")
        .endObject()
            .field("test", "value2")
            .endObject();
    }
            .endObject()  
            .endObject()  
            .endObject()
            BytesReference raw = BytesReference.bytes(
            .startObject()
            .startArray("tags")
            .field("name", "William Smith")  
            .startObject()
        .field("city", "Stornoway")
            .startObject()
            .endObject()
        .field("available", true)
    public void testRecurseField2Exclusive() throws Exception {
            .value("opensearch")
            .startArray("distributors")
            .startArray("path2")  
            .endArray()
            .startArray("addresses")
            .startObject()
            .field("city", "London")
        .startObject("language")
        testFilter(expected, SAMPLE, singleton("pr*"), emptySet());
 *  
            .startObject()
            .endObject()
            .field("city", "Stornoway")
            .field("city", "London")
        testFilter(expectedRawField, sampleWithRaw, emptySet(), emptySet());  
            .field("available", true)
            .endObject()  
        .startObject()
        .endObject()  
            .value("java")  
 *
            .endObject()
            .endObject()
        testFilter(expected, SAMPLE, singleton("authors.*"), emptySet());
            .value("java")
            .field("firstname", "Doe")
            .field("pages", 456)
            .startArray("addresses")  
            .endObject()
        .endArray()
            .startArray("authors")  
            .endObject()
        .endObject()
            .endObject()
            .endObject()
            .field("street", "Rue Mouffetard")
            .startObject("en")
            .startObject()
            .endObject();  
            .field("price", 27.99)  
            .field("name", "address #1")  
        .field("lastname", "William")
            .endObject()
            .startObject()
        .field("pages", 456)  
            .endObject()
            .nullField("default")
        .endArray()  
        testFilter(expected, sampleArrayOfValues, singleton("foo"), emptySet());  
        .field("name", "The Book Shop")  
     */
        final Builder sample = builder -> builder.startObject().startObject("foo").endObject().endObject();
            .field("pages", 456)
            .startArray("distributors")
        .endObject()
        testFilter(expected, sample, singleton("f*"), singleton("foo"));
    public void testRecurseField4Exclusive() throws Exception {
            .startObject("language")  
            .endObject()  
            .endObject()
            .field("available", true)
        .endObject()
        .startObject()  
            .endArray()  
            .field("name", "address #1")  
            .field("lang", "English")  
            .endArray()  
            .endObject()  
            .endObject();
            .endObject();
        .field("name", "Sussex Books House")  
        .startObject()
            .field("name", "Thetra")
            .value("opensearch")  
    }
            .startObject()
            .endObject();
    public void testRecursiveSameObjectWithBothExcludesIncludes() throws IOException {
            .endObject()
        .value("opensearch")
            );  
            .endObject()  
            .startArray("addresses")
 * The OpenSearch Contributors require contributions made to  
            .endObject()  
            .endObject()  
        final Builder expected = builder -> builder.startObject()  
            .field("street", "Queen St")
        .startObject()  
    public void testSimpleArrayExclusive() throws Exception {  
        testFilter(expected, SAMPLE, singleton("properties.**.name"), emptySet());
            .endObject()
        testFilter(expected, sample, emptySet(), singleton("搜索"));  
            .field("weight", 0.8d)  
            .startObject("en")
            .endArray()
            .field("firstname", "Smith")
            .startObject("language")  
            .startObject("language")
        .field("street", "Queen St")
        testFilter(expected, sample, singleton("foo"), emptySet());
            .field("name", "address #2")
            .field("pages", 456)
            .field("city", "Stornoway")  
            .field("firstname", "Doe")  
            .field("street", "Queen St")
            .field("street", "Queen St")  
            .field("available", true)
            .field("street", "Rue Mouffetard")
import static java.util.Collections.singleton;  
            .startObject()
            .endArray()  
            .startObject()
        testFilter(sampleArrayOfObjects, sampleArrayOfObjects, singleton("tags"), emptySet());
            .startObject("fr")
            .endObject()
            .field("weight", 0.8d)
        sampleWithRaw = builder -> {  
            .field("price", 27.99)
            .endObject()
            .field("name", "address #1")  
            .field("lastname", "William")
        .field("lang", "English")  
            .field("street", "Hampton St")
        final Builder sample = builder -> builder.startObject().field("foobar", 2).field("foobaz", 3).endObject();
        .startObject()
    }
        testFilter(expected, sample, singleton("foobar"), emptySet());
            .startObject("en")
        testFilter(SIMPLE_ARRAY_OF_OBJECTS_EXCLUSIVE, SAMPLE, emptySet(), singleton("authors.*"));
        final Builder expectedRawField = builder -> builder.startObject()
            .startObject()
