build-docker:
	mvn spring-boot:build-image -Dspring-boot.build-image.imageName=ghpm99/kawori-bot
run:
	docker run -d --network="host" -e SPRING_PROFILES_ACTIVE='dev' --name kawori ghpm99/kawori-bot
stop:
	docker stop kawori
start:
	docker start kawori