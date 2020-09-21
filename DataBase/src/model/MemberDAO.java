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
 * @author Tmax ����Ŭ ������ ���̽��� �����ϰ� select, insert, update, delete �۾��� �������ִ� Ŭ����
 */
public class MemberDAO {

    // ����Ŭ�� �����ϴ� �ҽ��� �ۼ�
    String id = "system";
    String pass = "123456";
    String url = "jdbc:oracle:thin:@localhost:1521:XE"; // ���� url

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    // �����ͺ��̽��� ������ �� �ֵ��� �����ִ� �޼ҵ� �ۼ�
    public void getCon() {
        try {
            // 1.�ش� �����ͺ��̽��� ����Ѵٰ� ���� (Ŭ������ ���=����Ŭ���� ���)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2.�ش� ������ ���̽��� ����
            con = DriverManager.getConnection(url, id, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �����ͺ��̽��� �� ����� ȸ�� ������ �������ִ� �޼ҵ�
    public void insertMember(MemberBean mbean) {
        try {
            getCon();

            // 3. ���� �� ���� �غ��Ͽ� ������ ����ϵ��� ����
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

            // 4. ����Ŭ���� ������ �����Ͻÿ�
            pstmt.executeUpdate();

            // 5. �ڿ��ݳ�
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<MemberBean> allSelectMember() {

        Vector<MemberBean> v = new Vector();

        try {
            getCon();

            // ���� �غ�
            String sql = "select * from member";
            // ������ ��������ִ� ��ü ����
            pstmt = con.prepareStatement(sql);
            // ������ ���� ��Ų ����� �����ؼ� �޾���(����Ŭ ���̺��� �˻��� ����� �ڹٰ�ü�� ����)
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberBean bean = new MemberBean();
                bean.setId(rs.getString(1));
                bean.setPass1(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setTel(rs.getString(4));
                bean.setHobby(rs.getString(5));
                bean.setJob(rs.getString(6));
                bean.setAge(rs.getString(7));
                bean.setInfo(rs.getString(8));

                v.add(bean);
            }

            con.close();

        } catch (Exception e) {

        }

        return v;

    }

    public MemberBean oneSelectMember(String id) {

        MemberBean bean = new MemberBean();

        try {
            getCon();

            String sql = "select * from member where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                bean.setId(rs.getString(1));
                bean.setPass1(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setTel(rs.getString(4));
                bean.setHobby(rs.getString(5));
                bean.setJob(rs.getString(6));
                bean.setAge(rs.getString(7));
                bean.setInfo(rs.getString(8));
            }

            con.close();

        } catch (Exception e) {

        }

        return bean;
    }


    public String getPass(String id) {
        String pass = "";

        try {
            getCon();

            String sql = "select pass1 from member where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pass = rs.getString(1);
            }

            con.close();
        }catch(Exception e) {

        }


        return pass;
    }

    public void updateMember(MemberBean bean) {
        getCon();

        try {
            String sql = "update member set email=?,tel=? where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bean.getEmail());
            //System.out.println(bean.getEmail());
            pstmt.setString(2, bean.getTel());
            pstmt.setString(3, bean.getId());
            //System.out.println(bean.getId());

            pstmt.executeUpdate();

            con.close();
        } catch (Exception e) {

        }
    }

    public void deleteMember(String id) {
        getCon();

        try {
            String sql = "delete from member where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            pstmt.executeUpdate();

            con.close();
        } catch(Exception e) {

        }
    }
}
