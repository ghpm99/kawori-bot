build-docker:
	mvn spring-boot:build-image -Dspring-boot.build-image.imageName=ghpm99/kawori-bot
run:
	mvn spring-boot:run -Dspring-boot.run.profiles=dev
stop:
	docker stop kawori
start:
	docker start kawori