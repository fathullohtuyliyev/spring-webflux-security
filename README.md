Spring Webflux Security-dan foydalangan holda o'quv loyihasi
================================


## Quyidagi texnologiyalardan foydalangan holda dastur yaratish bosqichlari :
 - Spring Boot 3
 - Spring Security (JWT)
 - Spring WebFlux
 - Spring Data R2DBC
 - MapStruct
 - PostgreSQL
 - Flyway


## Ilovani lokal  sifatida ishga tushirish
- PostgreSQL-ni o'rnating

## Ma'lumotlar bazasini yaratish
```sql
CREATE DATABASE "webflux_security";
```

## To'g'ri qiymatlarni o'rnating application.yaml
```sql
spring:r2dbc:username
```

```sql
spring:r2dbc:password
```

# cURL so'rovlar:

## 1. Foydalanuvchini ro'yxatdan o'tkazish
```bash
curl --location 'http://localhost:8083/api/v1/auth/register' \
--header 'Content-Type: application/json' \
--data '{
    "username": "jpro",
    "password": "test",
    "first_name": "Fathullo",
    "last_name": "Tuyliyev"
}'
```

Javob namunasi:
```json
{
  "id": 1,
  "username": "proselyte",
  "role": "USER",
  "first_name": "Fathullo",
  "last_name": "Tuyliyev",
  "enabled": true,
  "created_at": "2023-05-13T14:53:32.36094",
  "updated_at": "2023-05-13T14:53:32.360954"
}
```

## 2. Foydalanuvchi autentifikatsiyasi
```bash
curl --location 'http://localhost:8083/api/v1/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "jpro",
    "password": "test"
  }'
```

Javob namunasi:
```json
{
  "user_id": 1,
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Iiwicm9sZSI6IlVTRVIiLCJpc3MiOiJwcm9zZWx5dGUiLCJleHAiOjE2ODM5ODI0MzYsImlhdCI6MTY4Mzk3ODgzNiwianRpIjoiZjlmZDliMjYtN2UyOC00Y2QzLWIzY2MtOWM3MjdmNTdkNTliIiwidXNlcm5hbWUiOiJwcm9zZWx5dGUifQ.8gdTqi18le0h4GTAd_JnxTDybnDFQS03biRnMbRRpQQ",
  "issued_at": "2023-05-13T11:53:56.390+00:00",
  "expires_at": "2023-05-13T12:53:56.390+00:00"
}
```

## 3. Oldingi so'rovda olingan token yordamida foydalanuvchi ma'lumotlarini olish

```bash
curl --location 'http://localhost:8083/api/v1/auth/info' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Iiwicm9sZSI6IlVTRVIiLCJpc3MiOiJwcm9zZWx5dGUiLCJleHAiOjE2ODM5ODI0MzYsImlhdCI6MTY4Mzk3ODgzNiwianRpIjoiZjlmZDliMjYtN2UyOC00Y2QzLWIzY2MtOWM3MjdmNTdkNTliIiwidXNlcm5hbWUiOiJwcm9zZWx5dGUifQ.8gdTqi18le0h4GTAd_JnxTDybnDFQS03biRnMbRRpQQ'
```

Javob namunasi:
```json
{
  "id": 1,
  "username": "proselyte",
  "role": "USER",
  "first_name": "Fathullo",
  "last_name": "Tuyliyev",
  "enabled": true,
  "created_at": "2023-05-13T14:02:37.248466",
  "updated_at": "2023-05-13T14:02:37.248482"
}
```

Ishingizga omad !!!
