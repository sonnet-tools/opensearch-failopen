        DateRangeFieldDomain domain = new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test");
        );  
                new PutIndexFieldDomainsClusterStateUpdateRequest().targetIndex(new Index("logs-000001", "index-uuid"))
    private static final IndexFieldDomainMetadata FIELD_DOMAIN_METADATA = IndexFieldDomainMetadata.getInstance();
        assertThat(exception.getCause().getMessage(), containsString("expected: [expected-uuid]"));
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        assertSame(state, updated);
import org.opensearch.index.IndexNotFoundException;
    public void testApplyFieldDomainsPublishesMetadata() {  
        }
        if (customData.isEmpty() == false) {  
            .numberOfShards(1)
        );
 * compatible open source license.
    public void testApplyFieldDomainsReturnsSameStateWhenMetadataIsUnchanged() {
            .numberOfReplicas(0);
            )  
        Map<String, String> customData = updated.metadata().index("logs-000001").getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);
                    .build()
                Settings.builder()
import org.opensearch.cluster.ClusterState;
    private static ClusterState clusterState(IndexMetadata indexMetadata) {
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
import java.util.HashMap;  
import static org.hamcrest.Matchers.containsString;  
        ClusterState state = clusterState(indexMetadata("logs-000001", "index-uuid", existing));
                state,
 * The OpenSearch Contributors require contributions made to  
        assertThat(customData.get("fields.host.name.value"), equalTo("server-a"));
        assertThat(exception.getMessage(), equalTo("field domain metadata is required"));
    public void testApplyFieldDomainsFailsOnMissingMetadata() {  
        ClusterState state = clusterState(indexMetadata("logs-000001", "actual-uuid", Map.of()));
import java.util.Map;
        ClusterState updated = MetadataIndexFieldDomainService.applyFieldDomains(state, request("logs-000001", "index-uuid", domain));
        return new PutIndexFieldDomainsClusterStateUpdateRequest().targetIndex(new Index(index, indexUUID))  
    private static IndexMetadata indexMetadata(String index, String indexUUID, Map<String, String> customData) {
    }
    private static PutIndexFieldDomainsClusterStateUpdateRequest request(String index, String indexUUID, DateRangeFieldDomain domain) {
        assertNotNull(exception.getCause());
    public void testApplyFieldDomainsFailsOnIndexUUIDMismatch() {
    }
        ClusterState state = clusterState(indexMetadata("logs-000001", "index-uuid", FIELD_DOMAIN_METADATA.toCustomData(domain)));  
import org.opensearch.Version;
public class MetadataIndexFieldDomainServiceTests extends OpenSearchTestCase {  
                state,
        IndexNotFoundException exception = expectThrows(
                request("logs-000001", "expected-uuid", new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"))
        existing.put("fields.host.name.value", "server-a");  
                state,  
import org.opensearch.test.OpenSearchTestCase;
/*  
import org.opensearch.core.index.Index;  
        assertThat(exception.getMessage(), containsString("no such index [logs-000001]"));  
                request("logs-000001", "index-uuid", new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"))
            .settings(
            IllegalArgumentException.class,
        return builder.build();  
        Map<String, String> existing = new HashMap<>();
    }
 * this file be licensed under the Apache-2.0 license or a
            request("logs-000001", "index-uuid", new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"))
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    }
}
            state,
        return ClusterState.builder(ClusterName.DEFAULT).metadata(Metadata.builder().put(indexMetadata, false)).build();
            () -> MetadataIndexFieldDomainService.applyFieldDomains(  
            )  
import static org.hamcrest.Matchers.equalTo;
            IndexNotFoundException.class,
package org.opensearch.cluster.metadata;
            builder.putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, customData);
        assertThat(customData.get("fields.host.name.type"), equalTo("term_set"));  
 * SPDX-License-Identifier: Apache-2.0
            )
 *
    }  
        IndexMetadata.Builder builder = IndexMetadata.builder(index)  
        IllegalArgumentException exception = expectThrows(  
        assertThat(customData.get("fields.@timestamp.type"), equalTo("date_range"));  
    }
import org.opensearch.cluster.ClusterName;  
    }  
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));
            IndexNotFoundException.class,
        ClusterState state = clusterState(indexMetadata("logs-000001", "index-uuid", Map.of()));
            () -> MetadataIndexFieldDomainService.applyFieldDomains(  
import org.opensearch.common.settings.Settings;
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;  
        );
            () -> MetadataIndexFieldDomainService.applyFieldDomains(
import org.opensearch.action.admin.indices.fielddomain.PutIndexFieldDomainsClusterStateUpdateRequest;
            )  
                    .put(IndexMetadata.SETTING_INDEX_UUID, indexUUID)
        );  
    }
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).build();
            .fieldDomainCustomData(FIELD_DOMAIN_METADATA.toCustomData(domain));
    public void testApplyFieldDomainsFailsWhenIndexIsMissing() {
        expectThrows(
 */  
        ClusterState updated = MetadataIndexFieldDomainService.applyFieldDomains(  
        existing.put("fields.host.name.type", "term_set");
        assertThat(exception.getCause().getMessage(), containsString("got: [actual-uuid]"));  
