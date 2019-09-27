PRONY: build

# Maven steps
_clean:
	./mvnw clean

build:
	./mvnw clean install

# Infra
infra:
	docker run --rm --name locking-postgres\
	 -p 5432:5432\
	 -e POSTGRES_USER=locking-user\
	 -e POSTGRES_PASSWORD=locking-password\
	 -e POSTGRES_DB=locking-db\
	 -d postgres:9.6-alpine

	docker run --rm --name locking-redis\
	 -p 6379:6379\
	 -d redis:5.0.6-alpine

infra-stop:
	docker container stop locking-postgres locking-redis

# Docker steps
run-app: _clean
	docker-compose up --build -d

stop-app:
	docker-compose down
