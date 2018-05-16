1.获取token  http://localhost:8180/auth
headers: Content-Type : application/json
Body: raw
    {
		"username":"scy",
		"password":"123456"
	}
response: text
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzY3kiLCJjcmVhdGVkIjoxNTI2NDM3NDA5ODk3LCJleHAiOjE1MjY0Mzc0Njl9.0qYeN8HseZQQMfbqZHGkvBW-GBV9RjJmf25crgwLJOQ

2.查询数据  http://localhost:8180/user/getUserAll?username=scy
headers: Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzY3kiLCJjcmVhdGVkIjoxNTI2MzY3MDUyNTAyLCJleHAiOjE1MjYzNjcxMTJ9.HWpsocu_ZZBivxMJu5_x7Q3xZzUetjqNdPqDv-PIS_U
response: json
{
    "content": [
        {
            "id": 6,
            "name": "NA",
            "password": "$2a$10$SmY2WeQn0sJnEW4U2hlBw.dgtZHB./hb3pw8c2cmCHP/10gnFWgz6",
            "username": "abc",
            "divisionId": 1,
            "sex": "女",
            "email": "shengchongyang@hotmail.com",
            "mobilephone": "",
            "telephone": "13512352345",
            "userType": 1,
            "createBy": "",
            "createTime": 1510554056000,
            "updateBy": "",
            "updateTime": 1510554056000,
            "lastPasswordResetDate": 1510554056000,
            "status": 1,
            "theme": "",
            "isLdap": 0,
            "roles": [
                {
                    "id": 2,
                    "name": "ROLE_USER"
                }
            ]
        },
        {
            "id": 5,
            "name": "NA",
            "password": "$2a$10$tyQmNjyNOnqQEDmh3uWGV.IeCI/4MGG3QL9fT6DA.1d/7/tQBHWDW",
            "username": "scy",
            "divisionId": 1,
            "sex": "男",
            "email": "shengchongyang@hotmail.com",
            "mobilephone": "",
            "telephone": "13512352345",
            "userType": 1,
            "createBy": "ߘ\u0082加到几点好的",
            "createTime": 1510550052000,
            "updateBy": "",
            "updateTime": 1510550052000,
            "lastPasswordResetDate": 1510550052000,
            "status": 1,
            "theme": "",
            "isLdap": 0,
            "roles": [
                {
                    "id": 1,
                    "name": "ROLE_SUPERADMIN"
                }
            ]
        }
    ],
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "number": 0,
    "size": 10,
    "sort": [
        {
            "direction": "DESC",
            "property": "id",
            "ignoreCase": false,
            "nullHandling": "NATIVE",
            "ascending": false
        }
    ],
    "first": true,
    "numberOfElements": 2
}

3.刷新token  http://localhost:8180/refresh 
headers: Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzY3kiLCJjcmVhdGVkIjoxNTI2MzY3MDUyNTAyLCJleHAiOjE1MjYzNjcxMTJ9.HWpsocu_ZZBivxMJu5_x7Q3xZzUetjqNdPqDv-PIS_U
response: text
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzY3kiLCJjcmVhdGVkIjoxNTI2MzY2NzczNjUyLCJleHAiOjE1MjYzNjY4MzN9.x3BreZN8x1VhAXVgmLjY7ogFXpPFh4c58Rt_I_Z_g5s
