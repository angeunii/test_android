package com.example.study_1;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest ;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{

    // 서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://10.0.2.2:80/try/hong_register.php";
    //php파일은 xampp/htdocs/try/hong_register.php 랑 hong_login.php 가 들어있고
    //데이터베이스명은 testaram에 user테이블로 들어가있음 데이터베이스는 홍드로이드 참고
    //한글로 회원가입 하려면 가상 디바이스에서 설정-언어 설정 들어가서 한국어 지정해야함
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userAge", userAge + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }



}
