package com.ata.member.beans;

public class MemberList {
    
    private int memberId;
    private String memberName;
    private String gender;
    private int age;
    private String career;
    private String workingAt;

    public MemberList() {

    }
    
    public MemberList(int memberId, String memberName, String gender, int age,String career,String workingAt) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.gender = gender;
        this.age = age;
        this.career = career;
        this.workingAt = workingAt;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberNamer() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
    
    public String getWorkingAt() {
        return workingAt;
    }

    public void setWorkingAt(String workingAt) {
        this.workingAt = workingAt;
    }
}
