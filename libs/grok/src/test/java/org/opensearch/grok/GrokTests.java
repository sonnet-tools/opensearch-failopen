        assertEquals(expected, actual);
    public void testGarbageTypeNameBecomesString() {
            Map<String, String> bank = new HashMap<>();
        List<Object> valueList = (List<Object>) value;  
        String grokPattern = "Bonsuche mit folgender Anfrage: Belegart->\\[%{WORD:param2},(?<param5>(\\s*%{NOTSPACE})*)\\] "
        Map<String, Object> actual = g.captures(text);  
        assertEquals("circular reference in pattern [NAME2][!!!%{NAME2}!!!]", e.getMessage());  
 * GitHub history for details.
 * software distributed under the License is distributed on an
        String logLine = "31.184.238.164 - - [24/Jul/2014:05:35:37 +0530] \"GET /logs/access.log HTTP/1.0\" 200 69849 "
        );
            + "\"Mozilla"
            bank.put("NAME3", "!!!%{NAME1}!!!");
        assertEquals("First IP should match", "192.168.1.1", ipList.get(0));
            Map<String, String> bank = new HashMap<>();
                Map.entry("timestamp", STRING),  
            new Grok(bank, pattern, false, logger::warn);
        Map<String, Object> matches = grok.captures(line);
        assertEquals("grokdebug", matches.get("syslog5424_app"));  
    public void testMatchWithoutCaptures() {
        assertCaptureConfig(grok, Map.of("foo", STRING));
                Map.entry("syslog5424_proc", STRING),
    public void testUnsupportedBracketsInFieldName() {
        Map<String, Object> matches = grok.captures("11/01/01");
                }
 * not use this file except in compliance with the License.
    }
        grok.match("[foo]");  
        GrokCaptureExtracter logsourceExtracter = namedConfig(grok, "logsource").nativeExtracter(new ThrowingNativeExtracterMap() {  
    }
    public void testNoNamedCaptures() {
import java.util.function.IntConsumer;
                }
        assertEquals("circular reference in pattern [NAME][!!!%{NAME:name:int}!!!]", e.getMessage());
            logger::warn  
        assertEquals("circular reference in pattern [NAME][!!!%{NAME}!!!]", e.getMessage());
    }
        assertEquals(null, matches.get("duration"));  
            "2001-01-1aT00:00:00", // invalid day
        );
                Map.entry("syslog5424_sd", STRING),
        assertCaptureConfig(g, Map.of("name", STRING, "status", BOOLEAN));
            bank.put("NAME", "!!!%{NAME:name:int}!!!");
            true
        expected.put("httpversion", "1.1");
/*  
        expected.put("bytes", 12009.34f);  
            bank.put("NAME1", "!!!%{NAME2}!!!");  
        assertEquals(true, g.match(text));
        assertNotNull("Should have matches", matches);  
    }
        assertEquals("1", matches.get("syslog5424_ver"));  
 * KIND, either express or implied.  See the License for the
    public void testDatePattern() {
    }
        assertThat(captureBytes(grok, utf8, 0, 1), equalTo(Map.of("n", 1)));
        Exception e = expectThrows(IllegalArgumentException.class, () -> {
        List<String> ipList = (List<String>) ip;
            + "/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.77 Safari/537.36\"";
            Thread t = new Thread(() -> {
            try {
            "2001-11-06T20:45:45-0000",
        Grok grok = new Grok(bank, pattern, logger::warn);  
        );  
    }  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{DATE_EU:stimestamp}", logger::warn);  
            e.getMessage()
            logger::warn
    }
        String text = "12009.34 200 9032";
            Object old = fromGrok.put(config.name(), config.type());
        );  
        Map<String, Object> matches = grok.captures("hello world");  
        }
            "2001-01-01T00:00:00+", // invalid timezone  
    }
        String text = "wowza !!!Tal!!! - Tal";
        GrokCaptureExtracter.MapExtracter extracter = new GrokCaptureExtracter.MapExtracter(grok.captureConfig());  
        byte[] utf8 = "10".getBytes(StandardCharsets.UTF_8);
        assertNotNull("Should have matches", matches);
        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
                + "%{GREEDYDATA:syslog_message}",
                Map.entry("bytes", STRING),
        );  
    }
        bank.put("MONTHDAY", "(?:(?:0[1-9])|(?:[12][0-9])|(?:3[01])|[1-9])");
        assertGrokedField("[m]etadata");
        AtomicReference<String> message = new AtomicReference<>();
        Object value = matches.get("value");
                Map.entry("program", STRING),
        assertNull(matches);
import static org.opensearch.grok.GrokCaptureType.INTEGER;
        }
        Grok g = new Grok(bank, pattern, logger::warn);
        Map<String, String> bank = new HashMap<>();  
        );
            "2001-01-01T00:00:aa", // invalid second
 * this file be licensed under the Apache-2.0 license or a
            String pattern = "%{NAME1}";  
 * license agreements. See the NOTICE file distributed with
        bank.put("DATA", ".*?");
        Map<String, Object> matches = grok.captures(line);
            Grok.BUILTIN_PATTERNS,
import static org.hamcrest.Matchers.is;
        Map<String, String> bank = new HashMap<>();
        Map<String, String> bank = new HashMap<>();
    }
            });
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{WORD:unsuppo(r)ted}", logger::warn);  
        GrokCaptureExtracter ratingExtracter = namedConfig(g, "rating").nativeExtracter(new ThrowingNativeExtracterMap() {
        Map<String, Object> matches = grok.captures("123 456");
    }
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),  
        List<String> timeMessages = Arrays.asList(
            bank.put("NAME1", "!!!%{NAME2:!!!");
 * SPDX-License-Identifier: Apache-2.0
                Map.entry("auth", STRING),  
            "2001-01-32T00:00:00", // invalid day  
        bank.put("SECOND", "(?:(?:[0-5]?[0-9]|60)(?:[:.,][0-9]+)?)");
            String pattern = "%{NAME}";
        String[] logsource = new String[1];
                Map.entry("verb", STRING)
                + "Chrome/32.0.1700.77 Safari/537.36\""
        String line = "foo";
        );  
        Grok g = new Grok(Grok.BUILTIN_PATTERNS, pattern, logger::warn);  
                Map.entry("syslog5424_host", STRING),  
            "2001-12-07T23:54:54.123456Z",  
        Exception e = expectThrows(RuntimeException.class, () -> grok.captures(logLine));  
        assertGrokedField("metadat[a]");
        e = expectThrows(IllegalArgumentException.class, () -> {
            }  
public class GrokTests extends OpenSearchTestCase {
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "^%{TIMESTAMP_ISO8601}$", logger::warn);  
    public void testNumericCapturesCoercion() {
 * specific language governing permissions and limitations
            "(?<![0-9])(?:(?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.]"
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");  
        e = expectThrows(IllegalArgumentException.class, () -> {
    }
        Grok grok = new Grok(bank, "%{SINGLEDIGIT:num}%{SINGLEDIGIT:num}", logger::warn);
        assertGrokedField(randomAlphaOfLengthBetween(1, 5));
                Map.entry("syslog_program", STRING),  
            new Grok(bank, pattern, false, logger::warn);
        String pattern = "%{NUMBER:f:not_a_valid_type}";  
        );  
        }
        return (delay, command) -> {
    }
    private abstract class ThrowingNativeExtracterMap implements NativeExtracterMap<GrokCaptureExtracter> {
        assertThat(specificCapture(g, text, ratingExtracter), is(true));  
        String text = "active=true";  
            t.start();  
        expected.put("request", "/presentations/logstash-monitorama-2013/images/kibana-dashboard3.png");  
        assertThat(g.captures("12009.34"), equalTo(Map.of("f", "12009.34")));  
        assertEquals("12-12-12 12:12:12", matches.get("timestamp"));  
        String line = "<191>1 2009-06-30T18:30:00+02:00 paxton.local grokdebug 4123 - [id1 foo=\\\"bar\\\"][id2 baz=\\\"something\\\"] "
        assertThat(id[0], equalTo(20000000000L));
            "2001-09-05T16:36:36.123456+0000",
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "(?<foo>\\w+)", logger::warn);
                Map.entry("response", INTEGER),  
            bank.put("NAME", "!!!%{NAME:name}!!!");
                Map.entry("httpversion", STRING),  
import static org.opensearch.grok.GrokCaptureType.FLOAT;
        // Input with two different IP addresses  
            String pattern = "%{NAME1}";  
            String pattern = "%{NAME1}";  
        bank.put("MONTHDAY", "(?:(?:0[1-9])|(?:[12][0-9])|(?:3[01])|[1-9])");  
            } catch (InterruptedException e) {
            "2001-01-01T00:aa:00", // invalid minute
            String pattern = "%{NAME}";  
            "circular reference in pattern [NAME3][!!!%{NAME1}!!!] back to pattern [NAME1] via patterns [NAME1=>NAME2]",
        expected.put("clientip", "83.149.9.216");
    }  
            Map<String, String> bank = new TreeMap<>();  
        @SuppressWarnings("unchecked")
            logger::warn,
    public void testMalformedPattern() {
        // Pattern with multiple fields, one of which appears multiple times
        };
        String pattern = "%{NUMBER:bytes:float} %{NUMBER:id:long} %{NUMBER:rating:double}";  
        boolean[] status = new boolean[1];
            "\\b(?:Jan(?:uary|uar)?|Feb(?:ruary|ruar)?|M(?:a|ä)?r(?:ch|z)?|Apr(?:il)?|Ma(?:y|i)?|Jun(?:e|i)"
            assertThat(grok.match(msg), is(true));
        Map<String, Object> expected = new HashMap<>();
            "2010-05-03T08:18:18.123456+00:00",
                Map.entry("syslog_timestamp", STRING)
        expected.put("ident", "-");
                + "(?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5]))(?![0-9])"
        bank.put("USER", "[a-zA-Z0-9._-]+");
                Map.entry("verb", STRING)
            + "kibana-dashboard3.png HTTP/1.1\" 200 171717 \"http://semicomplete.com/presentations/logstash-monitorama-2013/\" "  
    }
        expected.put("timestamp", "19/Jul/2015:08:13:42 +0000");
        BiConsumer<Long, Runnable> scheduler = getLongRunnableBiConsumer();
                + "|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)"
        Grok grok = new Grok(
            "1974-03-02T04:09:09",  
        Map<String, String> bank = new HashMap<>();
/*  
        Grok g = new Grok(bank, pattern, logger::warn);
    public void testCircularReference() {  
        Map<String, Object> matches = grok.captures("test 28.4ms");  
            )  
        assertCaptureConfig(g, Map.of("EXCITED_NAME_0", STRING, "NAME_21", STRING, "NAME_22", STRING));
    }
                return buildExtracter.apply(b -> status[0] = b);  
                Map.entry("timestamp", STRING),
                + "SPF permerror (Junk encountered in record 'v=spf1 mx a:mail.domain.no ip4:192.168.0.4 �all'): Envelope-from: "  
            Map.ofEntries(  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "test (N/A|%{BASE10NUM:duration}ms)", logger::warn);
import static org.hamcrest.Matchers.nullValue;
        List<String> timeMessages = Arrays.asList(
        bank.put(  
        bank.put("NUMBER", "(?:%{BASE10NUM})");
        assertEquals(line, matches.get(fieldName));
            new Grok(bank, pattern, false, logger::warn);
        expected.put("rating", 4820.092);
        assertEquals("Name should match", "Server", matches.get("name"));
        assertEquals(expected, actual);  
        Grok g = new Grok(bank, pattern, logger::warn);
        Object actual = g.captures(text);
    public void testMultipleCapturesWithSameFieldNameDifferentTypes() {
 * Licensed to Elasticsearch under one or more contributor  
        bank.put("INT", "(?:[+-]?(?:[0-9]+))");
        expected.put("status", true);  
    public void testNumericCaptures() {
            "agent",  
                Map.entry("ident", STRING),
            bank.put("NAME2", "!!!%{NAME1}!!!");
    public void testLogCallBack() {  
 * Unless required by applicable law or agreed to in writing,
        assertEquals("Second IP should match", "192.168.1.2", ipList.get(1));
import java.util.Collections;  
        assertEquals("(?<EXCITED_NAME_0>!!!(?<NAME_21>Tal)!!!) - (?<NAME_22>Tal)", g.toRegex(pattern));
        Map<String, Object> actual = g.captures(text);
        assertCaptureConfig(grok, Map.of("stimestamp", STRING));
            }  
        });  
    public void testMultipleNamedCapturesWithSameName() {
                Map.entry("syslog5424_app", STRING),
        assertEquals(expected, actual);  
        assertThat(matches.get("syslog_pri"), equalTo("22"));  
 * You may obtain a copy of the License at  
            public GrokCaptureExtracter forBoolean(Function<Consumer<Boolean>, GrokCaptureExtracter> buildExtracter) {
        assertEquals("postfix/smtpd", matches.get("program"));
                + ":((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?"  
        @Override
 * this work for additional information regarding copyright
                Map.entry("syslog_pid", STRING),
                Map.entry("referrer", STRING),  
        Grok grok = new Grok(
/*
        assertEquals("1713", matches.get("pid"));  
    }
        });
        BiConsumer<Long, Runnable> scheduler = getLongRunnableBiConsumer();  
import java.util.function.Function;
    public void testApacheLog() {  
        assertTrue("IP should be a List", ip instanceof List);
import static org.hamcrest.Matchers.equalTo;  
    }
            "IPV4",  
    }
        assertEquals("2009-06-30T18:30:00+02:00", matches.get("syslog5424_ts"));
            new Grok(bank, pattern, false, logger::warn);
        assertEquals("Second value should be a Long", Long.valueOf(456), valueList.get(1));  
    public void testDotInFieldName() {
            Map.ofEntries(
        @Override
            "1974-03-02T04:09:09.123456",
 *  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{JAVAFILE}", logger::warn);
            });  
            "<22>Jan  4 07:50:46 mailmaster postfix/policy-spf[9454]: : "
    }
    }  
        bank.put("NUMBER", "(?:%{BASE10NUM})");
        }  
        public GrokCaptureExtracter forString(Function<Consumer<String>, GrokCaptureExtracter> buildExtracter) {
        assertEquals("Second IP should match", "192.168.1.2", ipList.get(1));
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");  
        Map<String, Object> expected = new HashMap<>();
        assertTrue("Should be a List", value instanceof List);  
        @SuppressWarnings("unchecked")
        );
        }
            "2001-01-01T01:60:00", // invalid minute  
        });
    }
            + "Zustand->ABGESCHLOSSEN Kassennummer->2 Bonnummer->6362 Datum->Mon Jan 08 00:00:00 UTC 2018";
        List<String> ipList = (List<String>) ipaddress;
    private boolean specificCapture(Grok grok, String str, GrokCaptureExtracter extracter) {  
                + "\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4})"  
        assertGrokedField("@metadata");  
import org.opensearch.grok.GrokCaptureConfig.NativeExtracterMap;
 * compatible open source license.
        assertThat(specificCapture(g, text, statusExtracter), is(true));  
 *
            "2001-01-01T00:00:00.123456",  
        assertGrokedField("meta_data");
            try {  
        assertEquals("GET", matches.get("verb"));
                Map.entry("syslog5424_msg", STRING),
                Thread.sleep(delay);  
        assertThat(grok.match("Test_Class.class"), is(true));
            @Override
    private void assertCaptureConfig(Grok grok, Map<String, GrokCaptureType> nameToType) {
        e = expectThrows(IllegalArgumentException.class, () -> {
    public void testNilCoercedValues() {  
                Map.entry("syslog5424_ver", STRING)
            grok,  
import java.util.function.BiConsumer;
            String pattern = "%{NAME1}";
        assertEquals("Should have 2 elements", 2, ipList.size());  
        assertEquals("[id1 foo=\\\"bar\\\"][id2 baz=\\\"something\\\"]", matches.get("syslog5424_sd"));  
            Grok.BUILTIN_PATTERNS,
                + "\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4})"
            "2001-01-01T25:00:00", // invalid hour
        for (GrokCaptureConfig config : grok.captureConfig()) {
    }
        );
        assertEquals("evita", matches.get("logsource"));
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "test (N/A|%{BASE10NUM:duration:float}ms)", logger::warn);
        Map<String, String> bank = new HashMap<>();
            public GrokCaptureExtracter forFloat(Function<FloatConsumer, GrokCaptureExtracter> buildExtracter) {
        String line = "Mar 16 00:01:25 evita postfix/smtpd[1713]: connect from camomile.cloud9.net[168.100.1.3]";
            )
        bank.put("NUMBER", "(?:%{BASE10NUM})");
            "2001-01-01Ta0:00:00", // invalid hour  
        }  
            @Override
    public void testAtInFieldName() {
            grok,
}  
import java.util.Map;  
        // this message comes from Joni, so updates to Joni may change the expectation
        });
    }  
            Grok.BUILTIN_PATTERNS,  
        bank.put("MINUTE", "(?:[0-5][0-9])");
            new Grok(bank, pattern, false, logger::warn);
    public void testComplete() {  
                Thread.sleep(delay);
        bank.put("HOUR", "(?:2[0123]|[01]?[0-9])");
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "value", logger::warn);  
        public GrokCaptureExtracter forFloat(Function<FloatConsumer, GrokCaptureExtracter> buildExtracter) {
                Map.entry("syslog_message", STRING),  
        // Pattern with repeated capture groups for the same field  
import java.util.List;
    public void testUnderscoreInFieldName() {
        });
        expected.put(
        AtomicBoolean run = new AtomicBoolean(true);  
            bank.put("NAME2", "!!!%{NAME2}!!!");
                return buildExtracter.apply(str -> logsource[0] = str);  
    public void testISO8601() {
    }  
        e = expectThrows(IllegalArgumentException.class, () -> {
    public void testNoMatchingPatternInDictionary() {
        assertEquals(  
        assertEquals(null, matches.get("duration"));  
            grok,  
        bank.put("TIME", "(?!<[0-9])%{HOUR}:%{MINUTE}(?::%{SECOND})(?![0-9])");  
        matches = grok.captures("test N/A");
import java.util.function.LongConsumer;  
                Map.entry("logsource", STRING),
        assertThat(message.get(), containsString("regular expression has redundant nested repeat operator"));
        assertEquals("\"http://8rursodiol.enjin.com\"", matches.get("referrer"));  
import static org.opensearch.grok.GrokCaptureType.STRING;
            "2001-01-01T00:00:00",
        expected.put("NAME_22", "Tal");
    }
    }
                Map.entry("syslog_hostname", STRING),
            Thread t = new Thread(() -> {
        assertEquals(
        BiConsumer<Long, Runnable> scheduler = (delay, command) -> {
            "2004-07-04T12:27:27.123456-00:00",  
 * ownership. Elasticsearch licenses this file to you under  
        AtomicBoolean run = new AtomicBoolean(true); // to avoid a lingering thread when test has completed
            String pattern = "%{NAME1}";
        );
        assertEquals("24/Jul/2014:05:35:37 +0530", matches.get("timestamp"));  
        assertEquals("1.0", matches.get("httpversion"));  
            + "Hello, syslog.";  
import java.util.concurrent.atomic.AtomicBoolean;
    public void testNilWithNoCoercion() {  
            "2001-01-01T00:00:00-00:61" // invalid timezone  
        expected.put("auth", "-");  
        }
            logger::warn,  
        String text = "83.149.9.216 - - [19/Jul/2015:08:13:42 +0000] \"GET /presentations/logstash-monitorama-2013/images/"
        Grok grok = new Grok(
        assertEquals(null, matches.get("syslog5424_msgid"));
        Grok grok = new Grok(bank, "%{MONTHDAY:greatday}", logger::warn);
        public GrokCaptureExtracter forInt(Function<IntConsumer, GrokCaptureExtracter> buildExtracter) {  
        e = expectThrows(IllegalArgumentException.class, () -> {
                Map.entry("rawrequest", STRING),
    private GrokCaptureConfig namedConfig(Grok grok, String name) {
        assertEquals("Third IP should match", "192.168.1.3", ipList.get(2));  
        Map<String, Object> matches = grok.captures("line");
        assertCaptureConfig(
                Map.entry("request", STRING),
        assertEquals("-", matches.get("ident"));
            "2010-05-03T08:18:18+00:00",
        });
        Map<String, String> bank = new HashMap<>();
        assertCaptureConfig(grok, Map.of());  
        assertThat(grok.captures("no_match"), nullValue());  
        Map<String, Object> matches = grok.captures(
        matches = grok.captures("test N/A");
 */
    public void testCaputuresBytes() {  
        assertThat(specificCapture(grok, line, logsourceExtracter), is(true));  
    public void testMultipleCapturesWithSameFieldName() {  
        assertEquals(expected, actual);
            + "Zustand->ABGESCHLOSSEN Kassennummer->%{WORD:param9} Bonnummer->%{WORD:param10} Datum->%{DATESTAMP_OTHER:param11}";
                + "{4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\"
    }
            "%{IP:ipaddress} %{IP:ipaddress}",  
        GrokCaptureExtracter bytesExtracter = namedConfig(g, "bytes").nativeExtracter(new ThrowingNativeExtracterMap() {
        return null;
            throw new IllegalArgumentException();  
                    command.run();  
            true  
        assertThat(e.getMessage(), equalTo("Unable to find pattern [NOTFOUND] in Grok's pattern dictionary"));  
        BiConsumer<Long, Runnable> scheduler = getLongRunnableBiConsumer();
    public void testMinusInFieldName() {  
                + "email@domain.no"
            Grok.BUILTIN_PATTERNS,
        assertThat(grok.captures("12"), equalTo(expected));
            @Override
                Map.entry("httpversion", STRING),
    public void testSimpleSyslogLine() {  
        Map<String, Object> expected = new HashMap<>();  
        @Override  
        double[] rating = new double[1];  
        assertGrokedField("meta.data");  
        Exception e = expectThrows(IllegalArgumentException.class, () -> {
            Map<String, String> bank = new TreeMap<>();  
        public GrokCaptureExtracter forDouble(Function<DoubleConsumer, GrokCaptureExtracter> buildExtracter) {  
                Map.entry("priority", STRING),
        assertGrokedField("metad[a]ta");  
            + "HTTP/%{NUMBER:httpversion}\" %{NUMBER:response:int} (?:-|%{NUMBER:bytes:int}) %{QS:referrer} %{QS:agent}";
        assertEquals("/logs/access.log", matches.get("request"));
                throw new AssertionError(e);  
                Map.entry("clientip", STRING),
        assertEquals("191", matches.get("syslog5424_pri"));
    }  
            String pattern = "%{NAME1}";
            new Grok(bank, pattern, false, logger::warn);  
        bank.put("IP", "(?:%{IPV6}|%{IPV4})");
                throw new AssertionError(e);
            }
        GrokCaptureExtracter idExtracter = namedConfig(g, "id").nativeExtracter(new ThrowingNativeExtracterMap() {  
        assertTrue("Should be a List", ipaddress instanceof List);
        expected.put("verb", "GET");
        Map<String, Object> expected = new HashMap<>();
        assertThat(grok.match("Test Class.java"), is(true));  
            "2001-01-01T00:00:00-25", // invalid timezone
        @Override
            bank.put("NAME1", "!!!%{NAME2!!!");  
            t.start();
            throw new IllegalArgumentException();
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "^%{TIMESTAMP_ISO8601}$", logger::warn);
import java.util.HashMap;
            "2001-01-01T00:00:00+2500", // invalid timezone
            bank.put("NAME2", "!!!%{NAME3}!!!");
    public void assertNonAsciiLetterInFieldName() {  
        assertEquals("First value should be an Integer", Integer.valueOf(123), valueList.get(0));
            )
        expected.put("num", "1");  
        for (String msg : timeMessages) {
 */  
        assertEquals("circular reference in pattern [NAME2][!!!%{NAME1}!!!] back to pattern [NAME1]", e.getMessage());
            true
 *
            "((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]"
                Map.entry("response", STRING),
    }  
import java.util.concurrent.atomic.AtomicReference;  
                + "d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]"  
        assertCaptureConfig(grok, Map.of("num", STRING));  
    }  
            throw new IllegalArgumentException();
        assertThat(fromGrok, equalTo(new TreeMap<>(nameToType)));
        @Override
import java.util.function.DoubleConsumer;  
        });
            + "Chrome/30.0.1599.12785 YaBrowser/13.12.1599.12785 Safari/537.36\" \"www.dlwindianrailways.com\"";  
            "2001-09-05T16:36:36+0000",  
            public GrokCaptureExtracter forDouble(java.util.function.Function<DoubleConsumer, GrokCaptureExtracter> buildExtracter) {
        String pattern = "%{EXCITED_NAME} - %{NAME}";  
        assertThat(captureBytes(grok, utf8, 3, 2), equalTo(Map.of("n", 11)));
            public GrokCaptureExtracter forString(Function<Consumer<String>, GrokCaptureExtracter> buildExtracter) {
            "2001-01-00T00:00:00", // invalid day
        assertThat(logsource[0], equalTo("evita"));
        assertThat(grok.captures("prefix_value"), equalTo(Map.of()));
        public GrokCaptureExtracter forLong(Function<LongConsumer, GrokCaptureExtracter> buildExtracter) {
            Map<String, String> bank = new HashMap<>();  
        );
        assertThat(e.getMessage(), equalTo("grok pattern matching was interrupted after [200] ms"));
                + "?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|O(?:c|k)?t(?:ober)?|Nov(?:ember)?|De(?:c|z)(?:ember)?)\\b"  
        Object ipaddress = matches.get("ipaddress");
        expected.put("name", "active");
            "MONTH",
        String pattern = "%{NUMBER:bytes:float} %{NUMBER:status} %{NUMBER}";  
                + "(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}"
                    command.run();
package org.opensearch.grok;
        String line = "fancy 12-12-12 12:12:12";
 * Modifications Copyright OpenSearch Contributors. See
            "2001-12-07T23:54:54Z",
        assertThat(specificCapture(g, text, idExtracter), is(true));  
        assertThat(captureBytes(grok, utf8, 6, 2), equalTo(Map.of("n", 12)));
        Map<String, Object> matches = grok.captures(logLine);
        assertCaptureConfig(g, Map.of("bytes", FLOAT, "id", LONG, "rating", DOUBLE));
        }
        Map<String, Object> actual = g.captures(text);
            "2001-12-07T23:54:60.123456Z" // '60' second is a leap second.
            new Grok(bank, pattern, false, logger::warn);  
    public void testNoMatch() {
                Map.entry("syslog5424_ts", STRING),  
        if (grok.match(utf8, offset, length, extracter)) {
        bank.put(
import static org.opensearch.grok.GrokCaptureType.LONG;  
        Map<String, String> bank = new HashMap<>();
            )
            bank.put("NAME1", "!!!%{NAME2}!!!");  
        bank.put(  
        Map<String, Object> matches = grok.captures("Server has IPs: 192.168.1.1, 192.168.1.2 and 192.168.1.3");
        Map<String, Object> actual = grok.captures(text);
                Map.entry("timestamp8601", STRING)
            e.getMessage()
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{COMBINEDAPACHELOG}", logger::warn);
        assertCaptureConfig(g, Map.of("f", STRING));
        bank.put("QS", "(?>(?<!\\\\)(?>\"(?>\\\\.|[^\\\\\"]+)+\"|\"\"|(?>'(?>\\\\.|[^\\\\']+)+')|''|(?>`(?>\\\\.|[^\\\\`]+)+`)|``))");  
    public void testAlphanumericFieldName() {
                return buildExtracter.apply(f -> bytes[0] = f);
            Map<String, String> bank = new TreeMap<>();
            + "\"http://8rursodiol.enjin.com\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) "
        assertThat(matches.get("stimestamp"), equalTo("11/01/01"));  
        assertEquals("connect from camomile.cloud9.net[168.100.1.3]", matches.get("message"));
        assertThat(grok.captures("nomatch"), nullValue());
        assertEquals("-", matches.get("auth"));
        );  
        return grok.captureConfig().stream().filter(i -> i.name().equals(name)).findFirst().get();  
            bank.put("NAME5", "!!!%{NAME1}!!!");
import java.nio.charset.StandardCharsets;
                Map.entry("agent", STRING),
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "{1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:)"
        float[] bytes = new float[1];
        assertEquals("28.4", matches.get("duration"));
            "2001-01-aT00:00:00", // invalid day
        Map<String, Object> expected = new HashMap<>();
        assertEquals("Should have 3 IPs", 3, ipList.size());  
        }
        assertThat(captureBytes(grok, utf8, 0, 2), equalTo(Map.of("n", 10)));  
        assertThat(captureBytes(grok, utf8, 0, utf8.length), equalTo(Map.of("n", 10)));  
    private Map<String, Object> captureBytes(Grok grok, byte[] utf8, int offset, int length) {
    private static BiConsumer<Long, Runnable> getLongRunnableBiConsumer() {
        });
    }
        e = expectThrows(IllegalArgumentException.class, () -> {
        bank.put("NAME", "Tal");
        assertEquals("69849", matches.get("bytes"));
            } catch (InterruptedException e) {
        return grok.match(utf8, 0, utf8.length, extracter);
        assertEquals("4123", matches.get("syslog5424_proc"));
    public void testNamedFieldsWithWholeTextMatch() {
    }
        assertThat(status[0], equalTo(true));
                Map.entry("syslog_pri", STRING),
        long[] id = new long[1];
        });
            }  
        );
                return buildExtracter.apply(d -> rating[0] = d);  
                Map.entry("clientip", STRING),
        @Override  
        assertCaptureConfig(
        assertGrokedField(randomAlphaOfLengthBetween(1, 5) + randomIntBetween(0, 100));  
        // Input with a name and three IPs
    public void testJavaFilePatternWithSpaces() {
        e = expectThrows(IllegalArgumentException.class, () -> {
        });
                return buildExtracter.apply(l -> id[0] = l);  
        });
        // Test a more complex pattern with multiple captures of the same field
        assertCaptureConfig(grok, Map.of("duration", STRING));
        Grok grok = new Grok(  
    }
        expected.put("bytes", 12009.34f);  
        );  
    private void assertGrokedField(String fieldName) {
                + "%{SYSLOGHOST:syslog_hostname} %{PROG:syslog_program}(:?)(?:\\[%{GREEDYDATA:syslog_pid}\\])?(:?) "
        assertThat(specificCapture(g, text, bytesExtracter), is(true));
 */  
        assertCaptureConfig(grok, Map.of("duration", FLOAT));
        // Pattern with repeated capture groups for the same field with different types
            Map.ofEntries(
 * the Apache License, Version 2.0 (the "License"); you may
        assertGrokedField(randomIntBetween(0, 100) + randomAlphaOfLengthBetween(1, 5));
                Map.entry("auth", STRING),
import static org.opensearch.grok.GrokCaptureType.BOOLEAN;
            )
                if (run.get()) {  
            Map.ofEntries(
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
            String pattern = "%{NAME1}";
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
            String pattern = "%{NAME}";
            Map<String, String> bank = new HashMap<>();  
        assertEquals("Should have 2 elements", 2, valueList.size());
        assertCaptureConfig(
        assertThat(rating[0], equalTo(4820.092));
                Map.entry("referrer", STRING),
    }
        assertEquals("Malformed pattern [NAME1][!!!%{NAME2:!!!]", e.getMessage());
            Map<String, String> bank = new TreeMap<>();  
                bank.put("NAME" + i, "!!!%{NAME" + (i + 1) + "}!!!");
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{NUMBER:n:int}", logger::warn);
        assertEquals("Mar 16 00:01:25", matches.get("timestamp"));  
            "2001-01-01T00:00:00+25:00", // invalid timezone  
        String text = "12009.34 20000000000 4820.092";
            grok,
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
        );
    public void testJavaClassPatternWithUnderscore() {
    }  
        assertEquals("Malformed pattern [NAME1][!!!%{NAME2!!!]", e.getMessage());
    }  
            "2001-13-01T00:00:00", // invalid month  
        assertEquals(28.4f, matches.get("duration"));
    public void assertSquareBracketInFieldName() {
        bank.put("SINGLEDIGIT", "[0-9]");
    public void testExponentialExpressions() {
        expected.put("EXCITED_NAME_0", "!!!Tal!!!");  
        Map<String, Object> expected = new HashMap<>();
            bank.put("NAME", "!!!%{NAME}!!!");  
            Grok.BUILTIN_PATTERNS,  
            assertThat("duplicates not allowed", old, nullValue());  
            return extracter.result();
            "2001-01-01T00:00:00-2500", // invalid timezone
            "%{WORD:name} has IPs: %{IP:ip}, %{IP:ip} and %{IP:ip}",
        });  
            }
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{WORD:" + fieldName + "}", logger::warn);  
            assertThat(grok.match(msg), is(false));  
        };
        );  
        assertEquals(  
        public GrokCaptureExtracter forBoolean(Function<Consumer<Boolean>, GrokCaptureExtracter> buildExtracter) {
                + "|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))"  
    }
            }
        Map<String, GrokCaptureType> fromGrok = new TreeMap<>();  
            grok,  
            "2001-01-01T00:00:00+25", // invalid timezone
            new Grok(bank, pattern, false, logger::warn);
            @Override  
        );
            throw new IllegalArgumentException();
        bank.put("WORD", "\\b\\w+\\b");  
    public void testSyslog5424Line() {
            throw new IllegalArgumentException();
            bank.put("NAME1", "!!!%{NAME2}!!!");
        assertEquals("circular reference in pattern [NAME][!!!%{NAME:name}!!!]", e.getMessage());  
            new Grok(bank, pattern, false, logger::warn);
                Map.entry("timestamp", STRING),  
        assertCaptureConfig(  
            public GrokCaptureExtracter forLong(Function<LongConsumer, GrokCaptureExtracter> buildExtracter) {
        assertCaptureConfig(g, Map.of("bytes", FLOAT, "status", STRING));
            grokPattern,
    }
        assertEquals("First IP should match", "192.168.1.1", ipList.get(0));
import static org.opensearch.grok.GrokCaptureType.DOUBLE;  
        assertCaptureConfig(grok, Map.of());
                + "{1,5})"
            "2004-07-04T12:27:27-00:00",
                Map.entry("bytes", INTEGER),  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{SYSLOGLINE}", logger::warn);
    public void testWithOniguramaNamedCaptures() {  
        String logLine = "Bonsuche mit folgender Anfrage: Belegart->[EINGESCHRAENKTER_VERKAUF, VERKAUF, NACHERFASSUNG] "  
            bank.put("NAME1", "!!!%{NAME2}!!!");
        assertEquals("Pattern references exceeded maximum depth of 500", e.getMessage());
import java.util.Arrays;
    }
        assertGrokedField("meta-data");
                Map.entry("message", STRING),
        bank.put("IPORHOST", "(?:%{IP}|%{HOSTNAME})");  
        assertEquals("Hello, syslog.", matches.get("syslog5424_msg"));
        assertEquals(expected, actual);
        for (String msg : timeMessages) {  
        // Test that multiple captures with the same field name are collected into a list
        assertNotNull("Should have matches", matches);
        String pattern = "%{WORD:name}=%{WORD:status:boolean}";
import org.opensearch.test.OpenSearchTestCase;
        assertThat(matches.get("foo"), equalTo("hello"));
        Grok g = new Grok(bank, pattern, false, logger::warn);
        expected.put("referrer", "\"http://semicomplete.com/presentations/logstash-monitorama-2013/\"");
        expected.put("status", "200");
        );  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{JAVACLASS}", logger::warn);  
            "%{NUMBER:value:int} %{NUMBER:value:long}",
import java.util.function.Consumer;
        assertEquals("31.184.238.164", matches.get("clientip"));  
            }
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");  
            "\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) "
    }
            "circular reference in pattern [NAME5][!!!%{NAME1}!!!] back to pattern [NAME1] " + "via patterns [NAME1=>NAME2=>NAME3=>NAME4]",
            matches.get("agent")
    public void testBooleanCaptures() {
            Map<String, String> bank = new HashMap<>();
        assertEquals("paxton.local", matches.get("syslog5424_host"));
            "2001-01-01T0:00:00", // invalid hour
        assertEquals("200", matches.get("response"));
        expected.put("response", 200);
        assertThat(grok.captures("value"), equalTo(Map.of()));
                if (run.get()) {
    }
            throw new IllegalArgumentException();  
        assertGrokedField("metädata");
            "\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.12785 "  
        Map<String, Object> matches = grok.captures(line);
                Map.entry("pid", STRING),  
        expected.put("id", 20000000000L);
        Map<String, Object> matches = grok.captures(line);
            logger::warn,  
        assertGrokedField(String.valueOf(randomIntBetween(0, 100)));
        });
        Map<String, Object> matches = grok.captures("test 28.4ms");  
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");
    public void testUnicodeSyslog() {  
        run.set(false);
            Map.ofEntries(
    public void testNotISO8601() {
        assertCaptureConfig(grok, Map.of("timestamp", STRING));
            for (int i = 1; i <= 501; i++) {
 * The OpenSearch Contributors require contributions made to  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{SYSLOG5424LINE}", logger::warn);
        expected.put("NAME_21", "Tal");
            bank.put("NAME4", "!!!%{NAME5}!!!");
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, ".*\\[.*%{SPACE}*\\].*", message::set);
        }  
                Map.entry("ident", STRING),  
            "IPV6",
            "2001-01-01T00:00:-1", // invalid second  
        assertEquals(null, matches.get("port"));
import java.util.TreeMap;
                + "YaBrowser/13.12.1599.12785 Safari/537.36\"",
        // Input with two different numbers
        bank.put("EXCITED_NAME", "!!!%{NAME:name}!!!");
        Map<String, Object> matches = grok.captures("192.168.1.1 192.168.1.2");
    }
        String pattern = "%{IPORHOST:clientip} %{USER:ident} %{USER:auth} \\[%{HTTPDATE:timestamp}\\] \"%{WORD:verb} %{DATA:request} "  
        Exception e = expectThrows(IllegalArgumentException.class, () -> new Grok(Collections.emptyMap(), "%{NOTFOUND}", logger::warn));
 * under the License.  
        assertThat(bytes[0], equalTo(12009.34f));  
        utf8 = "10 11 12".getBytes(StandardCharsets.UTF_8);
            "2001-00-01T00:00:00", // invalid month
                Map.entry("syslog5424_msgid", STRING),
        bank.put("YEAR", "(?>\\d\\d){1,2}");  
            Map<String, String> bank = new TreeMap<>();
        });  
        e = expectThrows(IllegalArgumentException.class, () -> {  
        bank.put("TEST", "hello world");  
        GrokCaptureExtracter statusExtracter = namedConfig(g, "status").nativeExtracter(new ThrowingNativeExtracterMap() {  
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "(?<timestamp>%{DATE_EU} %{TIME})", logger::warn);  
                Map.entry("facility", STRING),  
            bank.put("NAME2", "!!!%{NAME3}!!!");
    }  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new Grok(bank, pattern, false, logger::warn);  
        assertThat(matches.get("tags"), nullValue());
                Map.entry("agent", STRING),
                Map.entry("request", STRING),
        bank.put("HOSTNAME", "\\b(?:[0-9A-Za-z][0-9A-Za-z-]{0,62})(?:\\.(?:[0-9A-Za-z][0-9A-Za-z-]{0,62}))*(\\.?|\\b)");
        Grok grok = new Grok(
import static org.hamcrest.Matchers.containsString;
        Object ip = matches.get("ip");
            "<%{POSINT:syslog_pri}>%{SPACE}%{SYSLOGTIMESTAMP:syslog_timestamp} "  
            bank.put("NAME3", "!!!%{NAME4}!!!");  
    public void testMultipleCapturesWithSameFieldNameInComplexPattern() {  
            "2001-01-01T00:00:61", // invalid second
        @SuppressWarnings("unchecked")
        bank.put("NUMBER", "(?:%{BASE10NUM})");
        assertThat(matches.get("syslog_program"), equalTo("postfix/policy-spf"));
                Map.entry("syslog5424_pri", STRING),  
        });
        assertCaptureConfig(
            "2001-01-01T00:00:00A", // invalid timezone
    }  
            }
        bank.put("HTTPDATE", "%{MONTHDAY}/%{MONTH}/%{YEAR}:%{TIME} %{INT}");
        expected.put("bytes", 171717);  
            "2001-11-06T20:45:45.123456-0000",
