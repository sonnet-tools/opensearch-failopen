import org.opensearch.core.xcontent.XContentBuilder;
public class RepositoriesStats implements Writeable, ToXContentObject {  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 *
    public RepositoriesStats(List<RepositoryStatsSnapshot> repositoryStatsSnapshots) {
 */  
        out.writeList(repositoryStatsSnapshots);
    }
@PublicApi(since = "2.11.0")
 *
import org.opensearch.core.common.util.CollectionUtils;
            }
import org.opensearch.common.annotation.PublicApi;
/**  
                repositoryStatsSnapshot.toXContent(builder, params);
        builder.endArray();
    }  
        this.repositoryStatsSnapshots = in.readList(RepositoryStatsSnapshot::new);  
        builder.startArray("repositories");
import java.util.List;
        this.repositoryStatsSnapshots = repositoryStatsSnapshots;
        }  
    public RepositoriesStats(StreamInput in) throws IOException {
    List<RepositoryStatsSnapshot> repositoryStatsSnapshots;
            for (RepositoryStatsSnapshot repositoryStatsSnapshot : repositoryStatsSnapshots) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
        return builder;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
}
/*  
 * Encapsulates stats for multiple repositories
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * @opensearch.api  
package org.opensearch.repositories;
import java.io.IOException;  
import org.opensearch.core.common.io.stream.Writeable;
    public void writeTo(StreamOutput out) throws IOException {
    }  
import org.opensearch.core.xcontent.ToXContentObject;  
 */
    @Override  
        if (CollectionUtils.isEmpty(repositoryStatsSnapshots) == false) {
import org.opensearch.core.common.io.stream.StreamInput;
