# 1
FROM clojure
# 2
LABEL maintainer=""
# 3
COPY . /usr/src/app
# 4
WORKDIR /usr/src/app
# 5
EXPOSE 5678
# 6
CMD ["lein", "run"]