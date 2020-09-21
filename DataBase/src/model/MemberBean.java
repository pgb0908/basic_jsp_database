/*
 * Copyright 2020 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package model;

/**
 * @author Tmax
 *
 */
public class MemberBean {

    private String id;
    private String pass1;
    private String pass2;
    private String email;
    private String tel;
    private String hobby;
    private String job;
    private String age;
    private String info;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPass1() {
        return pass1;
    }
    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }
    public String getPass2() {
        return pass2;
    }
    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }



}
