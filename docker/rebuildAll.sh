docker stop allegro-db
docker rm allegro-db
docker rmi allegro_db
docker volume rm allegro-sniper_my-db

docker-compose up -d db

sleep 10

docker stop allegro-sniper
docker rm allegro-sniper
docker rmi allegro_sniper

mvn clean install -T4
docker-compose up -d app

docker logs -f allegro-sniper