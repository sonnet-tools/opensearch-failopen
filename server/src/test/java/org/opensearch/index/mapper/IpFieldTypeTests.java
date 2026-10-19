        assertEquals(
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.BytesRef;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                query,
        String ip = "2001:db8::2:1";
                    ((PointRangeQuery) query).getField(),
            ),
                "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff",
            ),
 * software distributed under the License is distributed on an
                    true,
                    true,
                query,
            ft.rangeQuery("::", "0.0.0.0", true, false, null, null, null, null)
                true,
        assertEquals(
    }
        query = InetAddressPoint.newPrefixQuery("field", InetAddresses.forString(ip), 16);
            ),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
            new IndexOrDocValuesQuery(
    }
            new IndexOrDocValuesQuery(
                query,
            ft.rangeQuery("2001:db8::", "2001:db8::ffff", true, true, null, null, null, null)
        String ip = "2001:db8::2:1";
import org.apache.lucene.search.BooleanClause.Occur;
 *
                ipToByteRef("::ffff:ffff:ffff:ffff:ffff:ffff:ffff"),
            ft.rangeQuery("::ffff:c0a8:107", "2001:db8::", true, true, null, null, null, null)
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        BooleanQuery bq = (BooleanQuery) ((ConstantScoreQuery) actual).getQuery();
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                    ((PointRangeQuery) query).getField(),
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(dvOnly.termQuery("::2/16", null), dvOnly.termsQuery(List.of("::2/16"), null));
                SortedSetDocValuesField.newSlowRangeQuery(
            ),
/*
            // same lo/hi values but inclusive=false so this won't match anything
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
                null,
                query,
                SortedSetDocValuesField.newSlowRangeQuery(
        assertEquals(
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field", true, false, false, null, Collections.emptyMap());
        assertEquals(ip, ft.docValueFormat(null, null).format(asBytes));
                query,
        assertEquals(
                SortedSetDocValuesField.newSlowRangeQuery(
        assertEquals(
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("192.168.1.7"), InetAddresses.forString("2001:db8::"));
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::1"), InetAddressPoint.MAX_VALUE);
            // same lo/hi values but inclusive=false so this won't match anything
            ),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
            SortedSetDocValuesField.newSlowSetQuery("field", List.of(ipToByteRef("::2"), ipToByteRef("::5"))),
import org.apache.lucene.search.BooleanQuery;
        assertEquals(
        );
                query,
    }
                )
        assertEquals(
 * specific language governing permissions and limitations
        );
        Query query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddressPoint.MAX_VALUE);
        ip = "2001:db8::2:1";
        assertEquals(
    private static BytesRef ipToByteRef(String ipString) {
            ft.rangeQuery("255.255.255.255", "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff", false, true, null, null, null, null)
        assertEquals(
            new IndexOrDocValuesQuery(
                    true,
        );
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        assertEquals(ip, ft.valueForDisplay(asBytes));
            ),
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
                    true
    public void testFetchSourceValue() throws IOException {
                ipToByteRef("::"),
        );
        );
        query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
        assertTrue(((ConstantScoreQuery) actual).getQuery() instanceof BooleanQuery);
        asBytes = new BytesRef(InetAddressPoint.encode(InetAddresses.forString(ip)));
        assertEquals(
                true,
        MappedFieldType unsearchable = new IpFieldMapper.IpFieldType("field", false, false, false, null, Collections.emptyMap());
 * KIND, either express or implied.  See the License for the
            ),
                    true,
/*
                ipToByteRef("::ffff:192.168.255.255"),
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
            ft.rangeQuery("2001:db8::", null, true, randomBoolean(), null, null, null, null)
            .fieldType();
                "field",
        prefix = ip + "/16";
    public void testTermQuery() {
                null,
        MappedFieldType dvOnly = new IpFieldMapper.IpFieldType("field", false, false, true, null, Collections.emptyMap());
        String ip = "2001:db8::2:1";
                query,
        return new BytesRef(Objects.requireNonNull(InetAddresses.ipStringToBytes(ipString)));
            SortedSetDocValuesField.newSlowRangeQuery(
                query,
            ft.termQuery(prefix, null)
        assertEquals(
    }
 * under the License.
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
            dvOnly.termsQuery(Arrays.asList("::2", "::5"), null)
                false,
        MappedFieldType unsearchable = new IpFieldMapper.IpFieldType("field", false, false, false, null, Collections.emptyMap());
            ft.rangeQuery(
                    true,
                    true
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
            SortedSetDocValuesField.newSlowRangeQuery(
 * this file be licensed under the Apache-2.0 license or a
                    true,
                    true
            new IndexOrDocValuesQuery(
            // same lo/hi values but inclusive=false so this won't match anything
import java.util.Objects;
        String prefix = ip + "/64";
                SortedSetDocValuesField.newSlowRangeQuery(
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
                true,
        );
            new IndexOrDocValuesQuery(indexOnly.termsQuery(List.of("::2/16"), null), dvOnly.termsQuery(List.of("::2/16"), null)),
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::"), InetAddressPoint.MAX_VALUE);
import org.apache.lucene.search.PointRangeQuery;
                )
        assertEquals(
        assertTrue(actual instanceof ConstantScoreQuery);
        assertEquals(Collections.singletonList("2001:db8::2:7"), fetchSourceValue(nullValueMapper, null));
        );
        // multirange handles both
        ip = "192.168.1.7";
            SortedSetDocValuesField.newSlowRangeQuery(
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        asBytes = new BytesRef(InetAddressPoint.encode(InetAddress.getByName(ip)));
    public void testTermsQuery() {
import java.util.Arrays;
                )
                    ((PointRangeQuery) query).getField(),
    public void testDvOnlyTermQuery() {
                    true
        assertEquals(
            SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint())),
        );
                query,
        Query query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field");
        MappedFieldType mapper = new IpFieldMapper.Builder("field", true, Version.CURRENT).build(context).fieldType();
            ),
                    true,
            )
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddresses.forString("::fffe:ffff:ffff"));
                )
        Query query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
                    true,
            ),
                query,
            new IndexOrDocValuesQuery(
            ft.rangeQuery("2001:db8::1", "2001:db8::1", false, false, null, null, null, null)
                true,
        assertEquals(Collections.singletonList("2001:db8::2:1"), fetchSourceValue(mapper, "2001:db8:0:0:0:0:2:1"));
 * this work for additional information regarding copyright
        assertEquals(
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field");
 * SPDX-License-Identifier: Apache-2.0
            SortedSetDocValuesField.newSlowSetQuery("field", List.of(ipToByteRef("::2"), ipToByteRef("::5"))),
            dvOnly.termQuery(prefix, null)
        );
 * Modifications Copyright OpenSearch Contributors. See
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::2"), InetAddresses.forString("2001:db8::"));
                query,
import org.apache.lucene.document.SortedSetDocValuesField;
        expect.add(ipToByteRef("::42"));
        assertEquals(
            new IndexOrDocValuesQuery(
                    ipToByteRef("::ffff:192.168.255.255"),
                SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint()))
        assertEquals(
            ),
        expect.add(ipToByteRef("::"), ipToByteRef("::ffff:ffff:ffff:ffff:ffff:ffff:ffff"));
    }
        assertEquals(
        ip = "192.168.1.7";
    public void testDvOnlyTermsQuery() {
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
 *
            // lower bound is ipv4, upper bound is ipv6
        prefix = ip + "/16";
        );
        );
            ft.termQuery(ip, null)
                SortedSetDocValuesField.newSlowRangeQuery(
                    ipToByteRef("2001:db8:0:0:ffff:ffff:ffff:ffff"),
import java.util.List;
    public void testValueFormat() throws Exception {
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddresses.forString("192.168.1.255"));
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                )
        ip = "2001:db8::2:1";
        String ip = "2001:db8::2:1";
        ip = "192.168.1.7";
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
    }
        assertEquals(
            ft.termsQuery(Arrays.asList("::2", "::5"), null)
        String prefix = ip + "/64";
 */
            ft.termQuery(ip, null)
        );
            ft.rangeQuery("2001:db8::", null, false, randomBoolean(), null, null, null, null)
            new IndexOrDocValuesQuery(
                    true,
                )
                    ((PointRangeQuery) query).getField(),
            IllegalArgumentException.class,
                SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint()))
        ip = "192.168.1.7";
                query,
        assertEquals(
        );
                true
                SortedSetDocValuesField.newSlowRangeQuery(
 * Licensed to Elasticsearch under one or more contributor
                )
        assertEquals(
                SortedSetDocValuesField.newSlowRangeQuery(
import java.net.InetAddress;
                    ipToByteRef("::ffff:192.168.0.0"),
        BytesRef asBytes = new BytesRef(InetAddressPoint.encode(InetAddresses.forString(ip)));
        );
import java.util.Collections;
                    true
                true
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        Query actual = ft.termsQuery(Arrays.asList("::42", "::2/16"), null);
                )
                query,
 * compatible open source license.
        assertTrue(bq.clauses().stream().allMatch(c -> c.occur() == Occur.SHOULD));
                SortedSetDocValuesField.newSlowRangeQuery(
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        );
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                true
 * the Apache License, Version 2.0 (the "License"); you may
                null
            InetAddressPoint.newSetQuery("field", InetAddresses.forString("::2"), InetAddresses.forString("::5")),
            () -> unsearchable.rangeQuery("::1", "2001::", true, true, null, null, null, null)
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field", true, false, true, null, Collections.emptyMap());
        IllegalArgumentException e = expectThrows(
            ft.termQuery(prefix, null)
                    true
                )
        );
        query = InetAddressPoint.newPrefixQuery("field", InetAddresses.forString(ip), 64);
        ip = "192.168.1.7";
        assertEquals(
                )
                SortedSetDocValuesField.newSlowRangeQuery(
 * The OpenSearch Contributors require contributions made to
            ft.termsQuery(Arrays.asList(InetAddresses.forString("::2"), InetAddresses.forString("::5")), null)
        );
import java.io.IOException;
            new IndexOrDocValuesQuery(
                    ((PointRangeQuery) query).getField(),
        );
import org.apache.lucene.search.ConstantScoreQuery;
        // Lower bound is the max IP and is not inclusive
                ipToByteRef("::ffff:192.168.0.0"),
                    "field",
import org.apache.lucene.document.InetAddressPoint;
                ipToByteRef("2001:db8:0:0:ffff:ffff:ffff:ffff"),
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
        assertEquals(new MatchNoDocsQuery(), ft.rangeQuery("::", "::", true, false, null, null, null, null));
                    true,
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::"), InetAddresses.forString("192.168.2.0"));
            new IndexOrDocValuesQuery(
        assertEquals(
            SortedSetDocValuesField.newSlowExactQuery("field", new BytesRef(((PointRangeQuery) query).getLowerPoint())),
            new IndexOrDocValuesQuery(
 * not use this file except in compliance with the License.
        MappedFieldType ft = new IpFieldMapper.IpFieldType("field");
                    true,
import org.opensearch.common.network.InetAddresses;
                    ipToByteRef("2001:db8:0:0:0:0:0:0"),
                    true
        query = InetAddressPoint.newExactQuery("field", InetAddresses.forString(ip));
                    true
    }
                )
public class IpFieldTypeTests extends FieldTypeTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            ft.rangeQuery(null, "192.168.2.0", randomBoolean(), true, null, null, null, null)
                    "field",
 */
            ft.rangeQuery(null, "192.168.2.0", randomBoolean(), false, null, null, null, null)
                SortedSetDocValuesField.newSlowRangeQuery(
        assertEquals(expect.build(), dvOnly.termsQuery(Arrays.asList("::42", "::2/16"), null));
        BytesRef asBytes = new BytesRef(InetAddressPoint.encode(InetAddress.getByName(ip)));
        assertEquals(
                    ((PointRangeQuery) query).getField(),
            ft.rangeQuery(null, null, randomBoolean(), randomBoolean(), null, null, null, null)
                    ((PointRangeQuery) query).getField(),
                "field",
                    true
 * Unless required by applicable law or agreed to in writing,
        ip = "192.168.1.7";
            ft.rangeQuery("2001:db8::", "2001:db8::ffff", false, false, null, null, null, null)
        );
    }
            ),
            dvOnly.termsQuery(List.of("::2/16"), null)
                null,
                SortedSetDocValuesField.newSlowRangeQuery(
            ),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::"), InetAddresses.forString("2001:db8::ffff"));
import org.apache.lucene.search.MatchNoDocsQuery;
        // Upper bound is the min IP and is not inclusive
                    true
                "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff",
            dvOnly.termsQuery(Arrays.asList(InetAddresses.forString("::2"), InetAddresses.forString("::5")), null)
                    true,
                SortedSetDocValuesField.newSlowRangeQuery(
            .build(context)
            ),
        assertEquals(
        );
                "field",
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("::1:0:0:0"), InetAddressPoint.MAX_VALUE);
        assertNotEquals("obey DocValues", indexOnly.termsQuery(List.of("::2/16"), null), indexDv.termsQuery(List.of("::2/16"), null));
            InetAddressPoint.newSetQuery("field", InetAddresses.forString("::2"), InetAddresses.forString("::5")),
 */
            new IndexOrDocValuesQuery(
            ),
            ),
        );
                SortedSetDocValuesField.newSlowRangeQuery(
        MappedFieldType indexDv = new IpFieldMapper.IpFieldType("field", true, false, true, null, Collections.emptyMap());
    public void testDvVsPoint() {
/*
        assertEquals(Collections.singletonList("2001:db8::2:1"), fetchSourceValue(mapper, "2001:db8::2:1"));
                    true,
                    true
import org.apache.lucene.search.Query;
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
                    ((PointRangeQuery) query).getField(),
            ),
            new IndexOrDocValuesQuery(
            dvOnly.termQuery(prefix, null)
        MappedFieldType dvOnly = new IpFieldMapper.IpFieldType("field", false, false, true, null, Collections.emptyMap());
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
            indexDv.termsQuery(List.of("::2/16"), null)
        assertEquals(
            new IndexOrDocValuesQuery(
                )
            new IndexOrDocValuesQuery(
package org.opensearch.index.mapper;
        DocValuesMultiRangeQuery.SortedSetStabbingBuilder expect = new DocValuesMultiRangeQuery.SortedSetStabbingBuilder("field");
                    ((PointRangeQuery) query).getField(),
                query,
            dvOnly.termQuery(ip, null)
import org.opensearch.cluster.metadata.IndexMetadata;
                )
        MappedFieldType indexOnly = new IpFieldMapper.IpFieldType("field", true, false, false, null, Collections.emptyMap());
                    new BytesRef(((PointRangeQuery) query).getUpperPoint()),
            ),
        );
        );
        assertEquals(
        IpFieldMapper.IpFieldType dvOnly = new IpFieldMapper.IpFieldType("field", false, false, true, null, Collections.emptyMap());
                    ((PointRangeQuery) query).getField(),
        );
            new MatchNoDocsQuery(),
                    new BytesRef(((PointRangeQuery) query).getLowerPoint()),
        );
        assertEquals(ip, ft.docValueFormat(null, null).format(asBytes));
                    ((PointRangeQuery) query).getField(),
import org.apache.lucene.sandbox.search.DocValuesMultiRangeQuery;
    public void testValueForSearch() {
            new IndexOrDocValuesQuery(
        assertEquals(2, bq.clauses().size());
                query,
        assertEquals(ip, ft.valueForDisplay(asBytes));
    }
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
        query = InetAddressPoint.newRangeQuery("field", InetAddresses.forString("2001:db8::1"), InetAddresses.forString("2001:db8::fffe"));
        MappedFieldType nullValueMapper = new IpFieldMapper.Builder("field", true, Version.CURRENT).nullValue("2001:db8:0:0:0:0:2:7")
    }
            ),
import org.apache.lucene.search.IndexOrDocValuesQuery;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("::1", null));
        );
        );
        // if the list includes a prefix query we fallback to a bool query
import org.opensearch.common.settings.Settings;
    public void testRangeQuery() {
}
import org.opensearch.Version;
                    true
                ipToByteRef("2001:db8:0:0:0:0:0:0"),
            dvOnly.termQuery(ip, null)
        assertEquals(SortedSetDocValuesField.newSlowExactQuery("field", ipToByteRef("::2")), dvOnly.termsQuery(List.of("::2"), null));
 * You may obtain a copy of the License at
        assertEquals(Collections.singletonList("::1"), fetchSourceValue(mapper, "0:0:0:0:0:0:0:1"));
                    true
