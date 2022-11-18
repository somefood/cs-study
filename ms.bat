@echo off
set IMAGE_NAME=sql-db-images
set CONTAINER_NAME=starters_db
set SET_SQL_PATH=/etc/mysql/setDB/sample.sql
set SET_BOOK_PATH=/etc/mysql/setDB/sample.dump
set SET_SQL_DELAY=15
set DB_ROOT_UID=root
set DB_ROOT_PASSWORD=starters12
echo.
echo.
echo [RUN] 1. Remove Container '%CONTAINER_NAME%'
echo.
docker stop %CONTAINER_NAME%
docker rm %CONTAINER_NAME%
docker rmi %IMAGE_NAME%
echo.
echo [RUN] 2. Run Container
echo.
docker build . -t %IMAGE_NAME%
docker run -d -p 3306:3306 --name %CONTAINER_NAME% %IMAGE_NAME% --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
echo.
echo [RUN] 3. Set DB
echo Wait for %SET_SQL_DELAY% second
timeout %SET_SQL_DELAY%
echo.
docker exec %CONTAINER_NAME% sh -c "mysql -u%DB_ROOT_UID% -p%DB_ROOT_PASSWORD% < %SET_SQL_PATH%"
docker exec %CONTAINER_NAME% sh -c "mysql -u%DB_ROOT_UID% -p%DB_ROOT_PASSWORD% < %SET_BOOK_PATH%"
echo.
echo [RUN COMPLETE]
echo.
echo.
pause