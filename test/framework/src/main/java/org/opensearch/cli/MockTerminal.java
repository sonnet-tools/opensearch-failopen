    public void addSecretInput(String input) {
/*  
        textIndex = 0;
        super("\n"); // always *nix newlines for tests  
        if (secretIndex >= secretInput.size()) {
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
    public void addTextInput(String input) {  
    public MockTerminal() {
    private int textIndex = 0;
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    // and keep track of the last position which was read. It means that we will hold onto all input  
 * can be plugged with fake input.
    /** Adds an an input that will be return from {@link #readSecret(String)}. Values are read in FIFO order. */
 * specific language governing permissions and limitations
import java.nio.charset.StandardCharsets;
    // to support the valid return value of readText being null (defined by Console), we need to be able  
 */  
    }
        }
 * KIND, either express or implied.  See the License for the
import java.io.ByteArrayOutputStream;
    }
    private int secretIndex = 0;  
 */
    @Override  
    private final PrintWriter writer = new PrintWriter(new OutputStreamWriter(stdoutBuffer, StandardCharsets.UTF_8));
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final List<String> textInput = new ArrayList<>();  
import java.io.PrintWriter;  
        return stdoutBuffer.toString("UTF-8");
    public PrintWriter getErrorWriter() {
 * the Apache License, Version 2.0 (the "License"); you may
    public char[] readSecret(String prompt) {  
    /** Returns all output written to this terminal. */  
        }  
 * software distributed under the License is distributed on an
    // to store nulls. However, java the java Deque api does not allow nulls because it uses null as
    private final List<String> secretInput = new ArrayList<>();
/*
 * The OpenSearch Contributors require contributions made to  
    }  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    public String readText(String prompt) {
 * not use this file except in compliance with the License.
    @Override
}
 * under the License.  
 *
    public String getOutput() throws UnsupportedEncodingException {
            throw new IllegalStateException("No secret input configured for prompt [" + prompt + "]");
        stdoutBuffer.reset();  
    }
            throw new IllegalStateException("No text input configured for prompt [" + prompt + "]");  
    @Override  
    public String getErrorOutput() throws UnsupportedEncodingException {  
        secretInput.clear();
        return secretInput.get(secretIndex++).toCharArray();
 * this file be licensed under the Apache-2.0 license or a
import java.io.OutputStreamWriter;
    private final ByteArrayOutputStream stderrBuffer = new ByteArrayOutputStream();
        textInput.clear();  
import java.util.List;
    private final PrintWriter errorWriter = new PrintWriter(new OutputStreamWriter(stderrBuffer, StandardCharsets.UTF_8));  
 * license agreements. See the NOTICE file distributed with
 */  
        secretInput.add(input);  
 * A terminal for tests which captures all output, and
 */  
        textInput.add(input);
import java.io.UnsupportedEncodingException;
 * this work for additional information regarding copyright
    /** Wipes the input and output. */
    public PrintWriter getWriter() {
import java.util.ArrayList;  
    public void reset() {
 * compatible open source license.
    /** Adds an an input that will be return from {@link #readText(String)}. Values are read in FIFO order. */
    // A deque would be a perfect data structure for the FIFO queue of input values needed here. However,
 *  
/**  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.cli;
    }  
    // a special return value from certain methods like peek(). So instead of deque, we use an array list here,
        if (textIndex >= textInput.size()) {
        stderrBuffer.reset();
    }
        return stderrBuffer.toString("UTF-8");
 * Modifications Copyright OpenSearch Contributors. See
    // so in reality it will not matter.
    }
public class MockTerminal extends Terminal {
        return errorWriter;
        secretIndex = 0;
 *
        return textInput.get(textIndex++);
    private final ByteArrayOutputStream stdoutBuffer = new ByteArrayOutputStream();  
        return writer;  
    // setup for the mock terminal during its lifetime, but this is normally a very small amount of data
    /** Returns all output written to this terminal. */
 * GitHub history for details.
