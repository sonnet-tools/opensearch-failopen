        assertResult("{'d1':'07:59:23.123'}", () -> builder().startObject().timeField("d1", d2.toLocalTime()).endObject());  
        );
        XContentBuilder build() throws IOException;  
        generator.writeName("foo");  
    }
    }
        objects.put("{'objects':[{'lat':45.759429931640625,'lon':4.8394775390625}]}", new Object[] { GeoPoint.fromGeohash("u05kq4k") });
    public void testIntegers() throws IOException {  
            assertSame(parser.nextToken(), Token.FIELD_NAME);  
            () -> builder().startObject().array("short", new short[] { Short.MAX_VALUE, Short.MIN_VALUE }).endObject()
    }
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, os.toByteArray())  
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        object.put("{'object':13}", (byte) 13);
            generator.writeNull();
            }
            assertNull(parser.nextToken());
        }
        map.put("foo", 0);
import java.time.ZoneOffset;  
            generator.writeEndObject();  
        });
    }  
            assertEquals(Token.START_OBJECT, parser.nextToken());
        assertResult("{'y':null}", () -> builder().startObject().field("y", (Year) null).endObject());  
        );
        result = "{'bigdecimal':[" + bigDecimal.toString() + "," + bigDecimal.toString() + "," + bigDecimal.toString() + "]}";
                + "'childs':["  
            return builder;
            assertThat(new BytesRef(parser.charBuffer()).utf8ToString(), equalTo(random.utf8ToString()));
        final String paths = Constants.WINDOWS ? "{'iter':['a\\\\b\\\\c','c\\\\d']}" : "{'iter':['a/b/c','c/d']}";  
        mapA.put("a", 0);
            }  
            generator.writeEndObject();  
            assertResult(expected, () -> builder().startObject().field("map").map(m.getValue()).endObject());
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((LocalDate) null).endObject());
    }
            assertEquals(Token.END_OBJECT, parser.nextToken());
                .createParser(registry, LoggingDeprecationHandler.INSTANCE, BytesReference.bytes(b).streamInput())  
        assertResult("{'date':null}", () -> builder().startObject().field("date", (LocalDate) null).endObject());
    }
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((OffsetDateTime) null).endObject());  
import java.time.LocalTime;
            final String expected = o.getKey();
        final OffsetTime zonedOffsetTime = offsetTime.withOffsetSameLocal(ZoneOffset.ofHours(5));
        final int offset = randomIntBetween(0, randomBytes.length - 1);
import java.time.OffsetDateTime;
        assertResult("{'boolean':[]}", () -> builder().startObject().array("boolean", new boolean[] {}).endObject());  
        assertResult(expected, () -> builder().startObject().field("map").value(mapA).endObject());
        for (boolean useStream : new boolean[] { false, true }) {  
        XContentBuilder builder = builder().startObject().field("text", new Text(random)).endObject();  
package org.opensearch.common.xcontent;
        map0.put("foo", 0);
            generator.writeStartObject();
        ) {
        final ToXContent x1 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", 2).array("f3", 3, 4, 5).endObject();
        assertResult(result, () -> builder().startObject().field("bigdecimal", bigDecimal).endObject());  
        assertResult("{'d1':'07:59:23.123'}", () -> builder().startObject().field("d1").timeValue(d2.toLocalTime()).endObject());
        objects.put("{'objects':[1,1,2,3,5,8]}", new Object[] { (short) 1, (short) 1, (short) 2, (short) 3, (short) 5, (short) 8 });
import java.time.Period;
        assertResult("{'o':'07:59:23.123Z'}", () -> builder().startObject().timeField("o", offsetTime).endObject());
        objects.put("{'objects':['OPEN','CLOSE']}", IndexMetadata.State.values());  
        generator.writeName("bigint");
        assertResult("{'byte':null}", () -> builder().startObject().field("byte", (Byte) null).endObject());
        assertResult("{'date':null}", () -> builder().startObject().field("date", (LocalDateTime) null).endObject());  
import org.apache.lucene.util.BytesRef;
    private static void expectUnclosedException(ThrowingRunnable runnable) {
        assertResult("{'integer':[]}", () -> builder().startObject().array("integer", new int[] {}).endObject());  
        expectValueException(() -> builder().startObject("foo").endObject());
        final DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            assertArrayEquals(Arrays.copyOfRange(randomBytes, offset, offset + length), parser.binaryValue());
            assertTrue(parser.nextToken().isValue());
        assertResult("{'bigdecimal':null}", () -> builder().startObject().field("bigdecimal", (BigInteger) null).endObject());
    public void testEnsureNotNull() {
        object.put("{'object':{'lat':45.759429931640625,'lon':4.8394775390625}}", GeoPoint.fromGeohash("u05kq4k"));
            builder.field("field", "value");  
        // also test with a date that has a real offset
        expectUnclosedException(() -> builder().startObject().toString());
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
 * You may obtain a copy of the License at  
        assertResult("{'long':[1,3,5,7,11]}", () -> builder().startObject().array("long", 1L, 3L, 5L, 7L, 11L).endObject());
        assertResult("{'bigint':[]}", () -> builder().startObject().array("bigint", new BigInteger[] {}).endObject());
 * The OpenSearch Contributors require contributions made to  
    }
            () -> builder().startObject().field("field", values).endObject()  
            assertNull(parser.nextToken());
        assertResult("{'date':null}", () -> builder().startObject().field("date", (ZonedDateTime) null).endObject());
    private interface Builder {
            XContentParser emptyRegistryParser = xcontentType().xContent()
        innerMap.put("int", 42);
    }  
            assertResult(expected, () -> builder().startObject().field("iter").value(i.getValue()).endObject());  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, runnable);
        Map<String, Object> map1 = new HashMap<>();
        final byte[] rawData = os.toByteArray();
        map0.put("foo", 0);  
        try (XContentParser parser = createParser(xcontentType().xContent(), BytesReference.bytes(builder))) {  
        Map<String, Object> mapD = singletonMap("d", "D");  
        }  
        assertThat(XContentHelper.convertToJson(BytesReference.bytes(builder.build()), randomBoolean()), equalToJson(expected));  
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (java.time.Instant) null).endObject());
        objects.put("{'objects':['2016-01-01T00:00:00.000Z','2015-01-01T00:00:00.000Z']}", new Object[] { d1, d2 });
    }
    }
import org.opensearch.core.xcontent.XContentGenerator;  
    }
        expectNonNullFieldException(() -> BytesReference.bytes(builder().field(null)));
    public void testLatLon() throws Exception {
    public void testPath() throws Exception {
            assertEquals(Token.END_OBJECT, parser.nextToken());
 *  
import static org.hamcrest.Matchers.equalTo;
import java.time.format.DateTimeFormatter;
import java.util.Collections;  
        final byte[] rawData = os.toByteArray();  
            {
 * KIND, either express or implied.  See the License for the
            assertSame(parser.nextToken(), Token.END_OBJECT);
        }
        assertResult("{'boolean':true}", () -> builder().startObject().field("boolean", Boolean.TRUE).endObject());
        // Build the XContentBuilder, convert its bytes to JSON and check it matches
    public void testSelfReferencingIterable() throws IOException {
            () -> builder().startObject().startObject("foo").startObject("bar").endObject().endObject().endObject()  
        }
                Exception e = expectThrows(XContentParseException.class, () -> p.namedObject(String.class, "doesn't matter", null));
            assertResult(expected, () -> builder().startObject().field("iter", i.getValue()).endObject());
        );  
            final String expected = o.getKey();  
        final ZonedDateTime d1 = ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
            generator.writeEndObject();
    public void testBigDecimals() throws Exception {  
            assertEquals(Token.FIELD_NAME, parser.nextToken());
        objects.put("{'objects':['2012-07-07T10:23:00.000Z','2014-11-16T19:36:00.000Z']}", new Object[] { c1, c2 });
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, serialized)
        assertResult("{'double':[42.0,43.0,45]}", () -> builder().startObject().array("double", 42.0, 43.0, 45).endObject());
        assertResult("{'string':[]}", () -> builder().startObject().array("string", Strings.EMPTY_ARRAY).endObject());
                + "{'field':'value','foo':{'bar':'baz'}}"
        assertResult("{'boolean':[true,false,true]}", () -> builder().startObject().array("boolean", true, false, true).endObject());  
        assertEquals(e.getMessage(), "Unclosed object or array found");  
        }  
        assertResult("{'string':null}", () -> builder().startObject().field("string").value((String) null).endObject());  
import java.util.Arrays;
        Map<String, Object> map0 = new HashMap<>();
        ToXContent xcontent0 = (builder, params) -> {
        XContentBuilder b = XContentBuilder.builder(xcontentType().xContent());
        objects.put("{'obj':50.63}", DistanceUnit.METERS.fromMeters(50.63));  
        final BytesReference random = new BytesArray(randomBytes());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> XContentBuilder.ensureNameNotNull(null));
            () -> builder().startObject().field("d1").timeValue(d1.toOffsetDateTime()).endObject()  
        );
            assertResult(expected, () -> builder().startObject().field("objects").value(o.getValue()).endObject());
        mapA.put("c", Arrays.asList(mapC, mapC));
        innerMap.put("object", singletonMap("key", "value"));
            assertEquals(parser.currentName(), "utf8");
        }
            "{'foo':{'bar':{}}}",
    public void testContentType() throws IOException {  
    }
        final String path = Constants.WINDOWS ? "{'object':'a\\\\b\\\\c'}" : "{'object':'a/b/c'}";  
            () -> builder().startObject().field("calendar").timeValue(calendar).endObject()
        assertResult(  
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1).endObject());  
            final String expected = m.getKey();
        MonthDay monthDay = MonthDay.of(month, randomIntBetween(1, 28));  
            "{'date_in_millis':1451606400000}",  
        Map<String, Map<String, ?>> maps = new HashMap<>();  
    public static Matcher<String> equalToJson(String json) {  
import static java.util.Collections.singletonMap;  
        generator.writeNumber(bigInteger);  
    public void testFloats() throws IOException {  
            builder.startObject();  
            assertResult(expected, () -> builder().startObject().field("map").value(m.getValue()).endObject());
        generator.writeEndObject();
        assertResult("{'foo':[]}", () -> builder().startObject().startArray("foo").endArray().endObject());
            assertEquals("bar", map.get("foo"));
        assertResult("{'xcontent':null}", () -> builder().startObject().field("xcontent").value((ToXContent) null).endObject());  
        }  
            try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {  
        final Calendar c1 = GregorianCalendar.from(ZonedDateTime.of(2012, 7, 7, 10, 23, 0, 0, ZoneOffset.UTC));  
            "{'d1':'2016-01-01T00:00:00.000+05:00'}",
        assertResult("{'boolean':null}", () -> builder().startObject().field("boolean").value((Boolean) null).endObject());
        assertResult("{'boolean':false}", () -> builder().startObject().field("boolean", Boolean.FALSE).endObject());
        // we can still call parser.map() and get the bigint value so that eg. source filtering
import org.opensearch.tools.jackson.core.JsonGenerationException;
        expectArrayException(() -> builder().endArray().toString());
            assertEquals(bigInteger, map.get("bigint"));
            assertResult(expected, () -> builder().humanReadable(true).startObject().field("object", o.getValue()).endObject());  
        map.put("baz", values);  
import org.opensearch.core.common.Strings;
 * SPDX-License-Identifier: Apache-2.0
        ) {
        os = new ByteArrayOutputStream();
        final ZonedDateTime d2 = ZonedDateTime.of(2016, 1, 1, 7, 59, 23, 123_000_000, ZoneOffset.UTC);
    }  
        ByteArrayOutputStream os = new ByteArrayOutputStream();
import java.time.Duration;
        }  
        assertResult(  
            generator.writeStartObject();  
        assertResult("{'float':42.5}", () -> builder().startObject().field("float", Float.valueOf(42.5f)).endObject());
    public void testDateField() throws Exception {
        }  
        for (XContentType xcontentType : XContentType.values()) {
    public void testBinaryValue() throws Exception {
        expectUnclosedException(() -> builder().startArray().toString());
        );  
        objects.put("{'obj':'MINUTES'}", TimeUnit.MINUTES);
import org.opensearch.core.xcontent.XContent;
            () -> builder().startObject().field("xcontent", xcontent0).endObject()
import static org.hamcrest.Matchers.startsWith;
        final Date d2 = Date.from(ZonedDateTime.of(2015, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());  
        map2.put("baz", 2);  
        object.put("{'object':1}", (short) 1);
        object.put("{'object':{'f1':'v1','f2':{'f1':'v1','f2':2,'f3':[3,4,5]}}}", x2);
        Map<String, Object> mapC = singletonMap("c", "C");
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, os.toByteArray())
            assertNull(parser.nextToken());
        assertResult(
            generator.writeStartObject();
            assertNull(parser.nextToken());  
            "{'double':[1.7976931348623157E308,4.9E-324]}",
        os = new ByteArrayOutputStream() {
        // ZonedDateTime
        Map<String, Object> object = new HashMap<>();
    }
            assertSame(parser.nextToken(), Token.END_OBJECT);
    }  
        assertResult(
        assertResult("{'field':'value','array':['1','2','3'],'foo':{'bar':'baz'}}", () -> builder().value(xcontent0));
        object.put("{'object':'" + "2016-01-01T00:00:00.000Z" + "'}", d1);
            assertEquals(Token.VALUE_NULL, parser.nextToken());
        maps.put("{'map':{}}", Collections.emptyMap());
        final byte[] randomBytes = randomBytes();
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertResult("{'foo':'bar'}", () -> builder().startObject().field("foo").value("bar").endObject());
            builder.field("field", "value");
import java.nio.file.Path;  
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((Date) null).endObject());  
        }
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((ZonedDateTime) null).endObject());
            assertNull(parser.nextToken());  
        );
        objects.put("{'obj':'class org.opensearch.common.xcontent.BaseXContentTestCase'}", BaseXContentTestCase.class);
        Duration duration = Duration.ofSeconds(randomInt(100000));
        BytesReference bytes = BytesReference.bytes(builder().startObject().field("binary", randomBytes).endObject());  
        final Date d1 = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
import java.util.Calendar;
        assertResult("{'short':[]}", () -> builder().startObject().array("short", new short[] {}).endObject());
        try (  
        assertThat(e.getMessage(), containsString("Failed to close the XContentBuilder"));  
        );
        assertResult(
import org.opensearch.common.geo.GeoPoint;
            assertEquals(Token.START_OBJECT, parser.nextToken());
import tools.jackson.core.JsonGenerator;  
    public void testMap() throws Exception {
        assertResult(result, () -> builder().startObject().array("bigint", bigInteger, bigInteger, bigInteger).endObject());  
            assertThat(new BytesRef(parser.charBuffer()).utf8ToString(), equalTo(randomBytesRef.utf8ToString()));  
    public void testField() throws IOException {  
            XContentParser p = xcontentType().xContent()
        objects.put("{'objects':[1.0,1.0,2.0,3.0,5.0,8.0,13.0]}", new Object[] { 1.0d, 1.0d, 2.0d, 3.0d, 5.0d, 8.0d, 13.0d });
        innerMap.put("path", PathUtils.get("path", "to", "file"));
        Calendar calendar = GregorianCalendar.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));
        expectNonNullFieldException(() -> BytesReference.bytes(builder().nullField(null)));
 * ownership. Elasticsearch licenses this file to you under  
        assertResult("{'m':null}", () -> builder().startObject().field("m", (MonthDay) null).endObject());
        final String expected = "{'latlon':{'lat':13.271484375,'lon':52.4267578125}}";  
    protected abstract XContentType xcontentType();  
            assertNull(parser.nextToken());
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1).endObject());
    private static void expectArrayException(ThrowingRunnable runnable) {
        Object test2 = new Object();  
            assertTrue(parser.nextToken().isValue());
        try (
    public void testObject() throws Exception {
            builder.field("bar", "baz");
        BytesReference bytes = BytesReference.bytes(builder().startObject().field("binary").value(randomBytes).endObject());
            generator.writeFieldName("foo");
            assertFalse("Generator should not have closed the output stream", closed.get());
        map0.put("map1", map1); // map 0 -> map 1
     */
    private static void expectValueException(ThrowingRunnable runnable) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> XContentBuilder.ensureNotNull(null, "message"));  
        iterables.put(path, PathUtils.get("path", "to", "file"));
        final ToXContent x1 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", 2).array("f3", 3, 4, 5).endObject();  
            assertArrayEquals(randomBytes, parser.binaryValue());  
     * Test that the same map written multiple times do not trigger the self-reference check in  
        assertResult("{'y':'" + year + "'}", () -> builder().startObject().field("y", year).endObject());
            assertEquals("foo", parser.currentName());
        assertResult("{'date':null}", () -> builder().startObject().field("date", (LocalTime) null).endObject());
            final String expected = i.getKey();
        assertResult(expected, () -> builder().startObject().latlon("latlon", 13.271484375, 52.4267578125).endObject());
    public void testNamedObject() throws IOException {
        OffsetDateTime offsetDateTime = d1.withZoneSameLocal(ZoneOffset.ofHours(5)).toOffsetDateTime();  
        IOException e = expectThrows(IOException.class, () -> {
        objects.put("{'objects':[{'f1':'v1'},{'f2':'v2'}]}", new Object[] { singletonMap("f1", "v1"), singletonMap("f2", "v2") });
        assertThat(e.getCause(), allOf(notNullValue(), instanceOf(IOException.class)));
            assertEquals("test", parser.currentName());  
        Iterable<Object> values = Arrays.asList("one", "two", map);
        assertResult(expected, () -> builder().startObject().field("map").map(mapA).endObject());
            assertWarnings("Deprecated field [deprecated] used, expected [test2] instead");
            Map<String, Object> map = parser.map();  
        );
    }
            builder.field("root", xcontent0);
            () -> builder().startObject().array("integer", new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE }).endObject()
            assertSame(parser.nextToken(), Token.START_OBJECT);
        assertResult("{'long':[]}", () -> builder().startObject().array("long", new long[] {}).endObject());
        assertResult("{'text':''}", () -> builder().startObject().field("text", new Text("")).endObject());
        objects.put(paths, new Object[] { PathUtils.get("a", "b", "c"), PathUtils.get("d", "e") });
        objects.put("{'objects':[[1,2,3],[4,5]]}", new Object[] { Arrays.asList(1, 2, 3), Arrays.asList(4, 5) });
            }
        object.put("{'object':'OPEN'}", IndexMetadata.State.OPEN);  
        final String paths = Constants.WINDOWS ? "{'objects':['a\\\\b\\\\c','d\\\\e']}" : "{'objects':['a/b/c','d/e']}";
import org.opensearch.core.common.bytes.BytesArray;  
        assertResult("{'p':null}", () -> builder().startObject().field("p", (Period) null).endObject());
        assertResult(expected, () -> builder().startObject().field("map", mapA).endObject());  
        map2.put("baz", 2);
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1").timeValue(d1).endObject());
import java.time.ZonedDateTime;
        expectValueException(() -> BytesReference.bytes(builder().field("foo")));
                () -> emptyRegistryParser.namedObject(String.class, "doesn't matter", null)  
}
        assertResult("{'foo':null}", () -> builder().startObject().field("foo").nullValue().endObject());
        byte[] data = os.toByteArray();
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
        // Year
        object.put("{'object':[1,2,3]}", Arrays.asList(1, 2, 3));
        map0.put("it1", it1); // map 0 -> it1
            builder.field("bin").value(randomBytes, offset, length);
            builder.startObject();
            assertEquals(Token.VALUE_NULL, parser.nextToken());
            assertEquals(Token.END_OBJECT, parser.nextToken());  
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1").timeValue(d1.toInstant()).endObject());  
        Map<String, Object> map0 = new HashMap<>();
        );
    }
import java.io.ByteArrayInputStream;
import org.apache.lucene.util.Constants;
                doTestRawField(xcontentType.xContent(), useStream);
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
            generator.writeEndObject();
            assertEquals(Token.START_OBJECT, parser.nextToken());
        object.put("{'object':'a'}", new Text("a"));  
                generator.writeRawField("bar", new BytesArray(rawData).streamInput());
        final BytesRef randomBytesRef = new BytesRef(randomBytes());
import static org.hamcrest.Matchers.allOf;
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (Date) null).endObject());
            "{'integer':[2147483647,-2147483648]}",
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1.toInstant()).endObject());
 * GitHub history for details.
        assertResult("{'d':'" + duration + "'}", () -> builder().startObject().field("d", duration).endObject());  
        iterables.put("{'iter':null}", (Iterable<?>) null);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        values.add("foo");
            if (useStream) {
    }
    }
            assertSame(parser.nextToken(), Token.START_OBJECT);  
        objects.put("{'objects':null}", null);
            builder.endObject();
            generator.writeFieldName("test");  
            () -> builder().startObject().array("float", 42.0f, 43.0f, 45.66666667f).endObject()
/*  
import java.time.LocalDateTime;
        expectArrayException(() -> BytesReference.bytes(builder().endArray()));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map0));  
        assertResult("{'path':null}", () -> builder().startObject().field("path", (Path) null).endObject());  
        XContentBuilder.ensureNotNull("foo", "No exception must be thrown");  
        // LocalDate (no time, no time zone)
        Period period = Period.ofDays(randomInt(1000));  
        assertResult(
    /**
        expectValueException(() -> BytesReference.bytes(builder().nullField("foo")));  
        );
        assertResult(  
    }  
    public void testEnsureNameNotNull() {  
        object.put("{'object':'b'}", new Text(new BytesArray("b")));
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((LocalTime) null).endObject());  
                closed.set(true);
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
            generator.writeEndObject();  
        XContentBuilder builder = builder().startObject();
        object.put("{'object':'NM'}", DistanceUnit.NAUTICALMILES);
            generator.writeRawValue(new BytesArray(rawData).streamInput(), source.mediaType());  
                    NamedObjectNotFoundException.class,
        objects.put("{'objects':[1.0,1.0,2.0,3.0,5.0,8.0,13.0]}", new Object[] { 1.0f, 1.0f, 2.0f, 3.0f, 5.0f, 8.0f, 13.0f });  
                generator.writeNumber(2L);
    }  
        );
            XContentParser parser = xcontentType().xContent()
    }
        assertResult(result, () -> builder().startObject().array("bigdecimal", bigDecimal, bigDecimal, bigDecimal).endObject());  
                assertThat(e.getCandidates(), containsInAnyOrder("test1", "test2", "deprecated", "str"));
            builder.endObject();  
        it1.add(map2); // it 1 -> map 1, map 2
            assertEquals("bar", parser.currentName());
        assertEquals(e.getMessage(), "Unclosed object or array found");
        Map<String, Object> mapB = singletonMap("b", "B");
import static org.hamcrest.Matchers.instanceOf;  
    }  
    }  
        assertResult(result, () -> builder().startObject().field("bigint", bigInteger).endObject());  
            "{'map':{'b2':{'b':'B'},'a':0,'c':[{'c':'C'},{'c':'C'}],'d1':{'d':'D'},'d2':{'d3':{'d':'D'}},'b1':{'b':'B'}}}";
        if (randomBoolean()) {
        assertResult("{'byte':1}", () -> builder().startObject().field("byte", (byte) 1).endObject());  
            () -> builder().startObject().field("field", values).endObject()
    public void testJavaTime() throws Exception {
        mapA.put("d1", mapD);  
            assertEquals("test", p.namedObject(Object.class, "str", null));
        assertResult("{'string':'value'}", () -> builder().startObject().field("string", "value").endObject());
            XContentParser parser = xcontentType().xContent()  
 * Unless required by applicable law or agreed to in writing,
        Object test1 = new Object();
        final byte[] randomBytes = randomBytes();
        final int length = randomIntBetween(1, Math.max(1, randomBytes.length - offset - 1));
        assertResult("{'boolean':[false,true]}", () -> builder().startObject().array("boolean", new boolean[] { false, true }).endObject());
    private static void assertResult(String expected, Builder builder) throws IOException {
        assertResult(
        values[0] = 0;  
        assertResult("{'short':null}", () -> builder().startObject().field("short", (Short) null).endObject());
        });
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, os.toByteArray())
        maps.put("{'map':{'key':'value'}}", singletonMap("key", "value"));  
        for (Map.Entry<String, Object> o : object.entrySet()) {
        // OffsetTime
            assertSame(parser.nextToken(), Token.FIELD_NAME);
import java.io.ByteArrayOutputStream;
            Arrays.asList(
        assertResult("{'d1':'2016-01-01'}", () -> builder().startObject().field("d1").timeValue(d1.toLocalDate()).endObject());
        assertResult("{'m':null}", () -> builder().startObject().field("m", (Month) null).endObject());
        Map<String, Iterable<?>> iterables = new HashMap<>();
    public void testStartEndArray() throws IOException {
        assertResult("{'d1':'00:00:00.000'}", () -> builder().startObject().field("d1").timeValue(d1.toLocalTime()).endObject());  
        assertResult("{'string':['a','b','c','d']}", () -> builder().startObject().array("string", "a", "b", "c", "d").endObject());
    }
                generator.writeStartArray();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
    }  
    }  
        assertResult("{'d2':'2016-12-25T07:59:42.213Z'}", () -> builder().startObject().field("d2").timeValue(d2).endObject());
            IllegalArgumentException.class,  
        assertResult("{'integer':null}", () -> builder().startObject().field("integer").value((Integer) null).endObject());
import org.opensearch.test.OpenSearchTestCase;
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);  
    public void testUnknownObject() throws Exception {
        object.put("{'object':{'f1':{'f2':'v2'}}}", singletonMap("f1", singletonMap("f2", "v2")));  
    }
        assertResult("{'byte':0}", () -> builder().startObject().field("byte").value((byte) 0).endObject());
import org.hamcrest.Matchers;
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));  
        assertResult("{'d1':'2016-01-01T00:00:00.000+05:00'}", () -> builder().startObject().timeField("d1", offsetDateTime).endObject());
        assertResult("{'double':null}", () -> builder().startObject().field("double", (Double) null).endObject());
            assertSame(parser.nextToken(), Token.FIELD_NAME);
        assertResult(
    }
        mapA.put("b1", mapB);  
        expectObjectException(() -> builder().endObject().toString());
            "{'d1':'2016-01-01T00:00:00.000Z'}",  
    }
            IllegalArgumentException.class,  
 * the Apache License, Version 2.0 (the "License"); you may
        expectFieldException(() -> builder().startObject().startArray().endArray().endObject());
        assertResult(  
        // also test with a date that has a real offset
        final Date d1 = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1.toOffsetDateTime()).endObject());  
        );
        map.put("bar", 1);  
        }
            XContentParser parser = xcontentType().xContent()
        assertThat(e.getMessage(), containsString("Current context not Array"));  
        values.add("bar");
    }
        final Calendar c2 = GregorianCalendar.from(ZonedDateTime.of(2014, 11, 16, 19, 36, 0, 0, ZoneOffset.UTC));
        Map<String, Object> map1 = new HashMap<>();
            assertSame(parser.nextToken(), Token.END_OBJECT);
        expectValueException(() -> builder().startArray("foo").endObject());
            assertResult(expected, () -> builder().startObject().field("obj", o.getValue()).endObject());  
    }
        );
    }
        // Period
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            builder.startObject();  
        // OffsetDateTime
        // Month  
            builder.startObject("foo");
            generator.writeStartObject();
        assertResult("{'long':null}", () -> builder().startObject().array("long", (long[]) null).endObject());  
            () -> builder().humanReadable(true).startObject().timeField("date_in_millis", "date", d.getTime()).endObject()
import java.math.BigDecimal;
        assertResult("{'text':null}", () -> builder().startObject().field("text", (Text) null).endObject());
    private XContentBuilder builder() throws IOException {
            "{'geo':{'lat':52.4267578125,'lon':13.271484375}}",
        ToXContentObject xcontent1 = (builder, params) -> {
        builder().map(null);
        assertThat(e.getMessage(), containsString("Field name cannot be null"));
        Object[] values = new Object[3];
            "{'float':[3.4028235E38,1.4E-45]}",
 * not use this file except in compliance with the License.
        assertResult("{'short':42}", () -> builder().startObject().field("short").value((short) 42).endObject());
                + "'field':'value',"
            () -> builder().startObject().field("geo").value(GeoPoint.fromGeohash("u33dc1")).endObject()
import static org.hamcrest.Matchers.containsString;  
        byte[] serialized = os.toByteArray();  
        assertResult(
            "{'d1':'2016-01-01T00:00:00.000Z'}",
    }
            "{'root':{"
/*  
 * Licensed to Elasticsearch under one or more contributor  
                generator.writeNumber(2L);  
    }
                    () -> p.namedObject(Object.class, "unknown", null)
        iterables.put("{'iter':['a','b']}", Arrays.asList("a", "b"));
        objects.put("{'objects':[1,1,2,3,5,8,13]}", new Object[] { 1L, 1L, 2L, 3L, 5L, 8L, 13L });  
import org.opensearch.core.xcontent.ToXContentObject;  
        } else {
        object.put("{'object':'string'}", "string");
        b.value("test");  
    public void testObjects() throws Exception {
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));  
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
import java.util.Date;
        try (
            assertResult(expected, () -> builder().startObject().field("map", m.getValue()).endObject());  
 *
 * software distributed under the License is distributed on an
        map1.put("bar", 1);  
            "{'date':'2016-01-01T00:00:00.000Z','date_in_millis':1451606400000}",
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (OffsetDateTime) null).endObject());
        );
                generator.writeStartObject();
        Map<String, Object> objects = new HashMap<>();
        try (  
        map2.put("map0", map0); // map 2 -> map 0 loop
            () -> builder().value(xcontent2)
        final ToXContent x2 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", x1).endObject();
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1.toLocalDateTime()).endObject());
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (OffsetTime) null).endObject());  
    public void testIterable() throws Exception {  
        object.put("{'object':3}", 3);
        assertResult("{'m':'" + monthDay + "'}", () -> builder().startObject().field("m", monthDay).endObject());
            IllegalArgumentException.class,
            "{'geo':{'lat':52.5201416015625,'lon':13.4033203125}}",  
        // LocalDateTime (no time zone)  
    }  
        assertThat(e.getMessage(), containsString("Current context not Object"));
import java.util.List;
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (ZonedDateTime) null).endObject());  
    void doTestRawValue(XContent source) throws Exception {  
    @FunctionalInterface
        Month month = randomFrom(Month.values());
            return builder;
import org.opensearch.cluster.metadata.IndexMetadata;  
            assertResult(expected, () -> builder().startObject().field("obj").value(o.getValue()).endObject());
import org.opensearch.core.ParseField;
        objects.put("{'objects':['a','b','c']}", new Object[] { "a", "b", "c" });
        assertResult("{'integer':[1,3,5,7,11]}", () -> builder().startObject().array("integer", 1, 3, 5, 7, 11).endObject());
        try (XContentParser parser = createParser(xcontentType().xContent(), bytes)) {
        assertThat(e.getMessage(), containsString("message"));
            assertSame(parser.nextToken(), Token.START_OBJECT);
    public void testBooleans() throws IOException {
            generator.writeRawValue(new BytesArray(rawData).streamInput(), source.mediaType());
    public void testBinaryField() throws Exception {
        assertResult("{'long':9223372036854775807}", () -> builder().startObject().field("long", 9_223_372_036_854_775_807L).endObject());  
        );
    private static byte[] randomBytes() throws Exception {  
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1).endObject());  
import org.hamcrest.Matcher;
        assertResult(
            "{'float':[42.0,43.0,45.666668]}",  
        assertResult("{'binary':null}", () -> builder().startObject().field("binary").value((byte[]) null).endObject());
            final String expected = o.getKey();
            () -> builder().startObject().field("field", values).endObject()
        expectUnclosedException(() -> BytesReference.bytes(builder().startObject()));
                assertEquals("unknown named object category [java.lang.String]", e.getMessage());  
        innerMap.put("long", 42L);
        BigDecimal bigDecimal = new BigDecimal("234.43");
                NamedObjectNotFoundException e = expectThrows(  
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        expectUnclosedException(() -> builder().startArray().close());  
import org.opensearch.core.xcontent.ToXContent;
        assertResult(  
    public void testStrings() throws IOException {  
        assertResult("{'string':''}", () -> builder().startObject().field("string", "").endObject());  
        IllegalArgumentException e = expectThrows(
    }
    public void testText() throws Exception {  
import static org.hamcrest.Matchers.containsInAnyOrder;
        e = expectThrows(IllegalArgumentException.class, () -> builder().startObject().array("field", values).endObject());
        mapA.put("b2", mapB);
     * {@link CollectionUtils#ensureNoSelfReferences(Object, String)} (Object)}
        );  
        assertResult("{'o':'07:59:23.123+05:00'}", () -> builder().startObject().timeField("o", zonedOffsetTime).endObject());  
    public void testShorts() throws IOException {
    public void testMissingEndArray() throws IOException {  
        };  
        assertThat(e.getMessage(), containsString("expecting a value"));
    public void testGeoPoint() throws Exception {
        assertResult("{'long':42}", () -> builder().startObject().field("long").value(42).endObject());  
            () -> builder().startObject().array("double", new double[] { Double.MAX_VALUE, Double.MIN_VALUE }).endObject()
    public void testLongs() throws IOException {  
    public void testRepeatedMapsAndNoSelfReferences() throws Exception {  
                new NamedXContentRegistry.Entry(Object.class, new ParseField("test2", "deprecated"), p -> test2),
        object.put("{'object':8.0}", 8.0f);  
import org.opensearch.core.xcontent.XContentParseException;
    }  
 * specific language governing permissions and limitations
            assertNull(parser.nextToken());
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (LocalDateTime) null).endObject());
        map1.put("bar", 1);  
        expectArrayException(() -> builder().endArray().close());
    protected void doTestBigInteger(JsonGenerator generator, ByteArrayOutputStream os) throws Exception {  
        values[1] = 1;
        final Date d = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());  
            assertEquals(Token.START_OBJECT, parser.nextToken());
        generator.writeStartObject();
                + "},"
        assertResult("{'double':[]}", () -> builder().startObject().array("double", new double[] {}).endObject());  
        innerMap.put("string", "value");  
        }
    public void testSelfReferencingMapsTwoLevels() throws IOException {
            assertEquals(Token.VALUE_NULL, parser.nextToken());
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {  
        try (
            assertEquals("named objects are not supported for this parser", e.getMessage());
        object.put("{'object':false}", Boolean.FALSE);  
        for (Map.Entry<String, Object[]> o : objects.entrySet()) {
            assertEquals(Token.END_OBJECT, parser.nextToken());
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((LocalDateTime) null).endObject());
        assertResult("{'byte':1}", () -> builder().startObject().field("byte").value((byte) 1).endObject());  
        }
import org.opensearch.core.common.text.Text;
    private static void expectObjectException(ThrowingRunnable runnable) {
            "{'objects':[{'f1':'v1','f2':2,'f3':[3,4,5]},{'f1':'v1','f2':{'f1':'v1','f2':2,'f3':[3,4,5]}}]}",
        map2.put("map0", map0); // map 2 -> map 0 loop
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);  
    public void testStartEndObject() throws IOException {
        assertThat(e.getCause().getMessage(), containsString("Unclosed object or array found"));
            assertResult(expected, () -> builder().humanReadable(true).startObject().field("object").value(o.getValue()).endObject());
        }
import static java.util.Collections.emptyMap;
        builder.endObject();
    public void testSelfReferencingObjectsArray() throws IOException {
    public void testDoubles() throws IOException {  
import java.util.concurrent.TimeUnit;  
    public void testBasics() throws IOException {
        assertResult("{'d1':'2016-01-01'}", () -> builder().startObject().timeField("d1", d1.toLocalDate()).endObject());  
 * this file be licensed under the Apache-2.0 license or a
import java.math.BigInteger;
        try (XContentGenerator generator = source.createGenerator(os)) {  
            "{'short':[32767,-32768]}",
        assertResult(
                generator.writeRawField("bar", new ByteArrayInputStream(rawData));  
        assertResult("{'short':5000}", () -> builder().startObject().field("short", Short.valueOf((short) 5000)).endObject());  
        map0.put("map1", map1); // map 0 -> map 1
        assertResult("{'bigint':null}", () -> builder().startObject().field("bigint", (BigInteger) null).endObject());
        Map<String, Object> map = new HashMap<>();
            @Override
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (LocalTime) null).endObject());
            assertEquals(parser.currentName(), "binary");
        final OffsetTime offsetTime = d2.toOffsetDateTime().toOffsetTime();  
            try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {  
        assertResult(  
        return randomUnicodeOfLength(scaledRandomIntBetween(10, 1000)).getBytes("UTF-8");
            }  
import static org.hamcrest.Matchers.endsWith;
        object.put("{'object':2}", 2L);  
                + "{'field':'value','array':['1','2','3'],'foo':{'bar':'baz'}},"
            () -> builder().startObject().array("long", new long[] { Integer.MAX_VALUE, Integer.MIN_VALUE }).endObject()  
        assertResult("{'float':1.2}", () -> builder().startObject().field("float", 1.2f).endObject());  
            generator.writeFieldName("foo");
        final byte[] randomBytes = randomBytes();  
import org.opensearch.core.xcontent.XContentParser.Token;  
    public void testNullField() throws IOException {
            )  
        assertResult("{'byte':null}", () -> builder().startObject().field("byte").value((Byte) null).endObject());
        IllegalStateException e = expectThrows(IllegalStateException.class, runnable);
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((java.time.Instant) null).endObject());  
                new NamedXContentRegistry.Entry(Object.class, new ParseField("str"), p -> p.text())
        map.put("field", map);
        assertResult("{'short':null}", () -> builder().startObject().array("short", (short[]) null).endObject());
    public void testSelfReferencingIterableTwoLevels() throws IOException {  
        assertResult("{'long':42}", () -> builder().startObject().field("long", Long.valueOf(42L)).endObject());
            assertSame(parser.nextToken(), Token.FIELD_NAME);
            assertThat(pex.getMessage(), startsWith("Duplicate Object property \"key\""));  
        String result = "{'bigint':" + bigInteger.toString() + "}";
        );  
import java.time.OffsetTime;  
        List<Object> values = new ArrayList<>();  
 */  
        values.add(values);  
        }
        try (XContentParser xParser = createParser(builder)) {
        Year year = Year.of(randomIntBetween(0, 2300));
            JsonParseException pex = expectThrows(JsonParseException.class, () -> xParser.map());
        assertResult("{'date':null}", () -> builder().startObject().field("date", (java.time.Instant) null).endObject());
        );  
        );
        expectUnclosedException(() -> BytesReference.bytes(builder().startArray()));
        assertResult("{}", () -> builder().startObject().endObject());
    public void testNullValue() throws IOException {
        }
        result = "{'bigint':[" + bigInteger.toString() + "," + bigInteger.toString() + "," + bigInteger.toString() + "]}";
        assertResult("{'foo':[1,2,3]}", () -> builder().startObject().startArray("foo").value(1).value(2).value(3).endArray().endObject());  
            () -> builder().startObject().timeField("date_in_millis", "date", d.getTime()).endObject()
        try (XContentGenerator generator = source.createGenerator(os)) {
        object.put("{'object':{'f1':'v1'}}", singletonMap("f1", "v1"));
        assertResult("{'date':null}", () -> builder().startObject().field("date", (OffsetTime) null).endObject());
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);
                XContentParseException.class,
import java.util.HashMap;  
        os = new ByteArrayOutputStream();
        assertResult("{'boolean':null}", () -> builder().startObject().field("boolean", (Boolean) null).endObject());  
        assertThat(e.getMessage(), containsString("Field name cannot be null"));
        }  
    public void testSelfReferencingIterableOneLevel() throws IOException {  
        iterables.put(paths, Arrays.asList(PathUtils.get("a", "b", "c"), PathUtils.get("c", "d")));
            assertEquals(test2, p.namedObject(Object.class, "deprecated", null));
        generator.writeString("bar");
            builder.array("childs", xcontent0, xcontent1);
import java.time.MonthDay;
        // Duration  
        DayOfWeek dayOfWeek = randomFrom(DayOfWeek.values());  
 */
            assertTrue(parser.nextToken().isValue());
import java.util.ArrayList;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map0));
        try (  
        innerMap.put("long[]", new long[] { 1L, 3L });  
    public void testBytes() throws IOException {  
                new NamedXContentRegistry.Entry(Object.class, new ParseField("test1"), p -> test1),  
            assertEquals("foo", parser.currentName());  
        }
        assertResult("{'d1':'00:00:00.000'}", () -> builder().startObject().timeField("d1", d1.toLocalTime()).endObject());
        assertResult("{'double':1.2}", () -> builder().startObject().field("double", 1.2).endObject());  
            assertEquals(Token.END_OBJECT, parser.nextToken());  
        maps.put("{'map':{'path':'" + path + "','string':'value','long[]':[1,3],'int':42,'long':42,'object':{'key':'value'}}}", innerMap);
        // Big integers cannot be handled explicitly, but if some values happen to be big ints,
        map1.put("map2", map2); // map 1 -> map 2
        assertResult("{'byte':0}", () -> builder().startObject().field("byte", (byte) 0).endObject());
    }
        assertResult(expected, () -> builder().startObject().field("path", path).endObject());
import org.opensearch.core.xcontent.XContentParser;
        assertResult("{'double':0.001}", () -> builder().startObject().field("double").value(0.001).endObject());
import org.opensearch.tools.jackson.core.JsonParseException;  
import java.time.Year;
        assertResult("{'binary':null}", () -> builder().startObject().field("binary", (byte[]) null).endObject());  
    }  
        assertResult("{'objects':[null,null,null]}", () -> builder().startObject().array("objects", null, null, null).endObject());
        assertResult("{'o':'07:59:23.123Z'}", () -> builder().startObject().field("o").timeValue(offsetTime).endObject());
        assertResult("{'d2':'2016-12-25T07:59:42.213Z'}", () -> builder().startObject().timeField("d2", d2).endObject());
        final String expected =  
        expectNonNullFieldException(() -> builder().startObject().startArray(null).endArray().endObject());  
        objects.put("{'objects':[1,1,2,3,5,8,13]}", new Object[] { (byte) 1, (byte) 1, (byte) 2, (byte) 3, (byte) 5, (byte) 8, (byte) 13 });
        assertResult("{'float':[]}", () -> builder().startObject().array("float", new float[] {}).endObject());
        Map<String, Object> map2 = new HashMap<>();
        ) {  
 */  
        }
        Map<String, Object> map = new HashMap<>();
        expectUnclosedException(() -> BytesReference.bytes(builder().startObject().nullField("foo")));
        assertResult("{'p':'" + period + "'}", () -> builder().startObject().field("p", period).endObject());
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
        object.put("{'object':null}", null);
    public void testMissingEndObject() throws IOException {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map));
            assertEquals("foo", parser.currentName());  
        final String path = Constants.WINDOWS ? "{'iter':'path\\\\to\\\\file'}" : "{'iter':'path/to/file'}";  
        IllegalArgumentException e = expectThrows(
        assertResult("{'d1':'00:00:00.000'}", () -> builder().startObject().field("d1", d1.toLocalTime()).endObject());
        String result = "{'bigdecimal':" + bigDecimal.toString() + "}";
            assertEquals(parser.currentName(), "bin");  
        assertResult("{'double':42.5}", () -> builder().startObject().field("double", Double.valueOf(42.5)).endObject());
            } else {
        try (XContentParser parser = createParser(xcontentType().xContent(), bytes)) {
        object.put("{'object':'2010-01-01T00:00:00.000Z'}", c1);
        try (XContentParser parser = createParser(xcontentType().xContent(), BytesReference.bytes(builder))) {
            assertSame(parser.nextToken(), Token.END_OBJECT);
import org.opensearch.core.xcontent.DeprecationHandler;
/*
        assertResult("{'dayOfWeek':'" + dayOfWeek + "'}", () -> builder().startObject().field("dayOfWeek", dayOfWeek).endObject());
        assertResult("{'integer':3}", () -> builder().startObject().field("integer", 3).endObject());  
        builder.endObject();
    }
            assertEquals(parser.currentName(), "text");
    }
            assertEquals(Token.START_OBJECT, parser.nextToken());
    }  
            () -> builder().startObject().field("d1").timeValue(offsetDateTime).endObject()
        );
            builder.field("bin", randomBytes, offset, length);  
                + "'array':['1','2','3'],"  
        assertResult("{'binary':null}", () -> builder().startObject().field("binary").value(null, 0, 0).endObject());
        assertResult("{'date':null}", () -> builder().startObject().field("date", (OffsetDateTime) null).endObject());
            }  
import java.io.IOException;  
            assertEquals(test1, p.namedObject(Object.class, "test1", null));
        assertResult("{'boolean':true}", () -> builder().startObject().field("boolean").value(Boolean.TRUE).endObject());
        expectNonNullFieldException(() -> builder().startObject().startObject(null));
            );
        assertResult(
import org.opensearch.core.common.util.CollectionUtils;  
        Map<String, Object> map0 = new HashMap<>();  
        assertResult("{'float':null}", () -> builder().startObject().array("float", (float[]) null).endObject());
            assertEquals(Token.FIELD_NAME, parser.nextToken());  
        objects.put("{'objects':['a','b','c']}", new Object[] { new Text("a"), new Text(new BytesArray("b")), new Text("c") });  
    }
        assertThat(builder().contentType(), equalTo(xcontentType()));
import java.time.LocalDate;  
        final Path path = PathUtils.get("first", "second", "third");
        assertResult("{'o':'07:59:23.123+05:00'}", () -> builder().startObject().field("o", zonedOffsetTime).endObject());
                + "]}",  
 * under the License.  
        ByteArrayOutputStream os = new ByteArrayOutputStream();
public abstract class BaseXContentTestCase extends OpenSearchTestCase {
        assertResult("{'long':null}", () -> builder().startObject().field("long").value((Long) null).endObject());
        iterables.put("{'iter':[]}", Collections.emptyList());  
import java.time.Month;  
        assertResult("{'short':null}", () -> builder().startObject().field("short").value((Short) null).endObject());  
        // DayOfWeek enum, not a real time value, but might be used in scripts
            assertEquals(Token.FIELD_NAME, parser.nextToken());
            assertTrue(parser.nextToken().isValue());  
        final ToXContent x2 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", x1).endObject();
    }
            XContentParser parser = xcontentType().xContent()
        assertResult("{'o':'07:59:23.123+05:00'}", () -> builder().startObject().field("o").timeValue(zonedOffsetTime).endObject());
        assertResult("{'string':null}", () -> builder().startObject().field("string", (String) null).endObject());
        NamedXContentRegistry registry = new NamedXContentRegistry(
            "{'long':[2147483647,-2147483648]}",
        objects.put(  
    }
        final AtomicBoolean closed = new AtomicBoolean(false);  
        };
        assertResult(  
        assertResult("{'float':null}", () -> builder().startObject().field("float").value((Float) null).endObject());  
        ToXContentObject xcontent2 = (builder, params) -> {
import org.opensearch.core.common.bytes.BytesReference;
    public void testRawField() throws Exception {
        ) {  
        expectObjectException(() -> builder().endObject().close());
        }
        ) {
    public void testEnsureNoSelfReferences() throws IOException {  
            assertSame(parser.nextToken(), Token.START_OBJECT);  
        // MonthDay
        assertResult("{'text':'foo bar'}", () -> builder().startObject().field("text", new Text("foo bar")).endObject());  
        final String path = Constants.WINDOWS ? "path\\\\to\\\\file" : "path/to/file";
                assertThat(e.getMessage(), endsWith("unknown field [unknown]"));
        generator.flush();
    private static void expectFieldException(ThrowingRunnable runnable) {
        assertResult("{'xcontent':null}", () -> builder().startObject().field("xcontent", (ToXContent) null).endObject());
        assertResult("{'long':null}", () -> builder().startObject().field("long", (Long) null).endObject());
        );
        for (Map.Entry<String, ?> o : objects.entrySet()) {
        assertResult("{'integer':null}", () -> builder().startObject().field("integer", (Integer) null).endObject());
    public void testSelfReferencingMapsOneLevel() throws IOException {
    }  
        expectObjectException(() -> BytesReference.bytes(builder().endObject()));  
        ) {  
    }
                );  
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (LocalDate) null).endObject());  
            assertSame(parser.nextToken(), Token.FIELD_NAME);  
import org.opensearch.common.unit.DistanceUnit;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Modifications Copyright OpenSearch Contributors. See
            () -> builder().startObject().field("unsigned_long", new BigDecimal("18446744073709551615")).endObject()  
                + "'foo':{'bar':'baz'}"
            () -> builder().startObject().array("short", (short) 1, (short) 3, (short) 5, (short) 7, (short) 11).endObject()
    public void testRawValue() throws Exception {  
        Map<String, Object> map2 = new HashMap<>();  
            {
    }
        object.put("{'object':5.0}", 5.0d);
        };
            assertEquals(parser.currentName(), "binary");
            assertNull(parser.nextToken());  
    public void testChecksForDuplicates() throws Exception {
        assertResult("{'utf8':null}", () -> builder().startObject().nullField("utf8").endObject());  
    void doTestRawField(XContent source, boolean useStream) throws Exception {
 * this work for additional information regarding copyright
            builder.endObject();  
        }
        assertResult("{'string':'42'}", () -> builder().startObject().field("string").value("42").endObject());
        Map<String, Object> mapA = new HashMap<>();
    public void testCalendar() throws Exception {  
        assertResult("{'float':9.9E-7}", () -> builder().startObject().field("float").value(0.00000099f).endObject());
        assertResult("{'double':null}", () -> builder().startObject().field("double").value((Double) null).endObject());
        assertResult("{'o':'07:59:23.123Z'}", () -> builder().startObject().field("o", offsetTime).endObject());  
        assertResult(expected, () -> builder().startObject().field("latlon").latlon(13.271484375, 52.4267578125).endObject());
        Map<String, Object> innerMap = new HashMap<>();
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1").timeValue(d1).endObject());
import org.opensearch.common.io.PathUtils;
            assertSame(parser.nextToken(), Token.START_OBJECT);
        assertResult("{'bigdecimal':[]}", () -> builder().startObject().array("bigdecimal", new BigInteger[] {}).endObject());
    }
        assertResult("{'integer':null}", () -> builder().startObject().array("integer", (int[]) null).endObject());
                generator.writeFieldName("foo");
            new Object[] { x1, x2 }
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
    }
        assertResult("{'foo':{}}", () -> builder().startObject().startObject("foo").endObject().endObject());
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
    public void testBinaryValueWithOffsetLength() throws Exception {  
    }  
        assertResult("{'d1':'2016-01-01'}", () -> builder().startObject().field("d1", d1.toLocalDate()).endObject());
    }
    }  
            Exception e = expectThrows(
        Map<String, Object[]> objects = new HashMap<>();
import org.opensearch.core.xcontent.NamedObjectNotFoundException;  
        IllegalArgumentException e = expectThrows(
        it1.add(map1);
            builder.endObject();  
    private static void expectNonNullFieldException(ThrowingRunnable runnable) {  
        assertResult("{'foo':null}", () -> builder().startObject().nullField("foo").endObject());
            () -> builder().startObject().array("float", new float[] { Float.MAX_VALUE, Float.MIN_VALUE }).endObject()
        final String expected = Constants.WINDOWS ? "{'path':'first\\\\second\\\\third'}" : "{'path':'first/second/third'}";  
        assertResult(
            assertResult(expected, () -> builder().startObject().field("objects", o.getValue()).endObject());
        objects.put("{'objects':[false,true,false]}", new Object[] { false, true, false });  
            builder.field("bar", "baz");
        }
        expectUnclosedException(() -> builder().startObject().close());  
 * compatible open source license.
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1.toOffsetDateTime()).endObject());
            return builder;
        // keeps working  
        assertEquals(xcontentType(), MediaTypeRegistry.xContent(data));  
        assertResult("{'dayOfWeek':null}", () -> builder().startObject().field("dayOfWeek", (DayOfWeek) null).endObject());
        for (Map.Entry<String, Iterable<?>> i : iterables.entrySet()) {  
        map0.put("foo", 0);  
        XContentBuilder builder = builder().startObject();  
        return XContentBuilder.builder(xcontentType().xContent());  
        assertResult("{'string':null}", () -> builder().startObject().array("string", (String[]) null).endObject());
        assertThat(e.getMessage(), containsString("expecting a property name"));  
        builder().map(emptyMap());
        expectUnclosedException(() -> BytesReference.bytes(builder().startObject().field("foo")));  
        assertResult("{'d1':'07:59:23.123'}", () -> builder().startObject().field("d1", d2.toLocalTime()).endObject());
        }  
    public void testBigIntegers() throws Exception {  
        assertResult("{'boolean':null}", () -> builder().startObject().array("boolean", (boolean[]) null).endObject());
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
            p.nextToken();  
 *
        final Date d2 = Date.from(ZonedDateTime.of(2016, 12, 25, 7, 59, 42, 213000000, ZoneOffset.UTC).toInstant());  
            for (XContentType xcontentType : XContentType.values()) {
        assertResult("{'float':null}", () -> builder().startObject().field("float", (Float) null).endObject());
    public void testDate() throws Exception {
        object.put(path, PathUtils.get("a", "b", "c"));
            generator.writeStartObject();
        IOException e = expectThrows(IOException.class, () -> {
            assertEquals(test2, p.namedObject(Object.class, "test2", null));  
            assertEquals(Token.FIELD_NAME, parser.nextToken());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map0));  
        try (XContentParser parser = createParser(xcontentType().xContent(), BytesReference.bytes(builder))) {
        for (Map.Entry<String, Map<String, ?>> m : maps.entrySet()) {
        assertResult(
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
        assertResult("{'double':null}", () -> builder().startObject().array("double", (double[]) null).endObject());
            assertArrayEquals(randomBytes, parser.binaryValue());
    }
        assertResult("{'d1':'2016-01-01T00:00:00.000+05:00'}", () -> builder().startObject().field("d1", offsetDateTime).endObject());
        assertResult("{'m':'" + month + "'}", () -> builder().startObject().field("m", month).endObject());  
    }  
    }
            generator.writeNull();  
            assertTrue(parser.nextToken().isValue());  
    }
            assertEquals(Token.FIELD_NAME, parser.nextToken());  
        assertResult("{'integer':42}", () -> builder().startObject().field("integer", Integer.valueOf(42)).endObject());
        builder.field("utf8").utf8Value(randomBytesRef.bytes, randomBytesRef.offset, randomBytesRef.length);
import java.time.DayOfWeek;
        final Date d1 = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());  
    }
            "{'short':[1,3,5,7,11]}",  
        assertResult("{'boolean':false}", () -> builder().startObject().field("boolean").value(Boolean.FALSE).endObject());  
        assertResult("{'geo':null}", () -> builder().startObject().field("geo", (GeoPoint) null).endObject());  
        mapA.put("d2", singletonMap("d3", mapD));
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1.toLocalDateTime()).endObject());  
            }  
        values[2] = values;
        final Calendar c1 = GregorianCalendar.from(ZonedDateTime.of(2010, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));  
        assertResult("{'integer':42}", () -> builder().startObject().field("integer").value(42).endObject());
        // LocalTime (no date, no time zone)
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);
        map1.put("map0", map0); // map 1 -> map 0 loop
            assertResult(expected, () -> builder().startObject().array("objects", o.getValue()).endObject());  
        objects.put("{'objects':[1,1,2,3,5,8,13]}", new Object[] { 1, 1, 2, 3, 5, 8, 13 });
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1.toInstant()).endObject());
            builder.endObject();
        objects.put("{'objects':[null,null,null]}", new Object[] { null, null, null });
        }  
            builder.array("array", "1", "2", "3");
            builder.startObject("foo");  
    }
            ByteArrayOutputStream os = new ByteArrayOutputStream();
    }
            assertSame(parser.nextToken(), Token.END_OBJECT);  
        }
        maps.put("{'map':null}", (Map<String, ?>) null);
import java.util.concurrent.atomic.AtomicBoolean;
            }
        List<Object> it1 = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();  
        return Matchers.equalTo(json.replace("'", "\""));
        }
            () -> builder().startObject().field("geo", GeoPoint.fromGeohash("u336q")).endObject()  
        );  
        };  
import java.util.Map;
    public void testBinaryUTF8() throws Exception {
        assertResult("{'d':null}", () -> builder().startObject().field("d", (Duration) null).endObject());
            "{'calendar':'2016-01-01T00:00:00.000Z'}",  
            doTestRawValue(xcontentType.xContent());
import java.util.GregorianCalendar;
        );
            () -> builder().startObject().field("d1").timeValue(d1.toLocalDateTime()).endObject()
            "{'xcontent':{'field':'value','array':['1','2','3'],'foo':{'bar':'baz'}}}",  
            public void close() {  
    }
        // Instant
    public void testToXContent() throws Exception {
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((OffsetTime) null).endObject());
            "{'unsigned_long':18446744073709551615}",
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, new byte[] {})
        XContentBuilder builder = builder().startObject().field("key", 1).field("key", 2).endObject();  
 * license agreements. See the NOTICE file distributed with
    }  
