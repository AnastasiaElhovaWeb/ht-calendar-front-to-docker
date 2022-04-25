FROM node:latest
WORKDIR /usr/src/app/my-app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run-script build