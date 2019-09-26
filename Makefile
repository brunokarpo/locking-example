PRONY: build

# Maven steps
_clean:
	./mvnw clean

build:
	./mvnw clean install

# Docker steps
run-app: _clean
	docker-compose up --build -d

stop-app:
	docker-compose down
