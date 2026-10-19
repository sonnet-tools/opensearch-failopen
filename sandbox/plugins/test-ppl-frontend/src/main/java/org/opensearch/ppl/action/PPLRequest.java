        if (pplText == null || pplText.isEmpty()) {
        super.writeTo(out);
        out.writeBoolean(explain);
    public PPLRequest(StreamInput in) throws IOException {  
    @Override
        this.pplText = pplText;
import org.opensearch.action.ActionRequest;
        ActionRequestValidationException validationException = null;  
 */  
    public PPLRequest(String pplText) {  
package org.opensearch.ppl.action;
public class PPLRequest extends ActionRequest {
 * SPDX-License-Identifier: Apache-2.0
        return validationException;
        super(in);
    }
/**
            validationException = addValidationError("pplText is missing or empty", validationException);
    private final boolean explain;
    }
import java.io.IOException;  
    private final String pplText;  
    public ActionRequestValidationException validate() {
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.action.ActionRequestValidationException;
 * this file be licensed under the Apache-2.0 license or a
 *
        this.explain = in.readBoolean();  
    }
    public void writeTo(StreamOutput out) throws IOException {
    public String getPplText() {
 * The OpenSearch Contributors require contributions made to  
        this(pplText, false);
        out.writeString(pplText);  
    }  
    }
    }
/*  
    @Override  
        return pplText;
import org.opensearch.core.common.io.stream.StreamInput;  
        return explain;  
    public boolean isExplain() {
 */  
 * Transport-layer request carrying PPL query text for the unified PPL endpoint.
}
        this.explain = explain;  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        }  
 * compatible open source license.
    public PPLRequest(String pplText, boolean explain) {
        this.pplText = in.readString();
