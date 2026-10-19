        return pingSucceeded;
        if (sendOpenSearchPing()) {  
            logger.debug("Closing DualSSL check client socket for {}", host);
        }
        this.overriddenSocket = overriddenSocket;
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/util/SSLConnectionTestUtil.java">SSLConnectionTestUtil</a>
                        logger.error("Received unexpected byte in OpenSearch Ping reply from {}", host);
         * OpenSearch Ping to the server failed.
 * Following that a custom client hello message will be sent to the server, if the server
        this.testOutputStreamWriter = testOutputStreamWriter;
            OutputStream outputStream = socket.getOutputStream();  
            outputStream.flush();
            OutputStreamWriter outputStreamWriter;
import java.io.IOException;
        Socket socket = null;  
            outputStreamWriter.flush();
         * Server does not support SSL.  
            outputStreamWriter.write(DUAL_MODE_CLIENT_HELLO_MSG);  
    }
                outputStreamWriter = testOutputStreamWriter;  
        /**
        /**
    /**  
            while ((currentChar = inputStreamReader.read()) != -1) {  
                try {
                    if (response[i] != OPENSEARCH_PING_MSG[i]) {  
    public SSLConnectionTestResult testConnection() {
import java.io.InputStreamReader;  
 *  
        final InputStreamReader testInputStreamReader
                        // Unexpected byte in response
                byteBufIndex++;  
    private InputStreamReader testInputStreamReader = null;
                        e.getMessage()
            if (byteBufIndex == 6) {
    }
        } catch (IOException e) {
        boolean dualSslSupported = false;
            }  
import org.apache.logging.log4j.Logger;
        }
        logger.debug("dualSslClient check with server {}, server supports ssl = {}", host, dualSslSupported);  
         */
     *
            return SSLConnectionTestResult.SSL_AVAILABLE;  
            }  
        (byte) 0xFF,
}  
        this.testInputStreamReader = testInputStreamReader;  
    private boolean sendOpenSearchPing() {
            return SSLConnectionTestResult.SSL_NOT_AVAILABLE;
            byte[] response = new byte[6];  
class SecureConnectionTestUtil {  
        (byte) 'E',
                        "Exception occurred while closing DualSSL check client socket for {}. Exception: {}",
            StringBuilder sb = new StringBuilder();
        final OutputStreamWriter testOutputStreamWriter,
import org.apache.logging.log4j.LogManager;
import java.net.InetAddress;  
            }
        try {
                pingSucceeded = true;
 *
        this.port = port;  
            logger.debug("Sending OpenSearch Ping to {}", host);  
                try {
            if (socket != null) {  
        final String host,
    }
        }
 * side has OpenSearchPortUnificationHandler it will reply with server hello message.
            int currentChar;
                sb.append((char) currentChar);
     * Return codes for SSLConnectionTestUtil.testConnection()
            if (overriddenSocket != null) {
                }  
    public SecureConnectionTestUtil(final String host, final int port) {
 * this file be licensed under the Apache-2.0 license or a
 *  
 * compatible open source license.
    }
            InputStreamReader inputStreamReader;  
        } catch (IOException ex) {
                }
                for (int i = 0; i < 6; i++) {
            InputStream inputStream = socket.getInputStream();
                        break;
 */
            socket.setSoTimeout(SOCKET_TIMEOUT_MILLIS);
     */
        if (sendDualSSLClientHello()) {
        return dualSslSupported;
    private Socket overriddenSocket = null;  
            logger.debug("Closing OpenSearch Ping client socket for connection to {}", host);
        logger.debug("OpenSearch Ping check to server {} result = {}", host, pingSucceeded);  
                logger.debug("Received reply for OpenSearch Ping. from {}", host);  
            if (socket != null) {  
     * - Send OpenSearch Ping to check if the server replies to the OpenSearch Ping message  
            logger.debug("DualSSL client check failed for {}, exception {}", host, e.getMessage());  
                inputStreamReader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
 * GitHub history for details.
            int byteBufIndex = 0;
import java.io.OutputStreamWriter;
                response[byteBufIndex] = (byte) currentByte;
        this.host = host;
        this.host = host;
/*  
                socket = overriddenSocket;
        SSL_NOT_AVAILABLE,
        final Socket overriddenSocket,  
    public static final String DUAL_MODE_SERVER_HELLO_MSG = "DUALSM";
    ) {  
import java.io.OutputStream;
        (byte) 0xFF };  
                inputStreamReader = testInputStreamReader;
        this.port = port;  
    private static final Logger logger = LogManager.getLogger(SecureConnectionTestUtil.class);
 * SSL Check will be done by sending an OpenSearch Ping to see if server is replying to pings.  
        /**  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
                    socket.close();
        return SSLConnectionTestResult.OPENSEARCH_PING_FAILED;
     * - Send Client Hello to check if the server replies with Server Hello which indicates that Server understands SSL
    private boolean sendDualSSLClientHello() {
                } catch (IOException e) {  
    private OutputStreamWriter testOutputStreamWriter = null;
        (byte) 0xFF,
     */  
 */  
                    }
            if (overriddenSocket != null) {
            if (sb.toString().equals(DUAL_MODE_SERVER_HELLO_MSG)) {
    protected SecureConnectionTestUtil(  
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            while ((byteBufIndex < 6) && ((currentByte = inputStream.read()) != -1)) {
        OPENSEARCH_PING_FAILED,
            }
                    );
        boolean pingSucceeded = false;
/**
            }
        SSL_AVAILABLE  
        final int port,
package org.opensearch.transport.netty4.ssl;
    }
                logger.debug("Received DualSSL Server Hello msg from {}", host);
import java.io.InputStream;
        }
     * @return SSLConnectionTestResult i.e. OPENSEARCH_PING_FAILED or SSL_NOT_AVAILABLE or SSL_AVAILABLE
                socket = new Socket(InetAddress.getByName(host), port);
            } else {
            socket.setSoTimeout(SOCKET_TIMEOUT_MILLIS);
import java.net.Socket;
    private final int port;
                        pingSucceeded = false;  
    /**  
     * Test connection to server by performing the below steps:
                    logger.error("Exception occurred while closing socket for {}. Exception: {}", host, e.getMessage());
    private final String host;
    enum SSLConnectionTestResult {  
            }  
                }  
        (byte) 'S',
                socket = overriddenSocket;  
    private static final int SOCKET_TIMEOUT_MILLIS = 10 * 1000;  
                    socket.close();
            logger.error("OpenSearch Ping failed for {}, exception: {}", host, ex.getMessage());  
            }
         */  
    }
    public static final byte[] OPENSEARCH_PING_MSG = new byte[] {  
 * Utility class to test if the server supports SSL connections.
                dualSslSupported = true;  
                        host,  
        Socket socket = null;  
            int currentByte;
                } catch (IOException e) {  
            } else {
    public static final String DUAL_MODE_CLIENT_HELLO_MSG = "DUALCM";
        } finally {
         * Server supports SSL.
                    logger.error(
import java.nio.charset.StandardCharsets;
            outputStream.write(OPENSEARCH_PING_MSG);
                socket = new Socket(InetAddress.getByName(host), port);  
 * The OpenSearch Contributors require contributions made to  
            }
        try {
         */
        } finally {
            logger.debug("Sent DualSSL Client Hello msg to {}", host);
        (byte) 0xFF,  
