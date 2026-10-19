 *
            try (StreamInput in = out.bytes().streamInput()) {  
 * license agreements. See the NOTICE file distributed with
        this.reader = reader;
 */  
 * Licensed to Elasticsearch under one or more contributor  
    /**
    /**
    public AbstractWriteableEnumTestCase(Writeable.Reader<?> reader) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void assertReadFromStream(final int ordinal, final Writeable expected) throws IOException {
     * Test that the ordinals for the enum are consistent (i.e. the order hasn't changed)  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    public abstract void testFromString();
     * Test that the conversion from a string to enum is correct.  
                assertThat(reader.read(in), equalTo(expected));
 * You may obtain a copy of the License at  
/*  
 * KIND, either express or implied.  See the License for the
            writeableEnum.writeTo(out);
            }  
 * compatible open source license.
 * specific language governing permissions and limitations
/**
        }
    /**  
        }  
    public abstract void testValidOrdinals();  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
     */
/*  
 * The OpenSearch Contributors require contributions made to  
            out.writeVInt(ordinal);  
     * Test that the correct enum value is produced from the serialized value in the {@link StreamInput}.
     * because writing an enum to a stream often uses the ordinal value.
/*
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;  
 * GitHub history for details.
 */  
}  
                assertThat(in.readVInt(), equalTo(ordinal));
     */
            try (StreamInput in = out.bytes().streamInput()) {
    /**
    }  
    // a convenience method for testing the read of a writeable enum  
import org.opensearch.core.common.io.stream.Writeable;  
 * Unless required by applicable law or agreed to in writing,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * under the License.  
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public abstract void testWriteTo() throws IOException;  
 * ownership. Elasticsearch licenses this file to you under  
public abstract class AbstractWriteableEnumTestCase extends OpenSearchTestCase {
import org.opensearch.core.common.io.stream.StreamInput;
    protected static void assertWriteToStream(final Writeable writeableEnum, final int ordinal) throws IOException {  
    }
 */  
package org.opensearch.common.io.stream;
 */
    private final Writeable.Reader<?> reader;
    // a convenience method for testing the write of a writeable enum
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
     */  
    }
 *  
     * Test that the correct serialized value is produced from the {@link StreamOutput}.
 *
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
 * Abstract class offering base functionality for testing @{link Writeable} enums.
import org.opensearch.test.OpenSearchTestCase;
    public abstract void testReadFrom() throws IOException;
