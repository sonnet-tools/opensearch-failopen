        assertAcked(client().execute(PutIndexFieldDomainsAction.INSTANCE, request).actionGet());
        Index targetIndex = indexMetadata(indexName).getIndex();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testPutIndexFieldDomainsActionPublishesIndexMetadata() throws Exception {  
}
        assertThat(customData.get("fields.event.ingested.type"), equalTo("date_range"));
 * The OpenSearch Contributors require contributions made to  
        assertThat(customData.get("fields.event.ingested.finalized"), equalTo("true"));
        assertThat(customData.get("fields.@timestamp.finalized"), equalTo("true"));
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        Map<String, String> customData = indexMetadata(indexName).getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);  
                new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test_producer")  
        assertThat(customData.get("fields.event.ingested.min"), equalTo("300"));
        );
import static org.hamcrest.Matchers.notNullValue;  
import org.opensearch.core.index.Index;
        assertThat(customData, notNullValue());
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
            )
                new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer"),
 *
import java.util.List;
        String indexName = "logs-000001";
import static org.hamcrest.Matchers.equalTo;
 */  
import org.opensearch.index.fielddomain.DateRangeFieldDomain;  
        assertThat(customData.get("fields.event.ingested.source"), equalTo("test_producer"));
        ensureGreen(indexName);  
import org.opensearch.test.OpenSearchIntegTestCase;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomains(  
import java.util.Map;
            List.of(
        assertAcked(prepareCreate(indexName).setMapping("@timestamp", "type=date", "event.ingested", "type=date"));
        return client().admin().cluster().prepareState().clear().setMetadata(true).get().getState().metadata().index(indexName);  
public class PutIndexFieldDomainsIT extends OpenSearchIntegTestCase {
    }
    private IndexMetadata indexMetadata(String indexName) {
        assertThat(customData.get("fields.event.ingested.max"), equalTo("400"));  
        assertThat(customData.get("fields.@timestamp.source"), equalTo("test_producer"));  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        assertThat(customData.get("fields.@timestamp.type"), equalTo("date_range"));
/*  
package org.opensearch.action.admin.indices.fielddomain;
    }  
