gRPC (Google Remote Procedure Call)


gRPC uses HTTP/2 and serializes data using Protocol Buffers (binary format), making it much faster and more bandwidth-efficient than REST. It supports streaming (client, server, and bidirectional). It requires both sides to share the same .proto schema file.
Use gRPC when:

Building internal microservice-to-microservice communication
Low latency and high throughput are critical
You need real-time streaming (e.g. live location, chat)
Strong type safety and schema contracts are important