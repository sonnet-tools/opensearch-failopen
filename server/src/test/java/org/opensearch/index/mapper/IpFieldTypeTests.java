                    true,
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field", true, false, false, null, Collections.emptyMap());
        );  
import org.apache.lucene.search.MatchNoDocsQuery;
                    ((PointRangeQuery) query).getField(),  
                "field",  
                SortedSetDocValuesField.newSlowRangeQuery(
        assertNotEquals("obey DocValues", indexOnly.termsQuery(List.of("::2/16"), null), indexDv.termsQuery(List.of("::2/16"), null));  
            new IndexOrDocValuesQuery(  
import org.apache.lucene.document.InetAddressPoint;  
            ft.termQuery(ip, null)
            // same lo/hi values but inclusive=false so this won't match anything  
            ft.rangeQuery(null, "192.168.2.0", randomBoolean(), true, null, null, null, null)
            .build(context)
        );
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        Query query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
        IpFieldMapper.IpFieldType dvOnly = new IpFieldMapper.IpFieldType("field", false, false, true, null, Collections.emptyMap());
                    true
        assertEquals(ip, ft.valueForDisplay(asBytes));
                    true
                "field",
        assertTrue(((ConstantScoreQuery) actual).getQuery() instanceof BooleanQuery);  
    }  
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::1:0:0:0"), InetAddressPoint.MAX_VALUE);  
package org.opensearch.index.mapper;
 * Licensed to Elasticsearch under one or more contributor  
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::1"), InetAddresses.forString("2001:db8::fffe"));
        assertEquals(
import org.apache.lucene.search.IndexOrDocValuesQuery;  
                "field",
                query,
    }  
                    true,
            new IndexOrDocValuesQuery(
    private static BytesRef ipToByteRef(String ipString) {
        String ip = "2001:db8::2:1";
                SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint()))  
                SortedSetDocValuesField.newSlowRangeQuery(
            ),  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("::1", null));  
 *  
        );  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
        assertEquals(  
                null,
    public void testFetchSourceValue() throws IOException {
                    ((PointRangeQuery) query).getField(),  
                    ((PointRangeQuery) query).getField(),  
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
    public void testValueFormat() throws Exception {
        assertEquals(Collections.singletonList("2001:db8::2:1"), fetchSourceValue(mapper, "2001:db8::2:1"));  
                ipToByteRef("::ffff:ffff:ffff:ffff:ffff:ffff:ffff"),
        MappedFieldType dvOnly = new IpFieldMapper.IpFieldType("field", false, false, true, null, Collections.emptyMap());
import org.apache.lucene.search.BooleanQuery;
                    true
            new IndexOrDocValuesQuery(
        assertEquals(Collections.singletonList("2001:db8::2:1"), fetchSourceValue(mapper, "2001:db8:0:0:0:0:2:1"));
import java.util.Arrays;  
                ipToByteRef("::"),  
                )
                    "field",
            new IndexOrDocValuesQuery(  
import org.apache.lucene.search.BooleanClause.Occur;  
        );
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field");
            ft.rangeQuery(
                query,
        Query query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
                    "field",
        );  
        Query query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddressPoint.MAX_VALUE);
                    ((PointRangeQuery) query).getField(),  
        assertEquals(ip, ft.docValueFormat(null, null).format(asBytes));  
            ft.rangeQuery("2001:db8::", null, true, randomBoolean(), null, null, null, null)
        asBytes = new BytesRef(InetAddressPoint.encode(InetAddresses.forString(ip)));
        assertTrue(actual instanceof ConstantScoreQuery);
 */
        ip = "192.168.1.7";  
        String ip = "2001:db8::2:1";  
        // if the list includes a prefix query we fallback to a bool query  
            new IndexOrDocValuesQuery(  
                query,
            dvOnly.termQuery(prefix, null)
            () -> unsearchable.rangeQuery("::1", "2001::", true, true, null, null, null, null)
        assertEquals(
        );  
            ),  
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),  
        BytesRef asBytes = new BytesRef(InetAddressPoint.encode(InetAddresses.forString(ip)));  
                SortedSetDocValuesField.newSlowRangeQuery(  
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
            new IndexOrDocValuesQuery(
        MappedFieldType indexOnly = new IpFieldMapper.IpFieldType("field", true, false, false, null, Collections.emptyMap());  
import org.apache.lucene.util.BytesRef;
                    ((PointRangeQuery) query).getField(),  
                    true
 * this work for additional information regarding copyright
                    true
            ft.rangeQuery(null, null, randomBoolean(), randomBoolean(), null, null, null, null)
        assertEquals(
            ft.rangeQuery("::ffff:c0a8:107", "2001:db8::", true, true, null, null, null, null)
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
            ft.rangeQuery("2001:db8::1", "2001:db8::1", false, false, null, null, null, null)
        assertEquals(
        assertEquals(Collections.singletonList("::1"), fetchSourceValue(mapper, "0:0:0:0:0:0:0:1"));
        );
                )  
/*
                    ((PointRangeQuery) query).getField(),  
        assertEquals(  
    }
            ),
            ),
            new MatchNoDocsQuery(),
        assertEquals(ip, ft.valueForDisplay(asBytes));
    }
            ),  
        assertEquals(
            ),  
        Query actual = ft.termsQuery(Arrays.asList("::42", "::2/16"), null);
        query = InetAddressPoint.newPrefixQuery("field", InetAddresses.forString(ip), 64);  
                )
            new IndexOrDocValuesQuery(  
                    true
 *
                    true
                    ipToByteRef("::ffff:192.168.255.255"),  
                true  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("192.168.1.7"), InetAddresses.forString("2001:db8::"));
            ft.rangeQuery(null, "192.168.2.0", randomBoolean(), false, null, null, null, null)
        ip = "192.168.1.7";
        ip = "192.168.1.7";
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        MappedFieldType unsearchable = new IpFieldMapper.IpFieldType("field", false, false, false, null, Collections.emptyMap());
            ft.rangeQuery("::", "0.0.0.0", true, false, null, null, null, null)  
        query = InetAddressPoint.newPrefixQuery("field", InetAddresses.forString(ip), 16);
                false,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field");
        assertEquals(expect.build(), dvOnly.termsQuery(Arrays.asList("::42", "::2/16"), null));
                SortedSetDocValuesField.newSlowRangeQuery(
            new IndexOrDocValuesQuery(indexOnly.termsQuery(List.of("::2/16"), null), dvOnly.termsQuery(List.of("::2/16"), null)),  
                    true,  
    }
    }  
                    ipToByteRef("::ffff:192.168.0.0"),
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
                SortedSetDocValuesField.newSlowRangeQuery(
    public void testDvOnlyTermQuery() {
 */  
                    true  
    }
        );
 * this file be licensed under the Apache-2.0 license or a
        );
        assertEquals(  
        assertEquals(new MatchNoDocsQuery(), ft.rangeQuery("::", "::", true, false, null, null, null, null));  
                "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff",  
            new IndexOrDocValuesQuery(
                )
        );  
            new IndexOrDocValuesQuery(  
                )  
        query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
                )
                SortedSetDocValuesField.newSlowRangeQuery(
        assertEquals(
                query,
 */
                )  
 * Unless required by applicable law or agreed to in writing,
                    true,
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
import java.io.IOException;
        // multirange handles both
            ft.rangeQuery("2001:db8::", null, false, randomBoolean(), null, null, null, null)
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::1"), InetAddressPoint.MAX_VALUE);
import java.net.InetAddress;
            ),  
        expect.add(ipToByteRef("::42"));  
                ipToByteRef("2001:db8:0:0:0:0:0:0"),
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddresses.forString("::fffe:ffff:ffff"));
        // Upper bound is the min IP and is not inclusive
        assertEquals(
        assertEquals(2, bq.clauses().size());
import org.apache.lucene.search.ConstantScoreQuery;
            ft.termsQuery(Arrays.asList(InetAddresses.forString("::2"), InetAddresses.forString("::5")), null)
        ip = "192.168.1.7";  
            dvOnly.termsQuery(Arrays.asList(InetAddresses.forString("::2"), InetAddresses.forString("::5")), null)
        assertEquals(
                    true,  
                query,
 * specific language governing permissions and limitations
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddresses.forString("192.168.1.255"));
        );
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
        assertEquals(
        ip = "2001:db8::2:1";  
            ),
                )
            ),
                    ((PointRangeQuery) query).getField(),
        DocValuesMultiRangeQuery.SortedSetStabbingBuilder expect = new DocValuesMultiRangeQuery.SortedSetStabbingBuilder("field");
            SortedSetDocValuesField.newSlowSetQuery("field", List.of(ipToByteRef("::2"), ipToByteRef("::5"))),
    public void testDvOnlyTermsQuery() {  
                    true,  
 * GitHub history for details.
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::"), InetAddressPoint.MAX_VALUE);
        );
            ),
                query,
                    true,  
        );
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());  
                query,
            ),
        );
        String prefix = ip + "/64";
        );  
        assertEquals(
        ip = "2001:db8::2:1";
import org.apache.lucene.sandbox.search.DocValuesMultiRangeQuery;
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
            new IndexOrDocValuesQuery(  
        assertEquals(  
            indexDv.termsQuery(List.of("::2/16"), null)
        assertEquals(  
        prefix = ip + "/16";
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::2"), InetAddresses.forString("2001:db8::"));
                query,  
    public void testTermQuery() {
            IllegalArgumentException.class,
                )
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint()))
                query,
        return new BytesRef(Objects.requireNonNull(InetAddresses.ipStringToBytes(ipString)));  
 * under the License.  
            SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint())),
        MappedFieldType dvOnly = new IpFieldMapper.IpFieldType("field", false, false, true, null, Collections.emptyMap());
            ft.rangeQuery("255.255.255.255", "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff", false, true, null, null, null, null)
    }
            new IndexOrDocValuesQuery(  
        assertEquals(
        );
        MappedFieldType indexDv = new IpFieldMapper.IpFieldType("field", true, false, true, null, Collections.emptyMap());
    public void testTermsQuery() {  
            SortedSetDocValuesField.newSlowRangeQuery(
                    true,
                true
            new IndexOrDocValuesQuery(
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                ipToByteRef("::ffff:192.168.255.255"),  
        assertEquals(
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),  
    public void testValueForSearch() {  
                query,
            )
        );
                true
        BooleanQuery bq = (BooleanQuery) ((ConstantScoreQuery) actual).getQuery();
            ),
                SortedSetDocValuesField.newSlowRangeQuery(
            dvOnly.termQuery(prefix, null)  
            InetAddressPoint.newSetQuery("field", InetAddresses.forString("::2"), InetAddresses.forString("::5")),
                    ((PointRangeQuery) query).getField(),  
        ip = "192.168.1.7";  
import org.opensearch.Version;
        expect.add(ipToByteRef("::"), ipToByteRef("::ffff:ffff:ffff:ffff:ffff:ffff:ffff"));
                    ipToByteRef("2001:db8:0:0:0:0:0:0"),  
            SortedSetDocValuesField.newSlowSetQuery("field", List.of(ipToByteRef("::2"), ipToByteRef("::5"))),
                    true  
/*
    public void testDvVsPoint() {
            ft.rangeQuery("2001:db8::", "2001:db8::ffff", false, false, null, null, null, null)
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;
                    true
            SortedSetDocValuesField.newSlowRangeQuery(
        String ip = "2001:db8::2:1";  
            ft.rangeQuery("2001:db8::", "2001:db8::ffff", true, true, null, null, null, null)
        );  
                )
public class IpFieldTypeTests extends FieldTypeTestCase {
            dvOnly.termQuery(ip, null)
        assertEquals(SortedSetDocValuesField.newSlowExactQuery("field", ipToByteRef("::2")), dvOnly.termsQuery(List.of("::2"), null));
                SortedSetDocValuesField.newSlowRangeQuery(  
            dvOnly.termsQuery(Arrays.asList("::2", "::5"), null)  
                SortedSetDocValuesField.newSlowRangeQuery(
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                true,
import java.util.List;
        assertEquals(
    }
            .fieldType();  
import org.apache.lucene.search.PointRangeQuery;
            SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint())),  
            ),  
            ),  
            // same lo/hi values but inclusive=false so this won't match anything
                query,  
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::"), InetAddresses.forString("2001:db8::ffff"));
            ft.termQuery(prefix, null)
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddresses.forString("192.168.2.0"));
        assertEquals(
        );
                query,
        assertEquals(  
                SortedSetDocValuesField.newSlowRangeQuery(
        ip = "192.168.1.7";  
                    true,
                true,  
            ),  
import org.apache.lucene.document.SortedSetDocValuesField;
            ),
        BytesRef asBytes = new BytesRef(InetAddressPoint.encode(InetAddress.getByName(ip)));
                ipToByteRef("2001:db8:0:0:ffff:ffff:ffff:ffff"),
        assertEquals(Collections.singletonList("2001:db8::2:7"), fetchSourceValue(nullValueMapper, null));
            dvOnly.termQuery(ip, null)  
            ft.termQuery(ip, null)  
 * ownership. Elasticsearch licenses this file to you under  
        MappedFieldType unsearchable = new IpFieldMapper.IpFieldType("field", false, false, false, null, Collections.emptyMap());
        IllegalArgumentException e = expectThrows(  
        prefix = ip + "/16";
                "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff",
            new IndexOrDocValuesQuery(
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field", true, false, true, null, Collections.emptyMap());  
 * KIND, either express or implied.  See the License for the
 *
        query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));  
import org.opensearch.cluster.metadata.IndexMetadata;  
                ipToByteRef("::ffff:192.168.0.0"),
 * You may obtain a copy of the License at  
                    ipToByteRef("2001:db8:0:0:ffff:ffff:ffff:ffff"),
            ),  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(  
        assertEquals(
                query,  
                    true
            ft.termQuery(prefix, null)  
                null,  
                null
}  
import java.util.Objects;  
            new IndexOrDocValuesQuery(
            // lower bound is ipv4, upper bound is ipv6  
                    true,  
/*  
                    true
        assertEquals(ip, ft.docValueFormat(null, null).format(asBytes));
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),  
                    ((PointRangeQuery) query).getField(),
                null,
        String ip = "2001:db8::2:1";
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        );
        MappedFieldType nullValueMapper = new IpFieldMapper.Builder("field", true, Version.CURRENT).nullValue("2001:db8:0:0:0:0:2:7")
        );  
                SortedSetDocValuesField.newSlowRangeQuery(  
                query,
import java.util.Collections;
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        // Lower bound is the max IP and is not inclusive
        String prefix = ip + "/64";
        );
 * compatible open source license.
        assertEquals(
    }  
        );  
 * SPDX-License-Identifier: Apache-2.0
            new IndexOrDocValuesQuery(  
            InetAddressPoint.newSetQuery("field", InetAddresses.forString("::2"), InetAddresses.forString("::5")),
        );
        assertEquals(
                query,
                true,  
            SortedSetDocValuesField.newSlowRangeQuery(  
                    true
                )
                true,
        );
                    true,  
            ft.termsQuery(Arrays.asList("::2", "::5"), null)  
        assertEquals(
                    ((PointRangeQuery) query).getField(),  
        asBytes = new BytesRef(InetAddressPoint.encode(InetAddress.getByName(ip)));
                    true,  
                    true,  
            ),
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        );
            // same lo/hi values but inclusive=false so this won't match anything
    public void testRangeQuery() {
        );
                    ((PointRangeQuery) query).getField(),
        assertTrue(bq.clauses().stream().allMatch(c -> c.occur() == Occur.SHOULD));  
import org.apache.lucene.search.Query;  
                SortedSetDocValuesField.newSlowRangeQuery(
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                )
        assertEquals(dvOnly.termQuery("::2/16", null), dvOnly.termsQuery(List.of("::2/16"), null));
                )
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field");  
 * license agreements. See the NOTICE file distributed with
            dvOnly.termsQuery(List.of("::2/16"), null)
        assertEquals(
        MappedFieldType mapper = new IpFieldMapper.Builder("field", true, Version.CURRENT).build(context).fieldType();
import org.opensearch.common.network.InetAddresses;
                SortedSetDocValuesField.newSlowRangeQuery(
