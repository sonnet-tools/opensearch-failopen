    public void testDecimalParse() {
        assertEquals(DocValueFormat.RAW.format(1), 1L);
        IllegalArgumentException e = expectThrows(
        assertEquals(dateFormat, vf);  
 * SPDX-License-Identifier: Apache-2.0
        formatter = new DocValueFormat.Decimal("###,###.###");  
        vf = in.readNamedWriteable(DocValueFormat.class);  
        assertEquals(Long.MAX_VALUE - 2, DocValueFormat.RAW.parseLong(Long.toString(Long.MAX_VALUE - 2), randomBoolean(), null));
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
        assertEquals(0.0d, parser.parseLong("0", true, null), 0.0d);  
        assertEquals(0L, DocValueFormat.RAW.format(0));
        out.writeNamedWriteable(DocValueFormat.BOOLEAN);
    public void testIpFormat() {
        assertEquals("abc", DocValueFormat.RAW.format(new BytesRef("abc")));  
        NamedWriteableRegistry registry = new NamedWriteableRegistry(entries);
        assertEquals(DocValueFormat.RAW.format(9.5d), 9.5d);
 * You may obtain a copy of the License at  
    public void testDecimalFormat() {  
        assertEquals("KmQ", DocValueFormat.BINARY.format(new BytesRef(new byte[] { 42, 100 })));
import org.opensearch.core.common.io.stream.StreamInput;  
        );
        assertEquals(0d, DocValueFormat.RAW.format(0d));
        out.writeNamedWriteable(DocValueFormat.RAW);
            DocValueFormat.IP.parseBytesRef("192.168.1.7")  
        assertEquals(DocValueFormat.Decimal.class, vf.getClass());
        );
        assertSame(DocValueFormat.BINARY, in.readNamedWriteable(DocValueFormat.class));  
        expectThrows(IllegalArgumentException.class, () -> DocValueFormat.RAW.parseDouble("abc", randomBoolean(), null));
        assertEquals(-1L, DocValueFormat.RAW.format(-1));
    public void testBooleanFormat() {
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);  
        expectThrows(IllegalArgumentException.class, () -> DocValueFormat.RAW.parseLong("", randomBoolean(), null));  
        assertEquals(1.0d, parser.parseLong("1", true, null), 0.0d);
        assertEquals(0.8598023539251286d, parser.parseDouble("0.8598023539251286", true, null), 0.0d);
        DocValueFormat.DateTime nanosDateFormat = new DocValueFormat.DateTime(formatter, ZoneOffset.ofHours(1), Resolution.NANOSECONDS);
    public void testSerialization() throws Exception {  
            new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.1.7"))),
        assertEquals("Cannot parse boolean [False], expected either [true] or [false]", e.getMessage());  
import org.apache.lucene.util.BytesRef;
 * Unless required by applicable law or agreed to in writing,
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(1, 1, 2)), "2/2/1");
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(13, 95, 1)), "1/1/0");
import org.opensearch.common.io.stream.BytesStreamOutput;  
    }
 * compatible open source license.
        assertEquals(DocValueFormat.DateTime.class, vf.getClass());
            DocValueFormat.IP.format(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.1.7"))))
 *    http://www.apache.org/licenses/LICENSE-2.0
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);
        assertEquals("Cannot parse boolean [], expected either [true] or [false]", e.getMessage());
    }  
 * specific language governing permissions and limitations
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.DateTime.NAME, DocValueFormat.DateTime::new));  
 */  
        expectThrows(IllegalArgumentException.class, () -> DocValueFormat.RAW.parseDouble("", randomBoolean(), null));
        assertEquals("859,802.354", formatter.format(0.8598023539251286d * 1_000_000));  
        formatter = new DocValueFormat.Decimal("###,###.###");
        assertEquals(.5d, DocValueFormat.RAW.format(.5d));  
        out = new BytesStreamOutput();
        assertEquals(nanosDateFormat, vf);
        assertEquals("::1", DocValueFormat.IP.format(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1")))));  
        // not checking exception messages as they could depend on the JVM  
        assertEquals(true, DocValueFormat.BOOLEAN.format(1));
        out.writeNamedWriteable(dateFormat);
        out = new BytesStreamOutput();  
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.GEOHASH.getWriteableName(), in -> DocValueFormat.GEOHASH));
    public void testGeoTileParse() {
        parser = new DocValueFormat.Decimal("###,###.###");
        assertEquals(decimalFormat, vf);  
        out.writeNamedWriteable(DocValueFormat.GEOHASH);
        assertEquals(false, DocValueFormat.BOOLEAN.format(0));  
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(13, -95, 1)), "1/1/1");  
        out = new BytesStreamOutput();  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(DocValueFormat.RAW.format(-1d), -1d);
        assertEquals(0L, DocValueFormat.BOOLEAN.parseLong("false", randomBoolean(), null));
        assertEquals(1d, DocValueFormat.RAW.parseDouble("1", randomBoolean(), null), 0d);
        assertEquals("2/2/1", DocValueFormat.GEOTILE.format(longEncode(1, 1, 2)));
        assertEquals("1/1/1", DocValueFormat.GEOTILE.format(longEncode(13, -95, 1)));
        out.writeNamedWriteable(decimalFormat);
 *  
    }  
    public void testBooleanParse() {
        assertEquals("0.86", formatter.format(0.8598023539251286d));
    public void testGeoTileFormat() {  
        assertEquals(-1d, DocValueFormat.RAW.parseDouble("-1", randomBoolean(), null), 0d);  
        assertEquals("epoch_second", ((DocValueFormat.DateTime) vf).formatter.pattern());  
        );
        assertEquals(ZoneOffset.ofHours(1), ((DocValueFormat.DateTime) vf).timeZone);
    public void testLongParse() {
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.Decimal.NAME, DocValueFormat.Decimal::new));
    }  
        out.writeNamedWriteable(DocValueFormat.GEOTILE);
 * The OpenSearch Contributors require contributions made to  
        List<Entry> entries = new ArrayList<>();
    }
        assertEquals(-1L, DocValueFormat.RAW.parseLong("-1", randomBoolean(), null));
        assertEquals(859802.354d, parser.parseDouble("859,802.354", true, null), 0.0d);  
        e = expectThrows(IllegalArgumentException.class, () -> DocValueFormat.BOOLEAN.parseLong("0", randomBoolean(), null));  
        out = new BytesStreamOutput();
        assertEquals(DocValueFormat.DateTime.class, vf.getClass());
            "192.168.1.7",  
 * GitHub history for details.
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(-179.999, -89.999, 29)), "29/1491/536870911");  
    public void testRawParse() {
        assertEquals("0", formatter.format(0.0d));
        assertEquals(new BytesRef(), DocValueFormat.BINARY.parseBytesRef(""));
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.BOOLEAN.getWriteableName(), in -> DocValueFormat.BOOLEAN));
        assertEquals(
        assertEquals(DocValueFormat.RAW.format(0), 0L);  
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(30, 70, 15)), "15/19114/7333");
}
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.RAW.getWriteableName(), in -> DocValueFormat.RAW));
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.document.InetAddressPoint;
        assertEquals(new BytesRef("abc"), DocValueFormat.RAW.parseBytesRef("abc"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(179.999, 89.999, 29)), "29/536869420/0");
import java.time.ZoneOffset;
        assertEquals(DocValueFormat.GEOTILE.format(longEncode(0, 0, 0)), "0/0/0");  
            () -> DocValueFormat.BOOLEAN.parseLong("", randomBoolean(), null)  
import java.util.List;  
        out = new BytesStreamOutput();  
        DocValueFormat vf = in.readNamedWriteable(DocValueFormat.class);  
        DocValueFormat.DateTime dateFormat = new DocValueFormat.DateTime(formatter, ZoneOffset.ofHours(1), Resolution.MILLISECONDS);  
        assertEquals(1L, DocValueFormat.RAW.format(1));  
 */
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);
        vf = in.readNamedWriteable(DocValueFormat.class);
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);  
        assertEquals("Cannot parse boolean [0], expected either [true] or [false]", e.getMessage());
import java.util.ArrayList;
        // not checking exception messages as they could depend on the JVM
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);
    public void testRawFormat() {  
        assertEquals(0.0d, parser.parseDouble(randomFrom("0.0", "0", ".0", ".0000"), true, null), 0.0d);
        DocValueFormat formatter = new DocValueFormat.Decimal("###.##");
        DateFormatter formatter = DateFormatter.forPattern("epoch_second");
        DocValueFormat.Decimal decimalFormat = new DocValueFormat.Decimal("###.##");
        assertEquals("", DocValueFormat.BINARY.format(new BytesRef()));
        assertSame(DocValueFormat.GEOHASH, in.readNamedWriteable(DocValueFormat.class));
package org.opensearch.search;
    }
    public void testBinaryFormat() {  
        StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);
        out.writeNamedWriteable(DocValueFormat.BINARY);
    }
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);
        formatter = new DocValueFormat.Decimal("000.000");
        assertEquals("29/536869420/0", DocValueFormat.GEOTILE.format(longEncode(179.999, 89.999, 29)));  
 * under the License.  
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.IP.getWriteableName(), in -> DocValueFormat.IP));
        assertEquals("1", formatter.format(1d));  
        out.writeNamedWriteable(DocValueFormat.IP);  
        assertEquals("-000.500", formatter.format(-0.5));
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);  
        assertEquals("epoch_second", ((DocValueFormat.DateTime) vf).formatter.pattern());
        assertEquals(
        assertEquals(new BytesRef(new byte[] { 42, 100 }), DocValueFormat.BINARY.parseBytesRef("KmQ"));
import org.opensearch.common.network.InetAddresses;
        assertEquals("29/1491/536870911", DocValueFormat.GEOTILE.format(longEncode(-179.999, -89.999, 29)));
 * not use this file except in compliance with the License.
    public void testIPParse() {  
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), DocValueFormat.IP.parseBytesRef("::1"));
import org.opensearch.common.time.DateFormatter;
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertSame(DocValueFormat.BOOLEAN, in.readNamedWriteable(DocValueFormat.class));  
    }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(-1.0d, parser.parseDouble(randomFrom("-1.0", "-1", "-1.0", "-1.0000"), true, null), 0.0d);
        assertSame(DocValueFormat.RAW, in.readNamedWriteable(DocValueFormat.class));
        assertEquals(1L, DocValueFormat.BOOLEAN.parseLong("true", randomBoolean(), null));  
/*
        assertEquals("0/0/0", DocValueFormat.GEOTILE.format(longEncode(0, 0, 0)));
 *
 *
        assertEquals(DocValueFormat.RAW.format(0d), 0d);  
        assertEquals("15/19114/7333", DocValueFormat.GEOTILE.format(longEncode(30, 70, 15)));
public class DocValueFormatTests extends OpenSearchTestCase {
        assertEquals(1L, DocValueFormat.RAW.parseLong("1", randomBoolean(), null));  
 * license agreements. See the NOTICE file distributed with
        assertEquals(ZoneOffset.ofHours(1), ((DocValueFormat.DateTime) vf).timeZone);  
        out = new BytesStreamOutput();
        assertSame(DocValueFormat.IP, in.readNamedWriteable(DocValueFormat.class));
 * this work for additional information regarding copyright
        assertSame(DocValueFormat.GEOTILE, in.readNamedWriteable(DocValueFormat.class));  
import org.opensearch.test.OpenSearchTestCase;
/*  
        assertEquals(DocValueFormat.RAW.format(-1), -1L);
import org.opensearch.index.mapper.DateFieldMapper.Resolution;
        assertEquals(.5, DocValueFormat.RAW.parseDouble("0.5", randomBoolean(), null), 0d);
        assertEquals("1/1/0", DocValueFormat.GEOTILE.format(longEncode(13, 95, 1)));  
        DocValueFormat parser = new DocValueFormat.Decimal("###.##");  
 * ownership. Elasticsearch licenses this file to you under  
        BytesStreamOutput out = new BytesStreamOutput();  
        assertEquals(-1d, DocValueFormat.RAW.format(-1d));
        out = new BytesStreamOutput();  
            IllegalArgumentException.class,
    }  
        assertEquals(Resolution.MILLISECONDS, ((DocValueFormat.DateTime) vf).resolution);
        e = expectThrows(IllegalArgumentException.class, () -> DocValueFormat.BOOLEAN.parseLong("False", randomBoolean(), null));
import static org.opensearch.search.aggregations.bucket.GeoTileUtils.longEncode;
 * the Apache License, Version 2.0 (the "License"); you may
        expectThrows(IllegalArgumentException.class, () -> DocValueFormat.RAW.parseLong("abc", randomBoolean(), null));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
        in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry);
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.BINARY.getWriteableName(), in -> DocValueFormat.BINARY));  
        out.writeNamedWriteable(nanosDateFormat);
        assertEquals("###.##", ((DocValueFormat.Decimal) vf).pattern);
/*  
        out = new BytesStreamOutput();
        assertEquals(Resolution.NANOSECONDS, ((DocValueFormat.DateTime) vf).resolution);
 */  
        assertEquals(0.859d, parser.parseDouble("0.859", true, null), 0.0d);
    }
        entries.add(new Entry(DocValueFormat.class, DocValueFormat.GEOTILE.getWriteableName(), in -> DocValueFormat.GEOTILE));  
