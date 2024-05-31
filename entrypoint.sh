#!/bin/bash

echo "Waiting for Selenium Hub to be ready..."
while ! curl -s http://selenium-hub:4444/wd/hub/status | grep '"ready": true' > /dev/null; do
  echo "Waiting..."
  sleep 1

  if [ $((SECONDS)) -gt 60 ]; then
    echo "Timeout waiting for Selenium Hub."
    exit 1
  fi
done

echo "Selenium Hub is ready. Running Maven install..."

mvn clean install
