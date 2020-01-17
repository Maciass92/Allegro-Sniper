docker stop allegro-sniper
docker rm allegro-sniper
docker rmi allegro_sniper

mvn clean install -T4
docker-compose up -d app

docker logs -f allegro-sniper