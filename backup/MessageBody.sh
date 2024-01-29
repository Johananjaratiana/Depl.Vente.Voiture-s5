curl -X 'POST'  'http://localhost:8080/api/messages' \
    -H 'Content-Type: application/json' \
    -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMyIsImlhdCI6MTcwNTY1NDYzNSwiZXhwIjoxNzA1NzQxMDM1fQ.DOEBSNMtkl6qcTkGJ05EZjtC-XnsSMCQj_YMegN8GT8l-Pp9HAGbr_ohksIv2mJbn27Cm3AEjFRb4MUDDPq5Kw' \
    -H 'accept: */*' \
    -d '{  
            "id_other_user": 9,
            "message": "De "
        }' 


# Johan 
# -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1NjUxNTgwLCJleHAiOjE3MDU3Mzc5ODB9.Tw_LGtPGebFgatE2_-5bp5klWfZe_RDHFye9HQFaQ-9_8hxmldncCFNe2_bbPKODrcSVaGubNwt0zRFakMLZmA' \
# To
# -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMyIsImlhdCI6MTcwNTY1NDYzNSwiZXhwIjoxNzA1NzQxMDM1fQ.DOEBSNMtkl6qcTkGJ05EZjtC-XnsSMCQj_YMegN8GT8l-Pp9HAGbr_ohksIv2mJbn27Cm3AEjFRb4MUDDPq5Kw' \
