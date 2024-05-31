# Use the official Ubuntu image
FROM ubuntu:20.04

# Install necessary tools
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    maven \
    curl \
    unzip \
    wget

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Copy the entrypoint script
COPY entrypoint.sh /app/entrypoint.sh

# Make the entrypoint script executable
RUN chmod +x /app/entrypoint.sh

# Run the entrypoint script
ENTRYPOINT ["/app/entrypoint.sh"]
