package com.pasistence.mantrafingerprint.Models;

import java.io.Serializable;

public class WorkerModel implements Serializable {
    public String id,workerId, name, adharcardId, gender, dob, fingerprint1, fingerprint2, email, permanentAddressId, currentAddressId, contact1, contact2, salary, createdAt, updatedAt, bankId, projectId, activation, imageUrl;

    public WorkerModel() {
    }

    public WorkerModel(String workerId, String name, String adharcardId, String gender, String dob, String fingerprint1, String fingerprint2, String email, String permanentAddressId, String currentAddressId, String contact1, String contact2, String salary, String createdAt, String updatedAt, String bankId, String projectId, String activation, String imageUrl) {
        this.workerId = workerId;
        this.name = name;
        this.adharcardId = adharcardId;
        this.gender = gender;
        this.dob = dob;
        this.fingerprint1 = fingerprint1;
        this.fingerprint2 = fingerprint2;
        this.email = email;
        this.permanentAddressId = permanentAddressId;
        this.currentAddressId = currentAddressId;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.salary = salary;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.bankId = bankId;
        this.projectId = projectId;
        this.activation = activation;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "WorkerModel{" +
                "id='" + id + '\'' +
                ", workerId='" + workerId + '\'' +
                ", name='" + name + '\'' +
                ", adharcardId='" + adharcardId + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", fingerprint1='" + fingerprint1 + '\'' +
                ", fingerprint2='" + fingerprint2 + '\'' +
                ", email='" + email + '\'' +
                ", permanentAddressId='" + permanentAddressId + '\'' +
                ", currentAddressId='" + currentAddressId + '\'' +
                ", contact1='" + contact1 + '\'' +
                ", contact2='" + contact2 + '\'' +
                ", salary='" + salary + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", bankId='" + bankId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", activation='" + activation + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdharcardId() {
        return adharcardId;
    }

    public void setAdharcardId(String adharcardId) {
        this.adharcardId = adharcardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFingerprint1() {
        return fingerprint1;
    }

    public void setFingerprint1(String fingerprint1) {
        this.fingerprint1 = fingerprint1;
    }

    public String getFingerprint2() {
        return fingerprint2;
    }

    public void setFingerprint2(String fingerprint2) {
        this.fingerprint2 = fingerprint2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermanentAddressId() {
        return permanentAddressId;
    }

    public void setPermanentAddressId(String permanentAddressId) {
        this.permanentAddressId = permanentAddressId;
    }

    public String getCurrentAddressId() {
        return currentAddressId;
    }

    public void setCurrentAddressId(String currentAddressId) {
        this.currentAddressId = currentAddressId;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}