package com.ata.member.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.ata.member.beans.UserAccount;
import com.ata.member.beans.MemberList;
 
public class DBUtils {
 
  public static UserAccount findUser(Connection conn, String userName, String userPassword) throws SQLException {
 
      String sql = "Select USER_NAME, USER_PASSWORD from user_account "
              + " where USER_NAME = ? and USER_PASSWORD= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, userPassword);
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {         
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setUserPassword(userPassword);          
          return user;
      }
      return null;
  }
 
  public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
      String sql = "Select USER_NAME, USER_PASSWORD from user_account " + " where USER_NAME = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          String userPassword = rs.getString("USER_PASSWORD");          
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setUserPassword(userPassword);          
          return user;
      }
      return null;
  }
 
  public static List<MemberList> queryMemberList(Connection conn) throws SQLException {
      String sql = "Select MEMBER_ID, MEMBER_NAME, GENDER, AGE, CAREER, WORKING_AT from member_list";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<MemberList> list = new ArrayList<MemberList>();
      while (rs.next()) {
          int memberId = rs.getInt("MEMBER_ID");
          String memberName = rs.getString("MEMBER_NAME");
          String gender = rs.getString("GENDER");
          int age = rs.getInt("AGE");
          String career = rs.getString("CAREER");
          String workingAt = rs.getString("WORKING_AT");          
          
          MemberList memberList = new MemberList();
          memberList.setMemberId(memberId);
          memberList.setMemberName(memberName);
          memberList.setGender(gender);
          memberList.setAge(age);
          memberList.setCareer(career);
          memberList.setWorkingAt(workingAt);
          list.add(memberList);
      }
      return list;
  }
 
  public static MemberList findMember(Connection conn, String code) throws SQLException {
      String sql = "Select MEMBER_ID, MEMBER_NAME, GENDER, AGE, CAREER, WORKING_AT from member_list where MEMBER_ID=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, code);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          int memberId = rs.getInt("MEMBER_ID");
          String memberName = rs.getString("MEMBER_NAME");
          String gender = rs.getString("GENDER");
          int age = rs.getInt("AGE");
          String career = rs.getString("CAREER");
          String workingAt = rs.getString("WORKING_AT");          
          
          MemberList memberList = new MemberList();
          memberList.setMemberId(memberId);
          memberList.setMemberName(memberName);
          memberList.setGender(gender);
          memberList.setAge(age);
          memberList.setCareer(career);
          memberList.setWorkingAt(workingAt);
          
          return memberList;
      }
      return null;
  }
 
  public static void updateMember(Connection conn, MemberList memberList) throws SQLException {
      String sql = "Update member_list set MEMBER_NAME =?, GENDER=?, AGE=?, CAREER=?, WORKING_AT=? where MEMBER_ID=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, memberList.getMemberNamer());
      pstm.setString(2, memberList.getGender());
      pstm.setInt(3, memberList.getAge());
      pstm.setString(4, memberList.getCareer());
      pstm.setString(5, memberList.getWorkingAt());
      pstm.executeUpdate();
  }
 
  public static void insertMember(Connection conn, MemberList memberList) throws SQLException {
      String sql = "Insert into member_list(MEMBER_NAME, GENDER,AGE,CAREER,WORKING_AT) values (?,?,?,?,?)";           
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, memberList.getMemberNamer());
      pstm.setString(2, memberList.getGender());
      pstm.setInt(3, memberList.getAge());
      pstm.setString(4, memberList.getCareer());
      pstm.setString(5, memberList.getWorkingAt()); 
      pstm.executeUpdate();
  }
 
  public static void deleteMember(Connection conn, String code) throws SQLException {
      String sql = "Delete FROM member_list where MEMBER_ID= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql); 
      pstm.setString(1, code); 
      pstm.executeUpdate();
  }
 
}
