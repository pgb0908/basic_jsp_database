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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author Tmax 오라클 데이터 베이스에 연결하고 select, insert, update, delete 작업을 실행해주는 클래스
 */
public class MemberDAO {

    // 오라클에 접속하는 소스를 작성
    String id = "system";
    String pass = "123456";
    String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 접속 url

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    // 데이터베이스에 접근할 수 있도록 도와주는 메소드 작성
    public void getCon() {
        try {
            // 1.해당 데이터베이스를 사용한다고 선언 (클래스를 등록=오라클용을 사용)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2.해당 데이터 베이스에 접속
            con = DriverManager.getConnection(url, id, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 데이터베이스에 한 사람의 회원 정보를 저장해주는 메소드
    public void insertMember(MemberBean mbean) {
        try {
            getCon();

            // 3. 접속 후 쿼리 준비하여 쿼리를 사용하도록 설정
            String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mbean.getId());
            pstmt.setString(2, mbean.getPass1());
            pstmt.setString(3, mbean.getEmail());
            pstmt.setString(4, mbean.getTel());
            pstmt.setString(5, mbean.getHobby());
            pstmt.setString(6, mbean.getJob());
            pstmt.setString(7, mbean.getAge());
            pstmt.setString(8, mbean.getInfo());

            // 4. 오라클에서 쿼리를 실행하시오
            pstmt.executeUpdate();

            // 5. 자원반남
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<MemberBean> allSelectMember() {

        Vector<MemberBean> v = new Vector();

        try {
            getCon();

            // 쿼리 준비
            String sql = "select * from member";
            // 쿼리를 실행시켜주는 객체 선언
            pstmt = con.prepareStatement(sql);
            // 쿼리를 실행 시킨 결과를 리턴해서 받아줌(오라클 테이블의 검색된 결과를 자바객체에 저장)
            rs = pstmt.executeQuery();

        }catch(Exception e) {

        }

        return v;

    }
}
