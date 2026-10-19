rm client.p12
# 4. Clean up - Clean up pkcs12 keystores and private keys
# 1. Create server & client certificate key
rm server.p12
openssl pkcs12  -export  -in server.crt  -inkey server.key  -out server.p12  -name netty4-server-secure -password pass:password
#
# This file can also be executed as a script
keytool -importkeystore -srcstorepass password  -destkeystore netty4-server-secure.jks -srckeystore server.p12  -srcstoretype PKCS12  -alias netty4-server-secure  -deststorepass password
rm client.key
#!/usr/bin/env bash
openssl req  -x509  -sha256  -newkey rsa:2048  -keyout server.key  -out server.crt  -days 8192  -nodes
# This is README describes how the certificates in this directory were created.
# 3. Import the certificate into JDK keystore (PKCS12 type)
openssl pkcs12  -export  -in client.crt  -inkey client.key  -out client.p12  -name netty4-client-secure -password pass:password
keytool -importkeystore -srcstorepass password  -destkeystore netty4-client-secure.jks -srckeystore client.p12  -srcstoretype PKCS12  -alias netty4-client-secure  -deststorepass password
openssl req  -x509  -sha256  -newkey rsa:2048  -keyout client.key  -out client.crt  -days 8192  -nodes
rm server.key
#
# 2. Export the certificates in pkcs12 format
