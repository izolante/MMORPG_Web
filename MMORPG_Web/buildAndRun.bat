@echo off
call mvn clean package
call docker build -t br.edu.ifsul/MMORPG_Web .
call docker rm -f MMORPG_Web
call docker run -d -p 9080:9080 -p 9443:9443 --name MMORPG_Web br.edu.ifsul/MMORPG_Web