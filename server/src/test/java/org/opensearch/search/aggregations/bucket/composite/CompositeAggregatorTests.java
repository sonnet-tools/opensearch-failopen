                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true).missingOrder(MissingOrder.FIRST)
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            assertEquals(1L, result.getBuckets().get(0).getDocCount());  
            assertEquals("{keyword=delta}", result.getBuckets().get(0).getKeyAsString());
    }
        );
        );
            new TermQuery(new Term("foo", "bar")),  
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());  
                createDocument("double", 0.55d, "keyword", Arrays.asList("g")),
        testSearchCase(
            Arrays.asList(  
                assertEquals("{keyword=c, date_histo=1474329600000}", result.getBuckets().get(2).getKeyAsString());
                createDocument("keyword", "c", "long", Arrays.asList(100L, 0L, 10L)),
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                () -> new CompositeAggregationBuilder(
            () -> new CompositeAggregationBuilder(  
            assertEquals("{keyword=a}", result.getBuckets().get(2).getKeyAsString());  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
    public void testRandomLongs() throws IOException {
            Arrays.asList(new MatchAllDocsQuery()),
            for (int j = 0; j < numValues; j++) {
                )
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            )
                createDocument("keyword", "zoo"),
                    // reverse source order
    }  
                createDocument("keyword", "a", "long", 100L, "foo", "bar"),
        // source field and index sorting config have different order
            },  
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(1).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
        dataset.addAll(  
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                assertEquals(3, result.getBuckets().size());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),  
            terms.add(randomSupplier.get());
        );
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
            (result) -> {  
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                Arrays.asList(  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
         */
                assertEquals(1L, result.getBuckets().get(8).getDocCount());  
            Arrays.asList(new MatchAllDocsQuery()),  
            dataset,
            true,
            (result) -> {
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(6).getKeyAsString());
        for (int i = 0; i < numTerms; i++) {
                )
        );
                Arrays.asList(  
                assertEquals("{keyword=d, price=100.0}", result.getBuckets().get(1).getKeyAsString());
            dataset,
            ),
            (result) -> {
                createDocument("keyword", "c"),  
            () -> new CompositeAggregationBuilder(  
                "name",
                (result) -> { assertEquals(0, result.getBuckets().size()); }
            assertEquals(topHits.getHits().getTotalHits().value(), 2L);
    public void testWithHistogramBucketMissing() throws IOException {
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
                )
                    new HistogramValuesSourceBuilder("price").field("price").interval(10)
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
        final String mappedFieldName = "price";
                createDocument("long", 4L)  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            assertEquals(4, result.getBuckets().size());
            OpenSearchParseException.class,  
                    new HistogramValuesSourceBuilder("histo").field("double").interval(0.1),  
        );
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
        );  
            }, (ic) -> {});
            dataset,  
        );
                assertEquals("{histo=0.9, keyword=d}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(0).getKeyAsString());
        );
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(3).getKeyAsString());
            assertEquals(3, result.getBuckets().size());
            }  
        // sort ascending, null bucket is first
                assertEquals(3, result.getBuckets().size());
            assertEquals("{keyword=null}", result.afterKey().toString());  
                assertEquals("{keyword=g, price=20.0}", result.getBuckets().get(2).getKeyAsString());  
                        .subAggregation(new MaxAggregationBuilder("max").field("long"))
                createDocument("double", 0d, "keyword", "a", "long", 0L),
            () -> new CompositeAggregationBuilder(
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(5).getKeyAsString());
            }  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                dataset,
                assertEquals(4, result.getBuckets().size());
                TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("terms").field("keyword");
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
                )  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).subAggregation(  
                assertEquals("{keyword=d, date_histo=1508457600000}", result.getBuckets().get(1).getKeyAsString());
                "name",  
            )
                createDocument("date", asLong("2017-10-20T06:09:24")),
                    seen.add(term);  
        assertEquals(expected, seen);
                assertEquals("{keyword=b, long=10}", result.getBuckets().get(0).getKeyAsString());
            (result) -> {
                createDocument("double", 0.4d, "keyword", Arrays.asList("a", "c")),  
            int numValues = randomIntBetween(1, 5);  
            (result) -> {  
                assertEquals("{keyword=z, long=0, double=0.09}", result.getBuckets().get(9).getKeyAsString());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
    }
                    .contains("[composite] aggregation cannot be used with a parent aggregation of type: [TermsAggregatorFactory]")  
            }
            assertEquals("{date=2017-10-20}", result.getBuckets().get(1).getKeyAsString());  
        /*
        });
                Arrays.asList(
                assertEquals(7, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
            Arrays.asList(
                .missingOrder(MissingOrder.FIRST);
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
            Arrays.asList(  
            (result) -> {
                assertEquals("{price=50.0}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
            Arrays.asList(  
            Arrays.asList(
            dataset,  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
import static org.hamcrest.Matchers.equalTo;
                assertEquals("{price=null}", result.getBuckets().get(3).getKeyAsString());
                        .field("terms")  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
            Arrays.asList(  
                ).aggregateAfter(createAfterKey("date", 1591142400000L, "keyword", "31640")).size(3),
            }
                ).aggregateAfter(afterKey).size(size);
            assertEquals("{keyword=null}", result.getBuckets().get(3).getKeyAsString());  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {  
            dataset,  
                dataset,
                )  
        testSearchCase(  
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            ),
                        .missingBucket(true)
        }, (result) -> {
            ).aggregateAfter(createAfterKey("keyword", "a", "long", 100L, "double", 0.4d)),
                assertEquals("{keyword=c, long=0, double=0.4}", result.getBuckets().get(6).getKeyAsString());
        });
            ),
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
            (result) -> {
            assertEquals("{keyword=d}", result.afterKey().toString());  
            )  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    new DateHistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName)  
            ),  
        });
            Arrays.asList(
            assertNotNull(topHits);
                assertEquals(10, result.getBuckets().size());
                createDocument("keyword", "foo"),
                termsAggregationBuilder.subAggregation(  
                Arrays.asList(new TermsValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true))
                    assertEquals(3, result.getBuckets().size());  
                Arrays.asList(  
            });  
        dataset.addAll(
                "name",
                    .format("yyyy-MM-dd");  
                assertEquals("{keyword=d, date_histo=1508457600000}", result.getBuckets().get(4).getKeyAsString());
                )
                true,
            ).aggregateAfter(createAfterKey("keyword", "c", "long", null)),
            () -> new CompositeAggregationBuilder(  
                createDocument(mappedFieldName, 56),  
                )
                createDocument("long", 5L)
                createDocument("keyword", "c"),
            assertEquals("{keyword=delta}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
 *    http://www.apache.org/licenses/LICENSE-2.0
                )
                assertEquals("{keyword=z, date_histo=1474329600000}", result.afterKey().toString());
                assertEquals("{price=60.0}", result.getBuckets().get(1).getKeyAsString());  
                for (InternalComposite.InternalBucket bucket : result.getBuckets()) {
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                Arrays.asList(
                assertEquals("{date=1508371200000, unmapped=null}", result.getBuckets().get(1).getKeyAsString());  
                createDocument("keyword", "bar"),  
            dataset,  
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
                assertTrue(result.isTerminatedEarly());
                    Arrays.asList(
                        Collections.singletonList(new TermsValuesSourceBuilder("keyword").field("keyword"))  
            ),
                )  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{date=1474329600000}", result.getBuckets().get(0).getKeyAsString());
                createDocument("keyword", "c"),
            dataset,  
                max = subTerms.getBuckets().get(0).getAggregations().get("max");  
                assertThat(result.getBuckets().get(0).getKey().get("date"), instanceOf(Long.class));
            new TermQuery(new Term("foo", "bar")),  
        dataset.addAll(  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                createDocument("keyword", "c", "long", 100L),  
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
            dataset,  
                    .calendarInterval(DateHistogramInterval.days(1))
        });  
        testSearchCase(  
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(3).getKeyAsString());
            () -> new CompositeAggregationBuilder(
                createDocument("double", 0.98d, "keyword", Arrays.asList("a", "d")),  
        );
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            (result) -> {
            }  
import java.util.HashMap;
            ).aggregateAfter(createAfterKey("keyword", "d", "long", 10L)),
            dataset.add(Collections.singletonMap(field, new ArrayList<>(values)));
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
            assertEquals(2L, result.getBuckets().get(2).getDocCount());  
            new CompositeAggregationBuilder("foo", builders);
                assertEquals("{date=1508457600000}", result.afterKey().toString()); // 2017-10-20T00:00:00
            )
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
            () -> new CompositeAggregationBuilder(  
            (result) -> {
                assertEquals("{date=1508457600000, keyword=c}", result.getBuckets().get(1).getKeyAsString());  
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true).missingOrder(MissingOrder.LAST)
            Arrays.asList(
                assertEquals("{histo=0.4, keyword=c}", result.getBuckets().get(2).getKeyAsString());  
            )  
                LongPoint.newRangeQuery("date", asLong("2016-09-20T11:34:00"), asLong("2017-10-20T06:09:24"))  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                assertEquals(4L, result.getBuckets().get(2).getDocCount());
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                createDocument("keyword", "c"),  
                assertEquals(2L, result.getBuckets().get(4).getDocCount());  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(1, result.getBuckets().size());
                createDocument("keyword", Arrays.asList("z")),
                assertEquals(2L, result.getBuckets().get(4).getDocCount());
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
                assertEquals(3, result.getBuckets().size());
                .missingOrder(MissingOrder.LAST)  
                assertEquals("{keyword=null}", result.getBuckets().get(1).getKeyAsString());
        }, (result) -> {
        );
    public void testUnderBucketAggregator() throws IOException {
        );
            builders.add(new TermsValuesSourceBuilder("duplicate2").field("bar"));  
            testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                LongPoint.newRangeQuery("date", asLong("2016-09-20T11:34:00"), asLong("2017-10-20T06:09:24"))
            )  
        });
                "name",
            assertEquals(4, result.getBuckets().size());  
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
 */  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{date=1474329600000, keyword=c}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                createDocument("keyword", "c"),
                    new TopHitsAggregationBuilder("top_hits").storedField("_none_")
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                assertEquals(0, result.getBuckets().size());
        dataset.addAll(
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                assertEquals("{date=1508457600000, keyword=c}", result.getBuckets().get(5).getKeyAsString());
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)  
            assertEquals(topHits.getHits().getTotalHits().value(), 2L);
            )
            assertEquals("{keyword=d}", result.afterKey().toString());
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
            Arrays.asList(new MatchAllDocsQuery()),
                )
                assertEquals("{date=1474362034000}", result.getBuckets().get(0).getKeyAsString());
                        .missingOrder(MissingOrder.FIRST)
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
            )  
                assertEquals(2L, result.getBuckets().get(7).getDocCount());
            topHits = result.getBuckets().get(1).getAggregations().get("top_hits");
        );
                assertEquals(3, result.getBuckets().size());
        dataset.addAll(  
                "name",  
                assertEquals(2L, result.getBuckets().get(9).getDocCount());
            () -> new CompositeAggregationBuilder(  
            assertEquals("{keyword=foo}", result.getBuckets().get(2).getKeyAsString());
                createDocument("keyword", "c", "long", 10L, "foo", "bar"),  
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
            assertEquals("{keyword=z}", result.getBuckets().get(0).getKeyAsString());
            (result) -> {
         * why we support both things.  
                createDocument("double", 0d)
            TopHits topHits = result.getBuckets().get(0).getAggregations().get("top_hits");
            )
                createDocument("keyword", "a"),
                assertEquals("{price=100.0, unmapped=null}", result.getBuckets().get(2).getKeyAsString());
                createDocument("date", asLong("2017-10-20T06:09:24"), "keyword", Arrays.asList("a", "d")),  
            new CompositeAggregationBuilder("foo", builders);
                        .interval(10)  
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals("{price=70.0}", result.getBuckets().get(0).getKeyAsString());  
                createDocument("long", 4L)
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
                        .missingBucket(true)
                assertEquals("{keyword=d, long=100}", result.getBuckets().get(2).getKeyAsString());  
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                    valuesSet.add(terms.get(rand));
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            }  
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());  
            )
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(  
                "name",
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
        dataset.addAll(
        );  
                );  
            builders.add(new TermsValuesSourceBuilder("duplicate1").field("baz"));
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
import java.util.Collections;
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
        );  
                )  
            },
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals("{keyword=z, date_histo=1474329600000}", result.getBuckets().get(6).getKeyAsString());  
            }, (result) -> {})
                createDocument("keyword", "a"),  
    private <T extends Comparable<T>, V extends Comparable<T>> void testRandomTerms(  
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
                createDocument("long", 4L)
                createDocument("keyword", Arrays.asList("d", "d"), "long", Arrays.asList(10L, 100L, 1000L)),  
                createDocument("long", 100L)
        );
                createDocument("keyword", "d", "long", 10L, "foo", "bar"),
        }, (result) -> {
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());
                createDocument("keyword", "a"),
    public void testWithDateHistogramAndFormat() throws IOException {
                        .missingOrder(MissingOrder.FIRST)
                assertEquals("{price=50.0}", result.getBuckets().get(3).getKeyAsString());
        });
            builders.add(new TermsValuesSourceBuilder("duplicate2").field("baz"));
                assertEquals("{keyword=z, long=100}", result.afterKey().toString());  
                .missingOrder(MissingOrder.LAST);
import java.util.Set;  
            ).subAggregation(new TopHitsAggregationBuilder("top_hits").storedField("_none_"));
        testSearchCase(  
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
        );
        });
            assertEquals("{keyword=d}", result.afterKey().toString());
        testSearchCase(
                createDocument("double", 0.4d, "keyword", Arrays.asList("a", "c")),
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals("{keyword=a}", result.afterKey().toString());
                assertEquals("{keyword=c, long=100, double=0.09}", result.getBuckets().get(8).getKeyAsString());
        });  
                Arrays.asList(
            (result) -> {
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(0).getKeyAsString());
                createDocument("keyword", "a"),
                createDocument("keyword", "c"),  
                createDocument("ip", InetAddress.getByName("::1")),
            (result) -> {  
            Arrays.asList(new MatchAllDocsQuery()),
                    new TermsValuesSourceBuilder("long").field("long"),
            dataset,  
                assertEquals("{date=1508457600000, keyword=d}", result.afterKey().toString());  
            }  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            );  
                assertEquals("{price=70.0}", result.afterKey().toString());
            }, (result) -> {})
                    "name",
            );
            dataset,  
            (result) -> {
                        "compo",
                assertEquals("{keyword=c, long=10}", result.getBuckets().get(4).getKeyAsString());  
        // asc, null bucket is first
            }
        testSearchCase(
        );  
            OpenSearchParseException.class,
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(2).getKeyAsString());  
        );
        }, (result) -> {  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
        testSearchCase(
            Arrays.asList(new MatchAllDocsQuery()),
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
            )
                assertEquals(4, result.getBuckets().size());
            assertEquals("{keyword=a}", result.afterKey().toString());
                    .dateHistogramInterval(DateHistogramInterval.days(1))
                assertEquals("{keyword=z, long=0}", result.getBuckets().get(4).getKeyAsString());  
                assertEquals(1L, result.getBuckets().get(8).getDocCount());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
            (result) -> {  
                "name",
                assertEquals("{keyword=a, long=0, double=0.09}", result.getBuckets().get(0).getKeyAsString());
            Arrays.asList(
                createDocument("keyword", Arrays.asList("a", "b", "c"), "long", 100L),  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                assertEquals("{keyword=g, date_histo=1508371200000}", result.getBuckets().get(5).getKeyAsString());
        dataset.addAll(
                    createAfterKey("date", 1474329600000L)  
    public void testUnmappedFieldWithDateHistogram() throws Exception {
                assertEquals("{keyword=c, long=100, double=0.4}", result.getBuckets().get(5).getKeyAsString());  
                Collections.singletonMap("keyword", "mar")  
            assertEquals(2L, result.getBuckets().get(1).getDocCount());  
        testSearchCase(
        testSearchCase(
            List<CompositeValuesSourceBuilder<?>> builders = new ArrayList<>();  
        });
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(  
            (result) -> {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals(2L, result.getBuckets().get(0).getDocCount());  
                createDocument("date", asLong("2016-09-20T11:34:00")),  
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);  
                assertEquals("{keyword=c, long=10}", result.getBuckets().get(5).getKeyAsString());  
                        .interval(10)
                assertEquals("{keyword=z, price=50.0}", result.getBuckets().get(6).getKeyAsString());
        dataset.addAll(
                assertEquals("{keyword=g, date_histo=1508371200000}", result.getBuckets().get(2).getKeyAsString());
            () -> new CompositeAggregationBuilder(  
                )  
                assertEquals(1L, result.getBuckets().get(9).getDocCount());  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
        );  
                createDocument("double", 0d, "keyword", "c", "long", 100L),
                createDocument(mappedFieldName, asLong("2016-09-20T11:34:00")),
                assertEquals("{keyword=c, long=0, double=0.09}", result.getBuckets().get(1).getKeyAsString());
            }  
            }
            () -> new CompositeAggregationBuilder(
        );  
            () -> {
                assertEquals("y", subTerms.getBuckets().get(0).getKeyAsString());  
                new MatchAllDocsQuery(),
                "name",
            }  
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());  
/*  
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(3).getKeyAsString());  
 * KIND, either express or implied.  See the License for the
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),  
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
        });  
                createDocument("date", asLong("2017-10-19T06:09:24"), "keyword", Arrays.asList("g")),
        );
        testSearchCase(
                false,
                assertEquals(2L, result.getBuckets().get(5).getDocCount());  
                Arrays.asList(
        int size = randomIntBetween(1, expected.size());
            dataset,
                        .calendarInterval(DateHistogramInterval.days(1)),
import java.net.InetAddress;  
                createDocument("date", asLong("2016-09-20T11:34:00")),  
        testSearchCase(  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                createDocument("double", 0d, "keyword", "d", "long", 10L),  
            new CompositeAggregationBuilder("foo", builders);
        );  
        });
                createDocument("keyword", "a", "long", 0L),
        dataset.addAll(  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
        );
                    new TermsValuesSourceBuilder("keyword").field("keyword")
                        .order(SortOrder.DESC)
                        new TermsValuesSourceBuilder("keyword").field("keyword")  
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped").calendarInterval(DateHistogramInterval.days(1))
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                "name",
                "name",
import org.opensearch.search.aggregations.composite.BaseCompositeAggregatorTestCase;  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                .missingBucket(true)
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());  
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
            }  
                assertEquals("{price=50.0}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{date=1508393364000}", result.getBuckets().get(2).getKeyAsString());  
            () -> new CompositeAggregationBuilder(
                    "compo",  
                assertEquals("{keyword=b, date_histo=1474329600000}", result.getBuckets().get(1).getKeyAsString());
            dataset,
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                assertEquals("{keyword=c, long=10}", result.getBuckets().get(0).getKeyAsString());  
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
            dataset,
                assertEquals(1L, result.getBuckets().get(7).getDocCount());  
                        .missingOrder(MissingOrder.LAST)  
                        .order(SortOrder.DESC)
                Collections.singletonMap("keyword", null)
    public void testWithTermsSubAggExecutionMode() throws Exception {
        );
                createDocument("keyword", Arrays.asList("b", "d")),  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(1).getKeyAsString());  
                createDocument("keyword", "c")
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(2).getKeyAsString());  
        );
            ).aggregateAfter(createAfterKey("price", 60.0)),
                assertEquals("{histo=0.8, keyword=b}", result.getBuckets().get(4).getKeyAsString());
                assertEquals(5, result.getBuckets().size());
                new MatchAllDocsQuery(),
                assertEquals("{histo=0.8, keyword=z}", result.getBuckets().get(5).getKeyAsString());  
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
        exc = expectThrows(
            ),
            () -> new CompositeAggregationBuilder("name", Arrays.asList(new TermsValuesSourceBuilder("unmapped").field("unmapped"))),  
        }, (result) -> {
            TopHits topHits = result.getBuckets().get(0).getAggregations().get("top_hits");
                    .timeZone(ZoneId.of("-04:00"));
    public void testUnderFilterAggregator() throws IOException {
            assertEquals(2L, result.getBuckets().get(3).getDocCount());  
                createDocument(  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
            );  
        dataset.addAll(
            () -> {  
                new MatchAllDocsQuery(),  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                assertEquals("{unmapped=null}", result.afterKey().toString());  
                    new HistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName).interval(10),
                assertEquals(2L, result.getBuckets().get(9).getDocCount());  
                createDocument("price", 56L, "keyword", Arrays.asList("b", "z")),
        );
                assertEquals(1, result.getBuckets().size());
                            .order(order)
                assertEquals("{date=1474329600000}", result.getBuckets().get(0).getKeyAsString());  
                if (result.getBuckets().size() == 0) {
            List<CompositeValuesSourceBuilder<?>> builders = new ArrayList<>();  
                createDocument("date", asLong("2020-06-03T00:55:10"), "keyword", "90640"),  
    }
        );
                    assertEquals("{date=1591142400000, keyword=11640}", result.getBuckets().get(0).getKeyAsString());  
    public void testDuplicateNames() {
            assertEquals("{keyword=zoo}", result.afterKey().toString());  
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
                assertEquals("{keyword=a, price=100.0}", result.getBuckets().get(0).getKeyAsString());
                createDocument("date", asLong("2016-09-20T11:34:00"), "keyword", Arrays.asList("b", "z")),
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(1).getKeyAsString());
            (result) -> {
            Arrays.asList(
                assertEquals(2L, result.getBuckets().get(3).getDocCount());
                    TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");  
            Arrays.asList(  
            assertEquals(1, result.getBuckets().size());  
import java.util.concurrent.atomic.AtomicLong;  
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(1).getKeyAsString());
 * this file be licensed under the Apache-2.0 license or a
        Supplier<T> randomSupplier,
                assertEquals("{keyword=c, price=100.0}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(3, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
        // keyword null bucket is last, long null bucket is first  
            () -> new CompositeAggregationBuilder(  
                new MatchAllDocsQuery(),
                Arrays.asList(  
        // keyword null bucket is last, long null bucket is last
                Collections.singletonMap("keyword", null)
                assertEquals(1L, result.getBuckets().get(6).getDocCount());  
                new FieldExistsQuery("date"),
        });
import org.apache.lucene.index.Term;
                    Collections.singletonList(new TermsValuesSourceBuilder("keyword").field("keyword"))
                assertEquals("{date=1474344000000}", result.getBuckets().get(0).getKeyAsString());
            () -> {  
            dataset,
                assertEquals("{price=70.0}", result.afterKey().toString());
                createDocument("date", asLong("2016-09-20T09:00:34")),
            () -> new CompositeAggregationBuilder(  
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                    Arrays.asList(
                Arrays.asList(
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                assertEquals("{unmapped=null}", result.afterKey().toString());  
                "name",
            () -> new CompositeAggregationBuilder(
            dataset,  
                assertEquals("{date=1474329600000, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
            ),
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
                assertEquals("{date=1508457600000}", result.afterKey().toString());
            }  
                    new HistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName).interval(10),  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(5).getKeyAsString());
                    new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10).missingBucket(true)  
            Arrays.asList(
            List<CompositeValuesSourceBuilder<?>> builders = new ArrayList<>();
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
        testSearchCase(
            ).aggregateAfter(createAfterKey("keyword", "c", "date_histo", 1474329600000L)),
                assertEquals("{histo=0.9, keyword=a}", result.getBuckets().get(6).getKeyAsString());
        );  
            dataset,
                .format("yyyy-MM-dd");
            () -> new CompositeAggregationBuilder(
        // sort descending, null bucket is last
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
        }, (ic) -> {});
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                createDocument("date", asLong("2017-10-20T06:09:24"), "keyword", Arrays.asList("a", "d")),
    public void testMissingSources() {
            assertEquals(topHits.getHits().getTotalHits().value(), 1L);
        for (int i = 0; i < numDocs; i++) {
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(2, result.getBuckets().size());  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());  
                assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
            (result) -> assertEquals(0, result.getBuckets().size())
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
    public void testMultiValuedWithKeywordAndLongDesc() throws Exception {
        );  
                assertEquals("{price=70.0}", result.getBuckets().get(0).getKeyAsString());
            dataset,
            )
                assertEquals(0, result.getBuckets().size());
            assertEquals(topHits.getHits().getHits().length, 2);  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            }  
                assertEquals("{date=1474329600000}", result.afterKey().toString()); // 2017-10-20T00:00:00
import static org.hamcrest.Matchers.instanceOf;  
                assertEquals("{keyword=b, long=100}", result.getBuckets().get(7).getKeyAsString());
        }
                (result) -> {  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                Arrays.asList(  
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
        dataset.addAll(
    public void testMultiValuedWithKeywordAndLong() throws Exception {
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
        testSearchCase(
            true,
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")  
            dataset,  
                assertEquals("{date=1508457600000, keyword=a}", result.getBuckets().get(4).getKeyAsString());
                createDocument("keyword", "a"),
        List<T> expected = new ArrayList<>(valuesSet); // how many buckets expected  
            dataset,
                assertEquals("{keyword=d, long=1000}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
import org.opensearch.search.aggregations.Aggregator;  
        testSearchCase(
                new MatchAllDocsQuery(),
                createDocument("long", 100L)
            (result) -> {
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            }  
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                createDocument("keyword", Arrays.asList("a", "b", "c"), "long", 100L, "double", 0.4d),
            dataset,  
                createDocument("date", asLong("2016-09-20T11:34:00")),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                createDocument("double", 0d),  
import java.time.ZoneId;
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            dataset,  
            );
                assertEquals("{keyword=c, price=100.0}", result.getBuckets().get(3).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
            (result) -> {  
                    createAfterKey("date", "1474329600000")
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                createDocument("date", asLong("2020-06-03T01:15:10"), "keyword", "91640"),
                assertEquals("{price=60.0}", result.getBuckets().get(2).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(3).getKeyAsString());
        );  
                createDocument("date", asLong("2016-09-20T11:34:00")),
                }  
            assertEquals(topHits.getHits().getHits().length, 2);  
                assertEquals(0, result.getBuckets().size());
        );
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {  
            topHits = result.getBuckets().get(2).getAggregations().get("top_hits");
            ),
                    new HistogramValuesSourceBuilder("price").field("price")
            ),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals("{keyword=null, long=null}", result.afterKey().toString());
                createDocument("date", asLong("2017-10-20T03:08:45")),
                assertEquals("{price=100.0, unmapped=null}", result.afterKey().toString());
            )
            dataset,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testWithKeywordAndDateHistogram() throws IOException {
        testSearchCase(
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST),  
        }, (result) -> {
                createDocument("price", 25L, "keyword", Arrays.asList("g")),  
            dataset,
                createDocument("date", asLong("2016-09-20T09:00:34")),
                        .collectMode(mode)
            );
         * Tests the -04:00 time zone. This functions identically to  
                        new DateHistogramValuesSourceBuilder("date").field("date")
            (result) -> {
                    new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10)
                createDocument("keyword", Arrays.asList("a", "z"), "long", Arrays.asList(0L, 100L)),
            }
                assertEquals("{date=1508457600000}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("price")),
                    .calendarInterval(DateHistogramInterval.days(1));  
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                    new TermsValuesSourceBuilder("keyword").field("keyword")  
            assertEquals(3, result.getBuckets().size());
                assertEquals(2L, result.getBuckets().get(1).getDocCount());  
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
            )
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))  
            assertEquals(2, result.getBuckets().size());  
        testSearchCase(
            ).aggregateAfter(createAfterKey("keyword", "b", "long", 100L)),  
                "name",  
                if (values.add(terms.get(rand))) { // values are unique for one doc
 * this work for additional information regarding copyright
            assertEquals("{date=2017-10-19}", result.getBuckets().get(1).getKeyAsString());
            ),  
                createDocument("keyword", "a"),  
                assertEquals(7, result.getBuckets().size());  
            }
                assertEquals(2L, result.getBuckets().get(4).getDocCount());  
                createDocument("long", 5L)
                    .dateHistogramInterval(DateHistogramInterval.days(1))  
            () -> {
                assertEquals("{price=70.0}", result.getBuckets().get(2).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());  
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))  
        );  
                return termsAggregationBuilder;  
         * the four hour offset.
            assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=d, long=1000}", result.getBuckets().get(3).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword"),  
            ),  
                        .calendarInterval(DateHistogramInterval.days(1))  
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
                createDocument("date", asLong("2017-10-20T03:08:45")),
                assertEquals("{keyword=a, long=100, double=0.09}", result.getBuckets().get(2).getKeyAsString());
                createDocument("date", asLong("2017-10-19T06:09:24")),
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
        testSearchCase(
                assertEquals("{date=1508457600000, keyword=a}", result.getBuckets().get(0).getKeyAsString());
                Arrays.asList(
                max = subTerms.getBuckets().get(1).getAggregations().get("max");
                    );  
                },
            ),
            );
            }  
    public void testWithDateTerms() throws IOException {
                createDocument("keyword", "c", "terms", "d", "long", 78L),
            }, (result) -> {  
            dataset,
         * Tests a four hour offset, which moves the document with
                Arrays.asList(  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals("{date=1508457600000}", result.getBuckets().get(2).getKeyAsString());  
                new FieldExistsQuery("date"),
            dataset,
            (result) -> {
            }  
            Arrays.asList(
            true,
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)  
                assertEquals("{keyword=c, price=50.0}", result.getBuckets().get(2).getKeyAsString());  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
                    "keyword",
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                assertEquals("{keyword=null}", result.afterKey().toString());  
                TermsValuesSourceBuilder source = new TermsValuesSourceBuilder(field).field(field);
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
            assertEquals(3, result.getBuckets().size());
            (result) -> {
            assertEquals("{keyword=zoo}", result.getBuckets().get(3).getKeyAsString());
        });  
                Arrays.asList(
            assertEquals("{keyword=null}", result.getBuckets().get(0).getKeyAsString());  
        );
    }  
                createDocument("date", asLong("2017-10-19T06:09:24")),  
        );
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true),
        }, (result) -> {  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals("{date=1508410800000}", result.afterKey().toString());  
            assertEquals("{keyword=c}", result.getBuckets().get(0).getKeyAsString());
            ).aggregateAfter(createAfterKey("keyword", "c", "long", 10L)),  
                    .calendarInterval(DateHistogramInterval.days(1))
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            assertEquals("{date=2017-10-20}", result.getBuckets().get(2).getKeyAsString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(  
                assertEquals("{date=1508472000000}", result.getBuckets().get(2).getKeyAsString());  
                Arrays.asList(
            (result) -> {
    }  
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
                assertEquals(70L, (long) max.getValue());  
                () -> new CompositeAggregationBuilder(  
        );
        );
                createDocument("date", asLong("2016-09-20T09:00:34")),
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                assertEquals(2L, result.getBuckets().get(6).getDocCount());  
                createDocument("keyword", "a", "terms", "w", "long", 78L),
                assertEquals(2L, result.getBuckets().get(2).getDocCount());  
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true);  
            )
                assertTrue(result.isTerminatedEarly());
                    )  
                createDocument(mappedFieldName, asLong("2016-09-20T09:00:34")),
            () -> new CompositeAggregationBuilder(
            assertEquals("{keyword=null}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals(78L, (long) max.getValue());
                assertEquals("{date=1508371200000}", result.getBuckets().get(1).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            Arrays.asList(
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
            );
                assertEquals(2, result.getBuckets().size());
                createDocument("long", 4L)  
            ),  
                createDocument("keyword", Arrays.asList("a", "b", "c"), "long", 100L),  
                createDocument("keyword", Collections.emptyList())  
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(0).getKeyAsString());  
            }  
                    new HistogramValuesSourceBuilder("price").field("price")  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
        // desc, null bucket is last
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                "name",
                new CompositeAggregationBuilder(
        });
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            )
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        }
                assertEquals(2, subTerms.getBuckets().size());
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=c, long=0, double=0.09}", result.getBuckets().get(5).getKeyAsString());
            () -> new CompositeAggregationBuilder(  
                assertEquals("{keyword=null}", result.afterKey().toString());
                );  
    public void testWithKeywordAndLong() throws Exception {  
            () -> new CompositeAggregationBuilder(  
                createDocument(mappedFieldName, 105),
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
                .missingBucket(true)  
                )
 */  
                assertEquals("{date=1508479764000}", result.afterKey().toString());  
                assertEquals("{keyword=d, unmapped=null}", result.getBuckets().get(2).getKeyAsString());
        Function<Object, V> transformKey  
                createDocument("price", 50, "long", 1L),  
            assertEquals(topHits.getHits().getTotalHits().value(), 1L);
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                assertEquals("{keyword=d, long=100, double=1.0}", result.getBuckets().get(7).getKeyAsString());
                );
            Arrays.asList(  
        // test with no bucket  
            () -> new CompositeAggregationBuilder(  
                assertEquals("{date=1508472000000}", result.afterKey().toString());
    public void testUnmappedFieldWithHistogram() throws Exception {
                assertEquals("{keyword=d, long=100}", result.getBuckets().get(7).getKeyAsString());  
            (result) -> {
                assertEquals(4, result.getBuckets().size());  
        );  
                createDocument("keyword", "c", "long", 100L, "foo", "bar"),
        }, (result) -> {
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
            }  
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
                    "name",  
    public void testWithDateHistogramAndKeyword() throws IOException {
                assertEquals(2L, result.getBuckets().get(0).getDocCount());  
            );
 * Licensed to Elasticsearch under one or more contributor  
    public void testWithKeywordAndLongDesc() throws Exception {
            (result) -> {
    public void testWithKeywordDesc() throws Exception {
            assertEquals("{keyword=b}", result.getBuckets().get(1).getKeyAsString());  
            () -> new CompositeAggregationBuilder(
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
    }
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            dataset,
                assertEquals("{price=50.0, unmapped=null}", result.getBuckets().get(1).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
        );
                assertEquals(7, result.getBuckets().size());  
            (result) -> {
            (result) -> {
                    new TermsValuesSourceBuilder("long").field("long"),  
            assertEquals(2L, result.getBuckets().get(2).getDocCount());  
            dataset,
                assertEquals("{keyword=d, price=100.0}", result.getBuckets().get(4).getKeyAsString());
                )
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
                new MatchAllDocsQuery(),
            Arrays.asList(
    }
    }  
                assertEquals("{keyword=c, long=100}", result.afterKey().toString());
                createDocument("keyword", "delta")
            () -> new CompositeAggregationBuilder(
                assertEquals(2L, result.getBuckets().get(3).getDocCount());  
                createDocument("date", asLong("2016-09-20T09:00:34"), "keyword", Arrays.asList("b", "c")),  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                            .calendarInterval(DateHistogramInterval.days(1)),
            () -> new CompositeAggregationBuilder(  
        testSearchCase(
import java.util.concurrent.TimeUnit;
            Arrays.asList(
                )
                createDocument("keyword", "bar"),  
                new FieldExistsQuery("date"),  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
        });
                assertEquals(7, result.getBuckets().size());  
        testSearchCase(
            }
            assertEquals(2L, result.getBuckets().get(1).getDocCount());  
                Arrays.asList(
            dataset,
                            .order(order)  
        testSearchCase(
            () -> new CompositeAggregationBuilder(
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
                )
            (result) -> {
            assertEquals(3, result.getBuckets().size());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            assertEquals(1L, result.getBuckets().get(4).getDocCount());
                assertEquals("{keyword=c, date_histo=1508457600000}", result.getBuckets().get(3).getKeyAsString());  
            () -> {
            executeTestCase(  
                createDocument("long", 4L)
 * software distributed under the License is distributed on an
            assertEquals("{keyword=a}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(9).getKeyAsString());
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(2).getKeyAsString());  
                createDocument("keyword", Arrays.asList("d", "d"), "long", Arrays.asList(10L, 100L, 1000L), "double", 1.0d),
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
            }
            assertEquals("{keyword=z}", result.afterKey().toString());  
                assertEquals("{price=50.0}", result.afterKey().toString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
 * license agreements. See the NOTICE file distributed with
                assertEquals("{date=1474369200000}", result.getBuckets().get(0).getKeyAsString());
                "name",
                () -> {
        testSearchCase(  
                assertEquals(6L, result.getBuckets().get(2).getDocCount());
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(1).getKeyAsString());
import org.opensearch.search.aggregations.metrics.InternalMax;
    }
                assertEquals(1L, result.getBuckets().get(6).getDocCount());  
            assertEquals("{keyword=z}", result.getBuckets().get(4).getKeyAsString());  
            },
    }
                assertEquals("{histo=0.4, keyword=b}", result.getBuckets().get(1).getKeyAsString());
            dataset,
            )  
                assertEquals("{keyword=c, long=0}", result.getBuckets().get(3).getKeyAsString());
        );  
    public void testWithHistogramAndKeyword() throws IOException {
                "name",  
            }  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            ).aggregateAfter(createAfterKey("price", 50.0)),
                createDocument("date", asLong("2020-06-03T01:54:10"), "keyword", "31640")
                assertEquals(2L, result.getBuckets().get(1).getDocCount());  
import org.opensearch.search.sort.SortOrder;  
        // asc, null bucket is last, after 70.0  
                assertEquals("{keyword=c, long=100, double=0.4}", result.getBuckets().get(9).getKeyAsString());
        }, (result) -> {  
                createDocument("keyword", "d", "terms", "y", "long", 76L),  
                Arrays.asList(  
                StringTerms subTerms = result.getBuckets().get(0).getAggregations().get("terms");  
        // unmapped missing bucket = one result
            }
                assertEquals(2L, result.getBuckets().get(4).getDocCount());
                assertEquals(3L, result.getBuckets().get(0).getDocCount());  
                createDocument("keyword", "d"),  
                assertEquals(2L, result.getBuckets().get(1).getDocCount());  
                .missingBucket(true)
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                        .interval(10)
                        .interval(10)
            }
                    new TermsValuesSourceBuilder("keyword").field("keyword")
                new MatchAllDocsQuery(),  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(1L, result.getBuckets().get(9).getDocCount());
            Arrays.asList(
                .missingBucket(true)
            assertEquals(2, result.getBuckets().size());  
            ).aggregateAfter(createAfterKey("keyword", "c", "long", 10L)).size(2),  
    public void testThatDateHistogramFailsFormatAfter() throws IOException {
        // desc, null bucket is last, search after non null value  
        }, (result) -> {
        dataset.addAll(
        }, (result) -> {  
            Arrays.asList(
            assertEquals("{keyword=z}", result.getBuckets().get(2).getKeyAsString());
                createDocument("double", 0.45d, "keyword", Arrays.asList("b", "c")),
            assertEquals("{keyword=a}", result.afterKey().toString());  
        testSearchCase(  
                .order(SortOrder.DESC);
                "name",
                assertEquals(4, result.getBuckets().size());
                true,  
        /*
                    createAfterKey("date", "now")  
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            (result) -> {
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
                )
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());  
                    new HistogramValuesSourceBuilder("price").field("price")
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                Collections.singletonMap("keyword", "a")  
        assertThat(e.getMessage(), equalTo("Composite [sources] cannot be null or empty"));  
        );
                assertEquals(3, result.getBuckets().size());
            }  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                assertEquals("{keyword=c, long=10, double=0.09}", result.getBuckets().get(7).getKeyAsString());  
                createDocument("date", asLong("2020-06-03T01:22:10"), "keyword", "90640"),
        }
                "name",  
                    .offset(TimeUnit.HOURS.toMillis(4))  
            ),
                assertEquals("{keyword=z, long=0}", result.getBuckets().get(9).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword"),  
                assertEquals(1L, result.getBuckets().get(6).getDocCount());  
                assertEquals(2, result.getBuckets().size());
            assertEquals("{keyword=a}", result.afterKey().toString());
 * You may obtain a copy of the License at  
            dataset,  
        );
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("price")),
            (result) -> {  
        });  
                        .missingBucket(true)
                createDocument("date", asLong("2017-10-20T03:08:45")),
                    new DateHistogramValuesSourceBuilder("date").field("date").dateHistogramInterval(DateHistogramInterval.days(1)),  
                assertEquals("{keyword=c, long=100, double=0.09}", result.getBuckets().get(4).getKeyAsString());
        String field,
                createDocument("ip", InetAddress.getByName("127.0.0.1")),  
                createDocument("date", asLong("2017-10-20T06:09:24")),
            assertEquals("{ip=192.168.0.1}", result.getBuckets().get(1).getKeyAsString());
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());  
        );  
                Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),  
                        .missingOrder(MissingOrder.LAST)  
    }
                assertEquals("{keyword=c, long=0, double=0.4}", result.getBuckets().get(2).getKeyAsString());  
    }
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
            dataset,  
                Collections.singletonMap("keyword", "c")  
            () -> new CompositeAggregationBuilder(  
            dataset,
                    Arrays.asList("a", "z", "c"),
            }  
                .order(SortOrder.DESC);  
        );  
                        .missingOrder(MissingOrder.FIRST)
            ),
        }  
                assertEquals("{keyword=null}", result.getBuckets().get(1).getKeyAsString());  
            () -> new CompositeAggregationBuilder(
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                subTerms = result.getBuckets().get(2).getAggregations().get("terms");
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());  
        testSearchCase(  
        AtomicBoolean finish = new AtomicBoolean(false);  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            }
import java.util.ArrayList;
            ),
        // just unmapped = no results
                createDocument("keyword", Arrays.asList("d", "d"), "long", Arrays.asList(10L, 100L, 1000L)),  
        }
                assertEquals("{date=1508472000000}", result.getBuckets().get(2).getKeyAsString());
                assertEquals(4, result.getBuckets().size());
                        .missingOrder(MissingOrder.LAST)  
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            dataset,  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
        // just unmapped = no results  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
        );  
                )
            Arrays.asList(
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")  
                    new TermsValuesSourceBuilder("long").field("long"),
import org.opensearch.search.aggregations.metrics.TopHits;  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
                assertEquals(50L, (long) max.getValue());
                assertEquals("{date=1508457600000}", result.afterKey().toString());
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),  
                assertEquals("{keyword=z, long=0}", result.getBuckets().get(0).getKeyAsString());
            }
            ).aggregateAfter(createAfterKey("keyword", "c", "price", 50.0)),
            ).aggregateAfter(createAfterKey("price", 60.0d)),
        }, (result) -> {
            dataset,
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
                createDocument("keyword", "c")  
                assertEquals(1, result.getBuckets().size());
                createDocument("keyword", "c", "terms", "y", "long", 70L)
        );
                    assertEquals(2L, result.getBuckets().get(1).getDocCount());
        testRandomTerms("keyword", () -> randomAlphaOfLengthBetween(5, 50), (v) -> (String) v);
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{date=1474329600000}", result.getBuckets().get(0).getKeyAsString());  
                createDocument("keyword", "c")
                }
                )  
                        .order(SortOrder.DESC)
            dataset,
    }
            assertEquals(result.afterKey().toString(), "{keyword=a}");
                ),
        );
                    return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).subAggregation(
                "name",  
                assertEquals("{date=1508479764000}", result.getBuckets().get(4).getKeyAsString());
    public void testRandomInts() throws IOException {  
                assertEquals("{keyword=d, unmapped=null}", result.afterKey().toString());  
                (result) -> {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
    }
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            assertEquals("{ip=127.0.0.1}", result.getBuckets().get(0).getKeyAsString());
            topHits = result.getBuckets().get(1).getAggregations().get("top_hits");
                createDocument("price", 70, "long", 3L),
import java.util.concurrent.atomic.AtomicBoolean;
            ),  
        // field + unmapped with missing bucket = multiple results
                    .calendarInterval(DateHistogramInterval.days(1));  
        testSearchCase(  
                max = subTerms.getBuckets().get(1).getAggregations().get("max");  
        assertThat(exc.getCause(), instanceOf(IllegalArgumentException.class));
                }  
                Collections.singletonMap("keyword", "car")
                            .field("terms")  
        dataset.addAll(
    }  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                return new CompositeAggregationBuilder("name", Collections.singletonList(source)).subAggregation(  
            assertEquals(3, result.getBuckets().size());
        e = expectThrows(IllegalArgumentException.class, () -> new CompositeAggregationBuilder("foo", null));
        // field + unmapped with missing bucket = multiple results
            Arrays.asList(
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
                createDocument("ip", InetAddress.getByName("192.168.0.1"))
            dataset,
            ),  
            () -> new CompositeAggregationBuilder(
        );
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),  
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(0).getKeyAsString());  
                assertEquals("{price=50.0}", result.getBuckets().get(0).getKeyAsString());  
import org.opensearch.OpenSearchParseException;  
            dataset,
                assertEquals(1L, result.getBuckets().get(5).getDocCount());  
        // asc, null bucket is first, after null
        dataset.addAll(
        }, (result) -> {
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
                assertEquals("{histo=0.8, keyword=z}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(
                assertEquals(4, result.getBuckets().size());  
            assertEquals(1L, result.getBuckets().get(1).getDocCount());  
            Arrays.asList(
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                        .missingOrder(MissingOrder.LAST)  
                    Arrays.asList(0L, 100L),
                "name",
            (result) -> {
            (result) -> {  
        );  
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            }
                assertEquals(2L, result.getBuckets().get(2).getDocCount());  
                assertEquals(2, result.getBuckets().size());  
                "name",
                    "long",  
                new MatchAllDocsQuery(),
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true)
            ).aggregateAfter(Collections.singletonMap("unmapped", null)),  
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST),
                Arrays.asList(new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10))  
                new TopHitsAggregationBuilder("top_hits").storedField("_none_")
                createDocument("date", asLong("2017-10-20T06:09:24")),
                Arrays.asList(
                )
        for (Aggregator.SubAggCollectionMode mode : Aggregator.SubAggCollectionMode.values()) {
        testSearchCase(  
                assertEquals("{date=1508472000000}", result.afterKey().toString());  
                        .interval(10)
                assertEquals(1, subTerms.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
                    V term = transformKey.apply(bucket.getKey().get(field));
        assertThat(exc.getCause().getMessage(), containsString("now() is not supported in [after] key"));
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                createDocument("date", asLong("2017-10-20T03:08:45"), "keyword", Arrays.asList("a", "c")),
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                assertEquals("{date=1508385600000}", result.getBuckets().get(1).getKeyAsString());
        );  
                createDocument("date", asLong("2016-09-20T11:34:00"), "keyword", Arrays.asList("b", "z")),
            ),  
            assertEquals("{keyword=c}", result.getBuckets().get(0).getKeyAsString());
            builders.add(null);  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
    }  
                        .missingBucket(true)
                        .missingBucket(true)
            (result) -> {
    }  
            () -> new CompositeAggregationBuilder(
        Map<Comparable<?>, AtomicLong> expectedDocCounts = new HashMap<>(); // how many docs for each value
                assertEquals("{keyword=b, price=50.0}", result.getBuckets().get(1).getKeyAsString());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {  
            dataset,  
                iae.getMessage()
                assertEquals(2L, result.getBuckets().get(2).getDocCount());  
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                        .missingOrder(MissingOrder.FIRST)  
            ),  
        testSearchCase(
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                assertEquals("{keyword=a, date_histo=1508457600000}", result.getBuckets().get(0).getKeyAsString());  
            dataset,
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(6).getKeyAsString());
                assertEquals("{date=1508457600000, unmapped=null}", result.getBuckets().get(2).getKeyAsString());
        });  
            Arrays.asList(  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals(3, result.getBuckets().size());
                    new TermsValuesSourceBuilder("double").field("double")  
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
                "name",
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());  
                "name",
                .format("yyyy-MM-dd");
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                assertEquals("{price=null}", result.afterKey().toString());  
            });  
            }
                            .subAggregation(new MaxAggregationBuilder("max").field("long"))
        testSearchCase(  
            dataset,
                    assertEquals("{date=1591142400000, keyword=22640}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{price=70.0}", result.getBuckets().get(3).getKeyAsString());  
                assertEquals("{keyword=b, long=100, double=0.4}", result.getBuckets().get(4).getKeyAsString());  
    }  
        testSearchCase(
                assertNull(result.afterKey());
                InternalMax max = subTerms.getBuckets().get(0).getAggregations().get("max");
                    new HistogramValuesSourceBuilder("price").field("price")  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                        .interval(10)
                assertEquals(1, result.getBuckets().get(5).getDocCount());
                    assertEquals("{date=1591142400000, keyword=91640}", result.getBuckets().get(2).getKeyAsString());  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());  
                assertEquals("{keyword=a, long=0, double=0.4}", result.getBuckets().get(1).getKeyAsString());  
                createDocument("keyword", "b", "long", 10L, "foo", "bar"),
            (result) -> {
            assertEquals(2, result.getBuckets().size());
                Arrays.asList(
            assertEquals(3, result.getBuckets().size());
            FilterAggregationBuilder filterAggregatorBuilder = new FilterAggregationBuilder(  
        int numTerms = randomIntBetween(10, 500);
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST),
    public void testWithKeywordAndMissingBucket() throws Exception {  
                createDocument("ip", InetAddress.getByName("::1")),  
                assertEquals(7, result.getBuckets().size());
            () -> new CompositeAggregationBuilder(
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                "name",
        );  
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
                    new DateHistogramValuesSourceBuilder("date_histo").field("date").dateHistogramInterval(DateHistogramInterval.days(1))  
        executeTestCase(  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
        });  
                assertEquals("{keyword=c, unmapped=null}", result.getBuckets().get(1).getKeyAsString());  
        testSearchCase(
            assertEquals("{keyword=a}", result.getBuckets().get(1).getKeyAsString());
            () -> new CompositeAggregationBuilder(  
            assertNotNull(topHits);
            )  
            dataset,  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals("{price=70.0}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=z, price=50.0}", result.afterKey().toString());
            (result) -> {
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                createDocument("keyword", "c", "long", Arrays.asList(100L, 0L, 10L)),
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());  
        }
            ),
                )
 * ownership. Elasticsearch licenses this file to you under  
    public void testWithKeywordLongAndMissingBucket() throws Exception {
                createDocument("keyword", "c")
            testSearchCase(
            ),
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
        dataset.addAll(
                assertEquals(2, result.getBuckets().size());
                assertEquals("{unmapped=null}", result.afterKey().toString());
            assertEquals("{date=2017-10-20}", result.afterKey().toString());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                        .missingBucket(true)
        // sort ascending, null bucket is first, same as default.  
                Arrays.asList(
                createDocument("date", asLong("2020-06-03T01:10:10"), "keyword", "22640"),
            }  
                createDocument("keyword", "a"),
                assertEquals("a", subTerms.getBuckets().get(0).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
        );
        }, (result) -> {
                createDocument("keyword", "c"),  
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                new FieldExistsQuery("date"),
                Arrays.asList(
            )
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                createDocument("date", asLong("2017-10-20T03:08:45"), "_doc_count", 5),  
                "name",
                    new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING)
import java.util.function.Function;
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                createDocument("double", 0d, "keyword", "c"),
        testSearchCase(
            assertEquals("{keyword=null}", result.getBuckets().get(0).getKeyAsString());  
            assertEquals(topHits.getHits().getHits().length, 1);  
                createDocument("keyword", Arrays.asList("a", "b")),
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
                Collections.singletonMap("keyword", "b")
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), dataset, () -> {
            assertNull(result.afterKey());  
            filterAggregatorBuilder.subAggregation(
    }
 * under the License.  
            assertEquals(5, result.getBuckets().size());
}
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(6).getKeyAsString());
import static org.hamcrest.Matchers.containsString;
            assertEquals("{keyword=bar}", result.getBuckets().get(0).getKeyAsString());
            )
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                )  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());  
                "name",
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true);
 * compatible open source license.
        // asc, null bucket is first, after 50.0
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),  
        );
        );
        }, (result) -> {  
                Collections.singletonMap("keyword", "a")
                createDocument("date", asLong("2017-10-20T03:08:45"), "keyword", Arrays.asList("a", "c")),  
            );
    }  
            () -> {  
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(2L, result.getBuckets().get(5).getDocCount());  
            Arrays.asList(
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
            dataset,
                    assertThat(bucket.getDocCount(), equalTo(expectedDocCounts.get(term).get()));
        testRandomTerms("long", () -> randomLong(), (v) -> (long) v);  
                    )
import org.apache.lucene.search.TermQuery;
                if (seen.size() > 0) {
                    Arrays.asList(0.4d, 0.09d)  
/*  
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals("{price=60.0}", result.getBuckets().get(1).getKeyAsString());
                "name",  
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))  
                createDocument("keyword", "a", "long", 0L, "foo", "bar"),  
                assertEquals("{price=50.0}", result.afterKey().toString());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
            assertEquals("{ip=127.0.0.1}", result.getBuckets().get(1).getKeyAsString());  
        );  
                createDocument("keyword", "c"),
                createDocument("keyword", "d"),  
            ),
                assertEquals(6, result.getBuckets().size());
                    afterKey = Collections.singletonMap(field, seen.get(seen.size() - 1));  
                assertEquals(76L, (long) max.getValue());
                assertEquals("{date=1508457600000, unmapped=null}", result.afterKey().toString());  
                assertEquals(2, result.getBuckets().size());
    ) throws IOException {
            (result) -> {
            )  
                ).size(3),
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            ).aggregateAfter(createAfterKey("keyword", "z", "long", 100L)),  
                int rand = randomIntBetween(0, terms.size() - 1);  
            );  
            () -> testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), Collections.emptyList(), () -> {
                Collections.singletonMap("ip", "::1")  
            }
            () -> new CompositeAggregationBuilder(
            Arrays.asList(  
                assertEquals("{keyword=g, price=20.0}", result.getBuckets().get(5).getKeyAsString());  
        Set<T> valuesSet = new HashSet<>(); // how many different values  
 * Modifications Copyright OpenSearch Contributors. See
                createDocument("keyword", "c"),
    public void testWithIP() throws Exception {
            assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());  
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
    public void testWithKeywordAndTopHits() throws Exception {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            ),
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{keyword=z, long=100}", result.getBuckets().get(5).getKeyAsString());
            Arrays.asList(
        }, (result) -> {
            executeTestCase(
        );
import java.util.Map;
        dataset.addAll(
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),  
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                new FieldExistsQuery("date"),  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {  
        testSearchCase(  
                )  
import org.apache.lucene.search.MatchAllDocsQuery;
         * date 2017-10-20T03:08:45 into 2017-10-19's bucket.
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
        // desc, null bucket is first, after 60.0
                    createAfterKey("date", 1474329600000L) // 2016-09-20T00:00:00
                        .missingBucket(true)
            assertEquals("{keyword=a}", result.getBuckets().get(1).getKeyAsString());
                )
                Arrays.asList(
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                )
            assertEquals("{keyword=zoo}", result.getBuckets().get(2).getKeyAsString());
                    createAfterKey("date", 1474329600000L)
                createDocument("double", 0.45d, "keyword", Arrays.asList("b", "c")),  
            ).aggregateAfter(createAfterKey("keyword", "c", "long", null)),  
        );
            Arrays.asList(new MatchAllDocsQuery()),
                assertEquals("w", subTerms.getBuckets().get(1).getKeyAsString());  
                Arrays.asList(
            assertEquals("{keyword=d}", result.getBuckets().get(3).getKeyAsString());  
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(1).getKeyAsString());
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                "name",  
        /*  
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
                    new CompositeAggregationBuilder(
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;  
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
            ).aggregateAfter(createAfterKey("keyword", "b", "long", 10L)).size(2),
            Arrays.asList(  
            Arrays.asList(
            return filterAggregatorBuilder;
            DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                createDocument("keyword", "a"),
            () -> new CompositeAggregationBuilder(
                createDocument("keyword", "c", "long", 100L),
                    new TermsValuesSourceBuilder("keyword").field("keyword")
            assertEquals("{keyword=a}", result.getBuckets().get(3).getKeyAsString());
                    new HistogramValuesSourceBuilder("price").field("price")
                assertEquals(2, result.getBuckets().size());  
        );
        // desc, null bucket is last, after 50.0  
                assertEquals("{histo=0.9, keyword=a}", result.getBuckets().get(1).getKeyAsString());  
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
        dataset.addAll(
            assertEquals("{keyword=null}", result.getBuckets().get(3).getKeyAsString());
                assertEquals("{keyword=z, date_histo=1474329600000}", result.afterKey().toString());
                new FieldExistsQuery("date"),
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                "name",
            assertEquals("{keyword=d}", result.afterKey().toString());  
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    assertEquals("{date=1591142400000, keyword=37640}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                Arrays.asList(
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo));  
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
                )  
        });
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(3, result.getBuckets().size());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals("{price=60.0}", result.getBuckets().get(1).getKeyAsString());  
                assertEquals("d", subTerms.getBuckets().get(0).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                Arrays.asList(
    }  
                assertEquals("{histo=0.9, keyword=d}", result.afterKey().toString());  
            assertEquals(3, result.getBuckets().size());
                assertEquals("{keyword=a, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=null, long=100}", result.afterKey().toString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                Arrays.asList(new TermsValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true))
                Arrays.asList(  
                createDocument("keyword", "d"),  
            assertEquals(4, result.getBuckets().size());
                }
                    )
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            }
        );  
            executeTestCase(false, false, new MatchAllDocsQuery(), Collections.emptyList(), () -> {
            ),
        );  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
        // unmapped missing bucket = one result
                "name",
                assertEquals("y", subTerms.getBuckets().get(1).getKeyAsString());
                createDocument("price", 103L, "keyword", Arrays.asList("a", "c")),
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
    public void testIndexSortWithDuplicate() throws Exception {
        testSearchCase(  
                )
        );  
            assertEquals("{keyword=b}", result.getBuckets().get(3).getKeyAsString());
                )
                createDocument("keyword", Arrays.asList("a", "z"), "long", Arrays.asList(0L, 100L)),
                )
                assertEquals("{keyword=c, long=10, double=0.09}", result.getBuckets().get(3).getKeyAsString());
                    assertEquals("{date=1591142400000, keyword=31640}", result.getBuckets().get(2).getKeyAsString());
                createDocument("keyword", "e", "long", 10L, "foo", "bar")
        );  
                        .order(SortOrder.DESC)
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                createDocument("keyword", "c", "long", Arrays.asList(100L, 0L, 10L), "double", 0.09d),
                "name",
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                    new TermsValuesSourceBuilder("double").field("double")
                assertEquals("{date=1508457600000, keyword=d}", result.afterKey().toString());
                );
                createDocument("price", 105L, "keyword", Arrays.asList("a", "d")),
            (result) -> {  
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(5).getKeyAsString());
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{keyword=z, long=0}", result.afterKey().toString());  
                createDocument("keyword", "foo"),
                )
            () -> testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), Collections.emptyList(), () -> {  
                assertEquals("{keyword=c, date_histo=1508457600000}", result.getBuckets().get(0).getKeyAsString());  
                Arrays.asList(  
                "name",
                assertEquals(4, result.getBuckets().size());
                assertEquals("{price=20.0, unmapped=null}", result.getBuckets().get(0).getKeyAsString());  
            ).aggregateAfter(createAfterKey("keyword", "z", "long", 100L, "double", 0.4d)),
            (result) -> {
                assertEquals(2L, result.getBuckets().get(2).getDocCount());  
                Arrays.asList(
                createDocument("long", 0L),
            ).aggregateAfter(createAfterKey("histo", 0.8d, "keyword", "b")),  
                assertEquals(10, result.getBuckets().size());
            assertEquals("{ip=192.168.0.1}", result.afterKey().toString());  
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());  
    public void testDateHistogramSourceWithSize() throws IOException {
                "name",  
    }  
            ).aggregateAfter(createAfterKey("keyword", "c")),  
                    .calendarInterval(DateHistogramInterval.days(1));
            (result) -> {
            (result) -> {
    public void testNullSourceNonNullCollection() {  
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
        );
    public void testMultiValuedWithKeywordDesc() throws Exception {
import org.opensearch.search.aggregations.AggregationBuilders;
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))  
        // asc, null bucket is last  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(6).getKeyAsString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
        );
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true).missingOrder(MissingOrder.LAST)
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                .missingOrder(MissingOrder.FIRST)
            }
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                    .format("yyyy-MM-dd");
        );  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            assertEquals("{keyword=a}", result.getBuckets().get(2).getKeyAsString());
                createDocument(mappedFieldName, asLong("2017-10-19T06:09:24"))
        });
                        .interval(10)  
                    new TermsValuesSourceBuilder("unmapped").field("unmapped")
                createDocument("keyword", "c", "long", 100L),
            assertEquals("{keyword=a}", result.getBuckets().get(4).getKeyAsString());
 */
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))  
        List<Comparable<T>> seen = new ArrayList<>();
                    .timeZone(ZoneId.of("America/Los_Angeles"));
                assertEquals("{price=70.0}", result.getBuckets().get(1).getKeyAsString());
            )
                assertEquals("{keyword=null, long=null}", result.afterKey().toString());  
                Arrays.asList(  
                new FieldExistsQuery("date"),  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>(
                )
                createDocument("double", 0d, "keyword", "c", "long", 100L),
        );  
            assertEquals(4, result.getBuckets().size());
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                Arrays.asList(
                createDocument("keyword", Arrays.asList("c", "a")),  
                "name",
import java.util.List;
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                createDocument("keyword", "a", "terms", "a", "long", 50L),  
                        new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING)
                        new DateHistogramValuesSourceBuilder("date").field("date")  
                assertEquals("{date=1508468925000}", result.getBuckets().get(3).getKeyAsString());
                "name",
                assertEquals("{keyword=c, long=100, double=0.4}", result.afterKey().toString());  
                    assertEquals("{date=1591142400000, keyword=90640}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());  
                assertEquals("{keyword=a, long=100, double=0.4}", result.getBuckets().get(3).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                createDocument("ip", InetAddress.getByName("192.168.0.1")),
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
        // sort ascending, null bucket is last.
                    new TermsValuesSourceBuilder("keyword").field("keyword"),  
        executeTestCase(  
                    new TermsValuesSourceBuilder("double").field("double")
            () -> new CompositeAggregationBuilder(
            assertEquals(2L, result.getBuckets().get(1).getDocCount());  
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());  
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
                createDocument("date", asLong("2017-10-19T06:09:24")),
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                createDocument("double", 0.98d, "keyword", Arrays.asList("a", "d")),
                Arrays.asList(
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
                assertEquals("{keyword=d, long=1000}", result.getBuckets().get(8).getKeyAsString());
            (result) -> {  
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());  
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true),
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
                createDocument("date", asLong("2020-06-03T01:21:10"), "keyword", "11640"),  
                "name",
                assertEquals(1, result.getBuckets().size());  
            }  
    public void testDateHistogramSourceWithDocCountField() throws IOException {  
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).size(1);
                        .calendarInterval(DateHistogramInterval.days(1))  
            testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(field)), dataset, () -> {  
        testSearchCase(  
            ),
            () -> new CompositeAggregationBuilder(
                        .interval(10)  
            assertNotNull(topHits);
            assertEquals("{keyword=d}", result.getBuckets().get(3).getKeyAsString());  
        // desc, null bucket is first  
                assertEquals(3, result.getBuckets().size());
                    new HistogramValuesSourceBuilder("price").field("price")  
                assertEquals("{histo=0.4, keyword=a}", result.getBuckets().get(0).getKeyAsString());
                    finish.set(true);
        }, (result) -> {
            assertEquals("{keyword=bar}", result.afterKey().toString());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());
 * specific language governing permissions and limitations
        );
        // field + unmapped, no missing bucket = no results  
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());  
            );  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
            (result) -> {  
            return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(  
            }
                Arrays.asList(
        OpenSearchParseException exc = expectThrows(
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                .missingBucket(true)
    public void testWithKeyword() throws Exception {
            dataset,
package org.opensearch.search.aggregations.bucket.composite;
                assertEquals("{date=1474329600000, keyword=b}", result.getBuckets().get(0).getKeyAsString());  
        dataset.addAll(  
            }  
         * Tests a four hour offset with a time zone, demonstrating
            }  
         */  
                createDocument("keyword", Arrays.asList("a", "b")),
                assertEquals("{keyword=d, long=1000, double=1.0}", result.getBuckets().get(8).getKeyAsString());  
        );  
        assertThat(e.getMessage(), equalTo("Composite source names must be unique, found duplicates: [duplicate2, duplicate1]"));
                assertEquals(8, result.getBuckets().size());  
            assertEquals("{ip=192.168.0.1}", result.afterKey().toString());
                assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
            },
            Arrays.asList(
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
        );
 *  
                createDocument("long", 4L)
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals(2, subTerms.getBuckets().size());  
            (result) -> {
        );
                createDocument("date", asLong("2016-09-20T11:34:00"), "_doc_count", 2),
            assertEquals(2L, result.getBuckets().get(1).getDocCount());  
            Arrays.asList(
                createDocument("long", 4L)
        // sort descending, null bucket is last, same as default
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
            () -> new CompositeAggregationBuilder(
import java.util.Arrays;  
        testSearchCase(  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
        executeTestCase(false, false, new MatchAllDocsQuery(), Collections.emptyList(), () -> {
            Arrays.asList(new MatchAllDocsQuery()),
                assertEquals(3, result.getBuckets().size());  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
        dataset.addAll(  
        );
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
    }
 * not use this file except in compliance with the License.
            ),  
            ),  
        testSearchCase(  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
        });
                assertEquals(2, result.getBuckets().size());  
    public void testMultiValuedWithKeyword() throws Exception {  
                Collections.singletonList(createDocument()),
                assertEquals("{histo=0.5, keyword=g}", result.getBuckets().get(3).getKeyAsString());
                createDocument("keyword", "e", "long", 100L, "foo", "bar"),
            );  
    public void testUnmappedFieldWithTerms() throws Exception {
            ),
            Arrays.asList(
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
        dataset.addAll(  
                return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).subAggregation(
                createDocument("long", 100L)
                assertEquals(1L, result.getBuckets().get(3).getDocCount());  
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true)
                assertEquals(4, result.getBuckets().size());  
                assertEquals("{price=null}", result.getBuckets().get(3).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            dataset,  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
            },  
            dataset,
            () -> new CompositeAggregationBuilder(
                    count.incrementAndGet();  
    }
                )  
            (result) -> {
            assertEquals(2L, result.getBuckets().get(2).getDocCount());  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
    }
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
 *
            assertEquals(1L, result.getBuckets().get(0).getDocCount());  
            dataset,
                createDocument("double", 0.8d, "keyword", Arrays.asList("b", "z")),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                );
        );  
        );
 * GitHub history for details.
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")  
                        .missingOrder(MissingOrder.FIRST)
                        .missingBucket(true)
            Arrays.asList(  
                assertEquals("{keyword=z, date_histo=1474329600000}", result.getBuckets().get(3).getKeyAsString());  
                createDocument("long", 4L)
            )
        }, (result) -> {  
                Collections.singletonMap("keyword", "c")
            (result) -> {  
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
            () -> new CompositeAggregationBuilder(  
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
        });  
        testSearchCase(
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped")
            Arrays.asList(  
            );  
                assertEquals("{price=50.0}", result.getBuckets().get(0).getKeyAsString());  
            Arrays.asList(
                createDocument("date", asLong("2017-10-20T03:08:45")),  
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
        Collections.sort(expected);
        });  
        dataset.addAll(
        );  
                createDocument("double", 0.8d, "keyword", Arrays.asList("b", "z")),
            }
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
        }, (result) -> {
                .missingBucket(true)
import java.util.HashSet;  
                Arrays.asList(  
                assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
            },
                )
                createDocument("date", asLong("2017-10-19T06:09:24")),
                    "double",
                )
                assertEquals(10, result.getBuckets().size());  
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
import java.util.function.Supplier;
                "name",
            assertEquals("{keyword=c}", result.getBuckets().get(0).getKeyAsString());
            (result) -> {  
    }
                    .calendarInterval(DateHistogramInterval.days(1))  
            dataset,
            assertEquals("{keyword=a}", result.afterKey().toString());
                createDocument("keyword", "d"),
                    new DateHistogramValuesSourceBuilder("date").field("date").dateHistogramInterval(DateHistogramInterval.days(1)),
            )  
    }
            DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")  
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
        }
import java.io.IOException;
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
        );
        testSearchCase(  
            true,
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                    .calendarInterval(DateHistogramInterval.days(1));  
            fail("Should have thrown an IllegalArgumentException");
                createDocument(mappedFieldName, asLong("2017-10-20T03:08:45")),  
                createDocument(mappedFieldName, 51),
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
            (result) -> assertEquals(0, result.getBuckets().size())
        for (SortOrder order : SortOrder.values()) {  
                createDocument("price", 62, "long", 4L),  
                )  
            assertEquals(4, result.getBuckets().size());
            )
            )
                        .interval(10)  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
            );  
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
            dataset,  
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=d, long=10, double=1.0}", result.getBuckets().get(6).getKeyAsString());
                    new HistogramValuesSourceBuilder("price").field("price")
            dataset,
                assertEquals("{keyword=z, long=0, double=0.09}", result.afterKey().toString());
        while (finish.get() == false) {
                "name",
        testSearchCase(  
                "name",
        try {  
                assertEquals(1L, result.getBuckets().get(4).getDocCount());  
            ).aggregateAfter(createAfterKey("date", 1508371200000L, "keyword", "g")),  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),  
            Arrays.asList(
        testSearchCase(
        dataset.addAll(  
                )
            }
                assertEquals(2L, result.getBuckets().get(6).getDocCount());  
                assertEquals("{keyword=z, price=50.0}", result.afterKey().toString());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),  
        // field + unmapped, no missing bucket = no results
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            Set<Object> values = new HashSet<>();
    }
                new FieldExistsQuery("date"),  
            assertEquals("{keyword=d}", result.afterKey().toString());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
            ),
        }, (result) -> {
                        new TermsValuesSourceBuilder("keyword").field("keyword")
        );  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.FieldExistsQuery;  
            }
                createDocument("double", 0d, "keyword", "a", "long", 100L),
                );
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                createDocument("keyword", "a", "long", 100L),
                assertEquals(1L, result.getBuckets().get(9).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                assertEquals("{keyword=c, long=null}", result.getBuckets().get(4).getKeyAsString());
        } catch (IllegalArgumentException iae) {  
                    assertEquals("{date=1591142400000, keyword=31640}", result.afterKey().toString());
                assertEquals(7, result.getBuckets().size());  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            ).aggregateAfter(createAfterKey("price", 70.0)),  
                createDocument(mappedFieldName, 25)
                createDocument("keyword", Collections.emptyList())
                    createAfterKey("date", 1474329600000L)  
            (result) -> {
            () -> new CompositeAggregationBuilder(
                    new HistogramValuesSourceBuilder("price").field("price")  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                .dateHistogramInterval(DateHistogramInterval.days(1))  
        int numDocs = randomIntBetween(100, 200);
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), dataset, () -> {
        testSearchCase(  
            }  
            assertEquals("{keyword=bar}", result.getBuckets().get(2).getKeyAsString());  
            (result) -> assertEquals(0, result.getBuckets().size())
            );
        List<Map<String, List<Object>>> dataset = new ArrayList<>();
    public void testEarlyTermination() throws Exception {  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("ip")), dataset, () -> {  
                assertEquals(3, result.getBuckets().size());
                        .missingBucket(true)
            () -> {
            }
                new MatchAllDocsQuery(),
                createDocument("long", 100L)
        });
            assertEquals("{keyword=null}", result.afterKey().toString());
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
        );  
                assertEquals("{keyword=d, long=100}", result.getBuckets().get(2).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());  
    }
public class CompositeAggregatorTests extends BaseCompositeAggregatorTestCase {
        assertThat(exc.getMessage(), containsString("failed to parse date field [1474329600000]"));  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),  
                createDocument("keyword", "a"),
                "name",
            Arrays.asList(
                assertEquals(0, result.getBuckets().size());
        testSearchCase(  
                            .calendarInterval(DateHistogramInterval.days(1)),
                assertEquals("{date=1508371200000}", result.getBuckets().get(1).getKeyAsString());
                createDocument("keyword", "d", "long", 10L),
            dataset,
                new MatchAllDocsQuery(),
                createDocument("double", 0.55d, "keyword", Arrays.asList("g")),  
import org.apache.lucene.document.LongPoint;
            dataset,  
                Arrays.asList(
        );
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),  
    }
        );  
                assertEquals("{date=1508371200000}", result.getBuckets().get(0).getKeyAsString());
            assertEquals("{keyword=a}", result.getBuckets().get(1).getKeyAsString());
            () -> new CompositeAggregationBuilder(  
            (result) -> {
            Arrays.asList(new MatchAllDocsQuery()),
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                "filter_mcmilterface",
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
        dataset.addAll(
            dataset,
                assertEquals("{date=1508457600000, keyword=d}", result.getBuckets().get(2).getKeyAsString());
                    assertEquals(3, result.getBuckets().size());
                assertEquals("{price=null}", result.afterKey().toString());  
            assertEquals(2, result.getBuckets().size());
                createDocument("keyword", Arrays.asList("b", "d")),
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                createDocument("keyword", "d"),
                assertEquals("{price=null}", result.afterKey().toString());  
                );  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                createDocument("keyword", Arrays.asList("c", "a")),
        );
            () -> new CompositeAggregationBuilder(
                }
                .dateHistogramInterval(DateHistogramInterval.days(1))
            () -> new CompositeAggregationBuilder(  
                    new HistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName).interval(10),
                createDocument("date", asLong("2016-09-20T09:00:34")),  
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");  
        }, (result) -> {  
        });
            Arrays.asList(new MatchAllDocsQuery()),
            assertEquals(2L, result.getBuckets().get(4).getDocCount());  
            dataset,
            assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                new MatchAllDocsQuery(),
                "name",  
        );
                createDocument("keyword", "a", "long", 0L),  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
    }
        // keyword null bucket is last, long null bucket is last  
                "name",  
            assertEquals("{keyword=b}", result.getBuckets().get(0).getKeyAsString());
                    new HistogramValuesSourceBuilder("price").field("price").interval(10)
            assertTrue(
            ).aggregateAfter(createAfterKey("price", null)),
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>(
            Arrays.asList(
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
                TermsValuesSourceBuilder histo = new TermsValuesSourceBuilder("date").field("date");
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(1).getKeyAsString());  
        // asc, null bucket is last, search after non null value  
                "name",
            builders.add(new TermsValuesSourceBuilder("duplicate1").field("bar"));
        for (Aggregator.SubAggCollectionMode mode : Aggregator.SubAggCollectionMode.values()) {
            () -> new CompositeAggregationBuilder(
            (result) -> {
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("ip").field("ip");
                "name",  
            assertNotNull(topHits);
                        .missingOrder(MissingOrder.LAST)
            assertEquals("{keyword=null}", result.afterKey().toString());  
/*
                "name",
                new MatchAllDocsQuery(),  
        }, (result) -> {
                createDocument("date", asLong("2017-10-20T06:09:24")),  
                assertEquals("{keyword=b, long=100, double=0.4}", result.getBuckets().get(0).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
        );
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(2).getKeyAsString());
            }
                assertEquals("{date=1508324400000}", result.getBuckets().get(1).getKeyAsString());  
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals(2L, result.getBuckets().get(0).getDocCount());  
        );  
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
            dataset,  
    public void testWithKeywordAndHistogram() throws IOException {
                }
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("ip")), dataset, () -> {
                assertEquals(3, result.getBuckets().size());  
    }  
            assertEquals(2, result.getBuckets().size());  
        testSearchCase(  
            (result) -> {  
                Arrays.asList(
                assertEquals("{date=1474371240000}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(6).getDocCount());  
                createDocument("keyword", "c"),
                Arrays.asList(  
                assertEquals("{date=1508457600000}", result.getBuckets().get(2).getKeyAsString());
        testSearchCase(
            ).aggregateAfter(createAfterKey("keyword", "c")),
            assertEquals("{keyword=zoo}", result.afterKey().toString());  
                assertEquals(1, result.getBuckets().size());
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
    public void testWithKeywordMissingAfter() throws Exception {
                createDocument("date", asLong("2017-10-20T06:09:24")),  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),  
            assertEquals(2L, result.getBuckets().get(1).getDocCount());  
    }
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("ip").field("ip");
        testSearchCase(
            ),
            ),  
            () -> new CompositeAggregationBuilder(
        }, (result) -> {
            },  
                );
            }
            Arrays.asList(
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
                createDocument("price", 60, "long", 2L),
                    new HistogramValuesSourceBuilder("histo").field("double").interval(0.1),
                    .offset(TimeUnit.HOURS.toMillis(4));
        }, (result) -> {
                createDocument("date", asLong("2017-10-19T06:09:24"), "keyword", Arrays.asList("g")),  
                subTerms = result.getBuckets().get(1).getAggregations().get("terms");
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(topHits.getHits().getHits().length, 1);  
        });
                assertEquals("{price=60.0}", result.getBuckets().get(2).getKeyAsString());  
                )
                assertEquals("{date=1508410800000}", result.getBuckets().get(2).getKeyAsString());
            assertEquals("{date=2017-10-19}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(
            }
            );
        );  
        );
        String mappedFieldName = "date";
                "name",
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{date=1474344000000}", result.getBuckets().get(0).getKeyAsString());
        );
                TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");  
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
            (result) -> {
    public void testRandomStrings() throws IOException {
                new MatchAllQueryBuilder()
        );
            (result) -> {  
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped")
                            .collectMode(mode)
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
        );
            assertEquals(4, result.getBuckets().size());
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery()),
            )
        });
            assertEquals("{date=2017-10-20}", result.afterKey().toString());  
                assertEquals("{price=70.0}", result.afterKey().toString());
                createDocument("keyword", "c"),  
            }  
                assertEquals("{keyword=c, long=0}", result.getBuckets().get(6).getKeyAsString());
        testSearchCase(
            () -> {
                assertEquals(2L, result.getBuckets().get(0).getDocCount());  
            }
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertEquals("{keyword=foo}", result.getBuckets().get(0).getKeyAsString());
    public void testMultiValuedWithKeywordLongAndDouble() throws Exception {  
            () -> new CompositeAggregationBuilder(
 * Unless required by applicable law or agreed to in writing,
                )  
                new FieldExistsQuery("date"),
                createDocument("date", asLong("2016-09-20T09:00:34")),
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            ),  
                createDocument("keyword", "d", "long", 10L),
        testSearchCase(
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
        testSearchCase(
        dataset.addAll(
import org.opensearch.index.query.MatchAllQueryBuilder;
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
import org.opensearch.search.aggregations.support.ValueType;
            Arrays.asList(  
                assertEquals("{price=50.0}", result.getBuckets().get(2).getKeyAsString());
                    assertEquals("{date=1591142400000, keyword=91640}", result.afterKey().toString());
        assertThat(e.getMessage(), equalTo("Composite [sources] cannot be null or empty"));  
 * The OpenSearch Contributors require contributions made to  
            assertEquals("{keyword=delta}", result.getBuckets().get(1).getKeyAsString());  
                createDocument("price", 51L, "keyword", Arrays.asList("b", "c")),  
            return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
            dataset,
            (result) -> {  
        dataset.addAll(
                .order(SortOrder.DESC);  
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
        );
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
            assertNotNull(topHits);
                )
            dataset,
    }
                assertEquals("{keyword=a, long=100}", result.afterKey().toString());  
            }, (result) -> {
                assertEquals(3, result.getBuckets().size());
                "name",  
                createDocument("double", 0d, "long", 100L),  
                assertEquals("{price=null}", result.afterKey().toString());
            }
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(8).getKeyAsString());  
            }
                Map<String, Object> afterKey = null;
                    new HistogramValuesSourceBuilder("price").field("price")
                    AtomicLong count = expectedDocCounts.computeIfAbsent(terms.get(rand), (k) -> new AtomicLong(0));
    }  
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST))  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                createDocument("keyword", "a"),  
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(5).getKeyAsString());  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                false,
            )
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                    new TermsValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true)
            assertEquals("{keyword=z}", result.afterKey().toString());  
                )
                        .missingBucket(true)  
        // sort descending, null bucket is first
        testSearchCase(  
                assertEquals(2L, result.getBuckets().get(8).getDocCount());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                createDocument(mappedFieldName, asLong("2017-10-20T06:09:24")),  
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());  
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
                Arrays.asList(  
                assertEquals(78L, (long) max.getValue());
        });  
            assertEquals(topHits.getHits().getHits().length, 2);  
    public void testWithDateHistogram() throws IOException {  
            }  
    }
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));  
        dataset.addAll(
            assertEquals(5, result.getBuckets().size());  
            ),
                Arrays.asList(
            )  
                createDocument("date", asLong("2020-06-03T00:53:10"), "keyword", "37640"),
                assertEquals("{histo=0.9, keyword=d}", result.getBuckets().get(7).getKeyAsString());
            assertEquals(topHits.getHits().getTotalHits().value(), 2L);
        List<T> terms = new ArrayList<>(); // possible values for the terms  
                Arrays.asList(  
            assertEquals("{ip=::1}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{date=1508385600000}", result.getBuckets().get(1).getKeyAsString());  
            assertEquals(3, result.getBuckets().size());  
                assertEquals("{date=1474329600000, keyword=z}", result.getBuckets().get(2).getKeyAsString());
            }  
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                createDocument("date", asLong("2016-09-20T09:00:34"), "keyword", Arrays.asList("b", "c")),
    }
                assertEquals(1, result.getBuckets().size());
            () -> new CompositeAggregationBuilder(
            assertEquals(0, result.getBuckets().size());
        testSearchCase(
                assertEquals("{date=1508457600000, keyword=d}", result.getBuckets().get(6).getKeyAsString());  
                assertEquals(1, result.getBuckets().size());
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
         */
        testRandomTerms("price", () -> randomInt(), (v) -> ((Number) v).intValue());
        testSearchCase(
                assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{histo=0.9, keyword=d}", result.afterKey().toString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                "name",
        dataset.addAll(
            assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                createDocument("long", 4L)
            (result) -> {
            assertEquals("{ip=192.168.0.1}", result.getBuckets().get(2).getKeyAsString());
                createDocument("keyword", "c", "long", 100L),  
        );
        testSearchCase(
                createAfterKey("date", "2016-09-20")
            dataset,  
            ).aggregateAfter(createAfterKey("keyword", "a", "long", 100L)),
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                createDocument("long", 100L)
            ),
        }, (result) -> {
                        .missingBucket(true)
                createDocument(mappedFieldName, 103),
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped").calendarInterval(DateHistogramInterval.days(1))
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{date=1508371200000, keyword=g}", result.getBuckets().get(3).getKeyAsString());  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals("{keyword=b, long=100}", result.getBuckets().get(2).getKeyAsString());
                "name",
            );  
                assertEquals(1L, result.getBuckets().get(0).getDocCount());  
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(4).getKeyAsString());
                .order(SortOrder.DESC);
            (result) -> assertEquals(0, result.getBuckets().size())
                max = subTerms.getBuckets().get(0).getAggregations().get("max");
                assertEquals(3, result.getBuckets().size());
    }  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
            () -> new CompositeAggregationBuilder(
            assertEquals("{keyword=foo}", result.getBuckets().get(1).getKeyAsString());  
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
                assertEquals("{keyword=z, price=50.0}", result.getBuckets().get(3).getKeyAsString());
            assertEquals("{keyword=null}", result.getBuckets().get(3).getKeyAsString());
                        .order(SortOrder.DESC)  
 *
        assertThat(e.getMessage(), equalTo("Composite source cannot be null"));  
                assertEquals(3, result.getBuckets().size());
    }  
            assertEquals("{keyword=d}", result.getBuckets().get(3).getKeyAsString());
                assertEquals(1, result.getBuckets().size());
                "name",
                createDocument("keyword", Arrays.asList("z")),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
            assertEquals(4, result.getBuckets().size());
        dataset.addAll(  
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
                    new DateHistogramValuesSourceBuilder("date_histo").field("date").dateHistogramInterval(DateHistogramInterval.days(1))  
                createDocument("keyword", "a", "long", 100L),
                        .missingBucket(true)
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
        );
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
            }
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                Arrays.asList(new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10).missingBucket(true))
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                Arrays.asList(
            ),
            dataset,
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
                assertEquals(10, result.getBuckets().size());
        testSearchCase(
                new FieldExistsQuery("date"),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            (result) -> {
            assertEquals("{date=2016-09-20}", result.getBuckets().get(0).getKeyAsString());  
                    new TermsValuesSourceBuilder("keyword").field("keyword")
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                createDocument("date", asLong("2017-10-19T06:09:24"), "_doc_count", 3),
            )  
            () -> new CompositeAggregationBuilder(
            () -> new CompositeAggregationBuilder(  
            () -> new CompositeAggregationBuilder(
            },
        testSearchCase(  
