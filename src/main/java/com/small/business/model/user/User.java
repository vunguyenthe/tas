package com.small.business.model.user;

import com.small.business.model.base.BaseMessage;

public class User extends BaseMessage {

    private String name;
    private String password;
    private Long roleId;
    private String roleName;
    private Long consultantId;
    private String consultantName;
    private String email;
    private String emailPassword;
    private String stmpServer;
    private String popServer;
    private String imapServer;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public Long getRoleId() {

        return roleId;
    }

    public void setRoleId(Long roleId) {

        this.roleId = roleId;
    }

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

    public Long getConsultantId() {

        return consultantId;
    }

    public void setConsultantId(Long consultantId) {

        this.consultantId = consultantId;
    }

    public String getConsultantName() {

        return consultantName;
    }

    public void setConsultantName(String consultantName) {

        this.consultantName = consultantName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getEmailPassword() {

        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {

        this.emailPassword = emailPassword;
    }

    public String getStmpServer() {

        return stmpServer;
    }

    public void setStmpServer(String stmpServer) {

        this.stmpServer = stmpServer;
    }

    public String getPopServer() {

        return popServer;
    }

    public void setPopServer(String popServer) {

        this.popServer = popServer;
    }

    public String getImapServer() {

        return imapServer;
    }

    public void setImapServer(String imapServer) {

        this.imapServer = imapServer;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((consultantId == null) ? 0 : consultantId.hashCode());
        result = prime * result + ((consultantName == null) ? 0 : consultantName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((emailPassword == null) ? 0 : emailPassword.hashCode());
        result = prime * result + ((imapServer == null) ? 0 : imapServer.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((popServer == null) ? 0 : popServer.hashCode());
        result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
        result = prime * result + ((stmpServer == null) ? 0 : stmpServer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (consultantId == null) {
            if (other.consultantId != null)
                return false;
        } else if (!consultantId.equals(other.consultantId))
            return false;
        if (consultantName == null) {
            if (other.consultantName != null)
                return false;
        } else if (!consultantName.equals(other.consultantName))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (emailPassword == null) {
            if (other.emailPassword != null)
                return false;
        } else if (!emailPassword.equals(other.emailPassword))
            return false;
        if (imapServer == null) {
            if (other.imapServer != null)
                return false;
        } else if (!imapServer.equals(other.imapServer))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (popServer == null) {
            if (other.popServer != null)
                return false;
        } else if (!popServer.equals(other.popServer))
            return false;
        if (roleId == null) {
            if (other.roleId != null)
                return false;
        } else if (!roleId.equals(other.roleId))
            return false;
        if (roleName == null) {
            if (other.roleName != null)
                return false;
        } else if (!roleName.equals(other.roleName))
            return false;
        if (stmpServer == null) {
            if (other.stmpServer != null)
                return false;
        } else if (!stmpServer.equals(other.stmpServer))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "User [name=" + name + ", password=" + password + ", roleId=" + roleId + ", roleName=" + roleName + ", consultantId=" + consultantId + ", consultantName="
                + consultantName + ", email=" + email + ", emailPassword=" + emailPassword + ", stmpServer=" + stmpServer + ", popServer=" + popServer + ", imapServer="
                + imapServer + "]";
    }

}
