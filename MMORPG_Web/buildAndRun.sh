#!/bin/sh
mvn clean package && docker build -t br.edu.ifsul/MMORPG_Web .
docker rm -f MMORPG_Web || true && docker run -d -p 9080:9080 -p 9443:9443 --name MMORPG_Web br.edu.ifsul/MMORPG_Web