    public void writeTo(StreamOutput out) throws IOException {
    @Override  
    public List<ProfileResult> getFetchProfileResults() {  
        return new FetchProfileShardResult(results);  
import org.opensearch.core.common.io.stream.Writeable;
            p.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;  
 */
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentFragment;
    public static FetchProfileShardResult fromXContent(XContentParser parser) throws IOException {  
        }
    }
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
        for (ProfileResult p : fetchProfileResults) {
        out.writeVInt(fetchProfileResults.size());  
        return fetchProfileResults;
/*  
        builder.startArray(FETCH);
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.Collections;  
}
import java.util.ArrayList;
        List<ProfileResult> tmp = new ArrayList<>(profileSize);
import org.opensearch.core.xcontent.XContentBuilder;  
    }
 * compatible open source license.
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
import org.opensearch.core.xcontent.XContentParser;
        return builder.endArray();  
 * Represents the fetch phase profile results for a single shard.  
import org.opensearch.core.common.io.stream.StreamInput;
            results.add(ProfileResult.fromXContent(parser));
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
public class FetchProfileShardResult implements Writeable, ToXContentFragment {  
        for (ProfileResult p : fetchProfileResults) {  
package org.opensearch.search.profile.fetch;
import java.io.IOException;
            tmp.add(new ProfileResult(in));
        List<ProfileResult> results = new ArrayList<>();
 *
        int profileSize = in.readVInt();
        ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.currentToken(), parser);
import org.opensearch.search.profile.ProfileResult;
    }
    }
        }  
        }
@ExperimentalApi()
    public static final String FETCH = "fetch";
 * this file be licensed under the Apache-2.0 license or a
/**
    private final List<ProfileResult> fetchProfileResults;  
            p.toXContent(builder, params);
import org.opensearch.common.annotation.ExperimentalApi;
    @Override
 */  
    }
        for (int j = 0; j < profileSize; j++) {  
    public FetchProfileShardResult(StreamInput in) throws IOException {  
        this.fetchProfileResults = Collections.unmodifiableList(tmp);  
        this.fetchProfileResults = Collections.unmodifiableList(results);  
        }
    public FetchProfileShardResult(List<ProfileResult> results) {
