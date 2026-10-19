    public void testRangeQueryWithNumericBounds() {
        createIndex("products");
    public void testRangeQueryWithDateFormat() {
        client().prepareIndex("products").setId("2").setSource("{\"price\": 150}", XContentType.JSON).get();
        SearchResponse response = client().prepareSearch("products").setQuery(QueryBuilders.rangeQuery("price").gte(100).lte(300)).get();
        client().prepareIndex("products").setId("3").setSource("{\"price\": 250}", XContentType.JSON).get();  
            .get();
        client().prepareIndex("logs").setId("1").setSource("{\"timestamp\": \"2024-03-31T10:00:00Z\"}", XContentType.JSON).get();
        refresh("events");
        client().prepareIndex("logs")
        SearchResponse response = client().prepareSearch("logs").setQuery(QueryBuilders.rangeQuery("timestamp").lte("2024-03-31")).get();
        client().prepareIndex("events").setId("1").setSource("{\"created\": \"2022-01-15T10:00:00Z\"}", XContentType.JSON).get();  
public class DslRangeQueryIT extends DslIntegTestBase {
    }  
        refresh("events");  
        assertEquals(1, response.getHits().getTotalHits().value());  
}  
import java.time.ZonedDateTime;
        ZonedDateTime startOfToday = nowZdt.toLocalDate().atStartOfDay(ZoneId.of("UTC"));
    }
        client().prepareIndex("events").setId("1").setSource("{\"created\": \"2022-01-15T10:00:00Z\"}", XContentType.JSON).get();
        createIndex("events");
        refresh("products");  
            .get();  
        client().prepareIndex("events").setId("2").setSource("{\"created\": \"2022-02-15T10:00:00Z\"}", XContentType.JSON).get();
    }
        assertEquals(1, response.getHits().getTotalHits().value());
        SearchResponse response = client().prepareSearch("products").setQuery(QueryBuilders.rangeQuery("price").gt(100).lt(200)).get();
        client().prepareIndex("logs").setId("3").setSource("{\"timestamp\": " + now + "}", XContentType.JSON).get();
        SearchResponse response = client().prepareSearch("events")
        client().prepareIndex("products").setId("2").setSource("{\"price\": 150}", XContentType.JSON).get();  
 * this file be licensed under the Apache-2.0 license or a
            .setId("1")
        client().prepareIndex("logs").setId("2").setSource("{\"timestamp\": \"2024-03-31T23:59:59.999Z\"}", XContentType.JSON).get();  
        createIndex("events");
        client().prepareIndex("products").setId("1").setSource("{\"price\": 100}", XContentType.JSON).get();
@AwaitsFix(bugUrl = "DSL query pipeline not fully wired E2E: fragment conversion, shard execution and Arrow Flight drain pending")
        client().prepareIndex("events").setId("2").setSource("{\"created\": \"2022-01-01T10:00:00Z\"}", XContentType.JSON).get();
/*  
        createIndex("products");  
        createIndex("logs");
import java.time.Instant;  
import org.opensearch.common.xcontent.XContentType;  
        client().prepareIndex("products").setId("2").setSource("{\"price\": 200}", XContentType.JSON).get();
            .setSource("{\"timestamp\": " + startOfToday.toInstant().toEpochMilli() + "}", XContentType.JSON)  
        client().prepareIndex("events").setId("2").setSource("{\"created\": \"2022-02-15T10:00:00Z\"}", XContentType.JSON).get();  
            .setQuery(QueryBuilders.rangeQuery("created").gte("2022-01-01").timeZone("America/New_York"))
    public void testRangeQueryGtAndLt() {  
        assertEquals(1, response.getHits().getTotalHits().value());
package org.opensearch.dsl;
        assertEquals(2, response.getHits().getTotalHits().value());
        client().prepareIndex("logs").setId("3").setSource("{\"timestamp\": \"2024-04-01T00:00:00Z\"}", XContentType.JSON).get();
        SearchResponse response = client().prepareSearch("products").setQuery(QueryBuilders.rangeQuery("price").gte(150).lte(250)).get();
    }
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
 */  
    public void testRangeQueryWithExplicitRounding() {  
        assertEquals(2, response.getHits().getTotalHits().value());  
        client().prepareIndex("events").setId("1").setSource("{\"created\": \"2022-01-01T05:00:00Z\"}", XContentType.JSON).get();  
import org.opensearch.action.search.SearchResponse;
        client().prepareIndex("products").setId("1").setSource("{\"price\": 50}", XContentType.JSON).get();
    public void testRangeQueryWithAutoRoundUp() {  
    public void testRangeQueryWithTimezone() {
    }
    }
        createIndex("products");
        assertTrue(response.getHits().getTotalHits().value() >= 2);
import org.opensearch.index.query.QueryBuilders;
        client().prepareIndex("products").setId("4").setSource("{\"price\": 350}", XContentType.JSON).get();
            .setSource("{\"timestamp\": " + (startOfToday.toInstant().toEpochMilli() - 86400000) + "}", XContentType.JSON)
    public void testRangeQueryBothBounds() {
        SearchResponse response = client().prepareSearch("events")
        client().prepareIndex("logs")  
        createIndex("logs");
            .setId("2")
import java.time.ZoneId;
        long now = System.currentTimeMillis();
        createIndex("events");
    }
            .get();  
        refresh("events");
            .setQuery(QueryBuilders.rangeQuery("created").gte("2022-01-01").lte("2022-01-31").relation("INTERSECTS"))
        client().prepareIndex("products").setId("3").setSource("{\"price\": 300}", XContentType.JSON).get();
        client().prepareIndex("events").setId("3").setSource("{\"created\": \"2022-03-15T10:00:00Z\"}", XContentType.JSON).get();
        SearchResponse response = client().prepareSearch("events")  
            .get();
        client().prepareIndex("products").setId("3").setSource("{\"price\": 200}", XContentType.JSON).get();
        SearchResponse response = client().prepareSearch("logs").setQuery(QueryBuilders.rangeQuery("timestamp").gte("now/d")).get();
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        refresh("products");
        client().prepareIndex("products").setId("1").setSource("{\"price\": 100}", XContentType.JSON).get();  
        ZonedDateTime nowZdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.of("UTC"));  
        assertEquals(2, response.getHits().getTotalHits().value());  
        assertEquals(1, response.getHits().getTotalHits().value());  
        refresh("products");
    }
        refresh("logs");
            .get();
        refresh("logs");  
    public void testRangeQueryWithRelation() {  
 *
 * The OpenSearch Contributors require contributions made to  
            .setQuery(QueryBuilders.rangeQuery("created").gte("01/02/2022").lte("28/02/2022").format("dd/MM/yyyy"))  
